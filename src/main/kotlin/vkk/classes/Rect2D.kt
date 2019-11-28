package vkk.classes

import glm_.vec2.Vec2i
import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkRect2D.*

/**
 * Structure specifying a two-dimensional subregion.
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code offset} &ndash; a {@link VkOffset2D} specifying the rectangle offset.</li>
 * <li>{@code extent} &ndash; a {@link VkExtent2D} specifying the rectangle extent.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkRect2D {
 *     {@link VkOffset2D VkOffset2D} offset;
 *     {@link VkExtent2D VkExtent2D} extent;
 * }</code></pre>
 */
class Rect2D(
    var offset: Offset2D = Offset2D(),
    var extent: Extent2D
) {

    constructor(size: Vec2i) : this(extent = Extent2D(size))

    infix fun write(stack: MemoryStack): Adr =
        stack.ncalloc(ALIGNOF, 1, SIZEOF).also { write(it) }

    infix fun write(ptr: Ptr) {
        offset write ptr
        extent.write(ptr + EXTENT)
    }
}

infix fun Array<Rect2D>.write(stack: MemoryStack): Ptr {
    val natives = stack.ncalloc(ALIGNOF, size, SIZEOF)
    for (i in indices)
        this[i] write (natives + i * SIZEOF)
    return natives
}