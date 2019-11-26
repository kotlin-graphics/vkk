package classes

import kool.Ptr
import org.lwjgl.vulkan.VkExtent3D.*

/**
 * Structure specifying a three-dimensional extent.
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code width} &ndash; the width of the extent.</li>
 * <li>{@code height} &ndash; the height of the extent.</li>
 * <li>{@code depth} &ndash; the depth of the extent.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkExtent3D {
 *     uint32_t width;
 *     uint32_t height;
 *     uint32_t depth;
 * }</code></pre>
 */
class Extent3D(
    val width: Int,
    var height: Int,
    var depth: Int
) {

    constructor(ptr: Ptr) : this(nwidth(ptr), nheight(ptr), ndepth(ptr))
}