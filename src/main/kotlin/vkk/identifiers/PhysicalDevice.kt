package vkk.identifiers

import kool.Adr
import kool.adr
import kool.pointerAdr
import org.lwjgl.system.Checks
import org.lwjgl.system.JNI.callPPPPI
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.vulkan.VkAllocationCallbacks
import org.lwjgl.vulkan.VkDeviceCreateInfo
import vkk.VK_CHECK_RESULT
import vkk._10.api.PhysicalDevice_vk10
import vkk._10.structs.DeviceCreateInfo
import vkk._11.api.PhysicalDevice_vk11
import vkk.extensions.PhysicalDevice_KHR_surface
import vkk.extensions.PhysicalDevice_KHR_swapchain
import vkk.framed
import vkk.stak

/** Wraps a Vulkan physical device handle.  */
class PhysicalDevice
/**
 * Creates a `VkPhysicalDevice` using the specified native handle and Vulkan instance.
 *
 * @param handle   the native `VkDevice` handle
 * @param instance the Vulkan instance from which the physical device was enumerated
 */
constructor(handle: Adr,
            /** Returns the Vulkan instance from which this physical device was enumerated.  */
            val instance: Instance
) :
        Dispatchable(handle, instance.capabilities),

        PhysicalDevice_vk10,

        PhysicalDevice_vk11,

        PhysicalDevice_KHR_surface,

        PhysicalDevice_KHR_swapchain {


    // ---------------------------------------------- VK10 -------------------------------------------------------------


    // --- [ vkCreateDevice ] ---

    infix fun MemoryStack.createDevice(createInfo: DeviceCreateInfo): Device =
            framed {
                val handle = this.pointerAdr { VK_CHECK_RESULT(callPPPPI(this@PhysicalDevice.adr, createInfo write this, NULL, it, capabilities.vkCreateDevice)) }
                Device(handle, this@PhysicalDevice, createInfo)
            }

    infix fun createDevice(createInfo: DeviceCreateInfo): Device =
            stak { it createDevice createInfo }


//    infix fun MemoryStack.createDeviceUnique(createInfo: DeviceCreateInfo): UniqueDevice =
//            framed {
//                val handle = this.pointerAdr { VK_CHECK_RESULT(callPPPPI(this@PhysicalDevice.adr, createInfo write this, NULL, it, capabilities.vkCreateDevice)) }
//                UniqueDevice(handle, this@PhysicalDevice, createInfo)
//            }
//
//    infix fun createDeviceUnique(createInfo: DeviceCreateInfo): UniqueDevice =
//            stak { it createDeviceUnique createInfo }
}