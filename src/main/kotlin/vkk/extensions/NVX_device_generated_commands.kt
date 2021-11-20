package vkk.extensions

import vkk.VkFlags

@JvmInline
value class VkIndirectCommandsTokenTypeNVX(val i: Int) {
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

@JvmInline
value class VkObjectEntryTypeNVX(val i: Int) {
    companion object {
        val DESCRIPTOR_SET_NVX = VkObjectEntryTypeNVX(0)
        val PIPELINE_NVX = VkObjectEntryTypeNVX(1)
        val INDEX_BUFFER_NVX = VkObjectEntryTypeNVX(2)
        val VERTEX_BUFFER_NVX = VkObjectEntryTypeNVX(3)
        val PUSH_CONSTANT_NVX = VkObjectEntryTypeNVX(4)
    }
}


@JvmInline
value class VkIndirectCommandsLayoutUsageNVX(val i: VkIndirectCommandsLayoutUsageFlagsNVX) {
    companion object {
        val UNORDERED_SEQUENCES_BIT_NVX = VkIndirectCommandsLayoutUsageNVX(0x00000001)
        val SPARSE_SEQUENCES_BIT_NVX = VkIndirectCommandsLayoutUsageNVX(0x00000002)
        val EMPTY_EXECUTIONS_BIT_NVX = VkIndirectCommandsLayoutUsageNVX(0x00000004)
        val INDEXED_SEQUENCES_BIT_NVX = VkIndirectCommandsLayoutUsageNVX(0x00000008)
    }
}

typealias VkIndirectCommandsLayoutUsageFlagsNVX = VkFlags


@JvmInline
value class VkObjectEntryUsageNVX(val i: VkObjectEntryUsageFlagsNVX) {
    companion object {
        val GRAPHICS_BIT_NVX = VkObjectEntryUsageNVX(0x00000001)
        val COMPUTE_BIT_NVX = VkObjectEntryUsageNVX(0x00000002)
    }
}

typealias VkObjectEntryUsageFlagsNVX = VkFlags

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