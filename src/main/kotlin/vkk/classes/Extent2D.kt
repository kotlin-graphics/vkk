package classes

import glm_.vec2.Vec2i
import kool.Ptr
import org.lwjgl.vulkan.VkExtent2D
import org.lwjgl.vulkan.VkExtent2D.*

/**
 * Structure specifying a two-dimensional extent.
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code width} &ndash; the width of the extent.</li>
 * <li>{@code height} &ndash; the height of the extent.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkExtent2D {
 *     uint32_t width;
 *     uint32_t height;
 * }</code></pre>
 */
class Extent2D(
    var width: Int,
    var height: Int
) {

    constructor(size: Vec2i) : this(size.x, size.y)
    constructor(ptr: Ptr) : this(nwidth(ptr), nheight(ptr))

    var size: Vec2i
        get() = Vec2i(width, height)
        set(value) {
            width = value.x
            height = value.y
        }

    infix fun toPtr(ptr: Ptr) {
        nwidth(ptr, width)
        nheight(ptr, height)
    }
}