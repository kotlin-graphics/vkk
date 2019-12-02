package vkk._11.structs

import kool.Ptr
import org.lwjgl.system.MemoryUtil.NULL
import vkk.VkExternalSemaphoreHandleType
import vkk.VkStructureType

/**
 * Structure specifying semaphore creation parameters.
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_EXTERNAL_SEMAPHORE_INFO STRUCTURE_TYPE_PHYSICAL_DEVICE_EXTERNAL_SEMAPHORE_INFO}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL}</li>
 * <li>{@code handleType} <b>must</b> be a valid {@code VkExternalSemaphoreHandleTypeFlagBits} value</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VK11#vkGetPhysicalDeviceExternalSemaphoreProperties GetPhysicalDeviceExternalSemaphoreProperties}, {@link KHRExternalSemaphoreCapabilities#vkGetPhysicalDeviceExternalSemaphorePropertiesKHR GetPhysicalDeviceExternalSemaphorePropertiesKHR}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure</li>
 * <li>{@code pNext} &ndash; NULL or a pointer to an extension-specific structure.</li>
 * <li>{@code handleType} &ndash; a {@code VkExternalSemaphoreHandleTypeFlagBits} value specifying the external semaphore handle type for which capabilities will be returned.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPhysicalDeviceExternalSemaphoreInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkExternalSemaphoreHandleTypeFlagBits handleType;
 * }</code></pre>
 */
class PhysicalDeviceExternalSemaphoreInfo(
    var handleType: VkExternalSemaphoreHandleType,
    var next: Ptr = NULL
) {

    val type get() = VkStructureType.PHYSICAL_DEVICE_EXTERNAL_SEMAPHORE_INFO
}