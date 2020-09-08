package tests

import glm_.glm
import glm_.vec2.Vec2i
import io.kotest.core.spec.style.StringSpec
import main.isNotCI
import uno.createSurface
import uno.glfw.GlfwWindow
import uno.glfw.glfw
import uno.glfw.windowHint.Api
import uno.requiredInstanceExtensions
import unsigned.Uint
import vkk.*
import vkk.entities.VkImage
import vkk.extensions.*
import vkk.unique.`try`
import vkk.unique.vu
import vkk.vk10.structs.ComponentMapping
import vkk.vk10.structs.Extent2D
import vkk.vk10.structs.ImageSubresourceRange
import vkk.vk10.structs.ImageViewCreateInfo

class `05 initSwapchain` : StringSpec() {

    val appName = "05_InitSwapchain"

    init {
        if (isNotCI)
            appName {
                `try` {
                    glfw.init(installDefaultErrorCallback = true)
                    val instance = vu.createInstance(appName, engineName, extensions = glfw.requiredInstanceExtensions)
//                    if(DEBUG)
//                    vk::UniqueDebugUtilsMessengerEXT debugUtilsMessenger = vk::su::createDebugUtilsMessenger(instance)

                    val physicalDevice = instance.physicalDevices[0]

                    val queueFamilyProperties = physicalDevice.queueFamilyProperties
                    var graphicsQueueFamilyIndex = vu.findGraphicsQueueFamilyIndex(queueFamilyProperties)

                    /* VULKAN_HPP_KEY_START */

                    val size = Vec2i(64)
                    glfw.windowHint { api = Api.None }
                    val window = GlfwWindow(size, appName)
                    val surface = instance.createSurface(window).also { this.disposes += { instance destroy it; println("surface destroyed") } }

                    // determine a queueFamilyIndex that supports present
                    // first check if the graphicsQueueFamiliyIndex is good enough
                    var presentQueueFamilyIndex = when {
                        physicalDevice.getSurfaceSupportKHR(graphicsQueueFamilyIndex, surface) -> graphicsQueueFamilyIndex
                        else -> queueFamilyProperties.size
                    }
                    if (presentQueueFamilyIndex == queueFamilyProperties.size) {
                        // the graphicsQueueFamilyIndex doesn't support present -> look for an other family index that supports both graphics and present
                        for (i in queueFamilyProperties.indices)
                            if (queueFamilyProperties[i].queueFlags has VkQueueFlag.GRAPHICS_BIT && physicalDevice.getSurfaceSupportKHR(i, surface)) {
                                graphicsQueueFamilyIndex = i
                                presentQueueFamilyIndex = i
                                break
                            }
                        // there's nothing like a single family index that supports both graphics and present -> look for an other family index that supports present
                        if (presentQueueFamilyIndex == queueFamilyProperties.size)
                            for (i in queueFamilyProperties.indices) {
                                if (physicalDevice.getSurfaceSupportKHR(i, surface)) {
                                    presentQueueFamilyIndex = i
                                    break
                                }
                            }
                    }
                    if (graphicsQueueFamilyIndex == queueFamilyProperties.size || presentQueueFamilyIndex == queueFamilyProperties.size)
                        error("Could not find a queue for graphics or present -> terminating")

                    // create a device
                    val device = vu.createDevice(physicalDevice, graphicsQueueFamilyIndex, vu.deviceExtensions)

                    // get the supported VkFormats
                    val formats = physicalDevice getSurfaceFormatsKHR surface
                    assert(formats.isNotEmpty())
                    val format = formats[0].format.takeIf { it != VkFormat.UNDEFINED } ?: VkFormat.B8G8R8A8_UNORM

                    val surfaceCapabilities = physicalDevice.getSurfaceCapabilitiesKHR(surface)
                    val swapchainExtent = when {
                        // If the surface size is undefined, the size is set to the size of the images requested.
                        surfaceCapabilities.currentExtent.width == Uint.MAX.v -> Extent2D(
                                glm.clamp(size.x, surfaceCapabilities.minImageExtent.width, surfaceCapabilities.maxImageExtent.width),
                                glm.clamp(size.y, surfaceCapabilities.minImageExtent.height, surfaceCapabilities.maxImageExtent.height))
                        // If the surface size is defined, the swap chain size must match
                        else -> Extent2D(surfaceCapabilities.currentExtent)
                    }

                    // The FIFO present mode is guaranteed by the spec to be supported
                    val swapchainPresentMode = VkPresentModeKHR.FIFO

                    val preTransform = when {
                        surfaceCapabilities.supportedTransforms has VkSurfaceTransformKHR.IDENTITY_BIT -> VkSurfaceTransformKHR.IDENTITY_BIT
                        else -> surfaceCapabilities.currentTransform
                    }

                    val compositeAlpha = surfaceCapabilities.supportedCompositeAlpha.let {
                        when {
                            it has VkCompositeAlphaKHR.PRE_MULTIPLIED_BIT -> VkCompositeAlphaKHR.PRE_MULTIPLIED_BIT
                            it has VkCompositeAlphaKHR.POST_MULTIPLIED_BIT -> VkCompositeAlphaKHR.POST_MULTIPLIED_BIT
                            it has VkCompositeAlphaKHR.INHERIT_BIT -> VkCompositeAlphaKHR.INHERIT_BIT
                            else -> VkCompositeAlphaKHR.OPAQUE_BIT
                        }
                    }

                    val swapChainCreateInfo = SwapchainCreateInfoKHR(0, surface, surfaceCapabilities.minImageCount, format,
                            VkColorSpaceKHR.SRGB_NONLINEAR_KHR, swapchainExtent, 1, VkImageUsage.COLOR_ATTACHMENT_BIT.i,
                            VkSharingMode.EXCLUSIVE, null, preTransform, compositeAlpha, swapchainPresentMode, true)

                    val queueFamilyIndices = intArrayOf(graphicsQueueFamilyIndex, presentQueueFamilyIndex)
                    if (graphicsQueueFamilyIndex != presentQueueFamilyIndex) {
                        // If the graphics and present queues are from different queue families, we either have to explicitly transfer ownership of images between
                        // the queues, or we have to create the swapchain with imageSharingMode as VK_SHARING_MODE_CONCURRENT
                        swapChainCreateInfo.imageSharingMode = VkSharingMode.CONCURRENT
                        swapChainCreateInfo.queueFamilyIndices = queueFamilyIndices
                    }

                    val swapChain = device.createSwapchainKHRUnique(swapChainCreateInfo)
// TODO
//                    val swapChainImages = device getSwapchainImagesKHR swapChain
//
//                    val componentMapping = ComponentMapping()
//                    val subResourceRange = ImageSubresourceRange(VkImageAspect.COLOR_BIT.i, 0, 1, 0, 1)
//                    val imageViewCreateInfo = ImageViewCreateInfo(0, VkImage.NULL, VkImageViewType._2D, format, componentMapping, subResourceRange)
//                    val imageViews = device.createImageViewArrayUnique(imageViewCreateInfo, swapChainImages)

                    // Note: No need to explicitly destroy the ImageViews or the swapChain, as the corresponding destroy
                    // functions are called by the destructor of the UniqueImageView and the UniqueSwapChainKHR on leaving this scope.

                    /* VULKAN_HPP_KEY_END */
                }
            }
    }
}