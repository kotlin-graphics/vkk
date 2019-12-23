package vkk.identifiers

import kool.Adr
import kool.Ptr
import org.lwjgl.system.FunctionProvider
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.vulkan.*
import java.util.*

/** Defines the capabilities of a Vulkan `VkDevice`.  */
class CapabilitiesDevice internal constructor(
        provider: FunctionProvider,
        capsInstance: CapabilitiesInstance,
        ext: Set<String>
) {
    // VK10
    val vkGetDeviceProcAddr: Adr
    val vkDestroyDevice: Adr
    val vkGetDeviceQueue: Adr
    val vkQueueSubmit: Adr
    val vkQueueWaitIdle: Adr
    val vkDeviceWaitIdle: Adr
    val vkAllocateMemory: Adr
    val vkFreeMemory: Adr
    val vkMapMemory: Adr
    val vkUnmapMemory: Adr
    val vkFlushMappedMemoryRanges: Adr
    val vkInvalidateMappedMemoryRanges: Adr
    val vkGetDeviceMemoryCommitment: Adr
    val vkBindBufferMemory: Adr
    val vkBindImageMemory: Adr
    val vkGetBufferMemoryRequirements: Adr
    val vkGetImageMemoryRequirements: Adr
    val vkGetImageSparseMemoryRequirements: Adr
    val vkQueueBindSparse: Adr
    val vkCreateFence: Adr
    val vkDestroyFence: Adr
    val vkResetFences: Adr
    val vkGetFenceStatus: Adr
    val vkWaitForFences: Adr
    val vkCreateSemaphore: Adr
    val vkDestroySemaphore: Adr
    val vkCreateEvent: Adr
    val vkDestroyEvent: Adr
    val vkGetEventStatus: Adr
    val vkSetEvent: Adr
    val vkResetEvent: Adr
    val vkCreateQueryPool: Adr
    val vkDestroyQueryPool: Adr
    val vkGetQueryPoolResults: Adr
    val vkCreateBuffer: Adr
    val vkDestroyBuffer: Adr
    val vkCreateBufferView: Adr
    val vkDestroyBufferView: Adr
    val vkCreateImage: Adr
    val vkDestroyImage: Adr
    val vkGetImageSubresourceLayout: Adr
    val vkCreateImageView: Adr
    val vkDestroyImageView: Adr
    val vkCreateShaderModule: Adr
    val vkDestroyShaderModule: Adr
    val vkCreatePipelineCache: Adr
    val vkDestroyPipelineCache: Adr
    val vkGetPipelineCacheData: Adr
    val vkMergePipelineCaches: Adr
    val vkCreateGraphicsPipelines: Adr
    val vkCreateComputePipelines: Adr
    val vkDestroyPipeline: Adr
    val vkCreatePipelineLayout: Adr
    val vkDestroyPipelineLayout: Adr
    val vkCreateSampler: Adr
    val vkDestroySampler: Adr
    val vkCreateDescriptorSetLayout: Adr
    val vkDestroyDescriptorSetLayout: Adr
    val vkCreateDescriptorPool: Adr
    val vkDestroyDescriptorPool: Adr
    val vkResetDescriptorPool: Adr
    val vkAllocateDescriptorSets: Adr
    val vkFreeDescriptorSets: Adr
    val vkUpdateDescriptorSets: Adr
    val vkCreateFramebuffer: Adr
    val vkDestroyFramebuffer: Adr
    val vkCreateRenderPass: Adr
    val vkDestroyRenderPass: Adr
    val vkGetRenderAreaGranularity: Adr
    val vkCreateCommandPool: Adr
    val vkDestroyCommandPool: Adr
    val vkResetCommandPool: Adr
    val vkAllocateCommandBuffers: Adr
    val vkFreeCommandBuffers: Adr
    val vkBeginCommandBuffer: Adr
    val vkEndCommandBuffer: Adr
    val vkResetCommandBuffer: Adr
    val vkCmdBindPipeline: Adr
    val vkCmdSetViewport: Adr
    val vkCmdSetScissor: Adr
    val vkCmdSetLineWidth: Adr
    val vkCmdSetDepthBias: Adr
    val vkCmdSetBlendConstants: Adr
    val vkCmdSetDepthBounds: Adr
    val vkCmdSetStencilCompareMask: Adr
    val vkCmdSetStencilWriteMask: Adr
    val vkCmdSetStencilReference: Adr
    val vkCmdBindDescriptorSets: Adr
    val vkCmdBindIndexBuffer: Adr
    val vkCmdBindVertexBuffers: Adr
    val vkCmdDraw: Adr
    val vkCmdDrawIndexed: Adr
    val vkCmdDrawIndirect: Adr
    val vkCmdDrawIndexedIndirect: Adr
    val vkCmdDispatch: Adr
    val vkCmdDispatchIndirect: Adr
    val vkCmdCopyBuffer: Adr
    val vkCmdCopyImage: Adr
    val vkCmdBlitImage: Adr
    val vkCmdCopyBufferToImage: Adr
    val vkCmdCopyImageToBuffer: Adr
    val vkCmdUpdateBuffer: Adr
    val vkCmdFillBuffer: Adr
    val vkCmdClearColorImage: Adr
    val vkCmdClearDepthStencilImage: Adr
    val vkCmdClearAttachments: Adr
    val vkCmdResolveImage: Adr
    val vkCmdSetEvent: Adr
    val vkCmdResetEvent: Adr
    val vkCmdWaitEvents: Adr
    val vkCmdPipelineBarrier: Adr
    val vkCmdBeginQuery: Adr
    val vkCmdEndQuery: Adr
    val vkCmdResetQueryPool: Adr
    val vkCmdWriteTimestamp: Adr
    val vkCmdCopyQueryPoolResults: Adr
    val vkCmdPushConstants: Adr
    val vkCmdBeginRenderPass: Adr
    val vkCmdNextSubpass: Adr
    val vkCmdEndRenderPass: Adr
    val vkCmdExecuteCommands: Adr
    // VK11
    val vkBindBufferMemory2: Adr
    val vkBindImageMemory2: Adr
    val vkGetDeviceGroupPeerMemoryFeatures: Adr
    val vkCmdSetDeviceMask: Adr
    val vkCmdDispatchBase: Adr
    val vkGetImageMemoryRequirements2: Adr
    val vkGetBufferMemoryRequirements2: Adr
    val vkGetImageSparseMemoryRequirements2: Adr
    val vkTrimCommandPool: Adr
    val vkGetDeviceQueue2: Adr
    val vkCreateSamplerYcbcrConversion: Adr
    val vkDestroySamplerYcbcrConversion: Adr
    val vkCreateDescriptorUpdateTemplate: Adr
    val vkDestroyDescriptorUpdateTemplate: Adr
    val vkUpdateDescriptorSetWithTemplate: Adr
    val vkGetDescriptorSetLayoutSupport: Adr
    // AMD_buffer_marker
    val vkCmdWriteBufferMarkerAMD: Adr
    // AMD_display_native_hdr
    val vkSetLocalDimmingAMD: Adr
    // AMD_draw_indirect_count
    val vkCmdDrawIndirectCountAMD: Adr
    val vkCmdDrawIndexedIndirectCountAMD: Adr
    // AMD_shader_info
    val vkGetShaderInfoAMD: Adr
    // EXT_buffer_device_address
    val vkGetBufferDeviceAddressEXT: Adr
    // EXT_calibrated_timestamps
    val vkGetCalibratedTimestampsEXT: Adr
    // EXT_conditional_rendering
    val vkCmdBeginConditionalRenderingEXT: Adr
    val vkCmdEndConditionalRenderingEXT: Adr
    // EXT_debug_marker
    val vkDebugMarkerSetObjectTagEXT: Adr
    val vkDebugMarkerSetObjectNameEXT: Adr
    val vkCmdDebugMarkerBeginEXT: Adr
    val vkCmdDebugMarkerEndEXT: Adr
    val vkCmdDebugMarkerInsertEXT: Adr
    // EXT_debug_utils
    val vkSetDebugUtilsObjectNameEXT: Adr
    val vkSetDebugUtilsObjectTagEXT: Adr
    val vkQueueBeginDebugUtilsLabelEXT: Adr
    val vkQueueEndDebugUtilsLabelEXT: Adr
    val vkQueueInsertDebugUtilsLabelEXT: Adr
    val vkCmdBeginDebugUtilsLabelEXT: Adr
    val vkCmdEndDebugUtilsLabelEXT: Adr
    val vkCmdInsertDebugUtilsLabelEXT: Adr
    // EXT_discard_rectangles
    val vkCmdSetDiscardRectangleEXT: Adr
    // EXT_display_control
    val vkDisplayPowerControlEXT: Adr
    val vkRegisterDeviceEventEXT: Adr
    val vkRegisterDisplayEventEXT: Adr
    val vkGetSwapchainCounterEXT: Adr
    // EXT_external_memory_host
    val vkGetMemoryHostPointerPropertiesEXT: Adr
    // EXT_full_screen_exclusive
    val vkAcquireFullScreenExclusiveModeEXT: Adr
    val vkReleaseFullScreenExclusiveModeEXT: Adr
    val vkGetDeviceGroupSurfacePresentModes2EXT: Adr
    // EXT_hdr_metadata
    val vkSetHdrMetadataEXT: Adr
    // EXT_host_query_reset
    val vkResetQueryPoolEXT: Adr
    // EXT_image_drm_format_modifier
    val vkGetImageDrmFormatModifierPropertiesEXT: Adr
    // EXT_line_rasterization
    val vkCmdSetLineStippleEXT: Adr
    // EXT_sample_locations
    val vkCmdSetSampleLocationsEXT: Adr
    // EXT_transform_feedback
    val vkCmdBindTransformFeedbackBuffersEXT: Adr
    val vkCmdBeginTransformFeedbackEXT: Adr
    val vkCmdEndTransformFeedbackEXT: Adr
    val vkCmdBeginQueryIndexedEXT: Adr
    val vkCmdEndQueryIndexedEXT: Adr
    val vkCmdDrawIndirectByteCountEXT: Adr
    // EXT_validation_cache
    val vkCreateValidationCacheEXT: Adr
    val vkDestroyValidationCacheEXT: Adr
    val vkMergeValidationCachesEXT: Adr
    val vkGetValidationCacheDataEXT: Adr
    // GOOGLE_display_timing
    val vkGetRefreshCycleDurationGOOGLE: Adr
    val vkGetPastPresentationTimingGOOGLE: Adr
    // INTEL_performance_query
    val vkInitializePerformanceApiINTEL: Adr
    val vkUninitializePerformanceApiINTEL: Adr
    val vkCmdSetPerformanceMarkerINTEL: Adr
    val vkCmdSetPerformanceStreamMarkerINTEL: Adr
    val vkCmdSetPerformanceOverrideINTEL: Adr
    val vkAcquirePerformanceConfigurationINTEL: Adr
    val vkReleasePerformanceConfigurationINTEL: Adr
    val vkQueueSetPerformanceConfigurationINTEL: Adr
    val vkGetPerformanceParameterINTEL: Adr
    // KHR_bind_memory2
    val vkBindBufferMemory2KHR: Adr
    val vkBindImageMemory2KHR: Adr
    // KHR_create_renderpass2
    val vkCreateRenderPass2KHR: Adr
    val vkCmdBeginRenderPass2KHR: Adr
    val vkCmdNextSubpass2KHR: Adr
    val vkCmdEndRenderPass2KHR: Adr
    // KHR_descriptor_update_template
    val vkCreateDescriptorUpdateTemplateKHR: Adr
    val vkDestroyDescriptorUpdateTemplateKHR: Adr
    val vkUpdateDescriptorSetWithTemplateKHR: Adr
    val vkCmdPushDescriptorSetWithTemplateKHR: Adr
    // KHR_device_group
    val vkGetDeviceGroupPeerMemoryFeaturesKHR: Adr
    val vkCmdSetDeviceMaskKHR: Adr
    val vkCmdDispatchBaseKHR: Adr
    val vkGetDeviceGroupPresentCapabilitiesKHR: Adr
    val vkGetDeviceGroupSurfacePresentModesKHR: Adr
    val vkAcquireNextImage2KHR: Adr
    // KHR_display_swapchain
    val vkCreateSharedSwapchainsKHR: Adr
    // KHR_draw_indirect_count
    val vkCmdDrawIndirectCountKHR: Adr
    val vkCmdDrawIndexedIndirectCountKHR: Adr
    // KHR_external_fence_fd
    val vkImportFenceFdKHR: Adr
    val vkGetFenceFdKHR: Adr
    // KHR_external_fence_win32
    val vkImportFenceWin32HandleKHR: Adr
    val vkGetFenceWin32HandleKHR: Adr
    // KHR_external_memory_fd
    val vkGetMemoryFdKHR: Adr
    val vkGetMemoryFdPropertiesKHR: Adr
    // KHR_external_memory_win32
    val vkGetMemoryWin32HandleKHR: Adr
    val vkGetMemoryWin32HandlePropertiesKHR: Adr
    // KHR_external_semaphore_fd
    val vkImportSemaphoreFdKHR: Adr
    val vkGetSemaphoreFdKHR: Adr
    // KHR_external_semaphore_win32
    val vkImportSemaphoreWin32HandleKHR: Adr
    val vkGetSemaphoreWin32HandleKHR: Adr
    // KHR_get_memory_requirements2
    val vkGetImageMemoryRequirements2KHR: Adr
    val vkGetBufferMemoryRequirements2KHR: Adr
    val vkGetImageSparseMemoryRequirements2KHR: Adr
    // KHR_maintenance1
    val vkTrimCommandPoolKHR: Adr
    // KHR_maintenance3
    val vkGetDescriptorSetLayoutSupportKHR: Adr
    // KHR_pipeline_executable_properties
    val vkGetPipelineExecutablePropertiesKHR: Adr
    val vkGetPipelineExecutableStatisticsKHR: Adr
    val vkGetPipelineExecutableInternalRepresentationsKHR: Adr
    // KHR_push_descriptor
    val vkCmdPushDescriptorSetKHR: Adr
    // KHR_sampler_ycbcr_conversion
    val vkCreateSamplerYcbcrConversionKHR: Adr
    val vkDestroySamplerYcbcrConversionKHR: Adr
    // KHR_shared_presentable_image
    val vkGetSwapchainStatusKHR: Adr
    // KHR_swapchain
    val vkCreateSwapchainKHR: Adr
    val vkDestroySwapchainKHR: Adr
    val vkGetSwapchainImagesKHR: Adr
    val vkAcquireNextImageKHR: Adr
    val vkQueuePresentKHR: Adr
    // NV_clip_space_w_scaling
    val vkCmdSetViewportWScalingNV: Adr
    // NV_device_diagnostic_checkpoints
    val vkCmdSetCheckpointNV: Adr
    val vkGetQueueCheckpointDataNV: Adr
    // NV_external_memory_win32
    val vkGetMemoryWin32HandleNV: Adr
    // NV_mesh_shader
    val vkCmdDrawMeshTasksNV: Adr
    val vkCmdDrawMeshTasksIndirectNV: Adr
    val vkCmdDrawMeshTasksIndirectCountNV: Adr
    // NV_ray_tracing
    val vkCreateAccelerationStructureNV: Adr
    val vkDestroyAccelerationStructureNV: Adr
    val vkGetAccelerationStructureMemoryRequirementsNV: Adr
    val vkBindAccelerationStructureMemoryNV: Adr
    val vkCmdBuildAccelerationStructureNV: Adr
    val vkCmdCopyAccelerationStructureNV: Adr
    val vkCmdTraceRaysNV: Adr
    val vkCreateRayTracingPipelinesNV: Adr
    val vkGetRayTracingShaderGroupHandlesNV: Adr
    val vkGetAccelerationStructureHandleNV: Adr
    val vkCmdWriteAccelerationStructuresPropertiesNV: Adr
    val vkCompileDeferredNV: Adr
    // NV_scissor_exclusive
    val vkCmdSetExclusiveScissorNV: Adr
    // NV_shading_rate_image
    val vkCmdBindShadingRateImageNV: Adr
    val vkCmdSetViewportShadingRatePaletteNV: Adr
    val vkCmdSetCoarseSampleOrderNV: Adr
    // NVX_device_generated_commands
    val vkCmdProcessCommandsNVX: Adr
    val vkCmdReserveSpaceForCommandsNVX: Adr
    val vkCreateIndirectCommandsLayoutNVX: Adr
    val vkDestroyIndirectCommandsLayoutNVX: Adr
    val vkCreateObjectTableNVX: Adr
    val vkDestroyObjectTableNVX: Adr
    val vkRegisterObjectsNVX: Adr
    val vkUnregisterObjectsNVX: Adr
    // NVX_image_view_handle
    val vkGetImageViewHandleNVX: Adr
    /** The Vulkan API version number.  */
    val apiVersion: Int
    /** When true, [VK10] is supported.  */
    val Vulkan10: Boolean
    /** When true, [VK11] is supported.  */
    val Vulkan11: Boolean

    /** When true, [AMDBufferMarker] is supported.  */
    val VK_AMD_buffer_marker: Boolean
    /** When true, [AMDDeviceCoherentMemory] is supported.  */
    val VK_AMD_device_coherent_memory: Boolean
    /** When true, [AMDDisplayNativeHdr] is supported.  */
    val VK_AMD_display_native_hdr: Boolean
    /** When true, [AMDDrawIndirectCount] is supported.  */
    val VK_AMD_draw_indirect_count: Boolean
    /** When true, [AMDGCNShader] is supported.  */
    val VK_AMD_gcn_shader: Boolean
    /** When true, [AMDGPUShaderHalfFloat] is supported.  */
    val VK_AMD_gpu_shader_half_float: Boolean
    /** When true, [AMDGPUShaderInt16] is supported.  */
    val VK_AMD_gpu_shader_int16: Boolean
    /** When true, [AMDMemoryOverallocationBehavior] is supported.  */
    val VK_AMD_memory_overallocation_behavior: Boolean
    /** When true, [AMDMixedAttachmentSamples] is supported.  */
    val VK_AMD_mixed_attachment_samples: Boolean
    /** When true, [AMDNegativeViewportHeight] is supported.  */
    val VK_AMD_negative_viewport_height: Boolean
    /** When true, [AMDPipelineCompilerControl] is supported.  */
    val VK_AMD_pipeline_compiler_control: Boolean
    /** When true, [AMDRasterizationOrder] is supported.  */
    val VK_AMD_rasterization_order: Boolean
    /** When true, [AMDShaderBallot] is supported.  */
    val VK_AMD_shader_ballot: Boolean
    /** When true, [AMDShaderCoreProperties] is supported.  */
    val VK_AMD_shader_core_properties: Boolean
    /** When true, [AMDShaderCoreProperties2] is supported.  */
    val VK_AMD_shader_core_properties2: Boolean
    /** When true, [AMDShaderExplicitVertexParameter] is supported.  */
    val VK_AMD_shader_explicit_vertex_parameter: Boolean
    /** When true, [AMDShaderFragmentMask] is supported.  */
    val VK_AMD_shader_fragment_mask: Boolean
    /** When true, [AMDShaderImageLoadStoreLod] is supported.  */
    val VK_AMD_shader_image_load_store_lod: Boolean
    /** When true, [AMDShaderInfo] is supported.  */
    val VK_AMD_shader_info: Boolean
    /** When true, [AMDShaderTrinaryMinmax] is supported.  */
    val VK_AMD_shader_trinary_minmax: Boolean
    /** When true, [AMDTextureGatherBiasLod] is supported.  */
    val VK_AMD_texture_gather_bias_lod: Boolean
    /** When true, [EXTAstcDecodeMode] is supported.  */
    val VK_EXT_astc_decode_mode: Boolean
    /** When true, [EXTBlendOperationAdvanced] is supported.  */
    val VK_EXT_blend_operation_advanced: Boolean
    /** When true, [EXTBufferDeviceAddress] is supported.  */
    val VK_EXT_buffer_device_address: Boolean
    /** When true, [EXTCalibratedTimestamps] is supported.  */
    val VK_EXT_calibrated_timestamps: Boolean
    /** When true, [EXTConditionalRendering] is supported.  */
    val VK_EXT_conditional_rendering: Boolean
    /** When true, [EXTConservativeRasterization] is supported.  */
    val VK_EXT_conservative_rasterization: Boolean
    /** When true, [EXTDebugMarker] is supported.  */
    val VK_EXT_debug_marker: Boolean
    /** When true, [EXTDepthClipEnable] is supported.  */
    val VK_EXT_depth_clip_enable: Boolean
    /** When true, [EXTDepthRangeUnrestricted] is supported.  */
    val VK_EXT_depth_range_unrestricted: Boolean
    /** When true, [EXTDescriptorIndexing] is supported.  */
    val VK_EXT_descriptor_indexing: Boolean
    /** When true, [EXTDiscardRectangles] is supported.  */
    val VK_EXT_discard_rectangles: Boolean
    /** When true, [EXTDisplayControl] is supported.  */
    val VK_EXT_display_control: Boolean
    /** When true, [EXTExternalMemoryDmaBuf] is supported.  */
    val VK_EXT_external_memory_dma_buf: Boolean
    /** When true, [EXTExternalMemoryHost] is supported.  */
    val VK_EXT_external_memory_host: Boolean
    /** When true, [EXTFilterCubic] is supported.  */
    val VK_EXT_filter_cubic: Boolean
    /** When true, [EXTFragmentDensityMap] is supported.  */
    val VK_EXT_fragment_density_map: Boolean
    /** When true, [EXTFragmentShaderInterlock] is supported.  */
    val VK_EXT_fragment_shader_interlock: Boolean
    /** When true, [EXTFullScreenExclusive] is supported.  */
    val VK_EXT_full_screen_exclusive: Boolean
    /** When true, [EXTGlobalPriority] is supported.  */
    val VK_EXT_global_priority: Boolean
    /** When true, [EXTHdrMetadata] is supported.  */
    val VK_EXT_hdr_metadata: Boolean
    /** When true, [EXTHostQueryReset] is supported.  */
    val VK_EXT_host_query_reset: Boolean
    /** When true, [EXTImageDrmFormatModifier] is supported.  */
    val VK_EXT_image_drm_format_modifier: Boolean
    /** When true, [EXTIndexTypeUint8] is supported.  */
    val VK_EXT_index_type_uint8: Boolean
    /** When true, [EXTInlineUniformBlock] is supported.  */
    val VK_EXT_inline_uniform_block: Boolean
    /** When true, [EXTLineRasterization] is supported.  */
    val VK_EXT_line_rasterization: Boolean
    /** When true, [EXTMemoryBudget] is supported.  */
    val VK_EXT_memory_budget: Boolean
    /** When true, [EXTMemoryPriority] is supported.  */
    val VK_EXT_memory_priority: Boolean
    /** When true, [EXTPciBusInfo] is supported.  */
    val VK_EXT_pci_bus_info: Boolean
    /** When true, [EXTPipelineCreationFeedback] is supported.  */
    val VK_EXT_pipeline_creation_feedback: Boolean
    /** When true, [EXTPostDepthCoverage] is supported.  */
    val VK_EXT_post_depth_coverage: Boolean
    /** When true, [EXTQueueFamilyForeign] is supported.  */
    val VK_EXT_queue_family_foreign: Boolean
    /** When true, [EXTSampleLocations] is supported.  */
    val VK_EXT_sample_locations: Boolean
    /** When true, [EXTSamplerFilterMinmax] is supported.  */
    val VK_EXT_sampler_filter_minmax: Boolean
    /** When true, [EXTScalarBlockLayout] is supported.  */
    val VK_EXT_scalar_block_layout: Boolean
    /** When true, [EXTSeparateStencilUsage] is supported.  */
    val VK_EXT_separate_stencil_usage: Boolean
    /** When true, [EXTShaderDemoteToHelperInvocation] is supported.  */
    val VK_EXT_shader_demote_to_helper_invocation: Boolean
    /** When true, [EXTShaderStencilExport] is supported.  */
    val VK_EXT_shader_stencil_export: Boolean
    /** When true, [EXTShaderSubgroupBallot] is supported.  */
    val VK_EXT_shader_subgroup_ballot: Boolean
    /** When true, [EXTShaderSubgroupVote] is supported.  */
    val VK_EXT_shader_subgroup_vote: Boolean
    /** When true, [EXTShaderViewportIndexLayer] is supported.  */
    val VK_EXT_shader_viewport_index_layer: Boolean
    /** When true, [EXTSubgroupSizeControl] is supported.  */
    val VK_EXT_subgroup_size_control: Boolean
    /** When true, [EXTTexelBufferAlignment] is supported.  */
    val VK_EXT_texel_buffer_alignment: Boolean
    /** When true, [EXTTextureCompressionAstcHdr] is supported.  */
    val VK_EXT_texture_compression_astc_hdr: Boolean
    /** When true, [EXTTransformFeedback] is supported.  */
    val VK_EXT_transform_feedback: Boolean
    /** When true, [EXTValidationCache] is supported.  */
    val VK_EXT_validation_cache: Boolean
    /** When true, [EXTVertexAttributeDivisor] is supported.  */
    val VK_EXT_vertex_attribute_divisor: Boolean
    /** When true, [EXTYcbcrImageArrays] is supported.  */
    val VK_EXT_ycbcr_image_arrays: Boolean
    /** When true, [GOOGLEDecorateString] is supported.  */
    val VK_GOOGLE_decorate_string: Boolean
    /** When true, [GOOGLEDisplayTiming] is supported.  */
    val VK_GOOGLE_display_timing: Boolean
    /** When true, [GOOGLEHlslFunctionality1] is supported.  */
    val VK_GOOGLE_hlsl_functionality1: Boolean
    /** When true, [IMGFilterCubic] is supported.  */
    val VK_IMG_filter_cubic: Boolean
    /** When true, [IMGFormatPVRTC] is supported.  */
    val VK_IMG_format_pvrtc: Boolean
    /** When true, [INTELPerformanceQuery] is supported.  */
    val VK_INTEL_performance_query: Boolean
    /** When true, [INTELShaderIntegerFunctions2] is supported.  */
    val VK_INTEL_shader_integer_functions2: Boolean
    /** When true, [KHR16bitStorage] is supported.  */
    val VK_KHR_16bit_storage: Boolean
    /** When true, [KHR8bitStorage] is supported.  */
    val VK_KHR_8bit_storage: Boolean
    /** When true, [KHRBindMemory2] is supported.  */
    val VK_KHR_bind_memory2: Boolean
    /** When true, [KHRCreateRenderpass2] is supported.  */
    val VK_KHR_create_renderpass2: Boolean
    /** When true, [KHRDedicatedAllocation] is supported.  */
    val VK_KHR_dedicated_allocation: Boolean
    /** When true, [KHRDepthStencilResolve] is supported.  */
    val VK_KHR_depth_stencil_resolve: Boolean
    /** When true, [KHRDescriptorUpdateTemplate] is supported.  */
    val VK_KHR_descriptor_update_template: Boolean
    /** When true, [KHRDeviceGroup] is supported.  */
    val VK_KHR_device_group: Boolean
    /** When true, [KHRDisplaySwapchain] is supported.  */
    val VK_KHR_display_swapchain: Boolean
    /** When true, [KHRDrawIndirectCount] is supported.  */
    val VK_KHR_draw_indirect_count: Boolean
    /** When true, [KHRDriverProperties] is supported.  */
    val VK_KHR_driver_properties: Boolean
    /** When true, [KHRExternalFence] is supported.  */
    val VK_KHR_external_fence: Boolean
    /** When true, [KHRExternalFenceFd] is supported.  */
    val VK_KHR_external_fence_fd: Boolean
    /** When true, [KHRExternalFenceWin32] is supported.  */
    val VK_KHR_external_fence_win32: Boolean
    /** When true, [KHRExternalMemory] is supported.  */
    val VK_KHR_external_memory: Boolean
    /** When true, [KHRExternalMemoryFd] is supported.  */
    val VK_KHR_external_memory_fd: Boolean
    /** When true, [KHRExternalMemoryWin32] is supported.  */
    val VK_KHR_external_memory_win32: Boolean
    /** When true, [KHRExternalSemaphore] is supported.  */
    val VK_KHR_external_semaphore: Boolean
    /** When true, [KHRExternalSemaphoreFd] is supported.  */
    val VK_KHR_external_semaphore_fd: Boolean
    /** When true, [KHRExternalSemaphoreWin32] is supported.  */
    val VK_KHR_external_semaphore_win32: Boolean
    /** When true, [KHRGetMemoryRequirements2] is supported.  */
    val VK_KHR_get_memory_requirements2: Boolean
    /** When true, [KHRImageFormatList] is supported.  */
    val VK_KHR_image_format_list: Boolean
    /** When true, [KHRImagelessFramebuffer] is supported.  */
    val VK_KHR_imageless_framebuffer: Boolean
    /** When true, [KHRIncrementalPresent] is supported.  */
    val VK_KHR_incremental_present: Boolean
    /** When true, [KHRMaintenance1] is supported.  */
    val VK_KHR_maintenance1: Boolean
    /** When true, [KHRMaintenance2] is supported.  */
    val VK_KHR_maintenance2: Boolean
    /** When true, [KHRMaintenance3] is supported.  */
    val VK_KHR_maintenance3: Boolean
    /** When true, [KHRMultiview] is supported.  */
    val VK_KHR_multiview: Boolean
    /** When true, [KHRPipelineExecutableProperties] is supported.  */
    val VK_KHR_pipeline_executable_properties: Boolean
    /** When true, [KHRPushDescriptor] is supported.  */
    val VK_KHR_push_descriptor: Boolean
    /** When true, [KHRRelaxedBlockLayout] is supported.  */
    val VK_KHR_relaxed_block_layout: Boolean
    /** When true, [KHRSamplerMirrorClampToEdge] is supported.  */
    val VK_KHR_sampler_mirror_clamp_to_edge: Boolean
    /** When true, [KHRSamplerYcbcrConversion] is supported.  */
    val VK_KHR_sampler_ycbcr_conversion: Boolean
    /** When true, [KHRShaderAtomicInt64] is supported.  */
    val VK_KHR_shader_atomic_int64: Boolean
    /** When true, [KHRShaderDrawParameters] is supported.  */
    val VK_KHR_shader_draw_parameters: Boolean
    /** When true, [KHRShaderFloat16Int8] is supported.  */
    val VK_KHR_shader_float16_int8: Boolean
    /** When true, [KHRShaderFloatControls] is supported.  */
    val VK_KHR_shader_float_controls: Boolean
    /** When true, [KHRSharedPresentableImage] is supported.  */
    val VK_KHR_shared_presentable_image: Boolean
    /** When true, [KHRStorageBufferStorageClass] is supported.  */
    val VK_KHR_storage_buffer_storage_class: Boolean
    /** When true, [KHRSwapchain] is supported.  */
    val VK_KHR_swapchain: Boolean
    /** When true, [KHRSwapchainMutableFormat] is supported.  */
    val VK_KHR_swapchain_mutable_format: Boolean
    /** When true, [KHRUniformBufferStandardLayout] is supported.  */
    val VK_KHR_uniform_buffer_standard_layout: Boolean
    /** When true, [KHRVariablePointers] is supported.  */
    val VK_KHR_variable_pointers: Boolean
    /** When true, [KHRVulkanMemoryModel] is supported.  */
    val VK_KHR_vulkan_memory_model: Boolean
    /** When true, [KHRWin32KeyedMutex] is supported.  */
    val VK_KHR_win32_keyed_mutex: Boolean
    /** When true, [NVClipSpaceWScaling] is supported.  */
    val VK_NV_clip_space_w_scaling: Boolean
    /** When true, [NVComputeShaderDerivatives] is supported.  */
    val VK_NV_compute_shader_derivatives: Boolean
    /** When true, [NVCooperativeMatrix] is supported.  */
    val VK_NV_cooperative_matrix: Boolean
    /** When true, [NVCornerSampledImage] is supported.  */
    val VK_NV_corner_sampled_image: Boolean
    /** When true, [NVCoverageReductionMode] is supported.  */
    val VK_NV_coverage_reduction_mode: Boolean
    /** When true, [NVDedicatedAllocation] is supported.  */
    val VK_NV_dedicated_allocation: Boolean
    /** When true, [NVDedicatedAllocationImageAliasing] is supported.  */
    val VK_NV_dedicated_allocation_image_aliasing: Boolean
    /** When true, [NVDeviceDiagnosticCheckpoints] is supported.  */
    val VK_NV_device_diagnostic_checkpoints: Boolean
    /** When true, [NVExternalMemory] is supported.  */
    val VK_NV_external_memory: Boolean
    /** When true, [NVExternalMemoryWin32] is supported.  */
    val VK_NV_external_memory_win32: Boolean
    /** When true, [NVFillRectangle] is supported.  */
    val VK_NV_fill_rectangle: Boolean
    /** When true, [NVFragmentCoverageToColor] is supported.  */
    val VK_NV_fragment_coverage_to_color: Boolean
    /** When true, [NVFragmentShaderBarycentric] is supported.  */
    val VK_NV_fragment_shader_barycentric: Boolean
    /** When true, [NVFramebufferMixedSamples] is supported.  */
    val VK_NV_framebuffer_mixed_samples: Boolean
    /** When true, [NVGeometryShaderPassthrough] is supported.  */
    val VK_NV_geometry_shader_passthrough: Boolean
    /** When true, [NVGLSLShader] is supported.  */
    val VK_NV_glsl_shader: Boolean
    /** When true, [NVMeshShader] is supported.  */
    val VK_NV_mesh_shader: Boolean
    /** When true, [NVRayTracing] is supported.  */
    val VK_NV_ray_tracing: Boolean
    /** When true, [NVRepresentativeFragmentTest] is supported.  */
    val VK_NV_representative_fragment_test: Boolean
    /** When true, [NVSampleMaskOverrideCoverage] is supported.  */
    val VK_NV_sample_mask_override_coverage: Boolean
    /** When true, [NVScissorExclusive] is supported.  */
    val VK_NV_scissor_exclusive: Boolean
    /** When true, [NVShaderImageFootprint] is supported.  */
    val VK_NV_shader_image_footprint: Boolean
    /** When true, [NVShaderSmBuiltins] is supported.  */
    val VK_NV_shader_sm_builtins: Boolean
    /** When true, [NVShaderSubgroupPartitioned] is supported.  */
    val VK_NV_shader_subgroup_partitioned: Boolean
    /** When true, [NVShadingRateImage] is supported.  */
    val VK_NV_shading_rate_image: Boolean
    /** When true, [NVViewportArray2] is supported.  */
    val VK_NV_viewport_array2: Boolean
    /** When true, [NVViewportSwizzle] is supported.  */
    val VK_NV_viewport_swizzle: Boolean
    /** When true, [NVWin32KeyedMutex] is supported.  */
    val VK_NV_win32_keyed_mutex: Boolean
    /** When true, [NVXDeviceGeneratedCommands] is supported.  */
    val VK_NVX_device_generated_commands: Boolean
    /** When true, [NVXImageViewHandle] is supported.  */
    val VK_NVX_image_view_handle: Boolean
    /** When true, [NVXMultiviewPerViewAttributes] is supported.  */
    val VK_NVX_multiview_per_view_attributes: Boolean

    init {
        apiVersion = capsInstance.apiVersion
        val caps = HashMap<String, Ptr>(274)
        operator fun String.invoke(): Ptr = caps[this] ?: NULL
        operator fun String.invoke(vararg functions: String): Boolean = this in ext && VK.checkExtension(this, provider.areSupported(caps, *functions))
        fun areSupported(vararg functions: String): Boolean = provider.areSupported(caps, *functions)
        fun isSupported(function: String, satisfiedDependency: Boolean): Boolean = provider.isSupported(function, caps, satisfiedDependency)
        Vulkan10 = "Vulkan10"("vkGetDeviceProcAddr", "vkDestroyDevice", "vkGetDeviceQueue", "vkQueueSubmit", "vkQueueWaitIdle", "vkDeviceWaitIdle", "vkAllocateMemory", "vkFreeMemory", "vkMapMemory", "vkUnmapMemory", "vkFlushMappedMemoryRanges", "vkInvalidateMappedMemoryRanges",
                "vkGetDeviceMemoryCommitment", "vkBindBufferMemory", "vkBindImageMemory", "vkGetBufferMemoryRequirements", "vkGetImageMemoryRequirements", "vkGetImageSparseMemoryRequirements", "vkQueueBindSparse", "vkCreateFence", "vkDestroyFence", "vkResetFences", "vkGetFenceStatus",
                "vkWaitForFences", "vkCreateSemaphore", "vkDestroySemaphore", "vkCreateEvent", "vkDestroyEvent", "vkGetEventStatus", "vkSetEvent", "vkResetEvent", "vkCreateQueryPool", "vkDestroyQueryPool", "vkGetQueryPoolResults", "vkCreateBuffer", "vkDestroyBuffer", "vkCreateBufferView",
                "vkDestroyBufferView", "vkCreateImage", "vkDestroyImage", "vkGetImageSubresourceLayout", "vkCreateImageView", "vkDestroyImageView", "vkCreateShaderModule", "vkDestroyShaderModule", "vkCreatePipelineCache", "vkDestroyPipelineCache", "vkGetPipelineCacheData", "vkMergePipelineCaches",
                "vkCreateGraphicsPipelines", "vkCreateComputePipelines", "vkDestroyPipeline", "vkCreatePipelineLayout", "vkDestroyPipelineLayout", "vkCreateSampler", "vkDestroySampler", "vkCreateDescriptorSetLayout", "vkDestroyDescriptorSetLayout", "vkCreateDescriptorPool", "vkDestroyDescriptorPool",
                "vkResetDescriptorPool", "vkAllocateDescriptorSets", "vkFreeDescriptorSets", "vkUpdateDescriptorSets", "vkCreateFramebuffer", "vkDestroyFramebuffer", "vkCreateRenderPass", "vkDestroyRenderPass", "vkGetRenderAreaGranularity", "vkCreateCommandPool", "vkDestroyCommandPool",
                "vkResetCommandPool", "vkAllocateCommandBuffers", "vkFreeCommandBuffers", "vkBeginCommandBuffer", "vkEndCommandBuffer", "vkResetCommandBuffer", "vkCmdBindPipeline", "vkCmdSetViewport", "vkCmdSetScissor", "vkCmdSetLineWidth", "vkCmdSetDepthBias", "vkCmdSetBlendConstants",
                "vkCmdSetDepthBounds", "vkCmdSetStencilCompareMask", "vkCmdSetStencilWriteMask", "vkCmdSetStencilReference", "vkCmdBindDescriptorSets", "vkCmdBindIndexBuffer", "vkCmdBindVertexBuffers", "vkCmdDraw", "vkCmdDrawIndexed", "vkCmdDrawIndirect", "vkCmdDrawIndexedIndirect", "vkCmdDispatch",
                "vkCmdDispatchIndirect", "vkCmdCopyBuffer", "vkCmdCopyImage", "vkCmdBlitImage", "vkCmdCopyBufferToImage", "vkCmdCopyImageToBuffer", "vkCmdUpdateBuffer", "vkCmdFillBuffer", "vkCmdClearColorImage", "vkCmdClearDepthStencilImage", "vkCmdClearAttachments", "vkCmdResolveImage",
                "vkCmdSetEvent", "vkCmdResetEvent", "vkCmdWaitEvents", "vkCmdPipelineBarrier", "vkCmdBeginQuery", "vkCmdEndQuery", "vkCmdResetQueryPool", "vkCmdWriteTimestamp", "vkCmdCopyQueryPoolResults", "vkCmdPushConstants", "vkCmdBeginRenderPass", "vkCmdNextSubpass", "vkCmdEndRenderPass",
                "vkCmdExecuteCommands")
        Vulkan11 = "Vulkan11"("vkBindBufferMemory2", "vkBindImageMemory2", "vkGetDeviceGroupPeerMemoryFeatures", "vkCmdSetDeviceMask", "vkCmdDispatchBase", "vkGetImageMemoryRequirements2", "vkGetBufferMemoryRequirements2", "vkGetImageSparseMemoryRequirements2", "vkTrimCommandPool",
                "vkGetDeviceQueue2", "vkCreateSamplerYcbcrConversion", "vkDestroySamplerYcbcrConversion", "vkCreateDescriptorUpdateTemplate", "vkDestroyDescriptorUpdateTemplate", "vkUpdateDescriptorSetWithTemplate", "vkGetDescriptorSetLayoutSupport")
        VK_AMD_buffer_marker = "VK_AMD_buffer_marker"("vkCmdWriteBufferMarkerAMD")
        VK_AMD_device_coherent_memory = "VK_AMD_device_coherent_memory" in ext
        VK_AMD_display_native_hdr = "VK_AMD_display_native_hdr"("vkSetLocalDimmingAMD")
        VK_AMD_draw_indirect_count = "VK_AMD_draw_indirect_count"("vkCmdDrawIndirectCountAMD", "vkCmdDrawIndexedIndirectCountAMD")
        VK_AMD_gcn_shader = "VK_AMD_gcn_shader" in ext
        VK_AMD_gpu_shader_half_float = "VK_AMD_gpu_shader_half_float" in ext
        VK_AMD_gpu_shader_int16 = "VK_AMD_gpu_shader_int16" in ext
        VK_AMD_memory_overallocation_behavior = "VK_AMD_memory_overallocation_behavior" in ext
        VK_AMD_mixed_attachment_samples = "VK_AMD_mixed_attachment_samples" in ext
        VK_AMD_negative_viewport_height = "VK_AMD_negative_viewport_height" in ext
        VK_AMD_pipeline_compiler_control = "VK_AMD_pipeline_compiler_control" in ext
        VK_AMD_rasterization_order = "VK_AMD_rasterization_order" in ext
        VK_AMD_shader_ballot = "VK_AMD_shader_ballot" in ext
        VK_AMD_shader_core_properties = "VK_AMD_shader_core_properties" in ext
        VK_AMD_shader_core_properties2 = "VK_AMD_shader_core_properties2" in ext
        VK_AMD_shader_explicit_vertex_parameter = "VK_AMD_shader_explicit_vertex_parameter" in ext
        VK_AMD_shader_fragment_mask = "VK_AMD_shader_fragment_mask" in ext
        VK_AMD_shader_image_load_store_lod = "VK_AMD_shader_image_load_store_lod" in ext
        VK_AMD_shader_info = "VK_AMD_shader_info"("vkGetShaderInfoAMD")
        VK_AMD_shader_trinary_minmax = "VK_AMD_shader_trinary_minmax" in ext
        VK_AMD_texture_gather_bias_lod = "VK_AMD_texture_gather_bias_lod" in ext
        VK_EXT_astc_decode_mode = "VK_EXT_astc_decode_mode" in ext
        VK_EXT_blend_operation_advanced = "VK_EXT_blend_operation_advanced" in ext
        VK_EXT_buffer_device_address = "VK_EXT_buffer_device_address"("vkGetBufferDeviceAddressEXT")
        VK_EXT_calibrated_timestamps = "VK_EXT_calibrated_timestamps"("vkGetCalibratedTimestampsEXT")
        VK_EXT_conditional_rendering = "VK_EXT_conditional_rendering"("vkCmdBeginConditionalRenderingEXT", "vkCmdEndConditionalRenderingEXT")
        VK_EXT_conservative_rasterization = "VK_EXT_conservative_rasterization" in ext
        VK_EXT_debug_marker = "VK_EXT_debug_marker"("vkDebugMarkerSetObjectTagEXT", "vkDebugMarkerSetObjectNameEXT", "vkCmdDebugMarkerBeginEXT", "vkCmdDebugMarkerEndEXT", "vkCmdDebugMarkerInsertEXT")
        "VK_EXT_debug_utils"("vkSetDebugUtilsObjectNameEXT", "vkSetDebugUtilsObjectTagEXT", "vkQueueBeginDebugUtilsLabelEXT", "vkQueueEndDebugUtilsLabelEXT", "vkQueueInsertDebugUtilsLabelEXT", "vkCmdBeginDebugUtilsLabelEXT", "vkCmdEndDebugUtilsLabelEXT", "vkCmdInsertDebugUtilsLabelEXT")
        VK_EXT_depth_clip_enable = "VK_EXT_depth_clip_enable" in ext
        VK_EXT_depth_range_unrestricted = "VK_EXT_depth_range_unrestricted" in ext
        VK_EXT_descriptor_indexing = "VK_EXT_descriptor_indexing" in ext
        VK_EXT_discard_rectangles = "VK_EXT_discard_rectangles"("vkCmdSetDiscardRectangleEXT")
        VK_EXT_display_control = "VK_EXT_display_control"("vkDisplayPowerControlEXT", "vkRegisterDeviceEventEXT", "vkRegisterDisplayEventEXT", "vkGetSwapchainCounterEXT")
        VK_EXT_external_memory_dma_buf = "VK_EXT_external_memory_dma_buf" in ext
        VK_EXT_external_memory_host = "VK_EXT_external_memory_host"("vkGetMemoryHostPointerPropertiesEXT")
        VK_EXT_filter_cubic = "VK_EXT_filter_cubic" in ext
        VK_EXT_fragment_density_map = "VK_EXT_fragment_density_map" in ext
        VK_EXT_fragment_shader_interlock = "VK_EXT_fragment_shader_interlock" in ext
        VK_EXT_full_screen_exclusive = "VK_EXT_full_screen_exclusive" in ext && VK.checkExtension("VK_EXT_full_screen_exclusive", areSupported("vkAcquireFullScreenExclusiveModeEXT", "vkReleaseFullScreenExclusiveModeEXT")
                && isSupported("vkGetDeviceGroupSurfacePresentModes2EXT", "Vulkan11" in ext || "VK_KHR_device_group" in ext))
        VK_EXT_global_priority = "VK_EXT_global_priority" in ext
        VK_EXT_hdr_metadata = "VK_EXT_hdr_metadata"("vkSetHdrMetadataEXT")
        VK_EXT_host_query_reset = "VK_EXT_host_query_reset"("vkResetQueryPoolEXT")
        VK_EXT_image_drm_format_modifier = "VK_EXT_image_drm_format_modifier"("vkGetImageDrmFormatModifierPropertiesEXT")
        VK_EXT_index_type_uint8 = "VK_EXT_index_type_uint8" in ext
        VK_EXT_inline_uniform_block = "VK_EXT_inline_uniform_block" in ext
        VK_EXT_line_rasterization = "VK_EXT_line_rasterization"("vkCmdSetLineStippleEXT")
        VK_EXT_memory_budget = "VK_EXT_memory_budget" in ext
        VK_EXT_memory_priority = "VK_EXT_memory_priority" in ext
        VK_EXT_pci_bus_info = "VK_EXT_pci_bus_info" in ext
        VK_EXT_pipeline_creation_feedback = "VK_EXT_pipeline_creation_feedback" in ext
        VK_EXT_post_depth_coverage = "VK_EXT_post_depth_coverage" in ext
        VK_EXT_queue_family_foreign = "VK_EXT_queue_family_foreign" in ext
        VK_EXT_sample_locations = "VK_EXT_sample_locations"("vkCmdSetSampleLocationsEXT")
        VK_EXT_sampler_filter_minmax = "VK_EXT_sampler_filter_minmax" in ext
        VK_EXT_scalar_block_layout = "VK_EXT_scalar_block_layout" in ext
        VK_EXT_separate_stencil_usage = "VK_EXT_separate_stencil_usage" in ext
        VK_EXT_shader_demote_to_helper_invocation = "VK_EXT_shader_demote_to_helper_invocation" in ext
        VK_EXT_shader_stencil_export = "VK_EXT_shader_stencil_export" in ext
        VK_EXT_shader_subgroup_ballot = "VK_EXT_shader_subgroup_ballot" in ext
        VK_EXT_shader_subgroup_vote = "VK_EXT_shader_subgroup_vote" in ext
        VK_EXT_shader_viewport_index_layer = "VK_EXT_shader_viewport_index_layer" in ext
        VK_EXT_subgroup_size_control = "VK_EXT_subgroup_size_control" in ext
        VK_EXT_texel_buffer_alignment = "VK_EXT_texel_buffer_alignment" in ext
        VK_EXT_texture_compression_astc_hdr = "VK_EXT_texture_compression_astc_hdr" in ext
        VK_EXT_transform_feedback = "VK_EXT_transform_feedback"("vkCmdBindTransformFeedbackBuffersEXT", "vkCmdBeginTransformFeedbackEXT", "vkCmdEndTransformFeedbackEXT", "vkCmdBeginQueryIndexedEXT", "vkCmdEndQueryIndexedEXT", "vkCmdDrawIndirectByteCountEXT")
        VK_EXT_validation_cache = "VK_EXT_validation_cache"("vkCreateValidationCacheEXT", "vkDestroyValidationCacheEXT", "vkMergeValidationCachesEXT", "vkGetValidationCacheDataEXT")
        VK_EXT_vertex_attribute_divisor = "VK_EXT_vertex_attribute_divisor" in ext
        VK_EXT_ycbcr_image_arrays = "VK_EXT_ycbcr_image_arrays" in ext
        VK_GOOGLE_decorate_string = "VK_GOOGLE_decorate_string" in ext
        VK_GOOGLE_display_timing = "VK_GOOGLE_display_timing"("vkGetRefreshCycleDurationGOOGLE", "vkGetPastPresentationTimingGOOGLE")
        VK_GOOGLE_hlsl_functionality1 = "VK_GOOGLE_hlsl_functionality1" in ext
        VK_IMG_filter_cubic = "VK_IMG_filter_cubic" in ext
        VK_IMG_format_pvrtc = "VK_IMG_format_pvrtc" in ext
        VK_INTEL_performance_query = "VK_INTEL_performance_query"("vkInitializePerformanceApiINTEL", "vkUninitializePerformanceApiINTEL", "vkCmdSetPerformanceMarkerINTEL", "vkCmdSetPerformanceStreamMarkerINTEL", "vkCmdSetPerformanceOverrideINTEL", "vkAcquirePerformanceConfigurationINTEL",
                "vkReleasePerformanceConfigurationINTEL", "vkQueueSetPerformanceConfigurationINTEL", "vkGetPerformanceParameterINTEL")
        VK_INTEL_shader_integer_functions2 = "VK_INTEL_shader_integer_functions2" in ext
        VK_KHR_16bit_storage = "VK_KHR_16bit_storage" in ext
        VK_KHR_8bit_storage = "VK_KHR_8bit_storage" in ext
        VK_KHR_bind_memory2 = "VK_KHR_bind_memory2"("vkBindBufferMemory2KHR", "vkBindImageMemory2KHR")
        VK_KHR_create_renderpass2 = "VK_KHR_create_renderpass2"("vkCreateRenderPass2KHR", "vkCmdBeginRenderPass2KHR", "vkCmdNextSubpass2KHR", "vkCmdEndRenderPass2KHR")
        VK_KHR_dedicated_allocation = "VK_KHR_dedicated_allocation" in ext
        VK_KHR_depth_stencil_resolve = "VK_KHR_depth_stencil_resolve" in ext
        VK_KHR_descriptor_update_template = "VK_KHR_descriptor_update_template" in ext && VK.checkExtension("VK_KHR_descriptor_update_template", areSupported("vkCreateDescriptorUpdateTemplateKHR", "vkDestroyDescriptorUpdateTemplateKHR", "vkUpdateDescriptorSetWithTemplateKHR")
                && isSupported("vkCmdPushDescriptorSetWithTemplateKHR", "VK_KHR_push_descriptor" in ext))
        VK_KHR_device_group = "VK_KHR_device_group" in ext && VK.checkExtension("VK_KHR_device_group", areSupported("vkGetDeviceGroupPeerMemoryFeaturesKHR", "vkCmdSetDeviceMaskKHR", "vkCmdDispatchBaseKHR")
                && isSupported("vkGetDeviceGroupPresentCapabilitiesKHR", "VK_KHR_surface" in ext) && isSupported("vkGetDeviceGroupSurfacePresentModesKHR", "VK_KHR_surface" in ext)
                && isSupported("vkAcquireNextImage2KHR", "VK_KHR_swapchain" in ext))
        VK_KHR_display_swapchain = "VK_KHR_display_swapchain"("vkCreateSharedSwapchainsKHR")
        VK_KHR_draw_indirect_count = "VK_KHR_draw_indirect_count"("vkCmdDrawIndirectCountKHR", "vkCmdDrawIndexedIndirectCountKHR")
        VK_KHR_driver_properties = "VK_KHR_driver_properties" in ext
        VK_KHR_external_fence = "VK_KHR_external_fence" in ext
        VK_KHR_external_fence_fd = "VK_KHR_external_fence_fd"("vkImportFenceFdKHR", "vkGetFenceFdKHR")
        VK_KHR_external_fence_win32 = "VK_KHR_external_fence_win32"("vkImportFenceWin32HandleKHR", "vkGetFenceWin32HandleKHR")
        VK_KHR_external_memory = "VK_KHR_external_memory" in ext
        VK_KHR_external_memory_fd = "VK_KHR_external_memory_fd"("vkGetMemoryFdKHR", "vkGetMemoryFdPropertiesKHR")
        VK_KHR_external_memory_win32 = "VK_KHR_external_memory_win32"("vkGetMemoryWin32HandleKHR", "vkGetMemoryWin32HandlePropertiesKHR")
        VK_KHR_external_semaphore = "VK_KHR_external_semaphore" in ext
        VK_KHR_external_semaphore_fd = "VK_KHR_external_semaphore_fd"("vkImportSemaphoreFdKHR", "vkGetSemaphoreFdKHR")
        VK_KHR_external_semaphore_win32 = "VK_KHR_external_semaphore_win32"("vkImportSemaphoreWin32HandleKHR", "vkGetSemaphoreWin32HandleKHR")
        VK_KHR_get_memory_requirements2 = "VK_KHR_get_memory_requirements2"("vkGetImageMemoryRequirements2KHR", "vkGetBufferMemoryRequirements2KHR", "vkGetImageSparseMemoryRequirements2KHR")
        VK_KHR_image_format_list = "VK_KHR_image_format_list" in ext
        VK_KHR_imageless_framebuffer = "VK_KHR_imageless_framebuffer" in ext
        VK_KHR_incremental_present = "VK_KHR_incremental_present" in ext
        VK_KHR_maintenance1 = "VK_KHR_maintenance1"("vkTrimCommandPoolKHR")
        VK_KHR_maintenance2 = "VK_KHR_maintenance2" in ext
        VK_KHR_maintenance3 = "VK_KHR_maintenance3"("vkGetDescriptorSetLayoutSupportKHR", "VK_KHR_multiview")
        VK_KHR_multiview = "VK_KHR_multiview" in ext
        VK_KHR_pipeline_executable_properties = "VK_KHR_pipeline_executable_properties"("vkGetPipelineExecutablePropertiesKHR", "vkGetPipelineExecutableStatisticsKHR", "vkGetPipelineExecutableInternalRepresentationsKHR")
        VK_KHR_push_descriptor = "VK_KHR_push_descriptor" in ext && VK.checkExtension("VK_KHR_push_descriptor", areSupported("vkCmdPushDescriptorSetKHR") && isSupported("vkCmdPushDescriptorSetWithTemplateKHR", "Vulkan11" in ext))
        VK_KHR_relaxed_block_layout = "VK_KHR_relaxed_block_layout" in ext
        VK_KHR_sampler_mirror_clamp_to_edge = "VK_KHR_sampler_mirror_clamp_to_edge" in ext
        VK_KHR_sampler_ycbcr_conversion = "VK_KHR_sampler_ycbcr_conversion"("vkCreateSamplerYcbcrConversionKHR", "vkDestroySamplerYcbcrConversionKHR")
        VK_KHR_shader_atomic_int64 = "VK_KHR_shader_atomic_int64" in ext
        VK_KHR_shader_draw_parameters = "VK_KHR_shader_draw_parameters" in ext
        VK_KHR_shader_float16_int8 = "VK_KHR_shader_float16_int8" in ext
        VK_KHR_shader_float_controls = "VK_KHR_shader_float_controls" in ext
        VK_KHR_shared_presentable_image = "VK_KHR_shared_presentable_image"("vkGetSwapchainStatusKHR")
        VK_KHR_storage_buffer_storage_class = "VK_KHR_storage_buffer_storage_class" in ext
        VK_KHR_swapchain = "VK_KHR_swapchain" in ext && VK.checkExtension("VK_KHR_swapchain", areSupported("vkCreateSwapchainKHR", "vkDestroySwapchainKHR", "vkGetSwapchainImagesKHR", "vkAcquireNextImageKHR", "vkQueuePresentKHR")
                && isSupported("vkGetDeviceGroupPresentCapabilitiesKHR", "Vulkan11" in ext) && isSupported("vkGetDeviceGroupSurfacePresentModesKHR", "Vulkan11" in ext) && isSupported("vkAcquireNextImage2KHR", "Vulkan11" in ext))
        VK_KHR_swapchain_mutable_format = "VK_KHR_swapchain_mutable_format" in ext
        VK_KHR_uniform_buffer_standard_layout = "VK_KHR_uniform_buffer_standard_layout" in ext
        VK_KHR_variable_pointers = "VK_KHR_variable_pointers" in ext
        VK_KHR_vulkan_memory_model = "VK_KHR_vulkan_memory_model" in ext
        VK_KHR_win32_keyed_mutex = "VK_KHR_win32_keyed_mutex" in ext
        VK_NV_clip_space_w_scaling = "VK_NV_clip_space_w_scaling"("vkCmdSetViewportWScalingNV")
        VK_NV_compute_shader_derivatives = "VK_NV_compute_shader_derivatives" in ext
        VK_NV_cooperative_matrix = "VK_NV_cooperative_matrix" in ext
        VK_NV_corner_sampled_image = "VK_NV_corner_sampled_image" in ext
        VK_NV_coverage_reduction_mode = "VK_NV_coverage_reduction_mode" in ext
        VK_NV_dedicated_allocation = "VK_NV_dedicated_allocation" in ext
        VK_NV_dedicated_allocation_image_aliasing = "VK_NV_dedicated_allocation_image_aliasing" in ext
        VK_NV_device_diagnostic_checkpoints = "VK_NV_device_diagnostic_checkpoints"("vkCmdSetCheckpointNV", "vkGetQueueCheckpointDataNV")
        VK_NV_external_memory = "VK_NV_external_memory" in ext
        VK_NV_external_memory_win32 = "VK_NV_external_memory_win32"("vkGetMemoryWin32HandleNV")
        VK_NV_fill_rectangle = "VK_NV_fill_rectangle" in ext
        VK_NV_fragment_coverage_to_color = "VK_NV_fragment_coverage_to_color" in ext
        VK_NV_fragment_shader_barycentric = "VK_NV_fragment_shader_barycentric" in ext
        VK_NV_framebuffer_mixed_samples = "VK_NV_framebuffer_mixed_samples" in ext
        VK_NV_geometry_shader_passthrough = "VK_NV_geometry_shader_passthrough" in ext
        VK_NV_glsl_shader = "VK_NV_glsl_shader" in ext
        VK_NV_mesh_shader = "VK_NV_mesh_shader"("vkCmdDrawMeshTasksNV", "vkCmdDrawMeshTasksIndirectNV", "vkCmdDrawMeshTasksIndirectCountNV")
        VK_NV_ray_tracing = "VK_NV_ray_tracing"("vkCreateAccelerationStructureNV", "vkDestroyAccelerationStructureNV", "vkGetAccelerationStructureMemoryRequirementsNV", "vkBindAccelerationStructureMemoryNV", "vkCmdBuildAccelerationStructureNV", "vkCmdCopyAccelerationStructureNV",
                "vkCmdTraceRaysNV", "vkCreateRayTracingPipelinesNV", "vkGetRayTracingShaderGroupHandlesNV", "vkGetAccelerationStructureHandleNV", "vkCmdWriteAccelerationStructuresPropertiesNV", "vkCompileDeferredNV")
        VK_NV_representative_fragment_test = ext.contains("VK_NV_representative_fragment_test")
        VK_NV_sample_mask_override_coverage = ext.contains("VK_NV_sample_mask_override_coverage")
        VK_NV_scissor_exclusive = "VK_NV_scissor_exclusive"("vkCmdSetExclusiveScissorNV")
        VK_NV_shader_image_footprint = "VK_NV_shader_image_footprint" in ext
        VK_NV_shader_sm_builtins = "VK_NV_shader_sm_builtins" in ext
        VK_NV_shader_subgroup_partitioned = "VK_NV_shader_subgroup_partitioned" in ext
        VK_NV_shading_rate_image = "VK_NV_shading_rate_image"("vkCmdBindShadingRateImageNV", "vkCmdSetViewportShadingRatePaletteNV", "vkCmdSetCoarseSampleOrderNV")
        VK_NV_viewport_array2 = "VK_NV_viewport_array2" in ext
        VK_NV_viewport_swizzle = "VK_NV_viewport_swizzle" in ext
        VK_NV_win32_keyed_mutex = "VK_NV_win32_keyed_mutex" in ext
        VK_NVX_device_generated_commands = "VK_NVX_device_generated_commands"("vkCmdProcessCommandsNVX", "vkCmdReserveSpaceForCommandsNVX", "vkCreateIndirectCommandsLayoutNVX", "vkDestroyIndirectCommandsLayoutNVX", "vkCreateObjectTableNVX", "vkDestroyObjectTableNVX", "vkRegisterObjectsNVX",
                "vkUnregisterObjectsNVX")
        VK_NVX_image_view_handle = "VK_NVX_image_view_handle"("vkGetImageViewHandleNVX")
        VK_NVX_multiview_per_view_attributes = "VK_NVX_multiview_per_view_attributes" in ext
        vkGetDeviceProcAddr = "vkGetDeviceProcAddr"()
        vkDestroyDevice = "vkDestroyDevice"()
        vkGetDeviceQueue = "vkGetDeviceQueue"()
        vkQueueSubmit = "vkQueueSubmit"()
        vkQueueWaitIdle = "vkQueueWaitIdle"()
        vkDeviceWaitIdle = "vkDeviceWaitIdle"()
        vkAllocateMemory = "vkAllocateMemory"()
        vkFreeMemory = "vkFreeMemory"()
        vkMapMemory = "vkMapMemory"()
        vkUnmapMemory = "vkUnmapMemory"()
        vkFlushMappedMemoryRanges = "vkFlushMappedMemoryRanges"()
        vkInvalidateMappedMemoryRanges = "vkInvalidateMappedMemoryRanges"()
        vkGetDeviceMemoryCommitment = "vkGetDeviceMemoryCommitment"()
        vkBindBufferMemory = "vkBindBufferMemory"()
        vkBindImageMemory = "vkBindImageMemory"()
        vkGetBufferMemoryRequirements = "vkGetBufferMemoryRequirements"()
        vkGetImageMemoryRequirements = "vkGetImageMemoryRequirements"()
        vkGetImageSparseMemoryRequirements = "vkGetImageSparseMemoryRequirements"()
        vkQueueBindSparse = "vkQueueBindSparse"()
        vkCreateFence = "vkCreateFence"()
        vkDestroyFence = "vkDestroyFence"()
        vkResetFences = "vkResetFences"()
        vkGetFenceStatus = "vkGetFenceStatus"()
        vkWaitForFences = "vkWaitForFences"()
        vkCreateSemaphore = "vkCreateSemaphore"()
        vkDestroySemaphore = "vkDestroySemaphore"()
        vkCreateEvent = "vkCreateEvent"()
        vkDestroyEvent = "vkDestroyEvent"()
        vkGetEventStatus = "vkGetEventStatus"()
        vkSetEvent = "vkSetEvent"()
        vkResetEvent = "vkResetEvent"()
        vkCreateQueryPool = "vkCreateQueryPool"()
        vkDestroyQueryPool = "vkDestroyQueryPool"()
        vkGetQueryPoolResults = "vkGetQueryPoolResults"()
        vkCreateBuffer = "vkCreateBuffer"()
        vkDestroyBuffer = "vkDestroyBuffer"()
        vkCreateBufferView = "vkCreateBufferView"()
        vkDestroyBufferView = "vkDestroyBufferView"()
        vkCreateImage = "vkCreateImage"()
        vkDestroyImage = "vkDestroyImage"()
        vkGetImageSubresourceLayout = "vkGetImageSubresourceLayout"()
        vkCreateImageView = "vkCreateImageView"()
        vkDestroyImageView = "vkDestroyImageView"()
        vkCreateShaderModule = "vkCreateShaderModule"()
        vkDestroyShaderModule = "vkDestroyShaderModule"()
        vkCreatePipelineCache = "vkCreatePipelineCache"()
        vkDestroyPipelineCache = "vkDestroyPipelineCache"()
        vkGetPipelineCacheData = "vkGetPipelineCacheData"()
        vkMergePipelineCaches = "vkMergePipelineCaches"()
        vkCreateGraphicsPipelines = "vkCreateGraphicsPipelines"()
        vkCreateComputePipelines = "vkCreateComputePipelines"()
        vkDestroyPipeline = "vkDestroyPipeline"()
        vkCreatePipelineLayout = "vkCreatePipelineLayout"()
        vkDestroyPipelineLayout = "vkDestroyPipelineLayout"()
        vkCreateSampler = "vkCreateSampler"()
        vkDestroySampler = "vkDestroySampler"()
        vkCreateDescriptorSetLayout = "vkCreateDescriptorSetLayout"()
        vkDestroyDescriptorSetLayout = "vkDestroyDescriptorSetLayout"()
        vkCreateDescriptorPool = "vkCreateDescriptorPool"()
        vkDestroyDescriptorPool = "vkDestroyDescriptorPool"()
        vkResetDescriptorPool = "vkResetDescriptorPool"()
        vkAllocateDescriptorSets = "vkAllocateDescriptorSets"()
        vkFreeDescriptorSets = "vkFreeDescriptorSets"()
        vkUpdateDescriptorSets = "vkUpdateDescriptorSets"()
        vkCreateFramebuffer = "vkCreateFramebuffer"()
        vkDestroyFramebuffer = "vkDestroyFramebuffer"()
        vkCreateRenderPass = "vkCreateRenderPass"()
        vkDestroyRenderPass = "vkDestroyRenderPass"()
        vkGetRenderAreaGranularity = "vkGetRenderAreaGranularity"()
        vkCreateCommandPool = "vkCreateCommandPool"()
        vkDestroyCommandPool = "vkDestroyCommandPool"()
        vkResetCommandPool = "vkResetCommandPool"()
        vkAllocateCommandBuffers = "vkAllocateCommandBuffers"()
        vkFreeCommandBuffers = "vkFreeCommandBuffers"()
        vkBeginCommandBuffer = "vkBeginCommandBuffer"()
        vkEndCommandBuffer = "vkEndCommandBuffer"()
        vkResetCommandBuffer = "vkResetCommandBuffer"()
        vkCmdBindPipeline = "vkCmdBindPipeline"()
        vkCmdSetViewport = "vkCmdSetViewport"()
        vkCmdSetScissor = "vkCmdSetScissor"()
        vkCmdSetLineWidth = "vkCmdSetLineWidth"()
        vkCmdSetDepthBias = "vkCmdSetDepthBias"()
        vkCmdSetBlendConstants = "vkCmdSetBlendConstants"()
        vkCmdSetDepthBounds = "vkCmdSetDepthBounds"()
        vkCmdSetStencilCompareMask = "vkCmdSetStencilCompareMask"()
        vkCmdSetStencilWriteMask = "vkCmdSetStencilWriteMask"()
        vkCmdSetStencilReference = "vkCmdSetStencilReference"()
        vkCmdBindDescriptorSets = "vkCmdBindDescriptorSets"()
        vkCmdBindIndexBuffer = "vkCmdBindIndexBuffer"()
        vkCmdBindVertexBuffers = "vkCmdBindVertexBuffers"()
        vkCmdDraw = "vkCmdDraw"()
        vkCmdDrawIndexed = "vkCmdDrawIndexed"()
        vkCmdDrawIndirect = "vkCmdDrawIndirect"()
        vkCmdDrawIndexedIndirect = "vkCmdDrawIndexedIndirect"()
        vkCmdDispatch = "vkCmdDispatch"()
        vkCmdDispatchIndirect = "vkCmdDispatchIndirect"()
        vkCmdCopyBuffer = "vkCmdCopyBuffer"()
        vkCmdCopyImage = "vkCmdCopyImage"()
        vkCmdBlitImage = "vkCmdBlitImage"()
        vkCmdCopyBufferToImage = "vkCmdCopyBufferToImage"()
        vkCmdCopyImageToBuffer = "vkCmdCopyImageToBuffer"()
        vkCmdUpdateBuffer = "vkCmdUpdateBuffer"()
        vkCmdFillBuffer = "vkCmdFillBuffer"()
        vkCmdClearColorImage = "vkCmdClearColorImage"()
        vkCmdClearDepthStencilImage = "vkCmdClearDepthStencilImage"()
        vkCmdClearAttachments = "vkCmdClearAttachments"()
        vkCmdResolveImage = "vkCmdResolveImage"()
        vkCmdSetEvent = "vkCmdSetEvent"()
        vkCmdResetEvent = "vkCmdResetEvent"()
        vkCmdWaitEvents = "vkCmdWaitEvents"()
        vkCmdPipelineBarrier = "vkCmdPipelineBarrier"()
        vkCmdBeginQuery = "vkCmdBeginQuery"()
        vkCmdEndQuery = "vkCmdEndQuery"()
        vkCmdResetQueryPool = "vkCmdResetQueryPool"()
        vkCmdWriteTimestamp = "vkCmdWriteTimestamp"()
        vkCmdCopyQueryPoolResults = "vkCmdCopyQueryPoolResults"()
        vkCmdPushConstants = "vkCmdPushConstants"()
        vkCmdBeginRenderPass = "vkCmdBeginRenderPass"()
        vkCmdNextSubpass = "vkCmdNextSubpass"()
        vkCmdEndRenderPass = "vkCmdEndRenderPass"()
        vkCmdExecuteCommands = "vkCmdExecuteCommands"()
        vkBindBufferMemory2 = "vkBindBufferMemory2"()
        vkBindImageMemory2 = "vkBindImageMemory2"()
        vkGetDeviceGroupPeerMemoryFeatures = "vkGetDeviceGroupPeerMemoryFeatures"()
        vkCmdSetDeviceMask = "vkCmdSetDeviceMask"()
        vkCmdDispatchBase = "vkCmdDispatchBase"()
        vkGetImageMemoryRequirements2 = "vkGetImageMemoryRequirements2"()
        vkGetBufferMemoryRequirements2 = "vkGetBufferMemoryRequirements2"()
        vkGetImageSparseMemoryRequirements2 = "vkGetImageSparseMemoryRequirements2"()
        vkTrimCommandPool = "vkTrimCommandPool"()
        vkGetDeviceQueue2 = "vkGetDeviceQueue2"()
        vkCreateSamplerYcbcrConversion = "vkCreateSamplerYcbcrConversion"()
        vkDestroySamplerYcbcrConversion = "vkDestroySamplerYcbcrConversion"()
        vkCreateDescriptorUpdateTemplate = "vkCreateDescriptorUpdateTemplate"()
        vkDestroyDescriptorUpdateTemplate = "vkDestroyDescriptorUpdateTemplate"()
        vkUpdateDescriptorSetWithTemplate = "vkUpdateDescriptorSetWithTemplate"()
        vkGetDescriptorSetLayoutSupport = "vkGetDescriptorSetLayoutSupport"()
        vkCmdWriteBufferMarkerAMD = "vkCmdWriteBufferMarkerAMD"()
        vkSetLocalDimmingAMD = "vkSetLocalDimmingAMD"()
        vkCmdDrawIndirectCountAMD = "vkCmdDrawIndirectCountAMD"()
        vkCmdDrawIndexedIndirectCountAMD = "vkCmdDrawIndexedIndirectCountAMD"()
        vkGetShaderInfoAMD = "vkGetShaderInfoAMD"()
        vkGetBufferDeviceAddressEXT = "vkGetBufferDeviceAddressEXT"()
        vkGetCalibratedTimestampsEXT = "vkGetCalibratedTimestampsEXT"()
        vkCmdBeginConditionalRenderingEXT = "vkCmdBeginConditionalRenderingEXT"()
        vkCmdEndConditionalRenderingEXT = "vkCmdEndConditionalRenderingEXT"()
        vkDebugMarkerSetObjectTagEXT = "vkDebugMarkerSetObjectTagEXT"()
        vkDebugMarkerSetObjectNameEXT = "vkDebugMarkerSetObjectNameEXT"()
        vkCmdDebugMarkerBeginEXT = "vkCmdDebugMarkerBeginEXT"()
        vkCmdDebugMarkerEndEXT = "vkCmdDebugMarkerEndEXT"()
        vkCmdDebugMarkerInsertEXT = "vkCmdDebugMarkerInsertEXT"()
        vkSetDebugUtilsObjectNameEXT = "vkSetDebugUtilsObjectNameEXT"()
        vkSetDebugUtilsObjectTagEXT = "vkSetDebugUtilsObjectTagEXT"()
        vkQueueBeginDebugUtilsLabelEXT = "vkQueueBeginDebugUtilsLabelEXT"()
        vkQueueEndDebugUtilsLabelEXT = "vkQueueEndDebugUtilsLabelEXT"()
        vkQueueInsertDebugUtilsLabelEXT = "vkQueueInsertDebugUtilsLabelEXT"()
        vkCmdBeginDebugUtilsLabelEXT = "vkCmdBeginDebugUtilsLabelEXT"()
        vkCmdEndDebugUtilsLabelEXT = "vkCmdEndDebugUtilsLabelEXT"()
        vkCmdInsertDebugUtilsLabelEXT = "vkCmdInsertDebugUtilsLabelEXT"()
        vkCmdSetDiscardRectangleEXT = "vkCmdSetDiscardRectangleEXT"()
        vkDisplayPowerControlEXT = "vkDisplayPowerControlEXT"()
        vkRegisterDeviceEventEXT = "vkRegisterDeviceEventEXT"()
        vkRegisterDisplayEventEXT = "vkRegisterDisplayEventEXT"()
        vkGetSwapchainCounterEXT = "vkGetSwapchainCounterEXT"()
        vkGetMemoryHostPointerPropertiesEXT = "vkGetMemoryHostPointerPropertiesEXT"()
        vkAcquireFullScreenExclusiveModeEXT = "vkAcquireFullScreenExclusiveModeEXT"()
        vkReleaseFullScreenExclusiveModeEXT = "vkReleaseFullScreenExclusiveModeEXT"()
        vkGetDeviceGroupSurfacePresentModes2EXT = "vkGetDeviceGroupSurfacePresentModes2EXT"()
        vkSetHdrMetadataEXT = "vkSetHdrMetadataEXT"()
        vkResetQueryPoolEXT = "vkResetQueryPoolEXT"()
        vkGetImageDrmFormatModifierPropertiesEXT = "vkGetImageDrmFormatModifierPropertiesEXT"()
        vkCmdSetLineStippleEXT = "vkCmdSetLineStippleEXT"()
        vkCmdSetSampleLocationsEXT = "vkCmdSetSampleLocationsEXT"()
        vkCmdBindTransformFeedbackBuffersEXT = "vkCmdBindTransformFeedbackBuffersEXT"()
        vkCmdBeginTransformFeedbackEXT = "vkCmdBeginTransformFeedbackEXT"()
        vkCmdEndTransformFeedbackEXT = "vkCmdEndTransformFeedbackEXT"()
        vkCmdBeginQueryIndexedEXT = "vkCmdBeginQueryIndexedEXT"()
        vkCmdEndQueryIndexedEXT = "vkCmdEndQueryIndexedEXT"()
        vkCmdDrawIndirectByteCountEXT = "vkCmdDrawIndirectByteCountEXT"()
        vkCreateValidationCacheEXT = "vkCreateValidationCacheEXT"()
        vkDestroyValidationCacheEXT = "vkDestroyValidationCacheEXT"()
        vkMergeValidationCachesEXT = "vkMergeValidationCachesEXT"()
        vkGetValidationCacheDataEXT = "vkGetValidationCacheDataEXT"()
        vkGetRefreshCycleDurationGOOGLE = "vkGetRefreshCycleDurationGOOGLE"()
        vkGetPastPresentationTimingGOOGLE = "vkGetPastPresentationTimingGOOGLE"()
        vkInitializePerformanceApiINTEL = "vkInitializePerformanceApiINTEL"()
        vkUninitializePerformanceApiINTEL = "vkUninitializePerformanceApiINTEL"()
        vkCmdSetPerformanceMarkerINTEL = "vkCmdSetPerformanceMarkerINTEL"()
        vkCmdSetPerformanceStreamMarkerINTEL = "vkCmdSetPerformanceStreamMarkerINTEL"()
        vkCmdSetPerformanceOverrideINTEL = "vkCmdSetPerformanceOverrideINTEL"()
        vkAcquirePerformanceConfigurationINTEL = "vkAcquirePerformanceConfigurationINTEL"()
        vkReleasePerformanceConfigurationINTEL = "vkReleasePerformanceConfigurationINTEL"()
        vkQueueSetPerformanceConfigurationINTEL = "vkQueueSetPerformanceConfigurationINTEL"()
        vkGetPerformanceParameterINTEL = "vkGetPerformanceParameterINTEL"()
        vkBindBufferMemory2KHR = "vkBindBufferMemory2KHR"()
        vkBindImageMemory2KHR = "vkBindImageMemory2KHR"()
        vkCreateRenderPass2KHR = "vkCreateRenderPass2KHR"()
        vkCmdBeginRenderPass2KHR = "vkCmdBeginRenderPass2KHR"()
        vkCmdNextSubpass2KHR = "vkCmdNextSubpass2KHR"()
        vkCmdEndRenderPass2KHR = "vkCmdEndRenderPass2KHR"()
        vkCreateDescriptorUpdateTemplateKHR = "vkCreateDescriptorUpdateTemplateKHR"()
        vkDestroyDescriptorUpdateTemplateKHR = "vkDestroyDescriptorUpdateTemplateKHR"()
        vkUpdateDescriptorSetWithTemplateKHR = "vkUpdateDescriptorSetWithTemplateKHR"()
        vkCmdPushDescriptorSetWithTemplateKHR = "vkCmdPushDescriptorSetWithTemplateKHR"()
        vkGetDeviceGroupPeerMemoryFeaturesKHR = "vkGetDeviceGroupPeerMemoryFeaturesKHR"()
        vkCmdSetDeviceMaskKHR = "vkCmdSetDeviceMaskKHR"()
        vkCmdDispatchBaseKHR = "vkCmdDispatchBaseKHR"()
        vkGetDeviceGroupPresentCapabilitiesKHR = "vkGetDeviceGroupPresentCapabilitiesKHR"()
        vkGetDeviceGroupSurfacePresentModesKHR = "vkGetDeviceGroupSurfacePresentModesKHR"()
        vkAcquireNextImage2KHR = "vkAcquireNextImage2KHR"()
        vkCreateSharedSwapchainsKHR = "vkCreateSharedSwapchainsKHR"()
        vkCmdDrawIndirectCountKHR = "vkCmdDrawIndirectCountKHR"()
        vkCmdDrawIndexedIndirectCountKHR = "vkCmdDrawIndexedIndirectCountKHR"()
        vkImportFenceFdKHR = "vkImportFenceFdKHR"()
        vkGetFenceFdKHR = "vkGetFenceFdKHR"()
        vkImportFenceWin32HandleKHR = "vkImportFenceWin32HandleKHR"()
        vkGetFenceWin32HandleKHR = "vkGetFenceWin32HandleKHR"()
        vkGetMemoryFdKHR = "vkGetMemoryFdKHR"()
        vkGetMemoryFdPropertiesKHR = "vkGetMemoryFdPropertiesKHR"()
        vkGetMemoryWin32HandleKHR = "vkGetMemoryWin32HandleKHR"()
        vkGetMemoryWin32HandlePropertiesKHR = "vkGetMemoryWin32HandlePropertiesKHR"()
        vkImportSemaphoreFdKHR = "vkImportSemaphoreFdKHR"()
        vkGetSemaphoreFdKHR = "vkGetSemaphoreFdKHR"()
        vkImportSemaphoreWin32HandleKHR = "vkImportSemaphoreWin32HandleKHR"()
        vkGetSemaphoreWin32HandleKHR = "vkGetSemaphoreWin32HandleKHR"()
        vkGetImageMemoryRequirements2KHR = "vkGetImageMemoryRequirements2KHR"()
        vkGetBufferMemoryRequirements2KHR = "vkGetBufferMemoryRequirements2KHR"()
        vkGetImageSparseMemoryRequirements2KHR = "vkGetImageSparseMemoryRequirements2KHR"()
        vkTrimCommandPoolKHR = "vkTrimCommandPoolKHR"()
        vkGetDescriptorSetLayoutSupportKHR = "vkGetDescriptorSetLayoutSupportKHR"()
        vkGetPipelineExecutablePropertiesKHR = "vkGetPipelineExecutablePropertiesKHR"()
        vkGetPipelineExecutableStatisticsKHR = "vkGetPipelineExecutableStatisticsKHR"()
        vkGetPipelineExecutableInternalRepresentationsKHR = "vkGetPipelineExecutableInternalRepresentationsKHR"()
        vkCmdPushDescriptorSetKHR = "vkCmdPushDescriptorSetKHR"()
        vkCreateSamplerYcbcrConversionKHR = "vkCreateSamplerYcbcrConversionKHR"()
        vkDestroySamplerYcbcrConversionKHR = "vkDestroySamplerYcbcrConversionKHR"()
        vkGetSwapchainStatusKHR = "vkGetSwapchainStatusKHR"()
        vkCreateSwapchainKHR = "vkCreateSwapchainKHR"()
        vkDestroySwapchainKHR = "vkDestroySwapchainKHR"()
        vkGetSwapchainImagesKHR = "vkGetSwapchainImagesKHR"()
        vkAcquireNextImageKHR = "vkAcquireNextImageKHR"()
        vkQueuePresentKHR = "vkQueuePresentKHR"()
        vkCmdSetViewportWScalingNV = "vkCmdSetViewportWScalingNV"()
        vkCmdSetCheckpointNV = "vkCmdSetCheckpointNV"()
        vkGetQueueCheckpointDataNV = "vkGetQueueCheckpointDataNV"()
        vkGetMemoryWin32HandleNV = "vkGetMemoryWin32HandleNV"()
        vkCmdDrawMeshTasksNV = "vkCmdDrawMeshTasksNV"()
        vkCmdDrawMeshTasksIndirectNV = "vkCmdDrawMeshTasksIndirectNV"()
        vkCmdDrawMeshTasksIndirectCountNV = "vkCmdDrawMeshTasksIndirectCountNV"()
        vkCreateAccelerationStructureNV = "vkCreateAccelerationStructureNV"()
        vkDestroyAccelerationStructureNV = "vkDestroyAccelerationStructureNV"()
        vkGetAccelerationStructureMemoryRequirementsNV = "vkGetAccelerationStructureMemoryRequirementsNV"()
        vkBindAccelerationStructureMemoryNV = "vkBindAccelerationStructureMemoryNV"()
        vkCmdBuildAccelerationStructureNV = "vkCmdBuildAccelerationStructureNV"()
        vkCmdCopyAccelerationStructureNV = "vkCmdCopyAccelerationStructureNV"()
        vkCmdTraceRaysNV = "vkCmdTraceRaysNV"()
        vkCreateRayTracingPipelinesNV = "vkCreateRayTracingPipelinesNV"()
        vkGetRayTracingShaderGroupHandlesNV = "vkGetRayTracingShaderGroupHandlesNV"()
        vkGetAccelerationStructureHandleNV = "vkGetAccelerationStructureHandleNV"()
        vkCmdWriteAccelerationStructuresPropertiesNV = "vkCmdWriteAccelerationStructuresPropertiesNV"()
        vkCompileDeferredNV = "vkCompileDeferredNV"()
        vkCmdSetExclusiveScissorNV = "vkCmdSetExclusiveScissorNV"()
        vkCmdBindShadingRateImageNV = "vkCmdBindShadingRateImageNV"()
        vkCmdSetViewportShadingRatePaletteNV = "vkCmdSetViewportShadingRatePaletteNV"()
        vkCmdSetCoarseSampleOrderNV = "vkCmdSetCoarseSampleOrderNV"()
        vkCmdProcessCommandsNVX = "vkCmdProcessCommandsNVX"()
        vkCmdReserveSpaceForCommandsNVX = "vkCmdReserveSpaceForCommandsNVX"()
        vkCreateIndirectCommandsLayoutNVX = "vkCreateIndirectCommandsLayoutNVX"()
        vkDestroyIndirectCommandsLayoutNVX = "vkDestroyIndirectCommandsLayoutNVX"()
        vkCreateObjectTableNVX = "vkCreateObjectTableNVX"()
        vkDestroyObjectTableNVX = "vkDestroyObjectTableNVX"()
        vkRegisterObjectsNVX = "vkRegisterObjectsNVX"()
        vkUnregisterObjectsNVX = "vkUnregisterObjectsNVX"()
        vkGetImageViewHandleNVX = "vkGetImageViewHandleNVX"()
    }
}