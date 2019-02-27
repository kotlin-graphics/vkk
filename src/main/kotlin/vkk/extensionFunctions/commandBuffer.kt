package vkk.extensionFunctions

import glm_.*
import glm_.vec2.Vec2i
import kool.*
import org.lwjgl.PointerBuffer
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.system.Pointer
import org.lwjgl.vulkan.*
import vkk.*
import vkk.entities.*
import java.nio.Buffer
import java.nio.IntBuffer
import java.nio.LongBuffer


infix fun VkCommandBuffer.begin(beginInfo: VkCommandBufferBeginInfo) =
        VK_CHECK_RESULT(VK10.nvkBeginCommandBuffer(this, beginInfo.adr))

/** JVM custom */
fun VkCommandBuffer.begin(flags: VkCommandBufferUsageFlags = VkCommandBufferUsage.SIMULTANEOUS_USE_BIT.i) =
        begin(vk.CommandBufferBeginInfo { this.flags = flags })

infix fun VkCommandBuffer.beginConditionalRenderingEXT(conditionalRenderingBegin: VkConditionalRenderingBeginInfoEXT) =
        EXTConditionalRendering.nvkCmdBeginConditionalRenderingEXT(this, conditionalRenderingBegin.adr)

infix fun VkCommandBuffer.beginDebugUtilsLabelEXT(labelInfo: VkDebugUtilsLabelEXT) =
        EXTDebugUtils.nvkCmdBeginDebugUtilsLabelEXT(this, labelInfo.adr)

fun VkCommandBuffer.beginQuery(queryPool: VkQueryPool, query: Int, flags: VkQueryControlFlags) =
        VK10.vkCmdBeginQuery(this, queryPool.L, query, flags)

fun VkCommandBuffer.beginQueryIndexedEXT(queryPool: VkQueryPool, query: Int, flags: VkQueryControlFlags, index: Int) =
        EXTTransformFeedback.vkCmdBeginQueryIndexedEXT(this, queryPool.L, query, flags, index)

fun VkCommandBuffer.beginRenderPass(renderPassBegin: VkRenderPassBeginInfo, contents: VkSubpassContents) =
        VK10.nvkCmdBeginRenderPass(this, renderPassBegin.adr, contents.i)

fun VkCommandBuffer.beginRenderPass2KHR(renderPassBegin: VkRenderPassBeginInfo, subpassBeginInfo: VkSubpassBeginInfoKHR) =
        KHRCreateRenderpass2.nvkCmdBeginRenderPass2KHR(this, renderPassBegin.adr, subpassBeginInfo.adr)

fun VkCommandBuffer.beginTransformFeedbackEXT(firstCounterBuffer: Int, counterBuffers: VkBufferBuffer?,
                                              counterBufferOffsets: VkDeviceSizeBuffer?) =
        EXTTransformFeedback.nvkCmdBeginTransformFeedbackEXT(this, firstCounterBuffer, counterBuffers?.rem
                ?: 0, counterBuffers?.adr ?: NULL, counterBufferOffsets?.adr ?: NULL)

fun VkCommandBuffer.bindDescriptorSets(pipelineBindPoint: VkPipelineBindPoint,
                                       layout: VkPipelineLayout,
                                       descriptorSets: VkDescriptorSetBuffer,
                                       dynamicOffsets: IntBuffer) =
        VK10.nvkCmdBindDescriptorSets(this, pipelineBindPoint.i, layout.L, 0, descriptorSets.rem, descriptorSets.adr, dynamicOffsets.rem, dynamicOffsets.adr)

fun VkCommandBuffer.bindDescriptorSets(pipelineBindPoint: VkPipelineBindPoint,
                                       layout: VkPipelineLayout,
                                       firstSet: Int,
                                       descriptorSets: VkDescriptorSetBuffer,
                                       dynamicOffsets: IntBuffer) =
        VK10.nvkCmdBindDescriptorSets(this, pipelineBindPoint.i, layout.L, firstSet, descriptorSets.rem, descriptorSets.adr, dynamicOffsets.rem, dynamicOffsets.adr)

fun VkCommandBuffer.bindDescriptorSets(pipelineBindPoint: VkPipelineBindPoint, layout: VkPipelineLayout,
                                       descriptorSet: VkDescriptorSet, dynamicOffsets: Int? = null) = stak {
    val pDescriptorSets = it.nmalloc(8, Long.BYTES)
    memPutLong(pDescriptorSets, descriptorSet.L)
    val dynamicOffsetCount: Int
    val pDynamicOffset = when (dynamicOffsets) {
        null -> {
            dynamicOffsetCount = 0
            NULL
        }
        else -> {
            dynamicOffsetCount = 1
            it.nmalloc(4, Int.BYTES).also { memPutInt(it, dynamicOffsets) }
        }
    }
    VK10.nvkCmdBindDescriptorSets(this, pipelineBindPoint.i, layout.L, 0, 1, pDescriptorSets, dynamicOffsetCount, pDynamicOffset)
}

fun VkCommandBuffer.bindIndexBuffer(buffer: VkBuffer, offset: VkDeviceSize, indexType: VkIndexType) =
        VK10.vkCmdBindIndexBuffer(this, buffer.L, offset.L, indexType.i)

fun VkCommandBuffer.bindPipeline(pipelineBindPoint: VkPipelineBindPoint, pipeline: VkPipeline) =
        VK10.vkCmdBindPipeline(this, pipelineBindPoint.i, pipeline.L)

fun VkCommandBuffer.bindShadingRateImageNV(imageView: VkImageView, imageLayout: VkImageLayout) =
        NVShadingRateImage.vkCmdBindShadingRateImageNV(this, imageView.L, imageLayout.i)

infix fun VkCommandBuffer.bindVertexBuffers(buffer: VkBuffer) = bindVertexBuffers(0, buffer)

fun VkCommandBuffer.bindVertexBuffers(firstBinding: Int, buffer: LongBuffer, offset: LongBuffer) {
    VK10.nvkCmdBindVertexBuffers(this, firstBinding, buffer.rem, buffer.adr, offset.adr)
}

fun VkCommandBuffer.bindVertexBuffers(firstBinding: Int, buffer: VkBuffer, offset: VkDeviceSize = VkDeviceSize(0)) = stak {
    val pBuffer = it.nmalloc(1, Long.BYTES)
    memPutLong(pBuffer, buffer.L)
    val pOffset = it.nmalloc(1, Long.BYTES)
    memPutLong(pOffset, offset.L)
    VK10.nvkCmdBindVertexBuffers(this, firstBinding, 1, pBuffer, pOffset)
}

fun VkCommandBuffer.blitImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, region: VkImageBlit, filter: VkFilter) = VK10.nvkCmdBlitImage(this, srcImage.L, srcImageLayout.i, dstImage.L, dstImageLayout.i, 1, region.adr, filter.i)

fun VkCommandBuffer.copyBuffer(srcBuffer: VkBuffer, dstBuffer: VkBuffer, region: VkBufferCopy) = VK10.nvkCmdCopyBuffer(this, srcBuffer.L, dstBuffer.L, 1, region.adr)

fun VkCommandBuffer.copyBuffer(srcBuffer: VkBuffer, dstBuffer: VkBuffer, regions: VkBufferCopy.Buffer) = VK10.nvkCmdCopyBuffer(this, srcBuffer.L, dstBuffer.L, regions.remaining(), regions.adr)

fun VkCommandBuffer.copyBufferToImage(srcBuffer: VkBuffer, dstImage: VkImage, dstImageLayout: VkImageLayout, region: VkBufferImageCopy) = VK10.nvkCmdCopyBufferToImage(this, srcBuffer.L, dstImage.L, dstImageLayout.i, 1, region.adr)

fun VkCommandBuffer.copyBufferToImage(srcBuffer: VkBuffer, dstImage: VkImage, dstImageLayout: VkImageLayout, region: VkBufferImageCopy.Buffer) = VK10.nvkCmdCopyBufferToImage(this, srcBuffer.L, dstImage.L, dstImageLayout.i, region.remaining(), region.adr)

fun VkCommandBuffer.copyImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, region: VkImageCopy) = VK10.nvkCmdCopyImage(this, srcImage.L, srcImageLayout.i, dstImage.L, dstImageLayout.i, 1, region.adr)

fun VkCommandBuffer.copyImageToBuffer(srcImage: VkImage, srcImageLayout: VkImageLayout, dstBuffer: VkBuffer, region: VkBufferImageCopy) = VK10.nvkCmdCopyImageToBuffer(this, srcImage.L, srcImageLayout.i, dstBuffer.L, 1, region.adr)
fun VkCommandBuffer.copyImageToBuffer(srcImage: VkImage, srcImageLayout: VkImageLayout, dstBuffer: VkBuffer, regions: VkBufferImageCopy.Buffer) = VK10.nvkCmdCopyImageToBuffer(this, srcImage.L, srcImageLayout.i, dstBuffer.L, regions.rem, regions.adr)

infix fun VkCommandBuffer.debugMarkerBegin(markerInfo: VkDebugMarkerMarkerInfoEXT) = EXTDebugMarker.nvkCmdDebugMarkerBeginEXT(this, markerInfo.adr)

fun VkCommandBuffer.debugMarkerEnd() = EXTDebugMarker.vkCmdDebugMarkerEndEXT(this)

infix fun VkCommandBuffer.debugMarkerInsert(markerInfo: VkDebugMarkerMarkerInfoEXT) = EXTDebugMarker.nvkCmdDebugMarkerInsertEXT(this, markerInfo.adr)

fun VkCommandBuffer.dispatch(groupCountXY: Vec2i, groupCountZ: Int) = dispatch(groupCountXY.x, groupCountXY.y, groupCountZ)

fun VkCommandBuffer.dispatch(groupCountX: Int, groupCountY: Int, groupCountZ: Int) = VK10.vkCmdDispatch(this, groupCountX, groupCountY, groupCountZ)

fun VkCommandBuffer.draw(vertexCount: Int, instanceCount: Int, firstVertex: Int, firstInstance: Int) = VK10.vkCmdDraw(this, vertexCount, instanceCount, firstVertex, firstInstance)

fun VkCommandBuffer.drawIndexed(indexCount: Int, instanceCount: Int, firstIndex: Int, vertexOffset: Int, firstInstance: Int) = VK10.vkCmdDrawIndexed(this, indexCount, instanceCount, firstIndex, vertexOffset, firstInstance)

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

infix fun VkCommandBuffer.executeCommand(commandBuffer: VkCommandBuffer) = VK10.vkCmdExecuteCommands(this, commandBuffer)

infix fun VkCommandBuffer.executeCommands(commandBuffers: Collection<VkCommandBuffer>) = stak {
    val count = commandBuffers.size
    val pCommandBuffers = it.mallocPointer(count)
    for (i in 0 until count)
        pCommandBuffers[i] = commandBuffers.elementAt(i)
    VK10.nvkCmdExecuteCommands(this, count, pCommandBuffers.adr)
}

infix fun VkCommandBuffer.nextSubpass(contents: VkSubpassContents) = VK10.vkCmdNextSubpass(this, contents.i)

fun VkCommandBuffer.pipelineBarrier(srcStageMask: VkPipelineStage, dstStageMask: VkPipelineStage,
                                    dependencyFlags: VkDependencyFlags = 0,
                                    memoryBarrier: VkMemoryBarrier? = null,
                                    bufferMemoryBarrier: VkBufferMemoryBarrier? = null,
                                    imageMemoryBarrier: VkImageMemoryBarrier? = null) = pipelineBarrier(srcStageMask.i, dstStageMask.i, dependencyFlags, memoryBarrier, bufferMemoryBarrier, imageMemoryBarrier)

fun VkCommandBuffer.pipelineBarrier(srcStageMask: VkPipelineStageFlags, dstStageMask: VkPipelineStageFlags,
                                    dependencyFlags: VkDependencyFlags = 0,
                                    memoryBarrier: VkMemoryBarrier? = null,
                                    bufferMemoryBarrier: VkBufferMemoryBarrier? = null,
                                    imageMemoryBarrier: VkImageMemoryBarrier? = null) =
        VK10.nvkCmdPipelineBarrier(this, srcStageMask, dstStageMask, dependencyFlags,
                if (memoryBarrier != null) 1 else 0, memoryBarrier?.adr ?: NULL,
                if (bufferMemoryBarrier != null) 1 else 0, bufferMemoryBarrier?.adr ?: NULL,
                if (imageMemoryBarrier != null) 1 else 0, imageMemoryBarrier?.adr ?: NULL)

fun VkCommandBuffer.pushConstants(layout: VkPipelineLayout, stageFlags: VkShaderStageFlags, offset: Int, values: Buffer) = VK10.nvkCmdPushConstants(this, layout.L, stageFlags, offset, values.remSize, values.adr)


fun VkCommandBuffer.reset(flags: VkCommandBufferResetFlags = 0) = VK_CHECK_RESULT(VK10.vkResetCommandBuffer(this, flags))

fun VkCommandBuffer.setDepthBias(depthBiasConstantFactor: Float, depthBiasClamp: Float, depthBiasSlopeFactor: Float) = VK10.vkCmdSetDepthBias(this, depthBiasConstantFactor, depthBiasClamp, depthBiasSlopeFactor)

infix fun VkCommandBuffer.setLineWidth(lineWidth: Float) = VK10.vkCmdSetLineWidth(this, lineWidth)

infix fun VkCommandBuffer.setScissor(extend: Vec2i) = setScissor(vk.Rect2D(0, 0, extend.x, extend.y))

fun VkCommandBuffer.setScissor(offset: Vec2i, extend: Vec2i) = setScissor(vk.Rect2D(offset, extend))

infix fun VkCommandBuffer.setScissor(scissor: VkRect2D) = VK10.nvkCmdSetScissor(this, 0, 1, scissor.adr)

infix fun VkCommandBuffer.setScissor(scissors: VkRect2D.Buffer) = VK10.nvkCmdSetScissor(this, 0, scissors.remaining(), scissors.adr)

fun VkCommandBuffer.setScissor(firstScissor: Int, scissors: VkRect2D.Buffer) = VK10.nvkCmdSetScissor(this, firstScissor, scissors.remaining(), scissors.adr)

infix fun VkCommandBuffer.setViewport(size: Vec2i) = setViewport(size, 0f, 1f)

fun VkCommandBuffer.setViewport(size: Vec2i, minDepth: Float, maxDepth: Float) = setViewport(size.x.f, size.y.f, minDepth, maxDepth)

fun VkCommandBuffer.setViewport(width: Float, height: Float, minDepth: Float = 0f, maxDepth: Float = 1f) = setViewport(vk.Viewport(width, height, minDepth, maxDepth))

infix fun VkCommandBuffer.setViewport(viewport: VkViewport) = VK10.nvkCmdSetViewport(this, 0, 1, viewport.adr)

fun VkCommandBuffer.setViewport(firstViewport: Int, viewports: VkViewport.Buffer) = VK10.nvkCmdSetViewport(this, firstViewport, viewports.remaining(), viewports.adr)

fun VkCommandBuffer.submit(queue: VkQueue, submitInfoPNext: Pointer? = null) {
    queue submit vk.SubmitInfo {
        commandBuffer = this@submit
        submitInfoPNext?.let { next = it.adr }
    }
    queue.waitIdle()
}

fun VkCommandBuffer.writeTimestamp(pipelineStage: VkPipelineStageFlags, queryPool: VkQueryPool, query: Int) = VK10.vkCmdWriteTimestamp(this, pipelineStage, queryPool.L, query)


//inline fun VkCommandBuffer.use(block: ()) {
//    VK10.nvkCmdSetViewport(this, firstViewport, viewports.remaining(), viewports.adr)
//}
//inline fun VkCommandBuffer.setBlendConstants(depthBiasConstantFactor: Float, depthBiasClamp: Float, depthBiasSlopeFactor: Float) {
//    VK10.setBlendConstants(this, depthBiasConstantFactor, depthBiasClamp, depthBiasSlopeFactor)
//}

// ---------- Inline lambdas ----------

/** begin .. end */
inline fun <R> VkCommandBuffer.record(beginInfo: VkCommandBufferBeginInfo, block: VkCommandBuffer.() -> R): R {
    begin(beginInfo)
    return block().also { end() }
}

//inline fun <R> VkCommandBuffer.conditionalRenderingEXT(conditionalRenderingBegin: VkConditionalRenderingBeginInfoEXT,
//                                                       block: VkCommandBuffer.() -> R): R {
//    beginConditionalRenderingEXT(conditionalRenderingBegin)
//    return block().also { endConditionalRenderingEXT() }
//}
//
//inline fun <R> VkCommandBuffer.debugUtilsLabelEXT(labelInfo: VkDebugUtilsLabelEXT, block: VkCommandBuffer.() -> R): R {
//    beginDebugUtilsLabelEXT(labelInfo)
//    return block().also { endDebugUtilsLabelEXT() }
//}
//
//inline fun <R> VkCommandBuffer.query(queryPool: VkQueryPool, query: Int, flags: VkQueryControlFlags, block: VkCommandBuffer.() -> R): R {
//    beginQuery(queryPool, query, flags)
//    return block().also { endQuery() }
//}
//
//inline fun <R> VkCommandBuffer.queryIndexedEXT(queryPool: VkQueryPool, query: Int, flags: VkQueryControlFlags,
//                                               index: Int, block: VkCommandBuffer.() -> R): R {
//    beginQueryIndexedEXT(queryPool, query, flags, index)
//    return block().also { endQueryIndexedEXT() }
//}
//
//inline fun <R> VkCommandBuffer.renderPass(renderPassBegin: VkRenderPassBeginInfo, contents: VkSubpassContents,
//                                          block: VkCommandBuffer.() -> R): R {
//    beginRenderPass(renderPassBegin, contents)
//    return block().also { endRenderPass() }
//}
//
//inline fun <R> VkCommandBuffer.renderPass2KHR(renderPassBegin: VkRenderPassBeginInfo, subpassBeginInfo: VkSubpassBeginInfoKHR,
//                                              block: VkCommandBuffer.() -> R): R {
//    beginRenderPass2KHR(renderPassBegin, subpassBeginInfo)
//    return block().also { endRenderPass2KHR() }
//}
//
//inline fun <R> VkCommandBuffer.transformFeedbackEXT(firstCounterBuffer: Int, counterBuffers: VkBufferBuffer?,
//                                                    counterBufferOffsets: VkDeviceSizeBuffer?,
//                                                    block: VkCommandBuffer.() -> R): R {
//    beginTransformFeedbackEXT(firstCounterBuffer, counterBuffers, counterBufferOffsets)
//    return block().also { endTransformFeedbackEXT() }
//}