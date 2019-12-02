package vkk._10.structs

import kool.Adr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkImageSubresourceLayers.*
import vkk.VkImageAspectFlags

/**
 * Structure specifying an image subresource layers.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>If {@code aspectMask} contains {@link VK10#VK_IMAGE_ASPECT_COLOR_BIT IMAGE_ASPECT_COLOR_BIT}, it <b>must</b> not contain either of {@link VK10#VK_IMAGE_ASPECT_DEPTH_BIT IMAGE_ASPECT_DEPTH_BIT} or {@link VK10#VK_IMAGE_ASPECT_STENCIL_BIT IMAGE_ASPECT_STENCIL_BIT}</li>
 * <li>{@code aspectMask} <b>must</b> not contain {@link VK10#VK_IMAGE_ASPECT_METADATA_BIT IMAGE_ASPECT_METADATA_BIT}</li>
 * <li>{@code aspectMask} <b>must</b> not include {@code VK_IMAGE_ASPECT_MEMORY_PLANE_i_BIT_EXT} for any index {@code i}.</li>
 * <li>{@code layerCount} <b>must</b> be greater than 0</li>
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
 * <p>{@link VkBufferImageCopy}, {@link VkImageBlit}, {@link VkImageCopy}, {@link VkImageResolve}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code aspectMask} &ndash; a combination of {@code VkImageAspectFlagBits}, selecting the color, depth and/or stencil aspects to be copied.</li>
 * <li>{@code mipLevel} &ndash; the mipmap level to copy from.</li>
 * <li>{@code baseArrayLayer} &ndash; {@code baseArrayLayer} and {@code layerCount} are the starting layer and number of layers to copy.</li>
 * <li>{@code layerCount} &ndash; see {@code baseArrayLayer}</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkImageSubresourceLayers {
 *     VkImageAspectFlags aspectMask;
 *     uint32_t mipLevel;
 *     uint32_t baseArrayLayer;
 *     uint32_t layerCount;
 * }</code></pre>
 */
class ImageSubresourceLayers(
        var aspectMask: VkImageAspectFlags,
        var mipLevel: Int,
        var baseArrayLayer: Int,
        var layerCount: Int
) {

    infix fun write(stack: MemoryStack): Adr =
            stack.ncalloc(ALIGNOF, 1, SIZEOF).also { write(it) }

    infix fun write(adr: Adr) {
        naspectMask(adr, aspectMask)
        nmipLevel(adr, mipLevel)
        nbaseArrayLayer(adr, baseArrayLayer)
        nlayerCount(adr, layerCount)
    }
}