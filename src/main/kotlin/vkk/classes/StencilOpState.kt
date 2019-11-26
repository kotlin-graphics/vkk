package classes

import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkStencilOpState.*
import vkk.VkCompareOp
import vkk.VkStencilOp

/**
 * Structure specifying stencil operation state.
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code failOp} <b>must</b> be a valid {@code VkStencilOp} value</li>
 * <li>{@code passOp} <b>must</b> be a valid {@code VkStencilOp} value</li>
 * <li>{@code depthFailOp} <b>must</b> be a valid {@code VkStencilOp} value</li>
 * <li>{@code compareOp} <b>must</b> be a valid {@code VkCompareOp} value</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkPipelineDepthStencilStateCreateInfo}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code failOp} &ndash; a {@code VkStencilOp} value specifying the action performed on samples that fail the stencil test.</li>
 * <li>{@code passOp} &ndash; a {@code VkStencilOp} value specifying the action performed on samples that pass both the depth and stencil tests.</li>
 * <li>{@code depthFailOp} &ndash; a {@code VkStencilOp} value specifying the action performed on samples that pass the stencil test and fail the depth test.</li>
 * <li>{@code compareOp} &ndash; a {@code VkCompareOp} value specifying the comparison operator used in the stencil test.</li>
 * <li>{@code compareMask} &ndash; selects the bits of the unsigned integer stencil values participating in the stencil test.</li>
 * <li>{@code writeMask} &ndash; selects the bits of the unsigned integer stencil values updated by the stencil test in the stencil framebuffer attachment.</li>
 * <li>{@code reference} &ndash; an integer reference value that is used in the unsigned stencil comparison.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkStencilOpState {
 *     VkStencilOp failOp;
 *     VkStencilOp passOp;
 *     VkStencilOp depthFailOp;
 *     VkCompareOp compareOp;
 *     uint32_t compareMask;
 *     uint32_t writeMask;
 *     uint32_t reference;
 * }</code></pre>
 */
class StencilOpState(
    var failOp: VkStencilOp = VkStencilOp.KEEP,
    var passOp: VkStencilOp = VkStencilOp.KEEP,
    var depthFailOp: VkStencilOp = VkStencilOp.KEEP,
    var compareOp: VkCompareOp = VkCompareOp.NEVER,
    var compareMask: Int = 0,
    var writeMask: Int = 0,
    var reference: Int = 0
) {

    val MemoryStack.native: Ptr
        get() = ncalloc(ALIGNOF, 1, SIZEOF).also { toPtr(it) }

    infix fun toPtr(ptr: Ptr) {
        nfailOp(ptr, failOp.i)
        npassOp(ptr, passOp.i)
        ndepthFailOp(ptr, depthFailOp.i)
        ncompareOp(ptr, compareOp.i)
        ncompareMask(ptr, compareMask)
        nwriteMask(ptr, writeMask)
        nreference(ptr, reference)
    }
}