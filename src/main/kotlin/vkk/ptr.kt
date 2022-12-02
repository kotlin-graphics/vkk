@file:OptIn(ExperimentalUnsignedTypes::class)

package vkk

import kool.Ptr
import kool.indices
import kool.set
import kool.ubuffers.UByteBuffer
import kool.unsafe
import org.lwjgl.system.MemoryUtil

//@JvmInline
//value class Ptr<out T> constructor(val address: Address = NULL.address) {
//    inline val adr: Address
//        get() = address
//
//    inline operator fun plus(offset: Int): Ptr<T> = plus(offset.toULong())
//    inline operator fun plus(offset: Long): Ptr<T> = plus(offset.toULong())
//    inline operator fun plus(offset: ULong): Ptr<T> = Ptr(address + offset)
//
//    inline fun <T> toPtr(): Ptr<T> = Ptr(adr)
//
//    companion object {
//        val NULL: Ptr<Nothing>
//            get() = Ptr(MemoryUtil.NULL.toULong())
//    }
//}
//
//inline fun <T> Ptr(long: Long): Ptr<T> = Ptr(long.toULong())

infix fun Ptr<UByte>.`=` (value: Boolean) = unsafe.set(adr, if (value) 1 else 0)
infix fun Ptr<UByte>.`=` (value: UByte) = unsafe.set(adr, value)
infix fun Ptr<UByte>.`=` (value: Int) = unsafe.set(adr, value)
infix fun Ptr<UByte>.`=` (value: UInt) = unsafe.set(adr, value)
infix fun Ptr<UByte>.`=` (value: ULong) = unsafe.set(adr, value)
infix fun Ptr<UByte>.`=` (value: Long) = unsafe.set(adr, value)
infix fun Ptr<UByte>.`=` (value: Float) = unsafe.set(adr, value)
infix fun Ptr<UByte>.`=` (value: String) {
    value.utf8Into(this)
}
infix fun Ptr<UByte>.`=` (value: FloatArray) {
    val ptr = toPtr<Float>()
    for (i in value.indices)
        ptr[i] = value[i]
}
infix fun <T> Ptr<UByte>.`=` (value: Ptr<T>) = unsafe.set(adr, value.adr)
infix fun Ptr<UByte>.`=`(value: UByteBuffer) {
    for (i in value.indices)
        this[i] = value[i]
}
infix fun Ptr<UByte>.`=`(value: UByteArray) {
    for (i in value.indices)
        this[i] = value[i]
}
infix fun Ptr<UByte>.`=`(value: UIntArray) {
    val ptr = toPtr<UInt>()
    for (i in value.indices)
        ptr[i] = value[i]
}
infix fun UByteBuffer.into(stack: MemStack): Ptr<UByte> {
    val mem = stack.malloc(this.cap.toUInt())
    for (i in indices)
        mem[i] = this[i]
    return mem
}
//
//typealias Pointer = ULong
//typealias Address = ULong
//
@JvmInline
value class Adr(val offset: ULong = NULL.offset) {
    //    inline val adr: Adr
    //        get() = address

    constructor(value: Long) : this(value.toULong())

    inline operator fun plus(offset: Int): Adr = plus(offset.toULong())
    inline operator fun plus(offset: Long): Adr = plus(offset.toULong())
    inline operator fun plus(offset: ULong): Adr = Adr(this.offset + offset)

    inline infix fun set(value: Int) = unsafe.set(offset, value)
    inline infix fun set(value: Float) = unsafe.set(offset, value)

    infix fun `=` (value: Int) = unsafe.set(offset, value)
    infix fun `=` (value: Float) = unsafe.set(offset, value)
    companion object {
        val NULL: Adr
            get() = Adr(MemoryUtil.NULL.toULong())
    }
}

val Long.asAdr
    get() = Adr(this)
//inline fun <T> Adr(value: Long): Adr = Adr(value.toULong())