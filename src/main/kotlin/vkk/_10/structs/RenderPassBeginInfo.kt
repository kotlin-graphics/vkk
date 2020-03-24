package vkk._10.structs

import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.system.MemoryUtil.memPutAddress
import org.lwjgl.vulkan.VkRenderPassBeginInfo.*
import vkk.VkStack
import vkk.VkStructureType
import vkk.entities.VkFramebuffer
import vkk.entities.VkRenderPass

/**
 * Structure specifying render pass begin info.
 *
 * <h5>Description</h5>
 *
 * <p>{@code renderArea} is the render area that is affected by the render pass instance. The effects of attachment load, store and multisample resolve operations are restricted to the pixels whose x and y coordinates fall within the render area on all attachments. The render area extends to all layers of {@code framebuffer}. The application <b>must</b> ensure (using scissor if necessary) that all rendering is contained within the render area. The render area <b>must</b> be contained within the framebuffer dimensions.</p>
 *
 * <p>When multiview is enabled, the resolve operation at the end of a subpass applies to all views in the view mask.</p>
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>There <b>may</b> be a performance cost for using a render area smaller than the framebuffer, unless it matches the render area granularity for the render pass.</p>
 * </div>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code clearValueCount} <b>must</b> be greater than the largest attachment index in {@code renderPass} that specifies a {@code loadOp} (or {@code stencilLoadOp}, if the attachment has a depth/stencil format) of {@link VK10#VK_ATTACHMENT_LOAD_OP_CLEAR ATTACHMENT_LOAD_OP_CLEAR}</li>
 * <li>{@code renderPass} <b>must</b> be <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#renderpass-compatibility">compatible</a> with the {@code renderPass} member of the {@link VkFramebufferCreateInfo} structure specified when creating {@code framebuffer}.</li>
 * <li>If {@code framebuffer} was created with a {@link VkFramebufferCreateInfo}{@code ::flags} value that did not include {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, and the {@code pNext} chain includes an instance of {@link VkRenderPassAttachmentBeginInfoKHR}, its {@code attachmentCount} <b>must</b> be zero</li>
 * <li>If {@code framebuffer} was created with a {@link VkFramebufferCreateInfo}{@code ::flags} value that included {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, the {@code attachmentCount} of an instance of {@link VkRenderPassAttachmentBeginInfoKHR} included in the {@code pNext} chain <b>must</b> be equal to the value of {@link VkFramebufferAttachmentsCreateInfoKHR}{@code ::attachmentImageInfoCount} used to create {@code framebuffer}</li>
 * <li>If {@code framebuffer} was created with a {@link VkFramebufferCreateInfo}{@code ::flags} value that included {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, each element of the {@code pAttachments} member of an instance of {@link VkRenderPassAttachmentBeginInfoKHR} included in the {@code pNext} chain <b>must</b> have been created on the same {@code VkDevice} as {@code framebuffer} and {@code renderPass}</li>
 * <li>If {@code framebuffer} was created with a {@link VkFramebufferCreateInfo}{@code ::flags} value that included {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, each element of the {@code pAttachments} member of an instance of {@link VkRenderPassAttachmentBeginInfoKHR} included in the {@code pNext} chain <b>must</b> be a {@code VkImageView} of an image created with a value of {@link VkImageCreateInfo}{@code ::flags} equal to the {@code flags} member of the corresponding element of {@link VkFramebufferAttachmentsCreateInfoKHR}{@code ::pAttachments} used to create {@code framebuffer}</li>
 * <li>If {@code framebuffer} was created with a {@link VkFramebufferCreateInfo}{@code ::flags} value that included {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, each element of the {@code pAttachments} member of an instance of {@link VkRenderPassAttachmentBeginInfoKHR} included in the {@code pNext} chain <b>must</b> be a {@code VkImageView} of an image created with a value of {@link VkImageCreateInfo}{@code ::usage} equal to the {@code usage} member of the corresponding element of {@link VkFramebufferAttachmentsCreateInfoKHR}{@code ::pAttachments} used to create {@code framebuffer}</li>
 * <li>If {@code framebuffer} was created with a {@link VkFramebufferCreateInfo}{@code ::flags} value that included {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, each element of the {@code pAttachments} member of an instance of {@link VkRenderPassAttachmentBeginInfoKHR} included in the {@code pNext} chain <b>must</b> be a {@code VkImageView} with a width equal to the {@code width} member of the corresponding element of {@link VkFramebufferAttachmentsCreateInfoKHR}{@code ::pAttachments} used to create {@code framebuffer}</li>
 * <li>If {@code framebuffer} was created with a {@link VkFramebufferCreateInfo}{@code ::flags} value that included {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, each element of the {@code pAttachments} member of an instance of {@link VkRenderPassAttachmentBeginInfoKHR} included in the {@code pNext} chain <b>must</b> be a {@code VkImageView} with a height equal to the {@code height} member of the corresponding element of {@link VkFramebufferAttachmentsCreateInfoKHR}{@code ::pAttachments} used to create {@code framebuffer}</li>
 * <li>If {@code framebuffer} was created with a {@link VkFramebufferCreateInfo}{@code ::flags} value that included {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, each element of the {@code pAttachments} member of an instance of {@link VkRenderPassAttachmentBeginInfoKHR} included in the {@code pNext} chain <b>must</b> be a {@code VkImageView} of an image created with a value of {@link VkImageViewCreateInfo}{@code ::subresourceRange}.{@code layerCount} equal to the {@code layerCount} member of the corresponding element of {@link VkFramebufferAttachmentsCreateInfoKHR}{@code ::pAttachments} used to create {@code framebuffer}</li>
 * <li>If {@code framebuffer} was created with a {@link VkFramebufferCreateInfo}{@code ::flags} value that included {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, each element of the {@code pAttachments} member of an instance of {@link VkRenderPassAttachmentBeginInfoKHR} included in the {@code pNext} chain <b>must</b> be a {@code VkImageView} of an image created with a value of {@link VkImageFormatListCreateInfoKHR}{@code ::viewFormatCount} equal to the {@code viewFormatCount} member of the corresponding element of {@link VkFramebufferAttachmentsCreateInfoKHR}{@code ::pAttachments} used to create {@code framebuffer}</li>
 * <li>If {@code framebuffer} was created with a {@link VkFramebufferCreateInfo}{@code ::flags} value that included {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, each element of the {@code pAttachments} member of an instance of {@link VkRenderPassAttachmentBeginInfoKHR} included in the {@code pNext} chain <b>must</b> be a {@code VkImageView} of an image created with a set of elements in {@link VkImageFormatListCreateInfoKHR}{@code ::pViewFormats} equal to the set of elements in the {@code pViewFormats} member of the corresponding element of {@link VkFramebufferAttachmentsCreateInfoKHR}{@code ::pAttachments} used to create {@code framebuffer}</li>
 * <li>If {@code framebuffer} was created with a {@link VkFramebufferCreateInfo}{@code ::flags} value that included {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, each element of the {@code pAttachments} member of an instance of {@link VkRenderPassAttachmentBeginInfoKHR} included in the {@code pNext} chain <b>must</b> be a {@code VkImageView} of an image created with a value of {@link VkImageViewCreateInfo}{@code ::format} equal to the corresponding value of {@link VkAttachmentDescription}{@code ::format} in {@code renderPass}</li>
 * <li>If {@code framebuffer} was created with a {@link VkFramebufferCreateInfo}{@code ::flags} value that included {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, each element of the {@code pAttachments} member of an instance of {@link VkRenderPassAttachmentBeginInfoKHR} included in the {@code pNext} chain <b>must</b> be a {@code VkImageView} of an image created with a value of {@link VkImageCreateInfo}{@code ::samples} equal to the corresponding value of {@link VkAttachmentDescription}{@code ::samples} in {@code renderPass}</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK10#VK_STRUCTURE_TYPE_RENDER_PASS_BEGIN_INFO STRUCTURE_TYPE_RENDER_PASS_BEGIN_INFO}</li>
 * <li>Each {@code pNext} member of any structure (including this one) in the {@code pNext} chain <b>must</b> be either {@code NULL} or a pointer to a valid instance of {@link VkDeviceGroupRenderPassBeginInfo}, {@link VkRenderPassAttachmentBeginInfoKHR}, or {@link VkRenderPassSampleLocationsBeginInfoEXT}</li>
 * <li>Each {@code sType} member in the {@code pNext} chain <b>must</b> be unique</li>
 * <li>{@code renderPass} <b>must</b> be a valid {@code VkRenderPass} handle</li>
 * <li>{@code framebuffer} <b>must</b> be a valid {@code VkFramebuffer} handle</li>
 * <li>If {@code clearValueCount} is not 0, {@code pClearValues} <b>must</b> be a valid pointer to an array of {@code clearValueCount} {@link VkClearValue} unions</li>
 * <li>Both of {@code framebuffer}, and {@code renderPass} <b>must</b> have been created, allocated, or retrieved from the same {@code VkDevice}</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkClearValue}, {@link VkRect2D}, {@link VK10#vkCmdBeginRenderPass CmdBeginRenderPass}, {@link KHRCreateRenderpass2#vkCmdBeginRenderPass2KHR CmdBeginRenderPass2KHR}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code renderPass} &ndash; the render pass to begin an instance of.</li>
 * <li>{@code framebuffer} &ndash; the framebuffer containing the attachments that are used with the render pass.</li>
 * <li>{@code renderArea} &ndash; the render area that is affected by the render pass instance, and is described in more detail below.</li>
 * <li>{@code clearValueCount} &ndash; the number of elements in {@code pClearValues}.</li>
 * <li>{@code pClearValues} &ndash; an array of {@link VkClearValue} structures that contains clear values for each attachment, if the attachment uses a {@code loadOp} value of {@link VK10#VK_ATTACHMENT_LOAD_OP_CLEAR ATTACHMENT_LOAD_OP_CLEAR} or if the attachment has a depth/stencil format and uses a {@code stencilLoadOp} value of {@link VK10#VK_ATTACHMENT_LOAD_OP_CLEAR ATTACHMENT_LOAD_OP_CLEAR}. The array is indexed by attachment number. Only elements corresponding to cleared attachments are used. Other elements of {@code pClearValues} are ignored.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkRenderPassBeginInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkRenderPass renderPass;
 *     VkFramebuffer framebuffer;
 *     {@link VkRect2D VkRect2D} renderArea;
 *     uint32_t clearValueCount;
 *     {@link VkClearValue VkClearValue} const * pClearValues;
 * }</code></pre>
 */
class RenderPassBeginInfo(
        var renderPass: VkRenderPass,
        var framebuffer: VkFramebuffer = VkFramebuffer.NULL,
        var renderArea: Rect2D,
        var clearValues: Array<ClearValue>? = null,
        var next: Ptr = NULL,
        clearValue: ClearValue? = null
) {
    init {
        clearValue?.let { clearValues = arrayOf(it) }
    }

    val type get() = VkStructureType.RENDER_PASS_BEGIN_INFO

    infix fun write(stack: VkStack): Adr {
        val adr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
        nsType(adr, type.i)
        npNext(adr, next)
        nrenderPass(adr, renderPass.L)
        nframebuffer(adr, framebuffer.L)
        renderArea write (adr + RENDERAREA)
        clearValues?.let {
            nclearValueCount(adr, it.size)
            memPutAddress(adr + PCLEARVALUES, it write stack)
        }
        return adr
    }
}