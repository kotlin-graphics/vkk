package tests

import io.kotlintest.specs.StringSpec
import main.isNotCI
import vkk.VkQueueFlag
import vkk._10.structs.DeviceCreateInfo
import vkk._10.structs.DeviceQueueCreateInfo
import vkk.has
import vkk.unique
import vkk.vu

class `03 initDevice` : StringSpec() {

    val appName = "03_InitDevice"

    init {
        if (isNotCI)
            appName {
                unique {
                    val instance = vu.createInstance(appName, engineName).unique()
//                  if(vk.DEBUG)
//                      vk::UniqueDebugUtilsMessengerEXT debugUtilsMessenger = vk::su::createDebugUtilsMessenger(instance);

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
                    val device = physicalDevice.createDevice(DeviceCreateInfo(0, deviceQueueCreateInfo)).unique()

                    // Note: No need to explicitly destroy the device, as the corresponding destroy function is
                    // called by the destructor of the UniqueDevice on leaving this scope.
                }
            }
    }
}