package identifiers

import kool.Ptr
import org.lwjgl.system.FunctionProvider
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.vulkan.EXTAcquireXlibDisplay
import org.lwjgl.vulkan.EXTDebugReport
import org.lwjgl.vulkan.VK10
import org.lwjgl.vulkan.VK11
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
    val vkDestroyInstance: Long
    val vkEnumeratePhysicalDevices: Long
    val vkGetPhysicalDeviceFeatures: Long
    val vkGetPhysicalDeviceFormatProperties: Long
    val vkGetPhysicalDeviceImageFormatProperties: Long
    val vkGetPhysicalDeviceProperties: Long
    val vkGetPhysicalDeviceQueueFamilyProperties: Long
    val vkGetPhysicalDeviceMemoryProperties: Long
    val vkCreateDevice: Long
    val vkEnumerateDeviceExtensionProperties: Long
    val vkEnumerateDeviceLayerProperties: Long
    val vkGetPhysicalDeviceSparseImageFormatProperties: Long
    // VK11
    val vkEnumeratePhysicalDeviceGroups: Long
    val vkGetPhysicalDeviceFeatures2: Long
    val vkGetPhysicalDeviceProperties2: Long
    val vkGetPhysicalDeviceFormatProperties2: Long
    val vkGetPhysicalDeviceImageFormatProperties2: Long
    val vkGetPhysicalDeviceQueueFamilyProperties2: Long
    val vkGetPhysicalDeviceMemoryProperties2: Long
    val vkGetPhysicalDeviceSparseImageFormatProperties2: Long
    val vkGetPhysicalDeviceExternalBufferProperties: Long
    val vkGetPhysicalDeviceExternalFenceProperties: Long
    val vkGetPhysicalDeviceExternalSemaphoreProperties: Long
    // EXT_acquire_xlib_display
    val vkAcquireXlibDisplayEXT: Long
    val vkGetRandROutputDisplayEXT: Long
    // EXT_calibrated_timestamps
    val vkGetPhysicalDeviceCalibrateableTimeDomainsEXT: Long
    // EXT_debug_report
    val vkCreateDebugReportCallbackEXT: Long
    val vkDestroyDebugReportCallbackEXT: Long
    val vkDebugReportMessageEXT: Long
    // EXT_debug_utils
    val vkCreateDebugUtilsMessengerEXT: Long
    val vkDestroyDebugUtilsMessengerEXT: Long
    val vkSubmitDebugUtilsMessageEXT: Long
    // EXT_direct_mode_display
    val vkReleaseDisplayEXT: Long
    // EXT_display_surface_counter
    val vkGetPhysicalDeviceSurfaceCapabilities2EXT: Long
    // EXT_full_screen_exclusive
    val vkGetPhysicalDeviceSurfacePresentModes2EXT: Long
    // EXT_headless_surface
    val vkCreateHeadlessSurfaceEXT: Long
    // EXT_metal_surface
    val vkCreateMetalSurfaceEXT: Long
    // EXT_sample_locations
    val vkGetPhysicalDeviceMultisamplePropertiesEXT: Long
    // KHR_device_group
    val vkGetPhysicalDevicePresentRectanglesKHR: Long
    // KHR_device_group_creation
    val vkEnumeratePhysicalDeviceGroupsKHR: Long
    // KHR_display
    val vkGetPhysicalDeviceDisplayPropertiesKHR: Long
    val vkGetPhysicalDeviceDisplayPlanePropertiesKHR: Long
    val vkGetDisplayPlaneSupportedDisplaysKHR: Long
    val vkGetDisplayModePropertiesKHR: Long
    val vkCreateDisplayModeKHR: Long
    val vkGetDisplayPlaneCapabilitiesKHR: Long
    val vkCreateDisplayPlaneSurfaceKHR: Long
    // KHR_external_fence_capabilities
    val vkGetPhysicalDeviceExternalFencePropertiesKHR: Long
    // KHR_external_memory_capabilities
    val vkGetPhysicalDeviceExternalBufferPropertiesKHR: Long
    // KHR_external_semaphore_capabilities
    val vkGetPhysicalDeviceExternalSemaphorePropertiesKHR: Long
    // KHR_get_display_properties2
    val vkGetPhysicalDeviceDisplayProperties2KHR: Long
    val vkGetPhysicalDeviceDisplayPlaneProperties2KHR: Long
    val vkGetDisplayModeProperties2KHR: Long
    val vkGetDisplayPlaneCapabilities2KHR: Long
    // KHR_get_physical_device_properties2
    val vkGetPhysicalDeviceFeatures2KHR: Long
    val vkGetPhysicalDeviceProperties2KHR: Long
    val vkGetPhysicalDeviceFormatProperties2KHR: Long
    val vkGetPhysicalDeviceImageFormatProperties2KHR: Long
    val vkGetPhysicalDeviceQueueFamilyProperties2KHR: Long
    val vkGetPhysicalDeviceMemoryProperties2KHR: Long
    val vkGetPhysicalDeviceSparseImageFormatProperties2KHR: Long
    // KHR_get_surface_capabilities2
    val vkGetPhysicalDeviceSurfaceCapabilities2KHR: Long
    val vkGetPhysicalDeviceSurfaceFormats2KHR: Long
    // KHR_surface
    val vkDestroySurfaceKHR: Long
    val vkGetPhysicalDeviceSurfaceSupportKHR: Long
    val vkGetPhysicalDeviceSurfaceCapabilitiesKHR: Long
    val vkGetPhysicalDeviceSurfaceFormatsKHR: Long
    val vkGetPhysicalDeviceSurfacePresentModesKHR: Long
    // KHR_wayland_surface
    val vkCreateWaylandSurfaceKHR: Long
    val vkGetPhysicalDeviceWaylandPresentationSupportKHR: Long
    // KHR_win32_surface
    val vkCreateWin32SurfaceKHR: Long
    val vkGetPhysicalDeviceWin32PresentationSupportKHR: Long
    // KHR_xlib_surface
    val vkCreateXlibSurfaceKHR: Long
    val vkGetPhysicalDeviceXlibPresentationSupportKHR: Long
    // MVK_macos_surface
    val vkCreateMacOSSurfaceMVK: Long
    // NV_cooperative_matrix
    val vkGetPhysicalDeviceCooperativeMatrixPropertiesNV: Long
    // NV_coverage_reduction_mode
    val vkGetPhysicalDeviceSupportedFramebufferMixedSamplesCombinationsNV: Long
    // NV_external_memory_capabilities
    val vkGetPhysicalDeviceExternalImageFormatPropertiesNV: Long
    // NVX_device_generated_commands
    val vkGetPhysicalDeviceGeneratedCommandsPropertiesNVX: Long
    /** When true, [VK10] is supported.  */
    val Vulkan10: Boolean
    /** When true, [VK11] is supported.  */
    val Vulkan11: Boolean
    /** When true, [EXTAcquireXlibDisplay] is supported.  */
//    val VK_EXT_acquire_xlib_display: Boolean
    /** When true, [EXTDebugReport] is supported.  */
    val VK_EXT_debug_report: Boolean
//    /** When true, [EXTDebugUtils] is supported.  */
//    val VK_EXT_debug_utils: Boolean
//    /** When true, [EXTDirectModeDisplay] is supported.  */
//    val VK_EXT_direct_mode_display: Boolean
//    /** When true, [EXTDisplaySurfaceCounter] is supported.  */
//    val VK_EXT_display_surface_counter: Boolean
//    /** When true, [EXTHeadlessSurface] is supported.  */
//    val VK_EXT_headless_surface: Boolean
//    /** When true, [EXTMetalSurface] is supported.  */
//    val VK_EXT_metal_surface: Boolean
//    /** When true, [EXTSwapchainColorspace] is supported.  */
//    val VK_EXT_swapchain_colorspace: Boolean
//    /** When true, [EXTValidationFeatures] is supported.  */
//    val VK_EXT_validation_features: Boolean
//    /** When true, [EXTValidationFlags] is supported.  */
//    val VK_EXT_validation_flags: Boolean
//    /** When true, [KHRDeviceGroupCreation] is supported.  */
//    val VK_KHR_device_group_creation: Boolean
//    /** When true, [KHRDisplay] is supported.  */
//    val VK_KHR_display: Boolean
//    /** When true, [KHRExternalFenceCapabilities] is supported.  */
//    val VK_KHR_external_fence_capabilities: Boolean
//    /** When true, [KHRExternalMemoryCapabilities] is supported.  */
//    val VK_KHR_external_memory_capabilities: Boolean
//    /** When true, [KHRExternalSemaphoreCapabilities] is supported.  */
//    val VK_KHR_external_semaphore_capabilities: Boolean
//    /** When true, [KHRGetDisplayProperties2] is supported.  */
//    val VK_KHR_get_display_properties2: Boolean
//    /** When true, [KHRGetPhysicalDeviceProperties2] is supported.  */
//    val VK_KHR_get_physical_device_properties2: Boolean
//    /** When true, [KHRGetSurfaceCapabilities2] is supported.  */
//    val VK_KHR_get_surface_capabilities2: Boolean
//    /** When true, [KHRSurface] is supported.  */
    val VK_KHR_surface: Boolean
//    /** When true, [KHRSurfaceProtectedCapabilities] is supported.  */
//    val VK_KHR_surface_protected_capabilities: Boolean
//    /** When true, [KHRWaylandSurface] is supported.  */
//    val VK_KHR_wayland_surface: Boolean
//    /** When true, [KHRWin32Surface] is supported.  */
//    val VK_KHR_win32_surface: Boolean
//    /** When true, [KHRXlibSurface] is supported.  */
//    val VK_KHR_xlib_surface: Boolean
//    /** When true, [MVKMacosSurface] is supported.  */
//    val VK_MVK_macos_surface: Boolean
//    /** When true, [NVExternalMemoryCapabilities] is supported.  */
//    val VK_NV_external_memory_capabilities: Boolean

    init {
        val caps = HashMap<String, Ptr>(79)
        operator fun String.invoke(): Ptr = caps[this] ?: NULL
        Vulkan10 = provider.checkCapsInstanceVK10(caps, ext)
        Vulkan11 = provider.checkCapsInstanceVK11(caps, ext)
//        VK_EXT_acquire_xlib_display = EXTAcquireXlibDisplay.checkCapsInstance(provider, caps, ext)
//        EXTCalibratedTimestamps.checkCapsInstance(provider, caps, deviceExt)
        VK_EXT_debug_report = "VK_EXT_debug_report" in ext && VK.checkExtension(
            "VK_EXT_debug_report",
            provider.isSupported("vkCreateDebugReportCallbackEXT", caps)
                    && provider.isSupported("vkDestroyDebugReportCallbackEXT", caps)
                    && provider.isSupported("vkDebugReportMessageEXT", caps)
        )
//        VK_EXT_debug_utils = EXTDebugUtils.checkCapsInstance(provider, caps, ext)
//        VK_EXT_direct_mode_display = EXTDirectModeDisplay.checkCapsInstance(provider, caps, ext)
//        VK_EXT_display_surface_counter = EXTDisplaySurfaceCounter.checkCapsInstance(provider, caps, ext)
//        EXTFullScreenExclusive.checkCapsInstance(provider, caps, deviceExt)
//        VK_EXT_headless_surface = EXTHeadlessSurface.checkCapsInstance(provider, caps, ext)
//        VK_EXT_metal_surface = EXTMetalSurface.checkCapsInstance(provider, caps, ext)
//        EXTSampleLocations.checkCapsInstance(provider, caps, deviceExt)
//        VK_EXT_swapchain_colorspace = ext.contains("VK_EXT_swapchain_colorspace")
//        VK_EXT_validation_features = ext.contains("VK_EXT_validation_features")
//        VK_EXT_validation_flags = ext.contains("VK_EXT_validation_flags")
//        KHRDeviceGroup.checkCapsInstance(provider, caps, deviceExt)
//        VK_KHR_device_group_creation = KHRDeviceGroupCreation.checkCapsInstance(provider, caps, ext)
//        VK_KHR_display = KHRDisplay.checkCapsInstance(provider, caps, ext)
//        VK_KHR_external_fence_capabilities = KHRExternalFenceCapabilities.checkCapsInstance(provider, caps, ext)
//        VK_KHR_external_memory_capabilities = KHRExternalMemoryCapabilities.checkCapsInstance(provider, caps, ext)
//        VK_KHR_external_semaphore_capabilities = KHRExternalSemaphoreCapabilities.checkCapsInstance(provider, caps, ext)
//        VK_KHR_get_display_properties2 = KHRGetDisplayProperties2.checkCapsInstance(provider, caps, ext)
//        VK_KHR_get_physical_device_properties2 = KHRGetPhysicalDeviceProperties2.checkCapsInstance(provider, caps, ext)
//        VK_KHR_get_surface_capabilities2 = KHRGetSurfaceCapabilities2.checkCapsInstance(provider, caps, ext)
        VK_KHR_surface = "VK_KHR_surface" in ext && VK.checkExtension(
            "VK_KHR_surface",
            provider.isSupported( "vkDestroySurfaceKHR", caps)
                    && provider.isSupported( "vkGetPhysicalDeviceSurfaceSupportKHR", caps)
                    && provider.isSupported( "vkGetPhysicalDeviceSurfaceCapabilitiesKHR", caps)
                    && provider.isSupported( "vkGetPhysicalDeviceSurfaceFormatsKHR", caps)
                    && provider.isSupported( "vkGetPhysicalDeviceSurfacePresentModesKHR", caps)
        )
//        VK_KHR_surface_protected_capabilities = ext.contains("VK_KHR_surface_protected_capabilities")
//        KHRSwapchain.checkCapsInstance(provider, caps, deviceExt)
//        VK_KHR_wayland_surface = KHRWaylandSurface.checkCapsInstance(provider, caps, ext)
//        VK_KHR_win32_surface = KHRWin32Surface.checkCapsInstance(provider, caps, ext)
//        VK_KHR_xlib_surface = KHRXlibSurface.checkCapsInstance(provider, caps, ext)
//        VK_MVK_macos_surface = MVKMacosSurface.checkCapsInstance(provider, caps, ext)
//        NVCooperativeMatrix.checkCapsInstance(provider, caps, deviceExt)
//        NVCoverageReductionMode.checkCapsInstance(provider, caps, deviceExt)
//        VK_NV_external_memory_capabilities = NVExternalMemoryCapabilities.checkCapsInstance(provider, caps, ext)
//        NVXDeviceGeneratedCommands.checkCapsInstance(provider, caps, deviceExt)
        vkDestroyInstance = "vkDestroyInstance"()
        vkEnumeratePhysicalDevices = "vkEnumeratePhysicalDevices"()
        vkGetPhysicalDeviceFeatures = "vkGetPhysicalDeviceFeatures"()
        vkGetPhysicalDeviceFormatProperties = "vkGetPhysicalDeviceFormatProperties"()
        vkGetPhysicalDeviceImageFormatProperties =
            "vkGetPhysicalDeviceImageFormatProperties"()
        vkGetPhysicalDeviceProperties = "vkGetPhysicalDeviceProperties"()
        vkGetPhysicalDeviceQueueFamilyProperties =
            "vkGetPhysicalDeviceQueueFamilyProperties"()
        vkGetPhysicalDeviceMemoryProperties = "vkGetPhysicalDeviceMemoryProperties"()
        vkCreateDevice = "vkCreateDevice"()
        vkEnumerateDeviceExtensionProperties = "vkEnumerateDeviceExtensionProperties"()
        vkEnumerateDeviceLayerProperties = "vkEnumerateDeviceLayerProperties"()
        vkGetPhysicalDeviceSparseImageFormatProperties =
            "vkGetPhysicalDeviceSparseImageFormatProperties"()
        vkEnumeratePhysicalDeviceGroups = "vkEnumeratePhysicalDeviceGroups"()
        vkGetPhysicalDeviceFeatures2 = "vkGetPhysicalDeviceFeatures2"()
        vkGetPhysicalDeviceProperties2 = "vkGetPhysicalDeviceProperties2"()
        vkGetPhysicalDeviceFormatProperties2 = "vkGetPhysicalDeviceFormatProperties2"()
        vkGetPhysicalDeviceImageFormatProperties2 =
            "vkGetPhysicalDeviceImageFormatProperties2"()
        vkGetPhysicalDeviceQueueFamilyProperties2 =
            "vkGetPhysicalDeviceQueueFamilyProperties2"()
        vkGetPhysicalDeviceMemoryProperties2 = "vkGetPhysicalDeviceMemoryProperties2"()
        vkGetPhysicalDeviceSparseImageFormatProperties2 =
            "vkGetPhysicalDeviceSparseImageFormatProperties2"()
        vkGetPhysicalDeviceExternalBufferProperties =
            "vkGetPhysicalDeviceExternalBufferProperties"()
        vkGetPhysicalDeviceExternalFenceProperties =
            "vkGetPhysicalDeviceExternalFenceProperties"()
        vkGetPhysicalDeviceExternalSemaphoreProperties =
            "vkGetPhysicalDeviceExternalSemaphoreProperties"()
        vkAcquireXlibDisplayEXT = "vkAcquireXlibDisplayEXT"()
        vkGetRandROutputDisplayEXT = "vkGetRandROutputDisplayEXT"()
        vkGetPhysicalDeviceCalibrateableTimeDomainsEXT =
            "vkGetPhysicalDeviceCalibrateableTimeDomainsEXT"()
        vkCreateDebugReportCallbackEXT = "vkCreateDebugReportCallbackEXT"()
        vkDestroyDebugReportCallbackEXT = "vkDestroyDebugReportCallbackEXT"()
        vkDebugReportMessageEXT = "vkDebugReportMessageEXT"()
        vkCreateDebugUtilsMessengerEXT = "vkCreateDebugUtilsMessengerEXT"()
        vkDestroyDebugUtilsMessengerEXT = "vkDestroyDebugUtilsMessengerEXT"()
        vkSubmitDebugUtilsMessageEXT = "vkSubmitDebugUtilsMessageEXT"()
        vkReleaseDisplayEXT = "vkReleaseDisplayEXT"()
        vkGetPhysicalDeviceSurfaceCapabilities2EXT =
            "vkGetPhysicalDeviceSurfaceCapabilities2EXT"()
        vkGetPhysicalDeviceSurfacePresentModes2EXT =
            "vkGetPhysicalDeviceSurfacePresentModes2EXT"()
        vkCreateHeadlessSurfaceEXT = "vkCreateHeadlessSurfaceEXT"()
        vkCreateMetalSurfaceEXT = "vkCreateMetalSurfaceEXT"()
        vkGetPhysicalDeviceMultisamplePropertiesEXT =
            "vkGetPhysicalDeviceMultisamplePropertiesEXT"()
        vkGetPhysicalDevicePresentRectanglesKHR =
            "vkGetPhysicalDevicePresentRectanglesKHR"()
        vkEnumeratePhysicalDeviceGroupsKHR = "vkEnumeratePhysicalDeviceGroupsKHR"()
        vkGetPhysicalDeviceDisplayPropertiesKHR =
            "vkGetPhysicalDeviceDisplayPropertiesKHR"()
        vkGetPhysicalDeviceDisplayPlanePropertiesKHR =
            "vkGetPhysicalDeviceDisplayPlanePropertiesKHR"()
        vkGetDisplayPlaneSupportedDisplaysKHR = "vkGetDisplayPlaneSupportedDisplaysKHR"()
        vkGetDisplayModePropertiesKHR = "vkGetDisplayModePropertiesKHR"()
        vkCreateDisplayModeKHR = "vkCreateDisplayModeKHR"()
        vkGetDisplayPlaneCapabilitiesKHR = "vkGetDisplayPlaneCapabilitiesKHR"()
        vkCreateDisplayPlaneSurfaceKHR = "vkCreateDisplayPlaneSurfaceKHR"()
        vkGetPhysicalDeviceExternalFencePropertiesKHR =
            "vkGetPhysicalDeviceExternalFencePropertiesKHR"()
        vkGetPhysicalDeviceExternalBufferPropertiesKHR =
            "vkGetPhysicalDeviceExternalBufferPropertiesKHR"()
        vkGetPhysicalDeviceExternalSemaphorePropertiesKHR =
            "vkGetPhysicalDeviceExternalSemaphorePropertiesKHR"()
        vkGetPhysicalDeviceDisplayProperties2KHR =
            "vkGetPhysicalDeviceDisplayProperties2KHR"()
        vkGetPhysicalDeviceDisplayPlaneProperties2KHR =
            "vkGetPhysicalDeviceDisplayPlaneProperties2KHR"()
        vkGetDisplayModeProperties2KHR = "vkGetDisplayModeProperties2KHR"()
        vkGetDisplayPlaneCapabilities2KHR = "vkGetDisplayPlaneCapabilities2KHR"()
        vkGetPhysicalDeviceFeatures2KHR = "vkGetPhysicalDeviceFeatures2KHR"()
        vkGetPhysicalDeviceProperties2KHR = "vkGetPhysicalDeviceProperties2KHR"()
        vkGetPhysicalDeviceFormatProperties2KHR =
            "vkGetPhysicalDeviceFormatProperties2KHR"()
        vkGetPhysicalDeviceImageFormatProperties2KHR =
            "vkGetPhysicalDeviceImageFormatProperties2KHR"()
        vkGetPhysicalDeviceQueueFamilyProperties2KHR =
            "vkGetPhysicalDeviceQueueFamilyProperties2KHR"()
        vkGetPhysicalDeviceMemoryProperties2KHR =
            "vkGetPhysicalDeviceMemoryProperties2KHR"()
        vkGetPhysicalDeviceSparseImageFormatProperties2KHR =
            "vkGetPhysicalDeviceSparseImageFormatProperties2KHR"()
        vkGetPhysicalDeviceSurfaceCapabilities2KHR =
            "vkGetPhysicalDeviceSurfaceCapabilities2KHR"()
        vkGetPhysicalDeviceSurfaceFormats2KHR = "vkGetPhysicalDeviceSurfaceFormats2KHR"()
        vkDestroySurfaceKHR = "vkDestroySurfaceKHR"()
        vkGetPhysicalDeviceSurfaceSupportKHR = "vkGetPhysicalDeviceSurfaceSupportKHR"()
        vkGetPhysicalDeviceSurfaceCapabilitiesKHR =
            "vkGetPhysicalDeviceSurfaceCapabilitiesKHR"()
        vkGetPhysicalDeviceSurfaceFormatsKHR = "vkGetPhysicalDeviceSurfaceFormatsKHR"()
        vkGetPhysicalDeviceSurfacePresentModesKHR =
            "vkGetPhysicalDeviceSurfacePresentModesKHR"()
        vkCreateWaylandSurfaceKHR = "vkCreateWaylandSurfaceKHR"()
        vkGetPhysicalDeviceWaylandPresentationSupportKHR =
            "vkGetPhysicalDeviceWaylandPresentationSupportKHR"()
        vkCreateWin32SurfaceKHR = "vkCreateWin32SurfaceKHR"()
        vkGetPhysicalDeviceWin32PresentationSupportKHR =
            "vkGetPhysicalDeviceWin32PresentationSupportKHR"()
        vkCreateXlibSurfaceKHR = "vkCreateXlibSurfaceKHR"()
        vkGetPhysicalDeviceXlibPresentationSupportKHR =
            "vkGetPhysicalDeviceXlibPresentationSupportKHR"()
        vkCreateMacOSSurfaceMVK = "vkCreateMacOSSurfaceMVK"()
        vkGetPhysicalDeviceCooperativeMatrixPropertiesNV =
            "vkGetPhysicalDeviceCooperativeMatrixPropertiesNV"()
        vkGetPhysicalDeviceSupportedFramebufferMixedSamplesCombinationsNV =
            "vkGetPhysicalDeviceSupportedFramebufferMixedSamplesCombinationsNV"()
        vkGetPhysicalDeviceExternalImageFormatPropertiesNV =
            "vkGetPhysicalDeviceExternalImageFormatPropertiesNV"()
        vkGetPhysicalDeviceGeneratedCommandsPropertiesNVX =
            "vkGetPhysicalDeviceGeneratedCommandsPropertiesNVX"()
    }
}


fun FunctionProvider.checkCapsInstanceVK10(caps: MutableMap<String, Ptr>, ext: Set<String>): Boolean =
    "Vulkan10" in ext && VK.checkExtension(
        "Vulkan10",
        isSupported("vkDestroyInstance", caps)
                && isSupported("vkEnumeratePhysicalDevices", caps)
                && isSupported("vkGetPhysicalDeviceFeatures", caps)
                && isSupported("vkGetPhysicalDeviceFormatProperties", caps)
                && isSupported("vkGetPhysicalDeviceImageFormatProperties", caps)
                && isSupported("vkGetPhysicalDeviceProperties", caps)
                && isSupported("vkGetPhysicalDeviceQueueFamilyProperties", caps)
                && isSupported("vkGetPhysicalDeviceMemoryProperties", caps)
                && isSupported("vkCreateDevice", caps)
                && isSupported("vkEnumerateDeviceExtensionProperties", caps)
                && isSupported("vkEnumerateDeviceLayerProperties", caps)
                && isSupported("vkGetPhysicalDeviceSparseImageFormatProperties", caps)
    )

fun FunctionProvider.checkCapsInstanceVK11(caps: MutableMap<String, Ptr>, ext: Set<String>): Boolean =
    "Vulkan11" in ext && VK.checkExtension(
        "Vulkan11",
        isSupported("vkEnumeratePhysicalDeviceGroups", caps)
                && isSupported("vkGetPhysicalDeviceFeatures2", caps)
                && isSupported("vkGetPhysicalDeviceProperties2", caps)
                && isSupported("vkGetPhysicalDeviceFormatProperties2", caps)
                && isSupported("vkGetPhysicalDeviceImageFormatProperties2", caps)
                && isSupported("vkGetPhysicalDeviceQueueFamilyProperties2", caps)
                && isSupported("vkGetPhysicalDeviceMemoryProperties2", caps)
                && isSupported("vkGetPhysicalDeviceSparseImageFormatProperties2", caps)
                && isSupported("vkGetPhysicalDeviceExternalBufferProperties", caps)
                && isSupported("vkGetPhysicalDeviceExternalFenceProperties", caps)
                && isSupported("vkGetPhysicalDeviceExternalSemaphoreProperties", caps)
    )