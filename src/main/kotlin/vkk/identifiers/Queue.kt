package vkk.identifiers

import kool.Ptr
import vkk._10.api.Queue_vk10
import vkk.extensions.Queue_KHR_swapchain

/** Wraps a Vulkan queue handle.  */
class Queue
/**
 * Creates a `VkQueue` using the specified native handle and device.
 *
 * @param handle the native `VkQueue` handle
 * @param device the device from which the queue was retrieved
 */
constructor(handle: Ptr,
            /** Returns the device from which this `VkQueue` was retrieved.  */
            val device: Device) :

        DispatchableHandleDevice(handle, device.capabilities),

        Queue_vk10,

        Queue_KHR_swapchain