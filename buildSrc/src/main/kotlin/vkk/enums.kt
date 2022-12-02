@file:OptIn(ExperimentalUnsignedTypes::class)

package vkk

import vkk.gen.*
import vkk.gen.Generator.Experimentals
import java.io.File

val defineEnums = mutableMapOf<String, String>()
val intEnums = HashSet<String>()
val uintBitmasks = HashSet<String>()
val ulongBitmasks = HashSet<String>()
val uintFlags = HashSet<String>()
val ulongFlags = HashSet<String>()

fun enums(target: File, vkDocs: File) {

    generate(target, vkDocs, "vkk/api/enums.kt") {
        experimentals += Experimentals.UnsignedTypes
        `package` = "vkk.api"
        imports += listOf("kool.Ptr", "kool.unsafe", "kool.set")
        suppressInlineWarning = true

        val enums = vkDocs.resolve("gen/api/enums").listAdoc().sorted().toCollection(ArrayList())
        // swap one a slot before because of interdependence
        val index = enums.indexOfFirst { it.nameWithoutExtension == "VK_MAX_GLOBAL_PRIORITY_SIZE_KHR" }
        enums.add(index - 1, enums.removeAt(index))

        for (enum in enums) {
            val name = enum.nameWithoutExtension
            when {
                //                name == "VkAccessFlagBits2" || name == "VkFormatFeatureFlagBits2"
                //                        || name == "VkMemoryDecompressionMethodFlagBitsNV" -> enum64(name, enum)
                name.startsWith("VK_") -> {

                    if (!name.endsWith("_EXTENSION_NAME") && !name.endsWith("_SPEC_VERSION")) {
                        val lines = enum.readText().lines()
                        check(lines[3] == "----" && lines[5] == "----")
                        val value = when (val v = lines[4].substringAfterLast(' ')) {
                            "(~0U)" -> "${0u.inv()}u"
                            "(~1U)" -> "${1u.inv()}u"
                            "(~2U)" -> "${2u.inv()}u"
                            "(~0ULL)" -> "${0uL.inv()}uL"
                            else -> if(v.first().isDigit()) v.toLowerCase() else v
                        }
                        // alias, ie `#define VK_LUID_SIZE_KHR                  VK_LUID_SIZE`
                        val alias = name.startsWith(value.substringBeforeLast("_KHR"))
//                        man(if (alias) value else name)
                        +"const val $name = $value"
                        defineEnums[name] = value.substringBefore("uL").substringBefore('u')
                    }
                }
                name.startsWith("Vk") -> {
                    var lines = enum.readText().lines()
                    val bitmask = "FlagBits" in name
                    val flags = name.replace("FlagBits", "Flags")
                    val x64 = lines[6] == "typedef VkFlags64 $name;"
                    if (lines.size == 9 && lines[5].startsWith("typedef Vk") && lines[5].endsWith(';')) {
                        // `typedef VkAccelerationStructureTypeKHR VkAccelerationStructureTypeNV;`
                        val (alias, aliased) = lines[5].substring(8).dropLast(1).split(' ')
                        +"typealias $aliased = $alias"
                        when {
                            bitmask && x64 -> ulongBitmasks += aliased
                            bitmask -> uintBitmasks += aliased
                            else -> intEnums += aliased
                        }
                    } else {
                        //                    val name2 = name.substringBeforeLast("KHR")
                        val inlined = when {
                            bitmask -> {
                                if (x64) ulongBitmasks += name
                                else uintBitmasks += name
                                "flags: $flags"
                            }
                            else -> {
                                intEnums += name
                                "i: Int"
                            }
                        }
                        //                        man(name)
                        +jvmInline
                        "value class $name(val $inlined)" {
                            "companion object" {
                                var prefix = name
                                if (name.endsWith("KHR")) prefix = prefix.substringBeforeLast("KHR")
                                if (name.endsWith("EXT")) prefix = prefix.substringBeforeLast("EXT")
                                if (name.endsWith("NV")) prefix = prefix.substringBeforeLast("NV")
                                prefix = prefix.replace("FlagBits", "").toSnakeCase() + '_'

                                fun String.clean(): String {
                                    var res = substringAfter(prefix)
                                    if (name.endsWith("KHR")) res = res.substringBeforeLast("_KHR")
                                    if (name.endsWith("EXT")) res = res.substringBeforeLast("_EXT")
                                    if (name.endsWith("NV")) res = res.substringBeforeLast("_NV")
                                    if (res.first().isDigit()) res = "`$res`"
                                    return res
                                }
                                //                            println(name + ',' + lines.size)
                                for (line in lines.drop(if (x64) 7 else 6).dropLast(3).filter { !it.startsWith("#ifdef ") && it != "#endif" })
                                    when {
                                        line.startsWith("  // ") -> docs(line.substring(5)) // TODO checkme
                                        else -> {
                                            if (x64 && !line.startsWith("static"))
                                                continue
                                            val (entry, _, v) = line.drop(if (x64) 14 + name.length else 4).dropLast(1).split(' ')
                                            val value = when {
                                                v.startsWith(prefix) -> v.clean()
                                                bitmask -> {
                                                    val uns = if (x64) "${v.dropLast(3)}uL" else "${v}u"
                                                    "$name($flags($uns))"
                                                }
                                                v.startsWith("VK_") -> v
                                                else -> "$name($v)"
                                            }
                                            val entryCleaned = entry.clean()
                                            //                                            println("$entry, $v, $value, $entryCleaned")
                                            refPages[name]?.xNames?.find { it.startsWith(entry) }?.let {
                                                docs(it.replace(entry, "[$entryCleaned]"))
                                            }
                                            +"val $entryCleaned: $name = $value"
                                        }
                                    }
                            }
                        }
                        val ext = when {
                            bitmask -> "flags." + if(x64) "ulong" else "uint"
                            else -> "i"
                        }
                        val arrayType = when {
                            bitmask -> if (x64) "ULongArray" else "UIntArray"
                            else -> "IntArray"
                        }
                        val array = when {
                            bitmask -> "$flags(array[index])"
                            else -> "array[index]"
                        }
                        +"""
                            $jvmInline
                            value class ${name}_Array(val array: $arrayType) {
                                constructor() : this($arrayType(0))
                                operator fun get(index: Int): $name = $name($array)
                                operator fun set(index: Int, element: $name) = array.set(index, element.$ext)
                                val size: Int 
                                    get() = array.size
                                fun isEmpty(): Boolean = array.isEmpty()
                                fun isNotEmpty(): Boolean = array.isNotEmpty()
                            }"""
//                        +"inline infix fun Ptr<UByte>.`=`($arg: $name): Unit = unsafe.set(adr, $ext)"
                    }
                }
            }
        }
    }
}

fun Generator.enum64(name: String, file: File) {
    val flags = name.replace("FlagBits", "Flags")
    man(flags)
    +"""
        $jvmInline
        value class $flags(val ulong: VkFlags64)"""

    var prefix = name.replace("FlagBits", "").toSnakeCase()
    //    if (name.endsWith("KHR")) cleaned = cleaned.substringBeforeLast("_KHR")
    //    if (name.endsWith("EXT")) cleaned = cleaned.substringBeforeLast("_EXT")
    if (prefix.endsWith("NV")) prefix = prefix.substringBeforeLast("_NV")
    //    if (cleaned.first().isDigit()) cleaned = "`$cleaned`"

    man(name)
    +jvmInline
    "value class $name(val flags: $flags)" {
        "companion object" {

            val entryIdx = 13 + name.length + 1 + prefix.length
            println(prefix)
            println("${name.length}, ${prefix.length}, $entryIdx")
            for (line in file.readText().lines().filter { it.startsWith("static") }) {
                val entry = line.substring(entryIdx).substringBefore(' ')
                val value = line.substring(entryIdx + entry.length + 3).dropLast(4)
                refPages[name]?.xNames?.find { it.startsWith(prefix + entry) }?.let {
                    docs(it.replace(prefix + entry, "[$entry]"))
                }
                +"val $entry = $name($flags(${value}uL))"
            }
        }
    }
}