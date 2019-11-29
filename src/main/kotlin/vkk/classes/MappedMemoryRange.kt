package vkk.classes

import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkMappedMemoryRange
import org.lwjgl.vulkan.VkMappedMemoryRange.*
import org.lwjgl.vulkan.VkVertexInputAttributeDescription
import vkk.VkStructureType
import vkk.entities.VkDeviceMemory
import vkk.entities.VkDeviceSize

/**
 * Structure specifying a mapped memory range.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code memory} <b>must</b> be currently host mapped</li>
 * <li>If {@code size} is not equal to {@link VK10#VK_WHOLE_SIZE WHOLE_SIZE}, {@code offset} and {@code size} <b>must</b> specify a range contained within the currently mapped range of {@code memory}</li>
 * <li>If {@code size} is equal to {@link VK10#VK_WHOLE_SIZE WHOLE_SIZE}, {@code offset} <b>must</b> be within the currently mapped range of {@code memory}</li>
 * <li>If {@code size} is equal to {@link VK10#VK_WHOLE_SIZE WHOLE_SIZE}, the end of the current mapping of {@code memory} <b>must</b> be a multiple of {@link VkPhysicalDeviceLimits}{@code ::nonCoherentAtomSize} bytes from the beginning of the memory object.</li>
 * <li>{@code offset} <b>must</b> be a multiple of {@link VkPhysicalDeviceLimits}{@code ::nonCoherentAtomSize}</li>
 * <li>If {@code size} is not equal to {@link VK10#VK_WHOLE_SIZE WHOLE_SIZE}, {@code size} <b>must</b> either be a multiple of {@link VkPhysicalDeviceLimits}{@code ::nonCoherentAtomSize}, or {@code offset} plus {@code size} <b>must</b> equal the size of {@code memory}.</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK10#VK_STRUCTURE_TYPE_MAPPED_MEMORY_RANGE STRUCTURE_TYPE_MAPPED_MEMORY_RANGE}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL}</li>
 * <li>{@code memory} <b>must</b> be a valid {@code VkDeviceMemory} handle</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VK10#vkFlushMappedMemoryRanges FlushMappedMemoryRanges}, {@link VK10#vkInvalidateMappedMemoryRanges InvalidateMappedMemoryRanges}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code memory} &ndash; the memory object to which this range belongs.</li>
 * <li>{@code offset} &ndash; the zero-based byte offset from the beginning of the memory object.</li>
 * <li>{@code size} &ndash; either the size of range, or {@link VK10#VK_WHOLE_SIZE WHOLE_SIZE} to affect the range from {@code offset} to the end of the current mapping of the allocation.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkMappedMemoryRange {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkDeviceMemory memory;
 *     VkDeviceSize offset;
 *     VkDeviceSize size;
 * }</code></pre>
 */
class MappedMemoryRange(
        var memory: VkDeviceMemory,
        var offset: VkDeviceSize = VkDeviceSize(0),
        var size: VkDeviceSize
) {

    val type get() = VkStructureType.MAPPED_MEMORY_RANGE

    infix fun write(stack: MemoryStack): Adr =
        stack.ncalloc(ALIGNOF, 1, SIZEOF).also { write(it) }

    infix fun write(adr: Adr) {
        nsType(adr, type.i)
        nmemory(adr, memory.L)
        noffset(adr, offset.L)
        nsize(adr, size.L)
    }
}

infix fun Array<MappedMemoryRange>.write(stack: MemoryStack): Ptr {
    val natives = stack.ncalloc(ALIGNOF, size, SIZEOF)
    for (i in indices)
        this[i] write (natives + i * SIZEOF)
    return natives
}