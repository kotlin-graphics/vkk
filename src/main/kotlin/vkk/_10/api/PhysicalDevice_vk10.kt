package vkk._10.api

import glm_.bool
import identifiers.CapabilitiesInstance
import kool.*
import org.lwjgl.system.JNI.*
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.system.Pointer
import org.lwjgl.vulkan.*
import vkk.*
import vkk._10.structs.*
import vkk.entities.VkPresentModeKHR_Array
import vkk.entities.VkSurfaceKHR

interface PhysicalDevice_vk10 : Pointer {

    val capabilities: CapabilitiesInstance

    // --- [ vkEnumerateDeviceExtensionProperties ] ---

    fun MemoryStack.enumerateDeviceExtensionProperties(layerName: String? = null): Array<ExtensionProperties> =
            framed {
                val pLayerName = layerName?.let { this.utf8Adr(it) } ?: NULL
                var properties: Ptr = NULL
                val pPropertyCount = this.mInt()
                var propertyCount: Int
                var result: VkResult
                do {
                    result = nEnumerateDeviceExtensionProperties(pLayerName, pPropertyCount)
                    propertyCount = pPropertyCount[0]
                    if (result == VkResult.SUCCESS && propertyCount != 0) {
                        properties = this.ncalloc(VkExtensionProperties.ALIGNOF, propertyCount, VkExtensionProperties.SIZEOF)
                        result = nEnumerateDeviceExtensionProperties(pLayerName, pPropertyCount, properties)
                    }
                } while (result == VkResult.INCOMPLETE)
                Array(propertyCount) {
                    ExtensionProperties(BytePtr(properties + it * VkExtensionProperties.SIZEOF))
                }
            }

    fun enumerateDeviceExtensionProperties(layerName: String? = null): Array<ExtensionProperties> =
            stak { it.enumerateDeviceExtensionProperties(layerName) }

    // --- [ vkEnumerateDeviceLayerProperties ] ---

    fun MemoryStack.enumerateDeviceLayerProperties(): Array<LayerProperties> = framed {
        var properties: Ptr = NULL
        var propertyCount: Int
        val pPropertyCount = this.mInt()
        var result: VkResult
        do {
            result = nEnumerateDeviceLayerProperties(pPropertyCount)
            propertyCount = pPropertyCount[0]
            if (result == VkResult.SUCCESS && propertyCount != 0) {
                properties = this.ncalloc(VkLayerProperties.ALIGNOF, propertyCount, VkLayerProperties.SIZEOF)
                result = nEnumerateDeviceLayerProperties(pPropertyCount, properties)
            }
        } while (result == VkResult.INCOMPLETE)
        Array(propertyCount) {
            LayerProperties(BytePtr(properties + it * VkLayerProperties.SIZEOF))
        }
    }

    fun enumerateDeviceLayerProperties(): Array<LayerProperties> =
            stak { it.enumerateDeviceLayerProperties() }

    // --- [ vkGetPhysicalDeviceFeatures ] ---

    val MemoryStack.features: PhysicalDeviceFeatures
        get() = PhysicalDeviceFeatures.read(this) { callPPV(adr, it, capabilities.vkGetPhysicalDeviceFeatures) }

    val features: PhysicalDeviceFeatures
        get() = stak { it.features }

    // --- [ vkGetPhysicalDeviceFormatProperties ] ---

    infix fun MemoryStack.getFormatProperties(format: VkFormat): FormatProperties =
            framed { FormatProperties.read(this) { callPPV(adr, format.i, it, capabilities.vkGetPhysicalDeviceFormatProperties) } }

    infix fun getFormatProperties(format: VkFormat): FormatProperties =
            stak { it getFormatProperties format }

    // --- [ vkGetPhysicalDeviceImageFormatProperties ] ---

    fun MemoryStack.getImageFormatProperties(format: VkFormat, type: VkImageType, tiling: VkImageTiling, usage: VkImageUsageFlags, flags: VkImageCreateFlags): ImageFormatProperties =
            framed { ImageFormatProperties.read(this) { VK_CHECK_RESULT(callPPI(adr, format.i, type.i, tiling.i, usage, flags, it, capabilities.vkGetPhysicalDeviceImageFormatProperties)) } }

    fun getImageFormatProperties(format: VkFormat, type: VkImageType, tiling: VkImageTiling, usage: VkImageUsageFlags, flags: VkImageCreateFlags): ImageFormatProperties =
            stak { it.getImageFormatProperties(format, type, tiling, usage, flags) }

    // --- [ vkGetPhysicalDeviceProperties ] ---

    val MemoryStack.properties: PhysicalDeviceProperties
        get() = framed { PhysicalDeviceProperties.read(this) { callPPV(adr, it, capabilities.vkGetPhysicalDeviceProperties) } }

    val properties: PhysicalDeviceProperties
        get() = stak { it.properties }

    // --- [ vkGetPhysicalDeviceSparseImageFormatProperties ] ---

    fun MemoryStack.getSparseImageFormatProperties(format: VkFormat, type: VkImageType, samples: VkSampleCount, usage: VkImageUsageFlags, tiling: VkImageTiling): Array<SparseImageFormatProperties> =
            framed {
                val pPropertyCount = this.mInt()
                nGetSparseImageFormatProperties(format, type, samples, usage, tiling, pPropertyCount)
                val propertyCount = pPropertyCount[0]
                val properties = this.ncalloc(VkSparseImageFormatProperties.ALIGNOF, propertyCount, VkSparseImageFormatProperties.SIZEOF)
                nGetSparseImageFormatProperties(format, type, samples, usage, tiling, pPropertyCount, properties)
                Array(propertyCount) {
                    SparseImageFormatProperties(BytePtr(properties + it * VkSparseImageFormatProperties.SIZEOF))
                }
            }

    fun getSparseImageFormatProperties(format: VkFormat, type: VkImageType, samples: VkSampleCount, usage: VkImageUsageFlags, tiling: VkImageTiling): Array<SparseImageFormatProperties> =
            stak { it.getSparseImageFormatProperties(format, type, samples, usage, tiling) }

    // --- [ vkGetPhysicalDeviceSurfaceFormatsKHR ] ---

    infix fun MemoryStack.getSurfaceFormatsKHR(surface: VkSurfaceKHR): MutableList<SurfaceFormatKHR> =
            framed {
                val pCount = this.mInt()
                nGetSurfaceFormatsKHR(surface, pCount.adr).check()
                val count = pCount[0]
                assert(count > 0)
                val pSurfaceFormats = this.ncalloc(VkSurfaceFormatKHR.ALIGNOF, count, VkSurfaceFormatKHR.SIZEOF)
                nGetSurfaceFormatsKHR(surface, pCount.adr, pSurfaceFormats).check()
                MutableList(count) { SurfaceFormatKHR(IntPtr(pSurfaceFormats + VkSurfaceFormatKHR.SIZEOF * it)) }
            }

    infix fun getSurfaceFormatsKHR(surface: VkSurfaceKHR): MutableList<SurfaceFormatKHR> =
            stak { it getSurfaceFormatsKHR surface }

    // --- [ vkGetPhysicalDeviceSurfaceSupportKHR ] ---

    fun MemoryStack.getSurfaceSupportKHR(queueFamilySize: Int, surface: VkSurfaceKHR): BooleanArray =
            framed {
                val supported = this.mInt()
                BooleanArray(queueFamilySize) {
                    VK_CHECK_RESULT(callPJPI(adr, it, surface.L, supported.adr, capabilities.vkGetPhysicalDeviceSurfaceSupportKHR))
                    supported[0].bool
                }
            }

    fun getSurfaceSupportKHR(queueFamilySize: Int, surface: VkSurfaceKHR): BooleanArray =
            stak { it.getSurfaceSupportKHR(queueFamilySize, surface) }

    // --- [ vkGetPhysicalDeviceMemoryProperties ] ---

    val MemoryStack.memoryProperties: PhysicalDeviceMemoryProperties
        get() = framed { PhysicalDeviceMemoryProperties.read(this) { callPPV(adr, it, capabilities.vkGetPhysicalDeviceMemoryProperties) } }

    val memoryProperties: PhysicalDeviceMemoryProperties
        get() = stak { it.memoryProperties }

    // --- [ vkGetPhysicalDeviceQueueFamilyProperties ] ---

    val MemoryStack.queueFamilyProperties: Array<QueueFamilyProperties>
        get() = framed {
            val pCount = this.mInt()
            nGetQueueFamilyProperties(pCount.adr)
            val count = pCount[0]
            val pQueueFamilyProperties = this.ncalloc(VkQueueFamilyProperties.ALIGNOF, count, VkQueueFamilyProperties.SIZEOF)
            nGetQueueFamilyProperties(pCount.adr, pQueueFamilyProperties)
            Array(count) {
                QueueFamilyProperties(BytePtr(pQueueFamilyProperties + VkQueueFamilyProperties.SIZEOF * it))
            }
        }

    val queueFamilyProperties: Array<QueueFamilyProperties>
        get() = stak { it.queueFamilyProperties }

    // --- [ vkGetPhysicalDeviceSurfaceCapabilitiesKHR ] ---

    infix fun MemoryStack.getSurfaceCapabilitiesKHR(surface: VkSurfaceKHR): SurfaceCapabilitiesKHR =
            framed { SurfaceCapabilitiesKHR.read(this) { VK_CHECK_RESULT(callPJPI(adr, surface.L, it, capabilities.vkGetPhysicalDeviceSurfaceCapabilitiesKHR)) } }

    infix fun getSurfaceCapabilitiesKHR(surface: VkSurfaceKHR): SurfaceCapabilitiesKHR =
            stak { it getSurfaceCapabilitiesKHR surface }

    // --- [ vkGetPhysicalDeviceSurfacePresentModesKHR ] ---

    infix fun MemoryStack.getSurfacePresentModesKHR(surface: VkSurfaceKHR): VkPresentModeKHR_Array =
            framed {
                val pPresentModeCount = this.mInt()
                var propertyCount: Int
                var result: VkResult
                var pPresentModes = IntPtr.NULL
                do {
                    result = nGetSurfacePresentModesKHR(surface, pPresentModeCount.adr)
                    propertyCount = pPresentModeCount[0]
                    if (result == VkResult.SUCCESS && propertyCount != 0) {
                        pPresentModes = this.mInt(propertyCount)
                        nGetSurfacePresentModesKHR(surface, pPresentModeCount.adr, pPresentModes.adr).check()
                    }
                } while (result == VkResult.INCOMPLETE)
                VkPresentModeKHR_Array(propertyCount) { VkPresentModeKHR(pPresentModes[it]) }
            }

    infix fun getSurfacePresentModesKHR(surface: VkSurfaceKHR): VkPresentModeKHR_Array =
            stak { it getSurfacePresentModesKHR surface }
}

private inline fun PhysicalDevice_vk10.nEnumerateDeviceExtensionProperties(pLayerName: Ptr, pPropertyCount: IntPtr, pProperties: Ptr = NULL): VkResult =
        VkResult(callPPPPI(adr, pLayerName, pPropertyCount.adr, pProperties, capabilities.vkEnumerateDeviceExtensionProperties))

private inline fun PhysicalDevice_vk10.nEnumerateDeviceLayerProperties(pPropertyCount: IntPtr, pProperties: Ptr = NULL): VkResult =
        VkResult(callPPPI(adr, pPropertyCount.adr, pProperties, capabilities.vkEnumerateDeviceLayerProperties))

private inline fun PhysicalDevice_vk10.nGetSparseImageFormatProperties(format: VkFormat, type: VkImageType, samples: VkSampleCount, usage: VkImageUsageFlags, tiling: VkImageTiling, pPropertyCount: IntPtr, pProperties: Ptr = NULL) =
        callPPPV(adr, format.i, type.i, samples.i, usage, tiling.i, pPropertyCount.adr, pProperties, capabilities.vkGetPhysicalDeviceSparseImageFormatProperties)

private inline fun PhysicalDevice_vk10.nGetSurfaceFormatsKHR(surface: VkSurfaceKHR, pSurfaceFormatCount: Ptr, pSurfaceFormats: Ptr = NULL): VkResult =
        VkResult(callPJPPI(adr, surface.L, pSurfaceFormatCount, pSurfaceFormats, capabilities.vkGetPhysicalDeviceSurfaceFormatsKHR))

private inline fun PhysicalDevice_vk10.nGetQueueFamilyProperties(pQueueFamilyPropertyCount: Ptr, pQueueFamilyProperties: Ptr = NULL) =
        callPPPV(adr, pQueueFamilyPropertyCount, pQueueFamilyProperties, capabilities.vkGetPhysicalDeviceQueueFamilyProperties)

private inline fun PhysicalDevice_vk10.nGetSurfacePresentModesKHR(surface: VkSurfaceKHR, pPresentModeCount: Ptr, pPresentModes: Ptr = NULL): VkResult =
        VkResult(callPJPPI(adr, surface.L, pPresentModeCount, pPresentModes, capabilities.vkGetPhysicalDeviceSurfacePresentModesKHR))