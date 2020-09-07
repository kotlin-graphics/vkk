package tests

import io.kotest.core.spec.style.StringSpec
import main.isNotCI
import vkk.unique.`try`
import vkk.unique.vu
import vkk.vk10.structs.CommandBufferAllocateInfo
import vkk.vk10.structs.CommandPoolCreateInfo

class `04 initCommandBuffer` : StringSpec() {

    val appName = "04_InitCommandBuffer"

    init {
        if (isNotCI)
            appName {
                `try` {
                    val instance = vu.createInstance(appName, engineName)
//                  if(DEBUG)
//                      vk::UniqueDebugUtilsMessengerEXT debugUtilsMessenger = vk::su::createDebugUtilsMessenger(instance);

                    val physicalDevice = instance.physicalDevices[0]

                    val graphicsQueueFamilyIndex = vu.findGraphicsQueueFamilyIndex(physicalDevice.queueFamilyProperties)
                    val device = vu.createDevice(physicalDevice, graphicsQueueFamilyIndex)

                    /* VULKAN_HPP_KEY_START */

                    // create a UniqueCommandPool to allocate a CommandBuffer from
                    val commandPool = device.createCommandPoolUnique(CommandPoolCreateInfo(0, graphicsQueueFamilyIndex))

                    // allocate a CommandBuffer from the CommandPool
                    val commandBuffer = device.allocateCommandBufferUnique(CommandBufferAllocateInfo(commandPool))
                }
            }
    }
}