package vkk.extensions

//typedef struct VkImportSemaphoreFdInfoKHR {
//    VkStructureType                          sType;
//    const void*                              pNext;
//    VkSemaphore                              semaphore;
//    VkSemaphoreImportFlags                   flags;
//    VkExternalSemaphoreHandleTypeFlagBits    handleType;
//    int                                      fd;
//} VkImportSemaphoreFdInfoKHR;
//
//typedef struct VkSemaphoreGetFdInfoKHR {
//    VkStructureType                          sType;
//    const void*                              pNext;
//    VkSemaphore                              semaphore;
//    VkExternalSemaphoreHandleTypeFlagBits    handleType;
//} VkSemaphoreGetFdInfoKHR;
//
//
//VKAPI_ATTR VkResult VKAPI_CALL vkImportSemaphoreFdKHR(
//VkDevice                                    device,
//const VkImportSemaphoreFdInfoKHR*           pImportSemaphoreFdInfo);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetSemaphoreFdKHR(
//VkDevice                                    device,
//const VkSemaphoreGetFdInfoKHR*              pGetFdInfo,
//int*                                        pFd);