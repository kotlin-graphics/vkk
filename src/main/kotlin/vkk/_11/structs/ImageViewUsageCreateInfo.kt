package vkk._11.structs

import kool.Ptr
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.NULL
import vkk.VkImageUsageFlags
import vkk.VkStructureType

/**
 * Specify the intended usage of an image view.
 *
 * <h5>Description</h5>
 *
 * <p>When this structure is chained to {@link VkImageViewCreateInfo} the {@code usage} field overrides the implicit {@code usage} parameter inherited from image creation time and its value is used instead for the purposes of determining the valid usage conditions of {@link VkImageViewCreateInfo}.</p>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_IMAGE_VIEW_USAGE_CREATE_INFO STRUCTURE_TYPE_IMAGE_VIEW_USAGE_CREATE_INFO}</li>
 * <li>{@code usage} <b>must</b> be a valid combination of {@code VkImageUsageFlagBits} values</li>
 * <li>{@code usage} <b>must</b> not be 0</li>
 * </ul>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code usage} &ndash; a bitmask describing the allowed usages of the image view. See {@code VkImageUsageFlagBits} for a description of the supported bits.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkImageViewUsageCreateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkImageUsageFlags usage;
 * }</code></pre>
 */
class ImageViewUsageCreateInfo(
        var usage: VkImageUsageFlags,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.IMAGE_VIEW_USAGE_CREATE_INFO
}