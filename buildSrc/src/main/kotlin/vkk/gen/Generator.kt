package vkk.gen

import java.io.File
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

class Generator(val targetDir: File) {

    val builder = StringBuilder()
    var indentation = ""

    var `package` = ""
    var imports = HashSet<String>()
    val experimentals = ArrayList<Experimentals>()
    var disableNameShadowing = false
    var suppressInlineWarning = false

    fun String.indented(block: () -> Unit) {
        +this
        indent {
            block()
        }
    }

    fun String.indentAndClose(block: () -> Unit) {
        indented(block)
        when(last()) {
            '(' -> builder.insert(builder.lastIndex, ')')
            else -> +"}"
        }
    }

    fun indent(block: () -> Unit) {
        indentation += "\t"
        block()
        indentation = indentation.dropLast(1)
    }

    operator fun String.unaryPlus() {
        var aligned = ""
        var spaces = 0
        var lineStart = this[0]
        var lastC = '\u0000'
        val parenthesis = Stack<Int>()
        for (i in indices) {
            val c = this[i]
            if (i == 0 && c == '\n') continue
            if (lineStart == ' ' || lineStart == '\t')
                if (i == lastIndex)
                    break
                else {
                    lineStart = this[i + 1]
                    continue
                }
            spaces++
            if (c == '(') parenthesis += spaces
            else if (c == ')' && parenthesis.isNotEmpty()) parenthesis.pop()
            else if (c == '{') parenthesis += spaces + 1 // eg: ..{ a0, a1,\nb0, b1 ->
            aligned += c
            if (c == '\n' && i != 0 && i != lastIndex) {
                val nextC = this[i + 1]
                if ((lastC == ',' || lastC == ' ') && nextC.isLetterOrDigit()) {
                    val padding = parenthesis.lastOrNull() ?: 0
                    aligned += " ".repeat(padding)
                    spaces = padding
                    lineStart = nextC
                } else
                    spaces = 0
            }
            lastC = c
        }
        builder.appendLine(aligned.trimIndent().prependIndent(indentation))
        //        builder.appendLine(trimIndent().prependIndent(indentation))
    }

    operator fun String.invoke(block: () -> Unit) {
        +"$this {"
        indent(block)
        +"}"
    }

    operator fun StringBuilder.plusAssign(text: String) {
        appendLine(text)
    }

    operator fun String.times(i: Int) = (1..i).joinToString { this }

    fun deleteLast() = builder.deleteAt(builder.lastIndex)

    val contract = "kotlin.contracts.contract { callsInPlace(res, kotlin.contracts.InvocationKind.EXACTLY_ONCE) }"

    fun contract(name: String) = "kotlin.contracts.contract { callsInPlace($name, kotlin.contracts.InvocationKind.EXACTLY_ONCE) }"

    val newLineAligned: Unit
        get() {
            var index = builder.length
            var spaces = 0
            var foundParenthes = false
            while (true) {
                if (builder[index] == '(') {
                    foundParenthes = true
                    spaces++
                }
                if (foundParenthes && builder[index] != '\n')
                    spaces++
                index--
            }
        }

    fun write(kt: String) {
        File(targetDir, kt).apply {
            parentFile.mkdirs()
            writeText(builder.toString())
        }
    }

    var lastDoc = ""
    fun docs(docs: String) {
        lastDoc = docs
        val lines = docs.trimIndent().lines()
        if (lines.size == 1) builder.appendLine("$indentation/** ${lines[0]} */")
        else {
            builder.appendLine("$indentation/**")
            for (line in lines)
                builder.appendLine("$indentation * $line")
            builder.appendLine("$indentation */")
        }
    }

    enum class Experimentals(val subPkg: String? = null) {
        Multiplatform,
        StdlibApi,
        Contracts("contracts"),
        UnsignedTypes,
        JsExport("js"),
        PathApi("io.path"),
        Time("time"),
        TypeInference("experimental");

        val pkg: String
            get() = when (subPkg) {
                null -> "kotlin"
                else -> "kotlin.$subPkg"
            }
    }

    enum class Part { Class, TopLevel }


    // dont change order (+ and - first, then * and /). Quat operator generation relies on this
    val operators = listOf("+" to "plus", "-" to "minus", "*" to "times", "/" to "div")
}