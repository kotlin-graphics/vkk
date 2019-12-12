package vkk._11.api

import identifiers.CapabilitiesDevice
import kool.*
import org.lwjgl.system.JNI.*
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.system.Pointer
import org.lwjgl.vulkan.VkSparseImageMemoryRequirements2
import vkk.*
import vkk._10.structs.DescriptorSetLayoutCreateInfo
import vkk._11.structs.*
import vkk.entities.VkCommandPool
import vkk.entities.VkDescriptorSet
import vkk.entities.VkDescriptorUpdateTemplate
import vkk.entities.VkSamplerYcbcrConversion

interface Device_vk11 : Pointer {

    val capabilities: CapabilitiesDevice

    // --- [ vkBindBufferMemory2 ] ---

    infix fun MemoryStack.bindBufferMemory2(bindInfos: Array<BindBufferMemoryInfo>): VkResult =
            framed { nBindBufferMemory2(bindInfos.size, bindInfos write this).apply { check() } }

    infix fun bindBufferMemory2(bindInfos: Array<BindBufferMemoryInfo>): VkResult =
            stak { it bindBufferMemory2 bindInfos }


    infix fun MemoryStack.bindBufferMemory2(bindInfo: BindBufferMemoryInfo): VkResult =
            framed { nBindBufferMemory2(1, bindInfo write this).apply { check() } }

    infix fun bindBufferMemory2(bindInfo: BindBufferMemoryInfo): VkResult =
            stak { it bindBufferMemory2 bindInfo }

    // --- [ vkBindImageMemory2 ] ---

    infix fun MemoryStack.bindImageMemory2(bindInfos: Array<BindImageMemoryInfo>): VkResult =
            framed { nBindImageMemory2(bindInfos.size, bindInfos write this).apply { check() } }

    infix fun bindImageMemory2(bindInfos: Array<BindImageMemoryInfo>): VkResult =
            stak { it bindImageMemory2 bindInfos }


    infix fun MemoryStack.bindImageMemory2(bindInfo: BindImageMemoryInfo): VkResult =
            framed { nBindImageMemory2(1, bindInfo write this).apply { check() } }

    infix fun bindImageMemory2(bindInfo: BindImageMemoryInfo): VkResult =
            stak { it bindImageMemory2 bindInfo }

    // --- [ vkCreateDescriptorUpdateTemplate ] ---

    infix fun MemoryStack.createDescriptorUpdateTemplate(createInfo: DescriptorUpdateTemplateCreateInfo): VkDescriptorUpdateTemplate =
            framed { VkDescriptorUpdateTemplate(this.longAdr { callPPPPI(adr, createInfo write this, NULL, it, capabilities.vkCreateDescriptorUpdateTemplate) }) }

    infix fun createDescriptorUpdateTemplate(createInfo: DescriptorUpdateTemplateCreateInfo): VkDescriptorUpdateTemplate =
            stak { it createDescriptorUpdateTemplate createInfo }

    // --- [ vkCreateSamplerYcbcrConversion ] ---

    infix fun MemoryStack.createSamplerYcbcrConversion(createInfo: SamplerYcbcrConversionCreateInfo): VkSamplerYcbcrConversion =
            framed { VkSamplerYcbcrConversion(this.longAdr { callPPPPI(adr, createInfo write this, NULL, it, capabilities.vkCreateSamplerYcbcrConversion) }) }

    infix fun createSamplerYcbcrConversion(createInfo: SamplerYcbcrConversionCreateInfo): VkSamplerYcbcrConversion =
            stak { it createSamplerYcbcrConversion createInfo }

    // --- [ vkDestroyDescriptorUpdateTemplate ] ---
    infix fun destroy(descriptorUpdateTemplate: VkDescriptorUpdateTemplate) =
            callPJPV(adr, descriptorUpdateTemplate.L, NULL, capabilities.vkDestroyDescriptorUpdateTemplate)

    // --- [ vkDestroySamplerYcbcrConversion ] ---
    infix fun destroy(ycbcrConversion: VkSamplerYcbcrConversion) =
            callPJPV(adr, ycbcrConversion.L, NULL, capabilities.vkDestroySamplerYcbcrConversion)

    // --- [ vkGetDescriptorSetLayoutSupport ] ---

    infix fun MemoryStack.getDescriptorSetLayoutSupport(createInfo: DescriptorSetLayoutCreateInfo): DescriptorSetLayoutSupport =
            framed { DescriptorSetLayoutSupport.read(this) { callPPPV(adr, createInfo write this, it, capabilities.vkGetDescriptorSetLayoutSupport) } }

    infix fun getDescriptorSetLayoutSupport(createInfo: DescriptorSetLayoutCreateInfo): DescriptorSetLayoutSupport =
            stak { it getDescriptorSetLayoutSupport createInfo }

    // --- [ vkGetDeviceGroupPeerMemoryFeatures ] ---

    fun MemoryStack.getGroupPeerMemoryFeatures(heapIndex: Int, localDeviceIndex: Int, remoteDeviceIndex: Int): VkPeerMemoryFeatureFlags =
            framed { this.intAdr { callPPV(adr, heapIndex, localDeviceIndex, remoteDeviceIndex, it, capabilities.vkGetDeviceGroupPeerMemoryFeatures) } }

    fun getGroupPeerMemoryFeatures(heapIndex: Int, localDeviceIndex: Int, remoteDeviceIndex: Int): VkPeerMemoryFeatureFlags =
            stak { it.getGroupPeerMemoryFeatures(heapIndex, localDeviceIndex, remoteDeviceIndex) }

    // --- [ vkGetImageMemoryRequirements2 ] ---

    infix fun MemoryStack.getImageMemoryRequirements2(info: ImageMemoryRequirementsInfo2): MemoryRequirements2 =
            framed { MemoryRequirements2.read(this) { callPPPV(adr, info write this, it, capabilities.vkGetImageMemoryRequirements2) } }

    infix fun getImageMemoryRequirements2(info: ImageMemoryRequirementsInfo2): MemoryRequirements2 =
            stak { it getImageMemoryRequirements2 info }

    // --- [ vkGetBufferMemoryRequirements2 ] ---

    infix fun MemoryStack.getBufferMemoryRequirements2(info: BufferMemoryRequirementsInfo2): MemoryRequirements2 =
            framed { MemoryRequirements2.read(this) { callPPPV(adr, info write this, it, capabilities.vkGetBufferMemoryRequirements2) } }

    infix fun getBufferMemoryRequirements2(info: BufferMemoryRequirementsInfo2): MemoryRequirements2 =
            stak { it getBufferMemoryRequirements2 info }

    // --- [ vkGetImageSparseMemoryRequirements2 ] ---

    infix fun MemoryStack.getImageSparseMemoryRequirements2(info: ImageSparseMemoryRequirementsInfo2): Array<SparseImageMemoryRequirements2> =
            framed {
                val pSparseMemoryRequirementCount = this.mInt()
                val pInfo = info write this
                nGetImageSparseMemoryRequirements2(pInfo, pSparseMemoryRequirementCount)
                val sparseMemoryRequirementCount = pSparseMemoryRequirementCount[0]
                val sparseMemoryRequirements = this.ncalloc(VkSparseImageMemoryRequirements2.ALIGNOF, sparseMemoryRequirementCount, VkSparseImageMemoryRequirements2.SIZEOF)
                nGetImageSparseMemoryRequirements2(pInfo, pSparseMemoryRequirementCount, sparseMemoryRequirements)
                Array(sparseMemoryRequirementCount) {
                    SparseImageMemoryRequirements2(BytePtr(sparseMemoryRequirements + it * VkSparseImageMemoryRequirements2.SIZEOF))
                }
            }

    infix fun getImageSparseMemoryRequirements2(info: ImageSparseMemoryRequirementsInfo2): Array<SparseImageMemoryRequirements2> =
            stak { it getImageSparseMemoryRequirements2 info }

    // --- [ vkTrimCommandPool ] ---
    fun trimCommandPool(commandPool: VkCommandPool, flags: VkCommandPoolTrimFlags = 0) =
            callPJV(adr, commandPool.L, flags, capabilities.vkTrimCommandPool)

    // --- [ vkUpdateDescriptorSetWithTemplate ] ---
    fun updateDescriptorSetWithTemplate(descriptorSet: VkDescriptorSet, descriptorUpdateTemplate: VkDescriptorUpdateTemplate, pData: Ptr) =
            callPJJPV(adr, descriptorSet.L, descriptorUpdateTemplate.L, pData, capabilities.vkUpdateDescriptorSetWithTemplate)
}

private inline fun Device_vk11.nBindBufferMemory2(bindInfoCount: Int, pBindInfos: Ptr): VkResult =
        VkResult(callPPI(adr, bindInfoCount, pBindInfos, capabilities.vkBindBufferMemory2))

private inline fun Device_vk11.nBindImageMemory2(bindInfoCount: Int, pBindInfos: Ptr): VkResult =
        VkResult(callPPI(adr, bindInfoCount, pBindInfos, capabilities.vkBindImageMemory2))

private inline fun Device_vk11.nGetImageSparseMemoryRequirements2(pInfo: Ptr, pSparseMemoryRequirementCount: IntPtr, pSparseMemoryRequirements: Ptr = NULL) =
        callPPPPV(adr, pInfo, pSparseMemoryRequirementCount.adr, pSparseMemoryRequirements, capabilities.vkGetImageSparseMemoryRequirements2)