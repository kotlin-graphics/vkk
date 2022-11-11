package tests

import io.kotest.core.spec.style.StringSpec
import main.isNotCI
import uno.glfw.glfw
import uno.vk.requiredInstanceExtensions
import uno.vk.vulkanSupported
import vkk.extensions.VkDebugReport
import vkk.identifiers.VkInstance
import vkk.vk10.structs.DebugReportCallbackCreateInfo
import vkk.vk10.structs.InstanceCreateInfo
import kotlin.system.exitProcess

class `01a initInstance` : StringSpec() {

    init {
        if (isNotCI) //disable, crashing, to fix
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
                val instance = VkInstance(createInfo)

                // Setup the debug report callback
                val debugReportCi = DebugReportCallbackCreateInfo(flags = VkDebugReport.ERROR_BIT_EXT.i or VkDebugReport.WARNING_BIT_EXT.i or VkDebugReport.PERFORMANCE_WARNING_BIT_EXT.i)
                val gDebugReport = instance createDebugReportCallbackEXT debugReportCi
            }
    }
}