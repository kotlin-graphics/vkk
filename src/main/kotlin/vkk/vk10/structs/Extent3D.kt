package vkk.vk10.structs

import glm_.vec2.Vec2i
import kool.Adr
import kool.IntPtr
import org.lwjgl.system.MemoryStack
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

    constructor(intPtr: IntPtr) : this(intPtr[0], intPtr[1], intPtr[2])
    constructor(xy: Vec2i, z: Int) : this(xy.x, xy.y, z)
    constructor(extent2D: Extent2D, depth: Int) : this(extent2D.width, extent2D.height, depth)

    infix fun write(stack: MemoryStack): Adr =
            stack.ncalloc(ALIGNOF, 1, SIZEOF).also { write(it) }

    infix fun write(adr: Adr) {
        nwidth(adr, width)
        nheight(adr, height)
        ndepth(adr, depth)
    }
}