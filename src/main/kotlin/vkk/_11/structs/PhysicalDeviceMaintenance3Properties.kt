package vkk._11.structs

import kool.Ptr
import org.lwjgl.system.MemoryUtil.NULL
import vkk.VkStructureType
import vkk.entities.VkDeviceSize

/**
 * Structure describing descriptor set properties.
 *
 * <h5>Description</h5>
 *
 * <p>If the {@link VkPhysicalDeviceMaintenance3Properties} structure is included in the {@code pNext} chain of {@link VkPhysicalDeviceProperties2}, it is filled with the implementation-dependent limits.</p>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_MAINTENANCE_3_PROPERTIES STRUCTURE_TYPE_PHYSICAL_DEVICE_MAINTENANCE_3_PROPERTIES}</li>
 * </ul>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code maxPerSetDescriptors} &ndash; a maximum number of descriptors (summed over all descriptor types) in a single descriptor set that is guaranteed to satisfy any implementation-dependent constraints on the size of a descriptor set itself. Applications <b>can</b> query whether a descriptor set that goes beyond this limit is supported using {@link VK11#vkGetDescriptorSetLayoutSupport GetDescriptorSetLayoutSupport}.</li>
 * <li>{@code maxMemoryAllocationSize} &ndash; the maximum size of a memory allocation that <b>can</b> be created, even if there is more space available in the heap.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPhysicalDeviceMaintenance3Properties {
 *     VkStructureType sType;
 *     void * pNext;
 *     uint32_t maxPerSetDescriptors;
 *     VkDeviceSize maxMemoryAllocationSize;
 * }</code></pre>
 */
class PhysicalDeviceMaintenance3Properties(
    var maxPerSetDescriptors: Int,
    var maxMemoryAllocationSize: VkDeviceSize,
    var next: Ptr = NULL
) {

    val type get() = VkStructureType.PHYSICAL_DEVICE_MAINTENANCE_3_PROPERTIES
}