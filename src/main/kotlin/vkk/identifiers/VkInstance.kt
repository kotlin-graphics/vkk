package vkk.identifiers

import kool.Ptr
import kool.adr
import kool.indices
import kool.stack
import org.lwjgl.system.APIUtil.apiLog
import org.lwjgl.system.Checks
import org.lwjgl.system.JNI.*
import org.lwjgl.system.MemoryStack.stackPush
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.vulkan.VK10.VK_SUCCESS
import org.lwjgl.vulkan.VkExtensionProperties
import vkk.VK_CHECK_RESULT
import vkk.VkCloseable
import vkk.VkStack
import vkk.vk10.api.Instance_vk10
import vkk.vk10.structs.InstanceCreateInfo
import java.util.*

typealias UniqueInstance = VkInstance

//class UniqueInstance(createInfo: InstanceCreateInfo) : Instance(createInfo) {
//    init {
//        // break object reference
//        val address = adr
//        val function =  capabilities.vkDestroyInstance
//        vk.cleaner.register(this) {
//            callPPV(address, NULL, function)
//            println("instance gc'ed")
//        }
//    }
//}

/** Wraps a Vulkan instance handle. */
class VkInstance
/**
 * Creates a [VkInstance] instance for the specified native handle.
 *
 * @param handle the native [VkInstance] handle
 * @param ci     the [VkInstanceCreateInfo] structured used to create the {@code VkInstance}.
 */
internal constructor(handle: Ptr, ci: InstanceCreateInfo) : DispatchableHandleInstance(handle, getInstanceCapabilities(handle, ci)),
                                                            VkCloseable, Instance_vk10 {

    // ---------------------------------------------- VK10 -------------------------------------------------------------

    // --- [ vkCreateInstance ] ---
    constructor(createInfo: InstanceCreateInfo) : this(
        stack { s ->
            s.pointerAdr {
                VK_CHECK_RESULT(callPPPI(createInfo write s, NULL, it, VK.globalCommands.vkCreateInstance))
            }
        }, createInfo)

    // TODO switch it with a dummy constructor VkStack extension call?
    constructor(createInfo: InstanceCreateInfo, stack: VkStack) : this(
        stack {
            stack.pointerAdr {
                VK_CHECK_RESULT(callPPPI(createInfo write stack, NULL, it, VK.globalCommands.vkCreateInstance))
            }
        }, createInfo)

    // --- [ vkDestroyInstance ] ---
    fun destroy() = callPPV(adr, NULL, capabilities.vkDestroyInstance)

    // ---------------------------------------------- VK11 -------------------------------------------------------------


    override fun close() = destroy()

    companion object {
        private fun getInstanceCapabilities(handle: Ptr, ci: InstanceCreateInfo): CapabilitiesInstance {

            val apiVersion = ci.applicationInfo?.apiVersion ?: VK.instanceVersionSupported

            return CapabilitiesInstance(apiVersion,
                                        VK.getEnabledExtensionSet(apiVersion, ci.enabledExtensionNames),
                                        getAvailableDeviceExtensions(handle)) { functionName ->
                callPPP(handle, functionName.adr, VK.globalCommands.vkGetInstanceProcAddr).also {
                    if (it == NULL && Checks.DEBUG_FUNCTIONS)
                        apiLog("Failed to locate address for VK instance function " + memASCII(functionName))
                }
            }
        }
    }
}

// Will be used to identify logical device extensions that extend physical device functionality.
// Such functions can be called on a physical device, before a logical device has been created.
private fun getAvailableDeviceExtensions(instance: Ptr): Set<String> {

    val extensions = HashSet<String>()

    val stack = stackPush()
    val ip = stack.callocInt(1)

    val GetInstanceProcAddr = VK.globalCommands.vkGetInstanceProcAddr
    val EnumeratePhysicalDevices = callPPP(instance, stack.ASCII("vkEnumeratePhysicalDevices").adr, GetInstanceProcAddr)
    val EnumerateDeviceExtensionProperties = callPPP(instance, stack.ASCII("vkEnumerateDeviceExtensionProperties").adr, GetInstanceProcAddr)
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

        val deviceExtensions = VkExtensionProperties.malloc(ip[0], stack)
        err = callPPPPI(physicalDevices[i], NULL, ip.adr, deviceExtensions.adr, EnumerateDeviceExtensionProperties)
        if (err != VK_SUCCESS)
            continue

        for (j in deviceExtensions)
            extensions += j.extensionNameString()
    }
    return extensions.also { stack.pop() }
}