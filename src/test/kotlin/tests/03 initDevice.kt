package tests

import io.kotlintest.specs.StringSpec
import main.isNotCI
import vkk.VkQueueFlag
import vkk.has
import vkk.unique.`try`
import vkk.unique.vu
import vkk.vk10.physicalDevices
import vkk.vk10.queueFamilyProperties
import vkk.vk10.structs.DeviceCreateInfo
import vkk.vk10.structs.DeviceQueueCreateInfo

class `03 initDevice` : StringSpec() {

    val appName = "03_InitDevice"

    init {
        if (isNotCI)
            appName {
                `try` {
                    val instance = vu.createInstance(appName, engineName)
//                  if(vk.DEBUG)
//                      vk::UniqueDebugUtilsMessengerEXT debugUtilsMessenger = vk::su::createDebugUtilsMessenger(instance);

                    val physicalDevice = instance.physicalDevices[0]

                    /* VULKAN_HPP_KEY_START */

                    // get the QueueFamilyProperties of the first PhysicalDevice
                    val queueFamilyProperties = physicalDevice.queueFamilyProperties

                    // get the first index into queueFamiliyProperties which supports graphics
                    val graphicsQueueFamilyIndex = queueFamilyProperties.indexOfFirst { it.queueFlags has VkQueueFlag.GRAPHICS_BIT }
                    assert(graphicsQueueFamilyIndex in queueFamilyProperties.indices)

                    // create a UniqueDevice
                    val queuePriority = 0f
                    val deviceQueueCreateInfo = DeviceQueueCreateInfo(0, graphicsQueueFamilyIndex, queuePriority)
                    val device = physicalDevice.createDeviceUnique(DeviceCreateInfo(0, deviceQueueCreateInfo))

                    // Note: No need to explicitly destroy the device, as the corresponding destroy function is
                    // called by the destructor of the UniqueDevice on leaving this scope.
                }
            }
    }
}