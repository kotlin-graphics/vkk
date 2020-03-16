package vkk.extensions

import vkk.VkFlags


typealias VkPipelineRasterizationStateStreamCreateFlagsEXT = VkFlags

//typedef struct VkPhysicalDeviceTransformFeedbackFeaturesEXT {
//    VkStructureType    sType;
//    void*              pNext;
//    VkBool32           transformFeedback;
//    VkBool32           geometryStreams;
//} VkPhysicalDeviceTransformFeedbackFeaturesEXT;
//
//typedef struct VkPhysicalDeviceTransformFeedbackPropertiesEXT {
//    VkStructureType    sType;
//    void*              pNext;
//    uint32_t           maxTransformFeedbackStreams;
//    uint32_t           maxTransformFeedbackBuffers;
//    VkDeviceSize       maxTransformFeedbackBufferSize;
//    uint32_t           maxTransformFeedbackStreamDataSize;
//    uint32_t           maxTransformFeedbackBufferDataSize;
//    uint32_t           maxTransformFeedbackBufferDataStride;
//    VkBool32           transformFeedbackQueries;
//    VkBool32           transformFeedbackStreamsLinesTriangles;
//    VkBool32           transformFeedbackRasterizationStreamSelect;
//    VkBool32           transformFeedbackDraw;
//} VkPhysicalDeviceTransformFeedbackPropertiesEXT;
//
//typedef struct VkPipelineRasterizationStateStreamCreateInfoEXT {
//    VkStructureType                                     sType;
//    const void*                                         pNext;
//    VkPipelineRasterizationStateStreamCreateFlagsEXT    flags;
//    uint32_t                                            rasterizationStream;
//} VkPipelineRasterizationStateStreamCreateInfoEXT;
//
//
//VKAPI_ATTR void VKAPI_CALL vkCmdBindTransformFeedbackBuffersEXT(
//VkCommandBuffer                             commandBuffer,
//uint32_t                                    firstBinding,
//uint32_t                                    bindingCount,
//const VkBuffer*                             pBuffers,
//const VkDeviceSize*                         pOffsets,
//const VkDeviceSize*                         pSizes);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdBeginTransformFeedbackEXT(
//VkCommandBuffer                             commandBuffer,
//uint32_t                                    firstCounterBuffer,
//uint32_t                                    counterBufferCount,
//const VkBuffer*                             pCounterBuffers,
//const VkDeviceSize*                         pCounterBufferOffsets);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdEndTransformFeedbackEXT(
//VkCommandBuffer                             commandBuffer,
//uint32_t                                    firstCounterBuffer,
//uint32_t                                    counterBufferCount,
//const VkBuffer*                             pCounterBuffers,
//const VkDeviceSize*                         pCounterBufferOffsets);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdBeginQueryIndexedEXT(
//VkCommandBuffer                             commandBuffer,
//VkQueryPool                                 queryPool,
//uint32_t                                    query,
//VkQueryControlFlags                         flags,
//uint32_t                                    index);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdEndQueryIndexedEXT(
//VkCommandBuffer                             commandBuffer,
//VkQueryPool                                 queryPool,
//uint32_t                                    query,
//uint32_t                                    index);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdDrawIndirectByteCountEXT(
//VkCommandBuffer                             commandBuffer,
//uint32_t                                    instanceCount,
//uint32_t                                    firstInstance,
//VkBuffer                                    counterBuffer,
//VkDeviceSize                                counterBufferOffset,
//uint32_t                                    counterOffset,
//uint32_t                                    vertexStride);