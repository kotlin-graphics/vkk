package vkk

val jvmInline
    get() = "@JvmInline"

val String.ktType
    get() = when (this) {
        "void" -> "Unit"
        "char" -> "Char"
        "float" -> "Float"
        "double" -> "Double"
        "int8_t" -> "Byte"
        "uint8_t" -> "UByte"
        "int16_t" -> "Short"
        "uint16_t" -> "UShort"
        "int32_t" -> "Int"
        "uint32_t" -> "UInt"
        "int64_t" -> "Long"
        "uint64_t" -> "ULong"
        else -> error("invalid type '$this'")
    }
val String.ktTypeDefault
    get() = when (this) {
        "float" -> "0f"
        else -> error("invalid type $this")
    }

@OptIn(ExperimentalUnsignedTypes::class)
fun String.format(type: String, value: String = ""): String {
//    println("type = '$type', value = '$value'")
    return when {
        value == "(~0U)" -> "0x" + 0u.inv().toString(16).toUpperCase() + 'u'
        value == "(~1U)" -> "0x" + 1u.inv().toString(16).toUpperCase() + 'u'
        value == "(~2U)" -> "0x" + 2u.inv().toString(16).toUpperCase() + 'u'
        value == "(~0ULL)" -> "0x" + 0uL.inv().toString(16).toUpperCase() + 'u'
        type == "UInt" -> this + 'u'
        type == "ULong" -> this + "uL"
        // 1000.0F -> 1000.0f
        type == "Float" -> when {
            endsWith(".0F", ignoreCase = true) -> substringBefore('.') + 'f'
            else -> toLowerCase()
        }
        else -> this
    }
}

fun String.removeEnumPrefix(prefix: String): String = when {
    prefix == "VkResult" -> drop(2).toLowerCase().capitalize() // ie VK_SUCCESS -> Success
    else -> {
        val underscores = prefix.count { it.isUpperCase() }
        split('_').drop(underscores).joinToString("") { it.toLowerCase().capitalize() }
    }
}