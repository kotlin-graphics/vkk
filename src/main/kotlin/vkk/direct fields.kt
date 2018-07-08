package vkk

import ab.appBuffer
import glm_.*
import glm_.buffer.adr
import glm_.vec2.Vec2
import glm_.vec2.Vec2i
import glm_.vec3.Vec3i
import glm_.vec4.Vec4
import org.lwjgl.PointerBuffer
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.vulkan.*
import java.nio.ByteBuffer
import java.nio.FloatBuffer
import java.nio.IntBuffer
import java.nio.LongBuffer


inline var VkApplicationInfo.type
    get() = VkStructureType of VkApplicationInfo.nsType(adr)
    set(value) = VkApplicationInfo.nsType(adr, value.i)
inline var VkApplicationInfo.next
    get() = VkApplicationInfo.npNext(adr)
    set(value) = VkApplicationInfo.npNext(adr, value)
inline var VkApplicationInfo.applicationName
    get() = VkApplicationInfo.npApplicationNameString(adr)
    set(value) = VkApplicationInfo.npApplicationName(adr, value?.utf8)
inline var VkApplicationInfo.applicationVersion
    get() = VkApplicationInfo.napplicationVersion(adr)
    set(value) = VkApplicationInfo.napiVersion(adr, value)
inline var VkApplicationInfo.engineName
    get() = VkApplicationInfo.npEngineNameString(adr)
    set(value) = VkApplicationInfo.npEngineName(adr, value?.utf8)
inline var VkApplicationInfo.apiVersion
    get() = VkApplicationInfo.napiVersion(adr)
    set(value) = VkApplicationInfo.napiVersion(adr, value)


inline var VkInstanceCreateInfo.type
    get() = VkStructureType of VkInstanceCreateInfo.nsType(adr)
    set(value) = VkInstanceCreateInfo.nsType(adr, value.i)
inline var VkInstanceCreateInfo.next
    get() = VkInstanceCreateInfo.npNext(adr)
    set(value) = VkInstanceCreateInfo.npNext(adr, value)
// flags is reserved for future usage, till now must be 0
//inline var VkInstanceCreateInfo.flag: VkInstanceCreateFlags
//    get() = VkInstanceCreateInfo.nflags(adr)
//    set(value) = VkInstanceCreateInfo.nflags(adr, value)
inline var VkInstanceCreateInfo.flags: VkInstanceCreateFlags
    get() = VkInstanceCreateInfo.nflags(adr)
    set(value) = VkInstanceCreateInfo.nflags(adr, value)
inline var VkInstanceCreateInfo.applicationInfo
    get() = VkInstanceCreateInfo.npApplicationInfo(adr)
    set(value) = VkInstanceCreateInfo.npApplicationInfo(adr, value)
inline var VkInstanceCreateInfo.enabledLayerNames: Collection<String>
    get() = VkInstanceCreateInfo.nppEnabledLayerNames(adr).toArrayList()
    set(value) = VkInstanceCreateInfo.nppEnabledLayerNames(adr, value.toPointerBuffer())
inline var VkInstanceCreateInfo.enabledExtensionNames
    get() = VkInstanceCreateInfo.nppEnabledExtensionNames(adr).toArrayList()
    set(value) = VkInstanceCreateInfo.nppEnabledExtensionNames(adr, value.toPointerBuffer())

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

inline val VkFormatProperties.linearTilingFeatures: VkFormatFeatureFlags get() = VkFormatProperties.nlinearTilingFeatures(adr)
inline val VkFormatProperties.optimalTilingFeatures: VkFormatFeatureFlags get() = VkFormatProperties.noptimalTilingFeatures(adr)
inline val VkFormatProperties.bufferFeatures: VkFormatFeatureFlags get() = VkFormatProperties.nbufferFeatures(adr)

//typedef struct VkExtent3D {
//    uint32_t    width;
//    uint32_t    height;
//    uint32_t    depth;
//} VkExtent3D;
//
//typedef struct VkImageFormatProperties {
//    VkExtent3D            maxExtent;
//    uint32_t              maxMipLevels;
//    uint32_t              maxArrayLayers;
//    VkSampleCountFlags    sampleCounts;
//    VkDeviceSize          maxResourceSize;
//} VkImageFormatProperties;

inline val VkPhysicalDeviceLimits.maxImageDimension1D
    get() = VkPhysicalDeviceLimits.nmaxImageDimension1D(adr)
inline val VkPhysicalDeviceLimits.maxImageDimension2D
    get() = VkPhysicalDeviceLimits.nmaxImageDimension2D(adr)
inline val VkPhysicalDeviceLimits.maxImageDimension3D
    get() = VkPhysicalDeviceLimits.nmaxImageDimension3D(adr)
inline val VkPhysicalDeviceLimits.maxImageDimensionCube
    get() = VkPhysicalDeviceLimits.nmaxImageDimensionCube(adr)
inline val VkPhysicalDeviceLimits.maxImageArrayLayers
    get() = VkPhysicalDeviceLimits.nmaxImageArrayLayers(adr)
inline val VkPhysicalDeviceLimits.maxTexelBufferElements
    get() = VkPhysicalDeviceLimits.nmaxTexelBufferElements(adr)
inline val VkPhysicalDeviceLimits.maxUniformBufferRange
    get() = VkPhysicalDeviceLimits.nmaxUniformBufferRange(adr)
inline val VkPhysicalDeviceLimits.maxStorageBufferRange
    get() = VkPhysicalDeviceLimits.nmaxStorageBufferRange(adr)
inline val VkPhysicalDeviceLimits.maxPushConstantsSize
    get() = VkPhysicalDeviceLimits.nmaxPushConstantsSize(adr)
inline val VkPhysicalDeviceLimits.maxMemoryAllocationCount
    get() = VkPhysicalDeviceLimits.nmaxMemoryAllocationCount(adr)
inline val VkPhysicalDeviceLimits.maxSamplerAllocationCount
    get() = VkPhysicalDeviceLimits.nmaxSamplerAllocationCount(adr)
inline val VkPhysicalDeviceLimits.bufferImageGranularity: VkDeviceSize
    get() = VkPhysicalDeviceLimits.nbufferImageGranularity(adr)
inline val VkPhysicalDeviceLimits.sparseAddressSpaceSize: VkDeviceSize
    get() = VkPhysicalDeviceLimits.nsparseAddressSpaceSize(adr)
inline val VkPhysicalDeviceLimits.maxBoundDescriptorSets
    get() = VkPhysicalDeviceLimits.nmaxBoundDescriptorSets(adr)
inline val VkPhysicalDeviceLimits.maxPerStageDescriptorSamplers
    get() = VkPhysicalDeviceLimits.nmaxPerStageDescriptorSamplers(adr)
inline val VkPhysicalDeviceLimits.maxPerStageDescriptorUniformBuffers
    get() = VkPhysicalDeviceLimits.nmaxPerStageDescriptorUniformBuffers(adr)
inline val VkPhysicalDeviceLimits.maxPerStageDescriptorStorageBuffers
    get() = VkPhysicalDeviceLimits.nmaxPerStageDescriptorStorageBuffers(adr)
inline val VkPhysicalDeviceLimits.maxPerStageDescriptorSampledImages
    get() = VkPhysicalDeviceLimits.nmaxPerStageDescriptorSampledImages(adr)
inline val VkPhysicalDeviceLimits.maxPerStageDescriptorStorageImages
    get() = VkPhysicalDeviceLimits.nmaxPerStageDescriptorStorageImages(adr)
inline val VkPhysicalDeviceLimits.maxPerStageDescriptorInputAttachments
    get() = VkPhysicalDeviceLimits.nmaxPerStageDescriptorInputAttachments(adr)
inline val VkPhysicalDeviceLimits.maxPerStageResources
    get() = VkPhysicalDeviceLimits.nmaxPerStageResources(adr)
inline val VkPhysicalDeviceLimits.maxDescriptorSetSamplers
    get() = VkPhysicalDeviceLimits.nmaxDescriptorSetSamplers(adr)
inline val VkPhysicalDeviceLimits.maxDescriptorSetUniformBuffers
    get() = VkPhysicalDeviceLimits.nmaxDescriptorSetUniformBuffers(adr)
inline val VkPhysicalDeviceLimits.maxDescriptorSetUniformBuffersDynamic
    get() = VkPhysicalDeviceLimits.nmaxDescriptorSetUniformBuffersDynamic(adr)
inline val VkPhysicalDeviceLimits.maxDescriptorSetStorageBuffers
    get() = VkPhysicalDeviceLimits.nmaxDescriptorSetStorageBuffers(adr)
inline val VkPhysicalDeviceLimits.maxDescriptorSetStorageBuffersDynamic
    get() = VkPhysicalDeviceLimits.nmaxDescriptorSetStorageBuffersDynamic(adr)
inline val VkPhysicalDeviceLimits.maxDescriptorSetSampledImages
    get() = VkPhysicalDeviceLimits.nmaxDescriptorSetSampledImages(adr)
inline val VkPhysicalDeviceLimits.maxDescriptorSetStorageImages
    get() = VkPhysicalDeviceLimits.nmaxDescriptorSetStorageImages(adr)
inline val VkPhysicalDeviceLimits.maxDescriptorSetInputAttachments
    get() = VkPhysicalDeviceLimits.nmaxDescriptorSetInputAttachments(adr)
inline val VkPhysicalDeviceLimits.maxVertexInputAttributes
    get() = VkPhysicalDeviceLimits.nmaxVertexInputAttributes(adr)
inline val VkPhysicalDeviceLimits.maxVertexInputBindings
    get() = VkPhysicalDeviceLimits.nmaxVertexInputBindings(adr)
inline val VkPhysicalDeviceLimits.maxVertexInputAttributeOffset
    get() = VkPhysicalDeviceLimits.nmaxVertexInputAttributeOffset(adr)
inline val VkPhysicalDeviceLimits.maxVertexInputBindingStride
    get() = VkPhysicalDeviceLimits.nmaxVertexInputBindingStride(adr)
inline val VkPhysicalDeviceLimits.maxVertexOutputComponents
    get() = VkPhysicalDeviceLimits.nmaxVertexOutputComponents(adr)
inline val VkPhysicalDeviceLimits.maxTessellationGenerationLevel
    get() = VkPhysicalDeviceLimits.nmaxTessellationGenerationLevel(adr)
inline val VkPhysicalDeviceLimits.maxTessellationPatchSize
    get() = VkPhysicalDeviceLimits.nmaxTessellationPatchSize(adr)
inline val VkPhysicalDeviceLimits.maxTessellationControlPerVertexInputComponents
    get() = VkPhysicalDeviceLimits.nmaxTessellationControlPerVertexInputComponents(adr)
inline val VkPhysicalDeviceLimits.maxTessellationControlPerVertexOutputComponents
    get() = VkPhysicalDeviceLimits.nmaxTessellationControlPerVertexOutputComponents(adr)
inline val VkPhysicalDeviceLimits.maxTessellationControlPerPatchOutputComponents
    get() = VkPhysicalDeviceLimits.nmaxTessellationControlPerPatchOutputComponents(adr)
inline val VkPhysicalDeviceLimits.maxTessellationControlTotalOutputComponents
    get() = VkPhysicalDeviceLimits.nmaxTessellationControlTotalOutputComponents(adr)
inline val VkPhysicalDeviceLimits.maxTessellationEvaluationInputComponents
    get() = VkPhysicalDeviceLimits.nmaxTessellationEvaluationInputComponents(adr)
inline val VkPhysicalDeviceLimits.maxTessellationEvaluationOutputComponents
    get() = VkPhysicalDeviceLimits.nmaxTessellationEvaluationOutputComponents(adr)
inline val VkPhysicalDeviceLimits.maxGeometryShaderInvocations
    get() = VkPhysicalDeviceLimits.nmaxGeometryShaderInvocations(adr)
inline val VkPhysicalDeviceLimits.maxGeometryInputComponents
    get() = VkPhysicalDeviceLimits.nmaxGeometryInputComponents(adr)
inline val VkPhysicalDeviceLimits.maxGeometryOutputComponents
    get() = VkPhysicalDeviceLimits.nmaxGeometryOutputComponents(adr)
inline val VkPhysicalDeviceLimits.maxGeometryOutputVertices
    get() = VkPhysicalDeviceLimits.nmaxGeometryOutputVertices(adr)
inline val VkPhysicalDeviceLimits.maxGeometryTotalOutputComponents
    get() = VkPhysicalDeviceLimits.nmaxGeometryTotalOutputComponents(adr)
inline val VkPhysicalDeviceLimits.maxFragmentInputComponents
    get() = VkPhysicalDeviceLimits.nmaxFragmentInputComponents(adr)
inline val VkPhysicalDeviceLimits.maxFragmentOutputAttachments
    get() = VkPhysicalDeviceLimits.nmaxFragmentOutputAttachments(adr)
inline val VkPhysicalDeviceLimits.maxFragmentDualSrcAttachments
    get() = VkPhysicalDeviceLimits.nmaxFragmentDualSrcAttachments(adr)
inline val VkPhysicalDeviceLimits.maxFragmentCombinedOutputResources
    get() = VkPhysicalDeviceLimits.nmaxFragmentCombinedOutputResources(adr)
inline val VkPhysicalDeviceLimits.maxComputeSharedMemorySize
    get() = VkPhysicalDeviceLimits.nmaxComputeSharedMemorySize(adr)
inline val VkPhysicalDeviceLimits.maxComputeWorkGroupCount: Vec3i
    get() = Vec3i { VkPhysicalDeviceLimits.nmaxComputeWorkGroupCount(adr, it) }
inline val VkPhysicalDeviceLimits.maxComputeWorkGroupInvocations
    get() = VkPhysicalDeviceLimits.nmaxComputeWorkGroupInvocations(adr)
inline val VkPhysicalDeviceLimits.maxComputeWorkGroupSize: Vec3i
    get() = Vec3i { VkPhysicalDeviceLimits.nmaxComputeWorkGroupSize(adr, it) }
inline val VkPhysicalDeviceLimits.subPixelPrecisionBits
    get() = VkPhysicalDeviceLimits.nsubPixelPrecisionBits(adr)
inline val VkPhysicalDeviceLimits.subTexelPrecisionBits
    get() = VkPhysicalDeviceLimits.nsubTexelPrecisionBits(adr)
inline val VkPhysicalDeviceLimits.mipmapPrecisionBits
    get() = VkPhysicalDeviceLimits.nmipmapPrecisionBits(adr)
inline val VkPhysicalDeviceLimits.maxDrawIndexedIndexValue
    get() = VkPhysicalDeviceLimits.nmaxDrawIndexedIndexValue(adr)
inline val VkPhysicalDeviceLimits.maxDrawIndirectCount
    get() = VkPhysicalDeviceLimits.nmaxDrawIndirectCount(adr)
inline val VkPhysicalDeviceLimits.maxSamplerLodBias
    get() = VkPhysicalDeviceLimits.nmaxSamplerLodBias(adr)
inline val VkPhysicalDeviceLimits.maxSamplerAnisotropy
    get() = VkPhysicalDeviceLimits.nmaxSamplerAnisotropy(adr)
inline val VkPhysicalDeviceLimits.maxViewports
    get() = VkPhysicalDeviceLimits.nmaxViewports(adr)
inline val VkPhysicalDeviceLimits.maxViewportDimensions: Vec2i
    get() = Vec2i { VkPhysicalDeviceLimits.nmaxViewportDimensions(adr, it) }
inline val VkPhysicalDeviceLimits.viewportBoundsRange: Vec2
    get() = Vec2 { VkPhysicalDeviceLimits.nviewportBoundsRange(adr, it) }
inline val VkPhysicalDeviceLimits.viewportSubPixelBits
    get() = VkPhysicalDeviceLimits.nviewportSubPixelBits(adr)
inline val VkPhysicalDeviceLimits.minMemoryMapAlignment
    get() = VkPhysicalDeviceLimits.nminMemoryMapAlignment(adr)
inline val VkPhysicalDeviceLimits.minTexelBufferOffsetAlignment: VkDeviceSize
    get() = VkPhysicalDeviceLimits.nminTexelBufferOffsetAlignment(adr)
inline val VkPhysicalDeviceLimits.minUniformBufferOffsetAlignment: VkDeviceSize
    get() = VkPhysicalDeviceLimits.nminUniformBufferOffsetAlignment(adr)
inline val VkPhysicalDeviceLimits.minStorageBufferOffsetAlignment: VkDeviceSize
    get() = VkPhysicalDeviceLimits.nminStorageBufferOffsetAlignment(adr)
inline val VkPhysicalDeviceLimits.minTexelOffset
    get() = VkPhysicalDeviceLimits.nminTexelOffset(adr)
inline val VkPhysicalDeviceLimits.maxTexelOffset
    get() = VkPhysicalDeviceLimits.nmaxTexelOffset(adr)
inline val VkPhysicalDeviceLimits.minTexelGatherOffset
    get() = VkPhysicalDeviceLimits.nminTexelGatherOffset(adr)
inline val VkPhysicalDeviceLimits.maxTexelGatherOffset
    get() = VkPhysicalDeviceLimits.nmaxTexelGatherOffset(adr)
inline val VkPhysicalDeviceLimits.minInterpolationOffset
    get() = VkPhysicalDeviceLimits.nminInterpolationOffset(adr)
inline val VkPhysicalDeviceLimits.maxInterpolationOffset
    get() = VkPhysicalDeviceLimits.nmaxInterpolationOffset(adr)
inline val VkPhysicalDeviceLimits.subPixelInterpolationOffsetBits
    get() = VkPhysicalDeviceLimits.nsubPixelInterpolationOffsetBits(adr)
inline val VkPhysicalDeviceLimits.maxFramebufferWidth
    get() = VkPhysicalDeviceLimits.nmaxFramebufferWidth(adr)
inline val VkPhysicalDeviceLimits.maxFramebufferHeight
    get() = VkPhysicalDeviceLimits.nmaxFramebufferHeight(adr)
inline val VkPhysicalDeviceLimits.maxFramebufferLayers
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
    get() = VkPhysicalDeviceLimits.noptimalBufferCopyOffsetAlignment(adr)
inline val VkPhysicalDeviceLimits.optimalBufferCopyRowPitchAlignment: VkDeviceSize
    get() = VkPhysicalDeviceLimits.noptimalBufferCopyRowPitchAlignment(adr)
inline val VkPhysicalDeviceLimits.nonCoherentAtomSize: VkDeviceSize
    get() = VkPhysicalDeviceLimits.nnonCoherentAtomSize(adr)

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


inline val VkMemoryType.propertyFlags: VkMemoryPropertyFlags get() = VkMemoryType.npropertyFlags(adr)
inline val VkMemoryType.heapIndex: Int get() = VkMemoryType.nheapIndex(adr)


//typedef struct VkMemoryHeap {
//    VkDeviceSize         size;
//    VkMemoryHeapFlags    flags;
//} VkMemoryHeap;

inline val VkPhysicalDeviceMemoryProperties.memoryTypeCount get() = VkPhysicalDeviceMemoryProperties.nmemoryTypeCount(adr)
inline val VkPhysicalDeviceMemoryProperties.memoryTypes: VkMemoryType.Buffer get() = VkPhysicalDeviceMemoryProperties.nmemoryTypes(adr)
inline val VkPhysicalDeviceMemoryProperties.memoryHeapCount get() = VkPhysicalDeviceMemoryProperties.nmemoryHeapCount(adr)
inline val VkPhysicalDeviceMemoryProperties.memoryHeaps: VkMemoryHeap.Buffer get() = VkPhysicalDeviceMemoryProperties.nmemoryHeaps(adr)


//typedef void (VKAPI_PTR *PFN_vkVoidFunction)(void);

inline var VkDeviceQueueCreateInfo.type: VkStructureType
    get() = VkStructureType of VkDeviceQueueCreateInfo.nsType(adr)
    set(value) = VkDeviceQueueCreateInfo.nsType(adr, value.i)
inline var VkDeviceQueueCreateInfo.next
    get() = VkDeviceQueueCreateInfo.npNext(adr)
    set(value) = VkDeviceQueueCreateInfo.npNext(adr, value)
inline var VkDeviceQueueCreateInfo.flag: VkDeviceQueueCreate
    get() = TODO()
    set(value) = VkDeviceQueueCreateInfo.nflags(adr, value.i)
inline var VkDeviceQueueCreateInfo.flags: VkDeviceQueueCreateFlags
    get() = VkDeviceQueueCreateInfo.nflags(adr)
    set(value) = VkDeviceQueueCreateInfo.nflags(adr, value)
inline var VkDeviceQueueCreateInfo.queueFamilyIndex
    get() = VkDeviceQueueCreateInfo.nqueueFamilyIndex(adr)
    set(value) = VkDeviceQueueCreateInfo.nqueueFamilyIndex(adr, value)
//inline val VkDeviceQueueCreateInfo.queueCount get() = VkDeviceQueueCreateInfo.nqueueCount(address)
inline var VkDeviceQueueCreateInfo.queuePriorities: FloatBuffer
    get() = VkDeviceQueueCreateInfo.npQueuePriorities(adr)
    set(value) = VkDeviceQueueCreateInfo.npQueuePriorities(adr, value)
/** JVM custom */
inline var VkDeviceQueueCreateInfo.queuePriority: Float
    get() = VkDeviceQueueCreateInfo.npQueuePriorities(adr)[0]
    set(value) {
        val buf = appBuffer floatBufferOf value
        VkDeviceQueueCreateInfo.npQueuePriorities(adr, buf)
    }

//typedef struct VkDeviceQueueCreateInfo {
//    VkStructureType             sType;
//    const void*                 pNext;
//    VkDeviceQueueCreateFlags    flags;
//    uint32_t                    queueFamilyIndex;
//    uint32_t                    queueCount;
//    const float*                pQueuePriorities;
//} VkDeviceQueueCreateInfo;

inline var VkDeviceCreateInfo.type: VkStructureType
    get() = VkStructureType of VkDeviceCreateInfo.nsType(adr)
    set(value) = VkDeviceCreateInfo.nsType(adr, value.i)
inline var VkDeviceCreateInfo.next
    get() = VkDeviceCreateInfo.npNext(adr)
    set(value) = VkDeviceCreateInfo.npNext(adr, value)
inline var VkDeviceCreateInfo.flags: VkDeviceCreateFlags
    get() = VkDeviceCreateInfo.nflags(adr)
    set(value) = VkDeviceCreateInfo.nflags(adr, value)
//inline val VkDeviceCreateInfo.queueCreateInfoCount get() = queueCreateInfoCount()
inline var VkDeviceCreateInfo.queueCreateInfos: VkDeviceQueueCreateInfo.Buffer
    get() = VkDeviceCreateInfo.npQueueCreateInfos(adr)
    set(value) = VkDeviceCreateInfo.npQueueCreateInfos(adr, value)
/** JVM custom */
inline var VkDeviceCreateInfo.queueCreateInfo: VkDeviceQueueCreateInfo
    get() = VkDeviceCreateInfo.npQueueCreateInfos(adr)[0]
    set(value) {
        memPutAddress(adr + VkDeviceCreateInfo.PQUEUECREATEINFOS, value.adr)
        VkDeviceCreateInfo.nqueueCreateInfoCount(adr, 1)
    }
inline var VkDeviceCreateInfo.enabledLayerNames: Collection<String>
    get() = VkDeviceCreateInfo.nppEnabledLayerNames(adr).toArrayList()
    set(value) = VkDeviceCreateInfo.nppEnabledLayerNames(adr, value.toPointerBuffer())
inline var VkDeviceCreateInfo.enabledExtensionNames: Collection<String>
    get() = VkDeviceCreateInfo.nppEnabledExtensionNames(adr).toArrayList()
    set(value) = VkDeviceCreateInfo.nppEnabledExtensionNames(adr, value.toPointerBuffer())
inline var VkDeviceCreateInfo.enabledFeatures: VkPhysicalDeviceFeatures?
    get() = VkDeviceCreateInfo.npEnabledFeatures(adr)
    set(value) = VkDeviceCreateInfo.npEnabledFeatures(adr, value)

//
//typedef struct VkExtensionProperties {
//    char        extensionName[VK_MAX_EXTENSION_NAME_SIZE];
//    uint32_t    specVersion;
//} VkExtensionProperties;
//
//typedef struct VkLayerProperties {
//    char        layerName[VK_MAX_EXTENSION_NAME_SIZE];
//    uint32_t    specVersion;
//    uint32_t    implementationVersion;
//    char        description[VK_MAX_DESCRIPTION_SIZE];
//} VkLayerProperties;

inline var VkSubmitInfo.type: VkStructureType
    get() = VkStructureType of VkSubmitInfo.nsType(adr)
    set(value) = VkSubmitInfo.nsType(adr, value.i)
inline var VkSubmitInfo.next
    get() = VkSubmitInfo.npNext(adr)
    set(value) = VkSubmitInfo.npNext(adr, value)
inline var VkSubmitInfo.waitSemaphoreCount
    get() = VkSubmitInfo.nwaitSemaphoreCount(adr)
    set(value) = VkSubmitInfo.nwaitSemaphoreCount(adr, value)
inline var VkSubmitInfo.waitSemaphores
    get() = VkSubmitInfo.npWaitSemaphores(adr)
    set(value) = VkSubmitInfo.npWaitSemaphores(adr, value)
/** JVM custom */
inline var VkSubmitInfo.waitSemaphore: VkSemaphore
    get() = VkSubmitInfo.npWaitSemaphores(adr)?.get(0) ?: NULL
    set(value) {
        val pSemaphore = appBuffer.long
        memPutLong(pSemaphore, value)
        memPutAddress(adr + VkSubmitInfo.PWAITSEMAPHORES, pSemaphore)
    }
inline var VkSubmitInfo.waitDstStageMask: IntBuffer?
    get() = VkSubmitInfo.npWaitDstStageMask(adr)
    set(value) = VkSubmitInfo.npWaitDstStageMask(adr, value)
//inline val VkSubmitInfo.commandBufferCount get() = VkSubmitInfo.ncommandBufferCount(address)
inline var VkSubmitInfo.commandBuffers: PointerBuffer?
    get() = VkSubmitInfo.npCommandBuffers(adr)
    set(value) = VkSubmitInfo.npCommandBuffers(adr, value)
/** JVM custom */
inline var VkSubmitInfo.commandBuffer: VkCommandBuffer?
    get() = null
    set(value) {
        val pCmdBuff = appBuffer.pointer
        memPutAddress(pCmdBuff, value?.adr ?: NULL)
        memPutAddress(adr + VkSubmitInfo.PCOMMANDBUFFERS, pCmdBuff)
        VkSubmitInfo.ncommandBufferCount(adr, if (value == null) 0 else 1)
    }
//inline val VkSubmitInfo.signalSemaphoreCount get() = VkSubmitInfo.nsignalSemaphoreCount(address)
inline var VkSubmitInfo.signalSemaphores: LongBuffer?
    get() = VkSubmitInfo.npSignalSemaphores(adr)
    set(value) = VkSubmitInfo.npSignalSemaphores(adr, value)
/** JVM custom */
inline var VkSubmitInfo.signalSemaphore: VkSemaphore
    get() = VkSubmitInfo.npSignalSemaphores(adr)?.get(0) ?: NULL
    set(value) {
        val pSemaphore = appBuffer.long
        memPutLong(pSemaphore, value)
        memPutAddress(adr + VkSubmitInfo.PSIGNALSEMAPHORES, pSemaphore)
        VkSubmitInfo.nsignalSemaphoreCount(adr, if (value == NULL) 0 else 1)
    }

//typedef struct VkSubmitInfo {
//    VkStructureType                sType;
//    const void*                    pNext;
//    uint32_t                       waitSemaphoreCount;
//    const VkSemaphore*             pWaitSemaphores;
//    const VkPipelineStageFlags*    pWaitDstStageMask;
//    uint32_t                       commandBufferCount;
//    const VkCommandBuffer*         pCommandBuffers;
//    uint32_t                       signalSemaphoreCount;
//    const VkSemaphore*             pSignalSemaphores;
//} VkSubmitInfo;


inline var VkMemoryAllocateInfo.type: VkStructureType
    get() = VkStructureType of VkMemoryAllocateInfo.nsType(adr)
    set(value) = VkMemoryAllocateInfo.nsType(adr, value.i)
inline var VkMemoryAllocateInfo.next
    get() = VkMemoryAllocateInfo.npNext(adr)
    set(value) = VkMemoryAllocateInfo.npNext(adr, value)
inline var VkMemoryAllocateInfo.allocationSize: VkDeviceSize
    get() = VkMemoryAllocateInfo.nallocationSize(adr)
    set(value) = VkMemoryAllocateInfo.nallocationSize(adr, value)
inline var VkMemoryAllocateInfo.memoryTypeIndex
    get() = VkMemoryAllocateInfo.nmemoryTypeIndex(adr)
    set(value) = VkMemoryAllocateInfo.nmemoryTypeIndex(adr, value)


inline var VkMappedMemoryRange.type: VkStructureType
    get() = VkStructureType of VkMappedMemoryRange.nsType(adr)
    set(value) = VkMappedMemoryRange.nsType(adr, value.i)
inline var VkMappedMemoryRange.next
    get() = VkMappedMemoryRange.npNext(adr)
    set(value) = VkMappedMemoryRange.npNext(adr, value)
inline var VkMappedMemoryRange.memory: VkDeviceMemory
    get() = VkMappedMemoryRange.nmemory(adr)
    set(value) = VkMappedMemoryRange.nmemory(adr, value)
inline var VkMappedMemoryRange.offset: VkDeviceSize
    get() = VkMappedMemoryRange.noffset(adr)
    set(value) = VkMappedMemoryRange.noffset(adr, value)
inline var VkMappedMemoryRange.size: VkDeviceSize
    get() = VkMappedMemoryRange.nsize(adr)
    set(value) = VkMappedMemoryRange.nsize(adr, value)


inline val VkMemoryRequirements.size: VkDeviceSize get() = VkMemoryRequirements.nsize(adr)
inline val VkMemoryRequirements.alignment: VkDeviceSize get() = VkMemoryRequirements.nalignment(adr)
inline val VkMemoryRequirements.memoryTypeBits get() = VkMemoryRequirements.nmemoryTypeBits(adr)


//typedef struct VkSparseImageFormatProperties {
//    VkImageAspectFlags          aspectMask;
//    VkExtent3D                  imageGranularity;
//    VkSparseImageFormatFlags    flags;
//} VkSparseImageFormatProperties;
//
//typedef struct VkSparseImageMemoryRequirements {
//    VkSparseImageFormatProperties    formatProperties;
//    uint32_t                         imageMipTailFirstLod;
//    VkDeviceSize                     imageMipTailSize;
//    VkDeviceSize                     imageMipTailOffset;
//    VkDeviceSize                     imageMipTailStride;
//} VkSparseImageMemoryRequirements;
//
//typedef struct VkSparseMemoryBind {
//    VkDeviceSize               resourceOffset;
//    VkDeviceSize               size;
//    VkDeviceMemory             memory;
//    VkDeviceSize               memoryOffset;
//    VkSparseMemoryBindFlags    flags;
//} VkSparseMemoryBind;
//
//typedef struct VkSparseBufferMemoryBindInfo {
//    VkBuffer                     buffer;
//    uint32_t                     bindCount;
//    const VkSparseMemoryBind*    pBinds;
//} VkSparseBufferMemoryBindInfo;
//
//typedef struct VkSparseImageOpaqueMemoryBindInfo {
//    VkImage                      image;
//    uint32_t                     bindCount;
//    const VkSparseMemoryBind*    pBinds;
//} VkSparseImageOpaqueMemoryBindInfo;

inline var VkImageSubresource.aspectMask: VkImageAspectFlags
    get() = VkImageSubresource.naspectMask(adr)
    set(value) = VkImageSubresource.naspectMask(adr, value.i)
inline var VkImageSubresource.mipLevel: Int
    get() = VkImageSubresource.nmipLevel(adr)
    set(value) = VkImageSubresource.nmipLevel(adr, value)
inline var VkImageSubresource.arrayLayer: Int
    get() = VkImageSubresource.narrayLayer(adr)
    set(value) = VkImageSubresource.narrayLayer(adr, value)

//typedef struct VkOffset3D {
//    int32_t    x;
//    int32_t    y;
//    int32_t    z;
//} VkOffset3D;
//
//typedef struct VkSparseImageMemoryBind {
//    VkImageSubresource         subresource;
//    VkOffset3D                 offset;
//    VkExtent3D                 extent;
//    VkDeviceMemory             memory;
//    VkDeviceSize               memoryOffset;
//    VkSparseMemoryBindFlags    flags;
//} VkSparseImageMemoryBind;
//
//typedef struct VkSparseImageMemoryBindInfo {
//    VkImage                           image;
//    uint32_t                          bindCount;
//    const VkSparseImageMemoryBind*    pBinds;
//} VkSparseImageMemoryBindInfo;
//
//typedef struct VkBindSparseInfo {
//    VkStructureType                             sType;
//    const void*                                 pNext;
//    uint32_t                                    waitSemaphoreCount;
//    const VkSemaphore*                          pWaitSemaphores;
//    uint32_t                                    bufferBindCount;
//    const VkSparseBufferMemoryBindInfo*         pBufferBinds;
//    uint32_t                                    imageOpaqueBindCount;
//    const VkSparseImageOpaqueMemoryBindInfo*    pImageOpaqueBinds;
//    uint32_t                                    imageBindCount;
//    const VkSparseImageMemoryBindInfo*          pImageBinds;
//    uint32_t                                    signalSemaphoreCount;
//    const VkSemaphore*                          pSignalSemaphores;
//} VkBindSparseInfo;

inline var VkFenceCreateInfo.type: VkStructureType
    get() = VkStructureType of VkFenceCreateInfo.nsType(adr)
    set(value) = VkFenceCreateInfo.nsType(adr, value.i)
inline var VkFenceCreateInfo.next
    get() = VkFenceCreateInfo.npNext(adr)
    set(value) = VkFenceCreateInfo.npNext(adr, value)
inline var VkFenceCreateInfo.flags: VkFenceCreateFlags
    get() = VkFenceCreateInfo.nflags(adr)
    set(value) = VkFenceCreateInfo.nflags(adr, value)


inline var VkSemaphoreCreateInfo.type: VkStructureType
    get() = VkStructureType of VkSemaphoreCreateInfo.nsType(adr)
    set(value) = VkSemaphoreCreateInfo.nsType(adr, value.i)
inline var VkSemaphoreCreateInfo.next
    get() = VkSemaphoreCreateInfo.npNext(adr)
    set(value) = VkSemaphoreCreateInfo.npNext(adr, value)
inline var VkSemaphoreCreateInfo.flags: VkSemaphoreCreateFlags
    get() = VkSemaphoreCreateInfo.nflags(adr)
    set(value) = VkSemaphoreCreateInfo.nflags(adr, value)


//typedef struct VkSemaphoreCreateInfo {
//    VkStructureType           sType;
//    const void*               pNext;
//    VkSemaphoreCreateFlags    flags;
//} VkSemaphoreCreateInfo;
//
//typedef struct VkEventCreateInfo {
//    VkStructureType       sType;
//    const void*           pNext;
//    VkEventCreateFlags    flags;
//} VkEventCreateInfo;


inline var VkQueryPoolCreateInfo.type: VkStructureType
    get() = VkStructureType of VkQueryPoolCreateInfo.nsType(adr)
    set(value) = VkQueryPoolCreateInfo.nsType(adr, value.i)
inline var VkQueryPoolCreateInfo.next
    get() = VkQueryPoolCreateInfo.npNext(adr)
    set(value) = VkQueryPoolCreateInfo.npNext(adr, value)
inline var VkQueryPoolCreateInfo.flags: VkQueryPoolCreateFlags
    get() = VkQueryPoolCreateInfo.nflags(adr)
    set(value) = VkQueryPoolCreateInfo.nflags(adr, value)
inline var VkQueryPoolCreateInfo.queryType: VkQueryType
    get() = VkQueryType of VkQueryPoolCreateInfo.nqueryType(adr)
    set(value) = VkQueryPoolCreateInfo.nqueryType(adr, value.i)
inline var VkQueryPoolCreateInfo.queryCount: Int
    get() = VkQueryPoolCreateInfo.nqueryCount(adr)
    set(value) = VkQueryPoolCreateInfo.nqueryCount(adr, value)
inline var VkQueryPoolCreateInfo.pipelineStatistics: VkQueryPipelineStatisticFlags
    get() = VkQueryPoolCreateInfo.npipelineStatistics(adr)
    set(value) = VkQueryPoolCreateInfo.npipelineStatistics(adr, value)


inline var VkBufferCreateInfo.type: VkStructureType
    get() = VkStructureType of VkBufferCreateInfo.nsType(adr)
    set(value) = VkBufferCreateInfo.nsType(adr, value.i)
inline var VkBufferCreateInfo.next
    get() = VkBufferCreateInfo.npNext(adr)
    set(value) = VkBufferCreateInfo.npNext(adr, value)
/** JVM custom */
inline var VkBufferCreateInfo.flag: VkBufferCreate
    get() = TODO()
    set(value) = VkBufferCreateInfo.nflags(adr, value.i)
inline var VkBufferCreateInfo.flags: VkBufferCreateFlags
    get() = VkBufferCreateInfo.nflags(adr)
    set(value) = VkBufferCreateInfo.nflags(adr, value)
inline var VkBufferCreateInfo.size: VkDeviceSize
    get() = VkBufferCreateInfo.nsize(adr)
    set(value) = VkBufferCreateInfo.nsize(adr, value)
inline var VkBufferCreateInfo.usage: VkBufferUsageFlags
    get() = VkBufferCreateInfo.nusage(adr)
    set(value) = VkBufferCreateInfo.nusage(adr, value)
inline var VkBufferCreateInfo.sharingMode: VkSharingMode
    get() = VkSharingMode of VkBufferCreateInfo.nsharingMode(adr)
    set(value) = VkBufferCreateInfo.nsharingMode(adr, value.i)
inline var VkBufferCreateInfo.queueFamilyIndexCount
    get() = VkBufferCreateInfo.nqueueFamilyIndexCount(adr)
    set(value) = VkBufferCreateInfo.nqueueFamilyIndexCount(adr, value)
inline var VkBufferCreateInfo.queueFamilyIndices
    get() = VkBufferCreateInfo.npQueueFamilyIndices(adr)
    set(value) = VkBufferCreateInfo.npQueueFamilyIndices(adr, value)


//typedef struct VkBufferViewCreateInfo {
//    VkStructureType            sType;
//    const void*                pNext;
//    VkBufferViewCreateFlags    flags;
//    VkBuffer                   buffer;
//    VkFormat                   format;
//    VkDeviceSize               offset;
//    VkDeviceSize               range;
//} VkBufferViewCreateInfo;


inline var VkImageViewCreateInfo.type: VkStructureType
    get() = VkStructureType of VkImageViewCreateInfo.nsType(adr)
    set(value) = VkImageViewCreateInfo.nsType(adr, value.i)
inline var VkImageViewCreateInfo.next
    get() = VkImageViewCreateInfo.npNext(adr)
    set(value) = VkImageViewCreateInfo.npNext(adr, value)
inline var VkImageViewCreateInfo.flags: VkImageViewCreateFlags
    get() = VkImageViewCreateInfo.nflags(adr)
    set(value) = VkImageViewCreateInfo.nflags(adr, value)
inline var VkImageViewCreateInfo.image: VkImage
    get() = VkImageViewCreateInfo.nimage(adr)
    set(value) = VkImageViewCreateInfo.nimage(adr, value)
inline var VkImageViewCreateInfo.viewType: VkImageViewType
    get() = VkImageViewType of VkImageViewCreateInfo.nviewType(adr)
    set(value) = VkImageViewCreateInfo.nviewType(adr, value.i)
inline var VkImageViewCreateInfo.format: VkFormat
    get() = VkFormat of VkImageViewCreateInfo.nformat(adr)
    set(value) = VkImageViewCreateInfo.nformat(adr, value.i)
inline var VkImageViewCreateInfo.components: VkComponentMapping
    get() = VkImageViewCreateInfo.ncomponents(adr)
    set(value) = VkImageViewCreateInfo.ncomponents(adr, value)

/** JVM custom */
inline fun VkImageViewCreateInfo.components(r: VkComponentSwizzle, g: VkComponentSwizzle, b: VkComponentSwizzle, a: VkComponentSwizzle) {
    components.r = r
    components.g = g
    components.b = b
    components.a = a
}

inline var VkImageViewCreateInfo.subresourceRange: VkImageSubresourceRange
    get() = VkImageViewCreateInfo.nsubresourceRange(adr)
    set(value) = VkImageViewCreateInfo.nsubresourceRange(adr, value)


inline var VkImageCreateInfo.type: VkStructureType
    get() = VkStructureType of VkImageCreateInfo.nsType(adr)
    set(value) = VkImageCreateInfo.nsType(adr, value.i)
inline var VkImageCreateInfo.next
    get() = VkImageCreateInfo.npNext(adr)
    set(value) = VkImageCreateInfo.npNext(adr, value)
/** JVM custom */
inline var VkImageCreateInfo.flag: VkImageCreate
    get() = TODO()
    set(value) = VkImageCreateInfo.nflags(adr, value.i)
inline var VkImageCreateInfo.flags: VkImageCreateFlags
    get() = VkImageCreateInfo.nflags(adr)
    set(value) = VkImageCreateInfo.nflags(adr, value)
inline var VkImageCreateInfo.imageType: VkImageType
    get() = VkImageType of VkImageCreateInfo.nimageType(adr)
    set(value) = VkImageCreateInfo.nimageType(adr, value.i)
inline var VkImageCreateInfo.format: VkFormat
    get() = VkFormat of VkImageCreateInfo.nformat(adr)
    set(value) = VkImageCreateInfo.nformat(adr, value.i)
inline var VkImageCreateInfo.extent: VkExtent3D
    get() = VkImageCreateInfo.nextent(adr)
    set(value) = VkImageCreateInfo.nextent(adr, value)

/** JVM custom */
inline fun VkImageCreateInfo.extent(extent: Vec3i) {
    this.extent.set(extent.x, extent.y, extent.z)
}

/** JVM custom */
inline fun VkImageCreateInfo.extent(extent: Vec2i, depth: Int) {
    this.extent.set(extent.x, extent.y, depth)
}

inline var VkImageCreateInfo.mipLevels
    get() = VkImageCreateInfo.nmipLevels(adr)
    set(value) = VkImageCreateInfo.nmipLevels(adr, value)
inline var VkImageCreateInfo.arrayLayers
    get() = VkImageCreateInfo.narrayLayers(adr)
    set(value) = VkImageCreateInfo.narrayLayers(adr, value)
inline var VkImageCreateInfo.samples: VkSampleCount
    get() = VkSampleCount of VkImageCreateInfo.nsamples(adr)
    set(value) = VkImageCreateInfo.nsamples(adr, value.i)
inline var VkImageCreateInfo.tiling: VkImageTiling
    get() = VkImageTiling of VkImageCreateInfo.ntiling(adr)
    set(value) = VkImageCreateInfo.ntiling(adr, value.i)
inline var VkImageCreateInfo.usage: VkImageUsageFlags
    get() = VkImageCreateInfo.nusage(adr)
    set(value) = VkImageCreateInfo.nusage(adr, value)
inline var VkImageCreateInfo.sharingMode: VkSharingMode
    get() = VkSharingMode of VkImageCreateInfo.nsharingMode(adr)
    set(value) = VkImageCreateInfo.nsharingMode(adr, value.i)
//inline val VkImageCreateInfo.queueFamilyIndexCount get() = queueFamilyIndexCount()
inline var VkImageCreateInfo.queueFamilyIndices
    get() = VkImageCreateInfo.npQueueFamilyIndices(adr)
    set(value) = VkImageCreateInfo.npQueueFamilyIndices(adr, value)
inline var VkImageCreateInfo.initialLayout: VkImageLayout
    get() = VkImageLayout of VkImageCreateInfo.ninitialLayout(adr)
    set(value) = VkImageCreateInfo.ninitialLayout(adr, value.i)

//typedef struct VkSubresourceLayout {
//    VkDeviceSize    offset;
//    VkDeviceSize    size;
//    VkDeviceSize    rowPitch;
//    VkDeviceSize    arrayPitch;
//    VkDeviceSize    depthPitch;
//} VkSubresourceLayout;

inline operator fun VkComponentMapping.invoke(r: VkComponentSwizzle, g: VkComponentSwizzle, b: VkComponentSwizzle, a: VkComponentSwizzle) {
    this.r = r
    this.g = g
    this.b = b
    this.a = a
}

inline var VkComponentMapping.r: VkComponentSwizzle
    get() = VkComponentSwizzle of VkComponentMapping.nr(adr)
    set(value) = VkComponentMapping.nr(adr, value.i)
inline var VkComponentMapping.g: VkComponentSwizzle
    get() = VkComponentSwizzle of VkComponentMapping.ng(adr)
    set(value) = VkComponentMapping.ng(adr, value.i)
inline var VkComponentMapping.b: VkComponentSwizzle
    get() = VkComponentSwizzle of VkComponentMapping.nb(adr)
    set(value) = VkComponentMapping.nb(adr, value.i)
inline var VkComponentMapping.a: VkComponentSwizzle
    get() = VkComponentSwizzle of VkComponentMapping.na(adr)
    set(value) = VkComponentMapping.na(adr, value.i)


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

//typedef struct VkImageViewCreateInfo {
//    VkStructureType            sType;
//    const void*                pNext;
//    VkImageViewCreateFlags     flags;
//    VkImage                    image;
//    VkImageViewType            viewType;
//    VkFormat                   format;
//    VkComponentMapping         components;
//    VkImageSubresourceRange    subresourceRange;
//} VkImageViewCreateInfo;

inline var VkShaderModuleCreateInfo.type: VkStructureType
    get() = VkStructureType of VkShaderModuleCreateInfo.nsType(adr)
    set(value) = VkShaderModuleCreateInfo.nsType(adr, value.i)
inline var VkShaderModuleCreateInfo.next
    get() = VkShaderModuleCreateInfo.npNext(adr)
    set(value) = VkShaderModuleCreateInfo.npNext(adr, value)
inline var VkShaderModuleCreateInfo.flags: VkShaderModuleCreateFlags
    get() = VkShaderModuleCreateInfo.nflags(adr)
    set(value) = VkShaderModuleCreateInfo.nflags(adr, value)
//inline val VkShaderModuleCreateInfo.codeSize get() = VkShaderModuleCreateInfo.ncodeSize(adr)
inline var VkShaderModuleCreateInfo.code: ByteBuffer
    get() = VkShaderModuleCreateInfo.npCode(adr)
    set(value) = VkShaderModuleCreateInfo.npCode(adr, value)


inline var VkPipelineCacheCreateInfo.type: VkStructureType
    get() = VkStructureType of VkPipelineCacheCreateInfo.nsType(adr)
    set(value) = VkPipelineCacheCreateInfo.nsType(adr, value.i)
inline var VkPipelineCacheCreateInfo.next
    get() = VkPipelineCacheCreateInfo.npNext(adr)
    set(value) = VkPipelineCacheCreateInfo.npNext(adr, value)
inline var VkPipelineCacheCreateInfo.flags: VkPipelineCacheCreateFlags
    get() = VkPipelineCacheCreateInfo.nflags(adr)
    set(value) = VkPipelineCacheCreateInfo.nflags(adr, value)
inline val VkPipelineCacheCreateInfo.initialDataSize get() = initialDataSize()
inline var VkPipelineCacheCreateInfo.initialData
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


//inline val VkSpecializationInfo.mapEntryCount: Int get() = VkSpecializationInfo.nmapEntryCount(adr)
inline var VkSpecializationInfo.mapEntries: VkSpecializationMapEntry.Buffer?
    get() = VkSpecializationInfo.npMapEntries(adr)
    set(value) = VkSpecializationInfo.npMapEntries(adr, value)
/** JVM custom */
inline var VkSpecializationInfo.mapEntry: VkSpecializationMapEntry?
    get() = VkSpecializationInfo.npMapEntries(adr)?.get(0)
    set(value) {
        memPutAddress(adr + VkSpecializationInfo.PMAPENTRIES, memAddressSafe(value))
        VkSpecializationInfo.nmapEntryCount(adr, if (value == null) 0 else 1)
    }
//inline val VkSpecializationInfo.dataSize: Long get() = VkSpecializationInfo.ndataSize(adr)
inline var VkSpecializationInfo.data: ByteBuffer?
    get() = VkSpecializationInfo.npData(adr)
    set(value) = VkSpecializationInfo.npData(adr, value)


//typedef struct VkSpecializationInfo {
//    uint32_t                           mapEntryCount;
//    const VkSpecializationMapEntry*    pMapEntries;
//    size_t                             dataSize;
//    const void*                        pData;
//} VkSpecializationInfo;


inline var VkPipelineShaderStageCreateInfo.type: VkStructureType
    get() = VkStructureType of VkPipelineShaderStageCreateInfo.nsType(adr)
    set(value) = VkPipelineShaderStageCreateInfo.nsType(adr, value.i)
inline var VkPipelineShaderStageCreateInfo.next
    get() = VkPipelineShaderStageCreateInfo.npNext(adr)
    set(value) = VkPipelineShaderStageCreateInfo.npNext(adr, value)
inline var VkPipelineShaderStageCreateInfo.flags: VkPipelineShaderStageCreateFlags
    get() = VkPipelineShaderStageCreateInfo.nflags(adr)
    set(value) = VkPipelineShaderStageCreateInfo.nflags(adr, value)
inline var VkPipelineShaderStageCreateInfo.stage: VkShaderStage
    get() = VkShaderStage of VkPipelineShaderStageCreateInfo.nstage(adr)
    set(value) = VkPipelineShaderStageCreateInfo.nstage(adr, value.i)
inline var VkPipelineShaderStageCreateInfo.module: VkShaderModule
    get() = VkPipelineShaderStageCreateInfo.nmodule(adr)
    set(value) = VkPipelineShaderStageCreateInfo.nmodule(adr, value)
inline var VkPipelineShaderStageCreateInfo.name: String
    get() = VkPipelineShaderStageCreateInfo.npNameString(adr)
    set(value) = VkPipelineShaderStageCreateInfo.npName(adr, value.utf8)
inline var VkPipelineShaderStageCreateInfo.specializationInfo
    get() = VkPipelineShaderStageCreateInfo.npSpecializationInfo(adr)
    set(value) = VkPipelineShaderStageCreateInfo.npSpecializationInfo(adr, value)


inline var VkVertexInputBindingDescription.binding
    get() = VkVertexInputBindingDescription.nbinding(adr)
    set(value) = VkVertexInputBindingDescription.nbinding(adr, value)
inline var VkVertexInputBindingDescription.stride
    get() = VkVertexInputBindingDescription.nstride(adr)
    set(value) = VkVertexInputBindingDescription.nstride(adr, value)
inline var VkVertexInputBindingDescription.inputRate: VkVertexInputRate
    get() = VkVertexInputRate of VkVertexInputBindingDescription.ninputRate(adr)
    set(value) = VkVertexInputBindingDescription.ninputRate(adr, value.i)


inline var VkVertexInputAttributeDescription.location
    get() = VkVertexInputAttributeDescription.nlocation(adr)
    set(value) = VkVertexInputAttributeDescription.nlocation(adr, value)
inline var VkVertexInputAttributeDescription.binding
    get() = VkVertexInputAttributeDescription.nbinding(adr)
    set(value) = VkVertexInputAttributeDescription.nbinding(adr, value)
inline var VkVertexInputAttributeDescription.format: VkFormat
    get() = VkFormat of VkVertexInputAttributeDescription.nformat(adr)
    set(value) = VkVertexInputAttributeDescription.nformat(adr, value.i)
inline var VkVertexInputAttributeDescription.offset
    get() = VkVertexInputAttributeDescription.noffset(adr)
    set(value) = VkVertexInputAttributeDescription.noffset(adr, value)


inline var VkPipelineVertexInputStateCreateInfo.type: VkStructureType
    get() = VkStructureType of VkPipelineVertexInputStateCreateInfo.nsType(adr)
    set(value) {
        sType(value.i)
    }
inline var VkPipelineVertexInputStateCreateInfo.next
    get() = VkPipelineVertexInputStateCreateInfo.npNext(adr)
    set(value) = VkPipelineVertexInputStateCreateInfo.npNext(adr, value)
inline var VkPipelineVertexInputStateCreateInfo.flags: VkPipelineVertexInputStateCreateFlags
    get() = VkPipelineVertexInputStateCreateInfo.nflags(adr)
    set(value) = VkPipelineVertexInputStateCreateInfo.nflags(adr, value)
//inline val VkPipelineVertexInputStateCreateInfo.vertexBindingDescriptionCount get() = VkPipelineVertexInputStateCreateInfo.nvertexBindingDescriptionCount(adr)
inline var VkPipelineVertexInputStateCreateInfo.vertexBindingDescriptions: VkVertexInputBindingDescription.Buffer?
    get() = VkPipelineVertexInputStateCreateInfo.npVertexBindingDescriptions(adr)
    set(value) = VkPipelineVertexInputStateCreateInfo.npVertexBindingDescriptions(adr, value)
/** JVM custom */
inline var VkPipelineVertexInputStateCreateInfo.vertexBindingDescription: VkVertexInputBindingDescription?
    get() = VkVertexInputBindingDescription.createSafe(memGetAddress(adr + VkPipelineVertexInputStateCreateInfo.PVERTEXBINDINGDESCRIPTIONS))
    set(value) {
        memPutAddress(adr + VkPipelineVertexInputStateCreateInfo.PVERTEXBINDINGDESCRIPTIONS, memAddressSafe(value))
        VkPipelineVertexInputStateCreateInfo.nvertexBindingDescriptionCount(adr, if (value == null) 0 else 1)
    }
//inline val VkPipelineVertexInputStateCreateInfo.vertexAttributeDescriptionCount get() = VkPipelineVertexInputStateCreateInfo.nvertexAttributeDescriptionCount(adr)
inline var VkPipelineVertexInputStateCreateInfo.vertexAttributeDescriptions: VkVertexInputAttributeDescription.Buffer?
    get() = VkPipelineVertexInputStateCreateInfo.npVertexAttributeDescriptions(adr)
    set(value) = VkPipelineVertexInputStateCreateInfo.npVertexAttributeDescriptions(adr, value)


inline var VkPipelineInputAssemblyStateCreateInfo.type: VkStructureType
    get() = VkStructureType of VkPipelineInputAssemblyStateCreateInfo.nsType(adr)
    set(value) = VkPipelineInputAssemblyStateCreateInfo.nsType(adr, value.i)
inline var VkPipelineInputAssemblyStateCreateInfo.next
    get() = VkPipelineInputAssemblyStateCreateInfo.npNext(adr)
    set(value) = VkPipelineInputAssemblyStateCreateInfo.npNext(adr, value)
inline var VkPipelineInputAssemblyStateCreateInfo.flags: VkPipelineInputAssemblyStateCreateFlags
    get() = VkPipelineInputAssemblyStateCreateInfo.nflags(adr)
    set(value) = VkPipelineInputAssemblyStateCreateInfo.nflags(adr, value)
inline var VkPipelineInputAssemblyStateCreateInfo.topology: VkPrimitiveTopology
    get() = VkPrimitiveTopology of VkPipelineInputAssemblyStateCreateInfo.ntopology(adr)
    set(value) = VkPipelineInputAssemblyStateCreateInfo.ntopology(adr, value.i)
inline var VkPipelineInputAssemblyStateCreateInfo.primitiveRestartEnable
    get() = VkPipelineInputAssemblyStateCreateInfo.nprimitiveRestartEnable(adr).bool
    set(value) = VkPipelineInputAssemblyStateCreateInfo.nprimitiveRestartEnable(adr, value.i)

//typedef struct VkPipelineInputAssemblyStateCreateInfo {
//    VkStructureType                            sType;
//    const void*                                pNext;
//    VkPipelineInputAssemblyStateCreateFlags    flags;
//    VkPrimitiveTopology                        topology;
//    VkBool32                                   primitiveRestartEnable;
//} VkPipelineInputAssemblyStateCreateInfo;
//
//typedef struct VkPipelineTessellationStateCreateInfo {
//    VkStructureType                           sType;
//    const void*                               pNext;
//    VkPipelineTessellationStateCreateFlags    flags;
//    uint32_t                                  patchControlPoints;
//} VkPipelineTessellationStateCreateInfo;


inline var VkViewport.x: Float
    get() = VkViewport.nx(adr)
    set(value) = VkViewport.nx(adr, value)
inline var VkViewport.y: Float
    get() = VkViewport.ny(adr)
    set(value) = VkViewport.ny(adr, value)
inline var VkViewport.width: Float
    get() = VkViewport.nwidth(adr)
    set(value) = VkViewport.nwidth(adr, value)
inline var VkViewport.height: Float
    get() = VkViewport.nheight(adr)
    set(value) = VkViewport.nheight(adr, value)
inline var VkViewport.minDepth: Float
    get() = VkViewport.nminDepth(adr)
    set(value) = VkViewport.nminDepth(adr, value)
inline var VkViewport.maxDepth: Float
    get() = VkViewport.nmaxDepth(adr)
    set(value) = VkViewport.nmaxDepth(adr, value)

/** JVM custom */
inline fun VkViewport.offset(f: Float) = offset(f, f)

/** JVM custom */
inline fun VkViewport.offset(x: Float, y: Float) {
    this.x = x
    this.y = y
}

/** JVM custom */
inline fun VkViewport.size(size: Vec2i) {
    width = size.x.f
    height = size.y.f
}

/** JVM custom */
inline fun VkViewport.depth(minDepth: Float, maxDepth: Float) {
    this.minDepth = minDepth
    this.maxDepth = maxDepth
}
//inline var VkViewport.pos
//    get() = Vec2(x, y)
//    set(value) {
//        x = value.x
//        y = value.y
//    }
//inline fun VkViewport.size(size: Vec2t<out Number>) { TODO BUG
//    width = size.x.f
//    height = size.y.f
//}

//inline var VkViewport.size
//    get() = Vec2(width, height)
//    set(value) {
//        width = value.x
//        height = value.y
//    }
//inline fun VkViewport.depth(min: Float, max: Float) { TODO BUG
//    minDepth = min
//    maxDepth = max
//}
//inline var VkViewport.depth
//    get() = Vec2(minDepth, maxDepth)
//    set(value) {
//        minDepth = value.x
//        maxDepth = value.y
//    }


inline var VkOffset2D.x
    get() = VkOffset2D.nx(adr)
    set(value) = VkOffset2D.nx(adr, value)
inline var VkOffset2D.y
    get() = VkOffset2D.ny(adr)
    set(value) = VkOffset2D.ny(adr, value)
//inline operator fun VkOffset2D.invoke(size: Vec2i) {
//    x = size.x
//    y = size.y
//}
//inline operator fun VkOffset2D.invoke(x: Int, y: Int) {
//    this.x = x
//    this.y = y
//}


inline var VkExtent2D.width
    get() = VkExtent2D.nwidth(adr)
    set(value) = VkExtent2D.nwidth(adr, value)
inline var VkExtent2D.height
    get() = VkExtent2D.nheight(adr)
    set(value) = VkExtent2D.nheight(adr, value)

//var VkExtent2D.size BUG
//    get() = Vec2i(width, height)
//    set(value) {
//        width = value.x
//        height = value.y
//    }
inline fun VkOffset2D.pos(x: Int, y: Int) {
    this.x = x
    this.y = y
}

//inline var VkOffset2D.pos BUG
//    get() = Vec2i(x, y)
//    set(value) {
//        x = value.x
//        y = value.y
//    }
inline var VkExtent3D.width
    get() = width()
    set(value) {
        width(value)
    }
inline var VkExtent3D.height
    get() = height()
    set(value) {
        height(value)
    }
inline var VkExtent3D.depth
    get() = depth()
    set(value) {
        depth(value)
    }

inline fun VkExtent3D.size(x: Int, y: Int, z: Int) {
    width = x
    height = y
    depth = z
}
//inline var VkExtent3D.size
//    get() = Vec3i(width, height, depth)
//    set(value) {
//        width = value.x
//        height = value.y
//        depth = value.z
//    } TODO BUG


inline var VkRect2D.offset: VkOffset2D
    get() = VkRect2D.noffset(adr)
    set(value) = VkRect2D.noffset(adr, value)
inline var VkRect2D.extent: VkExtent2D
    get() = VkRect2D.nextent(adr)
    set(value) = VkRect2D.nextent(adr, value)

/** JVM custom */
inline fun VkRect2D.offset(offset: Int) = offset(offset, offset)

/** JVM custom */
inline fun VkRect2D.offset(x: Int, y: Int) {
    offset.x = x
    offset.y = y
}

/** JVM custom */
inline fun VkRect2D.extent(size: Vec2i) = extent(size.x, size.y)

/** JVM custom */
inline fun VkRect2D.extent(width: Int, height: Int) {
    extent.width = width
    extent.height = height
}

/** JVM custom */
inline fun VkRect2D.extent(width: Number, height: Number) = extent(width.i, height.i)
/** JVM custom */
inline fun VkRect2D.offset(width: Number, height: Number) = offset(width.i, height.i)


inline var VkPipelineViewportStateCreateInfo.type: VkStructureType
    get() = VkStructureType of VkPipelineViewportStateCreateInfo.nsType(adr)
    set(value) = VkPipelineViewportStateCreateInfo.nsType(adr, value.i)
inline var VkPipelineViewportStateCreateInfo.next
    get() = VkPipelineViewportStateCreateInfo.npNext(adr)
    set(value) = VkPipelineViewportStateCreateInfo.npNext(adr, value)
inline var VkPipelineViewportStateCreateInfo.flags: VkPipelineViewportStateCreateFlags
    get() = VkPipelineViewportStateCreateInfo.nflags(adr)
    set(value) = VkPipelineViewportStateCreateInfo.nflags(adr, value)
inline var VkPipelineViewportStateCreateInfo.viewportCount
    get() = VkPipelineViewportStateCreateInfo.nviewportCount(adr)
    set(value) = VkPipelineViewportStateCreateInfo.nviewportCount(adr, value)
inline var VkPipelineViewportStateCreateInfo.viewports
    get() = VkPipelineViewportStateCreateInfo.npViewports(adr)
    set(value) = VkPipelineViewportStateCreateInfo.npViewports(adr, value)
inline var VkPipelineViewportStateCreateInfo.scissorCount
    get() = VkPipelineViewportStateCreateInfo.nscissorCount(adr)
    set(value) = VkPipelineViewportStateCreateInfo.nscissorCount(adr, value)
inline var VkPipelineViewportStateCreateInfo.scissors
    get() = VkPipelineViewportStateCreateInfo.npScissors(adr)
    set(value) = VkPipelineViewportStateCreateInfo.npScissors(adr, value)


inline var VkPipelineRasterizationStateCreateInfo.type: VkStructureType
    get() = VkStructureType of VkPipelineRasterizationStateCreateInfo.nsType(adr)
    set(value) = VkPipelineRasterizationStateCreateInfo.nsType(adr, value.i)
inline var VkPipelineRasterizationStateCreateInfo.next
    get() = VkPipelineRasterizationStateCreateInfo.npNext(adr)
    set(value) = VkPipelineRasterizationStateCreateInfo.npNext(adr, value)
inline var VkPipelineRasterizationStateCreateInfo.flags: VkPipelineRasterizationStateCreateFlags
    get() = VkPipelineRasterizationStateCreateInfo.nflags(adr)
    set(value) = VkPipelineRasterizationStateCreateInfo.nflags(adr, value)
inline var VkPipelineRasterizationStateCreateInfo.depthClampEnable
    get() = VkPipelineRasterizationStateCreateInfo.ndepthClampEnable(adr).bool
    set(value) = VkPipelineRasterizationStateCreateInfo.ndepthClampEnable(adr, value.i)
inline var VkPipelineRasterizationStateCreateInfo.rasterizerDiscardEnable
    get() = VkPipelineRasterizationStateCreateInfo.nrasterizerDiscardEnable(adr).bool
    set(value) = VkPipelineRasterizationStateCreateInfo.nrasterizerDiscardEnable(adr, value.i)
inline var VkPipelineRasterizationStateCreateInfo.polygonMode: VkPolygonMode
    get() = VkPolygonMode of VkPipelineRasterizationStateCreateInfo.npolygonMode(adr)
    set(value) = VkPipelineRasterizationStateCreateInfo.npolygonMode(adr, value.i)
inline var VkPipelineRasterizationStateCreateInfo.cullMode: VkCullModeFlags
    get() = VkPipelineRasterizationStateCreateInfo.ncullMode(adr)
    set(value) = VkPipelineRasterizationStateCreateInfo.ncullMode(adr, value)
inline var VkPipelineRasterizationStateCreateInfo.frontFace: VkFrontFace
    get() = VkFrontFace of VkPipelineRasterizationStateCreateInfo.nfrontFace(adr)
    set(value) = VkPipelineRasterizationStateCreateInfo.nfrontFace(adr, value.i)
inline var VkPipelineRasterizationStateCreateInfo.depthBiasEnable
    get() = VkPipelineRasterizationStateCreateInfo.ndepthBiasEnable(adr).bool
    set(value) = VkPipelineRasterizationStateCreateInfo.ndepthBiasEnable(adr, value.i)
inline var VkPipelineRasterizationStateCreateInfo.depthBiasConstantFactor
    get() = VkPipelineRasterizationStateCreateInfo.ndepthBiasConstantFactor(adr)
    set(value) = VkPipelineRasterizationStateCreateInfo.ndepthBiasConstantFactor(adr, value)
inline var VkPipelineRasterizationStateCreateInfo.depthBiasClamp
    get() = VkPipelineRasterizationStateCreateInfo.ndepthBiasClamp(adr)
    set(value) = VkPipelineRasterizationStateCreateInfo.ndepthBiasClamp(adr, value)
inline var VkPipelineRasterizationStateCreateInfo.depthBiasSlopeFactor
    get() = VkPipelineRasterizationStateCreateInfo.ndepthBiasSlopeFactor(adr)
    set(value) = VkPipelineRasterizationStateCreateInfo.ndepthBiasSlopeFactor(adr, value)
inline var VkPipelineRasterizationStateCreateInfo.lineWidth
    get() = VkPipelineRasterizationStateCreateInfo.nlineWidth(adr)
    set(value) = VkPipelineRasterizationStateCreateInfo.nlineWidth(adr, value)


inline var VkPipelineMultisampleStateCreateInfo.type: VkStructureType
    get() = VkStructureType of VkPipelineMultisampleStateCreateInfo.nsType(adr)
    set(value) = VkPipelineMultisampleStateCreateInfo.nsType(adr, value.i)
inline var VkPipelineMultisampleStateCreateInfo.next
    get() = VkPipelineMultisampleStateCreateInfo.npNext(adr)
    set(value) = VkPipelineMultisampleStateCreateInfo.npNext(adr, value)
inline var VkPipelineMultisampleStateCreateInfo.flags: VkPipelineMultisampleStateCreateFlags
    get() = VkPipelineMultisampleStateCreateInfo.nflags(adr)
    set(value) = VkPipelineMultisampleStateCreateInfo.nflags(adr, value)
inline var VkPipelineMultisampleStateCreateInfo.rasterizationSamples: VkSampleCount
    get() = VkSampleCount of VkPipelineMultisampleStateCreateInfo.nrasterizationSamples(adr)
    set(value) = VkPipelineMultisampleStateCreateInfo.nrasterizationSamples(adr, value.i)
inline var VkPipelineMultisampleStateCreateInfo.sampleShadingEnable
    get() = VkPipelineMultisampleStateCreateInfo.nsampleShadingEnable(adr).bool
    set(value) = VkPipelineMultisampleStateCreateInfo.nsampleShadingEnable(adr, value.i)
inline var VkPipelineMultisampleStateCreateInfo.minSampleShading
    get() = VkPipelineMultisampleStateCreateInfo.nminSampleShading(adr)
    set(value) = VkPipelineMultisampleStateCreateInfo.nminSampleShading(adr, value)
/** https://stackoverflow.com/a/38863042/1047713 */
inline var VkPipelineMultisampleStateCreateInfo.sampleMask: Int?
    get() = memGetInt(memGetAddress(adr + VkPipelineMultisampleStateCreateInfo.PSAMPLEMASK))
    set(value) {
        val pInt = when {
            value != null -> appBuffer.int.also { memPutInt(it, value) }
            else -> NULL
        }
        memPutAddress(adr + VkPipelineMultisampleStateCreateInfo.PSAMPLEMASK, pInt)
    }
inline var VkPipelineMultisampleStateCreateInfo.alphaToCoverageEnable
    get() = VkPipelineMultisampleStateCreateInfo.nalphaToCoverageEnable(adr).bool
    set(value) = VkPipelineMultisampleStateCreateInfo.nalphaToCoverageEnable(adr, value.i)
inline var VkPipelineMultisampleStateCreateInfo.alphaToOneEnable
    get() = VkPipelineMultisampleStateCreateInfo.nalphaToOneEnable(adr).bool
    set(value) = VkPipelineMultisampleStateCreateInfo.nalphaToOneEnable(adr, value.i)


inline var VkStencilOpState.failOp: VkStencilOp
    get() = VkStencilOp of VkStencilOpState.nfailOp(adr)
    set(value) = VkStencilOpState.nfailOp(adr, value.i)
inline var VkStencilOpState.passOp: VkStencilOp
    get() = VkStencilOp of VkStencilOpState.npassOp(adr)
    set(value) = VkStencilOpState.npassOp(adr, value.i)
inline var VkStencilOpState.depthFailOp: VkStencilOp
    get() = VkStencilOp of VkStencilOpState.ndepthFailOp(adr)
    set(value) = VkStencilOpState.ndepthFailOp(adr, value.i)
inline var VkStencilOpState.compareOp: VkCompareOp
    get() = VkCompareOp of VkStencilOpState.ncompareOp(adr)
    set(value) = VkStencilOpState.ncompareOp(adr, value.i)
inline var VkStencilOpState.compareMask
    get() = VkStencilOpState.ncompareMask(adr)
    set(value) = VkStencilOpState.ncompareMask(adr, value)
inline var VkStencilOpState.writeMask
    get() = VkStencilOpState.nwriteMask(adr)
    set(value) = VkStencilOpState.nwriteMask(adr, value)
inline var VkStencilOpState.reference
    get() = VkStencilOpState.nreference(adr)
    set(value) = VkStencilOpState.nreference(adr, value)


inline var VkPipelineDepthStencilStateCreateInfo.type: VkStructureType
    get() = VkStructureType of VkPipelineDepthStencilStateCreateInfo.nsType(adr)
    set(value) = VkPipelineDepthStencilStateCreateInfo.nsType(adr, value.i)
inline var VkPipelineDepthStencilStateCreateInfo.next
    get() = VkPipelineDepthStencilStateCreateInfo.npNext(adr)
    set(value) = VkPipelineDepthStencilStateCreateInfo.npNext(adr, value)
inline var VkPipelineDepthStencilStateCreateInfo.flags: VkPipelineDepthStencilStateCreateFlags
    get() = VkPipelineDepthStencilStateCreateInfo.nflags(adr)
    set(value) = VkPipelineDepthStencilStateCreateInfo.nflags(adr, value)
inline var VkPipelineDepthStencilStateCreateInfo.depthTestEnable
    get() = VkPipelineDepthStencilStateCreateInfo.ndepthTestEnable(adr).bool
    set(value) = VkPipelineDepthStencilStateCreateInfo.ndepthTestEnable(adr, value.i)
inline var VkPipelineDepthStencilStateCreateInfo.depthWriteEnable
    get() = VkPipelineDepthStencilStateCreateInfo.ndepthWriteEnable(adr).bool
    set(value) = VkPipelineDepthStencilStateCreateInfo.ndepthWriteEnable(adr, value.i)
inline var VkPipelineDepthStencilStateCreateInfo.depthCompareOp: VkCompareOp
    get() = VkCompareOp of VkPipelineDepthStencilStateCreateInfo.ndepthCompareOp(adr)
    set(value) = VkPipelineDepthStencilStateCreateInfo.ndepthCompareOp(adr, value.i)
inline var VkPipelineDepthStencilStateCreateInfo.depthBoundsTestEnable
    get() = VkPipelineDepthStencilStateCreateInfo.ndepthBoundsTestEnable(adr).bool
    set(value) = VkPipelineDepthStencilStateCreateInfo.ndepthBoundsTestEnable(adr, value.i)
inline var VkPipelineDepthStencilStateCreateInfo.stencilTestEnable
    get() = VkPipelineDepthStencilStateCreateInfo.nstencilTestEnable(adr).bool
    set(value) = VkPipelineDepthStencilStateCreateInfo.nstencilTestEnable(adr, value.i)
inline var VkPipelineDepthStencilStateCreateInfo.front: VkStencilOpState
    get() = VkPipelineDepthStencilStateCreateInfo.nfront(adr)
    set(value) = VkPipelineDepthStencilStateCreateInfo.nfront(adr, value)
inline var VkPipelineDepthStencilStateCreateInfo.back: VkStencilOpState
    get() = VkPipelineDepthStencilStateCreateInfo.nback(adr)
    set(value) = VkPipelineDepthStencilStateCreateInfo.nback(adr, value)
inline var VkPipelineDepthStencilStateCreateInfo.minDepthBounds
    get() = VkPipelineDepthStencilStateCreateInfo.nminDepthBounds(adr)
    set(value) = VkPipelineDepthStencilStateCreateInfo.nminDepthBounds(adr, value)
inline var VkPipelineDepthStencilStateCreateInfo.maxDepthBounds
    get() = VkPipelineDepthStencilStateCreateInfo.nmaxDepthBounds(adr)
    set(value) = VkPipelineDepthStencilStateCreateInfo.nmaxDepthBounds(adr, value)


inline var VkPipelineColorBlendAttachmentState.blendEnable
    get() = VkPipelineColorBlendAttachmentState.nblendEnable(adr).bool
    set(value) = VkPipelineColorBlendAttachmentState.nblendEnable(adr, value.i)
inline var VkPipelineColorBlendAttachmentState.srcColorBlendFactor: VkBlendFactor
    get() = VkBlendFactor of VkPipelineColorBlendAttachmentState.nsrcColorBlendFactor(adr)
    set(value) = VkPipelineColorBlendAttachmentState.nsrcColorBlendFactor(adr, value.i)
inline var VkPipelineColorBlendAttachmentState.dstColorBlendFactor: VkBlendFactor
    get() = VkBlendFactor of VkPipelineColorBlendAttachmentState.ndstColorBlendFactor(adr)
    set(value) = VkPipelineColorBlendAttachmentState.ndstColorBlendFactor(adr, value.i)
inline var VkPipelineColorBlendAttachmentState.colorBlendOp: VkBlendOp
    get() = VkBlendOp of VkPipelineColorBlendAttachmentState.ncolorBlendOp(adr)
    set(value) = VkPipelineColorBlendAttachmentState.ncolorBlendOp(adr, value.i)
inline var VkPipelineColorBlendAttachmentState.srcAlphaBlendFactor: VkBlendFactor
    get() = VkBlendFactor of VkPipelineColorBlendAttachmentState.nsrcAlphaBlendFactor(adr)
    set(value) = VkPipelineColorBlendAttachmentState.nsrcAlphaBlendFactor(adr, value.i)
inline var VkPipelineColorBlendAttachmentState.dstAlphaBlendFactor: VkBlendFactor
    get() = VkBlendFactor of VkPipelineColorBlendAttachmentState.ndstAlphaBlendFactor(adr)
    set(value) = VkPipelineColorBlendAttachmentState.ndstAlphaBlendFactor(adr, value.i)
inline var VkPipelineColorBlendAttachmentState.alphaBlendOp: VkBlendOp
    get() = VkBlendOp of VkPipelineColorBlendAttachmentState.nalphaBlendOp(adr)
    set(value) = VkPipelineColorBlendAttachmentState.nalphaBlendOp(adr, value.i)
inline var VkPipelineColorBlendAttachmentState.colorWriteMask: VkColorComponentFlags
    get() = VkPipelineColorBlendAttachmentState.ncolorWriteMask(adr)
    set(value) = VkPipelineColorBlendAttachmentState.ncolorWriteMask(adr, value)


inline var VkPipelineColorBlendStateCreateInfo.type: VkStructureType
    get() = VkStructureType of VkPipelineColorBlendStateCreateInfo.nsType(adr)
    set(value) = VkPipelineColorBlendStateCreateInfo.nsType(adr, value.i)
inline var VkPipelineColorBlendStateCreateInfo.next
    get() = VkPipelineColorBlendStateCreateInfo.npNext(adr)
    set(value) = VkPipelineColorBlendStateCreateInfo.npNext(adr, value)
inline var VkPipelineColorBlendStateCreateInfo.flags: VkPipelineColorBlendStateCreateFlags
    get() = VkPipelineColorBlendStateCreateInfo.nflags(adr)
    set(value) = VkPipelineColorBlendStateCreateInfo.nflags(adr, value)
inline var VkPipelineColorBlendStateCreateInfo.logicOpEnable
    get() = VkPipelineColorBlendStateCreateInfo.nlogicOpEnable(adr).bool
    set(value) = VkPipelineColorBlendStateCreateInfo.nlogicOpEnable(adr, value.i)
inline var VkPipelineColorBlendStateCreateInfo.logicOp: VkLogicOp
    get() = VkLogicOp of VkPipelineColorBlendStateCreateInfo.nlogicOp(adr)
    set(value) = VkPipelineColorBlendStateCreateInfo.nlogicOp(adr, value.i)
//inline val VkPipelineColorBlendStateCreateInfo.attachmentCount: Int get() = VkPipelineColorBlendStateCreateInfo.nattachmentCount(adr)
inline var VkPipelineColorBlendStateCreateInfo.attachments: VkPipelineColorBlendAttachmentState.Buffer?
    get() = VkPipelineColorBlendStateCreateInfo.npAttachments(adr)
    set(value) = VkPipelineColorBlendStateCreateInfo.npAttachments(adr, value)
/** JVM custom */
inline var VkPipelineColorBlendStateCreateInfo.attachment: VkPipelineColorBlendAttachmentState?
    get() = VkPipelineColorBlendAttachmentState.createSafe(memGetAddress(adr + VkPipelineColorBlendStateCreateInfo.PATTACHMENTS))
    set(value) {
        memPutAddress(adr + VkPipelineColorBlendStateCreateInfo.PATTACHMENTS, memAddressSafe(value))
        VkPipelineColorBlendStateCreateInfo.nattachmentCount(adr, if (value == null) 0 else 1)
    }
inline var VkPipelineColorBlendStateCreateInfo.blendConstants: FloatBuffer
    get() = VkPipelineColorBlendStateCreateInfo.nblendConstants(adr)
    set(value) = VkPipelineColorBlendStateCreateInfo.nblendConstants(adr, value)


inline var VkPipelineDynamicStateCreateInfo.type: VkStructureType
    get() = VkStructureType of VkPipelineDynamicStateCreateInfo.nsType(adr)
    set(value) = VkPipelineDynamicStateCreateInfo.nsType(adr, value.i)
inline var VkPipelineDynamicStateCreateInfo.next
    get() = VkPipelineDynamicStateCreateInfo.npNext(adr)
    set(value) = VkPipelineDynamicStateCreateInfo.npNext(adr, value)
inline var VkPipelineDynamicStateCreateInfo.flags: VkPipelineDynamicStateCreateFlags
    get() = VkPipelineDynamicStateCreateInfo.nflags(adr)
    set(value) = VkPipelineDynamicStateCreateInfo.nflags(adr, value)
//inline val VkPipelineDynamicStateCreateInfo.dynamicStateCount get() = VkPipelineDynamicStateCreateInfo.ndynamicStateCount(adr)
inline var VkPipelineDynamicStateCreateInfo.dynamicStates: IntBuffer
    get() = VkPipelineDynamicStateCreateInfo.npDynamicStates(adr)
    set(value) = VkPipelineDynamicStateCreateInfo.npDynamicStates(adr, value)

//typedef struct VkPipelineDynamicStateCreateInfo {
//    VkStructureType                      sType;
//    const void*                          pNext;
//    VkPipelineDynamicStateCreateFlags    flags;
//    uint32_t                             dynamicStateCount;
//    const VkDynamicState*                pDynamicStates;
//} VkPipelineDynamicStateCreateInfo;
//

inline var VkGraphicsPipelineCreateInfo.type: VkStructureType
    get() = VkStructureType of VkGraphicsPipelineCreateInfo.nsType(adr)
    set(value) = VkGraphicsPipelineCreateInfo.nsType(adr, value.i)
inline var VkGraphicsPipelineCreateInfo.next
    get() = VkGraphicsPipelineCreateInfo.npNext(adr)
    set(value) = VkGraphicsPipelineCreateInfo.npNext(adr, value)
/** JVM custom */
inline var VkGraphicsPipelineCreateInfo.flag: VkPipelineCreate
    get() = TODO()
    set(value) = VkGraphicsPipelineCreateInfo.nflags(adr, value.i)
inline var VkGraphicsPipelineCreateInfo.flags: VkPipelineCreateFlags
    get() = VkGraphicsPipelineCreateInfo.nflags(adr)
    set(value) = VkGraphicsPipelineCreateInfo.nflags(adr, value)
//inline val VkGraphicsPipelineCreateInfo.stageCount get() = VkGraphicsPipelineCreateInfo.nstageCount(adr)
inline var VkGraphicsPipelineCreateInfo.stages: VkPipelineShaderStageCreateInfo.Buffer
    get() = VkGraphicsPipelineCreateInfo.npStages(adr)
    set(value) = VkGraphicsPipelineCreateInfo.npStages(adr, value)
inline var VkGraphicsPipelineCreateInfo.vertexInputState: VkPipelineVertexInputStateCreateInfo
    get() = VkGraphicsPipelineCreateInfo.npVertexInputState(adr)
    set(value) = VkGraphicsPipelineCreateInfo.npVertexInputState(adr, value)
inline var VkGraphicsPipelineCreateInfo.inputAssemblyState: VkPipelineInputAssemblyStateCreateInfo
    get() = VkGraphicsPipelineCreateInfo.npInputAssemblyState(adr)
    set(value) = VkGraphicsPipelineCreateInfo.npInputAssemblyState(adr, value)
inline var VkGraphicsPipelineCreateInfo.tessellationState
    get() = VkGraphicsPipelineCreateInfo.npTessellationState(adr)
    set(value) = VkGraphicsPipelineCreateInfo.npTessellationState(adr, value)
inline var VkGraphicsPipelineCreateInfo.viewportState
    get() = VkGraphicsPipelineCreateInfo.npViewportState(adr)
    set(value) = VkGraphicsPipelineCreateInfo.npViewportState(adr, value)
inline var VkGraphicsPipelineCreateInfo.rasterizationState: VkPipelineRasterizationStateCreateInfo
    get() = VkGraphicsPipelineCreateInfo.npRasterizationState(adr)
    set(value) = VkGraphicsPipelineCreateInfo.npRasterizationState(adr, value)
inline var VkGraphicsPipelineCreateInfo.multisampleState
    get() = VkGraphicsPipelineCreateInfo.npMultisampleState(adr)
    set(value) = VkGraphicsPipelineCreateInfo.npMultisampleState(adr, value)
inline var VkGraphicsPipelineCreateInfo.depthStencilState
    get() = VkGraphicsPipelineCreateInfo.npDepthStencilState(adr)
    set(value) = VkGraphicsPipelineCreateInfo.npDepthStencilState(adr, value)
inline var VkGraphicsPipelineCreateInfo.colorBlendState
    get() = VkGraphicsPipelineCreateInfo.npColorBlendState(adr)
    set(value) = VkGraphicsPipelineCreateInfo.npColorBlendState(adr, value)
inline var VkGraphicsPipelineCreateInfo.dynamicState
    get() = VkGraphicsPipelineCreateInfo.npDynamicState(adr)
    set(value) = VkGraphicsPipelineCreateInfo.npDynamicState(adr, value)
inline var VkGraphicsPipelineCreateInfo.layout: VkPipelineLayout
    get() = VkGraphicsPipelineCreateInfo.nlayout(adr)
    set(value) = VkGraphicsPipelineCreateInfo.nlayout(adr, value)
inline var VkGraphicsPipelineCreateInfo.renderPass: VkRenderPass
    get() = VkGraphicsPipelineCreateInfo.nrenderPass(adr)
    set(value) = VkGraphicsPipelineCreateInfo.nrenderPass(adr, value)
inline var VkGraphicsPipelineCreateInfo.subpass
    get() = VkGraphicsPipelineCreateInfo.nsubpass(adr)
    set(value) = VkGraphicsPipelineCreateInfo.nsubpass(adr, value)
inline var VkGraphicsPipelineCreateInfo.basePipelineHandle: VkPipeline
    get() = VkGraphicsPipelineCreateInfo.nbasePipelineHandle(adr)
    set(value) = VkGraphicsPipelineCreateInfo.nbasePipelineHandle(adr, value)
inline var VkGraphicsPipelineCreateInfo.basePipelineIndex
    get() = VkGraphicsPipelineCreateInfo.nbasePipelineIndex(adr)
    set(value) = VkGraphicsPipelineCreateInfo.nbasePipelineIndex(adr, value)


inline var VkComputePipelineCreateInfo.type: VkStructureType
    get() = VkStructureType of VkComputePipelineCreateInfo.nsType(adr)
    set(value) = VkComputePipelineCreateInfo.nsType(adr, value.i)
inline var VkComputePipelineCreateInfo.next: Long
    get() = VkComputePipelineCreateInfo.npNext(adr)
    set(value) = VkComputePipelineCreateInfo.npNext(adr, value)
inline var VkComputePipelineCreateInfo.flags: VkPipelineCreateFlags
    get() = VkComputePipelineCreateInfo.nflags(adr)
    set(value) = VkComputePipelineCreateInfo.nflags(adr, value)
inline var VkComputePipelineCreateInfo.stage: VkPipelineShaderStageCreateInfo
    get() = VkComputePipelineCreateInfo.nstage(adr)
    set(value) = VkComputePipelineCreateInfo.nstage(adr, value)
inline var VkComputePipelineCreateInfo.layout: VkPipelineLayout
    get() = VkComputePipelineCreateInfo.nlayout(adr)
    set(value) = VkComputePipelineCreateInfo.nlayout(adr, value)
inline var VkComputePipelineCreateInfo.basePipelineHandle: VkPipeline
    get() = VkComputePipelineCreateInfo.nbasePipelineHandle(adr)
    set(value) = VkComputePipelineCreateInfo.nbasePipelineHandle(adr, value)
inline var VkComputePipelineCreateInfo.basePipelineIndex: Int
    get() = VkComputePipelineCreateInfo.nbasePipelineIndex(adr)
    set(value) = VkComputePipelineCreateInfo.nbasePipelineIndex(adr, value)


inline var VkPushConstantRange.stageFlags: VkShaderStageFlags
    get() = VkPushConstantRange.nstageFlags(adr)
    set(value) = VkPushConstantRange.nstageFlags(adr, value)
inline var VkPushConstantRange.offset: Int
    get() = VkPushConstantRange.noffset(adr)
    set(value) = VkPushConstantRange.noffset(adr, value)
inline var VkPushConstantRange.size: Int
    get() = VkPushConstantRange.nsize(adr)
    set(value) = VkPushConstantRange.nsize(adr, value)


inline var VkPipelineLayoutCreateInfo.type: VkStructureType
    get() = VkStructureType of VkPipelineLayoutCreateInfo.nsType(adr)
    set(value) = VkPipelineLayoutCreateInfo.nsType(adr, value.i)
inline var VkPipelineLayoutCreateInfo.next
    get() = VkPipelineLayoutCreateInfo.npNext(adr)
    set(value) = VkPipelineLayoutCreateInfo.npNext(adr, value)
inline var VkPipelineLayoutCreateInfo.flags: VkPipelineLayoutCreateFlags
    get() = VkPipelineLayoutCreateInfo.nflags(adr)
    set(value) = VkPipelineLayoutCreateInfo.nflags(adr, value)
//inline val VkPipelineLayoutCreateInfo.setLayoutCount get() = VkPipelineLayoutCreateInfo.nsetLayoutCount(adr)
inline var VkPipelineLayoutCreateInfo.setLayouts: LongBuffer?
    get() = VkPipelineLayoutCreateInfo.npSetLayouts(adr)
    set(value) = VkPipelineLayoutCreateInfo.npSetLayouts(adr, value)
//inline var VkPipelineLayoutCreateInfo.setLayout: VkDescriptorSetLayout? TODO BUG, inline it back
/** JVM custom */
var VkPipelineLayoutCreateInfo.setLayout: VkDescriptorSetLayout?
    get() = VkPipelineLayoutCreateInfo.npSetLayouts(adr)?.get(0)
    set(value) = VkPipelineLayoutCreateInfo.npSetLayouts(adr, value?.let { appBuffer longBufferOf it })
//inline val VkPipelineLayoutCreateInfo.pushConstantRangeCount get() = VkPipelineLayoutCreateInfo.npushConstantRangeCount(adr)
inline var VkPipelineLayoutCreateInfo.pushConstantRanges
    get() = VkPipelineLayoutCreateInfo.npPushConstantRanges(adr)
    set(value) = VkPipelineLayoutCreateInfo.npPushConstantRanges(adr, value)
/** JVM Custom */
inline var VkPipelineLayoutCreateInfo.pushConstantRange: VkPushConstantRange?
    get() = VkPushConstantRange.createSafe(memGetAddress(adr + VkPipelineLayoutCreateInfo.PPUSHCONSTANTRANGES))
    set(value) {
        memPutAddress(adr + VkPipelineLayoutCreateInfo.PPUSHCONSTANTRANGES, memAddressSafe(value))
        VkPipelineLayoutCreateInfo.npushConstantRangeCount(adr, if (value != null) 1 else 0)
    }

//typedef struct VkPipelineLayoutCreateInfo {
//    VkStructureType                 sType;
//    const void*                     pNext;
//    VkPipelineLayoutCreateFlags     flags;
//    uint32_t                        setLayoutCount;
//    const VkDescriptorSetLayout*    pSetLayouts;
//    uint32_t                        pushConstantRangeCount;
//    const VkPushConstantRange*      pPushConstantRanges;
//} VkPipelineLayoutCreateInfo;


inline var VkSamplerCreateInfo.type: VkStructureType
    get() = VkStructureType of VkSamplerCreateInfo.nsType(adr)
    set(value) = VkSamplerCreateInfo.nsType(adr, value.i)
inline var VkSamplerCreateInfo.next
    get() = VkSamplerCreateInfo.npNext(adr)
    set(value) = VkSamplerCreateInfo.npNext(adr, value)
inline var VkSamplerCreateInfo.flags: VkSamplerCreateFlags
    get() = VkSamplerCreateInfo.nflags(adr)
    set(value) = VkSamplerCreateInfo.nflags(adr, value)
inline var VkSamplerCreateInfo.magFilter: VkFilter
    get() = VkFilter of VkSamplerCreateInfo.nmagFilter(adr)
    set(value) = VkSamplerCreateInfo.nmagFilter(adr, value.i)
inline var VkSamplerCreateInfo.minFilter: VkFilter
    get() = VkFilter of VkSamplerCreateInfo.nminFilter(adr)
    set(value) = VkSamplerCreateInfo.nminFilter(adr, value.i)
inline var VkSamplerCreateInfo.mipmapMode: VkSamplerMipmapMode
    get() = VkSamplerMipmapMode of VkSamplerCreateInfo.nmipmapMode(adr)
    set(value) = VkSamplerCreateInfo.nmipmapMode(adr, value.i)
inline var VkSamplerCreateInfo.addressModeU: VkSamplerAddressMode
    get() = VkSamplerAddressMode of VkSamplerCreateInfo.naddressModeU(adr)
    set(value) = VkSamplerCreateInfo.naddressModeU(adr, value.i)
inline var VkSamplerCreateInfo.addressModeV: VkSamplerAddressMode
    get() = VkSamplerAddressMode of VkSamplerCreateInfo.naddressModeV(adr)
    set(value) = VkSamplerCreateInfo.naddressModeV(adr, value.i)
inline var VkSamplerCreateInfo.addressModeW: VkSamplerAddressMode
    get() = VkSamplerAddressMode of VkSamplerCreateInfo.naddressModeW(adr)
    set(value) = VkSamplerCreateInfo.naddressModeW(adr, value.i)
/** JVM custom */
inline var VkSamplerCreateInfo.addressMode: VkSamplerAddressMode
    get() = throw Error()
    set(value) {
        addressModeU = value
        addressModeV = value
        addressModeW = value
    }
inline var VkSamplerCreateInfo.mipLodBias: Float
    get() = VkSamplerCreateInfo.nmipLodBias(adr)
    set(value) = VkSamplerCreateInfo.nmipLodBias(adr, value)
inline var VkSamplerCreateInfo.anisotropyEnable: Boolean
    get() = VkSamplerCreateInfo.nanisotropyEnable(adr).bool
    set(value) = VkSamplerCreateInfo.nanisotropyEnable(adr, value.i)
inline var VkSamplerCreateInfo.maxAnisotropy: Float
    get() = VkSamplerCreateInfo.nmaxAnisotropy(adr)
    set(value) = VkSamplerCreateInfo.nmaxAnisotropy(adr, value)
inline var VkSamplerCreateInfo.compareEnable: Boolean
    get() = VkSamplerCreateInfo.ncompareEnable(adr).bool
    set(value) = VkSamplerCreateInfo.ncompareEnable(adr, value.i)
inline var VkSamplerCreateInfo.compareOp: VkCompareOp
    get() = VkCompareOp of VkSamplerCreateInfo.ncompareOp(adr)
    set(value) = VkSamplerCreateInfo.ncompareOp(adr, value.i)
inline var VkSamplerCreateInfo.minLod: Float
    get() = VkSamplerCreateInfo.nminLod(adr)
    set(value) = VkSamplerCreateInfo.nminLod(adr, value)
inline var VkSamplerCreateInfo.maxLod: Float
    get() = VkSamplerCreateInfo.nmaxLod(adr)
    set(value) = VkSamplerCreateInfo.nmaxLod(adr, value)
inline var VkSamplerCreateInfo.borderColor: VkBorderColor
    get() = VkBorderColor of VkSamplerCreateInfo.nborderColor(adr)
    set(value) = VkSamplerCreateInfo.nborderColor(adr, value.i)
inline var VkSamplerCreateInfo.unnormalizedCoordinates: Boolean
    get() = VkSamplerCreateInfo.nunnormalizedCoordinates(adr).bool
    set(value) = VkSamplerCreateInfo.nunnormalizedCoordinates(adr, value.i)


inline var VkDescriptorSetLayoutBinding.binding
    get() = VkDescriptorSetLayoutBinding.nbinding(adr)
    set(value) = VkDescriptorSetLayoutBinding.nbinding(adr, value)
inline var VkDescriptorSetLayoutBinding.descriptorType: VkDescriptorType
    get() = VkDescriptorType of VkDescriptorSetLayoutBinding.ndescriptorType(adr)
    set(value) = VkDescriptorSetLayoutBinding.ndescriptorType(adr, value.i)
inline var VkDescriptorSetLayoutBinding.descriptorCount
    get() = VkDescriptorSetLayoutBinding.ndescriptorCount(adr)
    set(value) = VkDescriptorSetLayoutBinding.ndescriptorCount(adr, value)
inline var VkDescriptorSetLayoutBinding.stageFlags: VkShaderStageFlags
    get() = VkDescriptorSetLayoutBinding.nstageFlags(adr)
    set(value) = VkDescriptorSetLayoutBinding.nstageFlags(adr, value)
inline var VkDescriptorSetLayoutBinding.immutableSamplers: VkSamplerBuffer?
    get() = VkDescriptorSetLayoutBinding.npImmutableSamplers(adr)
    set(value) = VkDescriptorSetLayoutBinding.npImmutableSamplers(adr, value)
/** JVM custom */
inline var VkDescriptorSetLayoutBinding.immutableSampler: VkSampler?
    get() = VkDescriptorSetLayoutBinding.npImmutableSamplers(adr)?.get(0)
    set(value) {
        if (value == null)
            memPutAddress(adr + VkDescriptorSetLayoutBinding.PIMMUTABLESAMPLERS, NULL)
        else {
            val pSampler = appBuffer.long
            memPutLong(pSampler, value)
            memPutAddress(adr + VkDescriptorSetLayoutBinding.PIMMUTABLESAMPLERS, pSampler)
            VkDescriptorSetLayoutBinding.ndescriptorCount(adr, 1)
        }
    }


inline var VkDescriptorSetLayoutCreateInfo.type: VkStructureType
    get() = VkStructureType of VkDescriptorSetLayoutCreateInfo.nsType(adr)
    set(value) = VkDescriptorSetLayoutCreateInfo.nsType(adr, value.i)
inline var VkDescriptorSetLayoutCreateInfo.next
    get() = VkDescriptorSetLayoutCreateInfo.npNext(adr)
    set(value) = VkDescriptorSetLayoutCreateInfo.npNext(adr, value)
/** JVM custom */
inline var VkDescriptorSetLayoutCreateInfo.flag: VkDescriptorSetLayoutCreate
    get() = TODO()
    set(value) = VkDescriptorSetLayoutCreateInfo.nflags(adr, value.i)
inline var VkDescriptorSetLayoutCreateInfo.flags: VkDescriptorSetLayoutCreateFlags
    get() = VkDescriptorSetLayoutCreateInfo.nflags(adr)
    set(value) = VkDescriptorSetLayoutCreateInfo.nflags(adr, value)
//inline val VkDescriptorSetLayoutCreateInfo.bindingCount get() = VkDescriptorSetLayoutCreateInfo.nbindingCount(adr)
inline var VkDescriptorSetLayoutCreateInfo.bindings: VkDescriptorSetLayoutBinding.Buffer?
    get() = VkDescriptorSetLayoutCreateInfo.npBindings(adr)
    set(value) = VkDescriptorSetLayoutCreateInfo.npBindings(adr, value)
/** JVM custom */
inline var VkDescriptorSetLayoutCreateInfo.binding: VkDescriptorSetLayoutBinding?
    get() = VkDescriptorSetLayoutBinding.createSafe(memGetAddress(adr + VkDescriptorSetLayoutCreateInfo.PBINDINGS))
    set(value) {
        memPutAddress(adr + VkDescriptorSetLayoutCreateInfo.PBINDINGS, value?.adr ?: NULL)
        VkDescriptorSetLayoutCreateInfo.nbindingCount(adr, if (value == null) 0 else 1)
    }


inline var VkDescriptorPoolSize.type: VkDescriptorType
    get() = VkDescriptorType of VkDescriptorPoolSize.ntype(adr)
    set(value) = VkDescriptorPoolSize.ntype(adr, value.i)
inline var VkDescriptorPoolSize.descriptorCount
    get() = VkDescriptorPoolSize.ndescriptorCount(adr)
    set(value) = VkDescriptorPoolSize.ndescriptorCount(adr, value)


inline var VkDescriptorPoolCreateInfo.type: VkStructureType
    get() = VkStructureType of VkDescriptorPoolCreateInfo.nsType(adr)
    set(value) = VkDescriptorPoolCreateInfo.nsType(adr, value.i)
inline var VkDescriptorPoolCreateInfo.next
    get() = VkDescriptorPoolCreateInfo.npNext(adr)
    set(value) = VkDescriptorPoolCreateInfo.npNext(adr, value)
/** JVM custom */
inline var VkDescriptorPoolCreateInfo.flag: VkDescriptorPoolCreate
    get() = TODO()
    set(value) = VkDescriptorPoolCreateInfo.nflags(adr, value.i)
inline var VkDescriptorPoolCreateInfo.flags: VkDescriptorPoolCreateFlags
    get() = VkDescriptorPoolCreateInfo.nflags(adr)
    set(value) = VkDescriptorPoolCreateInfo.nflags(adr, value)
inline var VkDescriptorPoolCreateInfo.maxSets
    get() = VkDescriptorPoolCreateInfo.nmaxSets(adr)
    set(value) = VkDescriptorPoolCreateInfo.nmaxSets(adr, value)
//inline val VkDescriptorPoolCreateInfo.poolSizeCount get() = VkDescriptorPoolCreateInfo.npoolSizeCount(adr)
inline var VkDescriptorPoolCreateInfo.poolSizes: VkDescriptorPoolSize.Buffer
    get() = VkDescriptorPoolCreateInfo.npPoolSizes(adr)
    set(value) = VkDescriptorPoolCreateInfo.npPoolSizes(adr, value)
/** JVM custom */
inline var VkDescriptorPoolCreateInfo.poolSize: VkDescriptorPoolSize
    get() = VkDescriptorPoolSize.create(memGetAddress(adr + VkDescriptorPoolCreateInfo.PPOOLSIZES))
    set(value) {
        memPutAddress(adr + VkDescriptorPoolCreateInfo.PPOOLSIZES, value.adr)
        VkDescriptorPoolCreateInfo.npoolSizeCount(adr, 1)
    }


inline var VkDescriptorSetAllocateInfo.type: VkStructureType
    get() = VkStructureType of VkDescriptorSetAllocateInfo.nsType(adr)
    set(value) = VkDescriptorSetAllocateInfo.nsType(adr, value.i)
inline var VkDescriptorSetAllocateInfo.next
    get() = VkDescriptorSetAllocateInfo.npNext(adr)
    set(value) = VkDescriptorSetAllocateInfo.npNext(adr, value)
inline var VkDescriptorSetAllocateInfo.descriptorPool: VkDescriptorPool
    get() = VkDescriptorSetAllocateInfo.ndescriptorPool(adr)
    set(value) = VkDescriptorSetAllocateInfo.ndescriptorPool(adr, value)
inline var VkDescriptorSetAllocateInfo.descriptorSetCount
    get() = VkDescriptorSetAllocateInfo.ndescriptorSetCount(adr)
    set(value) = VkDescriptorSetAllocateInfo.ndescriptorSetCount(adr, value)
inline var VkDescriptorSetAllocateInfo.setLayouts: LongBuffer
    get() = VkDescriptorSetAllocateInfo.npSetLayouts(adr)
    set(value) = VkDescriptorSetAllocateInfo.npSetLayouts(adr, value)
/** JVM custom */
inline var VkDescriptorSetAllocateInfo.setLayout: VkDescriptorSetLayout
    get() = VkDescriptorSetAllocateInfo.npSetLayouts(adr)[0]
    set(value) = VkDescriptorSetAllocateInfo.npSetLayouts(adr, appBuffer longBufferOf value)


inline var VkDescriptorImageInfo.sampler: VkSampler
    get() = VkDescriptorImageInfo.nsampler(adr)
    set(value) = VkDescriptorImageInfo.nsampler(adr, value)
inline var VkDescriptorImageInfo.imageView: VkImageView
    get() = VkDescriptorImageInfo.nimageView(adr)
    set(value) = VkDescriptorImageInfo.nimageView(adr, value)
inline var VkDescriptorImageInfo.imageLayout: VkImageLayout
    get() = VkImageLayout of VkDescriptorImageInfo.nimageLayout(adr)
    set(value) = VkDescriptorImageInfo.nimageLayout(adr, value.i)


inline var VkDescriptorBufferInfo.buffer: VkBuffer
    get() = VkDescriptorBufferInfo.nbuffer(adr)
    set(value) = VkDescriptorBufferInfo.nbuffer(adr, value)
inline var VkDescriptorBufferInfo.offset: VkDeviceSize
    get() = VkDescriptorBufferInfo.noffset(adr)
    set(value) = VkDescriptorBufferInfo.noffset(adr, value)
inline var VkDescriptorBufferInfo.range: VkDeviceSize
    get() = VkDescriptorBufferInfo.nrange(adr)
    set(value) = VkDescriptorBufferInfo.nrange(adr, value)


inline var VkWriteDescriptorSet.type: VkStructureType
    get() = VkStructureType of VkWriteDescriptorSet.nsType(adr)
    set(value) = VkWriteDescriptorSet.nsType(adr, value.i)
inline var VkWriteDescriptorSet.next
    get() = VkWriteDescriptorSet.npNext(adr)
    set(value) = VkWriteDescriptorSet.npNext(adr, value)
inline var VkWriteDescriptorSet.dstSet: VkDescriptorSet
    get() = VkWriteDescriptorSet.ndstSet(adr)
    set(value) = VkWriteDescriptorSet.ndstSet(adr, value)
inline var VkWriteDescriptorSet.dstBinding
    get() = VkWriteDescriptorSet.ndstBinding(adr)
    set(value) = VkWriteDescriptorSet.ndstBinding(adr, value)
inline var VkWriteDescriptorSet.dstArrayElement
    get() = VkWriteDescriptorSet.ndstArrayElement(adr)
    set(value) = VkWriteDescriptorSet.ndstArrayElement(adr, value)
//inline val VkWriteDescriptorSet.descriptorCount get() = VkWriteDescriptorSet.ndescriptorCount(adr)
inline var VkWriteDescriptorSet.descriptorType: VkDescriptorType
    get() = VkDescriptorType of VkWriteDescriptorSet.ndescriptorType(adr)
    set(value) = VkWriteDescriptorSet.ndescriptorType(adr, value.i)
inline var VkWriteDescriptorSet.imageInfo: VkDescriptorImageInfo.Buffer?
    get() = VkWriteDescriptorSet.npImageInfo(adr)
    set(value) = VkWriteDescriptorSet.npImageInfo(adr, value)
/** JVM custom */
inline var VkWriteDescriptorSet.imageInfo_: VkDescriptorImageInfo?
    get() = VkDescriptorImageInfo.createSafe(memGetAddress(adr + VkWriteDescriptorSet.PIMAGEINFO))
    set(value) {
        memPutAddress(adr + VkWriteDescriptorSet.PIMAGEINFO, memAddressSafe(value))
        value?.let { VkWriteDescriptorSet.ndescriptorCount(adr, 1) }
    }
inline var VkWriteDescriptorSet.bufferInfo: VkDescriptorBufferInfo.Buffer?
    get() = VkWriteDescriptorSet.npBufferInfo(adr)
    set(value) = VkWriteDescriptorSet.npBufferInfo(adr, value)
/** JVM custom */
inline var VkWriteDescriptorSet.bufferInfo_: VkDescriptorBufferInfo?
    get() = VkDescriptorBufferInfo.createSafe(memGetAddress(adr + VkWriteDescriptorSet.PBUFFERINFO))
    set(value) {
        memPutAddress(adr + VkWriteDescriptorSet.PBUFFERINFO, memAddressSafe(value))
        value?.let { VkWriteDescriptorSet.ndescriptorCount(adr, 1) }
    }
inline var VkWriteDescriptorSet.texelBufferView
    get() = VkWriteDescriptorSet.npTexelBufferView(adr)
    set(value) = VkWriteDescriptorSet.npTexelBufferView(adr, value)


//typedef struct VkCopyDescriptorSet {
//    VkStructureType    sType;
//    const void*        pNext;
//    VkDescriptorSet    srcSet;
//    uint32_t           srcBinding;
//    uint32_t           srcArrayElement;
//    VkDescriptorSet    dstSet;
//    uint32_t           dstBinding;
//    uint32_t           dstArrayElement;
//    uint32_t           descriptorCount;
//} VkCopyDescriptorSet;


inline var VkFramebufferCreateInfo.type: VkStructureType
    get() = VkStructureType of VkFramebufferCreateInfo.nsType(adr)
    set(value) = VkFramebufferCreateInfo.nsType(adr, value.i)
inline var VkFramebufferCreateInfo.next
    get() = VkFramebufferCreateInfo.npNext(adr)
    set(value) = VkFramebufferCreateInfo.npNext(adr, value)
inline var VkFramebufferCreateInfo.flags: VkFramebufferCreateFlags
    get() = VkFramebufferCreateInfo.nflags(adr)
    set(value) = VkFramebufferCreateInfo.nflags(adr, value)
inline var VkFramebufferCreateInfo.renderPass: VkRenderPass
    get() = VkFramebufferCreateInfo.nrenderPass(adr)
    set(value) = VkFramebufferCreateInfo.nrenderPass(adr, value)
//inline val VkFramebufferCreateInfo.attachmentCount get() = attachmentCount()
inline var VkFramebufferCreateInfo.attachments: VkImageViewBuffer?
    get() = VkFramebufferCreateInfo.npAttachments(adr)
    set(value) = VkFramebufferCreateInfo.npAttachments(adr, value)
/** JVM custom */
inline var VkFramebufferCreateInfo.attachment: VkImageView?
    get() = VkFramebufferCreateInfo.npAttachments(adr)?.get(0)
    set(value) {
        if (value == null) {
            memPutAddress(adr + VkFramebufferCreateInfo.PATTACHMENTS, NULL)
            VkFramebufferCreateInfo.nattachmentCount(adr, 0)
        } else {
            val pAtt = appBuffer.long
            memPutLong(pAtt, value)
            memPutAddress(adr + VkFramebufferCreateInfo.PATTACHMENTS, pAtt)
            VkFramebufferCreateInfo.nattachmentCount(adr, 1)
        }
    }
inline var VkFramebufferCreateInfo.width
    get() = VkFramebufferCreateInfo.nwidth(adr)
    set(value) = VkFramebufferCreateInfo.nwidth(adr, value)
inline var VkFramebufferCreateInfo.height
    get() = VkFramebufferCreateInfo.nheight(adr)
    set(value) = VkFramebufferCreateInfo.nheight(adr, value)
inline var VkFramebufferCreateInfo.layers
    get() = VkFramebufferCreateInfo.nlayers(adr)
    set(value) = VkFramebufferCreateInfo.nlayers(adr, value)

inline fun VkFramebufferCreateInfo.extent(extent: Vec2i, layers: Int) {
    width = extent.x
    height = extent.y
    this.layers = layers
}

/** JVM custom */
inline var VkAttachmentDescription.flag: VkAttachmentDescriptionFlag
    get() = TODO()
    set(value) = VkAttachmentDescription.nflags(adr, value.i)
inline var VkAttachmentDescription.flags: VkAttachmentDescriptionFlags
    get() = VkAttachmentDescription.nflags(adr)
    set(value) = VkAttachmentDescription.nflags(adr, value)
inline var VkAttachmentDescription.format: VkFormat
    get() = VkFormat of VkAttachmentDescription.nformat(adr)
    set(value) = VkAttachmentDescription.nformat(adr, value.i)
inline var VkAttachmentDescription.samples: VkSampleCount
    get() = VkSampleCount of VkAttachmentDescription.nsamples(adr)
    set(value) = VkAttachmentDescription.nsamples(adr, value.i)
inline var VkAttachmentDescription.loadOp: VkAttachmentLoadOp
    get() = VkAttachmentLoadOp of VkAttachmentDescription.nloadOp(adr)
    set(value) = VkAttachmentDescription.nloadOp(adr, value.i)
inline var VkAttachmentDescription.storeOp: VkAttachmentStoreOp
    get() = VkAttachmentStoreOp of VkAttachmentDescription.nstoreOp(adr)
    set(value) = VkAttachmentDescription.nstoreOp(adr, value.i)
inline var VkAttachmentDescription.stencilLoadOp: VkAttachmentLoadOp
    get() = VkAttachmentLoadOp of VkAttachmentDescription.nstencilLoadOp(adr)
    set(value) = VkAttachmentDescription.nstencilLoadOp(adr, value.i)
inline var VkAttachmentDescription.stencilStoreOp: VkAttachmentStoreOp
    get() = VkAttachmentStoreOp of VkAttachmentDescription.nstencilStoreOp(adr)
    set(value) = VkAttachmentDescription.nstencilStoreOp(adr, value.i)
inline var VkAttachmentDescription.initialLayout: VkImageLayout
    get() = VkImageLayout of VkAttachmentDescription.ninitialLayout(adr)
    set(value) = VkAttachmentDescription.ninitialLayout(adr, value.i)
inline var VkAttachmentDescription.finalLayout: VkImageLayout
    get() = VkImageLayout of VkAttachmentDescription.nfinalLayout(adr)
    set(value) = VkAttachmentDescription.nfinalLayout(adr, value.i)


inline var VkAttachmentReference.attachment
    get() = VkAttachmentReference.nattachment(adr)
    set(value) = VkAttachmentReference.nattachment(adr, value)
inline var VkAttachmentReference.layout: VkImageLayout
    get() = VkImageLayout of VkAttachmentReference.nlayout(adr)
    set(value) = VkAttachmentReference.nlayout(adr, value.i)


/** JVM custom */
inline var VkSubpassDescription.flag: VkSubpassDescriptionFlag
    get() = TODO()
    set(value) = VkSubpassDescription.nflags(adr, value.i)
inline var VkSubpassDescription.flags: VkSubpassDescriptionFlags
    get() = VkSubpassDescription.nflags(adr)
    set(value) = VkSubpassDescription.nflags(adr, value)
inline var VkSubpassDescription.pipelineBindPoint: VkPipelineBindPoint
    get() = VkPipelineBindPoint of VkSubpassDescription.npipelineBindPoint(adr)
    set(value) = VkSubpassDescription.npipelineBindPoint(adr, value.i)
//inline val VkSubpassDescription.inputAttachmentCount get() = VkSubpassDescription.ninputAttachmentCount(adr)
inline var VkSubpassDescription.inputAttachments
    get() = VkSubpassDescription.npInputAttachments(adr)
    set(value) = VkSubpassDescription.npInputAttachments(adr, value)
inline var VkSubpassDescription.colorAttachmentCount
    get() = VkSubpassDescription.ncolorAttachmentCount(adr)
    set(value) = VkSubpassDescription.ncolorAttachmentCount(adr, value)
inline var VkSubpassDescription.colorAttachments: VkAttachmentReference.Buffer?
    get() = VkSubpassDescription.npColorAttachments(adr)
    set(value) = VkSubpassDescription.npColorAttachments(adr, value)
/** JVM custom */
inline var VkSubpassDescription.colorAttachment: VkAttachmentReference?
    get() = VkSubpassDescription.npColorAttachments(adr)?.get(0)
    set(value) = memPutAddress(adr + VkSubpassDescription.PCOLORATTACHMENTS, memAddressSafe(value))
inline var VkSubpassDescription.resolveAttachments
    get() = VkSubpassDescription.npResolveAttachments(adr)
    set(value) = VkSubpassDescription.npResolveAttachments(adr, value)
inline var VkSubpassDescription.depthStencilAttachment
    get() = VkSubpassDescription.npDepthStencilAttachment(adr)
    set(value) = VkSubpassDescription.npDepthStencilAttachment(adr, value)
//inline val VkSubpassDescription.preserveAttachmentCount get() = VkSubpassDescription.npreserveAttachmentCount(adr)
inline var VkSubpassDescription.preserveAttachments
    get() = VkSubpassDescription.npPreserveAttachments(adr)
    set(value) = VkSubpassDescription.npPreserveAttachments(adr, value)


inline var VkSubpassDependency.srcSubpass
    get() = VkSubpassDependency.nsrcSubpass(adr)
    set(value) = VkSubpassDependency.nsrcSubpass(adr, value)
inline var VkSubpassDependency.dstSubpass
    get() = VkSubpassDependency.ndstSubpass(adr)
    set(value) = VkSubpassDependency.ndstSubpass(adr, value)
inline var VkSubpassDependency.srcStageMask: VkPipelineStageFlags
    get() = VkSubpassDependency.nsrcStageMask(adr)
    set(value) = VkSubpassDependency.nsrcStageMask(adr, value)
inline var VkSubpassDependency.dstStageMask: VkPipelineStageFlags
    get() = VkSubpassDependency.ndstStageMask(adr)
    set(value) = VkSubpassDependency.ndstStageMask(adr, value)
inline var VkSubpassDependency.srcAccessMask: VkAccessFlags
    get() = VkSubpassDependency.nsrcAccessMask(adr)
    set(value) = VkSubpassDependency.nsrcAccessMask(adr, value)
inline var VkSubpassDependency.dstAccessMask: VkAccessFlags
    get() = VkSubpassDependency.ndstAccessMask(adr)
    set(value) = VkSubpassDependency.ndstAccessMask(adr, value)
inline var VkSubpassDependency.dependencyFlags: VkDependencyFlags
    get() = VkSubpassDependency.ndependencyFlags(adr)
    set(value) = VkSubpassDependency.ndependencyFlags(adr, value)


inline var VkRenderPassCreateInfo.type: VkStructureType
    get() = VkStructureType of VkRenderPassCreateInfo.nsType(adr)
    set(value) = VkRenderPassCreateInfo.nsType(adr, value.i)
inline var VkRenderPassCreateInfo.next
    get() = VkRenderPassCreateInfo.npNext(adr)
    set(value) = VkRenderPassCreateInfo.npNext(adr, value)
inline var VkRenderPassCreateInfo.flags: VkRenderPassCreateFlags
    get() = VkRenderPassCreateInfo.nflags(adr)
    set(value) = VkRenderPassCreateInfo.nflags(adr, value)
inline val VkRenderPassCreateInfo.attachmentCount get() = VkRenderPassCreateInfo.nattachmentCount(adr)
inline var VkRenderPassCreateInfo.attachments: VkAttachmentDescription.Buffer?
    get() = VkRenderPassCreateInfo.npAttachments(adr)
    set(value) = VkRenderPassCreateInfo.npAttachments(adr, value)
/** JVM custom */
inline var VkRenderPassCreateInfo.attachment: VkAttachmentDescription?
    get() = VkRenderPassCreateInfo.npAttachments(adr)?.get(0)
    set(value) {
        memPutAddress(adr + VkRenderPassCreateInfo.PATTACHMENTS, memAddressSafe(value))
        VkRenderPassCreateInfo.nattachmentCount(adr, if (value == null) 0 else 1)
    }
inline val VkRenderPassCreateInfo.subpassCount get() = VkRenderPassCreateInfo.nsubpassCount(adr)
inline var VkRenderPassCreateInfo.subpasses: VkSubpassDescription.Buffer
    get() = VkRenderPassCreateInfo.npSubpasses(adr)
    set(value) = VkRenderPassCreateInfo.npSubpasses(adr, value)
/** JVM custom */
inline var VkRenderPassCreateInfo.subpass: VkSubpassDescription
    get() = VkRenderPassCreateInfo.npSubpasses(adr)[0]
    set(value) {
        memPutAddress(adr + VkRenderPassCreateInfo.PSUBPASSES, value.address())
        VkRenderPassCreateInfo.nsubpassCount(adr, 1)
    }
inline val VkRenderPassCreateInfo.dependencyCount get() = VkRenderPassCreateInfo.ndependencyCount(adr)
inline var VkRenderPassCreateInfo.dependencies: VkSubpassDependency.Buffer?
    get() = VkRenderPassCreateInfo.npDependencies(adr)
    set(value) = VkRenderPassCreateInfo.npDependencies(adr, value)
/** JVM custom */
inline var VkRenderPassCreateInfo.dependency: VkSubpassDependency?
    get() = VkRenderPassCreateInfo.npDependencies(adr)?.get(0)
    set(value) {
        memPutAddress(adr + VkRenderPassCreateInfo.PDEPENDENCIES, memAddressSafe(value))
        VkRenderPassCreateInfo.ndependencyCount(adr, if (value == null) 0 else 1)
    }


inline var VkCommandPoolCreateInfo.type: VkStructureType
    get() = VkStructureType of VkCommandPoolCreateInfo.nsType(adr)
    set(value) = VkCommandPoolCreateInfo.nsType(adr, value.i)
inline var VkCommandPoolCreateInfo.next
    get() = VkCommandPoolCreateInfo.npNext(adr)
    set(value) = VkCommandPoolCreateInfo.npNext(adr, value)
/** JVM custom */
inline var VkCommandPoolCreateInfo.flag: VkCommandPoolCreate
    get() = TODO()
    set(value) = VkCommandPoolCreateInfo.nflags(adr, value.i)
inline var VkCommandPoolCreateInfo.flags: VkCommandPoolCreateFlags
    get() = VkCommandPoolCreateInfo.nflags(adr)
    set(value) = VkCommandPoolCreateInfo.nflags(adr, value)
inline var VkCommandPoolCreateInfo.queueFamilyIndex
    get() = VkCommandPoolCreateInfo.nqueueFamilyIndex(adr)
    set(value) = VkCommandPoolCreateInfo.nqueueFamilyIndex(adr, value)

//typedef struct VkCommandPoolCreateInfo {
//    VkStructureType             sType;
//    const void*                 pNext;
//    VkCommandPoolCreateFlags    flags;
//    uint32_t                    queueFamilyIndex;
//} VkCommandPoolCreateInfo;

inline var VkCommandBufferAllocateInfo.type: VkStructureType
    get() = VkStructureType of VkCommandBufferAllocateInfo.nsType(adr)
    set(value) = VkCommandBufferAllocateInfo.nsType(adr, value.i)
var VkCommandBufferAllocateInfo.next
    get() = VkCommandBufferAllocateInfo.npNext(adr)
    set(value) = VkCommandBufferAllocateInfo.npNext(adr, value)
var VkCommandBufferAllocateInfo.commandPool: VkCommandPool
    get() = VkCommandBufferAllocateInfo.ncommandPool(adr)
    set(value) = VkCommandBufferAllocateInfo.ncommandPool(adr, value)
var VkCommandBufferAllocateInfo.level: VkCommandBufferLevel
    get() = VkCommandBufferLevel of VkCommandBufferAllocateInfo.nlevel(adr)
    set(value) = VkCommandBufferAllocateInfo.nlevel(adr, value.i)
var VkCommandBufferAllocateInfo.commandBufferCount
    get() = VkCommandBufferAllocateInfo.ncommandBufferCount(adr)
    set(value) = VkCommandBufferAllocateInfo.ncommandBufferCount(adr, value)


//typedef struct VkCommandBufferAllocateInfo {
//    VkStructureType         sType;
//    const void*             pNext;
//    VkCommandPool           commandPool;
//    VkCommandBufferLevel    level;
//    uint32_t                commandBufferCount;
//} VkCommandBufferAllocateInfo;
//
//typedef struct VkCommandBufferInheritanceInfo {
//    VkStructureType                  sType;
//    const void*                      pNext;
//    VkRenderPass                     renderPass;
//    uint32_t                         subpass;
//    VkFramebuffer                    framebuffer;
//    VkBool32                         occlusionQueryEnable;
//    VkQueryControlFlags              queryFlags;
//    VkQueryPipelineStatisticFlags    pipelineStatistics;
//} VkCommandBufferInheritanceInfo;
//

inline var VkCommandBufferBeginInfo.type: VkStructureType
    get() = VkStructureType of VkCommandBufferBeginInfo.nsType(adr)
    set(value) = VkCommandBufferBeginInfo.nsType(adr, value.i)
inline var VkCommandBufferBeginInfo.next
    get() = VkCommandBufferBeginInfo.npNext(adr)
    set(value) = VkCommandBufferBeginInfo.npNext(adr, value)
/** JVM custom */
inline var VkCommandBufferBeginInfo.flag: VkCommandBufferUsage
    get() = TODO()
    set(value) = VkCommandBufferBeginInfo.nflags(adr, value.i)
inline var VkCommandBufferBeginInfo.flags: VkCommandBufferUsageFlags
    get() = VkCommandBufferBeginInfo.nflags(adr)
    set(value) = VkCommandBufferBeginInfo.nflags(adr, value)
inline var VkCommandBufferBeginInfo.inheritanceInfo
    get() = VkCommandBufferBeginInfo.npInheritanceInfo(adr)
    set(value) = VkCommandBufferBeginInfo.npInheritanceInfo(adr, value)


inline var VkBufferCopy.srcOffset: VkDeviceSize
    get() = VkBufferCopy.nsrcOffset(adr)
    set(value) = VkBufferCopy.nsrcOffset(adr, value)
inline var VkBufferCopy.dstOffset: VkDeviceSize
    get() = VkBufferCopy.ndstOffset(adr)
    set(value) = VkBufferCopy.ndstOffset(adr, value)
inline var VkBufferCopy.size: VkDeviceSize
    get() = VkBufferCopy.nsize(adr)
    set(value) = VkBufferCopy.nsize(adr, value)

inline var VkBufferCopy.Buffer.size: VkDeviceSize // TODO remove all .Buffer fields?
    get() = size()
    set(value) {
        size(value)
    }


inline var VkImageSubresourceLayers.aspectMask: VkImageAspectFlags
    get() = VkImageSubresourceLayers.naspectMask(adr)
    set(value) = VkImageSubresourceLayers.naspectMask(adr, value)
inline var VkImageSubresourceLayers.mipLevel: Int
    get() = VkImageSubresourceLayers.nmipLevel(adr)
    set(value) = VkImageSubresourceLayers.nmipLevel(adr, value)
inline var VkImageSubresourceLayers.baseArrayLayer: Int
    get() = VkImageSubresourceLayers.nbaseArrayLayer(adr)
    set(value) = VkImageSubresourceLayers.nbaseArrayLayer(adr, value)
inline var VkImageSubresourceLayers.layerCount: Int
    get() = VkImageSubresourceLayers.nlayerCount(adr)
    set(value) = VkImageSubresourceLayers.nlayerCount(adr, value)


inline var VkImageCopy.srcSubresource: VkImageSubresourceLayers
    get() = VkImageCopy.nsrcSubresource(adr)
    set(value) = VkImageCopy.nsrcSubresource(adr, value)
inline var VkImageCopy.srcOffset: VkOffset3D
    get() = VkImageCopy.nsrcOffset(adr)
    set(value) = VkImageCopy.nsrcOffset(adr, value)
inline var VkImageCopy.dstSubresource: VkImageSubresourceLayers
    get() = VkImageCopy.ndstSubresource(adr)
    set(value) = VkImageCopy.ndstSubresource(adr, value)
inline var VkImageCopy.dstOffset: VkOffset3D
    get() = VkImageCopy.ndstOffset(adr)
    set(value) = VkImageCopy.ndstOffset(adr, value)
inline var VkImageCopy.extent: VkExtent3D
    get() = VkImageCopy.nextent(adr)
    set(value) = VkImageCopy.nextent(adr, value)


inline var VkImageBlit.srcSubresource: VkImageSubresourceLayers
    get() = VkImageBlit.nsrcSubresource(adr)
    set(value) = VkImageBlit.nsrcSubresource(adr, value)
inline var VkImageBlit.srcOffsets: VkOffset3D.Buffer
    get() = VkImageBlit.nsrcOffsets(adr)
    set(value) = VkImageBlit.nsrcOffsets(adr, value)
inline var VkImageBlit.dstSubresource: VkImageSubresourceLayers
    get() = VkImageBlit.ndstSubresource(adr)
    set(value) = VkImageBlit.ndstSubresource(adr, value)
inline var VkImageBlit.dstOffsets: VkOffset3D.Buffer
    get() = VkImageBlit.ndstOffsets(adr)
    set(value) = VkImageBlit.ndstOffsets(adr, value)


inline var VkBufferImageCopy.bufferOffset: VkDeviceSize
    get() = VkBufferImageCopy.nbufferOffset(adr)
    set(value) = VkBufferImageCopy.nbufferOffset(adr, value)
inline var VkBufferImageCopy.bufferRowLength: Int
    get() = VkBufferImageCopy.nbufferRowLength(adr)
    set(value) = VkBufferImageCopy.nbufferRowLength(adr, value)
inline var VkBufferImageCopy.bufferImageHeight: Int
    get() = VkBufferImageCopy.nbufferImageHeight(adr)
    set(value) = VkBufferImageCopy.nbufferImageHeight(adr, value)
inline var VkBufferImageCopy.imageSubresource: VkImageSubresourceLayers
    get() = VkBufferImageCopy.nimageSubresource(adr)
    set(value) = VkBufferImageCopy.nimageSubresource(adr, value)
inline var VkBufferImageCopy.imageOffset: VkOffset3D
    get() = VkBufferImageCopy.nimageOffset(adr)
    set(value) = VkBufferImageCopy.nimageOffset(adr, value)
inline var VkBufferImageCopy.imageExtent: VkExtent3D
    get() = VkBufferImageCopy.nimageExtent(adr)
    set(value) = VkBufferImageCopy.nimageExtent(adr, value)

/** JVM custom */
inline fun VkBufferImageCopy.imageExtent(extent: Vec2i, depth: Int) {
    imageExtent.apply {
        width = extent.x
        height = extent.y
        this.depth = depth
    }
}

/** JVM custom */
inline fun VkBufferImageCopy.imageExtent(extent: Vec3i) {
    this.imageExtent.set(extent.x, extent.y, extent.z)
}

//typedef union VkClearColorValue {
//    float       float32[4];
//    int32_t     int32[4];
//    uint32_t    uint32[4];
//} VkClearColorValue;
//
//typedef struct VkClearDepthStencilValue {
//    float       depth;
//    uint32_t    stencil;
//} VkClearDepthStencilValue;

inline var VkClearValue.color: VkClearColorValue
    get() = VkClearValue.ncolor(adr)
    set(value) = VkClearValue.ncolor(adr, value)
inline var VkClearValue.depthStencil: VkClearDepthStencilValue
    get() = VkClearValue.ndepthStencil(adr)
    set(value) = VkClearValue.ndepthStencil(adr, value)

inline fun VkClearValue.color(float: Float) = color(float, float, float, float)
inline fun VkClearValue.color(color: Vec4) = color(color.r, color.g, color.b, color.a)
inline fun VkClearValue.color(r: Float, g: Float, b: Float, a: Float) {
    memPutFloat(adr, r)
    memPutFloat(adr + Float.BYTES, g)
    memPutFloat(adr + Float.BYTES * 2, b)
    memPutFloat(adr + Float.BYTES * 3, a)
}


inline fun VkClearValue.depthStencil(depth: Float, stencil: Int) {
    memPutFloat(adr, depth)
    memPutInt(adr + Float.BYTES, stencil)
}

//typedef union VkClearValue {
//    VkClearColorValue           color;
//    VkClearDepthStencilValue    depthStencil;
//} VkClearValue;

//typedef struct VkClearAttachment {
//    VkImageAspectFlags    aspectMask;
//    uint32_t              colorAttachment;
//    VkClearValue          clearValue;
//} VkClearAttachment;
//
//typedef struct VkClearRect {
//    VkRect2D    rect;
//    uint32_t    baseArrayLayer;
//    uint32_t    layerCount;
//} VkClearRect;
//
//typedef struct VkImageResolve {
//    VkImageSubresourceLayers    srcSubresource;
//    VkOffset3D                  srcOffset;
//    VkImageSubresourceLayers    dstSubresource;
//    VkOffset3D                  dstOffset;
//    VkExtent3D                  extent;
//} VkImageResolve;
//
//typedef struct VkMemoryBarrier {
//    VkStructureType    sType;
//    const void*        pNext;
//    VkAccessFlags      srcAccessMask;
//    VkAccessFlags      dstAccessMask;
//} VkMemoryBarrier;

inline var VkBufferMemoryBarrier.type: VkStructureType
    get() = VkStructureType of VkBufferMemoryBarrier.nsType(adr)
    set(value) = VkBufferMemoryBarrier.nsType(adr, value.i)
inline var VkBufferMemoryBarrier.next: Long
    get() = VkBufferMemoryBarrier.npNext(adr)
    set(value) = VkBufferMemoryBarrier.npNext(adr, value)
inline var VkBufferMemoryBarrier.srcAccessMask: VkAccessFlags
    get() = VkBufferMemoryBarrier.nsrcAccessMask(adr)
    set(value) = VkBufferMemoryBarrier.nsrcAccessMask(adr, value)
inline var VkBufferMemoryBarrier.dstAccessMask: VkAccessFlags
    get() = VkBufferMemoryBarrier.ndstAccessMask(adr)
    set(value) = VkBufferMemoryBarrier.ndstAccessMask(adr, value)
inline var VkBufferMemoryBarrier.srcQueueFamilyIndex: Int
    get() = VkBufferMemoryBarrier.nsrcQueueFamilyIndex(adr)
    set(value) = VkBufferMemoryBarrier.nsrcQueueFamilyIndex(adr, value)
inline var VkBufferMemoryBarrier.dstQueueFamilyIndex: Int
    get() = VkBufferMemoryBarrier.ndstQueueFamilyIndex(adr)
    set(value) = VkBufferMemoryBarrier.ndstQueueFamilyIndex(adr, value)
inline var VkBufferMemoryBarrier.buffer: VkBuffer
    get() = VkBufferMemoryBarrier.nbuffer(adr)
    set(value) = VkBufferMemoryBarrier.nbuffer(adr, value)
inline var VkBufferMemoryBarrier.offset: VkDeviceSize
    get() = VkBufferMemoryBarrier.noffset(adr)
    set(value) = VkBufferMemoryBarrier.noffset(adr, value)
inline var VkBufferMemoryBarrier.size: VkDeviceSize
    get() = VkBufferMemoryBarrier.nsize(adr)
    set(value) = VkBufferMemoryBarrier.nsize(adr, value)


inline var VkImageMemoryBarrier.type: VkStructureType
    get() = VkStructureType of VkImageMemoryBarrier.nsType(adr)
    set(value) = VkImageMemoryBarrier.nsType(adr, value.i)
inline var VkImageMemoryBarrier.next
    get() = VkImageMemoryBarrier.npNext(adr)
    set(value) = VkImageMemoryBarrier.npNext(adr, value)
inline var VkImageMemoryBarrier.srcAccessMask: VkAccessFlags
    get() = VkImageMemoryBarrier.nsrcAccessMask(adr)
    set(value) = VkImageMemoryBarrier.nsrcAccessMask(adr, value)
inline var VkImageMemoryBarrier.dstAccessMask: VkAccessFlags
    get() = VkImageMemoryBarrier.ndstAccessMask(adr)
    set(value) = VkImageMemoryBarrier.ndstAccessMask(adr, value)
inline var VkImageMemoryBarrier.oldLayout: VkImageLayout
    get() = VkImageLayout of VkImageMemoryBarrier.noldLayout(adr)
    set(value) = VkImageMemoryBarrier.noldLayout(adr, value.i)
inline var VkImageMemoryBarrier.newLayout: VkImageLayout
    get() = VkImageLayout of VkImageMemoryBarrier.nnewLayout(adr)
    set(value) = VkImageMemoryBarrier.nnewLayout(adr, value.i)
inline var VkImageMemoryBarrier.srcQueueFamilyIndex
    get() = VkImageMemoryBarrier.nsrcQueueFamilyIndex(adr)
    set(value) = VkImageMemoryBarrier.nsrcQueueFamilyIndex(adr, value)
inline var VkImageMemoryBarrier.dstQueueFamilyIndex
    get() = VkImageMemoryBarrier.ndstQueueFamilyIndex(adr)
    set(value) = VkImageMemoryBarrier.ndstQueueFamilyIndex(adr, value)
inline var VkImageMemoryBarrier.image: VkImage
    get() = VkImageMemoryBarrier.nimage(adr)
    set(value) = VkImageMemoryBarrier.nimage(adr, value)
inline var VkImageMemoryBarrier.subresourceRange: VkImageSubresourceRange
    get() = VkImageMemoryBarrier.nsubresourceRange(adr)
    set(value) = VkImageMemoryBarrier.nsubresourceRange(adr, value)


inline var VkRenderPassBeginInfo.type: VkStructureType
    get() = VkStructureType of VkRenderPassBeginInfo.nsType(adr)
    set(value) = VkRenderPassBeginInfo.nsType(adr, value.i)
inline var VkRenderPassBeginInfo.next
    get() = VkRenderPassBeginInfo.npNext(adr)
    set(value) = VkRenderPassBeginInfo.npNext(adr, value)
inline var VkRenderPassBeginInfo.renderPass: VkRenderPass
    get() = VkRenderPassBeginInfo.nrenderPass(adr)
    set(value) = VkRenderPassBeginInfo.nrenderPass(adr, value)
inline var VkRenderPassBeginInfo.framebuffer: VkFramebuffer
    get() = VkRenderPassBeginInfo.nframebuffer(adr)
    set(value) = VkRenderPassBeginInfo.nframebuffer(adr, value)
inline var VkRenderPassBeginInfo.renderArea: VkRect2D
    get() = VkRenderPassBeginInfo.nrenderArea(adr)
    set(value) = VkRenderPassBeginInfo.nrenderArea(adr, value)
inline val VkRenderPassBeginInfo.clearValueCount get() = clearValueCount()
inline var VkRenderPassBeginInfo.clearValues: VkClearValue.Buffer?
    get() = VkRenderPassBeginInfo.npClearValues(adr)
    set(value) = VkRenderPassBeginInfo.npClearValues(adr, value)

/** JVM custom */
inline fun VkRenderPassBeginInfo.clearValue(vec4: Vec4) {
    memPutFloat(adr + VkRenderPassBeginInfo.PCLEARVALUES, vec4.x)
    memPutFloat(adr + VkRenderPassBeginInfo.PCLEARVALUES + Float.BYTES, vec4.y)
    memPutFloat(adr + VkRenderPassBeginInfo.PCLEARVALUES + Float.BYTES * 2, vec4.z)
    memPutFloat(adr + VkRenderPassBeginInfo.PCLEARVALUES + Float.BYTES * 3, vec4.w)
    VkRenderPassBeginInfo.nclearValueCount(adr, 1)
}

//typedef struct VkRenderPassBeginInfo {
//    VkStructureType        sType;
//    const void*            pNext;
//    VkRenderPass           renderPass;
//    VkFramebuffer          framebuffer;
//    VkRect2D               renderArea;
//    uint32_t               clearValueCount;
//    const VkClearValue*    pClearValues;
//} VkRenderPassBeginInfo;
//
//typedef struct VkDispatchIndirectCommand {
//    uint32_t    x;
//    uint32_t    y;
//    uint32_t    z;
//} VkDispatchIndirectCommand;
//
//typedef struct VkDrawIndexedIndirectCommand {
//    uint32_t    indexCount;
//    uint32_t    instanceCount;
//    uint32_t    firstIndex;
//    int32_t     vertexOffset;
//    uint32_t    firstInstance;
//} VkDrawIndexedIndirectCommand;
//
//typedef struct VkDrawIndirectCommand {
//    uint32_t    vertexCount;
//    uint32_t    instanceCount;
//    uint32_t    firstVertex;
//    uint32_t    firstInstance;
//} VkDrawIndirectCommand;
//
//
//typedef struct VkBaseOutStructure {
//    VkStructureType               sType;
//    struct VkBaseOutStructure*    pNext;
//} VkBaseOutStructure;
//
//typedef struct VkBaseInStructure {
//    VkStructureType                    sType;
//    const struct VkBaseInStructure*    pNext;
//} VkBaseInStructure;
//
//typedef VkResult (VKAPI_PTR *PFN_vkCreateInstance)(const VkInstanceCreateInfo* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkInstance* pInstance);
//typedef void (VKAPI_PTR *PFN_vkDestroyInstance)(VkInstance instance, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkEnumeratePhysicalDevices)(VkInstance instance, uint32_t* pPhysicalDeviceCount, VkPhysicalDevice* pPhysicalDevices);
//typedef void (VKAPI_PTR *PFN_vkGetPhysicalDeviceFeatures)(VkPhysicalDevice physicalDevice, VkPhysicalDeviceFeatures* pFeatures);
//typedef void (VKAPI_PTR *PFN_vkGetPhysicalDeviceFormatProperties)(VkPhysicalDevice physicalDevice, VkFormat format, VkFormatProperties* pFormatProperties);
//typedef VkResult (VKAPI_PTR *PFN_vkGetPhysicalDeviceImageFormatProperties)(VkPhysicalDevice physicalDevice, VkFormat format, VkImageType type, VkImageTiling tiling, VkImageUsageFlags usage, VkImageCreateFlags flags, VkImageFormatProperties* pImageFormatProperties);
//typedef void (VKAPI_PTR *PFN_vkGetPhysicalDeviceProperties)(VkPhysicalDevice physicalDevice, VkPhysicalDeviceProperties* pProperties);
//typedef void (VKAPI_PTR *PFN_vkGetPhysicalDeviceQueueFamilyProperties)(VkPhysicalDevice physicalDevice, uint32_t* pQueueFamilyPropertyCount, VkQueueFamilyProperties* pQueueFamilyProperties);
//typedef void (VKAPI_PTR *PFN_vkGetPhysicalDeviceMemoryProperties)(VkPhysicalDevice physicalDevice, VkPhysicalDeviceMemoryProperties* pMemoryProperties);
//typedef PFN_vkVoidFunction (VKAPI_PTR *PFN_vkGetInstanceProcAddr)(VkInstance instance, const char* pName);
//typedef PFN_vkVoidFunction (VKAPI_PTR *PFN_vkGetDeviceProcAddr)(VkDevice device, const char* pName);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateDevice)(VkPhysicalDevice physicalDevice, const VkDeviceCreateInfo* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkDevice* pDevice);
//typedef void (VKAPI_PTR *PFN_vkDestroyDevice)(VkDevice device, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkEnumerateInstanceExtensionProperties)(const char* pLayerName, uint32_t* pPropertyCount, VkExtensionProperties* pProperties);
//typedef VkResult (VKAPI_PTR *PFN_vkEnumerateDeviceExtensionProperties)(VkPhysicalDevice physicalDevice, const char* pLayerName, uint32_t* pPropertyCount, VkExtensionProperties* pProperties);
//typedef VkResult (VKAPI_PTR *PFN_vkEnumerateInstanceLayerProperties)(uint32_t* pPropertyCount, VkLayerProperties* pProperties);
//typedef VkResult (VKAPI_PTR *PFN_vkEnumerateDeviceLayerProperties)(VkPhysicalDevice physicalDevice, uint32_t* pPropertyCount, VkLayerProperties* pProperties);
//typedef void (VKAPI_PTR *PFN_vkGetDeviceQueue)(VkDevice device, uint32_t queueFamilyIndex, uint32_t queueIndex, VkQueue* pQueue);
//typedef VkResult (VKAPI_PTR *PFN_vkQueueSubmit)(VkQueue queue, uint32_t submitCount, const VkSubmitInfo* pSubmits, VkFence fence);
//typedef VkResult (VKAPI_PTR *PFN_vkQueueWaitIdle)(VkQueue queue);
//typedef VkResult (VKAPI_PTR *PFN_vkDeviceWaitIdle)(VkDevice device);
//typedef VkResult (VKAPI_PTR *PFN_vkAllocateMemory)(VkDevice device, const VkMemoryAllocateInfo* pAllocateInfo, const VkAllocationCallbacks* pAllocator, VkDeviceMemory* pMemory);
//typedef void (VKAPI_PTR *PFN_vkFreeMemory)(VkDevice device, VkDeviceMemory memory, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkMapMemory)(VkDevice device, VkDeviceMemory memory, VkDeviceSize offset, VkDeviceSize size, VkMemoryMapFlags flags, void** ppData);
//typedef void (VKAPI_PTR *PFN_vkUnmapMemory)(VkDevice device, VkDeviceMemory memory);
//typedef VkResult (VKAPI_PTR *PFN_vkFlushMappedMemoryRanges)(VkDevice device, uint32_t memoryRangeCount, const VkMappedMemoryRange* pMemoryRanges);
//typedef VkResult (VKAPI_PTR *PFN_vkInvalidateMappedMemoryRanges)(VkDevice device, uint32_t memoryRangeCount, const VkMappedMemoryRange* pMemoryRanges);
//typedef void (VKAPI_PTR *PFN_vkGetDeviceMemoryCommitment)(VkDevice device, VkDeviceMemory memory, VkDeviceSize* pCommittedMemoryInBytes);
//typedef VkResult (VKAPI_PTR *PFN_vkBindBufferMemory)(VkDevice device, VkBuffer buffer, VkDeviceMemory memory, VkDeviceSize memoryOffset);
//typedef VkResult (VKAPI_PTR *PFN_vkBindImageMemory)(VkDevice device, VkImage image, VkDeviceMemory memory, VkDeviceSize memoryOffset);
//typedef void (VKAPI_PTR *PFN_vkGetBufferMemoryRequirements)(VkDevice device, VkBuffer buffer, VkMemoryRequirements* pMemoryRequirements);
//typedef void (VKAPI_PTR *PFN_vkGetImageMemoryRequirements)(VkDevice device, VkImage image, VkMemoryRequirements* pMemoryRequirements);
//typedef void (VKAPI_PTR *PFN_vkGetImageSparseMemoryRequirements)(VkDevice device, VkImage image, uint32_t* pSparseMemoryRequirementCount, VkSparseImageMemoryRequirements* pSparseMemoryRequirements);
//typedef void (VKAPI_PTR *PFN_vkGetPhysicalDeviceSparseImageFormatProperties)(VkPhysicalDevice physicalDevice, VkFormat format, VkImageType type, VkSampleCountFlagBits samples, VkImageUsageFlags usage, VkImageTiling tiling, uint32_t* pPropertyCount, VkSparseImageFormatProperties* pProperties);
//typedef VkResult (VKAPI_PTR *PFN_vkQueueBindSparse)(VkQueue queue, uint32_t bindInfoCount, const VkBindSparseInfo* pBindInfo, VkFence fence);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateFence)(VkDevice device, const VkFenceCreateInfo* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkFence* pFence);
//typedef void (VKAPI_PTR *PFN_vkDestroyFence)(VkDevice device, VkFence fence, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkResetFences)(VkDevice device, uint32_t fenceCount, const VkFence* pFences);
//typedef VkResult (VKAPI_PTR *PFN_vkGetFenceStatus)(VkDevice device, VkFence fence);
//typedef VkResult (VKAPI_PTR *PFN_vkWaitForFences)(VkDevice device, uint32_t fenceCount, const VkFence* pFences, VkBool32 waitAll, uint64_t timeout);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateSemaphore)(VkDevice device, const VkSemaphoreCreateInfo* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkSemaphore* pSemaphore);
//typedef void (VKAPI_PTR *PFN_vkDestroySemaphore)(VkDevice device, VkSemaphore semaphore, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateEvent)(VkDevice device, const VkEventCreateInfo* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkEvent* pEvent);
//typedef void (VKAPI_PTR *PFN_vkDestroyEvent)(VkDevice device, VkEvent event, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkGetEventStatus)(VkDevice device, VkEvent event);
//typedef VkResult (VKAPI_PTR *PFN_vkSetEvent)(VkDevice device, VkEvent event);
//typedef VkResult (VKAPI_PTR *PFN_vkResetEvent)(VkDevice device, VkEvent event);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateQueryPool)(VkDevice device, const VkQueryPoolCreateInfo* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkQueryPool* pQueryPool);
//typedef void (VKAPI_PTR *PFN_vkDestroyQueryPool)(VkDevice device, VkQueryPool queryPool, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkGetQueryPoolResults)(VkDevice device, VkQueryPool queryPool, uint32_t firstQuery, uint32_t queryCount, size_t dataSize, void* pData, VkDeviceSize stride, VkQueryResultFlags flags);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateBuffer)(VkDevice device, const VkBufferCreateInfo* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkBuffer* pBuffer);
//typedef void (VKAPI_PTR *PFN_vkDestroyBuffer)(VkDevice device, VkBuffer buffer, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateBufferView)(VkDevice device, const VkBufferViewCreateInfo* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkBufferView* pView);
//typedef void (VKAPI_PTR *PFN_vkDestroyBufferView)(VkDevice device, VkBufferView bufferView, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateImage)(VkDevice device, const VkImageCreateInfo* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkImage* pImage);
//typedef void (VKAPI_PTR *PFN_vkDestroyImage)(VkDevice device, VkImage image, const VkAllocationCallbacks* pAllocator);
//typedef void (VKAPI_PTR *PFN_vkGetImageSubresourceLayout)(VkDevice device, VkImage image, const VkImageSubresource* pSubresource, VkSubresourceLayout* pLayout);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateImageView)(VkDevice device, const VkImageViewCreateInfo* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkImageView* pView);
//typedef void (VKAPI_PTR *PFN_vkDestroyImageView)(VkDevice device, VkImageView imageView, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateShaderModule)(VkDevice device, const VkShaderModuleCreateInfo* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkShaderModule* pShaderModule);
//typedef void (VKAPI_PTR *PFN_vkDestroyShaderModule)(VkDevice device, VkShaderModule shaderModule, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkCreatePipelineCache)(VkDevice device, const VkPipelineCacheCreateInfo* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkPipelineCache* pPipelineCache);
//typedef void (VKAPI_PTR *PFN_vkDestroyPipelineCache)(VkDevice device, VkPipelineCache pipelineCache, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkGetPipelineCacheData)(VkDevice device, VkPipelineCache pipelineCache, size_t* pDataSize, void* pData);
//typedef VkResult (VKAPI_PTR *PFN_vkMergePipelineCaches)(VkDevice device, VkPipelineCache dstCache, uint32_t srcCacheCount, const VkPipelineCache* pSrcCaches);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateGraphicsPipelines)(VkDevice device, VkPipelineCache pipelineCache, uint32_t createInfoCount, const VkGraphicsPipelineCreateInfo* pCreateInfos, const VkAllocationCallbacks* pAllocator, VkPipeline* pPipelines);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateComputePipelines)(VkDevice device, VkPipelineCache pipelineCache, uint32_t createInfoCount, const VkComputePipelineCreateInfo* pCreateInfos, const VkAllocationCallbacks* pAllocator, VkPipeline* pPipelines);
//typedef void (VKAPI_PTR *PFN_vkDestroyPipeline)(VkDevice device, VkPipeline pipeline, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkCreatePipelineLayout)(VkDevice device, const VkPipelineLayoutCreateInfo* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkPipelineLayout* pPipelineLayout);
//typedef void (VKAPI_PTR *PFN_vkDestroyPipelineLayout)(VkDevice device, VkPipelineLayout pipelineLayout, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateSampler)(VkDevice device, const VkSamplerCreateInfo* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkSampler* pSampler);
//typedef void (VKAPI_PTR *PFN_vkDestroySampler)(VkDevice device, VkSampler sampler, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateDescriptorSetLayout)(VkDevice device, const VkDescriptorSetLayoutCreateInfo* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkDescriptorSetLayout* pSetLayout);
//typedef void (VKAPI_PTR *PFN_vkDestroyDescriptorSetLayout)(VkDevice device, VkDescriptorSetLayout descriptorSetLayout, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateDescriptorPool)(VkDevice device, const VkDescriptorPoolCreateInfo* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkDescriptorPool* pDescriptorPool);
//typedef void (VKAPI_PTR *PFN_vkDestroyDescriptorPool)(VkDevice device, VkDescriptorPool descriptorPool, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkResetDescriptorPool)(VkDevice device, VkDescriptorPool descriptorPool, VkDescriptorPoolResetFlags flags);
//typedef VkResult (VKAPI_PTR *PFN_vkAllocateDescriptorSets)(VkDevice device, const VkDescriptorSetAllocateInfo* pAllocateInfo, VkDescriptorSet* pDescriptorSets);
//typedef VkResult (VKAPI_PTR *PFN_vkFreeDescriptorSets)(VkDevice device, VkDescriptorPool descriptorPool, uint32_t descriptorSetCount, const VkDescriptorSet* pDescriptorSets);
//typedef void (VKAPI_PTR *PFN_vkUpdateDescriptorSets)(VkDevice device, uint32_t descriptorWriteCount, const VkWriteDescriptorSet* pDescriptorWrites, uint32_t descriptorCopyCount, const VkCopyDescriptorSet* pDescriptorCopies);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateFramebuffer)(VkDevice device, const VkFramebufferCreateInfo* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkFramebuffer* pFramebuffer);
//typedef void (VKAPI_PTR *PFN_vkDestroyFramebuffer)(VkDevice device, VkFramebuffer framebuffer, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateRenderPass)(VkDevice device, const VkRenderPassCreateInfo* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkRenderPass* pRenderPass);
//typedef void (VKAPI_PTR *PFN_vkDestroyRenderPass)(VkDevice device, VkRenderPass renderPass, const VkAllocationCallbacks* pAllocator);
//typedef void (VKAPI_PTR *PFN_vkGetRenderAreaGranularity)(VkDevice device, VkRenderPass renderPass, VkExtent2D* pGranularity);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateCommandPool)(VkDevice device, const VkCommandPoolCreateInfo* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkCommandPool* pCommandPool);
//typedef void (VKAPI_PTR *PFN_vkDestroyCommandPool)(VkDevice device, VkCommandPool commandPool, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkResetCommandPool)(VkDevice device, VkCommandPool commandPool, VkCommandPoolResetFlags flags);
//typedef VkResult (VKAPI_PTR *PFN_vkAllocateCommandBuffers)(VkDevice device, const VkCommandBufferAllocateInfo* pAllocateInfo, VkCommandBuffer* pCommandBuffers);
//typedef void (VKAPI_PTR *PFN_vkFreeCommandBuffers)(VkDevice device, VkCommandPool commandPool, uint32_t commandBufferCount, const VkCommandBuffer* pCommandBuffers);
//typedef VkResult (VKAPI_PTR *PFN_vkBeginCommandBuffer)(VkCommandBuffer commandBuffer, const VkCommandBufferBeginInfo* pBeginInfo);
//typedef VkResult (VKAPI_PTR *PFN_vkEndCommandBuffer)(VkCommandBuffer commandBuffer);
//typedef VkResult (VKAPI_PTR *PFN_vkResetCommandBuffer)(VkCommandBuffer commandBuffer, VkCommandBufferResetFlags flags);
//typedef void (VKAPI_PTR *PFN_vkCmdBindPipeline)(VkCommandBuffer commandBuffer, VkPipelineBindPoint pipelineBindPoint, VkPipeline pipeline);
//typedef void (VKAPI_PTR *PFN_vkCmdSetViewport)(VkCommandBuffer commandBuffer, uint32_t firstViewport, uint32_t viewportCount, const VkViewport* pViewports);
//typedef void (VKAPI_PTR *PFN_vkCmdSetScissor)(VkCommandBuffer commandBuffer, uint32_t firstScissor, uint32_t scissorCount, const VkRect2D* pScissors);
//typedef void (VKAPI_PTR *PFN_vkCmdSetLineWidth)(VkCommandBuffer commandBuffer, float lineWidth);
//typedef void (VKAPI_PTR *PFN_vkCmdSetDepthBias)(VkCommandBuffer commandBuffer, float depthBiasConstantFactor, float depthBiasClamp, float depthBiasSlopeFactor);
//typedef void (VKAPI_PTR *PFN_vkCmdSetBlendConstants)(VkCommandBuffer commandBuffer, const float blendConstants[4]);
//typedef void (VKAPI_PTR *PFN_vkCmdSetDepthBounds)(VkCommandBuffer commandBuffer, float minDepthBounds, float maxDepthBounds);
//typedef void (VKAPI_PTR *PFN_vkCmdSetStencilCompareMask)(VkCommandBuffer commandBuffer, VkStencilFaceFlags faceMask, uint32_t compareMask);
//typedef void (VKAPI_PTR *PFN_vkCmdSetStencilWriteMask)(VkCommandBuffer commandBuffer, VkStencilFaceFlags faceMask, uint32_t writeMask);
//typedef void (VKAPI_PTR *PFN_vkCmdSetStencilReference)(VkCommandBuffer commandBuffer, VkStencilFaceFlags faceMask, uint32_t reference);
//typedef void (VKAPI_PTR *PFN_vkCmdBindDescriptorSets)(VkCommandBuffer commandBuffer, VkPipelineBindPoint pipelineBindPoint, VkPipelineLayout layout, uint32_t firstSet, uint32_t descriptorSetCount, const VkDescriptorSet* pDescriptorSets, uint32_t dynamicOffsetCount, const uint32_t* pDynamicOffsets);
//typedef void (VKAPI_PTR *PFN_vkCmdBindIndexBuffer)(VkCommandBuffer commandBuffer, VkBuffer buffer, VkDeviceSize offset, VkIndexType indexType);
//typedef void (VKAPI_PTR *PFN_vkCmdBindVertexBuffers)(VkCommandBuffer commandBuffer, uint32_t firstBinding, uint32_t bindingCount, const VkBuffer* pBuffers, const VkDeviceSize* pOffsets);
//typedef void (VKAPI_PTR *PFN_vkCmdDraw)(VkCommandBuffer commandBuffer, uint32_t vertexCount, uint32_t instanceCount, uint32_t firstVertex, uint32_t firstInstance);
//typedef void (VKAPI_PTR *PFN_vkCmdDrawIndexed)(VkCommandBuffer commandBuffer, uint32_t indexCount, uint32_t instanceCount, uint32_t firstIndex, int32_t vertexOffset, uint32_t firstInstance);
//typedef void (VKAPI_PTR *PFN_vkCmdDrawIndirect)(VkCommandBuffer commandBuffer, VkBuffer buffer, VkDeviceSize offset, uint32_t drawCount, uint32_t stride);
//typedef void (VKAPI_PTR *PFN_vkCmdDrawIndexedIndirect)(VkCommandBuffer commandBuffer, VkBuffer buffer, VkDeviceSize offset, uint32_t drawCount, uint32_t stride);
//typedef void (VKAPI_PTR *PFN_vkCmdDispatch)(VkCommandBuffer commandBuffer, uint32_t groupCountX, uint32_t groupCountY, uint32_t groupCountZ);
//typedef void (VKAPI_PTR *PFN_vkCmdDispatchIndirect)(VkCommandBuffer commandBuffer, VkBuffer buffer, VkDeviceSize offset);
//typedef void (VKAPI_PTR *PFN_vkCmdCopyBuffer)(VkCommandBuffer commandBuffer, VkBuffer srcBuffer, VkBuffer dstBuffer, uint32_t regionCount, const VkBufferCopy* pRegions);
//typedef void (VKAPI_PTR *PFN_vkCmdCopyImage)(VkCommandBuffer commandBuffer, VkImage srcImage, VkImageLayout srcImageLayout, VkImage dstImage, VkImageLayout dstImageLayout, uint32_t regionCount, const VkImageCopy* pRegions);
//typedef void (VKAPI_PTR *PFN_vkCmdBlitImage)(VkCommandBuffer commandBuffer, VkImage srcImage, VkImageLayout srcImageLayout, VkImage dstImage, VkImageLayout dstImageLayout, uint32_t regionCount, const VkImageBlit* pRegions, VkFilter filter);
//typedef void (VKAPI_PTR *PFN_vkCmdCopyBufferToImage)(VkCommandBuffer commandBuffer, VkBuffer srcBuffer, VkImage dstImage, VkImageLayout dstImageLayout, uint32_t regionCount, const VkBufferImageCopy* pRegions);
//typedef void (VKAPI_PTR *PFN_vkCmdCopyImageToBuffer)(VkCommandBuffer commandBuffer, VkImage srcImage, VkImageLayout srcImageLayout, VkBuffer dstBuffer, uint32_t regionCount, const VkBufferImageCopy* pRegions);
//typedef void (VKAPI_PTR *PFN_vkCmdUpdateBuffer)(VkCommandBuffer commandBuffer, VkBuffer dstBuffer, VkDeviceSize dstOffset, VkDeviceSize dataSize, const void* pData);
//typedef void (VKAPI_PTR *PFN_vkCmdFillBuffer)(VkCommandBuffer commandBuffer, VkBuffer dstBuffer, VkDeviceSize dstOffset, VkDeviceSize size, uint32_t data);
//typedef void (VKAPI_PTR *PFN_vkCmdClearColorImage)(VkCommandBuffer commandBuffer, VkImage image, VkImageLayout imageLayout, const VkClearColorValue* pColor, uint32_t rangeCount, const VkImageSubresourceRange* pRanges);
//typedef void (VKAPI_PTR *PFN_vkCmdClearDepthStencilImage)(VkCommandBuffer commandBuffer, VkImage image, VkImageLayout imageLayout, const VkClearDepthStencilValue* pDepthStencil, uint32_t rangeCount, const VkImageSubresourceRange* pRanges);
//typedef void (VKAPI_PTR *PFN_vkCmdClearAttachments)(VkCommandBuffer commandBuffer, uint32_t attachmentCount, const VkClearAttachment* pAttachments, uint32_t rectCount, const VkClearRect* pRects);
//typedef void (VKAPI_PTR *PFN_vkCmdResolveImage)(VkCommandBuffer commandBuffer, VkImage srcImage, VkImageLayout srcImageLayout, VkImage dstImage, VkImageLayout dstImageLayout, uint32_t regionCount, const VkImageResolve* pRegions);
//typedef void (VKAPI_PTR *PFN_vkCmdSetEvent)(VkCommandBuffer commandBuffer, VkEvent event, VkPipelineStageFlags stageMask);
//typedef void (VKAPI_PTR *PFN_vkCmdResetEvent)(VkCommandBuffer commandBuffer, VkEvent event, VkPipelineStageFlags stageMask);
//typedef void (VKAPI_PTR *PFN_vkCmdWaitEvents)(VkCommandBuffer commandBuffer, uint32_t eventCount, const VkEvent* pEvents, VkPipelineStageFlags srcStageMask, VkPipelineStageFlags dstStageMask, uint32_t memoryBarrierCount, const VkMemoryBarrier* pMemoryBarriers, uint32_t bufferMemoryBarrierCount, const VkBufferMemoryBarrier* pBufferMemoryBarriers, uint32_t imageMemoryBarrierCount, const VkImageMemoryBarrier* pImageMemoryBarriers);
//typedef void (VKAPI_PTR *PFN_vkCmdPipelineBarrier)(VkCommandBuffer commandBuffer, VkPipelineStageFlags srcStageMask, VkPipelineStageFlags dstStageMask, VkDependencyFlags dependencyFlags, uint32_t memoryBarrierCount, const VkMemoryBarrier* pMemoryBarriers, uint32_t bufferMemoryBarrierCount, const VkBufferMemoryBarrier* pBufferMemoryBarriers, uint32_t imageMemoryBarrierCount, const VkImageMemoryBarrier* pImageMemoryBarriers);
//typedef void (VKAPI_PTR *PFN_vkCmdBeginQuery)(VkCommandBuffer commandBuffer, VkQueryPool queryPool, uint32_t query, VkQueryControlFlags flags);
//typedef void (VKAPI_PTR *PFN_vkCmdEndQuery)(VkCommandBuffer commandBuffer, VkQueryPool queryPool, uint32_t query);
//typedef void (VKAPI_PTR *PFN_vkCmdResetQueryPool)(VkCommandBuffer commandBuffer, VkQueryPool queryPool, uint32_t firstQuery, uint32_t queryCount);
//typedef void (VKAPI_PTR *PFN_vkCmdWriteTimestamp)(VkCommandBuffer commandBuffer, VkPipelineStageFlagBits pipelineStage, VkQueryPool queryPool, uint32_t query);
//typedef void (VKAPI_PTR *PFN_vkCmdCopyQueryPoolResults)(VkCommandBuffer commandBuffer, VkQueryPool queryPool, uint32_t firstQuery, uint32_t queryCount, VkBuffer dstBuffer, VkDeviceSize dstOffset, VkDeviceSize stride, VkQueryResultFlags flags);
//typedef void (VKAPI_PTR *PFN_vkCmdPushConstants)(VkCommandBuffer commandBuffer, VkPipelineLayout layout, VkShaderStageFlags stageFlags, uint32_t offset, uint32_t size, const void* pValues);
//typedef void (VKAPI_PTR *PFN_vkCmdBeginRenderPass)(VkCommandBuffer commandBuffer, const VkRenderPassBeginInfo* pRenderPassBegin, VkSubpassContents contents);
//typedef void (VKAPI_PTR *PFN_vkCmdNextSubpass)(VkCommandBuffer commandBuffer, VkSubpassContents contents);
//typedef void (VKAPI_PTR *PFN_vkCmdEndRenderPass)(VkCommandBuffer commandBuffer);
//typedef void (VKAPI_PTR *PFN_vkCmdExecuteCommands)(VkCommandBuffer commandBuffer, uint32_t commandBufferCount, const VkCommandBuffer* pCommandBuffers);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateInstance(
//const VkInstanceCreateInfo*                 pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkInstance*                                 pInstance);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyInstance(
//VkInstance                                  instance,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkEnumeratePhysicalDevices(
//VkInstance                                  instance,
//uint32_t*                                   pPhysicalDeviceCount,
//VkPhysicalDevice*                           pPhysicalDevices);
//
//VKAPI_ATTR void VKAPI_CALL vkGetPhysicalDeviceFeatures(
//VkPhysicalDevice                            physicalDevice,
//VkPhysicalDeviceFeatures*                   pFeatures);
//
//VKAPI_ATTR void VKAPI_CALL vkGetPhysicalDeviceFormatProperties(
//VkPhysicalDevice                            physicalDevice,
//VkFormat                                    format,
//VkFormatProperties*                         pFormatProperties);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetPhysicalDeviceImageFormatProperties(
//VkPhysicalDevice                            physicalDevice,
//VkFormat                                    format,
//VkImageType                                 type,
//VkImageTiling                               tiling,
//VkImageUsageFlags                           usage,
//VkImageCreateFlags                          flags,
//VkImageFormatProperties*                    pImageFormatProperties);
//
//VKAPI_ATTR void VKAPI_CALL vkGetPhysicalDeviceProperties(
//VkPhysicalDevice                            physicalDevice,
//VkPhysicalDeviceProperties*                 pProperties);
//
//VKAPI_ATTR void VKAPI_CALL vkGetPhysicalDeviceQueueFamilyProperties(
//VkPhysicalDevice                            physicalDevice,
//uint32_t*                                   pQueueFamilyPropertyCount,
//VkQueueFamilyProperties*                    pQueueFamilyProperties);
//
//VKAPI_ATTR void VKAPI_CALL vkGetPhysicalDeviceMemoryProperties(
//VkPhysicalDevice                            physicalDevice,
//VkPhysicalDeviceMemoryProperties*           pMemoryProperties);
//
//VKAPI_ATTR PFN_vkVoidFunction VKAPI_CALL vkGetInstanceProcAddr(
//VkInstance                                  instance,
//const char*                                 pName);
//
//VKAPI_ATTR PFN_vkVoidFunction VKAPI_CALL vkGetDeviceProcAddr(
//VkDevice                                    device,
//const char*                                 pName);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateDevice(
//VkPhysicalDevice                            physicalDevice,
//const VkDeviceCreateInfo*                   pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkDevice*                                   pDevice);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyDevice(
//VkDevice                                    device,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkEnumerateInstanceExtensionProperties(
//const char*                                 pLayerName,
//uint32_t*                                   pPropertyCount,
//VkExtensionProperties*                      pProperties);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkEnumerateDeviceExtensionProperties(
//VkPhysicalDevice                            physicalDevice,
//const char*                                 pLayerName,
//uint32_t*                                   pPropertyCount,
//VkExtensionProperties*                      pProperties);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkEnumerateInstanceLayerProperties(
//uint32_t*                                   pPropertyCount,
//VkLayerProperties*                          pProperties);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkEnumerateDeviceLayerProperties(
//VkPhysicalDevice                            physicalDevice,
//uint32_t*                                   pPropertyCount,
//VkLayerProperties*                          pProperties);
//
//VKAPI_ATTR void VKAPI_CALL vkGetDeviceQueue(
//VkDevice                                    device,
//uint32_t                                    queueFamilyIndex,
//uint32_t                                    queueIndex,
//VkQueue*                                    pQueue);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkQueueSubmit(
//VkQueue                                     queue,
//uint32_t                                    submitCount,
//const VkSubmitInfo*                         pSubmits,
//VkFence                                     fence);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkQueueWaitIdle(
//VkQueue                                     queue);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkDeviceWaitIdle(
//VkDevice                                    device);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkAllocateMemory(
//VkDevice                                    device,
//const VkMemoryAllocateInfo*                 pAllocateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkDeviceMemory*                             pMemory);
//
//VKAPI_ATTR void VKAPI_CALL vkFreeMemory(
//VkDevice                                    device,
//VkDeviceMemory                              memory,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkMapMemory(
//VkDevice                                    device,
//VkDeviceMemory                              memory,
//VkDeviceSize                                offset,
//VkDeviceSize                                size,
//VkMemoryMapFlags                            flags,
//void**                                      ppData);
//
//VKAPI_ATTR void VKAPI_CALL vkUnmapMemory(
//VkDevice                                    device,
//VkDeviceMemory                              memory);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkFlushMappedMemoryRanges(
//VkDevice                                    device,
//uint32_t                                    memoryRangeCount,
//const VkMappedMemoryRange*                  pMemoryRanges);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkInvalidateMappedMemoryRanges(
//VkDevice                                    device,
//uint32_t                                    memoryRangeCount,
//const VkMappedMemoryRange*                  pMemoryRanges);
//
//VKAPI_ATTR void VKAPI_CALL vkGetDeviceMemoryCommitment(
//VkDevice                                    device,
//VkDeviceMemory                              memory,
//VkDeviceSize*                               pCommittedMemoryInBytes);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkBindBufferMemory(
//VkDevice                                    device,
//VkBuffer                                    buffer,
//VkDeviceMemory                              memory,
//VkDeviceSize                                memoryOffset);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkBindImageMemory(
//VkDevice                                    device,
//VkImage                                     image,
//VkDeviceMemory                              memory,
//VkDeviceSize                                memoryOffset);
//
//VKAPI_ATTR void VKAPI_CALL vkGetBufferMemoryRequirements(
//VkDevice                                    device,
//VkBuffer                                    buffer,
//VkMemoryRequirements*                       pMemoryRequirements);
//
//VKAPI_ATTR void VKAPI_CALL vkGetImageMemoryRequirements(
//VkDevice                                    device,
//VkImage                                     image,
//VkMemoryRequirements*                       pMemoryRequirements);
//
//VKAPI_ATTR void VKAPI_CALL vkGetImageSparseMemoryRequirements(
//VkDevice                                    device,
//VkImage                                     image,
//uint32_t*                                   pSparseMemoryRequirementCount,
//VkSparseImageMemoryRequirements*            pSparseMemoryRequirements);
//
//VKAPI_ATTR void VKAPI_CALL vkGetPhysicalDeviceSparseImageFormatProperties(
//VkPhysicalDevice                            physicalDevice,
//VkFormat                                    format,
//VkImageType                                 type,
//VkSampleCountFlagBits                       samples,
//VkImageUsageFlags                           usage,
//VkImageTiling                               tiling,
//uint32_t*                                   pPropertyCount,
//VkSparseImageFormatProperties*              pProperties);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkQueueBindSparse(
//VkQueue                                     queue,
//uint32_t                                    bindInfoCount,
//const VkBindSparseInfo*                     pBindInfo,
//VkFence                                     fence);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateFence(
//VkDevice                                    device,
//const VkFenceCreateInfo*                    pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkFence*                                    pFence);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyFence(
//VkDevice                                    device,
//VkFence                                     fence,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkResetFences(
//VkDevice                                    device,
//uint32_t                                    fenceCount,
//const VkFence*                              pFences);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetFenceStatus(
//VkDevice                                    device,
//VkFence                                     fence);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkWaitForFences(
//VkDevice                                    device,
//uint32_t                                    fenceCount,
//const VkFence*                              pFences,
//VkBool32                                    waitAll,
//uint64_t                                    timeout);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateSemaphore(
//VkDevice                                    device,
//const VkSemaphoreCreateInfo*                pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkSemaphore*                                pSemaphore);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroySemaphore(
//VkDevice                                    device,
//VkSemaphore                                 semaphore,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateEvent(
//VkDevice                                    device,
//const VkEventCreateInfo*                    pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkEvent*                                    pEvent);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyEvent(
//VkDevice                                    device,
//VkEvent                                     event,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetEventStatus(
//VkDevice                                    device,
//VkEvent                                     event);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkSetEvent(
//VkDevice                                    device,
//VkEvent                                     event);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkResetEvent(
//VkDevice                                    device,
//VkEvent                                     event);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateQueryPool(
//VkDevice                                    device,
//const VkQueryPoolCreateInfo*                pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkQueryPool*                                pQueryPool);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyQueryPool(
//VkDevice                                    device,
//VkQueryPool                                 queryPool,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetQueryPoolResults(
//VkDevice                                    device,
//VkQueryPool                                 queryPool,
//uint32_t                                    firstQuery,
//uint32_t                                    queryCount,
//size_t                                      dataSize,
//void*                                       pData,
//VkDeviceSize                                stride,
//VkQueryResultFlags                          flags);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateBuffer(
//VkDevice                                    device,
//const VkBufferCreateInfo*                   pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkBuffer*                                   pBuffer);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyBuffer(
//VkDevice                                    device,
//VkBuffer                                    buffer,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateBufferView(
//VkDevice                                    device,
//const VkBufferViewCreateInfo*               pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkBufferView*                               pView);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyBufferView(
//VkDevice                                    device,
//VkBufferView                                bufferView,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateImage(
//VkDevice                                    device,
//const VkImageCreateInfo*                    pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkImage*                                    pImage);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyImage(
//VkDevice                                    device,
//VkImage                                     image,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR void VKAPI_CALL vkGetImageSubresourceLayout(
//VkDevice                                    device,
//VkImage                                     image,
//const VkImageSubresource*                   pSubresource,
//VkSubresourceLayout*                        pLayout);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateImageView(
//VkDevice                                    device,
//const VkImageViewCreateInfo*                pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkImageView*                                pView);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyImageView(
//VkDevice                                    device,
//VkImageView                                 imageView,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateShaderModule(
//VkDevice                                    device,
//const VkShaderModuleCreateInfo*             pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkShaderModule*                             pShaderModule);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyShaderModule(
//VkDevice                                    device,
//VkShaderModule                              shaderModule,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreatePipelineCache(
//VkDevice                                    device,
//const VkPipelineCacheCreateInfo*            pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkPipelineCache*                            pPipelineCache);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyPipelineCache(
//VkDevice                                    device,
//VkPipelineCache                             pipelineCache,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetPipelineCacheData(
//VkDevice                                    device,
//VkPipelineCache                             pipelineCache,
//size_t*                                     pDataSize,
//void*                                       pData);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkMergePipelineCaches(
//VkDevice                                    device,
//VkPipelineCache                             dstCache,
//uint32_t                                    srcCacheCount,
//const VkPipelineCache*                      pSrcCaches);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateGraphicsPipelines(
//VkDevice                                    device,
//VkPipelineCache                             pipelineCache,
//uint32_t                                    createInfoCount,
//const VkGraphicsPipelineCreateInfo*         pCreateInfos,
//const VkAllocationCallbacks*                pAllocator,
//VkPipeline*                                 pPipelines);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateComputePipelines(
//VkDevice                                    device,
//VkPipelineCache                             pipelineCache,
//uint32_t                                    createInfoCount,
//const VkComputePipelineCreateInfo*          pCreateInfos,
//const VkAllocationCallbacks*                pAllocator,
//VkPipeline*                                 pPipelines);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyPipeline(
//VkDevice                                    device,
//VkPipeline                                  pipeline,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreatePipelineLayout(
//VkDevice                                    device,
//const VkPipelineLayoutCreateInfo*           pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkPipelineLayout*                           pPipelineLayout);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyPipelineLayout(
//VkDevice                                    device,
//VkPipelineLayout                            pipelineLayout,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateSampler(
//VkDevice                                    device,
//const VkSamplerCreateInfo*                  pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkSampler*                                  pSampler);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroySampler(
//VkDevice                                    device,
//VkSampler                                   sampler,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateDescriptorSetLayout(
//VkDevice                                    device,
//const VkDescriptorSetLayoutCreateInfo*      pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkDescriptorSetLayout*                      pSetLayout);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyDescriptorSetLayout(
//VkDevice                                    device,
//VkDescriptorSetLayout                       descriptorSetLayout,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateDescriptorPool(
//VkDevice                                    device,
//const VkDescriptorPoolCreateInfo*           pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkDescriptorPool*                           pDescriptorPool);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyDescriptorPool(
//VkDevice                                    device,
//VkDescriptorPool                            descriptorPool,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkResetDescriptorPool(
//VkDevice                                    device,
//VkDescriptorPool                            descriptorPool,
//VkDescriptorPoolResetFlags                  flags);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkAllocateDescriptorSets(
//VkDevice                                    device,
//const VkDescriptorSetAllocateInfo*          pAllocateInfo,
//VkDescriptorSet*                            pDescriptorSets);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkFreeDescriptorSets(
//VkDevice                                    device,
//VkDescriptorPool                            descriptorPool,
//uint32_t                                    descriptorSetCount,
//const VkDescriptorSet*                      pDescriptorSets);
//
//VKAPI_ATTR void VKAPI_CALL vkUpdateDescriptorSets(
//VkDevice                                    device,
//uint32_t                                    descriptorWriteCount,
//const VkWriteDescriptorSet*                 pDescriptorWrites,
//uint32_t                                    descriptorCopyCount,
//const VkCopyDescriptorSet*                  pDescriptorCopies);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateFramebuffer(
//VkDevice                                    device,
//const VkFramebufferCreateInfo*              pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkFramebuffer*                              pFramebuffer);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyFramebuffer(
//VkDevice                                    device,
//VkFramebuffer                               framebuffer,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateRenderPass(
//VkDevice                                    device,
//const VkRenderPassCreateInfo*               pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkRenderPass*                               pRenderPass);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyRenderPass(
//VkDevice                                    device,
//VkRenderPass                                renderPass,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR void VKAPI_CALL vkGetRenderAreaGranularity(
//VkDevice                                    device,
//VkRenderPass                                renderPass,
//VkExtent2D*                                 pGranularity);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateCommandPool(
//VkDevice                                    device,
//const VkCommandPoolCreateInfo*              pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkCommandPool*                              pCommandPool);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyCommandPool(
//VkDevice                                    device,
//VkCommandPool                               commandPool,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkResetCommandPool(
//VkDevice                                    device,
//VkCommandPool                               commandPool,
//VkCommandPoolResetFlags                     flags);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkAllocateCommandBuffers(
//VkDevice                                    device,
//const VkCommandBufferAllocateInfo*          pAllocateInfo,
//VkCommandBuffer*                            pCommandBuffers);
//
//VKAPI_ATTR void VKAPI_CALL vkFreeCommandBuffers(
//VkDevice                                    device,
//VkCommandPool                               commandPool,
//uint32_t                                    commandBufferCount,
//const VkCommandBuffer*                      pCommandBuffers);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkBeginCommandBuffer(
//VkCommandBuffer                             commandBuffer,
//const VkCommandBufferBeginInfo*             pBeginInfo);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkEndCommandBuffer(
//VkCommandBuffer                             commandBuffer);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkResetCommandBuffer(
//VkCommandBuffer                             commandBuffer,
//VkCommandBufferResetFlags                   flags);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdBindPipeline(
//VkCommandBuffer                             commandBuffer,
//VkPipelineBindPoint                         pipelineBindPoint,
//VkPipeline                                  pipeline);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdSetViewport(
//VkCommandBuffer                             commandBuffer,
//uint32_t                                    firstViewport,
//uint32_t                                    viewportCount,
//const VkViewport*                           pViewports);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdSetScissor(
//VkCommandBuffer                             commandBuffer,
//uint32_t                                    firstScissor,
//uint32_t                                    scissorCount,
//const VkRect2D*                             pScissors);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdSetLineWidth(
//VkCommandBuffer                             commandBuffer,
//float                                       lineWidth);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdSetDepthBias(
//VkCommandBuffer                             commandBuffer,
//float                                       depthBiasConstantFactor,
//float                                       depthBiasClamp,
//float                                       depthBiasSlopeFactor);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdSetBlendConstants(
//VkCommandBuffer                             commandBuffer,
//const float                                 blendConstants[4]);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdSetDepthBounds(
//VkCommandBuffer                             commandBuffer,
//float                                       minDepthBounds,
//float                                       maxDepthBounds);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdSetStencilCompareMask(
//VkCommandBuffer                             commandBuffer,
//VkStencilFaceFlags                          faceMask,
//uint32_t                                    compareMask);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdSetStencilWriteMask(
//VkCommandBuffer                             commandBuffer,
//VkStencilFaceFlags                          faceMask,
//uint32_t                                    writeMask);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdSetStencilReference(
//VkCommandBuffer                             commandBuffer,
//VkStencilFaceFlags                          faceMask,
//uint32_t                                    reference);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdBindDescriptorSets(
//VkCommandBuffer                             commandBuffer,
//VkPipelineBindPoint                         pipelineBindPoint,
//VkPipelineLayout                            layout,
//uint32_t                                    firstSet,
//uint32_t                                    descriptorSetCount,
//const VkDescriptorSet*                      pDescriptorSets,
//uint32_t                                    dynamicOffsetCount,
//const uint32_t*                             pDynamicOffsets);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdBindIndexBuffer(
//VkCommandBuffer                             commandBuffer,
//VkBuffer                                    buffer,
//VkDeviceSize                                offset,
//VkIndexType                                 indexType);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdBindVertexBuffers(
//VkCommandBuffer                             commandBuffer,
//uint32_t                                    firstBinding,
//uint32_t                                    bindingCount,
//const VkBuffer*                             pBuffers,
//const VkDeviceSize*                         pOffsets);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdDraw(
//VkCommandBuffer                             commandBuffer,
//uint32_t                                    vertexCount,
//uint32_t                                    instanceCount,
//uint32_t                                    firstVertex,
//uint32_t                                    firstInstance);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdDrawIndexed(
//VkCommandBuffer                             commandBuffer,
//uint32_t                                    indexCount,
//uint32_t                                    instanceCount,
//uint32_t                                    firstIndex,
//int32_t                                     vertexOffset,
//uint32_t                                    firstInstance);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdDrawIndirect(
//VkCommandBuffer                             commandBuffer,
//VkBuffer                                    buffer,
//VkDeviceSize                                offset,
//uint32_t                                    drawCount,
//uint32_t                                    stride);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdDrawIndexedIndirect(
//VkCommandBuffer                             commandBuffer,
//VkBuffer                                    buffer,
//VkDeviceSize                                offset,
//uint32_t                                    drawCount,
//uint32_t                                    stride);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdDispatch(
//VkCommandBuffer                             commandBuffer,
//uint32_t                                    groupCountX,
//uint32_t                                    groupCountY,
//uint32_t                                    groupCountZ);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdDispatchIndirect(
//VkCommandBuffer                             commandBuffer,
//VkBuffer                                    buffer,
//VkDeviceSize                                offset);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdCopyBuffer(
//VkCommandBuffer                             commandBuffer,
//VkBuffer                                    srcBuffer,
//VkBuffer                                    dstBuffer,
//uint32_t                                    regionCount,
//const VkBufferCopy*                         pRegions);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdCopyImage(
//VkCommandBuffer                             commandBuffer,
//VkImage                                     srcImage,
//VkImageLayout                               srcImageLayout,
//VkImage                                     dstImage,
//VkImageLayout                               dstImageLayout,
//uint32_t                                    regionCount,
//const VkImageCopy*                          pRegions);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdBlitImage(
//VkCommandBuffer                             commandBuffer,
//VkImage                                     srcImage,
//VkImageLayout                               srcImageLayout,
//VkImage                                     dstImage,
//VkImageLayout                               dstImageLayout,
//uint32_t                                    regionCount,
//const VkImageBlit*                          pRegions,
//VkFilter                                    filter);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdCopyBufferToImage(
//VkCommandBuffer                             commandBuffer,
//VkBuffer                                    srcBuffer,
//VkImage                                     dstImage,
//VkImageLayout                               dstImageLayout,
//uint32_t                                    regionCount,
//const VkBufferImageCopy*                    pRegions);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdCopyImageToBuffer(
//VkCommandBuffer                             commandBuffer,
//VkImage                                     srcImage,
//VkImageLayout                               srcImageLayout,
//VkBuffer                                    dstBuffer,
//uint32_t                                    regionCount,
//const VkBufferImageCopy*                    pRegions);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdUpdateBuffer(
//VkCommandBuffer                             commandBuffer,
//VkBuffer                                    dstBuffer,
//VkDeviceSize                                dstOffset,
//VkDeviceSize                                dataSize,
//const void*                                 pData);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdFillBuffer(
//VkCommandBuffer                             commandBuffer,
//VkBuffer                                    dstBuffer,
//VkDeviceSize                                dstOffset,
//VkDeviceSize                                size,
//uint32_t                                    data);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdClearColorImage(
//VkCommandBuffer                             commandBuffer,
//VkImage                                     image,
//VkImageLayout                               imageLayout,
//const VkClearColorValue*                    pColor,
//uint32_t                                    rangeCount,
//const VkImageSubresourceRange*              pRanges);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdClearDepthStencilImage(
//VkCommandBuffer                             commandBuffer,
//VkImage                                     image,
//VkImageLayout                               imageLayout,
//const VkClearDepthStencilValue*             pDepthStencil,
//uint32_t                                    rangeCount,
//const VkImageSubresourceRange*              pRanges);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdClearAttachments(
//VkCommandBuffer                             commandBuffer,
//uint32_t                                    attachmentCount,
//const VkClearAttachment*                    pAttachments,
//uint32_t                                    rectCount,
//const VkClearRect*                          pRects);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdResolveImage(
//VkCommandBuffer                             commandBuffer,
//VkImage                                     srcImage,
//VkImageLayout                               srcImageLayout,
//VkImage                                     dstImage,
//VkImageLayout                               dstImageLayout,
//uint32_t                                    regionCount,
//const VkImageResolve*                       pRegions);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdSetEvent(
//VkCommandBuffer                             commandBuffer,
//VkEvent                                     event,
//VkPipelineStageFlags                        stageMask);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdResetEvent(
//VkCommandBuffer                             commandBuffer,
//VkEvent                                     event,
//VkPipelineStageFlags                        stageMask);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdWaitEvents(
//VkCommandBuffer                             commandBuffer,
//uint32_t                                    eventCount,
//const VkEvent*                              pEvents,
//VkPipelineStageFlags                        srcStageMask,
//VkPipelineStageFlags                        dstStageMask,
//uint32_t                                    memoryBarrierCount,
//const VkMemoryBarrier*                      pMemoryBarriers,
//uint32_t                                    bufferMemoryBarrierCount,
//const VkBufferMemoryBarrier*                pBufferMemoryBarriers,
//uint32_t                                    imageMemoryBarrierCount,
//const VkImageMemoryBarrier*                 pImageMemoryBarriers);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdPipelineBarrier(
//VkCommandBuffer                             commandBuffer,
//VkPipelineStageFlags                        srcStageMask,
//VkPipelineStageFlags                        dstStageMask,
//VkDependencyFlags                           dependencyFlags,
//uint32_t                                    memoryBarrierCount,
//const VkMemoryBarrier*                      pMemoryBarriers,
//uint32_t                                    bufferMemoryBarrierCount,
//const VkBufferMemoryBarrier*                pBufferMemoryBarriers,
//uint32_t                                    imageMemoryBarrierCount,
//const VkImageMemoryBarrier*                 pImageMemoryBarriers);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdBeginQuery(
//VkCommandBuffer                             commandBuffer,
//VkQueryPool                                 queryPool,
//uint32_t                                    query,
//VkQueryControlFlags                         flags);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdEndQuery(
//VkCommandBuffer                             commandBuffer,
//VkQueryPool                                 queryPool,
//uint32_t                                    query);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdResetQueryPool(
//VkCommandBuffer                             commandBuffer,
//VkQueryPool                                 queryPool,
//uint32_t                                    firstQuery,
//uint32_t                                    queryCount);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdWriteTimestamp(
//VkCommandBuffer                             commandBuffer,
//VkPipelineStageFlagBits                     pipelineStage,
//VkQueryPool                                 queryPool,
//uint32_t                                    query);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdCopyQueryPoolResults(
//VkCommandBuffer                             commandBuffer,
//VkQueryPool                                 queryPool,
//uint32_t                                    firstQuery,
//uint32_t                                    queryCount,
//VkBuffer                                    dstBuffer,
//VkDeviceSize                                dstOffset,
//VkDeviceSize                                stride,
//VkQueryResultFlags                          flags);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdPushConstants(
//VkCommandBuffer                             commandBuffer,
//VkPipelineLayout                            layout,
//VkShaderStageFlags                          stageFlags,
//uint32_t                                    offset,
//uint32_t                                    size,
//const void*                                 pValues);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdBeginRenderPass(
//VkCommandBuffer                             commandBuffer,
//const VkRenderPassBeginInfo*                pRenderPassBegin,
//VkSubpassContents                           contents);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdNextSubpass(
//VkCommandBuffer                             commandBuffer,
//VkSubpassContents                           contents);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdEndRenderPass(
//VkCommandBuffer                             commandBuffer);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdExecuteCommands(
//VkCommandBuffer                             commandBuffer,
//uint32_t                                    commandBufferCount,
//const VkCommandBuffer*                      pCommandBuffers);
//#endif
//
//#define VK_KHR_surface 1
//VK_DEFINE_NON_DISPATCHABLE_HANDLE(VkSurfaceKHR)
//
//#define VK_KHR_SURFACE_SPEC_VERSION       25
//#define VK_KHR_SURFACE_EXTENSION_NAME     "VK_KHR_surface"
//#define VK_COLORSPACE_SRGB_NONLINEAR_KHR  VK_COLOR_SPACE_SRGB_NONLINEAR_KHR
//
//


inline val VkSurfaceCapabilitiesKHR.minImageCount get() = VkSurfaceCapabilitiesKHR.nminImageCount(adr)
inline val VkSurfaceCapabilitiesKHR.maxImageCount get() = VkSurfaceCapabilitiesKHR.nmaxImageCount(adr)
inline val VkSurfaceCapabilitiesKHR.currentExtent: VkExtent2D get() = VkSurfaceCapabilitiesKHR.ncurrentExtent(adr)
inline val VkSurfaceCapabilitiesKHR.minImageExtent: VkExtent2D get() = VkSurfaceCapabilitiesKHR.nminImageExtent(adr)
inline val VkSurfaceCapabilitiesKHR.maxImageExtent: VkExtent2D get() = VkSurfaceCapabilitiesKHR.nmaxImageExtent(adr)
inline val VkSurfaceCapabilitiesKHR.maxImageArrayLayers get() = VkSurfaceCapabilitiesKHR.nmaxImageArrayLayers(adr)
inline val VkSurfaceCapabilitiesKHR.supportedTransforms: VkSurfaceTransformFlagsKHR get() = VkSurfaceCapabilitiesKHR.nsupportedTransforms(adr)
inline val VkSurfaceCapabilitiesKHR.currentTransform: VkSurfaceTransform get() = VkSurfaceTransform of VkSurfaceCapabilitiesKHR.ncurrentTransform(adr)
inline val VkSurfaceCapabilitiesKHR.supportedCompositeAlpha: VkCompositeAlphaFlagsKHR get() = VkSurfaceCapabilitiesKHR.nsupportedCompositeAlpha(adr)
inline val VkSurfaceCapabilitiesKHR.supportedUsageFlags: VkImageUsageFlags get() = VkSurfaceCapabilitiesKHR.nsupportedUsageFlags(adr)

//typedef struct VkSurfaceCapabilitiesKHR {
//    uint32_t                         minImageCount;
//    uint32_t                         maxImageCount;
//    VkExtent2D                       currentExtent;
//    VkExtent2D                       minImageExtent;
//    VkExtent2D                       maxImageExtent;
//    uint32_t                         maxImageArrayLayers;
//    VkSurfaceTransformFlagsKHR       supportedTransforms;
//    VkSurfaceTransformFlagBitsKHR    currentTransform;
//    VkCompositeAlphaFlagsKHR         supportedCompositeAlpha;
//    VkImageUsageFlags                supportedUsageFlags;
//} VkSurfaceCapabilitiesKHR;

inline var VkSurfaceFormatKHR.format: VkFormat
    get() = VkFormat of VkSurfaceFormatKHR.nformat(adr)
    set(value) = memPutInt(adr + VkSurfaceFormatKHR.FORMAT, value.i)
inline var VkSurfaceFormatKHR.colorSpace: VkColorSpace
    get() = VkColorSpace of VkSurfaceFormatKHR.ncolorSpace(adr)
    set(value) = memPutInt(adr + VkSurfaceFormatKHR.COLORSPACE, value.i)

inline operator fun VkSurfaceFormatKHR.invoke(surfaceFormatKHR: VkSurfaceFormatKHR) {
    format = surfaceFormatKHR.format
    colorSpace = surfaceFormatKHR.colorSpace
}
//
//typedef void (VKAPI_PTR *PFN_vkDestroySurfaceKHR)(VkInstance instance, VkSurfaceKHR surface, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkGetPhysicalDeviceSurfaceSupportKHR)(VkPhysicalDevice physicalDevice, uint32_t queueFamilyIndex, VkSurfaceKHR surface, VkBool32* pSupported);
//typedef VkResult (VKAPI_PTR *PFN_vkGetPhysicalDeviceSurfaceCapabilitiesKHR)(VkPhysicalDevice physicalDevice, VkSurfaceKHR surface, VkSurfaceCapabilitiesKHR* pSurfaceCapabilities);
//typedef VkResult (VKAPI_PTR *PFN_vkGetPhysicalDeviceSurfaceFormatsKHR)(VkPhysicalDevice physicalDevice, VkSurfaceKHR surface, uint32_t* pSurfaceFormatCount, VkSurfaceFormatKHR* pSurfaceFormats);
//typedef VkResult (VKAPI_PTR *PFN_vkGetPhysicalDeviceSurfacePresentModesKHR)(VkPhysicalDevice physicalDevice, VkSurfaceKHR surface, uint32_t* pPresentModeCount, VkPresentModeKHR* pPresentModes);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR void VKAPI_CALL vkDestroySurfaceKHR(
//VkInstance                                  instance,
//VkSurfaceKHR                                surface,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetPhysicalDeviceSurfaceSupportKHR(
//VkPhysicalDevice                            physicalDevice,
//uint32_t                                    queueFamilyIndex,
//VkSurfaceKHR                                surface,
//VkBool32*                                   pSupported);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetPhysicalDeviceSurfaceCapabilitiesKHR(
//VkPhysicalDevice                            physicalDevice,
//VkSurfaceKHR                                surface,
//VkSurfaceCapabilitiesKHR*                   pSurfaceCapabilities);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetPhysicalDeviceSurfaceFormatsKHR(
//VkPhysicalDevice                            physicalDevice,
//VkSurfaceKHR                                surface,
//uint32_t*                                   pSurfaceFormatCount,
//VkSurfaceFormatKHR*                         pSurfaceFormats);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetPhysicalDeviceSurfacePresentModesKHR(
//VkPhysicalDevice                            physicalDevice,
//VkSurfaceKHR                                surface,
//uint32_t*                                   pPresentModeCount,
//VkPresentModeKHR*                           pPresentModes);
//#endif
//
//#define VK_KHR_swapchain 1
//VK_DEFINE_NON_DISPATCHABLE_HANDLE(VkSwapchainKHR)
//
//#define VK_KHR_SWAPCHAIN_SPEC_VERSION     68
//#define VK_KHR_SWAPCHAIN_EXTENSION_NAME   "VK_KHR_swapchain"


inline var VkSwapchainCreateInfoKHR.type: VkStructureType
    get() = VkStructureType of VkSwapchainCreateInfoKHR.nsType(adr)
    set(value) = VkSwapchainCreateInfoKHR.nsType(adr, value.i)
inline var VkSwapchainCreateInfoKHR.next: Long
    get() = VkSwapchainCreateInfoKHR.npNext(adr)
    set(value) = VkSwapchainCreateInfoKHR.npNext(adr, value)
inline var VkSwapchainCreateInfoKHR.flags: VkSwapchainCreateFlagsKHR
    get() = VkSwapchainCreateInfoKHR.nflags(adr)
    set(value) = VkSwapchainCreateInfoKHR.nflags(adr, value)
inline var VkSwapchainCreateInfoKHR.surface: VkSurfaceKHR
    get() = VkSwapchainCreateInfoKHR.nsurface(adr)
    set(value) = VkSwapchainCreateInfoKHR.nsurface(adr, value)
inline var VkSwapchainCreateInfoKHR.minImageCount
    get() = VkSwapchainCreateInfoKHR.nminImageCount(adr)
    set(value) = VkSwapchainCreateInfoKHR.nminImageCount(adr, value)
inline var VkSwapchainCreateInfoKHR.imageFormat: VkFormat
    get() = VkFormat of VkSwapchainCreateInfoKHR.nimageFormat(adr)
    set(value) = VkSwapchainCreateInfoKHR.nimageFormat(adr, value.i)
inline var VkSwapchainCreateInfoKHR.imageColorSpace: VkColorSpace
    get() = VkColorSpace of VkSwapchainCreateInfoKHR.nimageColorSpace(adr)
    set(value) = VkSwapchainCreateInfoKHR.nimageColorSpace(adr, value.i)
inline var VkSwapchainCreateInfoKHR.imageExtent: VkExtent2D
    get() = VkSwapchainCreateInfoKHR.nimageExtent(adr)
    set(value) = VkSwapchainCreateInfoKHR.nimageExtent(adr, value)

/** JVM custom */
inline fun VkSwapchainCreateInfoKHR.imageExtent(extent: Vec2i) {
    imageExtent.width = extent.x
    imageExtent.height = extent.y
}

inline var VkSwapchainCreateInfoKHR.imageArrayLayers
    get() = VkSwapchainCreateInfoKHR.nimageArrayLayers(adr)
    set(value) = VkSwapchainCreateInfoKHR.nimageArrayLayers(adr, value)
inline var VkSwapchainCreateInfoKHR.imageUsage: VkImageUsageFlags
    get() = VkSwapchainCreateInfoKHR.nimageUsage(adr)
    set(value) = VkSwapchainCreateInfoKHR.nimageUsage(adr, value)
inline var VkSwapchainCreateInfoKHR.imageSharingMode: VkSharingMode
    get() = VkSharingMode of VkSwapchainCreateInfoKHR.nimageSharingMode(adr)
    set(value) = VkSwapchainCreateInfoKHR.nimageSharingMode(adr, value.i)
inline val VkSwapchainCreateInfoKHR.queueFamilyIndexCount get() = VkSwapchainCreateInfoKHR.nqueueFamilyIndexCount(adr)
inline var VkSwapchainCreateInfoKHR.queueFamilyIndices
    get() = VkSwapchainCreateInfoKHR.npQueueFamilyIndices(adr)
    set(value) = VkSwapchainCreateInfoKHR.npQueueFamilyIndices(adr, value)
inline var VkSwapchainCreateInfoKHR.preTransform: VkSurfaceTransform
    get() = VkSurfaceTransform of VkSwapchainCreateInfoKHR.npreTransform(adr)
    set(value) = VkSwapchainCreateInfoKHR.npreTransform(adr, value.i)
inline var VkSwapchainCreateInfoKHR.compositeAlpha: VkCompositeAlpha
    get() = VkCompositeAlpha of VkSwapchainCreateInfoKHR.ncompositeAlpha(adr)
    set(value) = VkSwapchainCreateInfoKHR.ncompositeAlpha(adr, value.i)
inline var VkSwapchainCreateInfoKHR.presentMode: VkPresentMode
    get() = VkPresentMode of VkSwapchainCreateInfoKHR.npresentMode(adr)
    set(value) = VkSwapchainCreateInfoKHR.npresentMode(adr, value.i)
inline var VkSwapchainCreateInfoKHR.clipped
    get() = VkSwapchainCreateInfoKHR.nclipped(adr).bool
    set(value) = VkSwapchainCreateInfoKHR.nclipped(adr, value.i)
inline var VkSwapchainCreateInfoKHR.oldSwapchain: VkSwapchainKHR
    get() = VkSwapchainCreateInfoKHR.noldSwapchain(adr)
    set(value) = VkSwapchainCreateInfoKHR.noldSwapchain(adr, value)


typealias VkSwapchainCreateFlagsKHR = VkFlags

//typedef struct VkSwapchainCreateInfoKHR {
//    VkStructureType                  sType;
//    const void*                      pNext;
//    VkSwapchainCreateFlagsKHR        flags;
//    VkSurfaceKHR                     surface;
//    uint32_t                         minImageCount;
//    VkFormat                         imageFormat;
//    VkColorSpaceKHR                  imageColorSpace;
//    VkExtent2D                       imageExtent;
//    uint32_t                         imageArrayLayers;
//    VkImageUsageFlags                imageUsage;
//    VkSharingMode                    imageSharingMode;
//    uint32_t                         queueFamilyIndexCount;
//    const uint32_t*                  pQueueFamilyIndices;
//    VkSurfaceTransformFlagBitsKHR    preTransform;
//    VkCompositeAlphaFlagBitsKHR      compositeAlpha;
//    VkPresentModeKHR                 presentMode;
//    VkBool32                         clipped;
//    VkSwapchainKHR                   oldSwapchain;
//} VkSwapchainCreateInfoKHR;


inline var VkPresentInfoKHR.type: VkStructureType
    get() = VkStructureType of VkPresentInfoKHR.nsType(adr)
    set(value) = VkPresentInfoKHR.nsType(adr, value.i)
inline var VkPresentInfoKHR.next
    get() = VkPresentInfoKHR.npNext(adr)
    set(value) = VkPresentInfoKHR.npNext(adr, value)
//inline val VkPresentInfoKHR.waitSemaphoreCount get() = VkPresentInfoKHR.nwaitSemaphoreCount(adr)
inline var VkPresentInfoKHR.waitSemaphores: VkSemaphoreBuffer?
    get() = VkPresentInfoKHR.npWaitSemaphores(adr)
    set(value) = VkPresentInfoKHR.npWaitSemaphores(adr, value)
/** JVM custom */
inline var VkPresentInfoKHR.waitSemaphore: VkSemaphore?
    get() = VkPresentInfoKHR.npWaitSemaphores(adr)?.get(0)
    set(value) {
        if (value != null) {
            val pLong = appBuffer.long
            memPutLong(pLong, value)
            memPutAddress(adr + VkPresentInfoKHR.PWAITSEMAPHORES, pLong)
            VkPresentInfoKHR.nwaitSemaphoreCount(adr, 1)
        } else {
            memPutAddress(adr + VkPresentInfoKHR.PWAITSEMAPHORES, NULL)
            VkPresentInfoKHR.nwaitSemaphoreCount(adr, 0)
        }
    }
inline var VkPresentInfoKHR.swapchainCount: Int
    get() = VkPresentInfoKHR.nswapchainCount(adr)
    set(value) = VkPresentInfoKHR.nswapchainCount(adr, value)
inline var VkPresentInfoKHR.swapchains: VkSwapchainKhrBuffer
    get() = VkPresentInfoKHR.npSwapchains(adr)
    set(value) = VkPresentInfoKHR.npSwapchains(adr, value)
/** JVM custom */
inline var VkPresentInfoKHR.swapchain: VkSwapchainKHR
    get() = VkPresentInfoKHR.npSwapchains(adr)[0]
    set(value) {
        val pLong = appBuffer.long // TODO pLong of
        memPutLong(pLong, value)
        memPutAddress(adr + VkPresentInfoKHR.PSWAPCHAINS, pLong)
    }
inline var VkPresentInfoKHR.imageIndices: IntBuffer
    get() = VkPresentInfoKHR.npImageIndices(adr)
    set(value) = VkPresentInfoKHR.npImageIndices(adr, value)
/** JVM custom */
inline var VkPresentInfoKHR.imageIndex: Int
    get() = VkPresentInfoKHR.npImageIndices(adr)[0]
    set(value) {
        val pInt = appBuffer.int
        memPutInt(pInt, value)
        memPutAddress(adr + VkPresentInfoKHR.PIMAGEINDICES, pInt)
    }
inline var VkPresentInfoKHR.results: VkResultBuffer?
    get() = VkPresentInfoKHR.npResults(adr)
    set(value) = VkPresentInfoKHR.npResults(adr, value)

//typedef VkResult (VKAPI_PTR *PFN_vkCreateSwapchainKHR)(VkDevice device, const VkSwapchainCreateInfoKHR* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkSwapchainKHR* pSwapchain);
//typedef void (VKAPI_PTR *PFN_vkDestroySwapchainKHR)(VkDevice device, VkSwapchainKHR swapchain, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkGetSwapchainImagesKHR)(VkDevice device, VkSwapchainKHR swapchain, uint32_t* pSwapchainImageCount, VkImage* pSwapchainImages);
//typedef VkResult (VKAPI_PTR *PFN_vkAcquireNextImageKHR)(VkDevice device, VkSwapchainKHR swapchain, uint64_t timeout, VkSemaphore semaphore, VkFence fence, uint32_t* pImageIndex);
//typedef VkResult (VKAPI_PTR *PFN_vkQueuePresentKHR)(VkQueue queue, const VkPresentInfoKHR* pPresentInfo);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateSwapchainKHR(
//VkDevice                                    device,
//const VkSwapchainCreateInfoKHR*             pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkSwapchainKHR*                             pSwapchain);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroySwapchainKHR(
//VkDevice                                    device,
//VkSwapchainKHR                              swapchain,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetSwapchainImagesKHR(
//VkDevice                                    device,
//VkSwapchainKHR                              swapchain,
//uint32_t*                                   pSwapchainImageCount,
//VkImage*                                    pSwapchainImages);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkAcquireNextImageKHR(
//VkDevice                                    device,
//VkSwapchainKHR                              swapchain,
//uint64_t                                    timeout,
//VkSemaphore                                 semaphore,
//VkFence                                     fence,
//uint32_t*                                   pImageIndex);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkQueuePresentKHR(
//VkQueue                                     queue,
//const VkPresentInfoKHR*                     pPresentInfo);
//#endif
//
//#define VK_KHR_display 1
//VK_DEFINE_NON_DISPATCHABLE_HANDLE(VkDisplayKHR)
//VK_DEFINE_NON_DISPATCHABLE_HANDLE(VkDisplayModeKHR)
//
//#define VK_KHR_DISPLAY_SPEC_VERSION       21
//#define VK_KHR_DISPLAY_EXTENSION_NAME     "VK_KHR_display"
//
//
//typedef enum VkDisplayPlaneAlphaFlagBitsKHR {
//    VK_DISPLAY_PLANE_ALPHA_OPAQUE_BIT_KHR = 0x00000001,
//    VK_DISPLAY_PLANE_ALPHA_GLOBAL_BIT_KHR = 0x00000002,
//    VK_DISPLAY_PLANE_ALPHA_PER_PIXEL_BIT_KHR = 0x00000004,
//    VK_DISPLAY_PLANE_ALPHA_PER_PIXEL_PREMULTIPLIED_BIT_KHR = 0x00000008,
//    VK_DISPLAY_PLANE_ALPHA_FLAG_BITS_MAX_ENUM_KHR = 0x7FFFFFFF
//} VkDisplayPlaneAlphaFlagBitsKHR;
//typedef VkFlags VkDisplayPlaneAlphaFlagsKHR;
//typedef VkFlags VkDisplayModeCreateFlagsKHR;
//typedef VkFlags VkDisplaySurfaceCreateFlagsKHR;
//
//typedef struct VkDisplayPropertiesKHR {
//    VkDisplayKHR                  display;
//    const char*                   displayName;
//    VkExtent2D                    physicalDimensions;
//    VkExtent2D                    physicalResolution;
//    VkSurfaceTransformFlagsKHR    supportedTransforms;
//    VkBool32                      planeReorderPossible;
//    VkBool32                      persistentContent;
//} VkDisplayPropertiesKHR;
//
//typedef struct VkDisplayModeParametersKHR {
//    VkExtent2D    visibleRegion;
//    uint32_t      refreshRate;
//} VkDisplayModeParametersKHR;
//
//typedef struct VkDisplayModePropertiesKHR {
//    VkDisplayModeKHR              displayMode;
//    VkDisplayModeParametersKHR    parameters;
//} VkDisplayModePropertiesKHR;
//
//typedef struct VkDisplayModeCreateInfoKHR {
//    VkStructureType                sType;
//    const void*                    pNext;
//    VkDisplayModeCreateFlagsKHR    flags;
//    VkDisplayModeParametersKHR     parameters;
//} VkDisplayModeCreateInfoKHR;
//
//typedef struct VkDisplayPlaneCapabilitiesKHR {
//    VkDisplayPlaneAlphaFlagsKHR    supportedAlpha;
//    VkOffset2D                     minSrcPosition;
//    VkOffset2D                     maxSrcPosition;
//    VkExtent2D                     minSrcExtent;
//    VkExtent2D                     maxSrcExtent;
//    VkOffset2D                     minDstPosition;
//    VkOffset2D                     maxDstPosition;
//    VkExtent2D                     minDstExtent;
//    VkExtent2D                     maxDstExtent;
//} VkDisplayPlaneCapabilitiesKHR;
//
//typedef struct VkDisplayPlanePropertiesKHR {
//    VkDisplayKHR    currentDisplay;
//    uint32_t        currentStackIndex;
//} VkDisplayPlanePropertiesKHR;
//
//typedef struct VkDisplaySurfaceCreateInfoKHR {
//    VkStructureType                   sType;
//    const void*                       pNext;
//    VkDisplaySurfaceCreateFlagsKHR    flags;
//    VkDisplayModeKHR                  displayMode;
//    uint32_t                          planeIndex;
//    uint32_t                          planeStackIndex;
//    VkSurfaceTransformFlagBitsKHR     transform;
//    float                             globalAlpha;
//    VkDisplayPlaneAlphaFlagBitsKHR    alphaMode;
//    VkExtent2D                        imageExtent;
//} VkDisplaySurfaceCreateInfoKHR;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkGetPhysicalDeviceDisplayPropertiesKHR)(VkPhysicalDevice physicalDevice, uint32_t* pPropertyCount, VkDisplayPropertiesKHR* pProperties);
//typedef VkResult (VKAPI_PTR *PFN_vkGetPhysicalDeviceDisplayPlanePropertiesKHR)(VkPhysicalDevice physicalDevice, uint32_t* pPropertyCount, VkDisplayPlanePropertiesKHR* pProperties);
//typedef VkResult (VKAPI_PTR *PFN_vkGetDisplayPlaneSupportedDisplaysKHR)(VkPhysicalDevice physicalDevice, uint32_t planeIndex, uint32_t* pDisplayCount, VkDisplayKHR* pDisplays);
//typedef VkResult (VKAPI_PTR *PFN_vkGetDisplayModePropertiesKHR)(VkPhysicalDevice physicalDevice, VkDisplayKHR display, uint32_t* pPropertyCount, VkDisplayModePropertiesKHR* pProperties);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateDisplayModeKHR)(VkPhysicalDevice physicalDevice, VkDisplayKHR display, const VkDisplayModeCreateInfoKHR* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkDisplayModeKHR* pMode);
//typedef VkResult (VKAPI_PTR *PFN_vkGetDisplayPlaneCapabilitiesKHR)(VkPhysicalDevice physicalDevice, VkDisplayModeKHR mode, uint32_t planeIndex, VkDisplayPlaneCapabilitiesKHR* pCapabilities);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateDisplayPlaneSurfaceKHR)(VkInstance instance, const VkDisplaySurfaceCreateInfoKHR* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkSurfaceKHR* pSurface);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkGetPhysicalDeviceDisplayPropertiesKHR(
//VkPhysicalDevice                            physicalDevice,
//uint32_t*                                   pPropertyCount,
//VkDisplayPropertiesKHR*                     pProperties);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetPhysicalDeviceDisplayPlanePropertiesKHR(
//VkPhysicalDevice                            physicalDevice,
//uint32_t*                                   pPropertyCount,
//VkDisplayPlanePropertiesKHR*                pProperties);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetDisplayPlaneSupportedDisplaysKHR(
//VkPhysicalDevice                            physicalDevice,
//uint32_t                                    planeIndex,
//uint32_t*                                   pDisplayCount,
//VkDisplayKHR*                               pDisplays);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetDisplayModePropertiesKHR(
//VkPhysicalDevice                            physicalDevice,
//VkDisplayKHR                                display,
//uint32_t*                                   pPropertyCount,
//VkDisplayModePropertiesKHR*                 pProperties);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateDisplayModeKHR(
//VkPhysicalDevice                            physicalDevice,
//VkDisplayKHR                                display,
//const VkDisplayModeCreateInfoKHR*           pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkDisplayModeKHR*                           pMode);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetDisplayPlaneCapabilitiesKHR(
//VkPhysicalDevice                            physicalDevice,
//VkDisplayModeKHR                            mode,
//uint32_t                                    planeIndex,
//VkDisplayPlaneCapabilitiesKHR*              pCapabilities);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateDisplayPlaneSurfaceKHR(
//VkInstance                                  instance,
//const VkDisplaySurfaceCreateInfoKHR*        pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkSurfaceKHR*                               pSurface);
//#endif
//
//#define VK_KHR_display_swapchain 1
//#define VK_KHR_DISPLAY_SWAPCHAIN_SPEC_VERSION 9
//#define VK_KHR_DISPLAY_SWAPCHAIN_EXTENSION_NAME "VK_KHR_display_swapchain"
//
//typedef struct VkDisplayPresentInfoKHR {
//    VkStructureType    sType;
//    const void*        pNext;
//    VkRect2D           srcRect;
//    VkRect2D           dstRect;
//    VkBool32           persistent;
//} VkDisplayPresentInfoKHR;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkCreateSharedSwapchainsKHR)(VkDevice device, uint32_t swapchainCount, const VkSwapchainCreateInfoKHR* pCreateInfos, const VkAllocationCallbacks* pAllocator, VkSwapchainKHR* pSwapchains);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateSharedSwapchainsKHR(
//VkDevice                                    device,
//uint32_t                                    swapchainCount,
//const VkSwapchainCreateInfoKHR*             pCreateInfos,
//const VkAllocationCallbacks*                pAllocator,
//VkSwapchainKHR*                             pSwapchains);
//#endif
//
//#ifdef VK_USE_PLATFORM_XLIB_KHR
//#define VK_KHR_xlib_surface 1
//#include <X11/Xlib.h>
//
//#define VK_KHR_XLIB_SURFACE_SPEC_VERSION  6
//#define VK_KHR_XLIB_SURFACE_EXTENSION_NAME "VK_KHR_xlib_surface"
//
//typedef VkFlags VkXlibSurfaceCreateFlagsKHR;
//
//typedef struct VkXlibSurfaceCreateInfoKHR {
//    VkStructureType                sType;
//    const void*                    pNext;
//    VkXlibSurfaceCreateFlagsKHR    flags;
//    Display*                       dpy;
//    Window                         window;
//} VkXlibSurfaceCreateInfoKHR;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkCreateXlibSurfaceKHR)(VkInstance instance, const VkXlibSurfaceCreateInfoKHR* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkSurfaceKHR* pSurface);
//typedef VkBool32 (VKAPI_PTR *PFN_vkGetPhysicalDeviceXlibPresentationSupportKHR)(VkPhysicalDevice physicalDevice, uint32_t queueFamilyIndex, Display* dpy, VisualID visualID);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateXlibSurfaceKHR(
//VkInstance                                  instance,
//const VkXlibSurfaceCreateInfoKHR*           pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkSurfaceKHR*                               pSurface);
//
//VKAPI_ATTR VkBool32 VKAPI_CALL vkGetPhysicalDeviceXlibPresentationSupportKHR(
//VkPhysicalDevice                            physicalDevice,
//uint32_t                                    queueFamilyIndex,
//Display*                                    dpy,
//VisualID                                    visualID);
//#endif
//#endif /* VK_USE_PLATFORM_XLIB_KHR */
//
//#ifdef VK_USE_PLATFORM_XCB_KHR
//#define VK_KHR_xcb_surface 1
//#include <xcb/xcb.h>
//
//#define VK_KHR_XCB_SURFACE_SPEC_VERSION   6
//#define VK_KHR_XCB_SURFACE_EXTENSION_NAME "VK_KHR_xcb_surface"
//
//typedef VkFlags VkXcbSurfaceCreateFlagsKHR;
//
//typedef struct VkXcbSurfaceCreateInfoKHR {
//    VkStructureType               sType;
//    const void*                   pNext;
//    VkXcbSurfaceCreateFlagsKHR    flags;
//    xcb_connection_t*             connection;
//    xcb_window_t                  window;
//} VkXcbSurfaceCreateInfoKHR;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkCreateXcbSurfaceKHR)(VkInstance instance, const VkXcbSurfaceCreateInfoKHR* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkSurfaceKHR* pSurface);
//typedef VkBool32 (VKAPI_PTR *PFN_vkGetPhysicalDeviceXcbPresentationSupportKHR)(VkPhysicalDevice physicalDevice, uint32_t queueFamilyIndex, xcb_connection_t* connection, xcb_visualid_t visual_id);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateXcbSurfaceKHR(
//VkInstance                                  instance,
//const VkXcbSurfaceCreateInfoKHR*            pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkSurfaceKHR*                               pSurface);
//
//VKAPI_ATTR VkBool32 VKAPI_CALL vkGetPhysicalDeviceXcbPresentationSupportKHR(
//VkPhysicalDevice                            physicalDevice,
//uint32_t                                    queueFamilyIndex,
//xcb_connection_t*                           connection,
//xcb_visualid_t                              visual_id);
//#endif
//#endif /* VK_USE_PLATFORM_XCB_KHR */
//
//#ifdef VK_USE_PLATFORM_WAYLAND_KHR
//#define VK_KHR_wayland_surface 1
//#include <wayland-client.h>
//
//#define VK_KHR_WAYLAND_SURFACE_SPEC_VERSION 6
//#define VK_KHR_WAYLAND_SURFACE_EXTENSION_NAME "VK_KHR_wayland_surface"
//
//typedef VkFlags VkWaylandSurfaceCreateFlagsKHR;
//
//typedef struct VkWaylandSurfaceCreateInfoKHR {
//    VkStructureType                   sType;
//    const void*                       pNext;
//    VkWaylandSurfaceCreateFlagsKHR    flags;
//    struct wl_display*                display;
//    struct wl_surface*                surface;
//} VkWaylandSurfaceCreateInfoKHR;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkCreateWaylandSurfaceKHR)(VkInstance instance, const VkWaylandSurfaceCreateInfoKHR* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkSurfaceKHR* pSurface);
//typedef VkBool32 (VKAPI_PTR *PFN_vkGetPhysicalDeviceWaylandPresentationSupportKHR)(VkPhysicalDevice physicalDevice, uint32_t queueFamilyIndex, struct wl_display* display);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateWaylandSurfaceKHR(
//VkInstance                                  instance,
//const VkWaylandSurfaceCreateInfoKHR*        pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkSurfaceKHR*                               pSurface);
//
//VKAPI_ATTR VkBool32 VKAPI_CALL vkGetPhysicalDeviceWaylandPresentationSupportKHR(
//VkPhysicalDevice                            physicalDevice,
//uint32_t                                    queueFamilyIndex,
//struct wl_display*                          display);
//#endif
//#endif /* VK_USE_PLATFORM_WAYLAND_KHR */
//
//#ifdef VK_USE_PLATFORM_MIR_KHR
//#define VK_KHR_mir_surface 1
//#include <mir_toolkit/client_types.h>
//
//#define VK_KHR_MIR_SURFACE_SPEC_VERSION   4
//#define VK_KHR_MIR_SURFACE_EXTENSION_NAME "VK_KHR_mir_surface"
//
//typedef VkFlags VkMirSurfaceCreateFlagsKHR;
//
//typedef struct VkMirSurfaceCreateInfoKHR {
//    VkStructureType               sType;
//    const void*                   pNext;
//    VkMirSurfaceCreateFlagsKHR    flags;
//    MirConnection*                connection;
//    MirSurface*                   mirSurface;
//} VkMirSurfaceCreateInfoKHR;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkCreateMirSurfaceKHR)(VkInstance instance, const VkMirSurfaceCreateInfoKHR* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkSurfaceKHR* pSurface);
//typedef VkBool32 (VKAPI_PTR *PFN_vkGetPhysicalDeviceMirPresentationSupportKHR)(VkPhysicalDevice physicalDevice, uint32_t queueFamilyIndex, MirConnection* connection);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateMirSurfaceKHR(
//VkInstance                                  instance,
//const VkMirSurfaceCreateInfoKHR*            pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkSurfaceKHR*                               pSurface);
//
//VKAPI_ATTR VkBool32 VKAPI_CALL vkGetPhysicalDeviceMirPresentationSupportKHR(
//VkPhysicalDevice                            physicalDevice,
//uint32_t                                    queueFamilyIndex,
//MirConnection*                              connection);
//#endif
//#endif /* VK_USE_PLATFORM_MIR_KHR */
//
//#ifdef VK_USE_PLATFORM_ANDROID_KHR
//#define VK_KHR_android_surface 1
//#include <android/native_window.h>
//
//#define VK_KHR_ANDROID_SURFACE_SPEC_VERSION 6
//#define VK_KHR_ANDROID_SURFACE_EXTENSION_NAME "VK_KHR_android_surface"
//
//typedef VkFlags VkAndroidSurfaceCreateFlagsKHR;
//
//typedef struct VkAndroidSurfaceCreateInfoKHR {
//    VkStructureType                   sType;
//    const void*                       pNext;
//    VkAndroidSurfaceCreateFlagsKHR    flags;
//    ANativeWindow*                    window;
//} VkAndroidSurfaceCreateInfoKHR;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkCreateAndroidSurfaceKHR)(VkInstance instance, const VkAndroidSurfaceCreateInfoKHR* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkSurfaceKHR* pSurface);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateAndroidSurfaceKHR(
//VkInstance                                  instance,
//const VkAndroidSurfaceCreateInfoKHR*        pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkSurfaceKHR*                               pSurface);
//#endif
//#endif /* VK_USE_PLATFORM_ANDROID_KHR */
//
//#ifdef VK_USE_PLATFORM_WIN32_KHR
//#define VK_KHR_win32_surface 1
//#include <windows.h>
//
//#define VK_KHR_WIN32_SURFACE_SPEC_VERSION 6
//#define VK_KHR_WIN32_SURFACE_EXTENSION_NAME "VK_KHR_win32_surface"
//
//typedef VkFlags VkWin32SurfaceCreateFlagsKHR;
//
//typedef struct VkWin32SurfaceCreateInfoKHR {
//    VkStructureType                 sType;
//    const void*                     pNext;
//    VkWin32SurfaceCreateFlagsKHR    flags;
//    HINSTANCE                       hinstance;
//    HWND                            hwnd;
//} VkWin32SurfaceCreateInfoKHR;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkCreateWin32SurfaceKHR)(VkInstance instance, const VkWin32SurfaceCreateInfoKHR* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkSurfaceKHR* pSurface);
//typedef VkBool32 (VKAPI_PTR *PFN_vkGetPhysicalDeviceWin32PresentationSupportKHR)(VkPhysicalDevice physicalDevice, uint32_t queueFamilyIndex);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateWin32SurfaceKHR(
//VkInstance                                  instance,
//const VkWin32SurfaceCreateInfoKHR*          pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkSurfaceKHR*                               pSurface);
//
//VKAPI_ATTR VkBool32 VKAPI_CALL vkGetPhysicalDeviceWin32PresentationSupportKHR(
//VkPhysicalDevice                            physicalDevice,
//uint32_t                                    queueFamilyIndex);
//#endif
//#endif /* VK_USE_PLATFORM_WIN32_KHR */
//
//#define VK_KHR_sampler_mirror_clamp_to_edge 1
//#define VK_KHR_SAMPLER_MIRROR_CLAMP_TO_EDGE_SPEC_VERSION 1
//#define VK_KHR_SAMPLER_MIRROR_CLAMP_TO_EDGE_EXTENSION_NAME "VK_KHR_sampler_mirror_clamp_to_edge"
//
//
//#define VK_KHR_get_physical_device_properties2 1
//#define VK_KHR_GET_PHYSICAL_DEVICE_PROPERTIES_2_SPEC_VERSION 1
//#define VK_KHR_GET_PHYSICAL_DEVICE_PROPERTIES_2_EXTENSION_NAME "VK_KHR_get_physical_device_properties2"
//
//typedef struct VkPhysicalDeviceFeatures2KHR {
//    VkStructureType             sType;
//    void*                       pNext;
//    VkPhysicalDeviceFeatures    features;
//} VkPhysicalDeviceFeatures2KHR;
//
//typedef struct VkPhysicalDeviceProperties2KHR {
//    VkStructureType               sType;
//    void*                         pNext;
//    VkPhysicalDeviceProperties    properties;
//} VkPhysicalDeviceProperties2KHR;
//
//typedef struct VkFormatProperties2KHR {
//    VkStructureType       sType;
//    void*                 pNext;
//    VkFormatProperties    formatProperties;
//} VkFormatProperties2KHR;
//
//typedef struct VkImageFormatProperties2KHR {
//    VkStructureType            sType;
//    void*                      pNext;
//    VkImageFormatProperties    imageFormatProperties;
//} VkImageFormatProperties2KHR;
//
//typedef struct VkPhysicalDeviceImageFormatInfo2KHR {
//    VkStructureType       sType;
//    const void*           pNext;
//    VkFormat              format;
//    VkImageType           type;
//    VkImageTiling         tiling;
//    VkImageUsageFlags     usage;
//    VkImageCreateFlags    flags;
//} VkPhysicalDeviceImageFormatInfo2KHR;
//
//typedef struct VkQueueFamilyProperties2KHR {
//    VkStructureType            sType;
//    void*                      pNext;
//    VkQueueFamilyProperties    queueFamilyProperties;
//} VkQueueFamilyProperties2KHR;
//
//typedef struct VkPhysicalDeviceMemoryProperties2KHR {
//    VkStructureType                     sType;
//    void*                               pNext;
//    VkPhysicalDeviceMemoryProperties    memoryProperties;
//} VkPhysicalDeviceMemoryProperties2KHR;
//
//typedef struct VkSparseImageFormatProperties2KHR {
//    VkStructureType                  sType;
//    void*                            pNext;
//    VkSparseImageFormatProperties    properties;
//} VkSparseImageFormatProperties2KHR;
//
//typedef struct VkPhysicalDeviceSparseImageFormatInfo2KHR {
//    VkStructureType          sType;
//    const void*              pNext;
//    VkFormat                 format;
//    VkImageType              type;
//    VkSampleCountFlagBits    samples;
//    VkImageUsageFlags        usage;
//    VkImageTiling            tiling;
//} VkPhysicalDeviceSparseImageFormatInfo2KHR;
//
//
//typedef void (VKAPI_PTR *PFN_vkGetPhysicalDeviceFeatures2KHR)(VkPhysicalDevice physicalDevice, VkPhysicalDeviceFeatures2KHR* pFeatures);
//typedef void (VKAPI_PTR *PFN_vkGetPhysicalDeviceProperties2KHR)(VkPhysicalDevice physicalDevice, VkPhysicalDeviceProperties2KHR* pProperties);
//typedef void (VKAPI_PTR *PFN_vkGetPhysicalDeviceFormatProperties2KHR)(VkPhysicalDevice physicalDevice, VkFormat format, VkFormatProperties2KHR* pFormatProperties);
//typedef VkResult (VKAPI_PTR *PFN_vkGetPhysicalDeviceImageFormatProperties2KHR)(VkPhysicalDevice physicalDevice, const VkPhysicalDeviceImageFormatInfo2KHR* pImageFormatInfo, VkImageFormatProperties2KHR* pImageFormatProperties);
//typedef void (VKAPI_PTR *PFN_vkGetPhysicalDeviceQueueFamilyProperties2KHR)(VkPhysicalDevice physicalDevice, uint32_t* pQueueFamilyPropertyCount, VkQueueFamilyProperties2KHR* pQueueFamilyProperties);
//typedef void (VKAPI_PTR *PFN_vkGetPhysicalDeviceMemoryProperties2KHR)(VkPhysicalDevice physicalDevice, VkPhysicalDeviceMemoryProperties2KHR* pMemoryProperties);
//typedef void (VKAPI_PTR *PFN_vkGetPhysicalDeviceSparseImageFormatProperties2KHR)(VkPhysicalDevice physicalDevice, const VkPhysicalDeviceSparseImageFormatInfo2KHR* pFormatInfo, uint32_t* pPropertyCount, VkSparseImageFormatProperties2KHR* pProperties);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR void VKAPI_CALL vkGetPhysicalDeviceFeatures2KHR(
//VkPhysicalDevice                            physicalDevice,
//VkPhysicalDeviceFeatures2KHR*               pFeatures);
//
//VKAPI_ATTR void VKAPI_CALL vkGetPhysicalDeviceProperties2KHR(
//VkPhysicalDevice                            physicalDevice,
//VkPhysicalDeviceProperties2KHR*             pProperties);
//
//VKAPI_ATTR void VKAPI_CALL vkGetPhysicalDeviceFormatProperties2KHR(
//VkPhysicalDevice                            physicalDevice,
//VkFormat                                    format,
//VkFormatProperties2KHR*                     pFormatProperties);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetPhysicalDeviceImageFormatProperties2KHR(
//VkPhysicalDevice                            physicalDevice,
//const VkPhysicalDeviceImageFormatInfo2KHR*  pImageFormatInfo,
//VkImageFormatProperties2KHR*                pImageFormatProperties);
//
//VKAPI_ATTR void VKAPI_CALL vkGetPhysicalDeviceQueueFamilyProperties2KHR(
//VkPhysicalDevice                            physicalDevice,
//uint32_t*                                   pQueueFamilyPropertyCount,
//VkQueueFamilyProperties2KHR*                pQueueFamilyProperties);
//
//VKAPI_ATTR void VKAPI_CALL vkGetPhysicalDeviceMemoryProperties2KHR(
//VkPhysicalDevice                            physicalDevice,
//VkPhysicalDeviceMemoryProperties2KHR*       pMemoryProperties);
//
//VKAPI_ATTR void VKAPI_CALL vkGetPhysicalDeviceSparseImageFormatProperties2KHR(
//VkPhysicalDevice                            physicalDevice,
//const VkPhysicalDeviceSparseImageFormatInfo2KHR* pFormatInfo,
//uint32_t*                                   pPropertyCount,
//VkSparseImageFormatProperties2KHR*          pProperties);
//#endif
//
//#define VK_KHR_shader_draw_parameters 1
//#define VK_KHR_SHADER_DRAW_PARAMETERS_SPEC_VERSION 1
//#define VK_KHR_SHADER_DRAW_PARAMETERS_EXTENSION_NAME "VK_KHR_shader_draw_parameters"
//
//
//#define VK_KHR_maintenance1 1
//#define VK_KHR_MAINTENANCE1_SPEC_VERSION  1
//#define VK_KHR_MAINTENANCE1_EXTENSION_NAME "VK_KHR_maintenance1"
//
//typedef VkFlags VkCommandPoolTrimFlagsKHR;
//
//typedef void (VKAPI_PTR *PFN_vkTrimCommandPoolKHR)(VkDevice device, VkCommandPool commandPool, VkCommandPoolTrimFlagsKHR flags);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR void VKAPI_CALL vkTrimCommandPoolKHR(
//VkDevice                                    device,
//VkCommandPool                               commandPool,
//VkCommandPoolTrimFlagsKHR                   flags);
//#endif
//
//#define VK_KHR_external_memory_capabilities 1
//#define VK_LUID_SIZE_KHR                  8
//#define VK_KHR_EXTERNAL_MEMORY_CAPABILITIES_SPEC_VERSION 1
//#define VK_KHR_EXTERNAL_MEMORY_CAPABILITIES_EXTENSION_NAME "VK_KHR_external_memory_capabilities"
//
//
//typedef enum VkExternalMemoryHandleTypeFlagBitsKHR {
//    VK_EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_FD_BIT_KHR = 0x00000001,
//    VK_EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_WIN32_BIT_KHR = 0x00000002,
//    VK_EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_WIN32_KMT_BIT_KHR = 0x00000004,
//    VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D11_TEXTURE_BIT_KHR = 0x00000008,
//    VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D11_TEXTURE_KMT_BIT_KHR = 0x00000010,
//    VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D12_HEAP_BIT_KHR = 0x00000020,
//    VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D12_RESOURCE_BIT_KHR = 0x00000040,
//    VK_EXTERNAL_MEMORY_HANDLE_TYPE_DMA_BUF_BIT_EXT = 0x00000200,
//    VK_EXTERNAL_MEMORY_HANDLE_TYPE_HOST_ALLOCATION_BIT_EXT = 0x00000080,
//    VK_EXTERNAL_MEMORY_HANDLE_TYPE_HOST_MAPPED_FOREIGN_MEMORY_BIT_EXT = 0x00000100,
//    VK_EXTERNAL_MEMORY_HANDLE_TYPE_FLAG_BITS_MAX_ENUM_KHR = 0x7FFFFFFF
//} VkExternalMemoryHandleTypeFlagBitsKHR;
//typedef VkFlags VkExternalMemoryHandleTypeFlagsKHR;
//
//typedef enum VkExternalMemoryFeatureFlagBitsKHR {
//    VK_EXTERNAL_MEMORY_FEATURE_DEDICATED_ONLY_BIT_KHR = 0x00000001,
//    VK_EXTERNAL_MEMORY_FEATURE_EXPORTABLE_BIT_KHR = 0x00000002,
//    VK_EXTERNAL_MEMORY_FEATURE_IMPORTABLE_BIT_KHR = 0x00000004,
//    VK_EXTERNAL_MEMORY_FEATURE_FLAG_BITS_MAX_ENUM_KHR = 0x7FFFFFFF
//} VkExternalMemoryFeatureFlagBitsKHR;
//typedef VkFlags VkExternalMemoryFeatureFlagsKHR;
//
//typedef struct VkExternalMemoryPropertiesKHR {
//    VkExternalMemoryFeatureFlagsKHR       externalMemoryFeatures;
//    VkExternalMemoryHandleTypeFlagsKHR    exportFromImportedHandleTypes;
//    VkExternalMemoryHandleTypeFlagsKHR    compatibleHandleTypes;
//} VkExternalMemoryPropertiesKHR;
//
//typedef struct VkPhysicalDeviceExternalImageFormatInfoKHR {
//    VkStructureType                          sType;
//    const void*                              pNext;
//    VkExternalMemoryHandleTypeFlagBitsKHR    handleType;
//} VkPhysicalDeviceExternalImageFormatInfoKHR;
//
//typedef struct VkExternalImageFormatPropertiesKHR {
//    VkStructureType                  sType;
//    void*                            pNext;
//    VkExternalMemoryPropertiesKHR    externalMemoryProperties;
//} VkExternalImageFormatPropertiesKHR;
//
//typedef struct VkPhysicalDeviceExternalBufferInfoKHR {
//    VkStructureType                          sType;
//    const void*                              pNext;
//    VkBufferCreateFlags                      flags;
//    VkBufferUsageFlags                       usage;
//    VkExternalMemoryHandleTypeFlagBitsKHR    handleType;
//} VkPhysicalDeviceExternalBufferInfoKHR;
//
//typedef struct VkExternalBufferPropertiesKHR {
//    VkStructureType                  sType;
//    void*                            pNext;
//    VkExternalMemoryPropertiesKHR    externalMemoryProperties;
//} VkExternalBufferPropertiesKHR;
//
//typedef struct VkPhysicalDeviceIDPropertiesKHR {
//    VkStructureType    sType;
//    void*              pNext;
//    uint8_t            deviceUUID[VK_UUID_SIZE];
//    uint8_t            driverUUID[VK_UUID_SIZE];
//    uint8_t            deviceLUID[VK_LUID_SIZE_KHR];
//    uint32_t           deviceNodeMask;
//    VkBool32           deviceLUIDValid;
//} VkPhysicalDeviceIDPropertiesKHR;
//
//
//typedef void (VKAPI_PTR *PFN_vkGetPhysicalDeviceExternalBufferPropertiesKHR)(VkPhysicalDevice physicalDevice, const VkPhysicalDeviceExternalBufferInfoKHR* pExternalBufferInfo, VkExternalBufferPropertiesKHR* pExternalBufferProperties);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR void VKAPI_CALL vkGetPhysicalDeviceExternalBufferPropertiesKHR(
//VkPhysicalDevice                            physicalDevice,
//const VkPhysicalDeviceExternalBufferInfoKHR* pExternalBufferInfo,
//VkExternalBufferPropertiesKHR*              pExternalBufferProperties);
//#endif
//
//#define VK_KHR_external_memory 1
//#define VK_KHR_EXTERNAL_MEMORY_SPEC_VERSION 1
//#define VK_KHR_EXTERNAL_MEMORY_EXTENSION_NAME "VK_KHR_external_memory"
//#define VK_QUEUE_FAMILY_EXTERNAL_KHR      (~0U-1)
//
//typedef struct VkExternalMemoryImageCreateInfoKHR {
//    VkStructureType                       sType;
//    const void*                           pNext;
//    VkExternalMemoryHandleTypeFlagsKHR    handleTypes;
//} VkExternalMemoryImageCreateInfoKHR;
//
//typedef struct VkExternalMemoryBufferCreateInfoKHR {
//    VkStructureType                       sType;
//    const void*                           pNext;
//    VkExternalMemoryHandleTypeFlagsKHR    handleTypes;
//} VkExternalMemoryBufferCreateInfoKHR;
//
//typedef struct VkExportMemoryAllocateInfoKHR {
//    VkStructureType                       sType;
//    const void*                           pNext;
//    VkExternalMemoryHandleTypeFlagsKHR    handleTypes;
//} VkExportMemoryAllocateInfoKHR;
//
//
//
//#ifdef VK_USE_PLATFORM_WIN32_KHR
//#define VK_KHR_external_memory_win32 1
//#define VK_KHR_EXTERNAL_MEMORY_WIN32_SPEC_VERSION 1
//#define VK_KHR_EXTERNAL_MEMORY_WIN32_EXTENSION_NAME "VK_KHR_external_memory_win32"
//
//typedef struct VkImportMemoryWin32HandleInfoKHR {
//    VkStructureType                          sType;
//    const void*                              pNext;
//    VkExternalMemoryHandleTypeFlagBitsKHR    handleType;
//    HANDLE                                   handle;
//    LPCWSTR                                  name;
//} VkImportMemoryWin32HandleInfoKHR;
//
//typedef struct VkExportMemoryWin32HandleInfoKHR {
//    VkStructureType               sType;
//    const void*                   pNext;
//    const SECURITY_ATTRIBUTES*    pAttributes;
//    DWORD                         dwAccess;
//    LPCWSTR                       name;
//} VkExportMemoryWin32HandleInfoKHR;
//
//typedef struct VkMemoryWin32HandlePropertiesKHR {
//    VkStructureType    sType;
//    void*              pNext;
//    uint32_t           memoryTypeBits;
//} VkMemoryWin32HandlePropertiesKHR;
//
//typedef struct VkMemoryGetWin32HandleInfoKHR {
//    VkStructureType                          sType;
//    const void*                              pNext;
//    VkDeviceMemory                           memory;
//    VkExternalMemoryHandleTypeFlagBitsKHR    handleType;
//} VkMemoryGetWin32HandleInfoKHR;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkGetMemoryWin32HandleKHR)(VkDevice device, const VkMemoryGetWin32HandleInfoKHR* pGetWin32HandleInfo, HANDLE* pHandle);
//typedef VkResult (VKAPI_PTR *PFN_vkGetMemoryWin32HandlePropertiesKHR)(VkDevice device, VkExternalMemoryHandleTypeFlagBitsKHR handleType, HANDLE handle, VkMemoryWin32HandlePropertiesKHR* pMemoryWin32HandleProperties);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkGetMemoryWin32HandleKHR(
//VkDevice                                    device,
//const VkMemoryGetWin32HandleInfoKHR*        pGetWin32HandleInfo,
//HANDLE*                                     pHandle);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetMemoryWin32HandlePropertiesKHR(
//VkDevice                                    device,
//VkExternalMemoryHandleTypeFlagBitsKHR       handleType,
//HANDLE                                      handle,
//VkMemoryWin32HandlePropertiesKHR*           pMemoryWin32HandleProperties);
//#endif
//#endif /* VK_USE_PLATFORM_WIN32_KHR */
//
//#define VK_KHR_external_memory_fd 1
//#define VK_KHR_EXTERNAL_MEMORY_FD_SPEC_VERSION 1
//#define VK_KHR_EXTERNAL_MEMORY_FD_EXTENSION_NAME "VK_KHR_external_memory_fd"
//
//typedef struct VkImportMemoryFdInfoKHR {
//    VkStructureType                          sType;
//    const void*                              pNext;
//    VkExternalMemoryHandleTypeFlagBitsKHR    handleType;
//    int                                      fd;
//} VkImportMemoryFdInfoKHR;
//
//typedef struct VkMemoryFdPropertiesKHR {
//    VkStructureType    sType;
//    void*              pNext;
//    uint32_t           memoryTypeBits;
//} VkMemoryFdPropertiesKHR;
//
//typedef struct VkMemoryGetFdInfoKHR {
//    VkStructureType                          sType;
//    const void*                              pNext;
//    VkDeviceMemory                           memory;
//    VkExternalMemoryHandleTypeFlagBitsKHR    handleType;
//} VkMemoryGetFdInfoKHR;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkGetMemoryFdKHR)(VkDevice device, const VkMemoryGetFdInfoKHR* pGetFdInfo, int* pFd);
//typedef VkResult (VKAPI_PTR *PFN_vkGetMemoryFdPropertiesKHR)(VkDevice device, VkExternalMemoryHandleTypeFlagBitsKHR handleType, int fd, VkMemoryFdPropertiesKHR* pMemoryFdProperties);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkGetMemoryFdKHR(
//VkDevice                                    device,
//const VkMemoryGetFdInfoKHR*                 pGetFdInfo,
//int*                                        pFd);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetMemoryFdPropertiesKHR(
//VkDevice                                    device,
//VkExternalMemoryHandleTypeFlagBitsKHR       handleType,
//int                                         fd,
//VkMemoryFdPropertiesKHR*                    pMemoryFdProperties);
//#endif
//
//#ifdef VK_USE_PLATFORM_WIN32_KHR
//#define VK_KHR_win32_keyed_mutex 1
//#define VK_KHR_WIN32_KEYED_MUTEX_SPEC_VERSION 1
//#define VK_KHR_WIN32_KEYED_MUTEX_EXTENSION_NAME "VK_KHR_win32_keyed_mutex"
//
//typedef struct VkWin32KeyedMutexAcquireReleaseInfoKHR {
//    VkStructureType          sType;
//    const void*              pNext;
//    uint32_t                 acquireCount;
//    const VkDeviceMemory*    pAcquireSyncs;
//    const uint64_t*          pAcquireKeys;
//    const uint32_t*          pAcquireTimeouts;
//    uint32_t                 releaseCount;
//    const VkDeviceMemory*    pReleaseSyncs;
//    const uint64_t*          pReleaseKeys;
//} VkWin32KeyedMutexAcquireReleaseInfoKHR;
//
//
//#endif /* VK_USE_PLATFORM_WIN32_KHR */
//
//#define VK_KHR_external_semaphore_capabilities 1
//#define VK_KHR_EXTERNAL_SEMAPHORE_CAPABILITIES_SPEC_VERSION 1
//#define VK_KHR_EXTERNAL_SEMAPHORE_CAPABILITIES_EXTENSION_NAME "VK_KHR_external_semaphore_capabilities"
//
//
//typedef enum VkExternalSemaphoreHandleTypeFlagBitsKHR {
//    VK_EXTERNAL_SEMAPHORE_HANDLE_TYPE_OPAQUE_FD_BIT_KHR = 0x00000001,
//    VK_EXTERNAL_SEMAPHORE_HANDLE_TYPE_OPAQUE_WIN32_BIT_KHR = 0x00000002,
//    VK_EXTERNAL_SEMAPHORE_HANDLE_TYPE_OPAQUE_WIN32_KMT_BIT_KHR = 0x00000004,
//    VK_EXTERNAL_SEMAPHORE_HANDLE_TYPE_D3D12_FENCE_BIT_KHR = 0x00000008,
//    VK_EXTERNAL_SEMAPHORE_HANDLE_TYPE_SYNC_FD_BIT_KHR = 0x00000010,
//    VK_EXTERNAL_SEMAPHORE_HANDLE_TYPE_FLAG_BITS_MAX_ENUM_KHR = 0x7FFFFFFF
//} VkExternalSemaphoreHandleTypeFlagBitsKHR;
//typedef VkFlags VkExternalSemaphoreHandleTypeFlagsKHR;
//
//typedef enum VkExternalSemaphoreFeatureFlagBitsKHR {
//    VK_EXTERNAL_SEMAPHORE_FEATURE_EXPORTABLE_BIT_KHR = 0x00000001,
//    VK_EXTERNAL_SEMAPHORE_FEATURE_IMPORTABLE_BIT_KHR = 0x00000002,
//    VK_EXTERNAL_SEMAPHORE_FEATURE_FLAG_BITS_MAX_ENUM_KHR = 0x7FFFFFFF
//} VkExternalSemaphoreFeatureFlagBitsKHR;
//typedef VkFlags VkExternalSemaphoreFeatureFlagsKHR;
//
//typedef struct VkPhysicalDeviceExternalSemaphoreInfoKHR {
//    VkStructureType                             sType;
//    const void*                                 pNext;
//    VkExternalSemaphoreHandleTypeFlagBitsKHR    handleType;
//} VkPhysicalDeviceExternalSemaphoreInfoKHR;
//
//typedef struct VkExternalSemaphorePropertiesKHR {
//    VkStructureType                          sType;
//    void*                                    pNext;
//    VkExternalSemaphoreHandleTypeFlagsKHR    exportFromImportedHandleTypes;
//    VkExternalSemaphoreHandleTypeFlagsKHR    compatibleHandleTypes;
//    VkExternalSemaphoreFeatureFlagsKHR       externalSemaphoreFeatures;
//} VkExternalSemaphorePropertiesKHR;
//
//
//typedef void (VKAPI_PTR *PFN_vkGetPhysicalDeviceExternalSemaphorePropertiesKHR)(VkPhysicalDevice physicalDevice, const VkPhysicalDeviceExternalSemaphoreInfoKHR* pExternalSemaphoreInfo, VkExternalSemaphorePropertiesKHR* pExternalSemaphoreProperties);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR void VKAPI_CALL vkGetPhysicalDeviceExternalSemaphorePropertiesKHR(
//VkPhysicalDevice                            physicalDevice,
//const VkPhysicalDeviceExternalSemaphoreInfoKHR* pExternalSemaphoreInfo,
//VkExternalSemaphorePropertiesKHR*           pExternalSemaphoreProperties);
//#endif
//
//#define VK_KHR_external_semaphore 1
//#define VK_KHR_EXTERNAL_SEMAPHORE_SPEC_VERSION 1
//#define VK_KHR_EXTERNAL_SEMAPHORE_EXTENSION_NAME "VK_KHR_external_semaphore"
//
//
//typedef enum VkSemaphoreImportFlagBitsKHR {
//    VK_SEMAPHORE_IMPORT_TEMPORARY_BIT_KHR = 0x00000001,
//    VK_SEMAPHORE_IMPORT_FLAG_BITS_MAX_ENUM_KHR = 0x7FFFFFFF
//} VkSemaphoreImportFlagBitsKHR;
//typedef VkFlags VkSemaphoreImportFlagsKHR;
//
//typedef struct VkExportSemaphoreCreateInfoKHR {
//    VkStructureType                          sType;
//    const void*                              pNext;
//    VkExternalSemaphoreHandleTypeFlagsKHR    handleTypes;
//} VkExportSemaphoreCreateInfoKHR;
//
//
//
//#ifdef VK_USE_PLATFORM_WIN32_KHR
//#define VK_KHR_external_semaphore_win32 1
//#define VK_KHR_EXTERNAL_SEMAPHORE_WIN32_SPEC_VERSION 1
//#define VK_KHR_EXTERNAL_SEMAPHORE_WIN32_EXTENSION_NAME "VK_KHR_external_semaphore_win32"
//
//typedef struct VkImportSemaphoreWin32HandleInfoKHR {
//    VkStructureType                             sType;
//    const void*                                 pNext;
//    VkSemaphore                                 semaphore;
//    VkSemaphoreImportFlagsKHR                   flags;
//    VkExternalSemaphoreHandleTypeFlagBitsKHR    handleType;
//    HANDLE                                      handle;
//    LPCWSTR                                     name;
//} VkImportSemaphoreWin32HandleInfoKHR;
//
//typedef struct VkExportSemaphoreWin32HandleInfoKHR {
//    VkStructureType               sType;
//    const void*                   pNext;
//    const SECURITY_ATTRIBUTES*    pAttributes;
//    DWORD                         dwAccess;
//    LPCWSTR                       name;
//} VkExportSemaphoreWin32HandleInfoKHR;
//
//typedef struct VkD3D12FenceSubmitInfoKHR {
//    VkStructureType    sType;
//    const void*        pNext;
//    uint32_t           waitSemaphoreValuesCount;
//    const uint64_t*    pWaitSemaphoreValues;
//    uint32_t           signalSemaphoreValuesCount;
//    const uint64_t*    pSignalSemaphoreValues;
//} VkD3D12FenceSubmitInfoKHR;
//
//typedef struct VkSemaphoreGetWin32HandleInfoKHR {
//    VkStructureType                             sType;
//    const void*                                 pNext;
//    VkSemaphore                                 semaphore;
//    VkExternalSemaphoreHandleTypeFlagBitsKHR    handleType;
//} VkSemaphoreGetWin32HandleInfoKHR;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkImportSemaphoreWin32HandleKHR)(VkDevice device, const VkImportSemaphoreWin32HandleInfoKHR* pImportSemaphoreWin32HandleInfo);
//typedef VkResult (VKAPI_PTR *PFN_vkGetSemaphoreWin32HandleKHR)(VkDevice device, const VkSemaphoreGetWin32HandleInfoKHR* pGetWin32HandleInfo, HANDLE* pHandle);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkImportSemaphoreWin32HandleKHR(
//VkDevice                                    device,
//const VkImportSemaphoreWin32HandleInfoKHR*  pImportSemaphoreWin32HandleInfo);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetSemaphoreWin32HandleKHR(
//VkDevice                                    device,
//const VkSemaphoreGetWin32HandleInfoKHR*     pGetWin32HandleInfo,
//HANDLE*                                     pHandle);
//#endif
//#endif /* VK_USE_PLATFORM_WIN32_KHR */
//
//#define VK_KHR_external_semaphore_fd 1
//#define VK_KHR_EXTERNAL_SEMAPHORE_FD_SPEC_VERSION 1
//#define VK_KHR_EXTERNAL_SEMAPHORE_FD_EXTENSION_NAME "VK_KHR_external_semaphore_fd"
//
//typedef struct VkImportSemaphoreFdInfoKHR {
//    VkStructureType                             sType;
//    const void*                                 pNext;
//    VkSemaphore                                 semaphore;
//    VkSemaphoreImportFlagsKHR                   flags;
//    VkExternalSemaphoreHandleTypeFlagBitsKHR    handleType;
//    int                                         fd;
//} VkImportSemaphoreFdInfoKHR;
//
//typedef struct VkSemaphoreGetFdInfoKHR {
//    VkStructureType                             sType;
//    const void*                                 pNext;
//    VkSemaphore                                 semaphore;
//    VkExternalSemaphoreHandleTypeFlagBitsKHR    handleType;
//} VkSemaphoreGetFdInfoKHR;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkImportSemaphoreFdKHR)(VkDevice device, const VkImportSemaphoreFdInfoKHR* pImportSemaphoreFdInfo);
//typedef VkResult (VKAPI_PTR *PFN_vkGetSemaphoreFdKHR)(VkDevice device, const VkSemaphoreGetFdInfoKHR* pGetFdInfo, int* pFd);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkImportSemaphoreFdKHR(
//VkDevice                                    device,
//const VkImportSemaphoreFdInfoKHR*           pImportSemaphoreFdInfo);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetSemaphoreFdKHR(
//VkDevice                                    device,
//const VkSemaphoreGetFdInfoKHR*              pGetFdInfo,
//int*                                        pFd);
//#endif
//
//#define VK_KHR_push_descriptor 1
//#define VK_KHR_PUSH_DESCRIPTOR_SPEC_VERSION 1
//#define VK_KHR_PUSH_DESCRIPTOR_EXTENSION_NAME "VK_KHR_push_descriptor"
//
//typedef struct VkPhysicalDevicePushDescriptorPropertiesKHR {
//    VkStructureType    sType;
//    void*              pNext;
//    uint32_t           maxPushDescriptors;
//} VkPhysicalDevicePushDescriptorPropertiesKHR;
//
//
//typedef void (VKAPI_PTR *PFN_vkCmdPushDescriptorSetKHR)(VkCommandBuffer commandBuffer, VkPipelineBindPoint pipelineBindPoint, VkPipelineLayout layout, uint32_t set, uint32_t descriptorWriteCount, const VkWriteDescriptorSet* pDescriptorWrites);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR void VKAPI_CALL vkCmdPushDescriptorSetKHR(
//VkCommandBuffer                             commandBuffer,
//VkPipelineBindPoint                         pipelineBindPoint,
//VkPipelineLayout                            layout,
//uint32_t                                    set,
//uint32_t                                    descriptorWriteCount,
//const VkWriteDescriptorSet*                 pDescriptorWrites);
//#endif
//
//#define VK_KHR_16bit_storage 1
//#define VK_KHR_16BIT_STORAGE_SPEC_VERSION 1
//#define VK_KHR_16BIT_STORAGE_EXTENSION_NAME "VK_KHR_16bit_storage"
//
//typedef struct VkPhysicalDevice16BitStorageFeaturesKHR {
//    VkStructureType    sType;
//    void*              pNext;
//    VkBool32           storageBuffer16BitAccess;
//    VkBool32           uniformAndStorageBuffer16BitAccess;
//    VkBool32           storagePushConstant16;
//    VkBool32           storageInputOutput16;
//} VkPhysicalDevice16BitStorageFeaturesKHR;
//
//
//
//#define VK_KHR_incremental_present 1
//#define VK_KHR_INCREMENTAL_PRESENT_SPEC_VERSION 1
//#define VK_KHR_INCREMENTAL_PRESENT_EXTENSION_NAME "VK_KHR_incremental_present"
//
//typedef struct VkRectLayerKHR {
//    VkOffset2D    offset;
//    VkExtent2D    extent;
//    uint32_t      layer;
//} VkRectLayerKHR;
//
//typedef struct VkPresentRegionKHR {
//    uint32_t                 rectangleCount;
//    const VkRectLayerKHR*    pRectangles;
//} VkPresentRegionKHR;
//
//typedef struct VkPresentRegionsKHR {
//    VkStructureType              sType;
//    const void*                  pNext;
//    uint32_t                     swapchainCount;
//    const VkPresentRegionKHR*    pRegions;
//} VkPresentRegionsKHR;
//
//
//
//#define VK_KHR_descriptor_update_template 1
//VK_DEFINE_NON_DISPATCHABLE_HANDLE(VkDescriptorUpdateTemplateKHR)
//
//#define VK_KHR_DESCRIPTOR_UPDATE_TEMPLATE_SPEC_VERSION 1
//#define VK_KHR_DESCRIPTOR_UPDATE_TEMPLATE_EXTENSION_NAME "VK_KHR_descriptor_update_template"
//
//
//typedef enum VkDescriptorUpdateTemplateTypeKHR {
//    VK_DESCRIPTOR_UPDATE_TEMPLATE_TYPE_DESCRIPTOR_SET_KHR = 0,
//    VK_DESCRIPTOR_UPDATE_TEMPLATE_TYPE_PUSH_DESCRIPTORS_KHR = 1,
//    VK_DESCRIPTOR_UPDATE_TEMPLATE_TYPE_BEGIN_RANGE_KHR = VK_DESCRIPTOR_UPDATE_TEMPLATE_TYPE_DESCRIPTOR_SET_KHR,
//    VK_DESCRIPTOR_UPDATE_TEMPLATE_TYPE_END_RANGE_KHR = VK_DESCRIPTOR_UPDATE_TEMPLATE_TYPE_PUSH_DESCRIPTORS_KHR,
//    VK_DESCRIPTOR_UPDATE_TEMPLATE_TYPE_RANGE_SIZE_KHR = (VK_DESCRIPTOR_UPDATE_TEMPLATE_TYPE_PUSH_DESCRIPTORS_KHR - VK_DESCRIPTOR_UPDATE_TEMPLATE_TYPE_DESCRIPTOR_SET_KHR + 1),
//    VK_DESCRIPTOR_UPDATE_TEMPLATE_TYPE_MAX_ENUM_KHR = 0x7FFFFFFF
//} VkDescriptorUpdateTemplateTypeKHR;
//
//typedef VkFlags VkDescriptorUpdateTemplateCreateFlagsKHR;
//
//typedef struct VkDescriptorUpdateTemplateEntryKHR {
//    uint32_t            dstBinding;
//    uint32_t            dstArrayElement;
//    uint32_t            descriptorCount;
//    VkDescriptorType    descriptorType;
//    size_t              offset;
//    size_t              stride;
//} VkDescriptorUpdateTemplateEntryKHR;
//
//typedef struct VkDescriptorUpdateTemplateCreateInfoKHR {
//    VkStructureType                              sType;
//    void*                                        pNext;
//    VkDescriptorUpdateTemplateCreateFlagsKHR     flags;
//    uint32_t                                     descriptorUpdateEntryCount;
//    const VkDescriptorUpdateTemplateEntryKHR*    pDescriptorUpdateEntries;
//    VkDescriptorUpdateTemplateTypeKHR            templateType;
//    VkDescriptorSetLayout                        descriptorSetLayout;
//    VkPipelineBindPoint                          pipelineBindPoint;
//    VkPipelineLayout                             pipelineLayout;
//    uint32_t                                     set;
//} VkDescriptorUpdateTemplateCreateInfoKHR;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkCreateDescriptorUpdateTemplateKHR)(VkDevice device, const VkDescriptorUpdateTemplateCreateInfoKHR* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkDescriptorUpdateTemplateKHR* pDescriptorUpdateTemplate);
//typedef void (VKAPI_PTR *PFN_vkDestroyDescriptorUpdateTemplateKHR)(VkDevice device, VkDescriptorUpdateTemplateKHR descriptorUpdateTemplate, const VkAllocationCallbacks* pAllocator);
//typedef void (VKAPI_PTR *PFN_vkUpdateDescriptorSetWithTemplateKHR)(VkDevice device, VkDescriptorSet descriptorSet, VkDescriptorUpdateTemplateKHR descriptorUpdateTemplate, const void* pData);
//typedef void (VKAPI_PTR *PFN_vkCmdPushDescriptorSetWithTemplateKHR)(VkCommandBuffer commandBuffer, VkDescriptorUpdateTemplateKHR descriptorUpdateTemplate, VkPipelineLayout layout, uint32_t set, const void* pData);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateDescriptorUpdateTemplateKHR(
//VkDevice                                    device,
//const VkDescriptorUpdateTemplateCreateInfoKHR* pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkDescriptorUpdateTemplateKHR*              pDescriptorUpdateTemplate);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyDescriptorUpdateTemplateKHR(
//VkDevice                                    device,
//VkDescriptorUpdateTemplateKHR               descriptorUpdateTemplate,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR void VKAPI_CALL vkUpdateDescriptorSetWithTemplateKHR(
//VkDevice                                    device,
//VkDescriptorSet                             descriptorSet,
//VkDescriptorUpdateTemplateKHR               descriptorUpdateTemplate,
//const void*                                 pData);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdPushDescriptorSetWithTemplateKHR(
//VkCommandBuffer                             commandBuffer,
//VkDescriptorUpdateTemplateKHR               descriptorUpdateTemplate,
//VkPipelineLayout                            layout,
//uint32_t                                    set,
//const void*                                 pData);
//#endif
//
//#define VK_KHR_shared_presentable_image 1
//#define VK_KHR_SHARED_PRESENTABLE_IMAGE_SPEC_VERSION 1
//#define VK_KHR_SHARED_PRESENTABLE_IMAGE_EXTENSION_NAME "VK_KHR_shared_presentable_image"
//
//typedef struct VkSharedPresentSurfaceCapabilitiesKHR {
//    VkStructureType      sType;
//    void*                pNext;
//    VkImageUsageFlags    sharedPresentSupportedUsageFlags;
//} VkSharedPresentSurfaceCapabilitiesKHR;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkGetSwapchainStatusKHR)(VkDevice device, VkSwapchainKHR swapchain);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkGetSwapchainStatusKHR(
//VkDevice                                    device,
//VkSwapchainKHR                              swapchain);
//#endif
//
//#define VK_KHR_external_fence_capabilities 1
//#define VK_KHR_EXTERNAL_FENCE_CAPABILITIES_SPEC_VERSION 1
//#define VK_KHR_EXTERNAL_FENCE_CAPABILITIES_EXTENSION_NAME "VK_KHR_external_fence_capabilities"
//
//
//typedef enum VkExternalFenceHandleTypeFlagBitsKHR {
//    VK_EXTERNAL_FENCE_HANDLE_TYPE_OPAQUE_FD_BIT_KHR = 0x00000001,
//    VK_EXTERNAL_FENCE_HANDLE_TYPE_OPAQUE_WIN32_BIT_KHR = 0x00000002,
//    VK_EXTERNAL_FENCE_HANDLE_TYPE_OPAQUE_WIN32_KMT_BIT_KHR = 0x00000004,
//    VK_EXTERNAL_FENCE_HANDLE_TYPE_SYNC_FD_BIT_KHR = 0x00000008,
//    VK_EXTERNAL_FENCE_HANDLE_TYPE_FLAG_BITS_MAX_ENUM_KHR = 0x7FFFFFFF
//} VkExternalFenceHandleTypeFlagBitsKHR;
//typedef VkFlags VkExternalFenceHandleTypeFlagsKHR;
//
//typedef enum VkExternalFenceFeatureFlagBitsKHR {
//    VK_EXTERNAL_FENCE_FEATURE_EXPORTABLE_BIT_KHR = 0x00000001,
//    VK_EXTERNAL_FENCE_FEATURE_IMPORTABLE_BIT_KHR = 0x00000002,
//    VK_EXTERNAL_FENCE_FEATURE_FLAG_BITS_MAX_ENUM_KHR = 0x7FFFFFFF
//} VkExternalFenceFeatureFlagBitsKHR;
//typedef VkFlags VkExternalFenceFeatureFlagsKHR;
//
//typedef struct VkPhysicalDeviceExternalFenceInfoKHR {
//    VkStructureType                         sType;
//    const void*                             pNext;
//    VkExternalFenceHandleTypeFlagBitsKHR    handleType;
//} VkPhysicalDeviceExternalFenceInfoKHR;
//
//typedef struct VkExternalFencePropertiesKHR {
//    VkStructureType                      sType;
//    void*                                pNext;
//    VkExternalFenceHandleTypeFlagsKHR    exportFromImportedHandleTypes;
//    VkExternalFenceHandleTypeFlagsKHR    compatibleHandleTypes;
//    VkExternalFenceFeatureFlagsKHR       externalFenceFeatures;
//} VkExternalFencePropertiesKHR;
//
//
//typedef void (VKAPI_PTR *PFN_vkGetPhysicalDeviceExternalFencePropertiesKHR)(VkPhysicalDevice physicalDevice, const VkPhysicalDeviceExternalFenceInfoKHR* pExternalFenceInfo, VkExternalFencePropertiesKHR* pExternalFenceProperties);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR void VKAPI_CALL vkGetPhysicalDeviceExternalFencePropertiesKHR(
//VkPhysicalDevice                            physicalDevice,
//const VkPhysicalDeviceExternalFenceInfoKHR* pExternalFenceInfo,
//VkExternalFencePropertiesKHR*               pExternalFenceProperties);
//#endif
//
//#define VK_KHR_external_fence 1
//#define VK_KHR_EXTERNAL_FENCE_SPEC_VERSION 1
//#define VK_KHR_EXTERNAL_FENCE_EXTENSION_NAME "VK_KHR_external_fence"
//
//
//typedef enum VkFenceImportFlagBitsKHR {
//    VK_FENCE_IMPORT_TEMPORARY_BIT_KHR = 0x00000001,
//    VK_FENCE_IMPORT_FLAG_BITS_MAX_ENUM_KHR = 0x7FFFFFFF
//} VkFenceImportFlagBitsKHR;
//typedef VkFlags VkFenceImportFlagsKHR;
//
//typedef struct VkExportFenceCreateInfoKHR {
//    VkStructureType                      sType;
//    const void*                          pNext;
//    VkExternalFenceHandleTypeFlagsKHR    handleTypes;
//} VkExportFenceCreateInfoKHR;
//
//
//
//#ifdef VK_USE_PLATFORM_WIN32_KHR
//#define VK_KHR_external_fence_win32 1
//#define VK_KHR_EXTERNAL_FENCE_WIN32_SPEC_VERSION 1
//#define VK_KHR_EXTERNAL_FENCE_WIN32_EXTENSION_NAME "VK_KHR_external_fence_win32"
//
//typedef struct VkImportFenceWin32HandleInfoKHR {
//    VkStructureType                         sType;
//    const void*                             pNext;
//    VkFence                                 fence;
//    VkFenceImportFlagsKHR                   flags;
//    VkExternalFenceHandleTypeFlagBitsKHR    handleType;
//    HANDLE                                  handle;
//    LPCWSTR                                 name;
//} VkImportFenceWin32HandleInfoKHR;
//
//typedef struct VkExportFenceWin32HandleInfoKHR {
//    VkStructureType               sType;
//    const void*                   pNext;
//    const SECURITY_ATTRIBUTES*    pAttributes;
//    DWORD                         dwAccess;
//    LPCWSTR                       name;
//} VkExportFenceWin32HandleInfoKHR;
//
//typedef struct VkFenceGetWin32HandleInfoKHR {
//    VkStructureType                         sType;
//    const void*                             pNext;
//    VkFence                                 fence;
//    VkExternalFenceHandleTypeFlagBitsKHR    handleType;
//} VkFenceGetWin32HandleInfoKHR;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkImportFenceWin32HandleKHR)(VkDevice device, const VkImportFenceWin32HandleInfoKHR* pImportFenceWin32HandleInfo);
//typedef VkResult (VKAPI_PTR *PFN_vkGetFenceWin32HandleKHR)(VkDevice device, const VkFenceGetWin32HandleInfoKHR* pGetWin32HandleInfo, HANDLE* pHandle);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkImportFenceWin32HandleKHR(
//VkDevice                                    device,
//const VkImportFenceWin32HandleInfoKHR*      pImportFenceWin32HandleInfo);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetFenceWin32HandleKHR(
//VkDevice                                    device,
//const VkFenceGetWin32HandleInfoKHR*         pGetWin32HandleInfo,
//HANDLE*                                     pHandle);
//#endif
//#endif /* VK_USE_PLATFORM_WIN32_KHR */
//
//#define VK_KHR_external_fence_fd 1
//#define VK_KHR_EXTERNAL_FENCE_FD_SPEC_VERSION 1
//#define VK_KHR_EXTERNAL_FENCE_FD_EXTENSION_NAME "VK_KHR_external_fence_fd"
//
//typedef struct VkImportFenceFdInfoKHR {
//    VkStructureType                         sType;
//    const void*                             pNext;
//    VkFence                                 fence;
//    VkFenceImportFlagsKHR                   flags;
//    VkExternalFenceHandleTypeFlagBitsKHR    handleType;
//    int                                     fd;
//} VkImportFenceFdInfoKHR;
//
//typedef struct VkFenceGetFdInfoKHR {
//    VkStructureType                         sType;
//    const void*                             pNext;
//    VkFence                                 fence;
//    VkExternalFenceHandleTypeFlagBitsKHR    handleType;
//} VkFenceGetFdInfoKHR;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkImportFenceFdKHR)(VkDevice device, const VkImportFenceFdInfoKHR* pImportFenceFdInfo);
//typedef VkResult (VKAPI_PTR *PFN_vkGetFenceFdKHR)(VkDevice device, const VkFenceGetFdInfoKHR* pGetFdInfo, int* pFd);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkImportFenceFdKHR(
//VkDevice                                    device,
//const VkImportFenceFdInfoKHR*               pImportFenceFdInfo);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetFenceFdKHR(
//VkDevice                                    device,
//const VkFenceGetFdInfoKHR*                  pGetFdInfo,
//int*                                        pFd);
//#endif
//
//#define VK_KHR_maintenance2 1
//#define VK_KHR_MAINTENANCE2_SPEC_VERSION  1
//#define VK_KHR_MAINTENANCE2_EXTENSION_NAME "VK_KHR_maintenance2"
//
//
//typedef enum VkPointClippingBehaviorKHR {
//    VK_POINT_CLIPPING_BEHAVIOR_ALL_CLIP_PLANES_KHR = 0,
//    VK_POINT_CLIPPING_BEHAVIOR_USER_CLIP_PLANES_ONLY_KHR = 1,
//    VK_POINT_CLIPPING_BEHAVIOR_BEGIN_RANGE_KHR = VK_POINT_CLIPPING_BEHAVIOR_ALL_CLIP_PLANES_KHR,
//    VK_POINT_CLIPPING_BEHAVIOR_END_RANGE_KHR = VK_POINT_CLIPPING_BEHAVIOR_USER_CLIP_PLANES_ONLY_KHR,
//    VK_POINT_CLIPPING_BEHAVIOR_RANGE_SIZE_KHR = (VK_POINT_CLIPPING_BEHAVIOR_USER_CLIP_PLANES_ONLY_KHR - VK_POINT_CLIPPING_BEHAVIOR_ALL_CLIP_PLANES_KHR + 1),
//    VK_POINT_CLIPPING_BEHAVIOR_MAX_ENUM_KHR = 0x7FFFFFFF
//} VkPointClippingBehaviorKHR;
//
//typedef enum VkTessellationDomainOriginKHR {
//    VK_TESSELLATION_DOMAIN_ORIGIN_UPPER_LEFT_KHR = 0,
//    VK_TESSELLATION_DOMAIN_ORIGIN_LOWER_LEFT_KHR = 1,
//    VK_TESSELLATION_DOMAIN_ORIGIN_BEGIN_RANGE_KHR = VK_TESSELLATION_DOMAIN_ORIGIN_UPPER_LEFT_KHR,
//    VK_TESSELLATION_DOMAIN_ORIGIN_END_RANGE_KHR = VK_TESSELLATION_DOMAIN_ORIGIN_LOWER_LEFT_KHR,
//    VK_TESSELLATION_DOMAIN_ORIGIN_RANGE_SIZE_KHR = (VK_TESSELLATION_DOMAIN_ORIGIN_LOWER_LEFT_KHR - VK_TESSELLATION_DOMAIN_ORIGIN_UPPER_LEFT_KHR + 1),
//    VK_TESSELLATION_DOMAIN_ORIGIN_MAX_ENUM_KHR = 0x7FFFFFFF
//} VkTessellationDomainOriginKHR;
//
//typedef struct VkPhysicalDevicePointClippingPropertiesKHR {
//    VkStructureType               sType;
//    void*                         pNext;
//    VkPointClippingBehaviorKHR    pointClippingBehavior;
//} VkPhysicalDevicePointClippingPropertiesKHR;
//
//typedef struct VkInputAttachmentAspectReferenceKHR {
//    uint32_t              subpass;
//    uint32_t              inputAttachmentIndex;
//    VkImageAspectFlags    aspectMask;
//} VkInputAttachmentAspectReferenceKHR;
//
//typedef struct VkRenderPassInputAttachmentAspectCreateInfoKHR {
//    VkStructureType                               sType;
//    const void*                                   pNext;
//    uint32_t                                      aspectReferenceCount;
//    const VkInputAttachmentAspectReferenceKHR*    pAspectReferences;
//} VkRenderPassInputAttachmentAspectCreateInfoKHR;
//
//typedef struct VkImageViewUsageCreateInfoKHR {
//    VkStructureType      sType;
//    const void*          pNext;
//    VkImageUsageFlags    usage;
//} VkImageViewUsageCreateInfoKHR;
//
//typedef struct VkPipelineTessellationDomainOriginStateCreateInfoKHR {
//    VkStructureType                  sType;
//    const void*                      pNext;
//    VkTessellationDomainOriginKHR    domainOrigin;
//} VkPipelineTessellationDomainOriginStateCreateInfoKHR;
//
//
//
//#define VK_KHR_get_surface_capabilities2 1
//#define VK_KHR_GET_SURFACE_CAPABILITIES_2_SPEC_VERSION 1
//#define VK_KHR_GET_SURFACE_CAPABILITIES_2_EXTENSION_NAME "VK_KHR_get_surface_capabilities2"
//
//typedef struct VkPhysicalDeviceSurfaceInfo2KHR {
//    VkStructureType    sType;
//    const void*        pNext;
//    VkSurfaceKHR       surface;
//} VkPhysicalDeviceSurfaceInfo2KHR;
//
//typedef struct VkSurfaceCapabilities2KHR {
//    VkStructureType             sType;
//    void*                       pNext;
//    VkSurfaceCapabilitiesKHR    surfaceCapabilities;
//} VkSurfaceCapabilities2KHR;
//
//typedef struct VkSurfaceFormat2KHR {
//    VkStructureType       sType;
//    void*                 pNext;
//    VkSurfaceFormatKHR    surfaceFormat;
//} VkSurfaceFormat2KHR;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkGetPhysicalDeviceSurfaceCapabilities2KHR)(VkPhysicalDevice physicalDevice, const VkPhysicalDeviceSurfaceInfo2KHR* pSurfaceInfo, VkSurfaceCapabilities2KHR* pSurfaceCapabilities);
//typedef VkResult (VKAPI_PTR *PFN_vkGetPhysicalDeviceSurfaceFormats2KHR)(VkPhysicalDevice physicalDevice, const VkPhysicalDeviceSurfaceInfo2KHR* pSurfaceInfo, uint32_t* pSurfaceFormatCount, VkSurfaceFormat2KHR* pSurfaceFormats);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkGetPhysicalDeviceSurfaceCapabilities2KHR(
//VkPhysicalDevice                            physicalDevice,
//const VkPhysicalDeviceSurfaceInfo2KHR*      pSurfaceInfo,
//VkSurfaceCapabilities2KHR*                  pSurfaceCapabilities);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetPhysicalDeviceSurfaceFormats2KHR(
//VkPhysicalDevice                            physicalDevice,
//const VkPhysicalDeviceSurfaceInfo2KHR*      pSurfaceInfo,
//uint32_t*                                   pSurfaceFormatCount,
//VkSurfaceFormat2KHR*                        pSurfaceFormats);
//#endif
//
//#define VK_KHR_variable_pointers 1
//#define VK_KHR_VARIABLE_POINTERS_SPEC_VERSION 1
//#define VK_KHR_VARIABLE_POINTERS_EXTENSION_NAME "VK_KHR_variable_pointers"
//
//typedef struct VkPhysicalDeviceVariablePointerFeaturesKHR {
//    VkStructureType    sType;
//    void*              pNext;
//    VkBool32           variablePointersStorageBuffer;
//    VkBool32           variablePointers;
//} VkPhysicalDeviceVariablePointerFeaturesKHR;
//
//
//#define VK_KHR_get_display_properties2 1
//#define VK_KHR_GET_DISPLAY_PROPERTIES_2_SPEC_VERSION 1
//#define VK_KHR_GET_DISPLAY_PROPERTIES_2_EXTENSION_NAME "VK_KHR_get_display_properties2"
//
//typedef struct VkDisplayProperties2KHR {
//    VkStructureType           sType;
//    void*                     pNext;
//    VkDisplayPropertiesKHR    displayProperties;
//} VkDisplayProperties2KHR;
//
//typedef struct VkDisplayPlaneProperties2KHR {
//    VkStructureType                sType;
//    void*                          pNext;
//    VkDisplayPlanePropertiesKHR    displayPlaneProperties;
//} VkDisplayPlaneProperties2KHR;
//
//typedef struct VkDisplayModeProperties2KHR {
//    VkStructureType               sType;
//    void*                         pNext;
//    VkDisplayModePropertiesKHR    displayModeProperties;
//} VkDisplayModeProperties2KHR;
//
//typedef struct VkDisplayPlaneInfo2KHR {
//    VkStructureType     sType;
//    const void*         pNext;
//    VkDisplayModeKHR    mode;
//    uint32_t            planeIndex;
//} VkDisplayPlaneInfo2KHR;
//
//typedef struct VkDisplayPlaneCapabilities2KHR {
//    VkStructureType                  sType;
//    void*                            pNext;
//    VkDisplayPlaneCapabilitiesKHR    capabilities;
//} VkDisplayPlaneCapabilities2KHR;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkGetPhysicalDeviceDisplayProperties2KHR)(VkPhysicalDevice physicalDevice, uint32_t* pPropertyCount, VkDisplayProperties2KHR* pProperties);
//typedef VkResult (VKAPI_PTR *PFN_vkGetPhysicalDeviceDisplayPlaneProperties2KHR)(VkPhysicalDevice physicalDevice, uint32_t* pPropertyCount, VkDisplayPlaneProperties2KHR* pProperties);
//typedef VkResult (VKAPI_PTR *PFN_vkGetDisplayModeProperties2KHR)(VkPhysicalDevice physicalDevice, VkDisplayKHR display, uint32_t* pPropertyCount, VkDisplayModeProperties2KHR* pProperties);
//typedef VkResult (VKAPI_PTR *PFN_vkGetDisplayPlaneCapabilities2KHR)(VkPhysicalDevice physicalDevice, const VkDisplayPlaneInfo2KHR* pDisplayPlaneInfo, VkDisplayPlaneCapabilities2KHR* pCapabilities);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkGetPhysicalDeviceDisplayProperties2KHR(
//VkPhysicalDevice                            physicalDevice,
//uint32_t*                                   pPropertyCount,
//VkDisplayProperties2KHR*                    pProperties);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetPhysicalDeviceDisplayPlaneProperties2KHR(
//VkPhysicalDevice                            physicalDevice,
//uint32_t*                                   pPropertyCount,
//VkDisplayPlaneProperties2KHR*               pProperties);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetDisplayModeProperties2KHR(
//VkPhysicalDevice                            physicalDevice,
//VkDisplayKHR                                display,
//uint32_t*                                   pPropertyCount,
//VkDisplayModeProperties2KHR*                pProperties);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetDisplayPlaneCapabilities2KHR(
//VkPhysicalDevice                            physicalDevice,
//const VkDisplayPlaneInfo2KHR*               pDisplayPlaneInfo,
//VkDisplayPlaneCapabilities2KHR*             pCapabilities);
//#endif
//
//#define VK_KHR_dedicated_allocation 1
//#define VK_KHR_DEDICATED_ALLOCATION_SPEC_VERSION 3
//#define VK_KHR_DEDICATED_ALLOCATION_EXTENSION_NAME "VK_KHR_dedicated_allocation"
//
//typedef struct VkMemoryDedicatedRequirementsKHR {
//    VkStructureType    sType;
//    void*              pNext;
//    VkBool32           prefersDedicatedAllocation;
//    VkBool32           requiresDedicatedAllocation;
//} VkMemoryDedicatedRequirementsKHR;
//
//typedef struct VkMemoryDedicatedAllocateInfoKHR {
//    VkStructureType    sType;
//    const void*        pNext;
//    VkImage            image;
//    VkBuffer           buffer;
//} VkMemoryDedicatedAllocateInfoKHR;
//
//
//
//#define VK_KHR_storage_buffer_storage_class 1
//#define VK_KHR_STORAGE_BUFFER_STORAGE_CLASS_SPEC_VERSION 1
//#define VK_KHR_STORAGE_BUFFER_STORAGE_CLASS_EXTENSION_NAME "VK_KHR_storage_buffer_storage_class"
//
//
//#define VK_KHR_relaxed_block_layout 1
//#define VK_KHR_RELAXED_BLOCK_LAYOUT_SPEC_VERSION 1
//#define VK_KHR_RELAXED_BLOCK_LAYOUT_EXTENSION_NAME "VK_KHR_relaxed_block_layout"
//
//
//#define VK_KHR_get_memory_requirements2 1
//#define VK_KHR_GET_MEMORY_REQUIREMENTS_2_SPEC_VERSION 1
//#define VK_KHR_GET_MEMORY_REQUIREMENTS_2_EXTENSION_NAME "VK_KHR_get_memory_requirements2"
//
//typedef struct VkBufferMemoryRequirementsInfo2KHR {
//    VkStructureType    sType;
//    const void*        pNext;
//    VkBuffer           buffer;
//} VkBufferMemoryRequirementsInfo2KHR;
//
//typedef struct VkImageMemoryRequirementsInfo2KHR {
//    VkStructureType    sType;
//    const void*        pNext;
//    VkImage            image;
//} VkImageMemoryRequirementsInfo2KHR;
//
//typedef struct VkImageSparseMemoryRequirementsInfo2KHR {
//    VkStructureType    sType;
//    const void*        pNext;
//    VkImage            image;
//} VkImageSparseMemoryRequirementsInfo2KHR;
//
//typedef struct VkMemoryRequirements2KHR {
//    VkStructureType         sType;
//    void*                   pNext;
//    VkMemoryRequirements    memoryRequirements;
//} VkMemoryRequirements2KHR;
//
//typedef struct VkSparseImageMemoryRequirements2KHR {
//    VkStructureType                    sType;
//    void*                              pNext;
//    VkSparseImageMemoryRequirements    memoryRequirements;
//} VkSparseImageMemoryRequirements2KHR;
//
//
//typedef void (VKAPI_PTR *PFN_vkGetImageMemoryRequirements2KHR)(VkDevice device, const VkImageMemoryRequirementsInfo2KHR* pInfo, VkMemoryRequirements2KHR* pMemoryRequirements);
//typedef void (VKAPI_PTR *PFN_vkGetBufferMemoryRequirements2KHR)(VkDevice device, const VkBufferMemoryRequirementsInfo2KHR* pInfo, VkMemoryRequirements2KHR* pMemoryRequirements);
//typedef void (VKAPI_PTR *PFN_vkGetImageSparseMemoryRequirements2KHR)(VkDevice device, const VkImageSparseMemoryRequirementsInfo2KHR* pInfo, uint32_t* pSparseMemoryRequirementCount, VkSparseImageMemoryRequirements2KHR* pSparseMemoryRequirements);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR void VKAPI_CALL vkGetImageMemoryRequirements2KHR(
//VkDevice                                    device,
//const VkImageMemoryRequirementsInfo2KHR*    pInfo,
//VkMemoryRequirements2KHR*                   pMemoryRequirements);
//
//VKAPI_ATTR void VKAPI_CALL vkGetBufferMemoryRequirements2KHR(
//VkDevice                                    device,
//const VkBufferMemoryRequirementsInfo2KHR*   pInfo,
//VkMemoryRequirements2KHR*                   pMemoryRequirements);
//
//VKAPI_ATTR void VKAPI_CALL vkGetImageSparseMemoryRequirements2KHR(
//VkDevice                                    device,
//const VkImageSparseMemoryRequirementsInfo2KHR* pInfo,
//uint32_t*                                   pSparseMemoryRequirementCount,
//VkSparseImageMemoryRequirements2KHR*        pSparseMemoryRequirements);
//#endif
//
//#define VK_KHR_image_format_list 1
//#define VK_KHR_IMAGE_FORMAT_LIST_SPEC_VERSION 1
//#define VK_KHR_IMAGE_FORMAT_LIST_EXTENSION_NAME "VK_KHR_image_format_list"
//
//typedef struct VkImageFormatListCreateInfoKHR {
//    VkStructureType    sType;
//    const void*        pNext;
//    uint32_t           viewFormatCount;
//    const VkFormat*    pViewFormats;
//} VkImageFormatListCreateInfoKHR;
//
//
//
//#define VK_KHR_sampler_ycbcr_conversion 1
//VK_DEFINE_NON_DISPATCHABLE_HANDLE(VkSamplerYcbcrConversionKHR)
//
//#define VK_KHR_SAMPLER_YCBCR_CONVERSION_SPEC_VERSION 1
//#define VK_KHR_SAMPLER_YCBCR_CONVERSION_EXTENSION_NAME "VK_KHR_sampler_ycbcr_conversion"
//
//
//typedef enum VkSamplerYcbcrModelConversionKHR {
//    VK_SAMPLER_YCBCR_MODEL_CONVERSION_RGB_IDENTITY_KHR = 0,
//    VK_SAMPLER_YCBCR_MODEL_CONVERSION_YCBCR_IDENTITY_KHR = 1,
//    VK_SAMPLER_YCBCR_MODEL_CONVERSION_YCBCR_709_KHR = 2,
//    VK_SAMPLER_YCBCR_MODEL_CONVERSION_YCBCR_601_KHR = 3,
//    VK_SAMPLER_YCBCR_MODEL_CONVERSION_YCBCR_2020_KHR = 4,
//    VK_SAMPLER_YCBCR_MODEL_CONVERSION_BEGIN_RANGE_KHR = VK_SAMPLER_YCBCR_MODEL_CONVERSION_RGB_IDENTITY_KHR,
//    VK_SAMPLER_YCBCR_MODEL_CONVERSION_END_RANGE_KHR = VK_SAMPLER_YCBCR_MODEL_CONVERSION_YCBCR_2020_KHR,
//    VK_SAMPLER_YCBCR_MODEL_CONVERSION_RANGE_SIZE_KHR = (VK_SAMPLER_YCBCR_MODEL_CONVERSION_YCBCR_2020_KHR - VK_SAMPLER_YCBCR_MODEL_CONVERSION_RGB_IDENTITY_KHR + 1),
//    VK_SAMPLER_YCBCR_MODEL_CONVERSION_MAX_ENUM_KHR = 0x7FFFFFFF
//} VkSamplerYcbcrModelConversionKHR;
//
//typedef enum VkSamplerYcbcrRangeKHR {
//    VK_SAMPLER_YCBCR_RANGE_ITU_FULL_KHR = 0,
//    VK_SAMPLER_YCBCR_RANGE_ITU_NARROW_KHR = 1,
//    VK_SAMPLER_YCBCR_RANGE_BEGIN_RANGE_KHR = VK_SAMPLER_YCBCR_RANGE_ITU_FULL_KHR,
//    VK_SAMPLER_YCBCR_RANGE_END_RANGE_KHR = VK_SAMPLER_YCBCR_RANGE_ITU_NARROW_KHR,
//    VK_SAMPLER_YCBCR_RANGE_RANGE_SIZE_KHR = (VK_SAMPLER_YCBCR_RANGE_ITU_NARROW_KHR - VK_SAMPLER_YCBCR_RANGE_ITU_FULL_KHR + 1),
//    VK_SAMPLER_YCBCR_RANGE_MAX_ENUM_KHR = 0x7FFFFFFF
//} VkSamplerYcbcrRangeKHR;
//
//typedef enum VkChromaLocationKHR {
//    VK_CHROMA_LOCATION_COSITED_EVEN_KHR = 0,
//    VK_CHROMA_LOCATION_MIDPOINT_KHR = 1,
//    VK_CHROMA_LOCATION_BEGIN_RANGE_KHR = VK_CHROMA_LOCATION_COSITED_EVEN_KHR,
//    VK_CHROMA_LOCATION_END_RANGE_KHR = VK_CHROMA_LOCATION_MIDPOINT_KHR,
//    VK_CHROMA_LOCATION_RANGE_SIZE_KHR = (VK_CHROMA_LOCATION_MIDPOINT_KHR - VK_CHROMA_LOCATION_COSITED_EVEN_KHR + 1),
//    VK_CHROMA_LOCATION_MAX_ENUM_KHR = 0x7FFFFFFF
//} VkChromaLocationKHR;
//
//typedef struct VkSamplerYcbcrConversionCreateInfoKHR {
//    VkStructureType                     sType;
//    const void*                         pNext;
//    VkFormat                            format;
//    VkSamplerYcbcrModelConversionKHR    ycbcrModel;
//    VkSamplerYcbcrRangeKHR              ycbcrRange;
//    VkComponentMapping                  components;
//    VkChromaLocationKHR                 xChromaOffset;
//    VkChromaLocationKHR                 yChromaOffset;
//    VkFilter                            chromaFilter;
//    VkBool32                            forceExplicitReconstruction;
//} VkSamplerYcbcrConversionCreateInfoKHR;
//
//typedef struct VkSamplerYcbcrConversionInfoKHR {
//    VkStructureType                sType;
//    const void*                    pNext;
//    VkSamplerYcbcrConversionKHR    conversion;
//} VkSamplerYcbcrConversionInfoKHR;
//
//typedef struct VkBindImagePlaneMemoryInfoKHR {
//    VkStructureType          sType;
//    const void*              pNext;
//    VkImageAspectFlagBits    planeAspect;
//} VkBindImagePlaneMemoryInfoKHR;
//
//typedef struct VkImagePlaneMemoryRequirementsInfoKHR {
//    VkStructureType          sType;
//    const void*              pNext;
//    VkImageAspectFlagBits    planeAspect;
//} VkImagePlaneMemoryRequirementsInfoKHR;
//
//typedef struct VkPhysicalDeviceSamplerYcbcrConversionFeaturesKHR {
//    VkStructureType    sType;
//    void*              pNext;
//    VkBool32           samplerYcbcrConversion;
//} VkPhysicalDeviceSamplerYcbcrConversionFeaturesKHR;
//
//typedef struct VkSamplerYcbcrConversionImageFormatPropertiesKHR {
//    VkStructureType    sType;
//    void*              pNext;
//    uint32_t           combinedImageSamplerDescriptorCount;
//} VkSamplerYcbcrConversionImageFormatPropertiesKHR;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkCreateSamplerYcbcrConversionKHR)(VkDevice device, const VkSamplerYcbcrConversionCreateInfoKHR* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkSamplerYcbcrConversionKHR* pYcbcrConversion);
//typedef void (VKAPI_PTR *PFN_vkDestroySamplerYcbcrConversionKHR)(VkDevice device, VkSamplerYcbcrConversionKHR ycbcrConversion, const VkAllocationCallbacks* pAllocator);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateSamplerYcbcrConversionKHR(
//VkDevice                                    device,
//const VkSamplerYcbcrConversionCreateInfoKHR* pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkSamplerYcbcrConversionKHR*                pYcbcrConversion);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroySamplerYcbcrConversionKHR(
//VkDevice                                    device,
//VkSamplerYcbcrConversionKHR                 ycbcrConversion,
//const VkAllocationCallbacks*                pAllocator);
//#endif
//
//#define VK_KHR_bind_memory2 1
//#define VK_KHR_BIND_MEMORY_2_SPEC_VERSION 1
//#define VK_KHR_BIND_MEMORY_2_EXTENSION_NAME "VK_KHR_bind_memory2"
//
//typedef struct VkBindBufferMemoryInfoKHR {
//    VkStructureType    sType;
//    const void*        pNext;
//    VkBuffer           buffer;
//    VkDeviceMemory     memory;
//    VkDeviceSize       memoryOffset;
//} VkBindBufferMemoryInfoKHR;
//
//typedef struct VkBindImageMemoryInfoKHR {
//    VkStructureType    sType;
//    const void*        pNext;
//    VkImage            image;
//    VkDeviceMemory     memory;
//    VkDeviceSize       memoryOffset;
//} VkBindImageMemoryInfoKHR;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkBindBufferMemory2KHR)(VkDevice device, uint32_t bindInfoCount, const VkBindBufferMemoryInfoKHR* pBindInfos);
//typedef VkResult (VKAPI_PTR *PFN_vkBindImageMemory2KHR)(VkDevice device, uint32_t bindInfoCount, const VkBindImageMemoryInfoKHR* pBindInfos);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkBindBufferMemory2KHR(
//VkDevice                                    device,
//uint32_t                                    bindInfoCount,
//const VkBindBufferMemoryInfoKHR*            pBindInfos);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkBindImageMemory2KHR(
//VkDevice                                    device,
//uint32_t                                    bindInfoCount,
//const VkBindImageMemoryInfoKHR*             pBindInfos);
//#endif
//
//#define VK_KHR_draw_indirect_count 1
//#define VK_KHR_DRAW_INDIRECT_COUNT_SPEC_VERSION 1
//#define VK_KHR_DRAW_INDIRECT_COUNT_EXTENSION_NAME "VK_KHR_draw_indirect_count"
//
//typedef void (VKAPI_PTR *PFN_vkCmdDrawIndirectCountKHR)(VkCommandBuffer commandBuffer, VkBuffer buffer, VkDeviceSize offset, VkBuffer countBuffer, VkDeviceSize countBufferOffset, uint32_t maxDrawCount, uint32_t stride);
//typedef void (VKAPI_PTR *PFN_vkCmdDrawIndexedIndirectCountKHR)(VkCommandBuffer commandBuffer, VkBuffer buffer, VkDeviceSize offset, VkBuffer countBuffer, VkDeviceSize countBufferOffset, uint32_t maxDrawCount, uint32_t stride);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR void VKAPI_CALL vkCmdDrawIndirectCountKHR(
//VkCommandBuffer                             commandBuffer,
//VkBuffer                                    buffer,
//VkDeviceSize                                offset,
//VkBuffer                                    countBuffer,
//VkDeviceSize                                countBufferOffset,
//uint32_t                                    maxDrawCount,
//uint32_t                                    stride);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdDrawIndexedIndirectCountKHR(
//VkCommandBuffer                             commandBuffer,
//VkBuffer                                    buffer,
//VkDeviceSize                                offset,
//VkBuffer                                    countBuffer,
//VkDeviceSize                                countBufferOffset,
//uint32_t                                    maxDrawCount,
//uint32_t                                    stride);
//#endif
//
//#define VK_EXT_debug_report 1
//VK_DEFINE_NON_DISPATCHABLE_HANDLE(VkDebugReportCallbackEXT)
//
//#define VK_EXT_DEBUG_REPORT_SPEC_VERSION  9
//#define VK_EXT_DEBUG_REPORT_EXTENSION_NAME "VK_EXT_debug_report"
//#define DEBUG_REPORT_CREATE_INFO_EXT DEBUG_REPORT_CALLBACK_CREATE_INFO_EXT
//#define VK_DEBUG_REPORT_OBJECT_TYPE_DEBUG_REPORT_EXT VK_DEBUG_REPORT_OBJECT_TYPE_DEBUG_REPORT_CALLBACK_EXT_EXT
//

//typedef VkBool32 (VKAPI_PTR *PFN_vkDebugReportCallbackEXT)(
//VkDebugReportFlagsEXT                       flags,
//VkDebugReportObjectTypeEXT                  objectType,
//uint64_t                                    object,
//size_t                                      location,
//int32_t                                     messageCode,
//const char*                                 pLayerPrefix,
//const char*                                 pMessage,
//void*                                       pUserData);

inline var VkDebugReportCallbackCreateInfoEXT.type
    get() = VkStructureType of VkDebugReportCallbackCreateInfoEXT.nsType(adr)
    set(value) = VkDebugReportCallbackCreateInfoEXT.nsType(adr, value.i)
inline var VkDebugReportCallbackCreateInfoEXT.next
    get() = VkDebugReportCallbackCreateInfoEXT.npNext(adr)
    set(value) = VkDebugReportCallbackCreateInfoEXT.npNext(adr, value)
/** JVM custom */
inline var VkDebugReportCallbackCreateInfoEXT.flag: VkDebugReport
    get() = TODO()
    set(value) = VkDebugReportCallbackCreateInfoEXT.nflags(adr, value.i)
inline var VkDebugReportCallbackCreateInfoEXT.flags: VkDebugReportFlagsEXT
    get() = VkDebugReportCallbackCreateInfoEXT.nflags(adr)
    set(value) = VkDebugReportCallbackCreateInfoEXT.nflags(adr, value)
var debugCallback: VkDebugReportCallbackEXT? = null
var VkDebugReportCallbackCreateInfoEXT.callback: VkDebugReportCallbackType
    get() = TODO() //VkDebugReportCallbackCreateInfoEXT.npfnCallback(adr)
    set(crossinline value) {
        debugCallback?.free()
        debugCallback = VkDebugReportCallbackEXT.create { flags, objectType, `object`, location, messageCode, pLayerPrefix, pMessage, pUserData ->
            val type = VkDebugReportObjectType of objectType
            value(flags, type, `object`, location, messageCode, pLayerPrefix.utf8, pMessage.utf8, pUserData as Any).i
        }.also {
            VkDebugReportCallbackCreateInfoEXT.npfnCallback(adr, it)
        }
    }
inline var VkDebugReportCallbackCreateInfoEXT.userData
    get() = VkDebugReportCallbackCreateInfoEXT.npUserData(adr)
    set(value) = VkDebugReportCallbackCreateInfoEXT.npUserData(adr, value)

//
//typedef VkResult (VKAPI_PTR *PFN_vkCreateDebugReportCallbackEXT)(VkInstance instance, const VkDebugReportCallbackCreateInfoEXT* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkDebugReportCallbackEXT* pCallback);
//typedef void (VKAPI_PTR *PFN_vkDestroyDebugReportCallbackEXT)(VkInstance instance, VkDebugReportCallbackEXT callback, const VkAllocationCallbacks* pAllocator);
//typedef void (VKAPI_PTR *PFN_vkDebugReportMessageEXT)(VkInstance instance, VkDebugReportFlagsEXT flags, VkDebugReportObjectTypeEXT objectType, uint64_t object, size_t location, int32_t messageCode, const char* pLayerPrefix, const char* pMessage);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateDebugReportCallbackEXT(
//VkInstance                                  instance,
//const VkDebugReportCallbackCreateInfoEXT*   pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkDebugReportCallbackEXT*                   pCallback);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyDebugReportCallbackEXT(
//VkInstance                                  instance,
//VkDebugReportCallbackEXT                    callback,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR void VKAPI_CALL vkDebugReportMessageEXT(
//VkInstance                                  instance,
//VkDebugReportFlagsEXT                       flags,
//VkDebugReportObjectTypeEXT                  objectType,
//uint64_t                                    object,
//size_t                                      location,
//int32_t                                     messageCode,
//const char*                                 pLayerPrefix,
//const char*                                 pMessage);
//#endif
//
//#define VK_NV_glsl_shader 1
//#define VK_NV_GLSL_SHADER_SPEC_VERSION    1
//#define VK_NV_GLSL_SHADER_EXTENSION_NAME  "VK_NV_glsl_shader"
//
//
//#define VK_EXT_depth_range_unrestricted 1
//#define VK_EXT_DEPTH_RANGE_UNRESTRICTED_SPEC_VERSION 1
//#define VK_EXT_DEPTH_RANGE_UNRESTRICTED_EXTENSION_NAME "VK_EXT_depth_range_unrestricted"
//
//
//#define VK_IMG_filter_cubic 1
//#define VK_IMG_FILTER_CUBIC_SPEC_VERSION  1
//#define VK_IMG_FILTER_CUBIC_EXTENSION_NAME "VK_IMG_filter_cubic"
//
//
//#define VK_AMD_rasterization_order 1
//#define VK_AMD_RASTERIZATION_ORDER_SPEC_VERSION 1
//#define VK_AMD_RASTERIZATION_ORDER_EXTENSION_NAME "VK_AMD_rasterization_order"
//
//
//typedef enum VkRasterizationOrderAMD {
//    VK_RASTERIZATION_ORDER_STRICT_AMD = 0,
//    VK_RASTERIZATION_ORDER_RELAXED_AMD = 1,
//    VK_RASTERIZATION_ORDER_BEGIN_RANGE_AMD = VK_RASTERIZATION_ORDER_STRICT_AMD,
//    VK_RASTERIZATION_ORDER_END_RANGE_AMD = VK_RASTERIZATION_ORDER_RELAXED_AMD,
//    VK_RASTERIZATION_ORDER_RANGE_SIZE_AMD = (VK_RASTERIZATION_ORDER_RELAXED_AMD - VK_RASTERIZATION_ORDER_STRICT_AMD + 1),
//    VK_RASTERIZATION_ORDER_MAX_ENUM_AMD = 0x7FFFFFFF
//} VkRasterizationOrderAMD;
//
//typedef struct VkPipelineRasterizationStateRasterizationOrderAMD {
//    VkStructureType            sType;
//    const void*                pNext;
//    VkRasterizationOrderAMD    rasterizationOrder;
//} VkPipelineRasterizationStateRasterizationOrderAMD;
//
//
//
//#define VK_AMD_shader_trinary_minmax 1
//#define VK_AMD_SHADER_TRINARY_MINMAX_SPEC_VERSION 1
//#define VK_AMD_SHADER_TRINARY_MINMAX_EXTENSION_NAME "VK_AMD_shader_trinary_minmax"
//
//
//#define VK_AMD_shader_explicit_vertex_parameter 1
//#define VK_AMD_SHADER_EXPLICIT_VERTEX_PARAMETER_SPEC_VERSION 1
//#define VK_AMD_SHADER_EXPLICIT_VERTEX_PARAMETER_EXTENSION_NAME "VK_AMD_shader_explicit_vertex_parameter"
//
//
//#define VK_EXT_debug_marker 1
//#define VK_EXT_DEBUG_MARKER_SPEC_VERSION  4
//#define VK_EXT_DEBUG_MARKER_EXTENSION_NAME "VK_EXT_debug_marker"

inline var VkDebugMarkerObjectNameInfoEXT.type: VkStructureType
    get() = VkStructureType of VkDebugMarkerObjectNameInfoEXT.nsType(adr)
    set(value) = VkDebugMarkerObjectNameInfoEXT.nsType(adr, value.i)
inline var VkDebugMarkerObjectNameInfoEXT.next: Long
    get() = VkDebugMarkerObjectNameInfoEXT.npNext(adr)
    set(value) = VkDebugMarkerObjectNameInfoEXT.npNext(adr, value)
inline var VkDebugMarkerObjectNameInfoEXT.objectType: VkDebugReportObjectType
    get() = VkDebugReportObjectType of VkDebugMarkerObjectNameInfoEXT.nobjectType(adr)
    set(value) = VkDebugMarkerObjectNameInfoEXT.nobjectType(adr, value.i)
inline var VkDebugMarkerObjectNameInfoEXT.`object`: Long
    get() = VkDebugMarkerObjectNameInfoEXT.nobject(adr)
    set(value) = VkDebugMarkerObjectNameInfoEXT.nobject(adr, value)
inline var VkDebugMarkerObjectNameInfoEXT.objectName: String
    get() = VkDebugMarkerObjectNameInfoEXT.npObjectNameString(adr)
    set(value) = VkDebugMarkerObjectNameInfoEXT.npObjectName(adr, value.utf8)


inline var VkDebugMarkerObjectTagInfoEXT.type: VkStructureType
    get() = VkStructureType of VkDebugMarkerObjectTagInfoEXT.nsType(adr)
    set(value) = VkDebugMarkerObjectTagInfoEXT.nsType(adr, value.i)
inline var VkDebugMarkerObjectTagInfoEXT.next: Long
    get() = VkDebugMarkerObjectTagInfoEXT.npNext(adr)
    set(value) = VkDebugMarkerObjectTagInfoEXT.npNext(adr, value)
inline var VkDebugMarkerObjectTagInfoEXT.objectType: VkDebugReportObjectType
    get() = VkDebugReportObjectType of VkDebugMarkerObjectTagInfoEXT.nobjectType(adr)
    set(value) = VkDebugMarkerObjectTagInfoEXT.nobjectType(adr, value.i)
inline var VkDebugMarkerObjectTagInfoEXT.`object`: Long
    get() = VkDebugMarkerObjectTagInfoEXT.nobject(adr)
    set(value) = VkDebugMarkerObjectTagInfoEXT.nobject(adr, value)
inline var VkDebugMarkerObjectTagInfoEXT.tagName: String
    get() = memUTF8(VkDebugMarkerObjectTagInfoEXT.ntagName(adr))
    set(value) = VkDebugMarkerObjectTagInfoEXT.ntagName(adr, value.utf8.adr)
//inline val VkDebugMarkerObjectTagInfoEXT.tagSize: Long get() = VkDebugMarkerObjectTagInfoEXT.ntagSize(adr)
inline var VkDebugMarkerObjectTagInfoEXT.tag: ByteBuffer
    get() = VkDebugMarkerObjectTagInfoEXT.npTag(adr)
    set(value) {
        VkDebugMarkerObjectTagInfoEXT.npTag(adr, value)
        VkDebugMarkerObjectTagInfoEXT.ntagSize(adr, value.remaining().L)
    }


//typedef struct VkDebugMarkerObjectTagInfoEXT {
//    VkStructureType               sType;
//    const void*                   pNext;
//    VkDebugReportObjectTypeEXT    objectType;
//    uint64_t                      object;
//    uint64_t                      tagName;
//    size_t                        tagSize;
//    const void*                   pTag;
//} VkDebugMarkerObjectTagInfoEXT;


inline var VkDebugMarkerMarkerInfoEXT.type: VkStructureType
    get() = VkStructureType of VkDebugMarkerMarkerInfoEXT.nsType(adr)
    set(value) = VkDebugMarkerMarkerInfoEXT.nsType(adr, value.i)
inline var VkDebugMarkerMarkerInfoEXT.next: Long
    get() = VkDebugMarkerMarkerInfoEXT.npNext(adr)
    set(value) = VkDebugMarkerMarkerInfoEXT.npNext(adr, value)
inline var VkDebugMarkerMarkerInfoEXT.markerName: String
    get() = VkDebugMarkerMarkerInfoEXT.npMarkerNameString(adr)
    set(value) = VkDebugMarkerMarkerInfoEXT.npMarkerName(adr, value.utf8)
inline var VkDebugMarkerMarkerInfoEXT.color: Vec4
    get() = Vec4(VkDebugMarkerMarkerInfoEXT.ncolor(adr))
    set(value) {
        memPutFloat(adr + VkDebugMarkerMarkerInfoEXT.COLOR, value.r)
        memPutFloat(adr + VkDebugMarkerMarkerInfoEXT.COLOR + Float.BYTES, value.g)
        memPutFloat(adr + VkDebugMarkerMarkerInfoEXT.COLOR + Float.BYTES * 2, value.b)
        memPutFloat(adr + VkDebugMarkerMarkerInfoEXT.COLOR + Float.BYTES * 3, value.a)
    }

//typedef struct VkDebugMarkerMarkerInfoEXT {
//    VkStructureType    sType;
//    const void*        pNext;
//    const char*        pMarkerName;
//    float              color[4];
//} VkDebugMarkerMarkerInfoEXT;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkDebugMarkerSetObjectTagEXT)(VkDevice device, const VkDebugMarkerObjectTagInfoEXT* pTagInfo);
//typedef VkResult (VKAPI_PTR *PFN_vkDebugMarkerSetObjectNameEXT)(VkDevice device, const VkDebugMarkerObjectNameInfoEXT* pNameInfo);
//typedef void (VKAPI_PTR *PFN_vkCmdDebugMarkerBeginEXT)(VkCommandBuffer commandBuffer, const VkDebugMarkerMarkerInfoEXT* pMarkerInfo);
//typedef void (VKAPI_PTR *PFN_vkCmdDebugMarkerEndEXT)(VkCommandBuffer commandBuffer);
//typedef void (VKAPI_PTR *PFN_vkCmdDebugMarkerInsertEXT)(VkCommandBuffer commandBuffer, const VkDebugMarkerMarkerInfoEXT* pMarkerInfo);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkDebugMarkerSetObjectTagEXT(
//VkDevice                                    device,
//const VkDebugMarkerObjectTagInfoEXT*        pTagInfo);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkDebugMarkerSetObjectNameEXT(
//VkDevice                                    device,
//const VkDebugMarkerObjectNameInfoEXT*       pNameInfo);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdDebugMarkerBeginEXT(
//VkCommandBuffer                             commandBuffer,
//const VkDebugMarkerMarkerInfoEXT*           pMarkerInfo);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdDebugMarkerEndEXT(
//VkCommandBuffer                             commandBuffer);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdDebugMarkerInsertEXT(
//VkCommandBuffer                             commandBuffer,
//const VkDebugMarkerMarkerInfoEXT*           pMarkerInfo);
//#endif
//
//#define VK_AMD_gcn_shader 1
//#define VK_AMD_GCN_SHADER_SPEC_VERSION    1
//#define VK_AMD_GCN_SHADER_EXTENSION_NAME  "VK_AMD_gcn_shader"
//
//
//#define VK_NV_dedicated_allocation 1
//#define VK_NV_DEDICATED_ALLOCATION_SPEC_VERSION 1
//#define VK_NV_DEDICATED_ALLOCATION_EXTENSION_NAME "VK_NV_dedicated_allocation"
//
//typedef struct VkDedicatedAllocationImageCreateInfoNV {
//    VkStructureType    sType;
//    const void*        pNext;
//    VkBool32           dedicatedAllocation;
//} VkDedicatedAllocationImageCreateInfoNV;
//
//typedef struct VkDedicatedAllocationBufferCreateInfoNV {
//    VkStructureType    sType;
//    const void*        pNext;
//    VkBool32           dedicatedAllocation;
//} VkDedicatedAllocationBufferCreateInfoNV;
//
//typedef struct VkDedicatedAllocationMemoryAllocateInfoNV {
//    VkStructureType    sType;
//    const void*        pNext;
//    VkImage            image;
//    VkBuffer           buffer;
//} VkDedicatedAllocationMemoryAllocateInfoNV;
//
//
//
//#define VK_AMD_draw_indirect_count 1
//#define VK_AMD_DRAW_INDIRECT_COUNT_SPEC_VERSION 1
//#define VK_AMD_DRAW_INDIRECT_COUNT_EXTENSION_NAME "VK_AMD_draw_indirect_count"
//
//typedef void (VKAPI_PTR *PFN_vkCmdDrawIndirectCountAMD)(VkCommandBuffer commandBuffer, VkBuffer buffer, VkDeviceSize offset, VkBuffer countBuffer, VkDeviceSize countBufferOffset, uint32_t maxDrawCount, uint32_t stride);
//typedef void (VKAPI_PTR *PFN_vkCmdDrawIndexedIndirectCountAMD)(VkCommandBuffer commandBuffer, VkBuffer buffer, VkDeviceSize offset, VkBuffer countBuffer, VkDeviceSize countBufferOffset, uint32_t maxDrawCount, uint32_t stride);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR void VKAPI_CALL vkCmdDrawIndirectCountAMD(
//VkCommandBuffer                             commandBuffer,
//VkBuffer                                    buffer,
//VkDeviceSize                                offset,
//VkBuffer                                    countBuffer,
//VkDeviceSize                                countBufferOffset,
//uint32_t                                    maxDrawCount,
//uint32_t                                    stride);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdDrawIndexedIndirectCountAMD(
//VkCommandBuffer                             commandBuffer,
//VkBuffer                                    buffer,
//VkDeviceSize                                offset,
//VkBuffer                                    countBuffer,
//VkDeviceSize                                countBufferOffset,
//uint32_t                                    maxDrawCount,
//uint32_t                                    stride);
//#endif
//
//#define VK_AMD_negative_viewport_height 1
//#define VK_AMD_NEGATIVE_VIEWPORT_HEIGHT_SPEC_VERSION 1
//#define VK_AMD_NEGATIVE_VIEWPORT_HEIGHT_EXTENSION_NAME "VK_AMD_negative_viewport_height"
//
//
//#define VK_AMD_gpu_shader_half_float 1
//#define VK_AMD_GPU_SHADER_HALF_FLOAT_SPEC_VERSION 1
//#define VK_AMD_GPU_SHADER_HALF_FLOAT_EXTENSION_NAME "VK_AMD_gpu_shader_half_float"
//
//
//#define VK_AMD_shader_ballot 1
//#define VK_AMD_SHADER_BALLOT_SPEC_VERSION 1
//#define VK_AMD_SHADER_BALLOT_EXTENSION_NAME "VK_AMD_shader_ballot"
//
//
//#define VK_AMD_texture_gather_bias_lod 1
//#define VK_AMD_TEXTURE_GATHER_BIAS_LOD_SPEC_VERSION 1
//#define VK_AMD_TEXTURE_GATHER_BIAS_LOD_EXTENSION_NAME "VK_AMD_texture_gather_bias_lod"
//
//typedef struct VkTextureLODGatherFormatPropertiesAMD {
//    VkStructureType    sType;
//    void*              pNext;
//    VkBool32           supportsTextureGatherLODBiasAMD;
//} VkTextureLODGatherFormatPropertiesAMD;
//
//
//
//#define VK_AMD_shader_info 1
//#define VK_AMD_SHADER_INFO_SPEC_VERSION   1
//#define VK_AMD_SHADER_INFO_EXTENSION_NAME "VK_AMD_shader_info"
//
//
//typedef enum VkShaderInfoTypeAMD {
//    VK_SHADER_INFO_TYPE_STATISTICS_AMD = 0,
//    VK_SHADER_INFO_TYPE_BINARY_AMD = 1,
//    VK_SHADER_INFO_TYPE_DISASSEMBLY_AMD = 2,
//    VK_SHADER_INFO_TYPE_BEGIN_RANGE_AMD = VK_SHADER_INFO_TYPE_STATISTICS_AMD,
//    VK_SHADER_INFO_TYPE_END_RANGE_AMD = VK_SHADER_INFO_TYPE_DISASSEMBLY_AMD,
//    VK_SHADER_INFO_TYPE_RANGE_SIZE_AMD = (VK_SHADER_INFO_TYPE_DISASSEMBLY_AMD - VK_SHADER_INFO_TYPE_STATISTICS_AMD + 1),
//    VK_SHADER_INFO_TYPE_MAX_ENUM_AMD = 0x7FFFFFFF
//} VkShaderInfoTypeAMD;
//
//typedef struct VkShaderResourceUsageAMD {
//    uint32_t    numUsedVgprs;
//    uint32_t    numUsedSgprs;
//    uint32_t    ldsSizePerLocalWorkGroup;
//    size_t      ldsUsageSizeInBytes;
//    size_t      scratchMemUsageInBytes;
//} VkShaderResourceUsageAMD;
//
//typedef struct VkShaderStatisticsInfoAMD {
//    VkShaderStageFlags          shaderStageMask;
//    VkShaderResourceUsageAMD    resourceUsage;
//    uint32_t                    numPhysicalVgprs;
//    uint32_t                    numPhysicalSgprs;
//    uint32_t                    numAvailableVgprs;
//    uint32_t                    numAvailableSgprs;
//    uint32_t                    computeWorkGroupSize[3];
//} VkShaderStatisticsInfoAMD;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkGetShaderInfoAMD)(VkDevice device, VkPipeline pipeline, VkShaderStageFlagBits shaderStage, VkShaderInfoTypeAMD infoType, size_t* pInfoSize, void* pInfo);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkGetShaderInfoAMD(
//VkDevice                                    device,
//VkPipeline                                  pipeline,
//VkShaderStageFlagBits                       shaderStage,
//VkShaderInfoTypeAMD                         infoType,
//size_t*                                     pInfoSize,
//void*                                       pInfo);
//#endif
//
//#define VK_AMD_shader_image_load_store_lod 1
//#define VK_AMD_SHADER_IMAGE_LOAD_STORE_LOD_SPEC_VERSION 1
//#define VK_AMD_SHADER_IMAGE_LOAD_STORE_LOD_EXTENSION_NAME "VK_AMD_shader_image_load_store_lod"
//
//
//#define VK_KHX_multiview 1
//#define VK_KHX_MULTIVIEW_SPEC_VERSION     1
//#define VK_KHX_MULTIVIEW_EXTENSION_NAME   "VK_KHX_multiview"
//
//typedef struct VkRenderPassMultiviewCreateInfoKHX {
//    VkStructureType    sType;
//    const void*        pNext;
//    uint32_t           subpassCount;
//    const uint32_t*    pViewMasks;
//    uint32_t           dependencyCount;
//    const int32_t*     pViewOffsets;
//    uint32_t           correlationMaskCount;
//    const uint32_t*    pCorrelationMasks;
//} VkRenderPassMultiviewCreateInfoKHX;
//
//typedef struct VkPhysicalDeviceMultiviewFeaturesKHX {
//    VkStructureType    sType;
//    void*              pNext;
//    VkBool32           multiview;
//    VkBool32           multiviewGeometryShader;
//    VkBool32           multiviewTessellationShader;
//} VkPhysicalDeviceMultiviewFeaturesKHX;
//
//typedef struct VkPhysicalDeviceMultiviewPropertiesKHX {
//    VkStructureType    sType;
//    void*              pNext;
//    uint32_t           maxMultiviewViewCount;
//    uint32_t           maxMultiviewInstanceIndex;
//} VkPhysicalDeviceMultiviewPropertiesKHX;
//
//
//
//#define VK_IMG_format_pvrtc 1
//#define VK_IMG_FORMAT_PVRTC_SPEC_VERSION  1
//#define VK_IMG_FORMAT_PVRTC_EXTENSION_NAME "VK_IMG_format_pvrtc"
//
//
//#define VK_NV_external_memory_capabilities 1
//#define VK_NV_EXTERNAL_MEMORY_CAPABILITIES_SPEC_VERSION 1
//#define VK_NV_EXTERNAL_MEMORY_CAPABILITIES_EXTENSION_NAME "VK_NV_external_memory_capabilities"
//
//
//typedef enum VkExternalMemoryHandleTypeFlagBitsNV {
//    VK_EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_WIN32_BIT_NV = 0x00000001,
//    VK_EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_WIN32_KMT_BIT_NV = 0x00000002,
//    VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D11_IMAGE_BIT_NV = 0x00000004,
//    VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D11_IMAGE_KMT_BIT_NV = 0x00000008,
//    VK_EXTERNAL_MEMORY_HANDLE_TYPE_FLAG_BITS_MAX_ENUM_NV = 0x7FFFFFFF
//} VkExternalMemoryHandleTypeFlagBitsNV;
//typedef VkFlags VkExternalMemoryHandleTypeFlagsNV;
//
//typedef enum VkExternalMemoryFeatureFlagBitsNV {
//    VK_EXTERNAL_MEMORY_FEATURE_DEDICATED_ONLY_BIT_NV = 0x00000001,
//    VK_EXTERNAL_MEMORY_FEATURE_EXPORTABLE_BIT_NV = 0x00000002,
//    VK_EXTERNAL_MEMORY_FEATURE_IMPORTABLE_BIT_NV = 0x00000004,
//    VK_EXTERNAL_MEMORY_FEATURE_FLAG_BITS_MAX_ENUM_NV = 0x7FFFFFFF
//} VkExternalMemoryFeatureFlagBitsNV;
//typedef VkFlags VkExternalMemoryFeatureFlagsNV;
//
//typedef struct VkExternalImageFormatPropertiesNV {
//    VkImageFormatProperties              imageFormatProperties;
//    VkExternalMemoryFeatureFlagsNV       externalMemoryFeatures;
//    VkExternalMemoryHandleTypeFlagsNV    exportFromImportedHandleTypes;
//    VkExternalMemoryHandleTypeFlagsNV    compatibleHandleTypes;
//} VkExternalImageFormatPropertiesNV;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkGetPhysicalDeviceExternalImageFormatPropertiesNV)(VkPhysicalDevice physicalDevice, VkFormat format, VkImageType type, VkImageTiling tiling, VkImageUsageFlags usage, VkImageCreateFlags flags, VkExternalMemoryHandleTypeFlagsNV externalHandleType, VkExternalImageFormatPropertiesNV* pExternalImageFormatProperties);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkGetPhysicalDeviceExternalImageFormatPropertiesNV(
//VkPhysicalDevice                            physicalDevice,
//VkFormat                                    format,
//VkImageType                                 type,
//VkImageTiling                               tiling,
//VkImageUsageFlags                           usage,
//VkImageCreateFlags                          flags,
//VkExternalMemoryHandleTypeFlagsNV           externalHandleType,
//VkExternalImageFormatPropertiesNV*          pExternalImageFormatProperties);
//#endif
//
//#define VK_NV_external_memory 1
//#define VK_NV_EXTERNAL_MEMORY_SPEC_VERSION 1
//#define VK_NV_EXTERNAL_MEMORY_EXTENSION_NAME "VK_NV_external_memory"
//
//typedef struct VkExternalMemoryImageCreateInfoNV {
//    VkStructureType                      sType;
//    const void*                          pNext;
//    VkExternalMemoryHandleTypeFlagsNV    handleTypes;
//} VkExternalMemoryImageCreateInfoNV;
//
//typedef struct VkExportMemoryAllocateInfoNV {
//    VkStructureType                      sType;
//    const void*                          pNext;
//    VkExternalMemoryHandleTypeFlagsNV    handleTypes;
//} VkExportMemoryAllocateInfoNV;
//
//
//
//#ifdef VK_USE_PLATFORM_WIN32_KHR
//#define VK_NV_external_memory_win32 1
//#define VK_NV_EXTERNAL_MEMORY_WIN32_SPEC_VERSION 1
//#define VK_NV_EXTERNAL_MEMORY_WIN32_EXTENSION_NAME "VK_NV_external_memory_win32"
//
//typedef struct VkImportMemoryWin32HandleInfoNV {
//    VkStructureType                      sType;
//    const void*                          pNext;
//    VkExternalMemoryHandleTypeFlagsNV    handleType;
//    HANDLE                               handle;
//} VkImportMemoryWin32HandleInfoNV;
//
//typedef struct VkExportMemoryWin32HandleInfoNV {
//    VkStructureType               sType;
//    const void*                   pNext;
//    const SECURITY_ATTRIBUTES*    pAttributes;
//    DWORD                         dwAccess;
//} VkExportMemoryWin32HandleInfoNV;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkGetMemoryWin32HandleNV)(VkDevice device, VkDeviceMemory memory, VkExternalMemoryHandleTypeFlagsNV handleType, HANDLE* pHandle);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkGetMemoryWin32HandleNV(
//VkDevice                                    device,
//VkDeviceMemory                              memory,
//VkExternalMemoryHandleTypeFlagsNV           handleType,
//HANDLE*                                     pHandle);
//#endif
//#endif /* VK_USE_PLATFORM_WIN32_KHR */
//
//#ifdef VK_USE_PLATFORM_WIN32_KHR
//#define VK_NV_win32_keyed_mutex 1
//#define VK_NV_WIN32_KEYED_MUTEX_SPEC_VERSION 1
//#define VK_NV_WIN32_KEYED_MUTEX_EXTENSION_NAME "VK_NV_win32_keyed_mutex"
//
//typedef struct VkWin32KeyedMutexAcquireReleaseInfoNV {
//    VkStructureType          sType;
//    const void*              pNext;
//    uint32_t                 acquireCount;
//    const VkDeviceMemory*    pAcquireSyncs;
//    const uint64_t*          pAcquireKeys;
//    const uint32_t*          pAcquireTimeoutMilliseconds;
//    uint32_t                 releaseCount;
//    const VkDeviceMemory*    pReleaseSyncs;
//    const uint64_t*          pReleaseKeys;
//} VkWin32KeyedMutexAcquireReleaseInfoNV;
//
//
//#endif /* VK_USE_PLATFORM_WIN32_KHR */
//
//#define VK_KHX_device_group 1
//#define VK_KHX_DEVICE_GROUP_SPEC_VERSION  2
//#define VK_KHX_DEVICE_GROUP_EXTENSION_NAME "VK_KHX_device_group"
//#define VK_MAX_DEVICE_GROUP_SIZE_KHX      32
//
//
//typedef enum VkPeerMemoryFeatureFlagBitsKHX {
//    VK_PEER_MEMORY_FEATURE_COPY_SRC_BIT_KHX = 0x00000001,
//    VK_PEER_MEMORY_FEATURE_COPY_DST_BIT_KHX = 0x00000002,
//    VK_PEER_MEMORY_FEATURE_GENERIC_SRC_BIT_KHX = 0x00000004,
//    VK_PEER_MEMORY_FEATURE_GENERIC_DST_BIT_KHX = 0x00000008,
//    VK_PEER_MEMORY_FEATURE_FLAG_BITS_MAX_ENUM_KHX = 0x7FFFFFFF
//} VkPeerMemoryFeatureFlagBitsKHX;
//typedef VkFlags VkPeerMemoryFeatureFlagsKHX;
//
//typedef enum VkMemoryAllocateFlagBitsKHX {
//    VK_MEMORY_ALLOCATE_DEVICE_MASK_BIT_KHX = 0x00000001,
//    VK_MEMORY_ALLOCATE_FLAG_BITS_MAX_ENUM_KHX = 0x7FFFFFFF
//} VkMemoryAllocateFlagBitsKHX;
//typedef VkFlags VkMemoryAllocateFlagsKHX;
//
//typedef enum VkDeviceGroupPresentModeFlagBitsKHX {
//    VK_DEVICE_GROUP_PRESENT_MODE_LOCAL_BIT_KHX = 0x00000001,
//    VK_DEVICE_GROUP_PRESENT_MODE_REMOTE_BIT_KHX = 0x00000002,
//    VK_DEVICE_GROUP_PRESENT_MODE_SUM_BIT_KHX = 0x00000004,
//    VK_DEVICE_GROUP_PRESENT_MODE_LOCAL_MULTI_DEVICE_BIT_KHX = 0x00000008,
//    VK_DEVICE_GROUP_PRESENT_MODE_FLAG_BITS_MAX_ENUM_KHX = 0x7FFFFFFF
//} VkDeviceGroupPresentModeFlagBitsKHX;
//typedef VkFlags VkDeviceGroupPresentModeFlagsKHX;
//
//typedef struct VkMemoryAllocateFlagsInfoKHX {
//    VkStructureType             sType;
//    const void*                 pNext;
//    VkMemoryAllocateFlagsKHX    flags;
//    uint32_t                    deviceMask;
//} VkMemoryAllocateFlagsInfoKHX;
//
//typedef struct VkDeviceGroupRenderPassBeginInfoKHX {
//    VkStructureType    sType;
//    const void*        pNext;
//    uint32_t           deviceMask;
//    uint32_t           deviceRenderAreaCount;
//    const VkRect2D*    pDeviceRenderAreas;
//} VkDeviceGroupRenderPassBeginInfoKHX;
//
//typedef struct VkDeviceGroupCommandBufferBeginInfoKHX {
//    VkStructureType    sType;
//    const void*        pNext;
//    uint32_t           deviceMask;
//} VkDeviceGroupCommandBufferBeginInfoKHX;
//
//typedef struct VkDeviceGroupSubmitInfoKHX {
//    VkStructureType    sType;
//    const void*        pNext;
//    uint32_t           waitSemaphoreCount;
//    const uint32_t*    pWaitSemaphoreDeviceIndices;
//    uint32_t           commandBufferCount;
//    const uint32_t*    pCommandBufferDeviceMasks;
//    uint32_t           signalSemaphoreCount;
//    const uint32_t*    pSignalSemaphoreDeviceIndices;
//} VkDeviceGroupSubmitInfoKHX;
//
//typedef struct VkDeviceGroupBindSparseInfoKHX {
//    VkStructureType    sType;
//    const void*        pNext;
//    uint32_t           resourceDeviceIndex;
//    uint32_t           memoryDeviceIndex;
//} VkDeviceGroupBindSparseInfoKHX;
//
//typedef struct VkBindBufferMemoryDeviceGroupInfoKHX {
//    VkStructureType    sType;
//    const void*        pNext;
//    uint32_t           deviceIndexCount;
//    const uint32_t*    pDeviceIndices;
//} VkBindBufferMemoryDeviceGroupInfoKHX;
//
//typedef struct VkBindImageMemoryDeviceGroupInfoKHX {
//    VkStructureType    sType;
//    const void*        pNext;
//    uint32_t           deviceIndexCount;
//    const uint32_t*    pDeviceIndices;
//    uint32_t           SFRRectCount;
//    const VkRect2D*    pSFRRects;
//} VkBindImageMemoryDeviceGroupInfoKHX;
//
//typedef struct VkDeviceGroupPresentCapabilitiesKHX {
//    VkStructureType                     sType;
//    const void*                         pNext;
//    uint32_t                            presentMask[VK_MAX_DEVICE_GROUP_SIZE_KHX];
//    VkDeviceGroupPresentModeFlagsKHX    modes;
//} VkDeviceGroupPresentCapabilitiesKHX;
//
//typedef struct VkImageSwapchainCreateInfoKHX {
//    VkStructureType    sType;
//    const void*        pNext;
//    VkSwapchainKHR     swapchain;
//} VkImageSwapchainCreateInfoKHX;
//
//typedef struct VkBindImageMemorySwapchainInfoKHX {
//    VkStructureType    sType;
//    const void*        pNext;
//    VkSwapchainKHR     swapchain;
//    uint32_t           imageIndex;
//} VkBindImageMemorySwapchainInfoKHX;
//
//typedef struct VkAcquireNextImageInfoKHX {
//    VkStructureType    sType;
//    const void*        pNext;
//    VkSwapchainKHR     swapchain;
//    uint64_t           timeout;
//    VkSemaphore        semaphore;
//    VkFence            fence;
//    uint32_t           deviceMask;
//} VkAcquireNextImageInfoKHX;
//
//typedef struct VkDeviceGroupPresentInfoKHX {
//    VkStructureType                        sType;
//    const void*                            pNext;
//    uint32_t                               swapchainCount;
//    const uint32_t*                        pDeviceMasks;
//    VkDeviceGroupPresentModeFlagBitsKHX    mode;
//} VkDeviceGroupPresentInfoKHX;
//
//typedef struct VkDeviceGroupSwapchainCreateInfoKHX {
//    VkStructureType                     sType;
//    const void*                         pNext;
//    VkDeviceGroupPresentModeFlagsKHX    modes;
//} VkDeviceGroupSwapchainCreateInfoKHX;
//
//
//typedef void (VKAPI_PTR *PFN_vkGetDeviceGroupPeerMemoryFeaturesKHX)(VkDevice device, uint32_t heapIndex, uint32_t localDeviceIndex, uint32_t remoteDeviceIndex, VkPeerMemoryFeatureFlagsKHX* pPeerMemoryFeatures);
//typedef void (VKAPI_PTR *PFN_vkCmdSetDeviceMaskKHX)(VkCommandBuffer commandBuffer, uint32_t deviceMask);
//typedef void (VKAPI_PTR *PFN_vkCmdDispatchBaseKHX)(VkCommandBuffer commandBuffer, uint32_t baseGroupX, uint32_t baseGroupY, uint32_t baseGroupZ, uint32_t groupCountX, uint32_t groupCountY, uint32_t groupCountZ);
//typedef VkResult (VKAPI_PTR *PFN_vkGetDeviceGroupPresentCapabilitiesKHX)(VkDevice device, VkDeviceGroupPresentCapabilitiesKHX* pDeviceGroupPresentCapabilities);
//typedef VkResult (VKAPI_PTR *PFN_vkGetDeviceGroupSurfacePresentModesKHX)(VkDevice device, VkSurfaceKHR surface, VkDeviceGroupPresentModeFlagsKHX* pModes);
//typedef VkResult (VKAPI_PTR *PFN_vkGetPhysicalDevicePresentRectanglesKHX)(VkPhysicalDevice physicalDevice, VkSurfaceKHR surface, uint32_t* pRectCount, VkRect2D* pRects);
//typedef VkResult (VKAPI_PTR *PFN_vkAcquireNextImage2KHX)(VkDevice device, const VkAcquireNextImageInfoKHX* pAcquireInfo, uint32_t* pImageIndex);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR void VKAPI_CALL vkGetDeviceGroupPeerMemoryFeaturesKHX(
//VkDevice                                    device,
//uint32_t                                    heapIndex,
//uint32_t                                    localDeviceIndex,
//uint32_t                                    remoteDeviceIndex,
//VkPeerMemoryFeatureFlagsKHX*                pPeerMemoryFeatures);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdSetDeviceMaskKHX(
//VkCommandBuffer                             commandBuffer,
//uint32_t                                    deviceMask);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdDispatchBaseKHX(
//VkCommandBuffer                             commandBuffer,
//uint32_t                                    baseGroupX,
//uint32_t                                    baseGroupY,
//uint32_t                                    baseGroupZ,
//uint32_t                                    groupCountX,
//uint32_t                                    groupCountY,
//uint32_t                                    groupCountZ);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetDeviceGroupPresentCapabilitiesKHX(
//VkDevice                                    device,
//VkDeviceGroupPresentCapabilitiesKHX*        pDeviceGroupPresentCapabilities);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetDeviceGroupSurfacePresentModesKHX(
//VkDevice                                    device,
//VkSurfaceKHR                                surface,
//VkDeviceGroupPresentModeFlagsKHX*           pModes);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetPhysicalDevicePresentRectanglesKHX(
//VkPhysicalDevice                            physicalDevice,
//VkSurfaceKHR                                surface,
//uint32_t*                                   pRectCount,
//VkRect2D*                                   pRects);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkAcquireNextImage2KHX(
//VkDevice                                    device,
//const VkAcquireNextImageInfoKHX*            pAcquireInfo,
//uint32_t*                                   pImageIndex);
//#endif
//
//#define VK_EXT_validation_flags 1
//#define VK_EXT_VALIDATION_FLAGS_SPEC_VERSION 1
//#define VK_EXT_VALIDATION_FLAGS_EXTENSION_NAME "VK_EXT_validation_flags"
//
//
//typedef enum VkValidationCheckEXT {
//    VK_VALIDATION_CHECK_ALL_EXT = 0,
//    VK_VALIDATION_CHECK_SHADERS_EXT = 1,
//    VK_VALIDATION_CHECK_BEGIN_RANGE_EXT = VK_VALIDATION_CHECK_ALL_EXT,
//    VK_VALIDATION_CHECK_END_RANGE_EXT = VK_VALIDATION_CHECK_SHADERS_EXT,
//    VK_VALIDATION_CHECK_RANGE_SIZE_EXT = (VK_VALIDATION_CHECK_SHADERS_EXT - VK_VALIDATION_CHECK_ALL_EXT + 1),
//    VK_VALIDATION_CHECK_MAX_ENUM_EXT = 0x7FFFFFFF
//} VkValidationCheckEXT;
//
//typedef struct VkValidationFlagsEXT {
//    VkStructureType          sType;
//    const void*              pNext;
//    uint32_t                 disabledValidationCheckCount;
//    VkValidationCheckEXT*    pDisabledValidationChecks;
//} VkValidationFlagsEXT;
//
//
//
//#ifdef VK_USE_PLATFORM_VI_NN
//#define VK_NN_vi_surface 1
//#define VK_NN_VI_SURFACE_SPEC_VERSION     1
//#define VK_NN_VI_SURFACE_EXTENSION_NAME   "VK_NN_vi_surface"
//
//typedef VkFlags VkViSurfaceCreateFlagsNN;
//
//typedef struct VkViSurfaceCreateInfoNN {
//    VkStructureType             sType;
//    const void*                 pNext;
//    VkViSurfaceCreateFlagsNN    flags;
//    void*                       window;
//} VkViSurfaceCreateInfoNN;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkCreateViSurfaceNN)(VkInstance instance, const VkViSurfaceCreateInfoNN* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkSurfaceKHR* pSurface);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateViSurfaceNN(
//VkInstance                                  instance,
//const VkViSurfaceCreateInfoNN*              pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkSurfaceKHR*                               pSurface);
//#endif
//#endif /* VK_USE_PLATFORM_VI_NN */
//
//#define VK_EXT_shader_subgroup_ballot 1
//#define VK_EXT_SHADER_SUBGROUP_BALLOT_SPEC_VERSION 1
//#define VK_EXT_SHADER_SUBGROUP_BALLOT_EXTENSION_NAME "VK_EXT_shader_subgroup_ballot"
//
//
//#define VK_EXT_shader_subgroup_vote 1
//#define VK_EXT_SHADER_SUBGROUP_VOTE_SPEC_VERSION 1
//#define VK_EXT_SHADER_SUBGROUP_VOTE_EXTENSION_NAME "VK_EXT_shader_subgroup_vote"
//
//
//#define VK_KHX_device_group_creation 1
//#define VK_KHX_DEVICE_GROUP_CREATION_SPEC_VERSION 1
//#define VK_KHX_DEVICE_GROUP_CREATION_EXTENSION_NAME "VK_KHX_device_group_creation"
//
//typedef struct VkPhysicalDeviceGroupPropertiesKHX {
//    VkStructureType     sType;
//    void*               pNext;
//    uint32_t            physicalDeviceCount;
//    VkPhysicalDevice    physicalDevices[VK_MAX_DEVICE_GROUP_SIZE_KHX];
//    VkBool32            subsetAllocation;
//} VkPhysicalDeviceGroupPropertiesKHX;
//
//typedef struct VkDeviceGroupDeviceCreateInfoKHX {
//    VkStructureType            sType;
//    const void*                pNext;
//    uint32_t                   physicalDeviceCount;
//    const VkPhysicalDevice*    pPhysicalDevices;
//} VkDeviceGroupDeviceCreateInfoKHX;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkEnumeratePhysicalDeviceGroupsKHX)(VkInstance instance, uint32_t* pPhysicalDeviceGroupCount, VkPhysicalDeviceGroupPropertiesKHX* pPhysicalDeviceGroupProperties);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkEnumeratePhysicalDeviceGroupsKHX(
//VkInstance                                  instance,
//uint32_t*                                   pPhysicalDeviceGroupCount,
//VkPhysicalDeviceGroupPropertiesKHX*         pPhysicalDeviceGroupProperties);
//#endif
//
//#define VK_NVX_device_generated_commands 1
//VK_DEFINE_NON_DISPATCHABLE_HANDLE(VkObjectTableNVX)
//VK_DEFINE_NON_DISPATCHABLE_HANDLE(VkIndirectCommandsLayoutNVX)
//
//#define VK_NVX_DEVICE_GENERATED_COMMANDS_SPEC_VERSION 3
//#define VK_NVX_DEVICE_GENERATED_COMMANDS_EXTENSION_NAME "VK_NVX_device_generated_commands"
//
//
//typedef enum VkIndirectCommandsTokenTypeNVX {
//    VK_INDIRECT_COMMANDS_TOKEN_TYPE_PIPELINE_NVX = 0,
//    VK_INDIRECT_COMMANDS_TOKEN_TYPE_DESCRIPTOR_SET_NVX = 1,
//    VK_INDIRECT_COMMANDS_TOKEN_TYPE_INDEX_BUFFER_NVX = 2,
//    VK_INDIRECT_COMMANDS_TOKEN_TYPE_VERTEX_BUFFER_NVX = 3,
//    VK_INDIRECT_COMMANDS_TOKEN_TYPE_PUSH_CONSTANT_NVX = 4,
//    VK_INDIRECT_COMMANDS_TOKEN_TYPE_DRAW_INDEXED_NVX = 5,
//    VK_INDIRECT_COMMANDS_TOKEN_TYPE_DRAW_NVX = 6,
//    VK_INDIRECT_COMMANDS_TOKEN_TYPE_DISPATCH_NVX = 7,
//    VK_INDIRECT_COMMANDS_TOKEN_TYPE_BEGIN_RANGE_NVX = VK_INDIRECT_COMMANDS_TOKEN_TYPE_PIPELINE_NVX,
//    VK_INDIRECT_COMMANDS_TOKEN_TYPE_END_RANGE_NVX = VK_INDIRECT_COMMANDS_TOKEN_TYPE_DISPATCH_NVX,
//    VK_INDIRECT_COMMANDS_TOKEN_TYPE_RANGE_SIZE_NVX = (VK_INDIRECT_COMMANDS_TOKEN_TYPE_DISPATCH_NVX - VK_INDIRECT_COMMANDS_TOKEN_TYPE_PIPELINE_NVX + 1),
//    VK_INDIRECT_COMMANDS_TOKEN_TYPE_MAX_ENUM_NVX = 0x7FFFFFFF
//} VkIndirectCommandsTokenTypeNVX;
//
//typedef enum VkObjectEntryTypeNVX {
//    VK_OBJECT_ENTRY_TYPE_DESCRIPTOR_SET_NVX = 0,
//    VK_OBJECT_ENTRY_TYPE_PIPELINE_NVX = 1,
//    VK_OBJECT_ENTRY_TYPE_INDEX_BUFFER_NVX = 2,
//    VK_OBJECT_ENTRY_TYPE_VERTEX_BUFFER_NVX = 3,
//    VK_OBJECT_ENTRY_TYPE_PUSH_CONSTANT_NVX = 4,
//    VK_OBJECT_ENTRY_TYPE_BEGIN_RANGE_NVX = VK_OBJECT_ENTRY_TYPE_DESCRIPTOR_SET_NVX,
//    VK_OBJECT_ENTRY_TYPE_END_RANGE_NVX = VK_OBJECT_ENTRY_TYPE_PUSH_CONSTANT_NVX,
//    VK_OBJECT_ENTRY_TYPE_RANGE_SIZE_NVX = (VK_OBJECT_ENTRY_TYPE_PUSH_CONSTANT_NVX - VK_OBJECT_ENTRY_TYPE_DESCRIPTOR_SET_NVX + 1),
//    VK_OBJECT_ENTRY_TYPE_MAX_ENUM_NVX = 0x7FFFFFFF
//} VkObjectEntryTypeNVX;
//
//
//typedef enum VkIndirectCommandsLayoutUsageFlagBitsNVX {
//    VK_INDIRECT_COMMANDS_LAYOUT_USAGE_UNORDERED_SEQUENCES_BIT_NVX = 0x00000001,
//    VK_INDIRECT_COMMANDS_LAYOUT_USAGE_SPARSE_SEQUENCES_BIT_NVX = 0x00000002,
//    VK_INDIRECT_COMMANDS_LAYOUT_USAGE_EMPTY_EXECUTIONS_BIT_NVX = 0x00000004,
//    VK_INDIRECT_COMMANDS_LAYOUT_USAGE_INDEXED_SEQUENCES_BIT_NVX = 0x00000008,
//    VK_INDIRECT_COMMANDS_LAYOUT_USAGE_FLAG_BITS_MAX_ENUM_NVX = 0x7FFFFFFF
//} VkIndirectCommandsLayoutUsageFlagBitsNVX;
//typedef VkFlags VkIndirectCommandsLayoutUsageFlagsNVX;
//
//typedef enum VkObjectEntryUsageFlagBitsNVX {
//    VK_OBJECT_ENTRY_USAGE_GRAPHICS_BIT_NVX = 0x00000001,
//    VK_OBJECT_ENTRY_USAGE_COMPUTE_BIT_NVX = 0x00000002,
//    VK_OBJECT_ENTRY_USAGE_FLAG_BITS_MAX_ENUM_NVX = 0x7FFFFFFF
//} VkObjectEntryUsageFlagBitsNVX;
//typedef VkFlags VkObjectEntryUsageFlagsNVX;
//
//typedef struct VkDeviceGeneratedCommandsFeaturesNVX {
//    VkStructureType    sType;
//    const void*        pNext;
//    VkBool32           computeBindingPointSupport;
//} VkDeviceGeneratedCommandsFeaturesNVX;
//
//typedef struct VkDeviceGeneratedCommandsLimitsNVX {
//    VkStructureType    sType;
//    const void*        pNext;
//    uint32_t           maxIndirectCommandsLayoutTokenCount;
//    uint32_t           maxObjectEntryCounts;
//    uint32_t           minSequenceCountBufferOffsetAlignment;
//    uint32_t           minSequenceIndexBufferOffsetAlignment;
//    uint32_t           minCommandsTokenBufferOffsetAlignment;
//} VkDeviceGeneratedCommandsLimitsNVX;
//
//typedef struct VkIndirectCommandsTokenNVX {
//    VkIndirectCommandsTokenTypeNVX    tokenType;
//    VkBuffer                          buffer;
//    VkDeviceSize                      offset;
//} VkIndirectCommandsTokenNVX;
//
//typedef struct VkIndirectCommandsLayoutTokenNVX {
//    VkIndirectCommandsTokenTypeNVX    tokenType;
//    uint32_t                          bindingUnit;
//    uint32_t                          dynamicCount;
//    uint32_t                          divisor;
//} VkIndirectCommandsLayoutTokenNVX;
//
//typedef struct VkIndirectCommandsLayoutCreateInfoNVX {
//    VkStructureType                            sType;
//    const void*                                pNext;
//    VkPipelineBindPoint                        pipelineBindPoint;
//    VkIndirectCommandsLayoutUsageFlagsNVX      flags;
//    uint32_t                                   tokenCount;
//    const VkIndirectCommandsLayoutTokenNVX*    pTokens;
//} VkIndirectCommandsLayoutCreateInfoNVX;
//
//typedef struct VkCmdProcessCommandsInfoNVX {
//    VkStructureType                      sType;
//    const void*                          pNext;
//    VkObjectTableNVX                     objectTable;
//    VkIndirectCommandsLayoutNVX          indirectCommandsLayout;
//    uint32_t                             indirectCommandsTokenCount;
//    const VkIndirectCommandsTokenNVX*    pIndirectCommandsTokens;
//    uint32_t                             maxSequencesCount;
//    VkCommandBuffer                      targetCommandBuffer;
//    VkBuffer                             sequencesCountBuffer;
//    VkDeviceSize                         sequencesCountOffset;
//    VkBuffer                             sequencesIndexBuffer;
//    VkDeviceSize                         sequencesIndexOffset;
//} VkCmdProcessCommandsInfoNVX;
//
//typedef struct VkCmdReserveSpaceForCommandsInfoNVX {
//    VkStructureType                sType;
//    const void*                    pNext;
//    VkObjectTableNVX               objectTable;
//    VkIndirectCommandsLayoutNVX    indirectCommandsLayout;
//    uint32_t                       maxSequencesCount;
//} VkCmdReserveSpaceForCommandsInfoNVX;
//
//typedef struct VkObjectTableCreateInfoNVX {
//    VkStructureType                      sType;
//    const void*                          pNext;
//    uint32_t                             objectCount;
//    const VkObjectEntryTypeNVX*          pObjectEntryTypes;
//    const uint32_t*                      pObjectEntryCounts;
//    const VkObjectEntryUsageFlagsNVX*    pObjectEntryUsageFlags;
//    uint32_t                             maxUniformBuffersPerDescriptor;
//    uint32_t                             maxStorageBuffersPerDescriptor;
//    uint32_t                             maxStorageImagesPerDescriptor;
//    uint32_t                             maxSampledImagesPerDescriptor;
//    uint32_t                             maxPipelineLayouts;
//} VkObjectTableCreateInfoNVX;
//
//typedef struct VkObjectTableEntryNVX {
//    VkObjectEntryTypeNVX          type;
//    VkObjectEntryUsageFlagsNVX    flags;
//} VkObjectTableEntryNVX;
//
//typedef struct VkObjectTablePipelineEntryNVX {
//    VkObjectEntryTypeNVX          type;
//    VkObjectEntryUsageFlagsNVX    flags;
//    VkPipeline                    pipeline;
//} VkObjectTablePipelineEntryNVX;
//
//typedef struct VkObjectTableDescriptorSetEntryNVX {
//    VkObjectEntryTypeNVX          type;
//    VkObjectEntryUsageFlagsNVX    flags;
//    VkPipelineLayout              pipelineLayout;
//    VkDescriptorSet               descriptorSet;
//} VkObjectTableDescriptorSetEntryNVX;
//
//typedef struct VkObjectTableVertexBufferEntryNVX {
//    VkObjectEntryTypeNVX          type;
//    VkObjectEntryUsageFlagsNVX    flags;
//    VkBuffer                      buffer;
//} VkObjectTableVertexBufferEntryNVX;
//
//typedef struct VkObjectTableIndexBufferEntryNVX {
//    VkObjectEntryTypeNVX          type;
//    VkObjectEntryUsageFlagsNVX    flags;
//    VkBuffer                      buffer;
//    VkIndexType                   indexType;
//} VkObjectTableIndexBufferEntryNVX;
//
//typedef struct VkObjectTablePushConstantEntryNVX {
//    VkObjectEntryTypeNVX          type;
//    VkObjectEntryUsageFlagsNVX    flags;
//    VkPipelineLayout              pipelineLayout;
//    VkShaderStageFlags            stageFlags;
//} VkObjectTablePushConstantEntryNVX;
//
//
//typedef void (VKAPI_PTR *PFN_vkCmdProcessCommandsNVX)(VkCommandBuffer commandBuffer, const VkCmdProcessCommandsInfoNVX* pProcessCommandsInfo);
//typedef void (VKAPI_PTR *PFN_vkCmdReserveSpaceForCommandsNVX)(VkCommandBuffer commandBuffer, const VkCmdReserveSpaceForCommandsInfoNVX* pReserveSpaceInfo);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateIndirectCommandsLayoutNVX)(VkDevice device, const VkIndirectCommandsLayoutCreateInfoNVX* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkIndirectCommandsLayoutNVX* pIndirectCommandsLayout);
//typedef void (VKAPI_PTR *PFN_vkDestroyIndirectCommandsLayoutNVX)(VkDevice device, VkIndirectCommandsLayoutNVX indirectCommandsLayout, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateObjectTableNVX)(VkDevice device, const VkObjectTableCreateInfoNVX* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkObjectTableNVX* pObjectTable);
//typedef void (VKAPI_PTR *PFN_vkDestroyObjectTableNVX)(VkDevice device, VkObjectTableNVX objectTable, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkRegisterObjectsNVX)(VkDevice device, VkObjectTableNVX objectTable, uint32_t objectCount, const VkObjectTableEntryNVX* const*    ppObjectTableEntries, const uint32_t* pObjectIndices);
//typedef VkResult (VKAPI_PTR *PFN_vkUnregisterObjectsNVX)(VkDevice device, VkObjectTableNVX objectTable, uint32_t objectCount, const VkObjectEntryTypeNVX* pObjectEntryTypes, const uint32_t* pObjectIndices);
//typedef void (VKAPI_PTR *PFN_vkGetPhysicalDeviceGeneratedCommandsPropertiesNVX)(VkPhysicalDevice physicalDevice, VkDeviceGeneratedCommandsFeaturesNVX* pFeatures, VkDeviceGeneratedCommandsLimitsNVX* pLimits);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR void VKAPI_CALL vkCmdProcessCommandsNVX(
//VkCommandBuffer                             commandBuffer,
//const VkCmdProcessCommandsInfoNVX*          pProcessCommandsInfo);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdReserveSpaceForCommandsNVX(
//VkCommandBuffer                             commandBuffer,
//const VkCmdReserveSpaceForCommandsInfoNVX*  pReserveSpaceInfo);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateIndirectCommandsLayoutNVX(
//VkDevice                                    device,
//const VkIndirectCommandsLayoutCreateInfoNVX* pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkIndirectCommandsLayoutNVX*                pIndirectCommandsLayout);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyIndirectCommandsLayoutNVX(
//VkDevice                                    device,
//VkIndirectCommandsLayoutNVX                 indirectCommandsLayout,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateObjectTableNVX(
//VkDevice                                    device,
//const VkObjectTableCreateInfoNVX*           pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkObjectTableNVX*                           pObjectTable);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyObjectTableNVX(
//VkDevice                                    device,
//VkObjectTableNVX                            objectTable,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkRegisterObjectsNVX(
//VkDevice                                    device,
//VkObjectTableNVX                            objectTable,
//uint32_t                                    objectCount,
//const VkObjectTableEntryNVX* const*         ppObjectTableEntries,
//const uint32_t*                             pObjectIndices);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkUnregisterObjectsNVX(
//VkDevice                                    device,
//VkObjectTableNVX                            objectTable,
//uint32_t                                    objectCount,
//const VkObjectEntryTypeNVX*                 pObjectEntryTypes,
//const uint32_t*                             pObjectIndices);
//
//VKAPI_ATTR void VKAPI_CALL vkGetPhysicalDeviceGeneratedCommandsPropertiesNVX(
//VkPhysicalDevice                            physicalDevice,
//VkDeviceGeneratedCommandsFeaturesNVX*       pFeatures,
//VkDeviceGeneratedCommandsLimitsNVX*         pLimits);
//#endif
//
//#define VK_NV_clip_space_w_scaling 1
//#define VK_NV_CLIP_SPACE_W_SCALING_SPEC_VERSION 1
//#define VK_NV_CLIP_SPACE_W_SCALING_EXTENSION_NAME "VK_NV_clip_space_w_scaling"
//
//typedef struct VkViewportWScalingNV {
//    float    xcoeff;
//    float    ycoeff;
//} VkViewportWScalingNV;
//
//typedef struct VkPipelineViewportWScalingStateCreateInfoNV {
//    VkStructureType                sType;
//    const void*                    pNext;
//    VkBool32                       viewportWScalingEnable;
//    uint32_t                       viewportCount;
//    const VkViewportWScalingNV*    pViewportWScalings;
//} VkPipelineViewportWScalingStateCreateInfoNV;
//
//
//typedef void (VKAPI_PTR *PFN_vkCmdSetViewportWScalingNV)(VkCommandBuffer commandBuffer, uint32_t firstViewport, uint32_t viewportCount, const VkViewportWScalingNV* pViewportWScalings);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR void VKAPI_CALL vkCmdSetViewportWScalingNV(
//VkCommandBuffer                             commandBuffer,
//uint32_t                                    firstViewport,
//uint32_t                                    viewportCount,
//const VkViewportWScalingNV*                 pViewportWScalings);
//#endif
//
//#define VK_EXT_direct_mode_display 1
//#define VK_EXT_DIRECT_MODE_DISPLAY_SPEC_VERSION 1
//#define VK_EXT_DIRECT_MODE_DISPLAY_EXTENSION_NAME "VK_EXT_direct_mode_display"
//
//typedef VkResult (VKAPI_PTR *PFN_vkReleaseDisplayEXT)(VkPhysicalDevice physicalDevice, VkDisplayKHR display);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkReleaseDisplayEXT(
//VkPhysicalDevice                            physicalDevice,
//VkDisplayKHR                                display);
//#endif
//
//#ifdef VK_USE_PLATFORM_XLIB_XRANDR_EXT
//#define VK_EXT_acquire_xlib_display 1
//#include <X11/extensions/Xrandr.h>
//
//#define VK_EXT_ACQUIRE_XLIB_DISPLAY_SPEC_VERSION 1
//#define VK_EXT_ACQUIRE_XLIB_DISPLAY_EXTENSION_NAME "VK_EXT_acquire_xlib_display"
//
//typedef VkResult (VKAPI_PTR *PFN_vkAcquireXlibDisplayEXT)(VkPhysicalDevice physicalDevice, Display* dpy, VkDisplayKHR display);
//typedef VkResult (VKAPI_PTR *PFN_vkGetRandROutputDisplayEXT)(VkPhysicalDevice physicalDevice, Display* dpy, RROutput rrOutput, VkDisplayKHR* pDisplay);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkAcquireXlibDisplayEXT(
//VkPhysicalDevice                            physicalDevice,
//Display*                                    dpy,
//VkDisplayKHR                                display);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetRandROutputDisplayEXT(
//VkPhysicalDevice                            physicalDevice,
//Display*                                    dpy,
//RROutput                                    rrOutput,
//VkDisplayKHR*                               pDisplay);
//#endif
//#endif /* VK_USE_PLATFORM_XLIB_XRANDR_EXT */
//
//#define VK_EXT_display_surface_counter 1
//#define VK_EXT_DISPLAY_SURFACE_COUNTER_SPEC_VERSION 1
//#define VK_EXT_DISPLAY_SURFACE_COUNTER_EXTENSION_NAME "VK_EXT_display_surface_counter"
//#define SURFACE_CAPABILITIES2_EXT SURFACE_CAPABILITIES_2_EXT
//
//
//typedef enum VkSurfaceCounterFlagBitsEXT {
//    VK_SURFACE_COUNTER_VBLANK_EXT = 0x00000001,
//    VK_SURFACE_COUNTER_FLAG_BITS_MAX_ENUM_EXT = 0x7FFFFFFF
//} VkSurfaceCounterFlagBitsEXT;
//typedef VkFlags VkSurfaceCounterFlagsEXT;
//
//typedef struct VkSurfaceCapabilities2EXT {
//    VkStructureType                  sType;
//    void*                            pNext;
//    uint32_t                         minImageCount;
//    uint32_t                         maxImageCount;
//    VkExtent2D                       currentExtent;
//    VkExtent2D                       minImageExtent;
//    VkExtent2D                       maxImageExtent;
//    uint32_t                         maxImageArrayLayers;
//    VkSurfaceTransformFlagsKHR       supportedTransforms;
//    VkSurfaceTransformFlagBitsKHR    currentTransform;
//    VkCompositeAlphaFlagsKHR         supportedCompositeAlpha;
//    VkImageUsageFlags                supportedUsageFlags;
//    VkSurfaceCounterFlagsEXT         supportedSurfaceCounters;
//} VkSurfaceCapabilities2EXT;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkGetPhysicalDeviceSurfaceCapabilities2EXT)(VkPhysicalDevice physicalDevice, VkSurfaceKHR surface, VkSurfaceCapabilities2EXT* pSurfaceCapabilities);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkGetPhysicalDeviceSurfaceCapabilities2EXT(
//VkPhysicalDevice                            physicalDevice,
//VkSurfaceKHR                                surface,
//VkSurfaceCapabilities2EXT*                  pSurfaceCapabilities);
//#endif
//
//#define VK_EXT_display_control 1
//#define VK_EXT_DISPLAY_CONTROL_SPEC_VERSION 1
//#define VK_EXT_DISPLAY_CONTROL_EXTENSION_NAME "VK_EXT_display_control"
//
//
//typedef enum VkDisplayPowerStateEXT {
//    VK_DISPLAY_POWER_STATE_OFF_EXT = 0,
//    VK_DISPLAY_POWER_STATE_SUSPEND_EXT = 1,
//    VK_DISPLAY_POWER_STATE_ON_EXT = 2,
//    VK_DISPLAY_POWER_STATE_BEGIN_RANGE_EXT = VK_DISPLAY_POWER_STATE_OFF_EXT,
//    VK_DISPLAY_POWER_STATE_END_RANGE_EXT = VK_DISPLAY_POWER_STATE_ON_EXT,
//    VK_DISPLAY_POWER_STATE_RANGE_SIZE_EXT = (VK_DISPLAY_POWER_STATE_ON_EXT - VK_DISPLAY_POWER_STATE_OFF_EXT + 1),
//    VK_DISPLAY_POWER_STATE_MAX_ENUM_EXT = 0x7FFFFFFF
//} VkDisplayPowerStateEXT;
//
//typedef enum VkDeviceEventTypeEXT {
//    VK_DEVICE_EVENT_TYPE_DISPLAY_HOTPLUG_EXT = 0,
//    VK_DEVICE_EVENT_TYPE_BEGIN_RANGE_EXT = VK_DEVICE_EVENT_TYPE_DISPLAY_HOTPLUG_EXT,
//    VK_DEVICE_EVENT_TYPE_END_RANGE_EXT = VK_DEVICE_EVENT_TYPE_DISPLAY_HOTPLUG_EXT,
//    VK_DEVICE_EVENT_TYPE_RANGE_SIZE_EXT = (VK_DEVICE_EVENT_TYPE_DISPLAY_HOTPLUG_EXT - VK_DEVICE_EVENT_TYPE_DISPLAY_HOTPLUG_EXT + 1),
//    VK_DEVICE_EVENT_TYPE_MAX_ENUM_EXT = 0x7FFFFFFF
//} VkDeviceEventTypeEXT;
//
//typedef enum VkDisplayEventTypeEXT {
//    VK_DISPLAY_EVENT_TYPE_FIRST_PIXEL_OUT_EXT = 0,
//    VK_DISPLAY_EVENT_TYPE_BEGIN_RANGE_EXT = VK_DISPLAY_EVENT_TYPE_FIRST_PIXEL_OUT_EXT,
//    VK_DISPLAY_EVENT_TYPE_END_RANGE_EXT = VK_DISPLAY_EVENT_TYPE_FIRST_PIXEL_OUT_EXT,
//    VK_DISPLAY_EVENT_TYPE_RANGE_SIZE_EXT = (VK_DISPLAY_EVENT_TYPE_FIRST_PIXEL_OUT_EXT - VK_DISPLAY_EVENT_TYPE_FIRST_PIXEL_OUT_EXT + 1),
//    VK_DISPLAY_EVENT_TYPE_MAX_ENUM_EXT = 0x7FFFFFFF
//} VkDisplayEventTypeEXT;
//
//typedef struct VkDisplayPowerInfoEXT {
//    VkStructureType           sType;
//    const void*               pNext;
//    VkDisplayPowerStateEXT    powerState;
//} VkDisplayPowerInfoEXT;
//
//typedef struct VkDeviceEventInfoEXT {
//    VkStructureType         sType;
//    const void*             pNext;
//    VkDeviceEventTypeEXT    deviceEvent;
//} VkDeviceEventInfoEXT;
//
//typedef struct VkDisplayEventInfoEXT {
//    VkStructureType          sType;
//    const void*              pNext;
//    VkDisplayEventTypeEXT    displayEvent;
//} VkDisplayEventInfoEXT;
//
//typedef struct VkSwapchainCounterCreateInfoEXT {
//    VkStructureType             sType;
//    const void*                 pNext;
//    VkSurfaceCounterFlagsEXT    surfaceCounters;
//} VkSwapchainCounterCreateInfoEXT;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkDisplayPowerControlEXT)(VkDevice device, VkDisplayKHR display, const VkDisplayPowerInfoEXT* pDisplayPowerInfo);
//typedef VkResult (VKAPI_PTR *PFN_vkRegisterDeviceEventEXT)(VkDevice device, const VkDeviceEventInfoEXT* pDeviceEventInfo, const VkAllocationCallbacks* pAllocator, VkFence* pFence);
//typedef VkResult (VKAPI_PTR *PFN_vkRegisterDisplayEventEXT)(VkDevice device, VkDisplayKHR display, const VkDisplayEventInfoEXT* pDisplayEventInfo, const VkAllocationCallbacks* pAllocator, VkFence* pFence);
//typedef VkResult (VKAPI_PTR *PFN_vkGetSwapchainCounterEXT)(VkDevice device, VkSwapchainKHR swapchain, VkSurfaceCounterFlagBitsEXT counter, uint64_t* pCounterValue);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkDisplayPowerControlEXT(
//VkDevice                                    device,
//VkDisplayKHR                                display,
//const VkDisplayPowerInfoEXT*                pDisplayPowerInfo);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkRegisterDeviceEventEXT(
//VkDevice                                    device,
//const VkDeviceEventInfoEXT*                 pDeviceEventInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkFence*                                    pFence);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkRegisterDisplayEventEXT(
//VkDevice                                    device,
//VkDisplayKHR                                display,
//const VkDisplayEventInfoEXT*                pDisplayEventInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkFence*                                    pFence);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetSwapchainCounterEXT(
//VkDevice                                    device,
//VkSwapchainKHR                              swapchain,
//VkSurfaceCounterFlagBitsEXT                 counter,
//uint64_t*                                   pCounterValue);
//#endif
//
//#define VK_GOOGLE_display_timing 1
//#define VK_GOOGLE_DISPLAY_TIMING_SPEC_VERSION 1
//#define VK_GOOGLE_DISPLAY_TIMING_EXTENSION_NAME "VK_GOOGLE_display_timing"
//
//typedef struct VkRefreshCycleDurationGOOGLE {
//    uint64_t    refreshDuration;
//} VkRefreshCycleDurationGOOGLE;
//
//typedef struct VkPastPresentationTimingGOOGLE {
//    uint32_t    presentID;
//    uint64_t    desiredPresentTime;
//    uint64_t    actualPresentTime;
//    uint64_t    earliestPresentTime;
//    uint64_t    presentMargin;
//} VkPastPresentationTimingGOOGLE;
//
//typedef struct VkPresentTimeGOOGLE {
//    uint32_t    presentID;
//    uint64_t    desiredPresentTime;
//} VkPresentTimeGOOGLE;
//
//typedef struct VkPresentTimesInfoGOOGLE {
//    VkStructureType               sType;
//    const void*                   pNext;
//    uint32_t                      swapchainCount;
//    const VkPresentTimeGOOGLE*    pTimes;
//} VkPresentTimesInfoGOOGLE;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkGetRefreshCycleDurationGOOGLE)(VkDevice device, VkSwapchainKHR swapchain, VkRefreshCycleDurationGOOGLE* pDisplayTimingProperties);
//typedef VkResult (VKAPI_PTR *PFN_vkGetPastPresentationTimingGOOGLE)(VkDevice device, VkSwapchainKHR swapchain, uint32_t* pPresentationTimingCount, VkPastPresentationTimingGOOGLE* pPresentationTimings);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkGetRefreshCycleDurationGOOGLE(
//VkDevice                                    device,
//VkSwapchainKHR                              swapchain,
//VkRefreshCycleDurationGOOGLE*               pDisplayTimingProperties);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetPastPresentationTimingGOOGLE(
//VkDevice                                    device,
//VkSwapchainKHR                              swapchain,
//uint32_t*                                   pPresentationTimingCount,
//VkPastPresentationTimingGOOGLE*             pPresentationTimings);
//#endif
//
//#define VK_NV_sample_mask_override_coverage 1
//#define VK_NV_SAMPLE_MASK_OVERRIDE_COVERAGE_SPEC_VERSION 1
//#define VK_NV_SAMPLE_MASK_OVERRIDE_COVERAGE_EXTENSION_NAME "VK_NV_sample_mask_override_coverage"
//
//
//#define VK_NV_geometry_shader_passthrough 1
//#define VK_NV_GEOMETRY_SHADER_PASSTHROUGH_SPEC_VERSION 1
//#define VK_NV_GEOMETRY_SHADER_PASSTHROUGH_EXTENSION_NAME "VK_NV_geometry_shader_passthrough"
//
//
//#define VK_NV_viewport_array2 1
//#define VK_NV_VIEWPORT_ARRAY2_SPEC_VERSION 1
//#define VK_NV_VIEWPORT_ARRAY2_EXTENSION_NAME "VK_NV_viewport_array2"
//
//
//#define VK_NVX_multiview_per_view_attributes 1
//#define VK_NVX_MULTIVIEW_PER_VIEW_ATTRIBUTES_SPEC_VERSION 1
//#define VK_NVX_MULTIVIEW_PER_VIEW_ATTRIBUTES_EXTENSION_NAME "VK_NVX_multiview_per_view_attributes"
//
//typedef struct VkPhysicalDeviceMultiviewPerViewAttributesPropertiesNVX {
//    VkStructureType    sType;
//    void*              pNext;
//    VkBool32           perViewPositionAllComponents;
//} VkPhysicalDeviceMultiviewPerViewAttributesPropertiesNVX;
//
//
//
//#define VK_NV_viewport_swizzle 1
//#define VK_NV_VIEWPORT_SWIZZLE_SPEC_VERSION 1
//#define VK_NV_VIEWPORT_SWIZZLE_EXTENSION_NAME "VK_NV_viewport_swizzle"
//
//
//typedef enum VkViewportCoordinateSwizzleNV {
//    VK_VIEWPORT_COORDINATE_SWIZZLE_POSITIVE_X_NV = 0,
//    VK_VIEWPORT_COORDINATE_SWIZZLE_NEGATIVE_X_NV = 1,
//    VK_VIEWPORT_COORDINATE_SWIZZLE_POSITIVE_Y_NV = 2,
//    VK_VIEWPORT_COORDINATE_SWIZZLE_NEGATIVE_Y_NV = 3,
//    VK_VIEWPORT_COORDINATE_SWIZZLE_POSITIVE_Z_NV = 4,
//    VK_VIEWPORT_COORDINATE_SWIZZLE_NEGATIVE_Z_NV = 5,
//    VK_VIEWPORT_COORDINATE_SWIZZLE_POSITIVE_W_NV = 6,
//    VK_VIEWPORT_COORDINATE_SWIZZLE_NEGATIVE_W_NV = 7,
//    VK_VIEWPORT_COORDINATE_SWIZZLE_BEGIN_RANGE_NV = VK_VIEWPORT_COORDINATE_SWIZZLE_POSITIVE_X_NV,
//    VK_VIEWPORT_COORDINATE_SWIZZLE_END_RANGE_NV = VK_VIEWPORT_COORDINATE_SWIZZLE_NEGATIVE_W_NV,
//    VK_VIEWPORT_COORDINATE_SWIZZLE_RANGE_SIZE_NV = (VK_VIEWPORT_COORDINATE_SWIZZLE_NEGATIVE_W_NV - VK_VIEWPORT_COORDINATE_SWIZZLE_POSITIVE_X_NV + 1),
//    VK_VIEWPORT_COORDINATE_SWIZZLE_MAX_ENUM_NV = 0x7FFFFFFF
//} VkViewportCoordinateSwizzleNV;
//
//typedef VkFlags VkPipelineViewportSwizzleStateCreateFlagsNV;
//
//typedef struct VkViewportSwizzleNV {
//    VkViewportCoordinateSwizzleNV    x;
//    VkViewportCoordinateSwizzleNV    y;
//    VkViewportCoordinateSwizzleNV    z;
//    VkViewportCoordinateSwizzleNV    w;
//} VkViewportSwizzleNV;
//
//typedef struct VkPipelineViewportSwizzleStateCreateInfoNV {
//    VkStructureType                                sType;
//    const void*                                    pNext;
//    VkPipelineViewportSwizzleStateCreateFlagsNV    flags;
//    uint32_t                                       viewportCount;
//    const VkViewportSwizzleNV*                     pViewportSwizzles;
//} VkPipelineViewportSwizzleStateCreateInfoNV;
//
//
//
//#define VK_EXT_discard_rectangles 1
//#define VK_EXT_DISCARD_RECTANGLES_SPEC_VERSION 1
//#define VK_EXT_DISCARD_RECTANGLES_EXTENSION_NAME "VK_EXT_discard_rectangles"
//
//
//typedef enum VkDiscardRectangleModeEXT {
//    VK_DISCARD_RECTANGLE_MODE_INCLUSIVE_EXT = 0,
//    VK_DISCARD_RECTANGLE_MODE_EXCLUSIVE_EXT = 1,
//    VK_DISCARD_RECTANGLE_MODE_BEGIN_RANGE_EXT = VK_DISCARD_RECTANGLE_MODE_INCLUSIVE_EXT,
//    VK_DISCARD_RECTANGLE_MODE_END_RANGE_EXT = VK_DISCARD_RECTANGLE_MODE_EXCLUSIVE_EXT,
//    VK_DISCARD_RECTANGLE_MODE_RANGE_SIZE_EXT = (VK_DISCARD_RECTANGLE_MODE_EXCLUSIVE_EXT - VK_DISCARD_RECTANGLE_MODE_INCLUSIVE_EXT + 1),
//    VK_DISCARD_RECTANGLE_MODE_MAX_ENUM_EXT = 0x7FFFFFFF
//} VkDiscardRectangleModeEXT;
//
//typedef VkFlags VkPipelineDiscardRectangleStateCreateFlagsEXT;
//
//typedef struct VkPhysicalDeviceDiscardRectanglePropertiesEXT {
//    VkStructureType    sType;
//    void*              pNext;
//    uint32_t           maxDiscardRectangles;
//} VkPhysicalDeviceDiscardRectanglePropertiesEXT;
//
//typedef struct VkPipelineDiscardRectangleStateCreateInfoEXT {
//    VkStructureType                                  sType;
//    const void*                                      pNext;
//    VkPipelineDiscardRectangleStateCreateFlagsEXT    flags;
//    VkDiscardRectangleModeEXT                        discardRectangleMode;
//    uint32_t                                         discardRectangleCount;
//    const VkRect2D*                                  pDiscardRectangles;
//} VkPipelineDiscardRectangleStateCreateInfoEXT;
//
//
//typedef void (VKAPI_PTR *PFN_vkCmdSetDiscardRectangleEXT)(VkCommandBuffer commandBuffer, uint32_t firstDiscardRectangle, uint32_t discardRectangleCount, const VkRect2D* pDiscardRectangles);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR void VKAPI_CALL vkCmdSetDiscardRectangleEXT(
//VkCommandBuffer                             commandBuffer,
//uint32_t                                    firstDiscardRectangle,
//uint32_t                                    discardRectangleCount,
//const VkRect2D*                             pDiscardRectangles);
//#endif
//
//#define VK_EXT_conservative_rasterization 1
//#define VK_EXT_CONSERVATIVE_RASTERIZATION_SPEC_VERSION 1
//#define VK_EXT_CONSERVATIVE_RASTERIZATION_EXTENSION_NAME "VK_EXT_conservative_rasterization"
//
//
//typedef enum VkConservativeRasterizationModeEXT {
//    VK_CONSERVATIVE_RASTERIZATION_MODE_DISABLED_EXT = 0,
//    VK_CONSERVATIVE_RASTERIZATION_MODE_OVERESTIMATE_EXT = 1,
//    VK_CONSERVATIVE_RASTERIZATION_MODE_UNDERESTIMATE_EXT = 2,
//    VK_CONSERVATIVE_RASTERIZATION_MODE_BEGIN_RANGE_EXT = VK_CONSERVATIVE_RASTERIZATION_MODE_DISABLED_EXT,
//    VK_CONSERVATIVE_RASTERIZATION_MODE_END_RANGE_EXT = VK_CONSERVATIVE_RASTERIZATION_MODE_UNDERESTIMATE_EXT,
//    VK_CONSERVATIVE_RASTERIZATION_MODE_RANGE_SIZE_EXT = (VK_CONSERVATIVE_RASTERIZATION_MODE_UNDERESTIMATE_EXT - VK_CONSERVATIVE_RASTERIZATION_MODE_DISABLED_EXT + 1),
//    VK_CONSERVATIVE_RASTERIZATION_MODE_MAX_ENUM_EXT = 0x7FFFFFFF
//} VkConservativeRasterizationModeEXT;
//
//typedef VkFlags VkPipelineRasterizationConservativeStateCreateFlagsEXT;
//
//typedef struct VkPhysicalDeviceConservativeRasterizationPropertiesEXT {
//    VkStructureType    sType;
//    void*              pNext;
//    float              primitiveOverestimationSize;
//    float              maxExtraPrimitiveOverestimationSize;
//    float              extraPrimitiveOverestimationSizeGranularity;
//    VkBool32           primitiveUnderestimation;
//    VkBool32           conservativePointAndLineRasterization;
//    VkBool32           degenerateTrianglesRasterized;
//    VkBool32           degenerateLinesRasterized;
//    VkBool32           fullyCoveredFragmentShaderInputVariable;
//    VkBool32           conservativeRasterizationPostDepthCoverage;
//} VkPhysicalDeviceConservativeRasterizationPropertiesEXT;
//
//typedef struct VkPipelineRasterizationConservativeStateCreateInfoEXT {
//    VkStructureType                                           sType;
//    const void*                                               pNext;
//    VkPipelineRasterizationConservativeStateCreateFlagsEXT    flags;
//    VkConservativeRasterizationModeEXT                        conservativeRasterizationMode;
//    float                                                     extraPrimitiveOverestimationSize;
//} VkPipelineRasterizationConservativeStateCreateInfoEXT;
//
//
//
//#define VK_EXT_swapchain_colorspace 1
//#define VK_EXT_SWAPCHAIN_COLOR_SPACE_SPEC_VERSION 3
//#define VK_EXT_SWAPCHAIN_COLOR_SPACE_EXTENSION_NAME "VK_EXT_swapchain_colorspace"
//
//
//#define VK_EXT_hdr_metadata 1
//#define VK_EXT_HDR_METADATA_SPEC_VERSION  1
//#define VK_EXT_HDR_METADATA_EXTENSION_NAME "VK_EXT_hdr_metadata"
//
//typedef struct VkXYColorEXT {
//    float    x;
//    float    y;
//} VkXYColorEXT;
//
//typedef struct VkHdrMetadataEXT {
//    VkStructureType    sType;
//    const void*        pNext;
//    VkXYColorEXT       displayPrimaryRed;
//    VkXYColorEXT       displayPrimaryGreen;
//    VkXYColorEXT       displayPrimaryBlue;
//    VkXYColorEXT       whitePoint;
//    float              maxLuminance;
//    float              minLuminance;
//    float              maxContentLightLevel;
//    float              maxFrameAverageLightLevel;
//} VkHdrMetadataEXT;
//
//
//typedef void (VKAPI_PTR *PFN_vkSetHdrMetadataEXT)(VkDevice device, uint32_t swapchainCount, const VkSwapchainKHR* pSwapchains, const VkHdrMetadataEXT* pMetadata);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR void VKAPI_CALL vkSetHdrMetadataEXT(
//VkDevice                                    device,
//uint32_t                                    swapchainCount,
//const VkSwapchainKHR*                       pSwapchains,
//const VkHdrMetadataEXT*                     pMetadata);
//#endif
//
//#ifdef VK_USE_PLATFORM_IOS_MVK
//#define VK_MVK_ios_surface 1
//#define VK_MVK_IOS_SURFACE_SPEC_VERSION   2
//#define VK_MVK_IOS_SURFACE_EXTENSION_NAME "VK_MVK_ios_surface"
//
//typedef VkFlags VkIOSSurfaceCreateFlagsMVK;
//
//typedef struct VkIOSSurfaceCreateInfoMVK {
//    VkStructureType               sType;
//    const void*                   pNext;
//    VkIOSSurfaceCreateFlagsMVK    flags;
//    const void*                   pView;
//} VkIOSSurfaceCreateInfoMVK;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkCreateIOSSurfaceMVK)(VkInstance instance, const VkIOSSurfaceCreateInfoMVK* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkSurfaceKHR* pSurface);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateIOSSurfaceMVK(
//VkInstance                                  instance,
//const VkIOSSurfaceCreateInfoMVK*            pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkSurfaceKHR*                               pSurface);
//#endif
//#endif /* VK_USE_PLATFORM_IOS_MVK */
//
//#ifdef VK_USE_PLATFORM_MACOS_MVK
//#define VK_MVK_macos_surface 1
//#define VK_MVK_MACOS_SURFACE_SPEC_VERSION 2
//#define VK_MVK_MACOS_SURFACE_EXTENSION_NAME "VK_MVK_macos_surface"
//
//typedef VkFlags VkMacOSSurfaceCreateFlagsMVK;
//
//typedef struct VkMacOSSurfaceCreateInfoMVK {
//    VkStructureType                 sType;
//    const void*                     pNext;
//    VkMacOSSurfaceCreateFlagsMVK    flags;
//    const void*                     pView;
//} VkMacOSSurfaceCreateInfoMVK;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkCreateMacOSSurfaceMVK)(VkInstance instance, const VkMacOSSurfaceCreateInfoMVK* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkSurfaceKHR* pSurface);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateMacOSSurfaceMVK(
//VkInstance                                  instance,
//const VkMacOSSurfaceCreateInfoMVK*          pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkSurfaceKHR*                               pSurface);
//#endif
//#endif /* VK_USE_PLATFORM_MACOS_MVK */
//
//#define VK_EXT_external_memory_dma_buf 1
//#define VK_EXT_EXTERNAL_MEMORY_DMA_BUF_SPEC_VERSION 1
//#define VK_EXT_EXTERNAL_MEMORY_DMA_BUF_EXTENSION_NAME "VK_EXT_external_memory_dma_buf"
//
//
//#define VK_EXT_queue_family_foreign 1
//#define VK_EXT_QUEUE_FAMILY_FOREIGN_SPEC_VERSION 1
//#define VK_EXT_QUEUE_FAMILY_FOREIGN_EXTENSION_NAME "VK_EXT_queue_family_foreign"
//#define VK_QUEUE_FAMILY_FOREIGN_EXT       (~0U-2)
//
//
//#define VK_EXT_sampler_filter_minmax 1
//#define VK_EXT_SAMPLER_FILTER_MINMAX_SPEC_VERSION 1
//#define VK_EXT_SAMPLER_FILTER_MINMAX_EXTENSION_NAME "VK_EXT_sampler_filter_minmax"
//
//
//typedef enum VkSamplerReductionModeEXT {
//    VK_SAMPLER_REDUCTION_MODE_WEIGHTED_AVERAGE_EXT = 0,
//    VK_SAMPLER_REDUCTION_MODE_MIN_EXT = 1,
//    VK_SAMPLER_REDUCTION_MODE_MAX_EXT = 2,
//    VK_SAMPLER_REDUCTION_MODE_BEGIN_RANGE_EXT = VK_SAMPLER_REDUCTION_MODE_WEIGHTED_AVERAGE_EXT,
//    VK_SAMPLER_REDUCTION_MODE_END_RANGE_EXT = VK_SAMPLER_REDUCTION_MODE_MAX_EXT,
//    VK_SAMPLER_REDUCTION_MODE_RANGE_SIZE_EXT = (VK_SAMPLER_REDUCTION_MODE_MAX_EXT - VK_SAMPLER_REDUCTION_MODE_WEIGHTED_AVERAGE_EXT + 1),
//    VK_SAMPLER_REDUCTION_MODE_MAX_ENUM_EXT = 0x7FFFFFFF
//} VkSamplerReductionModeEXT;
//
//typedef struct VkSamplerReductionModeCreateInfoEXT {
//    VkStructureType              sType;
//    const void*                  pNext;
//    VkSamplerReductionModeEXT    reductionMode;
//} VkSamplerReductionModeCreateInfoEXT;
//
//typedef struct VkPhysicalDeviceSamplerFilterMinmaxPropertiesEXT {
//    VkStructureType    sType;
//    void*              pNext;
//    VkBool32           filterMinmaxSingleComponentFormats;
//    VkBool32           filterMinmaxImageComponentMapping;
//} VkPhysicalDeviceSamplerFilterMinmaxPropertiesEXT;
//
//
//
//#define VK_AMD_gpu_shader_int16 1
//#define VK_AMD_GPU_SHADER_INT16_SPEC_VERSION 1
//#define VK_AMD_GPU_SHADER_INT16_EXTENSION_NAME "VK_AMD_gpu_shader_int16"
//
//
//#define VK_AMD_mixed_attachment_samples 1
//#define VK_AMD_MIXED_ATTACHMENT_SAMPLES_SPEC_VERSION 1
//#define VK_AMD_MIXED_ATTACHMENT_SAMPLES_EXTENSION_NAME "VK_AMD_mixed_attachment_samples"
//
//
//#define VK_AMD_shader_fragment_mask 1
//#define VK_AMD_SHADER_FRAGMENT_MASK_SPEC_VERSION 1
//#define VK_AMD_SHADER_FRAGMENT_MASK_EXTENSION_NAME "VK_AMD_shader_fragment_mask"
//
//
//#define VK_EXT_shader_stencil_export 1
//#define VK_EXT_SHADER_STENCIL_EXPORT_SPEC_VERSION 1
//#define VK_EXT_SHADER_STENCIL_EXPORT_EXTENSION_NAME "VK_EXT_shader_stencil_export"
//
//
//#define VK_EXT_sample_locations 1
//#define VK_EXT_SAMPLE_LOCATIONS_SPEC_VERSION 1
//#define VK_EXT_SAMPLE_LOCATIONS_EXTENSION_NAME "VK_EXT_sample_locations"
//
//typedef struct VkSampleLocationEXT {
//    float    x;
//    float    y;
//} VkSampleLocationEXT;
//
//typedef struct VkSampleLocationsInfoEXT {
//    VkStructureType               sType;
//    const void*                   pNext;
//    VkSampleCountFlagBits         sampleLocationsPerPixel;
//    VkExtent2D                    sampleLocationGridSize;
//    uint32_t                      sampleLocationsCount;
//    const VkSampleLocationEXT*    pSampleLocations;
//} VkSampleLocationsInfoEXT;
//
//typedef struct VkAttachmentSampleLocationsEXT {
//    uint32_t                    attachmentIndex;
//    VkSampleLocationsInfoEXT    sampleLocationsInfo;
//} VkAttachmentSampleLocationsEXT;
//
//typedef struct VkSubpassSampleLocationsEXT {
//    uint32_t                    subpassIndex;
//    VkSampleLocationsInfoEXT    sampleLocationsInfo;
//} VkSubpassSampleLocationsEXT;
//
//typedef struct VkRenderPassSampleLocationsBeginInfoEXT {
//    VkStructureType                          sType;
//    const void*                              pNext;
//    uint32_t                                 attachmentInitialSampleLocationsCount;
//    const VkAttachmentSampleLocationsEXT*    pAttachmentInitialSampleLocations;
//    uint32_t                                 postSubpassSampleLocationsCount;
//    const VkSubpassSampleLocationsEXT*       pPostSubpassSampleLocations;
//} VkRenderPassSampleLocationsBeginInfoEXT;
//
//typedef struct VkPipelineSampleLocationsStateCreateInfoEXT {
//    VkStructureType             sType;
//    const void*                 pNext;
//    VkBool32                    sampleLocationsEnable;
//    VkSampleLocationsInfoEXT    sampleLocationsInfo;
//} VkPipelineSampleLocationsStateCreateInfoEXT;
//
//typedef struct VkPhysicalDeviceSampleLocationsPropertiesEXT {
//    VkStructureType       sType;
//    void*                 pNext;
//    VkSampleCountFlags    sampleLocationSampleCounts;
//    VkExtent2D            maxSampleLocationGridSize;
//    float                 sampleLocationCoordinateRange[2];
//    uint32_t              sampleLocationSubPixelBits;
//    VkBool32              variableSampleLocations;
//} VkPhysicalDeviceSampleLocationsPropertiesEXT;
//
//typedef struct VkMultisamplePropertiesEXT {
//    VkStructureType    sType;
//    void*              pNext;
//    VkExtent2D         maxSampleLocationGridSize;
//} VkMultisamplePropertiesEXT;
//
//
//typedef void (VKAPI_PTR *PFN_vkCmdSetSampleLocationsEXT)(VkCommandBuffer commandBuffer, const VkSampleLocationsInfoEXT* pSampleLocationsInfo);
//typedef void (VKAPI_PTR *PFN_vkGetPhysicalDeviceMultisamplePropertiesEXT)(VkPhysicalDevice physicalDevice, VkSampleCountFlagBits samples, VkMultisamplePropertiesEXT* pMultisampleProperties);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR void VKAPI_CALL vkCmdSetSampleLocationsEXT(
//VkCommandBuffer                             commandBuffer,
//const VkSampleLocationsInfoEXT*             pSampleLocationsInfo);
//
//VKAPI_ATTR void VKAPI_CALL vkGetPhysicalDeviceMultisamplePropertiesEXT(
//VkPhysicalDevice                            physicalDevice,
//VkSampleCountFlagBits                       samples,
//VkMultisamplePropertiesEXT*                 pMultisampleProperties);
//#endif
//
//#define VK_EXT_blend_operation_advanced 1
//#define VK_EXT_BLEND_OPERATION_ADVANCED_SPEC_VERSION 2
//#define VK_EXT_BLEND_OPERATION_ADVANCED_EXTENSION_NAME "VK_EXT_blend_operation_advanced"
//
//
//typedef enum VkBlendOverlapEXT {
//    VK_BLEND_OVERLAP_UNCORRELATED_EXT = 0,
//    VK_BLEND_OVERLAP_DISJOINT_EXT = 1,
//    VK_BLEND_OVERLAP_CONJOINT_EXT = 2,
//    VK_BLEND_OVERLAP_BEGIN_RANGE_EXT = VK_BLEND_OVERLAP_UNCORRELATED_EXT,
//    VK_BLEND_OVERLAP_END_RANGE_EXT = VK_BLEND_OVERLAP_CONJOINT_EXT,
//    VK_BLEND_OVERLAP_RANGE_SIZE_EXT = (VK_BLEND_OVERLAP_CONJOINT_EXT - VK_BLEND_OVERLAP_UNCORRELATED_EXT + 1),
//    VK_BLEND_OVERLAP_MAX_ENUM_EXT = 0x7FFFFFFF
//} VkBlendOverlapEXT;
//
//typedef struct VkPhysicalDeviceBlendOperationAdvancedFeaturesEXT {
//    VkStructureType    sType;
//    void*              pNext;
//    VkBool32           advancedBlendCoherentOperations;
//} VkPhysicalDeviceBlendOperationAdvancedFeaturesEXT;
//
//typedef struct VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT {
//    VkStructureType    sType;
//    void*              pNext;
//    uint32_t           advancedBlendMaxColorAttachments;
//    VkBool32           advancedBlendIndependentBlend;
//    VkBool32           advancedBlendNonPremultipliedSrcColor;
//    VkBool32           advancedBlendNonPremultipliedDstColor;
//    VkBool32           advancedBlendCorrelatedOverlap;
//    VkBool32           advancedBlendAllOperations;
//} VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT;
//
//typedef struct VkPipelineColorBlendAdvancedStateCreateInfoEXT {
//    VkStructureType      sType;
//    const void*          pNext;
//    VkBool32             srcPremultiplied;
//    VkBool32             dstPremultiplied;
//    VkBlendOverlapEXT    blendOverlap;
//} VkPipelineColorBlendAdvancedStateCreateInfoEXT;
//
//
//
//#define VK_NV_fragment_coverage_to_color 1
//#define VK_NV_FRAGMENT_COVERAGE_TO_COLOR_SPEC_VERSION 1
//#define VK_NV_FRAGMENT_COVERAGE_TO_COLOR_EXTENSION_NAME "VK_NV_fragment_coverage_to_color"
//
//typedef VkFlags VkPipelineCoverageToColorStateCreateFlagsNV;
//
//typedef struct VkPipelineCoverageToColorStateCreateInfoNV {
//    VkStructureType                                sType;
//    const void*                                    pNext;
//    VkPipelineCoverageToColorStateCreateFlagsNV    flags;
//    VkBool32                                       coverageToColorEnable;
//    uint32_t                                       coverageToColorLocation;
//} VkPipelineCoverageToColorStateCreateInfoNV;
//
//
//
//#define VK_NV_framebuffer_mixed_samples 1
//#define VK_NV_FRAMEBUFFER_MIXED_SAMPLES_SPEC_VERSION 1
//#define VK_NV_FRAMEBUFFER_MIXED_SAMPLES_EXTENSION_NAME "VK_NV_framebuffer_mixed_samples"
//
//
//typedef enum VkCoverageModulationModeNV {
//    VK_COVERAGE_MODULATION_MODE_NONE_NV = 0,
//    VK_COVERAGE_MODULATION_MODE_RGB_NV = 1,
//    VK_COVERAGE_MODULATION_MODE_ALPHA_NV = 2,
//    VK_COVERAGE_MODULATION_MODE_RGBA_NV = 3,
//    VK_COVERAGE_MODULATION_MODE_BEGIN_RANGE_NV = VK_COVERAGE_MODULATION_MODE_NONE_NV,
//    VK_COVERAGE_MODULATION_MODE_END_RANGE_NV = VK_COVERAGE_MODULATION_MODE_RGBA_NV,
//    VK_COVERAGE_MODULATION_MODE_RANGE_SIZE_NV = (VK_COVERAGE_MODULATION_MODE_RGBA_NV - VK_COVERAGE_MODULATION_MODE_NONE_NV + 1),
//    VK_COVERAGE_MODULATION_MODE_MAX_ENUM_NV = 0x7FFFFFFF
//} VkCoverageModulationModeNV;
//
//typedef VkFlags VkPipelineCoverageModulationStateCreateFlagsNV;
//
//typedef struct VkPipelineCoverageModulationStateCreateInfoNV {
//    VkStructureType                                   sType;
//    const void*                                       pNext;
//    VkPipelineCoverageModulationStateCreateFlagsNV    flags;
//    VkCoverageModulationModeNV                        coverageModulationMode;
//    VkBool32                                          coverageModulationTableEnable;
//    uint32_t                                          coverageModulationTableCount;
//    const float*                                      pCoverageModulationTable;
//} VkPipelineCoverageModulationStateCreateInfoNV;
//
//
//
//#define VK_NV_fill_rectangle 1
//#define VK_NV_FILL_RECTANGLE_SPEC_VERSION 1
//#define VK_NV_FILL_RECTANGLE_EXTENSION_NAME "VK_NV_fill_rectangle"
//
//
//#define VK_EXT_post_depth_coverage 1
//#define VK_EXT_POST_DEPTH_COVERAGE_SPEC_VERSION 1
//#define VK_EXT_POST_DEPTH_COVERAGE_EXTENSION_NAME "VK_EXT_post_depth_coverage"
//
//
//#define VK_EXT_validation_cache 1
//VK_DEFINE_NON_DISPATCHABLE_HANDLE(VkValidationCacheEXT)
//
//#define VK_EXT_VALIDATION_CACHE_SPEC_VERSION 1
//#define VK_EXT_VALIDATION_CACHE_EXTENSION_NAME "VK_EXT_validation_cache"
//
//
//typedef enum VkValidationCacheHeaderVersionEXT {
//    VK_VALIDATION_CACHE_HEADER_VERSION_ONE_EXT = 1,
//    VK_VALIDATION_CACHE_HEADER_VERSION_BEGIN_RANGE_EXT = VK_VALIDATION_CACHE_HEADER_VERSION_ONE_EXT,
//    VK_VALIDATION_CACHE_HEADER_VERSION_END_RANGE_EXT = VK_VALIDATION_CACHE_HEADER_VERSION_ONE_EXT,
//    VK_VALIDATION_CACHE_HEADER_VERSION_RANGE_SIZE_EXT = (VK_VALIDATION_CACHE_HEADER_VERSION_ONE_EXT - VK_VALIDATION_CACHE_HEADER_VERSION_ONE_EXT + 1),
//    VK_VALIDATION_CACHE_HEADER_VERSION_MAX_ENUM_EXT = 0x7FFFFFFF
//} VkValidationCacheHeaderVersionEXT;
//
//typedef VkFlags VkValidationCacheCreateFlagsEXT;
//
//typedef struct VkValidationCacheCreateInfoEXT {
//    VkStructureType                    sType;
//    const void*                        pNext;
//    VkValidationCacheCreateFlagsEXT    flags;
//    size_t                             initialDataSize;
//    const void*                        pInitialData;
//} VkValidationCacheCreateInfoEXT;
//
//typedef struct VkShaderModuleValidationCacheCreateInfoEXT {
//    VkStructureType         sType;
//    const void*             pNext;
//    VkValidationCacheEXT    validationCache;
//} VkShaderModuleValidationCacheCreateInfoEXT;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkCreateValidationCacheEXT)(VkDevice device, const VkValidationCacheCreateInfoEXT* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkValidationCacheEXT* pValidationCache);
//typedef void (VKAPI_PTR *PFN_vkDestroyValidationCacheEXT)(VkDevice device, VkValidationCacheEXT validationCache, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkMergeValidationCachesEXT)(VkDevice device, VkValidationCacheEXT dstCache, uint32_t srcCacheCount, const VkValidationCacheEXT* pSrcCaches);
//typedef VkResult (VKAPI_PTR *PFN_vkGetValidationCacheDataEXT)(VkDevice device, VkValidationCacheEXT validationCache, size_t* pDataSize, void* pData);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateValidationCacheEXT(
//VkDevice                                    device,
//const VkValidationCacheCreateInfoEXT*       pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkValidationCacheEXT*                       pValidationCache);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyValidationCacheEXT(
//VkDevice                                    device,
//VkValidationCacheEXT                        validationCache,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkMergeValidationCachesEXT(
//VkDevice                                    device,
//VkValidationCacheEXT                        dstCache,
//uint32_t                                    srcCacheCount,
//const VkValidationCacheEXT*                 pSrcCaches);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetValidationCacheDataEXT(
//VkDevice                                    device,
//VkValidationCacheEXT                        validationCache,
//size_t*                                     pDataSize,
//void*                                       pData);
//#endif
//
//#define VK_EXT_shader_viewport_index_layer 1
//#define VK_EXT_SHADER_VIEWPORT_INDEX_LAYER_SPEC_VERSION 1
//#define VK_EXT_SHADER_VIEWPORT_INDEX_LAYER_EXTENSION_NAME "VK_EXT_shader_viewport_index_layer"
//
//
//#define VK_EXT_global_priority 1
//#define VK_EXT_GLOBAL_PRIORITY_SPEC_VERSION 2
//#define VK_EXT_GLOBAL_PRIORITY_EXTENSION_NAME "VK_EXT_global_priority"
//
//
//typedef enum VkQueueGlobalPriorityEXT {
//    VK_QUEUE_GLOBAL_PRIORITY_LOW_EXT = 128,
//    VK_QUEUE_GLOBAL_PRIORITY_MEDIUM_EXT = 256,
//    VK_QUEUE_GLOBAL_PRIORITY_HIGH_EXT = 512,
//    VK_QUEUE_GLOBAL_PRIORITY_REALTIME_EXT = 1024,
//    VK_QUEUE_GLOBAL_PRIORITY_BEGIN_RANGE_EXT = VK_QUEUE_GLOBAL_PRIORITY_LOW_EXT,
//    VK_QUEUE_GLOBAL_PRIORITY_END_RANGE_EXT = VK_QUEUE_GLOBAL_PRIORITY_REALTIME_EXT,
//    VK_QUEUE_GLOBAL_PRIORITY_RANGE_SIZE_EXT = (VK_QUEUE_GLOBAL_PRIORITY_REALTIME_EXT - VK_QUEUE_GLOBAL_PRIORITY_LOW_EXT + 1),
//    VK_QUEUE_GLOBAL_PRIORITY_MAX_ENUM_EXT = 0x7FFFFFFF
//} VkQueueGlobalPriorityEXT;
//
//typedef struct VkDeviceQueueGlobalPriorityCreateInfoEXT {
//    VkStructureType             sType;
//    const void*                 pNext;
//    VkQueueGlobalPriorityEXT    globalPriority;
//} VkDeviceQueueGlobalPriorityCreateInfoEXT;
//
//
//
//#define VK_EXT_external_memory_host 1
//#define VK_EXT_EXTERNAL_MEMORY_HOST_SPEC_VERSION 1
//#define VK_EXT_EXTERNAL_MEMORY_HOST_EXTENSION_NAME "VK_EXT_external_memory_host"
//
//typedef struct VkImportMemoryHostPointerInfoEXT {
//    VkStructureType                          sType;
//    const void*                              pNext;
//    VkExternalMemoryHandleTypeFlagBitsKHR    handleType;
//    void*                                    pHostPointer;
//} VkImportMemoryHostPointerInfoEXT;
//
//typedef struct VkMemoryHostPointerPropertiesEXT {
//    VkStructureType    sType;
//    void*              pNext;
//    uint32_t           memoryTypeBits;
//} VkMemoryHostPointerPropertiesEXT;
//
//typedef struct VkPhysicalDeviceExternalMemoryHostPropertiesEXT {
//    VkStructureType    sType;
//    void*              pNext;
//    VkDeviceSize       minImportedHostPointerAlignment;
//} VkPhysicalDeviceExternalMemoryHostPropertiesEXT;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkGetMemoryHostPointerPropertiesEXT)(VkDevice device, VkExternalMemoryHandleTypeFlagBitsKHR handleType, const void* pHostPointer, VkMemoryHostPointerPropertiesEXT* pMemoryHostPointerProperties);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkGetMemoryHostPointerPropertiesEXT(
//VkDevice                                    device,
//VkExternalMemoryHandleTypeFlagBitsKHR       handleType,
//const void*                                 pHostPointer,
//VkMemoryHostPointerPropertiesEXT*           pMemoryHostPointerProperties);
//#endif
//
//#ifdef __cplusplus
//}
