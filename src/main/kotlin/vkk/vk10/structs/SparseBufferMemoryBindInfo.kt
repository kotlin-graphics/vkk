package vkk.vk10.structs

import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.memPutAddress
import org.lwjgl.vulkan.VkSparseBufferMemoryBindInfo.*
import vkk.entities.VkBuffer

/**
 * Structure specifying a sparse buffer memory bind operation.
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code buffer} <b>must</b> be a valid {@code VkBuffer} handle</li>
 * <li>{@code pBinds} <b>must</b> be a valid pointer to an array of {@code bindCount} valid {@link VkSparseMemoryBind} structures</li>
 * <li>{@code bindCount} <b>must</b> be greater than 0</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkBindSparseInfo}, {@link VkSparseMemoryBind}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code buffer} &ndash; the {@code VkBuffer} object to be bound.</li>
 * <li>{@code bindCount} &ndash; the number of {@link VkSparseMemoryBind} structures in the {@code pBinds} array.</li>
 * <li>{@code pBinds} &ndash; a pointer to array of {@link VkSparseMemoryBind} structures.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkSparseBufferMemoryBindInfo {
 *     VkBuffer buffer;
 *     uint32_t bindCount;
 *     {@link VkSparseMemoryBind VkSparseMemoryBind} const * pBinds;
 * }</code></pre>
 */
class SparseBufferMemoryBindInfo(
        var buffer: VkBuffer,
        var binds: Array<SparseMemoryBind>
) {

    infix fun write(stack: MemoryStack): Adr =
        stack.ncalloc(ALIGNOF, 1, SIZEOF).also { write(it, stack) }

    fun write(adr: Adr, stack: MemoryStack) {
        nbuffer(adr, buffer.L)
        nbindCount(adr, binds.size)
        memPutAddress(adr + PBINDS, binds write stack)
    }
}

infix fun Array<SparseBufferMemoryBindInfo>.write(stack: MemoryStack): Ptr {
    val natives = stack.ncalloc(ALIGNOF, size, SIZEOF)
    for (i in indices)
        this[i].write(natives + SIZEOF * i, stack)
    return natives
}