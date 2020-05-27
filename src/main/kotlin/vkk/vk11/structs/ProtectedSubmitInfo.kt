package vkk.vk11.structs

import kool.Ptr
import org.lwjgl.system.MemoryUtil.NULL
import vkk.VkStructureType

/**
 * Structure indicating whether the submission is protected.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>If the protected memory feature is not enabled, {@code protectedSubmit} <b>must</b> not be {@link VK10#VK_TRUE TRUE}.</li>
 * <li>If {@code protectedSubmit} is {@link VK10#VK_TRUE TRUE}, then each element of the {@code pCommandBuffers} array <b>must</b> be a protected command buffer.</li>
 * <li>If {@code protectedSubmit} is {@link VK10#VK_FALSE FALSE}, then each element of the {@code pCommandBuffers} array <b>must</b> be an unprotected command buffer.</li>
 * <li>If the {@link VkSubmitInfo}{@code ::pNext} chain does not include a {@link VkProtectedSubmitInfo} structure, then each element of the command buffer of the {@code pCommandBuffers} array <b>must</b> be an unprotected command buffer.</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_PROTECTED_SUBMIT_INFO STRUCTURE_TYPE_PROTECTED_SUBMIT_INFO}</li>
 * </ul>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code protectedSubmit} &ndash; specifies whether the batch is protected. If {@code protectedSubmit} is {@link VK10#VK_TRUE TRUE}, the batch is protected. If {@code protectedSubmit} is {@link VK10#VK_FALSE FALSE}, the batch is unprotected. If the {@link VkSubmitInfo}{@code ::pNext} chain does not contain this structure, the batch is unprotected.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkProtectedSubmitInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkBool32 protectedSubmit;
 * }</code></pre>
 */
class ProtectedSubmitInfo(
        var protectedSubmit: Boolean,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.PROTECTED_SUBMIT_INFO
}