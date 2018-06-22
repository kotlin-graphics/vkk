package vkk

import glm_.f
import glm_.i
import glm_.size
import glm_.vec2.Vec2i
import org.lwjgl.PointerBuffer
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.system.Pointer
import org.lwjgl.vulkan.*
import java.nio.ByteBuffer
import java.nio.FloatBuffer
import kotlin.reflect.KMutableProperty0
import ab.advance
import ab.appBuffer
import ab.appBuffer.ptr


/*
    VkCommandBuffer
 */

inline infix fun VkCommandBuffer.begin(beginInfo: VkCommandBufferBeginInfo) {
    VK_CHECK_RESULT(VK10.nvkBeginCommandBuffer(this, beginInfo.adr))
}

inline fun VkCommandBuffer.begin(flags: VkCommandBufferUsageFlags = VkCommandBufferUsage.SIMULTANEOUS_USE_BIT.i) {
    begin(vk.CommandBufferBeginInfo { this.flags = flags })
}

inline fun VkCommandBuffer.beginRenderPass(renderPassBegin: VkRenderPassBeginInfo, contents: VkSubpassContents) {
    VK10.nvkCmdBeginRenderPass(this, renderPassBegin.adr, contents.i)
}

inline fun VkCommandBuffer.bindDescriptorSets(pipelineBindPoint: VkPipelineBindPoint, layout: VkPipelineLayout,
                                              descriptorSet: VkDescriptorSet, dynamicOffsets: Int? = null) {
    vk.cmdBindDescriptorSets(this, pipelineBindPoint, layout, descriptorSet, dynamicOffsets)
}

inline fun VkCommandBuffer.bindIndexBuffer(buffer: VkBuffer, offset: VkDeviceSize, indexType: VkIndexType) {
    VK10.vkCmdBindIndexBuffer(this, buffer, offset, indexType.i)
}

inline fun VkCommandBuffer.bindPipeline(pipelineBindPoint: VkPipelineBindPoint, pipeline: VkPipeline) {
    VK10.vkCmdBindPipeline(this, pipelineBindPoint.i, pipeline)
}

inline infix fun VkCommandBuffer.bindVertexBuffers(buffer: VkBuffer) {
    bindVertexBuffers(0, buffer)
}

inline fun VkCommandBuffer.bindVertexBuffers(firstBinding: Int, buffer: VkBuffer) {
    val pBuffer = appBuffer.long
    memPutLong(pBuffer, buffer)
    val pOffset = appBuffer.long
//    memPutLong(pOffset, 0L) // TODO remove since calloc?
    VK10.nvkCmdBindVertexBuffers(this, firstBinding, 1, pBuffer, pOffset)
}

inline fun VkCommandBuffer.blitImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, region: VkImageBlit, filter: VkFilter) {
    VK10.nvkCmdBlitImage(this, srcImage, srcImageLayout.i, dstImage, dstImageLayout.i, 1, region.adr, filter.i)
}

inline fun VkCommandBuffer.copyBuffer(srcBuffer: VkBuffer, dstBuffer: VkBuffer, region: VkBufferCopy) {
    VK10.nvkCmdCopyBuffer(this, srcBuffer, dstBuffer, 1, region.adr)
}

inline fun VkCommandBuffer.copyBuffer(srcBuffer: VkBuffer, dstBuffer: VkBuffer, regions: VkBufferCopy.Buffer) {
    VK10.nvkCmdCopyBuffer(this, srcBuffer, dstBuffer, regions.remaining(), regions.adr)
}

inline fun VkCommandBuffer.copyBufferToImage(srcBuffer: VkBuffer, dstImage: VkImage, dstImageLayout: VkImageLayout,
                                             region: VkBufferImageCopy) {
    VK10.nvkCmdCopyBufferToImage(this, srcBuffer, dstImage, dstImageLayout.i, 1, region.adr)
}

inline fun VkCommandBuffer.copyBufferToImage(srcBuffer: VkBuffer, dstImage: VkImage, dstImageLayout: VkImageLayout,
                                             region: VkBufferImageCopy.Buffer) {
    VK10.nvkCmdCopyBufferToImage(this, srcBuffer, dstImage, dstImageLayout.i, region.remaining(), region.adr)
}

inline fun VkCommandBuffer.copyImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, region: VkImageCopy) {
    VK10.nvkCmdCopyImage(this, srcImage, srcImageLayout.i, dstImage, dstImageLayout.i, 1, region.adr)
}

inline infix fun VkCommandBuffer.debugMarkerBegin(markerInfo: VkDebugMarkerMarkerInfoEXT) {
    EXTDebugMarker.nvkCmdDebugMarkerBeginEXT(this, markerInfo.adr)
}

inline fun VkCommandBuffer.debugMarkerEnd() {
    EXTDebugMarker.vkCmdDebugMarkerEndEXT(this)
}

inline infix fun VkCommandBuffer.debugMarkerInsert(markerInfo: VkDebugMarkerMarkerInfoEXT) {
    EXTDebugMarker.nvkCmdDebugMarkerInsertEXT(this, markerInfo.adr)
}

inline fun VkCommandBuffer.dispatch(groupCountXY: Vec2i, groupCountZ: Int) {
    dispatch(groupCountXY.x, groupCountXY.y, groupCountZ)
}

inline fun VkCommandBuffer.dispatch(groupCountX: Int, groupCountY: Int, groupCountZ: Int) {
    VK10.vkCmdDispatch(this, groupCountX, groupCountY, groupCountZ)
}

inline fun VkCommandBuffer.draw(vertexCount: Int, instanceCount: Int, firstVertex: Int, firstInstance: Int) {
    VK10.vkCmdDraw(this, vertexCount, instanceCount, firstVertex, firstInstance)
}

inline fun VkCommandBuffer.drawIndexed(indexCount: Int, instanceCount: Int, firstIndex: Int, vertexOffset: Int, firstInstance: Int) {
    VK10.vkCmdDrawIndexed(this, indexCount, instanceCount, firstIndex, vertexOffset, firstInstance)
}

inline fun VkCommandBuffer.end() {
    VK_CHECK_RESULT(VK10.vkEndCommandBuffer(this))
}

inline fun VkCommandBuffer.end(queue: VkQueue, submitInfoPNext: Pointer? = null) {
    end()
    submit(queue, submitInfoPNext)
}

inline fun VkCommandBuffer.end(device: VkDevice, commandPool: VkCommandPool, queue: VkQueue, submitInfoPNext: Pointer? = null) {
    end(queue, submitInfoPNext)
    device.freeCommandBuffer(commandPool, this)
}

inline fun VkCommandBuffer.endRenderPass() {
    VK10.vkCmdEndRenderPass(this)
}

inline infix fun VkCommandBuffer.nextSubpass(contents: VkSubpassContents) {
    VK10.vkCmdNextSubpass(this, contents.i)
}

inline fun VkCommandBuffer.pipelineBarrier(srcStageMask: VkPipelineStageFlags, dstStageMask: VkPipelineStageFlags,
                                           dependencyFlags: VkDependencyFlags = 0,
                                           memoryBarrier: VkMemoryBarrier? = null,
                                           bufferMemoryBarrier: VkBufferMemoryBarrier? = null,
                                           imageMemoryBarrier: VkImageMemoryBarrier? = null) {
    VK10.nvkCmdPipelineBarrier(this, srcStageMask, dstStageMask, dependencyFlags,
            if (memoryBarrier != null) 1 else 0, memoryBarrier?.adr ?: NULL,
            if (bufferMemoryBarrier != null) 1 else 0, bufferMemoryBarrier?.adr ?: NULL,
            if (imageMemoryBarrier != null) 1 else 0, imageMemoryBarrier?.adr ?: NULL)
}

inline fun VkCommandBuffer.pushConstants(layout: VkPipelineLayout, stageFlags: VkShaderStageFlags, offset: Int, values: FloatBuffer) {
    VK10.nvkCmdPushConstants(this, layout, stageFlags, offset, values.size, memAddress(values))
}

inline fun VkCommandBuffer.pushConstants(layout: VkPipelineLayout, stageFlags: VkShaderStageFlags, offset: Int, values: ByteBuffer) {
    VK10.nvkCmdPushConstants(this, layout, stageFlags, offset, values.size, memAddress(values))
}

inline fun VkCommandBuffer.reset(flags: VkCommandBufferResetFlags) {
    VK_CHECK_RESULT(VK10.vkResetCommandBuffer(this, flags))
}

inline fun VkCommandBuffer.setDepthBias(depthBiasConstantFactor: Float, depthBiasClamp: Float, depthBiasSlopeFactor: Float) {
    VK10.vkCmdSetDepthBias(this, depthBiasConstantFactor, depthBiasClamp, depthBiasSlopeFactor)
}

inline infix fun VkCommandBuffer.setLineWidth(lineWidth: Float) {
    VK10.vkCmdSetLineWidth(this, lineWidth)
}

inline infix fun VkCommandBuffer.setScissor(size: Vec2i) {
    setScissor(size, Vec2i())
}

inline fun VkCommandBuffer.setScissor(size: Vec2i, offset: Vec2i) {
    setScissor(vk.Rect2D(size, offset))
}

inline infix fun VkCommandBuffer.setScissor(scissor: VkRect2D) {
    VK10.nvkCmdSetScissor(this, 0, 1, scissor.adr)
}

inline infix fun VkCommandBuffer.setScissor(scissors: VkRect2D.Buffer) {
    VK10.nvkCmdSetScissor(this, 0, scissors.remaining(), scissors.adr)
}

inline fun VkCommandBuffer.setScissor(firstScissor: Int, scissors: VkRect2D.Buffer) {
    VK10.nvkCmdSetScissor(this, firstScissor, scissors.remaining(), scissors.adr)
}

inline infix fun VkCommandBuffer.setViewport(size: Vec2i) {
    setViewport(size, 0f, 1f)
}

inline fun VkCommandBuffer.setViewport(size: Vec2i, minDepth: Float, maxDepth: Float) {
    setViewport(size.x.f, size.y.f, minDepth, maxDepth)
}

inline fun VkCommandBuffer.setViewport(width: Float, height: Float, minDepth: Float = 0f, maxDepth: Float = 1f) {
    setViewport(vk.Viewport {
        this.width = width
        this.height = height
        this.minDepth = minDepth
        this.maxDepth = maxDepth
    })
}

inline infix fun VkCommandBuffer.setViewport(viewport: VkViewport) {
    VK10.nvkCmdSetViewport(this, 0, 1, viewport.adr)
}

inline fun VkCommandBuffer.setViewport(firstViewport: Int, viewports: VkViewport.Buffer) {
    VK10.nvkCmdSetViewport(this, firstViewport, viewports.remaining(), viewports.adr)
}

inline fun VkCommandBuffer.submit(queue: VkQueue, submitInfoPNext: Pointer? = null) {
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

inline fun VkDevice.acquireNextImageKHR(swapchain: VkSwapchainKHR, timeout: Long, semaphore: VkSemaphore, fence: VkFence): Int {
    val pImageIndex = appBuffer.int
    VK_CHECK_RESULT(KHRSwapchain.nvkAcquireNextImageKHR(this, swapchain, timeout, semaphore, fence, pImageIndex))
    return memGetInt(pImageIndex)
}

inline infix fun VkDevice.allocateCommandBuffer(allocateInfo: VkCommandBufferAllocateInfo): VkCommandBuffer {
    val pCmdBuffer = appBuffer.pointer
    VK_CHECK_RESULT(VK10.nvkAllocateCommandBuffers(this, allocateInfo.adr, pCmdBuffer))
    return VkCommandBuffer(memGetAddress(pCmdBuffer), this)
}

inline infix fun VkDevice.allocateCommandBuffers(allocateInfo: VkCommandBufferAllocateInfo): ArrayList<VkCommandBuffer> {
    val count = allocateInfo.commandBufferCount
    val pCommandBuffer = appBuffer.pointerArray(count)
    val commandBuffers = ArrayList<VkCommandBuffer>(count)
    VK_CHECK_RESULT(VK10.nvkAllocateCommandBuffers(this, allocateInfo.adr, pCommandBuffer))
    for (i in 0 until count)
        commandBuffers += VkCommandBuffer(memGetAddress(pCommandBuffer + Pointer.POINTER_SIZE * i), this)
    return commandBuffers
}

inline infix fun VkDevice.allocateDescriptorSets(allocateInfo: VkDescriptorSetAllocateInfo): VkDescriptorSet {
    val pDescriptorSets = appBuffer.long
    VK_CHECK_RESULT(VK10.nvkAllocateDescriptorSets(this, allocateInfo.adr, pDescriptorSets))
    return memGetLong(pDescriptorSets)
}

inline infix fun VkDevice.allocateMemory(allocateInfo: VkMemoryAllocateInfo): VkDeviceMemory {
    val pMemory = appBuffer.long
    VK_CHECK_RESULT(VK10.nvkAllocateMemory(this, allocateInfo.adr, NULL, pMemory))
    return memGetLong(pMemory)
}

inline fun VkDevice.allocateMemory(allocateInfo: VkMemoryAllocateInfo, memory: KMutableProperty0<VkDeviceMemory>) {
    val pMemory = appBuffer.long
    VK_CHECK_RESULT(VK10.nvkAllocateMemory(this, allocateInfo.adr, NULL, pMemory))
    memory.set(memGetLong(pMemory))
}

inline fun VkDevice.bindBufferMemory(buffer: VkBuffer, memory: VkDeviceMemory, memoryOffset: VkDeviceSize = 0) { // TODO clean code?
    VK_CHECK_RESULT(VK10.vkBindBufferMemory(this, buffer, memory, memoryOffset))
}

inline fun VkDevice.bindImageMemory(image: VkImage, memory: VkDeviceMemory, memoryOffset: VkDeviceSize = 0L) {
    VK_CHECK_RESULT(VK10.vkBindImageMemory(this, image, memory, memoryOffset))
}

inline fun VkDevice.createBuffer(usage: VkBufferUsageFlags, size: VkDeviceSize): VkBuffer {
    return createBuffer(vk.BufferCreateInfo {
        this.usage = usage
        this.size = size
    })
}

inline infix fun VkDevice.createBuffer(createInfo: VkBufferCreateInfo): VkBuffer {
    val pBuffer = appBuffer.long
    VK_CHECK_RESULT(VK10.nvkCreateBuffer(this, createInfo.adr, NULL, pBuffer))
    return memGetLong(pBuffer)
}

inline fun VkDevice.createBuffer(createInfo: VkBufferCreateInfo, buffer: KMutableProperty0<VkBuffer>) {
    val pBuffer = appBuffer.long
    VK_CHECK_RESULT(VK10.nvkCreateBuffer(this, createInfo.adr, NULL, pBuffer))
    buffer.set(memGetLong(pBuffer))
}

inline infix fun VkDevice.createCommandPool(createInfo: VkCommandPoolCreateInfo): VkCommandPool {
    val pCommandPool = appBuffer.long
    VK_CHECK_RESULT(VK10.nvkCreateCommandPool(this, createInfo.adr, NULL, pCommandPool))
    return memGetLong(pCommandPool)
}

inline fun VkDevice.createComputePipelines(pipelineCache: VkPipelineCache, createInfo: VkComputePipelineCreateInfo): VkPipeline {
    val pPipeline = appBuffer.long
    VK_CHECK_RESULT(VK10.nvkCreateComputePipelines(this, pipelineCache, 1, createInfo.adr, NULL, pPipeline))
    return memGetLong(pPipeline)
}

inline infix fun VkDevice.createDescriptorPool(createInfo: VkDescriptorPoolCreateInfo): VkDescriptorPool {
    val pDescriptorPool = appBuffer.long
    VK_CHECK_RESULT(VK10.nvkCreateDescriptorPool(this, createInfo.adr, NULL, pDescriptorPool))
    return memGetLong(pDescriptorPool)
}

inline infix fun VkDevice.createDescriptorSetLayout(createInfo: VkDescriptorSetLayoutCreateInfo): VkDescriptorSetLayout {
    val pSetLayout = appBuffer.long
    VK10.nvkCreateDescriptorSetLayout(this, createInfo.adr, NULL, pSetLayout)
    return memGetLong(pSetLayout)
}

inline infix fun VkDevice.createFence(flags: VkFenceCreateFlags): VkFence {
    return createFence(vk.FenceCreateInfo { this.flags = flags })
}

inline infix fun VkDevice.createFence(createInfo: VkFenceCreateInfo): VkFence {
    val pFence = appBuffer.long
    VK_CHECK_RESULT(VK10.nvkCreateFence(this, createInfo.adr, NULL, pFence))
    return memGetLong(pFence)
}

inline fun VkDevice.createFences(createInfo: VkFenceCreateInfo, fences: ArrayList<VkFence>) {
    val pFence = appBuffer.long
    for (i in fences.indices) {
        VK_CHECK_RESULT(VK10.nvkCreateFence(this, createInfo.adr, NULL, pFence))
        fences[i] = memGetLong(pFence)
    }
}

inline infix fun VkDevice.createFramebuffer(createInfo: VkFramebufferCreateInfo): VkFramebuffer {
    val pFramebuffer = appBuffer.long
    VK_CHECK_RESULT(VK10.nvkCreateFramebuffer(this, createInfo.adr, NULL, pFramebuffer))
    return memGetLong(pFramebuffer)
}

inline fun VkDevice.createGraphicsPipelines(pipelineCache: VkPipelineCache, createInfo: VkGraphicsPipelineCreateInfo): VkPipeline {
    val pPipelines = appBuffer.long
    VK_CHECK_RESULT(VK10.nvkCreateGraphicsPipelines(this, pipelineCache, 1, createInfo.adr, NULL, pPipelines))
    return memGetLong(pPipelines)
}

inline infix fun VkDevice.createImage(createInfo: VkImageCreateInfo): VkImage {
    val pImage = appBuffer.long
    VK_CHECK_RESULT(VK10.nvkCreateImage(this, createInfo.adr, NULL, pImage))
    return memGetLong(pImage)
}

inline infix fun VkDevice.createImageView(createInfo: VkImageViewCreateInfo): VkImageView {
    val pView = appBuffer.long
    VK10.nvkCreateImageView(this, createInfo.adr, NULL, pView)
    return memGetLong(pView)
}

inline fun VkDevice.createPipeline(pipelineCache: VkPipelineCache, createInfo: VkGraphicsPipelineCreateInfo): VkPipeline {
    val pPipeline = appBuffer.long
    VK_CHECK_RESULT(VK10.nvkCreateGraphicsPipelines(this, pipelineCache, 1, createInfo.adr, NULL, pPipeline))
    return memGetLong(pPipeline)
}

inline infix fun VkDevice.createPipelineCache(createInfo: VkPipelineCacheCreateInfo): VkPipelineCache {
    val pPipelineCache = appBuffer.long
    VK_CHECK_RESULT(VK10.nvkCreatePipelineCache(this, createInfo.adr, NULL, pPipelineCache))
    return memGetLong(pPipelineCache)
}

inline infix fun VkDevice.createPipelineLayout(createInfo: VkPipelineLayoutCreateInfo): VkPipelineLayout {
    val pPipelineLayout = appBuffer.long
    VK_CHECK_RESULT(VK10.nvkCreatePipelineLayout(this, createInfo.adr, NULL, pPipelineLayout))
    return memGetLong(pPipelineLayout)
}

inline fun VkDevice.createQueryPool(createInfo: VkQueryPoolCreateInfo): VkQueryPool {
    val pQueryPool = appBuffer.long
    VK_CHECK_RESULT(VK10.nvkCreateQueryPool(this, createInfo.adr, NULL, pQueryPool))
    return memGetLong(pQueryPool)
}

inline infix fun VkDevice.createRenderPass(createInfo: VkRenderPassCreateInfo): VkRenderPass {
    val pRenderPass = appBuffer.long
    VK_CHECK_RESULT(VK10.nvkCreateRenderPass(this, createInfo.adr, NULL, pRenderPass))
    return memGetLong(pRenderPass)
}

inline infix fun VkDevice.createSampler(createInfo: VkSamplerCreateInfo): VkSampler {
    val pSampler = appBuffer.long
    VK_CHECK_RESULT(VK10.nvkCreateSampler(this, createInfo.adr, NULL, pSampler))
    return memGetLong(pSampler)
}

inline infix fun VkDevice.createSemaphore(createInfo: VkSemaphoreCreateInfo): VkSemaphore {
    val pSemaphore = appBuffer.long
    VK_CHECK_RESULT(VK10.nvkCreateSemaphore(this, createInfo.adr, NULL, pSemaphore))
    return memGetLong(pSemaphore)
}

inline infix fun VkDevice.createShaderModule(createInfo: VkShaderModuleCreateInfo): VkShaderModule {
    val pShaderModule = appBuffer.long
    VK_CHECK_RESULT(VK10.nvkCreateShaderModule(this, createInfo.adr, NULL, pShaderModule))
    return memGetLong(pShaderModule)
}

inline infix fun VkDevice.createSwapchainKHR(createInfo: VkSwapchainCreateInfoKHR): VkSwapchainKHR {
    val pSwapchain = appBuffer.long
    KHRSwapchain.nvkCreateSwapchainKHR(this, createInfo.adr, NULL, pSwapchain)
    return memGetLong(pSwapchain)
}

inline infix fun VkDevice.debugMarkerSetObjectName(nameInfo: VkDebugMarkerObjectNameInfoEXT) {
    EXTDebugMarker.nvkDebugMarkerSetObjectNameEXT(this, nameInfo.adr)
}

inline infix fun VkDevice.debugMarkerSetObjectTag(tagInfo: VkDebugMarkerObjectTagInfoEXT) {
    EXTDebugMarker.nvkDebugMarkerSetObjectTagEXT(this, tagInfo.adr)
}

inline infix fun VkDevice.destroyBuffer(buffer: VkBuffer) {
    VK10.nvkDestroyBuffer(this, buffer, NULL)
}

inline infix fun VkDevice.destroyCommandPool(commandPool: VkCommandPool) {
    VK10.nvkDestroyCommandPool(this, commandPool, NULL)
}

inline infix fun VkDevice.destroyDescriptorPool(descriptorPool: VkDescriptorPool) {
    VK10.nvkDestroyDescriptorPool(this, descriptorPool, NULL)
}

inline infix fun VkDevice.destroyDescriptorSetLayout(descriptorSetLayout: VkDescriptorSetLayout) {
    VK10.nvkDestroyDescriptorSetLayout(this, descriptorSetLayout, NULL)
}

inline infix fun VkDevice.destroyFence(fence: VkFence) {
    VK10.nvkDestroyFence(this, fence, NULL)
}

inline infix fun VkDevice.destroyFences(fences: ArrayList<VkFence>) {
    for (fence in fences)
        VK10.nvkDestroyFence(this, fence, NULL)
}

inline infix fun VkDevice.destroyFramebuffer(framebuffer: VkFramebuffer) {
    VK10.nvkDestroyFramebuffer(this, framebuffer, NULL)
}

inline infix fun VkDevice.destroyFramebuffers(framebuffers: Iterable<VkFramebuffer>) {
    for (i in framebuffers)
        VK10.nvkDestroyFramebuffer(this, i, NULL)
}

inline infix fun VkDevice.destroyImage(image: VkImage) {
    VK10.nvkDestroyImage(this, image, NULL)
}

inline infix fun VkDevice.destroyImageView(imageView: VkImageView) {
    VK10.nvkDestroyImageView(this, imageView, NULL)
}

inline infix fun VkDevice.destroyPipeline(pipeline: VkPipeline) {
    VK10.nvkDestroyPipeline(this, pipeline, NULL)
}

inline infix fun VkDevice.destroyPipelineCache(pipelineCache: VkPipelineCache) {
    VK10.nvkDestroyPipelineCache(this, pipelineCache, NULL)
}

inline infix fun VkDevice.destroyPipelineLayout(pipelineLayout: VkPipelineLayout) {
    VK10.nvkDestroyPipelineLayout(this, pipelineLayout, NULL)
}

inline fun VkDevice.destroyQueryPool(queryPool: VkQueryPool) {
    VK10.nvkDestroyQueryPool(this, queryPool, NULL)
}

inline infix fun VkDevice.destroyRenderPass(renderPass: VkRenderPass) {
    VK10.nvkDestroyRenderPass(this, renderPass, NULL)
}

inline infix fun VkDevice.destroySampler(sampler: VkSampler) {
    VK10.nvkDestroySampler(this, sampler, NULL)
}

inline infix fun VkDevice.destroySemaphore(semaphore: VkSemaphore) {
    VK10.nvkDestroySemaphore(this, semaphore, NULL)
}

inline fun VkDevice.destroySemaphores(vararg semaphores: VkSemaphore) {
    for (semaphore in semaphores)
        VK10.nvkDestroySemaphore(this, semaphore, NULL)
}

inline fun VkDevice.destroy() {
    VK10.nvkDestroyDevice(this, NULL)
}

inline infix fun VkDevice.destroyShaderModule(shaderModule: VkShaderModule) {
    VK10.nvkDestroyShaderModule(this, shaderModule, NULL)
}

inline infix fun VkDevice.destroyShaderModules(infos: VkPipelineShaderStageCreateInfo.Buffer) {
    for (i in infos)
        VK10.nvkDestroyShaderModule(this, i.module, NULL)
}

inline infix fun VkDevice.destroyShaderModules(modules: Iterable<VkShaderModule>) {
    for (i in modules)
        VK10.nvkDestroyShaderModule(this, i, NULL)
}

inline infix fun VkDevice.destroySwapchainKHR(swapchain: VkSwapchainKHR) {
    KHRSwapchain.nvkDestroySwapchainKHR(this, swapchain, NULL)
}

inline fun VkDevice.freeCommandBuffers(commandPool: VkCommandPool, commandBuffers: ArrayList<VkCommandBuffer>) {
    return vk.freeCommandBuffers(this, commandPool, commandBuffers)
}

inline infix fun VkDevice.flushMappedMemoryRanges(memoryRange: VkMappedMemoryRange) {
    VK_CHECK_RESULT(VK10.nvkFlushMappedMemoryRanges(this, 1, memoryRange.adr))
}

inline infix fun VkDevice.flushMappedMemoryRanges(memoryRanges: VkMappedMemoryRange.Buffer) {
    VK_CHECK_RESULT(VK10.nvkFlushMappedMemoryRanges(this, memoryRanges.capacity(), memoryRanges.adr))
}

inline fun VkDevice.freeCommandBuffer(commandPool: VkCommandPool, commandBuffer: VkCommandBuffer) {
    val pCommandBuffer = appBuffer.pointer
    memPutAddress(pCommandBuffer, commandBuffer.adr)
    VK10.nvkFreeCommandBuffers(this, commandPool, 1, pCommandBuffer)
}

inline infix fun VkDevice.freeMemory(memory: VkDeviceMemory) {
    VK10.nvkFreeMemory(this, memory, NULL)
}

inline infix fun VkDevice.getBufferMemoryRequirements(buffer: VkBuffer): VkMemoryRequirements {
    return getBufferMemoryRequirements(buffer, vk.MemoryRequirements { })
}

inline fun VkDevice.getBufferMemoryRequirements(buffer: VkBuffer, memoryRequirements: VkMemoryRequirements): VkMemoryRequirements {
    VK10.nvkGetBufferMemoryRequirements(this, buffer, memoryRequirements.adr)
    return memoryRequirements
}

inline infix fun VkDevice.getCommandBuffer(commandPool: VkCommandPool): VkCommandBuffer {
    return getCommandBuffer(commandPool, VkCommandBufferLevel.PRIMARY)
}

inline fun VkDevice.getCommandBuffer(commandPool: VkCommandPool, level: VkCommandBufferLevel = VkCommandBufferLevel.PRIMARY, autostart: Boolean = false): VkCommandBuffer {
    val cmdBufAllocateInfo = vk.CommandBufferAllocateInfo(commandPool, level, 1)
    return allocateCommandBuffer(cmdBufAllocateInfo).apply { if (autostart) begin() }
}

inline infix fun VkDevice.getImageMemoryRequirements(buffer: VkBuffer): VkMemoryRequirements {
    return getImageMemoryRequirements(buffer, vk.MemoryRequirements { })
}

inline fun VkDevice.getImageMemoryRequirements(buffer: VkBuffer, memoryRequirements: VkMemoryRequirements): VkMemoryRequirements {
    VK10.nvkGetImageMemoryRequirements(this, buffer, memoryRequirements.adr)
    return memoryRequirements
}

inline fun VkDevice.getImageSubresourceLayout(image: VkImage, subresource: VkImageSubresource): VkSubresourceLayout {
    val layout = vk.SubresourceLayout()
    VK10.nvkGetImageSubresourceLayout(this, image, subresource.adr, layout.adr)
    return layout
}

inline fun VkDevice.getImageSubresourceLayout(image: VkImage, subresource: VkImageSubresource, layout: VkSubresourceLayout): VkSubresourceLayout {
    VK10.nvkGetImageSubresourceLayout(this, image, subresource.adr, layout.adr)
    return layout
}

inline fun VkDevice.mappingMemory(memory: Long, offset: Long, size: Long, flags: VkMemoryMapFlags = 0, block: (Long) -> Unit) {
    val data = appBuffer.pointer
    VK_CHECK_RESULT(VK10.nvkMapMemory(this, memory, offset, size, flags, data))
    block(memGetAddress(data))
    VK10.vkUnmapMemory(this, memory)
}

inline fun VkDevice.mapMemory(memory: Long, offset: Long, size: Long, flags: VkMemoryMapFlags = 0): Long {
    val pData = appBuffer.pointer
    VK_CHECK_RESULT(VK10.nvkMapMemory(this, memory, offset, size, flags, pData))
    return memGetAddress(pData)
}

inline fun VkDevice.mapMemory(memory: Long, offset: Long, size: Long, flags: VkMemoryMapFlags, data: PointerBuffer) {
    VK_CHECK_RESULT(VK10.nvkMapMemory(this, memory, offset, size, flags, data.adr))
}

inline infix fun VkDevice.getQueue(queueFamilyIndex: Int): VkQueue {
    return getQueue(queueFamilyIndex, 0)
}

inline fun VkDevice.getQueue(queueFamilyIndex: Int, queueIndex: Int): VkQueue {
    val pQueue = appBuffer.pointer
    VK10.nvkGetDeviceQueue(this, queueFamilyIndex, queueIndex, pQueue)
    return VkQueue(memGetLong(pQueue), this)
}

inline infix fun VkDevice.getSwapchainImagesKHR(swapchain: VkSwapchainKHR): VkImageViewArray {
    return vk.getSwapchainImagesKHR(this, swapchain)
}

inline infix fun VkDevice.resetCommandPool(commandPool: VkCommandPool) {
    resetCommandPool(commandPool, 0)
}
inline fun VkDevice.resetCommandPool(commandPool: VkCommandPool, flags: VkCommandPoolResetFlags) {
    VK_CHECK_RESULT(VK10.vkResetCommandPool(this, commandPool, flags))
}

inline infix fun VkDevice.resetFence(fence: VkFence) {
    val pFence = appBuffer.long
    memPutLong(pFence, fence)
    VK10.nvkResetFences(this, 1, pFence)
}

inline infix fun VkDevice.unmapMemory(memory: VkDeviceMemory) {
    VK10.vkUnmapMemory(this, memory)
}

inline infix fun VkDevice.updateDescriptorSets(descriptorWrites: VkWriteDescriptorSet) {
    VK10.nvkUpdateDescriptorSets(this, 1, descriptorWrites.adr, 0, NULL)
}

inline infix fun VkDevice.updateDescriptorSets(descriptorWrites: VkWriteDescriptorSet.Buffer) {
    VK10.nvkUpdateDescriptorSets(this, descriptorWrites.remaining(), descriptorWrites.adr, 0, NULL)
}

//inline fun VkDevice.updateDescriptorSets(descriptorWrites: VkWriteDescriptorSet.Buffer,
//                                descriptorCopies: VkCopyDescriptorSet.Buffer? = null) {
//    VK10.nvkUpdateDescriptorSets(device, descriptorWrites.remaining(), descriptorWrites.adr,
//            descriptorCopies?.remaining() ?: 0, descriptorCopies?.adr ?: NULL)
//}

inline fun VkDevice.waitForFence(fence: VkFence, waitAll: Boolean, timeout: Long) {
    val pFence = appBuffer.long
    memPutLong(pFence, fence)
    VK_CHECK_RESULT(VK10.nvkWaitForFences(this, 1, pFence, waitAll.i, timeout))
}

inline fun VkDevice.waitIdle() {
    VK_CHECK_RESULT(VK10.vkDeviceWaitIdle(this))
}

inline fun VkDevice.withFence(flags: VkFenceCreateFlags = 0, block: (VkFence) -> Unit) {
    val fence = createFence(flags)
    block(fence)
    destroyFence(fence)
}


/*
    VkInstance
 */

inline infix fun VkInstance.createDebugReportCallbackEXT(createInfo: VkDebugReportCallbackCreateInfoEXT): VkDebugReportCallback {
    val long = appBuffer.long
    VK_CHECK_RESULT(EXTDebugReport.nvkCreateDebugReportCallbackEXT(this, createInfo.adr, NULL, long))
    return memGetLong(long)
}

inline fun VkInstance.destroy() {
    VK10.nvkDestroyInstance(this, NULL)
}

inline infix fun VkInstance.destroyDebugReportCallbackEXT(debugReportCallback: VkDebugReportCallback) {
    EXTDebugReport.nvkDestroyDebugReportCallbackEXT(this, debugReportCallback, NULL)
}

inline fun VkInstance.enumeratePhysicalDevices(): ArrayList<VkPhysicalDevice> {
    return vk.enumeratePhysicalDevices(this)
}


/*
    VkPhysicalDevice
 */

inline val VkPhysicalDevice.features: VkPhysicalDeviceFeatures
    get() = vk.PhysicalDeviceFeatures { }.also(::getFeatures)

inline infix fun VkPhysicalDevice.getFeatures(features: VkPhysicalDeviceFeatures) {
    VK10.nvkGetPhysicalDeviceFeatures(this, features.adr)
}

inline infix fun VkPhysicalDevice.getFormatProperties(format: VkFormat): VkFormatProperties {
    return getFormatProperties(format, vk.FormatProperties { })
}

inline fun VkPhysicalDevice.getFormatProperties(format: VkFormat, formatProperties: VkFormatProperties): VkFormatProperties {
    VK10.nvkGetPhysicalDeviceFormatProperties(this, format.i, formatProperties.adr)
    return formatProperties
}

inline val VkPhysicalDevice.memoryProperties: VkPhysicalDeviceMemoryProperties
    get() = vk.PhysicalDeviceMemoryProperties().also(::getMemoryProperties)

inline infix fun VkPhysicalDevice.getMemoryProperties(memoryProperties: VkPhysicalDeviceMemoryProperties) {
    VK10.nvkGetPhysicalDeviceMemoryProperties(this, memoryProperties.adr)
}

inline val VkPhysicalDevice.queueFamilyProperties: ArrayList<VkQueueFamilyProperties>
    get() = vk.getPhysicalDeviceQueueFamilyProperties(this)

inline val VkPhysicalDevice.properties: VkPhysicalDeviceProperties
    get() = vk.PhysicalDeviceProperties().also(::getProperties)

inline infix fun VkPhysicalDevice.getProperties(properties: VkPhysicalDeviceProperties) {
    VK10.nvkGetPhysicalDeviceProperties(this, properties.adr)
}

inline infix fun VkPhysicalDevice.createDevice(createInfo: VkDeviceCreateInfo): VkDevice {
    val pDevice = appBuffer.pointer
    VK_CHECK_RESULT(VK10.nvkCreateDevice(this, createInfo.adr, NULL, pDevice))
    return VkDevice(memGetLong(pDevice), this, createInfo)
}

inline infix fun VkPhysicalDevice.getSurfaceCapabilitiesKHR(surface: VkSurfaceKHR): VkSurfaceCapabilitiesKHR {
    return vk.SurfaceCapabilitiesKHR {
        VK_CHECK_RESULT(KHRSurface.nvkGetPhysicalDeviceSurfaceCapabilitiesKHR(this@getSurfaceCapabilitiesKHR, surface, adr))
    }
}

inline infix fun VkPhysicalDevice.getSurfaceFormatsKHR(surface: VkSurfaceKHR): ArrayList<VkSurfaceFormatKHR> {
    return vk.getPhysicalDeviceSurfaceFormatsKHR(this, surface)
}
inline fun VkPhysicalDevice.getSurfaceSupportKHR(queueFamily: Int, surface: VkSurfaceKHR): Boolean {
    return vk.getPhysicalDeviceSurfaceSupportKHR(this, queueFamily, surface)
}
inline fun VkPhysicalDevice.getSurfaceSupportKHR(queueFamilyProperties: ArrayList<VkQueueFamilyProperties>,
                                                 surface: VkSurfaceKHR): BooleanArray {
    return vk.getPhysicalDeviceSurfaceSupportKHR(this, queueFamilyProperties, surface)
}

inline infix fun VkPhysicalDevice.getSurfacePresentModesKHR(surface: VkSurfaceKHR): ArrayList<VkPresentMode> {
    return vk.getPhysicalDeviceSurfacePresentModesKHR(this, surface)
}


/*
    VkQueue
 */

inline infix fun VkQueue.presentKHR(presentInfo: VkPresentInfoKHR) {
    VK_CHECK_RESULT(KHRSwapchain.vkQueuePresentKHR(this, presentInfo))
}

inline infix fun VkQueue.submit(submits: VkSubmitInfo) {
    VK_CHECK_RESULT(VK10.nvkQueueSubmit(this, 1, submits.adr, NULL))
}

inline fun VkQueue.submit(submits: VkSubmitInfo, fence: VkFence) {
    VK_CHECK_RESULT(VK10.nvkQueueSubmit(this, 1, submits.adr, fence))
}

inline fun VkQueue.waitIdle() {
    VK_CHECK_RESULT(VK10.vkQueueWaitIdle(this))
}


/*
    Invokes (~set)
 */


inline operator fun VkDescriptorPoolSize.invoke(type: VkDescriptorType, descriptorCount: Int): VkDescriptorPoolSize {
    this.type = type
    this.descriptorCount = descriptorCount
    return this
}

inline operator fun VkDescriptorSetLayoutBinding.invoke(
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


inline operator fun VkVertexInputAttributeDescription.invoke(location: Int, binding: Int, format: VkFormat, offset: Int): VkVertexInputAttributeDescription {
    this.location = location
    this.binding = binding
    this.format = format
    this.offset = offset
    return this
}

inline operator fun VkVertexInputBindingDescription.invoke(binding: Int, stride: Int, inputRate: VkVertexInputRate): VkVertexInputBindingDescription {
    this.binding = binding
    this.stride = stride
    this.inputRate = inputRate
    return this
}


inline operator fun VkWriteDescriptorSet.invoke(dstSet: VkDescriptorSet, descriptorType: VkDescriptorType, dstBinding: Int,
                                                bufferInfo: VkDescriptorBufferInfo): VkWriteDescriptorSet {
    this.dstSet = dstSet
    this.dstBinding = dstBinding
    this.descriptorType = descriptorType
    this.bufferInfo_ = bufferInfo
    return this
}

inline operator fun VkWriteDescriptorSet.invoke(dstSet: VkDescriptorSet, descriptorType: VkDescriptorType, dstBinding: Int,
                                                imageInfo: VkDescriptorImageInfo): VkWriteDescriptorSet {
    this.dstSet = dstSet
    this.dstBinding = dstBinding
    this.descriptorType = descriptorType
    this.imageInfo_ = imageInfo
    return this
}
