package vkk.gen

import java.io.File

val jvmInline
    get() = "@JvmInline"

fun File.listAdoc(): List<File> = listFiles()!!.filterTo(ArrayList<File>()) { it.extension == "adoc" }.sorted()

val camelRegex = "(?<=[a-zA-Z])[A-Z]".toRegex()
val snakeRegex = "_[a-zA-Z]".toRegex()

// String extensions
fun String.toSnakeCase(): String {
    var res = StringBuilder()
    var previousUpperCase = false
    //    val specials = listOf("D3D12", "Win32")
    var i = 0
    while (i in indices) {
        val c = this[i]
        //        var isSpecial = false
        if (c == 'D' && i < length - 4 && this[i + 1] == '3' && this[i + 2] == 'D' && this[i + 3] == '1' && this[i + 4] == '2') {
            i += 5
            res.append("_D3D12")
            continue
        }
        if (c == 'W' && i < length - 4 && this[i + 1] == 'i' && this[i + 2] == 'n' && this[i + 3] == '3' && this[i + 4] == '2') {
            i += 5
            res.append("_WIN32")
            continue
        }
        if (c == 'A' && i < length - 4 && this[i + 1] == 'A' && this[i + 2] == 'B' && this[i + 3] == 'B' && this[i + 4] == 'N' && this[i + 5] == 'V') {
            i += 6
            res.append("_AABB_NV")
            continue
        }
        if (c == 'I' && i < length - 4 && this[i + 1] == 'O' && this[i + 2] == 'S')
            // VkIOSSurfaceCreateInfoMVK, VK_STRUCTURE_TYPE_IOS_SURFACE_CREATE_INFO_MVK
            if (this[i + 3].isUpperCase()) {
                i += 3
                res.append("_IOS")
                continue
            }
            // VkExportMetalIOSurfaceInfoEXT, VK_STRUCTURE_TYPE_EXPORT_METAL_IO_SURFACE_INFO_EXT
            else {
                i += 2
                res.append("_IO")
                continue
            }
        when {
            c.isUpperCase() -> res.append(if (previousUpperCase) c else "_$c")
            c.isDigit() -> res.append("_$c")
            else -> res.append(c.toUpperCase())
        }
        previousUpperCase = c.isUpperCase()
        i++
    }
    return res.toString().drop(1) // leading `_`
}
//    replace(humps, "_").toUpperCase()
//private val humps = "(?<=.)(?=\\p{Upper})".toRegex()
//    camelRegex.replace(this) { "_${it.value}" }.toUpperCase()

fun String.toLowerCamelCase(): String = snakeRegex.replace(this) { it.value.replace("_", "").toUpperCase() }

fun String.toUpperCamelCase(): String = toLowerCamelCase().capitalize()