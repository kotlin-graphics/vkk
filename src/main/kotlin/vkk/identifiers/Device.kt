package identifiers

import glm_.L
import glm_.i
import kool.*
import org.lwjgl.system.APIUtil.apiLog
import org.lwjgl.system.Checks
import org.lwjgl.system.FunctionProvider
import org.lwjgl.system.JNI.*
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.vulkan.*
import vkk.*
import vkk._10.structs.*
import vkk._11.structs.*
import vkk.entities.*

/** Wraps a Vulkan device dispatchable handle. */
class Device(
        handle: Ptr,
        val physicalDevice: PhysicalDevice, ci: DeviceCreateInfo, apiVersion: Int = 0
) : DispatchableHandleDevice(handle, getDeviceCapabilities(handle, physicalDevice, ci, apiVersion)) {

    // ---------------------------------------------- VK10 -------------------------------------------------------------

    // --- [ vkAcquireNextImageKHR ] ---
    fun acquireNextImageKHR(swapchain: VkSwapchainKHR, timeout: Long = -1L, semaphore: VkSemaphore, fence: VkFence = VkFence(NULL)): Int =
            stak {
                val p = it.nmalloc(Int.BYTES, Int.SIZE_BYTES)
                VK_CHECK_RESULT(
                        callPJJJJPI(adr, swapchain.L, timeout, semaphore.L, fence.L, p, capabilities.vkAcquireNextImageKHR)
                )
                memGetInt(p)
            }

    // --- [ vkAllocateCommandBuffers ] ---
    inline fun nAllocateCommandBuffers(pAllocateInfo: Ptr, pCommandBuffers: Ptr): VkResult =
            VkResult(callPPPI(adr, pAllocateInfo, pCommandBuffers, capabilities.vkAllocateCommandBuffers))

    infix fun allocateCommandBuffer(allocateInfo: CommandBufferAllocateInfo): CommandBuffer = stak { s ->
        CommandBuffer(s.pointerAdr { nAllocateCommandBuffers(allocateInfo write s, it).check() }, this)
    }

    infix fun allocateCommandBuffers(allocateInfo: CommandBufferAllocateInfo): Array<CommandBuffer> = stak { s ->
        val pCommandBuffers = s.mPointer(allocateInfo.commandBufferCount)
        nAllocateCommandBuffers(allocateInfo write s, pCommandBuffers.adr)
        Array(allocateInfo.commandBufferCount) {
            CommandBuffer(memGetAddress(pCommandBuffers[it]), this)
        }
    }

    // --- [ vkAllocateDescriptorSets ] ---
    inline fun nAllocateDescriptorSets(pAllocateInfo: Ptr, pDescriptorSets: Ptr): VkResult =
            VkResult(callPPPI(adr, pAllocateInfo, pDescriptorSets, capabilities.vkAllocateDescriptorSets)).apply { check() }

    infix fun allocateDescriptorSets(allocateInfo: DescriptorSetAllocateInfo): VkDescriptorSet_Array = stak { s ->
        val descriptors = s.mLong(allocateInfo.setLayouts.size)
        nAllocateDescriptorSets(allocateInfo write s, descriptors.adr).apply { check() }
        VkDescriptorSet_Array(allocateInfo.setLayouts.size) { VkDescriptorSet(descriptors[it]) }
    }

    infix fun allocateDescriptorSet(allocateInfo: DescriptorSetAllocateInfo): VkDescriptorSet = stak { s ->
        VkDescriptorSet(s.longAdr {
            nAllocateDescriptorSets(allocateInfo write s, it).apply { check() }
        })
    }

    // --- [ vkAllocateMemory ] ---
    infix fun allocateMemory(allocateInfo: MemoryAllocateInfo): VkDeviceMemory = stak { s ->
        VkDeviceMemory(s.longAdr {
            callPPPPI(adr, allocateInfo write s, NULL, it, capabilities.vkAllocateMemory)
        })
    }

    // --- [ vkBindBufferMemory ] ---
    fun bindBufferMemory(buffer: VkBuffer, memory: VkDeviceMemory, memoryOffset: VkDeviceSize = VkDeviceSize(0)): VkResult =
            VkResult(callPJJJI(adr, buffer.L, memory.L, memoryOffset.L, capabilities.vkBindBufferMemory)).apply { check() }

    // --- [ vkBindImageMemory ] ---
    fun bindImageMemory(image: VkImage, memory: VkDeviceMemory, memoryOffset: VkDeviceSize): VkResult =
            VkResult(callPJJJI(adr, image.L, memory.L, memoryOffset.L, capabilities.vkBindImageMemory))

    // --- [ vkCreateBuffer ] ---
    infix fun createBuffer(createInfo: BufferCreateInfo): VkBuffer = stak { s ->
        VkBuffer(s.longAdr { callPPPPI(adr, createInfo write s, NULL, it, capabilities.vkCreateBuffer) })
    }

    // --- [ vkCreateBufferView ] ---
    infix fun createBufferView(createInfo: BufferViewCreateInfo): VkBufferView = stak { s ->
        VkBufferView(s.longAdr { callPPPPI(adr, createInfo write s, NULL, it, capabilities.vkCreateBufferView) })
    }

    // --- [ vkCreateCommandPool ] ---
    infix fun createCommandPool(createInfo: CommandPoolCreateInfo): VkCommandPool = stak { s ->
        VkCommandPool(s.longAdr { callPPPPI(adr, createInfo write s, NULL, it, capabilities.vkCreateCommandPool) })
    }

    // --- [ vkCreateComputePipelines ] ---
    inline fun nCreateComputePipelines(pipelineCache: VkPipelineCache, createInfoCount: Int, pCreateInfos: Ptr, pPipelines: Ptr): VkResult =
            VkResult(callPJPPPI(adr, pipelineCache.L, createInfoCount, pCreateInfos, NULL, pPipelines, capabilities.vkCreateComputePipelines))

    infix fun createComputePipelines(createInfos: Array<ComputePipelineCreateInfo>): VkPipeline_Array =
            createComputePipelines(VkPipelineCache.NULL, createInfos)

    fun createComputePipelines(pipelineCache: VkPipelineCache, createInfos: Array<ComputePipelineCreateInfo>): VkPipeline_Array = stak { s ->
        val pipelines = s.mLong(createInfos.size)
        nCreateComputePipelines(pipelineCache, createInfos.size, createInfos write s, pipelines.adr).check()
        VkPipeline_Array(createInfos.size) { VkPipeline(pipelines[it]) }
    }

    infix fun createComputePipelines(createInfo: ComputePipelineCreateInfo): VkPipeline =
            createComputePipelines(VkPipelineCache.NULL, createInfo)

    fun createComputePipelines(pipelineCache: VkPipelineCache, createInfo: ComputePipelineCreateInfo): VkPipeline = stak { s ->
        VkPipeline(s.longAdr { nCreateComputePipelines(pipelineCache, 1, createInfo write s, it).check() })
    }

    // --- [ vkCreateDescriptorPool ] ---
    infix fun createDescriptorPool(createInfo: DescriptorPoolCreateInfo): VkDescriptorPool = stak { s ->
        VkDescriptorPool(s.longAdr { callPPPPI(adr, createInfo write s, NULL, it, capabilities.vkCreateDescriptorPool) })
    }

    // --- [ vkCreateDescriptorSetLayout ] ---
    infix fun createDescriptorSetLayout(createInfo: DescriptorSetLayoutCreateInfo): VkDescriptorSetLayout = stak { s ->
        VkDescriptorSetLayout(s.longAdr { callPPPPI(adr, createInfo write s, NULL, it, capabilities.vkCreateDescriptorSetLayout) })
    }

    // --- [ vkCreateEvent ] ---
    fun createEvent(createInfo: EventCreateInfo): VkEvent = stak { s ->
        VkEvent(s.longAdr { callPPPPI(adr, createInfo write s, NULL, it, capabilities.vkCreateEvent) })
    }

    // --- [ vkCreateFence ] ---
    infix fun createFence(createInfo: FenceCreateInfo): VkFence = stak { s ->
        VkFence(s.longAdr { callPPPPI(adr, createInfo write s, NULL, it, capabilities.vkCreateFence) })
    }

    // --- [ vkCreateFramebuffer ] ---
    inline fun nCreateFramebuffer(createInfo: Ptr, framebuffer: Ptr): VkResult =
            VkResult(callPPPPI(adr, createInfo, NULL, framebuffer, capabilities.vkCreateFramebuffer))

    infix fun createFramebuffer(createInfo: FramebufferCreateInfo): VkFramebuffer = stak { s ->
        VkFramebuffer(s.longAdr { nCreateFramebuffer(createInfo write s, it).check() })
    }

    // JVM
    fun createFramebufferArray(createInfo: FramebufferCreateInfo, imageViews: VkImageView_Array): VkFramebuffer_Array = stak { s ->
        val pCreateInfo = createInfo write s
        VkFramebufferCreateInfo.nattachmentCount(pCreateInfo, 1)
        val pAttachment = s.mLong()
        memPutAddress(pCreateInfo + VkFramebufferCreateInfo.PATTACHMENTS, pAttachment.adr)
        val pFramebuffer = s.mLong()
        VkFramebuffer_Array(imageViews.size) { i ->
            pAttachment[0] = imageViews[i].L
            nCreateFramebuffer(pCreateInfo, pFramebuffer.adr).check()
            VkFramebuffer(pFramebuffer[0])
        }
    }

    // --- [ vkCreateGraphicsPipelines ] ---
    inline fun nCreateGraphicsPipelines(pipelineCache: VkPipelineCache, createInfoCount: Int, pCreateInfos: Ptr, pPipelines: Ptr): VkResult =
            VkResult(callPJPPPI(adr, pipelineCache.L, createInfoCount, pCreateInfos, NULL, pPipelines, capabilities.vkCreateGraphicsPipelines))

    infix fun createGraphicsPipeline(createInfos: Array<GraphicsPipelineCreateInfo>): VkPipeline_Array =
            createGraphicsPipeline(VkPipelineCache.NULL, createInfos)

    fun createGraphicsPipeline(pipelineCache: VkPipelineCache, createInfos: Array<GraphicsPipelineCreateInfo>): VkPipeline_Array = stak { s ->
        val pipelines = s.mLong(createInfos.size)
        nCreateGraphicsPipelines(pipelineCache, 1, createInfos write s, pipelines.adr).check()
        VkPipeline_Array(createInfos.size) { VkPipeline(pipelines[it]) }
    }

    infix fun createGraphicsPipeline(createInfo: GraphicsPipelineCreateInfo): VkPipeline =
            createGraphicsPipeline(VkPipelineCache.NULL, createInfo)

    fun createGraphicsPipeline(pipelineCache: VkPipelineCache, createInfo: GraphicsPipelineCreateInfo): VkPipeline = stak { s ->
        VkPipeline(s.longAdr { nCreateGraphicsPipelines(pipelineCache, 1, createInfo write s, it).check() })
    }

    // --- [ vkCreateImage ] ---
    infix fun createImage(createInfo: ImageCreateInfo): VkImage = stak { s ->
        VkImage(s.longAdr { callPPPPI(adr, createInfo write s, NULL, it, capabilities.vkCreateImage) })
    }

    // --- [ vkCreateImageView ] ---
    inline fun nCreateImageView(createInfo: Ptr, imageView: Ptr): VkResult =
            VkResult(callPPPPI(adr, createInfo, NULL, imageView, capabilities.vkCreateImageView))

    infix fun createImageView(createInfo: ImageViewCreateInfo): VkImageView = stak { s ->
        VkImageView(s.longAdr { nCreateImageView(createInfo write s, it).check() })
    }

    // JVM
    fun createImageViewArray(createInfo: ImageViewCreateInfo, images: VkImage_Array): VkImageView_Array = stak { s ->
        val pCreateInfo = createInfo write s
        val pImageView = s.mLong()
        VkImageView_Array(images.size) { i ->
            VkImageViewCreateInfo.nimage(pCreateInfo, images[i].L)
            nCreateImageView(pCreateInfo, pImageView.adr)
            VkImageView(pImageView[0])
        }
    }

    // --- [ vkCreatePipelineCache ] ---
    fun createPipelineCache(createInfo: PipelineCacheCreateInfo): VkPipelineCache = stak { s ->
        VkPipelineCache(s.longAdr { callPPPPI(adr, createInfo write s, NULL, it, capabilities.vkCreatePipelineCache) })
    }

    // --- [ vkCreatePipelineLayout ] ---
    infix fun createPipelineLayout(createInfo: PipelineLayoutCreateInfo): VkPipelineLayout = stak { s ->
        VkPipelineLayout(s.longAdr { callPPPPI(adr, createInfo write s, NULL, it, capabilities.vkCreatePipelineLayout) })
    }

    // --- [ vkCreateQueryPool ] ---
    fun createQueryPool(createInfo: QueryPoolCreateInfo): VkQueryPool = stak { s ->
        VkQueryPool(s.longAdr { callPPPPI(adr, createInfo write s, NULL, it, capabilities.vkCreateQueryPool) })
    }

    // --- [ vkCreateRenderPass ] ---
    infix fun createRenderPass(createInfo: RenderPassCreateInfo): VkRenderPass = stak { s ->
        VkRenderPass(s.longAdr { callPPPPI(adr, createInfo write s, NULL, it, capabilities.vkCreateRenderPass) })
    }

    // --- [ vkCreateSampler ] ---
    infix fun createSampler(createInfo: SamplerCreateInfo): VkSampler = stak { s ->
        VkSampler(s.longAdr { callPPPPI(adr, createInfo write s, NULL, it, capabilities.vkCreateSampler) })
    }

    // --- [ vkCreateSemaphore ] ---
    fun createSemaphore(createInfo: SemaphoreCreateInfo = SemaphoreCreateInfo()): VkSemaphore = stak { s ->
        VkSemaphore(s.longAdr { callPPPPI(adr, createInfo write s, NULL, it, capabilities.vkCreateSemaphore) })
    }

    // --- [ vkCreateShaderModule ] ---

    infix fun createShaderModule(createInfo: ShaderModuleCreateInfo): VkShaderModule = stak { s ->
        VkShaderModule(s.longAdr { callPPPPI(adr, createInfo write s, NULL, it, capabilities.vkCreateShaderModule) })
    }

    // --- [ vkCreateSwapchainKHR ] ---
    infix fun createSwapchainKHR(createInfo: SwapchainCreateInfoKHR): VkSwapchainKHR = stak { s ->
        VkSwapchainKHR(s.longAdr {
            VK_CHECK_RESULT(callPPPPI(adr, createInfo write s, NULL, it, capabilities.vkCreateSwapchainKHR))
        })
    }

    // --- [ vkDestroyBuffer ] ---
    infix fun destroy(buffer: VkBuffer) =
            callPJPV(adr, buffer.L, NULL, capabilities.vkDestroyBuffer)

    // --- [ vkDestroyBufferView ] ---
    infix fun destroyBufferView(bufferView: VkBufferView) =
            callPJPV(adr, bufferView.L, NULL, capabilities.vkDestroyBufferView)

    // --- [ vkDestroyCommandPool ] ---
    infix fun destroy(commandPool: VkCommandPool) =
            callPJPV(adr, commandPool.L, NULL, capabilities.vkDestroyCommandPool)

    // --- [ vkDestroyDescriptorPool ] ---
    infix fun destroy(descriptorPool: VkDescriptorPool) =
            callPJPV(adr, descriptorPool.L, NULL, capabilities.vkDestroyDescriptorPool)

    // --- [ vkDestroyDescriptorSetLayout ] ---
    infix fun destroyDescriptorSetLayout(descriptorSetLayout: VkDescriptorSetLayout) =
            callPJPV(adr, descriptorSetLayout.L, NULL, capabilities.vkDestroyDescriptorSetLayout)

    // --- [ vkDestroyDevice ] ---
    fun destroy() =
            callPPV(adr, NULL, capabilities.vkDestroyDevice)

    // --- [ vkDestroyEvent ] ---
    infix fun destroy(event: VkEvent) =
            callPJPV(adr, event.L, NULL, capabilities.vkDestroyEvent)

    // --- [ vkDestroyFence ] ---
    infix fun destroy(fence: VkFence) =
            callPJPV(adr, fence.L, NULL, capabilities.vkDestroyFence)

    // --- [ vkDestroyFramebuffer ] ---
    infix fun destroy(framebuffer: VkFramebuffer) =
            callPJPV(adr, framebuffer.L, NULL, capabilities.vkDestroyFramebuffer)

    // --- [ vkDestroyImage ] ---
    infix fun destroy(image: VkImage) =
            callPJPV(adr, image.L, NULL, capabilities.vkDestroyImage)

    // --- [ vkDestroyImageView ] ---
    infix fun destroyImageView(imageView: VkImageView) =
            callPJPV(adr, imageView.L, NULL, capabilities.vkDestroyImageView)

    // --- [ vkDestroyPipelineCache ] ---
    infix fun destroy(pipelineCache: VkPipelineCache) =
            callPJPV(adr, pipelineCache.L, NULL, capabilities.vkDestroyPipelineCache)

    // --- [ vkDestroyPipelineLayout ] ---
    infix fun destroy(pipelineLayout: VkPipelineLayout) =
            callPJPV(adr, pipelineLayout.L, NULL, capabilities.vkDestroyPipelineLayout)

    // --- [ vkDestroyQueryPool ] ---
    infix fun destroy(queryPool: VkQueryPool) =
            callPJPV(adr, queryPool.L, NULL, capabilities.vkDestroyQueryPool)

    // --- [ vkDestroyRenderPass ] ---
    infix fun destroy(renderPass: VkRenderPass) =
            callPJPV(adr, renderPass.L, NULL, capabilities.vkDestroyRenderPass)

    // --- [ vkDestroySampler ] ---
    infix fun destroy(sampler: VkSampler) =
            callPJPV(adr, sampler.L, NULL, capabilities.vkDestroySampler)

    // --- [ vkDestroySemaphore ] ---
    infix fun destroy(semaphore: VkSemaphore) =
            callPJPV(adr, semaphore.L, NULL, capabilities.vkDestroySemaphore)

    // --- [ vkDestroyShaderModule ] ---
    infix fun destroy(shaderModule: VkShaderModule) =
            callPJPV(adr, shaderModule.L, NULL, capabilities.vkDestroyShaderModule)

    // --- [ vkDestroySwapchainKHR ] ---
    infix fun destroy(swapchain: VkSwapchainKHR) =
            callPJPV(adr, swapchain.L, NULL, capabilities.vkDestroySwapchainKHR)

    // --- [ vkDeviceWaitIdle ] ---
    fun waitIdle(): VkResult =
            VkResult(callPI(adr, capabilities.vkDeviceWaitIdle))

    // --- [ vkFlushMappedMemoryRanges ] ---
    infix fun flushMappedMemoryRanges(memoryRanges: Array<MappedMemoryRange>): VkResult = stak { s ->
        VkResult(callPPI(adr, memoryRanges.size, memoryRanges write s, capabilities.vkFlushMappedMemoryRanges))
    }

    // --- [ vkFreeCommandBuffers ] ---
    inline fun nFreeCommandBuffers(commandPool: VkCommandPool, commandBufferCount: Int, pCommandBuffers: Ptr) =
            callPJPV(adr, commandPool.L, commandBufferCount, pCommandBuffers, capabilities.vkFreeCommandBuffers)

    fun freeCommandBuffers(commandPool: VkCommandPool, commandBufferCount: Int, pCommandBuffers: Ptr) =
            callPJPV(adr, commandPool.L, commandBufferCount, pCommandBuffers, capabilities.vkFreeCommandBuffers)

    // --- [ vkFreeMemory ] ---
    fun freeMemory(memory: VkDeviceMemory) =
            callPJPV(adr, memory.L, NULL, capabilities.vkFreeMemory)

    // --- [ vkGetBufferMemoryRequirements ] ---
    infix fun getBufferMemoryRequirements(buffer: VkBuffer): MemoryRequirements =
            MemoryRequirements.read { callPJPV(adr, buffer.L, it, capabilities.vkGetBufferMemoryRequirements) }

    // --- [ vkGetDeviceQueue ] ---
    fun getQueue(queueFamilyIndex: Int, queueIndex: Int = 0): Queue =
            Queue(stak.pointerAdr { callPPV(adr, queueFamilyIndex, queueIndex, it, capabilities.vkGetDeviceQueue) }, this)

    // --- [ vkGetEventStatus ] ---
    fun getEventStatus(event: VkEvent): VkResult =
            VkResult(callPJI(adr, event.L, capabilities.vkGetEventStatus))

    // --- [ vkGetFenceStatus ] ---
    fun getFenceStatus(fence: VkFence): VkResult =
            VkResult(callPJI(adr, fence.L, capabilities.vkGetFenceStatus))

    // --- [ vkGetRenderAreaGranularity ] ---
    infix fun getRenderAreaGranularity(renderPass: VkRenderPass): Extent2D =
            Extent2D.read { callPJPV(adr, renderPass.L, it, capabilities.vkGetRenderAreaGranularity) }

    // --- [ vkFreeDescriptorSets ] ---
    fun nFreeDescriptorSets(descriptorPool: VkDescriptorPool, descriptorSetCount: Int, pDescriptorSets: Ptr): VkResult =
            VkResult(callPJPI(adr, descriptorPool.L, descriptorSetCount, pDescriptorSets, capabilities.vkFreeDescriptorSets))

    fun freeDescriptorSets(descriptorPool: VkDescriptorPool, descriptorSets: VkDescriptorSet_Array): VkResult = stak { s ->
        nFreeDescriptorSets(descriptorPool, descriptorSets.size, descriptorSets write s).apply { check() }
    }

    fun freeDescriptorSet(descriptorPool: VkDescriptorPool, descriptorSet: VkDescriptorSet): VkResult = stak { s ->
        nFreeDescriptorSets(descriptorPool, 1, s.longAdr(descriptorSet.L)).apply { check() }
    }

    // --- [ vkGetImageMemoryRequirements ] ---
    infix fun getImageMemoryRequirements(image: VkImage): MemoryRequirements =
            MemoryRequirements.read { callPJPV(adr, image.L, it, capabilities.vkGetImageMemoryRequirements) }

    // --- [ vkGetImageSparseMemoryRequirements ] ---
    inline fun nGetImageSparseMemoryRequirements(image: VkImage, pSparseMemoryRequirementCount: IntPtr, pSparseMemoryRequirements: Ptr = NULL) =
            callPJPPV(adr, image.L, pSparseMemoryRequirementCount.adr, pSparseMemoryRequirements, capabilities.vkGetImageSparseMemoryRequirements)

    infix fun getImageSparseMemoryRequirements(image: VkImage): Array<SparseImageMemoryRequirements> = stak { s ->
        val pSparseMemoryRequirementCount = s.mInt()
        nGetImageSparseMemoryRequirements(image, pSparseMemoryRequirementCount)
        val sparseMemoryRequirementCount = pSparseMemoryRequirementCount[0]
        val sparseMemoryRequirements = s.ncalloc(VkSparseImageMemoryRequirements.ALIGNOF, sparseMemoryRequirementCount, VkSparseImageMemoryRequirements.SIZEOF)
        nGetImageSparseMemoryRequirements(image, pSparseMemoryRequirementCount, sparseMemoryRequirements)
        Array(sparseMemoryRequirementCount) {
            SparseImageMemoryRequirements(BytePtr(sparseMemoryRequirements + it * VkSparseImageMemoryRequirements.SIZEOF))
        }
    }

    // --- [ vkGetImageSubresourceLayout ] ---
    fun getImageSubresourceLayout(image: VkImage, subresource: ImageSubresource): SubresourceLayout = stak { s ->
        SubresourceLayout.read(s) {
            callPJPPV(adr, image.L, subresource write s, it, capabilities.vkGetImageSubresourceLayout)
        }
    }

    // --- [ vkGetPipelineCacheData ] ---
    inline fun nGetPipelineCacheData(pipelineCache: VkPipelineCache, pDataSize: IntPtr, pData: Ptr = NULL): VkResult =
            VkResult(callPJPPI(adr, pipelineCache.L, pDataSize.adr, pData, capabilities.vkGetPipelineCacheData))

    infix fun getPipelineCacheData(pipelineCache: VkPipelineCache): ByteArray = stak { s ->
        var data: Ptr = NULL
        val pDataSize = s.mInt()
        var dataSize: Int
        var result: VkResult
        do {
            result = nGetPipelineCacheData(pipelineCache, pDataSize)
            dataSize = pDataSize[0]
            if (result == VkResult.SUCCESS && dataSize != 0) {
                data = s.ncalloc(1, dataSize, 1)
                result = nGetPipelineCacheData(pipelineCache, pDataSize, data)
            }
        } while (result == VkResult.INCOMPLETE)
        return ByteArray(dataSize) { memGetByte(data + it) }
    }

    // --- [ vkGetQueryPoolResults ] ---
    fun getQueryPoolResults(queryPool: VkQueryPool, firstQuery: Int, queryCount: Int, dataSize: Int, pData: Ptr, stride: VkDeviceSize,
                            flags: VkQueryResultFlags): VkResult =
            VkResult(callPJPPJI(adr, queryPool.L, firstQuery, queryCount, dataSize.L, pData, stride.L, flags, capabilities.vkGetQueryPoolResults))

    // --- [ vkGetSwapchainImagesKHR ] ---
    inline fun nGetSwapchainImagesKHR(swapchain: VkSwapchainKHR, pSwapchainImageCount: Ptr, pSwapchainImages: Ptr = NULL): VkResult =
            VkResult(callPJPPI(adr, swapchain.L, pSwapchainImageCount, pSwapchainImages, capabilities.vkGetSwapchainImagesKHR))


    infix fun getSwapchainImagesKHR(swapchain: VkSwapchainKHR): VkImage_Array = stak { s ->
        var pSwapchainImages = LongPtr.NULL
        val pSwapchainImageCount = s.mInt()
        var swapchainImageCount: Int
        var result: VkResult
        do {
            result = nGetSwapchainImagesKHR(swapchain, pSwapchainImageCount.adr)
            swapchainImageCount = pSwapchainImageCount[0]
            if (result == VkResult.SUCCESS && swapchainImageCount != 0) {
                pSwapchainImages = s.mLong(swapchainImageCount)
                result = nGetSwapchainImagesKHR(swapchain, pSwapchainImageCount.adr, pSwapchainImages.adr)
            }
        } while (result == VkResult.INCOMPLETE)
        VkImage_Array(swapchainImageCount) { VkImage(pSwapchainImages[it]) }
    }

    // --- [ vkInvalidateMappedMemoryRanges ] ---
    fun invalidateMappedMemoryRanges(memoryRanges: Array<MappedMemoryRange>): VkResult = stak { s ->
        VkResult(callPPI(adr, memoryRanges.size, memoryRanges write s, capabilities.vkInvalidateMappedMemoryRanges))
    }

    // --- [ vkGetDeviceMemoryCommitment ] ---
    infix fun getMemoryCommitment(memory: VkDeviceMemory): VkDeviceSize = stak { s ->
        VkDeviceSize(s.longAdr { callPJPV(adr, memory.L, it, capabilities.vkGetDeviceMemoryCommitment) })
    }

    // --- [ vkMapMemory ] ---
    fun mapMemory(memory: VkDeviceMemory, offset: VkDeviceSize, size: VkDeviceSize, flags: VkMemoryMapFlags = 0): Ptr =
            stak.pointerAdr { callPJJJPI(adr, memory.L, offset.L, size.L, flags, it, capabilities.vkMapMemory) }

    // --- [ vkMergePipelineCaches ] ---
    fun mergePipelineCaches(dstCache: VkPipelineCache, srcCaches: VkPipelineCache_Array): VkResult = stak { s ->
        VkResult(callPJPI(adr, dstCache.L, srcCaches.size, srcCaches write s, capabilities.vkMergePipelineCaches))
    }

    // --- [ vkResetCommandPool ] ---
    fun resetCommandPool(commandPool: VkCommandPool, flags: VkCommandPoolResetFlags = 0): VkResult =
            VkResult(callPJI(adr, commandPool.L, flags, capabilities.vkResetCommandPool)).apply { check() }

    // --- [ vkResetDescriptorPool ] ---
    fun resetDescriptorPool(descriptorPool: VkDescriptorPool, flags: VkDescriptorPoolResetFlags): VkResult =
            VkResult(callPJI(adr, descriptorPool.L, flags, capabilities.vkResetDescriptorPool)).apply { check() }

    // --- [ vkResetEvent ] ---
    fun resetEvent(event: VkEvent): VkResult =
            VkResult(callPJI(adr, event.L, capabilities.vkResetEvent))

    // --- [ vkResetFences ] ---
    fun resetFences(fences: VkFence_Array): VkResult = stak { s ->
        VkResult(callPPI(adr, fences.size, fences write s, capabilities.vkResetFences))
    }

    fun resetFences(fence: VkFence): VkResult = stak.longAdr(fence.L) {
        VkResult(callPPI(adr, 1, it, capabilities.vkResetFences))
    }

    // --- [ vkSetEvent ] ---
    fun setEvent(event: VkEvent): VkResult =
            VkResult(callPJI(adr, event.L, capabilities.vkSetEvent))

    // --- [ vkUnmapMemory ] ---
    infix fun unmapMemory(memory: VkDeviceMemory) = callPJV(adr, memory.L, capabilities.vkUnmapMemory)

    // --- [ vkUpdateDescriptorSets ] ---
    fun nUpdateDescriptorSets(descriptorWriteCount: Int, pDescriptorWrites: Ptr, descriptorCopyCount: Int, pDescriptorCopies: Ptr) =
            callPPPV(adr, descriptorWriteCount, pDescriptorWrites, descriptorCopyCount, pDescriptorCopies, capabilities.vkUpdateDescriptorSets)

    fun updateDescriptorSets(descriptorWrites: Array<WriteDescriptorSet>, descriptorCopies: Array<CopyDescriptorSet>) = stak { s ->
        nUpdateDescriptorSets(descriptorWrites.size, descriptorWrites write s, descriptorCopies.size, descriptorCopies write s)
    }

    fun updateDescriptorSets(descriptorWrite: WriteDescriptorSet, descriptorCopy: CopyDescriptorSet) = stak { s ->
        nUpdateDescriptorSets(1, descriptorWrite write s, 1, descriptorCopy write s)
    }

    // --- [ vkWaitForFences ] ---
    fun waitForFences(fences: VkFence_Array, waitAll: Boolean, timeout: NanoSecond): VkResult = stak { s ->
        VkResult(callPPJI(adr, fences.size, fences write s, waitAll.i, timeout, capabilities.vkWaitForFences))
    }

    fun waitForFences(fence: VkFence, waitAll: Boolean, timeout: NanoSecond): VkResult = stak.longAdr(fence.L) {
        VkResult(callPPJI(adr, 1, it, waitAll.i, timeout, capabilities.vkWaitForFences))
    }

    // JVM custom: vkMapMemory + vkUnmapMemory
    inline fun <R> mappedMemory(memory: VkDeviceMemory, offset: VkDeviceSize, size: VkDeviceSize,
                                flags: VkMemoryMapFlags = 0, block: (Ptr) -> R): R =
            block(mapMemory(memory, offset, size, flags)).also {
                unmapMemory(memory)
            }

    // ---------------------------------------------- VK11 -------------------------------------------------------------

    // --- [ vkBindBufferMemory2 ] ---
    inline fun nBindBufferMemory2(bindInfoCount: Int, pBindInfos: Ptr): VkResult =
            VkResult(callPPI(adr, bindInfoCount, pBindInfos, capabilities.vkBindBufferMemory2))

    infix fun bindBufferMemory2(bindInfos: Array<BindBufferMemoryInfo>): VkResult = stak { s ->
        nBindBufferMemory2(bindInfos.size, bindInfos write s).apply { check() }
    }

    infix fun bindBufferMemory2(bindInfo: BindBufferMemoryInfo): VkResult = stak { s ->
        nBindBufferMemory2(1, bindInfo write s).apply { check() }
    }

    // --- [ vkBindImageMemory2 ] ---
    inline fun nBindImageMemory2(bindInfoCount: Int, pBindInfos: Ptr): VkResult =
            VkResult(callPPI(adr, bindInfoCount, pBindInfos, capabilities.vkBindImageMemory2))

    infix fun bindImageMemory2(bindInfos: Array<BindImageMemoryInfo>): VkResult = stak { s ->
        nBindImageMemory2(bindInfos.size, bindInfos write s).apply { check() }
    }

    infix fun bindImageMemory2(bindInfo: BindImageMemoryInfo): VkResult = stak { s ->
        nBindImageMemory2(1, bindInfo write s).apply { check() }
    }

    // --- [ vkGetDeviceGroupPeerMemoryFeatures ] ---
    fun getGroupPeerMemoryFeatures(heapIndex: Int, localDeviceIndex: Int, remoteDeviceIndex: Int): VkPeerMemoryFeatureFlags =
            stak.intAdr {
                callPPV(adr, heapIndex, localDeviceIndex, remoteDeviceIndex, it, capabilities.vkGetDeviceGroupPeerMemoryFeatures)
            }

    // --- [ vkGetDeviceQueue2 ] ---
    infix fun getQueue2(queueInfo: DeviceQueueInfo2): Queue = stak { s ->
        Queue(s.longAdr {
            callPPPV(adr, queueInfo write s, it, capabilities.vkGetDeviceQueue2)
        }, this)
    }

    // --- [ vkGetImageMemoryRequirements2 ] ---
    infix fun getImageMemoryRequirements2(info: ImageMemoryRequirementsInfo2): MemoryRequirements2 = stak { s ->
        MemoryRequirements2.read {
            callPPPV(adr, info write s, it, capabilities.vkGetImageMemoryRequirements2)
        }
    }

    // --- [ vkGetBufferMemoryRequirements2 ] ---
    fun getBufferMemoryRequirements2(info: BufferMemoryRequirementsInfo2): MemoryRequirements2 = stak { s ->
        MemoryRequirements2.read {
            callPPPV(adr, info write s, it, capabilities.vkGetBufferMemoryRequirements2)
        }
    }

    // --- [ vkGetImageSparseMemoryRequirements2 ] ---
    inline fun nGetImageSparseMemoryRequirements2(pInfo: Ptr, pSparseMemoryRequirementCount: IntPtr, pSparseMemoryRequirements: Ptr = NULL) =
            callPPPPV(adr, pInfo, pSparseMemoryRequirementCount.adr, pSparseMemoryRequirements, capabilities.vkGetImageSparseMemoryRequirements2)

    infix fun getImageSparseMemoryRequirements2(info: ImageSparseMemoryRequirementsInfo2): Array<SparseImageMemoryRequirements2> = stak { s ->
        val pSparseMemoryRequirementCount = s.mInt()
        val pInfo = info write s
        nGetImageSparseMemoryRequirements2(pInfo, pSparseMemoryRequirementCount)
        val sparseMemoryRequirementCount = pSparseMemoryRequirementCount[0]
        val sparseMemoryRequirements = s.ncalloc(VkSparseImageMemoryRequirements2.ALIGNOF, sparseMemoryRequirementCount, VkSparseImageMemoryRequirements2.SIZEOF)
        nGetImageSparseMemoryRequirements2(pInfo, pSparseMemoryRequirementCount, sparseMemoryRequirements)
        return Array(sparseMemoryRequirementCount) {
            SparseImageMemoryRequirements2(BytePtr(sparseMemoryRequirements + it * VkSparseImageMemoryRequirements2.SIZEOF))
        }
    }

    // --- [ vkTrimCommandPool ] ---
    fun trimCommandPool(commandPool: VkCommandPool, flags: VkCommandPoolTrimFlags = 0) =
            callPJV(adr, commandPool.L, flags, capabilities.vkTrimCommandPool)
}

private fun getDeviceCapabilities(handle: Ptr, physicalDevice: PhysicalDevice, ci: DeviceCreateInfo, apiVersion_: Int): CapabilitiesDevice {
    var apiVersion = apiVersion_
    val GetDeviceProcAddr = stak { s ->
        if (apiVersion == 0) {
            val GetPhysicalDeviceProperties = callPPP(
                    physicalDevice.instance.adr,
                    s.asciiAdr("vkGetPhysicalDeviceProperties"),
                    VK.globalCommands!!.vkGetInstanceProcAddr
            )
            val props = s.ncalloc(VkPhysicalDeviceProperties.ALIGNOF, 1, VkPhysicalDeviceProperties.SIZEOF)
            callPPV(physicalDevice.adr, props, GetPhysicalDeviceProperties)
            apiVersion = memGetInt(props)
            if (apiVersion == 0)  // vkGetPhysicalDeviceProperties failed?
                apiVersion = physicalDevice.instance.capabilities.apiVersion
        }

        callPPP(physicalDevice.instance.adr, s.asciiAdr("vkGetDeviceProcAddr"), VK.globalCommands!!.vkGetInstanceProcAddr)
    }

    return CapabilitiesDevice(FunctionProvider { functionName ->
        callPPP(handle, functionName.adr, GetDeviceProcAddr).also {
            if (it == NULL && Checks.DEBUG_FUNCTIONS)
                apiLog("Failed to locate address for VK device function " + memASCII(functionName))
        }
    }, physicalDevice.capabilities, VK.getEnabledExtensionSet(apiVersion, ci.enabledExtensionNames))
}