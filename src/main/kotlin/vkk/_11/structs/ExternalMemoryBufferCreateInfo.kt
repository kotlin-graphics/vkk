package vkk._11.structs

import kool.Ptr
import org.lwjgl.system.MemoryUtil.NULL
import vkk.VkExternalMemoryHandleTypeFlags
import vkk.VkStructureType

/**
 * Specify that a buffer may be backed by external memory.
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_EXTERNAL_MEMORY_BUFFER_CREATE_INFO STRUCTURE_TYPE_EXTERNAL_MEMORY_BUFFER_CREATE_INFO}</li>
 * <li>{@code handleTypes} <b>must</b> be a valid combination of {@code VkExternalMemoryHandleTypeFlagBits} values</li>
 * </ul>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code handleTypes} &ndash; a bitmask of {@code VkExternalMemoryHandleTypeFlagBits} specifying one or more external memory handle types.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkExternalMemoryBufferCreateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkExternalMemoryHandleTypeFlags handleTypes;
 * }</code></pre>
 */
class ExternalMemoryBufferCreateInfo(
        var handleTypes: VkExternalMemoryHandleTypeFlags,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.EXTERNAL_MEMORY_BUFFER_CREATE_INFO
}