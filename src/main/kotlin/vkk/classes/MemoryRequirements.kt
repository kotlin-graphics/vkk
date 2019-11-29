package vkk.classes

import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkMemoryRequirements.*
import vkk.entities.VkDeviceSize
import vkk.stak

/**
 * Structure specifying memory requirements.
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code size} &ndash; the size, in bytes, of the memory allocation required: for the resource.</li>
 * <li>{@code alignment} &ndash; the alignment, in bytes, of the offset within the allocation required: for the resource.</li>
 * <li>{@code memoryTypeBits} &ndash; a bitmask and contains one bit set for every supported memory type for the resource. Bit {@code i} is set if and only if the memory type {@code i} in the {@link VkPhysicalDeviceMemoryProperties} structure for the physical device is supported for the resource.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkMemoryRequirements {
 *     VkDeviceSize size;
 *     VkDeviceSize alignment;
 *     uint32_t memoryTypeBits;
 * }</code></pre>
 */
class MemoryRequirements(
        var size: VkDeviceSize = VkDeviceSize(0),
        var alignment: VkDeviceSize = VkDeviceSize(0),
        var memoryTypeBits: Int = 0
) {

    constructor(ptr: Ptr) : this(
            VkDeviceSize(nsize(ptr)),
            VkDeviceSize(nalignment(ptr)),
            nmemoryTypeBits(ptr)
    )

    companion object {
        inline fun <R> read(block: (Adr) -> R): MemoryRequirements = stak { read(it, block) }
        inline fun <R> read(stack: MemoryStack, block: (Adr) -> R): MemoryRequirements {
            val adr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
            block(adr)
            return MemoryRequirements(adr)
        }
    }
}