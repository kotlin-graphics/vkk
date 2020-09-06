package vkk.vk11.structs

import kool.Adr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkBufferMemoryRequirementsInfo2.*
import vkk.VkStructureType
import vkk.entities.VkBuffer

/**
 * (None).
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_BUFFER_MEMORY_REQUIREMENTS_INFO_2 STRUCTURE_TYPE_BUFFER_MEMORY_REQUIREMENTS_INFO_2}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL}</li>
 * <li>{@code buffer} <b>must</b> be a valid {@code VkBuffer} handle</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VK11#vkGetBufferMemoryRequirements2 GetBufferMemoryRequirements2}, {@link KHRGetMemoryRequirements2#vkGetBufferMemoryRequirements2KHR GetBufferMemoryRequirements2KHR}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code buffer} &ndash; the buffer to query.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkBufferMemoryRequirementsInfo2 {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkBuffer buffer;
 * }</code></pre>
 */
class BufferMemoryRequirementsInfo2(
        var buffer: VkBuffer
) {

    val type get() = VkStructureType.BUFFER_MEMORY_REQUIREMENTS_INFO_2

    infix fun write(stack: MemoryStack): Adr {
        val adr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
        nsType(adr, type.i)
        nbuffer(adr, buffer.L)
        return adr
    }
}