package vkk._11.structs

import kool.Ptr
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.NULL
import vkk.VkStructureType

/**
 * Structure specifying, for a given subpass/input attachment pair, which aspect <b>can</b> be read.
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_RENDER_PASS_INPUT_ATTACHMENT_ASPECT_CREATE_INFO STRUCTURE_TYPE_RENDER_PASS_INPUT_ATTACHMENT_ASPECT_CREATE_INFO}</li>
 * <li>{@code pAspectReferences} <b>must</b> be a valid pointer to an array of {@code aspectReferenceCount} valid {@link VkInputAttachmentAspectReference} structures</li>
 * <li>{@code aspectReferenceCount} <b>must</b> be greater than 0</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkInputAttachmentAspectReference}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code aspectReferenceCount} &ndash; the number of elements in the {@code pAspectReferences} array.</li>
 * <li>{@code pAspectReferences} &ndash; points to an array of {@code aspectReferenceCount} number of {@link VkInputAttachmentAspectReference} structures describing which aspect(s) <b>can</b> be accessed for a given input attachment within a given subpass.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkRenderPassInputAttachmentAspectCreateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     uint32_t aspectReferenceCount;
 *     {@link VkInputAttachmentAspectReference VkInputAttachmentAspectReference} const * pAspectReferences;
 * }</code></pre>
 */
class RenderPassInputAttachmentAspectCreateInfo(
    var aspectReferences: Array<InputAttachmentAspectReference>,
    var next: Ptr = NULL
) {

    val type get() = VkStructureType.RENDER_PASS_INPUT_ATTACHMENT_ASPECT_CREATE_INFO
}