package vkk.entities

import glm_.i
import kool.*
import kool.lib.isEmpty
import kool.lib.isNotEmpty
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.system.MemoryUtil.memCopy
import vkk.VkDynamicState
import java.nio.ByteBuffer
import java.nio.IntBuffer
import java.nio.LongBuffer

inline class VkBuffer(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL

    val asHexString: String
        get() = "0x%X".format(L)
}

inline class VkBufferView(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkCommandPool(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkDebugReportCallback(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkDescriptorPool(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkDescriptorSet(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL

    val asHexString: String
        get() = "0x%X".format(L)
}

inline class VkDescriptorSetLayout(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL

    val asHexString: String
        get() = "0x%X".format(L)
}

inline class VkDeviceMemory(val L: Long) {

    val isValid get() = L != NULL
    val isInvalid get() = L == NULL

    val asHexString: String
        get() = "0x%X".format(L)
}

inline class VkDeviceSize(val L: Long) {

    val i: Int get() = L.i

    operator fun plus(size: VkDeviceSize) = VkDeviceSize(L + size.L)
    operator fun plus(size: Int) = VkDeviceSize(L + size)
    operator fun rem(b: VkDeviceSize) = VkDeviceSize(L % b.L)
    operator fun minus(b: VkDeviceSize) = VkDeviceSize(L - b.L)
    operator fun times(b: Int) = VkDeviceSize(L * b)

    val isEmpty get() = L == NULL
    val isNotEmpty get() = L != NULL
}

fun Buffer(size: VkDeviceSize): ByteBuffer = kool.Buffer(size.L.i)

fun memCopy(src: Ptr, dst: Ptr, bytes: VkDeviceSize) = memCopy(src, dst, bytes.L)

operator fun Int.rem(b: VkDeviceSize) = VkDeviceSize(this % b.L)
operator fun Int.plus(b: VkDeviceSize) = VkDeviceSize(this + b.L)

inline class VkEvent(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkFence(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkFramebuffer(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkImage(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkImageView(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkPipeline(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkPipelineCache(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkPipelineLayout(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkQueryPool(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkRenderPass(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkSampler(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkSemaphore(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkShaderModule(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkSurfaceKHR(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkSwapchainKHR(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}


inline class VkDisplayKHR(val L: Long)
inline class VkDisplayModeKHR (val L: Long)
inline class VkObjectTableNVX  (val L: Long)
inline class VkIndirectCommandsLayoutNVX   (val L: Long)
