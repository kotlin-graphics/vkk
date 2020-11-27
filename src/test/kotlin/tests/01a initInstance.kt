package tests

import io.kotest.core.spec.style.StringSpec
import kool.Ptr
import kool.adr
import main.Instance01
import main.isNotCI
import org.lwjgl.system.JNI
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.Pointer
import org.lwjgl.vulkan.VkInstanceCreateInfo
import uno.glfw.glfw
import uno.vk.requiredInstanceExtensions
import uno.vk.vulkanSupported
import vkk.VK_CHECK_RESULT
import vkk.VkStack
import vkk.extensions.VkDebugReport
import vkk.identifiers.Instance
import vkk.identifiers.VK
import vkk.vk10.structs.DebugReportCallbackCreateInfo
import vkk.vk10.structs.InstanceCreateInfo
import kotlin.system.exitProcess

class `01a initInstance` : StringSpec() {

    init {
        if (isNotCI)
            "01a initInstance" {

                glfw.errorCallback = glfw.defaultErrorCallback
                glfw.init()

                //                glfw.windowHint {
                //                    api = windowHint.Api.None
                //                }
                //                val window = GlfwWindow(1280, 720, "Dear ImGui GLFW+Vulkan example")

                // Setup Vulkan
                if (!glfw.vulkanSupported) {
                    System.err.println("GLFW: Vulkan Not Supported")
                    exitProcess(1)
                }

                val extensions = glfw.requiredInstanceExtensions
                val createInfo = InstanceCreateInfo(enabledExtensionNames = extensions)

                // Enabling multiple validation layers grouped as LunarG standard validation
                createInfo.enabledLayerNames = listOf("VK_LAYER_KHRONOS_validation")

                // Enable debug report extension (we need additional storage, so we duplicate the user array to add our new extension to it)
                extensions += "VK_EXT_debug_report"
                createInfo.enabledExtensionNames = extensions

                // Create Vulkan Instance
                val instance = Instance(createInfo)

                // Setup the debug report callback
                val debugReportCi = DebugReportCallbackCreateInfo(flags = VkDebugReport.ERROR_BIT_EXT.i or VkDebugReport.WARNING_BIT_EXT.i or VkDebugReport.PERFORMANCE_WARNING_BIT_EXT.i)
                val gDebugReport = instance createDebugReportCallbackEXT debugReportCi
            }
    }
}