package vkk

import glm_.bool
import glm_.i
import kool.Ptr
import kool.adr
import kool.stak
import org.lwjgl.vulkan.*
import vkk.entities.VkValidationCacheEXT
import java.nio.ByteBuffer
import java.nio.FloatBuffer
import java.nio.IntBuffer
import java.nio.LongBuffer


inline var VkPhysicalDeviceMultiviewPerViewAttributesPropertiesNVX.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceMultiviewPerViewAttributesPropertiesNVX.nsType(adr))
    set(value) = VkPhysicalDeviceMultiviewPerViewAttributesPropertiesNVX.nsType(adr, value.i)
inline var VkPhysicalDeviceMultiviewPerViewAttributesPropertiesNVX.next: Ptr
    get() = VkPhysicalDeviceMultiviewPerViewAttributesPropertiesNVX.npNext(adr)
    set(value) = VkPhysicalDeviceMultiviewPerViewAttributesPropertiesNVX.npNext(adr, value)
inline val VkPhysicalDeviceMultiviewPerViewAttributesPropertiesNVX.perViewPositionAllComponents: Boolean
    get() = VkPhysicalDeviceMultiviewPerViewAttributesPropertiesNVX.nperViewPositionAllComponents(adr).bool


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


inline var VkViewportSwizzleNV.x: VkViewportCoordinateSwizzleNV
    get() = VkViewportCoordinateSwizzleNV(VkViewportSwizzleNV.nx(adr))
    set(value) = VkViewportSwizzleNV.nx(adr, value.i)
inline var VkViewportSwizzleNV.y: VkViewportCoordinateSwizzleNV
    get() = VkViewportCoordinateSwizzleNV(VkViewportSwizzleNV.ny(adr))
    set(value) = VkViewportSwizzleNV.ny(adr, value.i)
inline var VkViewportSwizzleNV.z: VkViewportCoordinateSwizzleNV
    get() = VkViewportCoordinateSwizzleNV(VkViewportSwizzleNV.nz(adr))
    set(value) = VkViewportSwizzleNV.nz(adr, value.i)
inline var VkViewportSwizzleNV.w: VkViewportCoordinateSwizzleNV
    get() = VkViewportCoordinateSwizzleNV(VkViewportSwizzleNV.nw(adr))
    set(value) = VkViewportSwizzleNV.nw(adr, value.i)


inline var VkPipelineViewportSwizzleStateCreateInfoNV.type: VkStructureType
    get() = VkStructureType(VkPipelineViewportSwizzleStateCreateInfoNV.nsType(adr))
    set(value) = VkPipelineViewportSwizzleStateCreateInfoNV.nsType(adr, value.i)
inline var VkPipelineViewportSwizzleStateCreateInfoNV.next: Ptr
    get() = VkPipelineViewportSwizzleStateCreateInfoNV.npNext(adr)
    set(value) = VkPipelineViewportSwizzleStateCreateInfoNV.npNext(adr, value)
inline var VkPipelineViewportSwizzleStateCreateInfoNV.flags: VkPipelineViewportSwizzleStateCreateFlagsNV
    get() = VkPipelineViewportSwizzleStateCreateInfoNV.nflags(adr)
    set(value) = VkPipelineViewportSwizzleStateCreateInfoNV.nflags(adr, value)
inline var VkPipelineViewportSwizzleStateCreateInfoNV.viewportCount: Int
    get() = VkPipelineViewportSwizzleStateCreateInfoNV.nviewportCount(adr)
    @Deprecated("this will be set automatically")
    set(value) = VkPipelineViewportSwizzleStateCreateInfoNV.nviewportCount(adr, value)
inline var VkPipelineViewportSwizzleStateCreateInfoNV.viewportSwizzles: VkViewportSwizzleNV.Buffer
    get() = VkPipelineViewportSwizzleStateCreateInfoNV.npViewportSwizzles(adr)
    set(value) = VkPipelineViewportSwizzleStateCreateInfoNV.npViewportSwizzles(adr, value)


inline class VkDiscardRectangleModeEXT(val i: Int) {
    companion object {
        val INCLUSIVE_EXT = VkDiscardRectangleModeEXT(0)
        val EXCLUSIVE_EXT = VkDiscardRectangleModeEXT(1)
    }
}

typealias VkPipelineDiscardRectangleStateCreateFlagsEXT = VkFlags


inline var VkPhysicalDeviceDiscardRectanglePropertiesEXT.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceDiscardRectanglePropertiesEXT.nsType(adr))
    set(value) = VkPhysicalDeviceDiscardRectanglePropertiesEXT.nsType(adr, value.i)
inline var VkPhysicalDeviceDiscardRectanglePropertiesEXT.next: Ptr
    get() = VkPhysicalDeviceDiscardRectanglePropertiesEXT.npNext(adr)
    set(value) = VkPhysicalDeviceDiscardRectanglePropertiesEXT.npNext(adr, value)
inline val VkPhysicalDeviceDiscardRectanglePropertiesEXT.maxDiscardRectangles: Int
    get() = VkPhysicalDeviceDiscardRectanglePropertiesEXT.nmaxDiscardRectangles(adr)


inline var VkPipelineDiscardRectangleStateCreateInfoEXT.type: VkStructureType
    get() = VkStructureType(VkPipelineDiscardRectangleStateCreateInfoEXT.nsType(adr))
    set(value) = VkPipelineDiscardRectangleStateCreateInfoEXT.nsType(adr, value.i)
inline var VkPipelineDiscardRectangleStateCreateInfoEXT.next: Ptr
    get() = VkPipelineDiscardRectangleStateCreateInfoEXT.npNext(adr)
    set(value) = VkPipelineDiscardRectangleStateCreateInfoEXT.npNext(adr, value)
inline var VkPipelineDiscardRectangleStateCreateInfoEXT.flags: VkPipelineDiscardRectangleStateCreateFlagsEXT
    get() = VkPipelineDiscardRectangleStateCreateInfoEXT.nflags(adr)
    set(value) = VkPipelineDiscardRectangleStateCreateInfoEXT.nflags(adr, value)
inline var VkPipelineDiscardRectangleStateCreateInfoEXT.discardRectangleMode: VkDiscardRectangleModeEXT
    get() = VkDiscardRectangleModeEXT(VkPipelineDiscardRectangleStateCreateInfoEXT.ndiscardRectangleMode(adr))
    set(value) = VkPipelineDiscardRectangleStateCreateInfoEXT.ndiscardRectangleMode(adr, value.i)
inline var VkPipelineDiscardRectangleStateCreateInfoEXT.discardRectangleCount: Int
    get() = VkPipelineDiscardRectangleStateCreateInfoEXT.ndiscardRectangleCount(adr)
    @Deprecated("this will be set automatically")
    set(value) = VkPipelineDiscardRectangleStateCreateInfoEXT.ndiscardRectangleCount(adr, value)
inline var VkPipelineDiscardRectangleStateCreateInfoEXT.pDiscardRectangles: VkRect2D.Buffer?
    get() = VkPipelineDiscardRectangleStateCreateInfoEXT.npDiscardRectangles(adr)
    set(value) = VkPipelineDiscardRectangleStateCreateInfoEXT.npDiscardRectangles(adr, value)


inline class VkConservativeRasterizationModeEXT(val i: Int) {
    companion object {
        val DISABLED_EXT = VkConservativeRasterizationModeEXT(0)
        val OVERESTIMATE_EXT = VkConservativeRasterizationModeEXT(1)
        val UNDERESTIMATE_EXT = VkConservativeRasterizationModeEXT(2)
    }
}

typealias VkPipelineRasterizationConservativeStateCreateFlagsEXT = VkFlags


inline var VkPhysicalDeviceConservativeRasterizationPropertiesEXT.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceConservativeRasterizationPropertiesEXT.nsType(adr))
    set(value) = VkPhysicalDeviceConservativeRasterizationPropertiesEXT.nsType(adr, value.i)
inline var VkPhysicalDeviceConservativeRasterizationPropertiesEXT.next: Ptr
    get() = VkPhysicalDeviceConservativeRasterizationPropertiesEXT.npNext(adr)
    set(value) = VkPhysicalDeviceConservativeRasterizationPropertiesEXT.npNext(adr, value)
inline val VkPhysicalDeviceConservativeRasterizationPropertiesEXT.primitiveOverestimationSize: Float
    get() = VkPhysicalDeviceConservativeRasterizationPropertiesEXT.nprimitiveOverestimationSize(adr)
inline val VkPhysicalDeviceConservativeRasterizationPropertiesEXT.maxExtraPrimitiveOverestimationSize: Float
    get() = VkPhysicalDeviceConservativeRasterizationPropertiesEXT.nmaxExtraPrimitiveOverestimationSize(adr)
inline val VkPhysicalDeviceConservativeRasterizationPropertiesEXT.extraPrimitiveOverestimationSizeGranularity: Float
    get() = VkPhysicalDeviceConservativeRasterizationPropertiesEXT.nextraPrimitiveOverestimationSizeGranularity(adr)
inline val VkPhysicalDeviceConservativeRasterizationPropertiesEXT.primitiveUnderestimation: Boolean
    get() = VkPhysicalDeviceConservativeRasterizationPropertiesEXT.nprimitiveUnderestimation(adr).bool
inline val VkPhysicalDeviceConservativeRasterizationPropertiesEXT.conservativePointAndLineRasterization: Boolean
    get() = VkPhysicalDeviceConservativeRasterizationPropertiesEXT.nconservativePointAndLineRasterization(adr).bool
inline val VkPhysicalDeviceConservativeRasterizationPropertiesEXT.degenerateTrianglesRasterized: Boolean
    get() = VkPhysicalDeviceConservativeRasterizationPropertiesEXT.ndegenerateTrianglesRasterized(adr).bool
inline val VkPhysicalDeviceConservativeRasterizationPropertiesEXT.degenerateLinesRasterized: Boolean
    get() = VkPhysicalDeviceConservativeRasterizationPropertiesEXT.ndegenerateLinesRasterized(adr).bool
inline val VkPhysicalDeviceConservativeRasterizationPropertiesEXT.fullyCoveredFragmentShaderInputVariable: Boolean
    get() = VkPhysicalDeviceConservativeRasterizationPropertiesEXT.nfullyCoveredFragmentShaderInputVariable(adr).bool
inline val VkPhysicalDeviceConservativeRasterizationPropertiesEXT.conservativeRasterizationPostDepthCoverage: Boolean
    get() = VkPhysicalDeviceConservativeRasterizationPropertiesEXT.nconservativeRasterizationPostDepthCoverage(adr).bool


inline var VkPipelineRasterizationConservativeStateCreateInfoEXT.type: VkStructureType
    get() = VkStructureType(VkPipelineRasterizationConservativeStateCreateInfoEXT.nsType(adr))
    set(value) = VkPipelineRasterizationConservativeStateCreateInfoEXT.nsType(adr, value.i)
inline var VkPipelineRasterizationConservativeStateCreateInfoEXT.next: Ptr
    get() = VkPipelineRasterizationConservativeStateCreateInfoEXT.npNext(adr)
    set(value) = VkPipelineRasterizationConservativeStateCreateInfoEXT.npNext(adr, value)
inline var VkPipelineRasterizationConservativeStateCreateInfoEXT.flags: VkPipelineRasterizationConservativeStateCreateFlagsEXT
    get() = VkPipelineRasterizationConservativeStateCreateInfoEXT.nflags(adr)
    set(value) = VkPipelineRasterizationConservativeStateCreateInfoEXT.nflags(adr, value)
inline var VkPipelineRasterizationConservativeStateCreateInfoEXT.conservativeRasterizationMode: VkConservativeRasterizationModeEXT
    get() = VkConservativeRasterizationModeEXT(VkPipelineRasterizationConservativeStateCreateInfoEXT.nconservativeRasterizationMode(adr))
    set(value) = VkPipelineRasterizationConservativeStateCreateInfoEXT.nconservativeRasterizationMode(adr, value.i)
inline var VkPipelineRasterizationConservativeStateCreateInfoEXT.extraPrimitiveOverestimationSize: Float
    get() = VkPipelineRasterizationConservativeStateCreateInfoEXT.nextraPrimitiveOverestimationSize(adr)
    set(value) = VkPipelineRasterizationConservativeStateCreateInfoEXT.nextraPrimitiveOverestimationSize(adr, value)


inline var VkXYColorEXT.x: Float
    get() = VkXYColorEXT.nx(adr)
    set(value) = VkXYColorEXT.nx(adr, value)
inline var VkXYColorEXT.y: Float
    get() = VkXYColorEXT.ny(adr)
    set(value) = VkXYColorEXT.ny(adr, value)


inline var VkHdrMetadataEXT.type: VkStructureType
    get() = VkStructureType(VkHdrMetadataEXT.nsType(adr))
    set(value) = VkHdrMetadataEXT.nsType(adr, value.i)
inline var VkHdrMetadataEXT.next: Ptr
    get() = VkHdrMetadataEXT.npNext(adr)
    set(value) = VkHdrMetadataEXT.npNext(adr, value)
inline var VkHdrMetadataEXT.displayPrimaryRed: VkXYColorEXT
    get() = VkHdrMetadataEXT.ndisplayPrimaryRed(adr)
    set(value) = VkHdrMetadataEXT.ndisplayPrimaryRed(adr, value)
inline var VkHdrMetadataEXT.displayPrimaryGreen: VkXYColorEXT
    get() = VkHdrMetadataEXT.ndisplayPrimaryGreen(adr)
    set(value) = VkHdrMetadataEXT.ndisplayPrimaryGreen(adr, value)
inline var VkHdrMetadataEXT.displayPrimaryBlue: VkXYColorEXT
    get() = VkHdrMetadataEXT.ndisplayPrimaryBlue(adr)
    set(value) = VkHdrMetadataEXT.ndisplayPrimaryBlue(adr, value)
inline var VkHdrMetadataEXT.whitePoint: VkXYColorEXT
    get() = VkHdrMetadataEXT.nwhitePoint(adr)
    set(value) = VkHdrMetadataEXT.nwhitePoint(adr, value)
inline var VkHdrMetadataEXT.maxLuminance: Float
    get() = VkHdrMetadataEXT.nmaxLuminance(adr)
    set(value) = VkHdrMetadataEXT.nmaxLuminance(adr, value)
inline var VkHdrMetadataEXT.minLuminance: Float
    get() = VkHdrMetadataEXT.nminLuminance(adr)
    set(value) = VkHdrMetadataEXT.nminLuminance(adr, value)
inline var VkHdrMetadataEXT.maxContentLightLevel: Float
    get() = VkHdrMetadataEXT.nmaxContentLightLevel(adr)
    set(value) = VkHdrMetadataEXT.nmaxFrameAverageLightLevel(adr, value)
inline var VkHdrMetadataEXT.maxFrameAverageLightLevel: Float
    get() = VkHdrMetadataEXT.nmaxFrameAverageLightLevel(adr)
    set(value) = VkHdrMetadataEXT.nmaxFrameAverageLightLevel(adr, value)


typealias VkDebugUtilsMessengerCallbackDataFlagsEXT = VkFlags
typealias VkDebugUtilsMessengerCreateFlagsEXT = VkFlags

inline class VkDebugUtilsMessageSeverityEXT(val i: Int) {
    companion object {
        val VERBOSE_BIT_EXT = VkDebugUtilsMessageSeverityEXT(0x00000001)
        val INFO_BIT_EXT = VkDebugUtilsMessageSeverityEXT(0x00000010)
        val WARNING_BIT_EXT = VkDebugUtilsMessageSeverityEXT(0x00000100)
        val ERROR_BIT_EXT = VkDebugUtilsMessageSeverityEXT(0x00001000)
    }
}
typealias VkDebugUtilsMessageSeverityFlagsEXT = VkFlags

inline class VkDebugUtilsMessageTypeEXT(val i: Int) {
    companion object {
        val GENERAL_BIT_EXT = VkDebugUtilsMessageTypeEXT(0x00000001)
        val VALIDATION_BIT_EXT = VkDebugUtilsMessageTypeEXT(0x00000002)
        val PERFORMANCE_BIT_EXT = VkDebugUtilsMessageTypeEXT(0x00000004)
    }
}
typealias VkDebugUtilsMessageTypeFlagsEXT = VkFlags


inline var VkDebugUtilsObjectNameInfoEXT.type: VkStructureType
    get() = VkStructureType(VkDebugUtilsObjectNameInfoEXT.nsType(adr))
    set(value) = VkDebugUtilsObjectNameInfoEXT.nsType(adr, value.i)
inline var VkDebugUtilsObjectNameInfoEXT.next: Ptr
    get() = VkDebugUtilsObjectNameInfoEXT.npNext(adr)
    set(value) = VkDebugUtilsObjectNameInfoEXT.npNext(adr, value)
inline var VkDebugUtilsObjectNameInfoEXT.objectType: VkObjectType
    get() = VkObjectType(VkDebugUtilsObjectNameInfoEXT.nobjectType(adr))
    set(value) = VkDebugUtilsObjectNameInfoEXT.nobjectType(adr, value.i)
inline var VkDebugUtilsObjectNameInfoEXT.objectHandle: Long
    get() = VkDebugUtilsObjectNameInfoEXT.nobjectHandle(adr)
    set(value) = VkDebugUtilsObjectNameInfoEXT.nobjectHandle(adr, value)
inline var VkDebugUtilsObjectNameInfoEXT.objectName: String?
    get() = VkDebugUtilsObjectNameInfoEXT.npObjectNameString(adr)
    set(value) = when (value) {
        null -> VkDebugUtilsObjectNameInfoEXT.npObjectName(adr, null)
        else -> stak.asciiBuffer(value) { VkDebugUtilsObjectNameInfoEXT.npObjectName(adr, it) }
    }


inline var VkDebugUtilsObjectTagInfoEXT.type: VkStructureType
    get() = VkStructureType(VkDebugUtilsObjectTagInfoEXT.nsType(adr))
    set(value) = VkDebugUtilsObjectTagInfoEXT.nsType(adr, value.i)
inline var VkDebugUtilsObjectTagInfoEXT.next: Ptr
    get() = VkDebugUtilsObjectTagInfoEXT.npNext(adr)
    set(value) = VkDebugUtilsObjectTagInfoEXT.npNext(adr, value)
inline var VkDebugUtilsObjectTagInfoEXT.objectType: VkObjectType
    get() = VkObjectType(VkDebugUtilsObjectTagInfoEXT.nobjectType(adr))
    set(value) = VkDebugUtilsObjectTagInfoEXT.nobjectType(adr, value.i)
inline var VkDebugUtilsObjectTagInfoEXT.objectHandle: Long
    get() = VkDebugUtilsObjectTagInfoEXT.nobjectHandle(adr)
    set(value) = VkDebugUtilsObjectTagInfoEXT.nobjectHandle(adr, value)
inline var VkDebugUtilsObjectTagInfoEXT.tagName: Long
    get() = VkDebugUtilsObjectTagInfoEXT.ntagName(adr)
    set(value) = VkDebugUtilsObjectTagInfoEXT.ntagName(adr, value)
inline var VkDebugUtilsObjectTagInfoEXT.tagSize: Long
    get() = VkDebugUtilsObjectTagInfoEXT.ntagSize(adr)
    @Deprecated("this will be set automatically")
    set(value) = VkDebugUtilsObjectTagInfoEXT.ntagSize(adr, value)
inline var VkDebugUtilsObjectTagInfoEXT.tag: ByteBuffer
    get() = VkDebugUtilsObjectTagInfoEXT.npTag(adr)
    set(value) = VkDebugUtilsObjectTagInfoEXT.npTag(adr, value)


inline var VkDebugUtilsLabelEXT.type: VkStructureType
    get() = VkStructureType(VkDebugUtilsLabelEXT.nsType(adr))
    set(value) = VkDebugUtilsLabelEXT.nsType(adr, value.i)
inline var VkDebugUtilsLabelEXT.next: Ptr
    get() = VkDebugUtilsLabelEXT.npNext(adr)
    set(value) = VkDebugUtilsLabelEXT.npNext(adr, value)
inline var VkDebugUtilsLabelEXT.labelName: String
    get() = VkDebugUtilsLabelEXT.npLabelNameString(adr)
    set(value) = stak.asciiBuffer(value) { VkDebugUtilsLabelEXT.npLabelName(adr, it) }
inline var VkDebugUtilsLabelEXT.color: FloatBuffer
    get() = VkDebugUtilsLabelEXT.ncolor(adr)
    set(value) = VkDebugUtilsLabelEXT.ncolor(adr, value)


inline var VkDebugUtilsMessengerCallbackDataEXT.type: VkStructureType
    get() = VkStructureType(VkDebugUtilsMessengerCallbackDataEXT.nsType(adr))
    set(value) = VkDebugUtilsMessengerCallbackDataEXT.nsType(adr, value.i)
inline var VkDebugUtilsMessengerCallbackDataEXT.next: Ptr
    get() = VkDebugUtilsMessengerCallbackDataEXT.npNext(adr)
    set(value) = VkDebugUtilsMessengerCallbackDataEXT.npNext(adr, value)
inline var VkDebugUtilsMessengerCallbackDataEXT.flags: VkDebugUtilsMessengerCallbackDataFlagsEXT
    get() = VkDebugUtilsMessengerCallbackDataEXT.nflags(adr)
    set(value) = VkDebugUtilsMessengerCallbackDataEXT.nflags(adr, value)
inline var VkDebugUtilsMessengerCallbackDataEXT.messageIdName: String?
    get() = VkDebugUtilsMessengerCallbackDataEXT.npMessageIdNameString(adr)
    set(value) = when (value) {
        null -> VkDebugUtilsMessengerCallbackDataEXT.npMessageIdName(adr, null)
        else -> stak.asciiBuffer(value) { VkDebugUtilsMessengerCallbackDataEXT.npMessageIdName(adr, it) }
    }
inline var VkDebugUtilsMessengerCallbackDataEXT.message: String
    get() = VkDebugUtilsMessengerCallbackDataEXT.npMessageString(adr)
    set(value) = stak.asciiBuffer(value) { VkDebugUtilsMessengerCallbackDataEXT.npMessage(adr, it) }
inline var VkDebugUtilsMessengerCallbackDataEXT.queueLabelCount: Int
    get() = VkDebugUtilsMessengerCallbackDataEXT.nqueueLabelCount(adr)
    @Deprecated("this will be set automatically")
    set(value) = VkDebugUtilsMessengerCallbackDataEXT.nqueueLabelCount(adr, value)
inline var VkDebugUtilsMessengerCallbackDataEXT.queueLabels: VkDebugUtilsLabelEXT.Buffer?
    get() = VkDebugUtilsMessengerCallbackDataEXT.npQueueLabels(adr)
    set(value) = VkDebugUtilsMessengerCallbackDataEXT.npQueueLabels(adr, value)
inline var VkDebugUtilsMessengerCallbackDataEXT.cmdBufLabelCount: Int
    get() = VkDebugUtilsMessengerCallbackDataEXT.ncmdBufLabelCount(adr)
    @Deprecated("this will be set automatically")
    set(value) = VkDebugUtilsMessengerCallbackDataEXT.ncmdBufLabelCount(adr, value)
inline var VkDebugUtilsMessengerCallbackDataEXT.cmdBufLabels: VkDebugUtilsLabelEXT.Buffer?
    get() = VkDebugUtilsMessengerCallbackDataEXT.npCmdBufLabels(adr)
    set(value) = VkDebugUtilsMessengerCallbackDataEXT.npCmdBufLabels(adr, value)
inline var VkDebugUtilsMessengerCallbackDataEXT.objectCount: Int
    get() = VkDebugUtilsMessengerCallbackDataEXT.nobjectCount(adr)
    @Deprecated("this will be set automatically")
    set(value) = VkDebugUtilsMessengerCallbackDataEXT.nobjectCount(adr, value)
inline var VkDebugUtilsMessengerCallbackDataEXT.objects: VkDebugUtilsObjectNameInfoEXT.Buffer?
    get() = VkDebugUtilsMessengerCallbackDataEXT.npObjects(adr)
    set(value) = VkDebugUtilsMessengerCallbackDataEXT.npObjects(adr, value)


inline var VkDebugUtilsMessengerCreateInfoEXT.type: VkStructureType
    get() = VkStructureType(VkDebugUtilsMessengerCreateInfoEXT.nsType(adr))
    set(value) = VkDebugUtilsMessengerCreateInfoEXT.nsType(adr, value.i)
inline var VkDebugUtilsMessengerCreateInfoEXT.next: Ptr
    get() = VkDebugUtilsMessengerCreateInfoEXT.npNext(adr)
    set(value) = VkDebugUtilsMessengerCreateInfoEXT.npNext(adr, value)
inline var VkDebugUtilsMessengerCreateInfoEXT.flags: VkDebugUtilsMessengerCreateFlagsEXT
    get() = VkDebugUtilsMessengerCreateInfoEXT.nflags(adr)
    set(value) = VkDebugUtilsMessengerCreateInfoEXT.nflags(adr, value)
inline var VkDebugUtilsMessengerCreateInfoEXT.messageSeverity: VkDebugUtilsMessageSeverityFlagsEXT
    get() = VkDebugUtilsMessengerCreateInfoEXT.nmessageSeverity(adr)
    set(value) = VkDebugUtilsMessengerCreateInfoEXT.nmessageSeverity(adr, value)
inline var VkDebugUtilsMessengerCreateInfoEXT.messageType: VkDebugUtilsMessageTypeFlagsEXT
    get() = VkDebugUtilsMessengerCreateInfoEXT.nmessageType(adr)
    set(value) = VkDebugUtilsMessengerCreateInfoEXT.nmessageType(adr, value)
inline var VkDebugUtilsMessengerCreateInfoEXT.userCallback: VkDebugUtilsMessengerCallbackEXT
    get() = VkDebugUtilsMessengerCreateInfoEXT.npfnUserCallback(adr)
    set(value) = VkDebugUtilsMessengerCreateInfoEXT.npfnUserCallback(adr, value)
inline var VkDebugUtilsMessengerCreateInfoEXT.userData: Ptr
    get() = VkDebugUtilsMessengerCreateInfoEXT.npUserData(adr)
    set(value) = VkDebugUtilsMessengerCreateInfoEXT.npUserData(adr, value)


inline class VkSamplerReductionModeEXT(val i: Int) {
    companion object {
        val WEIGHTED_AVERAGE_EXT = VkSamplerReductionModeEXT(0)
        val MIN_EXT = VkSamplerReductionModeEXT(1)
        val MAX_EXT = VkSamplerReductionModeEXT(2)
    }
}


inline var VkSamplerReductionModeCreateInfoEXT.type: VkStructureType
    get() = VkStructureType(VkSamplerReductionModeCreateInfoEXT.nsType(adr))
    set(value) = VkSamplerReductionModeCreateInfoEXT.nsType(adr, value.i)
inline var VkSamplerReductionModeCreateInfoEXT.next: Ptr
    get() = VkSamplerReductionModeCreateInfoEXT.npNext(adr)
    set(value) = VkSamplerReductionModeCreateInfoEXT.npNext(adr, value)
inline var VkSamplerReductionModeCreateInfoEXT.reductionMode: VkSamplerReductionModeEXT
    get() = VkSamplerReductionModeEXT(VkSamplerReductionModeCreateInfoEXT.nreductionMode(adr))
    set(value) = VkSamplerReductionModeCreateInfoEXT.nreductionMode(adr, value.i)


inline var VkPhysicalDeviceSamplerFilterMinmaxPropertiesEXT.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceSamplerFilterMinmaxPropertiesEXT.nsType(adr))
    set(value) = VkPhysicalDeviceSamplerFilterMinmaxPropertiesEXT.nsType(adr, value.i)
inline var VkPhysicalDeviceSamplerFilterMinmaxPropertiesEXT.next: Ptr
    get() = VkPhysicalDeviceSamplerFilterMinmaxPropertiesEXT.npNext(adr)
    set(value) = VkPhysicalDeviceSamplerFilterMinmaxPropertiesEXT.npNext(adr, value)
inline val VkPhysicalDeviceSamplerFilterMinmaxPropertiesEXT.filterMinmaxSingleComponentFormats: Boolean
    get() = VkPhysicalDeviceSamplerFilterMinmaxPropertiesEXT.nfilterMinmaxSingleComponentFormats(adr).bool
inline val VkPhysicalDeviceSamplerFilterMinmaxPropertiesEXT.filterMinmaxImageComponentMapping: Boolean
    get() = VkPhysicalDeviceSamplerFilterMinmaxPropertiesEXT.nfilterMinmaxImageComponentMapping(adr).bool


inline var VkPhysicalDeviceInlineUniformBlockFeaturesEXT.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceInlineUniformBlockFeaturesEXT.nsType(adr))
    set(value) = VkPhysicalDeviceInlineUniformBlockFeaturesEXT.nsType(adr, value.i)
inline var VkPhysicalDeviceInlineUniformBlockFeaturesEXT.next: Ptr
    get() = VkPhysicalDeviceInlineUniformBlockFeaturesEXT.npNext(adr)
    set(value) = VkPhysicalDeviceInlineUniformBlockFeaturesEXT.npNext(adr, value)
inline var VkPhysicalDeviceInlineUniformBlockFeaturesEXT.inlineUniformBlock: Boolean
    get() = VkPhysicalDeviceInlineUniformBlockFeaturesEXT.ninlineUniformBlock(adr).bool
    set(value) = VkPhysicalDeviceInlineUniformBlockFeaturesEXT.ninlineUniformBlock(adr, value.i)
inline var VkPhysicalDeviceInlineUniformBlockFeaturesEXT.descriptorBindingInlineUniformBlockUpdateAfterBind: Boolean
    get() = VkPhysicalDeviceInlineUniformBlockFeaturesEXT.ndescriptorBindingInlineUniformBlockUpdateAfterBind(adr).bool
    set(value) = VkPhysicalDeviceInlineUniformBlockFeaturesEXT.ndescriptorBindingInlineUniformBlockUpdateAfterBind(adr, value.i)


inline var VkPhysicalDeviceInlineUniformBlockPropertiesEXT.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceInlineUniformBlockPropertiesEXT.nsType(adr))
    set(value) = VkPhysicalDeviceInlineUniformBlockPropertiesEXT.nsType(adr, value.i)
inline var VkPhysicalDeviceInlineUniformBlockPropertiesEXT.next: Ptr
    get() = VkPhysicalDeviceInlineUniformBlockPropertiesEXT.npNext(adr)
    set(value) = VkPhysicalDeviceInlineUniformBlockPropertiesEXT.npNext(adr, value)
inline val VkPhysicalDeviceInlineUniformBlockPropertiesEXT.maxInlineUniformBlockSize: Int
    get() = VkPhysicalDeviceInlineUniformBlockPropertiesEXT.nmaxInlineUniformBlockSize(adr)
inline val VkPhysicalDeviceInlineUniformBlockPropertiesEXT.maxPerStageDescriptorInlineUniformBlocks: Int
    get() = VkPhysicalDeviceInlineUniformBlockPropertiesEXT.nmaxPerStageDescriptorInlineUniformBlocks(adr)
inline val VkPhysicalDeviceInlineUniformBlockPropertiesEXT.maxPerStageDescriptorUpdateAfterBindInlineUniformBlocks: Int
    get() = VkPhysicalDeviceInlineUniformBlockPropertiesEXT.nmaxPerStageDescriptorUpdateAfterBindInlineUniformBlocks(adr)
inline val VkPhysicalDeviceInlineUniformBlockPropertiesEXT.maxDescriptorSetInlineUniformBlocks: Int
    get() = VkPhysicalDeviceInlineUniformBlockPropertiesEXT.nmaxDescriptorSetInlineUniformBlocks(adr)
inline val VkPhysicalDeviceInlineUniformBlockPropertiesEXT.maxDescriptorSetUpdateAfterBindInlineUniformBlocks: Int
    get() = VkPhysicalDeviceInlineUniformBlockPropertiesEXT.nmaxDescriptorSetUpdateAfterBindInlineUniformBlocks(adr)


inline var VkWriteDescriptorSetInlineUniformBlockEXT.type: VkStructureType
    get() = VkStructureType(VkWriteDescriptorSetInlineUniformBlockEXT.nsType(adr))
    set(value) = VkWriteDescriptorSetInlineUniformBlockEXT.nsType(adr, value.i)
inline var VkWriteDescriptorSetInlineUniformBlockEXT.next: Ptr
    get() = VkWriteDescriptorSetInlineUniformBlockEXT.npNext(adr)
    set(value) = VkWriteDescriptorSetInlineUniformBlockEXT.npNext(adr, value)
inline var VkWriteDescriptorSetInlineUniformBlockEXT.dataSize: Int
    get() = VkWriteDescriptorSetInlineUniformBlockEXT.ndataSize(adr)
    @Deprecated("this will be set automatically")
    set(value) = VkWriteDescriptorSetInlineUniformBlockEXT.ndataSize(adr, value)
inline var VkWriteDescriptorSetInlineUniformBlockEXT.data: ByteBuffer
    get() = VkWriteDescriptorSetInlineUniformBlockEXT.npData(adr)
    set(value) = VkWriteDescriptorSetInlineUniformBlockEXT.npData(adr, value)


inline var VkDescriptorPoolInlineUniformBlockCreateInfoEXT.type: VkStructureType
    get() = VkStructureType(VkDescriptorPoolInlineUniformBlockCreateInfoEXT.nsType(adr))
    set(value) = VkDescriptorPoolInlineUniformBlockCreateInfoEXT.nsType(adr, value.i)
inline var VkDescriptorPoolInlineUniformBlockCreateInfoEXT.next: Ptr
    get() = VkDescriptorPoolInlineUniformBlockCreateInfoEXT.npNext(adr)
    set(value) = VkDescriptorPoolInlineUniformBlockCreateInfoEXT.npNext(adr, value)
inline var VkDescriptorPoolInlineUniformBlockCreateInfoEXT.maxInlineUniformBlockBindings: Int
    get() = VkDescriptorPoolInlineUniformBlockCreateInfoEXT.nmaxInlineUniformBlockBindings(adr)
    set(value) = VkDescriptorPoolInlineUniformBlockCreateInfoEXT.nmaxInlineUniformBlockBindings(adr, value)


inline var VkSampleLocationEXT.x: Float
    get() = VkSampleLocationEXT.nx(adr)
    set(value) = VkSampleLocationEXT.nx(adr, value)
inline var VkSampleLocationEXT.y: Float
    get() = VkSampleLocationEXT.ny(adr)
    set(value) = VkSampleLocationEXT.ny(adr, value)


inline var VkSampleLocationsInfoEXT.type: VkStructureType
    get() = VkStructureType(VkSampleLocationsInfoEXT.nsType(adr))
    set(value) = VkSampleLocationsInfoEXT.nsType(adr, value.i)
inline var VkSampleLocationsInfoEXT.next: Ptr
    get() = VkSampleLocationsInfoEXT.npNext(adr)
    set(value) = VkSampleLocationsInfoEXT.npNext(adr, value)
inline var VkSampleLocationsInfoEXT.sampleLocationsPerPixel: VkSampleCount
    get() = VkSampleCount(VkSampleLocationsInfoEXT.nsampleLocationsPerPixel(adr))
    set(value) = VkSampleLocationsInfoEXT.nsampleLocationsPerPixel(adr, value.i)
inline var VkSampleLocationsInfoEXT.sampleLocationGridSize: VkExtent2D
    get() = VkSampleLocationsInfoEXT.nsampleLocationGridSize(adr)
    set(value) = VkSampleLocationsInfoEXT.nsampleLocationGridSize(adr, value)
inline var VkSampleLocationsInfoEXT.sampleLocationsCount: Int
    get() = VkSampleLocationsInfoEXT.nsampleLocationsCount(adr)
    @Deprecated("this will be set automatically")
    set(value) = VkSampleLocationsInfoEXT.nsampleLocationsCount(adr, value)
inline var VkSampleLocationsInfoEXT.sampleLocations: VkSampleLocationEXT.Buffer?
    get() = VkSampleLocationsInfoEXT.npSampleLocations(adr)
    set(value) = VkSampleLocationsInfoEXT.npSampleLocations(adr, value)


inline var VkAttachmentSampleLocationsEXT.attachmentIndex: Int
    get() = VkAttachmentSampleLocationsEXT.nattachmentIndex(adr)
    set(value) = VkAttachmentSampleLocationsEXT.nattachmentIndex(adr, value)
inline var VkAttachmentSampleLocationsEXT.sampleLocationsInfo: VkSampleLocationsInfoEXT
    get() = VkAttachmentSampleLocationsEXT.nsampleLocationsInfo(adr)
    set(value) = VkAttachmentSampleLocationsEXT.nsampleLocationsInfo(adr, value)


inline var VkSubpassSampleLocationsEXT.subpassIndex: Int
    get() = VkSubpassSampleLocationsEXT.nsubpassIndex(adr)
    set(value) = VkSubpassSampleLocationsEXT.nsubpassIndex(adr, value)
inline var VkSubpassSampleLocationsEXT.sampleLocationsInfo: VkSampleLocationsInfoEXT
    get() = VkSubpassSampleLocationsEXT.nsampleLocationsInfo(adr)
    set(value) = VkSubpassSampleLocationsEXT.nsampleLocationsInfo(adr, value)


inline var VkRenderPassSampleLocationsBeginInfoEXT.type: VkStructureType
    get() = VkStructureType(VkRenderPassSampleLocationsBeginInfoEXT.nsType(adr))
    set(value) = VkRenderPassSampleLocationsBeginInfoEXT.nsType(adr, value.i)
inline var VkRenderPassSampleLocationsBeginInfoEXT.next: Ptr
    get() = VkRenderPassSampleLocationsBeginInfoEXT.npNext(adr)
    set(value) = VkRenderPassSampleLocationsBeginInfoEXT.npNext(adr, value)
inline var VkRenderPassSampleLocationsBeginInfoEXT.attachmentInitialSampleLocationsCount: Int
    get() = VkRenderPassSampleLocationsBeginInfoEXT.nattachmentInitialSampleLocationsCount(adr)
    @Deprecated("this will be set automatically")
    set(value) = VkRenderPassSampleLocationsBeginInfoEXT.nattachmentInitialSampleLocationsCount(adr, value)
inline var VkRenderPassSampleLocationsBeginInfoEXT.attachmentInitialSampleLocations: VkAttachmentSampleLocationsEXT.Buffer?
    get() = VkRenderPassSampleLocationsBeginInfoEXT.npAttachmentInitialSampleLocations(adr)
    set(value) = VkRenderPassSampleLocationsBeginInfoEXT.npAttachmentInitialSampleLocations(adr, value)
inline var VkRenderPassSampleLocationsBeginInfoEXT.postSubpassSampleLocationsCount: Int
    get() = VkRenderPassSampleLocationsBeginInfoEXT.npostSubpassSampleLocationsCount(adr)
    @Deprecated("this will be set automatically")
    set(value) = VkRenderPassSampleLocationsBeginInfoEXT.npostSubpassSampleLocationsCount(adr, value)
inline var VkRenderPassSampleLocationsBeginInfoEXT.postSubpassSampleLocations: VkSubpassSampleLocationsEXT.Buffer?
    get() = VkRenderPassSampleLocationsBeginInfoEXT.npPostSubpassSampleLocations(adr)
    set(value) = VkRenderPassSampleLocationsBeginInfoEXT.npPostSubpassSampleLocations(adr, value)


inline var VkPipelineSampleLocationsStateCreateInfoEXT.type: VkStructureType
    get() = VkStructureType(VkPipelineSampleLocationsStateCreateInfoEXT.nsType(adr))
    set(value) = VkPipelineSampleLocationsStateCreateInfoEXT.nsType(adr, value.i)
inline var VkPipelineSampleLocationsStateCreateInfoEXT.next: Ptr
    get() = VkPipelineSampleLocationsStateCreateInfoEXT.npNext(adr)
    set(value) = VkPipelineSampleLocationsStateCreateInfoEXT.npNext(adr, value)
inline var VkPipelineSampleLocationsStateCreateInfoEXT.sampleLocationsEnable: Boolean
    get() = VkPipelineSampleLocationsStateCreateInfoEXT.nsampleLocationsEnable(adr).bool
    set(value) = VkPipelineSampleLocationsStateCreateInfoEXT.nsampleLocationsEnable(adr, value.i)
inline var VkPipelineSampleLocationsStateCreateInfoEXT.sampleLocationsInfo: VkSampleLocationsInfoEXT
    get() = VkPipelineSampleLocationsStateCreateInfoEXT.nsampleLocationsInfo(adr)
    set(value) = VkPipelineSampleLocationsStateCreateInfoEXT.nsampleLocationsInfo(adr, value)


inline var VkPhysicalDeviceSampleLocationsPropertiesEXT.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceSampleLocationsPropertiesEXT.nsType(adr))
    set(value) = VkPhysicalDeviceSampleLocationsPropertiesEXT.nsType(adr, value.i)
inline var VkPhysicalDeviceSampleLocationsPropertiesEXT.next: Ptr
    get() = VkPhysicalDeviceSampleLocationsPropertiesEXT.npNext(adr)
    set(value) = VkPhysicalDeviceSampleLocationsPropertiesEXT.npNext(adr, value)
inline val VkPhysicalDeviceSampleLocationsPropertiesEXT.sampleLocationSampleCounts: VkSampleCountFlags
    get() = VkPhysicalDeviceSampleLocationsPropertiesEXT.nsampleLocationSampleCounts(adr)
inline val VkPhysicalDeviceSampleLocationsPropertiesEXT.maxSampleLocationGridSize: VkExtent2D
    get() = VkPhysicalDeviceSampleLocationsPropertiesEXT.nmaxSampleLocationGridSize(adr)
inline val VkPhysicalDeviceSampleLocationsPropertiesEXT.sampleLocationCoordinateRange: FloatBuffer
    get() = VkPhysicalDeviceSampleLocationsPropertiesEXT.nsampleLocationCoordinateRange(adr)
inline val VkPhysicalDeviceSampleLocationsPropertiesEXT.sampleLocationSubPixelBits: Int
    get() = VkPhysicalDeviceSampleLocationsPropertiesEXT.nsampleLocationSubPixelBits(adr)
inline val VkPhysicalDeviceSampleLocationsPropertiesEXT.variableSampleLocations: Boolean
    get() = VkPhysicalDeviceSampleLocationsPropertiesEXT.nvariableSampleLocations(adr).bool


inline var VkMultisamplePropertiesEXT.type: VkStructureType
    get() = VkStructureType(VkMultisamplePropertiesEXT.nsType(adr))
    set(value) = VkMultisamplePropertiesEXT.nsType(adr, value.i)
inline var VkMultisamplePropertiesEXT.next: Ptr
    get() = VkMultisamplePropertiesEXT.npNext(adr)
    set(value) = VkMultisamplePropertiesEXT.npNext(adr, value)
inline val VkMultisamplePropertiesEXT.maxSampleLocationGridSize: VkExtent2D
    get() = VkMultisamplePropertiesEXT.nmaxSampleLocationGridSize(adr)


inline class VkBlendOverlapEXT(val i: Int) {
    companion object {
        val UNCORRELATED_EXT = VkBlendOverlapEXT(0)
        val DISJOINT_EXT = VkBlendOverlapEXT(1)
        val CONJOINT_EXT = VkBlendOverlapEXT(2)
    }
}


inline var VkPhysicalDeviceBlendOperationAdvancedFeaturesEXT.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceBlendOperationAdvancedFeaturesEXT.nsType(adr))
    set(value) = VkPhysicalDeviceBlendOperationAdvancedFeaturesEXT.nsType(adr, value.i)
inline var VkPhysicalDeviceBlendOperationAdvancedFeaturesEXT.next: Ptr
    get() = VkPhysicalDeviceBlendOperationAdvancedFeaturesEXT.npNext(adr)
    set(value) = VkPhysicalDeviceBlendOperationAdvancedFeaturesEXT.npNext(adr, value)
inline var VkPhysicalDeviceBlendOperationAdvancedFeaturesEXT.advancedBlendCoherentOperations: Boolean
    get() = VkPhysicalDeviceBlendOperationAdvancedFeaturesEXT.nadvancedBlendCoherentOperations(adr).bool
    set(value) = VkPhysicalDeviceBlendOperationAdvancedFeaturesEXT.nadvancedBlendCoherentOperations(adr, value.i)


inline var VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.nsType(adr))
    set(value) = VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.nsType(adr, value.i)
inline var VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.next: Ptr
    get() = VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.npNext(adr)
    set(value) = VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.npNext(adr, value)
inline val VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.advancedBlendMaxColorAttachments: Int
    get() = VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.nadvancedBlendMaxColorAttachments(adr)
inline val VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.advancedBlendIndependentBlend: Boolean
    get() = VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.nadvancedBlendIndependentBlend(adr).bool
inline val VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.advancedBlendNonPremultipliedSrcColor: Boolean
    get() = VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.nadvancedBlendNonPremultipliedSrcColor(adr).bool
inline val VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.advancedBlendNonPremultipliedDstColor: Boolean
    get() = VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.nadvancedBlendNonPremultipliedDstColor(adr).bool
inline val VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.advancedBlendCorrelatedOverlap: Boolean
    get() = VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.nadvancedBlendCorrelatedOverlap(adr).bool
inline val VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.advancedBlendAllOperations: Boolean
    get() = VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.nadvancedBlendAllOperations(adr).bool


inline var VkPipelineColorBlendAdvancedStateCreateInfoEXT.type: VkStructureType
    get() = VkStructureType(VkPipelineColorBlendAdvancedStateCreateInfoEXT.nsType(adr))
    set(value) = VkPipelineColorBlendAdvancedStateCreateInfoEXT.nsType(adr, value.i)
inline var VkPipelineColorBlendAdvancedStateCreateInfoEXT.next: Ptr
    get() = VkPipelineColorBlendAdvancedStateCreateInfoEXT.npNext(adr)
    set(value) = VkPipelineColorBlendAdvancedStateCreateInfoEXT.npNext(adr, value)
inline var VkPipelineColorBlendAdvancedStateCreateInfoEXT.srcPremultiplied: Boolean
    get() = VkPipelineColorBlendAdvancedStateCreateInfoEXT.nsrcPremultiplied(adr).bool
    set(value) = VkPipelineColorBlendAdvancedStateCreateInfoEXT.nsrcPremultiplied(adr, value.i)
inline var VkPipelineColorBlendAdvancedStateCreateInfoEXT.dstPremultiplied: Boolean
    get() = VkPipelineColorBlendAdvancedStateCreateInfoEXT.ndstPremultiplied(adr).bool
    set(value) = VkPipelineColorBlendAdvancedStateCreateInfoEXT.ndstPremultiplied(adr, value.i)
inline var VkPipelineColorBlendAdvancedStateCreateInfoEXT.blendOverlap: VkBlendOverlapEXT
    get() = VkBlendOverlapEXT(VkPipelineColorBlendAdvancedStateCreateInfoEXT.nblendOverlap(adr))
    set(value) = VkPipelineColorBlendAdvancedStateCreateInfoEXT.nblendOverlap(adr, value.i)


typealias VkPipelineCoverageToColorStateCreateFlagsNV = VkFlags


inline var VkPipelineCoverageToColorStateCreateInfoNV.type: VkStructureType
    get() = VkStructureType(VkPipelineCoverageToColorStateCreateInfoNV.nsType(adr))
    set(value) = VkPipelineCoverageToColorStateCreateInfoNV.nsType(adr, value.i)
inline var VkPipelineCoverageToColorStateCreateInfoNV.next: Ptr
    get() = VkPipelineCoverageToColorStateCreateInfoNV.npNext(adr)
    set(value) = VkPipelineCoverageToColorStateCreateInfoNV.npNext(adr, value)
inline var VkPipelineCoverageToColorStateCreateInfoNV.flags: VkPipelineCoverageToColorStateCreateFlagsNV
    get() = VkPipelineCoverageToColorStateCreateInfoNV.nflags(adr)
    set(value) = VkPipelineCoverageToColorStateCreateInfoNV.nflags(adr, value)
inline var VkPipelineCoverageToColorStateCreateInfoNV.coverageToColorEnable: Boolean
    get() = VkPipelineCoverageToColorStateCreateInfoNV.ncoverageToColorEnable(adr).bool
    set(value) = VkPipelineCoverageToColorStateCreateInfoNV.ncoverageToColorEnable(adr, value.i)
inline var VkPipelineCoverageToColorStateCreateInfoNV.coverageToColorLocation: Int
    get() = VkPipelineCoverageToColorStateCreateInfoNV.ncoverageToColorLocation(adr)
    set(value) = VkPipelineCoverageToColorStateCreateInfoNV.ncoverageToColorLocation(adr, value)


inline class VkCoverageModulationModeNV(val i: Int) {
    companion object {
        val NONE_NV = VkCoverageModulationModeNV(0)
        val RGB_NV = VkCoverageModulationModeNV(1)
        val ALPHA_NV = VkCoverageModulationModeNV(2)
        val RGBA_NV = VkCoverageModulationModeNV(3)
    }
}

typealias VkPipelineCoverageModulationStateCreateFlagsNV = VkFlags


inline var VkPipelineCoverageModulationStateCreateInfoNV.type: VkStructureType
    get() = VkStructureType(VkPipelineCoverageModulationStateCreateInfoNV.nsType(adr))
    set(value) = VkPipelineCoverageModulationStateCreateInfoNV.nsType(adr, value.i)
inline var VkPipelineCoverageModulationStateCreateInfoNV.next: Ptr
    get() = VkPipelineCoverageModulationStateCreateInfoNV.npNext(adr)
    set(value) = VkPipelineCoverageModulationStateCreateInfoNV.npNext(adr, value)
inline var VkPipelineCoverageModulationStateCreateInfoNV.flags: VkPipelineCoverageModulationStateCreateFlagsNV
    get() = VkPipelineCoverageModulationStateCreateInfoNV.nflags(adr)
    set(value) = VkPipelineCoverageModulationStateCreateInfoNV.nflags(adr, value)
inline var VkPipelineCoverageModulationStateCreateInfoNV.coverageModulationMode: VkCoverageModulationModeNV
    get() = VkCoverageModulationModeNV(VkPipelineCoverageModulationStateCreateInfoNV.ncoverageModulationMode(adr))
    set(value) = VkPipelineCoverageModulationStateCreateInfoNV.ncoverageModulationMode(adr, value.i)
inline var VkPipelineCoverageModulationStateCreateInfoNV.coverageModulationTableEnable: Boolean
    get() = VkPipelineCoverageModulationStateCreateInfoNV.ncoverageModulationTableEnable(adr).bool
    set(value) = VkPipelineCoverageModulationStateCreateInfoNV.ncoverageModulationTableEnable(adr, value.i)
inline var VkPipelineCoverageModulationStateCreateInfoNV.coverageModulationTableCount: Int
    get() = VkPipelineCoverageModulationStateCreateInfoNV.ncoverageModulationTableCount(adr)
    @Deprecated("this will be set automatically")
    set(value) = VkPipelineCoverageModulationStateCreateInfoNV.ncoverageModulationTableCount(adr, value)
inline var VkPipelineCoverageModulationStateCreateInfoNV.coverageModulationTable: FloatBuffer?
    get() = VkPipelineCoverageModulationStateCreateInfoNV.npCoverageModulationTable(adr)
    set(value) = VkPipelineCoverageModulationStateCreateInfoNV.npCoverageModulationTable(adr, value)


inline val VkDrmFormatModifierPropertiesEXT.drmFormatModifier: Long
    get() = VkDrmFormatModifierPropertiesEXT.ndrmFormatModifier(adr)
inline val VkDrmFormatModifierPropertiesEXT.drmFormatModifierPlaneCount: Int
    get() = VkDrmFormatModifierPropertiesEXT.ndrmFormatModifierPlaneCount(adr)
inline val VkDrmFormatModifierPropertiesEXT.drmFormatModifierTilingFeatures: VkFormatFeatureFlags
    get() = VkDrmFormatModifierPropertiesEXT.ndrmFormatModifierTilingFeatures(adr)


inline var VkDrmFormatModifierPropertiesListEXT.type: VkStructureType
    get() = VkStructureType(VkDrmFormatModifierPropertiesListEXT.nsType(adr))
    set(value) = VkDrmFormatModifierPropertiesListEXT.nsType(adr, value.i)
inline var VkDrmFormatModifierPropertiesListEXT.next: Ptr
    get() = VkDrmFormatModifierPropertiesListEXT.npNext(adr)
    set(value) = VkDrmFormatModifierPropertiesListEXT.npNext(adr, value)
inline val VkDrmFormatModifierPropertiesListEXT.drmFormatModifierCount: VkPipelineCoverageModulationStateCreateFlagsNV
    get() = VkDrmFormatModifierPropertiesListEXT.ndrmFormatModifierCount(adr)
inline val VkDrmFormatModifierPropertiesListEXT.drmFormatModifierProperties: VkDrmFormatModifierPropertiesEXT.Buffer?
    get() = VkDrmFormatModifierPropertiesListEXT.npDrmFormatModifierProperties(adr)


inline var VkPhysicalDeviceImageDrmFormatModifierInfoEXT.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceImageDrmFormatModifierInfoEXT.nsType(adr))
    set(value) = VkPhysicalDeviceImageDrmFormatModifierInfoEXT.nsType(adr, value.i)
inline var VkPhysicalDeviceImageDrmFormatModifierInfoEXT.next: Ptr
    get() = VkPhysicalDeviceImageDrmFormatModifierInfoEXT.npNext(adr)
    set(value) = VkPhysicalDeviceImageDrmFormatModifierInfoEXT.npNext(adr, value)
inline var VkPhysicalDeviceImageDrmFormatModifierInfoEXT.drmFormatModifier: Long
    get() = VkPhysicalDeviceImageDrmFormatModifierInfoEXT.ndrmFormatModifier(adr)
    set(value) = VkPhysicalDeviceImageDrmFormatModifierInfoEXT.ndrmFormatModifier(adr, value)
inline var VkPhysicalDeviceImageDrmFormatModifierInfoEXT.sharingMode: VkSharingMode
    get() = VkSharingMode(VkPhysicalDeviceImageDrmFormatModifierInfoEXT.nsharingMode(adr))
    set(value) = VkPhysicalDeviceImageDrmFormatModifierInfoEXT.nsharingMode(adr, value.i)
inline var VkPhysicalDeviceImageDrmFormatModifierInfoEXT.queueFamilyIndexCount: Int
    get() = VkPhysicalDeviceImageDrmFormatModifierInfoEXT.nqueueFamilyIndexCount(adr)
    @Deprecated("this will be set automatically")
    set(value) = VkPhysicalDeviceImageDrmFormatModifierInfoEXT.nqueueFamilyIndexCount(adr, value)
inline var VkPhysicalDeviceImageDrmFormatModifierInfoEXT.queueFamilyIndices: IntBuffer?
    get() = VkPhysicalDeviceImageDrmFormatModifierInfoEXT.npQueueFamilyIndices(adr)
    set(value) = VkPhysicalDeviceImageDrmFormatModifierInfoEXT.npQueueFamilyIndices(adr, value)


inline var VkImageDrmFormatModifierListCreateInfoEXT.type: VkStructureType
    get() = VkStructureType(VkImageDrmFormatModifierListCreateInfoEXT.nsType(adr))
    set(value) = VkImageDrmFormatModifierListCreateInfoEXT.nsType(adr, value.i)
inline var VkImageDrmFormatModifierListCreateInfoEXT.next: Ptr
    get() = VkImageDrmFormatModifierListCreateInfoEXT.npNext(adr)
    set(value) = VkImageDrmFormatModifierListCreateInfoEXT.npNext(adr, value)
inline var VkImageDrmFormatModifierListCreateInfoEXT.drmFormatModifierCount: Int
    get() = VkImageDrmFormatModifierListCreateInfoEXT.ndrmFormatModifierCount(adr)
    @Deprecated("this will be set automatically")
    set(value) = VkImageDrmFormatModifierListCreateInfoEXT.ndrmFormatModifierCount(adr, value)
inline var VkImageDrmFormatModifierListCreateInfoEXT.drmFormatModifiers: LongBuffer
    get() = VkImageDrmFormatModifierListCreateInfoEXT.npDrmFormatModifiers(adr)
    set(value) = VkImageDrmFormatModifierListCreateInfoEXT.npDrmFormatModifiers(adr, value)


inline var VkImageDrmFormatModifierExplicitCreateInfoEXT.type: VkStructureType
    get() = VkStructureType(VkImageDrmFormatModifierExplicitCreateInfoEXT.nsType(adr))
    set(value) = VkImageDrmFormatModifierExplicitCreateInfoEXT.nsType(adr, value.i)
inline var VkImageDrmFormatModifierExplicitCreateInfoEXT.next: Ptr
    get() = VkImageDrmFormatModifierExplicitCreateInfoEXT.npNext(adr)
    set(value) = VkImageDrmFormatModifierExplicitCreateInfoEXT.npNext(adr, value)
inline var VkImageDrmFormatModifierExplicitCreateInfoEXT.drmFormatModifier: Long
    get() = VkImageDrmFormatModifierExplicitCreateInfoEXT.ndrmFormatModifier(adr)
    set(value) = VkImageDrmFormatModifierExplicitCreateInfoEXT.ndrmFormatModifier(adr, value)
inline var VkImageDrmFormatModifierExplicitCreateInfoEXT.drmFormatModifierPlaneCount: Int
    get() = VkImageDrmFormatModifierExplicitCreateInfoEXT.ndrmFormatModifierPlaneCount(adr)
    @Deprecated("this will be set automatically")
    set(value) = VkImageDrmFormatModifierExplicitCreateInfoEXT.ndrmFormatModifierPlaneCount(adr, value)
inline var VkImageDrmFormatModifierExplicitCreateInfoEXT.planeLayouts: VkSubresourceLayout.Buffer?
    get() = VkImageDrmFormatModifierExplicitCreateInfoEXT.npPlaneLayouts(adr)
    set(value) = VkImageDrmFormatModifierExplicitCreateInfoEXT.npPlaneLayouts(adr, value)


inline var VkImageDrmFormatModifierPropertiesEXT.type: VkStructureType
    get() = VkStructureType(VkImageDrmFormatModifierPropertiesEXT.nsType(adr))
    set(value) = VkImageDrmFormatModifierPropertiesEXT.nsType(adr, value.i)
inline var VkImageDrmFormatModifierPropertiesEXT.next: Ptr
    get() = VkImageDrmFormatModifierPropertiesEXT.npNext(adr)
    set(value) = VkImageDrmFormatModifierPropertiesEXT.npNext(adr, value)
inline val VkImageDrmFormatModifierPropertiesEXT.drmFormatModifier: Long
    get() = VkImageDrmFormatModifierPropertiesEXT.ndrmFormatModifier(adr)


inline class VkValidationCacheHeaderVersionEXT(val i: Int) {
    companion object {
        val ONE_EXT = VkValidationCacheHeaderVersionEXT(1)
    }
}

typealias VkValidationCacheCreateFlagsEXT = VkFlags


inline var VkValidationCacheCreateInfoEXT.type: VkStructureType
    get() = VkStructureType(VkValidationCacheCreateInfoEXT.nsType(adr))
    set(value) = VkValidationCacheCreateInfoEXT.nsType(adr, value.i)
inline var VkValidationCacheCreateInfoEXT.next: Ptr
    get() = VkValidationCacheCreateInfoEXT.npNext(adr)
    set(value) = VkValidationCacheCreateInfoEXT.npNext(adr, value)
inline var VkValidationCacheCreateInfoEXT.flags: VkValidationCacheCreateFlagsEXT
    get() = VkValidationCacheCreateInfoEXT.nflags(adr)
    set(value) = VkValidationCacheCreateInfoEXT.nflags(adr, value)
inline var VkValidationCacheCreateInfoEXT.initialDataSize: Long
    get() = VkValidationCacheCreateInfoEXT.ninitialDataSize(adr)
    @Deprecated("this will be set automatically")
    set(value) = VkValidationCacheCreateInfoEXT.ninitialDataSize(adr, value)
inline var VkValidationCacheCreateInfoEXT.initialData: ByteBuffer?
    get() = VkValidationCacheCreateInfoEXT.npInitialData(adr)
    set(value) = VkValidationCacheCreateInfoEXT.npInitialData(adr, value)


inline var VkShaderModuleValidationCacheCreateInfoEXT.type: VkStructureType
    get() = VkStructureType(VkShaderModuleValidationCacheCreateInfoEXT.nsType(adr))
    set(value) = VkShaderModuleValidationCacheCreateInfoEXT.nsType(adr, value.i)
inline var VkShaderModuleValidationCacheCreateInfoEXT.next: Ptr
    get() = VkShaderModuleValidationCacheCreateInfoEXT.npNext(adr)
    set(value) = VkShaderModuleValidationCacheCreateInfoEXT.npNext(adr, value)
inline var VkShaderModuleValidationCacheCreateInfoEXT.validationCache: VkValidationCacheEXT
    get() = VkValidationCacheEXT(VkShaderModuleValidationCacheCreateInfoEXT.nvalidationCache(adr))
    set(value) = VkShaderModuleValidationCacheCreateInfoEXT.nvalidationCache(adr, value.L)


inline class VkDescriptorBindingEXT(val i: Int) {
    companion object {
        val UPDATE_AFTER_BIND_BIT_EXT = VkDescriptorBindingEXT(0x00000001)
        val UPDATE_UNUSED_WHILE_PENDING_BIT_EXT = VkDescriptorBindingEXT(0x00000002)
        val PARTIALLY_BOUND_BIT_EXT = VkDescriptorBindingEXT(0x00000004)
        val VARIABLE_DESCRIPTOR_COUNT_BIT_EXT = VkDescriptorBindingEXT(0x00000008)
    }
}

typealias VkDescriptorBindingFlagsEXT = VkFlags


inline var VkDescriptorSetLayoutBindingFlagsCreateInfoEXT.type: VkStructureType
    get() = VkStructureType(VkDescriptorSetLayoutBindingFlagsCreateInfoEXT.nsType(adr))
    set(value) = VkDescriptorSetLayoutBindingFlagsCreateInfoEXT.nsType(adr, value.i)
inline var VkDescriptorSetLayoutBindingFlagsCreateInfoEXT.next: Ptr
    get() = VkDescriptorSetLayoutBindingFlagsCreateInfoEXT.npNext(adr)
    set(value) = VkDescriptorSetLayoutBindingFlagsCreateInfoEXT.npNext(adr, value)
inline var VkDescriptorSetLayoutBindingFlagsCreateInfoEXT.bindingCount: Int
    get() = VkDescriptorSetLayoutBindingFlagsCreateInfoEXT.nbindingCount(adr)
    set(value) = VkDescriptorSetLayoutBindingFlagsCreateInfoEXT.nbindingCount(adr, value)
inline var VkDescriptorSetLayoutBindingFlagsCreateInfoEXT.bindingFlags: VkDescriptorBindingFlagsEXT_Buffer?
    get() = VkDescriptorSetLayoutBindingFlagsCreateInfoEXT.npBindingFlags(adr)?.let(::VkDescriptorBindingFlagsEXT_Buffer)
    set(value) = VkDescriptorSetLayoutBindingFlagsCreateInfoEXT.npBindingFlags(adr, value?.buffer)


inline var VkPhysicalDeviceDescriptorIndexingFeaturesEXT.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceDescriptorIndexingFeaturesEXT.nsType(adr))
    set(value) = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.nsType(adr, value.i)
inline var VkPhysicalDeviceDescriptorIndexingFeaturesEXT.next: Ptr
    get() = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.npNext(adr)
    set(value) = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.npNext(adr, value)
inline var VkPhysicalDeviceDescriptorIndexingFeaturesEXT.shaderInputAttachmentArrayDynamicIndexing: Boolean
    get() = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.nshaderInputAttachmentArrayDynamicIndexing(adr).bool
    set(value) = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.nshaderInputAttachmentArrayDynamicIndexing(adr, value.i)
inline var VkPhysicalDeviceDescriptorIndexingFeaturesEXT.shaderUniformTexelBufferArrayDynamicIndexing: Boolean
    get() = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.nshaderUniformTexelBufferArrayDynamicIndexing(adr).bool
    set(value) = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.nshaderUniformTexelBufferArrayDynamicIndexing(adr, value.i)
inline var VkPhysicalDeviceDescriptorIndexingFeaturesEXT.shaderStorageTexelBufferArrayDynamicIndexing: Boolean
    get() = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.nshaderStorageTexelBufferArrayDynamicIndexing(adr).bool
    set(value) = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.nshaderStorageTexelBufferArrayDynamicIndexing(adr, value.i)
inline var VkPhysicalDeviceDescriptorIndexingFeaturesEXT.shaderUniformBufferArrayNonUniformIndexing: Boolean
    get() = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.nshaderUniformBufferArrayNonUniformIndexing(adr).bool
    set(value) = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.nshaderUniformBufferArrayNonUniformIndexing(adr, value.i)
inline var VkPhysicalDeviceDescriptorIndexingFeaturesEXT.shaderSampledImageArrayNonUniformIndexing: Boolean
    get() = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.nshaderSampledImageArrayNonUniformIndexing(adr).bool
    set(value) = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.nshaderSampledImageArrayNonUniformIndexing(adr, value.i)
inline var VkPhysicalDeviceDescriptorIndexingFeaturesEXT.shaderStorageBufferArrayNonUniformIndexing: Boolean
    get() = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.nshaderStorageBufferArrayNonUniformIndexing(adr).bool
    set(value) = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.nshaderStorageBufferArrayNonUniformIndexing(adr, value.i)
inline var VkPhysicalDeviceDescriptorIndexingFeaturesEXT.shaderStorageImageArrayNonUniformIndexing: Boolean
    get() = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.nshaderStorageImageArrayNonUniformIndexing(adr).bool
    set(value) = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.nshaderStorageImageArrayNonUniformIndexing(adr, value.i)
inline var VkPhysicalDeviceDescriptorIndexingFeaturesEXT.shaderInputAttachmentArrayNonUniformIndexing: Boolean
    get() = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.nshaderInputAttachmentArrayNonUniformIndexing(adr).bool
    set(value) = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.nshaderInputAttachmentArrayNonUniformIndexing(adr, value.i)
inline var VkPhysicalDeviceDescriptorIndexingFeaturesEXT.shaderUniformTexelBufferArrayNonUniformIndexing: Boolean
    get() = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.nshaderUniformTexelBufferArrayNonUniformIndexing(adr).bool
    set(value) = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.nshaderUniformTexelBufferArrayNonUniformIndexing(adr, value.i)
inline var VkPhysicalDeviceDescriptorIndexingFeaturesEXT.shaderStorageTexelBufferArrayNonUniformIndexing: Boolean
    get() = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.nshaderStorageTexelBufferArrayNonUniformIndexing(adr).bool
    set(value) = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.nshaderStorageTexelBufferArrayNonUniformIndexing(adr, value.i)
inline var VkPhysicalDeviceDescriptorIndexingFeaturesEXT.descriptorBindingUniformBufferUpdateAfterBind: Boolean
    get() = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.ndescriptorBindingUniformBufferUpdateAfterBind(adr).bool
    set(value) = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.ndescriptorBindingUniformBufferUpdateAfterBind(adr, value.i)
inline var VkPhysicalDeviceDescriptorIndexingFeaturesEXT.descriptorBindingSampledImageUpdateAfterBind: Boolean
    get() = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.ndescriptorBindingSampledImageUpdateAfterBind(adr).bool
    set(value) = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.ndescriptorBindingSampledImageUpdateAfterBind(adr, value.i)
inline var VkPhysicalDeviceDescriptorIndexingFeaturesEXT.descriptorBindingStorageImageUpdateAfterBind: Boolean
    get() = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.ndescriptorBindingStorageImageUpdateAfterBind(adr).bool
    set(value) = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.ndescriptorBindingStorageImageUpdateAfterBind(adr, value.i)
inline var VkPhysicalDeviceDescriptorIndexingFeaturesEXT.descriptorBindingStorageBufferUpdateAfterBind: Boolean
    get() = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.ndescriptorBindingStorageBufferUpdateAfterBind(adr).bool
    set(value) = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.ndescriptorBindingStorageBufferUpdateAfterBind(adr, value.i)
inline var VkPhysicalDeviceDescriptorIndexingFeaturesEXT.descriptorBindingUniformTexelBufferUpdateAfterBind: Boolean
    get() = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.ndescriptorBindingUniformTexelBufferUpdateAfterBind(adr).bool
    set(value) = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.ndescriptorBindingUniformTexelBufferUpdateAfterBind(adr, value.i)
inline var VkPhysicalDeviceDescriptorIndexingFeaturesEXT.descriptorBindingStorageTexelBufferUpdateAfterBind: Boolean
    get() = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.ndescriptorBindingStorageTexelBufferUpdateAfterBind(adr).bool
    set(value) = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.ndescriptorBindingStorageTexelBufferUpdateAfterBind(adr, value.i)
inline var VkPhysicalDeviceDescriptorIndexingFeaturesEXT.descriptorBindingUpdateUnusedWhilePending: Boolean
    get() = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.ndescriptorBindingUpdateUnusedWhilePending(adr).bool
    set(value) = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.ndescriptorBindingUpdateUnusedWhilePending(adr, value.i)
inline var VkPhysicalDeviceDescriptorIndexingFeaturesEXT.descriptorBindingPartiallyBound: Boolean
    get() = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.ndescriptorBindingPartiallyBound(adr).bool
    set(value) = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.ndescriptorBindingPartiallyBound(adr, value.i)
inline var VkPhysicalDeviceDescriptorIndexingFeaturesEXT.descriptorBindingVariableDescriptorCount: Boolean
    get() = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.ndescriptorBindingVariableDescriptorCount(adr).bool
    set(value) = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.ndescriptorBindingVariableDescriptorCount(adr, value.i)
inline var VkPhysicalDeviceDescriptorIndexingFeaturesEXT.runtimeDescriptorArray: Boolean
    get() = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.nruntimeDescriptorArray(adr).bool
    set(value) = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.nruntimeDescriptorArray(adr, value.i)


inline var VkPhysicalDeviceDescriptorIndexingPropertiesEXT.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceDescriptorIndexingPropertiesEXT.nsType(adr))
    set(value) = VkPhysicalDeviceDescriptorIndexingPropertiesEXT.nsType(adr, value.i)
inline var VkPhysicalDeviceDescriptorIndexingPropertiesEXT.next: Ptr
    get() = VkPhysicalDeviceDescriptorIndexingPropertiesEXT.npNext(adr)
    set(value) = VkPhysicalDeviceDescriptorIndexingPropertiesEXT.npNext(adr, value)
inline val VkPhysicalDeviceDescriptorIndexingPropertiesEXT.maxUpdateAfterBindDescriptorsInAllPools: Int
    get() = VkPhysicalDeviceDescriptorIndexingPropertiesEXT.nmaxUpdateAfterBindDescriptorsInAllPools(adr)
inline val VkPhysicalDeviceDescriptorIndexingPropertiesEXT.shaderUniformBufferArrayNonUniformIndexingNative: Boolean
    get() = VkPhysicalDeviceDescriptorIndexingPropertiesEXT.nshaderUniformBufferArrayNonUniformIndexingNative(adr).bool
inline val VkPhysicalDeviceDescriptorIndexingPropertiesEXT.shaderSampledImageArrayNonUniformIndexingNative: Boolean
    get() = VkPhysicalDeviceDescriptorIndexingPropertiesEXT.nshaderSampledImageArrayNonUniformIndexingNative(adr).bool
inline val VkPhysicalDeviceDescriptorIndexingPropertiesEXT.shaderStorageBufferArrayNonUniformIndexingNative: Boolean
    get() = VkPhysicalDeviceDescriptorIndexingPropertiesEXT.nshaderStorageBufferArrayNonUniformIndexingNative(adr).bool
inline val VkPhysicalDeviceDescriptorIndexingPropertiesEXT.shaderStorageImageArrayNonUniformIndexingNative: Boolean
    get() = VkPhysicalDeviceDescriptorIndexingPropertiesEXT.nshaderStorageImageArrayNonUniformIndexingNative(adr).bool
inline val VkPhysicalDeviceDescriptorIndexingPropertiesEXT.shaderInputAttachmentArrayNonUniformIndexingNative: Boolean
    get() = VkPhysicalDeviceDescriptorIndexingPropertiesEXT.nshaderInputAttachmentArrayNonUniformIndexingNative(adr).bool
inline val VkPhysicalDeviceDescriptorIndexingPropertiesEXT.robustBufferAccessUpdateAfterBind: Boolean
    get() = VkPhysicalDeviceDescriptorIndexingPropertiesEXT.nrobustBufferAccessUpdateAfterBind(adr).bool
inline val VkPhysicalDeviceDescriptorIndexingPropertiesEXT.quadDivergentImplicitLod: Boolean
    get() = VkPhysicalDeviceDescriptorIndexingPropertiesEXT.nquadDivergentImplicitLod(adr).bool
inline val VkPhysicalDeviceDescriptorIndexingPropertiesEXT.maxPerStageDescriptorUpdateAfterBindSamplers: Int
    get() = VkPhysicalDeviceDescriptorIndexingPropertiesEXT.nmaxPerStageDescriptorUpdateAfterBindSamplers(adr)
inline val VkPhysicalDeviceDescriptorIndexingPropertiesEXT.maxPerStageDescriptorUpdateAfterBindUniformBuffers: Int
    get() = VkPhysicalDeviceDescriptorIndexingPropertiesEXT.nmaxPerStageDescriptorUpdateAfterBindUniformBuffers(adr)
inline val VkPhysicalDeviceDescriptorIndexingPropertiesEXT.maxPerStageDescriptorUpdateAfterBindStorageBuffers: Int
    get() = VkPhysicalDeviceDescriptorIndexingPropertiesEXT.nmaxPerStageDescriptorUpdateAfterBindStorageBuffers(adr)
inline val VkPhysicalDeviceDescriptorIndexingPropertiesEXT.maxPerStageDescriptorUpdateAfterBindSampledImages: Int
    get() = VkPhysicalDeviceDescriptorIndexingPropertiesEXT.nmaxPerStageDescriptorUpdateAfterBindSampledImages(adr)
inline val VkPhysicalDeviceDescriptorIndexingPropertiesEXT.maxPerStageDescriptorUpdateAfterBindStorageImages: Int
    get() = VkPhysicalDeviceDescriptorIndexingPropertiesEXT.nmaxPerStageDescriptorUpdateAfterBindStorageImages(adr)
inline val VkPhysicalDeviceDescriptorIndexingPropertiesEXT.maxPerStageDescriptorUpdateAfterBindInputAttachments: Int
    get() = VkPhysicalDeviceDescriptorIndexingPropertiesEXT.nmaxPerStageDescriptorUpdateAfterBindInputAttachments(adr)
inline val VkPhysicalDeviceDescriptorIndexingPropertiesEXT.maxPerStageUpdateAfterBindResources: Int
    get() = VkPhysicalDeviceDescriptorIndexingPropertiesEXT.nmaxPerStageUpdateAfterBindResources(adr)
inline val VkPhysicalDeviceDescriptorIndexingPropertiesEXT.maxDescriptorSetUpdateAfterBindSamplers: Int
    get() = VkPhysicalDeviceDescriptorIndexingPropertiesEXT.nmaxDescriptorSetUpdateAfterBindSamplers(adr)
inline val VkPhysicalDeviceDescriptorIndexingPropertiesEXT.maxDescriptorSetUpdateAfterBindUniformBuffers: Int
    get() = VkPhysicalDeviceDescriptorIndexingPropertiesEXT.nmaxDescriptorSetUpdateAfterBindUniformBuffers(adr)
inline val VkPhysicalDeviceDescriptorIndexingPropertiesEXT.maxDescriptorSetUpdateAfterBindUniformBuffersDynamic: Int
    get() = VkPhysicalDeviceDescriptorIndexingPropertiesEXT.nmaxDescriptorSetUpdateAfterBindUniformBuffersDynamic(adr)
inline val VkPhysicalDeviceDescriptorIndexingPropertiesEXT.maxDescriptorSetUpdateAfterBindStorageBuffers: Int
    get() = VkPhysicalDeviceDescriptorIndexingPropertiesEXT.nmaxDescriptorSetUpdateAfterBindStorageBuffers(adr)
inline val VkPhysicalDeviceDescriptorIndexingPropertiesEXT.maxDescriptorSetUpdateAfterBindStorageBuffersDynamic: Int
    get() = VkPhysicalDeviceDescriptorIndexingPropertiesEXT.nmaxDescriptorSetUpdateAfterBindStorageBuffersDynamic(adr)
inline val VkPhysicalDeviceDescriptorIndexingPropertiesEXT.maxDescriptorSetUpdateAfterBindSampledImages: Int
    get() = VkPhysicalDeviceDescriptorIndexingPropertiesEXT.nmaxDescriptorSetUpdateAfterBindSampledImages(adr)
inline val VkPhysicalDeviceDescriptorIndexingPropertiesEXT.maxDescriptorSetUpdateAfterBindStorageImages: Int
    get() = VkPhysicalDeviceDescriptorIndexingPropertiesEXT.nmaxDescriptorSetUpdateAfterBindStorageImages(adr)
inline val VkPhysicalDeviceDescriptorIndexingPropertiesEXT.maxDescriptorSetUpdateAfterBindInputAttachments: Int
    get() = VkPhysicalDeviceDescriptorIndexingPropertiesEXT.nmaxDescriptorSetUpdateAfterBindInputAttachments(adr)


inline var VkDescriptorSetVariableDescriptorCountAllocateInfoEXT.type: VkStructureType
    get() = VkStructureType(VkDescriptorSetVariableDescriptorCountAllocateInfoEXT.nsType(adr))
    set(value) = VkDescriptorSetVariableDescriptorCountAllocateInfoEXT.nsType(adr, value.i)
inline var VkDescriptorSetVariableDescriptorCountAllocateInfoEXT.next: Ptr
    get() = VkDescriptorSetVariableDescriptorCountAllocateInfoEXT.npNext(adr)
    set(value) = VkDescriptorSetVariableDescriptorCountAllocateInfoEXT.npNext(adr, value)
inline var VkDescriptorSetVariableDescriptorCountAllocateInfoEXT.descriptorSetCount: Int
    get() = VkDescriptorSetVariableDescriptorCountAllocateInfoEXT.ndescriptorSetCount(adr)
    set(value) = VkDescriptorSetVariableDescriptorCountAllocateInfoEXT.ndescriptorSetCount(adr, value)
inline var VkDescriptorSetVariableDescriptorCountAllocateInfoEXT.descriptorCounts: IntBuffer?
    get() = VkDescriptorSetVariableDescriptorCountAllocateInfoEXT.npDescriptorCounts(adr)
    set(value) = VkDescriptorSetVariableDescriptorCountAllocateInfoEXT.npDescriptorCounts(adr, value)


inline var VkDescriptorSetVariableDescriptorCountLayoutSupportEXT.type: VkStructureType
    get() = VkStructureType(VkDescriptorSetVariableDescriptorCountLayoutSupportEXT.nsType(adr))
    set(value) = VkDescriptorSetVariableDescriptorCountLayoutSupportEXT.nsType(adr, value.i)
inline var VkDescriptorSetVariableDescriptorCountLayoutSupportEXT.next: Ptr
    get() = VkDescriptorSetVariableDescriptorCountLayoutSupportEXT.npNext(adr)
    set(value) = VkDescriptorSetVariableDescriptorCountLayoutSupportEXT.npNext(adr, value)
inline val VkDescriptorSetVariableDescriptorCountLayoutSupportEXT.maxVariableDescriptorCount: Int
    get() = VkDescriptorSetVariableDescriptorCountLayoutSupportEXT.nmaxVariableDescriptorCount(adr)


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


inline var VkShadingRatePaletteNV.shadingRatePaletteEntryCount: Int
    get() = VkShadingRatePaletteNV.nshadingRatePaletteEntryCount(adr)
    @Deprecated("this will be set automatically")
    set(value) = VkShadingRatePaletteNV.nshadingRatePaletteEntryCount(adr, value.i)
inline var VkShadingRatePaletteNV.shadingRatePaletteEntries: VkShadingRatePaletteEntryNV_Buffer
    get() = VkShadingRatePaletteEntryNV_Buffer(VkShadingRatePaletteNV.npShadingRatePaletteEntries(adr))
    set(value) = VkShadingRatePaletteNV.npShadingRatePaletteEntries(adr, value.buffer)


inline var VkPipelineViewportShadingRateImageStateCreateInfoNV.type: VkStructureType
    get() = VkStructureType(VkPipelineViewportShadingRateImageStateCreateInfoNV.nsType(adr))
    set(value) = VkPipelineViewportShadingRateImageStateCreateInfoNV.nsType(adr, value.i)
inline var VkPipelineViewportShadingRateImageStateCreateInfoNV.next: Ptr
    get() = VkPipelineViewportShadingRateImageStateCreateInfoNV.npNext(adr)
    set(value) = VkPipelineViewportShadingRateImageStateCreateInfoNV.npNext(adr, value)
inline var VkPipelineViewportShadingRateImageStateCreateInfoNV.shadingRateImageEnable: Boolean
    get() = VkPipelineViewportShadingRateImageStateCreateInfoNV.nshadingRateImageEnable(adr).bool
    set(value) = VkPipelineViewportShadingRateImageStateCreateInfoNV.nshadingRateImageEnable(adr, value.i)
inline var VkPipelineViewportShadingRateImageStateCreateInfoNV.viewportCount: Int
    get() = VkPipelineViewportShadingRateImageStateCreateInfoNV.nviewportCount(adr)
    @Deprecated("this will be set automatically")
    set(value) = VkPipelineViewportShadingRateImageStateCreateInfoNV.nviewportCount(adr, value)
inline var VkPipelineViewportShadingRateImageStateCreateInfoNV.shadingRatePalettes: VkShadingRatePaletteNV.Buffer?
    get() = VkPipelineViewportShadingRateImageStateCreateInfoNV.npShadingRatePalettes(adr)
    set(value) = VkPipelineViewportShadingRateImageStateCreateInfoNV.npShadingRatePalettes(adr, value)