package vkk.vk11

import kool.*
import org.lwjgl.system.JNI.*
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.vulkan.VkPhysicalDeviceGroupProperties
import org.lwjgl.vulkan.VkQueueFamilyProperties2
import org.lwjgl.vulkan.VkSparseImageFormatProperties2
import org.lwjgl.vulkan.VkSparseImageMemoryRequirements2
import vkk.*
import vkk.vk11.structs.*
import vkk.entities.VkDescriptorUpdateTemplate
import vkk.entities.VkSamplerYcbcrConversion
import vkk.identifiers.*
import vkk.vk10.structs.DescriptorSetLayoutCreateInfo

interface VkStack_VK11 : VkStackInterface {

    // --- [ vkEnumerateInstanceVersion ] ---
    val vk.instanceVersion: Int
        get() = stack.intAdr { VK_CHECK_RESULT(callPI(it, VK.globalCommands!!.vkEnumerateInstanceVersion)) }

    // --- [ vkBindBufferMemory2 ] ---

    infix fun Device.bindBufferMemory2(bindInfos: Array<BindBufferMemoryInfo>): VkResult =
            stack { VkResult(callPPI(adr, bindInfos.size, bindInfos write stack, capabilities.vkBindBufferMemory2)).andCheck() }

    infix fun Device.bindBufferMemory2(bindInfo: BindBufferMemoryInfo): VkResult =
            stack { VkResult(callPPI(adr, 1, bindInfo write stack, capabilities.vkBindBufferMemory2)).andCheck() }

    // --- [ vkBindImageMemory2 ] ---

    infix fun Device.bindImageMemory2(bindInfos: Array<BindImageMemoryInfo>): VkResult =
            stack { VkResult(callPPI(adr, bindInfos.size, bindInfos write stack, capabilities.vkBindImageMemory2)).andCheck() }

    infix fun Device.bindImageMemory2(bindInfo: BindImageMemoryInfo): VkResult =
            stack { VkResult(callPPI(adr, 1, bindInfo write stack, capabilities.vkBindImageMemory2)).andCheck() }

    // --- [ vkGetDeviceGroupPeerMemoryFeatures ] ---
    fun Device.getGroupPeerMemoryFeatures(heapIndex: Int, localDeviceIndex: Int, remoteDeviceIndex: Int): VkPeerMemoryFeatureFlags =
            stack.intAdr { callPPV(adr, heapIndex, localDeviceIndex, remoteDeviceIndex, it, capabilities.vkGetDeviceGroupPeerMemoryFeatures) }

    // --- [ vkEnumeratePhysicalDeviceGroups ] ---
    val Instance.physicalDeviceGroups: Array<PhysicalDeviceGroupProperties>
        get() = stack {
            var properties: Ptr = NULL
            var count: Int
            val pCount = stack.mInt()
            var result: VkResult
            do {
                result = VkResult(callPPPI(adr, pCount.adr, properties, capabilities.vkEnumeratePhysicalDeviceGroups))
                count = pCount()
                if (result == VkResult.SUCCESS && count != 0) {
                    properties = stack.ncalloc(VkPhysicalDeviceGroupProperties.ALIGNOF, count, VkPhysicalDeviceGroupProperties.SIZEOF)
                    result = VkResult(callPPPI(adr, pCount.adr, properties, capabilities.vkEnumeratePhysicalDeviceGroups))
                }
            } while (result == VkResult.INCOMPLETE)
            assert(properties != NULL) // TODO others
            Array(count) { PhysicalDeviceGroupProperties(properties + it * VkPhysicalDeviceGroupProperties.SIZEOF, this) }
        }

    // --- [ vkGetImageMemoryRequirements2 ] ---
    infix fun Device.getImageMemoryRequirements2(info: ImageMemoryRequirementsInfo2): MemoryRequirements2 =
            MemoryRequirements2.read(stack) { callPPPV(adr, info write stack, it, capabilities.vkGetImageMemoryRequirements2) }

    // --- [ vkGetBufferMemoryRequirements2 ] ---
    infix fun Device.getBufferMemoryRequirements2(info: BufferMemoryRequirementsInfo2): MemoryRequirements2 =
            MemoryRequirements2.read(stack) { callPPPV(adr, info write stack, it, capabilities.vkGetBufferMemoryRequirements2) }

    // --- [ vkGetImageSparseMemoryRequirements2 ] ---
    infix fun Device.getImageSparseMemoryRequirements2(info: ImageSparseMemoryRequirementsInfo2): Array<SparseImageMemoryRequirements2> =
            stack {
                val pCount = stack.mInt()
                val pInfo = info write stack
                callPPPPV(adr, pInfo, pCount.adr, NULL, capabilities.vkGetImageSparseMemoryRequirements2)
                val count = pCount()
                val requirements = stack.ncalloc(VkSparseImageMemoryRequirements2.ALIGNOF, count, VkSparseImageMemoryRequirements2.SIZEOF)
                callPPPPV(adr, pInfo, pCount.adr, requirements, capabilities.vkGetImageSparseMemoryRequirements2)
                Array(count) { SparseImageMemoryRequirements2(BytePtr(requirements + it * VkSparseImageMemoryRequirements2.SIZEOF)) }
            }

    // --- [ vkGetPhysicalDeviceFeatures2 ] ---
    val PhysicalDevice.features2: PhysicalDeviceFeatures2
        get() = PhysicalDeviceFeatures2.read(stack) { callPPV(adr, it, capabilities.vkGetPhysicalDeviceFeatures2) }

    // --- [ vkGetPhysicalDeviceProperties2 ] ---
    val PhysicalDevice.properties2: PhysicalDeviceProperties2
        get() = PhysicalDeviceProperties2.read(stack) { callPPV(adr, it, capabilities.vkGetPhysicalDeviceProperties2) }

    // --- [ vkGetPhysicalDeviceFormatProperties2 ] ---
    infix fun PhysicalDevice.getFormatProperties2(format: VkFormat): FormatProperties2 =
            FormatProperties2.read(stack) { callPPV(adr, format.i, it, capabilities.vkGetPhysicalDeviceFormatProperties2) }

    // --- [ vkGetPhysicalDeviceImageFormatProperties2 ] ---
    infix fun PhysicalDevice.getImageFormatProperties2(imageFormatInfo: PhysicalDeviceImageFormatInfo2): ImageFormatProperties2 =
            ImageFormatProperties2.read(stack) { VK_CHECK_RESULT(callPPPI(adr, imageFormatInfo write stack, it, capabilities.vkGetPhysicalDeviceImageFormatProperties2)) }

    // --- [ vkGetPhysicalDeviceQueueFamilyProperties2 ] ---
    val PhysicalDevice.queueFamilyProperties2: Array<QueueFamilyProperties2>
        get() = stack {
            val pCount = stack.mInt()
            callPPPV(adr, pCount.adr, NULL, capabilities.vkGetPhysicalDeviceQueueFamilyProperties2)
            val count = pCount()
            val props = stack.ncalloc(VkQueueFamilyProperties2.ALIGNOF, count, VkQueueFamilyProperties2.SIZEOF)
            callPPPV(adr, pCount.adr, props, capabilities.vkGetPhysicalDeviceQueueFamilyProperties2)
            Array(count) { QueueFamilyProperties2(BytePtr(props + it * VkQueueFamilyProperties2.SIZEOF)) }
        }

    // --- [ vkGetPhysicalDeviceMemoryProperties2 ] ---
    val PhysicalDevice.memoryProperties2: PhysicalDeviceMemoryProperties2
        get() = PhysicalDeviceMemoryProperties2.read(stack) { callPPV(adr, it, capabilities.vkGetPhysicalDeviceMemoryProperties2) }

    // --- [ vkGetPhysicalDeviceSparseImageFormatProperties2 ] ---
    infix fun PhysicalDevice.getSparseImageFormatProperties2(formatInfo: PhysicalDeviceSparseImageFormatInfo2): Array<SparseImageFormatProperties2> =
            stack {
                val pCount = stack.mInt()
                val pFormatInfo = formatInfo write stack
                callPPPPV(adr, pFormatInfo, pCount.adr, NULL, capabilities.vkGetPhysicalDeviceSparseImageFormatProperties2)
                val count = pCount()
                val props = stack.ncalloc(VkSparseImageFormatProperties2.ALIGNOF, count, VkSparseImageFormatProperties2.SIZEOF)
                callPPPPV(adr, pFormatInfo, pCount.adr, props, capabilities.vkGetPhysicalDeviceSparseImageFormatProperties2)
                Array(count) { SparseImageFormatProperties2(BytePtr(props + it * VkSparseImageFormatProperties2.SIZEOF)) }
            }

    // --- [ vkGetDeviceQueue2 ] ---
    infix fun Device.getQueue2(queueInfo: DeviceQueueInfo2): Queue =
            Queue(stack.longAdr { callPPPV(adr, queueInfo write stack, it, capabilities.vkGetDeviceQueue2) }, this)

    // --- [ vkCreateSamplerYcbcrConversion ] ---
    infix fun Device.createSamplerYcbcrConversion(createInfo: SamplerYcbcrConversionCreateInfo): VkSamplerYcbcrConversion =
            VkSamplerYcbcrConversion(stack.longAdr { callPPPPI(adr, createInfo write stack, NULL, it, capabilities.vkCreateSamplerYcbcrConversion) })

    // --- [ vkCreateDescriptorUpdateTemplate ] ---
    infix fun Device.createDescriptorUpdateTemplate(createInfo: DescriptorUpdateTemplateCreateInfo): VkDescriptorUpdateTemplate =
            VkDescriptorUpdateTemplate(stack.longAdr { callPPPPI(adr, createInfo write stack, NULL, it, capabilities.vkCreateDescriptorUpdateTemplate) })

    // --- [ vkGetPhysicalDeviceExternalBufferProperties ] ---
    infix fun PhysicalDevice.getExternalBufferProperties(externalBufferInfo: PhysicalDeviceExternalBufferInfo): ExternalBufferProperties =
            ExternalBufferProperties.read(stack) { callPPPV(adr, externalBufferInfo write stack, it, capabilities.vkGetPhysicalDeviceExternalBufferProperties) }

    // --- [ vkGetPhysicalDeviceExternalFenceProperties ] ---
    infix fun PhysicalDevice.getExternalFenceProperties(externalFenceInfo: PhysicalDeviceExternalFenceInfo): ExternalFenceProperties =
            ExternalFenceProperties.read(stack) { callPPPV(adr, externalFenceInfo write stack, it, capabilities.vkGetPhysicalDeviceExternalFenceProperties) }

    // --- [ vkGetPhysicalDeviceExternalSemaphoreProperties ] ---
    infix fun PhysicalDevice.getExternalSemaphoreProperties(externalSemaphoreInfo: PhysicalDeviceExternalSemaphoreInfo): ExternalSemaphoreProperties =
            ExternalSemaphoreProperties.read(stack) { callPPPV(adr, externalSemaphoreInfo write stack, it, capabilities.vkGetPhysicalDeviceExternalSemaphoreProperties) }

    // --- [ vkGetDescriptorSetLayoutSupport ] ---
    infix fun Device.getDescriptorSetLayoutSupport(createInfo: DescriptorSetLayoutCreateInfo): DescriptorSetLayoutSupport =
            DescriptorSetLayoutSupport.read(stack) { callPPPV(adr, createInfo write stack, it, capabilities.vkGetDescriptorSetLayoutSupport) }
}

// --- [ vkEnumerateInstanceVersion ] ---
val vk.instanceVersion: Int
    get() = VkStack { it.run { vk.instanceVersion } }

// --- [ vkBindBufferMemory2 ] ---

infix fun Device.bindBufferMemory2(bindInfos: Array<BindBufferMemoryInfo>): VkResult =
        VkStack { it.run { bindBufferMemory2(bindInfos) } }

infix fun Device.bindBufferMemory2(bindInfo: BindBufferMemoryInfo): VkResult =
        VkStack { it.run { bindBufferMemory2(bindInfo) } }

// --- [ vkBindImageMemory2 ] ---

infix fun Device.bindImageMemory2(bindInfos: Array<BindImageMemoryInfo>): VkResult =
        VkStack { it.run { bindImageMemory2(bindInfos) } }

infix fun Device.bindImageMemory2(bindInfo: BindImageMemoryInfo): VkResult =
        VkStack { it.run { bindImageMemory2(bindInfo) } }

// --- [ vkGetDeviceGroupPeerMemoryFeatures ] ---
fun Device.getGroupPeerMemoryFeatures(heapIndex: Int, localDeviceIndex: Int, remoteDeviceIndex: Int): VkPeerMemoryFeatureFlags =
        VkStack { it.run { getGroupPeerMemoryFeatures(heapIndex, localDeviceIndex, remoteDeviceIndex) } }

// --- [ vkEnumeratePhysicalDeviceGroups ] ---
val Instance.physicalDeviceGroups: Array<PhysicalDeviceGroupProperties>
    get() = VkStack { it.run { physicalDeviceGroups } }

// --- [ vkGetImageMemoryRequirements2 ] ---
infix fun Device.getImageMemoryRequirements2(info: ImageMemoryRequirementsInfo2): MemoryRequirements2 =
        VkStack { it.run { getImageMemoryRequirements2(info) } }

// --- [ vkGetBufferMemoryRequirements2 ] ---
infix fun Device.getBufferMemoryRequirements2(info: BufferMemoryRequirementsInfo2): MemoryRequirements2 =
        VkStack { it.run { getBufferMemoryRequirements2(info) } }

// --- [ vkGetImageSparseMemoryRequirements2 ] ---
infix fun Device.getImageSparseMemoryRequirements2(info: ImageSparseMemoryRequirementsInfo2): Array<SparseImageMemoryRequirements2> =
        VkStack { it.run { getImageSparseMemoryRequirements2(info) } }

// --- [ vkGetPhysicalDeviceFeatures2 ] ---
val PhysicalDevice.features2: PhysicalDeviceFeatures2
    get() = VkStack { it.run { features2 } }

// --- [ vkGetPhysicalDeviceProperties2 ] ---
val PhysicalDevice.properties2: PhysicalDeviceProperties2
    get() = VkStack { it.run { properties2 } }

// --- [ vkGetPhysicalDeviceFormatProperties2 ] ---
infix fun PhysicalDevice.getFormatProperties2(format: VkFormat): FormatProperties2 =
        VkStack { it.run { getFormatProperties2(format) } }

// --- [ vkGetPhysicalDeviceImageFormatProperties2 ] ---
infix fun PhysicalDevice.getImageFormatProperties2(imageFormatInfo: PhysicalDeviceImageFormatInfo2): ImageFormatProperties2 =
        VkStack { it.run { getImageFormatProperties2(imageFormatInfo) } }

// --- [ vkGetPhysicalDeviceQueueFamilyProperties2 ] ---
val PhysicalDevice.queueFamilyProperties2: Array<QueueFamilyProperties2>
    get() = VkStack { it.run { queueFamilyProperties2 } }

// --- [ vkGetPhysicalDeviceMemoryProperties2 ] ---
val PhysicalDevice.memoryProperties2: PhysicalDeviceMemoryProperties2
    get() = VkStack { it.run { memoryProperties2 } }

// --- [ vkGetPhysicalDeviceSparseImageFormatProperties2 ] ---
infix fun PhysicalDevice.getSparseImageFormatProperties2(formatInfo: PhysicalDeviceSparseImageFormatInfo2): Array<SparseImageFormatProperties2> =
        VkStack { it.run { getSparseImageFormatProperties2(formatInfo) }}

// --- [ vkGetDeviceQueue2 ] ---
infix fun Device.getQueue2(queueInfo: DeviceQueueInfo2): Queue =
        VkStack { it.run { getQueue2(queueInfo) } }

// --- [ vkCreateSamplerYcbcrConversion ] ---
infix fun Device.createSamplerYcbcrConversion(createInfo: SamplerYcbcrConversionCreateInfo): VkSamplerYcbcrConversion =
        VkStack { it.run { createSamplerYcbcrConversion(createInfo) } }

// --- [ vkCreateDescriptorUpdateTemplate ] ---
infix fun Device.createDescriptorUpdateTemplate(createInfo: DescriptorUpdateTemplateCreateInfo): VkDescriptorUpdateTemplate =
        VkStack { it.run { createDescriptorUpdateTemplate(createInfo) } }

// --- [ vkGetPhysicalDeviceExternalBufferProperties ] ---
infix fun PhysicalDevice.getExternalBufferProperties(externalBufferInfo: PhysicalDeviceExternalBufferInfo): ExternalBufferProperties =
        VkStack { it.run { getExternalBufferProperties(externalBufferInfo) } }

// --- [ vkGetPhysicalDeviceExternalFenceProperties ] ---
infix fun PhysicalDevice.getExternalFenceProperties(externalFenceInfo: PhysicalDeviceExternalFenceInfo): ExternalFenceProperties =
        VkStack { it.run { getExternalFenceProperties(externalFenceInfo) } }

// --- [ vkGetPhysicalDeviceExternalSemaphoreProperties ] ---
infix fun PhysicalDevice.getExternalSemaphoreProperties(externalSemaphoreInfo: PhysicalDeviceExternalSemaphoreInfo): ExternalSemaphoreProperties =
        VkStack { it.run { getExternalSemaphoreProperties(externalSemaphoreInfo) } }