package tests

import io.kotlintest.specs.StringSpec
import main.isNotCI
import vkk.VkCommandBufferLevel
import vkk._10.structs.CommandBufferAllocateInfo
import vkk._10.structs.CommandPoolCreateInfo
import vkk.unique.`try`
import vkk.vu

class `04 initCommandBuffer` : StringSpec() {

    val appName = "04_InitCommandBuffer"
    val engineName = "Vulkan.hpp"

    init {
        if (isNotCI)
            "04 initCommandBuffer" {
                `try` {
//                    val instance = vu.createInstance(appName, engineName).unique()
////                  if(DEBUG)
////                      vk::UniqueDebugUtilsMessengerEXT debugUtilsMessenger = vk::su::createDebugUtilsMessenger(instance);
//
//                    val physicalDevice = instance.enumeratePhysicalDevices[0]
//
//                    val graphicsQueueFamilyIndex = vu.findGraphicsQueueFamilyIndex(physicalDevice.queueFamilyProperties)
//                    val device = vu.createDevice(physicalDevice, graphicsQueueFamilyIndex).unique()
//
//                    /* VULKAN_HPP_KEY_START */
//
//                    // create a UniqueCommandPool to allocate a CommandBuffer from
//                    val commandPool = device.createCommandPool(CommandPoolCreateInfo(0, graphicsQueueFamilyIndex)).unique()
//
//                    // allocate a CommandBuffer from the CommandPool
//                    val commandBuffer = device.allocateCommandBuffers(CommandBufferAllocateInfo(commandPool, VkCommandBufferLevel.PRIMARY, 1))[0]//.unique()
                }
            }
    }
}