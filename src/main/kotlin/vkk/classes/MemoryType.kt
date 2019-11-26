package classes

import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkMemoryType
import org.lwjgl.vulkan.VkMemoryType.*
import vkk.VkMemoryPropertyFlags

/**
 * Structure specifying memory type.
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code propertyFlags} &ndash; a bitmask of {@code VkMemoryPropertyFlagBits} of properties for this memory type.</li>
 * <li>{@code heapIndex} &ndash; describes which memory heap this memory type corresponds to, and <b>must</b> be less than {@code memoryHeapCount} from the {@link VkPhysicalDeviceMemoryProperties} structure.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkMemoryType {
 *     VkMemoryPropertyFlags propertyFlags;
 *     uint32_t heapIndex;
 * }</code></pre>
 */
class MemoryType(
    var propertyFlags: VkMemoryPropertyFlags,
    var heapIndex: Int
) {

    constructor(ptr: Ptr) : this(npropertyFlags(ptr), nheapIndex(ptr))
}