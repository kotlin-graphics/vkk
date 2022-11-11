package vkk

import glm_.bool
import glm_.i
import kool.Ptr
import kool.adr
import org.lwjgl.vulkan.VkApplicationInfo
import org.lwjgl.vulkan.VkInstanceCreateInfo
import org.lwjgl.vulkan.VkPhysicalDeviceFeatures


@JvmInline
value class VkLogicOp(val i: Int) {
    companion object {
        val CLEAR = VkLogicOp(0)
        val AND = VkLogicOp(1)
        val AND_REVERSE = VkLogicOp(2)
        val COPY = VkLogicOp(3)
        val AND_INVERTED = VkLogicOp(4)
        val NO_OP = VkLogicOp(5)
        val XOR = VkLogicOp(6)
        val OR = VkLogicOp(7)
        val NOR = VkLogicOp(8)
        val EQUIVALENT = VkLogicOp(9)
        val INVERT = VkLogicOp(10)
        val OR_REVERSE = VkLogicOp(11)
        val COPY_INVERTED = VkLogicOp(12)
        val OR_INVERTED = VkLogicOp(13)
        val NAND = VkLogicOp(14)
        val SET = VkLogicOp(15)
    }
}

@JvmInline
value class VkBlendFactor(val i: Int) {
    companion object {
        val ZERO = VkBlendFactor(0)
        val ONE = VkBlendFactor(1)
        val SRC_COLOR = VkBlendFactor(2)
        val ONE_MINUS_SRC_COLOR = VkBlendFactor(3)
        val DST_COLOR = VkBlendFactor(4)
        val ONE_MINUS_DST_COLOR = VkBlendFactor(5)
        val SRC_ALPHA = VkBlendFactor(6)
        val ONE_MINUS_SRC_ALPHA = VkBlendFactor(7)
        val DST_ALPHA = VkBlendFactor(8)
        val ONE_MINUS_DST_ALPHA = VkBlendFactor(9)
        val CONSTANT_COLOR = VkBlendFactor(10)
        val ONE_MINUS_CONSTANT_COLOR = VkBlendFactor(11)
        val CONSTANT_ALPHA = VkBlendFactor(12)
        val ONE_MINUS_CONSTANT_ALPHA = VkBlendFactor(13)
        val SRC_ALPHA_SATURATE = VkBlendFactor(14)
        val SRC1_COLOR = VkBlendFactor(15)
        val ONE_MINUS_SRC1_COLOR = VkBlendFactor(16)
        val SRC1_ALPHA = VkBlendFactor(17)
        val ONE_MINUS_SRC1_ALPHA = VkBlendFactor(18)
    }
}

@JvmInline
value class VkBlendOp(val i: Int) {
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


@JvmInline
value class VkDynamicState(val i: Int) {
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


@JvmInline
value class VkFilter(val i: Int) {
    companion object {
        val NEAREST = VkFilter(0)
        val LINEAR = VkFilter(1)
        val CUBIC_IMG = VkFilter(1000015000)
        val CUBIC_EXT = VkFilter.CUBIC_IMG
    }
}

@JvmInline
value class VkSamplerMipmapMode(val i: Int) {
    companion object {
        val NEAREST = VkSamplerMipmapMode(0)
        val LINEAR = VkSamplerMipmapMode(1)
    }
}

@JvmInline
value class VkSamplerAddressMode(val i: Int) {
    companion object {
        val REPEAT = VkSamplerAddressMode(0)
        val MIRRORED_REPEAT = VkSamplerAddressMode(1)
        val CLAMP_TO_EDGE = VkSamplerAddressMode(2)
        val CLAMP_TO_BORDER = VkSamplerAddressMode(3)
        val MIRROR_CLAMP_TO_EDGE = VkSamplerAddressMode(4)
    }
}

@JvmInline
value class VkBorderColor(val i: Int) {
    companion object {
        val FLOAT_TRANSPARENT_BLACK = VkBorderColor(0)
        val INT_TRANSPARENT_BLACK = VkBorderColor(1)
        val FLOAT_OPAQUE_BLACK = VkBorderColor(2)
        val INT_OPAQUE_BLACK = VkBorderColor(3)
        val FLOAT_OPAQUE_WHITE = VkBorderColor(4)
        val INT_OPAQUE_WHITE = VkBorderColor(5)
    }
}

@JvmInline
value class VkDescriptorType(val i: Int) {
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

//@JvmInline
//value class VkAttachmentLoadOp(val i: Int) {
//    companion object {
//        val LOAD = VkAttachmentLoadOp(0)
//        val CLEAR = VkAttachmentLoadOp(1)
//        val DONT_CARE = VkAttachmentLoadOp(2)
//    }
//}


//@JvmInline
//value class VkAttachmentStoreOp(val i: Int) {
//    companion object {
//        val STORE = VkAttachmentStoreOp(0)
//        val DONT_CARE = VkAttachmentStoreOp(1)
//    }
//}

@JvmInline
value class VkPipelineBindPoint(val i: Int) {
    companion object {
        val GRAPHICS = VkPipelineBindPoint(0)
        val COMPUTE = VkPipelineBindPoint(1)
        val RAY_TRACING_NV = VkPipelineBindPoint(1000165000)
    }
}


@JvmInline
value class VkCommandBufferLevel(val i: Int) {
    companion object {
        val PRIMARY = VkCommandBufferLevel(0)
        val SECONDARY = VkCommandBufferLevel(1)
    }
}

@JvmInline
value class VkIndexType(val i: Int) {
    companion object {
        val UINT16 = VkIndexType(0)
        val UINT32 = VkIndexType(1)
    }
}

@JvmInline
value class VkSubpassContents(val i: Int) {
    companion object {
        val INLINE = VkSubpassContents(0)
        val SECONDARY_COMMAND_BUFFERS = VkSubpassContents(1)
    }
}


@JvmInline
value class VkObjectType(val i: Int) {
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

@JvmInline
value class VkVendorId(val i: Int) {
    companion object {
        val VIV = VkVendorId(0x10001)
        val VSI = VkVendorId(0x10002)
        val KAZAN = VkVendorId(0x10003)
    }
}

//typealias VkInstanceCreateFlags = VkFlags

@JvmInline
value class VkFormatFeature(val i: VkFormatFeatureFlags) {
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

@JvmInline
value class VkImageUsage(val i: VkImageUsageFlags) {
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

@JvmInline
value class VkImageCreate(val i: VkImageCreateFlags) {
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

@JvmInline
value class VkSampleCount(val i: VkSampleCountFlags) {
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

@JvmInline
value class VkQueueFlag(val i: VkQueueFlags) {
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

@JvmInline
value class VkMemoryProperty(val i: VkMemoryPropertyFlags) {
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

@JvmInline
value class VkMemoryHeapFlag(val i: VkMemoryHeapFlags) {
    companion object {
        val DEVICE_LOCAL_BIT = VkMemoryHeapFlag(0x00000001)
        val MULTI_INSTANCE_BIT = VkMemoryHeapFlag(0x00000002)
        val MULTI_INSTANCE_BIT_KHR = VkMemoryHeapFlag.MULTI_INSTANCE_BIT
    }
}
typealias VkMemoryHeapFlags = VkFlags
typealias VkDeviceCreateFlags = VkFlags

@JvmInline
value class VkDeviceQueueCreate(val i: VkDeviceQueueCreateFlags) {
    companion object {
        val CREATE_PROTECTED_BIT = VkDeviceQueueCreate(0x00000001)
    }
}

typealias VkDeviceQueueCreateFlags = VkFlags

@JvmInline
value class VkPipelineStage(val i: VkPipelineStageFlags) {
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

@JvmInline
value class VkImageAspect(val i: VkImageAspectFlags) {
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

@JvmInline
value class VkSparseImageFormat(val i: VkSparseImageFormatFlags) {
    companion object {
        val SINGLE_MIPTAIL_BIT = VkSparseImageFormat(0x00000001)
        val ALIGNED_MIP_SIZE_BIT = VkSparseImageFormat(0x00000002)
        val NONSTANDARD_BLOCK_SIZE_BIT = VkSparseImageFormat(0x00000004)
    }
}
typealias VkSparseImageFormatFlags = VkFlags

@JvmInline
value class VkSparseMemoryBindFlag(val i: VkSparseMemoryBindFlags) {
    companion object {
        val METADATA_BIT = VkSparseMemoryBindFlag(0x00000001)
    }
}
typealias VkSparseMemoryBindFlags = VkFlags

@JvmInline
value class VkFenceCreate(val i: VkFenceCreateFlags) {
    companion object {
        val SIGNALED_BIT = VkFenceCreate(0x00000001)
    }
}

typealias VkFenceCreateFlags = VkFlags
typealias VkSemaphoreCreateFlags = VkFlags
typealias VkEventCreateFlags = VkFlags
typealias VkQueryPoolCreateFlags = VkFlags

@JvmInline
value class VkQueryPipelineStatistic(val i: VkQueryPipelineStatisticFlags) {
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

@JvmInline
value class VkQueryResult(val i: VkQueryResultFlags) {
    companion object {
        val _64_BIT = VkQueryResult(0x00000001)
        val WAIT_BIT = VkQueryResult(0x00000002)
        val WITH_AVAILABILITY_BIT = VkQueryResult(0x00000004)
        val PARTIAL_BIT = VkQueryResult(0x00000008)
    }
}
typealias VkQueryResultFlags = VkFlags

@JvmInline
value class VkBufferCreate(val i: VkBufferCreateFlags) {
    companion object {
        val SPARSE_BINDING_BIT = VkBufferCreate(0x00000001)
        val SPARSE_RESIDENCY_BIT = VkBufferCreate(0x00000002)
        val SPARSE_ALIASED_BIT = VkBufferCreate(0x00000004)
        val PROTECTED_BIT = VkBufferCreate(0x00000008)
        val DEVICE_ADDRESS_CAPTURE_REPLAY_BIT_EXT = VkBufferCreate(0x00000010)
    }
}

typealias VkBufferCreateFlags = VkFlags

@JvmInline
value class VkBufferUsage(val i: VkBufferUsageFlags) {
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

@JvmInline
value class VkImageViewCreate(val i: VkImageViewCreateFlags) {
    companion object {
        val FRAGMENT_DENSITY_MAP_DYNAMIC_BIT_EXT = VkImageViewCreate(0x00000001)
    }
}

typealias VkImageViewCreateFlags = VkFlags
typealias VkShaderModuleCreateFlags = VkFlags
typealias VkPipelineCacheCreateFlags = VkFlags


@JvmInline
value class VkPipelineCreate(val i: VkPipelineCreateFlags) {
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

@JvmInline
value class VkShaderStage(val i: Int) {
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


@JvmInline
value class VkCullMode(val i: VkCullModeFlags) {
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

@JvmInline
value class VkColorComponent(val i: VkColorComponentFlags) {
    companion object {
        val R_BIT = VkColorComponent(0x00000001)
        val G_BIT = VkColorComponent(0x00000002)
        val B_BIT = VkColorComponent(0x00000004)
        val A_BIT = VkColorComponent(0x00000008)
        val RGBA_BIT = VkColorComponent(0x0000000F)
    }
}

infix fun VkColorComponent.or(f: VkColorComponent): VkColorComponentFlags = i or f.i
infix fun Int.or(f: VkColorComponent): VkColorComponentFlags = or(f.i)


typealias VkColorComponentFlags = VkFlags
typealias VkPipelineDynamicStateCreateFlags = VkFlags
typealias VkPipelineLayoutCreateFlags = VkFlags
typealias VkShaderStageFlags = VkFlags


@JvmInline
value class VkSamplerCreate(val i: VkSamplerCreateFlags) {
    companion object {
        val SUBSAMPLED_BIT_EXT = VkSamplerCreate(0x00000001)
        val SUBSAMPLED_COARSE_RECONSTRUCTION_BIT_EXT = VkSamplerCreate(0x00000002)
        val FLAG_BITS_MAX_ENUM = VkSamplerCreate(0x7FFFFFFF)
    }
}


typealias VkSamplerCreateFlags = VkFlags

@JvmInline
value class VkDescriptorSetLayoutCreate(val i: VkDescriptorSetLayoutCreateFlags) {
    companion object {
        val PUSH_DESCRIPTOR_BIT_KHR = VkDescriptorSetLayoutCreate(0x00000001)
        val UPDATE_AFTER_BIND_POOL_BIT_EXT = VkDescriptorSetLayoutCreate(0x00000002)
    }
}

typealias VkDescriptorSetLayoutCreateFlags = VkFlags

@JvmInline
value class VkDescriptorPoolCreate(val i: VkDescriptorPoolCreateFlags) {
    companion object {
        val FREE_DESCRIPTOR_SET_BIT = VkDescriptorPoolCreate(0x00000001)
        val UPDATE_AFTER_BIND_BIT_EXT = VkDescriptorPoolCreate(0x00000002)
    }
}

typealias VkDescriptorPoolCreateFlags = VkFlags
typealias VkDescriptorPoolResetFlags = VkFlags
typealias VkFramebufferCreateFlags = VkFlags
typealias VkRenderPassCreateFlags = VkFlags

@JvmInline
value class VkAttachmentDescriptionFlag(val i: VkAttachmentDescriptionFlags) {
    companion object {
        val MAY_ALIAS_BIT = VkAttachmentDescriptionFlag(0x00000001)
    }
}

typealias VkAttachmentDescriptionFlags = VkFlags


@JvmInline
value class VkSubpassDescriptionFlag(val i: VkSubpassDescriptionFlags) {
    companion object {
        val PER_VIEW_ATTRIBUTES_BIT_NVX = VkSubpassDescriptionFlag(0x00000001)
        val PER_VIEW_POSITION_X_ONLY_BIT_NVX = VkSubpassDescriptionFlag(0x00000002)
    }
}

typealias VkSubpassDescriptionFlags = VkFlags

@JvmInline
value class VkAccess(val i: VkAccessFlags) {
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

@JvmInline
value class VkDependency(val i: VkDependencyFlags) {
    companion object {
        val BY_REGION_BIT = VkDependency(0x00000001)
        val VIEW_LOCAL_BIT = VkDependency(0x00000002)
        val DEVICE_GROUP_BIT = VkDependency(0x00000004)
        val VIEW_LOCAL_BIT_KHR = VkDependency.VIEW_LOCAL_BIT
        val DEVICE_GROUP_BIT_KHR = VkDependency.DEVICE_GROUP_BIT
    }
}

typealias VkDependencyFlags = VkFlags

@JvmInline
value class VkCommandPoolCreate(val i: VkCommandPoolCreateFlags) {
    companion object {
        val TRANSIENT_BIT = VkCommandPoolCreate(0x00000001)
        val RESET_COMMAND_BUFFER_BIT = VkCommandPoolCreate(0x00000002)
        val PROTECTED_BIT = VkCommandPoolCreate(0x00000004)
    }
}

typealias VkCommandPoolCreateFlags = VkFlags

@JvmInline
value class VkCommandPoolReset(val i: VkCommandPoolResetFlags) {
    companion object {
        val RELEASE_RESOURCES_BIT = VkCommandPoolReset(0x00000001)
    }
}
typealias VkCommandPoolResetFlags = VkFlags

@JvmInline
value class VkCommandBufferUsage(val i: VkCommandBufferUsageFlags) {
    companion object {
        val ONE_TIME_SUBMIT_BIT = VkCommandBufferUsage(0x00000001)
        val RENDER_PASS_CONTINUE_BIT = VkCommandBufferUsage(0x00000002)
        val SIMULTANEOUS_USE_BIT = VkCommandBufferUsage(0x00000004)
    }
}

infix fun Int.or(f: VkCommandBufferUsage) = or(f.i)

typealias VkCommandBufferUsageFlags = VkFlags


@JvmInline
value class VkQueryControl(val i: VkQueryControlFlags) {
    companion object {
        val PRECISE_BIT = VkQueryControl(0x00000001)
    }
}
typealias VkQueryControlFlags = VkFlags

@JvmInline
value class VkCommandBufferReset(val i: VkCommandBufferResetFlags) {
    companion object {
        val RELEASE_RESOURCES_BIT = VkCommandBufferReset(0x00000001)
    }
}
typealias VkCommandBufferResetFlags = VkFlags

@JvmInline
value class VkStencilFace(val i: VkStencilFaceFlags) {
    companion object {
        val FRONT_BIT = VkStencilFace(0x00000001)
        val BACK_BIT = VkStencilFace(0x00000002)
        val FRONT_AND_BACK = VkStencilFace(0x00000003)
    }
}
typealias VkStencilFaceFlags = VkFlags

// ...

enum class VkVendor { AMD, Nvidia, Intel, Unknown }

// #define VK_VERSION_1_1

@JvmInline
value class VkPointClippingBehavior(val i: Int) {
    companion object {
        val ALL_CLIP_PLANES = VkPointClippingBehavior(0)
        val USER_CLIP_PLANES_ONLY = VkPointClippingBehavior(1)
        val ALL_CLIP_PLANES_KHR = VkPointClippingBehavior.ALL_CLIP_PLANES
        val USER_CLIP_PLANES_ONLY_KHR = VkPointClippingBehavior.USER_CLIP_PLANES_ONLY
    }
}

@JvmInline
value class VkTessellationDomainOrigin(val i: Int) {
    companion object {
        val UPPER_LEFT = VkTessellationDomainOrigin(0)
        val LOWER_LEFT = VkTessellationDomainOrigin(1)
        val UPPER_LEFT_KHR = VkTessellationDomainOrigin.UPPER_LEFT
        val LOWER_LEFT_KHR = VkTessellationDomainOrigin.LOWER_LEFT
    }
}

@JvmInline
value class VkSamplerYcbcrModelConversion(val i: Int) {
    companion object {
        val RGB_IDENTITY = VkSamplerYcbcrModelConversion(0)
        val YCBCR_IDENTITY = VkSamplerYcbcrModelConversion(1)
        val YCBCR_709 = VkSamplerYcbcrModelConversion(2)
        val YCBCR_601 = VkSamplerYcbcrModelConversion(3)
        val YCBCR_2020 = VkSamplerYcbcrModelConversion(4)
        val RGB_IDENTITY_KHR = VkSamplerYcbcrModelConversion.RGB_IDENTITY
        val YCBCR_IDENTITY_KHR = VkSamplerYcbcrModelConversion.YCBCR_IDENTITY
        val YCBCR_709_KHR = VkSamplerYcbcrModelConversion.YCBCR_709
        val YCBCR_601_KHR = VkSamplerYcbcrModelConversion.YCBCR_601
        val YCBCR_2020_KHR = VkSamplerYcbcrModelConversion.YCBCR_2020
    }
}

@JvmInline
value class VkSamplerYcbcrRange(val i: Int) {
    companion object {
        val ITU_FULL = VkSamplerYcbcrRange(0)
        val ITU_NARROW = VkSamplerYcbcrRange(1)
        val ITU_FULL_KHR = VkSamplerYcbcrRange(0)
        val ITU_NARROW_KHR = VkSamplerYcbcrRange(1)
    }
}

@JvmInline
value class VkChromaLocation(val i: Int) {
    companion object {
        val COSITED_EVEN = VkChromaLocation(0)
        val MIDPOINT = VkChromaLocation(1)
        val COSITED_EVEN_KHR = VkChromaLocation(0)
        val MIDPOINT_KHR = VkChromaLocation(1)
    }
}

@JvmInline
value class VkDescriptorUpdateTemplateType(val i: Int) {
    companion object {
        val DESCRIPTOR_SET = VkDescriptorUpdateTemplateType(0)
        val PUSH_DESCRIPTORS_KHR = VkDescriptorUpdateTemplateType(1)
        val DESCRIPTOR_SET_KHR = VkDescriptorUpdateTemplateType.DESCRIPTOR_SET
    }
}


@JvmInline
value class VkSubgroupFeature(val i: VkSubgroupFeatureFlags) {
    companion object {
        val BASIC_BIT = VkSubgroupFeature(0x00000001)
        val VOTE_BIT = VkSubgroupFeature(0x00000002)
        val ARITHMETIC_BIT = VkSubgroupFeature(0x00000004)
        val BALLOT_BIT = VkSubgroupFeature(0x00000008)
        val SHUFFLE_BIT = VkSubgroupFeature(0x00000010)
        val SHUFFLE_RELATIVE_BIT = VkSubgroupFeature(0x00000020)
        val CLUSTERED_BIT = VkSubgroupFeature(0x00000040)
        val QUAD_BIT = VkSubgroupFeature(0x00000080)
        val PARTITIONED_BIT_NV = VkSubgroupFeature(0x00000100)
    }
}

typealias VkSubgroupFeatureFlags = VkFlags

@JvmInline
value class VkPeerMemoryFeature(val i: VkPeerMemoryFeatureFlags) {
    companion object {
        val COPY_SRC_BIT = VkPeerMemoryFeature(0x00000001)
        val COPY_DST_BIT = VkPeerMemoryFeature(0x00000002)
        val GENERIC_SRC_BIT = VkPeerMemoryFeature(0x00000004)
        val GENERIC_DST_BIT = VkPeerMemoryFeature(0x00000008)
        val COPY_SRC_BIT_KHR = VkPeerMemoryFeature(0x00000001)
        val COPY_DST_BIT_KHR = VkPeerMemoryFeature(0x00000002)
        val GENERIC_SRC_BIT_KHR = VkPeerMemoryFeature(0x00000004)
        val GENERIC_DST_BIT_KHR = VkPeerMemoryFeature(0x00000008)
    }
}

typealias VkPeerMemoryFeatureFlags = VkFlags

@JvmInline
value class VkMemoryAllocate(val i: VkMemoryAllocateFlags) {
    companion object {
        val DEVICE_MASK_BIT = VkMemoryAllocate(0x00000001)
    }
}

typealias VkMemoryAllocateFlags = VkFlags
typealias VkCommandPoolTrimFlags = VkFlags
typealias VkDescriptorUpdateTemplateCreateFlags = VkFlags

@JvmInline
value class VkExternalMemoryHandleType(val i: VkExternalMemoryHandleTypeFlags) {
    companion object {
        val OPAQUE_FD_BIT = VkExternalMemoryHandleType(0x00000001)
        val OPAQUE_WIN32_BIT = VkExternalMemoryHandleType(0x00000002)
        val OPAQUE_WIN32_KMT_BIT = VkExternalMemoryHandleType(0x00000004)
        val D3D11_TEXTURE_BIT = VkExternalMemoryHandleType(0x00000008)
        val D3D11_TEXTURE_KMT_BIT = VkExternalMemoryHandleType(0x00000010)
        val D3D12_HEAP_BIT = VkExternalMemoryHandleType(0x00000020)
        val D3D12_RESOURCE_BIT = VkExternalMemoryHandleType(0x00000040)
        val DMA_BUF_BIT_EXT = VkExternalMemoryHandleType(0x00000200)
        val ANDROID_HARDWARE_BUFFER_BIT_ANDROID = VkExternalMemoryHandleType(0x00000400)
        val HOST_ALLOCATION_BIT_EXT = VkExternalMemoryHandleType(0x00000080)
        val HOST_MAPPED_FOREIGN_MEMORY_BIT_EXT = VkExternalMemoryHandleType(0x00000100)
        val OPAQUE_FD_BIT_KHR = VkExternalMemoryHandleType.OPAQUE_FD_BIT
        val OPAQUE_WIN32_BIT_KHR = VkExternalMemoryHandleType.OPAQUE_WIN32_BIT
        val OPAQUE_WIN32_KMT_BIT_KHR = VkExternalMemoryHandleType.OPAQUE_WIN32_KMT_BIT
        val D3D11_TEXTURE_BIT_KHR = VkExternalMemoryHandleType.D3D11_TEXTURE_BIT
        val D3D11_TEXTURE_KMT_BIT_KHR = VkExternalMemoryHandleType.D3D11_TEXTURE_KMT_BIT
        val D3D12_HEAP_BIT_KHR = VkExternalMemoryHandleType.D3D12_HEAP_BIT
        val D3D12_RESOURCE_BIT_KHR = VkExternalMemoryHandleType.D3D12_RESOURCE_BIT
    }
}

typealias VkExternalMemoryHandleTypeFlags = VkFlags

@JvmInline
value class VkExternalMemoryFeature(val i: VkExternalMemoryFeatureFlags) {
    companion object {
        val DEDICATED_ONLY_BIT = VkExternalMemoryFeature(0x00000001)
        val EXPORTABLE_BIT = VkExternalMemoryFeature(0x00000002)
        val IMPORTABLE_BIT = VkExternalMemoryFeature(0x00000004)
        val DEDICATED_ONLY_BIT_KHR = VkExternalMemoryFeature.DEDICATED_ONLY_BIT
        val EXPORTABLE_BIT_KHR = VkExternalMemoryFeature.EXPORTABLE_BIT
        val IMPORTABLE_BIT_KHR = VkExternalMemoryFeature.IMPORTABLE_BIT
    }
}

typealias VkExternalMemoryFeatureFlags = VkFlags

@JvmInline
value class VkExternalFenceHandleType(val i: Int) {
    companion object {
        val OPAQUE_FD_BIT = VkExternalFenceHandleType(0x00000001)
        val OPAQUE_WIN32_BIT = VkExternalFenceHandleType(0x00000002)
        val OPAQUE_WIN32_KMT_BIT = VkExternalFenceHandleType(0x00000004)
        val SYNC_FD_BIT = VkExternalFenceHandleType(0x00000008)
        val OPAQUE_FD_BIT_KHR = VkExternalFenceHandleType.OPAQUE_FD_BIT
        val OPAQUE_WIN32_BIT_KHR = VkExternalFenceHandleType.OPAQUE_WIN32_BIT
        val OPAQUE_WIN32_KMT_BIT_KHR = VkExternalFenceHandleType.OPAQUE_WIN32_KMT_BIT
        val SYNC_FD_BIT_KHR = VkExternalFenceHandleType.SYNC_FD_BIT
    }
}

// ..


@JvmInline
value class VkDisplayPowerStateEXT(val i: Int) {
    companion object {
        val OFF_EXT = VkDisplayPowerStateEXT(0)
        val SUSPEND_EXT = VkDisplayPowerStateEXT(1)
        val ON_EXT = VkDisplayPowerStateEXT(2)
    }
}


@JvmInline
value class VkDeviceEventTypeEXT(val i: Int) {
    companion object {
        val DISPLAY_HOTPLUG_EXT = VkDeviceEventTypeEXT(0)
    }
}


@JvmInline
value class VkDisplayEventTypeEXT(val i: Int) {
    companion object {
        val FIRST_PIXEL_OUT_EXT = VkDisplayEventTypeEXT(0)
    }
}

// ..


