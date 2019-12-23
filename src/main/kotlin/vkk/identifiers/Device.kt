package identifiers

import kool.*
import org.lwjgl.system.APIUtil.apiLog
import org.lwjgl.system.Checks
import org.lwjgl.system.FunctionProvider
import org.lwjgl.system.JNI.*
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.vulkan.VkPhysicalDeviceProperties
import vkk.*
import vkk._10.api.*
import vkk._10.structs.*
import vkk._11.api.Device_vk11
import vkk._11.structs.DeviceQueueInfo2
import vkk.entities.*

/** Wraps a Vulkan device dispatchable handle. */
class Device(handle: Ptr,
             val physicalDevice: PhysicalDevice, ci: DeviceCreateInfo, apiVersion: Int = 0
)

    : DispatchableHandleDevice(handle, getDeviceCapabilities(handle, physicalDevice, ci, apiVersion)),

        Device_vk10,

        Device_vk11 {


    // ---------------------------------------------- VK10 -------------------------------------------------------------


    // --- [ vkAllocateCommandBuffers ] ---
    inline fun nAllocateCommandBuffers(pAllocateInfo: Ptr, pCommandBuffers: Ptr): VkResult =
            VkResult(callPPPI(adr, pAllocateInfo, pCommandBuffers, capabilities.vkAllocateCommandBuffers))


    infix fun MemoryStack.allocateCommandBuffer(allocateInfo: CommandBufferAllocateInfo): CommandBuffer =
            framed { CommandBuffer(this.pointerAdr { nAllocateCommandBuffers(allocateInfo write this, it).check() }, this@Device) }

    infix fun allocateCommandBuffer(allocateInfo: CommandBufferAllocateInfo): CommandBuffer =
            stak { it allocateCommandBuffer allocateInfo }


    infix fun MemoryStack.allocateCommandBuffers(allocateInfo: CommandBufferAllocateInfo): Array<CommandBuffer> =
            framed {
                val pCommandBuffers = this.mPointer(allocateInfo.commandBufferCount)
                nAllocateCommandBuffers(allocateInfo write this, pCommandBuffers.adr)
                Array(allocateInfo.commandBufferCount) {
                    CommandBuffer(memGetAddress(pCommandBuffers[it]), this@Device)
                }
            }

    infix fun allocateCommandBuffers(allocateInfo: CommandBufferAllocateInfo): Array<CommandBuffer> =
            stak { it allocateCommandBuffers allocateInfo }

    // --- [ vkGetDeviceQueue ] ---

    fun MemoryStack.getQueue(queueFamilyIndex: Int, queueIndex: Int = 0): Queue =
            framed { Queue(this.pointerAdr { callPPV(adr, queueFamilyIndex, queueIndex, it, capabilities.vkGetDeviceQueue) }, this@Device) }

    fun getQueue(queueFamilyIndex: Int, queueIndex: Int = 0): Queue =
            stak { it.getQueue(queueFamilyIndex, queueIndex) }


    // JVM custom: vkMapMemory + vkUnmapMemory
    inline fun <R> MemoryStack.mappedMemory(memory: VkDeviceMemory, offset: VkDeviceSize, size: VkDeviceSize, flags: VkMemoryMapFlags = 0, block: (Ptr) -> R): R =
            block(mapMemory(memory, offset, size, flags)).also { unmapMemory(memory) }

    inline fun <R> mappedMemory(memory: VkDeviceMemory, offset: VkDeviceSize, size: VkDeviceSize, flags: VkMemoryMapFlags = 0, block: (Ptr) -> R): R =
            block(mapMemory(memory, offset, size, flags)).also { unmapMemory(memory) }


    inline fun <R> MemoryStack.withFence(flags: VkFenceCreateFlags = 0, block: (VkFence) -> R): R {
        val fence = createFence(FenceCreateInfo(flags))
        return block(fence).also {
            destroy(fence)
        }
    }

    inline fun <R> withFence(flags: VkFenceCreateFlags = 0, block: (VkFence) -> R): R {
        val fence = createFence(FenceCreateInfo(flags))
        return block(fence).also {
            destroy(fence)
        }
    }

    // ---------------------------------------------- VK11 -------------------------------------------------------------


    // --- [ vkGetDeviceQueue2 ] ---

    infix fun MemoryStack.getQueue2(queueInfo: DeviceQueueInfo2): Queue =
            framed {
                Queue(this.longAdr {
                    callPPPV(adr, queueInfo write this, it, capabilities.vkGetDeviceQueue2)
                }, this@Device)
            }

    infix fun getQueue2(queueInfo: DeviceQueueInfo2): Queue =
            stak { it getQueue2 queueInfo }

}

private fun getDeviceCapabilities(handle: Ptr, physicalDevice: PhysicalDevice, ci: DeviceCreateInfo, apiVersion_: Int): CapabilitiesDevice {
    var apiVersion = apiVersion_
    val GetDeviceProcAddr = stak { s ->
        if (apiVersion == 0) {
            val GetPhysicalDeviceProperties = callPPP(
                    physicalDevice.instance.adr,
                    s.asciiAdr("vkGetPhysicalDeviceProperties"),
                    VK.globalCommands!!.vkGetInstanceProcAddr
            )
            val props = s.ncalloc(VkPhysicalDeviceProperties.ALIGNOF, 1, VkPhysicalDeviceProperties.SIZEOF)
            callPPV(physicalDevice.adr, props, GetPhysicalDeviceProperties)
            apiVersion = memGetInt(props)
            if (apiVersion == 0)  // vkGetPhysicalDeviceProperties failed?
                apiVersion = physicalDevice.instance.capabilities.apiVersion
        }

        callPPP(physicalDevice.instance.adr, s.asciiAdr("vkGetDeviceProcAddr"), VK.globalCommands!!.vkGetInstanceProcAddr)
    }

    return CapabilitiesDevice(FunctionProvider { functionName ->
        callPPP(handle, functionName.adr, GetDeviceProcAddr).also {
            if (it == NULL && Checks.DEBUG_FUNCTIONS)
                apiLog("Failed to locate address for VK device function " + memASCII(functionName))
        }
    }, physicalDevice.capabilities, VK.getEnabledExtensionSet(apiVersion, ci.enabledExtensionNames))
}