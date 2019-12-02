package vkk._11.structs

import vkk.*

/**
 * Structure specifying sparse image format inputs.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code samples} <b>must</b> be a bit value that is set in {@link VkImageFormatProperties}{@code ::sampleCounts} returned by {@code vkGetPhysicalDeviceImageFormatProperties} with {@code format}, {@code type}, {@code tiling}, and {@code usage} equal to those in this command and {@code flags} equal to the value that is set in {@link VkImageCreateInfo}{@code ::flags} when the image is created</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SPARSE_IMAGE_FORMAT_INFO_2 STRUCTURE_TYPE_PHYSICAL_DEVICE_SPARSE_IMAGE_FORMAT_INFO_2}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL}</li>
 * <li>{@code format} <b>must</b> be a valid {@code VkFormat} value</li>
 * <li>{@code type} <b>must</b> be a valid {@code VkImageType} value</li>
 * <li>{@code samples} <b>must</b> be a valid {@code VkSampleCountFlagBits} value</li>
 * <li>{@code usage} <b>must</b> be a valid combination of {@code VkImageUsageFlagBits} values</li>
 * <li>{@code usage} <b>must</b> not be 0</li>
 * <li>{@code tiling} <b>must</b> be a valid {@code VkImageTiling} value</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VK11#vkGetPhysicalDeviceSparseImageFormatProperties2 GetPhysicalDeviceSparseImageFormatProperties2}, {@link KHRGetPhysicalDeviceProperties2#vkGetPhysicalDeviceSparseImageFormatProperties2KHR GetPhysicalDeviceSparseImageFormatProperties2KHR}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code format} &ndash; the image format.</li>
 * <li>{@code type} &ndash; the dimensionality of image.</li>
 * <li>{@code samples} &ndash; the number of samples per texel as defined in {@code VkSampleCountFlagBits}.</li>
 * <li>{@code usage} &ndash; a bitmask describing the intended usage of the image.</li>
 * <li>{@code tiling} &ndash; the tiling arrangement of the texel blocks in memory.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPhysicalDeviceSparseImageFormatInfo2 {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkFormat format;
 *     VkImageType type;
 *     VkSampleCountFlagBits samples;
 *     VkImageUsageFlags usage;
 *     VkImageTiling tiling;
 * }</code></pre>
 */
class PhysicalDeviceSparseImageFormatInfo2(
    var format: VkFormat,
    var type: VkImageType,
    var samples: VkSampleCount,
    var usage: VkImageUsageFlags,
    var tiling: VkImageTiling
) {

    val type_ get() = VkStructureType.PHYSICAL_DEVICE_SPARSE_IMAGE_FORMAT_INFO_2
}