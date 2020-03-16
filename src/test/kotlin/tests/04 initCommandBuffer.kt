package tests

import io.kotlintest.specs.StringSpec
import main.isNotCI
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
//                val commandPool = device.createCommandPoolUnique(CommandPoolCreateInfo(0, graphicsQueueFamilyIndex))

                // allocate a CommandBuffer from the CommandPool
//                vk::UniqueCommandBuffer commandBuffer = std::move(device->allocateCommandBuffersUnique(vk::CommandBufferAllocateInfo(commandPool.get(), vk::CommandBufferLevel::ePrimary, 1)).front())
            }
    }
}