package vkk.classes

import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkVertexInputBindingDescription.*
import vkk.VkVertexInputRate

/**
 * Structure specifying vertex input binding description.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code binding} <b>must</b> be less than {@link VkPhysicalDeviceLimits}{@code ::maxVertexInputBindings}</li>
 * <li>{@code stride} <b>must</b> be less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxVertexInputBindingStride}</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code inputRate} <b>must</b> be a valid {@code VkVertexInputRate} value</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkPipelineVertexInputStateCreateInfo}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code binding} &ndash; the binding number that this structure describes.</li>
 * <li>{@code stride} &ndash; the distance in bytes between two consecutive elements within the buffer.</li>
 * <li>{@code inputRate} &ndash; a {@code VkVertexInputRate} value specifying whether vertex attribute addressing is a function of the vertex index or of the instance index.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkVertexInputBindingDescription {
 *     uint32_t binding;
 *     uint32_t stride;
 *     VkVertexInputRate inputRate;
 * }</code></pre>
 */
class VertexInputBindingDescription(
    var binding: Int,
    var stride: Int,
    var inputRate: VkVertexInputRate
) {

    infix fun write(ptr: Ptr) {
        nbinding(ptr, binding)
        nstride(ptr, stride)
        ninputRate(ptr, inputRate.i)
    }
}

infix fun Array<VertexInputBindingDescription>.write(stack: MemoryStack): Ptr {
    val natives = stack.ncalloc(ALIGNOF, size, SIZEOF)
    for (i in indices)
        this[i] write (natives + i * SIZEOF)
    return natives
}