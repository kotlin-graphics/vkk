package vkk

import vkk.gen.generate
import vkk.gen.jvmInline
import vkk.gen.listAdoc
import java.io.File

fun baseTypes(target: File, vkDocs: File) {

    generate(target, vkDocs, "vkk/api/baseTypes.kt") {

        `package` = "vkk.api"

        val ignore = listOf("AHardwareBuffer", "ANativeWindow", "CAMetalLayer", "IOSurfaceRef", "MTLBuffer_id",
                            "MTLCommandQueue_id", "MTLDevice_id", "MTLSharedEvent_id", "MTLTexture_id", "VkBool32",
                            "VkRemoteAddressNV")
        val inlineClasses = listOf("VkDeviceAddress", "VkDeviceSize")
        val typeAlias = listOf("VkFlags" to "UInt", "VkFlags64" to "ULong", "VkSampleMask" to "UInt")
        val baseTypes = vkDocs.resolve("gen/api/basetypes")

        for (file in baseTypes.listAdoc().filter { it.nameWithoutExtension !in ignore }) {

            val name = file.nameWithoutExtension

            man(name)

            if (name in inlineClasses) {
                +"""
                    $jvmInline
                    value class $name(val ulong: ULong)
                """
            } else typeAlias.find { name == it.first }?.let { (_, type) ->
                +"""
                    typealias $name = $type
                """
            } ?: error("$name not found")
        }
    }
}