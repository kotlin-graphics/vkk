package vkk

import glm_.*
import glm_.vec2.Vec2i
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.system.Pointer
import org.lwjgl.system.Struct
import org.lwjgl.vulkan.*
import org.lwjgl.vulkan.VK10.VK_QUEUE_FAMILY_IGNORED
import org.lwjgl.vulkan.VK10.vkCreateImage
import vkk.VkPhysicalDeviceArrayList.resize
import vkk.appBuffer.ptr
import java.nio.ByteBuffer
import java.nio.LongBuffer
import kotlin.reflect.KMutableProperty0


object vk {

    /*
        *Info constructor functions
     */

    inline fun ApplicationInfo(block: VkApplicationInfo.() -> Unit): VkApplicationInfo {
        val res = VkApplicationInfo.create(ptr.advance(VkApplicationInfo.SIZEOF))
        res.type = VkStructureType.APPLICATION_INFO
        res.block()
        return res
    }

    inline fun BufferCreateInfo(block: VkBufferCreateInfo.() -> Unit): VkBufferCreateInfo {
        val res = VkBufferCreateInfo.create(ptr.advance(VkBufferCreateInfo.SIZEOF))
        res.type = VkStructureType.BUFFER_CREATE_INFO
        res.block()
        return res
    }

    inline fun BufferMemoryBarrier(block: VkBufferMemoryBarrier.() -> Unit): VkBufferMemoryBarrier {
        val res = VkBufferMemoryBarrier.create(ptr.advance(VkBufferMemoryBarrier.SIZEOF))
        res.type = VkStructureType.BUFFER_MEMORY_BARRIER
        res.block()
        return res
    }

    inline fun CommandBufferAllocateInfo(commandPool: VkCommandPool, level: VkCommandBufferLevel, bufferCount: Int): VkCommandBufferAllocateInfo {
        return CommandBufferAllocateInfo {
            this.commandPool = commandPool
            this.level = level
            commandBufferCount = bufferCount
        }
    }

    inline fun CommandBufferAllocateInfo(block: VkCommandBufferAllocateInfo.() -> Unit): VkCommandBufferAllocateInfo {
        val res = VkCommandBufferAllocateInfo.create(ptr.advance(VkCommandBufferAllocateInfo.SIZEOF))
        res.type = VkStructureType.COMMAND_BUFFER_ALLOCATE_INFO
        res.block()
        return res
    }

    inline fun CommandBufferBeginInfo(): VkCommandBufferBeginInfo {
        val res = VkCommandBufferBeginInfo.create(ptr.advance(VkCommandBufferBeginInfo.SIZEOF))
        res.type = VkStructureType.COMMAND_BUFFER_BEGIN_INFO
        return res
    }

    inline fun CommandBufferBeginInfo(block: VkCommandBufferBeginInfo.() -> Unit): VkCommandBufferBeginInfo {
        val res = CommandBufferBeginInfo()
        res.block()
        return res
    }

    inline fun CommandPoolCreateInfo(block: VkCommandPoolCreateInfo.() -> Unit): VkCommandPoolCreateInfo {
        val res = VkCommandPoolCreateInfo.create(ptr.advance(VkCommandPoolCreateInfo.SIZEOF))
        res.type = VkStructureType.COMMAND_POOL_CREATE_INFO
        res.block()
        return res
    }

    inline fun ComputePipelineCreateInfo(block: VkComputePipelineCreateInfo.() -> Unit): VkComputePipelineCreateInfo {
        val res = VkComputePipelineCreateInfo.create(ptr.advance(VkComputePipelineCreateInfo.SIZEOF))
        res.type = VkStructureType.COMPUTE_PIPELINE_CREATE_INFO
        res.block()
        return res
    }

    inline fun DebugReportCallbackCreateInfoEXT(block: VkDebugReportCallbackCreateInfoEXT.() -> Unit): VkDebugReportCallbackCreateInfoEXT {
        val res = VkDebugReportCallbackCreateInfoEXT.create(ptr.advance(VkDebugReportCallbackCreateInfoEXT.SIZEOF))
        res.type = VkStructureType.DEBUG_REPORT_CALLBACK_CREATE_INFO_EXT
        res.block()
        return res
    }

    inline fun DescriptorBufferInfo(block: VkDescriptorBufferInfo.() -> Unit): VkDescriptorBufferInfo {
        val res = VkDescriptorBufferInfo.create(ptr.advance(VkDescriptorBufferInfo.SIZEOF))
        res.block()
        return res
    }

    inline fun DescriptorBufferInfo(capacity: Int, block: VkDescriptorBufferInfo.() -> Unit): VkDescriptorBufferInfo.Buffer {
        val res = VkDescriptorBufferInfo.create(ptr.advance(VkDescriptorBufferInfo.SIZEOF * capacity), capacity)
        res[0].block()
        return res
    }

    inline fun DescriptorPoolCreateInfo(block: VkDescriptorPoolCreateInfo.() -> Unit): VkDescriptorPoolCreateInfo {
        val res = VkDescriptorPoolCreateInfo.create(ptr.advance(VkDescriptorPoolCreateInfo.SIZEOF))
        res.type = VkStructureType.DESCRIPTOR_POOL_CREATE_INFO
        res.block()
        return res
    }

    inline fun DescriptorSetAllocateInfo(block: VkDescriptorSetAllocateInfo.() -> Unit): VkDescriptorSetAllocateInfo {
        val res = VkDescriptorSetAllocateInfo.create(ptr.advance(VkDescriptorSetAllocateInfo.SIZEOF))
        res.type = VkStructureType.DESCRIPTOR_SET_ALLOCATE_INFO
        res.block()
        return res
    }

    inline fun DescriptorSetLayoutCreateInfo(block: VkDescriptorSetLayoutCreateInfo.() -> Unit): VkDescriptorSetLayoutCreateInfo {
        val res = VkDescriptorSetLayoutCreateInfo.create(ptr.advance(VkDescriptorSetLayoutCreateInfo.SIZEOF))
        res.type = VkStructureType.DESCRIPTOR_SET_LAYOUT_CREATE_INFO
        res.block()
        return res
    }

    inline fun DeviceCreateInfo(block: VkDeviceCreateInfo.() -> Unit): VkDeviceCreateInfo {
        val res = VkDeviceCreateInfo.create(ptr.advance(VkDeviceCreateInfo.SIZEOF))
        res.type = VkStructureType.DEVICE_CREATE_INFO
        res.block()
        return res
    }

    inline fun DeviceQueueCreateInfo(): VkDeviceQueueCreateInfo {
        return VkDeviceQueueCreateInfo.create(ptr.advance(VkDeviceQueueCreateInfo.SIZEOF)).apply {
            type = VkStructureType.DEVICE_QUEUE_CREATE_INFO
        }
    }

    inline fun DeviceQueueCreateInfo(block: VkDeviceQueueCreateInfo.() -> Unit): VkDeviceQueueCreateInfo {
        return DeviceQueueCreateInfo().also(block)
    }

    inline fun DeviceQueueCreateInfo(capacity: Int, block: VkDeviceQueueCreateInfo.() -> Unit): VkDeviceQueueCreateInfo.Buffer {
        val res = VkDeviceQueueCreateInfo.create(ptr.advance(VkDeviceQueueCreateInfo.SIZEOF * capacity), capacity)
        for (b in res)
            b.type = VkStructureType.DEVICE_QUEUE_CREATE_INFO
        res[0].block()
        return res
    }

    inline fun FenceCreateInfo(block: VkFenceCreateInfo.() -> Unit): VkFenceCreateInfo {
        val res = VkFenceCreateInfo.create(ptr.advance(VkFenceCreateInfo.SIZEOF))
        res.type = VkStructureType.FENCE_CREATE_INFO
        res.block()
        return res
    }

    inline fun FramebufferCreateInfo(block: VkFramebufferCreateInfo.() -> Unit): VkFramebufferCreateInfo {
        val res = VkFramebufferCreateInfo.create(ptr.advance(VkFramebufferCreateInfo.SIZEOF))
        res.type = VkStructureType.FRAMEBUFFER_CREATE_INFO
        res.block()
        return res
    }

    inline fun GraphicsPipelineCreateInfo(block: VkGraphicsPipelineCreateInfo.() -> Unit): VkGraphicsPipelineCreateInfo {
        val res = VkGraphicsPipelineCreateInfo.create(ptr.advance(VkGraphicsPipelineCreateInfo.SIZEOF))
        res.type = VkStructureType.GRAPHICS_PIPELINE_CREATE_INFO
        res.block()
        return res
    }

    inline fun GraphicsPipelineCreateInfo(capacity: Int, block: VkGraphicsPipelineCreateInfo.() -> Unit): VkGraphicsPipelineCreateInfo.Buffer {
        val res = VkGraphicsPipelineCreateInfo.create(ptr.advance(VkGraphicsPipelineCreateInfo.SIZEOF * capacity), capacity)
        res.forEach { it.type = VkStructureType.GRAPHICS_PIPELINE_CREATE_INFO }
        res[0].block()
        return res
    }

    inline fun ImageCreateInfo(block: VkImageCreateInfo.() -> Unit): VkImageCreateInfo {
        val res = VkImageCreateInfo.create(ptr.advance(VkImageCreateInfo.SIZEOF))
        res.type = VkStructureType.IMAGE_CREATE_INFO
        res.block()
        return res
    }

    inline fun ImageMemoryBarrier(block: VkImageMemoryBarrier.() -> Unit): VkImageMemoryBarrier {
        val res = VkImageMemoryBarrier.create(ptr.advance(VkImageMemoryBarrier.SIZEOF))
        res.type = VkStructureType.IMAGE_MEMORY_BARRIER
        res.srcQueueFamilyIndex = VK_QUEUE_FAMILY_IGNORED
        res.dstQueueFamilyIndex = VK_QUEUE_FAMILY_IGNORED
        res.block()
        return res
    }

    inline fun ImageMemoryBarrier(capacity: Int, block: VkImageMemoryBarrier.() -> Unit): VkImageMemoryBarrier.Buffer {
        val res = VkImageMemoryBarrier.create(ptr.advance(VkImageMemoryBarrier.SIZEOF * capacity), capacity)
        for (i in res)
            i.type = VkStructureType.IMAGE_MEMORY_BARRIER
        res[0].block()
        return res
    }

    inline fun ImageViewCreateInfo(block: VkImageViewCreateInfo.() -> Unit): VkImageViewCreateInfo {
        val res = VkImageViewCreateInfo.create(ptr.advance(VkImageViewCreateInfo.SIZEOF))
        res.type = VkStructureType.IMAGE_VIEW_CREATE_INFO
        res.block()
        return res
    }

    inline fun InstanceCreateInfo(): VkInstanceCreateInfo {
        return VkInstanceCreateInfo.create(ptr.advance(VkInstanceCreateInfo.SIZEOF)).apply {
            type = VkStructureType.INSTANCE_CREATE_INFO
        }
    }

    inline fun InstanceCreateInfo(block: VkInstanceCreateInfo.() -> Unit): VkInstanceCreateInfo {
        return InstanceCreateInfo().also(block)
    }

    inline fun MappedMemoryRange(): VkMappedMemoryRange {
        return VkMappedMemoryRange.create(ptr.advance(VkMappedMemoryRange.SIZEOF)).apply {
            type = VkStructureType.MAPPED_MEMORY_RANGE
        }
    }

    inline fun MappedMemoryRange(capacity: Int): VkMappedMemoryRange.Buffer {
        return VkMappedMemoryRange.create(ptr.advance(VkMappedMemoryRange.SIZEOF * capacity), capacity).apply {
            for (range in this)
                range.type = VkStructureType.MAPPED_MEMORY_RANGE
        }
    }

    inline fun MappedMemoryRange(block: VkMappedMemoryRange.() -> Unit): VkMappedMemoryRange {
        return MappedMemoryRange().also(block)
    }

    inline fun MemoryAllocateInfo(block: VkMemoryAllocateInfo.() -> Unit): VkMemoryAllocateInfo {
        val res = VkMemoryAllocateInfo.create(ptr.advance(VkMemoryAllocateInfo.SIZEOF))
        res.type = VkStructureType.MEMORY_ALLOCATE_INFO
        res.block()
        return res
    }

    inline fun PhysicalDeviceFeatures(block: VkPhysicalDeviceFeatures.() -> Unit): VkPhysicalDeviceFeatures {
        val res = VkPhysicalDeviceFeatures.create(ptr.advance(VkPhysicalDeviceFeatures.SIZEOF))
        res.block()
        return res
    }

    inline fun PhysicalDeviceMemoryProperties(): VkPhysicalDeviceMemoryProperties {
        return VkPhysicalDeviceMemoryProperties.create(ptr.advance(VkPhysicalDeviceMemoryProperties.SIZEOF))
    }

    inline fun PhysicalDeviceProperties(): VkPhysicalDeviceProperties {
        return VkPhysicalDeviceProperties.create(ptr.advance(VkPhysicalDeviceProperties.SIZEOF))
    }

    inline fun PipelineCacheCreateInfo(block: VkPipelineCacheCreateInfo.() -> Unit): VkPipelineCacheCreateInfo {
        val res = VkPipelineCacheCreateInfo.create(ptr.advance(VkPipelineCacheCreateInfo.SIZEOF))
        res.type = VkStructureType.PIPELINE_CACHE_CREATE_INFO
        res.block()
        return res
    }

    inline fun PipelineColorBlendStateCreateInfo(block: VkPipelineColorBlendStateCreateInfo.() -> Unit): VkPipelineColorBlendStateCreateInfo {
        val res = VkPipelineColorBlendStateCreateInfo.create(ptr.advance(VkPipelineColorBlendStateCreateInfo.SIZEOF))
        res.type = VkStructureType.PIPELINE_COLOR_BLEND_STATE_CREATE_INFO
        res.block()
        return res
    }

    inline fun PipelineDepthStencilStateCreateInfo(): VkPipelineDepthStencilStateCreateInfo {
        return VkPipelineDepthStencilStateCreateInfo.create(ptr.advance(VkPipelineDepthStencilStateCreateInfo.SIZEOF)).apply {
            type = VkStructureType.PIPELINE_DEPTH_STENCIL_STATE_CREATE_INFO
        }
    }

    inline fun PipelineDepthStencilStateCreateInfo(block: VkPipelineDepthStencilStateCreateInfo.() -> Unit): VkPipelineDepthStencilStateCreateInfo {
        return PipelineDepthStencilStateCreateInfo().also(block)
    }

    inline fun PipelineDynamicStateCreateInfo(block: VkPipelineDynamicStateCreateInfo.() -> Unit): VkPipelineDynamicStateCreateInfo {
        val res = VkPipelineDynamicStateCreateInfo.create(ptr.advance(VkPipelineDynamicStateCreateInfo.SIZEOF))
        res.type = VkStructureType.PIPELINE_DYNAMIC_STATE_CREATE_INFO
        res.block()
        return res
    }

    inline fun PipelineInputAssemblyStateCreateInfo(block: VkPipelineInputAssemblyStateCreateInfo.() -> Unit): VkPipelineInputAssemblyStateCreateInfo {
        val res = VkPipelineInputAssemblyStateCreateInfo.create(ptr.advance(VkPipelineInputAssemblyStateCreateInfo.SIZEOF))
        res.type = VkStructureType.PIPELINE_INPUT_ASSEMBLY_STATE_CREATE_INFO
        res.block()
        return res
    }

    inline fun PipelineLayoutCreateInfo(block: VkPipelineLayoutCreateInfo.() -> Unit): VkPipelineLayoutCreateInfo {
        val res = VkPipelineLayoutCreateInfo.create(ptr.advance(VkPipelineLayoutCreateInfo.SIZEOF))
        res.type = VkStructureType.PIPELINE_LAYOUT_CREATE_INFO
        res.block()
        return res
    }

    inline fun PipelineMultisampleStateCreateInfo(block: VkPipelineMultisampleStateCreateInfo.() -> Unit): VkPipelineMultisampleStateCreateInfo {
        val res = VkPipelineMultisampleStateCreateInfo.create(ptr.advance(VkPipelineMultisampleStateCreateInfo.SIZEOF))
        res.type = VkStructureType.PIPELINE_MULTISAMPLE_STATE_CREATE_INFO
        res.block()
        return res
    }

    inline fun PipelineRasterizationStateCreateInfo(block: VkPipelineRasterizationStateCreateInfo.() -> Unit): VkPipelineRasterizationStateCreateInfo {
        val res = VkPipelineRasterizationStateCreateInfo.create(ptr.advance(VkPipelineRasterizationStateCreateInfo.SIZEOF))
        res.type = VkStructureType.PIPELINE_RASTERIZATION_STATE_CREATE_INFO
        res.block()
        return res
    }

    inline fun PipelineShaderStageCreateInfo(capacity: Int): VkPipelineShaderStageCreateInfo.Buffer {
        val res = VkPipelineShaderStageCreateInfo.create(ptr.advance(VkPipelineShaderStageCreateInfo.SIZEOF * capacity), capacity)
        for (info in res)
            info.type = VkStructureType.PIPELINE_SHADER_STAGE_CREATE_INFO
        return res
    }

    inline fun PipelineVertexInputStateCreateInfo(block: VkPipelineVertexInputStateCreateInfo.() -> Unit): VkPipelineVertexInputStateCreateInfo {
        val res = VkPipelineVertexInputStateCreateInfo.create(ptr.advance(VkPipelineVertexInputStateCreateInfo.SIZEOF))
        res.type = VkStructureType.PIPELINE_VERTEX_INPUT_STATE_CREATE_INFO
        res.block()
        return res
    }

    inline fun PipelineViewportStateCreateInfo(block: VkPipelineViewportStateCreateInfo.() -> Unit): VkPipelineViewportStateCreateInfo {
        val res = VkPipelineViewportStateCreateInfo.create(ptr.advance(VkPipelineViewportStateCreateInfo.SIZEOF))
        res.type = VkStructureType.PIPELINE_VIEWPORT_STATE_CREATE_INFO
        res.block()
        return res
    }

    inline fun PushConstantRange(block: VkPushConstantRange.() -> Unit): VkPushConstantRange {
        val res = VkPushConstantRange.create(ptr.advance(VkPushConstantRange.SIZEOF))
        res.block()
        return res
    }

    inline fun PushConstantRange(capacity: Int, block: VkPushConstantRange.() -> Unit): VkPushConstantRange.Buffer {
        val res = VkPushConstantRange.create(ptr.advance(VkPushConstantRange.SIZEOF * capacity), capacity)
        res[0].block()
        return res
    }

    inline fun PresentInfoKHR(block: VkPresentInfoKHR.() -> Unit): VkPresentInfoKHR {
        val res = VkPresentInfoKHR.create(ptr.advance(VkPresentInfoKHR.SIZEOF))
        res.type = VkStructureType.PRESENT_INFO_KHR
        res.block()
        return res
    }

    inline fun RenderPassBeginInfo(block: VkRenderPassBeginInfo.() -> Unit): VkRenderPassBeginInfo {
        val res = VkRenderPassBeginInfo.create(ptr.advance(VkRenderPassBeginInfo.SIZEOF))
        res.type = VkStructureType.RENDER_PASS_BEGIN_INFO
        res.block()
        return res
    }

    inline fun RenderPassCreateInfo(): VkRenderPassCreateInfo {
        return VkRenderPassCreateInfo.create(ptr.advance(VkRenderPassCreateInfo.SIZEOF)).apply {
            type = VkStructureType.RENDER_PASS_CREATE_INFO
        }
    }

    inline fun RenderPassCreateInfo(block: VkRenderPassCreateInfo.() -> Unit): VkRenderPassCreateInfo {
        return RenderPassCreateInfo().also(block)
    }

    inline fun SamplerCreateInfo(block: VkSamplerCreateInfo.() -> Unit): VkSamplerCreateInfo {
        val res = VkSamplerCreateInfo.create(ptr.advance(VkSamplerCreateInfo.SIZEOF))
        res.type = VkStructureType.SAMPLER_CREATE_INFO
        res.maxAnisotropy = 1f
        res.block()
        return res
    }

    inline fun SemaphoreCreateInfo(): VkSemaphoreCreateInfo {
        return VkSemaphoreCreateInfo.create(ptr.advance(VkSemaphoreCreateInfo.SIZEOF)).apply {
            type = VkStructureType.SEMAPHORE_CREATE_INFO
        }
    }

    inline fun SemaphoreCreateInfo(block: VkSemaphoreCreateInfo.() -> Unit): VkSemaphoreCreateInfo {
        return SemaphoreCreateInfo().also(block)
    }

    inline fun ShaderModuleCreateInfo(block: VkShaderModuleCreateInfo.() -> Unit): VkShaderModuleCreateInfo {
        val res = VkShaderModuleCreateInfo.create(ptr.advance(VkShaderModuleCreateInfo.SIZEOF))
        res.type = VkStructureType.SHADER_MODULE_CREATE_INFO
        res.block()
        return res
    }

    inline fun SubmitInfo(block: VkSubmitInfo.() -> Unit): VkSubmitInfo {
        val res = VkSubmitInfo.create(ptr.advance(VkSubmitInfo.SIZEOF))
        res.type = VkStructureType.SUBMIT_INFO
        res.block()
        return res
    }

    inline fun SwapchainCreateInfoKHR(block: VkSwapchainCreateInfoKHR.() -> Unit): VkSwapchainCreateInfoKHR {
        val res = VkSwapchainCreateInfoKHR.create(ptr.advance(VkSwapchainCreateInfoKHR.SIZEOF))
        res.type = VkStructureType.SWAPCHAIN_CREATE_INFO_KHR
        res.block()
        return res
    }

    inline fun WriteDescriptorSet(block: VkWriteDescriptorSet.() -> Unit): VkWriteDescriptorSet {
        val res = VkWriteDescriptorSet.create(ptr.advance(VkWriteDescriptorSet.SIZEOF)).also(block)
        res.type = VkStructureType.WRITE_DESCRIPTOR_SET
        return res
    }

    inline fun WriteDescriptorSet(capacity: Int): VkWriteDescriptorSet.Buffer {
        val res = VkWriteDescriptorSet.create(ptr.advance(VkWriteDescriptorSet.SIZEOF * capacity), capacity)
        for (set in res)
            set.type = VkStructureType.WRITE_DESCRIPTOR_SET
        return res
    }

    inline fun WriteDescriptorSet(capacity: Int, block: VkWriteDescriptorSet.Buffer.() -> Unit): VkWriteDescriptorSet.Buffer = WriteDescriptorSet(capacity).also(block)

    inline fun DescriptorImageInfo(capacity: Int): VkDescriptorImageInfo.Buffer {
        return VkDescriptorImageInfo.create(ptr.advance(VkDescriptorImageInfo.SIZEOF * capacity), capacity)
    }

    inline fun DescriptorImageInfo(block: VkDescriptorImageInfo.() -> Unit): VkDescriptorImageInfo {
        return VkDescriptorImageInfo.create(ptr.advance(VkDescriptorImageInfo.SIZEOF)).also(block)
    }

    inline fun DescriptorImageInfo(capacity: Int, block: VkDescriptorImageInfo.() -> Unit): VkDescriptorImageInfo.Buffer = DescriptorImageInfo(capacity).also { it[0].block() }


    /*
        normal constructor functions
     */

    inline fun AttachmentDescription(): VkAttachmentDescription = VkAttachmentDescription.create(ptr.advance(VkAttachmentDescription.SIZEOF))
    inline fun AttachmentDescription(capacity: Int): VkAttachmentDescription.Buffer = VkAttachmentDescription.create(ptr.advance(VkAttachmentDescription.SIZEOF * capacity), capacity)
    inline fun AttachmentDescription(block: VkAttachmentDescription.() -> Unit): VkAttachmentDescription = AttachmentDescription().also(block)

    inline fun AttachmentReference(): VkAttachmentReference = VkAttachmentReference.create(ptr.advance(VkAttachmentReference.SIZEOF))
    inline fun AttachmentReference(block: VkAttachmentReference.() -> Unit): VkAttachmentReference = AttachmentReference().also(block)
    inline fun AttachmentReference(capacity: Int): VkAttachmentReference.Buffer = VkAttachmentReference.create(ptr.advance(VkAttachmentReference.SIZEOF * capacity), capacity)
    inline fun AttachmentReference(capacity: Int, block: VkAttachmentReference.() -> Unit): VkAttachmentReference.Buffer = AttachmentReference(capacity).also { it[0].block() }

    inline fun BufferCopy(): VkBufferCopy = VkBufferCopy.create(ptr.advance(VkBufferCopy.SIZEOF))
    inline fun BufferCopy(capacity: Int): VkBufferCopy.Buffer = VkBufferCopy.create(ptr.advance(VkBufferCopy.SIZEOF * capacity), capacity)
    inline fun BufferCopy(block: VkBufferCopy.() -> Unit): VkBufferCopy = VkBufferCopy.create(ptr.advance(VkBufferCopy.SIZEOF)).also(block)

    inline fun BufferImageCopy(block: VkBufferImageCopy.() -> Unit): VkBufferImageCopy = VkBufferImageCopy.create(ptr.advance(VkBufferImageCopy.SIZEOF)).also(block)
    inline fun BufferImageCopy(capacity: Int, block: VkBufferImageCopy.() -> Unit): VkBufferImageCopy.Buffer = BufferImageCopy(capacity).also { it[0].block() }
    inline fun BufferImageCopy(capacity: Int): VkBufferImageCopy.Buffer = VkBufferImageCopy.create(ptr.advance(VkBufferImageCopy.SIZEOF * capacity), capacity)

    inline fun ClearValue(capacity: Int): VkClearValue.Buffer = VkClearValue.create(ptr.advance(VkClearValue.SIZEOF * capacity), capacity)

    inline fun DescriptorPoolSize(block: VkDescriptorPoolSize.() -> Unit): VkDescriptorPoolSize = VkDescriptorPoolSize.create(ptr.advance(VkDescriptorPoolSize.SIZEOF)).also(block)
    inline fun DescriptorPoolSize(capacity: Int): VkDescriptorPoolSize.Buffer = VkDescriptorPoolSize.create(ptr.advance(VkDescriptorPoolSize.SIZEOF * capacity), capacity)
    inline fun DescriptorPoolSize(capacity: Int, block: VkDescriptorPoolSize.Buffer.() -> Unit): VkDescriptorPoolSize.Buffer = DescriptorPoolSize(capacity).also(block)

    inline fun DescriptorSetLayoutBinding(capacity: Int): VkDescriptorSetLayoutBinding.Buffer = VkDescriptorSetLayoutBinding.create(ptr.advance(VkDescriptorSetLayoutBinding.SIZEOF * capacity), capacity)
    inline fun DescriptorSetLayoutBinding(capacity: Int, block: VkDescriptorSetLayoutBinding.Buffer.() -> Unit): VkDescriptorSetLayoutBinding.Buffer = DescriptorSetLayoutBinding(capacity).also(block)
    inline fun DescriptorSetLayoutBinding(block: VkDescriptorSetLayoutBinding.() -> Unit): VkDescriptorSetLayoutBinding = VkDescriptorSetLayoutBinding.create(ptr.advance(VkDescriptorSetLayoutBinding.SIZEOF)).also(block)

    inline fun ExtensionProperties(capacity: Int): VkExtensionProperties.Buffer = VkExtensionProperties.create(ptr.advance(VkExtensionProperties.SIZEOF * capacity), capacity)
    inline fun Extent3D(block: VkExtent3D.() -> Unit): VkExtent3D = VkExtent3D.create(ptr.advance(VkExtent3D.SIZEOF)).also(block)
    inline fun Extent2D(block: VkExtent2D.() -> Unit): VkExtent2D = VkExtent2D.create(ptr.advance(VkExtent2D.SIZEOF)).also(block)

    inline fun FormatProperties(block: VkFormatProperties.() -> Unit): VkFormatProperties = VkFormatProperties.create(ptr.advance(VkFormatProperties.SIZEOF)).also(block)

    inline fun ImageBlit(block: VkImageBlit.() -> Unit): VkImageBlit = VkImageBlit.create(ptr.advance(VkImageBlit.SIZEOF)).also(block)

    inline fun ImageCopy(block: VkImageCopy.() -> Unit): VkImageCopy = VkImageCopy.create(ptr.advance(VkImageCopy.SIZEOF)).also(block)

    inline fun ImageSubresource(block: VkImageSubresource.() -> Unit): VkImageSubresource = VkImageSubresource.create(ptr.advance(VkImageSubresource.SIZEOF)).also(block)

    inline fun ImageSubresourceRange(block: VkImageSubresourceRange.() -> Unit): VkImageSubresourceRange = VkImageSubresourceRange.create(ptr.advance(VkImageSubresourceRange.SIZEOF)).also(block)

    inline fun ImageSubresourceLayers(block: VkImageSubresourceLayers.() -> Unit): VkImageSubresourceLayers = VkImageSubresourceLayers.create(ptr.advance(VkImageSubresourceLayers.SIZEOF)).also(block)

//    inline fun InstanceCreateInfo(extensions: ArrayList<String>): VkInstanceCreateInfo {
//        return InstanceCreateInfo {
//
//        }
//    }

    inline fun MemoryRequirements(block: VkMemoryRequirements.() -> Unit): VkMemoryRequirements = VkMemoryRequirements.create(ptr.advance(VkMemoryRequirements.SIZEOF)).also(block)

    inline fun PipelineColorBlendAttachmentState(block: VkPipelineColorBlendAttachmentState.() -> Unit): VkPipelineColorBlendAttachmentState = VkPipelineColorBlendAttachmentState.create(ptr.advance(VkPipelineColorBlendAttachmentState.SIZEOF)).also(block)
    inline fun PipelineColorBlendAttachmentState(capacity: Int, block: VkPipelineColorBlendAttachmentState.() -> Unit): VkPipelineColorBlendAttachmentState.Buffer = VkPipelineColorBlendAttachmentState.create(ptr.advance(VkPipelineColorBlendAttachmentState.SIZEOF * capacity), capacity).also { it[0].block() }

    inline fun Rect2D(block: VkRect2D.() -> Unit): VkRect2D = VkRect2D.create(ptr.advance(VkRect2D.SIZEOF)).also(block)
    inline fun Rect2D(capacity: Int, block: VkRect2D.() -> Unit): VkRect2D.Buffer = VkRect2D.create(ptr.advance(VkRect2D.SIZEOF * capacity), capacity).also { it[0].block() }

    inline fun SpecializationMapEntry(): VkSpecializationMapEntry = VkSpecializationMapEntry.create(ptr.advance(VkSpecializationMapEntry.SIZEOF))
    inline fun SpecializationMapEntry(capacity: Int): VkSpecializationMapEntry.Buffer = VkSpecializationMapEntry.create(ptr.advance(VkSpecializationMapEntry.SIZEOF * capacity), capacity)

    inline fun SpecializationInfo(): VkSpecializationInfo = VkSpecializationInfo.create(ptr.advance(VkSpecializationInfo.SIZEOF))
    inline fun SpecializationInfo(capacity: Int): VkSpecializationInfo.Buffer = VkSpecializationInfo.create(ptr.advance(VkSpecializationInfo.SIZEOF * capacity), capacity)
    inline fun SpecializationInfo(block: VkSpecializationInfo.() -> Unit): VkSpecializationInfo = VkSpecializationInfo.create(ptr.advance(VkSpecializationInfo.SIZEOF)).also(block)

    inline fun SubpassDependency(): VkSubpassDependency = VkSubpassDependency.create(ptr.advance(VkSubpassDependency.SIZEOF))
    inline fun SubpassDependency(capacity: Int): VkSubpassDependency.Buffer = VkSubpassDependency.create(ptr.advance(VkSubpassDependency.SIZEOF * capacity), capacity)
    inline fun SubpassDependency(block: VkSubpassDependency.() -> Unit): VkSubpassDependency = SubpassDependency().also(block)

    inline fun SubpassDescription(block: VkSubpassDescription.() -> Unit): VkSubpassDescription = VkSubpassDescription.create(ptr.advance(VkSubpassDescription.SIZEOF)).also(block)
    inline fun SubpassDescription(capacity: Int): VkSubpassDescription.Buffer = VkSubpassDescription.create(ptr.advance(VkSubpassDescription.SIZEOF * capacity), capacity)

    inline fun SubresourceLayout(): VkSubresourceLayout = VkSubresourceLayout.create(ptr.advance(VkSubresourceLayout.SIZEOF))
    inline fun SubresourceLayout(capacity: Int, block: VkSubresourceLayout.() -> Unit): VkSubresourceLayout.Buffer = VkSubresourceLayout.create(ptr.advance(VkSubresourceLayout.SIZEOF * capacity), capacity).also { it[0].block() }

    inline fun SurfaceCapabilitiesKHR(block: VkSurfaceCapabilitiesKHR.() -> Unit): VkSurfaceCapabilitiesKHR = VkSurfaceCapabilitiesKHR.create(ptr.advance(VkSurfaceCapabilitiesKHR.SIZEOF)).also(block)

    inline fun SurfaceFormatKHR(capacity: Int): VkSurfaceFormatKHR.Buffer = VkSurfaceFormatKHR.create(ptr.advance(VkSurfaceFormatKHR.SIZEOF * capacity), capacity)

    inline fun VertexInputAttributeDescription(block: VkVertexInputAttributeDescription.() -> Unit): VkVertexInputAttributeDescription = VkVertexInputAttributeDescription.create(ptr.advance(VkVertexInputAttributeDescription.SIZEOF)).also(block)
    inline fun VertexInputAttributeDescription(capacity: Int): VkVertexInputAttributeDescription.Buffer = VkVertexInputAttributeDescription.create(ptr.advance(VkVertexInputAttributeDescription.SIZEOF * capacity), capacity)
    inline fun VertexInputAttributeDescription(capacity: Int, block: VkVertexInputAttributeDescription.Buffer.() -> Unit): VkVertexInputAttributeDescription.Buffer = VertexInputAttributeDescription(capacity).also(block)

    inline fun VertexInputBindingDescription(block: VkVertexInputBindingDescription.() -> Unit): VkVertexInputBindingDescription = VkVertexInputBindingDescription.create(ptr.advance(VkVertexInputBindingDescription.SIZEOF)).also { it.block() }
    inline fun VertexInputBindingDescription(capacity: Int, block: VkVertexInputBindingDescription.() -> Unit): VkVertexInputBindingDescription.Buffer = VkVertexInputBindingDescription.create(ptr.advance(VkVertexInputBindingDescription.SIZEOF * capacity), capacity).also { it[0].block() }

    inline fun Viewport(block: VkViewport.() -> Unit): VkViewport = VkViewport.create(ptr.advance(VkViewport.SIZEOF)).also(block)
    inline fun Viewport(capacity: Int, block: VkViewport.() -> Unit): VkViewport.Buffer = VkViewport.create(ptr.advance(VkViewport.SIZEOF * capacity), capacity).also { it[0].block() }


    /*
        Function Constructors
     */

    inline operator fun VkAttachmentReference.invoke(attachment: Int, layout: VkImageLayout): VkAttachmentReference {
        return attachment(attachment).layout(layout.i)
    }

    inline fun AttachmentReference(attachment: Int, layout: VkImageLayout): VkAttachmentReference {
        return AttachmentReference().attachment(attachment).layout(layout.i)
    }

    inline fun AttachmentReference(
            attachment0: Int, layout0: VkImageLayout,
            attachment1: Int, layout1: VkImageLayout): VkAttachmentReference.Buffer {
        return AttachmentReference(2).also {
            it[0].attachment(attachment0).layout(layout0.i)
            it[1].attachment(attachment1).layout(layout1.i)
        }
    }

    inline fun AttachmentReference(
            attachment0: Int, layout0: VkImageLayout,
            attachment1: Int, layout1: VkImageLayout,
            attachment2: Int, layout2: VkImageLayout): VkAttachmentReference.Buffer {
        return AttachmentReference(3).also {
            it[0].attachment(attachment0).layout(layout0.i)
            it[1].attachment(attachment1).layout(layout1.i)
            it[2].attachment(attachment2).layout(layout2.i)
        }
    }

    inline fun AttachmentReference(
            attachment0: Int, layout0: VkImageLayout,
            attachment1: Int, layout1: VkImageLayout,
            attachment2: Int, layout2: VkImageLayout,
            attachment3: Int, layout3: VkImageLayout): VkAttachmentReference.Buffer {
        return AttachmentReference(4).also {
            it[0].attachment(attachment0).layout(layout0.i)
            it[1].attachment(attachment1).layout(layout1.i)
            it[2].attachment(attachment2).layout(layout2.i)
            it[3].attachment(attachment3).layout(layout3.i)
        }
    }

    inline fun AttachmentReference(
            attachment0: Int, layout0: VkImageLayout,
            attachment1: Int, layout1: VkImageLayout,
            attachment2: Int, layout2: VkImageLayout,
            attachment3: Int, layout3: VkImageLayout,
            attachment4: Int, layout4: VkImageLayout): VkAttachmentReference.Buffer {
        return AttachmentReference(5).also {
            it[0].attachment(attachment0).layout(layout0.i)
            it[1].attachment(attachment1).layout(layout1.i)
            it[2].attachment(attachment2).layout(layout2.i)
            it[3].attachment(attachment3).layout(layout3.i)
            it[4].attachment(attachment4).layout(layout4.i)
        }
    }

    inline fun ComputePipelineCreateInfo(layout: VkPipelineLayout, flags: VkPipelineCreateFlags = 0): VkComputePipelineCreateInfo {
        return ComputePipelineCreateInfo {
            this.layout = layout
            this.flags = flags
        }
    }

    inline fun DescriptorImageInfo(sampler: VkSampler, imageView: VkImageView, imageLayout: VkImageLayout): VkDescriptorImageInfo {
        return DescriptorImageInfo {
            this.sampler = sampler
            this.imageView = imageView
            this.imageLayout = imageLayout
        }
    }

    inline fun DescriptorPoolCreateInfo(poolSize: VkDescriptorPoolSize, maxSets: Int): VkDescriptorPoolCreateInfo {
        return DescriptorPoolCreateInfo {
            this.poolSize = poolSize
            this.maxSets = maxSets
        }
    }

    inline fun DescriptorPoolCreateInfo(poolSizes: VkDescriptorPoolSize.Buffer, maxSets: Int): VkDescriptorPoolCreateInfo {
        return DescriptorPoolCreateInfo {
            this.poolSizes = poolSizes
            this.maxSets = maxSets
        }
    }

    inline fun DescriptorPoolSize(type: VkDescriptorType, descriptorCount: Int): VkDescriptorPoolSize {
        return DescriptorPoolSize {
            this.type = type
            this.descriptorCount = descriptorCount
        }
    }

    inline fun DescriptorPoolSize(
            type0: VkDescriptorType, descriptorCount0: Int,
            type1: VkDescriptorType, descriptorCount1: Int): VkDescriptorPoolSize.Buffer {
        return DescriptorPoolSize(2) {
            this[0].type(type0.i).descriptorCount(descriptorCount0)
            this[1].type(type1.i).descriptorCount(descriptorCount1)
        }
    }

    inline fun DescriptorPoolSize(
            type0: VkDescriptorType, descriptorCount0: Int,
            type1: VkDescriptorType, descriptorCount1: Int,
            type2: VkDescriptorType, descriptorCount2: Int): VkDescriptorPoolSize.Buffer {
        return DescriptorPoolSize(3) {
            this[0].type(type0.i).descriptorCount(descriptorCount0)
            this[1].type(type1.i).descriptorCount(descriptorCount1)
            this[2].type(type2.i).descriptorCount(descriptorCount2)
        }
    }

    inline fun DescriptorPoolSize(
            type0: VkDescriptorType, descriptorCount0: Int,
            type1: VkDescriptorType, descriptorCount1: Int,
            type2: VkDescriptorType, descriptorCount2: Int,
            type3: VkDescriptorType, descriptorCount3: Int): VkDescriptorPoolSize.Buffer {
        return DescriptorPoolSize(4) {
            this[0].type(type0.i).descriptorCount(descriptorCount0)
            this[1].type(type1.i).descriptorCount(descriptorCount1)
            this[2].type(type2.i).descriptorCount(descriptorCount2)
            this[3].type(type3.i).descriptorCount(descriptorCount3)
        }
    }

    inline fun DescriptorPoolSize(
            type0: VkDescriptorType, descriptorCount0: Int,
            type1: VkDescriptorType, descriptorCount1: Int,
            type2: VkDescriptorType, descriptorCount2: Int,
            type3: VkDescriptorType, descriptorCount3: Int,
            type4: VkDescriptorType, descriptorCount4: Int): VkDescriptorPoolSize.Buffer {
        return DescriptorPoolSize(5) {
            this[0].type(type0.i).descriptorCount(descriptorCount0)
            this[1].type(type1.i).descriptorCount(descriptorCount1)
            this[2].type(type2.i).descriptorCount(descriptorCount2)
            this[3].type(type3.i).descriptorCount(descriptorCount3)
            this[4].type(type4.i).descriptorCount(descriptorCount4)
        }
    }

    inline fun DescriptorPoolSize(
            type0: VkDescriptorType, descriptorCount0: Int,
            type1: VkDescriptorType, descriptorCount1: Int,
            type2: VkDescriptorType, descriptorCount2: Int,
            type3: VkDescriptorType, descriptorCount3: Int,
            type4: VkDescriptorType, descriptorCount4: Int,
            type5: VkDescriptorType, descriptorCount5: Int): VkDescriptorPoolSize.Buffer {
        return DescriptorPoolSize(6) {
            this[0].type(type0.i).descriptorCount(descriptorCount0)
            this[1].type(type1.i).descriptorCount(descriptorCount1)
            this[2].type(type2.i).descriptorCount(descriptorCount2)
            this[3].type(type3.i).descriptorCount(descriptorCount3)
            this[4].type(type4.i).descriptorCount(descriptorCount4)
            this[5].type(type5.i).descriptorCount(descriptorCount5)
        }
    }

    inline fun DescriptorPoolSize(
            type0: VkDescriptorType, descriptorCount0: Int,
            type1: VkDescriptorType, descriptorCount1: Int,
            type2: VkDescriptorType, descriptorCount2: Int,
            type3: VkDescriptorType, descriptorCount3: Int,
            type4: VkDescriptorType, descriptorCount4: Int,
            type5: VkDescriptorType, descriptorCount5: Int,
            type6: VkDescriptorType, descriptorCount6: Int): VkDescriptorPoolSize.Buffer {
        return DescriptorPoolSize(7) {
            this[0].type(type0.i).descriptorCount(descriptorCount0)
            this[1].type(type1.i).descriptorCount(descriptorCount1)
            this[2].type(type2.i).descriptorCount(descriptorCount2)
            this[3].type(type3.i).descriptorCount(descriptorCount3)
            this[4].type(type4.i).descriptorCount(descriptorCount4)
            this[5].type(type5.i).descriptorCount(descriptorCount5)
            this[6].type(type6.i).descriptorCount(descriptorCount6)
        }
    }

    inline fun DescriptorPoolSize(
            type0: VkDescriptorType, descriptorCount0: Int,
            type1: VkDescriptorType, descriptorCount1: Int,
            type2: VkDescriptorType, descriptorCount2: Int,
            type3: VkDescriptorType, descriptorCount3: Int,
            type4: VkDescriptorType, descriptorCount4: Int,
            type5: VkDescriptorType, descriptorCount5: Int,
            type6: VkDescriptorType, descriptorCount6: Int,
            type7: VkDescriptorType, descriptorCount7: Int): VkDescriptorPoolSize.Buffer {
        return DescriptorPoolSize(8) {
            this[0].type(type0.i).descriptorCount(descriptorCount0)
            this[1].type(type1.i).descriptorCount(descriptorCount1)
            this[2].type(type2.i).descriptorCount(descriptorCount2)
            this[3].type(type3.i).descriptorCount(descriptorCount3)
            this[4].type(type4.i).descriptorCount(descriptorCount4)
            this[5].type(type5.i).descriptorCount(descriptorCount5)
            this[6].type(type6.i).descriptorCount(descriptorCount6)
            this[7].type(type7.i).descriptorCount(descriptorCount7)
        }
    }

    inline fun DescriptorPoolSize(
            type0: VkDescriptorType, descriptorCount0: Int,
            type1: VkDescriptorType, descriptorCount1: Int,
            type2: VkDescriptorType, descriptorCount2: Int,
            type3: VkDescriptorType, descriptorCount3: Int,
            type4: VkDescriptorType, descriptorCount4: Int,
            type5: VkDescriptorType, descriptorCount5: Int,
            type6: VkDescriptorType, descriptorCount6: Int,
            type7: VkDescriptorType, descriptorCount7: Int,
            type8: VkDescriptorType, descriptorCount8: Int): VkDescriptorPoolSize.Buffer {
        return DescriptorPoolSize(9) {
            this[0].type(type0.i).descriptorCount(descriptorCount0)
            this[1].type(type1.i).descriptorCount(descriptorCount1)
            this[2].type(type2.i).descriptorCount(descriptorCount2)
            this[3].type(type3.i).descriptorCount(descriptorCount3)
            this[4].type(type4.i).descriptorCount(descriptorCount4)
            this[5].type(type5.i).descriptorCount(descriptorCount5)
            this[6].type(type6.i).descriptorCount(descriptorCount6)
            this[7].type(type7.i).descriptorCount(descriptorCount7)
            this[8].type(type8.i).descriptorCount(descriptorCount8)
        }
    }

    inline fun DescriptorPoolSize(
            type0: VkDescriptorType, descriptorCount0: Int,
            type1: VkDescriptorType, descriptorCount1: Int,
            type2: VkDescriptorType, descriptorCount2: Int,
            type3: VkDescriptorType, descriptorCount3: Int,
            type4: VkDescriptorType, descriptorCount4: Int,
            type5: VkDescriptorType, descriptorCount5: Int,
            type6: VkDescriptorType, descriptorCount6: Int,
            type7: VkDescriptorType, descriptorCount7: Int,
            type8: VkDescriptorType, descriptorCount8: Int,
            type9: VkDescriptorType, descriptorCount9: Int): VkDescriptorPoolSize.Buffer {
        return DescriptorPoolSize(10) {
            this[0].type(type0.i).descriptorCount(descriptorCount0)
            this[1].type(type1.i).descriptorCount(descriptorCount1)
            this[2].type(type2.i).descriptorCount(descriptorCount2)
            this[3].type(type3.i).descriptorCount(descriptorCount3)
            this[4].type(type4.i).descriptorCount(descriptorCount4)
            this[5].type(type5.i).descriptorCount(descriptorCount5)
            this[6].type(type6.i).descriptorCount(descriptorCount6)
            this[7].type(type7.i).descriptorCount(descriptorCount7)
            this[8].type(type8.i).descriptorCount(descriptorCount8)
            this[9].type(type9.i).descriptorCount(descriptorCount9)
        }
    }

    inline fun DescriptorPoolSize(
            type0: VkDescriptorType, descriptorCount0: Int,
            type1: VkDescriptorType, descriptorCount1: Int,
            type2: VkDescriptorType, descriptorCount2: Int,
            type3: VkDescriptorType, descriptorCount3: Int,
            type4: VkDescriptorType, descriptorCount4: Int,
            type5: VkDescriptorType, descriptorCount5: Int,
            type6: VkDescriptorType, descriptorCount6: Int,
            type7: VkDescriptorType, descriptorCount7: Int,
            type8: VkDescriptorType, descriptorCount8: Int,
            type9: VkDescriptorType, descriptorCount9: Int,
            type10: VkDescriptorType, descriptorCount10: Int): VkDescriptorPoolSize.Buffer {
        return DescriptorPoolSize(11) {
            this[0].type(type0.i).descriptorCount(descriptorCount0)
            this[1].type(type1.i).descriptorCount(descriptorCount1)
            this[2].type(type2.i).descriptorCount(descriptorCount2)
            this[3].type(type3.i).descriptorCount(descriptorCount3)
            this[4].type(type4.i).descriptorCount(descriptorCount4)
            this[5].type(type5.i).descriptorCount(descriptorCount5)
            this[6].type(type6.i).descriptorCount(descriptorCount6)
            this[7].type(type7.i).descriptorCount(descriptorCount7)
            this[8].type(type8.i).descriptorCount(descriptorCount8)
            this[9].type(type9.i).descriptorCount(descriptorCount9)
            this[10].type(type10.i).descriptorCount(descriptorCount10)
        }
    }

    inline fun DescriptorSetAllocateInfo(descriptorPool: VkDescriptorPool, setLayout: VkDescriptorSetLayout): VkDescriptorSetAllocateInfo {
        return DescriptorSetAllocateInfo {
            this.descriptorPool = descriptorPool
            this.setLayout = setLayout
        }
    }

    inline fun DescriptorSetLayoutBinding(type: VkDescriptorType, stageFlags: VkShaderStageFlags, binding: Int, descriptorCount: Int = 1): VkDescriptorSetLayoutBinding {
        return DescriptorSetLayoutBinding {
            descriptorType = type
            this.stageFlags = stageFlags
            this.binding = binding
            this.descriptorCount = descriptorCount
        }
    }

    inline fun DescriptorSetLayoutBinding(
            type0: VkDescriptorType, stageFlags0: VkShaderStageFlags, binding0: Int,
            type1: VkDescriptorType, stageFlags1: VkShaderStageFlags, binding1: Int): VkDescriptorSetLayoutBinding.Buffer {

        return DescriptorSetLayoutBinding(
                type0, stageFlags0, binding0, 1,
                type1, stageFlags1, binding1, 1)
    }

    inline fun DescriptorSetLayoutBinding(
            type0: VkDescriptorType, stageFlags0: VkShaderStageFlags, binding0: Int,
            type1: VkDescriptorType, stageFlags1: VkShaderStageFlags, binding1: Int,
            type2: VkDescriptorType, stageFlags2: VkShaderStageFlags, binding2: Int): VkDescriptorSetLayoutBinding.Buffer {

        return DescriptorSetLayoutBinding(
                type0, stageFlags0, binding0, 1,
                type1, stageFlags1, binding1, 1,
                type2, stageFlags2, binding2, 1)
    }

    inline fun DescriptorSetLayoutBinding(
            type0: VkDescriptorType, stageFlags0: VkShaderStageFlags, binding0: Int,
            type1: VkDescriptorType, stageFlags1: VkShaderStageFlags, binding1: Int,
            type2: VkDescriptorType, stageFlags2: VkShaderStageFlags, binding2: Int,
            type3: VkDescriptorType, stageFlags3: VkShaderStageFlags, binding3: Int): VkDescriptorSetLayoutBinding.Buffer {

        return DescriptorSetLayoutBinding(
                type0, stageFlags0, binding0, 1,
                type1, stageFlags1, binding1, 1,
                type2, stageFlags2, binding2, 1,
                type3, stageFlags3, binding3, 1)
    }

    inline fun DescriptorSetLayoutBinding(
            type0: VkDescriptorType, stageFlags0: VkShaderStageFlags, binding0: Int, descriptorCount0: Int,
            type1: VkDescriptorType, stageFlags1: VkShaderStageFlags, binding1: Int, descriptorCount1: Int): VkDescriptorSetLayoutBinding.Buffer {
        return DescriptorSetLayoutBinding(2) {
            this[0].apply {
                descriptorType = type0
                stageFlags = stageFlags0
                binding = binding0
                descriptorCount = descriptorCount0
            }
            this[1].apply {
                descriptorType = type1
                stageFlags = stageFlags1
                binding = binding1
                descriptorCount = descriptorCount1
            }
        }
    }

    inline fun DescriptorSetLayoutBinding(
            type0: VkDescriptorType, stageFlags0: VkShaderStageFlags, binding0: Int, descriptorCount0: Int,
            type1: VkDescriptorType, stageFlags1: VkShaderStageFlags, binding1: Int, descriptorCount1: Int,
            type2: VkDescriptorType, stageFlags2: VkShaderStageFlags, binding2: Int, descriptorCount2: Int): VkDescriptorSetLayoutBinding.Buffer {
        return DescriptorSetLayoutBinding(3) {
            this[0].apply {
                descriptorType = type0
                stageFlags = stageFlags0
                binding = binding0
                descriptorCount = descriptorCount0
            }
            this[1].apply {
                descriptorType = type1
                stageFlags = stageFlags1
                binding = binding1
                descriptorCount = descriptorCount1
            }
            this[2].apply {
                descriptorType = type2
                stageFlags = stageFlags2
                binding = binding2
                descriptorCount = descriptorCount2
            }
        }
    }

    inline fun DescriptorSetLayoutBinding(
            type0: VkDescriptorType, stageFlags0: VkShaderStageFlags, binding0: Int, descriptorCount0: Int,
            type1: VkDescriptorType, stageFlags1: VkShaderStageFlags, binding1: Int, descriptorCount1: Int,
            type2: VkDescriptorType, stageFlags2: VkShaderStageFlags, binding2: Int, descriptorCount2: Int,
            type3: VkDescriptorType, stageFlags3: VkShaderStageFlags, binding3: Int, descriptorCount3: Int): VkDescriptorSetLayoutBinding.Buffer {
        return DescriptorSetLayoutBinding(4) {
            this[0].apply {
                descriptorType = type0
                stageFlags = stageFlags0
                binding = binding0
                descriptorCount = descriptorCount0
            }
            this[1].apply {
                descriptorType = type1
                stageFlags = stageFlags1
                binding = binding1
                descriptorCount = descriptorCount1
            }
            this[2].apply {
                descriptorType = type2
                stageFlags = stageFlags2
                binding = binding2
                descriptorCount = descriptorCount2
            }
            this[3].apply {
                descriptorType = type3
                stageFlags = stageFlags3
                binding = binding3
                descriptorCount = descriptorCount3
            }
        }
    }

    inline fun DescriptorSetLayoutCreateInfo(binding: VkDescriptorSetLayoutBinding): VkDescriptorSetLayoutCreateInfo {
        return DescriptorSetLayoutCreateInfo {
            this.binding = binding
        }
    }

    inline fun DescriptorSetLayoutCreateInfo(bindings: VkDescriptorSetLayoutBinding.Buffer): VkDescriptorSetLayoutCreateInfo {
        return DescriptorSetLayoutCreateInfo {
            this.bindings = bindings
        }
    }

//    inline fun DeviceCreateInfo(queueCreateInfo: VkDeviceQueueCreateInfo, ): VkDeviceCreateInfo {
//
//    }

    inline fun FenceCreateInfo(flags: VkFenceCreateFlags = 0): VkFenceCreateInfo {
        return FenceCreateInfo {
            this.flags = flags
        }
    }

    inline fun GraphicsPipelineCreateInfo(layout: VkPipelineLayout, renderPass: VkRenderPass, flags: VkPipelineCreateFlags = 0): VkGraphicsPipelineCreateInfo {
        return GraphicsPipelineCreateInfo {
            this.layout = layout
            this.renderPass = renderPass
            this.flags = flags
            basePipelineIndex = -1
            basePipelineHandle = NULL
        }
    }

    inline fun PipelineColorBlendAttachmentState(colorWriteMask: VkColorComponentFlags, blendEnable: Boolean): VkPipelineColorBlendAttachmentState {
        return PipelineColorBlendAttachmentState {
            this.colorWriteMask = colorWriteMask
            this.blendEnable = blendEnable
        }
    }

    inline fun PipelineColorBlendStateCreateInfo(attachment: VkPipelineColorBlendAttachmentState): VkPipelineColorBlendStateCreateInfo {
        return PipelineColorBlendStateCreateInfo {
            this.attachment = attachment
        }
    }

    inline fun PipelineDepthStencilStateCreateInfo(depthTestEnable: Boolean,
                                                   depthWriteEnable: Boolean,
                                                   depthCompareOp: VkCompareOp): VkPipelineDepthStencilStateCreateInfo {
        return PipelineDepthStencilStateCreateInfo {
            this.depthTestEnable = depthTestEnable
            this.depthWriteEnable = depthWriteEnable
            this.depthCompareOp = depthCompareOp
            front = back
            back.compareOp = VkCompareOp.ALWAYS
        }
    }

    inline fun PipelineDynamicStateCreateInfo(dynamicStates: Collection<VkDynamicState>, flags: VkPipelineDynamicStateCreateFlags = 0): VkPipelineDynamicStateCreateInfo {
        return PipelineDynamicStateCreateInfo {
            val buf = appBuffer.intBuffer(dynamicStates.size)
            for (i in dynamicStates.indices)
                buf[i] = dynamicStates.elementAt(i).i
            this.dynamicStates = buf
            this.flags = flags
        }
    }

    inline fun PipelineInputAssemblyStateCreateInfo(topology: VkPrimitiveTopology,
                                                    flags: VkPipelineInputAssemblyStateCreateFlags = 0,
                                                    primitiveRestartEnable: Boolean = false): VkPipelineInputAssemblyStateCreateInfo {
        return PipelineInputAssemblyStateCreateInfo {
            this.topology = topology
            this.flags = flags
            this.primitiveRestartEnable = primitiveRestartEnable
        }
    }


    inline fun PipelineLayoutCreateInfo(setLayout: VkDescriptorSetLayout): VkPipelineLayoutCreateInfo {
        return PipelineLayoutCreateInfo {
            this.setLayout = setLayout
        }
    }

    inline fun PipelineMultisampleStateCreateInfo(rasterizationSamples: VkSampleCount, flags: VkPipelineMultisampleStateCreateFlags = 0): VkPipelineMultisampleStateCreateInfo {
        return PipelineMultisampleStateCreateInfo {
            this.rasterizationSamples = rasterizationSamples
            this.flags = flags
        }
    }

    inline fun PipelineRasterizationStateCreateInfo(
            polygonMode: VkPolygonMode,
            cullMode: VkCullModeFlags,
            frontFace: VkFrontFace,
            flags: VkPipelineRasterizationStateCreateFlags = 0
    ): VkPipelineRasterizationStateCreateInfo {
        return PipelineRasterizationStateCreateInfo {
            this.polygonMode = polygonMode
            this.cullMode = cullMode
            this.frontFace = frontFace
            this.flags = flags
            depthClampEnable = false
            lineWidth = 1f
        }
    }

    inline fun PipelineViewportStateCreateInfo(viewportCount: Int, scissorCount: Int, flags: VkPipelineViewportStateCreateFlags = 0): VkPipelineViewportStateCreateInfo {
        return PipelineViewportStateCreateInfo {
            this.viewportCount = viewportCount
            this.scissorCount = scissorCount
            this.flags = flags
        }
    }

    inline fun PushConstantRange(stageFlags: VkShaderStageFlags, size: Int, offset: Int): VkPushConstantRange {
        return PushConstantRange {
            this.stageFlags = stageFlags
            this.size = size
            this.offset = offset
        }
    }

    inline fun Rect2D(size: Vec2i, offset: Vec2i = Vec2i()) = Rect2D(size.x, size.y, offset.x, offset.y)

    inline fun Rect2D(width: Int, height: Int, offsetX: Int, offsetY: Int): VkRect2D.Buffer {
        return Rect2D(1) {
            extent.width = width
            extent.height = height
            offset.x = offsetX
            offset.y = offsetY
        }
    }

    inline fun SpecializationInfo(mapEntries: VkSpecializationMapEntry.Buffer, data: ByteBuffer): VkSpecializationInfo {
        return SpecializationInfo().also {
            it.mapEntries = mapEntries
            it.data = data
        }
    }

    inline fun SpecializationInfo(
            mapEntries0: VkSpecializationMapEntry.Buffer, data0: ByteBuffer,
            mapEntries1: VkSpecializationMapEntry.Buffer, data1: ByteBuffer): VkSpecializationInfo.Buffer {
        return SpecializationInfo(2).also {
            it[0].apply {
                mapEntries = mapEntries0
                data = data0
            }
            it[1].apply {
                mapEntries = mapEntries1
                data = data1
            }
        }
    }

    inline fun SpecializationMapEntry(constantId: Int, offset: Int, size: Int): VkSpecializationMapEntry {
        return SpecializationMapEntry().also {
            it.constantId = constantId
            it.offset = offset
            it.size = size.L
        }
    }

    inline fun SpecializationMapEntry(
            constantId0: Int, offset0: Int, size0: Int,
            constantId1: Int, offset1: Int, size1: Int): VkSpecializationMapEntry.Buffer {
        return SpecializationMapEntry(2).also {
            it[0].also {
                it.constantId = constantId0
                it.offset = offset0
                it.size = size0.L
            }
            it[1].also {
                it.constantId = constantId1
                it.offset = offset1
                it.size = size1.L
            }
        }
    }

    inline fun SpecializationMapEntry(
            constantId0: Int, offset0: Int, size0: Int,
            constantId1: Int, offset1: Int, size1: Int,
            constantId2: Int, offset2: Int, size2: Int): VkSpecializationMapEntry.Buffer {
        return SpecializationMapEntry(3).also {
            it[0].also {
                it.constantId = constantId0
                it.offset = offset0
                it.size = size0.L
            }
            it[1].also {
                it.constantId = constantId1
                it.offset = offset1
                it.size = size1.L
            }
            it[2].also {
                it.constantId = constantId2
                it.offset = offset2
                it.size = size2.L
            }
        }
    }

    inline fun SpecializationMapEntry(
            constantId0: Int, offset0: Int, size0: Int,
            constantId1: Int, offset1: Int, size1: Int,
            constantId2: Int, offset2: Int, size2: Int,
            constantId3: Int, offset3: Int, size3: Int): VkSpecializationMapEntry.Buffer {
        return SpecializationMapEntry(4).also {
            it[0].also {
                it.constantId = constantId0
                it.offset = offset0
                it.size = size0.L
            }
            it[1].also {
                it.constantId = constantId1
                it.offset = offset1
                it.size = size1.L
            }
            it[2].also {
                it.constantId = constantId2
                it.offset = offset2
                it.size = size2.L
            }
            it[3].also {
                it.constantId = constantId3
                it.offset = offset3
                it.size = size3.L
            }
        }
    }

    inline fun VertexInputBindingDescription(binding: Int, stride: Int, inputRate: VkVertexInputRate): VkVertexInputBindingDescription {
        return VertexInputBindingDescription {
            this.binding = binding
            this.stride = stride
            this.inputRate = inputRate
        }
    }

    inline fun Viewport(size: Vec2i, minDepth: Float = 0f, maxDepth: Float = 1f): VkViewport {
        return Viewport(size.x.f, size.y.f, minDepth, maxDepth)
    }

    inline fun Viewport(width: Float, height: Float, minDepth: Float = 0f, maxDepth: Float = 1f): VkViewport {
        return Viewport {
            this.width = width
            this.height = height
            this.minDepth = minDepth
            this.maxDepth = maxDepth
        }
    }

    inline fun WriteDescriptorSet(dstSet: VkDescriptorSet, type: VkDescriptorType, binding: Int, imageInfo: VkDescriptorImageInfo): VkWriteDescriptorSet {
        return WriteDescriptorSet {
            this.dstSet = dstSet
            descriptorType = type
            dstBinding = binding
            imageInfo_ = imageInfo
        }
    }

    inline fun WriteDescriptorSet(dstSet: VkDescriptorSet, type: VkDescriptorType, binding: Int, bufferInfo: VkDescriptorBufferInfo): VkWriteDescriptorSet {
        return WriteDescriptorSet {
            this.dstSet = dstSet
            descriptorType = type
            dstBinding = binding
            bufferInfo_ = bufferInfo
        }
    }

    inline fun WriteDescriptorSet(
            dstSet0: VkDescriptorSet, type0: VkDescriptorType, binding0: Int, info0: Struct,
            dstSet1: VkDescriptorSet, type1: VkDescriptorType, binding1: Int, info1: Struct): VkWriteDescriptorSet.Buffer {
        return WriteDescriptorSet(2) {
            this[0].apply {
                dstSet = dstSet0
                descriptorType = type0
                dstBinding = binding0
                if (info0 is VkDescriptorBufferInfo)
                    bufferInfo_ = info0
                else
                    imageInfo_ = info0 as VkDescriptorImageInfo
            }
            this[1].apply {
                dstSet = dstSet1
                descriptorType = type1
                dstBinding = binding1
                if (info1 is VkDescriptorBufferInfo)
                    bufferInfo_ = info1
                else
                    imageInfo_ = info1 as VkDescriptorImageInfo
            }
        }
    }

    inline fun WriteDescriptorSet(
            dstSet0: VkDescriptorSet, type0: VkDescriptorType, binding0: Int, info0: Struct,
            dstSet1: VkDescriptorSet, type1: VkDescriptorType, binding1: Int, info1: Struct,
            dstSet2: VkDescriptorSet, type2: VkDescriptorType, binding2: Int, info2: Struct): VkWriteDescriptorSet.Buffer {
        return WriteDescriptorSet(3) {
            this[0].apply {
                dstSet = dstSet0
                descriptorType = type0
                dstBinding = binding0
                if (info0 is VkDescriptorBufferInfo)
                    bufferInfo_ = info0
                else
                    imageInfo_ = info0 as VkDescriptorImageInfo
            }
            this[1].apply {
                dstSet = dstSet1
                descriptorType = type1
                dstBinding = binding1
                if (info1 is VkDescriptorBufferInfo)
                    bufferInfo_ = info1
                else
                    imageInfo_ = info1 as VkDescriptorImageInfo
            }
            this[2].apply {
                dstSet = dstSet2
                descriptorType = type2
                dstBinding = binding2
                if (info2 is VkDescriptorBufferInfo)
                    bufferInfo_ = info2
                else
                    imageInfo_ = info2 as VkDescriptorImageInfo
            }
        }
    }

    inline fun WriteDescriptorSet(
            dstSet0: VkDescriptorSet, type0: VkDescriptorType, binding0: Int, info0: Struct,
            dstSet1: VkDescriptorSet, type1: VkDescriptorType, binding1: Int, info1: Struct,
            dstSet2: VkDescriptorSet, type2: VkDescriptorType, binding2: Int, info2: Struct,
            dstSet3: VkDescriptorSet, type3: VkDescriptorType, binding3: Int, info3: Struct): VkWriteDescriptorSet.Buffer {
        return WriteDescriptorSet(4) {
            this[0].apply {
                dstSet = dstSet0
                descriptorType = type0
                dstBinding = binding0
                if (info0 is VkDescriptorBufferInfo)
                    bufferInfo_ = info0
                else
                    imageInfo_ = info0 as VkDescriptorImageInfo
            }
            this[1].apply {
                dstSet = dstSet1
                descriptorType = type1
                dstBinding = binding1
                if (info1 is VkDescriptorBufferInfo)
                    bufferInfo_ = info1
                else
                    imageInfo_ = info1 as VkDescriptorImageInfo
            }
            this[2].apply {
                dstSet = dstSet2
                descriptorType = type2
                dstBinding = binding2
                if (info2 is VkDescriptorBufferInfo)
                    bufferInfo_ = info2
                else
                    imageInfo_ = info2 as VkDescriptorImageInfo
            }
            this[3].apply {
                dstSet = dstSet3
                descriptorType = type3
                dstBinding = binding3
                if (info3 is VkDescriptorBufferInfo)
                    bufferInfo_ = info3
                else
                    imageInfo_ = info3 as VkDescriptorImageInfo
            }
        }
    }


    /*
        Full Constructors
     */


    inline fun ImageSubresourceRange(
            aspectMask: VkImageAspectFlags,
            baseMipLevel: Int,
            levelCount: Int,
            baseArrayLayer: Int,
            layerCount: Int): VkImageSubresourceRange {
        return ImageSubresourceRange {
            this.aspectMask = aspectMask
            this.baseMipLevel = baseMipLevel
            this.levelCount = levelCount
            this.baseArrayLayer = baseArrayLayer
            this.layerCount = layerCount
        }
    }

    inline fun VertexInputAttributeDescription(binding: Int, location: Int, format: VkFormat, offset: Int): VkVertexInputAttributeDescription {
        return VertexInputAttributeDescription {
            this.location = location
            this.binding = binding
            this.format = format
            this.offset = offset
        }
    }

    inline fun VertexInputAttributeDescription(
            binding0: Int, location0: Int, format0: VkFormat, offset0: Int,
            binding1: Int, location1: Int, format1: VkFormat, offset1: Int): VkVertexInputAttributeDescription.Buffer {

        return VertexInputAttributeDescription(2) {
            this[0].apply {
                location = location0
                binding = binding0
                format = format0
                offset = offset0
            }
            this[1].apply {
                location = location1
                binding = binding1
                format = format1
                offset = offset1
            }
        }
    }

    inline fun VertexInputAttributeDescription(
            binding0: Int, location0: Int, format0: VkFormat, offset0: Int,
            binding1: Int, location1: Int, format1: VkFormat, offset1: Int,
            binding2: Int, location2: Int, format2: VkFormat, offset2: Int): VkVertexInputAttributeDescription.Buffer {

        return VertexInputAttributeDescription(3) {
            this[0].apply {
                location = location0
                binding = binding0
                format = format0
                offset = offset0
            }
            this[1].apply {
                location = location1
                binding = binding1
                format = format1
                offset = offset1
            }
            this[2].apply {
                location = location2
                binding = binding2
                format = format2
                offset = offset2
            }
        }
    }

    inline fun VertexInputAttributeDescription(
            binding0: Int, location0: Int, format0: VkFormat, offset0: Int,
            binding1: Int, location1: Int, format1: VkFormat, offset1: Int,
            binding2: Int, location2: Int, format2: VkFormat, offset2: Int,
            binding3: Int, location3: Int, format3: VkFormat, offset3: Int): VkVertexInputAttributeDescription.Buffer {

        return VertexInputAttributeDescription(4) {
            this[0].apply {
                location = location0
                binding = binding0
                format = format0
                offset = offset0
            }
            this[1].apply {
                location = location1
                binding = binding1
                format = format1
                offset = offset1
            }
            this[2].apply {
                location = location2
                binding = binding2
                format = format2
                offset = offset2
            }
            this[3].apply {
                location = location3
                binding = binding3
                format = format3
                offset = offset3
            }
        }
    }

    inline fun VertexInputAttributeDescription(
            binding0: Int, location0: Int, format0: VkFormat, offset0: Int,
            binding1: Int, location1: Int, format1: VkFormat, offset1: Int,
            binding2: Int, location2: Int, format2: VkFormat, offset2: Int,
            binding3: Int, location3: Int, format3: VkFormat, offset3: Int,
            binding4: Int, location4: Int, format4: VkFormat, offset4: Int): VkVertexInputAttributeDescription.Buffer {

        return VertexInputAttributeDescription(4) {
            this[0].apply {
                location = location0
                binding = binding0
                format = format0
                offset = offset0
            }
            this[1].apply {
                location = location1
                binding = binding1
                format = format1
                offset = offset1
            }
            this[2].apply {
                location = location2
                binding = binding2
                format = format2
                offset = offset2
            }
            this[3].apply {
                location = location3
                binding = binding3
                format = format3
                offset = offset3
            }
            this[4].apply {
                location = location4
                binding = binding4
                format = format4
                offset = offset4
            }
        }
    }

/*
    functions
 */

    inline fun acquireNextImageKHR(device: VkDevice, swapchain: VkSwapchainKHR, timeout: Long, semaphore: VkSemaphore, fence: VkFence,
                                   imageIndex: KMutableProperty0<Int>): VkResult {
        val pImageIndex = appBuffer.int
        return VkResult of KHRSwapchain.nvkAcquireNextImageKHR(device, swapchain, timeout, semaphore, fence, pImageIndex).also {
            imageIndex.set(memGetInt(pImageIndex))
        }
    }

    inline fun allocateCommandBuffers(device: VkDevice, allocateInfo: VkCommandBufferAllocateInfo, count: Int,
                                      commandBuffers: ArrayList<VkCommandBuffer>): VkResult {
        val pCommandBuffer = appBuffer.pointerArray(count)
        commandBuffers.clear()
        return VkResult of VK10.nvkAllocateCommandBuffers(device, allocateInfo.adr, pCommandBuffer).also {
            for (i in 0 until count)
                commandBuffers += VkCommandBuffer(memGetAddress(pCommandBuffer + Pointer.POINTER_SIZE * i), device)
        }
    }

    inline fun allocateDescriptorSets(device: VkDevice, allocateInfo: VkDescriptorSetAllocateInfo,
                                      descriptorSets: KMutableProperty0<VkDescriptorSet>): VkResult {
        val pDescriptorSets = appBuffer.long
        return VkResult of VK10.nvkAllocateDescriptorSets(device, allocateInfo.adr, pDescriptorSets).also {
            descriptorSets.set(memGetLong(pDescriptorSets))
        }
    }

    inline fun allocateMemory(device: VkDevice, allocateInfo: VkMemoryAllocateInfo, memory: KMutableProperty0<VkDeviceMemory>): VkResult {
        val pMemory = appBuffer.long
        return VkResult of VK10.nvkAllocateMemory(device, allocateInfo.adr, NULL, pMemory).also {
            memory.set(memGetLong(pMemory))
        }
    }

    inline fun beginCommandBuffer(commandBuffer: VkCommandBuffer, beginInfo: VkCommandBufferBeginInfo): VkResult {
        return VkResult of VK10.nvkBeginCommandBuffer(commandBuffer, beginInfo.adr)
    }

    inline fun cmdBeginRenderPass(commandBuffer: VkCommandBuffer, renderPassBegin: VkRenderPassBeginInfo, contents: VkSubpassContents) {
        VK10.nvkCmdBeginRenderPass(commandBuffer, renderPassBegin.adr, contents.i)
    }

    inline fun cmdBindDescriptorSets(commandBuffer: VkCommandBuffer, pipelineBindPoint: VkPipelineBindPoint, layout: VkPipelineLayout,
                                     descriptorSet: VkDescriptorSet, dynamicOffsets: Int? = null) {
        val pDescriptorSets = appBuffer.long
        memPutLong(pDescriptorSets, descriptorSet)
        val dynamicOffsetCount: Int
        val pDynamicOffset: Long
        if (dynamicOffsets != null) {
            dynamicOffsetCount = 1
            pDynamicOffset = appBuffer.int
            memPutInt(pDynamicOffset, dynamicOffsets)
        } else {
            dynamicOffsetCount = 0
            pDynamicOffset = NULL
        }
        VK10.nvkCmdBindDescriptorSets(commandBuffer, pipelineBindPoint.i, layout, 0, 1, pDescriptorSets,
                dynamicOffsetCount, pDynamicOffset)
    }

    inline fun cmdBindIndexBuffer(commandBuffer: VkCommandBuffer, buffer: VkBuffer, offset: VkDeviceSize, indexType: VkIndexType) {
        VK10.vkCmdBindIndexBuffer(commandBuffer, buffer, offset, indexType.i)
    }

    inline fun cmdBindPipeline(commandBuffer: VkCommandBuffer, pipelineBindPoint: VkPipelineBindPoint, pipeline: VkPipeline) {
        VK10.vkCmdBindPipeline(commandBuffer, pipelineBindPoint.i, pipeline)
    }

    inline fun cmdBindVertexBuffer(commandBuffer: VkCommandBuffer, firstBinding: Int, buffer: VkBuffer) {
        val pBuffer = appBuffer.long
        memPutLong(pBuffer, buffer)
        val pOffset = appBuffer.long
        memPutLong(pOffset, 0L) // TODO remove since calloc?
        VK10.nvkCmdBindVertexBuffers(commandBuffer, firstBinding, 1, pBuffer, pOffset)
    }

    inline fun cmdDrawIndexed(commandBuffer: VkCommandBuffer, indexCount: Int, instanceCount: Int, firstIndex: Int, vertexOffset: Int, firstInstance: Int) {
        VK10.vkCmdDrawIndexed(commandBuffer, indexCount, instanceCount, firstIndex, vertexOffset, firstInstance)
    }

    inline fun cmdEndRenderPass(commandBuffer: VkCommandBuffer) {
        VK10.vkCmdEndRenderPass(commandBuffer)
    }

    inline fun cmdSetScissor(commandBuffer: VkCommandBuffer, firstScissor: Int, scissors: VkRect2D.Buffer) {
        VK10.nvkCmdSetScissor(commandBuffer, firstScissor, scissors.remaining(), scissors.adr)
    }

    inline fun cmdSetViewport(commandBuffer: VkCommandBuffer, firstViewport: Int, viewports: VkViewport.Buffer) {
        VK10.nvkCmdSetViewport(commandBuffer, firstViewport, viewports.remaining(), viewports.adr)
    }

    inline fun createBuffer(device: VkDevice, createInfo: VkBufferCreateInfo, buffer: KMutableProperty0<VkBuffer>): VkResult {
        val pBuffer = appBuffer.long
        return VkResult of VK10.nvkCreateBuffer(device, createInfo.adr, NULL, pBuffer).also {
            buffer.set(memGetLong(pBuffer))
        }
    }

    inline fun createCommandPool(device: VkDevice, createInfo: VkCommandPoolCreateInfo, commandPool: KMutableProperty0<VkCommandPool>): VkResult {
        val pCommandPool = appBuffer.long
        return VkResult of VK10.nvkCreateCommandPool(device, createInfo.adr, NULL, pCommandPool).also {
            commandPool.set(memGetLong(pCommandPool))
        }
    }

    inline fun createCommandPool(device: VkDevice, createInfo: VkCommandPoolCreateInfo, commandPool: LongBuffer): VkResult {
        return VkResult of VK10.nvkCreateCommandPool(device, createInfo.adr, NULL, memAddress(commandPool))
    }

    inline fun createDebugReportCallbackEXT(instance: VkInstance, createInfo: VkDebugReportCallbackCreateInfoEXT,
                                            callback: KMutableProperty0<Long>): VkResult {
        val long = appBuffer.long
        return VkResult of EXTDebugReport.nvkCreateDebugReportCallbackEXT(instance, createInfo.adr, NULL, long).also {
            callback.set(MemoryUtil.memGetLong(long))
        }
    }

    inline fun createDescriptorPool(device: VkDevice, createInfo: VkDescriptorPoolCreateInfo,
                                    descriptorPool: KMutableProperty0<VkDescriptorPool>): VkResult {
        val pDescriptorPool = appBuffer.long
        return VkResult of VK10.nvkCreateDescriptorPool(device, createInfo.adr, NULL, pDescriptorPool).also {
            descriptorPool.set(memGetLong(pDescriptorPool))
        }
    }

    inline fun createDescriptorSetLayout(device: VkDevice, createInfo: VkDescriptorSetLayoutCreateInfo,
                                         setLayout: KMutableProperty0<VkDescriptorSetLayout>): VkResult {
        val pSetLayout = appBuffer.long
        return VkResult of VK10.nvkCreateDescriptorSetLayout(device, createInfo.adr, NULL, pSetLayout).also {
            setLayout.set(memGetLong(pSetLayout))
        }
    }

    inline fun createDevice(physicalDevice: VkPhysicalDevice, createInfo: VkDeviceCreateInfo, device: KMutableProperty0<VkDevice?>)
            : VkResult {
        val pDevice = appBuffer.pointer
        return VkResult of VK10.nvkCreateDevice(physicalDevice, createInfo.adr, NULL, pDevice).also {
            device.set(VkDevice(memGetLong(pDevice), physicalDevice, createInfo))
        }
    }

    inline fun createFence(device: VkDevice, createInfo: VkFenceCreateInfo, fence: LongBuffer): VkResult {
        val pFence = appBuffer.long
        return VkResult of VK10.nvkCreateFence(device, createInfo.adr, NULL, pFence).also {
            fence[0] = memGetLong(pFence)
        }
    }

    inline fun createFences(device: VkDevice, createInfo: VkFenceCreateInfo, fences: ArrayList<VkFence>) {
        val pFence = appBuffer.long
        for (i in fences.indices) {
            VK_CHECK_RESULT(VK10.nvkCreateFence(device, createInfo.adr, NULL, pFence))
            fences[i] = memGetLong(pFence)
        }
    }

    inline fun createFramebuffer(device: VkDevice, createInfo: VkFramebufferCreateInfo, framebuffer: ArrayList<VkFramebuffer>, index: Int): VkResult {
        val pFramebuffer = appBuffer.long
        return VkResult of VK10.nvkCreateFramebuffer(device, createInfo.adr, NULL, pFramebuffer).also {
            framebuffer[index] = memGetLong(pFramebuffer)
        }
    }

    inline fun createGraphicsPipelines(device: VkDevice, pipelineCache: VkPipelineCache,
                                       createInfo: VkGraphicsPipelineCreateInfo,
                                       pipelines: KMutableProperty0<VkPipeline>): VkResult {
        val pPipelines = appBuffer.long
        return VkResult of VK10.nvkCreateGraphicsPipelines(device, pipelineCache, 1, createInfo.adr, NULL, pPipelines).also {
            pipelines.set(memGetLong(pPipelines))
        }
    }

    inline fun createGraphicsPipelines(device: VkDevice, pipelineCache: VkPipelineCache,
                                       createInfos: VkGraphicsPipelineCreateInfo.Buffer,
                                       pipelines: KMutableProperty0<VkPipeline>): VkResult {
        val pPipelines = appBuffer.long
        return VkResult of VK10.nvkCreateGraphicsPipelines(device, pipelineCache, createInfos.remaining(), createInfos.adr, NULL, pPipelines).also {
            pipelines.set(memGetLong(pPipelines))
        }
    }

    inline fun createImage(device: VkDevice, createInfo: VkImageCreateInfo, image: KMutableProperty0<VkImage>): VkResult {
        val pImage = appBuffer.long
        return VkResult of VK10.nvkCreateImage(device, createInfo.adr, NULL, pImage).also {
            image.set(memGetLong(pImage))
        }
    }

    inline fun createImageView(device: VkDevice, createInfo: VkImageViewCreateInfo, view: KMutableProperty0<VkImageView>): VkResult {
        val pView = appBuffer.long
        return VkResult of VK10.nvkCreateImageView(device, createInfo.adr, NULL, pView).also {
            view.set(memGetLong(pView))
        }
    }

    inline infix fun createInstance(createInfo: VkInstanceCreateInfo): VkInstance {
        val pInstance = appBuffer.pointer
        val res = VK10.nvkCreateInstance(createInfo.adr, NULL, pInstance)
        return VkInstance(MemoryUtil.memGetLong(pInstance), createInfo)
    }

    inline fun createInstance(createInfo: VkInstanceCreateInfo, instance: KMutableProperty0<VkInstance>): VkResult {
        val pInstance = appBuffer.pointer
        val res = VK10.nvkCreateInstance(createInfo.adr, NULL, pInstance)
        instance.set(VkInstance(MemoryUtil.memGetLong(pInstance), createInfo))
        return VkResult of res
    }

    inline fun createPipelineCache(device: VkDevice, createInfo: VkPipelineCacheCreateInfo, pipelineCache: KMutableProperty0<VkPipelineCache>): VkResult {
        val pPipelineCache = appBuffer.long
        return VkResult of VK10.nvkCreatePipelineCache(device, createInfo.adr, NULL, pPipelineCache).also {
            pipelineCache.set(memGetLong(pPipelineCache))
        }
    }

    inline fun createPipelineLayout(device: VkDevice, createInfo: VkPipelineLayoutCreateInfo,
                                    pipelineLayout: KMutableProperty0<VkPipelineLayout>): VkResult {
        val pPipelineLayout = appBuffer.long
        return VkResult of VK10.nvkCreatePipelineLayout(device, createInfo.adr, NULL, pPipelineLayout).also {
            pipelineLayout.set(memGetLong(pPipelineLayout))
        }
    }

    inline fun createRenderPass(device: VkDevice, createInfo: VkRenderPassCreateInfo, renderPass: KMutableProperty0<VkRenderPass>): VkResult {
        val pRenderPass = appBuffer.long
        return VkResult of VK10.nvkCreateRenderPass(device, createInfo.adr, NULL, pRenderPass).also {
            renderPass.set(memGetLong(pRenderPass))
        }
    }

    inline fun createSemaphore(device: VkDevice, createInfo: VkSemaphoreCreateInfo, semaphore: KMutableProperty0<VkSemaphore>): VkResult {
        val pSemaphore = appBuffer.long
        return VkResult of VK10.nvkCreateSemaphore(device, createInfo.adr, NULL, pSemaphore).also {
            semaphore.set(memGetLong(pSemaphore))
        }
    }

    inline fun createSemaphore(device: VkDevice, createInfo: VkSemaphoreCreateInfo, semaphore: VkSemaphoreBuffer): VkResult {
        return VkResult of VK10.nvkCreateSemaphore(device, createInfo.adr, NULL, memAddress(semaphore))
    }

    inline fun createShaderModule(device: VkDevice, createInfo: VkShaderModuleCreateInfo, shaderModule: LongBuffer): VkResult {
        return VkResult of VK10.nvkCreateShaderModule(device, createInfo.adr, NULL, memAddress(shaderModule))
    }

    inline fun createSwapchainKHR(device: VkDevice, createInfo: VkSwapchainCreateInfoKHR, swapchain: KMutableProperty0<VkSwapchainKHR>)
            : VkResult {
        val pSwapchain = appBuffer.long
        return VkResult of KHRSwapchain.nvkCreateSwapchainKHR(device, createInfo.adr, NULL, pSwapchain).also {
            swapchain.set(memGetLong(pSwapchain))
        }
    }

    inline fun destroyDescriptorPool(device: VkDevice, descriptorPool: VkDescriptorPool) {
        VK10.nvkDestroyDescriptorPool(device, descriptorPool, NULL)
    }

    inline fun destroyDescriptorSetLayout(device: VkDevice, descriptorSetLayout: VkDescriptorSetLayout) {
        VK10.nvkDestroyDescriptorSetLayout(device, descriptorSetLayout, NULL)
    }

    inline fun destroyBuffer(device: VkDevice, buffer: VkBuffer) {
        VK10.nvkDestroyBuffer(device, buffer, NULL)
    }

    inline fun destroyCommandPool(device: VkDevice, commandPool: VkCommandPool) {
        VK10.nvkDestroyCommandPool(device, commandPool, NULL)
    }

    inline fun destroyFence(device: VkDevice, fence: VkFence) {
        VK10.nvkDestroyFence(device, fence, NULL)
    }

    inline fun destroyFences(device: VkDevice, fences: Iterable<VkFence>) {
        for (i in fences)
            VK10.nvkDestroyFence(device, i, NULL)
    }

    inline fun destroyFramebuffers(device: VkDevice, framebuffers: Iterable<VkFramebuffer>) {
        for (i in framebuffers)
            VK10.nvkDestroyFramebuffer(device, i, NULL)
    }

    inline fun destroyImage(device: VkDevice, image: VkImage) {
        VK10.nvkDestroyImage(device, image, NULL)
    }

    inline fun destroyImageView(device: VkDevice, imageView: VkImageView) {
        VK10.nvkDestroyImageView(device, imageView, NULL)
    }

    inline fun destroyPipeline(device: VkDevice, pipeline: VkPipeline) {
        VK10.nvkDestroyPipeline(device, pipeline, NULL)
    }

    inline fun destroyPipelineCache(device: VkDevice, pipelineCache: VkPipelineCache) {
        VK10.nvkDestroyPipelineCache(device, pipelineCache, NULL)
    }

    inline fun destroyPipelineLayout(device: VkDevice, pipelineLayout: VkPipelineLayout) {
        VK10.nvkDestroyPipelineLayout(device, pipelineLayout, NULL)
    }

    inline fun destroyRenderPass(device: VkDevice, renderPass: VkRenderPass) {
        VK10.nvkDestroyRenderPass(device, renderPass, NULL)
    }

    inline fun destroySemaphore(device: VkDevice, semaphore: VkSemaphore) {
        VK10.nvkDestroySemaphore(device, semaphore, NULL)
    }

    inline fun destroyShaderModules(device: VkDevice, shaderModules: Iterable<VkShaderModule>, allocator: VkAllocationCallbacks? = null) {
        for (i in shaderModules)
            VK10.nvkDestroyShaderModule(device, i, allocator?.address() ?: NULL)
    }

    inline fun destroyShaderModules(device: VkDevice, shaderModules: VkPipelineShaderStageCreateInfo.Buffer) {
        for (i in shaderModules)
            VK10.nvkDestroyShaderModule(device, i.module, NULL)
    }

    inline fun destroySwapchainKHR(device: VkDevice, swapchain: VkSwapchainKHR) {
        KHRSwapchain.nvkDestroySwapchainKHR(device, swapchain, NULL)
    }

    inline fun endCommandBuffer(commandBuffer: VkCommandBuffer): VkResult {
        return VkResult of VK10.vkEndCommandBuffer(commandBuffer)
    }

    inline fun enumerateDeviceExtensionProperties(physicalDevice: VkPhysicalDevice, layerName: String? = null): ArrayList<String> {
        val pCount = appBuffer.int
        val pLayerName = layerName?.utf8?.let(::memAddress) ?: NULL
        VK_CHECK_RESULT(VK10.nvkEnumerateDeviceExtensionProperties(physicalDevice, pLayerName, pCount, NULL))
        val count = memGetInt(pCount)
        val res = ArrayList<String>(count)
        if (count > 0) {
            val properties = ExtensionProperties(count)
            VK_CHECK_RESULT(VK10.nvkEnumerateDeviceExtensionProperties(physicalDevice, pLayerName, pCount, properties.adr))
            properties.map { it.extensionNameString() }.toCollection(res)
        }
        return res
    }

    inline fun enumeratePhysicalDevices(instance: VkInstance): ArrayList<VkPhysicalDevice> {
        val physicalDevices = ArrayList<VkPhysicalDevice>()
        val pPhysicalDeviceCount = appBuffer.int
        var physicalDeviceCount: Int
        var result: Int
        do {
            result = VK10.nvkEnumeratePhysicalDevices(instance, pPhysicalDeviceCount, NULL)
            physicalDeviceCount = memGetInt(pPhysicalDeviceCount)
            if (result == VkResult.SUCCESS.i && physicalDeviceCount > 0) {
                val pPhysicalDevices = appBuffer.pointerBuffer(physicalDeviceCount)
                result = VK10.nvkEnumeratePhysicalDevices(instance, pPhysicalDeviceCount, pPhysicalDevices.adr)
                for (i in 0 until physicalDeviceCount)
                    physicalDevices += VkPhysicalDevice(pPhysicalDevices[i], instance)
            }
        } while (result == VkResult.INCOMPLETE.i)
        assert(physicalDeviceCount <= physicalDevices.size)
        physicalDevices resize physicalDeviceCount
        return physicalDevices
    }

    inline fun flushMappedMemoryRange(device: VkDevice, memoryRange: VkMappedMemoryRange): VkResult {
        return VkResult of VK10.nvkFlushMappedMemoryRanges(device, 1, memoryRange.adr)
    }

    inline fun freeCommandBuffers(device: VkDevice, commandPool: VkCommandPool, commandBuffers: ArrayList<VkCommandBuffer>) {
        val pointers = appBuffer.pointerArray(commandBuffers.size)
        for (i in commandBuffers.indices)
            memPutAddress(pointers + Pointer.POINTER_SIZE * i, commandBuffers[i].adr)
        return VK10.nvkFreeCommandBuffers(device, commandPool, commandBuffers.size, pointers)
    }

    inline fun freeMemory(device: VkDevice, memory: VkDeviceMemory) {
        VK10.nvkFreeMemory(device, memory, NULL)
    }

    inline fun getDeviceQueue(device: VkDevice, queueFamilyIndex: Int, queueIndex: Int, queue: KMutableProperty0<VkQueue>) {
        val pQueue = appBuffer.pointer
        VK10.nvkGetDeviceQueue(device, queueFamilyIndex, queueIndex, pQueue)
        queue.set(VkQueue(memGetLong(pQueue), device))
    }

    inline fun getPhysicalDeviceFormatProperties(physicalDevice: VkPhysicalDevice, format: VkFormat): VkFormatProperties {
        return FormatProperties {
            VK10.nvkGetPhysicalDeviceFormatProperties(physicalDevice, format.i, adr)
        }
    }

    inline fun getPhysicalDeviceQueueFamilyProperties(physicalDevice: VkPhysicalDevice): ArrayList<VkQueueFamilyProperties> {
        val pCount = appBuffer.int
        VK10.nvkGetPhysicalDeviceQueueFamilyProperties(physicalDevice, pCount, NULL)
        val count = memGetInt(pCount)
        val pQueueFamilyProperties = VkQueueFamilyProperties.calloc(count)
        VK10.nvkGetPhysicalDeviceQueueFamilyProperties(physicalDevice, pCount, pQueueFamilyProperties.adr)
        return pQueueFamilyProperties.toCollection(arrayListOf())
    }

    inline fun getPhysicalDeviceSurfaceSupportKHR(physicalDevice: VkPhysicalDevice,
                                                  queueFamily: Int,
                                                  surface: VkSurfaceKHR): Boolean {
        val supported = appBuffer.int
        KHRSurface.nvkGetPhysicalDeviceSurfaceSupportKHR(physicalDevice, queueFamily, surface, supported)
        return memGetBoolean(supported)
    }

    inline fun getPhysicalDeviceSurfaceSupportKHR(physicalDevice: VkPhysicalDevice,
                                                  queueFamilyProperties: ArrayList<VkQueueFamilyProperties>,
                                                  surface: VkSurfaceKHR): BooleanArray {
        val supported = appBuffer.int
        return BooleanArray(queueFamilyProperties.size) {
            KHRSurface.nvkGetPhysicalDeviceSurfaceSupportKHR(physicalDevice, it, surface, supported)
            memGetBoolean(supported)
        }
    }

    inline fun getPhysicalDeviceSurfaceFormatsKHR(physicalDevice: VkPhysicalDevice, surface: VkSurfaceKHR): ArrayList<VkSurfaceFormatKHR> {
        val pCount = appBuffer.int
        VK_CHECK_RESULT(KHRSurface.nvkGetPhysicalDeviceSurfaceFormatsKHR(physicalDevice, surface, pCount, NULL))
        val count = memGetInt(pCount)
        assert(count > 0)
        val surfaceFormats = SurfaceFormatKHR(count)
        VK_CHECK_RESULT(KHRSurface.nvkGetPhysicalDeviceSurfaceFormatsKHR(physicalDevice, surface, pCount, surfaceFormats.adr))
        return surfaceFormats.toCollection(arrayListOf())
    }

    inline fun getPhysicalDeviceSurfaceCapabilitiesKHR(physicalDevice: VkPhysicalDevice, surface: VkSurfaceKHR): VkSurfaceCapabilitiesKHR {
        return SurfaceCapabilitiesKHR {
            VK_CHECK_RESULT(KHRSurface.nvkGetPhysicalDeviceSurfaceCapabilitiesKHR(physicalDevice, surface, adr))
        }
    }

    inline fun getPhysicalDeviceSurfacePresentModesKHR(physicalDevice: VkPhysicalDevice, surface: VkSurfaceKHR): ArrayList<VkPresentMode> {
        val pCount = appBuffer.int
        VK_CHECK_RESULT(KHRSurface.nvkGetPhysicalDeviceSurfacePresentModesKHR(physicalDevice, surface, pCount, NULL))
        val count = memGetInt(pCount)
        assert(count > 0)
        val presentModes = appBuffer.intArray(count)
        KHRSurface.nvkGetPhysicalDeviceSurfacePresentModesKHR(physicalDevice, surface, pCount, presentModes)
        val res = ArrayList<VkPresentMode>()
        for (i in 0 until count) res += VkPresentMode of memGetInt(presentModes + Int.BYTES * i)
        return res
    }

    inline fun getSwapchainImagesKHR(device: VkDevice, swapchain: VkSwapchainKHR): VkImageViewArray {
        val pCount = appBuffer.int
        VK_CHECK_RESULT(KHRSwapchain.nvkGetSwapchainImagesKHR(device, swapchain, pCount, NULL))
        val count = memGetInt(pCount)
        val images = appBuffer.longArray(count)
        VK_CHECK_RESULT(KHRSwapchain.nvkGetSwapchainImagesKHR(device, swapchain, pCount, images))
        return VkImageViewArray(count) { memGetLong(images + Long.BYTES * it) }
    }

    inline fun invalidateMappedMemoryRanges(device: VkDevice, memoryRange: VkMappedMemoryRange): VkResult {
        return VkResult of VK10.nvkInvalidateMappedMemoryRanges(device, 1, memoryRange.adr)
    }

    inline fun queueSubmit(queue: VkQueue, submit: VkSubmitInfo, fence: VkFence = NULL): VkResult {
        return VkResult of VK10.nvkQueueSubmit(queue, 1, submit.adr, fence)
    }

    inline fun updateDescriptorSets(device: VkDevice, descriptorWrites: VkWriteDescriptorSet.Buffer,
                                    descriptorCopies: VkCopyDescriptorSet.Buffer? = null) {
        return VK10.nvkUpdateDescriptorSets(device, descriptorWrites.remaining(), descriptorWrites.adr,
                descriptorCopies?.remaining() ?: 0, descriptorCopies?.adr ?: NULL)
    }
}
