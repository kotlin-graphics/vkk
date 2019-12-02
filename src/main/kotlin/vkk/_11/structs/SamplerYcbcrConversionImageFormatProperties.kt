package vkk._11.structs

import kool.Ptr
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.NULL
import vkk.VkStructureType

/**
 * Structure specifying combined image sampler descriptor count for multi-planar images.
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_SAMPLER_YCBCR_CONVERSION_IMAGE_FORMAT_PROPERTIES STRUCTURE_TYPE_SAMPLER_YCBCR_CONVERSION_IMAGE_FORMAT_PROPERTIES}</li>
 * </ul>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code combinedImageSamplerDescriptorCount} &ndash; the number of combined image sampler descriptors that the implementation uses to access the format.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkSamplerYcbcrConversionImageFormatProperties {
 *     VkStructureType sType;
 *     void * pNext;
 *     uint32_t combinedImageSamplerDescriptorCount;
 * }</code></pre>
 */
class SamplerYcbcrConversionImageFormatProperties(
    var combinedImageSamplerDescriptorCount: Int,
    var next: Ptr = NULL
) {

    val type get() = VkStructureType.SAMPLER_YCBCR_CONVERSION_IMAGE_FORMAT_PROPERTIES
}