package vkk.vk10.structs

import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkImageResolve.*

/**
 * Structure specifying an image resolve operation.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>The {@code aspectMask} member of {@code srcSubresource} and {@code dstSubresource} <b>must</b> only contain {@link VK10#VK_IMAGE_ASPECT_COLOR_BIT IMAGE_ASPECT_COLOR_BIT}</li>
 * <li>The {@code layerCount} member of {@code srcSubresource} and {@code dstSubresource} <b>must</b> match</li>
 * <li>If either of the calling command&#8217;s {@code srcImage} or {@code dstImage} parameters are of {@code VkImageType} {@link VK10#VK_IMAGE_TYPE_3D IMAGE_TYPE_3D}, the {@code baseArrayLayer} and {@code layerCount} members of both {@code srcSubresource} and {@code dstSubresource} <b>must</b> be 0 and 1, respectively</li>
 * <li>{@code srcOffset.x} and <code>(extent.width srcOffset.x)</code> <b>must</b> both be greater than or equal to 0 and less than or equal to the source image subresource width</li>
 * <li>{@code srcOffset.y} and <code>(extent.height srcOffset.y)</code> <b>must</b> both be greater than or equal to 0 and less than or equal to the source image subresource height</li>
 * <li>If the calling command&#8217;s {@code srcImage} is of type {@link VK10#VK_IMAGE_TYPE_1D IMAGE_TYPE_1D}, then {@code srcOffset.y} <b>must</b> be 0 and {@code extent.height} <b>must</b> be 1.</li>
 * <li>{@code srcOffset.z} and <code>(extent.depth srcOffset.z)</code> <b>must</b> both be greater than or equal to 0 and less than or equal to the source image subresource depth</li>
 * <li>If the calling command&#8217;s {@code srcImage} is of type {@link VK10#VK_IMAGE_TYPE_1D IMAGE_TYPE_1D} or {@link VK10#VK_IMAGE_TYPE_2D IMAGE_TYPE_2D}, then {@code srcOffset.z} <b>must</b> be 0 and {@code extent.depth} <b>must</b> be 1.</li>
 * <li>{@code dstOffset.x} and <code>(extent.width dstOffset.x)</code> <b>must</b> both be greater than or equal to 0 and less than or equal to the destination image subresource width</li>
 * <li>{@code dstOffset.y} and <code>(extent.height dstOffset.y)</code> <b>must</b> both be greater than or equal to 0 and less than or equal to the destination image subresource height</li>
 * <li>If the calling command&#8217;s {@code dstImage} is of type {@link VK10#VK_IMAGE_TYPE_1D IMAGE_TYPE_1D}, then {@code dstOffset.y} <b>must</b> be 0 and {@code extent.height} <b>must</b> be 1.</li>
 * <li>{@code dstOffset.z} and <code>(extent.depth dstOffset.z)</code> <b>must</b> both be greater than or equal to 0 and less than or equal to the destination image subresource depth</li>
 * <li>If the calling command&#8217;s {@code dstImage} is of type {@link VK10#VK_IMAGE_TYPE_1D IMAGE_TYPE_1D} or {@link VK10#VK_IMAGE_TYPE_2D IMAGE_TYPE_2D}, then {@code dstOffset.z} <b>must</b> be 0 and {@code extent.depth} <b>must</b> be 1.</li>
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
 * <p>{@link VkExtent3D}, {@link VkImageSubresourceLayers}, {@link VkOffset3D}, {@link VK10#vkCmdResolveImage CmdResolveImage}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code srcSubresource} &ndash; {@code srcSubresource} and {@code dstSubresource} are {@link VkImageSubresourceLayers} structures specifying the image subresources of the images used for the source and destination image data, respectively. Resolve of depth/stencil images is not supported.</li>
 * <li>{@code srcOffset} &ndash; {@code srcOffset} and {@code dstOffset} select the initial {@code x}, {@code y}, and {@code z} offsets in texels of the sub-regions of the source and destination image data.</li>
 * <li>{@code dstSubresource} &ndash; see {@code srcSubresource}</li>
 * <li>{@code dstOffset} &ndash; see {@code srcOffset}</li>
 * <li>{@code extent} &ndash; the size in texels of the source image to resolve in {@code width}, {@code height} and {@code depth}.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkImageResolve {
 *     {@link VkImageSubresourceLayers VkImageSubresourceLayers} srcSubresource;
 *     {@link VkOffset3D VkOffset3D} srcOffset;
 *     {@link VkImageSubresourceLayers VkImageSubresourceLayers} dstSubresource;
 *     {@link VkOffset3D VkOffset3D} dstOffset;
 *     {@link VkExtent3D VkExtent3D} extent;
 * }</code></pre>
 */
class ImageResolve(
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

infix fun Array<ImageResolve>.write(stack: MemoryStack): Ptr {
    val natives = stack.ncalloc(ALIGNOF, size, SIZEOF)
    for (i in indices)
        this[i] write (natives + i * SIZEOF)
    return natives
}