import kx.KxProject.gli
import kx.KxProject.glm
import kx.KxProject.gln
import kx.KxProject.kool
import kx.KxProject.unsigned
import kx.Lwjgl
import kx.Lwjgl.Modules.*
import kx.implementation
import kx.testImplementation

plugins {
    val build = "0.7.3+43"
    id("kx.kotlin") version build
    //    id("kx.dokka") version build
    id("kx.publish") version build
    id("kx.dynamic-align") version build
    id("kx.util") version build
}

dependencies {

    implementation(kotlin("reflect"))

    implementation(unsigned, kool, glm, gli)

    Lwjgl { implementation(jemalloc, vulkan) }

    val spirvCross = "graphics.scenery:spirvcrossj:0.6.0-1.1.106.0"
    implementation(spirvCross)
    runtimeOnly("$spirvCross:${Lwjgl.natives}")

    Lwjgl { testImplementation(glfw, opengl) }
    testImplementation("io.github.microutils:kotlin-logging:1.7.7")
    testImplementation(gln)
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