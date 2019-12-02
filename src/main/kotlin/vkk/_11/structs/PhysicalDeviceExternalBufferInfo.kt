package vkk._11.structs

import vkk.VkBufferCreateFlags
import vkk.VkBufferUsageFlags
import vkk.VkExternalMemoryHandleType
import vkk.VkStructureType

/**
 * Structure specifying buffer creation parameters.
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_EXTERNAL_BUFFER_INFO STRUCTURE_TYPE_PHYSICAL_DEVICE_EXTERNAL_BUFFER_INFO}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL}</li>
 * <li>{@code flags} <b>must</b> be a valid combination of {@code VkBufferCreateFlagBits} values</li>
 * <li>{@code usage} <b>must</b> be a valid combination of {@code VkBufferUsageFlagBits} values</li>
 * <li>{@code usage} <b>must</b> not be 0</li>
 * <li>{@code handleType} <b>must</b> be a valid {@code VkExternalMemoryHandleTypeFlagBits} value</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VK11#vkGetPhysicalDeviceExternalBufferProperties GetPhysicalDeviceExternalBufferProperties}, {@link KHRExternalMemoryCapabilities#vkGetPhysicalDeviceExternalBufferPropertiesKHR GetPhysicalDeviceExternalBufferPropertiesKHR}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure</li>
 * <li>{@code pNext} &ndash; NULL or a pointer to an extension-specific structure.</li>
 * <li>{@code flags} &ndash; a bitmask of {@code VkBufferCreateFlagBits} describing additional parameters of the buffer, corresponding to {@link VkBufferCreateInfo}{@code ::flags}.</li>
 * <li>{@code usage} &ndash; a bitmask of {@code VkBufferUsageFlagBits} describing the intended usage of the buffer, corresponding to {@link VkBufferCreateInfo}{@code ::usage}.</li>
 * <li>{@code handleType} &ndash; a {@code VkExternalMemoryHandleTypeFlagBits} value specifying the memory handle type that will be used with the memory associated with the buffer.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPhysicalDeviceExternalBufferInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkBufferCreateFlags flags;
 *     VkBufferUsageFlags usage;
 *     VkExternalMemoryHandleTypeFlagBits handleType;
 * }</code></pre>
 */
class PhysicalDeviceExternalBufferInfo(
    var flags: VkBufferCreateFlags,
    var usage: VkBufferUsageFlags,
    var handleType: VkExternalMemoryHandleType
) {

    val type get() = VkStructureType.PHYSICAL_DEVICE_EXTERNAL_BUFFER_INFO
}