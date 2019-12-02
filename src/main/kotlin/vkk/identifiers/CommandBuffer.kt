package identifiers

import glm_.vec3.Vec3i
import identifiers.write
import kool.*
import org.lwjgl.system.JNI.*
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import vkk.*
import vkk._10.*
import vkk._10.structs.*
import vkk.entities.*

/** Wraps a Vulkan command buffer handle.  */
class CommandBuffer
/**
 * Creates a `VkCommandBuffer` using the specified native handle and device.
 *
 * @param handle the native `VkCommandBuffer` handle
 * @param device the device on which the command buffer was created
 */(
        handle: Ptr,
        /** Returns the device on which this `VkCommandBuffer` was created.  */
        val device: Device
) : DispatchableHandleDevice(handle, device.capabilities) {

    val isValid get() = adr != NULL
    val isInvalid get() = adr == NULL

    // --- [ vkBeginCommandBuffer ] ---

    infix fun begin(beginInfo: CommandBufferBeginInfo): VkResult =
            stak { s -> VkResult(callPPI(adr, beginInfo write s, capabilities.vkBeginCommandBuffer)) }

    // --- [ vkCmdBeginQuery ] ---
    fun beginQuery(queryPool: VkQueryPool, query: Int, flags: VkQueryControlFlags) =
            callPJV(adr, queryPool.L, query, flags, capabilities.vkCmdBeginQuery)

    // --- [ vkCmdBeginRenderPass ] ---
    fun beginRenderPass(renderPassBegin: RenderPassBeginInfo, contents: VkSubpassContents = VkSubpassContents.INLINE) = stak { s ->
        callPPV(adr, renderPassBegin write s, contents.i, capabilities.vkCmdBeginRenderPass)
    }

    // --- [ vkCmdBindDescriptorSets ] ---
    inline fun nBindDescriptorSets(pipelineBindPoint: VkPipelineBindPoint, layout: VkPipelineLayout, firstSet: Int,
                                   descriptorSetCount: Int, pDescriptorSets: Ptr, dynamicOffsetCount: Int, pDynamicOffsets: Ptr) =
            callPJPPV(adr, pipelineBindPoint.i, layout.L, firstSet, descriptorSetCount, pDescriptorSets, dynamicOffsetCount, pDynamicOffsets, capabilities.vkCmdBindDescriptorSets)

    fun bindDescriptorSets(pipelineBindPoint: VkPipelineBindPoint, layout: VkPipelineLayout, firstSet: Int,
                           descriptorSets: VkDescriptorSet_Array, dynamicOffsets: IntArray) = stak { s ->
        nBindDescriptorSets(pipelineBindPoint, layout, firstSet, descriptorSets.size, descriptorSets write s, dynamicOffsets.size, dynamicOffsets.toAdr(s).adr)
    }

    fun bindDescriptorSets(pipelineBindPoint: VkPipelineBindPoint, layout: VkPipelineLayout, firstSet: Int,
                           descriptorSet: VkDescriptorSet, dynamicOffset: Int) = stak { s ->
        nBindDescriptorSets(pipelineBindPoint, layout, firstSet, 1, s.longAdr(descriptorSet.L), 1, s.intAdr(dynamicOffset))
    }

    // --- [ vkCmdBindIndexBuffer ] ---
    fun bindIndexBuffer(buffer: VkBuffer, offset: VkDeviceSize, indexType: VkIndexType) =
            callPJJV(adr, buffer.L, offset.L, indexType.i, capabilities.vkCmdBindIndexBuffer)

    // --- [ vkCmdBindPipeline ] ---
    fun bindPipeline(pipelineBindPoint: VkPipelineBindPoint, pipeline: VkPipeline) =
            callPJV(adr, pipelineBindPoint.i, pipeline.L, capabilities.vkCmdBindPipeline)

    // --- [ vkCmdBindVertexBuffers ] ---
    inline fun nBindVertexBuffers(firstBinding: Int, bindingCount: Int, pBuffers: Ptr, pOffsets: Ptr) =
            callPPPV(adr, firstBinding, bindingCount, pBuffers, pOffsets, capabilities.vkCmdBindVertexBuffers)

    fun bindVertexBuffers(firstBinding: Int, bindingCount: Int, buffers: VkBuffer_Array, offsets: VkDeviceSize_Array) = stak { s ->
        nBindVertexBuffers(firstBinding, bindingCount, buffers write s, offsets write s)
    }

    fun bindVertexBuffers(firstBinding: Int, bindingCount: Int, buffer: VkBuffer, offset: VkDeviceSize) = stak { s ->
        nBindVertexBuffers(firstBinding, bindingCount, s.longAdr(buffer.L), s.longAdr(offset.L))
    }

    fun bindVertexBuffers(buffer: VkBuffer, offset: VkDeviceSize = VkDeviceSize.NULL) = stak { s ->
        nBindVertexBuffers(
                0,
                1,
                s.LongBuffer(1) { buffer.L }.adr,
                s.LongBuffer(1) { offset.L }.adr
        )
    }

    fun bindVertexBuffers(firstBinding: Int, buffer: VkBuffer_Array, offset: VkDeviceSize_Array) = stak { s ->
        nBindVertexBuffers(
                firstBinding,
                buffer.size,
                s.LongBuffer(buffer.size) { buffer[it].L }.adr,
                s.LongBuffer(offset.size) { offset[it].L }.adr
        )
    }

    // --- [ vkCmdBlitImage ] ---
    inline fun nBlitImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, regionCount: Int, pRegions: Ptr, filter: VkFilter) =
            callPJJPV(adr, srcImage.L, srcImageLayout.i, dstImage.L, dstImageLayout.i, regionCount, pRegions, filter.i, capabilities.vkCmdBlitImage)

    fun blitImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, regions: Array<ImageBlit>, filter: VkFilter) = stak { s ->
        nBlitImage(srcImage, srcImageLayout, dstImage, dstImageLayout, regions.size, regions write s, filter)
    }

    fun blitImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, region: ImageBlit, filter: VkFilter) = stak { s ->
        nBlitImage(srcImage, srcImageLayout, dstImage, dstImageLayout, 1, region write s, filter)
    }

    // --- [ vkCmdClearAttachments ] ---
    inline fun nClearAttachments(attachmentCount: Int, pAttachments: Ptr, rectCount: Int, pRects: Ptr) =
            callPPPV(adr, attachmentCount, pAttachments, rectCount, pRects, capabilities.vkCmdClearAttachments)

    fun clearAttachments(attachments: Array<ClearAttachment>, rects: Array<ClearRect>) = stak { s ->
        nClearAttachments(attachments.size, attachments write s, rects.size, rects write s)
    }

    fun clearAttachments(attachment: ClearAttachment, rect: ClearRect) = stak { s ->
        nClearAttachments(1, attachment write s, 1, rect write s)
    }

    // --- [ vkCmdClearColorImage ] ---
    inline fun nClearColorImage(image: VkImage, imageLayout: VkImageLayout, pColor: Ptr, rangeCount: Int, pRanges: Ptr) =
            callPJPPV(adr, image.L, imageLayout.i, pColor, rangeCount, pRanges, capabilities.vkCmdClearColorImage)

    fun clearColorImage(image: VkImage, imageLayout: VkImageLayout, color: ClearColorValue, ranges: Array<ImageSubresourceRange>) = stak { s ->
        nClearColorImage(image, imageLayout, color write s, ranges.size, ranges write s)
    }

    fun clearColorImage(image: VkImage, imageLayout: VkImageLayout, color: ClearColorValue, range: ImageSubresourceRange) = stak { s ->
        nClearColorImage(image, imageLayout, color write s, 1, range write s)
    }

    // --- [ vkCmdClearDepthStencilImage ] ---
    inline fun nClearDepthStencilImage(image: VkImage, imageLayout: VkImageLayout, pDepthStencil: Ptr, rangeCount: Int, pRanges: Ptr) =
            callPJPPV(adr, image.L, imageLayout.i, pDepthStencil, rangeCount, pRanges, capabilities.vkCmdClearDepthStencilImage)

    fun clearDepthStencilImage(image: VkImage, imageLayout: VkImageLayout, depthStencil: ClearDepthStencilValue, ranges: Array<ImageSubresourceRange>) = stak { s ->
        nClearDepthStencilImage(image, imageLayout, depthStencil write s, ranges.size, ranges write s)
    }

    fun clearDepthStencilImage(image: VkImage, imageLayout: VkImageLayout, depthStencil: ClearDepthStencilValue, range: ImageSubresourceRange) = stak { s ->
        nClearDepthStencilImage(image, imageLayout, depthStencil write s, 1, range write s)
    }

    // --- [ vkCmdCopyBuffer ] ---
    inline fun nCopyBuffer(srcBuffer: VkBuffer, dstBuffer: VkBuffer, regionCount: Int, pRegions: Ptr) =
            callPJJPV(adr, srcBuffer.L, dstBuffer.L, regionCount, pRegions, capabilities.vkCmdCopyBuffer)

    fun copyBuffer(srcBuffer: VkBuffer, dstBuffer: VkBuffer, regions: Array<BufferCopy>) = stak { s ->
        nCopyBuffer(srcBuffer, dstBuffer, regions.size, regions write s)
    }

    fun copyBuffer(srcBuffer: VkBuffer, dstBuffer: VkBuffer, region: BufferCopy) = stak { s ->
        nCopyBuffer(srcBuffer, dstBuffer, 1, region write s)
    }

    // --- [ vkCmdCopyBufferToImage ] ---
    inline fun nCopyBufferToImage(srcBuffer: VkBuffer, dstImage: VkImage, dstImageLayout: VkImageLayout, regionCount: Int, pRegions: Ptr) =
            callPJJPV(adr, srcBuffer.L, dstImage.L, dstImageLayout.i, regionCount, pRegions, capabilities.vkCmdCopyBufferToImage)

    fun copyBufferToImage(srcBuffer: VkBuffer, dstImage: VkImage, dstImageLayout: VkImageLayout, regions: Array<BufferImageCopy>) = stak { s ->
        nCopyBufferToImage(srcBuffer, dstImage, dstImageLayout, regions.size, regions write s)
    }

    fun copyBufferToImage(srcBuffer: VkBuffer, dstImage: VkImage, dstImageLayout: VkImageLayout, region: BufferImageCopy) = stak { s ->
        nCopyBufferToImage(srcBuffer, dstImage, dstImageLayout, 1, region write s)
    }

    // --- [ vkCmdCopyImage ] ---
    inline fun nCopyImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, regionCount: Int, pRegions: Ptr) =
            callPJJPV(adr, srcImage.L, srcImageLayout.i, dstImage.L, dstImageLayout.i, regionCount, pRegions, capabilities.vkCmdCopyImage)

    fun copyImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, regions: Array<ImageCopy>) = stak { s ->
        nCopyImage(srcImage, srcImageLayout, dstImage, dstImageLayout, regions.size, regions write s)
    }

    fun copyImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, region: ImageCopy) = stak { s ->
        nCopyImage(srcImage, srcImageLayout, dstImage, dstImageLayout, 1, region write s)
    }

    // --- [ vkCmdCopyImageToBuffer ] ---
    fun nCopyImageToBuffer(srcImage: VkImage, srcImageLayout: VkImageLayout, dstBuffer: VkBuffer, regionCount: Int, pRegions: Ptr) =
            callPJJPV(adr, srcImage.L, srcImageLayout.i, dstBuffer.L, regionCount, pRegions, capabilities.vkCmdCopyImageToBuffer)

    fun copyImageToBuffer(srcImage: VkImage, srcImageLayout: VkImageLayout, dstBuffer: VkBuffer, regions: Array<BufferImageCopy>) = stak { s ->
        nCopyImageToBuffer(srcImage, srcImageLayout, dstBuffer, regions.size, regions write s)
    }

    fun copyImageToBuffer(srcImage: VkImage, srcImageLayout: VkImageLayout, dstBuffer: VkBuffer, region: BufferImageCopy) = stak { s ->
        nCopyImageToBuffer(srcImage, srcImageLayout, dstBuffer, 1, region write s)
    }

    // --- [ vkCmdCopyQueryPoolResults ] ---
    fun copyQueryPoolResults(queryPool: VkQueryPool, firstQuery: Int, queryCount: Int, dstBuffer: VkBuffer,
                             dstOffset: VkDeviceSize, stride: VkDeviceSize, flags: VkQueryResultFlags = 0) =
            callPJJJJV(adr, queryPool.L, firstQuery, queryCount, dstBuffer.L, dstOffset.L, stride.L, flags, capabilities.vkCmdCopyQueryPoolResults)

    // --- [ vkCmdDispatch ] ---
    fun dispatch(groupCountX: Int, groupCountY: Int, groupCountZ: Int) =
            callPV(adr, groupCountX, groupCountY, groupCountZ, capabilities.vkCmdDispatch)

    fun dispatch(groupCount: Vec3i) =
            callPV(adr, groupCount.x, groupCount.y, groupCount.z, capabilities.vkCmdDispatch)

    // --- [ vkCmdDispatchIndirect ] ---
    fun dispatchIndirect(buffer: VkBuffer, offset: VkDeviceSize) =
            callPJJV(adr, buffer.L, offset.L, capabilities.vkCmdDispatchIndirect)

    // --- [ vkCmdDraw ] ---
    fun draw(vertexCount: Int, instanceCount: Int = 1, firstVertex: Int = 0, firstInstance: Int = 0) =
            callPV(adr, vertexCount, instanceCount, firstVertex, firstInstance, capabilities.vkCmdDraw)

    // --- [ vkCmdDrawIndexed ] ---
    fun drawIndexed(indexCount: Int, instanceCount: Int, firstIndex: Int, vertexOffset: Int, firstInstance: Int) =
            callPV(adr, indexCount, instanceCount, firstIndex, vertexOffset, firstInstance, capabilities.vkCmdDrawIndexed)

    // --- [ vkCmdDrawIndexedIndirect ] ---
    fun drawIndexedIndirect(buffer: VkBuffer, offset: VkDeviceSize, drawCount: Int, stride: Int) =
            callPJJV(adr, buffer.L, offset.L, drawCount, stride, capabilities.vkCmdDrawIndexedIndirect)

    // --- [ vkCmdDrawIndirect ] ---
    fun drawIndirect(buffer: VkBuffer, offset: VkDeviceSize, drawCount: Int, stride: Int) =
            callPJJV(adr, buffer.L, offset.L, drawCount, stride, capabilities.vkCmdDrawIndirect)

    // --- [ vkCmdEndQuery ] ---
    fun endQuery(queryPool: VkQueryPool, query: Int) =
            callPJV(adr, queryPool.L, query, capabilities.vkCmdEndQuery)

    // --- [ vkCmdEndRenderPass ] ---
    fun endRenderPass() =
            callPV(adr, capabilities.vkCmdEndRenderPass)

    // --- [ vkCmdExecuteCommands ] ---
    inline fun nExecuteCommands(commandBufferCount: Int, pCommandBuffers: Ptr) =
            callPPV(adr, commandBufferCount, pCommandBuffers, capabilities.vkCmdExecuteCommands)

    fun executeCommands(commandBuffers: Array<CommandBuffer>) = stak { s ->
        callPPV(adr, commandBuffers.size, commandBuffers write s, capabilities.vkCmdExecuteCommands)
    }

    fun executeCommands(commandBuffer: CommandBuffer) = stak { s ->
        callPPV(adr, 1, s.longAdr(commandBuffer.adr), capabilities.vkCmdExecuteCommands)
    }

    // --- [ vkCmdFillBuffer ] ---
    fun fillBuffer(dstBuffer: VkBuffer, dstOffset: VkDeviceSize, size: VkDeviceSize, data: Int) =
            callPJJJV(adr, dstBuffer.L, dstOffset.L, size.L, data, capabilities.vkCmdFillBuffer)

    // --- [ vkCmdNextSubpass ] ---
    infix fun nextSubpass(contents: VkSubpassContents) =
            callPV(adr, contents.i, capabilities.vkCmdNextSubpass)

    // --- [ vkCmdPipelineBarrier ] ---
    fun nPipelineBarrier(srcStageMask: VkPipelineStageFlags, dstStageMask: VkPipelineStageFlags, dependencyFlags: VkDependencyFlags,
                         memoryBarrierCount: Int, pMemoryBarriers: Ptr, bufferMemoryBarrierCount: Int, pBufferMemoryBarriers: Ptr,
                         imageMemoryBarrierCount: Int, pImageMemoryBarriers: Ptr) =
            callPPPPV(adr, srcStageMask, dstStageMask, dependencyFlags, memoryBarrierCount, pMemoryBarriers, bufferMemoryBarrierCount, pBufferMemoryBarriers, imageMemoryBarrierCount, pImageMemoryBarriers, capabilities.vkCmdPipelineBarrier)

    fun pipelineBarrier(srcStageMask: VkPipelineStageFlags, dstStageMask: VkPipelineStageFlags, dependencyFlags: VkDependencyFlags,
                        memoryBarriers: Array<MemoryBarrier>, bufferMemoryBarriers: Array<BufferMemoryBarrier>,
                        imageMemoryBarriers: Array<ImageMemoryBarrier>) = stak { s ->
        nPipelineBarrier(srcStageMask, dstStageMask, dependencyFlags, memoryBarriers.size, memoryBarriers write s,
                bufferMemoryBarriers.size, bufferMemoryBarriers write s, imageMemoryBarriers.size, imageMemoryBarriers write s)
    }

    // --- [ vkCmdPushConstants ] ---
    fun pushConstants(layout: VkPipelineLayout, stageFlags: VkShaderStageFlags, offset: Int, size: Int, pValues: Ptr) =
            callPJPV(adr, layout.L, stageFlags, offset, size, pValues, capabilities.vkCmdPushConstants)

    // --- [ vkCmdResetEvent ] ---
    fun resetEvent(event: VkEvent, stageMask: VkPipelineStageFlags) =
            callPJV(adr, event.L, stageMask, capabilities.vkCmdResetEvent)

    // --- [ vkCmdResetQueryPool ] ---
    fun resetQueryPool(queryPool: VkQueryPool, firstQuery: Int, queryCount: Int) =
            callPJV(adr, queryPool.L, firstQuery, queryCount, capabilities.vkCmdResetQueryPool)

    // --- [ vkCmdResolveImage ] ---
    inline fun nResolveImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, regionCount: Int, pRegions: Ptr) =
            callPJJPV(adr, srcImage.L, srcImageLayout.i, dstImage.L, dstImageLayout.i, regionCount, pRegions, capabilities.vkCmdResolveImage)

    fun resolveImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, regions: Array<ImageResolve>) = stak { s ->
        nResolveImage(srcImage, srcImageLayout, dstImage, dstImageLayout, regions.size, regions write s)
    }

    fun resolveImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, region: ImageResolve) = stak { s ->
        nResolveImage(srcImage, srcImageLayout, dstImage, dstImageLayout, 1, region write s)
    }

    // --- [ vkCmdSetBlendConstants ] ---
    fun setBlendConstants(blendConstants: FloatArray) = stak { s ->
        callPPV(adr, blendConstants.toAdr(s).adr, capabilities.vkCmdSetBlendConstants)
    }

    // --- [ vkCmdSetDepthBias ] ---
    fun setDepthBias(depthBiasConstantFactor: Float, depthBiasClamp: Float, depthBiasSlopeFactor: Float) =
            callPV(adr, depthBiasConstantFactor, depthBiasClamp, depthBiasSlopeFactor, capabilities.vkCmdSetDepthBias)

    // --- [ vkCmdSetDepthBounds ] ---
    fun setDepthBounds(minDepthBounds: Float, maxDepthBounds: Float) =
            callPV(adr, minDepthBounds, maxDepthBounds, capabilities.vkCmdSetDepthBounds)

    // --- [ vkCmdSetEvent ] ---
    fun setEvent(event: VkEvent, stageMask: VkPipelineStageFlags) =
            callPJV(adr, event.L, stageMask, capabilities.vkCmdSetEvent)

    // --- [ vkCmdSetLineWidth ] ---
    infix fun setLineWidth(lineWidth: Float) =
            callPV(adr, lineWidth, capabilities.vkCmdSetLineWidth)

    // --- [ vkCmdSetScissor ] ---
    inline fun nSetScissor(firstScissor: Int, scissorCount: Int, pScissors: Ptr) =
            callPPV(adr, firstScissor, scissorCount, pScissors, capabilities.vkCmdSetScissor)

    fun setScissor(firstScissor: Int, scissors: Array<Rect2D>) =
            stak { s -> nSetScissor(firstScissor, scissors.size, scissors write s) }

    infix fun setScissor(scissors: Rect2D) =
            stak { s -> nSetScissor(0, 1, scissors write s) }

    // --- [ vkCmdSetStencilCompareMask ] ---
    fun setStencilCompareMask(faceMask: VkStencilFaceFlags, compareMask: Int) =
            callPV(adr, faceMask, compareMask, capabilities.vkCmdSetStencilCompareMask)

    // --- [ vkCmdSetStencilReference ] ---
    fun setStencilReference(faceMask: VkStencilFaceFlags, reference: Int) =
            callPV(adr, faceMask, reference, capabilities.vkCmdSetStencilReference)

    // --- [ vkCmdSetStencilWriteMask ] ---
    fun setStencilWriteMask(faceMask: VkStencilFaceFlags, writeMask: Int) =
            callPV(adr, faceMask, writeMask, capabilities.vkCmdSetStencilWriteMask)

    // --- [ vkCmdSetViewport ] ---
    inline fun nSetViewport(firstViewport: Int, viewportCount: Int, pViewports: Ptr): Unit =
            callPPV(adr, firstViewport, viewportCount, pViewports, capabilities.vkCmdSetViewport)

    infix fun setViewport(viewport: Viewport) =
            stak { s -> nSetViewport(0, 1, viewport write s) }

    fun setViewport(firstViewport: Int, viewports: Array<Viewport>) =
            stak { s -> nSetViewport(firstViewport, viewports.size, viewports write s) }

    // --- [ vkCmdUpdateBuffer ] ---
    fun updateBuffer(dstBuffer: VkBuffer, dstOffset: VkDeviceSize, dataSize: VkDeviceSize, pData: Ptr) =
            callPJJJPV(adr, dstBuffer.L, dstOffset.L, dataSize.L, pData, capabilities.vkCmdUpdateBuffer)

    // --- [ vkCmdWaitEvents ] ---
    inline fun nWaitEvents(eventCount: Int, pEvents: Ptr, srcStageMask: VkPipelineStageFlags, dstStageMask: VkPipelineStageFlags,
                           memoryBarrierCount: Int, pMemoryBarriers: Ptr, bufferMemoryBarrierCount: Int, pBufferMemoryBarriers: Ptr,
                           imageMemoryBarrierCount: Int, pImageMemoryBarriers: Ptr) =
            callPPPPPV(adr, eventCount, pEvents, srcStageMask, dstStageMask, memoryBarrierCount, pMemoryBarriers, bufferMemoryBarrierCount, pBufferMemoryBarriers, imageMemoryBarrierCount, pImageMemoryBarriers, capabilities.vkCmdWaitEvents)

    fun waitEvents(events: VkEvent_Array, srcStageMask: VkPipelineStageFlags, dstStageMask: VkPipelineStageFlags,
                   memoryBarriers: Array<MemoryBarrier>, bufferMemoryBarriers: Array<BufferMemoryBarrier>,
                   imageMemoryBarriers: Array<ImageMemoryBarrier>) = stak { s ->
        nWaitEvents(events.size, events write s, srcStageMask, dstStageMask, memoryBarriers.size, memoryBarriers write s,
                bufferMemoryBarriers.size, bufferMemoryBarriers write s, imageMemoryBarriers.size, imageMemoryBarriers write s)
    }

    // --- [ vkCmdWriteTimestamp ] ---
    fun writeTimestamp(pipelineStage: VkPipelineStage, queryPool: VkQueryPool, query: Int) =
            callPJV(adr, pipelineStage.i, queryPool.L, query, capabilities.vkCmdWriteTimestamp)

    // --- [ vkEndCommandBuffer ] ---
    fun end(): VkResult = VkResult(callPI(adr, capabilities.vkEndCommandBuffer))

    // --- [ vkResetCommandBuffer ] ---
    infix fun reset(flags: VkCommandBufferResetFlags): VkResult =
            VkResult(callPI(adr, flags, capabilities.vkResetCommandBuffer))

    // JVM
    inline fun <R> query(queryPool: VkQueryPool, query: Int, flags: VkQueryControlFlags, block: () -> R): R {
        beginQuery(queryPool, query, flags)
        return block().also {
            endQuery(queryPool, query)
        }
    }

    inline fun <R> record(beginInfo: CommandBufferBeginInfo, block: (CommandBuffer) -> R): R {
        begin(beginInfo)
        return block(this).also { end() }
    }

    inline fun <R> renderPass(
            renderPassBegin: RenderPassBeginInfo,
            contents: VkSubpassContents = VkSubpassContents.INLINE,
            block: () -> R
    ): R {
        beginRenderPass(renderPassBegin, contents)
        return block().also { endRenderPass() }
    }
}

infix fun Array<CommandBuffer>.write(stack: MemoryStack): Ptr = stack.PointerAdr(size) { this[it].adr }