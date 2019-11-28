package vkk.classes

import glm_.vec3.Vec3i
import kool.Adr
import kool.IntPtr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkClearValue
import org.lwjgl.vulkan.VkOffset3D.*

/**
 * Structure specifying a three-dimensional offset.
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code x} &ndash; the x offset.</li>
 * <li>{@code y} &ndash; the y offset.</li>
 * <li>{@code z} &ndash; the z offset.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkOffset3D {
 *     int32_t x;
 *     int32_t y;
 *     int32_t z;
 * }</code></pre>
 */
class Offset3D(
    var x: Int = 0,
    var y: Int = 0,
    var z: Int = 0
) {

    constructor(v: Vec3i) : this(v.x, v.y, v.z)

    infix fun write(adr: Adr) {
        nx(adr, x)
        ny(adr, y)
        nz(adr, z)
    }
}

infix fun Array<Offset3D>.write(stack: MemoryStack): Ptr =
    stack.ncalloc(ALIGNOF, size, SIZEOF).also { write(it) }

infix fun Array<Offset3D>.write(adr: Adr) {
    for (i in indices)
        this[i] write (adr + i * SIZEOF)
}