package tests

import glm_.has
import kool.indices
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.*
import vkk.VkQueueFlag
import vkk.vu

fun main() {

    val appName = "03_InitDevice"
    val engineName = "Vulkan.hpp"

    val instance = vu.createInstanceLwjgl(appName, engineName)
//            if(vk.DEBUG)
//                vk::UniqueDebugUtilsMessengerEXT debugUtilsMessenger = vk::su::createDebugUtilsMessenger(instance);

    val stack = MemoryStack.stackPush()
    val pCount = stack.callocInt(1)
    VK10.vkEnumeratePhysicalDevices(instance, pCount, null)

    var count = pCount[0]
    val pPointer = stack.mallocPointer(count)
    VK10.vkEnumeratePhysicalDevices(instance, pCount, pPointer)

    /* For tri demo we just grab the first physical device */
    val physicalDevice = VkPhysicalDevice(pPointer[0], instance)

    /* VULKAN_HPP_KEY_START */

    // get the QueueFamilyProperties of the first PhysicalDevice
    VK10.vkGetPhysicalDeviceQueueFamilyProperties(physicalDevice, pCount, null)
    count = pCount[0]
    val queueProps = VkQueueFamilyProperties.malloc(count)
    VK10.vkGetPhysicalDeviceQueueFamilyProperties(physicalDevice, pCount, queueProps)

    // get the first index into queueFamiliyProperties which supports graphics
    val graphicsQueueFamilyIndex = queueProps.indexOfFirst { it.queueFlags() has VkQueueFlag.GRAPHICS_BIT.i }
    assert(graphicsQueueFamilyIndex in queueProps.indices)

    // create a UniqueDevice
    val queue = VkDeviceQueueCreateInfo.callocStack(1, stack)
            .sType(VK10.VK_STRUCTURE_TYPE_DEVICE_QUEUE_CREATE_INFO)
            .queueFamilyIndex(graphicsQueueFamilyIndex)
            .pQueuePriorities(stack.floats(0f))

    val features = VkPhysicalDeviceFeatures.callocStack(stack)

    val deviceCreateInfo = VkDeviceCreateInfo.mallocStack(stack)
            .sType(VK10.VK_STRUCTURE_TYPE_DEVICE_CREATE_INFO)
            .pQueueCreateInfos(queue)

    VK10.vkCreateDevice(physicalDevice, deviceCreateInfo, null, pPointer)

    val device = VkDevice(pPointer[0], physicalDevice, deviceCreateInfo)

    // Note: No need to explicitly destroy the device, as the corresponding destroy function is
    // called by the destructor of the UniqueDevice on leaving this scope.
}