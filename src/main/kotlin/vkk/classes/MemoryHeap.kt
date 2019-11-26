package classes

import kool.Ptr
import org.lwjgl.vulkan.VkMemoryHeap
import org.lwjgl.vulkan.VkMemoryHeap.*
import vkk.VkMemoryHeapFlags
import vkk.entities.VkDeviceSize

/**
 * Structure specifying a memory heap.
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code size} &ndash; the total memory size in bytes in the heap.</li>
 * <li>{@code flags} &ndash; a bitmask of {@code VkMemoryHeapFlagBits} specifying attribute flags for the heap.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkMemoryHeap {
 *     VkDeviceSize size;
 *     VkMemoryHeapFlags flags;
 * }</code></pre>
 */
class MemoryHeap(
    var size: VkDeviceSize,
    var flags: VkMemoryHeapFlags
) {

    constructor(ptr: Ptr) : this(VkDeviceSize(nsize(ptr)), nflags(ptr))
}