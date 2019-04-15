package vkk

import glm_.bool
import glm_.i
import glm_.vec2.Vec2i
import kool.Ptr
import kool.adr
import org.lwjgl.vulkan.*
import vkk.entities.*
import java.nio.IntBuffer


inline var VkPhysicalDeviceShadingRateImageFeaturesNV.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceShadingRateImageFeaturesNV.nsType(adr))
    set(value) = VkPhysicalDeviceShadingRateImageFeaturesNV.nsType(adr, value.i)
inline var VkPhysicalDeviceShadingRateImageFeaturesNV.next: Ptr
    get() = VkPhysicalDeviceShadingRateImageFeaturesNV.npNext(adr)
    set(value) = VkPhysicalDeviceShadingRateImageFeaturesNV.npNext(adr, value)
inline var VkPhysicalDeviceShadingRateImageFeaturesNV.shadingRateImage: Boolean
    get() = VkPhysicalDeviceShadingRateImageFeaturesNV.nshadingRateImage(adr).bool
    set(value) = VkPhysicalDeviceShadingRateImageFeaturesNV.nshadingRateImage(adr, value.i)
inline var VkPhysicalDeviceShadingRateImageFeaturesNV.shadingRateCoarseSampleOrder: Boolean
    get() = VkPhysicalDeviceShadingRateImageFeaturesNV.nshadingRateCoarseSampleOrder(adr).bool
    set(value) = VkPhysicalDeviceShadingRateImageFeaturesNV.nshadingRateCoarseSampleOrder(adr, value.i)


inline var VkPhysicalDeviceShadingRateImagePropertiesNV.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceShadingRateImagePropertiesNV.nsType(adr))
    set(value) = VkPhysicalDeviceShadingRateImagePropertiesNV.nsType(adr, value.i)
inline var VkPhysicalDeviceShadingRateImagePropertiesNV.next: Ptr
    get() = VkPhysicalDeviceShadingRateImagePropertiesNV.npNext(adr)
    set(value) = VkPhysicalDeviceShadingRateImagePropertiesNV.npNext(adr, value)
inline val VkPhysicalDeviceShadingRateImagePropertiesNV.shadingRateTexelSize: VkExtent2D
    get() = VkPhysicalDeviceShadingRateImagePropertiesNV.nshadingRateTexelSize(adr)
inline val VkPhysicalDeviceShadingRateImagePropertiesNV.shadingRatePaletteSize: Int
    get() = VkPhysicalDeviceShadingRateImagePropertiesNV.nshadingRatePaletteSize(adr)
inline val VkPhysicalDeviceShadingRateImagePropertiesNV.shadingRateMaxCoarseSamples: Int
    get() = VkPhysicalDeviceShadingRateImagePropertiesNV.nshadingRateMaxCoarseSamples(adr)


inline var VkCoarseSampleLocationNV.pixelX: Int
    get() = VkCoarseSampleLocationNV.npixelX(adr)
    set(value) = VkCoarseSampleLocationNV.npixelX(adr, value)
inline var VkCoarseSampleLocationNV.pixelY: Int
    get() = VkCoarseSampleLocationNV.npixelY(adr)
    set(value) = VkCoarseSampleLocationNV.npixelY(adr, value)
/** JVM custom */
inline var VkCoarseSampleLocationNV.pixel: Vec2i
    get() = Vec2i(pixelX, pixelY)
    set(value) {
        pixelX = value.x
        pixelY = value.y
    }
inline var VkCoarseSampleLocationNV.sample: Int
    get() = VkCoarseSampleLocationNV.nsample(adr)
    set(value) = VkCoarseSampleLocationNV.nsample(adr, value)


inline var VkCoarseSampleOrderCustomNV.shadingRate: VkShadingRatePaletteEntryNV
    get() = VkShadingRatePaletteEntryNV(VkCoarseSampleOrderCustomNV.nshadingRate(adr))
    set(value) = VkCoarseSampleOrderCustomNV.nshadingRate(adr, value.i)
inline var VkCoarseSampleOrderCustomNV.sampleCount: Int
    get() = VkCoarseSampleOrderCustomNV.nsampleCount(adr)
    set(value) = VkCoarseSampleOrderCustomNV.nsampleCount(adr, value)
inline var VkCoarseSampleOrderCustomNV.sampleLocationCount: Int
    get() = VkCoarseSampleOrderCustomNV.nsampleLocationCount(adr)
    set(value) = VkCoarseSampleOrderCustomNV.nsampleLocationCount(adr, value)
inline var VkCoarseSampleOrderCustomNV.sampleLocations: VkCoarseSampleLocationNV.Buffer
    get() = VkCoarseSampleOrderCustomNV.npSampleLocations(adr)
    set(value) = VkCoarseSampleOrderCustomNV.npSampleLocations(adr, value)


inline var VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.type: VkStructureType
    get() = VkStructureType(VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.nsType(adr))
    set(value) = VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.nsType(adr, value.i)
inline var VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.next: Ptr
    get() = VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.npNext(adr)
    set(value) = VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.npNext(adr, value)
inline var VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.sampleOrderType: VkCoarseSampleOrderTypeNV
    get() = VkCoarseSampleOrderTypeNV(VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.nsampleOrderType(adr))
    set(value) = VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.nsampleOrderType(adr, value.i)
inline var VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.customSampleOrderCount: Int
    get() = VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.ncustomSampleOrderCount(adr)
    set(value) = VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.ncustomSampleOrderCount(adr, value.i)
inline var VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.customSampleOrders: VkCoarseSampleOrderCustomNV.Buffer?
    get() = VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.npCustomSampleOrders(adr)
    set(value) = VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.npCustomSampleOrders(adr, value)


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


inline var VkRayTracingShaderGroupCreateInfoNV.sType: VkStructureType
    get() = VkStructureType(VkRayTracingShaderGroupCreateInfoNV.nsType(adr))
    set(value) = VkRayTracingShaderGroupCreateInfoNV.nsType(adr, value.i)
inline var VkRayTracingShaderGroupCreateInfoNV.next: Ptr
    get() = VkRayTracingShaderGroupCreateInfoNV.npNext(adr)
    set(value) = VkRayTracingShaderGroupCreateInfoNV.npNext(adr, value)
inline var VkRayTracingShaderGroupCreateInfoNV.type: VkRayTracingShaderGroupTypeNV
    get() = VkRayTracingShaderGroupTypeNV(VkRayTracingShaderGroupCreateInfoNV.ntype(adr))
    set(value) = VkRayTracingShaderGroupCreateInfoNV.ntype(adr, value.i)
inline var VkRayTracingShaderGroupCreateInfoNV.generalShader: Int
    get() = VkRayTracingShaderGroupCreateInfoNV.ngeneralShader(adr)
    set(value) = VkRayTracingShaderGroupCreateInfoNV.ngeneralShader(adr, value.i)
inline var VkRayTracingShaderGroupCreateInfoNV.closestHitShader: Int
    get() = VkRayTracingShaderGroupCreateInfoNV.nclosestHitShader(adr)
    set(value) = VkRayTracingShaderGroupCreateInfoNV.nclosestHitShader(adr, value)
inline var VkRayTracingShaderGroupCreateInfoNV.anyHitShader: Int
    get() = VkRayTracingShaderGroupCreateInfoNV.nanyHitShader(adr)
    set(value) = VkRayTracingShaderGroupCreateInfoNV.nanyHitShader(adr, value.i)
inline var VkRayTracingShaderGroupCreateInfoNV.intersectionShader: Int
    get() = VkRayTracingShaderGroupCreateInfoNV.nintersectionShader(adr)
    set(value) = VkRayTracingShaderGroupCreateInfoNV.nintersectionShader(adr, value)


inline var VkRayTracingPipelineCreateInfoNV.type: VkStructureType
    get() = VkStructureType(VkRayTracingPipelineCreateInfoNV.nsType(adr))
    set(value) = VkRayTracingPipelineCreateInfoNV.nsType(adr, value.i)
inline var VkRayTracingPipelineCreateInfoNV.next: Ptr
    get() = VkRayTracingPipelineCreateInfoNV.npNext(adr)
    set(value) = VkRayTracingPipelineCreateInfoNV.npNext(adr, value)
inline var VkRayTracingPipelineCreateInfoNV.flags: VkPipelineCreateFlags
    get() = VkRayTracingPipelineCreateInfoNV.nflags(adr)
    set(value) = VkRayTracingPipelineCreateInfoNV.nflags(adr, value.i)
inline var VkRayTracingPipelineCreateInfoNV.stageCount: Int
    get() = VkRayTracingPipelineCreateInfoNV.nstageCount(adr)
    @Deprecated("this will be set automatically")
    set(value) = VkRayTracingPipelineCreateInfoNV.nstageCount(adr, value.i)
inline var VkRayTracingPipelineCreateInfoNV.stages: VkPipelineShaderStageCreateInfo.Buffer
    get() = VkRayTracingPipelineCreateInfoNV.npStages(adr)
    set(value) = VkRayTracingPipelineCreateInfoNV.npStages(adr, value)
inline var VkRayTracingPipelineCreateInfoNV.groupCount: Int
    get() = VkRayTracingPipelineCreateInfoNV.ngroupCount(adr)
    @Deprecated("this will be set automatically")
    set(value) = VkRayTracingPipelineCreateInfoNV.ngroupCount(adr, value.i)
inline var VkRayTracingPipelineCreateInfoNV.groups: VkRayTracingShaderGroupCreateInfoNV.Buffer
    get() = VkRayTracingPipelineCreateInfoNV.npGroups(adr)
    set(value) = VkRayTracingPipelineCreateInfoNV.npGroups(adr, value)
inline var VkRayTracingPipelineCreateInfoNV.maxRecursionDepth: Int
    get() = VkRayTracingPipelineCreateInfoNV.nmaxRecursionDepth(adr)
    set(value) = VkRayTracingPipelineCreateInfoNV.nmaxRecursionDepth(adr, value)
inline var VkRayTracingPipelineCreateInfoNV.layout: VkPipelineLayout
    get() = VkPipelineLayout(VkRayTracingPipelineCreateInfoNV.nlayout(adr))
    set(value) = VkRayTracingPipelineCreateInfoNV.nlayout(adr, value.L)
inline var VkRayTracingPipelineCreateInfoNV.basePipelineHandle: VkPipeline
    get() = VkPipeline(VkRayTracingPipelineCreateInfoNV.nbasePipelineHandle(adr))
    set(value) = VkRayTracingPipelineCreateInfoNV.nbasePipelineHandle(adr, value.L)
inline var VkRayTracingPipelineCreateInfoNV.basePipelineIndex: Int
    get() = VkRayTracingPipelineCreateInfoNV.nbasePipelineIndex(adr)
    set(value) = VkRayTracingPipelineCreateInfoNV.nbasePipelineIndex(adr, value)


inline var VkGeometryTrianglesNV.type: VkStructureType
    get() = VkStructureType(VkGeometryTrianglesNV.nsType(adr))
    set(value) = VkGeometryTrianglesNV.nsType(adr, value.i)
inline var VkGeometryTrianglesNV.next: Ptr
    get() = VkGeometryTrianglesNV.npNext(adr)
    set(value) = VkGeometryTrianglesNV.npNext(adr, value)
inline var VkGeometryTrianglesNV.vertexData: VkBuffer
    get() = VkBuffer(VkGeometryTrianglesNV.nvertexData(adr))
    set(value) = VkGeometryTrianglesNV.nvertexData(adr, value.L)
inline var VkGeometryTrianglesNV.vertexOffset: VkDeviceSize
    get() = VkDeviceSize(VkGeometryTrianglesNV.nvertexOffset(adr))
    set(value) = VkGeometryTrianglesNV.nvertexOffset(adr, value.L)
inline var VkGeometryTrianglesNV.vertexCount: Int
    get() = VkGeometryTrianglesNV.nvertexCount(adr)
    set(value) = VkGeometryTrianglesNV.nvertexCount(adr, value)
inline var VkGeometryTrianglesNV.vertexStride: VkDeviceSize
    get() = VkDeviceSize(VkGeometryTrianglesNV.nvertexStride(adr))
    set(value) = VkGeometryTrianglesNV.nvertexStride(adr, value.L)
inline var VkGeometryTrianglesNV.vertexFormat: VkFormat
    get() = VkFormat(VkGeometryTrianglesNV.nvertexFormat(adr))
    set(value) = VkGeometryTrianglesNV.nvertexFormat(adr, value.i)
inline var VkGeometryTrianglesNV.indexData: VkBuffer
    get() = VkBuffer(VkGeometryTrianglesNV.nindexData(adr))
    set(value) = VkGeometryTrianglesNV.nindexData(adr, value.L)
inline var VkGeometryTrianglesNV.indexOffset: VkDeviceSize
    get() = VkDeviceSize(VkGeometryTrianglesNV.nindexOffset(adr))
    set(value) = VkGeometryTrianglesNV.nindexOffset(adr, value.L)
inline var VkGeometryTrianglesNV.indexCount: Int
    get() = VkGeometryTrianglesNV.nindexCount(adr)
    set(value) = VkGeometryTrianglesNV.nindexCount(adr, value)
inline var VkGeometryTrianglesNV.indexType: VkIndexType
    get() = VkIndexType(VkGeometryTrianglesNV.nindexType(adr))
    set(value) = VkGeometryTrianglesNV.nindexType(adr, value.i)
inline var VkGeometryTrianglesNV.transformData: VkBuffer
    get() = VkBuffer(VkGeometryTrianglesNV.ntransformData(adr))
    set(value) = VkGeometryTrianglesNV.ntransformData(adr, value.L)
inline var VkGeometryTrianglesNV.transformOffset: VkDeviceSize
    get() = VkDeviceSize(VkGeometryTrianglesNV.ntransformOffset(adr))
    set(value) = VkGeometryTrianglesNV.ntransformOffset(adr, value.L)


inline var VkGeometryAABBNV.type: VkStructureType
    get() = VkStructureType(VkGeometryAABBNV.nsType(adr))
    set(value) = VkGeometryAABBNV.nsType(adr, value.i)
inline var VkGeometryAABBNV.next: Ptr
    get() = VkGeometryAABBNV.npNext(adr)
    set(value) = VkGeometryAABBNV.npNext(adr, value)
inline var VkGeometryAABBNV.aabbData: VkBuffer
    get() = VkBuffer(VkGeometryAABBNV.naabbData(adr))
    set(value) = VkGeometryAABBNV.naabbData(adr, value.L)
inline var VkGeometryAABBNV.numAABBs: Int
    get() = VkGeometryAABBNV.nnumAABBs(adr)
    set(value) = VkGeometryAABBNV.nnumAABBs(adr, value)
inline var VkGeometryAABBNV.stride: Int
    get() = VkGeometryAABBNV.nstride(adr)
    set(value) = VkGeometryAABBNV.nstride(adr, value)
inline var VkGeometryAABBNV.offset: VkDeviceSize
    get() = VkDeviceSize(VkGeometryAABBNV.noffset(adr))
    set(value) = VkGeometryAABBNV.noffset(adr, value.L)


inline var VkGeometryDataNV.triangles: VkGeometryTrianglesNV
    get() = VkGeometryDataNV.ntriangles(adr)
    set(value) = VkGeometryDataNV.ntriangles(adr, value)
inline var VkGeometryDataNV.aabbs: VkGeometryAABBNV
    get() = VkGeometryDataNV.naabbs(adr)
    set(value) = VkGeometryDataNV.naabbs(adr, value)


inline var VkGeometryNV.type: VkStructureType
    get() = VkStructureType(VkGeometryNV.nsType(adr))
    set(value) = VkGeometryNV.nsType(adr, value.i)
inline var VkGeometryNV.next: Ptr
    get() = VkGeometryNV.npNext(adr)
    set(value) = VkGeometryNV.npNext(adr, value)
inline var VkGeometryNV.geometryType: VkGeometryTypeNV
    get() = VkGeometryTypeNV(VkGeometryNV.ngeometryType(adr))
    set(value) = VkGeometryNV.ngeometryType(adr, value.i)
inline var VkGeometryNV.geometry: VkGeometryDataNV
    get() = VkGeometryNV.ngeometry(adr)
    set(value) = VkGeometryNV.ngeometry(adr, value)
inline var VkGeometryNV.flags: VkGeometryFlagsNV
    get() = VkGeometryNV.nflags(adr)
    set(value) = VkGeometryNV.nflags(adr, value)


inline var VkAccelerationStructureInfoNV.sType: VkStructureType
    get() = VkStructureType(VkAccelerationStructureInfoNV.nsType(adr))
    set(value) = VkAccelerationStructureInfoNV.nsType(adr, value.i)
inline var VkAccelerationStructureInfoNV.next: Ptr
    get() = VkAccelerationStructureInfoNV.npNext(adr)
    set(value) = VkAccelerationStructureInfoNV.npNext(adr, value)
inline var VkAccelerationStructureInfoNV.type: VkGeometryTypeNV
    get() = VkGeometryTypeNV(VkAccelerationStructureInfoNV.ntype(adr))
    set(value) = VkAccelerationStructureInfoNV.ntype(adr, value.i)
inline var VkAccelerationStructureInfoNV.flags: VkBuildAccelerationStructureFlagsNV
    get() = VkAccelerationStructureInfoNV.nflags(adr)
    set(value) = VkAccelerationStructureInfoNV.nflags(adr, value)
inline var VkAccelerationStructureInfoNV.instanceCount: Int
    get() = VkAccelerationStructureInfoNV.ninstanceCount(adr)
    set(value) = VkAccelerationStructureInfoNV.ninstanceCount(adr, value)
inline var VkAccelerationStructureInfoNV.geometryCount: Int
    get() = VkAccelerationStructureInfoNV.ngeometryCount(adr)
    @Deprecated("this will be set automatically")
    set(value) = VkAccelerationStructureInfoNV.ngeometryCount(adr, value)
inline var VkAccelerationStructureInfoNV.geometries: VkGeometryNV.Buffer?
    get() = VkAccelerationStructureInfoNV.npGeometries(adr)
    set(value) = VkAccelerationStructureInfoNV.npGeometries(adr, value)


inline var VkAccelerationStructureCreateInfoNV.type: VkStructureType
    get() = VkStructureType(VkAccelerationStructureCreateInfoNV.nsType(adr))
    set(value) = VkAccelerationStructureCreateInfoNV.nsType(adr, value.i)
inline var VkAccelerationStructureCreateInfoNV.next: Ptr
    get() = VkAccelerationStructureCreateInfoNV.npNext(adr)
    set(value) = VkAccelerationStructureCreateInfoNV.npNext(adr, value)
inline var VkAccelerationStructureCreateInfoNV.compactedSize: VkDeviceSize
    get() = VkDeviceSize(VkAccelerationStructureCreateInfoNV.ncompactedSize(adr))
    set(value) = VkAccelerationStructureCreateInfoNV.ncompactedSize(adr, value.L)
inline var VkAccelerationStructureCreateInfoNV.info: VkAccelerationStructureInfoNV
    get() = VkAccelerationStructureCreateInfoNV.ninfo(adr)
    set(value) = VkAccelerationStructureCreateInfoNV.ninfo(adr, value)


inline var VkBindAccelerationStructureMemoryInfoNV.type: VkStructureType
    get() = VkStructureType(VkBindAccelerationStructureMemoryInfoNV.nsType(adr))
    set(value) = VkBindAccelerationStructureMemoryInfoNV.nsType(adr, value.i)
inline var VkBindAccelerationStructureMemoryInfoNV.next: Ptr
    get() = VkBindAccelerationStructureMemoryInfoNV.npNext(adr)
    set(value) = VkBindAccelerationStructureMemoryInfoNV.npNext(adr, value)
inline var VkBindAccelerationStructureMemoryInfoNV.accelerationStructure: VkAccelerationStructureNV
    get() = VkAccelerationStructureNV(VkBindAccelerationStructureMemoryInfoNV.naccelerationStructure(adr))
    set(value) = VkBindAccelerationStructureMemoryInfoNV.naccelerationStructure(adr, value.L)
inline var VkBindAccelerationStructureMemoryInfoNV.memory: VkDeviceMemory
    get() = VkDeviceMemory(VkBindAccelerationStructureMemoryInfoNV.nmemory(adr))
    set(value) = VkBindAccelerationStructureMemoryInfoNV.nmemory(adr, value.L)
inline var VkBindAccelerationStructureMemoryInfoNV.memoryOffset: VkDeviceSize
    get() = VkDeviceSize(VkBindAccelerationStructureMemoryInfoNV.nmemoryOffset(adr))
    set(value) = VkBindAccelerationStructureMemoryInfoNV.nmemoryOffset(adr, value.L)
inline var VkBindAccelerationStructureMemoryInfoNV.deviceIndexCount: Int
    get() = VkBindAccelerationStructureMemoryInfoNV.ndeviceIndexCount(adr)
    set(value) = VkBindAccelerationStructureMemoryInfoNV.ndeviceIndexCount(adr, value)
inline var VkBindAccelerationStructureMemoryInfoNV.deviceIndices: IntBuffer?
    get() = VkBindAccelerationStructureMemoryInfoNV.npDeviceIndices(adr)
    @Deprecated("this will be set automatically")
    set(value) = VkBindAccelerationStructureMemoryInfoNV.npDeviceIndices(adr, value)


inline var VkWriteDescriptorSetAccelerationStructureNV.type: VkStructureType
    get() = VkStructureType(VkWriteDescriptorSetAccelerationStructureNV.nsType(adr))
    set(value) = VkWriteDescriptorSetAccelerationStructureNV.nsType(adr, value.i)
inline var VkWriteDescriptorSetAccelerationStructureNV.next: Ptr
    get() = VkWriteDescriptorSetAccelerationStructureNV.npNext(adr)
    set(value) = VkWriteDescriptorSetAccelerationStructureNV.npNext(adr, value)
inline var VkWriteDescriptorSetAccelerationStructureNV.accelerationStructureCount: Int
    get() = VkWriteDescriptorSetAccelerationStructureNV.naccelerationStructureCount(adr)
    set(value) = VkWriteDescriptorSetAccelerationStructureNV.naccelerationStructureCount(adr, value)
inline var VkWriteDescriptorSetAccelerationStructureNV.accelerationStructures: VkAccelerationStructureNV_Buffer
    get() = VkAccelerationStructureNV_Buffer(VkWriteDescriptorSetAccelerationStructureNV.npAccelerationStructures(adr))
    set(value) = VkWriteDescriptorSetAccelerationStructureNV.npAccelerationStructures(adr, value.buffer)


inline var VkAccelerationStructureMemoryRequirementsInfoNV.sType: VkStructureType
    get() = VkStructureType(VkAccelerationStructureMemoryRequirementsInfoNV.nsType(adr))
    set(value) = VkAccelerationStructureMemoryRequirementsInfoNV.nsType(adr, value.i)
inline var VkAccelerationStructureMemoryRequirementsInfoNV.next: Ptr
    get() = VkAccelerationStructureMemoryRequirementsInfoNV.npNext(adr)
    set(value) = VkAccelerationStructureMemoryRequirementsInfoNV.npNext(adr, value)
inline var VkAccelerationStructureMemoryRequirementsInfoNV.type: VkAccelerationStructureMemoryRequirementsTypeNV
    get() = VkAccelerationStructureMemoryRequirementsTypeNV(VkAccelerationStructureMemoryRequirementsInfoNV.ntype(adr))
    set(value) = VkAccelerationStructureMemoryRequirementsInfoNV.ntype(adr, value.i)
inline var VkAccelerationStructureMemoryRequirementsInfoNV.accelerationStructure: VkAccelerationStructureNV
    get() = VkAccelerationStructureNV(VkAccelerationStructureMemoryRequirementsInfoNV.naccelerationStructure(adr))
    set(value) = VkAccelerationStructureMemoryRequirementsInfoNV.naccelerationStructure(adr, value.L)


inline var VkPhysicalDeviceRayTracingPropertiesNV.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceRayTracingPropertiesNV.nsType(adr))
    set(value) = VkPhysicalDeviceRayTracingPropertiesNV.nsType(adr, value.i)
inline var VkPhysicalDeviceRayTracingPropertiesNV.next: Ptr
    get() = VkPhysicalDeviceRayTracingPropertiesNV.npNext(adr)
    set(value) = VkPhysicalDeviceRayTracingPropertiesNV.npNext(adr, value)
inline val VkPhysicalDeviceRayTracingPropertiesNV.shaderGroupHandleSize: Int
    get() = VkPhysicalDeviceRayTracingPropertiesNV.nshaderGroupHandleSize(adr)
inline val VkPhysicalDeviceRayTracingPropertiesNV.maxRecursionDepth: Int
    get() = VkPhysicalDeviceRayTracingPropertiesNV.nmaxRecursionDepth(adr)
inline val VkPhysicalDeviceRayTracingPropertiesNV.maxShaderGroupStride: Int
    get() = VkPhysicalDeviceRayTracingPropertiesNV.nmaxShaderGroupStride(adr)
inline val VkPhysicalDeviceRayTracingPropertiesNV.shaderGroupBaseAlignment: Int
    get() = VkPhysicalDeviceRayTracingPropertiesNV.nshaderGroupBaseAlignment(adr)
inline val VkPhysicalDeviceRayTracingPropertiesNV.maxGeometryCount: Long
    get() = VkPhysicalDeviceRayTracingPropertiesNV.nmaxGeometryCount(adr)
inline val VkPhysicalDeviceRayTracingPropertiesNV.maxInstanceCount: Long
    get() = VkPhysicalDeviceRayTracingPropertiesNV.nmaxInstanceCount(adr)
inline val VkPhysicalDeviceRayTracingPropertiesNV.maxTriangleCount: Long
    get() = VkPhysicalDeviceRayTracingPropertiesNV.nmaxTriangleCount(adr)
inline val VkPhysicalDeviceRayTracingPropertiesNV.maxDescriptorSetAccelerationStructures: Int
    get() = VkPhysicalDeviceRayTracingPropertiesNV.nmaxDescriptorSetAccelerationStructures(adr)


inline var VkPhysicalDeviceImageViewImageFormatInfoEXT.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceImageViewImageFormatInfoEXT.nsType(adr))
    set(value) = VkPhysicalDeviceImageViewImageFormatInfoEXT.nsType(adr, value.i)
inline var VkPhysicalDeviceImageViewImageFormatInfoEXT.next: Ptr
    get() = VkPhysicalDeviceImageViewImageFormatInfoEXT.npNext(adr)
    set(value) = VkPhysicalDeviceImageViewImageFormatInfoEXT.npNext(adr, value)
inline var VkPhysicalDeviceImageViewImageFormatInfoEXT.imageViewType: VkImageViewType
    get() = VkImageViewType(VkPhysicalDeviceImageViewImageFormatInfoEXT.nimageViewType(adr))
    set(value) = VkPhysicalDeviceImageViewImageFormatInfoEXT.nimageViewType(adr, value.i)


inline var VkFilterCubicImageViewImageFormatPropertiesEXT.type: VkStructureType
    get() = VkStructureType(VkFilterCubicImageViewImageFormatPropertiesEXT.nsType(adr))
    set(value) = VkFilterCubicImageViewImageFormatPropertiesEXT.nsType(adr, value.i)
inline var VkFilterCubicImageViewImageFormatPropertiesEXT.next: Ptr
    get() = VkFilterCubicImageViewImageFormatPropertiesEXT.npNext(adr)
    set(value) = VkFilterCubicImageViewImageFormatPropertiesEXT.npNext(adr, value)
inline val VkFilterCubicImageViewImageFormatPropertiesEXT.filterCubic: Boolean
    get() = VkFilterCubicImageViewImageFormatPropertiesEXT.nfilterCubic(adr).bool
inline val VkFilterCubicImageViewImageFormatPropertiesEXT.filterCubicMinmax: Boolean
    get() = VkFilterCubicImageViewImageFormatPropertiesEXT.nfilterCubicMinmax(adr).bool


inline class VkQueueGlobalPriorityEXT(val i: Int) {
    companion object {
        val LOW_EXT = VkQueueGlobalPriorityEXT(128)
        val MEDIUM_EXT = VkQueueGlobalPriorityEXT(256)
        val HIGH_EXT = VkQueueGlobalPriorityEXT(512)
        val REALTIME_EXT = VkQueueGlobalPriorityEXT(1024)
    }
}


inline var VkDeviceQueueGlobalPriorityCreateInfoEXT.type: VkStructureType
    get() = VkStructureType(VkDeviceQueueGlobalPriorityCreateInfoEXT.nsType(adr))
    set(value) = VkDeviceQueueGlobalPriorityCreateInfoEXT.nsType(adr, value.i)
inline var VkDeviceQueueGlobalPriorityCreateInfoEXT.next: Ptr
    get() = VkDeviceQueueGlobalPriorityCreateInfoEXT.npNext(adr)
    set(value) = VkDeviceQueueGlobalPriorityCreateInfoEXT.npNext(adr, value)
inline var VkDeviceQueueGlobalPriorityCreateInfoEXT.globalPriority: VkQueueGlobalPriorityEXT
    get() = VkQueueGlobalPriorityEXT(VkDeviceQueueGlobalPriorityCreateInfoEXT.nglobalPriority(adr))
    set(value) = VkDeviceQueueGlobalPriorityCreateInfoEXT.nglobalPriority(adr, value.i)


inline var VkImportMemoryHostPointerInfoEXT.type: VkStructureType
    get() = VkStructureType(VkImportMemoryHostPointerInfoEXT.nsType(adr))
    set(value) = VkImportMemoryHostPointerInfoEXT.nsType(adr, value.i)
inline var VkImportMemoryHostPointerInfoEXT.next: Ptr
    get() = VkImportMemoryHostPointerInfoEXT.npNext(adr)
    set(value) = VkImportMemoryHostPointerInfoEXT.npNext(adr, value)
inline var VkImportMemoryHostPointerInfoEXT.handleType: VkExternalMemoryHandleType
    get() = VkExternalMemoryHandleType(VkImportMemoryHostPointerInfoEXT.nhandleType(adr))
    set(value) = VkImportMemoryHostPointerInfoEXT.nhandleType(adr, value.i)
inline var VkImportMemoryHostPointerInfoEXT.hostPointer: Ptr
    get() = VkImportMemoryHostPointerInfoEXT.npHostPointer(adr)
    set(value) = VkImportMemoryHostPointerInfoEXT.npHostPointer(adr, value)


inline var VkMemoryHostPointerPropertiesEXT.type: VkStructureType
    get() = VkStructureType(VkMemoryHostPointerPropertiesEXT.nsType(adr))
    set(value) = VkMemoryHostPointerPropertiesEXT.nsType(adr, value.i)
inline var VkMemoryHostPointerPropertiesEXT.next: Ptr
    get() = VkMemoryHostPointerPropertiesEXT.npNext(adr)
    set(value) = VkMemoryHostPointerPropertiesEXT.npNext(adr, value)
inline val VkMemoryHostPointerPropertiesEXT.memoryTypeBits: Int
    get() = VkMemoryHostPointerPropertiesEXT.nmemoryTypeBits(adr)


inline var VkPhysicalDeviceExternalMemoryHostPropertiesEXT.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceExternalMemoryHostPropertiesEXT.nsType(adr))
    set(value) = VkPhysicalDeviceExternalMemoryHostPropertiesEXT.nsType(adr, value.i)
inline var VkPhysicalDeviceExternalMemoryHostPropertiesEXT.next: Ptr
    get() = VkPhysicalDeviceExternalMemoryHostPropertiesEXT.npNext(adr)
    set(value) = VkPhysicalDeviceExternalMemoryHostPropertiesEXT.npNext(adr, value)
inline val VkPhysicalDeviceExternalMemoryHostPropertiesEXT.minImportedHostPointerAlignment: VkDeviceSize
    get() = VkDeviceSize(VkPhysicalDeviceExternalMemoryHostPropertiesEXT.nminImportedHostPointerAlignment(adr))


inline class VkTimeDomainEXT(val i: Int) {
    companion object {
        val DEVICE = VkTimeDomainEXT(0)
        val CLOCK_MONOTONIC = VkTimeDomainEXT(1)
        val CLOCK_MONOTONIC_RAW = VkTimeDomainEXT(2)
        val QUERY_PERFORMANCE_COUNTER = VkTimeDomainEXT(3)
    }
}


inline var VkCalibratedTimestampInfoEXT.type: VkStructureType
    get() = VkStructureType(VkCalibratedTimestampInfoEXT.nsType(adr))
    set(value) = VkCalibratedTimestampInfoEXT.nsType(adr, value.i)
inline var VkCalibratedTimestampInfoEXT.next: Ptr
    get() = VkCalibratedTimestampInfoEXT.npNext(adr)
    set(value) = VkCalibratedTimestampInfoEXT.npNext(adr, value)
inline var VkCalibratedTimestampInfoEXT.timeDomain: VkTimeDomainEXT
    get() = VkTimeDomainEXT(VkCalibratedTimestampInfoEXT.ntimeDomain(adr))
    set(value) = VkCalibratedTimestampInfoEXT.ntimeDomain(adr, value.i)


inline var VkPhysicalDeviceShaderCorePropertiesAMD.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceShaderCorePropertiesAMD.nsType(adr))
    set(value) = VkPhysicalDeviceShaderCorePropertiesAMD.nsType(adr, value.i)
inline var VkPhysicalDeviceShaderCorePropertiesAMD.next: Ptr
    get() = VkPhysicalDeviceShaderCorePropertiesAMD.npNext(adr)
    set(value) = VkPhysicalDeviceShaderCorePropertiesAMD.npNext(adr, value)
inline val VkPhysicalDeviceShaderCorePropertiesAMD.shaderEngineCount: Int
    get() = VkPhysicalDeviceShaderCorePropertiesAMD.nshaderEngineCount(adr)
inline val VkPhysicalDeviceShaderCorePropertiesAMD.shaderArraysPerEngineCount: Int
    get() = VkPhysicalDeviceShaderCorePropertiesAMD.nshaderArraysPerEngineCount(adr)
inline val VkPhysicalDeviceShaderCorePropertiesAMD.computeUnitsPerShaderArray: Int
    get() = VkPhysicalDeviceShaderCorePropertiesAMD.ncomputeUnitsPerShaderArray(adr)
inline val VkPhysicalDeviceShaderCorePropertiesAMD.simdPerComputeUnit: Int
    get() = VkPhysicalDeviceShaderCorePropertiesAMD.nsimdPerComputeUnit(adr)
inline val VkPhysicalDeviceShaderCorePropertiesAMD.wavefrontsPerSimd: Int
    get() = VkPhysicalDeviceShaderCorePropertiesAMD.nwavefrontsPerSimd(adr)
inline val VkPhysicalDeviceShaderCorePropertiesAMD.wavefrontSize: Int
    get() = VkPhysicalDeviceShaderCorePropertiesAMD.nwavefrontSize(adr)
inline val VkPhysicalDeviceShaderCorePropertiesAMD.sgprsPerSimd: Int
    get() = VkPhysicalDeviceShaderCorePropertiesAMD.nsgprsPerSimd(adr)
inline val VkPhysicalDeviceShaderCorePropertiesAMD.minSgprAllocation: Int
    get() = VkPhysicalDeviceShaderCorePropertiesAMD.nminSgprAllocation(adr)
inline val VkPhysicalDeviceShaderCorePropertiesAMD.maxSgprAllocation: Int
    get() = VkPhysicalDeviceShaderCorePropertiesAMD.nmaxSgprAllocation(adr)
inline val VkPhysicalDeviceShaderCorePropertiesAMD.sgprAllocationGranularity: Int
    get() = VkPhysicalDeviceShaderCorePropertiesAMD.nsgprAllocationGranularity(adr)
inline val VkPhysicalDeviceShaderCorePropertiesAMD.vgprsPerSimd: Int
    get() = VkPhysicalDeviceShaderCorePropertiesAMD.nvgprsPerSimd(adr)
inline val VkPhysicalDeviceShaderCorePropertiesAMD.minVgprAllocation: Int
    get() = VkPhysicalDeviceShaderCorePropertiesAMD.nminVgprAllocation(adr)
inline val VkPhysicalDeviceShaderCorePropertiesAMD.maxVgprAllocation: Int
    get() = VkPhysicalDeviceShaderCorePropertiesAMD.nmaxVgprAllocation(adr)
inline val VkPhysicalDeviceShaderCorePropertiesAMD.vgprAllocationGranularity: Int
    get() = VkPhysicalDeviceShaderCorePropertiesAMD.nvgprAllocationGranularity(adr)


inline class VkMemoryOverallocationBehaviorAMD(val i: Int) {
    companion object {
        val DEFAULT_AMD = VkMemoryOverallocationBehaviorAMD(0)
        val ALLOWED_AMD = VkMemoryOverallocationBehaviorAMD(1)
        val DISALLOWED_AMD = VkMemoryOverallocationBehaviorAMD(2)
    }
}


inline var VkDeviceMemoryOverallocationCreateInfoAMD.type: VkStructureType
    get() = VkStructureType(VkDeviceMemoryOverallocationCreateInfoAMD.nsType(adr))
    set(value) = VkDeviceMemoryOverallocationCreateInfoAMD.nsType(adr, value.i)
inline var VkDeviceMemoryOverallocationCreateInfoAMD.next: Ptr
    get() = VkDeviceMemoryOverallocationCreateInfoAMD.npNext(adr)
    set(value) = VkDeviceMemoryOverallocationCreateInfoAMD.npNext(adr, value)
inline var VkDeviceMemoryOverallocationCreateInfoAMD.overallocationBehavior: VkMemoryOverallocationBehaviorAMD
    get() = VkMemoryOverallocationBehaviorAMD(VkDeviceMemoryOverallocationCreateInfoAMD.noverallocationBehavior(adr))
    set(value) = VkDeviceMemoryOverallocationCreateInfoAMD.noverallocationBehavior(adr, value.i)


inline var VkPhysicalDeviceVertexAttributeDivisorPropertiesEXT.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceVertexAttributeDivisorPropertiesEXT.nsType(adr))
    set(value) = VkPhysicalDeviceVertexAttributeDivisorPropertiesEXT.nsType(adr, value.i)
inline var VkPhysicalDeviceVertexAttributeDivisorPropertiesEXT.next: Ptr
    get() = VkPhysicalDeviceVertexAttributeDivisorPropertiesEXT.npNext(adr)
    set(value) = VkPhysicalDeviceVertexAttributeDivisorPropertiesEXT.npNext(adr, value)
inline val VkPhysicalDeviceVertexAttributeDivisorPropertiesEXT.maxVertexAttribDivisor: Int
    get() = VkPhysicalDeviceVertexAttributeDivisorPropertiesEXT.nmaxVertexAttribDivisor(adr)


inline var VkVertexInputBindingDivisorDescriptionEXT.binding: Int
    get() = VkVertexInputBindingDivisorDescriptionEXT.nbinding(adr)
    set(value) = VkVertexInputBindingDivisorDescriptionEXT.nbinding(adr, value)
inline var VkVertexInputBindingDivisorDescriptionEXT.divisor: Int
    get() = VkVertexInputBindingDivisorDescriptionEXT.ndivisor(adr)
    set(value) = VkVertexInputBindingDivisorDescriptionEXT.ndivisor(adr, value)


inline var VkPipelineVertexInputDivisorStateCreateInfoEXT.type: VkStructureType
    get() = VkStructureType(VkPipelineVertexInputDivisorStateCreateInfoEXT.nsType(adr))
    set(value) = VkPipelineVertexInputDivisorStateCreateInfoEXT.nsType(adr, value.i)
inline var VkPipelineVertexInputDivisorStateCreateInfoEXT.next: Ptr
    get() = VkPipelineVertexInputDivisorStateCreateInfoEXT.npNext(adr)
    set(value) = VkPipelineVertexInputDivisorStateCreateInfoEXT.npNext(adr, value)
inline var VkPipelineVertexInputDivisorStateCreateInfoEXT.vertexBindingDivisorCount: Int
    get() = VkPipelineVertexInputDivisorStateCreateInfoEXT.nvertexBindingDivisorCount(adr)
    @Deprecated("this will be set automatically")
    set(value) = VkPipelineVertexInputDivisorStateCreateInfoEXT.nvertexBindingDivisorCount(adr, value)
inline var VkPipelineVertexInputDivisorStateCreateInfoEXT.vertexBindingDivisors: VkVertexInputBindingDivisorDescriptionEXT.Buffer
    get() = VkPipelineVertexInputDivisorStateCreateInfoEXT.npVertexBindingDivisors(adr)
    set(value) = VkPipelineVertexInputDivisorStateCreateInfoEXT.npVertexBindingDivisors(adr, value)


inline var VkPhysicalDeviceVertexAttributeDivisorFeaturesEXT.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceVertexAttributeDivisorFeaturesEXT.nsType(adr))
    set(value) = VkPhysicalDeviceVertexAttributeDivisorFeaturesEXT.nsType(adr, value.i)
inline var VkPhysicalDeviceVertexAttributeDivisorFeaturesEXT.next: Ptr
    get() = VkPhysicalDeviceVertexAttributeDivisorFeaturesEXT.npNext(adr)
    set(value) = VkPhysicalDeviceVertexAttributeDivisorFeaturesEXT.npNext(adr, value)
inline var VkPhysicalDeviceVertexAttributeDivisorFeaturesEXT.vertexAttributeInstanceRateDivisor: Boolean
    get() = VkPhysicalDeviceVertexAttributeDivisorFeaturesEXT.nvertexAttributeInstanceRateDivisor(adr).bool
    set(value) = VkPhysicalDeviceVertexAttributeDivisorFeaturesEXT.nvertexAttributeInstanceRateDivisor(adr, value.i)
inline var VkPhysicalDeviceVertexAttributeDivisorFeaturesEXT.vertexAttributeInstanceRateZeroDivisor: Boolean
    get() = VkPhysicalDeviceVertexAttributeDivisorFeaturesEXT.nvertexAttributeInstanceRateZeroDivisor(adr).bool
    set(value) = VkPhysicalDeviceVertexAttributeDivisorFeaturesEXT.nvertexAttributeInstanceRateZeroDivisor(adr, value.i)


inline var VkPhysicalDeviceComputeShaderDerivativesFeaturesNV.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceComputeShaderDerivativesFeaturesNV.nsType(adr))
    set(value) = VkPhysicalDeviceComputeShaderDerivativesFeaturesNV.nsType(adr, value.i)
inline var VkPhysicalDeviceComputeShaderDerivativesFeaturesNV.next: Ptr
    get() = VkPhysicalDeviceComputeShaderDerivativesFeaturesNV.npNext(adr)
    set(value) = VkPhysicalDeviceComputeShaderDerivativesFeaturesNV.npNext(adr, value)
inline var VkPhysicalDeviceComputeShaderDerivativesFeaturesNV.computeDerivativeGroupQuads: Boolean
    get() = VkPhysicalDeviceComputeShaderDerivativesFeaturesNV.ncomputeDerivativeGroupQuads(adr).bool
    set(value) = VkPhysicalDeviceComputeShaderDerivativesFeaturesNV.ncomputeDerivativeGroupQuads(adr, value.i)
inline var VkPhysicalDeviceComputeShaderDerivativesFeaturesNV.computeDerivativeGroupLinear: Boolean
    get() = VkPhysicalDeviceComputeShaderDerivativesFeaturesNV.ncomputeDerivativeGroupLinear(adr).bool
    set(value) = VkPhysicalDeviceComputeShaderDerivativesFeaturesNV.ncomputeDerivativeGroupLinear(adr, value.i)


inline var VkPhysicalDeviceMeshShaderFeaturesNV.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceMeshShaderFeaturesNV.nsType(adr))
    set(value) = VkPhysicalDeviceMeshShaderFeaturesNV.nsType(adr, value.i)
inline var VkPhysicalDeviceMeshShaderFeaturesNV.next: Ptr
    get() = VkPhysicalDeviceMeshShaderFeaturesNV.npNext(adr)
    set(value) = VkPhysicalDeviceMeshShaderFeaturesNV.npNext(adr, value)
inline var VkPhysicalDeviceMeshShaderFeaturesNV.taskShader: Boolean
    get() = VkPhysicalDeviceMeshShaderFeaturesNV.ntaskShader(adr).bool
    set(value) = VkPhysicalDeviceMeshShaderFeaturesNV.ntaskShader(adr, value.i)
inline var VkPhysicalDeviceMeshShaderFeaturesNV.meshShader: Boolean
    get() = VkPhysicalDeviceMeshShaderFeaturesNV.nmeshShader(adr).bool
    set(value) = VkPhysicalDeviceMeshShaderFeaturesNV.nmeshShader(adr, value.i)


inline var VkPhysicalDeviceMeshShaderPropertiesNV.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceMeshShaderPropertiesNV.nsType(adr))
    set(value) = VkPhysicalDeviceMeshShaderPropertiesNV.nsType(adr, value.i)
inline var VkPhysicalDeviceMeshShaderPropertiesNV.next: Ptr
    get() = VkPhysicalDeviceMeshShaderPropertiesNV.npNext(adr)
    set(value) = VkPhysicalDeviceMeshShaderPropertiesNV.npNext(adr, value)
inline val VkPhysicalDeviceMeshShaderPropertiesNV.maxDrawMeshTasksCount: Int
    get() = VkPhysicalDeviceMeshShaderPropertiesNV.nmaxDrawMeshTasksCount(adr)
inline val VkPhysicalDeviceMeshShaderPropertiesNV.maxTaskWorkGroupInvocations: Int
    get() = VkPhysicalDeviceMeshShaderPropertiesNV.nmaxTaskWorkGroupInvocations(adr)
inline val VkPhysicalDeviceMeshShaderPropertiesNV.maxTaskWorkGroupSize: IntBuffer
    get() = VkPhysicalDeviceMeshShaderPropertiesNV.nmaxTaskWorkGroupSize(adr)
inline val VkPhysicalDeviceMeshShaderPropertiesNV.maxTaskTotalMemorySize: Int
    get() = VkPhysicalDeviceMeshShaderPropertiesNV.nmaxTaskTotalMemorySize(adr)
inline val VkPhysicalDeviceMeshShaderPropertiesNV.maxTaskOutputCount: Int
    get() = VkPhysicalDeviceMeshShaderPropertiesNV.nmaxTaskOutputCount(adr)
inline val VkPhysicalDeviceMeshShaderPropertiesNV.maxMeshWorkGroupInvocations: Int
    get() = VkPhysicalDeviceMeshShaderPropertiesNV.nmaxMeshWorkGroupInvocations(adr)
inline val VkPhysicalDeviceMeshShaderPropertiesNV.maxMeshWorkGroupSize: IntBuffer
    get() = VkPhysicalDeviceMeshShaderPropertiesNV.nmaxMeshWorkGroupSize(adr)
inline val VkPhysicalDeviceMeshShaderPropertiesNV.maxMeshTotalMemorySize: Int
    get() = VkPhysicalDeviceMeshShaderPropertiesNV.nmaxMeshTotalMemorySize(adr)
inline val VkPhysicalDeviceMeshShaderPropertiesNV.maxMeshOutputVertices: Int
    get() = VkPhysicalDeviceMeshShaderPropertiesNV.nmaxMeshOutputVertices(adr)
inline val VkPhysicalDeviceMeshShaderPropertiesNV.maxMeshOutputPrimitives: Int
    get() = VkPhysicalDeviceMeshShaderPropertiesNV.nmaxMeshOutputPrimitives(adr)
inline val VkPhysicalDeviceMeshShaderPropertiesNV.maxMeshMultiviewViewCount: Int
    get() = VkPhysicalDeviceMeshShaderPropertiesNV.nmaxMeshMultiviewViewCount(adr)
inline val VkPhysicalDeviceMeshShaderPropertiesNV.meshOutputPerVertexGranularity: Int
    get() = VkPhysicalDeviceMeshShaderPropertiesNV.nmeshOutputPerVertexGranularity(adr)
inline val VkPhysicalDeviceMeshShaderPropertiesNV.meshOutputPerPrimitiveGranularity: Int
    get() = VkPhysicalDeviceMeshShaderPropertiesNV.nmeshOutputPerPrimitiveGranularity(adr)


inline var VkDrawMeshTasksIndirectCommandNV.taskCount: Int
    get() = VkDrawMeshTasksIndirectCommandNV.ntaskCount(adr)
    set(value) = VkDrawMeshTasksIndirectCommandNV.ntaskCount(adr, value)
inline var VkDrawMeshTasksIndirectCommandNV.firstTask: Int
    get() = VkDrawMeshTasksIndirectCommandNV.nfirstTask(adr)
    set(value) = VkDrawMeshTasksIndirectCommandNV.nfirstTask(adr, value)


inline var VkPhysicalDeviceFragmentShaderBarycentricFeaturesNV.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceFragmentShaderBarycentricFeaturesNV.nsType(adr))
    set(value) = VkPhysicalDeviceFragmentShaderBarycentricFeaturesNV.nsType(adr, value.i)
inline var VkPhysicalDeviceFragmentShaderBarycentricFeaturesNV.next: Ptr
    get() = VkPhysicalDeviceFragmentShaderBarycentricFeaturesNV.npNext(adr)
    set(value) = VkPhysicalDeviceFragmentShaderBarycentricFeaturesNV.npNext(adr, value)
inline var VkPhysicalDeviceFragmentShaderBarycentricFeaturesNV.fragmentShaderBarycentric: Boolean
    get() = VkPhysicalDeviceFragmentShaderBarycentricFeaturesNV.nfragmentShaderBarycentric(adr).bool
    set(value) = VkPhysicalDeviceFragmentShaderBarycentricFeaturesNV.nfragmentShaderBarycentric(adr, value.i)


inline var VkPhysicalDeviceShaderImageFootprintFeaturesNV.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceShaderImageFootprintFeaturesNV.nsType(adr))
    set(value) = VkPhysicalDeviceShaderImageFootprintFeaturesNV.nsType(adr, value.i)
inline var VkPhysicalDeviceShaderImageFootprintFeaturesNV.next: Ptr
    get() = VkPhysicalDeviceShaderImageFootprintFeaturesNV.npNext(adr)
    set(value) = VkPhysicalDeviceShaderImageFootprintFeaturesNV.npNext(adr, value)
inline var VkPhysicalDeviceShaderImageFootprintFeaturesNV.imageFootprint: Boolean
    get() = VkPhysicalDeviceShaderImageFootprintFeaturesNV.nimageFootprint(adr).bool
    set(value) = VkPhysicalDeviceShaderImageFootprintFeaturesNV.nimageFootprint(adr, value.i)


inline var VkPipelineViewportExclusiveScissorStateCreateInfoNV.type: VkStructureType
    get() = VkStructureType(VkPipelineViewportExclusiveScissorStateCreateInfoNV.nsType(adr))
    set(value) = VkPipelineViewportExclusiveScissorStateCreateInfoNV.nsType(adr, value.i)
inline var VkPipelineViewportExclusiveScissorStateCreateInfoNV.next: Ptr
    get() = VkPipelineViewportExclusiveScissorStateCreateInfoNV.npNext(adr)
    set(value) = VkPipelineViewportExclusiveScissorStateCreateInfoNV.npNext(adr, value)
inline var VkPipelineViewportExclusiveScissorStateCreateInfoNV.exclusiveScissorCount: Int
    get() = VkPipelineViewportExclusiveScissorStateCreateInfoNV.nexclusiveScissorCount(adr)
    @Deprecated("this will be set automatically")
    set(value) = VkPipelineViewportExclusiveScissorStateCreateInfoNV.nexclusiveScissorCount(adr, value)
inline var VkPipelineViewportExclusiveScissorStateCreateInfoNV.exclusiveScissors: VkRect2D.Buffer?
    get() = VkPipelineViewportExclusiveScissorStateCreateInfoNV.npExclusiveScissors(adr)
    set(value) = VkPipelineViewportExclusiveScissorStateCreateInfoNV.npExclusiveScissors(adr, value)


inline var VkPhysicalDeviceExclusiveScissorFeaturesNV.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceExclusiveScissorFeaturesNV.nsType(adr))
    set(value) = VkPhysicalDeviceExclusiveScissorFeaturesNV.nsType(adr, value.i)
inline var VkPhysicalDeviceExclusiveScissorFeaturesNV.next: Ptr
    get() = VkPhysicalDeviceExclusiveScissorFeaturesNV.npNext(adr)
    set(value) = VkPhysicalDeviceExclusiveScissorFeaturesNV.npNext(adr, value)
inline var VkPhysicalDeviceExclusiveScissorFeaturesNV.exclusiveScissor: Boolean
    get() = VkPhysicalDeviceExclusiveScissorFeaturesNV.nexclusiveScissor(adr).bool
    set(value) = VkPhysicalDeviceExclusiveScissorFeaturesNV.nexclusiveScissor(adr, value.i)


inline var VkQueueFamilyCheckpointPropertiesNV.type: VkStructureType
    get() = VkStructureType(VkQueueFamilyCheckpointPropertiesNV.nsType(adr))
    set(value) = VkQueueFamilyCheckpointPropertiesNV.nsType(adr, value.i)
inline var VkQueueFamilyCheckpointPropertiesNV.next: Ptr
    get() = VkQueueFamilyCheckpointPropertiesNV.npNext(adr)
    set(value) = VkQueueFamilyCheckpointPropertiesNV.npNext(adr, value)
inline val VkQueueFamilyCheckpointPropertiesNV.checkpointExecutionStageMask: VkPipelineStageFlags
    get() = VkQueueFamilyCheckpointPropertiesNV.ncheckpointExecutionStageMask(adr)


inline var VkCheckpointDataNV.type: VkStructureType
    get() = VkStructureType(VkCheckpointDataNV.nsType(adr))
    set(value) = VkCheckpointDataNV.nsType(adr, value.i)
inline var VkCheckpointDataNV.next: Ptr
    get() = VkCheckpointDataNV.npNext(adr)
    set(value) = VkCheckpointDataNV.npNext(adr, value)
inline val VkCheckpointDataNV.stage: VkPipelineStage
    get() = VkPipelineStage(VkCheckpointDataNV.nstage(adr))
inline val VkCheckpointDataNV.pCheckpointMarker: Ptr
    get() = VkCheckpointDataNV.npCheckpointMarker(adr)


inline var VkPhysicalDevicePCIBusInfoPropertiesEXT.type: VkStructureType
    get() = VkStructureType(VkPhysicalDevicePCIBusInfoPropertiesEXT.nsType(adr))
    set(value) = VkPhysicalDevicePCIBusInfoPropertiesEXT.nsType(adr, value.i)
inline var VkPhysicalDevicePCIBusInfoPropertiesEXT.next: Ptr
    get() = VkPhysicalDevicePCIBusInfoPropertiesEXT.npNext(adr)
    set(value) = VkPhysicalDevicePCIBusInfoPropertiesEXT.npNext(adr, value)
inline val VkPhysicalDevicePCIBusInfoPropertiesEXT.pciDomain: Int
    get() = VkPhysicalDevicePCIBusInfoPropertiesEXT.npciDomain(adr)
inline val VkPhysicalDevicePCIBusInfoPropertiesEXT.pciBus: Int
    get() = VkPhysicalDevicePCIBusInfoPropertiesEXT.npciBus(adr)
inline val VkPhysicalDevicePCIBusInfoPropertiesEXT.pciDevice: Int
    get() = VkPhysicalDevicePCIBusInfoPropertiesEXT.npciDevice(adr)
inline val VkPhysicalDevicePCIBusInfoPropertiesEXT.pciFunction: Int
    get() = VkPhysicalDevicePCIBusInfoPropertiesEXT.npciFunction(adr)


inline var VkPhysicalDeviceFragmentDensityMapFeaturesEXT.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceFragmentDensityMapFeaturesEXT.nsType(adr))
    set(value) = VkPhysicalDeviceFragmentDensityMapFeaturesEXT.nsType(adr, value.i)
inline var VkPhysicalDeviceFragmentDensityMapFeaturesEXT.next: Ptr
    get() = VkPhysicalDeviceFragmentDensityMapFeaturesEXT.npNext(adr)
    set(value) = VkPhysicalDeviceFragmentDensityMapFeaturesEXT.npNext(adr, value)
inline val VkPhysicalDeviceFragmentDensityMapFeaturesEXT.fragmentDensityMap: Boolean
    get() = VkPhysicalDeviceFragmentDensityMapFeaturesEXT.nfragmentDensityMap(adr).bool
inline val VkPhysicalDeviceFragmentDensityMapFeaturesEXT.fragmentDensityMapDynamic: Boolean
    get() = VkPhysicalDeviceFragmentDensityMapFeaturesEXT.nfragmentDensityMapDynamic(adr).bool
inline val VkPhysicalDeviceFragmentDensityMapFeaturesEXT.fragmentDensityMapNonSubsampledImages: Boolean
    get() = VkPhysicalDeviceFragmentDensityMapFeaturesEXT.nfragmentDensityMapNonSubsampledImages(adr).bool


inline var VkPhysicalDeviceFragmentDensityMapPropertiesEXT.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceFragmentDensityMapPropertiesEXT.nsType(adr))
    set(value) = VkPhysicalDeviceFragmentDensityMapPropertiesEXT.nsType(adr, value.i)
inline var VkPhysicalDeviceFragmentDensityMapPropertiesEXT.next: Ptr
    get() = VkPhysicalDeviceFragmentDensityMapPropertiesEXT.npNext(adr)
    set(value) = VkPhysicalDeviceFragmentDensityMapPropertiesEXT.npNext(adr, value)
inline val VkPhysicalDeviceFragmentDensityMapPropertiesEXT.minFragmentDensityTexelSize: VkExtent2D
    get() = VkPhysicalDeviceFragmentDensityMapPropertiesEXT.nminFragmentDensityTexelSize(adr)
inline val VkPhysicalDeviceFragmentDensityMapPropertiesEXT.maxFragmentDensityTexelSize: VkExtent2D
    get() = VkPhysicalDeviceFragmentDensityMapPropertiesEXT.nmaxFragmentDensityTexelSize(adr)
inline val VkPhysicalDeviceFragmentDensityMapPropertiesEXT.fragmentDensityInvocations: Boolean
    get() = VkPhysicalDeviceFragmentDensityMapPropertiesEXT.nfragmentDensityInvocations(adr).bool


inline var VkRenderPassFragmentDensityMapCreateInfoEXT.type: VkStructureType
    get() = VkStructureType(VkRenderPassFragmentDensityMapCreateInfoEXT.nsType(adr))
    set(value) = VkRenderPassFragmentDensityMapCreateInfoEXT.nsType(adr, value.i)
inline var VkRenderPassFragmentDensityMapCreateInfoEXT.next: Ptr
    get() = VkRenderPassFragmentDensityMapCreateInfoEXT.npNext(adr)
    set(value) = VkRenderPassFragmentDensityMapCreateInfoEXT.npNext(adr, value)
inline var VkRenderPassFragmentDensityMapCreateInfoEXT.fragmentDensityMapAttachment: VkAttachmentReference
    get() = VkRenderPassFragmentDensityMapCreateInfoEXT.nfragmentDensityMapAttachment(adr)
    set(value) = VkRenderPassFragmentDensityMapCreateInfoEXT.nfragmentDensityMapAttachment(adr, value)


inline var VkPhysicalDeviceScalarBlockLayoutFeaturesEXT.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceScalarBlockLayoutFeaturesEXT.nsType(adr))
    set(value) = VkPhysicalDeviceScalarBlockLayoutFeaturesEXT.nsType(adr, value.i)
inline var VkPhysicalDeviceScalarBlockLayoutFeaturesEXT.next: Ptr
    get() = VkPhysicalDeviceScalarBlockLayoutFeaturesEXT.npNext(adr)
    set(value) = VkPhysicalDeviceScalarBlockLayoutFeaturesEXT.npNext(adr, value)
inline var VkPhysicalDeviceScalarBlockLayoutFeaturesEXT.scalarBlockLayout: Boolean
    get() = VkPhysicalDeviceScalarBlockLayoutFeaturesEXT.nscalarBlockLayout(adr).bool
    set(value) = VkPhysicalDeviceScalarBlockLayoutFeaturesEXT.nscalarBlockLayout(adr, value.i)


inline var VkPhysicalDeviceMemoryBudgetPropertiesEXT.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceMemoryBudgetPropertiesEXT.nsType(adr))
    set(value) = VkPhysicalDeviceMemoryBudgetPropertiesEXT.nsType(adr, value.i)
inline var VkPhysicalDeviceMemoryBudgetPropertiesEXT.next: Ptr
    get() = VkPhysicalDeviceMemoryBudgetPropertiesEXT.npNext(adr)
    set(value) = VkPhysicalDeviceMemoryBudgetPropertiesEXT.npNext(adr, value)
inline val VkPhysicalDeviceMemoryBudgetPropertiesEXT.heapBudget: VkDeviceSize_Buffer
    get() = VkDeviceSize_Buffer(VkPhysicalDeviceMemoryBudgetPropertiesEXT.nheapBudget(adr))
inline val VkPhysicalDeviceMemoryBudgetPropertiesEXT.heapUsage: VkDeviceSize_Buffer
    get() = VkDeviceSize_Buffer(VkPhysicalDeviceMemoryBudgetPropertiesEXT.nheapUsage(adr))


inline var VkPhysicalDeviceMemoryPriorityFeaturesEXT.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceMemoryPriorityFeaturesEXT.nsType(adr))
    set(value) = VkPhysicalDeviceMemoryPriorityFeaturesEXT.nsType(adr, value.i)
inline var VkPhysicalDeviceMemoryPriorityFeaturesEXT.next: Ptr
    get() = VkPhysicalDeviceMemoryPriorityFeaturesEXT.npNext(adr)
    set(value) = VkPhysicalDeviceMemoryPriorityFeaturesEXT.npNext(adr, value)
inline var VkPhysicalDeviceMemoryPriorityFeaturesEXT.memoryPriority: Boolean
    get() = VkPhysicalDeviceMemoryPriorityFeaturesEXT.nmemoryPriority(adr).bool
    set(value) = VkPhysicalDeviceMemoryPriorityFeaturesEXT.nmemoryPriority(adr, value.i)


inline var VkMemoryPriorityAllocateInfoEXT.type: VkStructureType
    get() = VkStructureType(VkMemoryPriorityAllocateInfoEXT.nsType(adr))
    set(value) = VkMemoryPriorityAllocateInfoEXT.nsType(adr, value.i)
inline var VkMemoryPriorityAllocateInfoEXT.next: Ptr
    get() = VkMemoryPriorityAllocateInfoEXT.npNext(adr)
    set(value) = VkMemoryPriorityAllocateInfoEXT.npNext(adr, value)
inline var VkMemoryPriorityAllocateInfoEXT.priority: Float
    get() = VkMemoryPriorityAllocateInfoEXT.npriority(adr)
    set(value) = VkMemoryPriorityAllocateInfoEXT.npriority(adr, value)


inline var VkPhysicalDeviceDedicatedAllocationImageAliasingFeaturesNV.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceDedicatedAllocationImageAliasingFeaturesNV.nsType(adr))
    set(value) = VkPhysicalDeviceDedicatedAllocationImageAliasingFeaturesNV.nsType(adr, value.i)
inline var VkPhysicalDeviceDedicatedAllocationImageAliasingFeaturesNV.next: Ptr
    get() = VkPhysicalDeviceDedicatedAllocationImageAliasingFeaturesNV.npNext(adr)
    set(value) = VkPhysicalDeviceDedicatedAllocationImageAliasingFeaturesNV.npNext(adr, value)
inline var VkPhysicalDeviceDedicatedAllocationImageAliasingFeaturesNV.dedicatedAllocationImageAliasing: Boolean
    get() = VkPhysicalDeviceDedicatedAllocationImageAliasingFeaturesNV.ndedicatedAllocationImageAliasing(adr).bool
    set(value) = VkPhysicalDeviceDedicatedAllocationImageAliasingFeaturesNV.ndedicatedAllocationImageAliasing(adr, value.i)


inline var VkPhysicalDeviceBufferAddressFeaturesEXT.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceBufferAddressFeaturesEXT.nsType(adr))
    set(value) = VkPhysicalDeviceBufferAddressFeaturesEXT.nsType(adr, value.i)
inline var VkPhysicalDeviceBufferAddressFeaturesEXT.next: Ptr
    get() = VkPhysicalDeviceBufferAddressFeaturesEXT.npNext(adr)
    set(value) = VkPhysicalDeviceBufferAddressFeaturesEXT.npNext(adr, value)
inline var VkPhysicalDeviceBufferAddressFeaturesEXT.bufferDeviceAddress: Boolean
    get() = VkPhysicalDeviceBufferAddressFeaturesEXT.nbufferDeviceAddress(adr).bool
    set(value) = VkPhysicalDeviceBufferAddressFeaturesEXT.nbufferDeviceAddress(adr, value.i)
inline var VkPhysicalDeviceBufferAddressFeaturesEXT.bufferDeviceAddressCaptureReplay: Boolean
    get() = VkPhysicalDeviceBufferAddressFeaturesEXT.nbufferDeviceAddressCaptureReplay(adr).bool
    set(value) = VkPhysicalDeviceBufferAddressFeaturesEXT.nbufferDeviceAddressCaptureReplay(adr, value.i)
inline var VkPhysicalDeviceBufferAddressFeaturesEXT.bufferDeviceAddressMultiDevice: Boolean
    get() = VkPhysicalDeviceBufferAddressFeaturesEXT.nbufferDeviceAddressMultiDevice(adr).bool
    set(value) = VkPhysicalDeviceBufferAddressFeaturesEXT.nbufferDeviceAddressMultiDevice(adr, value.i)


inline var VkBufferDeviceAddressInfoEXT.type: VkStructureType
    get() = VkStructureType(VkBufferDeviceAddressInfoEXT.nsType(adr))
    set(value) = VkBufferDeviceAddressInfoEXT.nsType(adr, value.i)
inline var VkBufferDeviceAddressInfoEXT.next: Ptr
    get() = VkBufferDeviceAddressInfoEXT.npNext(adr)
    set(value) = VkBufferDeviceAddressInfoEXT.npNext(adr, value)
inline var VkBufferDeviceAddressInfoEXT.buffer: VkBuffer
    get() = VkBuffer(VkBufferDeviceAddressInfoEXT.nbuffer(adr))
    set(value) = VkBufferDeviceAddressInfoEXT.nbuffer(adr, value.L)


inline var VkBufferDeviceAddressCreateInfoEXT.type: VkStructureType
    get() = VkStructureType(VkBufferDeviceAddressCreateInfoEXT.nsType(adr))
    set(value) = VkBufferDeviceAddressCreateInfoEXT.nsType(adr, value.i)
inline var VkBufferDeviceAddressCreateInfoEXT.next: Ptr
    get() = VkBufferDeviceAddressCreateInfoEXT.npNext(adr)
    set(value) = VkBufferDeviceAddressCreateInfoEXT.npNext(adr, value)
inline var VkBufferDeviceAddressCreateInfoEXT.deviceAddress: VkDeviceSize
    get() = VkDeviceSize(VkBufferDeviceAddressCreateInfoEXT.ndeviceAddress(adr))
    set(value) = VkBufferDeviceAddressCreateInfoEXT.ndeviceAddress(adr, value.L)


inline var VkImageStencilUsageCreateInfoEXT.type: VkStructureType
    get() = VkStructureType(VkImageStencilUsageCreateInfoEXT.nsType(adr))
    set(value) = VkImageStencilUsageCreateInfoEXT.nsType(adr, value.i)
inline var VkImageStencilUsageCreateInfoEXT.next: Ptr
    get() = VkImageStencilUsageCreateInfoEXT.npNext(adr)
    set(value) = VkImageStencilUsageCreateInfoEXT.npNext(adr, value)
inline var VkImageStencilUsageCreateInfoEXT.stencilUsage: VkImageUsageFlags
    get() = VkImageStencilUsageCreateInfoEXT.nstencilUsage(adr)
    set(value) = VkImageStencilUsageCreateInfoEXT.nstencilUsage(adr, value)


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


inline var VkValidationFeaturesEXT.type: VkStructureType
    get() = VkStructureType(VkValidationFeaturesEXT.nsType(adr))
    set(value) = VkValidationFeaturesEXT.nsType(adr, value.i)
inline var VkValidationFeaturesEXT.next: Ptr
    get() = VkValidationFeaturesEXT.npNext(adr)
    set(value) = VkValidationFeaturesEXT.npNext(adr, value)
inline var VkValidationFeaturesEXT.enabledValidationFeatureCount: VkImageUsageFlags
    get() = VkValidationFeaturesEXT.nenabledValidationFeatureCount(adr)
    @Deprecated("this will be set automatically")
    set(value) = VkValidationFeaturesEXT.nenabledValidationFeatureCount(adr, value)
inline var VkValidationFeaturesEXT.enabledValidationFeatures: VkValidationFeatureEnableEXT_Buffer?
    get() = VkValidationFeaturesEXT.npEnabledValidationFeatures(adr)?.let(::VkValidationFeatureEnableEXT_Buffer)
    set(value) = VkValidationFeaturesEXT.npEnabledValidationFeatures(adr, value?.buffer)
inline var VkValidationFeaturesEXT.disabledValidationFeatureCount: VkImageUsageFlags
    get() = VkValidationFeaturesEXT.ndisabledValidationFeatureCount(adr)
    @Deprecated("this will be set automatically")
    set(value) = VkValidationFeaturesEXT.ndisabledValidationFeatureCount(adr, value)
inline var VkValidationFeaturesEXT.disabledValidationFeatures: VkValidationFeatureEnableEXT_Buffer?
    get() = VkValidationFeaturesEXT.npDisabledValidationFeatures(adr)?.let(::VkValidationFeatureEnableEXT_Buffer)
    set(value) = VkValidationFeaturesEXT.npDisabledValidationFeatures(adr, value?.buffer)


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


inline var VkCooperativeMatrixPropertiesNV.type: VkStructureType
    get() = VkStructureType(VkCooperativeMatrixPropertiesNV.nsType(adr))
    set(value) = VkCooperativeMatrixPropertiesNV.nsType(adr, value.i)
inline var VkCooperativeMatrixPropertiesNV.next: Ptr
    get() = VkCooperativeMatrixPropertiesNV.npNext(adr)
    set(value) = VkCooperativeMatrixPropertiesNV.npNext(adr, value)
inline var VkCooperativeMatrixPropertiesNV.mSize: Int
    get() = VkCooperativeMatrixPropertiesNV.nMSize(adr)
    set(value) = VkCooperativeMatrixPropertiesNV.nMSize(adr, value)
inline var VkCooperativeMatrixPropertiesNV.nSize: Int
    get() = VkCooperativeMatrixPropertiesNV.nNSize(adr)
    set(value) = VkCooperativeMatrixPropertiesNV.nNSize(adr, value)
inline var VkCooperativeMatrixPropertiesNV.kSize: Int
    get() = VkCooperativeMatrixPropertiesNV.nKSize(adr)
    set(value) = VkCooperativeMatrixPropertiesNV.nKSize(adr, value)
inline var VkCooperativeMatrixPropertiesNV.aType: VkComponentTypeNV
    get() = VkComponentTypeNV(VkCooperativeMatrixPropertiesNV.nAType(adr))
    set(value) = VkCooperativeMatrixPropertiesNV.nAType(adr, value.i)
inline var VkCooperativeMatrixPropertiesNV.bType: VkComponentTypeNV
    get() = VkComponentTypeNV(VkCooperativeMatrixPropertiesNV.nBType(adr))
    set(value) = VkCooperativeMatrixPropertiesNV.nBType(adr, value.i)
inline var VkCooperativeMatrixPropertiesNV.cType: VkComponentTypeNV
    get() = VkComponentTypeNV(VkCooperativeMatrixPropertiesNV.nCType(adr))
    set(value) = VkCooperativeMatrixPropertiesNV.nCType(adr, value.i)
inline var VkCooperativeMatrixPropertiesNV.dType: VkComponentTypeNV
    get() = VkComponentTypeNV(VkCooperativeMatrixPropertiesNV.nDType(adr))
    set(value) = VkCooperativeMatrixPropertiesNV.nDType(adr, value.i)
inline var VkCooperativeMatrixPropertiesNV.scope: VkScopeNV
    get() = VkScopeNV(VkCooperativeMatrixPropertiesNV.nscope(adr))
    set(value) = VkCooperativeMatrixPropertiesNV.nscope(adr, value.i)


inline var VkPhysicalDeviceCooperativeMatrixFeaturesNV.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceCooperativeMatrixFeaturesNV.nsType(adr))
    set(value) = VkPhysicalDeviceCooperativeMatrixFeaturesNV.nsType(adr, value.i)
inline var VkPhysicalDeviceCooperativeMatrixFeaturesNV.next: Ptr
    get() = VkPhysicalDeviceCooperativeMatrixFeaturesNV.npNext(adr)
    set(value) = VkPhysicalDeviceCooperativeMatrixFeaturesNV.npNext(adr, value)
inline var VkPhysicalDeviceCooperativeMatrixFeaturesNV.cooperativeMatrix: Boolean
    get() = VkPhysicalDeviceCooperativeMatrixFeaturesNV.ncooperativeMatrix(adr).bool
    set(value) = VkPhysicalDeviceCooperativeMatrixFeaturesNV.ncooperativeMatrix(adr, value.i)
inline var VkPhysicalDeviceCooperativeMatrixFeaturesNV.cooperativeMatrixRobustBufferAccess: Boolean
    get() = VkPhysicalDeviceCooperativeMatrixFeaturesNV.ncooperativeMatrixRobustBufferAccess(adr).bool
    set(value) = VkPhysicalDeviceCooperativeMatrixFeaturesNV.ncooperativeMatrixRobustBufferAccess(adr, value.i)


inline var VkPhysicalDeviceCooperativeMatrixPropertiesNV.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceCooperativeMatrixPropertiesNV.nsType(adr))
    set(value) = VkPhysicalDeviceCooperativeMatrixPropertiesNV.nsType(adr, value.i)
inline var VkPhysicalDeviceCooperativeMatrixPropertiesNV.next: Ptr
    get() = VkPhysicalDeviceCooperativeMatrixPropertiesNV.npNext(adr)
    set(value) = VkPhysicalDeviceCooperativeMatrixPropertiesNV.npNext(adr, value)
inline val VkPhysicalDeviceCooperativeMatrixPropertiesNV.cooperativeMatrixSupportedStages: VkShaderStageFlags
    get() = VkPhysicalDeviceCooperativeMatrixPropertiesNV.ncooperativeMatrixSupportedStages(adr)