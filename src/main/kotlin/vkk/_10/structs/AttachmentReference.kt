package vkk._10.structs

import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VK10
import org.lwjgl.vulkan.VkAttachmentReference.*
import org.lwjgl.vulkan.VkRenderPassCreateInfo
import org.lwjgl.vulkan.VkRenderPassFragmentDensityMapCreateInfoEXT
import org.lwjgl.vulkan.VkSubpassDescription
import vkk.VkImageLayout
import vkk.VkStack

/**
 * Structure specifying an attachment reference.
 *
 * <h5>Valid Usage</h5>
 *
 *
 *  * If `attachment` is not [ATTACHMENT_UNUSED][VK10.VK_ATTACHMENT_UNUSED], `layout` **must** not be [IMAGE_LAYOUT_UNDEFINED][VK10.VK_IMAGE_LAYOUT_UNDEFINED] or [IMAGE_LAYOUT_PREINITIALIZED][VK10.VK_IMAGE_LAYOUT_PREINITIALIZED]
 *
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 *
 *  * `layout` **must** be a valid `VkImageLayout` value
 *
 *
 * <h5>See Also</h5>
 *
 *
 * [VkRenderPassFragmentDensityMapCreateInfoEXT], [VkSubpassDescription]
 *
 * <h3>Member documentation</h3>
 *
 *
 *  * `attachment`  either an integer value identifying an attachment at the corresponding index in [VkRenderPassCreateInfo]`::pAttachments`, or [ATTACHMENT_UNUSED][VK10.VK_ATTACHMENT_UNUSED] to signify that this attachment is not used.
 *  * `layout`  a `VkImageLayout` value specifying the layout the attachment uses during the subpass.
 *
 *
 * <h3>Layout</h3>
 *
 * <pre>`
 * struct VkAttachmentReference {
 * uint32_t attachment;
 * VkImageLayout layout;
 * }`</pre>
 */
class AttachmentReference(
        var attachment: Int,
        var layout: VkImageLayout
) {

    infix fun write(stack: VkStack): Ptr =
            stack.ncalloc(ALIGNOF, 1, SIZEOF).also { write(it) }

    infix fun write(ptr: Ptr) {
        nattachment(ptr, attachment)
        nlayout(ptr, layout.i)
    }
}

infix fun Array<AttachmentReference>.write(stack: VkStack): Ptr {
    val natives = stack.ncalloc(ALIGNOF, size, SIZEOF)
    for (i in indices)
        this[i] write (natives + i * SIZEOF)
    return natives
}