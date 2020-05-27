package vkk.vk11.structs

import kool.Ptr
import org.lwjgl.system.MemoryUtil.NULL
import vkk.VkExternalMemoryHandleType
import vkk.VkStructureType

/**
 * Structure specifying external image creation parameters.
 *
 * <h5>Description</h5>
 *
 * <p>If {@code handleType} is 0, {@link VK11#vkGetPhysicalDeviceImageFormatProperties2 GetPhysicalDeviceImageFormatProperties2} will behave as if {@link VkPhysicalDeviceExternalImageFormatInfo} was not present, and {@link VkExternalImageFormatProperties} will be ignored.</p>
 *
 * <p>If {@code handleType} is not compatible with the {@code format}, {@code type}, {@code tiling}, {@code usage}, and {@code flags} specified in {@link VkPhysicalDeviceImageFormatInfo2}, then {@link VK11#vkGetPhysicalDeviceImageFormatProperties2 GetPhysicalDeviceImageFormatProperties2} returns {@link VK10#VK_ERROR_FORMAT_NOT_SUPPORTED ERROR_FORMAT_NOT_SUPPORTED}.</p>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_EXTERNAL_IMAGE_FORMAT_INFO STRUCTURE_TYPE_PHYSICAL_DEVICE_EXTERNAL_IMAGE_FORMAT_INFO}</li>
 * <li>If {@code handleType} is not 0, {@code handleType} <b>must</b> be a valid {@code VkExternalMemoryHandleTypeFlagBits} value</li>
 * </ul>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code handleType} &ndash; a {@code VkExternalMemoryHandleTypeFlagBits} value specifying the memory handle type that will be used with the memory associated with the image.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPhysicalDeviceExternalImageFormatInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkExternalMemoryHandleTypeFlagBits handleType;
 * }</code></pre>
 */
class PhysicalDeviceExternalImageFormatInfo(
    var handleType: VkExternalMemoryHandleType,
    var next: Ptr = NULL
) {

    val type get() = VkStructureType.PHYSICAL_DEVICE_EXTERNAL_IMAGE_FORMAT_INFO
}