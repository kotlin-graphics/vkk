package identifiers

import glm_.min
import kool.Ptr
import kool.adr
import org.lwjgl.system.*
import org.lwjgl.system.APIUtil.apiLog
import org.lwjgl.system.JNI.callPI
import org.lwjgl.system.JNI.callPPP
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.system.Platform.*
import org.lwjgl.vulkan.VK10.*
import org.lwjgl.vulkan.VK11
import vkk.stak
import kotlin.math.min

/**
 * This class loads the Vulkan library into the JVM process.
 *
 * @see Configuration#VULKAN_LIBRARY_NAME
 * @see Configuration#VULKAN_EXPLICIT_INIT
 */
object VK {

    var functionProvider: FunctionProvider? = null
        private set

    var globalCommands: GlobalCommands? = null
        private set

    init {
        if (!Configuration.VULKAN_EXPLICIT_INIT.get(false))
            create()
    }

    val module = "org.lwjgl.vulkan"
    /**
     * Loads the Vulkan shared library, using the default library name.
     *
     * @see #create(String)
     */
    fun create() {
        val claz = VK.javaClass
        val VK = when (Platform.get()) {
            LINUX -> Library.loadNative(claz, module, Configuration.VULKAN_LIBRARY_NAME, "libvulkan.so.1")
            WINDOWS -> Library.loadNative(claz, module, Configuration.VULKAN_LIBRARY_NAME, "vulkan-1")
            MACOSX -> {
                Configuration.VULKAN_LIBRARY_NAME.get()?.let {
                    // use the override without a fallback
                    Library.loadNative(claz, module, it)
                } ?: try {
                    // no override, try to use the bundled implementation (if available)
                    Library.loadNative(claz, module, "MoltenVK", true)
                } catch (_: Throwable) {
                    // TODO: print if found but loading failed (print in verbose debugloader mode?)
                    // TODO: must print all suppressed exceptions
                    // fallback to the Vulkan loader
                    Library.loadNative(claz, module, "libvulkan.1.dylib")
                }
            }
            else -> throw IllegalStateException()
        }
        create(VK)
    }

    /**
     * Loads the Vulkan shared library, using the specified library name.
     *
     * <p>The {@link FunctionProvider} instance created by this method can only be used to retrieve global commands and commands exposed statically by the
     * Vulkan shared library.</p>
     *
     * @param libName the shared library name
     *
     * @see #create(FunctionProvider)
     */
    fun create(libName: String) = create(Library.loadNative(VK.javaClass, module, libName))

    /**
     * Initializes Vulkan with the specified {@link FunctionProvider}. This method can be used to implement custom Vulkan library loading.
     *
     * @param functionProvider the provider of Vulkan function addresses
     */
    fun create(functionProvider: FunctionProvider) {
        if (VK.functionProvider != null) throw IllegalStateException("Vulkan has already been created.")

        VK.functionProvider = functionProvider
        globalCommands = GlobalCommands(functionProvider)
    }

    /** Unloads the Vulkan shared library. */
    fun destroy() {
        if (functionProvider == null) return
        else (functionProvider as? NativeResource)?.free()
        functionProvider = null
        globalCommands = null
    }

    private fun <T> check(t: T?): T = t ?: throw IllegalStateException("Vulkan library has not been loaded.")

    /**
     * Returns a {@code uint32_t}, which is the version of Vulkan supported by instance-level functionality, encoded as described in the
     * <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.0-extensions/html/vkspec.html#fundamentals-versionnum">API Version Numbers and
     * Semantics</a> section.
     *
     * <p>This method can be called before creating a Vulkan instance. The returned value can be used to set the {@link VkApplicationInfo}{@code ::apiVersion}
     * member.</p>
     */
    val instanceVersionSupported: Int
        get() {
            val EnumerateInstanceVersion = globalCommands!!.vkEnumerateInstanceVersion
            var res = VK_API_VERSION_1_0
            if (EnumerateInstanceVersion != NULL)
                stak {
                    val pi = it.callocInt(1)
                    VK11.vkEnumerateInstanceVersion(pi)
                    if (callPI(pi.adr, EnumerateInstanceVersion) == VK_SUCCESS)
                        res = pi[0]
                }
            return res
        }

    class GlobalCommands(library: FunctionProvider) {

        val vkGetInstanceProcAddr = library.getFunctionAddress("vkGetInstanceProcAddr").also {
            if (it == NULL) throw IllegalArgumentException("A critical function is missing. Make sure that Vulkan is available.")
        }

        val vkCreateInstance = getFunctionAddress("vkCreateInstance")
        val vkEnumerateInstanceExtensionProperties = getFunctionAddress("vkEnumerateInstanceExtensionProperties")
        val vkEnumerateInstanceLayerProperties = getFunctionAddress("vkEnumerateInstanceLayerProperties")
        val vkEnumerateInstanceVersion = getFunctionAddress("vkEnumerateInstanceVersion", false)

        private fun getFunctionAddress(name: String, required: Boolean = true) = stak.asciiAdr(name) { pName ->
            callPPP(NULL, pName, vkGetInstanceProcAddr).also {
                if (it == NULL && required) throw IllegalArgumentException("A critical function is missing. Make sure that Vulkan is available.")
            }
        }
    }

    fun getEnabledExtensionSet(apiVersion: Int, extensionNames: Collection<String>?): Set<String> {
        val enabledExtensions = HashSet<String>(16)

        val majorVersion = VK_VERSION_MAJOR(apiVersion)
        val minorVersion = VK_VERSION_MINOR(apiVersion)

        val VK_VERSIONS = intArrayOf(
            1 // Vulkan 1.0 to 1.1
        )

        val maxMajor = majorVersion min VK_VERSIONS.size
        for (M in 1..maxMajor) {
            var maxMinor = VK_VERSIONS[M - 1]
            if (M == majorVersion)
                maxMinor = min(minorVersion, maxMinor)
            for (m in 0..maxMinor)
                enabledExtensions += "Vulkan$M$m"
        }

        extensionNames?.let { enabledExtensions += it }

        return enabledExtensions
    }

    fun checkExtension(extension: String, available: Boolean): Boolean {
        if (!available) {
            apiLog("[VK] $extension was reported as available but an entry point is missing.")
            return false
        }
        return true
    }
}

fun FunctionProvider.isSupported(
    functionName: String,
    caps: MutableMap<String, Long>,
    satisfiedDependency: Boolean
): Boolean =
    !satisfiedDependency || isSupported(functionName, caps)

fun FunctionProvider.isSupported(functionName: String, caps: MutableMap<String, Long>): Boolean {
    val address = getFunctionAddress(functionName)
    if (address != NULL) {
        caps[functionName] = address
        return true
    }
    return false
}