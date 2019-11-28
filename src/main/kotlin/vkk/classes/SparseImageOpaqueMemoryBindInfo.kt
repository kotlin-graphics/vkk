package vkk.classes

import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.memPutAddress
import org.lwjgl.vulkan.VkSparseBufferMemoryBindInfo
import org.lwjgl.vulkan.VkSparseImageOpaqueMemoryBindInfo
import org.lwjgl.vulkan.VkSparseImageOpaqueMemoryBindInfo.*
import vkk.entities.VkImage

/**
 * Structure specifying sparse image opaque memory bind info.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>If the {@code flags} member of any element of {@code pBinds} contains {@link VK10#VK_SPARSE_MEMORY_BIND_METADATA_BIT SPARSE_MEMORY_BIND_METADATA_BIT}, the binding range defined <b>must</b> be within the mip tail region of the metadata aspect of {@code image}</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code image} <b>must</b> be a valid {@code VkImage} handle</li>
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
 * <li>{@code image} &ndash; the {@code VkImage} object to be bound.</li>
 * <li>{@code bindCount} &ndash; the number of {@link VkSparseMemoryBind} structures in the {@code pBinds} array.</li>
 * <li>{@code pBinds} &ndash; a pointer to array of {@link VkSparseMemoryBind} structures.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkSparseImageOpaqueMemoryBindInfo {
 *     VkImage image;
 *     uint32_t bindCount;
 *     {@link VkSparseMemoryBind VkSparseMemoryBind} const * pBinds;
 * }</code></pre>
 */
class SparseImageOpaqueMemoryBindInfo(
        var image: VkImage,
        var binds: Array<SparseMemoryBind>
) {

    infix fun write(stack: MemoryStack): Adr =
        stack.ncalloc(ALIGNOF, 1, SIZEOF).also { write(it, stack) }

    fun write(adr: Adr, stack: MemoryStack) {
        nimage(adr, image.L)
        nbindCount(adr, binds.size)
        memPutAddress(adr + PBINDS, binds write stack)
    }
}

infix fun Array<SparseImageOpaqueMemoryBindInfo>.write(stack: MemoryStack): Ptr {
    val natives = stack.ncalloc(ALIGNOF, size, SIZEOF)
    for (i in indices)
        this[i].write(natives + SIZEOF * i, stack)
    return natives
}