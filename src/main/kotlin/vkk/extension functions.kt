package vkk

import glm_.*
import glm_.vec2.Vec2i
import kool.*
import org.lwjgl.PointerBuffer
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.system.Pointer
import org.lwjgl.vulkan.*
import vkk.entities.*
import vkk.extensionFunctions.begin
import java.nio.Buffer
import java.nio.IntBuffer
import java.nio.LongBuffer




// VkInstance ======================================================================================================

infix fun VkInstance.createDebugReportCallbackEXT(createInfo: VkDebugReportCallbackCreateInfoEXT): VkDebugReportCallback = VkDebugReportCallback(stak.longAddress { VK_CHECK_RESULT(EXTDebugReport.nvkCreateDebugReportCallbackEXT(this, createInfo.adr, NULL, it)) })

fun VkInstance.destroy() = VK10.nvkDestroyInstance(this, NULL)

infix fun VkInstance.destroyDebugReportCallbackEXT(debugReportCallback: VkDebugReportCallback) = EXTDebugReport.nvkDestroyDebugReportCallbackEXT(this, debugReportCallback.L, NULL)

fun VkInstance.enumeratePhysicalDevices(): ArrayList<VkPhysicalDevice> = stak {
    val physicalDevices = ArrayList<VkPhysicalDevice>()
    val pPhysicalDeviceCount = it.nmalloc(1, Int.BYTES)
    var physicalDeviceCount: Int
    var result: VkResult
    do {
        result = VkResult(VK10.nvkEnumeratePhysicalDevices(this, pPhysicalDeviceCount, NULL))
        physicalDeviceCount = memGetInt(pPhysicalDeviceCount)
        if (result == VkResult.SUCCESS && physicalDeviceCount > 0) {
            val pPhysicalDevices = it.nmalloc(Pointer.POINTER_SIZE, physicalDeviceCount * Pointer.POINTER_SIZE)
            result = VkResult(VK10.nvkEnumeratePhysicalDevices(this, pPhysicalDeviceCount, pPhysicalDevices))
            for (i in 0 until physicalDeviceCount)
                physicalDevices += VkPhysicalDevice(memGetAddress(pPhysicalDevices), this)
        }
    } while (result == VkResult.INCOMPLETE)
    assert(physicalDeviceCount == physicalDevices.size)
    physicalDevices
}

infix fun VkInstance.destroySurfaceKHR(surface: VkSurfaceKHR) = KHRSurface.nvkDestroySurfaceKHR(this, surface.L, NULL)


// VkPhysicalDevice ================================================================================================

inline val VkPhysicalDevice.features: VkPhysicalDeviceFeatures
    get() = getFeatures(vk.PhysicalDeviceFeatures())

infix fun VkPhysicalDevice.getFeatures(features: VkPhysicalDeviceFeatures): VkPhysicalDeviceFeatures = features.also { VK10.nvkGetPhysicalDeviceFeatures(this, it.adr) }

infix fun VkPhysicalDevice.getFormatProperties(format: VkFormat): VkFormatProperties = getFormatProperties(format, vk.FormatProperties())

fun VkPhysicalDevice.getFormatProperties(format: VkFormat, formatProperties: VkFormatProperties): VkFormatProperties = formatProperties.also { VK10.nvkGetPhysicalDeviceFormatProperties(this, format.i, it.adr) }

infix fun VkPhysicalDevice.getSurfaceFormatsKHR(surface: VkSurfaceKHR): ArrayList<VkSurfaceFormatKHR> = vk.getPhysicalDeviceSurfaceFormatsKHR(this, surface)

inline val VkPhysicalDevice.memoryProperties: VkPhysicalDeviceMemoryProperties
    get() = getMemoryProperties(vk.PhysicalDeviceMemoryProperties())

infix fun VkPhysicalDevice.getMemoryProperties(memoryProperties: VkPhysicalDeviceMemoryProperties) = memoryProperties.also { VK10.nvkGetPhysicalDeviceMemoryProperties(this, it.adr) }

inline val VkPhysicalDevice.queueFamilyProperties: ArrayList<VkQueueFamilyProperties>
    get() = vk.getPhysicalDeviceQueueFamilyProperties(this)

inline val VkPhysicalDevice.properties: VkPhysicalDeviceProperties
    get() = getProperties(vk.PhysicalDeviceProperties())

infix fun VkPhysicalDevice.getProperties(properties: VkPhysicalDeviceProperties) = properties.also { VK10.nvkGetPhysicalDeviceProperties(this, it.adr) }

infix fun VkPhysicalDevice.createDevice(createInfo: VkDeviceCreateInfo): VkDevice = VkDevice(stak.pointerAddress { VK_CHECK_RESULT(VK10.nvkCreateDevice(this, createInfo.adr, NULL, it)) }, this, createInfo)

infix fun VkPhysicalDevice.getSurfaceCapabilitiesKHR(surface: VkSurfaceKHR): VkSurfaceCapabilitiesKHR = vk.SurfaceCapabilitiesKHR { VK_CHECK_RESULT(KHRSurface.nvkGetPhysicalDeviceSurfaceCapabilitiesKHR(this@getSurfaceCapabilitiesKHR, surface.L, adr)) }

fun VkPhysicalDevice.getSurfaceSupportKHR(queueFamily: Int, surface: VkSurfaceKHR): Boolean = vk.getPhysicalDeviceSurfaceSupportKHR(this, queueFamily, surface)

fun VkPhysicalDevice.getSurfaceSupportKHR(queueFamilyProperties: ArrayList<VkQueueFamilyProperties>, surface: VkSurfaceKHR): BooleanArray = vk.getPhysicalDeviceSurfaceSupportKHR(this, queueFamilyProperties, surface)

infix fun VkPhysicalDevice.getSurfacePresentModesKHR(surface: VkSurfaceKHR): ArrayList<VkPresentModeKHR> = vk.getPhysicalDeviceSurfacePresentModesKHR(this, surface)


// VkQueue =========================================================================================================

infix fun VkQueue.presentKHR(presentInfo: VkPresentInfoKHR) = VK_CHECK_RESULT(KHRSwapchain.vkQueuePresentKHR(this, presentInfo))
fun VkQueue.presentKHR(presentInfo: VkPresentInfoKHR, block: (VkResult) -> Unit) = block(VkResult(KHRSwapchain.vkQueuePresentKHR(this, presentInfo)))

infix fun VkQueue.submit(submits: VkSubmitInfo) = VK_CHECK_RESULT(VK10.nvkQueueSubmit(this, 1, submits.adr, NULL))

fun VkQueue.submit(submits: VkSubmitInfo, fence: VkFence) = VK_CHECK_RESULT(VK10.nvkQueueSubmit(this, 1, submits.adr, fence.L))

fun VkQueue.waitIdle() = VK_CHECK_RESULT(VK10.vkQueueWaitIdle(this))
