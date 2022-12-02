@file:OptIn(ExperimentalUnsignedTypes::class)

package vkk

import glm_.L
import kool.*
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil
import vkk.api.VkDeviceAddress
import vkk.identifiers.CommandBuffer
import vkk.identifiers.Device
import java.io.File
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

@Suppress("NOTHING_TO_INLINE")
inline fun defaultCheck(result: VkResult) = result.check()

infix fun Buffer.copyTo(ptr: Ptr) = MemoryUtil.memCopy(adr, ptr, remByte.L)
infix fun Buffer.copyFrom(ptr: Ptr) = MemoryUtil.memCopy(ptr, adr, remByte.L)


infix fun Array<VkDynamicState>.write(stack: MemoryStack): Adr {
    val pInts = stack.mInt(size)
    for (i in indices)
        pInts[i] = get(i).i
    return pInts.adr
}

infix fun Array<CommandBuffer>.write(stack: MemoryStack): Ptr = stack.PointerAdr(size) { this[it].adr }

inline fun <R> MemoryStack.framed(block: () -> R): R {
    val ptr = pointer
    return block().also {
        pointer = ptr
    }
}

interface VkStructure {
    infix fun write(stack: MemoryStack): Adr
}

interface StructureChain {
    var next: VkStructure?
}

interface VkCloseableDevice : VkCloseable {
    fun close(device: Device) = Unit
}

interface VkCloseable {
    fun close() = Unit
}

class ResourceHolder : VkCloseable {
    val resources = arrayListOf<VkCloseable>()
    lateinit var device: Device

    fun <T : VkCloseable> T.unique(): T {
        resources.add(this)
        if (this is Device) device = this
        return this
    }

    override fun close() = resources.asReversed().forEach {
        if (it is VkCloseableDevice)
            it.close(device)
        else
            it.close()
    }

    fun Array<CommandBuffer>.unique() {
        //        device.fre
    }
}

//fun copy(from: Path, to: Path) {
//
//    `try` {
//
////        val input = Files.newInputStream(from).unique()
////
////        val output = Files.newOutputStream(to).unique()
////
////        input.copyTo(output)
//    }
//}
inline fun `=`(type: Ptr<Display>) = unsafe.set(0u, type.adr)
inline operator fun Ptr<vkk.api.VkStructureType>.set(index: Int, type: vkk.api.VkStructureType) = toPtr<Int>().set(index, type.i)
inline operator fun Ptr<*>.set(index: Int, ptr: Ptr<*>): Unit = unsafe.set(adr + (index * ULong.BYTES).toULong(), ptr.adr)

inline infix fun Ptr<UByte>.set(int: Int) = toPtr<Int>().set(0, int)
inline operator fun Ptr<UByte>.plus(offset: Int): Ptr<UByte> = plus(offset.toULong())
inline operator fun Ptr<UByte>.plus(offset: ULong): Ptr<UByte> = Ptr(address + offset)
infix fun UIntArray.into(stack: MemStack): Ptr<UByte> {
    val ptr = stack.malloc(size * UInt.BYTES).toPtr<UInt>()
    for (i in indices)
        ptr[i] = this[i]
    return ptr.toPtr()
}

infix fun ULongArray.into(stack: MemStack): Ptr<UByte> {
    val ptr = stack.malloc(size * ULong.BYTES).toPtr<ULong>()
    for (i in indices)
        ptr[i] = this[i]
    return ptr.toPtr()
}

infix fun FloatArray.into(stack: MemStack): Ptr<UByte> {
    val ptr = stack.malloc(size * Float.BYTES).toPtr<Float>()
    for (i in indices)
        ptr[i] = this[i]
    return ptr.toPtr()
}

infix fun Collection<String>.utf8Into(stack: MemStack): Ptr<UByte> = stack.malloc(size * 8) { elementAt(it).utf8Into(stack) }