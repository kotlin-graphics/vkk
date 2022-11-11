package vkk.gen

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import java.io.File
import org.gradle.api.file.Directory
import org.gradle.api.file.ProjectLayout
import org.gradle.api.provider.Provider
import vkk.*
import javax.inject.Inject

abstract class GenerateCode: DefaultTask() {

    init {
        group = "build"
        description = "Generate glm code"
    }

    @get:Inject
    abstract val layout: ProjectLayout

    @get:OutputDirectory
    val targetDir: Provider<Directory>
        get() = layout.buildDirectory.dir("generated/common")

    @TaskAction
    fun generate() {
        val target = targetDir.get().asFile

        val text = javaClass.getResource("/vk.xml").readText()

        parse(text)

//        refPages(target, layout)

        vk(target)

        structs(target)

        handles(target)

        enums(target)
    }
}

fun generate(targetDir: File, file: String, block: Generator.() -> Unit) {
    Generator(targetDir).apply {
        builder.append('\n')
        block()
        for (import in imports)
            builder.insert(0, "import $import\n")
        if (`package`.isNotEmpty())
            builder.insert(0, "package $`package`\n")
        if (experimentals.isNotEmpty()) {
            val list = experimentals.joinToString { "${it.pkg}.Experimental${it.name}::class" }
            builder.insert(0, "@file:OptIn($list)\n")
        }
        if (disableNameShadowing)
            builder.insert(0, "@file:Suppress(\"NAME_SHADOWING\")\n")
        if (suppressInlineWarning)
            builder.insert(0, "@file:Suppress(\"NOTHING_TO_INLINE\")\n")
        write(file)
    }
}

