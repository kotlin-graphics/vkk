package vkk

import java.io.File
import vkk.gen.generate
import vkk.gen.jvmInline
import vkk.gen.listAdoc

fun defines(target: File, vkDocs: File) {

    generate(target, vkDocs, "vkk/api/defines.kt") {

        `package` = "vkk.api"

        man("VK_MAKE_API_VERSION")
        +"""            
            $jvmInline
            value class VkApiVersion(val value: Int) {
                constructor(variant: Int, major: Int, minor: Int, patch: Int) : 
                    this(((variant.toUInt() shr 29) or (major.toUInt() shr 22) or (minor.toUInt() shr 12) or patch.toUInt()).toInt())
                val variant: Int
                    get() = (value.toUInt() shr 29).toInt()
                val major: Int
                    get() = ((value.toUInt() shr 22) and 0x7Fu).toInt()
                val minor: Int
                    get() = ((value.toUInt() shr 12) and 0x3FFu).toInt()
                val patch: Int
                    get() = (value.toUInt() and 0xFFFu).toInt()
            }
            """

        lateinit var major: String
        lateinit var minor: String
        val ignore = listOf("VK_API_VERSION", "VK_API_VERSION_MAJOR", "VK_API_VERSION_MINOR", "VK_API_VERSION_PATCH",
                            "VK_API_VERSION_VARIANT", "VK_DEFINE_HANDLE", "VK_DEFINE_NON_DISPATCHABLE_HANDLE",
                            "VK_MAKE_API_VERSION", "VK_MAKE_VERSION", "VK_NULL_HANDLE", "VK_USE_64_BIT_PTR_DEFINES",
                            "VK_VERSION_MAJOR", "VK_VERSION_MINOR", "VK_VERSION_PATCH")
        val adocs = vkDocs.resolve("gen/api/defines").listAdoc().filter { it.nameWithoutExtension !in ignore }
                .toCollection(ArrayList())
        val index = adocs.indexOfFirst { it.nameWithoutExtension == "VK_HEADER_VERSION" }
        adocs.add(0, adocs.removeAt(index))
        adocs.forEach {
            val name = it.nameWithoutExtension
            val line = it.readText().lines()[6]
            if (name.startsWith("VK_API_VERSION")) {
                check(line.startsWith("#define VK_API_VERSION_"))
                val version = line.substring(23).substringBefore(' ').split('_')
                major = version[0]
                minor = version[1]
                man(name)
                +"""val `VK_API_VERSION $major,$minor`: VkApiVersion = VkApiVersion(0, $major, $minor, 0)"""
            } else if (name == "VK_HEADER_VERSION") {
                check(line.startsWith("#define $name"))
                val version = line.substring(8 + name.length)
                man(name)
                +"const val $name: Int = $version"
            } else if (name == "VK_HEADER_VERSION_COMPLETE") {
                check(line.startsWith("#define $name"))
                man(name)
                +"val $name: VkApiVersion = VkApiVersion(0, $major, $minor, VK_HEADER_VERSION)"
            } else error("$name unexpected")
        }
    }
}