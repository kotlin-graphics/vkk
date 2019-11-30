package vkk.classes

import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VK10
import org.lwjgl.vulkan.VkCommandBufferAllocateInfo.*
import vkk.VkCommandBufferLevel
import vkk.VkStructureType
import vkk.entities.VkCommandPool

/**
 * Structure specifying the allocation parameters for command buffer object.
 *
 * <h5>Valid Usage</h5>
 *
 *
 *  * `commandBufferCount` **must** be greater than 0
 *
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 *
 *  * `sType` **must** be [STRUCTURE_TYPE_COMMAND_BUFFER_ALLOCATE_INFO][VK10.VK_STRUCTURE_TYPE_COMMAND_BUFFER_ALLOCATE_INFO]
 *  * `pNext` **must** be `NULL`
 *  * `commandPool` **must** be a valid `VkCommandPool` handle
 *  * `level` **must** be a valid `VkCommandBufferLevel` value
 *
 *
 * <h5>See Also</h5>
 *
 *
 * [AllocateCommandBuffers][VK10.vkAllocateCommandBuffers]
 *
 * <h3>Member documentation</h3>
 *
 *
 *  * `sType`  the type of this structure.
 *  * `pNext`  `NULL` or a pointer to an extension-specific structure.
 *  * `commandPool`  the command pool from which the command buffers are allocated.
 *  * `level`  a `VkCommandBufferLevel` value specifying the command buffer level.
 *  * `commandBufferCount`  the number of command buffers to allocate from the pool.
 *
 *
 * <h3>Layout</h3>
 *
 * <pre>`
 * struct VkCommandBufferAllocateInfo {
 * VkStructureType sType;
 * void const * pNext;
 * VkCommandPool commandPool;
 * VkCommandBufferLevel level;
 * uint32_t commandBufferCount;
 * }`</pre>
 */
class CommandBufferAllocateInfo(
        var commandPool: VkCommandPool,
        var level: VkCommandBufferLevel = VkCommandBufferLevel.PRIMARY,
        var commandBufferCount: Int = 1
) {

    val type get() = VkStructureType.COMMAND_BUFFER_ALLOCATE_INFO

    infix fun write(stack: MemoryStack): Ptr =
            stack.ncalloc(ALIGNOF, 1, SIZEOF).also { write(it) }

    fun write(adr: Adr) {
        nsType(adr, type.i)
        ncommandPool(adr, commandPool.L)
        nlevel(adr, level.i)
        ncommandBufferCount(adr, commandBufferCount)
    }
}