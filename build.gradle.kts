import org.gradle.api.attributes.LibraryElements.LIBRARY_ELEMENTS_ATTRIBUTE
import org.gradle.api.attributes.java.TargetJvmVersion.TARGET_JVM_VERSION_ATTRIBUTE
import org.gradle.internal.os.OperatingSystem.*
import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    java
    kotlin("jvm") version "1.3.72"
    maven
    //    id "org.jetbrains.kotlin.kapt" version "1.3.10"
    id("org.jetbrains.dokka") version "0.10.1"
    id("com.github.johnrengelman.shadow").version("5.2.0")
}

val group = "com.github.kotlin_graphics"
val moduleName = "$group.vkk"
val kotestVersion = "4.0.5"


val kx = "com.github.kotlin-graphics"
val unsignedVersion = "0af6fae4"
val koolVersion = "3962a0be"
val glmVersion = "5b0f3461"
val gliVersion = "290b4a7f"
val sprivCrossVersion = "0.6.0-1.1.106.0"
val lwjglVersion = "3.2.3"
val lwjglNatives = when (current()) {
    WINDOWS -> "windows"
    LINUX -> "linux"
    else -> "macos"
}

repositories {
    mavenCentral()
    jcenter()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))

    implementation("$kx:kotlin-unsigned:$unsignedVersion")
    implementation("$kx:kool:$koolVersion")
    implementation("$kx:glm:$glmVersion")
    implementation("$kx:gli:$gliVersion")

    // https://mvnrepository.com/artifact/com.twelvemonkeys.imageio/imageio-core
    listOf("", /*"-batik",*/ "-bmp", "-core", "-icns", "-iff", "-jpeg", "-metadata", "-pcx", "-pdf", "-pict", "-pnm",
            "-psd", "-sgi", "-tga", "-thumbsdb", "-tiff"/*, "-reference", "-clippath", "-hdr"*/).forEach {
        implementation("com.twelvemonkeys.imageio:imageio$it:3.5")
    }
    // https://mvnrepository.com/artifact/org.apache.xmlgraphics/batik-transcoder
    //implementation "org.apache.xmlgraphics:batik-transcoder:1.12"

    listOf("", "-vulkan").forEach {
        implementation("org.lwjgl:lwjgl$it:$lwjglVersion")
        if (it != "-vulkan")
            implementation("org.lwjgl:lwjgl$it:$lwjglVersion:natives-$lwjglNatives")
    }

    val spirvCross = "graphics.scenery:spirvcrossj:$sprivCrossVersion"
    implementation("$spirvCross")
    runtimeOnly("$spirvCross:natives-$lwjglNatives")

    attributesSchema.attribute(LIBRARY_ELEMENTS_ATTRIBUTE).compatibilityRules.add(ModularJarCompatibilityRule::class)
    components { withModule<ModularKotlinRule>(kotlin("stdlib")) }
    components { withModule<ModularKotlinRule>(kotlin("stdlib-jdk8")) }

    //    compile group: 'org.jetbrains.kotlin.kapt', name: 'org.jetbrains.kotlin.kapt.gradle.plugin', version: '1.3.0-rc-146'


    listOf("-glfw").forEach {
        testImplementation("org.lwjgl:lwjgl$it:$lwjglVersion")
        testRuntimeOnly("org.lwjgl:lwjgl$it:$lwjglVersion:natives-$lwjglNatives")
    }
    testImplementation("io.github.microutils:kotlin-logging:1.7.7")

    //    testImplementation "${kx}:uno-sdk:402f5f495429b7f2178a1d200c32bb5ed2f7e6fa"
    testImplementation("$kx.uno-sdk:uno-vk:55063f983dba678375a5196ec13e4d716bb474f4")

    listOf("runner-junit5", "assertions-core", "runner-console"/*, "property"*/).forEach {
        testImplementation("io.kotest:kotest-$it-jvm:$kotestVersion")
    }
}

java {
    modularity.inferModulePath.set(true)
}

tasks {
    val dokka by getting(DokkaTask::class) {
        outputFormat = "html"
        outputDirectory = "$buildDir/dokka"
    }

    compileKotlin {
        kotlinOptions {
            jvmTarget = "11"
            freeCompilerArgs = listOf("-XXLanguage:+InlineClasses", "-Xjvm-default=enable")
        }
        sourceCompatibility = "11"
    }

    compileTestKotlin {
        kotlinOptions.jvmTarget = "11"
        sourceCompatibility = "11"
    }

    compileJava {
        // this is needed because we have a separate compile step in this example with the 'module-info.java' is in 'main/java' and the Kotlin code is in 'main/kotlin'
        options.compilerArgs = listOf("--patch-module", "$moduleName=${sourceSets.main.get().output.asPath}")
    }

    withType<Test> { useJUnitPlatform() }
}

val dokkaJar by tasks.creating(Jar::class) {
    group = JavaBasePlugin.DOCUMENTATION_GROUP
    description = "Assembles Kotlin docs with Dokka"
    archiveClassifier.set("javadoc")
    from(tasks.dokka)
}

val sourceJar = task("sourceJar", Jar::class) {
    dependsOn(tasks["classes"])
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
}

artifacts {
    archives(sourceJar)
    archives(dokkaJar)
}

// == Add access to the 'modular' variant of kotlin("stdlib"): Put this into a buildSrc plugin and reuse it in all your subprojects
configurations.all {
    attributes.attribute(TARGET_JVM_VERSION_ATTRIBUTE, 11)
    val n = name.toLowerCase()
    if (n.endsWith("compileclasspath") || n.endsWith("runtimeclasspath"))
        attributes.attribute(LIBRARY_ELEMENTS_ATTRIBUTE, objects.named("modular-jar"))
    if (n.endsWith("compile") || n.endsWith("runtime"))
        isCanBeConsumed = false
}

abstract class ModularJarCompatibilityRule : AttributeCompatibilityRule<LibraryElements> {
    override fun execute(details: CompatibilityCheckDetails<LibraryElements>): Unit = details.run {
        if (producerValue?.name == LibraryElements.JAR && consumerValue?.name == "modular-jar")
            compatible()
    }
}

abstract class ModularKotlinRule : ComponentMetadataRule {

    @javax.inject.Inject
    abstract fun getObjects(): ObjectFactory

    override fun execute(ctx: ComponentMetadataContext) {
        val id = ctx.details.id
        listOf("compile", "runtime").forEach { baseVariant ->
            ctx.details.addVariant("${baseVariant}Modular", baseVariant) {
                attributes {
                    attribute(LIBRARY_ELEMENTS_ATTRIBUTE, getObjects().named("modular-jar"))
                }
                withFiles {
                    removeAllFiles()
                    addFile("${id.name}-${id.version}-modular.jar")
                }
                withDependencies {
                    clear() // 'kotlin-stdlib-common' and  'annotations' are not modules and are also not needed
                }
            }
        }
    }
}