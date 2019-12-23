package vkk._10.api

import glm_.L
import glm_.i
import vkk.identifiers.CapabilitiesDevice
import vkk.identifiers.CommandBuffer
import kool.*
import org.lwjgl.system.JNI.*
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.system.Pointer
import org.lwjgl.vulkan.VkFramebufferCreateInfo
import org.lwjgl.vulkan.VkImageViewCreateInfo
import org.lwjgl.vulkan.VkSparseImageMemoryRequirements
import vkk.*
import vkk._10.structs.*
import vkk.entities.*

interface Device_vk10 : Pointer {

    val capabilities: CapabilitiesDevice

    // --- [ vkAcquireNextImageKHR ] ---

    fun MemoryStack.acquireNextImageKHR(swapchain: VkSwapchainKHR, timeout: Long = -1L, semaphore: VkSemaphore, fence: VkFence = VkFence.NULL, check: (VkResult) -> Unit = ::defaultCheck): Int =
            framed { this.intAdr { check(nAcquireNextImageKHR(swapchain, timeout, semaphore, fence, it)) } }

    fun acquireNextImageKHR(swapchain: VkSwapchainKHR, timeout: Long = -1L, semaphore: VkSemaphore, fence: VkFence = VkFence.NULL, check: (VkResult) -> Unit = ::defaultCheck): Int =
            stak { it.acquireNextImageKHR(swapchain, timeout, semaphore, fence, check) }

    // --- [ vkAllocateDescriptorSets ] ---

    infix fun MemoryStack.allocateDescriptorSets(allocateInfo: DescriptorSetAllocateInfo): VkDescriptorSet_Array =
            framed {
                val descriptors = this.mLong(allocateInfo.setLayouts.size)
                nAllocateDescriptorSets(allocateInfo write this, descriptors.adr)
                VkDescriptorSet_Array(allocateInfo.setLayouts.size) { VkDescriptorSet(descriptors[it]) }
            }

    infix fun allocateDescriptorSets(allocateInfo: DescriptorSetAllocateInfo): VkDescriptorSet_Array =
            stak { it allocateDescriptorSets allocateInfo }


    infix fun MemoryStack.allocateDescriptorSet(allocateInfo: DescriptorSetAllocateInfo): VkDescriptorSet =
            framed { VkDescriptorSet(this.longAdr { nAllocateDescriptorSets(allocateInfo write this, it).check() }) }

    infix fun allocateDescriptorSet(allocateInfo: DescriptorSetAllocateInfo): VkDescriptorSet =
            stak { it allocateDescriptorSet allocateInfo }

    // --- [ vkAllocateMemory ] ---

    infix fun MemoryStack.allocateMemory(allocateInfo: MemoryAllocateInfo): VkDeviceMemory =
            framed { VkDeviceMemory(this.longAdr { nAllocateMemory(allocateInfo write this, it).check() }) }

    infix fun allocateMemory(allocateInfo: MemoryAllocateInfo): VkDeviceMemory =
            stak { it allocateMemory allocateInfo }

    // --- [ vkBindBufferMemory ] ---
    fun bindBufferMemory(buffer: VkBuffer, memory: VkDeviceMemory, memoryOffset: VkDeviceSize = VkDeviceSize(0)): VkResult =
            VkResult(callPJJJI(adr, buffer.L, memory.L, memoryOffset.L, capabilities.vkBindBufferMemory)).andCheck()

    // --- [ vkBindImageMemory ] ---
    fun bindImageMemory(image: VkImage, memory: VkDeviceMemory, memoryOffset: VkDeviceSize = VkDeviceSize(0)): VkResult =
            VkResult(callPJJJI(adr, image.L, memory.L, memoryOffset.L, capabilities.vkBindImageMemory))

    // --- [ vkCreateBuffer ] ---

    infix fun MemoryStack.createBuffer(createInfo: BufferCreateInfo): VkBuffer =
            framed { VkBuffer(this.longAdr { nCreateBuffer(createInfo write this, it).check() }) }

    infix fun createBuffer(createInfo: BufferCreateInfo): VkBuffer =
            stak { it createBuffer createInfo }

    // --- [ vkCreateBufferView ] ---

    infix fun MemoryStack.createBufferView(createInfo: BufferViewCreateInfo): VkBufferView =
            framed { VkBufferView(this.longAdr { nCreateBufferView(createInfo write this, it).check() }) }

    infix fun createBufferView(createInfo: BufferViewCreateInfo): VkBufferView =
            stak { it createBufferView createInfo }

    // --- [ vkCreateCommandPool ] ---

    infix fun MemoryStack.createCommandPool(createInfo: CommandPoolCreateInfo): VkCommandPool =
            framed { VkCommandPool(this.longAdr { nCreateCommandPool(createInfo write this, it).check() }) }

    infix fun createCommandPool(createInfo: CommandPoolCreateInfo): VkCommandPool =
            stak { it createCommandPool createInfo }

    // --- [ vkCreateComputePipelines ] ---

    fun MemoryStack.createComputePipelines(pipelineCache: VkPipelineCache, createInfos: Array<ComputePipelineCreateInfo>): VkPipeline_Array =
            framed {
                val pipelines = this.mLong(createInfos.size)
                nCreateComputePipelines(pipelineCache, createInfos.size, createInfos write this, pipelines.adr).check()
                VkPipeline_Array(createInfos.size) { VkPipeline(pipelines[it]) }
            }

    fun createComputePipelines(pipelineCache: VkPipelineCache, createInfos: Array<ComputePipelineCreateInfo>): VkPipeline_Array =
            stak { it.createComputePipelines(pipelineCache, createInfos) }


    fun MemoryStack.createComputePipelines(pipelineCache: VkPipelineCache, createInfo: ComputePipelineCreateInfo): VkPipeline =
            framed { VkPipeline(this.longAdr { nCreateComputePipelines(pipelineCache, 1, createInfo write this, it).check() }) }

    fun createComputePipelines(pipelineCache: VkPipelineCache, createInfo: ComputePipelineCreateInfo): VkPipeline =
            stak { it.createComputePipelines(pipelineCache, createInfo) }

    // overloads with pipelineCache = null

    infix fun MemoryStack.createComputePipelines(createInfos: Array<ComputePipelineCreateInfo>): VkPipeline_Array = createComputePipelines(VkPipelineCache.NULL, createInfos)
    infix fun createComputePipelines(createInfos: Array<ComputePipelineCreateInfo>): VkPipeline_Array = createComputePipelines(VkPipelineCache.NULL, createInfos)

    infix fun MemoryStack.createComputePipelines(createInfo: ComputePipelineCreateInfo): VkPipeline = createComputePipelines(VkPipelineCache.NULL, createInfo)
    infix fun createComputePipelines(createInfo: ComputePipelineCreateInfo): VkPipeline = createComputePipelines(VkPipelineCache.NULL, createInfo)

    // --- [ vkCreateDescriptorPool ] ---

    infix fun MemoryStack.createDescriptorPool(createInfo: DescriptorPoolCreateInfo): VkDescriptorPool =
            framed { VkDescriptorPool(this.longAdr { nCreateDescriptorPool(createInfo write this, it).check() }) }

    infix fun createDescriptorPool(createInfo: DescriptorPoolCreateInfo): VkDescriptorPool =
            stak { it createDescriptorPool createInfo }

    // --- [ vkCreateDescriptorSetLayout ] ---

    infix fun MemoryStack.createDescriptorSetLayout(createInfo: DescriptorSetLayoutCreateInfo): VkDescriptorSetLayout =
            framed { VkDescriptorSetLayout(this.longAdr { nCreateDescriptorSetLayout(createInfo write this, it).check() }) }

    infix fun createDescriptorSetLayout(createInfo: DescriptorSetLayoutCreateInfo): VkDescriptorSetLayout =
            stak { it createDescriptorSetLayout createInfo }

    // --- [ vkCreateEvent ] ---

    infix fun MemoryStack.createEvent(createInfo: EventCreateInfo): VkEvent =
            framed { VkEvent(this.longAdr { nCreateEvent(createInfo write this, it).check() }) }

    infix fun createEvent(createInfo: EventCreateInfo): VkEvent =
            stak { it createEvent createInfo }

    // --- [ vkCreateFence ] ---

    infix fun MemoryStack.createFence(createInfo: FenceCreateInfo): VkFence =
            framed { VkFence(this.longAdr { nCreateFence(createInfo write this, it).check() }) }

    infix fun createFence(createInfo: FenceCreateInfo): VkFence =
            stak { it createFence createInfo }

    // --- [ vkCreateFramebuffer ] ---

    infix fun MemoryStack.createFramebuffer(createInfo: FramebufferCreateInfo): VkFramebuffer =
            framed { VkFramebuffer(this.longAdr { nCreateFramebuffer(createInfo write this, it).check() }) }

    infix fun createFramebuffer(createInfo: FramebufferCreateInfo): VkFramebuffer =
            stak { it createFramebuffer createInfo }

    // JVM custom
    fun MemoryStack.createFramebufferArray(createInfo: FramebufferCreateInfo, imageViews: VkImageView_Array): VkFramebuffer_Array =
            framed {
                val pCreateInfo = createInfo write this
                VkFramebufferCreateInfo.nattachmentCount(pCreateInfo, 1)
                val pAttachment = this.mLong()
                memPutAddress(pCreateInfo + VkFramebufferCreateInfo.PATTACHMENTS, pAttachment.adr)
                val pFramebuffer = this.mLong()
                VkFramebuffer_Array(imageViews.size) { i ->
                    pAttachment[0] = imageViews[i].L
                    nCreateFramebuffer(pCreateInfo, pFramebuffer.adr).check()
                    VkFramebuffer(pFramebuffer[0])
                }
            }

    fun createFramebufferArray(createInfo: FramebufferCreateInfo, imageViews: VkImageView_Array): VkFramebuffer_Array =
            stak { it.createFramebufferArray(createInfo, imageViews) }

    // --- [ vkCreateGraphicsPipelines ] ---

    fun MemoryStack.createGraphicsPipeline(pipelineCache: VkPipelineCache, createInfos: Array<GraphicsPipelineCreateInfo>): VkPipeline_Array =
            framed {
                val pipelines = this.mLong(createInfos.size)
                nCreateGraphicsPipelines(pipelineCache, 1, createInfos write this, pipelines.adr).check()
                VkPipeline_Array(createInfos.size) { VkPipeline(pipelines[it]) }
            }

    fun createGraphicsPipeline(pipelineCache: VkPipelineCache, createInfos: Array<GraphicsPipelineCreateInfo>): VkPipeline_Array =
            stak { it.createGraphicsPipeline(pipelineCache, createInfos) }


    fun MemoryStack.createGraphicsPipeline(pipelineCache: VkPipelineCache, createInfo: GraphicsPipelineCreateInfo): VkPipeline =
            framed { VkPipeline(this.longAdr { nCreateGraphicsPipelines(pipelineCache, 1, createInfo write this, it).check() }) }

    fun createGraphicsPipeline(pipelineCache: VkPipelineCache, createInfo: GraphicsPipelineCreateInfo): VkPipeline =
            stak { it.createGraphicsPipeline(pipelineCache, createInfo) }

    // overloads with pipelineCache = null

    infix fun MemoryStack.createGraphicsPipeline(createInfos: Array<GraphicsPipelineCreateInfo>): VkPipeline_Array = createGraphicsPipeline(VkPipelineCache.NULL, createInfos)
    infix fun createGraphicsPipeline(createInfos: Array<GraphicsPipelineCreateInfo>): VkPipeline_Array = createGraphicsPipeline(VkPipelineCache.NULL, createInfos)

    infix fun MemoryStack.createGraphicsPipeline(createInfo: GraphicsPipelineCreateInfo): VkPipeline = createGraphicsPipeline(VkPipelineCache.NULL, createInfo)
    infix fun createGraphicsPipeline(createInfo: GraphicsPipelineCreateInfo): VkPipeline = createGraphicsPipeline(VkPipelineCache.NULL, createInfo)

    // --- [ vkCreateImage ] ---

    infix fun MemoryStack.createImage(createInfo: ImageCreateInfo): VkImage =
            framed { VkImage(this.longAdr { nCreateImage(createInfo write this, it).check() }) }

    infix fun createImage(createInfo: ImageCreateInfo): VkImage =
            stak { it createImage createInfo }

    // --- [ vkCreateImageView ] ---

    infix fun MemoryStack.createImageView(createInfo: ImageViewCreateInfo): VkImageView =
            framed { VkImageView(this.longAdr { nCreateImageView(createInfo write this, it).check() }) }

    infix fun createImageView(createInfo: ImageViewCreateInfo): VkImageView =
            stak { it createImageView createInfo }

    // JVM
    fun MemoryStack.createImageViewArray(createInfo: ImageViewCreateInfo, images: VkImage_Array): VkImageView_Array =
            framed {
                val pCreateInfo = createInfo write this
                val pImageView = this.mLong()
                VkImageView_Array(images.size) { i ->
                    VkImageViewCreateInfo.nimage(pCreateInfo, images[i].L)
                    nCreateImageView(pCreateInfo, pImageView.adr)
                    VkImageView(pImageView[0])
                }
            }

    fun createImageViewArray(createInfo: ImageViewCreateInfo, images: VkImage_Array): VkImageView_Array =
            stak { it.createImageViewArray(createInfo, images) }

    // --- [ vkCreatePipelineCache ] ---

    fun MemoryStack.createPipelineCache(createInfo: PipelineCacheCreateInfo = PipelineCacheCreateInfo()): VkPipelineCache =
            framed { VkPipelineCache(this.longAdr { callPPPPI(adr, createInfo write this, NULL, it, capabilities.vkCreatePipelineCache) }) }

    fun createPipelineCache(createInfo: PipelineCacheCreateInfo = PipelineCacheCreateInfo()): VkPipelineCache =
            stak { it.createPipelineCache(createInfo) }

    // --- [ vkCreatePipelineLayout ] ---

    infix fun MemoryStack.createPipelineLayout(createInfo: PipelineLayoutCreateInfo): VkPipelineLayout =
            framed { VkPipelineLayout(this.longAdr { callPPPPI(adr, createInfo write this, NULL, it, capabilities.vkCreatePipelineLayout) }) }

    infix fun createPipelineLayout(createInfo: PipelineLayoutCreateInfo): VkPipelineLayout =
            stak { it createPipelineLayout createInfo }

    // --- [ vkCreateQueryPool ] ---

    infix fun MemoryStack.createQueryPool(createInfo: QueryPoolCreateInfo): VkQueryPool =
            framed { VkQueryPool(this.longAdr { callPPPPI(adr, createInfo write this, NULL, it, capabilities.vkCreateQueryPool) }) }

    infix fun createQueryPool(createInfo: QueryPoolCreateInfo): VkQueryPool =
            stak { it createQueryPool createInfo }

    // --- [ vkCreateRenderPass ] ---

    infix fun MemoryStack.createRenderPass(createInfo: RenderPassCreateInfo): VkRenderPass =
            framed { VkRenderPass(this.longAdr { callPPPPI(adr, createInfo write this, NULL, it, capabilities.vkCreateRenderPass) }) }

    infix fun createRenderPass(createInfo: RenderPassCreateInfo): VkRenderPass =
            stak { it createRenderPass createInfo }

    // --- [ vkCreateSampler ] ---

    infix fun MemoryStack.createSampler(createInfo: SamplerCreateInfo): VkSampler =
            framed { VkSampler(this.longAdr { callPPPPI(adr, createInfo write this, NULL, it, capabilities.vkCreateSampler) }) }

    infix fun createSampler(createInfo: SamplerCreateInfo): VkSampler =
            stak { it createSampler createInfo }

    // --- [ vkCreateSemaphore ] ---

    fun MemoryStack.createSemaphore(createInfo: SemaphoreCreateInfo = SemaphoreCreateInfo()): VkSemaphore =
            framed { VkSemaphore(this.longAdr { callPPPPI(adr, createInfo write this, NULL, it, capabilities.vkCreateSemaphore) }) }

    fun createSemaphore(createInfo: SemaphoreCreateInfo = SemaphoreCreateInfo()): VkSemaphore =
            stak { it.createSemaphore(createInfo) }

    // --- [ vkCreateShaderModule ] ---

    infix fun MemoryStack.createShaderModule(createInfo: ShaderModuleCreateInfo): VkShaderModule =
            framed { VkShaderModule(this.longAdr { callPPPPI(adr, createInfo write this, NULL, it, capabilities.vkCreateShaderModule) }) }

    infix fun createShaderModule(createInfo: ShaderModuleCreateInfo): VkShaderModule =
            stak { it createShaderModule createInfo }

    // --- [ vkCreateSwapchainKHR ] ---

    infix fun MemoryStack.createSwapchainKHR(createInfo: SwapchainCreateInfoKHR): VkSwapchainKHR =
            framed { VkSwapchainKHR(this.longAdr { VK_CHECK_RESULT(callPPPPI(adr, createInfo write this, NULL, it, capabilities.vkCreateSwapchainKHR)) }) }

    infix fun createSwapchainKHR(createInfo: SwapchainCreateInfoKHR): VkSwapchainKHR =
            stak { it createSwapchainKHR createInfo }

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
    infix fun destroy(imageView: VkImageView) =
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

    infix fun MemoryStack.flushMappedMemoryRanges(memoryRanges: Array<MappedMemoryRange>): VkResult =
            framed { nFlushMappedMemoryRanges(memoryRanges.size, memoryRanges write this) }

    infix fun flushMappedMemoryRanges(memoryRanges: Array<MappedMemoryRange>): VkResult =
            stak { it flushMappedMemoryRanges memoryRanges }


    infix fun MemoryStack.flushMappedMemoryRanges(memoryRange: MappedMemoryRange): VkResult =
            framed { nFlushMappedMemoryRanges(1, memoryRange write this) }

    infix fun flushMappedMemoryRanges(memoryRange: MappedMemoryRange): VkResult =
            stak { it flushMappedMemoryRanges memoryRange }

    // --- [ vkFreeCommandBuffers ] ---

    fun MemoryStack.freeCommandBuffers(commandPool: VkCommandPool, commandBuffer: CommandBuffer) =
            framed { nFreeCommandBuffers(commandPool, 1, this.longAdr(commandBuffer.adr)) }

    fun freeCommandBuffers(commandPool: VkCommandPool, commandBuffer: CommandBuffer) =
            stak { it.freeCommandBuffers(commandPool, commandBuffer) }


    fun MemoryStack.freeCommandBuffers(commandPool: VkCommandPool, commandBuffers: Array<CommandBuffer>) =
            framed { nFreeCommandBuffers(commandPool, commandBuffers.size, commandBuffers write this) }

    fun freeCommandBuffers(commandPool: VkCommandPool, commandBuffers: Array<CommandBuffer>) =
            stak { it.freeCommandBuffers(commandPool, commandBuffers) }

    // --- [ vkFreeMemory ] ---
    infix fun freeMemory(memory: VkDeviceMemory) =
            callPJPV(adr, memory.L, NULL, capabilities.vkFreeMemory)

    // --- [ vkGetBufferMemoryRequirements ] ---

    infix fun MemoryStack.getBufferMemoryRequirements(buffer: VkBuffer): MemoryRequirements =
            framed { MemoryRequirements.read(this) { callPJPV(adr, buffer.L, it, capabilities.vkGetBufferMemoryRequirements) } }

    infix fun getBufferMemoryRequirements(buffer: VkBuffer): MemoryRequirements =
            stak { it getBufferMemoryRequirements buffer }

    // --- [ vkGetEventStatus ] ---
    fun getEventStatus(event: VkEvent): VkResult =
            VkResult(callPJI(adr, event.L, capabilities.vkGetEventStatus))

    // --- [ vkGetFenceStatus ] ---
    fun getFenceStatus(fence: VkFence): VkResult =
            VkResult(callPJI(adr, fence.L, capabilities.vkGetFenceStatus))

    // --- [ vkGetRenderAreaGranularity ] ---

    infix fun MemoryStack.getRenderAreaGranularity(renderPass: VkRenderPass): Extent2D =
            framed { Extent2D.read(this) { callPJPV(adr, renderPass.L, it, capabilities.vkGetRenderAreaGranularity) } }

    infix fun getRenderAreaGranularity(renderPass: VkRenderPass): Extent2D =
            stak { it getRenderAreaGranularity renderPass }

    // --- [ vkFreeDescriptorSets ] ---

    fun MemoryStack.freeDescriptorSets(descriptorPool: VkDescriptorPool, descriptorSets: VkDescriptorSet_Array): VkResult =
            framed { nFreeDescriptorSets(descriptorPool, descriptorSets.size, descriptorSets write this).andCheck() }

    fun freeDescriptorSets(descriptorPool: VkDescriptorPool, descriptorSets: VkDescriptorSet_Array): VkResult =
            stak { it.freeDescriptorSets(descriptorPool, descriptorSets) }


    fun MemoryStack.freeDescriptorSets(descriptorPool: VkDescriptorPool, descriptorSet: VkDescriptorSet): VkResult =
            framed { nFreeDescriptorSets(descriptorPool, 1, this.longAdr(descriptorSet.L)).andCheck() }

    fun freeDescriptorSets(descriptorPool: VkDescriptorPool, descriptorSet: VkDescriptorSet): VkResult =
            stak { it.freeDescriptorSets(descriptorPool, descriptorSet) }

    // --- [ vkGetImageMemoryRequirements ] ---

    infix fun MemoryStack.getImageMemoryRequirements(image: VkImage): MemoryRequirements =
            framed { MemoryRequirements.read(this) { callPJPV(adr, image.L, it, capabilities.vkGetImageMemoryRequirements) } }

    infix fun getImageMemoryRequirements(image: VkImage): MemoryRequirements =
            stak { it getImageMemoryRequirements image }

    // --- [ vkGetImageSparseMemoryRequirements ] ---

    infix fun MemoryStack.getImageSparseMemoryRequirements(image: VkImage): Array<SparseImageMemoryRequirements> =
            framed {
                val pSparseMemoryRequirementCount = this.mInt()
                nGetImageSparseMemoryRequirements(image, pSparseMemoryRequirementCount)
                val sparseMemoryRequirementCount = pSparseMemoryRequirementCount[0]
                val sparseMemoryRequirements = this.ncalloc(VkSparseImageMemoryRequirements.ALIGNOF, sparseMemoryRequirementCount, VkSparseImageMemoryRequirements.SIZEOF)
                nGetImageSparseMemoryRequirements(image, pSparseMemoryRequirementCount, sparseMemoryRequirements)
                Array(sparseMemoryRequirementCount) {
                    SparseImageMemoryRequirements(BytePtr(sparseMemoryRequirements + it * VkSparseImageMemoryRequirements.SIZEOF))
                }
            }

    infix fun getImageSparseMemoryRequirements(image: VkImage): Array<SparseImageMemoryRequirements> =
            stak { it getImageSparseMemoryRequirements image }

    // --- [ vkGetImageSubresourceLayout ] ---

    fun MemoryStack.getImageSubresourceLayout(image: VkImage, subresource: ImageSubresource): SubresourceLayout =
            framed { SubresourceLayout.read(this) { callPJPPV(adr, image.L, subresource write this, it, capabilities.vkGetImageSubresourceLayout) } }

    fun getImageSubresourceLayout(image: VkImage, subresource: ImageSubresource): SubresourceLayout =
            stak { it.getImageSubresourceLayout(image, subresource) }

    // --- [ vkGetPipelineCacheData ] ---

    infix fun MemoryStack.getPipelineCacheData(pipelineCache: VkPipelineCache): ByteArray =
            framed {
                var data: Ptr = NULL
                val pDataSize = this.mInt()
                var dataSize: Int
                var result: VkResult
                do {
                    result = nGetPipelineCacheData(pipelineCache, pDataSize)
                    dataSize = pDataSize[0]
                    if (result == VkResult.SUCCESS && dataSize != 0) {
                        data = this.ncalloc(1, dataSize, 1)
                        result = nGetPipelineCacheData(pipelineCache, pDataSize, data)
                    }
                } while (result == VkResult.INCOMPLETE)
                ByteArray(dataSize) { memGetByte(data + it) }
            }

    infix fun getPipelineCacheData(pipelineCache: VkPipelineCache): ByteArray =
            stak { it getPipelineCacheData pipelineCache }

    // --- [ vkGetQueryPoolResults ] ---
    fun getQueryPoolResults(queryPool: VkQueryPool, firstQuery: Int, queryCount: Int, dataSize: Int, pData: Ptr, stride: VkDeviceSize, flags: VkQueryResultFlags): VkResult =
            VkResult(callPJPPJI(adr, queryPool.L, firstQuery, queryCount, dataSize.L, pData, stride.L, flags, capabilities.vkGetQueryPoolResults))

    // --- [ vkGetSwapchainImagesKHR ] ---

    infix fun MemoryStack.getSwapchainImagesKHR(swapchain: VkSwapchainKHR): VkImage_Array =
            framed {
                var pSwapchainImages = LongPtr.NULL
                val pSwapchainImageCount = this.mInt()
                var swapchainImageCount: Int
                var result: VkResult
                do {
                    result = nGetSwapchainImagesKHR(swapchain, pSwapchainImageCount.adr)
                    swapchainImageCount = pSwapchainImageCount[0]
                    if (result == VkResult.SUCCESS && swapchainImageCount != 0) {
                        pSwapchainImages = this.mLong(swapchainImageCount)
                        result = nGetSwapchainImagesKHR(swapchain, pSwapchainImageCount.adr, pSwapchainImages.adr)
                    }
                } while (result == VkResult.INCOMPLETE)
                VkImage_Array(swapchainImageCount) { VkImage(pSwapchainImages[it]) }
            }

    infix fun getSwapchainImagesKHR(swapchain: VkSwapchainKHR): VkImage_Array =
            stak { it getSwapchainImagesKHR swapchain }

    // --- [ vkInvalidateMappedMemoryRanges ] ---

    infix fun MemoryStack.invalidateMappedMemoryRanges(memoryRanges: Array<MappedMemoryRange>): VkResult =
            framed { nInvalidateMappedMemoryRanges(memoryRanges.size, memoryRanges write this) }

    infix fun invalidateMappedMemoryRanges(memoryRanges: Array<MappedMemoryRange>): VkResult =
            stak { it invalidateMappedMemoryRanges memoryRanges }


    infix fun MemoryStack.invalidateMappedMemoryRanges(memoryRange: MappedMemoryRange): VkResult =
            framed { nInvalidateMappedMemoryRanges(1, memoryRange write this) }

    infix fun invalidateMappedMemoryRanges(memoryRange: MappedMemoryRange): VkResult =
            stak { it invalidateMappedMemoryRanges memoryRange }

    // --- [ vkGetDeviceMemoryCommitment ] ---

    infix fun MemoryStack.getMemoryCommitment(memory: VkDeviceMemory): VkDeviceSize =
            framed { VkDeviceSize(this.longAdr { callPJPV(adr, memory.L, it, capabilities.vkGetDeviceMemoryCommitment) }) }

    infix fun getMemoryCommitment(memory: VkDeviceMemory): VkDeviceSize =
            stak { it getMemoryCommitment memory }

    // --- [ vkMapMemory ] ---

    fun MemoryStack.mapMemory(memory: VkDeviceMemory, offset: VkDeviceSize, size: VkDeviceSize, flags: VkMemoryMapFlags = 0): Ptr =
            framed { this.pointerAdr { callPJJJPI(adr, memory.L, offset.L, size.L, flags, it, capabilities.vkMapMemory) } }

    fun mapMemory(memory: VkDeviceMemory, offset: VkDeviceSize, size: VkDeviceSize, flags: VkMemoryMapFlags = 0): Ptr =
            stak { it.mapMemory(memory, offset, size, flags) }

    // --- [ vkMergePipelineCaches ] ---

    fun MemoryStack.mergePipelineCaches(dstCache: VkPipelineCache, srcCaches: VkPipelineCache_Array): VkResult =
            framed { VkResult(callPJPI(adr, dstCache.L, srcCaches.size, srcCaches write this, capabilities.vkMergePipelineCaches)) }

    fun mergePipelineCaches(dstCache: VkPipelineCache, srcCaches: VkPipelineCache_Array): VkResult =
            stak { it.mergePipelineCaches(dstCache, srcCaches) }

    // --- [ vkResetCommandPool ] ---
    fun resetCommandPool(commandPool: VkCommandPool, flags: VkCommandPoolResetFlags = 0): VkResult =
            VkResult(callPJI(adr, commandPool.L, flags, capabilities.vkResetCommandPool)).andCheck()

    // --- [ vkResetDescriptorPool ] ---
    fun resetDescriptorPool(descriptorPool: VkDescriptorPool, flags: VkDescriptorPoolResetFlags): VkResult =
            VkResult(callPJI(adr, descriptorPool.L, flags, capabilities.vkResetDescriptorPool)).andCheck()

    // --- [ vkResetEvent ] ---
    infix fun resetEvent(event: VkEvent): VkResult =
            VkResult(callPJI(adr, event.L, capabilities.vkResetEvent))

    // --- [ vkResetFences ] ---

    infix fun MemoryStack.resetFences(fences: VkFence_Array): VkResult =
            framed { VkResult(callPPI(adr, fences.size, fences write this, capabilities.vkResetFences)) }

    infix fun resetFences(fences: VkFence_Array): VkResult =
            stak { it resetFences fences }


    infix fun MemoryStack.resetFences(fence: VkFence): VkResult =
            framed { VkResult(callPPI(adr, 1, this.longAdr(fence.L), capabilities.vkResetFences)) }

    infix fun resetFences(fence: VkFence): VkResult =
            stak { it resetFences fence }


    // --- [ vkSetEvent ] ---
    infix fun setEvent(event: VkEvent): VkResult =
            VkResult(callPJI(adr, event.L, capabilities.vkSetEvent))

    // --- [ vkUnmapMemory ] ---
    infix fun unmapMemory(memory: VkDeviceMemory) =
            callPJV(adr, memory.L, capabilities.vkUnmapMemory)

    // --- [ vkUpdateDescriptorSets ] ---

    fun MemoryStack.updateDescriptorSets(descriptorWrites: Array<WriteDescriptorSet>, descriptorCopies: Array<CopyDescriptorSet>) =
            framed { nUpdateDescriptorSets(descriptorWrites.size, descriptorWrites write this, descriptorCopies.size, descriptorCopies write this) }

    fun updateDescriptorSets(descriptorWrites: Array<WriteDescriptorSet>, descriptorCopies: Array<CopyDescriptorSet>) =
            stak { it.updateDescriptorSets(descriptorWrites, descriptorCopies) }


    fun MemoryStack.updateDescriptorSets(descriptorWrite: WriteDescriptorSet, descriptorCopy: CopyDescriptorSet) =
            framed { nUpdateDescriptorSets(1, descriptorWrite write this, 1, descriptorCopy write this) }

    fun updateDescriptorSets(descriptorWrite: WriteDescriptorSet, descriptorCopy: CopyDescriptorSet) =
            stak { it.updateDescriptorSets(descriptorWrite, descriptorCopy) }

    // --- [ vkWaitForFences ] ---

    fun MemoryStack.waitForFences(fences: VkFence_Array, waitAll: Boolean, timeout: NanoSecond): VkResult =
            framed { nWaitForFences(fences.size, fences write this, waitAll, timeout) }

    fun waitForFences(fences: VkFence_Array, waitAll: Boolean, timeout: NanoSecond): VkResult =
            stak { it.waitForFences(fences, waitAll, timeout) }


    fun MemoryStack.waitForFences(fence: VkFence, waitAll: Boolean, timeout: NanoSecond): VkResult =
            framed { nWaitForFences(1, this.longAdr(fence.L), waitAll, timeout) }

    fun waitForFences(fence: VkFence, waitAll: Boolean, timeout: NanoSecond): VkResult =
            stak { it.waitForFences(fence, waitAll, timeout) }
}

inline fun Device_vk10.nAcquireNextImageKHR(swapchain: VkSwapchainKHR, timeout: Long = -1L, semaphore: VkSemaphore, fence: VkFence = VkFence.NULL, pImage: Ptr): VkResult =
        VkResult(callPJJJJPI(adr, swapchain.L, timeout, semaphore.L, fence.L, pImage, capabilities.vkAcquireNextImageKHR))

inline fun Device_vk10.nAllocateDescriptorSets(pAllocateInfo: Ptr, pDescriptorSets: Ptr): VkResult =
        VkResult(callPPPI(adr, pAllocateInfo, pDescriptorSets, capabilities.vkAllocateDescriptorSets))

inline fun Device_vk10.nAllocateMemory(allocateInfo: Ptr, memory: Ptr): VkResult =
        VkResult(callPPPPI(adr, allocateInfo, NULL, memory, capabilities.vkAllocateMemory))

inline fun Device_vk10.nCreateBuffer(createInfo: Ptr, buffer: Ptr): VkResult =
        VkResult(callPPPPI(adr, createInfo, NULL, buffer, capabilities.vkCreateBuffer))

inline fun Device_vk10.nCreateBufferView(createInfo: Ptr, bufferView: Ptr): VkResult =
        VkResult(callPPPPI(adr, createInfo, NULL, bufferView, capabilities.vkCreateBufferView))

inline fun Device_vk10.nCreateCommandPool(createInfo: Ptr, commandPool: Ptr): VkResult =
        VkResult(callPPPPI(adr, createInfo, NULL, commandPool, capabilities.vkCreateCommandPool))

inline fun Device_vk10.nCreateComputePipelines(pipelineCache: VkPipelineCache, createInfoCount: Int, pCreateInfos: Ptr, pPipelines: Ptr): VkResult =
        VkResult(callPJPPPI(adr, pipelineCache.L, createInfoCount, pCreateInfos, NULL, pPipelines, capabilities.vkCreateComputePipelines))

inline fun Device_vk10.nCreateDescriptorPool(createInfo: Ptr, descriptorPool: Ptr): VkResult =
        VkResult(callPPPPI(adr, createInfo, NULL, descriptorPool, capabilities.vkCreateDescriptorPool))

inline fun Device_vk10.nCreateDescriptorSetLayout(createInfo: Ptr, descriptorSetLayout: Ptr): VkResult =
        VkResult(callPPPPI(adr, createInfo, NULL, descriptorSetLayout, capabilities.vkCreateDescriptorSetLayout))

inline fun Device_vk10.nCreateEvent(createInfo: Ptr, event: Ptr): VkResult =
        VkResult(callPPPPI(adr, createInfo, NULL, event, capabilities.vkCreateEvent))

inline fun Device_vk10.nCreateFence(createInfo: Ptr, fence: Ptr): VkResult =
        VkResult(callPPPPI(adr, createInfo, NULL, fence, capabilities.vkCreateFence))

inline fun Device_vk10.nCreateFramebuffer(createInfo: Ptr, framebuffer: Ptr): VkResult =
        VkResult(callPPPPI(adr, createInfo, NULL, framebuffer, capabilities.vkCreateFramebuffer))

inline fun Device_vk10.nCreateGraphicsPipelines(pipelineCache: VkPipelineCache, createInfoCount: Int, pCreateInfos: Ptr, pPipelines: Ptr): VkResult =
        VkResult(callPJPPPI(adr, pipelineCache.L, createInfoCount, pCreateInfos, NULL, pPipelines, capabilities.vkCreateGraphicsPipelines))

inline fun Device_vk10.nCreateImage(createInfo: Ptr, image: Ptr): VkResult =
        VkResult(callPPPPI(adr, createInfo, NULL, image, capabilities.vkCreateImage))

inline fun Device_vk10.nCreateImageView(createInfo: Ptr, imageView: Ptr): VkResult =
        VkResult(callPPPPI(adr, createInfo, NULL, imageView, capabilities.vkCreateImageView))

inline fun Device_vk10.nFlushMappedMemoryRanges(memoryRangeCount: Int, pMemoryRanges: Ptr): VkResult =
        VkResult(callPPI(adr, memoryRangeCount, pMemoryRanges, capabilities.vkFlushMappedMemoryRanges))

inline fun Device_vk10.nFreeCommandBuffers(commandPool: VkCommandPool, commandBufferCount: Int, pCommandBuffers: Ptr) =
        callPJPV(adr, commandPool.L, commandBufferCount, pCommandBuffers, capabilities.vkFreeCommandBuffers)

inline fun Device_vk10.nFreeDescriptorSets(descriptorPool: VkDescriptorPool, descriptorSetCount: Int, pDescriptorSets: Ptr): VkResult =
        VkResult(callPJPI(adr, descriptorPool.L, descriptorSetCount, pDescriptorSets, capabilities.vkFreeDescriptorSets))

inline fun Device_vk10.nGetImageSparseMemoryRequirements(image: VkImage, pSparseMemoryRequirementCount: IntPtr, pSparseMemoryRequirements: Ptr = NULL) =
        callPJPPV(adr, image.L, pSparseMemoryRequirementCount.adr, pSparseMemoryRequirements, capabilities.vkGetImageSparseMemoryRequirements)

inline fun Device_vk10.nGetPipelineCacheData(pipelineCache: VkPipelineCache, pDataSize: IntPtr, pData: Ptr = NULL): VkResult =
        VkResult(callPJPPI(adr, pipelineCache.L, pDataSize.adr, pData, capabilities.vkGetPipelineCacheData))

inline fun Device_vk10.nGetSwapchainImagesKHR(swapchain: VkSwapchainKHR, pSwapchainImageCount: Ptr, pSwapchainImages: Ptr = NULL): VkResult =
        VkResult(callPJPPI(adr, swapchain.L, pSwapchainImageCount, pSwapchainImages, capabilities.vkGetSwapchainImagesKHR))

inline fun Device_vk10.nInvalidateMappedMemoryRanges(memoryRangeCount: Int, pMemoryRanges: Ptr): VkResult =
        VkResult(callPPI(adr, memoryRangeCount, pMemoryRanges, capabilities.vkInvalidateMappedMemoryRanges))

inline fun Device_vk10.nUpdateDescriptorSets(descriptorWriteCount: Int, pDescriptorWrites: Ptr, descriptorCopyCount: Int, pDescriptorCopies: Ptr) =
        callPPPV(adr, descriptorWriteCount, pDescriptorWrites, descriptorCopyCount, pDescriptorCopies, capabilities.vkUpdateDescriptorSets)

inline fun Device_vk10.nWaitForFences(fencesCount: Int, fences: Adr, waitAll: Boolean, timeout: NanoSecond): VkResult =
        VkResult(callPPJI(adr, fencesCount, fences, waitAll.i, timeout, capabilities.vkWaitForFences))