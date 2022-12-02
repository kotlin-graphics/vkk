@file:OptIn(ExperimentalUnsignedTypes::class)

package vkk

import org.gradle.nativeplatform.platform.internal.DefaultNativePlatform.getCurrentOperatingSystem
import vkk.gen.Generator
import vkk.gen.toSnakeCase
import kotlin.math.max
import kotlin.math.min

val structs = mutableMapOf<String, Struct>()
val aliasStructs = mutableMapOf<String, String>()
val specialsType = mapOf("VkApplicationInfo" to ("apiVersion" to "VkApiVersion"))
val longOsStructures = listOf("Display", "LPCWSTR", "HANDLE", "HINSTANCE", "HWND", "Wl_display", "Wl_surface", "Window",
                              "CAMetalLayer", "MTLBuffer_id", "MTLCommandQueue_id", "MTLDevice_id", "MTLSharedEvent_id", "MTLTexture_id", "IOSurfaceRef")
val intOsStructures = listOf("DWORD")

class Struct(val handleName: String, val aliasOf: String) {

    //    var alias = ""
    val members = ArrayList<Member>()
    var sType = false

    val DEFAULT_PACK_ALIGNMENT = if (getCurrentOperatingSystem().isWindows) 8 else 0x4000_0000
    var size = 0
    var alignment = 0

    fun init() {
        if (aliasOf.isNotEmpty() || size > 0)
            return
        var bitfield = 0
        for (member in members) {
            member.init()
            if (member.bitfield.isNotEmpty())
                bitfield += member.bitfield.toInt()
            if (bitfield == 0 || bitfield == Int.SIZE_BITS) {
                bitfield = 0
                val memberAlignment = member.getAlignment()
                member.offset = size align memberAlignment
                size = member.offset + member.size
                alignment = max(alignment, memberAlignment)
            }
        }
    }

    inner class Member(name: String, type: String, val len: String, val optional: Boolean) {
        val nType = when {
            type.startsWith("struct ") -> type.substring(7)
            else -> type
        }
        var offset = 0
        val isPrimitive
            get() = when (nType) {
                "int", "int8_t", "int16_t", "int32_t", "int64_t", "uint8_t", "uint16_t", "uint32_t", "uint64_t",
                "float", "double", "VkBool32", "size_t" -> true
                else -> false
            }
        var size = 0
        var alignment = 0
        val bitfield = name.substringAfter(':', "")
        val nName = name.substringBefore(':')

        var isCount = false
        val isArray
            // skip arrays of chars and pointers to arrays of chars
            get() = len.isNotEmpty() && len != "null-terminated" && !len.endsWith(",null-terminated")

        /*
            `in` and not `==` to detect also cases such as
            <member><type>size_t</type>                 <name>codeSize</name><comment>Specified in bytes</comment></member>
            <member len="latexmath:[\textrm{codeSize} \over 4]" altlen="codeSize / 4">const <type>uint32_t</type>*            <name>pCode</name><comment>Binary code of size codeSize</comment></member>
         */
        val countMember = members.find { it.nName in len }?.apply { isCount = true }

        // we need lazy because the `len` member comes always first than the array in the arg list
        val arrayMembers by lazy { members.filter { it.nName in len } }
        var skip = deprecated[handleName]?.contains(nName) == true ||
                //VkAccelerationStructureBuildGeometryInfoKHR::ppGeometries
                (len.endsWith(",1") && !optional && name.startsWith("pp") && name[2].isUpperCase())

        fun init() {
            val nSize = nType.nSize
            size = nSize * nName.arraySize()
            alignment = nSize
        }

        fun String.arraySize(): Int {
            val size = substringAfter('[', "").substringBefore(']')
            return when {
                size.isEmpty() -> 1
                size in defineEnums -> defineEnums[size]!!.toInt() //.also { println("[$handleName], $this::arraySize: $size * $it") }
                else -> size.toInt() * substringAfter("[$size]").arraySize() //.also { println("[$handleName], $this::arraySize: $size * $it") }
            }
        }

        fun getAlignment(packAlignment: Int = DEFAULT_PACK_ALIGNMENT) = min(alignment, packAlignment)

        val ktType: String
            get() = when {
                // useless since skipped automatically because of *Count
                //                "Semaphore" in nName && nType == "const uint64_t*" -> "VkSemaphore_Array"
                specialsType[handleName]?.first == ktName -> specialsType[handleName]!!.second
                nType == "int8_t" -> "Byte"
                nType == "int16_t" -> "Short"
                nType == "int32_t" -> "Int"
                nType == "int64_t" -> "Long"
                nType == "uint8_t" -> "UByte"
                nType == "uint16_t" -> "UShort"
                nType == "uint32_t" -> "UInt"
                nType == "uint64_t" -> "ULong"
                nType == "VkBool32" -> "Boolean"
                nType == "const uint8_t*" -> "UByteBuffer"
                //                nType == "const char*" -> "String"
                (nType == "void*" || nType == "const void*") && isArray -> "UByteBuffer"
                nType.isOpaquePointer -> "Ptr<*>"
                nType == "size_t" -> "ULong"
                nType == "LPCWSTR" -> "String"
                nType.isPointer -> {
                    if (nType == "const char*")
                        "String"
                    else {
                        val type = when {
                            nType.startsWith("const ") -> nType.substring(6)
                            else -> nType
                        }.dropLast(1)
                        when {
                            type in structs || type in dispHandles -> when {
                                isArray -> "List<$type>"
                                optional -> "$type?"
                                else -> "$type"
                            }
                            type in uintFlags || type in intEnums || type in uintBitmasks || type in ulongBitmasks || type in nonDispHandles -> "${type}_Array"
                            type == "int32_t" -> "IntArray"
                            type == "uint32_t" -> "UIntArray"
                            "Semaphore" in nName && type == "uint64_t" -> "VkSemaphore_Array"
                            type == "uint64_t" -> "ULongArray"
                            type == "float" -> "FloatArray"
                            type == "char* const" -> "List<String>"
                            intOsStructures.any { it.equals(type, true) } || longOsStructures.any { it.equals(type, true) } -> type
                            type == "SECURITY_ATTRIBUTES" -> "Ptr<*>"
                            isArray -> when {
                                type in baseTypes -> "${type}Array"
                                //                                type in structs -> "List<$type>"
                                else -> error("$handleName $nType")
                            }
                            else -> TODO("$handleName $nType")
                        }
                    }
                }
                nType == "char" && '[' in nName -> "String"
                else -> nType.capitalize()
            } + when {
                nType != "char" && '[' in nName -> "Array"
                else -> ""
            }

        val ktTypeDefault: String
            get() = when {
                nType in uintBitmasks -> " = $nType(${nType.substringBeforeLast("Bits") + 's' + nType.substringAfterLast("Bits")}(0u))"
                nType in uintFlags -> " = $nType(0u)"
                nType in nonDispHandles || nType in baseTypes || nType in ulongFlags -> " = $nType(0uL)"
                nType == "uint32_t" -> " = 0u"
                nType == "size_t" -> " = 0uL"
                nType == "const char*" -> " = \"\""
                nType.isPointer -> {
                    val type = when {
                        nType.startsWith("const ") -> nType.substring(6)
                        else -> nType
                    }.dropLast(1)
                    when {
                        type in structs -> when {
                            isArray -> " = emptyList()"
                            else -> " = null"
                        }
                        type in nonDispHandles || type in intEnums -> " = ${type}_Array()"
                        //                        type in intOsStructures -> error(" = ${type}()")
                        type in baseTypes -> " = ${type}()"
                        type in longOsStructures || type in intOsStructures -> " = $type()"
                        ktType == "Ptr<*>" -> " = Ptr.NULL"
                        type == "uint64_t" -> if ("Semaphore" in nName) " = VkSemaphore_Array()" else " = ULongArray(0)"
                        else -> TODO("$handleName $nType")
                    }
                }
                nType in intOsStructures || nType in longOsStructures -> " = $nType()"
                else -> error("[${handleName}] $nType $nName is flagged as optional, but it fell through")
            }

        val ktName: String
            get() = when {
                '[' in nName -> nName.substringBefore('[')
                nName == "object" -> "`object`"
                nName[0] == 'p' && nName[1].isUpperCase() -> nName.drop(1).decapitalize()
                nName[0] == 'p' && nName[1] == 'p' && nName[2].isUpperCase() -> nName.drop(2).decapitalize()
                else -> nName
            }
    }

    private infix fun Int.align(alignment: Int) = (this - 1 or alignment - 1) + 1

    fun Generator.write() {

        //        man(handleName)
        if (aliasOf.isNotEmpty()) {
            +"typealias $handleName = $aliasOf"
            return
        }
        var idx = 0
        val args = ArrayList<String>()
        while (idx in members.indices) {

            val member = members[idx]

            if (member.skip) {
                idx++
                continue
            }
            if (member.nName != "sType" && member.nName != "pNext")
                if (!member.isCount)
                    args += "var ${member.ktName}: ${member.ktType}" + if (member.optional) member.ktTypeDefault else ""
            if (member.ktType in longOsStructures || member.ktType in intOsStructures)
                imports += "vkk.${member.ktType}"
            idx++
        }

        // tail padding
        size = size align alignment

        when {
            handleName in specialStructs -> +specialStructs[handleName]!!
            else -> {
                var maybeInterface = ""
                var isInterface = false
                for ((`interface`, extended) in interfaces) {
                    if (handleName in extended)
                        maybeInterface = ": $`interface`"
                    else if (`interface` == handleName)
                        isInterface = true
                }
                val maybeOverride = when {
                    maybeInterface.isNotEmpty() -> "override "
                    else -> ""
                }
                if (isInterface) {
                    "interface $handleName" {
                        "companion object" {
                            +"""
                                val BYTES: UInt = ${size}u
                                val ALIGN: UInt = ${alignment}u"""
                        }
                    }
                } else {
                    "class $handleName(${args.joinToString(",\n")})$maybeInterface" {

                        +"${maybeOverride}infix fun into(stack: MemStack): Ptr<UByte> = stack.calloc(ALIGN, BYTES).also { into(it, stack) }"
                        "${maybeOverride}fun into(ptr: Ptr<UByte>, stack: MemStack)" {
                            var bitfield = ""
                            for (member in members) {
                                when {
                                    member.bitfield == "24" -> bitfield = "(${member.nName} shl 8)"
                                    member.bitfield == "8" -> {
                                        check(bitfield.isNotEmpty())
                                        val second = when {
                                            "Flags" in member.nType -> member.nName + ".uint"
                                            else -> member.nName
                                        }
                                        +"(ptr + ${member.offset}) `=` ($bitfield or ($second and 0xFu))"
                                        bitfield = ""
                                    }
                                    member.skip || member.nName == "pNext" -> Unit // skip
                                    member.isCount -> {} // skip
                                    member.isArray -> {
                                        val countMember = member.countMember
                                        if (countMember != null) {
                                            val maybeArray = when {
                                                member.nType.pointerNType in uintFlags || member.nType.pointerNType in ulongBitmasks
                                                        || member.nType.pointerNType in uintBitmasks -> ".array"
                                                else -> ""
                                            }
                                            //                                            val countOrBytes = when {
                                            //                                                member.ktType == "UIntArray"
                                            //                                            }
                                            val remOrSize = when (member.ktType) {
                                                "UByteBuffer" -> "rem"
                                                else -> "size"
                                            }
                                            +"""
                                                if (${member.ktName}.isNotEmpty()) {
                                                    (ptr + ${countMember.offset}) `=` ${member.ktName}.$remOrSize
                                                    (ptr + ${member.offset}) `=` ${member.ktName}$maybeArray.into(stack)
                                                } """
                                        } else if (member.len == "latexmath:[2 \\times \\mathtt{VK\\_UUID\\_SIZE}]")
                                            +"(ptr + ${member.offset}) `=` ${member.ktName}.into(stack)"
                                        else error("[$handleName] `${member.nName}` not processed")
                                    }
                                    member.isPrimitive -> {
                                        if (member.offset == 0) {
                                            check(!sType) { "$handleName shouldn't have any `sType`" }
                                            +"ptr `=` ${member.ktName}"
                                        } else
                                            +"(ptr + ${member.offset}) `=` ${member.ktName}"
                                    }
                                    member.nName == "sType" -> {
                                        check(member.offset == 0) { "sType not at offset 0" }
                                        +"ptr `=` sType.i"
                                    }
                                    member.nType in uintBitmasks -> +"(ptr + ${member.offset}) `=` ${member.nName}.flags.uint"
                                    member.nType in baseTypes -> +"(ptr + ${member.offset}) `=` ${member.nName}.ulong"
                                    member.nType == "const char*" -> when {
                                        member.optional -> +"""
                                            if (${member.ktName}.isNotEmpty())
                                                (ptr + ${member.offset}) `=` ${member.ktName}.utf8Into(stack)"""
                                        else -> +"(ptr + ${member.offset}) `=` ${member.ktName}.utf8Into(stack)"
                                    }
                                    member.nType.isOpaquePointer -> when {
                                        member.optional -> +"""
                                            if (${member.ktName}.isValid)
                                                (ptr + ${member.offset}) `=` ${member.ktName}"""
                                        else -> +"(ptr + ${member.offset}) `=` ${member.ktName}"
                                    }
                                    member.nType.isOpaquePointer -> +"(ptr + ${member.offset}) `=` ${member.nName}"
                                    member.nType == "LPCWSTR" -> +"(ptr + ${member.offset}) `=` ${member.nName}.utf8Into(stack)"
                                    member.nType.isPointer -> when {
                                        member.ktType == "UByteBuffer" -> +"(ptr + ${member.offset}) `=` ${member.ktName}.into(stack)"
                                        member.ktType == "String" -> TODO()
                                        member.ktType == "List<String>" -> +"(ptr + ${member.offset}) `=` ${member.ktName}.utf8Into(stack)"
                                        member.optional -> when {
                                            member.ktType in longOsStructures -> TODO()
                                            //                                                +"""
                                            //                                                if (${member.ktName}.L != 0)
                                            //
                                            //                                            """.trimIndent()
                                            member.nType.pointerNType == "SECURITY_ATTRIBUTES" -> +"""
                                                if (${member.ktName}.isValid)
                                                    (ptr + ${member.offset}) `=` ${member.ktName}
                                            """
                                            else -> +"${member.ktName}?.into(ptr + ${member.offset}, stack)"
                                        }
                                        else -> +"${member.ktName}.into(ptr + ${member.offset}, stack)"
                                    }
                                    // pointer case handled just above, here it's pre-allocated in the struct
                                    member.ktType == "String" -> +"(ptr + ${member.offset}) `=` ${member.ktName}"
                                    member.nType in uintFlags -> +"(ptr + ${member.offset}) `=` ${member.nName}.uint"
                                    member.nType in ulongFlags || member.nType in nonDispHandles -> +"(ptr + ${member.offset}) `=` ${member.nName}.ulong"
                                    member.nType in structs -> when {
                                        member.optional -> TODO()
                                        else -> +"${member.nName}.into(ptr + ${member.offset}, stack)"
                                    }
                                    member.nType in intEnums || member.nType in intOsStructures -> +"(ptr + ${member.offset}) `=` ${member.ktName}.i"
                                    member.nType in dispHandles -> +"(ptr + ${member.offset}) `=` ${member.ktName}.handle"
                                    member.nType in longOsStructures -> +"(ptr + ${member.offset}) `=` ${member.ktName}.L"
                                    member.ktType == "Ptr<*>" -> +"(ptr + ${member.offset}) `=` ${member.ktName}.adr"
                                    else -> error("[$handleName] `${member.nName}` not processed")
                                }
                                idx++
                            }
                        }

                        "companion object" {
                            if (sType && handleName != "VkBaseInStructure" && handleName != "VkBaseOutStructure")
                                +"val sType: VkStructureType = VkStructureType.${handleName.toSnakeCase().drop(3)}"
                            +"""
                                val BYTES: UInt = ${size}u
                                val ALIGN: UInt = ${alignment}u"""
                        }
                    }
                    +"""
                        infix fun List<$handleName>.into(stack: MemStack): Ptr<UByte> {
                            val ptr = stack.calloc($handleName.ALIGN, size, $handleName.BYTES)
                            for (i in indices)
                                this[i].into(ptr + $handleName.BYTES.toInt() * i, stack)
                            return ptr
                        }"""
                }
            }
        }
    }

    val String.nSize
        get() = when (this) {
            "char", "uint8_t", "int8_t" -> 1
            "uint16_t", "int16_t" -> 2
            "float", "int", "uint32_t", "int32_t", "VkBool32", "DWORD",
            "StdVideoH264LevelIdc", "StdVideoH264ProfileIdc", "StdVideoH265LevelIdc", "StdVideoH265ProfileIdc" -> 4
            "uint64_t", "int64_t", "void*", "const void*", "size_t", "HANDLE", "HINSTANCE", "HMONITOR", "HWND", "LPCWSTR",
            "MTLCommandQueue_id", "MTLBuffer_id", "MTLDevice_id", "MTLSharedEvent_id", "MTLTexture_id", "IOSurfaceRef",
            "VkCommandBuffer", "VkPhysicalDevice", "VkQueue", "VkDeviceOrHostAddressKHR",
            "VkDeviceOrHostAddressConstKHR",
            "VkPerformanceCounterResultKHR", "VkPerformanceValueDataINTEL", "VkPipelineExecutableStatisticValueKHR" -> 8
            "VkClearColorValue", "VkClearValue" -> 16
            "VkAccelerationStructureGeometryDataKHR" -> 64
            "VkAccelerationStructureMotionInstanceDataNV" -> 144
            "Window" -> if (getCurrentOperatingSystem().isWindows) 4 else 8
            else -> when {
                this in intEnums -> 4
                this in ulongFlags || this in nonDispHandles || this in baseTypes -> 8
                this in uintBitmasks || this in uintFlags -> Int.SIZE_BYTES
                // ptr to struct, eg `const VkAccelerationStructureGeometryKHR*`
                // or ptr of ptr, eg `const VkAccelerationStructureGeometryKHR* const*`
                isPointer /*&& substring(6).dropLast(1) in structs*/ -> 8
                else -> {
                    //                println("$this.nSize")
                    val size = getSize(this)
                    check(size > 0)
                    size
                }
            }
        }

    fun getSize(handleName: String): Int {
        val struct = structs[handleName] ?: error("[${this.handleName}] $handleName not found")
        if (struct.size == 0) {
            //            print("[${this.handleName}::getSize], $handleName = ")
            struct.init()
            //            println("..${struct.size}")
        }
        return struct.size
    }

    val String.isPointer
        get() = /*startsWith("const ") && */endsWith('*')
    val String.isOpaquePointer
        get() = this == "const void*" || this == "void*"
    val String.pointerNType: String
        get() = when {
            startsWith("const ") -> substring(6)
            else -> this
        }.dropLast(1)
    val String.pointerKtType: String
        get() {
            if (this == "const char*")
                return "String"
            val type = when {
                startsWith("const ") -> substring(6)
                else -> this
            }.dropLast(1)
            return when (type) {
                "uint32_t" -> "UInt"
                "char" -> "Char"
                "char* const" -> "String"
                else -> type
            }
        }

    companion object {
        val deprecated = mapOf("VkDeviceCreateInfo" to listOf("enabledLayerCount", "ppEnabledLayerNames"))
    }
}