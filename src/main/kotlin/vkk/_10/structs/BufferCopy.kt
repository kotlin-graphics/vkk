package vkk._10.structs

import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkBufferCopy.*
import vkk.entities.VkDeviceSize

/**
 * Structure specifying a buffer copy operation.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>The {@code size} <b>must</b> be greater than 0</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VK10#vkCmdCopyBuffer CmdCopyBuffer}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code srcOffset} &ndash; the starting offset in bytes from the start of {@code srcBuffer}.</li>
 * <li>{@code dstOffset} &ndash; the starting offset in bytes from the start of {@code dstBuffer}.</li>
 * <li>{@code size} &ndash; the number of bytes to copy.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkBufferCopy {
 *     VkDeviceSize srcOffset;
 *     VkDeviceSize dstOffset;
 *     VkDeviceSize size;
 * }</code></pre>
 */
class BufferCopy(
        var srcOffset: VkDeviceSize,
        var dstOffset: VkDeviceSize,
        var size: VkDeviceSize
) {

    infix fun write(stack: MemoryStack): Adr =
        stack.ncalloc(ALIGNOF, 1, SIZEOF).also { write(it) }

    infix fun write(adr: Adr) {
        nsrcOffset(adr, srcOffset.L)
        ndstOffset(adr, dstOffset.L)
        nsize(adr, size.L)
    }
}

infix fun Array<BufferCopy>.write(stack: MemoryStack): Ptr {
    val natives = stack.ncalloc(ALIGNOF, size, SIZEOF)
    for (i in indices)
        this[i] write (natives + i * SIZEOF)
    return natives
}