package vkk._10.structs

import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkDescriptorImageInfo.*
import vkk.VkImageLayout
import vkk.VkStack
import vkk.entities.VkImageView
import vkk.entities.VkSampler

/**
 * Structure specifying descriptor image info.
 *
 * <h5>Description</h5>
 *
 * <p>Members of {@link VkDescriptorImageInfo} that are not used in an update (as described above) are ignored.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code imageView} <b>must</b> not be 2D or 2D array image view created from a 3D image</li>
 * <li>If {@code imageView} is created from a depth/stencil image, the {@code aspectMask} used to create the {@code imageView} <b>must</b> include either {@link VK10#VK_IMAGE_ASPECT_DEPTH_BIT IMAGE_ASPECT_DEPTH_BIT} or {@link VK10#VK_IMAGE_ASPECT_STENCIL_BIT IMAGE_ASPECT_STENCIL_BIT} but not both.</li>
 * <li>{@code imageLayout} <b>must</b> match the actual {@code VkImageLayout} of each subresource accessible from {@code imageView} at the time this descriptor is accessed as defined by the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#resources-image-layouts-matching-rule">image layout matching rules</a></li>
 * <li>If {@code sampler} is used and the {@code VkFormat} of the image is a <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#formats-requiring-sampler-ycbcr-conversion">multi-planar format</a>, the image <b>must</b> have been created with {@link VK10#VK_IMAGE_CREATE_MUTABLE_FORMAT_BIT IMAGE_CREATE_MUTABLE_FORMAT_BIT}, and the {@code aspectMask} of the {@code imageView} <b>must</b> be {@link VK11#VK_IMAGE_ASPECT_PLANE_0_BIT IMAGE_ASPECT_PLANE_0_BIT}, {@link VK11#VK_IMAGE_ASPECT_PLANE_1_BIT IMAGE_ASPECT_PLANE_1_BIT} or (for three-plane formats only) {@link VK11#VK_IMAGE_ASPECT_PLANE_2_BIT IMAGE_ASPECT_PLANE_2_BIT}</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>Both of {@code imageView}, and {@code sampler} that are valid handles <b>must</b> have been created, allocated, or retrieved from the same {@code VkDevice}</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkWriteDescriptorSet}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sampler} &ndash; a sampler handle, and is used in descriptor updates for types {@link VK10#VK_DESCRIPTOR_TYPE_SAMPLER DESCRIPTOR_TYPE_SAMPLER} and {@link VK10#VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER} if the binding being updated does not use immutable samplers.</li>
 * <li>{@code imageView} &ndash; an image view handle, and is used in descriptor updates for types {@link VK10#VK_DESCRIPTOR_TYPE_SAMPLED_IMAGE DESCRIPTOR_TYPE_SAMPLED_IMAGE}, {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_IMAGE DESCRIPTOR_TYPE_STORAGE_IMAGE}, {@link VK10#VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER}, and {@link VK10#VK_DESCRIPTOR_TYPE_INPUT_ATTACHMENT DESCRIPTOR_TYPE_INPUT_ATTACHMENT}.</li>
 * <li>{@code imageLayout} &ndash; the layout that the image subresources accessible from {@code imageView} will be in at the time this descriptor is accessed. {@code imageLayout} is used in descriptor updates for types {@link VK10#VK_DESCRIPTOR_TYPE_SAMPLED_IMAGE DESCRIPTOR_TYPE_SAMPLED_IMAGE}, {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_IMAGE DESCRIPTOR_TYPE_STORAGE_IMAGE}, {@link VK10#VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER}, and {@link VK10#VK_DESCRIPTOR_TYPE_INPUT_ATTACHMENT DESCRIPTOR_TYPE_INPUT_ATTACHMENT}.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkDescriptorImageInfo {
 *     VkSampler sampler;
 *     VkImageView imageView;
 *     VkImageLayout imageLayout;
 * }</code></pre>
 */
class DescriptorImageInfo(
        var sampler: VkSampler,
        var imageView: VkImageView,
        var imageLayout: VkImageLayout
) {

    infix fun write(stack: VkStack): Adr =
        stack.ncalloc(ALIGNOF, 1, SIZEOF).also { write(it) }

    infix fun write(adr: Adr) {
        nsampler(adr, sampler.L)
        nimageView(adr, imageView.L)
        nimageLayout(adr, imageLayout.i)
    }
}

infix fun Array<DescriptorImageInfo>.write(stack: VkStack): Ptr {
    val natives = stack.ncalloc(ALIGNOF, size, SIZEOF)
    for (i in indices)
        this[i] write (natives + i * SIZEOF)
    return natives
}