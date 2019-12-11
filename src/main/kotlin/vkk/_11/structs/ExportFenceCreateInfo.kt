package vkk._11.structs

import kool.Ptr
import org.lwjgl.system.MemoryUtil.NULL
import vkk.VkExternalFenceHandleTypeFlags
import vkk.VkStructureType

/**
 * Structure specifying handle types that can be exported from a fence.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>The bits in {@code handleTypes} must be supported and compatible, as reported by {@link VkExternalFenceProperties}.</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_EXPORT_FENCE_CREATE_INFO STRUCTURE_TYPE_EXPORT_FENCE_CREATE_INFO}</li>
 * <li>{@code handleTypes} <b>must</b> be a valid combination of {@code VkExternalFenceHandleTypeFlagBits} values</li>
 * </ul>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code handleTypes} &ndash; a bitmask of {@code VkExternalFenceHandleTypeFlagBits} specifying one or more fence handle types the application <b>can</b> export from the resulting fence. The application <b>can</b> request multiple handle types for the same fence.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkExportFenceCreateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkExternalFenceHandleTypeFlags handleTypes;
 * }</code></pre>
 */
class ExportFenceCreateInfo(
    var handleTypes: VkExternalFenceHandleTypeFlags,
    var next: Ptr = NULL
) {

    val type get() = VkStructureType.EXPORT_FENCE_CREATE_INFO
}