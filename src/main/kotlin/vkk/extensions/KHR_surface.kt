package vkk.extensions

import glm_.bool
import kool.*
import org.lwjgl.system.JNI.*
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.vulkan.VkSurfaceCapabilitiesKHR
import org.lwjgl.vulkan.VkSurfaceFormatKHR
import vkk.*
import vkk.entities.VkPresentModeKHR_Array
import vkk.entities.VkSurfaceKHR
import vkk.identifiers.VkInstance
import vkk.identifiers.PhysicalDevice
import vkk.vk10.structs.Extent2D

//#define VK_KHR_SURFACE_SPEC_VERSION       25

@JvmInline
value class VkColorSpaceKHR(val i: Int) {
    companion object {
        val SRGB_NONLINEAR_KHR = VkColorSpaceKHR(0)
        val DISPLAY_P3_NONLINEAR_EXT = VkColorSpaceKHR(1000104001)
        val EXTENDED_SRGB_LINEAR_EXT = VkColorSpaceKHR(1000104002)
        val DCI_P3_LINEAR_EXT = VkColorSpaceKHR(1000104003)
        val DCI_P3_NONLINEAR_EXT = VkColorSpaceKHR(1000104004)
        val BT709_LINEAR_EXT = VkColorSpaceKHR(1000104005)
        val BT709_NONLINEAR_EXT = VkColorSpaceKHR(1000104006)
        val BT2020_LINEAR_EXT = VkColorSpaceKHR(1000104007)
        val HDR10_ST2084_EXT = VkColorSpaceKHR(1000104008)
        val DOLBYVISION_EXT = VkColorSpaceKHR(1000104009)
        val HDR10_HLG_EXT = VkColorSpaceKHR(1000104010)
        val ADOBERGB_LINEAR_EXT = VkColorSpaceKHR(1000104011)
        val ADOBERGB_NONLINEAR_EXT = VkColorSpaceKHR(1000104012)
        val PASS_THROUGH_EXT = VkColorSpaceKHR(1000104013)
        val EXTENDED_SRGB_NONLINEAR_EXT = VkColorSpaceKHR(1000104014)
        val DISPLAY_NATIVE_AMD = VkColorSpaceKHR(1000213000)
    }
}

@JvmInline
value class VkPresentModeKHR(val i: Int) {
    companion object {
        val IMMEDIATE = VkPresentModeKHR(0)
        val MAILBOX = VkPresentModeKHR(1)
        val FIFO = VkPresentModeKHR(2)
        val FIFO_RELAXED = VkPresentModeKHR(3)
        val SHARED_DEMAND_REFRESH = VkPresentModeKHR(1000111000)
        val SHARED_CONTINUOUS_REFRESH = VkPresentModeKHR(1000111001)
    }
}


@JvmInline
value class VkSurfaceTransformKHR(val i: VkSurfaceTransformFlagsKHR) {
    companion object {
        val IDENTITY_BIT = VkSurfaceTransformKHR(0x00000001)
        val ROTATE_90_BIT = VkSurfaceTransformKHR(0x00000002)
        val ROTATE_180_BIT = VkSurfaceTransformKHR(0x00000004)
        val ROTATE_270_BIT = VkSurfaceTransformKHR(0x00000008)
        val HORIZONTAL_MIRROR_BIT = VkSurfaceTransformKHR(0x00000010)
        val HORIZONTAL_MIRROR_ROTATE_90_BIT = VkSurfaceTransformKHR(0x00000020)
        val HORIZONTAL_MIRROR_ROTATE_180_BIT = VkSurfaceTransformKHR(0x00000040)
        val HORIZONTAL_MIRROR_ROTATE_270_BIT = VkSurfaceTransformKHR(0x00000080)
        val INHERIT_BIT = VkSurfaceTransformKHR(0x00000100)
    }
}

infix fun Int.has(f: VkSurfaceTransformKHR) = and(f.i) != 0

typealias VkSurfaceTransformFlagsKHR = VkFlags

@JvmInline
value class VkCompositeAlphaKHR(val i: VkCompositeAlphaFlagsKHR) {
    companion object {
        val OPAQUE_BIT = VkCompositeAlphaKHR(0x00000001)
        val PRE_MULTIPLIED_BIT = VkCompositeAlphaKHR(0x00000002)
        val POST_MULTIPLIED_BIT = VkCompositeAlphaKHR(0x00000004)
        val INHERIT_BIT = VkCompositeAlphaKHR(0x00000008)
    }
}

infix fun Int.has(f: VkCompositeAlphaKHR) = and(f.i) != 0

typealias VkCompositeAlphaFlagsKHR = VkFlags

class SurfaceCapabilitiesKHR(
        var minImageCount: Int,
        var maxImageCount: Int,
        var currentExtent: Extent2D,
        var minImageExtent: Extent2D,
        var maxImageExtent: Extent2D,
        var maxImageArrayLayers: Int,
        var supportedTransforms: VkSurfaceTransformFlagsKHR,
        var currentTransform: VkSurfaceTransformKHR,
        var supportedCompositeAlpha: VkCompositeAlphaFlagsKHR,
        var supportedUsageFlags: VkImageUsageFlags) {

    constructor(ptr: BytePtr) : this(
            VkSurfaceCapabilitiesKHR.nminImageCount(ptr.adr),
            VkSurfaceCapabilitiesKHR.nmaxImageCount(ptr.adr),
            Extent2D(IntPtr(ptr + VkSurfaceCapabilitiesKHR.CURRENTEXTENT)),
            Extent2D(IntPtr(ptr + VkSurfaceCapabilitiesKHR.MINIMAGEEXTENT)),
            Extent2D(IntPtr(ptr + VkSurfaceCapabilitiesKHR.MAXIMAGEEXTENT)),
            VkSurfaceCapabilitiesKHR.nmaxImageArrayLayers(ptr.adr),
            VkSurfaceCapabilitiesKHR.nsupportedTransforms(ptr.adr),
            VkSurfaceTransformKHR(VkSurfaceCapabilitiesKHR.ncurrentTransform(ptr.adr)),
            VkSurfaceCapabilitiesKHR.nsupportedCompositeAlpha(ptr.adr),
            VkSurfaceCapabilitiesKHR.nsupportedUsageFlags(ptr.adr)
    )

    companion object {
        //inline fun <R> read(block: (Ptr) -> R): SurfaceCapabilitiesKHR = stak { read(it, block) }
        inline fun <R> read(stack: MemoryStack, block: (Ptr) -> R): SurfaceCapabilitiesKHR = stack {
            val ptr = stack.ncalloc(VkSurfaceCapabilitiesKHR.ALIGNOF, 1, VkSurfaceCapabilitiesKHR.SIZEOF)
            block(ptr)
            SurfaceCapabilitiesKHR(BytePtr(ptr))
        }
    }
}

class SurfaceFormatKHR(
        var format: VkFormat = VkFormat.UNDEFINED, // 0
        var colorSpace: VkColorSpaceKHR = VkColorSpaceKHR.SRGB_NONLINEAR_KHR) { // 0

    constructor(intPtr: IntPtr) : this(VkFormat(intPtr[0]), VkColorSpaceKHR(intPtr[1]))
}

interface VkStack_KHR_surface : VkStackInterface {

    // --- [ vkGetPhysicalDeviceSurfaceSupportKHR ] ---

    fun PhysicalDevice.getSurfaceSupportKHR(queueFamilyIndex: Int, surface: VkSurfaceKHR): Boolean =
            stack.intAdr { VK_CHECK_RESULT(callPJPI(adr, queueFamilyIndex, surface.L, it, capabilities.vkGetPhysicalDeviceSurfaceSupportKHR)) }.bool

    fun PhysicalDevice.getSurfaceSupportsKHR(queueFamilySize: Int, surface: VkSurfaceKHR): BooleanArray = stack {
        val supported = stack.mInt()
        BooleanArray(queueFamilySize) {
            VK_CHECK_RESULT(callPJPI(adr, it, surface.L, supported.adr, capabilities.vkGetPhysicalDeviceSurfaceSupportKHR))
            supported[0].bool
        }
    }

    // --- [ vkGetPhysicalDeviceSurfaceCapabilitiesKHR ] ---

    infix fun PhysicalDevice.getSurfaceCapabilitiesKHR(surface: VkSurfaceKHR): SurfaceCapabilitiesKHR =
            SurfaceCapabilitiesKHR.read(stack) { VK_CHECK_RESULT(callPJPI(adr, surface.L, it, capabilities.vkGetPhysicalDeviceSurfaceCapabilitiesKHR)) }

    // --- [ vkGetPhysicalDeviceSurfaceFormatsKHR ] ---

    infix fun PhysicalDevice.getSurfaceFormatsKHR(surface: VkSurfaceKHR): ArrayList<SurfaceFormatKHR> = stack {
        val pCount = stack.mInt()
        VkResult(callPJPPI(adr, surface.L, pCount.adr, NULL, capabilities.vkGetPhysicalDeviceSurfaceFormatsKHR)).check()
        val count = pCount[0]
        assert(count > 0)
        val pSurfaceFormats = stack.ncalloc(VkSurfaceFormatKHR.ALIGNOF, count, VkSurfaceFormatKHR.SIZEOF)
        VkResult(callPJPPI(adr, surface.L, pCount.adr, pSurfaceFormats, capabilities.vkGetPhysicalDeviceSurfaceFormatsKHR)).check()
        val res = ArrayList<SurfaceFormatKHR>(count)
        for (i in 0 until count)
            res += SurfaceFormatKHR(IntPtr(pSurfaceFormats + VkSurfaceFormatKHR.SIZEOF * i))
        res
    }

    // --- [ vkGetPhysicalDeviceSurfacePresentModesKHR ] ---

    infix fun PhysicalDevice.getSurfacePresentModesKHR(surface: VkSurfaceKHR): VkPresentModeKHR_Array = stack {
        val pPresentModeCount = stack.mInt()
        var propertyCount: Int
        var result: VkResult
        var pPresentModes = IntPtr.NULL
        do {
            result = VkResult(callPJPPI(adr, surface.L, pPresentModeCount.adr, NULL, capabilities.vkGetPhysicalDeviceSurfacePresentModesKHR))
            propertyCount = pPresentModeCount[0]
            if (result == VkResult.SUCCESS && propertyCount != 0) {
                pPresentModes = stack.mInt(propertyCount)
                VkResult(callPJPPI(adr, surface.L, pPresentModeCount.adr, pPresentModes.adr, capabilities.vkGetPhysicalDeviceSurfacePresentModesKHR)).check()
            }
        } while (result == VkResult.INCOMPLETE)
        VkPresentModeKHR_Array(propertyCount) { VkPresentModeKHR(pPresentModes[it]) }
    }
}

// --- [ vkDestroySurfaceKHR ] ---
infix fun VkInstance.destroy(surface: VkSurfaceKHR) = callPJPV(adr, surface.L, NULL, capabilities.vkDestroySurfaceKHR)

// --- [ vkGetPhysicalDeviceSurfaceSupportKHR ] ---

fun PhysicalDevice.getSurfaceSupportKHR(queueFamilyIndex: Int, surface: VkSurfaceKHR): Boolean =
        VkStack { it.run { getSurfaceSupportKHR(queueFamilyIndex, surface) } }

fun PhysicalDevice.getSurfaceSupportsKHR(queueFamilySize: Int, surface: VkSurfaceKHR): BooleanArray =
        VkStack { it.run { getSurfaceSupportsKHR(queueFamilySize, surface) } }

// --- [ vkGetPhysicalDeviceSurfaceCapabilitiesKHR ] ---
infix fun PhysicalDevice.getSurfaceCapabilitiesKHR(surface: VkSurfaceKHR): SurfaceCapabilitiesKHR =
        VkStack { it.run { getSurfaceCapabilitiesKHR(surface) } }

// --- [ vkGetPhysicalDeviceSurfaceFormatsKHR ] ---
infix fun PhysicalDevice.getSurfaceFormatsKHR(surface: VkSurfaceKHR): ArrayList<SurfaceFormatKHR> =
        VkStack { it.run { getSurfaceFormatsKHR(surface) } }

// --- [ vkGetPhysicalDeviceSurfacePresentModesKHR ] ---
infix fun PhysicalDevice.getSurfacePresentModesKHR(surface: VkSurfaceKHR): VkPresentModeKHR_Array =
        VkStack { it.run { getSurfacePresentModesKHR(surface) } }