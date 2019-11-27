package classes

import glm_.i
import kool.Adr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.*
import org.lwjgl.vulkan.VkPhysicalDeviceFeatures.*

/**
 * Structure describing the fine-grained features that can be supported by an implementation.
 *
 * <h3>Member documentation</h3>
 *
 *
 *  * `robustBufferAccess`  specifies that accesses to buffers are bounds-checked against the range of the buffer descriptor (as determined by [VkDescriptorBufferInfo]`::range`, [VkBufferViewCreateInfo]`::range`, or the size of the buffer). Out of bounds accesses **must** not cause application termination, and the effects of shader loads, stores, and atomics **must** conform to an implementation-dependent behavior as described below.
 *
 *
 *  * A buffer access is considered to be out of bounds if any of the following are true:
 *
 *
 *  * The pointer was formed by `OpImageTexelPointer` and the coordinate is less than zero or greater than or equal to the number of whole elements in the bound range.
 *  * The pointer was not formed by `OpImageTexelPointer` and the object pointed to is not wholly contained within the bound range. This includes accesses performed via *variable pointers* where the buffer descriptor being accessed cannot be statically determined. Uninitialized pointers and pointers equal to `OpConstantNull` are treated as pointing to a zero-sized object, so all accesses through such pointers are considered to be out of bounds. Buffer accesses through buffer device addresses are not bounds-checked. If the [`cooperativeMatrixRobustBufferAccess`](https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-cooperativeMatrixRobustBufferAccess) feature is not enabled, then accesses using `OpCooperativeMatrixLoadNV` and `OpCooperativeMatrixStoreNV` **may** not be bounds-checked.
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 *
 * If a SPIR-V `OpLoad` instruction loads a structure and the tail end of the structure is out of bounds, then all members of the structure are considered out of bounds even if the members at the end are not statically used.
</div> *
 *
 *  * If any buffer access is determined to be out of bounds, then any other access of the same type (load, store, or atomic) to the same buffer that accesses an address less than 16 bytes away from the out of bounds address **may** also be considered out of bounds.
 *
 *
 *  * Out-of-bounds buffer loads will return any of the following values:
 *
 *
 *  * Values from anywhere within the memory range(s) bound to the buffer (possibly including bytes of memory past the end of the buffer, up to the end of the bound range).
 *  * Zero values, or `(0,0,0,x)` vectors for vector reads where x is a valid value represented in the type of the vector components and **may** be any of:
 *
 *
 *  * 0, 1, or the maximum representable positive integer value, for signed or unsigned integer components
 *  * 0.0 or 1.0, for floating-point components
 *
 *
 *
 *
 *  * Out-of-bounds writes **may** modify values within the memory range(s) bound to the buffer, but **must** not modify any other memory.
 *  * Out-of-bounds atomics **may** modify values within the memory range(s) bound to the buffer, but **must** not modify any other memory, and return an undefined value.
 *  * Vertex input attributes are considered out of bounds if the offset of the attribute in the bound vertex buffer range plus the size of the attribute is greater than either:
 *
 *
 *  * `vertexBufferRangeSize`, if `bindingStride == 0`; or
 *  * `(vertexBufferRangeSize - (vertexBufferRangeSize % bindingStride))`
 *
 *
 *
 * where `vertexBufferRangeSize` is the byte size of the memory range bound to the vertex buffer binding and `bindingStride` is the byte stride of the corresponding vertex input binding. Further, if any vertex input attribute using a specific vertex input binding is out of bounds, then all vertex input attributes using that vertex input binding for that vertex shader invocation are considered out of bounds.
 *
 *
 *  * If a vertex input attribute is out of bounds, it will be assigned one of the following values:
 *
 *
 *  * Values from anywhere within the memory range(s) bound to the buffer, converted according to the format of the attribute.
 *  * Zero values, format converted according to the format of the attribute.
 *  * Zero values, or `(0,0,0,x)` vectors, as described above.
 *
 *
 *
 *
 *  * If `robustBufferAccess` is not enabled, applications **must** not perform out of bounds accesses.
 *
 *  * `fullDrawIndexUint32`  specifies the full 32-bit range of indices is supported for indexed draw calls when using a `VkIndexType` of [INDEX_TYPE_UINT32][VK10.VK_INDEX_TYPE_UINT32]. `maxDrawIndexedIndexValue` is the maximum index value that **may** be used (aside from the primitive restart index, which is always 2<sup>32</sup>-1 when the `VkIndexType` is [INDEX_TYPE_UINT32][VK10.VK_INDEX_TYPE_UINT32]). If this feature is supported, `maxDrawIndexedIndexValue` **must** be 2<sup>32</sup>-1; otherwise it **must** be no smaller than 2<sup>24</sup>-1. See [maxDrawIndexedIndexValue](https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#limits-maxDrawIndexedIndexValue).
 *  * `imageCubeArray`  specifies whether image views with a `VkImageViewType` of [IMAGE_VIEW_TYPE_CUBE_ARRAY][VK10.VK_IMAGE_VIEW_TYPE_CUBE_ARRAY] **can** be created, and that the corresponding `SampledCubeArray` and `ImageCubeArray` SPIR-V capabilities **can** be used in shader code.
 *  * `independentBlend`  specifies whether the [VkPipelineColorBlendAttachmentState] settings are controlled independently per-attachment. If this feature is not enabled, the [VkPipelineColorBlendAttachmentState] settings for all color attachments **must** be identical. Otherwise, a different [VkPipelineColorBlendAttachmentState] **can** be provided for each bound color attachment.
 *  * `geometryShader`  specifies whether geometry shaders are supported. If this feature is not enabled, the [SHADER_STAGE_GEOMETRY_BIT][VK10.VK_SHADER_STAGE_GEOMETRY_BIT] and [PIPELINE_STAGE_GEOMETRY_SHADER_BIT][VK10.VK_PIPELINE_STAGE_GEOMETRY_SHADER_BIT] enum values **must** not be used. This also specifies whether shader modules **can** declare the `Geometry` capability.
 *  * `tessellationShader`  specifies whether tessellation control and evaluation shaders are supported. If this feature is not enabled, the [SHADER_STAGE_TESSELLATION_CONTROL_BIT][VK10.VK_SHADER_STAGE_TESSELLATION_CONTROL_BIT], [SHADER_STAGE_TESSELLATION_EVALUATION_BIT][VK10.VK_SHADER_STAGE_TESSELLATION_EVALUATION_BIT], [PIPELINE_STAGE_TESSELLATION_CONTROL_SHADER_BIT][VK10.VK_PIPELINE_STAGE_TESSELLATION_CONTROL_SHADER_BIT], [PIPELINE_STAGE_TESSELLATION_EVALUATION_SHADER_BIT][VK10.VK_PIPELINE_STAGE_TESSELLATION_EVALUATION_SHADER_BIT], and [STRUCTURE_TYPE_PIPELINE_TESSELLATION_STATE_CREATE_INFO][VK10.VK_STRUCTURE_TYPE_PIPELINE_TESSELLATION_STATE_CREATE_INFO] enum values **must** not be used. This also specifies whether shader modules **can** declare the `Tessellation` capability.
 *  * `sampleRateShading`  specifies whether [Sample Shading](https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#primsrast-sampleshading) and multisample interpolation are supported. If this feature is not enabled, the `sampleShadingEnable` member of the [VkPipelineMultisampleStateCreateInfo] structure **must** be set to [FALSE][VK10.VK_FALSE] and the `minSampleShading` member is ignored. This also specifies whether shader modules **can** declare the `SampleRateShading` capability.
 *  * `dualSrcBlend`  specifies whether blend operations which take two sources are supported. If this feature is not enabled, the [BLEND_FACTOR_SRC1_COLOR][VK10.VK_BLEND_FACTOR_SRC1_COLOR], [BLEND_FACTOR_ONE_MINUS_SRC1_COLOR][VK10.VK_BLEND_FACTOR_ONE_MINUS_SRC1_COLOR], [BLEND_FACTOR_SRC1_ALPHA][VK10.VK_BLEND_FACTOR_SRC1_ALPHA], and [BLEND_FACTOR_ONE_MINUS_SRC1_ALPHA][VK10.VK_BLEND_FACTOR_ONE_MINUS_SRC1_ALPHA] enum values **must** not be used as source or destination blending factors. See [Dual-Source Blending](https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#framebuffer-dsb).
 *  * `logicOp`  specifies whether logic operations are supported. If this feature is not enabled, the `logicOpEnable` member of the [VkPipelineColorBlendStateCreateInfo] structure **must** be set to [FALSE][VK10.VK_FALSE], and the `logicOp` member is ignored.
 *  * `multiDrawIndirect`  specifies whether multiple draw indirect is supported. If this feature is not enabled, the `drawCount` parameter to the `vkCmdDrawIndirect` and `vkCmdDrawIndexedIndirect` commands **must** be 0 or 1. The `maxDrawIndirectCount` member of the [VkPhysicalDeviceLimits] structure **must** also be 1 if this feature is not supported. See [maxDrawIndirectCount](https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#limits-maxDrawIndirectCount).
 *  * `drawIndirectFirstInstance`  specifies whether indirect draw calls support the `firstInstance` parameter. If this feature is not enabled, the `firstInstance` member of all [VkDrawIndirectCommand] and [VkDrawIndexedIndirectCommand] structures that are provided to the `vkCmdDrawIndirect` and `vkCmdDrawIndexedIndirect` commands **must** be 0.
 *  * `depthClamp`  specifies whether depth clamping is supported. If this feature is not enabled, the `depthClampEnable` member of the [VkPipelineRasterizationStateCreateInfo] structure **must** be set to [FALSE][VK10.VK_FALSE]. Otherwise, setting `depthClampEnable` to [TRUE][VK10.VK_TRUE] will enable depth clamping.
 *  * `depthBiasClamp`  specifies whether depth bias clamping is supported. If this feature is not enabled, the `depthBiasClamp` member of the [VkPipelineRasterizationStateCreateInfo] structure **must** be set to 0.0 unless the [DYNAMIC_STATE_DEPTH_BIAS][VK10.VK_DYNAMIC_STATE_DEPTH_BIAS] dynamic state is enabled, and the `depthBiasClamp` parameter to `vkCmdSetDepthBias` **must** be set to 0.0.
 *  * `fillModeNonSolid`  specifies whether point and wireframe fill modes are supported. If this feature is not enabled, the [POLYGON_MODE_POINT][VK10.VK_POLYGON_MODE_POINT] and [POLYGON_MODE_LINE][VK10.VK_POLYGON_MODE_LINE] enum values **must** not be used.
 *  * `depthBounds`  specifies whether depth bounds tests are supported. If this feature is not enabled, the `depthBoundsTestEnable` member of the [VkPipelineDepthStencilStateCreateInfo] structure **must** be set to [FALSE][VK10.VK_FALSE]. When `depthBoundsTestEnable` is set to [FALSE][VK10.VK_FALSE], the `minDepthBounds` and `maxDepthBounds` members of the [VkPipelineDepthStencilStateCreateInfo] structure are ignored.
 *  * `wideLines`  specifies whether lines with width other than 1.0 are supported. If this feature is not enabled, the `lineWidth` member of the [VkPipelineRasterizationStateCreateInfo] structure **must** be set to 1.0 unless the [DYNAMIC_STATE_LINE_WIDTH][VK10.VK_DYNAMIC_STATE_LINE_WIDTH] dynamic state is enabled, and the `lineWidth` parameter to `vkCmdSetLineWidth` **must** be set to 1.0. When this feature is supported, the range and granularity of supported line widths are indicated by the `lineWidthRange` and `lineWidthGranularity` members of the [VkPhysicalDeviceLimits] structure, respectively.
 *  * `largePoints`  specifies whether points with size greater than 1.0 are supported. If this feature is not enabled, only a point size of 1.0 written by a shader is supported. The range and granularity of supported point sizes are indicated by the `pointSizeRange` and `pointSizeGranularity` members of the [VkPhysicalDeviceLimits] structure, respectively.
 *  * `alphaToOne`  specifies whether the implementation is able to replace the alpha value of the color fragment output from the fragment shader with the maximum representable alpha value for fixed-point colors or 1.0 for floating-point colors. If this feature is not enabled, then the `alphaToOneEnable` member of the [VkPipelineMultisampleStateCreateInfo] structure **must** be set to [FALSE][VK10.VK_FALSE]. Otherwise setting `alphaToOneEnable` to [TRUE][VK10.VK_TRUE] will enable alpha-to-one behavior.
 *  * `multiViewport`  specifies whether more than one viewport is supported. If this feature is not enabled:
 *
 *
 *  * The `viewportCount` and `scissorCount` members of the [VkPipelineViewportStateCreateInfo] structure **must** be set to 1.
 *  * The `firstViewport` and `viewportCount` parameters to the `vkCmdSetViewport` command **must** be set to 0 and 1, respectively.
 *  * The `firstScissor` and `scissorCount` parameters to the `vkCmdSetScissor` command **must** be set to 0 and 1, respectively.
 *  * The `exclusiveScissorCount` member of the [VkPipelineViewportExclusiveScissorStateCreateInfoNV] structure **must** be set to 0 or 1.
 *  * The `firstExclusiveScissor` and `exclusiveScissorCount` parameters to the `vkCmdSetExclusiveScissorNV` command **must** be set to 0 and 1, respectively.
 *
 *  * `samplerAnisotropy`  specifies whether anisotropic filtering is supported. If this feature is not enabled, the `anisotropyEnable` member of the [VkSamplerCreateInfo] structure **must** be [FALSE][VK10.VK_FALSE].
 *  * `textureCompressionETC2`  specifies whether all of the ETC2 and EAC compressed texture formats are supported. If this feature is enabled, then the [FORMAT_FEATURE_SAMPLED_IMAGE_BIT][VK10.VK_FORMAT_FEATURE_SAMPLED_IMAGE_BIT], [FORMAT_FEATURE_BLIT_SRC_BIT][VK10.VK_FORMAT_FEATURE_BLIT_SRC_BIT] and [FORMAT_FEATURE_SAMPLED_IMAGE_FILTER_LINEAR_BIT][VK10.VK_FORMAT_FEATURE_SAMPLED_IMAGE_FILTER_LINEAR_BIT] features **must** be supported in `optimalTilingFeatures` for the following formats:
 *
 *
 *  * [FORMAT_ETC2_R8G8B8_UNORM_BLOCK][VK10.VK_FORMAT_ETC2_R8G8B8_UNORM_BLOCK]
 *  * [FORMAT_ETC2_R8G8B8_SRGB_BLOCK][VK10.VK_FORMAT_ETC2_R8G8B8_SRGB_BLOCK]
 *  * [FORMAT_ETC2_R8G8B8A1_UNORM_BLOCK][VK10.VK_FORMAT_ETC2_R8G8B8A1_UNORM_BLOCK]
 *  * [FORMAT_ETC2_R8G8B8A1_SRGB_BLOCK][VK10.VK_FORMAT_ETC2_R8G8B8A1_SRGB_BLOCK]
 *  * [FORMAT_ETC2_R8G8B8A8_UNORM_BLOCK][VK10.VK_FORMAT_ETC2_R8G8B8A8_UNORM_BLOCK]
 *  * [FORMAT_ETC2_R8G8B8A8_SRGB_BLOCK][VK10.VK_FORMAT_ETC2_R8G8B8A8_SRGB_BLOCK]
 *  * [FORMAT_EAC_R11_UNORM_BLOCK][VK10.VK_FORMAT_EAC_R11_UNORM_BLOCK]
 *  * [FORMAT_EAC_R11_SNORM_BLOCK][VK10.VK_FORMAT_EAC_R11_SNORM_BLOCK]
 *  * [FORMAT_EAC_R11G11_UNORM_BLOCK][VK10.VK_FORMAT_EAC_R11G11_UNORM_BLOCK]
 *  * [FORMAT_EAC_R11G11_SNORM_BLOCK][VK10.VK_FORMAT_EAC_R11G11_SNORM_BLOCK]
 *
 *
 *
 * To query for additional properties, or if the feature is not enabled, [GetPhysicalDeviceFormatProperties][VK10.vkGetPhysicalDeviceFormatProperties] and [GetPhysicalDeviceImageFormatProperties][VK10.vkGetPhysicalDeviceImageFormatProperties] **can** be used to check for supported properties of individual formats as normal.
 *  * `textureCompressionASTC_LDR`  specifies whether all of the ASTC LDR compressed texture formats are supported. If this feature is enabled, then the [FORMAT_FEATURE_SAMPLED_IMAGE_BIT][VK10.VK_FORMAT_FEATURE_SAMPLED_IMAGE_BIT], [FORMAT_FEATURE_BLIT_SRC_BIT][VK10.VK_FORMAT_FEATURE_BLIT_SRC_BIT] and [FORMAT_FEATURE_SAMPLED_IMAGE_FILTER_LINEAR_BIT][VK10.VK_FORMAT_FEATURE_SAMPLED_IMAGE_FILTER_LINEAR_BIT] features **must** be supported in `optimalTilingFeatures` for the following formats:
 *
 *
 *  * [FORMAT_ASTC_4x4_UNORM_BLOCK][VK10.VK_FORMAT_ASTC_4x4_UNORM_BLOCK]
 *  * [FORMAT_ASTC_4x4_SRGB_BLOCK][VK10.VK_FORMAT_ASTC_4x4_SRGB_BLOCK]
 *  * [FORMAT_ASTC_5x4_UNORM_BLOCK][VK10.VK_FORMAT_ASTC_5x4_UNORM_BLOCK]
 *  * [FORMAT_ASTC_5x4_SRGB_BLOCK][VK10.VK_FORMAT_ASTC_5x4_SRGB_BLOCK]
 *  * [FORMAT_ASTC_5x5_UNORM_BLOCK][VK10.VK_FORMAT_ASTC_5x5_UNORM_BLOCK]
 *  * [FORMAT_ASTC_5x5_SRGB_BLOCK][VK10.VK_FORMAT_ASTC_5x5_SRGB_BLOCK]
 *  * [FORMAT_ASTC_6x5_UNORM_BLOCK][VK10.VK_FORMAT_ASTC_6x5_UNORM_BLOCK]
 *  * [FORMAT_ASTC_6x5_SRGB_BLOCK][VK10.VK_FORMAT_ASTC_6x5_SRGB_BLOCK]
 *  * [FORMAT_ASTC_6x6_UNORM_BLOCK][VK10.VK_FORMAT_ASTC_6x6_UNORM_BLOCK]
 *  * [FORMAT_ASTC_6x6_SRGB_BLOCK][VK10.VK_FORMAT_ASTC_6x6_SRGB_BLOCK]
 *  * [FORMAT_ASTC_8x5_UNORM_BLOCK][VK10.VK_FORMAT_ASTC_8x5_UNORM_BLOCK]
 *  * [FORMAT_ASTC_8x5_SRGB_BLOCK][VK10.VK_FORMAT_ASTC_8x5_SRGB_BLOCK]
 *  * [FORMAT_ASTC_8x6_UNORM_BLOCK][VK10.VK_FORMAT_ASTC_8x6_UNORM_BLOCK]
 *  * [FORMAT_ASTC_8x6_SRGB_BLOCK][VK10.VK_FORMAT_ASTC_8x6_SRGB_BLOCK]
 *  * [FORMAT_ASTC_8x8_UNORM_BLOCK][VK10.VK_FORMAT_ASTC_8x8_UNORM_BLOCK]
 *  * [FORMAT_ASTC_8x8_SRGB_BLOCK][VK10.VK_FORMAT_ASTC_8x8_SRGB_BLOCK]
 *  * [FORMAT_ASTC_10x5_UNORM_BLOCK][VK10.VK_FORMAT_ASTC_10x5_UNORM_BLOCK]
 *  * [FORMAT_ASTC_10x5_SRGB_BLOCK][VK10.VK_FORMAT_ASTC_10x5_SRGB_BLOCK]
 *  * [FORMAT_ASTC_10x6_UNORM_BLOCK][VK10.VK_FORMAT_ASTC_10x6_UNORM_BLOCK]
 *  * [FORMAT_ASTC_10x6_SRGB_BLOCK][VK10.VK_FORMAT_ASTC_10x6_SRGB_BLOCK]
 *  * [FORMAT_ASTC_10x8_UNORM_BLOCK][VK10.VK_FORMAT_ASTC_10x8_UNORM_BLOCK]
 *  * [FORMAT_ASTC_10x8_SRGB_BLOCK][VK10.VK_FORMAT_ASTC_10x8_SRGB_BLOCK]
 *  * [FORMAT_ASTC_10x10_UNORM_BLOCK][VK10.VK_FORMAT_ASTC_10x10_UNORM_BLOCK]
 *  * [FORMAT_ASTC_10x10_SRGB_BLOCK][VK10.VK_FORMAT_ASTC_10x10_SRGB_BLOCK]
 *  * [FORMAT_ASTC_12x10_UNORM_BLOCK][VK10.VK_FORMAT_ASTC_12x10_UNORM_BLOCK]
 *  * [FORMAT_ASTC_12x10_SRGB_BLOCK][VK10.VK_FORMAT_ASTC_12x10_SRGB_BLOCK]
 *  * [FORMAT_ASTC_12x12_UNORM_BLOCK][VK10.VK_FORMAT_ASTC_12x12_UNORM_BLOCK]
 *  * [FORMAT_ASTC_12x12_SRGB_BLOCK][VK10.VK_FORMAT_ASTC_12x12_SRGB_BLOCK]
 *
 *
 *
 * To query for additional properties, or if the feature is not enabled, [GetPhysicalDeviceFormatProperties][VK10.vkGetPhysicalDeviceFormatProperties] and [GetPhysicalDeviceImageFormatProperties][VK10.vkGetPhysicalDeviceImageFormatProperties] **can** be used to check for supported properties of individual formats as normal.
 *  * `textureCompressionBC`  specifies whether all of the BC compressed texture formats are supported. If this feature is enabled, then the [FORMAT_FEATURE_SAMPLED_IMAGE_BIT][VK10.VK_FORMAT_FEATURE_SAMPLED_IMAGE_BIT], [FORMAT_FEATURE_BLIT_SRC_BIT][VK10.VK_FORMAT_FEATURE_BLIT_SRC_BIT] and [FORMAT_FEATURE_SAMPLED_IMAGE_FILTER_LINEAR_BIT][VK10.VK_FORMAT_FEATURE_SAMPLED_IMAGE_FILTER_LINEAR_BIT] features **must** be supported in `optimalTilingFeatures` for the following formats:
 *
 *
 *  * [FORMAT_BC1_RGB_UNORM_BLOCK][VK10.VK_FORMAT_BC1_RGB_UNORM_BLOCK]
 *  * [FORMAT_BC1_RGB_SRGB_BLOCK][VK10.VK_FORMAT_BC1_RGB_SRGB_BLOCK]
 *  * [FORMAT_BC1_RGBA_UNORM_BLOCK][VK10.VK_FORMAT_BC1_RGBA_UNORM_BLOCK]
 *  * [FORMAT_BC1_RGBA_SRGB_BLOCK][VK10.VK_FORMAT_BC1_RGBA_SRGB_BLOCK]
 *  * [FORMAT_BC2_UNORM_BLOCK][VK10.VK_FORMAT_BC2_UNORM_BLOCK]
 *  * [FORMAT_BC2_SRGB_BLOCK][VK10.VK_FORMAT_BC2_SRGB_BLOCK]
 *  * [FORMAT_BC3_UNORM_BLOCK][VK10.VK_FORMAT_BC3_UNORM_BLOCK]
 *  * [FORMAT_BC3_SRGB_BLOCK][VK10.VK_FORMAT_BC3_SRGB_BLOCK]
 *  * [FORMAT_BC4_UNORM_BLOCK][VK10.VK_FORMAT_BC4_UNORM_BLOCK]
 *  * [FORMAT_BC4_SNORM_BLOCK][VK10.VK_FORMAT_BC4_SNORM_BLOCK]
 *  * [FORMAT_BC5_UNORM_BLOCK][VK10.VK_FORMAT_BC5_UNORM_BLOCK]
 *  * [FORMAT_BC5_SNORM_BLOCK][VK10.VK_FORMAT_BC5_SNORM_BLOCK]
 *  * [FORMAT_BC6H_UFLOAT_BLOCK][VK10.VK_FORMAT_BC6H_UFLOAT_BLOCK]
 *  * [FORMAT_BC6H_SFLOAT_BLOCK][VK10.VK_FORMAT_BC6H_SFLOAT_BLOCK]
 *  * [FORMAT_BC7_UNORM_BLOCK][VK10.VK_FORMAT_BC7_UNORM_BLOCK]
 *  * [FORMAT_BC7_SRGB_BLOCK][VK10.VK_FORMAT_BC7_SRGB_BLOCK]
 *
 *
 *
 * To query for additional properties, or if the feature is not enabled, [GetPhysicalDeviceFormatProperties][VK10.vkGetPhysicalDeviceFormatProperties] and [GetPhysicalDeviceImageFormatProperties][VK10.vkGetPhysicalDeviceImageFormatProperties] **can** be used to check for supported properties of individual formats as normal.
 *  * `occlusionQueryPrecise`  specifies whether occlusion queries returning actual sample counts are supported. Occlusion queries are created in a `VkQueryPool` by specifying the `queryType` of [QUERY_TYPE_OCCLUSION][VK10.VK_QUERY_TYPE_OCCLUSION] in the [VkQueryPoolCreateInfo] structure which is passed to `vkCreateQueryPool`. If this feature is enabled, queries of this type **can** enable [QUERY_CONTROL_PRECISE_BIT][VK10.VK_QUERY_CONTROL_PRECISE_BIT] in the `flags` parameter to `vkCmdBeginQuery`. If this feature is not supported, the implementation supports only boolean occlusion queries. When any samples are passed, boolean queries will return a non-zero result value, otherwise a result value of zero is returned. When this feature is enabled and [QUERY_CONTROL_PRECISE_BIT][VK10.VK_QUERY_CONTROL_PRECISE_BIT] is set, occlusion queries will report the actual number of samples passed.
 *  * `pipelineStatisticsQuery`  specifies whether the pipeline statistics queries are supported. If this feature is not enabled, queries of type [QUERY_TYPE_PIPELINE_STATISTICS][VK10.VK_QUERY_TYPE_PIPELINE_STATISTICS] **cannot** be created, and none of the `VkQueryPipelineStatisticFlagBits` bits **can** be set in the `pipelineStatistics` member of the [VkQueryPoolCreateInfo] structure.
 *  * `vertexPipelineStoresAndAtomics`  specifies whether storage buffers and images support stores and atomic operations in the vertex, tessellation, and geometry shader stages. If this feature is not enabled, all storage image, storage texel buffers, and storage buffer variables used by these stages in shader modules **must** be decorated with the `NonWritable` decoration (or the `readonly` memory qualifier in GLSL).
 *  * `fragmentStoresAndAtomics`  specifies whether storage buffers and images support stores and atomic operations in the fragment shader stage. If this feature is not enabled, all storage image, storage texel buffers, and storage buffer variables used by the fragment stage in shader modules **must** be decorated with the `NonWritable` decoration (or the `readonly` memory qualifier in GLSL).
 *  * `shaderTessellationAndGeometryPointSize`  specifies whether the `PointSize` built-in decoration is available in the tessellation control, tessellation evaluation, and geometry shader stages. If this feature is not enabled, members decorated with the `PointSize` built-in decoration **must** not be read from or written to and all points written from a tessellation or geometry shader will have a size of 1.0. This also specifies whether shader modules **can** declare the `TessellationPointSize` capability for tessellation control and evaluation shaders, or if the shader modules **can** declare the `GeometryPointSize` capability for geometry shaders. An implementation supporting this feature **must** also support one or both of the [`tessellationShader`](https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-tessellationShader) or [`geometryShader`](https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-geometryShader) features.
 *  * `shaderImageGatherExtended`  specifies whether the extended set of image gather instructions are available in shader code. If this feature is not enabled, the `OpImage`*`Gather` instructions do not support the `Offset` and `ConstOffsets` operands. This also specifies whether shader modules **can** declare the `ImageGatherExtended` capability.
 *  * `shaderStorageImageExtendedFormats`  specifies whether all the extended storage image formats are available in shader code. If this feature is enabled then the [FORMAT_FEATURE_STORAGE_IMAGE_BIT][VK10.VK_FORMAT_FEATURE_STORAGE_IMAGE_BIT] feature **must** be supported in `optimalTilingFeatures` for all of the extended formats. To query for additional properties, or if the feature is not enabled, [GetPhysicalDeviceFormatProperties][VK10.vkGetPhysicalDeviceFormatProperties] and [GetPhysicalDeviceImageFormatProperties][VK10.vkGetPhysicalDeviceImageFormatProperties] **can** be used to check for supported properties of individual formats as normal.
 *  * `shaderStorageImageMultisample`  specifies whether multisampled storage images are supported. If this feature is not enabled, images that are created with a `usage` that includes [IMAGE_USAGE_STORAGE_BIT][VK10.VK_IMAGE_USAGE_STORAGE_BIT] **must** be created with `samples` equal to [SAMPLE_COUNT_1_BIT][VK10.VK_SAMPLE_COUNT_1_BIT]. This also specifies whether shader modules **can** declare the `StorageImageMultisample` capability.
 *  * `shaderStorageImageReadWithoutFormat`  specifies whether storage images require a format qualifier to be specified when reading from storage images. If this feature is not enabled, the `OpImageRead` instruction **must** not have an `OpTypeImage` of `Unknown`. This also specifies whether shader modules **can** declare the `StorageImageReadWithoutFormat` capability.
 *  * `shaderStorageImageWriteWithoutFormat`  specifies whether storage images require a format qualifier to be specified when writing to storage images. If this feature is not enabled, the `OpImageWrite` instruction **must** not have an `OpTypeImage` of `Unknown`. This also specifies whether shader modules **can** declare the `StorageImageWriteWithoutFormat` capability.
 *  * `shaderUniformBufferArrayDynamicIndexing`  specifies whether arrays of uniform buffers **can** be indexed by *dynamically uniform* integer expressions in shader code. If this feature is not enabled, resources with a descriptor type of [DESCRIPTOR_TYPE_UNIFORM_BUFFER][VK10.VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER] or [DESCRIPTOR_TYPE_UNIFORM_BUFFER_DYNAMIC][VK10.VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER_DYNAMIC] **must** be indexed only by constant integral expressions when aggregated into arrays in shader code. This also specifies whether shader modules **can** declare the `UniformBufferArrayDynamicIndexing` capability.
 *  * `shaderSampledImageArrayDynamicIndexing`  specifies whether arrays of samplers or sampled images **can** be indexed by dynamically uniform integer expressions in shader code. If this feature is not enabled, resources with a descriptor type of [DESCRIPTOR_TYPE_SAMPLER][VK10.VK_DESCRIPTOR_TYPE_SAMPLER], [DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER][VK10.VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER], or [DESCRIPTOR_TYPE_SAMPLED_IMAGE][VK10.VK_DESCRIPTOR_TYPE_SAMPLED_IMAGE] **must** be indexed only by constant integral expressions when aggregated into arrays in shader code. This also specifies whether shader modules **can** declare the `SampledImageArrayDynamicIndexing` capability.
 *  * `shaderStorageBufferArrayDynamicIndexing`  specifies whether arrays of storage buffers **can** be indexed by dynamically uniform integer expressions in shader code. If this feature is not enabled, resources with a descriptor type of [DESCRIPTOR_TYPE_STORAGE_BUFFER][VK10.VK_DESCRIPTOR_TYPE_STORAGE_BUFFER] or [DESCRIPTOR_TYPE_STORAGE_BUFFER_DYNAMIC][VK10.VK_DESCRIPTOR_TYPE_STORAGE_BUFFER_DYNAMIC] **must** be indexed only by constant integral expressions when aggregated into arrays in shader code. This also specifies whether shader modules **can** declare the `StorageBufferArrayDynamicIndexing` capability.
 *  * `shaderStorageImageArrayDynamicIndexing`  specifies whether arrays of storage images **can** be indexed by dynamically uniform integer expressions in shader code. If this feature is not enabled, resources with a descriptor type of [DESCRIPTOR_TYPE_STORAGE_IMAGE][VK10.VK_DESCRIPTOR_TYPE_STORAGE_IMAGE] **must** be indexed only by constant integral expressions when aggregated into arrays in shader code. This also specifies whether shader modules **can** declare the `StorageImageArrayDynamicIndexing` capability.
 *  * `shaderClipDistance`  specifies whether clip distances are supported in shader code. If this feature is not enabled, any members decorated with the `ClipDistance` built-in decoration **must** not be read from or written to in shader modules. This also specifies whether shader modules **can** declare the `ClipDistance` capability.
 *  * `shaderCullDistance`  specifies whether cull distances are supported in shader code. If this feature is not enabled, any members decorated with the `CullDistance` built-in decoration **must** not be read from or written to in shader modules. This also specifies whether shader modules **can** declare the `CullDistance` capability.
 *  * `shaderFloat64`  specifies whether 64-bit floats (doubles) are supported in shader code. If this feature is not enabled, 64-bit floating-point types **must** not be used in shader code. This also specifies whether shader modules **can** declare the `Float64` capability.
 *  * `shaderInt64`  specifies whether 64-bit integers (signed and unsigned) are supported in shader code. If this feature is not enabled, 64-bit integer types **must** not be used in shader code. This also specifies whether shader modules **can** declare the `Int64` capability.
 *  * `shaderInt16`  specifies whether 16-bit integers (signed and unsigned) are supported in shader code. If this feature is not enabled, 16-bit integer types **must** not be used in shader code. This also specifies whether shader modules **can** declare the `Int16` capability.
 *  * `shaderResourceResidency`  specifies whether image operations that return resource residency information are supported in shader code. If this feature is not enabled, the `OpImageSparse`* instructions **must** not be used in shader code. This also specifies whether shader modules **can** declare the `SparseResidency` capability. The feature requires at least one of the `sparseResidency`* features to be supported.
 *  * `shaderResourceMinLod`  specifies whether image operations that specify the minimum resource LOD are supported in shader code. If this feature is not enabled, the `MinLod` image operand **must** not be used in shader code. This also specifies whether shader modules **can** declare the `MinLod` capability.
 *  * `sparseBinding`  specifies whether resource memory **can** be managed at opaque sparse block level instead of at the object level. If this feature is not enabled, resource memory **must** be bound only on a per-object basis using the `vkBindBufferMemory` and `vkBindImageMemory` commands. In this case, buffers and images **must** not be created with [BUFFER_CREATE_SPARSE_BINDING_BIT][VK10.VK_BUFFER_CREATE_SPARSE_BINDING_BIT] and [IMAGE_CREATE_SPARSE_BINDING_BIT][VK10.VK_IMAGE_CREATE_SPARSE_BINDING_BIT] set in the `flags` member of the [VkBufferCreateInfo] and [VkImageCreateInfo] structures, respectively. Otherwise resource memory **can** be managed as described in [Sparse Resource Features](https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#sparsememory-sparseresourcefeatures).
 *  * `sparseResidencyBuffer`  specifies whether the device **can** access partially resident buffers. If this feature is not enabled, buffers **must** not be created with [BUFFER_CREATE_SPARSE_RESIDENCY_BIT][VK10.VK_BUFFER_CREATE_SPARSE_RESIDENCY_BIT] set in the `flags` member of the [VkBufferCreateInfo] structure.
 *  * `sparseResidencyImage2D`  specifies whether the device **can** access partially resident 2D images with 1 sample per pixel. If this feature is not enabled, images with an `imageType` of [IMAGE_TYPE_2D][VK10.VK_IMAGE_TYPE_2D] and `samples` set to [SAMPLE_COUNT_1_BIT][VK10.VK_SAMPLE_COUNT_1_BIT] **must** not be created with [IMAGE_CREATE_SPARSE_RESIDENCY_BIT][VK10.VK_IMAGE_CREATE_SPARSE_RESIDENCY_BIT] set in the `flags` member of the [VkImageCreateInfo] structure.
 *  * `sparseResidencyImage3D`  specifies whether the device **can** access partially resident 3D images. If this feature is not enabled, images with an `imageType` of [IMAGE_TYPE_3D][VK10.VK_IMAGE_TYPE_3D] **must** not be created with [IMAGE_CREATE_SPARSE_RESIDENCY_BIT][VK10.VK_IMAGE_CREATE_SPARSE_RESIDENCY_BIT] set in the `flags` member of the [VkImageCreateInfo] structure.
 *  * `sparseResidency2Samples`  specifies whether the physical device **can** access partially resident 2D images with 2 samples per pixel. If this feature is not enabled, images with an `imageType` of [IMAGE_TYPE_2D][VK10.VK_IMAGE_TYPE_2D] and `samples` set to [SAMPLE_COUNT_2_BIT][VK10.VK_SAMPLE_COUNT_2_BIT] **must** not be created with [IMAGE_CREATE_SPARSE_RESIDENCY_BIT][VK10.VK_IMAGE_CREATE_SPARSE_RESIDENCY_BIT] set in the `flags` member of the [VkImageCreateInfo] structure.
 *  * `sparseResidency4Samples`  specifies whether the physical device **can** access partially resident 2D images with 4 samples per pixel. If this feature is not enabled, images with an `imageType` of [IMAGE_TYPE_2D][VK10.VK_IMAGE_TYPE_2D] and `samples` set to [SAMPLE_COUNT_4_BIT][VK10.VK_SAMPLE_COUNT_4_BIT] **must** not be created with [IMAGE_CREATE_SPARSE_RESIDENCY_BIT][VK10.VK_IMAGE_CREATE_SPARSE_RESIDENCY_BIT] set in the `flags` member of the [VkImageCreateInfo] structure.
 *  * `sparseResidency8Samples`  specifies whether the physical device **can** access partially resident 2D images with 8 samples per pixel. If this feature is not enabled, images with an `imageType` of [IMAGE_TYPE_2D][VK10.VK_IMAGE_TYPE_2D] and `samples` set to [SAMPLE_COUNT_8_BIT][VK10.VK_SAMPLE_COUNT_8_BIT] **must** not be created with [IMAGE_CREATE_SPARSE_RESIDENCY_BIT][VK10.VK_IMAGE_CREATE_SPARSE_RESIDENCY_BIT] set in the `flags` member of the [VkImageCreateInfo] structure.
 *  * `sparseResidency16Samples`  specifies whether the physical device **can** access partially resident 2D images with 16 samples per pixel. If this feature is not enabled, images with an `imageType` of [IMAGE_TYPE_2D][VK10.VK_IMAGE_TYPE_2D] and `samples` set to [SAMPLE_COUNT_16_BIT][VK10.VK_SAMPLE_COUNT_16_BIT] **must** not be created with [IMAGE_CREATE_SPARSE_RESIDENCY_BIT][VK10.VK_IMAGE_CREATE_SPARSE_RESIDENCY_BIT] set in the `flags` member of the [VkImageCreateInfo] structure.
 *  * `sparseResidencyAliased`  specifies whether the physical device **can** correctly access data aliased into multiple locations. If this feature is not enabled, the [BUFFER_CREATE_SPARSE_ALIASED_BIT][VK10.VK_BUFFER_CREATE_SPARSE_ALIASED_BIT] and [IMAGE_CREATE_SPARSE_ALIASED_BIT][VK10.VK_IMAGE_CREATE_SPARSE_ALIASED_BIT] enum values **must** not be used in `flags` members of the [VkBufferCreateInfo] and [VkImageCreateInfo] structures, respectively.
 *  * `variableMultisampleRate`  specifies whether all pipelines that will be bound to a command buffer during a subpass with no attachments **must** have the same value for [VkPipelineMultisampleStateCreateInfo]`::rasterizationSamples`. If set to [TRUE][VK10.VK_TRUE], the implementation supports variable multisample rates in a subpass with no attachments. If set to [FALSE][VK10.VK_FALSE], then all pipelines bound in such a subpass **must** have the same multisample rate. This has no effect in situations where a subpass uses any attachments.
 *  * `inheritedQueries`  specifies whether a secondary command buffer **may** be executed while a query is active.
 *
 *
 * <h3>Layout</h3>
 *
 * <pre>`
 * struct VkPhysicalDeviceFeatures {
 * VkBool32 robustBufferAccess;
 * VkBool32 fullDrawIndexUint32;
 * VkBool32 imageCubeArray;
 * VkBool32 independentBlend;
 * VkBool32 geometryShader;
 * VkBool32 tessellationShader;
 * VkBool32 sampleRateShading;
 * VkBool32 dualSrcBlend;
 * VkBool32 logicOp;
 * VkBool32 multiDrawIndirect;
 * VkBool32 drawIndirectFirstInstance;
 * VkBool32 depthClamp;
 * VkBool32 depthBiasClamp;
 * VkBool32 fillModeNonSolid;
 * VkBool32 depthBounds;
 * VkBool32 wideLines;
 * VkBool32 largePoints;
 * VkBool32 alphaToOne;
 * VkBool32 multiViewport;
 * VkBool32 samplerAnisotropy;
 * VkBool32 textureCompressionETC2;
 * VkBool32 textureCompressionASTC_LDR;
 * VkBool32 textureCompressionBC;
 * VkBool32 occlusionQueryPrecise;
 * VkBool32 pipelineStatisticsQuery;
 * VkBool32 vertexPipelineStoresAndAtomics;
 * VkBool32 fragmentStoresAndAtomics;
 * VkBool32 shaderTessellationAndGeometryPointSize;
 * VkBool32 shaderImageGatherExtended;
 * VkBool32 shaderStorageImageExtendedFormats;
 * VkBool32 shaderStorageImageMultisample;
 * VkBool32 shaderStorageImageReadWithoutFormat;
 * VkBool32 shaderStorageImageWriteWithoutFormat;
 * VkBool32 shaderUniformBufferArrayDynamicIndexing;
 * VkBool32 shaderSampledImageArrayDynamicIndexing;
 * VkBool32 shaderStorageBufferArrayDynamicIndexing;
 * VkBool32 shaderStorageImageArrayDynamicIndexing;
 * VkBool32 shaderClipDistance;
 * VkBool32 shaderCullDistance;
 * VkBool32 shaderFloat64;
 * VkBool32 shaderInt64;
 * VkBool32 shaderInt16;
 * VkBool32 shaderResourceResidency;
 * VkBool32 shaderResourceMinLod;
 * VkBool32 sparseBinding;
 * VkBool32 sparseResidencyBuffer;
 * VkBool32 sparseResidencyImage2D;
 * VkBool32 sparseResidencyImage3D;
 * VkBool32 sparseResidency2Samples;
 * VkBool32 sparseResidency4Samples;
 * VkBool32 sparseResidency8Samples;
 * VkBool32 sparseResidency16Samples;
 * VkBool32 sparseResidencyAliased;
 * VkBool32 variableMultisampleRate;
 * VkBool32 inheritedQueries;
 * }`</pre>
 */
class PhysicalDeviceFeatures(
        var robustBufferAccess: Boolean = false,
        var fullDrawIndexUint32: Boolean = false,
        var imageCubeArray: Boolean = false,
        var independentBlend: Boolean = false,
        var geometryShader: Boolean = false,
        var tessellationShader: Boolean = false,
        var sampleRateShading: Boolean = false,
        var dualSrcBlend: Boolean = false,
        var logicOp: Boolean = false,
        var multiDrawIndirect: Boolean = false,
        var drawIndirectFirstInstance: Boolean = false,
        var depthClamp: Boolean = false,
        var depthBiasClamp: Boolean = false,
        var fillModeNonSolid: Boolean = false,
        var depthBounds: Boolean = false,
        var wideLines: Boolean = false,
        var largePoints: Boolean = false,
        var alphaToOne: Boolean = false,
        var multiViewport: Boolean = false,
        var samplerAnisotropy: Boolean = false,
        var textureCompressionETC2: Boolean = false,
        var textureCompressionASTC_LDR: Boolean = false,
        var textureCompressionBC: Boolean = false,
        var occlusionQueryPrecise: Boolean = false,
        var pipelineStatisticsQuery: Boolean = false,
        var vertexPipelineStoresAndAtomics: Boolean = false,
        var fragmentStoresAndAtomics: Boolean = false,
        var shaderTessellationAndGeometryPointSize: Boolean = false,
        var shaderImageGatherExtended: Boolean = false,
        var shaderStorageImageExtendedFormats: Boolean = false,
        var shaderStorageImageMultisample: Boolean = false,
        var shaderStorageImageReadWithoutFormat: Boolean = false,
        var shaderStorageImageWriteWithoutFormat: Boolean = false,
        var shaderUniformBufferArrayDynamicIndexing: Boolean = false,
        var shaderSampledImageArrayDynamicIndexing: Boolean = false,
        var shaderStorageBufferArrayDynamicIndexing: Boolean = false,
        var shaderStorageImageArrayDynamicIndexing: Boolean = false,
        var shaderClipDistance: Boolean = false,
        var shaderCullDistance: Boolean = false,
        var shaderFloat64: Boolean = false,
        var shaderInt64: Boolean = false,
        var shaderInt16: Boolean = false,
        var shaderResourceResidency: Boolean = false,
        var shaderResourceMinLod: Boolean = false,
        var sparseBinding: Boolean = false,
        var sparseResidencyBuffer: Boolean = false,
        var sparseResidencyImage2D: Boolean = false,
        var sparseResidencyImage3D: Boolean = false,
        var sparseResidency2Samples: Boolean = false,
        var sparseResidency4Samples: Boolean = false,
        var sparseResidency8Samples: Boolean = false,
        var sparseResidency16Samples: Boolean = false,
        var sparseResidencyAliased: Boolean = false,
        var variableMultisampleRate: Boolean = false,
        var inheritedQueries: Boolean = false
) {

    infix fun write(stack: MemoryStack): Adr =
            stack.ncalloc(ALIGNOF, 1, SIZEOF).also { write(it) }

    infix fun write(adr: Adr) {
        nrobustBufferAccess(adr, robustBufferAccess.i)
        nfullDrawIndexUint32(adr, fullDrawIndexUint32.i)
        nimageCubeArray(adr, imageCubeArray.i)
        nindependentBlend(adr, independentBlend.i)
        ngeometryShader(adr, geometryShader.i)
        ntessellationShader(adr, tessellationShader.i)
        nsampleRateShading(adr, sampleRateShading.i)
        ndualSrcBlend(adr, dualSrcBlend.i)
        nlogicOp(adr, logicOp.i)
        nmultiDrawIndirect(adr, multiDrawIndirect.i)
        ndrawIndirectFirstInstance(adr, drawIndirectFirstInstance.i)
        ndepthClamp(adr, depthClamp.i)
        ndepthBiasClamp(adr, depthBiasClamp.i)
        nfillModeNonSolid(adr, fillModeNonSolid.i)
        ndepthBounds(adr, depthBounds.i)
        nwideLines(adr, wideLines.i)
        nlargePoints(adr, largePoints.i)
        nalphaToOne(adr, alphaToOne.i)
        nmultiViewport(adr, multiViewport.i)
        nsamplerAnisotropy(adr, samplerAnisotropy.i)
        ntextureCompressionETC2(adr, textureCompressionETC2.i)
        ntextureCompressionASTC_LDR(adr, textureCompressionASTC_LDR.i)
        ntextureCompressionBC(adr, textureCompressionBC.i)
        nocclusionQueryPrecise(adr, occlusionQueryPrecise.i)
        npipelineStatisticsQuery(adr, pipelineStatisticsQuery.i)
        nvertexPipelineStoresAndAtomics(adr, vertexPipelineStoresAndAtomics.i)
        nfragmentStoresAndAtomics(adr, fragmentStoresAndAtomics.i)
        nshaderTessellationAndGeometryPointSize(adr, shaderTessellationAndGeometryPointSize.i)
        nshaderImageGatherExtended(adr, shaderImageGatherExtended.i)
        nshaderStorageImageExtendedFormats(adr, shaderStorageImageExtendedFormats.i)
        nshaderStorageImageMultisample(adr, shaderStorageImageMultisample.i)
        nshaderStorageImageReadWithoutFormat(adr, shaderStorageImageReadWithoutFormat.i)
        nshaderStorageImageWriteWithoutFormat(adr, shaderStorageImageWriteWithoutFormat.i)
        nshaderUniformBufferArrayDynamicIndexing(adr, shaderUniformBufferArrayDynamicIndexing.i)
        nshaderSampledImageArrayDynamicIndexing(adr, shaderSampledImageArrayDynamicIndexing.i)
        nshaderStorageBufferArrayDynamicIndexing(adr, shaderStorageBufferArrayDynamicIndexing.i)
        nshaderStorageImageArrayDynamicIndexing(adr, shaderStorageImageArrayDynamicIndexing.i)
        nshaderClipDistance(adr, shaderClipDistance.i)
        nshaderCullDistance(adr, shaderCullDistance.i)
        nshaderFloat64(adr, shaderFloat64.i)
        nshaderInt64(adr, shaderInt64.i)
        nshaderInt16(adr, shaderInt16.i)
        nshaderResourceResidency(adr, shaderResourceResidency.i)
        nshaderResourceMinLod(adr, shaderResourceMinLod.i)
        nsparseBinding(adr, sparseBinding.i)
        nsparseResidencyBuffer(adr, sparseResidencyBuffer.i)
        nsparseResidencyImage2D(adr, sparseResidencyImage2D.i)
        nsparseResidencyImage3D(adr, sparseResidencyImage3D.i)
        nsparseResidency2Samples(adr, sparseResidency2Samples.i)
        nsparseResidency4Samples(adr, sparseResidency4Samples.i)
        nsparseResidency8Samples(adr, sparseResidency8Samples.i)
        nsparseResidency16Samples(adr, sparseResidency16Samples.i)
        nsparseResidencyAliased(adr, sparseResidencyAliased.i)
        nvariableMultisampleRate(adr, variableMultisampleRate.i)
        ninheritedQueries(adr, inheritedQueries.i)
    }
}