package vkk.extensions

//typedef struct VkDebugMarkerObjectNameInfoEXT {
//    VkStructureType               sType;
//    const void*                   pNext;
//    VkDebugReportObjectTypeEXT    objectType;
//    uint64_t                      object;
//    const char*                   pObjectName;
//} VkDebugMarkerObjectNameInfoEXT;
//
//typedef struct VkDebugMarkerObjectTagInfoEXT {
//    VkStructureType               sType;
//    const void*                   pNext;
//    VkDebugReportObjectTypeEXT    objectType;
//    uint64_t                      object;
//    uint64_t                      tagName;
//    size_t                        tagSize;
//    const void*                   pTag;
//} VkDebugMarkerObjectTagInfoEXT;
//
//typedef struct VkDebugMarkerMarkerInfoEXT {
//    VkStructureType    sType;
//    const void*        pNext;
//    const char*        pMarkerName;
//    float              color[4];
//} VkDebugMarkerMarkerInfoEXT;
//
//
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