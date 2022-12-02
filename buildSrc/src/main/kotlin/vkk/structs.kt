package vkk

import vkk.gen.*
import java.io.File

val interfaces = mapOf(
    "VkAccelerationStructureGeometryDataKHR" to listOf("VkAccelerationStructureGeometryTrianglesDataKHR",
                                                       "VkAccelerationStructureGeometryAabbsDataKHR",
                                                       "VkAccelerationStructureGeometryInstancesDataKHR"),
    "VkAccelerationStructureMotionInstanceDataNV" to listOf("VkAccelerationStructureInstanceKHR",
                                                            "VkAccelerationStructureMatrixMotionInstanceNV",
                                                            "VkAccelerationStructureSRTMotionInstanceNV"),
    "VkClearValue" to listOf("VkClearColorValue", "VkClearDepthStencilValue"),
    "VkDeviceOrHostAddressConstKHR" to listOf("VkDeviceAddress"),
    "VkDeviceOrHostAddressKHR" to listOf("VkDeviceAddress"))

fun structs(target: File, vkDocs: File) {

    generate(target, vkDocs, "vkk/api/structs.kt") {

        experimentals += Generator.Experimentals.UnsignedTypes

        `package` = "vkk.api"
        imports += listOf(
            "vkk.api.VkSemaphore_Array",
            "kool.Ptr",
            "vkk.Adr",
            "vkk.`=`",
            "vkk.into",
            "vkk.utf8Into",
            "vkk.MemStack",
            "kool.set",
            "kool.isNotEmpty",
            "vkk.set",
            "vkk.Wl_display",
            "vkk.Wl_surface",
            "kool.ubuffers.UByteBuffer",
            "org.lwjgl.system.MemoryStack",
                         )

        fun skip(name: String): Boolean = when (name) {
            "VkAllocationCallbacks", "VkAndroidSurfaceCreateInfoKHR", "VkDeviceFaultInfoEXT",
            "VkDirectFBSurfaceCreateInfoEXT", "VkBaseOutStructure", "VkBaseInStructure",
            "VkPresentFrameTokenGGP", "VkStreamDescriptorSurfaceCreateInfoGGP", "VkXcbSurfaceCreateInfoKHR", // skip
            "VkShaderModuleCreateInfo", // TODO
            "VkDebugReportCallbackCreateInfoEXT", "VkDebugUtilsMessengerCreateInfoEXT", "VkDeviceDeviceMemoryReportCreateInfoEXT" // debug
            -> true
            else -> when {
                "FUCHSIA" in name || "ANDROID" in name || "QNX" in name -> true
                else -> refPages[name]?.page?.startsWith("There is currently no specification language written for this type.") ?: false
            }
        }

        val specialReadWrite = listOf("VkAccelerationStructureInstanceKHR", "VkAccelerationStructureMatrixMotionInstanceNV",
                                      "VkAccelerationStructureSRTMotionInstanceNV")


        //        val specialCases = listOf(Case("VkDeviceQueueCreateInfo","queueCount", "pQueuePriorities"))

        fun String.isPointer() = startsWith("const ") && last() == '*'
        fun String.getKtType() = when (this) {
            "int8_t" -> "Byte"
            "int16_t" -> "Short"
            "int32_t" -> "Int"
            "int64_t" -> "Long"
            "uint8_t" -> "UByte"
            "uint16_t" -> "UShort"
            "uint32_t" -> "UInt"
            "uint64_t" -> "ULong"
            "VkBool32" -> "Boolean"
            "const uint8_t*" -> "UByteBuffer"
            "const char*" -> "String"
            "void*", "const void*" -> "Ptr<*>"
            "size_t" -> "Long"
            else -> capitalize()
        }

        // we need to loop it first and save all the structs, because this is needed later on when we go field by field
        val xml = vkDocs.resolve("xml/vk.xml").readLines()
                .dropWhile { it != "            <comment>Struct types</comment>" }
                .takeWhile { it != "    </types>" }
        lateinit var struct: Struct
        var skip = false
        for (line in xml)
            when {
                line.category == "struct" || line.category == "union" -> {
                    val name = line.name
                    skip = skip(name)
                    if (!skip) {
                        struct = Struct(name, line.alias)
                        structs[name] = struct
                    }
                }
                line.isMember -> {
                    if (!skip) {
                        val (nType, nName) = line.cleaned
                        struct.members += struct.Member(nName, nType, line.len, line.optional)
                        if (nName == "sType")
                            struct.sType = true
                    }
                }
            }
        for (s in structs.values.toList().sortedBy { it.handleName }.take(400))
            s.apply {
                init()
                write()
            }
    }
}

private val String.category: String
    get() = substringAfter("category=\"", "").substringBefore('"')
private val String.name: String
    get() = substringAfter("name=\"", "").substringBefore('"')
private val String.alias: String
    get() = substringAfter("alias=\"", "").substringBefore('"')
private val String.isMember: Boolean
    get() = startsWith("            <member")
private val String.len: String
    get() = substringAfter("len=\"", "").substringBefore('"')
private val String.optional: Boolean
    get() = substringAfter("optional=\"", "").substringBefore('"') == "true"
private val String.cleaned: Pair<String, String>
    get() {
        var line = substringBefore("<comment>")
        var res = ""
        while ('<' in line) {
            res += line.substringBefore('<')
            line = line.substringAfter('>')
        }
        val split = res.trim().split(Regex("\\s+"))
        return split.dropLast(1).joinToString(" ") to split.last()
    }

