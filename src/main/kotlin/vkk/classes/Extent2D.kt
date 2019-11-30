package vkk.classes

import glm_.vec2.Vec2i
import kool.BytePtr
import kool.IntPtr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkExtent2D.*
import org.lwjgl.vulkan.VkSurfaceCapabilitiesKHR
import vkk.stak

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
    constructor(intPtr: IntPtr) : this(intPtr[0], intPtr[1])

    var size: Vec2i
        get() = Vec2i(width, height)
        set(value) {
            width = value.x
            height = value.y
        }

    infix fun write(ptr: Ptr) {
        nwidth(ptr, width)
        nheight(ptr, height)
    }

    companion object {
        inline fun <R> read(block: (Ptr) -> R): Extent2D = stak { read(it, block) }
        inline fun <R> read(stack: MemoryStack, block: (Ptr) -> R): Extent2D {
            val ptr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
            block(ptr)
            return Extent2D(IntPtr(ptr))
        }
    }
}