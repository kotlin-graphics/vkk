package vkk

import glm_.BYTES
import glm_.bool
import glm_.f
import glm_.i
import glm_.vec2.Vec2
import glm_.vec2.Vec2i
import glm_.vec3.Vec3i
import kool.Ptr
import org.lwjgl.PointerBuffer
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.system.Pointer
import org.lwjgl.vulkan.*
import java.nio.ByteBuffer
import java.nio.FloatBuffer
import java.nio.IntBuffer
import java.nio.LongBuffer


inline var VkApplicationInfo.type: VkStructureType
    get() = VkStructureType of VkApplicationInfo.nsType(adr)
    set(value) = VkApplicationInfo.nsType(adr, value.i)
inline var VkApplicationInfo.next: Ptr
    get() = VkApplicationInfo.npNext(adr)
    set(value) = VkApplicationInfo.npNext(adr, value)
inline var VkApplicationInfo.applicationName: String?
    get() = VkApplicationInfo.npApplicationNameString(adr)
    set(value) = VkApplicationInfo.npApplicationName(adr, value?.toUTF8stack())
inline var VkApplicationInfo.applicationVersion: Int
    get() = VkApplicationInfo.napplicationVersion(adr)
    set(value) = VkApplicationInfo.napiVersion(adr, value)
inline var VkApplicationInfo.engineName: String?
    get() = VkApplicationInfo.npEngineNameString(adr)
    set(value) = VkApplicationInfo.npEngineName(adr, value?.toUTF8stack())
inline var VkApplicationInfo.apiVersion: Int
    get() = VkApplicationInfo.napiVersion(adr)
    set(value) = VkApplicationInfo.napiVersion(adr, value)


inline var VkInstanceCreateInfo.type: VkStructureType
    get() = VkStructureType of VkInstanceCreateInfo.nsType(adr)
    set(value) = VkInstanceCreateInfo.nsType(adr, value.i)
inline var VkInstanceCreateInfo.next: Ptr
    get() = VkInstanceCreateInfo.npNext(adr)
    set(value) = VkInstanceCreateInfo.npNext(adr, value)
// flags is reserved for future usage, till now must be 0
//inline var VkInstanceCreateInfo.flag: VkInstanceCreateFlags
//    get() = VkInstanceCreateInfo.nflags(adr)
//    set(value) = VkInstanceCreateInfo.nflags(adr, value)
inline var VkInstanceCreateInfo.flags: VkInstanceCreateFlags
    get() = VkInstanceCreateInfo.nflags(adr)
    set(value) = VkInstanceCreateInfo.nflags(adr, value)
inline var VkInstanceCreateInfo.applicationInfo: VkApplicationInfo?
    get() = VkInstanceCreateInfo.npApplicationInfo(adr)
    set(value) = VkInstanceCreateInfo.npApplicationInfo(adr, value)
inline var VkInstanceCreateInfo.enabledLayerNames: Collection<String>
    get() = VkInstanceCreateInfo.nppEnabledLayerNames(adr).toArrayList()
    set(value) = VkInstanceCreateInfo.nppEnabledLayerNames(adr, value.toPointerBufferStack())
inline var VkInstanceCreateInfo.enabledExtensionNames: Collection<String>
    get() = VkInstanceCreateInfo.nppEnabledExtensionNames(adr).toArrayList()
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

inline val VkFormatProperties.linearTilingFeatures: VkFormatFeatureFlags
    get() = VkFormatProperties.nlinearTilingFeatures(adr)
inline val VkFormatProperties.optimalTilingFeatures: VkFormatFeatureFlags
    get() = VkFormatProperties.noptimalTilingFeatures(adr)
inline val VkFormatProperties.bufferFeatures: VkFormatFeatureFlags
    get() = VkFormatProperties.nbufferFeatures(adr)

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


//typedef struct VkMemoryHeap {
//    VkDeviceSize         size;
//    VkMemoryHeapFlags    flags;
//} VkMemoryHeap;

inline val VkPhysicalDeviceMemoryProperties.memoryTypeCount: Int
    get() = VkPhysicalDeviceMemoryProperties.nmemoryTypeCount(adr)
inline val VkPhysicalDeviceMemoryProperties.memoryTypes: VkMemoryType.Buffer
    get() = VkPhysicalDeviceMemoryProperties.nmemoryTypes(adr)
inline val VkPhysicalDeviceMemoryProperties.memoryHeapCount: Int
    get() = VkPhysicalDeviceMemoryProperties.nmemoryHeapCount(adr)
inline val VkPhysicalDeviceMemoryProperties.memoryHeaps: VkMemoryHeap.Buffer
    get() = VkPhysicalDeviceMemoryProperties.nmemoryHeaps(adr)


//typedef void (VKAPI_PTR *PFN_vkVoidFunction)(void);

inline var VkDeviceQueueCreateInfo.type: VkStructureType
    get() = VkStructureType of VkDeviceQueueCreateInfo.nsType(adr)
    set(value) = VkDeviceQueueCreateInfo.nsType(adr, value.i)
inline var VkDeviceQueueCreateInfo.next: Ptr
    get() = VkDeviceQueueCreateInfo.npNext(adr)
    set(value) = VkDeviceQueueCreateInfo.npNext(adr, value)
inline var VkDeviceQueueCreateInfo.flag: VkDeviceQueueCreate
    get() = TODO()
    set(value) = VkDeviceQueueCreateInfo.nflags(adr, value.i)
inline var VkDeviceQueueCreateInfo.flags: VkDeviceQueueCreateFlags
    get() = VkDeviceQueueCreateInfo.nflags(adr)
    set(value) = VkDeviceQueueCreateInfo.nflags(adr, value)
inline var VkDeviceQueueCreateInfo.queueFamilyIndex: Int
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
        val stack = MemoryStack.stackGet()
        val buf = stack.nmalloc(1, Float.BYTES)
        memPutFloat(buf, value)
        memPutAddress(adr + VkDeviceQueueCreateInfo.PQUEUEPRIORITIES, buf)
        VkDeviceQueueCreateInfo.nqueueCount(adr, 1)
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
inline var VkDeviceCreateInfo.next: Ptr
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
    set(value) = VkDeviceCreateInfo.nppEnabledLayerNames(adr, value.toPointerBufferStack())
inline var VkDeviceCreateInfo.enabledExtensionNames: Collection<String>
    get() = VkDeviceCreateInfo.nppEnabledExtensionNames(adr).toArrayList()
    set(value) = VkDeviceCreateInfo.nppEnabledExtensionNames(adr, value.toPointerBufferStack())
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
inline var VkSubmitInfo.next: Ptr
    get() = VkSubmitInfo.npNext(adr)
    set(value) = VkSubmitInfo.npNext(adr, value)
inline var VkSubmitInfo.waitSemaphoreCount: Int
    get() = VkSubmitInfo.nwaitSemaphoreCount(adr)
    set(value) = VkSubmitInfo.nwaitSemaphoreCount(adr, value)
inline var VkSubmitInfo.waitSemaphores: LongBuffer?
    get() = VkSubmitInfo.npWaitSemaphores(adr)
    set(value) = VkSubmitInfo.npWaitSemaphores(adr, value)
/** JVM custom */
inline var VkSubmitInfo.waitSemaphore: VkSemaphore
    get() = VkSemaphore(VkSubmitInfo.npWaitSemaphores(adr)?.get(0) ?: NULL)
    set(value) {
        val stack = MemoryStack.stackGet()
        val pSemaphore = stack.nmalloc(1, Long.BYTES)
        memPutLong(pSemaphore, value.L)
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
        val stack = MemoryStack.stackGet()
        val pCmdBuff = stack.nmalloc(Pointer.POINTER_SIZE, Pointer.POINTER_SIZE)
        memPutAddress(pCmdBuff, value?.adr ?: NULL)
        memPutAddress(adr + VkSubmitInfo.PCOMMANDBUFFERS, pCmdBuff)
        VkSubmitInfo.ncommandBufferCount(adr, if (value == null) 0 else 1)
    }
//inline val VkSubmitInfo.signalSemaphoreCount get() = VkSubmitInfo.nsignalSemaphoreCount(address)
inline var VkSubmitInfo.signalSemaphores: LongBuffer?
    get() = VkSubmitInfo.npSignalSemaphores(adr)
    set(value) = VkSubmitInfo.npSignalSemaphores(adr, value)
/** JVM custom */
var VkSubmitInfo.signalSemaphore: VkSemaphore // TODO BUG, inline
    get() = VkSemaphore(VkSubmitInfo.npSignalSemaphores(adr)?.get(0) ?: NULL)
    set(value) {
        val stack = MemoryStack.stackGet()
        val pSemaphore = stack.nmalloc(1, Long.BYTES)
        memPutLong(pSemaphore, value.L)
        memPutAddress(adr + VkSubmitInfo.PSIGNALSEMAPHORES, pSemaphore)
        VkSubmitInfo.nsignalSemaphoreCount(adr, if (value.L == NULL) 0 else 1)
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
    get() = VkStructureType of VkMappedMemoryRange.nsType(adr)
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
inline var VkFenceCreateInfo.next: Ptr
    get() = VkFenceCreateInfo.npNext(adr)
    set(value) = VkFenceCreateInfo.npNext(adr, value)
inline var VkFenceCreateInfo.flags: VkFenceCreateFlags
    get() = VkFenceCreateInfo.nflags(adr)
    set(value) = VkFenceCreateInfo.nflags(adr, value)


inline var VkSemaphoreCreateInfo.type: VkStructureType
    get() = VkStructureType of VkSemaphoreCreateInfo.nsType(adr)
    set(value) = VkSemaphoreCreateInfo.nsType(adr, value.i)
inline var VkSemaphoreCreateInfo.next: Ptr
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
inline var VkQueryPoolCreateInfo.next: Ptr
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
inline var VkBufferCreateInfo.next: Ptr
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
    get() = VkDeviceSize(VkBufferCreateInfo.nsize(adr))
    set(value) = VkBufferCreateInfo.nsize(adr, value.L)
inline var VkBufferCreateInfo.usage: VkBufferUsageFlags
    get() = VkBufferCreateInfo.nusage(adr)
    set(value) = VkBufferCreateInfo.nusage(adr, value)
inline var VkBufferCreateInfo.sharingMode: VkSharingMode
    get() = VkSharingMode of VkBufferCreateInfo.nsharingMode(adr)
    set(value) = VkBufferCreateInfo.nsharingMode(adr, value.i)
inline var VkBufferCreateInfo.queueFamilyIndexCount: Int
    get() = VkBufferCreateInfo.nqueueFamilyIndexCount(adr)
    set(value) = VkBufferCreateInfo.nqueueFamilyIndexCount(adr, value)
inline var VkBufferCreateInfo.queueFamilyIndices: IntBuffer?
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
    get() = VkImageViewType of VkImageViewCreateInfo.nviewType(adr)
    set(value) = VkImageViewCreateInfo.nviewType(adr, value.i)
inline var VkImageViewCreateInfo.format: VkFormat
    get() = VkFormat of VkImageViewCreateInfo.nformat(adr)
    set(value) = VkImageViewCreateInfo.nformat(adr, value.i)
inline var VkImageViewCreateInfo.components: VkComponentMapping
    get() = VkImageViewCreateInfo.ncomponents(adr)
    set(value) = VkImageViewCreateInfo.ncomponents(adr, value)

/** JVM custom */
fun VkImageViewCreateInfo.components(r: VkComponentSwizzle, g: VkComponentSwizzle, b: VkComponentSwizzle, a: VkComponentSwizzle) {
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
inline var VkImageCreateInfo.next: Ptr
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
fun VkImageCreateInfo.extent(extent: Vec3i) {
    this.extent.set(extent.x, extent.y, extent.z)
}

/** JVM custom */
fun VkImageCreateInfo.extent(extent: Vec2i, depth: Int) {
    this.extent.set(extent.x, extent.y, depth)
}

inline var VkImageCreateInfo.mipLevels: Int
    get() = VkImageCreateInfo.nmipLevels(adr)
    set(value) = VkImageCreateInfo.nmipLevels(adr, value)
inline var VkImageCreateInfo.arrayLayers: Int
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
inline var VkImageCreateInfo.queueFamilyIndices: IntBuffer?
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

operator fun VkComponentMapping.invoke(r: VkComponentSwizzle, g: VkComponentSwizzle, b: VkComponentSwizzle, a: VkComponentSwizzle) {
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
inline var VkShaderModuleCreateInfo.next: Ptr
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
inline var VkPipelineCacheCreateInfo.next: Ptr
    get() = VkPipelineCacheCreateInfo.npNext(adr)
    set(value) = VkPipelineCacheCreateInfo.npNext(adr, value)
inline var VkPipelineCacheCreateInfo.flags: VkPipelineCacheCreateFlags
    get() = VkPipelineCacheCreateInfo.nflags(adr)
    set(value) = VkPipelineCacheCreateInfo.nflags(adr, value)
inline val VkPipelineCacheCreateInfo.initialDataSize: Long
    get() = initialDataSize()
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
inline var VkPipelineShaderStageCreateInfo.next: Ptr
    get() = VkPipelineShaderStageCreateInfo.npNext(adr)
    set(value) = VkPipelineShaderStageCreateInfo.npNext(adr, value)
inline var VkPipelineShaderStageCreateInfo.flags: VkPipelineShaderStageCreateFlags
    get() = VkPipelineShaderStageCreateInfo.nflags(adr)
    set(value) = VkPipelineShaderStageCreateInfo.nflags(adr, value)
inline var VkPipelineShaderStageCreateInfo.stage: VkShaderStage
    get() = VkShaderStage of VkPipelineShaderStageCreateInfo.nstage(adr)
    set(value) = VkPipelineShaderStageCreateInfo.nstage(adr, value.i)
inline var VkPipelineShaderStageCreateInfo.module: VkShaderModule
    get() = VkShaderModule(VkPipelineShaderStageCreateInfo.nmodule(adr))
    set(value) = VkPipelineShaderStageCreateInfo.nmodule(adr, value.L)
inline var VkPipelineShaderStageCreateInfo.name: String
    get() = VkPipelineShaderStageCreateInfo.npNameString(adr)
    set(value) = VkPipelineShaderStageCreateInfo.npName(adr, value.toUTF8stack())
inline var VkPipelineShaderStageCreateInfo.specializationInfo: VkSpecializationInfo?
    get() = VkPipelineShaderStageCreateInfo.npSpecializationInfo(adr)
    set(value) = VkPipelineShaderStageCreateInfo.npSpecializationInfo(adr, value)


inline var VkVertexInputBindingDescription.binding: Int
    get() = VkVertexInputBindingDescription.nbinding(adr)
    set(value) = VkVertexInputBindingDescription.nbinding(adr, value)
inline var VkVertexInputBindingDescription.stride: Int
    get() = VkVertexInputBindingDescription.nstride(adr)
    set(value) = VkVertexInputBindingDescription.nstride(adr, value)
inline var VkVertexInputBindingDescription.inputRate: VkVertexInputRate
    get() = VkVertexInputRate of VkVertexInputBindingDescription.ninputRate(adr)
    set(value) = VkVertexInputBindingDescription.ninputRate(adr, value.i)


inline var VkVertexInputAttributeDescription.location: Int
    get() = VkVertexInputAttributeDescription.nlocation(adr)
    set(value) = VkVertexInputAttributeDescription.nlocation(adr, value)
inline var VkVertexInputAttributeDescription.binding: Int
    get() = VkVertexInputAttributeDescription.nbinding(adr)
    set(value) = VkVertexInputAttributeDescription.nbinding(adr, value)
inline var VkVertexInputAttributeDescription.format: VkFormat
    get() = VkFormat of VkVertexInputAttributeDescription.nformat(adr)
    set(value) = VkVertexInputAttributeDescription.nformat(adr, value.i)
inline var VkVertexInputAttributeDescription.offset: Int
    get() = VkVertexInputAttributeDescription.noffset(adr)
    set(value) = VkVertexInputAttributeDescription.noffset(adr, value)


inline var VkPipelineVertexInputStateCreateInfo.type: VkStructureType
    get() = VkStructureType of VkPipelineVertexInputStateCreateInfo.nsType(adr)
    set(value) {
        sType(value.i)
    }
inline var VkPipelineVertexInputStateCreateInfo.next: Ptr
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
inline var VkPipelineInputAssemblyStateCreateInfo.next: Ptr
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
fun VkViewport.offset(f: Float) = offset(f, f)

/** JVM custom */
fun VkViewport.offset(x: Float, y: Float) {
    this.x = x
    this.y = y
}

/** JVM custom */
fun VkViewport.size(size: Vec2i) {
    width = size.x.f
    height = size.y.f
}

/** JVM custom */
fun VkViewport.depth(minDepth: Float, maxDepth: Float) {
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


inline var VkOffset2D.x: Int
    get() = VkOffset2D.nx(adr)
    set(value) = VkOffset2D.nx(adr, value)
inline var VkOffset2D.y: Int
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


inline var VkExtent2D.width: Int
    get() = VkExtent2D.nwidth(adr)
    set(value) = VkExtent2D.nwidth(adr, value)
inline var VkExtent2D.height: Int
    get() = VkExtent2D.nheight(adr)
    set(value) = VkExtent2D.nheight(adr, value)

//var VkExtent2D.size BUG
//    get() = Vec2i(width, height)
//    set(value) {
//        width = value.x
//        height = value.y
//    }
fun VkOffset2D.pos(x: Int, y: Int) {
    this.x = x
    this.y = y
}

//inline var VkOffset2D.pos BUG
//    get() = Vec2i(x, y)
//    set(value) {
//        x = value.x
//        y = value.y
//    }
inline var VkExtent3D.width: Int
    get() = width()
    set(value) {
        width(value)
    }
inline var VkExtent3D.height: Int
    get() = height()
    set(value) {
        height(value)
    }
inline var VkExtent3D.depth: Int
    get() = depth()
    set(value) {
        depth(value)
    }

fun VkExtent3D.size(x: Int, y: Int, z: Int) {
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
fun VkRect2D.offset(offset: Int) = offset(offset, offset)

/** JVM custom */
fun VkRect2D.offset(x: Int, y: Int) {
    offset.x = x
    offset.y = y
}

/** JVM custom */
fun VkRect2D.extent(size: Vec2i) = extent(size.x, size.y)

/** JVM custom */
fun VkRect2D.extent(width: Int, height: Int) {
    extent.width = width
    extent.height = height
}

/** JVM custom */
fun VkRect2D.extent(width: Number, height: Number) = extent(width.i, height.i)

/** JVM custom */
fun VkRect2D.offset(width: Number, height: Number) = offset(width.i, height.i)


inline var VkPipelineViewportStateCreateInfo.type: VkStructureType
    get() = VkStructureType of VkPipelineViewportStateCreateInfo.nsType(adr)
    set(value) = VkPipelineViewportStateCreateInfo.nsType(adr, value.i)
inline var VkPipelineViewportStateCreateInfo.next: Ptr
    get() = VkPipelineViewportStateCreateInfo.npNext(adr)
    set(value) = VkPipelineViewportStateCreateInfo.npNext(adr, value)
inline var VkPipelineViewportStateCreateInfo.flags: VkPipelineViewportStateCreateFlags
    get() = VkPipelineViewportStateCreateInfo.nflags(adr)
    set(value) = VkPipelineViewportStateCreateInfo.nflags(adr, value)
inline var VkPipelineViewportStateCreateInfo.viewportCount: Int
    get() = VkPipelineViewportStateCreateInfo.nviewportCount(adr)
    set(value) = VkPipelineViewportStateCreateInfo.nviewportCount(adr, value)
inline var VkPipelineViewportStateCreateInfo.viewports: VkViewport.Buffer?
    get() = VkPipelineViewportStateCreateInfo.npViewports(adr)
    set(value) = VkPipelineViewportStateCreateInfo.npViewports(adr, value)
inline var VkPipelineViewportStateCreateInfo.scissorCount: Int
    get() = VkPipelineViewportStateCreateInfo.nscissorCount(adr)
    set(value) = VkPipelineViewportStateCreateInfo.nscissorCount(adr, value)
inline var VkPipelineViewportStateCreateInfo.scissors: VkRect2D.Buffer?
    get() = VkPipelineViewportStateCreateInfo.npScissors(adr)
    set(value) = VkPipelineViewportStateCreateInfo.npScissors(adr, value)


inline var VkPipelineRasterizationStateCreateInfo.type: VkStructureType
    get() = VkStructureType of VkPipelineRasterizationStateCreateInfo.nsType(adr)
    set(value) = VkPipelineRasterizationStateCreateInfo.nsType(adr, value.i)
inline var VkPipelineRasterizationStateCreateInfo.next: Ptr
    get() = VkPipelineRasterizationStateCreateInfo.npNext(adr)
    set(value) = VkPipelineRasterizationStateCreateInfo.npNext(adr, value)
inline var VkPipelineRasterizationStateCreateInfo.flags: VkPipelineRasterizationStateCreateFlags
    get() = VkPipelineRasterizationStateCreateInfo.nflags(adr)
    set(value) = VkPipelineRasterizationStateCreateInfo.nflags(adr, value)
inline var VkPipelineRasterizationStateCreateInfo.depthClampEnable: Boolean
    get() = VkPipelineRasterizationStateCreateInfo.ndepthClampEnable(adr).bool
    set(value) = VkPipelineRasterizationStateCreateInfo.ndepthClampEnable(adr, value.i)
inline var VkPipelineRasterizationStateCreateInfo.rasterizerDiscardEnable: Boolean
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
inline var VkPipelineRasterizationStateCreateInfo.depthBiasEnable: Boolean
    get() = VkPipelineRasterizationStateCreateInfo.ndepthBiasEnable(adr).bool
    set(value) = VkPipelineRasterizationStateCreateInfo.ndepthBiasEnable(adr, value.i)
inline var VkPipelineRasterizationStateCreateInfo.depthBiasConstantFactor: Float
    get() = VkPipelineRasterizationStateCreateInfo.ndepthBiasConstantFactor(adr)
    set(value) = VkPipelineRasterizationStateCreateInfo.ndepthBiasConstantFactor(adr, value)
inline var VkPipelineRasterizationStateCreateInfo.depthBiasClamp: Float
    get() = VkPipelineRasterizationStateCreateInfo.ndepthBiasClamp(adr)
    set(value) = VkPipelineRasterizationStateCreateInfo.ndepthBiasClamp(adr, value)
inline var VkPipelineRasterizationStateCreateInfo.depthBiasSlopeFactor: Float
    get() = VkPipelineRasterizationStateCreateInfo.ndepthBiasSlopeFactor(adr)
    set(value) = VkPipelineRasterizationStateCreateInfo.ndepthBiasSlopeFactor(adr, value)
inline var VkPipelineRasterizationStateCreateInfo.lineWidth: Float
    get() = VkPipelineRasterizationStateCreateInfo.nlineWidth(adr)
    set(value) = VkPipelineRasterizationStateCreateInfo.nlineWidth(adr, value)


inline var VkPipelineMultisampleStateCreateInfo.type: VkStructureType
    get() = VkStructureType of VkPipelineMultisampleStateCreateInfo.nsType(adr)
    set(value) = VkPipelineMultisampleStateCreateInfo.nsType(adr, value.i)
inline var VkPipelineMultisampleStateCreateInfo.next: Ptr
    get() = VkPipelineMultisampleStateCreateInfo.npNext(adr)
    set(value) = VkPipelineMultisampleStateCreateInfo.npNext(adr, value)
inline var VkPipelineMultisampleStateCreateInfo.flags: VkPipelineMultisampleStateCreateFlags
    get() = VkPipelineMultisampleStateCreateInfo.nflags(adr)
    set(value) = VkPipelineMultisampleStateCreateInfo.nflags(adr, value)
inline var VkPipelineMultisampleStateCreateInfo.rasterizationSamples: VkSampleCount
    get() = VkSampleCount of VkPipelineMultisampleStateCreateInfo.nrasterizationSamples(adr)
    set(value) = VkPipelineMultisampleStateCreateInfo.nrasterizationSamples(adr, value.i)
inline var VkPipelineMultisampleStateCreateInfo.sampleShadingEnable: Boolean
    get() = VkPipelineMultisampleStateCreateInfo.nsampleShadingEnable(adr).bool
    set(value) = VkPipelineMultisampleStateCreateInfo.nsampleShadingEnable(adr, value.i)
inline var VkPipelineMultisampleStateCreateInfo.minSampleShading: Float
    get() = VkPipelineMultisampleStateCreateInfo.nminSampleShading(adr)
    set(value) = VkPipelineMultisampleStateCreateInfo.nminSampleShading(adr, value)
/** https://stackoverflow.com/a/38863042/1047713 */
inline var VkPipelineMultisampleStateCreateInfo.sampleMask: Int?
    get() = memGetInt(memGetAddress(adr + VkPipelineMultisampleStateCreateInfo.PSAMPLEMASK))
    set(value) {
        val stack = MemoryStack.stackGet()
        val pInt = when {
            value != null -> stack.nmalloc(1, Int.BYTES).also { memPutInt(it, value) }
            else -> NULL
        }
        memPutAddress(adr + VkPipelineMultisampleStateCreateInfo.PSAMPLEMASK, pInt)
    }
inline var VkPipelineMultisampleStateCreateInfo.alphaToCoverageEnable: Boolean
    get() = VkPipelineMultisampleStateCreateInfo.nalphaToCoverageEnable(adr).bool
    set(value) = VkPipelineMultisampleStateCreateInfo.nalphaToCoverageEnable(adr, value.i)
inline var VkPipelineMultisampleStateCreateInfo.alphaToOneEnable: Boolean
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
inline var VkStencilOpState.compareMask: Int
    get() = VkStencilOpState.ncompareMask(adr)
    set(value) = VkStencilOpState.ncompareMask(adr, value)
inline var VkStencilOpState.writeMask: Int
    get() = VkStencilOpState.nwriteMask(adr)
    set(value) = VkStencilOpState.nwriteMask(adr, value)
inline var VkStencilOpState.reference: Int
    get() = VkStencilOpState.nreference(adr)
    set(value) = VkStencilOpState.nreference(adr, value)


inline var VkPipelineDepthStencilStateCreateInfo.type: VkStructureType
    get() = VkStructureType of VkPipelineDepthStencilStateCreateInfo.nsType(adr)
    set(value) = VkPipelineDepthStencilStateCreateInfo.nsType(adr, value.i)
inline var VkPipelineDepthStencilStateCreateInfo.next: Ptr
    get() = VkPipelineDepthStencilStateCreateInfo.npNext(adr)
    set(value) = VkPipelineDepthStencilStateCreateInfo.npNext(adr, value)
inline var VkPipelineDepthStencilStateCreateInfo.flags: VkPipelineDepthStencilStateCreateFlags
    get() = VkPipelineDepthStencilStateCreateInfo.nflags(adr)
    set(value) = VkPipelineDepthStencilStateCreateInfo.nflags(adr, value)
inline var VkPipelineDepthStencilStateCreateInfo.depthTestEnable: Boolean
    get() = VkPipelineDepthStencilStateCreateInfo.ndepthTestEnable(adr).bool
    set(value) = VkPipelineDepthStencilStateCreateInfo.ndepthTestEnable(adr, value.i)
inline var VkPipelineDepthStencilStateCreateInfo.depthWriteEnable: Boolean
    get() = VkPipelineDepthStencilStateCreateInfo.ndepthWriteEnable(adr).bool
    set(value) = VkPipelineDepthStencilStateCreateInfo.ndepthWriteEnable(adr, value.i)
inline var VkPipelineDepthStencilStateCreateInfo.depthCompareOp: VkCompareOp
    get() = VkCompareOp of VkPipelineDepthStencilStateCreateInfo.ndepthCompareOp(adr)
    set(value) = VkPipelineDepthStencilStateCreateInfo.ndepthCompareOp(adr, value.i)
inline var VkPipelineDepthStencilStateCreateInfo.depthBoundsTestEnable: Boolean
    get() = VkPipelineDepthStencilStateCreateInfo.ndepthBoundsTestEnable(adr).bool
    set(value) = VkPipelineDepthStencilStateCreateInfo.ndepthBoundsTestEnable(adr, value.i)
inline var VkPipelineDepthStencilStateCreateInfo.stencilTestEnable: Boolean
    get() = VkPipelineDepthStencilStateCreateInfo.nstencilTestEnable(adr).bool
    set(value) = VkPipelineDepthStencilStateCreateInfo.nstencilTestEnable(adr, value.i)
inline var VkPipelineDepthStencilStateCreateInfo.front: VkStencilOpState
    get() = VkPipelineDepthStencilStateCreateInfo.nfront(adr)
    set(value) = VkPipelineDepthStencilStateCreateInfo.nfront(adr, value)
inline var VkPipelineDepthStencilStateCreateInfo.back: VkStencilOpState
    get() = VkPipelineDepthStencilStateCreateInfo.nback(adr)
    set(value) = VkPipelineDepthStencilStateCreateInfo.nback(adr, value)
inline var VkPipelineDepthStencilStateCreateInfo.minDepthBounds: Float
    get() = VkPipelineDepthStencilStateCreateInfo.nminDepthBounds(adr)
    set(value) = VkPipelineDepthStencilStateCreateInfo.nminDepthBounds(adr, value)
inline var VkPipelineDepthStencilStateCreateInfo.maxDepthBounds: Float
    get() = VkPipelineDepthStencilStateCreateInfo.nmaxDepthBounds(adr)
    set(value) = VkPipelineDepthStencilStateCreateInfo.nmaxDepthBounds(adr, value)


inline var VkPipelineColorBlendAttachmentState.blendEnable: Boolean
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
inline var VkPipelineColorBlendStateCreateInfo.next: Ptr
    get() = VkPipelineColorBlendStateCreateInfo.npNext(adr)
    set(value) = VkPipelineColorBlendStateCreateInfo.npNext(adr, value)
inline var VkPipelineColorBlendStateCreateInfo.flags: VkPipelineColorBlendStateCreateFlags
    get() = VkPipelineColorBlendStateCreateInfo.nflags(adr)
    set(value) = VkPipelineColorBlendStateCreateInfo.nflags(adr, value)
inline var VkPipelineColorBlendStateCreateInfo.logicOpEnable: Boolean
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
inline var VkPipelineDynamicStateCreateInfo.next: Ptr
    get() = VkPipelineDynamicStateCreateInfo.npNext(adr)
    set(value) = VkPipelineDynamicStateCreateInfo.npNext(adr, value)
inline var VkPipelineDynamicStateCreateInfo.flags: VkPipelineDynamicStateCreateFlags
    get() = VkPipelineDynamicStateCreateInfo.nflags(adr)
    set(value) = VkPipelineDynamicStateCreateInfo.nflags(adr, value)
//inline val VkPipelineDynamicStateCreateInfo.dynamicStateCount get() = VkPipelineDynamicStateCreateInfo.ndynamicStateCount(adr)
inline var VkPipelineDynamicStateCreateInfo.dynamicStates: VkDynamicStateBuffer
    get() = VkDynamicStateBuffer(VkPipelineDynamicStateCreateInfo.npDynamicStates(adr))
    set(value) = VkPipelineDynamicStateCreateInfo.npDynamicStates(adr, value.buffer)

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
inline var VkGraphicsPipelineCreateInfo.next: Ptr
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
    get() = VkPipelineLayout(VkGraphicsPipelineCreateInfo.nlayout(adr))
    set(value) = VkGraphicsPipelineCreateInfo.nlayout(adr, value.L)
inline var VkGraphicsPipelineCreateInfo.renderPass: VkRenderPass
    get() = VkRenderPass(VkGraphicsPipelineCreateInfo.nrenderPass(adr))
    set(value) = VkGraphicsPipelineCreateInfo.nrenderPass(adr, value.L)
inline var VkGraphicsPipelineCreateInfo.subpass
    get() = VkGraphicsPipelineCreateInfo.nsubpass(adr)
    set(value) = VkGraphicsPipelineCreateInfo.nsubpass(adr, value)
inline var VkGraphicsPipelineCreateInfo.basePipelineHandle: VkPipeline
    get() = VkPipeline(VkGraphicsPipelineCreateInfo.nbasePipelineHandle(adr))
    set(value) = VkGraphicsPipelineCreateInfo.nbasePipelineHandle(adr, value.L)
inline var VkGraphicsPipelineCreateInfo.basePipelineIndex: Int
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
    get() = VkPipelineLayout(VkComputePipelineCreateInfo.nlayout(adr))
    set(value) = VkComputePipelineCreateInfo.nlayout(adr, value.L)
inline var VkComputePipelineCreateInfo.basePipelineHandle: VkPipeline
    get() = VkPipeline(VkComputePipelineCreateInfo.nbasePipelineHandle(adr))
    set(value) = VkComputePipelineCreateInfo.nbasePipelineHandle(adr, value.L)
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
inline var VkPipelineLayoutCreateInfo.next: Ptr
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
    get() = VkPipelineLayoutCreateInfo.npSetLayouts(adr)?.let { VkDescriptorSetLayout(it[0]) }
    set(value) = when (value) {
        null -> VkPipelineLayoutCreateInfo.npSetLayouts(adr, null)
        else -> longAddressStack(value.L) {
            memPutAddress(adr + VkPipelineLayoutCreateInfo.PSETLAYOUTS, it)
            memPutInt(adr + VkPipelineLayoutCreateInfo.SETLAYOUTCOUNT, 1)
        }
    }
//inline val VkPipelineLayoutCreateInfo.pushConstantRangeCount get() = VkPipelineLayoutCreateInfo.npushConstantRangeCount(adr)
inline var VkPipelineLayoutCreateInfo.pushConstantRanges: VkPushConstantRange.Buffer?
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
inline var VkSamplerCreateInfo.next: Ptr
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


inline var VkDescriptorSetLayoutBinding.binding: Int
    get() = VkDescriptorSetLayoutBinding.nbinding(adr)
    set(value) = VkDescriptorSetLayoutBinding.nbinding(adr, value)
inline var VkDescriptorSetLayoutBinding.descriptorType: VkDescriptorType
    get() = VkDescriptorType of VkDescriptorSetLayoutBinding.ndescriptorType(adr)
    set(value) = VkDescriptorSetLayoutBinding.ndescriptorType(adr, value.i)
inline var VkDescriptorSetLayoutBinding.descriptorCount: Int
    get() = VkDescriptorSetLayoutBinding.ndescriptorCount(adr)
    set(value) = VkDescriptorSetLayoutBinding.ndescriptorCount(adr, value)
/** JVM custom */
inline var VkDescriptorSetLayoutBinding.stageFlag: VkShaderStage
    get() = TODO()
    set(value) = VkDescriptorSetLayoutBinding.nstageFlags(adr, value.i)
inline var VkDescriptorSetLayoutBinding.stageFlags: VkShaderStageFlags
    get() = VkDescriptorSetLayoutBinding.nstageFlags(adr)
    set(value) = VkDescriptorSetLayoutBinding.nstageFlags(adr, value)
inline var VkDescriptorSetLayoutBinding.immutableSamplers: VkSamplerBuffer?
    get() = VkDescriptorSetLayoutBinding.npImmutableSamplers(adr)
    set(value) = VkDescriptorSetLayoutBinding.npImmutableSamplers(adr, value)
/** JVM custom */
inline var VkDescriptorSetLayoutBinding.immutableSampler: VkSampler?
    get() = VkDescriptorSetLayoutBinding.npImmutableSamplers(adr)?.let { VkSampler(it[0]) }
    set(value) = when (value) {
        null -> memPutAddress(adr + VkDescriptorSetLayoutBinding.PIMMUTABLESAMPLERS, NULL)
        else -> longAddressStack(value.L) { pSampler ->
            memPutAddress(adr + VkDescriptorSetLayoutBinding.PIMMUTABLESAMPLERS, pSampler)
            memPutInt(adr + VkDescriptorSetLayoutBinding.DESCRIPTORCOUNT, 1)
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
    get() = VkDescriptorPool(VkDescriptorSetAllocateInfo.ndescriptorPool(adr))
    set(value) = VkDescriptorSetAllocateInfo.ndescriptorPool(adr, value.L)
inline var VkDescriptorSetAllocateInfo.descriptorSetCount
    get() = VkDescriptorSetAllocateInfo.ndescriptorSetCount(adr)
    set(value) = VkDescriptorSetAllocateInfo.ndescriptorSetCount(adr, value)
inline var VkDescriptorSetAllocateInfo.setLayouts: LongBuffer
    get() = VkDescriptorSetAllocateInfo.npSetLayouts(adr)
    set(value) = VkDescriptorSetAllocateInfo.npSetLayouts(adr, value)
/** JVM custom */
inline var VkDescriptorSetAllocateInfo.setLayout: VkDescriptorSetLayout
    get() = VkDescriptorSetLayout(VkDescriptorSetAllocateInfo.npSetLayouts(adr)[0])
    set(value) = longAddressStack(value.L) {
        memPutAddress(adr + VkDescriptorSetAllocateInfo.PSETLAYOUTS, it)
        memPutInt(adr + VkDescriptorSetAllocateInfo.DESCRIPTORSETCOUNT, 1)
    }


inline var VkDescriptorImageInfo.sampler: VkSampler
    get() = VkSampler(VkDescriptorImageInfo.nsampler(adr))
    set(value) = VkDescriptorImageInfo.nsampler(adr, value.L)
inline var VkDescriptorImageInfo.imageView: VkImageView
    get() = VkImageView(VkDescriptorImageInfo.nimageView(adr))
    set(value) = VkDescriptorImageInfo.nimageView(adr, value.L)
inline var VkDescriptorImageInfo.imageLayout: VkImageLayout
    get() = VkImageLayout of VkDescriptorImageInfo.nimageLayout(adr)
    set(value) = VkDescriptorImageInfo.nimageLayout(adr, value.i)


inline var VkDescriptorBufferInfo.buffer: VkBuffer
    get() = VkBuffer(VkDescriptorBufferInfo.nbuffer(adr))
    set(value) = VkDescriptorBufferInfo.nbuffer(adr, value.L)
inline var VkDescriptorBufferInfo.offset: VkDeviceSize
    get() = VkDeviceSize(VkDescriptorBufferInfo.noffset(adr))
    set(value) = VkDescriptorBufferInfo.noffset(adr, value.L)
inline var VkDescriptorBufferInfo.range: VkDeviceSize
    get() = VkDeviceSize(VkDescriptorBufferInfo.nrange(adr))
    set(value) = VkDescriptorBufferInfo.nrange(adr, value.L)