package vkk.entities

import glm_.i
import kool.*
import org.lwjgl.system.MemoryStack.stackGet
import org.lwjgl.system.MemoryUtil.memCopy
import org.lwjgl.vulkan.VK10.VK_NULL_HANDLE
import vkk.vk
import java.nio.ByteBuffer
import java.nio.LongBuffer


inline class VkAccelerationStructureNV(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    companion object {
        val NULL = VkAccelerationStructureNV()
    }
}

inline class VkBuffer(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    val hexString: String
        get() = "0x%X".format(L)

    companion object {
        val NULL = VkBuffer()
    }
}

inline class VkBufferView(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    companion object {
        val NULL = VkBufferView()
    }
}

inline class VkCommandPool(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    companion object {
        val NULL = VkCommandPool()
    }
}

inline class VkDebugReportCallback(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    companion object {
        val NULL = VkDebugReportCallback()
    }
}

inline class VkDebugUtilsMessengerEXT(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    companion object {
        val NULL = VkDebugUtilsMessengerEXT()
    }
}

inline class VkDescriptorPool(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    companion object {
        val NULL = VkDescriptorPool()
    }
}

inline class VkDescriptorSet(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    val hexString: String
        get() = "0x%X".format(L)

    companion object {
        val NULL = VkDescriptorSet()
    }
}

inline class VkDescriptorSetLayout(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    val hexString: String
        get() = "0x%X".format(L)

    companion object {
        val NULL = VkDescriptorSetLayout()
    }
}

inline class VkDescriptorUpdateTemplate(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    companion object {
        val NULL = VkDescriptorUpdateTemplate()
    }
}

inline class VkDeviceAddress(val L: Long = VK_NULL_HANDLE) {

    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    val hexString: String
        get() = "0x%X".format(L)

    companion object {
        val NULL = VkDeviceAddress()
    }
}

inline class VkDeviceMemory(val L: Long = VK_NULL_HANDLE) {

    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    val hexString: String
        get() = "0x%X".format(L)

    companion object {
        val NULL = VkDeviceMemory()
    }
}

inline class VkDeviceSize(val L: Long = VK_NULL_HANDLE) {

    val i: Int get() = L.i

    operator fun plus(size: VkDeviceSize) = VkDeviceSize(L + size.L)
    operator fun plus(size: Int) = VkDeviceSize(L + size)
    operator fun rem(b: VkDeviceSize) = VkDeviceSize(L % b.L)
    operator fun minus(b: VkDeviceSize) = VkDeviceSize(L - b.L)
    operator fun times(b: Int) = VkDeviceSize(L * b)

    val isEmpty get() = L == VK_NULL_HANDLE
    val isNotEmpty get() = L != VK_NULL_HANDLE

    companion object {
        val NULL = VkDeviceSize()
        val WHOLE_SIZE = VkDeviceSize(0L)
    }
}

operator fun Int.rem(b: VkDeviceSize) = VkDeviceSize(this % b.L)
operator fun Int.plus(b: VkDeviceSize) = VkDeviceSize(this + b.L)

inline class VkDisplayKHR(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    companion object {
        val NULL = VkDisplayKHR()
    }
}

inline class VkDisplayModeKHR(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    companion object {
        val NULL = VkDisplayModeKHR()
    }
}

inline class VkEvent(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    companion object {
        val NULL = VkEvent()
    }
}

inline class VkFence(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    companion object {
        val NULL = VkFence()
    }
}

inline class VkFramebuffer(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    companion object {
        val NULL = VkFramebuffer()
    }
}

inline class VkImage(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    companion object {
        val NULL = VkImage()
    }
}

inline class VkImageView(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    companion object {
        val NULL = VkImageView()
    }
}

inline class VkIndirectCommandsLayoutNVX(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    companion object {
        val NULL = VkIndirectCommandsLayoutNVX()
    }
}

inline class VkObjectTableNVX(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    companion object {
        val NULL = VkObjectTableNVX()
    }
}

inline class VkPipeline(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    companion object {
        val NULL = VkPipeline()
    }
}

inline class VkPipelineCache(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    companion object {
        val NULL = VkPipelineCache()
    }
}

inline class VkPipelineLayout(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    companion object {
        val NULL = VkPipelineLayout()
    }
}

inline class VkQueryPool(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    companion object {
        val NULL = VkQueryPool()
    }
}

inline class VkRenderPass(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    companion object {
        val NULL = VkRenderPass()
    }
}

inline class VkSampler(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    companion object {
        val NULL = VkSampler()
    }
}

inline class VkSamplerYcbcrConversion(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    companion object {
        val NULL = VkSamplerYcbcrConversion()
    }
}

inline class VkSemaphore(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    companion object {
        val NULL = VkSemaphore()
    }
}

inline class VkShaderModule(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    companion object {
        val NULL = VkShaderModule()
    }
}

inline class VkSurfaceKHR(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    companion object {
        val NULL = VkSurfaceKHR()
    }
}

inline class VkSwapchainKHR(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    companion object {
        val NULL = VkSwapchainKHR()
    }
}

inline class VkValidationCacheEXT(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    companion object {
        val NULL = VkValidationCacheEXT()
    }
}