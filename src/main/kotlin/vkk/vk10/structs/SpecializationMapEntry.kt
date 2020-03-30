package vkk.vk10.structs

import kool.Adr
import kool.Ptr
import org.lwjgl.vulkan.VkSpecializationMapEntry.*
import vkk.VkStack

/**
 * Structure specifying a specialization map entry.
 *
 * <h5>Description</h5>
 *
 * <p>If a {@code constantID} value is not a specialization constant ID used in the shader, that map entry does not affect the behavior of the pipeline.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>For a {@code constantID} specialization constant declared in a shader, {@code size} <b>must</b> match the byte size of the {@code constantID}. If the specialization constant is of type {@code boolean}, {@code size} <b>must</b> be the byte size of {@code VkBool32}</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkSpecializationInfo}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code constantID} &ndash; the ID of the specialization constant in SPIR-V.</li>
 * <li>{@code offset} &ndash; the byte offset of the specialization constant value within the supplied data buffer.</li>
 * <li>{@code size} &ndash; the byte size of the specialization constant value within the supplied data buffer.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkSpecializationMapEntry {
 *     uint32_t constantID;
 *     uint32_t offset;
 *     size_t size;
 * }</code></pre>
 */
class SpecializationMapEntry(
    var constantID: Int,
    var offset: Int,
    var size: Long
) {

    infix fun write(adr: Adr) {
        nconstantID(adr, constantID)
        noffset(adr, offset)
        nsize(adr, size)
    }
}

infix fun Array<SpecializationMapEntry>.write(stack: VkStack): Ptr {
    val natives = stack.ncalloc(ALIGNOF, size, SIZEOF)
    for (i in indices)
        this[i] write (natives + i * SIZEOF)
    return natives
}