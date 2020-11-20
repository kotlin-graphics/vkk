package vkk.extensions

import vkk.VkFlags

inline class VkDebugReportObjectTypeEXT(val i: Int) {
    companion object {
        val UNKNOWN = VkDebugReportObjectTypeEXT(0)
        val INSTANCE = VkDebugReportObjectTypeEXT(1)
        val PHYSICAL_DEVICE = VkDebugReportObjectTypeEXT(2)
        val DEVICE = VkDebugReportObjectTypeEXT(3)
        val QUEUE = VkDebugReportObjectTypeEXT(4)
        val SEMAPHORE = VkDebugReportObjectTypeEXT(5)
        val COMMAND_BUFFER = VkDebugReportObjectTypeEXT(6)
        val FENCE = VkDebugReportObjectTypeEXT(7)
        val DEVICE_MEMORY = VkDebugReportObjectTypeEXT(8)
        val BUFFER = VkDebugReportObjectTypeEXT(9)
        val IMAGE = VkDebugReportObjectTypeEXT(10)
        val EVENT = VkDebugReportObjectTypeEXT(11)
        val QUERY_POOL = VkDebugReportObjectTypeEXT(12)
        val BUFFER_VIEW = VkDebugReportObjectTypeEXT(13)
        val IMAGE_VIEW = VkDebugReportObjectTypeEXT(14)
        val SHADER_MODULE = VkDebugReportObjectTypeEXT(15)
        val PIPELINE_CACHE = VkDebugReportObjectTypeEXT(16)
        val PIPELINE_LAYOUT = VkDebugReportObjectTypeEXT(17)
        val RENDER_PASS = VkDebugReportObjectTypeEXT(18)
        val PIPELINE = VkDebugReportObjectTypeEXT(19)
        val DESCRIPTOR_SET_LAYOUT = VkDebugReportObjectTypeEXT(20)
        val SAMPLER = VkDebugReportObjectTypeEXT(21)
        val DESCRIPTOR_POOL = VkDebugReportObjectTypeEXT(22)
        val DESCRIPTOR_SET = VkDebugReportObjectTypeEXT(23)
        val FRAMEBUFFER = VkDebugReportObjectTypeEXT(24)
        val COMMAND_POOL = VkDebugReportObjectTypeEXT(25)
        val SURFACE_KHR = VkDebugReportObjectTypeEXT(26)
        val SWAPCHAIN_KHR = VkDebugReportObjectTypeEXT(27)
        val DEBUG_REPORT_CALLBACK_EXT = VkDebugReportObjectTypeEXT(28)
        val DISPLAY_KHR = VkDebugReportObjectTypeEXT(29)
        val DISPLAY_MODE_KHR = VkDebugReportObjectTypeEXT(30)
        val OBJECT_TABLE_NVX = VkDebugReportObjectTypeEXT(31)
        val INDIRECT_COMMANDS_LAYOUT_NVX = VkDebugReportObjectTypeEXT(32)
        val VALIDATION_CACHE_EXT = VkDebugReportObjectTypeEXT(33)
        val SAMPLER_YCBCR_CONVERSION = VkDebugReportObjectTypeEXT(1000156000)
        val DESCRIPTOR_UPDATE_TEMPLATE = VkDebugReportObjectTypeEXT(1000085000)
        val ACCELERATION_STRUCTURE_NV = VkDebugReportObjectTypeEXT(1000156000)
        val DEBUG_REPORT = VkDebugReportObjectTypeEXT.DEBUG_REPORT_CALLBACK_EXT
        val VALIDATION_CACHE = VkDebugReportObjectTypeEXT.VALIDATION_CACHE_EXT
        val DEBUG_REPORT_OBJECT_TYPE_DESCRIPTOR_UPDATE_TEMPLATE_KHR = VkDebugReportObjectTypeEXT.DESCRIPTOR_UPDATE_TEMPLATE
        val SAMPLER_YCBCR_CONVERSION_KHR = VkDebugReportObjectTypeEXT.SAMPLER_YCBCR_CONVERSION
    }
}


inline class VkDebugReport(val i: VkDebugReportFlagsEXT) {
    companion object {
        val INFORMATION_BIT_EXT = VkDebugReport(0x00000001)
        val WARNING_BIT_EXT = VkDebugReport(0x00000002)
        val PERFORMANCE_WARNING_BIT_EXT = VkDebugReport(0x00000004)
        val ERROR_BIT_EXT = VkDebugReport(0x00000008)
        val DEBUG_BIT_EXT = VkDebugReport(0x00000010)
    }

    infix fun or(other: VkDebugReport) = i or other.i
}

infix fun Int.has(f: VkDebugReport) = and(f.i) != 0
infix fun Int.or(f: VkDebugReport): VkDebugReportFlagsEXT = or(f.i)
infix fun Int.and(f: VkDebugReport): VkDebugReportFlagsEXT = and(f.i)

typealias VkDebugReportFlagsEXT = VkFlags

//typedef VkBool32 (VKAPI_PTR *PFN_vkDebugReportCallbackEXT)(
//VkDebugReportFlagsEXT                       flags,
//VkDebugReportObjectTypeEXT                  objectType,
//uint64_t                                    object,
//size_t                                      location,
//int32_t                                     messageCode,
//const char*                                 pLayerPrefix,
//const char*                                 pMessage,
//void*                                       pUserData);
//
//typedef struct VkDebugReportCallbackCreateInfoEXT {
//    VkStructureType                 sType;
//    const void*                     pNext;
//    VkDebugReportFlagsEXT           flags;
//    PFN_vkDebugReportCallbackEXT    pfnCallback;
//    void*                           pUserData;
//} VkDebugReportCallbackCreateInfoEXT;
//
//
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