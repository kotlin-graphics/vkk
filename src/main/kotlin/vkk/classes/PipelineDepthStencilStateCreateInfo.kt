package classes

import glm_.i
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkPipelineDepthStencilStateCreateInfo
import org.lwjgl.vulkan.VkPipelineDepthStencilStateCreateInfo.*
import org.lwjgl.vulkan.VkStencilOpState
import vkk.VkCompareOp
import vkk.VkStructureType

/**
 * Structure specifying parameters of a newly created pipeline depth stencil state.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-depthBounds">depth bounds testing</a> feature is not enabled, {@code depthBoundsTestEnable} <b>must</b> be {@link VK10#VK_FALSE FALSE}</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK10#VK_STRUCTURE_TYPE_PIPELINE_DEPTH_STENCIL_STATE_CREATE_INFO STRUCTURE_TYPE_PIPELINE_DEPTH_STENCIL_STATE_CREATE_INFO}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL}</li>
 * <li>{@code flags} <b>must</b> be 0</li>
 * <li>{@code depthCompareOp} <b>must</b> be a valid {@code VkCompareOp} value</li>
 * <li>{@code front} <b>must</b> be a valid {@link VkStencilOpState} structure</li>
 * <li>{@code back} <b>must</b> be a valid {@link VkStencilOpState} structure</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkGraphicsPipelineCreateInfo}, {@link VkStencilOpState}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code flags} &ndash; reserved for future use.</li>
 * <li>{@code depthTestEnable} &ndash; controls whether <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#fragops-depth">depth testing</a> is enabled.</li>
 * <li>{@code depthWriteEnable} &ndash; controls whether <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#fragops-depth-write">depth writes</a> are enabled when {@code depthTestEnable} is {@link VK10#VK_TRUE TRUE}. Depth writes are always disabled when {@code depthTestEnable} is {@link VK10#VK_FALSE FALSE}.</li>
 * <li>{@code depthCompareOp} &ndash; the comparison operator used in the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#fragops-depth">depth test</a>.</li>
 * <li>{@code depthBoundsTestEnable} &ndash; controls whether <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#fragops-dbt">depth bounds testing</a> is enabled.</li>
 * <li>{@code stencilTestEnable} &ndash; controls whether <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#fragops-stencil">stencil testing</a> is enabled.</li>
 * <li>{@code front} &ndash; {@code front} and {@code back} control the parameters of the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#fragops-stencil">stencil test</a>.</li>
 * <li>{@code back} &ndash; see {@code front}</li>
 * <li>{@code minDepthBounds} &ndash; {@code minDepthBounds} and {@code maxDepthBounds} define the range of values used in the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#fragops-dbt">depth bounds test</a>.</li>
 * <li>{@code maxDepthBounds} &ndash; see {@code minDepthBounds}</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPipelineDepthStencilStateCreateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkPipelineDepthStencilStateCreateFlags flags;
 *     VkBool32 depthTestEnable;
 *     VkBool32 depthWriteEnable;
 *     VkCompareOp depthCompareOp;
 *     VkBool32 depthBoundsTestEnable;
 *     VkBool32 stencilTestEnable;
 *     {@link VkStencilOpState VkStencilOpState} front;
 *     {@link VkStencilOpState VkStencilOpState} back;
 *     float minDepthBounds;
 *     float maxDepthBounds;
 * }</code></pre>
 */
class PipelineDepthStencilStateCreateInfo(
    var depthTestEnable: Boolean = false,
    var depthWriteEnable: Boolean = false,
    var depthCompareOp: VkCompareOp = VkCompareOp.NEVER,
    var depthBoundsTestEnable: Boolean = false,
    var stencilTestEnable: Boolean = false,
    var front: StencilOpState = StencilOpState(),
    var back: StencilOpState = front,
    var minDepthBounds: Float = 0f,
    var maxDepthBounds: Float = 0f
) {

    val type get() = VkStructureType.PIPELINE_DEPTH_STENCIL_STATE_CREATE_INFO

    val MemoryStack.native: Ptr
        get() = ncalloc(ALIGNOF, 1, SIZEOF).also {
            nsType(it, type.i)
            ndepthTestEnable(it, depthTestEnable.i)
            ndepthWriteEnable(it, depthWriteEnable.i)
            ndepthCompareOp(it, depthCompareOp.i)
            ndepthBoundsTestEnable(it, depthBoundsTestEnable.i)
            nstencilTestEnable(it, stencilTestEnable.i)
            front.toPtr(it + FRONT)
            back.toPtr(it + BACK)
            nminDepthBounds(it, minDepthBounds)
            nmaxDepthBounds(it, maxDepthBounds)
        }
}