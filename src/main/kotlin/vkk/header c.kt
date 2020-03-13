package vkk


inline class VkExternalMemoryHandleTypeNV(val i: Int) {
    companion object {
        val OPAQUE_WIN32_BIT_NV = VkExternalMemoryHandleTypeNV(0x00000001)
        val OPAQUE_WIN32_KMT_BIT_NV = VkExternalMemoryHandleTypeNV(0x00000002)
        val D3D11_IMAGE_BIT_NV = VkExternalMemoryHandleTypeNV(0x00000004)
        val D3D11_IMAGE_KMT_BIT_NV = VkExternalMemoryHandleTypeNV(0x00000008)
    }
}

typealias VkExternalMemoryHandleTypeFlagsNV = VkFlags

inline class VkExternalMemoryFeatureNV(val i: Int) {
    companion object {
        val DEDICATED_ONLY_BIT_NV = VkExternalMemoryFeatureNV(0x00000001)
        val EXPORTABLE_BIT_NV = VkExternalMemoryFeatureNV(0x00000002)
        val IMPORTABLE_BIT_NV = VkExternalMemoryFeatureNV(0x00000004)
    }
}

typealias VkExternalMemoryFeatureFlagsNV = VkFlags

// ..

typealias VkExternalFenceHandleTypeFlags = VkFlags

inline class VkExternalFenceFeature(val i: Int) {
    companion object {
        val EXPORTABLE_BIT = VkExternalFenceFeature(0x00000001)
        val IMPORTABLE_BIT = VkExternalFenceFeature(0x00000002)
        val EXPORTABLE_BIT_KHR = VkExternalFenceFeature.EXPORTABLE_BIT
        val IMPORTABLE_BIT_KHR = VkExternalFenceFeature.IMPORTABLE_BIT
    }
}

typealias VkExternalFenceFeatureFlags = VkFlags

inline class VkFenceImport(val i: Int) {
    companion object {
        val TEMPORARY_BIT = VkFenceImport(0x00000001)
        val TEMPORARY_BIT_KHR = VkFenceImport.TEMPORARY_BIT
    }
}

typealias VkFenceImportFlags = VkFlags

inline class VkSemaphoreImport(val i: Int) {
    companion object {
        val TEMPORARY_BIT = VkSemaphoreImport(0x00000001)
        val TEMPORARY_BIT_KHR = VkSemaphoreImport.TEMPORARY_BIT
    }
}

typealias VkSemaphoreImportFlags = VkFlags

// ...

inline class VkExternalSemaphoreHandleType(val i: Int) {
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

inline class VkExternalSemaphoreFeature(val i: Int) {
    companion object {
        val EXPORTABLE_BIT = VkExternalSemaphoreFeature(0x00000001)
        val IMPORTABLE_BIT = VkExternalSemaphoreFeature(0x00000002)
        val EXPORTABLE_BIT_KHR = VkExternalSemaphoreFeature.EXPORTABLE_BIT
        val IMPORTABLE_BIT_KHR = VkExternalSemaphoreFeature.IMPORTABLE_BIT
    }
}

typealias VkExternalSemaphoreFeatureFlags = VkFlags


// ...


inline class VkColorSpaceKHR(val i: Int) {
    companion object {
        val SRGB_NONLINEAR_KHR = VkColorSpaceKHR(0)
        val DISPLAY_P3_NONLINEAR_EXT = VkColorSpaceKHR(1000104001)
        val EXTENDED_SRGB_LINEAR_EXT = VkColorSpaceKHR(1000104002)
        val DCI_P3_LINEAR_EXT = VkColorSpaceKHR(1000104003)
        val DCI_P3_NONLINEAR_EXT = VkColorSpaceKHR(1000104004)
        val BT709_LINEAR_EXT = VkColorSpaceKHR(1000104005)
        val BT709_NONLINEAR_EXT = VkColorSpaceKHR(1000104006)
        val BT2020_LINEAR_EXT = VkColorSpaceKHR(1000104007)
        val HDR10_ST2084_EXT = VkColorSpaceKHR(1000104008)
        val DOLBYVISION_EXT = VkColorSpaceKHR(1000104009)
        val HDR10_HLG_EXT = VkColorSpaceKHR(1000104010)
        val ADOBERGB_LINEAR_EXT = VkColorSpaceKHR(1000104011)
        val ADOBERGB_NONLINEAR_EXT = VkColorSpaceKHR(1000104012)
        val PASS_THROUGH_EXT = VkColorSpaceKHR(1000104013)
        val EXTENDED_SRGB_NONLINEAR_EXT = VkColorSpaceKHR(1000104014)
        val DISPLAY_NATIVE_AMD = VkColorSpaceKHR(1000213000)
    }
}

inline class VkPresentModeKHR(val i: Int) {
    companion object {
        val IMMEDIATE = VkPresentModeKHR(0)
        val MAILBOX = VkPresentModeKHR(1)
        val FIFO = VkPresentModeKHR(2)
        val FIFO_RELAXED = VkPresentModeKHR(3)
        val SHARED_DEMAND_REFRESH = VkPresentModeKHR(1000111000)
        val SHARED_CONTINUOUS_REFRESH = VkPresentModeKHR(1000111001)
    }
}


inline class VkSurfaceTransformKHR(val i: Int) {
    companion object {
        val IDENTITY_BIT = VkSurfaceTransformKHR(0x00000001)
        val ROTATE_90_BIT = VkSurfaceTransformKHR(0x00000002)
        val ROTATE_180_BIT = VkSurfaceTransformKHR(0x00000004)
        val ROTATE_270_BIT = VkSurfaceTransformKHR(0x00000008)
        val HORIZONTAL_MIRROR_BIT = VkSurfaceTransformKHR(0x00000010)
        val HORIZONTAL_MIRROR_ROTATE_90_BIT = VkSurfaceTransformKHR(0x00000020)
        val HORIZONTAL_MIRROR_ROTATE_180_BIT = VkSurfaceTransformKHR(0x00000040)
        val HORIZONTAL_MIRROR_ROTATE_270_BIT = VkSurfaceTransformKHR(0x00000080)
        val INHERIT_BIT = VkSurfaceTransformKHR(0x00000100)
    }
}

infix fun Int.has(f: VkSurfaceTransformKHR) = and(f.i) != 0

typealias VkSurfaceTransformFlagsKHR = VkFlags

inline class VkCompositeAlphaKHR(val i: Int) {
    companion object {
        val OPAQUE_BIT = VkCompositeAlphaKHR(0x00000001)
        val PRE_MULTIPLIED_BIT = VkCompositeAlphaKHR(0x00000002)
        val POST_MULTIPLIED_BIT = VkCompositeAlphaKHR(0x00000004)
        val INHERIT_BIT = VkCompositeAlphaKHR(0x00000008)
    }
}

infix fun Int.has(f: VkCompositeAlphaKHR) = and(f.i) != 0

typealias VkCompositeAlphaFlagsKHR = VkFlags

// ...

inline class VkSwapchainCreateKHR(val i: Int) {
    companion object {
        val SPLIT_INSTANCE_BIND_REGIONS_BIT = VkSwapchainCreateKHR(0x00000001)
        val PROTECTED_BIT = VkSwapchainCreateKHR(0x00000002)
        val MUTABLE_FORMAT_BIT = VkSwapchainCreateKHR(0x00000004)
    }
}

typealias VkSwapchainCreateFlagsKHR = VkFlags


inline class VkDeviceGroupPresentModeKHR(val i: Int) {
    companion object {
        val LOCAL_BIT = VkDeviceGroupPresentModeKHR(0x00000001)
        val REMOTE_BIT = VkDeviceGroupPresentModeKHR(0x00000002)
        val SUM_BIT = VkDeviceGroupPresentModeKHR(0x00000004)
        val LOCAL_MULTI_DEVICE_BIT = VkDeviceGroupPresentModeKHR(0x00000008)
    }
}

typealias VkDeviceGroupPresentModeFlagsKHR = VkFlags

// ..

inline class VkDisplayPlaneAlphaKHR(val i: Int) {

    companion object {
        val OPAQUE_BIT = VkDisplayPlaneAlphaKHR(0x00000001)
        val GLOBAL_BIT = VkDisplayPlaneAlphaKHR(0x00000002)
        val PER_PIXEL_BIT = VkDisplayPlaneAlphaKHR(0x00000004)
        val PER_PIXEL_PREMULTIPLIED_BIT = VkDisplayPlaneAlphaKHR(0x00000008)
    }
}

typealias VkDisplayPlaneAlphaFlagsKHR = VkFlags
typealias VkDisplayModeCreateFlagsKHR = VkFlags
typealias VkDisplaySurfaceCreateFlagsKHR = VkFlags

// ..

inline class VkDriverIdKHR(val i: Int) {
    companion object {
        val AMD_PROPRIETARY = VkDriverIdKHR(1)
        val AMD_OPEN_SOURCE = VkDriverIdKHR(2)
        val MESA_RADV = VkDriverIdKHR(3)
        val NVIDIA_PROPRIETARY = VkDriverIdKHR(4)
        val INTEL_PROPRIETARY_WINDOWS = VkDriverIdKHR(5)
        val INTEL_OPEN_SOURCE_MESA = VkDriverIdKHR(6)
        val IMAGINATION_PROPRIETARY = VkDriverIdKHR(7)
        val QUALCOMM_PROPRIETARY = VkDriverIdKHR(8)
        val ARM_PROPRIETARY = VkDriverIdKHR(9)
        val GOOGLE_PASTEL = VkDriverIdKHR(10)
        val GGP_PROPRIETARY = VkDriverIdKHR(11)
    }
}

// ..

inline class VkResolveModeKHR(val i: Int) {
    companion object {
        val NONE = VkResolveModeKHR(0)
        val SAMPLE_ZERO_BIT = VkResolveModeKHR(0x00000001)
        val AVERAGE_BIT = VkResolveModeKHR(0x00000002)
        val MIN_BIT = VkResolveModeKHR(0x00000004)
        val MAX_BIT = VkResolveModeKHR(0x00000008)
    }
}

typealias VkResolveModeFlagsKHR = VkFlags

// ..


inline class VkDebugReportObjectTypeEXT(val i: Int) {
    companion object {
        val UNKNOWN = VkDebugReportObjectTypeEXT(0)
        val INSTANCE = VkDebugReportObjectTypeEXT(1)
        val PHYSICAL_DEVICE = VkDebugReportObjectTypeEXT(2)
        val DEVICE = VkDebugReportObjectTypeEXT(3)
        val QUEUE = VkDebugReportObjectTypeEXT(4)
        val SEMAPHORE = VkDebugReportObjectTypeEXT(5)
        val COMMAND_BUFFER = VkDebugReportObjectTypeEXT(6)
        val FENCE = VkDebugReportObjectTypeEXT(7)
        val DEVICE_MEMORY = VkDebugReportObjectTypeEXT(8)
        val BUFFER = VkDebugReportObjectTypeEXT(9)
        val IMAGE = VkDebugReportObjectTypeEXT(10)
        val EVENT = VkDebugReportObjectTypeEXT(11)
        val QUERY_POOL = VkDebugReportObjectTypeEXT(12)
        val BUFFER_VIEW = VkDebugReportObjectTypeEXT(13)
        val IMAGE_VIEW = VkDebugReportObjectTypeEXT(14)
        val SHADER_MODULE = VkDebugReportObjectTypeEXT(15)
        val PIPELINE_CACHE = VkDebugReportObjectTypeEXT(16)
        val PIPELINE_LAYOUT = VkDebugReportObjectTypeEXT(17)
        val RENDER_PASS = VkDebugReportObjectTypeEXT(18)
        val PIPELINE = VkDebugReportObjectTypeEXT(19)
        val DESCRIPTOR_SET_LAYOUT = VkDebugReportObjectTypeEXT(20)
        val SAMPLER = VkDebugReportObjectTypeEXT(21)
        val DESCRIPTOR_POOL = VkDebugReportObjectTypeEXT(22)
        val DESCRIPTOR_SET = VkDebugReportObjectTypeEXT(23)
        val FRAMEBUFFER = VkDebugReportObjectTypeEXT(24)
        val COMMAND_POOL = VkDebugReportObjectTypeEXT(25)
        val SURFACE_KHR = VkDebugReportObjectTypeEXT(26)
        val SWAPCHAIN_KHR = VkDebugReportObjectTypeEXT(27)
        val DEBUG_REPORT_CALLBACK_EXT = VkDebugReportObjectTypeEXT(28)
        val DISPLAY_KHR = VkDebugReportObjectTypeEXT(29)
        val DISPLAY_MODE_KHR = VkDebugReportObjectTypeEXT(30)
        val OBJECT_TABLE_NVX = VkDebugReportObjectTypeEXT(31)
        val INDIRECT_COMMANDS_LAYOUT_NVX = VkDebugReportObjectTypeEXT(32)
        val VALIDATION_CACHE_EXT = VkDebugReportObjectTypeEXT(33)
        val SAMPLER_YCBCR_CONVERSION = VkDebugReportObjectTypeEXT(1000156000)
        val DESCRIPTOR_UPDATE_TEMPLATE = VkDebugReportObjectTypeEXT(1000085000)
        val ACCELERATION_STRUCTURE_NV = VkDebugReportObjectTypeEXT(1000156000)
        val DEBUG_REPORT = VkDebugReportObjectTypeEXT.DEBUG_REPORT_CALLBACK_EXT
        val VALIDATION_CACHE = VkDebugReportObjectTypeEXT.VALIDATION_CACHE_EXT
        val DEBUG_REPORT_OBJECT_TYPE_DESCRIPTOR_UPDATE_TEMPLATE_KHR = VkDebugReportObjectTypeEXT.DESCRIPTOR_UPDATE_TEMPLATE
        val SAMPLER_YCBCR_CONVERSION_KHR = VkDebugReportObjectTypeEXT.SAMPLER_YCBCR_CONVERSION
    }
}


inline class VkDebugReport(val i: Int) {
    companion object {
        val INFORMATION_BIT_EXT = VkDebugReport(0x00000001)
        val WARNING_BIT_EXT = VkDebugReport(0x00000002)
        val PERFORMANCE_WARNING_BIT_EXT = VkDebugReport(0x00000004)
        val ERROR_BIT_EXT = VkDebugReport(0x00000008)
        val DEBUG_BIT_EXT = VkDebugReport(0x00000010)
    }

    infix fun or(other: VkDebugReport) = i or other.i
}

infix fun Int.has(f: VkDebugReport) = and(f.i) != 0
infix fun Int.or(f: VkDebugReport): VkDebugReportFlagsEXT = or(f.i)
infix fun Int.and(f: VkDebugReport): VkDebugReportFlagsEXT = and(f.i)

typealias VkDebugReportFlagsEXT = VkFlags

// ..

typealias VkPipelineRasterizationStateStreamCreateFlagsEXT = VkFlags

// ..

inline class VkShaderInfoTypeAMD(val i: Int) {
    companion object {
        val STATISTICS_AMD = VkShaderInfoTypeAMD(0)
        val BINARY_AMD = VkShaderInfoTypeAMD(1)
        val DISASSEMBLY_AMD = VkShaderInfoTypeAMD(2)
    }
}

// ..


inline class VkValidationCheckEXT(val i: Int) {
    companion object {
        val ALL_EXT = VkValidationCheckEXT(0)
        val SHADERS_EXT = VkValidationCheckEXT(1)
    }
}

// ..


inline class VkConditionalRenderingEXT(val i: Int) {
    companion object {
        val INVERTED_BIT_EXT = VkConditionalRenderingEXT(0x00000001)
    }
}

typealias VkConditionalRenderingFlagsEXT = VkFlags

// ..


inline class VkIndirectCommandsTokenTypeNVX(val i: Int) {
    companion object {
        val PIPELINE_NVX = VkIndirectCommandsTokenTypeNVX(0)
        val DESCRIPTOR_SET_NVX = VkIndirectCommandsTokenTypeNVX(1)
        val INDEX_BUFFER_NVX = VkIndirectCommandsTokenTypeNVX(2)
        val VERTEX_BUFFER_NVX = VkIndirectCommandsTokenTypeNVX(3)
        val PUSH_CONSTANT_NVX = VkIndirectCommandsTokenTypeNVX(4)
        val DRAW_INDEXED_NVX = VkIndirectCommandsTokenTypeNVX(5)
        val DRAW_NVX = VkIndirectCommandsTokenTypeNVX(6)
        val DISPATCH_NVX = VkIndirectCommandsTokenTypeNVX(7)
    }
}

inline class VkObjectEntryTypeNVX(val i: Int) {
    companion object {
        val DESCRIPTOR_SET_NVX = VkObjectEntryTypeNVX(0)
        val PIPELINE_NVX = VkObjectEntryTypeNVX(1)
        val INDEX_BUFFER_NVX = VkObjectEntryTypeNVX(2)
        val VERTEX_BUFFER_NVX = VkObjectEntryTypeNVX(3)
        val PUSH_CONSTANT_NVX = VkObjectEntryTypeNVX(4)
    }
}


inline class VkIndirectCommandsLayoutUsageNVX(val i: Int) {
    companion object {
        val UNORDERED_SEQUENCES_BIT_NVX = VkIndirectCommandsLayoutUsageNVX(0x00000001)
        val SPARSE_SEQUENCES_BIT_NVX = VkIndirectCommandsLayoutUsageNVX(0x00000002)
        val EMPTY_EXECUTIONS_BIT_NVX = VkIndirectCommandsLayoutUsageNVX(0x00000004)
        val INDEXED_SEQUENCES_BIT_NVX = VkIndirectCommandsLayoutUsageNVX(0x00000008)
    }
}

typealias VkIndirectCommandsLayoutUsageFlagsNVX = VkFlags


inline class VkObjectEntryUsageNVX(val i: Int) {
    companion object {
        val GRAPHICS_BIT_NVX = VkObjectEntryUsageNVX(0x00000001)
        val COMPUTE_BIT_NVX = VkObjectEntryUsageNVX(0x00000002)
    }
}

typealias VkObjectEntryUsageFlagsNVX = VkFlags

// ..


inline class VkSurfaceCounterEXT(val i: Int) {
    companion object {
        val VBLANK_EXT = VkSurfaceCounterEXT(0x00000001)
    }
}

typealias VkSurfaceCounterFlagsEXT = VkFlags

// ..

inline class VkViewportCoordinateSwizzleNV(val i: Int) {
    companion object {
        val POSITIVE_X_NV = VkViewportCoordinateSwizzleNV(0)
        val NEGATIVE_X_NV = VkViewportCoordinateSwizzleNV(1)
        val POSITIVE_Y_NV = VkViewportCoordinateSwizzleNV(2)
        val NEGATIVE_Y_NV = VkViewportCoordinateSwizzleNV(3)
        val POSITIVE_Z_NV = VkViewportCoordinateSwizzleNV(4)
        val NEGATIVE_Z_NV = VkViewportCoordinateSwizzleNV(5)
        val POSITIVE_W_NV = VkViewportCoordinateSwizzleNV(6)
        val NEGATIVE_W_NV = VkViewportCoordinateSwizzleNV(7)
    }
}

typealias VkPipelineViewportSwizzleStateCreateFlagsNV = VkFlags

// ..

inline class VkDiscardRectangleModeEXT(val i: Int) {
    companion object {
        val INCLUSIVE_EXT = VkDiscardRectangleModeEXT(0)
        val EXCLUSIVE_EXT = VkDiscardRectangleModeEXT(1)
    }
}

typealias VkPipelineDiscardRectangleStateCreateFlagsEXT = VkFlags

// ..

inline class VkConservativeRasterizationModeEXT(val i: Int) {
    companion object {
        val DISABLED_EXT = VkConservativeRasterizationModeEXT(0)
        val OVERESTIMATE_EXT = VkConservativeRasterizationModeEXT(1)
        val UNDERESTIMATE_EXT = VkConservativeRasterizationModeEXT(2)
    }
}

typealias VkPipelineRasterizationConservativeStateCreateFlagsEXT = VkFlags

// ..

typealias VkPipelineRasterizationDepthClipStateCreateFlagsEXT = VkFlags

// ..

typealias VkDebugUtilsMessengerCallbackDataFlagsEXT = VkFlags
typealias VkDebugUtilsMessengerCreateFlagsEXT = VkFlags

inline class VkDebugUtilsMessageSeverityEXT(val i: Int) {
    companion object {
        val VERBOSE = VkDebugUtilsMessageSeverityEXT(0x00000001)
        val INFO = VkDebugUtilsMessageSeverityEXT(0x00000010)
        val WARNING = VkDebugUtilsMessageSeverityEXT(0x00000100)
        val ERROR = VkDebugUtilsMessageSeverityEXT(0x00001000)
    }
}
typealias VkDebugUtilsMessageSeverityFlagsEXT = VkFlags

inline class VkDebugUtilsMessageTypeEXT(val i: Int) {
    companion object {
        val GENERAL = VkDebugUtilsMessageTypeEXT(0x00000001)
        val VALIDATION = VkDebugUtilsMessageTypeEXT(0x00000002)
        val PERFORMANCE = VkDebugUtilsMessageTypeEXT(0x00000004)
    }
}
typealias VkDebugUtilsMessageTypeFlagsEXT = VkFlags

// ..

inline class VkSamplerReductionModeEXT(val i: Int) {
    companion object {
        val WEIGHTED_AVERAGE_EXT = VkSamplerReductionModeEXT(0)
        val MIN_EXT = VkSamplerReductionModeEXT(1)
        val MAX_EXT = VkSamplerReductionModeEXT(2)
    }
}

// ..


inline class VkBlendOverlapEXT(val i: Int) {
    companion object {
        val UNCORRELATED_EXT = VkBlendOverlapEXT(0)
        val DISJOINT_EXT = VkBlendOverlapEXT(1)
        val CONJOINT_EXT = VkBlendOverlapEXT(2)
    }
}

// ..

typealias VkPipelineCoverageToColorStateCreateFlagsNV = VkFlags

// ..

inline class VkCoverageModulationModeNV(val i: Int) {
    companion object {
        val NONE_NV = VkCoverageModulationModeNV(0)
        val RGB_NV = VkCoverageModulationModeNV(1)
        val ALPHA_NV = VkCoverageModulationModeNV(2)
        val RGBA_NV = VkCoverageModulationModeNV(3)
    }
}

typealias VkPipelineCoverageModulationStateCreateFlagsNV = VkFlags

// ..

inline class VkValidationCacheHeaderVersionEXT(val i: Int) {
    companion object {
        val ONE_EXT = VkValidationCacheHeaderVersionEXT(1)
    }
}

typealias VkValidationCacheCreateFlagsEXT = VkFlags

// ..

inline class VkDescriptorBindingEXT(val i: Int) {
    companion object {
        val UPDATE_AFTER_BIND_BIT_EXT = VkDescriptorBindingEXT(0x00000001)
        val UPDATE_UNUSED_WHILE_PENDING_BIT_EXT = VkDescriptorBindingEXT(0x00000002)
        val PARTIALLY_BOUND_BIT_EXT = VkDescriptorBindingEXT(0x00000004)
        val VARIABLE_DESCRIPTOR_COUNT_BIT_EXT = VkDescriptorBindingEXT(0x00000008)
    }
}

typealias VkDescriptorBindingFlagsEXT = VkFlags

// ..

inline class VkShadingRatePaletteEntryNV(val i: Int) {
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

inline class VkCoarseSampleOrderTypeNV(val i: Int) {
    companion object {
        val DEFAULT_NV = VkCoarseSampleOrderTypeNV(0)
        val CUSTOM_NV = VkCoarseSampleOrderTypeNV(1)
        val PIXEL_MAJOR_NV = VkCoarseSampleOrderTypeNV(2)
        val SAMPLE_MAJOR_NV = VkCoarseSampleOrderTypeNV(3)
    }
}

// ..

inline class VkRayTracingShaderGroupTypeNV(val i: Int) {
    companion object {
        val GENERAL_NV = VkRayTracingShaderGroupTypeNV(0)
        val TRIANGLES_HIT_GROUP_NV = VkRayTracingShaderGroupTypeNV(1)
        val PROCEDURAL_HIT_GROUP_NV = VkRayTracingShaderGroupTypeNV(2)
    }
}

inline class VkGeometryTypeNV(val i: Int) {
    companion object {
        val TRIANGLES_NV = VkGeometryTypeNV(0)
        val AABBS_NV = VkGeometryTypeNV(1)
    }
}

inline class VkAccelerationStructureTypeNV(val i: Int) {
    companion object {
        val TOP_LEVEL_NV = VkAccelerationStructureTypeNV(0)
        val BOTTOM_LEVEL_NV = VkAccelerationStructureTypeNV(1)
    }
}

inline class VkCopyAccelerationStructureModeNV(val i: Int) {
    companion object {
        val CLONE_NV = VkCopyAccelerationStructureModeNV(0)
        val COMPACT_NV = VkCopyAccelerationStructureModeNV(1)
    }
}

inline class VkAccelerationStructureMemoryRequirementsTypeNV(val i: Int) {
    companion object {
        val OBJECT_NV = VkAccelerationStructureMemoryRequirementsTypeNV(0)
        val BUILD_SCRATCH_NV = VkAccelerationStructureMemoryRequirementsTypeNV(1)
        val UPDATE_SCRATCH_NV = VkAccelerationStructureMemoryRequirementsTypeNV(2)
    }
}


inline class VkGeometryFlagNV(val i: Int) {
    companion object {
        val OPAQUE_BIT_NV = VkGeometryFlagNV(0x00000001)
        val NO_DUPLICATE_ANY_HIT_INVOCATION_BIT_NV = VkGeometryFlagNV(0x00000002)
    }
}

typealias VkGeometryFlagsNV = VkFlags

inline class VkGeometryInstanceNV(val i: Int) {
    companion object {
        val TRIANGLE_CULL_DISABLE_BIT_NV = VkGeometryInstanceNV(0x00000001)
        val TRIANGLE_FRONT_COUNTERCLOCKWISE_BIT_NV = VkGeometryInstanceNV(0x00000002)
        val FORCE_OPAQUE_BIT_NV = VkGeometryInstanceNV(0x00000004)
        val FORCE_NO_OPAQUE_BIT_NV = VkGeometryInstanceNV(0x00000008)
    }
}

typealias VkGeometryInstanceFlagsNV = VkFlags

inline class VkBuildAccelerationStructureNV(val i: Int) {
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

inline class VkQueueGlobalPriorityEXT(val i: Int) {
    companion object {
        val LOW_EXT = VkQueueGlobalPriorityEXT(128)
        val MEDIUM_EXT = VkQueueGlobalPriorityEXT(256)
        val HIGH_EXT = VkQueueGlobalPriorityEXT(512)
        val REALTIME_EXT = VkQueueGlobalPriorityEXT(1024)
    }
}

// ..

inline class VkTimeDomainEXT(val i: Int) {
    companion object {
        val DEVICE = VkTimeDomainEXT(0)
        val CLOCK_MONOTONIC = VkTimeDomainEXT(1)
        val CLOCK_MONOTONIC_RAW = VkTimeDomainEXT(2)
        val QUERY_PERFORMANCE_COUNTER = VkTimeDomainEXT(3)
    }
}

// ..

inline class VkMemoryOverallocationBehaviorAMD(val i: Int) {
    companion object {
        val DEFAULT_AMD = VkMemoryOverallocationBehaviorAMD(0)
        val ALLOWED_AMD = VkMemoryOverallocationBehaviorAMD(1)
        val DISALLOWED_AMD = VkMemoryOverallocationBehaviorAMD(2)
    }
}

// ..

inline class VkPipelineCreationFeedback(val i: Int) {
    companion object {
        val FEEDBACK_VALID_BIT_EXT = VkPipelineCreationFeedback(0x00000001)
        val APPLICATION_PIPELINE_CACHE_HIT_BIT_EXT = VkPipelineCreationFeedback(0x00000002)
        val FEEDBACK_BASE_PIPELINE_ACCELERATION_BIT_EXT = VkPipelineCreationFeedback(0x00000004)
    }
}

typealias VkPipelineCreationFeedbackFlagsEXT = VkFlags

// ..

inline class VkValidationFeatureEnableEXT(val i: Int) {
    companion object {
        val GPU_ASSISTED = VkValidationFeatureEnableEXT(0)
        val GPU_ASSISTED_RESERVE_BINDING_SLOT = VkValidationFeatureEnableEXT(1)
    }
}

inline class VkValidationFeatureDisableEXT(val i: Int) {
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

inline class VkComponentTypeNV(val i: Int) {
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


inline class VkScopeNV(val i: Int) {
    companion object {
        val DEVICE_NV = VkScopeNV(1)
        val WORKGROUP_NV = VkScopeNV(2)
        val SUBGROUP_NV = VkScopeNV(3)
        val QUEUE_FAMILY_NV = VkScopeNV(5)
    }
}

// ..

typealias VkHeadlessSurfaceCreateFlagsEXT = VkFlags