rootProject.name = "vkk"

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://raw.githubusercontent.com/kotlin-graphics/mary/master")
    }
}

gradle.rootProject {
    group = "kotlin.graphics"
    version = "0.3.2+37"
}