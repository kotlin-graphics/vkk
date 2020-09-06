package tests

import glm_.mat4x4.Mat4
import io.kotlintest.specs.StringSpec
import main.isNotCI
import vkk.VkBufferUsage
import vkk.entities.VkDeviceSize
import vkk.ptrOf
import vkk.unique.`try`
import vkk.unique.vu
import vkk.vk10.structs.Extent2D

class `09 initDescriptorSet` : StringSpec() {

    val appName = "09_InitDescriptorSet"

    init {
        if (isNotCI)
            appName {
                `try` {

                    val instance = vu.createInstance(appName, engineName)
//                    if(DEBUG)
//                    vk::UniqueDebugUtilsMessengerEXT debugUtilsMessenger = vk::su::createDebugUtilsMessenger(instance)

                    val physicalDevice = instance.physicalDevices[0]

                    val device = vu.createDevice(physicalDevice, vu.findGraphicsQueueFamilyIndex(physicalDevice.queueFamilyProperties))

                    val a = Prova()

                    val uniformBufferData = vu.newBufferData(physicalDevice, device, VkDeviceSize(Mat4.size), VkBufferUsage.UNIFORM_BUFFER_BIT.i)
                    val mvp = vu.createModelViewProjectionClipMatrix(Extent2D(0, 0))
                    vu.copyToDevice(device, uniformBufferData.deviceMemory, stack.ptrOf(mvp), Mat4.size)

                    val descriptorSetLayout = vu.createDescriptorSetLayout(device, { {vk::DescriptorType::eUniformBuffer, 1, vk::ShaderStageFlagBits::eVertex} })
//
//                    /* VULKAN_HPP_KEY_START */
//
//                    // create a descriptor pool
//                    vk::DescriptorPoolSize poolSize(vk::DescriptorType::eUniformBuffer, 1)
//                    vk::UniqueDescriptorPool descriptorPool = device->createDescriptorPoolUnique(vk::DescriptorPoolCreateInfo(vk::DescriptorPoolCreateFlagBits::eFreeDescriptorSet, 1, 1, &poolSize))
//
//                    // allocate a descriptor set
//                    vk::UniqueDescriptorSet descriptorSet = std::move(device->allocateDescriptorSetsUnique(vk::DescriptorSetAllocateInfo(*descriptorPool, 1, &*descriptorSetLayout)).front())
//
//                    vk::DescriptorBufferInfo descriptorBufferInfo(uniformBufferData.buffer.get(), 0, sizeof(glm::mat4x4))
//                    device->updateDescriptorSets(vk::WriteDescriptorSet(descriptorSet.get(), 0, 0, 1, vk::DescriptorType::eUniformBuffer, nullptr, &descriptorBufferInfo), {})

                    /* VULKAN_HPP_KEY_END */
                }
            }
    }
}