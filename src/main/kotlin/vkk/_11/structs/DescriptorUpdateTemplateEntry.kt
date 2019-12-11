package vkk._11.structs

import glm_.L
import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkDescriptorUpdateTemplateEntry.*
import vkk.VkDescriptorType

/**
 * Describes a single descriptor update of the descriptor update template.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code dstBinding} <b>must</b> be a valid binding in the descriptor set layout implicitly specified when using a descriptor update template to update descriptors.</li>
 * <li>{@code dstArrayElement} and {@code descriptorCount} <b>must</b> be less than or equal to the number of array elements in the descriptor set binding implicitly specified when using a descriptor update template to update descriptors, and all applicable consecutive bindings, as described by <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#descriptorsets-updates-consecutive">consecutive binding updates</a></li>
 * <li>If {@code descriptor} type is {@link EXTInlineUniformBlock#VK_DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT}, {@code dstArrayElement} <b>must</b> be an integer multiple of 4</li>
 * <li>If {@code descriptor} type is {@link EXTInlineUniformBlock#VK_DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT}, {@code descriptorCount} <b>must</b> be an integer multiple of 4</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code descriptorType} <b>must</b> be a valid {@code VkDescriptorType} value</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkDescriptorUpdateTemplateCreateInfo}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code dstBinding} &ndash; the descriptor binding to update when using this descriptor update template.</li>
 * <li>{@code dstArrayElement} &ndash; the starting element in the array belonging to {@code dstBinding}. If the descriptor binding identified by {@code srcBinding} has a descriptor type of {@link EXTInlineUniformBlock#VK_DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT} then {@code dstArrayElement} specifies the starting byte offset to update.</li>
 * <li>{@code descriptorCount} &ndash; the number of descriptors to update. If {@code descriptorCount} is greater than the number of remaining array elements in the destination binding, those affect consecutive bindings in a manner similar to {@link VkWriteDescriptorSet} above. If the descriptor binding identified by {@code dstBinding} has a descriptor type of {@link EXTInlineUniformBlock#VK_DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT} then {@code descriptorCount} specifies the number of bytes to update and the remaining array elements in the destination binding refer to the remaining number of bytes in it.</li>
 * <li>{@code descriptorType} &ndash; a {@code VkDescriptorType} specifying the type of the descriptor.</li>
 * <li>{@code offset} &ndash; the offset in bytes of the first binding in the raw data structure.</li>
 * <li>{@code stride} &ndash; the stride in bytes between two consecutive array elements of the descriptor update informations in the raw data structure. The actual pointer ptr for each array element j of update entry i is computed using the following formula:
 *
 * <pre><code>
 *     const char *ptr = (const char *)pData + pDescriptorUpdateEntries[i].offset + j * pDescriptorUpdateEntries[i].stride</code></pre>
 *
 * <p>The stride is useful in case the bindings are stored in structs along with other data. If {@code descriptorType} is {@link EXTInlineUniformBlock#VK_DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT} then the value of {@code stride} is ignored and the stride is assumed to be 1, i.e. the descriptor update information for them is always specified as a contiguous range.</p></li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkDescriptorUpdateTemplateEntry {
 *     uint32_t dstBinding;
 *     uint32_t dstArrayElement;
 *     uint32_t descriptorCount;
 *     VkDescriptorType descriptorType;
 *     size_t offset;
 *     size_t stride;
 * }</code></pre>
 */
class DescriptorUpdateTemplateEntry(
        var dstBinding: Int,
        var dstArrayElement: Int,
        var descriptorCount: Int,
        var descriptorType: VkDescriptorType,
        var offset: Int,
        var stride: Int
) {

    infix fun write(stack: MemoryStack): Adr =
            stack.ncalloc(ALIGNOF, 1, SIZEOF).also { write(it) }

    infix fun write(adr: Adr) {
        ndstBinding(adr, dstBinding)
        ndstArrayElement(adr, dstArrayElement)
        ndescriptorCount(adr, descriptorCount)
        ndescriptorType(adr, descriptorType.i)
        noffset(adr, offset.L)
        nstride(adr, stride.L)
    }
}

infix fun Array<DescriptorUpdateTemplateEntry>.write(stack: MemoryStack): Ptr {
    val natives = stack.ncalloc(ALIGNOF, size, SIZEOF)
    for (i in indices)
        this[i] write (natives + i * SIZEOF)
    return natives
}