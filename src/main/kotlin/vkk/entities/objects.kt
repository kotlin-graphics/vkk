package vkk.entities

import glm_.L
import glm_.i
import kool.remSize
import org.lwjgl.vulkan.VK10.VK_NULL_HANDLE
import vkk.VkCloseableDevice
import vkk.identifiers.Device
import java.nio.Buffer


inline class VkAccelerationStructureNV(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    companion object {
        val NULL = VkAccelerationStructureNV()
    }
}

typealias VkUniqueBuffer = VkBuffer

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

//fun VkUniqueCommandPool(long: Long = VK_NULL_HANDLE): VkUniqueCommandPool = VkUniqueCommandPool(L)
//
//inline class VkUniqueCommandPool(val L: Long = VK_NULL_HANDLE)

typealias VkUniqueCommandPool = VkCommandPool

inline class VkCommandPool(val L: Long = VK_NULL_HANDLE) : VkCloseableDevice {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE
    override fun close(device: Device) = device destroy this

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

inline class VkUniqueDebugUtilsMessengerEXT(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    companion object {
        val NULL = VkUniqueDebugUtilsMessengerEXT()
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

typealias VkUniqueDescriptorSetLayout = VkDescriptorSetLayout

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

typealias VkUniqueDeviceMemory = VkDeviceMemory

inline class VkDeviceMemory(val L: Long = VK_NULL_HANDLE) {

    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    val hexString: String
        get() = "0x%X".format(L)

    companion object {
        val NULL = VkDeviceMemory()
    }
}

fun VkDeviceSize(buffer: Buffer): VkDeviceSize = VkDeviceSize(buffer.remSize)
fun VkDeviceSize(int: Int): VkDeviceSize = VkDeviceSize(int.L)
inline class VkDeviceSize(val L: Long = VK_NULL_HANDLE) {

    val i: Int get() = L.i

    operator fun plus(size: VkDeviceSize) = VkDeviceSize(L + size.L)
    operator fun plus(int: Int) = VkDeviceSize(L + int)
    operator fun minus(b: VkDeviceSize) = VkDeviceSize(L - b.L)
    operator fun minus(int: Int) = VkDeviceSize(L - int)
    operator fun rem(size: VkDeviceSize) = VkDeviceSize(L % size.L)
    operator fun rem(int: Int) = VkDeviceSize(L % int.L)
    operator fun times(size: VkDeviceSize) = VkDeviceSize(L * size.L)
    operator fun times(int: Int) = VkDeviceSize(L * int)
    operator fun div(size: VkDeviceSize) = VkDeviceSize(L / size.L)
    operator fun div(int: Int) = VkDeviceSize(L / int)

    val isEmpty get() = L == VK_NULL_HANDLE
    val isNotEmpty get() = L != VK_NULL_HANDLE

    operator fun compareTo(other: VkDeviceSize): Int = L.compareTo(other.L)
    operator fun compareTo(other: Int): Int = L.compareTo(other.L)
    operator fun compareTo(other: Long): Int = L.compareTo(other)

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

typealias VkUniqueImage = VkImage

inline class VkImage(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    companion object {
        val NULL = VkImage()
    }
}

typealias VkUniqueImageView = VkImageView

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

typealias VkUniquePipelineLayout = VkPipelineLayout

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

typealias VkUniqueSurfaceKHR = VkSurfaceKHR

inline class VkSurfaceKHR(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    companion object {
        val NULL = VkSurfaceKHR()
    }
}

typealias VkUniqueSwapchainKHR = VkSwapchainKHR

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