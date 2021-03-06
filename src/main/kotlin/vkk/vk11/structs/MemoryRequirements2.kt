package vkk.vk11.structs

import kool.Adr
import kool.BytePtr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.vulkan.VkMemoryRequirements2.*
import vkk.VkStructureType
import vkk.invoke
import vkk.vk10.structs.MemoryRequirements

/**
 * Structure specifying memory requirements.
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_MEMORY_REQUIREMENTS_2 STRUCTURE_TYPE_MEMORY_REQUIREMENTS_2}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL} or a pointer to a valid instance of {@link VkMemoryDedicatedRequirements}</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkMemoryRequirements}, {@link VK11#vkGetBufferMemoryRequirements2 GetBufferMemoryRequirements2}, {@link KHRGetMemoryRequirements2#vkGetBufferMemoryRequirements2KHR GetBufferMemoryRequirements2KHR}, {@link VK11#vkGetImageMemoryRequirements2 GetImageMemoryRequirements2}, {@link KHRGetMemoryRequirements2#vkGetImageMemoryRequirements2KHR GetImageMemoryRequirements2KHR}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code memoryRequirements} &ndash; a structure of type {@link VkMemoryRequirements} describing the memory requirements of the resource.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkMemoryRequirements2 {
 *     VkStructureType sType;
 *     void * pNext;
 *     {@link VkMemoryRequirements VkMemoryRequirements} memoryRequirements;
 * }</code></pre>
 */
class MemoryRequirements2(
        var memoryRequirements: MemoryRequirements,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.MEMORY_REQUIREMENTS_2

    constructor(ptr: BytePtr) : this(MemoryRequirements(ptr + MEMORYREQUIREMENTS))

    companion object {
//        inline infix fun <R> read(block: (Adr) -> R): MemoryRequirements2 = stak { read(it, block) }
        inline fun <R> read(stack: MemoryStack, block: (Adr) -> R): MemoryRequirements2 = stack {
            val adr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
            block(adr)
            MemoryRequirements2(BytePtr(adr))
        }
    }
}