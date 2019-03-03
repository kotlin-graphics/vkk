package vkk.entities

import glm_.i
import kool.*
import org.lwjgl.system.MemoryStack.stackGet
import org.lwjgl.system.MemoryUtil.memCopy
import org.lwjgl.vulkan.VK10.VK_NULL_HANDLE
import vkk.vk
import java.nio.ByteBuffer
import java.nio.LongBuffer

inline class VkBuffer(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    val asHexString: String
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

    val asHexString: String
        get() = "0x%X".format(L)

    companion object {
        val NULL = VkDescriptorSet()
    }
}

inline class VkDescriptorSet_Buffer(val buffer: LongBuffer) {
    val rem get() = buffer.rem
    val adr get() = buffer.adr
    var pos
        get() = buffer.pos
        set(value) {
            buffer.pos = value
        }
    var lim
        get() = buffer.lim
        set(value) {
            buffer.lim = value
        }

    fun put(src: VkDescriptorSet_Buffer) {
        buffer.put(src.buffer)
    }

    fun flip(): VkDescriptorSet_Buffer {
        buffer.flip()
        return this
    }
}

fun VkDescriptorSet_Buffer(collection: Collection<VkDescriptorSet>) =
        VkDescriptorSet_Buffer(collection.size) { collection.elementAt(it) }

fun VkDescriptorSet_Buffer(size: Int, init: (Int) -> VkDescriptorSet) =
        VkDescriptorSet_Buffer(LongBuffer(size) { init(it).L })

fun vk.DescriptorSet_Buffer(collection: Collection<VkDescriptorSet>) =
        VkDescriptorSet_Buffer(stackGet().LongBuffer(collection.size) { collection.elementAt(it).L })

fun vk.DescriptorSet_Buffer(size: Int, init: (Int) -> VkDescriptorSet) =
        VkDescriptorSet_Buffer(stackGet().LongBuffer(size) { init(it).L })

inline class VkDescriptorSet_Array(val array: LongArray)

inline class VkDescriptorSetLayout(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    val asHexString: String
        get() = "0x%X".format(L)

    companion object {
        val NULL = VkDescriptorSetLayout()
    }
}

inline class VkDescriptorSetLayout_Buffer(val buffer: LongBuffer) {
    val rem get() = buffer.rem
    val adr get() = buffer.adr
}

fun VkDescriptorSetLayout_Buffer(collection: Collection<VkDescriptorSetLayout>) =
        VkDescriptorSetLayout_Buffer(collection.size) { collection.elementAt(it) }

fun VkDescriptorSetLayout_Buffer(size: Int, init: (Int) -> VkDescriptorSetLayout) =
        VkDescriptorSetLayoutBuffer(LongBuffer(size) { init(it).L })

fun vk.DescriptorSetLayout_Buffer(collection: Collection<VkDescriptorSetLayout>) =
        VkDescriptorSetLayout_Buffer(stackGet().LongBuffer(collection.size) { collection.elementAt(it).L })

fun vk.DescriptorSetLayout_Buffer(size: Int, init: (Int) -> VkDescriptorSetLayout) =
        VkDescriptorSetLayoutBuffer(stackGet().LongBuffer(size) { init(it).L })

inline class VkDeviceMemory(val L: Long = VK_NULL_HANDLE) {

    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    val asHexString: String
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
    }
}

fun Buffer(size: VkDeviceSize): ByteBuffer = kool.Buffer(size.L.i)

fun memCopy(src: Ptr, dst: Ptr, bytes: VkDeviceSize) = memCopy(src, dst, bytes.L)

operator fun Int.rem(b: VkDeviceSize) = VkDeviceSize(this % b.L)
operator fun Int.plus(b: VkDeviceSize) = VkDeviceSize(this + b.L)

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

inline class VkPipeline(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    companion object {
        val NULL = VkPipeline()
    }
}

inline class VkPipeline_Array(val array: LongArray)
inline class VkPipeline_Buffer(val buffer: LongBuffer)

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

inline class VkObjectTableNVX(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    companion object {
        val NULL = VkObjectTableNVX()
    }
}

inline class VkIndirectCommandsLayoutNVX(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    companion object {
        val NULL = VkIndirectCommandsLayoutNVX()
    }
}

inline class VkIndirectCommandsLayoutNVX_Buffer(val buffer: LongBuffer)

inline class VkAccelerationStructureNV(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    companion object {
        val NULL = VkAccelerationStructureNV()
    }
}

inline class VkAccelerationStructureNV_Buffer(val buffer: LongBuffer) {
    val rem get() = buffer.rem
    val adr get() = buffer.adr
}

inline class VkDescriptorUpdateTemplate(val L: Long = VK_NULL_HANDLE) {
    val isValid get() = L != VK_NULL_HANDLE
    val isInvalid get() = L == VK_NULL_HANDLE

    companion object {
        val NULL = VkDescriptorUpdateTemplate()
    }
}

inline class VkDescriptorUpdateTemplate_Buffer(val buffer: LongBuffer)