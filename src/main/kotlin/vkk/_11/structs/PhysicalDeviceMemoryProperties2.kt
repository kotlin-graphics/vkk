package vkk._11.structs

import kool.Ptr
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.NULL
import vkk.VkStructureType
import vkk._10.structs.PhysicalDeviceMemoryProperties

/**
 * Structure specifying physical device memory properties.
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_MEMORY_PROPERTIES_2 STRUCTURE_TYPE_PHYSICAL_DEVICE_MEMORY_PROPERTIES_2}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL} or a pointer to a valid instance of {@link VkPhysicalDeviceMemoryBudgetPropertiesEXT}</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkPhysicalDeviceMemoryProperties}, {@link VK11#vkGetPhysicalDeviceMemoryProperties2 GetPhysicalDeviceMemoryProperties2}, {@link KHRGetPhysicalDeviceProperties2#vkGetPhysicalDeviceMemoryProperties2KHR GetPhysicalDeviceMemoryProperties2KHR}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code memoryProperties} &ndash; a structure of type {@link VkPhysicalDeviceMemoryProperties} which is populated with the same values as in {@link VK10#vkGetPhysicalDeviceMemoryProperties GetPhysicalDeviceMemoryProperties}.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPhysicalDeviceMemoryProperties2 {
 *     VkStructureType sType;
 *     void * pNext;
 *     {@link VkPhysicalDeviceMemoryProperties VkPhysicalDeviceMemoryProperties} memoryProperties;
 * }</code></pre>
 */
class PhysicalDeviceMemoryProperties2(
    var memoryProperties: PhysicalDeviceMemoryProperties,
    var next: Ptr = NULL
) {

    val type get() = VkStructureType.PHYSICAL_DEVICE_MEMORY_PROPERTIES_2
}