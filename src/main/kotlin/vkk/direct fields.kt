package vkk


import glm_.BYTES
import glm_.bool
import glm_.f
import glm_.i
import glm_.vec2.Vec2
import glm_.vec2.Vec2i
import glm_.vec3.Vec3i
import kool.Adr
import kool.Ptr
import kool.adr
import kool.stak
import org.lwjgl.PointerBuffer
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.system.Pointer
import org.lwjgl.vulkan.*
import vkk.entities.*
import java.nio.ByteBuffer
import java.nio.FloatBuffer
import java.nio.IntBuffer
import java.nio.LongBuffer


inline var VkApplicationInfo.type: VkStructureType
    get() = VkStructureType(VkApplicationInfo.nsType(adr))
    set(value) = VkApplicationInfo.nsType(adr, value.i)
inline var VkApplicationInfo.next: Ptr
    get() = VkApplicationInfo.npNext(adr)
    set(value) = VkApplicationInfo.npNext(adr, value)
inline var VkApplicationInfo.applicationName: String?
    get() = VkApplicationInfo.npApplicationNameString(adr)
    set(value) = stak { VkApplicationInfo.npApplicationName(adr, value?.toUTF8(it)) }
inline var VkApplicationInfo.applicationVersion: Int
    get() = VkApplicationInfo.napplicationVersion(adr)
    set(value) = VkApplicationInfo.napiVersion(adr, value)
inline var VkApplicationInfo.engineName: String?
    get() = VkApplicationInfo.npEngineNameString(adr)
    set(value) = stak { VkApplicationInfo.npEngineName(adr, value?.toUTF8(it)) }
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
    set(value) = stak { VkInstanceCreateInfo.nppEnabledLayerNames(adr, value.toPointerBuffer(it)) }
inline var VkInstanceCreateInfo.enabledExtensionNames: Collection<String>
    get() = VkInstanceCreateInfo.nppEnabledExtensionNames(adr)?.toArrayList() ?: arrayListOf()
    set(value) = stak { VkInstanceCreateInfo.nppEnabledExtensionNames(adr, value.toPointerBuffer(it)) }


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


inline val VkFormatProperties.linearTilingFeatures: VkFormatFeatureFlags
    get() = VkFormatProperties.nlinearTilingFeatures(adr)
inline val VkFormatProperties.optimalTilingFeatures: VkFormatFeatureFlags
    get() = VkFormatProperties.noptimalTilingFeatures(adr)
inline val VkFormatProperties.bufferFeatures: VkFormatFeatureFlags
    get() = VkFormatProperties.nbufferFeatures(adr)


inline var VkExtent3D.width: Int
    get() = VkExtent3D.nwidth(adr)
    set(value) =VkExtent3D.nwidth(adr, value)
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
inline val  VkImageFormatProperties.maxMipLevels: Int
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
inline val VkPhysicalDeviceLimits.maxTexelGatherOffsetminMemoryMapAlignment
    get() = VkPhysicalDeviceLimits.nmaxTexelGatherOffset(adr)
inline val VkPhysicalDeviceLimits.minInterpolationOffset: Float
    get() = VkPhysicalDeviceLimits.nminInterpolationOffset(adr)
inline val VkPhysicalDeviceLimits.maxInterpolationOffset: Float
    get() = VkPhysicalDeviceLimits.nmaxInterpolationOffset(adr)
inline val VkPhysicalDeviceLimits.subPixelInterpolationOffsetBitsminMemoryMapAlignment
    get() = VkPhysicalDeviceLimits.nsubPixelInterpolationOffsetBits(adr)
inline val VkPhysicalDeviceLimits.maxFramebufferWidthminMemoryMapAlignment
    get() = VkPhysicalDeviceLimits.nmaxFramebufferWidth(adr)
inline val VkPhysicalDeviceLimits.maxFramebufferHeightminMemoryMapAlignment
    get() = VkPhysicalDeviceLimits.nmaxFramebufferHeight(adr)
inline val VkPhysicalDeviceLimits.maxFramebufferLayersminMemoryMapAlignment
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

//typedef struct VkPhysicalDeviceSparseProperties {
//    VkBool32    residencyStandard2DBlockShape;
//    VkBool32    residencyStandard2DMultisampleBlockShape;
//    VkBool32    residencyStandard3DBlockShape;
//    VkBool32    residencyAlignedMipSize;
//    VkBool32    residencyNonResidentStrict;
//} VkPhysicalDeviceSparseProperties;


inline val VkPhysicalDeviceProperties.apiVersion: Int
    get() = VkPhysicalDeviceProperties.napiVersion(adr)
inline val VkPhysicalDeviceProperties.driverVersion: Int
    get() = VkPhysicalDeviceProperties.ndriverVersion(adr)
inline val VkPhysicalDeviceProperties.vendorID: Int
    get() = VkPhysicalDeviceProperties.nvendorID(adr)
inline val VkPhysicalDeviceProperties.deviceID: Int
    get() = VkPhysicalDeviceProperties.ndeviceID(adr)
inline val VkPhysicalDeviceProperties.deviceType: VkPhysicalDeviceType
    get() = VkPhysicalDeviceType of VkPhysicalDeviceProperties.ndeviceType(adr)
inline val VkPhysicalDeviceProperties.deviceName: String
    get() = VkPhysicalDeviceProperties.ndeviceNameString(adr)
inline val VkPhysicalDeviceProperties.pipelineCacheUUID: ByteBuffer
    get() = VkPhysicalDeviceProperties.npipelineCacheUUID(adr)
inline val VkPhysicalDeviceProperties.limits: VkPhysicalDeviceLimits
    get() = VkPhysicalDeviceProperties.nlimits(adr)
inline val VkPhysicalDeviceProperties.sparseProperties: VkPhysicalDeviceSparseProperties
    get() = VkPhysicalDeviceProperties.nsparseProperties(adr)

/* ---------------------------------------------------------------------------------------------------------------------
 * JVM custom */
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
/* JVM custom
*  -------------------------------------------------------------------------------------------------------------------*/


//typedef struct VkPhysicalDeviceProperties {
//    uint32_t                            apiVersion;
//    uint32_t                            driverVersion;
//    uint32_t                            vendorID;
//    uint32_t                            deviceID;
//    VkPhysicalDeviceType                deviceType;
//    char                                deviceName[VK_MAX_PHYSICAL_DEVICE_NAME_SIZE];
//    uint8_t                             pipelineCacheUUID[VK_UUID_SIZE];
//    VkPhysicalDeviceLimits              limits;
//    VkPhysicalDeviceSparseProperties    sparseProperties;
//} VkPhysicalDeviceProperties;

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