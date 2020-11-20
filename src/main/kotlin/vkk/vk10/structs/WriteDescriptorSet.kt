package vkk.vk10.structs

import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.system.MemoryUtil.memPutAddress
import org.lwjgl.vulkan.VkWriteDescriptorSet.*
import vkk.VkDescriptorType
import vkk.VkStructureType
import vkk.entities.VkBufferView_Array
import vkk.entities.VkDescriptorSet

/**
 * Structure specifying the parameters of a descriptor set write operation.
 *
 * <h5>Description</h5>
 *
 * <p>Only one of {@code pImageInfo}, {@code pBufferInfo}, or {@code pTexelBufferView} members is used according to the descriptor type specified in the {@code descriptorType} member of the containing {@link VkWriteDescriptorSet} structure, or none of them in case {@code descriptorType} is {@link EXTInlineUniformBlock#VK_DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT}, in which case the source data for the descriptor writes is taken from the instance of {@link VkWriteDescriptorSetInlineUniformBlockEXT} in the {@code pNext} chain of {@link VkWriteDescriptorSet}, or if {@code descriptorType} is {@link NVRayTracing#VK_DESCRIPTOR_TYPE_ACCELERATION_STRUCTURE_NV DESCRIPTOR_TYPE_ACCELERATION_STRUCTURE_NV}, in which case the source data for the descriptor writes is taken from the instance of {@link VkWriteDescriptorSetAccelerationStructureNV} in the {@code pNext} chain of {@link VkWriteDescriptorSet}, as specified below.</p>
 *
 * <p>If the {@code dstBinding} has fewer than {@code descriptorCount} array elements remaining starting from {@code dstArrayElement}, then the remainder will be used to update the subsequent binding - <code>dstBinding+1</code> starting at array element zero. If a binding has a {@code descriptorCount} of zero, it is skipped. This behavior applies recursively, with the update affecting consecutive bindings as needed to update all {@code descriptorCount} descriptors.</p>
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>The same behavior applies to bindings with a descriptor type of {@link EXTInlineUniformBlock#VK_DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT} where {@code descriptorCount} specifies the number of bytes to update while {@code dstArrayElement} specifies the starting byte offset, thus in this case if the {@code dstBinding} has a smaller byte size than the sum of {@code dstArrayElement} and {@code descriptorCount}, then the remainder will be used to update the subsequent binding - <code>dstBinding+1</code> starting at offset zero. This falls out as a special case of the above rule.</p>
 * </div>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code dstBinding} <b>must</b> be less than or equal to the maximum value of {@code binding} of all {@link VkDescriptorSetLayoutBinding} structures specified when {@code dstSet}&#8217;s descriptor set layout was created</li>
 * <li>{@code dstBinding} <b>must</b> be a binding with a non-zero {@code descriptorCount}</li>
 * <li>All consecutive bindings updated via a single {@link VkWriteDescriptorSet} structure, except those with a {@code descriptorCount} of zero, <b>must</b> have identical {@code descriptorType} and {@code stageFlags}.</li>
 * <li>All consecutive bindings updated via a single {@link VkWriteDescriptorSet} structure, except those with a {@code descriptorCount} of zero, <b>must</b> all either use immutable samplers or <b>must</b> all not use immutable samplers.</li>
 * <li>{@code descriptorType} <b>must</b> match the type of {@code dstBinding} within {@code dstSet}</li>
 * <li>{@code dstSet} <b>must</b> be a valid {@code VkDescriptorSet} handle</li>
 * <li>The sum of {@code dstArrayElement} and {@code descriptorCount} <b>must</b> be less than or equal to the number of array elements in the descriptor set binding specified by {@code dstBinding}, and all applicable consecutive bindings, as described by <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#descriptorsets-updates-consecutive">consecutive binding updates</a></li>
 * <li>If {@code descriptorType} is {@link EXTInlineUniformBlock#VK_DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT}, {@code dstArrayElement} <b>must</b> be an integer multiple of 4</li>
 * <li>If {@code descriptorType} is {@link EXTInlineUniformBlock#VK_DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT}, {@code descriptorCount} <b>must</b> be an integer multiple of 4</li>
 * <li>If {@code descriptorType} is {@link VK10#VK_DESCRIPTOR_TYPE_SAMPLER DESCRIPTOR_TYPE_SAMPLER}, {@link VK10#VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER}, {@link VK10#VK_DESCRIPTOR_TYPE_SAMPLED_IMAGE DESCRIPTOR_TYPE_SAMPLED_IMAGE}, {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_IMAGE DESCRIPTOR_TYPE_STORAGE_IMAGE}, or {@link VK10#VK_DESCRIPTOR_TYPE_INPUT_ATTACHMENT DESCRIPTOR_TYPE_INPUT_ATTACHMENT}, {@code pImageInfo} <b>must</b> be a valid pointer to an array of {@code descriptorCount} valid {@link VkDescriptorImageInfo} structures</li>
 * <li>If {@code descriptorType} is {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_TEXEL_BUFFER DESCRIPTOR_TYPE_UNIFORM_TEXEL_BUFFER} or {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_TEXEL_BUFFER DESCRIPTOR_TYPE_STORAGE_TEXEL_BUFFER}, {@code pTexelBufferView} <b>must</b> be a valid pointer to an array of {@code descriptorCount} valid {@code VkBufferView} handles</li>
 * <li>If {@code descriptorType} is {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER DESCRIPTOR_TYPE_UNIFORM_BUFFER}, {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_BUFFER DESCRIPTOR_TYPE_STORAGE_BUFFER}, {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER_DYNAMIC DESCRIPTOR_TYPE_UNIFORM_BUFFER_DYNAMIC}, or {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_BUFFER_DYNAMIC DESCRIPTOR_TYPE_STORAGE_BUFFER_DYNAMIC}, {@code pBufferInfo} <b>must</b> be a valid pointer to an array of {@code descriptorCount} valid {@link VkDescriptorBufferInfo} structures</li>
 * <li>If {@code descriptorType} is {@link VK10#VK_DESCRIPTOR_TYPE_SAMPLER DESCRIPTOR_TYPE_SAMPLER} or {@link VK10#VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER}, and {@code dstSet} was not allocated with a layout that included immutable samplers for {@code dstBinding} with {@code descriptorType}, the {@code sampler} member of each element of {@code pImageInfo} <b>must</b> be a valid {@code VkSampler} object</li>
 * <li>If {@code descriptorType} is {@link VK10#VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER}, {@link VK10#VK_DESCRIPTOR_TYPE_SAMPLED_IMAGE DESCRIPTOR_TYPE_SAMPLED_IMAGE}, {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_IMAGE DESCRIPTOR_TYPE_STORAGE_IMAGE}, or {@link VK10#VK_DESCRIPTOR_TYPE_INPUT_ATTACHMENT DESCRIPTOR_TYPE_INPUT_ATTACHMENT}, the {@code imageView} and {@code imageLayout} members of each element of {@code pImageInfo} <b>must</b> be a valid {@code VkImageView} and {@code VkImageLayout}, respectively</li>
 * <li>If {@code descriptorType} is {@link EXTInlineUniformBlock#VK_DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT}, the {@code pNext} chain <b>must</b> include a {@link VkWriteDescriptorSetInlineUniformBlockEXT} structure whose {@code dataSize} member equals {@code descriptorCount}</li>
 * <li>If {@code descriptorType} is {@link NVRayTracing#VK_DESCRIPTOR_TYPE_ACCELERATION_STRUCTURE_NV DESCRIPTOR_TYPE_ACCELERATION_STRUCTURE_NV}, the {@code pNext} chain <b>must</b> include a {@link VkWriteDescriptorSetAccelerationStructureNV} structure whose {@code accelerationStructureCount} member equals {@code descriptorCount}</li>
 * <li>If {@code descriptorType} is {@link VK10#VK_DESCRIPTOR_TYPE_SAMPLED_IMAGE DESCRIPTOR_TYPE_SAMPLED_IMAGE}, then the {@code imageView} member of each {@code pImageInfo} element <b>must</b> have been created without a {@link VkSamplerYcbcrConversionInfo} structure in its {@code pNext} chain</li>
 * <li>If {@code descriptorType} is {@link VK10#VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER}, and if any element of {@code pImageInfo} has a {@code imageView} member that was created with a {@link VkSamplerYcbcrConversionInfo} structure in its {@code pNext} chain, then {@code dstSet} <b>must</b> have been allocated with a layout that included immutable samplers for {@code dstBinding}, and the corresponding immutable sampler <b>must</b> have been created with an <em>identically defined</em> {@link VkSamplerYcbcrConversionInfo} object</li>
 * <li>If {@code descriptorType} is {@link VK10#VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER}, and {@code dstSet} was allocated with a layout that included immutable samplers for {@code dstBinding}, then the {@code imageView} member of each element of {@code pImageInfo} which corresponds to an immutable sampler that enables <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#samplers-YCbCr-conversion">sampler Y&#8217;C<sub>B</sub>C<sub>R</sub> conversion</a> <b>must</b> have been created with a {@link VkSamplerYcbcrConversionInfo} structure in its {@code pNext} chain with an <em>identically defined</em> {@link VkSamplerYcbcrConversionInfo} to the corresponding immutable sampler</li>
 * <li>If {@code descriptorType} is {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_IMAGE DESCRIPTOR_TYPE_STORAGE_IMAGE}, for each descriptor that will be accessed via load or store operations the {@code imageLayout} member for corresponding elements of {@code pImageInfo} <b>must</b> be {@link VK10#VK_IMAGE_LAYOUT_GENERAL IMAGE_LAYOUT_GENERAL}</li>
 * <li>If {@code descriptorType} is {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER DESCRIPTOR_TYPE_UNIFORM_BUFFER} or {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER_DYNAMIC DESCRIPTOR_TYPE_UNIFORM_BUFFER_DYNAMIC}, the {@code offset} member of each element of {@code pBufferInfo} <b>must</b> be a multiple of {@link VkPhysicalDeviceLimits}{@code ::minUniformBufferOffsetAlignment}</li>
 * <li>If {@code descriptorType} is {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_BUFFER DESCRIPTOR_TYPE_STORAGE_BUFFER} or {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_BUFFER_DYNAMIC DESCRIPTOR_TYPE_STORAGE_BUFFER_DYNAMIC}, the {@code offset} member of each element of {@code pBufferInfo} <b>must</b> be a multiple of {@link VkPhysicalDeviceLimits}{@code ::minStorageBufferOffsetAlignment}</li>
 * <li>If {@code descriptorType} is {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER DESCRIPTOR_TYPE_UNIFORM_BUFFER}, {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER_DYNAMIC DESCRIPTOR_TYPE_UNIFORM_BUFFER_DYNAMIC}, {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_BUFFER DESCRIPTOR_TYPE_STORAGE_BUFFER}, or {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_BUFFER_DYNAMIC DESCRIPTOR_TYPE_STORAGE_BUFFER_DYNAMIC}, and the {@code buffer} member of any element of {@code pBufferInfo} is the handle of a non-sparse buffer, then that buffer <b>must</b> be bound completely and contiguously to a single {@code VkDeviceMemory} object</li>
 * <li>If {@code descriptorType} is {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER DESCRIPTOR_TYPE_UNIFORM_BUFFER} or {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER_DYNAMIC DESCRIPTOR_TYPE_UNIFORM_BUFFER_DYNAMIC}, the {@code buffer} member of each element of {@code pBufferInfo} <b>must</b> have been created with {@link VK10#VK_BUFFER_USAGE_UNIFORM_BUFFER_BIT BUFFER_USAGE_UNIFORM_BUFFER_BIT} set</li>
 * <li>If {@code descriptorType} is {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_BUFFER DESCRIPTOR_TYPE_STORAGE_BUFFER} or {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_BUFFER_DYNAMIC DESCRIPTOR_TYPE_STORAGE_BUFFER_DYNAMIC}, the {@code buffer} member of each element of {@code pBufferInfo} <b>must</b> have been created with {@link VK10#VK_BUFFER_USAGE_STORAGE_BUFFER_BIT BUFFER_USAGE_STORAGE_BUFFER_BIT} set</li>
 * <li>If {@code descriptorType} is {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER DESCRIPTOR_TYPE_UNIFORM_BUFFER} or {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER_DYNAMIC DESCRIPTOR_TYPE_UNIFORM_BUFFER_DYNAMIC}, the {@code range} member of each element of {@code pBufferInfo}, or the effective range if {@code range} is {@link VK10#VK_WHOLE_SIZE WHOLE_SIZE}, <b>must</b> be less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxUniformBufferRange}</li>
 * <li>If {@code descriptorType} is {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_BUFFER DESCRIPTOR_TYPE_STORAGE_BUFFER} or {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_BUFFER_DYNAMIC DESCRIPTOR_TYPE_STORAGE_BUFFER_DYNAMIC}, the {@code range} member of each element of {@code pBufferInfo}, or the effective range if {@code range} is {@link VK10#VK_WHOLE_SIZE WHOLE_SIZE}, <b>must</b> be less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxStorageBufferRange}</li>
 * <li>If {@code descriptorType} is {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_TEXEL_BUFFER DESCRIPTOR_TYPE_UNIFORM_TEXEL_BUFFER}, the {@code VkBuffer} that each element of {@code pTexelBufferView} was created from <b>must</b> have been created with {@link VK10#VK_BUFFER_USAGE_UNIFORM_TEXEL_BUFFER_BIT BUFFER_USAGE_UNIFORM_TEXEL_BUFFER_BIT} set</li>
 * <li>If {@code descriptorType} is {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_TEXEL_BUFFER DESCRIPTOR_TYPE_STORAGE_TEXEL_BUFFER}, the {@code VkBuffer} that each element of {@code pTexelBufferView} was created from <b>must</b> have been created with {@link VK10#VK_BUFFER_USAGE_STORAGE_TEXEL_BUFFER_BIT BUFFER_USAGE_STORAGE_TEXEL_BUFFER_BIT} set</li>
 * <li>If {@code descriptorType} is {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_IMAGE DESCRIPTOR_TYPE_STORAGE_IMAGE} or {@link VK10#VK_DESCRIPTOR_TYPE_INPUT_ATTACHMENT DESCRIPTOR_TYPE_INPUT_ATTACHMENT}, the {@code imageView} member of each element of {@code pImageInfo} <b>must</b> have been created with the identity swizzle</li>
 * <li>If {@code descriptorType} is {@link VK10#VK_DESCRIPTOR_TYPE_SAMPLED_IMAGE DESCRIPTOR_TYPE_SAMPLED_IMAGE} or {@link VK10#VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER}, the {@code imageView} member of each element of {@code pImageInfo} <b>must</b> have been created with {@link VK10#VK_IMAGE_USAGE_SAMPLED_BIT IMAGE_USAGE_SAMPLED_BIT} set</li>
 * <li>If {@code descriptorType} is {@link VK10#VK_DESCRIPTOR_TYPE_SAMPLED_IMAGE DESCRIPTOR_TYPE_SAMPLED_IMAGE} or {@link VK10#VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER}, the {@code imageLayout} member of each element of {@code pImageInfo} <b>must</b> be a member of the list given in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#descriptorsets-sampledimage">Sampled Image</a> or <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#descriptorsets-combinedimagesampler">Combined Image Sampler</a>, corresponding to its type</li>
 * <li>If {@code descriptorType} is {@link VK10#VK_DESCRIPTOR_TYPE_INPUT_ATTACHMENT DESCRIPTOR_TYPE_INPUT_ATTACHMENT}, the {@code imageView} member of each element of {@code pImageInfo} <b>must</b> have been created with {@link VK10#VK_IMAGE_USAGE_INPUT_ATTACHMENT_BIT IMAGE_USAGE_INPUT_ATTACHMENT_BIT} set</li>
 * <li>If {@code descriptorType} is {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_IMAGE DESCRIPTOR_TYPE_STORAGE_IMAGE}, the {@code imageView} member of each element of {@code pImageInfo} <b>must</b> have been created with {@link VK10#VK_IMAGE_USAGE_STORAGE_BIT IMAGE_USAGE_STORAGE_BIT} set</li>
 * <li>All consecutive bindings updated via a single {@link VkWriteDescriptorSet} structure, except those with a {@code descriptorCount} of zero, <b>must</b> have identical {@code VkDescriptorBindingFlagBitsEXT}.</li>
 * <li>If {@code descriptorType} is {@link VK10#VK_DESCRIPTOR_TYPE_SAMPLER DESCRIPTOR_TYPE_SAMPLER}, then {@code dstSet} <b>must</b> not have been allocated with a layout that included immutable samplers for {@code dstBinding}</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK10#VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET}</li>
 * <li>Each {@code pNext} member of any structure (including this one) in the {@code pNext} chain <b>must</b> be either {@code NULL} or a pointer to a valid instance of {@link VkWriteDescriptorSetAccelerationStructureNV} or {@link VkWriteDescriptorSetInlineUniformBlockEXT}</li>
 * <li>Each {@code sType} member in the {@code pNext} chain <b>must</b> be unique</li>
 * <li>{@code descriptorType} <b>must</b> be a valid {@code VkDescriptorType} value</li>
 * <li>{@code descriptorCount} <b>must</b> be greater than 0</li>
 * <li>Both of {@code dstSet}, and the elements of {@code pTexelBufferView} that are valid handles <b>must</b> have been created, allocated, or retrieved from the same {@code VkDevice}</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkDescriptorBufferInfo}, {@link VkDescriptorImageInfo}, {@link KHRPushDescriptor#vkCmdPushDescriptorSetKHR CmdPushDescriptorSetKHR}, {@link VK10#vkUpdateDescriptorSets UpdateDescriptorSets}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code dstSet} &ndash; the destination descriptor set to update.</li>
 * <li>{@code dstBinding} &ndash; the descriptor binding within that set.</li>
 * <li>{@code dstArrayElement} &ndash; the starting element in that array. If the descriptor binding identified by {@code dstSet} and {@code dstBinding} has a descriptor type of {@link EXTInlineUniformBlock#VK_DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT} then {@code dstArrayElement} specifies the starting byte offset within the binding.</li>
 * <li>{@code descriptorCount} &ndash; the number of descriptors to update (the number of elements in {@code pImageInfo}, {@code pBufferInfo}, or {@code pTexelBufferView} , or a value matching the {@code dataSize} member of an instance of {@link VkWriteDescriptorSetInlineUniformBlockEXT} in the {@code pNext} chain , or a value matching the {@code accelerationStructureCount} of an instance of {@link VkWriteDescriptorSetAccelerationStructureNV} in the {@code pNext} chain ). If the descriptor binding identified by {@code dstSet} and {@code dstBinding} has a descriptor type of {@link EXTInlineUniformBlock#VK_DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT} then {@code descriptorCount} specifies the number of bytes to update.</li>
 * <li>{@code descriptorType} &ndash; a {@code VkDescriptorType} specifying the type of each descriptor in {@code pImageInfo}, {@code pBufferInfo}, or {@code pTexelBufferView}, as described below. It <b>must</b> be the same type as that specified in {@link VkDescriptorSetLayoutBinding} for {@code dstSet} at {@code dstBinding}. The type of the descriptor also controls which array the descriptors are taken from.</li>
 * <li>{@code pImageInfo} &ndash; points to an array of {@link VkDescriptorImageInfo} structures or is ignored, as described below.</li>
 * <li>{@code pBufferInfo} &ndash; points to an array of {@link VkDescriptorBufferInfo} structures or is ignored, as described below.</li>
 * <li>{@code pTexelBufferView} &ndash; points to an array of {@code VkBufferView} handles as described in the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#resources-buffer-views">Buffer Views</a> section or is ignored, as described below.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkWriteDescriptorSet {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkDescriptorSet dstSet;
 *     uint32_t dstBinding;
 *     uint32_t dstArrayElement;
 *     uint32_t descriptorCount;
 *     VkDescriptorType descriptorType;
 *     {@link VkDescriptorImageInfo VkDescriptorImageInfo} const * pImageInfo;
 *     {@link VkDescriptorBufferInfo VkDescriptorBufferInfo} const * pBufferInfo;
 *     VkBufferView const * pTexelBufferView;
 * }</code></pre>
 */
class WriteDescriptorSet(
        var dstSet: VkDescriptorSet,
        var dstBinding: Int = 0,
        var dstArrayElement: Int = 0,
        var descriptorCount: Int,
        var descriptorType: VkDescriptorType,
        var imageInfo: Array<DescriptorImageInfo>? = null,
        var bufferInfo: Array<DescriptorBufferInfo>? = null,
        var texelBufferView: VkBufferView_Array? = null,
        var next: Ptr = NULL) {


    val type get() = VkStructureType.WRITE_DESCRIPTOR_SET

    infix fun write(stack: MemoryStack): Adr =
            stack.ncalloc(ALIGNOF, 1, SIZEOF).also { write(it, stack) }

    fun write(adr: Adr, stack: MemoryStack) {
        nsType(adr, type.i)
        npNext(adr, next)
        ndstSet(adr, dstSet.L)
        ndstBinding(adr, dstBinding)
        ndstArrayElement(adr, dstArrayElement)
        ndescriptorCount(adr, descriptorCount)
        ndescriptorType(adr, descriptorType.i)
        imageInfo?.let { memPutAddress(adr + PIMAGEINFO, it write stack) }
        bufferInfo?.let { memPutAddress(adr + PBUFFERINFO, it write stack) }
        texelBufferView?.let { memPutAddress(adr + PTEXELBUFFERVIEW, it write stack) }
    }
}

infix fun Array<WriteDescriptorSet>.write(stack: MemoryStack): Ptr {
    val natives = stack.ncalloc(ALIGNOF, size, SIZEOF)
    for (i in indices)
        this[i].write(natives + SIZEOF * i, stack)
    return natives
}