package vkk.vk11.structs

import kool.Ptr
import org.lwjgl.system.MemoryUtil.NULL
import vkk.VkPointClippingBehavior
import vkk.VkStructureType

/**
 * Structure describing the point clipping behavior supported by an implementation.
 *
 * <h5>Description</h5>
 *
 * <p>If the {@link VkPhysicalDevicePointClippingProperties} structure is included in the {@code pNext} chain of {@link VkPhysicalDeviceProperties2}, it is filled with the implementation-dependent limits.</p>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_POINT_CLIPPING_PROPERTIES STRUCTURE_TYPE_PHYSICAL_DEVICE_POINT_CLIPPING_PROPERTIES}</li>
 * </ul>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code pointClippingBehavior} &ndash; the point clipping behavior supported by the implementation, and is of type {@code VkPointClippingBehavior}.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPhysicalDevicePointClippingProperties {
 *     VkStructureType sType;
 *     void * pNext;
 *     VkPointClippingBehavior pointClippingBehavior;
 * }</code></pre>
 */
class PhysicalDevicePointClippingProperties(
        var pointClippingBehavior: VkPointClippingBehavior,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.PHYSICAL_DEVICE_POINT_CLIPPING_PROPERTIES
}