package classes

import glm_.i
import kool.Ptr
import org.lwjgl.system.Callback
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.system.MemoryUtil.memUTF8
import org.lwjgl.vulkan.*
import vkk.VkDebugReportFlagsEXT
import vkk.VkDebugReportObjectTypeEXT

/**
 * Application-defined debug report callback function.
 *
 * <h5>C Specification</h5>
 *
 *
 * The prototype for the [VkDebugReportCallbackCreateInfoEXT]`::pfnCallback` function implemented by the application is:
 *
 * <pre>`
 * typedef VkBool32 (VKAPI_PTR *PFN_vkDebugReportCallbackEXT)(
 * VkDebugReportFlagsEXT                       flags,
 * VkDebugReportObjectTypeEXT                  objectType,
 * uint64_t                                    object,
 * size_t                                      location,
 * int32_t                                     messageCode,
 * const char*                                 pLayerPrefix,
 * const char*                                 pMessage,
 * void*                                       pUserData);`</pre>
 *
 * <h5>Description</h5>
 *
 *
 * The callback **must** not call `vkDestroyDebugReportCallbackEXT`.
 *
 *
 * The callback returns a `VkBool32`, which is interpreted in a layer-specified manner. The application **should** always return [FALSE][VK10.VK_FALSE]. The [TRUE][VK10.VK_TRUE] value is reserved for use in layer development.
 *
 *
 * `object` **must** be a Vulkan object or [NULL_HANDLE][VK10.VK_NULL_HANDLE]. If `objectType` is not [DEBUG_REPORT_OBJECT_TYPE_UNKNOWN_EXT][EXTDebugReport.VK_DEBUG_REPORT_OBJECT_TYPE_UNKNOWN_EXT] and `object` is not [NULL_HANDLE][VK10.VK_NULL_HANDLE], `object` **must** be a Vulkan object of the corresponding type associated with `objectType` as defined in [`VkDebugReportObjectTypeEXT` and Vulkan Handle Relationship](https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#debug-report-object-types).
 *
 * <h5>See Also</h5>
 *
 *
 * [VkDebugReportCallbackCreateInfoEXT]
 */
object DebugReportCallback {

    val native = VkDebugReportCallbackEXT.create { flags, objectType, `object`, location, messageCode, layerPrefix, message, userData ->
        callback(flags, VkDebugReportObjectTypeEXT(objectType), `object`, location, messageCode, memUTF8(layerPrefix), memUTF8(message), userData)
        VK10.VK_FALSE
    }

    lateinit var callback: (flags: VkDebugReportFlagsEXT, objectType: VkDebugReportObjectTypeEXT, `object`: Long, location: Long, messageCode: Int,
                            layerPrefix: String, message: String, userData: Ptr) -> Unit
}