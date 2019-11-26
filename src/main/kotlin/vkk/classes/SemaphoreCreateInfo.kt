package classes

import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.vulkan.VkSemaphoreCreateInfo.*
import vkk.VkStructureType

/**
 * Structure specifying parameters of a newly created semaphore.
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK10#VK_STRUCTURE_TYPE_SEMAPHORE_CREATE_INFO STRUCTURE_TYPE_SEMAPHORE_CREATE_INFO}</li>
 * <li>Each {@code pNext} member of any structure (including this one) in the {@code pNext} chain <b>must</b> be either {@code NULL} or a pointer to a valid instance of {@link VkExportSemaphoreCreateInfo} or {@link VkExportSemaphoreWin32HandleInfoKHR}</li>
 * <li>Each {@code sType} member in the {@code pNext} chain <b>must</b> be unique</li>
 * <li>{@code flags} <b>must</b> be 0</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VK10#vkCreateSemaphore CreateSemaphore}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code flags} &ndash; reserved for future use.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkSemaphoreCreateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkSemaphoreCreateFlags flags;
 * }</code></pre>
 */
class SemaphoreCreateInfo(
    var next: Ptr = NULL
) {

    val type get() = VkStructureType.SEMAPHORE_CREATE_INFO

    val MemoryStack.native: Ptr
        get() = ncalloc(ALIGNOF, 1, SIZEOF).also {
            nsType(it, type.i)
            npNext(it, next)
        }
}