package vkk.vk10.structs

import kool.*
import org.lwjgl.system.MemoryUtil.memPutAddress
import org.lwjgl.vulkan.*
import org.lwjgl.vulkan.VkSubpassDescription.*
import vkk.VkPipelineBindPoint
import vkk.VkStack
import vkk.VkSubpassDescriptionFlags

/**
 * Structure specifying a subpass description.
 *
 * <h5>Description</h5>
 *
 *
 * Each element of the `pInputAttachments` array corresponds to an input attachment index in a fragment shader, i.e. if a shader declares an image variable decorated with a `InputAttachmentIndex` value of **X**, then it uses the attachment provided in `pInputAttachments`[**X**]. Input attachments **must** also be bound to the pipeline in a descriptor set. If the `attachment` member of any element of `pInputAttachments` is [ATTACHMENT_UNUSED][VK10.VK_ATTACHMENT_UNUSED], the application **must** not read from the corresponding input attachment index. Fragment shaders **can** use subpass input variables to access the contents of an input attachment at the fragment's (x, y, layer) framebuffer coordinates.
 *
 *
 * Each element of the `pColorAttachments` array corresponds to an output location in the shader, i.e. if the shader declares an output variable decorated with a `Location` value of **X**, then it uses the attachment provided in `pColorAttachments`[**X**]. If the `attachment` member of any element of `pColorAttachments` is [ATTACHMENT_UNUSED][VK10.VK_ATTACHMENT_UNUSED], writes to the corresponding location by a fragment are discarded.
 *
 *
 * If `pResolveAttachments` is not `NULL`, each of its elements corresponds to a color attachment (the element in `pColorAttachments` at the same index), and a multisample resolve operation is defined for each attachment. At the end of each subpass, multisample resolve operations read the subpass's color attachments, and resolve the samples for each pixel to the same pixel location in the corresponding resolve attachments, unless the resolve attachment index is [ATTACHMENT_UNUSED][VK10.VK_ATTACHMENT_UNUSED].
 *
 *
 * Similarly, if [VkSubpassDescriptionDepthStencilResolveKHR]`::pDepthStencilResolveAttachment` is not `NULL` and does not have the value [ATTACHMENT_UNUSED][VK10.VK_ATTACHMENT_UNUSED], it corresponds to the depth/stencil attachment in `pDepthStencilAttachment`, and multisample resolve operations for depth and stencil are defined by [VkSubpassDescriptionDepthStencilResolveKHR]`::depthResolveMode` and [VkSubpassDescriptionDepthStencilResolveKHR]`::stencilResolveMode`, respectively. At the end of each subpass, multisample resolve operations read the subpass's depth/stencil attachment, and resolve the samples for each pixel to the same pixel location in the corresponding resolve attachment. If [VkSubpassDescriptionDepthStencilResolveKHR]`::depthResolveMode` is [RESOLVE_MODE_NONE_KHR][KHRDepthStencilResolve.VK_RESOLVE_MODE_NONE_KHR], then the depth component of the resolve attachment is not written to and its contents are preserved. Similarly, if [VkSubpassDescriptionDepthStencilResolveKHR]`::stencilResolveMode` is [RESOLVE_MODE_NONE_KHR][KHRDepthStencilResolve.VK_RESOLVE_MODE_NONE_KHR], then the stencil component of the resolve attachment is not written to and its contents are preserved. [VkSubpassDescriptionDepthStencilResolveKHR]`::depthResolveMode` is ignored if the `VkFormat` of the `pDepthStencilResolveAttachment` does not have a depth component. Similarly, [VkSubpassDescriptionDepthStencilResolveKHR]`::stencilResolveMode` is ignored if the `VkFormat` of the `pDepthStencilResolveAttachment` does not have a stencil component.
 *
 *
 * If the image subresource range referenced by the depth/stencil attachment is created with [IMAGE_CREATE_SAMPLE_LOCATIONS_COMPATIBLE_DEPTH_BIT_EXT][EXTSampleLocations.VK_IMAGE_CREATE_SAMPLE_LOCATIONS_COMPATIBLE_DEPTH_BIT_EXT], then the multisample resolve operation uses the sample locations state specified in the `sampleLocationsInfo` member of the element of the [VkRenderPassSampleLocationsBeginInfoEXT]`::pPostSubpassSampleLocations` for the subpass.
 *
 *
 * If `pDepthStencilAttachment` is `NULL`, or if its attachment index is [ATTACHMENT_UNUSED][VK10.VK_ATTACHMENT_UNUSED], it indicates that no depth/stencil attachment will be used in the subpass.
 *
 *
 * The contents of an attachment within the render area become undefined at the start of a subpass **S** if all of the following conditions are true:
 *
 *
 *  * The attachment is used as a color, depth/stencil, or resolve attachment in any subpass in the render pass.
 *  * There is a subpass **S<sub>1</sub>** that uses or preserves the attachment, and a subpass dependency from **S<sub>1</sub>** to **S**.
 *  * The attachment is not used or preserved in subpass **S**.
 *
 *
 *
 * Once the contents of an attachment become undefined in subpass **S**, they remain undefined for subpasses in subpass dependency chains starting with subpass **S** until they are written again. However, they remain valid for subpasses in other subpass dependency chains starting with subpass **S<sub>1</sub>** if those subpasses use or preserve the attachment.
 *
 * <h5>Valid Usage</h5>
 *
 *
 *  * `pipelineBindPoint` **must** be [PIPELINE_BIND_POINT_GRAPHICS][VK10.VK_PIPELINE_BIND_POINT_GRAPHICS]
 *  * `colorAttachmentCount` **must** be less than or equal to [VkPhysicalDeviceLimits]`::maxColorAttachments`
 *  * If the first use of an attachment in this render pass is as an input attachment, and the attachment is not also used as a color or depth/stencil attachment in the same subpass, then `loadOp` **must** not be [ATTACHMENT_LOAD_OP_CLEAR][VK10.VK_ATTACHMENT_LOAD_OP_CLEAR]
 *  * If `pResolveAttachments` is not `NULL`, for each resolve attachment that is not [ATTACHMENT_UNUSED][VK10.VK_ATTACHMENT_UNUSED], the corresponding color attachment **must** not be [ATTACHMENT_UNUSED][VK10.VK_ATTACHMENT_UNUSED]
 *  * If `pResolveAttachments` is not `NULL`, for each resolve attachment that is not [ATTACHMENT_UNUSED][VK10.VK_ATTACHMENT_UNUSED], the corresponding color attachment **must** not have a sample count of [SAMPLE_COUNT_1_BIT][VK10.VK_SAMPLE_COUNT_1_BIT]
 *  * If `pResolveAttachments` is not `NULL`, each resolve attachment that is not [ATTACHMENT_UNUSED][VK10.VK_ATTACHMENT_UNUSED] **must** have a sample count of [SAMPLE_COUNT_1_BIT][VK10.VK_SAMPLE_COUNT_1_BIT]
 *  * If `pResolveAttachments` is not `NULL`, each resolve attachment that is not [ATTACHMENT_UNUSED][VK10.VK_ATTACHMENT_UNUSED] **must** have the same `VkFormat` as its corresponding color attachment
 *  * All attachments in `pColorAttachments` that are not [ATTACHMENT_UNUSED][VK10.VK_ATTACHMENT_UNUSED] **must** have the same sample count
 *  * All attachments in `pInputAttachments` that are not [ATTACHMENT_UNUSED][VK10.VK_ATTACHMENT_UNUSED] **must** have formats whose features contain at least one of [FORMAT_FEATURE_COLOR_ATTACHMENT_BIT][VK10.VK_FORMAT_FEATURE_COLOR_ATTACHMENT_BIT] or [FORMAT_FEATURE_DEPTH_STENCIL_ATTACHMENT_BIT][VK10.VK_FORMAT_FEATURE_DEPTH_STENCIL_ATTACHMENT_BIT].
 *  * All attachments in `pColorAttachments` that are not [ATTACHMENT_UNUSED][VK10.VK_ATTACHMENT_UNUSED] **must** have formats whose features contain [FORMAT_FEATURE_COLOR_ATTACHMENT_BIT][VK10.VK_FORMAT_FEATURE_COLOR_ATTACHMENT_BIT]
 *  * All attachments in `pResolveAttachments` that are not [ATTACHMENT_UNUSED][VK10.VK_ATTACHMENT_UNUSED] **must** have formats whose features contain [FORMAT_FEATURE_COLOR_ATTACHMENT_BIT][VK10.VK_FORMAT_FEATURE_COLOR_ATTACHMENT_BIT]
 *  * If `pDepthStencilAttachment` is not `NULL` and the attachment is not [ATTACHMENT_UNUSED][VK10.VK_ATTACHMENT_UNUSED] then it **must** have a format whose features contain [FORMAT_FEATURE_DEPTH_STENCIL_ATTACHMENT_BIT][VK10.VK_FORMAT_FEATURE_DEPTH_STENCIL_ATTACHMENT_BIT]
 *  * If the `VK_AMD_mixed_attachment_samples` extension is enabled, and all attachments in `pColorAttachments` that are not [ATTACHMENT_UNUSED][VK10.VK_ATTACHMENT_UNUSED] **must** have a sample count that is smaller than or equal to the sample count of `pDepthStencilAttachment` if it is not [ATTACHMENT_UNUSED][VK10.VK_ATTACHMENT_UNUSED]
 *  * If neither the `VK_AMD_mixed_attachment_samples` nor the `VK_NV_framebuffer_mixed_samples` extensions are enabled, and if `pDepthStencilAttachment` is not [ATTACHMENT_UNUSED][VK10.VK_ATTACHMENT_UNUSED] and any attachments in `pColorAttachments` are not [ATTACHMENT_UNUSED][VK10.VK_ATTACHMENT_UNUSED], they **must** have the same sample count
 *  * The `attachment` member of each element of `pPreserveAttachments` **must** not be [ATTACHMENT_UNUSED][VK10.VK_ATTACHMENT_UNUSED]
 *  * Each element of `pPreserveAttachments` **must** not also be an element of any other member of the subpass description
 *  * If any attachment is used by more than one [VkAttachmentReference] member, then each use **must** use the same `layout`
 *  * If `flags` includes [SUBPASS_DESCRIPTION_PER_VIEW_POSITION_X_ONLY_BIT_NVX][NVXMultiviewPerViewAttributes.VK_SUBPASS_DESCRIPTION_PER_VIEW_POSITION_X_ONLY_BIT_NVX], it **must** also include [SUBPASS_DESCRIPTION_PER_VIEW_ATTRIBUTES_BIT_NVX][NVXMultiviewPerViewAttributes.VK_SUBPASS_DESCRIPTION_PER_VIEW_ATTRIBUTES_BIT_NVX].
 *
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 *
 *  * `flags` **must** be a valid combination of `VkSubpassDescriptionFlagBits` values
 *  * `pipelineBindPoint` **must** be a valid `VkPipelineBindPoint` value
 *  * If `inputAttachmentCount` is not 0, `pInputAttachments` **must** be a valid pointer to an array of `inputAttachmentCount` valid [VkAttachmentReference] structures
 *  * If `colorAttachmentCount` is not 0, `pColorAttachments` **must** be a valid pointer to an array of `colorAttachmentCount` valid [VkAttachmentReference] structures
 *  * If `colorAttachmentCount` is not 0, and `pResolveAttachments` is not `NULL`, `pResolveAttachments` **must** be a valid pointer to an array of `colorAttachmentCount` valid [VkAttachmentReference] structures
 *  * If `pDepthStencilAttachment` is not `NULL`, `pDepthStencilAttachment` **must** be a valid pointer to a valid [VkAttachmentReference] structure
 *  * If `preserveAttachmentCount` is not 0, `pPreserveAttachments` **must** be a valid pointer to an array of `preserveAttachmentCount` `uint32_t` values
 *
 *
 * <h5>See Also</h5>
 *
 *
 * [VkAttachmentReference], [VkRenderPassCreateInfo]
 *
 * <h3>Member documentation</h3>
 *
 *
 *  * `flags`  a bitmask of `VkSubpassDescriptionFlagBits` specifying usage of the subpass.
 *  * `pipelineBindPoint`  a `VkPipelineBindPoint` value specifying the pipeline type supported for this subpass.
 *  * `inputAttachmentCount`  the number of input attachments.
 *  * `pInputAttachments`  an array of [VkAttachmentReference] structures defining the input attachments for this subpass and their layouts.
 *  * `colorAttachmentCount`  the number of color attachments.
 *  * `pColorAttachments`  an array of [VkAttachmentReference] structures defining the color attachments for this subpass and their layouts.
 *  * `pResolveAttachments`  an optional array of `colorAttachmentCount` [VkAttachmentReference] structures defining the resolve attachments for this subpass and their layouts.
 *  * `pDepthStencilAttachment`  a pointer to a [VkAttachmentReference] specifying the depth/stencil attachment for this subpass and its layout.
 *  * `preserveAttachmentCount`  the number of preserved attachments.
 *  * `pPreserveAttachments`  an array of `preserveAttachmentCount` render pass attachment indices identifying attachments that are not used by this subpass, but whose contents **must** be preserved throughout the subpass.
 *
 *
 * <h3>Layout</h3>
 *
 * <pre>`
 * struct VkSubpassDescription {
 * VkSubpassDescriptionFlags flags;
 * VkPipelineBindPoint pipelineBindPoint;
 * uint32_t inputAttachmentCount;
 * [VkAttachmentReference] const * pInputAttachments;
 * uint32_t colorAttachmentCount;
 * [VkAttachmentReference] const * pColorAttachments;
 * [VkAttachmentReference] const * pResolveAttachments;
 * [VkAttachmentReference] const * pDepthStencilAttachment;
 * uint32_t preserveAttachmentCount;
 * uint32_t const * pPreserveAttachments;
 * }`</pre>
 */
class SubpassDescription(
    var flags: VkSubpassDescriptionFlags = 0,
    var pipelineBindPoint: VkPipelineBindPoint,
    var inputAttachments: Array<AttachmentReference>? = null,
    var colorAttachments: Array<AttachmentReference>? = null,
    var resolveAttachments: Array<AttachmentReference>? = null,
    var depthStencilAttachment: AttachmentReference? = null,
    var preserveAttachments: IntArray? = null,
    colorAttachment: AttachmentReference? = null
) {

    init {
        colorAttachment?.let { colorAttachments = arrayOf(it) }
    }

//    var inputAttachment: AttachmentReference
//        get() = inputAttachments!![0]
//        set(value) {
//            inputAttachments = arrayOf(value)
//        }
//
//    var colorAttachment: AttachmentReference
//        get() = colorAttachments!![0]
//        set(value) {
//            colorAttachments = arrayOf(value)
//        }
//
//    var resolveAttachment: AttachmentReference
//        get() = resolveAttachments!![0]
//        set(value) {
//            resolveAttachments = arrayOf(value)
//        }

    fun write(stack: VkStack): Adr =
        stack.ncalloc(ALIGNOF, 1, SIZEOF).also { write(it, stack) }

    fun write(ptr: Ptr, stack: VkStack) {
        nflags(ptr, flags)
        npipelineBindPoint(ptr, pipelineBindPoint.i)
        inputAttachments?.let {
            ninputAttachmentCount(ptr, it.size)
            memPutAddress(ptr + PINPUTATTACHMENTS, it write stack)
        }
        colorAttachments?.let {
            ncolorAttachmentCount(ptr, it.size)
            memPutAddress(ptr + PCOLORATTACHMENTS, it write stack)
        }
        resolveAttachments?.let { memPutAddress(ptr + PRESOLVEATTACHMENTS, it write stack) }
        depthStencilAttachment?.let { memPutAddress(ptr + PDEPTHSTENCILATTACHMENT, it write stack) }
        preserveAttachments?.let {
            npreserveAttachmentCount(ptr, it.size)
            memPutAddress(ptr + PPRESERVEATTACHMENTS, stack.Adr(it).adr)
        }
    }
}

infix fun Array<SubpassDescription>.write(stack: VkStack): Ptr {
    val natives = stack.ncalloc(ALIGNOF, size, SIZEOF)
    for (i in indices)
        this[i].write(natives + i * SIZEOF, stack)
    return natives
}