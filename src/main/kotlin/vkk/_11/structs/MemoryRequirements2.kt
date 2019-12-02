package vkk._11.structs

import kool.Ptr
import org.lwjgl.system.MemoryUtil.NULL
import vkk.VkStructureType
import vkk._10.structs.MemoryRequirements

/**
 * Structure specifying memory requirements.
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_MEMORY_REQUIREMENTS_2 STRUCTURE_TYPE_MEMORY_REQUIREMENTS_2}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL} or a pointer to a valid instance of {@link VkMemoryDedicatedRequirements}</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkMemoryRequirements}, {@link VK11#vkGetBufferMemoryRequirements2 GetBufferMemoryRequirements2}, {@link KHRGetMemoryRequirements2#vkGetBufferMemoryRequirements2KHR GetBufferMemoryRequirements2KHR}, {@link VK11#vkGetImageMemoryRequirements2 GetImageMemoryRequirements2}, {@link KHRGetMemoryRequirements2#vkGetImageMemoryRequirements2KHR GetImageMemoryRequirements2KHR}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code memoryRequirements} &ndash; a structure of type {@link VkMemoryRequirements} describing the memory requirements of the resource.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkMemoryRequirements2 {
 *     VkStructureType sType;
 *     void * pNext;
 *     {@link VkMemoryRequirements VkMemoryRequirements} memoryRequirements;
 * }</code></pre>
 */
class MemoryRequirements2(
        var memoryRequirements: MemoryRequirements,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.MEMORY_REQUIREMENTS_2
}