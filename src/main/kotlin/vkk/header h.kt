package vkk

import glm_.bool
import glm_.i
import glm_.vec4.Vec4
import kool.Ptr
import kool.adr
import org.lwjgl.system.MemoryUtil
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


inline class VkDebugReportObjectType(val i: Int) {
    companion object {
        val UNKNOWN_EXT = VkDebugReportObjectType(0)
        val INSTANCE_EXT = VkDebugReportObjectType(1)
        val PHYSICAL_DEVICE_EXT = VkDebugReportObjectType(2)
        val DEVICE_EXT = VkDebugReportObjectType(3)
        val QUEUE_EXT = VkDebugReportObjectType(4)
        val SEMAPHORE_EXT = VkDebugReportObjectType(5)
        val COMMAND_BUFFER_EXT = VkDebugReportObjectType(6)
        val FENCE_EXT = VkDebugReportObjectType(7)
        val DEVICE_MEMORY_EXT = VkDebugReportObjectType(8)
        val BUFFER_EXT = VkDebugReportObjectType(9)
        val IMAGE_EXT = VkDebugReportObjectType(10)
        val EVENT_EXT = VkDebugReportObjectType(11)
        val QUERY_POOL_EXT = VkDebugReportObjectType(12)
        val BUFFER_VIEW_EXT = VkDebugReportObjectType(13)
        val IMAGE_VIEW_EXT = VkDebugReportObjectType(14)
        val SHADER_MODULE_EXT = VkDebugReportObjectType(15)
        val PIPELINE_CACHE_EXT = VkDebugReportObjectType(16)
        val PIPELINE_LAYOUT_EXT = VkDebugReportObjectType(17)
        val RENDER_PASS_EXT = VkDebugReportObjectType(18)
        val PIPELINE_EXT = VkDebugReportObjectType(19)
        val DESCRIPTOR_SET_LAYOUT_EXT = VkDebugReportObjectType(20)
        val SAMPLER_EXT = VkDebugReportObjectType(21)
        val DESCRIPTOR_POOL_EXT = VkDebugReportObjectType(22)
        val DESCRIPTOR_SET_EXT = VkDebugReportObjectType(23)
        val FRAMEBUFFER_EXT = VkDebugReportObjectType(24)
        val COMMAND_POOL_EXT = VkDebugReportObjectType(25)
        val SURFACE_KHR_EXT = VkDebugReportObjectType(26)
        val SWAPCHAIN_KHR_EXT = VkDebugReportObjectType(27)
        val DEBUG_REPORT_CALLBACK_EXT_EXT = VkDebugReportObjectType(28)
        val DISPLAY_KHR_EXT = VkDebugReportObjectType(29)
        val DISPLAY_MODE_KHR_EXT = VkDebugReportObjectType(30)
        val OBJECT_TABLE_NVX_EXT = VkDebugReportObjectType(31)
        val INDIRECT_COMMANDS_LAYOUT_NVX_EXT = VkDebugReportObjectType(32)
        val VALIDATION_CACHE_EXT_EXT = VkDebugReportObjectType(33)
        val SAMPLER_YCBCR_CONVERSION_EXT = VkDebugReportObjectType(1000156000)
        val DESCRIPTOR_UPDATE_TEMPLATE_EXT = VkDebugReportObjectType(1000085000)
        val ACCELERATION_STRUCTURE_NV_EXT = VkDebugReportObjectType(1000156000)
        val DEBUG_REPORT_EXT = VkDebugReportObjectType.DEBUG_REPORT_CALLBACK_EXT_EXT
        val VALIDATION_CACHE_EXT = VkDebugReportObjectType.VALIDATION_CACHE_EXT_EXT
        val DEBUG_REPORT_OBJECT_TYPE_DESCRIPTOR_UPDATE_TEMPLATE_KHR_EXT = VkDebugReportObjectType.DESCRIPTOR_UPDATE_TEMPLATE_EXT
        val SAMPLER_YCBCR_CONVERSION_KHR_EXT = VkDebugReportObjectType.SAMPLER_YCBCR_CONVERSION_EXT
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
inline var VkDebugMarkerObjectNameInfoEXT.objectType: VkDebugReportObjectType
    get() = VkDebugReportObjectType(VkDebugMarkerObjectNameInfoEXT.nobjectType(adr))
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
inline var VkDebugMarkerObjectTagInfoEXT.objectType: VkDebugReportObjectType
    get() = VkDebugReportObjectType(VkDebugMarkerObjectTagInfoEXT.nobjectType(adr))
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
//inline var VkCmdProcessCommandsInfoNVX.targetCommandBuffer: VkCommandBuffer
//    get() = VkCmdProcessCommandsInfoNVX.ntargetCommandBuffer(adr)
//    set(value) = VkCmdProcessCommandsInfoNVX.ntargetCommandBuffer(adr, value)
inline var VkCmdProcessCommandsInfoNVX.sequencesCountOffset: VkDeviceSize
    get() = VkDeviceSize(VkCmdProcessCommandsInfoNVX.nsequencesCountOffset(adr))
    set(value) = VkCmdProcessCommandsInfoNVX.nsequencesCountOffset(adr, value.L)
inline var VkCmdProcessCommandsInfoNVX.sequencesIndexBuffer: VkBuffer
    get() = VkBuffer(VkCmdProcessCommandsInfoNVX.nsequencesIndexBuffer(adr))
    set(value) = VkCmdProcessCommandsInfoNVX.nsequencesIndexBuffer(adr, value.L)
inline var VkCmdProcessCommandsInfoNVX.sequencesIndexOffset: VkDeviceSize
    get() = VkDeviceSize(VkCmdProcessCommandsInfoNVX.nsequencesIndexOffset(adr))
    set(value) = VkCmdProcessCommandsInfoNVX.nsequencesIndexOffset(adr, value.L)