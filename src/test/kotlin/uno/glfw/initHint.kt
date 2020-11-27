package uno.glfw

import glm_.i
import org.lwjgl.glfw.GLFW.*

object initHint {

    var joystickHatButtons = true
        set(value) {
            glfwInitHint(GLFW_JOYSTICK_HAT_BUTTONS, value.i)
            field = value
        }

    var cocoaChdirResources = true
        set(value) {
            glfwInitHint(GLFW_COCOA_CHDIR_RESOURCES, value.i)
            field = value
        }

    var cocoaMenubar = true
        set(value) {
            glfwInitHint(GLFW_COCOA_MENUBAR, value.i)
            field = value
        }
}