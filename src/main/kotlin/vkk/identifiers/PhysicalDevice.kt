package identifiers

import kool.*
import org.lwjgl.system.JNI.*
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.vulkan.VkQueueFamilyProperties2
import org.lwjgl.vulkan.VkSparseImageFormatProperties2
import vkk.VK_CHECK_RESULT
import vkk.VkFormat
import vkk._10.api.PhysicalDevice_vk10
import vkk._10.api.PhysicalDevice_vk11
import vkk._10.structs.DeviceCreateInfo
import vkk._11.structs.*
import vkk.stak

/** Wraps a Vulkan physical device handle.  */
class PhysicalDevice
/**
 * Creates a `VkPhysicalDevice` using the specified native handle and Vulkan instance.
 *
 * @param handle   the native `VkDevice` handle
 * @param instance the Vulkan instance from which the physical device was enumerated
 */
constructor(
        handle: Adr,
        /** Returns the Vulkan instance from which this physical device was enumerated.  */
        val instance: Instance
) :
        Dispatchable(handle, instance.capabilities),

        PhysicalDevice_vk10,

        PhysicalDevice_vk11 {


    // ---------------------------------------------- VK10 -------------------------------------------------------------


    // --- [ vkCreateDevice ] ---
    infix fun createDevice(createInfo: DeviceCreateInfo): Device = stak { s ->
        val handle = s.pointerAdr { VK_CHECK_RESULT(callPPPPI(adr, createInfo write s, NULL, it, capabilities.vkCreateDevice)) }
        Device(handle, this, createInfo)
    }


    // ---------------------------------------------- VK11 -------------------------------------------------------------


}