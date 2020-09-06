package vkk.vk11.structs

import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.vulkan.VkPhysicalDeviceImageFormatInfo2.*
import vkk.*

/**
 * Structure specifying image creation parameters.
 *
 * <h5>Description</h5>
 *
 * <p>The members of {@link VkPhysicalDeviceImageFormatInfo2} correspond to the arguments to {@link VK10#vkGetPhysicalDeviceImageFormatProperties GetPhysicalDeviceImageFormatProperties}, with {@code sType} and {@code pNext} added for extensibility.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code tiling} <b>must</b> be {@link EXTImageDrmFormatModifier#VK_IMAGE_TILING_DRM_FORMAT_MODIFIER_EXT IMAGE_TILING_DRM_FORMAT_MODIFIER_EXT} if and only if the {@code pNext} chain contains {@link VkPhysicalDeviceImageDrmFormatModifierInfoEXT}.</li>
 * <li>If {@code tiling} is {@link EXTImageDrmFormatModifier#VK_IMAGE_TILING_DRM_FORMAT_MODIFIER_EXT IMAGE_TILING_DRM_FORMAT_MODIFIER_EXT} and {@code flags} contains {@link VK10#VK_IMAGE_CREATE_MUTABLE_FORMAT_BIT IMAGE_CREATE_MUTABLE_FORMAT_BIT}, then the {@code pNext} chain <b>must</b> contain {@link VkImageFormatListCreateInfoKHR} with non-zero {@code viewFormatCount}.</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_IMAGE_FORMAT_INFO_2 STRUCTURE_TYPE_PHYSICAL_DEVICE_IMAGE_FORMAT_INFO_2}</li>
 * <li>Each {@code pNext} member of any structure (including this one) in the {@code pNext} chain <b>must</b> be either {@code NULL} or a pointer to a valid instance of {@link VkImageFormatListCreateInfoKHR}, {@link VkImageStencilUsageCreateInfoEXT}, {@link VkPhysicalDeviceExternalImageFormatInfo}, {@link VkPhysicalDeviceImageDrmFormatModifierInfoEXT}, or {@link VkPhysicalDeviceImageViewImageFormatInfoEXT}</li>
 * <li>Each {@code sType} member in the {@code pNext} chain <b>must</b> be unique</li>
 * <li>{@code format} <b>must</b> be a valid {@code VkFormat} value</li>
 * <li>{@code type} <b>must</b> be a valid {@code VkImageType} value</li>
 * <li>{@code tiling} <b>must</b> be a valid {@code VkImageTiling} value</li>
 * <li>{@code usage} <b>must</b> be a valid combination of {@code VkImageUsageFlagBits} values</li>
 * <li>{@code usage} <b>must</b> not be 0</li>
 * <li>{@code flags} <b>must</b> be a valid combination of {@code VkImageCreateFlagBits} values</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VK11#vkGetPhysicalDeviceImageFormatProperties2 GetPhysicalDeviceImageFormatProperties2}, {@link KHRGetPhysicalDeviceProperties2#vkGetPhysicalDeviceImageFormatProperties2KHR GetPhysicalDeviceImageFormatProperties2KHR}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure. The {@code pNext} chain of {@link VkPhysicalDeviceImageFormatInfo2} is used to provide additional image parameters to {@code vkGetPhysicalDeviceImageFormatProperties2}.</li>
 * <li>{@code format} &ndash; a {@code VkFormat} value indicating the image format, corresponding to {@link VkImageCreateInfo}{@code ::format}.</li>
 * <li>{@code type} &ndash; a {@code VkImageType} value indicating the image type, corresponding to {@link VkImageCreateInfo}{@code ::imageType}.</li>
 * <li>{@code tiling} &ndash; a {@code VkImageTiling} value indicating the image tiling, corresponding to {@link VkImageCreateInfo}{@code ::tiling}.</li>
 * <li>{@code usage} &ndash; a bitmask of {@code VkImageUsageFlagBits} indicating the intended usage of the image, corresponding to {@link VkImageCreateInfo}{@code ::usage}.</li>
 * <li>{@code flags} &ndash; a bitmask of {@code VkImageCreateFlagBits} indicating additional parameters of the image, corresponding to {@link VkImageCreateInfo}{@code ::flags}.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPhysicalDeviceImageFormatInfo2 {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkFormat format;
 *     VkImageType type;
 *     VkImageTiling tiling;
 *     VkImageUsageFlags usage;
 *     VkImageCreateFlags flags;
 * }</code></pre>
 */
class PhysicalDeviceImageFormatInfo2(
        var format: VkFormat,
        var type: VkImageType,
        var tiling: VkImageTiling,
        var usage: VkImageUsageFlags,
        var flags: VkImageCreateFlags,
        var next: Ptr = NULL
) {

    val type_ get() = VkStructureType.PHYSICAL_DEVICE_IMAGE_FORMAT_INFO_2

    infix fun write(stack: MemoryStack): Adr {
        val adr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
        nsType(adr, type_.i)
        npNext(adr, next)
        nformat(adr, format.i)
        ntype(adr, type.i)
        ntiling(adr, tiling.i)
        nusage(adr, usage)
        nflags(adr, flags)
        return adr
    }
}