package vkk._11.structs

import kool.BytePtr
import kool.Ptr
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.vulkan.VkQueueFamilyProperties2
import org.lwjgl.vulkan.VkQueueFamilyProperties2.QUEUEFAMILYPROPERTIES
import org.lwjgl.vulkan.VkQueueFamilyProperties2.npNext
import vkk.VkStructureType
import vkk._10.structs.QueueFamilyProperties

/**
 * Structure providing information about a queue family.
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_QUEUE_FAMILY_PROPERTIES_2 STRUCTURE_TYPE_QUEUE_FAMILY_PROPERTIES_2}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL} or a pointer to a valid instance of {@link VkQueueFamilyCheckpointPropertiesNV}</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkQueueFamilyProperties}, {@link VK11#vkGetPhysicalDeviceQueueFamilyProperties2 GetPhysicalDeviceQueueFamilyProperties2}, {@link KHRGetPhysicalDeviceProperties2#vkGetPhysicalDeviceQueueFamilyProperties2KHR GetPhysicalDeviceQueueFamilyProperties2KHR}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code queueFamilyProperties} &ndash; a structure of type {@link VkQueueFamilyProperties} which is populated with the same values as in {@link VK10#vkGetPhysicalDeviceQueueFamilyProperties GetPhysicalDeviceQueueFamilyProperties}.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkQueueFamilyProperties2 {
 *     VkStructureType sType;
 *     void * pNext;
 *     {@link VkQueueFamilyProperties VkQueueFamilyProperties} queueFamilyProperties;
 * }</code></pre>
 */
class QueueFamilyProperties2(
        var queueFamilyProperties: QueueFamilyProperties,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.QUEUE_FAMILY_PROPERTIES_2

    constructor(ptr: BytePtr) : this(
            QueueFamilyProperties(ptr + QUEUEFAMILYPROPERTIES),
            npNext(ptr.adr)
    )
}