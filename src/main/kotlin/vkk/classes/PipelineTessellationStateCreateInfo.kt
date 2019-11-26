package classes

import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.vulkan.VkPipelineTessellationStateCreateInfo
import org.lwjgl.vulkan.VkPipelineTessellationStateCreateInfo.*
import vkk.VkStructureType

/**
 * Structure specifying parameters of a newly created pipeline tessellation state.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code patchControlPoints} <b>must</b> be greater than zero and less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxTessellationPatchSize}</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK10#VK_STRUCTURE_TYPE_PIPELINE_TESSELLATION_STATE_CREATE_INFO STRUCTURE_TYPE_PIPELINE_TESSELLATION_STATE_CREATE_INFO}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL} or a pointer to a valid instance of {@link VkPipelineTessellationDomainOriginStateCreateInfo}</li>
 * <li>{@code flags} <b>must</b> be 0</li>
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
 * <li>{@code patchControlPoints} &ndash; number of control points per patch.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPipelineTessellationStateCreateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkPipelineTessellationStateCreateFlags flags;
 *     uint32_t patchControlPoints;
 * }</code></pre>
 */
class PipelineTessellationStateCreateInfo(
    var patchControlPoints: Int,
    var next: Ptr = NULL
) {

    val type get() = VkStructureType.PIPELINE_TESSELLATION_STATE_CREATE_INFO

    val MemoryStack.native: Ptr
        get() = ncalloc(ALIGNOF, 1, SIZEOF).also {
            nsType(it, type.i)
            npNext(it, next)
            npatchControlPoints(it, patchControlPoints)
        }
}