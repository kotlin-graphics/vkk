package uno.glfw

import glm_.i
import org.lwjgl.glfw.GLFW.*

object windowHint {

    // Window related hints


    var resizable = true
        set(value) {
            glfwWindowHint(GLFW_RESIZABLE, value.i)
            field = value
        }

    var visible = true
        set(value) {
            glfwWindowHint(GLFW_VISIBLE, value.i)
            field = value
        }

    var decorated = true
        set(value) {
            glfwWindowHint(GLFW_DECORATED, value.i)
            field = value
        }

    var focused = true
        set(value) {
            glfwWindowHint(GLFW_FOCUSED, value.i)
            field = value
        }

    var autoIconify = true
        set(value) {
            glfwWindowHint(GLFW_AUTO_ICONIFY, value.i)
            field = value
        }

    var floating = false
        set(value) {
            glfwWindowHint(GLFW_FLOATING, value.i)
            field = value
        }

    var maximized = false
        set(value) {
            glfwWindowHint(GLFW_MAXIMIZED, value.i)
            field = value
        }

    var centerCursor = true
        set(value) {
            glfwWindowHint(GLFW_CENTER_CURSOR, value.i)
            field = value
        }

    var transparentFramebuffer = false
        set(value) {
            glfwWindowHint(GLFW_TRANSPARENT_FRAMEBUFFER, value.i)
            field = value
        }

    var focusOnShow = true
        set(value) {
            glfwWindowHint(GLFW_FOCUS_ON_SHOW, value.i)
            field = value
        }

    var scaleToMonitor = false
        set(value) {
            glfwWindowHint(GLFW_SCALE_TO_MONITOR, value.i)
            field = value
        }


    // Framebuffer related hints


    var redBits = 8
        set(value) {
            glfwWindowHint(GLFW_RED_BITS, value)
            field = value
        }

    var greenBits = 8
        set(value) {
            glfwWindowHint(GLFW_GREEN_BITS, value)
            field = value
        }

    var blueBits = 8
        set(value) {
            glfwWindowHint(GLFW_BLUE_BITS, value)
            field = value
        }

    var alphaBits = 8
        set(value) {
            glfwWindowHint(GLFW_ALPHA_BITS, value)
            field = value
        }

    var depthBits = 24
        set(value) {
            glfwWindowHint(GLFW_DEPTH_BITS, value)
            field = value
        }

    var stencilBits = 8
        set(value) {
            glfwWindowHint(GLFW_STENCIL_BITS, value)
            field = value
        }

    var accumRedBits = 0
        set(value) {
            glfwWindowHint(GLFW_ACCUM_RED_BITS, value)
            field = value
        }

    var accumGreenBits = 0
        set(value) {
            glfwWindowHint(GLFW_ACCUM_GREEN_BITS, value)
            field = value
        }

    var accumBlueBits = 0
        set(value) {
            glfwWindowHint(GLFW_ACCUM_BLUE_BITS, value)
            field = value
        }

    var accumAlphaBits = 0
        set(value) {
            glfwWindowHint(GLFW_ACCUM_ALPHA_BITS, value)
            field = value
        }

    var auxBuffers = 0
        set(value) {
            glfwWindowHint(GLFW_AUX_BUFFERS, value)
            field = value
        }

    var stereo = false
        set(value) {
            glfwWindowHint(GLFW_STEREO, value.i)
            field = value
        }

    var samples = 0
        set(value) {
            glfwWindowHint(GLFW_SAMPLES, value)
            field = value
        }

    var srgb = false
        set(value) {
            glfwWindowHint(GLFW_SRGB_CAPABLE, value.i)
            field = value
        }

    var doubleBuffer = true
        set(value) {
            glfwWindowHint(GLFW_DOUBLEBUFFER, value.i)
            field = value
        }


    // Monitor related hints


    var refreshRate = GLFW_DONT_CARE
        set(value) {
            glfwWindowHint(GLFW_REFRESH_RATE, value)
            field = value
        }


    // Context related hints


    enum class Api { gl, glEs, None }

    var api = Api.gl
        set(value) {
            glfwWindowHint(GLFW_CLIENT_API, when (value) {
                Api.gl -> GLFW_OPENGL_API
                Api.glEs -> GLFW_OPENGL_ES_API
                Api.None -> GLFW_NO_API
            })
            field = value
        }

    // Context related hints
    val context = Context

    object Context {

        enum class CreationApi { native, egl }

        var creationApi = CreationApi.native
            set(value) {
                glfwWindowHint(GLFW_CONTEXT_CREATION_API, when (value) {
                    CreationApi.native -> GLFW_NATIVE_CONTEXT_API
                    CreationApi.egl -> GLFW_EGL_CONTEXT_API
                })
                field = value
            }

        var version = "1.0"
            set(value) {
                glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, java.lang.Integer.parseInt(value[0].toString()))
                glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, java.lang.Integer.parseInt(value[2].toString()))
                field = value
            }

        var major = 1
            set(value) {
                glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, value)
                field = value
            }

        var minor = 0
            set(value) {
                glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, value)
                field = value
            }

        enum class Robustness { noResetNotification, loseContextOnReset, none }

        var robustness = Robustness.none
            set(value) {
                glfwWindowHint(GLFW_CONTEXT_ROBUSTNESS, when (value) {
                    Robustness.none -> GLFW_NO_ROBUSTNESS
                    Robustness.noResetNotification -> GLFW_NO_RESET_NOTIFICATION
                    Robustness.loseContextOnReset -> GLFW_LOSE_CONTEXT_ON_RESET
                })
                field = value
            }

        enum class ReleaseBehaviour { any, flush, none }

        var releaseBehaviour = ReleaseBehaviour.any
            set(value) {
                glfwWindowHint(GLFW_CONTEXT_RELEASE_BEHAVIOR, when (value) {
                    ReleaseBehaviour.any -> GLFW_ANY_RELEASE_BEHAVIOR
                    ReleaseBehaviour.flush -> GLFW_RELEASE_BEHAVIOR_FLUSH
                    ReleaseBehaviour.none -> GLFW_RELEASE_BEHAVIOR_NONE
                })
                field = value
            }
    }

    // macOS specific window hints
    val cocoa = Cocoa

    object Cocoa {

        var retinaFramebuffer = true
            set(value) {
                glfwWindowHint(GLFW_COCOA_RETINA_FRAMEBUFFER, value.i)
                field = value
            }

        var frameName = ""
            set(value) {
                glfwWindowHintString(GLFW_COCOA_FRAME_NAME, value)
                field = value
            }

        var graphicsSwitching = false
            set(value) {
                glfwWindowHint(GLFW_COCOA_GRAPHICS_SWITCHING, value.i)
                field = value
            }
    }

    // X11 specific window hints
    val x11 = X11

    object X11 {

        var className = ""
            set(value) {
                glfwWindowHintString(GLFW_X11_CLASS_NAME, value)
                field = value
            }

        var instanceName = ""
            set(value) {
                glfwWindowHintString(GLFW_X11_INSTANCE_NAME, value)
                field = value
            }
    }

    var forwardComp = false
        set(value) {
            glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, value.i)
            field = value
        }

    var debug = false
        set(value) {
            glfwWindowHint(GLFW_OPENGL_DEBUG_CONTEXT, value.i)
            field = value
        }

    enum class Profile { any, compat, core }

    var profile = Profile.any
        set(value) {
            glfwWindowHint(GLFW_OPENGL_PROFILE, when (value) {
                Profile.core -> GLFW_OPENGL_CORE_PROFILE
                Profile.compat -> GLFW_OPENGL_COMPAT_PROFILE
                Profile.any -> GLFW_OPENGL_ANY_PROFILE
            })
            field = value
        }
}
