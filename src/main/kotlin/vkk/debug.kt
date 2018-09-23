package vkk

import glm_.L
import glm_.i
import glm_.set
import org.lwjgl.PointerBuffer
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.vulkan.*
import unsigned.Uint
import unsigned.Ulong
import java.nio.ByteBuffer
import java.nio.LongBuffer
import kotlin.reflect.KMutableProperty0

val String.utf8: ByteBuffer
    get() {
        val size = memLengthUTF8(this, true)
        val target = memByteBuffer(ptr.advance(size), size)
        memUTF8(this, true, target)
        return target
    }
val Long.utf8: String get() = MemoryUtil.memUTF8(this)


inline operator fun PointerBuffer.set(index: Int, string: String) {
    put(index, string.utf8)
}

operator fun VkDeviceQueueCreateInfo.Buffer.plusAssign(info: VkDeviceQueueCreateInfo) {
    put(info)
}


fun vkCreateSemaphore(device: VkDevice, createInfo: VkSemaphoreCreateInfo, allocator: VkAllocationCallbacks?,
                      semaphore: KMutableProperty0<Long>): VkResult {
    val pSemaphore = memAllocLong(1)
    return VkResult of VK10.vkCreateSemaphore(device, createInfo, allocator, pSemaphore).also {
        semaphore.set(pSemaphore[0])
    }
}