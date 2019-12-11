package vkk._10.api

import identifiers.CapabilitiesInstance
import kool.*
import org.lwjgl.system.JNI.*
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.Pointer
import org.lwjgl.vulkan.VkExtensionProperties
import org.lwjgl.vulkan.VkLayerProperties
import vkk.*
import vkk._10.structs.*

interface PhysicalDevice_vk10 : Pointer {

    val capabilities: CapabilitiesInstance

    // --- [ vkEnumerateDeviceExtensionProperties ] ---

    fun MemoryStack.enumerateDeviceExtensionProperties(layerName: String? = null): Array<ExtensionProperties> =
            framed {
                val pLayerName = layerName?.let { this.utf8Adr(it) } ?: MemoryUtil.NULL
                var properties: Ptr = MemoryUtil.NULL
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
                return Array(propertyCount) {
                    ExtensionProperties(BytePtr(properties + it * VkExtensionProperties.SIZEOF))
                }
            }

    fun enumerateDeviceExtensionProperties(layerName: String? = null): Array<ExtensionProperties> =
            stak { it.enumerateDeviceExtensionProperties(layerName) }

    // --- [ vkEnumerateDeviceLayerProperties ] ---

    fun MemoryStack.enumerateDeviceLayerProperties(): Array<LayerProperties> = framed {
        var properties: Ptr = MemoryUtil.NULL
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
        return Array(propertyCount) {
            LayerProperties(BytePtr(properties + it * VkLayerProperties.SIZEOF))
        }
    }

    fun enumerateDeviceLayerProperties(): Array<LayerProperties> =
            stak { it.enumerateDeviceLayerProperties() }

    // --- [ vkGetPhysicalDeviceFeatures ] ---

    val MemoryStack.features: PhysicalDeviceFeatures
        get() = PhysicalDeviceFeatures.read(this) { nGetFeatures(it) }

    val features: PhysicalDeviceFeatures
        get() = stak { it.features }

    // --- [ vkGetPhysicalDeviceFormatProperties ] ---

    infix fun MemoryStack.getFormatProperties(format: VkFormat): FormatProperties =
            framed { FormatProperties.read(this) { nGetFormatProperties(format, it) } }

    infix fun getFormatProperties(format: VkFormat): FormatProperties =
            stak { it getFormatProperties format }

    // --- [ vkGetPhysicalDeviceImageFormatProperties ] ---

    fun MemoryStack.getImageFormatProperties(format: VkFormat, type: VkImageType, tiling: VkImageTiling, usage: VkImageUsageFlags, flags: VkImageCreateFlags): ImageFormatProperties =
            framed { ImageFormatProperties.read(this) { nGetImageFormatProperties(format, type, tiling, usage, flags, it) } }

    fun getImageFormatProperties(format: VkFormat, type: VkImageType, tiling: VkImageTiling, usage: VkImageUsageFlags, flags: VkImageCreateFlags): ImageFormatProperties =
            stak { it.getImageFormatProperties(format, type, tiling, usage, flags) }

    // --- [ vkGetPhysicalDeviceProperties ] ---

    val MemoryStack.properties: PhysicalDeviceProperties
        get() = framed { PhysicalDeviceProperties.read(this) { nGetProperties(it) } }

    val properties: PhysicalDeviceProperties
        get() = stak { it.properties }
}

private inline fun PhysicalDevice_vk10.nEnumerateDeviceExtensionProperties(pLayerName: Ptr, pPropertyCount: IntPtr, pProperties: Ptr = MemoryUtil.NULL): VkResult =
        VkResult(callPPPPI(adr, pLayerName, pPropertyCount.adr, pProperties, capabilities.vkEnumerateDeviceExtensionProperties))

private inline fun PhysicalDevice_vk10.nEnumerateDeviceLayerProperties(pPropertyCount: IntPtr, pProperties: Ptr = MemoryUtil.NULL): VkResult =
        VkResult(callPPPI(adr, pPropertyCount.adr, pProperties, capabilities.vkEnumerateDeviceLayerProperties))

private inline infix fun PhysicalDevice_vk10.nGetFeatures(pFeatures: Adr) =
        callPPV(adr, pFeatures, capabilities.vkGetPhysicalDeviceFeatures)

private inline fun PhysicalDevice_vk10.nGetFormatProperties(format: VkFormat, pProperties: Adr) =
        callPPV(adr, format.i, pProperties, capabilities.vkGetPhysicalDeviceFormatProperties)

private inline fun PhysicalDevice_vk10.nGetImageFormatProperties(format: VkFormat, type: VkImageType, tiling: VkImageTiling, usage: VkImageUsageFlags, flags: VkImageCreateFlags, pProperties: Adr) =
        callPPI(adr, format.i, type.i, tiling.i, usage, flags, pProperties, capabilities.vkGetPhysicalDeviceImageFormatProperties)

private inline fun PhysicalDevice_vk10.nGetProperties(pProperties: Adr) =
    callPPV(adr, pProperties, capabilities.vkGetPhysicalDeviceProperties)