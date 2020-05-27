package vkk.vk11.structs

import kool.Ptr
import org.lwjgl.system.MemoryUtil.NULL
import vkk.VkStructureType

/**
 * Structure containing multiview info for all subpasses.
 *
 * <h5>Description</h5>
 *
 * <p>When a subpass uses a non-zero view mask, <em>multiview</em> functionality is considered to be enabled. Multiview is all-or-nothing for a render pass - that is, either all subpasses <b>must</b> have a non-zero view mask (though some subpasses <b>may</b> have only one view) or all <b>must</b> be zero. Multiview causes all drawing and clear commands in the subpass to behave as if they were broadcast to each view, where a view is represented by one layer of the framebuffer attachments. All draws and clears are broadcast to each <em>view index</em> whose bit is set in the view mask. The view index is provided in the {@code ViewIndex} shader input variable, and color, depth/stencil, and input attachments all read/write the layer of the framebuffer corresponding to the view index.</p>
 *
 * <p>If the view mask is zero for all subpasses, multiview is considered to be disabled and all drawing commands execute normally, without this additional broadcasting.</p>
 *
 * <p>Some implementations <b>may</b> not support multiview in conjunction with <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-multiview-gs">geometry shaders</a> or <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-multiview-tess">tessellation shaders</a>.</p>
 *
 * <p>When multiview is enabled, the {@link VK11#VK_DEPENDENCY_VIEW_LOCAL_BIT DEPENDENCY_VIEW_LOCAL_BIT} bit in a dependency <b>can</b> be used to express a view-local dependency, meaning that each view in the destination subpass depends on a single view in the source subpass. Unlike pipeline barriers, a subpass dependency <b>can</b> potentially have a different view mask in the source subpass and the destination subpass. If the dependency is view-local, then each view (<code>dstView</code>) in the destination subpass depends on the view <code>dstView + pViewOffsets[dependency]</code> in the source subpass. If there is not such a view in the source subpass, then this dependency does not affect that view in the destination subpass. If the dependency is not view-local, then all views in the destination subpass depend on all views in the source subpass, and the view offset is ignored. A non-zero view offset is not allowed in a self-dependency.</p>
 *
 * <p>The elements of {@code pCorrelationMasks} are a set of masks of views indicating that views in the same mask <b>may</b> exhibit spatial coherency between the views, making it more efficient to render them concurrently. Correlation masks <b>must</b> not have a functional effect on the results of the multiview rendering.</p>
 *
 * <p>When multiview is enabled, at the beginning of each subpass all non-render pass state is undefined. In particular, each time {@link VK10#vkCmdBeginRenderPass CmdBeginRenderPass} or {@link VK10#vkCmdNextSubpass CmdNextSubpass} is called the graphics pipeline <b>must</b> be bound, any relevant descriptor sets or vertex/index buffers <b>must</b> be bound, and any relevant dynamic state or push constants <b>must</b> be set before they are used.</p>
 *
 * <p>A multiview subpass <b>can</b> declare that its shaders will write per-view attributes for all views in a single invocation, by setting the {@link NVXMultiviewPerViewAttributes#VK_SUBPASS_DESCRIPTION_PER_VIEW_ATTRIBUTES_BIT_NVX SUBPASS_DESCRIPTION_PER_VIEW_ATTRIBUTES_BIT_NVX} bit in the subpass description. The only supported per-view attributes are position and viewport mask, and per-view position and viewport masks are written to output array variables decorated with {@code PositionPerViewNV} and {@code ViewportMaskPerViewNV}, respectively. If {@link NVViewportArray2 VK_NV_viewport_array2} is not supported and enabled, {@code ViewportMaskPerViewNV} <b>must</b> not be used. Values written to elements of {@code PositionPerViewNV} and {@code ViewportMaskPerViewNV} <b>must</b> not depend on the {@code ViewIndex}. The shader <b>must</b> also write to an output variable decorated with {@code Position}, and the value written to {@code Position} <b>must</b> equal the value written to {@code PositionPerViewNV}[{@code ViewIndex}]. Similarly, if {@code ViewportMaskPerViewNV} is written to then the shader <b>must</b> also write to an output variable decorated with {@code ViewportMaskNV}, and the value written to {@code ViewportMaskNV} <b>must</b> equal the value written to {@code ViewportMaskPerViewNV}[{@code ViewIndex}]. Implementations will either use values taken from {@code Position} and {@code ViewportMaskNV} and invoke the shader once for each view, or will use values taken from {@code PositionPerViewNV} and {@code ViewportMaskPerViewNV} and invoke the shader fewer times. The values written to {@code Position} and {@code ViewportMaskNV} <b>must</b> not depend on the values written to {@code PositionPerViewNV} and {@code ViewportMaskPerViewNV}, or vice versa (to allow compilers to eliminate the unused outputs). All attributes that do not have {@code *PerViewNV} counterparts <b>must</b> not depend on {@code ViewIndex}.</p>
 *
 * <p>Per-view attributes are all-or-nothing for a subpass. That is, all pipelines compiled against a subpass that includes the {@link NVXMultiviewPerViewAttributes#VK_SUBPASS_DESCRIPTION_PER_VIEW_ATTRIBUTES_BIT_NVX SUBPASS_DESCRIPTION_PER_VIEW_ATTRIBUTES_BIT_NVX} bit <b>must</b> write per-view attributes to the {@code *PerViewNV[]} shader outputs, in addition to the non-per-view (e.g. {@code Position}) outputs. Pipelines compiled against a subpass that does not include this bit <b>must</b> not include the {@code *PerViewNV[]} outputs in their interfaces.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>Each view index <b>must</b> not be set in more than one element of {@code pCorrelationMasks}</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_RENDER_PASS_MULTIVIEW_CREATE_INFO STRUCTURE_TYPE_RENDER_PASS_MULTIVIEW_CREATE_INFO}</li>
 * <li>If {@code subpassCount} is not 0, {@code pViewMasks} <b>must</b> be a valid pointer to an array of {@code subpassCount} {@code uint32_t} values</li>
 * <li>If {@code dependencyCount} is not 0, {@code pViewOffsets} <b>must</b> be a valid pointer to an array of {@code dependencyCount} {@code int32_t} values</li>
 * <li>If {@code correlationMaskCount} is not 0, {@code pCorrelationMasks} <b>must</b> be a valid pointer to an array of {@code correlationMaskCount} {@code uint32_t} values</li>
 * </ul>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code subpassCount} &ndash; zero or is the number of subpasses in the render pass.</li>
 * <li>{@code pViewMasks} &ndash; points to an array of {@code subpassCount} number of view masks, where each mask is a bitfield of view indices describing which views rendering is broadcast to in each subpass, when multiview is enabled. If {@code subpassCount} is zero, each view mask is treated as zero.</li>
 * <li>{@code dependencyCount} &ndash; zero or the number of dependencies in the render pass.</li>
 * <li>{@code pViewOffsets} &ndash; points to an array of {@code dependencyCount} view offsets, one for each dependency. If {@code dependencyCount} is zero, each dependency&#8217;s view offset is treated as zero. Each view offset controls which views in the source subpass the views in the destination subpass depend on.</li>
 * <li>{@code correlationMaskCount} &ndash; zero or a number of correlation masks.</li>
 * <li>{@code pCorrelationMasks} &ndash; an array of view masks indicating sets of views that <b>may</b> be more efficient to render concurrently.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkRenderPassMultiviewCreateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     uint32_t subpassCount;
 *     uint32_t const * pViewMasks;
 *     uint32_t dependencyCount;
 *     int32_t const * pViewOffsets;
 *     uint32_t correlationMaskCount;
 *     uint32_t const * pCorrelationMasks;
 * }</code></pre>
 */
class RenderPassMultiviewCreateInfo(
    var viewMasks: IntArray? = null,
    var viewOffsets: IntArray? = null,
    var correlationMasks: IntArray? = null,
    var next: Ptr = NULL
) {

    val type get() = VkStructureType.RENDER_PASS_MULTIVIEW_CREATE_INFO
}