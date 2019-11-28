package vkk.classes

import kool.Adr
import kool.IntPtr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkClearValue
import org.lwjgl.vulkan.VkDescriptorPoolSize
import org.lwjgl.vulkan.VkDescriptorPoolSize.*
import vkk.VkDescriptorType

/**
 * Structure specifying descriptor pool size.
 *
 * <h5>Description</h5>
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>When creating a descriptor pool that will contain descriptors for combined image samplers of multi-planar formats, an application needs to account for non-trivial descriptor consumption when choosing the {@code descriptorCount} value, as indicated by {@link VkSamplerYcbcrConversionImageFormatProperties}{@code ::combinedImageSamplerDescriptorCount}.</p>
 * </div>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code descriptorCount} <b>must</b> be greater than 0</li>
 * <li>If {@code type} is {@link EXTInlineUniformBlock#VK_DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT} then {@code descriptorCount} <b>must</b> be a multiple of 4</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code type} <b>must</b> be a valid {@code VkDescriptorType} value</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkDescriptorPoolCreateInfo}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code type} &ndash; the type of descriptor.</li>
 * <li>{@code descriptorCount} &ndash; the number of descriptors of that type to allocate. If {@code type} is {@link EXTInlineUniformBlock#VK_DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT} then {@code descriptorCount} is the number of bytes to allocate for descriptors of this type.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkDescriptorPoolSize {
 *     VkDescriptorType type;
 *     uint32_t descriptorCount;
 * }</code></pre>
 */
class DescriptorPoolSize(
        val type: VkDescriptorType,
        var descriptorCount: Int
) {

    infix fun write(stack: MemoryStack): Adr =
        stack.ncalloc(ALIGNOF, 1, SIZEOF).also { write(it) }

    infix fun write(adr: Adr) {
        ntype(adr, type.i)
        ndescriptorCount(adr, descriptorCount)
    }
}

infix fun Array<DescriptorPoolSize>.write(stack: MemoryStack): Ptr {
    val natives = stack.ncalloc(ALIGNOF, size, SIZEOF)
    for (i in indices)
        this[i] write (natives + i * SIZEOF)
    return natives
}