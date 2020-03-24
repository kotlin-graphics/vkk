package vkk._10.structs

import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkBufferImageCopy.*
import vkk.VkStack
import vkk.entities.VkDeviceSize

/**
 * Structure specifying a buffer image copy operation.
 *
 * <h5>Description</h5>
 *
 * <p>When copying to or from a depth or stencil aspect, the data in buffer memory uses a layout that is a (mostly) tightly packed representation of the depth or stencil data. Specifically:</p>
 *
 * <ul>
 * <li>data copied to or from the stencil aspect of any depth/stencil format is tightly packed with one {@link VK10#VK_FORMAT_S8_UINT FORMAT_S8_UINT} value per texel.</li>
 * <li>data copied to or from the depth aspect of a {@link VK10#VK_FORMAT_D16_UNORM FORMAT_D16_UNORM} or {@link VK10#VK_FORMAT_D16_UNORM_S8_UINT FORMAT_D16_UNORM_S8_UINT} format is tightly packed with one {@link VK10#VK_FORMAT_D16_UNORM FORMAT_D16_UNORM} value per texel.</li>
 * <li>data copied to or from the depth aspect of a {@link VK10#VK_FORMAT_D32_SFLOAT FORMAT_D32_SFLOAT} or {@link VK10#VK_FORMAT_D32_SFLOAT_S8_UINT FORMAT_D32_SFLOAT_S8_UINT} format is tightly packed with one {@link VK10#VK_FORMAT_D32_SFLOAT FORMAT_D32_SFLOAT} value per texel.</li>
 * <li>data copied to or from the depth aspect of a {@link VK10#VK_FORMAT_X8_D24_UNORM_PACK32 FORMAT_X8_D24_UNORM_PACK32} or {@link VK10#VK_FORMAT_D24_UNORM_S8_UINT FORMAT_D24_UNORM_S8_UINT} format is packed with one 32-bit word per texel with the D24 value in the LSBs of the word, and undefined values in the eight MSBs.</li>
 * </ul>
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>To copy both the depth and stencil aspects of a depth/stencil format, two entries in {@code pRegions} <b>can</b> be used, where one specifies the depth aspect in {@code imageSubresource}, and the other specifies the stencil aspect.</p>
 * </div>
 *
 * <p>Because depth or stencil aspect buffer to image copies <b>may</b> require format conversions on some implementations, they are not supported on queues that do not support graphics.</p>
 *
 * <p>When copying to a depth aspect, and the VK_EXT_depth_range_unrestricted extension is not enabled, the data in buffer memory <b>must</b> be in the range <code>[0,1]</code>, or the resulting values are undefined.</p>
 *
 * <p>Copies are done layer by layer starting with image layer {@code baseArrayLayer} member of {@code imageSubresource}. {@code layerCount} layers are copied from the source image or to the destination image.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>If the calling command&#8217;s {@code VkImage} parameter&#8217;s format is not a depth/stencil format or a <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#formats-requiring-sampler-ycbcr-conversion">multi-planar format</a>, then {@code bufferOffset} <b>must</b> be a multiple of the format&#8217;s texel block size.</li>
 * <li>If the calling command&#8217;s {@code VkImage} parameter&#8217;s format is a <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#formats-requiring-sampler-ycbcr-conversion">multi-planar format</a>, then {@code bufferOffset} <b>must</b> be a multiple of the element size of the compatible format for the format and the {@code aspectMask} of the {@code imageSubresource} as defined in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#formats-compatible-planes">Compatible formats of planes of multi-planar formats</a></li>
 * <li>{@code bufferOffset} <b>must</b> be a multiple of 4</li>
 * <li>{@code bufferRowLength} <b>must</b> be 0, or greater than or equal to the {@code width} member of {@code imageExtent}</li>
 * <li>{@code bufferImageHeight} <b>must</b> be 0, or greater than or equal to the {@code height} member of {@code imageExtent}</li>
 * <li>{@code imageOffset.x} and <code>(imageExtent.width imageOffset.x)</code> <b>must</b> both be greater than or equal to 0 and less than or equal to the image subresource width where this refers to the width of the <em>plane</em> of the image involved in the copy in the case of a <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#formats-requiring-sampler-ycbcr-conversion">multi-planar format</a></li>
 * <li>{@code imageOffset.y} and <code>(imageExtent.height imageOffset.y)</code> <b>must</b> both be greater than or equal to 0 and less than or equal to the image subresource height where this refers to the height of the <em>plane</em> of the image involved in the copy in the case of a <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#formats-requiring-sampler-ycbcr-conversion">multi-planar format</a></li>
 * <li>If the calling command&#8217;s {@code srcImage} ({@link VK10#vkCmdCopyImageToBuffer CmdCopyImageToBuffer}) or {@code dstImage} ({@link VK10#vkCmdCopyBufferToImage CmdCopyBufferToImage}) is of type {@link VK10#VK_IMAGE_TYPE_1D IMAGE_TYPE_1D}, then {@code imageOffset.y} <b>must</b> be 0 and {@code imageExtent.height} <b>must</b> be 1.</li>
 * <li>{@code imageOffset.z} and <code>(imageExtent.depth imageOffset.z)</code> <b>must</b> both be greater than or equal to 0 and less than or equal to the image subresource depth</li>
 * <li>If the calling command&#8217;s {@code srcImage} ({@link VK10#vkCmdCopyImageToBuffer CmdCopyImageToBuffer}) or {@code dstImage} ({@link VK10#vkCmdCopyBufferToImage CmdCopyBufferToImage}) is of type {@link VK10#VK_IMAGE_TYPE_1D IMAGE_TYPE_1D} or {@link VK10#VK_IMAGE_TYPE_2D IMAGE_TYPE_2D}, then {@code imageOffset.z} <b>must</b> be 0 and {@code imageExtent.depth} <b>must</b> be 1</li>
 * <li>If the calling command&#8217;s {@code VkImage} parameter is a compressed image, or a <em>single-plane</em>, “{@code _422}” image format, {@code bufferRowLength} <b>must</b> be a multiple of the compressed texel block width</li>
 * <li>If the calling command&#8217;s {@code VkImage} parameter is a compressed image, or a <em>single-plane</em>, “{@code _422}” image format, {@code bufferImageHeight} <b>must</b> be a multiple of the compressed texel block height</li>
 * <li>If the calling command&#8217;s {@code VkImage} parameter is a compressed image, or a <em>single-plane</em>, “{@code _422}” image format, all members of {@code imageOffset} <b>must</b> be a multiple of the corresponding dimensions of the compressed texel block</li>
 * <li>If the calling command&#8217;s {@code VkImage} parameter is a compressed image, or a <em>single-plane</em>, “{@code _422}” image format, {@code bufferOffset} <b>must</b> be a multiple of the compressed texel block size in bytes</li>
 * <li>If the calling command&#8217;s {@code VkImage} parameter is a compressed image, or a <em>single-plane</em>, “{@code _422}” image format, {@code imageExtent.width} <b>must</b> be a multiple of the compressed texel block width or <code>(imageExtent.width imageOffset.x)</code> <b>must</b> equal the image subresource width</li>
 * <li>If the calling command&#8217;s {@code VkImage} parameter is a compressed image, or a <em>single-plane</em>, “{@code _422}” image format, {@code imageExtent.height} <b>must</b> be a multiple of the compressed texel block height or <code>(imageExtent.height imageOffset.y)</code> <b>must</b> equal the image subresource height</li>
 * <li>If the calling command&#8217;s {@code VkImage} parameter is a compressed image, or a <em>single-plane</em>, “{@code _422}” image format, {@code imageExtent.depth} <b>must</b> be a multiple of the compressed texel block depth or <code>(imageExtent.depth imageOffset.z)</code> <b>must</b> equal the image subresource depth</li>
 * <li>The {@code aspectMask} member of {@code imageSubresource} <b>must</b> specify aspects present in the calling command&#8217;s {@code VkImage} parameter</li>
 * <li>If the calling command&#8217;s {@code VkImage} parameter&#8217;s format is a <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#formats-requiring-sampler-ycbcr-conversion">multi-planar format</a>, then the {@code aspectMask} member of {@code imageSubresource} <b>must</b> be {@link VK11#VK_IMAGE_ASPECT_PLANE_0_BIT IMAGE_ASPECT_PLANE_0_BIT}, {@link VK11#VK_IMAGE_ASPECT_PLANE_1_BIT IMAGE_ASPECT_PLANE_1_BIT}, or {@link VK11#VK_IMAGE_ASPECT_PLANE_2_BIT IMAGE_ASPECT_PLANE_2_BIT} (with {@link VK11#VK_IMAGE_ASPECT_PLANE_2_BIT IMAGE_ASPECT_PLANE_2_BIT} valid only for image formats with three planes)</li>
 * <li>The {@code aspectMask} member of {@code imageSubresource} <b>must</b> only have a single bit set</li>
 * <li>If the calling command&#8217;s {@code VkImage} parameter is of {@code VkImageType} {@link VK10#VK_IMAGE_TYPE_3D IMAGE_TYPE_3D}, the {@code baseArrayLayer} and {@code layerCount} members of {@code imageSubresource} <b>must</b> be 0 and 1, respectively</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code imageSubresource} <b>must</b> be a valid {@link VkImageSubresourceLayers} structure</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkExtent3D}, {@link VkImageSubresourceLayers}, {@link VkOffset3D}, {@link VK10#vkCmdCopyBufferToImage CmdCopyBufferToImage}, {@link VK10#vkCmdCopyImageToBuffer CmdCopyImageToBuffer}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code bufferOffset} &ndash; the offset in bytes from the start of the buffer object where the image data is copied from or to.</li>
 * <li>{@code bufferRowLength} &ndash; {@code bufferRowLength} and {@code bufferImageHeight} specify in texels a subregion of a larger two- or three-dimensional image in buffer memory, and control the addressing calculations. If either of these values is zero, that aspect of the buffer memory is considered to be tightly packed according to the {@code imageExtent}.</li>
 * <li>{@code bufferImageHeight} &ndash; see {@code bufferRowLength}</li>
 * <li>{@code imageSubresource} &ndash; a {@link VkImageSubresourceLayers} used to specify the specific image subresources of the image used for the source or destination image data.</li>
 * <li>{@code imageOffset} &ndash; selects the initial {@code x}, {@code y}, {@code z} offsets in texels of the sub-region of the source or destination image data.</li>
 * <li>{@code imageExtent} &ndash; the size in texels of the image to copy in {@code width}, {@code height} and {@code depth}.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkBufferImageCopy {
 *     VkDeviceSize bufferOffset;
 *     uint32_t bufferRowLength;
 *     uint32_t bufferImageHeight;
 *     {@link VkImageSubresourceLayers VkImageSubresourceLayers} imageSubresource;
 *     {@link VkOffset3D VkOffset3D} imageOffset;
 *     {@link VkExtent3D VkExtent3D} imageExtent;
 * }</code></pre>
 */
class BufferImageCopy(
        var bufferOffset: VkDeviceSize = VkDeviceSize(0),
        var bufferRowLength: Int = 0,
        var bufferImageHeight: Int = 0,
        var imageSubresource: ImageSubresourceLayers,
        var imageOffset: Offset3D = Offset3D(),
        var imageExtent: Extent3D
) {

    infix fun write(stack: VkStack): Adr =
        stack.ncalloc(ALIGNOF, 1, SIZEOF).also { write(it) }

    infix fun write(adr: Adr) {
        nbufferOffset(adr, bufferOffset.L)
        nbufferRowLength(adr, bufferRowLength)
        nbufferImageHeight(adr, bufferImageHeight)
        imageSubresource write (adr + IMAGESUBRESOURCE)
        imageOffset write (adr + IMAGEOFFSET)
        imageExtent write (adr + IMAGEEXTENT)
    }
}

infix fun Array<BufferImageCopy>.write(stack: VkStack): Ptr {
    val natives = stack.ncalloc(ALIGNOF, size, SIZEOF)
    for (i in indices)
        this[i] write (natives + i * SIZEOF)
    return natives
}