package tests

import gli_.has
import io.kotest.core.spec.style.StringSpec
import main.isNotCI
import uno.glfw.glfw
import uno.requiredInstanceExtensions
import vkk.*
import vkk.unique.`try`
import vkk.unique.vu
import vkk.vk10.structs.*

class `06 initDepthBuffer` : StringSpec() {
    val appName = "06_InitDepthBuffer"

    init {
        if (isNotCI)
            appName {
                `try` {
                    glfw.init(installDefaultErrorCallback = true)
                    val instance = vu.createInstance(appName, engineName, extensions = glfw.requiredInstanceExtensions)
//                    if(DEBUG)
//                    vk::UniqueDebugUtilsMessengerEXT debugUtilsMessenger = vk ::su::createDebugUtilsMessenger(instance)

                    val physicalDevice = instance.physicalDevices[0]

                    val surfaceData = createSurfaceData(instance, appName, Extent2D(500))

                    val (graphicsQueueFamilyIndex, _) = vu.findGraphicsAndPresentQueueFamilyIndex(physicalDevice, surfaceData.surface)
                    val device = vu.createDevice(physicalDevice, graphicsQueueFamilyIndex, vu.deviceExtensions)

                    /* VULKAN_HPP_KEY_START */

                    val depthFormat = VkFormat.D16_UNORM
                    val formatProperties = physicalDevice getFormatProperties depthFormat

                    val tiling = when {
                        formatProperties.linearTilingFeatures has VkFormatFeature.DEPTH_STENCIL_ATTACHMENT_BIT -> VkImageTiling.LINEAR
                        formatProperties.optimalTilingFeatures has VkFormatFeature.DEPTH_STENCIL_ATTACHMENT_BIT -> VkImageTiling.OPTIMAL
                        else -> error("DepthStencilAttachment is not supported for D16Unorm depth format.")
                    }
                    val imageCreateInfo = ImageCreateInfo(0, VkImageType._2D, depthFormat, Extent3D(surfaceData.extent, 1), 1, 1, VkSampleCount._1_BIT, tiling, VkImageUsage.DEPTH_STENCIL_ATTACHMENT_BIT.i)
                    val depthImage = device createImageUnique imageCreateInfo

                    val memoryProperties = physicalDevice.memoryProperties
                    val memoryRequirements = device getImageMemoryRequirements depthImage
                    var typeBits = memoryRequirements.memoryTypeBits
                    var typeIndex = -1
                    for (i in memoryProperties.memoryTypes.indices)                    {
                        if (typeBits has 1 && (memoryProperties.memoryTypes[i].propertyFlags and VkMemoryProperty.DEVICE_LOCAL_BIT.i) == VkMemoryProperty.DEVICE_LOCAL_BIT.i) {
                            typeIndex = i
                            break
                        }
                        typeBits = typeBits ushr 1
                    }
                    assert(typeIndex != -1)
                    val depthMemory = device allocateMemoryUnique MemoryAllocateInfo(memoryRequirements.size, typeIndex)

                    device.bindImageMemory(depthImage, depthMemory)

                    val componentMapping = ComponentMapping()
                    val subResourceRange = ImageSubresourceRange(VkImageAspect.DEPTH_BIT.i, 0, 1, 0, 1)
                    val depthView = device.createImageViewUnique(ImageViewCreateInfo(0, depthImage, VkImageViewType._2D, depthFormat, componentMapping, subResourceRange))

                    /* VULKAN_HPP_KEY_END */
                }
            }
    }
}