package vkk.vk10.structs

import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.system.MemoryUtil.memPutAddress
import org.lwjgl.vulkan.VkPipelineViewportStateCreateInfo.*
import vkk.VkStack
import vkk.VkStructureType

/**
 * Structure specifying parameters of a newly created pipeline viewport state.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-multiViewport">multiple viewports</a> feature is not enabled, {@code viewportCount} <b>must</b> be 1</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-multiViewport">multiple viewports</a> feature is not enabled, {@code scissorCount} <b>must</b> be 1</li>
 * <li>{@code viewportCount} <b>must</b> be between 1 and {@link VkPhysicalDeviceLimits}{@code ::maxViewports}, inclusive</li>
 * <li>{@code scissorCount} <b>must</b> be between 1 and {@link VkPhysicalDeviceLimits}{@code ::maxViewports}, inclusive</li>
 * <li>{@code scissorCount} and {@code viewportCount} <b>must</b> be identical</li>
 * <li>If the {@code viewportWScalingEnable} member of a {@link VkPipelineViewportWScalingStateCreateInfoNV} structure chained to the {@code pNext} chain is {@link VK10#VK_TRUE TRUE}, the {@code viewportCount} member of the {@link VkPipelineViewportWScalingStateCreateInfoNV} structure <b>must</b> be equal to {@code viewportCount}</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK10#VK_STRUCTURE_TYPE_PIPELINE_VIEWPORT_STATE_CREATE_INFO STRUCTURE_TYPE_PIPELINE_VIEWPORT_STATE_CREATE_INFO}</li>
 * <li>Each {@code pNext} member of any structure (including this one) in the {@code pNext} chain <b>must</b> be either {@code NULL} or a pointer to a valid instance of {@link VkPipelineViewportCoarseSampleOrderStateCreateInfoNV}, {@link VkPipelineViewportExclusiveScissorStateCreateInfoNV}, {@link VkPipelineViewportShadingRateImageStateCreateInfoNV}, {@link VkPipelineViewportSwizzleStateCreateInfoNV}, or {@link VkPipelineViewportWScalingStateCreateInfoNV}</li>
 * <li>Each {@code sType} member in the {@code pNext} chain <b>must</b> be unique</li>
 * <li>{@code flags} <b>must</b> be 0</li>
 * <li>{@code viewportCount} <b>must</b> be greater than 0</li>
 * <li>{@code scissorCount} <b>must</b> be greater than 0</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkGraphicsPipelineCreateInfo}, {@link VkRect2D}, {@link VkViewport}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code flags} &ndash; reserved for future use.</li>
 * <li>{@code viewportCount} &ndash; the number of viewports used by the pipeline.</li>
 * <li>{@code pViewports} &ndash; a pointer to an array of {@link VkViewport} structures, defining the viewport transforms. If the viewport state is dynamic, this member is ignored.</li>
 * <li>{@code scissorCount} &ndash; the number of <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#fragops-scissor">scissors</a> and <b>must</b> match the number of viewports.</li>
 * <li>{@code pScissors} &ndash; a pointer to an array of {@link VkRect2D} structures which define the rectangular bounds of the scissor for the corresponding viewport. If the scissor state is dynamic, this member is ignored.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPipelineViewportStateCreateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkPipelineViewportStateCreateFlags flags;
 *     uint32_t viewportCount;
 *     {@link VkViewport VkViewport} const * pViewports;
 *     uint32_t scissorCount;
 *     {@link VkRect2D VkRect2D} const * pScissors;
 * }</code></pre>
 */
class PipelineViewportStateCreateInfo(
        var viewports: Array<Viewport>? = null,
        var scissors: Array<Rect2D>? = null,
        var next: Ptr = NULL
) {

    constructor(viewport: Viewport, scissor: Rect2D) : this(arrayOf(viewport), arrayOf(scissor))

    val type get() = VkStructureType.PIPELINE_VIEWPORT_STATE_CREATE_INFO

    infix fun write(stack: VkStack): Adr {
        val adr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
        nsType(adr, type.i)
        npNext(adr, next)
        viewports?.let {
            nviewportCount(adr, it.size)
            memPutAddress(adr + PVIEWPORTS, it write stack)
        }
        scissors?.let {
            nscissorCount(adr, it.size)
            memPutAddress(adr + PSCISSORS, it write stack)
        }
        return adr
    }
}