package classes

import glm_.vec3.Vec3i
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.system.MemoryUtil.memPutAddress
import org.lwjgl.vulkan.VkFramebufferCreateInfo.*
import util.native
import vkk.VkFramebufferCreateFlags
import vkk.VkStructureType
import vkk.entities.VkImageView
import vkk.entities.VkImageView_Array
import vkk.entities.VkRenderPass

/**
 * Structure specifying parameters of a newly created framebuffer.
 *
 * <h5>Description</h5>
 *
 * <p>Applications <b>must</b> ensure that all accesses to memory that backs image subresources used as attachments in a given renderpass instance either happen-before the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#renderpass-load-store-ops">load operations</a> for those attachments, or happen-after the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#renderpass-load-store-ops">store operations</a> for those attachments.</p>
 *
 * <p>For depth/stencil attachments, each aspect <b>can</b> be used separately as attachments and non-attachments as long as the non-attachment accesses are also via an image subresource in either the {@link VK11#VK_IMAGE_LAYOUT_DEPTH_READ_ONLY_STENCIL_ATTACHMENT_OPTIMAL IMAGE_LAYOUT_DEPTH_READ_ONLY_STENCIL_ATTACHMENT_OPTIMAL} layout or the {@link VK11#VK_IMAGE_LAYOUT_DEPTH_ATTACHMENT_STENCIL_READ_ONLY_OPTIMAL IMAGE_LAYOUT_DEPTH_ATTACHMENT_STENCIL_READ_ONLY_OPTIMAL} layout, and the attachment resource uses whichever of those two layouts the image accesses do not. Use of non-attachment aspects in this case is only well defined if the attachment is used in the subpass where the non-attachment access is being made, or the layout of the image subresource is constant throughout the entire render pass instance, including the {@code initialLayout} and {@code finalLayout}.</p>
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>These restrictions mean that the render pass has full knowledge of all uses of all of the attachments, so that the implementation is able to make correct decisions about when and how to perform layout transitions, when to overlap execution of subpasses, etc.</p>
 * </div>
 *
 * <p>It is legal for a subpass to use no color or depth/stencil attachments, and rather use shader side effects such as image stores and atomics to produce an output. In this case, the subpass continues to use the {@code width}, {@code height}, and {@code layers} of the framebuffer to define the dimensions of the rendering area, and the {@code rasterizationSamples} from each pipeline's {@link VkPipelineMultisampleStateCreateInfo} to define the number of samples used in rasterization; however, if {@link VkPhysicalDeviceFeatures}{@code ::variableMultisampleRate} is {@link VK10#VK_FALSE FALSE}, then all pipelines to be bound with a given zero-attachment subpass <b>must</b> have the same value for {@link VkPipelineMultisampleStateCreateInfo}{@code ::rasterizationSamples}.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code attachmentCount} <b>must</b> be equal to the attachment count specified in {@code renderPass}</li>
 * <li>If {@code flags} does not include {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, and {@code attachmentCount} is not 0, {@code pAttachments} must be a valid pointer to an array of {@code attachmentCount} valid {@code VkImageView} handles</li>
 * <li>If {@code flags} does not include {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, each element of {@code pAttachments} that is used as a color attachment or resolve attachment by {@code renderPass} <b>must</b> have been created with a {@code usage} value including {@link VK10#VK_IMAGE_USAGE_COLOR_ATTACHMENT_BIT IMAGE_USAGE_COLOR_ATTACHMENT_BIT}</li>
 * <li>If {@code flags} does not include {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, each element of {@code pAttachments} that is used as a depth/stencil attachment by {@code renderPass} <b>must</b> have been created with a {@code usage} value including {@link VK10#VK_IMAGE_USAGE_DEPTH_STENCIL_ATTACHMENT_BIT IMAGE_USAGE_DEPTH_STENCIL_ATTACHMENT_BIT}</li>
 * <li>If {@code flags} does not include {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, each element of {@code pAttachments} that is used as a depth/stencil resolve attachment by {@code renderPass} <b>must</b> have been created with a {@code usage} value including {@link VK10#VK_IMAGE_USAGE_DEPTH_STENCIL_ATTACHMENT_BIT IMAGE_USAGE_DEPTH_STENCIL_ATTACHMENT_BIT}</li>
 * <li>If {@code flags} does not include {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, each element of {@code pAttachments} that is used as an input attachment by {@code renderPass} <b>must</b> have been created with a {@code usage} value including {@link VK10#VK_IMAGE_USAGE_INPUT_ATTACHMENT_BIT IMAGE_USAGE_INPUT_ATTACHMENT_BIT}</li>
 * <li>Each element of {@code pAttachments} that is used as a fragment density map attachment by {@code renderPass} <b>must</b> not have been created with a {@code flags} value including {@link EXTFragmentDensityMap#VK_IMAGE_CREATE_SUBSAMPLED_BIT_EXT IMAGE_CREATE_SUBSAMPLED_BIT_EXT}.</li>
 * <li>If {@code renderPass} has a fragment density map attachment and <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-nonsubsampledimages">non-subsample image feature</a> is not enabled, each element of {@code pAttachments} <b>must</b> have been created with a {@code flags} value including {@link EXTFragmentDensityMap#VK_IMAGE_CREATE_SUBSAMPLED_BIT_EXT IMAGE_CREATE_SUBSAMPLED_BIT_EXT} unless that element is the fragment density map attachment.</li>
 * <li>If {@code flags} does not include {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, each element of {@code pAttachments} <b>must</b> have been created with an {@code VkFormat} value that matches the {@code VkFormat} specified by the corresponding {@link VkAttachmentDescription} in {@code renderPass}</li>
 * <li>If {@code flags} does not include {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, each element of {@code pAttachments} <b>must</b> have been created with a {@code samples} value that matches the {@code samples} value specified by the corresponding {@link VkAttachmentDescription} in {@code renderPass}</li>
 * <li>If {@code flags} does not include {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, each element of {@code pAttachments} <b>must</b> have dimensions at least as large as the corresponding framebuffer dimension except for any element that is referenced by {@code fragmentDensityMapAttachment}</li>
 * <li>If {@code renderPass} was specified with non-zero view masks, each element of {@code pAttachments} that is not referenced by {@code fragmentDensityMapAttachment} <b>must</b> have a {@code layerCount} greater than the index of the most significant bit set in any of those view masks</li>
 * <li>If {@code renderPass} was specified with non-zero view masks, each element of {@code pAttachments} that is referenced by {@code fragmentDensityMapAttachment} <b>must</b> have a {@code layerCount} equal to 1 or greater than the index of the most significant bit set in any of those view masks</li>
 * <li>If {@code renderPass} was not specified with non-zero view masks, each element of {@code pAttachments} that is referenced by {@code fragmentDensityMapAttachment} <b>must</b> have a {@code layerCount} equal to 1</li>
 * <li>If {@code flags} does not include {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, an element of {@code pAttachments} that is referenced by {@code fragmentDensityMapAttachment} <b>must</b> have a width at least as large as {@code ceil(width / maxFragmentDensityTexelSize.width)}</li>
 * <li>If {@code flags} does not include {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, an element of {@code pAttachments} that is referenced by {@code fragmentDensityMapAttachment} <b>must</b> have a height at least as large as {@code ceil(height / maxFragmentDensityTexelSize.height)}</li>
 * <li>If {@code flags} does not include {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, each element of {@code pAttachments} <b>must</b> only specify a single mip level</li>
 * <li>If {@code flags} does not include {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, each element of {@code pAttachments} <b>must</b> have been created with the identity swizzle</li>
 * <li>{@code width} <b>must</b> be greater than 0.</li>
 * <li>{@code width} <b>must</b> be less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxFramebufferWidth}</li>
 * <li>{@code height} <b>must</b> be greater than 0.</li>
 * <li>{@code height} <b>must</b> be less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxFramebufferHeight}</li>
 * <li>{@code layers} <b>must</b> be greater than 0.</li>
 * <li>{@code layers} <b>must</b> be less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxFramebufferLayers}</li>
 * <li>If {@code renderPass} was specified with non-zero view masks, {@code layers} <b>must</b> be 1</li>
 * <li>If {@code flags} does not include {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, each element of {@code pAttachments} that is a 2D or 2D array image view taken from a 3D image <b>must</b> not be a depth/stencil format</li>
 * <li>If {@code flags} does not include {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, and {@code attachmentCount} is not 0, {@code pAttachments} <b>must</b> be a valid pointer to an array of {@code attachmentCount} valid {@code VkImageView} handles</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-imagelessFramebuffer">imageless framebuffer</a> feature is not enabled, {@code flags} <b>must</b> not include {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}</li>
 * <li>If {@code flags} includes {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, the {@code pNext} chain <b>must</b> include an instance of {@link VkFramebufferAttachmentsCreateInfoKHR}</li>
 * <li>If {@code flags} includes {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, the {@code attachmentImageInfoCount} member of an instance of {@link VkFramebufferAttachmentsCreateInfoKHR} in the {@code pNext} chain <b>must</b> be equal to either zero or {@code attachmentCount}</li>
 * <li>If {@code flags} includes {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, the {@code width} member of any element of the {@code pAttachmentImageInfos} member of an instance of {@link VkFramebufferAttachmentsCreateInfoKHR} in the {@code pNext} chain <b>must</b> be greater than or equal to {@code width}, except for any element that is referenced by {@link VkRenderPassFragmentDensityMapCreateInfoEXT}{@code ::fragmentDensityMapAttachment} in {@code renderPass}</li>
 * <li>If {@code flags} includes {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, the {@code height} member of any element of the {@code pAttachmentImageInfos} member of an instance of {@link VkFramebufferAttachmentsCreateInfoKHR} in the {@code pNext} chain <b>must</b> be greater than or equal to {@code height}, except for any element that is referenced by {@link VkRenderPassFragmentDensityMapCreateInfoEXT}{@code ::fragmentDensityMapAttachment} in {@code renderPass}</li>
 * <li>If {@code flags} includes {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, the {@code width} member of any element of the {@code pAttachmentImageInfos} member of an instance of {@link VkFramebufferAttachmentsCreateInfoKHR} in the {@code pNext} chain that is referenced by {@link VkRenderPassFragmentDensityMapCreateInfoEXT}{@code ::fragmentDensityMapAttachment} in {@code renderPass} <b>must</b> be greater than or equal to {@code ceil(width / maxFragmentDensityTexelSize.width)}</li>
 * <li>If {@code flags} includes {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, the {@code height} member of any element of the {@code pAttachmentImageInfos} member of an instance of {@link VkFramebufferAttachmentsCreateInfoKHR} in the {@code pNext} chain that is referenced by {@link VkRenderPassFragmentDensityMapCreateInfoEXT}{@code ::fragmentDensityMapAttachment} in {@code renderPass} <b>must</b> be greater than or equal to {@code ceil(height / maxFragmentDensityTexelSize.height)}</li>
 * <li>If multiview is enabled for {@code renderPass}, and {@code flags} includes {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, the {@code layerCount} member of any element of the {@code pAttachmentImageInfos} member of an instance of {@link VkFramebufferAttachmentsCreateInfoKHR} in the {@code pNext} chain <b>must</b> be greater than the maximum bit index set in the view mask in the subpasses in which it is used in {@code renderPass}</li>
 * <li>If multiview is not enabled for {@code renderPass}, and {@code flags} includes {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, the {@code layerCount} member of any element of the {@code pAttachmentImageInfos} member of an instance of {@link VkFramebufferAttachmentsCreateInfoKHR} in the {@code pNext} chain <b>must</b> be greater than or equal to {@code layers}</li>
 * <li>If {@code flags} includes {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, the {@code usage} member of any element of the {@code pAttachmentImageInfos} member of an instance of {@link VkFramebufferAttachmentsCreateInfoKHR} in the {@code pNext} chain that refers to an attachment used as a color attachment or resolve attachment by {@code renderPass} <b>must</b> include {@link VK10#VK_IMAGE_USAGE_COLOR_ATTACHMENT_BIT IMAGE_USAGE_COLOR_ATTACHMENT_BIT}</li>
 * <li>If {@code flags} includes {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, the {@code usage} member of any element of the {@code pAttachmentImageInfos} member of an instance of {@link VkFramebufferAttachmentsCreateInfoKHR} in the {@code pNext} chain that refers to an attachment used as a depth/stencil attachment by {@code renderPass} <b>must</b> include {@link VK10#VK_IMAGE_USAGE_DEPTH_STENCIL_ATTACHMENT_BIT IMAGE_USAGE_DEPTH_STENCIL_ATTACHMENT_BIT}</li>
 * <li>If {@code flags} includes {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, the {@code usage} member of any element of the {@code pAttachmentImageInfos} member of an instance of {@link VkFramebufferAttachmentsCreateInfoKHR} in the {@code pNext} chain that refers to an attachment used as a depth/stencil resolve attachment by {@code renderPass} <b>must</b> include {@link VK10#VK_IMAGE_USAGE_DEPTH_STENCIL_ATTACHMENT_BIT IMAGE_USAGE_DEPTH_STENCIL_ATTACHMENT_BIT}</li>
 * <li>If {@code flags} includes {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, the {@code usage} member of any element of the {@code pAttachmentImageInfos} member of an instance of {@link VkFramebufferAttachmentsCreateInfoKHR} in the {@code pNext} chain that refers to an attachment used as an input attachment by {@code renderPass} <b>must</b> include {@link VK10#VK_IMAGE_USAGE_INPUT_ATTACHMENT_BIT IMAGE_USAGE_INPUT_ATTACHMENT_BIT}</li>
 * <li>If {@code flags} includes {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, at least one element of the {@code pViewFormats} member of any element of the {@code pAttachmentImageInfos} member of an instance of {@link VkFramebufferAttachmentsCreateInfoKHR} in the {@code pNext} chain <b>must</b> be equal to the corresponding value of {@link VkAttachmentDescription}{@code ::format} used to create {@code renderPass}</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK10#VK_STRUCTURE_TYPE_FRAMEBUFFER_CREATE_INFO STRUCTURE_TYPE_FRAMEBUFFER_CREATE_INFO}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL} or a pointer to a valid instance of {@link VkFramebufferAttachmentsCreateInfoKHR}</li>
 * <li>{@code flags} <b>must</b> be a valid combination of {@code VkFramebufferCreateFlagBits} values</li>
 * <li>{@code renderPass} <b>must</b> be a valid {@code VkRenderPass} handle</li>
 * <li>Both of {@code renderPass}, and the elements of {@code pAttachments} that are valid handles <b>must</b> have been created, allocated, or retrieved from the same {@code VkDevice}</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VK10#vkCreateFramebuffer CreateFramebuffer}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code flags} &ndash; a bitmask of {@code VkFramebufferCreateFlagBits}</li>
 * <li>{@code renderPass} &ndash; a render pass that defines what render passes the framebuffer will be compatible with. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#renderpass-compatibility">Render Pass Compatibility</a> for details.</li>
 * <li>{@code attachmentCount} &ndash; the number of attachments.</li>
 * <li>{@code pAttachments} &ndash; an array of {@code VkImageView} handles, each of which will be used as the corresponding attachment in a render pass instance. If {@code flags} includes {@link KHRImagelessFramebuffer#VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR FRAMEBUFFER_CREATE_IMAGELESS_BIT_KHR}, this parameter is ignored.</li>
 * <li>{@code width} &ndash; {@code width}, {@code height} and {@code layers} define the dimensions of the framebuffer. If the render pass uses multiview, then {@code layers} <b>must</b> be one and each attachment requires a number of layers that is greater than the maximum bit index set in the view mask in the subpasses in which it is used.</li>
 * <li>{@code height} &ndash; see {@code width}</li>
 * <li>{@code layers} &ndash; see {@code width}</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkFramebufferCreateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkFramebufferCreateFlags flags;
 *     VkRenderPass renderPass;
 *     uint32_t attachmentCount;
 *     VkImageView const * pAttachments;
 *     uint32_t width;
 *     uint32_t height;
 *     uint32_t layers;
 * }</code></pre>
 */
class FramebufferCreateInfo(
    var flags: VkFramebufferCreateFlags = 0,
    var renderPass: VkRenderPass,
    var attachments: VkImageView_Array? = null,
    var dimension: Vec3i,
    var next: Ptr = NULL
) {
    val type get() = VkStructureType.FRAMEBUFFER_CREATE_INFO

//    var attachment: VkImageView? TODO
//        get() = attachments?.get(0)
//        set(value) = when (value) {
//            null -> attachments = null
//            else -> attachments?.set(0, value) ?: run { attachments = VkImageView_Array(1) { value } }
//        }

    val MemoryStack.native: Ptr
        get() = ncalloc(ALIGNOF, 1, SIZEOF).also { ptr ->
            nsType(ptr, type.i)
            npNext(ptr, next)
            nflags(ptr, flags)
            nrenderPass(ptr, renderPass.L)
            attachments?.let {
                nattachmentCount(ptr, it.size)
                memPutAddress(ptr + PATTACHMENTS, it.native(this))
            }
            dimension.to(ptr + WIDTH)
        }
}