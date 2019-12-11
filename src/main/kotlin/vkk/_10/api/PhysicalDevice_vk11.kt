package vkk._10.api

import identifiers.CapabilitiesInstance
import kool.*
import org.lwjgl.system.JNI.*
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.system.Pointer
import org.lwjgl.vulkan.VkQueueFamilyProperties2
import org.lwjgl.vulkan.VkSparseImageFormatProperties2
import vkk.VK_CHECK_RESULT
import vkk.VkFormat
import vkk._11.structs.*
import vkk.framed
import vkk.stak

interface PhysicalDevice_vk11 : Pointer {

    val capabilities: CapabilitiesInstance

    // --- [ vkGetPhysicalDeviceExternalBufferProperties ] ---

    infix fun MemoryStack.getExternalBufferProperties(externalBufferInfo: PhysicalDeviceExternalBufferInfo): ExternalBufferProperties =
            framed { ExternalBufferProperties.read(this) { callPPPV(adr, externalBufferInfo write this, it, capabilities.vkGetPhysicalDeviceExternalBufferProperties) } }

    infix fun getExternalBufferProperties(externalBufferInfo: PhysicalDeviceExternalBufferInfo): ExternalBufferProperties =
            stak { it getExternalBufferProperties externalBufferInfo }

    // --- [ vkGetPhysicalDeviceExternalFenceProperties ] ---

    infix fun MemoryStack.getExternalFenceProperties(externalFenceInfo: PhysicalDeviceExternalFenceInfo): ExternalFenceProperties =
            framed { ExternalFenceProperties.read(this) { callPPPV(adr, externalFenceInfo write this, it, capabilities.vkGetPhysicalDeviceExternalFenceProperties) } }

    infix fun getExternalFenceProperties(externalFenceInfo: PhysicalDeviceExternalFenceInfo): ExternalFenceProperties =
            stak { it getExternalFenceProperties externalFenceInfo }

    // --- [ vkGetPhysicalDeviceExternalSemaphoreProperties ] ---

    infix fun MemoryStack.getExternalSemaphoreProperties(externalSemaphoreInfo: PhysicalDeviceExternalSemaphoreInfo): ExternalSemaphoreProperties =
            framed { ExternalSemaphoreProperties.read(this) { callPPPV(adr, externalSemaphoreInfo write this, it, capabilities.vkGetPhysicalDeviceExternalSemaphoreProperties) } }

    infix fun getExternalSemaphoreProperties(externalSemaphoreInfo: PhysicalDeviceExternalSemaphoreInfo): ExternalSemaphoreProperties =
            stak { it getExternalSemaphoreProperties externalSemaphoreInfo }

    // --- [ vkGetPhysicalDeviceFeatures2 ] ---

    val MemoryStack.features2: PhysicalDeviceFeatures2
        get() = framed { PhysicalDeviceFeatures2.read(this) { callPPV(adr, it, capabilities.vkGetPhysicalDeviceFeatures2) } }

    val features2: PhysicalDeviceFeatures2
        get() = stak { it.features2 }

    // --- [ vkGetPhysicalDeviceFormatProperties2 ] ---

    infix fun MemoryStack.getFormatProperties2(format: VkFormat): FormatProperties2 =
            framed { FormatProperties2.read(this) { callPPV(adr, format.i, it, capabilities.vkGetPhysicalDeviceFormatProperties2) } }

    infix fun getFormatProperties2(format: VkFormat): FormatProperties2 =
            stak { it getFormatProperties2 format }

    // --- [ vkGetPhysicalDeviceImageFormatProperties2 ] ---

    infix fun MemoryStack.getImageFormatProperties2(imageFormatInfo: PhysicalDeviceImageFormatInfo2): ImageFormatProperties2 =
            framed { ImageFormatProperties2.read(this) { VK_CHECK_RESULT(callPPPI(adr, imageFormatInfo write this, it, capabilities.vkGetPhysicalDeviceImageFormatProperties2)) } }

    infix fun getImageFormatProperties2(imageFormatInfo: PhysicalDeviceImageFormatInfo2): ImageFormatProperties2 =
            stak { it getImageFormatProperties2 imageFormatInfo }

    // --- [ vkGetPhysicalDeviceMemoryProperties2 ] ---

    val MemoryStack.memoryProperties2: PhysicalDeviceMemoryProperties2
        get() = framed { PhysicalDeviceMemoryProperties2.read(this) { callPPV(adr, it, capabilities.vkGetPhysicalDeviceMemoryProperties2) } }

    val memoryProperties2: PhysicalDeviceMemoryProperties2
        get() = stak { it.memoryProperties2 }

    // --- [ vkGetPhysicalDeviceProperties2 ] ---

    val MemoryStack.properties2: PhysicalDeviceProperties2
        get() = framed { PhysicalDeviceProperties2.read(this) { callPPV(adr, it, capabilities.vkGetPhysicalDeviceProperties2) } }

    val properties2: PhysicalDeviceProperties2
        get() = stak { it.properties2 }

    // --- [ vkGetPhysicalDeviceQueueFamilyProperties2 ] ---

    val MemoryStack.queueFamilyProperties2: Array<QueueFamilyProperties2>
        get() = framed {
            val pQueueFamilyPropertyCount = this.mInt()
            nGetQueueFamilyProperties2(pQueueFamilyPropertyCount)
            val queueFamilyPropertyCount = pQueueFamilyPropertyCount[0]
            val queueFamilyProperties = this.ncalloc(VkQueueFamilyProperties2.ALIGNOF, queueFamilyPropertyCount, VkQueueFamilyProperties2.SIZEOF)
            nGetQueueFamilyProperties2(pQueueFamilyPropertyCount, queueFamilyProperties)
            Array(queueFamilyPropertyCount) {
                QueueFamilyProperties2(BytePtr(queueFamilyProperties + it * VkQueueFamilyProperties2.SIZEOF))
            }
        }

    val queueFamilyProperties2: Array<QueueFamilyProperties2>
        get() = stak { it.queueFamilyProperties2 }

    // --- [ vkGetPhysicalDeviceSparseImageFormatProperties2 ] ---

    infix fun MemoryStack.getSparseImageFormatProperties2(formatInfo: PhysicalDeviceSparseImageFormatInfo2): Array<SparseImageFormatProperties2> =
            framed {
                val pPropertyCount = this.mInt()
                val pFormatInfo = formatInfo write this
                nGetSparseImageFormatProperties2(pFormatInfo, pPropertyCount)
                val propertyCount = pPropertyCount[0]
                val properties = this.ncalloc(VkSparseImageFormatProperties2.ALIGNOF, propertyCount, VkSparseImageFormatProperties2.SIZEOF)
                nGetSparseImageFormatProperties2(pFormatInfo, pPropertyCount, properties)
                Array(propertyCount) {
                    SparseImageFormatProperties2(BytePtr(properties + it * VkSparseImageFormatProperties2.SIZEOF))
                }
            }

    fun getSparseImageFormatProperties2(formatInfo: PhysicalDeviceSparseImageFormatInfo2): Array<SparseImageFormatProperties2> =
            stak { it getSparseImageFormatProperties2 formatInfo }
}

private inline fun PhysicalDevice_vk11.nGetQueueFamilyProperties2(pQueueFamilyPropertyCount: IntPtr, pQueueFamilyProperties: Ptr = NULL) =
        callPPPV(adr, pQueueFamilyPropertyCount.adr, pQueueFamilyProperties, capabilities.vkGetPhysicalDeviceQueueFamilyProperties2)

private inline fun PhysicalDevice_vk11.nGetSparseImageFormatProperties2(pFormatInfo: Ptr, pPropertyCount: IntPtr, pProperties: Ptr = NULL) =
        callPPPPV(adr, pFormatInfo, pPropertyCount.adr, pProperties, capabilities.vkGetPhysicalDeviceSparseImageFormatProperties2)