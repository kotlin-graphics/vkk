package vkk._10.structs

import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.memPutAddress
import org.lwjgl.vulkan.VkSparseImageMemoryBindInfo.*
import vkk.entities.VkImage

/**
 * Structure specifying sparse image memory bind info.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>The {@code subresource.mipLevel} member of each element of {@code pBinds} <b>must</b> be less than the {@code mipLevels} specified in {@link VkImageCreateInfo} when {@code image} was created</li>
 * <li>The {@code subresource.arrayLayer} member of each element of {@code pBinds} <b>must</b> be less than the {@code arrayLayers} specified in {@link VkImageCreateInfo} when {@code image} was created</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code image} <b>must</b> be a valid {@code VkImage} handle</li>
 * <li>{@code pBinds} <b>must</b> be a valid pointer to an array of {@code bindCount} valid {@link VkSparseImageMemoryBind} structures</li>
 * <li>{@code bindCount} <b>must</b> be greater than 0</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkBindSparseInfo}, {@link VkSparseImageMemoryBind}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code image} &ndash; the {@code VkImage} object to be bound</li>
 * <li>{@code bindCount} &ndash; the number of {@link VkSparseImageMemoryBind} structures in {@code pBinds} array</li>
 * <li>{@code pBinds} &ndash; a pointer to array of {@link VkSparseImageMemoryBind} structures</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkSparseImageMemoryBindInfo {
 *     VkImage image;
 *     uint32_t bindCount;
 *     {@link VkSparseImageMemoryBind VkSparseImageMemoryBind} const * pBinds;
 * }</code></pre>
 */
class SparseImageMemoryBindInfo(
        var image: VkImage,
        var binds: Array<SparseImageMemoryBind>
) {
    infix fun write(stack: MemoryStack): Adr =
            stack.ncalloc(ALIGNOF, 1, SIZEOF).also { write(it, stack) }

    fun write(adr: Adr, stack: MemoryStack) {
        nimage(adr, image.L)
        nbindCount(adr, binds.size)
        memPutAddress(adr + PBINDS, binds write stack)
    }
}


infix fun Array<SparseImageMemoryBindInfo>.write(stack: MemoryStack): Ptr {
    val natives = stack.ncalloc(ALIGNOF, size, SIZEOF)
    for (i in indices)
        this[i].write(natives + SIZEOF * i, stack)
    return natives
}