import vkk.gen.GenerateCode
import magik.createGithubPublication
import magik.github
import org.jetbrains.kotlin.gradle.dsl.KotlinCompile
import org.lwjgl.lwjgl
import org.lwjgl.lwjgl.Module.*

plugins {
    kotlin("jvm") version embeddedKotlinVersion
    id("org.lwjgl.plugin") version "0.0.29"
    id("elect86.magik") version "0.3.1"
    `maven-publish`
}

repositories {
    mavenCentral()
    github("kotlin-graphics/mary")
}

dependencies {

    implementation(kotlin("reflect"))
    implementation("kotlin.graphics:gli:0.8.3.0-18")
    implementation("kotlin.graphics:glm:0.9.9.1-5")
    implementation("kotlin.graphics:unsigned:3.3.31")
    implementation("kotlin.graphics:kool:0.9.70")

    lwjgl {
        implementation(jemalloc, vulkan)
        testImplementation(glfw, opengl)
    }

    val spirvCross = "graphics.scenery:spirvcrossj:0.6.0-1.1.106.0"
    implementation(spirvCross)
    runtimeOnly("$spirvCross:natives-${lwjgl.runningPlatform}")

    testImplementation("io.kotest:kotest-runner-junit5:5.4.1")
    testImplementation("io.kotest:kotest-assertions-core:5.4.1")
    testImplementation("kotlin.graphics:gln:0.5.31")
    testImplementation("io.github.microutils:kotlin-logging:1.7.7")
}

kotlin.jvmToolchain {
    this as JavaToolchainSpec
    languageVersion.set(JavaLanguageVersion.of(8))
}

tasks {
    withType<KotlinCompile<*>>().all {
        kotlinOptions {
            freeCompilerArgs += listOf("-opt-in=kotlin.RequiresOptIn")
        }
    }
    val generateCode by registering(GenerateCode::class)
    kotlin.sourceSets {
        main { kotlin.srcDir(generateCode) }
    }
    withType<Test>().configureEach { useJUnitPlatform() }
}

publishing {
    publications {
        createGithubPublication {
            from(components["java"])
            suppressAllPomMetadataWarnings()
        }
    }
    repositories {
        github {
            domain = "kotlin-graphics/mary"
        }
    }
}

java { withSourcesJar() }

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