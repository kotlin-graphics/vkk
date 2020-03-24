package vkk._10

import glm_.i
import glm_.vec4.Vec4
import kool.BytePtr
import kool.Ptr
import kool.adr
import org.lwjgl.system.JNI.*
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.system.MemoryUtil.memGetAddress
import org.lwjgl.system.Pointer
import org.lwjgl.vulkan.*
import vkk.*
import vkk._10.structs.*
import vkk.entities.*
import vkk.identifiers.*
import vkk.identifiers.VK

interface VkStack_VK10 {

    val vkStack: VkStack

    // --- [ vkCreateInstance ] ---
    infix fun vk.createInstance(createInfo: InstanceCreateInfo): Instance =
            Instance(vkStack.pointerAdr { VK_CHECK_RESULT(callPPPI(createInfo write vkStack, NULL, it, VK.globalCommands!!.vkCreateInstance)) }, createInfo)

    // --- [ vkEnumeratePhysicalDevices ] ---
    val Instance.physicalDevices: Array<PhysicalDevice>
        get() = vkStack {
            var pPhysicalDevices: Ptr = NULL
            val pPhysicalDeviceCount = vkStack.mInt()
            var physicalDeviceCount: Int
            var result: VkResult
            do {
                result = VkResult(callPPPI(adr, pPhysicalDeviceCount.adr, pPhysicalDevices, capabilities.vkEnumeratePhysicalDevices))
                physicalDeviceCount = pPhysicalDeviceCount()
                if (result == VkResult.SUCCESS && physicalDeviceCount != 0) {
                    pPhysicalDevices = vkStack.nmalloc(Pointer.POINTER_SIZE, physicalDeviceCount shl Pointer.POINTER_SHIFT)
                    result = VkResult(callPPPI(adr, pPhysicalDeviceCount.adr, pPhysicalDevices, capabilities.vkEnumeratePhysicalDevices))
                }
            } while (result == VkResult.INCOMPLETE)
            Array(physicalDeviceCount) { PhysicalDevice(memGetAddress(pPhysicalDevices + it * Pointer.POINTER_SIZE), this) }
        }

    // --- [ vkGetPhysicalDeviceFeatures ] ---
    val PhysicalDevice.features: PhysicalDeviceFeatures
        get() = PhysicalDeviceFeatures.read(vkStack) { callPPV(adr, it, capabilities.vkGetPhysicalDeviceFeatures) }

    // --- [ vkGetPhysicalDeviceFormatProperties ] ---
    infix fun PhysicalDevice.getFormatProperties(format: VkFormat): FormatProperties =
            vkStack { FormatProperties.read(vkStack) { callPPV(adr, format.i, it, capabilities.vkGetPhysicalDeviceFormatProperties) } }

    // --- [ vkGetPhysicalDeviceImageFormatProperties ] ---
    fun PhysicalDevice.getImageFormatProperties(format: VkFormat, type: VkImageType, tiling: VkImageTiling, usage: VkImageUsageFlags, flags: VkImageCreateFlags): ImageFormatProperties =
            vkStack { ImageFormatProperties.read(vkStack) { VK_CHECK_RESULT(callPPI(adr, format.i, type.i, tiling.i, usage, flags, it, capabilities.vkGetPhysicalDeviceImageFormatProperties)) } }

    // --- [ vkGetPhysicalDeviceProperties ] ---
    val PhysicalDevice.properties: PhysicalDeviceProperties
        get() = vkStack { PhysicalDeviceProperties.read(vkStack) { callPPV(adr, it, capabilities.vkGetPhysicalDeviceProperties) } }

    // --- [ vkGetPhysicalDeviceQueueFamilyProperties ] ---
    val PhysicalDevice.queueFamilyProperties: Array<QueueFamilyProperties>
        get() = vkStack {
            val pCount = vkStack.mInt()
            callPPPV(adr, pCount.adr, NULL, capabilities.vkGetPhysicalDeviceQueueFamilyProperties)
            val count = pCount()
            val pQueueFamilyProperties = vkStack.ncalloc(VkQueueFamilyProperties.ALIGNOF, count, VkQueueFamilyProperties.SIZEOF)
            callPPPV(adr, pCount.adr, pQueueFamilyProperties, capabilities.vkGetPhysicalDeviceQueueFamilyProperties)
            Array(count) { QueueFamilyProperties(BytePtr(pQueueFamilyProperties + VkQueueFamilyProperties.SIZEOF * it)) }
        }

    // --- [ vkGetPhysicalDeviceMemoryProperties ] ---
    val PhysicalDevice.memoryProperties: PhysicalDeviceMemoryProperties
        get() = vkStack { PhysicalDeviceMemoryProperties.read(vkStack) { callPPV(adr, it, capabilities.vkGetPhysicalDeviceMemoryProperties) } }

    // --- [ vkGetInstanceProcAddr ] ---
    infix fun Instance.getProcAddr(name: String) = vkStack.asciiAdr(name) { callPPP(adr, it, VK.globalCommands!!.vkGetInstanceProcAddr) }

    // --- [ vkGetDeviceProcAddr ] ---
    infix fun Device.getProcAddr(name: String) = vkStack.asciiAdr(name) { callPPP(adr, it, capabilities.vkGetDeviceProcAddr) }

    // --- [ vkCreateDevice ] ---
    infix fun PhysicalDevice.createDevice(createInfo: DeviceCreateInfo): Device = vkStack {
        val handle = vkStack.pointerAdr { VK_CHECK_RESULT(callPPPPI(adr, createInfo write vkStack, NULL, it, capabilities.vkCreateDevice)) }
        Device(handle, this, createInfo)
    }

    // --- [ vkEnumerateInstanceExtensionProperties ] ---
    fun vk.enumerateInstanceExtensionProperties(layerName: String? = null): Array<ExtensionProperties> = vkStack {
        val pLayerName = layerName?.let { vkStack.utf8Adr(layerName) } ?: NULL
        var properties: Ptr = NULL
        val pPropertyCount = vkStack.mInt()
        var propertyCount: Int
        var result: VkResult
        do {
            result = VkResult(callPPPI(pLayerName, pPropertyCount.adr, properties, VK.globalCommands!!.vkEnumerateInstanceExtensionProperties))
            propertyCount = pPropertyCount()
            if (result == VkResult.SUCCESS && propertyCount != 0) {
                properties = vkStack.ncalloc(VkExtensionProperties.ALIGNOF, propertyCount, VkExtensionProperties.SIZEOF)
                result = VkResult(callPPPI(pLayerName, pPropertyCount.adr, properties, VK.globalCommands!!.vkEnumerateInstanceExtensionProperties))
            }
        } while (result == VkResult.INCOMPLETE)
        Array(propertyCount) { ExtensionProperties(BytePtr(properties + it * VkExtensionProperties.SIZEOF)) }
    }

    // --- [ vkEnumerateDeviceExtensionProperties ] ---
    fun PhysicalDevice.enumerateDeviceExtensionProperties(layerName: String? = null): Array<ExtensionProperties> = vkStack {
        val pLayerName = layerName?.let { vkStack.utf8Adr(it) } ?: NULL
        var properties: Ptr = NULL
        val pPropertyCount = vkStack.mInt()
        var propertyCount: Int
        var result: VkResult
        do {
            result = VkResult(callPPPPI(adr, pLayerName, pPropertyCount.adr, properties, capabilities.vkEnumerateDeviceExtensionProperties))
            propertyCount = pPropertyCount[0]
            if (result == VkResult.SUCCESS && propertyCount != 0) {
                properties = vkStack.ncalloc(VkExtensionProperties.ALIGNOF, propertyCount, VkExtensionProperties.SIZEOF)
                result = VkResult(callPPPPI(adr, pLayerName, pPropertyCount.adr, properties, capabilities.vkEnumerateDeviceExtensionProperties))
            }
        } while (result == VkResult.INCOMPLETE)
        Array(propertyCount) { ExtensionProperties(BytePtr(properties + it * VkExtensionProperties.SIZEOF)) }
    }

    // --- [ vkEnumerateInstanceLayerProperties ] ---
    fun vk.enumerateInstanceLayerProperties(): Array<LayerProperties> = vkStack {
        var properties: Ptr = NULL
        val pPropertyCount = vkStack.mInt()
        var propertyCount: Int
        var result: VkResult
        do {
            result = VkResult(callPPI(pPropertyCount.adr, properties, VK.globalCommands!!.vkEnumerateInstanceLayerProperties))
            propertyCount = pPropertyCount()
            if (result == VkResult.SUCCESS && propertyCount != 0) {
                properties = vkStack.ncalloc(VkLayerProperties.ALIGNOF, propertyCount, VkLayerProperties.SIZEOF)
                result = VkResult(callPPI(pPropertyCount.adr, properties, VK.globalCommands!!.vkEnumerateInstanceLayerProperties))
            }
        } while (result == VkResult.INCOMPLETE)
        return Array(propertyCount) {
            LayerProperties(BytePtr(properties + it * VkLayerProperties.SIZEOF))
        }
    }

    // --- [ vkEnumerateDeviceLayerProperties ] ---
    fun PhysicalDevice.enumerateDeviceLayerProperties(): Array<LayerProperties> = vkStack {
        var properties: Ptr = NULL
        var propertyCount: Int
        val pPropertyCount = vkStack.mInt()
        var result: VkResult
        do {
            result = VkResult(callPPPI(adr, pPropertyCount.adr, properties, capabilities.vkEnumerateDeviceLayerProperties))
            propertyCount = pPropertyCount[0]
            if (result == VkResult.SUCCESS && propertyCount != 0) {
                properties = vkStack.ncalloc(VkLayerProperties.ALIGNOF, propertyCount, VkLayerProperties.SIZEOF)
                result = VkResult(callPPPI(adr, pPropertyCount.adr, properties, capabilities.vkEnumerateDeviceLayerProperties))
            }
        } while (result == VkResult.INCOMPLETE)
        Array(propertyCount) { LayerProperties(BytePtr(properties + it * VkLayerProperties.SIZEOF)) }
    }

    // --- [ vkGetDeviceQueue ] ---
    fun Device.getQueue(queueFamilyIndex: Int, queueIndex: Int = 0): Queue =
            vkStack { Queue(vkStack.pointerAdr { callPPV(adr, queueFamilyIndex, queueIndex, it, capabilities.vkGetDeviceQueue) }, this) }

    // --- [ vkQueueSubmit ] ---
    fun Queue.submit(submit: SubmitInfo, fence: VkFence = VkFence.NULL): VkResult =
            vkStack { VkResult(callPPJI(adr, 1, submit write vkStack, fence.L, capabilities.vkQueueSubmit)).andCheck() }

    // --- [ vkAllocateMemory ] ---
    infix fun Device.allocateMemory(allocateInfo: MemoryAllocateInfo): VkDeviceMemory =
            vkStack { VkDeviceMemory(vkStack.longAdr { VkResult(callPPPPI(adr, allocateInfo write vkStack, NULL, it, capabilities.vkAllocateMemory)) }) }

    // --- [ vkMapMemory ] ---

    fun Device.mapMemory(memory: VkDeviceMemory, offset: VkDeviceSize, size: VkDeviceSize, flags: VkMemoryMapFlags = 0): Ptr =
            vkStack.pointerAdr { callPJJJPI(adr, memory.L, offset.L, size.L, flags, it, capabilities.vkMapMemory) }

    // [JVM]: vkMapMemory + vkUnmapMemory
    fun <R> Device.mappedMemory(memory: VkDeviceMemory, offset: VkDeviceSize, size: VkDeviceSize, flags: VkMemoryMapFlags = 0, block: (Ptr) -> R): R =
            block(mapMemory(memory, offset, size, flags)).also { unmapMemory(memory) }

    // --- [ vkFlushMappedMemoryRanges ] ---

    infix fun Device.flushMappedMemoryRanges(memoryRanges: Array<MappedMemoryRange>): VkResult =
            vkStack { VkResult(callPPI(adr, memoryRanges.size, memoryRanges write vkStack, capabilities.vkFlushMappedMemoryRanges)) }

    infix fun Device.flushMappedMemoryRanges(memoryRange: MappedMemoryRange): VkResult =
            vkStack { VkResult(callPPI(adr, 1, memoryRange write vkStack, capabilities.vkFlushMappedMemoryRanges)) }

    // --- [ vkInvalidateMappedMemoryRanges ] ---

    infix fun Device.invalidateMappedMemoryRanges(memoryRanges: Array<MappedMemoryRange>): VkResult =
            vkStack { VkResult(callPPI(adr, memoryRanges.size, memoryRanges write vkStack, capabilities.vkInvalidateMappedMemoryRanges)) }

    infix fun Device.invalidateMappedMemoryRanges(memoryRange: MappedMemoryRange): VkResult =
            vkStack { VkResult(callPPI(adr, 1, memoryRange write vkStack, capabilities.vkInvalidateMappedMemoryRanges)) }

    // --- [ vkGetDeviceMemoryCommitment ] ---
    infix fun Device.getMemoryCommitment(memory: VkDeviceMemory): VkDeviceSize =
            VkDeviceSize(vkStack.longAdr { callPJPV(adr, memory.L, it, capabilities.vkGetDeviceMemoryCommitment) })

    // --- [ vkGetBufferMemoryRequirements ] ---
    infix fun Device.getBufferMemoryRequirements(buffer: VkBuffer): MemoryRequirements =
            vkStack { MemoryRequirements.read(vkStack) { callPJPV(adr, buffer.L, it, capabilities.vkGetBufferMemoryRequirements) } }

    // --- [ vkGetImageMemoryRequirements ] ---
    infix fun Device.getImageMemoryRequirements(image: VkImage): MemoryRequirements =
            vkStack { MemoryRequirements.read(vkStack) { callPJPV(adr, image.L, it, capabilities.vkGetImageMemoryRequirements) } }

    // --- [ vkGetImageSparseMemoryRequirements ] ---
    infix fun Device.getImageSparseMemoryRequirements(image: VkImage): Array<SparseImageMemoryRequirements> = vkStack {
        val pSparseMemoryRequirementCount = vkStack.mInt()
        callPJPPV(adr, image.L, pSparseMemoryRequirementCount.adr, NULL, capabilities.vkGetImageSparseMemoryRequirements)
        val sparseMemoryRequirementCount = pSparseMemoryRequirementCount()
        val sparseMemoryRequirements = vkStack.ncalloc(VkSparseImageMemoryRequirements.ALIGNOF, sparseMemoryRequirementCount, VkSparseImageMemoryRequirements.SIZEOF)
        callPJPPV(adr, image.L, pSparseMemoryRequirementCount.adr, sparseMemoryRequirements, capabilities.vkGetImageSparseMemoryRequirements)
        Array(sparseMemoryRequirementCount) { SparseImageMemoryRequirements(BytePtr(sparseMemoryRequirements + it * VkSparseImageMemoryRequirements.SIZEOF)) }
    }

    // --- [ vkGetPhysicalDeviceSparseImageFormatProperties ] ---
    fun PhysicalDevice.getSparseImageFormatProperties(format: VkFormat, type: VkImageType, samples: VkSampleCount, usage: VkImageUsageFlags, tiling: VkImageTiling): Array<SparseImageFormatProperties> = vkStack {
        val pPropertyCount = vkStack.mInt()
        callPPPV(adr, format.i, type.i, samples.i, usage, tiling.i, pPropertyCount.adr, NULL, capabilities.vkGetPhysicalDeviceSparseImageFormatProperties)
        val propertyCount = pPropertyCount[0]
        val properties = vkStack.ncalloc(VkSparseImageFormatProperties.ALIGNOF, propertyCount, VkSparseImageFormatProperties.SIZEOF)
        callPPPV(adr, format.i, type.i, samples.i, usage, tiling.i, pPropertyCount.adr, properties, capabilities.vkGetPhysicalDeviceSparseImageFormatProperties)
        Array(propertyCount) {
            SparseImageFormatProperties(BytePtr(properties + it * VkSparseImageFormatProperties.SIZEOF))
        }
    }

    // --- [ vkQueueBindSparse ] ---
    fun Queue.bindSparse(bindInfos: Array<BindSparseInfo>, fence: VkFence = VkFence.NULL): VkResult =
            vkStack { VkResult(callPPJI(adr, bindInfos.size, bindInfos write vkStack, fence.L, capabilities.vkQueueBindSparse)) }

    // --- [ vkCreateFence ] ---
    fun Device.createFence(createInfo: FenceCreateInfo = FenceCreateInfo()): VkFence =
            vkStack { VkFence(vkStack.longAdr { VkResult(callPPPPI(adr, createInfo write vkStack, NULL, it, capabilities.vkCreateFence)) }) }

    fun <R> Device.withFence(flags: VkFenceCreateFlags = 0, block: (VkFence) -> R): R = vkStack {
        val fence = createFence(FenceCreateInfo(flags))
        block(fence).also { destroy(fence) }
    }

    // --- [ vkResetFences ] ---

    infix fun Device.resetFences(fences: VkFence_Array): VkResult =
            vkStack { VkResult(callPPI(adr, fences.size, fences write vkStack, capabilities.vkResetFences)) }

    infix fun Device.resetFences(fence: VkFence): VkResult =
            vkStack.longAdr(fence.L) { VkResult(callPPI(adr, 1, it, capabilities.vkResetFences)) }

    // --- [ vkWaitForFences ] ---

    fun Device.waitForFences(fences: VkFence_Array, waitAll: Boolean, timeout: NanoSecond): VkResult =
            vkStack { VkResult(callPPJI(adr, fences.size, fences write vkStack, waitAll.i, timeout, capabilities.vkWaitForFences)) }

    fun Device.waitForFences(fence: VkFence, waitAll: Boolean, timeout: NanoSecond): VkResult =
            vkStack.longAdr(fence.L) { VkResult(callPPJI(adr, 1, it, waitAll.i, timeout, capabilities.vkWaitForFences)) }

    // --- [ vkCreateSemaphore ] ---
    fun Device.createSemaphore(createInfo: SemaphoreCreateInfo = SemaphoreCreateInfo()): VkSemaphore =
            vkStack { VkSemaphore(vkStack.longAdr { callPPPPI(adr, createInfo write vkStack, NULL, it, capabilities.vkCreateSemaphore) }) }

    // --- [ vkCreateEvent ] ---
    infix fun Device.createEvent(createInfo: EventCreateInfo): VkEvent =
            vkStack { VkEvent(vkStack.longAdr { VkResult(callPPPPI(adr, createInfo write vkStack, NULL, it, capabilities.vkCreateEvent)) }) }

    // --- [ vkCreateQueryPool ] ---
    infix fun Device.createQueryPool(createInfo: QueryPoolCreateInfo): VkQueryPool =
            vkStack { VkQueryPool(vkStack.longAdr { callPPPPI(adr, createInfo write vkStack, NULL, it, capabilities.vkCreateQueryPool) }) }

    // --- [ vkCreateBuffer ] ---
    infix fun Device.createBuffer(createInfo: BufferCreateInfo): VkBuffer =
            vkStack { VkBuffer(vkStack.longAdr { VkResult(callPPPPI(adr, createInfo write vkStack, NULL, it, capabilities.vkCreateBuffer)).check() }) }

    // --- [ vkCreateBufferView ] ---
    infix fun Device.createBufferView(createInfo: BufferViewCreateInfo): VkBufferView =
            vkStack { VkBufferView(vkStack.longAdr { VkResult(callPPPPI(adr, createInfo write vkStack, NULL, it, capabilities.vkCreateBufferView)).check() }) }

    // --- [ vkCreateImage ] ---
    infix fun Device.createImage(createInfo: ImageCreateInfo): VkImage =
            vkStack { VkImage(vkStack.longAdr { VkResult(callPPPPI(adr, createInfo write vkStack, NULL, it, capabilities.vkCreateImage)).check() }) }

    // --- [ vkGetImageSubresourceLayout ] ---
    fun Device.getImageSubresourceLayout(image: VkImage, subresource: ImageSubresource): SubresourceLayout =
            vkStack { SubresourceLayout.read(vkStack) { callPJPPV(adr, image.L, subresource write vkStack, it, capabilities.vkGetImageSubresourceLayout) } }

    // --- [ vkCreateImageView ] ---

    infix fun Device.createImageView(createInfo: ImageViewCreateInfo): VkImageView =
            vkStack { VkImageView(vkStack.longAdr { VkResult(callPPPPI(adr, createInfo write vkStack, NULL, it, capabilities.vkCreateImageView)).check() }) }

    // [JVM]
    fun Device.createImageViewArray(createInfo: ImageViewCreateInfo, images: VkImage_Array): VkImageView_Array =
            vkStack {
                val pCreateInfo = createInfo write vkStack
                val pImageView = vkStack.mLong()
                VkImageView_Array(images.size) { i ->
                    VkImageViewCreateInfo.nimage(pCreateInfo, images[i].L)
                    VkResult(callPPPPI(adr, pCreateInfo, NULL, pImageView.adr, capabilities.vkCreateImageView)).check()
                    VkImageView(pImageView[0])
                }
            }

    // --- [ vkCreateShaderModule ] ---
    infix fun Device.createShaderModule(createInfo: ShaderModuleCreateInfo): VkShaderModule =
            vkStack { VkShaderModule(vkStack.longAdr { callPPPPI(adr, createInfo write vkStack, NULL, it, capabilities.vkCreateShaderModule) }) }

    // --- [ vkCreatePipelineCache ] ---
    fun Device.createPipelineCache(createInfo: PipelineCacheCreateInfo = PipelineCacheCreateInfo()): VkPipelineCache =
            vkStack { VkPipelineCache(vkStack.longAdr { callPPPPI(adr, createInfo write vkStack, NULL, it, capabilities.vkCreatePipelineCache) }) }

    // --- [ vkGetPipelineCacheData ] ---
    infix fun Device.getPipelineCacheData(pipelineCache: VkPipelineCache): ByteArray = vkStack {
        var data: Ptr = NULL
        val pDataSize = vkStack.mInt()
        var dataSize: Int
        var result: VkResult
        do {
            result = VkResult(callPJPPI(adr, pipelineCache.L, pDataSize.adr, data, capabilities.vkGetPipelineCacheData))
            dataSize = pDataSize[0]
            if (result == VkResult.SUCCESS && dataSize != 0) {
                data = vkStack.ncalloc(1, dataSize, 1)
                result = VkResult(callPJPPI(adr, pipelineCache.L, pDataSize.adr, data, capabilities.vkGetPipelineCacheData))
            }
        } while (result == VkResult.INCOMPLETE)
        ByteArray(dataSize) { MemoryUtil.memGetByte(data + it) }
    }

    // --- [ vkMergePipelineCaches ] ---
    fun Device.mergePipelineCaches(dstCache: VkPipelineCache, srcCaches: VkPipelineCache_Array): VkResult =
            vkStack { VkResult(callPJPI(adr, dstCache.L, srcCaches.size, srcCaches write vkStack, capabilities.vkMergePipelineCaches)) }

    // --- [ vkCreateGraphicsPipelines ] ---

    fun Device.createGraphicsPipeline(pipelineCache: VkPipelineCache, createInfos: Array<GraphicsPipelineCreateInfo>): VkPipeline_Array = vkStack {
        val pipelines = vkStack.mLong(createInfos.size)
        VkResult(callPJPPPI(adr, pipelineCache.L, createInfos.size, createInfos write vkStack, NULL, pipelines.adr, capabilities.vkCreateGraphicsPipelines))
        VkPipeline_Array(createInfos.size) { VkPipeline(pipelines[it]) }
    }

    fun Device.createGraphicsPipeline(pipelineCache: VkPipelineCache, createInfo: GraphicsPipelineCreateInfo): VkPipeline =
            vkStack { VkPipeline(vkStack.longAdr { VkResult(callPJPPPI(adr, pipelineCache.L, 1, createInfo write vkStack, NULL, it, capabilities.vkCreateGraphicsPipelines)).check() }) }

    // --- [ vkCreateComputePipelines ] ---

    fun Device.createComputePipelines(pipelineCache: VkPipelineCache, createInfos: Array<ComputePipelineCreateInfo>): VkPipeline_Array = vkStack {
        val pipelines = vkStack.mLong(createInfos.size)
        VkResult(callPJPPPI(adr, pipelineCache.L, createInfos.size, createInfos write vkStack, NULL, pipelines.adr, capabilities.vkCreateComputePipelines)).check()
        VkPipeline_Array(createInfos.size) { VkPipeline(pipelines[it]) }
    }

    fun Device.createComputePipelines(pipelineCache: VkPipelineCache, createInfo: ComputePipelineCreateInfo): VkPipeline =
            vkStack { VkPipeline(vkStack.longAdr { VkResult(callPJPPPI(adr, pipelineCache.L, 1, createInfo write vkStack, NULL, it, capabilities.vkCreateComputePipelines)).check() }) }

    // --- [ vkCreatePipelineLayout ] ---
    infix fun Device.createPipelineLayout(createInfo: PipelineLayoutCreateInfo): VkPipelineLayout =
            vkStack { VkPipelineLayout(vkStack.longAdr { callPPPPI(adr, createInfo write vkStack, NULL, it, capabilities.vkCreatePipelineLayout) }) }

    // --- [ vkCreateSampler ] ---
    infix fun Device.createSampler(createInfo: SamplerCreateInfo): VkSampler =
            vkStack { VkSampler(vkStack.longAdr { callPPPPI(adr, createInfo write vkStack, NULL, it, capabilities.vkCreateSampler) }) }

    // --- [ vkCreateDescriptorSetLayout ] ---
    infix fun Device.createDescriptorSetLayout(createInfo: DescriptorSetLayoutCreateInfo): VkDescriptorSetLayout =
            vkStack { VkDescriptorSetLayout(vkStack.longAdr { VkResult(callPPPPI(adr, createInfo write vkStack, NULL, it, capabilities.vkCreateDescriptorSetLayout)).check() }) }

    // --- [ vkCreateDescriptorPool ] ---
    infix fun Device.createDescriptorPool(createInfo: DescriptorPoolCreateInfo): VkDescriptorPool =
            vkStack { VkDescriptorPool(vkStack.longAdr { VkResult(callPPPPI(adr, createInfo write vkStack, NULL, it, capabilities.vkCreateDescriptorPool)).check() }) }

    // --- [ vkAllocateDescriptorSets ] ---

    infix fun Device.allocateDescriptorSets(allocateInfo: DescriptorSetAllocateInfo): VkDescriptorSet_Array = vkStack {
        val descriptors = vkStack.mLong(allocateInfo.setLayouts.size)
        VkResult(callPPPI(adr, allocateInfo write vkStack, descriptors.adr, capabilities.vkAllocateDescriptorSets))
        VkDescriptorSet_Array(allocateInfo.setLayouts.size) { VkDescriptorSet(descriptors[it]) }
    }

    infix fun Device.allocateDescriptorSet(allocateInfo: DescriptorSetAllocateInfo): VkDescriptorSet =
            vkStack { VkDescriptorSet(vkStack.longAdr { VkResult(callPPPI(adr, allocateInfo write vkStack, it, capabilities.vkAllocateDescriptorSets)).check() }) }

    // --- [ vkFreeDescriptorSets ] ---

    fun Device.freeDescriptorSets(descriptorPool: VkDescriptorPool, descriptorSets: VkDescriptorSet_Array): VkResult =
            vkStack { VkResult(callPJPI(adr, descriptorPool.L, descriptorSets.size, descriptorSets write vkStack, capabilities.vkFreeDescriptorSets)).andCheck() }

    fun Device.freeDescriptorSets(descriptorPool: VkDescriptorPool, descriptorSet: VkDescriptorSet): VkResult =
            vkStack.longAdr(descriptorSet.L) { VkResult(callPJPI(adr, descriptorPool.L, 1, it, capabilities.vkFreeDescriptorSets)).andCheck() }

    // --- [ vkUpdateDescriptorSets ] ---

    fun Device.updateDescriptorSets(descriptorWrites: Array<WriteDescriptorSet>, descriptorCopies: Array<CopyDescriptorSet>) =
            vkStack { callPPPV(adr, descriptorWrites.size, descriptorWrites write vkStack, descriptorCopies.size, descriptorCopies write vkStack, capabilities.vkUpdateDescriptorSets) }

    fun Device.updateDescriptorSets(descriptorWrite: WriteDescriptorSet, descriptorCopy: CopyDescriptorSet) =
            vkStack { callPPPV(adr, 1, descriptorWrite write vkStack, 1, descriptorCopy write vkStack, capabilities.vkUpdateDescriptorSets) }

    // --- [ vkCreateFramebuffer ] ---

    infix fun Device.createFramebuffer(createInfo: FramebufferCreateInfo): VkFramebuffer =
            vkStack { VkFramebuffer(vkStack.longAdr { VkResult(callPPPPI(adr, createInfo write vkStack, NULL, it, capabilities.vkCreateFramebuffer)).check() }) }

    // [JVM]
    fun Device.createFramebufferArray(createInfo: FramebufferCreateInfo, imageViews: VkImageView_Array): VkFramebuffer_Array = vkStack {
        val pCreateInfo = createInfo write vkStack
        VkFramebufferCreateInfo.nattachmentCount(pCreateInfo, 1)
        val pAttachment = vkStack.mLong()
        MemoryUtil.memPutAddress(pCreateInfo + VkFramebufferCreateInfo.PATTACHMENTS, pAttachment.adr)
        val pFramebuffer = vkStack.mLong()
        VkFramebuffer_Array(imageViews.size) { i ->
            pAttachment[0] = imageViews[i].L
            VkResult(callPPPPI(adr, pCreateInfo, NULL, pFramebuffer.adr, capabilities.vkCreateFramebuffer)).check()
            VkFramebuffer(pFramebuffer[0])
        }
    }

    // --- [ vkCreateRenderPass ] ---
    infix fun Device.createRenderPass(createInfo: RenderPassCreateInfo): VkRenderPass =
            vkStack { VkRenderPass(vkStack.longAdr { callPPPPI(adr, createInfo write vkStack, NULL, it, capabilities.vkCreateRenderPass) }) }

    // --- [ vkGetRenderAreaGranularity ] ---
    infix fun Device.getRenderAreaGranularity(renderPass: VkRenderPass): Extent2D =
            vkStack { Extent2D.read(vkStack) { callPJPV(adr, renderPass.L, it, capabilities.vkGetRenderAreaGranularity) } }

    // --- [ vkCreateCommandPool ] ---
    infix fun Device.createCommandPool(createInfo: CommandPoolCreateInfo): VkCommandPool =
            vkStack { VkCommandPool(vkStack.longAdr { VkResult(callPPPPI(adr, createInfo write vkStack, NULL, it, capabilities.vkCreateCommandPool)).check() }) }

    // --- [ vkAllocateCommandBuffers ] ---

    infix fun Device.allocateCommandBuffer(allocateInfo: CommandBufferAllocateInfo): CommandBuffer =
            vkStack { CommandBuffer(vkStack.pointerAdr { VkResult(callPPPI(adr, allocateInfo write vkStack, it, capabilities.vkAllocateCommandBuffers)).check() }, this) }

    infix fun Device.allocateCommandBuffers(allocateInfo: CommandBufferAllocateInfo): Array<CommandBuffer> = vkStack {
        val pCommandBuffers = vkStack.mPointer(allocateInfo.commandBufferCount)
        VkResult(callPPPI(adr, allocateInfo write vkStack, pCommandBuffers.adr, capabilities.vkAllocateCommandBuffers))
        Array(allocateInfo.commandBufferCount) { CommandBuffer(memGetAddress(pCommandBuffers[it]), this) }
    }

    // --- [ vkFreeCommandBuffers ] ---

    fun Device.freeCommandBuffers(commandPool: VkCommandPool, commandBuffer: CommandBuffer) =
            vkStack.longAdr(commandBuffer.adr) { callPJPV(adr, commandPool.L, 1, it, capabilities.vkFreeCommandBuffers) }

    fun Device.freeCommandBuffers(commandPool: VkCommandPool, commandBuffers: Array<CommandBuffer>) =
            vkStack { callPJPV(adr, commandPool.L, commandBuffers.size, commandBuffers write vkStack, capabilities.vkFreeCommandBuffers) }

    // --- [ vkBeginCommandBuffer ] ---
    infix fun CommandBuffer.begin(beginInfo: CommandBufferBeginInfo): VkResult =
            vkStack { VkResult(callPPI(adr, beginInfo write vkStack, capabilities.vkBeginCommandBuffer)).andCheck() }

    // [JVM] begin { .. } end
    fun <R> CommandBuffer.record(beginInfo: CommandBufferBeginInfo, block: (CommandBuffer) -> R): R {
        begin(beginInfo)
        return block(this).also { end() }
    }

    // --- [ vkCmdSetViewport ] ---

    infix fun CommandBuffer.setViewport(viewport: Viewport) =
            vkStack { callPPV(adr, 0, 1, viewport write vkStack, capabilities.vkCmdSetViewport) }

    fun CommandBuffer.setViewport(firstViewport: Int, viewports: Array<Viewport>) =
            vkStack { callPPV(adr, firstViewport, viewports.size, viewports write vkStack, capabilities.vkCmdSetViewport) }

    // --- [ vkCmdSetScissor ] ---

    fun CommandBuffer.setScissor(firstScissor: Int, scissors: Array<Rect2D>) =
            vkStack { callPPV(adr, firstScissor, scissors.size, scissors write vkStack, capabilities.vkCmdSetScissor) }

    infix fun CommandBuffer.setScissor(scissor: Rect2D) =
            vkStack { callPPV(adr, 0, 1, scissor write vkStack, capabilities.vkCmdSetScissor) }

    // --- [ vkCmdSetBlendConstants ] ---
    infix fun CommandBuffer.setBlendConstants(blendConstants: Vec4) =
            vkStack { callPPV(adr, blendConstants.toAdr(vkStack).adr, capabilities.vkCmdSetBlendConstants) }

    // --- [ vkCmdBindDescriptorSets ] ---

    fun CommandBuffer.bindDescriptorSets(pipelineBindPoint: VkPipelineBindPoint, layout: VkPipelineLayout, firstSet: Int, descriptorSets: VkDescriptorSet_Array, dynamicOffsets: IntArray) =
            vkStack { callPJPPV(adr, pipelineBindPoint.i, layout.L, firstSet, descriptorSets.size, descriptorSets write vkStack, dynamicOffsets.size, vkStack.Adr(dynamicOffsets).adr, capabilities.vkCmdBindDescriptorSets) }

    fun CommandBuffer.bindDescriptorSets(pipelineBindPoint: VkPipelineBindPoint, layout: VkPipelineLayout, firstSet: Int, descriptorSet: VkDescriptorSet, dynamicOffset: Int) =
            vkStack { callPJPPV(adr, pipelineBindPoint.i, layout.L, firstSet, 1, vkStack.longAdrOf(descriptorSet.L), 1, vkStack.intAdrOf(dynamicOffset), capabilities.vkCmdBindDescriptorSets) }

    // --- [ vkCmdBindVertexBuffers ] ---

    fun CommandBuffer.bindVertexBuffers(firstBinding: Int, bindingCount: Int, buffers: VkBuffer_Array, offsets: VkDeviceSize_Array) =
            vkStack { callPPPV(adr, firstBinding, bindingCount, buffers write vkStack, offsets write vkStack, capabilities.vkCmdBindVertexBuffers) }

    fun CommandBuffer.bindVertexBuffers(firstBinding: Int, bindingCount: Int, buffer: VkBuffer, offset: VkDeviceSize) =
            vkStack { callPPPV(adr, firstBinding, bindingCount, vkStack.longAdrOf(buffer.L), vkStack.longAdrOf(offset.L), capabilities.vkCmdBindVertexBuffers) }

    // firstBinding and bindCount defaulted to 0 and 1
    fun CommandBuffer.bindVertexBuffers(buffer: VkBuffer, offset: VkDeviceSize = VkDeviceSize.NULL) =
            vkStack { callPPPV(adr, 0, 1, vkStack.longAdrOf(buffer.L), vkStack.longAdrOf(offset.L), capabilities.vkCmdBindVertexBuffers) }

    // bindCount extrapolated from buffers
    fun CommandBuffer.bindVertexBuffers(firstBinding: Int, buffers: VkBuffer_Array, offsets: VkDeviceSize_Array) =
            vkStack { callPPPV(adr, firstBinding, buffers.size, buffers write vkStack, offsets write vkStack, capabilities.vkCmdBindVertexBuffers) }

    // --- [ vkCmdCopyBuffer ] ---

    fun CommandBuffer.copyBuffer(srcBuffer: VkBuffer, dstBuffer: VkBuffer, regions: Array<BufferCopy>) =
            vkStack { callPJJPV(adr, srcBuffer.L, dstBuffer.L, regions.size, regions write vkStack, capabilities.vkCmdCopyBuffer) }

    fun CommandBuffer.copyBuffer(srcBuffer: VkBuffer, dstBuffer: VkBuffer, region: BufferCopy) =
            vkStack { callPJJPV(adr, srcBuffer.L, dstBuffer.L, 1, region write vkStack, capabilities.vkCmdCopyBuffer) }

    // --- [ vkCmdCopyImage ] ---

    fun CommandBuffer.copyImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, regions: Array<ImageCopy>) =
            vkStack { callPJJPV(adr, srcImage.L, srcImageLayout.i, dstImage.L, dstImageLayout.i, regions.size, regions write vkStack, capabilities.vkCmdCopyImage) }

    fun CommandBuffer.copyImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, region: ImageCopy) =
            vkStack { callPJJPV(adr, srcImage.L, srcImageLayout.i, dstImage.L, dstImageLayout.i, 1, region write vkStack, capabilities.vkCmdCopyImage) }

    // --- [ vkCmdBlitImage ] ---

    fun CommandBuffer.blitImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, regions: Array<ImageBlit>, filter: VkFilter) =
            vkStack { callPJJPV(adr, srcImage.L, srcImageLayout.i, dstImage.L, dstImageLayout.i, regions.size, regions write vkStack, filter.i, capabilities.vkCmdBlitImage) }

    fun CommandBuffer.blitImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, region: ImageBlit, filter: VkFilter) =
            vkStack { callPJJPV(adr, srcImage.L, srcImageLayout.i, dstImage.L, dstImageLayout.i, 1, region write vkStack, filter.i, capabilities.vkCmdBlitImage) }

    // --- [ vkCmdCopyBufferToImage ] ---

    fun CommandBuffer.copyBufferToImage(srcBuffer: VkBuffer, dstImage: VkImage, dstImageLayout: VkImageLayout, regions: Array<BufferImageCopy>) =
            vkStack { callPJJPV(adr, srcBuffer.L, dstImage.L, dstImageLayout.i, regions.size, regions write vkStack, capabilities.vkCmdCopyBufferToImage) }

    fun CommandBuffer.copyBufferToImage(srcBuffer: VkBuffer, dstImage: VkImage, dstImageLayout: VkImageLayout, region: BufferImageCopy) =
            vkStack { callPJJPV(adr, srcBuffer.L, dstImage.L, dstImageLayout.i, 1, region write vkStack, capabilities.vkCmdCopyBufferToImage) }

    // --- [ vkCmdCopyImageToBuffer ] ---

    fun CommandBuffer.copyImageToBuffer(srcImage: VkImage, srcImageLayout: VkImageLayout, dstBuffer: VkBuffer, regions: Array<BufferImageCopy>) =
            vkStack { callPJJPV(adr, srcImage.L, srcImageLayout.i, dstBuffer.L, regions.size, regions write vkStack, capabilities.vkCmdCopyImageToBuffer) }

    fun CommandBuffer.copyImageToBuffer(srcImage: VkImage, srcImageLayout: VkImageLayout, dstBuffer: VkBuffer, region: BufferImageCopy) =
            vkStack { callPJJPV(adr, srcImage.L, srcImageLayout.i, dstBuffer.L, 1, region write vkStack, capabilities.vkCmdCopyImageToBuffer) }

    // --- [ vkCmdClearColorImage ] ---

    fun CommandBuffer.clearColorImage(image: VkImage, imageLayout: VkImageLayout, color: ClearColorValue, ranges: Array<ImageSubresourceRange>) =
            vkStack { callPJPPV(adr, image.L, imageLayout.i, color write vkStack, ranges.size, ranges write vkStack, capabilities.vkCmdClearColorImage) }

    fun CommandBuffer.clearColorImage(image: VkImage, imageLayout: VkImageLayout, color: ClearColorValue, range: ImageSubresourceRange) =
            vkStack { callPJPPV(adr, image.L, imageLayout.i, color write vkStack, 1, range write vkStack, capabilities.vkCmdClearColorImage) }

    // --- [ vkCmdClearDepthStencilImage ] ---

    fun CommandBuffer.clearDepthStencilImage(image: VkImage, imageLayout: VkImageLayout, depthStencil: ClearDepthStencilValue, ranges: Array<ImageSubresourceRange>) =
            vkStack { callPJPPV(adr, image.L, imageLayout.i, depthStencil write vkStack, ranges.size, ranges write vkStack, capabilities.vkCmdClearDepthStencilImage) }

    fun CommandBuffer.clearDepthStencilImage(image: VkImage, imageLayout: VkImageLayout, depthStencil: ClearDepthStencilValue, range: ImageSubresourceRange) =
            vkStack { callPJPPV(adr, image.L, imageLayout.i, depthStencil write vkStack, 1, range write vkStack, capabilities.vkCmdClearDepthStencilImage) }

    // --- [ vkCmdClearAttachments ] ---

    fun CommandBuffer.clearAttachments(attachments: Array<ClearAttachment>, rects: Array<ClearRect>) =
            vkStack { callPPPV(adr, attachments.size, attachments write vkStack, rects.size, rects write vkStack, capabilities.vkCmdClearAttachments) }

    fun CommandBuffer.clearAttachments(attachment: ClearAttachment, rect: ClearRect) =
            vkStack { callPPPV(adr, 1, attachment write vkStack, 1, rect write vkStack, capabilities.vkCmdClearAttachments) }

    // --- [ vkCmdResolveImage ] ---

    fun CommandBuffer.resolveImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, regions: Array<ImageResolve>) =
            vkStack { callPJJPV(adr, srcImage.L, srcImageLayout.i, dstImage.L, dstImageLayout.i, regions.size, regions write vkStack, capabilities.vkCmdResolveImage) }

    fun CommandBuffer.resolveImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, region: ImageResolve) =
            vkStack { callPJJPV(adr, srcImage.L, srcImageLayout.i, dstImage.L, dstImageLayout.i, 1, region write vkStack, capabilities.vkCmdResolveImage) }

    // --- [ vkCmdWaitEvents ] ---

    fun CommandBuffer.waitEvents(events: VkEvent_Array, srcStageMask: VkPipelineStageFlags, dstStageMask: VkPipelineStageFlags,
                                 memoryBarriers: Array<MemoryBarrier>, bufferMemoryBarriers: Array<BufferMemoryBarrier>,
                                 imageMemoryBarriers: Array<ImageMemoryBarrier>) =
            vkStack { callPPPPPV(adr, events.size, events write vkStack, srcStageMask, dstStageMask, memoryBarriers.size, memoryBarriers write vkStack, bufferMemoryBarriers.size, bufferMemoryBarriers write vkStack, imageMemoryBarriers.size, imageMemoryBarriers write vkStack, capabilities.vkCmdWaitEvents) }

    // --- [ vkCmdPipelineBarrier ] ---

    fun CommandBuffer.pipelineBarrier(srcStageMask: VkPipelineStageFlags, dstStageMask: VkPipelineStageFlags, dependencyFlags: VkDependencyFlags,
                                      memoryBarriers: Array<MemoryBarrier>? = null, bufferMemoryBarriers: Array<BufferMemoryBarrier>? = null,
                                      imageMemoryBarriers: Array<ImageMemoryBarrier>? = null) =
            vkStack {
                callPPPPV(adr, srcStageMask, dstStageMask, dependencyFlags, memoryBarriers?.size
                        ?: 0, memoryBarriers?.write(vkStack) ?: NULL, bufferMemoryBarriers?.size
                        ?: 0, bufferMemoryBarriers?.write(vkStack) ?: NULL, imageMemoryBarriers?.size
                        ?: 0, imageMemoryBarriers?.write(vkStack) ?: NULL, capabilities.vkCmdPipelineBarrier)
            }

    fun CommandBuffer.pipelineBarrier(srcStageMask: VkPipelineStageFlags, dstStageMask: VkPipelineStageFlags, dependencyFlags: VkDependencyFlags,
                                      memoryBarrier: MemoryBarrier? = null, bufferMemoryBarrier: BufferMemoryBarrier? = null, imageMemoryBarrier: ImageMemoryBarrier? = null) =
            vkStack {
                callPPPPV(adr, srcStageMask, dstStageMask, dependencyFlags, (memoryBarrier != null).i, memoryBarrier?.write(vkStack)
                        ?: NULL,
                        (bufferMemoryBarrier != null).i, bufferMemoryBarrier?.write(vkStack)
                        ?: NULL, (imageMemoryBarrier != null).i, imageMemoryBarrier?.write(vkStack)
                        ?: NULL, capabilities.vkCmdPipelineBarrier)
            }

    // --- [ vkCmdBeginRenderPass ] ---
    fun CommandBuffer.beginRenderPass(renderPassBegin: RenderPassBeginInfo, contents: VkSubpassContents = VkSubpassContents.INLINE) =
            vkStack { callPPV(adr, renderPassBegin write vkStack, contents.i, capabilities.vkCmdBeginRenderPass) }

    // [JVM]
    fun <R> CommandBuffer.renderPass(renderPassBegin: RenderPassBeginInfo, contents: VkSubpassContents = VkSubpassContents.INLINE, block: () -> R): R =
            vkStack { beginRenderPass(renderPassBegin, contents); block().also { endRenderPass() } }

    // --- [ vkCmdExecuteCommands ] ---

    infix fun CommandBuffer.executeCommands(commandBuffers: Array<CommandBuffer>) =
            vkStack { callPPV(adr, commandBuffers.size, commandBuffers write vkStack, capabilities.vkCmdExecuteCommands) }

    infix fun CommandBuffer.executeCommands(commandBuffer: CommandBuffer) =
            vkStack.pointerAdr(commandBuffer) { callPPV(adr, 1, it, capabilities.vkCmdExecuteCommands) }
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

// --- [ vkEnumerateInstanceExtensionProperties ] ---
fun vk.enumerateInstanceExtensionProperties(layerName: String? = null): Array<ExtensionProperties> =
        VkStack { it.run { vk.enumerateInstanceExtensionProperties(layerName) } }

// --- [ vkEnumerateDeviceExtensionProperties ] ---
fun PhysicalDevice.enumerateDeviceExtensionProperties(layerName: String? = null): Array<ExtensionProperties> =
        VkStack { it.run { enumerateDeviceExtensionProperties(layerName) } }

// --- [ vkEnumerateInstanceLayerProperties ] ---
fun vk.enumerateInstanceLayerProperties(): Array<LayerProperties> =
        VkStack { it.run { vk.enumerateInstanceLayerProperties() } }

// --- [ vkEnumerateDeviceLayerProperties ] ---
fun PhysicalDevice.enumerateDeviceLayerProperties(): Array<LayerProperties> =
        VkStack { it.run { enumerateDeviceLayerProperties() } }

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

fun Device.updateDescriptorSets(descriptorWrites: Array<WriteDescriptorSet>, descriptorCopies: Array<CopyDescriptorSet>) =
        VkStack { it.run { updateDescriptorSets(descriptorWrites, descriptorCopies) } }

fun Device.updateDescriptorSets(descriptorWrite: WriteDescriptorSet, descriptorCopy: CopyDescriptorSet) =
        VkStack { it.run { updateDescriptorSets(descriptorWrite, descriptorCopy) } }

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