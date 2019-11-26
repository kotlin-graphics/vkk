package classes

import glm_.vec2.Vec2
import glm_.vec2.Vec2i
import glm_.vec3.Vec3i
import vkk.VkSampleCountFlags
import vkk.entities.VkDeviceSize

/**
 * Structure reporting implementation-dependent physical device limits.
 *
 * <h5>Description</h5>
 *
 * <dl>
 * <dt>1</dt>
 * <dd>For all bitmasks of {@code VkSampleCountFlagBits}, the sample count limits defined above represent the minimum supported sample counts for each image type. Individual images <b>may</b> support additional sample counts, which are queried using {@link VK10#vkGetPhysicalDeviceImageFormatProperties GetPhysicalDeviceImageFormatProperties} as described in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-supported-sample-counts">Supported Sample Counts</a>.</dd>
 * </dl>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkPhysicalDeviceProperties}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code maxImageDimension1D} &ndash; the maximum dimension ({@code width}) supported for all images created with an {@code imageType} of {@link VK10#VK_IMAGE_TYPE_1D IMAGE_TYPE_1D}.</li>
 * <li>{@code maxImageDimension2D} &ndash; the maximum dimension ({@code width} or {@code height}) supported for all images created with an {@code imageType} of {@link VK10#VK_IMAGE_TYPE_2D IMAGE_TYPE_2D} and without {@link VK10#VK_IMAGE_CREATE_CUBE_COMPATIBLE_BIT IMAGE_CREATE_CUBE_COMPATIBLE_BIT} set in {@code flags}.</li>
 * <li>{@code maxImageDimension3D} &ndash; the maximum dimension ({@code width}, {@code height}, or {@code depth}) supported for all images created with an {@code imageType} of {@link VK10#VK_IMAGE_TYPE_3D IMAGE_TYPE_3D}.</li>
 * <li>{@code maxImageDimensionCube} &ndash; the maximum dimension ({@code width} or {@code height}) supported for all images created with an {@code imageType} of {@link VK10#VK_IMAGE_TYPE_2D IMAGE_TYPE_2D} and with {@link VK10#VK_IMAGE_CREATE_CUBE_COMPATIBLE_BIT IMAGE_CREATE_CUBE_COMPATIBLE_BIT} set in {@code flags}.</li>
 * <li>{@code maxImageArrayLayers} &ndash; the maximum number of layers ({@code arrayLayers}) for an image.</li>
 * <li>{@code maxTexelBufferElements} &ndash; the maximum number of addressable texels for a buffer view created on a buffer which was created with the {@link VK10#VK_BUFFER_USAGE_UNIFORM_TEXEL_BUFFER_BIT BUFFER_USAGE_UNIFORM_TEXEL_BUFFER_BIT} or {@link VK10#VK_BUFFER_USAGE_STORAGE_TEXEL_BUFFER_BIT BUFFER_USAGE_STORAGE_TEXEL_BUFFER_BIT} set in the {@code usage} member of the {@link VkBufferCreateInfo} structure.</li>
 * <li>{@code maxUniformBufferRange} &ndash; the maximum value that <b>can</b> be specified in the {@code range} member of any {@link VkDescriptorBufferInfo} structures passed to a call to {@link VK10#vkUpdateDescriptorSets UpdateDescriptorSets} for descriptors of type {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER DESCRIPTOR_TYPE_UNIFORM_BUFFER} or {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER_DYNAMIC DESCRIPTOR_TYPE_UNIFORM_BUFFER_DYNAMIC}.</li>
 * <li>{@code maxStorageBufferRange} &ndash; the maximum value that <b>can</b> be specified in the {@code range} member of any {@link VkDescriptorBufferInfo} structures passed to a call to {@link VK10#vkUpdateDescriptorSets UpdateDescriptorSets} for descriptors of type {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_BUFFER DESCRIPTOR_TYPE_STORAGE_BUFFER} or {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_BUFFER_DYNAMIC DESCRIPTOR_TYPE_STORAGE_BUFFER_DYNAMIC}.</li>
 * <li>{@code maxPushConstantsSize} &ndash; the maximum size, in bytes, of the pool of push constant memory. For each of the push constant ranges indicated by the {@code pPushConstantRanges} member of the {@link VkPipelineLayoutCreateInfo} structure, <code>(offset + size)</code> <b>must</b> be less than or equal to this limit.</li>
 * <li>{@code maxMemoryAllocationCount} &ndash; the maximum number of device memory allocations, as created by {@link VK10#vkAllocateMemory AllocateMemory}, which <b>can</b> simultaneously exist.</li>
 * <li>{@code maxSamplerAllocationCount} &ndash; the maximum number of sampler objects, as created by {@link VK10#vkCreateSampler CreateSampler}, which <b>can</b> simultaneously exist on a device.</li>
 * <li>{@code bufferImageGranularity} &ndash; the granularity, in bytes, at which buffer or linear image resources, and optimal image resources <b>can</b> be bound to adjacent offsets in the same {@code VkDeviceMemory} object without aliasing. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#resources-bufferimagegranularity">Buffer-Image Granularity</a> for more details.</li>
 * <li>{@code sparseAddressSpaceSize} &ndash; the total amount of address space available, in bytes, for sparse memory resources. This is an upper bound on the sum of the size of all sparse resources, regardless of whether any memory is bound to them.</li>
 * <li>{@code maxBoundDescriptorSets} &ndash; the maximum number of descriptor sets that <b>can</b> be simultaneously used by a pipeline. All {@code DescriptorSet} decorations in shader modules <b>must</b> have a value less than {@code maxBoundDescriptorSets}. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#descriptorsets-sets">Descriptor Sets</a>.</li>
 * <li>{@code maxPerStageDescriptorSamplers} &ndash; the maximum number of samplers that <b>can</b> be accessible to a single shader stage in a pipeline layout. Descriptors with a type of {@link VK10#VK_DESCRIPTOR_TYPE_SAMPLER DESCRIPTOR_TYPE_SAMPLER} or {@link VK10#VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER} count against this limit. Only descriptors in descriptor set layouts created without the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT} bit set count against this limit. A descriptor is accessible to a shader stage when the {@code stageFlags} member of the {@link VkDescriptorSetLayoutBinding} structure has the bit for that shader stage set. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#descriptorsets-sampler">Sampler</a> and <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#descriptorsets-combinedimagesampler">Combined Image Sampler</a>.</li>
 * <li>{@code maxPerStageDescriptorUniformBuffers} &ndash; the maximum number of uniform buffers that <b>can</b> be accessible to a single shader stage in a pipeline layout. Descriptors with a type of {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER DESCRIPTOR_TYPE_UNIFORM_BUFFER} or {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER_DYNAMIC DESCRIPTOR_TYPE_UNIFORM_BUFFER_DYNAMIC} count against this limit. Only descriptors in descriptor set layouts created without the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT} bit set count against this limit. A descriptor is accessible to a shader stage when the {@code stageFlags} member of the {@link VkDescriptorSetLayoutBinding} structure has the bit for that shader stage set. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#descriptorsets-uniformbuffer">Uniform Buffer</a> and <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#descriptorsets-uniformbufferdynamic">Dynamic Uniform Buffer</a>.</li>
 * <li>{@code maxPerStageDescriptorStorageBuffers} &ndash; the maximum number of storage buffers that <b>can</b> be accessible to a single shader stage in a pipeline layout. Descriptors with a type of {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_BUFFER DESCRIPTOR_TYPE_STORAGE_BUFFER} or {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_BUFFER_DYNAMIC DESCRIPTOR_TYPE_STORAGE_BUFFER_DYNAMIC} count against this limit. Only descriptors in descriptor set layouts created without the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT} bit set count against this limit. A descriptor is accessible to a pipeline shader stage when the {@code stageFlags} member of the {@link VkDescriptorSetLayoutBinding} structure has the bit for that shader stage set. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#descriptorsets-storagebuffer">Storage Buffer</a> and <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#descriptorsets-storagebufferdynamic">Dynamic Storage Buffer</a>.</li>
 * <li>{@code maxPerStageDescriptorSampledImages} &ndash; the maximum number of sampled images that <b>can</b> be accessible to a single shader stage in a pipeline layout. Descriptors with a type of {@link VK10#VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER}, {@link VK10#VK_DESCRIPTOR_TYPE_SAMPLED_IMAGE DESCRIPTOR_TYPE_SAMPLED_IMAGE}, or {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_TEXEL_BUFFER DESCRIPTOR_TYPE_UNIFORM_TEXEL_BUFFER} count against this limit. Only descriptors in descriptor set layouts created without the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT} bit set count against this limit. A descriptor is accessible to a pipeline shader stage when the {@code stageFlags} member of the {@link VkDescriptorSetLayoutBinding} structure has the bit for that shader stage set. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#descriptorsets-combinedimagesampler">Combined Image Sampler</a>, <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#descriptorsets-sampledimage">Sampled Image</a>, and <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#descriptorsets-uniformtexelbuffer">Uniform Texel Buffer</a>.</li>
 * <li>{@code maxPerStageDescriptorStorageImages} &ndash; the maximum number of storage images that <b>can</b> be accessible to a single shader stage in a pipeline layout. Descriptors with a type of {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_IMAGE DESCRIPTOR_TYPE_STORAGE_IMAGE}, or {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_TEXEL_BUFFER DESCRIPTOR_TYPE_STORAGE_TEXEL_BUFFER} count against this limit. Only descriptors in descriptor set layouts created without the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT} bit set count against this limit. A descriptor is accessible to a pipeline shader stage when the {@code stageFlags} member of the {@link VkDescriptorSetLayoutBinding} structure has the bit for that shader stage set. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#descriptorsets-storageimage">Storage Image</a>, and <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#descriptorsets-storagetexelbuffer">Storage Texel Buffer</a>.</li>
 * <li>{@code maxPerStageDescriptorInputAttachments} &ndash; the maximum number of input attachments that <b>can</b> be accessible to a single shader stage in a pipeline layout. Descriptors with a type of {@link VK10#VK_DESCRIPTOR_TYPE_INPUT_ATTACHMENT DESCRIPTOR_TYPE_INPUT_ATTACHMENT} count against this limit. Only descriptors in descriptor set layouts created without the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT} bit set count against this limit. A descriptor is accessible to a pipeline shader stage when the {@code stageFlags} member of the {@link VkDescriptorSetLayoutBinding} structure has the bit for that shader stage set. These are only supported for the fragment stage. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#descriptorsets-inputattachment">Input Attachment</a>.</li>
 * <li>{@code maxPerStageResources} &ndash; the maximum number of resources that <b>can</b> be accessible to a single shader stage in a pipeline layout. Descriptors with a type of {@link VK10#VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER}, {@link VK10#VK_DESCRIPTOR_TYPE_SAMPLED_IMAGE DESCRIPTOR_TYPE_SAMPLED_IMAGE}, {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_IMAGE DESCRIPTOR_TYPE_STORAGE_IMAGE}, {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_TEXEL_BUFFER DESCRIPTOR_TYPE_UNIFORM_TEXEL_BUFFER}, {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_TEXEL_BUFFER DESCRIPTOR_TYPE_STORAGE_TEXEL_BUFFER}, {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER DESCRIPTOR_TYPE_UNIFORM_BUFFER}, {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_BUFFER DESCRIPTOR_TYPE_STORAGE_BUFFER}, {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER_DYNAMIC DESCRIPTOR_TYPE_UNIFORM_BUFFER_DYNAMIC}, {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_BUFFER_DYNAMIC DESCRIPTOR_TYPE_STORAGE_BUFFER_DYNAMIC}, or {@link VK10#VK_DESCRIPTOR_TYPE_INPUT_ATTACHMENT DESCRIPTOR_TYPE_INPUT_ATTACHMENT} count against this limit. Only descriptors in descriptor set layouts created without the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT} bit set count against this limit. For the fragment shader stage the framebuffer color attachments also count against this limit.</li>
 * <li>{@code maxDescriptorSetSamplers} &ndash; the maximum number of samplers that <b>can</b> be included in descriptor bindings in a pipeline layout across all pipeline shader stages and descriptor set numbers. Descriptors with a type of {@link VK10#VK_DESCRIPTOR_TYPE_SAMPLER DESCRIPTOR_TYPE_SAMPLER} or {@link VK10#VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER} count against this limit. Only descriptors in descriptor set layouts created without the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT} bit set count against this limit. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#descriptorsets-sampler">Sampler</a> and <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#descriptorsets-combinedimagesampler">Combined Image Sampler</a>.</li>
 * <li>{@code maxDescriptorSetUniformBuffers} &ndash; the maximum number of uniform buffers that <b>can</b> be included in descriptor bindings in a pipeline layout across all pipeline shader stages and descriptor set numbers. Descriptors with a type of {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER DESCRIPTOR_TYPE_UNIFORM_BUFFER} or {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER_DYNAMIC DESCRIPTOR_TYPE_UNIFORM_BUFFER_DYNAMIC} count against this limit. Only descriptors in descriptor set layouts created without the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT} bit set count against this limit. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#descriptorsets-uniformbuffer">Uniform Buffer</a> and <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#descriptorsets-uniformbufferdynamic">Dynamic Uniform Buffer</a>.</li>
 * <li>{@code maxDescriptorSetUniformBuffersDynamic} &ndash; the maximum number of dynamic uniform buffers that <b>can</b> be included in descriptor bindings in a pipeline layout across all pipeline shader stages and descriptor set numbers. Descriptors with a type of {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER_DYNAMIC DESCRIPTOR_TYPE_UNIFORM_BUFFER_DYNAMIC} count against this limit. Only descriptors in descriptor set layouts created without the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT} bit set count against this limit. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#descriptorsets-uniformbufferdynamic">Dynamic Uniform Buffer</a>.</li>
 * <li>{@code maxDescriptorSetStorageBuffers} &ndash; the maximum number of storage buffers that <b>can</b> be included in descriptor bindings in a pipeline layout across all pipeline shader stages and descriptor set numbers. Descriptors with a type of {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_BUFFER DESCRIPTOR_TYPE_STORAGE_BUFFER} or {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_BUFFER_DYNAMIC DESCRIPTOR_TYPE_STORAGE_BUFFER_DYNAMIC} count against this limit. Only descriptors in descriptor set layouts created without the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT} bit set count against this limit. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#descriptorsets-storagebuffer">Storage Buffer</a> and <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#descriptorsets-storagebufferdynamic">Dynamic Storage Buffer</a>.</li>
 * <li>{@code maxDescriptorSetStorageBuffersDynamic} &ndash; the maximum number of dynamic storage buffers that <b>can</b> be included in descriptor bindings in a pipeline layout across all pipeline shader stages and descriptor set numbers. Descriptors with a type of {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_BUFFER_DYNAMIC DESCRIPTOR_TYPE_STORAGE_BUFFER_DYNAMIC} count against this limit. Only descriptors in descriptor set layouts created without the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT} bit set count against this limit. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#descriptorsets-storagebufferdynamic">Dynamic Storage Buffer</a>.</li>
 * <li>{@code maxDescriptorSetSampledImages} &ndash; the maximum number of sampled images that <b>can</b> be included in descriptor bindings in a pipeline layout across all pipeline shader stages and descriptor set numbers. Descriptors with a type of {@link VK10#VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER}, {@link VK10#VK_DESCRIPTOR_TYPE_SAMPLED_IMAGE DESCRIPTOR_TYPE_SAMPLED_IMAGE}, or {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_TEXEL_BUFFER DESCRIPTOR_TYPE_UNIFORM_TEXEL_BUFFER} count against this limit. Only descriptors in descriptor set layouts created without the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT} bit set count against this limit. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#descriptorsets-combinedimagesampler">Combined Image Sampler</a>, <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#descriptorsets-sampledimage">Sampled Image</a>, and <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#descriptorsets-uniformtexelbuffer">Uniform Texel Buffer</a>.</li>
 * <li>{@code maxDescriptorSetStorageImages} &ndash; the maximum number of storage images that <b>can</b> be included in descriptor bindings in a pipeline layout across all pipeline shader stages and descriptor set numbers. Descriptors with a type of {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_IMAGE DESCRIPTOR_TYPE_STORAGE_IMAGE}, or {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_TEXEL_BUFFER DESCRIPTOR_TYPE_STORAGE_TEXEL_BUFFER} count against this limit. Only descriptors in descriptor set layouts created without the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT} bit set count against this limit. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#descriptorsets-storageimage">Storage Image</a>, and <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#descriptorsets-storagetexelbuffer">Storage Texel Buffer</a>.</li>
 * <li>{@code maxDescriptorSetInputAttachments} &ndash; the maximum number of input attachments that <b>can</b> be included in descriptor bindings in a pipeline layout across all pipeline shader stages and descriptor set numbers. Descriptors with a type of {@link VK10#VK_DESCRIPTOR_TYPE_INPUT_ATTACHMENT DESCRIPTOR_TYPE_INPUT_ATTACHMENT} count against this limit. Only descriptors in descriptor set layouts created without the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT} bit set count against this limit. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#descriptorsets-inputattachment">Input Attachment</a>.</li>
 * <li>{@code maxVertexInputAttributes} &ndash; the maximum number of vertex input attributes that <b>can</b> be specified for a graphics pipeline. These are described in the array of {@link VkVertexInputAttributeDescription} structures that are provided at graphics pipeline creation time via the {@code pVertexAttributeDescriptions} member of the {@link VkPipelineVertexInputStateCreateInfo} structure. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#fxvertex-attrib">Vertex Attributes</a> and <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#fxvertex-input">Vertex Input Description</a>.</li>
 * <li>{@code maxVertexInputBindings} &ndash; the maximum number of vertex buffers that <b>can</b> be specified for providing vertex attributes to a graphics pipeline. These are described in the array of {@link VkVertexInputBindingDescription} structures that are provided at graphics pipeline creation time via the {@code pVertexBindingDescriptions} member of the {@link VkPipelineVertexInputStateCreateInfo} structure. The {@code binding} member of {@link VkVertexInputBindingDescription} <b>must</b> be less than this limit. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#fxvertex-input">Vertex Input Description</a>.</li>
 * <li>{@code maxVertexInputAttributeOffset} &ndash; the maximum vertex input attribute offset that <b>can</b> be added to the vertex input binding stride. The {@code offset} member of the {@link VkVertexInputAttributeDescription} structure <b>must</b> be less than or equal to this limit. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#fxvertex-input">Vertex Input Description</a>.</li>
 * <li>{@code maxVertexInputBindingStride} &ndash; the maximum vertex input binding stride that <b>can</b> be specified in a vertex input binding. The {@code stride} member of the {@link VkVertexInputBindingDescription} structure <b>must</b> be less than or equal to this limit. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#fxvertex-input">Vertex Input Description</a>.</li>
 * <li>{@code maxVertexOutputComponents} &ndash; the maximum number of components of output variables which <b>can</b> be output by a vertex shader. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#shaders-vertex">Vertex Shaders</a>.</li>
 * <li>{@code maxTessellationGenerationLevel} &ndash; the maximum tessellation generation level supported by the fixed-function tessellation primitive generator. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#tessellation">Tessellation</a>.</li>
 * <li>{@code maxTessellationPatchSize} &ndash; the maximum patch size, in vertices, of patches that <b>can</b> be processed by the tessellation control shader and tessellation primitive generator. The {@code patchControlPoints} member of the {@link VkPipelineTessellationStateCreateInfo} structure specified at pipeline creation time and the value provided in the {@code OutputVertices} execution mode of shader modules <b>must</b> be less than or equal to this limit. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#tessellation">Tessellation</a>.</li>
 * <li>{@code maxTessellationControlPerVertexInputComponents} &ndash; the maximum number of components of input variables which <b>can</b> be provided as per-vertex inputs to the tessellation control shader stage.</li>
 * <li>{@code maxTessellationControlPerVertexOutputComponents} &ndash; the maximum number of components of per-vertex output variables which <b>can</b> be output from the tessellation control shader stage.</li>
 * <li>{@code maxTessellationControlPerPatchOutputComponents} &ndash; the maximum number of components of per-patch output variables which <b>can</b> be output from the tessellation control shader stage.</li>
 * <li>{@code maxTessellationControlTotalOutputComponents} &ndash; the maximum total number of components of per-vertex and per-patch output variables which <b>can</b> be output from the tessellation control shader stage.</li>
 * <li>{@code maxTessellationEvaluationInputComponents} &ndash; the maximum number of components of input variables which <b>can</b> be provided as per-vertex inputs to the tessellation evaluation shader stage.</li>
 * <li>{@code maxTessellationEvaluationOutputComponents} &ndash; the maximum number of components of per-vertex output variables which <b>can</b> be output from the tessellation evaluation shader stage.</li>
 * <li>{@code maxGeometryShaderInvocations} &ndash; the maximum invocation count supported for instanced geometry shaders. The value provided in the {@code Invocations} execution mode of shader modules <b>must</b> be less than or equal to this limit. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#geometry">Geometry Shading</a>.</li>
 * <li>{@code maxGeometryInputComponents} &ndash; the maximum number of components of input variables which <b>can</b> be provided as inputs to the geometry shader stage.</li>
 * <li>{@code maxGeometryOutputComponents} &ndash; the maximum number of components of output variables which <b>can</b> be output from the geometry shader stage.</li>
 * <li>{@code maxGeometryOutputVertices} &ndash; the maximum number of vertices which <b>can</b> be emitted by any geometry shader.</li>
 * <li>{@code maxGeometryTotalOutputComponents} &ndash; the maximum total number of components of output, across all emitted vertices, which <b>can</b> be output from the geometry shader stage.</li>
 * <li>{@code maxFragmentInputComponents} &ndash; the maximum number of components of input variables which <b>can</b> be provided as inputs to the fragment shader stage.</li>
 * <li>{@code maxFragmentOutputAttachments} &ndash; the maximum number of output attachments which <b>can</b> be written to by the fragment shader stage.</li>
 * <li>{@code maxFragmentDualSrcAttachments} &ndash; the maximum number of output attachments which <b>can</b> be written to by the fragment shader stage when blending is enabled and one of the dual source blend modes is in use. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#framebuffer-dsb">Dual-Source Blending</a> and <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-dualSrcBlend">dualSrcBlend</a>.</li>
 * <li>{@code maxFragmentCombinedOutputResources} &ndash; the total number of storage buffers, storage images, and output buffers which <b>can</b> be used in the fragment shader stage.</li>
 * <li>{@code maxComputeSharedMemorySize} &ndash; the maximum total storage size, in bytes, available for variables declared with the {@code Workgroup} storage class in shader modules (or with the {@code shared} storage qualifier in GLSL) in the compute shader stage. The amount of storage consumed by the variables declared with the {@code Workgroup} storage class is implementation-dependent. However, the amount of storage consumed may not exceed the largest block size that would be obtained if all active variables declared with {@code Workgroup} storage class were assigned offsets in an arbitrary order by successively taking the smallest valid offset according to the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#interfaces-resources-layout-std430">Standard Storage Buffer Layout</a> rules. (This is equivalent to using the GLSL std430 layout rules.)</li>
 * <li>{@code maxComputeWorkGroupCount[3]} &ndash; the maximum number of local workgroups that <b>can</b> be dispatched by a single dispatch command. These three values represent the maximum number of local workgroups for the X, Y, and Z dimensions, respectively. The workgroup count parameters to the dispatch commands <b>must</b> be less than or equal to the corresponding limit. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#dispatch">Dispatching Commands</a>.</li>
 * <li>{@code maxComputeWorkGroupInvocations} &ndash; the maximum total number of compute shader invocations in a single local workgroup. The product of the X, Y, and Z sizes, as specified by the {@code LocalSize} execution mode in shader modules or by the object decorated by the {@code WorkgroupSize} decoration, <b>must</b> be less than or equal to this limit.</li>
 * <li>{@code maxComputeWorkGroupSize[3]} &ndash; the maximum size of a local compute workgroup, per dimension. These three values represent the maximum local workgroup size in the X, Y, and Z dimensions, respectively. The {@code x}, {@code y}, and {@code z} sizes, as specified by the {@code LocalSize} execution mode or by the object decorated by the {@code WorkgroupSize} decoration in shader modules, <b>must</b> be less than or equal to the corresponding limit.</li>
 * <li>{@code subPixelPrecisionBits} &ndash; the number of bits of subpixel precision in framebuffer coordinates <code>x<sub>f</sub></code> and <code>y<sub>f</sub></code>. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#primsrast">Rasterization</a>.</li>
 * <li>{@code subTexelPrecisionBits} &ndash; the number of bits of precision in the division along an axis of an image used for minification and magnification filters. <code>2<sup>subTexelPrecisionBits</sup></code> is the actual number of divisions along each axis of the image represented. Sub-texel values calculated during image sampling will snap to these locations when generating the filtered results.</li>
 * <li>{@code mipmapPrecisionBits} &ndash; the number of bits of division that the LOD calculation for mipmap fetching get snapped to when determining the contribution from each mip level to the mip filtered results. <code>2<sup>mipmapPrecisionBits</sup></code> is the actual number of divisions.</li>
 * <li>{@code maxDrawIndexedIndexValue} &ndash; the maximum index value that <b>can</b> be used for indexed draw calls when using 32-bit indices. This excludes the primitive restart index value of 0xFFFFFFFF. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-fullDrawIndexUint32">fullDrawIndexUint32</a>.</li>
 * <li>{@code maxDrawIndirectCount} &ndash; the maximum draw count that is supported for indirect draw calls. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-multiDrawIndirect">multiDrawIndirect</a>.</li>
 * <li>{@code maxSamplerLodBias} &ndash; the maximum absolute sampler LOD bias. The sum of the {@code mipLodBias} member of the {@link VkSamplerCreateInfo} structure and the {@code Bias} operand of image sampling operations in shader modules (or 0 if no {@code Bias} operand is provided to an image sampling operation) are clamped to the range <code>[-maxSamplerLodBias,+maxSamplerLodBias]</code>. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#samplers-mipLodBias">samplers-mipLodBias</a>.</li>
 * <li>{@code maxSamplerAnisotropy} &ndash; the maximum degree of sampler anisotropy. The maximum degree of anisotropic filtering used for an image sampling operation is the minimum of the {@code maxAnisotropy} member of the {@link VkSamplerCreateInfo} structure and this limit. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#samplers-maxAnisotropy">samplers-maxAnisotropy</a>.</li>
 * <li>{@code maxViewports} &ndash; the maximum number of active viewports. The {@code viewportCount} member of the {@link VkPipelineViewportStateCreateInfo} structure that is provided at pipeline creation <b>must</b> be less than or equal to this limit.</li>
 * <li>{@code maxViewportDimensions[2]} &ndash; are the maximum viewport dimensions in the X (width) and Y (height) dimensions, respectively. The maximum viewport dimensions <b>must</b> be greater than or equal to the largest image which <b>can</b> be created and used as a framebuffer attachment. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#vertexpostproc-viewport">Controlling the Viewport</a>.</li>
 * <li>{@code viewportBoundsRange[2]} &ndash; the <code>[minimum, maximum]</code> range that the corners of a viewport <b>must</b> be contained in. This range <b>must</b> be at least <code>[-2 × size, 2 × size - 1]</code>, where <code>size = max(maxViewportDimensions[0], maxViewportDimensions[1])</code>. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#vertexpostproc-viewport">Controlling the Viewport</a>.
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>The intent of the {@code viewportBoundsRange} limit is to allow a maximum sized viewport to be arbitrarily shifted relative to the output target as long as at least some portion intersects. This would give a bounds limit of <code>[-size + 1, 2 × size - 1]</code> which would allow all possible non-empty-set intersections of the output target and the viewport. Since these numbers are typically powers of two, picking the signed number range using the smallest possible number of bits ends up with the specified range.</p>
 * </div></li>
 * <li>{@code viewportSubPixelBits} &ndash; the number of bits of subpixel precision for viewport bounds. The subpixel precision that floating-point viewport bounds are interpreted at is given by this limit.</li>
 * <li>{@code minMemoryMapAlignment} &ndash; the minimum required: alignment, in bytes, of host visible memory allocations within the host address space. When mapping a memory allocation with {@link VK10#vkMapMemory MapMemory}, subtracting {@code offset} bytes from the returned pointer will always produce an integer multiple of this limit. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#memory-device-hostaccess">Host Access to Device Memory Objects</a>.</li>
 * <li>{@code minTexelBufferOffsetAlignment} &ndash; the minimum required: alignment, in bytes, for the {@code offset} member of the {@link VkBufferViewCreateInfo} structure for texel buffers. If <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-texelBufferAlignment">texelBufferAlignment</a> is enabled, this limit is equivalent to the maximum of the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#limits-uniformTexelBufferOffsetAlignmentBytes">{@code uniformTexelBufferOffsetAlignmentBytes}</a> and <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#limits-storageTexelBufferOffsetAlignmentBytes">{@code storageTexelBufferOffsetAlignmentBytes}</a> members of {@link VkPhysicalDeviceTexelBufferAlignmentPropertiesEXT}, but smaller alignment is optionally: allowed by <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#limits-storageTexelBufferOffsetSingleTexelAlignment">{@code storageTexelBufferOffsetSingleTexelAlignment}</a> and <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#limits-uniformTexelBufferOffsetSingleTexelAlignment">{@code uniformTexelBufferOffsetSingleTexelAlignment}</a>. If <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-texelBufferAlignment">texelBufferAlignment</a> is not enabled, {@link VkBufferViewCreateInfo}{@code ::offset} <b>must</b> be a multiple of this value.</li>
 * <li>{@code minUniformBufferOffsetAlignment} &ndash; the minimum required: alignment, in bytes, for the {@code offset} member of the {@link VkDescriptorBufferInfo} structure for uniform buffers. When a descriptor of type {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER DESCRIPTOR_TYPE_UNIFORM_BUFFER} or {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER_DYNAMIC DESCRIPTOR_TYPE_UNIFORM_BUFFER_DYNAMIC} is updated, the {@code offset} <b>must</b> be an integer multiple of this limit. Similarly, dynamic offsets for uniform buffers <b>must</b> be multiples of this limit.</li>
 * <li>{@code minStorageBufferOffsetAlignment} &ndash; the minimum required: alignment, in bytes, for the {@code offset} member of the {@link VkDescriptorBufferInfo} structure for storage buffers. When a descriptor of type {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_BUFFER DESCRIPTOR_TYPE_STORAGE_BUFFER} or {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_BUFFER_DYNAMIC DESCRIPTOR_TYPE_STORAGE_BUFFER_DYNAMIC} is updated, the {@code offset} <b>must</b> be an integer multiple of this limit. Similarly, dynamic offsets for storage buffers <b>must</b> be multiples of this limit.</li>
 * <li>{@code minTexelOffset} &ndash; the minimum offset value for the {@code ConstOffset} image operand of any of the {@code OpImageSample}* or {@code OpImageFetch}* image instructions.</li>
 * <li>{@code maxTexelOffset} &ndash; the maximum offset value for the {@code ConstOffset} image operand of any of the {@code OpImageSample}* or {@code OpImageFetch}* image instructions.</li>
 * <li>{@code minTexelGatherOffset} &ndash; the minimum offset value for the {@code Offset}, {@code ConstOffset}, or {@code ConstOffsets} image operands of any of the {@code OpImage}*{@code Gather} image instructions.</li>
 * <li>{@code maxTexelGatherOffset} &ndash; the maximum offset value for the {@code Offset}, {@code ConstOffset}, or {@code ConstOffsets} image operands of any of the {@code OpImage}*{@code Gather} image instructions.</li>
 * <li>{@code minInterpolationOffset} &ndash; the minimum negative offset value for the {@code offset} operand of the {@code InterpolateAtOffset} extended instruction.</li>
 * <li>{@code maxInterpolationOffset} &ndash; the maximum positive offset value for the {@code offset} operand of the {@code InterpolateAtOffset} extended instruction.</li>
 * <li>{@code subPixelInterpolationOffsetBits} &ndash; the number of subpixel fractional bits that the {@code x} and {@code y} offsets to the {@code InterpolateAtOffset} extended instruction <b>may</b> be rounded to as fixed-point values.</li>
 * <li>{@code maxFramebufferWidth} &ndash; the maximum width for a framebuffer. The {@code width} member of the {@link VkFramebufferCreateInfo} structure <b>must</b> be less than or equal to this limit.</li>
 * <li>{@code maxFramebufferHeight} &ndash; the maximum height for a framebuffer. The {@code height} member of the {@link VkFramebufferCreateInfo} structure <b>must</b> be less than or equal to this limit.</li>
 * <li>{@code maxFramebufferLayers} &ndash; the maximum layer count for a layered framebuffer. The {@code layers} member of the {@link VkFramebufferCreateInfo} structure <b>must</b> be less than or equal to this limit.</li>
 * <li>{@code framebufferColorSampleCounts} &ndash; a bitmask<sup>1</sup> of {@code VkSampleCountFlagBits} indicating the color sample counts that are supported for all framebuffer color attachments with floating- or fixed-point formats. There is no limit that specifies the color sample counts that are supported for all color attachments with integer formats.</li>
 * <li>{@code framebufferDepthSampleCounts} &ndash; a bitmask<sup>1</sup> of {@code VkSampleCountFlagBits} indicating the supported depth sample counts for all framebuffer depth/stencil attachments, when the format includes a depth component.</li>
 * <li>{@code framebufferStencilSampleCounts} &ndash; a bitmask<sup>1</sup> of {@code VkSampleCountFlagBits} indicating the supported stencil sample counts for all framebuffer depth/stencil attachments, when the format includes a stencil component.</li>
 * <li>{@code framebufferNoAttachmentsSampleCounts} &ndash; a bitmask<sup>1</sup> of {@code VkSampleCountFlagBits} indicating the supported sample counts for a framebuffer with no attachments.</li>
 * <li>{@code maxColorAttachments} &ndash; the maximum number of color attachments that <b>can</b> be used by a subpass in a render pass. The {@code colorAttachmentCount} member of the {@link VkSubpassDescription} structure <b>must</b> be less than or equal to this limit.</li>
 * <li>{@code sampledImageColorSampleCounts} &ndash; a bitmask<sup>1</sup> of {@code VkSampleCountFlagBits} indicating the sample counts supported for all 2D images created with {@link VK10#VK_IMAGE_TILING_OPTIMAL IMAGE_TILING_OPTIMAL}, {@code usage} containing {@link VK10#VK_IMAGE_USAGE_SAMPLED_BIT IMAGE_USAGE_SAMPLED_BIT}, and a non-integer color format.</li>
 * <li>{@code sampledImageIntegerSampleCounts} &ndash; a bitmask<sup>1</sup> of {@code VkSampleCountFlagBits} indicating the sample counts supported for all 2D images created with {@link VK10#VK_IMAGE_TILING_OPTIMAL IMAGE_TILING_OPTIMAL}, {@code usage} containing {@link VK10#VK_IMAGE_USAGE_SAMPLED_BIT IMAGE_USAGE_SAMPLED_BIT}, and an integer color format.</li>
 * <li>{@code sampledImageDepthSampleCounts} &ndash; a bitmask<sup>1</sup> of {@code VkSampleCountFlagBits} indicating the sample counts supported for all 2D images created with {@link VK10#VK_IMAGE_TILING_OPTIMAL IMAGE_TILING_OPTIMAL}, {@code usage} containing {@link VK10#VK_IMAGE_USAGE_SAMPLED_BIT IMAGE_USAGE_SAMPLED_BIT}, and a depth format.</li>
 * <li>{@code sampledImageStencilSampleCounts} &ndash; a bitmask<sup>1</sup> of {@code VkSampleCountFlagBits} indicating the sample supported for all 2D images created with {@link VK10#VK_IMAGE_TILING_OPTIMAL IMAGE_TILING_OPTIMAL}, {@code usage} containing {@link VK10#VK_IMAGE_USAGE_SAMPLED_BIT IMAGE_USAGE_SAMPLED_BIT}, and a stencil format.</li>
 * <li>{@code storageImageSampleCounts} &ndash; a bitmask<sup>1</sup> of {@code VkSampleCountFlagBits} indicating the sample counts supported for all 2D images created with {@link VK10#VK_IMAGE_TILING_OPTIMAL IMAGE_TILING_OPTIMAL}, and {@code usage} containing {@link VK10#VK_IMAGE_USAGE_STORAGE_BIT IMAGE_USAGE_STORAGE_BIT}.</li>
 * <li>{@code maxSampleMaskWords} &ndash; the maximum number of array elements of a variable decorated with the {@code SampleMask} built-in decoration.</li>
 * <li>{@code timestampComputeAndGraphics} &ndash; specifies support for timestamps on all graphics and compute queues. If this limit is set to {@link VK10#VK_TRUE TRUE}, all queues that advertise the {@link VK10#VK_QUEUE_GRAPHICS_BIT QUEUE_GRAPHICS_BIT} or {@link VK10#VK_QUEUE_COMPUTE_BIT QUEUE_COMPUTE_BIT} in the {@link VkQueueFamilyProperties}{@code ::queueFlags} support {@link VkQueueFamilyProperties}{@code ::timestampValidBits} of at least 36. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#queries-timestamps">Timestamp Queries</a>.</li>
 * <li>{@code timestampPeriod} &ndash; the number of nanoseconds required: for a timestamp query to be incremented by 1. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#queries-timestamps">Timestamp Queries</a>.</li>
 * <li>{@code maxClipDistances} &ndash; the maximum number of clip distances that <b>can</b> be used in a single shader stage. The size of any array declared with the {@code ClipDistance} built-in decoration in a shader module <b>must</b> be less than or equal to this limit.</li>
 * <li>{@code maxCullDistances} &ndash; the maximum number of cull distances that <b>can</b> be used in a single shader stage. The size of any array declared with the {@code CullDistance} built-in decoration in a shader module <b>must</b> be less than or equal to this limit.</li>
 * <li>{@code maxCombinedClipAndCullDistances} &ndash; the maximum combined number of clip and cull distances that <b>can</b> be used in a single shader stage. The sum of the sizes of any pair of arrays declared with the {@code ClipDistance} and {@code CullDistance} built-in decoration used by a single shader stage in a shader module <b>must</b> be less than or equal to this limit.</li>
 * <li>{@code discreteQueuePriorities} &ndash; the number of discrete priorities that <b>can</b> be assigned to a queue based on the value of each member of {@link VkDeviceQueueCreateInfo}{@code ::pQueuePriorities}. This <b>must</b> be at least 2, and levels <b>must</b> be spread evenly over the range, with at least one level at 1.0, and another at 0.0. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#devsandqueues-priority">Queue Priority</a>.</li>
 * <li>{@code pointSizeRange[2]} &ndash; the range <code>[minimum,maximum]</code> of supported sizes for points. Values written to variables decorated with the {@code PointSize} built-in decoration are clamped to this range.</li>
 * <li>{@code lineWidthRange[2]} &ndash; the range <code>[minimum,maximum]</code> of supported widths for lines. Values specified by the {@code lineWidth} member of the {@link VkPipelineRasterizationStateCreateInfo} or the {@code lineWidth} parameter to {@code vkCmdSetLineWidth} are clamped to this range.</li>
 * <li>{@code pointSizeGranularity} &ndash; the granularity of supported point sizes. Not all point sizes in the range defined by {@code pointSizeRange} are supported. This limit specifies the granularity (or increment) between successive supported point sizes.</li>
 * <li>{@code lineWidthGranularity} &ndash; the granularity of supported line widths. Not all line widths in the range defined by {@code lineWidthRange} are supported. This limit specifies the granularity (or increment) between successive supported line widths.</li>
 * <li>{@code strictLines} &ndash; specifies whether lines are rasterized according to the preferred method of rasterization. If set to {@link VK10#VK_FALSE FALSE}, lines <b>may</b> be rasterized under a relaxed set of rules. If set to {@link VK10#VK_TRUE TRUE}, lines are rasterized as per the strict definition. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#primsrast-lines-basic">Basic Line Segment Rasterization</a>.</li>
 * <li>{@code standardSampleLocations} &ndash; specifies whether rasterization uses the standard sample locations as documented in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#primsrast-multisampling">Multisampling</a>. If set to {@link VK10#VK_TRUE TRUE}, the implementation uses the documented sample locations. If set to {@link VK10#VK_FALSE FALSE}, the implementation <b>may</b> use different sample locations.</li>
 * <li>{@code optimalBufferCopyOffsetAlignment} &ndash; the optimal buffer offset alignment in bytes for {@code vkCmdCopyBufferToImage} and {@code vkCmdCopyImageToBuffer}. The per texel alignment requirements are enforced, but applications <b>should</b> use the optimal alignment for optimal performance and power use.</li>
 * <li>{@code optimalBufferCopyRowPitchAlignment} &ndash; the optimal buffer row pitch alignment in bytes for {@code vkCmdCopyBufferToImage} and {@code vkCmdCopyImageToBuffer}. Row pitch is the number of bytes between texels with the same X coordinate in adjacent rows (Y coordinates differ by one). The per texel alignment requirements are enforced, but applications <b>should</b> use the optimal alignment for optimal performance and power use.</li>
 * <li>{@code nonCoherentAtomSize} &ndash; the size and alignment in bytes that bounds concurrent access to <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#memory-device-hostaccess">host-mapped device memory</a>.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPhysicalDeviceLimits {
 *     uint32_t maxImageDimension1D;
 *     uint32_t maxImageDimension2D;
 *     uint32_t maxImageDimension3D;
 *     uint32_t maxImageDimensionCube;
 *     uint32_t maxImageArrayLayers;
 *     uint32_t maxTexelBufferElements;
 *     uint32_t maxUniformBufferRange;
 *     uint32_t maxStorageBufferRange;
 *     uint32_t maxPushConstantsSize;
 *     uint32_t maxMemoryAllocationCount;
 *     uint32_t maxSamplerAllocationCount;
 *     VkDeviceSize bufferImageGranularity;
 *     VkDeviceSize sparseAddressSpaceSize;
 *     uint32_t maxBoundDescriptorSets;
 *     uint32_t maxPerStageDescriptorSamplers;
 *     uint32_t maxPerStageDescriptorUniformBuffers;
 *     uint32_t maxPerStageDescriptorStorageBuffers;
 *     uint32_t maxPerStageDescriptorSampledImages;
 *     uint32_t maxPerStageDescriptorStorageImages;
 *     uint32_t maxPerStageDescriptorInputAttachments;
 *     uint32_t maxPerStageResources;
 *     uint32_t maxDescriptorSetSamplers;
 *     uint32_t maxDescriptorSetUniformBuffers;
 *     uint32_t maxDescriptorSetUniformBuffersDynamic;
 *     uint32_t maxDescriptorSetStorageBuffers;
 *     uint32_t maxDescriptorSetStorageBuffersDynamic;
 *     uint32_t maxDescriptorSetSampledImages;
 *     uint32_t maxDescriptorSetStorageImages;
 *     uint32_t maxDescriptorSetInputAttachments;
 *     uint32_t maxVertexInputAttributes;
 *     uint32_t maxVertexInputBindings;
 *     uint32_t maxVertexInputAttributeOffset;
 *     uint32_t maxVertexInputBindingStride;
 *     uint32_t maxVertexOutputComponents;
 *     uint32_t maxTessellationGenerationLevel;
 *     uint32_t maxTessellationPatchSize;
 *     uint32_t maxTessellationControlPerVertexInputComponents;
 *     uint32_t maxTessellationControlPerVertexOutputComponents;
 *     uint32_t maxTessellationControlPerPatchOutputComponents;
 *     uint32_t maxTessellationControlTotalOutputComponents;
 *     uint32_t maxTessellationEvaluationInputComponents;
 *     uint32_t maxTessellationEvaluationOutputComponents;
 *     uint32_t maxGeometryShaderInvocations;
 *     uint32_t maxGeometryInputComponents;
 *     uint32_t maxGeometryOutputComponents;
 *     uint32_t maxGeometryOutputVertices;
 *     uint32_t maxGeometryTotalOutputComponents;
 *     uint32_t maxFragmentInputComponents;
 *     uint32_t maxFragmentOutputAttachments;
 *     uint32_t maxFragmentDualSrcAttachments;
 *     uint32_t maxFragmentCombinedOutputResources;
 *     uint32_t maxComputeSharedMemorySize;
 *     uint32_t maxComputeWorkGroupCount[3];
 *     uint32_t maxComputeWorkGroupInvocations;
 *     uint32_t maxComputeWorkGroupSize[3];
 *     uint32_t subPixelPrecisionBits;
 *     uint32_t subTexelPrecisionBits;
 *     uint32_t mipmapPrecisionBits;
 *     uint32_t maxDrawIndexedIndexValue;
 *     uint32_t maxDrawIndirectCount;
 *     float maxSamplerLodBias;
 *     float maxSamplerAnisotropy;
 *     uint32_t maxViewports;
 *     uint32_t maxViewportDimensions[2];
 *     float viewportBoundsRange[2];
 *     uint32_t viewportSubPixelBits;
 *     size_t minMemoryMapAlignment;
 *     VkDeviceSize minTexelBufferOffsetAlignment;
 *     VkDeviceSize minUniformBufferOffsetAlignment;
 *     VkDeviceSize minStorageBufferOffsetAlignment;
 *     int32_t minTexelOffset;
 *     uint32_t maxTexelOffset;
 *     int32_t minTexelGatherOffset;
 *     uint32_t maxTexelGatherOffset;
 *     float minInterpolationOffset;
 *     float maxInterpolationOffset;
 *     uint32_t subPixelInterpolationOffsetBits;
 *     uint32_t maxFramebufferWidth;
 *     uint32_t maxFramebufferHeight;
 *     uint32_t maxFramebufferLayers;
 *     VkSampleCountFlags framebufferColorSampleCounts;
 *     VkSampleCountFlags framebufferDepthSampleCounts;
 *     VkSampleCountFlags framebufferStencilSampleCounts;
 *     VkSampleCountFlags framebufferNoAttachmentsSampleCounts;
 *     uint32_t maxColorAttachments;
 *     VkSampleCountFlags sampledImageColorSampleCounts;
 *     VkSampleCountFlags sampledImageIntegerSampleCounts;
 *     VkSampleCountFlags sampledImageDepthSampleCounts;
 *     VkSampleCountFlags sampledImageStencilSampleCounts;
 *     VkSampleCountFlags storageImageSampleCounts;
 *     uint32_t maxSampleMaskWords;
 *     VkBool32 timestampComputeAndGraphics;
 *     float timestampPeriod;
 *     uint32_t maxClipDistances;
 *     uint32_t maxCullDistances;
 *     uint32_t maxCombinedClipAndCullDistances;
 *     uint32_t discreteQueuePriorities;
 *     float pointSizeRange[2];
 *     float lineWidthRange[2];
 *     float pointSizeGranularity;
 *     float lineWidthGranularity;
 *     VkBool32 strictLines;
 *     VkBool32 standardSampleLocations;
 *     VkDeviceSize optimalBufferCopyOffsetAlignment;
 *     VkDeviceSize optimalBufferCopyRowPitchAlignment;
 *     VkDeviceSize nonCoherentAtomSize;
 * }</code></pre>
 */
class PhysicalDeviceLimits (
var maxImageDimension1D: Int,
var maxImageDimension2D: Int,
var maxImageDimension3D: Int,
var maxImageDimensionCube: Int,
var maxImageArrayLayers: Int,
var maxTexelBufferElements: Int,
var maxUniformBufferRange: Int,
var maxStorageBufferRange: Int,
var maxPushConstantsSize: Int,
var maxMemoryAllocationCount: Int,
var maxSamplerAllocationCount: Int,
var bufferImageGranularity: VkDeviceSize,
var sparseAddressSpaceSize: VkDeviceSize,
var maxBoundDescriptorSets: Int,
var maxPerStageDescriptorSamplers: Int,
var maxPerStageDescriptorUniformBuffers: Int,
var maxPerStageDescriptorStorageBuffers: Int,
var maxPerStageDescriptorSampledImages: Int,
var maxPerStageDescriptorStorageImages: Int,
var maxPerStageDescriptorInputAttachments: Int,
var maxPerStageResources: Int,
var maxDescriptorSetSamplers: Int,
var maxDescriptorSetUniformBuffers: Int,
var maxDescriptorSetUniformBuffersDynamic: Int,
var maxDescriptorSetStorageBuffers: Int,
var maxDescriptorSetStorageBuffersDynamic: Int,
var maxDescriptorSetSampledImages: Int,
var maxDescriptorSetStorageImages: Int,
var maxDescriptorSetInputAttachments: Int,
var maxVertexInputAttributes: Int,
var maxVertexInputBindings: Int,
var maxVertexInputAttributeOffset: Int,
var maxVertexInputBindingStride: Int,
var maxVertexOutputComponents: Int,
var maxTessellationGenerationLevel: Int,
var maxTessellationPatchSize: Int,
var maxTessellationControlPerVertexInputComponents: Int,
var maxTessellationControlPerVertexOutputComponents: Int,
var maxTessellationControlPerPatchOutputComponents: Int,
var maxTessellationControlTotalOutputComponents: Int,
var maxTessellationEvaluationInputComponents: Int,
var maxTessellationEvaluationOutputComponents: Int,
var maxGeometryShaderInvocations: Int,
var maxGeometryInputComponents: Int,
var maxGeometryOutputComponents: Int,
var maxGeometryOutputVertices: Int,
var maxGeometryTotalOutputComponents: Int,
var maxFragmentInputComponents: Int,
var maxFragmentOutputAttachments: Int,
var maxFragmentDualSrcAttachments: Int,
var maxFragmentCombinedOutputResources: Int,
var maxComputeSharedMemorySize: Int,
var maxComputeWorkGroupCount: Vec3i,
var maxComputeWorkGroupInvocations: Int,
var maxComputeWorkGroupSize: Vec3i,
var subPixelPrecisionBits: Int,
var subTexelPrecisionBits: Int,
var mipmapPrecisionBits: Int,
var maxDrawIndexedIndexValue: Int,
var maxDrawIndirectCount: Int,
var maxSamplerLodBias: Float,
var maxSamplerAnisotropy: Float,
var maxViewports: Int,
var maxViewportDimensions: Vec2i,
var viewportBoundsRange: Vec2,
var viewportSubPixelBits: Int,
var minMemoryMapAlignment: Long,
var minTexelBufferOffsetAlignment: VkDeviceSize,
var minUniformBufferOffsetAlignment: VkDeviceSize,
var minStorageBufferOffsetAlignment: VkDeviceSize,
var minTexelOffset: Int,
var maxTexelOffset: Int,
var minTexelGatherOffset: Int,
var maxTexelGatherOffset: Int,
var minInterpolationOffset: Float,
var maxInterpolationOffset: Float,
var subPixelInterpolationOffsetBits: Int,
var maxFramebufferWidth: Int,
var maxFramebufferHeight: Int,
var maxFramebufferLayers: Int,
var framebufferColorSampleCounts: VkSampleCountFlags,
var framebufferDepthSampleCounts: VkSampleCountFlags,
var framebufferStencilSampleCounts: VkSampleCountFlags,
var framebufferNoAttachmentsSampleCounts: VkSampleCountFlags,
var maxColorAttachments: Int,
var sampledImageColorSampleCounts: VkSampleCountFlags,
var sampledImageIntegerSampleCounts: VkSampleCountFlags,
var sampledImageDepthSampleCounts: VkSampleCountFlags,
var sampledImageStencilSampleCounts: VkSampleCountFlags,
var storageImageSampleCounts: VkSampleCountFlags,
var maxSampleMaskWords: Int,
var timestampComputeAndGraphics: Boolean,
var timestampPeriod: Float,
var maxClipDistances: Int,
var maxCullDistances: Int,
var maxCombinedClipAndCullDistances: Int,
var discreteQueuePriorities: Int,
var pointSizeRange: Vec2,
var lineWidthRange: Vec2,
var pointSizeGranularity: Float,
var lineWidthGranularity: Float,
var strictLines: Boolean,
var standardSampleLocations: Boolean,
var optimalBufferCopyOffsetAlignment: VkDeviceSize,
var optimalBufferCopyRowPitchAlignment: VkDeviceSize,
var nonCoherentAtomSiz: VkDeviceSize
) {

}