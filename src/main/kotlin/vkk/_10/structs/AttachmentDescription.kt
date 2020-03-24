package vkk._10.structs

import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VK10
import org.lwjgl.vulkan.VkAttachmentDescription.*
import org.lwjgl.vulkan.VkRenderPassCreateInfo
import vkk.*

/**
 * Structure specifying an attachment description.
 *
 * <h5>Description</h5>
 *
 *
 * If the attachment uses a color format, then `loadOp` and `storeOp` are used, and `stencilLoadOp` and `stencilStoreOp` are ignored. If the format has depth and/or stencil components, `loadOp` and `storeOp` apply only to the depth data, while `stencilLoadOp` and `stencilStoreOp` define how the stencil data is handled. `loadOp` and `stencilLoadOp` define the *load operations* that execute as part of the first subpass that uses the attachment. `storeOp` and `stencilStoreOp` define the *store operations* that execute as part of the last subpass that uses the attachment.
 *
 *
 * The load operation for each sample in an attachment happens-before any recorded command which accesses the sample in the first subpass where the attachment is used. Load operations for attachments with a depth/stencil format execute in the [PIPELINE_STAGE_EARLY_FRAGMENT_TESTS_BIT][VK10.VK_PIPELINE_STAGE_EARLY_FRAGMENT_TESTS_BIT] pipeline stage. Load operations for attachments with a color format execute in the [PIPELINE_STAGE_COLOR_ATTACHMENT_OUTPUT_BIT][VK10.VK_PIPELINE_STAGE_COLOR_ATTACHMENT_OUTPUT_BIT] pipeline stage.
 *
 *
 * The store operation for each sample in an attachment happens-after any recorded command which accesses the sample in the last subpass where the attachment is used. Store operations for attachments with a depth/stencil format execute in the [PIPELINE_STAGE_LATE_FRAGMENT_TESTS_BIT][VK10.VK_PIPELINE_STAGE_LATE_FRAGMENT_TESTS_BIT] pipeline stage. Store operations for attachments with a color format execute in the [PIPELINE_STAGE_COLOR_ATTACHMENT_OUTPUT_BIT][VK10.VK_PIPELINE_STAGE_COLOR_ATTACHMENT_OUTPUT_BIT] pipeline stage.
 *
 *
 * If an attachment is not used by any subpass, then `loadOp`, `storeOp`, `stencilStoreOp`, and `stencilLoadOp` are ignored, and the attachment's memory contents will not be modified by execution of a render pass instance.
 *
 *
 * The load and store operations apply on the first and last use of each view in the render pass, respectively. If a view index of an attachment is not included in the view mask in any subpass that uses it, then the load and store operations are ignored, and the attachment's memory contents will not be modified by execution of a render pass instance.
 *
 *
 * During a render pass instance, input/color attachments with color formats that have a component size of 8, 16, or 32 bits **must** be represented in the attachment's format throughout the instance. Attachments with other floating- or fixed-point color formats, or with depth components **may** be represented in a format with a precision higher than the attachment format, but **must** be represented with the same range. When such a component is loaded via the `loadOp`, it will be converted into an implementation-dependent format used by the render pass. Such components **must** be converted from the render pass format, to the format of the attachment, before they are resolved or stored at the end of a render pass instance via `storeOp`. Conversions occur as described in [Numeric Representation and Computation](https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#fundamentals-numerics) and [Fixed-Point Data Conversions](https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#fundamentals-fixedconv).
 *
 *
 * If `flags` includes [ATTACHMENT_DESCRIPTION_MAY_ALIAS_BIT][VK10.VK_ATTACHMENT_DESCRIPTION_MAY_ALIAS_BIT], then the attachment is treated as if it shares physical memory with another attachment in the same render pass. This information limits the ability of the implementation to reorder certain operations (like layout transitions and the `loadOp`) such that it is not improperly reordered against other uses of the same physical memory via a different attachment. This is described in more detail below.
 *
 * <h5>Valid Usage</h5>
 *
 *
 *  * `finalLayout` **must** not be [IMAGE_LAYOUT_UNDEFINED][VK10.VK_IMAGE_LAYOUT_UNDEFINED] or [IMAGE_LAYOUT_PREINITIALIZED][VK10.VK_IMAGE_LAYOUT_PREINITIALIZED]
 *
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 *
 *  * `flags` **must** be a valid combination of `VkAttachmentDescriptionFlagBits` values
 *  * `format` **must** be a valid `VkFormat` value
 *  * `samples` **must** be a valid `VkSampleCountFlagBits` value
 *  * `loadOp` **must** be a valid `VkAttachmentLoadOp` value
 *  * `storeOp` **must** be a valid `VkAttachmentStoreOp` value
 *  * `stencilLoadOp` **must** be a valid `VkAttachmentLoadOp` value
 *  * `stencilStoreOp` **must** be a valid `VkAttachmentStoreOp` value
 *  * `initialLayout` **must** be a valid `VkImageLayout` value
 *  * `finalLayout` **must** be a valid `VkImageLayout` value
 *
 *
 * <h5>See Also</h5>
 *
 *
 * [VkRenderPassCreateInfo]
 *
 * <h3>Member documentation</h3>
 *
 *
 *  * `flags`  a bitmask of `VkAttachmentDescriptionFlagBits` specifying additional properties of the attachment.
 *  * `format`  a `VkFormat` value specifying the format of the image view that will be used for the attachment.
 *  * `samples`  the number of samples of the image as defined in `VkSampleCountFlagBits`.
 *  * `loadOp`  a `VkAttachmentLoadOp` value specifying how the contents of color and depth components of the attachment are treated at the beginning of the subpass where it is first used.
 *  * `storeOp`  a `VkAttachmentStoreOp` value specifying how the contents of color and depth components of the attachment are treated at the end of the subpass where it is last used.
 *  * `stencilLoadOp`  a `VkAttachmentLoadOp` value specifying how the contents of stencil components of the attachment are treated at the beginning of the subpass where it is first used.
 *  * `stencilStoreOp`  a `VkAttachmentStoreOp` value specifying how the contents of stencil components of the attachment are treated at the end of the last subpass where it is used.
 *  * `initialLayout`  the layout the attachment image subresource will be in when a render pass instance begins.
 *  * `finalLayout`  the layout the attachment image subresource will be transitioned to when a render pass instance ends.
 *
 *
 * <h3>Layout</h3>
 *
 * <pre>`
 * struct VkAttachmentDescription {
 * VkAttachmentDescriptionFlags flags;
 * VkFormat format;
 * VkSampleCountFlagBits samples;
 * VkAttachmentLoadOp loadOp;
 * VkAttachmentStoreOp storeOp;
 * VkAttachmentLoadOp stencilLoadOp;
 * VkAttachmentStoreOp stencilStoreOp;
 * VkImageLayout initialLayout;
 * VkImageLayout finalLayout;
 * }`</pre>
 */
class AttachmentDescription(
        var flags: VkAttachmentDescriptionFlags = 0,
        var format: VkFormat,
        var samples: VkSampleCount,
        var loadOp: VkAttachmentLoadOp,
        var storeOp: VkAttachmentStoreOp,
        var stencilLoadOp: VkAttachmentLoadOp,
        var stencilStoreOp: VkAttachmentStoreOp,
        var initialLayout: VkImageLayout,
        var finalLayout: VkImageLayout
) {

    infix fun write(stack: VkStack): Adr =
            stack.ncalloc(ALIGNOF, 1, SIZEOF).also { write(it) }

    infix fun write(ptr: Ptr) {
        nflags(ptr, flags)
        nformat(ptr, format.i)
        nsamples(ptr, samples.i)
        nloadOp(ptr, loadOp.i)
        nstoreOp(ptr, storeOp.i)
        nstencilLoadOp(ptr, stencilLoadOp.i)
        nstencilStoreOp(ptr, stencilStoreOp.i)
        ninitialLayout(ptr, initialLayout.i)
        nfinalLayout(ptr, finalLayout.i)
    }
}

infix fun Array<AttachmentDescription>.write(stack: VkStack): Ptr {
    val natives = stack.ncalloc(ALIGNOF, size, SIZEOF)
    for (i in indices)
        this[i] write (natives + i * SIZEOF)
    return natives
}