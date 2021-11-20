import kx.*
import org.lwjgl.Lwjgl
import org.lwjgl.Lwjgl.Module.*

plugins {
    fun kx(vararg p: Pair<String, String>) = p.forEach { id("io.github.kotlin-graphics.${it.first}") version it.second }
    kx("align" to "0.0.7",
       "base" to "0.0.10",
       "publish" to "0.0.6",
       "utils" to "0.0.5")
    id("org.lwjgl.plugin") version "0.0.20"
}

dependencies {

    implementation(kotlin("reflect"))

    implementation(unsigned, kool, glm, gli)

    Lwjgl { implementation(jemalloc, vulkan) }

    val spirvCross = "graphics.scenery:spirvcrossj:0.6.0-1.1.106.0"
    implementation(spirvCross)
    runtimeOnly("$spirvCross:${Lwjgl.native}")

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