//import kx.LwjglModules.*/
//import kx.KxProject.*
//import kx.kxImplementation
//import kx.kxTestImplementation
//import kx.lwjglImplementation
//import kx.lwjglTestImplementation
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    val build = "0.7.0+79"
    //    id("kx.kotlin.11") version build
//    id("kx.lwjgl") version build
    //    id("kx.dokka") version build
//    id("kx.publish") version build
    //    id("kx.util") version build
//    java
    `java-library`
    kotlin("jvm") version "1.4.30"
    application
    idea
}

version = "0.3.2+36"

repositories {
    mavenCentral()
    maven("https://raw.githubusercontent.com/kotlin-graphics/mary/master")
}

dependencies {

    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))

    //    kxImplementation(unsigned, kool, glm, gli)
    implementation("kotlin.graphics:unsigned:3.2.9+31")
    implementation("kotlin.graphics:kool:0.9.0+23")
    implementation("kotlin.graphics:glm:0.9.9.1-3+23")
    implementation("kotlin.graphics:gli:0.8.3.0-16+22")

    implementation("org.lwjgl:lwjgl:3.2.3")
    runtimeOnly("org.lwjgl", "lwjgl", "3.2.3", classifier = "natives-linux")
    implementation("org.lwjgl:lwjgl-jemalloc:3.2.3")
    runtimeOnly("org.lwjgl", "lwjgl-jemalloc", "3.2.3", classifier = "natives-linux")
    implementation("org.lwjgl:lwjgl-vulkan:3.2.3")
    //    lwjglImplementation(jemalloc, vulkan)

    val spirvCross = "graphics.scenery:spirvcrossj:0.6.0-1.1.106.0"
    implementation(spirvCross)
    //    runtimeOnly("$spirvCross:${kx.lwjglNatives}")
    runtimeOnly("$spirvCross:natives-linux")

    testImplementation("org.lwjgl:lwjgl-glfw:3.2.3")
    runtimeOnly("org.lwjgl", "lwjgl-glfw", "3.2.3", classifier = "natives-linux")
    testImplementation("org.lwjgl:lwjgl-opengl:3.2.3")
    runtimeOnly("org.lwjgl", "lwjgl-opengl", "3.2.3", classifier = "natives-linux")
    //    lwjglTestImplementation(glfw, opengl)
    testImplementation("io.github.microutils:kotlin-logging:1.7.7")

    testImplementation("kotlin.graphics:gln:0.5.2+22")
    //    kxTestImplementation(gln)

    testImplementation("io.kotest:kotest-runner-junit5:4.4.1")
    testImplementation("io.kotest:kotest-assertions-core:4.4.1")
}

java { modularity.inferModulePath.set(true) }

tasks {

    withType<KotlinCompile>().all {
        kotlinOptions.jvmTarget = "11"
        sourceCompatibility = "11"
    }

    // this is needed because we have a separate compile step in this example with the 'module-info.java' is in 'main/java' and the Kotlin code is in 'main/kotlin'
    val module = "vkk" // uno-
    compileJava {
        inputs.property("moduleName", module)
        options.compilerArgs = listOf(
            "--module-path", classpath.asPath,
//            "--module-path", "${classpath.asPath}:/home/elect/IdeaProjects/vkk/build/libs/vkk-0.3.2+36.jar",
//            "--add-modules", module,
            "--patch-module", "$module=${sourceSets.main.get().output.asPath}")
        println(options.compilerArgs)
    }
}

application {
    mainClass.set("vkk.VkKt")
}


// == Add access to the 'modular' variant of kotlin("stdlib"): Put this into a buildSrc plugin and reuse it in all your subprojects
configurations.all { attributes.attribute(TargetJvmVersion.TARGET_JVM_VERSION_ATTRIBUTE, 11) }




//test {
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