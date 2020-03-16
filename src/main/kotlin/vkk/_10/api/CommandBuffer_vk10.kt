package vkk._10.api

import glm_.vec3.Vec3i
import vkk.identifiers.CapabilitiesDevice
import vkk.identifiers.CommandBuffer
import kool.*
import org.lwjgl.system.JNI.*
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.system.Pointer
import vkk.*
import vkk._10.structs.*
import vkk.entities.*

interface CommandBuffer_vk10 : Pointer {

    val capabilities: CapabilitiesDevice

    // --- [ vkBeginCommandBuffer ] ---

    infix fun MemoryStack.begin(beginInfo: CommandBufferBeginInfo): VkResult =
            framed { VkResult(callPPI(adr, beginInfo write this, capabilities.vkBeginCommandBuffer)).andCheck() }

    infix fun begin(beginInfo: CommandBufferBeginInfo): VkResult =
            stak { it begin beginInfo }

    // --- [ vkCmdBeginQuery ] ---
    fun beginQuery(queryPool: VkQueryPool, query: Int, flags: VkQueryControlFlags) =
            callPJV(adr, queryPool.L, query, flags, capabilities.vkCmdBeginQuery)

    // --- [ vkCmdBeginRenderPass ] ---

    fun MemoryStack.beginRenderPass(renderPassBegin: RenderPassBeginInfo, contents: VkSubpassContents = VkSubpassContents.INLINE) =
            framed { callPPV(this@CommandBuffer_vk10.adr, renderPassBegin write this, contents.i, capabilities.vkCmdBeginRenderPass) }

    fun beginRenderPass(renderPassBegin: RenderPassBeginInfo, contents: VkSubpassContents = VkSubpassContents.INLINE) =
            stak { it.beginRenderPass(renderPassBegin, contents) }

    // --- [ vkCmdBindDescriptorSets ] ---

    fun MemoryStack.bindDescriptorSets(pipelineBindPoint: VkPipelineBindPoint, layout: VkPipelineLayout, firstSet: Int, descriptorSets: VkDescriptorSet_Array, dynamicOffsets: IntArray) =
            framed { nBindDescriptorSets(pipelineBindPoint, layout, firstSet, descriptorSets.size, descriptorSets write this, dynamicOffsets.size, dynamicOffsets.toAdr(this).adr) }

    fun bindDescriptorSets(pipelineBindPoint: VkPipelineBindPoint, layout: VkPipelineLayout, firstSet: Int, descriptorSets: VkDescriptorSet_Array, dynamicOffsets: IntArray) =
            stak { it.bindDescriptorSets(pipelineBindPoint, layout, firstSet, descriptorSets, dynamicOffsets) }

    fun MemoryStack.bindDescriptorSets(pipelineBindPoint: VkPipelineBindPoint, layout: VkPipelineLayout, firstSet: Int, descriptorSet: VkDescriptorSet, dynamicOffset: Int) =
            framed { nBindDescriptorSets(pipelineBindPoint, layout, firstSet, 1, this.longAdr(descriptorSet.L), 1, this.intAdr(dynamicOffset)) }

    fun bindDescriptorSets(pipelineBindPoint: VkPipelineBindPoint, layout: VkPipelineLayout, firstSet: Int, descriptorSet: VkDescriptorSet, dynamicOffset: Int) =
            stak { it.bindDescriptorSets(pipelineBindPoint, layout, firstSet, descriptorSet, dynamicOffset) }

    // --- [ vkCmdBindIndexBuffer ] ---
    fun bindIndexBuffer(buffer: VkBuffer, offset: VkDeviceSize, indexType: VkIndexType) =
            callPJJV(adr, buffer.L, offset.L, indexType.i, capabilities.vkCmdBindIndexBuffer)

    // --- [ vkCmdBindPipeline ] ---
    fun bindPipeline(pipelineBindPoint: VkPipelineBindPoint, pipeline: VkPipeline) =
            callPJV(adr, pipelineBindPoint.i, pipeline.L, capabilities.vkCmdBindPipeline)

    // --- [ vkCmdBindVertexBuffers ] ---

    fun MemoryStack.bindVertexBuffers(firstBinding: Int, bindingCount: Int, buffers: VkBuffer_Array, offsets: VkDeviceSize_Array) =
            framed { nBindVertexBuffers(firstBinding, bindingCount, buffers write this, offsets write this) }

    fun bindVertexBuffers(firstBinding: Int, bindingCount: Int, buffers: VkBuffer_Array, offsets: VkDeviceSize_Array) =
            stak { it.bindVertexBuffers(firstBinding, bindingCount, buffers, offsets) }


    fun MemoryStack.bindVertexBuffers(firstBinding: Int, bindingCount: Int, buffer: VkBuffer, offset: VkDeviceSize) =
            framed { nBindVertexBuffers(firstBinding, bindingCount, this.longAdr(buffer.L), this.longAdr(offset.L)) }

    fun bindVertexBuffers(firstBinding: Int, bindingCount: Int, buffer: VkBuffer, offset: VkDeviceSize) =
            stak { it.bindVertexBuffers(firstBinding, bindingCount, buffer, offset) }


    fun MemoryStack.bindVertexBuffers(buffer: VkBuffer, offset: VkDeviceSize = VkDeviceSize.NULL) =
            framed { nBindVertexBuffers(0, 1, this.longAdr(buffer.L), this.longAdr(offset.L)) }

    fun bindVertexBuffers(buffer: VkBuffer, offset: VkDeviceSize = VkDeviceSize.NULL) =
            stak { it.bindVertexBuffers(0, 1, buffer, offset) }


    fun MemoryStack.bindVertexBuffers(firstBinding: Int, buffers: VkBuffer_Array, offsets: VkDeviceSize_Array) =
            framed { nBindVertexBuffers(firstBinding, buffers.size, buffers write this, offsets write this) }

    fun bindVertexBuffers(firstBinding: Int, buffers: VkBuffer_Array, offsets: VkDeviceSize_Array) =
            stak { it.bindVertexBuffers(firstBinding, buffers.size, buffers, offsets) }

    // --- [ vkCmdBlitImage ] ---

    fun MemoryStack.blitImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, regions: Array<ImageBlit>, filter: VkFilter) =
            framed { nBlitImage(srcImage, srcImageLayout, dstImage, dstImageLayout, regions.size, regions write this, filter) }

    fun blitImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, regions: Array<ImageBlit>, filter: VkFilter) =
            stak { it.blitImage(srcImage, srcImageLayout, dstImage, dstImageLayout, regions, filter) }

    fun MemoryStack.blitImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, region: ImageBlit, filter: VkFilter) =
            framed { nBlitImage(srcImage, srcImageLayout, dstImage, dstImageLayout, 1, region write this, filter) }

    fun blitImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, region: ImageBlit, filter: VkFilter) =
            stak { it.blitImage(srcImage, srcImageLayout, dstImage, dstImageLayout, region, filter) }

    // --- [ vkCmdClearAttachments ] ---

    fun MemoryStack.clearAttachments(attachments: Array<ClearAttachment>, rects: Array<ClearRect>) =
            framed { nClearAttachments(attachments.size, attachments write this, rects.size, rects write this) }

    fun clearAttachments(attachments: Array<ClearAttachment>, rects: Array<ClearRect>) =
            stak { it.clearAttachments(attachments, rects) }

    fun MemoryStack.clearAttachments(attachment: ClearAttachment, rect: ClearRect) =
            framed { nClearAttachments(1, attachment write this, 1, rect write this) }

    fun clearAttachments(attachment: ClearAttachment, rect: ClearRect) =
            stak { it.clearAttachments(attachment, rect) }

    // --- [ vkCmdClearColorImage ] ---

    fun MemoryStack.clearColorImage(image: VkImage, imageLayout: VkImageLayout, color: ClearColorValue, ranges: Array<ImageSubresourceRange>) =
            framed { nClearColorImage(image, imageLayout, color write this, ranges.size, ranges write this) }

    fun clearColorImage(image: VkImage, imageLayout: VkImageLayout, color: ClearColorValue, ranges: Array<ImageSubresourceRange>) =
            stak { it.clearColorImage(image, imageLayout, color, ranges) }


    fun MemoryStack.clearColorImage(image: VkImage, imageLayout: VkImageLayout, color: ClearColorValue, range: ImageSubresourceRange) =
            framed { nClearColorImage(image, imageLayout, color write this, 1, range write this) }

    fun clearColorImage(image: VkImage, imageLayout: VkImageLayout, color: ClearColorValue, range: ImageSubresourceRange) =
            stak { it.clearColorImage(image, imageLayout, color, range) }

    // --- [ vkCmdClearDepthStencilImage ] ---

    fun MemoryStack.clearDepthStencilImage(image: VkImage, imageLayout: VkImageLayout, depthStencil: ClearDepthStencilValue, ranges: Array<ImageSubresourceRange>) =
            framed { nClearDepthStencilImage(image, imageLayout, depthStencil write this, ranges.size, ranges write this) }

    fun clearDepthStencilImage(image: VkImage, imageLayout: VkImageLayout, depthStencil: ClearDepthStencilValue, ranges: Array<ImageSubresourceRange>) =
            stak { it.clearDepthStencilImage(image, imageLayout, depthStencil, ranges) }


    fun MemoryStack.clearDepthStencilImage(image: VkImage, imageLayout: VkImageLayout, depthStencil: ClearDepthStencilValue, range: ImageSubresourceRange) =
            framed { nClearDepthStencilImage(image, imageLayout, depthStencil write this, 1, range write this) }

    fun clearDepthStencilImage(image: VkImage, imageLayout: VkImageLayout, depthStencil: ClearDepthStencilValue, range: ImageSubresourceRange) =
            stak { it.clearDepthStencilImage(image, imageLayout, depthStencil, range) }


    // --- [ vkCmdCopyBuffer ] ---

    fun MemoryStack.copyBuffer(srcBuffer: VkBuffer, dstBuffer: VkBuffer, regions: Array<BufferCopy>) =
            framed { nCopyBuffer(srcBuffer, dstBuffer, regions.size, regions write this) }

    fun copyBuffer(srcBuffer: VkBuffer, dstBuffer: VkBuffer, regions: Array<BufferCopy>) =
            stak { it.copyBuffer(srcBuffer, dstBuffer, regions) }


    fun MemoryStack.copyBuffer(srcBuffer: VkBuffer, dstBuffer: VkBuffer, region: BufferCopy) =
            framed { nCopyBuffer(srcBuffer, dstBuffer, 1, region write this) }

    fun copyBuffer(srcBuffer: VkBuffer, dstBuffer: VkBuffer, region: BufferCopy) =
            stak { it.copyBuffer(srcBuffer, dstBuffer, region) }


    // --- [ vkCmdCopyBufferToImage ] ---

    fun MemoryStack.copyBufferToImage(srcBuffer: VkBuffer, dstImage: VkImage, dstImageLayout: VkImageLayout, regions: Array<BufferImageCopy>) =
            framed { nCopyBufferToImage(srcBuffer, dstImage, dstImageLayout, regions.size, regions write this) }

    fun copyBufferToImage(srcBuffer: VkBuffer, dstImage: VkImage, dstImageLayout: VkImageLayout, regions: Array<BufferImageCopy>) =
            stak { it.copyBufferToImage(srcBuffer, dstImage, dstImageLayout, regions) }


    fun MemoryStack.copyBufferToImage(srcBuffer: VkBuffer, dstImage: VkImage, dstImageLayout: VkImageLayout, region: BufferImageCopy) =
            framed { nCopyBufferToImage(srcBuffer, dstImage, dstImageLayout, 1, region write this) }

    fun copyBufferToImage(srcBuffer: VkBuffer, dstImage: VkImage, dstImageLayout: VkImageLayout, region: BufferImageCopy) =
            stak { it.copyBufferToImage(srcBuffer, dstImage, dstImageLayout, region) }

    // --- [ vkCmdCopyImage ] ---

    fun MemoryStack.copyImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, regions: Array<ImageCopy>) =
            framed { nCopyImage(srcImage, srcImageLayout, dstImage, dstImageLayout, regions.size, regions write this) }

    fun copyImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, regions: Array<ImageCopy>) =
            stak { it.copyImage(srcImage, srcImageLayout, dstImage, dstImageLayout, regions) }


    fun MemoryStack.copyImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, region: ImageCopy) =
            framed { nCopyImage(srcImage, srcImageLayout, dstImage, dstImageLayout, 1, region write this) }

    fun copyImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, region: ImageCopy) =
            stak { it.copyImage(srcImage, srcImageLayout, dstImage, dstImageLayout, region) }

    // --- [ vkCmdCopyImageToBuffer ] ---

    fun MemoryStack.copyImageToBuffer(srcImage: VkImage, srcImageLayout: VkImageLayout, dstBuffer: VkBuffer, regions: Array<BufferImageCopy>) =
            framed { nCopyImageToBuffer(srcImage, srcImageLayout, dstBuffer, regions.size, regions write this) }

    fun copyImageToBuffer(srcImage: VkImage, srcImageLayout: VkImageLayout, dstBuffer: VkBuffer, regions: Array<BufferImageCopy>) =
            stak { it.copyImageToBuffer(srcImage, srcImageLayout, dstBuffer, regions) }


    fun MemoryStack.copyImageToBuffer(srcImage: VkImage, srcImageLayout: VkImageLayout, dstBuffer: VkBuffer, region: BufferImageCopy) =
            framed { nCopyImageToBuffer(srcImage, srcImageLayout, dstBuffer, 1, region write this) }

    fun copyImageToBuffer(srcImage: VkImage, srcImageLayout: VkImageLayout, dstBuffer: VkBuffer, region: BufferImageCopy) =
            stak { it.copyImageToBuffer(srcImage, srcImageLayout, dstBuffer, region) }

    // --- [ vkCmdCopyQueryPoolResults ] ---
    fun copyQueryPoolResults(queryPool: VkQueryPool, firstQuery: Int, queryCount: Int, dstBuffer: VkBuffer, dstOffset: VkDeviceSize, stride: VkDeviceSize, flags: VkQueryResultFlags = 0) =
            callPJJJJV(adr, queryPool.L, firstQuery, queryCount, dstBuffer.L, dstOffset.L, stride.L, flags, capabilities.vkCmdCopyQueryPoolResults)

    // --- [ vkCmdDispatch ] ---

    fun dispatch(groupCountX: Int, groupCountY: Int, groupCountZ: Int) =
            nDispatch(groupCountX, groupCountY, groupCountZ)

    fun dispatch(groupCount: Vec3i) =
            nDispatch(groupCount.x, groupCount.y, groupCount.z)

    // --- [ vkCmdDispatchIndirect ] ---
    fun dispatchIndirect(buffer: VkBuffer, offset: VkDeviceSize) =
            callPJJV(adr, buffer.L, offset.L, capabilities.vkCmdDispatchIndirect)

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

    infix fun MemoryStack.executeCommands(commandBuffers: Array<CommandBuffer>) =
            framed { nExecuteCommands(commandBuffers.size, commandBuffers write this) }

    infix fun executeCommands(commandBuffers: Array<CommandBuffer>) =
            stak { it executeCommands commandBuffers }


    infix fun MemoryStack.executeCommands(commandBuffer: CommandBuffer) =
            framed { nExecuteCommands(1, this.longAdr(commandBuffer.adr)) }

    infix fun executeCommands(commandBuffer: CommandBuffer) =
            stak { it executeCommands commandBuffer }

    // --- [ vkCmdFillBuffer ] ---
    fun fillBuffer(dstBuffer: VkBuffer, dstOffset: VkDeviceSize, size: VkDeviceSize, data: Int) =
            callPJJJV(adr, dstBuffer.L, dstOffset.L, size.L, data, capabilities.vkCmdFillBuffer)

    // --- [ vkCmdNextSubpass ] ---
    infix fun nextSubpass(contents: VkSubpassContents) =
            callPV(adr, contents.i, capabilities.vkCmdNextSubpass)

    // --- [ vkCmdPipelineBarrier ] ---

    fun MemoryStack.pipelineBarrier(srcStageMask: VkPipelineStageFlags, dstStageMask: VkPipelineStageFlags, dependencyFlags: VkDependencyFlags, memoryBarriers: Array<MemoryBarrier>? = null,
                                    bufferMemoryBarriers: Array<BufferMemoryBarrier>? = null, imageMemoryBarriers: Array<ImageMemoryBarrier>? = null) =
            framed {
                nPipelineBarrier(srcStageMask, dstStageMask, dependencyFlags,
                        memoryBarriers?.size ?: 0, memoryBarriers?.write(this) ?: NULL,
                        bufferMemoryBarriers?.size ?: 0, bufferMemoryBarriers?.write(this) ?: NULL,
                        imageMemoryBarriers?.size ?: 0, imageMemoryBarriers?.write(this) ?: NULL)
            }

    fun pipelineBarrier(srcStageMask: VkPipelineStageFlags, dstStageMask: VkPipelineStageFlags, dependencyFlags: VkDependencyFlags,
                        memoryBarriers: Array<MemoryBarrier>? = null, bufferMemoryBarriers: Array<BufferMemoryBarrier>? = null,
                        imageMemoryBarriers: Array<ImageMemoryBarrier>? = null) =
            stak { it.pipelineBarrier(srcStageMask, dstStageMask, dependencyFlags, memoryBarriers, bufferMemoryBarriers, imageMemoryBarriers) }


    fun MemoryStack.pipelineBarrier(srcStageMask: VkPipelineStageFlags, dstStageMask: VkPipelineStageFlags, dependencyFlags: VkDependencyFlags,
                                    memoryBarrier: MemoryBarrier? = null, bufferMemoryBarrier: BufferMemoryBarrier? = null, imageMemoryBarrier: ImageMemoryBarrier? = null) =
            framed {
                nPipelineBarrier(srcStageMask, dstStageMask, dependencyFlags,
                        if (memoryBarrier != null) 1 else 0, memoryBarrier?.write(this) ?: NULL,
                        if (bufferMemoryBarrier != null) 1 else 0, bufferMemoryBarrier?.write(this) ?: NULL,
                        if (imageMemoryBarrier != null) 1 else 0, imageMemoryBarrier?.write(this) ?: NULL)
            }

    fun pipelineBarrier(srcStageMask: VkPipelineStageFlags, dstStageMask: VkPipelineStageFlags, dependencyFlags: VkDependencyFlags,
                        memoryBarrier: MemoryBarrier? = null, bufferMemoryBarrier: BufferMemoryBarrier? = null, imageMemoryBarrier: ImageMemoryBarrier? = null) =
            stak { it.pipelineBarrier(srcStageMask, dstStageMask, dependencyFlags, memoryBarrier, bufferMemoryBarrier, imageMemoryBarrier) }


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

    fun MemoryStack.resolveImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, regions: Array<ImageResolve>) =
            framed { nResolveImage(srcImage, srcImageLayout, dstImage, dstImageLayout, regions.size, regions write this) }

    fun resolveImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, regions: Array<ImageResolve>) =
            stak { it.resolveImage(srcImage, srcImageLayout, dstImage, dstImageLayout, regions) }


    fun MemoryStack.resolveImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, region: ImageResolve) =
            framed { nResolveImage(srcImage, srcImageLayout, dstImage, dstImageLayout, 1, region write this) }

    fun resolveImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, region: ImageResolve) =
            stak { it.resolveImage(srcImage, srcImageLayout, dstImage, dstImageLayout, region) }

    // --- [ vkCmdSetBlendConstants ] ---

    infix fun MemoryStack.setBlendConstants(blendConstants: FloatArray) =
            framed{ nSetBlendConstants(blendConstants.toAdr(this).adr) }

    infix fun setBlendConstants(blendConstants: FloatArray) =
            stak { it setBlendConstants blendConstants }

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

    fun MemoryStack.setScissor(firstScissor: Int, scissors: Array<Rect2D>) =
            framed { nSetScissor(firstScissor, scissors.size, scissors write this) }

    fun setScissor(firstScissor: Int, scissors: Array<Rect2D>) =
            stak { it.setScissor(firstScissor, scissors) }


    infix fun MemoryStack.setScissor(scissors: Rect2D) =
            framed { nSetScissor(0, 1, scissors write this) }

    infix fun setScissor(scissors: Rect2D) =
            stak { it setScissor scissors }

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

    infix fun MemoryStack.setViewport(viewport: Viewport) =
            framed { nSetViewport(0, 1, viewport write this) }

    infix fun setViewport(viewport: Viewport) =
            stak { it setViewport viewport }


    fun MemoryStack.setViewport(firstViewport: Int, viewports: Array<Viewport>) =
            framed { nSetViewport(firstViewport, viewports.size, viewports write this) }

    fun setViewport(firstViewport: Int, viewports: Array<Viewport>) =
            stak { it.setViewport(firstViewport, viewports) }

    // --- [ vkCmdUpdateBuffer ] ---
    fun updateBuffer(dstBuffer: VkBuffer, dstOffset: VkDeviceSize, dataSize: VkDeviceSize, pData: Ptr) =
            callPJJJPV(adr, dstBuffer.L, dstOffset.L, dataSize.L, pData, capabilities.vkCmdUpdateBuffer)

    // --- [ vkCmdWaitEvents ] ---

    fun MemoryStack.waitEvents(events: VkEvent_Array, srcStageMask: VkPipelineStageFlags, dstStageMask: VkPipelineStageFlags,
                               memoryBarriers: Array<MemoryBarrier>, bufferMemoryBarriers: Array<BufferMemoryBarrier>,
                               imageMemoryBarriers: Array<ImageMemoryBarrier>) =
            framed {
                nWaitEvents(events.size, events write this, srcStageMask, dstStageMask, memoryBarriers.size, memoryBarriers write this,
                        bufferMemoryBarriers.size, bufferMemoryBarriers write this, imageMemoryBarriers.size, imageMemoryBarriers write this)
            }

    fun waitEvents(events: VkEvent_Array, srcStageMask: VkPipelineStageFlags, dstStageMask: VkPipelineStageFlags,
                   memoryBarriers: Array<MemoryBarrier>, bufferMemoryBarriers: Array<BufferMemoryBarrier>,
                   imageMemoryBarriers: Array<ImageMemoryBarrier>) =
            stak { it.waitEvents(events, srcStageMask, dstStageMask, memoryBarriers, bufferMemoryBarriers, imageMemoryBarriers) }

    // --- [ vkCmdWriteTimestamp ] ---
    fun writeTimestamp(pipelineStage: VkPipelineStage, queryPool: VkQueryPool, query: Int) =
            callPJV(adr, pipelineStage.i, queryPool.L, query, capabilities.vkCmdWriteTimestamp)

    // --- [ vkEndCommandBuffer ] ---
    fun end(): VkResult =
            VkResult(callPI(adr, capabilities.vkEndCommandBuffer)).andCheck()

    // --- [ vkResetCommandBuffer ] ---
    infix fun reset(flags: VkCommandBufferResetFlags): VkResult =
            VkResult(callPI(adr, flags, capabilities.vkResetCommandBuffer)).andCheck()
}


private inline fun CommandBuffer_vk10.nBindDescriptorSets(pipelineBindPoint: VkPipelineBindPoint, layout: VkPipelineLayout, firstSet: Int, descriptorSetCount: Int, pDescriptorSets: Ptr, dynamicOffsetCount: Int, pDynamicOffsets: Ptr) =
        callPJPPV(adr, pipelineBindPoint.i, layout.L, firstSet, descriptorSetCount, pDescriptorSets, dynamicOffsetCount, pDynamicOffsets, capabilities.vkCmdBindDescriptorSets)

private inline fun CommandBuffer_vk10.nBindVertexBuffers(firstBinding: Int, bindingCount: Int, pBuffers: Ptr, pOffsets: Ptr) =
        callPPPV(adr, firstBinding, bindingCount, pBuffers, pOffsets, capabilities.vkCmdBindVertexBuffers)

private inline fun CommandBuffer_vk10.nBlitImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, regionCount: Int, pRegions: Ptr, filter: VkFilter) =
        callPJJPV(adr, srcImage.L, srcImageLayout.i, dstImage.L, dstImageLayout.i, regionCount, pRegions, filter.i, capabilities.vkCmdBlitImage)

private inline fun CommandBuffer_vk10.nClearAttachments(attachmentCount: Int, pAttachments: Ptr, rectCount: Int, pRects: Ptr) =
        callPPPV(adr, attachmentCount, pAttachments, rectCount, pRects, capabilities.vkCmdClearAttachments)

private inline fun CommandBuffer_vk10.nClearColorImage(image: VkImage, imageLayout: VkImageLayout, pColor: Ptr, rangeCount: Int, pRanges: Ptr) =
        callPJPPV(adr, image.L, imageLayout.i, pColor, rangeCount, pRanges, capabilities.vkCmdClearColorImage)

private inline fun CommandBuffer_vk10.nClearDepthStencilImage(image: VkImage, imageLayout: VkImageLayout, pDepthStencil: Ptr, rangeCount: Int, pRanges: Ptr) =
        callPJPPV(adr, image.L, imageLayout.i, pDepthStencil, rangeCount, pRanges, capabilities.vkCmdClearDepthStencilImage)

private inline fun CommandBuffer_vk10.nCopyBuffer(srcBuffer: VkBuffer, dstBuffer: VkBuffer, regionCount: Int, pRegions: Ptr) =
        callPJJPV(adr, srcBuffer.L, dstBuffer.L, regionCount, pRegions, capabilities.vkCmdCopyBuffer)

private inline fun CommandBuffer_vk10.nCopyBufferToImage(srcBuffer: VkBuffer, dstImage: VkImage, dstImageLayout: VkImageLayout, regionCount: Int, pRegions: Ptr) =
        callPJJPV(adr, srcBuffer.L, dstImage.L, dstImageLayout.i, regionCount, pRegions, capabilities.vkCmdCopyBufferToImage)

private inline fun CommandBuffer_vk10.nCopyImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, regionCount: Int, pRegions: Ptr) =
        callPJJPV(adr, srcImage.L, srcImageLayout.i, dstImage.L, dstImageLayout.i, regionCount, pRegions, capabilities.vkCmdCopyImage)

private inline fun CommandBuffer_vk10.nCopyImageToBuffer(srcImage: VkImage, srcImageLayout: VkImageLayout, dstBuffer: VkBuffer, regionCount: Int, pRegions: Ptr) =
        callPJJPV(adr, srcImage.L, srcImageLayout.i, dstBuffer.L, regionCount, pRegions, capabilities.vkCmdCopyImageToBuffer)

private inline fun CommandBuffer_vk10.nDispatch(groupCountX: Int, groupCountY: Int, groupCountZ: Int) =
        callPV(adr, groupCountX, groupCountY, groupCountZ, capabilities.vkCmdDispatch)

private inline fun CommandBuffer_vk10.nExecuteCommands(commandBufferCount: Int, pCommandBuffers: Ptr) =
        callPPV(adr, commandBufferCount, pCommandBuffers, capabilities.vkCmdExecuteCommands)

private inline fun CommandBuffer_vk10.nPipelineBarrier(srcStageMask: VkPipelineStageFlags, dstStageMask: VkPipelineStageFlags, dependencyFlags: VkDependencyFlags, memoryBarrierCount: Int, pMemoryBarriers: Ptr,
                                                       bufferMemoryBarrierCount: Int, pBufferMemoryBarriers: Ptr, imageMemoryBarrierCount: Int, pImageMemoryBarriers: Ptr) =
        callPPPPV(adr, srcStageMask, dstStageMask, dependencyFlags, memoryBarrierCount, pMemoryBarriers, bufferMemoryBarrierCount, pBufferMemoryBarriers, imageMemoryBarrierCount, pImageMemoryBarriers, capabilities.vkCmdPipelineBarrier)

private inline fun CommandBuffer_vk10.nResolveImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, regionCount: Int, pRegions: Ptr) =
        callPJJPV(adr, srcImage.L, srcImageLayout.i, dstImage.L, dstImageLayout.i, regionCount, pRegions, capabilities.vkCmdResolveImage)

private inline fun CommandBuffer_vk10.nSetBlendConstants(blendConstants: Ptr) =
    callPPV(adr, blendConstants, capabilities.vkCmdSetBlendConstants)

private inline fun CommandBuffer_vk10.nSetScissor(firstScissor: Int, scissorCount: Int, pScissors: Ptr) =
        callPPV(adr, firstScissor, scissorCount, pScissors, capabilities.vkCmdSetScissor)

private inline fun CommandBuffer_vk10.nSetViewport(firstViewport: Int, viewportCount: Int, pViewports: Ptr): Unit =
        callPPV(adr, firstViewport, viewportCount, pViewports, capabilities.vkCmdSetViewport)

private inline fun CommandBuffer_vk10.nWaitEvents(eventCount: Int, pEvents: Ptr, srcStageMask: VkPipelineStageFlags, dstStageMask: VkPipelineStageFlags,
                                                  memoryBarrierCount: Int, pMemoryBarriers: Ptr, bufferMemoryBarrierCount: Int, pBufferMemoryBarriers: Ptr, imageMemoryBarrierCount: Int, pImageMemoryBarriers: Ptr) =
        callPPPPPV(adr, eventCount, pEvents, srcStageMask, dstStageMask, memoryBarrierCount, pMemoryBarriers, bufferMemoryBarrierCount, pBufferMemoryBarriers, imageMemoryBarrierCount, pImageMemoryBarriers, capabilities.vkCmdWaitEvents)