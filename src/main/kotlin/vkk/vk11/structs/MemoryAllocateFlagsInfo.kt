package vkk.vk11.structs

import vkk.VkMemoryAllocateFlags
import vkk.VkStructureType

/**
 * Structure controlling how many instances of memory will be allocated.
 *
 * <h5>Description</h5>
 *
 * <p>If {@link VK11#VK_MEMORY_ALLOCATE_DEVICE_MASK_BIT MEMORY_ALLOCATE_DEVICE_MASK_BIT} is not set, the number of instances allocated depends on whether {@link VK11#VK_MEMORY_HEAP_MULTI_INSTANCE_BIT MEMORY_HEAP_MULTI_INSTANCE_BIT} is set in the memory heap. If {@link VK11#VK_MEMORY_HEAP_MULTI_INSTANCE_BIT MEMORY_HEAP_MULTI_INSTANCE_BIT} is set, then memory is allocated for every physical device in the logical device (as if {@code deviceMask} has bits set for all device indices). If {@link VK11#VK_MEMORY_HEAP_MULTI_INSTANCE_BIT MEMORY_HEAP_MULTI_INSTANCE_BIT} is not set, then a single instance of memory is allocated (as if {@code deviceMask} is set to one).</p>
 *
 * <p>On some implementations, allocations from a multi-instance heap <b>may</b> consume memory on all physical devices even if the {@code deviceMask} excludes some devices. If {@link VkPhysicalDeviceGroupProperties}{@code ::subsetAllocation} is {@link VK10#VK_TRUE TRUE}, then memory is only consumed for the devices in the device mask.</p>
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>In practice, most allocations on a multi-instance heap will be allocated across all physical devices. Unicast allocation support is an optional optimization for a minority of allocations.</p>
 * </div>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>If {@link VK11#VK_MEMORY_ALLOCATE_DEVICE_MASK_BIT MEMORY_ALLOCATE_DEVICE_MASK_BIT} is set, {@code deviceMask} <b>must</b> be a valid device mask.</li>
 * <li>If {@link VK11#VK_MEMORY_ALLOCATE_DEVICE_MASK_BIT MEMORY_ALLOCATE_DEVICE_MASK_BIT} is set, {@code deviceMask} <b>must</b> not be zero</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_MEMORY_ALLOCATE_FLAGS_INFO STRUCTURE_TYPE_MEMORY_ALLOCATE_FLAGS_INFO}</li>
 * <li>{@code flags} <b>must</b> be a valid combination of {@code VkMemoryAllocateFlagBits} values</li>
 * </ul>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code flags} &ndash; a bitmask of {@code VkMemoryAllocateFlagBits} controlling the allocation.</li>
 * <li>{@code deviceMask} &ndash; a mask of physical devices in the logical device, indicating that memory <b>must</b> be allocated on each device in the mask, if {@link VK11#VK_MEMORY_ALLOCATE_DEVICE_MASK_BIT MEMORY_ALLOCATE_DEVICE_MASK_BIT} is set in {@code flags}.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkMemoryAllocateFlagsInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkMemoryAllocateFlags flags;
 *     uint32_t deviceMask;
 * }</code></pre>
 */
class MemoryAllocateFlagsInfo(
        var flags: VkMemoryAllocateFlags,
        var deviceMask: Int
) {

    val type get() = VkStructureType.MEMORY_ALLOCATE_FLAGS_INFO
}