package vkk.vk11.structs

import kool.Ptr
import org.lwjgl.system.MemoryUtil.NULL
import vkk.VkExternalSemaphoreHandleTypeFlags
import vkk.VkStructureType

/**
 * Structure specifying handle types that can be exported from a semaphore.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>The bits in {@code handleTypes} <b>must</b> be supported and compatible, as reported by {@link VkExternalSemaphoreProperties}.</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_EXPORT_SEMAPHORE_CREATE_INFO STRUCTURE_TYPE_EXPORT_SEMAPHORE_CREATE_INFO}</li>
 * <li>{@code handleTypes} <b>must</b> be a valid combination of {@code VkExternalSemaphoreHandleTypeFlagBits} values</li>
 * </ul>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code handleTypes} &ndash; a bitmask of {@code VkExternalSemaphoreHandleTypeFlagBits} specifying one or more semaphore handle types the application <b>can</b> export from the resulting semaphore. The application <b>can</b> request multiple handle types for the same semaphore.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkExportSemaphoreCreateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkExternalSemaphoreHandleTypeFlags handleTypes;
 * }</code></pre>
 */
class ExportSemaphoreCreateInfo(
    var handleTypes: VkExternalSemaphoreHandleTypeFlags,
    var next: Ptr = NULL
) {

    val type get() = VkStructureType.EXPORT_SEMAPHORE_CREATE_INFO
}