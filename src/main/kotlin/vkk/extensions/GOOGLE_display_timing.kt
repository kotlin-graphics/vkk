package vkk.extensions

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