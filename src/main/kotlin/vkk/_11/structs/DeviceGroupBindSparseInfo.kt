package vkk._11.structs

import kool.Ptr
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.NULL
import vkk.VkStructureType

/**
 * Structure indicating which instances are bound.
 *
 * <h5>Description</h5>
 *
 * <p>These device indices apply to all buffer and image memory binds included in the batch that points to this structure. The semaphore waits and signals for the batch are executed only by the physical device specified by the {@code resourceDeviceIndex}.</p>
 *
 * <p>If this structure is not present, {@code resourceDeviceIndex} and {@code memoryDeviceIndex} are assumed to be zero.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code resourceDeviceIndex} and {@code memoryDeviceIndex} <b>must</b> both be valid device indices.</li>
 * <li>Each memory allocation bound in this batch <b>must</b> have allocated an instance for {@code memoryDeviceIndex}.</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_DEVICE_GROUP_BIND_SPARSE_INFO STRUCTURE_TYPE_DEVICE_GROUP_BIND_SPARSE_INFO}</li>
 * </ul>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code resourceDeviceIndex} &ndash; a device index indicating which instance of the resource is bound.</li>
 * <li>{@code memoryDeviceIndex} &ndash; a device index indicating which instance of the memory the resource instance is bound to.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkDeviceGroupBindSparseInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     uint32_t resourceDeviceIndex;
 *     uint32_t memoryDeviceIndex;
 * }</code></pre>
 */
class DeviceGroupBindSparseInfo(
        var resourceDeviceIndex: Int,
        var memoryDeviceIndex: Int,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.DEVICE_GROUP_BIND_SPARSE_INFO
}