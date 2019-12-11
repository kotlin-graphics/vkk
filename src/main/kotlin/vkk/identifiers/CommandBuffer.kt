package identifiers

import glm_.vec3.Vec3i
import kool.PointerAdr
import kool.Ptr
import kool.adr
import org.lwjgl.system.JNI.callPV
import org.lwjgl.system.MemoryStack
import vkk.VkQueryControlFlags
import vkk.VkSubpassContents
import vkk._10.api.CommandBuffer_vk10
import vkk._10.api.CommandBuffer_vk11
import vkk._10.structs.CommandBufferBeginInfo
import vkk._10.structs.RenderPassBeginInfo
import vkk.entities.VkQueryPool

/** Wraps a Vulkan command buffer handle.  */
class CommandBuffer
/**
 * Creates a `VkCommandBuffer` using the specified native handle and device.
 *
 * @param handle the native `VkCommandBuffer` handle
 * @param device the device on which the command buffer was created
 */
constructor(
        handle: Ptr,
        /** Returns the device on which this `VkCommandBuffer` was created.  */
        val device: Device
)

    : DispatchableHandleDevice(handle, device.capabilities),

        CommandBuffer_vk10,

        CommandBuffer_vk11 {


    // ---------------------------------------------- VK10 -------------------------------------------------------------


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

    // ---------------------------------------------- VK11 -------------------------------------------------------------


}

infix fun Array<CommandBuffer>.write(stack: MemoryStack): Ptr = stack.PointerAdr(size) { this[it].adr }