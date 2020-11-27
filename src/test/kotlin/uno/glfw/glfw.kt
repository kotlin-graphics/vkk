package uno.glfw

import glm_.i
import gln.misc.glDebugCallback
import kool.Adr
import kool.IntPtr
import kool.mInt
import org.lwjgl.glfw.*
import org.lwjgl.glfw.GLFW.*
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.system.Platform
import org.lwjgl.system.Pointer
import uno.glfw.windowHint.Profile
import uno.kotlin.parseInt

/**
 * Created by elect on 22/04/17.
 */

object glfw {

    val versionMajor get() = GLFW_VERSION_MAJOR
    val versionMinor get() = GLFW_VERSION_MAJOR
    val versionRevision get() = GLFW_VERSION_REVISION

    // --- [ glfwInit ] ---

    /** Short version of:
     *  glfw.init()
     *  glfw.windowHint {
     *      context.version = "3.2"
     *      windowHint.profile = "core"
     *  }
     *  + default error callback
     */
    @Throws(RuntimeException::class)
    fun init(version: String, profile: Profile = Profile.core, installDefaultErrorCallback: Boolean = true) {
        init(installDefaultErrorCallback)
        windowHint {
            context.version = version
            val v = version[0].parseInt() * 10 + version[1].parseInt()
            if (v >= 32) // The concept of a core profile does not exist prior to OpenGL 3.2
                this.profile = profile
        }
    }

    @Throws(RuntimeException::class)
    fun init(errorCallback: GLFWErrorCallbackT) {
        this.errorCallback = errorCallback
        init()
    }

    @Throws(RuntimeException::class)
    fun init(installDefaultErrorCallback: Boolean) {
        if (installDefaultErrorCallback)
            errorCallback = defaultErrorCallback
        init()
    }

    @Throws(RuntimeException::class)
    fun init() {

        if (!glfwInit())
            throw RuntimeException("Unable to initialize GLFW")

        // This window hint is required to use OpenGL 3.1+ on macOS
        if (Platform.get() == Platform.MACOSX)
            windowHint.forwardComp = true
    }

    // --- [ glfwTerminate ] ---

    fun terminate() {
        glfwTerminate()
        nErrorCallback.free()
        glDebugCallback?.free()
    }

    // --- [ glfwInitHint ] ---

    fun <T> initHint(block: initHint.() -> T) = initHint.block()

    // --- [ glfwGetVersion ] ---

    val version: IntArray
        get() = stak { s ->
            val p = s.mInt(3)
            nglfwGetVersion(p.adr, (p + 1).adr, (p + 2).adr)
            IntArray(3) { p[it] }
        }

    // --- [ glfwGetVersionString ] ---

    val versionString: String
        get() = glfwGetVersionString()

    // --- [ glfwGetError ] ---

    val error: Error
        get() = stak {
            val pointer = it.mallocPointer(1)
            val code = glfwGetError(pointer)
            errorDescription = when {
                code != GLFW_NO_ERROR -> memUTF8(pointer[0])
                else -> ""
            }
            return Error of pointer[0].i
        }
    var errorDescription = ""

    enum class Error(val i: Int) {
        none(GLFW_NO_ERROR),
        notInitialized(GLFW_NOT_INITIALIZED),
        noCurrentContext(GLFW_NO_CURRENT_CONTEXT),
        invalidEnum(GLFW_INVALID_ENUM),
        invalidValue(GLFW_INVALID_VALUE),
        outOfMemory(GLFW_OUT_OF_MEMORY),
        apiUnavailable(GLFW_API_UNAVAILABLE),
        versionUnavailable(GLFW_VERSION_UNAVAILABLE),
        platformError(GLFW_PLATFORM_ERROR),
        formatUnavailable(GLFW_FORMAT_UNAVAILABLE),
        noWindowContext(GLFW_NO_WINDOW_CONTEXT);

        companion object {
            infix fun of(i: Int) = values().first { it.i == i }
        }
    }

    // --- [ glfwSetErrorCallback ] ---

    val nErrorCallback: GLFWErrorCallback = GLFWErrorCallback.create { error, description -> errorCallback?.invoke(Error of error, memUTF8(description)) }
    val defaultErrorCallback: GLFWErrorCallbackT = { error, description -> System.err.println("glfw $error error: $description") }

    var errorCallback: GLFWErrorCallbackT? = null
        set(value) {
            if (value != null) {
                field = value
                val previous = glfwSetErrorCallback(nErrorCallback)
                if (previous != null && previous != nErrorCallback)
                    previous.free()
            } else
                nglfwSetErrorCallback(NULL)
        }

    val monitors: Array<GlfwMonitor>
        get() = stak { s ->
            val pCount = s.mInt()
            val pMonitors = nglfwGetMonitors(pCount.adr)
            Array(pCount[0]) {
                GlfwMonitor(memGetAddress(pMonitors + it * Pointer.POINTER_SIZE))
            }
        }

    // --- [ glfwGetPrimaryMonitor ] ---

    val primaryMonitor: GlfwMonitor
        get() = GlfwMonitor(glfwGetPrimaryMonitor())

    /** [JVM] */
    val primaryMonitorVideoMode: GlfwVidMode?
        get() = when (val pMode = nglfwGetVideoMode(primaryMonitor.handle)) {
            NULL -> null
            else -> GlfwVidMode(IntPtr(pMode))
        }

    // --- [ glfwGetMonitorPos ] ---
    // --- [ glfwGetMonitorWorkarea ] ---
    // --- [ glfwGetMonitorPhysicalSize ] ---
    // --- [ glfwGetMonitorContentScale ] ---
    // --- [ glfwGetMonitorName ] ---
    // --- [ glfwSetMonitorUserPointer ] ---
    // --- [ glfwGetMonitorUserPointer ] ---
    // -> GlfwMonitor class

    // --- [ glfwSetMonitorCallback ] ---
    fun setMonitorCallback(cbfun: GLFWMonitorCallbackI?): GLFWMonitorCallback? = glfwSetMonitorCallback(cbfun)

    // --- [ glfwGetVideoModes ] ---
    // --- [ glfwGetVideoMode ] ---
    // --- [ glfwSetGamma ] ---
    // --- [ glfwGetGammaRamp ] ---
    // --- [ glfwSetGammaRamp ] ---
    // -> GlfwMonitor class

    // --- [ glfwDefaultWindowHints ] ---
    fun resetWindowHints() = glfwDefaultWindowHints()

    // --- [ glfwWindowHint ] ---
    // --- [ glfwWindowHintString ] ---
    fun <T> windowHint(block: windowHint.() -> T) = windowHint.block()

    // --- [ glfwCreateWindow ] ---
    // --- [ glfwDestroyWindow ] ---
    // --- [ glfwWindowShouldClose ] ---
    // --- [ glfwSetWindowShouldClose ] ---
    // --- [ glfwSetWindowTitle ] ---
    // --- [ glfwSetWindowIcon ] ---
    // --- [ glfwGetWindowPos ] ---
    // --- [ glfwSetWindowPos ] ---
    // --- [ glfwGetWindowSize ] ---
    // --- [ glfwSetWindowSizeLimits ] ---
    // --- [ glfwSetWindowAspectRatio ] ---
    // --- [ glfwSetWindowSize ] ---
    // --- [ glfwGetFramebufferSize ] ---
    // --- [ glfwGetWindowFrameSize ] ---
    // --- [ glfwGetWindowContentScale ] ---
    // --- [ glfwGetWindowOpacity ] ---
    // --- [ glfwSetWindowOpacity ] ---
    // --- [ glfwIconifyWindow ] ---
    // --- [ glfwRestoreWindow ] ---
    // --- [ glfwMaximizeWindow ] ---
    // --- [ glfwShowWindow ] ---
    // --- [ glfwHideWindow ] ---
    // --- [ glfwFocusWindow ] ---
    // --- [ glfwRequestWindowAttention ] ---
    // --- [ glfwGetWindowMonitor ] ---
    // --- [ glfwSetWindowMonitor ] ---
    // --- [ glfwGetWindowAttrib ] ---
    // --- [ glfwSetWindowAttrib ] ---
    // --- [ glfwSetWindowUserPointer ] ---
    // --- [ glfwGetWindowUserPointer ] ---
    // --- [ glfwSetWindowPosCallback ] ---
    // --- [ glfwSetWindowSizeCallback ] ---
    // --- [ glfwSetWindowCloseCallback ] ---
    // --- [ glfwSetWindowRefreshCallback ] ---
    // --- [ glfwSetWindowFocusCallback ] ---
    // --- [ glfwSetWindowIconifyCallback ] ---
    // --- [ glfwSetWindowMaximizeCallback ] ---
    // --- [ glfwSetFramebufferSizeCallback ] ---
    // --- [ glfwSetWindowContentScaleCallback ] ---
    // -> GlfwWindow

    // --- [ glfwPollEvents ] ---
    fun pollEvents() = glfwPollEvents()

    // --- [ glfwWaitEvents ] ---
    fun waitEvents() = glfwWaitEvents()

    // --- [ glfwWaitEventsTimeout ] ---
    fun waitEventsTimeout(timeout: Double) = glfwWaitEventsTimeout(timeout)

    // --- [ glfwPostEmptyEvent ] ---
    fun postEmptyEvent() = glfwPostEmptyEvent()

    // --- [ glfwGetInputMode ] ---
    // --- [ glfwSetInputMode ] ---
    // -> GlfwWindow

    // --- [ glfwRawMouseMotionSupported ] ---
    val isRawMouseMotionSupported: Boolean
        get() = glfwRawMouseMotionSupported()

    // --- [ glfwGetKeyName ] ---
    // also on Key enum
    fun getKeyName(scancode: Int): String? = glfwGetKeyName(GLFW_KEY_UNKNOWN, scancode)

    // --- [ glfwGetKeyScancode ] ---
    // -> Key

    // --- [ glfwGetKey ] ---
    // --- [ glfwGetMouseButton ] ---
    // --- [ glfwGetCursorPos ] ---
    // --- [ glfwSetCursorPos ] ---
    // -> GlfwWindow

    // --- [ glfwCreateCursor ] ---
    fun createCursor(image: GLFWImage, xhot: Int, yhot: Int) = GlfwCursor(glfwCreateCursor(image, xhot, yhot))

    // --- [ glfwCreateStandardCursor ] ---

    enum class CursorShape(val i: Int) {
        arrow(GLFW_ARROW_CURSOR),
        ibeam(GLFW_IBEAM_CURSOR),
        crosshair(GLFW_CROSSHAIR_CURSOR),
        hand(GLFW_HAND_CURSOR),
        hResize(GLFW_HRESIZE_CURSOR),
        vResize(GLFW_VRESIZE_CURSOR)
    }

    // --- [ glfwCreateStandardCursor ] ---
    fun createStandardCursor(shape: CursorShape) = GlfwCursor(glfwCreateStandardCursor(shape.i))

    // --- [ glfwDestroyCursor ] ---
    // -> GlfwCursor

    // --- [ glfwSetCursor ] ---
    // --- [ glfwSetKeyCallback ] ---
    // --- [ glfwSetCharCallback ] ---
    // --- [ glfwSetCharModsCallback ] ---
    // --- [ glfwSetMouseButtonCallback ] ---
    // --- [ glfwSetCursorPosCallback ] ---
    // --- [ glfwSetCursorEnterCallback ] ---
    // --- [ glfwSetScrollCallback ] ---
    // --- [ glfwSetDropCallback ] ---
    // -> GlfwWindow

    // --- [ glfwJoystickPresent ] ---
    // --- [ glfwGetJoystickAxes ] ---
    // --- [ glfwGetJoystickButtons ] ---
    // --- [ glfwGetJoystickHats ] ---
    // --- [ glfwGetJoystickName ] ---
    // --- [ glfwGetJoystickGUID ] ---
    // --- [ glfwSetJoystickUserPointer ] ---
    // --- [ glfwGetJoystickUserPointer ] ---
    // --- [ glfwJoystickIsGamepad ] ---
    // --- [ glfwSetJoystickCallback ] ---
    // -> Joystick

    // --- [ glfwUpdateGamepadMappings ] ---
    fun updateGamepadMappings(string: String): Boolean = stak.asciiAdr(string) { nglfwUpdateGamepadMappings(it) } == GLFW_TRUE

    // --- [ glfwGetGamepadName ] ---
    // --- [ glfwGetGamepadState ] ---
    // -> Joystick

    // --- [ glfwSetClipboardString ] ---
    // --- [ glfwGetClipboardString ] ---
    // -> GlfwWindow

    // --- [ glfwGetTime ] ---
    // --- [ glfwSetTime ] ---
    var time: Seconds
        get() = glfwGetTime()
        set(value) = glfwSetTime(value)

    // --- [ glfwGetTimerValue ] ---
    val timerValue: Long
        get() = glfwGetTimerValue()

    // --- [ glfwGetTimerFrequency ] ---
    val timerFrequency: Hz
        get() = glfwGetTimerFrequency()

    // --- [ glfwMakeContextCurrent ] ---
    // -> GlfwWindow

    // --- [ glfwGetCurrentContext ] ---
    val currentContext: GlfwWindowHandle
        get() = GlfwWindowHandle(glfwGetCurrentContext())

    // --- [ glfwSwapBuffers ] ---
    // -> GlfwWindow

    // --- [ glfwSwapInterval ] ---

    var swapInterval: VSync = VSync.ON
        set(value) {
            glfwSwapInterval(value.i)
            field = value
        }

    // --- [ glfwExtensionSupported ] ---
    fun extensionSupported(extension: CharSequence): Boolean = glfwExtensionSupported(extension)

    // --- [ glfwGetProcAddress ] ---
    fun getProcAddress(procName: CharSequence): Adr = glfwGetProcAddress(procName)


//    val resolution: Vec2i
//        get() = Vec2i(videoMode.width, videoMode.height)


    fun attachWin32Window(handle: HWND): GlfwWindowHandle = GlfwWindowHandle(GLFWNativeWin32.glfwAttachWin32Window(handle.L, NULL))

    // [JVM] dsl
    inline operator fun invoke(block: glfw.() -> Unit) = glfw.block()
}