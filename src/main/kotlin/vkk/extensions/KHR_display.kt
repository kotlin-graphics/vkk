package vkk.extensions

import vkk.VkFlags
import vkk.VkStructureType
import vkk.vk10.structs.Extent2D
import vkk.vk10.structs.Offset2D
import vkk.entities.VkDisplayKHR
import vkk.entities.VkDisplayModeKHR

//#define VK_KHR_DISPLAY_SPEC_VERSION       23

@JvmInline
value class VkDisplayPlaneAlphaKHR(val i: VkDisplayPlaneAlphaFlagsKHR) {

    companion object {
        val OPAQUE_BIT = VkDisplayPlaneAlphaKHR(0x00000001)
        val GLOBAL_BIT = VkDisplayPlaneAlphaKHR(0x00000002)
        val PER_PIXEL_BIT = VkDisplayPlaneAlphaKHR(0x00000004)
        val PER_PIXEL_PREMULTIPLIED_BIT = VkDisplayPlaneAlphaKHR(0x00000008)
    }
}

typealias VkDisplayPlaneAlphaFlagsKHR = VkFlags
typealias VkDisplayModeCreateFlagsKHR = VkFlags
typealias VkDisplaySurfaceCreateFlagsKHR = VkFlags

class DisplayPropertiesKHR(
        var display: VkDisplayKHR,
        var displayName: String,
        var physicalDimensions: Extent2D,
        var physicalResolution: Extent2D,
        var supportedTransforms: VkSurfaceTransformFlagsKHR,
        var planeReorderPossible: Boolean,
        var persistentContent: Boolean) {


}

class DisplayModeParametersKHR(
        var visibleRegion: Extent2D,
        var refreshRate: Int)

class DisplayModePropertiesKHR(
        var displayMode: VkDisplayModeKHR,
        var parameters: DisplayModeParametersKHR)

class DisplayModeCreateInfoKHR(
        var parameters: DisplayModeParametersKHR) {

    val type get() = VkStructureType.DISPLAY_MODE_CREATE_INFO_KHR
}

class DisplayPlaneCapabilitiesKHR(
        var supportedAlpha: VkDisplayPlaneAlphaFlagsKHR,
        var minSrcPosition: Offset2D,
        var maxSrcPosition: Offset2D,
        var minSrcExtent: Extent2D,
        var maxSrcExtent: Extent2D,
        var minDstPosition: Offset2D,
        var maxDstPosition: Offset2D,
        var minDstExtent: Extent2D,
        var maxDstExten: Extent2D)

class DisplayPlanePropertiesKHR(
        var currentDisplay: VkDisplayKHR,
        var currentStackIndex: Int)

class DisplaySurfaceCreateInfoKHR // TODO

//VKAPI_ATTR VkResult VKAPI_CALL vkGetPhysicalDeviceDisplayPropertiesKHR(
//VkPhysicalDevice                            physicalDevice,
//uint32_t*                                   pPropertyCount,
//VkDisplayPropertiesKHR*                     pProperties);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetPhysicalDeviceDisplayPlanePropertiesKHR(
//VkPhysicalDevice                            physicalDevice,
//uint32_t*                                   pPropertyCount,
//VkDisplayPlanePropertiesKHR*                pProperties);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetDisplayPlaneSupportedDisplaysKHR(
//VkPhysicalDevice                            physicalDevice,
//uint32_t                                    planeIndex,
//uint32_t*                                   pDisplayCount,
//VkDisplayKHR*                               pDisplays);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetDisplayModePropertiesKHR(
//VkPhysicalDevice                            physicalDevice,
//VkDisplayKHR                                display,
//uint32_t*                                   pPropertyCount,
//VkDisplayModePropertiesKHR*                 pProperties);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateDisplayModeKHR(
//VkPhysicalDevice                            physicalDevice,
//VkDisplayKHR                                display,
//const VkDisplayModeCreateInfoKHR*           pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkDisplayModeKHR*                           pMode);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetDisplayPlaneCapabilitiesKHR(
//VkPhysicalDevice                            physicalDevice,
//VkDisplayModeKHR                            mode,
//uint32_t                                    planeIndex,
//VkDisplayPlaneCapabilitiesKHR*              pCapabilities);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateDisplayPlaneSurfaceKHR(
//VkInstance                                  instance,
//const VkDisplaySurfaceCreateInfoKHR*        pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkSurfaceKHR*                               pSurface);