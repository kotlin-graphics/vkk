package vkk._10.api

import kool.adr
import kool.longAdr
import kool.utf8Adr
import org.lwjgl.system.Checks
import org.lwjgl.system.JNI.*
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.system.Pointer
import org.lwjgl.vulkan.VK10
import org.lwjgl.vulkan.VkAllocationCallbacks
import org.lwjgl.vulkan.VkInstance
import vkk.*
import vkk._10.structs.DebugReportCallbackCreateInfo
import vkk.entities.VkDebugReportCallback
import vkk.entities.VkSurfaceKHR
import vkk.extensions.VkDebugReportFlagsEXT
import vkk.extensions.VkDebugReportObjectTypeEXT
import vkk.identifiers.CapabilitiesInstance

interface Instance_vk10 : Pointer {

    val capabilities: CapabilitiesInstance

    // --- [ vkCreateDebugReportCallbackEXT ] ---

    infix fun MemoryStack.createDebugReportCallbackEXT(createInfo: DebugReportCallbackCreateInfo): VkDebugReportCallback =
            framed { VkDebugReportCallback(this.longAdr { VK_CHECK_RESULT(callPPPPI(adr, createInfo write this, NULL, it, capabilities.vkCreateDebugReportCallbackEXT)) }) }

    infix fun createDebugReportCallbackEXT(createInfo: DebugReportCallbackCreateInfo): VkDebugReportCallback =
            stak { it createDebugReportCallbackEXT createInfo }

    // --- [ vkDebugReportMessageEXT ] ---

    fun MemoryStack.debugReportMessageEXT(flags: VkDebugReportFlagsEXT, objectType: VkDebugReportObjectTypeEXT, `object`: Long = VK10.VK_NULL_HANDLE,
                                          location: Long, messageCode: Int, pLayerPrefix: String, pMessage: String) =
            framed {
                callPJPPPV(
                        adr, flags, objectType.i, `object`, location, messageCode, this.utf8Adr(pLayerPrefix),
                        this.utf8Adr(pMessage), capabilities.vkCreateDebugReportCallbackEXT
                )
            }

    fun debugReportMessageEXT(flags: VkDebugReportFlagsEXT, objectType: VkDebugReportObjectTypeEXT, `object`: Long = VK10.VK_NULL_HANDLE,
                              location: Long, messageCode: Int, pLayerPrefix: String, pMessage: String) =
            stak { it.debugReportMessageEXT(flags, objectType, `object`, location, messageCode, pLayerPrefix, pMessage) }

    // --- [ vkDestroyDebugReportCallbackEXT ] ---
    infix fun destroy(debugReportCallback: VkDebugReportCallback) =
            callPJPV(adr, debugReportCallback.L, NULL, capabilities.vkDestroyDebugReportCallbackEXT)

    // --- [ vkDestroyInstance ] ---
    fun destroy() =
            callPPV(adr, NULL, capabilities.vkDestroyInstance)
}