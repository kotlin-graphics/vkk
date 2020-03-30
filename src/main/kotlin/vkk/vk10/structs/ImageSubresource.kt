package vkk.vk10.structs

import kool.Adr
import org.lwjgl.vulkan.VkImageSubresource.*
import vkk.VkImageAspectFlags
import vkk.VkStack

/**
 * Structure specifying an image subresource.
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
 * <p>{@link VkSparseImageMemoryBind}, {@link VK10#vkGetImageSubresourceLayout GetImageSubresourceLayout}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code aspectMask} &ndash; a {@code VkImageAspectFlags} selecting the image <em>aspect</em>.</li>
 * <li>{@code mipLevel} &ndash; selects the mipmap level.</li>
 * <li>{@code arrayLayer} &ndash; selects the array layer.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkImageSubresource {
 *     VkImageAspectFlags aspectMask;
 *     uint32_t mipLevel;
 *     uint32_t arrayLayer;
 * }</code></pre>
 */
class ImageSubresource(
        var aspectMask: VkImageAspectFlags,
        var mipLevel: Int,
        var arrayLayer: Int = 0
) {

    infix fun write(stack: VkStack): Adr =
            stack.ncalloc(ALIGNOF, 1, SIZEOF).also { write(it) }

    infix fun write(adr: Adr) {
        naspectMask(adr, aspectMask)
        nmipLevel(adr, mipLevel)
        narrayLayer(adr, arrayLayer)
    }
}