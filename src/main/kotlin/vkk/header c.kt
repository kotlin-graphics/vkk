package vkk

import glm_.BYTES
import glm_.bool
import glm_.i
import glm_.vec2.Vec2
import glm_.vec2.Vec2i
import glm_.vec3.Vec3i
import kool.Ptr
import kool.adr
import org.lwjgl.PointerBuffer
import org.lwjgl.system.MemoryStack.stackGet
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.system.Pointer
import org.lwjgl.vulkan.*
import vkk.entities.*
import java.nio.ByteBuffer
import java.nio.FloatBuffer
import java.nio.IntBuffer


inline val VkFormatProperties.linearTilingFeatures: VkFormatFeatureFlags
    get() = VkFormatProperties.nlinearTilingFeatures(adr)
inline val VkFormatProperties.optimalTilingFeatures: VkFormatFeatureFlags
    get() = VkFormatProperties.noptimalTilingFeatures(adr)
inline val VkFormatProperties.bufferFeatures: VkFormatFeatureFlags
    get() = VkFormatProperties.nbufferFeatures(adr)


inline var VkExtent3D.width: Int
    get() = VkExtent3D.nwidth(adr)
    set(value) = VkExtent3D.nwidth(adr, value)
inline var VkExtent3D.height: Int
    get() = VkExtent3D.nheight(adr)
    set(value) = VkExtent3D.nheight(adr, value)
inline var VkExtent3D.depth: Int
    get() = VkExtent3D.ndepth(adr)
    set(value) = VkExtent3D.ndepth(adr, value)

fun VkExtent3D.size(x: Int, y: Int, z: Int) {
    width = x
    height = y
    depth = z
}

inline var VkExtent3D.size: Vec3i
    get() = Vec3i(width, height, depth)
    set(value) {
        width = value.x
        height = value.y
        depth = value.z
    }


inline val VkImageFormatProperties.maxExtent: VkExtent3D
    get() = VkImageFormatProperties.nmaxExtent(adr)
inline val VkImageFormatProperties.maxMipLevels: Int
    get() = VkImageFormatProperties.nmaxMipLevels(adr)
inline val VkImageFormatProperties.maxArrayLayers: Int
    get() = VkImageFormatProperties.nmaxArrayLayers(adr)
inline val VkImageFormatProperties.sampleCounts: VkSampleCountFlags
    get() = VkImageFormatProperties.nsampleCounts(adr)
inline val VkImageFormatProperties.maxResourceSize: VkDeviceSize
    get() = VkDeviceSize(VkImageFormatProperties.nmaxResourceSize(adr))


inline val VkPhysicalDeviceLimits.maxImageDimension1D: Int
    get() = VkPhysicalDeviceLimits.nmaxImageDimension1D(adr)
inline val VkPhysicalDeviceLimits.maxImageDimension2D: Int
    get() = VkPhysicalDeviceLimits.nmaxImageDimension2D(adr)
inline val VkPhysicalDeviceLimits.maxImageDimension3D: Int
    get() = VkPhysicalDeviceLimits.nmaxImageDimension3D(adr)
inline val VkPhysicalDeviceLimits.maxImageDimensionCube: Int
    get() = VkPhysicalDeviceLimits.nmaxImageDimensionCube(adr)
inline val VkPhysicalDeviceLimits.maxImageArrayLayers: Int
    get() = VkPhysicalDeviceLimits.nmaxImageArrayLayers(adr)
inline val VkPhysicalDeviceLimits.maxTexelBufferElements: Int
    get() = VkPhysicalDeviceLimits.nmaxTexelBufferElements(adr)
inline val VkPhysicalDeviceLimits.maxUniformBufferRange: Int
    get() = VkPhysicalDeviceLimits.nmaxUniformBufferRange(adr)
inline val VkPhysicalDeviceLimits.maxStorageBufferRange: Int
    get() = VkPhysicalDeviceLimits.nmaxStorageBufferRange(adr)
inline val VkPhysicalDeviceLimits.maxPushConstantsSize: Int
    get() = VkPhysicalDeviceLimits.nmaxPushConstantsSize(adr)
inline val VkPhysicalDeviceLimits.maxMemoryAllocationCount: Int
    get() = VkPhysicalDeviceLimits.nmaxMemoryAllocationCount(adr)
inline val VkPhysicalDeviceLimits.maxSamplerAllocationCount: Int
    get() = VkPhysicalDeviceLimits.nmaxSamplerAllocationCount(adr)
inline val VkPhysicalDeviceLimits.bufferImageGranularity: VkDeviceSize
    get() = VkDeviceSize(VkPhysicalDeviceLimits.nbufferImageGranularity(adr))
inline val VkPhysicalDeviceLimits.sparseAddressSpaceSize: VkDeviceSize
    get() = VkDeviceSize(VkPhysicalDeviceLimits.nsparseAddressSpaceSize(adr))
inline val VkPhysicalDeviceLimits.maxBoundDescriptorSets: Int
    get() = VkPhysicalDeviceLimits.nmaxBoundDescriptorSets(adr)
inline val VkPhysicalDeviceLimits.maxPerStageDescriptorSamplers: Int
    get() = VkPhysicalDeviceLimits.nmaxPerStageDescriptorSamplers(adr)
inline val VkPhysicalDeviceLimits.maxPerStageDescriptorUniformBuffers: Int
    get() = VkPhysicalDeviceLimits.nmaxPerStageDescriptorUniformBuffers(adr)
inline val VkPhysicalDeviceLimits.maxPerStageDescriptorStorageBuffers: Int
    get() = VkPhysicalDeviceLimits.nmaxPerStageDescriptorStorageBuffers(adr)
inline val VkPhysicalDeviceLimits.maxPerStageDescriptorSampledImages: Int
    get() = VkPhysicalDeviceLimits.nmaxPerStageDescriptorSampledImages(adr)
inline val VkPhysicalDeviceLimits.maxPerStageDescriptorStorageImages: Int
    get() = VkPhysicalDeviceLimits.nmaxPerStageDescriptorStorageImages(adr)
inline val VkPhysicalDeviceLimits.maxPerStageDescriptorInputAttachments: Int
    get() = VkPhysicalDeviceLimits.nmaxPerStageDescriptorInputAttachments(adr)
inline val VkPhysicalDeviceLimits.maxPerStageResources: Int
    get() = VkPhysicalDeviceLimits.nmaxPerStageResources(adr)
inline val VkPhysicalDeviceLimits.maxDescriptorSetSamplers: Int
    get() = VkPhysicalDeviceLimits.nmaxDescriptorSetSamplers(adr)
inline val VkPhysicalDeviceLimits.maxDescriptorSetUniformBuffers: Int
    get() = VkPhysicalDeviceLimits.nmaxDescriptorSetUniformBuffers(adr)
inline val VkPhysicalDeviceLimits.maxDescriptorSetUniformBuffersDynamic: Int
    get() = VkPhysicalDeviceLimits.nmaxDescriptorSetUniformBuffersDynamic(adr)
inline val VkPhysicalDeviceLimits.maxDescriptorSetStorageBuffers: Int
    get() = VkPhysicalDeviceLimits.nmaxDescriptorSetStorageBuffers(adr)
inline val VkPhysicalDeviceLimits.maxDescriptorSetStorageBuffersDynamic: Int
    get() = VkPhysicalDeviceLimits.nmaxDescriptorSetStorageBuffersDynamic(adr)
inline val VkPhysicalDeviceLimits.maxDescriptorSetSampledImages: Int
    get() = VkPhysicalDeviceLimits.nmaxDescriptorSetSampledImages(adr)
inline val VkPhysicalDeviceLimits.maxDescriptorSetStorageImages: Int
    get() = VkPhysicalDeviceLimits.nmaxDescriptorSetStorageImages(adr)
inline val VkPhysicalDeviceLimits.maxDescriptorSetInputAttachments: Int
    get() = VkPhysicalDeviceLimits.nmaxDescriptorSetInputAttachments(adr)
inline val VkPhysicalDeviceLimits.maxVertexInputAttributes: Int
    get() = VkPhysicalDeviceLimits.nmaxVertexInputAttributes(adr)
inline val VkPhysicalDeviceLimits.maxVertexInputBindings: Int
    get() = VkPhysicalDeviceLimits.nmaxVertexInputBindings(adr)
inline val VkPhysicalDeviceLimits.maxVertexInputAttributeOffset: Int
    get() = VkPhysicalDeviceLimits.nmaxVertexInputAttributeOffset(adr)
inline val VkPhysicalDeviceLimits.maxVertexInputBindingStride: Int
    get() = VkPhysicalDeviceLimits.nmaxVertexInputBindingStride(adr)
inline val VkPhysicalDeviceLimits.maxVertexOutputComponents: Int
    get() = VkPhysicalDeviceLimits.nmaxVertexOutputComponents(adr)
inline val VkPhysicalDeviceLimits.maxTessellationGenerationLevel: Int
    get() = VkPhysicalDeviceLimits.nmaxTessellationGenerationLevel(adr)
inline val VkPhysicalDeviceLimits.maxTessellationPatchSize: Int
    get() = VkPhysicalDeviceLimits.nmaxTessellationPatchSize(adr)
inline val VkPhysicalDeviceLimits.maxTessellationControlPerVertexInputComponents: Int
    get() = VkPhysicalDeviceLimits.nmaxTessellationControlPerVertexInputComponents(adr)
inline val VkPhysicalDeviceLimits.maxTessellationControlPerVertexOutputComponents: Int
    get() = VkPhysicalDeviceLimits.nmaxTessellationControlPerVertexOutputComponents(adr)
inline val VkPhysicalDeviceLimits.maxTessellationControlPerPatchOutputComponents: Int
    get() = VkPhysicalDeviceLimits.nmaxTessellationControlPerPatchOutputComponents(adr)
inline val VkPhysicalDeviceLimits.maxTessellationControlTotalOutputComponents: Int
    get() = VkPhysicalDeviceLimits.nmaxTessellationControlTotalOutputComponents(adr)
inline val VkPhysicalDeviceLimits.maxTessellationEvaluationInputComponents: Int
    get() = VkPhysicalDeviceLimits.nmaxTessellationEvaluationInputComponents(adr)
inline val VkPhysicalDeviceLimits.maxTessellationEvaluationOutputComponents: Int
    get() = VkPhysicalDeviceLimits.nmaxTessellationEvaluationOutputComponents(adr)
inline val VkPhysicalDeviceLimits.maxGeometryShaderInvocations: Int
    get() = VkPhysicalDeviceLimits.nmaxGeometryShaderInvocations(adr)
inline val VkPhysicalDeviceLimits.maxGeometryInputComponents: Int
    get() = VkPhysicalDeviceLimits.nmaxGeometryInputComponents(adr)
inline val VkPhysicalDeviceLimits.maxGeometryOutputComponents: Int
    get() = VkPhysicalDeviceLimits.nmaxGeometryOutputComponents(adr)
inline val VkPhysicalDeviceLimits.maxGeometryOutputVertices: Int
    get() = VkPhysicalDeviceLimits.nmaxGeometryOutputVertices(adr)
inline val VkPhysicalDeviceLimits.maxGeometryTotalOutputComponents: Int
    get() = VkPhysicalDeviceLimits.nmaxGeometryTotalOutputComponents(adr)
inline val VkPhysicalDeviceLimits.maxFragmentInputComponents: Int
    get() = VkPhysicalDeviceLimits.nmaxFragmentInputComponents(adr)
inline val VkPhysicalDeviceLimits.maxFragmentOutputAttachments: Int
    get() = VkPhysicalDeviceLimits.nmaxFragmentOutputAttachments(adr)
inline val VkPhysicalDeviceLimits.maxFragmentDualSrcAttachments: Int
    get() = VkPhysicalDeviceLimits.nmaxFragmentDualSrcAttachments(adr)
inline val VkPhysicalDeviceLimits.maxFragmentCombinedOutputResources: Int
    get() = VkPhysicalDeviceLimits.nmaxFragmentCombinedOutputResources(adr)
inline val VkPhysicalDeviceLimits.maxComputeSharedMemorySize: Int
    get() = VkPhysicalDeviceLimits.nmaxComputeSharedMemorySize(adr)
inline val VkPhysicalDeviceLimits.maxComputeWorkGroupCount: Vec3i
    get() = Vec3i { VkPhysicalDeviceLimits.nmaxComputeWorkGroupCount(adr, it) }
inline val VkPhysicalDeviceLimits.maxComputeWorkGroupInvocations: Int
    get() = VkPhysicalDeviceLimits.nmaxComputeWorkGroupInvocations(adr)
inline val VkPhysicalDeviceLimits.maxComputeWorkGroupSize: Vec3i
    get() = Vec3i { VkPhysicalDeviceLimits.nmaxComputeWorkGroupSize(adr, it) }
inline val VkPhysicalDeviceLimits.subPixelPrecisionBits: Int
    get() = VkPhysicalDeviceLimits.nsubPixelPrecisionBits(adr)
inline val VkPhysicalDeviceLimits.subTexelPrecisionBits: Int
    get() = VkPhysicalDeviceLimits.nsubTexelPrecisionBits(adr)
inline val VkPhysicalDeviceLimits.mipmapPrecisionBits: Int
    get() = VkPhysicalDeviceLimits.nmipmapPrecisionBits(adr)
inline val VkPhysicalDeviceLimits.maxDrawIndexedIndexValue: Int
    get() = VkPhysicalDeviceLimits.nmaxDrawIndexedIndexValue(adr)
inline val VkPhysicalDeviceLimits.maxDrawIndirectCount: Int
    get() = VkPhysicalDeviceLimits.nmaxDrawIndirectCount(adr)
inline val VkPhysicalDeviceLimits.maxSamplerLodBias: Float
    get() = VkPhysicalDeviceLimits.nmaxSamplerLodBias(adr)
inline val VkPhysicalDeviceLimits.maxSamplerAnisotropy: Float
    get() = VkPhysicalDeviceLimits.nmaxSamplerAnisotropy(adr)
inline val VkPhysicalDeviceLimits.maxViewports: Int
    get() = VkPhysicalDeviceLimits.nmaxViewports(adr)
inline val VkPhysicalDeviceLimits.maxViewportDimensions: Vec2i
    get() = Vec2i { VkPhysicalDeviceLimits.nmaxViewportDimensions(adr, it) }
inline val VkPhysicalDeviceLimits.viewportBoundsRange: Vec2
    get() = Vec2 { VkPhysicalDeviceLimits.nviewportBoundsRange(adr, it) }
inline val VkPhysicalDeviceLimits.viewportSubPixelBits: Int
    get() = VkPhysicalDeviceLimits.nviewportSubPixelBits(adr)
inline val VkPhysicalDeviceLimits.minMemoryMapAlignment: Long
    get() = VkPhysicalDeviceLimits.nminMemoryMapAlignment(adr)
inline val VkPhysicalDeviceLimits.minTexelBufferOffsetAlignment: VkDeviceSize
    get() = VkDeviceSize(VkPhysicalDeviceLimits.nminTexelBufferOffsetAlignment(adr))
inline val VkPhysicalDeviceLimits.minUniformBufferOffsetAlignment: VkDeviceSize
    get() = VkDeviceSize(VkPhysicalDeviceLimits.nminUniformBufferOffsetAlignment(adr))
inline val VkPhysicalDeviceLimits.minStorageBufferOffsetAlignment: VkDeviceSize
    get() = VkDeviceSize(VkPhysicalDeviceLimits.nminStorageBufferOffsetAlignment(adr))
inline val VkPhysicalDeviceLimits.minTexelOffset: Int
    get() = VkPhysicalDeviceLimits.nminTexelOffset(adr)
inline val VkPhysicalDeviceLimits.maxTexelOffset: Int
    get() = VkPhysicalDeviceLimits.nmaxTexelOffset(adr)
inline val VkPhysicalDeviceLimits.minTexelGatherOffset: Int
    get() = VkPhysicalDeviceLimits.nminTexelGatherOffset(adr)
inline val VkPhysicalDeviceLimits.maxTexelGatherOffset: Int
    get() = VkPhysicalDeviceLimits.nmaxTexelGatherOffset(adr)
inline val VkPhysicalDeviceLimits.minInterpolationOffset: Float
    get() = VkPhysicalDeviceLimits.nminInterpolationOffset(adr)
inline val VkPhysicalDeviceLimits.maxInterpolationOffset: Float
    get() = VkPhysicalDeviceLimits.nmaxInterpolationOffset(adr)
inline val VkPhysicalDeviceLimits.subPixelInterpolationOffsetBits: Int
    get() = VkPhysicalDeviceLimits.nsubPixelInterpolationOffsetBits(adr)
inline val VkPhysicalDeviceLimits.maxFramebufferWidth: Int
    get() = VkPhysicalDeviceLimits.nmaxFramebufferWidth(adr)
inline val VkPhysicalDeviceLimits.maxFramebufferHeight: Int
    get() = VkPhysicalDeviceLimits.nmaxFramebufferHeight(adr)
inline val VkPhysicalDeviceLimits.maxFramebufferLayers: Int
    get() = VkPhysicalDeviceLimits.nmaxFramebufferLayers(adr)
inline val VkPhysicalDeviceLimits.framebufferColorSampleCounts: VkSampleCountFlags
    get() = VkPhysicalDeviceLimits.nframebufferColorSampleCounts(adr)
inline val VkPhysicalDeviceLimits.framebufferDepthSampleCounts: VkSampleCountFlags
    get() = VkPhysicalDeviceLimits.nframebufferDepthSampleCounts(adr)
inline val VkPhysicalDeviceLimits.framebufferStencilSampleCounts: VkSampleCountFlags
    get() = VkPhysicalDeviceLimits.nframebufferStencilSampleCounts(adr)
inline val VkPhysicalDeviceLimits.framebufferNoAttachmentsSampleCounts: VkSampleCountFlags
    get() = VkPhysicalDeviceLimits.nframebufferNoAttachmentsSampleCounts(adr)
inline val VkPhysicalDeviceLimits.maxColorAttachments: Int
    get() = VkPhysicalDeviceLimits.nmaxColorAttachments(adr)
inline val VkPhysicalDeviceLimits.sampledImageColorSampleCounts: VkSampleCountFlags
    get() = VkPhysicalDeviceLimits.nsampledImageColorSampleCounts(adr)
inline val VkPhysicalDeviceLimits.sampledImageIntegerSampleCounts: VkSampleCountFlags
    get() = VkPhysicalDeviceLimits.nsampledImageIntegerSampleCounts(adr)
inline val VkPhysicalDeviceLimits.sampledImageDepthSampleCounts: VkSampleCountFlags
    get() = VkPhysicalDeviceLimits.nsampledImageDepthSampleCounts(adr)
inline val VkPhysicalDeviceLimits.sampledImageStencilSampleCounts: VkSampleCountFlags
    get() = VkPhysicalDeviceLimits.nsampledImageStencilSampleCounts(adr)
inline val VkPhysicalDeviceLimits.storageImageSampleCounts: VkSampleCountFlags
    get() = VkPhysicalDeviceLimits.nstorageImageSampleCounts(adr)
inline val VkPhysicalDeviceLimits.maxSampleMaskWords: Int
    get() = VkPhysicalDeviceLimits.nmaxSampleMaskWords(adr)
inline val VkPhysicalDeviceLimits.timestampComputeAndGraphics: Boolean
    get() = VkPhysicalDeviceLimits.ntimestampComputeAndGraphics(adr).bool
inline val VkPhysicalDeviceLimits.timestampPeriod: Float
    get() = VkPhysicalDeviceLimits.ntimestampPeriod(adr)
inline val VkPhysicalDeviceLimits.maxClipDistances: Int
    get() = VkPhysicalDeviceLimits.nmaxClipDistances(adr)
inline val VkPhysicalDeviceLimits.maxCullDistances: Int
    get() = VkPhysicalDeviceLimits.nmaxCullDistances(adr)
inline val VkPhysicalDeviceLimits.maxCombinedClipAndCullDistances: Int
    get() = VkPhysicalDeviceLimits.nmaxCombinedClipAndCullDistances(adr)
inline val VkPhysicalDeviceLimits.discreteQueuePriorities: Int
    get() = VkPhysicalDeviceLimits.ndiscreteQueuePriorities(adr)
inline val VkPhysicalDeviceLimits.pointSizeRange: Vec2
    get() = Vec2 { VkPhysicalDeviceLimits.npointSizeRange(adr, it) }
inline val VkPhysicalDeviceLimits.lineWidthRange: Vec2
    get() = Vec2 { VkPhysicalDeviceLimits.nlineWidthRange(adr, it) }
inline val VkPhysicalDeviceLimits.pointSizeGranularity: Float
    get() = VkPhysicalDeviceLimits.npointSizeGranularity(adr)
inline val VkPhysicalDeviceLimits.lineWidthGranularity: Float
    get() = VkPhysicalDeviceLimits.nlineWidthGranularity(adr)
inline val VkPhysicalDeviceLimits.strictLines: Boolean
    get() = VkPhysicalDeviceLimits.nstrictLines(adr).bool
inline val VkPhysicalDeviceLimits.standardSampleLocations: Boolean
    get() = VkPhysicalDeviceLimits.nstandardSampleLocations(adr).bool
inline val VkPhysicalDeviceLimits.optimalBufferCopyOffsetAlignment: VkDeviceSize
    get() = VkDeviceSize(VkPhysicalDeviceLimits.noptimalBufferCopyOffsetAlignment(adr))
inline val VkPhysicalDeviceLimits.optimalBufferCopyRowPitchAlignment: VkDeviceSize
    get() = VkDeviceSize(VkPhysicalDeviceLimits.noptimalBufferCopyRowPitchAlignment(adr))
inline val VkPhysicalDeviceLimits.nonCoherentAtomSize: VkDeviceSize
    get() = VkDeviceSize(VkPhysicalDeviceLimits.nnonCoherentAtomSize(adr))


inline val VkPhysicalDeviceSparseProperties.residencyStandard2DBlockShape: Boolean
    get() = VkPhysicalDeviceSparseProperties.nresidencyStandard2DBlockShape(adr).bool
inline val VkPhysicalDeviceSparseProperties.residencyStandard2DMultisampleBlockShape: Boolean
    get() = VkPhysicalDeviceSparseProperties.nresidencyStandard2DMultisampleBlockShape(adr).bool
inline val VkPhysicalDeviceSparseProperties.residencyStandard3DBlockShape: Boolean
    get() = VkPhysicalDeviceSparseProperties.nresidencyStandard3DBlockShape(adr).bool
inline val VkPhysicalDeviceSparseProperties.residencyAlignedMipSize: Boolean
    get() = VkPhysicalDeviceSparseProperties.nresidencyAlignedMipSize(adr).bool
inline val VkPhysicalDeviceSparseProperties.residencyNonResidentStrict: Boolean
    get() = VkPhysicalDeviceSparseProperties.nresidencyNonResidentStrict(adr).bool


inline val VkPhysicalDeviceProperties.apiVersion: Int
    get() = VkPhysicalDeviceProperties.napiVersion(adr)
inline val VkPhysicalDeviceProperties.driverVersion: Int
    get() = VkPhysicalDeviceProperties.ndriverVersion(adr)
inline val VkPhysicalDeviceProperties.vendorID: Int
    get() = VkPhysicalDeviceProperties.nvendorID(adr)
inline val VkPhysicalDeviceProperties.deviceID: Int
    get() = VkPhysicalDeviceProperties.ndeviceID(adr)
inline val VkPhysicalDeviceProperties.deviceType: VkPhysicalDeviceType
    get() = VkPhysicalDeviceType(VkPhysicalDeviceProperties.ndeviceType(adr))
inline val VkPhysicalDeviceProperties.deviceName: String
    get() = VkPhysicalDeviceProperties.ndeviceNameString(adr)
inline val VkPhysicalDeviceProperties.pipelineCacheUUID: ByteBuffer
    get() = VkPhysicalDeviceProperties.npipelineCacheUUID(adr)
inline val VkPhysicalDeviceProperties.limits: VkPhysicalDeviceLimits
    get() = VkPhysicalDeviceProperties.nlimits(adr)
inline val VkPhysicalDeviceProperties.sparseProperties: VkPhysicalDeviceSparseProperties
    get() = VkPhysicalDeviceProperties.nsparseProperties(adr)
/** JVM custom */
inline val VkPhysicalDeviceProperties.apiVersionString: String
    get() = _decode(apiVersion)
inline val VkPhysicalDeviceProperties.driverVersionString: String
    get() = _decode(driverVersion)

enum class VkVendor { AMD, Nvidia, Intel, Unknown }

inline val VkPhysicalDeviceProperties.vendor: VkVendor
    get() = when (vendorID) {
        0x1002 -> VkVendor.AMD
        0x10DE -> VkVendor.Nvidia
        0x8086 -> VkVendor.Intel
        else -> VkVendor.Unknown
    }

fun _decode(int: Int) = "${int and 0xFFC00000.i shr 22}.${int and 0x003FF000 shr 12}.${int and 0x00000FFF}"


inline val VkQueueFamilyProperties.queueFlags: VkQueueFlags
    get() = VkQueueFamilyProperties.nqueueFlags(adr)
inline val VkQueueFamilyProperties.queueCount: Int
    get() = VkQueueFamilyProperties.nqueueCount(adr)
inline val VkQueueFamilyProperties.timestampValidBits: Int
    get() = VkQueueFamilyProperties.ntimestampValidBits(adr)
inline val VkQueueFamilyProperties.minImageTransferGranularity: VkExtent3D
    get() = VkQueueFamilyProperties.nminImageTransferGranularity(adr)


inline val VkMemoryType.propertyFlags: VkMemoryPropertyFlags
    get() = VkMemoryType.npropertyFlags(adr)
inline val VkMemoryType.heapIndex: Int
    get() = VkMemoryType.nheapIndex(adr)


inline val VkMemoryHeap.size: VkDeviceSize
    get() = VkDeviceSize(VkMemoryHeap.nsize(adr))
inline val VkMemoryHeap.flags: VkMemoryHeapFlags
    get() = VkMemoryHeap.nflags(adr)


inline val VkPhysicalDeviceMemoryProperties.memoryTypeCount: Int
    get() = VkPhysicalDeviceMemoryProperties.nmemoryTypeCount(adr)
inline val VkPhysicalDeviceMemoryProperties.memoryTypes: VkMemoryType.Buffer
    get() = VkPhysicalDeviceMemoryProperties.nmemoryTypes(adr)
inline val VkPhysicalDeviceMemoryProperties.memoryHeapCount: Int
    get() = VkPhysicalDeviceMemoryProperties.nmemoryHeapCount(adr)
inline val VkPhysicalDeviceMemoryProperties.memoryHeaps: VkMemoryHeap.Buffer
    get() = VkPhysicalDeviceMemoryProperties.nmemoryHeaps(adr)


inline var VkDeviceQueueCreateInfo.type: VkStructureType
    get() = VkStructureType(VkDeviceQueueCreateInfo.nsType(adr))
    set(value) = VkDeviceQueueCreateInfo.nsType(adr, value.i)
inline var VkDeviceQueueCreateInfo.next: Ptr
    get() = VkDeviceQueueCreateInfo.npNext(adr)
    set(value) = VkDeviceQueueCreateInfo.npNext(adr, value)
inline var VkDeviceQueueCreateInfo.flag: VkDeviceQueueCreate
    get() = throw Exception("invalid")
    set(value) = VkDeviceQueueCreateInfo.nflags(adr, value.i)
inline var VkDeviceQueueCreateInfo.flags: VkDeviceQueueCreateFlags
    get() = VkDeviceQueueCreateInfo.nflags(adr)
    set(value) = VkDeviceQueueCreateInfo.nflags(adr, value)
inline var VkDeviceQueueCreateInfo.queueFamilyIndex: Int
    get() = VkDeviceQueueCreateInfo.nqueueFamilyIndex(adr)
    set(value) = VkDeviceQueueCreateInfo.nqueueFamilyIndex(adr, value)
@Deprecated("this will be set automatically")
inline var VkDeviceQueueCreateInfo.queueCount: Int
    get() = VkDeviceQueueCreateInfo.nqueueCount(adr)
    set(value) = VkDeviceQueueCreateInfo.nqueueCount(adr, value)
inline var VkDeviceQueueCreateInfo.queuePriorities: FloatBuffer
    get() = VkDeviceQueueCreateInfo.npQueuePriorities(adr)
    set(value) = VkDeviceQueueCreateInfo.npQueuePriorities(adr, value)
/** JVM custom */
inline var VkDeviceQueueCreateInfo.queuePriority: Float
    get() = VkDeviceQueueCreateInfo.npQueuePriorities(adr)[0]
    set(value) {
        val adr = stackGet().nmalloc(4, Float.BYTES)
        memPutFloat(adr, value)
        memPutAddress(adr + VkDeviceQueueCreateInfo.PQUEUEPRIORITIES, adr)
        queueCount = 1
    }


inline var VkDeviceCreateInfo.type: VkStructureType
    get() = VkStructureType(VkDeviceCreateInfo.nsType(adr))
    set(value) = VkDeviceCreateInfo.nsType(adr, value.i)
inline var VkDeviceCreateInfo.next: Ptr
    get() = VkDeviceCreateInfo.npNext(adr)
    set(value) = VkDeviceCreateInfo.npNext(adr, value)
inline var VkDeviceCreateInfo.flags: VkDeviceCreateFlags
    get() = VkDeviceCreateInfo.nflags(adr)
    set(value) = VkDeviceCreateInfo.nflags(adr, value)
@Deprecated("this will be set automatically")
inline var VkDeviceCreateInfo.queueCreateInfoCount: Int
    get() = VkDeviceCreateInfo.nqueueCreateInfoCount(adr)
    set(value) = VkDeviceCreateInfo.nqueueCreateInfoCount(adr, value)
inline var VkDeviceCreateInfo.queueCreateInfos: VkDeviceQueueCreateInfo.Buffer
    get() = VkDeviceCreateInfo.npQueueCreateInfos(adr)
    set(value) = VkDeviceCreateInfo.npQueueCreateInfos(adr, value)
/** JVM custom */
inline var VkDeviceCreateInfo.queueCreateInfo: VkDeviceQueueCreateInfo
    get() = VkDeviceCreateInfo.npQueueCreateInfos(adr)[0]
    set(value) {
        memPutAddress(adr + VkDeviceCreateInfo.PQUEUECREATEINFOS, value.adr)
        queueCreateInfoCount = 1
    }
inline var VkDeviceCreateInfo.enabledLayerNames: Collection<String>
    get() = VkDeviceCreateInfo.nppEnabledLayerNames(adr)?.toArrayList() ?: arrayListOf()
    set(value) = VkDeviceCreateInfo.nppEnabledLayerNames(adr, value.toPointerBufferStack())
inline var VkDeviceCreateInfo.enabledExtensionNames: Collection<String>
    get() = VkDeviceCreateInfo.nppEnabledExtensionNames(adr)?.toArrayList() ?: arrayListOf()
    set(value) = VkDeviceCreateInfo.nppEnabledExtensionNames(adr, value.toPointerBufferStack())
inline var VkDeviceCreateInfo.enabledFeatures: VkPhysicalDeviceFeatures?
    get() = VkDeviceCreateInfo.npEnabledFeatures(adr)
    set(value) = VkDeviceCreateInfo.npEnabledFeatures(adr, value)


inline val VkExtensionProperties.extensionName: String
    get() = VkExtensionProperties.nextensionNameString(adr)
inline val VkExtensionProperties.specVersion: Int
    get() = VkExtensionProperties.nspecVersion(adr)


inline val VkLayerProperties.layerName: String
    get() = VkLayerProperties.nlayerNameString(adr)
inline val VkLayerProperties.specVersion: Int
    get() = VkLayerProperties.nspecVersion(adr)
inline val VkLayerProperties.implementationVersion: Int
    get() = VkLayerProperties.nimplementationVersion(adr)
inline val VkLayerProperties.description: String
    get() = VkLayerProperties.ndescriptionString(adr)


inline var VkSubmitInfo.type: VkStructureType
    get() = VkStructureType(VkSubmitInfo.nsType(adr))
    set(value) = VkSubmitInfo.nsType(adr, value.i)
inline var VkSubmitInfo.next: Ptr
    get() = VkSubmitInfo.npNext(adr)
    set(value) = VkSubmitInfo.npNext(adr, value)
inline var VkSubmitInfo.waitSemaphoreCount: Int
    get() = VkSubmitInfo.nwaitSemaphoreCount(adr)
    set(value) = VkSubmitInfo.nwaitSemaphoreCount(adr, value)
inline var VkSubmitInfo.waitSemaphores: VkSemaphore_Buffer?
    get() = VkSubmitInfo.npWaitSemaphores(adr)?.let(::VkSemaphore_Buffer)
    set(value) = VkSubmitInfo.npWaitSemaphores(adr, value?.buffer)
/** JVM custom */
inline var VkSubmitInfo.waitSemaphore: VkSemaphore
    get() = VkSemaphore(VkSubmitInfo.npWaitSemaphores(adr)?.get(0) ?: NULL)
    set(value) {
        val pSemaphore = stackGet().nmalloc(8, Long.BYTES)
        memPutLong(pSemaphore, value.L)
        memPutAddress(adr + VkSubmitInfo.PWAITSEMAPHORES, pSemaphore)
    }
inline var VkSubmitInfo.waitDstStageMask: IntBuffer?
    get() = VkSubmitInfo.npWaitDstStageMask(adr)
    set(value) = VkSubmitInfo.npWaitDstStageMask(adr, value)
@Deprecated("this will be set automatically")
inline var VkSubmitInfo.commandBufferCount: Int
    get() = VkSubmitInfo.ncommandBufferCount(adr)
    set(value) = VkSubmitInfo.ncommandBufferCount(adr, value)
inline var VkSubmitInfo.commandBuffers: PointerBuffer?
    get() = VkSubmitInfo.npCommandBuffers(adr)
    set(value) = VkSubmitInfo.npCommandBuffers(adr, value)
/** JVM custom */
inline var VkSubmitInfo.commandBuffer: VkCommandBuffer?
    get() = null
    set(value) {
        val pCmdBuff = stackGet().nmalloc(Pointer.POINTER_SIZE, Pointer.POINTER_SIZE)
        memPutAddress(pCmdBuff, value?.adr ?: NULL)
        memPutAddress(adr + VkSubmitInfo.PCOMMANDBUFFERS, pCmdBuff)
        VkSubmitInfo.ncommandBufferCount(adr, if (value == null) 0 else 1)
    }
@Deprecated("this will be set automatically")
inline var VkSubmitInfo.signalSemaphoreCount: Int
    get() = VkSubmitInfo.nsignalSemaphoreCount(adr)
    set(value) = VkSubmitInfo.nsignalSemaphoreCount(adr, value)

inline var VkSubmitInfo.signalSemaphores: VkSemaphore_Buffer?
    get() = VkSubmitInfo.npSignalSemaphores(adr)?.let(::VkSemaphore_Buffer)
    set(value) = VkSubmitInfo.npSignalSemaphores(adr, value?.buffer)
/** JVM custom */
inline var VkSubmitInfo.signalSemaphore: VkSemaphore
    get() = VkSemaphore(VkSubmitInfo.npSignalSemaphores(adr)?.get(0) ?: NULL)
    set(value) {
        val pSemaphore = stackGet().nmalloc(8, Long.BYTES)
        memPutLong(pSemaphore, value.L)
        memPutAddress(adr + VkSubmitInfo.PSIGNALSEMAPHORES, pSemaphore)
        signalSemaphoreCount = if (value.isValid) 1 else 0
    }

inline var VkMemoryAllocateInfo.type: VkStructureType
    get() = VkStructureType(VkMemoryAllocateInfo.nsType(adr))
    set(value) = VkMemoryAllocateInfo.nsType(adr, value.i)
inline var VkMemoryAllocateInfo.next: Ptr
    get() = VkMemoryAllocateInfo.npNext(adr)
    set(value) = VkMemoryAllocateInfo.npNext(adr, value)
inline var VkMemoryAllocateInfo.allocationSize: VkDeviceSize
    get() = VkDeviceSize(VkMemoryAllocateInfo.nallocationSize(adr))
    set(value) = VkMemoryAllocateInfo.nallocationSize(adr, value.L)
inline var VkMemoryAllocateInfo.memoryTypeIndex: Int
    get() = VkMemoryAllocateInfo.nmemoryTypeIndex(adr)
    set(value) = VkMemoryAllocateInfo.nmemoryTypeIndex(adr, value)


inline var VkMappedMemoryRange.type: VkStructureType
    get() = VkStructureType(VkMappedMemoryRange.nsType(adr))
    set(value) = VkMappedMemoryRange.nsType(adr, value.i)
inline var VkMappedMemoryRange.next: Ptr
    get() = VkMappedMemoryRange.npNext(adr)
    set(value) = VkMappedMemoryRange.npNext(adr, value)
inline var VkMappedMemoryRange.memory: VkDeviceMemory
    get() = VkDeviceMemory(VkMappedMemoryRange.nmemory(adr))
    set(value) = VkMappedMemoryRange.nmemory(adr, value.L)
inline var VkMappedMemoryRange.offset: VkDeviceSize
    get() = VkDeviceSize(VkMappedMemoryRange.noffset(adr))
    set(value) = VkMappedMemoryRange.noffset(adr, value.L)
inline var VkMappedMemoryRange.size: VkDeviceSize
    get() = VkDeviceSize(VkMappedMemoryRange.nsize(adr))
    set(value) = VkMappedMemoryRange.nsize(adr, value.L)


inline val VkMemoryRequirements.size: VkDeviceSize
    get() = VkDeviceSize(VkMemoryRequirements.nsize(adr))
inline val VkMemoryRequirements.alignment: VkDeviceSize
    get() = VkDeviceSize(VkMemoryRequirements.nalignment(adr))
inline val VkMemoryRequirements.memoryTypeBits: Int
    get() = VkMemoryRequirements.nmemoryTypeBits(adr)


inline val VkSparseImageFormatProperties.aspectMask: VkImageAspectFlags
    get() = VkSparseImageFormatProperties.naspectMask(adr)
inline val VkSparseImageFormatProperties.imageGranularity: VkExtent3D
    get() = VkSparseImageFormatProperties.nimageGranularity(adr)
inline val VkSparseImageFormatProperties.flags: VkSparseImageFormatFlags
    get() = VkSparseImageFormatProperties.nflags(adr)


inline var VkSparseMemoryBind.resourceOffset: VkDeviceSize
    get() = VkDeviceSize(VkSparseMemoryBind.nresourceOffset(adr))
    set(value) = VkSparseMemoryBind.nresourceOffset(adr, value.L)
inline var VkSparseMemoryBind.size: VkDeviceSize
    get() = VkDeviceSize(VkSparseMemoryBind.nsize(adr))
    set(value) = VkSparseMemoryBind.nsize(adr, value.L)
inline var VkSparseMemoryBind.memory: VkDeviceMemory
    get() = VkDeviceMemory(VkSparseMemoryBind.nmemory(adr))
    set(value) = VkSparseMemoryBind.nmemory(adr, value.L)
inline var VkSparseMemoryBind.memoryOffset: VkDeviceSize
    get() = VkDeviceSize(VkSparseMemoryBind.nmemoryOffset(adr))
    set(value) = VkSparseMemoryBind.nmemoryOffset(adr, value.L)
inline var VkSparseMemoryBind.flags: VkSparseMemoryBindFlags
    get() = VkSparseMemoryBind.nflags(adr)
    set(value) = VkSparseMemoryBind.nflags(adr, value)


inline var VkSparseBufferMemoryBindInfo.buffer: VkBuffer
    get() = VkBuffer(VkSparseBufferMemoryBindInfo.nbuffer(adr))
    set(value) = VkSparseBufferMemoryBindInfo.nbuffer(adr, value.L)
inline var VkSparseBufferMemoryBindInfo.bindCount: Int
    get() = VkSparseBufferMemoryBindInfo.nbindCount(adr)
    set(value) = VkSparseBufferMemoryBindInfo.nbindCount(adr, value)
@Deprecated("this will be set automatically")
inline var VkSparseBufferMemoryBindInfo.binds: VkSparseMemoryBind.Buffer
    get() = VkSparseBufferMemoryBindInfo.npBinds(adr)
    set(value) = VkSparseBufferMemoryBindInfo.npBinds(adr, value)


inline var VkSparseImageOpaqueMemoryBindInfo.image: VkImage
    get() = VkImage(VkSparseImageOpaqueMemoryBindInfo.nimage(adr))
    set(value) = VkSparseImageOpaqueMemoryBindInfo.nimage(adr, value.L)
@Deprecated("this will be set automatically")
inline var VkSparseImageOpaqueMemoryBindInfo.bindCount: Int
    get() = VkSparseImageOpaqueMemoryBindInfo.nbindCount(adr)
    set(value) = VkSparseImageOpaqueMemoryBindInfo.nbindCount(adr, value)
inline var VkSparseImageOpaqueMemoryBindInfo.binds: VkSparseMemoryBind.Buffer
    get() = VkSparseImageOpaqueMemoryBindInfo.npBinds(adr)
    set(value) = VkSparseImageOpaqueMemoryBindInfo.npBinds(adr, value)


inline var VkImageSubresource.aspectMask: VkImageAspectFlags
    get() = VkImageSubresource.naspectMask(adr)
    set(value) = VkImageSubresource.naspectMask(adr, value.i)
inline var VkImageSubresource.mipLevel: Int
    get() = VkImageSubresource.nmipLevel(adr)
    set(value) = VkImageSubresource.nmipLevel(adr, value)
inline var VkImageSubresource.arrayLayer: Int
    get() = VkImageSubresource.narrayLayer(adr)
    set(value) = VkImageSubresource.narrayLayer(adr, value)


inline var VkOffset3D.x: Int
    get() = VkOffset3D.nx(adr)
    set(value) = VkOffset3D.nx(adr, value)
inline var VkOffset3D.y: Int
    get() = VkOffset3D.ny(adr)
    set(value) = VkOffset3D.ny(adr, value)
inline var VkOffset3D.z: Int
    get() = VkOffset3D.nz(adr)
    set(value) = VkOffset3D.nz(adr, value)
/** JVM custom */
inline var VkOffset3D.v: Vec3i
    get() = Vec3i(x, y, z)
    set(value) {
        x = value.x
        y = value.y
        z = value.z
    }


inline var VkSparseImageMemoryBind.subresource: VkImageSubresource
    get() = VkSparseImageMemoryBind.nsubresource(adr)
    set(value) = VkSparseImageMemoryBind.nsubresource(adr, value)
inline var VkSparseImageMemoryBind.offset: VkOffset3D
    get() = VkSparseImageMemoryBind.noffset(adr)
    set(value) = VkSparseImageMemoryBind.noffset(adr, value)
inline var VkSparseImageMemoryBind.extent: VkExtent3D
    get() = VkSparseImageMemoryBind.nextent(adr)
    set(value) = VkSparseImageMemoryBind.nextent(adr, value)
inline var VkSparseImageMemoryBind.memory: VkDeviceMemory
    get() = VkDeviceMemory(VkSparseImageMemoryBind.nmemory(adr))
    set(value) = VkSparseImageMemoryBind.nmemory(adr, value.L)
inline var VkSparseImageMemoryBind.memoryOffset: VkDeviceSize
    get() = VkDeviceSize(VkSparseImageMemoryBind.nmemoryOffset(adr))
    set(value) = VkSparseImageMemoryBind.nmemoryOffset(adr, value.L)
inline var VkSparseImageMemoryBind.flags: VkSparseMemoryBindFlags
    get() = VkSparseImageMemoryBind.nflags(adr)
    set(value) = VkSparseImageMemoryBind.nflags(adr, value)


inline var VkSparseImageMemoryBindInfo.image: VkImage
    get() = VkImage(VkSparseImageMemoryBindInfo.nimage(adr))
    set(value) = VkSparseImageMemoryBindInfo.nimage(adr, value.L)
@Deprecated("this will be set automatically")
inline var VkSparseImageMemoryBindInfo.bindCount: Int
    get() = VkSparseImageMemoryBindInfo.nbindCount(adr)
    set(value) = VkSparseImageMemoryBindInfo.nbindCount(adr, value)
inline var VkSparseImageMemoryBindInfo.binds: VkSparseImageMemoryBind.Buffer
    get() = VkSparseImageMemoryBindInfo.npBinds(adr)
    set(value) = VkSparseImageMemoryBindInfo.npBinds(adr, value)


inline var VkBindSparseInfo.type: VkStructureType
    get() = VkStructureType(VkBindSparseInfo.nsType(adr))
    set(value) = VkBindSparseInfo.nsType(adr, value.i)
inline var VkBindSparseInfo.next: Ptr
    get() = VkBindSparseInfo.npNext(adr)
    set(value) = VkBindSparseInfo.npNext(adr, value)
@Deprecated("this will be set automatically")
inline var VkBindSparseInfo.waitSemaphoreCount: Int
    get() = VkBindSparseInfo.nwaitSemaphoreCount(adr)
    set(value) = VkBindSparseInfo.nwaitSemaphoreCount(adr, value)
inline var VkBindSparseInfo.waitSemaphores: VkSemaphore_Buffer?
    get() = VkBindSparseInfo.npWaitSemaphores(adr)?.let(::VkSemaphore_Buffer)
    set(value) = VkBindSparseInfo.npWaitSemaphores(adr, value?.buffer)
@Deprecated("this will be set automatically")
inline var VkBindSparseInfo.bufferBindCount: Int
    get() = VkBindSparseInfo.nbufferBindCount(adr)
    set(value) = VkBindSparseInfo.nbufferBindCount(adr, value)
inline var VkBindSparseInfo.bufferBinds: VkSparseBufferMemoryBindInfo.Buffer?
    get() = VkBindSparseInfo.npBufferBinds(adr)
    set(value) = VkBindSparseInfo.npBufferBinds(adr, value)
@Deprecated("this will be set automatically")
inline var VkBindSparseInfo.imageOpaqueBindCount: Int
    get() = VkBindSparseInfo.nimageOpaqueBindCount(adr)
    set(value) = VkBindSparseInfo.nimageOpaqueBindCount(adr, value)
inline var VkBindSparseInfo.imageOpaqueBinds: VkSparseImageOpaqueMemoryBindInfo.Buffer?
    get() = VkBindSparseInfo.npImageOpaqueBinds(adr)
    set(value) = VkBindSparseInfo.npImageOpaqueBinds(adr, value)
@Deprecated("this will be set automatically")
inline var VkBindSparseInfo.imageBindCount: Int
    get() = VkBindSparseInfo.nimageBindCount(adr)
    set(value) = VkBindSparseInfo.nimageBindCount(adr, value)
inline var VkBindSparseInfo.imageBinds: VkSparseImageMemoryBindInfo.Buffer?
    get() = VkBindSparseInfo.npImageBinds(adr)
    set(value) = VkBindSparseInfo.npImageBinds(adr, value)
@Deprecated("this will be set automatically")
inline var VkBindSparseInfo.signalSemaphoreCount: Int
    get() = VkBindSparseInfo.nsignalSemaphoreCount(adr)
    set(value) = VkBindSparseInfo.nsignalSemaphoreCount(adr, value)
inline var VkBindSparseInfo.signalSemaphores: VkSemaphore_Buffer?
    get() = VkBindSparseInfo.npSignalSemaphores(adr)?.let(::VkSemaphore_Buffer)
    set(value) = VkBindSparseInfo.npSignalSemaphores(adr, value?.buffer)


inline var VkFenceCreateInfo.type: VkStructureType
    get() = VkStructureType(VkFenceCreateInfo.nsType(adr))
    set(value) = VkFenceCreateInfo.nsType(adr, value.i)
inline var VkFenceCreateInfo.next: Ptr
    get() = VkFenceCreateInfo.npNext(adr)
    set(value) = VkFenceCreateInfo.npNext(adr, value)
inline var VkFenceCreateInfo.flags: VkFenceCreateFlags
    get() = VkFenceCreateInfo.nflags(adr)
    set(value) = VkFenceCreateInfo.nflags(adr, value)


inline var VkSemaphoreCreateInfo.type: VkStructureType
    get() = VkStructureType(VkSemaphoreCreateInfo.nsType(adr))
    set(value) = VkSemaphoreCreateInfo.nsType(adr, value.i)
inline var VkSemaphoreCreateInfo.next: Ptr
    get() = VkSemaphoreCreateInfo.npNext(adr)
    set(value) = VkSemaphoreCreateInfo.npNext(adr, value)
inline var VkSemaphoreCreateInfo.flags: VkSemaphoreCreateFlags
    get() = VkSemaphoreCreateInfo.nflags(adr)
    set(value) = VkSemaphoreCreateInfo.nflags(adr, value)


inline var VkEventCreateInfo.type: VkStructureType
    get() = VkStructureType(VkEventCreateInfo.nsType(adr))
    set(value) = VkEventCreateInfo.nsType(adr, value.i)
inline var VkEventCreateInfo.next: Ptr
    get() = VkEventCreateInfo.npNext(adr)
    set(value) = VkEventCreateInfo.npNext(adr, value)
inline var VkEventCreateInfo.flags: VkEventCreateFlags
    get() = VkEventCreateInfo.nflags(adr)
    set(value) = VkEventCreateInfo.nflags(adr, value)


inline var VkQueryPoolCreateInfo.type: VkStructureType
    get() = VkStructureType(VkQueryPoolCreateInfo.nsType(adr))
    set(value) = VkQueryPoolCreateInfo.nsType(adr, value.i)
inline var VkQueryPoolCreateInfo.next: Ptr
    get() = VkQueryPoolCreateInfo.npNext(adr)
    set(value) = VkQueryPoolCreateInfo.npNext(adr, value)
inline var VkQueryPoolCreateInfo.flags: VkQueryPoolCreateFlags
    get() = VkQueryPoolCreateInfo.nflags(adr)
    set(value) = VkQueryPoolCreateInfo.nflags(adr, value)
inline var VkQueryPoolCreateInfo.queryType: VkQueryType
    get() = VkQueryType(VkQueryPoolCreateInfo.nqueryType(adr))
    set(value) = VkQueryPoolCreateInfo.nqueryType(adr, value.i)
inline var VkQueryPoolCreateInfo.queryCount: Int
    get() = VkQueryPoolCreateInfo.nqueryCount(adr)
    set(value) = VkQueryPoolCreateInfo.nqueryCount(adr, value)
inline var VkQueryPoolCreateInfo.pipelineStatistics: VkQueryPipelineStatisticFlags
    get() = VkQueryPoolCreateInfo.npipelineStatistics(adr)
    set(value) = VkQueryPoolCreateInfo.npipelineStatistics(adr, value)


inline var VkBufferCreateInfo.type: VkStructureType
    get() = VkStructureType(VkBufferCreateInfo.nsType(adr))
    set(value) = VkBufferCreateInfo.nsType(adr, value.i)
inline var VkBufferCreateInfo.next: Ptr
    get() = VkBufferCreateInfo.npNext(adr)
    set(value) = VkBufferCreateInfo.npNext(adr, value)
/** JVM custom */
inline var VkBufferCreateInfo.flag: VkBufferCreate
    get() = throw Exception("invalid")
    set(value) = VkBufferCreateInfo.nflags(adr, value.i)
inline var VkBufferCreateInfo.flags: VkBufferCreateFlags
    get() = VkBufferCreateInfo.nflags(adr)
    set(value) = VkBufferCreateInfo.nflags(adr, value)
inline var VkBufferCreateInfo.size: VkDeviceSize
    get() = VkDeviceSize(VkBufferCreateInfo.nsize(adr))
    set(value) = VkBufferCreateInfo.nsize(adr, value.L)
inline var VkBufferCreateInfo.usage: VkBufferUsageFlags
    get() = VkBufferCreateInfo.nusage(adr)
    set(value) = VkBufferCreateInfo.nusage(adr, value)
inline var VkBufferCreateInfo.sharingMode: VkSharingMode
    get() = VkSharingMode(VkBufferCreateInfo.nsharingMode(adr))
    set(value) = VkBufferCreateInfo.nsharingMode(adr, value.i)
inline var VkBufferCreateInfo.queueFamilyIndexCount: Int
    get() = VkBufferCreateInfo.nqueueFamilyIndexCount(adr)
    set(value) = VkBufferCreateInfo.nqueueFamilyIndexCount(adr, value)
inline var VkBufferCreateInfo.queueFamilyIndices: IntBuffer?
    get() = VkBufferCreateInfo.npQueueFamilyIndices(adr)
    set(value) = VkBufferCreateInfo.npQueueFamilyIndices(adr, value)


inline var VkBufferViewCreateInfo.type: VkStructureType
    get() = VkStructureType(VkBufferViewCreateInfo.nsType(adr))
    set(value) = VkBufferViewCreateInfo.nsType(adr, value.i)
inline var VkBufferViewCreateInfo.next: Ptr
    get() = VkBufferViewCreateInfo.npNext(adr)
    set(value) = VkBufferViewCreateInfo.npNext(adr, value)
inline var VkBufferViewCreateInfo.flags: VkBufferViewCreateFlags
    get() = VkBufferViewCreateInfo.nflags(adr)
    set(value) = VkBufferViewCreateInfo.nflags(adr, value)
inline var VkBufferViewCreateInfo.buffer: VkBuffer
    get() = VkBuffer(VkBufferViewCreateInfo.nbuffer(adr))
    set(value) = VkBufferViewCreateInfo.nbuffer(adr, value.L)
inline var VkBufferViewCreateInfo.format: VkFormat
    get() = VkFormat(VkBufferViewCreateInfo.nformat(adr))
    set(value) = VkBufferViewCreateInfo.nformat(adr, value.i)
inline var VkBufferViewCreateInfo.offset: VkDeviceSize
    get() = VkDeviceSize(VkBufferViewCreateInfo.noffset(adr))
    set(value) = VkBufferViewCreateInfo.noffset(adr, value.L)
inline var VkBufferViewCreateInfo.range: VkDeviceSize
    get() = VkDeviceSize(VkBufferViewCreateInfo.nrange(adr))
    set(value) = VkBufferViewCreateInfo.nrange(adr, value.L)


inline var VkImageCreateInfo.type: VkStructureType
    get() = VkStructureType(VkImageCreateInfo.nsType(adr))
    set(value) = VkImageCreateInfo.nsType(adr, value.i)
inline var VkImageCreateInfo.next: Ptr
    get() = VkImageCreateInfo.npNext(adr)
    set(value) = VkImageCreateInfo.npNext(adr, value)
/** JVM custom */
inline var VkImageCreateInfo.flag: VkImageCreate
    get() = throw Exception("Invalid")
    set(value) = VkImageCreateInfo.nflags(adr, value.i)
inline var VkImageCreateInfo.flags: VkImageCreateFlags
    get() = VkImageCreateInfo.nflags(adr)
    set(value) = VkImageCreateInfo.nflags(adr, value)
inline var VkImageCreateInfo.imageType: VkImageType
    get() = VkImageType(VkImageCreateInfo.nimageType(adr))
    set(value) = VkImageCreateInfo.nimageType(adr, value.i)
inline var VkImageCreateInfo.format: VkFormat
    get() = VkFormat(VkImageCreateInfo.nformat(adr))
    set(value) = VkImageCreateInfo.nformat(adr, value.i)
inline var VkImageCreateInfo.extent: VkExtent3D
    get() = VkImageCreateInfo.nextent(adr)
    set(value) = VkImageCreateInfo.nextent(adr, value)

/** JVM custom */
fun VkImageCreateInfo.extent(extent: Vec3i) = this.extent.set(extent.x, extent.y, extent.z)

/** JVM custom */
fun VkImageCreateInfo.extent(extent: Vec2i, depth: Int) = this.extent.set(extent.x, extent.y, depth)

inline var VkImageCreateInfo.mipLevels: Int
    get() = VkImageCreateInfo.nmipLevels(adr)
    set(value) = VkImageCreateInfo.nmipLevels(adr, value)
inline var VkImageCreateInfo.arrayLayers: Int
    get() = VkImageCreateInfo.narrayLayers(adr)
    set(value) = VkImageCreateInfo.narrayLayers(adr, value)
inline var VkImageCreateInfo.samples: VkSampleCount
    get() = VkSampleCount(VkImageCreateInfo.nsamples(adr))
    set(value) = VkImageCreateInfo.nsamples(adr, value.i)
inline var VkImageCreateInfo.tiling: VkImageTiling
    get() = VkImageTiling(VkImageCreateInfo.ntiling(adr))
    set(value) = VkImageCreateInfo.ntiling(adr, value.i)
inline var VkImageCreateInfo.usage: VkImageUsageFlags
    get() = VkImageCreateInfo.nusage(adr)
    set(value) = VkImageCreateInfo.nusage(adr, value)
inline var VkImageCreateInfo.sharingMode: VkSharingMode
    get() = VkSharingMode(VkImageCreateInfo.nsharingMode(adr))
    set(value) = VkImageCreateInfo.nsharingMode(adr, value.i)
@Deprecated("this will be set automatically")
inline var VkImageCreateInfo.queueFamilyIndexCount: Int
    get() = VkImageCreateInfo.nqueueFamilyIndexCount(adr)
    set(value) = VkImageCreateInfo.nqueueFamilyIndexCount(adr, value)
inline var VkImageCreateInfo.queueFamilyIndices: IntBuffer?
    get() = VkImageCreateInfo.npQueueFamilyIndices(adr)
    set(value) = VkImageCreateInfo.npQueueFamilyIndices(adr, value)
inline var VkImageCreateInfo.initialLayout: VkImageLayout
    get() = VkImageLayout(VkImageCreateInfo.ninitialLayout(adr))
    set(value) = VkImageCreateInfo.ninitialLayout(adr, value.i)


inline val VkSubresourceLayout.offset: VkDeviceSize
    get() = VkDeviceSize(VkSubresourceLayout.noffset(adr))
inline val VkSubresourceLayout.size: VkDeviceSize
    get() = VkDeviceSize(VkSubresourceLayout.nsize(adr))
inline val VkSubresourceLayout.rowPitch: VkDeviceSize
    get() = VkDeviceSize(VkSubresourceLayout.nrowPitch(adr))
inline val VkSubresourceLayout.arrayPitch: VkDeviceSize
    get() = VkDeviceSize(VkSubresourceLayout.narrayPitch(adr))
inline val VkSubresourceLayout.depthPitch: VkDeviceSize
    get() = VkDeviceSize(VkSubresourceLayout.ndepthPitch(adr))


inline var VkComponentMapping.r: VkComponentSwizzle
    get() = VkComponentSwizzle(VkComponentMapping.nr(adr))
    set(value) = VkComponentMapping.nr(adr, value.i)
inline var VkComponentMapping.g: VkComponentSwizzle
    get() = VkComponentSwizzle(VkComponentMapping.ng(adr))
    set(value) = VkComponentMapping.ng(adr, value.i)
inline var VkComponentMapping.b: VkComponentSwizzle
    get() = VkComponentSwizzle(VkComponentMapping.nb(adr))
    set(value) = VkComponentMapping.nb(adr, value.i)
inline var VkComponentMapping.a: VkComponentSwizzle
    get() = VkComponentSwizzle(VkComponentMapping.na(adr))
    set(value) = VkComponentMapping.na(adr, value.i)

/** JVM custom */
operator fun VkComponentMapping.invoke(r: VkComponentSwizzle, g: VkComponentSwizzle, b: VkComponentSwizzle, a: VkComponentSwizzle) {
    this.r = r
    this.g = g
    this.b = b
    this.a = a
}


inline var VkImageSubresourceRange.aspectMask: VkImageAspectFlags
    get() = VkImageSubresourceRange.naspectMask(adr)
    set(value) = VkImageSubresourceRange.naspectMask(adr, value)
inline var VkImageSubresourceRange.baseMipLevel: Int
    get() = VkImageSubresourceRange.nbaseMipLevel(adr)
    set(value) = VkImageSubresourceRange.nbaseMipLevel(adr, value)
inline var VkImageSubresourceRange.levelCount: Int
    get() = VkImageSubresourceRange.nlevelCount(adr)
    set(value) = VkImageSubresourceRange.nlevelCount(adr, value)
inline var VkImageSubresourceRange.baseArrayLayer: Int
    get() = VkImageSubresourceRange.nbaseArrayLayer(adr)
    set(value) = VkImageSubresourceRange.nbaseArrayLayer(adr, value)
inline var VkImageSubresourceRange.layerCount: Int
    get() = VkImageSubresourceRange.nlayerCount(adr)
    set(value) = VkImageSubresourceRange.nlayerCount(adr, value)


inline var VkImageViewCreateInfo.type: VkStructureType
    get() = VkStructureType(VkImageViewCreateInfo.nsType(adr))
    set(value) = VkImageViewCreateInfo.nsType(adr, value.i)
inline var VkImageViewCreateInfo.next: Ptr
    get() = VkImageViewCreateInfo.npNext(adr)
    set(value) = VkImageViewCreateInfo.npNext(adr, value)
inline var VkImageViewCreateInfo.flags: VkImageViewCreateFlags
    get() = VkImageViewCreateInfo.nflags(adr)
    set(value) = VkImageViewCreateInfo.nflags(adr, value)
inline var VkImageViewCreateInfo.image: VkImage
    get() = VkImage(VkImageViewCreateInfo.nimage(adr))
    set(value) = VkImageViewCreateInfo.nimage(adr, value.L)
inline var VkImageViewCreateInfo.viewType: VkImageViewType
    get() = VkImageViewType(VkImageViewCreateInfo.nviewType(adr))
    set(value) = VkImageViewCreateInfo.nviewType(adr, value.i)
inline var VkImageViewCreateInfo.format: VkFormat
    get() = VkFormat(VkImageViewCreateInfo.nformat(adr))
    set(value) = VkImageViewCreateInfo.nformat(adr, value.i)
inline var VkImageViewCreateInfo.components: VkComponentMapping
    get() = VkImageViewCreateInfo.ncomponents(adr)
    set(value) = VkImageViewCreateInfo.ncomponents(adr, value)
inline var VkImageViewCreateInfo.subresourceRange: VkImageSubresourceRange
    get() = VkImageViewCreateInfo.nsubresourceRange(adr)
    set(value) = VkImageViewCreateInfo.nsubresourceRange(adr, value)


inline var VkShaderModuleCreateInfo.type: VkStructureType
    get() = VkStructureType(VkShaderModuleCreateInfo.nsType(adr))
    set(value) = VkShaderModuleCreateInfo.nsType(adr, value.i)
inline var VkShaderModuleCreateInfo.next: Ptr
    get() = VkShaderModuleCreateInfo.npNext(adr)
    set(value) = VkShaderModuleCreateInfo.npNext(adr, value)
inline var VkShaderModuleCreateInfo.flags: VkShaderModuleCreateFlags
    get() = VkShaderModuleCreateInfo.nflags(adr)
    set(value) = VkShaderModuleCreateInfo.nflags(adr, value)
@Deprecated("this will be set automatically")
inline var VkShaderModuleCreateInfo.codeSize: Long
    get() = VkShaderModuleCreateInfo.ncodeSize(adr)
    set(value) = VkShaderModuleCreateInfo.ncodeSize(adr, value)
inline var VkShaderModuleCreateInfo.code: ByteBuffer
    get() = VkShaderModuleCreateInfo.npCode(adr)
    set(value) = VkShaderModuleCreateInfo.npCode(adr, value)


inline var VkPipelineCacheCreateInfo.type: VkStructureType
    get() = VkStructureType(VkPipelineCacheCreateInfo.nsType(adr))
    set(value) = VkPipelineCacheCreateInfo.nsType(adr, value.i)
inline var VkPipelineCacheCreateInfo.next: Ptr
    get() = VkPipelineCacheCreateInfo.npNext(adr)
    set(value) = VkPipelineCacheCreateInfo.npNext(adr, value)
inline var VkPipelineCacheCreateInfo.flags: VkPipelineCacheCreateFlags
    get() = VkPipelineCacheCreateInfo.nflags(adr)
    set(value) = VkPipelineCacheCreateInfo.nflags(adr, value)
@Deprecated("this will be set automatically")
inline var VkPipelineCacheCreateInfo.initialDataSize: Long
    get() = VkPipelineCacheCreateInfo.ninitialDataSize(adr)
    set(value) = VkPipelineCacheCreateInfo.ninitialDataSize(adr, value)
inline var VkPipelineCacheCreateInfo.initialData: ByteBuffer?
    get() = VkPipelineCacheCreateInfo.npInitialData(adr)
    set(value) = VkPipelineCacheCreateInfo.npInitialData(adr, value)


inline var VkSpecializationMapEntry.constantId: Int
    get() = VkSpecializationMapEntry.nconstantID(adr)
    set(value) = VkSpecializationMapEntry.nconstantID(adr, value)
inline var VkSpecializationMapEntry.offset: Int
    get() = VkSpecializationMapEntry.noffset(adr)
    set(value) = VkSpecializationMapEntry.noffset(adr, value)
inline var VkSpecializationMapEntry.size: Long
    get() = VkSpecializationMapEntry.nsize(adr)
    set(value) = VkSpecializationMapEntry.nsize(adr, value)


@Deprecated("this will be set automatically")
inline var VkSpecializationInfo.mapEntryCount: Int
    get() = VkSpecializationInfo.nmapEntryCount(adr)
    set(value) = VkSpecializationInfo.nmapEntryCount(adr, value)
inline var VkSpecializationInfo.mapEntries: VkSpecializationMapEntry.Buffer?
    get() = VkSpecializationInfo.npMapEntries(adr)
    set(value) = VkSpecializationInfo.npMapEntries(adr, value)
/** JVM custom */
inline var VkSpecializationInfo.mapEntry: VkSpecializationMapEntry?
    get() = VkSpecializationInfo.npMapEntries(adr)?.get(0)
    set(value) {
        memPutAddress(adr + VkSpecializationInfo.PMAPENTRIES, memAddressSafe(value))
        mapEntryCount = 1
    }
@Deprecated("this will be set automatically")
inline var VkSpecializationInfo.dataSize: Long
    get() = VkSpecializationInfo.ndataSize(adr)
    set(value) = VkSpecializationInfo.ndataSize(adr, value)
inline var VkSpecializationInfo.data: ByteBuffer?
    get() = VkSpecializationInfo.npData(adr)
    set(value) = VkSpecializationInfo.npData(adr, value)