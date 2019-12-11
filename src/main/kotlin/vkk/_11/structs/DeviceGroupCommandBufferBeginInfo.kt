package vkk._11.structs

import kool.Ptr
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.NULL
import vkk.VkStructureType

/**
 * Set the initial device mask for a command buffer.
 *
 * <h5>Description</h5>
 *
 * <p>The initial device mask also acts as an upper bound on the set of devices that <b>can</b> ever be in the device mask in the command buffer.</p>
 *
 * <p>If this structure is not present, the initial value of a command buffer's device mask is set to include all physical devices in the logical device when the command buffer begins recording.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code deviceMask} <b>must</b> be a valid device mask value</li>
 * <li>{@code deviceMask} <b>must</b> not be zero</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_DEVICE_GROUP_COMMAND_BUFFER_BEGIN_INFO STRUCTURE_TYPE_DEVICE_GROUP_COMMAND_BUFFER_BEGIN_INFO}</li>
 * </ul>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code deviceMask} &ndash; the initial value of the command buffer&#8217;s device mask.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkDeviceGroupCommandBufferBeginInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     uint32_t deviceMask;
 * }</code></pre>
 */
class DeviceGroupCommandBufferBeginInfo(
    var deviceMask: Int,
    var next: Ptr = NULL
) {

    val type get() = VkStructureType.DEVICE_GROUP_COMMAND_BUFFER_BEGIN_INFO
}