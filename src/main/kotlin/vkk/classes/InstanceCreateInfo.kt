package classes

import kool.Ptr
import kool.adr
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.vulkan.*
import org.lwjgl.vulkan.VkInstanceCreateInfo.*
import util.PointerBuffer
import vkk.VkStructureType

/**
 * Structure specifying parameters of a newly created instance.
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 *
 *  * `sType` **must** be [STRUCTURE_TYPE_INSTANCE_CREATE_INFO][VK10.VK_STRUCTURE_TYPE_INSTANCE_CREATE_INFO]
 *  * Each `pNext` member of any structure (including this one) in the `pNext` chain **must** be either `NULL` or a pointer to a valid instance of [VkDebugReportCallbackCreateInfoEXT], [VkDebugUtilsMessengerCreateInfoEXT], [VkValidationFeaturesEXT], or [VkValidationFlagsEXT]
 *  * Each `sType` member in the `pNext` chain **must** be unique
 *  * `flags` **must** be 0
 *  * If `pApplicationInfo` is not `NULL`, `pApplicationInfo` **must** be a valid pointer to a valid [VkApplicationInfo] structure
 *  * If `enabledLayerCount` is not 0, `ppEnabledLayerNames` **must** be a valid pointer to an array of `enabledLayerCount` null-terminated UTF-8 strings
 *  * If `enabledExtensionCount` is not 0, `ppEnabledExtensionNames` **must** be a valid pointer to an array of `enabledExtensionCount` null-terminated UTF-8 strings
 *
 *
 * <h5>See Also</h5>
 *
 *
 * [VkApplicationInfo], [CreateInstance][VK10.vkCreateInstance]
 *
 * <h3>Member documentation</h3>
 *
 *
 *  * `sType`  the type of this structure.
 *  * `pNext`  `NULL` or a pointer to an extension-specific structure.
 *  * `flags`  reserved for future use.
 *  * `pApplicationInfo`  `NULL` or a pointer to an instance of [VkApplicationInfo]. If not `NULL`, this information helps implementations recognize behavior inherent to classes of applications. [VkApplicationInfo] is defined in detail below.
 *  * `enabledLayerCount`  the number of global layers to enable.
 *  * `ppEnabledLayerNames`  a pointer to an array of `enabledLayerCount` null-terminated UTF-8 strings containing the names of layers to enable for the created instance. See the [Layers](https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#extendingvulkan-layers) section for further details.
 *  * `enabledExtensionCount`  the number of global extensions to enable.
 *  * `ppEnabledExtensionNames`  a pointer to an array of `enabledExtensionCount` null-terminated UTF-8 strings containing the names of extensions to enable.
 *
 *
 * <h3>Layout</h3>
 *
 * <pre>`
 * struct VkInstanceCreateInfo {
 * VkStructureType sType;
 * void const * pNext;
 * VkInstanceCreateFlags flags;
 * [VkApplicationInfo] const * pApplicationInfo;
 * uint32_t enabledLayerCount;
 * char const * const * ppEnabledLayerNames;
 * uint32_t enabledExtensionCount;
 * char const * const * ppEnabledExtensionNames;
 * }`</pre>
 */
class InstanceCreateInfo(
    var applicationInfo: ApplicationInfo? = null,
    var enabledLayerNames: List<String>? = null,
    var enabledExtensionNames: List<String>? = null,
    var next: Ptr = NULL
) {

    val type get() = VkStructureType.INSTANCE_CREATE_INFO


    /** Initializes this struct with the specified values.  */
    operator fun invoke(src: InstanceCreateInfo): InstanceCreateInfo {
        next = src.next
        applicationInfo = src.applicationInfo
        enabledLayerNames = src.enabledLayerNames
        enabledExtensionNames = src.enabledExtensionNames
        return this
    }

    val MemoryStack.native: Ptr
        get() = ncalloc(ALIGNOF, 1, SIZEOF).also {
            nsType(it, type.i)
            npNext(it, next)
            memPutAddress(it + PAPPLICATIONINFO, applicationInfo?.run { native } ?: NULL)
            nppEnabledLayerNames(it, PointerBuffer(enabledLayerNames))
            nppEnabledExtensionNames(it, PointerBuffer(enabledExtensionNames))
        }
}