package vkk

import vkk.gen.generate
import java.io.File

fun enums(target: File) {

    generate(target, "vkk/enums.kt") {

        `package` = "vkk"

        +"typealias VkFlags = Int\n\n"

        for (enum in Registry.enums) {

            when {
                enum.name == "API Constants" -> {
                    +"// ${enum.comment}"
                    fun append(v: EnumClass.Value, name: String = v.name) {
                        val maybeComment = if ('~' in v.value) " // ${v.value}" else ""
                        +"const val $name: ${v.type.ktType} = ${v.value.format(v.type.ktType, v.value)}$maybeComment"
                    }
                    for (value in enum.values)
                        if (value is EnumClass.Value) {
                            if (value.alias.isNotEmpty()) {
                                val aliased = enum.values.filterIsInstance<EnumClass.Value>().first { it.name == value.alias }
                                append(aliased, value.name)
                            } else {
                                if (value.comment.isNotEmpty())
                                    docs(value.comment)
                                append(value)
                            }
                        } else // it's an EnumClass.Comment class
                            +"// ${(value as EnumClass.Comment).text}"
                }
                enum.valueName.isNotEmpty() ->
                    +"""
                        $jvmInline
                        value class ${enum.valueName}(val i: VkFlags)
                        
                        $jvmInline
                        value class ${enum.name}(val flag: ${enum.valueName}) {
                            
                            companion object {
                            }
                        }"""
                enum.type == "enum" -> {
                    fun enumInt(offset: String, ext: String = ""): String = (1_000_000_000 + (ext.ifEmpty{ "1" }.toInt() - 1) * 1_000 + offset.toInt()).toString()
                    +jvmInline
                    "value class ${enum.name} (val i: Int)" {
                        "companion object" {
                            //                        println(enum.name)
                            // we need to save them to a tmp map because some enum values might be modified afterwards,
                            // such as VK_SAMPLER_ADDRESS_MODE_MIRROR_CLAMP_TO_EDGE
                            val entries = mutableListOf<Triple<String, String, String>>()
                            for (v in enum.values)
                                if (v is EnumClass.Value) {
                                    if (v.alias.isEmpty())
                                        entries += Triple(v.value, v.name, v.comment)
                                    else {
                                        //                                    val alias = entries.first { it.second == v.alias }
                                        entries += Triple(v.alias, v.name, v.comment)
                                    }
                                }
                            // add additional entries from features
                            for (feature in Registry.features)
                                for (require in feature.requires)
                                    for (extEnum in require.interfaces.filterIsInstance<Require.Enum>())
                                        if (enum.name == extEnum.extends) {
                                            println("[${extEnum.extends}] ${extEnum.name}, ${extEnum.offset}, ${extEnum.extnumber}")
                                            // replace
                                            if (extEnum.value.isNotEmpty()) {
                                                // remove if
                                                if (entries.removeIf { it.first == extEnum.value })
                                                    println("removed ${extEnum.name}")
                                                entries += Triple(extEnum.value, extEnum.name, extEnum.comment)
                                            }
                                            // alias
                                            else if (extEnum.alias.isNotEmpty()) {
                                                //                                            val alias = entries.first { it.second == extEnum.alias }
                                                entries += Triple(extEnum.alias, extEnum.name, extEnum.comment)
                                                //                                            println("alias(${alias.second}, ${extEnum.name}, ${extEnum.comment})")
                                            } else {
//                                                println("[${extEnum.extends}] ${extEnum.name}, ${extEnum.offset}, ${extEnum.extnumber}")
                                                entries += Triple(enumInt(extEnum.offset, extEnum.extnumber), extEnum.name, extEnum.comment)
                                            }
                                        }
                            // add additional entries from extensions
//                            for (feature in Registry.extensions) {
//
//                            }
                            entries.forEach { (v, n, c) ->
                                if (c.isNotEmpty())
                                    docs(c)
                                var name = n.removeEnumPrefix(enum.name)
                                if (name.isEmpty())
                                    println("$v, $n, ${enum.name}, $c")
                                else if (name[0].isDigit())
                                    name = "`$name`"
                                +"val $name = ${enum.name}($v)"
                            }
                        }
                    }
                }
                else -> System.err.println("enum ${enum.name} doesn't end with `FlagBits`!")
            }
        }
    }
}