package vkk.vk10.structs

import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.system.MemoryUtil.memPutAddress
import org.lwjgl.vulkan.VK10
import org.lwjgl.vulkan.VkDeviceCreateInfo
import org.lwjgl.vulkan.VkDeviceQueueCreateInfo.*
import org.lwjgl.vulkan.VkDeviceQueueGlobalPriorityCreateInfoEXT
import org.lwjgl.vulkan.VkQueueFamilyProperties
import vkk.VkDeviceQueueCreateFlags
import vkk.VkStructureType
import vkk.adr

/**
 * Structure specifying parameters of a newly created device queue.
 *
 * <h5>Valid Usage</h5>
 *
 *
 *  * `queueFamilyIndex` **must** be less than `pQueueFamilyPropertyCount` returned by `vkGetPhysicalDeviceQueueFamilyProperties`
 *  * `queueCount` **must** be less than or equal to the `queueCount` member of the [VkQueueFamilyProperties] structure, as returned by `vkGetPhysicalDeviceQueueFamilyProperties` in the `pQueueFamilyProperties`[`queueFamilyIndex`]
 *  * Each element of `pQueuePriorities` **must** be between `0.0` and `1.0` inclusive
 *
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 *
 *  * `sType` **must** be [STRUCTURE_TYPE_DEVICE_QUEUE_CREATE_INFO][VK10.VK_STRUCTURE_TYPE_DEVICE_QUEUE_CREATE_INFO]
 *  * `pNext` **must** be `NULL` or a pointer to a valid instance of [VkDeviceQueueGlobalPriorityCreateInfoEXT]
 *  * `flags` **must** be a valid combination of `VkDeviceQueueCreateFlagBits` values
 *  * `pQueuePriorities` **must** be a valid pointer to an array of `queueCount` `float` values
 *  * `queueCount` **must** be greater than 0
 *
 *
 * <h5>See Also</h5>
 *
 *
 * [VkDeviceCreateInfo]
 *
 * <h3>Member documentation</h3>
 *
 *
 *  * `sType`  the type of this structure.
 *  * `pNext`  `NULL` or a pointer to an extension-specific structure.
 *  * `flags`  a bitmask indicating behavior of the queue.
 *  * `queueFamilyIndex`  an unsigned integer indicating the index of the queue family to create on this device. This index corresponds to the index of an element of the `pQueueFamilyProperties` array that was returned by `vkGetPhysicalDeviceQueueFamilyProperties`.
 *  * `queueCount`  an unsigned integer specifying the number of queues to create in the queue family indicated by `queueFamilyIndex`.
 *  * `pQueuePriorities`  an array of `queueCount` normalized floating point values, specifying priorities of work that will be submitted to each created queue. See [Queue Priority](https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#devsandqueues-priority) for more information.
 *
 *
 * <h3>Layout</h3>
 *
 * <pre>`
 * struct VkDeviceQueueCreateInfo {
 * VkStructureType sType;
 * void const * pNext;
 * VkDeviceQueueCreateFlags flags;
 * uint32_t queueFamilyIndex;
 * uint32_t queueCount;
 * float const * pQueuePriorities;
 * }`</pre>
 */
class DeviceQueueCreateInfo(
    var flags: VkDeviceQueueCreateFlags = 0,
    var queueFamilyIndex: Int = 0,
    var queuePriorities: FloatArray,
    var next: Ptr = NULL
) {

    constructor(
        flags: VkDeviceQueueCreateFlags = 0,
        queueFamilyIndex: Int = 0,
        queuePriority: Float,
        next: Ptr = NULL
    ) : this(flags, queueFamilyIndex, floatArrayOf(queuePriority), next)

    val type get() = VkStructureType.DEVICE_QUEUE_CREATE_INFO

    var queuePriority: Float
        get() = queuePriorities[0]
        set(value) = queuePriorities.set(0, value)

    fun write(stack: MemoryStack): Adr =
        stack.ncalloc(ALIGNOF, 1, SIZEOF).also { write(it, stack) }

    fun write(adr: Adr, stack: MemoryStack) {
        nsType(adr, type.i)
        nflags(adr, flags)
        nqueueFamilyIndex(adr, queueFamilyIndex)
        nqueueCount(adr, queuePriorities.size)
        memPutAddress(adr + PQUEUEPRIORITIES, stack.adr(queuePriorities))
    }
}

//infix fun Array<DeviceQueueCreateInfo>.write(stack: MemoryStack): Ptr {
//    val natives = stack.ncalloc(ALIGNOF, size, SIZEOF)
//    for (i in indices)
//        this[i].write(natives + SIZEOF * i, stack)
//    return natives
//}