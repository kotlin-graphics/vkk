package tests

import uno.createSurface
import uno.glfw.GlfwWindow
import uno.glfw.glfw
import uno.glfw.windowHint
import vkk.extensions.destroy
import vkk.identifiers.UniqueInstance
import vkk.unique.VkObjectHolder
import vkk.vk10.structs.Extent2D

class SurfaceData(instance: UniqueInstance, windowName: String,
                  val extent: Extent2D) {

    init {
        glfw.windowHint { api = windowHint.Api.None }
    }

    val window = GlfwWindow(extent.width, extent.height, windowName)

    val surface = instance createSurface window
}

fun VkObjectHolder.createSurfaceData(instance: UniqueInstance, windowName: String, extent: Extent2D): SurfaceData =
        SurfaceData(instance, windowName, extent).also { disposes += { instance destroy it.surface } }