package vkk._10.structs

import kool.Adr
import kool.BytePtr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkSubresourceLayout.*
import vkk.VkStack
import vkk.entities.VkDeviceSize
import vkk.stak

/**
 * Structure specifying subresource layout.
 *
 * <h5>Description</h5>
 *
 * <p>If the image is <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#glossary-linear-resource">linear</a>, then {@code rowPitch}, {@code arrayPitch} and {@code depthPitch} describe the layout of the image subresource in linear memory. For uncompressed formats, {@code rowPitch} is the number of bytes between texels with the same x coordinate in adjacent rows (y coordinates differ by one). {@code arrayPitch} is the number of bytes between texels with the same x and y coordinate in adjacent array layers of the image (array layer values differ by one). {@code depthPitch} is the number of bytes between texels with the same x and y coordinate in adjacent slices of a 3D image (z coordinates differ by one). Expressed as an addressing formula, the starting byte of a texel in the image subresource has address:</p>
 *
 * <pre><code>
 * // (x,y,z,layer) are in texel coordinates
 * address(x,y,z,layer) = layer*arrayPitch + z*depthPitch + y*rowPitch + x*elementSize + offset</code></pre>
 *
 * <p>For compressed formats, the {@code rowPitch} is the number of bytes between compressed texel blocks in adjacent rows. {@code arrayPitch} is the number of bytes between compressed texel blocks in adjacent array layers. {@code depthPitch} is the number of bytes between compressed texel blocks in adjacent slices of a 3D image.</p>
 *
 * <pre><code>
 * // (x,y,z,layer) are in compressed texel block coordinates
 * address(x,y,z,layer) = layer*arrayPitch + z*depthPitch + y*rowPitch + x*compressedTexelBlockByteSize + offset;</code></pre>
 *
 * <p>The value of {@code arrayPitch} is undefined for images that were not created as arrays. {@code depthPitch} is defined only for 3D images.</p>
 *
 * <p>If the image has a <em>single-plane</em> color format and its tiling is {@link VK10#VK_IMAGE_TILING_LINEAR IMAGE_TILING_LINEAR} , then the {@code aspectMask} member of {@link VkImageSubresource} <b>must</b> be {@link VK10#VK_IMAGE_ASPECT_COLOR_BIT IMAGE_ASPECT_COLOR_BIT}.</p>
 *
 * <p>If the image has a depth/stencil format and its tiling is {@link VK10#VK_IMAGE_TILING_LINEAR IMAGE_TILING_LINEAR} , then {@code aspectMask} <b>must</b> be either {@link VK10#VK_IMAGE_ASPECT_DEPTH_BIT IMAGE_ASPECT_DEPTH_BIT} or {@link VK10#VK_IMAGE_ASPECT_STENCIL_BIT IMAGE_ASPECT_STENCIL_BIT}. On implementations that store depth and stencil aspects separately, querying each of these image subresource layouts will return a different {@code offset} and {@code size} representing the region of memory used for that aspect. On implementations that store depth and stencil aspects interleaved, the same {@code offset} and {@code size} are returned and represent the interleaved memory allocation.</p>
 *
 * <p>If the image has a <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#formats-requiring-sampler-ycbcr-conversion">multi-planar format</a> and its tiling is {@link VK10#VK_IMAGE_TILING_LINEAR IMAGE_TILING_LINEAR} , then the {@code aspectMask} member of {@link VkImageSubresource} <b>must</b> be {@link VK11#VK_IMAGE_ASPECT_PLANE_0_BIT IMAGE_ASPECT_PLANE_0_BIT}, {@link VK11#VK_IMAGE_ASPECT_PLANE_1_BIT IMAGE_ASPECT_PLANE_1_BIT}, or (for 3-plane formats only) {@link VK11#VK_IMAGE_ASPECT_PLANE_2_BIT IMAGE_ASPECT_PLANE_2_BIT}. Querying each of these image subresource layouts will return a different {@code offset} and {@code size} representing the region of memory used for that plane. If the image is <em>disjoint</em>, then the {@code offset} is relative to the base address of the plane. If the image is <em>non-disjoint</em>, then the {@code offset} is relative to the base address of the image.</p>
 *
 * <p>If the image's tiling is {@link EXTImageDrmFormatModifier#VK_IMAGE_TILING_DRM_FORMAT_MODIFIER_EXT IMAGE_TILING_DRM_FORMAT_MODIFIER_EXT}, then the {@code aspectMask} member of {@link VkImageSubresource} <b>must</b> be one of {@code VK_IMAGE_ASPECT_MEMORY_PLANE_i_BIT_EXT}, where the maximum allowed plane index {@code i} is defined by the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#VkDrmFormatModifierPropertiesEXT">{@code drmFormatModifierPlaneCount}</a> associated with the image's <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#VkImageCreateInfo">{@code format}</a> and <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#glossary-drm-format-modifier">modifier</a>. The memory range used by the subresource is described by {@code offset} and {@code size}. If the image is <em>disjoint</em>, then the {@code offset} is relative to the base address of the <em>memory plane</em>. If the image is <em>non-disjoint</em>, then the {@code offset} is relative to the base address of the image. If the image is <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#glossary-linear-resource">non-linear</a>, then {@code rowPitch}, {@code arrayPitch}, and {@code depthPitch} have an implementation-dependent meaning.</p>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkImageDrmFormatModifierExplicitCreateInfoEXT}, {@link VK10#vkGetImageSubresourceLayout GetImageSubresourceLayout}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code offset} &ndash; the byte offset from the start of the image or the plane where the image subresource begins.</li>
 * <li>{@code size} &ndash; the size in bytes of the image subresource. {@code size} includes any extra memory that is required based on {@code rowPitch}.</li>
 * <li>{@code rowPitch} &ndash; describes the number of bytes between each row of texels in an image.</li>
 * <li>{@code arrayPitch} &ndash; describes the number of bytes between each array layer of an image.</li>
 * <li>{@code depthPitch} &ndash; describes the number of bytes between each slice of 3D image.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkSubresourceLayout {
 *     VkDeviceSize offset;
 *     VkDeviceSize size;
 *     VkDeviceSize rowPitch;
 *     VkDeviceSize arrayPitch;
 *     VkDeviceSize depthPitch;
 * }</code></pre>
 */
class SubresourceLayout(
        var offset: VkDeviceSize,
        var size: VkDeviceSize,
        var rowPitch: VkDeviceSize,
        var arrayPitch: VkDeviceSize,
        var depthPitch: VkDeviceSize
) {

    constructor(ptr: BytePtr) : this(
            VkDeviceSize(noffset(ptr.adr)),
            VkDeviceSize(nsize(ptr.adr)),
            VkDeviceSize(nrowPitch(ptr.adr)),
            VkDeviceSize(narrayPitch(ptr.adr)),
            VkDeviceSize(ndepthPitch(ptr.adr))
    )

    companion object {
//        inline infix fun <R> read(block: (Adr) -> R): SubresourceLayout = stak { read(it, block) }
        inline fun <R> read(stack: VkStack, block: (Adr) -> R): SubresourceLayout {
            val adr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
            block(adr)
            return SubresourceLayout(BytePtr(adr))
        }
    }
}