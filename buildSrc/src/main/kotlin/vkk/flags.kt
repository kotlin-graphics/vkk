package vkk

import vkk.gen.Generator.Experimentals
import vkk.gen.generate
import vkk.gen.jvmInline
import vkk.gen.listAdoc
import java.io.File

fun flags(target: File, vkDocs: File) {

    generate(target, vkDocs, "vkk/api/flags.kt") {

        experimentals += Experimentals.UnsignedTypes
        `package` = "vkk.api"
        imports += listOf("kool.Ptr", "kool.unsafe", "kool.set")

        val flags = vkDocs.resolve("gen/api/flags").listAdoc().sorted().toCollection(ArrayList())

        for (flag in flags) {

            val name = flag.nameWithoutExtension

            val (first, second) = flag.readText().lines()[5].drop(8).dropLast(1).split(' ')
            if (first.startsWith("VkFlags")) {
                val x64 = first.length == 9
                val value = when {
                    x64 -> {
                        ulongFlags += name
                        "ulong: VkFlags64"
                    }
                    else -> {
                        uintFlags += name
                        "uint: VkFlags"
                    }
                }
                man(second)
                +"""
                    $jvmInline
                    value class $name(val $value)
                    
                    $jvmInline
                    value class ${name}_Array(val array: ${if (x64) "ULong" else "UInt"}Array) {
                        operator fun get(index: Int): $name = $name(array[index])
                        operator fun set(index: Int, element: $name) = array.set(index, element.${if (x64) "ulong" else "uint"})
                        val size: Int
                            get() = array.size
                        fun isEmpty(): Boolean = array.isEmpty()
                        fun isNotEmpty(): Boolean = array.isNotEmpty()
                    }"""

            } else {
                man(first)
                +"typealias $second = $first"
                if (first in uintFlags)
                    uintFlags += second
                else
                    ulongFlags += second
            }
        }
    }
}