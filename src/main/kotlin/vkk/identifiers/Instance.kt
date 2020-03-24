package vkk.identifiers

import kool.*
import org.lwjgl.system.APIUtil.apiLog
import org.lwjgl.system.Checks
import org.lwjgl.system.FunctionProvider
import org.lwjgl.system.JNI.*
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryStack.stackPush
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.vulkan.VK10.VK_SUCCESS
import org.lwjgl.vulkan.VkExtensionProperties
import org.lwjgl.vulkan.VkPhysicalDeviceGroupProperties
import vkk.*
import vkk._10.structs.InstanceCreateInfo
import vkk._11.structs.PhysicalDeviceGroupProperties
import vkk.extensions.Instance_KHR_surface
import vkk.unique.UniqueInstanceI
import java.util.*

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
class Instance
/**
 * Creates a {@link VkInstance} instance for the specified native handle.
 *
 * @param handle the native {@code VkInstance} handle
 * @param ci     the {@link VkInstanceCreateInfo} structured used to create the {@code VkInstance}.
 */
internal constructor(handle: Ptr, ci: InstanceCreateInfo) :
        Dispatchable(handle, getInstanceCapabilities(handle, ci)),
        Instance_KHR_surface,
        VkCloseable,
        UniqueInstanceI {

    // ---------------------------------------------- VK10 -------------------------------------------------------------

    // --- [ vkCreateInstance ] ---
    constructor(createInfo: InstanceCreateInfo) : this(
            VkStack { s ->
                s.pointerAdr {
                    VK_CHECK_RESULT(callPPPI(createInfo write s, NULL, it, VK.globalCommands!!.vkCreateInstance))
                }
            }, createInfo)

    // --- [ vkDestroyInstance ] ---
    fun destroy() = callPPV(adr, NULL, capabilities.vkDestroyInstance)

    // ---------------------------------------------- VK11 -------------------------------------------------------------

    // --- [ vkEnumeratePhysicalDeviceGroups ] ---
    inline fun nEnumeratePhysicalDeviceGroups(pPhysicalDeviceGroupCount: IntPtr, pPhysicalDeviceGroupProperties: Ptr = NULL): VkResult =
            VkResult(callPPPI(adr, pPhysicalDeviceGroupCount.adr, pPhysicalDeviceGroupProperties, capabilities.vkEnumeratePhysicalDeviceGroups))

    val MemoryStack.enumeratePhysicalDeviceGroups: Array<PhysicalDeviceGroupProperties>
        get() = framed {
            var physicalDeviceGroupProperties: Ptr = NULL
            var physicalDeviceGroupCount: Int
            val pPhysicalDeviceGroupCount = this.mInt()
            var result: VkResult
            do {
                result = nEnumeratePhysicalDeviceGroups(pPhysicalDeviceGroupCount)
                physicalDeviceGroupCount = pPhysicalDeviceGroupCount[0]
                if (result == VkResult.SUCCESS && physicalDeviceGroupCount != 0) {
                    physicalDeviceGroupProperties = this.ncalloc(VkPhysicalDeviceGroupProperties.ALIGNOF, physicalDeviceGroupCount, VkPhysicalDeviceGroupProperties.SIZEOF)
                    result = nEnumeratePhysicalDeviceGroups(pPhysicalDeviceGroupCount, physicalDeviceGroupProperties)
                }
            } while (result == VkResult.INCOMPLETE)
            assert(physicalDeviceGroupProperties != NULL) // TODO others
            Array(physicalDeviceGroupCount) {
                PhysicalDeviceGroupProperties(physicalDeviceGroupProperties + it * VkPhysicalDeviceGroupProperties.SIZEOF, this@Instance)
            }
        }

    val enumeratePhysicalDeviceGroups: Array<PhysicalDeviceGroupProperties>
        get() = stak { it.enumeratePhysicalDeviceGroups }


    override fun close() = destroy()
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