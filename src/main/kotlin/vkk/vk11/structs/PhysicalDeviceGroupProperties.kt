package vkk.vk11.structs

import glm_.bool
import vkk.identifiers.VkInstance
import vkk.identifiers.PhysicalDevice
import kool.Adr
import kool.BYTES
import org.lwjgl.vulkan.VkPhysicalDeviceGroupProperties.*
import vkk.VkStructureType

/**
 * Structure specifying physical device group properties.
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_GROUP_PROPERTIES STRUCTURE_TYPE_PHYSICAL_DEVICE_GROUP_PROPERTIES}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL}</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VK11#vkEnumeratePhysicalDeviceGroups EnumeratePhysicalDeviceGroups}, {@link KHRDeviceGroupCreation#vkEnumeratePhysicalDeviceGroupsKHR EnumeratePhysicalDeviceGroupsKHR}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code physicalDeviceCount} &ndash; the number of physical devices in the group.</li>
 * <li>{@code physicalDevices[VK_MAX_DEVICE_GROUP_SIZE]} &ndash; an array of physical device handles representing all physical devices in the group. The first {@code physicalDeviceCount} elements of the array will be valid.</li>
 * <li>{@code subsetAllocation} &ndash; specifies whether logical devices created from the group support allocating device memory on a subset of devices, via the {@code deviceMask} member of the {@link VkMemoryAllocateFlagsInfo}. If this is {@link VK10#VK_FALSE FALSE}, then all device memory allocations are made across all physical devices in the group. If {@code physicalDeviceCount} is 1, then {@code subsetAllocation} <b>must</b> be {@link VK10#VK_FALSE FALSE}.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPhysicalDeviceGroupProperties {
 *     VkStructureType sType;
 *     void * pNext;
 *     uint32_t physicalDeviceCount;
 *     VkPhysicalDevice physicalDevices[VK_MAX_DEVICE_GROUP_SIZE];
 *     VkBool32 subsetAllocation;
 * }</code></pre>
 */
class PhysicalDeviceGroupProperties(
        var physicalDevices: Array<PhysicalDevice>,
        var subsetAllocation: Boolean
) {

    val type get() = VkStructureType.PHYSICAL_DEVICE_GROUP_PROPERTIES

    constructor(adr: Adr, instance: VkInstance) : this(
            Array(nphysicalDeviceCount(adr)) { PhysicalDevice(adr + it * Long.BYTES, instance) },
            nsubsetAllocation(adr).bool
                                                      )
}