package vkk

import glm_.L
import glm_.bitCount
import glm_.i
import kool.*
import org.lwjgl.BufferUtils
import org.lwjgl.CLongBuffer
import org.lwjgl.PointerBuffer
import org.lwjgl.system.*
import org.lwjgl.system.Checks.CHECKS
import vkk._10.VkStack_VK10
import java.nio.*


/**
 * An off-heap memory stack.
 *
 * <p>This class should be used in a thread-local manner for stack allocations.</p>
 *
 * @see Configuration#STACK_SIZE
 * @see Configuration#DEBUG_STACK
 */
class VkStack internal constructor(val container: ByteBuffer?, address: Adr, val size: Int) :
        Pointer.Default(address),
        AutoCloseable,
        VkStack_VK10 {

    override val vkStack: VkStack
        get() = this

    /**
     * Returns the current stack pointer.
     *
     * <p>The stack grows "downwards", so when the stack is empty {@code pointer} is equal to {@code size}. On every allocation {@code pointer} is reduced by
     * the allocated size (after alignment) and {@code address + pointer} points to the first byte of the last allocation.</p>
     *
     * <p>Effectively, this methods returns how many more bytes may be allocated on the stack.</p>
     */
    var pointer = size
        /**
         * Sets the current stack pointer.
         *
         * <p>This method directly manipulates the stack pointer. Using it irresponsibly may break the internal state of the stack. It should only be used in rare
         * cases or in auto-generated code.</p>
         */
        set(value) {
            if (CHECKS) checkPointer(value)
            field = value
        }

    var frames = IntArray(DEFAULT_STACK_FRAMES)
    protected var frameIndex = 0

    val pointerAddress: Adr
        get() = address + (pointer and 0xFFFFFFFFL.i)

    private val TLS = ThreadLocal.withInitial { VkStack() }

    /**
     * Creates a new `VkStack` with the specified size.
     *
     *
     * In the initial state, there is no active stack frame. The [.push] method must be used before any allocations.
     *
     * @param capacity the maximum number of bytes that may be allocated on the stack
     */
    constructor(capacity: Int = DEFAULT_STACK_SIZE) : this(BufferUtils.createByteBuffer(capacity))

    /**
     * Creates a new `VkStack` backed by the specified memory buffer.
     *
     *
     * In the initial state, there is no active stack frame. The [.push] method must be used before any allocations.
     *
     * @param buffer the backing memory buffer
     */
    constructor(buffer: ByteBuffer) : this(buffer, buffer.adr, buffer.rem)

    /**
     * Creates a new `VkStack` backed by the specified memory region.
     *
     *
     * In the initial state, there is no active stack frame. The [.push] method must be used before any allocations.
     *
     * @param address the backing memory address
     * @param size    the backing memory size
     */
    constructor(address: Adr, size: Int) : this(null, address, size)

    inline operator fun <R> invoke(block: () -> R): R {
        val ptr = pointer
        return block().also {
            pointer = ptr
        }
    }

    inline fun <R> framed(block: () -> R): R {
        val ptr = pointer
        return block().also {
            pointer = ptr
        }
    }

    /**
     * Stores the current stack pointer and pushes a new frame to the stack.
     *
     *
     * This method should be called when entering a method, before doing any stack allocations. When exiting a method, call the [.pop] method to
     * restore the previous stack frame.
     *
     *
     * Pairs of push/pop calls may be nested. Care must be taken to:
     *
     *  * match every push with a pop
     *  * not call pop before push has been called at least once
     *  * not nest push calls to more than the maximum supported depth
     *
     *
     * @return this stack
     */
    fun push() {
        if (frameIndex == frames.size) frameOverflow()
        frames[frameIndex++] = pointer
    }

    private fun frameOverflow() {
        if (Checks.DEBUG) APIUtil.apiLog("[WARNING] Out of frame stack space (" + frames.size + ") in thread: " + Thread.currentThread())
        frames = frames.copyOf(frames.size * 3 / 2)
    }

    /**
     * Pops the current stack frame and moves the stack pointer to the end of the previous stack frame.
     *
     * @return this stack
     */
    fun pop() {
        pointer = frames[--frameIndex]
    }

    /**
     * Calls [.pop] on this `VkStack`.
     *
     *
     * This method should not be used directly. It is called automatically when the `VkStack` is used as a resource in a try-with-resources
     * statement.
     */
    override fun close() = pop()

    private fun checkPointer(pointer: Int) {
        if (pointer < 0 || size < pointer) throw IndexOutOfBoundsException("Invalid stack pointer")
    }

    private fun checkAlignment(alignment: Int) = require(alignment.bitCount == 1) { "Alignment must be a power-of-two value." }


    /**
     * Calls [.nmalloc] with `alignment` equal to 1.
     *
     * @param size the allocation size
     *
     * @return the memory address on the stack for the requested allocation
     */
    fun nmalloc(size: Int): Adr = nmalloc(1, size)

    /**
     * Allocates a block of `size` bytes of memory on the stack. The content of the newly allocated block of memory is not initialized, remaining with
     * indeterminate values.
     *
     * @param alignment the required alignment
     * @param size      the allocation size
     *
     * @return the memory address on the stack for the requested allocation
     */
    fun nmalloc(alignment: Int, size: Int): Adr {
        // Align address to the specified alignment
        val address = address + pointer - size and Integer.toUnsignedLong(alignment - 1).inv()
        pointer = (address - this.address).toInt()
        if (CHECKS && pointer < 0) throw OutOfMemoryError("Out of stack space.")
        return address
    }

    /**
     * Allocates a block of memory on the stack for an array of `num` elements, each of them `size` bytes long, and initializes all its bits to
     * zero.
     *
     * @param alignment the required element alignment
     * @param num       num  the number of elements to allocate
     * @param size      the size of each element
     *
     * @return the memory address on the stack for the requested allocation
     */
    fun ncalloc(alignment: Int, num: Int, size: Int): Long {
        val bytes = num * size
        val address = nmalloc(alignment, bytes)
        MemoryUtil.memSet(address, 0, bytes.L)
        return address
    }

    // -------------------------------------------------

    // -------------------------------------------------
    /**
     * Allocates an aligned [ByteBuffer] on the stack.
     *
     * @param alignment the required buffer alignment
     * @param size      the number of elements in the buffer
     *
     * @return the allocated buffer
     */
    fun malloc(alignment: Int, size: Int): ByteBuffer {
        if (Checks.DEBUG) checkAlignment(alignment)
        return MemoryUtil.memByteBuffer(nmalloc(alignment, size), size)
    }

    /** Calloc version of [.malloc].  */
    fun calloc(alignment: Int, size: Int): ByteBuffer {
        if (Checks.DEBUG) checkAlignment(alignment)
        return MemoryUtil.memByteBuffer(ncalloc(alignment, size, 1), size)
    }

    /**
     * Allocates a [ByteBuffer] on the stack.
     *
     * @param size the number of elements in the buffer
     *
     * @return the allocated buffer
     */
    fun malloc(size: Int): ByteBuffer = malloc(1, size)

    /** Calloc version of [.malloc].  */
    fun calloc(size: Int): ByteBuffer = calloc(1, size)

    fun bytes(x: Byte): ByteBuffer = malloc(1, 1).put(0, x)
    fun bytes(x: Byte, y: Byte): ByteBuffer = malloc(1, 2).put(0, x).put(1, y)
    fun bytes(x: Byte, y: Byte, z: Byte): ByteBuffer = malloc(1, 3).put(0, x).put(1, y).put(2, z)
    fun bytes(x: Byte, y: Byte, z: Byte, w: Byte): ByteBuffer = malloc(1, 4).put(0, x).put(1, y).put(2, z).put(3, w)
    fun bytes(vararg values: Byte): ByteBuffer = malloc(1, values.size).put(values).apply { flip() }

    // -------------------------------------------------

    fun mallocShort(size: Int): ShortBuffer = MemoryUtil.memShortBuffer(nmalloc(2, size shl 1), size)
    fun callocShort(size: Int): ShortBuffer {
        val bytes = size * 2
        val address = nmalloc(2, bytes)
        MemoryUtil.memSet(address, 0, bytes.L)
        return MemoryUtil.memShortBuffer(address, size)
    }

    fun shorts(x: Short): ShortBuffer = mallocShort(1).put(0, x)
    fun shorts(x: Short, y: Short): ShortBuffer = mallocShort(2).put(0, x).put(1, y)
    fun shorts(x: Short, y: Short, z: Short): ShortBuffer = mallocShort(3).put(0, x).put(1, y).put(2, z)
    fun shorts(x: Short, y: Short, z: Short, w: Short): ShortBuffer = mallocShort(4).put(0, x).put(1, y).put(2, z).put(3, w)
    fun shorts(vararg values: Short): ShortBuffer = mallocShort(values.size).put(values).apply { flip() }

    // -------------------------------------------------

    fun mallocInt(size: Int): IntBuffer = MemoryUtil.memIntBuffer(nmalloc(4, size shl 2), size)
    fun callocInt(size: Int): IntBuffer {
        val bytes = size * 4
        val address = nmalloc(4, bytes)
        MemoryUtil.memSet(address, 0, bytes.L)
        return MemoryUtil.memIntBuffer(address, size)
    }

    fun ints(x: Int): IntBuffer = mallocInt(1).put(0, x)
    fun ints(x: Int, y: Int): IntBuffer = mallocInt(2).put(0, x).put(1, y)
    fun ints(x: Int, y: Int, z: Int): IntBuffer = mallocInt(3).put(0, x).put(1, y).put(2, z)
    fun ints(x: Int, y: Int, z: Int, w: Int): IntBuffer = mallocInt(4).put(0, x).put(1, y).put(2, z).put(3, w)
    fun ints(vararg values: Int): IntBuffer = mallocInt(values.size).put(values).apply { flip() }

    // -------------------------------------------------

    fun mallocLong(size: Int): LongBuffer = MemoryUtil.memLongBuffer(nmalloc(8, size shl 3), size)
    fun callocLong(size: Int): LongBuffer {
        val bytes = size * 8
        val address = nmalloc(8, bytes)
        MemoryUtil.memSet(address, 0, bytes.L)
        return MemoryUtil.memLongBuffer(address, size)
    }

    fun longs(x: Long): LongBuffer = mallocLong(1).put(0, x)
    fun longs(x: Long, y: Long): LongBuffer = mallocLong(2).put(0, x).put(1, y)
    fun longs(x: Long, y: Long, z: Long): LongBuffer = mallocLong(3).put(0, x).put(1, y).put(2, z)
    fun longs(x: Long, y: Long, z: Long, w: Long): LongBuffer = mallocLong(4).put(0, x).put(1, y).put(2, z).put(3, w)
    fun longs(vararg more: Long): LongBuffer = mallocLong(more.size).put(more).apply { flip() }

    // -------------------------------------------------

    fun mallocCLong(size: Int): CLongBuffer = wrap(CLongBuffer::class.java, nmalloc(Pointer.CLONG_SIZE, size shl Pointer.CLONG_SHIFT), size)
    fun callocCLong(size: Int): CLongBuffer {
        val bytes = size * Pointer.CLONG_SIZE
        val address = nmalloc(Pointer.CLONG_SIZE, bytes)
        MemoryUtil.memSet(address, 0, bytes.L)
        return wrap(CLongBuffer::class.java, address, size)
    }

    fun clongs(x: Long): CLongBuffer = mallocCLong(1).put(0, x)
    fun clongs(x: Long, y: Long): CLongBuffer = mallocCLong(2).put(0, x).put(1, y)
    fun clongs(x: Long, y: Long, z: Long): CLongBuffer = mallocCLong(3).put(0, x).put(1, y).put(2, z)
    fun clongs(x: Long, y: Long, z: Long, w: Long): CLongBuffer = mallocCLong(4).put(0, x).put(1, y).put(2, z).put(3, w)
    fun clongs(vararg values: Long): CLongBuffer = mallocCLong(values.size).put(values).apply { flip() }

    // -------------------------------------------------

    fun mallocFloat(size: Int): FloatBuffer = MemoryUtil.memFloatBuffer(nmalloc(4, size shl 2), size)
    fun callocFloat(size: Int): FloatBuffer {
        val bytes = size * 4
        val address = nmalloc(4, bytes)
        MemoryUtil.memSet(address, 0, bytes.L)
        return MemoryUtil.memFloatBuffer(address, size)
    }

    fun floats(x: Float): FloatBuffer = mallocFloat(1).put(0, x)
    fun floats(x: Float, y: Float): FloatBuffer = mallocFloat(2).put(0, x).put(1, y)
    fun floats(x: Float, y: Float, z: Float): FloatBuffer = mallocFloat(3).put(0, x).put(1, y).put(2, z)
    fun floats(x: Float, y: Float, z: Float, w: Float): FloatBuffer = mallocFloat(4).put(0, x).put(1, y).put(2, z).put(3, w)
    fun floats(vararg values: Float): FloatBuffer = mallocFloat(values.size).put(values).apply { flip() }

    // -------------------------------------------------

    fun mallocDouble(size: Int): DoubleBuffer = MemoryUtil.memDoubleBuffer(nmalloc(8, size shl 3), size)
    fun callocDouble(size: Int): DoubleBuffer {
        val bytes = size * 8
        val address = nmalloc(8, bytes)
        MemoryUtil.memSet(address, 0, bytes.L)
        return MemoryUtil.memDoubleBuffer(address, size)
    }

    fun doubles(x: Double): DoubleBuffer = mallocDouble(1).put(0, x)
    fun doubles(x: Double, y: Double): DoubleBuffer = mallocDouble(2).put(0, x).put(1, y)
    fun doubles(x: Double, y: Double, z: Double): DoubleBuffer = mallocDouble(3).put(0, x).put(1, y).put(2, z)
    fun doubles(x: Double, y: Double, z: Double, w: Double): DoubleBuffer = mallocDouble(4).put(0, x).put(1, y).put(2, z).put(3, w)
    fun doubles(vararg values: Double): DoubleBuffer = mallocDouble(values.size).put(values).apply { flip() }

    // -------------------------------------------------

    fun mallocPointer(size: Int): PointerBuffer = wrap(PointerBuffer::class.java, nmalloc(Pointer.POINTER_SIZE, size shl Pointer.POINTER_SHIFT), size)
    fun callocPointer(size: Int): PointerBuffer {
        val bytes = size * Pointer.POINTER_SIZE
        val address = nmalloc(Pointer.POINTER_SIZE, bytes)
        MemoryUtil.memSet(address, 0, bytes.L)
        return wrap(PointerBuffer::class.java, address, size)
    }

    fun pointers(x: Long): PointerBuffer = mallocPointer(1).put(0, x)
    fun pointers(x: Long, y: Long): PointerBuffer = mallocPointer(2).put(0, x).put(1, y)
    fun pointers(x: Long, y: Long, z: Long): PointerBuffer = mallocPointer(3).put(0, x).put(1, y).put(2, z)
    fun pointers(x: Long, y: Long, z: Long, w: Long): PointerBuffer = mallocPointer(4).put(0, x).put(1, y).put(2, z).put(3, w)
    fun pointers(vararg values: Long): PointerBuffer = mallocPointer(values.size).put(values).apply { flip() }

    /** Single value version of [.mallocPointer].  */
    fun pointers(x: Pointer): PointerBuffer = mallocPointer(1).put(0, x)
    fun pointers(x: Pointer, y: Pointer): PointerBuffer = mallocPointer(2).put(0, x).put(1, y)
    fun pointers(x: Pointer, y: Pointer, z: Pointer): PointerBuffer = mallocPointer(3).put(0, x).put(1, y).put(2, z)
    fun pointers(x: Pointer, y: Pointer, z: Pointer, w: Pointer): PointerBuffer = mallocPointer(4).put(0, x).put(1, y).put(2, z).put(3, w)
    fun pointers(vararg values: Pointer): PointerBuffer {
        val buffer = mallocPointer(values.size)
        for (i in values.indices) buffer.put(i, values[i])
        return buffer
    }

    fun pointers(x: Buffer): PointerBuffer = mallocPointer(1).put(0, x.adr)
    fun pointers(x: Buffer, y: Buffer): PointerBuffer = mallocPointer(2).put(0, x.adr).put(1, y.adr)
    fun pointers(x: Buffer, y: Buffer, z: Buffer): PointerBuffer = mallocPointer(3).put(0, x.adr).put(1, y.adr).put(2, z.adr)
    fun pointers(x: Buffer, y: Buffer, z: Buffer, w: Buffer): PointerBuffer = mallocPointer(4).put(0, x.adr).put(1, y.adr).put(2, z.adr).put(3, w.adr)
    fun pointers(vararg values: Buffer): PointerBuffer {
        val buffer = mallocPointer(values.size)
        for (i in values.indices) buffer.put(i, MemoryUtil.memAddress(values[i]))
        return buffer
    }

    // -------------------------------------------------

    /**
     * Encodes the specified text on the stack using ASCII encoding and returns a ByteBuffer that points to the encoded text, including a null-terminator.
     *
     * @param text the text to encode
     */
    fun ASCII(text: CharSequence): ByteBuffer = ASCII(text, true)

    /**
     * Encodes the specified text on the stack using ASCII encoding and returns a ByteBuffer that points to the encoded text.
     *
     * @param text           the text to encode
     * @param nullTerminated if true, a null-terminator is included at the end of the encoded text
     */
    fun ASCII(text: CharSequence, nullTerminated: Boolean): ByteBuffer {
        val length = MemoryUtil.memLengthASCII(text, nullTerminated)
        val target = nmalloc(1, length)
        encodeASCII(text, nullTerminated, target)
        return MemoryUtil.memByteBuffer(target, length)
    }

    /**
     * Encodes the specified text on the stack using ASCII encoding and returns the encoded text length, in bytes.
     *
     *
     * Use [.getPointerAddress] immediately after this method to get the encoded text address.
     *
     * @param text           the text to encode
     * @param nullTerminated if true, a null-terminator is included at the end of the encoded text
     */
    fun nASCII(text: CharSequence, nullTerminated: Boolean): Int = encodeASCII(text, nullTerminated, nmalloc(1, MemoryUtil.memLengthASCII(text, nullTerminated)))

    /** Like [ASCII][.ASCII], but returns `null` if `text` is `null`.  */
    fun ASCIISafe(text: CharSequence?): ByteBuffer? = ASCIISafe(text, true)

    /** Like [ASCII][.ASCII], but returns `null` if `text` is `null`.  */
    fun ASCIISafe(text: CharSequence?, nullTerminated: Boolean): ByteBuffer? = text?.let { ASCII(it, nullTerminated) }

    /** Like [nASCII][.nASCII], but returns 0 if `text` is `null`.  */
    fun nASCIISafe(text: CharSequence?, nullTerminated: Boolean): Int = text?.let { nASCII(it, nullTerminated) } ?: 0

    /**
     * Encodes the specified text on the stack using UTF8 encoding and returns a ByteBuffer that points to the encoded text, including a null-terminator.
     *
     * @param text the text to encode
     */
    fun UTF8(text: CharSequence): ByteBuffer = UTF8(text, true)

    /**
     * Encodes the specified text on the stack using UTF8 encoding and returns a ByteBuffer that points to the encoded text.
     *
     * @param text           the text to encode
     * @param nullTerminated if true, a null-terminator is included at the end of the encoded text
     */
    fun UTF8(text: CharSequence, nullTerminated: Boolean): ByteBuffer {
        val length = MemoryUtil.memLengthUTF8(text, nullTerminated)
        val target = nmalloc(1, length)
        encodeUTF8(text, nullTerminated, target)
        return MemoryUtil.memByteBuffer(target, length)
    }

    /**
     * Encodes the specified text on the stack using UTF8 encoding and returns the encoded text length, in bytes.
     *
     *
     * Use [.getPointerAddress] immediately after this method to get the encoded text address.
     *
     * @param text           the text to encode
     * @param nullTerminated if true, a null-terminator is included at the end of the encoded text
     */
    fun nUTF8(text: CharSequence, nullTerminated: Boolean): Int = encodeUTF8(text, nullTerminated, nmalloc(1, MemoryUtil.memLengthUTF8(text, nullTerminated)))

    /** Like [UTF8][.UTF8], but returns `null` if `text` is `null`.  */
    fun UTF8Safe(text: CharSequence?): ByteBuffer? = UTF8Safe(text, true)

    /** Like [UTF8][.UTF8], but returns `null` if `text` is `null`.  */
    fun UTF8Safe(text: CharSequence?, nullTerminated: Boolean): ByteBuffer? = text?.let { UTF8(it, nullTerminated) }

    /** Like [nUTF8][.nUTF8], but returns 0 if `text` is `null`.  */
    fun nUTF8Safe(text: CharSequence?, nullTerminated: Boolean): Int = text?.let { nUTF8(it, nullTerminated) } ?: 0

    /**
     * Encodes the specified text on the stack using UTF16 encoding and returns a ByteBuffer that points to the encoded text, including a null-terminator.
     *
     * @param text the text to encode
     */
    fun UTF16(text: CharSequence): ByteBuffer = UTF16(text, true)

    /**
     * Encodes the specified text on the stack using UTF16 encoding and returns a ByteBuffer that points to the encoded text.
     *
     * @param text           the text to encode
     * @param nullTerminated if true, a null-terminator is included at the end of the encoded text
     */
    fun UTF16(text: CharSequence, nullTerminated: Boolean): ByteBuffer {
        val length = MemoryUtil.memLengthUTF16(text, nullTerminated)
        val target = nmalloc(2, length)
        encodeUTF16(text, nullTerminated, target)
        return MemoryUtil.memByteBuffer(target, length)
    }

    /**
     * Encodes the specified text on the stack using UTF16 encoding and returns the encoded text length, in bytes.
     *
     *
     * Use [.getPointerAddress] immediately after this method to get the encoded text address.
     *
     * @param text           the text to encode
     * @param nullTerminated if true, a null-terminator is included at the end of the encoded text
     */
    fun nUTF16(text: CharSequence, nullTerminated: Boolean): Int = encodeUTF16(text, nullTerminated, nmalloc(2, MemoryUtil.memLengthUTF16(text, nullTerminated)))

    /** Like [UTF16][.UTF16], but returns `null` if `text` is `null`.  */
    fun UTF16Safe(text: CharSequence?): ByteBuffer? = UTF16Safe(text, true)

    /** Like [UTF16][.UTF16], but returns `null` if `text` is `null`.  */
    fun UTF16Safe(text: CharSequence?, nullTerminated: Boolean): ByteBuffer? = text?.let { UTF16(it, nullTerminated) }

    /** Like [nUTF16][.nUTF16], but returns 0 if `text` is `null`.  */
    fun nUTF16Safe(text: CharSequence?, nullTerminated: Boolean): Int = text?.let { nUTF16(it, nullTerminated) } ?: 0


    inline fun mByte(count: Int = 1) = BytePtr(nmalloc(Byte.BYTES, Byte.BYTES * count))
    inline fun mShort(count: Int = 1) = ShortPtr(nmalloc(Short.BYTES, Short.BYTES * count))
    inline fun mInt(count: Int = 1) = IntPtr(nmalloc(Int.BYTES, Int.BYTES * count))
    inline fun mLong(count: Int = 1) = LongPtr(nmalloc(Long.BYTES, Long.BYTES * count))
    inline fun mFloat(count: Int = 1) = FloatPtr(nmalloc(Float.BYTES, Float.BYTES * count))
    inline fun mDouble(count: Int = 1) = DoublePtr(nmalloc(Double.BYTES, Double.BYTES * count))
    inline fun mPointer(count: Int = 1) = PointerPtr(nmalloc(Long.BYTES, Long.BYTES * count))

    inline fun cByte(count: Int = 1) = BytePtr(ncalloc(Byte.BYTES, count, Byte.BYTES))
    inline fun cShort(count: Int = 1) = ShortPtr(ncalloc(Short.BYTES, count, Short.BYTES))
    inline fun cInt(count: Int = 1) = IntPtr(ncalloc(Int.BYTES, count, Int.BYTES))
    inline fun cLong(count: Int = 1) = LongPtr(ncalloc(Long.BYTES, count, Long.BYTES))
    inline fun cFloat(count: Int = 1) = FloatPtr(ncalloc(Float.BYTES, count, Float.BYTES))
    inline fun cDouble(count: Int = 1) = DoublePtr(ncalloc(Double.BYTES, count, Double.BYTES))
    inline fun cPointer(count: Int = 1) = PointerPtr(ncalloc(Long.BYTES, count, Long.BYTES))

    fun reset() {
        pointer = Configuration.STACK_SIZE.get(64) * 1024
    }

    fun ptrOf(b: Byte): BytePtr = mByte(1).also { it[0] = b }
    fun ptrOf(b0: Byte, b1: Byte): BytePtr = mByte(2).also { it[0] = b0; it[1] = b1 }
    fun ptrOf(b0: Byte, b1: Byte, b2: Byte): BytePtr = mByte(3).also { it[0] = b0; it[1] = b1; it[2] = b2 }
    fun ptrOf(b0: Byte, b1: Byte, b2: Byte, b3: Byte): BytePtr = mByte(4).also { it[0] = b0; it[1] = b1; it[2] = b2; it[3] = b3 }
    fun ptrOf(vararg bytes: Byte): BytePtr = mByte(bytes.size).also { for (i in bytes.indices) it[i] = bytes[i] }

    fun ptrOf(s: Short): ShortPtr = mShort(1).also { it[0] = s }
    fun ptrOf(s0: Short, s1: Short): ShortPtr = mShort(2).also { it[0] = s0; it[1] = s1 }
    fun ptrOf(s0: Short, s1: Short, s2: Short): ShortPtr = mShort(3).also { it[0] = s0; it[1] = s1; it[2] = s2 }
    fun ptrOf(s0: Short, s1: Short, s2: Short, s3: Short): ShortPtr = mShort(4).also { it[0] = s0; it[1] = s1; it[2] = s2; it[3] = s3 }
    fun ptrOf(vararg shorts: Short): ShortPtr = mShort(shorts.size).also { for (i in shorts.indices) it[i] = shorts[i] }

    fun ptrOf(i: Int): IntPtr = mInt(1).also { it[0] = i }
    fun ptrOf(i0: Int, i1: Int): IntPtr = mInt(2).also { it[0] = i0; it[1] = i1 }
    fun ptrOf(i0: Int, i1: Int, i2: Int): IntPtr = mInt(3).also { it[0] = i0; it[1] = i1; it[2] = i2 }
    fun ptrOf(i0: Int, i1: Int, i2: Int, i3: Int): IntPtr = mInt(4).also { it[0] = i0; it[1] = i1; it[2] = i2; it[3] = i3 }
    fun ptrOf(vararg ints: Int): IntPtr = mInt(ints.size).also { for (i in ints.indices) it[i] = ints[i] }

    fun ptrOf(L: Long): LongPtr = mLong(1).also { it[0] = L }
    fun ptrOf(L0: Long, L1: Long): LongPtr = mLong(2).also { it[0] = L0; it[1] = L1 }
    fun ptrOf(L0: Long, L1: Long, L2: Long): LongPtr = mLong(3).also { it[0] = L0; it[1] = L1; it[2] = L2 }
    fun ptrOf(L0: Long, L1: Long, L2: Long, L3: Long): LongPtr = mLong(4).also { it[0] = L0; it[1] = L1; it[2] = L2; it[3] = L3 }
    fun ptrOf(vararg longs: Long): LongPtr = mLong(longs.size).also { for (i in longs.indices) it[i] = longs[i] }

    fun ptrOf(f: Float): FloatPtr = mFloat(1).also { it[0] = f }
    fun ptrOf(f0: Float, f1: Float): FloatPtr = mFloat(2).also { it[0] = f0; it[1] = f1 }
    fun ptrOf(f0: Float, f1: Float, f2: Float): FloatPtr = mFloat(3).also { it[0] = f0; it[1] = f1; it[2] = f2 }
    fun ptrOf(f0: Float, f1: Float, f2: Float, f3: Float): FloatPtr = mFloat(4).also { it[0] = f0; it[1] = f1; it[2] = f2; it[3] = f3 }
    fun ptrOf(vararg floats: Float): FloatPtr = mFloat(floats.size).also { for (i in floats.indices) it[i] = floats[i] }

    fun ptrOf(d: Double): DoublePtr = mDouble(1).also { it[0] = d }
    fun ptrOf(d0: Double, d1: Double): DoublePtr = mDouble(2).also { it[0] = d0; it[1] = d1 }
    fun ptrOf(d0: Double, d1: Double, d2: Double): DoublePtr = mDouble(3).also { it[0] = d0; it[1] = d1; it[2] = d2 }
    fun ptrOf(d0: Double, d1: Double, d2: Double, d3: Double): DoublePtr = mDouble(4).also { it[0] = d0; it[1] = d1; it[2] = d2; it[3] = d3 }
    fun ptrOf(vararg doubles: Double): DoublePtr = mDouble(doubles.size).also { for (i in doubles.indices) it[i] = doubles[i] }

    fun ptrOf(p: Pointer): PointerPtr = mPointer(1).also { it[0] = p }
//fun VrStack.ptrOf(d0: Double, d1: Double): DoublePtr = mDouble(2).also { it[0] = d0; it[1] = d1 }
//fun VrStack.ptrOf(d0: Double, d1: Double, d2: Double): DoublePtr = mDouble(3).also { it[0] = d0; it[1] = d1; it[2] = d2 }
//fun VrStack.ptrOf(d0: Double, d1: Double, d2: Double, d3: Double): DoublePtr = mDouble(4).also { it[0] = d0; it[1] = d1; it[2] = d2; it[3] = d3 }
//fun VrStack.ptrOf(vararg doubles: Double): DoublePtr = mDouble(doubles.size).also { for(i in doubles.indices) it[i] = doubles[i] }


// --------------------------------------------- getters ---------------------------------------------

    inline fun <R> byteAdr(block: (Adr) -> R): Byte {
        val pByte = mByte()
        block(pByte.adr)
        return pByte()
    }

    inline fun <R> byteBuffer(block: (ByteBuffer) -> R): Byte {
        val buf = malloc(1)
        block(buf)
        return buf[0]
    }

    inline fun <R> shortAdr(block: (Adr) -> R): Short {
        val pShort = mShort()
        block(pShort.adr)
        return pShort()
    }

    inline fun <R> shortBuffer(block: (ShortBuffer) -> R): Short {
        val buf = mallocShort(1)
        block(buf)
        return buf[0]
    }

    inline fun <R> intAdr(block: (Adr) -> R): Int {
        val pInt = mInt()
        block(pInt.adr)
        return pInt()
    }

    inline fun <R> intBuffer(block: (IntBuffer) -> R): Int {
        val buf = mallocInt(1)
        block(buf)
        return buf[0]
    }

    inline fun <R> longAdr(block: (Adr) -> R): Long {
        val pLong = mLong()
        block(pLong.adr)
        return pLong()
    }

    inline fun <R> longBuffer(block: (LongBuffer) -> R): Long {
        val buf = mallocLong(1)
        block(buf)
        return buf[0]
    }

    inline fun <R> floatAdr(block: (Adr) -> R): Float {
        val pFloat = mFloat()
        block(pFloat.adr)
        return pFloat()
    }

    inline fun <R> floatBuffer(block: (FloatBuffer) -> R): Float {
        val buf = mallocFloat(1)
        block(buf)
        return buf[0]
    }

    inline fun <R> doubleAdr(block: (Adr) -> R): Double {
        val pDouble = mDouble()
        block(pDouble.adr)
        return pDouble()
    }

    inline fun <R> doubleBuffer(block: (DoubleBuffer) -> R): Double {
        val buf = mallocDouble(1)
        block(buf)
        return buf[0]
    }

    inline fun <R> pointerAdr(block: (Adr) -> R): Ptr {
        val pointer = mPointer()
        block(pointer.adr)
        return pointer()
    }

    inline fun <R> pointerBuffer(block: (PointerBuffer) -> R): Ptr {
        val buf = mallocPointer(1)
        block(buf)
        return buf[0]
    }

    /** It mallocs, passes the address and reads the null terminated string */
    inline fun <R> asciiAdr(maxSize: Int, block: (Adr) -> R): String {
        val adr = nmalloc(1, maxSize)
        block(adr)
        return MemoryUtil.memASCII(adr, strlen64NT1(adr, maxSize))
    }

    /** It malloc the buffer, passes it and reads the null terminated string */
    inline fun <R> asciiBuffer(maxSize: Int, block: (ByteBuffer) -> R): String {
        val buf = malloc(1, maxSize)
        block(buf)
        return MemoryUtil.memASCII(buf.adr, maxSize)
    }

    // --------------------------------------------- setters ---------------------------------------------
// mainly for syntax consistence
    inline fun asciiAdr(chars: CharSequence, nullTerminated: Boolean = true): Adr = nASCII(chars, nullTerminated).let { pointerAddress }
    inline fun asciiBuffer(chars: CharSequence, nullTerminated: Boolean = true): ByteBuffer = ASCII(chars, nullTerminated)
    inline fun <R> asciiAdr(chars: CharSequence, nullTerminated: Boolean = true, block: (Adr) -> R) = framed { nASCII(chars, nullTerminated); block(pointerAddress); }
    inline fun <R> asciiBuffer(chars: CharSequence, nullTerminated: Boolean = true, block: (ByteBuffer) -> R) = framed { block(ASCII(chars, nullTerminated)) }

//@JvmName("asciiAdrSafe")
//inline fun VrStack.asciiAdr(chars: CharSequence?, nullTerminated: Boolean = true): Adr = chars?.let { asciiAdr(it, nullTerminated) } ?: NULL

    inline fun byteAdrOf(byte: Byte) = ptrOf(byte).adr
    inline fun byteBufferOf(byte: Byte) = bytes(byte)

    inline fun shortAdrOf(short: Short) = ptrOf(short).adr
    inline fun shortBufferOf(short: Short) = shorts(short)

    inline fun intAdrOf(int: Int) = ptrOf(int).adr
    inline fun intBufferOf(int: Int) = ints(int)

    inline fun longAdrOf(long: Long) = ptrOf(long).adr
    inline fun longBufferOf(long: Long) = longs(long)

    inline fun floatAdrOf(float: Float) = ptrOf(float).adr
    inline fun floatBufferOf(float: Float) = floats(float)

    inline fun doubleAdrOf(double: Double) = ptrOf(double).adr
    inline fun doubleBufferOf(double: Double) = doubles(double)

    inline fun pointerAdrOf(pointer: Pointer) = ptrOf(pointer).adr
    inline fun pointerBufferOf(pointer: Pointer) = pointers(pointer)

    inline fun <R> byteAdr(byte: Byte, block: (Adr) -> R): R = block(ptrOf(byte).adr)
    inline fun <R> byteBuffer(byte: Byte, block: (ByteBuffer) -> R): R = block(bytes(byte))

    inline fun <R> shortAdr(short: Short, block: (Adr) -> R): R = block(ptrOf(short).adr)
    inline fun <R> shortBuffer(short: Short, block: (ShortBuffer) -> R): R = block(shorts(short))

    inline fun <R> intAdr(int: Int, block: (Adr) -> R): R = block(ptrOf(int).adr)
    inline fun <R> intBuffer(int: Int, block: (IntBuffer) -> R): R = block(ints(int))

    inline fun <R> longAdr(long: Long, block: (Adr) -> R): R = block(ptrOf(long).adr)
    inline fun <R> longBuffer(long: Long, block: (LongBuffer) -> R): R = block(longs(long))

    inline fun <R> floatAdr(float: Float, block: (Adr) -> R): R = block(ptrOf(float).adr)
    inline fun <R> floatBuffer(float: Float, block: (FloatBuffer) -> R): R = block(floats(float))

    inline fun <R> doubleAdr(double: Double, block: (Adr) -> R): R = block(ptrOf(double).adr)
    inline fun <R> doubleBuffer(double: Double, block: (DoubleBuffer) -> R): R = block(doubles(double))

    inline fun <R> pointerAdr(pointer: Pointer, block: (Adr) -> R): R = block(ptrOf(pointer).adr)
    inline fun <R> pointerBuffer(pointer: Pointer, block: (PointerBuffer) -> R): R = block(pointers(pointer))

    inline fun utf8Adr(chars: CharSequence, nullTerminated: Boolean = true): Adr = nmalloc(1, MemoryUtil.memLengthASCII(chars, nullTerminated)).also { encodeUTF8(chars, nullTerminated, it) }
    inline fun utf8Buffer(chars: CharSequence, nullTerminated: Boolean = true): ByteBuffer = UTF8(chars, true)


    // VrStack version

    fun Buffer(size: Int): ByteBuffer = calloc(size)
    inline fun Buffer(size: Int, init: (Int) -> Byte) = Buffer(size).also { for (i in 0 until size) it[i] = init(i) }

    fun ByteBuffer(size: Int): ByteBuffer = calloc(size)
    inline fun ByteBuffer(size: Int, init: (Int) -> Byte) = ByteBuffer(size).also { for (i in 0 until size) it[i] = init(i) }

    fun ShortBuffer(size: Int): ShortBuffer = callocShort(size)
    inline fun ShortBuffer(size: Int, init: (Int) -> Short) = ShortBuffer(size).also { for (i in 0 until size) it[i] = init(i) }

    fun IntBuffer(size: Int): IntBuffer = callocInt(size)
    inline fun IntBuffer(size: Int, init: (Int) -> Int) = IntBuffer(size).also { for (i in 0 until size) it[i] = init(i) }

    fun LongBuffer(size: Int): LongBuffer = mallocLong(size)
    inline fun LongBuffer(size: Int, init: (Int) -> Long) = LongBuffer(size).also { for (i in 0 until size) it[i] = init(i) }

    fun FloatBuffer(size: Int): FloatBuffer = callocFloat(size)
    inline fun FloatBuffer(size: Int, init: (Int) -> Float) = FloatBuffer(size).also { for (i in 0 until size) it[i] = init(i) }

    fun DoubleBuffer(size: Int): DoubleBuffer = callocDouble(size)
    inline fun DoubleBuffer(size: Int, init: (Int) -> Double) = DoubleBuffer(size).also { for (i in 0 until size) it[i] = init(i) }

    fun PointerBuffer(size: Int): PointerBuffer = callocPointer(size)
    inline fun PointerBuffer(size: Int, init: (Int) -> Adr) = PointerBuffer(size).also { for (i in 0 until size) it[i] = init(i) }
    inline fun PointerBufferP(size: Int, init: (Int) -> Pointer) = PointerBuffer(size).also { for (i in 0 until size) it[i] = init(i) }
    inline fun PointerBufferB(size: Int, init: (Int) -> Buffer) = PointerBuffer(size).also { for (i in 0 until size) it[i] = init(i) }

    @JvmName("PointerBufferSafe")
    fun PointerBuffer(strings: Collection<String>?): PointerBuffer? =
            strings?.let { PointerBuffer(it) }

    fun PointerBuffer(strings: Collection<String>): PointerBuffer =
            PointerBuffer(strings.size) { i ->
                val string = strings.elementAt(i)
                val length = MemoryUtil.memLengthUTF8(string, true)
                nmalloc(1, length).also { encodeUTF8(string, true, it) }
            }

    @JvmName("PointerAdrSafe")
    fun PointerAdr(strings: Collection<String>?): Adr = strings?.let { PointerAdr(it) } ?: MemoryUtil.NULL

    fun PointerAdr(strings: Collection<String>): Adr =
            PointerAdr(strings.size) { i ->
                val string = strings.elementAt(i)
                val length = MemoryUtil.memLengthUTF8(string, true)
                nmalloc(1, length).also { encodeUTF8(string, true, it) }
            }

    inline fun PointerAdr(size: Int, init: (Int) -> Adr): Adr {
        val bytes = size * Pointer.POINTER_SIZE
        val address = nmalloc(Pointer.POINTER_SIZE, bytes)
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
    fun ByteAdr(size: Int, init: (Int) -> Byte): BytePtr = mByte(size).also { for (i in 0 until size) it[i] = init(i) }

    fun Adr(shorts: ShortArray): ShortPtr = ShortPtr(shorts.size) { shorts[it] }
    fun ByteAdr(shorts: ShortArray): BytePtr = BytePtr(Adr(shorts))
    fun ShortAdr(shorts: ShortArray): ShortPtr = Adr(shorts)
    fun ShortAdr(size: Int, init: (Int) -> Short): ShortPtr = mShort(size).also { for (i in 0 until size) it[i] = init(i) }

    fun Adr(ints: IntArray): IntPtr = IntPtr(ints.size) { ints[it] }
    fun ByteAdr(ints: IntArray): BytePtr = BytePtr(Adr(ints))
    fun IntAdr(ints: IntArray): IntPtr = Adr(ints)
    fun IntAdr(size: Int, init: (Int) -> Int): IntPtr = mInt(size).also { for (i in 0 until size) it[i] = init(i) }

    fun Adr(longs: LongArray): LongPtr = LongPtr(longs.size) { longs[it] }
    fun ByteAdr(longs: LongArray): BytePtr = BytePtr(Adr(longs))
    fun LongAdr(longs: LongArray): LongPtr = Adr(longs)
    fun LongAdr(size: Int, init: (Int) -> Long): LongPtr = mLong(size).also { for (i in 0 until size) it[i] = init(i) }

    fun Adr(floats: FloatArray): FloatPtr = FloatPtr(floats.size) { floats[it] }
    fun ByteAdr(floats: FloatArray): BytePtr = BytePtr(Adr(floats))
    fun FloatAdr(floats: FloatArray): FloatPtr = Adr(floats)
    fun FloatAdr(size: Int, init: (Int) -> Float): FloatPtr = mFloat(size).also { for (i in 0 until size) it[i] = init(i) }

    fun Adr(doubles: DoubleArray): DoublePtr = DoublePtr(doubles.size) { doubles[it] }
    fun ByteAdr(doubles: DoubleArray): BytePtr = BytePtr(Adr(doubles))
    fun DoubleAdr(doubles: DoubleArray): DoublePtr = Adr(doubles)
    fun DoubleAdr(size: Int, init: (Int) -> Double): DoublePtr = mDouble(size).also { for (i in 0 until size) it[i] = init(i) }

    companion object {

        operator fun <R> invoke(block: (VkStack) -> R): R {
            val stack = stackGet()
            val ptr = stack.pointer
            val res = block(stack)
            stack.pointer = ptr
            return res
        }

        val DEFAULT_STACK_SIZE = Configuration.STACK_SIZE[64] * 1024
        val DEFAULT_STACK_FRAMES = 8

        init {
            if (DEFAULT_STACK_SIZE < 0) throw IllegalStateException("Invalid stack size.")
        }

        private val TLS = ThreadLocal.withInitial { VkStack() }

        // -----------------------------------------------------
        // -----------------------------------------------------
        // -----------------------------------------------------

        // -----------------------------------------------------
        // -----------------------------------------------------
        // -----------------------------------------------------
        /** Returns the stack of the current thread.  */
        fun stackGet(): VkStack = TLS.get()

        /**
         * Calls [.push] on the stack of the current thread.
         *
         * @return the stack of the current thread.
         */
        fun stackPush(): VkStack = stackGet().apply { push() }

        /**
         * Calls [.pop] on the stack of the current thread.
         *
         * @return the stack of the current thread.
         */
        fun stackPop(): VkStack = stackGet().apply { pop() }

        fun nstackMalloc(size: Int): Long = stackGet().nmalloc(size)
        fun nstackMalloc(alignment: Int, size: Int): Long = stackGet().nmalloc(alignment, size)
        fun nstackCalloc(alignment: Int, num: Int, size: Int): Long = stackGet().ncalloc(alignment, num, size)

        // -------------------------------------------------

        fun stackMalloc(size: Int): ByteBuffer = stackGet().malloc(size)
        fun stackCalloc(size: Int): ByteBuffer = stackGet().calloc(size)
        fun stackBytes(x: Byte): ByteBuffer = stackGet().bytes(x)
        fun stackBytes(x: Byte, y: Byte): ByteBuffer = stackGet().bytes(x, y)
        fun stackBytes(x: Byte, y: Byte, z: Byte): ByteBuffer = stackGet().bytes(x, y, z)
        fun stackBytes(x: Byte, y: Byte, z: Byte, w: Byte): ByteBuffer = stackGet().bytes(x, y, z, w)
        fun stackBytes(vararg values: Byte): ByteBuffer = stackGet().bytes(*values)

        // -------------------------------------------------

        fun stackMallocShort(size: Int): ShortBuffer = stackGet().mallocShort(size)
        fun stackCallocShort(size: Int): ShortBuffer = stackGet().callocShort(size)
        fun stackShorts(x: Short): ShortBuffer = stackGet().shorts(x)
        fun stackShorts(x: Short, y: Short): ShortBuffer = stackGet().shorts(x, y)
        fun stackShorts(x: Short, y: Short, z: Short): ShortBuffer = stackGet().shorts(x, y, z)
        fun stackShorts(x: Short, y: Short, z: Short, w: Short): ShortBuffer = stackGet().shorts(x, y, z, w)
        fun stackShorts(vararg values: Short): ShortBuffer = stackGet().shorts(*values)

        // -------------------------------------------------

        fun stackMallocInt(size: Int): IntBuffer = stackGet().mallocInt(size)
        fun stackCallocInt(size: Int): IntBuffer = stackGet().callocInt(size)
        fun stackInts(x: Int): IntBuffer = stackGet().ints(x)
        fun stackInts(x: Int, y: Int): IntBuffer = stackGet().ints(x, y)
        fun stackInts(x: Int, y: Int, z: Int): IntBuffer = stackGet().ints(x, y, z)
        fun stackInts(x: Int, y: Int, z: Int, w: Int): IntBuffer = stackGet().ints(x, y, z, w)
        fun stackInts(vararg values: Int): IntBuffer = stackGet().ints(*values)

        // -------------------------------------------------

        fun stackMallocLong(size: Int): LongBuffer = stackGet().mallocLong(size)
        fun stackCallocLong(size: Int): LongBuffer = stackGet().callocLong(size)
        fun stackLongs(x: Long): LongBuffer = stackGet().longs(x)
        fun stackLongs(x: Long, y: Long): LongBuffer = stackGet().longs(x, y)
        fun stackLongs(x: Long, y: Long, z: Long): LongBuffer = stackGet().longs(x, y, z)
        fun stackLongs(x: Long, y: Long, z: Long, w: Long): LongBuffer = stackGet().longs(x, y, z, w)
        fun stackLongs(vararg values: Long): LongBuffer = stackGet().longs(*values)

        // -------------------------------------------------

        fun stackMallocCLong(size: Int): CLongBuffer = stackGet().mallocCLong(size)
        fun stackCallocCLong(size: Int): CLongBuffer = stackGet().callocCLong(size)
        fun stackCLongs(x: Long): CLongBuffer = stackGet().clongs(x)
        fun stackCLongs(x: Long, y: Long): CLongBuffer = stackGet().clongs(x, y)
        fun stackCLongs(x: Long, y: Long, z: Long): CLongBuffer = stackGet().clongs(x, y, z)
        fun stackCLongs(x: Long, y: Long, z: Long, w: Long): CLongBuffer = stackGet().clongs(x, y, z, w)
        fun stackCLongs(vararg values: Long): CLongBuffer = stackGet().clongs(*values)

        // -------------------------------------------------

        fun stackMallocFloat(size: Int): FloatBuffer = stackGet().mallocFloat(size)
        fun stackCallocFloat(size: Int): FloatBuffer = stackGet().callocFloat(size)
        fun stackFloats(x: Float): FloatBuffer = stackGet().floats(x)
        fun stackFloats(x: Float, y: Float): FloatBuffer = stackGet().floats(x, y)
        fun stackFloats(x: Float, y: Float, z: Float): FloatBuffer = stackGet().floats(x, y, z)
        fun stackFloats(x: Float, y: Float, z: Float, w: Float): FloatBuffer = stackGet().floats(x, y, z, w)
        fun stackFloats(vararg values: Float): FloatBuffer = stackGet().floats(*values)

        // -------------------------------------------------

        fun stackMallocDouble(size: Int): DoubleBuffer = stackGet().mallocDouble(size)
        fun stackCallocDouble(size: Int): DoubleBuffer = stackGet().callocDouble(size)
        fun stackDoubles(x: Double): DoubleBuffer = stackGet().doubles(x)
        fun stackDoubles(x: Double, y: Double): DoubleBuffer = stackGet().doubles(x, y)
        fun stackDoubles(x: Double, y: Double, z: Double): DoubleBuffer = stackGet().doubles(x, y, z)
        fun stackDoubles(x: Double, y: Double, z: Double, w: Double): DoubleBuffer = stackGet().doubles(x, y, z, w)
        fun stackDoubles(vararg values: Double): DoubleBuffer = stackGet().doubles(*values)

        // -------------------------------------------------

        fun stackMallocPointer(size: Int): PointerBuffer = stackGet().mallocPointer(size)
        fun stackCallocPointer(size: Int): PointerBuffer = stackGet().callocPointer(size)
        fun stackPointers(x: Long): PointerBuffer = stackGet().pointers(x)
        fun stackPointers(x: Long, y: Long): PointerBuffer = stackGet().pointers(x, y)
        fun stackPointers(x: Long, y: Long, z: Long): PointerBuffer = stackGet().pointers(x, y, z)
        fun stackPointers(x: Long, y: Long, z: Long, w: Long): PointerBuffer = stackGet().pointers(x, y, z, w)
        fun stackPointers(vararg values: Long): PointerBuffer = stackGet().pointers(*values)
        fun stackPointers(x: Pointer): PointerBuffer = stackGet().pointers(x)
        fun stackPointers(x: Pointer, y: Pointer): PointerBuffer = stackGet().pointers(x, y)
        fun stackPointers(x: Pointer, y: Pointer, z: Pointer): PointerBuffer = stackGet().pointers(x, y, z)
        fun stackPointers(x: Pointer, y: Pointer, z: Pointer, w: Pointer): PointerBuffer = stackGet().pointers(x, y, z, w)
        fun stackPointers(vararg values: Pointer): PointerBuffer = stackGet().pointers(*values)

        // -------------------------------------------------

        fun stackASCII(text: CharSequence): ByteBuffer = stackGet().ASCII(text)
        fun stackASCII(text: CharSequence, nullTerminated: Boolean): ByteBuffer = stackGet().ASCII(text, nullTerminated)

        fun stackUTF8(text: CharSequence): ByteBuffer = stackGet().UTF8(text)
        fun stackUTF8(text: CharSequence, nullTerminated: Boolean): ByteBuffer = stackGet().UTF8(text, nullTerminated)

        fun stackUTF16(text: CharSequence): ByteBuffer = stackGet().UTF16(text)
        fun stackUTF16(text: CharSequence, nullTerminated: Boolean): ByteBuffer = stackGet().UTF16(text, nullTerminated)

        fun stackASCIISafe(text: CharSequence?): ByteBuffer? = stackGet().ASCIISafe(text)
        fun stackASCIISafe(text: CharSequence?, nullTerminated: Boolean): ByteBuffer? = stackGet().ASCIISafe(text, nullTerminated)

        fun stackUTF8Safe(text: CharSequence?): ByteBuffer? = stackGet().UTF8Safe(text)
        fun stackUTF8Safe(text: CharSequence?, nullTerminated: Boolean): ByteBuffer? = stackGet().UTF8Safe(text, nullTerminated)

        fun stackUTF16Safe(text: CharSequence?): ByteBuffer? = stackGet().UTF16Safe(text)
        fun stackUTF16Safe(text: CharSequence?, nullTerminated: Boolean): ByteBuffer? = stackGet().UTF16Safe(text, nullTerminated)
    }
}