package vkk.unique

import vkk.VkStackInterface
import vkk.entities.*
import vkk.extensions.SwapchainCreateInfoKHR
import vkk.extensions.destroy
import vkk.identifiers.*
import vkk.vk
import vkk.vk10.structs.*
import java.util.*

interface Unique : VkStackInterface {
    val disposes: Deque<() -> Unit>
}

interface UniqueVk : Unique {

    fun vk.createInstanceUnique(createInfo: InstanceCreateInfo): UniqueInstance = stack.run {
        vk.createInstance(createInfo).also { disposes += { it.destroy(); println("instance destroyed") } }
    }
}

interface UniquePhysicalDeviceI : Unique {

    // --- [ vkCreateDevice ] ---
    infix fun PhysicalDevice.createDeviceUnique(createInfo: DeviceCreateInfo): UniqueDevice = stack.run {
        createDevice(createInfo).also { disposes += { it.destroy(); println("device destroyed") } }
    }
}

interface UniqueDeviceI : Unique {

    // --- [ vkCreateCommandPool ] ---
    infix fun Device.createCommandPoolUnique(createInfo: CommandPoolCreateInfo): VkUniqueCommandPool =
            stack.run { createCommandPool(createInfo).also { disposes += { destroy(it); println("commandPool destroyed") } } }

    // --- [ vkAllocateCommandBuffers ] ---

    infix fun Device.allocateCommandBufferUnique(allocateInfo: CommandBufferAllocateInfo): UniqueCommandBuffer =
            stack.run { allocateCommandBuffer(allocateInfo).also { disposes += { freeCommandBuffers(allocateInfo.commandPool, it); println("commandBuffer freed") } } }

    infix fun Device.allocateCommandBuffersUnique(allocateInfo: CommandBufferAllocateInfo): Array<UniqueCommandBuffer> =
            stack.run { allocateCommandBuffers(allocateInfo).also { disposes += { freeCommandBuffers(allocateInfo.commandPool, it); println("commandBuffers freed") } } }

    // --- [ vkAllocateMemory ] ---
    infix fun Device.allocateMemoryUnique(allocateInfo: MemoryAllocateInfo): VkUniqueDeviceMemory =
            stack.run { allocateMemory(allocateInfo).also { disposes += { freeMemory(it); println("memory freed") } } }

    // --- [ vkCreateBuffer ] ---
    infix fun Device.createBufferUnique(createInfo: BufferCreateInfo): VkUniqueBuffer =
            stack.run { createBuffer(createInfo).also { disposes += { destroy(it); println("buffer destroyed") } } }

    // --- [ vkCreateDescriptorSetLayout ] ---
    infix fun Device.createDescriptorSetLayoutUnique(createInfo: DescriptorSetLayoutCreateInfo): VkUniqueDescriptorSetLayout =
            stack.run { createDescriptorSetLayout(createInfo).also { disposes += { destroy(it); println("descriptorSetLayour destroyed") } } }

    // --- [ vkCreatePipelineLayout ] ---
    infix fun Device.createPipelineLayoutUnique(createInfo: PipelineLayoutCreateInfo): VkUniquePipelineLayout =
            stack.run { createPipelineLayout(createInfo).also { disposes += { destroy(it); println("pipelineLayout destroyed") } } }

    // --- [ vkCreateSwapchainKHR ] ---
    infix fun Device.createSwapchainKHRUnique(createInfo: SwapchainCreateInfoKHR): VkUniqueSwapchainKHR =
            stack.run { createSwapchainKHR(createInfo).also { disposes += { destroy(it); println("swapchain destroyed") } } }

    // --- [ vkCreateImage ] ---
    infix fun Device.createImageUnique(createInfo: ImageCreateInfo): VkUniqueImage =
            stack.run { createImage(createInfo).also { disposes += { destroy(it); println("image destroyed") } } }

    // --- [ vkCreateImageView ] ---

    infix fun Device.createImageViewUnique(createInfo: ImageViewCreateInfo): VkUniqueImageView =
            stack.run { createImageView(createInfo).also { disposes += { destroy(it); println("imageView destroyed") } } }

    // [JVM]
    fun Device.createImageViewArrayUnique(createInfo: ImageViewCreateInfo, images: VkImage_Array): VkUniqueImageView_Array =
            stack.run { createImageViewArray(createInfo, images).also { disposes += { it.forEach { image -> destroy(image) }; println("imageViewArray destroyed") } } }
}