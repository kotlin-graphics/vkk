package vkk.identifiers

import kool.Adr

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
            val instance: VkInstance
) :
    DispatchableHandleInstance(handle, instance.capabilities) {


    // ---------------------------------------------- VK10 -------------------------------------------------------------


//    infix fun MemoryStack.createDeviceUnique(createInfo: DeviceCreateInfo): UniqueDevice =
//            framed {
//                val handle = this.pointerAdr { VK_CHECK_RESULT(callPPPPI(this@PhysicalDevice.adr, createInfo write this, NULL, it, capabilities.vkCreateDevice)) }
//                UniqueDevice(handle, this@PhysicalDevice, createInfo)
//            }
//
//    infix fun createDeviceUnique(createInfo: DeviceCreateInfo): UniqueDevice =
//            stak { it createDeviceUnique createInfo }
}