package vkk.identifiers

import glm_.vec3.Vec3i
import kool.Ptr
import kool.adr
import org.lwjgl.system.JNI.*
import vkk.*
import vkk._11.api.CommandBuffer_vk11
import vkk.entities.*

//class UniqueCommandBuffer(handle: Ptr, device: Device) : CommandBuffer(handle, device) {
//    val address = adr
//    val function = capabilities.vkDestroy
//    vk.cleaner.register(this) {
//        JNI.callPJPV(address, commandPool.L, commandBufferCount, pCommandBuffers, capabilities.vkFreeCommandBuffers)
//        println("device gc'ed")
//    }
//}

/** Wraps a Vulkan command buffer handle.  */
class CommandBuffer
/**
 * Creates a `VkCommandBuffer` using the specified native handle and device.
 *
 * @param handle the native `VkCommandBuffer` handle
 * @param device the device on which the command buffer was created
 */
constructor(handle: Ptr,
            /** Returns the device on which this `VkCommandBuffer` was created.  */
            val device: Device) :

        DispatchableHandleDevice(handle, device.capabilities),
        CommandBuffer_vk11 {


    // ---------------------------------------------- VK10 -------------------------------------------------------------

    // --- [ vkEndCommandBuffer ] ---
    fun end(): VkResult = VkResult(callPI(adr, capabilities.vkEndCommandBuffer)).andCheck()

    // --- [ vkResetCommandBuffer ] ---
    infix fun reset(flags: VkCommandBufferResetFlags): VkResult = VkResult(callPI(adr, flags, capabilities.vkResetCommandBuffer)).andCheck()

    // --- [ vkCmdBindPipeline ] ---
    fun bindPipeline(pipelineBindPoint: VkPipelineBindPoint, pipeline: VkPipeline) = callPJV(adr, pipelineBindPoint.i, pipeline.L, capabilities.vkCmdBindPipeline)

    // --- [ vkCmdSetLineWidth ] ---
    infix fun setLineWidth(lineWidth: Float) = callPV(adr, lineWidth, capabilities.vkCmdSetLineWidth)

    // --- [ vkCmdSetDepthBias ] ---
    fun setDepthBias(depthBiasConstantFactor: Float, depthBiasClamp: Float, depthBiasSlopeFactor: Float) = callPV(adr, depthBiasConstantFactor, depthBiasClamp, depthBiasSlopeFactor, capabilities.vkCmdSetDepthBias)

    // --- [ vkCmdSetDepthBounds ] ---
    fun setDepthBounds(minDepthBounds: Float, maxDepthBounds: Float) = callPV(adr, minDepthBounds, maxDepthBounds, capabilities.vkCmdSetDepthBounds)

    // --- [ vkCmdSetStencilCompareMask ] ---
    fun setStencilCompareMask(faceMask: VkStencilFaceFlags, compareMask: Int) = callPV(adr, faceMask, compareMask, capabilities.vkCmdSetStencilCompareMask)

    // --- [ vkCmdSetStencilWriteMask ] ---
    fun setStencilWriteMask(faceMask: VkStencilFaceFlags, writeMask: Int) = callPV(adr, faceMask, writeMask, capabilities.vkCmdSetStencilWriteMask)

    // --- [ vkCmdSetStencilReference ] ---
    fun setStencilReference(faceMask: VkStencilFaceFlags, reference: Int) = callPV(adr, faceMask, reference, capabilities.vkCmdSetStencilReference)

    // --- [ vkCmdBindIndexBuffer ] ---
    fun bindIndexBuffer(buffer: VkBuffer, offset: VkDeviceSize, indexType: VkIndexType) = callPJJV(adr, buffer.L, offset.L, indexType.i, capabilities.vkCmdBindIndexBuffer)

    // --- [ vkCmdDraw ] ---
    fun draw(vertexCount: Int, instanceCount: Int, firstVertex: Int, firstInstance: Int) = callPV(adr, vertexCount, instanceCount, firstVertex, firstInstance, capabilities.vkCmdDraw)

    // --- [ vkCmdDrawIndexed ] ---
    fun drawIndexed(indexCount: Int, instanceCount: Int, firstIndex: Int, vertexOffset: Int, firstInstance: Int) = callPV(adr, indexCount, instanceCount, firstIndex, vertexOffset, firstInstance, capabilities.vkCmdDrawIndexed)

    // --- [ vkCmdDrawIndirect ] ---
    fun drawIndirect(buffer: VkBuffer, offset: VkDeviceSize, drawCount: Int, stride: Int) = callPJJV(adr, buffer.L, offset.L, drawCount, stride, capabilities.vkCmdDrawIndirect)

    // --- [ vkCmdDrawIndexedIndirect ] ---
    fun drawIndexedIndirect(buffer: VkBuffer, offset: VkDeviceSize, drawCount: Int, stride: Int) = callPJJV(adr, buffer.L, offset.L, drawCount, stride, capabilities.vkCmdDrawIndexedIndirect)

    // --- [ vkCmdDispatch ] ---

    fun dispatch(groupCountX: Int, groupCountY: Int, groupCountZ: Int) = callPV(adr, groupCountX, groupCountY, groupCountZ, capabilities.vkCmdDispatch)

    fun dispatch(groupCount: Vec3i) = callPV(adr, groupCount.x, groupCount.y, groupCount.z, capabilities.vkCmdDispatch)

    // --- [ vkCmdDispatchIndirect ] ---
    fun dispatchIndirect(buffer: VkBuffer, offset: VkDeviceSize) = callPJJV(adr, buffer.L, offset.L, capabilities.vkCmdDispatchIndirect)

    // --- [ vkCmdUpdateBuffer ] ---
    fun updateBuffer(dstBuffer: VkBuffer, dstOffset: VkDeviceSize, dataSize: VkDeviceSize, pData: Ptr) = callPJJJPV(adr, dstBuffer.L, dstOffset.L, dataSize.L, pData, capabilities.vkCmdUpdateBuffer)

    // --- [ vkCmdFillBuffer ] ---
    fun fillBuffer(dstBuffer: VkBuffer, dstOffset: VkDeviceSize, size: VkDeviceSize, data: Int) = callPJJJV(adr, dstBuffer.L, dstOffset.L, size.L, data, capabilities.vkCmdFillBuffer)

    // --- [ vkCmdSetEvent ] ---
    fun setEvent(event: VkEvent, stageMask: VkPipelineStageFlags) = callPJV(adr, event.L, stageMask, capabilities.vkCmdSetEvent)

    // --- [ vkCmdResetEvent ] ---
    fun resetEvent(event: VkEvent, stageMask: VkPipelineStageFlags) = callPJV(adr, event.L, stageMask, capabilities.vkCmdResetEvent)

    // --- [ vkCmdBeginQuery ] ---
    fun beginQuery(queryPool: VkQueryPool, query: Int, flags: VkQueryControlFlags) = callPJV(adr, queryPool.L, query, flags, capabilities.vkCmdBeginQuery)

    // --- [ vkCmdEndQuery ] ---
    fun endQuery(queryPool: VkQueryPool, query: Int) = callPJV(adr, queryPool.L, query, capabilities.vkCmdEndQuery)

    // [JVM]
    inline fun <R> query(queryPool: VkQueryPool, query: Int, flags: VkQueryControlFlags, block: () -> R): R {
        beginQuery(queryPool, query, flags)
        return block().also { endQuery(queryPool, query) }
    }

    // --- [ vkCmdResetQueryPool ] ---
    fun resetQueryPool(queryPool: VkQueryPool, firstQuery: Int, queryCount: Int) = callPJV(adr, queryPool.L, firstQuery, queryCount, capabilities.vkCmdResetQueryPool)

    // --- [ vkCmdWriteTimestamp ] ---
    fun writeTimestamp(pipelineStage: VkPipelineStage, queryPool: VkQueryPool, query: Int) = callPJV(adr, pipelineStage.i, queryPool.L, query, capabilities.vkCmdWriteTimestamp)

    // --- [ vkCmdCopyQueryPoolResults ] ---
    fun copyQueryPoolResults(queryPool: VkQueryPool, firstQuery: Int, queryCount: Int, dstBuffer: VkBuffer, dstOffset: VkDeviceSize, stride: VkDeviceSize, flags: VkQueryResultFlags = 0) = callPJJJJV(adr, queryPool.L, firstQuery, queryCount, dstBuffer.L, dstOffset.L, stride.L, flags, capabilities.vkCmdCopyQueryPoolResults)

    // --- [ vkCmdPushConstants ] ---
    fun pushConstants(layout: VkPipelineLayout, stageFlags: VkShaderStageFlags, offset: Int, size: Int, pValues: Ptr) = callPJPV(adr, layout.L, stageFlags, offset, size, pValues, capabilities.vkCmdPushConstants)

    // --- [ vkCmdNextSubpass ] ---
    infix fun nextSubpass(contents: VkSubpassContents) = callPV(adr, contents.i, capabilities.vkCmdNextSubpass)

    // --- [ vkCmdEndRenderPass ] ---
    fun endRenderPass() = callPV(adr, capabilities.vkCmdEndRenderPass)



    // ---------------------------------------------- VK11 -------------------------------------------------------------
}