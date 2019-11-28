package vkk.classes

import kool.Adr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkBufferViewCreateInfo.*
import vkk.VkFormat
import vkk.VkStructureType
import vkk.entities.VkBuffer
import vkk.entities.VkDeviceSize

/**
 * Structure specifying parameters of a newly created buffer view.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code offset} <b>must</b> be less than the size of {@code buffer}</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-texelBufferAlignment">texelBufferAlignment</a> feature is not enabled, {@code offset} <b>must</b> be a multiple of {@link VkPhysicalDeviceLimits}{@code ::minTexelBufferOffsetAlignment}</li>
 * <li>If {@code range} is not equal to {@link VK10#VK_WHOLE_SIZE WHOLE_SIZE}, {@code range} <b>must</b> be greater than 0</li>
 * <li>If {@code range} is not equal to {@link VK10#VK_WHOLE_SIZE WHOLE_SIZE}, {@code range} <b>must</b> be an integer multiple of the texel block size of {@code format}</li>
 * <li>If {@code range} is not equal to {@link VK10#VK_WHOLE_SIZE WHOLE_SIZE}, {@code range} divided by the texel block size of {@code format}, multiplied by the number of texels per texel block for that format (as defined in the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#formats-compatibility">Compatible Formats</a> table), <b>must</b> be less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxTexelBufferElements}</li>
 * <li>If {@code range} is not equal to {@link VK10#VK_WHOLE_SIZE WHOLE_SIZE}, the sum of {@code offset} and {@code range} <b>must</b> be less than or equal to the size of {@code buffer}</li>
 * <li>{@code buffer} <b>must</b> have been created with a {@code usage} value containing at least one of {@link VK10#VK_BUFFER_USAGE_UNIFORM_TEXEL_BUFFER_BIT BUFFER_USAGE_UNIFORM_TEXEL_BUFFER_BIT} or {@link VK10#VK_BUFFER_USAGE_STORAGE_TEXEL_BUFFER_BIT BUFFER_USAGE_STORAGE_TEXEL_BUFFER_BIT}</li>
 * <li>If {@code buffer} was created with {@code usage} containing {@link VK10#VK_BUFFER_USAGE_UNIFORM_TEXEL_BUFFER_BIT BUFFER_USAGE_UNIFORM_TEXEL_BUFFER_BIT}, {@code format} <b>must</b> be supported for uniform texel buffers, as specified by the {@link VK10#VK_FORMAT_FEATURE_UNIFORM_TEXEL_BUFFER_BIT FORMAT_FEATURE_UNIFORM_TEXEL_BUFFER_BIT} flag in {@link VkFormatProperties}{@code ::bufferFeatures} returned by {@code vkGetPhysicalDeviceFormatProperties}</li>
 * <li>If {@code buffer} was created with {@code usage} containing {@link VK10#VK_BUFFER_USAGE_STORAGE_TEXEL_BUFFER_BIT BUFFER_USAGE_STORAGE_TEXEL_BUFFER_BIT}, {@code format} <b>must</b> be supported for storage texel buffers, as specified by the {@link VK10#VK_FORMAT_FEATURE_STORAGE_TEXEL_BUFFER_BIT FORMAT_FEATURE_STORAGE_TEXEL_BUFFER_BIT} flag in {@link VkFormatProperties}{@code ::bufferFeatures} returned by {@code vkGetPhysicalDeviceFormatProperties}</li>
 * <li>If {@code buffer} is non-sparse then it <b>must</b> be bound completely and contiguously to a single {@code VkDeviceMemory} object</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-texelBufferAlignment">texelBufferAlignment</a> feature is enabled and if {@code buffer} was created with {@code usage} containing {@link VK10#VK_BUFFER_USAGE_STORAGE_TEXEL_BUFFER_BIT BUFFER_USAGE_STORAGE_TEXEL_BUFFER_BIT}, {@code offset} <b>must</b> be a multiple of the lesser of {@link VkPhysicalDeviceTexelBufferAlignmentPropertiesEXT}{@code ::storageTexelBufferOffsetAlignmentBytes} or, if {@link VkPhysicalDeviceTexelBufferAlignmentPropertiesEXT}{@code ::storageTexelBufferOffsetSingleTexelAlignment} is {@link VK10#VK_TRUE TRUE}, the size of a texel of the requested {@code format}. If the size of a texel is a multiple of three bytes, then the size of a single component of {@code format} is used instead</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-texelBufferAlignment">texelBufferAlignment</a> feature is enabled and if {@code buffer} was created with {@code usage} containing {@link VK10#VK_BUFFER_USAGE_UNIFORM_TEXEL_BUFFER_BIT BUFFER_USAGE_UNIFORM_TEXEL_BUFFER_BIT}, {@code offset} <b>must</b> be a multiple of the lesser of {@link VkPhysicalDeviceTexelBufferAlignmentPropertiesEXT}{@code ::uniformTexelBufferOffsetAlignmentBytes} or, if {@link VkPhysicalDeviceTexelBufferAlignmentPropertiesEXT}{@code ::uniformTexelBufferOffsetSingleTexelAlignment} is {@link VK10#VK_TRUE TRUE}, the size of a texel of the requested {@code format}. If the size of a texel is a multiple of three bytes, then the size of a single component of {@code format} is used instead</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK10#VK_STRUCTURE_TYPE_BUFFER_VIEW_CREATE_INFO STRUCTURE_TYPE_BUFFER_VIEW_CREATE_INFO}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL}</li>
 * <li>{@code flags} <b>must</b> be 0</li>
 * <li>{@code buffer} <b>must</b> be a valid {@code VkBuffer} handle</li>
 * <li>{@code format} <b>must</b> be a valid {@code VkFormat} value</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VK10#vkCreateBufferView CreateBufferView}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code flags} &ndash; reserved for future use.</li>
 * <li>{@code buffer} &ndash; a {@code VkBuffer} on which the view will be created.</li>
 * <li>{@code format} &ndash; a {@code VkFormat} describing the format of the data elements in the buffer.</li>
 * <li>{@code offset} &ndash; an offset in bytes from the base address of the buffer. Accesses to the buffer view from shaders use addressing that is relative to this starting offset.</li>
 * <li>{@code range} &ndash; a size in bytes of the buffer view. If {@code range} is equal to {@link VK10#VK_WHOLE_SIZE WHOLE_SIZE}, the range from {@code offset} to the end of the buffer is used. If {@link VK10#VK_WHOLE_SIZE WHOLE_SIZE} is used and the remaining size of the buffer is not a multiple of the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#texel-block-size">texel block size</a> of {@code format}, the nearest smaller multiple is used.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkBufferViewCreateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkBufferViewCreateFlags flags;
 *     VkBuffer buffer;
 *     VkFormat format;
 *     VkDeviceSize offset;
 *     VkDeviceSize range;
 * }</code></pre>
 */
class BufferViewCreateInfo(
        var buffer: VkBuffer,
        var format: VkFormat,
        var offset: VkDeviceSize = VkDeviceSize(0),
        var range: VkDeviceSize
) {

    val type get() = VkStructureType.BUFFER_VIEW_CREATE_INFO

    infix fun write(stack: MemoryStack): Adr {
        val adr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
        nsType(adr, type.i)
        nbuffer(adr, buffer.L)
        nformat(adr, format.i)
        noffset(adr, offset.L)
        nrange(adr, range.L)
        return adr
    }
}