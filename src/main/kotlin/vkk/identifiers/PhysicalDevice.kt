package identifiers

import vkk.classes.*
import glm_.bool
import kool.*
import org.lwjgl.system.JNI.*
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.vulkan.VkQueueFamilyProperties
import org.lwjgl.vulkan.VkSurfaceFormatKHR
import vkk.VK_CHECK_RESULT
import vkk.VkPresentModeKHR
import vkk.VkResult
import vkk.entities.VkPresentModeKHR_Array
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
        val handle = s.pointerAdr {
            VK_CHECK_RESULT(
                    callPPPPI(adr, createInfo.write(s), NULL, it, capabilities.vkCreateDevice)
            )
        }
        Device(handle, this, createInfo)
    }

    // --- [ vkGetPhysicalDeviceSurfaceFormatsKHR ] ---
    inline fun nGetSurfaceFormatsKHR(surface: VkSurfaceKHR, pSurfaceFormatCount: Ptr, pSurfaceFormats: Ptr = NULL): VkResult =
            VkResult(callPJPPI(adr, surface.L, pSurfaceFormatCount, pSurfaceFormats, capabilities.vkGetPhysicalDeviceSurfaceFormatsKHR))

    infix fun getSurfaceFormatsKHR(surface: VkSurfaceKHR): MutableList<SurfaceFormatKHR> =
            stak { s ->
                val pCount = s.mInt()
                nGetSurfaceFormatsKHR(surface, pCount.adr).check()
                val count = pCount[0]
                assert(count > 0)
                val pSurfaceFormats = SurfaceFormatKHR.ncalloc(s, count)
                nGetSurfaceFormatsKHR(surface, pCount.adr, pSurfaceFormats)
                return MutableList(count) { SurfaceFormatKHR(IntPtr(pSurfaceFormats + VkSurfaceFormatKHR.SIZEOF * it)) }
            }

    // --- [ vkGetPhysicalDeviceSurfaceSupportKHR ] ---

    fun getSurfaceSupportKHR(
            queueFamilyProperties: Collection<QueueFamilyProperties>,
            surface: VkSurfaceKHR
    ): BooleanArray = stak { s ->
        val supported = s.mInt()
        BooleanArray(queueFamilyProperties.size) {
            callPJPI(adr, it, surface.L, supported.adr, capabilities.vkGetPhysicalDeviceSurfaceSupportKHR)
            supported[0].bool
        }
    }

    // --- [ vkGetPhysicalDeviceMemoryProperties ] ---
    inline val memoryProperties: PhysicalDeviceMemoryProperties
        get() = stak { s ->
            PhysicalDeviceMemoryProperties.read(s) {
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
            val pCount = s.mInt()
            nGetQueueFamilyProperties(pCount.adr)
            val count = pCount[0]
            val pQueueFamilyProperties = QueueFamilyProperties.ncalloc(s, count)
            nGetQueueFamilyProperties(pCount.adr, pQueueFamilyProperties)
            MutableList(count) { QueueFamilyProperties(pQueueFamilyProperties + VkQueueFamilyProperties.SIZEOF * it) }
        }

    // --- [ vkGetPhysicalDeviceSurfaceCapabilitiesKHR ] ---
    infix fun getSurfaceCapabilitiesKHR(surface: VkSurfaceKHR): SurfaceCapabilitiesKHR = stak { s ->
        SurfaceCapabilitiesKHR.read(s) {
            VK_CHECK_RESULT(callPJPI(adr, surface.L, it, capabilities.vkGetPhysicalDeviceSurfaceCapabilitiesKHR))
        }
    }

    // --- [ vkGetPhysicalDeviceSurfacePresentModesKHR ] ---
    inline fun nGetSurfacePresentModesKHR(surface: VkSurfaceKHR, pPresentModeCount: Ptr, pPresentModes: Ptr = NULL): VkResult =
            VkResult(callPJPPI(adr, surface.L, pPresentModeCount, pPresentModes, capabilities.vkGetPhysicalDeviceSurfacePresentModesKHR))

    infix fun getSurfacePresentModesKHR(surface: VkSurfaceKHR): VkPresentModeKHR_Array = stak { s ->
        val pPresentModeCount = s.mInt()
        var propertyCount: Int
        var result: VkResult
        var pPresentModes = IntPtr.NULL
        do {
            result = nGetSurfacePresentModesKHR(surface, pPresentModeCount.adr)
            propertyCount = pPresentModeCount[0]
            if (result == VkResult.SUCCESS && propertyCount != 0) {
                pPresentModes = s.mInt(propertyCount)
                nGetSurfacePresentModesKHR(surface, pPresentModeCount.adr, pPresentModes.adr).check()
            }
        } while (result == VkResult.INCOMPLETE)
        VkPresentModeKHR_Array(propertyCount) { VkPresentModeKHR(pPresentModes[it]) }
    }
}