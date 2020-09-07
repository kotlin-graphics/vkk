package vkk.vk10.structs

import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkImageBlit.*

/**
 * Structure specifying an image blit operation.
 *
 * <h5>Description</h5>
 *
 * <p>For each element of the {@code pRegions} array, a blit operation is performed the specified source and destination regions.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>The {@code aspectMask} member of {@code srcSubresource} and {@code dstSubresource} <b>must</b> match</li>
 * <li>The {@code layerCount} member of {@code srcSubresource} and {@code dstSubresource} <b>must</b> match</li>
 * <li>If either of the calling command&#8217;s {@code srcImage} or {@code dstImage} parameters are of {@code VkImageType} {@link VK10#VK_IMAGE_TYPE_3D IMAGE_TYPE_3D}, the {@code baseArrayLayer} and {@code layerCount} members of both {@code srcSubresource} and {@code dstSubresource} <b>must</b> be 0 and 1, respectively</li>
 * <li>The {@code aspectMask} member of {@code srcSubresource} <b>must</b> specify aspects present in the calling command&#8217;s {@code srcImage}</li>
 * <li>The {@code aspectMask} member of {@code dstSubresource} <b>must</b> specify aspects present in the calling command&#8217;s {@code dstImage}</li>
 * <li>{@code srcOffset}[0].{@code x} and {@code srcOffset}[1].{@code x} <b>must</b> both be greater than or equal to 0 and less than or equal to the source image subresource width</li>
 * <li>{@code srcOffset}[0].{@code y} and {@code srcOffset}[1].{@code y} <b>must</b> both be greater than or equal to 0 and less than or equal to the source image subresource height</li>
 * <li>If the calling command&#8217;s {@code srcImage} is of type {@link VK10#VK_IMAGE_TYPE_1D IMAGE_TYPE_1D}, then {@code srcOffset}[0].y <b>must</b> be 0 and {@code srcOffset}[1].y <b>must</b> be 1.</li>
 * <li>{@code srcOffset}[0].{@code z} and {@code srcOffset}[1].{@code z} <b>must</b> both be greater than or equal to 0 and less than or equal to the source image subresource depth</li>
 * <li>If the calling command&#8217;s {@code srcImage} is of type {@link VK10#VK_IMAGE_TYPE_1D IMAGE_TYPE_1D} or {@link VK10#VK_IMAGE_TYPE_2D IMAGE_TYPE_2D}, then {@code srcOffset}[0].z <b>must</b> be 0 and {@code srcOffset}[1].z <b>must</b> be 1.</li>
 * <li>{@code dstOffset}[0].{@code x} and {@code dstOffset}[1].{@code x} <b>must</b> both be greater than or equal to 0 and less than or equal to the destination image subresource width</li>
 * <li>{@code dstOffset}[0].{@code y} and {@code dstOffset}[1].{@code y} <b>must</b> both be greater than or equal to 0 and less than or equal to the destination image subresource height</li>
 * <li>If the calling command&#8217;s {@code dstImage} is of type {@link VK10#VK_IMAGE_TYPE_1D IMAGE_TYPE_1D}, then {@code dstOffset}[0].y <b>must</b> be 0 and {@code dstOffset}[1].y <b>must</b> be 1.</li>
 * <li>{@code dstOffset}[0].{@code z} and {@code dstOffset}[1].{@code z} <b>must</b> both be greater than or equal to 0 and less than or equal to the destination image subresource depth</li>
 * <li>If the calling command&#8217;s {@code dstImage} is of type {@link VK10#VK_IMAGE_TYPE_1D IMAGE_TYPE_1D} or {@link VK10#VK_IMAGE_TYPE_2D IMAGE_TYPE_2D}, then {@code dstOffset}[0].z <b>must</b> be 0 and {@code dstOffset}[1].z <b>must</b> be 1.</li>
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
 * <p>{@link VkImageSubresourceLayers}, {@link VkOffset3D}, {@link VK10#vkCmdBlitImage CmdBlitImage}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code srcSubresource} &ndash; the subresource to blit from.</li>
 * <li>{@code srcOffsets[2]} &ndash; an array of two {@link VkOffset3D} structures specifying the bounds of the source region within {@code srcSubresource}.</li>
 * <li>{@code dstSubresource} &ndash; the subresource to blit into.</li>
 * <li>{@code dstOffsets[2]} &ndash; an array of two {@link VkOffset3D} structures specifying the bounds of the destination region within {@code dstSubresource}.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkImageBlit {
 *     {@link VkImageSubresourceLayers VkImageSubresourceLayers} srcSubresource;
 *     {@link VkOffset3D VkOffset3D} srcOffsets[2];
 *     {@link VkImageSubresourceLayers VkImageSubresourceLayers} dstSubresource;
 *     {@link VkOffset3D VkOffset3D} dstOffsets[2];
 * }</code></pre>
 */
class ImageBlit(
        var srcSubresource: ImageSubresourceLayers,
        var srcOffsets: Array<Offset3D>,
        var dstSubresource: ImageSubresourceLayers,
        var dstOffsets: Array<Offset3D>
) {

    infix fun write(stack: MemoryStack): Adr =
        stack.ncalloc(ALIGNOF, 1, SIZEOF).also { write(it) }

    infix fun write(adr: Adr) {
        srcSubresource write (adr + SRCSUBRESOURCE)
        srcOffsets write (adr + SRCOFFSETS)
        dstSubresource write (adr + DSTSUBRESOURCE)
        dstOffsets write (adr + DSTOFFSETS)
    }
}

infix fun Array<ImageBlit>.write(stack: MemoryStack): Ptr {
    val natives = stack.ncalloc(ALIGNOF, size, SIZEOF)
    for (i in indices)
        this[i] write (natives + i * SIZEOF)
    return natives
}