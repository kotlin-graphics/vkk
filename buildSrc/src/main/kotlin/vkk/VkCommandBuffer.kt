package vkk

import vkk.gen.Generator
import vkk.gen.generate
import java.io.File

fun VkCommandBuffer(target: File, vkDocs: File) {

    generate(target, vkDocs, "vkk/api/VkCommandBuffer.kt") {

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
            class VkCommandBuffer
                /** Create a new Vulkan instance */
                constructor(createInfo: VkInstanceCreateInfo, stack: MemStack = MemStack()) : Dispatchable {
            
                /** the native [VkInstance] handle */
                override val handle: Adr
                
                /** the [InstanceCapabilities] instance associated with this dispatchable handle.  */
                val capabilities: InstanceCapabilities
                
                init {
                    VK_CHECK_RESULT(callPPPI(createInfo.ptr.adr.toLong(), 0L, it.adr.toLong(), adr.toLong()))
                    
                    val appInfo: VkApplicationInfo = createInfo.pApplicationInfo
            
                    val apiVersion = if (appInfo != null && appInfo.apiVersion() != 0) appInfo.apiVersion() else VK10.VK_API_VERSION_1_0
            
                    return VKCapabilitiesInstance(FunctionProvider { functionName: ByteBuffer? ->
                        val address: Long = JNI.callPPP(handle, MemoryUtil.memAddress(functionName), org.lwjgl.vulkan.VK.getGlobalCommands().vkGetInstanceProcAddr)
                        if (address == MemoryUtil.NULL && Checks.DEBUG_FUNCTIONS) {
                            APIUtil.apiLog("Failed to locate address for VK instance function " + MemoryUtil.memASCII(functionName))
                        }
                        address
                    }, apiVersion, org.lwjgl.vulkan.VK.getEnabledExtensionSet(apiVersion, ci.ppEnabledExtensionNames()), org.lwjgl.vulkan.VkInstance.getAvailableDeviceExtensions(handle.toLong()))
                }
            }
            """
    }
}