package vkk.extensions

import glm_.vec4.Vec4
import kool.Adr
import kool.adr
import kool.utf8Adr
import org.lwjgl.system.JNI.callPPI
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.memPutAddress
import org.lwjgl.system.Pointer
import org.lwjgl.vulkan.VkDebugUtilsObjectNameInfoEXT
import vkk.*
import vkk.identifiers.CapabilitiesDevice
import java.nio.ByteBuffer

typealias VkDebugUtilsMessengerCallbackDataFlagsEXT = VkFlags
typealias VkDebugUtilsMessengerCreateFlagsEXT = VkFlags

inline class VkDebugUtilsMessageSeverityEXT(val i: Int) {
    companion object {
        val VERBOSE = VkDebugUtilsMessageSeverityEXT(0x00000001)
        val INFO = VkDebugUtilsMessageSeverityEXT(0x00000010)
        val WARNING = VkDebugUtilsMessageSeverityEXT(0x00000100)
        val ERROR = VkDebugUtilsMessageSeverityEXT(0x00001000)
    }
}
typealias VkDebugUtilsMessageSeverityFlagsEXT = VkFlags

inline class VkDebugUtilsMessageTypeEXT(val i: Int) {
    companion object {
        val GENERAL = VkDebugUtilsMessageTypeEXT(0x00000001)
        val VALIDATION = VkDebugUtilsMessageTypeEXT(0x00000002)
        val PERFORMANCE = VkDebugUtilsMessageTypeEXT(0x00000004)
    }
}
typealias VkDebugUtilsMessageTypeFlagsEXT = VkFlags

/**
 * Specify parameters of a name to give to an object.
 *
 * <h5>Description</h5>
 *
 * <p>Applications <b>may</b> change the name associated with an object simply by calling {@code vkSetDebugUtilsObjectNameEXT} again with a new string. If {@code pObjectName} is an empty string, then any previously set name is removed.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>If {@code objectType} is {@link VK10#VK_OBJECT_TYPE_UNKNOWN OBJECT_TYPE_UNKNOWN}, {@code objectHandle} <b>must</b> not be {@link VK10#VK_NULL_HANDLE NULL_HANDLE}</li>
 * <li>If {@code objectType} is not {@link VK10#VK_OBJECT_TYPE_UNKNOWN OBJECT_TYPE_UNKNOWN}, {@code objectHandle} <b>must</b> be {@link VK10#VK_NULL_HANDLE NULL_HANDLE} or a valid Vulkan handle of the type associated with {@code objectType} as defined in the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#debugging-object-types">VkObjectType and Vulkan Handle Relationship</a> table</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link EXTDebugUtils#VK_STRUCTURE_TYPE_DEBUG_UTILS_OBJECT_NAME_INFO_EXT STRUCTURE_TYPE_DEBUG_UTILS_OBJECT_NAME_INFO_EXT}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL}</li>
 * <li>{@code objectType} <b>must</b> be a valid {@code VkObjectType} value</li>
 * <li>If {@code pObjectName} is not {@code NULL}, {@code pObjectName} <b>must</b> be a null-terminated UTF-8 string</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkDebugUtilsMessengerCallbackDataEXT}, {@link EXTDebugUtils#vkSetDebugUtilsObjectNameEXT SetDebugUtilsObjectNameEXT}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code objectType} &ndash; a {@code VkObjectType} specifying the type of the object to be named.</li>
 * <li>{@code objectHandle} &ndash; the object to be named.</li>
 * <li>{@code pObjectName} &ndash; a null-terminated UTF-8 string specifying the name to apply to {@code objectHandle}.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkDebugUtilsObjectNameInfoEXT {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkObjectType objectType;
 *     uint64_t objectHandle;
 *     char const * pObjectName;
 * }</code></pre>
 */
class DebugUtilsObjectNameInfoEXT(
        var objectType: VkObjectType,
        var objectHandle: Long,
        var objectName: String?) {

    val type get() = VkStructureType.DEBUG_UTILS_OBJECT_NAME_INFO_EXT

    infix fun write(stack: MemoryStack): Adr {
        val adr = stack.ncalloc(VkDebugUtilsObjectNameInfoEXT.ALIGNOF, 1, VkDebugUtilsObjectNameInfoEXT.SIZEOF)
        VkDebugUtilsObjectNameInfoEXT.nobjectType(adr, objectType.i)
        VkDebugUtilsObjectNameInfoEXT.nobjectHandle(adr, objectHandle)
        objectName?.let { memPutAddress(adr + VkDebugUtilsObjectNameInfoEXT.POBJECTNAME, stack.utf8Adr(it)) }
        return adr
    }
}

/**
 * Specify parameters of a tag to attach to an object.
 *
 * <h5>Description</h5>
 *
 * <p>The {@code tagName} parameter gives a name or identifier to the type of data being tagged. This can be used by debugging layers to easily filter for only data that can be used by that implementation.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code objectType} <b>must</b> not be {@link VK10#VK_OBJECT_TYPE_UNKNOWN OBJECT_TYPE_UNKNOWN}</li>
 * <li>{@code objectHandle} <b>must</b> be a valid Vulkan handle of the type associated with {@code objectType} as defined in the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#debugging-object-types">VkObjectType and Vulkan Handle Relationship</a> table</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link EXTDebugUtils#VK_STRUCTURE_TYPE_DEBUG_UTILS_OBJECT_TAG_INFO_EXT STRUCTURE_TYPE_DEBUG_UTILS_OBJECT_TAG_INFO_EXT}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL}</li>
 * <li>{@code objectType} <b>must</b> be a valid {@code VkObjectType} value</li>
 * <li>{@code pTag} <b>must</b> be a valid pointer to an array of {@code tagSize} bytes</li>
 * <li>{@code tagSize} <b>must</b> be greater than 0</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link EXTDebugUtils#vkSetDebugUtilsObjectTagEXT SetDebugUtilsObjectTagEXT}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code objectType} &ndash; a {@code VkObjectType} specifying the type of the object to be named.</li>
 * <li>{@code objectHandle} &ndash; the object to be tagged.</li>
 * <li>{@code tagName} &ndash; a numerical identifier of the tag.</li>
 * <li>{@code tagSize} &ndash; the number of bytes of data to attach to the object.</li>
 * <li>{@code pTag} &ndash; an array of {@code tagSize} bytes containing the data to be associated with the object.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkDebugUtilsObjectTagInfoEXT {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkObjectType objectType;
 *     uint64_t objectHandle;
 *     uint64_t tagName;
 *     size_t tagSize;
 *     void const * pTag;
 * }</code></pre>
 */
class DebugUtilsObjectTagInfoEXT(
        var objectType: VkObjectType,
        var objectHandle: Long,
        var tagName: Long,
        var tag: ByteBuffer) {

    val type get() = VkStructureType.DEBUG_UTILS_OBJECT_TAG_INFO_EXT
}

/**
 * Specify parameters of a label region.
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link EXTDebugUtils#VK_STRUCTURE_TYPE_DEBUG_UTILS_LABEL_EXT STRUCTURE_TYPE_DEBUG_UTILS_LABEL_EXT}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL}</li>
 * <li>{@code pLabelName} <b>must</b> be a null-terminated UTF-8 string</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkDebugUtilsMessengerCallbackDataEXT}, {@link EXTDebugUtils#vkCmdBeginDebugUtilsLabelEXT CmdBeginDebugUtilsLabelEXT}, {@link EXTDebugUtils#vkCmdInsertDebugUtilsLabelEXT CmdInsertDebugUtilsLabelEXT}, {@link EXTDebugUtils#vkQueueBeginDebugUtilsLabelEXT QueueBeginDebugUtilsLabelEXT}, {@link EXTDebugUtils#vkQueueInsertDebugUtilsLabelEXT QueueInsertDebugUtilsLabelEXT}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code pLabelName} &ndash; a pointer to a null-terminated UTF-8 string that contains the name of the label.</li>
 * <li>{@code color[4]} &ndash; an optional RGBA color value that can be associated with the label. A particular implementation <b>may</b> choose to ignore this color value. The values contain RGBA values in order, in the range 0.0 to 1.0. If all elements in {@code color} are set to 0.0 then it is ignored.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkDebugUtilsLabelEXT {
 *     VkStructureType sType;
 *     void const * pNext;
 *     char const * pLabelName;
 *     float color[4];
 * }</code></pre>
 */
class DebugUtilsLabelEXT(
        var labelName: String,
        var color: Vec4) {

    val type get() = VkStructureType.DEBUG_UTILS_LABEL_EXT
}

/**
 * Structure specifying parameters returned to the callback.
 *
 * <h5>Description</h5>
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>This structure should only be considered valid during the lifetime of the triggered callback.</p>
 * </div>
 *
 * <p>Since adding queue and command buffer labels behaves like pushing and popping onto a stack, the order of both {@code pQueueLabels} and {@code pCmdBufLabels} is based on the order the labels were defined. The result is that the first label in either {@code pQueueLabels} or {@code pCmdBufLabels} will be the first defined (and therefore the oldest) while the last label in each list will be the most recent.</p>
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>{@code pQueueLabels} will only be non-NULL if one of the objects in {@code pObjects} can be related directly to a defined {@code VkQueue} which has had one or more labels associated with it.</p>
 *
 * <p>Likewise, {@code pCmdBufLabels} will only be non-NULL if one of the objects in {@code pObjects} can be related directly to a defined {@code VkCommandBuffer} which has had one or more labels associated with it. Additionally, while command buffer labels allow for beginning and ending across different command buffers, the debug messaging framework <b>cannot</b> guarantee that labels in {@code pCmdBufLables} will contain those defined outside of the associated command buffer. This is partially due to the fact that the association of one command buffer with another may not have been defined at the time the debug message is triggered.</p>
 * </div>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link EXTDebugUtils#VK_STRUCTURE_TYPE_DEBUG_UTILS_MESSENGER_CALLBACK_DATA_EXT STRUCTURE_TYPE_DEBUG_UTILS_MESSENGER_CALLBACK_DATA_EXT}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL}</li>
 * <li>{@code flags} <b>must</b> be 0</li>
 * <li>If {@code pMessageIdName} is not {@code NULL}, {@code pMessageIdName} <b>must</b> be a null-terminated UTF-8 string</li>
 * <li>{@code pMessage} <b>must</b> be a null-terminated UTF-8 string</li>
 * <li>If {@code queueLabelCount} is not 0, {@code pQueueLabels} <b>must</b> be a valid pointer to an array of {@code queueLabelCount} valid {@link VkDebugUtilsLabelEXT} structures</li>
 * <li>If {@code cmdBufLabelCount} is not 0, {@code pCmdBufLabels} <b>must</b> be a valid pointer to an array of {@code cmdBufLabelCount} valid {@link VkDebugUtilsLabelEXT} structures</li>
 * <li>If {@code objectCount} is not 0, {@code pObjects} <b>must</b> be a valid pointer to an array of {@code objectCount} valid {@link VkDebugUtilsObjectNameInfoEXT} structures</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkDebugUtilsLabelEXT}, {@link VkDebugUtilsObjectNameInfoEXT}, {@link EXTDebugUtils#vkSubmitDebugUtilsMessageEXT SubmitDebugUtilsMessageEXT}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code flags} &ndash; 0 and reserved for future use.</li>
 * <li>{@code pMessageIdName} &ndash; a null-terminated string that identifies the particular message ID that is associated with the provided message. If the message corresponds to a validation layer message, then this string may contain the portion of the Vulkan specification that is believed to have been violated.</li>
 * <li>{@code messageIdNumber} &ndash; the ID number of the triggering message. If the message corresponds to a validation layer message, then this number is related to the internal number associated with the message being triggered.</li>
 * <li>{@code pMessage} &ndash; a null-terminated string detailing the trigger conditions.</li>
 * <li>{@code queueLabelCount} &ndash; a count of items contained in the {@code pQueueLabels} array.</li>
 * <li>{@code pQueueLabels} &ndash; NULL or a pointer to an array of {@link VkDebugUtilsLabelEXT} active in the current {@code VkQueue} at the time the callback was triggered. Refer to <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#debugging-queue-labels">Queue Labels</a> for more information.</li>
 * <li>{@code cmdBufLabelCount} &ndash; a count of items contained in the {@code pCmdBufLabels} array.</li>
 * <li>{@code pCmdBufLabels} &ndash; NULL or a pointer to an array of {@link VkDebugUtilsLabelEXT} active in the current {@code VkCommandBuffer} at the time the callback was triggered. Refer to <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#debugging-command-buffer-labels">Command Buffer Labels</a> for more information.</li>
 * <li>{@code objectCount} &ndash; a count of items contained in the {@code pObjects} array.</li>
 * <li>{@code pObjects} &ndash; a pointer to an array of {@link VkDebugUtilsObjectNameInfoEXT} objects related to the detected issue. The array is roughly in order or importance, but the 0th element is always guaranteed to be the most important object for this message.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkDebugUtilsMessengerCallbackDataEXT {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkDebugUtilsMessengerCallbackDataFlagsEXT flags;
 *     char const * pMessageIdName;
 *     int32_t messageIdNumber;
 *     char const * pMessage;
 *     uint32_t queueLabelCount;
 *     {@link VkDebugUtilsLabelEXT VkDebugUtilsLabelEXT} const * pQueueLabels;
 *     uint32_t cmdBufLabelCount;
 *     {@link VkDebugUtilsLabelEXT VkDebugUtilsLabelEXT} const * pCmdBufLabels;
 *     uint32_t objectCount;
 *     {@link VkDebugUtilsObjectNameInfoEXT VkDebugUtilsObjectNameInfoEXT} const * pObjects;
 * }</code></pre>
 */
class DebugUtilsMessengerCallbackDataEXT(
        var messageIdName: String,
        var messageIdNumber: Int,
        var message: String,
        var queueLabels: Array<DebugUtilsLabelEXT>?,
        var cmdBufLabels: Array<DebugUtilsLabelEXT>?,
        var objects: Array<DebugUtilsObjectNameInfoEXT>) {

    val type get() = VkStructureType.DEBUG_UTILS_MESSENGER_CALLBACK_DATA_EXT
}

interface Device_EXT_debug_utils : Pointer {

    val capabilities: CapabilitiesDevice

    // --- [ vkSetDebugUtilsObjectNameEXT ] ---

    infix fun MemoryStack.setDebugUtilsObjectNameEXT(nameInfo: DebugUtilsObjectNameInfoEXT): VkResult =
            VkResult(callPPI(adr, nameInfo write this, capabilities.vkSetDebugUtilsObjectNameEXT))

    fun setDebugUtilsObjectNameEXT(nameInfo: DebugUtilsObjectNameInfoEXT): VkResult =
            stak { it setDebugUtilsObjectNameEXT nameInfo }
}

typealias DebugUtilsMessengerCallbackEXT = (
        messageSeverity: VkDebugUtilsMessageSeverityEXT,
        messageTypes: VkDebugUtilsMessageTypeFlagsEXT,
        callbackData: DebugUtilsMessengerCallbackDataEXT,
        userData: Any) -> Boolean

/**
 * Structure specifying parameters of a newly created debug messenger.
 *
 * <h5>Description</h5>
 *
 * <p>For each {@code VkDebugUtilsMessengerEXT} that is created the {@link VkDebugUtilsMessengerCreateInfoEXT}{@code ::messageSeverity} and {@link VkDebugUtilsMessengerCreateInfoEXT}{@code ::messageType} determine when that {@link VkDebugUtilsMessengerCreateInfoEXT}{@code ::pfnUserCallback} is called. The process to determine if the user's {@code pfnUserCallback} is triggered when an event occurs is as follows:</p>
 *
 * <ul>
 * <li>The implementation will perform a bitwise AND of the event&#8217;s {@code VkDebugUtilsMessageSeverityFlagBitsEXT} with the {@code messageSeverity} provided during creation of the {@code VkDebugUtilsMessengerEXT} object.
 *
 * <ul>
 * <li>If the value is 0, the message is skipped.</li>
 * </ul>
 * </li>
 * <li>The implementation will perform bitwise AND of the event&#8217;s {@code VkDebugUtilsMessageTypeFlagBitsEXT} with the {@code messageType} provided during the creation of the {@code VkDebugUtilsMessengerEXT} object.
 *
 * <ul>
 * <li>If the value is 0, the message is skipped.</li>
 * </ul>
 * </li>
 * <li>The callback will trigger a debug message for the current event</li>
 * </ul>
 *
 * <p>The callback will come directly from the component that detected the event, unless some other layer intercepts the calls for its own purposes (filter them in a different way, log to a system error log, etc.).</p>
 *
 * <p>An application <b>can</b> receive multiple callbacks if multiple {@code VkDebugUtilsMessengerEXT} objects are created. A callback will always be executed in the same thread as the originating Vulkan call.</p>
 *
 * <p>A callback <b>can</b> be called from multiple threads simultaneously (if the application is making Vulkan calls from multiple threads).</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code pfnUserCallback} <b>must</b> be a valid {@link VkDebugUtilsMessengerCallbackEXT}</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link EXTDebugUtils#VK_STRUCTURE_TYPE_DEBUG_UTILS_MESSENGER_CREATE_INFO_EXT STRUCTURE_TYPE_DEBUG_UTILS_MESSENGER_CREATE_INFO_EXT}</li>
 * <li>{@code flags} <b>must</b> be 0</li>
 * <li>{@code messageSeverity} <b>must</b> be a valid combination of {@code VkDebugUtilsMessageSeverityFlagBitsEXT} values</li>
 * <li>{@code messageSeverity} <b>must</b> not be 0</li>
 * <li>{@code messageType} <b>must</b> be a valid combination of {@code VkDebugUtilsMessageTypeFlagBitsEXT} values</li>
 * <li>{@code messageType} <b>must</b> not be 0</li>
 * <li>{@code pfnUserCallback} <b>must</b> be a valid {@link VkDebugUtilsMessengerCallbackEXT} value</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkDebugUtilsMessengerCallbackEXT}, {@link EXTDebugUtils#vkCreateDebugUtilsMessengerEXT CreateDebugUtilsMessengerEXT}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code flags} &ndash; 0 and reserved for future use.</li>
 * <li>{@code messageSeverity} &ndash; a bitmask of {@code VkDebugUtilsMessageSeverityFlagBitsEXT} specifying which severity of event(s) will cause this callback to be called.</li>
 * <li>{@code messageType} &ndash; a bitmask of {@code VkDebugUtilsMessageTypeFlagBitsEXT} specifying which type of event(s) will cause this callback to be called.</li>
 * <li>{@code pfnUserCallback} &ndash; the application callback function to call.</li>
 * <li>{@code pUserData} &ndash; user data to be passed to the callback.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkDebugUtilsMessengerCreateInfoEXT {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkDebugUtilsMessengerCreateFlagsEXT flags;
 *     VkDebugUtilsMessageSeverityFlagsEXT messageSeverity;
 *     VkDebugUtilsMessageTypeFlagsEXT messageType;
 *     {@link VkDebugUtilsMessengerCallbackEXTI PFN_vkDebugUtilsMessengerCallbackEXT} pfnUserCallback;
 *     void * pUserData;
 * }</code></pre>
 */
class DebugUtilsMessengerCreateInfoEXT(

)

//typedef VkResult (VKAPI_PTR *PFN_vkSetDebugUtilsObjectNameEXT)(VkDevice device, const VkDebugUtilsObjectNameInfoEXT* pNameInfo);
//typedef VkResult (VKAPI_PTR *PFN_vkSetDebugUtilsObjectTagEXT)(VkDevice device, const VkDebugUtilsObjectTagInfoEXT* pTagInfo);
//typedef void (VKAPI_PTR *PFN_vkQueueBeginDebugUtilsLabelEXT)(VkQueue queue, const VkDebugUtilsLabelEXT* pLabelInfo);
//typedef void (VKAPI_PTR *PFN_vkQueueEndDebugUtilsLabelEXT)(VkQueue queue);
//typedef void (VKAPI_PTR *PFN_vkQueueInsertDebugUtilsLabelEXT)(VkQueue queue, const VkDebugUtilsLabelEXT* pLabelInfo);
//typedef void (VKAPI_PTR *PFN_vkCmdBeginDebugUtilsLabelEXT)(VkCommandBuffer commandBuffer, const VkDebugUtilsLabelEXT* pLabelInfo);
//typedef void (VKAPI_PTR *PFN_vkCmdEndDebugUtilsLabelEXT)(VkCommandBuffer commandBuffer);
//typedef void (VKAPI_PTR *PFN_vkCmdInsertDebugUtilsLabelEXT)(VkCommandBuffer commandBuffer, const VkDebugUtilsLabelEXT* pLabelInfo);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateDebugUtilsMessengerEXT)(VkInstance instance, const VkDebugUtilsMessengerCreateInfoEXT* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkDebugUtilsMessengerEXT* pMessenger);
//typedef void (VKAPI_PTR *PFN_vkDestroyDebugUtilsMessengerEXT)(VkInstance instance, VkDebugUtilsMessengerEXT messenger, const VkAllocationCallbacks* pAllocator);
//typedef void (VKAPI_PTR *PFN_vkSubmitDebugUtilsMessageEXT)(VkInstance instance, VkDebugUtilsMessageSeverityFlagBitsEXT messageSeverity, VkDebugUtilsMessageTypeFlagsEXT messageTypes, const VkDebugUtilsMessengerCallbackDataEXT* pCallbackData);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkSetDebugUtilsObjectNameEXT(
//VkDevice                                    device,
//const VkDebugUtilsObjectNameInfoEXT*        pNameInfo);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkSetDebugUtilsObjectTagEXT(
//VkDevice                                    device,
//const VkDebugUtilsObjectTagInfoEXT*         pTagInfo);
//
//VKAPI_ATTR void VKAPI_CALL vkQueueBeginDebugUtilsLabelEXT(
//VkQueue                                     queue,
//const VkDebugUtilsLabelEXT*                 pLabelInfo);
//
//VKAPI_ATTR void VKAPI_CALL vkQueueEndDebugUtilsLabelEXT(
//VkQueue                                     queue);
//
//VKAPI_ATTR void VKAPI_CALL vkQueueInsertDebugUtilsLabelEXT(
//VkQueue                                     queue,
//const VkDebugUtilsLabelEXT*                 pLabelInfo);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdBeginDebugUtilsLabelEXT(
//VkCommandBuffer                             commandBuffer,
//const VkDebugUtilsLabelEXT*                 pLabelInfo);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdEndDebugUtilsLabelEXT(
//VkCommandBuffer                             commandBuffer);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdInsertDebugUtilsLabelEXT(
//VkCommandBuffer                             commandBuffer,
//const VkDebugUtilsLabelEXT*                 pLabelInfo);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateDebugUtilsMessengerEXT(
//VkInstance                                  instance,
//const VkDebugUtilsMessengerCreateInfoEXT*   pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkDebugUtilsMessengerEXT*                   pMessenger);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyDebugUtilsMessengerEXT(
//VkInstance                                  instance,
//VkDebugUtilsMessengerEXT                    messenger,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR void VKAPI_CALL vkSubmitDebugUtilsMessageEXT(
//VkInstance                                  instance,
//VkDebugUtilsMessageSeverityFlagBitsEXT      messageSeverity,
//VkDebugUtilsMessageTypeFlagsEXT             messageTypes,
//const VkDebugUtilsMessengerCallbackDataEXT* pCallbackData);