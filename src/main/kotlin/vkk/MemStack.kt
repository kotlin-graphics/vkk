@file:OptIn(ExperimentalContracts::class)

package vkk

import kool.*
import kool.Adr
import org.lwjgl.system.MemoryStack
import vkk.api.VkInstanceCreateInfo
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

@JvmInline
value class MemStack(val lwjgl: MemoryStack) {

    inline fun malloc(size: Int): Ptr<UByte> = malloc(size.toUInt())
    inline fun malloc(size: Int, init: (Int) -> ULong): Ptr<UByte> {
        val ptr = malloc(size.toUInt())
        for (i in 0 until size)
            ptr[i] = init(i).toPtr<UByte>()
        return ptr
    }

    //    fun malloc(size: UInt): Adr<ULong> = malloc(8u, size)
    inline fun malloc(size: UInt): Ptr<UByte> = malloc(8u, size)

    //    inline fun <T> malloc(size: UInt): Ptr<T> = TODO()
    inline fun malloc(alignment: UInt, size: UInt): Ptr<UByte> = lwjgl.nmalloc(alignment.toInt(), size.toInt()).toPtr()

    inline fun calloc(alignment: UInt, size: UInt): Ptr<UByte> = calloc(alignment, 1u, size)
    inline fun calloc(alignment: UInt, num: UInt, size: UInt): Ptr<UByte> = lwjgl.ncalloc(alignment.toInt(), num.toInt(), size.toInt()).toPtr()
    inline fun calloc(alignment: UInt, num: Int, size: UInt): Ptr<UByte> = lwjgl.ncalloc(alignment.toInt(), num, size.toInt()).toPtr()

    inline operator fun <R> invoke(block: MemStack.() -> R): R {
        val ptr = lwjgl.pointer
        return this.block().also {
            lwjgl.pointer = ptr
        }
    }

    inline fun <R> framed(block: MemStack.() -> R): R {
        contract { callsInPlace(block, kotlin.contracts.InvocationKind.EXACTLY_ONCE) }
        val ptr = lwjgl.pointer
        return this.block().also {
            lwjgl.pointer = ptr
        }
    }

    inline val String.asciiPtr: Ptr<Char>
        get() = lwjgl.apply { nASCII(this@asciiPtr, true) }.pointerAddress.toPtr()


    inline val VkInstanceCreateInfo.ptr: Ptr<VkInstanceCreateInfo>
        get() = this.into(this@MemStack)

    inline fun <R> readPointer(block: (Ptr<UByte>) -> R): Ptr<UByte> = invoke { lwjgl.nmalloc(8).toPtr<UByte>().also { block(it) } }

    companion object
}

inline fun String.utf8Into(stack: MemStack): Adr = stack.lwjgl.writeUtf8ToAdr(this)
// encodeUTF8Unsafe
fun String.utf8Into(target: Ptr<UByte>, nullTerminated: Boolean = true): Int {
    var p = 0
    var i = 0
    val len = length

    while (i < len) {
        val c = this[i++]
        val code = c.code
        if (code < 0x80) {
            target[p++] = code.toUByte()
        } else {
            var cp = code
            if (code < 0x800) {
                target[p++] = (0xC0 or (cp shr 6)).toUByte()
            } else {
                if (!c.isHighSurrogate())
                    target[p++] = (0xE0 or (cp shr 12)).toUByte()
                else {
                    cp = Character.toCodePoint(c, this[i++])

                    target[p++] = (0xF0 or (cp shr 18)).toUByte()
                    target[p++] = (0x80 or ((cp shr 12) and 0x3F)).toUByte()
                }
                target[p++] = (0x80 or ((cp shr 6) and 0x3F)).toUByte()
            }
            target[p++] = (0x80 or (cp and 0x3F)).toUByte()
        }
    }

    if (nullTerminated)
        target[p++] = 0u

    return p
}

inline fun MemStack() = MemStack(MemoryStack.stackGet())

inline operator fun <R> MemStack.Companion.invoke(block: MemStack.() -> R): R = MemStack().invoke { block() }