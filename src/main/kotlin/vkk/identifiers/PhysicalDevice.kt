package identifiers

import classes.*
import glm_.BYTES
import kool.Adr
import kool.Ptr
import kool.adr
import org.lwjgl.system.JNI.*
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.vulkan.VkQueueFamilyProperties
import org.lwjgl.vulkan.VkSurfaceFormatKHR
import util.VkPresentModeKHR_Array
import util.nmallocInt
import util.pointerAddress
import vkk.VK_CHECK_RESULT
import vkk.VkPresentModeKHR
import vkk.VkResult
import vkk.entities.VkSurfaceKHR
import vkk.stak

/** Wraps a Vulkan physical device handle.  */
class PhysicalDevice
/**
 * Creates a `VkPhysicalDevice` using the specified native handle and Vulkan instance.
 *
 * @param handle   the native `VkDevice` handle
 * @param instance the Vulkan instance from which the physical device was enumerated
 */(
    handle: Adr,
    /** Returns the Vulkan instance from which this physical device was enumerated.  */
    val instance: Instance
) : Dispatchable(handle, instance.capabilities) {

    // --- [ vkCreateDevice ] ---
    infix fun createDevice(createInfo: DeviceCreateInfo): Device = stak { s ->
        val handle = s.pointerAddress {
            VK_CHECK_RESULT(
                callPPPPI(adr, createInfo.run { s.native }, NULL, it, capabilities.vkCreateDevice)
            )
        }
        Device(handle, this, createInfo)
    }

    // --- [ vkGetPhysicalDeviceSurfaceFormatsKHR ] ---
    inline fun nGetSurfaceFormatsKHR(surface: VkSurfaceKHR, pSurfaceFormatCount: Ptr, pSurfaceFormats: Ptr = NULL): VkResult =
        VkResult(callPJPPI(adr, surface.L, pSurfaceFormatCount, pSurfaceFormats, capabilities.vkGetPhysicalDeviceSurfaceFormatsKHR))

    infix fun getSurfaceFormatsKHR(surface: VkSurfaceKHR): MutableList<SurfaceFormatKHR> =
        stak { s ->
            val pCount = s.nmallocInt()
            nGetSurfaceFormatsKHR(surface, pCount).check()
            val count = memGetInt(pCount)
            assert(count > 0)
            val pSurfaceFormats = SurfaceFormatKHR.ncalloc(s, count)
            nGetSurfaceFormatsKHR(surface, pCount, pSurfaceFormats)
            return MutableList(count) { SurfaceFormatKHR(pSurfaceFormats + VkSurfaceFormatKHR.SIZEOF * it) }
        }

    // --- [ vkGetPhysicalDeviceSurfaceSupportKHR ] ---

    fun getSurfaceSupportKHR(
        queueFamilyProperties: Collection<QueueFamilyProperties>,
        surface: VkSurfaceKHR
    ): BooleanArray = stak { s ->
        val supported = s.nmallocInt()
        BooleanArray(queueFamilyProperties.size) {
            callPJPI(adr, it, surface.L, supported, capabilities.vkGetPhysicalDeviceSurfaceSupportKHR)
            memGetBoolean(supported)
        }
    }

    // --- [ vkGetPhysicalDeviceMemoryProperties ] ---
    inline val memoryProperties: PhysicalDeviceMemoryProperties
        get() = stak { s ->
            PhysicalDeviceMemoryProperties.fromNative(s) {
                callPPV(adr, it, capabilities.vkGetPhysicalDeviceMemoryProperties)
            }
        }

    // --- [ vkGetPhysicalDeviceQueueFamilyProperties ] ---
    inline fun nGetQueueFamilyProperties(pQueueFamilyPropertyCount: Ptr, pQueueFamilyProperties: Ptr = NULL) =
        callPPPV(
            adr,
            pQueueFamilyPropertyCount,
            pQueueFamilyProperties,
            capabilities.vkGetPhysicalDeviceQueueFamilyProperties
        )

    val queueFamilyProperties: MutableList<QueueFamilyProperties>
        get() = stak { s ->
            val pCount = s.nmallocInt()
            nGetQueueFamilyProperties(pCount)
            val count = memGetInt(pCount)
            val pQueueFamilyProperties = QueueFamilyProperties.ncalloc(s, count)
            nGetQueueFamilyProperties(pCount, pQueueFamilyProperties)
            MutableList(count) { QueueFamilyProperties(pQueueFamilyProperties + VkQueueFamilyProperties.SIZEOF * it) }
        }

    // --- [ vkGetPhysicalDeviceSurfaceCapabilitiesKHR ] ---
    infix fun getSurfaceCapabilitiesKHR(surface: VkSurfaceKHR): SurfaceCapabilitiesKHR = stak { s ->
        SurfaceCapabilitiesKHR.fromNative(s) {
            VK_CHECK_RESULT(callPJPI(adr, surface.L, it, capabilities.vkGetPhysicalDeviceSurfaceCapabilitiesKHR))
        }
    }

    // --- [ vkGetPhysicalDeviceSurfacePresentModesKHR ] ---
    inline fun nGetSurfacePresentModesKHR(surface: VkSurfaceKHR, pPresentModeCount: Ptr, pPresentModes: Ptr = NULL): VkResult =
        VkResult(callPJPPI(adr, surface.L, pPresentModeCount, pPresentModes, capabilities.vkGetPhysicalDeviceSurfacePresentModesKHR))

    infix fun getSurfacePresentModesKHR(surface: VkSurfaceKHR): VkPresentModeKHR_Array = stak { s ->
        val pPresentModeCount = s.nmallocInt()
        var propertyCount: Int
        var result: VkResult
        var pPresentModes: Ptr = NULL
        do {
            result = nGetSurfacePresentModesKHR(surface, pPresentModeCount)
            propertyCount = memGetInt(pPresentModeCount)
            if (result == VkResult.SUCCESS && propertyCount != 0) {
                pPresentModes = s.nmallocInt(propertyCount)
                nGetSurfacePresentModesKHR(surface, pPresentModeCount, pPresentModes).check()
            }
        } while (result == VkResult.INCOMPLETE)
        VkPresentModeKHR_Array(propertyCount) {
            VkPresentModeKHR(memGetInt(pPresentModes + Int.BYTES * it))
        }
    }
}