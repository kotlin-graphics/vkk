package classes

import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.vulkan.EXTDebugReport
import org.lwjgl.vulkan.VkDebugReportCallbackCreateInfoEXT
import org.lwjgl.vulkan.VkDebugReportCallbackCreateInfoEXT.*
import org.lwjgl.vulkan.VkDebugReportCallbackEXT
import org.lwjgl.vulkan.VkDebugReportCallbackEXTI
import vkk.VkDebugReportFlagsEXT
import vkk.VkStructureType

/**
 * Structure specifying parameters of a newly created debug report callback.
 *
 * <h5>Description</h5>
 *
 *
 * For each `VkDebugReportCallbackEXT` that is created the [VkDebugReportCallbackCreateInfoEXT]`::flags` determine when that [VkDebugReportCallbackCreateInfoEXT]`::pfnCallback` is called. When an event happens, the implementation will do a bitwise AND of the event's `VkDebugReportFlagBitsEXT` flags to each `VkDebugReportCallbackEXT` object's flags. For each non-zero result the corresponding callback will be called. The callback will come directly from the component that detected the event, unless some other layer intercepts the calls for its own purposes (filter them in a different way, log to a system error log, etc.).
 *
 *
 * An application **may** receive multiple callbacks if multiple `VkDebugReportCallbackEXT` objects were created. A callback will always be executed in the same thread as the originating Vulkan call.
 *
 *
 * A callback may be called from multiple threads simultaneously (if the application is making Vulkan calls from multiple threads).
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 *
 *  * `sType` **must** be [STRUCTURE_TYPE_DEBUG_REPORT_CALLBACK_CREATE_INFO_EXT][EXTDebugReport.VK_STRUCTURE_TYPE_DEBUG_REPORT_CALLBACK_CREATE_INFO_EXT]
 *  * `flags` **must** be a valid combination of `VkDebugReportFlagBitsEXT` values
 *  * `pfnCallback` **must** be a valid [VkDebugReportCallbackEXT] value
 *
 *
 * <h5>See Also</h5>
 *
 *
 * [VkDebugReportCallbackEXT], [CreateDebugReportCallbackEXT][EXTDebugReport.vkCreateDebugReportCallbackEXT]
 *
 * <h3>Member documentation</h3>
 *
 *
 *  * `sType`  the type of this structure.
 *  * `pNext`  `NULL` or a pointer to an extension-specific structure.
 *  * `flags`  a bitmask of `VkDebugReportFlagBitsEXT` specifying which event(s) will cause this callback to be called.
 *  * `pfnCallback`  the application callback function to call.
 *  * `pUserData`  user data to be passed to the callback.
 *
 *
 * <h3>Layout</h3>
 *
 * <pre>`
 * struct VkDebugReportCallbackCreateInfoEXT {
 * VkStructureType sType;
 * void const * pNext;
 * VkDebugReportFlagsEXT flags;
 * [PFN_vkDebugReportCallbackEXT][VkDebugReportCallbackEXTI] pfnCallback;
 * void * pUserData;
 * }`</pre>
 */
class DebugReportCallbackCreateInfo(
        var flags: VkDebugReportFlagsEXT = 0,
        var userData: Ptr = NULL,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.DEBUG_REPORT_CALLBACK_CREATE_INFO_EXT

    fun write(stack: MemoryStack): Adr =
            stack.ncalloc(ALIGNOF, 1, SIZEOF).also { write(it) }

    fun write(adr: Adr) {
        nsType(adr, type.i)
        npNext(adr, next)
        nflags(adr, flags)
        npfnCallback(adr, DebugReportCallback.native)
        npUserData(adr, userData)
    }
}