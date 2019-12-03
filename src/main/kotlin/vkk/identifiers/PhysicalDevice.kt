package identifiers

import glm_.bool
import kool.*
import org.lwjgl.system.Checks
import org.lwjgl.system.JNI.*
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.vulkan.*
import vkk.*
import vkk._10.structs.*
import vkk._11.structs.*
import vkk.entities.VkPresentModeKHR_Array
import vkk.entities.VkSurfaceKHR

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


    // ---------------------------------------------- VK10 -------------------------------------------------------------


    // --- [ vkCreateDevice ] ---
    infix fun createDevice(createInfo: DeviceCreateInfo): Device = stak { s ->
        val handle = s.pointerAdr {
            VK_CHECK_RESULT(
                    callPPPPI(adr, createInfo write s, NULL, it, capabilities.vkCreateDevice)
            )
        }
        Device(handle, this, createInfo)
    }

    // --- [ vkEnumerateDeviceExtensionProperties ] ---
    inline fun nEnumerateDeviceExtensionProperties(pLayerName: Ptr, pPropertyCount: IntPtr, pProperties: Ptr = NULL): VkResult =
            VkResult(callPPPPI(adr, pLayerName, pPropertyCount.adr, pProperties, capabilities.vkEnumerateDeviceExtensionProperties))

    infix fun enumerateDeviceExtensionProperties(layerName: String?): Array<ExtensionProperties> = stak { s ->
        val pLayerName = layerName?.let { s.utf8Adr(it) } ?: NULL
        var properties: Ptr = NULL
        val pPropertyCount = s.mInt()
        var propertyCount: Int
        var result: VkResult
        do {
            result = nEnumerateDeviceExtensionProperties(pLayerName, pPropertyCount)
            propertyCount = pPropertyCount[0]
            if (result == VkResult.SUCCESS && propertyCount != 0) {
                properties = s.ncalloc(VkExtensionProperties.ALIGNOF, propertyCount, VkExtensionProperties.SIZEOF)
                result = nEnumerateDeviceExtensionProperties(pLayerName, pPropertyCount, properties)
            }
        } while (result == VkResult.INCOMPLETE)
        return Array(propertyCount) {
            ExtensionProperties(BytePtr(properties + it * VkExtensionProperties.SIZEOF))
        }
    }

    // --- [ vkEnumerateDeviceLayerProperties ] ---
    inline fun nEnumerateDeviceLayerProperties(pPropertyCount: IntPtr, pProperties: Ptr = NULL): VkResult =
            VkResult(callPPPI(adr, pPropertyCount.adr, pProperties, capabilities.vkEnumerateDeviceLayerProperties))

    fun enumerateDeviceLayerProperties(): Array<LayerProperties> = stak { s ->
        var properties: Ptr = NULL
        var propertyCount: Int
        val pPropertyCount = s.mInt()
        var result: VkResult
        do {
            result = nEnumerateDeviceLayerProperties(pPropertyCount)
            propertyCount = pPropertyCount[0]
            if (result == VkResult.SUCCESS && propertyCount != 0) {
                properties = s.ncalloc(VkLayerProperties.ALIGNOF, propertyCount, VkLayerProperties.SIZEOF)
                result = nEnumerateDeviceLayerProperties(pPropertyCount, properties)
            }
        } while (result == VkResult.INCOMPLETE)
        return Array(propertyCount) {
            LayerProperties(BytePtr(properties + it * VkLayerProperties.SIZEOF))
        }
    }

    // --- [ vkGetPhysicalDeviceFeatures ] ---
    val features: PhysicalDeviceFeatures
        get() = PhysicalDeviceFeatures read { callPPV(adr, it, capabilities.vkGetPhysicalDeviceFeatures) }

    // --- [ vkGetPhysicalDeviceFormatProperties ] ---
    infix fun getFormatProperties(format: VkFormat): FormatProperties =
            FormatProperties read { callPPV(adr, format.i, it, capabilities.vkGetPhysicalDeviceFormatProperties) }

    // --- [ vkGetPhysicalDeviceImageFormatProperties ] ---
    fun getImageFormatProperties(format: VkFormat, type: VkImageType, tiling: VkImageTiling,
                                 usage: VkImageUsageFlags, flags: VkImageCreateFlags): ImageFormatProperties =
            ImageFormatProperties.read {
                callPPI(adr, format.i, type.i, tiling.i, usage, flags, it, capabilities.vkGetPhysicalDeviceImageFormatProperties)
            }

    // --- [ vkGetPhysicalDeviceProperties ] ---
    val properties: PhysicalDeviceProperties
        get() = PhysicalDeviceProperties read { callPPV(adr, it, capabilities.vkGetPhysicalDeviceProperties) }

    // --- [ vkGetPhysicalDeviceSparseImageFormatProperties ] ---
    inline fun nGetSparseImageFormatProperties(format: VkFormat, type: VkImageType, samples: VkSampleCount,
                                               usage: VkImageUsageFlags, tiling: VkImageTiling,
                                               pPropertyCount: IntPtr, pProperties: Ptr = NULL) =
            callPPPV(adr, format.i, type.i, samples.i, usage, tiling.i, pPropertyCount.adr, pProperties, capabilities.vkGetPhysicalDeviceSparseImageFormatProperties)

    fun getSparseImageFormatProperties(format: VkFormat, type: VkImageType, samples: VkSampleCount,
                                       usage: VkImageUsageFlags, tiling: VkImageTiling): Array<SparseImageFormatProperties> =
            stak { s ->
                val pPropertyCount = s.mInt()
                nGetSparseImageFormatProperties(format, type, samples, usage, tiling, pPropertyCount)
                val propertyCount = pPropertyCount[0]
                val properties = s.ncalloc(VkSparseImageFormatProperties.ALIGNOF, propertyCount, VkSparseImageFormatProperties.SIZEOF)
                nGetSparseImageFormatProperties(format, type, samples, usage, tiling, pPropertyCount, properties)
                Array(propertyCount) {
                    SparseImageFormatProperties(BytePtr(properties + it * VkSparseImageFormatProperties.SIZEOF))
                }
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
        get() = PhysicalDeviceMemoryProperties read { callPPV(adr, it, capabilities.vkGetPhysicalDeviceMemoryProperties) }

    // --- [ vkGetPhysicalDeviceQueueFamilyProperties ] ---
    inline fun nGetQueueFamilyProperties(pQueueFamilyPropertyCount: Ptr, pQueueFamilyProperties: Ptr = NULL) =
            callPPPV(
                    adr,
                    pQueueFamilyPropertyCount,
                    pQueueFamilyProperties,
                    capabilities.vkGetPhysicalDeviceQueueFamilyProperties
            )

    val queueFamilyProperties: Array<QueueFamilyProperties>
        get() = stak { s ->
            val pCount = s.mInt()
            nGetQueueFamilyProperties(pCount.adr)
            val count = pCount[0]
            val pQueueFamilyProperties = QueueFamilyProperties.ncalloc(s, count)
            nGetQueueFamilyProperties(pCount.adr, pQueueFamilyProperties)
            Array(count) {
                QueueFamilyProperties(BytePtr(pQueueFamilyProperties + VkQueueFamilyProperties.SIZEOF * it))
            }
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


    // ---------------------------------------------- VK11 -------------------------------------------------------------


    // --- [ vkGetPhysicalDeviceExternalBufferProperties ] ---
    infix fun getExternalBufferProperties(externalBufferInfo: PhysicalDeviceExternalBufferInfo): ExternalBufferProperties = stak { s ->
        ExternalBufferProperties.read(s) {
            callPPPV(adr, externalBufferInfo write s, it, capabilities.vkGetPhysicalDeviceExternalBufferProperties)
        }
    }

    // --- [ vkGetPhysicalDeviceExternalFenceProperties ] ---
    infix fun getExternalFenceProperties(externalFenceInfo: PhysicalDeviceExternalFenceInfo): ExternalFenceProperties = stak { s ->
        ExternalFenceProperties.read(s) {
            callPPPV(adr, externalFenceInfo write s, it, capabilities.vkGetPhysicalDeviceExternalFenceProperties)
        }
    }

    // --- [ vkGetPhysicalDeviceExternalSemaphoreProperties ] ---
    infix fun getExternalSemaphoreProperties(externalSemaphoreInfo: PhysicalDeviceExternalSemaphoreInfo): ExternalSemaphoreProperties = stak { s ->
        ExternalSemaphoreProperties.read(s) {
            callPPPV(adr, externalSemaphoreInfo write s, it, capabilities.vkGetPhysicalDeviceExternalSemaphoreProperties)
        }
    }

    // --- [ vkGetPhysicalDeviceFeatures2 ] ---
    val features2: PhysicalDeviceFeatures2
        get() = PhysicalDeviceFeatures2.read { callPPV(adr, it, capabilities.vkGetPhysicalDeviceFeatures2) }

    // --- [ vkGetPhysicalDeviceFormatProperties2 ] ---
    infix fun getFormatProperties2(format: VkFormat): FormatProperties2 =
            FormatProperties2.read { callPPV(adr, format.i, it, capabilities.vkGetPhysicalDeviceFormatProperties2) }

    // --- [ vkGetPhysicalDeviceImageFormatProperties2 ] ---
    infix fun getImageFormatProperties2(imageFormatInfo: PhysicalDeviceImageFormatInfo2): ImageFormatProperties2 = stak { s ->
        ImageFormatProperties2.read(s) {
            VK_CHECK_RESULT(callPPPI(adr, imageFormatInfo write s, it, capabilities.vkGetPhysicalDeviceImageFormatProperties2))
        }
    }

    // --- [ vkGetPhysicalDeviceMemoryProperties2 ] ---
    val memoryProperties2: PhysicalDeviceMemoryProperties2
        get() = PhysicalDeviceMemoryProperties2.read { callPPV(adr, it, capabilities.vkGetPhysicalDeviceMemoryProperties2) }

    // --- [ vkGetPhysicalDeviceProperties2 ] ---
    val properties2: PhysicalDeviceProperties2
        get() = PhysicalDeviceProperties2.read { callPPV(adr, it, capabilities.vkGetPhysicalDeviceProperties2) }

    // --- [ vkGetPhysicalDeviceQueueFamilyProperties2 ] ---
    inline fun nGetQueueFamilyProperties2(pQueueFamilyPropertyCount: IntPtr, pQueueFamilyProperties: Ptr = NULL) =
            callPPPV(adr, pQueueFamilyPropertyCount.adr, pQueueFamilyProperties, capabilities.vkGetPhysicalDeviceQueueFamilyProperties2)

    val queueFamilyProperties2: Array<QueueFamilyProperties2>
        get() = stak { s ->
            val pQueueFamilyPropertyCount = s.mInt()
            nGetQueueFamilyProperties2(pQueueFamilyPropertyCount)
            val queueFamilyPropertyCount = pQueueFamilyPropertyCount[0]
            val queueFamilyProperties = s.ncalloc(VkQueueFamilyProperties2.ALIGNOF, queueFamilyPropertyCount, VkQueueFamilyProperties2.SIZEOF)
            nGetQueueFamilyProperties2(pQueueFamilyPropertyCount, queueFamilyProperties)
            Array(queueFamilyPropertyCount) {
                QueueFamilyProperties2(BytePtr(queueFamilyProperties + it * VkQueueFamilyProperties2.SIZEOF))
            }
        }

    // --- [ vkGetPhysicalDeviceSparseImageFormatProperties2 ] ---
    inline fun nGetSparseImageFormatProperties2(pFormatInfo: Ptr, pPropertyCount: IntPtr, pProperties: Ptr = NULL) =
            callPPPPV(adr, pFormatInfo, pPropertyCount.adr, pProperties, capabilities.vkGetPhysicalDeviceSparseImageFormatProperties2)

    fun getSparseImageFormatProperties2(formatInfo: PhysicalDeviceSparseImageFormatInfo2): Array<SparseImageFormatProperties2> = stak { s ->
        val pPropertyCount = s.mInt()
        val pFormatInfo = formatInfo write s
        nGetSparseImageFormatProperties2(pFormatInfo, pPropertyCount)
        val propertyCount = pPropertyCount[0]
        val properties = s.ncalloc(VkSparseImageFormatProperties2.ALIGNOF, propertyCount, VkSparseImageFormatProperties2.SIZEOF)
        nGetSparseImageFormatProperties2(pFormatInfo, pPropertyCount, properties)
        return Array(propertyCount) {
            SparseImageFormatProperties2(BytePtr(properties + it * VkSparseImageFormatProperties2.SIZEOF))
        }
    }
}