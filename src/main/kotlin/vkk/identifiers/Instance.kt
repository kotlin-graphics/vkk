package identifiers

import classes.DebugReportCallbackCreateInfo
import classes.InstanceCreateInfo
import kool.*
import org.lwjgl.PointerBuffer
import org.lwjgl.system.APIUtil.apiLog
import org.lwjgl.system.Checks
import org.lwjgl.system.FunctionProvider
import org.lwjgl.system.JNI.*
import org.lwjgl.system.MemoryStack.stackPush
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.vulkan.VK10.VK_NULL_HANDLE
import org.lwjgl.vulkan.VK10.VK_SUCCESS
import org.lwjgl.vulkan.VkExtensionProperties
import util.longAddress
import util.nUtf8
import util.nmallocInt
import util.pointerAddress
import vkk.*
import vkk.entities.VkDebugReportCallback
import java.util.*

/** Wraps a Vulkan instance handle. */
class Instance
/**
 * Creates a {@link VkInstance} instance for the specified native handle.
 *
 * @param handle the native {@code VkInstance} handle
 * @param ci     the {@link VkInstanceCreateInfo} structured used to create the {@code VkInstance}.
 */
private constructor(handle: Ptr, ci: InstanceCreateInfo) :
    Dispatchable(handle, getInstanceCapabilities(handle, ci)) {

    constructor(createInfo: InstanceCreateInfo) : this(
        stak { s ->
            s.pointerAdr {
                VK_CHECK_RESULT(callPPPI(createInfo.write(s), NULL, it, VK.globalCommands!!.vkCreateInstance))
            }
        }, createInfo
    )

    // --- [ vkCreateDebugReportCallbackEXT ] ---
    infix fun createDebugReportCallbackEXT(createInfo: DebugReportCallbackCreateInfo): VkDebugReportCallback =
        stak { s ->
            VkDebugReportCallback(s.longAdr {
                VK_CHECK_RESULT(callPPPPI(adr, createInfo.write(s), NULL, it, capabilities.vkCreateDebugReportCallbackEXT))
            })
        }

    // --- [ vkDebugReportMessageEXT ] ---
    fun debugReportMessageEXT(
        flags: VkDebugReportFlagsEXT, objectType: VkDebugReportObjectTypeEXT, `object`: Long = VK_NULL_HANDLE,
        location: Long, messageCode: Int, pLayerPrefix: String, pMessage: String
    ) = stak { s ->
        callPJPPPV(
            adr, flags, objectType.i, `object`, location, messageCode, s.nUtf8(pLayerPrefix),
            s.nUtf8(pMessage), capabilities.vkCreateDebugReportCallbackEXT
        )
    }

    // --- [ vkDestroyDebugReportCallbackEXT ] ---
    infix fun destroy(debugReportCallback: VkDebugReportCallback) =
        callPJPV(adr, debugReportCallback.L, NULL, capabilities.vkDestroyDebugReportCallbackEXT)

    // --- [ vkEnumeratePhysicalDevices ] ---
    inline fun nEnumeratePhysicalDevices(pPhysicalDeviceCount: Ptr, pPhysicalDevices: Ptr): VkResult =
        VkResult(callPPPI(adr, pPhysicalDeviceCount, pPhysicalDevices, capabilities.vkEnumeratePhysicalDevices))

    val enumeratePhysicalDevices: Array<PhysicalDevice>
        get() = stak {
            lateinit var physicalDevices: PointerBuffer
            val pPhysicalDeviceGroupCount = it.nmallocInt()
            var physicalDeviceCount: Int
            var result: VkResult
            do {
                result = nEnumeratePhysicalDevices(pPhysicalDeviceGroupCount, NULL).apply { check() }
                physicalDeviceCount = memGetInt(pPhysicalDeviceGroupCount)
                if (result == VkResult.SUCCESS && physicalDeviceCount != 0) {
                    physicalDevices = it.PointerBuffer(physicalDeviceCount)
                    result = nEnumeratePhysicalDevices(pPhysicalDeviceGroupCount, physicalDevices.adr)
                }
            } while (result == VkResult.INCOMPLETE)
            Array(physicalDeviceCount) { PhysicalDevice(physicalDevices[0], this) }
        }
}

private fun getInstanceCapabilities(handle: Ptr, ci: InstanceCreateInfo): CapabilitiesInstance {

    val apiVersion = ci.applicationInfo?.apiVersion ?: VK.instanceVersionSupported

    return CapabilitiesInstance(
        FunctionProvider { functionName ->
            callPPP(handle, functionName.adr, VK.globalCommands!!.vkGetInstanceProcAddr).also {
                if (it == NULL && Checks.DEBUG_FUNCTIONS)
                    apiLog("Failed to locate address for VK instance function " + memASCII(functionName))
            }
        },
        apiVersion,
        VK.getEnabledExtensionSet(apiVersion, ci.enabledExtensionNames),
        getAvailableDeviceExtensions(handle)
    )
}

// Will be used to identify logical device extensions that extend physical device functionality.
// Such functions can be called on a physical device, before a logical device has been created.
private fun getAvailableDeviceExtensions(instance: Ptr): Set<String> {

    val extensions = HashSet<String>()

    val stack = stackPush()
    val ip = stack.callocInt(1)

    val GetInstanceProcAddr = VK.globalCommands!!.vkGetInstanceProcAddr
    val EnumeratePhysicalDevices = callPPP(instance, stack.ASCII("vkEnumeratePhysicalDevices").adr, GetInstanceProcAddr)
    val EnumerateDeviceExtensionProperties =
        callPPP(instance, stack.ASCII("vkEnumerateDeviceExtensionProperties").adr, GetInstanceProcAddr)
    if (EnumeratePhysicalDevices == NULL || EnumerateDeviceExtensionProperties == NULL)
        return extensions.also { stack.pop() }

    var err = callPPPI(instance, ip.adr, NULL, EnumeratePhysicalDevices)
    if (err != VK_SUCCESS || ip[0] == 0)
        return extensions.also { stack.pop() }

    val physicalDevices = stack.mallocPointer(ip[0])
    err = callPPPI(instance, ip.adr, physicalDevices.adr, EnumeratePhysicalDevices)
    if (err != VK_SUCCESS)
        return extensions.also { stack.pop() }

    for (i in physicalDevices.indices) {
        err = callPPPPI(physicalDevices[i], NULL, memAddress(ip), NULL, EnumerateDeviceExtensionProperties)
        if (err != VK_SUCCESS || ip[0] == 0)
            continue

        val deviceExtensions = VkExtensionProperties.mallocStack(ip[0], stack)
        err = callPPPPI(physicalDevices[i], NULL, ip.adr, deviceExtensions.adr, EnumerateDeviceExtensionProperties)
        if (err != VK_SUCCESS)
            continue

        for (j in deviceExtensions)
            extensions += j.extensionNameString()
    }
    return extensions.also { stack.pop() }
}