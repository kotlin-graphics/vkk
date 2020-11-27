package uno.kotlin

import gli_.has
import glm_.i
import kool.Ptr
import kool.adr
import org.lwjgl.system.Pointer
import kotlin.random.Random


val Pointer.speakable: String
    get() = formatUidDigit(adr)

val Ptr.speakable: String
    get() = formatUidDigit(this)

private val evenLetters = "bcdfghlmnprstwx"

private val oddLetters = "aeiou"
private fun formatUidDigit(n: Long, level: Int = 0): String {
    if (n != 0L) {
        val letters = if (level has 1) oddLetters else evenLetters
        val base = letters.length
        val s = formatUidDigit(n / base, level + 1)
        return s + letters[(n % base).i]
    }
    return ""
}

fun main(args: Array<String>) {

    for (i in 0..99) {
        val k = Random.nextLong(1000000, 2000000)
        println("$k, ${k.speakable}")
    }
}
