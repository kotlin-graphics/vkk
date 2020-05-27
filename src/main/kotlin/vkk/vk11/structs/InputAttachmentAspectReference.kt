package vkk.vk11.structs

import vkk.VkImageAspectFlags

/**
 * Structure specifying a subpass/input attachment pair and an aspect mask that <b>can</b> be read.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code aspectMask} <b>must</b> not include {@link VK10#VK_IMAGE_ASPECT_METADATA_BIT IMAGE_ASPECT_METADATA_BIT}</li>
 * <li>{@code aspectMask} <b>must</b> not include {@code VK_IMAGE_ASPECT_MEMORY_PLANE_i_BIT_EXT} for any index {@code i}.</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code aspectMask} <b>must</b> be a valid combination of {@code VkImageAspectFlagBits} values</li>
 * <li>{@code aspectMask} <b>must</b> not be 0</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkRenderPassInputAttachmentAspectCreateInfo}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code subpass} &ndash; an index into the {@code pSubpasses} array of the parent {@link VkRenderPassCreateInfo} structure.</li>
 * <li>{@code inputAttachmentIndex} &ndash; an index into the {@code pInputAttachments} of the specified subpass.</li>
 * <li>{@code aspectMask} &ndash; a mask of which aspect(s) <b>can</b> be accessed within the specified subpass.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkInputAttachmentAspectReference {
 *     uint32_t subpass;
 *     uint32_t inputAttachmentIndex;
 *     VkImageAspectFlags aspectMask;
 * }</code></pre>
 */
class InputAttachmentAspectReference(
        var subpass: Int,
        var inputAttachmentIndex: Int,
        var aspectMask: VkImageAspectFlags
) {
}