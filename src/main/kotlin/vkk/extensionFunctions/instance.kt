package vkk.extensionFunctions

import glm_.BYTES
import kool.*
import org.lwjgl.PointerBuffer
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.system.MemoryUtil.memGetInt
import org.lwjgl.vulkan.*
import vkk.*
import vkk.entities.VkDebugReportCallback
import vkk.entities.VkDebugUtilsMessengerEXT
import vkk.entities.VkDisplayKHR
import vkk.entities.VkSurfaceKHR


infix fun VkInstance.createDebugReportCallbackEXT(createInfo: VkDebugReportCallbackCreateInfoEXT): VkDebugReportCallback =
        VkDebugReportCallback(stak.longAddress {
            VK_CHECK_RESULT(EXTDebugReport.nvkCreateDebugReportCallbackEXT(this, createInfo.adr, NULL, it))
        })


infix fun VkInstance.createDebugUtilsMessengerEXT(createInfo: VkDebugUtilsMessengerCreateInfoEXT): VkDebugUtilsMessengerEXT =
        VkDebugUtilsMessengerEXT(stak.longAddress {
            VK_CHECK_RESULT(EXTDebugUtils.nvkCreateDebugUtilsMessengerEXT(this, createInfo.adr, NULL, it))
        })


infix fun VkInstance.createDisplayPlaneSurfaceKHR(createInfo: VkDisplaySurfaceCreateInfoKHR): VkSurfaceKHR =
        VkSurfaceKHR(stak.longAddress {
            VK_CHECK_RESULT(KHRDisplay.nvkCreateDisplayPlaneSurfaceKHR(this, createInfo.adr, NULL, it))
        })


infix fun VkInstance.createMacOSSurfaceMVK(createInfo: VkMacOSSurfaceCreateInfoMVK): VkSurfaceKHR =
        VkSurfaceKHR(stak.longAddress {
            VK_CHECK_RESULT(MVKMacosSurface.nvkCreateMacOSSurfaceMVK(this, createInfo.adr, NULL, it))
        })


infix fun VkInstance.createWaylandSurfaceKHR(createInfo: VkWaylandSurfaceCreateInfoKHR): VkSurfaceKHR =
        VkSurfaceKHR(stak.longAddress {
            VK_CHECK_RESULT(KHRWaylandSurface.nvkCreateWaylandSurfaceKHR(this, createInfo.adr, NULL, it))
        })


infix fun VkInstance.createWin32SurfaceKHR(createInfo: VkWin32SurfaceCreateInfoKHR): VkSurfaceKHR =
        VkSurfaceKHR(stak.longAddress {
            VK_CHECK_RESULT(KHRWin32Surface.nvkCreateWin32SurfaceKHR(this, createInfo.adr, NULL, it))
        })


infix fun VkInstance.createXlibSurfaceKHR(createInfo: VkXlibSurfaceCreateInfoKHR): VkSurfaceKHR =
        VkSurfaceKHR(stak.longAddress {
            VK_CHECK_RESULT(KHRXlibSurface.nvkCreateXlibSurfaceKHR(this, createInfo.adr, NULL, it))
        })


fun VkInstance.debugReportMessageEXT(flags: VkDebugReportFlagsEXT, objectType: VkDebugReportObjectTypeEXT, `object`: Long, location: Long, messageCode: Int, layerPrefix: CharSequence, message: CharSequence) =
        stak {
            it.nUTF8(layerPrefix, true)
            val pLayerPrefixEncoded = it.pointerAddress
            it.nUTF8(message, true)
            val pMessageEncoded = it.pointerAddress
            EXTDebugReport.nvkDebugReportMessageEXT(this, flags, objectType.i, `object`, location, messageCode, pLayerPrefixEncoded, pMessageEncoded)
        }


infix fun VkInstance.destroyDebugReportCallbackEXT(debugReportCallback: VkDebugReportCallback) =
        EXTDebugReport.nvkDestroyDebugReportCallbackEXT(this, debugReportCallback.L, NULL)

infix fun VkInstance.destroy(debugReportCallback: VkDebugReportCallback) =
        EXTDebugReport.nvkDestroyDebugReportCallbackEXT(this, debugReportCallback.L, NULL)


infix fun VkInstance.destroyDebugUtilsMessengerEXT(messenger: VkDebugUtilsMessengerEXT) =
        EXTDebugUtils.nvkDestroyDebugUtilsMessengerEXT(this, messenger.L, NULL)

infix fun VkInstance.destroy(messenger: VkDebugUtilsMessengerEXT) =
        EXTDebugUtils.nvkDestroyDebugUtilsMessengerEXT(this, messenger.L, NULL)


fun VkInstance.destroy() =
        VK10.nvkDestroyInstance(this, NULL)


fun VkInstance.destroySurfaceKHR(surface: VkSurfaceKHR) =
        KHRSurface.nvkDestroySurfaceKHR(this, surface.L, NULL)

fun VkInstance.destroy(surface: VkSurfaceKHR) =
        KHRSurface.nvkDestroySurfaceKHR(this, surface.L, NULL)


fun VkInstance.enumeratePhysicalDeviceGroups(physicalDeviceGroupProperties: VkPhysicalDeviceGroupProperties.Buffer): VkResult =
        VkResult(stak.intAddress(physicalDeviceGroupProperties.rem) {
            VK11.nvkEnumeratePhysicalDeviceGroups(this, it, physicalDeviceGroupProperties.adr)
        }).apply { check() }

inline fun <reified T> VkInstance.enumeratePhysicalDeviceGroups(): T = when (T::class) {
    Int::class -> stak.intAddress {
        VK_CHECK_RESULT(VK11.nvkEnumeratePhysicalDeviceGroups(this, it, NULL))
    } as T
    VkPhysicalDeviceGroupProperties.Buffer::class -> stak {
        lateinit var physicalDeviceGroupProperties: VkPhysicalDeviceGroupProperties.Buffer
        val pPhysicalDeviceGroupCount = it.nmalloc(4, Int.BYTES)
        var result: VkResult
        do {
            result = VkResult(VK11.nvkEnumeratePhysicalDeviceGroups(this, pPhysicalDeviceGroupCount, NULL)).apply { check() }
            val physicalDeviceCount = memGetInt(pPhysicalDeviceGroupCount)
            if (result == VkResult.SUCCESS && physicalDeviceCount != 0) {
                physicalDeviceGroupProperties = it.PhysicalDeviceGroupProperties(physicalDeviceCount)
                result = VkResult(VK11.nvkEnumeratePhysicalDeviceGroups(this, pPhysicalDeviceGroupCount, physicalDeviceGroupProperties.adr))
            }
        } while (result == VkResult.INCOMPLETE)
        physicalDeviceGroupProperties as T
    }
    else -> throw Exception("[VkInstance::enumeratePhysicalDeviceGroups] Invalid T")
}

val VkInstance.enumeratePhysicalDeviceGroups: VkPhysicalDeviceGroupProperties.Buffer
    get() = enumeratePhysicalDeviceGroups()


fun VkInstance.enumeratePhysicalDeviceGroupsKHR(physicalDeviceGroupProperties: VkPhysicalDeviceGroupProperties.Buffer): VkResult =
        VkResult(stak.intAddress(physicalDeviceGroupProperties.rem) {
            KHRDeviceGroupCreation.nvkEnumeratePhysicalDeviceGroupsKHR(this, it, physicalDeviceGroupProperties.adr)
        }).apply { check() }

inline fun <reified T> VkInstance.enumeratePhysicalDeviceGroupsKHR(): T = when (T::class) {
    Int::class -> stak.intAddress {
        VK_CHECK_RESULT(KHRDeviceGroupCreation.nvkEnumeratePhysicalDeviceGroupsKHR(this, it, NULL))
    } as T
    VkPhysicalDeviceGroupProperties.Buffer::class -> stak {
        lateinit var physicalDeviceGroupProperties: VkPhysicalDeviceGroupProperties.Buffer
        val pPhysicalDeviceGroupCount = it.nmalloc(4, Int.BYTES)
        var result: VkResult
        do {
            result = VkResult(KHRDeviceGroupCreation.nvkEnumeratePhysicalDeviceGroupsKHR(this, pPhysicalDeviceGroupCount, NULL)).apply { check() }
            val physicalDeviceCount = memGetInt(pPhysicalDeviceGroupCount)
            if (result == VkResult.SUCCESS && physicalDeviceCount != 0) {
                physicalDeviceGroupProperties = it.PhysicalDeviceGroupProperties(physicalDeviceCount)
                result = VkResult(KHRDeviceGroupCreation.nvkEnumeratePhysicalDeviceGroupsKHR(this, pPhysicalDeviceGroupCount, physicalDeviceGroupProperties.adr))
            }
        } while (result == VkResult.INCOMPLETE)
        physicalDeviceGroupProperties as T
    }
    else -> throw Exception("[VkInstance::enumeratePhysicalDeviceGroupsKHR] Invalid T")
}

val VkInstance.enumeratePhysicalDeviceGroupsKHR: VkPhysicalDeviceGroupProperties.Buffer
    get() = enumeratePhysicalDeviceGroupsKHR()


fun VkInstance.enumeratePhysicalDevices(physicalDevices: VkPhysicalDevice_Buffer): VkResult =
        VkResult(stak.intAddress(physicalDevices.rem) {
            VK10.nvkEnumeratePhysicalDevices(this, it, physicalDevices.adr)
        }).apply { check() }

inline fun <reified T> VkInstance.enumeratePhysicalDevices(): T = when (T::class) {
    Int::class -> stak.intAddress {
        VK_CHECK_RESULT(VK10.nvkEnumeratePhysicalDevices(this, it, NULL))
    } as T
    VkPhysicalDevice_Buffer::class -> stak {
        lateinit var physicalDevices: PointerBuffer
        val pPhysicalDeviceGroupCount = it.nmalloc(4, Int.BYTES)
        var result: VkResult
        do {
            result = VkResult(VK10.nvkEnumeratePhysicalDevices(this, pPhysicalDeviceGroupCount, NULL)).apply { check() }
            val physicalDeviceCount = memGetInt(pPhysicalDeviceGroupCount)
            if (result == VkResult.SUCCESS && physicalDeviceCount != 0) {
                physicalDevices = it.PointerBuffer(physicalDeviceCount)
                result = VkResult(VK10.nvkEnumeratePhysicalDevices(this, pPhysicalDeviceGroupCount, physicalDevices.adr))
            }
        } while (result == VkResult.INCOMPLETE)
        VkPhysicalDevice_Buffer(physicalDevices, this) as T
    }
    else -> throw Exception("[VkInstance::enumeratePhysicalDevices] Invalid T")
}

val VkInstance.enumeratePhysicalDevices: VkPhysicalDevice_Buffer
    get() = enumeratePhysicalDevices()


fun VkInstance.getProcAddr(name: String): Adr =
        stak.asciiAddress(name) { VK10.nvkGetInstanceProcAddr(this, it) }


fun VkInstance.submitDebugUtilsMessageEXT(messageSeverity: VkDebugUtilsMessageSeverityEXT, messageTypes: VkDebugUtilsMessageTypeFlagsEXT, callbackData: VkDebugUtilsMessengerCallbackDataEXT) =
        EXTDebugUtils.nvkSubmitDebugUtilsMessageEXT(this, messageSeverity.i, messageTypes, callbackData.adr)

