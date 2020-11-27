package uno.glfw

import glm_.vec2.Vec2
import glm_.vec2.Vec2d
import glm_.vec2.Vec2i
import glm_.vec4.Vec4i
import kool.*
import org.lwjgl.glfw.GLFW.*
import org.lwjgl.glfw.GLFWGamepadState
import org.lwjgl.glfw.GLFWJoystickCallback
import org.lwjgl.glfw.GLFWJoystickCallbackI
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.system.MemoryUtil.memUTF8
import java.nio.ByteBuffer
import java.nio.FloatBuffer


typealias GLFWErrorCallbackT = (glfw.Error, String) -> Unit

class GlfwMonitor(val handle: Long) {

    // --- [ glfwGetMonitorPos ] ---
    val pos: Vec2i
        get() = stak {
            val pos = it.mInt(2)
            nglfwGetMonitorPos(handle, pos.adr, (pos + 1).adr)
            Vec2i(pos[0], pos[1]) // TODO glm
        }

    // --- [ glfwGetMonitorWorkarea ] ---
    val workArea: Vec4i
        get() = stak {
            val area = it.mInt(4)
            nglfwGetMonitorWorkarea(handle, area.adr, (area + 1).adr, (area + 2).adr, (area + 3).adr)
            Vec4i(area[0], area[1], area[2], area[3]) // TODO glm
        }

    // --- [ glfwGetMonitorPhysicalSize ] ---
    val physicalSize: Vec2i
        get() = stak {
            val size = it.mInt(2)
            nglfwGetMonitorPhysicalSize(handle, size.adr, (size + 1).adr)
            Vec2i(size[0], size[1]) // TODO glm
        }

    // --- [ glfwGetMonitorContentScale ] ---
    val contentScale: Vec2
        get() = stak {
            val scale = it.mFloat(2)
            nglfwGetMonitorPhysicalSize(handle, scale.adr, (scale + 1).adr)
            Vec2(scale[0], scale[1]) // TODO glm
        }

    // --- [ glfwGetMonitorName ] ---
    val name: String?
        get() = stak {
            val pName = nglfwGetMonitorName(handle)
            when (pName) {
                NULL -> null
                else -> memUTF8(pName)
            }
        }

    // --- [ glfwSetMonitorUserPointer ] ---
    var userPointer: Ptr
        get() = glfwGetMonitorUserPointer(handle)
        set(value) = glfwSetMonitorUserPointer(handle, value)


    // --- [ glfwGetVideoModes ] ---
    val videoModes: Array<GlfwVidMode>
        get() = stak { s ->
            val pCount = s.mInt()
            val pModes = nglfwGetVideoModes(handle, pCount.adr)
            val count = pCount[0]
            Array(count) {
                GlfwVidMode(IntPtr(pModes + it * Int.BYTES * 6))
            }
        }

    // --- [ glfwGetVideoMode ] ---
    val videoMode: GlfwVidMode
        get() = stak {
            GlfwVidMode(IntPtr(nglfwGetVideoMode(handle)))
        }

    // --- [ glfwSetGamma ] ---
    fun setGamma(gamma: Float) = glfwSetGamma(handle, gamma)

    // --- [ glfwGetGammaRamp ] ---
    var gammaRamp: GlfwGammaRamp
        get() = stak {
            val pRamp = IntPtr(nglfwGetGammaRamp(handle))
            GlfwGammaRamp(pRamp[0], pRamp[1], pRamp[2], pRamp[3])
        }
        set(value) = stak {
            val pRamp = it.mInt(4)
            pRamp[0] = value.red
            pRamp[1] = value.green
            pRamp[2] = value.blue
            pRamp[3] = value.size
            nglfwSetGammaRamp(handle, pRamp.adr)
        }
}

class GlfwVidMode(val size: Vec2i, val redBits: Int, val greenBits: Int, val blueBits: Int, val refreshRate: Int) {
    constructor(intPtr: IntPtr) : this(Vec2i(intPtr[0], intPtr[1]), intPtr[2], intPtr[3], intPtr[4], intPtr[5])
}

class GlfwGammaRamp(val red: Int, val green: Int, val blue: Int, val size: Int)

data class Monitor(val handle: Long, val xPos: Int, val yPos: Int, val width: Int, val height: Int, val refreshRate: Int = GLFW_DONT_CARE)

inline class GlfwWindowHandle(val value: Long)

inline class GlfwCursor(val handle: Long) {

    // --- [ glfwDestroyCursor ] ---
    fun destroy() = glfwDestroyCursor(handle)
}

inline class Joystick(val id: Int) {

    // --- [ glfwJoystickPresent ] ---

    val isPresent: Boolean
        get() = glfwJoystickPresent(id)

    // --- [ glfwGetJoystickAxes ] ---

    val axes: FloatBuffer?
        get() = glfwGetJoystickAxes(id)

    // --- [ glfwGetJoystickButtons ] ---

    val buttons: ByteBuffer?
        get() = glfwGetJoystickButtons(id)

    // --- [ glfwGetJoystickHats ] ---
    val hats: ByteBuffer?
        get() = glfwGetJoystickHats(id)

    // --- [ glfwGetJoystickName ] ---
    val name: String?
        get() = glfwGetJoystickName(id)

    // --- [ glfwGetJoystickGUID ] ---
    val guid: String?
        get() = glfwGetJoystickGUID(id)

    // --- [ glfwSetJoystickUserPointer ] ---
    // --- [ glfwGetJoystickUserPointer ] ---
    var userPointer: Ptr
        get() = glfwGetJoystickUserPointer(id)
        set(value) = glfwSetJoystickUserPointer(id, value)

    // --- [ glfwJoystickIsGamepad ] ---
    val isGamepad: Boolean
        get() = glfwJoystickIsGamepad(id)

    // --- [ glfwSetJoystickCallback ] ---
    fun setJoystickCallback(cbfun: GLFWJoystickCallbackI?): GLFWJoystickCallback? = glfwSetJoystickCallback(cbfun)

    // --- [ glfwGetGamepadName ] ---
    val gamepadName: String?
        get() = glfwGetGamepadName(id)

    // --- [ glfwGetGamepadState ] ---
    fun getGamepadState(state: GLFWGamepadState = GLFWGamepadState.create()): Boolean = glfwGetGamepadState(id, state)

    companion object {
        val _1: Joystick get() = Joystick(GLFW_JOYSTICK_1)
        val _2: Joystick get() = Joystick(GLFW_JOYSTICK_2)
        val _3: Joystick get() = Joystick(GLFW_JOYSTICK_3)
    }
}

typealias WindowPosCB = (pos: Vec2i) -> Unit
typealias WindowSizeCB = (size: Vec2i) -> Unit
typealias WindowCloseCB = () -> Unit
typealias WindowRefreshCB = () -> Unit
typealias WindowFocusCB = (focused: Boolean) -> Unit
typealias WindowIconifyCB = (iconified: Boolean) -> Unit
typealias WindowMaximizeCB = (maximized: Boolean) -> Unit
typealias FramebufferSizeCB = (size: Vec2i) -> Unit
typealias WindowContentScaleCB = (Vec2) -> Unit
typealias CharCB = (codePoint: Int) -> Unit
typealias CharModsCB = (codePoint: Int, mods: Int) -> Unit
typealias MouseButtonCB = (button: Int, action: Int, mods: Int) -> Unit
typealias CursorPosCB = (pos: Vec2) -> Unit
typealias CursorEnterCB = (entered: Boolean) -> Unit
typealias ScrollCB = (scroll: Vec2d) -> Unit
typealias DropCB = (names: Array<String>) -> Unit
typealias KeyCB = (key: Int, scanCode: Int, action: Int, mods: Int) -> Unit

//typealias JoystickCB = (connected: Boolean) -> Unit

enum class VSync {
    AdaptiveHalfRate, Adaptive, OFF, ON;

    val i = ordinal - 2
}