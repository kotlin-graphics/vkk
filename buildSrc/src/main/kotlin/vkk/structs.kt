package vkk

import java.io.File
import vkk.gen.generate
import java.net.URL
import kotlin.collections.filterIsInstance

fun structs(target: File) {

    for (struct in Registry.types.filterIsInstance<Type.Struct>()) {

        val name = struct.name

        generate(target, "vkk/structs/$name.kt") {

            `package` = "vkk.structs"

            //            suppressInlineWarning = true
            //            experimentals += Generator.Experimentals.TypeInference
            //            experimentals += Generator.Experimentals.UnsignedTypes

            imports += listOf(
                //                "kool.rem",
                //                "kool.set",
                //                "kool.iterator",
                //                "kool.lib.collectionSizeOrDefault",
                //                "kool.lib.mapCapacity",
                             )

            docs(man(name))
            "class $name" {

                for (member in struct.members) {

                    if (member.isPrimitive) {

                        +member.gen()
                    }
                }
            }
        }
    }

    println(URL("https://registry.khronos.org/vulkan/specs/1.3-extensions/man/html/VkAabbPositionsKHR.html").readText())
}

fun man(name: String): String {

    val text = URL("https://registry.khronos.org/vulkan/specs/1.3-extensions/man/html/$name.html").readText()

    val desc = text.substringAfter("<p>$name - ").substringBefore("</p>")
    return desc
//    val spec =
}