package vkk._10.structs

import glm_.i
import glm_.vec4.Vec4
import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.system.MemoryUtil.memPutAddress
import org.lwjgl.vulkan.VkPipelineColorBlendStateCreateInfo.*
import vkk.VkLogicOp
import vkk.VkStack
import vkk.VkStructureType

/**
 * Structure specifying parameters of a newly created pipeline color blend state.
 *
 * <h5>Description</h5>
 *
 * <p>Each element of the {@code pAttachments} array is a {@link VkPipelineColorBlendAttachmentState} structure specifying per-target blending state for each individual color attachment. If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-independentBlend">independent blending</a> feature is not enabled on the device, all {@link VkPipelineColorBlendAttachmentState} elements in the {@code pAttachments} array <b>must</b> be identical.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-independentBlend">independent blending</a> feature is not enabled, all elements of {@code pAttachments} <b>must</b> be identical</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-logicOp">logic operations</a> feature is not enabled, {@code logicOpEnable} <b>must</b> be {@link VK10#VK_FALSE FALSE}</li>
 * <li>If {@code logicOpEnable} is {@link VK10#VK_TRUE TRUE}, {@code logicOp} <b>must</b> be a valid {@code VkLogicOp} value</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK10#VK_STRUCTURE_TYPE_PIPELINE_COLOR_BLEND_STATE_CREATE_INFO STRUCTURE_TYPE_PIPELINE_COLOR_BLEND_STATE_CREATE_INFO}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL} or a pointer to a valid instance of {@link VkPipelineColorBlendAdvancedStateCreateInfoEXT}</li>
 * <li>{@code flags} <b>must</b> be 0</li>
 * <li>If {@code attachmentCount} is not 0, {@code pAttachments} <b>must</b> be a valid pointer to an array of {@code attachmentCount} valid {@link VkPipelineColorBlendAttachmentState} structures</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkGraphicsPipelineCreateInfo}, {@link VkPipelineColorBlendAttachmentState}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code flags} &ndash; reserved for future use.</li>
 * <li>{@code logicOpEnable} &ndash; controls whether to apply <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#framebuffer-logicop">Logical Operations</a>.</li>
 * <li>{@code logicOp} &ndash; selects which logical operation to apply.</li>
 * <li>{@code attachmentCount} &ndash; the number of {@link VkPipelineColorBlendAttachmentState} elements in {@code pAttachments}. This value <b>must</b> equal the {@code colorAttachmentCount} for the subpass in which this pipeline is used.</li>
 * <li>{@code pAttachments} &ndash; a pointer to array of per target attachment states.</li>
 * <li>{@code blendConstants[4]} &ndash; an array of four values used as the R, G, B, and A components of the blend constant that are used in blending, depending on the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#framebuffer-blendfactors">blend factor</a>.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPipelineColorBlendStateCreateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkPipelineColorBlendStateCreateFlags flags;
 *     VkBool32 logicOpEnable;
 *     VkLogicOp logicOp;
 *     uint32_t attachmentCount;
 *     {@link VkPipelineColorBlendAttachmentState VkPipelineColorBlendAttachmentState} const * pAttachments;
 *     float blendConstants[4];
 * }</code></pre>
 */
class PipelineColorBlendStateCreateInfo(
        var logicOpEnable: Boolean = false,
        var logicOp: VkLogicOp = VkLogicOp.CLEAR,
        var attachments: Array<PipelineColorBlendAttachmentState>? = null,
        var blendConstants: Vec4 = Vec4(0f),
        var next: Ptr = NULL
) {
    constructor(
            logicOpEnable: Boolean = false,
            logicOp: VkLogicOp = VkLogicOp.CLEAR,
            attachment: PipelineColorBlendAttachmentState,
            blendConstants: Vec4 = Vec4(0f)
    ) : this(logicOpEnable, logicOp, arrayOf(attachment), blendConstants)

    val type get() = VkStructureType.PIPELINE_COLOR_BLEND_STATE_CREATE_INFO

    infix fun write(stack: VkStack): Adr {
        val adr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
        nsType(adr, type.i)
        npNext(adr, next)
        nlogicOpEnable(adr, logicOpEnable.i)
        nlogicOp(adr, logicOp.i)
        attachments?.let {
            nattachmentCount(adr, it.size)
            memPutAddress(adr + PATTACHMENTS, it write stack)
        }
        blendConstants to (adr + BLENDCONSTANTS)
        return adr
    }
}

