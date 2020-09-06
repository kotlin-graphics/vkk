package vkk.vk11.structs

import kool.Adr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkDeviceQueueInfo2.*
import vkk.VkDeviceQueueCreateFlags
import vkk.VkStructureType

/**
 * Structure specifying the parameters used for device queue creation.
 *
 * <h5>Description</h5>
 *
 * <p>The queue returned by {@code vkGetDeviceQueue2} <b>must</b> have the same {@code flags} value from this structure as that used at device creation time in a {@link VkDeviceQueueCreateInfo} instance. If no matching {@code flags} were specified at device creation time then {@code pQueue} will return {@link VK10#VK_NULL_HANDLE NULL_HANDLE}.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code queueFamilyIndex} <b>must</b> be one of the queue family indices specified when {@code device} was created, via the {@link VkDeviceQueueCreateInfo} structure</li>
 * <li>{@code queueIndex} <b>must</b> be less than the number of queues created for the specified queue family index and {@code VkDeviceQueueCreateFlags} member {@code flags} equal to this {@code flags} value when {@code device} was created, via the {@code queueCount} member of the {@link VkDeviceQueueCreateInfo} structure</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_DEVICE_QUEUE_INFO_2 STRUCTURE_TYPE_DEVICE_QUEUE_INFO_2}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL}</li>
 * <li>{@code flags} <b>must</b> be a valid combination of {@code VkDeviceQueueCreateFlagBits} values</li>
 * <li>{@code flags} <b>must</b> not be 0</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VK11#vkGetDeviceQueue2 GetDeviceQueue2}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure. The {@code pNext} chain of {@link VkDeviceQueueInfo2} is used to provide additional image parameters to {@code vkGetDeviceQueue2}.</li>
 * <li>{@code flags} &ndash; a {@code VkDeviceQueueCreateFlags} value indicating the flags used to create the device queue.</li>
 * <li>{@code queueFamilyIndex} &ndash; the index of the queue family to which the queue belongs.</li>
 * <li>{@code queueIndex} &ndash; the index within this queue family of the queue to retrieve.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkDeviceQueueInfo2 {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkDeviceQueueCreateFlags flags;
 *     uint32_t queueFamilyIndex;
 *     uint32_t queueIndex;
 * }</code></pre>
 */
class DeviceQueueInfo2(
        var flags: VkDeviceQueueCreateFlags,
        var queueFamilyIndex: Int,
        var queueIndex: Int
) {

    val type get() = VkStructureType.DEVICE_QUEUE_INFO_2

    infix fun write(stack: MemoryStack): Adr {
        val adr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
        nsType(adr, type.i)
        nflags(adr, flags)
        nqueueFamilyIndex(adr, queueFamilyIndex)
        nqueueIndex(adr, queueIndex)
        return adr
    }
}