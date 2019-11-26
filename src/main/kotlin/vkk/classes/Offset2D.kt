package classes

import kool.Ptr
import org.lwjgl.vulkan.VkOffset2D
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

    infix fun toPtr(ptr: Ptr) {
        nx(ptr, x)
        ny(ptr, y)
    }
}