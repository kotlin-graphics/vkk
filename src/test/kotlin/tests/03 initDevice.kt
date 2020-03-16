package tests

import io.kotlintest.specs.StringSpec
import kool.adr
import org.lwjgl.system.Configuration
import org.lwjgl.system.JNI
import org.lwjgl.system.MemoryUtil
import org.lwjgl.vulkan.VK10
import org.lwjgl.vulkan.VK11
import org.lwjgl.vulkan.VkDeviceQueueCreateInfo
import vkk.*
import vkk._10.structs.DeviceCreateInfo
import vkk._10.structs.DeviceQueueCreateInfo
import vkk.identifiers.UniqueDevice

class `03_initDevice` : StringSpec() {

    val appName = "03_InitDevice"
    val engineName = "Vulkan.hpp"

    init {

        Configuration.DEBUG.set(true)
        Configuration.DEBUG_STREAM.set(true)
        Configuration.DEBUG_MEMORY_ALLOCATOR.set(true)
        Configuration.DEBUG_MEMORY_ALLOCATOR_INTERNAL.set(true)
        Configuration.DEBUG_LOADER.set(true)
        Configuration.DEBUG_FUNCTIONS.set(true)
        Configuration.DEBUG_STACK.set(true)

        "03 initDevice" {

            val instance = vu.createInstance(appName, engineName)
//            if(vk.DEBUG)
//                vk::UniqueDebugUtilsMessengerEXT debugUtilsMessenger = vk::su::createDebugUtilsMessenger(instance);

            val physicalDevice = instance.enumeratePhysicalDevices[0]

            /* VULKAN_HPP_KEY_START */

            // get the QueueFamilyProperties of the first PhysicalDevice
            val queueFamilyProperties = physicalDevice.queueFamilyProperties

            // get the first index into queueFamiliyProperties which supports graphics
            val graphicsQueueFamilyIndex = queueFamilyProperties.indexOfFirst { it.queueFlags has VkQueueFlag.GRAPHICS_BIT }
            assert(graphicsQueueFamilyIndex in queueFamilyProperties.indices)

            // create a UniqueDevice
            val queuePriority = 0f
            val deviceQueueCreateInfo = DeviceQueueCreateInfo(0, graphicsQueueFamilyIndex, queuePriority)
//            val device = physicalDevice.createDeviceUnique(DeviceCreateInfo(queueCreateInfo = deviceQueueCreateInfo))

            // Note: No need to explicitly destroy the device, as the corresponding destroy function is
            // called by the destructor of the UniqueDevice on leaving this scope.
        }
    }
}