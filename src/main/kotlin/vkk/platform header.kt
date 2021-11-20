package vkk

import glm_.bool
import glm_.i
import kool.Ptr
import kool.adr
import org.lwjgl.system.windows.SECURITY_ATTRIBUTES
import org.lwjgl.vulkan.*
import vkk.entities.*
import java.nio.IntBuffer
import java.nio.LongBuffer

// win32

typealias VkWin32SurfaceCreateFlagsKHR = VkFlags

// ...

@JvmInline
value class VkFullScreenExclusiveEXT(val i: Int) {
    companion object {
        val DEFAULT_EXT = VkFullScreenExclusiveEXT(0)
        val ALLOWED_EXT = VkFullScreenExclusiveEXT(1)
        val DISALLOWED_EXT = VkFullScreenExclusiveEXT(2)
        val APPLICATION_CONTROLLED_EXT = VkFullScreenExclusiveEXT(3)
    }
}

// ..

// VkPhysicalDeviceSurfaceInfo2KHR is already defined in the header

// ..

// macosx

typealias VkMacOSSurfaceCreateFlagsMVK = VkFlags

// ..

// wayland

typealias VkWaylandSurfaceCreateFlagsKHR = VkFlags

// ..

// xlib

typealias VkXlibSurfaceCreateFlagsKHR = VkFlags

// ..