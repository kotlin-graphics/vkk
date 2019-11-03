package vkk.classes

import java.nio.*

import org.lwjgl.*
import org.lwjgl.system.*

import org.lwjgl.system.Checks.*
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.system.MemoryStack.*

/**
 * Structure specifying application info.
 *
 * <h5>Description</h5>
 *
 *
 * Vulkan 1.0 implementations were required to return [ERROR_INCOMPATIBLE_DRIVER][VK10.VK_ERROR_INCOMPATIBLE_DRIVER] if `apiVersion` was larger than 1.0. Implementations that support Vulkan 1.1 or later **must** not return [ERROR_INCOMPATIBLE_DRIVER][VK10.VK_ERROR_INCOMPATIBLE_DRIVER] for any value of `apiVersion`.
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 *
 * Because Vulkan 1.0 implementations **may** fail with [ERROR_INCOMPATIBLE_DRIVER][VK10.VK_ERROR_INCOMPATIBLE_DRIVER], applications **should** determine the version of Vulkan available before calling [CreateInstance][VK10.vkCreateInstance]. If the [GetInstanceProcAddr][VK10.vkGetInstanceProcAddr] returns `NULL` for [EnumerateInstanceVersion][VK11.vkEnumerateInstanceVersion], it is a Vulkan 1.0 implementation. Otherwise, the application **can** call [EnumerateInstanceVersion][VK11.vkEnumerateInstanceVersion] to determine the version of Vulkan.
</div> *
 *
 *
 * As long as the instance supports at least Vulkan 1.1, an application **can** use different versions of Vulkan with an instance than it does with a device or physical device.
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 *
 * The Khronos validation layers will treat `apiVersion` as the highest API version the application targets, and will validate API usage against the minimum of that version and the implementation version (instance or device, depending on context). If an application tries to use functionality from a greater version than this, a validation error will be triggered.
 *
 *
 * For example, if the instance supports Vulkan 1.1 and three physical devices support Vulkan 1.0, Vulkan 1.1, and a hypothetical Vulkan 1.2, respectively, and if the application sets `apiVersion` to 1.2, the application **can** use the following versions of Vulkan:
 *
 *
 *  * Vulkan 1.0 **can** be used with the instance and with all physical devices.
 *  * Vulkan 1.1 **can** be used with the instance and with the physical devices that support Vulkan 1.1 and Vulkan 1.2.
 *  * Vulkan 1.2 **can** be used with the physical device that supports Vulkan 1.2.
 *
 *
 *
 * If we modify the above example so that the application sets `apiVersion` to 1.1, then the application **must** not use Vulkan 1.2 functionality on the physical device that supports Vulkan 1.2.
</div> *
 *
 *
 * Implicit layers **must** be disabled if they do not support a version at least as high as `apiVersion`. See the [Vulkan Loader Specification and Architecture Overview](https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#LoaderAndLayerInterface) document for additional information.
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 *
 * Providing a `NULL` [VkInstanceCreateInfo]`::pApplicationInfo` or providing an `apiVersion` of 0 is equivalent to providing an `apiVersion` of `VK_MAKE_VERSION(1,0,0)`.
</div> *
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 *
 *  * `sType` **must** be [STRUCTURE_TYPE_APPLICATION_INFO][VK10.VK_STRUCTURE_TYPE_APPLICATION_INFO]
 *  * `pNext` **must** be `NULL`
 *  * If `pApplicationName` is not `NULL`, `pApplicationName` **must** be a null-terminated UTF-8 string
 *  * If `pEngineName` is not `NULL`, `pEngineName` **must** be a null-terminated UTF-8 string
 *
 *
 * <h5>See Also</h5>
 *
 *
 * [VkInstanceCreateInfo]
 *
 * <h3>Member documentation</h3>
 *
 *
 *  * `sType`  the type of this structure.
 *  * `pNext`  `NULL` or a pointer to an extension-specific structure.
 *  * `pApplicationName`  `NULL` or is a pointer to a null-terminated UTF-8 string containing the name of the application.
 *  * `applicationVersion`  an unsigned integer variable containing the developer-supplied version number of the application.
 *  * `pEngineName`  `NULL` or is a pointer to a null-terminated UTF-8 string containing the name of the engine (if any) used to create the application.
 *  * `engineVersion`  an unsigned integer variable containing the developer-supplied version number of the engine used to create the application.
 *  * `apiVersion`  **must** be the highest version of Vulkan that the application is designed to use, encoded as described in [Version Numbers](https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#extendingvulkan-coreversions-versionnumbers). The patch version number specified in `apiVersion` is ignored when creating an instance object. Only the major and minor versions of the instance **must** match those requested in `apiVersion`.
 *
 *
 * <h3>Layout</h3>
 *
 * <pre>`
 * struct VkApplicationInfo {
 * VkStructureType sType;
 * void const * pNext;
 * char const * pApplicationName;
 * uint32_t applicationVersion;
 * char const * pEngineName;
 * uint32_t engineVersion;
 * uint32_t apiVersion;
 * }`</pre>
 */
class ApplicationInfo : Struct, NativeResource {

    /**
     * Creates a `VkApplicationInfo` instance at the current position of the specified [ByteBuffer] container. Changes to the buffer's content will be
     * visible to the struct instance and vice versa.
     *
     *
     * The created instance holds a strong reference to the container object.
     */
    constructor(container: ByteBuffer) : super(memAddress(container), __checkContainer(container, SIZEOF))

    constructor() : super(NULL, null)

    override fun sizeof() = SIZEOF

    var applicationName: String? = null

    var applicationVersion = 0

    /** Returns a [ByteBuffer] view of the null-terminated string pointed to by the `pEngineName` field.  */
    @NativeType("char const *")
    fun pEngineName(): ByteBuffer? {
        return npEngineName(address())
    }

    /** Decodes the null-terminated string pointed to by the `pEngineName` field.  */
    @NativeType("char const *")
    fun pEngineNameString(): String? {
        return npEngineNameString(address())
    }

    /** Returns the value of the `engineVersion` field.  */
    @NativeType("uint32_t")
    fun engineVersion(): Int {
        return nengineVersion(address())
    }

    /** Returns the value of the `apiVersion` field.  */
    @NativeType("uint32_t")
    fun apiVersion(): Int {
        return napiVersion(address())
    }

    /** Sets the specified value to the `sType` field.  */
    fun sType(@NativeType("VkStructureType") value: Int): ApplicationInfo {
        nsType(address(), value)
        return this
    }

    /** Sets the specified value to the `pNext` field.  */
    fun pNext(@NativeType("void const *") value: Long): ApplicationInfo {
        npNext(address(), value)
        return this
    }

    /** Sets the address of the specified encoded string to the `pApplicationName` field.  */
    fun pApplicationName(@NativeType("char const *") value: ByteBuffer?): ApplicationInfo {
        npApplicationName(address(), value)
        return this
    }

    /** Sets the specified value to the `applicationVersion` field.  */
    fun applicationVersion(@NativeType("uint32_t") value: Int): ApplicationInfo {
        napplicationVersion(address(), value)
        return this
    }

    /** Sets the address of the specified encoded string to the `pEngineName` field.  */
    fun pEngineName(@NativeType("char const *") value: ByteBuffer?): ApplicationInfo {
        npEngineName(address(), value)
        return this
    }

    /** Sets the specified value to the `engineVersion` field.  */
    fun engineVersion(@NativeType("uint32_t") value: Int): ApplicationInfo {
        nengineVersion(address(), value)
        return this
    }

    /** Sets the specified value to the `apiVersion` field.  */
    fun apiVersion(@NativeType("uint32_t") value: Int): ApplicationInfo {
        napiVersion(address(), value)
        return this
    }

    /** Initializes this struct with the specified values.  */
    operator fun set(
            sType: Int,
            pNext: Long,
            pApplicationName: ByteBuffer?,
            applicationVersion: Int,
            pEngineName: ByteBuffer?,
            engineVersion: Int,
            apiVersion: Int
    ): ApplicationInfo {
        sType(sType)
        pNext(pNext)
        pApplicationName(pApplicationName)
        applicationVersion(applicationVersion)
        pEngineName(pEngineName)
        engineVersion(engineVersion)
        apiVersion(apiVersion)

        return this
    }

    /**
     * Copies the specified struct data to this struct.
     *
     * @param src the source struct
     *
     * @return this struct
     */
    fun set(src: ApplicationInfo): ApplicationInfo {
        memCopy(src.address(), address(), SIZEOF.toLong())
        return this
    }

    // -----------------------------------

    /** An array of [ApplicationInfo] structs.  */
    class Buffer : StructBuffer<ApplicationInfo, Buffer>, NativeResource {

        /**
         * Creates a new `VkApplicationInfo.Buffer` instance backed by the specified container.
         *
         * Changes to the container's content will be visible to the struct buffer instance and vice versa. The two buffers' position, limit, and mark values
         * will be independent. The new buffer's position will be zero, its capacity and its limit will be the number of bytes remaining in this buffer divided
         * by [ApplicationInfo.SIZEOF], and its mark will be undefined.
         *
         *
         * The created buffer instance holds a strong reference to the container object.
         */
        constructor(container: ByteBuffer) : super(container, container.remaining() / SIZEOF) {}

        constructor(address: Long, cap: Int) : super(address, null, -1, 0, cap, cap) {}

        internal constructor(address: Long, container: ByteBuffer?, mark: Int, pos: Int, lim: Int, cap: Int) : super(address, container, mark, pos, lim, cap) {}

        override fun self(): Buffer {
            return this
        }

        override fun getElementFactory(): ApplicationInfo {
            return ELEMENT_FACTORY
        }

        /** Returns the value of the `sType` field.  */
        @NativeType("VkStructureType")
        fun sType(): Int {
            return ApplicationInfo.nsType(address())
        }

        /** Returns the value of the `pNext` field.  */
        @NativeType("void const *")
        fun pNext(): Long {
            return ApplicationInfo.npNext(address())
        }

        /** Returns a [ByteBuffer] view of the null-terminated string pointed to by the `pApplicationName` field.  */
        @NativeType("char const *")
        fun pApplicationName(): ByteBuffer? {
            return ApplicationInfo.npApplicationName(address())
        }

        /** Decodes the null-terminated string pointed to by the `pApplicationName` field.  */
        @NativeType("char const *")
        fun pApplicationNameString(): String? {
            return ApplicationInfo.npApplicationNameString(address())
        }

        /** Returns the value of the `applicationVersion` field.  */
        @NativeType("uint32_t")
        fun applicationVersion(): Int {
            return ApplicationInfo.napplicationVersion(address())
        }

        /** Returns a [ByteBuffer] view of the null-terminated string pointed to by the `pEngineName` field.  */
        @NativeType("char const *")
        fun pEngineName(): ByteBuffer? {
            return ApplicationInfo.npEngineName(address())
        }

        /** Decodes the null-terminated string pointed to by the `pEngineName` field.  */
        @NativeType("char const *")
        fun pEngineNameString(): String? {
            return ApplicationInfo.npEngineNameString(address())
        }

        /** Returns the value of the `engineVersion` field.  */
        @NativeType("uint32_t")
        fun engineVersion(): Int {
            return ApplicationInfo.nengineVersion(address())
        }

        /** Returns the value of the `apiVersion` field.  */
        @NativeType("uint32_t")
        fun apiVersion(): Int {
            return ApplicationInfo.napiVersion(address())
        }

        /** Sets the specified value to the `sType` field.  */
        fun sType(@NativeType("VkStructureType") value: Int): ApplicationInfo.Buffer {
            ApplicationInfo.nsType(address(), value)
            return this
        }

        /** Sets the specified value to the `pNext` field.  */
        fun pNext(@NativeType("void const *") value: Long): ApplicationInfo.Buffer {
            ApplicationInfo.npNext(address(), value)
            return this
        }

        /** Sets the address of the specified encoded string to the `pApplicationName` field.  */
        fun pApplicationName(@NativeType("char const *") value: ByteBuffer?): ApplicationInfo.Buffer {
            ApplicationInfo.npApplicationName(address(), value)
            return this
        }

        /** Sets the specified value to the `applicationVersion` field.  */
        fun applicationVersion(@NativeType("uint32_t") value: Int): ApplicationInfo.Buffer {
            ApplicationInfo.napplicationVersion(address(), value)
            return this
        }

        /** Sets the address of the specified encoded string to the `pEngineName` field.  */
        fun pEngineName(@NativeType("char const *") value: ByteBuffer?): ApplicationInfo.Buffer {
            ApplicationInfo.npEngineName(address(), value)
            return this
        }

        /** Sets the specified value to the `engineVersion` field.  */
        fun engineVersion(@NativeType("uint32_t") value: Int): ApplicationInfo.Buffer {
            ApplicationInfo.nengineVersion(address(), value)
            return this
        }

        /** Sets the specified value to the `apiVersion` field.  */
        fun apiVersion(@NativeType("uint32_t") value: Int): ApplicationInfo.Buffer {
            ApplicationInfo.napiVersion(address(), value)
            return this
        }

        companion object {

            private val ELEMENT_FACTORY = ApplicationInfo.create(-1L)
        }

    }

    companion object {

        /** The struct size in bytes.  */
        val SIZEOF: Int

        /** The struct alignment in bytes.  */
        val ALIGNOF: Int

        /** The struct member offsets.  */
        val STYPE: Int
        val PNEXT: Int
        val PAPPLICATIONNAME: Int
        val APPLICATIONVERSION: Int
        val PENGINENAME: Int
        val ENGINEVERSION: Int
        val APIVERSION: Int

        init {
            val layout = Struct.__struct(
                    Struct.__member(4),
                    Struct.__member(Pointer.POINTER_SIZE),
                    Struct.__member(Pointer.POINTER_SIZE),
                    Struct.__member(4),
                    Struct.__member(Pointer.POINTER_SIZE),
                    Struct.__member(4),
                    Struct.__member(4)
            )

            SIZEOF = layout.size
            ALIGNOF = layout.alignment

            STYPE = layout.offsetof(0)
            PNEXT = layout.offsetof(1)
            PAPPLICATIONNAME = layout.offsetof(2)
            APPLICATIONVERSION = layout.offsetof(3)
            PENGINENAME = layout.offsetof(4)
            ENGINEVERSION = layout.offsetof(5)
            APIVERSION = layout.offsetof(6)
        }

        // -----------------------------------

        /** Returns a new `VkApplicationInfo` instance allocated with [memAlloc][MemoryUtil.memAlloc]. The instance must be explicitly freed.  */
        fun malloc(): ApplicationInfo {
            return Struct.wrap(ApplicationInfo::class.java, nmemAllocChecked(SIZEOF.toLong()))
        }

        /** Returns a new `VkApplicationInfo` instance allocated with [memCalloc][MemoryUtil.memCalloc]. The instance must be explicitly freed.  */
        fun calloc(): ApplicationInfo {
            return Struct.wrap(ApplicationInfo::class.java, nmemCallocChecked(1, SIZEOF.toLong()))
        }

        /** Returns a new `VkApplicationInfo` instance allocated with [BufferUtils].  */
        fun create(): ApplicationInfo {
            val container = BufferUtils.createByteBuffer(SIZEOF)
            return Struct.wrap(ApplicationInfo::class.java, memAddress(container), container)
        }

        /** Returns a new `VkApplicationInfo` instance for the specified memory address.  */
        fun create(address: Long): ApplicationInfo {
            return Struct.wrap(ApplicationInfo::class.java, address)
        }

        /** Like [create][.create], but returns `null` if `address` is `NULL`.  */
        fun createSafe(address: Long): ApplicationInfo? {
            return if (address == NULL) null else Struct.wrap(ApplicationInfo::class.java, address)
        }

        /**
         * Returns a new [ApplicationInfo.Buffer] instance allocated with [memAlloc][MemoryUtil.memAlloc]. The instance must be explicitly freed.
         *
         * @param capacity the buffer capacity
         */
        fun malloc(capacity: Int): ApplicationInfo.Buffer {
            return Pointer.Default.wrap(Buffer::class.java, nmemAllocChecked(Struct.__checkMalloc(capacity, SIZEOF)), capacity)
        }

        /**
         * Returns a new [ApplicationInfo.Buffer] instance allocated with [memCalloc][MemoryUtil.memCalloc]. The instance must be explicitly freed.
         *
         * @param capacity the buffer capacity
         */
        fun calloc(capacity: Int): ApplicationInfo.Buffer {
            return Pointer.Default.wrap(Buffer::class.java, nmemCallocChecked(capacity.toLong(), SIZEOF.toLong()), capacity)
        }

        /**
         * Returns a new [ApplicationInfo.Buffer] instance allocated with [BufferUtils].
         *
         * @param capacity the buffer capacity
         */
        fun create(capacity: Int): ApplicationInfo.Buffer {
            val container = Struct.__create(capacity, SIZEOF)
            return Pointer.Default.wrap(Buffer::class.java, memAddress(container), capacity, container)
        }

        /**
         * Create a [ApplicationInfo.Buffer] instance at the specified memory.
         *
         * @param address  the memory address
         * @param capacity the buffer capacity
         */
        fun create(address: Long, capacity: Int): ApplicationInfo.Buffer {
            return Pointer.Default.wrap(Buffer::class.java, address, capacity)
        }

        /** Like [create][.create], but returns `null` if `address` is `NULL`.  */
        fun createSafe(address: Long, capacity: Int): ApplicationInfo.Buffer? {
            return if (address == NULL) null else Pointer.Default.wrap(Buffer::class.java, address, capacity)
        }

        /**
         * Returns a new `VkApplicationInfo` instance allocated on the specified [MemoryStack].
         *
         * @param stack the stack from which to allocate
         */
        @JvmOverloads
        fun mallocStack(stack: MemoryStack = stackGet()): ApplicationInfo {
            return Struct.wrap(ApplicationInfo::class.java, stack.nmalloc(ALIGNOF, SIZEOF))
        }

        /**
         * Returns a new `VkApplicationInfo` instance allocated on the specified [MemoryStack] and initializes all its bits to zero.
         *
         * @param stack the stack from which to allocate
         */
        @JvmOverloads
        fun callocStack(stack: MemoryStack = stackGet()): ApplicationInfo {
            return Struct.wrap(ApplicationInfo::class.java, stack.ncalloc(ALIGNOF, 1, SIZEOF))
        }

        /**
         * Returns a new [ApplicationInfo.Buffer] instance allocated on the specified [MemoryStack].
         *
         * @param stack the stack from which to allocate
         * @param capacity the buffer capacity
         */
        @JvmOverloads
        fun mallocStack(capacity: Int, stack: MemoryStack = stackGet()): ApplicationInfo.Buffer {
            return Pointer.Default.wrap(Buffer::class.java, stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity)
        }

        /**
         * Returns a new [ApplicationInfo.Buffer] instance allocated on the specified [MemoryStack] and initializes all its bits to zero.
         *
         * @param stack the stack from which to allocate
         * @param capacity the buffer capacity
         */
        @JvmOverloads
        fun callocStack(capacity: Int, stack: MemoryStack = stackGet()): ApplicationInfo.Buffer {
            return Pointer.Default.wrap(Buffer::class.java, stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity)
        }

        // -----------------------------------

        /** Unsafe version of [.sType].  */
        fun nsType(struct: Long): Int {
            return Pointer.Default.UNSAFE.getInt(null, struct + ApplicationInfo.STYPE)
        }

        /** Unsafe version of [.pNext].  */
        fun npNext(struct: Long): Long {
            return memGetAddress(struct + ApplicationInfo.PNEXT)
        }

        /** Unsafe version of [.pApplicationName].  */
        fun npApplicationName(struct: Long): ByteBuffer? {
            return memByteBufferNT1Safe(memGetAddress(struct + ApplicationInfo.PAPPLICATIONNAME))
        }

        /** Unsafe version of [.pApplicationNameString].  */
        fun npApplicationNameString(struct: Long): String? {
            return memUTF8Safe(memGetAddress(struct + ApplicationInfo.PAPPLICATIONNAME))
        }

        /** Unsafe version of [.applicationVersion].  */
        fun napplicationVersion(struct: Long): Int {
            return Pointer.Default.UNSAFE.getInt(null, struct + ApplicationInfo.APPLICATIONVERSION)
        }

        /** Unsafe version of [.pEngineName].  */
        fun npEngineName(struct: Long): ByteBuffer? {
            return memByteBufferNT1Safe(memGetAddress(struct + ApplicationInfo.PENGINENAME))
        }

        /** Unsafe version of [.pEngineNameString].  */
        fun npEngineNameString(struct: Long): String? {
            return memUTF8Safe(memGetAddress(struct + ApplicationInfo.PENGINENAME))
        }

        /** Unsafe version of [.engineVersion].  */
        fun nengineVersion(struct: Long): Int {
            return Pointer.Default.UNSAFE.getInt(null, struct + ApplicationInfo.ENGINEVERSION)
        }

        /** Unsafe version of [.apiVersion].  */
        fun napiVersion(struct: Long): Int {
            return Pointer.Default.UNSAFE.getInt(null, struct + ApplicationInfo.APIVERSION)
        }

        /** Unsafe version of [sType][.sType].  */
        fun nsType(struct: Long, value: Int) {
            Pointer.Default.UNSAFE.putInt(null, struct + ApplicationInfo.STYPE, value)
        }

        /** Unsafe version of [pNext][.pNext].  */
        fun npNext(struct: Long, value: Long) {
            memPutAddress(struct + ApplicationInfo.PNEXT, value)
        }

        /** Unsafe version of [pApplicationName][.pApplicationName].  */
        fun npApplicationName(struct: Long, value: ByteBuffer?) {
            if (CHECKS) {
                checkNT1Safe(value)
            }
            memPutAddress(struct + ApplicationInfo.PAPPLICATIONNAME, memAddressSafe(value))
        }

        /** Unsafe version of [applicationVersion][.applicationVersion].  */
        fun napplicationVersion(struct: Long, value: Int) {
            Pointer.Default.UNSAFE.putInt(null, struct + ApplicationInfo.APPLICATIONVERSION, value)
        }

        /** Unsafe version of [pEngineName][.pEngineName].  */
        fun npEngineName(struct: Long, value: ByteBuffer?) {
            if (CHECKS) {
                checkNT1Safe(value)
            }
            memPutAddress(struct + ApplicationInfo.PENGINENAME, memAddressSafe(value))
        }

        /** Unsafe version of [engineVersion][.engineVersion].  */
        fun nengineVersion(struct: Long, value: Int) {
            Pointer.Default.UNSAFE.putInt(null, struct + ApplicationInfo.ENGINEVERSION, value)
        }

        /** Unsafe version of [apiVersion][.apiVersion].  */
        fun napiVersion(struct: Long, value: Int) {
            Pointer.Default.UNSAFE.putInt(null, struct + ApplicationInfo.APIVERSION, value)
        }
    }

}// -----------------------------------
/** Returns a new `VkApplicationInfo` instance allocated on the thread-local [MemoryStack].  */
/** Returns a new `VkApplicationInfo` instance allocated on the thread-local [MemoryStack] and initializes all its bits to zero.  */
/**
 * Returns a new [vsApplicationInfo.Buffer] instance allocated on the thread-local [MemoryStack].
 *
 * @param capacity the buffer capacity
 */
/**
 * Returns a new [vsApplicationInfo.Buffer] instance allocated on the thread-local [MemoryStack] and initializes all its bits to zero.
 *
 * @param capacity the buffer capacity
 */