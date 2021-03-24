import kx.LwjglModules.*
import kx.KxProject.*
import kx.kxImplementation
import kx.kxTestImplementation
import kx.lwjglImplementation
import kx.lwjglTestImplementation

plugins {
    val build = "0.7.0+71"
    id("kx.kotlin.11") version build
    id("kx.lwjgl") version build
    id("kx.dokka") version build
    id("kx.publish") version build
    java
}

version = "0.3.2+35"

dependencies {

    implementation(kotlin("reflect"))

    kxImplementation(unsigned, kool, glm, gli)

    lwjglImplementation(jemalloc, vulkan)

    val spirvCross = "graphics.scenery:spirvcrossj:0.6.0-1.1.106.0"
    implementation(spirvCross)
    runtimeOnly("$spirvCross:${kx.lwjglNatives}")

    lwjglTestImplementation(glfw, opengl)
    testImplementation("io.github.microutils:kotlin-logging:1.7.7")
    kxTestImplementation(gln)
}


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