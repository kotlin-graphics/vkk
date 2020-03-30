package vkk.vk10.structs

import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.vulkan.VkFenceCreateInfo.*
import vkk.VkFenceCreateFlags
import vkk.VkStack
import vkk.VkStructureType

/**
 * Structure specifying parameters of a newly created fence.
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK10#VK_STRUCTURE_TYPE_FENCE_CREATE_INFO STRUCTURE_TYPE_FENCE_CREATE_INFO}</li>
 * <li>Each {@code pNext} member of any structure (including this one) in the {@code pNext} chain <b>must</b> be either {@code NULL} or a pointer to a valid instance of {@link VkExportFenceCreateInfo} or {@link VkExportFenceWin32HandleInfoKHR}</li>
 * <li>Each {@code sType} member in the {@code pNext} chain <b>must</b> be unique</li>
 * <li>{@code flags} <b>must</b> be a valid combination of {@code VkFenceCreateFlagBits} values</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VK10#vkCreateFence CreateFence}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code flags} &ndash; a bitmask of {@code VkFenceCreateFlagBits} specifying the initial state and behavior of the fence.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkFenceCreateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkFenceCreateFlags flags;
 * }</code></pre>
 */
class FenceCreateInfo(
        var flags: VkFenceCreateFlags = 0,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.FENCE_CREATE_INFO

    infix fun write(stack: VkStack): Adr{
        val adr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
        nsType(adr, type.i)
        npNext(adr, next)
        nflags(adr, flags)
        return adr
    }
}