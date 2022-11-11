package vkk

import java.io.File
import vkk.gen.generate
import java.net.URL
import kotlin.collections.filterIsInstance

fun handles(target: File) {

    for (handle in Registry.types.filterIsInstance<Type.Handle>()) {

        val name = handle.name

        generate(target, "vkk/handles/$name.kt") {

            `package` = "vkk.handles"

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

            //            docs(man(name))
            if (name == "VkInstance")
                VkInstance(target)
            if (handle.dispatchable)
                "class $name" {


                }
        }
    }

//    println(URL("https://registry.khronos.org/vulkan/specs/1.3-extensions/man/html/VkAabbPositionsKHR.html").readText())
}
//
//fun man(name: String): String {
//
////    val text = URL("https://registry.khronos.org/vulkan/specs/1.3-extensions/man/html/$name.html").readText()
////
////    val desc = text.substringAfter("<p>$name - ").substringBefore("</p>")
//
//    if (name !in refPages)
//        println("$name isn't there")
//    return refPages[name] ?: ""
//
////    val spec =
//}