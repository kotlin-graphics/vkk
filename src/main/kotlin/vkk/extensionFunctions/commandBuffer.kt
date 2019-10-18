package vkk.extensionFunctions

import glm_.*
import glm_.vec2.Vec2i
import glm_.vec3.Vec3i
import kool.*
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.system.Pointer
import org.lwjgl.vulkan.*
import vkk.*
import vkk.entities.*
import java.nio.Buffer
import java.nio.FloatBuffer
import java.nio.IntBuffer


infix fun VkCommandBuffer.begin(beginInfo: VkCommandBufferBeginInfo): VkResult =
        VkResult(VK10.nvkBeginCommandBuffer(this, beginInfo.adr)).apply { check() }

/** JVM custom */
fun VkCommandBuffer.begin(flags: VkCommandBufferUsageFlags = VkCommandBufferUsage.SIMULTANEOUS_USE_BIT.i): VkResult =
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

fun VkCommandBuffer.beginTransformFeedbackEXT(firstCounterBuffer: Int, counterBuffers: VkBuffer_Buffer?,
                                              counterBufferOffsets: VkDeviceSize_Buffer?) =
        EXTTransformFeedback.nvkCmdBeginTransformFeedbackEXT(this, firstCounterBuffer, counterBuffers?.rem
                ?: 0, counterBuffers?.adr ?: NULL, counterBufferOffsets?.adr ?: NULL)

fun VkCommandBuffer.bindDescriptorSets(pipelineBindPoint: VkPipelineBindPoint,
                                       layout: VkPipelineLayout,
                                       descriptorSets: VkDescriptorSet_Buffer,
                                       dynamicOffsets: IntBuffer) =
        VK10.nvkCmdBindDescriptorSets(this, pipelineBindPoint.i, layout.L, 0, descriptorSets.rem, descriptorSets.adr, dynamicOffsets.rem, dynamicOffsets.adr)

fun VkCommandBuffer.bindDescriptorSets(pipelineBindPoint: VkPipelineBindPoint,
                                       layout: VkPipelineLayout,
                                       firstSet: Int,
                                       descriptorSets: VkDescriptorSet_Buffer,
                                       dynamicOffsets: IntBuffer) =
        VK10.nvkCmdBindDescriptorSets(this, pipelineBindPoint.i, layout.L, firstSet, descriptorSets.rem, descriptorSets.adr, dynamicOffsets.rem, dynamicOffsets.adr)

fun VkCommandBuffer.bindDescriptorSets(pipelineBindPoint: VkPipelineBindPoint, layout: VkPipelineLayout,
                                       descriptorSet: VkDescriptorSet, dynamicOffsets: Int? = null) =
        stak {
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

fun VkCommandBuffer.bindTransformFeedbackBuffersEXT(firstBinding: Int, buffers: VkBuffer_Buffer, offsets: VkDeviceSize_Buffer, sizes: VkDeviceSize_Buffer? = null) =
        EXTTransformFeedback.nvkCmdBindTransformFeedbackBuffersEXT(this, firstBinding, buffers.rem, buffers.adr, offsets.adr, sizes?.adr
                ?: NULL)

infix fun VkCommandBuffer.bindVertexBuffers(buffer: VkBuffer) = bindVertexBuffers(0, buffer)

// TODO remove firstBinding?
fun VkCommandBuffer.bindVertexBuffers(firstBinding: Int, buffer: VkBuffer, offset: VkDeviceSize = VkDeviceSize(0)) =
        stak {
            val pBuffer = it.nmalloc(8, Long.BYTES)
            memPutLong(pBuffer, buffer.L)
            val pOffset = it.nmalloc(8, Long.BYTES)
            memPutLong(pOffset, offset.L)
            VK10.nvkCmdBindVertexBuffers(this, firstBinding, 1, pBuffer, pOffset)
        }

fun VkCommandBuffer.bindVertexBuffers(firstBinding: Int, buffer: VkBuffer_Buffer, offset: VkDeviceSize_Buffer) =
        VK10.nvkCmdBindVertexBuffers(this, firstBinding, buffer.rem, buffer.adr, offset.adr)

fun VkCommandBuffer.blitImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, region: VkImageBlit, filter: VkFilter) =
        VK10.nvkCmdBlitImage(this, srcImage.L, srcImageLayout.i, dstImage.L, dstImageLayout.i, 1, region.adr, filter.i)

fun VkCommandBuffer.buildAccelerationStructureNV(info: VkAccelerationStructureInfoNV, instanceData: VkBuffer, instanceOffset: VkDeviceSize, update: Boolean, dst: VkAccelerationStructureNV, src: VkAccelerationStructureNV, scratch: VkBuffer, scratchOffset: VkDeviceSize) =
        NVRayTracing.nvkCmdBuildAccelerationStructureNV(this, info.adr, instanceData.L, instanceOffset.L, update.i, dst.L, src.L, scratch.L, scratchOffset.L)

fun VkCommandBuffer.clearAttachments(attachments: VkClearAttachment.Buffer, rects: VkClearRect.Buffer) =
        VK10.nvkCmdClearAttachments(this, attachments.rem, attachments.adr, rects.rem, rects.adr)

fun VkCommandBuffer.clearColorImage(image: VkImage, imageLayout: VkImageLayout, color: VkClearColorValue, range: VkImageSubresourceRange) =
        VK10.nvkCmdClearColorImage(this, image.L, imageLayout.i, color.adr, 1, range.adr)

fun VkCommandBuffer.clearColorImage(image: VkImage, imageLayout: VkImageLayout, color: VkClearColorValue, ranges: VkImageSubresourceRange.Buffer) =
        VK10.nvkCmdClearColorImage(this, image.L, imageLayout.i, color.adr, ranges.rem, ranges.adr)

fun VkCommandBuffer.clearDepthStencilImage(image: VkImage, imageLayout: VkImageLayout, depthStencil: VkClearDepthStencilValue, range: VkImageSubresourceRange) =
        VK10.nvkCmdClearDepthStencilImage(this, image.L, imageLayout.i, depthStencil.adr, 1, range.adr)

fun VkCommandBuffer.clearDepthStencilImage(image: VkImage, imageLayout: VkImageLayout, depthStencil: VkClearDepthStencilValue, ranges: VkImageSubresourceRange.Buffer) =
        VK10.nvkCmdClearDepthStencilImage(this, image.L, imageLayout.i, depthStencil.adr, ranges.rem, ranges.adr)

fun VkCommandBuffer.copyAccelerationStructureNV(dst: VkAccelerationStructureNV, src: VkAccelerationStructureNV, mode: VkCopyAccelerationStructureModeNV) =
        NVRayTracing.vkCmdCopyAccelerationStructureNV(this, dst.L, src.L, mode.i)

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

fun VkCommandBuffer.copyImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, regions: VkImageCopy.Buffer) =
        VK10.nvkCmdCopyImage(this, srcImage.L, srcImageLayout.i, dstImage.L, dstImageLayout.i, regions.rem, regions.adr)

fun VkCommandBuffer.copyImageToBuffer(srcImage: VkImage, srcImageLayout: VkImageLayout, dstBuffer: VkBuffer, region: VkBufferImageCopy) =
        VK10.nvkCmdCopyImageToBuffer(this, srcImage.L, srcImageLayout.i, dstBuffer.L, 1, region.adr)

fun VkCommandBuffer.copyImageToBuffer(srcImage: VkImage, srcImageLayout: VkImageLayout, dstBuffer: VkBuffer, regions: VkBufferImageCopy.Buffer) =
        VK10.nvkCmdCopyImageToBuffer(this, srcImage.L, srcImageLayout.i, dstBuffer.L, regions.rem, regions.adr)

fun VkCommandBuffer.copyQueryPoolResults(queryPool: VkQueryPool, firstQuery: Int, queryCount: Int, dstBuffer: VkBuffer, dstOffset: VkDeviceSize, stride: VkDeviceSize, flags: VkQueryResultFlags) =
        VK10.vkCmdCopyQueryPoolResults(this, queryPool.L, firstQuery, queryCount, dstBuffer.L, dstOffset.L, stride.L, flags)

infix fun VkCommandBuffer.debugMarkerBeginEXT(markerInfo: VkDebugMarkerMarkerInfoEXT) =
        EXTDebugMarker.nvkCmdDebugMarkerBeginEXT(this, markerInfo.adr)

fun VkCommandBuffer.debugMarkerEndEXT() =
        EXTDebugMarker.vkCmdDebugMarkerEndEXT(this)

fun VkCommandBuffer.debugMarkerInsertEXT(markerInfo: VkDebugMarkerMarkerInfoEXT) =
        EXTDebugMarker.nvkCmdDebugMarkerInsertEXT(this, markerInfo.adr)

infix fun VkCommandBuffer.debugMarkerInsert(markerInfo: VkDebugMarkerMarkerInfoEXT) = EXTDebugMarker.nvkCmdDebugMarkerInsertEXT(this, markerInfo.adr)

fun VkCommandBuffer.dispatch(groupCountXYZ: Vec3i) =
        dispatch(groupCountXYZ.x, groupCountXYZ.y, groupCountXYZ.z)

fun VkCommandBuffer.dispatch(groupCountXY: Vec2i, groupCountZ: Int) =
        dispatch(groupCountXY.x, groupCountXY.y, groupCountZ)

fun VkCommandBuffer.dispatch(groupCountX: Int, groupCountY: Int, groupCountZ: Int) =
        VK10.vkCmdDispatch(this, groupCountX, groupCountY, groupCountZ)

fun VkCommandBuffer.dispatchBase(baseGroupXYZ: Vec3i, groupCountXYZ: Vec3i) =
        VK11.vkCmdDispatchBase(this, baseGroupXYZ.x, baseGroupXYZ.y, baseGroupXYZ.z, groupCountXYZ.x, groupCountXYZ.y, groupCountXYZ.z)

fun VkCommandBuffer.dispatchBase(baseGroupX: Int, baseGroupY: Int, baseGroupZ: Int, groupCountX: Int, groupCountY: Int, groupCountZ: Int) =
        VK11.vkCmdDispatchBase(this, baseGroupX, baseGroupY, baseGroupZ, groupCountX, groupCountY, groupCountZ)

fun VkCommandBuffer.dispatchBaseKHR(baseGroupXYZ: Vec3i, groupCountXYZ: Vec3i) =
        KHRDeviceGroup.vkCmdDispatchBaseKHR(this, baseGroupXYZ.x, baseGroupXYZ.y, baseGroupXYZ.z, groupCountXYZ.x, groupCountXYZ.y, groupCountXYZ.z)

fun VkCommandBuffer.dispatchBaseKHR(baseGroupX: Int, baseGroupY: Int, baseGroupZ: Int, groupCountX: Int, groupCountY: Int, groupCountZ: Int) =
        KHRDeviceGroup.vkCmdDispatchBaseKHR(this, baseGroupX, baseGroupY, baseGroupZ, groupCountX, groupCountY, groupCountZ)

fun VkCommandBuffer.dispatchIndirect(buffer: VkBuffer, offset: VkDeviceSize) =
        VK10.vkCmdDispatchIndirect(this, buffer.L, offset.L)

fun VkCommandBuffer.draw(vertexCount: Int, instanceCount: Int, firstVertex: Int, firstInstance: Int) =
        VK10.vkCmdDraw(this, vertexCount, instanceCount, firstVertex, firstInstance)

fun VkCommandBuffer.drawIndexed(indexCount: Int, instanceCount: Int, firstIndex: Int, vertexOffset: Int, firstInstance: Int) =
        VK10.vkCmdDrawIndexed(this, indexCount, instanceCount, firstIndex, vertexOffset, firstInstance)

fun VkCommandBuffer.drawIndexedIndirect(buffer: VkBuffer, offset: VkDeviceSize, drawCount: Int, stride: Int) =
        VK10.vkCmdDrawIndexedIndirect(this, buffer.L, offset.L, drawCount, stride)

fun VkCommandBuffer.drawIndexedIndirectCountAMD(buffer: VkBuffer, offset: VkDeviceSize, countBuffer: VkBuffer, countBufferOffset: VkDeviceSize, maxDrawCount: Int, stride: Int) =
        AMDDrawIndirectCount.vkCmdDrawIndexedIndirectCountAMD(this, buffer.L, offset.L, countBuffer.L, countBufferOffset.L, maxDrawCount, stride)

fun VkCommandBuffer.drawIndexedIndirectCountKHR(buffer: VkBuffer, offset: VkDeviceSize, countBuffer: VkBuffer, countBufferOffset: VkDeviceSize, maxDrawCount: Int, stride: Int) =
        KHRDrawIndirectCount.vkCmdDrawIndexedIndirectCountKHR(this, buffer.L, offset.L, countBuffer.L, countBufferOffset.L, maxDrawCount, stride)

fun VkCommandBuffer.drawIndirect(buffer: VkBuffer, offset: VkDeviceSize, drawCount: Int, stride: Int) =
        VK10.vkCmdDrawIndirect(this, buffer.L, offset.L, drawCount, stride)

fun VkCommandBuffer.drawIndirectByteCountEXT(instanceCount: Int, firstInstance: Int, counterBuffer: VkBuffer, counterBufferOffset: VkDeviceSize, counterOffset: Int, vertexStride: Int) =
        EXTTransformFeedback.vkCmdDrawIndirectByteCountEXT(this, instanceCount, firstInstance, counterBuffer.L, counterBufferOffset.L, counterOffset, vertexStride)

fun VkCommandBuffer.drawIndirectCountAMD(buffer: VkBuffer, offset: VkDeviceSize, countBuffer: VkBuffer, countBufferOffset: VkDeviceSize, maxDrawCount: Int, stride: Int) =
        AMDDrawIndirectCount.vkCmdDrawIndirectCountAMD(this, buffer.L, offset.L, countBuffer.L, countBufferOffset.L, maxDrawCount, stride)

fun VkCommandBuffer.drawIndirectCountKHR(buffer: VkBuffer, offset: VkDeviceSize, countBuffer: VkBuffer, countBufferOffset: VkDeviceSize, maxDrawCount: Int, stride: Int) =
        KHRDrawIndirectCount.vkCmdDrawIndirectCountKHR(this, buffer.L, offset.L, countBuffer.L, countBufferOffset.L, maxDrawCount, stride)

fun VkCommandBuffer.drawMeshTasksIndirectCountNV(buffer: VkBuffer, offset: VkDeviceSize, countBuffer: VkBuffer, countBufferOffset: VkDeviceSize, maxDrawCount: Int, stride: Int) =
        NVMeshShader.vkCmdDrawMeshTasksIndirectCountNV(this, buffer.L, offset.L, countBuffer.L, countBufferOffset.L, maxDrawCount, stride)

fun VkCommandBuffer.drawMeshTasksIndirectNV(buffer: VkBuffer, offset: VkDeviceSize, drawCount: Int, stride: Int) =
        NVMeshShader.vkCmdDrawMeshTasksIndirectNV(this, buffer.L, offset.L, drawCount, stride)

fun VkCommandBuffer.drawMeshTasksNV(taskCount: Int, firstTask: Int) =
        NVMeshShader.vkCmdDrawMeshTasksNV(this, taskCount, firstTask)

fun VkCommandBuffer.end(): VkResult =
        VkResult(VK10.vkEndCommandBuffer(this)).apply { check() }

/** JVM custom TODO :VkResult?  */
fun VkCommandBuffer.end(queue: VkQueue, submitInfoPNext: Pointer? = null) {
    end()
    submit(queue, submitInfoPNext)
}

/** JVM custom */ // TODO check if args order makes sense
fun VkCommandBuffer.end(device: VkDevice, commandPool: VkCommandPool, queue: VkQueue, submitInfoPNext: Pointer? = null) {
    end(queue, submitInfoPNext)
    device.freeCommandBuffer(commandPool, this)
}

fun VkCommandBuffer.endConditionalRenderingEXT() =
        EXTConditionalRendering.vkCmdEndConditionalRenderingEXT(this)

fun VkCommandBuffer.endDebugUtilsLabelEXT() =
        EXTDebugUtils.vkCmdEndDebugUtilsLabelEXT(this)

fun VkCommandBuffer.endQuery(queryPool: VkQueryPool, query: Int) =
        VK10.vkCmdEndQuery(this, queryPool.L, query)

fun VkCommandBuffer.endQueryIndexedEXT(queryPool: VkQueryPool, query: Int, index: Int) =
        EXTTransformFeedback.vkCmdEndQueryIndexedEXT(this, queryPool.L, query, index)

fun VkCommandBuffer.endRenderPass() =
        VK10.vkCmdEndRenderPass(this)

fun VkCommandBuffer.endRenderPass2KHR(subpassEndInfo: VkSubpassEndInfoKHR) =
        KHRCreateRenderpass2.nvkCmdEndRenderPass2KHR(this, subpassEndInfo.adr)

fun VkCommandBuffer.endTransformFeedbackEXT(firstCounterBuffer: Int, counterBuffers: VkBuffer_Buffer?, counterBufferOffsets: VkDeviceSize_Buffer?) =
        EXTTransformFeedback.nvkCmdEndTransformFeedbackEXT(this, firstCounterBuffer, counterBuffers?.rem
                ?: 0, counterBuffers?.adr ?: NULL, counterBufferOffsets?.adr ?: NULL)

fun VkCommandBuffer.executeCommand(commandBuffer: VkCommandBuffer) =
        stak.pointerAddress(commandBuffer) {
            VK10.nvkCmdExecuteCommands(this, 1, it)
        }

infix fun VkCommandBuffer.executeCommands(commandBuffers: Collection<VkCommandBuffer>) =
        stak {
            val count = commandBuffers.size
            val pCommandBuffers = it.mallocPointer(count)
            for (i in 0 until count)
                pCommandBuffers[i] = commandBuffers.elementAt(i)
            VK10.nvkCmdExecuteCommands(this, count, pCommandBuffers.adr)
        }

fun VkCommandBuffer.fillBuffer(dstBuffer: VkBuffer, dstOffset: VkDeviceSize, size: VkDeviceSize, data: Int) =
        VK10.vkCmdFillBuffer(this, dstBuffer.L, dstOffset.L, size.L, data)

fun VkCommandBuffer.insertDebugUtilsLabelEXT(labelInfo: VkDebugUtilsLabelEXT) =
        EXTDebugUtils.nvkCmdInsertDebugUtilsLabelEXT(this, labelInfo.adr)

infix fun VkCommandBuffer.nextSubpass(contents: VkSubpassContents) =
        VK10.vkCmdNextSubpass(this, contents.i)

fun VkCommandBuffer.nextSubpass2KHR(subpassBeginInfo: VkSubpassBeginInfoKHR, subpassEndInfo: VkSubpassEndInfoKHR) =
        KHRCreateRenderpass2.nvkCmdNextSubpass2KHR(this, subpassBeginInfo.adr, subpassEndInfo.adr)

fun VkCommandBuffer.pipelineBarrier(srcStage: VkPipelineStage, dstStage: VkPipelineStage,
                                    dependencyFlags: VkDependencyFlags = 0,
                                    memoryBarrier: VkMemoryBarrier? = null,
                                    bufferMemoryBarrier: VkBufferMemoryBarrier? = null,
                                    imageMemoryBarrier: VkImageMemoryBarrier? = null) =
        pipelineBarrier(srcStage.i, dstStage.i, dependencyFlags, memoryBarrier, bufferMemoryBarrier, imageMemoryBarrier)

fun VkCommandBuffer.pipelineBarrier(srcStageMask: VkPipelineStageFlags, dstStageMask: VkPipelineStageFlags,
                                    dependencyFlags: VkDependencyFlags = 0,
                                    memoryBarrier: VkMemoryBarrier? = null,
                                    bufferMemoryBarrier: VkBufferMemoryBarrier? = null,
                                    imageMemoryBarrier: VkImageMemoryBarrier? = null) =
        VK10.nvkCmdPipelineBarrier(this, srcStageMask, dstStageMask, dependencyFlags,
                if (memoryBarrier != null) 1 else 0, memoryBarrier?.adr ?: NULL,
                if (bufferMemoryBarrier != null) 1 else 0, bufferMemoryBarrier?.adr ?: NULL,
                if (imageMemoryBarrier != null) 1 else 0, imageMemoryBarrier?.adr ?: NULL)

fun VkCommandBuffer.processCommandsNVX(processCommandsInfo: VkCmdProcessCommandsInfoNVX) =
        NVXDeviceGeneratedCommands.nvkCmdProcessCommandsNVX(this, processCommandsInfo.adr)

fun VkCommandBuffer.pushConstants(layout: VkPipelineLayout, stageFlags: VkShaderStageFlags, offset: Int, values: Buffer) =
        VK10.nvkCmdPushConstants(this, layout.L, stageFlags, offset, values.remSize, values.adr)

fun VkCommandBuffer.pushDescriptorSetKHR(pipelineBindPoint: VkPipelineBindPoint, layout: VkPipelineLayout, set: Int, descriptorWrites: VkWriteDescriptorSet.Buffer) =
        KHRPushDescriptor.nvkCmdPushDescriptorSetKHR(this, pipelineBindPoint.i, layout.L, set, descriptorWrites.rem, descriptorWrites.adr)

fun VkCommandBuffer.pushDescriptorSetKHR(pipelineBindPoint: VkPipelineBindPoint, layout: VkPipelineLayout, set: Int, descriptorWrite: VkWriteDescriptorSet) =
        KHRPushDescriptor.nvkCmdPushDescriptorSetKHR(this, pipelineBindPoint.i, layout.L, set, 1, descriptorWrite.adr)

fun VkCommandBuffer.pushDescriptorSetWithTemplateKHR(descriptorUpdateTemplate: VkDescriptorUpdateTemplate, layout: VkPipelineLayout, set: Int, data: Ptr) =
        KHRPushDescriptor.vkCmdPushDescriptorSetWithTemplateKHR(this, descriptorUpdateTemplate.L, layout.L, set, data)

fun VkCommandBuffer.reserveSpaceForCommandsNVX(reserveSpaceInfo: VkCmdReserveSpaceForCommandsInfoNVX) =
        NVXDeviceGeneratedCommands.nvkCmdReserveSpaceForCommandsNVX(this, reserveSpaceInfo.adr)

fun VkCommandBuffer.reset(flags: VkCommandBufferResetFlags = 0): VkResult =
        VkResult(VK10.vkResetCommandBuffer(this, flags)).apply { check() }

fun VkCommandBuffer.resetEvent(event: VkEvent, stageMask: VkPipelineStageFlags) =
        VK10.vkCmdResetEvent(this, event.L, stageMask)

fun VkCommandBuffer.resetQueryPool(queryPool: VkQueryPool, firstQuery: Int, queryCount: Int) =
        VK10.vkCmdResetQueryPool(this, queryPool.L, firstQuery, queryCount)

fun VkCommandBuffer.resolveImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, regions: VkImageResolve.Buffer) =
        VK10.nvkCmdResolveImage(this, srcImage.L, srcImageLayout.i, dstImage.L, dstImageLayout.i, regions.rem, regions.adr)

fun VkCommandBuffer.resolveImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, region: VkImageResolve) =
        VK10.nvkCmdResolveImage(this, srcImage.L, srcImageLayout.i, dstImage.L, dstImageLayout.i, 1, region.adr)

fun VkCommandBuffer.setBlendConstants(blendConstants: FloatBuffer) =
        VK10.nvkCmdSetBlendConstants(this, blendConstants.adr)

fun VkCommandBuffer.setCheckpointNV(checkpointMarker: Ptr) =
        NVDeviceDiagnosticCheckpoints.vkCmdSetCheckpointNV(this, checkpointMarker)

fun VkCommandBuffer.setCoarseSampleOrderNV(sampleOrderType: VkCoarseSampleOrderTypeNV, customSampleOrders: VkCoarseSampleOrderCustomNV.Buffer?) =
        NVShadingRateImage.nvkCmdSetCoarseSampleOrderNV(this, sampleOrderType.i, customSampleOrders?.rem
                ?: 0, customSampleOrders?.adr ?: NULL)

fun VkCommandBuffer.setDepthBias(depthBiasConstantFactor: Float, depthBiasClamp: Float, depthBiasSlopeFactor: Float) =
        VK10.vkCmdSetDepthBias(this, depthBiasConstantFactor, depthBiasClamp, depthBiasSlopeFactor)

fun VkCommandBuffer.depthBounds(minDepthBounds: Float, maxDepthBounds: Float) =
        VK10.vkCmdSetDepthBounds(this, minDepthBounds, maxDepthBounds)

fun VkCommandBuffer.setDeviceMask(deviceMask: Int) =
        VK11.vkCmdSetDeviceMask(this, deviceMask)

fun VkCommandBuffer.setDeviceMaskKHR(deviceMask: Int) =
        KHRDeviceGroup.vkCmdSetDeviceMaskKHR(this, deviceMask)

fun VkCommandBuffer.setDiscardRectangleEXT(firstDiscardRectangle: Int, discardRectangles: VkRect2D.Buffer) =
        EXTDiscardRectangles.nvkCmdSetDiscardRectangleEXT(this, firstDiscardRectangle, discardRectangles.rem, discardRectangles.adr)

fun VkCommandBuffer.setEvent(event: VkEvent, stageMask: VkPipelineStageFlags) =
        VK10.vkCmdSetEvent(this, event.L, stageMask)

fun VkCommandBuffer.setExclusiveScissorNV(firstExclusiveScissor: Int, exclusiveScissors: VkRect2D.Buffer) =
        NVScissorExclusive.nvkCmdSetExclusiveScissorNV(this, firstExclusiveScissor, exclusiveScissors.rem, exclusiveScissors.adr)

infix fun VkCommandBuffer.setLineWidth(lineWidth: Float) =
        VK10.vkCmdSetLineWidth(this, lineWidth)

infix fun VkCommandBuffer.setPerformanceMarkerINTEL(markerInfo: VkPerformanceMarkerInfoINTEL): VkResult =
        VkResult(INTELPerformanceQuery.nvkCmdSetPerformanceMarkerINTEL(this, markerInfo.adr))

infix fun VkCommandBuffer.setPerformanceStreamMarkerINTEL(markerInfo: VkPerformanceStreamMarkerInfoINTEL): VkResult =
        VkResult(INTELPerformanceQuery.nvkCmdSetPerformanceStreamMarkerINTEL(this, markerInfo.adr))

infix fun VkCommandBuffer.setPerformanceOverrideINTEL(overrideInfo: VkPerformanceOverrideInfoINTEL): VkResult =
        VkResult(INTELPerformanceQuery.nvkCmdSetPerformanceOverrideINTEL(this, overrideInfo.adr))

infix fun VkCommandBuffer.setSampleLocationsEXT(sampleLocationsInfo: VkSampleLocationsInfoEXT) =
        EXTSampleLocations.nvkCmdSetSampleLocationsEXT(this, sampleLocationsInfo.adr)

infix fun VkCommandBuffer.setScissor(extend: Vec2i) =
        setScissor(vk.Rect2D(0, 0, extend.x, extend.y))

fun VkCommandBuffer.setScissor(offset: Vec2i, extend: Vec2i) =
        setScissor(vk.Rect2D(offset, extend))

infix fun VkCommandBuffer.setScissor(scissor: VkRect2D) =
        VK10.nvkCmdSetScissor(this, 0, 1, scissor.adr)

infix fun VkCommandBuffer.setScissor(scissors: VkRect2D.Buffer) =
        VK10.nvkCmdSetScissor(this, 0, scissors.remaining(), scissors.adr)

fun VkCommandBuffer.setScissor(firstScissor: Int, scissors: VkRect2D.Buffer) =
        VK10.nvkCmdSetScissor(this, firstScissor, scissors.rem, scissors.adr)

fun VkCommandBuffer.setStencilCompareMask(faceMask: VkStencilFaceFlags, compareMask: Int) =
        VK10.vkCmdSetStencilCompareMask(this, faceMask, compareMask)

fun VkCommandBuffer.setStencilReference(faceMask: VkStencilFaceFlags, reference: Int) =
        VK10.vkCmdSetStencilReference(this, faceMask, reference)

fun VkCommandBuffer.setStencilWriteMask(faceMask: VkStencilFaceFlags, writeMask: Int) =
        VK10.vkCmdSetStencilWriteMask(this, faceMask, writeMask)

infix fun VkCommandBuffer.setViewport(size: Vec2i) =
        setViewport(size, 0f, 1f)

fun VkCommandBuffer.setViewport(size: Vec2i, minDepth: Float, maxDepth: Float) =
        setViewport(size.x.f, size.y.f, minDepth, maxDepth)

fun VkCommandBuffer.setViewport(width: Float, height: Float, minDepth: Float = 0f, maxDepth: Float = 1f) =
        setViewport(vk.Viewport(width, height, minDepth, maxDepth))

infix fun VkCommandBuffer.setViewport(viewport: VkViewport) =
        VK10.nvkCmdSetViewport(this, 0, 1, viewport.adr)

fun VkCommandBuffer.setViewport(firstViewport: Int, viewports: VkViewport.Buffer) =
        VK10.nvkCmdSetViewport(this, firstViewport, viewports.rem, viewports.adr)

fun VkCommandBuffer.setViewportShadingRatePaletteNV(firstViewport: Int, shadingRatePalettes: VkShadingRatePaletteNV.Buffer) =
        NVShadingRateImage.nvkCmdSetViewportShadingRatePaletteNV(this, firstViewport, shadingRatePalettes.rem, shadingRatePalettes.adr)

fun VkCommandBuffer.setViewportWScalingNV(firstViewport: Int, viewportWScalings: VkViewportWScalingNV.Buffer) =
        NVClipSpaceWScaling.nvkCmdSetViewportWScalingNV(this, firstViewport, viewportWScalings.rem, viewportWScalings.adr)

fun VkCommandBuffer.submit(queue: VkQueue, submitInfoPNext: Pointer? = null) {
    queue.submit(vk.SubmitInfo {
        commandBuffer = this@submit
        submitInfoPNext?.let { next = it.adr }
    })
    queue.waitIdle()
}

fun VkCommandBuffer.traceRaysNV(raygenShaderBindingTableBuffer: VkBuffer, raygenShaderBindingOffset: VkDeviceSize,
                                missShaderBindingTableBuffer: VkBuffer, missShaderBindingOffset: VkDeviceSize,
                                missShaderBindingStride: VkDeviceSize, hitShaderBindingTableBuffer: VkBuffer,
                                hitShaderBindingOffset: VkDeviceSize, hitShaderBindingStride: VkDeviceSize,
                                callableShaderBindingTableBuffer: VkBuffer, callableShaderBindingOffset: VkDeviceSize,
                                callableShaderBindingStride: VkDeviceSize, width: Int, height: Int, depth: Int) =
        NVRayTracing.vkCmdTraceRaysNV(this, raygenShaderBindingTableBuffer.L, raygenShaderBindingOffset.L,
                missShaderBindingTableBuffer.L, missShaderBindingOffset.L, missShaderBindingStride.L,
                hitShaderBindingTableBuffer.L, hitShaderBindingOffset.L, hitShaderBindingStride.L,
                callableShaderBindingTableBuffer.L, callableShaderBindingOffset.L, callableShaderBindingStride.L,
                width, height, depth)

fun VkCommandBuffer.updateBuffer(dstBuffer: VkBuffer, dstOffset: VkDeviceSize, data: Buffer) =
        VK10.nvkCmdUpdateBuffer(this, dstBuffer.L, dstOffset.L, data.remSize.L, data.adr)

fun VkCommandBuffer.waitEvents(events: VkEvent_Buffer, srcStageMask: VkPipelineStageFlags, dstStageMask: VkPipelineStageFlags,
                               memoryBarriers: VkMemoryBarrier.Buffer? = null, bufferMemoryBarriers: VkBufferMemoryBarrier.Buffer? = null,
                               imageMemoryBarriers: VkImageMemoryBarrier.Buffer? = null) =
        VK10.nvkCmdWaitEvents(this, events.rem, events.adr, srcStageMask, dstStageMask, memoryBarriers?.rem
                ?: 0, memoryBarriers?.adr ?: NULL, bufferMemoryBarriers?.rem ?: 0, bufferMemoryBarriers?.adr
                ?: NULL, imageMemoryBarriers?.rem ?: 0, imageMemoryBarriers?.adr ?: NULL)

fun VkCommandBuffer.writeAccelerationStructuresPropertiesNV(accelerationStructures: VkAccelerationStructureNV_Buffer,
                                                            queryType: VkQueryType, queryPool: VkQueryPool, firstQuery: Int) =
        NVRayTracing.nvkCmdWriteAccelerationStructuresPropertiesNV(this, accelerationStructures.rem,
                accelerationStructures.adr, queryType.i, queryPool.L, firstQuery)

fun VkCommandBuffer.writeBufferMarkerAMD(pipelineStage: VkPipelineStage, dstBuffer: VkBuffer, dstOffset: VkDeviceSize, marker: Int) =
        AMDBufferMarker.vkCmdWriteBufferMarkerAMD(this, pipelineStage.i, dstBuffer.L, dstOffset.L, marker)

fun VkCommandBuffer.writeTimestamp(pipelineStage: VkPipelineStageFlags, queryPool: VkQueryPool, query: Int) =
        VK10.vkCmdWriteTimestamp(this, pipelineStage, queryPool.L, query)


// ---------- Inline lambdas ----------


inline fun <R> VkCommandBuffer.debugMarkerEXT(markerInfo: VkDebugMarkerMarkerInfoEXT, block: () -> R): R {
    debugMarkerBeginEXT(markerInfo)
    return block().also { debugMarkerEndEXT() }
}

inline fun <R> VkCommandBuffer.conditionalRenderingEXT(conditionalRenderingBegin: VkConditionalRenderingBeginInfoEXT,
                                                       block: VkCommandBuffer.() -> R): R {
    beginConditionalRenderingEXT(conditionalRenderingBegin)
    return block().also { endConditionalRenderingEXT() }
}

inline fun <R> VkCommandBuffer.debugUtilsLabelEXT(labelInfo: VkDebugUtilsLabelEXT, block: VkCommandBuffer.() -> R): R {
    beginDebugUtilsLabelEXT(labelInfo)
    return block().also { endDebugUtilsLabelEXT() }
}

inline fun <R> VkCommandBuffer.query(queryPool: VkQueryPool, query: Int, flags: VkQueryControlFlags, block: VkCommandBuffer.() -> R): R {
    beginQuery(queryPool, query, flags)
    return block().also { endQuery(queryPool, query) }
}

inline fun <R> VkCommandBuffer.queryIndexedEXT(queryPool: VkQueryPool, query: Int, flags: VkQueryControlFlags,
                                               index: Int, block: VkCommandBuffer.() -> R): R {
    beginQueryIndexedEXT(queryPool, query, flags, index)
    return block().also { endQueryIndexedEXT(queryPool, query, index) }
}

inline fun <R> VkCommandBuffer.renderPass(renderPassBegin: VkRenderPassBeginInfo, contents: VkSubpassContents,
                                          block: VkCommandBuffer.() -> R): R {
    beginRenderPass(renderPassBegin, contents)
    return block().also { endRenderPass() }
}

inline fun <R> VkCommandBuffer.renderPass2KHR(renderPassBegin: VkRenderPassBeginInfo, subpassBeginInfo: VkSubpassBeginInfoKHR,
                                              subpassEndInfo: VkSubpassEndInfoKHR, block: VkCommandBuffer.() -> R): R {
    beginRenderPass2KHR(renderPassBegin, subpassBeginInfo)
    return block().also { endRenderPass2KHR(subpassEndInfo) }
}

/** begin .. end */
inline fun <R> VkCommandBuffer.record(beginInfo: VkCommandBufferBeginInfo, block: VkCommandBuffer.() -> R): R {
    begin(beginInfo)
    return block().also { end() }
}

inline fun <R> VkCommandBuffer.transformFeedbackEXT(firstCounterBuffer: Int, counterBuffers: VkBuffer_Buffer?,
                                                    counterBufferOffsets: VkDeviceSize_Buffer?,
                                                    block: VkCommandBuffer.() -> R): R {
    beginTransformFeedbackEXT(firstCounterBuffer, counterBuffers, counterBufferOffsets)
    return block().also { endTransformFeedbackEXT(firstCounterBuffer, counterBuffers, counterBufferOffsets) }
}