package vkk

import glm_.bool
import glm_.i
import kool.Ptr
import kool.adr
import org.lwjgl.vulkan.VkApplicationInfo
import org.lwjgl.vulkan.VkInstanceCreateInfo
import org.lwjgl.vulkan.VkPhysicalDeviceFeatures


inline class VkBlendOp(val i: Int) {
    companion object {
        val ADD = VkBlendOp(0)
        val SUBTRACT = VkBlendOp(1)
        val REVERSE_SUBTRACT = VkBlendOp(2)
        val MIN = VkBlendOp(3)
        val MAX = VkBlendOp(4)
        val ZERO_EXT = VkBlendOp(1000148000)
        val SRC_EXT = VkBlendOp(1000148001)
        val DST_EXT = VkBlendOp(1000148002)
        val SRC_OVER_EXT = VkBlendOp(1000148003)
        val DST_OVER_EXT = VkBlendOp(1000148004)
        val SRC_IN_EXT = VkBlendOp(1000148005)
        val DST_IN_EXT = VkBlendOp(1000148006)
        val SRC_OUT_EXT = VkBlendOp(1000148007)
        val DST_OUT_EXT = VkBlendOp(1000148008)
        val SRC_ATOP_EXT = VkBlendOp(1000148009)
        val DST_ATOP_EXT = VkBlendOp(1000148010)
        val XOR_EXT = VkBlendOp(1000148011)
        val MULTIPLY_EXT = VkBlendOp(1000148012)
        val SCREEN_EXT = VkBlendOp(1000148013)
        val OVERLAY_EXT = VkBlendOp(1000148014)
        val DARKEN_EXT = VkBlendOp(1000148015)
        val LIGHTEN_EXT = VkBlendOp(1000148016)
        val COLORDODGE_EXT = VkBlendOp(1000148017)
        val COLORBURN_EXT = VkBlendOp(1000148018)
        val HARDLIGHT_EXT = VkBlendOp(1000148019)
        val SOFTLIGHT_EXT = VkBlendOp(1000148020)
        val DIFFERENCE_EXT = VkBlendOp(1000148021)
        val EXCLUSION_EXT = VkBlendOp(1000148022)
        val INVERT_EXT = VkBlendOp(1000148023)
        val INVERT_RGB_EXT = VkBlendOp(1000148024)
        val LINEARDODGE_EXT = VkBlendOp(1000148025)
        val LINEARBURN_EXT = VkBlendOp(1000148026)
        val VIVIDLIGHT_EXT = VkBlendOp(1000148027)
        val LINEARLIGHT_EXT = VkBlendOp(1000148028)
        val PINLIGHT_EXT = VkBlendOp(1000148029)
        val HARDMIX_EXT = VkBlendOp(1000148030)
        val HSL_HUE_EXT = VkBlendOp(1000148031)
        val HSL_SATURATION_EXT = VkBlendOp(1000148032)
        val HSL_COLOR_EXT = VkBlendOp(1000148033)
        val HSL_LUMINOSITY_EXT = VkBlendOp(1000148034)
        val PLUS_EXT = VkBlendOp(1000148035)
        val PLUS_CLAMPED_EXT = VkBlendOp(1000148036)
        val PLUS_CLAMPED_ALPHA_EXT = VkBlendOp(1000148037)
        val PLUS_DARKER_EXT = VkBlendOp(1000148038)
        val MINUS_EXT = VkBlendOp(1000148039)
        val MINUS_CLAMPED_EXT = VkBlendOp(1000148040)
        val CONTRAST_EXT = VkBlendOp(1000148041)
        val INVERT_OVG_EXT = VkBlendOp(1000148042)
        val RED_EXT = VkBlendOp(1000148043)
        val GREEN_EXT = VkBlendOp(1000148044)
        val BLUE_EXT = VkBlendOp(1000148045)
    }
}


inline class VkDynamicState(val i: Int) {
    companion object {
        val VIEWPORT = VkDynamicState(0)
        val SCISSOR = VkDynamicState(1)
        val LINE_WIDTH = VkDynamicState(2)
        val DEPTH_BIAS = VkDynamicState(3)
        val BLEND_CONSTANTS = VkDynamicState(4)
        val DEPTH_BOUNDS = VkDynamicState(5)
        val STENCIL_COMPARE_MASK = VkDynamicState(6)
        val STENCIL_WRITE_MASK = VkDynamicState(7)
        val STENCIL_REFERENCE = VkDynamicState(8)
        val VIEWPORT_W_SCALING_NV = VkDynamicState(1000087000)
        val DISCARD_RECTANGLE_EXT = VkDynamicState(1000099000)
        val SAMPLE_LOCATIONS_EXT = VkDynamicState(1000143000)
        val VIEWPORT_SHADING_RATE_PALETTE_NV = VkDynamicState(1000164004)
        val VIEWPORT_COARSE_SAMPLE_ORDER_NV = VkDynamicState(1000164006)
        val EXCLUSIVE_SCISSOR_NV = VkDynamicState(1000205001)
    }
}


inline class VkFilter(val i: Int) {
    companion object {
        val NEAREST = VkFilter(0)
        val LINEAR = VkFilter(1)
        val CUBIC_IMG = VkFilter(1000015000)
        val CUBIC_EXT = VkFilter.CUBIC_IMG
    }
}

inline class VkSamplerMipmapMode(val i: Int) {
    companion object {
        val NEAREST = VkSamplerMipmapMode(0)
        val LINEAR = VkSamplerMipmapMode(1)
    }
}

inline class VkSamplerAddressMode(val i: Int) {
    companion object {
        val REPEAT = VkSamplerAddressMode(0)
        val MIRRORED_REPEAT = VkSamplerAddressMode(1)
        val CLAMP_TO_EDGE = VkSamplerAddressMode(2)
        val CLAMP_TO_BORDER = VkSamplerAddressMode(3)
        val MIRROR_CLAMP_TO_EDGE = VkSamplerAddressMode(4)
    }
}

inline class VkBorderColor(val i: Int) {
    companion object {
        val FLOAT_TRANSPARENT_BLACK = VkBorderColor(0)
        val INT_TRANSPARENT_BLACK = VkBorderColor(1)
        val FLOAT_OPAQUE_BLACK = VkBorderColor(2)
        val INT_OPAQUE_BLACK = VkBorderColor(3)
        val FLOAT_OPAQUE_WHITE = VkBorderColor(4)
        val INT_OPAQUE_WHITE = VkBorderColor(5)
    }
}

inline class VkDescriptorType(val i: Int) {
    companion object {
        val SAMPLER = VkDescriptorType(0)
        val COMBINED_IMAGE_SAMPLER = VkDescriptorType(1)
        val SAMPLED_IMAGE = VkDescriptorType(2)
        val STORAGE_IMAGE = VkDescriptorType(3)
        val UNIFORM_TEXEL_BUFFER = VkDescriptorType(4)
        val STORAGE_TEXEL_BUFFER = VkDescriptorType(5)
        val UNIFORM_BUFFER = VkDescriptorType(6)
        val STORAGE_BUFFER = VkDescriptorType(7)
        val UNIFORM_BUFFER_DYNAMIC = VkDescriptorType(8)
        val STORAGE_BUFFER_DYNAMIC = VkDescriptorType(9)
        val INPUT_ATTACHMENT = VkDescriptorType(10)
        val INLINE_UNIFORM_BLOCK_EXT = VkDescriptorType(1000138000)
        val ACCELERATION_STRUCTURE_NV = VkDescriptorType(1000165000)
    }
}

inline class VkAttachmentLoadOp(val i: Int) {
    companion object {
        val LOAD = VkAttachmentLoadOp(0)
        val CLEAR = VkAttachmentLoadOp(1)
        val DONT_CARE = VkAttachmentLoadOp(2)
    }
}


inline class VkAttachmentStoreOp(val i: Int) {
    companion object {
        val STORE = VkAttachmentStoreOp(0)
        val DONT_CARE = VkAttachmentStoreOp(1)
    }
}

inline class VkPipelineBindPoint(val i: Int) {
    companion object {
        val GRAPHICS = VkPipelineBindPoint(0)
        val COMPUTE = VkPipelineBindPoint(1)
        val RAY_TRACING_NV = VkPipelineBindPoint(1000165000)
    }
}


inline class VkCommandBufferLevel(val i: Int) {
    companion object {
        val PRIMARY = VkCommandBufferLevel(0)
        val SECONDARY = VkCommandBufferLevel(1)
    }
}

inline class VkIndexType(val i: Int) {
    companion object {
        val UINT16 = VkIndexType(0)
        val UINT32 = VkIndexType(1)
    }
}

inline class VkSubpassContents(val i: Int) {
    companion object {
        val INLINE = VkSubpassContents(0)
        val SECONDARY_COMMAND_BUFFERS = VkSubpassContents(1)
    }
}


inline class VkObjectType(val i: Int) {
    companion object {
        val UNKNOWN = VkObjectType(0)
        val INSTANCE = VkObjectType(1)
        val PHYSICAL_DEVICE = VkObjectType(2)
        val DEVICE = VkObjectType(3)
        val QUEUE = VkObjectType(4)
        val SEMAPHORE = VkObjectType(5)
        val COMMAND_BUFFER = VkObjectType(6)
        val FENCE = VkObjectType(7)
        val DEVICE_MEMORY = VkObjectType(8)
        val BUFFER = VkObjectType(9)
        val IMAGE = VkObjectType(10)
        val EVENT = VkObjectType(11)
        val QUERY_POOL = VkObjectType(12)
        val BUFFER_VIEW = VkObjectType(13)
        val IMAGE_VIEW = VkObjectType(14)
        val SHADER_MODULE = VkObjectType(15)
        val PIPELINE_CACHE = VkObjectType(16)
        val PIPELINE_LAYOUT = VkObjectType(17)
        val RENDER_PASS = VkObjectType(18)
        val PIPELINE = VkObjectType(19)
        val DESCRIPTOR_SET_LAYOUT = VkObjectType(20)
        val SAMPLER = VkObjectType(21)
        val DESCRIPTOR_POOL = VkObjectType(22)
        val DESCRIPTOR_SET = VkObjectType(23)
        val FRAMEBUFFER = VkObjectType(24)
        val COMMAND_POOL = VkObjectType(25)
        val SAMPLER_YCBCR_CONVERSION = VkObjectType(1000156000)
        val DESCRIPTOR_UPDATE_TEMPLATE = VkObjectType(1000085000)
        val SURFACE_KHR = VkObjectType(1000000000)
        val SWAPCHAIN_KHR = VkObjectType(1000001000)
        val DISPLAY_KHR = VkObjectType(1000002000)
        val DISPLAY_MODE_KHR = VkObjectType(1000002001)
        val DEBUG_REPORT_CALLBACK_EXT = VkObjectType(1000011000)
        val OBJECT_TABLE_NVX = VkObjectType(1000086000)
        val INDIRECT_COMMANDS_LAYOUT_NVX = VkObjectType(1000086001)
        val DEBUG_UTILS_MESSENGER_EXT = VkObjectType(1000128000)
        val VALIDATION_CACHE_EXT = VkObjectType(1000160000)
        val ACCELERATION_STRUCTURE_NV = VkObjectType(1000165000)
        val DESCRIPTOR_UPDATE_TEMPLATE_KHR = VkObjectType.DESCRIPTOR_UPDATE_TEMPLATE
        val SAMPLER_YCBCR_CONVERSION_KHR = VkObjectType.SAMPLER_YCBCR_CONVERSION
    }
}

inline class VkVendorId(val i: Int) {
    companion object {
        val VIV = VkVendorId(0x10001)
        val VSI = VkVendorId(0x10002)
        val KAZAN = VkVendorId(0x10003)
    }
}

typealias VkInstanceCreateFlags = VkFlags

inline class VkFormatFeature(val i: Int) {
    companion object {
        val SAMPLED_IMAGE_BIT = VkFormatFeature(0x00000001)
        val STORAGE_IMAGE_BIT = VkFormatFeature(0x00000002)
        val STORAGE_IMAGE_ATOMIC_BIT = VkFormatFeature(0x00000004)
        val UNIFORM_TEXEL_BUFFER_BIT = VkFormatFeature(0x00000008)
        val STORAGE_TEXEL_BUFFER_BIT = VkFormatFeature(0x00000010)
        val STORAGE_TEXEL_BUFFER_ATOMIC_BIT = VkFormatFeature(0x00000020)
        val VERTEX_BUFFER_BIT = VkFormatFeature(0x00000040)
        val COLOR_ATTACHMENT_BIT = VkFormatFeature(0x00000080)
        val COLOR_ATTACHMENT_BLEND_BIT = VkFormatFeature(0x00000100)
        val DEPTH_STENCIL_ATTACHMENT_BIT = VkFormatFeature(0x00000200)
        val BLIT_SRC_BIT = VkFormatFeature(0x00000400)
        val BLIT_DST_BIT = VkFormatFeature(0x00000800)
        val SAMPLED_IMAGE_FILTER_LINEAR_BIT = VkFormatFeature(0x00001000)
        val TRANSFER_SRC_BIT = VkFormatFeature(0x00004000)
        val TRANSFER_DST_BIT = VkFormatFeature(0x00008000)
        val MIDPOINT_CHROMA_SAMPLES_BIT = VkFormatFeature(0x00020000)
        val SAMPLED_IMAGE_YCBCR_CONVERSION_LINEAR_FILTER_BIT = VkFormatFeature(0x00040000)
        val SAMPLED_IMAGE_YCBCR_CONVERSION_SEPARATE_RECONSTRUCTION_FILTER_BIT = VkFormatFeature(0x00080000)
        val SAMPLED_IMAGE_YCBCR_CONVERSION_CHROMA_RECONSTRUCTION_EXPLICIT_BIT = VkFormatFeature(0x00100000)
        val SAMPLED_IMAGE_YCBCR_CONVERSION_CHROMA_RECONSTRUCTION_EXPLICIT_FORCEABLE_BIT = VkFormatFeature(0x00200000)
        val DISJOINT_BIT = VkFormatFeature(0x00400000)
        val COSITED_CHROMA_SAMPLES_BIT = VkFormatFeature(0x00800000)
        val SAMPLED_IMAGE_FILTER_CUBIC_BIT_IMG = VkFormatFeature(0x00002000)
        val SAMPLED_IMAGE_FILTER_MINMAX_BIT_EXT = VkFormatFeature(0x00010000)
        val FRAGMENT_DENSITY_MAP_BIT_EXT = VkFormatFeature(0x01000000)
        val TRANSFER_SRC_BIT_KHR = VkFormatFeature.TRANSFER_SRC_BIT
        val TRANSFER_DST_BIT_KHR = VkFormatFeature.TRANSFER_DST_BIT
        val MIDPOINT_CHROMA_SAMPLES_BIT_KHR = VkFormatFeature.MIDPOINT_CHROMA_SAMPLES_BIT
        val SAMPLED_IMAGE_YCBCR_CONVERSION_LINEAR_FILTER_BIT_KHR = VkFormatFeature.SAMPLED_IMAGE_YCBCR_CONVERSION_LINEAR_FILTER_BIT
        val SAMPLED_IMAGE_YCBCR_CONVERSION_SEPARATE_RECONSTRUCTION_FILTER_BIT_KHR = VkFormatFeature.SAMPLED_IMAGE_YCBCR_CONVERSION_SEPARATE_RECONSTRUCTION_FILTER_BIT
        val SAMPLED_IMAGE_YCBCR_CONVERSION_CHROMA_RECONSTRUCTION_EXPLICIT_BIT_KHR = VkFormatFeature.SAMPLED_IMAGE_YCBCR_CONVERSION_CHROMA_RECONSTRUCTION_EXPLICIT_BIT
        val SAMPLED_IMAGE_YCBCR_CONVERSION_CHROMA_RECONSTRUCTION_EXPLICIT_FORCEABLE_BIT_KHR = VkFormatFeature.SAMPLED_IMAGE_YCBCR_CONVERSION_CHROMA_RECONSTRUCTION_EXPLICIT_FORCEABLE_BIT
        val DISJOINT_BIT_KHR = VkFormatFeature.DISJOINT_BIT
        val COSITED_CHROMA_SAMPLES_BIT_KHR = VkFormatFeature.COSITED_CHROMA_SAMPLES_BIT
        val SAMPLED_IMAGE_FILTER_CUBIC_BIT_EXT = VkFormatFeature.SAMPLED_IMAGE_FILTER_CUBIC_BIT_IMG
    }
}

infix fun Int.has(f: VkFormatFeature) = and(f.i) != 0
infix fun Int.hasnt(f: VkFormatFeature) = and(f.i) == 0

typealias VkFormatFeatureFlags = VkFlags

inline class VkImageUsage(val i: Int) {
    companion object {
        val TRANSFER_SRC_BIT = VkImageUsage(0x00000001)
        val TRANSFER_DST_BIT = VkImageUsage(0x00000002)
        val SAMPLED_BIT = VkImageUsage(0x00000004)
        val STORAGE_BIT = VkImageUsage(0x00000008)
        val COLOR_ATTACHMENT_BIT = VkImageUsage(0x00000010)
        val DEPTH_STENCIL_ATTACHMENT_BIT = VkImageUsage(0x00000020)
        val TRANSIENT_ATTACHMENT_BIT = VkImageUsage(0x00000040)
        val INPUT_ATTACHMENT_BIT = VkImageUsage(0x00000080)
        val SHADING_RATE_IMAGE_BIT_NV = VkImageUsage(0x00000100)
        val FRAGMENT_DENSITY_MAP_BIT_EXT = VkImageUsage(0x00000200)
    }

    infix fun or(b: VkImageUsage): VkImageUsageFlags = i or b.i
}

infix fun Int.or(b: VkImageUsage): VkImageUsageFlags = or(b.i)
infix fun Int.has(b: VkImageUsage): Boolean = and(b.i) != 0
infix fun Int.hasnt(b: VkImageUsage): Boolean = and(b.i) == 0

typealias VkImageUsageFlags = VkFlags

inline class VkImageCreate(val i: Int) {
    companion object {
        val SPARSE_BINDING_BIT = VkImageCreate(0x00000001)
        val SPARSE_RESIDENCY_BIT = VkImageCreate(0x00000002)
        val SPARSE_ALIASED_BIT = VkImageCreate(0x00000004)
        val MUTABLE_FORMAT_BIT = VkImageCreate(0x00000008)
        val CUBE_COMPATIBLE_BIT = VkImageCreate(0x00000010)
        val ALIAS_BIT = VkImageCreate(0x00000400)
        val SPLIT_INSTANCE_BIND_REGIONS_BIT = VkImageCreate(0x00000040)
        val _2D_ARRAY_COMPATIBLE_BIT = VkImageCreate(0x00000020)
        val BLOCK_TEXEL_VIEW_COMPATIBLE_BIT = VkImageCreate(0x00000080)
        val EXTENDED_USAGE_BIT = VkImageCreate(0x00000100)
        val PROTECTED_BIT = VkImageCreate(0x00000800)
        val DISJOINT_BIT = VkImageCreate(0x00000200)
        val SAMPLE_LOCATIONS_COMPATIBLE_DEPTH_BIT_EXT = VkImageCreate(0x00001000)
        val SUBSAMPLED_BIT_EXT = VkImageCreate(0x00004000)
        val VK_IMAGE_CREATE_SPLIT_INSTANCE_BIND_REGIONS_BIT_KHR = VkImageCreate.SPLIT_INSTANCE_BIND_REGIONS_BIT
        val VK_IMAGE_CREATE_2D_ARRAY_COMPATIBLE_BIT_KHR = VkImageCreate._2D_ARRAY_COMPATIBLE_BIT
        val VK_IMAGE_CREATE_BLOCK_TEXEL_VIEW_COMPATIBLE_BIT_KHR = VkImageCreate.BLOCK_TEXEL_VIEW_COMPATIBLE_BIT
        val VK_IMAGE_CREATE_EXTENDED_USAGE_BIT_KHR = VkImageCreate.EXTENDED_USAGE_BIT
        val VK_IMAGE_CREATE_DISJOINT_BIT_KHR = VkImageCreate.DISJOINT_BIT
        val VK_IMAGE_CREATE_ALIAS_BIT_KHR = VkImageCreate.ALIAS_BIT
    }
}

typealias VkImageCreateFlags = VkFlags

inline class VkSampleCount(val i: Int) {
    companion object {
        val _1_BIT = VkSampleCount(0x00000001)
        val _2_BIT = VkSampleCount(0x00000002)
        val _4_BIT = VkSampleCount(0x00000004)
        val _8_BIT = VkSampleCount(0x00000008)
        val _16_BIT = VkSampleCount(0x00000010)
        val _32_BIT = VkSampleCount(0x00000020)
        val _64_BIT = VkSampleCount(0x00000040)
    }
}

typealias VkSampleCountFlags = VkFlags

inline class VkQueueFlag(val i: Int) {
    companion object {
        val GRAPHICS_BIT = VkQueueFlag(0x00000001)
        val COMPUTE_BIT = VkQueueFlag(0x00000002)
        val TRANSFER_BIT = VkQueueFlag(0x00000004)
        val SPARSE_BINDING_BIT = VkQueueFlag(0x00000008)
        val PROTECTED_BIT = VkQueueFlag(0x00000010)
    }

    infix fun or(b: VkQueueFlag): VkQueueFlags = i or b.i
}

infix fun Int.has(b: VkQueueFlag) = and(b.i) != 0
infix fun Int.hasnt(b: VkQueueFlag) = and(b.i) == 0

typealias VkQueueFlags = VkFlags

inline class VkMemoryProperty(val i: Int) {
    companion object {
        val DEVICE_LOCAL_BIT = VkMemoryProperty(0x00000001)
        val HOST_VISIBLE_BIT = VkMemoryProperty(0x00000002)
        val HOST_COHERENT_BIT = VkMemoryProperty(0x00000004)
        val HOST_CACHED_BIT = VkMemoryProperty(0x00000008)
        val LAZILY_ALLOCATED_BIT = VkMemoryProperty(0x00000010)
        val PROTECTED_BIT = VkMemoryProperty(0x00000020)
    }

    infix fun or(b: VkMemoryProperty): VkMemoryPropertyFlags = i or b.i
}

infix fun Int.has(b: VkMemoryProperty) = and(b.i) != 0
infix fun Int.hasnt(b: VkMemoryProperty) = and(b.i) == 0

typealias VkMemoryPropertyFlags = VkFlags

inline class VkMemoryHeapFlag(val i: Int) {
    companion object {
        val DEVICE_LOCAL_BIT = VkMemoryHeapFlag(0x00000001)
        val MULTI_INSTANCE_BIT = VkMemoryHeapFlag(0x00000002)
        val MULTI_INSTANCE_BIT_KHR = VkMemoryHeapFlag.MULTI_INSTANCE_BIT
    }
}
typealias VkMemoryHeapFlags = VkFlags
typealias VkDeviceCreateFlags = VkFlags

inline class VkDeviceQueueCreate(val i: Int) {
    companion object {
        val CREATE_PROTECTED_BIT = VkDeviceQueueCreate(0x00000001)
    }
}

typealias VkDeviceQueueCreateFlags = VkFlags

inline class VkPipelineStage(val i: Int) {
    companion object {
        val TOP_OF_PIPE_BIT = VkPipelineStage(0x00000001)
        val DRAW_INDIRECT_BIT = VkPipelineStage(0x00000002)
        val VERTEX_INPUT_BIT = VkPipelineStage(0x00000004)
        val VERTEX_SHADER_BIT = VkPipelineStage(0x00000008)
        val TESSELLATION_CONTROL_SHADER_BIT = VkPipelineStage(0x00000010)
        val TESSELLATION_EVALUATION_SHADER_BIT = VkPipelineStage(0x00000020)
        val GEOMETRY_SHADER_BIT = VkPipelineStage(0x00000040)
        val FRAGMENT_SHADER_BIT = VkPipelineStage(0x00000080)
        val EARLY_FRAGMENT_TESTS_BIT = VkPipelineStage(0x00000100)
        val LATE_FRAGMENT_TESTS_BIT = VkPipelineStage(0x00000200)
        val COLOR_ATTACHMENT_OUTPUT_BIT = VkPipelineStage(0x00000400)
        val COMPUTE_SHADER_BIT = VkPipelineStage(0x00000800)
        val TRANSFER_BIT = VkPipelineStage(0x00001000)
        val BOTTOM_OF_PIPE_BIT = VkPipelineStage(0x00002000)
        val HOST_BIT = VkPipelineStage(0x00004000)
        val ALL_GRAPHICS_BIT = VkPipelineStage(0x00008000)
        val ALL_COMMANDS_BIT = VkPipelineStage(0x00010000)
        val CONDITIONAL_RENDERING_BIT_EXT = VkPipelineStage(0x00040000)
        val COMMAND_PROCESS_BIT_NVX = VkPipelineStage(0x00020000)
        val SHADING_RATE_IMAGE_BIT_NV = VkPipelineStage(0x00400000)
        val RAY_TRACING_SHADER_BIT_NV = VkPipelineStage(0x00200000)
        val ACCELERATION_STRUCTURE_BUILD_BIT_NV = VkPipelineStage(0x02000000)
        val TASK_SHADER_BIT_NV = VkPipelineStage(0x00080000)
        val MESH_SHADER_BIT_NV = VkPipelineStage(0x00100000)
        val FRAGMENT_DENSITY_PROCESS_BIT_EXT = VkPipelineStage(0x00800000)
    }
}

typealias VkPipelineStageFlags = VkFlags

typealias VkMemoryMapFlags = VkFlags

inline class VkImageAspect(val i: Int) {
    companion object {
        val COLOR_BIT = VkImageAspect(0x00000001)
        val DEPTH_BIT = VkImageAspect(0x00000002)
        val STENCIL_BIT = VkImageAspect(0x00000004)
        val METADATA_BIT = VkImageAspect(0x00000008)
        val PLANE_0_BIT = VkImageAspect(0x00000010)
        val PLANE_1_BIT = VkImageAspect(0x00000020)
        val PLANE_2_BIT = VkImageAspect(0x00000040)
        val MEMORY_PLANE_0_BIT_EXT = VkImageAspect(0x00000080)
        val MEMORY_PLANE_1_BIT_EXT = VkImageAspect(0x00000100)
        val MEMORY_PLANE_2_BIT_EXT = VkImageAspect(0x00000200)
        val MEMORY_PLANE_3_BIT_EXT = VkImageAspect(0x00000400)
        val PLANE_0_BIT_KHR = VkImageAspect.PLANE_0_BIT
        val PLANE_1_BIT_KHR = VkImageAspect.PLANE_1_BIT
        val PLANE_2_BIT_KHR = VkImageAspect.PLANE_2_BIT
    }

    infix fun or(f: VkImageAspect) = i or f.i
}

typealias VkImageAspectFlags = VkFlags

inline class VkSparseImageFormat(val i: Int) {
    companion object {
        val SINGLE_MIPTAIL_BIT = VkSparseImageFormat(0x00000001)
        val ALIGNED_MIP_SIZE_BIT = VkSparseImageFormat(0x00000002)
        val NONSTANDARD_BLOCK_SIZE_BIT = VkSparseImageFormat(0x00000004)
    }
}
typealias VkSparseImageFormatFlags = VkFlags

inline class VkSparseMemoryBindFlag(val i: Int) {
    companion object {
        val METADATA_BIT = VkSparseMemoryBindFlag(0x00000001)
    }
}
typealias VkSparseMemoryBindFlags = VkFlags

inline class VkFenceCreate(val i: Int) {
    companion object {
        val SIGNALED_BIT = VkFenceCreate(0x00000001)
    }
}

typealias VkFenceCreateFlags = VkFlags
typealias VkSemaphoreCreateFlags = VkFlags
typealias VkEventCreateFlags = VkFlags
typealias VkQueryPoolCreateFlags = VkFlags

inline class VkQueryPipelineStatistic(val i: Int) {
    companion object {
        val INPUT_ASSEMBLY_VERTICES_BIT = VkQueryPipelineStatistic(0x00000001)
        val INPUT_ASSEMBLY_PRIMITIVES_BIT = VkQueryPipelineStatistic(0x00000002)
        val VERTEX_SHADER_INVOCATIONS_BIT = VkQueryPipelineStatistic(0x00000004)
        val GEOMETRY_SHADER_INVOCATIONS_BIT = VkQueryPipelineStatistic(0x00000008)
        val GEOMETRY_SHADER_PRIMITIVES_BIT = VkQueryPipelineStatistic(0x00000010)
        val CLIPPING_INVOCATIONS_BIT = VkQueryPipelineStatistic(0x00000020)
        val CLIPPING_PRIMITIVES_BIT = VkQueryPipelineStatistic(0x00000040)
        val FRAGMENT_SHADER_INVOCATIONS_BIT = VkQueryPipelineStatistic(0x00000080)
        val TESSELLATION_CONTROL_SHADER_PATCHES_BIT = VkQueryPipelineStatistic(0x00000100)
        val TESSELLATION_EVALUATION_SHADER_INVOCATIONS_BIT = VkQueryPipelineStatistic(0x00000200)
        val COMPUTE_SHADER_INVOCATIONS_BIT = VkQueryPipelineStatistic(0x00000400)
    }
}
typealias VkQueryPipelineStatisticFlags = VkFlags

inline class VkQueryResult(val i: Int) {
    companion object {
        val _64_BIT = VkQueryResult(0x00000001)
        val WAIT_BIT = VkQueryResult(0x00000002)
        val WITH_AVAILABILITY_BIT = VkQueryResult(0x00000004)
        val PARTIAL_BIT = VkQueryResult(0x00000008)
    }
}
typealias VkQueryResultFlags = VkFlags

inline class VkBufferCreate(val i: Int) {
    companion object {
        val SPARSE_BINDING_BIT = VkBufferCreate(0x00000001)
        val SPARSE_RESIDENCY_BIT = VkBufferCreate(0x00000002)
        val SPARSE_ALIASED_BIT = VkBufferCreate(0x00000004)
        val PROTECTED_BIT = VkBufferCreate(0x00000008)
        val DEVICE_ADDRESS_CAPTURE_REPLAY_BIT_EXT = VkBufferCreate(0x00000010)
    }
}

typealias VkBufferCreateFlags = VkFlags

inline class VkBufferUsage(val i: Int) {
    companion object {
        val TRANSFER_SRC_BIT = VkBufferUsage(0x00000001)
        val TRANSFER_DST_BIT = VkBufferUsage(0x00000002)
        val UNIFORM_TEXEL_BUFFER_BIT = VkBufferUsage(0x00000004)
        val STORAGE_TEXEL_BUFFER_BIT = VkBufferUsage(0x00000008)
        val UNIFORM_BUFFER_BIT = VkBufferUsage(0x00000010)
        val STORAGE_BUFFER_BIT = VkBufferUsage(0x00000020)
        val INDEX_BUFFER_BIT = VkBufferUsage(0x00000040)
        val VERTEX_BUFFER_BIT = VkBufferUsage(0x00000080)
        val INDIRECT_BUFFER_BIT = VkBufferUsage(0x00000100)
        val TRANSFORM_FEEDBACK_BUFFER_BIT_EXT = VkBufferUsage(0x00000800)
        val TRANSFORM_FEEDBACK_COUNTER_BUFFER_BIT_EXT = VkBufferUsage(0x00001000)
        val CONDITIONAL_RENDERING_BIT_EXT = VkBufferUsage(0x00000200)
        val RAY_TRACING_BIT_NV = VkBufferUsage(0x00000400)
        val SHADER_DEVICE_ADDRESS_BIT_EXT = VkBufferUsage(0x00020000)
    }

    infix fun or(f: VkBufferUsage): VkBufferCreateFlags = i or f.i
}

infix fun Int.or(f: VkBufferUsage): VkBufferCreateFlags = or(f.i)

typealias VkBufferUsageFlags = VkFlags
typealias VkBufferViewCreateFlags = VkFlags

inline class VkImageViewCreate(val i: Int) {
    companion object {
        val FRAGMENT_DENSITY_MAP_DYNAMIC_BIT_EXT = VkImageViewCreate(0x00000001)
    }
}

typealias VkImageViewCreateFlags = VkFlags
typealias VkShaderModuleCreateFlags = VkFlags
typealias VkPipelineCacheCreateFlags = VkFlags


inline class VkPipelineCreate(val i: Int) {
    companion object {
        val DISABLE_OPTIMIZATION_BIT = VkPipelineCreate(0x00000001)
        val ALLOW_DERIVATIVES_BIT = VkPipelineCreate(0x00000002)
        val DERIVATIVE_BIT = VkPipelineCreate(0x00000004)
        val VIEW_INDEX_FROM_DEVICE_INDEX_BIT = VkPipelineCreate(0x00000008)
        val DISPATCH_BASE = VkPipelineCreate(0x00000010)
        val DEFER_COMPILE_BIT_NV = VkPipelineCreate(0x00000020)
        val VIEW_INDEX_FROM_DEVICE_INDEX_BIT_KHR = VkPipelineCreate.VIEW_INDEX_FROM_DEVICE_INDEX_BIT
        val DISPATCH_BASE_KHR = VkPipelineCreate.DISPATCH_BASE
    }
}
typealias VkPipelineCreateFlags = VkFlags
typealias VkPipelineShaderStageCreateFlags = VkFlags

inline class VkShaderStage(val i: Int) {
    companion object {
        val VERTEX_BIT = VkShaderStage(0x00000001)
        val TESSELLATION_CONTROL_BIT = VkShaderStage(0x00000002)
        val TESSELLATION_EVALUATION_BIT = VkShaderStage(0x00000004)
        val GEOMETRY_BIT = VkShaderStage(0x00000008)
        val FRAGMENT_BIT = VkShaderStage(0x00000010)
        val COMPUTE_BIT = VkShaderStage(0x00000020)
        val ALL_GRAPHICS = VkShaderStage(0x0000001F)
        val ALL = VkShaderStage(0x7FFFFFFF)
        val RAYGEN_BIT_NV = VkShaderStage(0x00000100)
        val ANY_HIT_BIT_NV = VkShaderStage(0x00000200)
        val CLOSEST_HIT_BIT_NV = VkShaderStage(0x00000400)
        val MISS_BIT_NV = VkShaderStage(0x00000800)
        val INTERSECTION_BIT_NV = VkShaderStage(0x00001000)
        val CALLABLE_BIT_NV = VkShaderStage(0x00002000)
        val TASK_BIT_NV = VkShaderStage(0x00000040)
        val MESH_BIT_NV = VkShaderStage(0x00000080)
    }
}


typealias VkPipelineVertexInputStateCreateFlags = VkFlags
typealias VkPipelineInputAssemblyStateCreateFlags = VkFlags
typealias VkPipelineTessellationStateCreateFlags = VkFlags
typealias VkPipelineViewportStateCreateFlags = VkFlags
typealias VkPipelineRasterizationStateCreateFlags = VkFlags


inline class VkCullMode(val i: Int) {
    companion object {
        val NONE = VkCullMode(0)
        val FRONT_BIT = VkCullMode(0x00000001)
        val BACK_BIT = VkCullMode(0x00000002)
        val FRONT_AND_BACK = VkCullMode(0x00000003)
    }
}

typealias VkCullModeFlags = VkFlags
typealias VkPipelineMultisampleStateCreateFlags = VkFlags
typealias VkPipelineDepthStencilStateCreateFlags = VkFlags
typealias VkPipelineColorBlendStateCreateFlags = VkFlags

inline class VkColorComponent(val i: Int) {
    companion object {
        val R_BIT = VkColorComponent(0x00000001)
        val G_BIT = VkColorComponent(0x00000002)
        val B_BIT = VkColorComponent(0x00000004)
        val A_BIT = VkColorComponent(0x00000008)
    }
}

infix fun VkColorComponent.or(f: VkColorComponent): VkColorComponentFlags = i or f.i
infix fun Int.or(f: VkColorComponent): VkColorComponentFlags = or(f.i)


typealias VkColorComponentFlags = VkFlags
typealias VkPipelineDynamicStateCreateFlags = VkFlags
typealias VkPipelineLayoutCreateFlags = VkFlags
typealias VkShaderStageFlags = VkFlags


inline class VkSamplerCreate(val i: Int) {
    companion object {
        val SUBSAMPLED_BIT_EXT = VkSamplerCreate(0x00000001)
        val SUBSAMPLED_COARSE_RECONSTRUCTION_BIT_EXT = VkSamplerCreate(0x00000002)
        val FLAG_BITS_MAX_ENUM = VkSamplerCreate(0x7FFFFFFF)
    }
}


typealias VkSamplerCreateFlags = VkFlags

inline class VkDescriptorSetLayoutCreate(val i: Int) {
    companion object {
        val PUSH_DESCRIPTOR_BIT_KHR = VkDescriptorSetLayoutCreate(0x00000001)
        val UPDATE_AFTER_BIND_POOL_BIT_EXT = VkDescriptorSetLayoutCreate(0x00000002)
    }
}

typealias VkDescriptorSetLayoutCreateFlags = VkFlags

inline class VkDescriptorPoolCreate(val i: Int) {
    companion object {
        val FREE_DESCRIPTOR_SET_BIT = VkDescriptorPoolCreate(0x00000001)
        val UPDATE_AFTER_BIND_BIT_EXT = VkDescriptorPoolCreate(0x00000002)
    }
}

typealias VkDescriptorPoolCreateFlags = VkFlags
typealias VkDescriptorPoolResetFlags = VkFlags
typealias VkFramebufferCreateFlags = VkFlags
typealias VkRenderPassCreateFlags = VkFlags

inline class VkAttachmentDescriptionFlag(val i: Int) {
    companion object {
        val MAY_ALIAS_BIT = VkAttachmentDescriptionFlag(0x00000001)
    }
}

typealias VkAttachmentDescriptionFlags = VkFlags


inline class VkSubpassDescriptionFlag(val i: Int) {
    companion object {
        val PER_VIEW_ATTRIBUTES_BIT_NVX = VkSubpassDescriptionFlag(0x00000001)
        val PER_VIEW_POSITION_X_ONLY_BIT_NVX = VkSubpassDescriptionFlag(0x00000002)
    }
}

typealias VkSubpassDescriptionFlags = VkFlags

inline class VkAccess(val i: Int) {
    companion object {
        val INDIRECT_COMMAND_READ_BIT = VkAccess(0x00000001)
        val INDEX_READ_BIT = VkAccess(0x00000002)
        val VERTEX_ATTRIBUTE_READ_BIT = VkAccess(0x00000004)
        val UNIFORM_READ_BIT = VkAccess(0x00000008)
        val INPUT_ATTACHMENT_READ_BIT = VkAccess(0x00000010)
        val SHADER_READ_BIT = VkAccess(0x00000020)
        val SHADER_WRITE_BIT = VkAccess(0x00000040)
        val COLOR_ATTACHMENT_READ_BIT = VkAccess(0x00000080)
        val COLOR_ATTACHMENT_WRITE_BIT = VkAccess(0x00000100)
        val DEPTH_STENCIL_ATTACHMENT_READ_BIT = VkAccess(0x00000200)
        val DEPTH_STENCIL_ATTACHMENT_WRITE_BIT = VkAccess(0x00000400)
        val TRANSFER_READ_BIT = VkAccess(0x00000800)
        val TRANSFER_WRITE_BIT = VkAccess(0x00001000)
        val HOST_READ_BIT = VkAccess(0x00002000)
        val HOST_WRITE_BIT = VkAccess(0x00004000)
        val MEMORY_READ_BIT = VkAccess(0x00008000)
        val MEMORY_WRITE_BIT = VkAccess(0x00010000)
        val CONDITIONAL_RENDERING_READ_BIT_EXT = VkAccess(0x00100000)
        val COMMAND_PROCESS_READ_BIT_NVX = VkAccess(0x00020000)
        val COMMAND_PROCESS_WRITE_BIT_NVX = VkAccess(0x00040000)
        val COLOR_ATTACHMENT_READ_NONCOHERENT_BIT_EXT = VkAccess(0x00080000)
        val SHADING_RATE_IMAGE_READ_BIT_NV = VkAccess(0x00800000)
        val ACCELERATION_STRUCTURE_READ_BIT_NV = VkAccess(0x00200000)
        val ACCELERATION_STRUCTURE_WRITE_BIT_NV = VkAccess(0x00400000)
        val FRAGMENT_DENSITY_MAP_READ_BIT_EXT = VkAccess(0x01000000)
    }

    infix fun or(f: VkAccess) = i or f.i
}

infix fun Int.or(f: VkAccess) = or(f.i)

typealias VkAccessFlags = VkFlags

inline class VkDependency(val i: Int) {
    companion object {
        val BY_REGION_BIT = VkDependency(0x00000001)
        val VIEW_LOCAL_BIT = VkDependency(0x00000002)
        val DEVICE_GROUP_BIT = VkDependency(0x00000004)
        val VIEW_LOCAL_BIT_KHR = VkDependency.VIEW_LOCAL_BIT
        val DEVICE_GROUP_BIT_KHR = VkDependency.DEVICE_GROUP_BIT
    }
}

typealias VkDependencyFlags = VkFlags

inline class VkCommandPoolCreate(val i: Int) {
    companion object {
        val TRANSIENT_BIT = VkCommandPoolCreate(0x00000001)
        val RESET_COMMAND_BUFFER_BIT = VkCommandPoolCreate(0x00000002)
        val PROTECTED_BIT = VkCommandPoolCreate(0x00000004)
    }
}

typealias VkCommandPoolCreateFlags = VkFlags

inline class VkCommandPoolReset(val i: Int) {
    companion object {
        val RELEASE_RESOURCES_BIT = VkCommandPoolReset(0x00000001)
    }
}
typealias VkCommandPoolResetFlags = VkFlags

inline class VkCommandBufferUsage(val i: Int) {
    companion object {
        val ONE_TIME_SUBMIT_BIT = VkCommandBufferUsage(0x00000001)
        val RENDER_PASS_CONTINUE_BIT = VkCommandBufferUsage(0x00000002)
        val SIMULTANEOUS_USE_BIT = VkCommandBufferUsage(0x00000004)
    }
}

infix fun Int.or(f: VkCommandBufferUsage) = or(f.i)

typealias VkCommandBufferUsageFlags = VkFlags


inline class VkQueryControl(val i: Int) {
    companion object {
        val PRECISE_BIT = VkQueryControl(0x00000001)
    }
}
typealias VkQueryControlFlags = VkFlags

inline class VkCommandBufferReset(val i: Int) {
    companion object {
        val RELEASE_RESOURCES_BIT = VkCommandBufferReset(0x00000001)
    }
}
typealias VkCommandBufferResetFlags = VkFlags

inline class VkStencilFace(val i: Int) {
    companion object {
        val FRONT_BIT = VkStencilFace(0x00000001)
        val BACK_BIT = VkStencilFace(0x00000002)
        val FRONT_AND_BACK = VkStencilFace(0x00000003)
    }
}
typealias VkStencilFaceFlags = VkFlags

inline var VkApplicationInfo.type: VkStructureType
    get() = VkStructureType(VkApplicationInfo.nsType(adr))
    set(value) = VkApplicationInfo.nsType(adr, value.i)
inline var VkApplicationInfo.next: Ptr
    get() = VkApplicationInfo.npNext(adr)
    set(value) = VkApplicationInfo.npNext(adr, value)
inline var VkApplicationInfo.applicationName: String?
    get() = VkApplicationInfo.npApplicationNameString(adr)
    set(value) = VkApplicationInfo.npApplicationName(adr, value?.toUtf8Stack())
inline var VkApplicationInfo.applicationVersion: Int
    get() = VkApplicationInfo.napplicationVersion(adr)
    set(value) = VkApplicationInfo.napiVersion(adr, value)
inline var VkApplicationInfo.engineName: String?
    get() = VkApplicationInfo.npEngineNameString(adr)
    set(value) = VkApplicationInfo.npEngineName(adr, value?.toUtf8Stack())
inline var VkApplicationInfo.apiVersion: Int
    get() = VkApplicationInfo.napiVersion(adr)
    set(value) = VkApplicationInfo.napiVersion(adr, value)


inline var VkInstanceCreateInfo.type: VkStructureType
    get() = VkStructureType(VkInstanceCreateInfo.nsType(adr))
    set(value) = VkInstanceCreateInfo.nsType(adr, value.i)
inline var VkInstanceCreateInfo.next: Ptr
    get() = VkInstanceCreateInfo.npNext(adr)
    set(value) = VkInstanceCreateInfo.npNext(adr, value)
inline var VkInstanceCreateInfo.flags: VkInstanceCreateFlags
    get() = VkInstanceCreateInfo.nflags(adr)
    set(value) = VkInstanceCreateInfo.nflags(adr, value)
inline var VkInstanceCreateInfo.applicationInfo: VkApplicationInfo?
    get() = VkInstanceCreateInfo.npApplicationInfo(adr)
    set(value) = VkInstanceCreateInfo.npApplicationInfo(adr, value)
inline var VkInstanceCreateInfo.enabledLayerNames: Collection<String>
    get() = VkInstanceCreateInfo.nppEnabledLayerNames(adr)?.toArrayList() ?: arrayListOf()
    set(value) = VkInstanceCreateInfo.nppEnabledLayerNames(adr, value.toPointerBufferStack())
inline var VkInstanceCreateInfo.enabledExtensionNames: Collection<String>
    get() = VkInstanceCreateInfo.nppEnabledExtensionNames(adr)?.toArrayList() ?: arrayListOf()
    set(value) = VkInstanceCreateInfo.nppEnabledExtensionNames(adr, value.toPointerBufferStack())


//typedef struct VkAllocationCallbacks {
//    void*                                   pUserData;
//    PFN_vkAllocationFunction                pfnAllocation;
//    PFN_vkReallocationFunction              pfnReallocation;
//    PFN_vkFreeFunction                      pfnFree;
//    PFN_vkInternalAllocationNotification    pfnInternalAllocation;
//    PFN_vkInternalFreeNotification          pfnInternalFree;
//} VkAllocationCallbacks;


inline var VkPhysicalDeviceFeatures.robustBufferAccess: Boolean
    get() = VkPhysicalDeviceFeatures.nrobustBufferAccess(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nrobustBufferAccess(adr, value.i)
inline var VkPhysicalDeviceFeatures.fullDrawIndexUint32: Boolean
    get() = VkPhysicalDeviceFeatures.nfullDrawIndexUint32(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nfullDrawIndexUint32(adr, value.i)
inline var VkPhysicalDeviceFeatures.imageCubeArray: Boolean
    get() = VkPhysicalDeviceFeatures.nimageCubeArray(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nimageCubeArray(adr, value.i)
inline var VkPhysicalDeviceFeatures.independentBlend: Boolean
    get() = VkPhysicalDeviceFeatures.nindependentBlend(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nindependentBlend(adr, value.i)
inline var VkPhysicalDeviceFeatures.geometryShader: Boolean
    get() = VkPhysicalDeviceFeatures.ngeometryShader(adr).bool
    set(value) = VkPhysicalDeviceFeatures.ngeometryShader(adr, value.i)
inline var VkPhysicalDeviceFeatures.tessellationShader: Boolean
    get() = VkPhysicalDeviceFeatures.ntessellationShader(adr).bool
    set(value) = VkPhysicalDeviceFeatures.ntessellationShader(adr, value.i)
inline var VkPhysicalDeviceFeatures.sampleRateShading: Boolean
    get() = VkPhysicalDeviceFeatures.nsampleRateShading(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nsampleRateShading(adr, value.i)
inline var VkPhysicalDeviceFeatures.dualSrcBlend: Boolean
    get() = VkPhysicalDeviceFeatures.ndualSrcBlend(adr).bool
    set(value) = VkPhysicalDeviceFeatures.ndualSrcBlend(adr, value.i)
inline var VkPhysicalDeviceFeatures.logicOp: Boolean
    get() = VkPhysicalDeviceFeatures.nlogicOp(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nlogicOp(adr, value.i)
inline var VkPhysicalDeviceFeatures.multiDrawIndirect: Boolean
    get() = VkPhysicalDeviceFeatures.nmultiDrawIndirect(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nmultiDrawIndirect(adr, value.i)
inline var VkPhysicalDeviceFeatures.drawIndirectFirstInstance: Boolean
    get() = VkPhysicalDeviceFeatures.ndrawIndirectFirstInstance(adr).bool
    set(value) = VkPhysicalDeviceFeatures.ndrawIndirectFirstInstance(adr, value.i)
inline var VkPhysicalDeviceFeatures.depthClamp: Boolean
    get() = VkPhysicalDeviceFeatures.ndepthClamp(adr).bool
    set(value) = VkPhysicalDeviceFeatures.ndepthClamp(adr, value.i)
inline var VkPhysicalDeviceFeatures.depthBiasClamp: Boolean
    get() = VkPhysicalDeviceFeatures.ndepthBiasClamp(adr).bool
    set(value) = VkPhysicalDeviceFeatures.ndepthBiasClamp(adr, value.i)
inline var VkPhysicalDeviceFeatures.fillModeNonSolid: Boolean
    get() = VkPhysicalDeviceFeatures.nfillModeNonSolid(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nfillModeNonSolid(adr, value.i)
inline var VkPhysicalDeviceFeatures.depthBounds: Boolean
    get() = VkPhysicalDeviceFeatures.ndepthBounds(adr).bool
    set(value) = VkPhysicalDeviceFeatures.ndepthBounds(adr, value.i)
inline var VkPhysicalDeviceFeatures.wideLines: Boolean
    get() = VkPhysicalDeviceFeatures.nwideLines(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nwideLines(adr, value.i)
inline var VkPhysicalDeviceFeatures.largePoints: Boolean
    get() = VkPhysicalDeviceFeatures.nlargePoints(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nlargePoints(adr, value.i)
inline var VkPhysicalDeviceFeatures.alphaToOne: Boolean
    get() = VkPhysicalDeviceFeatures.nalphaToOne(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nalphaToOne(adr, value.i)
inline var VkPhysicalDeviceFeatures.multiViewport: Boolean
    get() = VkPhysicalDeviceFeatures.nmultiViewport(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nmultiViewport(adr, value.i)
inline var VkPhysicalDeviceFeatures.samplerAnisotropy: Boolean
    get() = VkPhysicalDeviceFeatures.nsamplerAnisotropy(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nsamplerAnisotropy(adr, value.i)
inline var VkPhysicalDeviceFeatures.textureCompressionETC2: Boolean
    get() = VkPhysicalDeviceFeatures.ntextureCompressionETC2(adr).bool
    set(value) = VkPhysicalDeviceFeatures.ntextureCompressionETC2(adr, value.i)
inline var VkPhysicalDeviceFeatures.textureCompressionASTC_LDR: Boolean
    get() = VkPhysicalDeviceFeatures.ntextureCompressionASTC_LDR(adr).bool
    set(value) = VkPhysicalDeviceFeatures.ntextureCompressionASTC_LDR(adr, value.i)
inline var VkPhysicalDeviceFeatures.textureCompressionBC: Boolean
    get() = VkPhysicalDeviceFeatures.ntextureCompressionBC(adr).bool
    set(value) = VkPhysicalDeviceFeatures.ntextureCompressionBC(adr, value.i)
inline var VkPhysicalDeviceFeatures.occlusionQueryPrecise: Boolean
    get() = VkPhysicalDeviceFeatures.nocclusionQueryPrecise(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nocclusionQueryPrecise(adr, value.i)
inline var VkPhysicalDeviceFeatures.pipelineStatisticsQuery: Boolean
    get() = VkPhysicalDeviceFeatures.npipelineStatisticsQuery(adr).bool
    set(value) = VkPhysicalDeviceFeatures.npipelineStatisticsQuery(adr, value.i)
inline var VkPhysicalDeviceFeatures.vertexPipelineStoresAndAtomics: Boolean
    get() = VkPhysicalDeviceFeatures.nvertexPipelineStoresAndAtomics(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nvertexPipelineStoresAndAtomics(adr, value.i)
inline var VkPhysicalDeviceFeatures.fragmentStoresAndAtomics: Boolean
    get() = VkPhysicalDeviceFeatures.nfragmentStoresAndAtomics(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nfragmentStoresAndAtomics(adr, value.i)
inline var VkPhysicalDeviceFeatures.shaderTessellationAndGeometryPointSize: Boolean
    get() = VkPhysicalDeviceFeatures.nshaderTessellationAndGeometryPointSize(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nshaderTessellationAndGeometryPointSize(adr, value.i)
inline var VkPhysicalDeviceFeatures.shaderImageGatherExtended: Boolean
    get() = VkPhysicalDeviceFeatures.nshaderImageGatherExtended(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nshaderImageGatherExtended(adr, value.i)
inline var VkPhysicalDeviceFeatures.shaderStorageImageExtendedFormats: Boolean
    get() = VkPhysicalDeviceFeatures.nshaderStorageImageExtendedFormats(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nshaderStorageImageExtendedFormats(adr, value.i)
inline var VkPhysicalDeviceFeatures.shaderStorageImageMultisample: Boolean
    get() = VkPhysicalDeviceFeatures.nshaderStorageImageMultisample(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nshaderStorageImageMultisample(adr, value.i)
inline var VkPhysicalDeviceFeatures.shaderStorageImageReadWithoutFormat: Boolean
    get() = VkPhysicalDeviceFeatures.nshaderStorageImageReadWithoutFormat(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nshaderStorageImageReadWithoutFormat(adr, value.i)
inline var VkPhysicalDeviceFeatures.shaderStorageImageWriteWithoutFormat: Boolean
    get() = VkPhysicalDeviceFeatures.nshaderStorageImageWriteWithoutFormat(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nshaderStorageImageWriteWithoutFormat(adr, value.i)
inline var VkPhysicalDeviceFeatures.shaderUniformBufferArrayDynamicIndexing: Boolean
    get() = VkPhysicalDeviceFeatures.nshaderUniformBufferArrayDynamicIndexing(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nshaderUniformBufferArrayDynamicIndexing(adr, value.i)
inline var VkPhysicalDeviceFeatures.shaderSampledImageArrayDynamicIndexing: Boolean
    get() = VkPhysicalDeviceFeatures.nshaderSampledImageArrayDynamicIndexing(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nshaderSampledImageArrayDynamicIndexing(adr, value.i)
inline var VkPhysicalDeviceFeatures.shaderStorageBufferArrayDynamicIndexing: Boolean
    get() = VkPhysicalDeviceFeatures.nshaderStorageBufferArrayDynamicIndexing(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nshaderStorageBufferArrayDynamicIndexing(adr, value.i)
inline var VkPhysicalDeviceFeatures.shaderStorageImageArrayDynamicIndexing: Boolean
    get() = VkPhysicalDeviceFeatures.nshaderStorageImageArrayDynamicIndexing(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nshaderStorageImageArrayDynamicIndexing(adr, value.i)
inline var VkPhysicalDeviceFeatures.shaderClipDistance: Boolean
    get() = VkPhysicalDeviceFeatures.nshaderClipDistance(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nshaderClipDistance(adr, value.i)
inline var VkPhysicalDeviceFeatures.shaderCullDistance: Boolean
    get() = VkPhysicalDeviceFeatures.nshaderCullDistance(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nshaderCullDistance(adr, value.i)
inline var VkPhysicalDeviceFeatures.shaderFloat64: Boolean
    get() = VkPhysicalDeviceFeatures.nshaderFloat64(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nshaderFloat64(adr, value.i)
inline var VkPhysicalDeviceFeatures.shaderInt64: Boolean
    get() = VkPhysicalDeviceFeatures.nshaderInt64(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nshaderInt64(adr, value.i)
inline var VkPhysicalDeviceFeatures.shaderInt16: Boolean
    get() = VkPhysicalDeviceFeatures.nshaderInt16(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nshaderInt16(adr, value.i)
inline var VkPhysicalDeviceFeatures.shaderResourceResidency: Boolean
    get() = VkPhysicalDeviceFeatures.nshaderResourceResidency(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nshaderResourceResidency(adr, value.i)
inline var VkPhysicalDeviceFeatures.shaderResourceMinLod: Boolean
    get() = VkPhysicalDeviceFeatures.nshaderResourceMinLod(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nshaderResourceMinLod(adr, value.i)
inline var VkPhysicalDeviceFeatures.sparseBinding: Boolean
    get() = VkPhysicalDeviceFeatures.nsparseBinding(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nsparseBinding(adr, value.i)
inline var VkPhysicalDeviceFeatures.sparseResidencyBuffer: Boolean
    get() = VkPhysicalDeviceFeatures.nsparseResidencyBuffer(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nsparseResidencyBuffer(adr, value.i)
inline var VkPhysicalDeviceFeatures.sparseResidencyImage2D: Boolean
    get() = VkPhysicalDeviceFeatures.nsparseResidencyImage2D(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nsparseResidencyImage2D(adr, value.i)
inline var VkPhysicalDeviceFeatures.sparseResidencyImage3D: Boolean
    get() = VkPhysicalDeviceFeatures.nsparseResidencyImage3D(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nsparseResidencyImage3D(adr, value.i)
inline var VkPhysicalDeviceFeatures.sparseResidency2Samples: Boolean
    get() = VkPhysicalDeviceFeatures.nsparseResidency2Samples(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nsparseResidency2Samples(adr, value.i)
inline var VkPhysicalDeviceFeatures.sparseResidency4Samples: Boolean
    get() = VkPhysicalDeviceFeatures.nsparseResidency4Samples(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nsparseResidency4Samples(adr, value.i)
inline var VkPhysicalDeviceFeatures.sparseResidency8Samples: Boolean
    get() = VkPhysicalDeviceFeatures.nsparseResidency8Samples(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nsparseResidency8Samples(adr, value.i)
inline var VkPhysicalDeviceFeatures.sparseResidency16Samples: Boolean
    get() = VkPhysicalDeviceFeatures.nsparseResidency16Samples(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nrobustBufferAccess(adr, value.i)
inline var VkPhysicalDeviceFeatures.sparseResidencyAliased: Boolean
    get() = VkPhysicalDeviceFeatures.nsparseResidencyAliased(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nsparseResidencyAliased(adr, value.i)
inline var VkPhysicalDeviceFeatures.variableMultisampleRate: Boolean
    get() = VkPhysicalDeviceFeatures.nvariableMultisampleRate(adr).bool
    set(value) = VkPhysicalDeviceFeatures.nvariableMultisampleRate(adr, value.i)
inline var VkPhysicalDeviceFeatures.inheritedQueries: Boolean
    get() = VkPhysicalDeviceFeatures.ninheritedQueries(adr).bool
    set(value) = VkPhysicalDeviceFeatures.ninheritedQueries(adr, value.i)