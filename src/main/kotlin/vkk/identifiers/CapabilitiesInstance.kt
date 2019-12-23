package vkk.identifiers

import kool.Adr
import kool.Ptr
import org.lwjgl.system.FunctionProvider
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.vulkan.*
import java.util.*

/** Defines the capabilities of a Vulkan `VkInstance`.  */
class CapabilitiesInstance internal constructor(
        provider: FunctionProvider,
        /** The Vulkan API version number.  */
        val apiVersion: Int,
        ext: Set<String>,
        deviceExt: Set<String>
) {
    // VK10
    val vkDestroyInstance: Adr
    val vkEnumeratePhysicalDevices: Adr
    val vkGetPhysicalDeviceFeatures: Adr
    val vkGetPhysicalDeviceFormatProperties: Adr
    val vkGetPhysicalDeviceImageFormatProperties: Adr
    val vkGetPhysicalDeviceProperties: Adr
    val vkGetPhysicalDeviceQueueFamilyProperties: Adr
    val vkGetPhysicalDeviceMemoryProperties: Adr
    val vkCreateDevice: Adr
    val vkEnumerateDeviceExtensionProperties: Adr
    val vkEnumerateDeviceLayerProperties: Adr
    val vkGetPhysicalDeviceSparseImageFormatProperties: Adr
    // VK11
    val vkEnumeratePhysicalDeviceGroups: Adr
    val vkGetPhysicalDeviceFeatures2: Adr
    val vkGetPhysicalDeviceProperties2: Adr
    val vkGetPhysicalDeviceFormatProperties2: Adr
    val vkGetPhysicalDeviceImageFormatProperties2: Adr
    val vkGetPhysicalDeviceQueueFamilyProperties2: Adr
    val vkGetPhysicalDeviceMemoryProperties2: Adr
    val vkGetPhysicalDeviceSparseImageFormatProperties2: Adr
    val vkGetPhysicalDeviceExternalBufferProperties: Adr
    val vkGetPhysicalDeviceExternalFenceProperties: Adr
    val vkGetPhysicalDeviceExternalSemaphoreProperties: Adr
    // EXT_acquire_xlib_display
    val vkAcquireXlibDisplayEXT: Adr
    val vkGetRandROutputDisplayEXT: Adr
    // EXT_calibrated_timestamps
    val vkGetPhysicalDeviceCalibrateableTimeDomainsEXT: Adr
    // EXT_debug_report
    val vkCreateDebugReportCallbackEXT: Adr
    val vkDestroyDebugReportCallbackEXT: Adr
    val vkDebugReportMessageEXT: Adr
    // EXT_debug_utils
    val vkCreateDebugUtilsMessengerEXT: Adr
    val vkDestroyDebugUtilsMessengerEXT: Adr
    val vkSubmitDebugUtilsMessageEXT: Adr
    // EXT_direct_mode_display
    val vkReleaseDisplayEXT: Adr
    // EXT_display_surface_counter
    val vkGetPhysicalDeviceSurfaceCapabilities2EXT: Adr
    // EXT_full_screen_exclusive
    val vkGetPhysicalDeviceSurfacePresentModes2EXT: Adr
    // EXT_headless_surface
    val vkCreateHeadlessSurfaceEXT: Adr
    // EXT_metal_surface
    val vkCreateMetalSurfaceEXT: Adr
    // EXT_sample_locations
    val vkGetPhysicalDeviceMultisamplePropertiesEXT: Adr
    // KHR_device_group
    val vkGetPhysicalDevicePresentRectanglesKHR: Adr
    // KHR_device_group_creation
    val vkEnumeratePhysicalDeviceGroupsKHR: Adr
    // KHR_display
    val vkGetPhysicalDeviceDisplayPropertiesKHR: Adr
    val vkGetPhysicalDeviceDisplayPlanePropertiesKHR: Adr
    val vkGetDisplayPlaneSupportedDisplaysKHR: Adr
    val vkGetDisplayModePropertiesKHR: Adr
    val vkCreateDisplayModeKHR: Adr
    val vkGetDisplayPlaneCapabilitiesKHR: Adr
    val vkCreateDisplayPlaneSurfaceKHR: Adr
    // KHR_external_fence_capabilities
    val vkGetPhysicalDeviceExternalFencePropertiesKHR: Adr
    // KHR_external_memory_capabilities
    val vkGetPhysicalDeviceExternalBufferPropertiesKHR: Adr
    // KHR_external_semaphore_capabilities
    val vkGetPhysicalDeviceExternalSemaphorePropertiesKHR: Adr
    // KHR_get_display_properties2
    val vkGetPhysicalDeviceDisplayProperties2KHR: Adr
    val vkGetPhysicalDeviceDisplayPlaneProperties2KHR: Adr
    val vkGetDisplayModeProperties2KHR: Adr
    val vkGetDisplayPlaneCapabilities2KHR: Adr
    // KHR_get_physical_device_properties2
    val vkGetPhysicalDeviceFeatures2KHR: Adr
    val vkGetPhysicalDeviceProperties2KHR: Adr
    val vkGetPhysicalDeviceFormatProperties2KHR: Adr
    val vkGetPhysicalDeviceImageFormatProperties2KHR: Adr
    val vkGetPhysicalDeviceQueueFamilyProperties2KHR: Adr
    val vkGetPhysicalDeviceMemoryProperties2KHR: Adr
    val vkGetPhysicalDeviceSparseImageFormatProperties2KHR: Adr
    // KHR_get_surface_capabilities2
    val vkGetPhysicalDeviceSurfaceCapabilities2KHR: Adr
    val vkGetPhysicalDeviceSurfaceFormats2KHR: Adr
    // KHR_surface
    val vkDestroySurfaceKHR: Adr
    val vkGetPhysicalDeviceSurfaceSupportKHR: Adr
    val vkGetPhysicalDeviceSurfaceCapabilitiesKHR: Adr
    val vkGetPhysicalDeviceSurfaceFormatsKHR: Adr
    val vkGetPhysicalDeviceSurfacePresentModesKHR: Adr
    // KHR_wayland_surface
    val vkCreateWaylandSurfaceKHR: Adr
    val vkGetPhysicalDeviceWaylandPresentationSupportKHR: Adr
    // KHR_win32_surface
    val vkCreateWin32SurfaceKHR: Adr
    val vkGetPhysicalDeviceWin32PresentationSupportKHR: Adr
    // KHR_xlib_surface
    val vkCreateXlibSurfaceKHR: Adr
    val vkGetPhysicalDeviceXlibPresentationSupportKHR: Adr
    // MVK_macos_surface
    val vkCreateMacOSSurfaceMVK: Adr
    // NV_cooperative_matrix
    val vkGetPhysicalDeviceCooperativeMatrixPropertiesNV: Adr
    // NV_coverage_reduction_mode
    val vkGetPhysicalDeviceSupportedFramebufferMixedSamplesCombinationsNV: Adr
    // NV_external_memory_capabilities
    val vkGetPhysicalDeviceExternalImageFormatPropertiesNV: Adr
    // NVX_device_generated_commands
    val vkGetPhysicalDeviceGeneratedCommandsPropertiesNVX: Adr
    /** When true, [VK10] is supported.  */
    val Vulkan10: Boolean
    /** When true, [VK11] is supported.  */
    val Vulkan11: Boolean
    /** When true, [EXTAcquireXlibDisplay] is supported.  */
    val VK_EXT_acquire_xlib_display: Boolean
    /** When true, [EXTDebugReport] is supported.  */
    val VK_EXT_debug_report: Boolean
    /** When true, [EXTDebugUtils] is supported.  */
    val VK_EXT_debug_utils: Boolean
    /** When true, [EXTDirectModeDisplay] is supported.  */
    val VK_EXT_direct_mode_display: Boolean
    /** When true, [EXTDisplaySurfaceCounter] is supported.  */
    val VK_EXT_display_surface_counter: Boolean
    /** When true, [EXTHeadlessSurface] is supported.  */
    val VK_EXT_headless_surface: Boolean
    /** When true, [EXTMetalSurface] is supported.  */
    val VK_EXT_metal_surface: Boolean
    /** When true, [EXTSwapchainColorspace] is supported.  */
    val VK_EXT_swapchain_colorspace: Boolean
    /** When true, [EXTValidationFeatures] is supported.  */
    val VK_EXT_validation_features: Boolean
    /** When true, [EXTValidationFlags] is supported.  */
    val VK_EXT_validation_flags: Boolean
    /** When true, [KHRDeviceGroupCreation] is supported.  */
    val VK_KHR_device_group_creation: Boolean
    /** When true, [KHRDisplay] is supported.  */
    val VK_KHR_display: Boolean
    /** When true, [KHRExternalFenceCapabilities] is supported.  */
    val VK_KHR_external_fence_capabilities: Boolean
    /** When true, [KHRExternalMemoryCapabilities] is supported.  */
    val VK_KHR_external_memory_capabilities: Boolean
    /** When true, [KHRExternalSemaphoreCapabilities] is supported.  */
    val VK_KHR_external_semaphore_capabilities: Boolean
    /** When true, [KHRGetDisplayProperties2] is supported.  */
    val VK_KHR_get_display_properties2: Boolean
    /** When true, [KHRGetPhysicalDeviceProperties2] is supported.  */
    val VK_KHR_get_physical_device_properties2: Boolean
    /** When true, [KHRGetSurfaceCapabilities2] is supported.  */
    val VK_KHR_get_surface_capabilities2: Boolean
    /** When true, [KHRSurface] is supported.  */
    val VK_KHR_surface: Boolean
    /** When true, [KHRSurfaceProtectedCapabilities] is supported.  */
    val VK_KHR_surface_protected_capabilities: Boolean
    /** When true, [KHRWaylandSurface] is supported.  */
    val VK_KHR_wayland_surface: Boolean
    /** When true, [KHRWin32Surface] is supported.  */
    val VK_KHR_win32_surface: Boolean
    /** When true, [KHRXlibSurface] is supported.  */
    val VK_KHR_xlib_surface: Boolean
    /** When true, [MVKMacosSurface] is supported.  */
    val VK_MVK_macos_surface: Boolean
    /** When true, [NVExternalMemoryCapabilities] is supported.  */
    val VK_NV_external_memory_capabilities: Boolean

    init {
        val caps = HashMap<String, Ptr>(79)
        operator fun String.invoke(): Ptr = caps[this] ?: NULL
        operator fun String.invoke(vararg exts: String): Boolean = this in ext && VK.checkExtension(this, provider.areSupported(caps, *exts))
        Vulkan10 = "Vulkan10"("vkDestroyInstance", "vkEnumeratePhysicalDevices", "vkGetPhysicalDeviceFeatures", "vkGetPhysicalDeviceFormatProperties", "vkGetPhysicalDeviceImageFormatProperties", "vkGetPhysicalDeviceProperties", "vkGetPhysicalDeviceQueueFamilyProperties", "vkGetPhysicalDeviceMemoryProperties", "vkCreateDevice", "vkEnumerateDeviceExtensionProperties", "vkEnumerateDeviceLayerProperties", "vkGetPhysicalDeviceSparseImageFormatProperties")
        Vulkan11 = "Vulkan11"("vkEnumeratePhysicalDeviceGroups", "vkGetPhysicalDeviceFeatures2", "vkGetPhysicalDeviceProperties2", "vkGetPhysicalDeviceFormatProperties2", "vkGetPhysicalDeviceImageFormatProperties2", "vkGetPhysicalDeviceQueueFamilyProperties2", "vkGetPhysicalDeviceMemoryProperties2", "vkGetPhysicalDeviceSparseImageFormatProperties2", "vkGetPhysicalDeviceExternalBufferProperties", "vkGetPhysicalDeviceExternalFenceProperties", "vkGetPhysicalDeviceExternalSemaphoreProperties")
        VK_EXT_acquire_xlib_display = "VK_EXT_acquire_xlib_display"("vkAcquireXlibDisplayEXT", "vkGetRandROutputDisplayEXT")
        "VK_EXT_calibrated_timestamps"("vkGetPhysicalDeviceCalibrateableTimeDomainsEXT")
        VK_EXT_debug_report = "VK_EXT_debug_report"("vkCreateDebugReportCallbackEXT", "vkDestroyDebugReportCallbackEXT", "vkDebugReportMessageEXT")
        VK_EXT_debug_utils = "VK_EXT_debug_utils"("vkCreateDebugUtilsMessengerEXT", "vkDestroyDebugUtilsMessengerEXT", "vkSubmitDebugUtilsMessageEXT")
        VK_EXT_direct_mode_display = "VK_EXT_direct_mode_display"("vkReleaseDisplayEXT")
        VK_EXT_display_surface_counter = "VK_EXT_display_surface_counter"("vkGetPhysicalDeviceSurfaceCapabilities2EXT")
        "VK_EXT_full_screen_exclusive"("vkGetPhysicalDeviceSurfacePresentModes2EXT")
        VK_EXT_headless_surface = "VK_EXT_headless_surface"("vkCreateHeadlessSurfaceEXT")
        VK_EXT_metal_surface = "VK_EXT_metal_surface"("vkCreateMetalSurfaceEXT")
        "VK_EXT_sample_locations"("vkGetPhysicalDeviceMultisamplePropertiesEXT")
        VK_EXT_swapchain_colorspace = "VK_EXT_swapchain_colorspace" in ext
        VK_EXT_validation_features = "VK_EXT_validation_features" in ext
        VK_EXT_validation_flags = "VK_EXT_validation_flags" in ext
        VK.checkExtension("VK_KHR_device_group", provider.isSupported("vkGetPhysicalDevicePresentRectanglesKHR", caps, "VK_KHR_surface" in ext))
        VK_KHR_device_group_creation = "VK_KHR_device_group_creation"("vkEnumeratePhysicalDeviceGroupsKHR")
        VK_KHR_display = "VK_KHR_display"("vkGetPhysicalDeviceDisplayPropertiesKHR", "vkGetPhysicalDeviceDisplayPlanePropertiesKHR", "vkGetDisplayPlaneSupportedDisplaysKHR", "vkGetDisplayModePropertiesKHR", "vkCreateDisplayModeKHR", "vkGetDisplayPlaneCapabilitiesKHR", "vkCreateDisplayPlaneSurfaceKHR")
        VK_KHR_external_fence_capabilities = "VK_KHR_external_fence_capabilities"("vkGetPhysicalDeviceExternalFencePropertiesKHR")
        VK_KHR_external_memory_capabilities = "VK_KHR_external_memory_capabilities"("vkGetPhysicalDeviceExternalBufferPropertiesKHR")
        VK_KHR_external_semaphore_capabilities = "VK_KHR_external_semaphore_capabilities"("vkGetPhysicalDeviceExternalSemaphorePropertiesKHR")
        VK_KHR_get_display_properties2 = "VK_KHR_get_display_properties2"("vkGetPhysicalDeviceDisplayProperties2KHR", "vkGetPhysicalDeviceDisplayPlaneProperties2KHR", "vkGetDisplayModeProperties2KHR", "vkGetDisplayPlaneCapabilities2KHR")
        VK_KHR_get_physical_device_properties2 = "VK_KHR_get_physical_device_properties2"("vkGetPhysicalDeviceFeatures2KHR", "vkGetPhysicalDeviceProperties2KHR", "vkGetPhysicalDeviceFormatProperties2KHR", "vkGetPhysicalDeviceImageFormatProperties2KHR", "vkGetPhysicalDeviceQueueFamilyProperties2KHR", "vkGetPhysicalDeviceMemoryProperties2KHR", "vkGetPhysicalDeviceSparseImageFormatProperties2KHR")
        VK_KHR_get_surface_capabilities2 = "VK_KHR_get_surface_capabilities2"("vkGetPhysicalDeviceSurfaceCapabilities2KHR", "vkGetPhysicalDeviceSurfaceFormats2KHR")
        VK_KHR_surface = "VK_KHR_surface"("vkDestroySurfaceKHR", "vkGetPhysicalDeviceSurfaceSupportKHR", "vkGetPhysicalDeviceSurfaceCapabilitiesKHR", "vkGetPhysicalDeviceSurfaceFormatsKHR", "vkGetPhysicalDeviceSurfacePresentModesKHR")
        VK_KHR_surface_protected_capabilities = "VK_KHR_surface_protected_capabilities" in ext
        VK.checkExtension("VK_KHR_swapchain", provider.isSupported("vkGetPhysicalDevicePresentRectanglesKHR", caps, "Vulkan11" in ext))
        VK_KHR_wayland_surface = "VK_KHR_wayland_surface"("vkCreateWaylandSurfaceKHR", "vkGetPhysicalDeviceWaylandPresentationSupportKHR")
        VK_KHR_win32_surface = "VK_KHR_win32_surface"("vkCreateWin32SurfaceKHR", "vkGetPhysicalDeviceWin32PresentationSupportKHR")
        VK_KHR_xlib_surface = "VK_KHR_xlib_surface"("vkCreateXlibSurfaceKHR", "vkGetPhysicalDeviceXlibPresentationSupportKHR")
        VK_MVK_macos_surface = "VK_MVK_macos_surface"("vkCreateMacOSSurfaceMVK")
        "VK_NV_cooperative_matrix"("vkGetPhysicalDeviceCooperativeMatrixPropertiesNV")
        "VK_NV_coverage_reduction_mode"("vkGetPhysicalDeviceSupportedFramebufferMixedSamplesCombinationsNV")
        VK_NV_external_memory_capabilities = "VK_NV_external_memory_capabilities"("vkGetPhysicalDeviceExternalImageFormatPropertiesNV")
        "VK_NVX_device_generated_commands"("vkGetPhysicalDeviceGeneratedCommandsPropertiesNVX")
        vkDestroyInstance = "vkDestroyInstance"()
        vkEnumeratePhysicalDevices = "vkEnumeratePhysicalDevices"()
        vkGetPhysicalDeviceFeatures = "vkGetPhysicalDeviceFeatures"()
        vkGetPhysicalDeviceFormatProperties = "vkGetPhysicalDeviceFormatProperties"()
        vkGetPhysicalDeviceImageFormatProperties = "vkGetPhysicalDeviceImageFormatProperties"()
        vkGetPhysicalDeviceProperties = "vkGetPhysicalDeviceProperties"()
        vkGetPhysicalDeviceQueueFamilyProperties = "vkGetPhysicalDeviceQueueFamilyProperties"()
        vkGetPhysicalDeviceMemoryProperties = "vkGetPhysicalDeviceMemoryProperties"()
        vkCreateDevice = "vkCreateDevice"()
        vkEnumerateDeviceExtensionProperties = "vkEnumerateDeviceExtensionProperties"()
        vkEnumerateDeviceLayerProperties = "vkEnumerateDeviceLayerProperties"()
        vkGetPhysicalDeviceSparseImageFormatProperties = "vkGetPhysicalDeviceSparseImageFormatProperties"()
        vkEnumeratePhysicalDeviceGroups = "vkEnumeratePhysicalDeviceGroups"()
        vkGetPhysicalDeviceFeatures2 = "vkGetPhysicalDeviceFeatures2"()
        vkGetPhysicalDeviceProperties2 = "vkGetPhysicalDeviceProperties2"()
        vkGetPhysicalDeviceFormatProperties2 = "vkGetPhysicalDeviceFormatProperties2"()
        vkGetPhysicalDeviceImageFormatProperties2 = "vkGetPhysicalDeviceImageFormatProperties2"()
        vkGetPhysicalDeviceQueueFamilyProperties2 = "vkGetPhysicalDeviceQueueFamilyProperties2"()
        vkGetPhysicalDeviceMemoryProperties2 = "vkGetPhysicalDeviceMemoryProperties2"()
        vkGetPhysicalDeviceSparseImageFormatProperties2 = "vkGetPhysicalDeviceSparseImageFormatProperties2"()
        vkGetPhysicalDeviceExternalBufferProperties = "vkGetPhysicalDeviceExternalBufferProperties"()
        vkGetPhysicalDeviceExternalFenceProperties = "vkGetPhysicalDeviceExternalFenceProperties"()
        vkGetPhysicalDeviceExternalSemaphoreProperties = "vkGetPhysicalDeviceExternalSemaphoreProperties"()
        vkAcquireXlibDisplayEXT = "vkAcquireXlibDisplayEXT"()
        vkGetRandROutputDisplayEXT = "vkGetRandROutputDisplayEXT"()
        vkGetPhysicalDeviceCalibrateableTimeDomainsEXT = "vkGetPhysicalDeviceCalibrateableTimeDomainsEXT"()
        vkCreateDebugReportCallbackEXT = "vkCreateDebugReportCallbackEXT"()
        vkDestroyDebugReportCallbackEXT = "vkDestroyDebugReportCallbackEXT"()
        vkDebugReportMessageEXT = "vkDebugReportMessageEXT"()
        vkCreateDebugUtilsMessengerEXT = "vkCreateDebugUtilsMessengerEXT"()
        vkDestroyDebugUtilsMessengerEXT = "vkDestroyDebugUtilsMessengerEXT"()
        vkSubmitDebugUtilsMessageEXT = "vkSubmitDebugUtilsMessageEXT"()
        vkReleaseDisplayEXT = "vkReleaseDisplayEXT"()
        vkGetPhysicalDeviceSurfaceCapabilities2EXT = "vkGetPhysicalDeviceSurfaceCapabilities2EXT"()
        vkGetPhysicalDeviceSurfacePresentModes2EXT = "vkGetPhysicalDeviceSurfacePresentModes2EXT"()
        vkCreateHeadlessSurfaceEXT = "vkCreateHeadlessSurfaceEXT"()
        vkCreateMetalSurfaceEXT = "vkCreateMetalSurfaceEXT"()
        vkGetPhysicalDeviceMultisamplePropertiesEXT = "vkGetPhysicalDeviceMultisamplePropertiesEXT"()
        vkGetPhysicalDevicePresentRectanglesKHR = "vkGetPhysicalDevicePresentRectanglesKHR"()
        vkEnumeratePhysicalDeviceGroupsKHR = "vkEnumeratePhysicalDeviceGroupsKHR"()
        vkGetPhysicalDeviceDisplayPropertiesKHR = "vkGetPhysicalDeviceDisplayPropertiesKHR"()
        vkGetPhysicalDeviceDisplayPlanePropertiesKHR = "vkGetPhysicalDeviceDisplayPlanePropertiesKHR"()
        vkGetDisplayPlaneSupportedDisplaysKHR = "vkGetDisplayPlaneSupportedDisplaysKHR"()
        vkGetDisplayModePropertiesKHR = "vkGetDisplayModePropertiesKHR"()
        vkCreateDisplayModeKHR = "vkCreateDisplayModeKHR"()
        vkGetDisplayPlaneCapabilitiesKHR = "vkGetDisplayPlaneCapabilitiesKHR"()
        vkCreateDisplayPlaneSurfaceKHR = "vkCreateDisplayPlaneSurfaceKHR"()
        vkGetPhysicalDeviceExternalFencePropertiesKHR = "vkGetPhysicalDeviceExternalFencePropertiesKHR"()
        vkGetPhysicalDeviceExternalBufferPropertiesKHR = "vkGetPhysicalDeviceExternalBufferPropertiesKHR"()
        vkGetPhysicalDeviceExternalSemaphorePropertiesKHR = "vkGetPhysicalDeviceExternalSemaphorePropertiesKHR"()
        vkGetPhysicalDeviceDisplayProperties2KHR = "vkGetPhysicalDeviceDisplayProperties2KHR"()
        vkGetPhysicalDeviceDisplayPlaneProperties2KHR = "vkGetPhysicalDeviceDisplayPlaneProperties2KHR"()
        vkGetDisplayModeProperties2KHR = "vkGetDisplayModeProperties2KHR"()
        vkGetDisplayPlaneCapabilities2KHR = "vkGetDisplayPlaneCapabilities2KHR"()
        vkGetPhysicalDeviceFeatures2KHR = "vkGetPhysicalDeviceFeatures2KHR"()
        vkGetPhysicalDeviceProperties2KHR = "vkGetPhysicalDeviceProperties2KHR"()
        vkGetPhysicalDeviceFormatProperties2KHR = "vkGetPhysicalDeviceFormatProperties2KHR"()
        vkGetPhysicalDeviceImageFormatProperties2KHR = "vkGetPhysicalDeviceImageFormatProperties2KHR"()
        vkGetPhysicalDeviceQueueFamilyProperties2KHR = "vkGetPhysicalDeviceQueueFamilyProperties2KHR"()
        vkGetPhysicalDeviceMemoryProperties2KHR = "vkGetPhysicalDeviceMemoryProperties2KHR"()
        vkGetPhysicalDeviceSparseImageFormatProperties2KHR = "vkGetPhysicalDeviceSparseImageFormatProperties2KHR"()
        vkGetPhysicalDeviceSurfaceCapabilities2KHR = "vkGetPhysicalDeviceSurfaceCapabilities2KHR"()
        vkGetPhysicalDeviceSurfaceFormats2KHR = "vkGetPhysicalDeviceSurfaceFormats2KHR"()
        vkDestroySurfaceKHR = "vkDestroySurfaceKHR"()
        vkGetPhysicalDeviceSurfaceSupportKHR = "vkGetPhysicalDeviceSurfaceSupportKHR"()
        vkGetPhysicalDeviceSurfaceCapabilitiesKHR = "vkGetPhysicalDeviceSurfaceCapabilitiesKHR"()
        vkGetPhysicalDeviceSurfaceFormatsKHR = "vkGetPhysicalDeviceSurfaceFormatsKHR"()
        vkGetPhysicalDeviceSurfacePresentModesKHR = "vkGetPhysicalDeviceSurfacePresentModesKHR"()
        vkCreateWaylandSurfaceKHR = "vkCreateWaylandSurfaceKHR"()
        vkGetPhysicalDeviceWaylandPresentationSupportKHR = "vkGetPhysicalDeviceWaylandPresentationSupportKHR"()
        vkCreateWin32SurfaceKHR = "vkCreateWin32SurfaceKHR"()
        vkGetPhysicalDeviceWin32PresentationSupportKHR = "vkGetPhysicalDeviceWin32PresentationSupportKHR"()
        vkCreateXlibSurfaceKHR = "vkCreateXlibSurfaceKHR"()
        vkGetPhysicalDeviceXlibPresentationSupportKHR = "vkGetPhysicalDeviceXlibPresentationSupportKHR"()
        vkCreateMacOSSurfaceMVK = "vkCreateMacOSSurfaceMVK"()
        vkGetPhysicalDeviceCooperativeMatrixPropertiesNV = "vkGetPhysicalDeviceCooperativeMatrixPropertiesNV"()
        vkGetPhysicalDeviceSupportedFramebufferMixedSamplesCombinationsNV = "vkGetPhysicalDeviceSupportedFramebufferMixedSamplesCombinationsNV"()
        vkGetPhysicalDeviceExternalImageFormatPropertiesNV = "vkGetPhysicalDeviceExternalImageFormatPropertiesNV"()
        vkGetPhysicalDeviceGeneratedCommandsPropertiesNVX = "vkGetPhysicalDeviceGeneratedCommandsPropertiesNVX"()
    }
}