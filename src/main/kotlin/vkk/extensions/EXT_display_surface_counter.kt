package vkk.extensions

import vkk.VkFlags

inline class VkSurfaceCounterEXT(val i: VkSurfaceCounterFlagsEXT) {
    companion object {
        val VBLANK_EXT = VkSurfaceCounterEXT(0x00000001)
    }
}

typealias VkSurfaceCounterFlagsEXT = VkFlags

//typedef struct VkSurfaceCapabilities2EXT {
//    VkStructureType                  sType;
//    void*                            pNext;
//    uint32_t                         minImageCount;
//    uint32_t                         maxImageCount;
//    VkExtent2D                       currentExtent;
//    VkExtent2D                       minImageExtent;
//    VkExtent2D                       maxImageExtent;
//    uint32_t                         maxImageArrayLayers;
//    VkSurfaceTransformFlagsKHR       supportedTransforms;
//    VkSurfaceTransformFlagBitsKHR    currentTransform;
//    VkCompositeAlphaFlagsKHR         supportedCompositeAlpha;
//    VkImageUsageFlags                supportedUsageFlags;
//    VkSurfaceCounterFlagsEXT         supportedSurfaceCounters;
//} VkSurfaceCapabilities2EXT;
//
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetPhysicalDeviceSurfaceCapabilities2EXT(
//VkPhysicalDevice                            physicalDevice,
//VkSurfaceKHR                                surface,
//VkSurfaceCapabilities2EXT*                  pSurfaceCapabilities);