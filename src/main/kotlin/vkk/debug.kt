package vkk

import appBuffer.advance
import appBuffer.appBuffer
import appBuffer.appBuffer.ptr
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


inline fun <R> getLong(block: (LongBuffer) -> R): Long {
    val pLong = appBuffer.longBuffer
    block(pLong)
    return pLong[0]
}

inline fun <R> withLong(block: (LongBuffer) -> R): R = block(appBuffer.longBuffer)

inline fun <R> getPointer(block: (PointerBuffer) -> R): Long {
    val pointer = appBuffer.pointerBuffer
    block(pointer)
    return pointer[0]
}

inline fun <R> withPointer(block: (PointerBuffer) -> R): R = block(appBuffer.pointerBuffer)


fun ArrayList<VkDeviceQueueCreateInfo>.toBuffer(): VkDeviceQueueCreateInfo.Buffer {
    val buffer = VkDeviceQueueCreateInfo.calloc(size)
    for (i in indices)
        buffer += get(i)
    return buffer.flip()
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

fun Long.toLongBuffer(): LongBuffer = MemoryUtil.memAllocLong(1).also { it[0] = this }


fun VkCommandBuffer.toPointerBuffer(): PointerBuffer {
    val p = MemoryUtil.memAllocPointer(1)
    p[0] = address()
    return p
}

val UINT32_MAX = Uint.MAX_VALUE.i
val UINT64_MAX = Ulong.MAX_VALUE.L