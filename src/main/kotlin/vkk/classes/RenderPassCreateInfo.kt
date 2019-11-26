package classes

import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.system.MemoryUtil.memPutAddress
import org.lwjgl.vulkan.VkRenderPassCreateInfo.*
import vkk.VkRenderPassCreateFlags
import vkk.VkStructureType


/**
 * Structure specifying parameters of a newly created render pass.
 *
 * <h5>Description</h5>
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>Care should be taken to avoid a data race here; if any subpasses access attachments with overlapping memory locations, and one of those accesses is a write, a subpass dependency needs to be included between them.</p>
 * </div>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>If the {@code attachment} member of any element of {@code pInputAttachments}, {@code pColorAttachments}, {@code pResolveAttachments} or {@code pDepthStencilAttachment}, or any element of {@code pPreserveAttachments} in any element of {@code pSubpasses} is not {@link VK10#VK_ATTACHMENT_UNUSED ATTACHMENT_UNUSED}, it <b>must</b> be less than {@code attachmentCount}</li>
 * <li>For any member of {@code pAttachments} with a {@code loadOp} equal to {@link VK10#VK_ATTACHMENT_LOAD_OP_CLEAR ATTACHMENT_LOAD_OP_CLEAR}, the first use of that attachment <b>must</b> not specify a {@code layout} equal to {@link VK10#VK_IMAGE_LAYOUT_SHADER_READ_ONLY_OPTIMAL IMAGE_LAYOUT_SHADER_READ_ONLY_OPTIMAL} or {@link VK10#VK_IMAGE_LAYOUT_DEPTH_STENCIL_READ_ONLY_OPTIMAL IMAGE_LAYOUT_DEPTH_STENCIL_READ_ONLY_OPTIMAL}.</li>
 * <li>For any member of {@code pAttachments} with a {@code stencilLoadOp} equal to {@link VK10#VK_ATTACHMENT_LOAD_OP_CLEAR ATTACHMENT_LOAD_OP_CLEAR}, the first use of that attachment <b>must</b> not specify a {@code layout} equal to {@link VK10#VK_IMAGE_LAYOUT_SHADER_READ_ONLY_OPTIMAL IMAGE_LAYOUT_SHADER_READ_ONLY_OPTIMAL} or {@link VK10#VK_IMAGE_LAYOUT_DEPTH_STENCIL_READ_ONLY_OPTIMAL IMAGE_LAYOUT_DEPTH_STENCIL_READ_ONLY_OPTIMAL}.</li>
 * <li>For any member of {@code pAttachments} with a {@code loadOp} equal to {@link VK10#VK_ATTACHMENT_LOAD_OP_CLEAR ATTACHMENT_LOAD_OP_CLEAR}, the first use of that attachment <b>must</b> not specify a {@code layout} equal to {@link VK11#VK_IMAGE_LAYOUT_DEPTH_READ_ONLY_STENCIL_ATTACHMENT_OPTIMAL IMAGE_LAYOUT_DEPTH_READ_ONLY_STENCIL_ATTACHMENT_OPTIMAL}.</li>
 * <li>For any member of {@code pAttachments} with a {@code stencilLoadOp} equal to {@link VK10#VK_ATTACHMENT_LOAD_OP_CLEAR ATTACHMENT_LOAD_OP_CLEAR}, the first use of that attachment <b>must</b> not specify a {@code layout} equal to {@link VK11#VK_IMAGE_LAYOUT_DEPTH_ATTACHMENT_STENCIL_READ_ONLY_OPTIMAL IMAGE_LAYOUT_DEPTH_ATTACHMENT_STENCIL_READ_ONLY_OPTIMAL}.</li>
 * <li>If the {@code pNext} chain includes an instance of {@link VkRenderPassInputAttachmentAspectCreateInfo}, the {@code subpass} member of each element of its {@code pAspectReferences} member <b>must</b> be less than {@code subpassCount}</li>
 * <li>If the {@code pNext} chain includes an instance of {@link VkRenderPassInputAttachmentAspectCreateInfo}, the {@code inputAttachmentIndex} member of each element of its {@code pAspectReferences} member <b>must</b> be less than the value of {@code inputAttachmentCount} in the member of {@code pSubpasses} identified by its {@code subpass} member</li>
 * <li>If the {@code pNext} chain includes an instance of {@link VkRenderPassInputAttachmentAspectCreateInfo}, for any element of the {@code pInputAttachments} member of any element of {@code pSubpasses} where the {@code attachment} member is not {@link VK10#VK_ATTACHMENT_UNUSED ATTACHMENT_UNUSED}, the {@code aspectMask} member of the corresponding element of {@link VkRenderPassInputAttachmentAspectCreateInfo}{@code ::pAspectReferences} <b>must</b> only include aspects that are present in images of the format specified by the element of {@code pAttachments} at {@code attachment}</li>
 * <li>If the {@code pNext} chain includes an instance of {@link VkRenderPassMultiviewCreateInfo}, and its {@code subpassCount} member is not zero, that member <b>must</b> be equal to the value of {@code subpassCount}</li>
 * <li>If the {@code pNext} chain includes an instance of {@link VkRenderPassMultiviewCreateInfo}, if its {@code dependencyCount} member is not zero, it <b>must</b> be equal to {@code dependencyCount}</li>
 * <li>If the {@code pNext} chain includes an instance of {@link VkRenderPassMultiviewCreateInfo}, for each non-zero element of {@code pViewOffsets}, the {@code srcSubpass} and {@code dstSubpass} members of {@code pDependencies} at the same index <b>must</b> not be equal</li>
 * <li>If the {@code pNext} chain includes an instance of {@link VkRenderPassMultiviewCreateInfo}, for any element of {@code pDependencies} with a {@code dependencyFlags} member that does not include {@link VK11#VK_DEPENDENCY_VIEW_LOCAL_BIT DEPENDENCY_VIEW_LOCAL_BIT}, the corresponding element of the {@code pViewOffsets} member of that {@link VkRenderPassMultiviewCreateInfo} instance <b>must</b> be 0</li>
 * <li>If the {@code pNext} chain includes an instance of {@link VkRenderPassMultiviewCreateInfo}, elements of its {@code pViewMasks} member <b>must</b> either all be 0, or all not be 0</li>
 * <li>If the {@code pNext} chain includes an instance of {@link VkRenderPassMultiviewCreateInfo}, and each element of its {@code pViewMasks} member is 0, the {@code dependencyFlags} member of each element of {@code pDependencies} <b>must</b> not include {@link VK11#VK_DEPENDENCY_VIEW_LOCAL_BIT DEPENDENCY_VIEW_LOCAL_BIT}</li>
 * <li>If the {@code pNext} chain includes an instance of {@link VkRenderPassMultiviewCreateInfo}, and each element of its {@code pViewMasks} member is 0, {@code correlatedViewMaskCount} <b>must</b> be 0</li>
 * <li>If the {@code pNext} chain includes an instance of {@link VkRenderPassMultiviewCreateInfo}, each element of its {@code pViewMask} member <b>must</b> not have a bit set at an index greater than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxFramebufferLayers}</li>
 * <li>For any element of {@code pDependencies}, if the {@code srcSubpass} is not {@link VK10#VK_SUBPASS_EXTERNAL SUBPASS_EXTERNAL}, all stage flags included in the {@code srcStageMask} member of that dependency <b>must</b> be a pipeline stage supported by the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-pipeline-stages-types">pipeline</a> identified by the {@code pipelineBindPoint} member of the source subpass</li>
 * <li>For any element of {@code pDependencies}, if the {@code dstSubpass} is not {@link VK10#VK_SUBPASS_EXTERNAL SUBPASS_EXTERNAL}, all stage flags included in the {@code dstStageMask} member of that dependency <b>must</b> be a pipeline stage supported by the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-pipeline-stages-types">pipeline</a> identified by the {@code pipelineBindPoint} member of the destination subpass</li>
 * <li>The {@code srcSubpass} member of each element of {@code pDependencies} <b>must</b> be less than {@code subpassCount}</li>
 * <li>The {@code dstSubpass} member of each element of {@code pDependencies} <b>must</b> be less than {@code subpassCount}</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK10#VK_STRUCTURE_TYPE_RENDER_PASS_CREATE_INFO STRUCTURE_TYPE_RENDER_PASS_CREATE_INFO}</li>
 * <li>Each {@code pNext} member of any structure (including this one) in the {@code pNext} chain <b>must</b> be either {@code NULL} or a pointer to a valid instance of {@link VkRenderPassFragmentDensityMapCreateInfoEXT}, {@link VkRenderPassInputAttachmentAspectCreateInfo}, or {@link VkRenderPassMultiviewCreateInfo}</li>
 * <li>Each {@code sType} member in the {@code pNext} chain <b>must</b> be unique</li>
 * <li>If {@code attachmentCount} is not 0, {@code pAttachments} <b>must</b> be a valid pointer to an array of {@code attachmentCount} valid {@link VkAttachmentDescription} structures</li>
 * <li>{@code pSubpasses} <b>must</b> be a valid pointer to an array of {@code subpassCount} valid {@link VkSubpassDescription} structures</li>
 * <li>If {@code dependencyCount} is not 0, {@code pDependencies} <b>must</b> be a valid pointer to an array of {@code dependencyCount} valid {@link VkSubpassDependency} structures</li>
 * <li>{@code subpassCount} <b>must</b> be greater than 0</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkAttachmentDescription}, {@link VkSubpassDependency}, {@link VkSubpassDescription}, {@link VK10#vkCreateRenderPass CreateRenderPass}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code flags} &ndash; reserved for future use.</li>
 * <li>{@code attachmentCount} &ndash; the number of attachments used by this render pass.</li>
 * <li>{@code pAttachments} &ndash; points to an array of {@code attachmentCount} {@link VkAttachmentDescription} structures describing the attachments used by the render pass.</li>
 * <li>{@code subpassCount} &ndash; the number of subpasses to create.</li>
 * <li>{@code pSubpasses} &ndash; points to an array of {@code subpassCount} {@link VkSubpassDescription} structures describing each subpass.</li>
 * <li>{@code dependencyCount} &ndash; the number of memory dependencies between pairs of subpasses.</li>
 * <li>{@code pDependencies} &ndash; points to an array of {@code dependencyCount} {@link VkSubpassDependency} structures describing dependencies between pairs of subpasses.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkRenderPassCreateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkRenderPassCreateFlags flags;
 *     uint32_t attachmentCount;
 *     {@link VkAttachmentDescription VkAttachmentDescription} const * pAttachments;
 *     uint32_t subpassCount;
 *     {@link VkSubpassDescription VkSubpassDescription} const * pSubpasses;
 *     uint32_t dependencyCount;
 *     {@link VkSubpassDependency VkSubpassDependency} const * pDependencies;
 * }</code></pre>
 */
class RenderPassCreateInfo(
    var flags: VkRenderPassCreateFlags = 0,
    var attachments: Array<AttachmentDescription>? = null,
    var subpasses: Array<SubpassDescription>,
    var dependencies: Array<SubpassDependency>? = null
) {

    constructor(
        flags: VkRenderPassCreateFlags = 0,
        attachment: AttachmentDescription? = null,
        subpass: SubpassDescription,
        dependency: SubpassDependency? = null
    ) : this(flags, attachment?.let { arrayOf(it) }, arrayOf(subpass), dependency?.let { arrayOf(it) })

    val type get() = VkStructureType.RENDER_PASS_CREATE_INFO

    val MemoryStack.native: Ptr
        get() = ncalloc(ALIGNOF, 1, SIZEOF).also { toPtr(it) }

    infix fun MemoryStack.toPtr(ptr: Ptr) {
        nsType(ptr, type.i)
        nflags(ptr, flags)
        nattachmentCount(ptr, attachments?.size ?: 0)
        memPutAddress(ptr + PATTACHMENTS, attachments?.run { write(this@toPtr) } ?: NULL)
        nsubpassCount(ptr, subpasses.size)
        memPutAddress(ptr + PSUBPASSES, subpasses.run { write(this@toPtr) })
        ndependencyCount(ptr, dependencies?.size ?: 0)
        memPutAddress(ptr + PDEPENDENCIES, dependencies?.run { write(this@toPtr) } ?: NULL)
    }
}