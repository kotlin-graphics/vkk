package classes

import glm_.i
import kool.Ptr
import kool.adr
import kool.toBuffer
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.system.MemoryUtil.memPutAddress
import org.lwjgl.vulkan.VkPipelineMultisampleStateCreateInfo
import org.lwjgl.vulkan.VkPipelineMultisampleStateCreateInfo.*
import vkk.VkSampleCount
import vkk.VkStructureType

/**
 * Structure specifying parameters of a newly created pipeline multisample state.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-sampleRateShading">sample rate shading</a> feature is not enabled, {@code sampleShadingEnable} <b>must</b> be {@link VK10#VK_FALSE FALSE}</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-alphaToOne">alpha to one</a> feature is not enabled, {@code alphaToOneEnable} <b>must</b> be {@link VK10#VK_FALSE FALSE}</li>
 * <li>{@code minSampleShading} <b>must</b> be in the range <code>[0,1]</code></li>
 * <li>If the {@code VK_NV_framebuffer_mixed_samples} extension is enabled, and if the subpass has any color attachments and {@code rasterizationSamples} is greater than the number of color samples, then {@code sampleShadingEnable} <b>must</b> be {@link VK10#VK_FALSE FALSE}</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK10#VK_STRUCTURE_TYPE_PIPELINE_MULTISAMPLE_STATE_CREATE_INFO STRUCTURE_TYPE_PIPELINE_MULTISAMPLE_STATE_CREATE_INFO}</li>
 * <li>Each {@code pNext} member of any structure (including this one) in the {@code pNext} chain <b>must</b> be either {@code NULL} or a pointer to a valid instance of {@link VkPipelineCoverageModulationStateCreateInfoNV}, {@link VkPipelineCoverageReductionStateCreateInfoNV}, {@link VkPipelineCoverageToColorStateCreateInfoNV}, or {@link VkPipelineSampleLocationsStateCreateInfoEXT}</li>
 * <li>Each {@code sType} member in the {@code pNext} chain <b>must</b> be unique</li>
 * <li>{@code flags} <b>must</b> be 0</li>
 * <li>{@code rasterizationSamples} <b>must</b> be a valid {@code VkSampleCountFlagBits} value</li>
 * <li>If {@code pSampleMask} is not {@code NULL}, {@code pSampleMask} <b>must</b> be a valid pointer to an array of {@code ceil(rasterizationSamples / 32)} {@code VkSampleMask} values</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkGraphicsPipelineCreateInfo}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code flags} &ndash; reserved for future use.</li>
 * <li>{@code rasterizationSamples} &ndash; a {@code VkSampleCountFlagBits} specifying the number of samples used in rasterization.</li>
 * <li>{@code sampleShadingEnable} &ndash; <b>can</b> be used to enable <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#primsrast-sampleshading">Sample Shading</a>.</li>
 * <li>{@code minSampleShading} &ndash; specifies a minimum fraction of sample shading if {@code sampleShadingEnable} is set to {@link VK10#VK_TRUE TRUE}.</li>
 * <li>{@code pSampleMask} &ndash; a bitmask of static coverage information that is ANDed with the coverage information generated during rasterization, as described in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#fragops-samplemask">Sample Mask</a>.</li>
 * <li>{@code alphaToCoverageEnable} &ndash; controls whether a temporary coverage value is generated based on the alpha component of the fragment&#8217;s first color output as specified in the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#fragops-covg">Multisample Coverage</a> section.</li>
 * <li>{@code alphaToOneEnable} &ndash; controls whether the alpha component of the fragment&#8217;s first color output is replaced with one as described in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#fragops-covg">Multisample Coverage</a>.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPipelineMultisampleStateCreateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkPipelineMultisampleStateCreateFlags flags;
 *     VkSampleCountFlagBits rasterizationSamples;
 *     VkBool32 sampleShadingEnable;
 *     float minSampleShading;
 *     VkSampleMask const * pSampleMask;
 *     VkBool32 alphaToCoverageEnable;
 *     VkBool32 alphaToOneEnable;
 * }</code></pre>
 */
class PipelineMultisampleStateCreateInfo(
    var rasterizationSamples: VkSampleCount = VkSampleCount._1_BIT,
    var sampleShadingEnable: Boolean = false,
    var minSampleShading: Float = 0f,
    var sampleMask: IntArray? = null,
    var alphaToCoverageEnable: Boolean = false,
    var alphaToOneEnable: Boolean = false,
    var next: Ptr = NULL
) {

    val type get() = VkStructureType.PIPELINE_MULTISAMPLE_STATE_CREATE_INFO

    val MemoryStack.native: Ptr
        get() = ncalloc(ALIGNOF, 1, SIZEOF).also { ptr ->
            nsType(ptr, type.i)
            npNext(ptr, next)
            nrasterizationSamples(ptr, rasterizationSamples.i)
            nsampleShadingEnable(ptr, sampleShadingEnable.i)
            nminSampleShading(ptr, minSampleShading)
            sampleMask?.let { memPutAddress(ptr + PSAMPLEMASK, it.toBuffer(this).adr)  }
            nalphaToCoverageEnable(ptr, alphaToCoverageEnable.i)
            nalphaToOneEnable(ptr, alphaToOneEnable.i)
        }
}