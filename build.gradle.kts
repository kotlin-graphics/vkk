import org.gradle.api.attributes.java.TargetJvmVersion.TARGET_JVM_VERSION_ATTRIBUTE
import org.gradle.internal.os.OperatingSystem.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.net.URL

plugins {
    java
    kotlin("jvm") version "1.4.10"
    `maven-publish`
    id("org.jetbrains.dokka") version "1.4.10"
    id("com.github.johnrengelman.shadow").version("6.1.0")
}

group = "com.github.kotlin_graphics"

val kotestVersion = "4.2.5"
val kx = "com.github.kotlin-graphics"
val unsignedVersion = "95391df4"
val koolVersion = "f91acd54"
val glmVersion = "127c7b85"
val gliVersion = "0c577125"
val sprivCrossVersion = "0.6.0-1.1.106.0"
val lwjglVersion = "3.2.3"
val lwjglNatives = "natives-" + when (current()) {
    WINDOWS -> "windows"
    LINUX -> "linux"
    else -> "macos"
}

repositories {
    mavenCentral()
    jcenter()
    maven("https://jitpack.io")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))

    implementation("$kx:kotlin-unsigned:$unsignedVersion")
    implementation("$kx:kool:$koolVersion")
    implementation("$kx:glm:$glmVersion")
    implementation("$kx:gli:$gliVersion")

    implementation(platform("org.lwjgl:lwjgl-bom:$lwjglVersion"))
    listOf("", "-vulkan", "-jemalloc").forEach {
        implementation("org.lwjgl", "lwjgl$it")
        if (it != "-vulkan")
            runtimeOnly("org.lwjgl", "lwjgl$it", classifier = lwjglNatives)
    }

    val spirvCross = "graphics.scenery:spirvcrossj:$sprivCrossVersion"
    implementation(spirvCross)
    runtimeOnly("$spirvCross:$lwjglNatives")

    testImplementation("io.kotest:kotest-runner-junit5-jvm:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core-jvm:$kotestVersion")

    testImplementation(platform("org.lwjgl:lwjgl-bom:$lwjglVersion"))
    testImplementation("org.lwjgl", "lwjgl-glfw")
    testRuntimeOnly("org.lwjgl", "lwjgl-glfw", classifier = lwjglNatives)

    testImplementation("io.github.microutils:kotlin-logging:1.7.7")
//    testImplementation "${kx}:uno-sdk:402f5f495429b7f2178a1d200c32bb5ed2f7e6fa"
    testImplementation("${kx}.uno-sdk:uno-vk:55063f983dba678375a5196ec13e4d716bb474f4")
}

tasks {
    dokkaHtml {
        dokkaSourceSets.configureEach {
            sourceLink {
                localDirectory.set(file("src/main/kotlin"))
                remoteUrl.set(URL("https://github.com/kotlin-graphics/vkk/tree/master/src/main/kotlin"))
                remoteLineSuffix.set("#L")
            }
        }
    }

    withType<KotlinCompile>().all {
        kotlinOptions {
            jvmTarget = "1.8"
            freeCompilerArgs += listOf("-Xinline-classes", "-Xopt-in=kotlin.RequiresOptIn")
        }
        sourceCompatibility = "1.8"
    }

    withType<Test> { useJUnitPlatform() }
}

val dokkaJavadocJar by tasks.register<Jar>("dokkaJavadocJar") {
    dependsOn(tasks.dokkaJavadoc)
    from(tasks.dokkaJavadoc.get().outputDirectory.get())
    archiveClassifier.set("javadoc")
}

val dokkaHtmlJar by tasks.register<Jar>("dokkaHtmlJar") {
    dependsOn(tasks.dokkaHtml)
    from(tasks.dokkaHtml.get().outputDirectory.get())
    archiveClassifier.set("html-doc")
}

val sourceJar = task("sourceJar", Jar::class) {
    dependsOn(tasks.classes)
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
}

artifacts {
    archives(dokkaJavadocJar)
    archives(dokkaHtmlJar)
    archives(sourceJar)
}

publishing {
    publications.create<MavenPublication>("mavenJava") {
        from(components["java"])
        artifact(sourceJar)
    }
    repositories.maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/kotlin-graphics/vkk")
        credentials {
            username = System.getenv("GITHUB_ACTOR")
            password = System.getenv("GITHUB_TOKEN")
        }
    }
}

// == Add access to the 'modular' variant of kotlin("stdlib"): Put this into a buildSrc plugin and reuse it in all your subprojects
configurations.all { attributes.attribute(TARGET_JVM_VERSION_ATTRIBUTE, 8) }

//jar {
//    inputs.property("moduleName", moduleName)
////    manifest.attributes('Automatic-Module-Name': moduleName)
//    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
//}

//test {
//    useJUnitPlatform()
//
//    testLogging {
//        // Make sure output from
//        // standard out or error is shown
//        // in Gradle output.
////        showStandardStreams = true
//
//        // Or we use events method:
//        // events 'standard_out', 'standard_error'
//
//        // Or set property events:
//        // events = ['standard_out', 'standard_error']
//
//        // Instead of string values we can
//        // use enum values:
//        // events org.gradle.api.tasks.testing.logging.TestLogEvent.STANDARD_OUT,
//        //        org.gradle.api.tasks.testing.logging.TestLogEvent.STANDARD_ERROR,
//    }
//}