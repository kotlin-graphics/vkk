package tests

import io.kotlintest.specs.StringSpec
import main.isNotCI
import vkk.VkCommandBufferLevel
import vkk._10.structs.CommandBufferAllocateInfo
import vkk._10.structs.CommandPoolCreateInfo
import vkk.vu

class `04 initCommandBuffer` : StringSpec() {

    val appName = "04_InitCommandBuffer"
    val engineName = "Vulkan.hpp"

    init {
        if (isNotCI)
            "04 initCommandBuffer" {

                val instance = vu.createInstance(appName, engineName)
//                if(DEBUG)
//                vk::UniqueDebugUtilsMessengerEXT debugUtilsMessenger = vk::su::createDebugUtilsMessenger(instance);

                val physicalDevice = instance.enumeratePhysicalDevices[0]

                val graphicsQueueFamilyIndex = vu.findGraphicsQueueFamilyIndex(physicalDevice.queueFamilyProperties)
                val device = vu.createDevice(physicalDevice, graphicsQueueFamilyIndex)

                /* VULKAN_HPP_KEY_START */

                // create a UniqueCommandPool to allocate a CommandBuffer from
                val commandPool = device.createCommandPoolUnique(CommandPoolCreateInfo(0, graphicsQueueFamilyIndex))

                // allocate a CommandBuffer from the CommandPool
                val commandBuffer = device.allocateCommandBuffersUnique(CommandBufferAllocateInfo(commandPool, VkCommandBufferLevel.PRIMARY, 1))[0]

//                for (i in 1..10000) {
//                    val a = IntArray(10000)
//                    try {
//                        Thread.sleep(1)
//                    } catch (e: InterruptedException) {
//                    }
//                }
            }
    }
}