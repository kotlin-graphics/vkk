package vkk


@JvmInline
value class VkExternalMemoryHandleTypeNV(val i: VkExternalMemoryHandleTypeFlagsNV) {
    companion object {
        val OPAQUE_WIN32_BIT_NV = VkExternalMemoryHandleTypeNV(0x00000001)
        val OPAQUE_WIN32_KMT_BIT_NV = VkExternalMemoryHandleTypeNV(0x00000002)
        val D3D11_IMAGE_BIT_NV = VkExternalMemoryHandleTypeNV(0x00000004)
        val D3D11_IMAGE_KMT_BIT_NV = VkExternalMemoryHandleTypeNV(0x00000008)
    }
}

typealias VkExternalMemoryHandleTypeFlagsNV = VkFlags

@JvmInline
value class VkExternalMemoryFeatureNV(val i: VkExternalMemoryFeatureFlagsNV) {
    companion object {
        val DEDICATED_ONLY_BIT_NV = VkExternalMemoryFeatureNV(0x00000001)
        val EXPORTABLE_BIT_NV = VkExternalMemoryFeatureNV(0x00000002)
        val IMPORTABLE_BIT_NV = VkExternalMemoryFeatureNV(0x00000004)
    }
}

typealias VkExternalMemoryFeatureFlagsNV = VkFlags

// ..

typealias VkExternalFenceHandleTypeFlags = VkFlags

@JvmInline
value class VkExternalFenceFeature(val i: VkExternalFenceFeatureFlags) {
    companion object {
        val EXPORTABLE_BIT = VkExternalFenceFeature(0x00000001)
        val IMPORTABLE_BIT = VkExternalFenceFeature(0x00000002)
        val EXPORTABLE_BIT_KHR = VkExternalFenceFeature.EXPORTABLE_BIT
        val IMPORTABLE_BIT_KHR = VkExternalFenceFeature.IMPORTABLE_BIT
    }
}

typealias VkExternalFenceFeatureFlags = VkFlags

@JvmInline
value class VkFenceImport(val i: VkFenceImportFlags) {
    companion object {
        val TEMPORARY_BIT = VkFenceImport(0x00000001)
        val TEMPORARY_BIT_KHR = VkFenceImport.TEMPORARY_BIT
    }
}

typealias VkFenceImportFlags = VkFlags

@JvmInline
value class VkSemaphoreImport(val i: VkSemaphoreImportFlags) {
    companion object {
        val TEMPORARY_BIT = VkSemaphoreImport(0x00000001)
        val TEMPORARY_BIT_KHR = VkSemaphoreImport.TEMPORARY_BIT
    }
}

typealias VkSemaphoreImportFlags = VkFlags

// ...

@JvmInline
value class VkExternalSemaphoreHandleType(val i: VkExternalSemaphoreHandleTypeFlags) {
    companion object {
        val OPAQUE_FD_BIT = VkExternalSemaphoreHandleType(0x00000001)
        val OPAQUE_WIN32_BIT = VkExternalSemaphoreHandleType(0x00000002)
        val OPAQUE_WIN32_KMT_BIT = VkExternalSemaphoreHandleType(0x00000004)
        val D3D12_FENCE_BIT = VkExternalSemaphoreHandleType(0x00000008)
        val SYNC_FD_BIT = VkExternalSemaphoreHandleType(0x00000010)
        val OPAQUE_FD_BIT_KHR = VkExternalSemaphoreHandleType.OPAQUE_FD_BIT
        val OPAQUE_WIN32_BIT_KHR = VkExternalSemaphoreHandleType.OPAQUE_WIN32_BIT
        val OPAQUE_WIN32_KMT_BIT_KHR = VkExternalSemaphoreHandleType.OPAQUE_WIN32_KMT_BIT
        val D3D12_FENCE_BIT_KHR = VkExternalSemaphoreHandleType.D3D12_FENCE_BIT
        val SYNC_FD_BIT_KHR = VkExternalSemaphoreHandleType.SYNC_FD_BIT
    }
}

typealias VkExternalSemaphoreHandleTypeFlags = VkFlags

@JvmInline
value class VkExternalSemaphoreFeature(val i: VkExternalSemaphoreFeatureFlags) {
    companion object {
        val EXPORTABLE_BIT = VkExternalSemaphoreFeature(0x00000001)
        val IMPORTABLE_BIT = VkExternalSemaphoreFeature(0x00000002)
        val EXPORTABLE_BIT_KHR = VkExternalSemaphoreFeature.EXPORTABLE_BIT
        val IMPORTABLE_BIT_KHR = VkExternalSemaphoreFeature.IMPORTABLE_BIT
    }
}

typealias VkExternalSemaphoreFeatureFlags = VkFlags


// KHR_surface

// KHR_swapchain

// KHR_display

// KHR_display_swapchain

// KHR_get_physical_device_properties2

// KHR_device_group

// KHR_maintenance1

// KHR_device_group_creation

// KHR_external_memory_capabilities

// KHR_external_memory_fd

// KHR_external_semaphore_capabilities

// KHR_external_semaphore_fd

// KHR_push_descriptor

// KHR_shader_float16_int8

// KHR_incremental_present

// KHR_descriptor_update_template

// KHR_imageless_framebuffer

// KHR_create_renderpass2

// KHR_shared_presentable_image

// KHR_external_fence_capabilities

// KHR_external_fence_fd

// KHR_get_surface_capabilities2

// KHR_get_display_properties2

// KHR_get_memory_requirements2

// KHR_image_format_list

// KHR_sampler_ycbcr_conversion

// KHR_bind_memory2

// KHR_maintenance3

// KHR_draw_indirect_count

// KHR_8bit_storage

// KHR_shader_atomic_int64

// KHR_driver_properties

// KHR_shader_float_controls

// KHR_depth_stencil_resolve

// KHR_vulkan_memory_model

// KHR_surface_protected_capabilities

// KHR_uniform_buffer_standard_layout

// KHR_pipeline_executable_properties

// AMD_rasterization_order

// EXT_debug_marker

// NV_dedicated_allocation

// EXT_transform_feedback

// AMD_draw_indirect_count

// AMD_texture_gather_bias_lod

// AMD_shader_info

// NV_corner_sampled_image

// NV_external_memory_capabilities

// NV_external_memory

// EXT_validation_flags

// EXT_texture_compression_astc_hdr

// EXT_astc_decode_mode

// EXT_conditional_rendering

// NVX_device_generated_commands

// NV_clip_space_w_scaling

// EXT_direct_mode_display

// EXT_display_surface_counter

// EXT_display_control

// EXT_display_control

// GOOGLE_display_timing

// NVX_multiview_per_view_attributes

// NV_viewport_swizzle

// EXT_discard_rectangles

// EXT_conservative_rasterization

// EXT_depth_clip_enable

// EXT_hdr_metadata

// EXT_debug_utils

// ..

@JvmInline
value class VkSamplerReductionModeEXT(val i: Int) {
    companion object {
        val WEIGHTED_AVERAGE_EXT = VkSamplerReductionModeEXT(0)
        val MIN_EXT = VkSamplerReductionModeEXT(1)
        val MAX_EXT = VkSamplerReductionModeEXT(2)
    }
}

// ..


@JvmInline
value class VkBlendOverlapEXT(val i: Int) {
    companion object {
        val UNCORRELATED_EXT = VkBlendOverlapEXT(0)
        val DISJOINT_EXT = VkBlendOverlapEXT(1)
        val CONJOINT_EXT = VkBlendOverlapEXT(2)
    }
}

// ..

typealias VkPipelineCoverageToColorStateCreateFlagsNV = VkFlags

// ..

@JvmInline
value class VkCoverageModulationModeNV(val i: Int) {
    companion object {
        val NONE_NV = VkCoverageModulationModeNV(0)
        val RGB_NV = VkCoverageModulationModeNV(1)
        val ALPHA_NV = VkCoverageModulationModeNV(2)
        val RGBA_NV = VkCoverageModulationModeNV(3)
    }
}

typealias VkPipelineCoverageModulationStateCreateFlagsNV = VkFlags

// ..

@JvmInline
value class VkValidationCacheHeaderVersionEXT(val i: Int) {
    companion object {
        val ONE_EXT = VkValidationCacheHeaderVersionEXT(1)
    }
}

typealias VkValidationCacheCreateFlagsEXT = VkFlags

// ..

@JvmInline
value class VkDescriptorBindingEXT(val i: VkDescriptorBindingFlagsEXT) {
    companion object {
        val UPDATE_AFTER_BIND_BIT_EXT = VkDescriptorBindingEXT(0x00000001)
        val UPDATE_UNUSED_WHILE_PENDING_BIT_EXT = VkDescriptorBindingEXT(0x00000002)
        val PARTIALLY_BOUND_BIT_EXT = VkDescriptorBindingEXT(0x00000004)
        val VARIABLE_DESCRIPTOR_COUNT_BIT_EXT = VkDescriptorBindingEXT(0x00000008)
    }
}

typealias VkDescriptorBindingFlagsEXT = VkFlags

// ..

@JvmInline
value class VkShadingRatePaletteEntryNV(val i: Int) {
    companion object {
        val _NO_INVOCATIONS_NV = VkShadingRatePaletteEntryNV(0)
        val _16_INVOCATIONS_PER_PIXEL_NV = VkShadingRatePaletteEntryNV(1)
        val _8_INVOCATIONS_PER_PIXEL_NV = VkShadingRatePaletteEntryNV(2)
        val _4_INVOCATIONS_PER_PIXEL_NV = VkShadingRatePaletteEntryNV(3)
        val _2_INVOCATIONS_PER_PIXEL_NV = VkShadingRatePaletteEntryNV(4)
        val _1_INVOCATION_PER_PIXEL_NV = VkShadingRatePaletteEntryNV(5)
        val _1_INVOCATION_PER_2X1_PIXELS_NV = VkShadingRatePaletteEntryNV(6)
        val _1_INVOCATION_PER_1X2_PIXELS_NV = VkShadingRatePaletteEntryNV(7)
        val _1_INVOCATION_PER_2X2_PIXELS_NV = VkShadingRatePaletteEntryNV(8)
        val _1_INVOCATION_PER_4X2_PIXELS_NV = VkShadingRatePaletteEntryNV(9)
        val _1_INVOCATION_PER_2X4_PIXELS_NV = VkShadingRatePaletteEntryNV(10)
        val _1_INVOCATION_PER_4X4_PIXELS_NV = VkShadingRatePaletteEntryNV(11)
    }
}

@JvmInline
value class VkCoarseSampleOrderTypeNV(val i: Int) {
    companion object {
        val DEFAULT_NV = VkCoarseSampleOrderTypeNV(0)
        val CUSTOM_NV = VkCoarseSampleOrderTypeNV(1)
        val PIXEL_MAJOR_NV = VkCoarseSampleOrderTypeNV(2)
        val SAMPLE_MAJOR_NV = VkCoarseSampleOrderTypeNV(3)
    }
}

// ..

@JvmInline
value class VkRayTracingShaderGroupTypeNV(val i: Int) {
    companion object {
        val GENERAL_NV = VkRayTracingShaderGroupTypeNV(0)
        val TRIANGLES_HIT_GROUP_NV = VkRayTracingShaderGroupTypeNV(1)
        val PROCEDURAL_HIT_GROUP_NV = VkRayTracingShaderGroupTypeNV(2)
    }
}

@JvmInline
value class VkGeometryTypeNV(val i: Int) {
    companion object {
        val TRIANGLES_NV = VkGeometryTypeNV(0)
        val AABBS_NV = VkGeometryTypeNV(1)
    }
}

@JvmInline
value class VkAccelerationStructureTypeNV(val i: Int) {
    companion object {
        val TOP_LEVEL_NV = VkAccelerationStructureTypeNV(0)
        val BOTTOM_LEVEL_NV = VkAccelerationStructureTypeNV(1)
    }
}

@JvmInline
value class VkCopyAccelerationStructureModeNV(val i: Int) {
    companion object {
        val CLONE_NV = VkCopyAccelerationStructureModeNV(0)
        val COMPACT_NV = VkCopyAccelerationStructureModeNV(1)
    }
}

@JvmInline
value class VkAccelerationStructureMemoryRequirementsTypeNV(val i: Int) {
    companion object {
        val OBJECT_NV = VkAccelerationStructureMemoryRequirementsTypeNV(0)
        val BUILD_SCRATCH_NV = VkAccelerationStructureMemoryRequirementsTypeNV(1)
        val UPDATE_SCRATCH_NV = VkAccelerationStructureMemoryRequirementsTypeNV(2)
    }
}


@JvmInline
value class VkGeometryFlagNV(val i: VkGeometryFlagsNV) {
    companion object {
        val OPAQUE_BIT_NV = VkGeometryFlagNV(0x00000001)
        val NO_DUPLICATE_ANY_HIT_INVOCATION_BIT_NV = VkGeometryFlagNV(0x00000002)
    }
}

typealias VkGeometryFlagsNV = VkFlags

@JvmInline
value class VkGeometryInstanceNV(val i: VkGeometryInstanceFlagsNV) {
    companion object {
        val TRIANGLE_CULL_DISABLE_BIT_NV = VkGeometryInstanceNV(0x00000001)
        val TRIANGLE_FRONT_COUNTERCLOCKWISE_BIT_NV = VkGeometryInstanceNV(0x00000002)
        val FORCE_OPAQUE_BIT_NV = VkGeometryInstanceNV(0x00000004)
        val FORCE_NO_OPAQUE_BIT_NV = VkGeometryInstanceNV(0x00000008)
    }
}

typealias VkGeometryInstanceFlagsNV = VkFlags

@JvmInline
value class VkBuildAccelerationStructureNV(val i: VkBuildAccelerationStructureFlagsNV) {
    companion object {
        val ALLOW_UPDATE_BIT_NV = VkBuildAccelerationStructureNV(0x00000001)
        val ALLOW_COMPACTION_BIT_NV = VkBuildAccelerationStructureNV(0x00000002)
        val PREFER_FAST_TRACE_BIT_NV = VkBuildAccelerationStructureNV(0x00000004)
        val PREFER_FAST_BUILD_BIT_NV = VkBuildAccelerationStructureNV(0x00000008)
        val LOW_MEMORY_BIT_NV = VkBuildAccelerationStructureNV(0x00000010)
    }
}

typealias VkBuildAccelerationStructureFlagsNV = VkFlags

// ..

@JvmInline
value class VkQueueGlobalPriorityEXT(val i: Int) {
    companion object {
        val LOW_EXT = VkQueueGlobalPriorityEXT(128)
        val MEDIUM_EXT = VkQueueGlobalPriorityEXT(256)
        val HIGH_EXT = VkQueueGlobalPriorityEXT(512)
        val REALTIME_EXT = VkQueueGlobalPriorityEXT(1024)
    }
}

// ..

@JvmInline
value class VkTimeDomainEXT(val i: Int) {
    companion object {
        val DEVICE = VkTimeDomainEXT(0)
        val CLOCK_MONOTONIC = VkTimeDomainEXT(1)
        val CLOCK_MONOTONIC_RAW = VkTimeDomainEXT(2)
        val QUERY_PERFORMANCE_COUNTER = VkTimeDomainEXT(3)
    }
}

// ..

@JvmInline
value class VkMemoryOverallocationBehaviorAMD(val i: Int) {
    companion object {
        val DEFAULT_AMD = VkMemoryOverallocationBehaviorAMD(0)
        val ALLOWED_AMD = VkMemoryOverallocationBehaviorAMD(1)
        val DISALLOWED_AMD = VkMemoryOverallocationBehaviorAMD(2)
    }
}

// ..

@JvmInline
value class VkPipelineCreationFeedback(val i: VkPipelineCreationFeedbackFlagsEXT) {
    companion object {
        val FEEDBACK_VALID_BIT_EXT = VkPipelineCreationFeedback(0x00000001)
        val APPLICATION_PIPELINE_CACHE_HIT_BIT_EXT = VkPipelineCreationFeedback(0x00000002)
        val FEEDBACK_BASE_PIPELINE_ACCELERATION_BIT_EXT = VkPipelineCreationFeedback(0x00000004)
    }
}

typealias VkPipelineCreationFeedbackFlagsEXT = VkFlags

// ..

@JvmInline
value class VkValidationFeatureEnableEXT(val i: Int) {
    companion object {
        val GPU_ASSISTED = VkValidationFeatureEnableEXT(0)
        val GPU_ASSISTED_RESERVE_BINDING_SLOT = VkValidationFeatureEnableEXT(1)
    }
}

@JvmInline
value class VkValidationFeatureDisableEXT(val i: Int) {
    companion object {
        val AL = VkValidationFeatureDisableEXT(0)
        val SHADER = VkValidationFeatureDisableEXT(1)
        val THREAD_SAFET = VkValidationFeatureDisableEXT(2)
        val API_PARAMETER = VkValidationFeatureDisableEXT(3)
        val OBJECT_LIFETIME = VkValidationFeatureDisableEXT(4)
        val CORE_CHECK = VkValidationFeatureDisableEXT(5)
        val UNIQUE_HANDLE = VkValidationFeatureDisableEXT(6)
    }
}

// ..

@JvmInline
value class VkComponentTypeNV(val i: Int) {
    companion object {
        val FLOAT16_NV = VkComponentTypeNV(0)
        val FLOAT32_NV = VkComponentTypeNV(1)
        val FLOAT64_NV = VkComponentTypeNV(2)
        val SINT8_NV = VkComponentTypeNV(3)
        val SINT16_NV = VkComponentTypeNV(4)
        val SINT32_NV = VkComponentTypeNV(5)
        val SINT64_NV = VkComponentTypeNV(6)
        val UINT8_NV = VkComponentTypeNV(7)
        val UINT16_NV = VkComponentTypeNV(8)
        val UINT32_NV = VkComponentTypeNV(9)
        val UINT64_NV = VkComponentTypeNV(10)
    }
}


@JvmInline
value class VkScopeNV(val i: Int) {
    companion object {
        val DEVICE_NV = VkScopeNV(1)
        val WORKGROUP_NV = VkScopeNV(2)
        val SUBGROUP_NV = VkScopeNV(3)
        val QUEUE_FAMILY_NV = VkScopeNV(5)
    }
}

// ..

typealias VkHeadlessSurfaceCreateFlagsEXT = VkFlags