package vkk

import glm_.L
import glm_.bool
import glm_.i
import glm_.vec2.Vec2
import glm_.vec4.Vec4
import kool.Ptr
import kool.adr
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.memPutAddress
import org.lwjgl.vulkan.*
import vkk.entities.*
import java.nio.ByteBuffer
import java.nio.IntBuffer


inline class VkResolveModeKHR(val i: Int) {
    companion object {
        val NONE_KHR = VkResolveModeKHR(0)
        val SAMPLE_ZERO_BIT_KHR = VkResolveModeKHR(0x00000001)
        val AVERAGE_BIT_KHR = VkResolveModeKHR(0x00000002)
        val MIN_BIT_KHR = VkResolveModeKHR(0x00000004)
        val MAX_BIT_KHR = VkResolveModeKHR(0x00000008)
    }
}

typealias VkResolveModeFlagsKHR = VkFlags


inline var VkSubpassDescriptionDepthStencilResolveKHR.type: VkStructureType
    get() = VkStructureType(VkSubpassDescriptionDepthStencilResolveKHR.nsType(adr))
    set(value) = VkSubpassDescriptionDepthStencilResolveKHR.nsType(adr, value.i)
inline var VkSubpassDescriptionDepthStencilResolveKHR.next: Ptr
    get() = VkSubpassDescriptionDepthStencilResolveKHR.npNext(adr)
    set(value) = VkSubpassDescriptionDepthStencilResolveKHR.npNext(adr, value)
inline var VkSubpassDescriptionDepthStencilResolveKHR.depthResolveMode: VkResolveModeKHR
    get() = VkResolveModeKHR(VkSubpassDescriptionDepthStencilResolveKHR.ndepthResolveMode(adr))
    set(value) = VkSubpassDescriptionDepthStencilResolveKHR.ndepthResolveMode(adr, value.i)
inline var VkSubpassDescriptionDepthStencilResolveKHR.stencilResolveMode: VkResolveModeKHR
    get() = VkResolveModeKHR(VkSubpassDescriptionDepthStencilResolveKHR.nstencilResolveMode(adr))
    set(value) = VkSubpassDescriptionDepthStencilResolveKHR.nstencilResolveMode(adr, value.i)
inline var VkSubpassDescriptionDepthStencilResolveKHR.depthStencilResolveAttachment: VkAttachmentReference2KHR?
    get() = VkSubpassDescriptionDepthStencilResolveKHR.npDepthStencilResolveAttachment(adr)
    set(value) = VkSubpassDescriptionDepthStencilResolveKHR.npDepthStencilResolveAttachment(adr, value)
//
//
inline var VkPhysicalDeviceDepthStencilResolvePropertiesKHR.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceDepthStencilResolvePropertiesKHR.nsType(adr))
    set(value) = VkPhysicalDeviceDepthStencilResolvePropertiesKHR.nsType(adr, value.i)
inline var VkPhysicalDeviceDepthStencilResolvePropertiesKHR.next: Ptr
    get() = VkPhysicalDeviceDepthStencilResolvePropertiesKHR.npNext(adr)
    set(value) = VkPhysicalDeviceDepthStencilResolvePropertiesKHR.npNext(adr, value)
inline val VkPhysicalDeviceDepthStencilResolvePropertiesKHR.supportedDepthResolveModes: VkResolveModeFlagsKHR
    get() = VkPhysicalDeviceDepthStencilResolvePropertiesKHR.nsupportedDepthResolveModes(adr)
inline val VkPhysicalDeviceDepthStencilResolvePropertiesKHR.supportedStencilResolveModes: VkResolveModeFlagsKHR
    get() = VkPhysicalDeviceDepthStencilResolvePropertiesKHR.nsupportedStencilResolveModes(adr)
inline val VkPhysicalDeviceDepthStencilResolvePropertiesKHR.independentResolveNone: Boolean
    get() = VkPhysicalDeviceDepthStencilResolvePropertiesKHR.nindependentResolveNone(adr).bool
inline val VkPhysicalDeviceDepthStencilResolvePropertiesKHR.independentResolve: Boolean
    get() = VkPhysicalDeviceDepthStencilResolvePropertiesKHR.nindependentResolve(adr).bool


inline var VkPhysicalDeviceVulkanMemoryModelFeaturesKHR.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceVulkanMemoryModelFeaturesKHR.nsType(adr))
    set(value) = VkPhysicalDeviceVulkanMemoryModelFeaturesKHR.nsType(adr, value.i)
inline var VkPhysicalDeviceVulkanMemoryModelFeaturesKHR.next: Ptr
    get() = VkPhysicalDeviceVulkanMemoryModelFeaturesKHR.npNext(adr)
    set(value) = VkPhysicalDeviceVulkanMemoryModelFeaturesKHR.npNext(adr, value)
inline var VkPhysicalDeviceVulkanMemoryModelFeaturesKHR.vulkanMemoryModel: Boolean
    get() = VkPhysicalDeviceVulkanMemoryModelFeaturesKHR.nvulkanMemoryModel(adr).bool
    set(value) = VkPhysicalDeviceVulkanMemoryModelFeaturesKHR.nvulkanMemoryModel(adr, value.i)
inline var VkPhysicalDeviceVulkanMemoryModelFeaturesKHR.vulkanMemoryModelDeviceScope: Boolean
    get() = VkPhysicalDeviceVulkanMemoryModelFeaturesKHR.nvulkanMemoryModelDeviceScope(adr).bool
    set(value) = VkPhysicalDeviceVulkanMemoryModelFeaturesKHR.nvulkanMemoryModelDeviceScope(adr, value.i)
inline var VkPhysicalDeviceVulkanMemoryModelFeaturesKHR.vulkanMemoryModelAvailabilityVisibilityChains: Boolean
    get() = VkPhysicalDeviceVulkanMemoryModelFeaturesKHR.nvulkanMemoryModelAvailabilityVisibilityChains(adr).bool
    set(value) = VkPhysicalDeviceVulkanMemoryModelFeaturesKHR.nvulkanMemoryModelAvailabilityVisibilityChains(adr, value.i)


inline var VkSurfaceProtectedCapabilitiesKHR.type: VkStructureType
    get() = VkStructureType(VkSurfaceProtectedCapabilitiesKHR.nsType(adr))
    set(value) = VkSurfaceProtectedCapabilitiesKHR.nsType(adr, value.i)
inline var VkSurfaceProtectedCapabilitiesKHR.next: Ptr
    get() = VkSurfaceProtectedCapabilitiesKHR.npNext(adr)
    set(value) = VkSurfaceProtectedCapabilitiesKHR.npNext(adr, value)
inline var VkSurfaceProtectedCapabilitiesKHR.supportsProtected: Boolean
    get() = VkSurfaceProtectedCapabilitiesKHR.nsupportsProtected(adr).bool
    set(value) = VkSurfaceProtectedCapabilitiesKHR.nsupportsProtected(adr, value.i)


inline var VkPhysicalDeviceUniformBufferStandardLayoutFeaturesKHR.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceUniformBufferStandardLayoutFeaturesKHR.nsType(adr))
    set(value) = VkPhysicalDeviceUniformBufferStandardLayoutFeaturesKHR.nsType(adr, value.i)
inline var VkPhysicalDeviceUniformBufferStandardLayoutFeaturesKHR.next: Ptr
    get() = VkPhysicalDeviceUniformBufferStandardLayoutFeaturesKHR.npNext(adr)
    set(value) = VkPhysicalDeviceUniformBufferStandardLayoutFeaturesKHR.npNext(adr, value)
inline var VkPhysicalDeviceUniformBufferStandardLayoutFeaturesKHR.uniformBufferStandardLayout: Boolean
    get() = VkPhysicalDeviceUniformBufferStandardLayoutFeaturesKHR.nuniformBufferStandardLayout(adr).bool
    set(value) = VkPhysicalDeviceUniformBufferStandardLayoutFeaturesKHR.nuniformBufferStandardLayout(adr, value.i)


inline class VkPipelineExecutableStatisticFormatKHR(val i: Int) {
    companion object {
        val BOOL32_KHR = VkPipelineExecutableStatisticFormatKHR(0)
        val INT64_KHR = VkPipelineExecutableStatisticFormatKHR(1)
        val UINT64_KHR = VkPipelineExecutableStatisticFormatKHR(2)
        val FLOAT64_KHR = VkPipelineExecutableStatisticFormatKHR(3)
    }
}


inline var VkPhysicalDevicePipelineExecutablePropertiesFeaturesKHR.type: VkStructureType
    get() = VkStructureType(VkPhysicalDevicePipelineExecutablePropertiesFeaturesKHR.nsType(adr))
    set(value) = VkPhysicalDevicePipelineExecutablePropertiesFeaturesKHR.nsType(adr, value.i)
inline var VkPhysicalDevicePipelineExecutablePropertiesFeaturesKHR.next: Ptr
    get() = VkPhysicalDevicePipelineExecutablePropertiesFeaturesKHR.npNext(adr)
    set(value) = VkPhysicalDevicePipelineExecutablePropertiesFeaturesKHR.npNext(adr, value)
inline var VkPhysicalDevicePipelineExecutablePropertiesFeaturesKHR.pipelineExecutableInfo: Boolean
    get() = VkPhysicalDevicePipelineExecutablePropertiesFeaturesKHR.npipelineExecutableInfo(adr).bool
    set(value) = VkPhysicalDevicePipelineExecutablePropertiesFeaturesKHR.npipelineExecutableInfo(adr, value.i)


inline var VkPipelineInfoKHR.type: VkStructureType
    get() = VkStructureType(VkPipelineInfoKHR.nsType(adr))
    set(value) = VkPipelineInfoKHR.nsType(adr, value.i)
inline var VkPipelineInfoKHR.next: Ptr
    get() = VkPipelineInfoKHR.npNext(adr)
    set(value) = VkPipelineInfoKHR.npNext(adr, value)
inline var VkPipelineInfoKHR.pipeline: VkPipeline
    get() = VkPipeline(VkPipelineInfoKHR.npipeline(adr))
    set(value) = VkPipelineInfoKHR.npipeline(adr, value.L)


inline var VkPipelineExecutablePropertiesKHR.type: VkStructureType
    get() = VkStructureType(VkPipelineExecutablePropertiesKHR.nsType(adr))
    set(value) = VkPipelineExecutablePropertiesKHR.nsType(adr, value.i)
inline var VkPipelineExecutablePropertiesKHR.next: Ptr
    get() = VkPipelineExecutablePropertiesKHR.npNext(adr)
    set(value) = VkPipelineExecutablePropertiesKHR.npNext(adr, value)
inline val VkPipelineExecutablePropertiesKHR.stages: VkShaderStageFlags
    get() = VkPipelineExecutablePropertiesKHR.nstages(adr)
inline val VkPipelineExecutablePropertiesKHR.name: String
    get() = VkPipelineExecutablePropertiesKHR.nnameString(adr)
inline val VkPipelineExecutablePropertiesKHR.description: String
    get() = VkPipelineExecutablePropertiesKHR.ndescriptionString(adr)
inline val VkPipelineExecutablePropertiesKHR.subgroupSize: Int
    get() = VkPipelineExecutablePropertiesKHR.nsubgroupSize(adr)


inline val VkPipelineExecutableStatisticValueKHR.b32: Boolean
    get() = VkPipelineExecutableStatisticValueKHR.nb32(adr).bool
inline val VkPipelineExecutableStatisticValueKHR.i64: Long
    get() = VkPipelineExecutableStatisticValueKHR.ni64(adr)
inline val VkPipelineExecutableStatisticValueKHR.u64: Long
    get() = VkPipelineExecutableStatisticValueKHR.nu64(adr)
inline val VkPipelineExecutableStatisticValueKHR.f64: Double
    get() = VkPipelineExecutableStatisticValueKHR.nf64(adr)


inline var VkPipelineExecutableStatisticKHR.type: VkStructureType
    get() = VkStructureType(VkPipelineExecutableStatisticKHR.nsType(adr))
    set(value) = VkPipelineExecutableStatisticKHR.nsType(adr, value.i)
inline var VkPipelineExecutableStatisticKHR.next: Ptr
    get() = VkPipelineExecutableStatisticKHR.npNext(adr)
    set(value) = VkPipelineExecutableStatisticKHR.npNext(adr, value)
inline val VkPipelineExecutableStatisticKHR.name: String
    get() = VkPipelineExecutableStatisticKHR.nnameString(adr)
inline val VkPipelineExecutableStatisticKHR.description: String
    get() = VkPipelineExecutableStatisticKHR.ndescriptionString(adr)
inline val VkPipelineExecutableStatisticKHR.format: VkPipelineExecutableStatisticFormatKHR
    get() = VkPipelineExecutableStatisticFormatKHR(VkPipelineExecutableStatisticKHR.nformat(adr))
inline val VkPipelineExecutableStatisticKHR.value: VkPipelineExecutableStatisticValueKHR
    get() = VkPipelineExecutableStatisticKHR.nvalue(adr)


inline var VkPipelineExecutableInternalRepresentationKHR.type: VkStructureType
    get() = VkStructureType(VkPipelineExecutableInternalRepresentationKHR.nsType(adr))
    set(value) = VkPipelineExecutableInternalRepresentationKHR.nsType(adr, value.i)
inline var VkPipelineExecutableInternalRepresentationKHR.next: Ptr
    get() = VkPipelineExecutableInternalRepresentationKHR.npNext(adr)
    set(value) = VkPipelineExecutableInternalRepresentationKHR.npNext(adr, value)
inline var VkPipelineExecutableInternalRepresentationKHR.name: String
    get() = VkPipelineExecutableInternalRepresentationKHR.nnameString(adr)
    set(value) = stak.asciiBuffer(value) { VkPipelineExecutableInternalRepresentationKHR.nname(adr, it) }
inline var VkPipelineExecutableInternalRepresentationKHR.description: String
    get() = VkPipelineExecutableInternalRepresentationKHR.ndescriptionString(adr)
    set(value) = stak.asciiBuffer(value) { VkPipelineExecutableInternalRepresentationKHR.ndescription(adr, it) }
inline var VkPipelineExecutableInternalRepresentationKHR.isText: Boolean
    get() = VkPipelineExecutableInternalRepresentationKHR.nisText(adr).bool
    set(value) = VkPipelineExecutableInternalRepresentationKHR.nisText(adr, value.i)
inline var VkPipelineExecutableInternalRepresentationKHR.dataSize: Int
    get() = VkPipelineExecutableInternalRepresentationKHR.ndataSize(adr).i
    set(value) = VkPipelineExecutableInternalRepresentationKHR.ndataSize(adr, value.L)


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


inline var VkDebugReportCallbackCreateInfoEXT.type: VkStructureType
    get() = VkStructureType(VkDebugReportCallbackCreateInfoEXT.nsType(adr))
    set(value) = VkDebugReportCallbackCreateInfoEXT.nsType(adr, value.i)
inline var VkDebugReportCallbackCreateInfoEXT.next: Ptr
    get() = VkDebugReportCallbackCreateInfoEXT.npNext(adr)
    set(value) = VkDebugReportCallbackCreateInfoEXT.npNext(adr, value)
/** JVM custom */
inline var VkDebugReportCallbackCreateInfoEXT.flag: VkDebugReport
    get() = throw Exception("Invalid")
    set(value) = VkDebugReportCallbackCreateInfoEXT.nflags(adr, value.i)
inline var VkDebugReportCallbackCreateInfoEXT.flags: VkDebugReportFlagsEXT
    get() = VkDebugReportCallbackCreateInfoEXT.nflags(adr)
    set(value) = VkDebugReportCallbackCreateInfoEXT.nflags(adr, value)
inline var VkDebugReportCallbackCreateInfoEXT.callback: VkDebugReportCallbackEXT
    get() = VkDebugReportCallbackCreateInfoEXT.npfnCallback(adr)
    set(value) = VkDebugReportCallbackCreateInfoEXT.npfnCallback(adr, value)
inline var VkDebugReportCallbackCreateInfoEXT.userData: Ptr
    get() = VkDebugReportCallbackCreateInfoEXT.npUserData(adr)
    set(value) = VkDebugReportCallbackCreateInfoEXT.npUserData(adr, value)


inline class VkRasterizationOrderAMD(val i: Int) {
    companion object {
        val STRICT_AMD = VkRasterizationOrderAMD(0)
        val RELAXED_AMD = VkRasterizationOrderAMD(1)
    }
}


inline var VkPipelineRasterizationStateRasterizationOrderAMD.type: VkStructureType
    get() = VkStructureType(VkPipelineRasterizationStateRasterizationOrderAMD.nsType(adr))
    set(value) = VkPipelineRasterizationStateRasterizationOrderAMD.nsType(adr, value.i)
inline var VkPipelineRasterizationStateRasterizationOrderAMD.next: Ptr
    get() = VkPipelineRasterizationStateRasterizationOrderAMD.npNext(adr)
    set(value) = VkPipelineRasterizationStateRasterizationOrderAMD.npNext(adr, value)
inline var VkPipelineRasterizationStateRasterizationOrderAMD.rasterizationOrder: VkRasterizationOrderAMD
    get() = VkRasterizationOrderAMD(VkPipelineRasterizationStateRasterizationOrderAMD.nrasterizationOrder(adr))
    set(value) = VkPipelineRasterizationStateRasterizationOrderAMD.nrasterizationOrder(adr, value.i)


inline var VkDebugMarkerObjectNameInfoEXT.type: VkStructureType
    get() = VkStructureType(VkDebugMarkerObjectNameInfoEXT.nsType(adr))
    set(value) = VkDebugMarkerObjectNameInfoEXT.nsType(adr, value.i)
inline var VkDebugMarkerObjectNameInfoEXT.next: Ptr
    get() = VkDebugMarkerObjectNameInfoEXT.npNext(adr)
    set(value) = VkDebugMarkerObjectNameInfoEXT.npNext(adr, value)
inline var VkDebugMarkerObjectNameInfoEXT.objectType: VkDebugReportObjectTypeEXT
    get() = VkDebugReportObjectTypeEXT(VkDebugMarkerObjectNameInfoEXT.nobjectType(adr))
    set(value) = VkDebugMarkerObjectNameInfoEXT.nobjectType(adr, value.i)
inline var VkDebugMarkerObjectNameInfoEXT.`object`: Long
    get() = VkDebugMarkerObjectNameInfoEXT.nobject(adr)
    set(value) = VkDebugMarkerObjectNameInfoEXT.nobject(adr, value)
inline var VkDebugMarkerObjectNameInfoEXT.objectName: String
    get() = VkDebugMarkerObjectNameInfoEXT.npObjectNameString(adr)
    set(value) = VkDebugMarkerObjectNameInfoEXT.npObjectName(adr, value.toUtf8Stack())


inline var VkDebugMarkerObjectTagInfoEXT.type: VkStructureType
    get() = VkStructureType(VkDebugMarkerObjectTagInfoEXT.nsType(adr))
    set(value) = VkDebugMarkerObjectTagInfoEXT.nsType(adr, value.i)
inline var VkDebugMarkerObjectTagInfoEXT.next: Ptr
    get() = VkDebugMarkerObjectTagInfoEXT.npNext(adr)
    set(value) = VkDebugMarkerObjectTagInfoEXT.npNext(adr, value)
inline var VkDebugMarkerObjectTagInfoEXT.objectType: VkDebugReportObjectTypeEXT
    get() = VkDebugReportObjectTypeEXT(VkDebugMarkerObjectTagInfoEXT.nobjectType(adr))
    set(value) = VkDebugMarkerObjectTagInfoEXT.nobjectType(adr, value.i)
inline var VkDebugMarkerObjectTagInfoEXT.`object`: Long
    get() = VkDebugMarkerObjectTagInfoEXT.nobject(adr)
    set(value) = VkDebugMarkerObjectTagInfoEXT.nobject(adr, value)
inline var VkDebugMarkerObjectTagInfoEXT.tagName: String
    get() = MemoryUtil.memUTF8(VkDebugMarkerObjectTagInfoEXT.ntagName(adr))
    set(value) = VkDebugMarkerObjectTagInfoEXT.ntagName(adr, value.toUtf8Stack().adr)
@Deprecated("this will be set automatically")
inline var VkDebugMarkerObjectTagInfoEXT.tagSize: Long
    get() = VkDebugMarkerObjectTagInfoEXT.ntagSize(adr)
    set(value) = VkDebugMarkerObjectTagInfoEXT.ntagSize(adr, value)
inline var VkDebugMarkerObjectTagInfoEXT.tag: ByteBuffer
    get() = VkDebugMarkerObjectTagInfoEXT.npTag(adr)
    set(value) = VkDebugMarkerObjectTagInfoEXT.npTag(adr, value)


inline var VkDebugMarkerMarkerInfoEXT.type: VkStructureType
    get() = VkStructureType(VkDebugMarkerMarkerInfoEXT.nsType(adr))
    set(value) = VkDebugMarkerMarkerInfoEXT.nsType(adr, value.i)
inline var VkDebugMarkerMarkerInfoEXT.next: Ptr
    get() = VkDebugMarkerMarkerInfoEXT.npNext(adr)
    set(value) = VkDebugMarkerMarkerInfoEXT.npNext(adr, value)
inline var VkDebugMarkerMarkerInfoEXT.markerName: String
    get() = VkDebugMarkerMarkerInfoEXT.npMarkerNameString(adr)
    set(value) = VkDebugMarkerMarkerInfoEXT.npMarkerName(adr, value.toUtf8Stack())
inline var VkDebugMarkerMarkerInfoEXT.color: Vec4
    get() = Vec4(VkDebugMarkerMarkerInfoEXT.ncolor(adr))
    set(value) {
        value to VkDebugMarkerMarkerInfoEXT.ncolor(adr)
    }


inline var VkDedicatedAllocationImageCreateInfoNV.type: VkStructureType
    get() = VkStructureType(VkDedicatedAllocationImageCreateInfoNV.nsType(adr))
    set(value) = VkDedicatedAllocationImageCreateInfoNV.nsType(adr, value.i)
inline var VkDedicatedAllocationImageCreateInfoNV.next: Ptr
    get() = VkDedicatedAllocationImageCreateInfoNV.npNext(adr)
    set(value) = VkDedicatedAllocationImageCreateInfoNV.npNext(adr, value)
inline var VkDedicatedAllocationImageCreateInfoNV.dedicatedAllocation: Boolean
    get() = VkDedicatedAllocationImageCreateInfoNV.ndedicatedAllocation(adr).bool
    set(value) = VkDedicatedAllocationImageCreateInfoNV.ndedicatedAllocation(adr, value.i)


inline var VkDedicatedAllocationBufferCreateInfoNV.type: VkStructureType
    get() = VkStructureType(VkDedicatedAllocationBufferCreateInfoNV.nsType(adr))
    set(value) = VkDedicatedAllocationBufferCreateInfoNV.nsType(adr, value.i)
inline var VkDedicatedAllocationBufferCreateInfoNV.next: Ptr
    get() = VkDedicatedAllocationBufferCreateInfoNV.npNext(adr)
    set(value) = VkDedicatedAllocationBufferCreateInfoNV.npNext(adr, value)
inline var VkDedicatedAllocationBufferCreateInfoNV.dedicatedAllocation: Boolean
    get() = VkDedicatedAllocationBufferCreateInfoNV.ndedicatedAllocation(adr).bool
    set(value) = VkDedicatedAllocationBufferCreateInfoNV.ndedicatedAllocation(adr, value.i)


inline var VkDedicatedAllocationMemoryAllocateInfoNV.type: VkStructureType
    get() = VkStructureType(VkDedicatedAllocationMemoryAllocateInfoNV.nsType(adr))
    set(value) = VkDedicatedAllocationMemoryAllocateInfoNV.nsType(adr, value.i)
inline var VkDedicatedAllocationMemoryAllocateInfoNV.next: Ptr
    get() = VkDedicatedAllocationMemoryAllocateInfoNV.npNext(adr)
    set(value) = VkDedicatedAllocationMemoryAllocateInfoNV.npNext(adr, value)
inline var VkDedicatedAllocationMemoryAllocateInfoNV.image: VkImage
    get() = VkImage(VkDedicatedAllocationMemoryAllocateInfoNV.nimage(adr))
    set(value) = VkDedicatedAllocationMemoryAllocateInfoNV.nimage(adr, value.L)
inline var VkDedicatedAllocationMemoryAllocateInfoNV.buffer: VkBuffer
    get() = VkBuffer(VkDedicatedAllocationMemoryAllocateInfoNV.nbuffer(adr))
    set(value) = VkDedicatedAllocationMemoryAllocateInfoNV.nbuffer(adr, value.L)


typealias VkPipelineRasterizationStateStreamCreateFlagsEXT = VkFlags


inline var VkPhysicalDeviceTransformFeedbackFeaturesEXT.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceTransformFeedbackFeaturesEXT.nsType(adr))
    set(value) = VkPhysicalDeviceTransformFeedbackFeaturesEXT.nsType(adr, value.i)
inline var VkPhysicalDeviceTransformFeedbackFeaturesEXT.next: Ptr
    get() = VkPhysicalDeviceTransformFeedbackFeaturesEXT.npNext(adr)
    set(value) = VkPhysicalDeviceTransformFeedbackFeaturesEXT.npNext(adr, value)
inline var VkPhysicalDeviceTransformFeedbackFeaturesEXT.transformFeedback: Boolean
    get() = VkPhysicalDeviceTransformFeedbackFeaturesEXT.ntransformFeedback(adr).bool
    set(value) = VkPhysicalDeviceTransformFeedbackFeaturesEXT.ntransformFeedback(adr, value.i)
inline var VkPhysicalDeviceTransformFeedbackFeaturesEXT.geometryStreams: Boolean
    get() = VkPhysicalDeviceTransformFeedbackFeaturesEXT.ngeometryStreams(adr).bool
    set(value) = VkPhysicalDeviceTransformFeedbackFeaturesEXT.ngeometryStreams(adr, value.i)


inline var VkPhysicalDeviceTransformFeedbackPropertiesEXT.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceTransformFeedbackPropertiesEXT.nsType(adr))
    set(value) = VkPhysicalDeviceTransformFeedbackPropertiesEXT.nsType(adr, value.i)
inline var VkPhysicalDeviceTransformFeedbackPropertiesEXT.next: Ptr
    get() = VkPhysicalDeviceTransformFeedbackPropertiesEXT.npNext(adr)
    set(value) = VkPhysicalDeviceTransformFeedbackPropertiesEXT.npNext(adr, value)
inline val VkPhysicalDeviceTransformFeedbackPropertiesEXT.maxTransformFeedbackStreams: Int
    get() = VkPhysicalDeviceTransformFeedbackPropertiesEXT.nmaxTransformFeedbackStreams(adr)
inline val VkPhysicalDeviceTransformFeedbackPropertiesEXT.maxTransformFeedbackBuffers: Int
    get() = VkPhysicalDeviceTransformFeedbackPropertiesEXT.nmaxTransformFeedbackBuffers(adr)
inline val VkPhysicalDeviceTransformFeedbackPropertiesEXT.maxTransformFeedbackBufferSize: VkDeviceSize
    get() = VkDeviceSize(VkPhysicalDeviceTransformFeedbackPropertiesEXT.nmaxTransformFeedbackBufferSize(adr))
inline val VkPhysicalDeviceTransformFeedbackPropertiesEXT.maxTransformFeedbackStreamDataSize: Int
    get() = VkPhysicalDeviceTransformFeedbackPropertiesEXT.nmaxTransformFeedbackStreamDataSize(adr)
inline val VkPhysicalDeviceTransformFeedbackPropertiesEXT.maxTransformFeedbackBufferDataSize: Int
    get() = VkPhysicalDeviceTransformFeedbackPropertiesEXT.nmaxTransformFeedbackBufferDataSize(adr)
inline val VkPhysicalDeviceTransformFeedbackPropertiesEXT.maxTransformFeedbackBufferDataStride: Int
    get() = VkPhysicalDeviceTransformFeedbackPropertiesEXT.nmaxTransformFeedbackBufferDataStride(adr)
inline val VkPhysicalDeviceTransformFeedbackPropertiesEXT.transformFeedbackQueries: Boolean
    get() = VkPhysicalDeviceTransformFeedbackPropertiesEXT.ntransformFeedbackQueries(adr).bool
inline val VkPhysicalDeviceTransformFeedbackPropertiesEXT.transformFeedbackStreamsLinesTriangles: Boolean
    get() = VkPhysicalDeviceTransformFeedbackPropertiesEXT.ntransformFeedbackStreamsLinesTriangles(adr).bool
inline val VkPhysicalDeviceTransformFeedbackPropertiesEXT.transformFeedbackRasterizationStreamSelect: Boolean
    get() = VkPhysicalDeviceTransformFeedbackPropertiesEXT.ntransformFeedbackRasterizationStreamSelect(adr).bool
inline val VkPhysicalDeviceTransformFeedbackPropertiesEXT.transformFeedbackDraw: Boolean
    get() = VkPhysicalDeviceTransformFeedbackPropertiesEXT.ntransformFeedbackDraw(adr).bool


inline var VkPipelineRasterizationStateStreamCreateInfoEXT.type: VkStructureType
    get() = VkStructureType(VkPipelineRasterizationStateStreamCreateInfoEXT.nsType(adr))
    set(value) = VkPipelineRasterizationStateStreamCreateInfoEXT.nsType(adr, value.i)
inline var VkPipelineRasterizationStateStreamCreateInfoEXT.next: Ptr
    get() = VkPipelineRasterizationStateStreamCreateInfoEXT.npNext(adr)
    set(value) = VkPipelineRasterizationStateStreamCreateInfoEXT.npNext(adr, value)
inline var VkPipelineRasterizationStateStreamCreateInfoEXT.flags: VkPipelineRasterizationStateStreamCreateFlagsEXT
    get() = VkPipelineRasterizationStateStreamCreateInfoEXT.nflags(adr)
    set(value) = VkPipelineRasterizationStateStreamCreateInfoEXT.nflags(adr, value)
inline var VkPipelineRasterizationStateStreamCreateInfoEXT.rasterizationStream: Int
    get() = VkPipelineRasterizationStateStreamCreateInfoEXT.nrasterizationStream(adr)
    set(value) = VkPipelineRasterizationStateStreamCreateInfoEXT.nrasterizationStream(adr, value)


inline var VkImageViewHandleInfoNVX.type: VkStructureType
    get() = VkStructureType(VkImageViewHandleInfoNVX.nsType(adr))
    set(value) = VkImageViewHandleInfoNVX.nsType(adr, value.i)
inline var VkImageViewHandleInfoNVX.next: Ptr
    get() = VkImageViewHandleInfoNVX.npNext(adr)
    set(value) = VkImageViewHandleInfoNVX.npNext(adr, value)
inline var VkImageViewHandleInfoNVX.imageView: VkImageView
    get() = VkImageView(VkImageViewHandleInfoNVX.nimageView(adr))
    set(value) = VkImageViewHandleInfoNVX.nimageView(adr, value.L)
inline var VkImageViewHandleInfoNVX.descriptorType: VkDescriptorType
    get() = VkDescriptorType(VkImageViewHandleInfoNVX.ndescriptorType(adr))
    set(value) = VkImageViewHandleInfoNVX.ndescriptorType(adr, value.i)
inline var VkImageViewHandleInfoNVX.sampler: VkSampler
    get() = VkSampler(VkImageViewHandleInfoNVX.nsampler(adr))
    set(value) = VkImageViewHandleInfoNVX.nsampler(adr, value.L)


inline var VkTextureLODGatherFormatPropertiesAMD.type: VkStructureType
    get() = VkStructureType(VkTextureLODGatherFormatPropertiesAMD.nsType(adr))
    set(value) = VkTextureLODGatherFormatPropertiesAMD.nsType(adr, value.i)
inline var VkTextureLODGatherFormatPropertiesAMD.next: Ptr
    get() = VkTextureLODGatherFormatPropertiesAMD.npNext(adr)
    set(value) = VkTextureLODGatherFormatPropertiesAMD.npNext(adr, value)
inline val VkTextureLODGatherFormatPropertiesAMD.supportsTextureGatherLODBiasAMD: Boolean
    get() = VkTextureLODGatherFormatPropertiesAMD.nsupportsTextureGatherLODBiasAMD(adr).bool


inline class VkShaderInfoTypeAMD(val i: Int) {
    companion object {
        val STATISTICS_AMD = VkShaderInfoTypeAMD(0)
        val BINARY_AMD = VkShaderInfoTypeAMD(1)
        val DISASSEMBLY_AMD = VkShaderInfoTypeAMD(2)
    }
}


inline val VkShaderResourceUsageAMD.numUsedVgprs: Int
    get() = VkShaderResourceUsageAMD.nnumUsedVgprs(adr)
inline val VkShaderResourceUsageAMD.numUsedSgprs: Int
    get() = VkShaderResourceUsageAMD.nnumUsedSgprs(adr)
inline val VkShaderResourceUsageAMD.ldsSizePerLocalWorkGroup: Int
    get() = VkShaderResourceUsageAMD.nldsSizePerLocalWorkGroup(adr)
inline val VkShaderResourceUsageAMD.ldsUsageSizeInBytes: Long
    get() = VkShaderResourceUsageAMD.nldsUsageSizeInBytes(adr)
inline val VkShaderResourceUsageAMD.scratchMemUsageInBytes: Long
    get() = VkShaderResourceUsageAMD.nscratchMemUsageInBytes(adr)


inline val VkShaderStatisticsInfoAMD.shaderStageMask: VkShaderStageFlags
    get() = VkShaderStatisticsInfoAMD.nshaderStageMask(adr)
inline val VkShaderStatisticsInfoAMD.resourceUsage: VkShaderResourceUsageAMD
    get() = VkShaderStatisticsInfoAMD.nresourceUsage(adr)
inline val VkShaderStatisticsInfoAMD.numPhysicalVgprs: Int
    get() = VkShaderStatisticsInfoAMD.nnumPhysicalVgprs(adr)
inline val VkShaderStatisticsInfoAMD.numPhysicalSgprs: Int
    get() = VkShaderStatisticsInfoAMD.nnumPhysicalSgprs(adr)
inline val VkShaderStatisticsInfoAMD.numAvailableVgprs: Int
    get() = VkShaderStatisticsInfoAMD.nnumAvailableVgprs(adr)
inline val VkShaderStatisticsInfoAMD.numAvailableSgprs: Int
    get() = VkShaderStatisticsInfoAMD.nnumAvailableSgprs(adr)
inline val VkShaderStatisticsInfoAMD.computeWorkGroupSize: IntBuffer
    get() = VkShaderStatisticsInfoAMD.ncomputeWorkGroupSize(adr)


inline var VkPhysicalDeviceCornerSampledImageFeaturesNV.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceCornerSampledImageFeaturesNV.nsType(adr))
    set(value) = VkPhysicalDeviceCornerSampledImageFeaturesNV.nsType(adr, value.i)
inline var VkPhysicalDeviceCornerSampledImageFeaturesNV.next: Ptr
    get() = VkPhysicalDeviceCornerSampledImageFeaturesNV.npNext(adr)
    set(value) = VkPhysicalDeviceCornerSampledImageFeaturesNV.npNext(adr, value)
inline val VkPhysicalDeviceCornerSampledImageFeaturesNV.cornerSampledImage: Boolean
    get() = VkPhysicalDeviceCornerSampledImageFeaturesNV.ncornerSampledImage(adr).bool


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


inline val VkExternalImageFormatPropertiesNV.imageFormatProperties: VkImageFormatProperties
    get() = VkExternalImageFormatPropertiesNV.nimageFormatProperties(adr)
inline val VkExternalImageFormatPropertiesNV.externalMemoryFeatures: VkExternalMemoryFeatureFlagsNV
    get() = VkExternalImageFormatPropertiesNV.nexternalMemoryFeatures(adr)
inline val VkExternalImageFormatPropertiesNV.exportFromImportedHandleTypes: VkExternalMemoryHandleTypeFlagsNV
    get() = VkExternalImageFormatPropertiesNV.nexportFromImportedHandleTypes(adr)
inline val VkExternalImageFormatPropertiesNV.compatibleHandleTypes: VkExternalMemoryHandleTypeFlagsNV
    get() = VkExternalImageFormatPropertiesNV.ncompatibleHandleTypes(adr)


inline var VkExternalMemoryImageCreateInfoNV.type: VkStructureType
    get() = VkStructureType(VkExternalMemoryImageCreateInfoNV.nsType(adr))
    set(value) = VkExternalMemoryImageCreateInfoNV.nsType(adr, value.i)
inline var VkExternalMemoryImageCreateInfoNV.next: Ptr
    get() = VkExternalMemoryImageCreateInfoNV.npNext(adr)
    set(value) = VkExternalMemoryImageCreateInfoNV.npNext(adr, value)
inline var VkExternalMemoryImageCreateInfoNV.handleTypes: VkExternalMemoryHandleTypeFlagsNV
    get() = VkExternalMemoryImageCreateInfoNV.nhandleTypes(adr)
    set(value) = VkExternalMemoryImageCreateInfoNV.nhandleTypes(adr, value)


inline var VkExportMemoryAllocateInfoNV.type: VkStructureType
    get() = VkStructureType(VkExportMemoryAllocateInfoNV.nsType(adr))
    set(value) = VkExportMemoryAllocateInfoNV.nsType(adr, value.i)
inline var VkExportMemoryAllocateInfoNV.next: Ptr
    get() = VkExportMemoryAllocateInfoNV.npNext(adr)
    set(value) = VkExportMemoryAllocateInfoNV.npNext(adr, value)
inline var VkExportMemoryAllocateInfoNV.handleTypes: VkExternalMemoryHandleTypeFlagsNV
    get() = VkExportMemoryAllocateInfoNV.nhandleTypes(adr)
    set(value) = VkExportMemoryAllocateInfoNV.nhandleTypes(adr, value)


inline class VkValidationCheckEXT(val i: Int) {
    companion object {
        val ALL_EXT = VkValidationCheckEXT(0)
        val SHADERS_EXT = VkValidationCheckEXT(1)
    }
}


inline var VkValidationFlagsEXT.type: VkStructureType
    get() = VkStructureType(VkValidationFlagsEXT.nsType(adr))
    set(value) = VkValidationFlagsEXT.nsType(adr, value.i)
inline var VkValidationFlagsEXT.next: Ptr
    get() = VkValidationFlagsEXT.npNext(adr)
    set(value) = VkValidationFlagsEXT.npNext(adr, value)
@Deprecated("this will be set automatically")
inline var VkValidationFlagsEXT.disabledValidationCheckCount: Int
    get() = VkValidationFlagsEXT.ndisabledValidationCheckCount(adr)
    set(value) = VkValidationFlagsEXT.ndisabledValidationCheckCount(adr, value)
inline var VkValidationFlagsEXT.disabledValidationChecks: IntBuffer
    get() = VkValidationFlagsEXT.npDisabledValidationChecks(adr)
    set(value) = VkValidationFlagsEXT.npDisabledValidationChecks(adr, value)


inline var VkPhysicalDeviceTextureCompressionASTCHDRFeaturesEXT.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceTextureCompressionASTCHDRFeaturesEXT.nsType(adr))
    set(value) = VkPhysicalDeviceTextureCompressionASTCHDRFeaturesEXT.nsType(adr, value.i)
inline var VkPhysicalDeviceTextureCompressionASTCHDRFeaturesEXT.next: Ptr
    get() = VkPhysicalDeviceTextureCompressionASTCHDRFeaturesEXT.npNext(adr)
    set(value) = VkPhysicalDeviceTextureCompressionASTCHDRFeaturesEXT.npNext(adr, value)
inline var VkPhysicalDeviceTextureCompressionASTCHDRFeaturesEXT.textureCompressionASTC_HDR: Boolean
    get() = VkPhysicalDeviceTextureCompressionASTCHDRFeaturesEXT.ntextureCompressionASTC_HDR(adr).bool
    set(value) = VkPhysicalDeviceTextureCompressionASTCHDRFeaturesEXT.ntextureCompressionASTC_HDR(adr, value.i)


inline var VkImageViewASTCDecodeModeEXT.type: VkStructureType
    get() = VkStructureType(VkImageViewASTCDecodeModeEXT.nsType(adr))
    set(value) = VkImageViewASTCDecodeModeEXT.nsType(adr, value.i)
inline var VkImageViewASTCDecodeModeEXT.next: Ptr
    get() = VkImageViewASTCDecodeModeEXT.npNext(adr)
    set(value) = VkImageViewASTCDecodeModeEXT.npNext(adr, value)
inline var VkImageViewASTCDecodeModeEXT.decodeMode: VkFormat
    get() = VkFormat(VkImageViewASTCDecodeModeEXT.ndecodeMode(adr))
    set(value) = VkImageViewASTCDecodeModeEXT.ndecodeMode(adr, value.i)


inline var VkPhysicalDeviceASTCDecodeFeaturesEXT.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceASTCDecodeFeaturesEXT.nsType(adr))
    set(value) = VkPhysicalDeviceASTCDecodeFeaturesEXT.nsType(adr, value.i)
inline var VkPhysicalDeviceASTCDecodeFeaturesEXT.next: Ptr
    get() = VkPhysicalDeviceASTCDecodeFeaturesEXT.npNext(adr)
    set(value) = VkPhysicalDeviceASTCDecodeFeaturesEXT.npNext(adr, value)
inline var VkPhysicalDeviceASTCDecodeFeaturesEXT.decodeModeSharedExponent: Boolean
    get() = VkPhysicalDeviceASTCDecodeFeaturesEXT.ndecodeModeSharedExponent(adr).bool
    set(value) = VkPhysicalDeviceASTCDecodeFeaturesEXT.ndecodeModeSharedExponent(adr, value.i)


inline class VkConditionalRenderingEXT(val i: Int) {
    companion object {
        val INVERTED_BIT_EXT = VkConditionalRenderingEXT(0x00000001)
    }
}

typealias VkConditionalRenderingFlagsEXT = VkFlags


inline var VkConditionalRenderingBeginInfoEXT.type: VkStructureType
    get() = VkStructureType(VkConditionalRenderingBeginInfoEXT.nsType(adr))
    set(value) = VkConditionalRenderingBeginInfoEXT.nsType(adr, value.i)
inline var VkConditionalRenderingBeginInfoEXT.next: Ptr
    get() = VkConditionalRenderingBeginInfoEXT.npNext(adr)
    set(value) = VkConditionalRenderingBeginInfoEXT.npNext(adr, value)
inline var VkConditionalRenderingBeginInfoEXT.buffer: VkBuffer
    get() = VkBuffer(VkConditionalRenderingBeginInfoEXT.nbuffer(adr))
    set(value) = VkConditionalRenderingBeginInfoEXT.nbuffer(adr, value.L)
inline var VkConditionalRenderingBeginInfoEXT.offset: VkDeviceSize
    get() = VkDeviceSize(VkConditionalRenderingBeginInfoEXT.nbuffer(adr))
    set(value) = VkConditionalRenderingBeginInfoEXT.nbuffer(adr, value.L)
inline var VkConditionalRenderingBeginInfoEXT.flags: VkConditionalRenderingFlagsEXT
    get() = VkConditionalRenderingBeginInfoEXT.nflags(adr)
    set(value) = VkConditionalRenderingBeginInfoEXT.nflags(adr, value)


inline var VkPhysicalDeviceConditionalRenderingFeaturesEXT.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceConditionalRenderingFeaturesEXT.nsType(adr))
    set(value) = VkPhysicalDeviceConditionalRenderingFeaturesEXT.nsType(adr, value.i)
inline var VkPhysicalDeviceConditionalRenderingFeaturesEXT.next: Ptr
    get() = VkPhysicalDeviceConditionalRenderingFeaturesEXT.npNext(adr)
    set(value) = VkPhysicalDeviceConditionalRenderingFeaturesEXT.npNext(adr, value)
inline var VkPhysicalDeviceConditionalRenderingFeaturesEXT.conditionalRendering: Boolean
    get() = VkPhysicalDeviceConditionalRenderingFeaturesEXT.nconditionalRendering(adr).bool
    set(value) = VkPhysicalDeviceConditionalRenderingFeaturesEXT.nconditionalRendering(adr, value.i)
inline var VkPhysicalDeviceConditionalRenderingFeaturesEXT.inheritedConditionalRendering: Boolean
    get() = VkPhysicalDeviceConditionalRenderingFeaturesEXT.ninheritedConditionalRendering(adr).bool
    set(value) = VkPhysicalDeviceConditionalRenderingFeaturesEXT.ninheritedConditionalRendering(adr, value.i)


inline var VkCommandBufferInheritanceConditionalRenderingInfoEXT.type: VkStructureType
    get() = VkStructureType(VkCommandBufferInheritanceConditionalRenderingInfoEXT.nsType(adr))
    set(value) = VkCommandBufferInheritanceConditionalRenderingInfoEXT.nsType(adr, value.i)
inline var VkCommandBufferInheritanceConditionalRenderingInfoEXT.next: Ptr
    get() = VkCommandBufferInheritanceConditionalRenderingInfoEXT.npNext(adr)
    set(value) = VkCommandBufferInheritanceConditionalRenderingInfoEXT.npNext(adr, value)
inline var VkCommandBufferInheritanceConditionalRenderingInfoEXT.conditionalRenderingEnable: Boolean
    get() = VkCommandBufferInheritanceConditionalRenderingInfoEXT.nconditionalRenderingEnable(adr).bool
    set(value) = VkCommandBufferInheritanceConditionalRenderingInfoEXT.nconditionalRenderingEnable(adr, value.i)


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


inline var VkDeviceGeneratedCommandsFeaturesNVX.type: VkStructureType
    get() = VkStructureType(VkDeviceGeneratedCommandsFeaturesNVX.nsType(adr))
    set(value) = VkDeviceGeneratedCommandsFeaturesNVX.nsType(adr, value.i)
inline var VkDeviceGeneratedCommandsFeaturesNVX.next: Ptr
    get() = VkDeviceGeneratedCommandsFeaturesNVX.npNext(adr)
    set(value) = VkDeviceGeneratedCommandsFeaturesNVX.npNext(adr, value)
inline var VkDeviceGeneratedCommandsFeaturesNVX.computeBindingPointSupport: Boolean
    get() = VkDeviceGeneratedCommandsFeaturesNVX.ncomputeBindingPointSupport(adr).bool
    set(value) = VkDeviceGeneratedCommandsFeaturesNVX.ncomputeBindingPointSupport(adr, value.i)


inline var VkDeviceGeneratedCommandsLimitsNVX.type: VkStructureType
    get() = VkStructureType(VkDeviceGeneratedCommandsLimitsNVX.nsType(adr))
    set(value) = VkDeviceGeneratedCommandsLimitsNVX.nsType(adr, value.i)
inline var VkDeviceGeneratedCommandsLimitsNVX.next: Ptr
    get() = VkDeviceGeneratedCommandsLimitsNVX.npNext(adr)
    set(value) = VkDeviceGeneratedCommandsLimitsNVX.npNext(adr, value)
inline var VkDeviceGeneratedCommandsLimitsNVX.maxIndirectCommandsLayoutTokenCount: Int
    get() = VkDeviceGeneratedCommandsLimitsNVX.nmaxIndirectCommandsLayoutTokenCount(adr)
    set(value) = VkDeviceGeneratedCommandsLimitsNVX.nmaxIndirectCommandsLayoutTokenCount(adr, value)
inline var VkDeviceGeneratedCommandsLimitsNVX.maxObjectEntryCounts: Int
    get() = VkDeviceGeneratedCommandsLimitsNVX.nmaxObjectEntryCounts(adr)
    set(value) = VkDeviceGeneratedCommandsLimitsNVX.nmaxObjectEntryCounts(adr, value)
inline var VkDeviceGeneratedCommandsLimitsNVX.minSequenceCountBufferOffsetAlignment: Int
    get() = VkDeviceGeneratedCommandsLimitsNVX.nminSequenceCountBufferOffsetAlignment(adr)
    set(value) = VkDeviceGeneratedCommandsLimitsNVX.nminSequenceCountBufferOffsetAlignment(adr, value)
inline var VkDeviceGeneratedCommandsLimitsNVX.minSequenceIndexBufferOffsetAlignment: Int
    get() = VkDeviceGeneratedCommandsLimitsNVX.nminSequenceIndexBufferOffsetAlignment(adr)
    set(value) = VkDeviceGeneratedCommandsLimitsNVX.nminSequenceIndexBufferOffsetAlignment(adr, value)
inline var VkDeviceGeneratedCommandsLimitsNVX.minCommandsTokenBufferOffsetAlignment: Int
    get() = VkDeviceGeneratedCommandsLimitsNVX.nminCommandsTokenBufferOffsetAlignment(adr)
    set(value) = VkDeviceGeneratedCommandsLimitsNVX.nminCommandsTokenBufferOffsetAlignment(adr, value)


inline var VkIndirectCommandsTokenNVX.tokenType: VkIndirectCommandsTokenTypeNVX
    get() = VkIndirectCommandsTokenTypeNVX(VkIndirectCommandsTokenNVX.ntokenType(adr))
    set(value) = VkIndirectCommandsTokenNVX.ntokenType(adr, value.i)
inline var VkIndirectCommandsTokenNVX.buffer: VkBuffer
    get() = VkBuffer(VkIndirectCommandsTokenNVX.nbuffer(adr))
    set(value) = VkIndirectCommandsTokenNVX.nbuffer(adr, value.L)
inline var VkIndirectCommandsTokenNVX.offset: VkDeviceSize
    get() = VkDeviceSize(VkIndirectCommandsTokenNVX.noffset(adr))
    set(value) = VkIndirectCommandsTokenNVX.noffset(adr, value.L)


inline var VkIndirectCommandsLayoutTokenNVX.tokenType: VkIndirectCommandsTokenTypeNVX
    get() = VkIndirectCommandsTokenTypeNVX(VkIndirectCommandsLayoutTokenNVX.ntokenType(adr))
    set(value) = VkIndirectCommandsLayoutTokenNVX.ntokenType(adr, value.i)
inline var VkIndirectCommandsLayoutTokenNVX.bindingUnit: Int
    get() = VkIndirectCommandsLayoutTokenNVX.nbindingUnit(adr)
    set(value) = VkIndirectCommandsLayoutTokenNVX.nbindingUnit(adr, value)
inline var VkIndirectCommandsLayoutTokenNVX.dynamicCount: Int
    get() = VkIndirectCommandsLayoutTokenNVX.ndynamicCount(adr)
    set(value) = VkIndirectCommandsLayoutTokenNVX.ndynamicCount(adr, value)
inline var VkIndirectCommandsLayoutTokenNVX.divisor: Int
    get() = VkIndirectCommandsLayoutTokenNVX.ndivisor(adr)
    set(value) = VkIndirectCommandsLayoutTokenNVX.ndivisor(adr, value)


inline var VkIndirectCommandsLayoutCreateInfoNVX.type: VkStructureType
    get() = VkStructureType(VkIndirectCommandsLayoutCreateInfoNVX.nsType(adr))
    set(value) = VkIndirectCommandsLayoutCreateInfoNVX.nsType(adr, value.i)
inline var VkIndirectCommandsLayoutCreateInfoNVX.next: Ptr
    get() = VkIndirectCommandsLayoutCreateInfoNVX.npNext(adr)
    set(value) = VkIndirectCommandsLayoutCreateInfoNVX.npNext(adr, value)
inline var VkIndirectCommandsLayoutCreateInfoNVX.pipelineBindPoint: VkPipelineBindPoint
    get() = VkPipelineBindPoint(VkIndirectCommandsLayoutCreateInfoNVX.npipelineBindPoint(adr))
    set(value) = VkIndirectCommandsLayoutCreateInfoNVX.npipelineBindPoint(adr, value.i)
inline var VkIndirectCommandsLayoutCreateInfoNVX.flags: VkIndirectCommandsLayoutUsageFlagsNVX
    get() = VkIndirectCommandsLayoutCreateInfoNVX.nflags(adr)
    set(value) = VkIndirectCommandsLayoutCreateInfoNVX.nflags(adr, value)
@Deprecated("this will be set automatically")
inline var VkIndirectCommandsLayoutCreateInfoNVX.tokenCount: Int
    get() = VkIndirectCommandsLayoutCreateInfoNVX.ntokenCount(adr)
    set(value) = VkIndirectCommandsLayoutCreateInfoNVX.ntokenCount(adr, value)
inline var VkIndirectCommandsLayoutCreateInfoNVX.tokens: VkIndirectCommandsLayoutTokenNVX.Buffer
    get() = VkIndirectCommandsLayoutCreateInfoNVX.npTokens(adr)
    set(value) = VkIndirectCommandsLayoutCreateInfoNVX.npTokens(adr, value)


inline var VkCmdProcessCommandsInfoNVX.type: VkStructureType
    get() = VkStructureType(VkCmdProcessCommandsInfoNVX.nsType(adr))
    set(value) = VkCmdProcessCommandsInfoNVX.nsType(adr, value.i)
inline var VkCmdProcessCommandsInfoNVX.next: Ptr
    get() = VkCmdProcessCommandsInfoNVX.npNext(adr)
    set(value) = VkCmdProcessCommandsInfoNVX.npNext(adr, value)
inline var VkCmdProcessCommandsInfoNVX.objectTable: VkObjectTableNVX
    get() = VkObjectTableNVX(VkCmdProcessCommandsInfoNVX.nobjectTable(adr))
    set(value) = VkCmdProcessCommandsInfoNVX.nobjectTable(adr, value.L)
inline var VkCmdProcessCommandsInfoNVX.indirectCommandsLayout: VkIndirectCommandsLayoutNVX
    get() = VkIndirectCommandsLayoutNVX(VkCmdProcessCommandsInfoNVX.nindirectCommandsLayout(adr))
    set(value) = VkCmdProcessCommandsInfoNVX.nindirectCommandsLayout(adr, value.L)
@Deprecated("this will be set automatically")
inline var VkCmdProcessCommandsInfoNVX.indirectCommandsTokenCount: Int
    get() = VkCmdProcessCommandsInfoNVX.nindirectCommandsTokenCount(adr)
    set(value) = VkCmdProcessCommandsInfoNVX.nindirectCommandsTokenCount(adr, value)
inline var VkCmdProcessCommandsInfoNVX.indirectCommandsTokens: VkIndirectCommandsTokenNVX.Buffer
    get() = VkCmdProcessCommandsInfoNVX.npIndirectCommandsTokens(adr)
    set(value) = VkCmdProcessCommandsInfoNVX.npIndirectCommandsTokens(adr, value)
inline var VkCmdProcessCommandsInfoNVX.maxSequencesCount: Int
    get() = VkCmdProcessCommandsInfoNVX.nmaxSequencesCount(adr)
    set(value) = VkCmdProcessCommandsInfoNVX.nmaxSequencesCount(adr, value)
inline var VkCmdProcessCommandsInfoNVX.targetCommandBuffer: Ptr
    get() = VkCmdProcessCommandsInfoNVX.ntargetCommandBuffer(adr)
    set(value) = memPutAddress(adr + VkCmdProcessCommandsInfoNVX.TARGETCOMMANDBUFFER, value)
inline var VkCmdProcessCommandsInfoNVX.sequencesCountOffset: VkDeviceSize
    get() = VkDeviceSize(VkCmdProcessCommandsInfoNVX.nsequencesCountOffset(adr))
    set(value) = VkCmdProcessCommandsInfoNVX.nsequencesCountOffset(adr, value.L)
inline var VkCmdProcessCommandsInfoNVX.sequencesIndexBuffer: VkBuffer
    get() = VkBuffer(VkCmdProcessCommandsInfoNVX.nsequencesIndexBuffer(adr))
    set(value) = VkCmdProcessCommandsInfoNVX.nsequencesIndexBuffer(adr, value.L)
inline var VkCmdProcessCommandsInfoNVX.sequencesIndexOffset: VkDeviceSize
    get() = VkDeviceSize(VkCmdProcessCommandsInfoNVX.nsequencesIndexOffset(adr))
    set(value) = VkCmdProcessCommandsInfoNVX.nsequencesIndexOffset(adr, value.L)


inline var VkCmdReserveSpaceForCommandsInfoNVX.type: VkStructureType
    get() = VkStructureType(VkCmdReserveSpaceForCommandsInfoNVX.nsType(adr))
    set(value) = VkCmdReserveSpaceForCommandsInfoNVX.nsType(adr, value.i)
inline var VkCmdReserveSpaceForCommandsInfoNVX.next: Ptr
    get() = VkCmdReserveSpaceForCommandsInfoNVX.npNext(adr)
    set(value) = VkCmdReserveSpaceForCommandsInfoNVX.npNext(adr, value)
inline var VkCmdReserveSpaceForCommandsInfoNVX.objectTable: VkObjectTableNVX
    get() = VkObjectTableNVX(VkCmdReserveSpaceForCommandsInfoNVX.nobjectTable(adr))
    set(value) = VkCmdReserveSpaceForCommandsInfoNVX.nobjectTable(adr, value.L)
inline var VkCmdReserveSpaceForCommandsInfoNVX.indirectCommandsLayout: VkIndirectCommandsLayoutNVX
    get() = VkIndirectCommandsLayoutNVX(VkCmdReserveSpaceForCommandsInfoNVX.nindirectCommandsLayout(adr))
    set(value) = VkCmdReserveSpaceForCommandsInfoNVX.nindirectCommandsLayout(adr, value.L)
inline var VkCmdReserveSpaceForCommandsInfoNVX.maxSequencesCount: Int
    get() = VkCmdReserveSpaceForCommandsInfoNVX.nmaxSequencesCount(adr)
    set(value) = VkCmdReserveSpaceForCommandsInfoNVX.nmaxSequencesCount(adr, value)


inline var VkObjectTableCreateInfoNVX.type: VkStructureType
    get() = VkStructureType(VkObjectTableCreateInfoNVX.nsType(adr))
    set(value) = VkObjectTableCreateInfoNVX.nsType(adr, value.i)
inline var VkObjectTableCreateInfoNVX.next: Ptr
    get() = VkObjectTableCreateInfoNVX.npNext(adr)
    set(value) = VkObjectTableCreateInfoNVX.npNext(adr, value)
inline var VkObjectTableCreateInfoNVX.objectCount: Int
    get() = VkObjectTableCreateInfoNVX.nobjectCount(adr)
    set(value) = VkObjectTableCreateInfoNVX.nobjectCount(adr, value)
inline var VkObjectTableCreateInfoNVX.objectEntryTypes: VkObjectEntryTypeNVX_Buffer
    get() = VkObjectEntryTypeNVX_Buffer(VkObjectTableCreateInfoNVX.npObjectEntryTypes(adr))
    set(value) = VkObjectTableCreateInfoNVX.npObjectEntryTypes(adr, value.buffer)
inline var VkObjectTableCreateInfoNVX.objectEntryCounts: IntBuffer
    get() = VkObjectTableCreateInfoNVX.npObjectEntryCounts(adr)
    set(value) = VkObjectTableCreateInfoNVX.npObjectEntryCounts(adr, value)
inline var VkObjectTableCreateInfoNVX.objectEntryUsageFlags: VkObjectEntryUsageFlagsNVX_Buffer
    get() = VkObjectEntryUsageFlagsNVX_Buffer(VkObjectTableCreateInfoNVX.npObjectEntryUsageFlags(adr))
    set(value) = VkObjectTableCreateInfoNVX.npObjectEntryUsageFlags(adr, value.buffer)
inline var VkObjectTableCreateInfoNVX.maxUniformBuffersPerDescriptor: Int
    get() = VkObjectTableCreateInfoNVX.nmaxUniformBuffersPerDescriptor(adr)
    set(value) = VkObjectTableCreateInfoNVX.nmaxUniformBuffersPerDescriptor(adr, value)
inline var VkObjectTableCreateInfoNVX.maxStorageBuffersPerDescriptor: Int
    get() = VkObjectTableCreateInfoNVX.nmaxStorageBuffersPerDescriptor(adr)
    set(value) = VkObjectTableCreateInfoNVX.nmaxStorageBuffersPerDescriptor(adr, value)
inline var VkObjectTableCreateInfoNVX.maxStorageImagesPerDescriptor: Int
    get() = VkObjectTableCreateInfoNVX.nmaxStorageImagesPerDescriptor(adr)
    set(value) = VkObjectTableCreateInfoNVX.nmaxStorageImagesPerDescriptor(adr, value)
inline var VkObjectTableCreateInfoNVX.maxSampledImagesPerDescriptor: Int
    get() = VkObjectTableCreateInfoNVX.nmaxSampledImagesPerDescriptor(adr)
    set(value) = VkObjectTableCreateInfoNVX.nmaxSampledImagesPerDescriptor(adr, value)
inline var VkObjectTableCreateInfoNVX.maxPipelineLayouts: Int
    get() = VkObjectTableCreateInfoNVX.nmaxPipelineLayouts(adr)
    set(value) = VkObjectTableCreateInfoNVX.nmaxPipelineLayouts(adr, value)


inline var VkObjectTableEntryNVX.type: VkObjectEntryTypeNVX
    get() = VkObjectEntryTypeNVX(VkObjectTableEntryNVX.ntype(adr))
    set(value) = VkObjectTableEntryNVX.ntype(adr, value.i)
inline var VkObjectTableEntryNVX.flags: VkObjectEntryUsageFlagsNVX
    get() = VkObjectTableEntryNVX.nflags(adr)
    set(value) = VkObjectTableEntryNVX.nflags(adr, value)


inline var VkObjectTablePipelineEntryNVX.type: VkObjectEntryTypeNVX
    get() = VkObjectEntryTypeNVX(VkObjectTablePipelineEntryNVX.ntype(adr))
    set(value) = VkObjectTablePipelineEntryNVX.ntype(adr, value.i)
inline var VkObjectTablePipelineEntryNVX.flags: VkObjectEntryUsageFlagsNVX
    get() = VkObjectTablePipelineEntryNVX.nflags(adr)
    set(value) = VkObjectTablePipelineEntryNVX.nflags(adr, value)
inline var VkObjectTablePipelineEntryNVX.pipeline: VkPipeline
    get() = VkPipeline(VkObjectTablePipelineEntryNVX.npipeline(adr))
    set(value) = VkObjectTablePipelineEntryNVX.npipeline(adr, value.L)


inline var VkObjectTableDescriptorSetEntryNVX.type: VkObjectEntryTypeNVX
    get() = VkObjectEntryTypeNVX(VkObjectTableDescriptorSetEntryNVX.ntype(adr))
    set(value) = VkObjectTableDescriptorSetEntryNVX.ntype(adr, value.i)
inline var VkObjectTableDescriptorSetEntryNVX.flags: VkObjectEntryUsageFlagsNVX
    get() = VkObjectTableDescriptorSetEntryNVX.nflags(adr)
    set(value) = VkObjectTableDescriptorSetEntryNVX.nflags(adr, value)
inline var VkObjectTableDescriptorSetEntryNVX.pipelineLayout: VkPipelineLayout
    get() = VkPipelineLayout(VkObjectTableDescriptorSetEntryNVX.npipelineLayout(adr))
    set(value) = VkObjectTableDescriptorSetEntryNVX.npipelineLayout(adr, value.L)
inline var VkObjectTableDescriptorSetEntryNVX.descriptorSet: VkDescriptorSet
    get() = VkDescriptorSet(VkObjectTableDescriptorSetEntryNVX.ndescriptorSet(adr))
    set(value) = VkObjectTableDescriptorSetEntryNVX.ndescriptorSet(adr, value.L)


inline var VkObjectTableVertexBufferEntryNVX.type: VkObjectEntryTypeNVX
    get() = VkObjectEntryTypeNVX(VkObjectTableVertexBufferEntryNVX.ntype(adr))
    set(value) = VkObjectTableVertexBufferEntryNVX.ntype(adr, value.i)
inline var VkObjectTableVertexBufferEntryNVX.flags: VkObjectEntryUsageFlagsNVX
    get() = VkObjectTableVertexBufferEntryNVX.nflags(adr)
    set(value) = VkObjectTableVertexBufferEntryNVX.nflags(adr, value)
inline var VkObjectTableVertexBufferEntryNVX.buffer: VkBuffer
    get() = VkBuffer(VkObjectTableVertexBufferEntryNVX.nbuffer(adr))
    set(value) = VkObjectTableVertexBufferEntryNVX.nbuffer(adr, value.L)


inline var VkObjectTableIndexBufferEntryNVX.type: VkObjectEntryTypeNVX
    get() = VkObjectEntryTypeNVX(VkObjectTableIndexBufferEntryNVX.ntype(adr))
    set(value) = VkObjectTableIndexBufferEntryNVX.ntype(adr, value.i)
inline var VkObjectTableIndexBufferEntryNVX.flags: VkObjectEntryUsageFlagsNVX
    get() = VkObjectTableIndexBufferEntryNVX.nflags(adr)
    set(value) = VkObjectTableIndexBufferEntryNVX.nflags(adr, value)
inline var VkObjectTableIndexBufferEntryNVX.buffer: VkBuffer
    get() = VkBuffer(VkObjectTableIndexBufferEntryNVX.nbuffer(adr))
    set(value) = VkObjectTableIndexBufferEntryNVX.nbuffer(adr, value.L)
inline var VkObjectTableIndexBufferEntryNVX.indexType: VkIndexType
    get() = VkIndexType(VkObjectTableIndexBufferEntryNVX.nindexType(adr))
    set(value) = VkObjectTableIndexBufferEntryNVX.nindexType(adr, value.i)


inline var VkObjectTablePushConstantEntryNVX.type: VkObjectEntryTypeNVX
    get() = VkObjectEntryTypeNVX(VkObjectTablePushConstantEntryNVX.ntype(adr))
    set(value) = VkObjectTablePushConstantEntryNVX.ntype(adr, value.i)
inline var VkObjectTablePushConstantEntryNVX.flags: VkObjectEntryUsageFlagsNVX
    get() = VkObjectTablePushConstantEntryNVX.nflags(adr)
    set(value) = VkObjectTablePushConstantEntryNVX.nflags(adr, value)
inline var VkObjectTablePushConstantEntryNVX.pipelineLayout: VkPipelineLayout
    get() = VkPipelineLayout(VkObjectTablePushConstantEntryNVX.npipelineLayout(adr))
    set(value) = VkObjectTablePushConstantEntryNVX.npipelineLayout(adr, value.L)
inline var VkObjectTablePushConstantEntryNVX.stageFlags: VkShaderStageFlags
    get() = VkObjectTablePushConstantEntryNVX.nstageFlags(adr)
    set(value) = VkObjectTablePushConstantEntryNVX.nstageFlags(adr, value)


inline var VkViewportWScalingNV.xCoeff: Float
    get() = VkViewportWScalingNV.nxcoeff(adr)
    set(value) = VkViewportWScalingNV.nxcoeff(adr, value)
inline var VkViewportWScalingNV.yCoeff: Float
    get() = VkViewportWScalingNV.nycoeff(adr)
    set(value) = VkViewportWScalingNV.nycoeff(adr, value)
/** JVM custom */
inline var VkViewportWScalingNV.coeff: Vec2
    get() = Vec2(xCoeff, yCoeff)
    set(value) {
        xCoeff = value.x
        yCoeff = value.y
    }


inline var VkPipelineViewportWScalingStateCreateInfoNV.type: VkStructureType
    get() = VkStructureType(VkPipelineViewportWScalingStateCreateInfoNV.nsType(adr))
    set(value) = VkPipelineViewportWScalingStateCreateInfoNV.nsType(adr, value.i)
inline var VkPipelineViewportWScalingStateCreateInfoNV.next: Ptr
    get() = VkPipelineViewportWScalingStateCreateInfoNV.npNext(adr)
    set(value) = VkPipelineViewportWScalingStateCreateInfoNV.npNext(adr, value)
inline var VkPipelineViewportWScalingStateCreateInfoNV.viewportWScalingEnable: Boolean
    get() = VkPipelineViewportWScalingStateCreateInfoNV.nviewportWScalingEnable(adr).bool
    set(value) = VkPipelineViewportWScalingStateCreateInfoNV.nviewportWScalingEnable(adr, value.i)
@Deprecated("this will be set automatically")
inline var VkPipelineViewportWScalingStateCreateInfoNV.viewportCount: Int
    get() = VkPipelineViewportWScalingStateCreateInfoNV.nviewportCount(adr)
    set(value) = VkPipelineViewportWScalingStateCreateInfoNV.nviewportCount(adr, value)
inline var VkPipelineViewportWScalingStateCreateInfoNV.viewportWScalings: VkViewportWScalingNV.Buffer?
    get() = VkPipelineViewportWScalingStateCreateInfoNV.npViewportWScalings(adr)
    set(value) = VkPipelineViewportWScalingStateCreateInfoNV.npViewportWScalings(adr, value)


inline class VkSurfaceCounterEXT(val i: Int) {
    companion object {
        val VBLANK_EXT = VkSurfaceCounterEXT(0x00000001)
    }
}

typealias VkSurfaceCounterFlagsEXT = VkFlags


inline var VkSurfaceCapabilities2EXT.type: VkStructureType
    get() = VkStructureType(VkSurfaceCapabilities2EXT.nsType(adr))
    set(value) = VkSurfaceCapabilities2EXT.nsType(adr, value.i)
inline var VkSurfaceCapabilities2EXT.next: Ptr
    get() = VkSurfaceCapabilities2EXT.npNext(adr)
    set(value) = VkSurfaceCapabilities2EXT.npNext(adr, value)
inline val VkSurfaceCapabilities2EXT.minImageCount: Int
    get() = VkSurfaceCapabilities2EXT.nminImageCount(adr)
inline val VkSurfaceCapabilities2EXT.maxImageCount: Int
    get() = VkSurfaceCapabilities2EXT.nmaxImageCount(adr)
inline val VkSurfaceCapabilities2EXT.currentExtent: VkExtent2D
    get() = VkSurfaceCapabilities2EXT.ncurrentExtent(adr)
inline val VkSurfaceCapabilities2EXT.minImageExtent: VkExtent2D
    get() = VkSurfaceCapabilities2EXT.nminImageExtent(adr)
inline val VkSurfaceCapabilities2EXT.maxImageExtent: VkExtent2D
    get() = VkSurfaceCapabilities2EXT.nmaxImageExtent(adr)
inline val VkSurfaceCapabilities2EXT.maxImageArrayLayers: Int
    get() = VkSurfaceCapabilities2EXT.nmaxImageArrayLayers(adr)
inline val VkSurfaceCapabilities2EXT.supportedTransforms: VkSurfaceTransformFlagsKHR
    get() = VkSurfaceCapabilities2EXT.nsupportedTransforms(adr)
inline val VkSurfaceCapabilities2EXT.currentTransform: VkSurfaceTransformKHR
    get() = VkSurfaceTransformKHR(VkSurfaceCapabilities2EXT.ncurrentTransform(adr))
inline val VkSurfaceCapabilities2EXT.supportedCompositeAlpha: VkCompositeAlphaFlagsKHR
    get() = VkSurfaceCapabilities2EXT.nsupportedCompositeAlpha(adr)
inline val VkSurfaceCapabilities2EXT.supportedUsageFlags: VkImageUsageFlags
    get() = VkSurfaceCapabilities2EXT.nsupportedUsageFlags(adr)
inline val VkSurfaceCapabilities2EXT.supportedSurfaceCounters: VkSurfaceCounterFlagsEXT
    get() = VkSurfaceCapabilities2EXT.nsupportedSurfaceCounters(adr)


inline class VkDisplayPowerStateEXT(val i: Int) {
    companion object {
        val OFF_EXT = VkDisplayPowerStateEXT(0)
        val SUSPEND_EXT = VkDisplayPowerStateEXT(1)
        val ON_EXT = VkDisplayPowerStateEXT(2)
    }
}


inline class VkDeviceEventTypeEXT(val i: Int) {
    companion object {
        val DISPLAY_HOTPLUG_EXT = VkDeviceEventTypeEXT(0)
    }
}


inline class VkDisplayEventTypeEXT(val i: Int) {
    companion object {
        val FIRST_PIXEL_OUT_EXT = VkDisplayEventTypeEXT(0)
    }
}


inline var VkDisplayPowerInfoEXT.type: VkStructureType
    get() = VkStructureType(VkDisplayPowerInfoEXT.nsType(adr))
    set(value) = VkDisplayPowerInfoEXT.nsType(adr, value.i)
inline var VkDisplayPowerInfoEXT.next: Ptr
    get() = VkDisplayPowerInfoEXT.npNext(adr)
    set(value) = VkDisplayPowerInfoEXT.npNext(adr, value)
inline var VkDisplayPowerInfoEXT.powerState: VkDisplayPowerStateEXT
    get() = VkDisplayPowerStateEXT(VkDisplayPowerInfoEXT.npowerState(adr))
    set(value) = VkDisplayPowerInfoEXT.npowerState(adr, value.i)


inline var VkDeviceEventInfoEXT.type: VkStructureType
    get() = VkStructureType(VkDeviceEventInfoEXT.nsType(adr))
    set(value) = VkDeviceEventInfoEXT.nsType(adr, value.i)
inline var VkDeviceEventInfoEXT.next: Ptr
    get() = VkDeviceEventInfoEXT.npNext(adr)
    set(value) = VkDeviceEventInfoEXT.npNext(adr, value)
inline var VkDeviceEventInfoEXT.deviceEvent: VkDeviceEventTypeEXT
    get() = VkDeviceEventTypeEXT(VkDeviceEventInfoEXT.ndeviceEvent(adr))
    set(value) = VkDeviceEventInfoEXT.ndeviceEvent(adr, value.i)


inline var VkDisplayEventInfoEXT.type: VkStructureType
    get() = VkStructureType(VkDisplayEventInfoEXT.nsType(adr))
    set(value) = VkDisplayEventInfoEXT.nsType(adr, value.i)
inline var VkDisplayEventInfoEXT.next: Ptr
    get() = VkDisplayEventInfoEXT.npNext(adr)
    set(value) = VkDisplayEventInfoEXT.npNext(adr, value)
inline var VkDisplayEventInfoEXT.deviceEvent: VkDisplayEventTypeEXT
    get() = VkDisplayEventTypeEXT(VkDisplayEventInfoEXT.ndisplayEvent(adr))
    set(value) = VkDisplayEventInfoEXT.ndisplayEvent(adr, value.i)


inline var VkSwapchainCounterCreateInfoEXT.type: VkStructureType
    get() = VkStructureType(VkSwapchainCounterCreateInfoEXT.nsType(adr))
    set(value) = VkSwapchainCounterCreateInfoEXT.nsType(adr, value.i)
inline var VkSwapchainCounterCreateInfoEXT.next: Ptr
    get() = VkSwapchainCounterCreateInfoEXT.npNext(adr)
    set(value) = VkSwapchainCounterCreateInfoEXT.npNext(adr, value)
inline var VkSwapchainCounterCreateInfoEXT.deviceEvent: VkSurfaceCounterFlagsEXT
    get() = VkSwapchainCounterCreateInfoEXT.nsurfaceCounters(adr)
    set(value) = VkSwapchainCounterCreateInfoEXT.nsurfaceCounters(adr, value)


inline val VkRefreshCycleDurationGOOGLE.refreshDuration: Long
    get() = VkRefreshCycleDurationGOOGLE.nrefreshDuration(adr)


inline val VkPastPresentationTimingGOOGLE.presentID: Int
    get() = VkPastPresentationTimingGOOGLE.npresentID(adr)
inline val VkPastPresentationTimingGOOGLE.desiredPresentTime: Long
    get() = VkPastPresentationTimingGOOGLE.ndesiredPresentTime(adr)
inline val VkPastPresentationTimingGOOGLE.actualPresentTime: Long
    get() = VkPastPresentationTimingGOOGLE.nactualPresentTime(adr)
inline val VkPastPresentationTimingGOOGLE.earliestPresentTime: Long
    get() = VkPastPresentationTimingGOOGLE.nearliestPresentTime(adr)
inline val VkPastPresentationTimingGOOGLE.presentMargin: Long
    get() = VkPastPresentationTimingGOOGLE.npresentMargin(adr)


inline var VkPresentTimeGOOGLE.presentID: Int
    get() = VkPresentTimeGOOGLE.npresentID(adr)
    set(value) = VkPresentTimeGOOGLE.npresentID(adr, value)
inline var VkPresentTimeGOOGLE.desiredPresentTime: Long
    get() = VkPresentTimeGOOGLE.ndesiredPresentTime(adr)
    set(value) = VkPresentTimeGOOGLE.ndesiredPresentTime(adr, value)


inline var VkPresentTimesInfoGOOGLE.type: VkStructureType
    get() = VkStructureType(VkPresentTimesInfoGOOGLE.nsType(adr))
    set(value) = VkPresentTimesInfoGOOGLE.nsType(adr, value.i)
inline var VkPresentTimesInfoGOOGLE.next: Ptr
    get() = VkPresentTimesInfoGOOGLE.npNext(adr)
    set(value) = VkPresentTimesInfoGOOGLE.npNext(adr, value)
inline var VkPresentTimesInfoGOOGLE.swapchainCount: Int
    get() = VkPresentTimesInfoGOOGLE.nswapchainCount(adr)
    @Deprecated("this will be set automatically")
    set(value) = VkPresentTimesInfoGOOGLE.nswapchainCount(adr, value)
inline var VkPresentTimesInfoGOOGLE.times: VkPresentTimeGOOGLE.Buffer?
    get() = VkPresentTimesInfoGOOGLE.npTimes(adr)
    set(value) = VkPresentTimesInfoGOOGLE.npTimes(adr, value)