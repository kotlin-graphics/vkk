package tests

import io.kotest.core.spec.style.StringSpec
import main.isNotCI
import vkk.VkDescriptorType
import vkk.VkShaderStage
import vkk.unique.`try`
import vkk.unique.vu
import vkk.vk10.structs.DescriptorSetLayoutBinding
import vkk.vk10.structs.DescriptorSetLayoutCreateInfo
import vkk.vk10.structs.PipelineLayoutCreateInfo

class `08 initPipelineLayout` : StringSpec() {

    val appName = "08_InitPipelineLayout"

    init {
        if (isNotCI)
            appName {
                `try` {

                    val instance = vu.createInstance(appName, engineName)
//                    if(DEBUG)
//                    vk::UniqueDebugUtilsMessengerEXT debugUtilsMessenger = vk::su::createDebugUtilsMessenger(instance)

                    val physicalDevice = instance.physicalDevices[0]

                    val device = vu.createDevice(physicalDevice, vu.findGraphicsQueueFamilyIndex(physicalDevice.queueFamilyProperties))

                    /* VULKAN_HPP_KEY_START */

                    // create a DescriptorSetLayout
                    val descriptorSetLayoutBinding = DescriptorSetLayoutBinding(0, VkDescriptorType.UNIFORM_BUFFER, 1, VkShaderStage.VERTEX_BIT.i)
                    val descriptorSetLayout = device.createDescriptorSetLayoutUnique(DescriptorSetLayoutCreateInfo(0, descriptorSetLayoutBinding))

                    // create a PipelineLayout using that DescriptorSetLayout
                    val pipelineLayout = device.createPipelineLayoutUnique(PipelineLayoutCreateInfo(descriptorSetLayout))

                    // Note: No need to explicitly destroy the layouts, as the corresponding destroy function is
                    // called by the destructor of the UniqueDescriptorSetLayout or UniquePipelineLayout, respectively, on leaving this scope.

                    /* VULKAN_HPP_KEY_END */
                }
            }

    }
}