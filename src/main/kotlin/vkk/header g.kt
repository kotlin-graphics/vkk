package vkk

import glm_.BYTES
import glm_.b
import glm_.bool
import glm_.i
import glm_.vec2.Vec2i
import kool.Ptr
import kool.adr
import org.lwjgl.PointerBuffer
import org.lwjgl.system.MemoryStack.stackGet
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.vulkan.*
import vkk.entities.*
import java.nio.ByteBuffer
import java.nio.IntBuffer


inline class VkPresentModeKHR(val i: Int) {
    companion object {
        val IMMEDIATE_KHR = VkPresentModeKHR(0)
        val MAILBOX_KHR = VkPresentModeKHR(1)
        val FIFO_KHR = VkPresentModeKHR(2)
        val FIFO_RELAXED_KHR = VkPresentModeKHR(3)
        val SHARED_DEMAND_REFRESH_KHR = VkPresentModeKHR(1000111000)
        val SHARED_CONTINUOUS_REFRESH_KHR = VkPresentModeKHR(1000111001)
    }
}


inline class VkSurfaceTransformKHR(val i: Int) {
    companion object {
        val IDENTITY_BIT_KHR = VkSurfaceTransformKHR(0x00000001)
        val ROTATE_90_BIT_KHR = VkSurfaceTransformKHR(0x00000002)
        val ROTATE_180_BIT_KHR = VkSurfaceTransformKHR(0x00000004)
        val ROTATE_270_BIT_KHR = VkSurfaceTransformKHR(0x00000008)
        val HORIZONTAL_MIRROR_BIT_KHR = VkSurfaceTransformKHR(0x00000010)
        val HORIZONTAL_MIRROR_ROTATE_90_BIT_KHR = VkSurfaceTransformKHR(0x00000020)
        val HORIZONTAL_MIRROR_ROTATE_180_BIT_KHR = VkSurfaceTransformKHR(0x00000040)
        val HORIZONTAL_MIRROR_ROTATE_270_BIT_KHR = VkSurfaceTransformKHR(0x00000080)
        val INHERIT_BIT_KHR = VkSurfaceTransformKHR(0x00000100)
    }
}

infix fun Int.has(f: VkSurfaceTransformKHR) = and(f.i) != 0

typealias VkSurfaceTransformFlagsKHR = VkFlags

inline class VkCompositeAlphaKHR(val i: Int) {
    companion object {
        val OPAQUE_BIT_KHR = VkCompositeAlphaKHR(0x00000001)
        val PRE_MULTIPLIED_BIT_KHR = VkCompositeAlphaKHR(0x00000002)
        val POST_MULTIPLIED_BIT_KHR = VkCompositeAlphaKHR(0x00000004)
        val INHERIT_BIT_KHR = VkCompositeAlphaKHR(0x00000008)
    }
}

infix fun Int.has(f: VkCompositeAlphaKHR) = and(f.i) != 0

typealias VkCompositeAlphaFlagsKHR = VkFlags


inline val VkSurfaceCapabilitiesKHR.minImageCount: Int
    get() = VkSurfaceCapabilitiesKHR.nminImageCount(adr)
inline val VkSurfaceCapabilitiesKHR.maxImageCount: Int
    get() = VkSurfaceCapabilitiesKHR.nmaxImageCount(adr)
inline val VkSurfaceCapabilitiesKHR.currentExtent: VkExtent2D
    get() = VkSurfaceCapabilitiesKHR.ncurrentExtent(adr)
inline val VkSurfaceCapabilitiesKHR.minImageExtent: VkExtent2D
    get() = VkSurfaceCapabilitiesKHR.nminImageExtent(adr)
inline val VkSurfaceCapabilitiesKHR.maxImageExtent: VkExtent2D
    get() = VkSurfaceCapabilitiesKHR.nmaxImageExtent(adr)
inline val VkSurfaceCapabilitiesKHR.maxImageArrayLayers: Int
    get() = VkSurfaceCapabilitiesKHR.nmaxImageArrayLayers(adr)
inline val VkSurfaceCapabilitiesKHR.supportedTransforms: VkSurfaceTransformFlagsKHR
    get() = VkSurfaceCapabilitiesKHR.nsupportedTransforms(adr)
inline val VkSurfaceCapabilitiesKHR.currentTransform: VkSurfaceTransformKHR
    get() = VkSurfaceTransformKHR(VkSurfaceCapabilitiesKHR.ncurrentTransform(adr))
inline val VkSurfaceCapabilitiesKHR.supportedCompositeAlpha: VkCompositeAlphaFlagsKHR
    get() = VkSurfaceCapabilitiesKHR.nsupportedCompositeAlpha(adr)
inline val VkSurfaceCapabilitiesKHR.supportedUsageFlags: VkImageUsageFlags
    get() = VkSurfaceCapabilitiesKHR.nsupportedUsageFlags(adr)


inline var VkSurfaceFormatKHR.format: VkFormat
    get() = VkFormat(VkSurfaceFormatKHR.nformat(adr))
    set(value) = memPutInt(adr + VkSurfaceFormatKHR.FORMAT, value.i)
inline var VkSurfaceFormatKHR.colorSpace: VkColorSpaceKHR
    get() = VkColorSpaceKHR(VkSurfaceFormatKHR.ncolorSpace(adr))
    set(value) = memPutInt(adr + VkSurfaceFormatKHR.COLORSPACE, value.i)

/** JVM custom */
operator fun VkSurfaceFormatKHR.invoke(surfaceFormatKHR: VkSurfaceFormatKHR) {
    format = surfaceFormatKHR.format
    colorSpace = surfaceFormatKHR.colorSpace
}


inline class VkSwapchainCreateKHR(val i: Int) {
    companion object {
        val SPLIT_INSTANCE_BIND_REGIONS_BIT_KHR = VkSwapchainCreateKHR(0x00000001)
        val PROTECTED_BIT_KHR = VkSwapchainCreateKHR(0x00000002)
        val MUTABLE_FORMAT_BIT_KHR = VkSwapchainCreateKHR(0x00000004)
    }
}

typealias VkSwapchainCreateFlagsKHR = VkFlags


inline class VkDeviceGroupPresentModeKHR(val i: Int) {
    companion object {
        val LOCAL_BIT_KHR = VkDeviceGroupPresentModeKHR(0x00000001)
        val REMOTE_BIT_KHR = VkDeviceGroupPresentModeKHR(0x00000002)
        val SUM_BIT_KHR = VkDeviceGroupPresentModeKHR(0x00000004)
        val LOCAL_MULTI_DEVICE_BIT_KHR = VkDeviceGroupPresentModeKHR(0x00000008)
    }
}

typealias VkDeviceGroupPresentModeFlagsKHR = VkFlags


inline var VkSwapchainCreateInfoKHR.type: VkStructureType
    get() = VkStructureType(VkSwapchainCreateInfoKHR.nsType(adr))
    set(value) = VkSwapchainCreateInfoKHR.nsType(adr, value.i)
inline var VkSwapchainCreateInfoKHR.next: Ptr
    get() = VkSwapchainCreateInfoKHR.npNext(adr)
    set(value) = VkSwapchainCreateInfoKHR.npNext(adr, value)
inline var VkSwapchainCreateInfoKHR.flags: VkSwapchainCreateFlagsKHR
    get() = VkSwapchainCreateInfoKHR.nflags(adr)
    set(value) = VkSwapchainCreateInfoKHR.nflags(adr, value)
inline var VkSwapchainCreateInfoKHR.surface: VkSurfaceKHR
    get() = VkSurfaceKHR(VkSwapchainCreateInfoKHR.nsurface(adr))
    set(value) = VkSwapchainCreateInfoKHR.nsurface(adr, value.L)
inline var VkSwapchainCreateInfoKHR.minImageCount: Int
    get() = VkSwapchainCreateInfoKHR.nminImageCount(adr)
    set(value) = VkSwapchainCreateInfoKHR.nminImageCount(adr, value)
inline var VkSwapchainCreateInfoKHR.imageFormat: VkFormat
    get() = VkFormat(VkSwapchainCreateInfoKHR.nimageFormat(adr))
    set(value) = VkSwapchainCreateInfoKHR.nimageFormat(adr, value.i)
inline var VkSwapchainCreateInfoKHR.imageColorSpace: VkColorSpaceKHR
    get() = VkColorSpaceKHR(VkSwapchainCreateInfoKHR.nimageColorSpace(adr))
    set(value) = VkSwapchainCreateInfoKHR.nimageColorSpace(adr, value.i)
inline var VkSwapchainCreateInfoKHR.imageExtent: VkExtent2D
    get() = VkSwapchainCreateInfoKHR.nimageExtent(adr)
    set(value) = VkSwapchainCreateInfoKHR.nimageExtent(adr, value)

/** JVM custom */
fun VkSwapchainCreateInfoKHR.imageExtent(extent: Vec2i) {
    imageExtent.width = extent.x
    imageExtent.height = extent.y
}

inline var VkSwapchainCreateInfoKHR.imageArrayLayers: Int
    get() = VkSwapchainCreateInfoKHR.nimageArrayLayers(adr)
    set(value) = VkSwapchainCreateInfoKHR.nimageArrayLayers(adr, value)
inline var VkSwapchainCreateInfoKHR.imageUsage: VkImageUsageFlags
    get() = VkSwapchainCreateInfoKHR.nimageUsage(adr)
    set(value) = VkSwapchainCreateInfoKHR.nimageUsage(adr, value)
inline var VkSwapchainCreateInfoKHR.imageSharingMode: VkSharingMode
    get() = VkSharingMode(VkSwapchainCreateInfoKHR.nimageSharingMode(adr))
    set(value) = VkSwapchainCreateInfoKHR.nimageSharingMode(adr, value.i)
inline val VkSwapchainCreateInfoKHR.queueFamilyIndexCount: Int
    get() = VkSwapchainCreateInfoKHR.nqueueFamilyIndexCount(adr)
inline var VkSwapchainCreateInfoKHR.queueFamilyIndices: IntBuffer?
    get() = VkSwapchainCreateInfoKHR.npQueueFamilyIndices(adr)
    set(value) = VkSwapchainCreateInfoKHR.npQueueFamilyIndices(adr, value)
inline var VkSwapchainCreateInfoKHR.preTransform: VkSurfaceTransformKHR
    get() = VkSurfaceTransformKHR(VkSwapchainCreateInfoKHR.npreTransform(adr))
    set(value) = VkSwapchainCreateInfoKHR.npreTransform(adr, value.i)
inline var VkSwapchainCreateInfoKHR.compositeAlpha: VkCompositeAlphaKHR
    get() = VkCompositeAlphaKHR(VkSwapchainCreateInfoKHR.ncompositeAlpha(adr))
    set(value) = VkSwapchainCreateInfoKHR.ncompositeAlpha(adr, value.i)
inline var VkSwapchainCreateInfoKHR.presentMode: VkPresentModeKHR
    get() = VkPresentModeKHR(VkSwapchainCreateInfoKHR.npresentMode(adr))
    set(value) = VkSwapchainCreateInfoKHR.npresentMode(adr, value.i)
inline var VkSwapchainCreateInfoKHR.clipped: Boolean
    get() = VkSwapchainCreateInfoKHR.nclipped(adr).bool
    set(value) = VkSwapchainCreateInfoKHR.nclipped(adr, value.i)
inline var VkSwapchainCreateInfoKHR.oldSwapchain: VkSwapchainKHR
    get() = VkSwapchainKHR(VkSwapchainCreateInfoKHR.noldSwapchain(adr))
    set(value) = VkSwapchainCreateInfoKHR.noldSwapchain(adr, value.L)


inline var VkPresentInfoKHR.type: VkStructureType
    get() = VkStructureType(VkPresentInfoKHR.nsType(adr))
    set(value) = VkPresentInfoKHR.nsType(adr, value.i)
inline var VkPresentInfoKHR.next: Ptr
    get() = VkPresentInfoKHR.npNext(adr)
    set(value) = VkPresentInfoKHR.npNext(adr, value)
@Deprecated("this will be set automatically")
inline var VkPresentInfoKHR.waitSemaphoreCount: Int
    get() = VkPresentInfoKHR.nwaitSemaphoreCount(adr)
    set(value) = VkPresentInfoKHR.nwaitSemaphoreCount(adr, value)
inline var VkPresentInfoKHR.waitSemaphores: VkSemaphore_Buffer?
    get() = VkPresentInfoKHR.npWaitSemaphores(adr)?.let(::VkSemaphore_Buffer)
    set(value) = VkPresentInfoKHR.npWaitSemaphores(adr, value?.buffer)
/** JVM custom */
inline var VkPresentInfoKHR.waitSemaphore: VkSemaphore?
    get() = VkPresentInfoKHR.npWaitSemaphores(adr)?.let { VkSemaphore(it[0]) }
    set(value) = when (value) {
        null -> {
            memPutAddress(adr + VkPresentInfoKHR.PWAITSEMAPHORES, NULL)
            waitSemaphoreCount = 0
        }
        else -> {
            val p = stackGet().nmalloc(8, Long.BYTES)
            memPutLong(p, value.L)
            waitSemaphoreCount = 1
        }
    }
inline var VkPresentInfoKHR.swapchainCount: Int
    get() = VkPresentInfoKHR.nswapchainCount(adr)
    set(value) = VkPresentInfoKHR.nswapchainCount(adr, value)
inline var VkPresentInfoKHR.swapchains: VkSwapchainKHR_Buffer
    get() = VkSwapchainKHR_Buffer(VkPresentInfoKHR.npSwapchains(adr))
    set(value) = VkPresentInfoKHR.npSwapchains(adr, value.buffer)
/** JVM custom */
inline var VkPresentInfoKHR.swapchain: VkSwapchainKHR
    get() = VkSwapchainKHR(VkPresentInfoKHR.npSwapchains(adr)[0])
    set(value) = stak.longAddress(value.L) { memPutAddress(adr + VkPresentInfoKHR.PSWAPCHAINS, it) }
inline var VkPresentInfoKHR.imageIndices: IntBuffer
    get() = VkPresentInfoKHR.npImageIndices(adr)
    set(value) = VkPresentInfoKHR.npImageIndices(adr, value)
/** JVM custom */
inline var VkPresentInfoKHR.imageIndex: Int
    get() = VkPresentInfoKHR.npImageIndices(adr)[0]
    set(value) = stak.intAddress(value) { memPutAddress(adr + VkPresentInfoKHR.PIMAGEINDICES, it) }
inline var VkPresentInfoKHR.results: VkResultBuffer?
    get() = VkPresentInfoKHR.npResults(adr)
    set(value) = VkPresentInfoKHR.npResults(adr, value)


inline var VkImageSwapchainCreateInfoKHR.type: VkStructureType
    get() = VkStructureType(VkImageSwapchainCreateInfoKHR.nsType(adr))
    set(value) = VkImageSwapchainCreateInfoKHR.nsType(adr, value.i)
inline var VkImageSwapchainCreateInfoKHR.next: Ptr
    get() = VkImageSwapchainCreateInfoKHR.npNext(adr)
    set(value) = VkImageSwapchainCreateInfoKHR.npNext(adr, value)
inline var VkImageSwapchainCreateInfoKHR.swapchain: VkSwapchainKHR
    get() = VkSwapchainKHR(VkImageSwapchainCreateInfoKHR.nswapchain(adr))
    set(value) = VkImageSwapchainCreateInfoKHR.nswapchain(adr, value.L)


inline var VkBindImageMemorySwapchainInfoKHR.type: VkStructureType
    get() = VkStructureType(VkBindImageMemorySwapchainInfoKHR.nsType(adr))
    set(value) = VkBindImageMemorySwapchainInfoKHR.nsType(adr, value.i)
inline var VkBindImageMemorySwapchainInfoKHR.next: Ptr
    get() = VkBindImageMemorySwapchainInfoKHR.npNext(adr)
    set(value) = VkBindImageMemorySwapchainInfoKHR.npNext(adr, value)
inline var VkBindImageMemorySwapchainInfoKHR.swapchain: VkSwapchainKHR
    get() = VkSwapchainKHR(VkBindImageMemorySwapchainInfoKHR.nswapchain(adr))
    set(value) = VkBindImageMemorySwapchainInfoKHR.nswapchain(adr, value.L)
inline var VkBindImageMemorySwapchainInfoKHR.imageIndex: Int
    get() = VkBindImageMemorySwapchainInfoKHR.nimageIndex(adr)
    set(value) = VkBindImageMemorySwapchainInfoKHR.nimageIndex(adr, value)


inline var VkAcquireNextImageInfoKHR.type: VkStructureType
    get() = VkStructureType(VkAcquireNextImageInfoKHR.nsType(adr))
    set(value) = VkAcquireNextImageInfoKHR.nsType(adr, value.i)
inline var VkAcquireNextImageInfoKHR.next: Ptr
    get() = VkAcquireNextImageInfoKHR.npNext(adr)
    set(value) = VkAcquireNextImageInfoKHR.npNext(adr, value)
inline var VkAcquireNextImageInfoKHR.swapchain: VkSwapchainKHR
    get() = VkSwapchainKHR(VkAcquireNextImageInfoKHR.nswapchain(adr))
    set(value) = VkAcquireNextImageInfoKHR.nswapchain(adr, value.L)
inline var VkAcquireNextImageInfoKHR.timeout: Long
    get() = VkAcquireNextImageInfoKHR.ntimeout(adr)
    set(value) = VkAcquireNextImageInfoKHR.ntimeout(adr, value)
inline var VkAcquireNextImageInfoKHR.semaphore: VkSemaphore
    get() = VkSemaphore(VkAcquireNextImageInfoKHR.nsemaphore(adr))
    set(value) = VkAcquireNextImageInfoKHR.nsemaphore(adr, value.L)
inline var VkAcquireNextImageInfoKHR.fence: VkFence
    get() = VkFence(VkAcquireNextImageInfoKHR.nfence(adr))
    set(value) = VkAcquireNextImageInfoKHR.nfence(adr, value.L)
inline var VkAcquireNextImageInfoKHR.deviceMask: Int
    get() = VkAcquireNextImageInfoKHR.ndeviceMask(adr)
    set(value) = VkAcquireNextImageInfoKHR.ndeviceMask(adr, value)


inline var VkDeviceGroupPresentCapabilitiesKHR.type: VkStructureType
    get() = VkStructureType(VkDeviceGroupPresentCapabilitiesKHR.nsType(adr))
    set(value) = VkDeviceGroupPresentCapabilitiesKHR.nsType(adr, value.i)
inline var VkDeviceGroupPresentCapabilitiesKHR.next: Ptr
    get() = VkDeviceGroupPresentCapabilitiesKHR.npNext(adr)
    set(value) = VkDeviceGroupPresentCapabilitiesKHR.npNext(adr, value)
inline val VkDeviceGroupPresentCapabilitiesKHR.presentMask: IntBuffer
    get() = VkDeviceGroupPresentCapabilitiesKHR.npresentMask(adr)
inline val VkDeviceGroupPresentCapabilitiesKHR.modes: VkDeviceGroupPresentModeFlagsKHR
    get() = VkDeviceGroupPresentCapabilitiesKHR.nmodes(adr)


inline var VkDeviceGroupPresentInfoKHR.type: VkStructureType
    get() = VkStructureType(VkDeviceGroupPresentInfoKHR.nsType(adr))
    set(value) = VkDeviceGroupPresentInfoKHR.nsType(adr, value.i)
inline var VkDeviceGroupPresentInfoKHR.next: Ptr
    get() = VkDeviceGroupPresentInfoKHR.npNext(adr)
    set(value) = VkDeviceGroupPresentInfoKHR.npNext(adr, value)
@Deprecated("this will be set automatically")
inline var VkDeviceGroupPresentInfoKHR.swapchainCount: Int
    get() = VkDeviceGroupPresentInfoKHR.nswapchainCount(adr)
    set(value) = VkDeviceGroupPresentInfoKHR.nswapchainCount(adr, value)
inline var VkDeviceGroupPresentInfoKHR.deviceMasks: IntBuffer?
    get() = VkDeviceGroupPresentInfoKHR.npDeviceMasks(adr)
    set(value) = VkDeviceGroupPresentInfoKHR.npDeviceMasks(adr, value)
inline var VkDeviceGroupPresentInfoKHR.mode: VkDeviceGroupPresentModeKHR
    get() = VkDeviceGroupPresentModeKHR(VkDeviceGroupPresentInfoKHR.nmode(adr))
    set(value) = VkDeviceGroupPresentInfoKHR.nmode(adr, value.i)


inline var VkDeviceGroupSwapchainCreateInfoKHR.type: VkStructureType
    get() = VkStructureType(VkDeviceGroupSwapchainCreateInfoKHR.nsType(adr))
    set(value) = VkDeviceGroupSwapchainCreateInfoKHR.nsType(adr, value.i)
inline var VkDeviceGroupSwapchainCreateInfoKHR.next: Ptr
    get() = VkDeviceGroupSwapchainCreateInfoKHR.npNext(adr)
    set(value) = VkDeviceGroupSwapchainCreateInfoKHR.npNext(adr, value)
inline var VkDeviceGroupSwapchainCreateInfoKHR.modes: VkDeviceGroupPresentModeFlagsKHR
    get() = VkDeviceGroupSwapchainCreateInfoKHR.nmodes(adr)
    set(value) = VkDeviceGroupSwapchainCreateInfoKHR.nmodes(adr, value)


inline class VkDisplayPlaneAlphaKHR(val i: Int) {

    companion object {
        val OPAQUE_BIT_KHR = VkDisplayPlaneAlphaKHR(0x00000001)
        val GLOBAL_BIT_KHR = VkDisplayPlaneAlphaKHR(0x00000002)
        val PER_PIXEL_BIT_KHR = VkDisplayPlaneAlphaKHR(0x00000004)
        val PER_PIXEL_PREMULTIPLIED_BIT_KHR = VkDisplayPlaneAlphaKHR(0x00000008)
    }
}

typealias VkDisplayPlaneAlphaFlagsKHR = VkFlags
typealias VkDisplayModeCreateFlagsKHR = VkFlags
typealias VkDisplaySurfaceCreateFlagsKHR = VkFlags


inline val VkDisplayPropertiesKHR.display: VkDisplayKHR
    get() = VkDisplayKHR(VkDisplayPropertiesKHR.ndisplay(adr))
inline val VkDisplayPropertiesKHR.displayName: String
    get() = VkDisplayPropertiesKHR.ndisplayNameString(adr)
inline val VkDisplayPropertiesKHR.physicalDimensions: VkExtent2D
    get() = VkDisplayPropertiesKHR.nphysicalDimensions(adr)
inline val VkDisplayPropertiesKHR.physicalResolution: VkExtent2D
    get() = VkDisplayPropertiesKHR.nphysicalResolution(adr)
inline val VkDisplayPropertiesKHR.supportedTransforms: VkSurfaceTransformFlagsKHR
    get() = VkDisplayPropertiesKHR.nsupportedTransforms(adr)
inline val VkDisplayPropertiesKHR.planeReorderPossible: Boolean
    get() = VkDisplayPropertiesKHR.nplaneReorderPossible(adr).bool
inline val VkDisplayPropertiesKHR.persistentContent: Boolean
    get() = VkDisplayPropertiesKHR.npersistentContent(adr).bool


inline var VkDisplayModeParametersKHR.visibleRegion: VkExtent2D
    get() = VkDisplayModeParametersKHR.nvisibleRegion(adr)
    set(value) = VkDisplayModeParametersKHR.nvisibleRegion(adr, value)
inline var VkDisplayModeParametersKHR.refreshRate: Int
    get() = VkDisplayModeParametersKHR.nrefreshRate(adr)
    set(value) = VkDisplayModeParametersKHR.nrefreshRate(adr, value)


inline val VkDisplayModePropertiesKHR.displayMode: VkDisplayModeKHR
    get() = VkDisplayModeKHR(VkDisplayModePropertiesKHR.ndisplayMode(adr))
inline val VkDisplayModePropertiesKHR.parameters: VkDisplayModeParametersKHR
    get() = VkDisplayModePropertiesKHR.nparameters(adr)


inline var VkDisplayModeCreateInfoKHR.type: VkStructureType
    get() = VkStructureType(VkDisplayModeCreateInfoKHR.nsType(adr))
    set(value) = VkDisplayModeCreateInfoKHR.nsType(adr, value.i)
inline var VkDisplayModeCreateInfoKHR.next: Ptr
    get() = VkDisplayModeCreateInfoKHR.npNext(adr)
    set(value) = VkDisplayModeCreateInfoKHR.npNext(adr, value)
inline var VkDisplayModeCreateInfoKHR.flags: VkDisplayModeCreateFlagsKHR
    get() = VkDisplayModeCreateInfoKHR.nflags(adr)
    set(value) = VkDisplayModeCreateInfoKHR.nflags(adr, value)
inline var VkDisplayModeCreateInfoKHR.parameters: VkDisplayModeParametersKHR
    get() = VkDisplayModeCreateInfoKHR.nparameters(adr)
    set(value) = VkDisplayModeCreateInfoKHR.nparameters(adr, value)


inline val VkDisplayPlaneCapabilitiesKHR.supportedAlpha: VkDisplayPlaneAlphaFlagsKHR
    get() = VkDisplayPlaneCapabilitiesKHR.nsupportedAlpha(adr)
inline val VkDisplayPlaneCapabilitiesKHR.minSrcPosition: VkOffset2D
    get() = VkDisplayPlaneCapabilitiesKHR.nminSrcPosition(adr)
inline val VkDisplayPlaneCapabilitiesKHR.maxSrcPosition: VkOffset2D
    get() = VkDisplayPlaneCapabilitiesKHR.nmaxSrcPosition(adr)
inline val VkDisplayPlaneCapabilitiesKHR.minSrcExtent: VkExtent2D
    get() = VkDisplayPlaneCapabilitiesKHR.nminSrcExtent(adr)
inline val VkDisplayPlaneCapabilitiesKHR.maxSrcExtent: VkExtent2D
    get() = VkDisplayPlaneCapabilitiesKHR.nmaxSrcExtent(adr)
inline val VkDisplayPlaneCapabilitiesKHR.minDstPosition: VkOffset2D
    get() = VkDisplayPlaneCapabilitiesKHR.nminDstPosition(adr)
inline val VkDisplayPlaneCapabilitiesKHR.maxDstPosition: VkOffset2D
    get() = VkDisplayPlaneCapabilitiesKHR.nmaxDstPosition(adr)
inline val VkDisplayPlaneCapabilitiesKHR.minDstExtent: VkExtent2D
    get() = VkDisplayPlaneCapabilitiesKHR.nminDstExtent(adr)
inline val VkDisplayPlaneCapabilitiesKHR.maxDstExtent: VkExtent2D
    get() = VkDisplayPlaneCapabilitiesKHR.nmaxDstExtent(adr)


inline val VkDisplayPlanePropertiesKHR.currentDisplay: VkDisplayKHR
    get() = VkDisplayKHR(VkDisplayPlanePropertiesKHR.ncurrentDisplay(adr))
inline val VkDisplayPlanePropertiesKHR.currentStackIndex: Int
    get() = VkDisplayPlanePropertiesKHR.ncurrentStackIndex(adr)


inline var VkDisplaySurfaceCreateInfoKHR.type: VkStructureType
    get() = VkStructureType(VkDisplaySurfaceCreateInfoKHR.nsType(adr))
    set(value) = VkDisplaySurfaceCreateInfoKHR.nsType(adr, value.i)
inline var VkDisplaySurfaceCreateInfoKHR.next: Ptr
    get() = VkDisplaySurfaceCreateInfoKHR.npNext(adr)
    set(value) = VkDisplaySurfaceCreateInfoKHR.npNext(adr, value)
inline var VkDisplaySurfaceCreateInfoKHR.flags: VkDisplaySurfaceCreateFlagsKHR
    get() = VkDisplaySurfaceCreateInfoKHR.nflags(adr)
    set(value) = VkDisplaySurfaceCreateInfoKHR.nflags(adr, value)
inline var VkDisplaySurfaceCreateInfoKHR.displayMode: VkDisplayModeKHR
    get() = VkDisplayModeKHR(VkDisplaySurfaceCreateInfoKHR.ndisplayMode(adr))
    set(value) = VkDisplaySurfaceCreateInfoKHR.ndisplayMode(adr, value.L)
inline var VkDisplaySurfaceCreateInfoKHR.planeIndex: Int
    get() = VkDisplaySurfaceCreateInfoKHR.nplaneIndex(adr)
    set(value) = VkDisplaySurfaceCreateInfoKHR.nplaneIndex(adr, value)
inline var VkDisplaySurfaceCreateInfoKHR.planeStackIndex: Int
    get() = VkDisplaySurfaceCreateInfoKHR.nplaneStackIndex(adr)
    set(value) = VkDisplaySurfaceCreateInfoKHR.nplaneStackIndex(adr, value)
inline var VkDisplaySurfaceCreateInfoKHR.transform: VkSurfaceTransformKHR
    get() = VkSurfaceTransformKHR(VkDisplaySurfaceCreateInfoKHR.ntransform(adr))
    set(value) = VkDisplaySurfaceCreateInfoKHR.ntransform(adr, value.i)
inline var VkDisplaySurfaceCreateInfoKHR.globalAlpha: Float
    get() = VkDisplaySurfaceCreateInfoKHR.nglobalAlpha(adr)
    set(value) = VkDisplaySurfaceCreateInfoKHR.nglobalAlpha(adr, value)
inline var VkDisplaySurfaceCreateInfoKHR.alphaMode: VkDisplayPlaneAlphaKHR
    get() = VkDisplayPlaneAlphaKHR(VkDisplaySurfaceCreateInfoKHR.nalphaMode(adr))
    set(value) = VkDisplaySurfaceCreateInfoKHR.nalphaMode(adr, value.i)
inline var VkDisplaySurfaceCreateInfoKHR.imageExtent: VkExtent2D
    get() = VkDisplaySurfaceCreateInfoKHR.nimageExtent(adr)
    set(value) = VkDisplaySurfaceCreateInfoKHR.nimageExtent(adr, value)


inline var VkDisplayPresentInfoKHR.type: VkStructureType
    get() = VkStructureType(VkDisplayPresentInfoKHR.nsType(adr))
    set(value) = VkDisplayPresentInfoKHR.nsType(adr, value.i)
inline var VkDisplayPresentInfoKHR.next: Ptr
    get() = VkDisplayPresentInfoKHR.npNext(adr)
    set(value) = VkDisplayPresentInfoKHR.npNext(adr, value)
inline var VkDisplayPresentInfoKHR.srcRect: VkRect2D
    get() = VkDisplayPresentInfoKHR.nsrcRect(adr)
    set(value) = VkDisplayPresentInfoKHR.nsrcRect(adr, value)
inline var VkDisplayPresentInfoKHR.dstRect: VkRect2D
    get() = VkDisplayPresentInfoKHR.ndstRect(adr)
    set(value) = VkDisplayPresentInfoKHR.ndstRect(adr, value)
inline var VkDisplayPresentInfoKHR.persistent: Int
    get() = VkDisplayPresentInfoKHR.npersistent(adr)
    set(value) = VkDisplayPresentInfoKHR.npersistent(adr, value)


inline var VkImportMemoryFdInfoKHR.type: VkStructureType
    get() = VkStructureType(VkImportMemoryFdInfoKHR.nsType(adr))
    set(value) = VkImportMemoryFdInfoKHR.nsType(adr, value.i)
inline var VkImportMemoryFdInfoKHR.next: Ptr
    get() = VkImportMemoryFdInfoKHR.npNext(adr)
    set(value) = VkImportMemoryFdInfoKHR.npNext(adr, value)
inline var VkImportMemoryFdInfoKHR.handleType: VkExternalMemoryHandleType
    get() = VkExternalMemoryHandleType(VkImportMemoryFdInfoKHR.nhandleType(adr))
    set(value) = VkImportMemoryFdInfoKHR.nhandleType(adr, value.i)
inline var VkImportMemoryFdInfoKHR.fd: Int
    get() = VkImportMemoryFdInfoKHR.nfd(adr)
    set(value) = VkImportMemoryFdInfoKHR.nfd(adr, value)


inline var VkMemoryFdPropertiesKHR.type: VkStructureType
    get() = VkStructureType(VkMemoryFdPropertiesKHR.nsType(adr))
    set(value) = VkMemoryFdPropertiesKHR.nsType(adr, value.i)
inline var VkMemoryFdPropertiesKHR.next: Ptr
    get() = VkMemoryFdPropertiesKHR.npNext(adr)
    set(value) = VkMemoryFdPropertiesKHR.npNext(adr, value)
inline val VkMemoryFdPropertiesKHR.memoryTypeBits: Int
    get() = VkMemoryFdPropertiesKHR.nmemoryTypeBits(adr)


inline var VkMemoryGetFdInfoKHR.type: VkStructureType
    get() = VkStructureType(VkMemoryGetFdInfoKHR.nsType(adr))
    set(value) = VkMemoryGetFdInfoKHR.nsType(adr, value.i)
inline var VkMemoryGetFdInfoKHR.next: Ptr
    get() = VkMemoryGetFdInfoKHR.npNext(adr)
    set(value) = VkMemoryGetFdInfoKHR.npNext(adr, value)
inline var VkMemoryGetFdInfoKHR.memory: VkDeviceMemory
    get() = VkDeviceMemory(VkMemoryGetFdInfoKHR.nmemory(adr))
    set(value) = VkMemoryGetFdInfoKHR.nmemory(adr, value.L)
inline var VkMemoryGetFdInfoKHR.handleType: VkExternalMemoryHandleType
    get() = VkExternalMemoryHandleType(VkMemoryGetFdInfoKHR.nhandleType(adr))
    set(value) = VkMemoryGetFdInfoKHR.nhandleType(adr, value.i)


inline var VkImportSemaphoreFdInfoKHR.type: VkStructureType
    get() = VkStructureType(VkImportSemaphoreFdInfoKHR.nsType(adr))
    set(value) = VkImportSemaphoreFdInfoKHR.nsType(adr, value.i)
inline var VkImportSemaphoreFdInfoKHR.next: Ptr
    get() = VkImportSemaphoreFdInfoKHR.npNext(adr)
    set(value) = VkImportSemaphoreFdInfoKHR.npNext(adr, value)
inline var VkImportSemaphoreFdInfoKHR.semaphore: VkSemaphore
    get() = VkSemaphore(VkImportSemaphoreFdInfoKHR.nsemaphore(adr))
    set(value) = VkImportSemaphoreFdInfoKHR.nsemaphore(adr, value.L)
inline var VkImportSemaphoreFdInfoKHR.flags: VkSemaphoreImportFlags
    get() = VkImportSemaphoreFdInfoKHR.nflags(adr)
    set(value) = VkImportSemaphoreFdInfoKHR.nflags(adr, value.i)
inline var VkImportSemaphoreFdInfoKHR.handleType: VkExternalSemaphoreHandleType
    get() = VkExternalSemaphoreHandleType(VkImportSemaphoreFdInfoKHR.nhandleType(adr))
    set(value) = VkImportSemaphoreFdInfoKHR.nhandleType(adr, value.i)
inline var VkImportSemaphoreFdInfoKHR.fd: Int
    get() = VkImportSemaphoreFdInfoKHR.nfd(adr)
    set(value) = VkImportSemaphoreFdInfoKHR.nfd(adr, value)


inline var VkSemaphoreGetFdInfoKHR.type: VkStructureType
    get() = VkStructureType(VkSemaphoreGetFdInfoKHR.nsType(adr))
    set(value) = VkSemaphoreGetFdInfoKHR.nsType(adr, value.i)
inline var VkSemaphoreGetFdInfoKHR.next: Ptr
    get() = VkSemaphoreGetFdInfoKHR.npNext(adr)
    set(value) = VkSemaphoreGetFdInfoKHR.npNext(adr, value)
inline var VkSemaphoreGetFdInfoKHR.semaphore: VkSemaphore
    get() = VkSemaphore(VkSemaphoreGetFdInfoKHR.nsemaphore(adr))
    set(value) = VkSemaphoreGetFdInfoKHR.nsemaphore(adr, value.L)
inline var VkSemaphoreGetFdInfoKHR.handleType: VkExternalSemaphoreHandleType
    get() = VkExternalSemaphoreHandleType(VkSemaphoreGetFdInfoKHR.nhandleType(adr))
    set(value) = VkSemaphoreGetFdInfoKHR.nhandleType(adr, value.i)


inline var VkPhysicalDevicePushDescriptorPropertiesKHR.type: VkStructureType
    get() = VkStructureType(VkPhysicalDevicePushDescriptorPropertiesKHR.nsType(adr))
    set(value) = VkPhysicalDevicePushDescriptorPropertiesKHR.nsType(adr, value.i)
inline var VkPhysicalDevicePushDescriptorPropertiesKHR.next: Ptr
    get() = VkPhysicalDevicePushDescriptorPropertiesKHR.npNext(adr)
    set(value) = VkPhysicalDevicePushDescriptorPropertiesKHR.npNext(adr, value)
inline val VkPhysicalDevicePushDescriptorPropertiesKHR.maxPushDescriptors: Int
    get() = VkPhysicalDevicePushDescriptorPropertiesKHR.nmaxPushDescriptors(adr)


inline var VkPhysicalDeviceFloat16Int8FeaturesKHR.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceFloat16Int8FeaturesKHR.nsType(adr))
    set(value) = VkPhysicalDeviceFloat16Int8FeaturesKHR.nsType(adr, value.i)
inline var VkPhysicalDeviceFloat16Int8FeaturesKHR.next: Ptr
    get() = VkPhysicalDeviceFloat16Int8FeaturesKHR.npNext(adr)
    set(value) = VkPhysicalDeviceFloat16Int8FeaturesKHR.npNext(adr, value)
inline var VkPhysicalDeviceFloat16Int8FeaturesKHR.shaderFloat16: Boolean
    get() = VkPhysicalDeviceFloat16Int8FeaturesKHR.nshaderFloat16(adr).bool
    set(value) = VkPhysicalDeviceFloat16Int8FeaturesKHR.nshaderFloat16(adr, value.i)
inline var VkPhysicalDeviceFloat16Int8FeaturesKHR.shaderInt8: Boolean
    get() = VkPhysicalDeviceFloat16Int8FeaturesKHR.nshaderInt8(adr).bool
    set(value) = VkPhysicalDeviceFloat16Int8FeaturesKHR.nshaderInt8(adr, value.i)


inline var VkRectLayerKHR.offset: VkOffset2D
    get() = VkRectLayerKHR.noffset(adr)
    set(value) = VkRectLayerKHR.noffset(adr, value)
inline var VkRectLayerKHR.extent: VkExtent2D
    get() = VkRectLayerKHR.nextent(adr)
    set(value) = VkRectLayerKHR.nextent(adr, value)
inline var VkRectLayerKHR.layer: Int
    get() = VkRectLayerKHR.nlayer(adr)
    set(value) = VkRectLayerKHR.nlayer(adr, value)


@Deprecated("this will be set automatically")
inline var VkPresentRegionKHR.rectangleCount: Int
    get() = VkPresentRegionKHR.nrectangleCount(adr)
    set(value) = VkPresentRegionKHR.nrectangleCount(adr, value)
inline var VkPresentRegionKHR.rectangles: VkRectLayerKHR.Buffer?
    get() = VkPresentRegionKHR.npRectangles(adr)
    set(value) = VkPresentRegionKHR.npRectangles(adr, value)


inline var VkPresentRegionsKHR.type: VkStructureType
    get() = VkStructureType(VkPresentRegionsKHR.nsType(adr))
    set(value) = VkPresentRegionsKHR.nsType(adr, value.i)
inline var VkPresentRegionsKHR.next: Ptr
    get() = VkPresentRegionsKHR.npNext(adr)
    set(value) = VkPresentRegionsKHR.npNext(adr, value)
@Deprecated("this will be set automatically")
inline var VkPresentRegionsKHR.swapchainCount: Int
    get() = VkPresentRegionsKHR.nswapchainCount(adr)
    set(value) = VkPresentRegionsKHR.nswapchainCount(adr, value)
inline var VkPresentRegionsKHR.regions: VkPresentRegionKHR.Buffer?
    get() = VkPresentRegionsKHR.npRegions(adr)
    set(value) = VkPresentRegionsKHR.npRegions(adr, value)


inline var VkAttachmentDescription2KHR.type: VkStructureType
    get() = VkStructureType(VkAttachmentDescription2KHR.nsType(adr))
    set(value) = VkAttachmentDescription2KHR.nsType(adr, value.i)
inline var VkAttachmentDescription2KHR.next: Ptr
    get() = VkAttachmentDescription2KHR.npNext(adr)
    set(value) = VkAttachmentDescription2KHR.npNext(adr, value)
inline var VkAttachmentDescription2KHR.flags: VkAttachmentDescriptionFlags
    get() = VkAttachmentDescription2KHR.nflags(adr)
    set(value) = VkAttachmentDescription2KHR.nflags(adr, value)
inline var VkAttachmentDescription2KHR.format: VkFormat
    get() = VkFormat(VkAttachmentDescription2KHR.nformat(adr))
    set(value) = VkAttachmentDescription2KHR.nformat(adr, value.i)
inline var VkAttachmentDescription2KHR.samples: VkSampleCount
    get() = VkSampleCount(VkAttachmentDescription2KHR.nsamples(adr))
    set(value) = VkAttachmentDescription2KHR.nsamples(adr, value.i)
inline var VkAttachmentDescription2KHR.loadOp: VkAttachmentLoadOp
    get() = VkAttachmentLoadOp(VkAttachmentDescription2KHR.nloadOp(adr))
    set(value) = VkAttachmentDescription2KHR.nloadOp(adr, value.i)
inline var VkAttachmentDescription2KHR.storeOp: VkAttachmentStoreOp
    get() = VkAttachmentStoreOp(VkAttachmentDescription2KHR.nstoreOp(adr))
    set(value) = VkAttachmentDescription2KHR.nstoreOp(adr, value.i)
inline var VkAttachmentDescription2KHR.stencilLoadOp: VkAttachmentLoadOp
    get() = VkAttachmentLoadOp(VkAttachmentDescription2KHR.nstencilLoadOp(adr))
    set(value) = VkAttachmentDescription2KHR.nstencilLoadOp(adr, value.i)
inline var VkAttachmentDescription2KHR.stencilStoreOp: VkAttachmentStoreOp
    get() = VkAttachmentStoreOp(VkAttachmentDescription2KHR.nstencilStoreOp(adr))
    set(value) = VkAttachmentDescription2KHR.nstencilStoreOp(adr, value.i)
inline var VkAttachmentDescription2KHR.initialLayout: VkImageLayout
    get() = VkImageLayout(VkAttachmentDescription2KHR.ninitialLayout(adr))
    set(value) = VkAttachmentDescription2KHR.ninitialLayout(adr, value.i)
inline var VkAttachmentDescription2KHR.finalLayout: VkImageLayout
    get() = VkImageLayout(VkAttachmentDescription2KHR.nfinalLayout(adr))
    set(value) = VkAttachmentDescription2KHR.nfinalLayout(adr, value.i)


inline var VkAttachmentReference2KHR.type: VkStructureType
    get() = VkStructureType(VkAttachmentReference2KHR.nsType(adr))
    set(value) = VkAttachmentReference2KHR.nsType(adr, value.i)
inline var VkAttachmentReference2KHR.next: Ptr
    get() = VkAttachmentReference2KHR.npNext(adr)
    set(value) = VkAttachmentReference2KHR.npNext(adr, value)
inline var VkAttachmentReference2KHR.attachment: Int
    get() = VkAttachmentReference2KHR.nattachment(adr)
    set(value) = VkAttachmentReference2KHR.nattachment(adr, value)
inline var VkAttachmentReference2KHR.layout: VkImageLayout
    get() = VkImageLayout(VkAttachmentReference2KHR.nlayout(adr))
    set(value) = VkAttachmentReference2KHR.nlayout(adr, value.i)
inline var VkAttachmentReference2KHR.aspectMask: VkImageAspectFlags
    get() = VkAttachmentReference2KHR.naspectMask(adr)
    set(value) = VkAttachmentReference2KHR.naspectMask(adr, value)


inline var VkSubpassDescription2KHR.type: VkStructureType
    get() = VkStructureType(VkSubpassDescription2KHR.nsType(adr))
    set(value) = VkSubpassDescription2KHR.nsType(adr, value.i)
inline var VkSubpassDescription2KHR.next: Ptr
    get() = VkSubpassDescription2KHR.npNext(adr)
    set(value) = VkSubpassDescription2KHR.npNext(adr, value)
inline var VkSubpassDescription2KHR.flags: VkSubpassDescriptionFlags
    get() = VkSubpassDescription2KHR.nflags(adr)
    set(value) = VkSubpassDescription2KHR.nflags(adr, value)
inline var VkSubpassDescription2KHR.pipelineBindPoint: VkPipelineBindPoint
    get() = VkPipelineBindPoint(VkSubpassDescription2KHR.npipelineBindPoint(adr))
    set(value) = VkSubpassDescription2KHR.npipelineBindPoint(adr, value.i)
inline var VkSubpassDescription2KHR.viewMask: Int
    get() = VkSubpassDescription2KHR.nviewMask(adr)
    set(value) = VkSubpassDescription2KHR.nviewMask(adr, value)
@Deprecated("this will be set automatically")
inline var VkSubpassDescription2KHR.inputAttachmentCount: Int
    get() = VkSubpassDescription2KHR.ninputAttachmentCount(adr)
    set(value) = VkSubpassDescription2KHR.ninputAttachmentCount(adr, value)
inline var VkSubpassDescription2KHR.inputAttachments: VkAttachmentReference2KHR.Buffer?
    get() = VkSubpassDescription2KHR.npInputAttachments(adr)
    set(value) = VkSubpassDescription2KHR.npInputAttachments(adr, value)
inline var VkSubpassDescription2KHR.colorAttachmentCount: Int
    get() = VkSubpassDescription2KHR.ncolorAttachmentCount(adr)
    set(value) = VkSubpassDescription2KHR.ncolorAttachmentCount(adr, value)
inline var VkSubpassDescription2KHR.colorAttachments: VkAttachmentReference2KHR.Buffer?
    get() = VkSubpassDescription2KHR.npColorAttachments(adr)
    set(value) = VkSubpassDescription2KHR.npColorAttachments(adr, value)
inline var VkSubpassDescription2KHR.resolveAttachments: VkAttachmentReference2KHR.Buffer?
    get() = VkSubpassDescription2KHR.npResolveAttachments(adr)
    set(value) = VkSubpassDescription2KHR.npResolveAttachments(adr, value)
inline var VkSubpassDescription2KHR.depthStencilAttachment: VkAttachmentReference2KHR?
    get() = VkSubpassDescription2KHR.npDepthStencilAttachment(adr)
    set(value) = VkSubpassDescription2KHR.npDepthStencilAttachment(adr, value)
@Deprecated("this will be set automatically")
inline var VkSubpassDescription2KHR.preserveAttachmentCount: Int
    get() = VkSubpassDescription2KHR.npreserveAttachmentCount(adr)
    set(value) = VkSubpassDescription2KHR.npreserveAttachmentCount(adr, value)
inline var VkSubpassDescription2KHR.preserveAttachments: IntBuffer?
    get() = VkSubpassDescription2KHR.npPreserveAttachments(adr)
    set(value) = VkSubpassDescription2KHR.npPreserveAttachments(adr, value)


inline var VkSubpassDependency2KHR.type: VkStructureType
    get() = VkStructureType(VkSubpassDependency2KHR.nsType(adr))
    set(value) = VkSubpassDependency2KHR.nsType(adr, value.i)
inline var VkSubpassDependency2KHR.next: Ptr
    get() = VkSubpassDependency2KHR.npNext(adr)
    set(value) = VkSubpassDependency2KHR.npNext(adr, value)
inline var VkSubpassDependency2KHR.srcSubpass: Int
    get() = VkSubpassDependency2KHR.nsrcSubpass(adr)
    set(value) = VkSubpassDependency2KHR.nsrcSubpass(adr, value)
inline var VkSubpassDependency2KHR.dstSubpass: Int
    get() = VkSubpassDependency2KHR.ndstSubpass(adr)
    set(value) = VkSubpassDependency2KHR.ndstSubpass(adr, value)
inline var VkSubpassDependency2KHR.srcStageMask: VkPipelineStageFlags
    get() = VkSubpassDependency2KHR.nsrcStageMask(adr)
    set(value) = VkSubpassDependency2KHR.nsrcStageMask(adr, value)
inline var VkSubpassDependency2KHR.dstStageMask: VkPipelineStageFlags
    get() = VkSubpassDependency2KHR.ndstStageMask(adr)
    set(value) = VkSubpassDependency2KHR.ndstStageMask(adr, value)
inline var VkSubpassDependency2KHR.srcAccessMask: VkAccessFlags
    get() = VkSubpassDependency2KHR.nsrcAccessMask(adr)
    set(value) = VkSubpassDependency2KHR.nsrcAccessMask(adr, value)
inline var VkSubpassDependency2KHR.dstAccessMask: VkAccessFlags
    get() = VkSubpassDependency2KHR.ndstAccessMask(adr)
    set(value) = VkSubpassDependency2KHR.ndstAccessMask(adr, value)
inline var VkSubpassDependency2KHR.dependencyFlags: VkDependencyFlags
    get() = VkSubpassDependency2KHR.ndependencyFlags(adr)
    set(value) = VkSubpassDependency2KHR.ndependencyFlags(adr, value)
inline var VkSubpassDependency2KHR.viewOffset: Int
    get() = VkSubpassDependency2KHR.nviewOffset(adr)
    set(value) = VkSubpassDependency2KHR.nviewOffset(adr, value)


inline var VkRenderPassCreateInfo2KHR.type: VkStructureType
    get() = VkStructureType(VkRenderPassCreateInfo2KHR.nsType(adr))
    set(value) = VkRenderPassCreateInfo2KHR.nsType(adr, value.i)
inline var VkRenderPassCreateInfo2KHR.next: Ptr
    get() = VkRenderPassCreateInfo2KHR.npNext(adr)
    set(value) = VkRenderPassCreateInfo2KHR.npNext(adr, value)
inline var VkRenderPassCreateInfo2KHR.flags: VkRenderPassCreateFlags
    get() = VkRenderPassCreateInfo2KHR.nflags(adr)
    set(value) = VkRenderPassCreateInfo2KHR.nflags(adr, value)
@Deprecated("this will be set automatically")
inline var VkRenderPassCreateInfo2KHR.attachmentCount: Int
    get() = VkRenderPassCreateInfo2KHR.nattachmentCount(adr)
    set(value) = VkRenderPassCreateInfo2KHR.nattachmentCount(adr, value)
inline var VkRenderPassCreateInfo2KHR.attachments: VkAttachmentDescription2KHR.Buffer?
    get() = VkRenderPassCreateInfo2KHR.npAttachments(adr)
    set(value) = VkRenderPassCreateInfo2KHR.npAttachments(adr, value)
@Deprecated("this will be set automatically")
inline var VkRenderPassCreateInfo2KHR.subpassCount: Int
    get() = VkRenderPassCreateInfo2KHR.nsubpassCount(adr)
    set(value) = VkRenderPassCreateInfo2KHR.nsubpassCount(adr, value)
inline var VkRenderPassCreateInfo2KHR.subpasses: VkSubpassDescription2KHR.Buffer
    get() = VkRenderPassCreateInfo2KHR.npSubpasses(adr)
    set(value) = VkRenderPassCreateInfo2KHR.npSubpasses(adr, value)
@Deprecated("this will be set automatically")
inline var VkRenderPassCreateInfo2KHR.dependencyCount: VkAccessFlags
    get() = VkRenderPassCreateInfo2KHR.ndependencyCount(adr)
    set(value) = VkRenderPassCreateInfo2KHR.ndependencyCount(adr, value)
inline var VkRenderPassCreateInfo2KHR.dependencies: VkSubpassDependency2KHR.Buffer?
    get() = VkRenderPassCreateInfo2KHR.npDependencies(adr)
    set(value) = VkRenderPassCreateInfo2KHR.npDependencies(adr, value)
@Deprecated("this will be set automatically")
inline var VkRenderPassCreateInfo2KHR.correlatedViewMaskCount: Int
    get() = VkRenderPassCreateInfo2KHR.ncorrelatedViewMaskCount(adr)
    set(value) = VkRenderPassCreateInfo2KHR.ncorrelatedViewMaskCount(adr, value)
inline var VkRenderPassCreateInfo2KHR.correlatedViewMasks: IntBuffer?
    get() = VkRenderPassCreateInfo2KHR.npCorrelatedViewMasks(adr)
    set(value) = VkRenderPassCreateInfo2KHR.npCorrelatedViewMasks(adr, value)


inline var VkSubpassBeginInfoKHR.type: VkStructureType
    get() = VkStructureType(VkSubpassBeginInfoKHR.nsType(adr))
    set(value) = VkSubpassBeginInfoKHR.nsType(adr, value.i)
inline var VkSubpassBeginInfoKHR.next: Ptr
    get() = VkSubpassBeginInfoKHR.npNext(adr)
    set(value) = VkSubpassBeginInfoKHR.npNext(adr, value)
inline var VkSubpassBeginInfoKHR.contents: VkSubpassContents
    get() = VkSubpassContents(VkSubpassBeginInfoKHR.ncontents(adr))
    set(value) = VkSubpassBeginInfoKHR.ncontents(adr, value.i)


inline var VkSubpassEndInfoKHR.type: VkStructureType
    get() = VkStructureType(VkSubpassEndInfoKHR.nsType(adr))
    set(value) = VkSubpassEndInfoKHR.nsType(adr, value.i)
inline var VkSubpassEndInfoKHR.next: Ptr
    get() = VkSubpassEndInfoKHR.npNext(adr)
    set(value) = VkSubpassEndInfoKHR.npNext(adr, value)


inline var VkSharedPresentSurfaceCapabilitiesKHR.type: VkStructureType
    get() = VkStructureType(VkSharedPresentSurfaceCapabilitiesKHR.nsType(adr))
    set(value) = VkSharedPresentSurfaceCapabilitiesKHR.nsType(adr, value.i)
inline var VkSharedPresentSurfaceCapabilitiesKHR.next: Ptr
    get() = VkSharedPresentSurfaceCapabilitiesKHR.npNext(adr)
    set(value) = VkSharedPresentSurfaceCapabilitiesKHR.npNext(adr, value)
inline val VkSharedPresentSurfaceCapabilitiesKHR.sharedPresentSupportedUsageFlags: Int
    get() = VkSharedPresentSurfaceCapabilitiesKHR.nsharedPresentSupportedUsageFlags(adr)


inline var VkImportFenceFdInfoKHR.type: VkStructureType
    get() = VkStructureType(VkFenceGetFdInfoKHR.nsType(adr))
    set(value) = VkImportFenceFdInfoKHR.nsType(adr, value.i)
inline var VkImportFenceFdInfoKHR.next: Ptr
    get() = VkImportFenceFdInfoKHR.npNext(adr)
    set(value) = VkImportFenceFdInfoKHR.npNext(adr, value)
inline var VkImportFenceFdInfoKHR.fence: VkFence
    get() = VkFence(VkImportFenceFdInfoKHR.nfence(adr))
    set(value) = VkImportFenceFdInfoKHR.nfence(adr, value.L)
inline var VkImportFenceFdInfoKHR.flags: VkFenceImportFlags
    get() = VkImportFenceFdInfoKHR.nflags(adr)
    set(value) = VkImportFenceFdInfoKHR.nflags(adr, value)
inline var VkImportFenceFdInfoKHR.handleType: VkExternalFenceHandleType
    get() = VkExternalFenceHandleType(VkImportFenceFdInfoKHR.nhandleType(adr))
    set(value) = VkImportFenceFdInfoKHR.nhandleType(adr, value.i)
inline var VkImportFenceFdInfoKHR.fd: Int
    get() = VkImportFenceFdInfoKHR.nfd(adr)
    set(value) = VkImportFenceFdInfoKHR.nfd(adr, value)


inline var VkFenceGetFdInfoKHR.type: VkStructureType
    get() = VkStructureType(VkFenceGetFdInfoKHR.nsType(adr))
    set(value) = VkFenceGetFdInfoKHR.nsType(adr, value.i)
inline var VkFenceGetFdInfoKHR.next: Ptr
    get() = VkFenceGetFdInfoKHR.npNext(adr)
    set(value) = VkFenceGetFdInfoKHR.npNext(adr, value)
inline var VkFenceGetFdInfoKHR.fence: VkFence
    get() = VkFence(VkFenceGetFdInfoKHR.nfence(adr))
    set(value) = VkFenceGetFdInfoKHR.nfence(adr, value.L)
inline var VkFenceGetFdInfoKHR.handleType: VkExternalFenceHandleType
    get() = VkExternalFenceHandleType(VkFenceGetFdInfoKHR.nhandleType(adr))
    set(value) = VkFenceGetFdInfoKHR.nhandleType(adr, value.i)


inline var VkPhysicalDeviceSurfaceInfo2KHR.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceSurfaceInfo2KHR.nsType(adr))
    set(value) = VkPhysicalDeviceSurfaceInfo2KHR.nsType(adr, value.i)
inline var VkPhysicalDeviceSurfaceInfo2KHR.next: Ptr
    get() = VkPhysicalDeviceSurfaceInfo2KHR.npNext(adr)
    set(value) = VkPhysicalDeviceSurfaceInfo2KHR.npNext(adr, value)
inline var VkPhysicalDeviceSurfaceInfo2KHR.surface: VkSurfaceKHR
    get() = VkSurfaceKHR(VkPhysicalDeviceSurfaceInfo2KHR.nsurface(adr))
    set(value) = VkPhysicalDeviceSurfaceInfo2KHR.nsurface(adr, value.L)


inline var VkSurfaceCapabilities2KHR.type: VkStructureType
    get() = VkStructureType(VkSurfaceCapabilities2KHR.nsType(adr))
    set(value) = VkSurfaceCapabilities2KHR.nsType(adr, value.i)
inline var VkSurfaceCapabilities2KHR.next: Ptr
    get() = VkSurfaceCapabilities2KHR.npNext(adr)
    set(value) = VkSurfaceCapabilities2KHR.npNext(adr, value)
inline val VkSurfaceCapabilities2KHR.surfaceCapabilities: VkSurfaceCapabilitiesKHR
    get() = VkSurfaceCapabilities2KHR.nsurfaceCapabilities(adr)


inline var VkSurfaceFormat2KHR.type: VkStructureType
    get() = VkStructureType(VkSurfaceFormat2KHR.nsType(adr))
    set(value) = VkSurfaceFormat2KHR.nsType(adr, value.i)
inline var VkSurfaceFormat2KHR.next: Ptr
    get() = VkSurfaceFormat2KHR.npNext(adr)
    set(value) = VkSurfaceFormat2KHR.npNext(adr, value)
inline val VkSurfaceFormat2KHR.surfaceFormat: VkSurfaceFormatKHR
    get() = VkSurfaceFormat2KHR.nsurfaceFormat(adr)


inline var VkDisplayProperties2KHR.type: VkStructureType
    get() = VkStructureType(VkDisplayProperties2KHR.nsType(adr))
    set(value) = VkDisplayProperties2KHR.nsType(adr, value.i)
inline var VkDisplayProperties2KHR.next: Ptr
    get() = VkDisplayProperties2KHR.npNext(adr)
    set(value) = VkDisplayProperties2KHR.npNext(adr, value)
inline val VkDisplayProperties2KHR.displayProperties: VkDisplayPropertiesKHR
    get() = VkDisplayProperties2KHR.ndisplayProperties(adr)


inline var VkDisplayPlaneProperties2KHR.type: VkStructureType
    get() = VkStructureType(VkDisplayPlaneProperties2KHR.nsType(adr))
    set(value) = VkDisplayPlaneProperties2KHR.nsType(adr, value.i)
inline var VkDisplayPlaneProperties2KHR.next: Ptr
    get() = VkDisplayPlaneProperties2KHR.npNext(adr)
    set(value) = VkDisplayPlaneProperties2KHR.npNext(adr, value)
inline val VkDisplayPlaneProperties2KHR.displayPlaneProperties: VkDisplayPlanePropertiesKHR
    get() = VkDisplayPlaneProperties2KHR.ndisplayPlaneProperties(adr)


inline var VkDisplayModeProperties2KHR.type: VkStructureType
    get() = VkStructureType(VkDisplayModeProperties2KHR.nsType(adr))
    set(value) = VkDisplayModeProperties2KHR.nsType(adr, value.i)
inline var VkDisplayModeProperties2KHR.next: Ptr
    get() = VkDisplayModeProperties2KHR.npNext(adr)
    set(value) = VkDisplayModeProperties2KHR.npNext(adr, value)
inline val VkDisplayModeProperties2KHR.displayModeProperties: VkDisplayModePropertiesKHR
    get() = VkDisplayModeProperties2KHR.ndisplayModeProperties(adr)


inline var VkDisplayPlaneInfo2KHR.type: VkStructureType
    get() = VkStructureType(VkDisplayPlaneInfo2KHR.nsType(adr))
    set(value) = VkDisplayPlaneInfo2KHR.nsType(adr, value.i)
inline var VkDisplayPlaneInfo2KHR.next: Ptr
    get() = VkDisplayPlaneInfo2KHR.npNext(adr)
    set(value) = VkDisplayPlaneInfo2KHR.npNext(adr, value)
inline var VkDisplayPlaneInfo2KHR.mode: VkDisplayModeKHR
    get() = VkDisplayModeKHR(VkDisplayPlaneInfo2KHR.nmode(adr))
    set(value) = VkDisplayPlaneInfo2KHR.nmode(adr, value.L)
inline var VkDisplayPlaneInfo2KHR.planeIndex: Int
    get() = VkDisplayPlaneInfo2KHR.nplaneIndex(adr)
    set(value) = VkDisplayPlaneInfo2KHR.nplaneIndex(adr, value)


inline var VkDisplayPlaneCapabilities2KHR.type: VkStructureType
    get() = VkStructureType(VkDisplayPlaneCapabilities2KHR.nsType(adr))
    set(value) = VkDisplayPlaneCapabilities2KHR.nsType(adr, value.i)
inline var VkDisplayPlaneCapabilities2KHR.next: Ptr
    get() = VkDisplayPlaneCapabilities2KHR.npNext(adr)
    set(value) = VkDisplayPlaneCapabilities2KHR.npNext(adr, value)
inline val VkDisplayPlaneCapabilities2KHR.capabilities: VkDisplayPlaneCapabilitiesKHR
    get() = VkDisplayPlaneCapabilities2KHR.ncapabilities(adr)


inline var VkImageFormatListCreateInfoKHR.type: VkStructureType
    get() = VkStructureType(VkImageFormatListCreateInfoKHR.nsType(adr))
    set(value) = VkImageFormatListCreateInfoKHR.nsType(adr, value.i)
inline var VkImageFormatListCreateInfoKHR.next: Ptr
    get() = VkImageFormatListCreateInfoKHR.npNext(adr)
    set(value) = VkImageFormatListCreateInfoKHR.npNext(adr, value)
@Deprecated("this will be set automatically")
inline var VkImageFormatListCreateInfoKHR.viewFormatCount: Int
    get() = VkImageFormatListCreateInfoKHR.nviewFormatCount(adr)
    set(value) = VkImageFormatListCreateInfoKHR.nviewFormatCount(adr, value)
inline var VkImageFormatListCreateInfoKHR.viewFormats: IntBuffer?
    get() = VkImageFormatListCreateInfoKHR.npViewFormats(adr)
    set(value) = VkImageFormatListCreateInfoKHR.npViewFormats(adr, value)


inline var VkPhysicalDevice8BitStorageFeaturesKHR.type: VkStructureType
    get() = VkStructureType(VkPhysicalDevice8BitStorageFeaturesKHR.nsType(adr))
    set(value) = VkPhysicalDevice8BitStorageFeaturesKHR.nsType(adr, value.i)
inline var VkPhysicalDevice8BitStorageFeaturesKHR.next: Ptr
    get() = VkPhysicalDevice8BitStorageFeaturesKHR.npNext(adr)
    set(value) = VkPhysicalDevice8BitStorageFeaturesKHR.npNext(adr, value)
inline var VkPhysicalDevice8BitStorageFeaturesKHR.storageBuffer8BitAccess: Boolean
    get() = VkPhysicalDevice8BitStorageFeaturesKHR.nstorageBuffer8BitAccess(adr).bool
    set(value) = VkPhysicalDevice8BitStorageFeaturesKHR.nstorageBuffer8BitAccess(adr, value.i)
inline var VkPhysicalDevice8BitStorageFeaturesKHR.uniformAndStorageBuffer8BitAccess: Boolean
    get() = VkPhysicalDevice8BitStorageFeaturesKHR.nuniformAndStorageBuffer8BitAccess(adr).bool
    set(value) = VkPhysicalDevice8BitStorageFeaturesKHR.nuniformAndStorageBuffer8BitAccess(adr, value.i)
inline var VkPhysicalDevice8BitStorageFeaturesKHR.storagePushConstant8: Boolean
    get() = VkPhysicalDevice8BitStorageFeaturesKHR.nstoragePushConstant8(adr).bool
    set(value) = VkPhysicalDevice8BitStorageFeaturesKHR.nstoragePushConstant8(adr, value.i)


inline var VkPhysicalDeviceShaderAtomicInt64FeaturesKHR.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceShaderAtomicInt64FeaturesKHR.nsType(adr))
    set(value) = VkPhysicalDeviceShaderAtomicInt64FeaturesKHR.nsType(adr, value.i)
inline var VkPhysicalDeviceShaderAtomicInt64FeaturesKHR.next: Ptr
    get() = VkPhysicalDeviceShaderAtomicInt64FeaturesKHR.npNext(adr)
    set(value) = VkPhysicalDeviceShaderAtomicInt64FeaturesKHR.npNext(adr, value)
inline var VkPhysicalDeviceShaderAtomicInt64FeaturesKHR.shaderBufferInt64Atomics: Boolean
    get() = VkPhysicalDeviceShaderAtomicInt64FeaturesKHR.nshaderBufferInt64Atomics(adr).bool
    set(value) = VkPhysicalDeviceShaderAtomicInt64FeaturesKHR.nshaderBufferInt64Atomics(adr, value.i)
inline var VkPhysicalDeviceShaderAtomicInt64FeaturesKHR.shaderSharedInt64Atomics: Boolean
    get() = VkPhysicalDeviceShaderAtomicInt64FeaturesKHR.nshaderSharedInt64Atomics(adr).bool
    set(value) = VkPhysicalDeviceShaderAtomicInt64FeaturesKHR.nshaderSharedInt64Atomics(adr, value.i)


inline class VkDriverIdKHR(val i: Int) {
    companion object {
        val AMD_PROPRIETARY_KHR = VkDriverIdKHR(1)
        val AMD_OPEN_SOURCE_KHR = VkDriverIdKHR(2)
        val MESA_RADV_KHR = VkDriverIdKHR(3)
        val NVIDIA_PROPRIETARY_KHR = VkDriverIdKHR(4)
        val INTEL_PROPRIETARY_WINDOWS_KHR = VkDriverIdKHR(5)
        val INTEL_OPEN_SOURCE_MESA_KHR = VkDriverIdKHR(6)
        val IMAGINATION_PROPRIETARY_KHR = VkDriverIdKHR(7)
        val QUALCOMM_PROPRIETARY_KHR = VkDriverIdKHR(8)
        val ARM_PROPRIETARY_KHR = VkDriverIdKHR(9)
        val GOOGLE_PASTEL_KHR = VkDriverIdKHR(10)
        val GGP_PROPRIETARY_KHR = VkDriverIdKHR(11)
    }
}


inline var VkConformanceVersionKHR.major: Int
    get() = VkConformanceVersionKHR.nmajor(adr).i
    set(value) = VkConformanceVersionKHR.nmajor(adr, value.b)
inline var VkConformanceVersionKHR.minor: Int
    get() = VkConformanceVersionKHR.nminor(adr).i
    set(value) = VkConformanceVersionKHR.nminor(adr, value.b)
inline var VkConformanceVersionKHR.subminor: Int
    get() = VkConformanceVersionKHR.nsubminor(adr).i
    set(value) = VkConformanceVersionKHR.nsubminor(adr, value.b)
inline var VkConformanceVersionKHR.patch: Int
    get() = VkConformanceVersionKHR.npatch(adr).i
    set(value) = VkConformanceVersionKHR.npatch(adr, value.b)


inline var VkPhysicalDeviceDriverPropertiesKHR.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceDriverPropertiesKHR.nsType(adr))
    set(value) = VkPhysicalDeviceDriverPropertiesKHR.nsType(adr, value.i)
inline var VkPhysicalDeviceDriverPropertiesKHR.next: Ptr
    get() = VkPhysicalDeviceDriverPropertiesKHR.npNext(adr)
    set(value) = VkPhysicalDeviceDriverPropertiesKHR.npNext(adr, value)
inline val VkPhysicalDeviceDriverPropertiesKHR.driverID: VkDriverIdKHR
    get() = VkDriverIdKHR(VkPhysicalDeviceDriverPropertiesKHR.ndriverID(adr))
inline val VkPhysicalDeviceDriverPropertiesKHR.driverName: String
    get() = VkPhysicalDeviceDriverPropertiesKHR.ndriverNameString(adr)
inline val VkPhysicalDeviceDriverPropertiesKHR.driverInfo: ByteBuffer
    get() = VkPhysicalDeviceDriverPropertiesKHR.ndriverInfo(adr)
inline val VkPhysicalDeviceDriverPropertiesKHR.conformanceVersion: VkConformanceVersionKHR
    get() = VkPhysicalDeviceDriverPropertiesKHR.nconformanceVersion(adr)


inline var VkPhysicalDeviceFloatControlsPropertiesKHR.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceFloatControlsPropertiesKHR.nsType(adr))
    set(value) = VkPhysicalDeviceFloatControlsPropertiesKHR.nsType(adr, value.i)
inline var VkPhysicalDeviceFloatControlsPropertiesKHR.next: Ptr
    get() = VkPhysicalDeviceFloatControlsPropertiesKHR.npNext(adr)
    set(value) = VkPhysicalDeviceFloatControlsPropertiesKHR.npNext(adr, value)
inline val VkPhysicalDeviceFloatControlsPropertiesKHR.separateDenormSettings: Boolean
    get() = VkPhysicalDeviceFloatControlsPropertiesKHR.nseparateDenormSettings(adr).bool
inline val VkPhysicalDeviceFloatControlsPropertiesKHR.separateRoundingModeSettings: Boolean
    get() = VkPhysicalDeviceFloatControlsPropertiesKHR.nseparateRoundingModeSettings(adr).bool
inline val VkPhysicalDeviceFloatControlsPropertiesKHR.shaderSignedZeroInfNanPreserveFloat16: Boolean
    get() = VkPhysicalDeviceFloatControlsPropertiesKHR.nshaderSignedZeroInfNanPreserveFloat16(adr).bool
inline val VkPhysicalDeviceFloatControlsPropertiesKHR.shaderSignedZeroInfNanPreserveFloat32: Boolean
    get() = VkPhysicalDeviceFloatControlsPropertiesKHR.nshaderSignedZeroInfNanPreserveFloat32(adr).bool
inline val VkPhysicalDeviceFloatControlsPropertiesKHR.shaderSignedZeroInfNanPreserveFloat64: Boolean
    get() = VkPhysicalDeviceFloatControlsPropertiesKHR.nshaderSignedZeroInfNanPreserveFloat64(adr).bool
inline val VkPhysicalDeviceFloatControlsPropertiesKHR.shaderDenormPreserveFloat16: Boolean
    get() = VkPhysicalDeviceFloatControlsPropertiesKHR.nshaderDenormPreserveFloat16(adr).bool
inline val VkPhysicalDeviceFloatControlsPropertiesKHR.shaderDenormPreserveFloat32: Boolean
    get() = VkPhysicalDeviceFloatControlsPropertiesKHR.nshaderDenormPreserveFloat32(adr).bool
inline val VkPhysicalDeviceFloatControlsPropertiesKHR.shaderDenormPreserveFloat64: Boolean
    get() = VkPhysicalDeviceFloatControlsPropertiesKHR.nshaderDenormPreserveFloat64(adr).bool
inline val VkPhysicalDeviceFloatControlsPropertiesKHR.shaderDenormFlushToZeroFloat16: Boolean
    get() = VkPhysicalDeviceFloatControlsPropertiesKHR.nshaderDenormFlushToZeroFloat16(adr).bool
inline val VkPhysicalDeviceFloatControlsPropertiesKHR.shaderDenormFlushToZeroFloat32: Boolean
    get() = VkPhysicalDeviceFloatControlsPropertiesKHR.nshaderDenormFlushToZeroFloat32(adr).bool
inline val VkPhysicalDeviceFloatControlsPropertiesKHR.shaderDenormFlushToZeroFloat64: Boolean
    get() = VkPhysicalDeviceFloatControlsPropertiesKHR.nshaderDenormFlushToZeroFloat64(adr).bool
inline val VkPhysicalDeviceFloatControlsPropertiesKHR.shaderRoundingModeRTEFloat16: Boolean
    get() = VkPhysicalDeviceFloatControlsPropertiesKHR.nshaderRoundingModeRTEFloat16(adr).bool
inline val VkPhysicalDeviceFloatControlsPropertiesKHR.shaderRoundingModeRTEFloat32: Boolean
    get() = VkPhysicalDeviceFloatControlsPropertiesKHR.nshaderRoundingModeRTEFloat32(adr).bool
inline val VkPhysicalDeviceFloatControlsPropertiesKHR.shaderRoundingModeRTEFloat64: Boolean
    get() = VkPhysicalDeviceFloatControlsPropertiesKHR.nshaderRoundingModeRTEFloat64(adr).bool
inline val VkPhysicalDeviceFloatControlsPropertiesKHR.shaderRoundingModeRTZFloat16: Boolean
    get() = VkPhysicalDeviceFloatControlsPropertiesKHR.nshaderRoundingModeRTZFloat16(adr).bool
inline val VkPhysicalDeviceFloatControlsPropertiesKHR.shaderRoundingModeRTZFloat32: Boolean
    get() = VkPhysicalDeviceFloatControlsPropertiesKHR.nshaderRoundingModeRTZFloat32(adr).bool
inline val VkPhysicalDeviceFloatControlsPropertiesKHR.shaderRoundingModeRTZFloat64: Boolean
    get() = VkPhysicalDeviceFloatControlsPropertiesKHR.nshaderRoundingModeRTZFloat64(adr).bool