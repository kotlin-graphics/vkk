//package vkk
//
//import glm_.L
//import glm_.set
//import glm_.toUnsignedLong
//import org.lwjgl.BufferUtils
//import org.lwjgl.PointerBuffer
//import org.lwjgl.system.Configuration
//import org.lwjgl.system.MathUtil.mathIsPoT
//import org.lwjgl.system.MemoryUtil.*
//import org.lwjgl.system.Pointer
//import org.lwjgl.system.Pointer.POINTER_SHIFT
//import org.lwjgl.system.Pointer.POINTER_SIZE
//import java.nio.*
//import java.util.*
//import kotlin.collections.ArrayList
//
//open class MemoryStackPlus
///**
// * Creates a new [MemoryStackPlus] with the specified size.
// *
// * @param size the maximum number of bytes that may be allocated on the stack
// */
//protected constructor(
//        /**
//         * Returns the size of the backing off-heap memory.
//         *
//         * This is the maximum number of bytes that may be allocated on the stack.
//         */
//        private val size: Int) : AutoCloseable {
//
//    private val buffer: ByteBuffer = BufferUtils.createByteBuffer(size)
//    /**
//     * Returns the address of the backing off-heap memory.
//     *
//     * The stack grows "downwards", so the bottom of the stack is at `address + size`, while the top is at `address`.
//     */
//    val address = memAddress(buffer)
//
//    var pointer = size
//
//    private var frames = IntArray(MemoryStackPlus.Companion.DEFAULT_STACK_FRAMES)
//    /**
//     * Returns the current frame index.
//     *
//     *
//     * This is the current number of nested [.push] calls.
//     */
//    var frameIndex = 0
//        protected set
//
//    /**
//     * Stores the current stack pointer and pushes a new frame to the stack.
//     *
//     * This method should be called when entering a method, before doing any stack allocations. When exiting a method, call the [.pop] method to
//     * restore the previous stack frame.
//     *
//     *
//     * Pairs of push/pop calls may be nested. Care must be taken to:
//     *
//     *  * match every push with a pop
//     *  * not call pop before push has been called at least once
//     *  * not nest push calls to more than the maximum supported depth
//     *
//     *
//     * @return this stack
//     */
//    open fun push(): MemoryStackPlus {
//        if (frameIndex == frames.size) frameOverflow()
//        frames[frameIndex++] = pointer
//        return this
//    }
//
//    private fun frameOverflow() {
//        frames = Arrays.copyOf(frames, frames.size * 3 / 2)
//    }
//
//    /**
//     * Pops the current stack frame and moves the stack pointer to the end of the previous stack frame.
//     *
//     * @return this stack
//     */
//    open fun pop(): MemoryStackPlus {
//        pointer = frames[--frameIndex]
//        return this
//    }
//
//    /**
//     * Calls [.pop] on this [MemoryStackPlus].
//     *
//     * This method should not be used directly. It is called automatically when the `MemoryStackPlus` is used as a resource in a try-with-resources
//     * statement.
//     */
//    override fun close() {
//        pop()
//    }
//
//    private fun checkPointer(pointer: Int) {
//        if (pointer < 0 || size < pointer)
//            throw IndexOutOfBoundsException("Invalid stack ptr")
//    }
//
//    /**
//     * Calls [.nmalloc] with `alignment` equal to 1.
//     *
//     * @param size the allocation size
//     *
//     * @return the memory address on the stack for the requested allocation
//     */
//    fun nmalloc(size: Int) = nmalloc(1, size)
//
//    /**
//     * Allocates a block of `size` bytes of memory on the stack. The content of the newly allocated block of memory is not initialized, remaining with
//     * indeterminate values.
//     *
//     * @param alignment the required alignment
//     * @param size      the allocation size
//     *
//     * @return the memory address on the stack for the requested allocation
//     */
//    fun nmalloc(alignment: Int, size: Int): Long {
//        var newPointer = pointer - size
//        // Align pointer to the specified alignment
//        newPointer = newPointer and (alignment - 1).inv()
//        pointer = newPointer
//        return address + newPointer.toUnsignedLong
//    }
//
//    /**
//     * Allocates a block of memory on the stack for an array of `num` elements, each of them `size` bytes long, and initializes all its bits to
//     * zero.
//     *
//     * @param alignment the required element alignment
//     * @param num       num  the number of elements to allocate
//     * @param size      the size of each element
//     *
//     * @return the memory address on the stack for the requested allocation
//     */
//    fun ncalloc(alignment: Int, num: Int, size: Int): Long {
//        val bytes = num * size
//        val address = nmalloc(alignment, bytes)
//        memSet(address, 0, bytes.L)
//        return address
//    }
//
//    // -------------------------------------------------
//
//    /**
//     * Allocates an aligned [ByteBuffer] on the stack.
//     *
//     * @param alignment the required buffer alignment
//     * @param size      the number of elements in the buffer
//     *
//     * @return the allocated buffer
//     */
//    fun malloc(alignment: Int, size: Int): ByteBuffer = memByteBuffer(nmalloc(alignment, size), size)
//
//    /** Calloc version of [.malloc].  */
//    fun calloc(alignment: Int, size: Int): ByteBuffer = memByteBuffer(ncalloc(alignment, size, 1), size)
//
//    /**
//     * Allocates a [ByteBuffer] on the stack.
//     *
//     * @param size the number of elements in the buffer
//     *
//     * @return the allocated buffer
//     */
//    fun malloc(size: Int = 1) = malloc(1, size)
//
//    fun malloc(size: IntBuffer) = malloc(1, size[0])
//
//    /** Calloc version of [.malloc].  */
//    fun calloc(size: Int = 1) = calloc(1, size)
//
//    fun calloc(size: IntBuffer) = calloc(1, size[0])
//
//    /** Single value version of [.malloc].  */
//    fun bytes(x: Byte): ByteBuffer = malloc(1).put(0, x)
//
//    /** Two value version of [.malloc].  */
//    fun bytes(x: Byte, y: Byte): ByteBuffer = malloc(2).put(0, x).put(1, y)
//
//    /** Three value version of [.malloc].  */
//    fun bytes(x: Byte, y: Byte, z: Byte): ByteBuffer = malloc(3).put(0, x).put(1, y).put(2, z)
//
//    /** Four value version of [.malloc].  */
//    fun bytes(x: Byte, y: Byte, z: Byte, w: Byte): ByteBuffer = malloc(4).put(0, x).put(1, y).put(2, z).put(3, w)
//
//    /** Vararg version of [.malloc].  */
//    fun bytes(vararg values: Byte): ByteBuffer = malloc(values.size).put(values).apply { flip() }
//
//    // -------------------------------------------------
//
//    /** Short version of [.malloc].  */
//    fun mallocShort(size: Int = 1): ShortBuffer = memShortBuffer(nmalloc(2, size shl 1), size)
//
//    fun mallocShort(size: IntBuffer): ShortBuffer = memShortBuffer(nmalloc(2, size[0] shl 1), size[0])
//
//    /** Short version of [.calloc].  */
//    fun callocShort(size: Int = 1): ShortBuffer = memShortBuffer(ncalloc(2, size, 2), size)
//
//    fun callocShort(size: IntBuffer): ShortBuffer = memShortBuffer(ncalloc(2, size[0], 2), size[0])
//
//    /** Single value version of [.mallocShort].  */
//    fun shorts(x: Short): ShortBuffer = mallocShort(1).put(0, x)
//
//    /** Two value version of [.mallocShort].  */
//    fun shorts(x: Short, y: Short): ShortBuffer = mallocShort(2).put(0, x).put(1, y)
//
//    /** Three value version of [.mallocShort].  */
//    fun shorts(x: Short, y: Short, z: Short): ShortBuffer = mallocShort(3).put(0, x).put(1, y).put(2, z)
//
//    /** Four value version of [.mallocShort].  */
//    fun shorts(x: Short, y: Short, z: Short, w: Short): ShortBuffer = mallocShort(4).put(0, x).put(1, y).put(2, z).put(3, w)
//
//    /** Vararg version of [.mallocShort].  */
//    fun shorts(vararg values: Short): ShortBuffer = mallocShort(values.size).put(values).apply { flip() }
//
//    // -------------------------------------------------
//
//    /** Int version of [.malloc].  */
//    fun mallocInt(size: Int = 1): IntBuffer = memIntBuffer(nmalloc(4, size shl 2), size)
//
//    fun mallocInt(size: IntBuffer): IntBuffer = memIntBuffer(nmalloc(4, size[0] shl 2), size[0])
//
//    /** Int version of [.calloc].  */
//    fun callocInt(size: Int = 1): IntBuffer = memIntBuffer(ncalloc(4, size, 4), size)
//
//    fun callocInt(size: IntBuffer): IntBuffer = memIntBuffer(ncalloc(4, size[0], 4), size[0])
//
//    /** Single value version of [.mallocInt].  */
//    fun ints(x: Int): IntBuffer = mallocInt(1).put(0, x)
//
//    /** Two value version of [.mallocInt].  */
//    fun ints(x: Int, y: Int): IntBuffer = mallocInt(2).put(0, x).put(1, y)
//
//    /** Three value version of [.mallocInt].  */
//    fun ints(x: Int, y: Int, z: Int): IntBuffer = mallocInt(3).put(0, x).put(1, y).put(2, z)
//
//    /** Four value version of [.mallocInt].  */
//    fun ints(x: Int, y: Int, z: Int, w: Int): IntBuffer = mallocInt(4).put(0, x).put(1, y).put(2, z).put(3, w)
//
//    /** Vararg version of [.mallocInt].  */
//    fun ints(vararg values: Int): IntBuffer = mallocInt(values.size).put(values).apply { flip() }
//
//    // -------------------------------------------------
//
//    /** Long version of [.malloc].  */
//    fun mallocLong(size: Int = 1): LongBuffer = memLongBuffer(nmalloc(8, size shl 3), size)
//
//    fun mallocLong(size: IntBuffer): LongBuffer = memLongBuffer(nmalloc(8, size[0] shl 3), size[0])
//
//    /** Long version of [.calloc].  */
//    fun callocLong(size: Int = 1): LongBuffer = memLongBuffer(ncalloc(8, size, 8), size)
//
//    fun callocLong(size: IntBuffer): LongBuffer = memLongBuffer(ncalloc(8, size[0], 8), size[0])
//
//    /** Single value version of [.mallocLong].  */
//    fun longs(x: Long): LongBuffer = mallocLong(1).put(0, x)
//
//    /** Two value version of [.mallocLong].  */
//    fun longs(x: Long, y: Long): LongBuffer = mallocLong(2).put(0, x).put(1, y)
//
//    /** Three value version of [.mallocLong].  */
//    fun longs(x: Long, y: Long, z: Long): LongBuffer = mallocLong(3).put(0, x).put(1, y).put(2, z)
//
//    /** Four value version of [.mallocLong].  */
//    fun longs(x: Long, y: Long, z: Long, w: Long): LongBuffer = mallocLong(4).put(0, x).put(1, y).put(2, z).put(3, w)
//
//    /** Vararg version of [.mallocLong].  */
//    fun longs(vararg more: Long): LongBuffer = mallocLong(more.size).put(more).apply { flip() }
//
//    // -------------------------------------------------
//
//    /** Float version of [.malloc].  */
//    fun mallocFloat(size: Int = 1): FloatBuffer = memFloatBuffer(nmalloc(4, size shl 2), size)
//
//    fun mallocFloat(size: IntBuffer): FloatBuffer = memFloatBuffer(nmalloc(4, size[0] shl 2), size[0])
//
//    /** Float version of [.calloc].  */
//    fun callocFloat(size: Int = 1): FloatBuffer = memFloatBuffer(ncalloc(4, size, 4), size)
//
//    fun callocFloat(size: IntBuffer): FloatBuffer = memFloatBuffer(ncalloc(4, size[0], 4), size[0])
//
//    /** Single value version of [.mallocFloat].  */
//    fun floats(x: Float): FloatBuffer = mallocFloat(1).put(0, x)
//
//    /** Two value version of [.mallocFloat].  */
//    fun floats(x: Float, y: Float): FloatBuffer = mallocFloat(2).put(0, x).put(1, y)
//
//    /** Three value version of [.mallocFloat].  */
//    fun floats(x: Float, y: Float, z: Float): FloatBuffer = mallocFloat(3).put(0, x).put(1, y).put(2, z)
//
//    /** Four value version of [.mallocFloat].  */
//    fun floats(x: Float, y: Float, z: Float, w: Float): FloatBuffer = mallocFloat(4).put(0, x).put(1, y).put(2, z).put(3, w)
//
//    /** Vararg version of [.mallocFloat].  */
//    fun floats(vararg values: Float): FloatBuffer = mallocFloat(values.size).put(values).apply { flip() }
//
//    // -------------------------------------------------
//
//    /** Double version of [.malloc].  */
//    fun mallocDouble(size: Int = 1): DoubleBuffer = memDoubleBuffer(nmalloc(8, size shl 3), size)
//
//    fun mallocDouble(size: IntBuffer): DoubleBuffer = memDoubleBuffer(nmalloc(8, size[0] shl 3), size[0])
//
//    /** Double version of [.calloc].  */
//    fun callocDouble(size: Int = 1): DoubleBuffer = memDoubleBuffer(ncalloc(8, size, 8), size)
//
//    fun callocDouble(size: IntBuffer): DoubleBuffer = memDoubleBuffer(ncalloc(8, size[0], 8), size[0])
//
//    /** Single value version of [.mallocDouble].  */
//    fun doubles(x: Double): DoubleBuffer = mallocDouble(1).put(0, x)
//
//    /** Two value version of [.mallocDouble].  */
//    fun doubles(x: Double, y: Double): DoubleBuffer = mallocDouble(2).put(0, x).put(1, y)
//
//    /** Three value version of [.mallocDouble].  */
//    fun doubles(x: Double, y: Double, z: Double): DoubleBuffer = mallocDouble(3).put(0, x).put(1, y).put(2, z)
//
//    /** Four value version of [.mallocDouble].  */
//    fun doubles(x: Double, y: Double, z: Double, w: Double): DoubleBuffer = mallocDouble(4).put(0, x).put(1, y).put(2, z).put(3, w)
//
//    /** Vararg version of [.mallocDouble].  */
//    fun doubles(vararg values: Double): DoubleBuffer = mallocDouble(values.size).put(values).apply { flip() }
//
//    // -------------------------------------------------
//
//    /** Pointer version of [.malloc].  */
//    fun mallocPointer(size: Int = 1): PointerBuffer = memPointerBuffer(nmalloc(POINTER_SIZE, size shl POINTER_SHIFT), size)
//
//    fun mallocPointer(size: IntBuffer): PointerBuffer = memPointerBuffer(nmalloc(POINTER_SIZE, size[0] shl POINTER_SHIFT), size[0])
//
//    /** Pointer version of [.calloc].  */
//    fun callocPointer(size: Int = 1): PointerBuffer = memPointerBuffer(ncalloc(POINTER_SIZE, size, POINTER_SIZE), size)
//
//    fun callocPointer(size: IntBuffer): PointerBuffer = memPointerBuffer(ncalloc(POINTER_SIZE, size[0], POINTER_SIZE), size[0])
//
//    /** Single value version of [.mallocPointer].  */
//    fun pointers(x: Long): PointerBuffer = mallocPointer(1).put(0, x)
//
//    /** Two value version of [.mallocPointer].  */
//    fun pointers(x: Long, y: Long): PointerBuffer = mallocPointer(2).put(0, x).put(1, y)
//
//    /** Three value version of [.mallocPointer].  */
//    fun pointers(x: Long, y: Long, z: Long): PointerBuffer = mallocPointer(3).put(0, x).put(1, y).put(2, z)
//
//    /** Four value version of [.mallocPointer].  */
//    fun pointers(x: Long, y: Long, z: Long, w: Long): PointerBuffer = mallocPointer(4).put(0, x).put(1, y).put(2, z).put(3, w)
//
//    /** Vararg version of [.mallocPointer].  */
//    fun pointers(vararg values: Long): PointerBuffer = mallocPointer(values.size).put(values).apply { flip() }
//
//    /** Single value version of [.mallocPointer].  */
//    fun pointers(x: Pointer): PointerBuffer = mallocPointer(1).put(0, x)
//
//    /** Two value version of [.mallocPointer].  */
//    fun pointers(x: Pointer, y: Pointer): PointerBuffer = mallocPointer(2).put(0, x).put(1, y)
//
//    /** Three value version of [.mallocPointer].  */
//    fun pointers(x: Pointer, y: Pointer, z: Pointer): PointerBuffer = mallocPointer(3).put(0, x).put(1, y).put(2, z)
//
//    /** Four value version of [.mallocPointer].  */
//    fun pointers(x: Pointer, y: Pointer, z: Pointer, w: Pointer): PointerBuffer = mallocPointer(4).put(0, x).put(1, y).put(2, z).put(3, w)
//
//    /** Vararg version of [.mallocPointer].  */
//    fun pointers(vararg values: Pointer): PointerBuffer {
//        val buffer = mallocPointer(values.size)
//        for (i in values.indices)
//            buffer[i] = values[i]
//        return buffer
//    }
//
//    /**
//     * Encodes the specified text on the stack using ascii encoding and returns a ByteBuffer that points to the encoded text.
//     *
//     * @param text           the text to encode
//     * @param nullTerminated if true, a null-terminator is included at the end of the encoded text
//     */
//    @JvmOverloads
//    fun ascii(text: CharSequence, nullTerminated: Boolean = true): ByteBuffer {
//        val encoded = malloc(memLengthASCII(text, nullTerminated))
//        memASCII(text, nullTerminated, encoded)
//        return encoded
//    }
//
//    /** Like [ascii][.ascii], but returns `null` if `text` is `null`.  */
//    @JvmOverloads
//    fun asciiSafe(text: CharSequence?, nullTerminated: Boolean = true) = text?.let { ascii(it, nullTerminated) }
//
//    /**
//     * Encodes the specified text on the stack using utf8 encoding and returns a ByteBuffer that points to the encoded text.
//     *
//     * @param text           the text to encode
//     * @param nullTerminated if true, a null-terminator is included at the end of the encoded text
//     */
//    @JvmOverloads
//    fun utf8(text: CharSequence, nullTerminated: Boolean = true): ByteBuffer {
//        val encoded = malloc(memLengthUTF8(text, nullTerminated))
//        memUTF8(text, nullTerminated, encoded)
//        return encoded
//    }
//
//    /** Like [utf8][.utf8], but returns `null` if `text` is `null`.  */
//    @JvmOverloads
//    fun utf8Safe(text: CharSequence?, nullTerminated: Boolean = true) = text?.let { utf8(it, nullTerminated) }
//
//    /**
//     * Encodes the specified text on the stack using utf16 encoding and returns a ByteBuffer that points to the encoded text.
//     *
//     * @param text           the text to encode
//     * @param nullTerminated if true, a null-terminator is included at the end of the encoded text
//     */
//    @JvmOverloads
//    fun utf16(text: CharSequence, nullTerminated: Boolean = true): ByteBuffer {
//        val encoded = malloc(2, memLengthUTF16(text, nullTerminated))
//        memUTF16(text, nullTerminated, encoded)
//        return encoded
//    }
//
//    /** Like [utf16][.utf16], but returns `null` if `text` is `null`.  */
//    @JvmOverloads
//    fun utf16Safe(text: CharSequence?, nullTerminated: Boolean = true) = text?.let { utf16(it, nullTerminated) }
//
//    companion object {
//
//        private val DEFAULT_STACK_SIZE = Configuration.STACK_SIZE.get(64) * 1024
//        private val DEFAULT_STACK_FRAMES = 8
//
//        private val DEBUG_STACK = Configuration.DEBUG_STACK.get(false)
//
//        private val TLS = ThreadLocal.withInitial<MemoryStackPlus>({ MemoryStackPlus.Companion.create() })
//
//        init {
//            if (MemoryStackPlus.Companion.DEFAULT_STACK_SIZE < 0)
//                throw IllegalStateException("Invalid stack size.")
//        }
//
//        /**
//         * Creates a new [MemoryStackPlus] with the specified size.
//         *
//         * @param size the maximum number of bytes that may be allocated on the stack
//         */
//        @JvmOverloads
//        fun create(size: Int = MemoryStackPlus.Companion.DEFAULT_STACK_SIZE) = vkk.MemoryStackPlus(size)
//
//        private fun checkAlignment(alignment: Int) {
//            if (!mathIsPoT(alignment))
//                throw IllegalArgumentException("Alignment must be a power-of-two value.")
//        }
//
//        private fun checkPush(pointer: Int) {
//            if (pointer < 0)
//                throw OutOfMemoryError("Out of stack space.")
//        }
//
//        // -----------------------------------------------------
//        // -----------------------------------------------------
//        // -----------------------------------------------------
//
//        /** Returns the stack of the current thread.  */
//        fun stackGet(): MemoryStackPlus = MemoryStackPlus.Companion.TLS.get()
//
//        /**
//         * Calls [.push] on the stack of the current thread.
//         *
//         * @return the stack of the current thread.
//         */
////        @Deprecated("", ReplaceWith("withStack{..}", "same import"))
//        fun stackPush() = MemoryStackPlus.Companion.stackGet().push()
//
////        inline fun <R> withStack(block: MemoryStackPlus.() -> R): R {
////            var exception: Throwable? = null
////            val stack = stackGet().push()
////            try {
////                return stack.block()
////            } catch (e: Throwable) {
////                exception = e
////                throw e
////            } finally {
////                stack.closeFinally(exception)
////            }
////        }
////
//////        @SinceKotlin("1.1")
//////        @Suppress("INVISIBLE_REFERENCE", "INVISIBLE_MEMBER")
//////        @kotlin.internal.InlineOnly
//////        inline fun <T : AutoCloseable?, R> T.use(block: (T) -> R): R {
//////            var exception: Throwable? = null
//////            try {
//////                return block(this)
//////            } catch (e: Throwable) {
//////                exception = e
//////                throw e
//////            } finally {
//////                this.closeFinally(exception)
//////            }
//////        }
////
////        @SinceKotlin("1.1")
////        @PublishedApi
////        internal fun AutoCloseable?.closeFinally(cause: Throwable?) = when {
////            this == null -> Unit
////            cause == null -> close()
////            else ->
////                try {
////                    close()
////                } catch (closeException: Throwable) {
////                    cause.addSuppressed(closeException)
////                }
////        }
//
//        /**
//         * Calls [.pop] on the stack of the current thread.
//         *
//         * @return the stack of the current thread.
//         */
//        fun stackPop() = MemoryStackPlus.stackGet().pop()
//
//        /** Thread-local version of [.nmalloc].  */
//        fun nstackMalloc(size: Int = 1) = MemoryStackPlus.Companion.stackGet().nmalloc(size)
//
//        /** Thread-local version of [.nmalloc].  */
//        fun nstackMalloc(alignment: Int, size: Int) = MemoryStackPlus.Companion.stackGet().nmalloc(alignment, size)
//
//        /** Thread-local version of [.ncalloc].  */
//        fun nstackCalloc(alignment: Int, num: Int, size: Int) = MemoryStackPlus.Companion.stackGet().ncalloc(alignment, num, size)
//
//        // -------------------------------------------------
//
//        /** Thread-local version of [.malloc].  */
//        fun stackMalloc(size: Int = 1) = MemoryStackPlus.Companion.stackGet().malloc(size)
//
//        fun stackMalloc(size: IntBuffer) = MemoryStackPlus.Companion.stackGet().malloc(size[0])
//
//        /** Thread-local version of [.calloc].  */
//        fun stackCalloc(size: Int = 1) = MemoryStackPlus.Companion.stackGet().calloc(size)
//
//        fun stackCalloc(size: IntBuffer) = MemoryStackPlus.Companion.stackGet().calloc(size[0])
//
//        /** Thread-local version of [.bytes].  */
//        fun stackBytes(x: Byte) = MemoryStackPlus.Companion.stackGet().bytes(x)
//
//        /** Thread-local version of [.bytes].  */
//        fun stackBytes(x: Byte, y: Byte) = MemoryStackPlus.Companion.stackGet().bytes(x, y)
//
//        /** Thread-local version of [.bytes].  */
//        fun stackBytes(x: Byte, y: Byte, z: Byte) = MemoryStackPlus.Companion.stackGet().bytes(x, y, z)
//
//        /** Thread-local version of [.bytes].  */
//        fun stackBytes(x: Byte, y: Byte, z: Byte, w: Byte) = MemoryStackPlus.Companion.stackGet().bytes(x, y, z, w)
//
//        /** Thread-local version of [.bytes].  */
//        fun stackBytes(vararg values: Byte) = MemoryStackPlus.Companion.stackGet().bytes(*values)
//
//        // -------------------------------------------------
//
//        /** Thread-local version of [.mallocShort].  */
//        fun stackMallocShort(size: Int = 1) = MemoryStackPlus.Companion.stackGet().mallocShort(size)
//
//        fun stackMallocShort(size: IntBuffer) = MemoryStackPlus.Companion.stackGet().mallocShort(size[0])
//
//        /** Thread-local version of [.callocShort].  */
//        fun stackCallocShort(size: Int = 1) = MemoryStackPlus.Companion.stackGet().callocShort(size)
//
//        fun stackCallocShort(size: IntBuffer) = MemoryStackPlus.Companion.stackGet().callocShort(size[0])
//
//        /** Thread-local version of [.shorts].  */
//        fun stackShorts(x: Short) = MemoryStackPlus.Companion.stackGet().shorts(x)
//
//        /** Thread-local version of [.shorts].  */
//        fun stackShorts(x: Short, y: Short) = MemoryStackPlus.Companion.stackGet().shorts(x, y)
//
//        /** Thread-local version of [.shorts].  */
//        fun stackShorts(x: Short, y: Short, z: Short) = MemoryStackPlus.Companion.stackGet().shorts(x, y, z)
//
//        /** Thread-local version of [.shorts].  */
//        fun stackShorts(x: Short, y: Short, z: Short, w: Short) = MemoryStackPlus.Companion.stackGet().shorts(x, y, z, w)
//
//        /** Thread-local version of [.shorts].  */
//        fun stackShorts(vararg values: Short) = MemoryStackPlus.Companion.stackGet().shorts(*values)
//
//        // -------------------------------------------------
//
//        /** Thread-local version of [.mallocInt].  */
//        fun stackMallocInt(size: Int = 1) = MemoryStackPlus.Companion.stackGet().mallocInt(size)
//
//        fun stackMallocInt(size: IntBuffer) = MemoryStackPlus.Companion.stackGet().mallocInt(size[0])
//
//        /** Thread-local version of [.callocInt].  */
//        fun stackCallocInt(size: Int = 1) = MemoryStackPlus.Companion.stackGet().callocInt(size)
//
//        fun stackCallocInt(size: IntBuffer) = MemoryStackPlus.Companion.stackGet().callocInt(size[0])
//
//        /** Thread-local version of [.ints].  */
//        fun stackInts(x: Int) = MemoryStackPlus.Companion.stackGet().ints(x)
//
//        /** Thread-local version of [.ints].  */
//        fun stackInts(x: Int, y: Int) = MemoryStackPlus.Companion.stackGet().ints(x, y)
//
//        /** Thread-local version of [.ints].  */
//        fun stackInts(x: Int, y: Int, z: Int) = MemoryStackPlus.Companion.stackGet().ints(x, y, z)
//
//        /** Thread-local version of [.ints].  */
//        fun stackInts(x: Int, y: Int, z: Int, w: Int) = MemoryStackPlus.Companion.stackGet().ints(x, y, z, w)
//
//        /** Thread-local version of [.ints].  */
//        fun stackInts(vararg values: Int) = MemoryStackPlus.Companion.stackGet().ints(*values)
//
//        // -------------------------------------------------
//
//        /** Thread-local version of [.mallocLong].  */
//        fun stackMallocLong(size: Int = 1) = MemoryStackPlus.Companion.stackGet().mallocLong(size)
//
//        fun stackMallocLong(size: IntBuffer) = MemoryStackPlus.Companion.stackGet().mallocLong(size[0])
//
//        /** Thread-local version of [.callocLong].  */
//        fun stackCallocLong(size: Int = 1) = MemoryStackPlus.Companion.stackGet().callocLong(size)
//
//        fun stackCallocLong(size: IntBuffer) = MemoryStackPlus.Companion.stackGet().callocLong(size[0])
//
//        /** Thread-local version of [.longs].  */
//        fun stackLongs(x: Long) = MemoryStackPlus.Companion.stackGet().longs(x)
//
//        /** Thread-local version of [.longs].  */
//        fun stackLongs(x: Long, y: Long) = MemoryStackPlus.Companion.stackGet().longs(x, y)
//
//        /** Thread-local version of [.longs].  */
//        fun stackLongs(x: Long, y: Long, z: Long) = MemoryStackPlus.Companion.stackGet().longs(x, y, z)
//
//        /** Thread-local version of [.longs].  */
//        fun stackLongs(x: Long, y: Long, z: Long, w: Long) = MemoryStackPlus.Companion.stackGet().longs(x, y, z, w)
//
//        /** Thread-local version of [.longs].  */
//        fun stackLongs(vararg values: Long) = MemoryStackPlus.Companion.stackGet().longs(*values)
//
//        // -------------------------------------------------
//
//        /** Thread-local version of [.mallocFloat].  */
//        fun stackMallocFloat(size: Int = 1) = MemoryStackPlus.Companion.stackGet().mallocFloat(size)
//
//        fun stackMallocFloat(size: IntBuffer) = MemoryStackPlus.Companion.stackGet().mallocFloat(size[0])
//
//        /** Thread-local version of [.callocFloat].  */
//        fun stackCallocFloat(size: Int = 1) = MemoryStackPlus.Companion.stackGet().callocFloat(size)
//
//        fun stackCallocFloat(size: IntBuffer) = MemoryStackPlus.Companion.stackGet().callocFloat(size[0])
//
//        /** Thread-local version of [.floats].  */
//        fun stackFloats(x: Float) = MemoryStackPlus.Companion.stackGet().floats(x)
//
//        /** Thread-local version of [.floats].  */
//        fun stackFloats(x: Float, y: Float) = MemoryStackPlus.Companion.stackGet().floats(x, y)
//
//        /** Thread-local version of [.floats].  */
//        fun stackFloats(x: Float, y: Float, z: Float) = MemoryStackPlus.Companion.stackGet().floats(x, y, z)
//
//        /** Thread-local version of [.floats].  */
//        fun stackFloats(x: Float, y: Float, z: Float, w: Float) = MemoryStackPlus.Companion.stackGet().floats(x, y, z, w)
//
//        /** Thread-local version of [.floats].  */
//        fun stackFloats(vararg values: Float) = MemoryStackPlus.Companion.stackGet().floats(*values)
//
//        // -------------------------------------------------
//
//        /** Thread-local version of [.mallocDouble].  */
//        fun stackMallocDouble(size: Int = 1) = MemoryStackPlus.Companion.stackGet().mallocDouble(size)
//
//        fun stackMallocDouble(size: IntBuffer) = MemoryStackPlus.Companion.stackGet().mallocDouble(size[0])
//
//        /** Thread-local version of [.callocDouble].  */
//        fun stackCallocDouble(size: Int = 1) = MemoryStackPlus.Companion.stackGet().callocDouble(size)
//
//        fun stackCallocDouble(size: IntBuffer) = MemoryStackPlus.Companion.stackGet().callocDouble(size[0])
//
//        /** Thread-local version of [.doubles].  */
//        fun stackDoubles(x: Double) = MemoryStackPlus.Companion.stackGet().doubles(x)
//
//        /** Thread-local version of [.doubles].  */
//        fun stackDoubles(x: Double, y: Double) = MemoryStackPlus.Companion.stackGet().doubles(x, y)
//
//        /** Thread-local version of [.doubles].  */
//        fun stackDoubles(x: Double, y: Double, z: Double) = MemoryStackPlus.Companion.stackGet().doubles(x, y, z)
//
//        /** Thread-local version of [.doubles].  */
//        fun stackDoubles(x: Double, y: Double, z: Double, w: Double) = MemoryStackPlus.Companion.stackGet().doubles(x, y, z, w)
//
//        /** Thread-local version of [.doubles].  */
//        fun stackDoubles(vararg values: Double) = MemoryStackPlus.Companion.stackGet().doubles(*values)
//
//        // -------------------------------------------------
//
//        /** Thread-local version of [.mallocPointer].  */
//        fun stackMallocPointer(size: Int = 1) = MemoryStackPlus.Companion.stackGet().mallocPointer(size)
//
//        fun stackMallocPointer(size: IntBuffer) = MemoryStackPlus.Companion.stackGet().mallocPointer(size[0])
//
//        /** Thread-local version of [.callocPointer].  */
//        fun stackCallocPointer(size: Int = 1) = MemoryStackPlus.Companion.stackGet().callocPointer(size)
//
//        fun stackCallocPointer(size: IntBuffer) = MemoryStackPlus.Companion.stackGet().callocPointer(size[0])
//
//        /** Thread-local version of [.pointers].  */
//        fun stackPointers(x: Long) = MemoryStackPlus.Companion.stackGet().pointers(x)
//
//        /** Thread-local version of [.pointers].  */
//        fun stackPointers(x: Long, y: Long) = MemoryStackPlus.Companion.stackGet().pointers(x, y)
//
//        /** Thread-local version of [.pointers].  */
//        fun stackPointers(x: Long, y: Long, z: Long) = MemoryStackPlus.Companion.stackGet().pointers(x, y, z)
//
//        /** Thread-local version of [.pointers].  */
//        fun stackPointers(x: Long, y: Long, z: Long, w: Long) = MemoryStackPlus.Companion.stackGet().pointers(x, y, z, w)
//
//        /** Thread-local version of [.pointers].  */
//        fun stackPointers(vararg values: Long) = MemoryStackPlus.Companion.stackGet().pointers(*values)
//
//        /** Thread-local version of [.pointers].  */
//        fun stackPointers(x: Pointer) = MemoryStackPlus.Companion.stackGet().pointers(x)
//
//        /** Thread-local version of [.pointers].  */
//        fun stackPointers(x: Pointer, y: Pointer) = MemoryStackPlus.Companion.stackGet().pointers(x, y)
//
//        /** Thread-local version of [.pointers].  */
//        fun stackPointers(x: Pointer, y: Pointer, z: Pointer) = MemoryStackPlus.Companion.stackGet().pointers(x, y, z)
//
//        /** Thread-local version of [.pointers].  */
//        fun stackPointers(x: Pointer, y: Pointer, z: Pointer, w: Pointer) = MemoryStackPlus.Companion.stackGet().pointers(x, y, z, w)
//
//        /** Thread-local version of [.pointers].  */
//        fun stackPointers(vararg values: Pointer) = MemoryStackPlus.Companion.stackGet().pointers(*values)
//
//        // -------------------------------------------------
//
//        /** Thread-local version of [.ascii].  */
//        fun stackASCII(text: CharSequence) = MemoryStackPlus.Companion.stackGet().ascii(text)
//
//        /** Thread-local version of [.ascii].  */
//        fun stackASCII(text: CharSequence, nullTerminated: Boolean) = MemoryStackPlus.Companion.stackGet().ascii(text, nullTerminated)
//
//        /** Thread-local version of [.utf8].  */
//        fun stackUTF8(text: CharSequence) = MemoryStackPlus.Companion.stackGet().utf8(text)
//
//        /** Thread-local version of [.utf8].  */
//        fun stackUTF8(text: CharSequence, nullTerminated: Boolean) = MemoryStackPlus.Companion.stackGet().utf8(text, nullTerminated)
//
//        /** Thread-local version of [.utf16].  */
//        fun stackUTF16(text: CharSequence) = MemoryStackPlus.Companion.stackGet().utf16(text)
//
//        /** Thread-local version of [.utf16].  */
//        fun stackUTF16(text: CharSequence, nullTerminated: Boolean) = MemoryStackPlus.Companion.stackGet().utf16(text, nullTerminated)
//
//        /** Thread-local version of [.ascii].  */
//        fun stackASCIISafe(text: CharSequence?) = MemoryStackPlus.Companion.stackGet().asciiSafe(text)
//
//        /** Thread-local version of [.ascii].  */
//        fun stackASCIISafe(text: CharSequence?, nullTerminated: Boolean) = MemoryStackPlus.Companion.stackGet().asciiSafe(text, nullTerminated)
//
//        /** Thread-local version of [.utf8].  */
//        fun stackUTF8Safe(text: CharSequence?) = MemoryStackPlus.Companion.stackGet().utf8Safe(text)
//
//        /** Thread-local version of [.utf8].  */
//        fun stackUTF8Safe(text: CharSequence?, nullTerminated: Boolean) = MemoryStackPlus.Companion.stackGet().utf8Safe(text, nullTerminated)
//
//        /** Thread-local version of [.utf16].  */
//        fun stackUTF16Safe(text: CharSequence?) = MemoryStackPlus.Companion.stackGet().utf16Safe(text)
//
//        /** Thread-local version of [.utf16].  */
//        fun stackUTF16Safe(text: CharSequence, nullTerminated: Boolean) = MemoryStackPlus.Companion.stackGet().utf16Safe(text, nullTerminated)
//    }
//
//    val vk = StackVK(this)
//
////    fun Collection<String>.toPointerBuffer(): PointerBuffer {
////        val buf = mallocPointer(size)
////        for (i in indices) buf[i] = elementAt(i)
////        return buf
////    }
////
////    fun Collection<Int>.toIntBuffer(): IntBuffer {
////        val buf = mallocInt(size)
////        for (i in indices) buf[i] = elementAt(i)
////        return buf
////    }
////
////    inline fun PointerBuffer.toArrayListString(count: Int = remaining()): ArrayList<String> {
////        val res = ArrayList<String>(count)
////        for (i in 0 until count)
////            res += getStringUTF8(i)
////        return res
////    }
////
////    inline operator fun PointerBuffer.set(index: Int, string: String) {
////        put(index, string.utf8)
////    }
//
//    //    inline val String.memUTF16: ByteBuffer get() = memUTF16(this)
//    inline val String.utf8: ByteBuffer get() = utf8(this)
//    inline val Long.toUTF8: String get() = memUTF8(this)
//}