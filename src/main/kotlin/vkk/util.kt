package vkk

import glm_.L
import identifiers.CommandBuffer
import kool.*
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil
import org.lwjgl.vulkan.VK10
import vkk.entities.VkDeviceSize
import java.nio.Buffer


//fun pointerBufferOf(vararg strings: String): PointerBuffer {
//    val buf = pointerBufferBig(strings.size)
//    for (i in strings.indices)
//        buf[i] = strings[i]
//    return buf
//}
//
//operator fun PointerBuffer.set(index: Int, string: String) {
//    put(index, string.memUTF16)
//}

//operator fun PointerBuffer.plusAssign(string: String) {
//    put(string.stackUTF16)
//}

//operator fun <T> PointerBuffer.plusAssign(elements: Iterable<T>) {
//    for (item in elements)
//        if (item is String)
//            put(item.memUTF16)
//        else
//            throw Error()
//}
//
//fun PointerBuffer.isNotEmpty() = position() > 0


infix fun Buffer.copyTo(ptr: Ptr) = MemoryUtil.memCopy(adr, ptr, remSize.L)
infix fun Buffer.copyFrom(ptr: Ptr) = MemoryUtil.memCopy(ptr, adr, remSize.L)


fun Array<VkDynamicState>.write(stack: MemoryStack): Adr = stack.IntPtr(size) { get(it).i }.adr
infix fun Array<CommandBuffer>.write(stack: MemoryStack): Ptr = stack.PointerAdr(size) { this[it].adr }

inline fun <R> MemoryStack.framed(block: () -> R): R {
    val ptr = pointer
    return block().also {
        pointer = ptr
    }
}