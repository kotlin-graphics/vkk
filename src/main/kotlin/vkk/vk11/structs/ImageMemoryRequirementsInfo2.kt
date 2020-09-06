package vkk.vk11.structs

import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.vulkan.VkImageMemoryRequirementsInfo2.*
import vkk.VkStructureType
import vkk.entities.VkImage

/**
 * (None).
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>If {@code image} was created with a <em>multi-planar</em> format and the {@link VK11#VK_IMAGE_CREATE_DISJOINT_BIT IMAGE_CREATE_DISJOINT_BIT} flag, there <b>must</b> be a {@link VkImagePlaneMemoryRequirementsInfo} in the {@code pNext} chain of the {@link VkImageMemoryRequirementsInfo2} structure</li>
 * <li>If {@code image} was created with {@link VK11#VK_IMAGE_CREATE_DISJOINT_BIT IMAGE_CREATE_DISJOINT_BIT} and with {@link EXTImageDrmFormatModifier#VK_IMAGE_TILING_DRM_FORMAT_MODIFIER_EXT IMAGE_TILING_DRM_FORMAT_MODIFIER_EXT}, then there <b>must</b> be a {@link VkImagePlaneMemoryRequirementsInfo} in the {@code pNext} chain of the {@link VkImageMemoryRequirementsInfo2} structure</li>
 * <li>If {@code image} was not created with the {@link VK11#VK_IMAGE_CREATE_DISJOINT_BIT IMAGE_CREATE_DISJOINT_BIT} flag, there <b>must</b> not be a {@link VkImagePlaneMemoryRequirementsInfo} in the {@code pNext} chain of the {@link VkImageMemoryRequirementsInfo2} structure</li>
 * <li>If {@code image} was created with a single-plane format and with any {@code tiling} other than {@link EXTImageDrmFormatModifier#VK_IMAGE_TILING_DRM_FORMAT_MODIFIER_EXT IMAGE_TILING_DRM_FORMAT_MODIFIER_EXT}, then there <b>must</b> not be a {@link VkImagePlaneMemoryRequirementsInfo} in the {@code pNext} chain of the {@link VkImageMemoryRequirementsInfo2} structure</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_IMAGE_MEMORY_REQUIREMENTS_INFO_2 STRUCTURE_TYPE_IMAGE_MEMORY_REQUIREMENTS_INFO_2}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL} or a pointer to a valid instance of {@link VkImagePlaneMemoryRequirementsInfo}</li>
 * <li>{@code image} <b>must</b> be a valid {@code VkImage} handle</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VK11#vkGetImageMemoryRequirements2 GetImageMemoryRequirements2}, {@link KHRGetMemoryRequirements2#vkGetImageMemoryRequirements2KHR GetImageMemoryRequirements2KHR}</p>
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
 * struct VkImageMemoryRequirementsInfo2 {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkImage image;
 * }</code></pre>
 */
class ImageMemoryRequirementsInfo2(
        var image: VkImage,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.IMAGE_MEMORY_REQUIREMENTS_INFO_2

    infix fun write(stack: MemoryStack): Adr {
        val adr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
        nsType(adr, type.i)
        npNext(adr, next)
        nimage(adr, image.L)
        return adr
    }
}