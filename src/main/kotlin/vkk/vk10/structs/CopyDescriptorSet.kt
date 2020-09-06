package vkk.vk10.structs

import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkCopyDescriptorSet.*
import vkk.VkStructureType
import vkk.entities.VkDescriptorSet

/**
 * Structure specifying a copy descriptor set operation.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code srcBinding} <b>must</b> be a valid binding within {@code srcSet}</li>
 * <li>The sum of {@code srcArrayElement} and {@code descriptorCount} <b>must</b> be less than or equal to the number of array elements in the descriptor set binding specified by {@code srcBinding}, and all applicable consecutive bindings, as described by <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#descriptorsets-updates-consecutive">consecutive binding updates</a></li>
 * <li>{@code dstBinding} <b>must</b> be a valid binding within {@code dstSet}</li>
 * <li>The sum of {@code dstArrayElement} and {@code descriptorCount} <b>must</b> be less than or equal to the number of array elements in the descriptor set binding specified by {@code dstBinding}, and all applicable consecutive bindings, as described by <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#descriptorsets-updates-consecutive">consecutive binding updates</a></li>
 * <li>The type of {@code dstBinding} within {@code dstSet} <b>must</b> be equal to the type of {@code srcBinding} within {@code srcSet}</li>
 * <li>If {@code srcSet} is equal to {@code dstSet}, then the source and destination ranges of descriptors <b>must</b> not overlap, where the ranges <b>may</b> include array elements from consecutive bindings as described by <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#descriptorsets-updates-consecutive">consecutive binding updates</a></li>
 * <li>If the descriptor type of the descriptor set binding specified by {@code srcBinding} is {@link EXTInlineUniformBlock#VK_DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT}, {@code srcArrayElement} <b>must</b> be an integer multiple of 4</li>
 * <li>If the descriptor type of the descriptor set binding specified by {@code dstBinding} is {@link EXTInlineUniformBlock#VK_DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT}, {@code dstArrayElement} <b>must</b> be an integer multiple of 4</li>
 * <li>If the descriptor type of the descriptor set binding specified by either {@code srcBinding} or {@code dstBinding} is {@link EXTInlineUniformBlock#VK_DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT}, {@code descriptorCount} <b>must</b> be an integer multiple of 4</li>
 * <li>If {@code srcSet}&#8217;s layout was created with the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT} flag set, then {@code dstSet}&#8217;s layout <b>must</b> also have been created with the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT} flag set</li>
 * <li>If {@code srcSet}&#8217;s layout was created without the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT} flag set, then {@code dstSet}&#8217;s layout <b>must</b> also have been created without the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT} flag set</li>
 * <li>If the descriptor pool from which {@code srcSet} was allocated was created with the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_POOL_CREATE_UPDATE_AFTER_BIND_BIT_EXT DESCRIPTOR_POOL_CREATE_UPDATE_AFTER_BIND_BIT_EXT} flag set, then the descriptor pool from which {@code dstSet} was allocated <b>must</b> also have been created with the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_POOL_CREATE_UPDATE_AFTER_BIND_BIT_EXT DESCRIPTOR_POOL_CREATE_UPDATE_AFTER_BIND_BIT_EXT} flag set</li>
 * <li>If the descriptor pool from which {@code srcSet} was allocated was created without the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_POOL_CREATE_UPDATE_AFTER_BIND_BIT_EXT DESCRIPTOR_POOL_CREATE_UPDATE_AFTER_BIND_BIT_EXT} flag set, then the descriptor pool from which {@code dstSet} was allocated <b>must</b> also have been created without the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_POOL_CREATE_UPDATE_AFTER_BIND_BIT_EXT DESCRIPTOR_POOL_CREATE_UPDATE_AFTER_BIND_BIT_EXT} flag set</li>
 * <li>If the descriptor type of the descriptor set binding specified by {@code dstBinding} is {@link VK10#VK_DESCRIPTOR_TYPE_SAMPLER DESCRIPTOR_TYPE_SAMPLER}, then {@code dstSet} <b>must</b> not have been allocated with a layout that included immutable samplers for {@code dstBinding}</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK10#VK_STRUCTURE_TYPE_COPY_DESCRIPTOR_SET STRUCTURE_TYPE_COPY_DESCRIPTOR_SET}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL}</li>
 * <li>{@code srcSet} <b>must</b> be a valid {@code VkDescriptorSet} handle</li>
 * <li>{@code dstSet} <b>must</b> be a valid {@code VkDescriptorSet} handle</li>
 * <li>Both of {@code dstSet}, and {@code srcSet} <b>must</b> have been created, allocated, or retrieved from the same {@code VkDevice}</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VK10#vkUpdateDescriptorSets UpdateDescriptorSets}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code srcSet} &ndash; {@code srcSet}, {@code srcBinding}, and {@code srcArrayElement} are the source set, binding, and array element, respectively. If the descriptor binding identified by {@code srcSet} and {@code srcBinding} has a descriptor type of {@link EXTInlineUniformBlock#VK_DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT} then {@code srcArrayElement} specifies the starting byte offset within the binding to copy from.</li>
 * <li>{@code srcBinding} &ndash; see {@code srcSet}</li>
 * <li>{@code srcArrayElement} &ndash; see {@code srcSet}</li>
 * <li>{@code dstSet} &ndash; {@code dstSet}, {@code dstBinding}, and {@code dstArrayElement} are the destination set, binding, and array element, respectively. If the descriptor binding identified by {@code dstSet} and {@code dstBinding} has a descriptor type of {@link EXTInlineUniformBlock#VK_DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT} then {@code dstArrayElement} specifies the starting byte offset within the binding to copy to.</li>
 * <li>{@code dstBinding} &ndash; see {@code dstSet}</li>
 * <li>{@code dstArrayElement} &ndash; see {@code dstSet}</li>
 * <li>{@code descriptorCount} &ndash; the number of descriptors to copy from the source to destination. If {@code descriptorCount} is greater than the number of remaining array elements in the source or destination binding, those affect consecutive bindings in a manner similar to {@link VkWriteDescriptorSet} above. If the descriptor binding identified by {@code srcSet} and {@code srcBinding} has a descriptor type of {@link EXTInlineUniformBlock#VK_DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT} then {@code descriptorCount} specifies the number of bytes to copy and the remaining array elements in the source or destination binding refer to the remaining number of bytes in those.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkCopyDescriptorSet {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkDescriptorSet srcSet;
 *     uint32_t srcBinding;
 *     uint32_t srcArrayElement;
 *     VkDescriptorSet dstSet;
 *     uint32_t dstBinding;
 *     uint32_t dstArrayElement;
 *     uint32_t descriptorCount;
 * }</code></pre>
 */
class CopyDescriptorSet(
        val srcSet: VkDescriptorSet,
        var srcBinding: Int,
        var srcArrayElement: Int,
        val dstSet: VkDescriptorSet,
        var dstBinding: Int,
        var dstArrayElement: Int,
        var descriptorCount: Int
) {

    val type get() = VkStructureType.COPY_DESCRIPTOR_SET

    infix fun write(stack: MemoryStack): Adr =
            stack.ncalloc(ALIGNOF, 1, SIZEOF).also(::write)

    fun write(adr: Adr) {
        nsType(adr, type.i)
        nsrcSet(adr, srcSet.L)
        nsrcBinding(adr, srcBinding)
        nsrcArrayElement(adr, srcArrayElement)
        ndstSet(adr, dstSet.L)
        ndstBinding(adr, dstBinding)
        ndstArrayElement(adr, dstArrayElement)
        ndescriptorCount(adr, descriptorCount)
    }
}

infix fun Array<CopyDescriptorSet>.write(stack: MemoryStack): Ptr {
    val natives = stack.ncalloc(ALIGNOF, size, SIZEOF)
    for (i in indices)
        this[i].write(natives + SIZEOF * i)
    return natives
}