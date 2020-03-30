package vkk.vk10.structs

import kool.Ptr
import org.lwjgl.vulkan.VkVertexInputAttributeDescription.*
import vkk.VkFormat
import vkk.VkStack

/**
 * Structure specifying vertex input attribute description.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code location} <b>must</b> be less than {@link VkPhysicalDeviceLimits}{@code ::maxVertexInputAttributes}</li>
 * <li>{@code binding} <b>must</b> be less than {@link VkPhysicalDeviceLimits}{@code ::maxVertexInputBindings}</li>
 * <li>{@code offset} <b>must</b> be less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxVertexInputAttributeOffset}</li>
 * <li>{@code format} <b>must</b> be allowed as a vertex buffer format, as specified by the {@link VK10#VK_FORMAT_FEATURE_VERTEX_BUFFER_BIT FORMAT_FEATURE_VERTEX_BUFFER_BIT} flag in {@link VkFormatProperties}{@code ::bufferFeatures} returned by {@code vkGetPhysicalDeviceFormatProperties}</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code format} <b>must</b> be a valid {@code VkFormat} value</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkPipelineVertexInputStateCreateInfo}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code location} &ndash; the shader binding location number for this attribute.</li>
 * <li>{@code binding} &ndash; the binding number which this attribute takes its data from.</li>
 * <li>{@code format} &ndash; the size and type of the vertex attribute data.</li>
 * <li>{@code offset} &ndash; a byte offset of this attribute relative to the start of an element in the vertex input binding.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkVertexInputAttributeDescription {
 *     uint32_t location;
 *     uint32_t binding;
 *     VkFormat format;
 *     uint32_t offset;
 * }</code></pre>
 */
class VertexInputAttributeDescription(
    var location: Int,
    var binding: Int,
    var format: VkFormat,
    var offset: Int = 0
) {

    infix fun write(ptr: Ptr) {
        nlocation(ptr, location)
        nbinding(ptr, binding)
        nformat(ptr, format.i)
        noffset(ptr, offset)
    }
}

infix fun Array<VertexInputAttributeDescription>.write(stack: VkStack): Ptr {
    val natives = stack.ncalloc(ALIGNOF, size, SIZEOF)
    for (i in indices)
        this[i] write (natives + i * SIZEOF)
    return natives
}