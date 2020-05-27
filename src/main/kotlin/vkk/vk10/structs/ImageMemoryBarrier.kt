package vkk.vk10.structs

import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.vulkan.VK10.VK_QUEUE_FAMILY_IGNORED
import org.lwjgl.vulkan.VkImageMemoryBarrier.*
import vkk.VkAccessFlags
import vkk.VkImageLayout
import vkk.VkStack
import vkk.VkStructureType
import vkk.entities.VkImage

/**
 * Structure specifying the parameters of an image memory barrier.
 *
 * <h5>Description</h5>
 *
 * <p>The first <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-dependencies-access-scopes">access scope</a> is limited to access to memory through the specified image subresource range, via access types in the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-access-masks">source access mask</a> specified by {@code srcAccessMask}. If {@code srcAccessMask} includes {@link VK10#VK_ACCESS_HOST_WRITE_BIT ACCESS_HOST_WRITE_BIT}, memory writes performed by that access type are also made visible, as that access type is not performed through a resource.</p>
 *
 * <p>The second <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-dependencies-access-scopes">access scope</a> is limited to access to memory through the specified image subresource range, via access types in the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-access-masks">destination access mask</a> specified by {@code dstAccessMask}. If {@code dstAccessMask} includes {@link VK10#VK_ACCESS_HOST_WRITE_BIT ACCESS_HOST_WRITE_BIT} or {@link VK10#VK_ACCESS_HOST_READ_BIT ACCESS_HOST_READ_BIT}, available memory writes are also made visible to accesses of those types, as those access types are not performed through a resource.</p>
 *
 * <p>If {@code srcQueueFamilyIndex} is not equal to {@code dstQueueFamilyIndex}, and {@code srcQueueFamilyIndex} is equal to the current queue family, then the memory barrier defines a <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-queue-transfers-release">queue family release operation</a> for the specified image subresource range, and the second access scope includes no access, as if {@code dstAccessMask} was 0.</p>
 *
 * <p>If {@code dstQueueFamilyIndex} is not equal to {@code srcQueueFamilyIndex}, and {@code dstQueueFamilyIndex} is equal to the current queue family, then the memory barrier defines a <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-queue-transfers-acquire">queue family acquire operation</a> for the specified image subresource range, and the first access scope includes no access, as if {@code srcAccessMask} was 0.</p>
 *
 * <p>If {@code oldLayout} is not equal to {@code newLayout}, then the memory barrier defines an <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-image-layout-transitions">image layout transition</a> for the specified image subresource range.</p>
 *
 * <p>Layout transitions that are performed via image memory barriers execute in their entirety in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-submission-order">submission order</a>, relative to other image layout transitions submitted to the same queue, including those performed by <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#renderpass">render passes</a>. In effect there is an implicit execution dependency from each such layout transition to all layout transitions previously submitted to the same queue.</p>
 *
 * <p>The image layout of each image subresource of a depth/stencil image created with {@link EXTSampleLocations#VK_IMAGE_CREATE_SAMPLE_LOCATIONS_COMPATIBLE_DEPTH_BIT_EXT IMAGE_CREATE_SAMPLE_LOCATIONS_COMPATIBLE_DEPTH_BIT_EXT} is dependent on the last sample locations used to render to the image subresource as a depth/stencil attachment, thus when the {@code image} member of an {@link VkImageMemoryBarrier} is an image created with this flag the application <b>can</b> chain a {@link VkSampleLocationsInfoEXT} structure to the {@code pNext} chain of {@link VkImageMemoryBarrier} to specify the sample locations to use during the image layout transition.</p>
 *
 * <p>If the {@link VkSampleLocationsInfoEXT} structure in the {@code pNext} chain of {@link VkImageMemoryBarrier} does not match the sample location state last used to render to the image subresource range specified by {@code subresourceRange} or if no {@link VkSampleLocationsInfoEXT} structure is in the {@code pNext} chain of {@link VkImageMemoryBarrier} then the contents of the given image subresource range becomes undefined as if {@code oldLayout} would equal {@link VK10#VK_IMAGE_LAYOUT_UNDEFINED IMAGE_LAYOUT_UNDEFINED}.</p>
 *
 * <p>If {@code image} has a multi-planar format and the image is <em>disjoint</em>, then including {@link VK10#VK_IMAGE_ASPECT_COLOR_BIT IMAGE_ASPECT_COLOR_BIT} in the {@code aspectMask} member of {@code subresourceRange} is equivalent to including {@link VK11#VK_IMAGE_ASPECT_PLANE_0_BIT IMAGE_ASPECT_PLANE_0_BIT}, {@link VK11#VK_IMAGE_ASPECT_PLANE_1_BIT IMAGE_ASPECT_PLANE_1_BIT}, and (for three-plane formats only) {@link VK11#VK_IMAGE_ASPECT_PLANE_2_BIT IMAGE_ASPECT_PLANE_2_BIT}.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code oldLayout} <b>must</b> be {@link VK10#VK_IMAGE_LAYOUT_UNDEFINED IMAGE_LAYOUT_UNDEFINED} or the current layout of the image subresources affected by the barrier</li>
 * <li>{@code newLayout} <b>must</b> not be {@link VK10#VK_IMAGE_LAYOUT_UNDEFINED IMAGE_LAYOUT_UNDEFINED} or {@link VK10#VK_IMAGE_LAYOUT_PREINITIALIZED IMAGE_LAYOUT_PREINITIALIZED}</li>
 * <li>If {@code image} was created with a sharing mode of {@link VK10#VK_SHARING_MODE_CONCURRENT SHARING_MODE_CONCURRENT}, at least one of {@code srcQueueFamilyIndex} and {@code dstQueueFamilyIndex} <b>must</b> be {@link VK10#VK_QUEUE_FAMILY_IGNORED QUEUE_FAMILY_IGNORED}</li>
 * <li>If {@code image} was created with a sharing mode of {@link VK10#VK_SHARING_MODE_CONCURRENT SHARING_MODE_CONCURRENT}, and one of {@code srcQueueFamilyIndex} and {@code dstQueueFamilyIndex} is {@link VK10#VK_QUEUE_FAMILY_IGNORED QUEUE_FAMILY_IGNORED}, the other <b>must</b> be {@link VK10#VK_QUEUE_FAMILY_IGNORED QUEUE_FAMILY_IGNORED} or a special queue family reserved for external memory transfers, as described in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-queue-transfers">Queue Family Ownership Transfer</a>.</li>
 * <li>If {@code image} was created with a sharing mode of {@link VK10#VK_SHARING_MODE_EXCLUSIVE SHARING_MODE_EXCLUSIVE} and {@code srcQueueFamilyIndex} is {@link VK10#VK_QUEUE_FAMILY_IGNORED QUEUE_FAMILY_IGNORED}, {@code dstQueueFamilyIndex} <b>must</b> also be {@link VK10#VK_QUEUE_FAMILY_IGNORED QUEUE_FAMILY_IGNORED}.</li>
 * <li>If {@code image} was created with a sharing mode of {@link VK10#VK_SHARING_MODE_EXCLUSIVE SHARING_MODE_EXCLUSIVE} and {@code srcQueueFamilyIndex} is not {@link VK10#VK_QUEUE_FAMILY_IGNORED QUEUE_FAMILY_IGNORED}, it <b>must</b> be a valid queue family or a special queue family reserved for external memory transfers, as described in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-queue-transfers">Queue Family Ownership Transfer</a>.</li>
 * <li>If {@code image} was created with a sharing mode of {@link VK10#VK_SHARING_MODE_EXCLUSIVE SHARING_MODE_EXCLUSIVE} and {@code dstQueueFamilyIndex} is not {@link VK10#VK_QUEUE_FAMILY_IGNORED QUEUE_FAMILY_IGNORED}, it <b>must</b> be a valid queue family or a special queue family reserved for external memory transfers, as described in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-queue-transfers">Queue Family Ownership Transfer</a>.</li>
 * <li>If {@code image} was created with a sharing mode of {@link VK10#VK_SHARING_MODE_EXCLUSIVE SHARING_MODE_EXCLUSIVE}, and {@code srcQueueFamilyIndex} and {@code dstQueueFamilyIndex} are not {@link VK10#VK_QUEUE_FAMILY_IGNORED QUEUE_FAMILY_IGNORED}, at least one of them <b>must</b> be the same as the family of the queue that will execute this barrier</li>
 * <li>{@code subresourceRange.baseMipLevel} <b>must</b> be less than the {@code mipLevels} specified in {@link VkImageCreateInfo} when {@code image} was created</li>
 * <li>If {@code subresourceRange.levelCount} is not {@link VK10#VK_REMAINING_MIP_LEVELS REMAINING_MIP_LEVELS}, <code>subresourceRange.baseMipLevel + subresourceRange.levelCount</code> <b>must</b> be less than or equal to the {@code mipLevels} specified in {@link VkImageCreateInfo} when {@code image} was created</li>
 * <li>{@code subresourceRange.baseArrayLayer} <b>must</b> be less than the {@code arrayLayers} specified in {@link VkImageCreateInfo} when {@code image} was created</li>
 * <li>If {@code subresourceRange.layerCount} is not {@link VK10#VK_REMAINING_ARRAY_LAYERS REMAINING_ARRAY_LAYERS}, <code>subresourceRange.baseArrayLayer subresourceRange.layerCount</code> <b>must</b> be less than or equal to the {@code arrayLayers} specified in {@link VkImageCreateInfo} when {@code image} was created</li>
 * <li>If {@code image} has a depth/stencil format with both depth and stencil components, then the {@code aspectMask} member of {@code subresourceRange} <b>must</b> include both {@link VK10#VK_IMAGE_ASPECT_DEPTH_BIT IMAGE_ASPECT_DEPTH_BIT} and {@link VK10#VK_IMAGE_ASPECT_STENCIL_BIT IMAGE_ASPECT_STENCIL_BIT}</li>
 * <li>If {@code image} has a single-plane color format or is not <em>disjoint</em>, then the {@code aspectMask} member of {@code subresourceRange} <b>must</b> be {@link VK10#VK_IMAGE_ASPECT_COLOR_BIT IMAGE_ASPECT_COLOR_BIT}</li>
 * <li>If {@code image} has a multi-planar format and the image is <em>disjoint</em>, then the {@code aspectMask} member of {@code subresourceRange} <b>must</b> include either at least one of {@link VK11#VK_IMAGE_ASPECT_PLANE_0_BIT IMAGE_ASPECT_PLANE_0_BIT}, {@link VK11#VK_IMAGE_ASPECT_PLANE_1_BIT IMAGE_ASPECT_PLANE_1_BIT}, and {@link VK11#VK_IMAGE_ASPECT_PLANE_2_BIT IMAGE_ASPECT_PLANE_2_BIT}; or <b>must</b> include {@link VK10#VK_IMAGE_ASPECT_COLOR_BIT IMAGE_ASPECT_COLOR_BIT}</li>
 * <li>If {@code image} has a multi-planar format with only two planes, then the {@code aspectMask} member of {@code subresourceRange} <b>must</b> not include {@link VK11#VK_IMAGE_ASPECT_PLANE_2_BIT IMAGE_ASPECT_PLANE_2_BIT}</li>
 * <li>If either {@code oldLayout} or {@code newLayout} is {@link VK10#VK_IMAGE_LAYOUT_COLOR_ATTACHMENT_OPTIMAL IMAGE_LAYOUT_COLOR_ATTACHMENT_OPTIMAL} then {@code image} <b>must</b> have been created with {@link VK10#VK_IMAGE_USAGE_COLOR_ATTACHMENT_BIT IMAGE_USAGE_COLOR_ATTACHMENT_BIT} set</li>
 * <li>If either {@code oldLayout} or {@code newLayout} is {@link VK10#VK_IMAGE_LAYOUT_DEPTH_STENCIL_ATTACHMENT_OPTIMAL IMAGE_LAYOUT_DEPTH_STENCIL_ATTACHMENT_OPTIMAL} then {@code image} <b>must</b> have been created with {@link VK10#VK_IMAGE_USAGE_DEPTH_STENCIL_ATTACHMENT_BIT IMAGE_USAGE_DEPTH_STENCIL_ATTACHMENT_BIT} set</li>
 * <li>If either {@code oldLayout} or {@code newLayout} is {@link VK10#VK_IMAGE_LAYOUT_DEPTH_STENCIL_READ_ONLY_OPTIMAL IMAGE_LAYOUT_DEPTH_STENCIL_READ_ONLY_OPTIMAL} then {@code image} <b>must</b> have been created with {@link VK10#VK_IMAGE_USAGE_DEPTH_STENCIL_ATTACHMENT_BIT IMAGE_USAGE_DEPTH_STENCIL_ATTACHMENT_BIT} set</li>
 * <li>If either {@code oldLayout} or {@code newLayout} is {@link VK11#VK_IMAGE_LAYOUT_DEPTH_READ_ONLY_STENCIL_ATTACHMENT_OPTIMAL IMAGE_LAYOUT_DEPTH_READ_ONLY_STENCIL_ATTACHMENT_OPTIMAL} then {@code image} <b>must</b> have been created with {@link VK10#VK_IMAGE_USAGE_DEPTH_STENCIL_ATTACHMENT_BIT IMAGE_USAGE_DEPTH_STENCIL_ATTACHMENT_BIT} set</li>
 * <li>If either {@code oldLayout} or {@code newLayout} is {@link VK11#VK_IMAGE_LAYOUT_DEPTH_ATTACHMENT_STENCIL_READ_ONLY_OPTIMAL IMAGE_LAYOUT_DEPTH_ATTACHMENT_STENCIL_READ_ONLY_OPTIMAL} then {@code image} <b>must</b> have been created with {@link VK10#VK_IMAGE_USAGE_DEPTH_STENCIL_ATTACHMENT_BIT IMAGE_USAGE_DEPTH_STENCIL_ATTACHMENT_BIT} set</li>
 * <li>If either {@code oldLayout} or {@code newLayout} is {@link VK10#VK_IMAGE_LAYOUT_SHADER_READ_ONLY_OPTIMAL IMAGE_LAYOUT_SHADER_READ_ONLY_OPTIMAL} then {@code image} <b>must</b> have been created with {@link VK10#VK_IMAGE_USAGE_SAMPLED_BIT IMAGE_USAGE_SAMPLED_BIT} or {@link VK10#VK_IMAGE_USAGE_INPUT_ATTACHMENT_BIT IMAGE_USAGE_INPUT_ATTACHMENT_BIT} set</li>
 * <li>If either {@code oldLayout} or {@code newLayout} is {@link VK10#VK_IMAGE_LAYOUT_TRANSFER_SRC_OPTIMAL IMAGE_LAYOUT_TRANSFER_SRC_OPTIMAL} then {@code image} <b>must</b> have been created with {@link VK10#VK_IMAGE_USAGE_TRANSFER_SRC_BIT IMAGE_USAGE_TRANSFER_SRC_BIT} set</li>
 * <li>If either {@code oldLayout} or {@code newLayout} is {@link VK10#VK_IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL} then {@code image} <b>must</b> have been created with {@link VK10#VK_IMAGE_USAGE_TRANSFER_DST_BIT IMAGE_USAGE_TRANSFER_DST_BIT} set</li>
 * <li>If {@code image} is non-sparse then it <b>must</b> be bound completely and contiguously to a single {@code VkDeviceMemory} object</li>
 * <li>If either {@code oldLayout} or {@code newLayout} is {@link NVShadingRateImage#VK_IMAGE_LAYOUT_SHADING_RATE_OPTIMAL_NV IMAGE_LAYOUT_SHADING_RATE_OPTIMAL_NV} then {@code image} <b>must</b> have been created with {@link NVShadingRateImage#VK_IMAGE_USAGE_SHADING_RATE_IMAGE_BIT_NV IMAGE_USAGE_SHADING_RATE_IMAGE_BIT_NV} set</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK10#VK_STRUCTURE_TYPE_IMAGE_MEMORY_BARRIER STRUCTURE_TYPE_IMAGE_MEMORY_BARRIER}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL} or a pointer to a valid instance of {@link VkSampleLocationsInfoEXT}</li>
 * <li>{@code srcAccessMask} <b>must</b> be a valid combination of {@code VkAccessFlagBits} values</li>
 * <li>{@code dstAccessMask} <b>must</b> be a valid combination of {@code VkAccessFlagBits} values</li>
 * <li>{@code oldLayout} <b>must</b> be a valid {@code VkImageLayout} value</li>
 * <li>{@code newLayout} <b>must</b> be a valid {@code VkImageLayout} value</li>
 * <li>{@code image} <b>must</b> be a valid {@code VkImage} handle</li>
 * <li>{@code subresourceRange} <b>must</b> be a valid {@link VkImageSubresourceRange} structure</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkImageSubresourceRange}, {@link VK10#vkCmdPipelineBarrier CmdPipelineBarrier}, {@link VK10#vkCmdWaitEvents CmdWaitEvents}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code srcAccessMask} &ndash; a bitmask of {@code VkAccessFlagBits} specifying a <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-access-masks">source access mask</a>.</li>
 * <li>{@code dstAccessMask} &ndash; a bitmask of {@code VkAccessFlagBits} specifying a <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-access-masks">destination access mask</a>.</li>
 * <li>{@code oldLayout} &ndash; the old layout in an <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-image-layout-transitions">image layout transition</a>.</li>
 * <li>{@code newLayout} &ndash; the new layout in an <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-image-layout-transitions">image layout transition</a>.</li>
 * <li>{@code srcQueueFamilyIndex} &ndash; the source queue family for a <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-queue-transfers">queue family ownership transfer</a>.</li>
 * <li>{@code dstQueueFamilyIndex} &ndash; the destination queue family for a <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-queue-transfers">queue family ownership transfer</a>.</li>
 * <li>{@code image} &ndash; a handle to the image affected by this barrier.</li>
 * <li>{@code subresourceRange} &ndash; describes the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#resources-image-views">image subresource range</a> within {@code image} that is affected by this barrier.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkImageMemoryBarrier {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkAccessFlags srcAccessMask;
 *     VkAccessFlags dstAccessMask;
 *     VkImageLayout oldLayout;
 *     VkImageLayout newLayout;
 *     uint32_t srcQueueFamilyIndex;
 *     uint32_t dstQueueFamilyIndex;
 *     VkImage image;
 *     {@link VkImageSubresourceRange VkImageSubresourceRange} subresourceRange;
 * }</code></pre>
 */
class ImageMemoryBarrier(
        var srcAccessMask: VkAccessFlags = 0,
        var dstAccessMask: VkAccessFlags = 0,
        var oldLayout: VkImageLayout,
        var newLayout: VkImageLayout,
        var srcQueueFamilyIndex: Int = VK_QUEUE_FAMILY_IGNORED,
        var dstQueueFamilyIndex: Int = VK_QUEUE_FAMILY_IGNORED,
        var image: VkImage,
        var subresourceRange: ImageSubresourceRange,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.IMAGE_MEMORY_BARRIER

    infix fun write(stack: VkStack): Adr =
        stack.ncalloc(ALIGNOF, 1, SIZEOF).also { write(it) }

    infix fun write(adr: Adr) {
        nsType(adr, type.i)
        npNext(adr, next)
        nsrcAccessMask(adr, srcAccessMask)
        ndstAccessMask(adr, dstAccessMask)
        noldLayout(adr, oldLayout.i)
        nnewLayout(adr, newLayout.i)
        nsrcQueueFamilyIndex(adr, srcQueueFamilyIndex)
        ndstQueueFamilyIndex(adr, dstQueueFamilyIndex)
        nimage(adr, image.L)
        subresourceRange write (adr + SUBRESOURCERANGE)
    }
}

infix fun Array<ImageMemoryBarrier>.write(stack: VkStack): Ptr {
    val natives = stack.ncalloc(ALIGNOF, size, SIZEOF)
    for (i in indices)
        this[i] write (natives + i * SIZEOF)
    return natives
}