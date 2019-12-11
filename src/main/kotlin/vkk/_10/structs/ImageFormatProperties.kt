package vkk._10.structs

import kool.Adr
import kool.BytePtr
import kool.IntPtr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkImageFormatProperties.*
import vkk.VkSampleCountFlags
import vkk.entities.VkDeviceSize
import vkk.stak

/**
 * Structure specifying an image format properties.
 *
 * <h5>Description</h5>
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>There is no mechanism to query the size of an image before creating it, to compare that size against {@code maxResourceSize}. If an application attempts to create an image that exceeds this limit, the creation will fail and {@link VK10#vkCreateImage CreateImage} will return {@link VK10#VK_ERROR_OUT_OF_DEVICE_MEMORY ERROR_OUT_OF_DEVICE_MEMORY}. While the advertised limit <b>must</b> be at least 2<sup>31</sup>, it <b>may</b> not be possible to create an image that approaches that size, particularly for {@link VK10#VK_IMAGE_TYPE_1D IMAGE_TYPE_1D}.</p>
 * </div>
 *
 * <p>If the combination of parameters to {@code vkGetPhysicalDeviceImageFormatProperties} is not supported by the implementation for use in {@link VK10#vkCreateImage CreateImage}, then all members of {@link VkImageFormatProperties} will be filled with zero.</p>
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>Filling {@link VkImageFormatProperties} with zero for unsupported formats is an exception to the usual rule that output structures have undefined contents on error. This exception was unintentional, but is preserved for backwards compatibility.</p>
 * </div>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkExtent3D}, {@link VkExternalImageFormatPropertiesNV}, {@link VkImageFormatProperties2}, {@link VK10#vkGetPhysicalDeviceImageFormatProperties GetPhysicalDeviceImageFormatProperties}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code maxExtent} &ndash; are the maximum image dimensions. See the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-extentperimagetype">Allowed Extent Values</a> section below for how these values are constrained by {@code type}.</li>
 * <li>{@code maxMipLevels} &ndash; the maximum number of mipmap levels. {@code maxMipLevels} <b>must</b> be equal to the number of levels in the complete mipmap chain based on the <code>maxExtent.width</code>, <code>maxExtent.height</code>, and <code>maxExtent.depth</code>, except when one of the following conditions is true, in which case it <b>may</b> instead be 1:
 *
 * <ul>
 * <li>{@code vkGetPhysicalDeviceImageFormatProperties}{@code ::tiling} was {@link VK10#VK_IMAGE_TILING_LINEAR IMAGE_TILING_LINEAR}</li>
 * <li>{@link VkPhysicalDeviceImageFormatInfo2}{@code ::tiling} was {@link EXTImageDrmFormatModifier#VK_IMAGE_TILING_DRM_FORMAT_MODIFIER_EXT IMAGE_TILING_DRM_FORMAT_MODIFIER_EXT}</li>
 * <li>the {@link VkPhysicalDeviceImageFormatInfo2}{@code ::pNext} chain included an instance of {@link VkPhysicalDeviceExternalImageFormatInfo} with a handle type included in the {@code handleTypes} member for which mipmap image support is not required</li>
 * <li>image {@code format} is one of those listed in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#formats-requiring-sampler-ycbcr-conversion">Formats requiring sampler Y'C<sub>B</sub>C<sub>R</sub> conversion for {@link VK10#VK_IMAGE_ASPECT_COLOR_BIT IMAGE_ASPECT_COLOR_BIT} image views</a></li>
 * <li>{@code flags} contains {@link EXTFragmentDensityMap#VK_IMAGE_CREATE_SUBSAMPLED_BIT_EXT IMAGE_CREATE_SUBSAMPLED_BIT_EXT}</li>
 * </ul></li>
 * <li>{@code maxArrayLayers} &ndash; the maximum number of array layers. {@code maxArrayLayers} <b>must</b> be no less than {@link VkPhysicalDeviceLimits}{@code ::maxImageArrayLayers}, except when one of the following conditions is true, in which case it <b>may</b> instead be 1:
 *
 * <ul>
 * <li>{@code tiling} is {@link VK10#VK_IMAGE_TILING_LINEAR IMAGE_TILING_LINEAR}</li>
 * <li>{@code tiling} is {@link VK10#VK_IMAGE_TILING_OPTIMAL IMAGE_TILING_OPTIMAL} and {@code type} is {@link VK10#VK_IMAGE_TYPE_3D IMAGE_TYPE_3D}</li>
 * <li>{@code format} is one of those listed in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#formats-requiring-sampler-ycbcr-conversion">Formats requiring sampler Y'C<sub>B</sub>C<sub>R</sub> conversion for {@link VK10#VK_IMAGE_ASPECT_COLOR_BIT IMAGE_ASPECT_COLOR_BIT} image views</a></li>
 * <li>If {@code tiling} is {@link EXTImageDrmFormatModifier#VK_IMAGE_TILING_DRM_FORMAT_MODIFIER_EXT IMAGE_TILING_DRM_FORMAT_MODIFIER_EXT}, then {@code maxArrayLayers} <b>must</b> not be 0.</li>
 * </ul></li>
 * <li>{@code sampleCounts} &ndash; a bitmask of {@code VkSampleCountFlagBits} specifying all the supported sample counts for this image as described <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-supported-sample-counts">below</a>.</li>
 * <li>{@code maxResourceSize} &ndash; an upper bound on the total image size in bytes, inclusive of all image subresources. Implementations <b>may</b> have an address space limit on total size of a resource, which is advertised by this property. {@code maxResourceSize} <b>must</b> be at least 2<sup>31</sup>.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkImageFormatProperties {
 *     {@link VkExtent3D VkExtent3D} maxExtent;
 *     uint32_t maxMipLevels;
 *     uint32_t maxArrayLayers;
 *     VkSampleCountFlags sampleCounts;
 *     VkDeviceSize maxResourceSize;
 * }</code></pre>
 */
class ImageFormatProperties(
        val maxExtent: Extent3D,
        var maxMipLevels: Int,
        var maxArrayLayers: Int,
        var sampleCounts: VkSampleCountFlags,
        var maxResourceSize: VkDeviceSize
) {
    constructor(ptr: BytePtr) : this(
            Extent3D(IntPtr(ptr + MAXEXTENT)),
            nmaxMipLevels(ptr.adr),
            nmaxArrayLayers(ptr.adr),
            nsampleCounts(ptr.adr),
            VkDeviceSize(nmaxResourceSize(ptr.adr))
    )

    companion object {
        inline fun <R> read(block: (Adr) -> R): ImageFormatProperties = stak { read(it, block) }
        inline fun <R> read(stack: MemoryStack, block: (Adr) -> R): ImageFormatProperties {
            val adr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
            block(adr)
            return ImageFormatProperties(BytePtr(adr))
        }
    }
}