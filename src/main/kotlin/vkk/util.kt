package vkk

import glm_.BYTES
import glm_.L
import glm_.i
import graphics.scenery.spirvcrossj.*
import kool.*
import org.lwjgl.PointerBuffer
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryStack.stackGet
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.memLengthUTF8
import org.lwjgl.system.MemoryUtil.memUTF8
import org.lwjgl.vulkan.VK10
import org.lwjgl.vulkan.VkAttachmentReference
import vkk.entities.VkDeviceSize
import java.nio.Buffer
import java.nio.ByteBuffer
import java.nio.file.Files
import java.nio.file.Path


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



val VK_WHOLE_SIZE = VkDeviceSize(VK10.VK_WHOLE_SIZE)