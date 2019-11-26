package identifiers

import kool.Ptr
import org.lwjgl.system.FunctionProvider
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.vulkan.VK10
import org.lwjgl.vulkan.VK11
import java.util.*

/** Defines the capabilities of a Vulkan `VkDevice`.  */
class CapabilitiesDevice internal constructor(
    provider: FunctionProvider,
    capsInstance: CapabilitiesInstance,
    ext: Set<String>
) {
    // VK10
//    val vkGetDeviceProcAddr: Long
//    val vkDestroyDevice: Long
    val vkGetDeviceQueue: Long
    val vkQueueSubmit: Long
    val vkQueueWaitIdle: Long
    //    val vkDeviceWaitIdle: Long
    val vkAllocateMemory: Long
    //    val vkFreeMemory: Long
    val vkMapMemory: Long
    val vkUnmapMemory: Long
    //    val vkFlushMappedMemoryRanges: Long
//    val vkInvalidateMappedMemoryRanges: Long
//    val vkGetDeviceMemoryCommitment: Long
    val vkBindBufferMemory: Long
    //    val vkBindImageMemory: Long
    val vkGetBufferMemoryRequirements: Long
    //    val vkGetImageMemoryRequirements: Long
//    val vkGetImageSparseMemoryRequirements: Long
//    val vkQueueBindSparse: Long
//    val vkCreateFence: Long
//    val vkDestroyFence: Long
//    val vkResetFences: Long
//    val vkGetFenceStatus: Long
//    val vkWaitForFences: Long
    val vkCreateSemaphore: Long
    val vkDestroySemaphore: Long
    //    val vkCreateEvent: Long
//    val vkDestroyEvent: Long
//    val vkGetEventStatus: Long
//    val vkSetEvent: Long
//    val vkResetEvent: Long
//    val vkCreateQueryPool: Long
//    val vkDestroyQueryPool: Long
//    val vkGetQueryPoolResults: Long
    val vkCreateBuffer: Long
    //    val vkDestroyBuffer: Long
//    val vkCreateBufferView: Long
//    val vkDestroyBufferView: Long
//    val vkCreateImage: Long
//    val vkDestroyImage: Long
//    val vkGetImageSubresourceLayout: Long
    val vkCreateImageView: Long
    //    val vkDestroyImageView: Long
    val vkCreateShaderModule: Long
    //    val vkDestroyShaderModule: Long
//    val vkCreatePipelineCache: Long
//    val vkDestroyPipelineCache: Long
//    val vkGetPipelineCacheData: Long
//    val vkMergePipelineCaches: Long
    val vkCreateGraphicsPipelines: Long
    //    val vkCreateComputePipelines: Long
//    val vkDestroyPipeline: Long
    val vkCreatePipelineLayout: Long
    //    val vkDestroyPipelineLayout: Long
//    val vkCreateSampler: Long
//    val vkDestroySampler: Long
//    val vkCreateDescriptorSetLayout: Long
//    val vkDestroyDescriptorSetLayout: Long
//    val vkCreateDescriptorPool: Long
//    val vkDestroyDescriptorPool: Long
//    val vkResetDescriptorPool: Long
//    val vkAllocateDescriptorSets: Long
//    val vkFreeDescriptorSets: Long
//    val vkUpdateDescriptorSets: Long
    val vkCreateFramebuffer: Long
    val vkDestroyFramebuffer: Long
    val vkCreateRenderPass: Long
    //    val vkDestroyRenderPass: Long
//    val vkGetRenderAreaGranularity: Long
    val vkCreateCommandPool: Long
    //    val vkDestroyCommandPool: Long
    val vkResetCommandPool: Long
    val vkAllocateCommandBuffers: Long
    //    val vkFreeCommandBuffers: Long
    val vkBeginCommandBuffer: Long
    val vkEndCommandBuffer: Long
    //    val vkResetCommandBuffer: Long
    val vkCmdBindPipeline: Long
    val vkCmdSetViewport: Long
    val vkCmdSetScissor: Long
    //    val vkCmdSetLineWidth: Long
//    val vkCmdSetDepthBias: Long
//    val vkCmdSetBlendConstants: Long
//    val vkCmdSetDepthBounds: Long
//    val vkCmdSetStencilCompareMask: Long
//    val vkCmdSetStencilWriteMask: Long
//    val vkCmdSetStencilReference: Long
//    val vkCmdBindDescriptorSets: Long
//    val vkCmdBindIndexBuffer: Long
    val vkCmdBindVertexBuffers: Long
    val vkCmdDraw: Long
    //    val vkCmdDrawIndexed: Long
//    val vkCmdDrawIndirect: Long
//    val vkCmdDrawIndexedIndirect: Long
//    val vkCmdDispatch: Long
//    val vkCmdDispatchIndirect: Long
//    val vkCmdCopyBuffer: Long
//    val vkCmdCopyImage: Long
//    val vkCmdBlitImage: Long
//    val vkCmdCopyBufferToImage: Long
//    val vkCmdCopyImageToBuffer: Long
//    val vkCmdUpdateBuffer: Long
//    val vkCmdFillBuffer: Long
//    val vkCmdClearColorImage: Long
//    val vkCmdClearDepthStencilImage: Long
//    val vkCmdClearAttachments: Long
//    val vkCmdResolveImage: Long
//    val vkCmdSetEvent: Long
//    val vkCmdResetEvent: Long
//    val vkCmdWaitEvents: Long
//    val vkCmdPipelineBarrier: Long
//    val vkCmdBeginQuery: Long
//    val vkCmdEndQuery: Long
//    val vkCmdResetQueryPool: Long
//    val vkCmdWriteTimestamp: Long
//    val vkCmdCopyQueryPoolResults: Long
//    val vkCmdPushConstants: Long
    val vkCmdBeginRenderPass: Long
    //    val vkCmdNextSubpass: Long
    val vkCmdEndRenderPass: Long
    //    val vkCmdExecuteCommands: Long
//    // VK11
//    val vkBindBufferMemory2: Long
//    val vkBindImageMemory2: Long
//    val vkGetDeviceGroupPeerMemoryFeatures: Long
//    val vkCmdSetDeviceMask: Long
//    val vkCmdDispatchBase: Long
//    val vkGetImageMemoryRequirements2: Long
//    val vkGetBufferMemoryRequirements2: Long
//    val vkGetImageSparseMemoryRequirements2: Long
//    val vkTrimCommandPool: Long
//    val vkGetDeviceQueue2: Long
//    val vkCreateSamplerYcbcrConversion: Long
//    val vkDestroySamplerYcbcrConversion: Long
//    val vkCreateDescriptorUpdateTemplate: Long
//    val vkDestroyDescriptorUpdateTemplate: Long
//    val vkUpdateDescriptorSetWithTemplate: Long
//    val vkGetDescriptorSetLayoutSupport: Long
//    // AMD_buffer_marker
//    val vkCmdWriteBufferMarkerAMD: Long
//    // AMD_display_native_hdr
//    val vkSetLocalDimmingAMD: Long
//    // AMD_draw_indirect_count
//    val vkCmdDrawIndirectCountAMD: Long
//    val vkCmdDrawIndexedIndirectCountAMD: Long
//    // AMD_shader_info
//    val vkGetShaderInfoAMD: Long
//    // EXT_buffer_device_address
//    val vkGetBufferDeviceAddressEXT: Long
//    // EXT_calibrated_timestamps
//    val vkGetCalibratedTimestampsEXT: Long
//    // EXT_conditional_rendering
//    val vkCmdBeginConditionalRenderingEXT: Long
//    val vkCmdEndConditionalRenderingEXT: Long
//    // EXT_debug_marker
//    val vkDebugMarkerSetObjectTagEXT: Long
//    val vkDebugMarkerSetObjectNameEXT: Long
//    val vkCmdDebugMarkerBeginEXT: Long
//    val vkCmdDebugMarkerEndEXT: Long
//    val vkCmdDebugMarkerInsertEXT: Long
//    // EXT_debug_utils
//    val vkSetDebugUtilsObjectNameEXT: Long
//    val vkSetDebugUtilsObjectTagEXT: Long
//    val vkQueueBeginDebugUtilsLabelEXT: Long
//    val vkQueueEndDebugUtilsLabelEXT: Long
//    val vkQueueInsertDebugUtilsLabelEXT: Long
//    val vkCmdBeginDebugUtilsLabelEXT: Long
//    val vkCmdEndDebugUtilsLabelEXT: Long
//    val vkCmdInsertDebugUtilsLabelEXT: Long
//    // EXT_discard_rectangles
//    val vkCmdSetDiscardRectangleEXT: Long
//    // EXT_display_control
//    val vkDisplayPowerControlEXT: Long
//    val vkRegisterDeviceEventEXT: Long
//    val vkRegisterDisplayEventEXT: Long
//    val vkGetSwapchainCounterEXT: Long
//    // EXT_external_memory_host
//    val vkGetMemoryHostPointerPropertiesEXT: Long
//    // EXT_full_screen_exclusive
//    val vkAcquireFullScreenExclusiveModeEXT: Long
//    val vkReleaseFullScreenExclusiveModeEXT: Long
//    val vkGetDeviceGroupSurfacePresentModes2EXT: Long
//    // EXT_hdr_metadata
//    val vkSetHdrMetadataEXT: Long
//    // EXT_host_query_reset
//    val vkResetQueryPoolEXT: Long
//    // EXT_image_drm_format_modifier
//    val vkGetImageDrmFormatModifierPropertiesEXT: Long
//    // EXT_line_rasterization
//    val vkCmdSetLineStippleEXT: Long
//    // EXT_sample_locations
//    val vkCmdSetSampleLocationsEXT: Long
//    // EXT_transform_feedback
//    val vkCmdBindTransformFeedbackBuffersEXT: Long
//    val vkCmdBeginTransformFeedbackEXT: Long
//    val vkCmdEndTransformFeedbackEXT: Long
//    val vkCmdBeginQueryIndexedEXT: Long
//    val vkCmdEndQueryIndexedEXT: Long
//    val vkCmdDrawIndirectByteCountEXT: Long
//    // EXT_validation_cache
//    val vkCreateValidationCacheEXT: Long
//    val vkDestroyValidationCacheEXT: Long
//    val vkMergeValidationCachesEXT: Long
//    val vkGetValidationCacheDataEXT: Long
//    // GOOGLE_display_timing
//    val vkGetRefreshCycleDurationGOOGLE: Long
//    val vkGetPastPresentationTimingGOOGLE: Long
//    // INTEL_performance_query
//    val vkInitializePerformanceApiINTEL: Long
//    val vkUninitializePerformanceApiINTEL: Long
//    val vkCmdSetPerformanceMarkerINTEL: Long
//    val vkCmdSetPerformanceStreamMarkerINTEL: Long
//    val vkCmdSetPerformanceOverrideINTEL: Long
//    val vkAcquirePerformanceConfigurationINTEL: Long
//    val vkReleasePerformanceConfigurationINTEL: Long
//    val vkQueueSetPerformanceConfigurationINTEL: Long
//    val vkGetPerformanceParameterINTEL: Long
//    // KHR_bind_memory2
//    val vkBindBufferMemory2KHR: Long
//    val vkBindImageMemory2KHR: Long
//    // KHR_create_renderpass2
//    val vkCreateRenderPass2KHR: Long
//    val vkCmdBeginRenderPass2KHR: Long
//    val vkCmdNextSubpass2KHR: Long
//    val vkCmdEndRenderPass2KHR: Long
//    // KHR_descriptor_update_template
//    val vkCreateDescriptorUpdateTemplateKHR: Long
//    val vkDestroyDescriptorUpdateTemplateKHR: Long
//    val vkUpdateDescriptorSetWithTemplateKHR: Long
//    val vkCmdPushDescriptorSetWithTemplateKHR: Long
//    // KHR_device_group
//    val vkGetDeviceGroupPeerMemoryFeaturesKHR: Long
//    val vkCmdSetDeviceMaskKHR: Long
//    val vkCmdDispatchBaseKHR: Long
//    val vkGetDeviceGroupPresentCapabilitiesKHR: Long
//    val vkGetDeviceGroupSurfacePresentModesKHR: Long
//    val vkAcquireNextImage2KHR: Long
//    // KHR_display_swapchain
//    val vkCreateSharedSwapchainsKHR: Long
//    // KHR_draw_indirect_count
//    val vkCmdDrawIndirectCountKHR: Long
//    val vkCmdDrawIndexedIndirectCountKHR: Long
//    // KHR_external_fence_fd
//    val vkImportFenceFdKHR: Long
//    val vkGetFenceFdKHR: Long
//    // KHR_external_fence_win32
//    val vkImportFenceWin32HandleKHR: Long
//    val vkGetFenceWin32HandleKHR: Long
//    // KHR_external_memory_fd
//    val vkGetMemoryFdKHR: Long
//    val vkGetMemoryFdPropertiesKHR: Long
//    // KHR_external_memory_win32
//    val vkGetMemoryWin32HandleKHR: Long
//    val vkGetMemoryWin32HandlePropertiesKHR: Long
//    // KHR_external_semaphore_fd
//    val vkImportSemaphoreFdKHR: Long
//    val vkGetSemaphoreFdKHR: Long
//    // KHR_external_semaphore_win32
//    val vkImportSemaphoreWin32HandleKHR: Long
//    val vkGetSemaphoreWin32HandleKHR: Long
//    // KHR_get_memory_requirements2
//    val vkGetImageMemoryRequirements2KHR: Long
//    val vkGetBufferMemoryRequirements2KHR: Long
//    val vkGetImageSparseMemoryRequirements2KHR: Long
//    // KHR_maintenance1
//    val vkTrimCommandPoolKHR: Long
//    // KHR_maintenance3
//    val vkGetDescriptorSetLayoutSupportKHR: Long
//    // KHR_pipeline_executable_properties
//    val vkGetPipelineExecutablePropertiesKHR: Long
//    val vkGetPipelineExecutableStatisticsKHR: Long
//    val vkGetPipelineExecutableInternalRepresentationsKHR: Long
//    // KHR_push_descriptor
//    val vkCmdPushDescriptorSetKHR: Long
//    // KHR_sampler_ycbcr_conversion
//    val vkCreateSamplerYcbcrConversionKHR: Long
//    val vkDestroySamplerYcbcrConversionKHR: Long
//    // KHR_shared_presentable_image
//    val vkGetSwapchainStatusKHR: Long
//    // KHR_swapchain
    val vkCreateSwapchainKHR: Long
    val vkDestroySwapchainKHR: Long
    val vkGetSwapchainImagesKHR: Long
    val vkAcquireNextImageKHR: Long
    val vkQueuePresentKHR: Long
//    // NV_clip_space_w_scaling
//    val vkCmdSetViewportWScalingNV: Long
//    // NV_device_diagnostic_checkpoints
//    val vkCmdSetCheckpointNV: Long
//    val vkGetQueueCheckpointDataNV: Long
//    // NV_external_memory_win32
//    val vkGetMemoryWin32HandleNV: Long
//    // NV_mesh_shader
//    val vkCmdDrawMeshTasksNV: Long
//    val vkCmdDrawMeshTasksIndirectNV: Long
//    val vkCmdDrawMeshTasksIndirectCountNV: Long
//    // NV_ray_tracing
//    val vkCreateAccelerationStructureNV: Long
//    val vkDestroyAccelerationStructureNV: Long
//    val vkGetAccelerationStructureMemoryRequirementsNV: Long
//    val vkBindAccelerationStructureMemoryNV: Long
//    val vkCmdBuildAccelerationStructureNV: Long
//    val vkCmdCopyAccelerationStructureNV: Long
//    val vkCmdTraceRaysNV: Long
//    val vkCreateRayTracingPipelinesNV: Long
//    val vkGetRayTracingShaderGroupHandlesNV: Long
//    val vkGetAccelerationStructureHandleNV: Long
//    val vkCmdWriteAccelerationStructuresPropertiesNV: Long
//    val vkCompileDeferredNV: Long
//    // NV_scissor_exclusive
//    val vkCmdSetExclusiveScissorNV: Long
//    // NV_shading_rate_image
//    val vkCmdBindShadingRateImageNV: Long
//    val vkCmdSetViewportShadingRatePaletteNV: Long
//    val vkCmdSetCoarseSampleOrderNV: Long
//    // NVX_device_generated_commands
//    val vkCmdProcessCommandsNVX: Long
//    val vkCmdReserveSpaceForCommandsNVX: Long
//    val vkCreateIndirectCommandsLayoutNVX: Long
//    val vkDestroyIndirectCommandsLayoutNVX: Long
//    val vkCreateObjectTableNVX: Long
//    val vkDestroyObjectTableNVX: Long
//    val vkRegisterObjectsNVX: Long
//    val vkUnregisterObjectsNVX: Long
//    // NVX_image_view_handle
//    val vkGetImageViewHandleNVX: Long
    /** The Vulkan API version number.  */
    val apiVersion: Int
    /** When true, [VK10] is supported.  */
    val Vulkan10: Boolean
    /** When true, [VK11] is supported.  */
    val Vulkan11: Boolean

    /** When true, [AMDBufferMarker] is supported.  */
//    val VK_AMD_buffer_marker: Boolean
//    /** When true, [AMDDeviceCoherentMemory] is supported.  */
//    val VK_AMD_device_coherent_memory: Boolean
//    /** When true, [AMDDisplayNativeHdr] is supported.  */
//    val VK_AMD_display_native_hdr: Boolean
//    /** When true, [AMDDrawIndirectCount] is supported.  */
//    val VK_AMD_draw_indirect_count: Boolean
//    /** When true, [AMDGCNShader] is supported.  */
//    val VK_AMD_gcn_shader: Boolean
//    /** When true, [AMDGPUShaderHalfFloat] is supported.  */
//    val VK_AMD_gpu_shader_half_float: Boolean
//    /** When true, [AMDGPUShaderInt16] is supported.  */
//    val VK_AMD_gpu_shader_int16: Boolean
//    /** When true, [AMDMemoryOverallocationBehavior] is supported.  */
//    val VK_AMD_memory_overallocation_behavior: Boolean
//    /** When true, [AMDMixedAttachmentSamples] is supported.  */
//    val VK_AMD_mixed_attachment_samples: Boolean
//    /** When true, [AMDNegativeViewportHeight] is supported.  */
//    val VK_AMD_negative_viewport_height: Boolean
//    /** When true, [AMDPipelineCompilerControl] is supported.  */
//    val VK_AMD_pipeline_compiler_control: Boolean
//    /** When true, [AMDRasterizationOrder] is supported.  */
//    val VK_AMD_rasterization_order: Boolean
//    /** When true, [AMDShaderBallot] is supported.  */
//    val VK_AMD_shader_ballot: Boolean
//    /** When true, [AMDShaderCoreProperties] is supported.  */
//    val VK_AMD_shader_core_properties: Boolean
//    /** When true, [AMDShaderCoreProperties2] is supported.  */
//    val VK_AMD_shader_core_properties2: Boolean
//    /** When true, [AMDShaderExplicitVertexParameter] is supported.  */
//    val VK_AMD_shader_explicit_vertex_parameter: Boolean
//    /** When true, [AMDShaderFragmentMask] is supported.  */
//    val VK_AMD_shader_fragment_mask: Boolean
//    /** When true, [AMDShaderImageLoadStoreLod] is supported.  */
//    val VK_AMD_shader_image_load_store_lod: Boolean
//    /** When true, [AMDShaderInfo] is supported.  */
//    val VK_AMD_shader_info: Boolean
//    /** When true, [AMDShaderTrinaryMinmax] is supported.  */
//    val VK_AMD_shader_trinary_minmax: Boolean
//    /** When true, [AMDTextureGatherBiasLod] is supported.  */
//    val VK_AMD_texture_gather_bias_lod: Boolean
//    /** When true, [EXTAstcDecodeMode] is supported.  */
//    val VK_EXT_astc_decode_mode: Boolean
//    /** When true, [EXTBlendOperationAdvanced] is supported.  */
//    val VK_EXT_blend_operation_advanced: Boolean
//    /** When true, [EXTBufferDeviceAddress] is supported.  */
//    val VK_EXT_buffer_device_address: Boolean
//    /** When true, [EXTCalibratedTimestamps] is supported.  */
//    val VK_EXT_calibrated_timestamps: Boolean
//    /** When true, [EXTConditionalRendering] is supported.  */
//    val VK_EXT_conditional_rendering: Boolean
//    /** When true, [EXTConservativeRasterization] is supported.  */
//    val VK_EXT_conservative_rasterization: Boolean
//    /** When true, [EXTDebugMarker] is supported.  */
//    val VK_EXT_debug_marker: Boolean
//    /** When true, [EXTDepthClipEnable] is supported.  */
//    val VK_EXT_depth_clip_enable: Boolean
//    /** When true, [EXTDepthRangeUnrestricted] is supported.  */
//    val VK_EXT_depth_range_unrestricted: Boolean
//    /** When true, [EXTDescriptorIndexing] is supported.  */
//    val VK_EXT_descriptor_indexing: Boolean
//    /** When true, [EXTDiscardRectangles] is supported.  */
//    val VK_EXT_discard_rectangles: Boolean
//    /** When true, [EXTDisplayControl] is supported.  */
//    val VK_EXT_display_control: Boolean
//    /** When true, [EXTExternalMemoryDmaBuf] is supported.  */
//    val VK_EXT_external_memory_dma_buf: Boolean
//    /** When true, [EXTExternalMemoryHost] is supported.  */
//    val VK_EXT_external_memory_host: Boolean
//    /** When true, [EXTFilterCubic] is supported.  */
//    val VK_EXT_filter_cubic: Boolean
//    /** When true, [EXTFragmentDensityMap] is supported.  */
//    val VK_EXT_fragment_density_map: Boolean
//    /** When true, [EXTFragmentShaderInterlock] is supported.  */
//    val VK_EXT_fragment_shader_interlock: Boolean
//    /** When true, [EXTFullScreenExclusive] is supported.  */
//    val VK_EXT_full_screen_exclusive: Boolean
//    /** When true, [EXTGlobalPriority] is supported.  */
//    val VK_EXT_global_priority: Boolean
//    /** When true, [EXTHdrMetadata] is supported.  */
//    val VK_EXT_hdr_metadata: Boolean
//    /** When true, [EXTHostQueryReset] is supported.  */
//    val VK_EXT_host_query_reset: Boolean
//    /** When true, [EXTImageDrmFormatModifier] is supported.  */
//    val VK_EXT_image_drm_format_modifier: Boolean
//    /** When true, [EXTIndexTypeUint8] is supported.  */
//    val VK_EXT_index_type_uint8: Boolean
//    /** When true, [EXTInlineUniformBlock] is supported.  */
//    val VK_EXT_inline_uniform_block: Boolean
//    /** When true, [EXTLineRasterization] is supported.  */
//    val VK_EXT_line_rasterization: Boolean
//    /** When true, [EXTMemoryBudget] is supported.  */
//    val VK_EXT_memory_budget: Boolean
//    /** When true, [EXTMemoryPriority] is supported.  */
//    val VK_EXT_memory_priority: Boolean
//    /** When true, [EXTPciBusInfo] is supported.  */
//    val VK_EXT_pci_bus_info: Boolean
//    /** When true, [EXTPipelineCreationFeedback] is supported.  */
//    val VK_EXT_pipeline_creation_feedback: Boolean
//    /** When true, [EXTPostDepthCoverage] is supported.  */
//    val VK_EXT_post_depth_coverage: Boolean
//    /** When true, [EXTQueueFamilyForeign] is supported.  */
//    val VK_EXT_queue_family_foreign: Boolean
//    /** When true, [EXTSampleLocations] is supported.  */
//    val VK_EXT_sample_locations: Boolean
//    /** When true, [EXTSamplerFilterMinmax] is supported.  */
//    val VK_EXT_sampler_filter_minmax: Boolean
//    /** When true, [EXTScalarBlockLayout] is supported.  */
//    val VK_EXT_scalar_block_layout: Boolean
//    /** When true, [EXTSeparateStencilUsage] is supported.  */
//    val VK_EXT_separate_stencil_usage: Boolean
//    /** When true, [EXTShaderDemoteToHelperInvocation] is supported.  */
//    val VK_EXT_shader_demote_to_helper_invocation: Boolean
//    /** When true, [EXTShaderStencilExport] is supported.  */
//    val VK_EXT_shader_stencil_export: Boolean
//    /** When true, [EXTShaderSubgroupBallot] is supported.  */
//    val VK_EXT_shader_subgroup_ballot: Boolean
//    /** When true, [EXTShaderSubgroupVote] is supported.  */
//    val VK_EXT_shader_subgroup_vote: Boolean
//    /** When true, [EXTShaderViewportIndexLayer] is supported.  */
//    val VK_EXT_shader_viewport_index_layer: Boolean
//    /** When true, [EXTSubgroupSizeControl] is supported.  */
//    val VK_EXT_subgroup_size_control: Boolean
//    /** When true, [EXTTexelBufferAlignment] is supported.  */
//    val VK_EXT_texel_buffer_alignment: Boolean
//    /** When true, [EXTTextureCompressionAstcHdr] is supported.  */
//    val VK_EXT_texture_compression_astc_hdr: Boolean
//    /** When true, [EXTTransformFeedback] is supported.  */
//    val VK_EXT_transform_feedback: Boolean
//    /** When true, [EXTValidationCache] is supported.  */
//    val VK_EXT_validation_cache: Boolean
//    /** When true, [EXTVertexAttributeDivisor] is supported.  */
//    val VK_EXT_vertex_attribute_divisor: Boolean
//    /** When true, [EXTYcbcrImageArrays] is supported.  */
//    val VK_EXT_ycbcr_image_arrays: Boolean
//    /** When true, [GOOGLEDecorateString] is supported.  */
//    val VK_GOOGLE_decorate_string: Boolean
//    /** When true, [GOOGLEDisplayTiming] is supported.  */
//    val VK_GOOGLE_display_timing: Boolean
//    /** When true, [GOOGLEHlslFunctionality1] is supported.  */
//    val VK_GOOGLE_hlsl_functionality1: Boolean
//    /** When true, [IMGFilterCubic] is supported.  */
//    val VK_IMG_filter_cubic: Boolean
//    /** When true, [IMGFormatPVRTC] is supported.  */
//    val VK_IMG_format_pvrtc: Boolean
//    /** When true, [INTELPerformanceQuery] is supported.  */
//    val VK_INTEL_performance_query: Boolean
//    /** When true, [INTELShaderIntegerFunctions2] is supported.  */
//    val VK_INTEL_shader_integer_functions2: Boolean
//    /** When true, [KHR16bitStorage] is supported.  */
//    val VK_KHR_16bit_storage: Boolean
//    /** When true, [KHR8bitStorage] is supported.  */
//    val VK_KHR_8bit_storage: Boolean
//    /** When true, [KHRBindMemory2] is supported.  */
//    val VK_KHR_bind_memory2: Boolean
//    /** When true, [KHRCreateRenderpass2] is supported.  */
//    val VK_KHR_create_renderpass2: Boolean
//    /** When true, [KHRDedicatedAllocation] is supported.  */
//    val VK_KHR_dedicated_allocation: Boolean
//    /** When true, [KHRDepthStencilResolve] is supported.  */
//    val VK_KHR_depth_stencil_resolve: Boolean
//    /** When true, [KHRDescriptorUpdateTemplate] is supported.  */
//    val VK_KHR_descriptor_update_template: Boolean
//    /** When true, [KHRDeviceGroup] is supported.  */
//    val VK_KHR_device_group: Boolean
//    /** When true, [KHRDisplaySwapchain] is supported.  */
//    val VK_KHR_display_swapchain: Boolean
//    /** When true, [KHRDrawIndirectCount] is supported.  */
//    val VK_KHR_draw_indirect_count: Boolean
//    /** When true, [KHRDriverProperties] is supported.  */
//    val VK_KHR_driver_properties: Boolean
//    /** When true, [KHRExternalFence] is supported.  */
//    val VK_KHR_external_fence: Boolean
//    /** When true, [KHRExternalFenceFd] is supported.  */
//    val VK_KHR_external_fence_fd: Boolean
//    /** When true, [KHRExternalFenceWin32] is supported.  */
//    val VK_KHR_external_fence_win32: Boolean
//    /** When true, [KHRExternalMemory] is supported.  */
//    val VK_KHR_external_memory: Boolean
//    /** When true, [KHRExternalMemoryFd] is supported.  */
//    val VK_KHR_external_memory_fd: Boolean
//    /** When true, [KHRExternalMemoryWin32] is supported.  */
//    val VK_KHR_external_memory_win32: Boolean
//    /** When true, [KHRExternalSemaphore] is supported.  */
//    val VK_KHR_external_semaphore: Boolean
//    /** When true, [KHRExternalSemaphoreFd] is supported.  */
//    val VK_KHR_external_semaphore_fd: Boolean
//    /** When true, [KHRExternalSemaphoreWin32] is supported.  */
//    val VK_KHR_external_semaphore_win32: Boolean
//    /** When true, [KHRGetMemoryRequirements2] is supported.  */
//    val VK_KHR_get_memory_requirements2: Boolean
//    /** When true, [KHRImageFormatList] is supported.  */
//    val VK_KHR_image_format_list: Boolean
//    /** When true, [KHRImagelessFramebuffer] is supported.  */
//    val VK_KHR_imageless_framebuffer: Boolean
//    /** When true, [KHRIncrementalPresent] is supported.  */
//    val VK_KHR_incremental_present: Boolean
//    /** When true, [KHRMaintenance1] is supported.  */
//    val VK_KHR_maintenance1: Boolean
//    /** When true, [KHRMaintenance2] is supported.  */
//    val VK_KHR_maintenance2: Boolean
//    /** When true, [KHRMaintenance3] is supported.  */
//    val VK_KHR_maintenance3: Boolean
//    /** When true, [KHRMultiview] is supported.  */
//    val VK_KHR_multiview: Boolean
//    /** When true, [KHRPipelineExecutableProperties] is supported.  */
//    val VK_KHR_pipeline_executable_properties: Boolean
//    /** When true, [KHRPushDescriptor] is supported.  */
//    val VK_KHR_push_descriptor: Boolean
//    /** When true, [KHRRelaxedBlockLayout] is supported.  */
//    val VK_KHR_relaxed_block_layout: Boolean
//    /** When true, [KHRSamplerMirrorClampToEdge] is supported.  */
//    val VK_KHR_sampler_mirror_clamp_to_edge: Boolean
//    /** When true, [KHRSamplerYcbcrConversion] is supported.  */
//    val VK_KHR_sampler_ycbcr_conversion: Boolean
//    /** When true, [KHRShaderAtomicInt64] is supported.  */
//    val VK_KHR_shader_atomic_int64: Boolean
//    /** When true, [KHRShaderDrawParameters] is supported.  */
//    val VK_KHR_shader_draw_parameters: Boolean
//    /** When true, [KHRShaderFloat16Int8] is supported.  */
//    val VK_KHR_shader_float16_int8: Boolean
//    /** When true, [KHRShaderFloatControls] is supported.  */
//    val VK_KHR_shader_float_controls: Boolean
//    /** When true, [KHRSharedPresentableImage] is supported.  */
//    val VK_KHR_shared_presentable_image: Boolean
//    /** When true, [KHRStorageBufferStorageClass] is supported.  */
//    val VK_KHR_storage_buffer_storage_class: Boolean
//    /** When true, [KHRSwapchain] is supported.  */
    val VK_KHR_swapchain: Boolean
//    /** When true, [KHRSwapchainMutableFormat] is supported.  */
//    val VK_KHR_swapchain_mutable_format: Boolean
//    /** When true, [KHRUniformBufferStandardLayout] is supported.  */
//    val VK_KHR_uniform_buffer_standard_layout: Boolean
//    /** When true, [KHRVariablePointers] is supported.  */
//    val VK_KHR_variable_pointers: Boolean
//    /** When true, [KHRVulkanMemoryModel] is supported.  */
//    val VK_KHR_vulkan_memory_model: Boolean
//    /** When true, [KHRWin32KeyedMutex] is supported.  */
//    val VK_KHR_win32_keyed_mutex: Boolean
//    /** When true, [NVClipSpaceWScaling] is supported.  */
//    val VK_NV_clip_space_w_scaling: Boolean
//    /** When true, [NVComputeShaderDerivatives] is supported.  */
//    val VK_NV_compute_shader_derivatives: Boolean
//    /** When true, [NVCooperativeMatrix] is supported.  */
//    val VK_NV_cooperative_matrix: Boolean
//    /** When true, [NVCornerSampledImage] is supported.  */
//    val VK_NV_corner_sampled_image: Boolean
//    /** When true, [NVCoverageReductionMode] is supported.  */
//    val VK_NV_coverage_reduction_mode: Boolean
//    /** When true, [NVDedicatedAllocation] is supported.  */
//    val VK_NV_dedicated_allocation: Boolean
//    /** When true, [NVDedicatedAllocationImageAliasing] is supported.  */
//    val VK_NV_dedicated_allocation_image_aliasing: Boolean
//    /** When true, [NVDeviceDiagnosticCheckpoints] is supported.  */
//    val VK_NV_device_diagnostic_checkpoints: Boolean
//    /** When true, [NVExternalMemory] is supported.  */
//    val VK_NV_external_memory: Boolean
//    /** When true, [NVExternalMemoryWin32] is supported.  */
//    val VK_NV_external_memory_win32: Boolean
//    /** When true, [NVFillRectangle] is supported.  */
//    val VK_NV_fill_rectangle: Boolean
//    /** When true, [NVFragmentCoverageToColor] is supported.  */
//    val VK_NV_fragment_coverage_to_color: Boolean
//    /** When true, [NVFragmentShaderBarycentric] is supported.  */
//    val VK_NV_fragment_shader_barycentric: Boolean
//    /** When true, [NVFramebufferMixedSamples] is supported.  */
//    val VK_NV_framebuffer_mixed_samples: Boolean
//    /** When true, [NVGeometryShaderPassthrough] is supported.  */
//    val VK_NV_geometry_shader_passthrough: Boolean
//    /** When true, [NVGLSLShader] is supported.  */
//    val VK_NV_glsl_shader: Boolean
//    /** When true, [NVMeshShader] is supported.  */
//    val VK_NV_mesh_shader: Boolean
//    /** When true, [NVRayTracing] is supported.  */
//    val VK_NV_ray_tracing: Boolean
//    /** When true, [NVRepresentativeFragmentTest] is supported.  */
//    val VK_NV_representative_fragment_test: Boolean
//    /** When true, [NVSampleMaskOverrideCoverage] is supported.  */
//    val VK_NV_sample_mask_override_coverage: Boolean
//    /** When true, [NVScissorExclusive] is supported.  */
//    val VK_NV_scissor_exclusive: Boolean
//    /** When true, [NVShaderImageFootprint] is supported.  */
//    val VK_NV_shader_image_footprint: Boolean
//    /** When true, [NVShaderSmBuiltins] is supported.  */
//    val VK_NV_shader_sm_builtins: Boolean
//    /** When true, [NVShaderSubgroupPartitioned] is supported.  */
//    val VK_NV_shader_subgroup_partitioned: Boolean
//    /** When true, [NVShadingRateImage] is supported.  */
//    val VK_NV_shading_rate_image: Boolean
//    /** When true, [NVViewportArray2] is supported.  */
//    val VK_NV_viewport_array2: Boolean
//    /** When true, [NVViewportSwizzle] is supported.  */
//    val VK_NV_viewport_swizzle: Boolean
//    /** When true, [NVWin32KeyedMutex] is supported.  */
//    val VK_NV_win32_keyed_mutex: Boolean
//    /** When true, [NVXDeviceGeneratedCommands] is supported.  */
//    val VK_NVX_device_generated_commands: Boolean
//    /** When true, [NVXImageViewHandle] is supported.  */
//    val VK_NVX_image_view_handle: Boolean
//    /** When true, [NVXMultiviewPerViewAttributes] is supported.  */
//    val VK_NVX_multiview_per_view_attributes: Boolean

    init {
        apiVersion = capsInstance.apiVersion
        val caps = HashMap<String, Ptr>(274)
        operator fun String.invoke(): Ptr = caps[this] ?: NULL
        Vulkan10 = provider.checkCapsDeviceVK10(caps, ext)
        Vulkan11 = provider.checkCapsDeviceVK11(caps, ext)
//        VK_AMD_buffer_marker = AMDBufferMarker.checkCapsDevice(provider, caps, ext)
//        VK_AMD_device_coherent_memory = ext.contains("VK_AMD_device_coherent_memory")
//        VK_AMD_display_native_hdr = AMDDisplayNativeHdr.checkCapsDevice(provider, caps, ext)
//        VK_AMD_draw_indirect_count = AMDDrawIndirectCount.checkCapsDevice(provider, caps, ext)
//        VK_AMD_gcn_shader = ext.contains("VK_AMD_gcn_shader")
//        VK_AMD_gpu_shader_half_float = ext.contains("VK_AMD_gpu_shader_half_float")
//        VK_AMD_gpu_shader_int16 = ext.contains("VK_AMD_gpu_shader_int16")
//        VK_AMD_memory_overallocation_behavior = ext.contains("VK_AMD_memory_overallocation_behavior")
//        VK_AMD_mixed_attachment_samples = ext.contains("VK_AMD_mixed_attachment_samples")
//        VK_AMD_negative_viewport_height = ext.contains("VK_AMD_negative_viewport_height")
//        VK_AMD_pipeline_compiler_control = ext.contains("VK_AMD_pipeline_compiler_control")
//        VK_AMD_rasterization_order = ext.contains("VK_AMD_rasterization_order")
//        VK_AMD_shader_ballot = ext.contains("VK_AMD_shader_ballot")
//        VK_AMD_shader_core_properties = ext.contains("VK_AMD_shader_core_properties")
//        VK_AMD_shader_core_properties2 = ext.contains("VK_AMD_shader_core_properties2")
//        VK_AMD_shader_explicit_vertex_parameter = ext.contains("VK_AMD_shader_explicit_vertex_parameter")
//        VK_AMD_shader_fragment_mask = ext.contains("VK_AMD_shader_fragment_mask")
//        VK_AMD_shader_image_load_store_lod = ext.contains("VK_AMD_shader_image_load_store_lod")
//        VK_AMD_shader_info = AMDShaderInfo.checkCapsDevice(provider, caps, ext)
//        VK_AMD_shader_trinary_minmax = ext.contains("VK_AMD_shader_trinary_minmax")
//        VK_AMD_texture_gather_bias_lod = ext.contains("VK_AMD_texture_gather_bias_lod")
//        VK_EXT_astc_decode_mode = ext.contains("VK_EXT_astc_decode_mode")
//        VK_EXT_blend_operation_advanced = ext.contains("VK_EXT_blend_operation_advanced")
//        VK_EXT_buffer_device_address = EXTBufferDeviceAddress.checkCapsDevice(provider, caps, ext)
//        VK_EXT_calibrated_timestamps = EXTCalibratedTimestamps.checkCapsDevice(provider, caps, ext)
//        VK_EXT_conditional_rendering = EXTConditionalRendering.checkCapsDevice(provider, caps, ext)
//        VK_EXT_conservative_rasterization = ext.contains("VK_EXT_conservative_rasterization")
//        VK_EXT_debug_marker = EXTDebugMarker.checkCapsDevice(provider, caps, ext)
//        EXTDebugUtils.checkCapsDevice(provider, caps, capsInstance)
//        VK_EXT_depth_clip_enable = ext.contains("VK_EXT_depth_clip_enable")
//        VK_EXT_depth_range_unrestricted = ext.contains("VK_EXT_depth_range_unrestricted")
//        VK_EXT_descriptor_indexing = ext.contains("VK_EXT_descriptor_indexing")
//        VK_EXT_discard_rectangles = EXTDiscardRectangles.checkCapsDevice(provider, caps, ext)
//        VK_EXT_display_control = EXTDisplayControl.checkCapsDevice(provider, caps, ext)
//        VK_EXT_external_memory_dma_buf = ext.contains("VK_EXT_external_memory_dma_buf")
//        VK_EXT_external_memory_host = EXTExternalMemoryHost.checkCapsDevice(provider, caps, ext)
//        VK_EXT_filter_cubic = ext.contains("VK_EXT_filter_cubic")
//        VK_EXT_fragment_density_map = ext.contains("VK_EXT_fragment_density_map")
//        VK_EXT_fragment_shader_interlock = ext.contains("VK_EXT_fragment_shader_interlock")
//        VK_EXT_full_screen_exclusive = EXTFullScreenExclusive.checkCapsDevice(provider, caps, ext)
//        VK_EXT_global_priority = ext.contains("VK_EXT_global_priority")
//        VK_EXT_hdr_metadata = EXTHdrMetadata.checkCapsDevice(provider, caps, ext)
//        VK_EXT_host_query_reset = EXTHostQueryReset.checkCapsDevice(provider, caps, ext)
//        VK_EXT_image_drm_format_modifier = EXTImageDrmFormatModifier.checkCapsDevice(provider, caps, ext)
//        VK_EXT_index_type_uint8 = ext.contains("VK_EXT_index_type_uint8")
//        VK_EXT_inline_uniform_block = ext.contains("VK_EXT_inline_uniform_block")
//        VK_EXT_line_rasterization = EXTLineRasterization.checkCapsDevice(provider, caps, ext)
//        VK_EXT_memory_budget = ext.contains("VK_EXT_memory_budget")
//        VK_EXT_memory_priority = ext.contains("VK_EXT_memory_priority")
//        VK_EXT_pci_bus_info = ext.contains("VK_EXT_pci_bus_info")
//        VK_EXT_pipeline_creation_feedback = ext.contains("VK_EXT_pipeline_creation_feedback")
//        VK_EXT_post_depth_coverage = ext.contains("VK_EXT_post_depth_coverage")
//        VK_EXT_queue_family_foreign = ext.contains("VK_EXT_queue_family_foreign")
//        VK_EXT_sample_locations = EXTSampleLocations.checkCapsDevice(provider, caps, ext)
//        VK_EXT_sampler_filter_minmax = ext.contains("VK_EXT_sampler_filter_minmax")
//        VK_EXT_scalar_block_layout = ext.contains("VK_EXT_scalar_block_layout")
//        VK_EXT_separate_stencil_usage = ext.contains("VK_EXT_separate_stencil_usage")
//        VK_EXT_shader_demote_to_helper_invocation = ext.contains("VK_EXT_shader_demote_to_helper_invocation")
//        VK_EXT_shader_stencil_export = ext.contains("VK_EXT_shader_stencil_export")
//        VK_EXT_shader_subgroup_ballot = ext.contains("VK_EXT_shader_subgroup_ballot")
//        VK_EXT_shader_subgroup_vote = ext.contains("VK_EXT_shader_subgroup_vote")
//        VK_EXT_shader_viewport_index_layer = ext.contains("VK_EXT_shader_viewport_index_layer")
//        VK_EXT_subgroup_size_control = ext.contains("VK_EXT_subgroup_size_control")
//        VK_EXT_texel_buffer_alignment = ext.contains("VK_EXT_texel_buffer_alignment")
//        VK_EXT_texture_compression_astc_hdr = ext.contains("VK_EXT_texture_compression_astc_hdr")
//        VK_EXT_transform_feedback = EXTTransformFeedback.checkCapsDevice(provider, caps, ext)
//        VK_EXT_validation_cache = EXTValidationCache.checkCapsDevice(provider, caps, ext)
//        VK_EXT_vertex_attribute_divisor = ext.contains("VK_EXT_vertex_attribute_divisor")
//        VK_EXT_ycbcr_image_arrays = ext.contains("VK_EXT_ycbcr_image_arrays")
//        VK_GOOGLE_decorate_string = ext.contains("VK_GOOGLE_decorate_string")
//        VK_GOOGLE_display_timing = GOOGLEDisplayTiming.checkCapsDevice(provider, caps, ext)
//        VK_GOOGLE_hlsl_functionality1 = ext.contains("VK_GOOGLE_hlsl_functionality1")
//        VK_IMG_filter_cubic = ext.contains("VK_IMG_filter_cubic")
//        VK_IMG_format_pvrtc = ext.contains("VK_IMG_format_pvrtc")
//        VK_INTEL_performance_query = INTELPerformanceQuery.checkCapsDevice(provider, caps, ext)
//        VK_INTEL_shader_integer_functions2 = ext.contains("VK_INTEL_shader_integer_functions2")
//        VK_KHR_16bit_storage = ext.contains("VK_KHR_16bit_storage")
//        VK_KHR_8bit_storage = ext.contains("VK_KHR_8bit_storage")
//        VK_KHR_bind_memory2 = KHRBindMemory2.checkCapsDevice(provider, caps, ext)
//        VK_KHR_create_renderpass2 = KHRCreateRenderpass2.checkCapsDevice(provider, caps, ext)
//        VK_KHR_dedicated_allocation = ext.contains("VK_KHR_dedicated_allocation")
//        VK_KHR_depth_stencil_resolve = ext.contains("VK_KHR_depth_stencil_resolve")
//        VK_KHR_descriptor_update_template = KHRDescriptorUpdateTemplate.checkCapsDevice(provider, caps, ext)
//        VK_KHR_device_group = KHRDeviceGroup.checkCapsDevice(provider, caps, ext)
//        VK_KHR_display_swapchain = KHRDisplaySwapchain.checkCapsDevice(provider, caps, ext)
//        VK_KHR_draw_indirect_count = KHRDrawIndirectCount.checkCapsDevice(provider, caps, ext)
//        VK_KHR_driver_properties = ext.contains("VK_KHR_driver_properties")
//        VK_KHR_external_fence = ext.contains("VK_KHR_external_fence")
//        VK_KHR_external_fence_fd = KHRExternalFenceFd.checkCapsDevice(provider, caps, ext)
//        VK_KHR_external_fence_win32 = KHRExternalFenceWin32.checkCapsDevice(provider, caps, ext)
//        VK_KHR_external_memory = ext.contains("VK_KHR_external_memory")
//        VK_KHR_external_memory_fd = KHRExternalMemoryFd.checkCapsDevice(provider, caps, ext)
//        VK_KHR_external_memory_win32 = KHRExternalMemoryWin32.checkCapsDevice(provider, caps, ext)
//        VK_KHR_external_semaphore = ext.contains("VK_KHR_external_semaphore")
//        VK_KHR_external_semaphore_fd = KHRExternalSemaphoreFd.checkCapsDevice(provider, caps, ext)
//        VK_KHR_external_semaphore_win32 = KHRExternalSemaphoreWin32.checkCapsDevice(provider, caps, ext)
//        VK_KHR_get_memory_requirements2 = KHRGetMemoryRequirements2.checkCapsDevice(provider, caps, ext)
//        VK_KHR_image_format_list = ext.contains("VK_KHR_image_format_list")
//        VK_KHR_imageless_framebuffer = ext.contains("VK_KHR_imageless_framebuffer")
//        VK_KHR_incremental_present = ext.contains("VK_KHR_incremental_present")
//        VK_KHR_maintenance1 = KHRMaintenance1.checkCapsDevice(provider, caps, ext)
//        VK_KHR_maintenance2 = ext.contains("VK_KHR_maintenance2")
//        VK_KHR_maintenance3 = KHRMaintenance3.checkCapsDevice(provider, caps, ext)
//        VK_KHR_multiview = ext.contains("VK_KHR_multiview")
//        VK_KHR_pipeline_executable_properties = KHRPipelineExecutableProperties.checkCapsDevice(provider, caps, ext)
//        VK_KHR_push_descriptor = KHRPushDescriptor.checkCapsDevice(provider, caps, ext)
//        VK_KHR_relaxed_block_layout = ext.contains("VK_KHR_relaxed_block_layout")
//        VK_KHR_sampler_mirror_clamp_to_edge = ext.contains("VK_KHR_sampler_mirror_clamp_to_edge")
//        VK_KHR_sampler_ycbcr_conversion = KHRSamplerYcbcrConversion.checkCapsDevice(provider, caps, ext)
//        VK_KHR_shader_atomic_int64 = ext.contains("VK_KHR_shader_atomic_int64")
//        VK_KHR_shader_draw_parameters = ext.contains("VK_KHR_shader_draw_parameters")
//        VK_KHR_shader_float16_int8 = ext.contains("VK_KHR_shader_float16_int8")
//        VK_KHR_shader_float_controls = ext.contains("VK_KHR_shader_float_controls")
//        VK_KHR_shared_presentable_image = KHRSharedPresentableImage.checkCapsDevice(provider, caps, ext)
//        VK_KHR_storage_buffer_storage_class = ext.contains("VK_KHR_storage_buffer_storage_class")
        VK_KHR_swapchain = "VK_KHR_swapchain" in ext && VK.checkExtension(
            "VK_KHR_swapchain",
            provider.isSupported("vkCreateSwapchainKHR", caps)
                    && provider.isSupported("vkDestroySwapchainKHR", caps)
                    && provider.isSupported("vkGetSwapchainImagesKHR", caps)
                    && provider.isSupported("vkAcquireNextImageKHR", caps)
                    && provider.isSupported("vkQueuePresentKHR", caps)
                    && provider.isSupported("vkGetDeviceGroupPresentCapabilitiesKHR", caps, "Vulkan11" in ext)
                    && provider.isSupported("vkGetDeviceGroupSurfacePresentModesKHR", caps, "Vulkan11" in ext)
                    && provider.isSupported("vkAcquireNextImage2KHR", caps, "Vulkan11" in ext)
        )
//        VK_KHR_swapchain_mutable_format = ext.contains("VK_KHR_swapchain_mutable_format")
//        VK_KHR_uniform_buffer_standard_layout = ext.contains("VK_KHR_uniform_buffer_standard_layout")
//        VK_KHR_variable_pointers = ext.contains("VK_KHR_variable_pointers")
//        VK_KHR_vulkan_memory_model = ext.contains("VK_KHR_vulkan_memory_model")
//        VK_KHR_win32_keyed_mutex = ext.contains("VK_KHR_win32_keyed_mutex")
//        VK_NV_clip_space_w_scaling = NVClipSpaceWScaling.checkCapsDevice(provider, caps, ext)
//        VK_NV_compute_shader_derivatives = ext.contains("VK_NV_compute_shader_derivatives")
//        VK_NV_cooperative_matrix = ext.contains("VK_NV_cooperative_matrix")
//        VK_NV_corner_sampled_image = ext.contains("VK_NV_corner_sampled_image")
//        VK_NV_coverage_reduction_mode = ext.contains("VK_NV_coverage_reduction_mode")
//        VK_NV_dedicated_allocation = ext.contains("VK_NV_dedicated_allocation")
//        VK_NV_dedicated_allocation_image_aliasing = ext.contains("VK_NV_dedicated_allocation_image_aliasing")
//        VK_NV_device_diagnostic_checkpoints = NVDeviceDiagnosticCheckpoints.checkCapsDevice(provider, caps, ext)
//        VK_NV_external_memory = ext.contains("VK_NV_external_memory")
//        VK_NV_external_memory_win32 = NVExternalMemoryWin32.checkCapsDevice(provider, caps, ext)
//        VK_NV_fill_rectangle = ext.contains("VK_NV_fill_rectangle")
//        VK_NV_fragment_coverage_to_color = ext.contains("VK_NV_fragment_coverage_to_color")
//        VK_NV_fragment_shader_barycentric = ext.contains("VK_NV_fragment_shader_barycentric")
//        VK_NV_framebuffer_mixed_samples = ext.contains("VK_NV_framebuffer_mixed_samples")
//        VK_NV_geometry_shader_passthrough = ext.contains("VK_NV_geometry_shader_passthrough")
//        VK_NV_glsl_shader = ext.contains("VK_NV_glsl_shader")
//        VK_NV_mesh_shader = NVMeshShader.checkCapsDevice(provider, caps, ext)
//        VK_NV_ray_tracing = NVRayTracing.checkCapsDevice(provider, caps, ext)
//        VK_NV_representative_fragment_test = ext.contains("VK_NV_representative_fragment_test")
//        VK_NV_sample_mask_override_coverage = ext.contains("VK_NV_sample_mask_override_coverage")
//        VK_NV_scissor_exclusive = NVScissorExclusive.checkCapsDevice(provider, caps, ext)
//        VK_NV_shader_image_footprint = ext.contains("VK_NV_shader_image_footprint")
//        VK_NV_shader_sm_builtins = ext.contains("VK_NV_shader_sm_builtins")
//        VK_NV_shader_subgroup_partitioned = ext.contains("VK_NV_shader_subgroup_partitioned")
//        VK_NV_shading_rate_image = NVShadingRateImage.checkCapsDevice(provider, caps, ext)
//        VK_NV_viewport_array2 = ext.contains("VK_NV_viewport_array2")
//        VK_NV_viewport_swizzle = ext.contains("VK_NV_viewport_swizzle")
//        VK_NV_win32_keyed_mutex = ext.contains("VK_NV_win32_keyed_mutex")
//        VK_NVX_device_generated_commands = NVXDeviceGeneratedCommands.checkCapsDevice(provider, caps, ext)
//        VK_NVX_image_view_handle = NVXImageViewHandle.checkCapsDevice(provider, caps, ext)
//        VK_NVX_multiview_per_view_attributes = ext.contains("VK_NVX_multiview_per_view_attributes")
//        vkGetDeviceProcAddr = VK.get(caps, "vkGetDeviceProcAddr")
//        vkDestroyDevice = VK.get(caps, "vkDestroyDevice")
        vkGetDeviceQueue = "vkGetDeviceQueue"()
        vkQueueSubmit = "vkQueueSubmit"()
        vkQueueWaitIdle = "vkQueueWaitIdle"()
//        vkDeviceWaitIdle = VK.get(caps, "vkDeviceWaitIdle")
        vkAllocateMemory = "vkAllocateMemory"()
//        vkFreeMemory = VK.get(caps, "vkFreeMemory")
        vkMapMemory = "vkMapMemory"()
        vkUnmapMemory = "vkUnmapMemory"()
//        vkFlushMappedMemoryRanges = VK.get(caps, "vkFlushMappedMemoryRanges")
//        vkInvalidateMappedMemoryRanges = VK.get(caps, "vkInvalidateMappedMemoryRanges")
//        vkGetDeviceMemoryCommitment = VK.get(caps, "vkGetDeviceMemoryCommitment")
        vkBindBufferMemory = "vkBindBufferMemory"()
//        vkBindImageMemory = VK.get(caps, "vkBindImageMemory")
        vkGetBufferMemoryRequirements = "vkGetBufferMemoryRequirements"()
//        vkGetImageMemoryRequirements = VK.get(caps, "vkGetImageMemoryRequirements")
//        vkGetImageSparseMemoryRequirements = VK.get(caps, "vkGetImageSparseMemoryRequirements")
//        vkQueueBindSparse = VK.get(caps, "vkQueueBindSparse")
//        vkCreateFence = VK.get(caps, "vkCreateFence")
//        vkDestroyFence = VK.get(caps, "vkDestroyFence")
//        vkResetFences = VK.get(caps, "vkResetFences")
//        vkGetFenceStatus = VK.get(caps, "vkGetFenceStatus")
//        vkWaitForFences = VK.get(caps, "vkWaitForFences")
        vkCreateSemaphore = "vkCreateSemaphore"()
        vkDestroySemaphore = "vkDestroySemaphore"()
//        vkCreateEvent = VK.get(caps, "vkCreateEvent")
//        vkDestroyEvent = VK.get(caps, "vkDestroyEvent")
//        vkGetEventStatus = VK.get(caps, "vkGetEventStatus")
//        vkSetEvent = VK.get(caps, "vkSetEvent")
//        vkResetEvent = VK.get(caps, "vkResetEvent")
//        vkCreateQueryPool = VK.get(caps, "vkCreateQueryPool")
//        vkDestroyQueryPool = VK.get(caps, "vkDestroyQueryPool")
//        vkGetQueryPoolResults = VK.get(caps, "vkGetQueryPoolResults")
        vkCreateBuffer = "vkCreateBuffer"()
//        vkDestroyBuffer = VK.get(caps, "vkDestroyBuffer")
//        vkCreateBufferView = VK.get(caps, "vkCreateBufferView")
//        vkDestroyBufferView = VK.get(caps, "vkDestroyBufferView")
//        vkCreateImage = VK.get(caps, "vkCreateImage")
//        vkDestroyImage = VK.get(caps, "vkDestroyImage")
//        vkGetImageSubresourceLayout = VK.get(caps, "vkGetImageSubresourceLayout")
        vkCreateImageView = "vkCreateImageView"()
//        vkDestroyImageView = VK.get(caps, "vkDestroyImageView")
        vkCreateShaderModule = "vkCreateShaderModule"()
//        vkDestroyShaderModule = VK.get(caps, "vkDestroyShaderModule")
//        vkCreatePipelineCache = VK.get(caps, "vkCreatePipelineCache")
//        vkDestroyPipelineCache = VK.get(caps, "vkDestroyPipelineCache")
//        vkGetPipelineCacheData = VK.get(caps, "vkGetPipelineCacheData")
//        vkMergePipelineCaches = VK.get(caps, "vkMergePipelineCaches")
        vkCreateGraphicsPipelines = "vkCreateGraphicsPipelines"()
//        vkCreateComputePipelines = VK.get(caps, "vkCreateComputePipelines")
//        vkDestroyPipeline = VK.get(caps, "vkDestroyPipeline")
        vkCreatePipelineLayout = "vkCreatePipelineLayout"()
//        vkDestroyPipelineLayout = VK.get(caps, "vkDestroyPipelineLayout")
//        vkCreateSampler = VK.get(caps, "vkCreateSampler")
//        vkDestroySampler = VK.get(caps, "vkDestroySampler")
//        vkCreateDescriptorSetLayout = VK.get(caps, "vkCreateDescriptorSetLayout")
//        vkDestroyDescriptorSetLayout = VK.get(caps, "vkDestroyDescriptorSetLayout")
//        vkCreateDescriptorPool = VK.get(caps, "vkCreateDescriptorPool")
//        vkDestroyDescriptorPool = VK.get(caps, "vkDestroyDescriptorPool")
//        vkResetDescriptorPool = VK.get(caps, "vkResetDescriptorPool")
//        vkAllocateDescriptorSets = VK.get(caps, "vkAllocateDescriptorSets")
//        vkFreeDescriptorSets = VK.get(caps, "vkFreeDescriptorSets")
//        vkUpdateDescriptorSets = VK.get(caps, "vkUpdateDescriptorSets")
        vkCreateFramebuffer = "vkCreateFramebuffer"()
        vkDestroyFramebuffer = "vkDestroyFramebuffer"()
        vkCreateRenderPass = "vkCreateRenderPass"()
//        vkDestroyRenderPass = VK.get(caps, "vkDestroyRenderPass")
//        vkGetRenderAreaGranularity = VK.get(caps, "vkGetRenderAreaGranularity")
        vkCreateCommandPool = "vkCreateCommandPool"()
//        vkDestroyCommandPool = VK.get(caps, "vkDestroyCommandPool")
        vkResetCommandPool = "vkResetCommandPool"()
        vkAllocateCommandBuffers = "vkAllocateCommandBuffers"()
//        vkFreeCommandBuffers = VK.get(caps, "vkFreeCommandBuffers")
        vkBeginCommandBuffer = "vkBeginCommandBuffer"()
        vkEndCommandBuffer = "vkEndCommandBuffer"()
//        vkResetCommandBuffer = VK.get(caps, "vkResetCommandBuffer")
        vkCmdBindPipeline = "vkCmdBindPipeline"()
        vkCmdSetViewport = "vkCmdSetViewport"()
        vkCmdSetScissor = "vkCmdSetScissor"()
//        vkCmdSetLineWidth = VK.get(caps, "vkCmdSetLineWidth")
//        vkCmdSetDepthBias = VK.get(caps, "vkCmdSetDepthBias")
//        vkCmdSetBlendConstants = VK.get(caps, "vkCmdSetBlendConstants")
//        vkCmdSetDepthBounds = VK.get(caps, "vkCmdSetDepthBounds")
//        vkCmdSetStencilCompareMask = VK.get(caps, "vkCmdSetStencilCompareMask")
//        vkCmdSetStencilWriteMask = VK.get(caps, "vkCmdSetStencilWriteMask")
//        vkCmdSetStencilReference = VK.get(caps, "vkCmdSetStencilReference")
//        vkCmdBindDescriptorSets = VK.get(caps, "vkCmdBindDescriptorSets")
//        vkCmdBindIndexBuffer = VK.get(caps, "vkCmdBindIndexBuffer")
        vkCmdBindVertexBuffers = "vkCmdBindVertexBuffers"()
        vkCmdDraw = "vkCmdDraw"()
//        vkCmdDrawIndexed = VK.get(caps, "vkCmdDrawIndexed")
//        vkCmdDrawIndirect = VK.get(caps, "vkCmdDrawIndirect")
//        vkCmdDrawIndexedIndirect = VK.get(caps, "vkCmdDrawIndexedIndirect")
//        vkCmdDispatch = VK.get(caps, "vkCmdDispatch")
//        vkCmdDispatchIndirect = VK.get(caps, "vkCmdDispatchIndirect")
//        vkCmdCopyBuffer = VK.get(caps, "vkCmdCopyBuffer")
//        vkCmdCopyImage = VK.get(caps, "vkCmdCopyImage")
//        vkCmdBlitImage = VK.get(caps, "vkCmdBlitImage")
//        vkCmdCopyBufferToImage = VK.get(caps, "vkCmdCopyBufferToImage")
//        vkCmdCopyImageToBuffer = VK.get(caps, "vkCmdCopyImageToBuffer")
//        vkCmdUpdateBuffer = VK.get(caps, "vkCmdUpdateBuffer")
//        vkCmdFillBuffer = VK.get(caps, "vkCmdFillBuffer")
//        vkCmdClearColorImage = VK.get(caps, "vkCmdClearColorImage")
//        vkCmdClearDepthStencilImage = VK.get(caps, "vkCmdClearDepthStencilImage")
//        vkCmdClearAttachments = VK.get(caps, "vkCmdClearAttachments")
//        vkCmdResolveImage = VK.get(caps, "vkCmdResolveImage")
//        vkCmdSetEvent = VK.get(caps, "vkCmdSetEvent")
//        vkCmdResetEvent = VK.get(caps, "vkCmdResetEvent")
//        vkCmdWaitEvents = VK.get(caps, "vkCmdWaitEvents")
//        vkCmdPipelineBarrier = VK.get(caps, "vkCmdPipelineBarrier")
//        vkCmdBeginQuery = VK.get(caps, "vkCmdBeginQuery")
//        vkCmdEndQuery = VK.get(caps, "vkCmdEndQuery")
//        vkCmdResetQueryPool = VK.get(caps, "vkCmdResetQueryPool")
//        vkCmdWriteTimestamp = VK.get(caps, "vkCmdWriteTimestamp")
//        vkCmdCopyQueryPoolResults = VK.get(caps, "vkCmdCopyQueryPoolResults")
//        vkCmdPushConstants = VK.get(caps, "vkCmdPushConstants")
        vkCmdBeginRenderPass = "vkCmdBeginRenderPass"()
//        vkCmdNextSubpass = VK.get(caps, "vkCmdNextSubpass")
        vkCmdEndRenderPass = "vkCmdEndRenderPass"()
//        vkCmdExecuteCommands = VK.get(caps, "vkCmdExecuteCommands")
//        vkBindBufferMemory2 = VK.get(caps, "vkBindBufferMemory2")
//        vkBindImageMemory2 = VK.get(caps, "vkBindImageMemory2")
//        vkGetDeviceGroupPeerMemoryFeatures = VK.get(caps, "vkGetDeviceGroupPeerMemoryFeatures")
//        vkCmdSetDeviceMask = VK.get(caps, "vkCmdSetDeviceMask")
//        vkCmdDispatchBase = VK.get(caps, "vkCmdDispatchBase")
//        vkGetImageMemoryRequirements2 = VK.get(caps, "vkGetImageMemoryRequirements2")
//        vkGetBufferMemoryRequirements2 = VK.get(caps, "vkGetBufferMemoryRequirements2")
//        vkGetImageSparseMemoryRequirements2 = VK.get(caps, "vkGetImageSparseMemoryRequirements2")
//        vkTrimCommandPool = VK.get(caps, "vkTrimCommandPool")
//        vkGetDeviceQueue2 = VK.get(caps, "vkGetDeviceQueue2")
//        vkCreateSamplerYcbcrConversion = VK.get(caps, "vkCreateSamplerYcbcrConversion")
//        vkDestroySamplerYcbcrConversion = VK.get(caps, "vkDestroySamplerYcbcrConversion")
//        vkCreateDescriptorUpdateTemplate = VK.get(caps, "vkCreateDescriptorUpdateTemplate")
//        vkDestroyDescriptorUpdateTemplate = VK.get(caps, "vkDestroyDescriptorUpdateTemplate")
//        vkUpdateDescriptorSetWithTemplate = VK.get(caps, "vkUpdateDescriptorSetWithTemplate")
//        vkGetDescriptorSetLayoutSupport = VK.get(caps, "vkGetDescriptorSetLayoutSupport")
//        vkCmdWriteBufferMarkerAMD = VK.get(caps, "vkCmdWriteBufferMarkerAMD")
//        vkSetLocalDimmingAMD = VK.get(caps, "vkSetLocalDimmingAMD")
//        vkCmdDrawIndirectCountAMD = VK.get(caps, "vkCmdDrawIndirectCountAMD")
//        vkCmdDrawIndexedIndirectCountAMD = VK.get(caps, "vkCmdDrawIndexedIndirectCountAMD")
//        vkGetShaderInfoAMD = VK.get(caps, "vkGetShaderInfoAMD")
//        vkGetBufferDeviceAddressEXT = VK.get(caps, "vkGetBufferDeviceAddressEXT")
//        vkGetCalibratedTimestampsEXT = VK.get(caps, "vkGetCalibratedTimestampsEXT")
//        vkCmdBeginConditionalRenderingEXT = VK.get(caps, "vkCmdBeginConditionalRenderingEXT")
//        vkCmdEndConditionalRenderingEXT = VK.get(caps, "vkCmdEndConditionalRenderingEXT")
//        vkDebugMarkerSetObjectTagEXT = VK.get(caps, "vkDebugMarkerSetObjectTagEXT")
//        vkDebugMarkerSetObjectNameEXT = VK.get(caps, "vkDebugMarkerSetObjectNameEXT")
//        vkCmdDebugMarkerBeginEXT = VK.get(caps, "vkCmdDebugMarkerBeginEXT")
//        vkCmdDebugMarkerEndEXT = VK.get(caps, "vkCmdDebugMarkerEndEXT")
//        vkCmdDebugMarkerInsertEXT = VK.get(caps, "vkCmdDebugMarkerInsertEXT")
//        vkSetDebugUtilsObjectNameEXT = VK.get(caps, "vkSetDebugUtilsObjectNameEXT")
//        vkSetDebugUtilsObjectTagEXT = VK.get(caps, "vkSetDebugUtilsObjectTagEXT")
//        vkQueueBeginDebugUtilsLabelEXT = VK.get(caps, "vkQueueBeginDebugUtilsLabelEXT")
//        vkQueueEndDebugUtilsLabelEXT = VK.get(caps, "vkQueueEndDebugUtilsLabelEXT")
//        vkQueueInsertDebugUtilsLabelEXT = VK.get(caps, "vkQueueInsertDebugUtilsLabelEXT")
//        vkCmdBeginDebugUtilsLabelEXT = VK.get(caps, "vkCmdBeginDebugUtilsLabelEXT")
//        vkCmdEndDebugUtilsLabelEXT = VK.get(caps, "vkCmdEndDebugUtilsLabelEXT")
//        vkCmdInsertDebugUtilsLabelEXT = VK.get(caps, "vkCmdInsertDebugUtilsLabelEXT")
//        vkCmdSetDiscardRectangleEXT = VK.get(caps, "vkCmdSetDiscardRectangleEXT")
//        vkDisplayPowerControlEXT = VK.get(caps, "vkDisplayPowerControlEXT")
//        vkRegisterDeviceEventEXT = VK.get(caps, "vkRegisterDeviceEventEXT")
//        vkRegisterDisplayEventEXT = VK.get(caps, "vkRegisterDisplayEventEXT")
//        vkGetSwapchainCounterEXT = VK.get(caps, "vkGetSwapchainCounterEXT")
//        vkGetMemoryHostPointerPropertiesEXT = VK.get(caps, "vkGetMemoryHostPointerPropertiesEXT")
//        vkAcquireFullScreenExclusiveModeEXT = VK.get(caps, "vkAcquireFullScreenExclusiveModeEXT")
//        vkReleaseFullScreenExclusiveModeEXT = VK.get(caps, "vkReleaseFullScreenExclusiveModeEXT")
//        vkGetDeviceGroupSurfacePresentModes2EXT =
//            VK.get(caps, "vkGetDeviceGroupSurfacePresentModes2EXT")
//        vkSetHdrMetadataEXT = VK.get(caps, "vkSetHdrMetadataEXT")
//        vkResetQueryPoolEXT = VK.get(caps, "vkResetQueryPoolEXT")
//        vkGetImageDrmFormatModifierPropertiesEXT =
//            VK.get(caps, "vkGetImageDrmFormatModifierPropertiesEXT")
//        vkCmdSetLineStippleEXT = VK.get(caps, "vkCmdSetLineStippleEXT")
//        vkCmdSetSampleLocationsEXT = VK.get(caps, "vkCmdSetSampleLocationsEXT")
//        vkCmdBindTransformFeedbackBuffersEXT = VK.get(caps, "vkCmdBindTransformFeedbackBuffersEXT")
//        vkCmdBeginTransformFeedbackEXT = VK.get(caps, "vkCmdBeginTransformFeedbackEXT")
//        vkCmdEndTransformFeedbackEXT = VK.get(caps, "vkCmdEndTransformFeedbackEXT")
//        vkCmdBeginQueryIndexedEXT = VK.get(caps, "vkCmdBeginQueryIndexedEXT")
//        vkCmdEndQueryIndexedEXT = VK.get(caps, "vkCmdEndQueryIndexedEXT")
//        vkCmdDrawIndirectByteCountEXT = VK.get(caps, "vkCmdDrawIndirectByteCountEXT")
//        vkCreateValidationCacheEXT = VK.get(caps, "vkCreateValidationCacheEXT")
//        vkDestroyValidationCacheEXT = VK.get(caps, "vkDestroyValidationCacheEXT")
//        vkMergeValidationCachesEXT = VK.get(caps, "vkMergeValidationCachesEXT")
//        vkGetValidationCacheDataEXT = VK.get(caps, "vkGetValidationCacheDataEXT")
//        vkGetRefreshCycleDurationGOOGLE = VK.get(caps, "vkGetRefreshCycleDurationGOOGLE")
//        vkGetPastPresentationTimingGOOGLE = VK.get(caps, "vkGetPastPresentationTimingGOOGLE")
//        vkInitializePerformanceApiINTEL = VK.get(caps, "vkInitializePerformanceApiINTEL")
//        vkUninitializePerformanceApiINTEL = VK.get(caps, "vkUninitializePerformanceApiINTEL")
//        vkCmdSetPerformanceMarkerINTEL = VK.get(caps, "vkCmdSetPerformanceMarkerINTEL")
//        vkCmdSetPerformanceStreamMarkerINTEL = VK.get(caps, "vkCmdSetPerformanceStreamMarkerINTEL")
//        vkCmdSetPerformanceOverrideINTEL = VK.get(caps, "vkCmdSetPerformanceOverrideINTEL")
//        vkAcquirePerformanceConfigurationINTEL = VK.get(caps, "vkAcquirePerformanceConfigurationINTEL")
//        vkReleasePerformanceConfigurationINTEL = VK.get(caps, "vkReleasePerformanceConfigurationINTEL")
//        vkQueueSetPerformanceConfigurationINTEL =
//            VK.get(caps, "vkQueueSetPerformanceConfigurationINTEL")
//        vkGetPerformanceParameterINTEL = VK.get(caps, "vkGetPerformanceParameterINTEL")
//        vkBindBufferMemory2KHR = VK.get(caps, "vkBindBufferMemory2KHR")
//        vkBindImageMemory2KHR = VK.get(caps, "vkBindImageMemory2KHR")
//        vkCreateRenderPass2KHR = VK.get(caps, "vkCreateRenderPass2KHR")
//        vkCmdBeginRenderPass2KHR = VK.get(caps, "vkCmdBeginRenderPass2KHR")
//        vkCmdNextSubpass2KHR = VK.get(caps, "vkCmdNextSubpass2KHR")
//        vkCmdEndRenderPass2KHR = VK.get(caps, "vkCmdEndRenderPass2KHR")
//        vkCreateDescriptorUpdateTemplateKHR = VK.get(caps, "vkCreateDescriptorUpdateTemplateKHR")
//        vkDestroyDescriptorUpdateTemplateKHR = VK.get(caps, "vkDestroyDescriptorUpdateTemplateKHR")
//        vkUpdateDescriptorSetWithTemplateKHR = VK.get(caps, "vkUpdateDescriptorSetWithTemplateKHR")
//        vkCmdPushDescriptorSetWithTemplateKHR = VK.get(caps, "vkCmdPushDescriptorSetWithTemplateKHR")
//        vkGetDeviceGroupPeerMemoryFeaturesKHR = VK.get(caps, "vkGetDeviceGroupPeerMemoryFeaturesKHR")
//        vkCmdSetDeviceMaskKHR = VK.get(caps, "vkCmdSetDeviceMaskKHR")
//        vkCmdDispatchBaseKHR = VK.get(caps, "vkCmdDispatchBaseKHR")
//        vkGetDeviceGroupPresentCapabilitiesKHR = VK.get(caps, "vkGetDeviceGroupPresentCapabilitiesKHR")
//        vkGetDeviceGroupSurfacePresentModesKHR = VK.get(caps, "vkGetDeviceGroupSurfacePresentModesKHR")
//        vkAcquireNextImage2KHR = VK.get(caps, "vkAcquireNextImage2KHR")
//        vkCreateSharedSwapchainsKHR = VK.get(caps, "vkCreateSharedSwapchainsKHR")
//        vkCmdDrawIndirectCountKHR = VK.get(caps, "vkCmdDrawIndirectCountKHR")
//        vkCmdDrawIndexedIndirectCountKHR = VK.get(caps, "vkCmdDrawIndexedIndirectCountKHR")
//        vkImportFenceFdKHR = VK.get(caps, "vkImportFenceFdKHR")
//        vkGetFenceFdKHR = VK.get(caps, "vkGetFenceFdKHR")
//        vkImportFenceWin32HandleKHR = VK.get(caps, "vkImportFenceWin32HandleKHR")
//        vkGetFenceWin32HandleKHR = VK.get(caps, "vkGetFenceWin32HandleKHR")
//        vkGetMemoryFdKHR = VK.get(caps, "vkGetMemoryFdKHR")
//        vkGetMemoryFdPropertiesKHR = VK.get(caps, "vkGetMemoryFdPropertiesKHR")
//        vkGetMemoryWin32HandleKHR = VK.get(caps, "vkGetMemoryWin32HandleKHR")
//        vkGetMemoryWin32HandlePropertiesKHR = VK.get(caps, "vkGetMemoryWin32HandlePropertiesKHR")
//        vkImportSemaphoreFdKHR = VK.get(caps, "vkImportSemaphoreFdKHR")
//        vkGetSemaphoreFdKHR = VK.get(caps, "vkGetSemaphoreFdKHR")
//        vkImportSemaphoreWin32HandleKHR = VK.get(caps, "vkImportSemaphoreWin32HandleKHR")
//        vkGetSemaphoreWin32HandleKHR = VK.get(caps, "vkGetSemaphoreWin32HandleKHR")
//        vkGetImageMemoryRequirements2KHR = VK.get(caps, "vkGetImageMemoryRequirements2KHR")
//        vkGetBufferMemoryRequirements2KHR = VK.get(caps, "vkGetBufferMemoryRequirements2KHR")
//        vkGetImageSparseMemoryRequirements2KHR = VK.get(caps, "vkGetImageSparseMemoryRequirements2KHR")
//        vkTrimCommandPoolKHR = VK.get(caps, "vkTrimCommandPoolKHR")
//        vkGetDescriptorSetLayoutSupportKHR = VK.get(caps, "vkGetDescriptorSetLayoutSupportKHR")
//        vkGetPipelineExecutablePropertiesKHR = VK.get(caps, "vkGetPipelineExecutablePropertiesKHR")
//        vkGetPipelineExecutableStatisticsKHR = VK.get(caps, "vkGetPipelineExecutableStatisticsKHR")
//        vkGetPipelineExecutableInternalRepresentationsKHR =
//            VK.get(caps, "vkGetPipelineExecutableInternalRepresentationsKHR")
//        vkCmdPushDescriptorSetKHR = VK.get(caps, "vkCmdPushDescriptorSetKHR")
//        vkCreateSamplerYcbcrConversionKHR = VK.get(caps, "vkCreateSamplerYcbcrConversionKHR")
//        vkDestroySamplerYcbcrConversionKHR = VK.get(caps, "vkDestroySamplerYcbcrConversionKHR")
//        vkGetSwapchainStatusKHR = VK.get(caps, "vkGetSwapchainStatusKHR")
        vkCreateSwapchainKHR = "vkCreateSwapchainKHR"()
        vkDestroySwapchainKHR = "vkDestroySwapchainKHR"()
        vkGetSwapchainImagesKHR = "vkGetSwapchainImagesKHR"()
        vkAcquireNextImageKHR = "vkAcquireNextImageKHR"()
        vkQueuePresentKHR = "vkQueuePresentKHR"()
//        vkCmdSetViewportWScalingNV = VK.get(caps, "vkCmdSetViewportWScalingNV")
//        vkCmdSetCheckpointNV = VK.get(caps, "vkCmdSetCheckpointNV")
//        vkGetQueueCheckpointDataNV = VK.get(caps, "vkGetQueueCheckpointDataNV")
//        vkGetMemoryWin32HandleNV = VK.get(caps, "vkGetMemoryWin32HandleNV")
//        vkCmdDrawMeshTasksNV = VK.get(caps, "vkCmdDrawMeshTasksNV")
//        vkCmdDrawMeshTasksIndirectNV = VK.get(caps, "vkCmdDrawMeshTasksIndirectNV")
//        vkCmdDrawMeshTasksIndirectCountNV = VK.get(caps, "vkCmdDrawMeshTasksIndirectCountNV")
//        vkCreateAccelerationStructureNV = VK.get(caps, "vkCreateAccelerationStructureNV")
//        vkDestroyAccelerationStructureNV = VK.get(caps, "vkDestroyAccelerationStructureNV")
//        vkGetAccelerationStructureMemoryRequirementsNV =
//            VK.get(caps, "vkGetAccelerationStructureMemoryRequirementsNV")
//        vkBindAccelerationStructureMemoryNV = VK.get(caps, "vkBindAccelerationStructureMemoryNV")
//        vkCmdBuildAccelerationStructureNV = VK.get(caps, "vkCmdBuildAccelerationStructureNV")
//        vkCmdCopyAccelerationStructureNV = VK.get(caps, "vkCmdCopyAccelerationStructureNV")
//        vkCmdTraceRaysNV = VK.get(caps, "vkCmdTraceRaysNV")
//        vkCreateRayTracingPipelinesNV = VK.get(caps, "vkCreateRayTracingPipelinesNV")
//        vkGetRayTracingShaderGroupHandlesNV = VK.get(caps, "vkGetRayTracingShaderGroupHandlesNV")
//        vkGetAccelerationStructureHandleNV = VK.get(caps, "vkGetAccelerationStructureHandleNV")
//        vkCmdWriteAccelerationStructuresPropertiesNV =
//            VK.get(caps, "vkCmdWriteAccelerationStructuresPropertiesNV")
//        vkCompileDeferredNV = VK.get(caps, "vkCompileDeferredNV")
//        vkCmdSetExclusiveScissorNV = VK.get(caps, "vkCmdSetExclusiveScissorNV")
//        vkCmdBindShadingRateImageNV = VK.get(caps, "vkCmdBindShadingRateImageNV")
//        vkCmdSetViewportShadingRatePaletteNV = VK.get(caps, "vkCmdSetViewportShadingRatePaletteNV")
//        vkCmdSetCoarseSampleOrderNV = VK.get(caps, "vkCmdSetCoarseSampleOrderNV")
//        vkCmdProcessCommandsNVX = VK.get(caps, "vkCmdProcessCommandsNVX")
//        vkCmdReserveSpaceForCommandsNVX = VK.get(caps, "vkCmdReserveSpaceForCommandsNVX")
//        vkCreateIndirectCommandsLayoutNVX = VK.get(caps, "vkCreateIndirectCommandsLayoutNVX")
//        vkDestroyIndirectCommandsLayoutNVX = VK.get(caps, "vkDestroyIndirectCommandsLayoutNVX")
//        vkCreateObjectTableNVX = VK.get(caps, "vkCreateObjectTableNVX")
//        vkDestroyObjectTableNVX = VK.get(caps, "vkDestroyObjectTableNVX")
//        vkRegisterObjectsNVX = VK.get(caps, "vkRegisterObjectsNVX")
//        vkUnregisterObjectsNVX = VK.get(caps, "vkUnregisterObjectsNVX")
//        vkGetImageViewHandleNVX = VK.get(caps, "vkGetImageViewHandleNVX")
    }
}

fun FunctionProvider.checkCapsDeviceVK10(caps: MutableMap<String, Ptr>, ext: Set<String>): Boolean =
    "Vulkan10" in ext && VK.checkExtension(
        "Vulkan10",
        isSupported("vkGetDeviceProcAddr", caps)
                && isSupported("vkDestroyDevice", caps)
                && isSupported("vkGetDeviceQueue", caps)
                && isSupported("vkQueueSubmit", caps)
                && isSupported("vkQueueWaitIdle", caps)
                && isSupported("vkDeviceWaitIdle", caps)
                && isSupported("vkAllocateMemory", caps)
                && isSupported("vkFreeMemory", caps)
                && isSupported("vkMapMemory", caps)
                && isSupported("vkUnmapMemory", caps)
                && isSupported("vkFlushMappedMemoryRanges", caps)
                && isSupported("vkInvalidateMappedMemoryRanges", caps)
                && isSupported("vkGetDeviceMemoryCommitment", caps)
                && isSupported("vkBindBufferMemory", caps)
                && isSupported("vkBindImageMemory", caps)
                && isSupported("vkGetBufferMemoryRequirements", caps)
                && isSupported("vkGetImageMemoryRequirements", caps)
                && isSupported("vkGetImageSparseMemoryRequirements", caps)
                && isSupported("vkQueueBindSparse", caps)
                && isSupported("vkCreateFence", caps)
                && isSupported("vkDestroyFence", caps)
                && isSupported("vkResetFences", caps)
                && isSupported("vkGetFenceStatus", caps)
                && isSupported("vkWaitForFences", caps)
                && isSupported("vkCreateSemaphore", caps)
                && isSupported("vkDestroySemaphore", caps)
                && isSupported("vkCreateEvent", caps)
                && isSupported("vkDestroyEvent", caps)
                && isSupported("vkGetEventStatus", caps)
                && isSupported("vkSetEvent", caps)
                && isSupported("vkResetEvent", caps)
                && isSupported("vkCreateQueryPool", caps)
                && isSupported("vkDestroyQueryPool", caps)
                && isSupported("vkGetQueryPoolResults", caps)
                && isSupported("vkCreateBuffer", caps)
                && isSupported("vkDestroyBuffer", caps)
                && isSupported("vkCreateBufferView", caps)
                && isSupported("vkDestroyBufferView", caps)
                && isSupported("vkCreateImage", caps)
                && isSupported("vkDestroyImage", caps)
                && isSupported("vkGetImageSubresourceLayout", caps)
                && isSupported("vkCreateImageView", caps)
                && isSupported("vkDestroyImageView", caps)
                && isSupported("vkCreateShaderModule", caps)
                && isSupported("vkDestroyShaderModule", caps)
                && isSupported("vkCreatePipelineCache", caps)
                && isSupported("vkDestroyPipelineCache", caps)
                && isSupported("vkGetPipelineCacheData", caps)
                && isSupported("vkMergePipelineCaches", caps)
                && isSupported("vkCreateGraphicsPipelines", caps)
                && isSupported("vkCreateComputePipelines", caps)
                && isSupported("vkDestroyPipeline", caps)
                && isSupported("vkCreatePipelineLayout", caps)
                && isSupported("vkDestroyPipelineLayout", caps)
                && isSupported("vkCreateSampler", caps)
                && isSupported("vkDestroySampler", caps)
                && isSupported("vkCreateDescriptorSetLayout", caps)
                && isSupported("vkDestroyDescriptorSetLayout", caps)
                && isSupported("vkCreateDescriptorPool", caps)
                && isSupported("vkDestroyDescriptorPool", caps)
                && isSupported("vkResetDescriptorPool", caps)
                && isSupported("vkAllocateDescriptorSets", caps)
                && isSupported("vkFreeDescriptorSets", caps)
                && isSupported("vkUpdateDescriptorSets", caps)
                && isSupported("vkCreateFramebuffer", caps)
                && isSupported("vkDestroyFramebuffer", caps)
                && isSupported("vkCreateRenderPass", caps)
                && isSupported("vkDestroyRenderPass", caps)
                && isSupported("vkGetRenderAreaGranularity", caps)
                && isSupported("vkCreateCommandPool", caps)
                && isSupported("vkDestroyCommandPool", caps)
                && isSupported("vkResetCommandPool", caps)
                && isSupported("vkAllocateCommandBuffers", caps)
                && isSupported("vkFreeCommandBuffers", caps)
                && isSupported("vkBeginCommandBuffer", caps)
                && isSupported("vkEndCommandBuffer", caps)
                && isSupported("vkResetCommandBuffer", caps)
                && isSupported("vkCmdBindPipeline", caps)
                && isSupported("vkCmdSetViewport", caps)
                && isSupported("vkCmdSetScissor", caps)
                && isSupported("vkCmdSetLineWidth", caps)
                && isSupported("vkCmdSetDepthBias", caps)
                && isSupported("vkCmdSetBlendConstants", caps)
                && isSupported("vkCmdSetDepthBounds", caps)
                && isSupported("vkCmdSetStencilCompareMask", caps)
                && isSupported("vkCmdSetStencilWriteMask", caps)
                && isSupported("vkCmdSetStencilReference", caps)
                && isSupported("vkCmdBindDescriptorSets", caps)
                && isSupported("vkCmdBindIndexBuffer", caps)
                && isSupported("vkCmdBindVertexBuffers", caps)
                && isSupported("vkCmdDraw", caps)
                && isSupported("vkCmdDrawIndexed", caps)
                && isSupported("vkCmdDrawIndirect", caps)
                && isSupported("vkCmdDrawIndexedIndirect", caps)
                && isSupported("vkCmdDispatch", caps)
                && isSupported("vkCmdDispatchIndirect", caps)
                && isSupported("vkCmdCopyBuffer", caps)
                && isSupported("vkCmdCopyImage", caps)
                && isSupported("vkCmdBlitImage", caps)
                && isSupported("vkCmdCopyBufferToImage", caps)
                && isSupported("vkCmdCopyImageToBuffer", caps)
                && isSupported("vkCmdUpdateBuffer", caps)
                && isSupported("vkCmdFillBuffer", caps)
                && isSupported("vkCmdClearColorImage", caps)
                && isSupported("vkCmdClearDepthStencilImage", caps)
                && isSupported("vkCmdClearAttachments", caps)
                && isSupported("vkCmdResolveImage", caps)
                && isSupported("vkCmdSetEvent", caps)
                && isSupported("vkCmdResetEvent", caps)
                && isSupported("vkCmdWaitEvents", caps)
                && isSupported("vkCmdPipelineBarrier", caps)
                && isSupported("vkCmdBeginQuery", caps)
                && isSupported("vkCmdEndQuery", caps)
                && isSupported("vkCmdResetQueryPool", caps)
                && isSupported("vkCmdWriteTimestamp", caps)
                && isSupported("vkCmdCopyQueryPoolResults", caps)
                && isSupported("vkCmdPushConstants", caps)
                && isSupported("vkCmdBeginRenderPass", caps)
                && isSupported("vkCmdNextSubpass", caps)
                && isSupported("vkCmdEndRenderPass", caps)
                && isSupported("vkCmdExecuteCommands", caps)
    )

fun FunctionProvider.checkCapsDeviceVK11(caps: MutableMap<String, Ptr>, ext: Set<String>): Boolean =
    "Vulkan11" in ext && VK.checkExtension(
        "Vulkan11",
        isSupported("vkBindBufferMemory2", caps)
                && isSupported("vkBindImageMemory2", caps)
                && isSupported("vkGetDeviceGroupPeerMemoryFeatures", caps)
                && isSupported("vkCmdSetDeviceMask", caps)
                && isSupported("vkCmdDispatchBase", caps)
                && isSupported("vkGetImageMemoryRequirements2", caps)
                && isSupported("vkGetBufferMemoryRequirements2", caps)
                && isSupported("vkGetImageSparseMemoryRequirements2", caps)
                && isSupported("vkTrimCommandPool", caps)
                && isSupported("vkGetDeviceQueue2", caps)
                && isSupported("vkCreateSamplerYcbcrConversion", caps)
                && isSupported("vkDestroySamplerYcbcrConversion", caps)
                && isSupported("vkCreateDescriptorUpdateTemplate", caps)
                && isSupported("vkDestroyDescriptorUpdateTemplate", caps)
                && isSupported("vkUpdateDescriptorSetWithTemplate", caps)
                && isSupported("vkGetDescriptorSetLayoutSupport", caps)
    )