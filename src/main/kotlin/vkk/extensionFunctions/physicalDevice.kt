package vkk.extensionFunctions

import glm_.BYTES
import glm_.bool
import kool.*
import org.lwjgl.system.MemoryStack.stackGet
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.vulkan.*
import vkk.*
import vkk.entities.VkDisplayKHR
import vkk.entities.VkDisplayKHR_Buffer
import vkk.entities.VkDisplayModeKHR
import vkk.entities.VkSurfaceKHR
import java.nio.IntBuffer
import java.nio.LongBuffer


infix fun VkPhysicalDevice.acquireXlibDisplayEXT(display: VkDisplayKHR): Display =
        Display(stak.longAddress { VK_CHECK_RESULT(EXTAcquireXlibDisplay.vkAcquireXlibDisplayEXT(this, it, display.L)) })


infix fun VkPhysicalDevice.createDevice(createInfo: VkDeviceCreateInfo): VkDevice =
        VkDevice(stak.pointerAddress { VK_CHECK_RESULT(VK10.nvkCreateDevice(this, createInfo.adr, NULL, it)) }, this, createInfo)


fun VkPhysicalDevice.createDisplayModeKHR(display: VkDisplayKHR, createInfo: VkDisplayModeCreateInfoKHR): VkDisplayModeKHR =
        VkDisplayModeKHR(stak.longAddress { VK_CHECK_RESULT(KHRDisplay.nvkCreateDisplayModeKHR(this, display.L, createInfo.adr, NULL, it)) })


fun VkPhysicalDevice.enumerateDeviceExtensionProperties(layerName: String? = null, properties: VkExtensionProperties.Buffer): VkResult =
        stak {
            val pPropertyCount = it.nmalloc(4, Int.BYTES)
            memPutInt(pPropertyCount, properties.rem)
            val pLayerName = layerName?.toUTF8(it)?.let(::memAddress) ?: NULL
            VkResult(VK10.nvkEnumerateDeviceExtensionProperties(this, pLayerName, pPropertyCount, properties.adr)).apply { check() }
        }

inline fun <reified T> VkPhysicalDevice.enumerateDeviceExtensionProperties(layerName: String? = null): T = when (T::class) {
    Int::class -> stak {
        val pPropertyCount = it.nmalloc(4, Int.BYTES)
        val pLayerName = layerName?.toUTF8(it)?.let(::memAddress) ?: NULL
        VK_CHECK_RESULT(VK10.nvkEnumerateDeviceExtensionProperties(this, pLayerName, pPropertyCount, NULL))
        memGetInt(pPropertyCount) as T
    }
    VkExtensionProperties.Buffer::class -> {
        val st = stackGet()
        val pPropertyCount = st.nmalloc(4, Int.BYTES)
        val pLayerName = layerName?.toUTF8(st)?.let(::memAddress) ?: NULL
        var result: VkResult
        lateinit var properties: VkExtensionProperties.Buffer
        do {
            result = VkResult(VK10.nvkEnumerateDeviceExtensionProperties(this, pLayerName, pPropertyCount, NULL))
            val propertyCount = memGetInt(pPropertyCount)
            if (result == VkResult.SUCCESS && propertyCount != 0) {
                properties = st.ExtensionProperties(propertyCount)
                VK_CHECK_RESULT(VK10.nvkEnumerateDeviceExtensionProperties(this, pLayerName, pPropertyCount, properties.adr))
            }
        } while (result == VkResult.INCOMPLETE)
        properties as T
    }
    else -> throw Exception("[VkPhysicalDevice::enumerateDeviceExtensionProperties] Invalid T")
}

val VkPhysicalDevice.extensionProperties: VkExtensionProperties.Buffer
    get() = enumerateDeviceExtensionProperties()


fun VkPhysicalDevice.enumerateDeviceLayerProperties(properties: VkLayerProperties.Buffer): VkResult =
        stak.intAddress(properties.rem) {
            VkResult(VK10.nvkEnumerateDeviceLayerProperties(this, it, properties.adr)).apply { check() }
        }

inline fun <reified T> VkPhysicalDevice.enumerateDeviceLayerProperties(): T = when (T::class) {
    Int::class -> stak.intAddress {
        VK_CHECK_RESULT(VK10.nvkEnumerateDeviceLayerProperties(this, it, NULL))
    } as T
    VkLayerProperties.Buffer::class -> {
        val st = stackGet()
        val pPropertyCount = st.nmalloc(4, Int.BYTES)
        var result: VkResult
        lateinit var properties: VkLayerProperties.Buffer
        do {
            result = VkResult(VK10.nvkEnumerateDeviceLayerProperties(this, pPropertyCount, NULL))
            val propertyCount = memGetInt(pPropertyCount)
            if (result == VkResult.SUCCESS && propertyCount != 0) {
                properties = st.LayerProperties(propertyCount)
                VK_CHECK_RESULT(VK10.nvkEnumerateDeviceLayerProperties(this, pPropertyCount, properties.adr))
            }
        } while (result == VkResult.INCOMPLETE)
        properties as T
    }
    else -> throw Exception("[VkPhysicalDevice::enumerateDeviceLayerProperties] Invalid T")
}

val VkPhysicalDevice.layerProperties: VkLayerProperties.Buffer
    get() = enumerateDeviceLayerProperties()


fun VkPhysicalDevice.getDisplayModeProperties2KHR(display: VkDisplayKHR, properties: VkDisplayModeProperties2KHR.Buffer): VkResult =
        stak.intAddress(properties.rem) {
            VkResult(KHRGetDisplayProperties2.nvkGetDisplayModeProperties2KHR(this, display.L, it, properties.adr))
        }

inline fun <reified T> VkPhysicalDevice.getDisplayModeProperties2KHR(display: VkDisplayKHR): T = when (T::class) {
    Int::class -> stak.intAddress {
        VK_CHECK_RESULT(KHRGetDisplayProperties2.nvkGetDisplayModeProperties2KHR(this, display.L, it, NULL))
    } as T
    VkDisplayModeProperties2KHR.Buffer::class -> {
        val st = stackGet()
        val pPropertyCount = st.nmalloc(4, Int.BYTES)
        var result: VkResult
        lateinit var properties: VkDisplayModeProperties2KHR.Buffer
        do {
            result = VkResult(KHRGetDisplayProperties2.nvkGetDisplayModeProperties2KHR(this, display.L, pPropertyCount, NULL))
            val propertyCount = memGetInt(pPropertyCount)
            if (result == VkResult.SUCCESS && propertyCount != 0) {
                properties = st.DisplayModeProperties2KHR(propertyCount)
                VK_CHECK_RESULT(KHRGetDisplayProperties2.nvkGetDisplayModeProperties2KHR(this, display.L, pPropertyCount, properties.adr))
            }
        } while (result == VkResult.INCOMPLETE)
        properties as T
    }
    else -> throw Exception("[VkPhysicalDevice::getDisplayModeProperties2KHR] Invalid T")
}


fun VkPhysicalDevice.getDisplayModePropertiesKHR(display: VkDisplayKHR, properties: VkDisplayModePropertiesKHR.Buffer): VkResult =
        stak.intAddress(properties.rem) {
            VkResult(KHRDisplay.nvkGetDisplayModePropertiesKHR(this, display.L, it, properties.adr))
        }

inline fun <reified T> VkPhysicalDevice.getDisplayModePropertiesKHR(display: VkDisplayKHR): T = when (T::class) {
    Int::class -> stak.intAddress {
        VK_CHECK_RESULT(KHRDisplay.nvkGetDisplayModePropertiesKHR(this, display.L, it, NULL))
    } as T
    VkDisplayModePropertiesKHR.Buffer::class -> {
        val st = stackGet()
        val pPropertyCount = st.nmalloc(4, Int.BYTES)
        var result: VkResult
        lateinit var properties: VkDisplayModePropertiesKHR.Buffer
        do {
            result = VkResult(KHRDisplay.nvkGetDisplayModePropertiesKHR(this, display.L, pPropertyCount, NULL))
            val propertyCount = memGetInt(pPropertyCount)
            if (result == VkResult.SUCCESS && propertyCount != 0) {
                properties = st.DisplayModePropertiesKHR(propertyCount)
                VK_CHECK_RESULT(KHRDisplay.nvkGetDisplayModePropertiesKHR(this, display.L, pPropertyCount, properties.adr))
            }
        } while (result == VkResult.INCOMPLETE)
        properties as T
    }
    else -> throw Exception("[VkPhysicalDevice::getDisplayModePropertiesKHR] Invalid T")
}


fun VkPhysicalDevice.getDisplayPlaneCapabilities2KHR(displayPlaneInfo: VkDisplayPlaneInfo2KHR, capabilities: VkDisplayPlaneCapabilities2KHR = vk.DisplayPlaneCapabilities2KHR()): VkResult =
        VkResult(KHRGetDisplayProperties2.nvkGetDisplayPlaneCapabilities2KHR(this, displayPlaneInfo.adr, capabilities.adr)).apply { check() }


fun VkPhysicalDevice.getDisplayPlaneCapabilitiesKHR(mode: VkDisplayModeKHR, planeIndex: Int, capabilities: VkDisplayPlaneCapabilitiesKHR = vk.DisplayPlaneCapabilitiesKHR()): VkResult =
        VkResult(KHRDisplay.nvkGetDisplayPlaneCapabilitiesKHR(this, mode.L, planeIndex, capabilities.adr)).apply { check() }


fun VkPhysicalDevice.getDisplayPlaneSupportedDisplaysKHR(planeIndex: Int, displays: VkDisplayKHR_Buffer): VkResult =
        stak.intAddress(displays.rem) {
            VkResult(KHRDisplay.nvkGetDisplayPlaneSupportedDisplaysKHR(this, planeIndex, it, displays.adr)).apply { check() }
        }

inline fun <reified T> VkPhysicalDevice.getDisplayPlaneSupportedDisplaysKHR(planeIndex: Int): T = when (T::class) {
    Int::class -> stak.intAddress {
        VK_CHECK_RESULT(KHRDisplay.nvkGetDisplayPlaneSupportedDisplaysKHR(this, planeIndex, it, NULL))
    } as T
    VkDisplayKHR_Buffer::class -> {
        val s = stackGet()
        val pDisplayCount = s.nmalloc(4, Int.BYTES)
        var result: VkResult
        lateinit var properties: LongBuffer
        do {
            result = VkResult(KHRDisplay.nvkGetDisplayPlaneSupportedDisplaysKHR(this, planeIndex, pDisplayCount, NULL))
            val displayCount = memGetInt(pDisplayCount)
            if (result == VkResult.SUCCESS && displayCount != 0) {
                properties = s.LongBuffer(displayCount)
                VK_CHECK_RESULT(KHRDisplay.nvkGetDisplayPlaneSupportedDisplaysKHR(this, planeIndex, pDisplayCount, properties.adr))
            }
        } while (result == VkResult.INCOMPLETE)
        VkDisplayKHR_Buffer(properties) as T
    }
    else -> throw Exception("[VkPhysicalDevice::getDisplayPlaneSupportedDisplaysKHR] Invalid T")
}


fun VkPhysicalDevice.getCalibrateableTimeDomainsEXT(timeDomains: VkTimeDomainEXT_Buffer): VkResult =
        stak.intAddress(timeDomains.rem) {
            VkResult(EXTCalibratedTimestamps.nvkGetPhysicalDeviceCalibrateableTimeDomainsEXT(this, it, timeDomains.adr)).apply { check() }
        }

inline fun <reified T> VkPhysicalDevice.getCalibrateableTimeDomainsEXT(): T = when (T::class) {
    Int::class -> stak.intAddress {
        VK_CHECK_RESULT(EXTCalibratedTimestamps.nvkGetPhysicalDeviceCalibrateableTimeDomainsEXT(this, it, NULL))
    } as T
    VkTimeDomainEXT_Buffer::class -> {
        val s = stackGet()
        val pTimeDomainCount = s.nmalloc(4, Int.BYTES)
        var result: VkResult
        lateinit var timeDomains: IntBuffer
        do {
            result = VkResult(EXTCalibratedTimestamps.nvkGetPhysicalDeviceCalibrateableTimeDomainsEXT(this, pTimeDomainCount, NULL))
            val timeDomainCount = memGetInt(pTimeDomainCount)
            if (result == VkResult.SUCCESS && timeDomainCount != 0) {
                timeDomains = s.IntBuffer(timeDomainCount)
                VK_CHECK_RESULT(EXTCalibratedTimestamps.nvkGetPhysicalDeviceCalibrateableTimeDomainsEXT(this, pTimeDomainCount, timeDomains.adr))
            }
        } while (result == VkResult.INCOMPLETE)
        VkTimeDomainEXT_Buffer(timeDomains) as T
    }
    else -> throw Exception("[VkPhysicalDevice::getCalibrateableTimeDomainsEXT] Invalid T")
}

val VkPhysicalDevice.calibrateableTimeDomainsEXT: VkTimeDomainEXT_Buffer
    get() = getCalibrateableTimeDomainsEXT()


fun VkPhysicalDevice.getDisplayPlaneProperties2KHR(properties: VkDisplayPlaneProperties2KHR.Buffer): VkResult =
        stak.intAddress(properties.rem) {
            VkResult(KHRGetDisplayProperties2.nvkGetPhysicalDeviceDisplayPlaneProperties2KHR(this, it, properties.adr)).apply { check() }
        }

inline fun <reified T> VkPhysicalDevice.getDisplayPlaneProperties2KHR(): T = when (T::class) {
    Int::class -> stak.intAddress {
        VK_CHECK_RESULT(KHRGetDisplayProperties2.nvkGetPhysicalDeviceDisplayPlaneProperties2KHR(this, it, NULL))
    } as T
    VkDisplayPlaneProperties2KHR.Buffer::class -> {
        val st = stackGet()
        val pPropertyCount = st.nmalloc(4, Int.BYTES)
        var result: VkResult
        lateinit var properties: VkDisplayPlaneProperties2KHR.Buffer
        do {
            result = VkResult(KHRGetDisplayProperties2.nvkGetPhysicalDeviceDisplayPlaneProperties2KHR(this, pPropertyCount, NULL))
            val propertiesCount = memGetInt(pPropertyCount)
            if (result == VkResult.SUCCESS && propertiesCount != 0) {
                properties = st.DisplayPlaneProperties2KHR(propertiesCount)
                VK_CHECK_RESULT(KHRGetDisplayProperties2.nvkGetPhysicalDeviceDisplayPlaneProperties2KHR(this, pPropertyCount, properties.adr))
            }
        } while (result == VkResult.INCOMPLETE)
        properties as T
    }
    else -> throw Exception("[VkPhysicalDevice::getDisplayPlaneProperties2KHR] Invalid T")
}

inline val VkPhysicalDevice.displayPlaneProperties2KHR: VkDisplayPlaneProperties2KHR.Buffer
    get() = getDisplayPlaneProperties2KHR()


fun VkPhysicalDevice.getDisplayPlanePropertiesKHR(properties: VkDisplayPlanePropertiesKHR.Buffer): VkResult =
        stak.intAddress(properties.rem) {
            VkResult(KHRDisplay.nvkGetPhysicalDeviceDisplayPlanePropertiesKHR(this, it, properties.adr)).apply { check() }
        }

inline fun <reified T> VkPhysicalDevice.getDisplayPlanePropertiesKHR(): T = when (T::class) {
    Int::class -> stak.intAddress {
        VK_CHECK_RESULT(KHRDisplay.nvkGetPhysicalDeviceDisplayPlanePropertiesKHR(this, it, NULL))
    } as T
    VkDisplayPlanePropertiesKHR.Buffer::class -> {
        val st = stackGet()
        val pPropertyCount = st.nmalloc(4, Int.BYTES)
        var result: VkResult
        lateinit var properties: VkDisplayPlanePropertiesKHR.Buffer
        do {
            result = VkResult(KHRDisplay.nvkGetPhysicalDeviceDisplayPlanePropertiesKHR(this, pPropertyCount, NULL))
            val propertiesCount = memGetInt(pPropertyCount)
            if (result == VkResult.SUCCESS && propertiesCount != 0) {
                properties = st.DisplayPlanePropertiesKHR(propertiesCount)
                VK_CHECK_RESULT(KHRDisplay.nvkGetPhysicalDeviceDisplayPlanePropertiesKHR(this, pPropertyCount, properties.adr))
            }
        } while (result == VkResult.INCOMPLETE)
        properties as T
    }
    else -> throw Exception("[VkPhysicalDevice::getDisplayPlanePropertiesKHR] Invalid T")
}

inline val VkPhysicalDevice.displayPlanePropertiesKHR: VkDisplayPlanePropertiesKHR.Buffer
    get() = getDisplayPlanePropertiesKHR()


fun VkPhysicalDevice.getDisplayProperties2KHR(properties: VkDisplayProperties2KHR.Buffer): VkResult =
        stak.intAddress(properties.rem) {
            VkResult(KHRGetDisplayProperties2.nvkGetPhysicalDeviceDisplayProperties2KHR(this, it, properties.adr)).apply { check() }
        }

inline fun <reified T> VkPhysicalDevice.getDisplayProperties2KHR(): T = when (T::class) {
    Int::class -> stak.intAddress {
        VK_CHECK_RESULT(KHRGetDisplayProperties2.nvkGetPhysicalDeviceDisplayProperties2KHR(this, it, NULL))
    } as T
    VkDisplayProperties2KHR.Buffer::class -> {
        val st = stackGet()
        val pPropertyCount = st.nmalloc(4, Int.BYTES)
        var result: VkResult
        lateinit var properties: VkDisplayProperties2KHR.Buffer
        do {
            result = VkResult(KHRGetDisplayProperties2.nvkGetPhysicalDeviceDisplayProperties2KHR(this, pPropertyCount, NULL))
            val propertiesCount = memGetInt(pPropertyCount)
            if (result == VkResult.SUCCESS && propertiesCount != 0) {
                properties = st.DisplayProperties2KHR(propertiesCount)
                VK_CHECK_RESULT(KHRGetDisplayProperties2.nvkGetPhysicalDeviceDisplayProperties2KHR(this, pPropertyCount, properties.adr))
            }
        } while (result == VkResult.INCOMPLETE)
        properties as T
    }
    else -> throw Exception("[VkPhysicalDevice::getDisplayProperties2KHR] Invalid T")
}

inline val VkPhysicalDevice.displayProperties2KHR: VkDisplayProperties2KHR.Buffer
    get() = getDisplayProperties2KHR()


fun VkPhysicalDevice.getDisplayPropertiesKHR(properties: VkDisplayPropertiesKHR.Buffer): VkResult =
        stak.intAddress(properties.rem) {
            VkResult(KHRDisplay.nvkGetPhysicalDeviceDisplayPropertiesKHR(this, it, properties.adr)).apply { check() }
        }

inline fun <reified T> VkPhysicalDevice.getDisplayPropertiesKHR(): T = when (T::class) {
    Int::class -> stak.intAddress {
        VkResult(KHRDisplay.nvkGetPhysicalDeviceDisplayPropertiesKHR(this, it, NULL))
    } as T
    VkDisplayPropertiesKHR.Buffer::class -> {
        val st = stackGet()
        val pPropertyCount = st.nmalloc(4, Int.BYTES)
        var result: VkResult
        lateinit var properties: VkDisplayPropertiesKHR.Buffer
        do {
            result = VkResult(KHRDisplay.nvkGetPhysicalDeviceDisplayPropertiesKHR(this, pPropertyCount, NULL))
            val propertiesCount = memGetInt(pPropertyCount)
            if (result == VkResult.SUCCESS && propertiesCount != 0) {
                properties = st.DisplayPropertiesKHR(propertiesCount)
                VK_CHECK_RESULT(KHRDisplay.nvkGetPhysicalDeviceDisplayPropertiesKHR(this, pPropertyCount, properties.adr))
            }
        } while (result == VkResult.INCOMPLETE)
        properties as T
    }
    else -> throw Exception("[VkPhysicalDevice::getDisplayPropertiesKHR] Invalid T")
}

inline val VkPhysicalDevice.displayPropertiesKHR: VkDisplayPropertiesKHR.Buffer
    get() = getDisplayPropertiesKHR()


fun VkPhysicalDevice.getExternalBufferProperties(externalBufferInfo: VkPhysicalDeviceExternalBufferInfo, externalBufferProperties: VkExternalBufferProperties = vk.ExternalBufferProperties()): VkExternalBufferProperties =
        externalBufferProperties.also { VK11.nvkGetPhysicalDeviceExternalBufferProperties(this, externalBufferInfo.adr, it.adr) }


fun VkPhysicalDevice.getExternalBufferPropertiesKHR(externalBufferInfo: VkPhysicalDeviceExternalBufferInfo, externalBufferProperties: VkExternalBufferProperties = vk.ExternalBufferProperties()): VkExternalBufferProperties =
        externalBufferProperties.also { KHRExternalMemoryCapabilities.nvkGetPhysicalDeviceExternalBufferPropertiesKHR(this, externalBufferInfo.adr, it.adr) }


fun VkPhysicalDevice.getExternalFenceProperties(externalFenceInfo: VkPhysicalDeviceExternalFenceInfo, externalFenceProperties: VkExternalFenceProperties = vk.ExternalFenceProperties()): VkExternalFenceProperties =
        externalFenceProperties.also { VK11.nvkGetPhysicalDeviceExternalFenceProperties(this, externalFenceInfo.adr, it.adr) }


fun VkPhysicalDevice.getExternalFencePropertiesKHR(externalFenceInfo: VkPhysicalDeviceExternalFenceInfo, externalFenceProperties: VkExternalFenceProperties = vk.ExternalFenceProperties()): VkExternalFenceProperties =
        externalFenceProperties.also { KHRExternalFenceCapabilities.nvkGetPhysicalDeviceExternalFencePropertiesKHR(this, externalFenceInfo.adr, it.adr) }


fun VkPhysicalDevice.getExternalImageFormatPropertiesNV(format: VkFormat, type: VkImageType, tiling: VkImageTiling, usage: VkImageUsageFlags, flags: VkImageCreateFlags, externalHandleType: VkExternalMemoryHandleTypeFlagsNV, externalImageFormatProperties: VkExternalImageFormatPropertiesNV = vk.ExternalImageFormatPropertiesNV()): VkExternalImageFormatPropertiesNV =
        externalImageFormatProperties.also { VK_CHECK_RESULT(NVExternalMemoryCapabilities.nvkGetPhysicalDeviceExternalImageFormatPropertiesNV(this, format.i, type.i, tiling.i, usage, flags, externalHandleType, externalImageFormatProperties.adr)) }


fun VkPhysicalDevice.getExternalSemaphoreProperties(externalSemaphoreInfo: VkPhysicalDeviceExternalSemaphoreInfo, externalSemaphoreProperties: VkExternalSemaphoreProperties = vk.ExternalSemaphoreProperties()): VkExternalSemaphoreProperties =
        externalSemaphoreProperties.also { VK11.nvkGetPhysicalDeviceExternalSemaphoreProperties(this, externalSemaphoreInfo.adr, externalSemaphoreProperties.adr) }


fun VkPhysicalDevice.getExternalSemaphorePropertiesKHR(externalSemaphoreInfo: VkPhysicalDeviceExternalSemaphoreInfo, externalSemaphoreProperties: VkExternalSemaphoreProperties = vk.ExternalSemaphoreProperties()): VkExternalSemaphoreProperties =
        externalSemaphoreProperties.also { KHRExternalSemaphoreCapabilities.nvkGetPhysicalDeviceExternalSemaphorePropertiesKHR(this, externalSemaphoreInfo.adr, externalSemaphoreProperties.adr) }


fun VkPhysicalDevice.getFeatures(features: VkPhysicalDeviceFeatures = vk.PhysicalDeviceFeatures()): VkPhysicalDeviceFeatures =
        features.also { VK10.nvkGetPhysicalDeviceFeatures(this, it.adr) }

inline val VkPhysicalDevice.features: VkPhysicalDeviceFeatures
    get() = getFeatures()


fun VkPhysicalDevice.getFeatures2(features: VkPhysicalDeviceFeatures2 = vk.PhysicalDeviceFeatures2()): VkPhysicalDeviceFeatures2 =
        features.also { VK11.nvkGetPhysicalDeviceFeatures2(this, it.adr) }

inline val VkPhysicalDevice.features2: VkPhysicalDeviceFeatures2
    get() = getFeatures2()


fun VkPhysicalDevice.getFormatProperties(format: VkFormat, formatProperties: VkFormatProperties = vk.FormatProperties()): VkFormatProperties =
        formatProperties.also { VK10.nvkGetPhysicalDeviceFormatProperties(this, format.i, it.adr) }


fun VkPhysicalDevice.getFormatProperties2(format: VkFormat, formatProperties: VkFormatProperties2 = vk.FormatProperties2()): VkFormatProperties2 =
        formatProperties.also { VK11.nvkGetPhysicalDeviceFormatProperties2(this, format.i, it.adr) }


fun VkPhysicalDevice.getGeneratedCommandsPropertiesNVX(features: VkDeviceGeneratedCommandsFeaturesNVX, limits: VkDeviceGeneratedCommandsLimitsNVX = vk.DeviceGeneratedCommandsLimitsNVX()): VkDeviceGeneratedCommandsLimitsNVX =
        limits.also { NVXDeviceGeneratedCommands.nvkGetPhysicalDeviceGeneratedCommandsPropertiesNVX(this, features.adr, it.adr) }


fun VkPhysicalDevice.getImageFormatProperties(format: VkFormat, type: VkImageType, tiling: VkImageTiling, usage: VkImageUsageFlags, flags: VkImageCreateFlags, imageFormatProperties: VkImageFormatProperties = vk.ImageFormatProperties()): VkImageFormatProperties =
        imageFormatProperties.also { VK_CHECK_RESULT(VK10.nvkGetPhysicalDeviceImageFormatProperties(this, format.i, type.i, tiling.i, usage, flags, imageFormatProperties.adr)) }


fun VkPhysicalDevice.getImageFormatProperties2(imageFormatInfo: VkPhysicalDeviceImageFormatInfo2, imageFormatProperties: VkImageFormatProperties2): VkImageFormatProperties2 =
        imageFormatProperties.also { VK_CHECK_RESULT(VK11.nvkGetPhysicalDeviceImageFormatProperties2(this, imageFormatInfo.adr, it.adr)) }


fun VkPhysicalDevice.getImageFormatProperties2KHR(imageFormatInfo: VkPhysicalDeviceImageFormatInfo2, imageFormatProperties: VkImageFormatProperties2): VkImageFormatProperties2 =
        imageFormatProperties.also { VK_CHECK_RESULT(KHRGetPhysicalDeviceProperties2.nvkGetPhysicalDeviceImageFormatProperties2KHR(this, imageFormatInfo.adr, it.adr)) }


fun VkPhysicalDevice.getMemoryProperties(memoryProperties: VkPhysicalDeviceMemoryProperties = vk.PhysicalDeviceMemoryProperties()): VkPhysicalDeviceMemoryProperties = memoryProperties.also { VK10.nvkGetPhysicalDeviceMemoryProperties(this, it.adr) }

inline val VkPhysicalDevice.memoryProperties: VkPhysicalDeviceMemoryProperties
    get() = getMemoryProperties()


fun VkPhysicalDevice.getMemoryProperties2(memoryProperties: VkPhysicalDeviceMemoryProperties2 = vk.PhysicalDeviceMemoryProperties2()): VkPhysicalDeviceMemoryProperties2 =
        memoryProperties.also { VK11.nvkGetPhysicalDeviceMemoryProperties2(this, it.adr) }

inline val VkPhysicalDevice.memoryProperties2: VkPhysicalDeviceMemoryProperties2
    get() = getMemoryProperties2()


fun VkPhysicalDevice.getMemoryProperties2KHR(memoryProperties: VkPhysicalDeviceMemoryProperties2 = vk.PhysicalDeviceMemoryProperties2()): VkPhysicalDeviceMemoryProperties2 =
        memoryProperties.also { KHRGetPhysicalDeviceProperties2.nvkGetPhysicalDeviceMemoryProperties2KHR(this, it.adr) }

inline val VkPhysicalDevice.memoryProperties2KHR: VkPhysicalDeviceMemoryProperties2
    get() = getMemoryProperties2KHR()


fun VkPhysicalDevice.getMultisamplePropertiesEXT(samples: VkSampleCount, multisampleProperties: VkMultisamplePropertiesEXT = vk.MultisamplePropertiesEXT()): VkMultisamplePropertiesEXT =
        multisampleProperties.also { EXTSampleLocations.nvkGetPhysicalDeviceMultisamplePropertiesEXT(this, samples.i, it.adr) }


fun VkPhysicalDevice.getPresentRectanglesKHR(surface: VkSurfaceKHR, rects: VkRect2D.Buffer): VkResult =
        stak.intAddress(rects.rem) {
            VkResult(KHRDeviceGroup.nvkGetPhysicalDevicePresentRectanglesKHR(this, surface.L, it, rects.adr)).apply { check() }
        }

inline infix fun <reified T> VkPhysicalDevice.getPresentRectanglesKHR(surface: VkSurfaceKHR): T = when (T::class) {
    Int::class -> stak.intAddress {
        VK_CHECK_RESULT(KHRDeviceGroup.nvkGetPhysicalDevicePresentRectanglesKHR(this, surface.L, it, NULL))
    } as T
    VkRect2D.Buffer::class -> {
        val st = stackGet()
        val pRectCount = st.nmalloc(4, Int.BYTES)
        var result: VkResult
        lateinit var rects: VkRect2D.Buffer
        do {
            result = VkResult(KHRDeviceGroup.nvkGetPhysicalDevicePresentRectanglesKHR(this, surface.L, pRectCount, NULL))
            val rectCount = memGetInt(pRectCount)
            if (result == VkResult.SUCCESS && rectCount != 0) {
                rects = st.Rect2D(rectCount)
                VK_CHECK_RESULT(KHRDeviceGroup.nvkGetPhysicalDevicePresentRectanglesKHR(this, surface.L, pRectCount, rects.adr))
            }
        } while (result == VkResult.INCOMPLETE)
        rects as T
    }
    else -> throw Exception("[VkPhysicalDevice::getPresentRectanglesKHR] Invalid T")
}


fun VkPhysicalDevice.getProperties(properties: VkPhysicalDeviceProperties = vk.PhysicalDeviceProperties()): VkPhysicalDeviceProperties =
        properties.also { VK10.nvkGetPhysicalDeviceProperties(this, it.adr) }

inline val VkPhysicalDevice.properties: VkPhysicalDeviceProperties
    get() = getProperties()


fun VkPhysicalDevice.getProperties2(properties: VkPhysicalDeviceProperties2 = vk.PhysicalDeviceProperties2()): VkPhysicalDeviceProperties2 =
        properties.also { VK11.nvkGetPhysicalDeviceProperties2(this, it.adr) }

inline val VkPhysicalDevice.properties2: VkPhysicalDeviceProperties2
    get() = getProperties2()


fun VkPhysicalDevice.getProperties2KHR(properties: VkPhysicalDeviceProperties2 = vk.PhysicalDeviceProperties2()): VkPhysicalDeviceProperties2 =
        properties.also { KHRGetPhysicalDeviceProperties2.nvkGetPhysicalDeviceProperties2KHR(this, it.adr) }

inline val VkPhysicalDevice.properties2KHR: VkPhysicalDeviceProperties2
    get() = getProperties2KHR()


fun VkPhysicalDevice.getQueueFamilyProperties(queueFamilyProperties: VkQueueFamilyProperties.Buffer) =
        stak.intAddress(queueFamilyProperties.rem) {
            VK10.nvkGetPhysicalDeviceQueueFamilyProperties(this, it, queueFamilyProperties.adr)
        }

inline fun <reified T> VkPhysicalDevice.getQueueFamilyProperties(): T = when (T::class) {
    Int::class -> stak.intAddress {
        VK10.nvkGetPhysicalDeviceQueueFamilyProperties(this, it, NULL)
    } as T
//    ArrayList::class -> {
//        val st = stackGet()
//        val pQueueFamilyPropertyCount = st.nmalloc(4, Int.BYTES)
//        VK10.nvkGetPhysicalDeviceQueueFamilyProperties(this, pQueueFamilyPropertyCount, NULL)
//        val count = memGetInt(pQueueFamilyPropertyCount)
//        st.QueueFamilyProperties(count).also {
//            VK10.nvkGetPhysicalDeviceQueueFamilyProperties(this, pQueueFamilyPropertyCount, it.adr)
//        }.toCollection(arrayListOf()) as T
//    }
    VkQueueFamilyProperties.Buffer::class -> {
        val st = stackGet()
        val pQueueFamilyPropertyCount = st.nmalloc(4, Int.BYTES)
        VK10.nvkGetPhysicalDeviceQueueFamilyProperties(this, pQueueFamilyPropertyCount, NULL)
        val count = memGetInt(pQueueFamilyPropertyCount)
        st.QueueFamilyProperties(count).also {
            VK10.nvkGetPhysicalDeviceQueueFamilyProperties(this, pQueueFamilyPropertyCount, it.adr)
        } as T
    }
    else -> throw Exception("[VkPhysicalDevice::getQueueFamilyProperties] Invalid T")
}

inline val VkPhysicalDevice.queueFamilyProperties: VkQueueFamilyProperties.Buffer
    get() = getQueueFamilyProperties()


fun VkPhysicalDevice.getQueueFamilyProperties2(queueFamilyProperties: VkQueueFamilyProperties2.Buffer) =
        stak.intAddress(queueFamilyProperties.rem) {
            VK11.nvkGetPhysicalDeviceQueueFamilyProperties2(this, it, queueFamilyProperties.adr)
        }

inline fun <reified T> VkPhysicalDevice.getQueueFamilyProperties2(): T = when (T::class) {
    Int::class -> stak.intAddress {
        VK11.nvkGetPhysicalDeviceQueueFamilyProperties2(this, it, NULL)
    } as T
//    ArrayList::class -> {
//        val st = stackGet()
//        val pQueueFamilyPropertyCount = st.nmalloc(4, Int.BYTES)
//        VK11.nvkGetPhysicalDeviceQueueFamilyProperties2(this, pQueueFamilyPropertyCount, NULL)
//        val count = memGetInt(pQueueFamilyPropertyCount)
//        st.QueueFamilyProperties2(count).also {
//            VK11.nvkGetPhysicalDeviceQueueFamilyProperties2(this, pQueueFamilyPropertyCount, it.adr)
//        }.toCollection(arrayListOf()) as T
//    }
    VkQueueFamilyProperties2.Buffer::class -> {
        val st = stackGet()
        val pQueueFamilyPropertyCount = st.nmalloc(4, Int.BYTES)
        VK11.nvkGetPhysicalDeviceQueueFamilyProperties2(this, pQueueFamilyPropertyCount, NULL)
        val count = memGetInt(pQueueFamilyPropertyCount)
        st.QueueFamilyProperties(count).also {
            VK11.nvkGetPhysicalDeviceQueueFamilyProperties2(this, pQueueFamilyPropertyCount, it.adr)
        } as T
    }
    else -> throw Exception("[VkPhysicalDevice::getQueueFamilyProperties2] Invalid T")
}

inline val VkPhysicalDevice.queueFamilyProperties2: ArrayList<VkQueueFamilyProperties2>
    get() = getQueueFamilyProperties2()


fun VkPhysicalDevice.getQueueFamilyProperties2KHR(queueFamilyProperties: VkQueueFamilyProperties2.Buffer) =
        stak.intAddress(queueFamilyProperties.rem) {
            KHRGetPhysicalDeviceProperties2.nvkGetPhysicalDeviceQueueFamilyProperties2KHR(this, it, queueFamilyProperties.adr)
        }

inline fun <reified T> VkPhysicalDevice.getQueueFamilyProperties2KHR(): T = when (T::class) {
    Int::class -> stak.intAddress {
        KHRGetPhysicalDeviceProperties2.nvkGetPhysicalDeviceQueueFamilyProperties2KHR(this, it, NULL)
    } as T
//    ArrayList::class -> {
//        val st = stackGet()
//        val pQueueFamilyPropertyCount = st.nmalloc(4, Int.BYTES)
//        KHRGetPhysicalDeviceProperties2.nvkGetPhysicalDeviceQueueFamilyProperties2KHR(this, pQueueFamilyPropertyCount, NULL)
//        val count = memGetInt(pQueueFamilyPropertyCount)
//        st.QueueFamilyProperties2(count).also {
//            KHRGetPhysicalDeviceProperties2.nvkGetPhysicalDeviceQueueFamilyProperties2KHR(this, pQueueFamilyPropertyCount, it.adr)
//        }.toCollection(arrayListOf()) as T
//    }
    VkQueueFamilyProperties.Buffer::class -> {
        val st = stackGet()
        val pQueueFamilyPropertyCount = st.nmalloc(4, Int.BYTES)
        KHRGetPhysicalDeviceProperties2.nvkGetPhysicalDeviceQueueFamilyProperties2KHR(this, pQueueFamilyPropertyCount, NULL)
        val count = memGetInt(pQueueFamilyPropertyCount)
        st.QueueFamilyProperties(count).also {
            KHRGetPhysicalDeviceProperties2.nvkGetPhysicalDeviceQueueFamilyProperties2KHR(this, pQueueFamilyPropertyCount, it.adr)
        } as T
    }
    else -> throw Exception("[VkPhysicalDevice::getQueueFamilyProperties2] Invalid T")
}

inline val VkPhysicalDevice.queueFamilyProperties2KHR: ArrayList<VkQueueFamilyProperties2>
    get() = getQueueFamilyProperties2KHR()


fun VkPhysicalDevice.getSparseImageFormatProperties(format: VkFormat, type: VkImageType, samples: VkSampleCount, usage: VkImageUsageFlags, tiling: VkImageTiling, properties: VkSparseImageFormatProperties.Buffer) =
        stak.intAddress(properties.rem) {
            VK10.nvkGetPhysicalDeviceSparseImageFormatProperties(this, format.i, type.i, samples.i, usage, tiling.i, it, properties.adr)
        }

inline fun <reified T> VkPhysicalDevice.getSparseImageFormatProperties(format: VkFormat, type: VkImageType, samples: VkSampleCount, usage: VkImageUsageFlags, tiling: VkImageTiling): T = when (T::class) {
    Int::class -> stak.intAddress {
        VK10.nvkGetPhysicalDeviceSparseImageFormatProperties(this, format.i, type.i, samples.i, usage, tiling.i, it, NULL)
    } as T
//    ArrayList::class -> {
//        val st = stackGet()
//        val pPropertyCount = st.nmalloc(4, Int.BYTES)
//        VK10.nvkGetPhysicalDeviceSparseImageFormatProperties(this, format.i, type.i, samples.i, usage, tiling.i, pPropertyCount, NULL)
//        val count = memGetInt(pPropertyCount)
//        st.SparseImageFormatProperties(count).also {
//            VK10.nvkGetPhysicalDeviceSparseImageFormatProperties(this, format.i, type.i, samples.i, usage, tiling.i, pPropertyCount, it.adr)
//        }.toCollection(arrayListOf()) as T
//    }
    VkSparseImageFormatProperties.Buffer::class -> {
        val st = stackGet()
        val pPropertyCount = st.nmalloc(4, Int.BYTES)
        VK10.nvkGetPhysicalDeviceSparseImageFormatProperties(this, format.i, type.i, samples.i, usage, tiling.i, pPropertyCount, NULL)
        val count = memGetInt(pPropertyCount)
        st.SparseImageFormatProperties(count).also {
            VK10.nvkGetPhysicalDeviceSparseImageFormatProperties(this, format.i, type.i, samples.i, usage, tiling.i, pPropertyCount, it.adr)
        } as T
    }
    else -> throw Exception("[VkPhysicalDevice::getSparseImageFormatProperties] Invalid T")
}


fun VkPhysicalDevice.getSparseImageFormatProperties2(formatInfo: VkPhysicalDeviceSparseImageFormatInfo2, properties: VkSparseImageFormatProperties2.Buffer) =
        stak.intAddress(properties.rem) {
            VK11.nvkGetPhysicalDeviceSparseImageFormatProperties2(this, formatInfo.adr, it, properties.adr)
        }

inline fun <reified T> VkPhysicalDevice.getSparseImageFormatProperties2(formatInfo: VkPhysicalDeviceSparseImageFormatInfo2): T = when (T::class) {
    Int::class -> stak.intAddress {
        VK11.nvkGetPhysicalDeviceSparseImageFormatProperties2(this, formatInfo.adr, it, NULL)
    } as T
//    ArrayList::class -> {
//        val st = stackGet()
//        val pPropertyCount = st.nmalloc(4, Int.BYTES)
//        VK11.nvkGetPhysicalDeviceSparseImageFormatProperties2(this, formatInfo.adr, pPropertyCount, NULL)
//        val count = memGetInt(pPropertyCount)
//        st.SparseImageFormatProperties2(count).also {
//            VK11.nvkGetPhysicalDeviceSparseImageFormatProperties2(this, formatInfo.adr, pPropertyCount, it.adr)
//        }.toCollection(arrayListOf()) as T
//    }
    VkSparseImageFormatProperties2.Buffer::class -> {
        val st = stackGet()
        val pPropertyCount = st.nmalloc(4, Int.BYTES)
        VK11.nvkGetPhysicalDeviceSparseImageFormatProperties2(this, formatInfo.adr, pPropertyCount, NULL)
        val count = memGetInt(pPropertyCount)
        st.SparseImageFormatProperties2(count).also {
            VK11.nvkGetPhysicalDeviceSparseImageFormatProperties2(this, formatInfo.adr, pPropertyCount, it.adr)
        } as T
    }
    else -> throw Exception("[VkPhysicalDevice::getSparseImageFormatProperties2] Invalid T")
}


fun VkPhysicalDevice.getSparseImageFormatProperties2KHR(formatInfo: VkPhysicalDeviceSparseImageFormatInfo2, properties: VkSparseImageFormatProperties2.Buffer) =
        stak.intAddress(properties.rem) {
            KHRGetPhysicalDeviceProperties2.nvkGetPhysicalDeviceSparseImageFormatProperties2KHR(this, formatInfo.adr, it, properties.adr)
        }

inline infix fun <reified T> VkPhysicalDevice.getSparseImageFormatProperties2KHR(formatInfo: VkPhysicalDeviceSparseImageFormatInfo2): T = when (T::class) {
    Int::class -> stak.intAddress {
        KHRGetPhysicalDeviceProperties2.nvkGetPhysicalDeviceSparseImageFormatProperties2KHR(this, formatInfo.adr, it, NULL)
    } as T
//    ArrayList::class -> {
//        val st = stackGet()
//        val pPropertyCount = st.nmalloc(4, Int.BYTES)
//        KHRGetPhysicalDeviceProperties2.nvkGetPhysicalDeviceSparseImageFormatProperties2KHR(this, formatInfo.adr, pPropertyCount, NULL)
//        val count = memGetInt(pPropertyCount)
//        st.SparseImageFormatProperties2(count).also {
//            KHRGetPhysicalDeviceProperties2.nvkGetPhysicalDeviceSparseImageFormatProperties2KHR(this, formatInfo.adr, pPropertyCount, it.adr)
//        }.toCollection(arrayListOf()) as T
//    }
    VkSparseImageFormatProperties2.Buffer::class -> {
        val st = stackGet()
        val pPropertyCount = st.nmalloc(4, Int.BYTES)
        KHRGetPhysicalDeviceProperties2.nvkGetPhysicalDeviceSparseImageFormatProperties2KHR(this, formatInfo.adr, pPropertyCount, NULL)
        val count = memGetInt(pPropertyCount)
        st.SparseImageFormatProperties2(count).also {
            KHRGetPhysicalDeviceProperties2.nvkGetPhysicalDeviceSparseImageFormatProperties2KHR(this, formatInfo.adr, pPropertyCount, it.adr)
        } as T
    }
    else -> throw Exception("[VkPhysicalDevice::getSparseImageFormatProperties2KHR] Invalid T")
}


fun VkPhysicalDevice.getSurfaceCapabilities2EXT(surface: VkSurfaceKHR, surfaceCapabilities: VkSurfaceCapabilities2EXT): VkResult =
        VkResult(EXTDisplaySurfaceCounter.nvkGetPhysicalDeviceSurfaceCapabilities2EXT(this, surface.L, surfaceCapabilities.adr)).apply { check() }

infix fun VkPhysicalDevice.getSurfaceCapabilities2EXT(surface: VkSurfaceKHR): VkSurfaceCapabilities2EXT =
        vk.SurfaceCapabilities2EXT().also { VK_CHECK_RESULT(EXTDisplaySurfaceCounter.nvkGetPhysicalDeviceSurfaceCapabilities2EXT(this, surface.L, it.adr)) }


fun VkPhysicalDevice.getSurfaceCapabilities2KHR(surfaceInfo: VkPhysicalDeviceSurfaceInfo2KHR, surfaceCapabilities: VkSurfaceCapabilities2KHR): VkResult =
        VkResult(KHRGetSurfaceCapabilities2.nvkGetPhysicalDeviceSurfaceCapabilities2KHR(this, surfaceInfo.adr, surfaceCapabilities.adr)).apply { check() }

infix fun VkPhysicalDevice.getSurfaceCapabilities2KHR(surfaceInfo: VkPhysicalDeviceSurfaceInfo2KHR): VkSurfaceCapabilities2KHR =
        vk.SurfaceCapabilities2KHR().also { VK_CHECK_RESULT(KHRGetSurfaceCapabilities2.nvkGetPhysicalDeviceSurfaceCapabilities2KHR(this, surfaceInfo.adr, it.adr)) }


fun VkPhysicalDevice.getSurfaceCapabilitiesKHR(surface: VkSurfaceKHR, surfaceCapabilities: VkSurfaceCapabilitiesKHR): VkResult =
        VkResult(KHRSurface.nvkGetPhysicalDeviceSurfaceCapabilitiesKHR(this, surface.L, surfaceCapabilities.adr)).apply { check() }

infix fun VkPhysicalDevice.getSurfaceCapabilitiesKHR(surface: VkSurfaceKHR): VkSurfaceCapabilitiesKHR =
        vk.SurfaceCapabilitiesKHR().also { VK_CHECK_RESULT(KHRSurface.nvkGetPhysicalDeviceSurfaceCapabilitiesKHR(this, surface.L, it.adr)) }


fun VkPhysicalDevice.getSurfaceFormats2KHR(surfaceInfo: VkPhysicalDeviceSurfaceInfo2KHR, surfaceFormats: VkSurfaceFormat2KHR.Buffer) =
        stak.intAddress(surfaceFormats.rem) {
            KHRGetSurfaceCapabilities2.nvkGetPhysicalDeviceSurfaceFormats2KHR(this, surfaceInfo.adr, it, surfaceFormats.adr)
        }

inline infix fun <reified T> VkPhysicalDevice.getSurfaceFormats2KHR(surfaceInfo: VkPhysicalDeviceSurfaceInfo2KHR): T = when (T::class) {
    Int::class -> stak.intAddress {
        VK_CHECK_RESULT(KHRGetSurfaceCapabilities2.nvkGetPhysicalDeviceSurfaceFormats2KHR(this, surfaceInfo.adr, it, NULL))
    } as T
    VkSurfaceFormat2KHR.Buffer::class -> {
        val st = stackGet()
        val pSurfaceFormatCount = st.nmalloc(4, Int.BYTES)
        var result: VkResult
        lateinit var surfaceFormats: VkSurfaceFormat2KHR.Buffer
        do {
            result = VkResult(KHRGetSurfaceCapabilities2.nvkGetPhysicalDeviceSurfaceFormats2KHR(this, surfaceInfo.adr, pSurfaceFormatCount, NULL)).apply { check() }
            val propertyCount = memGetInt(pSurfaceFormatCount)
            if (result == VkResult.SUCCESS && propertyCount != 0) {
                surfaceFormats = st.SurfaceFormat2KHR(propertyCount)
                VK_CHECK_RESULT(KHRGetSurfaceCapabilities2.nvkGetPhysicalDeviceSurfaceFormats2KHR(this, surfaceInfo.adr, pSurfaceFormatCount, surfaceFormats.adr))
            }
        } while (result == VkResult.INCOMPLETE)
        surfaceFormats as T
    }
    else -> throw Exception("[VkPhysicalDevice::getSurfaceFormats2KHR] Invalid T")
}


fun VkPhysicalDevice.getSurfaceFormatsKHR(surface: VkSurfaceKHR, surfaceFormats: VkSurfaceFormatKHR.Buffer): VkResult =
        stak.intAddress(surfaceFormats.rem) {
            VkResult(KHRSurface.nvkGetPhysicalDeviceSurfaceFormatsKHR(this, surface.L, it, surfaceFormats.adr)).apply { check() }
        }

inline infix fun <reified T> VkPhysicalDevice.getSurfaceFormatsKHR(surface: VkSurfaceKHR): T = when (T::class) {
    Int::class -> stak.intAddress {
        KHRSurface.nvkGetPhysicalDeviceSurfaceFormatsKHR(this, surface.L, it, NULL)
    } as T
    VkSurfaceFormatKHR.Buffer::class -> {
        val st = stackGet()
        val pSurfaceFormatCount = st.nmalloc(4, Int.BYTES)
        var result: VkResult
        lateinit var surfaceFormats: VkSurfaceFormatKHR.Buffer
        do {
            result = VkResult(KHRSurface.nvkGetPhysicalDeviceSurfaceFormatsKHR(this, surface.L, pSurfaceFormatCount, NULL)).apply { check() }
            val propertyCount = memGetInt(pSurfaceFormatCount)
            if (result == VkResult.SUCCESS && propertyCount != 0) {
                surfaceFormats = st.SurfaceFormatKHR(propertyCount)
                VK_CHECK_RESULT(KHRSurface.nvkGetPhysicalDeviceSurfaceFormatsKHR(this, surface.L, pSurfaceFormatCount, surfaceFormats.adr))
            }
        } while (result == VkResult.INCOMPLETE)
        surfaceFormats as T
    }
    else -> throw Exception("[VkPhysicalDevice::getSurfaceFormatsKHR] Invalid T")
}


fun VkPhysicalDevice.getSurfacePresentModesKHR(surface: VkSurfaceKHR, presentModes: VkPresentModeKHR_Buffer) =
        stak.intAddress(presentModes.rem) {
            KHRSurface.nvkGetPhysicalDeviceSurfacePresentModesKHR(this, surface.L, it, presentModes.adr)
        }

inline infix fun <reified T> VkPhysicalDevice.getSurfacePresentModesKHR(surface: VkSurfaceKHR): T = when (T::class) {
    Int::class -> stak.intAddress {
        KHRSurface.nvkGetPhysicalDeviceSurfacePresentModesKHR(this, surface.L, it, NULL)
    } as T
    VkPresentModeKHR_Buffer::class -> {
        val st = stackGet()
        val pPresentModeCount = st.nmalloc(4, Int.BYTES)
        var result: VkResult
        lateinit var presentModes: IntBuffer
        do {
            result = VkResult(KHRSurface.nvkGetPhysicalDeviceSurfacePresentModesKHR(this, surface.L, pPresentModeCount, NULL))
            val propertyCount = memGetInt(pPresentModeCount)
            if (result == VkResult.SUCCESS && propertyCount != 0) {
                presentModes = st.IntBuffer(propertyCount)
                VK_CHECK_RESULT(KHRSurface.nvkGetPhysicalDeviceSurfacePresentModesKHR(this, surface.L, pPresentModeCount, presentModes.adr))
            }
        } while (result == VkResult.INCOMPLETE)
        VkPresentModeKHR_Buffer(presentModes) as T
    }
    else -> throw Exception("[VkPhysicalDevice::getSurfacePresentModesKHR] Invalid T")
}


fun VkPhysicalDevice.getSurfaceSupportKHR(queueFamilyIndex: Int, surface: VkSurfaceKHR): Boolean =
        stak.intAddress {
            VK_CHECK_RESULT(KHRSurface.nvkGetPhysicalDeviceSurfaceSupportKHR(this, queueFamilyIndex, surface.L, it))
        }.bool

fun VkPhysicalDevice.getSurfaceSupportKHR(queueFamilyIndices: VkQueueFamilyProperties.Buffer, surface: VkSurfaceKHR): BooleanArray =
        BooleanArray(queueFamilyIndices.rem) { i ->
            stak.intAddress {
                VK_CHECK_RESULT(KHRSurface.nvkGetPhysicalDeviceSurfaceSupportKHR(this, i, surface.L, it))
            }.bool
        }

fun VkPhysicalDevice.getSurfaceSupportKHR(queueFamilyIndex: Int, display: WLDisplay): Boolean =
        KHRWaylandSurface.vkGetPhysicalDeviceWaylandPresentationSupportKHR(this, queueFamilyIndex, display.L)

fun VkPhysicalDevice.getSurfaceSupportKHR(queueFamilyIndices: VkQueueFamilyProperties.Buffer, display: WLDisplay): BooleanArray =
        BooleanArray(queueFamilyIndices.rem) { i ->
            KHRWaylandSurface.vkGetPhysicalDeviceWaylandPresentationSupportKHR(this, i, display.L)
        }

infix fun VkPhysicalDevice.getWin32PresentationSupportKHR(queueFamilyIndex: Int): Boolean =
        KHRWin32Surface.vkGetPhysicalDeviceWin32PresentationSupportKHR(this, queueFamilyIndex)


fun VkPhysicalDevice.getXlibPresentationSupportKHR(queueFamilyIndex: Int, dpy: Display, visualID: VisualID): Boolean =
        KHRXlibSurface.vkGetPhysicalDeviceXlibPresentationSupportKHR(this, queueFamilyIndex, dpy.L, visualID.L)


fun VkPhysicalDevice.getRandROutputDisplayEXT(dpy: Display, rrOutput: RROutput): VkDisplayKHR =
        VkDisplayKHR(stak.longAddress {
            EXTAcquireXlibDisplay.nvkGetRandROutputDisplayEXT(this, dpy.L, rrOutput.L, it)
        })


fun VkPhysicalDevice.releaseDisplayEXT(display: VkDisplayKHR): VkResult =
        VkResult(EXTDirectModeDisplay.vkReleaseDisplayEXT(this, display.L)).apply { check() }