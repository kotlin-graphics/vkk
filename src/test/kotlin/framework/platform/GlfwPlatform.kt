package framework.platform

import glm_.i
import glm_.vec2.Vec2
import glm_.vec2.Vec2i
import kool.Ptr
import kool.isInvalid
import org.lwjgl.glfw.GLFW.*
import org.lwjgl.glfw.GLFWVulkan.glfwCreateWindowSurface
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.vulkan.VK10.VK_SUCCESS
import org.lwjgl.vulkan.VkInstance
import thirdParty.spdlog.Sink
import vkk.entities.VkSurfaceKHR
import vkk.stak

var platform: Platform? = null

class GlfwPlatform : Platform() {

//    public:

//    override fun destroy() = super.destroy()

    override fun initialize(app: Application): Boolean {

        val result = super.initialize(app)

        val options = activeApp!!.options

        if (!glfwInit())
            return false

        glfwSetErrorCallback { error, description -> logger.error { "GLFW Error (code $error}): ${MemoryUtil.memUTF8(description)}" } }

        glfwWindowHint(GLFW_CLIENT_API, GLFW_NO_API)

        if (options.hide)
            glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE)

        val size = Vec2i(options.width ?: 1280, options.height ?: 720)

        window = glfwCreateWindow(size.x, size.y, activeApp!!.name, NULL, NULL)

        if (window == NULL)
            return false

//        glfwSetWindowUserPointer(window, this)

        glfwSetWindowCloseCallback(window) { window -> glfwSetWindowShouldClose(window, true) }
        glfwSetWindowSizeCallback(window) { window, width, height -> platform?.getApp()!!.resize(size) }
        glfwSetWindowFocusCallback(window) { window, focused -> platform?.getApp()!!.focus = focused }
        glfwSetKeyCallback(window) { window, key, scancode, action, mods -> platform?.getApp()!!.inputEvent(InputEvent.KeyInputEvent(key, action)) }
        glfwSetCursorPosCallback(window) { window, xpos, ypos -> platform?.getApp()!!.inputEvent(InputEvent.MouseButtonInputEvent(MouseButton.Unknown, MouseAction.Move, Vec2(xpos, ypos))) }
        glfwSetMouseButtonCallback(window) { window, button, action, mods ->

            val mouseAction = when (action) {
                GLFW_PRESS -> MouseAction.Down
                GLFW_RELEASE -> MouseAction.Up
                else -> MouseAction.Unknown
            }

            platform?.let {
                val pos = stak {
                    val xPos = it.mallocDouble(1)
                    val yPos = it.mallocDouble(1)
                    glfwGetCursorPos(window, xPos, yPos)
                    Vec2(xPos[0], yPos[0])
                }

                val button = when {
                    button < GLFW_MOUSE_BUTTON_6 -> MouseButton.values()[button]
                    else -> MouseButton.Unknown
                }
                it.getApp().inputEvent(InputEvent.MouseButtonInputEvent(button, mouseAction, pos))
            }
        }

        glfwSetInputMode(window, GLFW_STICKY_KEYS, 1)
        glfwSetInputMode(window, GLFW_STICKY_MOUSE_BUTTONS, 1)

        return result && super.prepare()
    }

    override fun createSurface(instance: VkInstance): VkSurfaceKHR = when {
        instance.isInvalid || window == NULL -> VkSurfaceKHR.NULL
        else -> stak {
            val pSurface = it.mallocLong(1)
            val errCode = glfwCreateWindowSurface(instance, window, null, pSurface)
            if (errCode != VK_SUCCESS)
                VkSurfaceKHR.NULL
            else VkSurfaceKHR(pSurface[0])
        }
    }

    override fun mainLoop() {
        while (!glfwWindowShouldClose(window)) {
            run()
            glfwPollEvents()
        }
    }

    override fun terminate(code: ExitCode) {
        glfwTerminate()
        super.terminate(code)
    }

    override fun close() = glfwSetWindowShouldClose(window, true)

    /** It calculates the dpi factor using the density from GLFW physical size
     *  https://www.glfw.org/docs/latest/monitor_guide.html#monitor_size     GLFW docs for dpi */
    override val dpiFactor: Float
        get() {
            val primaryMonitor = glfwGetPrimaryMonitor()
            val vidmode = glfwGetVideoMode(primaryMonitor)!!

            val sizeMm = stak {
                val width = it.mallocInt(1)
                val height = it.mallocInt(1)
                glfwGetMonitorPhysicalSize(primaryMonitor, width, height)
                Vec2i(width, height)
            }

            // As suggested by the GLFW monitor guide
            val inchToMm = 25f
            val winBaseDensity = 96f

            val dpi = (vidmode.width() / (sizeMm.x / inchToMm)).i
            val dpiFactor = dpi / winBaseDensity
            return dpiFactor
        }

    //    private :
    private var window: Ptr = NULL

    override val platformSinks: Array<Sink>
        get() = arrayOf(Sink.stdout_color_sink_mt)
}