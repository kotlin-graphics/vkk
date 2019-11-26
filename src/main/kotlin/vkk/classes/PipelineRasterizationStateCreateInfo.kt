package classes

import glm_.i
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.vulkan.VkPipelineRasterizationStateCreateInfo
import org.lwjgl.vulkan.VkPipelineRasterizationStateCreateInfo.*
import vkk.VkCullModeFlags
import vkk.VkFrontFace
import vkk.VkPolygonMode
import vkk.VkStructureType

/**
 * Structure specifying parameters of a newly created pipeline rasterization state.
 *
 * <h5>Description</h5>
 *
 * <p>The application <b>can</b> also add a {@link VkPipelineRasterizationStateRasterizationOrderAMD} structure to the {@code pNext} chain of a {@link VkPipelineRasterizationStateCreateInfo} structure. This structure enables selecting the rasterization order to use when rendering with the corresponding graphics pipeline as described in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#primrast-order">Rasterization Order</a>.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-depthClamp">depth clamping</a> feature is not enabled, {@code depthClampEnable} <b>must</b> be {@link VK10#VK_FALSE FALSE}</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-fillModeNonSolid">non-solid fill modes</a> feature is not enabled, {@code polygonMode} <b>must</b> be {@link VK10#VK_POLYGON_MODE_FILL POLYGON_MODE_FILL} or {@link NVFillRectangle#VK_POLYGON_MODE_FILL_RECTANGLE_NV POLYGON_MODE_FILL_RECTANGLE_NV}</li>
 * <li>If the {@link NVFillRectangle VK_NV_fill_rectangle} extension is not enabled, {@code polygonMode} <b>must</b> not be {@link NVFillRectangle#VK_POLYGON_MODE_FILL_RECTANGLE_NV POLYGON_MODE_FILL_RECTANGLE_NV}</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK10#VK_STRUCTURE_TYPE_PIPELINE_RASTERIZATION_STATE_CREATE_INFO STRUCTURE_TYPE_PIPELINE_RASTERIZATION_STATE_CREATE_INFO}</li>
 * <li>Each {@code pNext} member of any structure (including this one) in the {@code pNext} chain <b>must</b> be either {@code NULL} or a pointer to a valid instance of {@link VkPipelineRasterizationConservativeStateCreateInfoEXT}, {@link VkPipelineRasterizationDepthClipStateCreateInfoEXT}, {@link VkPipelineRasterizationLineStateCreateInfoEXT}, {@link VkPipelineRasterizationStateRasterizationOrderAMD}, or {@link VkPipelineRasterizationStateStreamCreateInfoEXT}</li>
 * <li>Each {@code sType} member in the {@code pNext} chain <b>must</b> be unique</li>
 * <li>{@code flags} <b>must</b> be 0</li>
 * <li>{@code polygonMode} <b>must</b> be a valid {@code VkPolygonMode} value</li>
 * <li>{@code cullMode} <b>must</b> be a valid combination of {@code VkCullModeFlagBits} values</li>
 * <li>{@code frontFace} <b>must</b> be a valid {@code VkFrontFace} value</li>
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
 * <li>{@code depthClampEnable} &ndash; controls whether to clamp the fragment&#8217;s depth values as described in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#fragops-depth">Depth Test</a>. If the pipeline is not created with {@link VkPipelineRasterizationDepthClipStateCreateInfoEXT} present then enabling depth clamp will also disable clipping primitives to the z planes of the frustrum as described in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#vertexpostproc-clipping">Primitive Clipping</a>. Otherwise depth clipping is controlled by the state set in {@link VkPipelineRasterizationDepthClipStateCreateInfoEXT}.</li>
 * <li>{@code rasterizerDiscardEnable} &ndash; controls whether primitives are discarded immediately before the rasterization stage.</li>
 * <li>{@code polygonMode} &ndash; the triangle rendering mode. See {@code VkPolygonMode}.</li>
 * <li>{@code cullMode} &ndash; the triangle facing direction used for primitive culling. See {@code VkCullModeFlagBits}.</li>
 * <li>{@code frontFace} &ndash; a {@code VkFrontFace} value specifying the front-facing triangle orientation to be used for culling.</li>
 * <li>{@code depthBiasEnable} &ndash; controls whether to bias fragment depth values.</li>
 * <li>{@code depthBiasConstantFactor} &ndash; a scalar factor controlling the constant depth value added to each fragment.</li>
 * <li>{@code depthBiasClamp} &ndash; the maximum (or minimum) depth bias of a fragment.</li>
 * <li>{@code depthBiasSlopeFactor} &ndash; a scalar factor applied to a fragment&#8217;s slope in depth bias calculations.</li>
 * <li>{@code lineWidth} &ndash; the width of rasterized line segments.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPipelineRasterizationStateCreateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkPipelineRasterizationStateCreateFlags flags;
 *     VkBool32 depthClampEnable;
 *     VkBool32 rasterizerDiscardEnable;
 *     VkPolygonMode polygonMode;
 *     VkCullModeFlags cullMode;
 *     VkFrontFace frontFace;
 *     VkBool32 depthBiasEnable;
 *     float depthBiasConstantFactor;
 *     float depthBiasClamp;
 *     float depthBiasSlopeFactor;
 *     float lineWidth;
 * }</code></pre>
 */
class PipelineRasterizationStateCreateInfo(
    var depthClampEnable: Boolean = false,
    var rasterizerDiscardEnable: Boolean = false,
    var polygonMode: VkPolygonMode = VkPolygonMode.FILL,
    var cullMode: VkCullModeFlags,
    var frontFace: VkFrontFace,
    var depthBiasEnable: Boolean = false,
    var depthBiasConstantFactor: Float = 0f,
    var depthBiasClamp: Float = 0f,
    var depthBiasSlopeFactor: Float = 0f,
    var lineWidth: Float = 1f,
    var next: Ptr = NULL
) {

    val type get() = VkStructureType.PIPELINE_RASTERIZATION_STATE_CREATE_INFO

    val MemoryStack.native: Ptr
        get() = ncalloc(ALIGNOF, 1, SIZEOF).also {
            nsType(it, type.i)
            npNext(it, next)
            ndepthClampEnable(it, depthClampEnable.i)
            nrasterizerDiscardEnable(it, rasterizerDiscardEnable.i)
            npolygonMode(it, polygonMode.i)
            ncullMode(it, cullMode)
            nfrontFace(it, frontFace.i)
            ndepthBiasEnable(it, depthBiasEnable.i)
            ndepthBiasConstantFactor(it, depthBiasConstantFactor)
            ndepthBiasClamp(it, depthBiasClamp)
            ndepthBiasSlopeFactor(it, depthBiasSlopeFactor)
            nlineWidth(it, lineWidth)
        }
}