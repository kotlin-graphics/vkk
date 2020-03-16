package vkk.extensions

//typedef struct VkImportFenceFdInfoKHR {
//    VkStructureType                      sType;
//    const void*                          pNext;
//    VkFence                              fence;
//    VkFenceImportFlags                   flags;
//    VkExternalFenceHandleTypeFlagBits    handleType;
//    int                                  fd;
//} VkImportFenceFdInfoKHR;
//
//typedef struct VkFenceGetFdInfoKHR {
//    VkStructureType                      sType;
//    const void*                          pNext;
//    VkFence                              fence;
//    VkExternalFenceHandleTypeFlagBits    handleType;
//} VkFenceGetFdInfoKHR;
//
//
//VKAPI_ATTR VkResult VKAPI_CALL vkImportFenceFdKHR(
//VkDevice                                    device,
//const VkImportFenceFdInfoKHR*               pImportFenceFdInfo);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetFenceFdKHR(
//VkDevice                                    device,
//const VkFenceGetFdInfoKHR*                  pGetFdInfo,
//int*                                        pFd);