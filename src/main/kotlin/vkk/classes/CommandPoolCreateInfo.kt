package vkk.classes

import kool.Adr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VK10
import org.lwjgl.vulkan.VkCommandPoolCreateInfo.*
import vkk.VkCommandPoolCreateFlags
import vkk.VkStructureType

/**
 * Structure specifying parameters of a newly created command pool.
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 *
 *  * `sType` **must** be [STRUCTURE_TYPE_COMMAND_POOL_CREATE_INFO][VK10.VK_STRUCTURE_TYPE_COMMAND_POOL_CREATE_INFO]
 *  * `pNext` **must** be `NULL`
 *  * `flags` **must** be a valid combination of `VkCommandPoolCreateFlagBits` values
 *
 *
 * <h5>See Also</h5>
 *
 *
 * [CreateCommandPool][VK10.vkCreateCommandPool]
 *
 * <h3>Member documentation</h3>
 *
 *
 *  * `sType`  the type of this structure.
 *  * `pNext`  `NULL` or a pointer to an extension-specific structure.
 *  * `flags`  a bitmask of `VkCommandPoolCreateFlagBits` indicating usage behavior for the pool and command buffers allocated from it.
 *  * `queueFamilyIndex`  designates a queue family as described in section [Queue Family Properties](https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#devsandqueues-queueprops). All command buffers allocated from this command pool **must** be submitted on queues from the same queue family.
 *
 *
 * <h3>Layout</h3>
 *
 * <pre>`
 * struct VkCommandPoolCreateInfo {
 * VkStructureType sType;
 * void const * pNext;
 * VkCommandPoolCreateFlags flags;
 * uint32_t queueFamilyIndex;
 * }`</pre>
 */
class CommandPoolCreateInfo(
        var flags: VkCommandPoolCreateFlags,
        var queueFamilyIndex: Int
) {

    val type get() = VkStructureType.COMMAND_POOL_CREATE_INFO

    fun write(stack: MemoryStack): Adr =
            stack.ncalloc(ALIGNOF, 1, SIZEOF).also { write(it) }

    fun write(adr: Adr) {
        nsType(adr, type.i)
        nflags(adr, flags)
        nqueueFamilyIndex(adr, queueFamilyIndex)
    }
}