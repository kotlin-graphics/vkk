package vkk.extensions

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