package vkk

import kotlin.reflect.KProperty

lateinit var xml: String
var index = 0
lateinit var lines: List<String>
val line: String
    get() = lines[index].trim()
val type: List<String>
    get() = getElement("type")
val enums: List<String>
    get() = getElement("enums")
val command: List<String>
    get() = getElement("command")
val require: List<String>
    get() = getElement("require")

fun getElement(element: String): List<String> {
    require(line.startsWith("<$element")) { "$line\n$element" }
    val res = ArrayList<String>()
    while (true) {
        res += line
        if (line.startsWith("<$element") && line.endsWith("/>"))
            break
        if (line.endsWith("</$element>"))
            break
        nextLine()
    }
    return res
}

fun List<String>.trimElement() {
    this as ArrayList
    set(0, first().substringAfter('>'))
    set(lastIndex, last().substringBeforeLast('<'))
}

operator fun String.get(attribute: String): String? = when {
    " $attribute=" in this -> substringAfter(" $attribute=\"").substringBefore('"')
    else -> null
}

val String.category: Type.Category?
    get() = this["category"]?.let { Type.Category.valueOf(it) }
val String.requires: String?
    get() = this["requires"]

fun nextLine() {
    index++
}

fun parse(text: String) {
    lines = text.lines().filter { it.isNotEmpty() }
    while (index in lines.indices) {

        if (line.startsWith("<platforms")) {
            nextLine()
            while (line.startsWith("<platform")) {
                Registry.platforms += Platform(line)
                nextLine()
            }
        }
        if (line.startsWith("<tags")) {
            nextLine()
            while (line.startsWith("<tag")) {
                Registry.tags += Tag(line)
                nextLine()
            }
        }
        if (line.startsWith("<types ")) {
            nextLine()
            while (!line.startsWith("</types>")) {
                val category = line.category
                if (category == null) {

                } else when (category) {
                    Type.Category.define -> {
                        val element = type
                        val requires by element[0]
                        element.trimElement()
                        val comment = element[0].substringAfter("// ", "")
                        if ("DEPRECATED" !in comment) {
                            if (requires == "VK_MAKE_API_VERSION")
                                Registry.types += Type.ApiVersion(element[1], comment)
                            else {
                                val name by element.getOrElse(1) { "" }
                                if (name == "VK_HEADER_VERSION")
                                    Registry.types += Type.HeaderVersion(element[1], comment)
                            }
                        }
                    }
                    Type.Category.bitmask -> line.requires?.let { Registry.types += Type.Bitmask(line) }
                    Type.Category.handle -> Registry.types += Type.Handle(line)
                    Type.Category.enum -> Registry.types += Type.Enum(line)
                    Type.Category.funcpointer -> Registry.types += Type.FuncPointer(type.apply { trimElement() })
                    Type.Category.struct -> Registry.types += Type.Struct(type)
                    Type.Category.union -> Registry.types += Type.Union(type)
                    else -> {}
                }
                nextLine()
            }
        }
        if (line.startsWith("<enums"))
            Registry.enums += EnumClass(enums)
        if (line.startsWith("<commands")) {
            nextLine()
            while (line != "</commands>") {
                Registry.commands += if ("alias" in line) CommandAlias(command) else Command(command)
                nextLine()
            }
        }
        if (line.startsWith("<feature"))
            Registry.features += Feature(line)
        if (line.startsWith("<extensions")) {
            nextLine()
            while (line.startsWith("<extension"))
                Registry.extensions += Extension(line)
        }
        nextLine()
    }
    println()
}

private operator fun String.getValue(any: Any?, property: KProperty<*>): String {
    val name = property.name
    val attr = " $name=\""
    return when {
        attr in this -> substringAfter(attr).substringBefore('"')
        "<$name>" in this -> substringAfter("<$name>").substringBefore('<')
        else -> ""
    }
}

private operator fun List<String>.getValue(any: Any?, property: KProperty<*>): String {
    val name = property.name
    val attr = " $name=\""
    val elem = "<$name>"
    return find { attr in it }?.let { it.substringAfter(attr).substringBefore('"') }
        ?: find { elem in it }?.let { it.substringAfter(elem).substringBefore('<') }
        ?: ""
}

object Registry {
    val platforms = ArrayList<Platform>()
    val tags = ArrayList<Tag>()
    val types = ArrayList<Type>()
    val enums = ArrayList<EnumClass>()
    val commands = ArrayList<CommandBase>()
    val features = ArrayList<Feature>()
    val extensions = ArrayList<Extension>()
}

class Platform(line: String) {
    val name by line
    val protect by line
    val comment by line
}

class Tag(line: String) {
    val name by line
    val author by line
    val contact by line
}

sealed class Type(line: String, val commentProvide: () -> String = { line }) {

    val name by line
    val requires by line
    val alias by line
    val comment
        get() = commentProvide()

    enum class Category { define, bitmask, include, basetype, handle, enum, funcpointer, struct, union }

    class ApiVersion(line: String, comment: String) : Type(line, { comment }) {
        val variant: String
        val major: String
        val minor: String

        init {
            val split = name.substringAfter("VK_API_VERSION_").split('_')
            var i = 0
            variant = if (split.size == 3) split[i++] else "0"
            major = split[i++]
            minor = split[i]
        }
    }

    class HeaderVersion(line: String, comment: String) : Type(line, { comment }) {
        val version = line.substringBefore("</type>").substringAfterLast('>').trim()
    }

    class Bitmask(line: String) : Type(line)

    class Handle(line: String) : Type(line) {
        val type by line
        val parent by line
        val objtypeenum by line

        val dispatchable
            get() = type == "VK_DEFINE_HANDLE"
    }

    class Enum(line: String) : Type(line)

    class FuncPointer(element: List<String>) : Type(element.first()) {
        val signature: String
        val args = mutableMapOf<String, String>()

        init {
            signature = element.first().clean()
            for (line in element.drop(1).map { it.clean() }) {
                val split = line.split(Regex("\\s+"))
                args[split[0]] = split[1].substringBefore(',').substringBefore(");")
            }
        }
    }

    class Struct(element: List<String>) : Type(element.first(), { element.first() }) {
        val returnedonly by element.first()
        val structextends by element.first()
        val allowduplicate by element.first()
        val members = ArrayList<Member>()

        init {
            for (line in element.map { it.clean() }.filter { it.isNotEmpty() })
                members += Member(line)
        }
    }

    class Union(element: List<String>) : Type(element.first()) {
        val returnedonly by element.first()
        val structextends by element.first()
        val members = ArrayList<Member>()

        init {
            for (line in element.map { it.clean() }.filter { it.isNotEmpty() })
                members += Member(line)
        }
    }

    class Member(line: String) {
        val api by line
        val values by line
        val len by line
        val altlen by line
        val externsync by line
        val optional by line
        val selector by line
        val selection by line
        val noautovalidity by line
        val limittype by line
        val objecttype by line
        val stride by line
        val comment = line.substringAfter("<comment>", "").substringBefore("</comment>", "")
        val type: String
        val name: String

        fun gen(): String {
            return if (isPrimitive)
                "var $name: ${type.ktType} = ${type.ktTypeDefault}"
            else error("")
        }

        val isPrimitive
            get() = when (type) {
                "float" -> true
                else -> false
            }

        init {
            val pure = if (comment.isNotEmpty()) line.substringBefore(comment) else line
            name = pure.substringAfterLast(" ")
            type = pure.substringBefore(name).trim()
        }
    }
}

fun String.clean(): String {
    var line = this
    while ('<' in line)
        line = line.substringBefore('<') + line.substringAfter('>')
    return line
}

class EnumClass(element: List<String>) {
    val name by element.first()
    val valueName: String
        get() = when {
            name.endsWith("FlagBits") -> name.substringBefore("Bits") + 's'
            else -> ""
        }
    val type by element.first()

    // todo `start,end`, are they together or separated?
    val vendor by element.first()
    val comment by element.first()
    val bitwidth by element.first()

    val values = ArrayList<ValueInterface>()

    init {
        var comment: String? = null
        for (line in element.drop(1).dropLast(1))
            when {
                line.startsWith("<comment>") ->
                    if (line.endsWith("</comment>"))
                        values += Comment(line.drop(9).dropLast(10))
                    else
                        comment = ""
                comment != null -> comment += line
                line == "</comment>" -> {
                    values += Comment(comment!!)
                    comment = null
                }
                line.startsWith("<enum") -> values += Value(line)
            }
    }

    interface ValueInterface

    class Value(line: String) : ValueInterface {
        val value by line
        val bitpos by line
        val name by line
        val api by line
        val type by line
        val alias by line
        val protect by line
        val comment by line
    }

    class Comment(val text: String) : ValueInterface
}

abstract class CommandBase(element: List<String>) {
    val api by element
}

class Command(element: List<String>) : CommandBase(element) {
    val tasks by element.first()
    val queues by element.first()
    val successcodes by element.first()
    val errorcodes by element.first()
    val renderpass by element.first()
    val videocoding by element.first()
    val cmdbufferlevel by element.first()
    val comment by element.first()

    val proto = element[1].clean()
    val params = ArrayList<Param>()

    init {
        for (line in element.drop(2).dropLast(1))
            params += Param(line)
    }

    class Param(line: String) {
        val api by line
        val len by line
        val altlen by line
        val optional by line
        val selector by line
        val noautovalidity by line
        val externsync by line
        val objecttype by line
        val validstructs by line

        val type: String
        val name: String

        init {
            name = line.substringAfterLast(" ")
            type = line.substringBefore(name).trim()
        }
    }
}

class CommandAlias(element: List<String>) : CommandBase(element) {
    val name by element.first()
    val alias by element.first()
}

class Feature(line: String) {
    val api by line
    val name by line
    val number by line
    val sortorder by line
    val protect by line
    val comment by line

    val requires = ArrayList<Require>()

    init {
        nextLine()
        while (vkk.line != "</feature>") {
            requires += Require(require)
            nextLine()
        }
    }
}

class Require(element: List<String>) {
    val profile by element.first()
    val comment by element.first()
    val api by element.first()
    val extension by element.first()
    val feature by element.first()

    val interfaces = ArrayList<Interface>()

    init {
        for (line in element.drop(1).dropLast(1)) {
            val kind = line.drop(1).split(Regex("\\s+")).first()
            interfaces += when (kind) {
                "command" -> Command(line)
                "enum" -> Enum(line)
                else -> {
                    check(kind == "type")
                    Type(line)
                }
            }
        }
    }

    abstract class Interface(val line: String) {
        val name by line
        val comment by line
    }

    class Command(line: String) : Interface(line)
    class Enum(line: String) : Interface(line) {
        val api by line

        // Reference enums
        // Extension enums
        val value by line
        val type by line
        val bitpos by line
        val extends by line
        val extnumber by line
        val offset by line
        val dir by line
        val alias by line
        val protect by line
    }

    class Type(line: String) : Interface(line)
}

class Extension(line: String) {
    val name by line
    val number by line
    val sortorder by line
    val author by line
    val contact by line
    val type by line
    val requires by line
    val requiresCore by line
    val protect by line
    val platform by line
    val supported by line
    val promotedto by line
    val deprecatedby by line
    val obsoletedby by line
    val provisional by line
    val specialuse by line
    val comment by line

    val require = ArrayList<Require>()

    init {
        nextLine()
        while (line.startsWith("<require"))
            require += Require(vkk.require)
        println(vkk.line)
        error("")
    }
}