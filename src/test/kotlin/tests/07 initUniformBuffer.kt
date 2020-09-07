package tests

import glm_.L
import glm_.func.rad
import glm_.glm
import glm_.mat4x4.Mat4
import glm_.vec3.Vec3
import io.kotest.core.spec.style.StringSpec
import kool.adr
import main.isNotCI
import org.lwjgl.system.MemoryUtil
import vkk.VkBufferUsage
import vkk.VkMemoryProperty
import vkk.entities.VkDeviceSize
import vkk.unique.`try`
import vkk.unique.vu
import vkk.vk10.structs.BufferCreateInfo
import vkk.vk10.structs.MemoryAllocateInfo

class `07 initUniformBuffer` : StringSpec() {

    val appName = "07_InitUniformBuffer"

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

                    val model = Mat4(1f)
                    val view = glm.lookAt(Vec3(-5f, 3f, -10f), Vec3(), Vec3(0f, -1f, 0f))
                    val projection = glm.perspective(45f.rad, 1f, 0.1f, 100f)
                    val clip = Mat4(
                            1f, 0f, 0f, 0f,
                            0f, -1f, 0f, 0f,
                            0f, 0f, 0.5f, 0f,
                            0f, 0f, 0.5f, 1f)   // vulkan clip space has inverted y and half z !
                    val mvpc = clip * projection * view * model

                    val uniformDataBuffer = device.createBufferUnique(BufferCreateInfo(0, VkDeviceSize(Mat4.size), VkBufferUsage.UNIFORM_BUFFER_BIT.i))

                    val memoryRequirements = device getBufferMemoryRequirements uniformDataBuffer
                    val typeIndex = vu.findMemoryType(physicalDevice.memoryProperties, memoryRequirements.memoryTypeBits, VkMemoryProperty.HOST_VISIBLE_BIT or VkMemoryProperty.HOST_COHERENT_BIT)
                    val uniformDataMemory = device.allocateMemoryUnique(MemoryAllocateInfo(memoryRequirements.size, typeIndex))

                    device.mappedMemory(uniformDataMemory, VkDeviceSize(0), memoryRequirements.size) { pData ->
                        MemoryUtil.memCopy(mvpc.toBuffer(this.stack).adr, pData, Mat4.size.L)
                    }

                    device.bindBufferMemory(uniformDataBuffer, uniformDataMemory)

                    // Note: No need to explicitly destroy the memory or the buffer, as the corresponding destroy function is
                    // called by the destructor of the UniqueMemory or UniqueBuffer, respectively, on leaving this scope.

                    /* VULKAN_HPP_KEY_END */
                }
            }
    }
}