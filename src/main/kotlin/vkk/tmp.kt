package vkk

import glm_.i
import kool.Ptr
import kool.Stack
import org.lwjgl.system.MemoryUtil
import org.lwjgl.vulkan.VkCommandBuffer
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