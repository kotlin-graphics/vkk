package vkk.extensions

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