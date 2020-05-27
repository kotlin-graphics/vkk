package vkk.vk11.structs

import kool.BytePtr
import kool.Ptr
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.vulkan.VkSparseImageMemoryRequirements2.MEMORYREQUIREMENTS
import org.lwjgl.vulkan.VkSparseImageMemoryRequirements2.npNext
import vkk.VkStructureType
import vkk.vk10.structs.SparseImageMemoryRequirements

/**
 * (None).
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_SPARSE_IMAGE_MEMORY_REQUIREMENTS_2 STRUCTURE_TYPE_SPARSE_IMAGE_MEMORY_REQUIREMENTS_2}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL}</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkSparseImageMemoryRequirements}, {@link VK11#vkGetImageSparseMemoryRequirements2 GetImageSparseMemoryRequirements2}, {@link KHRGetMemoryRequirements2#vkGetImageSparseMemoryRequirements2KHR GetImageSparseMemoryRequirements2KHR}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code memoryRequirements} &ndash; a structure of type {@link VkSparseImageMemoryRequirements} describing the memory requirements of the sparse image.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkSparseImageMemoryRequirements2 {
 *     VkStructureType sType;
 *     void * pNext;
 *     {@link VkSparseImageMemoryRequirements VkSparseImageMemoryRequirements} memoryRequirements;
 * }</code></pre>
 */
class SparseImageMemoryRequirements2(
        var memoryRequirements: SparseImageMemoryRequirements,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.SPARSE_IMAGE_MEMORY_REQUIREMENTS_2

    constructor(ptr: BytePtr) : this(
            SparseImageMemoryRequirements(ptr + MEMORYREQUIREMENTS),
            npNext(ptr.adr)
    )
}