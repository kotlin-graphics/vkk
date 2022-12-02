package vkk

import vkk.gen.Generator.Experimentals.UnsignedTypes
import vkk.gen.generate
import vkk.gen.jvmInline
import vkk.gen.listAdoc
import java.io.File

val baseTypes = HashSet<String>()

fun baseTypes(target: File, vkDocs: File) {

    generate(target, vkDocs, "vkk/api/baseTypes.kt") {
        experimentals += UnsignedTypes
        `package` = "vkk.api"
        imports += listOf("kool.Ptr", "kool.unsafe", "kool.set")

        val ignore = listOf("AHardwareBuffer", "ANativeWindow", "CAMetalLayer", "IOSurfaceRef", "MTLBuffer_id",
                            "MTLCommandQueue_id", "MTLDevice_id", "MTLSharedEvent_id", "MTLTexture_id", "VkBool32",
                            "VkRemoteAddressNV")
        val inlineClasses = listOf("VkDeviceAddress", "VkDeviceSize")
        val typeAlias = listOf("VkFlags" to "UInt", "VkFlags64" to "ULong", "VkSampleMask" to "UInt")
        val baseTypesFiles = vkDocs.resolve("gen/api/basetypes")

        for (file in baseTypesFiles.listAdoc().filter { it.nameWithoutExtension !in ignore }) {

            val name = file.nameWithoutExtension

            man(name)

            if (name in inlineClasses)
                +"""
                    $jvmInline
                    value class $name(val ulong: ULong)
                """
            else typeAlias.find { name == it.first }?.let { (_, type) ->
                +"""
                    typealias $name = $type
                    
                    $jvmInline
                    value class ${name}_Array(val array: ${type}Array) {
                        constructor() : this(${type}Array(0))
                        val size: Int
                            get = array.size
                        fun isEmpty(): Boolean = array.isEmpty()
                        fun isNotEmpty(): Boolean = array.isNotEmpty()
                    }"""
            } ?: error("$name not found")

            baseTypes += name
        }
    }
}