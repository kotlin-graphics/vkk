package vkk._11.structs

import kool.Ptr
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.NULL
import vkk.VkStructureType
import vkk._10.structs.Rect2D

/**
 * Set the initial device mask and render areas for a render pass instance.
 *
 * <h5>Description</h5>
 *
 * <p>The {@code deviceMask} serves several purposes. It is an upper bound on the set of physical devices that <b>can</b> be used during the render pass instance, and the initial device mask when the render pass instance begins. In addition, commands transitioning to the next subpass in the render pass instance and commands ending the render pass instance, and, accordingly render pass attachment load, store, and resolve operations and subpass dependencies corresponding to the render pass instance, are executed on the physical devices included in the device mask provided here.</p>
 *
 * <p>If {@code deviceRenderAreaCount} is not zero, then the elements of {@code pDeviceRenderAreas} override the value of {@link VkRenderPassBeginInfo}{@code ::renderArea}, and provide a render area specific to each physical device. These render areas serve the same purpose as {@link VkRenderPassBeginInfo}{@code ::renderArea}, including controlling the region of attachments that are cleared by {@link VK10#VK_ATTACHMENT_LOAD_OP_CLEAR ATTACHMENT_LOAD_OP_CLEAR} and that are resolved into resolve attachments.</p>
 *
 * <p>If this structure is not present, the render pass instance's device mask is the value of {@link VkDeviceGroupCommandBufferBeginInfo}{@code ::deviceMask}. If this structure is not present or if {@code deviceRenderAreaCount} is zero, {@link VkRenderPassBeginInfo}{@code ::renderArea} is used for all physical devices.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code deviceMask} <b>must</b> be a valid device mask value</li>
 * <li>{@code deviceMask} <b>must</b> not be zero</li>
 * <li>{@code deviceMask} <b>must</b> be a subset of the command buffer&#8217;s initial device mask</li>
 * <li>{@code deviceRenderAreaCount} <b>must</b> either be zero or equal to the number of physical devices in the logical device.</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_DEVICE_GROUP_RENDER_PASS_BEGIN_INFO STRUCTURE_TYPE_DEVICE_GROUP_RENDER_PASS_BEGIN_INFO}</li>
 * <li>If {@code deviceRenderAreaCount} is not 0, {@code pDeviceRenderAreas} <b>must</b> be a valid pointer to an array of {@code deviceRenderAreaCount} {@link VkRect2D} structures</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkRect2D}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code deviceMask} &ndash; the device mask for the render pass instance.</li>
 * <li>{@code deviceRenderAreaCount} &ndash; the number of elements in the {@code pDeviceRenderAreas} array.</li>
 * <li>{@code pDeviceRenderAreas} &ndash; an array of structures of type {@link VkRect2D} defining the render area for each physical device.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkDeviceGroupRenderPassBeginInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     uint32_t deviceMask;
 *     uint32_t deviceRenderAreaCount;
 *     {@link VkRect2D VkRect2D} const * pDeviceRenderAreas;
 * }</code></pre>
 */
class DeviceGroupRenderPassBeginInfo(
        var deviceMask: Int,
        var deviceRenderAreas: Array<Rect2D>? = null,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.DEVICE_GROUP_RENDER_PASS_BEGIN_INFO
}