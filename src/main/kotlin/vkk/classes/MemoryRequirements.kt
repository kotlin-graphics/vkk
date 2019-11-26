package classes

import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkMemoryRequirements.*
import vkk.entities.VkDeviceSize

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

    companion object {
        fun ncalloc(stack: MemoryStack, num: Int = 1): Ptr = stack.ncalloc(ALIGNOF, num, SIZEOF)

        fun <R> fromNative(stack: MemoryStack, block: (Ptr) -> R): MemoryRequirements {
            val native = ncalloc(stack)
            block(native)
            return MemoryRequirements(
                VkDeviceSize(nsize(native)),
                VkDeviceSize(nalignment(native)),
                memoryTypeBits = nmemoryTypeBits(native)
            )
        }
    }
}