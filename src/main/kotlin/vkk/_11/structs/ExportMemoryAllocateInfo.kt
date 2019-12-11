package vkk._11.structs

import kool.Ptr
import org.lwjgl.system.MemoryUtil.NULL
import vkk.VkExternalMemoryHandleTypeFlags
import vkk.VkStructureType

/**
 * Specify exportable handle types for a device memory object.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>The bits in {@code handleTypes} <b>must</b> be supported and compatible, as reported by {@link VkExternalImageFormatProperties} or {@link VkExternalBufferProperties}.</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_EXPORT_MEMORY_ALLOCATE_INFO STRUCTURE_TYPE_EXPORT_MEMORY_ALLOCATE_INFO}</li>
 * <li>{@code handleTypes} <b>must</b> be a valid combination of {@code VkExternalMemoryHandleTypeFlagBits} values</li>
 * </ul>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code handleTypes} &ndash; a bitmask of {@code VkExternalMemoryHandleTypeFlagBits} specifying one or more memory handle types the application <b>can</b> export from the resulting allocation. The application <b>can</b> request multiple handle types for the same allocation.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkExportMemoryAllocateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkExternalMemoryHandleTypeFlags handleTypes;
 * }</code></pre>
 */
class ExportMemoryAllocateInfo(
    var handleTypes: VkExternalMemoryHandleTypeFlags,
    var next: Ptr = NULL
) {

    val type get() = VkStructureType.EXPORT_MEMORY_ALLOCATE_INFO
}