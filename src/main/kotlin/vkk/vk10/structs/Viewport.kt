package vkk.vk10.structs

import glm_.f
import glm_.vec2.Vec2t
import kool.Adr
import kool.Ptr
import org.lwjgl.vulkan.VkViewport.*
import vkk.VkStack

/**
 * Structure specifying a viewport.
 *
 * <h5>Description</h5>
 *
 * <p>The framebuffer depth coordinate <code>z<sub>f</sub></code> <b>may</b> be represented using either a fixed-point or floating-point representation. However, a floating-point representation <b>must</b> be used if the depth/stencil attachment has a floating-point depth component. If an <code>m</code>-bit fixed-point representation is used, we assume that it represents each value <code>k / (2<sup>m</sup> - 1)</code>, where <code>k ∈ { 0, 1, ..., 2<sup>m</sup>-1 }</code>, as <code>k</code> (e.g. 1.0 is represented in binary as a string of all ones).</p>
 *
 * <p>The viewport parameters shown in the above equations are found from these values as</p>
 *
 * <dl>
 * <dd><code>o<sub>x</sub> = x + width / 2</code></dd>
 * <dd><code>o<sub>y</sub> = y + height / 2</code></dd>
 * <dd><code>o<sub>z</sub> = minDepth</code></dd>
 * <dd><code>p<sub>x</sub> = width</code></dd>
 * <dd><code>p<sub>y</sub> = height</code></dd>
 * <dd><code>p<sub>z</sub> = maxDepth - minDepth</code>.</dd>
 * </dl>
 *
 * <p>The application <b>can</b> specify a negative term for {@code height}, which has the effect of negating the y coordinate in clip space before performing the transform. When using a negative {@code height}, the application <b>should</b> also adjust the {@code y} value to point to the lower left corner of the viewport instead of the upper left corner. Using the negative {@code height} allows the application to avoid having to negate the y component of the {@code Position} output from the last vertex processing stage in shaders that also target other graphics APIs.</p>
 *
 * <p>The width and height of the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#limits-maxViewportDimensions">implementation-dependent maximum viewport dimensions</a> <b>must</b> be greater than or equal to the width and height of the largest image which <b>can</b> be created and attached to a framebuffer.</p>
 *
 * <p>The floating-point viewport bounds are represented with an <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#limits-viewportSubPixelBits">implementation-dependent precision</a>.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code width} <b>must</b> be greater than {@code 0.0}</li>
 * <li>{@code width} <b>must</b> be less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxViewportDimensions}[0]</li>
 * <li>The absolute value of {@code height} <b>must</b> be less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxViewportDimensions}[1]</li>
 * <li>{@code x} <b>must</b> be greater than or equal to {@code viewportBoundsRange}[0]</li>
 * <li><code>(x + width)</code> <b>must</b> be less than or equal to {@code viewportBoundsRange}[1]</li>
 * <li>{@code y} <b>must</b> be greater than or equal to {@code viewportBoundsRange}[0]</li>
 * <li>{@code y} <b>must</b> be less than or equal to {@code viewportBoundsRange}[1]</li>
 * <li><code>(y + height)</code> <b>must</b> be greater than or equal to {@code viewportBoundsRange}[0]</li>
 * <li><code>(y + height)</code> <b>must</b> be less than or equal to {@code viewportBoundsRange}[1]</li>
 * <li>Unless {@link EXTDepthRangeUnrestricted VK_EXT_depth_range_unrestricted} extension is enabled {@code minDepth} <b>must</b> be between {@code 0.0} and {@code 1.0}, inclusive</li>
 * <li>Unless {@link EXTDepthRangeUnrestricted VK_EXT_depth_range_unrestricted} extension is enabled {@code maxDepth} <b>must</b> be between {@code 0.0} and {@code 1.0}, inclusive</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkPipelineViewportStateCreateInfo}, {@link VK10#vkCmdSetViewport CmdSetViewport}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code x} &ndash; {@code x} and {@code y} are the viewport&#8217;s upper left corner <code>(x,y)</code>.</li>
 * <li>{@code y} &ndash; see {@code x}</li>
 * <li>{@code width} &ndash; {@code width} and {@code height} are the viewport&#8217;s width and height, respectively.</li>
 * <li>{@code height} &ndash; see {@code width}</li>
 * <li>{@code minDepth} &ndash; {@code minDepth} and {@code maxDepth} are the depth range for the viewport. It is valid for {@code minDepth} to be greater than or equal to {@code maxDepth}.</li>
 * <li>{@code maxDepth} &ndash; see {@code minDepth}</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkViewport {
 *     float x;
 *     float y;
 *     float width;
 *     float height;
 *     float minDepth;
 *     float maxDepth;
 * }</code></pre>
 */
class Viewport(
    var x: Float = 0f,
    var y: Float = 0f,
    var width: Float,
    var height: Float,
    var minDepth: Float = 0f,
    var maxDepth: Float = 1f
) {

    constructor(size: Vec2t<out Number>) : this(width = size.x.f, height = size.y.f)

    infix fun write(stack: VkStack): Adr =
        stack.ncalloc(ALIGNOF, 1, SIZEOF).also { write(it) }

    infix fun write(adr: Adr) {
        nx(adr, x)
        ny(adr, y)
        nwidth(adr, width)
        nheight(adr, height)
        nminDepth(adr, minDepth)
        nmaxDepth(adr, maxDepth)
    }
}

infix fun Array<Viewport>.write(stack: VkStack): Ptr {
    val natives = stack.ncalloc(ALIGNOF, size, SIZEOF)
    for (i in indices)
        this[i] write (natives + i * SIZEOF)
    return natives
}