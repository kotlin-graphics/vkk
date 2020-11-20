package vkk.extensions

import glm_.i
import kool.*
import org.lwjgl.system.JNI.*
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.system.MemoryUtil.memPutAddress
import org.lwjgl.vulkan.*
import org.lwjgl.vulkan.VK11.VK_MAX_DEVICE_GROUP_SIZE
import vkk.*
import vkk.entities.*
import vkk.identifiers.Device
import vkk.identifiers.PhysicalDevice
import vkk.identifiers.Queue
import vkk.vk10.structs.Extent2D
import vkk.vk10.structs.Rect2D

//#define VK_KHR_SWAPCHAIN_SPEC_VERSION     70

inline class VkSwapchainCreateKHR(val i: VkSwapchainCreateFlagsKHR) {
    companion object {
        val SPLIT_INSTANCE_BIND_REGIONS_BIT_KHR = (0x00000001)
        val PROTECTED_BIT_KHR = (0x00000002)
        val MUTABLE_FORMAT_BIT_KHR = (0x00000004)
    }
}

typealias VkSwapchainCreateFlagsKHR = VkFlags

inline class VkDeviceGroupPresentModeKHR(val i: VkDeviceGroupPresentModeFlagsKHR) {
    companion object {
        val LOCAL_BIT_KHR = (0x00000001)
        val REMOTE_BIT_KHR = (0x00000002)
        val SUM_BIT_KHR = (0x00000004)
        val LOCAL_MULTI_DEVICE_BIT_KHR = (0x00000008)
    }
}

typealias VkDeviceGroupPresentModeFlagsKHR = VkFlags

class SwapchainCreateInfoKHR(
        var flags: VkSwapchainCreateFlagsKHR = 0,
        var surface: VkSurfaceKHR,
        var minImageCount: Int,
        var imageFormat: VkFormat,
        var imageColorSpace: VkColorSpaceKHR,
        var imageExtent: Extent2D = Extent2D(0, 0),
        var imageArrayLayers: Int,
        var imageUsage: VkImageUsageFlags,
        var imageSharingMode: VkSharingMode,
        var queueFamilyIndices: IntArray? = null,
        var preTransform: VkSurfaceTransformKHR,
        var compositeAlpha: VkCompositeAlphaKHR,
        var presentMode: VkPresentModeKHR,
        var clipped: Boolean,
        var oldSwapchain: VkSwapchainKHR = VkSwapchainKHR.NULL,
        var next: Ptr = NULL) {

    /** surfaceFormat variant */
    constructor(flags: VkSwapchainCreateFlagsKHR = 0,
                surface: VkSurfaceKHR,
                minImageCount: Int,
                surfaceFormat: SurfaceFormatKHR,
                imageExtent: Extent2D = Extent2D(0, 0),
                imageArrayLayers: Int,
                imageUsage: VkImageUsageFlags,
                imageSharingMode: VkSharingMode,
                queueFamilyIndices: IntArray? = null,
                preTransform: VkSurfaceTransformKHR,
                compositeAlpha: VkCompositeAlphaKHR,
                presentMode: VkPresentModeKHR,
                clipped: Boolean,
                oldSwapchain: VkSwapchainKHR = VkSwapchainKHR.NULL,
                next: Ptr = NULL) :
            this(flags, surface, minImageCount, surfaceFormat.format, surfaceFormat.colorSpace, imageExtent,
                    imageArrayLayers, imageUsage, imageSharingMode, queueFamilyIndices, preTransform, compositeAlpha,
                    presentMode, clipped)

    val type get() = VkStructureType.SWAPCHAIN_CREATE_INFO_KHR

    infix fun write(stack: MemoryStack): Adr {
        val adr = stack.ncalloc(VkSwapchainCreateInfoKHR.ALIGNOF, 1, VkSwapchainCreateInfoKHR.SIZEOF)
        VkSwapchainCreateInfoKHR.nsType(adr, type.i)
        VkSwapchainCreateInfoKHR.npNext(adr, next)
        VkSwapchainCreateInfoKHR.nflags(adr, flags)
        VkSwapchainCreateInfoKHR.nsurface(adr, surface.L)
        VkSwapchainCreateInfoKHR.nminImageCount(adr, minImageCount)
        VkSwapchainCreateInfoKHR.nimageFormat(adr, imageFormat.i)
        VkSwapchainCreateInfoKHR.nimageColorSpace(adr, imageColorSpace.i)
        imageExtent.write(adr + VkSwapchainCreateInfoKHR.IMAGEEXTENT)
        VkSwapchainCreateInfoKHR.nimageArrayLayers(adr, imageArrayLayers)
        VkSwapchainCreateInfoKHR.nimageUsage(adr, imageUsage)
        VkSwapchainCreateInfoKHR.nimageSharingMode(adr, imageSharingMode.i)
        queueFamilyIndices?.let {
            VkSwapchainCreateInfoKHR.nqueueFamilyIndexCount(adr, it.size)
            memPutAddress(adr + VkSwapchainCreateInfoKHR.PQUEUEFAMILYINDICES, stack.Adr(it).adr)
        }
        VkSwapchainCreateInfoKHR.npreTransform(adr, preTransform.i)
        VkSwapchainCreateInfoKHR.ncompositeAlpha(adr, compositeAlpha.i)
        VkSwapchainCreateInfoKHR.npresentMode(adr, presentMode.i)
        VkSwapchainCreateInfoKHR.nclipped(adr, clipped.i)
        VkSwapchainCreateInfoKHR.noldSwapchain(adr, oldSwapchain.L)
        return adr
    }
}

class PresentInfoKHR(
        var waitSemaphores: VkSemaphore_Array? = null,
        var swapchains: VkSwapchainKHR_Array,
        var imageIndices: IntArray,
        var results: VkResult_Array? = null,
        var next: Ptr = NULL
) {

    constructor(
            waitSemaphore: VkSemaphore? = null,
            swapchain: VkSwapchainKHR = VkSwapchainKHR.NULL,
            imageIndex: Int,
            result: VkResult_Array? = null
    ) : this(
            waitSemaphore?.let { s -> VkSemaphore_Array(1) { s } },
            VkSwapchainKHR_Array(1) { swapchain },
            intArrayOf(imageIndex),
            result
    )

    val type get() = VkStructureType.PRESENT_INFO_KHR

    var swapchain: VkSwapchainKHR
        get() = swapchains[0]
        set(value) {
            swapchains[0] = value
        }

    var imageIndex: Int
        get() = imageIndices[0]
        set(value) {
            imageIndices[0] = value
        }

    // write and maybe read
    fun <R> native(stack: MemoryStack, block: (Ptr) -> R): R = stack {
        val adr = stack.ncalloc(VkPresentInfoKHR.ALIGNOF, 1, VkPresentInfoKHR.SIZEOF)
        VkPresentInfoKHR.nsType(adr, type.i)
        VkPresentInfoKHR.npNext(adr, next)
        waitSemaphores?.let {
            VkPresentInfoKHR.nwaitSemaphoreCount(adr, it.size)
            memPutAddress(adr + VkPresentInfoKHR.PWAITSEMAPHORES, it write stack)
        }
        VkPresentInfoKHR.nswapchainCount(adr, swapchains.size)
        memPutAddress(adr + VkPresentInfoKHR.PSWAPCHAINS, swapchains write stack)
        memPutAddress(adr + VkPresentInfoKHR.PIMAGEINDICES, stack.Adr(imageIndices).adr)
        when (val results = results) {
            null -> block(adr)
            else -> {
                val pResults = stack.mInt(swapchains.size)
                memPutAddress(adr + VkPresentInfoKHR.PRESULTS, pResults.adr)
                block(adr).also {
                    for (i in results.indices)
                        results[i] = VkResult(pResults[i])
                }
            }
        }
    }
}

class ImageSwapchainCreateInfoKHR(
        var swapchain: VkSwapchainKHR,
        var next: Ptr) {

    val type get() = VkStructureType.IMAGE_SWAPCHAIN_CREATE_INFO_KHR
}

class BindImageMemorySwapchainInfoKHR(
        var swapchain: VkSwapchainKHR,
        var imageIndex: Int,
        var next: Ptr) {

    val type get() = VkStructureType.BIND_IMAGE_MEMORY_SWAPCHAIN_INFO_KHR
}

class AcquireNextImageInfoKHR(
        var swapchain: VkSwapchainKHR,
        var timeout: Long,
        var semaphore: VkSemaphore,
        var fence: VkFence,
        var deviceMask: Int) {

    val type get() = VkStructureType.ACQUIRE_NEXT_IMAGE_INFO_KHR

    infix fun write(stack: MemoryStack): Adr {
        val adr = stack.ncalloc(VkAcquireNextImageInfoKHR.ALIGNOF, 1, VkAcquireNextImageInfoKHR.SIZEOF)
        VkAcquireNextImageInfoKHR.nsType(adr, type.i)
        // pNext must be null
        VkAcquireNextImageInfoKHR.nswapchain(adr, swapchain.L)
        VkAcquireNextImageInfoKHR.ntimeout(adr, timeout)
        VkAcquireNextImageInfoKHR.nsemaphore(adr, semaphore.L)
        VkAcquireNextImageInfoKHR.nfence(adr, fence.L)
        VkAcquireNextImageInfoKHR.ndeviceMask(adr, deviceMask)
        return adr
    }
}

class DeviceGroupPresentCapabilitiesKHR(
        var presentMask: IntArray, // [VK_MAX_DEVICE_GROUP_SIZE]
        var modes: VkDeviceGroupPresentModeFlagsKHR) {

    val type get() = VkStructureType.DEVICE_GROUP_PRESENT_CAPABILITIES_KHR

    constructor(ptr: BytePtr) : this(
            IntArray(VK_MAX_DEVICE_GROUP_SIZE) { VkDeviceGroupPresentCapabilitiesKHR.npresentMask(ptr.adr, it) },
            VkDeviceGroupPresentCapabilitiesKHR.nmodes(ptr.adr))

    companion object {
        //        inline infix fun <R> read(block: (Adr) -> R): PhysicalDeviceProperties2 = stak { read(it, block) }
        inline fun <R> read(stack: MemoryStack, block: (Adr) -> R): DeviceGroupPresentCapabilitiesKHR = stack {
            val adr = stack.ncalloc(VkDeviceGroupPresentCapabilitiesKHR.ALIGNOF, 1, VkDeviceGroupPresentCapabilitiesKHR.SIZEOF)
            block(adr)
            DeviceGroupPresentCapabilitiesKHR(BytePtr(adr))
        }
    }
}

class DeviceGroupPresentInfoKHR(
        var deviceMasks: IntArray?,
        var mode: VkDeviceGroupPresentModeFlagsKHR,
        var next: Ptr) {

    val type get() = VkStructureType.DEVICE_GROUP_PRESENT_INFO_KHR
}

class DeviceGroupSwapchainCreateInfoKHR(
        var modes: VkDeviceGroupPresentModeFlagsKHR,
        var next: Ptr) {

    val type get() = VkStructureType.DEVICE_GROUP_SWAPCHAIN_CREATE_INFO_KHR
}

interface VkStack_KHR_swapchain : VkStackInterface {

    // --- [ vkCreateSwapchainKHR ] ---
    infix fun Device.createSwapchainKHR(createInfo: SwapchainCreateInfoKHR): VkSwapchainKHR =
            stack { VkSwapchainKHR(stack.longAdr { VK_CHECK_RESULT(callPPPPI(adr, createInfo write stack, NULL, it, capabilities.vkCreateSwapchainKHR)) }) }

    // --- [ vkGetSwapchainImagesKHR ] ---
    infix fun Device.getSwapchainImagesKHR(swapchain: VkSwapchainKHR): VkImage_Array = stack {
        var pSwapchainImages = LongPtr.NULL
        val pSwapchainImageCount = stack.mInt()
        var swapchainImageCount: Int
        var result: VkResult
        do {
            result = VkResult(callPJPPI(adr, swapchain.L, pSwapchainImageCount.adr, NULL, capabilities.vkGetSwapchainImagesKHR))
            swapchainImageCount = pSwapchainImageCount[0]
            if (result == VkResult.SUCCESS && swapchainImageCount != 0) {
                pSwapchainImages = stack.mLong(swapchainImageCount)
                result = VkResult(callPJPPI(adr, swapchain.L, pSwapchainImageCount.adr, pSwapchainImages.adr, capabilities.vkGetSwapchainImagesKHR))
            }
        } while (result == VkResult.INCOMPLETE)
        VkImage_Array(swapchainImageCount) { VkImage(pSwapchainImages[it]) }
    }

    // --- [ vkAcquireNextImageKHR ] ---
    fun Device.acquireNextImageKHR(swapchain: VkSwapchainKHR, timeout: Long = -1L, semaphore: VkSemaphore, fence: VkFence = VkFence.NULL, check: (VkResult) -> Unit = ::defaultCheck): Int =
            stack.intAdr { check(VkResult(callPJJJJPI(adr, swapchain.L, timeout, semaphore.L, fence.L, it, capabilities.vkAcquireNextImageKHR))) }

    // --- [ vkQueuePresentKHR ] ---
    infix fun Queue.presentKHR(presentInfo: PresentInfoKHR): VkResult =
            presentInfo.native(stack) { VkResult(callPPI(adr, it, capabilities.vkQueuePresentKHR)).andCheck() }

    // --- [ vkGetDeviceGroupPresentCapabilitiesKHR ] ---
    val Device.groupPresentCapabilitiesKHR: DeviceGroupPresentCapabilitiesKHR
        get() = DeviceGroupPresentCapabilitiesKHR.read(stack) { callPPI(adr, it, capabilities.vkGetDeviceGroupPresentCapabilitiesKHR) }

    // --- [ vkGetDeviceGroupSurfacePresentModesKHR ] ---
    infix fun Device.getGroupSurfacePresentModesKHR(surface: VkSurfaceKHR): VkDeviceGroupPresentModeFlagsKHR =
            stack.intAdr { callPJPI(adr, surface.L, it, capabilities.vkGetDeviceGroupSurfacePresentModesKHR) }

    // --- [ vkGetPhysicalDevicePresentRectanglesKHR ] ---
    infix fun PhysicalDevice.getPresentRectanglesKHR(surface: VkSurfaceKHR): Array<Rect2D> = stack {
        var rects: Ptr = NULL
        val pRectCount = stack.mInt()
        var rectCount: Int
        do {
            var result = VkResult(callPJPPI(adr, surface.L, pRectCount.adr, NULL, capabilities.vkGetPhysicalDevicePresentRectanglesKHR))
            rectCount = pRectCount()
            if (result == VkResult.SUCCESS && rectCount != 0) {
                rects = stack.ncalloc(VkRect2D.ALIGNOF, rectCount, VkRect2D.SIZEOF)
                result = VkResult(callPJPPI(adr, surface.L, pRectCount.adr, rects, capabilities.vkGetPhysicalDevicePresentRectanglesKHR))
            }
        } while (result == VkResult.INCOMPLETE)
        Array(rectCount) { Rect2D(IntPtr(rects + it * VkRect2D.SIZEOF)) }
    }

    // --- [ vkAcquireNextImage2KHR ] ---
    infix fun Device.acquireNextImage2KHR(acquireInfo: AcquireNextImageInfoKHR): Int =
            stack.intAdr { VK_CHECK_RESULT(callPPPI(adr, acquireInfo write stack, it, capabilities.vkAcquireNextImage2KHR)) }
}

// --- [ vkCreateSwapchainKHR ] ---
infix fun Device.createSwapchainKHR(createInfo: SwapchainCreateInfoKHR): VkSwapchainKHR =
        VkStack { it.run { createSwapchainKHR(createInfo) } }

// --- [ vkDestroySwapchainKHR ] ---
infix fun Device.destroy(swapchain: VkSwapchainKHR) = callPJPV(adr, swapchain.L, NULL, capabilities.vkDestroySwapchainKHR)

// --- [ vkGetSwapchainImagesKHR ] ---
infix fun Device.getSwapchainImagesKHR(swapchain: VkSwapchainKHR): VkImage_Array =
        VkStack { it.run { getSwapchainImagesKHR(swapchain) } }

// --- [ vkAcquireNextImageKHR ] ---
fun Device.acquireNextImageKHR(swapchain: VkSwapchainKHR, timeout: Long = -1L, semaphore: VkSemaphore, fence: VkFence = VkFence.NULL, check: (VkResult) -> Unit = ::defaultCheck): Int =
        VkStack { it.run { acquireNextImageKHR(swapchain, timeout, semaphore, fence, check) } }

// --- [ vkQueuePresentKHR ] ---
infix fun Queue.presentKHR(presentInfo: PresentInfoKHR): VkResult =
        VkStack { it.run { presentKHR(presentInfo) } }

// --- [ vkGetDeviceGroupPresentCapabilitiesKHR ] ---
val Device.groupPresentCapabilitiesKHR: DeviceGroupPresentCapabilitiesKHR
    get() = VkStack { it.run { groupPresentCapabilitiesKHR } }

// --- [ vkGetDeviceGroupSurfacePresentModesKHR ] ---
infix fun Device.getGroupSurfacePresentModesKHR(surface: VkSurfaceKHR): VkDeviceGroupPresentModeFlagsKHR =
        VkStack { it.run { getGroupSurfacePresentModesKHR(surface) } }

// --- [ vkGetPhysicalDevicePresentRectanglesKHR ] ---
infix fun PhysicalDevice.getPresentRectanglesKHR(surface: VkSurfaceKHR): Array<Rect2D> =
        VkStack { it.run { getPresentRectanglesKHR(surface) } }

// --- [ vkAcquireNextImage2KHR ] ---
infix fun Device.acquireNextImage2KHR(acquireInfo: AcquireNextImageInfoKHR): Int =
        VkStack { it.run { acquireNextImage2KHR(acquireInfo) } }