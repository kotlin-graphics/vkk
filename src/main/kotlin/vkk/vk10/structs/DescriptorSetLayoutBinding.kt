package vkk.vk10.structs

import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.memPutAddress
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding.*
import vkk.VkDescriptorType
import vkk.VkShaderStageFlags
import vkk.entities.VkSampler
import vkk.entities.VkSampler_Array

/**
 * Structure specifying a descriptor set layout binding.
 *
 * <h5>Description</h5>
 *
 * <p>The above layout definition allows the descriptor bindings to be specified sparsely such that not all binding numbers between 0 and the maximum binding number need to be specified in the {@code pBindings} array. Bindings that are not specified have a {@code descriptorCount} and {@code stageFlags} of zero, and the value of {@code descriptorType} is undefined. However, all binding numbers between 0 and the maximum binding number in the {@link VkDescriptorSetLayoutCreateInfo}{@code ::pBindings} array <b>may</b> consume memory in the descriptor set layout even if not all descriptor bindings are used, though it <b>should</b> not consume additional memory from the descriptor pool.</p>
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>The maximum binding number specified <b>should</b> be as compact as possible to avoid wasted memory.</p>
 * </div>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>If {@code descriptorType} is {@link VK10#VK_DESCRIPTOR_TYPE_SAMPLER DESCRIPTOR_TYPE_SAMPLER} or {@link VK10#VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER}, and {@code descriptorCount} is not 0 and {@code pImmutableSamplers} is not {@code NULL}, {@code pImmutableSamplers} <b>must</b> be a valid pointer to an array of {@code descriptorCount} valid {@code VkSampler} handles</li>
 * <li>If {@code descriptorType} is {@link EXTInlineUniformBlock#VK_DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT} then {@code descriptorCount} <b>must</b> be a multiple of 4</li>
 * <li>If {@code descriptorType} is {@link EXTInlineUniformBlock#VK_DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT} then {@code descriptorCount} <b>must</b> be less than or equal to {@link VkPhysicalDeviceInlineUniformBlockPropertiesEXT}{@code ::maxInlineUniformBlockSize}</li>
 * <li>If {@code descriptorCount} is not 0, {@code stageFlags} <b>must</b> be a valid combination of {@code VkShaderStageFlagBits} values</li>
 * <li>If {@code descriptorType} is {@link VK10#VK_DESCRIPTOR_TYPE_INPUT_ATTACHMENT DESCRIPTOR_TYPE_INPUT_ATTACHMENT} and {@code descriptorCount} is not 0, then {@code stageFlags} <b>must</b> be 0 or {@link VK10#VK_SHADER_STAGE_FRAGMENT_BIT SHADER_STAGE_FRAGMENT_BIT}</li>
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
 * <p>{@link VkDescriptorSetLayoutCreateInfo}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code binding} &ndash; the binding number of this entry and corresponds to a resource of the same binding number in the shader stages.</li>
 * <li>{@code descriptorType} &ndash; a {@code VkDescriptorType} specifying which type of resource descriptors are used for this binding.</li>
 * <li>{@code descriptorCount} &ndash; the number of descriptors contained in the binding, accessed in a shader as an array , except if {@code descriptorType} is {@link EXTInlineUniformBlock#VK_DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT} in which case {@code descriptorCount} is the size in bytes of the inline uniform block . If {@code descriptorCount} is zero this binding entry is reserved and the resource <b>must</b> not be accessed from any stage via this binding within any pipeline using the set layout.</li>
 * <li>{@code stageFlags} &ndash; member is a bitmask of {@code VkShaderStageFlagBits} specifying which pipeline shader stages <b>can</b> access a resource for this binding. {@link VK10#VK_SHADER_STAGE_ALL SHADER_STAGE_ALL} is a shorthand specifying that all defined shader stages, including any additional stages defined by extensions, <b>can</b> access the resource.
 *
 * <p>If a shader stage is not included in {@code stageFlags}, then a resource <b>must</b> not be accessed from that stage via this binding within any pipeline using the set layout. Other than input attachments which are limited to the fragment shader, there are no limitations on what combinations of stages <b>can</b> use a descriptor binding, and in particular a binding <b>can</b> be used by both graphics stages and the compute stage.</p></li>
 * <li>{@code pImmutableSamplers} &ndash; affects initialization of samplers. If {@code descriptorType} specifies a {@link VK10#VK_DESCRIPTOR_TYPE_SAMPLER DESCRIPTOR_TYPE_SAMPLER} or {@link VK10#VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER} type descriptor, then {@code pImmutableSamplers} <b>can</b> be used to initialize a set of <em>immutable samplers</em>. Immutable samplers are permanently bound into the set layout and <b>must</b> not be changed; updating a {@link VK10#VK_DESCRIPTOR_TYPE_SAMPLER DESCRIPTOR_TYPE_SAMPLER} descriptor with immutable samplers is not allowed and updates to a {@link VK10#VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER} descriptor with immutable samplers does not modify the samplers (the image views are updated, but the sampler updates are ignored). If {@code pImmutableSamplers} is not {@code NULL}, then it is considered to be a pointer to an array of sampler handles that will be consumed by the set layout and used for the corresponding binding. If {@code pImmutableSamplers} is {@code NULL}, then the sampler slots are dynamic and sampler handles <b>must</b> be bound into descriptor sets using this layout. If {@code descriptorType} is not one of these descriptor types, then {@code pImmutableSamplers} is ignored.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkDescriptorSetLayoutBinding {
 *     uint32_t binding;
 *     VkDescriptorType descriptorType;
 *     uint32_t descriptorCount;
 *     VkShaderStageFlags stageFlags;
 *     VkSampler const * pImmutableSamplers;
 * }</code></pre>
 */
class DescriptorSetLayoutBinding(
        var binding: Int,
        var descriptorType: VkDescriptorType,
        var descriptorCount: Int,
        var stageFlags: VkShaderStageFlags,
        var immutableSamplers: VkSampler_Array? = null
) {

    constructor(binding: Int,
                descriptorType: VkDescriptorType,
                descriptorCount: Int,
                stageFlags: VkShaderStageFlags,
                immutableSampler: VkSampler) :
            this(binding, descriptorType, descriptorCount, stageFlags, immutableSampler.toArray())

    infix fun write(stack: MemoryStack): Adr =
            stack.ncalloc(ALIGNOF, 1, SIZEOF).also { write(it, stack) }

    fun write(adr: Adr, stack: MemoryStack) {
        nbinding(adr, binding)
        ndescriptorType(adr, descriptorType.i)
        ndescriptorCount(adr, descriptorCount)
        nstageFlags(adr, stageFlags)
        immutableSamplers?.let { memPutAddress(adr + PIMMUTABLESAMPLERS, it write stack) }
    }
}

infix fun Array<DescriptorSetLayoutBinding>.write(stack: MemoryStack): Ptr {
    val natives = stack.ncalloc(ALIGNOF, size, SIZEOF)
    for (i in indices)
        this[i].write(natives + SIZEOF * i, stack)
    return natives
}