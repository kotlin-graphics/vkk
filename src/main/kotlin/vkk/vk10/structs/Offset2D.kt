package vkk.vk10.structs

import glm_.vec2.Vec2i
import kool.IntPtr
import kool.Ptr
import org.lwjgl.vulkan.VkOffset2D.nx
import org.lwjgl.vulkan.VkOffset2D.ny

/**
 * Structure specifying a two-dimensional offset.
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code x} &ndash; the x offset.</li>
 * <li>{@code y} &ndash; the y offset.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkOffset2D {
 *     int32_t x;
 *     int32_t y;
 * }</code></pre>
 */
class Offset2D(
    var x: Int = 0,
    var y: Int = 0
) {

    constructor(v: Vec2i) : this(v.x, v.y)
    constructor(ptr: IntPtr) : this(ptr[0], ptr[1])

    infix fun write(ptr: Ptr) {
        nx(ptr, x)
        ny(ptr, y)
    }
}