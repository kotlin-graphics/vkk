package vkk

import glm_.BYTES
import glm_.L
import glm_.i
import glm_.vec4.Vec4
import kool.adr
import org.lwjgl.system.MemoryUtil.memPutFloat
import org.lwjgl.system.MemoryUtil.memUTF8
import org.lwjgl.vulkan.*
import java.nio.ByteBuffer

//typedef VkResult (VKAPI_PTR *PFN_vkCreateSharedSwapchainsKHR)(VkDevice device, uint32_t swapchainCount, const VkSwapchainCreateInfoKHR* pCreateInfos, const VkAllocationCallbacks* pAllocator, VkSwapchainKHR* pSwapchains);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateSharedSwapchainsKHR(
//VkDevice                                    device,
//uint32_t                                    swapchainCount,
//const VkSwapchainCreateInfoKHR*             pCreateInfos,
//const VkAllocationCallbacks*                pAllocator,
//VkSwapchainKHR*                             pSwapchains);
//#endif
//
//#ifdef VK_USE_PLATFORM_XLIB_KHR
//#define VK_KHR_xlib_surface 1
//#include <X11/Xlib.h>
//
//#define VK_KHR_XLIB_SURFACE_SPEC_VERSION  6
//#define VK_KHR_XLIB_SURFACE_EXTENSION_NAME "VK_KHR_xlib_surface"
//
//typedef VkFlags VkXlibSurfaceCreateFlagsKHR;
//
//typedef struct VkXlibSurfaceCreateInfoKHR {
//    VkStructureType                sType;
//    const void*                    pNext;
//    VkXlibSurfaceCreateFlagsKHR    flags;
//    Display*                       dpy;
//    Window                         window;
//} VkXlibSurfaceCreateInfoKHR;
//
//typedef VkResult (VKAPI_PTR *PFN_vkCreateXlibSurfaceKHR)(VkInstance instance, const VkXlibSurfaceCreateInfoKHR* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkSurfaceKHR* pSurface);
//typedef VkBool32 (VKAPI_PTR *PFN_vkGetPhysicalDeviceXlibPresentationSupportKHR)(VkPhysicalDevice physicalDevice, uint32_t queueFamilyIndex, Display* dpy, VisualID visualID);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateXlibSurfaceKHR(
//VkInstance                                  instance,
//const VkXlibSurfaceCreateInfoKHR*           pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkSurfaceKHR*                               pSurface);
//
//VKAPI_ATTR VkBool32 VKAPI_CALL vkGetPhysicalDeviceXlibPresentationSupportKHR(
//VkPhysicalDevice                            physicalDevice,
//uint32_t                                    queueFamilyIndex,
//Display*                                    dpy,
//VisualID                                    visualID);
//#endif
//#endif /* VK_USE_PLATFORM_XLIB_KHR */
//
//#ifdef VK_USE_PLATFORM_XCB_KHR
//#define VK_KHR_xcb_surface 1
//#include <xcb/xcb.h>
//
//#define VK_KHR_XCB_SURFACE_SPEC_VERSION   6
//#define VK_KHR_XCB_SURFACE_EXTENSION_NAME "VK_KHR_xcb_surface"
//
//typedef VkFlags VkXcbSurfaceCreateFlagsKHR;
//
//typedef struct VkXcbSurfaceCreateInfoKHR {
//    VkStructureType               sType;
//    const void*                   pNext;
//    VkXcbSurfaceCreateFlagsKHR    flags;
//    xcb_connection_t*             connection;
//    xcb_window_t                  window;
//} VkXcbSurfaceCreateInfoKHR;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkCreateXcbSurfaceKHR)(VkInstance instance, const VkXcbSurfaceCreateInfoKHR* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkSurfaceKHR* pSurface);
//typedef VkBool32 (VKAPI_PTR *PFN_vkGetPhysicalDeviceXcbPresentationSupportKHR)(VkPhysicalDevice physicalDevice, uint32_t queueFamilyIndex, xcb_connection_t* connection, xcb_visualid_t visual_id);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateXcbSurfaceKHR(
//VkInstance                                  instance,
//const VkXcbSurfaceCreateInfoKHR*            pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkSurfaceKHR*                               pSurface);
//
//VKAPI_ATTR VkBool32 VKAPI_CALL vkGetPhysicalDeviceXcbPresentationSupportKHR(
//VkPhysicalDevice                            physicalDevice,
//uint32_t                                    queueFamilyIndex,
//xcb_connection_t*                           connection,
//xcb_visualid_t                              visual_id);
//#endif
//#endif /* VK_USE_PLATFORM_XCB_KHR */
//
//#ifdef VK_USE_PLATFORM_WAYLAND_KHR
//#define VK_KHR_wayland_surface 1
//#include <wayland-client.h>
//
//#define VK_KHR_WAYLAND_SURFACE_SPEC_VERSION 6
//#define VK_KHR_WAYLAND_SURFACE_EXTENSION_NAME "VK_KHR_wayland_surface"
//
//typedef VkFlags VkWaylandSurfaceCreateFlagsKHR;
//
//typedef struct VkWaylandSurfaceCreateInfoKHR {
//    VkStructureType                   sType;
//    const void*                       pNext;
//    VkWaylandSurfaceCreateFlagsKHR    flags;
//    struct wl_display*                display;
//    struct wl_surface*                surface;
//} VkWaylandSurfaceCreateInfoKHR;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkCreateWaylandSurfaceKHR)(VkInstance instance, const VkWaylandSurfaceCreateInfoKHR* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkSurfaceKHR* pSurface);
//typedef VkBool32 (VKAPI_PTR *PFN_vkGetPhysicalDeviceWaylandPresentationSupportKHR)(VkPhysicalDevice physicalDevice, uint32_t queueFamilyIndex, struct wl_display* display);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateWaylandSurfaceKHR(
//VkInstance                                  instance,
//const VkWaylandSurfaceCreateInfoKHR*        pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkSurfaceKHR*                               pSurface);
//
//VKAPI_ATTR VkBool32 VKAPI_CALL vkGetPhysicalDeviceWaylandPresentationSupportKHR(
//VkPhysicalDevice                            physicalDevice,
//uint32_t                                    queueFamilyIndex,
//struct wl_display*                          display);
//#endif
//#endif /* VK_USE_PLATFORM_WAYLAND_KHR */
//
//#ifdef VK_USE_PLATFORM_MIR_KHR
//#define VK_KHR_mir_surface 1
//#include <mir_toolkit/client_types.h>
//
//#define VK_KHR_MIR_SURFACE_SPEC_VERSION   4
//#define VK_KHR_MIR_SURFACE_EXTENSION_NAME "VK_KHR_mir_surface"
//
//typedef VkFlags VkMirSurfaceCreateFlagsKHR;
//
//typedef struct VkMirSurfaceCreateInfoKHR {
//    VkStructureType               sType;
//    const void*                   pNext;
//    VkMirSurfaceCreateFlagsKHR    flags;
//    MirConnection*                connection;
//    MirSurface*                   mirSurface;
//} VkMirSurfaceCreateInfoKHR;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkCreateMirSurfaceKHR)(VkInstance instance, const VkMirSurfaceCreateInfoKHR* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkSurfaceKHR* pSurface);
//typedef VkBool32 (VKAPI_PTR *PFN_vkGetPhysicalDeviceMirPresentationSupportKHR)(VkPhysicalDevice physicalDevice, uint32_t queueFamilyIndex, MirConnection* connection);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateMirSurfaceKHR(
//VkInstance                                  instance,
//const VkMirSurfaceCreateInfoKHR*            pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkSurfaceKHR*                               pSurface);
//
//VKAPI_ATTR VkBool32 VKAPI_CALL vkGetPhysicalDeviceMirPresentationSupportKHR(
//VkPhysicalDevice                            physicalDevice,
//uint32_t                                    queueFamilyIndex,
//MirConnection*                              connection);
//#endif
//#endif /* VK_USE_PLATFORM_MIR_KHR */
//
//#ifdef VK_USE_PLATFORM_ANDROID_KHR
//#define VK_KHR_android_surface 1
//#include <android/native_window.h>
//
//#define VK_KHR_ANDROID_SURFACE_SPEC_VERSION 6
//#define VK_KHR_ANDROID_SURFACE_EXTENSION_NAME "VK_KHR_android_surface"
//
//typedef VkFlags VkAndroidSurfaceCreateFlagsKHR;
//
//typedef struct VkAndroidSurfaceCreateInfoKHR {
//    VkStructureType                   sType;
//    const void*                       pNext;
//    VkAndroidSurfaceCreateFlagsKHR    flags;
//    ANativeWindow*                    window;
//} VkAndroidSurfaceCreateInfoKHR;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkCreateAndroidSurfaceKHR)(VkInstance instance, const VkAndroidSurfaceCreateInfoKHR* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkSurfaceKHR* pSurface);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateAndroidSurfaceKHR(
//VkInstance                                  instance,
//const VkAndroidSurfaceCreateInfoKHR*        pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkSurfaceKHR*                               pSurface);
//#endif
//#endif /* VK_USE_PLATFORM_ANDROID_KHR */
//
//#ifdef VK_USE_PLATFORM_WIN32_KHR
//#define VK_KHR_win32_surface 1
//#include <windows.h>
//
//#define VK_KHR_WIN32_SURFACE_SPEC_VERSION 6
//#define VK_KHR_WIN32_SURFACE_EXTENSION_NAME "VK_KHR_win32_surface"
//
//typedef VkFlags VkWin32SurfaceCreateFlagsKHR;
//
//typedef struct VkWin32SurfaceCreateInfoKHR {
//    VkStructureType                 sType;
//    const void*                     pNext;
//    VkWin32SurfaceCreateFlagsKHR    flags;
//    HINSTANCE                       hinstance;
//    HWND                            hwnd;
//} VkWin32SurfaceCreateInfoKHR;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkCreateWin32SurfaceKHR)(VkInstance instance, const VkWin32SurfaceCreateInfoKHR* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkSurfaceKHR* pSurface);
//typedef VkBool32 (VKAPI_PTR *PFN_vkGetPhysicalDeviceWin32PresentationSupportKHR)(VkPhysicalDevice physicalDevice, uint32_t queueFamilyIndex);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateWin32SurfaceKHR(
//VkInstance                                  instance,
//const VkWin32SurfaceCreateInfoKHR*          pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkSurfaceKHR*                               pSurface);
//
//VKAPI_ATTR VkBool32 VKAPI_CALL vkGetPhysicalDeviceWin32PresentationSupportKHR(
//VkPhysicalDevice                            physicalDevice,
//uint32_t                                    queueFamilyIndex);
//#endif
//#endif /* VK_USE_PLATFORM_WIN32_KHR */
//
//#define VK_KHR_sampler_mirror_clamp_to_edge 1
//#define VK_KHR_SAMPLER_MIRROR_CLAMP_TO_EDGE_SPEC_VERSION 1
//#define VK_KHR_SAMPLER_MIRROR_CLAMP_TO_EDGE_EXTENSION_NAME "VK_KHR_sampler_mirror_clamp_to_edge"
//
//
//#define VK_KHR_get_physical_device_properties2 1
//#define VK_KHR_GET_PHYSICAL_DEVICE_PROPERTIES_2_SPEC_VERSION 1
//#define VK_KHR_GET_PHYSICAL_DEVICE_PROPERTIES_2_EXTENSION_NAME "VK_KHR_get_physical_device_properties2"
//
//typedef struct VkPhysicalDeviceFeatures2KHR {
//    VkStructureType             sType;
//    void*                       pNext;
//    VkPhysicalDeviceFeatures    features;
//} VkPhysicalDeviceFeatures2KHR;
//
//typedef struct VkPhysicalDeviceProperties2KHR {
//    VkStructureType               sType;
//    void*                         pNext;
//    VkPhysicalDeviceProperties    properties;
//} VkPhysicalDeviceProperties2KHR;
//
//typedef struct VkFormatProperties2KHR {
//    VkStructureType       sType;
//    void*                 pNext;
//    VkFormatProperties    formatProperties;
//} VkFormatProperties2KHR;
//
//typedef struct VkImageFormatProperties2KHR {
//    VkStructureType            sType;
//    void*                      pNext;
//    VkImageFormatProperties    imageFormatProperties;
//} VkImageFormatProperties2KHR;
//
//typedef struct VkPhysicalDeviceImageFormatInfo2KHR {
//    VkStructureType       sType;
//    const void*           pNext;
//    VkFormat              format;
//    VkImageType           type;
//    VkImageTiling         tiling;
//    VkImageUsageFlags     usage;
//    VkImageCreateFlags    flags;
//} VkPhysicalDeviceImageFormatInfo2KHR;
//
//typedef struct VkQueueFamilyProperties2KHR {
//    VkStructureType            sType;
//    void*                      pNext;
//    VkQueueFamilyProperties    queueFamilyProperties;
//} VkQueueFamilyProperties2KHR;
//
//typedef struct VkPhysicalDeviceMemoryProperties2KHR {
//    VkStructureType                     sType;
//    void*                               pNext;
//    VkPhysicalDeviceMemoryProperties    memoryProperties;
//} VkPhysicalDeviceMemoryProperties2KHR;
//
//typedef struct VkSparseImageFormatProperties2KHR {
//    VkStructureType                  sType;
//    void*                            pNext;
//    VkSparseImageFormatProperties    properties;
//} VkSparseImageFormatProperties2KHR;
//
//typedef struct VkPhysicalDeviceSparseImageFormatInfo2KHR {
//    VkStructureType          sType;
//    const void*              pNext;
//    VkFormat                 format;
//    VkImageType              type;
//    VkSampleCountFlagBits    samples;
//    VkImageUsageFlags        usage;
//    VkImageTiling            tiling;
//} VkPhysicalDeviceSparseImageFormatInfo2KHR;
//
//
//typedef void (VKAPI_PTR *PFN_vkGetPhysicalDeviceFeatures2KHR)(VkPhysicalDevice physicalDevice, VkPhysicalDeviceFeatures2KHR* pFeatures);
//typedef void (VKAPI_PTR *PFN_vkGetPhysicalDeviceProperties2KHR)(VkPhysicalDevice physicalDevice, VkPhysicalDeviceProperties2KHR* pProperties);
//typedef void (VKAPI_PTR *PFN_vkGetPhysicalDeviceFormatProperties2KHR)(VkPhysicalDevice physicalDevice, VkFormat format, VkFormatProperties2KHR* pFormatProperties);
//typedef VkResult (VKAPI_PTR *PFN_vkGetPhysicalDeviceImageFormatProperties2KHR)(VkPhysicalDevice physicalDevice, const VkPhysicalDeviceImageFormatInfo2KHR* pImageFormatInfo, VkImageFormatProperties2KHR* pImageFormatProperties);
//typedef void (VKAPI_PTR *PFN_vkGetPhysicalDeviceQueueFamilyProperties2KHR)(VkPhysicalDevice physicalDevice, uint32_t* pQueueFamilyPropertyCount, VkQueueFamilyProperties2KHR* pQueueFamilyProperties);
//typedef void (VKAPI_PTR *PFN_vkGetPhysicalDeviceMemoryProperties2KHR)(VkPhysicalDevice physicalDevice, VkPhysicalDeviceMemoryProperties2KHR* pMemoryProperties);
//typedef void (VKAPI_PTR *PFN_vkGetPhysicalDeviceSparseImageFormatProperties2KHR)(VkPhysicalDevice physicalDevice, const VkPhysicalDeviceSparseImageFormatInfo2KHR* pFormatInfo, uint32_t* pPropertyCount, VkSparseImageFormatProperties2KHR* pProperties);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR void VKAPI_CALL vkGetPhysicalDeviceFeatures2KHR(
//VkPhysicalDevice                            physicalDevice,
//VkPhysicalDeviceFeatures2KHR*               pFeatures);
//
//VKAPI_ATTR void VKAPI_CALL vkGetPhysicalDeviceProperties2KHR(
//VkPhysicalDevice                            physicalDevice,
//VkPhysicalDeviceProperties2KHR*             pProperties);
//
//VKAPI_ATTR void VKAPI_CALL vkGetPhysicalDeviceFormatProperties2KHR(
//VkPhysicalDevice                            physicalDevice,
//VkFormat                                    format,
//VkFormatProperties2KHR*                     pFormatProperties);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetPhysicalDeviceImageFormatProperties2KHR(
//VkPhysicalDevice                            physicalDevice,
//const VkPhysicalDeviceImageFormatInfo2KHR*  pImageFormatInfo,
//VkImageFormatProperties2KHR*                pImageFormatProperties);
//
//VKAPI_ATTR void VKAPI_CALL vkGetPhysicalDeviceQueueFamilyProperties2KHR(
//VkPhysicalDevice                            physicalDevice,
//uint32_t*                                   pQueueFamilyPropertyCount,
//VkQueueFamilyProperties2KHR*                pQueueFamilyProperties);
//
//VKAPI_ATTR void VKAPI_CALL vkGetPhysicalDeviceMemoryProperties2KHR(
//VkPhysicalDevice                            physicalDevice,
//VkPhysicalDeviceMemoryProperties2KHR*       pMemoryProperties);
//
//VKAPI_ATTR void VKAPI_CALL vkGetPhysicalDeviceSparseImageFormatProperties2KHR(
//VkPhysicalDevice                            physicalDevice,
//const VkPhysicalDeviceSparseImageFormatInfo2KHR* pFormatInfo,
//uint32_t*                                   pPropertyCount,
//VkSparseImageFormatProperties2KHR*          pProperties);
//#endif
//
//#define VK_KHR_shader_draw_parameters 1
//#define VK_KHR_SHADER_DRAW_PARAMETERS_SPEC_VERSION 1
//#define VK_KHR_SHADER_DRAW_PARAMETERS_EXTENSION_NAME "VK_KHR_shader_draw_parameters"
//
//
//#define VK_KHR_maintenance1 1
//#define VK_KHR_MAINTENANCE1_SPEC_VERSION  1
//#define VK_KHR_MAINTENANCE1_EXTENSION_NAME "VK_KHR_maintenance1"
//
//typedef VkFlags VkCommandPoolTrimFlagsKHR;
//
//typedef void (VKAPI_PTR *PFN_vkTrimCommandPoolKHR)(VkDevice device, VkCommandPool commandPool, VkCommandPoolTrimFlagsKHR flags);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR void VKAPI_CALL vkTrimCommandPoolKHR(
//VkDevice                                    device,
//VkCommandPool                               commandPool,
//VkCommandPoolTrimFlagsKHR                   flags);
//#endif
//
//#define VK_KHR_external_memory_capabilities 1
//#define VK_LUID_SIZE_KHR                  8
//#define VK_KHR_EXTERNAL_MEMORY_CAPABILITIES_SPEC_VERSION 1
//#define VK_KHR_EXTERNAL_MEMORY_CAPABILITIES_EXTENSION_NAME "VK_KHR_external_memory_capabilities"
//
//
//typedef enum VkExternalMemoryHandleTypeFlagBitsKHR {
//    VK_EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_FD_BIT_KHR = 0x00000001,
//    VK_EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_WIN32_BIT_KHR = 0x00000002,
//    VK_EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_WIN32_KMT_BIT_KHR = 0x00000004,
//    VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D11_TEXTURE_BIT_KHR = 0x00000008,
//    VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D11_TEXTURE_KMT_BIT_KHR = 0x00000010,
//    VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D12_HEAP_BIT_KHR = 0x00000020,
//    VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D12_RESOURCE_BIT_KHR = 0x00000040,
//    VK_EXTERNAL_MEMORY_HANDLE_TYPE_DMA_BUF_BIT_EXT = 0x00000200,
//    VK_EXTERNAL_MEMORY_HANDLE_TYPE_HOST_ALLOCATION_BIT_EXT = 0x00000080,
//    VK_EXTERNAL_MEMORY_HANDLE_TYPE_HOST_MAPPED_FOREIGN_MEMORY_BIT_EXT = 0x00000100,
//    VK_EXTERNAL_MEMORY_HANDLE_TYPE_FLAG_BITS_MAX_ENUM_KHR = 0x7FFFFFFF
//} VkExternalMemoryHandleTypeFlagBitsKHR;
//typedef VkFlags VkExternalMemoryHandleTypeFlagsKHR;
//
//typedef enum VkExternalMemoryFeatureFlagBitsKHR {
//    VK_EXTERNAL_MEMORY_FEATURE_DEDICATED_ONLY_BIT_KHR = 0x00000001,
//    VK_EXTERNAL_MEMORY_FEATURE_EXPORTABLE_BIT_KHR = 0x00000002,
//    VK_EXTERNAL_MEMORY_FEATURE_IMPORTABLE_BIT_KHR = 0x00000004,
//    VK_EXTERNAL_MEMORY_FEATURE_FLAG_BITS_MAX_ENUM_KHR = 0x7FFFFFFF
//} VkExternalMemoryFeatureFlagBitsKHR;
//typedef VkFlags VkExternalMemoryFeatureFlagsKHR;
//
//typedef struct VkExternalMemoryPropertiesKHR {
//    VkExternalMemoryFeatureFlagsKHR       externalMemoryFeatures;
//    VkExternalMemoryHandleTypeFlagsKHR    exportFromImportedHandleTypes;
//    VkExternalMemoryHandleTypeFlagsKHR    compatibleHandleTypes;
//} VkExternalMemoryPropertiesKHR;
//
//typedef struct VkPhysicalDeviceExternalImageFormatInfoKHR {
//    VkStructureType                          sType;
//    const void*                              pNext;
//    VkExternalMemoryHandleTypeFlagBitsKHR    handleType;
//} VkPhysicalDeviceExternalImageFormatInfoKHR;
//
//typedef struct VkExternalImageFormatPropertiesKHR {
//    VkStructureType                  sType;
//    void*                            pNext;
//    VkExternalMemoryPropertiesKHR    externalMemoryProperties;
//} VkExternalImageFormatPropertiesKHR;
//
//typedef struct VkPhysicalDeviceExternalBufferInfoKHR {
//    VkStructureType                          sType;
//    const void*                              pNext;
//    VkBufferCreateFlags                      flags;
//    VkBufferUsageFlags                       usage;
//    VkExternalMemoryHandleTypeFlagBitsKHR    handleType;
//} VkPhysicalDeviceExternalBufferInfoKHR;
//
//typedef struct VkExternalBufferPropertiesKHR {
//    VkStructureType                  sType;
//    void*                            pNext;
//    VkExternalMemoryPropertiesKHR    externalMemoryProperties;
//} VkExternalBufferPropertiesKHR;
//
//typedef struct VkPhysicalDeviceIDPropertiesKHR {
//    VkStructureType    sType;
//    void*              pNext;
//    uint8_t            deviceUUID[VK_UUID_SIZE];
//    uint8_t            driverUUID[VK_UUID_SIZE];
//    uint8_t            deviceLUID[VK_LUID_SIZE_KHR];
//    uint32_t           deviceNodeMask;
//    VkBool32           deviceLUIDValid;
//} VkPhysicalDeviceIDPropertiesKHR;
//
//
//typedef void (VKAPI_PTR *PFN_vkGetPhysicalDeviceExternalBufferPropertiesKHR)(VkPhysicalDevice physicalDevice, const VkPhysicalDeviceExternalBufferInfoKHR* pExternalBufferInfo, VkExternalBufferPropertiesKHR* pExternalBufferProperties);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR void VKAPI_CALL vkGetPhysicalDeviceExternalBufferPropertiesKHR(
//VkPhysicalDevice                            physicalDevice,
//const VkPhysicalDeviceExternalBufferInfoKHR* pExternalBufferInfo,
//VkExternalBufferPropertiesKHR*              pExternalBufferProperties);
//#endif
//
//#define VK_KHR_external_memory 1
//#define VK_KHR_EXTERNAL_MEMORY_SPEC_VERSION 1
//#define VK_KHR_EXTERNAL_MEMORY_EXTENSION_NAME "VK_KHR_external_memory"
//#define VK_QUEUE_FAMILY_EXTERNAL_KHR      (~0U-1)
//
//typedef struct VkExternalMemoryImageCreateInfoKHR {
//    VkStructureType                       sType;
//    const void*                           pNext;
//    VkExternalMemoryHandleTypeFlagsKHR    handleTypes;
//} VkExternalMemoryImageCreateInfoKHR;
//
//typedef struct VkExternalMemoryBufferCreateInfoKHR {
//    VkStructureType                       sType;
//    const void*                           pNext;
//    VkExternalMemoryHandleTypeFlagsKHR    handleTypes;
//} VkExternalMemoryBufferCreateInfoKHR;
//
//typedef struct VkExportMemoryAllocateInfoKHR {
//    VkStructureType                       sType;
//    const void*                           pNext;
//    VkExternalMemoryHandleTypeFlagsKHR    handleTypes;
//} VkExportMemoryAllocateInfoKHR;
//
//
//
//#ifdef VK_USE_PLATFORM_WIN32_KHR
//#define VK_KHR_external_memory_win32 1
//#define VK_KHR_EXTERNAL_MEMORY_WIN32_SPEC_VERSION 1
//#define VK_KHR_EXTERNAL_MEMORY_WIN32_EXTENSION_NAME "VK_KHR_external_memory_win32"
//
//typedef struct VkImportMemoryWin32HandleInfoKHR {
//    VkStructureType                          sType;
//    const void*                              pNext;
//    VkExternalMemoryHandleTypeFlagBitsKHR    handleType;
//    HANDLE                                   handle;
//    LPCWSTR                                  name;
//} VkImportMemoryWin32HandleInfoKHR;
//
//typedef struct VkExportMemoryWin32HandleInfoKHR {
//    VkStructureType               sType;
//    const void*                   pNext;
//    const SECURITY_ATTRIBUTES*    pAttributes;
//    DWORD                         dwAccess;
//    LPCWSTR                       name;
//} VkExportMemoryWin32HandleInfoKHR;
//
//typedef struct VkMemoryWin32HandlePropertiesKHR {
//    VkStructureType    sType;
//    void*              pNext;
//    uint32_t           memoryTypeBits;
//} VkMemoryWin32HandlePropertiesKHR;
//
//typedef struct VkMemoryGetWin32HandleInfoKHR {
//    VkStructureType                          sType;
//    const void*                              pNext;
//    VkDeviceMemory                           memory;
//    VkExternalMemoryHandleTypeFlagBitsKHR    handleType;
//} VkMemoryGetWin32HandleInfoKHR;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkGetMemoryWin32HandleKHR)(VkDevice device, const VkMemoryGetWin32HandleInfoKHR* pGetWin32HandleInfo, HANDLE* pHandle);
//typedef VkResult (VKAPI_PTR *PFN_vkGetMemoryWin32HandlePropertiesKHR)(VkDevice device, VkExternalMemoryHandleTypeFlagBitsKHR handleType, HANDLE handle, VkMemoryWin32HandlePropertiesKHR* pMemoryWin32HandleProperties);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkGetMemoryWin32HandleKHR(
//VkDevice                                    device,
//const VkMemoryGetWin32HandleInfoKHR*        pGetWin32HandleInfo,
//HANDLE*                                     pHandle);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetMemoryWin32HandlePropertiesKHR(
//VkDevice                                    device,
//VkExternalMemoryHandleTypeFlagBitsKHR       handleType,
//HANDLE                                      handle,
//VkMemoryWin32HandlePropertiesKHR*           pMemoryWin32HandleProperties);
//#endif
//#endif /* VK_USE_PLATFORM_WIN32_KHR */
//
//#define VK_KHR_external_memory_fd 1
//#define VK_KHR_EXTERNAL_MEMORY_FD_SPEC_VERSION 1
//#define VK_KHR_EXTERNAL_MEMORY_FD_EXTENSION_NAME "VK_KHR_external_memory_fd"
//
//typedef struct VkImportMemoryFdInfoKHR {
//    VkStructureType                          sType;
//    const void*                              pNext;
//    VkExternalMemoryHandleTypeFlagBitsKHR    handleType;
//    int                                      fd;
//} VkImportMemoryFdInfoKHR;
//
//typedef struct VkMemoryFdPropertiesKHR {
//    VkStructureType    sType;
//    void*              pNext;
//    uint32_t           memoryTypeBits;
//} VkMemoryFdPropertiesKHR;
//
//typedef struct VkMemoryGetFdInfoKHR {
//    VkStructureType                          sType;
//    const void*                              pNext;
//    VkDeviceMemory                           memory;
//    VkExternalMemoryHandleTypeFlagBitsKHR    handleType;
//} VkMemoryGetFdInfoKHR;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkGetMemoryFdKHR)(VkDevice device, const VkMemoryGetFdInfoKHR* pGetFdInfo, int* pFd);
//typedef VkResult (VKAPI_PTR *PFN_vkGetMemoryFdPropertiesKHR)(VkDevice device, VkExternalMemoryHandleTypeFlagBitsKHR handleType, int fd, VkMemoryFdPropertiesKHR* pMemoryFdProperties);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkGetMemoryFdKHR(
//VkDevice                                    device,
//const VkMemoryGetFdInfoKHR*                 pGetFdInfo,
//int*                                        pFd);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetMemoryFdPropertiesKHR(
//VkDevice                                    device,
//VkExternalMemoryHandleTypeFlagBitsKHR       handleType,
//int                                         fd,
//VkMemoryFdPropertiesKHR*                    pMemoryFdProperties);
//#endif
//
//#ifdef VK_USE_PLATFORM_WIN32_KHR
//#define VK_KHR_win32_keyed_mutex 1
//#define VK_KHR_WIN32_KEYED_MUTEX_SPEC_VERSION 1
//#define VK_KHR_WIN32_KEYED_MUTEX_EXTENSION_NAME "VK_KHR_win32_keyed_mutex"
//
//typedef struct VkWin32KeyedMutexAcquireReleaseInfoKHR {
//    VkStructureType          sType;
//    const void*              pNext;
//    uint32_t                 acquireCount;
//    const VkDeviceMemory*    pAcquireSyncs;
//    const uint64_t*          pAcquireKeys;
//    const uint32_t*          pAcquireTimeouts;
//    uint32_t                 releaseCount;
//    const VkDeviceMemory*    pReleaseSyncs;
//    const uint64_t*          pReleaseKeys;
//} VkWin32KeyedMutexAcquireReleaseInfoKHR;
//
//
//#endif /* VK_USE_PLATFORM_WIN32_KHR */
//
//#define VK_KHR_external_semaphore_capabilities 1
//#define VK_KHR_EXTERNAL_SEMAPHORE_CAPABILITIES_SPEC_VERSION 1
//#define VK_KHR_EXTERNAL_SEMAPHORE_CAPABILITIES_EXTENSION_NAME "VK_KHR_external_semaphore_capabilities"
//
//
//typedef enum VkExternalSemaphoreHandleTypeFlagBitsKHR {
//    VK_EXTERNAL_SEMAPHORE_HANDLE_TYPE_OPAQUE_FD_BIT_KHR = 0x00000001,
//    VK_EXTERNAL_SEMAPHORE_HANDLE_TYPE_OPAQUE_WIN32_BIT_KHR = 0x00000002,
//    VK_EXTERNAL_SEMAPHORE_HANDLE_TYPE_OPAQUE_WIN32_KMT_BIT_KHR = 0x00000004,
//    VK_EXTERNAL_SEMAPHORE_HANDLE_TYPE_D3D12_FENCE_BIT_KHR = 0x00000008,
//    VK_EXTERNAL_SEMAPHORE_HANDLE_TYPE_SYNC_FD_BIT_KHR = 0x00000010,
//    VK_EXTERNAL_SEMAPHORE_HANDLE_TYPE_FLAG_BITS_MAX_ENUM_KHR = 0x7FFFFFFF
//} VkExternalSemaphoreHandleTypeFlagBitsKHR;
//typedef VkFlags VkExternalSemaphoreHandleTypeFlagsKHR;
//
//typedef enum VkExternalSemaphoreFeatureFlagBitsKHR {
//    VK_EXTERNAL_SEMAPHORE_FEATURE_EXPORTABLE_BIT_KHR = 0x00000001,
//    VK_EXTERNAL_SEMAPHORE_FEATURE_IMPORTABLE_BIT_KHR = 0x00000002,
//    VK_EXTERNAL_SEMAPHORE_FEATURE_FLAG_BITS_MAX_ENUM_KHR = 0x7FFFFFFF
//} VkExternalSemaphoreFeatureFlagBitsKHR;
//typedef VkFlags VkExternalSemaphoreFeatureFlagsKHR;
//
//typedef struct VkPhysicalDeviceExternalSemaphoreInfoKHR {
//    VkStructureType                             sType;
//    const void*                                 pNext;
//    VkExternalSemaphoreHandleTypeFlagBitsKHR    handleType;
//} VkPhysicalDeviceExternalSemaphoreInfoKHR;
//
//typedef struct VkExternalSemaphorePropertiesKHR {
//    VkStructureType                          sType;
//    void*                                    pNext;
//    VkExternalSemaphoreHandleTypeFlagsKHR    exportFromImportedHandleTypes;
//    VkExternalSemaphoreHandleTypeFlagsKHR    compatibleHandleTypes;
//    VkExternalSemaphoreFeatureFlagsKHR       externalSemaphoreFeatures;
//} VkExternalSemaphorePropertiesKHR;
//
//
//typedef void (VKAPI_PTR *PFN_vkGetPhysicalDeviceExternalSemaphorePropertiesKHR)(VkPhysicalDevice physicalDevice, const VkPhysicalDeviceExternalSemaphoreInfoKHR* pExternalSemaphoreInfo, VkExternalSemaphorePropertiesKHR* pExternalSemaphoreProperties);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR void VKAPI_CALL vkGetPhysicalDeviceExternalSemaphorePropertiesKHR(
//VkPhysicalDevice                            physicalDevice,
//const VkPhysicalDeviceExternalSemaphoreInfoKHR* pExternalSemaphoreInfo,
//VkExternalSemaphorePropertiesKHR*           pExternalSemaphoreProperties);
//#endif
//
//#define VK_KHR_external_semaphore 1
//#define VK_KHR_EXTERNAL_SEMAPHORE_SPEC_VERSION 1
//#define VK_KHR_EXTERNAL_SEMAPHORE_EXTENSION_NAME "VK_KHR_external_semaphore"
//
//
//typedef enum VkSemaphoreImportFlagBitsKHR {
//    VK_SEMAPHORE_IMPORT_TEMPORARY_BIT_KHR = 0x00000001,
//    VK_SEMAPHORE_IMPORT_FLAG_BITS_MAX_ENUM_KHR = 0x7FFFFFFF
//} VkSemaphoreImportFlagBitsKHR;
//typedef VkFlags VkSemaphoreImportFlagsKHR;
//
//typedef struct VkExportSemaphoreCreateInfoKHR {
//    VkStructureType                          sType;
//    const void*                              pNext;
//    VkExternalSemaphoreHandleTypeFlagsKHR    handleTypes;
//} VkExportSemaphoreCreateInfoKHR;
//
//
//
//#ifdef VK_USE_PLATFORM_WIN32_KHR
//#define VK_KHR_external_semaphore_win32 1
//#define VK_KHR_EXTERNAL_SEMAPHORE_WIN32_SPEC_VERSION 1
//#define VK_KHR_EXTERNAL_SEMAPHORE_WIN32_EXTENSION_NAME "VK_KHR_external_semaphore_win32"
//
//typedef struct VkImportSemaphoreWin32HandleInfoKHR {
//    VkStructureType                             sType;
//    const void*                                 pNext;
//    VkSemaphore                                 semaphore;
//    VkSemaphoreImportFlagsKHR                   flags;
//    VkExternalSemaphoreHandleTypeFlagBitsKHR    handleType;
//    HANDLE                                      handle;
//    LPCWSTR                                     name;
//} VkImportSemaphoreWin32HandleInfoKHR;
//
//typedef struct VkExportSemaphoreWin32HandleInfoKHR {
//    VkStructureType               sType;
//    const void*                   pNext;
//    const SECURITY_ATTRIBUTES*    pAttributes;
//    DWORD                         dwAccess;
//    LPCWSTR                       name;
//} VkExportSemaphoreWin32HandleInfoKHR;
//
//typedef struct VkD3D12FenceSubmitInfoKHR {
//    VkStructureType    sType;
//    const void*        pNext;
//    uint32_t           waitSemaphoreValuesCount;
//    const uint64_t*    pWaitSemaphoreValues;
//    uint32_t           signalSemaphoreValuesCount;
//    const uint64_t*    pSignalSemaphoreValues;
//} VkD3D12FenceSubmitInfoKHR;
//
//typedef struct VkSemaphoreGetWin32HandleInfoKHR {
//    VkStructureType                             sType;
//    const void*                                 pNext;
//    VkSemaphore                                 semaphore;
//    VkExternalSemaphoreHandleTypeFlagBitsKHR    handleType;
//} VkSemaphoreGetWin32HandleInfoKHR;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkImportSemaphoreWin32HandleKHR)(VkDevice device, const VkImportSemaphoreWin32HandleInfoKHR* pImportSemaphoreWin32HandleInfo);
//typedef VkResult (VKAPI_PTR *PFN_vkGetSemaphoreWin32HandleKHR)(VkDevice device, const VkSemaphoreGetWin32HandleInfoKHR* pGetWin32HandleInfo, HANDLE* pHandle);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkImportSemaphoreWin32HandleKHR(
//VkDevice                                    device,
//const VkImportSemaphoreWin32HandleInfoKHR*  pImportSemaphoreWin32HandleInfo);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetSemaphoreWin32HandleKHR(
//VkDevice                                    device,
//const VkSemaphoreGetWin32HandleInfoKHR*     pGetWin32HandleInfo,
//HANDLE*                                     pHandle);
//#endif
//#endif /* VK_USE_PLATFORM_WIN32_KHR */
//
//#define VK_KHR_external_semaphore_fd 1
//#define VK_KHR_EXTERNAL_SEMAPHORE_FD_SPEC_VERSION 1
//#define VK_KHR_EXTERNAL_SEMAPHORE_FD_EXTENSION_NAME "VK_KHR_external_semaphore_fd"
//
//typedef struct VkImportSemaphoreFdInfoKHR {
//    VkStructureType                             sType;
//    const void*                                 pNext;
//    VkSemaphore                                 semaphore;
//    VkSemaphoreImportFlagsKHR                   flags;
//    VkExternalSemaphoreHandleTypeFlagBitsKHR    handleType;
//    int                                         fd;
//} VkImportSemaphoreFdInfoKHR;
//
//typedef struct VkSemaphoreGetFdInfoKHR {
//    VkStructureType                             sType;
//    const void*                                 pNext;
//    VkSemaphore                                 semaphore;
//    VkExternalSemaphoreHandleTypeFlagBitsKHR    handleType;
//} VkSemaphoreGetFdInfoKHR;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkImportSemaphoreFdKHR)(VkDevice device, const VkImportSemaphoreFdInfoKHR* pImportSemaphoreFdInfo);
//typedef VkResult (VKAPI_PTR *PFN_vkGetSemaphoreFdKHR)(VkDevice device, const VkSemaphoreGetFdInfoKHR* pGetFdInfo, int* pFd);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkImportSemaphoreFdKHR(
//VkDevice                                    device,
//const VkImportSemaphoreFdInfoKHR*           pImportSemaphoreFdInfo);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetSemaphoreFdKHR(
//VkDevice                                    device,
//const VkSemaphoreGetFdInfoKHR*              pGetFdInfo,
//int*                                        pFd);
//#endif
//
//#define VK_KHR_push_descriptor 1
//#define VK_KHR_PUSH_DESCRIPTOR_SPEC_VERSION 1
//#define VK_KHR_PUSH_DESCRIPTOR_EXTENSION_NAME "VK_KHR_push_descriptor"
//
//typedef struct VkPhysicalDevicePushDescriptorPropertiesKHR {
//    VkStructureType    sType;
//    void*              pNext;
//    uint32_t           maxPushDescriptors;
//} VkPhysicalDevicePushDescriptorPropertiesKHR;
//
//
//typedef void (VKAPI_PTR *PFN_vkCmdPushDescriptorSetKHR)(VkCommandBuffer commandBuffer, VkPipelineBindPoint pipelineBindPoint, VkPipelineLayout layout, uint32_t set, uint32_t descriptorWriteCount, const VkWriteDescriptorSet* pDescriptorWrites);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR void VKAPI_CALL vkCmdPushDescriptorSetKHR(
//VkCommandBuffer                             commandBuffer,
//VkPipelineBindPoint                         pipelineBindPoint,
//VkPipelineLayout                            layout,
//uint32_t                                    set,
//uint32_t                                    descriptorWriteCount,
//const VkWriteDescriptorSet*                 pDescriptorWrites);
//#endif
//
//#define VK_KHR_16bit_storage 1
//#define VK_KHR_16BIT_STORAGE_SPEC_VERSION 1
//#define VK_KHR_16BIT_STORAGE_EXTENSION_NAME "VK_KHR_16bit_storage"
//
//typedef struct VkPhysicalDevice16BitStorageFeaturesKHR {
//    VkStructureType    sType;
//    void*              pNext;
//    VkBool32           storageBuffer16BitAccess;
//    VkBool32           uniformAndStorageBuffer16BitAccess;
//    VkBool32           storagePushConstant16;
//    VkBool32           storageInputOutput16;
//} VkPhysicalDevice16BitStorageFeaturesKHR;
//
//
//
//#define VK_KHR_incremental_present 1
//#define VK_KHR_INCREMENTAL_PRESENT_SPEC_VERSION 1
//#define VK_KHR_INCREMENTAL_PRESENT_EXTENSION_NAME "VK_KHR_incremental_present"
//
//typedef struct VkRectLayerKHR {
//    VkOffset2D    offset;
//    VkExtent2D    extent;
//    uint32_t      layer;
//} VkRectLayerKHR;
//
//typedef struct VkPresentRegionKHR {
//    uint32_t                 rectangleCount;
//    const VkRectLayerKHR*    pRectangles;
//} VkPresentRegionKHR;
//
//typedef struct VkPresentRegionsKHR {
//    VkStructureType              sType;
//    const void*                  pNext;
//    uint32_t                     swapchainCount;
//    const VkPresentRegionKHR*    pRegions;
//} VkPresentRegionsKHR;
//
//
//
//#define VK_KHR_descriptor_update_template 1
//VK_DEFINE_NON_DISPATCHABLE_HANDLE(VkDescriptorUpdateTemplateKHR)
//
//#define VK_KHR_DESCRIPTOR_UPDATE_TEMPLATE_SPEC_VERSION 1
//#define VK_KHR_DESCRIPTOR_UPDATE_TEMPLATE_EXTENSION_NAME "VK_KHR_descriptor_update_template"
//
//
//typedef enum VkDescriptorUpdateTemplateTypeKHR {
//    VK_DESCRIPTOR_UPDATE_TEMPLATE_TYPE_DESCRIPTOR_SET_KHR = 0,
//    VK_DESCRIPTOR_UPDATE_TEMPLATE_TYPE_PUSH_DESCRIPTORS_KHR = 1,
//    VK_DESCRIPTOR_UPDATE_TEMPLATE_TYPE_BEGIN_RANGE_KHR = VK_DESCRIPTOR_UPDATE_TEMPLATE_TYPE_DESCRIPTOR_SET_KHR,
//    VK_DESCRIPTOR_UPDATE_TEMPLATE_TYPE_END_RANGE_KHR = VK_DESCRIPTOR_UPDATE_TEMPLATE_TYPE_PUSH_DESCRIPTORS_KHR,
//    VK_DESCRIPTOR_UPDATE_TEMPLATE_TYPE_RANGE_SIZE_KHR = (VK_DESCRIPTOR_UPDATE_TEMPLATE_TYPE_PUSH_DESCRIPTORS_KHR - VK_DESCRIPTOR_UPDATE_TEMPLATE_TYPE_DESCRIPTOR_SET_KHR + 1),
//    VK_DESCRIPTOR_UPDATE_TEMPLATE_TYPE_MAX_ENUM_KHR = 0x7FFFFFFF
//} VkDescriptorUpdateTemplateTypeKHR;
//
//typedef VkFlags VkDescriptorUpdateTemplateCreateFlagsKHR;
//
//typedef struct VkDescriptorUpdateTemplateEntryKHR {
//    uint32_t            dstBinding;
//    uint32_t            dstArrayElement;
//    uint32_t            descriptorCount;
//    VkDescriptorType    descriptorType;
//    size_t              offset;
//    size_t              stride;
//} VkDescriptorUpdateTemplateEntryKHR;
//
//typedef struct VkDescriptorUpdateTemplateCreateInfoKHR {
//    VkStructureType                              sType;
//    void*                                        pNext;
//    VkDescriptorUpdateTemplateCreateFlagsKHR     flags;
//    uint32_t                                     descriptorUpdateEntryCount;
//    const VkDescriptorUpdateTemplateEntryKHR*    pDescriptorUpdateEntries;
//    VkDescriptorUpdateTemplateTypeKHR            templateType;
//    VkDescriptorSetLayout                        descriptorSetLayout;
//    VkPipelineBindPoint                          pipelineBindPoint;
//    VkPipelineLayout                             pipelineLayout;
//    uint32_t                                     set;
//} VkDescriptorUpdateTemplateCreateInfoKHR;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkCreateDescriptorUpdateTemplateKHR)(VkDevice device, const VkDescriptorUpdateTemplateCreateInfoKHR* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkDescriptorUpdateTemplateKHR* pDescriptorUpdateTemplate);
//typedef void (VKAPI_PTR *PFN_vkDestroyDescriptorUpdateTemplateKHR)(VkDevice device, VkDescriptorUpdateTemplateKHR descriptorUpdateTemplate, const VkAllocationCallbacks* pAllocator);
//typedef void (VKAPI_PTR *PFN_vkUpdateDescriptorSetWithTemplateKHR)(VkDevice device, VkDescriptorSet descriptorSet, VkDescriptorUpdateTemplateKHR descriptorUpdateTemplate, const void* pData);
//typedef void (VKAPI_PTR *PFN_vkCmdPushDescriptorSetWithTemplateKHR)(VkCommandBuffer commandBuffer, VkDescriptorUpdateTemplateKHR descriptorUpdateTemplate, VkPipelineLayout layout, uint32_t set, const void* pData);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateDescriptorUpdateTemplateKHR(
//VkDevice                                    device,
//const VkDescriptorUpdateTemplateCreateInfoKHR* pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkDescriptorUpdateTemplateKHR*              pDescriptorUpdateTemplate);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyDescriptorUpdateTemplateKHR(
//VkDevice                                    device,
//VkDescriptorUpdateTemplateKHR               descriptorUpdateTemplate,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR void VKAPI_CALL vkUpdateDescriptorSetWithTemplateKHR(
//VkDevice                                    device,
//VkDescriptorSet                             descriptorSet,
//VkDescriptorUpdateTemplateKHR               descriptorUpdateTemplate,
//const void*                                 pData);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdPushDescriptorSetWithTemplateKHR(
//VkCommandBuffer                             commandBuffer,
//VkDescriptorUpdateTemplateKHR               descriptorUpdateTemplate,
//VkPipelineLayout                            layout,
//uint32_t                                    set,
//const void*                                 pData);
//#endif
//
//#define VK_KHR_shared_presentable_image 1
//#define VK_KHR_SHARED_PRESENTABLE_IMAGE_SPEC_VERSION 1
//#define VK_KHR_SHARED_PRESENTABLE_IMAGE_EXTENSION_NAME "VK_KHR_shared_presentable_image"
//
//typedef struct VkSharedPresentSurfaceCapabilitiesKHR {
//    VkStructureType      sType;
//    void*                pNext;
//    VkImageUsageFlags    sharedPresentSupportedUsageFlags;
//} VkSharedPresentSurfaceCapabilitiesKHR;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkGetSwapchainStatusKHR)(VkDevice device, VkSwapchainKHR swapchain);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkGetSwapchainStatusKHR(
//VkDevice                                    device,
//VkSwapchainKHR                              swapchain);
//#endif
//
//#define VK_KHR_external_fence_capabilities 1
//#define VK_KHR_EXTERNAL_FENCE_CAPABILITIES_SPEC_VERSION 1
//#define VK_KHR_EXTERNAL_FENCE_CAPABILITIES_EXTENSION_NAME "VK_KHR_external_fence_capabilities"
//
//
//typedef enum VkExternalFenceHandleTypeFlagBitsKHR {
//    VK_EXTERNAL_FENCE_HANDLE_TYPE_OPAQUE_FD_BIT_KHR = 0x00000001,
//    VK_EXTERNAL_FENCE_HANDLE_TYPE_OPAQUE_WIN32_BIT_KHR = 0x00000002,
//    VK_EXTERNAL_FENCE_HANDLE_TYPE_OPAQUE_WIN32_KMT_BIT_KHR = 0x00000004,
//    VK_EXTERNAL_FENCE_HANDLE_TYPE_SYNC_FD_BIT_KHR = 0x00000008,
//    VK_EXTERNAL_FENCE_HANDLE_TYPE_FLAG_BITS_MAX_ENUM_KHR = 0x7FFFFFFF
//} VkExternalFenceHandleTypeFlagBitsKHR;
//typedef VkFlags VkExternalFenceHandleTypeFlagsKHR;
//
//typedef enum VkExternalFenceFeatureFlagBitsKHR {
//    VK_EXTERNAL_FENCE_FEATURE_EXPORTABLE_BIT_KHR = 0x00000001,
//    VK_EXTERNAL_FENCE_FEATURE_IMPORTABLE_BIT_KHR = 0x00000002,
//    VK_EXTERNAL_FENCE_FEATURE_FLAG_BITS_MAX_ENUM_KHR = 0x7FFFFFFF
//} VkExternalFenceFeatureFlagBitsKHR;
//typedef VkFlags VkExternalFenceFeatureFlagsKHR;
//
//typedef struct VkPhysicalDeviceExternalFenceInfoKHR {
//    VkStructureType                         sType;
//    const void*                             pNext;
//    VkExternalFenceHandleTypeFlagBitsKHR    handleType;
//} VkPhysicalDeviceExternalFenceInfoKHR;
//
//typedef struct VkExternalFencePropertiesKHR {
//    VkStructureType                      sType;
//    void*                                pNext;
//    VkExternalFenceHandleTypeFlagsKHR    exportFromImportedHandleTypes;
//    VkExternalFenceHandleTypeFlagsKHR    compatibleHandleTypes;
//    VkExternalFenceFeatureFlagsKHR       externalFenceFeatures;
//} VkExternalFencePropertiesKHR;
//
//
//typedef void (VKAPI_PTR *PFN_vkGetPhysicalDeviceExternalFencePropertiesKHR)(VkPhysicalDevice physicalDevice, const VkPhysicalDeviceExternalFenceInfoKHR* pExternalFenceInfo, VkExternalFencePropertiesKHR* pExternalFenceProperties);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR void VKAPI_CALL vkGetPhysicalDeviceExternalFencePropertiesKHR(
//VkPhysicalDevice                            physicalDevice,
//const VkPhysicalDeviceExternalFenceInfoKHR* pExternalFenceInfo,
//VkExternalFencePropertiesKHR*               pExternalFenceProperties);
//#endif
//
//#define VK_KHR_external_fence 1
//#define VK_KHR_EXTERNAL_FENCE_SPEC_VERSION 1
//#define VK_KHR_EXTERNAL_FENCE_EXTENSION_NAME "VK_KHR_external_fence"
//
//
//typedef enum VkFenceImportFlagBitsKHR {
//    VK_FENCE_IMPORT_TEMPORARY_BIT_KHR = 0x00000001,
//    VK_FENCE_IMPORT_FLAG_BITS_MAX_ENUM_KHR = 0x7FFFFFFF
//} VkFenceImportFlagBitsKHR;
//typedef VkFlags VkFenceImportFlagsKHR;
//
//typedef struct VkExportFenceCreateInfoKHR {
//    VkStructureType                      sType;
//    const void*                          pNext;
//    VkExternalFenceHandleTypeFlagsKHR    handleTypes;
//} VkExportFenceCreateInfoKHR;
//
//
//
//#ifdef VK_USE_PLATFORM_WIN32_KHR
//#define VK_KHR_external_fence_win32 1
//#define VK_KHR_EXTERNAL_FENCE_WIN32_SPEC_VERSION 1
//#define VK_KHR_EXTERNAL_FENCE_WIN32_EXTENSION_NAME "VK_KHR_external_fence_win32"
//
//typedef struct VkImportFenceWin32HandleInfoKHR {
//    VkStructureType                         sType;
//    const void*                             pNext;
//    VkFence                                 fence;
//    VkFenceImportFlagsKHR                   flags;
//    VkExternalFenceHandleTypeFlagBitsKHR    handleType;
//    HANDLE                                  handle;
//    LPCWSTR                                 name;
//} VkImportFenceWin32HandleInfoKHR;
//
//typedef struct VkExportFenceWin32HandleInfoKHR {
//    VkStructureType               sType;
//    const void*                   pNext;
//    const SECURITY_ATTRIBUTES*    pAttributes;
//    DWORD                         dwAccess;
//    LPCWSTR                       name;
//} VkExportFenceWin32HandleInfoKHR;
//
//typedef struct VkFenceGetWin32HandleInfoKHR {
//    VkStructureType                         sType;
//    const void*                             pNext;
//    VkFence                                 fence;
//    VkExternalFenceHandleTypeFlagBitsKHR    handleType;
//} VkFenceGetWin32HandleInfoKHR;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkImportFenceWin32HandleKHR)(VkDevice device, const VkImportFenceWin32HandleInfoKHR* pImportFenceWin32HandleInfo);
//typedef VkResult (VKAPI_PTR *PFN_vkGetFenceWin32HandleKHR)(VkDevice device, const VkFenceGetWin32HandleInfoKHR* pGetWin32HandleInfo, HANDLE* pHandle);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkImportFenceWin32HandleKHR(
//VkDevice                                    device,
//const VkImportFenceWin32HandleInfoKHR*      pImportFenceWin32HandleInfo);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetFenceWin32HandleKHR(
//VkDevice                                    device,
//const VkFenceGetWin32HandleInfoKHR*         pGetWin32HandleInfo,
//HANDLE*                                     pHandle);
//#endif
//#endif /* VK_USE_PLATFORM_WIN32_KHR */
//
//#define VK_KHR_external_fence_fd 1
//#define VK_KHR_EXTERNAL_FENCE_FD_SPEC_VERSION 1
//#define VK_KHR_EXTERNAL_FENCE_FD_EXTENSION_NAME "VK_KHR_external_fence_fd"
//
//typedef struct VkImportFenceFdInfoKHR {
//    VkStructureType                         sType;
//    const void*                             pNext;
//    VkFence                                 fence;
//    VkFenceImportFlagsKHR                   flags;
//    VkExternalFenceHandleTypeFlagBitsKHR    handleType;
//    int                                     fd;
//} VkImportFenceFdInfoKHR;
//
//typedef struct VkFenceGetFdInfoKHR {
//    VkStructureType                         sType;
//    const void*                             pNext;
//    VkFence                                 fence;
//    VkExternalFenceHandleTypeFlagBitsKHR    handleType;
//} VkFenceGetFdInfoKHR;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkImportFenceFdKHR)(VkDevice device, const VkImportFenceFdInfoKHR* pImportFenceFdInfo);
//typedef VkResult (VKAPI_PTR *PFN_vkGetFenceFdKHR)(VkDevice device, const VkFenceGetFdInfoKHR* pGetFdInfo, int* pFd);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkImportFenceFdKHR(
//VkDevice                                    device,
//const VkImportFenceFdInfoKHR*               pImportFenceFdInfo);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetFenceFdKHR(
//VkDevice                                    device,
//const VkFenceGetFdInfoKHR*                  pGetFdInfo,
//int*                                        pFd);
//#endif
//
//#define VK_KHR_maintenance2 1
//#define VK_KHR_MAINTENANCE2_SPEC_VERSION  1
//#define VK_KHR_MAINTENANCE2_EXTENSION_NAME "VK_KHR_maintenance2"
//
//
//typedef enum VkPointClippingBehaviorKHR {
//    VK_POINT_CLIPPING_BEHAVIOR_ALL_CLIP_PLANES_KHR = 0,
//    VK_POINT_CLIPPING_BEHAVIOR_USER_CLIP_PLANES_ONLY_KHR = 1,
//    VK_POINT_CLIPPING_BEHAVIOR_BEGIN_RANGE_KHR = VK_POINT_CLIPPING_BEHAVIOR_ALL_CLIP_PLANES_KHR,
//    VK_POINT_CLIPPING_BEHAVIOR_END_RANGE_KHR = VK_POINT_CLIPPING_BEHAVIOR_USER_CLIP_PLANES_ONLY_KHR,
//    VK_POINT_CLIPPING_BEHAVIOR_RANGE_SIZE_KHR = (VK_POINT_CLIPPING_BEHAVIOR_USER_CLIP_PLANES_ONLY_KHR - VK_POINT_CLIPPING_BEHAVIOR_ALL_CLIP_PLANES_KHR + 1),
//    VK_POINT_CLIPPING_BEHAVIOR_MAX_ENUM_KHR = 0x7FFFFFFF
//} VkPointClippingBehaviorKHR;
//
//typedef enum VkTessellationDomainOriginKHR {
//    VK_TESSELLATION_DOMAIN_ORIGIN_UPPER_LEFT_KHR = 0,
//    VK_TESSELLATION_DOMAIN_ORIGIN_LOWER_LEFT_KHR = 1,
//    VK_TESSELLATION_DOMAIN_ORIGIN_BEGIN_RANGE_KHR = VK_TESSELLATION_DOMAIN_ORIGIN_UPPER_LEFT_KHR,
//    VK_TESSELLATION_DOMAIN_ORIGIN_END_RANGE_KHR = VK_TESSELLATION_DOMAIN_ORIGIN_LOWER_LEFT_KHR,
//    VK_TESSELLATION_DOMAIN_ORIGIN_RANGE_SIZE_KHR = (VK_TESSELLATION_DOMAIN_ORIGIN_LOWER_LEFT_KHR - VK_TESSELLATION_DOMAIN_ORIGIN_UPPER_LEFT_KHR + 1),
//    VK_TESSELLATION_DOMAIN_ORIGIN_MAX_ENUM_KHR = 0x7FFFFFFF
//} VkTessellationDomainOriginKHR;
//
//typedef struct VkPhysicalDevicePointClippingPropertiesKHR {
//    VkStructureType               sType;
//    void*                         pNext;
//    VkPointClippingBehaviorKHR    pointClippingBehavior;
//} VkPhysicalDevicePointClippingPropertiesKHR;
//
//typedef struct VkInputAttachmentAspectReferenceKHR {
//    uint32_t              subpass;
//    uint32_t              inputAttachmentIndex;
//    VkImageAspectFlags    aspectMask;
//} VkInputAttachmentAspectReferenceKHR;
//
//typedef struct VkRenderPassInputAttachmentAspectCreateInfoKHR {
//    VkStructureType                               sType;
//    const void*                                   pNext;
//    uint32_t                                      aspectReferenceCount;
//    const VkInputAttachmentAspectReferenceKHR*    pAspectReferences;
//} VkRenderPassInputAttachmentAspectCreateInfoKHR;
//
//typedef struct VkImageViewUsageCreateInfoKHR {
//    VkStructureType      sType;
//    const void*          pNext;
//    VkImageUsageFlags    usage;
//} VkImageViewUsageCreateInfoKHR;
//
//typedef struct VkPipelineTessellationDomainOriginStateCreateInfoKHR {
//    VkStructureType                  sType;
//    const void*                      pNext;
//    VkTessellationDomainOriginKHR    domainOrigin;
//} VkPipelineTessellationDomainOriginStateCreateInfoKHR;
//
//
//
//#define VK_KHR_get_surface_capabilities2 1
//#define VK_KHR_GET_SURFACE_CAPABILITIES_2_SPEC_VERSION 1
//#define VK_KHR_GET_SURFACE_CAPABILITIES_2_EXTENSION_NAME "VK_KHR_get_surface_capabilities2"
//
//typedef struct VkPhysicalDeviceSurfaceInfo2KHR {
//    VkStructureType    sType;
//    const void*        pNext;
//    VkSurfaceKHR       surface;
//} VkPhysicalDeviceSurfaceInfo2KHR;
//
//typedef struct VkSurfaceCapabilities2KHR {
//    VkStructureType             sType;
//    void*                       pNext;
//    VkSurfaceCapabilitiesKHR    surfaceCapabilities;
//} VkSurfaceCapabilities2KHR;
//
//typedef struct VkSurfaceFormat2KHR {
//    VkStructureType       sType;
//    void*                 pNext;
//    VkSurfaceFormatKHR    surfaceFormat;
//} VkSurfaceFormat2KHR;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkGetPhysicalDeviceSurfaceCapabilities2KHR)(VkPhysicalDevice physicalDevice, const VkPhysicalDeviceSurfaceInfo2KHR* pSurfaceInfo, VkSurfaceCapabilities2KHR* pSurfaceCapabilities);
//typedef VkResult (VKAPI_PTR *PFN_vkGetPhysicalDeviceSurfaceFormats2KHR)(VkPhysicalDevice physicalDevice, const VkPhysicalDeviceSurfaceInfo2KHR* pSurfaceInfo, uint32_t* pSurfaceFormatCount, VkSurfaceFormat2KHR* pSurfaceFormats);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkGetPhysicalDeviceSurfaceCapabilities2KHR(
//VkPhysicalDevice                            physicalDevice,
//const VkPhysicalDeviceSurfaceInfo2KHR*      pSurfaceInfo,
//VkSurfaceCapabilities2KHR*                  pSurfaceCapabilities);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetPhysicalDeviceSurfaceFormats2KHR(
//VkPhysicalDevice                            physicalDevice,
//const VkPhysicalDeviceSurfaceInfo2KHR*      pSurfaceInfo,
//uint32_t*                                   pSurfaceFormatCount,
//VkSurfaceFormat2KHR*                        pSurfaceFormats);
//#endif
//
//#define VK_KHR_variable_pointers 1
//#define VK_KHR_VARIABLE_POINTERS_SPEC_VERSION 1
//#define VK_KHR_VARIABLE_POINTERS_EXTENSION_NAME "VK_KHR_variable_pointers"
//
//typedef struct VkPhysicalDeviceVariablePointerFeaturesKHR {
//    VkStructureType    sType;
//    void*              pNext;
//    VkBool32           variablePointersStorageBuffer;
//    VkBool32           variablePointers;
//} VkPhysicalDeviceVariablePointerFeaturesKHR;
//
//
//#define VK_KHR_get_display_properties2 1
//#define VK_KHR_GET_DISPLAY_PROPERTIES_2_SPEC_VERSION 1
//#define VK_KHR_GET_DISPLAY_PROPERTIES_2_EXTENSION_NAME "VK_KHR_get_display_properties2"
//
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
//typedef VkResult (VKAPI_PTR *PFN_vkGetPhysicalDeviceDisplayProperties2KHR)(VkPhysicalDevice physicalDevice, uint32_t* pPropertyCount, VkDisplayProperties2KHR* pProperties);
//typedef VkResult (VKAPI_PTR *PFN_vkGetPhysicalDeviceDisplayPlaneProperties2KHR)(VkPhysicalDevice physicalDevice, uint32_t* pPropertyCount, VkDisplayPlaneProperties2KHR* pProperties);
//typedef VkResult (VKAPI_PTR *PFN_vkGetDisplayModeProperties2KHR)(VkPhysicalDevice physicalDevice, VkDisplayKHR display, uint32_t* pPropertyCount, VkDisplayModeProperties2KHR* pProperties);
//typedef VkResult (VKAPI_PTR *PFN_vkGetDisplayPlaneCapabilities2KHR)(VkPhysicalDevice physicalDevice, const VkDisplayPlaneInfo2KHR* pDisplayPlaneInfo, VkDisplayPlaneCapabilities2KHR* pCapabilities);
//
//#ifndef VK_NO_PROTOTYPES
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
//#endif
//
//#define VK_KHR_dedicated_allocation 1
//#define VK_KHR_DEDICATED_ALLOCATION_SPEC_VERSION 3
//#define VK_KHR_DEDICATED_ALLOCATION_EXTENSION_NAME "VK_KHR_dedicated_allocation"
//
//typedef struct VkMemoryDedicatedRequirementsKHR {
//    VkStructureType    sType;
//    void*              pNext;
//    VkBool32           prefersDedicatedAllocation;
//    VkBool32           requiresDedicatedAllocation;
//} VkMemoryDedicatedRequirementsKHR;
//
//typedef struct VkMemoryDedicatedAllocateInfoKHR {
//    VkStructureType    sType;
//    const void*        pNext;
//    VkImage            image;
//    VkBuffer           buffer;
//} VkMemoryDedicatedAllocateInfoKHR;
//
//
//
//#define VK_KHR_storage_buffer_storage_class 1
//#define VK_KHR_STORAGE_BUFFER_STORAGE_CLASS_SPEC_VERSION 1
//#define VK_KHR_STORAGE_BUFFER_STORAGE_CLASS_EXTENSION_NAME "VK_KHR_storage_buffer_storage_class"
//
//
//#define VK_KHR_relaxed_block_layout 1
//#define VK_KHR_RELAXED_BLOCK_LAYOUT_SPEC_VERSION 1
//#define VK_KHR_RELAXED_BLOCK_LAYOUT_EXTENSION_NAME "VK_KHR_relaxed_block_layout"
//
//
//#define VK_KHR_get_memory_requirements2 1
//#define VK_KHR_GET_MEMORY_REQUIREMENTS_2_SPEC_VERSION 1
//#define VK_KHR_GET_MEMORY_REQUIREMENTS_2_EXTENSION_NAME "VK_KHR_get_memory_requirements2"
//
//typedef struct VkBufferMemoryRequirementsInfo2KHR {
//    VkStructureType    sType;
//    const void*        pNext;
//    VkBuffer           buffer;
//} VkBufferMemoryRequirementsInfo2KHR;
//
//typedef struct VkImageMemoryRequirementsInfo2KHR {
//    VkStructureType    sType;
//    const void*        pNext;
//    VkImage            image;
//} VkImageMemoryRequirementsInfo2KHR;
//
//typedef struct VkImageSparseMemoryRequirementsInfo2KHR {
//    VkStructureType    sType;
//    const void*        pNext;
//    VkImage            image;
//} VkImageSparseMemoryRequirementsInfo2KHR;
//
//typedef struct VkMemoryRequirements2KHR {
//    VkStructureType         sType;
//    void*                   pNext;
//    VkMemoryRequirements    memoryRequirements;
//} VkMemoryRequirements2KHR;
//
//typedef struct VkSparseImageMemoryRequirements2KHR {
//    VkStructureType                    sType;
//    void*                              pNext;
//    VkSparseImageMemoryRequirements    memoryRequirements;
//} VkSparseImageMemoryRequirements2KHR;
//
//
//typedef void (VKAPI_PTR *PFN_vkGetImageMemoryRequirements2KHR)(VkDevice device, const VkImageMemoryRequirementsInfo2KHR* pInfo, VkMemoryRequirements2KHR* pMemoryRequirements);
//typedef void (VKAPI_PTR *PFN_vkGetBufferMemoryRequirements2KHR)(VkDevice device, const VkBufferMemoryRequirementsInfo2KHR* pInfo, VkMemoryRequirements2KHR* pMemoryRequirements);
//typedef void (VKAPI_PTR *PFN_vkGetImageSparseMemoryRequirements2KHR)(VkDevice device, const VkImageSparseMemoryRequirementsInfo2KHR* pInfo, uint32_t* pSparseMemoryRequirementCount, VkSparseImageMemoryRequirements2KHR* pSparseMemoryRequirements);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR void VKAPI_CALL vkGetImageMemoryRequirements2KHR(
//VkDevice                                    device,
//const VkImageMemoryRequirementsInfo2KHR*    pInfo,
//VkMemoryRequirements2KHR*                   pMemoryRequirements);
//
//VKAPI_ATTR void VKAPI_CALL vkGetBufferMemoryRequirements2KHR(
//VkDevice                                    device,
//const VkBufferMemoryRequirementsInfo2KHR*   pInfo,
//VkMemoryRequirements2KHR*                   pMemoryRequirements);
//
//VKAPI_ATTR void VKAPI_CALL vkGetImageSparseMemoryRequirements2KHR(
//VkDevice                                    device,
//const VkImageSparseMemoryRequirementsInfo2KHR* pInfo,
//uint32_t*                                   pSparseMemoryRequirementCount,
//VkSparseImageMemoryRequirements2KHR*        pSparseMemoryRequirements);
//#endif
//
//#define VK_KHR_image_format_list 1
//#define VK_KHR_IMAGE_FORMAT_LIST_SPEC_VERSION 1
//#define VK_KHR_IMAGE_FORMAT_LIST_EXTENSION_NAME "VK_KHR_image_format_list"
//
//typedef struct VkImageFormatListCreateInfoKHR {
//    VkStructureType    sType;
//    const void*        pNext;
//    uint32_t           viewFormatCount;
//    const VkFormat*    pViewFormats;
//} VkImageFormatListCreateInfoKHR;
//
//
//
//#define VK_KHR_sampler_ycbcr_conversion 1
//VK_DEFINE_NON_DISPATCHABLE_HANDLE(VkSamplerYcbcrConversionKHR)
//
//#define VK_KHR_SAMPLER_YCBCR_CONVERSION_SPEC_VERSION 1
//#define VK_KHR_SAMPLER_YCBCR_CONVERSION_EXTENSION_NAME "VK_KHR_sampler_ycbcr_conversion"
//
//
//typedef enum VkSamplerYcbcrModelConversionKHR {
//    VK_SAMPLER_YCBCR_MODEL_CONVERSION_RGB_IDENTITY_KHR = 0,
//    VK_SAMPLER_YCBCR_MODEL_CONVERSION_YCBCR_IDENTITY_KHR = 1,
//    VK_SAMPLER_YCBCR_MODEL_CONVERSION_YCBCR_709_KHR = 2,
//    VK_SAMPLER_YCBCR_MODEL_CONVERSION_YCBCR_601_KHR = 3,
//    VK_SAMPLER_YCBCR_MODEL_CONVERSION_YCBCR_2020_KHR = 4,
//    VK_SAMPLER_YCBCR_MODEL_CONVERSION_BEGIN_RANGE_KHR = VK_SAMPLER_YCBCR_MODEL_CONVERSION_RGB_IDENTITY_KHR,
//    VK_SAMPLER_YCBCR_MODEL_CONVERSION_END_RANGE_KHR = VK_SAMPLER_YCBCR_MODEL_CONVERSION_YCBCR_2020_KHR,
//    VK_SAMPLER_YCBCR_MODEL_CONVERSION_RANGE_SIZE_KHR = (VK_SAMPLER_YCBCR_MODEL_CONVERSION_YCBCR_2020_KHR - VK_SAMPLER_YCBCR_MODEL_CONVERSION_RGB_IDENTITY_KHR + 1),
//    VK_SAMPLER_YCBCR_MODEL_CONVERSION_MAX_ENUM_KHR = 0x7FFFFFFF
//} VkSamplerYcbcrModelConversionKHR;
//
//typedef enum VkSamplerYcbcrRangeKHR {
//    VK_SAMPLER_YCBCR_RANGE_ITU_FULL_KHR = 0,
//    VK_SAMPLER_YCBCR_RANGE_ITU_NARROW_KHR = 1,
//    VK_SAMPLER_YCBCR_RANGE_BEGIN_RANGE_KHR = VK_SAMPLER_YCBCR_RANGE_ITU_FULL_KHR,
//    VK_SAMPLER_YCBCR_RANGE_END_RANGE_KHR = VK_SAMPLER_YCBCR_RANGE_ITU_NARROW_KHR,
//    VK_SAMPLER_YCBCR_RANGE_RANGE_SIZE_KHR = (VK_SAMPLER_YCBCR_RANGE_ITU_NARROW_KHR - VK_SAMPLER_YCBCR_RANGE_ITU_FULL_KHR + 1),
//    VK_SAMPLER_YCBCR_RANGE_MAX_ENUM_KHR = 0x7FFFFFFF
//} VkSamplerYcbcrRangeKHR;
//
//typedef enum VkChromaLocationKHR {
//    VK_CHROMA_LOCATION_COSITED_EVEN_KHR = 0,
//    VK_CHROMA_LOCATION_MIDPOINT_KHR = 1,
//    VK_CHROMA_LOCATION_BEGIN_RANGE_KHR = VK_CHROMA_LOCATION_COSITED_EVEN_KHR,
//    VK_CHROMA_LOCATION_END_RANGE_KHR = VK_CHROMA_LOCATION_MIDPOINT_KHR,
//    VK_CHROMA_LOCATION_RANGE_SIZE_KHR = (VK_CHROMA_LOCATION_MIDPOINT_KHR - VK_CHROMA_LOCATION_COSITED_EVEN_KHR + 1),
//    VK_CHROMA_LOCATION_MAX_ENUM_KHR = 0x7FFFFFFF
//} VkChromaLocationKHR;
//
//typedef struct VkSamplerYcbcrConversionCreateInfoKHR {
//    VkStructureType                     sType;
//    const void*                         pNext;
//    VkFormat                            format;
//    VkSamplerYcbcrModelConversionKHR    ycbcrModel;
//    VkSamplerYcbcrRangeKHR              ycbcrRange;
//    VkComponentMapping                  components;
//    VkChromaLocationKHR                 xChromaOffset;
//    VkChromaLocationKHR                 yChromaOffset;
//    VkFilter                            chromaFilter;
//    VkBool32                            forceExplicitReconstruction;
//} VkSamplerYcbcrConversionCreateInfoKHR;
//
//typedef struct VkSamplerYcbcrConversionInfoKHR {
//    VkStructureType                sType;
//    const void*                    pNext;
//    VkSamplerYcbcrConversionKHR    conversion;
//} VkSamplerYcbcrConversionInfoKHR;
//
//typedef struct VkBindImagePlaneMemoryInfoKHR {
//    VkStructureType          sType;
//    const void*              pNext;
//    VkImageAspectFlagBits    planeAspect;
//} VkBindImagePlaneMemoryInfoKHR;
//
//typedef struct VkImagePlaneMemoryRequirementsInfoKHR {
//    VkStructureType          sType;
//    const void*              pNext;
//    VkImageAspectFlagBits    planeAspect;
//} VkImagePlaneMemoryRequirementsInfoKHR;
//
//typedef struct VkPhysicalDeviceSamplerYcbcrConversionFeaturesKHR {
//    VkStructureType    sType;
//    void*              pNext;
//    VkBool32           samplerYcbcrConversion;
//} VkPhysicalDeviceSamplerYcbcrConversionFeaturesKHR;
//
//typedef struct VkSamplerYcbcrConversionImageFormatPropertiesKHR {
//    VkStructureType    sType;
//    void*              pNext;
//    uint32_t           combinedImageSamplerDescriptorCount;
//} VkSamplerYcbcrConversionImageFormatPropertiesKHR;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkCreateSamplerYcbcrConversionKHR)(VkDevice device, const VkSamplerYcbcrConversionCreateInfoKHR* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkSamplerYcbcrConversionKHR* pYcbcrConversion);
//typedef void (VKAPI_PTR *PFN_vkDestroySamplerYcbcrConversionKHR)(VkDevice device, VkSamplerYcbcrConversionKHR ycbcrConversion, const VkAllocationCallbacks* pAllocator);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateSamplerYcbcrConversionKHR(
//VkDevice                                    device,
//const VkSamplerYcbcrConversionCreateInfoKHR* pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkSamplerYcbcrConversionKHR*                pYcbcrConversion);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroySamplerYcbcrConversionKHR(
//VkDevice                                    device,
//VkSamplerYcbcrConversionKHR                 ycbcrConversion,
//const VkAllocationCallbacks*                pAllocator);
//#endif
//
//#define VK_KHR_bind_memory2 1
//#define VK_KHR_BIND_MEMORY_2_SPEC_VERSION 1
//#define VK_KHR_BIND_MEMORY_2_EXTENSION_NAME "VK_KHR_bind_memory2"
//
//typedef struct VkBindBufferMemoryInfoKHR {
//    VkStructureType    sType;
//    const void*        pNext;
//    VkBuffer           buffer;
//    VkDeviceMemory     memory;
//    VkDeviceSize       memoryOffset;
//} VkBindBufferMemoryInfoKHR;
//
//typedef struct VkBindImageMemoryInfoKHR {
//    VkStructureType    sType;
//    const void*        pNext;
//    VkImage            image;
//    VkDeviceMemory     memory;
//    VkDeviceSize       memoryOffset;
//} VkBindImageMemoryInfoKHR;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkBindBufferMemory2KHR)(VkDevice device, uint32_t bindInfoCount, const VkBindBufferMemoryInfoKHR* pBindInfos);
//typedef VkResult (VKAPI_PTR *PFN_vkBindImageMemory2KHR)(VkDevice device, uint32_t bindInfoCount, const VkBindImageMemoryInfoKHR* pBindInfos);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkBindBufferMemory2KHR(
//VkDevice                                    device,
//uint32_t                                    bindInfoCount,
//const VkBindBufferMemoryInfoKHR*            pBindInfos);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkBindImageMemory2KHR(
//VkDevice                                    device,
//uint32_t                                    bindInfoCount,
//const VkBindImageMemoryInfoKHR*             pBindInfos);
//#endif
//
//#define VK_KHR_draw_indirect_count 1
//#define VK_KHR_DRAW_INDIRECT_COUNT_SPEC_VERSION 1
//#define VK_KHR_DRAW_INDIRECT_COUNT_EXTENSION_NAME "VK_KHR_draw_indirect_count"
//
//typedef void (VKAPI_PTR *PFN_vkCmdDrawIndirectCountKHR)(VkCommandBuffer commandBuffer, VkBuffer buffer, VkDeviceSize offset, VkBuffer countBuffer, VkDeviceSize countBufferOffset, uint32_t maxDrawCount, uint32_t stride);
//typedef void (VKAPI_PTR *PFN_vkCmdDrawIndexedIndirectCountKHR)(VkCommandBuffer commandBuffer, VkBuffer buffer, VkDeviceSize offset, VkBuffer countBuffer, VkDeviceSize countBufferOffset, uint32_t maxDrawCount, uint32_t stride);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR void VKAPI_CALL vkCmdDrawIndirectCountKHR(
//VkCommandBuffer                             commandBuffer,
//VkBuffer                                    buffer,
//VkDeviceSize                                offset,
//VkBuffer                                    countBuffer,
//VkDeviceSize                                countBufferOffset,
//uint32_t                                    maxDrawCount,
//uint32_t                                    stride);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdDrawIndexedIndirectCountKHR(
//VkCommandBuffer                             commandBuffer,
//VkBuffer                                    buffer,
//VkDeviceSize                                offset,
//VkBuffer                                    countBuffer,
//VkDeviceSize                                countBufferOffset,
//uint32_t                                    maxDrawCount,
//uint32_t                                    stride);
//#endif
//
//#define VK_EXT_debug_report 1
//VK_DEFINE_NON_DISPATCHABLE_HANDLE(VkDebugReportCallbackEXT)
//
//#define VK_EXT_DEBUG_REPORT_SPEC_VERSION  9
//#define VK_EXT_DEBUG_REPORT_EXTENSION_NAME "VK_EXT_debug_report"
//#define DEBUG_REPORT_CREATE_INFO_EXT DEBUG_REPORT_CALLBACK_CREATE_INFO_EXT
//#define VK_DEBUG_REPORT_OBJECT_TYPE_DEBUG_REPORT_EXT VK_DEBUG_REPORT_OBJECT_TYPE_DEBUG_REPORT_CALLBACK_EXT_EXT
//

//typedef VkBool32 (VKAPI_PTR *PFN_vkDebugReportCallbackEXT)(
//VkDebugReportFlagsEXT                       flags,
//VkDebugReportObjectTypeEXT                  objectType,
//uint64_t                                    object,
//size_t                                      location,
//int32_t                                     messageCode,
//const char*                                 pLayerPrefix,
//const char*                                 pMessage,
//void*                                       pUserData);

inline var VkDebugReportCallbackCreateInfoEXT.type
    get() = VkStructureType of VkDebugReportCallbackCreateInfoEXT.nsType(adr)
    set(value) = VkDebugReportCallbackCreateInfoEXT.nsType(adr, value.i)
inline var VkDebugReportCallbackCreateInfoEXT.next
    get() = VkDebugReportCallbackCreateInfoEXT.npNext(adr)
    set(value) = VkDebugReportCallbackCreateInfoEXT.npNext(adr, value)
/** JVM custom */
inline var VkDebugReportCallbackCreateInfoEXT.flag: VkDebugReport
    get() = TODO()
    set(value) = VkDebugReportCallbackCreateInfoEXT.nflags(adr, value.i)
inline var VkDebugReportCallbackCreateInfoEXT.flags: VkDebugReportFlagsEXT
    get() = VkDebugReportCallbackCreateInfoEXT.nflags(adr)
    set(value) = VkDebugReportCallbackCreateInfoEXT.nflags(adr, value)
var debugCallback: VkDebugReportCallbackEXT? = null
var VkDebugReportCallbackCreateInfoEXT.callback: VkDebugReportCallbackType
    get() = TODO() //VkDebugReportCallbackCreateInfoEXT.npfnCallback(adr)
    set(crossinline value) {
        debugCallback?.free()
        debugCallback = VkDebugReportCallbackEXT.create { flags, objectType, `object`, location, messageCode, pLayerPrefix, pMessage, pUserData ->
            val type = VkDebugReportObjectType of objectType
            value(flags, type, `object`, location, messageCode, pLayerPrefix.utf8, pMessage.utf8, pUserData as Any).i
        }.also {
            VkDebugReportCallbackCreateInfoEXT.npfnCallback(adr, it)
        }
    }
inline var VkDebugReportCallbackCreateInfoEXT.userData
    get() = VkDebugReportCallbackCreateInfoEXT.npUserData(adr)
    set(value) = VkDebugReportCallbackCreateInfoEXT.npUserData(adr, value)

//
//typedef VkResult (VKAPI_PTR *PFN_vkCreateDebugReportCallbackEXT)(VkInstance instance, const VkDebugReportCallbackCreateInfoEXT* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkDebugReportCallbackEXT* pCallback);
//typedef void (VKAPI_PTR *PFN_vkDestroyDebugReportCallbackEXT)(VkInstance instance, VkDebugReportCallbackEXT callback, const VkAllocationCallbacks* pAllocator);
//typedef void (VKAPI_PTR *PFN_vkDebugReportMessageEXT)(VkInstance instance, VkDebugReportFlagsEXT flags, VkDebugReportObjectTypeEXT objectType, uint64_t object, size_t location, int32_t messageCode, const char* pLayerPrefix, const char* pMessage);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateDebugReportCallbackEXT(
//VkInstance                                  instance,
//const VkDebugReportCallbackCreateInfoEXT*   pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkDebugReportCallbackEXT*                   pCallback);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyDebugReportCallbackEXT(
//VkInstance                                  instance,
//VkDebugReportCallbackEXT                    callback,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR void VKAPI_CALL vkDebugReportMessageEXT(
//VkInstance                                  instance,
//VkDebugReportFlagsEXT                       flags,
//VkDebugReportObjectTypeEXT                  objectType,
//uint64_t                                    object,
//size_t                                      location,
//int32_t                                     messageCode,
//const char*                                 pLayerPrefix,
//const char*                                 pMessage);
//#endif
//
//#define VK_NV_glsl_shader 1
//#define VK_NV_GLSL_SHADER_SPEC_VERSION    1
//#define VK_NV_GLSL_SHADER_EXTENSION_NAME  "VK_NV_glsl_shader"
//
//
//#define VK_EXT_depth_range_unrestricted 1
//#define VK_EXT_DEPTH_RANGE_UNRESTRICTED_SPEC_VERSION 1
//#define VK_EXT_DEPTH_RANGE_UNRESTRICTED_EXTENSION_NAME "VK_EXT_depth_range_unrestricted"
//
//
//#define VK_IMG_filter_cubic 1
//#define VK_IMG_FILTER_CUBIC_SPEC_VERSION  1
//#define VK_IMG_FILTER_CUBIC_EXTENSION_NAME "VK_IMG_filter_cubic"
//
//
//#define VK_AMD_rasterization_order 1
//#define VK_AMD_RASTERIZATION_ORDER_SPEC_VERSION 1
//#define VK_AMD_RASTERIZATION_ORDER_EXTENSION_NAME "VK_AMD_rasterization_order"
//
//
//typedef enum VkRasterizationOrderAMD {
//    VK_RASTERIZATION_ORDER_STRICT_AMD = 0,
//    VK_RASTERIZATION_ORDER_RELAXED_AMD = 1,
//    VK_RASTERIZATION_ORDER_BEGIN_RANGE_AMD = VK_RASTERIZATION_ORDER_STRICT_AMD,
//    VK_RASTERIZATION_ORDER_END_RANGE_AMD = VK_RASTERIZATION_ORDER_RELAXED_AMD,
//    VK_RASTERIZATION_ORDER_RANGE_SIZE_AMD = (VK_RASTERIZATION_ORDER_RELAXED_AMD - VK_RASTERIZATION_ORDER_STRICT_AMD + 1),
//    VK_RASTERIZATION_ORDER_MAX_ENUM_AMD = 0x7FFFFFFF
//} VkRasterizationOrderAMD;
//
//typedef struct VkPipelineRasterizationStateRasterizationOrderAMD {
//    VkStructureType            sType;
//    const void*                pNext;
//    VkRasterizationOrderAMD    rasterizationOrder;
//} VkPipelineRasterizationStateRasterizationOrderAMD;
//
//
//
//#define VK_AMD_shader_trinary_minmax 1
//#define VK_AMD_SHADER_TRINARY_MINMAX_SPEC_VERSION 1
//#define VK_AMD_SHADER_TRINARY_MINMAX_EXTENSION_NAME "VK_AMD_shader_trinary_minmax"
//
//
//#define VK_AMD_shader_explicit_vertex_parameter 1
//#define VK_AMD_SHADER_EXPLICIT_VERTEX_PARAMETER_SPEC_VERSION 1
//#define VK_AMD_SHADER_EXPLICIT_VERTEX_PARAMETER_EXTENSION_NAME "VK_AMD_shader_explicit_vertex_parameter"
//
//
//#define VK_EXT_debug_marker 1
//#define VK_EXT_DEBUG_MARKER_SPEC_VERSION  4
//#define VK_EXT_DEBUG_MARKER_EXTENSION_NAME "VK_EXT_debug_marker"

inline var VkDebugMarkerObjectNameInfoEXT.type: VkStructureType
    get() = VkStructureType of VkDebugMarkerObjectNameInfoEXT.nsType(adr)
    set(value) = VkDebugMarkerObjectNameInfoEXT.nsType(adr, value.i)
inline var VkDebugMarkerObjectNameInfoEXT.next: Long
    get() = VkDebugMarkerObjectNameInfoEXT.npNext(adr)
    set(value) = VkDebugMarkerObjectNameInfoEXT.npNext(adr, value)
inline var VkDebugMarkerObjectNameInfoEXT.objectType: VkDebugReportObjectType
    get() = VkDebugReportObjectType of VkDebugMarkerObjectNameInfoEXT.nobjectType(adr)
    set(value) = VkDebugMarkerObjectNameInfoEXT.nobjectType(adr, value.i)
inline var VkDebugMarkerObjectNameInfoEXT.`object`: Long
    get() = VkDebugMarkerObjectNameInfoEXT.nobject(adr)
    set(value) = VkDebugMarkerObjectNameInfoEXT.nobject(adr, value)
inline var VkDebugMarkerObjectNameInfoEXT.objectName: String
    get() = VkDebugMarkerObjectNameInfoEXT.npObjectNameString(adr)
    set(value) = VkDebugMarkerObjectNameInfoEXT.npObjectName(adr, value.utf8)


inline var VkDebugMarkerObjectTagInfoEXT.type: VkStructureType
    get() = VkStructureType of VkDebugMarkerObjectTagInfoEXT.nsType(adr)
    set(value) = VkDebugMarkerObjectTagInfoEXT.nsType(adr, value.i)
inline var VkDebugMarkerObjectTagInfoEXT.next: Long
    get() = VkDebugMarkerObjectTagInfoEXT.npNext(adr)
    set(value) = VkDebugMarkerObjectTagInfoEXT.npNext(adr, value)
inline var VkDebugMarkerObjectTagInfoEXT.objectType: VkDebugReportObjectType
    get() = VkDebugReportObjectType of VkDebugMarkerObjectTagInfoEXT.nobjectType(adr)
    set(value) = VkDebugMarkerObjectTagInfoEXT.nobjectType(adr, value.i)
inline var VkDebugMarkerObjectTagInfoEXT.`object`: Long
    get() = VkDebugMarkerObjectTagInfoEXT.nobject(adr)
    set(value) = VkDebugMarkerObjectTagInfoEXT.nobject(adr, value)
inline var VkDebugMarkerObjectTagInfoEXT.tagName: String
    get() = memUTF8(VkDebugMarkerObjectTagInfoEXT.ntagName(adr))
    set(value) = VkDebugMarkerObjectTagInfoEXT.ntagName(adr, value.utf8.adr)
//inline val VkDebugMarkerObjectTagInfoEXT.tagSize: Long get() = VkDebugMarkerObjectTagInfoEXT.ntagSize(adr)
inline var VkDebugMarkerObjectTagInfoEXT.tag: ByteBuffer
    get() = VkDebugMarkerObjectTagInfoEXT.npTag(adr)
    set(value) {
        VkDebugMarkerObjectTagInfoEXT.npTag(adr, value)
        VkDebugMarkerObjectTagInfoEXT.ntagSize(adr, value.remaining().L)
    }


//typedef struct VkDebugMarkerObjectTagInfoEXT {
//    VkStructureType               sType;
//    const void*                   pNext;
//    VkDebugReportObjectTypeEXT    objectType;
//    uint64_t                      object;
//    uint64_t                      tagName;
//    size_t                        tagSize;
//    const void*                   pTag;
//} VkDebugMarkerObjectTagInfoEXT;


inline var VkDebugMarkerMarkerInfoEXT.type: VkStructureType
    get() = VkStructureType of VkDebugMarkerMarkerInfoEXT.nsType(adr)
    set(value) = VkDebugMarkerMarkerInfoEXT.nsType(adr, value.i)
inline var VkDebugMarkerMarkerInfoEXT.next: Long
    get() = VkDebugMarkerMarkerInfoEXT.npNext(adr)
    set(value) = VkDebugMarkerMarkerInfoEXT.npNext(adr, value)
inline var VkDebugMarkerMarkerInfoEXT.markerName: String
    get() = VkDebugMarkerMarkerInfoEXT.npMarkerNameString(adr)
    set(value) = VkDebugMarkerMarkerInfoEXT.npMarkerName(adr, value.utf8)
inline var VkDebugMarkerMarkerInfoEXT.color: Vec4
    get() = Vec4(VkDebugMarkerMarkerInfoEXT.ncolor(adr))
    set(value) {
        memPutFloat(adr + VkDebugMarkerMarkerInfoEXT.COLOR, value.r)
        memPutFloat(adr + VkDebugMarkerMarkerInfoEXT.COLOR + Float.BYTES, value.g)
        memPutFloat(adr + VkDebugMarkerMarkerInfoEXT.COLOR + Float.BYTES * 2, value.b)
        memPutFloat(adr + VkDebugMarkerMarkerInfoEXT.COLOR + Float.BYTES * 3, value.a)
    }

//typedef struct VkDebugMarkerMarkerInfoEXT {
//    VkStructureType    sType;
//    const void*        pNext;
//    const char*        pMarkerName;
//    float              color[4];
//} VkDebugMarkerMarkerInfoEXT;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkDebugMarkerSetObjectTagEXT)(VkDevice device, const VkDebugMarkerObjectTagInfoEXT* pTagInfo);
//typedef VkResult (VKAPI_PTR *PFN_vkDebugMarkerSetObjectNameEXT)(VkDevice device, const VkDebugMarkerObjectNameInfoEXT* pNameInfo);
//typedef void (VKAPI_PTR *PFN_vkCmdDebugMarkerBeginEXT)(VkCommandBuffer commandBuffer, const VkDebugMarkerMarkerInfoEXT* pMarkerInfo);
//typedef void (VKAPI_PTR *PFN_vkCmdDebugMarkerEndEXT)(VkCommandBuffer commandBuffer);
//typedef void (VKAPI_PTR *PFN_vkCmdDebugMarkerInsertEXT)(VkCommandBuffer commandBuffer, const VkDebugMarkerMarkerInfoEXT* pMarkerInfo);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkDebugMarkerSetObjectTagEXT(
//VkDevice                                    device,
//const VkDebugMarkerObjectTagInfoEXT*        pTagInfo);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkDebugMarkerSetObjectNameEXT(
//VkDevice                                    device,
//const VkDebugMarkerObjectNameInfoEXT*       pNameInfo);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdDebugMarkerBeginEXT(
//VkCommandBuffer                             commandBuffer,
//const VkDebugMarkerMarkerInfoEXT*           pMarkerInfo);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdDebugMarkerEndEXT(
//VkCommandBuffer                             commandBuffer);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdDebugMarkerInsertEXT(
//VkCommandBuffer                             commandBuffer,
//const VkDebugMarkerMarkerInfoEXT*           pMarkerInfo);
//#endif
//
//#define VK_AMD_gcn_shader 1
//#define VK_AMD_GCN_SHADER_SPEC_VERSION    1
//#define VK_AMD_GCN_SHADER_EXTENSION_NAME  "VK_AMD_gcn_shader"
//
//
//#define VK_NV_dedicated_allocation 1
//#define VK_NV_DEDICATED_ALLOCATION_SPEC_VERSION 1
//#define VK_NV_DEDICATED_ALLOCATION_EXTENSION_NAME "VK_NV_dedicated_allocation"
//
//typedef struct VkDedicatedAllocationImageCreateInfoNV {
//    VkStructureType    sType;
//    const void*        pNext;
//    VkBool32           dedicatedAllocation;
//} VkDedicatedAllocationImageCreateInfoNV;
//
//typedef struct VkDedicatedAllocationBufferCreateInfoNV {
//    VkStructureType    sType;
//    const void*        pNext;
//    VkBool32           dedicatedAllocation;
//} VkDedicatedAllocationBufferCreateInfoNV;
//
//typedef struct VkDedicatedAllocationMemoryAllocateInfoNV {
//    VkStructureType    sType;
//    const void*        pNext;
//    VkImage            image;
//    VkBuffer           buffer;
//} VkDedicatedAllocationMemoryAllocateInfoNV;
//
//
//
//#define VK_AMD_draw_indirect_count 1
//#define VK_AMD_DRAW_INDIRECT_COUNT_SPEC_VERSION 1
//#define VK_AMD_DRAW_INDIRECT_COUNT_EXTENSION_NAME "VK_AMD_draw_indirect_count"
//
//typedef void (VKAPI_PTR *PFN_vkCmdDrawIndirectCountAMD)(VkCommandBuffer commandBuffer, VkBuffer buffer, VkDeviceSize offset, VkBuffer countBuffer, VkDeviceSize countBufferOffset, uint32_t maxDrawCount, uint32_t stride);
//typedef void (VKAPI_PTR *PFN_vkCmdDrawIndexedIndirectCountAMD)(VkCommandBuffer commandBuffer, VkBuffer buffer, VkDeviceSize offset, VkBuffer countBuffer, VkDeviceSize countBufferOffset, uint32_t maxDrawCount, uint32_t stride);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR void VKAPI_CALL vkCmdDrawIndirectCountAMD(
//VkCommandBuffer                             commandBuffer,
//VkBuffer                                    buffer,
//VkDeviceSize                                offset,
//VkBuffer                                    countBuffer,
//VkDeviceSize                                countBufferOffset,
//uint32_t                                    maxDrawCount,
//uint32_t                                    stride);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdDrawIndexedIndirectCountAMD(
//VkCommandBuffer                             commandBuffer,
//VkBuffer                                    buffer,
//VkDeviceSize                                offset,
//VkBuffer                                    countBuffer,
//VkDeviceSize                                countBufferOffset,
//uint32_t                                    maxDrawCount,
//uint32_t                                    stride);
//#endif
//
//#define VK_AMD_negative_viewport_height 1
//#define VK_AMD_NEGATIVE_VIEWPORT_HEIGHT_SPEC_VERSION 1
//#define VK_AMD_NEGATIVE_VIEWPORT_HEIGHT_EXTENSION_NAME "VK_AMD_negative_viewport_height"
//
//
//#define VK_AMD_gpu_shader_half_float 1
//#define VK_AMD_GPU_SHADER_HALF_FLOAT_SPEC_VERSION 1
//#define VK_AMD_GPU_SHADER_HALF_FLOAT_EXTENSION_NAME "VK_AMD_gpu_shader_half_float"
//
//
//#define VK_AMD_shader_ballot 1
//#define VK_AMD_SHADER_BALLOT_SPEC_VERSION 1
//#define VK_AMD_SHADER_BALLOT_EXTENSION_NAME "VK_AMD_shader_ballot"
//
//
//#define VK_AMD_texture_gather_bias_lod 1
//#define VK_AMD_TEXTURE_GATHER_BIAS_LOD_SPEC_VERSION 1
//#define VK_AMD_TEXTURE_GATHER_BIAS_LOD_EXTENSION_NAME "VK_AMD_texture_gather_bias_lod"
//
//typedef struct VkTextureLODGatherFormatPropertiesAMD {
//    VkStructureType    sType;
//    void*              pNext;
//    VkBool32           supportsTextureGatherLODBiasAMD;
//} VkTextureLODGatherFormatPropertiesAMD;
//
//
//
//#define VK_AMD_shader_info 1
//#define VK_AMD_SHADER_INFO_SPEC_VERSION   1
//#define VK_AMD_SHADER_INFO_EXTENSION_NAME "VK_AMD_shader_info"
//
//
//typedef enum VkShaderInfoTypeAMD {
//    VK_SHADER_INFO_TYPE_STATISTICS_AMD = 0,
//    VK_SHADER_INFO_TYPE_BINARY_AMD = 1,
//    VK_SHADER_INFO_TYPE_DISASSEMBLY_AMD = 2,
//    VK_SHADER_INFO_TYPE_BEGIN_RANGE_AMD = VK_SHADER_INFO_TYPE_STATISTICS_AMD,
//    VK_SHADER_INFO_TYPE_END_RANGE_AMD = VK_SHADER_INFO_TYPE_DISASSEMBLY_AMD,
//    VK_SHADER_INFO_TYPE_RANGE_SIZE_AMD = (VK_SHADER_INFO_TYPE_DISASSEMBLY_AMD - VK_SHADER_INFO_TYPE_STATISTICS_AMD + 1),
//    VK_SHADER_INFO_TYPE_MAX_ENUM_AMD = 0x7FFFFFFF
//} VkShaderInfoTypeAMD;
//
//typedef struct VkShaderResourceUsageAMD {
//    uint32_t    numUsedVgprs;
//    uint32_t    numUsedSgprs;
//    uint32_t    ldsSizePerLocalWorkGroup;
//    size_t      ldsUsageSizeInBytes;
//    size_t      scratchMemUsageInBytes;
//} VkShaderResourceUsageAMD;
//
//typedef struct VkShaderStatisticsInfoAMD {
//    VkShaderStageFlags          shaderStageMask;
//    VkShaderResourceUsageAMD    resourceUsage;
//    uint32_t                    numPhysicalVgprs;
//    uint32_t                    numPhysicalSgprs;
//    uint32_t                    numAvailableVgprs;
//    uint32_t                    numAvailableSgprs;
//    uint32_t                    computeWorkGroupSize[3];
//} VkShaderStatisticsInfoAMD;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkGetShaderInfoAMD)(VkDevice device, VkPipeline pipeline, VkShaderStageFlagBits shaderStage, VkShaderInfoTypeAMD infoType, size_t* pInfoSize, void* pInfo);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkGetShaderInfoAMD(
//VkDevice                                    device,
//VkPipeline                                  pipeline,
//VkShaderStageFlagBits                       shaderStage,
//VkShaderInfoTypeAMD                         infoType,
//size_t*                                     pInfoSize,
//void*                                       pInfo);
//#endif
//
//#define VK_AMD_shader_image_load_store_lod 1
//#define VK_AMD_SHADER_IMAGE_LOAD_STORE_LOD_SPEC_VERSION 1
//#define VK_AMD_SHADER_IMAGE_LOAD_STORE_LOD_EXTENSION_NAME "VK_AMD_shader_image_load_store_lod"
//
//
//#define VK_KHX_multiview 1
//#define VK_KHX_MULTIVIEW_SPEC_VERSION     1
//#define VK_KHX_MULTIVIEW_EXTENSION_NAME   "VK_KHX_multiview"
//
//typedef struct VkRenderPassMultiviewCreateInfoKHX {
//    VkStructureType    sType;
//    const void*        pNext;
//    uint32_t           subpassCount;
//    const uint32_t*    pViewMasks;
//    uint32_t           dependencyCount;
//    const int32_t*     pViewOffsets;
//    uint32_t           correlationMaskCount;
//    const uint32_t*    pCorrelationMasks;
//} VkRenderPassMultiviewCreateInfoKHX;
//
//typedef struct VkPhysicalDeviceMultiviewFeaturesKHX {
//    VkStructureType    sType;
//    void*              pNext;
//    VkBool32           multiview;
//    VkBool32           multiviewGeometryShader;
//    VkBool32           multiviewTessellationShader;
//} VkPhysicalDeviceMultiviewFeaturesKHX;
//
//typedef struct VkPhysicalDeviceMultiviewPropertiesKHX {
//    VkStructureType    sType;
//    void*              pNext;
//    uint32_t           maxMultiviewViewCount;
//    uint32_t           maxMultiviewInstanceIndex;
//} VkPhysicalDeviceMultiviewPropertiesKHX;
//
//
//
//#define VK_IMG_format_pvrtc 1
//#define VK_IMG_FORMAT_PVRTC_SPEC_VERSION  1
//#define VK_IMG_FORMAT_PVRTC_EXTENSION_NAME "VK_IMG_format_pvrtc"
//
//
//#define VK_NV_external_memory_capabilities 1
//#define VK_NV_EXTERNAL_MEMORY_CAPABILITIES_SPEC_VERSION 1
//#define VK_NV_EXTERNAL_MEMORY_CAPABILITIES_EXTENSION_NAME "VK_NV_external_memory_capabilities"
//
//
//typedef enum VkExternalMemoryHandleTypeFlagBitsNV {
//    VK_EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_WIN32_BIT_NV = 0x00000001,
//    VK_EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_WIN32_KMT_BIT_NV = 0x00000002,
//    VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D11_IMAGE_BIT_NV = 0x00000004,
//    VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D11_IMAGE_KMT_BIT_NV = 0x00000008,
//    VK_EXTERNAL_MEMORY_HANDLE_TYPE_FLAG_BITS_MAX_ENUM_NV = 0x7FFFFFFF
//} VkExternalMemoryHandleTypeFlagBitsNV;
//typedef VkFlags VkExternalMemoryHandleTypeFlagsNV;
//
//typedef enum VkExternalMemoryFeatureFlagBitsNV {
//    VK_EXTERNAL_MEMORY_FEATURE_DEDICATED_ONLY_BIT_NV = 0x00000001,
//    VK_EXTERNAL_MEMORY_FEATURE_EXPORTABLE_BIT_NV = 0x00000002,
//    VK_EXTERNAL_MEMORY_FEATURE_IMPORTABLE_BIT_NV = 0x00000004,
//    VK_EXTERNAL_MEMORY_FEATURE_FLAG_BITS_MAX_ENUM_NV = 0x7FFFFFFF
//} VkExternalMemoryFeatureFlagBitsNV;
//typedef VkFlags VkExternalMemoryFeatureFlagsNV;
//
//typedef struct VkExternalImageFormatPropertiesNV {
//    VkImageFormatProperties              imageFormatProperties;
//    VkExternalMemoryFeatureFlagsNV       externalMemoryFeatures;
//    VkExternalMemoryHandleTypeFlagsNV    exportFromImportedHandleTypes;
//    VkExternalMemoryHandleTypeFlagsNV    compatibleHandleTypes;
//} VkExternalImageFormatPropertiesNV;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkGetPhysicalDeviceExternalImageFormatPropertiesNV)(VkPhysicalDevice physicalDevice, VkFormat format, VkImageType type, VkImageTiling tiling, VkImageUsageFlags usage, VkImageCreateFlags flags, VkExternalMemoryHandleTypeFlagsNV externalHandleType, VkExternalImageFormatPropertiesNV* pExternalImageFormatProperties);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkGetPhysicalDeviceExternalImageFormatPropertiesNV(
//VkPhysicalDevice                            physicalDevice,
//VkFormat                                    format,
//VkImageType                                 type,
//VkImageTiling                               tiling,
//VkImageUsageFlags                           usage,
//VkImageCreateFlags                          flags,
//VkExternalMemoryHandleTypeFlagsNV           externalHandleType,
//VkExternalImageFormatPropertiesNV*          pExternalImageFormatProperties);
//#endif
//
//#define VK_NV_external_memory 1
//#define VK_NV_EXTERNAL_MEMORY_SPEC_VERSION 1
//#define VK_NV_EXTERNAL_MEMORY_EXTENSION_NAME "VK_NV_external_memory"
//
//typedef struct VkExternalMemoryImageCreateInfoNV {
//    VkStructureType                      sType;
//    const void*                          pNext;
//    VkExternalMemoryHandleTypeFlagsNV    handleTypes;
//} VkExternalMemoryImageCreateInfoNV;
//
//typedef struct VkExportMemoryAllocateInfoNV {
//    VkStructureType                      sType;
//    const void*                          pNext;
//    VkExternalMemoryHandleTypeFlagsNV    handleTypes;
//} VkExportMemoryAllocateInfoNV;
//
//
//
//#ifdef VK_USE_PLATFORM_WIN32_KHR
//#define VK_NV_external_memory_win32 1
//#define VK_NV_EXTERNAL_MEMORY_WIN32_SPEC_VERSION 1
//#define VK_NV_EXTERNAL_MEMORY_WIN32_EXTENSION_NAME "VK_NV_external_memory_win32"
//
//typedef struct VkImportMemoryWin32HandleInfoNV {
//    VkStructureType                      sType;
//    const void*                          pNext;
//    VkExternalMemoryHandleTypeFlagsNV    handleType;
//    HANDLE                               handle;
//} VkImportMemoryWin32HandleInfoNV;
//
//typedef struct VkExportMemoryWin32HandleInfoNV {
//    VkStructureType               sType;
//    const void*                   pNext;
//    const SECURITY_ATTRIBUTES*    pAttributes;
//    DWORD                         dwAccess;
//} VkExportMemoryWin32HandleInfoNV;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkGetMemoryWin32HandleNV)(VkDevice device, VkDeviceMemory memory, VkExternalMemoryHandleTypeFlagsNV handleType, HANDLE* pHandle);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkGetMemoryWin32HandleNV(
//VkDevice                                    device,
//VkDeviceMemory                              memory,
//VkExternalMemoryHandleTypeFlagsNV           handleType,
//HANDLE*                                     pHandle);
//#endif
//#endif /* VK_USE_PLATFORM_WIN32_KHR */
//
//#ifdef VK_USE_PLATFORM_WIN32_KHR
//#define VK_NV_win32_keyed_mutex 1
//#define VK_NV_WIN32_KEYED_MUTEX_SPEC_VERSION 1
//#define VK_NV_WIN32_KEYED_MUTEX_EXTENSION_NAME "VK_NV_win32_keyed_mutex"
//
//typedef struct VkWin32KeyedMutexAcquireReleaseInfoNV {
//    VkStructureType          sType;
//    const void*              pNext;
//    uint32_t                 acquireCount;
//    const VkDeviceMemory*    pAcquireSyncs;
//    const uint64_t*          pAcquireKeys;
//    const uint32_t*          pAcquireTimeoutMilliseconds;
//    uint32_t                 releaseCount;
//    const VkDeviceMemory*    pReleaseSyncs;
//    const uint64_t*          pReleaseKeys;
//} VkWin32KeyedMutexAcquireReleaseInfoNV;
//
//
//#endif /* VK_USE_PLATFORM_WIN32_KHR */
//
//#define VK_KHX_device_group 1
//#define VK_KHX_DEVICE_GROUP_SPEC_VERSION  2
//#define VK_KHX_DEVICE_GROUP_EXTENSION_NAME "VK_KHX_device_group"
//#define VK_MAX_DEVICE_GROUP_SIZE_KHX      32
//
//
//typedef enum VkPeerMemoryFeatureFlagBitsKHX {
//    VK_PEER_MEMORY_FEATURE_COPY_SRC_BIT_KHX = 0x00000001,
//    VK_PEER_MEMORY_FEATURE_COPY_DST_BIT_KHX = 0x00000002,
//    VK_PEER_MEMORY_FEATURE_GENERIC_SRC_BIT_KHX = 0x00000004,
//    VK_PEER_MEMORY_FEATURE_GENERIC_DST_BIT_KHX = 0x00000008,
//    VK_PEER_MEMORY_FEATURE_FLAG_BITS_MAX_ENUM_KHX = 0x7FFFFFFF
//} VkPeerMemoryFeatureFlagBitsKHX;
//typedef VkFlags VkPeerMemoryFeatureFlagsKHX;
//
//typedef enum VkMemoryAllocateFlagBitsKHX {
//    VK_MEMORY_ALLOCATE_DEVICE_MASK_BIT_KHX = 0x00000001,
//    VK_MEMORY_ALLOCATE_FLAG_BITS_MAX_ENUM_KHX = 0x7FFFFFFF
//} VkMemoryAllocateFlagBitsKHX;
//typedef VkFlags VkMemoryAllocateFlagsKHX;
//
//typedef enum VkDeviceGroupPresentModeFlagBitsKHX {
//    VK_DEVICE_GROUP_PRESENT_MODE_LOCAL_BIT_KHX = 0x00000001,
//    VK_DEVICE_GROUP_PRESENT_MODE_REMOTE_BIT_KHX = 0x00000002,
//    VK_DEVICE_GROUP_PRESENT_MODE_SUM_BIT_KHX = 0x00000004,
//    VK_DEVICE_GROUP_PRESENT_MODE_LOCAL_MULTI_DEVICE_BIT_KHX = 0x00000008,
//    VK_DEVICE_GROUP_PRESENT_MODE_FLAG_BITS_MAX_ENUM_KHX = 0x7FFFFFFF
//} VkDeviceGroupPresentModeFlagBitsKHX;
//typedef VkFlags VkDeviceGroupPresentModeFlagsKHX;
//
//typedef struct VkMemoryAllocateFlagsInfoKHX {
//    VkStructureType             sType;
//    const void*                 pNext;
//    VkMemoryAllocateFlagsKHX    flags;
//    uint32_t                    deviceMask;
//} VkMemoryAllocateFlagsInfoKHX;
//
//typedef struct VkDeviceGroupRenderPassBeginInfoKHX {
//    VkStructureType    sType;
//    const void*        pNext;
//    uint32_t           deviceMask;
//    uint32_t           deviceRenderAreaCount;
//    const VkRect2D*    pDeviceRenderAreas;
//} VkDeviceGroupRenderPassBeginInfoKHX;
//
//typedef struct VkDeviceGroupCommandBufferBeginInfoKHX {
//    VkStructureType    sType;
//    const void*        pNext;
//    uint32_t           deviceMask;
//} VkDeviceGroupCommandBufferBeginInfoKHX;
//
//typedef struct VkDeviceGroupSubmitInfoKHX {
//    VkStructureType    sType;
//    const void*        pNext;
//    uint32_t           waitSemaphoreCount;
//    const uint32_t*    pWaitSemaphoreDeviceIndices;
//    uint32_t           commandBufferCount;
//    const uint32_t*    pCommandBufferDeviceMasks;
//    uint32_t           signalSemaphoreCount;
//    const uint32_t*    pSignalSemaphoreDeviceIndices;
//} VkDeviceGroupSubmitInfoKHX;
//
//typedef struct VkDeviceGroupBindSparseInfoKHX {
//    VkStructureType    sType;
//    const void*        pNext;
//    uint32_t           resourceDeviceIndex;
//    uint32_t           memoryDeviceIndex;
//} VkDeviceGroupBindSparseInfoKHX;
//
//typedef struct VkBindBufferMemoryDeviceGroupInfoKHX {
//    VkStructureType    sType;
//    const void*        pNext;
//    uint32_t           deviceIndexCount;
//    const uint32_t*    pDeviceIndices;
//} VkBindBufferMemoryDeviceGroupInfoKHX;
//
//typedef struct VkBindImageMemoryDeviceGroupInfoKHX {
//    VkStructureType    sType;
//    const void*        pNext;
//    uint32_t           deviceIndexCount;
//    const uint32_t*    pDeviceIndices;
//    uint32_t           SFRRectCount;
//    const VkRect2D*    pSFRRects;
//} VkBindImageMemoryDeviceGroupInfoKHX;
//
//typedef struct VkDeviceGroupPresentCapabilitiesKHX {
//    VkStructureType                     sType;
//    const void*                         pNext;
//    uint32_t                            presentMask[VK_MAX_DEVICE_GROUP_SIZE_KHX];
//    VkDeviceGroupPresentModeFlagsKHX    modes;
//} VkDeviceGroupPresentCapabilitiesKHX;
//
//typedef struct VkImageSwapchainCreateInfoKHX {
//    VkStructureType    sType;
//    const void*        pNext;
//    VkSwapchainKHR     swapchain;
//} VkImageSwapchainCreateInfoKHX;
//
//typedef struct VkBindImageMemorySwapchainInfoKHX {
//    VkStructureType    sType;
//    const void*        pNext;
//    VkSwapchainKHR     swapchain;
//    uint32_t           imageIndex;
//} VkBindImageMemorySwapchainInfoKHX;
//
//typedef struct VkAcquireNextImageInfoKHX {
//    VkStructureType    sType;
//    const void*        pNext;
//    VkSwapchainKHR     swapchain;
//    uint64_t           timeout;
//    VkSemaphore        semaphore;
//    VkFence            fence;
//    uint32_t           deviceMask;
//} VkAcquireNextImageInfoKHX;
//
//typedef struct VkDeviceGroupPresentInfoKHX {
//    VkStructureType                        sType;
//    const void*                            pNext;
//    uint32_t                               swapchainCount;
//    const uint32_t*                        pDeviceMasks;
//    VkDeviceGroupPresentModeFlagBitsKHX    mode;
//} VkDeviceGroupPresentInfoKHX;
//
//typedef struct VkDeviceGroupSwapchainCreateInfoKHX {
//    VkStructureType                     sType;
//    const void*                         pNext;
//    VkDeviceGroupPresentModeFlagsKHX    modes;
//} VkDeviceGroupSwapchainCreateInfoKHX;
//
//
//typedef void (VKAPI_PTR *PFN_vkGetDeviceGroupPeerMemoryFeaturesKHX)(VkDevice device, uint32_t heapIndex, uint32_t localDeviceIndex, uint32_t remoteDeviceIndex, VkPeerMemoryFeatureFlagsKHX* pPeerMemoryFeatures);
//typedef void (VKAPI_PTR *PFN_vkCmdSetDeviceMaskKHX)(VkCommandBuffer commandBuffer, uint32_t deviceMask);
//typedef void (VKAPI_PTR *PFN_vkCmdDispatchBaseKHX)(VkCommandBuffer commandBuffer, uint32_t baseGroupX, uint32_t baseGroupY, uint32_t baseGroupZ, uint32_t groupCountX, uint32_t groupCountY, uint32_t groupCountZ);
//typedef VkResult (VKAPI_PTR *PFN_vkGetDeviceGroupPresentCapabilitiesKHX)(VkDevice device, VkDeviceGroupPresentCapabilitiesKHX* pDeviceGroupPresentCapabilities);
//typedef VkResult (VKAPI_PTR *PFN_vkGetDeviceGroupSurfacePresentModesKHX)(VkDevice device, VkSurfaceKHR surface, VkDeviceGroupPresentModeFlagsKHX* pModes);
//typedef VkResult (VKAPI_PTR *PFN_vkGetPhysicalDevicePresentRectanglesKHX)(VkPhysicalDevice physicalDevice, VkSurfaceKHR surface, uint32_t* pRectCount, VkRect2D* pRects);
//typedef VkResult (VKAPI_PTR *PFN_vkAcquireNextImage2KHX)(VkDevice device, const VkAcquireNextImageInfoKHX* pAcquireInfo, uint32_t* pImageIndex);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR void VKAPI_CALL vkGetDeviceGroupPeerMemoryFeaturesKHX(
//VkDevice                                    device,
//uint32_t                                    heapIndex,
//uint32_t                                    localDeviceIndex,
//uint32_t                                    remoteDeviceIndex,
//VkPeerMemoryFeatureFlagsKHX*                pPeerMemoryFeatures);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdSetDeviceMaskKHX(
//VkCommandBuffer                             commandBuffer,
//uint32_t                                    deviceMask);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdDispatchBaseKHX(
//VkCommandBuffer                             commandBuffer,
//uint32_t                                    baseGroupX,
//uint32_t                                    baseGroupY,
//uint32_t                                    baseGroupZ,
//uint32_t                                    groupCountX,
//uint32_t                                    groupCountY,
//uint32_t                                    groupCountZ);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetDeviceGroupPresentCapabilitiesKHX(
//VkDevice                                    device,
//VkDeviceGroupPresentCapabilitiesKHX*        pDeviceGroupPresentCapabilities);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetDeviceGroupSurfacePresentModesKHX(
//VkDevice                                    device,
//VkSurfaceKHR                                surface,
//VkDeviceGroupPresentModeFlagsKHX*           pModes);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetPhysicalDevicePresentRectanglesKHX(
//VkPhysicalDevice                            physicalDevice,
//VkSurfaceKHR                                surface,
//uint32_t*                                   pRectCount,
//VkRect2D*                                   pRects);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkAcquireNextImage2KHX(
//VkDevice                                    device,
//const VkAcquireNextImageInfoKHX*            pAcquireInfo,
//uint32_t*                                   pImageIndex);
//#endif
//
//#define VK_EXT_validation_flags 1
//#define VK_EXT_VALIDATION_FLAGS_SPEC_VERSION 1
//#define VK_EXT_VALIDATION_FLAGS_EXTENSION_NAME "VK_EXT_validation_flags"
//
//
//typedef enum VkValidationCheckEXT {
//    VK_VALIDATION_CHECK_ALL_EXT = 0,
//    VK_VALIDATION_CHECK_SHADERS_EXT = 1,
//    VK_VALIDATION_CHECK_BEGIN_RANGE_EXT = VK_VALIDATION_CHECK_ALL_EXT,
//    VK_VALIDATION_CHECK_END_RANGE_EXT = VK_VALIDATION_CHECK_SHADERS_EXT,
//    VK_VALIDATION_CHECK_RANGE_SIZE_EXT = (VK_VALIDATION_CHECK_SHADERS_EXT - VK_VALIDATION_CHECK_ALL_EXT + 1),
//    VK_VALIDATION_CHECK_MAX_ENUM_EXT = 0x7FFFFFFF
//} VkValidationCheckEXT;
//
//typedef struct VkValidationFlagsEXT {
//    VkStructureType          sType;
//    const void*              pNext;
//    uint32_t                 disabledValidationCheckCount;
//    VkValidationCheckEXT*    pDisabledValidationChecks;
//} VkValidationFlagsEXT;
//
//
//
//#ifdef VK_USE_PLATFORM_VI_NN
//#define VK_NN_vi_surface 1
//#define VK_NN_VI_SURFACE_SPEC_VERSION     1
//#define VK_NN_VI_SURFACE_EXTENSION_NAME   "VK_NN_vi_surface"
//
//typedef VkFlags VkViSurfaceCreateFlagsNN;
//
//typedef struct VkViSurfaceCreateInfoNN {
//    VkStructureType             sType;
//    const void*                 pNext;
//    VkViSurfaceCreateFlagsNN    flags;
//    void*                       window;
//} VkViSurfaceCreateInfoNN;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkCreateViSurfaceNN)(VkInstance instance, const VkViSurfaceCreateInfoNN* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkSurfaceKHR* pSurface);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateViSurfaceNN(
//VkInstance                                  instance,
//const VkViSurfaceCreateInfoNN*              pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkSurfaceKHR*                               pSurface);
//#endif
//#endif /* VK_USE_PLATFORM_VI_NN */
//
//#define VK_EXT_shader_subgroup_ballot 1
//#define VK_EXT_SHADER_SUBGROUP_BALLOT_SPEC_VERSION 1
//#define VK_EXT_SHADER_SUBGROUP_BALLOT_EXTENSION_NAME "VK_EXT_shader_subgroup_ballot"
//
//
//#define VK_EXT_shader_subgroup_vote 1
//#define VK_EXT_SHADER_SUBGROUP_VOTE_SPEC_VERSION 1
//#define VK_EXT_SHADER_SUBGROUP_VOTE_EXTENSION_NAME "VK_EXT_shader_subgroup_vote"
//
//
//#define VK_KHX_device_group_creation 1
//#define VK_KHX_DEVICE_GROUP_CREATION_SPEC_VERSION 1
//#define VK_KHX_DEVICE_GROUP_CREATION_EXTENSION_NAME "VK_KHX_device_group_creation"
//
//typedef struct VkPhysicalDeviceGroupPropertiesKHX {
//    VkStructureType     sType;
//    void*               pNext;
//    uint32_t            physicalDeviceCount;
//    VkPhysicalDevice    physicalDevices[VK_MAX_DEVICE_GROUP_SIZE_KHX];
//    VkBool32            subsetAllocation;
//} VkPhysicalDeviceGroupPropertiesKHX;
//
//typedef struct VkDeviceGroupDeviceCreateInfoKHX {
//    VkStructureType            sType;
//    const void*                pNext;
//    uint32_t                   physicalDeviceCount;
//    const VkPhysicalDevice*    pPhysicalDevices;
//} VkDeviceGroupDeviceCreateInfoKHX;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkEnumeratePhysicalDeviceGroupsKHX)(VkInstance instance, uint32_t* pPhysicalDeviceGroupCount, VkPhysicalDeviceGroupPropertiesKHX* pPhysicalDeviceGroupProperties);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkEnumeratePhysicalDeviceGroupsKHX(
//VkInstance                                  instance,
//uint32_t*                                   pPhysicalDeviceGroupCount,
//VkPhysicalDeviceGroupPropertiesKHX*         pPhysicalDeviceGroupProperties);
//#endif
//
//#define VK_NVX_device_generated_commands 1
//VK_DEFINE_NON_DISPATCHABLE_HANDLE(VkObjectTableNVX)
//VK_DEFINE_NON_DISPATCHABLE_HANDLE(VkIndirectCommandsLayoutNVX)
//
//#define VK_NVX_DEVICE_GENERATED_COMMANDS_SPEC_VERSION 3
//#define VK_NVX_DEVICE_GENERATED_COMMANDS_EXTENSION_NAME "VK_NVX_device_generated_commands"
//
//
//typedef enum VkIndirectCommandsTokenTypeNVX {
//    VK_INDIRECT_COMMANDS_TOKEN_TYPE_PIPELINE_NVX = 0,
//    VK_INDIRECT_COMMANDS_TOKEN_TYPE_DESCRIPTOR_SET_NVX = 1,
//    VK_INDIRECT_COMMANDS_TOKEN_TYPE_INDEX_BUFFER_NVX = 2,
//    VK_INDIRECT_COMMANDS_TOKEN_TYPE_VERTEX_BUFFER_NVX = 3,
//    VK_INDIRECT_COMMANDS_TOKEN_TYPE_PUSH_CONSTANT_NVX = 4,
//    VK_INDIRECT_COMMANDS_TOKEN_TYPE_DRAW_INDEXED_NVX = 5,
//    VK_INDIRECT_COMMANDS_TOKEN_TYPE_DRAW_NVX = 6,
//    VK_INDIRECT_COMMANDS_TOKEN_TYPE_DISPATCH_NVX = 7,
//    VK_INDIRECT_COMMANDS_TOKEN_TYPE_BEGIN_RANGE_NVX = VK_INDIRECT_COMMANDS_TOKEN_TYPE_PIPELINE_NVX,
//    VK_INDIRECT_COMMANDS_TOKEN_TYPE_END_RANGE_NVX = VK_INDIRECT_COMMANDS_TOKEN_TYPE_DISPATCH_NVX,
//    VK_INDIRECT_COMMANDS_TOKEN_TYPE_RANGE_SIZE_NVX = (VK_INDIRECT_COMMANDS_TOKEN_TYPE_DISPATCH_NVX - VK_INDIRECT_COMMANDS_TOKEN_TYPE_PIPELINE_NVX + 1),
//    VK_INDIRECT_COMMANDS_TOKEN_TYPE_MAX_ENUM_NVX = 0x7FFFFFFF
//} VkIndirectCommandsTokenTypeNVX;
//
//typedef enum VkObjectEntryTypeNVX {
//    VK_OBJECT_ENTRY_TYPE_DESCRIPTOR_SET_NVX = 0,
//    VK_OBJECT_ENTRY_TYPE_PIPELINE_NVX = 1,
//    VK_OBJECT_ENTRY_TYPE_INDEX_BUFFER_NVX = 2,
//    VK_OBJECT_ENTRY_TYPE_VERTEX_BUFFER_NVX = 3,
//    VK_OBJECT_ENTRY_TYPE_PUSH_CONSTANT_NVX = 4,
//    VK_OBJECT_ENTRY_TYPE_BEGIN_RANGE_NVX = VK_OBJECT_ENTRY_TYPE_DESCRIPTOR_SET_NVX,
//    VK_OBJECT_ENTRY_TYPE_END_RANGE_NVX = VK_OBJECT_ENTRY_TYPE_PUSH_CONSTANT_NVX,
//    VK_OBJECT_ENTRY_TYPE_RANGE_SIZE_NVX = (VK_OBJECT_ENTRY_TYPE_PUSH_CONSTANT_NVX - VK_OBJECT_ENTRY_TYPE_DESCRIPTOR_SET_NVX + 1),
//    VK_OBJECT_ENTRY_TYPE_MAX_ENUM_NVX = 0x7FFFFFFF
//} VkObjectEntryTypeNVX;
//
//
//typedef enum VkIndirectCommandsLayoutUsageFlagBitsNVX {
//    VK_INDIRECT_COMMANDS_LAYOUT_USAGE_UNORDERED_SEQUENCES_BIT_NVX = 0x00000001,
//    VK_INDIRECT_COMMANDS_LAYOUT_USAGE_SPARSE_SEQUENCES_BIT_NVX = 0x00000002,
//    VK_INDIRECT_COMMANDS_LAYOUT_USAGE_EMPTY_EXECUTIONS_BIT_NVX = 0x00000004,
//    VK_INDIRECT_COMMANDS_LAYOUT_USAGE_INDEXED_SEQUENCES_BIT_NVX = 0x00000008,
//    VK_INDIRECT_COMMANDS_LAYOUT_USAGE_FLAG_BITS_MAX_ENUM_NVX = 0x7FFFFFFF
//} VkIndirectCommandsLayoutUsageFlagBitsNVX;
//typedef VkFlags VkIndirectCommandsLayoutUsageFlagsNVX;
//
//typedef enum VkObjectEntryUsageFlagBitsNVX {
//    VK_OBJECT_ENTRY_USAGE_GRAPHICS_BIT_NVX = 0x00000001,
//    VK_OBJECT_ENTRY_USAGE_COMPUTE_BIT_NVX = 0x00000002,
//    VK_OBJECT_ENTRY_USAGE_FLAG_BITS_MAX_ENUM_NVX = 0x7FFFFFFF
//} VkObjectEntryUsageFlagBitsNVX;
//typedef VkFlags VkObjectEntryUsageFlagsNVX;
//
//typedef struct VkDeviceGeneratedCommandsFeaturesNVX {
//    VkStructureType    sType;
//    const void*        pNext;
//    VkBool32           computeBindingPointSupport;
//} VkDeviceGeneratedCommandsFeaturesNVX;
//
//typedef struct VkDeviceGeneratedCommandsLimitsNVX {
//    VkStructureType    sType;
//    const void*        pNext;
//    uint32_t           maxIndirectCommandsLayoutTokenCount;
//    uint32_t           maxObjectEntryCounts;
//    uint32_t           minSequenceCountBufferOffsetAlignment;
//    uint32_t           minSequenceIndexBufferOffsetAlignment;
//    uint32_t           minCommandsTokenBufferOffsetAlignment;
//} VkDeviceGeneratedCommandsLimitsNVX;
//
//typedef struct VkIndirectCommandsTokenNVX {
//    VkIndirectCommandsTokenTypeNVX    tokenType;
//    VkBuffer                          buffer;
//    VkDeviceSize                      offset;
//} VkIndirectCommandsTokenNVX;
//
//typedef struct VkIndirectCommandsLayoutTokenNVX {
//    VkIndirectCommandsTokenTypeNVX    tokenType;
//    uint32_t                          bindingUnit;
//    uint32_t                          dynamicCount;
//    uint32_t                          divisor;
//} VkIndirectCommandsLayoutTokenNVX;
//
//typedef struct VkIndirectCommandsLayoutCreateInfoNVX {
//    VkStructureType                            sType;
//    const void*                                pNext;
//    VkPipelineBindPoint                        pipelineBindPoint;
//    VkIndirectCommandsLayoutUsageFlagsNVX      flags;
//    uint32_t                                   tokenCount;
//    const VkIndirectCommandsLayoutTokenNVX*    pTokens;
//} VkIndirectCommandsLayoutCreateInfoNVX;
//
//typedef struct VkCmdProcessCommandsInfoNVX {
//    VkStructureType                      sType;
//    const void*                          pNext;
//    VkObjectTableNVX                     objectTable;
//    VkIndirectCommandsLayoutNVX          indirectCommandsLayout;
//    uint32_t                             indirectCommandsTokenCount;
//    const VkIndirectCommandsTokenNVX*    pIndirectCommandsTokens;
//    uint32_t                             maxSequencesCount;
//    VkCommandBuffer                      targetCommandBuffer;
//    VkBuffer                             sequencesCountBuffer;
//    VkDeviceSize                         sequencesCountOffset;
//    VkBuffer                             sequencesIndexBuffer;
//    VkDeviceSize                         sequencesIndexOffset;
//} VkCmdProcessCommandsInfoNVX;
//
//typedef struct VkCmdReserveSpaceForCommandsInfoNVX {
//    VkStructureType                sType;
//    const void*                    pNext;
//    VkObjectTableNVX               objectTable;
//    VkIndirectCommandsLayoutNVX    indirectCommandsLayout;
//    uint32_t                       maxSequencesCount;
//} VkCmdReserveSpaceForCommandsInfoNVX;
//
//typedef struct VkObjectTableCreateInfoNVX {
//    VkStructureType                      sType;
//    const void*                          pNext;
//    uint32_t                             objectCount;
//    const VkObjectEntryTypeNVX*          pObjectEntryTypes;
//    const uint32_t*                      pObjectEntryCounts;
//    const VkObjectEntryUsageFlagsNVX*    pObjectEntryUsageFlags;
//    uint32_t                             maxUniformBuffersPerDescriptor;
//    uint32_t                             maxStorageBuffersPerDescriptor;
//    uint32_t                             maxStorageImagesPerDescriptor;
//    uint32_t                             maxSampledImagesPerDescriptor;
//    uint32_t                             maxPipelineLayouts;
//} VkObjectTableCreateInfoNVX;
//
//typedef struct VkObjectTableEntryNVX {
//    VkObjectEntryTypeNVX          type;
//    VkObjectEntryUsageFlagsNVX    flags;
//} VkObjectTableEntryNVX;
//
//typedef struct VkObjectTablePipelineEntryNVX {
//    VkObjectEntryTypeNVX          type;
//    VkObjectEntryUsageFlagsNVX    flags;
//    VkPipeline                    pipeline;
//} VkObjectTablePipelineEntryNVX;
//
//typedef struct VkObjectTableDescriptorSetEntryNVX {
//    VkObjectEntryTypeNVX          type;
//    VkObjectEntryUsageFlagsNVX    flags;
//    VkPipelineLayout              pipelineLayout;
//    VkDescriptorSet               descriptorSet;
//} VkObjectTableDescriptorSetEntryNVX;
//
//typedef struct VkObjectTableVertexBufferEntryNVX {
//    VkObjectEntryTypeNVX          type;
//    VkObjectEntryUsageFlagsNVX    flags;
//    VkBuffer                      buffer;
//} VkObjectTableVertexBufferEntryNVX;
//
//typedef struct VkObjectTableIndexBufferEntryNVX {
//    VkObjectEntryTypeNVX          type;
//    VkObjectEntryUsageFlagsNVX    flags;
//    VkBuffer                      buffer;
//    VkIndexType                   indexType;
//} VkObjectTableIndexBufferEntryNVX;
//
//typedef struct VkObjectTablePushConstantEntryNVX {
//    VkObjectEntryTypeNVX          type;
//    VkObjectEntryUsageFlagsNVX    flags;
//    VkPipelineLayout              pipelineLayout;
//    VkShaderStageFlags            stageFlags;
//} VkObjectTablePushConstantEntryNVX;
//
//
//typedef void (VKAPI_PTR *PFN_vkCmdProcessCommandsNVX)(VkCommandBuffer commandBuffer, const VkCmdProcessCommandsInfoNVX* pProcessCommandsInfo);
//typedef void (VKAPI_PTR *PFN_vkCmdReserveSpaceForCommandsNVX)(VkCommandBuffer commandBuffer, const VkCmdReserveSpaceForCommandsInfoNVX* pReserveSpaceInfo);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateIndirectCommandsLayoutNVX)(VkDevice device, const VkIndirectCommandsLayoutCreateInfoNVX* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkIndirectCommandsLayoutNVX* pIndirectCommandsLayout);
//typedef void (VKAPI_PTR *PFN_vkDestroyIndirectCommandsLayoutNVX)(VkDevice device, VkIndirectCommandsLayoutNVX indirectCommandsLayout, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateObjectTableNVX)(VkDevice device, const VkObjectTableCreateInfoNVX* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkObjectTableNVX* pObjectTable);
//typedef void (VKAPI_PTR *PFN_vkDestroyObjectTableNVX)(VkDevice device, VkObjectTableNVX objectTable, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkRegisterObjectsNVX)(VkDevice device, VkObjectTableNVX objectTable, uint32_t objectCount, const VkObjectTableEntryNVX* const*    ppObjectTableEntries, const uint32_t* pObjectIndices);
//typedef VkResult (VKAPI_PTR *PFN_vkUnregisterObjectsNVX)(VkDevice device, VkObjectTableNVX objectTable, uint32_t objectCount, const VkObjectEntryTypeNVX* pObjectEntryTypes, const uint32_t* pObjectIndices);
//typedef void (VKAPI_PTR *PFN_vkGetPhysicalDeviceGeneratedCommandsPropertiesNVX)(VkPhysicalDevice physicalDevice, VkDeviceGeneratedCommandsFeaturesNVX* pFeatures, VkDeviceGeneratedCommandsLimitsNVX* pLimits);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR void VKAPI_CALL vkCmdProcessCommandsNVX(
//VkCommandBuffer                             commandBuffer,
//const VkCmdProcessCommandsInfoNVX*          pProcessCommandsInfo);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdReserveSpaceForCommandsNVX(
//VkCommandBuffer                             commandBuffer,
//const VkCmdReserveSpaceForCommandsInfoNVX*  pReserveSpaceInfo);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateIndirectCommandsLayoutNVX(
//VkDevice                                    device,
//const VkIndirectCommandsLayoutCreateInfoNVX* pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkIndirectCommandsLayoutNVX*                pIndirectCommandsLayout);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyIndirectCommandsLayoutNVX(
//VkDevice                                    device,
//VkIndirectCommandsLayoutNVX                 indirectCommandsLayout,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateObjectTableNVX(
//VkDevice                                    device,
//const VkObjectTableCreateInfoNVX*           pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkObjectTableNVX*                           pObjectTable);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyObjectTableNVX(
//VkDevice                                    device,
//VkObjectTableNVX                            objectTable,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkRegisterObjectsNVX(
//VkDevice                                    device,
//VkObjectTableNVX                            objectTable,
//uint32_t                                    objectCount,
//const VkObjectTableEntryNVX* const*         ppObjectTableEntries,
//const uint32_t*                             pObjectIndices);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkUnregisterObjectsNVX(
//VkDevice                                    device,
//VkObjectTableNVX                            objectTable,
//uint32_t                                    objectCount,
//const VkObjectEntryTypeNVX*                 pObjectEntryTypes,
//const uint32_t*                             pObjectIndices);
//
//VKAPI_ATTR void VKAPI_CALL vkGetPhysicalDeviceGeneratedCommandsPropertiesNVX(
//VkPhysicalDevice                            physicalDevice,
//VkDeviceGeneratedCommandsFeaturesNVX*       pFeatures,
//VkDeviceGeneratedCommandsLimitsNVX*         pLimits);
//#endif
//
//#define VK_NV_clip_space_w_scaling 1
//#define VK_NV_CLIP_SPACE_W_SCALING_SPEC_VERSION 1
//#define VK_NV_CLIP_SPACE_W_SCALING_EXTENSION_NAME "VK_NV_clip_space_w_scaling"
//
//typedef struct VkViewportWScalingNV {
//    float    xcoeff;
//    float    ycoeff;
//} VkViewportWScalingNV;
//
//typedef struct VkPipelineViewportWScalingStateCreateInfoNV {
//    VkStructureType                sType;
//    const void*                    pNext;
//    VkBool32                       viewportWScalingEnable;
//    uint32_t                       viewportCount;
//    const VkViewportWScalingNV*    pViewportWScalings;
//} VkPipelineViewportWScalingStateCreateInfoNV;
//
//
//typedef void (VKAPI_PTR *PFN_vkCmdSetViewportWScalingNV)(VkCommandBuffer commandBuffer, uint32_t firstViewport, uint32_t viewportCount, const VkViewportWScalingNV* pViewportWScalings);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR void VKAPI_CALL vkCmdSetViewportWScalingNV(
//VkCommandBuffer                             commandBuffer,
//uint32_t                                    firstViewport,
//uint32_t                                    viewportCount,
//const VkViewportWScalingNV*                 pViewportWScalings);
//#endif
//
//#define VK_EXT_direct_mode_display 1
//#define VK_EXT_DIRECT_MODE_DISPLAY_SPEC_VERSION 1
//#define VK_EXT_DIRECT_MODE_DISPLAY_EXTENSION_NAME "VK_EXT_direct_mode_display"
//
//typedef VkResult (VKAPI_PTR *PFN_vkReleaseDisplayEXT)(VkPhysicalDevice physicalDevice, VkDisplayKHR display);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkReleaseDisplayEXT(
//VkPhysicalDevice                            physicalDevice,
//VkDisplayKHR                                display);
//#endif
//
//#ifdef VK_USE_PLATFORM_XLIB_XRANDR_EXT
//#define VK_EXT_acquire_xlib_display 1
//#include <X11/extensions/Xrandr.h>
//
//#define VK_EXT_ACQUIRE_XLIB_DISPLAY_SPEC_VERSION 1
//#define VK_EXT_ACQUIRE_XLIB_DISPLAY_EXTENSION_NAME "VK_EXT_acquire_xlib_display"
//
//typedef VkResult (VKAPI_PTR *PFN_vkAcquireXlibDisplayEXT)(VkPhysicalDevice physicalDevice, Display* dpy, VkDisplayKHR display);
//typedef VkResult (VKAPI_PTR *PFN_vkGetRandROutputDisplayEXT)(VkPhysicalDevice physicalDevice, Display* dpy, RROutput rrOutput, VkDisplayKHR* pDisplay);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkAcquireXlibDisplayEXT(
//VkPhysicalDevice                            physicalDevice,
//Display*                                    dpy,
//VkDisplayKHR                                display);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetRandROutputDisplayEXT(
//VkPhysicalDevice                            physicalDevice,
//Display*                                    dpy,
//RROutput                                    rrOutput,
//VkDisplayKHR*                               pDisplay);
//#endif
//#endif /* VK_USE_PLATFORM_XLIB_XRANDR_EXT */
//
//#define VK_EXT_display_surface_counter 1
//#define VK_EXT_DISPLAY_SURFACE_COUNTER_SPEC_VERSION 1
//#define VK_EXT_DISPLAY_SURFACE_COUNTER_EXTENSION_NAME "VK_EXT_display_surface_counter"
//#define SURFACE_CAPABILITIES2_EXT SURFACE_CAPABILITIES_2_EXT
//
//
//typedef enum VkSurfaceCounterFlagBitsEXT {
//    VK_SURFACE_COUNTER_VBLANK_EXT = 0x00000001,
//    VK_SURFACE_COUNTER_FLAG_BITS_MAX_ENUM_EXT = 0x7FFFFFFF
//} VkSurfaceCounterFlagBitsEXT;
//typedef VkFlags VkSurfaceCounterFlagsEXT;
//
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
//typedef VkResult (VKAPI_PTR *PFN_vkGetPhysicalDeviceSurfaceCapabilities2EXT)(VkPhysicalDevice physicalDevice, VkSurfaceKHR surface, VkSurfaceCapabilities2EXT* pSurfaceCapabilities);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkGetPhysicalDeviceSurfaceCapabilities2EXT(
//VkPhysicalDevice                            physicalDevice,
//VkSurfaceKHR                                surface,
//VkSurfaceCapabilities2EXT*                  pSurfaceCapabilities);
//#endif
//
//#define VK_EXT_display_control 1
//#define VK_EXT_DISPLAY_CONTROL_SPEC_VERSION 1
//#define VK_EXT_DISPLAY_CONTROL_EXTENSION_NAME "VK_EXT_display_control"
//
//
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
//
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
//typedef VkResult (VKAPI_PTR *PFN_vkDisplayPowerControlEXT)(VkDevice device, VkDisplayKHR display, const VkDisplayPowerInfoEXT* pDisplayPowerInfo);
//typedef VkResult (VKAPI_PTR *PFN_vkRegisterDeviceEventEXT)(VkDevice device, const VkDeviceEventInfoEXT* pDeviceEventInfo, const VkAllocationCallbacks* pAllocator, VkFence* pFence);
//typedef VkResult (VKAPI_PTR *PFN_vkRegisterDisplayEventEXT)(VkDevice device, VkDisplayKHR display, const VkDisplayEventInfoEXT* pDisplayEventInfo, const VkAllocationCallbacks* pAllocator, VkFence* pFence);
//typedef VkResult (VKAPI_PTR *PFN_vkGetSwapchainCounterEXT)(VkDevice device, VkSwapchainKHR swapchain, VkSurfaceCounterFlagBitsEXT counter, uint64_t* pCounterValue);
//
//#ifndef VK_NO_PROTOTYPES
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
//#endif
//
//#define VK_GOOGLE_display_timing 1
//#define VK_GOOGLE_DISPLAY_TIMING_SPEC_VERSION 1
//#define VK_GOOGLE_DISPLAY_TIMING_EXTENSION_NAME "VK_GOOGLE_display_timing"
//
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
//typedef VkResult (VKAPI_PTR *PFN_vkGetRefreshCycleDurationGOOGLE)(VkDevice device, VkSwapchainKHR swapchain, VkRefreshCycleDurationGOOGLE* pDisplayTimingProperties);
//typedef VkResult (VKAPI_PTR *PFN_vkGetPastPresentationTimingGOOGLE)(VkDevice device, VkSwapchainKHR swapchain, uint32_t* pPresentationTimingCount, VkPastPresentationTimingGOOGLE* pPresentationTimings);
//
//#ifndef VK_NO_PROTOTYPES
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
//#endif
//
//#define VK_NV_sample_mask_override_coverage 1
//#define VK_NV_SAMPLE_MASK_OVERRIDE_COVERAGE_SPEC_VERSION 1
//#define VK_NV_SAMPLE_MASK_OVERRIDE_COVERAGE_EXTENSION_NAME "VK_NV_sample_mask_override_coverage"
//
//
//#define VK_NV_geometry_shader_passthrough 1
//#define VK_NV_GEOMETRY_SHADER_PASSTHROUGH_SPEC_VERSION 1
//#define VK_NV_GEOMETRY_SHADER_PASSTHROUGH_EXTENSION_NAME "VK_NV_geometry_shader_passthrough"
//
//
//#define VK_NV_viewport_array2 1
//#define VK_NV_VIEWPORT_ARRAY2_SPEC_VERSION 1
//#define VK_NV_VIEWPORT_ARRAY2_EXTENSION_NAME "VK_NV_viewport_array2"
//
//
//#define VK_NVX_multiview_per_view_attributes 1
//#define VK_NVX_MULTIVIEW_PER_VIEW_ATTRIBUTES_SPEC_VERSION 1
//#define VK_NVX_MULTIVIEW_PER_VIEW_ATTRIBUTES_EXTENSION_NAME "VK_NVX_multiview_per_view_attributes"
//
//typedef struct VkPhysicalDeviceMultiviewPerViewAttributesPropertiesNVX {
//    VkStructureType    sType;
//    void*              pNext;
//    VkBool32           perViewPositionAllComponents;
//} VkPhysicalDeviceMultiviewPerViewAttributesPropertiesNVX;
//
//
//
//#define VK_NV_viewport_swizzle 1
//#define VK_NV_VIEWPORT_SWIZZLE_SPEC_VERSION 1
//#define VK_NV_VIEWPORT_SWIZZLE_EXTENSION_NAME "VK_NV_viewport_swizzle"
//
//
//typedef enum VkViewportCoordinateSwizzleNV {
//    VK_VIEWPORT_COORDINATE_SWIZZLE_POSITIVE_X_NV = 0,
//    VK_VIEWPORT_COORDINATE_SWIZZLE_NEGATIVE_X_NV = 1,
//    VK_VIEWPORT_COORDINATE_SWIZZLE_POSITIVE_Y_NV = 2,
//    VK_VIEWPORT_COORDINATE_SWIZZLE_NEGATIVE_Y_NV = 3,
//    VK_VIEWPORT_COORDINATE_SWIZZLE_POSITIVE_Z_NV = 4,
//    VK_VIEWPORT_COORDINATE_SWIZZLE_NEGATIVE_Z_NV = 5,
//    VK_VIEWPORT_COORDINATE_SWIZZLE_POSITIVE_W_NV = 6,
//    VK_VIEWPORT_COORDINATE_SWIZZLE_NEGATIVE_W_NV = 7,
//    VK_VIEWPORT_COORDINATE_SWIZZLE_BEGIN_RANGE_NV = VK_VIEWPORT_COORDINATE_SWIZZLE_POSITIVE_X_NV,
//    VK_VIEWPORT_COORDINATE_SWIZZLE_END_RANGE_NV = VK_VIEWPORT_COORDINATE_SWIZZLE_NEGATIVE_W_NV,
//    VK_VIEWPORT_COORDINATE_SWIZZLE_RANGE_SIZE_NV = (VK_VIEWPORT_COORDINATE_SWIZZLE_NEGATIVE_W_NV - VK_VIEWPORT_COORDINATE_SWIZZLE_POSITIVE_X_NV + 1),
//    VK_VIEWPORT_COORDINATE_SWIZZLE_MAX_ENUM_NV = 0x7FFFFFFF
//} VkViewportCoordinateSwizzleNV;
//
//typedef VkFlags VkPipelineViewportSwizzleStateCreateFlagsNV;
//
//typedef struct VkViewportSwizzleNV {
//    VkViewportCoordinateSwizzleNV    x;
//    VkViewportCoordinateSwizzleNV    y;
//    VkViewportCoordinateSwizzleNV    z;
//    VkViewportCoordinateSwizzleNV    w;
//} VkViewportSwizzleNV;
//
//typedef struct VkPipelineViewportSwizzleStateCreateInfoNV {
//    VkStructureType                                sType;
//    const void*                                    pNext;
//    VkPipelineViewportSwizzleStateCreateFlagsNV    flags;
//    uint32_t                                       viewportCount;
//    const VkViewportSwizzleNV*                     pViewportSwizzles;
//} VkPipelineViewportSwizzleStateCreateInfoNV;
//
//
//
//#define VK_EXT_discard_rectangles 1
//#define VK_EXT_DISCARD_RECTANGLES_SPEC_VERSION 1
//#define VK_EXT_DISCARD_RECTANGLES_EXTENSION_NAME "VK_EXT_discard_rectangles"
//
//
//typedef enum VkDiscardRectangleModeEXT {
//    VK_DISCARD_RECTANGLE_MODE_INCLUSIVE_EXT = 0,
//    VK_DISCARD_RECTANGLE_MODE_EXCLUSIVE_EXT = 1,
//    VK_DISCARD_RECTANGLE_MODE_BEGIN_RANGE_EXT = VK_DISCARD_RECTANGLE_MODE_INCLUSIVE_EXT,
//    VK_DISCARD_RECTANGLE_MODE_END_RANGE_EXT = VK_DISCARD_RECTANGLE_MODE_EXCLUSIVE_EXT,
//    VK_DISCARD_RECTANGLE_MODE_RANGE_SIZE_EXT = (VK_DISCARD_RECTANGLE_MODE_EXCLUSIVE_EXT - VK_DISCARD_RECTANGLE_MODE_INCLUSIVE_EXT + 1),
//    VK_DISCARD_RECTANGLE_MODE_MAX_ENUM_EXT = 0x7FFFFFFF
//} VkDiscardRectangleModeEXT;
//
//typedef VkFlags VkPipelineDiscardRectangleStateCreateFlagsEXT;
//
//typedef struct VkPhysicalDeviceDiscardRectanglePropertiesEXT {
//    VkStructureType    sType;
//    void*              pNext;
//    uint32_t           maxDiscardRectangles;
//} VkPhysicalDeviceDiscardRectanglePropertiesEXT;
//
//typedef struct VkPipelineDiscardRectangleStateCreateInfoEXT {
//    VkStructureType                                  sType;
//    const void*                                      pNext;
//    VkPipelineDiscardRectangleStateCreateFlagsEXT    flags;
//    VkDiscardRectangleModeEXT                        discardRectangleMode;
//    uint32_t                                         discardRectangleCount;
//    const VkRect2D*                                  pDiscardRectangles;
//} VkPipelineDiscardRectangleStateCreateInfoEXT;
//
//
//typedef void (VKAPI_PTR *PFN_vkCmdSetDiscardRectangleEXT)(VkCommandBuffer commandBuffer, uint32_t firstDiscardRectangle, uint32_t discardRectangleCount, const VkRect2D* pDiscardRectangles);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR void VKAPI_CALL vkCmdSetDiscardRectangleEXT(
//VkCommandBuffer                             commandBuffer,
//uint32_t                                    firstDiscardRectangle,
//uint32_t                                    discardRectangleCount,
//const VkRect2D*                             pDiscardRectangles);
//#endif
//
//#define VK_EXT_conservative_rasterization 1
//#define VK_EXT_CONSERVATIVE_RASTERIZATION_SPEC_VERSION 1
//#define VK_EXT_CONSERVATIVE_RASTERIZATION_EXTENSION_NAME "VK_EXT_conservative_rasterization"
//
//
//typedef enum VkConservativeRasterizationModeEXT {
//    VK_CONSERVATIVE_RASTERIZATION_MODE_DISABLED_EXT = 0,
//    VK_CONSERVATIVE_RASTERIZATION_MODE_OVERESTIMATE_EXT = 1,
//    VK_CONSERVATIVE_RASTERIZATION_MODE_UNDERESTIMATE_EXT = 2,
//    VK_CONSERVATIVE_RASTERIZATION_MODE_BEGIN_RANGE_EXT = VK_CONSERVATIVE_RASTERIZATION_MODE_DISABLED_EXT,
//    VK_CONSERVATIVE_RASTERIZATION_MODE_END_RANGE_EXT = VK_CONSERVATIVE_RASTERIZATION_MODE_UNDERESTIMATE_EXT,
//    VK_CONSERVATIVE_RASTERIZATION_MODE_RANGE_SIZE_EXT = (VK_CONSERVATIVE_RASTERIZATION_MODE_UNDERESTIMATE_EXT - VK_CONSERVATIVE_RASTERIZATION_MODE_DISABLED_EXT + 1),
//    VK_CONSERVATIVE_RASTERIZATION_MODE_MAX_ENUM_EXT = 0x7FFFFFFF
//} VkConservativeRasterizationModeEXT;
//
//typedef VkFlags VkPipelineRasterizationConservativeStateCreateFlagsEXT;
//
//typedef struct VkPhysicalDeviceConservativeRasterizationPropertiesEXT {
//    VkStructureType    sType;
//    void*              pNext;
//    float              primitiveOverestimationSize;
//    float              maxExtraPrimitiveOverestimationSize;
//    float              extraPrimitiveOverestimationSizeGranularity;
//    VkBool32           primitiveUnderestimation;
//    VkBool32           conservativePointAndLineRasterization;
//    VkBool32           degenerateTrianglesRasterized;
//    VkBool32           degenerateLinesRasterized;
//    VkBool32           fullyCoveredFragmentShaderInputVariable;
//    VkBool32           conservativeRasterizationPostDepthCoverage;
//} VkPhysicalDeviceConservativeRasterizationPropertiesEXT;
//
//typedef struct VkPipelineRasterizationConservativeStateCreateInfoEXT {
//    VkStructureType                                           sType;
//    const void*                                               pNext;
//    VkPipelineRasterizationConservativeStateCreateFlagsEXT    flags;
//    VkConservativeRasterizationModeEXT                        conservativeRasterizationMode;
//    float                                                     extraPrimitiveOverestimationSize;
//} VkPipelineRasterizationConservativeStateCreateInfoEXT;
//
//
//
//#define VK_EXT_swapchain_colorspace 1
//#define VK_EXT_SWAPCHAIN_COLOR_SPACE_SPEC_VERSION 3
//#define VK_EXT_SWAPCHAIN_COLOR_SPACE_EXTENSION_NAME "VK_EXT_swapchain_colorspace"
//
//
//#define VK_EXT_hdr_metadata 1
//#define VK_EXT_HDR_METADATA_SPEC_VERSION  1
//#define VK_EXT_HDR_METADATA_EXTENSION_NAME "VK_EXT_hdr_metadata"
//
//typedef struct VkXYColorEXT {
//    float    x;
//    float    y;
//} VkXYColorEXT;
//
//typedef struct VkHdrMetadataEXT {
//    VkStructureType    sType;
//    const void*        pNext;
//    VkXYColorEXT       displayPrimaryRed;
//    VkXYColorEXT       displayPrimaryGreen;
//    VkXYColorEXT       displayPrimaryBlue;
//    VkXYColorEXT       whitePoint;
//    float              maxLuminance;
//    float              minLuminance;
//    float              maxContentLightLevel;
//    float              maxFrameAverageLightLevel;
//} VkHdrMetadataEXT;
//
//
//typedef void (VKAPI_PTR *PFN_vkSetHdrMetadataEXT)(VkDevice device, uint32_t swapchainCount, const VkSwapchainKHR* pSwapchains, const VkHdrMetadataEXT* pMetadata);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR void VKAPI_CALL vkSetHdrMetadataEXT(
//VkDevice                                    device,
//uint32_t                                    swapchainCount,
//const VkSwapchainKHR*                       pSwapchains,
//const VkHdrMetadataEXT*                     pMetadata);
//#endif
//
//#ifdef VK_USE_PLATFORM_IOS_MVK
//#define VK_MVK_ios_surface 1
//#define VK_MVK_IOS_SURFACE_SPEC_VERSION   2
//#define VK_MVK_IOS_SURFACE_EXTENSION_NAME "VK_MVK_ios_surface"
//
//typedef VkFlags VkIOSSurfaceCreateFlagsMVK;
//
//typedef struct VkIOSSurfaceCreateInfoMVK {
//    VkStructureType               sType;
//    const void*                   pNext;
//    VkIOSSurfaceCreateFlagsMVK    flags;
//    const void*                   pView;
//} VkIOSSurfaceCreateInfoMVK;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkCreateIOSSurfaceMVK)(VkInstance instance, const VkIOSSurfaceCreateInfoMVK* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkSurfaceKHR* pSurface);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateIOSSurfaceMVK(
//VkInstance                                  instance,
//const VkIOSSurfaceCreateInfoMVK*            pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkSurfaceKHR*                               pSurface);
//#endif
//#endif /* VK_USE_PLATFORM_IOS_MVK */
//
//#ifdef VK_USE_PLATFORM_MACOS_MVK
//#define VK_MVK_macos_surface 1
//#define VK_MVK_MACOS_SURFACE_SPEC_VERSION 2
//#define VK_MVK_MACOS_SURFACE_EXTENSION_NAME "VK_MVK_macos_surface"
//
//typedef VkFlags VkMacOSSurfaceCreateFlagsMVK;
//
//typedef struct VkMacOSSurfaceCreateInfoMVK {
//    VkStructureType                 sType;
//    const void*                     pNext;
//    VkMacOSSurfaceCreateFlagsMVK    flags;
//    const void*                     pView;
//} VkMacOSSurfaceCreateInfoMVK;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkCreateMacOSSurfaceMVK)(VkInstance instance, const VkMacOSSurfaceCreateInfoMVK* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkSurfaceKHR* pSurface);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateMacOSSurfaceMVK(
//VkInstance                                  instance,
//const VkMacOSSurfaceCreateInfoMVK*          pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkSurfaceKHR*                               pSurface);
//#endif
//#endif /* VK_USE_PLATFORM_MACOS_MVK */
//
//#define VK_EXT_external_memory_dma_buf 1
//#define VK_EXT_EXTERNAL_MEMORY_DMA_BUF_SPEC_VERSION 1
//#define VK_EXT_EXTERNAL_MEMORY_DMA_BUF_EXTENSION_NAME "VK_EXT_external_memory_dma_buf"
//
//
//#define VK_EXT_queue_family_foreign 1
//#define VK_EXT_QUEUE_FAMILY_FOREIGN_SPEC_VERSION 1
//#define VK_EXT_QUEUE_FAMILY_FOREIGN_EXTENSION_NAME "VK_EXT_queue_family_foreign"
//#define VK_QUEUE_FAMILY_FOREIGN_EXT       (~0U-2)
//
//
//#define VK_EXT_sampler_filter_minmax 1
//#define VK_EXT_SAMPLER_FILTER_MINMAX_SPEC_VERSION 1
//#define VK_EXT_SAMPLER_FILTER_MINMAX_EXTENSION_NAME "VK_EXT_sampler_filter_minmax"
//
//
//typedef enum VkSamplerReductionModeEXT {
//    VK_SAMPLER_REDUCTION_MODE_WEIGHTED_AVERAGE_EXT = 0,
//    VK_SAMPLER_REDUCTION_MODE_MIN_EXT = 1,
//    VK_SAMPLER_REDUCTION_MODE_MAX_EXT = 2,
//    VK_SAMPLER_REDUCTION_MODE_BEGIN_RANGE_EXT = VK_SAMPLER_REDUCTION_MODE_WEIGHTED_AVERAGE_EXT,
//    VK_SAMPLER_REDUCTION_MODE_END_RANGE_EXT = VK_SAMPLER_REDUCTION_MODE_MAX_EXT,
//    VK_SAMPLER_REDUCTION_MODE_RANGE_SIZE_EXT = (VK_SAMPLER_REDUCTION_MODE_MAX_EXT - VK_SAMPLER_REDUCTION_MODE_WEIGHTED_AVERAGE_EXT + 1),
//    VK_SAMPLER_REDUCTION_MODE_MAX_ENUM_EXT = 0x7FFFFFFF
//} VkSamplerReductionModeEXT;
//
//typedef struct VkSamplerReductionModeCreateInfoEXT {
//    VkStructureType              sType;
//    const void*                  pNext;
//    VkSamplerReductionModeEXT    reductionMode;
//} VkSamplerReductionModeCreateInfoEXT;
//
//typedef struct VkPhysicalDeviceSamplerFilterMinmaxPropertiesEXT {
//    VkStructureType    sType;
//    void*              pNext;
//    VkBool32           filterMinmaxSingleComponentFormats;
//    VkBool32           filterMinmaxImageComponentMapping;
//} VkPhysicalDeviceSamplerFilterMinmaxPropertiesEXT;
//
//
//
//#define VK_AMD_gpu_shader_int16 1
//#define VK_AMD_GPU_SHADER_INT16_SPEC_VERSION 1
//#define VK_AMD_GPU_SHADER_INT16_EXTENSION_NAME "VK_AMD_gpu_shader_int16"
//
//
//#define VK_AMD_mixed_attachment_samples 1
//#define VK_AMD_MIXED_ATTACHMENT_SAMPLES_SPEC_VERSION 1
//#define VK_AMD_MIXED_ATTACHMENT_SAMPLES_EXTENSION_NAME "VK_AMD_mixed_attachment_samples"
//
//
//#define VK_AMD_shader_fragment_mask 1
//#define VK_AMD_SHADER_FRAGMENT_MASK_SPEC_VERSION 1
//#define VK_AMD_SHADER_FRAGMENT_MASK_EXTENSION_NAME "VK_AMD_shader_fragment_mask"
//
//
//#define VK_EXT_shader_stencil_export 1
//#define VK_EXT_SHADER_STENCIL_EXPORT_SPEC_VERSION 1
//#define VK_EXT_SHADER_STENCIL_EXPORT_EXTENSION_NAME "VK_EXT_shader_stencil_export"
//
//
//#define VK_EXT_sample_locations 1
//#define VK_EXT_SAMPLE_LOCATIONS_SPEC_VERSION 1
//#define VK_EXT_SAMPLE_LOCATIONS_EXTENSION_NAME "VK_EXT_sample_locations"
//
//typedef struct VkSampleLocationEXT {
//    float    x;
//    float    y;
//} VkSampleLocationEXT;
//
//typedef struct VkSampleLocationsInfoEXT {
//    VkStructureType               sType;
//    const void*                   pNext;
//    VkSampleCountFlagBits         sampleLocationsPerPixel;
//    VkExtent2D                    sampleLocationGridSize;
//    uint32_t                      sampleLocationsCount;
//    const VkSampleLocationEXT*    pSampleLocations;
//} VkSampleLocationsInfoEXT;
//
//typedef struct VkAttachmentSampleLocationsEXT {
//    uint32_t                    attachmentIndex;
//    VkSampleLocationsInfoEXT    sampleLocationsInfo;
//} VkAttachmentSampleLocationsEXT;
//
//typedef struct VkSubpassSampleLocationsEXT {
//    uint32_t                    subpassIndex;
//    VkSampleLocationsInfoEXT    sampleLocationsInfo;
//} VkSubpassSampleLocationsEXT;
//
//typedef struct VkRenderPassSampleLocationsBeginInfoEXT {
//    VkStructureType                          sType;
//    const void*                              pNext;
//    uint32_t                                 attachmentInitialSampleLocationsCount;
//    const VkAttachmentSampleLocationsEXT*    pAttachmentInitialSampleLocations;
//    uint32_t                                 postSubpassSampleLocationsCount;
//    const VkSubpassSampleLocationsEXT*       pPostSubpassSampleLocations;
//} VkRenderPassSampleLocationsBeginInfoEXT;
//
//typedef struct VkPipelineSampleLocationsStateCreateInfoEXT {
//    VkStructureType             sType;
//    const void*                 pNext;
//    VkBool32                    sampleLocationsEnable;
//    VkSampleLocationsInfoEXT    sampleLocationsInfo;
//} VkPipelineSampleLocationsStateCreateInfoEXT;
//
//typedef struct VkPhysicalDeviceSampleLocationsPropertiesEXT {
//    VkStructureType       sType;
//    void*                 pNext;
//    VkSampleCountFlags    sampleLocationSampleCounts;
//    VkExtent2D            maxSampleLocationGridSize;
//    float                 sampleLocationCoordinateRange[2];
//    uint32_t              sampleLocationSubPixelBits;
//    VkBool32              variableSampleLocations;
//} VkPhysicalDeviceSampleLocationsPropertiesEXT;
//
//typedef struct VkMultisamplePropertiesEXT {
//    VkStructureType    sType;
//    void*              pNext;
//    VkExtent2D         maxSampleLocationGridSize;
//} VkMultisamplePropertiesEXT;
//
//
//typedef void (VKAPI_PTR *PFN_vkCmdSetSampleLocationsEXT)(VkCommandBuffer commandBuffer, const VkSampleLocationsInfoEXT* pSampleLocationsInfo);
//typedef void (VKAPI_PTR *PFN_vkGetPhysicalDeviceMultisamplePropertiesEXT)(VkPhysicalDevice physicalDevice, VkSampleCountFlagBits samples, VkMultisamplePropertiesEXT* pMultisampleProperties);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR void VKAPI_CALL vkCmdSetSampleLocationsEXT(
//VkCommandBuffer                             commandBuffer,
//const VkSampleLocationsInfoEXT*             pSampleLocationsInfo);
//
//VKAPI_ATTR void VKAPI_CALL vkGetPhysicalDeviceMultisamplePropertiesEXT(
//VkPhysicalDevice                            physicalDevice,
//VkSampleCountFlagBits                       samples,
//VkMultisamplePropertiesEXT*                 pMultisampleProperties);
//#endif
//
//#define VK_EXT_blend_operation_advanced 1
//#define VK_EXT_BLEND_OPERATION_ADVANCED_SPEC_VERSION 2
//#define VK_EXT_BLEND_OPERATION_ADVANCED_EXTENSION_NAME "VK_EXT_blend_operation_advanced"
//
//
//typedef enum VkBlendOverlapEXT {
//    VK_BLEND_OVERLAP_UNCORRELATED_EXT = 0,
//    VK_BLEND_OVERLAP_DISJOINT_EXT = 1,
//    VK_BLEND_OVERLAP_CONJOINT_EXT = 2,
//    VK_BLEND_OVERLAP_BEGIN_RANGE_EXT = VK_BLEND_OVERLAP_UNCORRELATED_EXT,
//    VK_BLEND_OVERLAP_END_RANGE_EXT = VK_BLEND_OVERLAP_CONJOINT_EXT,
//    VK_BLEND_OVERLAP_RANGE_SIZE_EXT = (VK_BLEND_OVERLAP_CONJOINT_EXT - VK_BLEND_OVERLAP_UNCORRELATED_EXT + 1),
//    VK_BLEND_OVERLAP_MAX_ENUM_EXT = 0x7FFFFFFF
//} VkBlendOverlapEXT;
//
//typedef struct VkPhysicalDeviceBlendOperationAdvancedFeaturesEXT {
//    VkStructureType    sType;
//    void*              pNext;
//    VkBool32           advancedBlendCoherentOperations;
//} VkPhysicalDeviceBlendOperationAdvancedFeaturesEXT;
//
//typedef struct VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT {
//    VkStructureType    sType;
//    void*              pNext;
//    uint32_t           advancedBlendMaxColorAttachments;
//    VkBool32           advancedBlendIndependentBlend;
//    VkBool32           advancedBlendNonPremultipliedSrcColor;
//    VkBool32           advancedBlendNonPremultipliedDstColor;
//    VkBool32           advancedBlendCorrelatedOverlap;
//    VkBool32           advancedBlendAllOperations;
//} VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT;
//
//typedef struct VkPipelineColorBlendAdvancedStateCreateInfoEXT {
//    VkStructureType      sType;
//    const void*          pNext;
//    VkBool32             srcPremultiplied;
//    VkBool32             dstPremultiplied;
//    VkBlendOverlapEXT    blendOverlap;
//} VkPipelineColorBlendAdvancedStateCreateInfoEXT;
//
//
//
//#define VK_NV_fragment_coverage_to_color 1
//#define VK_NV_FRAGMENT_COVERAGE_TO_COLOR_SPEC_VERSION 1
//#define VK_NV_FRAGMENT_COVERAGE_TO_COLOR_EXTENSION_NAME "VK_NV_fragment_coverage_to_color"
//
//typedef VkFlags VkPipelineCoverageToColorStateCreateFlagsNV;
//
//typedef struct VkPipelineCoverageToColorStateCreateInfoNV {
//    VkStructureType                                sType;
//    const void*                                    pNext;
//    VkPipelineCoverageToColorStateCreateFlagsNV    flags;
//    VkBool32                                       coverageToColorEnable;
//    uint32_t                                       coverageToColorLocation;
//} VkPipelineCoverageToColorStateCreateInfoNV;
//
//
//
//#define VK_NV_framebuffer_mixed_samples 1
//#define VK_NV_FRAMEBUFFER_MIXED_SAMPLES_SPEC_VERSION 1
//#define VK_NV_FRAMEBUFFER_MIXED_SAMPLES_EXTENSION_NAME "VK_NV_framebuffer_mixed_samples"
//
//
//typedef enum VkCoverageModulationModeNV {
//    VK_COVERAGE_MODULATION_MODE_NONE_NV = 0,
//    VK_COVERAGE_MODULATION_MODE_RGB_NV = 1,
//    VK_COVERAGE_MODULATION_MODE_ALPHA_NV = 2,
//    VK_COVERAGE_MODULATION_MODE_RGBA_NV = 3,
//    VK_COVERAGE_MODULATION_MODE_BEGIN_RANGE_NV = VK_COVERAGE_MODULATION_MODE_NONE_NV,
//    VK_COVERAGE_MODULATION_MODE_END_RANGE_NV = VK_COVERAGE_MODULATION_MODE_RGBA_NV,
//    VK_COVERAGE_MODULATION_MODE_RANGE_SIZE_NV = (VK_COVERAGE_MODULATION_MODE_RGBA_NV - VK_COVERAGE_MODULATION_MODE_NONE_NV + 1),
//    VK_COVERAGE_MODULATION_MODE_MAX_ENUM_NV = 0x7FFFFFFF
//} VkCoverageModulationModeNV;
//
//typedef VkFlags VkPipelineCoverageModulationStateCreateFlagsNV;
//
//typedef struct VkPipelineCoverageModulationStateCreateInfoNV {
//    VkStructureType                                   sType;
//    const void*                                       pNext;
//    VkPipelineCoverageModulationStateCreateFlagsNV    flags;
//    VkCoverageModulationModeNV                        coverageModulationMode;
//    VkBool32                                          coverageModulationTableEnable;
//    uint32_t                                          coverageModulationTableCount;
//    const float*                                      pCoverageModulationTable;
//} VkPipelineCoverageModulationStateCreateInfoNV;
//
//
//
//#define VK_NV_fill_rectangle 1
//#define VK_NV_FILL_RECTANGLE_SPEC_VERSION 1
//#define VK_NV_FILL_RECTANGLE_EXTENSION_NAME "VK_NV_fill_rectangle"
//
//
//#define VK_EXT_post_depth_coverage 1
//#define VK_EXT_POST_DEPTH_COVERAGE_SPEC_VERSION 1
//#define VK_EXT_POST_DEPTH_COVERAGE_EXTENSION_NAME "VK_EXT_post_depth_coverage"
//
//
//#define VK_EXT_validation_cache 1
//VK_DEFINE_NON_DISPATCHABLE_HANDLE(VkValidationCacheEXT)
//
//#define VK_EXT_VALIDATION_CACHE_SPEC_VERSION 1
//#define VK_EXT_VALIDATION_CACHE_EXTENSION_NAME "VK_EXT_validation_cache"
//
//
//typedef enum VkValidationCacheHeaderVersionEXT {
//    VK_VALIDATION_CACHE_HEADER_VERSION_ONE_EXT = 1,
//    VK_VALIDATION_CACHE_HEADER_VERSION_BEGIN_RANGE_EXT = VK_VALIDATION_CACHE_HEADER_VERSION_ONE_EXT,
//    VK_VALIDATION_CACHE_HEADER_VERSION_END_RANGE_EXT = VK_VALIDATION_CACHE_HEADER_VERSION_ONE_EXT,
//    VK_VALIDATION_CACHE_HEADER_VERSION_RANGE_SIZE_EXT = (VK_VALIDATION_CACHE_HEADER_VERSION_ONE_EXT - VK_VALIDATION_CACHE_HEADER_VERSION_ONE_EXT + 1),
//    VK_VALIDATION_CACHE_HEADER_VERSION_MAX_ENUM_EXT = 0x7FFFFFFF
//} VkValidationCacheHeaderVersionEXT;
//
//typedef VkFlags VkValidationCacheCreateFlagsEXT;
//
//typedef struct VkValidationCacheCreateInfoEXT {
//    VkStructureType                    sType;
//    const void*                        pNext;
//    VkValidationCacheCreateFlagsEXT    flags;
//    size_t                             initialDataSize;
//    const void*                        pInitialData;
//} VkValidationCacheCreateInfoEXT;
//
//typedef struct VkShaderModuleValidationCacheCreateInfoEXT {
//    VkStructureType         sType;
//    const void*             pNext;
//    VkValidationCacheEXT    validationCache;
//} VkShaderModuleValidationCacheCreateInfoEXT;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkCreateValidationCacheEXT)(VkDevice device, const VkValidationCacheCreateInfoEXT* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkValidationCacheEXT* pValidationCache);
//typedef void (VKAPI_PTR *PFN_vkDestroyValidationCacheEXT)(VkDevice device, VkValidationCacheEXT validationCache, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkMergeValidationCachesEXT)(VkDevice device, VkValidationCacheEXT dstCache, uint32_t srcCacheCount, const VkValidationCacheEXT* pSrcCaches);
//typedef VkResult (VKAPI_PTR *PFN_vkGetValidationCacheDataEXT)(VkDevice device, VkValidationCacheEXT validationCache, size_t* pDataSize, void* pData);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateValidationCacheEXT(
//VkDevice                                    device,
//const VkValidationCacheCreateInfoEXT*       pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkValidationCacheEXT*                       pValidationCache);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyValidationCacheEXT(
//VkDevice                                    device,
//VkValidationCacheEXT                        validationCache,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkMergeValidationCachesEXT(
//VkDevice                                    device,
//VkValidationCacheEXT                        dstCache,
//uint32_t                                    srcCacheCount,
//const VkValidationCacheEXT*                 pSrcCaches);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetValidationCacheDataEXT(
//VkDevice                                    device,
//VkValidationCacheEXT                        validationCache,
//size_t*                                     pDataSize,
//void*                                       pData);
//#endif
//
//#define VK_EXT_shader_viewport_index_layer 1
//#define VK_EXT_SHADER_VIEWPORT_INDEX_LAYER_SPEC_VERSION 1
//#define VK_EXT_SHADER_VIEWPORT_INDEX_LAYER_EXTENSION_NAME "VK_EXT_shader_viewport_index_layer"
//
//
//#define VK_EXT_global_priority 1
//#define VK_EXT_GLOBAL_PRIORITY_SPEC_VERSION 2
//#define VK_EXT_GLOBAL_PRIORITY_EXTENSION_NAME "VK_EXT_global_priority"
//
//
//typedef enum VkQueueGlobalPriorityEXT {
//    VK_QUEUE_GLOBAL_PRIORITY_LOW_EXT = 128,
//    VK_QUEUE_GLOBAL_PRIORITY_MEDIUM_EXT = 256,
//    VK_QUEUE_GLOBAL_PRIORITY_HIGH_EXT = 512,
//    VK_QUEUE_GLOBAL_PRIORITY_REALTIME_EXT = 1024,
//    VK_QUEUE_GLOBAL_PRIORITY_BEGIN_RANGE_EXT = VK_QUEUE_GLOBAL_PRIORITY_LOW_EXT,
//    VK_QUEUE_GLOBAL_PRIORITY_END_RANGE_EXT = VK_QUEUE_GLOBAL_PRIORITY_REALTIME_EXT,
//    VK_QUEUE_GLOBAL_PRIORITY_RANGE_SIZE_EXT = (VK_QUEUE_GLOBAL_PRIORITY_REALTIME_EXT - VK_QUEUE_GLOBAL_PRIORITY_LOW_EXT + 1),
//    VK_QUEUE_GLOBAL_PRIORITY_MAX_ENUM_EXT = 0x7FFFFFFF
//} VkQueueGlobalPriorityEXT;
//
//typedef struct VkDeviceQueueGlobalPriorityCreateInfoEXT {
//    VkStructureType             sType;
//    const void*                 pNext;
//    VkQueueGlobalPriorityEXT    globalPriority;
//} VkDeviceQueueGlobalPriorityCreateInfoEXT;
//
//
//
//#define VK_EXT_external_memory_host 1
//#define VK_EXT_EXTERNAL_MEMORY_HOST_SPEC_VERSION 1
//#define VK_EXT_EXTERNAL_MEMORY_HOST_EXTENSION_NAME "VK_EXT_external_memory_host"
//
//typedef struct VkImportMemoryHostPointerInfoEXT {
//    VkStructureType                          sType;
//    const void*                              pNext;
//    VkExternalMemoryHandleTypeFlagBitsKHR    handleType;
//    void*                                    pHostPointer;
//} VkImportMemoryHostPointerInfoEXT;
//
//typedef struct VkMemoryHostPointerPropertiesEXT {
//    VkStructureType    sType;
//    void*              pNext;
//    uint32_t           memoryTypeBits;
//} VkMemoryHostPointerPropertiesEXT;
//
//typedef struct VkPhysicalDeviceExternalMemoryHostPropertiesEXT {
//    VkStructureType    sType;
//    void*              pNext;
//    VkDeviceSize       minImportedHostPointerAlignment;
//} VkPhysicalDeviceExternalMemoryHostPropertiesEXT;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkGetMemoryHostPointerPropertiesEXT)(VkDevice device, VkExternalMemoryHandleTypeFlagBitsKHR handleType, const void* pHostPointer, VkMemoryHostPointerPropertiesEXT* pMemoryHostPointerProperties);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkGetMemoryHostPointerPropertiesEXT(
//VkDevice                                    device,
//VkExternalMemoryHandleTypeFlagBitsKHR       handleType,
//const void*                                 pHostPointer,
//VkMemoryHostPointerPropertiesEXT*           pMemoryHostPointerProperties);
//#endif
//
//#ifdef __cplusplus
//}
