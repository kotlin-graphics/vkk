package uno.glfw

import glm_.bool
import glm_.f
import glm_.i
import glm_.vec2.Vec2
import glm_.vec2.Vec2d
import glm_.vec2.Vec2i
import glm_.vec4.Vec4i
import gln.cap.Caps
import gln.misc.GlDebugSeverity
import gln.misc.GlDebugSource
import gln.misc.GlDebugType
import kool.*
import org.lwjgl.glfw.*
import org.lwjgl.glfw.GLFW.*
import org.lwjgl.opengl.GL
import org.lwjgl.opengl.GL43C
import org.lwjgl.opengl.GLUtil
import org.lwjgl.system.Callback
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import uno.kotlin.getOrfirst
import java.util.*
import java.util.function.BooleanSupplier
import java.util.function.Consumer

/**
 * Created by GBarbieri on 24.04.2017.
 */

// --- [ glfwCreateWindow ] ---

open class GlfwWindow(var handle: GlfwWindowHandle) {

    @Throws(RuntimeException::class)
    constructor(windowSize: Vec2i,
                title: String,
                monitor: GlfwMonitor? = null,
                position: Vec2i = Vec2i(Int.MIN_VALUE),
                installCallbacks: Boolean = true) : this(windowSize.x, windowSize.y, title, monitor, position, installCallbacks)

    @Throws(RuntimeException::class)
    constructor(x: Int,
                title: String,
                monitor: GlfwMonitor? = null,
                position: Vec2i = Vec2i(Int.MIN_VALUE),
                installCallbacks: Boolean = true) : this(x, x, title, monitor, position, installCallbacks)

    @Throws(RuntimeException::class)
    constructor(width: Int, height: Int,
                title: String,
                monitor: GlfwMonitor? = null,
                position: Vec2i = Vec2i(Int.MIN_VALUE),
                installCallbacks: Boolean = true) :
            this(GlfwWindowHandle(glfwCreateWindow(width, height, title, monitor?.handle ?: NULL, NULL))) {

        this.title = title

        if (position != Vec2i(Int.MIN_VALUE))
            glfwSetWindowPos(handle.value, position.x, position.y)

        if (installCallbacks)
            installNativeCallbacks() // TODO default too?
    }

    init {
        if (handle.value == NULL) {
            glfw.terminate()
            throw RuntimeException("Failed to create the GLFW window")
        }
    }

    fun installNativeCallbacks() {
        glfwSetCharCallback(handle.value, nCharCB)
        glfwSetCursorPosCallback(handle.value, nCursorPosCB)
        glfwSetCursorEnterCallback(handle.value, nCursorEnterCB)
        glfwSetFramebufferSizeCallback(handle.value, nFramebufferSizeCB)
        glfwSetKeyCallback(handle.value, nKeyCB)
        glfwSetMouseButtonCallback(handle.value, nMouseButtonCB)
        glfwSetScrollCallback(handle.value, nScrollCB)
        glfwSetWindowCloseCallback(handle.value, nWindowCloseCB)
        glfwSetWindowContentScaleCallback(handle.value, nWindowContentScaleCB)
    }

    fun installDefaultCallbacks() {
        cursorPosCB = defaultCursorPosCallback
        cursorEnterCB = defaultCursorEnterCallback
        framebufferSizeCB = defaultFramebufferSizeCallback
        keyCB = defaultKeyCallback
        mouseButtonCB = defaultMouseButtonCallback
        scrollCB = defaultScrollCallback
        windowCloseCB = defaultWindowCloseCallback
        windowContentScaleCB = defaultWindowContentScaleCallback
    }

    lateinit var caps: Caps

    /**
     * Spasi: "the ideal option for modern applications is: compatibility context + forwardCompatible. A compatibility context
     * does not do extra validations that may cost performance and with `forwardCompatible == true` you don't risk using
     * legacy functionality by mistake.
     * LWJGL will not try to load deprecated functions, so calling them will crash but the context will actually expose them"
     */
    fun createCapabilities(profile: Caps.Profile = Caps.Profile.COMPATIBILITY, forwardCompatible: Boolean = true) {
        caps = Caps(profile, forwardCompatible)
    }

    var debugProc: Callback? = null

    fun init(show: Boolean = true) {
        makeContextCurrent()
        /*  This line is critical for LWJGL's interoperation with GLFW's OpenGL context,
            or any context that is managed externally.
            LWJGL detects the context that is current in the current thread, creates the GLCapabilities instance and
            makes the OpenGL bindings available for use. */
        GL.createCapabilities()
        show(show)
        if (windowHint.debug) {
            debugProc = GLUtil.setupDebugMessageCallback()
            // turn off notifications only
            GL43C.nglDebugMessageControl(GlDebugSource.DONT_CARE.i, GlDebugType.DONT_CARE.i, GlDebugSeverity.NOTIFICATION.i, 0, NULL, false)
        }
    }

    // --- [ glfwDestroyWindow ] ---

    /** Free the window callbacks and destroy the window and reset its handle back to NULL */
    fun destroy() {
        Callbacks.glfwFreeCallbacks(handle.value)
        debugProc?.free()
        glfwDestroyWindow(handle.value)
        handle = GlfwWindowHandle(NULL)
    }

    // --- [ glfwWindowShouldClose ] ---
    // --- [ glfwSetWindowShouldClose ] ---

    val isOpen: Boolean
        get() = !shouldClose

    var shouldClose: Boolean
        get() = glfwWindowShouldClose(handle.value)
        set(value) = glfwSetWindowShouldClose(handle.value, value)

    // --- [ glfwSetWindowTitle ] ---

    var title: String = ""
        set(value) {
            glfwSetWindowTitle(handle.value, value)
            field = value
        }

    // --- [ glfwSetWindowIcon ] ---

    fun setIcon(images: GLFWImage.Buffer?) = nglfwSetWindowIcon(handle.value, images?.rem ?: 0, images?.adr ?: NULL)

    // --- [ glfwGetWindowPos ] ---
    // --- [ glfwSetWindowPos ] ---

    var pos: Vec2i
        get() = stak {
            val p = it.mInt(2)
            nglfwGetWindowPos(handle.value, p.adr, (p + 1).adr)
            Vec2i(p[0], p[1]) // TODO glm
        }
        set(value) = glfwSetWindowPos(handle.value, value.x, value.y)

    // --- [ glfwGetWindowSize ] ---
    // --- [ glfwSetWindowSize ] ---

    var size: Vec2i
        get() = stak {
            val p = it.mInt(2)
            nglfwGetWindowSize(handle.value, p.adr, (p + 1).adr)
            Vec2i(p[0], p[1]) // TODO glm
        }
        set(value) = glfwSetWindowSize(handle.value, value.x, value.y)

    // --- [ glfwSetWindowSizeLimits ] ---

    fun setSizeLimit(width: IntRange, height: IntRange) = glfwSetWindowSizeLimits(handle.value, width.first, height.first, width.last, height.last)
    fun setSizeLimit(minWidth: Int, minHeight: Int, maxWidth: Int, maxHeight: Int) = glfwSetWindowSizeLimits(handle.value, minWidth, minHeight, maxWidth, maxHeight)

    // --- [ glfwSetWindowAspectRatio ] ---

    val aspect: Float
        get() = size.aspect
//        set(value) = glfwSetWindowAspectRatio(handle, (value * 1_000).i, 1_000)

    var aspectRatio: Vec2i
        get() = Vec2i(size.x, size.y)
        set(value) = glfwSetWindowAspectRatio(handle.value, value.x, value.y)

    // --- [ glfwGetFramebufferSize ] ---

    val framebufferSize: Vec2i
        get() = stak {
            val p = it.mInt(2)
            nglfwGetFramebufferSize(handle.value, p.adr, (p + 1).adr)
            Vec2i(p[0], p[1]) // TODO glm
        }

    // --- [ glfwGetWindowFrameSize ] ---

    val frameSize: Vec4i
        get() = stak {
            val p = it.mInt(4)
            nglfwGetWindowFrameSize(handle.value, p.adr, (p + 1).adr, (p + 2).adr, (p + 3).adr)
            Vec4i(p[0], p[1], p[2], p[3]) // TODO glm
        }

    // --- [ glfwGetWindowContentScale ] ---

    val contentScale: Vec2
        get() = stak {
            val p = it.mInt(2)
            nglfwGetWindowContentScale(handle.value, p.adr, (p + 1).adr)
            Vec2(p[0], p[1]) // TODO glm
        }

    // --- [ glfwGetWindowOpacity ] ---
    // --- [ glfwSetWindowOpacity ] ---

    var opacity: Float
        get() = glfwGetWindowOpacity(handle.value)
        set(value) = glfwSetWindowOpacity(handle.value, value)

    // --- [ glfwIconifyWindow ] ---
    // --- [ glfwRestoreWindow ] ---

    fun iconify() = glfwIconifyWindow(handle.value)
    fun restore() = glfwRestoreWindow(handle.value)

    // [JVM]
    fun iconify(iconify: Boolean) = if (iconify) iconify() else restore()

    // --- [ glfwMaximizeWindow ] ---

    fun maximize() = glfwMaximizeWindow(handle.value)

    // --- [ glfwShowWindow ] ---

    fun show(show: Boolean) = if (show) show() else hide()
    fun show() = glfwShowWindow(handle.value)

    // --- [ glfwHideWindow ] ---

    fun hide() = glfwHideWindow(handle.value)

    // --- [ glfwFocusWindow ] ---

    fun focus() = glfwFocusWindow(handle.value)

    // --- [ glfwRequestWindowAttention ] ---

    fun requestAttention() = glfwRequestWindowAttention(handle.value)

    // --- [ glfwGetWindowMonitor ] ---
    // --- [ glfwSetWindowMonitor ] ---

    var monitor: Monitor
        get() = Monitor(glfwGetWindowMonitor(handle.value), pos.x, pos.y, size.x, size.y)
        set(value) = glfwSetWindowMonitor(handle.value, value.handle, value.xPos, value.yPos, value.width, value.height, value.refreshRate)

    // --- [ glfwGetWindowAttrib ] ---
    // --- [ glfwSetWindowAttrib ] ---

    val isFocused: Boolean
        get() = glfwGetWindowAttrib(handle.value, GLFW_FOCUSED).bool
    val isIconified: Boolean
        get() = glfwGetWindowAttrib(handle.value, GLFW_ICONIFIED).bool
    val isMaximized: Boolean
        get() = glfwGetWindowAttrib(handle.value, GLFW_MAXIMIZED).bool
    val isHovered: Boolean
        get() = glfwGetWindowAttrib(handle.value, GLFW_HOVERED).bool
    val isVisible: Boolean
        get() = glfwGetWindowAttrib(handle.value, GLFW_VISIBLE).bool
    var resizable: Boolean
        get() = glfwGetWindowAttrib(handle.value, GLFW_RESIZABLE).bool
        set(value) = glfwSetWindowAttrib(handle.value, GLFW_RESIZABLE, value.i)
    var decorated: Boolean
        get() = glfwGetWindowAttrib(handle.value, GLFW_DECORATED).bool
        set(value) = glfwSetWindowAttrib(handle.value, GLFW_DECORATED, value.i)
    var autoIconified: Boolean
        get() = glfwGetWindowAttrib(handle.value, GLFW_AUTO_ICONIFY).bool
        set(value) = glfwSetWindowAttrib(handle.value, GLFW_AUTO_ICONIFY, value.i)
    var floating: Boolean
        get() = glfwGetWindowAttrib(handle.value, GLFW_FLOATING).bool
        set(value) = glfwSetWindowAttrib(handle.value, GLFW_FLOATING, value.i)
    val transparentFramebuffer: Boolean
        get() = glfwGetWindowAttrib(handle.value, GLFW_TRANSPARENT_FRAMEBUFFER).bool
    var focusOnShow: Boolean
        get() = glfwGetWindowAttrib(handle.value, GLFW_FOCUS_ON_SHOW).bool
        set(value) = glfwSetWindowAttrib(handle.value, GLFW_FOCUS_ON_SHOW, value.i)

    // --- [ glfwSetWindowUserPointer ] ---
    // --- [ glfwGetWindowUserPointer ] ---

    var userPointer: Ptr
        get() = glfwGetWindowUserPointer(handle.value)
        set(value) = glfwSetWindowUserPointer(handle.value, value)

    // ------------------- Callbacks -------------------

    val defaultKey = "0 - default"

    // --- [ glfwSetWindowPosCallback ] ---

    var windowPosCB: WindowPosCB?
        get() = windowPosCBs.getOrfirst(defaultKey)
        set(value) {
            if (value != null)
                windowPosCBs[defaultKey] = value
            else
                windowPosCBs -= defaultKey
        }

    val windowPosCBs = TreeMap<String, WindowPosCB>()
    val nWindowPosCB = GLFWWindowPosCallbackI { _, x, y -> windowPosCBs.values.forEach { it(Vec2i(x, y)) } }

    // --- [ glfwSetWindowSizeCallback ] ---

    var windowSizeCB: WindowSizeCB?
        get() = windowSizeCBs.getOrfirst(defaultKey)
        set(value) =
            if (value != null) windowSizeCBs[defaultKey] = value
            else windowSizeCBs -= defaultKey

    val windowSizeCBs = TreeMap<String, WindowSizeCB>()
    val nWindowSizeCB = GLFWWindowSizeCallbackI { _, x, y -> windowSizeCBs.values.forEach { it(Vec2i(x, y)) } }

    // --- [ glfwSetWindowCloseCallback ] ---

    var windowCloseCB: WindowCloseCB?
        get() = windowCloseCBs.getOrfirst(defaultKey)
        set(value) =
            if (value != null) windowCloseCBs[defaultKey] = value
            else windowCloseCBs -= defaultKey
    val windowCloseCBs = TreeMap<String, WindowCloseCB>()
    val nWindowCloseCB = GLFWWindowCloseCallbackI { windowCloseCBs.values.forEach { it() } }

    // --- [ glfwSetWindowRefreshCallback ] ---

    var windowRefreshCB: WindowRefreshCB?
        get() = windowRefreshCBs.getOrfirst(defaultKey)
        set(value) =
            if (value != null) windowRefreshCBs[defaultKey] = value
            else windowRefreshCBs -= defaultKey
    val windowRefreshCBs = TreeMap<String, WindowRefreshCB>()
    val nWindowRefreshCB = GLFWWindowRefreshCallbackI { windowRefreshCBs.values.forEach { it() } }

    // --- [ glfwSetWindowFocusCallback ] ---

    var windowFocusCB: WindowFocusCB?
        get() = windowFocusCBs.getOrfirst(defaultKey)
        set(value) =
            if (value != null) windowFocusCBs[defaultKey] = value
            else windowFocusCBs -= defaultKey
    val windowFocusCBs = TreeMap<String, WindowFocusCB>()
    val nWindowFocusCB = GLFWWindowFocusCallbackI { _, focused -> windowFocusCBs.values.forEach { it(focused) } }

    // --- [ glfwSetWindowIconifyCallback ] ---

    var windowIconifyCB: WindowIconifyCB?
        get() = windowIconifyCBs.getOrfirst(defaultKey)
        set(value) =
            if (value != null) windowIconifyCBs[defaultKey] = value
            else windowIconifyCBs -= defaultKey
    val windowIconifyCBs = TreeMap<String, WindowIconifyCB>()
    val nWindowIconifyCB = GLFWWindowIconifyCallbackI { _, iconify -> windowIconifyCBs.values.forEach { it(iconify) } }

    // --- [ glfwSetWindowMaximizeCallback ] ---

    var windowMaximizeCB: WindowMaximizeCB?
        get() = windowMaximizeCBs.getOrfirst(defaultKey)
        set(value) =
            if (value != null) windowMaximizeCBs[defaultKey] = value
            else windowMaximizeCBs -= defaultKey
    val windowMaximizeCBs = TreeMap<String, WindowMaximizeCB>()
    val nWindowMaximizeCB = GLFWWindowMaximizeCallbackI { _, maximized -> windowMaximizeCBs.values.forEach { it(maximized) } }

    // --- [ glfwSetFramebufferSizeCallback ] ---

    var framebufferSizeCB: FramebufferSizeCB?
        get() = framebufferSizeCBs.getOrfirst(defaultKey)
        set(value) =
            if (value != null) framebufferSizeCBs[defaultKey] = value
            else framebufferSizeCBs -= defaultKey
    val framebufferSizeCBs = TreeMap<String, FramebufferSizeCB>()
    val nFramebufferSizeCB = GLFWFramebufferSizeCallbackI { _, width, height -> framebufferSizeCBs.values.forEach { it(Vec2i(width, height)) } }

    // --- [ glfwSetWindowContentScaleCallback ] ---

    var windowContentScaleCB: WindowContentScaleCB?
        get() = windowContentScaleCBs.getOrfirst(defaultKey)
        set(value) =
            if (value != null) windowContentScaleCBs[defaultKey] = value
            else windowContentScaleCBs -= defaultKey
    val windowContentScaleCBs = TreeMap<String, WindowContentScaleCB>()
    val nWindowContentScaleCB = GLFWWindowContentScaleCallbackI { _, xScale, yScale -> windowContentScaleCBs.values.forEach { it(Vec2(xScale, yScale)) } }

    // --- [ glfwGetInputMode ] ---
    // --- [ glfwSetInputMode ] ---

    var cursorMode: CursorMode
        get() = CursorMode of glfwGetInputMode(handle.value, GLFW_CURSOR)
        set(value) = glfwSetInputMode(handle.value, GLFW_CURSOR, value.i)

    enum class CursorMode(val i: Int) {
        normal(GLFW_CURSOR_NORMAL), hidden(GLFW_CURSOR_HIDDEN), disabled(GLFW_CURSOR_DISABLED);

        companion object {
            infix fun of(i: Int) = values().first { it.i == i }
        }
    }

    var stickyKeys: Boolean
        get() = glfwGetInputMode(handle.value, GLFW_STICKY_KEYS).bool
        set(value) = glfwSetInputMode(handle.value, GLFW_STICKY_KEYS, value.i)

    var stickyMouseButtons: Boolean
        get() = glfwGetInputMode(handle.value, GLFW_STICKY_MOUSE_BUTTONS).bool
        set(value) = glfwSetInputMode(handle.value, GLFW_STICKY_MOUSE_BUTTONS, value.i)

    var lockKeyMods: Boolean
        get() = glfwGetInputMode(handle.value, GLFW_LOCK_KEY_MODS).bool
        set(value) = glfwSetInputMode(handle.value, GLFW_LOCK_KEY_MODS, value.i)


    // --- [ glfwGetKey ] ---

    infix fun isPressed(key: Key): Boolean = glfwGetKey(handle.value, key.i) == GLFW_PRESS
    infix fun isReleased(key: Key): Boolean = glfwGetKey(handle.value, key.i) == GLFW_RELEASE

    // --- [ glfwGetMouseButton ] ---

    infix fun isPressed(button: MouseButton): Boolean = glfwGetMouseButton(handle.value, button.i) == GLFW_PRESS
    infix fun isRelease(button: MouseButton): Boolean = glfwGetMouseButton(handle.value, button.i) == GLFW_RELEASE

    // --- [ glfwGetCursorPos ] ---
    // --- [ glfwSetCursorPos ] ---
    var cursorPos: Vec2d
        get() = stak {
            val p = it.mDouble(2)
            nglfwGetCursorPos(handle.value, p.adr, (p + 1).adr)
            Vec2d(p[0], p[1]) // TODO glm
        }
        set(value) = glfwSetCursorPos(handle.value, value.x, value.y)

    // --- [ glfwSetKeyCallback ] ---

    var keyCB: KeyCB?
        get() = keyCBs.getOrfirst(defaultKey)
        set(value) =
            if (value != null) keyCBs[defaultKey] = value
            else keyCBs -= defaultKey
    val keyCBs = TreeMap<String, KeyCB>()
    val nKeyCB = GLFWKeyCallbackI { _, key, scanCode, action, mods -> keyCBs.values.forEach { it(key, scanCode, action, mods) } }

    // --- [ glfwSetCharCallback ] ---

    var charCB: CharCB?
        get() = charCBs.getOrfirst(defaultKey)
        set(value) =
            if (value != null) charCBs[defaultKey] = value
            else charCBs -= defaultKey

    val charCBs = TreeMap<String, CharCB>()
    val nCharCB = GLFWCharCallbackI { _, codePoint -> charCBs.values.forEach { it(codePoint) } }

    // --- [ glfwSetCharModsCallback ] ---

    var charModsCB: CharModsCB?
        get() = charModsCBs.getOrfirst(defaultKey)
        set(value) =
            if (value != null) charModsCBs[defaultKey] = value
            else charModsCBs -= defaultKey

    val charModsCBs = TreeMap<String, CharModsCB>()
    val nCharModsCB = GLFWCharModsCallbackI { _, codePoint, mods -> charModsCBs.values.forEach { it(codePoint, mods) } }

    // --- [ glfwSetMouseButtonCallback ] ---

    var mouseButtonCB: MouseButtonCB?
        get() = mouseButtonCBs.getOrfirst(defaultKey)
        set(value) =
            if (value != null) mouseButtonCBs[defaultKey] = value
            else mouseButtonCBs -= defaultKey

    val mouseButtonCBs = TreeMap<String, MouseButtonCB>()
    val nMouseButtonCB = GLFWMouseButtonCallbackI { _, button, action, mods -> mouseButtonCBs.values.forEach { it(button, action, mods) } }

    // --- [ glfwSetCursorPosCallback ] ---

    var cursorPosCB: CursorPosCB?
        get() = cursorPosCBs.getOrfirst(defaultKey)
        set(value) =
            if (value != null) cursorPosCBs[defaultKey] = value
            else cursorPosCBs -= defaultKey

    val cursorPosCBs = TreeMap<String, CursorPosCB>()
    val nCursorPosCB = GLFWCursorPosCallbackI { _, xPos, yPos -> cursorPosCBs.values.forEach { it(Vec2(xPos, yPos)) } }

    // --- [ glfwSetCursorEnterCallback ] ---

    var cursorEnterCB: CursorEnterCB?
        get() = cursorEnterCBs.getOrfirst(defaultKey)
        set(value) =
            if (value != null) cursorEnterCBs[defaultKey] = value
            else cursorEnterCBs -= defaultKey

    val cursorEnterCBs = TreeMap<String, CursorEnterCB>()
    val nCursorEnterCB = GLFWCursorEnterCallbackI { _, entered -> cursorEnterCBs.values.forEach { it(entered) } }

    // --- [ glfwSetScrollCallback ] ---

    var scrollCB: ScrollCB?
        get() = scrollCBs.getOrfirst(defaultKey)
        set(value) =
            if (value != null) scrollCBs[defaultKey] = value
            else scrollCBs -= defaultKey

    val scrollCBs = TreeMap<String, ScrollCB>()
    val nScrollCB = GLFWScrollCallbackI { _, xOffset, yOffset -> scrollCBs.values.forEach { it(Vec2d(xOffset, yOffset)) } }

    // --- [ glfwSetDropCallback ] ---

    var dropCB: DropCB?
        get() = dropCBs.getOrfirst(defaultKey)
        set(value) =
            if (value != null) dropCBs[defaultKey] = value
            else dropCBs -= defaultKey

    val dropCBs = TreeMap<String, DropCB>()
    val nDropCB = GLFWDropCallbackI { _, xOffset, yOffset -> scrollCBs.values.forEach { it(Vec2d(xOffset, yOffset)) } }


    var clipboardString: String?
        // --- [ glfwGetClipboardString ] ---
        get() = glfwGetClipboardString(handle.value)
        // --- [ glfwSetClipboardString ] ---
        set(value) {
            value?.let { glfwSetClipboardString(handle.value, it) }
        }

    // --- [ glfwMakeContextCurrent ] ---

    fun makeContextCurrent() = glfwMakeContextCurrent(handle.value)
    fun makeContextCurrent(current: Boolean) = glfwMakeContextCurrent(if (current) handle.value else NULL)

    inline fun inContext(block: () -> Unit) {
        glfwMakeContextCurrent(handle.value)
        GL.setCapabilities(caps.gl)
        block()
        glfwMakeContextCurrent(NULL)
    }

    /** for Java */
    fun inContext(runnable: Runnable) {
        glfwMakeContextCurrent(handle.value)
        GL.setCapabilities(caps.gl)
        runnable.run()
        glfwMakeContextCurrent(NULL)
    }

    // --- [ glfwSwapBuffers ] ---

    fun swapBuffers() = glfwSwapBuffers(handle.value)

    // [JVM] alias
    fun present() = swapBuffers()


    val defaultKeyCallback: KeyCB = { key, scanCode, action, mods -> onKey(Key of key, scanCode, action, mods) }
    val defaultMouseButtonCallback: MouseButtonCB = { button, action, mods -> onMouse(MouseButton of button, action, mods) }
    val defaultCursorPosCallback: CursorPosCB = { pos -> onMouseMoved(pos) }
    val defaultCursorEnterCallback: CursorEnterCB = { entered -> if (entered) onMouseEntered() else onMouseExited() }
    val defaultScrollCallback: ScrollCB = { scroll -> onMouseScrolled(scroll.y.f) }
    val defaultWindowCloseCallback: WindowCloseCB = ::onWindowClosed
    val defaultWindowContentScaleCallback: WindowContentScaleCB = { newScale -> onWindowContentScaled(newScale) }
    val defaultFramebufferSizeCallback: FramebufferSizeCB = { size -> onWindowResized(size) }

    //
    // Event handlers are called by the GLFW callback mechanism and should not be called directly
    //

    open fun onWindowResized(newSize: Vec2i) {}
    open fun onWindowClosed() {}

    // Keyboard handling
    open fun onKey(key: Key, scanCode: Int, action: Int, mods: Int) {
        when (action) {
            GLFW_PRESS -> onKeyPressed(key, mods)
            GLFW_RELEASE -> onKeyReleased(key, mods)
        }
    }

    open fun onKeyPressed(key: Key, mods: Int) {}
    open fun onKeyReleased(key: Key, mods: Int) {}

    // Mouse handling
    open fun onMouse(button: MouseButton, action: Int, mods: Int) {
        when (action) {
            GLFW_PRESS -> onMousePressed(button, mods)
            GLFW_RELEASE -> onMouseReleased(button, mods)
        }
    }

    open fun onMousePressed(button: MouseButton, mods: Int) {}
    open fun onMouseReleased(button: MouseButton, mods: Int) {}
    open fun onMouseMoved(newPos: Vec2) {}
    open fun onMouseEntered() {}
    open fun onMouseExited() {}
    open fun onMouseScrolled(delta: Float) {}

    open fun onWindowContentScaled(newScale: Vec2) {}

    var cursor: GlfwCursor
        get() = error("this is a setter-only property")
        set(value) = glfwSetCursor(handle.value, value.handle)


    var autoSwap = true

    inline fun loop(block: (MemoryStack) -> Unit) = loop({ isOpen }, block)

    /**
     *  The `stack` passed to `block` will be automatically a stack frame in place
     *  (i.e. it has been pushed exactly once, without popping).
     *  So you can do any allocation on that frame without pushing/popping further
     *  It's the user choice to pass it down the stacktrace to avoid TLS
     */
    inline fun loop(condition: () -> Boolean, block: (MemoryStack) -> Unit) {
        while (condition()) {
            glfwPollEvents()
            stak {
                block(it)
                if (autoSwap)
                    glfwSwapBuffers(handle.value)
            }
        }
    }

    fun loop(block: Consumer<MemoryStack>) = loop(BooleanSupplier { isOpen }, block)

    /**
     *  The `stack` passed to `block` will be automatically a stack frame in place
     *  (i.e. it has been pushed exactly once, without popping).
     *  So you can do any allocation on that frame without pushing/popping further
     *  It's the user choice to pass it down the stacktrace to avoid TLS
     */
    fun loop(condition: BooleanSupplier, block: Consumer<MemoryStack>) {
        while (condition.asBoolean) {
            glfwPollEvents()
            stak {
                block.accept(it)
                if (autoSwap)
                    glfwSwapBuffers(handle.value)
            }
        }
    }

//    infix fun createSurface(instance: VkInstance) = glfw.createWindowSurface(handle, instance)


    val hwnd: HWND
        get() = HWND(GLFWNativeWin32.glfwGetWin32Window(handle.value))

    val isCurrent: Boolean
        get() = glfw.currentContext == handle

    companion object {
        infix fun fromWin32Window(hwnd: HWND): GlfwWindow = GlfwWindow(glfw.attachWin32Window(hwnd))

        @JvmStatic
        fun from(handle: Long) = GlfwWindow(GlfwWindowHandle(handle))
    }
}