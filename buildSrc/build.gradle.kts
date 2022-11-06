import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
    kotlin("plugin.serialization") version embeddedKotlinVersion
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    //    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.13.0")
    //    implementation("com.fasterxml.woodstox:woodstox-core:6.2.5")
    //    implementation("io.github.pdvrieze.xmlutil:core:0.84.3")
    implementation("io.github.pdvrieze.xmlutil:core-jvm:0.84.3")
    implementation("io.github.pdvrieze.xmlutil:serialization-jvm:0.84.3")
    //    implementation("org.jetbrains.kotlin:kotlin-serialization:$embeddedKotlinVersion")
}

//val compileKotlin: KotlinCompile by tasks
//compileKotlin.kotlinOptions {
//    languageVersion = "1.5"
//}