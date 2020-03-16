package vkk.extensions

//typedef struct VkImportMemoryFdInfoKHR {
//    VkStructureType                       sType;
//    const void*                           pNext;
//    VkExternalMemoryHandleTypeFlagBits    handleType;
//    int                                   fd;
//} VkImportMemoryFdInfoKHR;
//
//typedef struct VkMemoryFdPropertiesKHR {
//    VkStructureType    sType;
//    void*              pNext;
//    uint32_t           memoryTypeBits;
//} VkMemoryFdPropertiesKHR;
//
//typedef struct VkMemoryGetFdInfoKHR {
//    VkStructureType                       sType;
//    const void*                           pNext;
//    VkDeviceMemory                        memory;
//    VkExternalMemoryHandleTypeFlagBits    handleType;
//} VkMemoryGetFdInfoKHR;
//
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetMemoryFdKHR(
//VkDevice                                    device,
//const VkMemoryGetFdInfoKHR*                 pGetFdInfo,
//int*                                        pFd);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetMemoryFdPropertiesKHR(
//VkDevice                                    device,
//VkExternalMemoryHandleTypeFlagBits          handleType,
//int                                         fd,
//VkMemoryFdPropertiesKHR*                    pMemoryFdProperties);