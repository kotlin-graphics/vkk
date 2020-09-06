package vkk.vk10.structs

import glm_.i
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkPipelineColorBlendAttachmentState.*
import vkk.VkBlendFactor
import vkk.VkBlendOp
import vkk.VkColorComponentFlags

/**
 * Structure specifying a pipeline color blend attachment state.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-dualSrcBlend">dual source blending</a> feature is not enabled, {@code srcColorBlendFactor} <b>must</b> not be {@link VK10#VK_BLEND_FACTOR_SRC1_COLOR BLEND_FACTOR_SRC1_COLOR}, {@link VK10#VK_BLEND_FACTOR_ONE_MINUS_SRC1_COLOR BLEND_FACTOR_ONE_MINUS_SRC1_COLOR}, {@link VK10#VK_BLEND_FACTOR_SRC1_ALPHA BLEND_FACTOR_SRC1_ALPHA}, or {@link VK10#VK_BLEND_FACTOR_ONE_MINUS_SRC1_ALPHA BLEND_FACTOR_ONE_MINUS_SRC1_ALPHA}</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-dualSrcBlend">dual source blending</a> feature is not enabled, {@code dstColorBlendFactor} <b>must</b> not be {@link VK10#VK_BLEND_FACTOR_SRC1_COLOR BLEND_FACTOR_SRC1_COLOR}, {@link VK10#VK_BLEND_FACTOR_ONE_MINUS_SRC1_COLOR BLEND_FACTOR_ONE_MINUS_SRC1_COLOR}, {@link VK10#VK_BLEND_FACTOR_SRC1_ALPHA BLEND_FACTOR_SRC1_ALPHA}, or {@link VK10#VK_BLEND_FACTOR_ONE_MINUS_SRC1_ALPHA BLEND_FACTOR_ONE_MINUS_SRC1_ALPHA}</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-dualSrcBlend">dual source blending</a> feature is not enabled, {@code srcAlphaBlendFactor} <b>must</b> not be {@link VK10#VK_BLEND_FACTOR_SRC1_COLOR BLEND_FACTOR_SRC1_COLOR}, {@link VK10#VK_BLEND_FACTOR_ONE_MINUS_SRC1_COLOR BLEND_FACTOR_ONE_MINUS_SRC1_COLOR}, {@link VK10#VK_BLEND_FACTOR_SRC1_ALPHA BLEND_FACTOR_SRC1_ALPHA}, or {@link VK10#VK_BLEND_FACTOR_ONE_MINUS_SRC1_ALPHA BLEND_FACTOR_ONE_MINUS_SRC1_ALPHA}</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-dualSrcBlend">dual source blending</a> feature is not enabled, {@code dstAlphaBlendFactor} <b>must</b> not be {@link VK10#VK_BLEND_FACTOR_SRC1_COLOR BLEND_FACTOR_SRC1_COLOR}, {@link VK10#VK_BLEND_FACTOR_ONE_MINUS_SRC1_COLOR BLEND_FACTOR_ONE_MINUS_SRC1_COLOR}, {@link VK10#VK_BLEND_FACTOR_SRC1_ALPHA BLEND_FACTOR_SRC1_ALPHA}, or {@link VK10#VK_BLEND_FACTOR_ONE_MINUS_SRC1_ALPHA BLEND_FACTOR_ONE_MINUS_SRC1_ALPHA}</li>
 * <li>If either of {@code colorBlendOp} or {@code alphaBlendOp} is an <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#framebuffer-blend-advanced">advanced blend operation</a>, then {@code colorBlendOp} <b>must</b> equal {@code alphaBlendOp}</li>
 * <li>If {@link VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT}{@code ::advancedBlendIndependentBlend} is {@link VK10#VK_FALSE FALSE} and {@code colorBlendOp} is an <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#framebuffer-blend-advanced">advanced blend operation</a>, then {@code colorBlendOp} <b>must</b> be the same for all attachments.</li>
 * <li>If {@link VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT}{@code ::advancedBlendIndependentBlend} is {@link VK10#VK_FALSE FALSE} and {@code alphaBlendOp} is an <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#framebuffer-blend-advanced">advanced blend operation</a>, then {@code alphaBlendOp} <b>must</b> be the same for all attachments.</li>
 * <li>If {@link VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT}{@code ::advancedBlendAllOperations} is {@link VK10#VK_FALSE FALSE}, then {@code colorBlendOp} <b>must</b> not be {@link EXTBlendOperationAdvanced#VK_BLEND_OP_ZERO_EXT BLEND_OP_ZERO_EXT}, {@link EXTBlendOperationAdvanced#VK_BLEND_OP_SRC_EXT BLEND_OP_SRC_EXT}, {@link EXTBlendOperationAdvanced#VK_BLEND_OP_DST_EXT BLEND_OP_DST_EXT}, {@link EXTBlendOperationAdvanced#VK_BLEND_OP_SRC_OVER_EXT BLEND_OP_SRC_OVER_EXT}, {@link EXTBlendOperationAdvanced#VK_BLEND_OP_DST_OVER_EXT BLEND_OP_DST_OVER_EXT}, {@link EXTBlendOperationAdvanced#VK_BLEND_OP_SRC_IN_EXT BLEND_OP_SRC_IN_EXT}, {@link EXTBlendOperationAdvanced#VK_BLEND_OP_DST_IN_EXT BLEND_OP_DST_IN_EXT}, {@link EXTBlendOperationAdvanced#VK_BLEND_OP_SRC_OUT_EXT BLEND_OP_SRC_OUT_EXT}, {@link EXTBlendOperationAdvanced#VK_BLEND_OP_DST_OUT_EXT BLEND_OP_DST_OUT_EXT}, {@link EXTBlendOperationAdvanced#VK_BLEND_OP_SRC_ATOP_EXT BLEND_OP_SRC_ATOP_EXT}, {@link EXTBlendOperationAdvanced#VK_BLEND_OP_DST_ATOP_EXT BLEND_OP_DST_ATOP_EXT}, {@link EXTBlendOperationAdvanced#VK_BLEND_OP_XOR_EXT BLEND_OP_XOR_EXT}, {@link EXTBlendOperationAdvanced#VK_BLEND_OP_INVERT_EXT BLEND_OP_INVERT_EXT}, {@link EXTBlendOperationAdvanced#VK_BLEND_OP_INVERT_RGB_EXT BLEND_OP_INVERT_RGB_EXT}, {@link EXTBlendOperationAdvanced#VK_BLEND_OP_LINEARDODGE_EXT BLEND_OP_LINEARDODGE_EXT}, {@link EXTBlendOperationAdvanced#VK_BLEND_OP_LINEARBURN_EXT BLEND_OP_LINEARBURN_EXT}, {@link EXTBlendOperationAdvanced#VK_BLEND_OP_VIVIDLIGHT_EXT BLEND_OP_VIVIDLIGHT_EXT}, {@link EXTBlendOperationAdvanced#VK_BLEND_OP_LINEARLIGHT_EXT BLEND_OP_LINEARLIGHT_EXT}, {@link EXTBlendOperationAdvanced#VK_BLEND_OP_PINLIGHT_EXT BLEND_OP_PINLIGHT_EXT}, {@link EXTBlendOperationAdvanced#VK_BLEND_OP_HARDMIX_EXT BLEND_OP_HARDMIX_EXT}, {@link EXTBlendOperationAdvanced#VK_BLEND_OP_PLUS_EXT BLEND_OP_PLUS_EXT}, {@link EXTBlendOperationAdvanced#VK_BLEND_OP_PLUS_CLAMPED_EXT BLEND_OP_PLUS_CLAMPED_EXT}, {@link EXTBlendOperationAdvanced#VK_BLEND_OP_PLUS_CLAMPED_ALPHA_EXT BLEND_OP_PLUS_CLAMPED_ALPHA_EXT}, {@link EXTBlendOperationAdvanced#VK_BLEND_OP_PLUS_DARKER_EXT BLEND_OP_PLUS_DARKER_EXT}, {@link EXTBlendOperationAdvanced#VK_BLEND_OP_MINUS_EXT BLEND_OP_MINUS_EXT}, {@link EXTBlendOperationAdvanced#VK_BLEND_OP_MINUS_CLAMPED_EXT BLEND_OP_MINUS_CLAMPED_EXT}, {@link EXTBlendOperationAdvanced#VK_BLEND_OP_CONTRAST_EXT BLEND_OP_CONTRAST_EXT}, {@link EXTBlendOperationAdvanced#VK_BLEND_OP_INVERT_OVG_EXT BLEND_OP_INVERT_OVG_EXT}, {@link EXTBlendOperationAdvanced#VK_BLEND_OP_RED_EXT BLEND_OP_RED_EXT}, {@link EXTBlendOperationAdvanced#VK_BLEND_OP_GREEN_EXT BLEND_OP_GREEN_EXT}, or {@link EXTBlendOperationAdvanced#VK_BLEND_OP_BLUE_EXT BLEND_OP_BLUE_EXT}</li>
 * <li>If {@code colorBlendOp} or {@code alphaBlendOp} is an <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#framebuffer-blend-advanced">advanced blend operation</a>, then {@link VkSubpassDescription}{@code ::colorAttachmentCount} of the subpass this pipeline is compiled against <b>must</b> be less than or equal to {@link VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT}::advancedBlendMaxColorAttachments</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code srcColorBlendFactor} <b>must</b> be a valid {@code VkBlendFactor} value</li>
 * <li>{@code dstColorBlendFactor} <b>must</b> be a valid {@code VkBlendFactor} value</li>
 * <li>{@code colorBlendOp} <b>must</b> be a valid {@code VkBlendOp} value</li>
 * <li>{@code srcAlphaBlendFactor} <b>must</b> be a valid {@code VkBlendFactor} value</li>
 * <li>{@code dstAlphaBlendFactor} <b>must</b> be a valid {@code VkBlendFactor} value</li>
 * <li>{@code alphaBlendOp} <b>must</b> be a valid {@code VkBlendOp} value</li>
 * <li>{@code colorWriteMask} <b>must</b> be a valid combination of {@code VkColorComponentFlagBits} values</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkPipelineColorBlendStateCreateInfo}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code blendEnable} &ndash; controls whether blending is enabled for the corresponding color attachment. If blending is not enabled, the source fragment&#8217;s color for that attachment is passed through unmodified.</li>
 * <li>{@code srcColorBlendFactor} &ndash; selects which blend factor is used to determine the source factors <code>(S<sub>r</sub>,S<sub>g</sub>,S<sub>b</sub>)</code>.</li>
 * <li>{@code dstColorBlendFactor} &ndash; selects which blend factor is used to determine the destination factors <code>(D<sub>r</sub>,D<sub>g</sub>,D<sub>b</sub>)</code>.</li>
 * <li>{@code colorBlendOp} &ndash; selects which blend operation is used to calculate the RGB values to write to the color attachment.</li>
 * <li>{@code srcAlphaBlendFactor} &ndash; selects which blend factor is used to determine the source factor <code>S<sub>a</sub></code>.</li>
 * <li>{@code dstAlphaBlendFactor} &ndash; selects which blend factor is used to determine the destination factor <code>D<sub>a</sub></code>.</li>
 * <li>{@code alphaBlendOp} &ndash; selects which blend operation is use to calculate the alpha values to write to the color attachment.</li>
 * <li>{@code colorWriteMask} &ndash; a bitmask of {@code VkColorComponentFlagBits} specifying which of the R, G, B, and/or A components are enabled for writing, as described for the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#framebuffer-color-write-mask">Color Write Mask</a>.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPipelineColorBlendAttachmentState {
 *     VkBool32 blendEnable;
 *     VkBlendFactor srcColorBlendFactor;
 *     VkBlendFactor dstColorBlendFactor;
 *     VkBlendOp colorBlendOp;
 *     VkBlendFactor srcAlphaBlendFactor;
 *     VkBlendFactor dstAlphaBlendFactor;
 *     VkBlendOp alphaBlendOp;
 *     VkColorComponentFlags colorWriteMask;
 * }</code></pre>
 */
class PipelineColorBlendAttachmentState(
    var blendEnable: Boolean = false,
    var srcColorBlendFactor: VkBlendFactor = VkBlendFactor.ZERO,
    var dstColorBlendFactor: VkBlendFactor = VkBlendFactor.ZERO,
    var colorBlendOp: VkBlendOp = VkBlendOp.ADD,
    var srcAlphaBlendFactor: VkBlendFactor = VkBlendFactor.ZERO,
    var dstAlphaBlendFactor: VkBlendFactor = VkBlendFactor.ZERO,
    var alphaBlendOp: VkBlendOp = VkBlendOp.ADD,
    var colorWriteMask: VkColorComponentFlags = 0
) {

    infix fun write(ptr: Ptr) {
        nblendEnable(ptr, blendEnable.i)
        nsrcColorBlendFactor(ptr, srcColorBlendFactor.i)
        ndstColorBlendFactor(ptr, dstColorBlendFactor.i)
        ncolorBlendOp(ptr, colorBlendOp.i)
        nsrcAlphaBlendFactor(ptr, srcAlphaBlendFactor.i)
        ndstAlphaBlendFactor(ptr, dstAlphaBlendFactor.i)
        nalphaBlendOp(ptr, alphaBlendOp.i)
        ncolorWriteMask(ptr, colorWriteMask)
    }
}

infix fun Array<PipelineColorBlendAttachmentState>.write(stack: MemoryStack): Ptr {
    val natives = stack.ncalloc(ALIGNOF, size, SIZEOF)
    for (i in indices)
        this[i].write(natives + SIZEOF * i)
    return natives
}