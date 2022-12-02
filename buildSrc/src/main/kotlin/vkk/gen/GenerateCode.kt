package vkk.gen

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import java.io.File
import org.gradle.api.file.Directory
import org.gradle.api.file.ProjectLayout
import org.gradle.api.provider.Provider
import vkk.*
import vkk.handles.VkInstance
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
        get() = layout.buildDirectory.dir("generated")

    @TaskAction
    fun generate() {
        val target = targetDir.get().asFile

        val vkDocs = layout.buildDirectory.dir("Vulkan-Docs").get().asFile
//        val input = vkDocs.resolve("gen/api/basetypes")

        apiMapAndDocs(vkDocs)
        baseTypes(target, vkDocs)
        defines(target, vkDocs)
        flags(target, vkDocs)
        enums(target, vkDocs)
        handles(target, vkDocs)
        structs(target, vkDocs)
        protos(target, vkDocs)
        VkInstance(target, vkDocs)
        InstanceCapabilities(target, vkDocs)
        VkCommandBuffer(target, vkDocs)
    }
}

fun generate(targetDir: File, vkDocs: File, file: String, block: Generator.() -> Unit) {
    Generator(targetDir, vkDocs).apply {
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

