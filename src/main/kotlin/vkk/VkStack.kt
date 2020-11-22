package vkk

import kool.*
import org.lwjgl.BufferUtils
import org.lwjgl.CLongBuffer
import org.lwjgl.PointerBuffer
import org.lwjgl.system.Configuration
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.Pointer
import vkk.extensions.VkStack_KHR_surface
import vkk.extensions.VkStack_KHR_swapchain
import vkk.vk10.VkStack_VK10
import vkk.vk11.VkStack_VK11
import java.nio.*

interface VkStackInterface {
    val stack: VkStack
}

inline operator fun <R> MemoryStack.invoke(block: () -> R): R {
    val ptr = pointer
    return block().also {
        pointer = ptr
    }
}

/**
 * An off-heap memory stack.
 *
 * <p>This class should be used in a thread-local manner for stack allocations.</p>
 *
 * @see Configuration#STACK_SIZE
 * @see Configuration#DEBUG_STACK
 */
class VkStack private constructor(container: ByteBuffer?, address: Adr, size: Int) :
        MemoryStack(container, address, size),
        VkStack_VK10,
        VkStack_VK11,
        VkStack_KHR_surface,
        VkStack_KHR_swapchain {

    override val stack: VkStack
        get() = this

    //    inline var pointer: Int
    //        get() = stack.pointer
    //        set(value) {
    //            stack.pointer = value
    //        }

    inline operator fun <R> invoke(block: () -> R): R = framed(block)

    inline fun <R> framed(block: () -> R): R {
        val ptr = pointer
        return block().also {
            pointer = ptr
        }
    }


    inline fun pByte(count: Int = 1) = BytePtr(super.nmalloc(Byte.BYTES, Byte.BYTES * count))
    inline fun pShort(count: Int = 1) = ShortPtr(stack.nmalloc(Short.BYTES, Short.BYTES * count))
    inline fun pInt(count: Int = 1) = IntPtr(stack.nmalloc(Int.BYTES, Int.BYTES * count))
    inline fun pLong(count: Int = 1) = LongPtr(stack.nmalloc(Long.BYTES, Long.BYTES * count))
    inline fun pFloat(count: Int = 1) = FloatPtr(stack.nmalloc(Float.BYTES, Float.BYTES * count))
    inline fun pDouble(count: Int = 1) = DoublePtr(stack.nmalloc(Double.BYTES, Double.BYTES * count))
    inline fun pPointer(count: Int = 1) = PointerPtr(stack.nmalloc(Pointer.POINTER_SIZE, Pointer.POINTER_SIZE * count))

    // TODO keep?
    inline fun cByte(count: Int = 1) = BytePtr(stack.ncalloc(Byte.BYTES, count, Byte.BYTES))
    inline fun cShort(count: Int = 1) = ShortPtr(stack.ncalloc(Short.BYTES, count, Short.BYTES))
    inline fun cInt(count: Int = 1) = IntPtr(stack.ncalloc(Int.BYTES, count, Int.BYTES))
    inline fun cLong(count: Int = 1) = LongPtr(stack.ncalloc(Long.BYTES, count, Long.BYTES))
    inline fun cFloat(count: Int = 1) = FloatPtr(stack.ncalloc(Float.BYTES, count, Float.BYTES))
    inline fun cDouble(count: Int = 1) = DoublePtr(stack.ncalloc(Double.BYTES, count, Double.BYTES))
    inline fun cPointer(count: Int = 1) = PointerPtr(stack.ncalloc(Pointer.POINTER_SIZE, count, Pointer.POINTER_SIZE))

    fun reset() {
        stack.pointer = Configuration.STACK_SIZE.get(64) * 1024
    }

    fun pByteOf(b: Byte): BytePtr = pByte(1).also { it[0] = b }
    fun pByteOf(b0: Byte, b1: Byte): BytePtr = pByte(2).also { it[0] = b0; it[1] = b1 }
    fun pByteOf(b0: Byte, b1: Byte, b2: Byte): BytePtr = pByte(3).also { it[0] = b0; it[1] = b1; it[2] = b2 }
    fun pByteOf(b0: Byte, b1: Byte, b2: Byte, b3: Byte): BytePtr = pByte(4).also { it[0] = b0; it[1] = b1; it[2] = b2; it[3] = b3 }
    fun pByteOf(vararg bytes: Byte): BytePtr = pByte(bytes.size).also { for (i in bytes.indices) it[i] = bytes[i] }

    fun pShortOf(s: Short): ShortPtr = pShort(1).also { it[0] = s }
    fun pShortOf(s0: Short, s1: Short): ShortPtr = pShort(2).also { it[0] = s0; it[1] = s1 }
    fun pShortOf(s0: Short, s1: Short, s2: Short): ShortPtr = pShort(3).also { it[0] = s0; it[1] = s1; it[2] = s2 }
    fun pShortOf(s0: Short, s1: Short, s2: Short, s3: Short): ShortPtr = pShort(4).also { it[0] = s0; it[1] = s1; it[2] = s2; it[3] = s3 }
    fun pShortOf(vararg shorts: Short): ShortPtr = pShort(shorts.size).also { for (i in shorts.indices) it[i] = shorts[i] }

    fun pIntOf(i: Int): IntPtr = pInt(1).also { it[0] = i }
    fun pIntOf(i0: Int, i1: Int): IntPtr = pInt(2).also { it[0] = i0; it[1] = i1 }
    fun pIntOf(i0: Int, i1: Int, i2: Int): IntPtr = pInt(3).also { it[0] = i0; it[1] = i1; it[2] = i2 }
    fun pIntOf(i0: Int, i1: Int, i2: Int, i3: Int): IntPtr = pInt(4).also { it[0] = i0; it[1] = i1; it[2] = i2; it[3] = i3 }
    fun pIntOf(vararg ints: Int): IntPtr = pInt(ints.size).also { for (i in ints.indices) it[i] = ints[i] }

    fun pLongOf(L: Long): LongPtr = pLong(1).also { it[0] = L }
    fun pLongOf(L0: Long, L1: Long): LongPtr = pLong(2).also { it[0] = L0; it[1] = L1 }
    fun pLongOf(L0: Long, L1: Long, L2: Long): LongPtr = pLong(3).also { it[0] = L0; it[1] = L1; it[2] = L2 }
    fun pLongOf(L0: Long, L1: Long, L2: Long, L3: Long): LongPtr = pLong(4).also { it[0] = L0; it[1] = L1; it[2] = L2; it[3] = L3 }
    fun pLongOf(vararg longs: Long): LongPtr = pLong(longs.size).also { for (i in longs.indices) it[i] = longs[i] }

    fun pFloatOf(f: Float): FloatPtr = pFloat(1).also { it[0] = f }
    fun pFloatOf(f0: Float, f1: Float): FloatPtr = pFloat(2).also { it[0] = f0; it[1] = f1 }
    fun pFloatOf(f0: Float, f1: Float, f2: Float): FloatPtr = pFloat(3).also { it[0] = f0; it[1] = f1; it[2] = f2 }
    fun pFloatOf(f0: Float, f1: Float, f2: Float, f3: Float): FloatPtr = pFloat(4).also { it[0] = f0; it[1] = f1; it[2] = f2; it[3] = f3 }
    fun pFloatOf(vararg floats: Float): FloatPtr = pFloat(floats.size).also { for (i in floats.indices) it[i] = floats[i] }

    fun pDoubleOf(d: Double): DoublePtr = pDouble(1).also { it[0] = d }
    fun pDoubleOf(d0: Double, d1: Double): DoublePtr = pDouble(2).also { it[0] = d0; it[1] = d1 }
    fun pDoubleOf(d0: Double, d1: Double, d2: Double): DoublePtr = pDouble(3).also { it[0] = d0; it[1] = d1; it[2] = d2 }
    fun pDoubleOf(d0: Double, d1: Double, d2: Double, d3: Double): DoublePtr = pDouble(4).also { it[0] = d0; it[1] = d1; it[2] = d2; it[3] = d3 }
    fun pDoubleOf(vararg doubles: Double): DoublePtr = pDouble(doubles.size).also { for (i in doubles.indices) it[i] = doubles[i] }

    fun pPointerOf(p: Pointer): PointerPtr = pPointer(1).also { it[0] = p }
    //fun VrStack.pPointerOf(d0: Double, d1: Double): DoublePtr = mDouble(2).also { it[0] = d0; it[1] = d1 }
    //fun VrStack.pPointerOf(d0: Double, d1: Double, d2: Double): DoublePtr = mDouble(3).also { it[0] = d0; it[1] = d1; it[2] = d2 }
    //fun VrStack.pPointerOf(d0: Double, d1: Double, d2: Double, d3: Double): DoublePtr = mDouble(4).also { it[0] = d0; it[1] = d1; it[2] = d2; it[3] = d3 }
    //fun VrStack.pPointerOf(vararg doubles: Double): DoublePtr = mDouble(doubles.size).also { for(i in doubles.indices) it[i] = doubles[i] }


    // --------------------------------------------- getters ---------------------------------------------

    inline fun <R> byteAdr(block: (Adr) -> R): Byte {
        val pByte = pByte()
        block(pByte.adr)
        return pByte()
    }

    inline fun <R> byteBuf(block: (ByteBuffer) -> R): Byte {
        val buf = stack.malloc(1)
        block(buf)
        return buf[0]
    }

    inline fun <R> shortAdr(block: (Adr) -> R): Short {
        val pShort = pShort()
        block(pShort.adr)
        return pShort()
    }

    inline fun <R> shortBuf(block: (ShortBuffer) -> R): Short {
        val buf = stack.mallocShort(1)
        block(buf)
        return buf[0]
    }

    inline fun <R> intAdr(block: (Adr) -> R): Int {
        val pInt = pInt()
        block(pInt.adr)
        return pInt()
    }

    inline fun <R> intBuf(block: (IntBuffer) -> R): Int {
        val buf = stack.mallocInt(1)
        block(buf)
        return buf[0]
    }

    inline fun <R> longAdr(block: (Adr) -> R): Long {
        val pLong = pLong()
        block(pLong.adr)
        return pLong()
    }

    inline fun <R> longBuf(block: (LongBuffer) -> R): Long {
        val buf = stack.mallocLong(1)
        block(buf)
        return buf[0]
    }

    inline fun <R> floatAdr(block: (Adr) -> R): Float {
        val pFloat = pFloat()
        block(pFloat.adr)
        return pFloat()
    }

    inline fun <R> floatBuf(block: (FloatBuffer) -> R): Float {
        val buf = stack.mallocFloat(1)
        block(buf)
        return buf[0]
    }

    inline fun <R> doubleAdr(block: (Adr) -> R): Double {
        val pDouble = pDouble()
        block(pDouble.adr)
        return pDouble()
    }

    inline fun <R> doubleBuf(block: (DoubleBuffer) -> R): Double {
        val buf = stack.mallocDouble(1)
        block(buf)
        return buf[0]
    }

    inline fun <R> pointerAdr(block: (Adr) -> R): Ptr = framed {
        val pointer = pPointer()
        block(pointer.adr)
        return pointer()
    }

    inline fun <R> pointerBuf(block: (PointerBuffer) -> R): Ptr {
        val buf = stack.mallocPointer(1)
        block(buf)
        return buf[0]
    }

    /** It mallocs, passes the address and reads the null terminated string */
    inline fun <R> asciiAdr(maxSize: Int, block: (Adr) -> R): String {
        val adr = stack.nmalloc(1, maxSize)
        block(adr)
        return MemoryUtil.memASCII(adr, strlen64NT1(adr, maxSize))
    }

    /** It malloc the buffer, passes it and reads the null terminated string */
    inline fun <R> asciiBuffer(maxSize: Int, block: (ByteBuffer) -> R): String {
        val buf = stack.malloc(1, maxSize)
        block(buf)
        return MemoryUtil.memASCII(buf.adr, maxSize)
    }

    // --------------------------------------------- setters ---------------------------------------------

    inline fun asciiAdr(chars: CharSequence, nullTerminated: Boolean = true): Adr = stack.nASCII(chars, nullTerminated).let { stack.pointerAddress }
    inline fun asciiBuffer(chars: CharSequence, nullTerminated: Boolean = true): ByteBuffer = stack.ASCII(chars, nullTerminated)

    inline fun utf8Adr(chars: CharSequence, nullTerminated: Boolean = true): Adr = stack.nmalloc(1, MemoryUtil.memLengthUTF8(chars, nullTerminated)).also { encodeUTF8(chars, nullTerminated, it) }
    inline fun utf8Buffer(chars: CharSequence, nullTerminated: Boolean = true): ByteBuffer = stack.UTF8(chars, nullTerminated)

    inline fun utf16Adr(chars: CharSequence, nullTerminated: Boolean = true): Adr = stack.nmalloc(1, MemoryUtil.memLengthUTF16(chars, nullTerminated)).also { encodeUTF16(chars, nullTerminated, it) }
    inline fun utf16Buffer(chars: CharSequence, nullTerminated: Boolean = true): ByteBuffer = stack.UTF16(chars, nullTerminated)

    //@JvmName("asciiAdrSafe")
    //inline fun VrStack.asciiAdr(chars: CharSequence?, nullTerminated: Boolean = true): Adr = chars?.let { asciiAdr(it, nullTerminated) } ?: NULL

    inline fun adrOf(byte: Byte): Adr = pByteOf(byte).adr
    inline fun bufOf(byte: Byte): ByteBuffer = stack.bytes(byte)

    inline fun adrOf(short: Short): Adr = pShortOf(short).adr
    inline fun bufOf(short: Short): ShortBuffer = stack.shorts(short)

    inline fun adrOf(int: Int): Adr = pIntOf(int).adr
    inline fun bufOf(int: Int): IntBuffer = stack.ints(int)

    inline fun adrOf(long: Long): Adr = pLongOf(long).adr
    inline fun bufOf(long: Long): LongBuffer = stack.longs(long)

    inline fun adrOf(float: Float): Adr = pFloatOf(float).adr
    inline fun bufOf(float: Float): FloatBuffer = stack.floats(float)

    inline fun adrOf(double: Double): Adr = pDoubleOf(double).adr
    inline fun bufOf(double: Double): DoubleBuffer = stack.doubles(double)

    inline fun adrOf(pointer: Pointer): Adr = pPointerOf(pointer).adr
    inline fun bufOf(pointer: Pointer): PointerBuffer = stack.pointers(pointer)

    // --------------------------------------------- framed setters ---------------------------------------------

    inline fun <R> asciiAdr(chars: CharSequence, nullTerminated: Boolean = true, block: (Adr) -> R) = framed { stack.nASCII(chars, nullTerminated); block(stack.pointerAddress); }
    inline fun <R> asciiBuf(chars: CharSequence, nullTerminated: Boolean = true, block: (ByteBuffer) -> R) = framed { block(stack.ASCII(chars, nullTerminated)) }

    inline fun <R> adr(byte: Byte, block: (Adr) -> R): R = framed { block(pByteOf(byte).adr) }
    inline fun <R> buf(byte: Byte, block: (ByteBuffer) -> R): R = framed { block(stack.bytes(byte)) }

    inline fun <R> adr(short: Short, block: (Adr) -> R): R = framed { block(pShortOf(short).adr) }
    inline fun <R> buf(short: Short, block: (ShortBuffer) -> R): R = framed { block(stack.shorts(short)) }

    inline fun <R> adr(int: Int, block: (Adr) -> R): R = framed { block(pIntOf(int).adr) }
    inline fun <R> buf(int: Int, block: (IntBuffer) -> R): R = framed { block(stack.ints(int)) }

    inline fun <R> adr(long: Long, block: (Adr) -> R): R = framed { block(pLongOf(long).adr) }
    inline fun <R> buf(long: Long, block: (LongBuffer) -> R): R = framed { block(stack.longs(long)) }

    inline fun <R> adr(float: Float, block: (Adr) -> R): R = framed { block(pFloatOf(float).adr) }
    inline fun <R> buf(float: Float, block: (FloatBuffer) -> R): R = framed { block(stack.floats(float)) }

    inline fun <R> adr(double: Double, block: (Adr) -> R): R = framed { block(pDoubleOf(double).adr) }
    inline fun <R> buf(double: Double, block: (DoubleBuffer) -> R): R = framed { block(stack.doubles(double)) }

    inline fun <R> adr(pointer: Pointer, block: (Adr) -> R): R = framed { block(pPointerOf(pointer).adr) }
    inline fun <R> buf(pointer: Pointer, block: (PointerBuffer) -> R): R = framed { block(stack.pointers(pointer)) }

    inline fun <R> utf8Adr(chars: CharSequence, nullTerminated: Boolean = true, block: (Adr) -> R): R = framed {
        val target = stack.nmalloc(1, MemoryUtil.memLengthASCII(chars, nullTerminated))
        encodeUTF8(chars, nullTerminated, target)
        block(target)
    }

    inline fun <R> utf8Buffer(chars: CharSequence, nullTerminated: Boolean = true, block: (ByteBuffer) -> R): R =
            framed { block(stack.UTF8(chars, nullTerminated)) }


    // VrStack version

    fun Buffer(size: Int): ByteBuffer = stack.calloc(size)
    inline fun Buffer(size: Int, init: (Int) -> Byte) = Buffer(size).also { for (i in 0 until size) it[i] = init(i) }

    fun ByteBuffer(size: Int): ByteBuffer = stack.calloc(size)
    inline fun ByteBuffer(size: Int, init: (Int) -> Byte) = ByteBuffer(size).also { for (i in 0 until size) it[i] = init(i) }

    fun ShortBuffer(size: Int): ShortBuffer = stack.callocShort(size)
    inline fun ShortBuffer(size: Int, init: (Int) -> Short) = ShortBuffer(size).also { for (i in 0 until size) it[i] = init(i) }

    fun IntBuffer(size: Int): IntBuffer = stack.callocInt(size)
    inline fun IntBuffer(size: Int, init: (Int) -> Int) = IntBuffer(size).also { for (i in 0 until size) it[i] = init(i) }

    fun LongBuffer(size: Int): LongBuffer = stack.mallocLong(size)
    inline fun LongBuffer(size: Int, init: (Int) -> Long) = LongBuffer(size).also { for (i in 0 until size) it[i] = init(i) }

    fun FloatBuffer(size: Int): FloatBuffer = stack.callocFloat(size)
    inline fun FloatBuffer(size: Int, init: (Int) -> Float) = FloatBuffer(size).also { for (i in 0 until size) it[i] = init(i) }

    fun DoubleBuffer(size: Int): DoubleBuffer = stack.callocDouble(size)
    inline fun DoubleBuffer(size: Int, init: (Int) -> Double) = DoubleBuffer(size).also { for (i in 0 until size) it[i] = init(i) }

    fun PointerBuffer(size: Int): PointerBuffer = stack.callocPointer(size)
    inline fun PointerBuffer(size: Int, init: (Int) -> Adr) = PointerBuffer(size).also { for (i in 0 until size) it[i] = init(i) }
    inline fun PointerBufferP(size: Int, init: (Int) -> Pointer) = PointerBuffer(size).also { for (i in 0 until size) it[i] = init(i) }
    inline fun PointerBufferB(size: Int, init: (Int) -> Buffer) = PointerBuffer(size).also { for (i in 0 until size) it[i] = init(i) }

    fun PointerBuffer(strings: Collection<String>): PointerBuffer = PointerBuffer(strings.size) { i ->
        val string = strings.elementAt(i)
        val length = MemoryUtil.memLengthUTF8(string, true)
        stack.nmalloc(1, length).also { encodeUTF8(string, true, it) }
    }

    @JvmName("PointerBufferSafe")
    fun PointerBuffer(strings: Collection<String>?): PointerBuffer? = strings?.let { PointerBuffer(it) }

    fun PointerAdr(strings: Collection<String>): Adr = PointerAdr(strings.size) { i ->
        val string = strings.elementAt(i)
        val length = MemoryUtil.memLengthUTF8(string, true)
        stack.nmalloc(1, length).also { encodeUTF8(string, true, it) }
    }

    @JvmName("PointerAdrSafe")
    fun PointerAdr(strings: Collection<String>?): Adr = strings?.let { PointerAdr(it) } ?: MemoryUtil.NULL

    inline fun PointerAdr(size: Int, init: (Int) -> Adr): Adr {
        val bytes = size * Pointer.POINTER_SIZE
        val address = stack.nmalloc(Pointer.POINTER_SIZE, bytes)
        MemoryUtil.memSet(address, 0, bytes.toLong())
        for (i in 0 until size)
            MemoryUtil.memPutAddress(address + i * Pointer.POINTER_SIZE, init(i))
        return address
    }


    // conversions, buffers

    fun Buffer(bytes: ByteArray): ByteBuffer = Buffer(bytes.size) { bytes[it] }
    fun ByteBuffer(bytes: ByteArray): ByteBuffer = Buffer(bytes)
    //inline fun ByteArray.toShortBuffer(stack: MemoryStack): ShortBuffer { TODO?

    fun Buffer(shorts: ShortArray): ByteBuffer = Buffer(shorts.size * Short.BYTES).also { for (i in shorts.indices) it.putShort(i * Short.BYTES, shorts[i]) }
    fun ByteBuffer(shorts: ShortArray): ByteBuffer = Buffer(shorts)
    fun ShortBuffer(shorts: ShortArray): ShortBuffer = ShortBuffer(shorts.size) { shorts[it] }

    fun Buffer(ints: IntArray): ByteBuffer = Buffer(ints.size * Int.BYTES).also { for (i in ints.indices) it.putInt(i * Int.BYTES, ints[i]) }
    fun ByteBuffer(ints: IntArray): ByteBuffer = Buffer(ints)
    fun IntBuffer(ints: IntArray): IntBuffer = IntBuffer(ints.size) { ints[it] }

    fun Buffer(longs: LongArray): ByteBuffer = Buffer(longs.size * Long.BYTES).also { for (i in longs.indices) it.putLong(i * Long.BYTES, longs[i]) }
    fun ByteBuffer(longs: LongArray): ByteBuffer = Buffer(longs)
    fun LongBuffer(longs: LongArray): LongBuffer = LongBuffer(longs.size) { longs[it] }

    fun Buffer(floats: FloatArray): ByteBuffer = Buffer(floats.size * Float.BYTES).also { for (i in floats.indices) it.putFloat(i * Float.BYTES, floats[i]) }
    fun ByteBuffer(floats: FloatArray): ByteBuffer = Buffer(floats)
    fun FloatBuffer(floats: FloatArray): FloatBuffer = FloatBuffer(floats.size) { floats[it] }

    fun Buffer(doubles: DoubleArray): ByteBuffer = Buffer(doubles.size * Double.BYTES).also { for (i in doubles.indices) it.putDouble(i * Double.BYTES, doubles[i]) }
    fun ByteBuffer(doubles: DoubleArray): ByteBuffer = Buffer(doubles)
    fun DoubleBuffer(doubles: DoubleArray): DoubleBuffer = DoubleBuffer(doubles.size) { doubles[it] }

    // Address version

    fun Adr(bytes: ByteArray): BytePtr = BytePtr(bytes.size) { bytes[it] }
    fun ByteAdr(bytes: ByteArray): BytePtr = Adr(bytes)
    fun ByteAdr(size: Int, init: (Int) -> Byte): BytePtr = pByte(size).also { for (i in 0 until size) it[i] = init(i) }

    fun Adr(shorts: ShortArray): ShortPtr = ShortPtr(shorts.size) { shorts[it] }
    fun ByteAdr(shorts: ShortArray): BytePtr = BytePtr(Adr(shorts))
    fun ShortAdr(shorts: ShortArray): ShortPtr = Adr(shorts)
    fun ShortAdr(size: Int, init: (Int) -> Short): ShortPtr = pShort(size).also { for (i in 0 until size) it[i] = init(i) }

    fun Adr(ints: IntArray): IntPtr = IntPtr(ints.size) { ints[it] }
    fun ByteAdr(ints: IntArray): BytePtr = BytePtr(Adr(ints))
    fun IntAdr(ints: IntArray): IntPtr = Adr(ints)
    fun IntAdr(size: Int, init: (Int) -> Int): IntPtr = pInt(size).also { for (i in 0 until size) it[i] = init(i) }

    fun Adr(longs: LongArray): LongPtr = LongPtr(longs.size) { longs[it] }
    fun ByteAdr(longs: LongArray): BytePtr = BytePtr(Adr(longs))
    fun LongAdr(longs: LongArray): LongPtr = Adr(longs)
    fun LongAdr(size: Int, init: (Int) -> Long): LongPtr = pLong(size).also { for (i in 0 until size) it[i] = init(i) }

    fun Adr(floats: FloatArray): FloatPtr = FloatPtr(floats.size) { floats[it] }
    fun ByteAdr(floats: FloatArray): BytePtr = BytePtr(Adr(floats))
    fun FloatAdr(floats: FloatArray): FloatPtr = Adr(floats)
    fun FloatAdr(size: Int, init: (Int) -> Float): FloatPtr = pFloat(size).also { for (i in 0 until size) it[i] = init(i) }

    fun Adr(doubles: DoubleArray): DoublePtr = DoublePtr(doubles.size) { doubles[it] }
    fun ByteAdr(doubles: DoubleArray): BytePtr = BytePtr(Adr(doubles))
    fun DoubleAdr(doubles: DoubleArray): DoublePtr = Adr(doubles)
    fun DoubleAdr(size: Int, init: (Int) -> Double): DoublePtr = pDouble(size).also { for (i in 0 until size) it[i] = init(i) }

    companion object {

        val DEFAULT_STACK_SIZE = Configuration.STACK_SIZE.get(64) * 1024
        private val TLS = ThreadLocal.withInitial(this::create)

        fun create(capacity: Int = DEFAULT_STACK_SIZE): VkStack = create(BufferUtils.createByteBuffer(capacity))
        fun create(buffer: ByteBuffer): VkStack = VkStack(buffer, buffer.adr, buffer.rem)
        fun ncreate(address: Adr, size: Int): VkStack = VkStack(null, address, size)

        fun get(): VkStack = from(TLS.get())

        fun push(): VkStack = get().apply { push() }

        fun pop(): VkStack = get().apply { pop() }

        infix fun from(memStack: MemoryStack): VkStack {
            val adr = memStack.adr
            val size = memStack.size
            return VkStack(MemoryUtil.memByteBuffer(adr, size), adr, size)
        }

        inline operator fun <R> invoke(block: (VkStack) -> R): R {
            val vkStack = VkStack.get() // slightly more efficient than `use`
            val ptr = vkStack.pointer
            return block(vkStack).also {
                vkStack.pointer = ptr
            }
        }

        fun nMalloc(size: Int): Adr = MemoryStack.nstackMalloc(size)
        fun nMalloc(alignment: Int, size: Int): Adr = MemoryStack.nstackMalloc(alignment, size)
        fun nCalloc(alignment: Int, num: Int, size: Int): Adr = MemoryStack.nstackCalloc(alignment, num, size)

        // -------------------------------------------------

        fun malloc(size: Int): ByteBuffer = MemoryStack.stackGet().malloc(size)
        fun calloc(size: Int): ByteBuffer = MemoryStack.stackGet().calloc(size)
        fun bytes(x: Byte): ByteBuffer = MemoryStack.stackGet().bytes(x)
        fun bytes(x: Byte, y: Byte): ByteBuffer = MemoryStack.stackGet().bytes(x, y)
        fun bytes(x: Byte, y: Byte, z: Byte): ByteBuffer = MemoryStack.stackGet().bytes(x, y, z)
        fun bytes(x: Byte, y: Byte, z: Byte, w: Byte): ByteBuffer = MemoryStack.stackGet().bytes(x, y, z, w)
        fun bytes(vararg values: Byte): ByteBuffer = MemoryStack.stackGet().bytes(*values)

        // -------------------------------------------------

        fun mallocShort(size: Int): ShortBuffer = MemoryStack.stackGet().mallocShort(size)
        fun callocShort(size: Int): ShortBuffer = MemoryStack.stackGet().callocShort(size)
        fun shorts(x: Short): ShortBuffer = MemoryStack.stackGet().shorts(x)
        fun shorts(x: Short, y: Short): ShortBuffer = MemoryStack.stackGet().shorts(x, y)
        fun shorts(x: Short, y: Short, z: Short): ShortBuffer = MemoryStack.stackGet().shorts(x, y, z)
        fun shorts(x: Short, y: Short, z: Short, w: Short): ShortBuffer = MemoryStack.stackGet().shorts(x, y, z, w)
        fun shorts(vararg values: Short): ShortBuffer = MemoryStack.stackGet().shorts(*values)

        // -------------------------------------------------

        fun mallocInt(size: Int): IntBuffer = MemoryStack.stackGet().mallocInt(size)
        fun callocInt(size: Int): IntBuffer = MemoryStack.stackGet().callocInt(size)
        fun ints(x: Int): IntBuffer = MemoryStack.stackGet().ints(x)
        fun ints(x: Int, y: Int): IntBuffer = MemoryStack.stackGet().ints(x, y)
        fun ints(x: Int, y: Int, z: Int): IntBuffer = MemoryStack.stackGet().ints(x, y, z)
        fun ints(x: Int, y: Int, z: Int, w: Int): IntBuffer = MemoryStack.stackGet().ints(x, y, z, w)
        fun ints(vararg values: Int): IntBuffer = MemoryStack.stackGet().ints(*values)

        // -------------------------------------------------

        fun mallocLong(size: Int): LongBuffer = MemoryStack.stackGet().mallocLong(size)
        fun callocLong(size: Int): LongBuffer = MemoryStack.stackGet().callocLong(size)
        fun longs(x: Long): LongBuffer = MemoryStack.stackGet().longs(x)
        fun longs(x: Long, y: Long): LongBuffer = MemoryStack.stackGet().longs(x, y)
        fun longs(x: Long, y: Long, z: Long): LongBuffer = MemoryStack.stackGet().longs(x, y, z)
        fun longs(x: Long, y: Long, z: Long, w: Long): LongBuffer = MemoryStack.stackGet().longs(x, y, z, w)
        fun longs(vararg values: Long): LongBuffer = MemoryStack.stackGet().longs(*values)

        // -------------------------------------------------

        fun mallocCLong(size: Int): CLongBuffer = MemoryStack.stackGet().mallocCLong(size)
        fun callocCLong(size: Int): CLongBuffer = MemoryStack.stackGet().callocCLong(size)
        fun clongs(x: Long): CLongBuffer = MemoryStack.stackGet().clongs(x)
        fun clongs(x: Long, y: Long): CLongBuffer = MemoryStack.stackGet().clongs(x, y)
        fun clongs(x: Long, y: Long, z: Long): CLongBuffer = MemoryStack.stackGet().clongs(x, y, z)
        fun clongs(x: Long, y: Long, z: Long, w: Long): CLongBuffer = MemoryStack.stackGet().clongs(x, y, z, w)
        fun clongs(vararg values: Long): CLongBuffer = MemoryStack.stackGet().clongs(*values)

        // -------------------------------------------------

        fun mallocFloat(size: Int): FloatBuffer = MemoryStack.stackGet().mallocFloat(size)
        fun callocFloat(size: Int): FloatBuffer = MemoryStack.stackGet().callocFloat(size)
        fun floats(x: Float): FloatBuffer = MemoryStack.stackGet().floats(x)
        fun floats(x: Float, y: Float): FloatBuffer = MemoryStack.stackGet().floats(x, y)
        fun floats(x: Float, y: Float, z: Float): FloatBuffer = MemoryStack.stackGet().floats(x, y, z)
        fun floats(x: Float, y: Float, z: Float, w: Float): FloatBuffer = MemoryStack.stackGet().floats(x, y, z, w)
        fun floats(vararg values: Float): FloatBuffer = MemoryStack.stackGet().floats(*values)

        // -------------------------------------------------

        fun mallocDouble(size: Int): DoubleBuffer = MemoryStack.stackGet().mallocDouble(size)
        fun callocDouble(size: Int): DoubleBuffer = MemoryStack.stackGet().callocDouble(size)
        fun doubles(x: Double): DoubleBuffer = MemoryStack.stackGet().doubles(x)
        fun doubles(x: Double, y: Double): DoubleBuffer = MemoryStack.stackGet().doubles(x, y)
        fun doubles(x: Double, y: Double, z: Double): DoubleBuffer = MemoryStack.stackGet().doubles(x, y, z)
        fun doubles(x: Double, y: Double, z: Double, w: Double): DoubleBuffer = MemoryStack.stackGet().doubles(x, y, z, w)
        fun doubles(vararg values: Double): DoubleBuffer = MemoryStack.stackGet().doubles(*values)

        // -------------------------------------------------

        fun mallocPointer(size: Int): PointerBuffer = MemoryStack.stackGet().mallocPointer(size)
        fun callocPointer(size: Int): PointerBuffer = MemoryStack.stackGet().callocPointer(size)
        fun pointers(x: Long): PointerBuffer = MemoryStack.stackGet().pointers(x)
        fun pointers(x: Long, y: Long): PointerBuffer = MemoryStack.stackGet().pointers(x, y)
        fun pointers(x: Long, y: Long, z: Long): PointerBuffer = MemoryStack.stackGet().pointers(x, y, z)
        fun pointers(x: Long, y: Long, z: Long, w: Long): PointerBuffer = MemoryStack.stackGet().pointers(x, y, z, w)
        fun pointers(vararg values: Long): PointerBuffer = MemoryStack.stackGet().pointers(*values)
        fun pointers(x: Pointer): PointerBuffer = MemoryStack.stackGet().pointers(x)
        fun pointers(x: Pointer, y: Pointer): PointerBuffer = MemoryStack.stackGet().pointers(x, y)
        fun pointers(x: Pointer, y: Pointer, z: Pointer): PointerBuffer = MemoryStack.stackGet().pointers(x, y, z)
        fun pointers(x: Pointer, y: Pointer, z: Pointer, w: Pointer): PointerBuffer = MemoryStack.stackGet().pointers(x, y, z, w)
        fun pointers(vararg values: Pointer): PointerBuffer = MemoryStack.stackGet().pointers(*values)

        // -------------------------------------------------

        fun ascii(text: CharSequence, nullTerminated: Boolean = true): ByteBuffer = MemoryStack.stackGet().ASCII(text, nullTerminated)

        @JvmName("asciiSafe")
        fun ascii(text: CharSequence?, nullTerminated: Boolean = true): ByteBuffer? = text?.let { ascii(it, nullTerminated) }

        fun utf8(text: CharSequence, nullTerminated: Boolean = true): ByteBuffer = MemoryStack.stackGet().UTF8(text, nullTerminated)

        @JvmName("utf8Safe")
        fun utf8(text: CharSequence?, nullTerminated: Boolean = true): ByteBuffer? = text?.let { utf8(it, nullTerminated) }

        fun utf16(text: CharSequence, nullTerminated: Boolean = true): ByteBuffer = MemoryStack.stackGet().UTF16(text, nullTerminated)

        @JvmName("utf16Safe")
        fun utf16(text: CharSequence?, nullTerminated: Boolean): ByteBuffer? = text?.let { utf16(it, nullTerminated) }
    }
}