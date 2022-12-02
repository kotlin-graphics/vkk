package vkk.handles

import vkk.gen.Generator
import vkk.gen.generate
import java.io.File

fun VkInstance(target: File, vkDocs: File) {

    generate(target, vkDocs, "vkk/api/VkInstance.kt") {

//        experimentals += Generator.Experimentals.UnsignedTypes

        `package` = "vkk.api"
        imports += listOf(
            "vkk.api.VkInstanceCreateInfo",
            "vkk.InstanceCapabilities",
            "kool.Adr",
            "vkk.identifiers.VK",
            "vkk.identifiers.Dispatchable",
            "vkk.MemStack",
//            "kool.set",
            "vkk.VK_CHECK_RESULT",
//            "kool.ubuffers.UByteBuffer",
            "org.lwjgl.system.JNI.callPPPI",
                         )

        +"""
            class VkInstance
                /** Create a new Vulkan instance */
                constructor(createInfo: VkInstanceCreateInfo, stack: MemStack = MemStack()) : Dispatchable {
            
                /** the native [VkInstance] handle */
                override val handle: Adr
                
                /** the [InstanceCapabilities] instance associated with this dispatchable handle.  */
                val capabilities: InstanceCapabilities
                
                init {
                    stack.framed {
                        handle = readPointer {
                            VK_CHECK_RESULT(callPPPI(createInfo.into(stack).adr.toLong(), 0L, it.adr.toLong(), VK.globalCommands.vkCreateInstance.adr.toLong()))
                        }.adr
            
                        val apiVersion = createInfo.applicationInfo?.apiVersion?.takeIf { it.isValid } ?: `VK_API_VERSION 1,0`
            
                        return VKCapabilitiesInstance(FunctionProvider { functionName: ByteBuffer? ->
                            val address: Long = JNI.callPPP(handle, MemoryUtil.memAddress(functionName), org.lwjgl.vulkan.VK.getGlobalCommands().vkGetInstanceProcAddr)
                            if (address == MemoryUtil.NULL && Checks.DEBUG_FUNCTIONS) {
                                APIUtil.apiLog("Failed to locate address for VK instance function " + MemoryUtil.memASCII(functionName))
                            }
                            address
                        }, apiVersion, apiVersion getEnabledExtensionSet createInfo.enabledExtensionNames, org.lwjgl.vulkan.VkInstance.getAvailableDeviceExtensions(handle.toLong()))
                    }
                }
            }
            """
    }
}