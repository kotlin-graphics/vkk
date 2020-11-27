package uno.glfw

import glm_.vec2.Vec2i
import kool.Stack
import kool.adr
import org.lwjgl.glfw.GLFWVidMode


inline val GLFWVidMode.width: Int
    get() = GLFWVidMode.nwidth(adr)
inline val GLFWVidMode.height: Int
    get() = GLFWVidMode.nheight(adr)
inline val GLFWVidMode.size: Vec2i
    get() = Vec2i(width, height)
inline val GLFWVidMode.redBits: Int
    get() = GLFWVidMode.nredBits(adr)
inline val GLFWVidMode.greenBits: Int
    get() = GLFWVidMode.ngreenBits(adr)
inline val GLFWVidMode.blueBits: Int
    get() = GLFWVidMode.nblueBits(adr)
inline val GLFWVidMode.refreshRate: Int
    get() = GLFWVidMode.nrefreshRate(adr)

inline class HWND(val L: Long)

typealias Seconds = Double
typealias Hz = Long
typealias stak = Stack