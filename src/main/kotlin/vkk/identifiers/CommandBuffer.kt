package identifiers

import vkk.classes.*
import kool.*
import org.lwjgl.system.JNI.*
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import vkk.VkPipelineBindPoint
import vkk.VkResult
import vkk.VkSubpassContents
import vkk.entities.*
import vkk.stak

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
            stak { s -> VkResult(callPPI(adr, beginInfo.write(s), capabilities.vkBeginCommandBuffer)) }

    // --- [ vkCmdBeginRenderPass ] ---
    fun beginRenderPass(renderPassBegin: RenderPassBeginInfo, contents: VkSubpassContents = VkSubpassContents.INLINE) = stak { s ->
        callPPV(adr, renderPassBegin write s, contents.i, capabilities.vkCmdBeginRenderPass)
    }

    // --- [ vkCmdBindPipeline ] ---
    fun bindPipeline(pipelineBindPoint: VkPipelineBindPoint, pipeline: VkPipeline) =
            callPJV(adr, pipelineBindPoint.i, pipeline.L, capabilities.vkCmdBindPipeline)

    // --- [ vkCmdBindVertexBuffers ] ---
    fun nBindVertexBuffers(firstBinding: Int, bindingCount: Int, pBuffers: Ptr, pOffsets: Ptr) =
            callPPPV(adr, firstBinding, bindingCount, pBuffers, pOffsets, capabilities.vkCmdBindVertexBuffers)

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

    // --- [ vkEndCommandBuffer ] ---
    fun end(): VkResult = VkResult(callPI(adr, capabilities.vkEndCommandBuffer))

    // --- [ vkCmdEndRenderPass ] ---
    fun endRenderPass() = callPV(adr, capabilities.vkCmdEndRenderPass)

    // --- [ vkCmdDraw ] ---
    fun draw(vertexCount: Int, instanceCount: Int = 1, firstVertex: Int = 0, firstInstance: Int = 0) =
            callPV(adr, vertexCount, instanceCount, firstVertex, firstInstance, capabilities.vkCmdDraw)

    // --- [ vkCmdSetScissor ] ---
    inline fun nSetScissor(firstScissor: Int, scissorCount: Int, pScissors: Ptr) =
            callPPV(adr, firstScissor, scissorCount, pScissors, capabilities.vkCmdSetScissor)

    fun setScissor(firstScissor: Int, scissors: Array<Rect2D>) =
            stak { s -> nSetScissor(firstScissor, scissors.size, scissors write s) }

    infix fun setScissor(scissors: Rect2D) =
            stak { s -> nSetScissor(0, 1, scissors write s) }

    // --- [ vkCmdSetViewport ] ---
    inline fun nSetViewport(firstViewport: Int, viewportCount: Int, pViewports: Ptr): Unit =
            callPPV(adr, firstViewport, viewportCount, pViewports, capabilities.vkCmdSetViewport)

    infix fun setViewport(viewport: Viewport) =
            stak { s -> nSetViewport(0, 1, viewport write s) }

    fun setViewport(firstViewport: Int, viewports: Array<Viewport>) =
            stak { s -> nSetViewport(firstViewport, viewports.size, viewports write s) }

    // JVM
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

fun Array<CommandBuffer>.write(stack: MemoryStack): Ptr = stack.PointerAdr(size) { this[it].adr }