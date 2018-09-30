package vkk

import kool.stak
import org.lwjgl.PointerBuffer
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.memLengthUTF8
import org.lwjgl.system.MemoryUtil.memUTF8
import org.lwjgl.vulkan.VkDeviceQueueCreateInfo
import java.nio.ByteBuffer

val String.utf8: ByteBuffer
    get() = stak {
        val size = memLengthUTF8(this, true)
        val target = it.malloc(size)
        memUTF8(this, true, target)
        return target
    }
val Long.utf8: String get() = MemoryUtil.memUTF8(this)


operator fun PointerBuffer.set(index: Int, string: String): PointerBuffer = put(index, string.utf8)

operator fun VkDeviceQueueCreateInfo.Buffer.plusAssign(info: VkDeviceQueueCreateInfo) {
    put(info)
}
