package vkk._10.structs

import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkImageCopy.*

/**
 * Structure specifying an image copy operation.
 *
 * <h5>Description</h5>
 *
 * <p>For {@link VK10#VK_IMAGE_TYPE_3D IMAGE_TYPE_3D} images, copies are performed slice by slice starting with the {@code z} member of the {@code srcOffset} or {@code dstOffset}, and copying {@code depth} slices. For images with multiple layers, copies are performed layer by layer starting with the {@code baseArrayLayer} member of the {@code srcSubresource} or {@code dstSubresource} and copying {@code layerCount} layers. Image data <b>can</b> be copied between images with different image types. If one image is {@link VK10#VK_IMAGE_TYPE_3D IMAGE_TYPE_3D} and the other image is {@link VK10#VK_IMAGE_TYPE_2D IMAGE_TYPE_2D} with multiple layers, then each slice is copied to or from a different layer.</p>
 *
 * <p>Copies involving a <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#formats-requiring-sampler-ycbcr-conversion">multi-planar image format</a> specify the region to be copied in terms of the <em>plane</em> to be copied, not the coordinates of the multi-planar image. This means that copies accessing the R/B planes of "{@code _422}" format images <b>must</b> fit the copied region within half the {@code width} of the parent image, and that copies accessing the R/B planes of "{@code _420}" format images <b>must</b> fit the copied region within half the {@code width} and {@code height} of the parent image.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>If neither the calling command&#8217;s {@code srcImage} nor the calling command&#8217;s {@code dstImage} has a <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#formats-requiring-sampler-ycbcr-conversion">multi-planar image format</a> then the {@code aspectMask} member of {@code srcSubresource} and {@code dstSubresource} <b>must</b> match</li>
 * <li>If the calling command&#8217;s {@code srcImage} has a {@code VkFormat} with <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#formats-requiring-sampler-ycbcr-conversion">two planes</a> then the {@code srcSubresource} {@code aspectMask} <b>must</b> be {@link VK11#VK_IMAGE_ASPECT_PLANE_0_BIT IMAGE_ASPECT_PLANE_0_BIT} or {@link VK11#VK_IMAGE_ASPECT_PLANE_1_BIT IMAGE_ASPECT_PLANE_1_BIT}</li>
 * <li>If the calling command&#8217;s {@code srcImage} has a {@code VkFormat} with <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#formats-requiring-sampler-ycbcr-conversion">three planes</a> then the {@code srcSubresource} {@code aspectMask} <b>must</b> be {@link VK11#VK_IMAGE_ASPECT_PLANE_0_BIT IMAGE_ASPECT_PLANE_0_BIT}, {@link VK11#VK_IMAGE_ASPECT_PLANE_1_BIT IMAGE_ASPECT_PLANE_1_BIT}, or {@link VK11#VK_IMAGE_ASPECT_PLANE_2_BIT IMAGE_ASPECT_PLANE_2_BIT}</li>
 * <li>If the calling command&#8217;s {@code dstImage} has a {@code VkFormat} with <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#formats-requiring-sampler-ycbcr-conversion">two planes</a> then the {@code dstSubresource} {@code aspectMask} <b>must</b> be {@link VK11#VK_IMAGE_ASPECT_PLANE_0_BIT IMAGE_ASPECT_PLANE_0_BIT} or {@link VK11#VK_IMAGE_ASPECT_PLANE_1_BIT IMAGE_ASPECT_PLANE_1_BIT}</li>
 * <li>If the calling command&#8217;s {@code dstImage} has a {@code VkFormat} with <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#formats-requiring-sampler-ycbcr-conversion">three planes</a> then the {@code dstSubresource} {@code aspectMask} <b>must</b> be {@link VK11#VK_IMAGE_ASPECT_PLANE_0_BIT IMAGE_ASPECT_PLANE_0_BIT}, {@link VK11#VK_IMAGE_ASPECT_PLANE_1_BIT IMAGE_ASPECT_PLANE_1_BIT}, or {@link VK11#VK_IMAGE_ASPECT_PLANE_2_BIT IMAGE_ASPECT_PLANE_2_BIT}</li>
 * <li>If the calling command&#8217;s {@code srcImage} has a <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#formats-requiring-sampler-ycbcr-conversion">multi-planar image format</a> and the {@code dstImage} does not have a multi-planar image format, the {@code dstSubresource} {@code aspectMask} <b>must</b> be {@link VK10#VK_IMAGE_ASPECT_COLOR_BIT IMAGE_ASPECT_COLOR_BIT}</li>
 * <li>If the calling command&#8217;s {@code dstImage} has a <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#formats-requiring-sampler-ycbcr-conversion">multi-planar image format</a> and the {@code srcImage} does not have a multi-planar image format, the {@code srcSubresource} {@code aspectMask} <b>must</b> be {@link VK10#VK_IMAGE_ASPECT_COLOR_BIT IMAGE_ASPECT_COLOR_BIT}</li>
 * <li>The number of slices of the {@code extent} (for 3D) or layers of the {@code srcSubresource} (for non-3D) <b>must</b> match the number of slices of the {@code extent} (for 3D) or layers of the {@code dstSubresource} (for non-3D)</li>
 * <li>If either of the calling command&#8217;s {@code srcImage} or {@code dstImage} parameters are of {@code VkImageType} {@link VK10#VK_IMAGE_TYPE_3D IMAGE_TYPE_3D}, the {@code baseArrayLayer} and {@code layerCount} members of the corresponding subresource <b>must</b> be 0 and 1, respectively</li>
 * <li>The {@code aspectMask} member of {@code srcSubresource} <b>must</b> specify aspects present in the calling command&#8217;s {@code srcImage}</li>
 * <li>The {@code aspectMask} member of {@code dstSubresource} <b>must</b> specify aspects present in the calling command&#8217;s {@code dstImage}</li>
 * <li>{@code srcOffset.x} and <code>(extent.width srcOffset.x)</code> <b>must</b> both be greater than or equal to 0 and less than or equal to the source image subresource width</li>
 * <li>{@code srcOffset.y} and <code>(extent.height srcOffset.y)</code> <b>must</b> both be greater than or equal to 0 and less than or equal to the source image subresource height</li>
 * <li>If the calling command&#8217;s {@code srcImage} is of type {@link VK10#VK_IMAGE_TYPE_1D IMAGE_TYPE_1D}, then {@code srcOffset.y} <b>must</b> be 0 and {@code extent.height} <b>must</b> be 1.</li>
 * <li>{@code srcOffset.z} and <code>(extent.depth srcOffset.z)</code> <b>must</b> both be greater than or equal to 0 and less than or equal to the source image subresource depth</li>
 * <li>If the calling command&#8217;s {@code srcImage} is of type {@link VK10#VK_IMAGE_TYPE_1D IMAGE_TYPE_1D}, then {@code srcOffset.z} <b>must</b> be 0 and {@code extent.depth} <b>must</b> be 1.</li>
 * <li>If the calling command&#8217;s {@code dstImage} is of type {@link VK10#VK_IMAGE_TYPE_1D IMAGE_TYPE_1D}, then {@code dstOffset.z} <b>must</b> be 0 and {@code extent.depth} <b>must</b> be 1.</li>
 * <li>If the calling command&#8217;s {@code srcImage} is of type {@link VK10#VK_IMAGE_TYPE_2D IMAGE_TYPE_2D}, then {@code srcOffset.z} <b>must</b> be 0.</li>
 * <li>If the calling command&#8217;s {@code dstImage} is of type {@link VK10#VK_IMAGE_TYPE_2D IMAGE_TYPE_2D}, then {@code dstOffset.z} <b>must</b> be 0.</li>
 * <li>If both {@code srcImage} and {@code dstImage} are of type {@link VK10#VK_IMAGE_TYPE_2D IMAGE_TYPE_2D} then {@code extent.depth} <b>must</b> be 1.</li>
 * <li>If the calling command&#8217;s {@code srcImage} is of type {@link VK10#VK_IMAGE_TYPE_2D IMAGE_TYPE_2D}, and the {@code dstImage} is of type {@link VK10#VK_IMAGE_TYPE_3D IMAGE_TYPE_3D}, then {@code extent.depth} <b>must</b> equal to the {@code layerCount} member of {@code srcSubresource}.</li>
 * <li>If the calling command&#8217;s {@code dstImage} is of type {@link VK10#VK_IMAGE_TYPE_2D IMAGE_TYPE_2D}, and the {@code srcImage} is of type {@link VK10#VK_IMAGE_TYPE_3D IMAGE_TYPE_3D}, then {@code extent.depth} <b>must</b> equal to the {@code layerCount} member of {@code dstSubresource}.</li>
 * <li>{@code dstOffset.x} and <code>(extent.width dstOffset.x)</code> <b>must</b> both be greater than or equal to 0 and less than or equal to the destination image subresource width</li>
 * <li>{@code dstOffset.y} and <code>(extent.height dstOffset.y)</code> <b>must</b> both be greater than or equal to 0 and less than or equal to the destination image subresource height</li>
 * <li>If the calling command&#8217;s {@code dstImage} is of type {@link VK10#VK_IMAGE_TYPE_1D IMAGE_TYPE_1D}, then {@code dstOffset.y} <b>must</b> be 0 and {@code extent.height} <b>must</b> be 1.</li>
 * <li>{@code dstOffset.z} and <code>(extent.depth dstOffset.z)</code> <b>must</b> both be greater than or equal to 0 and less than or equal to the destination image subresource depth</li>
 * <li>If the calling command&#8217;s {@code srcImage} is a compressed image, or a <em>single-plane</em>, “{@code _422}” image format, all members of {@code srcOffset} <b>must</b> be a multiple of the corresponding dimensions of the compressed texel block</li>
 * <li>If the calling command&#8217;s {@code srcImage} is a compressed image, or a <em>single-plane</em>, “{@code _422}” image format, {@code extent.width} <b>must</b> be a multiple of the compressed texel block width or <code>(extent.width + srcOffset.x)</code> <b>must</b> equal the source image subresource width</li>
 * <li>If the calling command&#8217;s {@code srcImage} is a compressed image, or a <em>single-plane</em>, “{@code _422}” image format, {@code extent.height} <b>must</b> be a multiple of the compressed texel block height or <code>(extent.height + srcOffset.y)</code> <b>must</b> equal the source image subresource height</li>
 * <li>If the calling command&#8217;s {@code srcImage} is a compressed image, or a <em>single-plane</em>, “{@code _422}” image format, {@code extent.depth} <b>must</b> be a multiple of the compressed texel block depth or <code>(extent.depth + srcOffset.z)</code> <b>must</b> equal the source image subresource depth</li>
 * <li>If the calling command&#8217;s {@code dstImage} is a compressed format image, or a <em>single-plane</em>, “{@code _422}” image format, all members of {@code dstOffset} <b>must</b> be a multiple of the corresponding dimensions of the compressed texel block</li>
 * <li>If the calling command&#8217;s {@code dstImage} is a compressed format image, or a <em>single-plane</em>, “{@code _422}” image format, {@code extent.width} <b>must</b> be a multiple of the compressed texel block width or <code>(extent.width + dstOffset.x)</code> <b>must</b> equal the destination image subresource width</li>
 * <li>If the calling command&#8217;s {@code dstImage} is a compressed format image, or a <em>single-plane</em>, “{@code _422}” image format, {@code extent.height} <b>must</b> be a multiple of the compressed texel block height or <code>(extent.height + dstOffset.y)</code> <b>must</b> equal the destination image subresource height</li>
 * <li>If the calling command&#8217;s {@code dstImage} is a compressed format image, or a <em>single-plane</em>, “{@code _422}” image format, {@code extent.depth} <b>must</b> be a multiple of the compressed texel block depth or <code>(extent.depth + dstOffset.z)</code> <b>must</b> equal the destination image subresource depth</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code srcSubresource} <b>must</b> be a valid {@link VkImageSubresourceLayers} structure</li>
 * <li>{@code dstSubresource} <b>must</b> be a valid {@link VkImageSubresourceLayers} structure</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkExtent3D}, {@link VkImageSubresourceLayers}, {@link VkOffset3D}, {@link VK10#vkCmdCopyImage CmdCopyImage}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code srcSubresource} &ndash; {@code srcSubresource} and {@code dstSubresource} are {@link VkImageSubresourceLayers} structures specifying the image subresources of the images used for the source and destination image data, respectively.</li>
 * <li>{@code srcOffset} &ndash; {@code srcOffset} and {@code dstOffset} select the initial {@code x}, {@code y}, and {@code z} offsets in texels of the sub-regions of the source and destination image data.</li>
 * <li>{@code dstSubresource} &ndash; see {@code srcSubresource}</li>
 * <li>{@code dstOffset} &ndash; see {@code srcOffset}</li>
 * <li>{@code extent} &ndash; the size in texels of the image to copy in {@code width}, {@code height} and {@code depth}.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkImageCopy {
 *     {@link VkImageSubresourceLayers VkImageSubresourceLayers} srcSubresource;
 *     {@link VkOffset3D VkOffset3D} srcOffset;
 *     {@link VkImageSubresourceLayers VkImageSubresourceLayers} dstSubresource;
 *     {@link VkOffset3D VkOffset3D} dstOffset;
 *     {@link VkExtent3D VkExtent3D} extent;
 * }</code></pre>
 */
class ImageCopy(
        var srcSubresource: ImageSubresourceLayers,
        var srcOffset: Offset3D,
        var dstSubresource: ImageSubresourceLayers,
        var dstOffset: Offset3D,
        var extent: Extent3D
) {

    infix fun write(stack: MemoryStack): Adr =
        stack.ncalloc(ALIGNOF, 1, SIZEOF).also { write(it) }

    infix fun write(adr: Adr) {
        srcSubresource write (adr + SRCSUBRESOURCE)
        srcOffset write (adr + SRCOFFSET)
        dstSubresource write (adr + DSTSUBRESOURCE)
        dstOffset write (adr + DSTOFFSET)
        extent write (adr + EXTENT)
    }
}

infix fun Array<ImageCopy>.write(stack: MemoryStack): Ptr {
    val natives = stack.ncalloc(ALIGNOF, size, SIZEOF)
    for (i in indices)
        this[i] write (natives + i * SIZEOF)
    return natives
}