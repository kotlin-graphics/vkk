package vkk

import glm_.BYTES
import kool.Adr
import org.lwjgl.PointerBuffer
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.*
import java.nio.ByteBuffer

fun String.toUTF8stack(): ByteBuffer = toUTF8(MemoryStack.stackGet())

fun String.toUTF8(stack: MemoryStack): ByteBuffer {
    val size = memLengthUTF8(this, true)
    return stack.malloc(size).also {
        memUTF8(this, true, it)
    }
}

fun String.toUTF8(): ByteBuffer {
    val size = memLengthUTF8(this, true)
    return MemoryUtil.memAlloc(size).also {
        memUTF8(this, true, it)
    }
}

val ByteBuffer.utf8: String
    get() = MemoryUtil.memUTF8(this)

val Adr.utf8: String
    get() = MemoryUtil.memUTF8(this)


operator fun PointerBuffer.set(index: Int, string: String): PointerBuffer = put(index, string.toUTF8stack())

//operator fun VkDeviceQueueCreateInfo.Buffer.plusAssign(info: VkDeviceQueueCreateInfo) {
//    put(info)
//}

inline fun <R> longAddressStack(long: Long, block: (Adr) -> R): R {
    val pLong = MemoryStack.stackGet().nmalloc(1, Long.BYTES)
    memPutLong(pLong, long)
    return block(pLong)
}

inline fun <R> intAddressStack(int: Int, block: (Adr) -> R): R {
    val pInt = MemoryStack.stackGet().nmalloc(1, Int.BYTES)
    memPutInt(pInt, int)
    return block(pInt)
}

//fun main(args: Array<String>) {
//
//    MemoryStackPlus.vk.
//}
//
//object MemoryStackPlus {
//
//    val stack = MemoryStack.stackGet()
//
//    val vk = StackVK()
//}