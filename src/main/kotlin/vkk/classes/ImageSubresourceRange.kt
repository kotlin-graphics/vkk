package classes

import kool.Ptr
import org.lwjgl.vulkan.VkImageSubresourceRange
import org.lwjgl.vulkan.VkImageSubresourceRange.*
import vkk.VkImageAspectFlags

/**
 * Structure specifying an image subresource range.
 *
 * <h5>Description</h5>
 *
 * <p>The number of mipmap levels and array layers <b>must</b> be a subset of the image subresources in the image. If an application wants to use all mip levels or layers in an image after the {@code baseMipLevel} or {@code baseArrayLayer}, it <b>can</b> set {@code levelCount} and {@code layerCount} to the special values {@link VK10#VK_REMAINING_MIP_LEVELS REMAINING_MIP_LEVELS} and {@link VK10#VK_REMAINING_ARRAY_LAYERS REMAINING_ARRAY_LAYERS} without knowing the exact number of mip levels or layers.</p>
 *
 * <p>For cube and cube array image views, the layers of the image view starting at {@code baseArrayLayer} correspond to faces in the order +X, -X, +Y, -Y, +Z, -Z. For cube arrays, each set of six sequential layers is a single cube, so the number of cube maps in a cube map array view is <em>{@code layerCount} / 6</em>, and image array layer <code>(baseArrayLayer + i)</code> is face index <code>(i mod 6)</code> of cube <em>i / 6</em>. If the number of layers in the view, whether set explicitly in {@code layerCount} or implied by {@link VK10#VK_REMAINING_ARRAY_LAYERS REMAINING_ARRAY_LAYERS}, is not a multiple of 6, the last cube map in the array <b>must</b> not be accessed.</p>
 *
 * <p>{@code aspectMask} <b>must</b> be only {@link VK10#VK_IMAGE_ASPECT_COLOR_BIT IMAGE_ASPECT_COLOR_BIT}, {@link VK10#VK_IMAGE_ASPECT_DEPTH_BIT IMAGE_ASPECT_DEPTH_BIT} or {@link VK10#VK_IMAGE_ASPECT_STENCIL_BIT IMAGE_ASPECT_STENCIL_BIT} if {@code format} is a color, depth-only or stencil-only format, respectively, except if {@code format} is a <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#formats-requiring-sampler-ycbcr-conversion">multi-planar format</a>. If using a depth/stencil format with both depth and stencil components, {@code aspectMask} <b>must</b> include at least one of {@link VK10#VK_IMAGE_ASPECT_DEPTH_BIT IMAGE_ASPECT_DEPTH_BIT} and {@link VK10#VK_IMAGE_ASPECT_STENCIL_BIT IMAGE_ASPECT_STENCIL_BIT}, and <b>can</b> include both.</p>
 *
 * <p>When the {@link VkImageSubresourceRange} structure is used to select a subset of the slices of a 3D image's mip level in order to create a 2D or 2D array image view of a 3D image created with {@link KHRMaintenance1#VK_IMAGE_CREATE_2D_ARRAY_COMPATIBLE_BIT_KHR IMAGE_CREATE_2D_ARRAY_COMPATIBLE_BIT_KHR}, {@code baseArrayLayer} and {@code layerCount} specify the first slice index and the number of slices to include in the created image view. Such an image view <b>can</b> be used as a framebuffer attachment that refers only to the specified range of slices of the selected mip level. However, any layout transitions performed on such an attachment view during a render pass instance still apply to the entire subresource referenced which includes all the slices of the selected mip level.</p>
 *
 * <p>When using an image view of a depth/stencil image to populate a descriptor set (e.g. for sampling in the shader, or for use as an input attachment), the {@code aspectMask} <b>must</b> only include one bit and selects whether the image view is used for depth reads (i.e. using a floating-point sampler or input attachment in the shader) or stencil reads (i.e. using an unsigned integer sampler or input attachment in the shader). When an image view of a depth/stencil image is used as a depth/stencil framebuffer attachment, the {@code aspectMask} is ignored and both depth and stencil image subresources are used.</p>
 *
 * <p>The {@code components} member is of type {@link VkComponentMapping}, and describes a remapping from components of the image to components of the vector returned by shader image instructions. This remapping <b>must</b> be identity for storage image descriptors, input attachment descriptors, framebuffer attachments, and any {@code VkImageView} used with a combined image sampler that enables <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#samplers-YCbCr-conversion">sampler Y'C<sub>B</sub>C<sub>R</sub> conversion</a>.</p>
 *
 * <p>When creating a {@code VkImageView}, if <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#samplers-YCbCr-conversion">sampler Y'C<sub>B</sub>C<sub>R</sub> conversion</a> is enabled in the sampler, the {@code aspectMask} of a {@code subresourceRange} used by the {@code VkImageView} <b>must</b> be {@link VK10#VK_IMAGE_ASPECT_COLOR_BIT IMAGE_ASPECT_COLOR_BIT}.</p>
 *
 * <p>When creating a {@code VkImageView}, if sampler Y'C<sub>B</sub>C<sub>R</sub> conversion is not enabled in the sampler and the image {@code format} is <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#formats-requiring-sampler-ycbcr-conversion">multi-planar</a>, the image <b>must</b> have been created with {@link VK10#VK_IMAGE_CREATE_MUTABLE_FORMAT_BIT IMAGE_CREATE_MUTABLE_FORMAT_BIT}, and the {@code aspectMask} of the {@code VkImageView}'s {@code subresourceRange} <b>must</b> be {@link VK11#VK_IMAGE_ASPECT_PLANE_0_BIT IMAGE_ASPECT_PLANE_0_BIT}, {@link VK11#VK_IMAGE_ASPECT_PLANE_1_BIT IMAGE_ASPECT_PLANE_1_BIT} or {@link VK11#VK_IMAGE_ASPECT_PLANE_2_BIT IMAGE_ASPECT_PLANE_2_BIT}.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>If {@code levelCount} is not {@link VK10#VK_REMAINING_MIP_LEVELS REMAINING_MIP_LEVELS}, it <b>must</b> be greater than 0</li>
 * <li>If {@code layerCount} is not {@link VK10#VK_REMAINING_ARRAY_LAYERS REMAINING_ARRAY_LAYERS}, it <b>must</b> be greater than 0</li>
 * <li>If {@code aspectMask} includes {@link VK10#VK_IMAGE_ASPECT_COLOR_BIT IMAGE_ASPECT_COLOR_BIT}, then it <b>must</b> not include any of {@link VK11#VK_IMAGE_ASPECT_PLANE_0_BIT IMAGE_ASPECT_PLANE_0_BIT}, {@link VK11#VK_IMAGE_ASPECT_PLANE_1_BIT IMAGE_ASPECT_PLANE_1_BIT}, or {@link VK11#VK_IMAGE_ASPECT_PLANE_2_BIT IMAGE_ASPECT_PLANE_2_BIT}</li>
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
 * <p>{@link VkImageMemoryBarrier}, {@link VkImageViewCreateInfo}, {@link VK10#vkCmdClearColorImage CmdClearColorImage}, {@link VK10#vkCmdClearDepthStencilImage CmdClearDepthStencilImage}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code aspectMask} &ndash; a bitmask of {@code VkImageAspectFlagBits} specifying which aspect(s) of the image are included in the view.</li>
 * <li>{@code baseMipLevel} &ndash; the first mipmap level accessible to the view.</li>
 * <li>{@code levelCount} &ndash; the number of mipmap levels (starting from {@code baseMipLevel}) accessible to the view.</li>
 * <li>{@code baseArrayLayer} &ndash; the first array layer accessible to the view.</li>
 * <li>{@code layerCount} &ndash; the number of array layers (starting from {@code baseArrayLayer}) accessible to the view.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkImageSubresourceRange {
 *     VkImageAspectFlags aspectMask;
 *     uint32_t baseMipLevel;
 *     uint32_t levelCount;
 *     uint32_t baseArrayLayer;
 *     uint32_t layerCount;
 * }</code></pre>
 */
class ImageSubresourceRange(
    var aspectMask: VkImageAspectFlags = 0,
    var baseMipLevel: Int = 0,
    var levelCount: Int = 0,
    var baseArrayLayer: Int = 0,
    var layerCount: Int = 0
) {

    infix fun toPtr(ptr: Ptr) {
        naspectMask(ptr, aspectMask)
        nbaseMipLevel(ptr, baseMipLevel)
        nlevelCount(ptr, levelCount)
        nbaseArrayLayer(ptr, baseArrayLayer)
        nlayerCount(ptr, layerCount)
    }
}