package vkk.identifiers

import kool.Ptr
import kool.adr
import org.lwjgl.system.JNI
import vkk.VkResult

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

        DispatchableHandleDevice(handle, device.capabilities) {

    // ---------------------------------------------- VK10 -------------------------------------------------------------

    // --- [ vkQueueWaitIdle ] ---
    fun waitIdle(): VkResult = VkResult(JNI.callPI(adr, capabilities.vkQueueWaitIdle)).andCheck()
}