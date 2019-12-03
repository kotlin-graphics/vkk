package vkk._11.structs

import kool.Adr
import kool.BytePtr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.vulkan.VkImageSparseMemoryRequirementsInfo2
import org.lwjgl.vulkan.VkImageSparseMemoryRequirementsInfo2.*
import vkk.VkStructureType
import vkk.entities.VkImage

/**
 * (None).
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_IMAGE_SPARSE_MEMORY_REQUIREMENTS_INFO_2 STRUCTURE_TYPE_IMAGE_SPARSE_MEMORY_REQUIREMENTS_INFO_2}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL}</li>
 * <li>{@code image} <b>must</b> be a valid {@code VkImage} handle</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VK11#vkGetImageSparseMemoryRequirements2 GetImageSparseMemoryRequirements2}, {@link KHRGetMemoryRequirements2#vkGetImageSparseMemoryRequirements2KHR GetImageSparseMemoryRequirements2KHR}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code image} &ndash; the image to query.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkImageSparseMemoryRequirementsInfo2 {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkImage image;
 * }</code></pre>
 */
class ImageSparseMemoryRequirementsInfo2(
        var image: VkImage,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.IMAGE_SPARSE_MEMORY_REQUIREMENTS_INFO_2

    infix fun write(stack: MemoryStack): Adr {
        val adr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
        nsType(adr, type.i)
        npNext(adr, next)
        nimage(adr, image.L)
        return adr
    }
}