package vkk.vk10.structs

import kool.Adr
import org.lwjgl.system.MemoryUtil.memPutAddress
import org.lwjgl.vulkan.VkPipelineLayoutCreateInfo.*
import vkk.VkStack
import vkk.VkStructureType
import vkk.entities.VkDescriptorSetLayout_Array

/**
 * Structure specifying the parameters of a newly created pipeline layout object.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code setLayoutCount} <b>must</b> be less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxBoundDescriptorSets}</li>
 * <li>The total number of descriptors in descriptor set layouts created without the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT} bit set with a {@code descriptorType} of {@link VK10#VK_DESCRIPTOR_TYPE_SAMPLER DESCRIPTOR_TYPE_SAMPLER} and {@link VK10#VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER} accessible to any given shader stage across all elements of {@code pSetLayouts} <b>must</b> be less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxPerStageDescriptorSamplers}</li>
 * <li>The total number of descriptors in descriptor set layouts created without the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT} bit set with a {@code descriptorType} of {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER DESCRIPTOR_TYPE_UNIFORM_BUFFER} and {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER_DYNAMIC DESCRIPTOR_TYPE_UNIFORM_BUFFER_DYNAMIC} accessible to any given shader stage across all elements of {@code pSetLayouts} <b>must</b> be less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxPerStageDescriptorUniformBuffers}</li>
 * <li>The total number of descriptors in descriptor set layouts created without the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT} bit set with a {@code descriptorType} of {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_BUFFER DESCRIPTOR_TYPE_STORAGE_BUFFER} and {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_BUFFER_DYNAMIC DESCRIPTOR_TYPE_STORAGE_BUFFER_DYNAMIC} accessible to any given shader stage across all elements of {@code pSetLayouts} <b>must</b> be less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxPerStageDescriptorStorageBuffers}</li>
 * <li>The total number of descriptors in descriptor set layouts created without the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT} bit set with a {@code descriptorType} of {@link VK10#VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER}, {@link VK10#VK_DESCRIPTOR_TYPE_SAMPLED_IMAGE DESCRIPTOR_TYPE_SAMPLED_IMAGE}, and {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_TEXEL_BUFFER DESCRIPTOR_TYPE_UNIFORM_TEXEL_BUFFER} accessible to any given shader stage across all elements of {@code pSetLayouts} <b>must</b> be less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxPerStageDescriptorSampledImages}</li>
 * <li>The total number of descriptors in descriptor set layouts created without the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT} bit set with a {@code descriptorType} of {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_IMAGE DESCRIPTOR_TYPE_STORAGE_IMAGE}, and {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_TEXEL_BUFFER DESCRIPTOR_TYPE_STORAGE_TEXEL_BUFFER} accessible to any given shader stage across all elements of {@code pSetLayouts} <b>must</b> be less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxPerStageDescriptorStorageImages}</li>
 * <li>The total number of descriptors in descriptor set layouts created without the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT} bit set with a {@code descriptorType} of {@link VK10#VK_DESCRIPTOR_TYPE_INPUT_ATTACHMENT DESCRIPTOR_TYPE_INPUT_ATTACHMENT} accessible to any given shader stage across all elements of {@code pSetLayouts} <b>must</b> be less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxPerStageDescriptorInputAttachments}</li>
 * <li>The total number of bindings in descriptor set layouts created without the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT} bit set with a {@code descriptorType} of {@link EXTInlineUniformBlock#VK_DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT} accessible to any given shader stage across all elements of {@code pSetLayouts} <b>must</b> be less than or equal to {@link VkPhysicalDeviceInlineUniformBlockPropertiesEXT}{@code ::maxPerStageDescriptorInlineUniformBlocks}</li>
 * <li>The total number of descriptors with a {@code descriptorType} of {@link VK10#VK_DESCRIPTOR_TYPE_SAMPLER DESCRIPTOR_TYPE_SAMPLER} and {@link VK10#VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER} accessible to any given shader stage across all elements of {@code pSetLayouts} <b>must</b> be less than or equal to {@link VkPhysicalDeviceDescriptorIndexingPropertiesEXT}{@code ::maxPerStageDescriptorUpdateAfterBindSamplers}</li>
 * <li>The total number of descriptors with a {@code descriptorType} of {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER DESCRIPTOR_TYPE_UNIFORM_BUFFER} and {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER_DYNAMIC DESCRIPTOR_TYPE_UNIFORM_BUFFER_DYNAMIC} accessible to any given shader stage across all elements of {@code pSetLayouts} <b>must</b> be less than or equal to {@link VkPhysicalDeviceDescriptorIndexingPropertiesEXT}{@code ::maxPerStageDescriptorUpdateAfterBindUniformBuffers}</li>
 * <li>The total number of descriptors with a {@code descriptorType} of {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_BUFFER DESCRIPTOR_TYPE_STORAGE_BUFFER} and {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_BUFFER_DYNAMIC DESCRIPTOR_TYPE_STORAGE_BUFFER_DYNAMIC} accessible to any given shader stage across all elements of {@code pSetLayouts} <b>must</b> be less than or equal to {@link VkPhysicalDeviceDescriptorIndexingPropertiesEXT}{@code ::maxPerStageDescriptorUpdateAfterBindStorageBuffers}</li>
 * <li>The total number of descriptors with a {@code descriptorType} of {@link VK10#VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER}, {@link VK10#VK_DESCRIPTOR_TYPE_SAMPLED_IMAGE DESCRIPTOR_TYPE_SAMPLED_IMAGE}, and {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_TEXEL_BUFFER DESCRIPTOR_TYPE_UNIFORM_TEXEL_BUFFER} accessible to any given shader stage across all elements of {@code pSetLayouts} <b>must</b> be less than or equal to {@link VkPhysicalDeviceDescriptorIndexingPropertiesEXT}{@code ::maxPerStageDescriptorUpdateAfterBindSampledImages}</li>
 * <li>The total number of descriptors with a {@code descriptorType} of {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_IMAGE DESCRIPTOR_TYPE_STORAGE_IMAGE}, and {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_TEXEL_BUFFER DESCRIPTOR_TYPE_STORAGE_TEXEL_BUFFER} accessible to any given shader stage across all elements of {@code pSetLayouts} <b>must</b> be less than or equal to {@link VkPhysicalDeviceDescriptorIndexingPropertiesEXT}{@code ::maxPerStageDescriptorUpdateAfterBindStorageImages}</li>
 * <li>The total number of descriptors with a {@code descriptorType} of {@link VK10#VK_DESCRIPTOR_TYPE_INPUT_ATTACHMENT DESCRIPTOR_TYPE_INPUT_ATTACHMENT} accessible to any given shader stage across all elements of {@code pSetLayouts} <b>must</b> be less than or equal to {@link VkPhysicalDeviceDescriptorIndexingPropertiesEXT}{@code ::maxPerStageDescriptorUpdateAfterBindInputAttachments}</li>
 * <li>The total number of bindings with a {@code descriptorType} of {@link EXTInlineUniformBlock#VK_DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT} accessible to any given shader stage across all elements of {@code pSetLayouts} <b>must</b> be less than or equal to {@link VkPhysicalDeviceInlineUniformBlockPropertiesEXT}{@code ::maxPerStageDescriptorUpdateAfterBindInlineUniformBlocks}</li>
 * <li>The total number of descriptors in descriptor set layouts created without the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT} bit set with a {@code descriptorType} of {@link VK10#VK_DESCRIPTOR_TYPE_SAMPLER DESCRIPTOR_TYPE_SAMPLER} and {@link VK10#VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER} accessible across all shader stages and across all elements of {@code pSetLayouts} <b>must</b> be less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxDescriptorSetSamplers}</li>
 * <li>The total number of descriptors in descriptor set layouts created without the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT} bit set with a {@code descriptorType} of {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER DESCRIPTOR_TYPE_UNIFORM_BUFFER} accessible across all shader stages and across all elements of {@code pSetLayouts} <b>must</b> be less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxDescriptorSetUniformBuffers}</li>
 * <li>The total number of descriptors in descriptor set layouts created without the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT} bit set with a {@code descriptorType} of {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER_DYNAMIC DESCRIPTOR_TYPE_UNIFORM_BUFFER_DYNAMIC} accessible across all shader stages and across all elements of {@code pSetLayouts} <b>must</b> be less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxDescriptorSetUniformBuffersDynamic}</li>
 * <li>The total number of descriptors in descriptor set layouts created without the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT} bit set with a {@code descriptorType} of {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_BUFFER DESCRIPTOR_TYPE_STORAGE_BUFFER} accessible across all shader stages and across all elements of {@code pSetLayouts} <b>must</b> be less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxDescriptorSetStorageBuffers}</li>
 * <li>The total number of descriptors in descriptor set layouts created without the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT} bit set with a {@code descriptorType} of {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_BUFFER_DYNAMIC DESCRIPTOR_TYPE_STORAGE_BUFFER_DYNAMIC} accessible across all shader stages and across all elements of {@code pSetLayouts} <b>must</b> be less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxDescriptorSetStorageBuffersDynamic}</li>
 * <li>The total number of descriptors in descriptor set layouts created without the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT} bit set with a {@code descriptorType} of {@link VK10#VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER}, {@link VK10#VK_DESCRIPTOR_TYPE_SAMPLED_IMAGE DESCRIPTOR_TYPE_SAMPLED_IMAGE}, and {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_TEXEL_BUFFER DESCRIPTOR_TYPE_UNIFORM_TEXEL_BUFFER} accessible across all shader stages and across all elements of {@code pSetLayouts} <b>must</b> be less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxDescriptorSetSampledImages}</li>
 * <li>The total number of descriptors in descriptor set layouts created without the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT} bit set with a {@code descriptorType} of {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_IMAGE DESCRIPTOR_TYPE_STORAGE_IMAGE}, and {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_TEXEL_BUFFER DESCRIPTOR_TYPE_STORAGE_TEXEL_BUFFER} accessible across all shader stages and across all elements of {@code pSetLayouts} <b>must</b> be less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxDescriptorSetStorageImages}</li>
 * <li>The total number of descriptors in descriptor set layouts created without the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT} bit set with a {@code descriptorType} of {@link VK10#VK_DESCRIPTOR_TYPE_INPUT_ATTACHMENT DESCRIPTOR_TYPE_INPUT_ATTACHMENT} accessible across all shader stages and across all elements of {@code pSetLayouts} <b>must</b> be less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxDescriptorSetInputAttachments}</li>
 * <li>The total number of bindings in descriptor set layouts created without the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT} bit set with a {@code descriptorType} of {@link EXTInlineUniformBlock#VK_DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT} accessible across all shader stages and across all elements of {@code pSetLayouts} <b>must</b> be less than or equal to {@link VkPhysicalDeviceInlineUniformBlockPropertiesEXT}{@code ::maxDescriptorSetInlineUniformBlocks}</li>
 * <li>The total number of descriptors of the type {@link VK10#VK_DESCRIPTOR_TYPE_SAMPLER DESCRIPTOR_TYPE_SAMPLER} and {@link VK10#VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER} accessible across all shader stages and across all elements of {@code pSetLayouts} <b>must</b> be less than or equal to {@link VkPhysicalDeviceDescriptorIndexingPropertiesEXT}{@code ::maxDescriptorSetUpdateAfterBindSamplers}</li>
 * <li>The total number of descriptors of the type {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER DESCRIPTOR_TYPE_UNIFORM_BUFFER} accessible across all shader stages and across all elements of {@code pSetLayouts} <b>must</b> be less than or equal to {@link VkPhysicalDeviceDescriptorIndexingPropertiesEXT}{@code ::maxDescriptorSetUpdateAfterBindUniformBuffers}</li>
 * <li>The total number of descriptors of the type {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER_DYNAMIC DESCRIPTOR_TYPE_UNIFORM_BUFFER_DYNAMIC} accessible across all shader stages and across all elements of {@code pSetLayouts} <b>must</b> be less than or equal to {@link VkPhysicalDeviceDescriptorIndexingPropertiesEXT}{@code ::maxDescriptorSetUpdateAfterBindUniformBuffersDynamic}</li>
 * <li>The total number of descriptors of the type {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_BUFFER DESCRIPTOR_TYPE_STORAGE_BUFFER} accessible across all shader stages and across all elements of {@code pSetLayouts} <b>must</b> be less than or equal to {@link VkPhysicalDeviceDescriptorIndexingPropertiesEXT}{@code ::maxDescriptorSetUpdateAfterBindStorageBuffers}</li>
 * <li>The total number of descriptors of the type {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_BUFFER_DYNAMIC DESCRIPTOR_TYPE_STORAGE_BUFFER_DYNAMIC} accessible across all shader stages and across all elements of {@code pSetLayouts} <b>must</b> be less than or equal to {@link VkPhysicalDeviceDescriptorIndexingPropertiesEXT}{@code ::maxDescriptorSetUpdateAfterBindStorageBuffersDynamic}</li>
 * <li>The total number of descriptors of the type {@link VK10#VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER}, {@link VK10#VK_DESCRIPTOR_TYPE_SAMPLED_IMAGE DESCRIPTOR_TYPE_SAMPLED_IMAGE}, and {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_TEXEL_BUFFER DESCRIPTOR_TYPE_UNIFORM_TEXEL_BUFFER} accessible across all shader stages and across all elements of {@code pSetLayouts} <b>must</b> be less than or equal to {@link VkPhysicalDeviceDescriptorIndexingPropertiesEXT}{@code ::maxDescriptorSetUpdateAfterBindSampledImages}</li>
 * <li>The total number of descriptors of the type {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_IMAGE DESCRIPTOR_TYPE_STORAGE_IMAGE}, and {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_TEXEL_BUFFER DESCRIPTOR_TYPE_STORAGE_TEXEL_BUFFER} accessible across all shader stages and across all elements of {@code pSetLayouts} <b>must</b> be less than or equal to {@link VkPhysicalDeviceDescriptorIndexingPropertiesEXT}{@code ::maxDescriptorSetUpdateAfterBindStorageImages}</li>
 * <li>The total number of descriptors of the type {@link VK10#VK_DESCRIPTOR_TYPE_INPUT_ATTACHMENT DESCRIPTOR_TYPE_INPUT_ATTACHMENT} accessible across all shader stages and across all elements of {@code pSetLayouts} <b>must</b> be less than or equal to {@link VkPhysicalDeviceDescriptorIndexingPropertiesEXT}{@code ::maxDescriptorSetUpdateAfterBindInputAttachments}</li>
 * <li>The total number of bindings with a {@code descriptorType} of {@link EXTInlineUniformBlock#VK_DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT} accessible across all shader stages and across all elements of {@code pSetLayouts} <b>must</b> be less than or equal to {@link VkPhysicalDeviceInlineUniformBlockPropertiesEXT}{@code ::maxDescriptorSetUpdateAfterBindInlineUniformBlocks}</li>
 * <li>Any two elements of {@code pPushConstantRanges} <b>must</b> not include the same stage in {@code stageFlags}</li>
 * <li>{@code pSetLayouts} <b>must</b> not contain more than one descriptor set layout that was created with {@link KHRPushDescriptor#VK_DESCRIPTOR_SET_LAYOUT_CREATE_PUSH_DESCRIPTOR_BIT_KHR DESCRIPTOR_SET_LAYOUT_CREATE_PUSH_DESCRIPTOR_BIT_KHR} set</li>
 * <li>The total number of bindings with a {@code descriptorType} of {@link NVRayTracing#VK_DESCRIPTOR_TYPE_ACCELERATION_STRUCTURE_NV DESCRIPTOR_TYPE_ACCELERATION_STRUCTURE_NV} accessible across all shader stages and across all elements of {@code pSetLayouts} <b>must</b> be less than or equal to {@link VkPhysicalDeviceRayTracingPropertiesNV}{@code ::maxDescriptorSetAccelerationStructures}</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK10#VK_STRUCTURE_TYPE_PIPELINE_LAYOUT_CREATE_INFO STRUCTURE_TYPE_PIPELINE_LAYOUT_CREATE_INFO}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL}</li>
 * <li>{@code flags} <b>must</b> be 0</li>
 * <li>If {@code setLayoutCount} is not 0, {@code pSetLayouts} <b>must</b> be a valid pointer to an array of {@code setLayoutCount} valid {@code VkDescriptorSetLayout} handles</li>
 * <li>If {@code pushConstantRangeCount} is not 0, {@code pPushConstantRanges} <b>must</b> be a valid pointer to an array of {@code pushConstantRangeCount} valid {@link VkPushConstantRange} structures</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkPushConstantRange}, {@link VK10#vkCreatePipelineLayout CreatePipelineLayout}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code flags} &ndash; reserved for future use.</li>
 * <li>{@code setLayoutCount} &ndash; the number of descriptor sets included in the pipeline layout.</li>
 * <li>{@code pSetLayouts} &ndash; a pointer to an array of {@code VkDescriptorSetLayout} objects.</li>
 * <li>{@code pushConstantRangeCount} &ndash; the number of push constant ranges included in the pipeline layout.</li>
 * <li>{@code pPushConstantRanges} &ndash; a pointer to an array of {@link VkPushConstantRange} structures defining a set of push constant ranges for use in a single pipeline layout. In addition to descriptor set layouts, a pipeline layout also describes how many push constants <b>can</b> be accessed by each stage of the pipeline.
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>Push constants represent a high speed path to modify constant data in pipelines that is expected to outperform memory-backed resource updates.</p>
 * </div></li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPipelineLayoutCreateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkPipelineLayoutCreateFlags flags;
 *     uint32_t setLayoutCount;
 *     VkDescriptorSetLayout const * pSetLayouts;
 *     uint32_t pushConstantRangeCount;
 *     {@link VkPushConstantRange VkPushConstantRange} const * pPushConstantRanges;
 * }</code></pre>
 */
class PipelineLayoutCreateInfo(
        var setLayouts: VkDescriptorSetLayout_Array? = null,
        var pushConstantRanges: Array<PushConstantRange>? = null
) {

    val type get() = VkStructureType.PIPELINE_LAYOUT_CREATE_INFO

    infix fun write(stack: VkStack): Adr {
        val adr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
        nsType(adr, type.i)
        setLayouts?.let {
            nsetLayoutCount(adr, it.size)
            memPutAddress(adr + PSETLAYOUTS, it write stack)
        }
        pushConstantRanges?.let {
            npushConstantRangeCount(adr, it.size)
            memPutAddress(adr + PPUSHCONSTANTRANGES, it write stack)
        }
        return adr
    }
}