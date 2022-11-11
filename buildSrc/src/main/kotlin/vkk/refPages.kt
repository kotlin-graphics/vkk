package vkk

import org.gradle.api.file.ProjectLayout
import vkk.gen.generate
import java.io.File

val refPages = mutableMapOf<String, String>()

fun refPages(target: File, layout: ProjectLayout) {

    var page = ""
    var desc = ""
    var doc = ""

    val skip = listOf("--", ":refpage: ", "ifdef::", "endif::")

    val vkDocs = layout.buildDirectory.file("Vulkan-Docs").get().asFile

    for (file in vkDocs.resolve("chapters").listFiles { f -> f.isFile }!!) {

//        println(file)

        for (line in file.readText().lines()) {

            var line = line

            if (line.startsWith("[open,refpage='")) {

                if (page.isNotEmpty())
                    refPages[page] = desc

                page = line.substring(15).substringBefore("'")
                desc = line.substringAfter("desc='").substringBefore("'")
//                println("$page, $desc")
                //    generate(target, "vkk/Vk10.kt") {
            }

            if (skip.any { line.startsWith(it) })
                continue

            if ("sname:$page" in line)
                line = line.replace("sname:$page", "`$page`")

            if (line.startsWith("include::{generated}")) {

                val path = line.substring(21).substringBefore("[]")

                val include = vkDocs.resolve("gen/$path")

                doc += include.readText()
            }

            if ("pname:" in line) {
                val pname = line.substringAfter("pname:").substringBefore(" ")
                line = line.replace("pname:$pname", "`$pname`")
            }

            doc += line
        }
    }
}
