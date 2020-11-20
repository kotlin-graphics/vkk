package vkk.vk10

import glm_.i
import glm_.vec4.Vec4
import kool.*
import org.lwjgl.system.JNI.*
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.system.MemoryUtil.memGetAddress
import org.lwjgl.system.Pointer
import org.lwjgl.vulkan.*
import vkk.*
import vkk.entities.*
import vkk.identifiers.*
import vkk.identifiers.VK
import vkk.vk10.structs.*

interface VkStack_VK10 : VkStackInterface {

    // --- [ vkCreateInstance ] ---
    infix fun vk.createInstance(createInfo: InstanceCreateInfo): Instance =
            Instance(stack.pointerAdr { VK_CHECK_RESULT(callPPPI(createInfo write stack, NULL, it, VK.globalCommands!!.vkCreateInstance)) }, createInfo)

    // --- [ vkEnumeratePhysicalDevices ] ---
    val Instance.physicalDevices: Array<PhysicalDevice>
        get() = stack {
            var pPhysicalDevices: Ptr = NULL
            val pPhysicalDeviceCount = stack.mInt()
            var physicalDeviceCount: Int
            var result: VkResult
            do {
                result = VkResult(callPPPI(adr, pPhysicalDeviceCount.adr, pPhysicalDevices, capabilities.vkEnumeratePhysicalDevices))
                physicalDeviceCount = pPhysicalDeviceCount()
                if (result == VkResult.SUCCESS && physicalDeviceCount != 0) {
                    pPhysicalDevices = stack.nmalloc(Pointer.POINTER_SIZE, physicalDeviceCount shl Pointer.POINTER_SHIFT)
                    result = VkResult(callPPPI(adr, pPhysicalDeviceCount.adr, pPhysicalDevices, capabilities.vkEnumeratePhysicalDevices))
                }
            } while (result == VkResult.INCOMPLETE)
            Array(physicalDeviceCount) { PhysicalDevice(memGetAddress(pPhysicalDevices + it * Pointer.POINTER_SIZE), this) }
        }

    // --- [ vkGetPhysicalDeviceFeatures ] ---
    val PhysicalDevice.features: PhysicalDeviceFeatures
        get() = PhysicalDeviceFeatures.read(stack) { callPPV(adr, it, capabilities.vkGetPhysicalDeviceFeatures) }

    // --- [ vkGetPhysicalDeviceFormatProperties ] ---
    infix fun PhysicalDevice.getFormatProperties(format: VkFormat): FormatProperties =
            FormatProperties.read(stack) { callPPV(adr, format.i, it, capabilities.vkGetPhysicalDeviceFormatProperties) }

    // --- [ vkGetPhysicalDeviceImageFormatProperties ] ---
    fun PhysicalDevice.getImageFormatProperties(format: VkFormat, type: VkImageType, tiling: VkImageTiling, usage: VkImageUsageFlags, flags: VkImageCreateFlags): ImageFormatProperties =
            ImageFormatProperties.read(stack) { VK_CHECK_RESULT(callPPI(adr, format.i, type.i, tiling.i, usage, flags, it, capabilities.vkGetPhysicalDeviceImageFormatProperties)) }

    // --- [ vkGetPhysicalDeviceProperties ] ---
    val PhysicalDevice.properties: PhysicalDeviceProperties
        get() = PhysicalDeviceProperties.read(stack) { callPPV(adr, it, capabilities.vkGetPhysicalDeviceProperties) }

    // --- [ vkGetPhysicalDeviceQueueFamilyProperties ] ---
    val PhysicalDevice.queueFamilyProperties: Array<QueueFamilyProperties>
        get() = stack {
            val pCount = stack.mInt()
            callPPPV(adr, pCount.adr, NULL, capabilities.vkGetPhysicalDeviceQueueFamilyProperties)
            val count = pCount()
            val pQueueFamilyProperties = stack.ncalloc(VkQueueFamilyProperties.ALIGNOF, count, VkQueueFamilyProperties.SIZEOF)
            callPPPV(adr, pCount.adr, pQueueFamilyProperties, capabilities.vkGetPhysicalDeviceQueueFamilyProperties)
            Array(count) { QueueFamilyProperties(BytePtr(pQueueFamilyProperties + VkQueueFamilyProperties.SIZEOF * it)) }
        }

    // --- [ vkGetPhysicalDeviceMemoryProperties ] ---
    val PhysicalDevice.memoryProperties: PhysicalDeviceMemoryProperties
        get() = PhysicalDeviceMemoryProperties.read(stack) { callPPV(adr, it, capabilities.vkGetPhysicalDeviceMemoryProperties) }

    // --- [ vkGetInstanceProcAddr ] ---
    infix fun Instance.getProcAddr(name: String) = stack.asciiAdr(name) { callPPP(adr, it, VK.globalCommands!!.vkGetInstanceProcAddr) }

    // --- [ vkGetDeviceProcAddr ] ---
    infix fun Device.getProcAddr(name: String) = stack.asciiAdr(name) { callPPP(adr, it, capabilities.vkGetDeviceProcAddr) }

    // --- [ vkCreateDevice ] ---
    infix fun PhysicalDevice.createDevice(createInfo: DeviceCreateInfo): Device =
            Device(stack.pointerAdr { VK_CHECK_RESULT(callPPPPI(adr, createInfo write stack, NULL, it, capabilities.vkCreateDevice)) }, this, createInfo)

    // --- [ vkEnumerateInstanceExtensionProperties ] ---
    fun vk.enumerateInstanceExtensionProperties(layerName: String? = null): Array<ExtensionProperties> = stack {
        val pLayerName = layerName?.let { stack.utf8Adr(layerName) } ?: NULL
        var properties: Ptr = NULL
        val pPropertyCount = stack.mInt()
        var propertyCount: Int
        var result: VkResult
        do {
            result = VkResult(callPPPI(pLayerName, pPropertyCount.adr, properties, VK.globalCommands!!.vkEnumerateInstanceExtensionProperties))
            propertyCount = pPropertyCount()
            if (result == VkResult.SUCCESS && propertyCount != 0) {
                properties = stack.ncalloc(VkExtensionProperties.ALIGNOF, propertyCount, VkExtensionProperties.SIZEOF)
                result = VkResult(callPPPI(pLayerName, pPropertyCount.adr, properties, VK.globalCommands!!.vkEnumerateInstanceExtensionProperties))
            }
        } while (result == VkResult.INCOMPLETE)
        Array(propertyCount) { ExtensionProperties(BytePtr(properties + it * VkExtensionProperties.SIZEOF)) }
    }

    // --- [ vkEnumerateDeviceExtensionProperties ] ---
    fun PhysicalDevice.enumerateDeviceExtensionProperties(layerName: String? = null): Array<ExtensionProperties> = stack {
        val pLayerName = layerName?.let { stack.utf8Adr(it) } ?: NULL
        var properties: Ptr = NULL
        val pPropertyCount = stack.mInt()
        var propertyCount: Int
        var result: VkResult
        do {
            result = VkResult(callPPPPI(adr, pLayerName, pPropertyCount.adr, properties, capabilities.vkEnumerateDeviceExtensionProperties))
            propertyCount = pPropertyCount[0]
            if (result == VkResult.SUCCESS && propertyCount != 0) {
                properties = stack.ncalloc(VkExtensionProperties.ALIGNOF, propertyCount, VkExtensionProperties.SIZEOF)
                result = VkResult(callPPPPI(adr, pLayerName, pPropertyCount.adr, properties, capabilities.vkEnumerateDeviceExtensionProperties))
            }
        } while (result == VkResult.INCOMPLETE)
        Array(propertyCount) { ExtensionProperties(BytePtr(properties + it * VkExtensionProperties.SIZEOF)) }
    }

    // --- [ vkEnumerateInstanceLayerProperties ] ---
    val vk.instanceLayerProperties: Array<LayerProperties>
        get() = stack {
            var properties: Ptr = NULL
            val pPropertyCount = stack.mInt()
            var propertyCount: Int
            var result: VkResult
            do {
                result = VkResult(callPPI(pPropertyCount.adr, properties, VK.globalCommands!!.vkEnumerateInstanceLayerProperties))
                propertyCount = pPropertyCount()
                if (result == VkResult.SUCCESS && propertyCount != 0) {
                    properties = stack.ncalloc(VkLayerProperties.ALIGNOF, propertyCount, VkLayerProperties.SIZEOF)
                    result = VkResult(callPPI(pPropertyCount.adr, properties, VK.globalCommands!!.vkEnumerateInstanceLayerProperties))
                }
            } while (result == VkResult.INCOMPLETE)
            Array(propertyCount) { LayerProperties(BytePtr(properties + it * VkLayerProperties.SIZEOF)) }
        }

    // --- [ vkEnumerateDeviceLayerProperties ] ---
    fun PhysicalDevice.enumerateDeviceLayerProperties(): Array<LayerProperties> = stack {
        var properties: Ptr = NULL
        var propertyCount: Int
        val pPropertyCount = stack.mInt()
        var result: VkResult
        do {
            result = VkResult(callPPPI(adr, pPropertyCount.adr, properties, capabilities.vkEnumerateDeviceLayerProperties))
            propertyCount = pPropertyCount[0]
            if (result == VkResult.SUCCESS && propertyCount != 0) {
                properties = stack.ncalloc(VkLayerProperties.ALIGNOF, propertyCount, VkLayerProperties.SIZEOF)
                result = VkResult(callPPPI(adr, pPropertyCount.adr, properties, capabilities.vkEnumerateDeviceLayerProperties))
            }
        } while (result == VkResult.INCOMPLETE)
        Array(propertyCount) { LayerProperties(BytePtr(properties + it * VkLayerProperties.SIZEOF)) }
    }

    // --- [ vkGetDeviceQueue ] ---
    fun Device.getQueue(queueFamilyIndex: Int, queueIndex: Int = 0): Queue =
            Queue(stack.pointerAdr { callPPV(adr, queueFamilyIndex, queueIndex, it, capabilities.vkGetDeviceQueue) }, this)

    // --- [ vkQueueSubmit ] ---
    fun Queue.submit(submit: SubmitInfo, fence: VkFence = VkFence.NULL): VkResult =
            stack { VkResult(callPPJI(adr, 1, submit write stack, fence.L, capabilities.vkQueueSubmit)).andCheck() }

    // --- [ vkAllocateMemory ] ---
    infix fun Device.allocateMemory(allocateInfo: MemoryAllocateInfo): VkDeviceMemory =
            VkDeviceMemory(stack.longAdr { VkResult(callPPPPI(adr, allocateInfo write stack, NULL, it, capabilities.vkAllocateMemory)) })

    // --- [ vkMapMemory ] ---

    fun Device.mapMemory(memory: VkDeviceMemory, offset: VkDeviceSize, size: VkDeviceSize, flags: VkMemoryMapFlags = 0): Ptr =
            stack.pointerAdr { callPJJJPI(adr, memory.L, offset.L, size.L, flags, it, capabilities.vkMapMemory) }

    // [JVM]: vkMapMemory + vkUnmapMemory
    fun <R> Device.mappedMemory(memory: VkDeviceMemory, offset: VkDeviceSize, size: VkDeviceSize, flags: VkMemoryMapFlags = 0, block: (Ptr) -> R): R =
            block(mapMemory(memory, offset, size, flags)).also { unmapMemory(memory) }

    // --- [ vkFlushMappedMemoryRanges ] ---

    infix fun Device.flushMappedMemoryRanges(memoryRanges: Array<MappedMemoryRange>): VkResult =
            stack { VkResult(callPPI(adr, memoryRanges.size, memoryRanges write stack, capabilities.vkFlushMappedMemoryRanges)) }

    infix fun Device.flushMappedMemoryRanges(memoryRange: MappedMemoryRange): VkResult =
            stack { VkResult(callPPI(adr, 1, memoryRange write stack, capabilities.vkFlushMappedMemoryRanges)) }

    // --- [ vkInvalidateMappedMemoryRanges ] ---

    infix fun Device.invalidateMappedMemoryRanges(memoryRanges: Array<MappedMemoryRange>): VkResult =
            stack { VkResult(callPPI(adr, memoryRanges.size, memoryRanges write stack, capabilities.vkInvalidateMappedMemoryRanges)) }

    infix fun Device.invalidateMappedMemoryRanges(memoryRange: MappedMemoryRange): VkResult =
            stack { VkResult(callPPI(adr, 1, memoryRange write stack, capabilities.vkInvalidateMappedMemoryRanges)) }

    // --- [ vkGetDeviceMemoryCommitment ] ---
    infix fun Device.getMemoryCommitment(memory: VkDeviceMemory): VkDeviceSize =
            VkDeviceSize(stack.longAdr { callPJPV(adr, memory.L, it, capabilities.vkGetDeviceMemoryCommitment) })

    // --- [ vkGetBufferMemoryRequirements ] ---
    infix fun Device.getBufferMemoryRequirements(buffer: VkBuffer): MemoryRequirements =
            MemoryRequirements.read(stack) { callPJPV(adr, buffer.L, it, capabilities.vkGetBufferMemoryRequirements) }

    // --- [ vkGetImageMemoryRequirements ] ---
    infix fun Device.getImageMemoryRequirements(image: VkImage): MemoryRequirements =
            MemoryRequirements.read(stack) { callPJPV(adr, image.L, it, capabilities.vkGetImageMemoryRequirements) }

    // --- [ vkGetImageSparseMemoryRequirements ] ---
    infix fun Device.getImageSparseMemoryRequirements(image: VkImage): Array<SparseImageMemoryRequirements> = stack {
        val pSparseMemoryRequirementCount = stack.mInt()
        callPJPPV(adr, image.L, pSparseMemoryRequirementCount.adr, NULL, capabilities.vkGetImageSparseMemoryRequirements)
        val sparseMemoryRequirementCount = pSparseMemoryRequirementCount()
        val sparseMemoryRequirements = stack.ncalloc(VkSparseImageMemoryRequirements.ALIGNOF, sparseMemoryRequirementCount, VkSparseImageMemoryRequirements.SIZEOF)
        callPJPPV(adr, image.L, pSparseMemoryRequirementCount.adr, sparseMemoryRequirements, capabilities.vkGetImageSparseMemoryRequirements)
        Array(sparseMemoryRequirementCount) { SparseImageMemoryRequirements(BytePtr(sparseMemoryRequirements + it * VkSparseImageMemoryRequirements.SIZEOF)) }
    }

    // --- [ vkGetPhysicalDeviceSparseImageFormatProperties ] ---
    fun PhysicalDevice.getSparseImageFormatProperties(format: VkFormat, type: VkImageType, samples: VkSampleCount, usage: VkImageUsageFlags, tiling: VkImageTiling): Array<SparseImageFormatProperties> = stack {
        val pPropertyCount = stack.mInt()
        callPPPV(adr, format.i, type.i, samples.i, usage, tiling.i, pPropertyCount.adr, NULL, capabilities.vkGetPhysicalDeviceSparseImageFormatProperties)
        val propertyCount = pPropertyCount[0]
        val properties = stack.ncalloc(VkSparseImageFormatProperties.ALIGNOF, propertyCount, VkSparseImageFormatProperties.SIZEOF)
        callPPPV(adr, format.i, type.i, samples.i, usage, tiling.i, pPropertyCount.adr, properties, capabilities.vkGetPhysicalDeviceSparseImageFormatProperties)
        Array(propertyCount) {
            SparseImageFormatProperties(BytePtr(properties + it * VkSparseImageFormatProperties.SIZEOF))
        }
    }

    // --- [ vkQueueBindSparse ] ---
    fun Queue.bindSparse(bindInfos: Array<BindSparseInfo>, fence: VkFence = VkFence.NULL): VkResult =
            stack { VkResult(callPPJI(adr, bindInfos.size, bindInfos write stack, fence.L, capabilities.vkQueueBindSparse)) }

    // --- [ vkCreateFence ] ---
    fun Device.createFence(createInfo: FenceCreateInfo = FenceCreateInfo()): VkFence =
            stack { VkFence(stack.longAdr { VkResult(callPPPPI(adr, createInfo write stack, NULL, it, capabilities.vkCreateFence)) }) }

    fun <R> Device.withFence(flags: VkFenceCreateFlags = 0, block: (VkFence) -> R): R = stack {
        val fence = createFence(FenceCreateInfo(flags))
        block(fence).also { destroy(fence) }
    }

    // --- [ vkResetFences ] ---

    infix fun Device.resetFences(fences: VkFence_Array): VkResult =
            stack { VkResult(callPPI(adr, fences.size, fences write stack, capabilities.vkResetFences)) }

    infix fun Device.resetFences(fence: VkFence): VkResult =
            stack.adr(fence.L) { VkResult(callPPI(adr, 1, it, capabilities.vkResetFences)) }

    // --- [ vkWaitForFences ] ---

    fun Device.waitForFences(fences: VkFence_Array, waitAll: Boolean, timeout: NanoSecond): VkResult =
            stack { VkResult(callPPJI(adr, fences.size, fences write stack, waitAll.i, timeout, capabilities.vkWaitForFences)) }

    fun Device.waitForFences(fence: VkFence, waitAll: Boolean, timeout: NanoSecond): VkResult =
            stack.adr(fence.L) { VkResult(callPPJI(adr, 1, it, waitAll.i, timeout, capabilities.vkWaitForFences)) }

    // --- [ vkCreateSemaphore ] ---
    fun Device.createSemaphore(createInfo: SemaphoreCreateInfo = SemaphoreCreateInfo()): VkSemaphore =
            VkSemaphore(stack.longAdr { callPPPPI(adr, createInfo write stack, NULL, it, capabilities.vkCreateSemaphore) })

    // --- [ vkCreateEvent ] ---
    infix fun Device.createEvent(createInfo: EventCreateInfo): VkEvent =
            VkEvent(stack.longAdr { VkResult(callPPPPI(adr, createInfo write stack, NULL, it, capabilities.vkCreateEvent)) })

    // --- [ vkCreateQueryPool ] ---
    infix fun Device.createQueryPool(createInfo: QueryPoolCreateInfo): VkQueryPool =
            VkQueryPool(stack.longAdr { callPPPPI(adr, createInfo write stack, NULL, it, capabilities.vkCreateQueryPool) })

    // --- [ vkCreateBuffer ] ---
    infix fun Device.createBuffer(createInfo: BufferCreateInfo): VkBuffer =
            VkBuffer(stack.longAdr { VkResult(callPPPPI(adr, createInfo write stack, NULL, it, capabilities.vkCreateBuffer)).check() })

    // --- [ vkCreateBufferView ] ---
    infix fun Device.createBufferView(createInfo: BufferViewCreateInfo): VkBufferView =
            VkBufferView(stack.longAdr { VkResult(callPPPPI(adr, createInfo write stack, NULL, it, capabilities.vkCreateBufferView)).check() })

    // --- [ vkCreateImage ] ---
    infix fun Device.createImage(createInfo: ImageCreateInfo): VkImage =
            VkImage(stack.longAdr { VkResult(callPPPPI(adr, createInfo write stack, NULL, it, capabilities.vkCreateImage)).check() })

    // --- [ vkGetImageSubresourceLayout ] ---
    fun Device.getImageSubresourceLayout(image: VkImage, subresource: ImageSubresource): SubresourceLayout =
            SubresourceLayout.read(stack) { callPJPPV(adr, image.L, subresource write stack, it, capabilities.vkGetImageSubresourceLayout) }

    // --- [ vkCreateImageView ] ---

    infix fun Device.createImageView(createInfo: ImageViewCreateInfo): VkImageView =
            VkImageView(stack.longAdr { VkResult(callPPPPI(adr, createInfo write stack, NULL, it, capabilities.vkCreateImageView)).check() })

    // [JVM]
    fun Device.createImageViewArray(createInfo: ImageViewCreateInfo, images: VkImage_Array): VkImageView_Array = stack {
        val pCreateInfo = createInfo write stack
        val pImageView = stack.mLong()
        VkImageView_Array(images.size) { i ->
            VkImageViewCreateInfo.nimage(pCreateInfo, images[i].L)
            VkResult(callPPPPI(adr, pCreateInfo, NULL, pImageView.adr, capabilities.vkCreateImageView)).check()
            VkImageView(pImageView[0])
        }
    }

    // --- [ vkCreateShaderModule ] ---
    infix fun Device.createShaderModule(createInfo: ShaderModuleCreateInfo): VkShaderModule =
            VkShaderModule(stack.longAdr { callPPPPI(adr, createInfo write stack, NULL, it, capabilities.vkCreateShaderModule) })

    // --- [ vkCreatePipelineCache ] ---
    fun Device.createPipelineCache(createInfo: PipelineCacheCreateInfo = PipelineCacheCreateInfo()): VkPipelineCache =
            VkPipelineCache(stack.longAdr { callPPPPI(adr, createInfo write stack, NULL, it, capabilities.vkCreatePipelineCache) })

    // --- [ vkGetPipelineCacheData ] ---
    infix fun Device.getPipelineCacheData(pipelineCache: VkPipelineCache): ByteArray = stack {
        var data: Ptr = NULL
        val pDataSize = stack.mInt()
        var dataSize: Int
        var result: VkResult
        do {
            result = VkResult(callPJPPI(adr, pipelineCache.L, pDataSize.adr, data, capabilities.vkGetPipelineCacheData))
            dataSize = pDataSize[0]
            if (result == VkResult.SUCCESS && dataSize != 0) {
                data = stack.ncalloc(1, dataSize, 1)
                result = VkResult(callPJPPI(adr, pipelineCache.L, pDataSize.adr, data, capabilities.vkGetPipelineCacheData))
            }
        } while (result == VkResult.INCOMPLETE)
        ByteArray(dataSize) { MemoryUtil.memGetByte(data + it) }
    }

    // --- [ vkMergePipelineCaches ] ---
    fun Device.mergePipelineCaches(dstCache: VkPipelineCache, srcCaches: VkPipelineCache_Array): VkResult =
            stack { VkResult(callPJPI(adr, dstCache.L, srcCaches.size, srcCaches write stack, capabilities.vkMergePipelineCaches)) }

    // --- [ vkCreateGraphicsPipelines ] ---

    fun Device.createGraphicsPipeline(pipelineCache: VkPipelineCache, createInfos: Array<GraphicsPipelineCreateInfo>): VkPipeline_Array = stack {
        val pipelines = stack.mLong(createInfos.size)
        VkResult(callPJPPPI(adr, pipelineCache.L, createInfos.size, createInfos write stack, NULL, pipelines.adr, capabilities.vkCreateGraphicsPipelines))
        VkPipeline_Array(createInfos.size) { VkPipeline(pipelines[it]) }
    }

    fun Device.createGraphicsPipeline(pipelineCache: VkPipelineCache, createInfo: GraphicsPipelineCreateInfo): VkPipeline =
            VkPipeline(stack.longAdr { VkResult(callPJPPPI(adr, pipelineCache.L, 1, createInfo write stack, NULL, it, capabilities.vkCreateGraphicsPipelines)).check() })

    // --- [ vkCreateComputePipelines ] ---

    fun Device.createComputePipelines(pipelineCache: VkPipelineCache, createInfos: Array<ComputePipelineCreateInfo>): VkPipeline_Array = stack {
        val pipelines = stack.mLong(createInfos.size)
        VkResult(callPJPPPI(adr, pipelineCache.L, createInfos.size, createInfos write stack, NULL, pipelines.adr, capabilities.vkCreateComputePipelines)).check()
        VkPipeline_Array(createInfos.size) { VkPipeline(pipelines[it]) }
    }

    fun Device.createComputePipelines(pipelineCache: VkPipelineCache, createInfo: ComputePipelineCreateInfo): VkPipeline =
            VkPipeline(stack.longAdr { VkResult(callPJPPPI(adr, pipelineCache.L, 1, createInfo write stack, NULL, it, capabilities.vkCreateComputePipelines)).check() })

    // --- [ vkCreatePipelineLayout ] ---
    infix fun Device.createPipelineLayout(createInfo: PipelineLayoutCreateInfo): VkPipelineLayout =
            VkPipelineLayout(stack.longAdr { callPPPPI(adr, createInfo write stack, NULL, it, capabilities.vkCreatePipelineLayout) })

    // --- [ vkCreateSampler ] ---
    infix fun Device.createSampler(createInfo: SamplerCreateInfo): VkSampler =
            VkSampler(stack.longAdr { callPPPPI(adr, createInfo write stack, NULL, it, capabilities.vkCreateSampler) })

    // --- [ vkCreateDescriptorSetLayout ] ---
    infix fun Device.createDescriptorSetLayout(createInfo: DescriptorSetLayoutCreateInfo): VkDescriptorSetLayout =
            VkDescriptorSetLayout(stack.longAdr { VkResult(callPPPPI(adr, createInfo write stack, NULL, it, capabilities.vkCreateDescriptorSetLayout)).check() })

    // --- [ vkCreateDescriptorPool ] ---
    infix fun Device.createDescriptorPool(createInfo: DescriptorPoolCreateInfo): VkDescriptorPool =
            VkDescriptorPool(stack.longAdr { VkResult(callPPPPI(adr, createInfo write stack, NULL, it, capabilities.vkCreateDescriptorPool)).check() })

    // --- [ vkAllocateDescriptorSets ] ---

    infix fun Device.allocateDescriptorSets(allocateInfo: DescriptorSetAllocateInfo): VkDescriptorSet_Array = stack {
        val descriptors = stack.mLong(allocateInfo.setLayouts.size)
        VkResult(callPPPI(adr, allocateInfo write stack, descriptors.adr, capabilities.vkAllocateDescriptorSets))
        VkDescriptorSet_Array(allocateInfo.setLayouts.size) { VkDescriptorSet(descriptors[it]) }
    }

    infix fun Device.allocateDescriptorSet(allocateInfo: DescriptorSetAllocateInfo): VkDescriptorSet =
            VkDescriptorSet(stack.longAdr { VkResult(callPPPI(adr, allocateInfo write stack, it, capabilities.vkAllocateDescriptorSets)).check() })

    // --- [ vkFreeDescriptorSets ] ---

    fun Device.freeDescriptorSets(descriptorPool: VkDescriptorPool, descriptorSets: VkDescriptorSet_Array): VkResult =
            stack { VkResult(callPJPI(adr, descriptorPool.L, descriptorSets.size, descriptorSets write stack, capabilities.vkFreeDescriptorSets)).andCheck() }

    fun Device.freeDescriptorSets(descriptorPool: VkDescriptorPool, descriptorSet: VkDescriptorSet): VkResult =
            stack.adr(descriptorSet.L) { VkResult(callPJPI(adr, descriptorPool.L, 1, it, capabilities.vkFreeDescriptorSets)).andCheck() }

    // --- [ vkUpdateDescriptorSets ] ---

    fun Device.updateDescriptorSets(descriptorWrites: Array<WriteDescriptorSet>?, descriptorCopies: Array<CopyDescriptorSet>? = null) =
            stack { callPPPV(adr, descriptorWrites?.size ?: 0, descriptorWrites?.write(stack) ?: NULL, descriptorCopies?.size ?: 0, descriptorCopies?.write(stack) ?: NULL, capabilities.vkUpdateDescriptorSets) }

    fun Device.updateDescriptorSet(descriptorWrite: WriteDescriptorSet?, descriptorCopy: CopyDescriptorSet? = null) =
            stack { callPPPV(adr, if(descriptorWrite != null) 1 else 0, descriptorWrite?.write(stack) ?: NULL, if(descriptorCopy != null) 1 else 0, descriptorCopy?.write(stack) ?: NULL, capabilities.vkUpdateDescriptorSets) }

    // --- [ vkCreateFramebuffer ] ---

    infix fun Device.createFramebuffer(createInfo: FramebufferCreateInfo): VkFramebuffer =
            VkFramebuffer(stack.longAdr { VkResult(callPPPPI(adr, createInfo write stack, NULL, it, capabilities.vkCreateFramebuffer)).check() })

    // [JVM]
    fun Device.createFramebufferArray(createInfo: FramebufferCreateInfo, imageViews: VkImageView_Array): VkFramebuffer_Array = stack {
        val pCreateInfo = createInfo write stack
        VkFramebufferCreateInfo.nattachmentCount(pCreateInfo, 1)
        val pAttachment = stack.mLong()
        MemoryUtil.memPutAddress(pCreateInfo + VkFramebufferCreateInfo.PATTACHMENTS, pAttachment.adr)
        val pFramebuffer = stack.mLong()
        VkFramebuffer_Array(imageViews.size) { i ->
            pAttachment[0] = imageViews[i].L
            VkResult(callPPPPI(adr, pCreateInfo, NULL, pFramebuffer.adr, capabilities.vkCreateFramebuffer)).check()
            VkFramebuffer(pFramebuffer[0])
        }
    }

    // --- [ vkCreateRenderPass ] ---
    infix fun Device.createRenderPass(createInfo: RenderPassCreateInfo): VkRenderPass =
            VkRenderPass(stack.longAdr { callPPPPI(adr, createInfo write stack, NULL, it, capabilities.vkCreateRenderPass) })

    // --- [ vkGetRenderAreaGranularity ] ---
    infix fun Device.getRenderAreaGranularity(renderPass: VkRenderPass): Extent2D =
            Extent2D.read(stack) { callPJPV(adr, renderPass.L, it, capabilities.vkGetRenderAreaGranularity) }

    // --- [ vkCreateCommandPool ] ---
    infix fun Device.createCommandPool(createInfo: CommandPoolCreateInfo): VkCommandPool =
            VkCommandPool(stack.longAdr { VkResult(callPPPPI(adr, createInfo write stack, NULL, it, capabilities.vkCreateCommandPool)).check() })

    // --- [ vkAllocateCommandBuffers ] ---

    infix fun Device.allocateCommandBuffer(allocateInfo: CommandBufferAllocateInfo): CommandBuffer =
            CommandBuffer(stack.pointerAdr { VkResult(callPPPI(adr, allocateInfo write stack, it, capabilities.vkAllocateCommandBuffers)).check() }, this)

    infix fun Device.allocateCommandBuffers(allocateInfo: CommandBufferAllocateInfo): Array<CommandBuffer> = stack {
        val pCommandBuffers = stack.mPointer(allocateInfo.commandBufferCount)
        VkResult(callPPPI(adr, allocateInfo write stack, pCommandBuffers.adr, capabilities.vkAllocateCommandBuffers))
        Array(allocateInfo.commandBufferCount) { CommandBuffer(pCommandBuffers[it], this) }
    }

    // --- [ vkFreeCommandBuffers ] ---

    fun Device.freeCommandBuffers(commandPool: VkCommandPool, commandBuffer: CommandBuffer) =
            stack.adr(commandBuffer.adr) { callPJPV(adr, commandPool.L, 1, it, capabilities.vkFreeCommandBuffers) }

    fun Device.freeCommandBuffers(commandPool: VkCommandPool, commandBuffers: Array<CommandBuffer>) =
            stack { callPJPV(adr, commandPool.L, commandBuffers.size, commandBuffers write stack, capabilities.vkFreeCommandBuffers) }

    // --- [ vkBeginCommandBuffer ] ---
    infix fun CommandBuffer.begin(beginInfo: CommandBufferBeginInfo): VkResult =
            stack { VkResult(callPPI(adr, beginInfo write stack, capabilities.vkBeginCommandBuffer)).andCheck() }

    // [JVM] begin { .. } end
    fun <R> CommandBuffer.record(beginInfo: CommandBufferBeginInfo, block: (CommandBuffer) -> R): R {
        begin(beginInfo)
        return block(this).also { end() }
    }

    // --- [ vkCmdSetViewport ] ---

    infix fun CommandBuffer.setViewport(viewport: Viewport) =
            stack { callPPV(adr, 0, 1, viewport write stack, capabilities.vkCmdSetViewport) }

    fun CommandBuffer.setViewport(firstViewport: Int, viewports: Array<Viewport>) =
            stack { callPPV(adr, firstViewport, viewports.size, viewports write stack, capabilities.vkCmdSetViewport) }

    // --- [ vkCmdSetScissor ] ---

    fun CommandBuffer.setScissor(firstScissor: Int, scissors: Array<Rect2D>) =
            stack { callPPV(adr, firstScissor, scissors.size, scissors write stack, capabilities.vkCmdSetScissor) }

    infix fun CommandBuffer.setScissor(scissor: Rect2D) =
            stack { callPPV(adr, 0, 1, scissor write stack, capabilities.vkCmdSetScissor) }

    // --- [ vkCmdSetBlendConstants ] ---
    infix fun CommandBuffer.setBlendConstants(blendConstants: Vec4) =
            stack { callPPV(adr, blendConstants.toAdr(stack).adr, capabilities.vkCmdSetBlendConstants) }

    // --- [ vkCmdBindDescriptorSets ] ---

    fun CommandBuffer.bindDescriptorSets(pipelineBindPoint: VkPipelineBindPoint, layout: VkPipelineLayout, firstSet: Int, descriptorSets: VkDescriptorSet_Array, dynamicOffsets: IntArray) =
            stack { callPJPPV(adr, pipelineBindPoint.i, layout.L, firstSet, descriptorSets.size, descriptorSets write stack, dynamicOffsets.size, stack.Adr(dynamicOffsets).adr, capabilities.vkCmdBindDescriptorSets) }

    fun CommandBuffer.bindDescriptorSets(pipelineBindPoint: VkPipelineBindPoint, layout: VkPipelineLayout, firstSet: Int, descriptorSet: VkDescriptorSet, dynamicOffset: Int) =
            stack { callPJPPV(adr, pipelineBindPoint.i, layout.L, firstSet, 1, stack.longAdr(descriptorSet.L), 1, stack.intAdr(dynamicOffset), capabilities.vkCmdBindDescriptorSets) }

    // --- [ vkCmdBindVertexBuffers ] ---

    fun CommandBuffer.bindVertexBuffers(firstBinding: Int, bindingCount: Int, buffers: VkBuffer_Array, offsets: VkDeviceSize_Array) =
            stack { callPPPV(adr, firstBinding, bindingCount, buffers write stack, offsets write stack, capabilities.vkCmdBindVertexBuffers) }

    fun CommandBuffer.bindVertexBuffers(firstBinding: Int, bindingCount: Int, buffer: VkBuffer, offset: VkDeviceSize) =
            stack { callPPPV(adr, firstBinding, bindingCount, stack.longAdr(buffer.L), stack.longAdr(offset.L), capabilities.vkCmdBindVertexBuffers) }

    // firstBinding and bindCount defaulted to 0 and 1
    fun CommandBuffer.bindVertexBuffers(buffer: VkBuffer, offset: VkDeviceSize = VkDeviceSize.NULL) =
            stack { callPPPV(adr, 0, 1, stack.longAdr(buffer.L), stack.longAdr(offset.L), capabilities.vkCmdBindVertexBuffers) }

    // bindCount extrapolated from buffers
    fun CommandBuffer.bindVertexBuffers(firstBinding: Int, buffers: VkBuffer_Array, offsets: VkDeviceSize_Array) =
            stack { callPPPV(adr, firstBinding, buffers.size, buffers write stack, offsets write stack, capabilities.vkCmdBindVertexBuffers) }

    // --- [ vkCmdCopyBuffer ] ---

    fun CommandBuffer.copyBuffer(srcBuffer: VkBuffer, dstBuffer: VkBuffer, regions: Array<BufferCopy>) =
            stack { callPJJPV(adr, srcBuffer.L, dstBuffer.L, regions.size, regions write stack, capabilities.vkCmdCopyBuffer) }

    fun CommandBuffer.copyBuffer(srcBuffer: VkBuffer, dstBuffer: VkBuffer, region: BufferCopy) =
            stack { callPJJPV(adr, srcBuffer.L, dstBuffer.L, 1, region write stack, capabilities.vkCmdCopyBuffer) }

    // --- [ vkCmdCopyImage ] ---

    fun CommandBuffer.copyImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, regions: Array<ImageCopy>) =
            stack { callPJJPV(adr, srcImage.L, srcImageLayout.i, dstImage.L, dstImageLayout.i, regions.size, regions write stack, capabilities.vkCmdCopyImage) }

    fun CommandBuffer.copyImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, region: ImageCopy) =
            stack { callPJJPV(adr, srcImage.L, srcImageLayout.i, dstImage.L, dstImageLayout.i, 1, region write stack, capabilities.vkCmdCopyImage) }

    // --- [ vkCmdBlitImage ] ---

    fun CommandBuffer.blitImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, regions: Array<ImageBlit>, filter: VkFilter) =
            stack { callPJJPV(adr, srcImage.L, srcImageLayout.i, dstImage.L, dstImageLayout.i, regions.size, regions write stack, filter.i, capabilities.vkCmdBlitImage) }

    fun CommandBuffer.blitImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, region: ImageBlit, filter: VkFilter) =
            stack { callPJJPV(adr, srcImage.L, srcImageLayout.i, dstImage.L, dstImageLayout.i, 1, region write stack, filter.i, capabilities.vkCmdBlitImage) }

    // --- [ vkCmdCopyBufferToImage ] ---

    fun CommandBuffer.copyBufferToImage(srcBuffer: VkBuffer, dstImage: VkImage, dstImageLayout: VkImageLayout, regions: Array<BufferImageCopy>) =
            stack { callPJJPV(adr, srcBuffer.L, dstImage.L, dstImageLayout.i, regions.size, regions write stack, capabilities.vkCmdCopyBufferToImage) }

    fun CommandBuffer.copyBufferToImage(srcBuffer: VkBuffer, dstImage: VkImage, dstImageLayout: VkImageLayout, region: BufferImageCopy) =
            stack { callPJJPV(adr, srcBuffer.L, dstImage.L, dstImageLayout.i, 1, region write stack, capabilities.vkCmdCopyBufferToImage) }

    // --- [ vkCmdCopyImageToBuffer ] ---

    fun CommandBuffer.copyImageToBuffer(srcImage: VkImage, srcImageLayout: VkImageLayout, dstBuffer: VkBuffer, regions: Array<BufferImageCopy>) =
            stack { callPJJPV(adr, srcImage.L, srcImageLayout.i, dstBuffer.L, regions.size, regions write stack, capabilities.vkCmdCopyImageToBuffer) }

    fun CommandBuffer.copyImageToBuffer(srcImage: VkImage, srcImageLayout: VkImageLayout, dstBuffer: VkBuffer, region: BufferImageCopy) =
            stack { callPJJPV(adr, srcImage.L, srcImageLayout.i, dstBuffer.L, 1, region write stack, capabilities.vkCmdCopyImageToBuffer) }

    // --- [ vkCmdClearColorImage ] ---

    fun CommandBuffer.clearColorImage(image: VkImage, imageLayout: VkImageLayout, color: ClearColorValue, ranges: Array<ImageSubresourceRange>) =
            stack { callPJPPV(adr, image.L, imageLayout.i, color write stack, ranges.size, ranges write stack, capabilities.vkCmdClearColorImage) }

    fun CommandBuffer.clearColorImage(image: VkImage, imageLayout: VkImageLayout, color: ClearColorValue, range: ImageSubresourceRange) =
            stack { callPJPPV(adr, image.L, imageLayout.i, color write stack, 1, range write stack, capabilities.vkCmdClearColorImage) }

    // --- [ vkCmdClearDepthStencilImage ] ---

    fun CommandBuffer.clearDepthStencilImage(image: VkImage, imageLayout: VkImageLayout, depthStencil: ClearDepthStencilValue, ranges: Array<ImageSubresourceRange>) =
            stack { callPJPPV(adr, image.L, imageLayout.i, depthStencil write stack, ranges.size, ranges write stack, capabilities.vkCmdClearDepthStencilImage) }

    fun CommandBuffer.clearDepthStencilImage(image: VkImage, imageLayout: VkImageLayout, depthStencil: ClearDepthStencilValue, range: ImageSubresourceRange) =
            stack { callPJPPV(adr, image.L, imageLayout.i, depthStencil write stack, 1, range write stack, capabilities.vkCmdClearDepthStencilImage) }

    // --- [ vkCmdClearAttachments ] ---

    fun CommandBuffer.clearAttachments(attachments: Array<ClearAttachment>, rects: Array<ClearRect>) =
            stack { callPPPV(adr, attachments.size, attachments write stack, rects.size, rects write stack, capabilities.vkCmdClearAttachments) }

    fun CommandBuffer.clearAttachments(attachment: ClearAttachment, rect: ClearRect) =
            stack { callPPPV(adr, 1, attachment write stack, 1, rect write stack, capabilities.vkCmdClearAttachments) }

    // --- [ vkCmdResolveImage ] ---

    fun CommandBuffer.resolveImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, regions: Array<ImageResolve>) =
            stack { callPJJPV(adr, srcImage.L, srcImageLayout.i, dstImage.L, dstImageLayout.i, regions.size, regions write stack, capabilities.vkCmdResolveImage) }

    fun CommandBuffer.resolveImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, region: ImageResolve) =
            stack { callPJJPV(adr, srcImage.L, srcImageLayout.i, dstImage.L, dstImageLayout.i, 1, region write stack, capabilities.vkCmdResolveImage) }

    // --- [ vkCmdWaitEvents ] ---

    fun CommandBuffer.waitEvents(events: VkEvent_Array, srcStageMask: VkPipelineStageFlags, dstStageMask: VkPipelineStageFlags,
                                 memoryBarriers: Array<MemoryBarrier>, bufferMemoryBarriers: Array<BufferMemoryBarrier>,
                                 imageMemoryBarriers: Array<ImageMemoryBarrier>) =
            stack { callPPPPPV(adr, events.size, events write stack, srcStageMask, dstStageMask, memoryBarriers.size, memoryBarriers write stack, bufferMemoryBarriers.size, bufferMemoryBarriers write stack, imageMemoryBarriers.size, imageMemoryBarriers write stack, capabilities.vkCmdWaitEvents) }

    // --- [ vkCmdPipelineBarrier ] ---

    fun CommandBuffer.pipelineBarrier(srcStageMask: VkPipelineStageFlags, dstStageMask: VkPipelineStageFlags, dependencyFlags: VkDependencyFlags,
                                      memoryBarriers: Array<MemoryBarrier>? = null, bufferMemoryBarriers: Array<BufferMemoryBarrier>? = null,
                                      imageMemoryBarriers: Array<ImageMemoryBarrier>? = null) =
            stack {
                callPPPPV(adr, srcStageMask, dstStageMask, dependencyFlags, memoryBarriers?.size
                        ?: 0, memoryBarriers?.write(stack) ?: NULL, bufferMemoryBarriers?.size
                        ?: 0, bufferMemoryBarriers?.write(stack) ?: NULL, imageMemoryBarriers?.size
                        ?: 0, imageMemoryBarriers?.write(stack) ?: NULL, capabilities.vkCmdPipelineBarrier)
            }

    fun CommandBuffer.pipelineBarrier(srcStageMask: VkPipelineStageFlags, dstStageMask: VkPipelineStageFlags, dependencyFlags: VkDependencyFlags,
                                      memoryBarrier: MemoryBarrier? = null, bufferMemoryBarrier: BufferMemoryBarrier? = null, imageMemoryBarrier: ImageMemoryBarrier? = null) =
            stack {
                callPPPPV(adr, srcStageMask, dstStageMask, dependencyFlags, (memoryBarrier != null).i,
                        memoryBarrier?.write(stack) ?: NULL, (bufferMemoryBarrier != null).i,
                        bufferMemoryBarrier?.write(stack) ?: NULL, (imageMemoryBarrier != null).i,
                        imageMemoryBarrier?.write(stack) ?: NULL, capabilities.vkCmdPipelineBarrier)
            }

    // --- [ vkCmdBeginRenderPass ] ---
    fun CommandBuffer.beginRenderPass(renderPassBegin: RenderPassBeginInfo, contents: VkSubpassContents = VkSubpassContents.INLINE) =
            stack { callPPV(adr, renderPassBegin write stack, contents.i, capabilities.vkCmdBeginRenderPass) }

    // [JVM]
    fun <R> CommandBuffer.renderPass(renderPassBegin: RenderPassBeginInfo, contents: VkSubpassContents = VkSubpassContents.INLINE, block: () -> R): R =
            stack { beginRenderPass(renderPassBegin, contents); block().also { endRenderPass() } }

    // --- [ vkCmdExecuteCommands ] ---

    infix fun CommandBuffer.executeCommands(commandBuffers: Array<CommandBuffer>) =
            stack { callPPV(adr, commandBuffers.size, commandBuffers write stack, capabilities.vkCmdExecuteCommands) }

    infix fun CommandBuffer.executeCommands(commandBuffer: CommandBuffer) =
            stack.adr(commandBuffer) { callPPV(adr, 1, it, capabilities.vkCmdExecuteCommands) }
}

// --- [ vkCreateInstance ] ---
infix fun vk.createInstance(createInfo: InstanceCreateInfo): Instance =
        VkStack { it.run { vk createInstance createInfo } }

// --- [ vkEnumeratePhysicalDevices ] ---
val Instance.physicalDevices: Array<PhysicalDevice>
    get() = VkStack { it.run { physicalDevices } }

// --- [ vkGetPhysicalDeviceFeatures ] ---
val PhysicalDevice.features: PhysicalDeviceFeatures
    get() = VkStack { it.run { features } }

// --- [ vkGetPhysicalDeviceFormatProperties ] ---
infix fun PhysicalDevice.getFormatProperties(format: VkFormat): FormatProperties =
        VkStack { it.run { getFormatProperties(format) } }

// --- [ vkGetPhysicalDeviceImageFormatProperties ] ---
fun PhysicalDevice.getImageFormatProperties(format: VkFormat, type: VkImageType, tiling: VkImageTiling, usage: VkImageUsageFlags, flags: VkImageCreateFlags): ImageFormatProperties =
        VkStack { it.run { getImageFormatProperties(format, type, tiling, usage, flags) } }

// --- [ vkGetPhysicalDeviceProperties ] ---
val PhysicalDevice.properties: PhysicalDeviceProperties
    get() = VkStack { it.run { properties } }

// --- [ vkGetPhysicalDeviceQueueFamilyProperties ] ---
val PhysicalDevice.queueFamilyProperties: Array<QueueFamilyProperties>
    get() = VkStack { it.run { queueFamilyProperties } }

// --- [ vkGetPhysicalDeviceMemoryProperties ] ---
val PhysicalDevice.memoryProperties: PhysicalDeviceMemoryProperties
    get() = VkStack { it.run { memoryProperties } }

// --- [ vkGetInstanceProcAddr ] ---
infix fun Instance.getProcAddr(name: String) = VkStack { it.run { getProcAddr(name) } }

// --- [ vkGetDeviceProcAddr ] ---
infix fun Device.getProcAddr(name: String) = VkStack { it.run { getProcAddr(name) } }

// --- [ vkCreateDevice ] ---
infix fun PhysicalDevice.createDevice(createInfo: DeviceCreateInfo): Device =
        VkStack { it.run { createDevice(createInfo) } }

class Prova

// --- [ vkEnumerateInstanceExtensionProperties ] ---
fun vk.enumerateInstanceExtensionProperties(layerName: String? = null): Array<ExtensionProperties> =
        VkStack { it.run { vk.enumerateInstanceExtensionProperties(layerName) } }

// --- [ vkEnumerateDeviceExtensionProperties ] ---
fun PhysicalDevice.enumerateDeviceExtensionProperties(layerName: String? = null): Array<ExtensionProperties> =
        VkStack { it.run { enumerateDeviceExtensionProperties(layerName) } }

// --- [ vkEnumerateInstanceLayerProperties ] ---
val vk.instanceLayerProperties: Array<LayerProperties>
    get() = VkStack { it.run { vk.instanceLayerProperties } }

// --- [ vkEnumerateDeviceLayerProperties ] ---
val PhysicalDevice.layerProperties: Array<LayerProperties>
    get() = VkStack { it.run { enumerateDeviceLayerProperties() } }

// --- [ vkGetDeviceQueue ] ---
fun Device.getQueue(queueFamilyIndex: Int, queueIndex: Int = 0): Queue =
        VkStack { it.run { getQueue(queueFamilyIndex, queueIndex) } }

// --- [ vkQueueSubmit ] ---
fun Queue.submit(submit: SubmitInfo, fence: VkFence = VkFence.NULL): VkResult =
        VkStack { it.run { submit(submit, fence) } }

// --- [ vkAllocateMemory ] ---
infix fun Device.allocateMemory(allocateInfo: MemoryAllocateInfo): VkDeviceMemory =
        VkStack { it.run { allocateMemory(allocateInfo) } }

// --- [ vkMapMemory ] ---

fun Device.mapMemory(memory: VkDeviceMemory, offset: VkDeviceSize, size: VkDeviceSize, flags: VkMemoryMapFlags = 0): Ptr =
        VkStack { it.run { mapMemory(memory, offset, size, flags) } }

// [JVM]
fun <R> Device.mappedMemory(memory: VkDeviceMemory, offset: VkDeviceSize, size: VkDeviceSize, flags: VkMemoryMapFlags = 0, block: (Ptr) -> R): R =
        VkStack { it.run { mappedMemory(memory, offset, size, flags, block) } }

// --- [ vkFlushMappedMemoryRanges ] ---

infix fun Device.flushMappedMemoryRanges(memoryRanges: Array<MappedMemoryRange>): VkResult =
        VkStack { it.run { flushMappedMemoryRanges(memoryRanges) } }

infix fun Device.flushMappedMemoryRanges(memoryRange: MappedMemoryRange): VkResult =
        VkStack { it.run { flushMappedMemoryRanges(memoryRange) } }

// --- [ vkInvalidateMappedMemoryRanges ] ---

infix fun Device.invalidateMappedMemoryRanges(memoryRanges: Array<MappedMemoryRange>): VkResult =
        VkStack { it.run { invalidateMappedMemoryRanges(memoryRanges) } }

infix fun Device.invalidateMappedMemoryRanges(memoryRange: MappedMemoryRange): VkResult =
        VkStack { it.run { invalidateMappedMemoryRanges(memoryRange) } }

// --- [ vkGetDeviceMemoryCommitment ] ---
infix fun Device.getMemoryCommitment(memory: VkDeviceMemory): VkDeviceSize =
        VkStack { it.run { getMemoryCommitment(memory) } }

// --- [ vkGetBufferMemoryRequirements ] ---
infix fun Device.getBufferMemoryRequirements(buffer: VkBuffer): MemoryRequirements =
        VkStack { it.run { getBufferMemoryRequirements(buffer) } }

// --- [ vkGetImageMemoryRequirements ] ---
infix fun Device.getImageMemoryRequirements(image: VkImage): MemoryRequirements =
        VkStack { it.run { getImageMemoryRequirements(image) } }

// --- [ vkGetImageSparseMemoryRequirements ] ---
infix fun Device.getImageSparseMemoryRequirements(image: VkImage): Array<SparseImageMemoryRequirements> =
        VkStack { it.run { getImageSparseMemoryRequirements(image) } }

// --- [ vkGetPhysicalDeviceSparseImageFormatProperties ] ---
fun PhysicalDevice.getSparseImageFormatProperties(format: VkFormat, type: VkImageType, samples: VkSampleCount, usage: VkImageUsageFlags, tiling: VkImageTiling): Array<SparseImageFormatProperties> =
        VkStack { it.run { getSparseImageFormatProperties(format, type, samples, usage, tiling) } }

// --- [ vkQueueBindSparse ] ---
fun Queue.bindSparse(bindInfos: Array<BindSparseInfo>, fence: VkFence = VkFence.NULL): VkResult =
        VkStack { it.run { bindSparse(bindInfos, fence) } }

// --- [ vkCreateFence ] ---
fun Device.createFence(createInfo: FenceCreateInfo = FenceCreateInfo()): VkFence =
        VkStack { it.run { createFence(createInfo) } }

fun <R> Device.withFence(flags: VkFenceCreateFlags = 0, block: (VkFence) -> R): R =
        VkStack { it.run { withFence(flags, block) } }

// --- [ vkResetFences ] ---

infix fun Device.resetFences(fences: VkFence_Array): VkResult =
        VkStack { it.run { resetFences(fences) } }

infix fun Device.resetFences(fence: VkFence): VkResult =
        VkStack { it.run { resetFences(fence) } }

// --- [ vkWaitForFences ] ---

fun Device.waitForFences(fences: VkFence_Array, waitAll: Boolean, timeout: NanoSecond): VkResult =
        VkStack { it.run { waitForFences(fences, waitAll, timeout) } }

fun Device.waitForFences(fence: VkFence, waitAll: Boolean, timeout: NanoSecond): VkResult =
        VkStack { it.run { waitForFences(fence, waitAll, timeout) } }

// --- [ vkCreateSemaphore ] ---
fun Device.createSemaphore(createInfo: SemaphoreCreateInfo = SemaphoreCreateInfo()): VkSemaphore =
        VkStack { it.run { createSemaphore(createInfo) } }

// --- [ vkCreateEvent ] ---
fun Device.createEvent(createInfo: EventCreateInfo): VkEvent =
        VkStack { it.run { createEvent(createInfo) } }

// --- [ vkCreateQueryPool ] ---
infix fun Device.createQueryPool(createInfo: QueryPoolCreateInfo): VkQueryPool =
        VkStack { it.run { createQueryPool(createInfo) } }

// --- [ vkCreateBuffer ] ---
infix fun Device.createBuffer(createInfo: BufferCreateInfo): VkBuffer =
        VkStack { it.run { createBuffer(createInfo) } }

// --- [ vkCreateBufferView ] ---
infix fun Device.createBufferView(createInfo: BufferViewCreateInfo): VkBufferView =
        VkStack { it.run { createBufferView(createInfo) } }

// --- [ vkCreateImage ] ---
infix fun Device.createImage(createInfo: ImageCreateInfo): VkImage =
        VkStack { it.run { createImage(createInfo) } }

// --- [ vkGetImageSubresourceLayout ] ---
fun Device.getImageSubresourceLayout(image: VkImage, subresource: ImageSubresource): SubresourceLayout =
        VkStack { it.run { getImageSubresourceLayout(image, subresource) } }

// --- [ vkCreateImageView ] ---

infix fun Device.createImageView(createInfo: ImageViewCreateInfo): VkImageView =
        VkStack { it.run { createImageView(createInfo) } }

// [JVM]
fun Device.createImageViewArray(createInfo: ImageViewCreateInfo, images: VkImage_Array): VkImageView_Array =
        VkStack { it.run { createImageViewArray(createInfo, images) } }

// --- [ vkCreateShaderModule ] ---
infix fun Device.createShaderModule(createInfo: ShaderModuleCreateInfo): VkShaderModule =
        VkStack { it.run { createShaderModule(createInfo) } }

// --- [ vkCreatePipelineCache ] ---
fun Device.createPipelineCache(createInfo: PipelineCacheCreateInfo = PipelineCacheCreateInfo()): VkPipelineCache =
        VkStack { it.run { createPipelineCache(createInfo) } }

// --- [ vkGetPipelineCacheData ] ---
infix fun Device.getPipelineCacheData(pipelineCache: VkPipelineCache): ByteArray =
        VkStack { it.run { getPipelineCacheData(pipelineCache) } }

// --- [ vkMergePipelineCaches ] ---
fun Device.mergePipelineCaches(dstCache: VkPipelineCache, srcCaches: VkPipelineCache_Array): VkResult =
        VkStack { it.run { mergePipelineCaches(dstCache, srcCaches) } }

// --- [ vkCreateGraphicsPipelines ] ---

fun Device.createGraphicsPipeline(pipelineCache: VkPipelineCache, createInfos: Array<GraphicsPipelineCreateInfo>): VkPipeline_Array =
        VkStack { it.run { createGraphicsPipeline(pipelineCache, createInfos) } }

fun Device.createGraphicsPipeline(pipelineCache: VkPipelineCache, createInfo: GraphicsPipelineCreateInfo): VkPipeline =
        VkStack { it.run { createGraphicsPipeline(pipelineCache, createInfo) } }

// overloads with pipelineCache = null
infix fun Device.createGraphicsPipeline(createInfos: Array<GraphicsPipelineCreateInfo>): VkPipeline_Array = createGraphicsPipeline(VkPipelineCache.NULL, createInfos)
infix fun Device.createGraphicsPipeline(createInfo: GraphicsPipelineCreateInfo): VkPipeline = createGraphicsPipeline(VkPipelineCache.NULL, createInfo)

// --- [ vkCreateComputePipelines ] ---

fun Device.createComputePipelines(pipelineCache: VkPipelineCache, createInfos: Array<ComputePipelineCreateInfo>): VkPipeline_Array =
        VkStack { it.run { createComputePipelines(pipelineCache, createInfos) } }

fun Device.createComputePipelines(pipelineCache: VkPipelineCache, createInfo: ComputePipelineCreateInfo): VkPipeline =
        VkStack { it.run { createComputePipelines(pipelineCache, createInfo) } }

// overloads with pipelineCache = null
infix fun Device.createComputePipelines(createInfos: Array<ComputePipelineCreateInfo>): VkPipeline_Array = createComputePipelines(VkPipelineCache.NULL, createInfos)
infix fun Device.createComputePipelines(createInfo: ComputePipelineCreateInfo): VkPipeline = createComputePipelines(VkPipelineCache.NULL, createInfo)

// --- [ vkCreatePipelineLayout ] ---
infix fun Device.createPipelineLayout(createInfo: PipelineLayoutCreateInfo): VkPipelineLayout =
        VkStack { it.run { createPipelineLayout(createInfo) } }

// --- [ vkCreateSampler ] ---
infix fun Device.createSampler(createInfo: SamplerCreateInfo): VkSampler =
        VkStack { it.run { createSampler(createInfo) } }

// --- [ vkCreateDescriptorSetLayout ] ---
infix fun Device.createDescriptorSetLayout(createInfo: DescriptorSetLayoutCreateInfo): VkDescriptorSetLayout =
        VkStack { it.run { createDescriptorSetLayout(createInfo) } }

// --- [ vkCreateDescriptorPool ] ---
infix fun Device.createDescriptorPool(createInfo: DescriptorPoolCreateInfo): VkDescriptorPool =
        VkStack { it.run { createDescriptorPool(createInfo) } }

// --- [ vkAllocateDescriptorSets ] ---

infix fun Device.allocateDescriptorSets(allocateInfo: DescriptorSetAllocateInfo): VkDescriptorSet_Array =
        VkStack { it.run { allocateDescriptorSets(allocateInfo) } }

infix fun Device.allocateDescriptorSet(allocateInfo: DescriptorSetAllocateInfo): VkDescriptorSet =
        VkStack { it.run { allocateDescriptorSet(allocateInfo) } }

// --- [ vkFreeDescriptorSets ] ---

fun Device.freeDescriptorSets(descriptorPool: VkDescriptorPool, descriptorSets: VkDescriptorSet_Array): VkResult =
        VkStack { it.run { freeDescriptorSets(descriptorPool, descriptorSets) } }

fun Device.freeDescriptorSets(descriptorPool: VkDescriptorPool, descriptorSet: VkDescriptorSet): VkResult =
        VkStack { it.run { freeDescriptorSets(descriptorPool, descriptorSet) } }

// --- [ vkUpdateDescriptorSets ] ---

fun Device.updateDescriptorSets(descriptorWrites: Array<WriteDescriptorSet>?, descriptorCopies: Array<CopyDescriptorSet>? = null) =
        VkStack { it.run { updateDescriptorSets(descriptorWrites, descriptorCopies) } }

fun Device.updateDescriptorSet(descriptorWrite: WriteDescriptorSet?, descriptorCopy: CopyDescriptorSet? = null) =
        VkStack { it.run { updateDescriptorSet(descriptorWrite, descriptorCopy) } }

// --- [ vkCreateFramebuffer ] ---

infix fun Device.createFramebuffer(createInfo: FramebufferCreateInfo): VkFramebuffer =
        VkStack { it.run { createFramebuffer(createInfo) } }

// [JVM]
fun Device.createFramebufferArray(createInfo: FramebufferCreateInfo, imageViews: VkImageView_Array): VkFramebuffer_Array =
        VkStack { it.run { createFramebufferArray(createInfo, imageViews) } }

// --- [ vkCreateRenderPass ] ---
infix fun Device.createRenderPass(createInfo: RenderPassCreateInfo): VkRenderPass =
        VkStack { it.run { createRenderPass(createInfo) } }

// --- [ vkGetRenderAreaGranularity ] ---
infix fun Device.getRenderAreaGranularity(renderPass: VkRenderPass): Extent2D =
        VkStack { it.run { getRenderAreaGranularity(renderPass) } }

// --- [ vkCreateCommandPool ] ---
infix fun Device.createCommandPool(createInfo: CommandPoolCreateInfo): VkCommandPool =
        VkStack { it.run { createCommandPool(createInfo) } }

// --- [ vkAllocateCommandBuffers ] ---

infix fun Device.allocateCommandBuffer(allocateInfo: CommandBufferAllocateInfo): CommandBuffer =
        VkStack { it.run { allocateCommandBuffer(allocateInfo) } }

infix fun Device.allocateCommandBuffers(allocateInfo: CommandBufferAllocateInfo): Array<CommandBuffer> =
        VkStack { it.run { allocateCommandBuffers(allocateInfo) } }

// --- [ vkFreeCommandBuffers ] ---

fun Device.freeCommandBuffers(commandPool: VkCommandPool, commandBuffer: CommandBuffer) =
        VkStack { it.run { freeCommandBuffers(commandPool, commandBuffer) } }

fun Device.freeCommandBuffers(commandPool: VkCommandPool, commandBuffers: Array<CommandBuffer>) =
        VkStack { it.run { freeCommandBuffers(commandPool, commandBuffers) } }

// --- [ vkBeginCommandBuffer ] ---
infix fun CommandBuffer.begin(beginInfo: CommandBufferBeginInfo): VkResult =
        VkStack { it.run { begin(beginInfo) } }

// [JVM] begin { .. } end
fun <R> CommandBuffer.record(beginInfo: CommandBufferBeginInfo, block: (CommandBuffer) -> R): R =
        VkStack { it.run { record(beginInfo, block) } }

// --- [ vkCmdSetViewport ] ---

infix fun CommandBuffer.setViewport(viewport: Viewport) =
        VkStack { it.run { setViewport(viewport) } }

fun CommandBuffer.setViewport(firstViewport: Int, viewports: Array<Viewport>) =
        VkStack { it.run { setViewport(firstViewport, viewports) } }

// --- [ vkCmdSetScissor ] ---

fun CommandBuffer.setScissor(firstScissor: Int, scissors: Array<Rect2D>) =
        VkStack { it.run { setScissor(firstScissor, scissors) } }

infix fun CommandBuffer.setScissor(scissor: Rect2D) =
        VkStack { it.run { setScissor(scissor) } }

// --- [ vkCmdSetBlendConstants ] ---
infix fun CommandBuffer.setBlendConstants(blendConstants: Vec4) =
        VkStack { it.run { setBlendConstants(blendConstants) } }

// --- [ vkCmdBindDescriptorSets ] ---

fun CommandBuffer.bindDescriptorSets(pipelineBindPoint: VkPipelineBindPoint, layout: VkPipelineLayout, firstSet: Int, descriptorSets: VkDescriptorSet_Array, dynamicOffsets: IntArray) =
        VkStack { it.run { bindDescriptorSets(pipelineBindPoint, layout, firstSet, descriptorSets, dynamicOffsets) } }

fun CommandBuffer.bindDescriptorSets(pipelineBindPoint: VkPipelineBindPoint, layout: VkPipelineLayout, firstSet: Int, descriptorSet: VkDescriptorSet, dynamicOffset: Int) =
        VkStack { it.run { bindDescriptorSets(pipelineBindPoint, layout, firstSet, descriptorSet, dynamicOffset) } }

// --- [ vkCmdBindVertexBuffers ] ---

fun CommandBuffer.bindVertexBuffers(firstBinding: Int, bindingCount: Int, buffers: VkBuffer_Array, offsets: VkDeviceSize_Array) =
        VkStack { it.run { bindVertexBuffers(firstBinding, bindingCount, buffers, offsets) } }

fun CommandBuffer.bindVertexBuffers(firstBinding: Int, bindingCount: Int, buffer: VkBuffer, offset: VkDeviceSize) =
        VkStack { it.run { bindVertexBuffers(firstBinding, bindingCount, buffer, offset) } }

// firstBinding and bindCount defaulted to 0 and 1
fun CommandBuffer.bindVertexBuffers(buffer: VkBuffer, offset: VkDeviceSize = VkDeviceSize.NULL) =
        VkStack { it.run { bindVertexBuffers(buffer, offset) } }

// bindCount extrapolated from buffers
fun CommandBuffer.bindVertexBuffers(firstBinding: Int, buffers: VkBuffer_Array, offsets: VkDeviceSize_Array) =
        VkStack { it.run { bindVertexBuffers(firstBinding, buffers, offsets) } }

// --- [ vkCmdCopyBuffer ] ---

fun CommandBuffer.copyBuffer(srcBuffer: VkBuffer, dstBuffer: VkBuffer, regions: Array<BufferCopy>) =
        VkStack { it.run { copyBuffer(srcBuffer, dstBuffer, regions) } }

fun CommandBuffer.copyBuffer(srcBuffer: VkBuffer, dstBuffer: VkBuffer, region: BufferCopy) =
        VkStack { it.run { copyBuffer(srcBuffer, dstBuffer, region) } }

// --- [ vkCmdCopyImage ] ---

fun CommandBuffer.copyImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, regions: Array<ImageCopy>) =
        VkStack { it.run { copyImage(srcImage, srcImageLayout, dstImage, dstImageLayout, regions) } }

fun CommandBuffer.copyImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, region: ImageCopy) =
        VkStack { it.run { copyImage(srcImage, srcImageLayout, dstImage, dstImageLayout, region) } }

// --- [ vkCmdBlitImage ] ---

fun CommandBuffer.blitImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, regions: Array<ImageBlit>, filter: VkFilter) =
        VkStack { it.run { blitImage(srcImage, srcImageLayout, dstImage, dstImageLayout, regions, filter) } }

fun CommandBuffer.blitImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, region: ImageBlit, filter: VkFilter) =
        VkStack { it.run { blitImage(srcImage, srcImageLayout, dstImage, dstImageLayout, region, filter) } }

// --- [ vkCmdCopyBufferToImage ] ---

fun CommandBuffer.copyBufferToImage(srcBuffer: VkBuffer, dstImage: VkImage, dstImageLayout: VkImageLayout, regions: Array<BufferImageCopy>) =
        VkStack { it.run { copyBufferToImage(srcBuffer, dstImage, dstImageLayout, regions) } }

fun CommandBuffer.copyBufferToImage(srcBuffer: VkBuffer, dstImage: VkImage, dstImageLayout: VkImageLayout, region: BufferImageCopy) =
        VkStack { it.run { copyBufferToImage(srcBuffer, dstImage, dstImageLayout, region) } }

// --- [ vkCmdCopyImageToBuffer ] ---

fun CommandBuffer.copyImageToBuffer(srcImage: VkImage, srcImageLayout: VkImageLayout, dstBuffer: VkBuffer, regions: Array<BufferImageCopy>) =
        VkStack { it.run { copyImageToBuffer(srcImage, srcImageLayout, dstBuffer, regions) } }

fun CommandBuffer.copyImageToBuffer(srcImage: VkImage, srcImageLayout: VkImageLayout, dstBuffer: VkBuffer, region: BufferImageCopy) =
        VkStack { it.run { copyImageToBuffer(srcImage, srcImageLayout, dstBuffer, region) } }

// --- [ vkCmdClearColorImage ] ---

fun CommandBuffer.clearColorImage(image: VkImage, imageLayout: VkImageLayout, color: ClearColorValue, ranges: Array<ImageSubresourceRange>) =
        VkStack { it.run { clearColorImage(image, imageLayout, color, ranges) } }

fun CommandBuffer.clearColorImage(image: VkImage, imageLayout: VkImageLayout, color: ClearColorValue, range: ImageSubresourceRange) =
        VkStack { it.run { clearColorImage(image, imageLayout, color, range) } }

// --- [ vkCmdClearDepthStencilImage ] ---

fun CommandBuffer.clearDepthStencilImage(image: VkImage, imageLayout: VkImageLayout, depthStencil: ClearDepthStencilValue, ranges: Array<ImageSubresourceRange>) =
        VkStack { it.run { clearDepthStencilImage(image, imageLayout, depthStencil, ranges) } }

fun CommandBuffer.clearDepthStencilImage(image: VkImage, imageLayout: VkImageLayout, depthStencil: ClearDepthStencilValue, range: ImageSubresourceRange) =
        VkStack { it.run { clearDepthStencilImage(image, imageLayout, depthStencil, range) } }

// --- [ vkCmdClearAttachments ] ---

fun CommandBuffer.clearAttachments(attachments: Array<ClearAttachment>, rects: Array<ClearRect>) =
        VkStack { it.run { clearAttachments(attachments, rects) } }

fun CommandBuffer.clearAttachments(attachment: ClearAttachment, rect: ClearRect) =
        VkStack { it.run { clearAttachments(attachment, rect) } }

// --- [ vkCmdResolveImage ] ---

fun CommandBuffer.resolveImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, regions: Array<ImageResolve>) =
        VkStack { it.run { resolveImage(srcImage, srcImageLayout, dstImage, dstImageLayout, regions) } }

fun CommandBuffer.resolveImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, region: ImageResolve) =
        VkStack { it.run { resolveImage(srcImage, srcImageLayout, dstImage, dstImageLayout, region) } }

// --- [ vkCmdWaitEvents ] ---

fun CommandBuffer.waitEvents(events: VkEvent_Array, srcStageMask: VkPipelineStageFlags, dstStageMask: VkPipelineStageFlags,
                             memoryBarriers: Array<MemoryBarrier>, bufferMemoryBarriers: Array<BufferMemoryBarrier>,
                             imageMemoryBarriers: Array<ImageMemoryBarrier>) =
        VkStack { it.run { waitEvents(events, srcStageMask, dstStageMask, memoryBarriers, bufferMemoryBarriers, imageMemoryBarriers) } }

// --- [ vkCmdPipelineBarrier ] ---

fun CommandBuffer.pipelineBarrier(srcStageMask: VkPipelineStageFlags, dstStageMask: VkPipelineStageFlags, dependencyFlags: VkDependencyFlags,
                                  memoryBarriers: Array<MemoryBarrier>? = null, bufferMemoryBarriers: Array<BufferMemoryBarrier>? = null,
                                  imageMemoryBarriers: Array<ImageMemoryBarrier>? = null) =
        VkStack { it.run { pipelineBarrier(srcStageMask, dstStageMask, dependencyFlags, memoryBarriers, bufferMemoryBarriers, imageMemoryBarriers) } }

fun CommandBuffer.pipelineBarrier(srcStageMask: VkPipelineStageFlags, dstStageMask: VkPipelineStageFlags, dependencyFlags: VkDependencyFlags,
                                  memoryBarrier: MemoryBarrier? = null, bufferMemoryBarrier: BufferMemoryBarrier? = null, imageMemoryBarrier: ImageMemoryBarrier? = null) =
        VkStack { it.run { pipelineBarrier(srcStageMask, dstStageMask, dependencyFlags, memoryBarrier, bufferMemoryBarrier, imageMemoryBarrier) } }

// --- [ vkCmdBeginRenderPass ] ---
fun CommandBuffer.beginRenderPass(renderPassBegin: RenderPassBeginInfo, contents: VkSubpassContents = VkSubpassContents.INLINE) =
        VkStack { it.run { beginRenderPass(renderPassBegin, contents) } }

// [JVM]
fun <R> CommandBuffer.renderPass(renderPassBegin: RenderPassBeginInfo, contents: VkSubpassContents = VkSubpassContents.INLINE, block: () -> R): R =
        VkStack { it.run { renderPass(renderPassBegin, contents, block) } }

// --- [ vkCmdExecuteCommands ] ---

infix fun CommandBuffer.executeCommands(commandBuffers: Array<CommandBuffer>) =
        VkStack { it.run { executeCommands(commandBuffers) } }

infix fun CommandBuffer.executeCommands(commandBuffer: CommandBuffer) =
        VkStack { it.run { executeCommands(commandBuffer) } }