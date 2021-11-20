package vkk

import glm_.i
import glm_.mat4x4.Mat4
import glm_.s
import glm_.vec4.Vec4
import kool.*
import org.lwjgl.PointerBuffer
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.Pointer
import org.lwjgl.vulkan.VkCommandBuffer
import unsigned.toULong
import vkk.entities.VkDeviceSize
import java.nio.*

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


@JvmInline
value class HINSTANCE(val L: Long)
@JvmInline
value class HWND(val L: Long)
@JvmInline
value class HANDLE(val L: Long)
@JvmInline
value class DWORD(val i: Int)
@JvmInline
value class Display(val L: Long)
@JvmInline
value class Window(val L: Long)
@JvmInline
value class VisualID(val L: Long)
@JvmInline
value class WLDisplay(val L: Long)
@JvmInline
value class WLSurface(val L: Long)
@JvmInline
value class RROutput(val L: Long)
@JvmInline
value class HMONITOR(val L: Long)


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

fun Vec4.toAdr(stack: MemoryStack): FloatPtr {
    val floats = stack.mFloat(Vec4.length)
    floats[0] = x
    floats[1] = y
    floats[2] = z
    floats[3] = w
    return floats
}

// --------------------------------------------- framed setters ---------------------------------------------

inline fun <R> MemoryStack.asciiAdr(chars: CharSequence, nullTerminated: Boolean = true, block: (Adr) -> R) = framed { nASCII(chars, nullTerminated); block(pointerAddress); }
inline fun <R> MemoryStack.asciiBuf(chars: CharSequence, nullTerminated: Boolean = true, block: (ByteBuffer) -> R) = framed { block(ASCII(chars, nullTerminated)) }

inline fun <R> MemoryStack.adr(byte: Byte, block: (Adr) -> R): R = framed { block(byteAdr(byte)) }
inline fun <R> MemoryStack.buf(byte: Byte, block: (ByteBuffer) -> R): R = framed { block(bytes(byte)) }

inline fun <R> MemoryStack.adr(short: Short, block: (Adr) -> R): R = framed { block(shortAdr(short)) }
inline fun <R> MemoryStack.buf(short: Short, block: (ShortBuffer) -> R): R = framed { block(shorts(short)) }

inline fun <R> MemoryStack.adr(int: Int, block: (Adr) -> R): R = framed { block(intAdr(int)) }
inline fun <R> MemoryStack.buf(int: Int, block: (IntBuffer) -> R): R = framed { block(ints(int)) }

inline fun <R> MemoryStack.adr(long: Long, block: (Adr) -> R): R = framed { block(longAdr(long)) }
inline fun <R> MemoryStack.buf(long: Long, block: (LongBuffer) -> R): R = framed { block(longs(long)) }

inline fun <R> MemoryStack.adr(float: Float, block: (Adr) -> R): R = framed { block(floatAdr(float)) }
inline fun <R> MemoryStack.buf(float: Float, block: (FloatBuffer) -> R): R = framed { block(floats(float)) }

inline fun <R> MemoryStack.adr(double: Double, block: (Adr) -> R): R = framed { block(doubleAdr(double)) }
inline fun <R> MemoryStack.buf(double: Double, block: (DoubleBuffer) -> R): R = framed { block(doubles(double)) }

inline fun <R> MemoryStack.adr(pointer: Pointer, block: (Adr) -> R): R = framed { block(pointerAdr(pointer)) }
inline fun <R> MemoryStack.buf(pointer: Pointer, block: (PointerBuffer) -> R): R = framed { block(pointers(pointer)) }

inline fun <R> MemoryStack.utf8Adr(chars: CharSequence, nullTerminated: Boolean = true, block: (Adr) -> R): R = framed {
    val target = nmalloc(1, MemoryUtil.memLengthASCII(chars, nullTerminated))
    encodeUTF8(chars, nullTerminated, target)
    block(target)
}

inline fun <R> MemoryStack.utf8Buffer(chars: CharSequence, nullTerminated: Boolean = true, block: (ByteBuffer) -> R): R =
        framed { block(UTF8(chars, nullTerminated)) }


fun MemoryStack.adr(bytes: ByteArray): Adr {
    val pByte = mByte(bytes.size)
    for (i in bytes.indices)
        pByte[i] = bytes[i]
    return pByte.adr
}

fun MemoryStack.adr(ints: IntArray): Adr {
    val pInt = mInt(ints.size)
    for (i in ints.indices)
        pInt[i] = ints[i]
    return pInt.adr
}

fun MemoryStack.adr(longs: LongArray): Adr {
    val pLong = mLong(longs.size)
    for (i in longs.indices)
        pLong[i] = longs[i]
    return pLong.adr
}

fun MemoryStack.adr(floats: FloatArray): Adr {
    val pFloat = mFloat(floats.size)
    for (i in floats.indices)
        pFloat[i] = floats[i]
    return pFloat.adr
}

// Address version

fun MemoryStack.Adr(bytes: ByteArray): BytePtr = BytePtr(bytes.size) { bytes[it] }
fun MemoryStack.ByteAdr(bytes: ByteArray): BytePtr = Adr(bytes)
//fun MemoryStack.ByteAdr(size: Int, init: (Int) -> Byte): BytePtr = pByte(size).also { for (i in 0 until size) it[i] = init(i) }

fun MemoryStack.Adr(shorts: ShortArray): ShortPtr = ShortPtr(shorts.size) { shorts[it] }
fun MemoryStack.ByteAdr(shorts: ShortArray): BytePtr = BytePtr(Adr(shorts))
fun MemoryStack.ShortAdr(shorts: ShortArray): ShortPtr = Adr(shorts)
//fun MemoryStack.ShortAdr(size: Int, init: (Int) -> Short): ShortPtr = pShort(size).also { for (i in 0 until size) it[i] = init(i) }

fun MemoryStack.Adr(ints: IntArray): IntPtr = IntPtr(ints.size) { ints[it] }
fun MemoryStack.ByteAdr(ints: IntArray): BytePtr = BytePtr(Adr(ints))
fun MemoryStack.IntAdr(ints: IntArray): IntPtr = Adr(ints)
//fun MemoryStack.IntAdr(size: Int, init: (Int) -> Int): IntPtr = pInt(size).also { for (i in 0 until size) it[i] = init(i) }

fun MemoryStack.Adr(longs: LongArray): LongPtr = LongPtr(longs.size) { longs[it] }
fun MemoryStack.ByteAdr(longs: LongArray): BytePtr = BytePtr(Adr(longs))
fun MemoryStack.LongAdr(longs: LongArray): LongPtr = Adr(longs)
//fun MemoryStack.LongAdr(size: Int, init: (Int) -> Long): LongPtr = pLong(size).also { for (i in 0 until size) it[i] = init(i) }

fun MemoryStack.Adr(floats: FloatArray): FloatPtr = FloatPtr(floats.size) { floats[it] }
fun MemoryStack.ByteAdr(floats: FloatArray): BytePtr = BytePtr(Adr(floats))
fun MemoryStack.FloatAdr(floats: FloatArray): FloatPtr = Adr(floats)
//fun MemoryStack.FloatAdr(size: Int, init: (Int) -> Float): FloatPtr = pFloat(size).also { for (i in 0 until size) it[i] = init(i) }

fun MemoryStack.Adr(doubles: DoubleArray): DoublePtr = DoublePtr(doubles.size) { doubles[it] }
fun MemoryStack.ByteAdr(doubles: DoubleArray): BytePtr = BytePtr(Adr(doubles))
fun MemoryStack.DoubleAdr(doubles: DoubleArray): DoublePtr = Adr(doubles)
//fun MemoryStack.DoubleAdr(size: Int, init: (Int) -> Double): DoublePtr = pDouble(size).also { for (i in 0 until size) it[i] = init(i) }

fun MemoryStack.ptrOf(mat: Mat4): Ptr {
    val p= mFloat(Mat4.length)
    for (c in 0..3)
        for (r in 0..3)
            p[c * 4 + r] = mat[c, r]
    return p.adr
}