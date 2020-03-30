package vkk

import glm_.i
import glm_.s
import glm_.vec4.Vec4
import kool.*
import org.lwjgl.PointerBuffer
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil
import org.lwjgl.vulkan.VkCommandBuffer
import unsigned.toULong
import vkk.entities.VkDeviceSize
import java.nio.ByteBuffer

fun main() {
    test<Int>()
    test<VkCommandBuffer>()
    test<Array<VkCommandBuffer>>()
    test<ArrayList<VkCommandBuffer>>()
    test<Float>()
}

inline fun <reified T : Any> test() {
    println(when (T::class) {
        Int::class -> "Int"
        Float::class -> "Float"
        VkCommandBuffer::class -> "VkCommandBuffer"
        Array<VkCommandBuffer>::class -> "Array<VkCommandBuffer>"
        ArrayList::class -> "ArrayList<VkCommandBuffer>"
        else -> "else"
    })
}

fun Buffer(size: VkDeviceSize): ByteBuffer = kool.Buffer(size.L.i)

fun memCopy(src: Ptr, dst: Ptr, bytes: VkDeviceSize) = MemoryUtil.memCopy(src, dst, bytes.L)


inline class HINSTANCE(val L: Long)
inline class HWND(val L: Long)
inline class HANDLE(val L: Long)
inline class DWORD(val i: Int)
inline class Display(val L: Long)
inline class Window(val L: Long)
inline class VisualID(val L: Long)
inline class WLDisplay(val L: Long)
inline class WLSurface(val L: Long)
inline class RROutput(val L: Long)
inline class HMONITOR(val L: Long)


typealias NanoSecond = Long

typealias stak = Stack

fun MemoryStack.resize(src: PointerBuffer?, newSize: Int): PointerBuffer = when {
    src == null -> this.PointerBuffer(newSize)
    newSize > src.cap -> this.PointerBuffer(newSize).also { for (i in src.indices) it[i] = src[i] }
    else -> src.apply { lim = newSize }
}

fun encodeUTF16(text: CharSequence, nullTerminated: Boolean, target: Adr): Int {
    var len = text.length
    for (i in 0 until len)
        UNSAFE.putShort(target + i.toULong() * 2, text[i].s)
    if (nullTerminated)
        UNSAFE.putShort(target + (len++).toULong() * 2, 0)
    return 2 * len
}

fun Vec4.toAdr(stack: VkStack): FloatPtr {
    val floats = stack.mFloat(Vec4.length)
    floats[0] = x
    floats[1] = y
    floats[2] = z
    floats[3] = w
    return floats
}

