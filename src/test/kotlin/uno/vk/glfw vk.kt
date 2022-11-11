package uno.vk

import kool.adr
import kool.mInt
import org.lwjgl.glfw.GLFWVulkan
import org.lwjgl.system.MemoryUtil.*
import uno.glfw.GlfwWindow
import uno.glfw.glfw
import uno.glfw.stak
import vkk.VK_CHECK_RESULT
import vkk.entities.VkSurfaceKHR
import vkk.identifiers.VkInstance

// --- [ glfwVulkanSupported ] ---
val glfw.vulkanSupported: Boolean
    get() = GLFWVulkan.glfwVulkanSupported()

// --- [ glfwGetRequiredInstanceExtensions ] ---
val glfw.requiredInstanceExtensions: ArrayList<String>
    get() = stak {
        val pCount = it.mInt()
        val ppNames = GLFWVulkan.nglfwGetRequiredInstanceExtensions(pCount.adr)
        val count = pCount[0]
        if (count == 0) arrayListOf()
        else {
            val pNames = memPointerBuffer(ppNames, count)
            val res = ArrayList<String>(count)
            for (i in 0 until count)
                res += memASCII(pNames[i])
            res
        }
    }

// --- [ glfwCreateWindowSurface ] ---
infix fun VkInstance.createSurface(window: GlfwWindow): VkSurfaceKHR =
        VkSurfaceKHR(stak.longAdr { VK_CHECK_RESULT(GLFWVulkan.nglfwCreateWindowSurface(adr, window.handle.value, NULL, it)) })