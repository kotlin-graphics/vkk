package vkk.gen

import java.io.File

val jvmInline
    get() = "@JvmInline"

fun File.listAdoc(): List<File> = listFiles()!!.filterTo(ArrayList<File>()) { it.extension == "adoc" }

val camelRegex = "(?<=[a-zA-Z])[A-Z]".toRegex()
val snakeRegex = "_[a-zA-Z]".toRegex()

// String extensions
fun String.toSnakeCase(): String {
    var res = StringBuilder()
    var previousUpperCase = false
    for (c in this) {
        when {
            c.isUpperCase() -> res.append(if (previousUpperCase) c else "_$c")
            c.isDigit() -> res.append("_$c")
            else -> res.append(c.toUpperCase())
        }
        previousUpperCase = c.isUpperCase()
    }
    return res.toString().drop(1) // leading `_`
}
//    replace(humps, "_").toUpperCase()
//private val humps = "(?<=.)(?=\\p{Upper})".toRegex()
//    camelRegex.replace(this) { "_${it.value}" }.toUpperCase()

fun String.toLowerCamelCase(): String = snakeRegex.replace(this) { it.value.replace("_", "").toUpperCase() }

fun String.toUpperCamelCase(): String = toLowerCamelCase().capitalize()