package vkk

import glm_.*
import glm_.vec2.Vec2i
import kool.Ptr
import kool.stak
import org.lwjgl.PointerBuffer
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.system.Pointer
import org.lwjgl.system.Pointer.POINTER_SIZE
import org.lwjgl.vulkan.*
import java.nio.ByteBuffer
import java.nio.FloatBuffer


/*
    VkCommandBuffer
 */

infix fun VkCommandBuffer.begin(beginInfo: VkCommandBufferBeginInfo) =
        VK_CHECK_RESULT(VK10.nvkBeginCommandBuffer(this, beginInfo.adr))

fun VkCommandBuffer.begin(flags: VkCommandBufferUsageFlags = VkCommandBufferUsage.SIMULTANEOUS_USE_BIT.i) =
        begin(vk.CommandBufferBeginInfo { this.flags = flags })

fun VkCommandBuffer.beginRenderPass(renderPassBegin: VkRenderPassBeginInfo, contents: VkSubpassContents) =
        VK10.nvkCmdBeginRenderPass(this, renderPassBegin.adr, contents.i)

fun VkCommandBuffer.bindDescriptorSets(pipelineBindPoint: VkPipelineBindPoint, layout: VkPipelineLayout, descriptorSet: VkDescriptorSet, dynamicOffsets: Int? = null) =
        vk.cmdBindDescriptorSets(this, pipelineBindPoint, layout, descriptorSet, dynamicOffsets)

fun VkCommandBuffer.bindIndexBuffer(buffer: VkBuffer, offset: VkDeviceSize, indexType: VkIndexType) =
        VK10.vkCmdBindIndexBuffer(this, buffer.L, offset.L, indexType.i)

fun VkCommandBuffer.bindPipeline(pipelineBindPoint: VkPipelineBindPoint, pipeline: VkPipeline) =
        VK10.vkCmdBindPipeline(this, pipelineBindPoint.i, pipeline.L)

infix fun VkCommandBuffer.bindVertexBuffers(buffer: VkBuffer) = bindVertexBuffers(0, buffer)

fun VkCommandBuffer.bindVertexBuffers(firstBinding: Int, buffer: VkBuffer) =
        stak {
            val pBuffer = nmemAlloc(Long.BYTES.L)
            memPutLong(pBuffer, buffer.L)
            val pOffset = nmemCalloc(Long.BYTES.L, 1)
            VK10.nvkCmdBindVertexBuffers(this, firstBinding, 1, pBuffer, pOffset)
        }

fun VkCommandBuffer.blitImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, region: VkImageBlit, filter: VkFilter) =
        VK10.nvkCmdBlitImage(this, srcImage.L, srcImageLayout.i, dstImage.L, dstImageLayout.i, 1, region.adr, filter.i)

fun VkCommandBuffer.copyBuffer(srcBuffer: VkBuffer, dstBuffer: VkBuffer, region: VkBufferCopy) =
        VK10.nvkCmdCopyBuffer(this, srcBuffer.L, dstBuffer.L, 1, region.adr)

fun VkCommandBuffer.copyBuffer(srcBuffer: VkBuffer, dstBuffer: VkBuffer, regions: VkBufferCopy.Buffer) =
        VK10.nvkCmdCopyBuffer(this, srcBuffer.L, dstBuffer.L, regions.remaining(), regions.adr)

fun VkCommandBuffer.copyBufferToImage(srcBuffer: VkBuffer, dstImage: VkImage, dstImageLayout: VkImageLayout, region: VkBufferImageCopy) =
        VK10.nvkCmdCopyBufferToImage(this, srcBuffer.L, dstImage.L, dstImageLayout.i, 1, region.adr)

fun VkCommandBuffer.copyBufferToImage(srcBuffer: VkBuffer, dstImage: VkImage, dstImageLayout: VkImageLayout, region: VkBufferImageCopy.Buffer) =
        VK10.nvkCmdCopyBufferToImage(this, srcBuffer.L, dstImage.L, dstImageLayout.i, region.remaining(), region.adr)

fun VkCommandBuffer.copyImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, region: VkImageCopy) =
        VK10.nvkCmdCopyImage(this, srcImage.L, srcImageLayout.i, dstImage.L, dstImageLayout.i, 1, region.adr)

infix fun VkCommandBuffer.debugMarkerBegin(markerInfo: VkDebugMarkerMarkerInfoEXT) =
        EXTDebugMarker.nvkCmdDebugMarkerBeginEXT(this, markerInfo.adr)

fun VkCommandBuffer.debugMarkerEnd() = EXTDebugMarker.vkCmdDebugMarkerEndEXT(this)

infix fun VkCommandBuffer.debugMarkerInsert(markerInfo: VkDebugMarkerMarkerInfoEXT) =
        EXTDebugMarker.nvkCmdDebugMarkerInsertEXT(this, markerInfo.adr)

fun VkCommandBuffer.dispatch(groupCountXY: Vec2i, groupCountZ: Int) =
        dispatch(groupCountXY.x, groupCountXY.y, groupCountZ)

fun VkCommandBuffer.dispatch(groupCountX: Int, groupCountY: Int, groupCountZ: Int) =
        VK10.vkCmdDispatch(this, groupCountX, groupCountY, groupCountZ)

fun VkCommandBuffer.draw(vertexCount: Int, instanceCount: Int, firstVertex: Int, firstInstance: Int) =
        VK10.vkCmdDraw(this, vertexCount, instanceCount, firstVertex, firstInstance)

fun VkCommandBuffer.drawIndexed(indexCount: Int, instanceCount: Int, firstIndex: Int, vertexOffset: Int, firstInstance: Int) =
        VK10.vkCmdDrawIndexed(this, indexCount, instanceCount, firstIndex, vertexOffset, firstInstance)

fun VkCommandBuffer.end() = VK_CHECK_RESULT(VK10.vkEndCommandBuffer(this))

fun VkCommandBuffer.end(queue: VkQueue, submitInfoPNext: Pointer? = null) {
    end()
    submit(queue, submitInfoPNext)
}

fun VkCommandBuffer.end(device: VkDevice, commandPool: VkCommandPool, queue: VkQueue, submitInfoPNext: Pointer? = null) {
    end(queue, submitInfoPNext)
    device.freeCommandBuffer(commandPool, this)
}

fun VkCommandBuffer.endRenderPass() = VK10.vkCmdEndRenderPass(this)

infix fun VkCommandBuffer.nextSubpass(contents: VkSubpassContents) = VK10.vkCmdNextSubpass(this, contents.i)

fun VkCommandBuffer.pipelineBarrier(srcStageMask: VkPipelineStage, dstStageMask: VkPipelineStage,
                                    dependencyFlags: VkDependencyFlags = 0,
                                    memoryBarrier: VkMemoryBarrier? = null,
                                    bufferMemoryBarrier: VkBufferMemoryBarrier? = null,
                                    imageMemoryBarrier: VkImageMemoryBarrier? = null) =
        pipelineBarrier(srcStageMask.i, dstStageMask.i, dependencyFlags, memoryBarrier, bufferMemoryBarrier, imageMemoryBarrier)

fun VkCommandBuffer.pipelineBarrier(srcStageMask: VkPipelineStageFlags, dstStageMask: VkPipelineStageFlags,
                                    dependencyFlags: VkDependencyFlags = 0,
                                    memoryBarrier: VkMemoryBarrier? = null,
                                    bufferMemoryBarrier: VkBufferMemoryBarrier? = null,
                                    imageMemoryBarrier: VkImageMemoryBarrier? = null) =
        VK10.nvkCmdPipelineBarrier(this, srcStageMask, dstStageMask, dependencyFlags,
                if (memoryBarrier != null) 1 else 0, memoryBarrier?.adr ?: NULL,
                if (bufferMemoryBarrier != null) 1 else 0, bufferMemoryBarrier?.adr ?: NULL,
                if (imageMemoryBarrier != null) 1 else 0, imageMemoryBarrier?.adr ?: NULL)

fun VkCommandBuffer.pushConstants(layout: VkPipelineLayout, stageFlags: VkShaderStageFlags, offset: Int, values: FloatBuffer) =
        VK10.nvkCmdPushConstants(this, layout.L, stageFlags, offset, values.size, memAddress(values))

fun VkCommandBuffer.pushConstants(layout: VkPipelineLayout, stageFlags: VkShaderStageFlags, offset: Int, values: ByteBuffer) =
        VK10.nvkCmdPushConstants(this, layout.L, stageFlags, offset, values.size, memAddress(values))

fun VkCommandBuffer.reset(flags: VkCommandBufferResetFlags) =
        VK_CHECK_RESULT(VK10.vkResetCommandBuffer(this, flags))

fun VkCommandBuffer.setDepthBias(depthBiasConstantFactor: Float, depthBiasClamp: Float, depthBiasSlopeFactor: Float) =
        VK10.vkCmdSetDepthBias(this, depthBiasConstantFactor, depthBiasClamp, depthBiasSlopeFactor)

infix fun VkCommandBuffer.setLineWidth(lineWidth: Float) = VK10.vkCmdSetLineWidth(this, lineWidth)

infix fun VkCommandBuffer.setScissor(size: Vec2i) = setScissor(size, Vec2i())

fun VkCommandBuffer.setScissor(size: Vec2i, offset: Vec2i) = setScissor(vk.Rect2D(size, offset))

infix fun VkCommandBuffer.setScissor(scissor: VkRect2D) =
        VK10.nvkCmdSetScissor(this, 0, 1, scissor.adr)

infix fun VkCommandBuffer.setScissor(scissors: VkRect2D.Buffer) =
        VK10.nvkCmdSetScissor(this, 0, scissors.remaining(), scissors.adr)

fun VkCommandBuffer.setScissor(firstScissor: Int, scissors: VkRect2D.Buffer) =
        VK10.nvkCmdSetScissor(this, firstScissor, scissors.remaining(), scissors.adr)

infix fun VkCommandBuffer.setViewport(size: Vec2i) = setViewport(size, 0f, 1f)

fun VkCommandBuffer.setViewport(size: Vec2i, minDepth: Float, maxDepth: Float) =
        setViewport(size.x.f, size.y.f, minDepth, maxDepth)

fun VkCommandBuffer.setViewport(width: Float, height: Float, minDepth: Float = 0f, maxDepth: Float = 1f) =
        setViewport(vk.Viewport {
            this.width = width
            this.height = height
            this.minDepth = minDepth
            this.maxDepth = maxDepth
        })

infix fun VkCommandBuffer.setViewport(viewport: VkViewport) =
        VK10.nvkCmdSetViewport(this, 0, 1, viewport.adr)

fun VkCommandBuffer.setViewport(firstViewport: Int, viewports: VkViewport.Buffer) =
        VK10.nvkCmdSetViewport(this, firstViewport, viewports.remaining(), viewports.adr)

fun VkCommandBuffer.submit(queue: VkQueue, submitInfoPNext: Pointer? = null) {
    queue submit vk.SubmitInfo {
        commandBuffer = this@submit
        submitInfoPNext?.let { next = it.adr }
    }
    queue.waitIdle()
}

//inline fun VkCommandBuffer.use(block: ()) {
//    VK10.nvkCmdSetViewport(this, firstViewport, viewports.remaining(), viewports.adr)
//}
//inline fun VkCommandBuffer.setBlendConstants(depthBiasConstantFactor: Float, depthBiasClamp: Float, depthBiasSlopeFactor: Float) {
//    VK10.setBlendConstants(this, depthBiasConstantFactor, depthBiasClamp, depthBiasSlopeFactor)
//}


/*
    VkDevice
 */

fun VkDevice.acquireNextImageKHR(swapchain: VkSwapchainKHR, timeout: Long, semaphore: VkSemaphore, fence: VkFence = VkFence(NULL)): Int =
        stak.intAddress { imageIndex ->
            VK_CHECK_RESULT(KHRSwapchain.nvkAcquireNextImageKHR(this, swapchain.L, timeout, semaphore.L, fence.L, imageIndex))
        }

infix fun VkDevice.allocateCommandBuffer(allocateInfo: VkCommandBufferAllocateInfo): VkCommandBuffer =
        stak {
            val pCmdBuffer = it.nmalloc(POINTER_SIZE)
            VK_CHECK_RESULT(VK10.nvkAllocateCommandBuffers(this, allocateInfo.adr, pCmdBuffer))
            VkCommandBuffer(memGetAddress(pCmdBuffer), this)
        }

infix fun VkDevice.allocateCommandBuffers(allocateInfo: VkCommandBufferAllocateInfo): ArrayList<VkCommandBuffer> = stak{
    val count = allocateInfo.commandBufferCount
    val pCommandBuffer = it.nmalloc(POINTER_SIZE, count)
    val commandBuffers = ArrayList<VkCommandBuffer>(count)
    VK_CHECK_RESULT(VK10.nvkAllocateCommandBuffers(this, allocateInfo.adr, pCommandBuffer))
    for (i in 0 until count)
        commandBuffers += VkCommandBuffer(memGetAddress(pCommandBuffer + POINTER_SIZE * i), this)
    return commandBuffers
}

infix fun VkDevice.allocateDescriptorSets(allocateInfo: VkDescriptorSetAllocateInfo): VkDescriptorSet =
        VkDescriptorSet(stak.longAddress { descriptorSets ->
            VK_CHECK_RESULT(VK10.nvkAllocateDescriptorSets(this, allocateInfo.adr, descriptorSets))
        })

infix fun VkDevice.allocateMemory(allocateInfo: VkMemoryAllocateInfo): VkDeviceMemory =
        VkDeviceMemory(stak.longAddress { memory ->
            VK_CHECK_RESULT(VK10.nvkAllocateMemory(this, allocateInfo.adr, NULL, memory))
        })

//inline fun VkDevice.allocateMemory(allocateInfo: VkMemoryAllocateInfo, memory: KMutableProperty0<VkDeviceMemory>) {
//    val pMemory = appBuffer.long
//    VK_CHECK_RESULT(VK10.nvkAllocateMemory(this, allocateInfo.adr, NULL, pMemory))
//    memory.set(memGetLong(pMemory))
//}

fun VkDevice.bindBufferMemory(buffer: VkBuffer, memory: VkDeviceMemory, memoryOffset: VkDeviceSize = VkDeviceSize(0)) =
        VK_CHECK_RESULT(VK10.vkBindBufferMemory(this, buffer.L, memory.L, memoryOffset.L))

fun VkDevice.bindImageMemory(image: VkImage, memory: VkDeviceMemory, memoryOffset: VkDeviceSize = VkDeviceSize(0)) =
        VK_CHECK_RESULT(VK10.vkBindImageMemory(this, image.L, memory.L, memoryOffset.L))

fun VkDevice.createBuffer(usage: VkBufferUsageFlags, size: VkDeviceSize): VkBuffer =
        createBuffer(vk.BufferCreateInfo {
            this.usage = usage
            this.size = size
        })

infix fun VkDevice.createBuffer(createInfo: VkBufferCreateInfo): VkBuffer =
        VkBuffer(stak.longAddress { buffer ->
            VK_CHECK_RESULT(VK10.nvkCreateBuffer(this, createInfo.adr, NULL, buffer))
        })

//inline fun VkDevice.createBuffer(createInfo: VkBufferCreateInfo, buffer: KMutableProperty0<VkBuffer>) {
//    val pBuffer = appBuffer.long
//    VK_CHECK_RESULT(VK10.nvkCreateBuffer(this, createInfo.adr, NULL, pBuffer))
//    buffer.set(memGetLong(pBuffer))
//}

infix fun VkDevice.createCommandPool(createInfo: VkCommandPoolCreateInfo): VkCommandPool =
        VkCommandPool(stak.longAddress { commandPool ->
            VK_CHECK_RESULT(VK10.nvkCreateCommandPool(this, createInfo.adr, NULL, commandPool))
        })

fun VkDevice.createComputePipelines(pipelineCache: VkPipelineCache, createInfo: VkComputePipelineCreateInfo): VkPipeline =
        VkPipeline(stak.longAddress { pipeline ->
            VK_CHECK_RESULT(VK10.nvkCreateComputePipelines(this, pipelineCache.L, 1, createInfo.adr, NULL, pipeline))
        })

infix fun VkDevice.createDescriptorPool(createInfo: VkDescriptorPoolCreateInfo): VkDescriptorPool =
        VkDescriptorPool(stak.longAddress { descriptorPool ->
            VK_CHECK_RESULT(VK10.nvkCreateDescriptorPool(this, createInfo.adr, NULL, descriptorPool))
        })

infix fun VkDevice.createDescriptorSetLayout(createInfo: VkDescriptorSetLayoutCreateInfo): VkDescriptorSetLayout =
        VkDescriptorSetLayout(stak.longAddress { setLayout ->
            VK10.nvkCreateDescriptorSetLayout(this, createInfo.adr, NULL, setLayout)
        })

infix fun VkDevice.createFence(flag: VkFenceCreate): VkFence =
        createFence(vk.FenceCreateInfo { this.flags = flag.i })

infix fun VkDevice.createFence(flags: VkFenceCreateFlags): VkFence =
        createFence(vk.FenceCreateInfo { this.flags = flags })

infix fun VkDevice.createFence(createInfo: VkFenceCreateInfo): VkFence =
        VkFence(stak.longAddress { fence ->
            VK_CHECK_RESULT(VK10.nvkCreateFence(this, createInfo.adr, NULL, fence))
        })

//inline fun VkDevice.createFences(createInfo: VkFenceCreateInfo, fences: ArrayList<VkFence>) {
//    val pFence = appBuffer.long
//    for (i in fences.indices) {
//        VK_CHECK_RESULT(VK10.nvkCreateFence(this, createInfo.adr, NULL, pFence))
//        fences[i] = memGetLong(pFence)
//    }
//}

infix fun VkDevice.createFramebuffer(createInfo: VkFramebufferCreateInfo): VkFramebuffer =
        VkFramebuffer(stak.longAddress { framebuffer ->
            VK_CHECK_RESULT(VK10.nvkCreateFramebuffer(this, createInfo.adr, NULL, framebuffer))
        })

fun VkDevice.createGraphicsPipelines(pipelineCache: VkPipelineCache, createInfo: VkGraphicsPipelineCreateInfo): VkPipeline =
        VkPipeline(stak.longAddress { pipelines ->
            VK_CHECK_RESULT(VK10.nvkCreateGraphicsPipelines(this, pipelineCache.L, 1, createInfo.adr, NULL, pipelines))
        })

infix fun VkDevice.createImage(createInfo: VkImageCreateInfo): VkImage =
        VkImage(stak.longAddress { image ->
            VK_CHECK_RESULT(VK10.nvkCreateImage(this, createInfo.adr, NULL, image))
        })

infix fun VkDevice.createImageView(createInfo: VkImageViewCreateInfo): VkImageView =
        VkImageView(stak.longAddress { view ->
            VK10.nvkCreateImageView(this, createInfo.adr, NULL, view)
        })

fun VkDevice.createPipeline(pipelineCache: VkPipelineCache, createInfo: VkGraphicsPipelineCreateInfo): VkPipeline =
        VkPipeline(stak.longAddress { pipeline ->
            VK_CHECK_RESULT(VK10.nvkCreateGraphicsPipelines(this, pipelineCache.L, 1, createInfo.adr, NULL, pipeline))
        })

infix fun VkDevice.createPipelineCache(createInfo: VkPipelineCacheCreateInfo): VkPipelineCache =
        VkPipelineCache(stak.longAddress { pipelineCache ->
            VK_CHECK_RESULT(VK10.nvkCreatePipelineCache(this, createInfo.adr, NULL, pipelineCache))
        })

infix fun VkDevice.createPipelineLayout(createInfo: VkPipelineLayoutCreateInfo): VkPipelineLayout =
        VkPipelineLayout(stak.longAddress { pipelineLayout ->
            VK_CHECK_RESULT(VK10.nvkCreatePipelineLayout(this, createInfo.adr, NULL, pipelineLayout))
        })

fun VkDevice.createQueryPool(createInfo: VkQueryPoolCreateInfo): VkQueryPool =
        VkQueryPool(stak.longAddress { queryPool ->
            VK_CHECK_RESULT(VK10.nvkCreateQueryPool(this, createInfo.adr, NULL, queryPool))
        })

infix fun VkDevice.createRenderPass(createInfo: VkRenderPassCreateInfo): VkRenderPass =
        VkRenderPass(stak.longAddress { renderPass ->
            VK_CHECK_RESULT(VK10.nvkCreateRenderPass(this, createInfo.adr, NULL, renderPass))
        })

infix fun VkDevice.createSampler(createInfo: VkSamplerCreateInfo): VkSampler =
        VkSampler(stak.longAddress { sampler ->
            VK_CHECK_RESULT(VK10.nvkCreateSampler(this, createInfo.adr, NULL, sampler))
        })

infix fun VkDevice.createSemaphore(createInfo: VkSemaphoreCreateInfo): VkSemaphore =
        VkSemaphore(stak.longAddress { semaphore ->
            VK_CHECK_RESULT(VK10.nvkCreateSemaphore(this, createInfo.adr, NULL, semaphore))
        })

infix fun VkDevice.createShaderModule(createInfo: VkShaderModuleCreateInfo): VkShaderModule =
        VkShaderModule(stak.longAddress { shaderModule ->
            VK_CHECK_RESULT(VK10.nvkCreateShaderModule(this, createInfo.adr, NULL, shaderModule))
        })

infix fun VkDevice.createSwapchainKHR(createInfo: VkSwapchainCreateInfoKHR): VkSwapchainKHR =
        VkSwapchainKHR(stak.longAddress { swapchain ->
            KHRSwapchain.nvkCreateSwapchainKHR(this, createInfo.adr, NULL, swapchain)
        })

infix fun VkDevice.debugMarkerSetObjectName(nameInfo: VkDebugMarkerObjectNameInfoEXT) =
        EXTDebugMarker.nvkDebugMarkerSetObjectNameEXT(this, nameInfo.adr)

infix fun VkDevice.debugMarkerSetObjectTag(tagInfo: VkDebugMarkerObjectTagInfoEXT) =
        EXTDebugMarker.nvkDebugMarkerSetObjectTagEXT(this, tagInfo.adr)

infix fun VkDevice.destroyBuffer(buffer: VkBuffer) = VK10.nvkDestroyBuffer(this, buffer.L, NULL)

infix fun VkDevice.destroyCommandPool(commandPool: VkCommandPool) =
        VK10.nvkDestroyCommandPool(this, commandPool.L, NULL)

infix fun VkDevice.destroyDescriptorPool(descriptorPool: VkDescriptorPool) =
        VK10.nvkDestroyDescriptorPool(this, descriptorPool.L, NULL)

infix fun VkDevice.destroyDescriptorSetLayout(descriptorSetLayout: VkDescriptorSetLayout) =
        VK10.nvkDestroyDescriptorSetLayout(this, descriptorSetLayout.L, NULL)

infix fun VkDevice.destroyFence(fence: VkFence) = VK10.nvkDestroyFence(this, fence.L, NULL)

infix fun VkDevice.destroyFences(fences: ArrayList<VkFence>) {
    for (fence in fences)
        VK10.nvkDestroyFence(this, fence.L, NULL)
}

infix fun VkDevice.destroyFences(fences: VkFenceArray) {
    for (fence in fences)
        VK10.nvkDestroyFence(this, fence.L, NULL)
}

infix fun VkDevice.destroyFramebuffer(framebuffer: VkFramebuffer) =
        VK10.nvkDestroyFramebuffer(this, framebuffer.L, NULL)

infix fun VkDevice.destroyFramebuffers(framebuffers: Iterable<VkFramebuffer>) {
    for (i in framebuffers)
        VK10.nvkDestroyFramebuffer(this, i.L, NULL)
}

infix fun VkDevice.destroyImage(image: VkImage) = VK10.nvkDestroyImage(this, image.L, NULL)

infix fun VkDevice.destroyImageView(imageView: VkImageView) = VK10.nvkDestroyImageView(this, imageView.L, NULL)

infix fun VkDevice.destroyPipeline(pipeline: VkPipeline) = VK10.nvkDestroyPipeline(this, pipeline.L, NULL)

infix fun VkDevice.destroyPipelineCache(pipelineCache: VkPipelineCache) =
        VK10.nvkDestroyPipelineCache(this, pipelineCache.L, NULL)

infix fun VkDevice.destroyPipelineLayout(pipelineLayout: VkPipelineLayout) =
        VK10.nvkDestroyPipelineLayout(this, pipelineLayout.L, NULL)

fun VkDevice.destroyQueryPool(queryPool: VkQueryPool) = VK10.nvkDestroyQueryPool(this, queryPool.L, NULL)

infix fun VkDevice.destroyRenderPass(renderPass: VkRenderPass) =
        VK10.nvkDestroyRenderPass(this, renderPass.L, NULL)

infix fun VkDevice.destroySampler(sampler: VkSampler) = VK10.nvkDestroySampler(this, sampler.L, NULL)

infix fun VkDevice.destroySemaphore(semaphore: VkSemaphore) = VK10.nvkDestroySemaphore(this, semaphore.L, NULL)

//inline fun VkDevice.destroySemaphores(vararg semaphores: VkSemaphore) {
//    for (semaphore in semaphores)
//        VK10.nvkDestroySemaphore(this, semaphore, NULL)
//}

fun VkDevice.destroySemaphores(semaphore0: VkSemaphore, semaphore1: VkSemaphore) {
    VK10.nvkDestroySemaphore(this, semaphore0.L, NULL)
    VK10.nvkDestroySemaphore(this, semaphore1.L, NULL)
}

fun VkDevice.destroySemaphores(semaphore0: VkSemaphore, semaphore1: VkSemaphore, semaphore2: VkSemaphore) {
    VK10.nvkDestroySemaphore(this, semaphore0.L, NULL)
    VK10.nvkDestroySemaphore(this, semaphore1.L, NULL)
    VK10.nvkDestroySemaphore(this, semaphore2.L, NULL)
}

fun VkDevice.destroy() = VK10.nvkDestroyDevice(this, NULL)

infix fun VkDevice.destroyShaderModule(shaderModule: VkShaderModule) =
        VK10.nvkDestroyShaderModule(this, shaderModule.L, NULL)

infix fun VkDevice.destroyShaderModules(infos: VkPipelineShaderStageCreateInfo.Buffer) {
    for (i in infos)
        VK10.nvkDestroyShaderModule(this, i.module.L, NULL)
}

infix fun VkDevice.destroyShaderModules(modules: Iterable<VkShaderModule>) {
    for (i in modules)
        VK10.nvkDestroyShaderModule(this, i.L, NULL)
}

infix fun VkDevice.destroySwapchainKHR(swapchain: VkSwapchainKHR) =
        KHRSwapchain.nvkDestroySwapchainKHR(this, swapchain.L, NULL)

fun VkDevice.freeCommandBuffers(commandPool: VkCommandPool, commandBuffers: ArrayList<VkCommandBuffer>) =
        vk.freeCommandBuffers(this, commandPool, commandBuffers)

infix fun VkDevice.flushMappedMemoryRanges(memoryRange: VkMappedMemoryRange) =
        VK_CHECK_RESULT(VK10.nvkFlushMappedMemoryRanges(this, 1, memoryRange.adr))

infix fun VkDevice.flushMappedMemoryRanges(memoryRanges: VkMappedMemoryRange.Buffer) =
        VK_CHECK_RESULT(VK10.nvkFlushMappedMemoryRanges(this, memoryRanges.capacity(), memoryRanges.adr))

fun VkDevice.freeCommandBuffer(commandPool: VkCommandPool, commandBuffer: VkCommandBuffer): Ptr =
        stak.pointerAddress { pCommandBuffer ->
            memPutAddress(pCommandBuffer, commandBuffer.adr)
            VK10.nvkFreeCommandBuffers(this, commandPool.L, 1, pCommandBuffer)
        }

infix fun VkDevice.freeMemory(memory: VkDeviceMemory) = VK10.nvkFreeMemory(this, memory.L, NULL)

infix fun VkDevice.getBufferMemoryRequirements(buffer: VkBuffer): VkMemoryRequirements =
        getBufferMemoryRequirements(buffer, vk.MemoryRequirements())

fun VkDevice.getBufferMemoryRequirements(buffer: VkBuffer, memoryRequirements: VkMemoryRequirements): VkMemoryRequirements {
    VK10.nvkGetBufferMemoryRequirements(this, buffer.L, memoryRequirements.adr)
    return memoryRequirements
}

infix fun VkDevice.getCommandBuffer(commandPool: VkCommandPool): VkCommandBuffer =
        getCommandBuffer(commandPool, VkCommandBufferLevel.PRIMARY)

fun VkDevice.getCommandBuffer(commandPool: VkCommandPool, level: VkCommandBufferLevel = VkCommandBufferLevel.PRIMARY, autostart: Boolean = false): VkCommandBuffer {
    val cmdBufAllocateInfo = vk.CommandBufferAllocateInfo(commandPool, level, 1)
    return allocateCommandBuffer(cmdBufAllocateInfo).apply { if (autostart) begin() }
}

infix fun VkDevice.getImageMemoryRequirements(image: VkImage): VkMemoryRequirements =
        getImageMemoryRequirements(image, vk.MemoryRequirements())

fun VkDevice.getImageMemoryRequirements(image: VkImage, memoryRequirements: VkMemoryRequirements): VkMemoryRequirements {
    VK10.nvkGetImageMemoryRequirements(this, image.L, memoryRequirements.adr)
    return memoryRequirements
}

fun VkDevice.getImageSubresourceLayout(image: VkImage, subresource: VkImageSubresource): VkSubresourceLayout =
        vk.SubresourceLayout().also { VK10.nvkGetImageSubresourceLayout(this, image.L, subresource.adr, it.adr) }

fun VkDevice.getImageSubresourceLayout(image: VkImage, subresource: VkImageSubresource, layout: VkSubresourceLayout): VkSubresourceLayout {
    VK10.nvkGetImageSubresourceLayout(this, image.L, subresource.adr, layout.adr)
    return layout
}

// TODO mappedMemory?
inline fun VkDevice.mappingMemory(memory: VkDeviceMemory, offset: VkDeviceSize, size: VkDeviceSize, flags: VkMemoryMapFlags = 0, block: (Ptr) -> Unit) =
        stak.pointerAddress { data ->
            VK_CHECK_RESULT(VK10.nvkMapMemory(this, memory.L, offset.L, size.L, flags, data))
            block(memGetAddress(data))
            VK10.vkUnmapMemory(this, memory.L)
        }

fun VkDevice.mapMemory(memory: VkDeviceMemory, offset: VkDeviceSize, size: VkDeviceSize, flags: VkMemoryMapFlags = 0): Ptr =
        stak.pointerAddress { data ->
            VK_CHECK_RESULT(VK10.nvkMapMemory(this, memory.L, offset.L, size.L, flags, data))
            memGetAddress(data)
        }

fun VkDevice.mapMemory(memory: VkDeviceMemory, offset: VkDeviceSize, size: VkDeviceSize, flags: VkMemoryMapFlags, data: PointerBuffer) =
        VK_CHECK_RESULT(VK10.nvkMapMemory(this, memory.L, offset.L, size.L, flags, data.adr))

infix fun VkDevice.getQueue(queueFamilyIndex: Int): VkQueue =
        getQueue(queueFamilyIndex, 0)

fun VkDevice.getQueue(queueFamilyIndex: Int, queueIndex: Int): VkQueue =
        VkQueue(
                stak.pointerAddress { queue ->
                    VK10.nvkGetDeviceQueue(this, queueFamilyIndex, queueIndex, queue)
                }, this)

infix fun VkDevice.getSwapchainImagesKHR(swapchain: VkSwapchainKHR): VkImageArray =
        vk.getSwapchainImagesKHR(this, swapchain)

infix fun VkDevice.resetCommandPool(commandPool: VkCommandPool) = resetCommandPool(commandPool, 0)

fun VkDevice.resetCommandPool(commandPool: VkCommandPool, flags: VkCommandPoolResetFlags) =
        VK_CHECK_RESULT(VK10.vkResetCommandPool(this, commandPool.L, flags))

infix fun VkDevice.resetFence(fence: VkFence) {
    stak.longAddress(fence.L) { pFence ->
        VK10.nvkResetFences(this, 1, pFence)
    }
}

infix fun VkDevice.unmapMemory(memory: VkDeviceMemory) = VK10.vkUnmapMemory(this, memory.L)

infix fun VkDevice.updateDescriptorSets(descriptorWrites: VkWriteDescriptorSet) =
        VK10.nvkUpdateDescriptorSets(this, 1, descriptorWrites.adr, 0, NULL)

infix fun VkDevice.updateDescriptorSets(descriptorWrites: VkWriteDescriptorSet.Buffer) =
        VK10.nvkUpdateDescriptorSets(this, descriptorWrites.remaining(), descriptorWrites.adr, 0, NULL)

//inline fun VkDevice.updateDescriptorSets(descriptorWrites: VkWriteDescriptorSet.Buffer,
//                                descriptorCopies: VkCopyDescriptorSet.Buffer? = null) {
//    VK10.nvkUpdateDescriptorSets(device, descriptorWrites.remaining(), descriptorWrites.adr,
//            descriptorCopies?.remaining() ?: 0, descriptorCopies?.adr ?: NULL)
//}

fun VkDevice.waitForFence(fence: VkFence, waitAll: Boolean, timeout: Long) {
    stak.longAddress(fence.L) { pFence ->
        VK_CHECK_RESULT(VK10.nvkWaitForFences(this, 1, pFence, waitAll.i, timeout))
    }
}

fun VkDevice.waitIdle() = VK_CHECK_RESULT(VK10.vkDeviceWaitIdle(this))

inline fun VkDevice.withFence(flags: VkFenceCreateFlags = 0, block: (VkFence) -> Unit) {
    val fence = createFence(flags)
    block(fence)
    destroyFence(fence)
}


/*
    VkInstance
 */

infix fun VkInstance.createDebugReportCallbackEXT(createInfo: VkDebugReportCallbackCreateInfoEXT): VkDebugReportCallback =
        VkDebugReportCallback(stak.longAddress { callback ->
            VK_CHECK_RESULT(EXTDebugReport.nvkCreateDebugReportCallbackEXT(this, createInfo.adr, NULL, callback))
            callback
        })

fun VkInstance.destroy() = VK10.nvkDestroyInstance(this, NULL)

infix fun VkInstance.destroyDebugReportCallbackEXT(debugReportCallback: VkDebugReportCallback) {
    EXTDebugReport.nvkDestroyDebugReportCallbackEXT(this, debugReportCallback.L, NULL)
}

fun VkInstance.enumeratePhysicalDevices(): ArrayList<VkPhysicalDevice> {
    return vk.enumeratePhysicalDevices(this)
}

infix fun VkInstance.destroySurfaceKHR(surface: VkSurface) {
    KHRSurface.nvkDestroySurfaceKHR(this, surface.L, NULL)
}


/*
    VkPhysicalDevice
 */

inline val VkPhysicalDevice.features: VkPhysicalDeviceFeatures
    get() = vk.PhysicalDeviceFeatures().also(::getFeatures)

infix fun VkPhysicalDevice.getFeatures(features: VkPhysicalDeviceFeatures) =
        VK10.nvkGetPhysicalDeviceFeatures(this, features.adr)

infix fun VkPhysicalDevice.getFormatProperties(format: VkFormat): VkFormatProperties =
        getFormatProperties(format, vk.FormatProperties())

fun VkPhysicalDevice.getFormatProperties(format: VkFormat, formatProperties: VkFormatProperties): VkFormatProperties {
    VK10.nvkGetPhysicalDeviceFormatProperties(this, format.i, formatProperties.adr)
    return formatProperties
}

infix fun VkPhysicalDevice.getSurfaceFormatsKHR(surface: VkSurface): ArrayList<VkSurfaceFormatKHR> =
        vk.getPhysicalDeviceSurfaceFormatsKHR(this, surface)

inline val VkPhysicalDevice.memoryProperties: VkPhysicalDeviceMemoryProperties
    get() = vk.PhysicalDeviceMemoryProperties().also(::getMemoryProperties)

infix fun VkPhysicalDevice.getMemoryProperties(memoryProperties: VkPhysicalDeviceMemoryProperties) =
        VK10.nvkGetPhysicalDeviceMemoryProperties(this, memoryProperties.adr)

inline val VkPhysicalDevice.queueFamilyProperties: ArrayList<VkQueueFamilyProperties>
    get() = vk.getPhysicalDeviceQueueFamilyProperties(this)

inline val VkPhysicalDevice.properties: VkPhysicalDeviceProperties
    get() = vk.PhysicalDeviceProperties().also(::getProperties)

infix fun VkPhysicalDevice.getProperties(properties: VkPhysicalDeviceProperties) =
        VK10.nvkGetPhysicalDeviceProperties(this, properties.adr)

infix fun VkPhysicalDevice.createDevice(createInfo: VkDeviceCreateInfo): VkDevice =
        stak {
            val pDevice = it.nmalloc(POINTER_SIZE, POINTER_SIZE)
            VK_CHECK_RESULT(VK10.nvkCreateDevice(this, createInfo.adr, NULL, pDevice))
            VkDevice(memGetLong(pDevice), this, createInfo)
        }

infix fun VkPhysicalDevice.getSurfaceCapabilitiesKHR(surface: VkSurface): VkSurfaceCapabilitiesKHR =
        vk.SurfaceCapabilitiesKHR {
            VK_CHECK_RESULT(KHRSurface.nvkGetPhysicalDeviceSurfaceCapabilitiesKHR(this@getSurfaceCapabilitiesKHR, surface.L, adr))
        }

fun VkPhysicalDevice.getSurfaceSupportKHR(queueFamily: Int, surface: VkSurface): Boolean =
        vk.getPhysicalDeviceSurfaceSupportKHR(this, queueFamily, surface)

fun VkPhysicalDevice.getSurfaceSupportKHR(queueFamilyProperties: ArrayList<VkQueueFamilyProperties>, surface: VkSurface): BooleanArray =
        vk.getPhysicalDeviceSurfaceSupportKHR(this, queueFamilyProperties, surface)

infix fun VkPhysicalDevice.getSurfacePresentModesKHR(surface: VkSurface): ArrayList<VkPresentMode> =
        vk.getPhysicalDeviceSurfacePresentModesKHR(this, surface)


/*
    VkQueue
 */

infix fun VkQueue.presentKHR(presentInfo: VkPresentInfoKHR) =
        VK_CHECK_RESULT(KHRSwapchain.vkQueuePresentKHR(this, presentInfo))

infix fun VkQueue.submit(submits: VkSubmitInfo) =
        VK_CHECK_RESULT(VK10.nvkQueueSubmit(this, 1, submits.adr, NULL))

fun VkQueue.submit(submits: VkSubmitInfo, fence: VkFence) =
        VK_CHECK_RESULT(VK10.nvkQueueSubmit(this, 1, submits.adr, fence.L))

fun VkQueue.waitIdle() = VK_CHECK_RESULT(VK10.vkQueueWaitIdle(this))


/*
    Invokes (~set)
 */


operator fun VkDescriptorPoolSize.invoke(type: VkDescriptorType, descriptorCount: Int): VkDescriptorPoolSize {
    this.type = type
    this.descriptorCount = descriptorCount
    return this
}

operator fun VkDescriptorSetLayoutBinding.invoke(
        binding: Int,
        type: VkDescriptorType,
        descriptorCount: Int = 1,
        stageFlags: VkShaderStageFlags): VkDescriptorSetLayoutBinding {
    this.binding = binding
    this.descriptorType = type
    this.descriptorCount = descriptorCount
    this.stageFlags = stageFlags
    return this
}


operator fun VkVertexInputAttributeDescription.invoke(location: Int, binding: Int, format: VkFormat, offset: Int): VkVertexInputAttributeDescription {
    this.location = location
    this.binding = binding
    this.format = format
    this.offset = offset
    return this
}

operator fun VkVertexInputBindingDescription.invoke(binding: Int, stride: Int, inputRate: VkVertexInputRate): VkVertexInputBindingDescription {
    this.binding = binding
    this.stride = stride
    this.inputRate = inputRate
    return this
}


operator fun VkWriteDescriptorSet.invoke(dstSet: VkDescriptorSet, descriptorType: VkDescriptorType, dstBinding: Int,
                                         bufferInfo: VkDescriptorBufferInfo): VkWriteDescriptorSet {
    this.dstSet = dstSet
    this.dstBinding = dstBinding
    this.descriptorType = descriptorType
    this.bufferInfo_ = bufferInfo
    return this
}

operator fun VkWriteDescriptorSet.invoke(dstSet: VkDescriptorSet, descriptorType: VkDescriptorType, dstBinding: Int,
                                         imageInfo: VkDescriptorImageInfo): VkWriteDescriptorSet {
    this.dstSet = dstSet
    this.dstBinding = dstBinding
    this.descriptorType = descriptorType
    this.imageInfo_ = imageInfo
    return this
}
