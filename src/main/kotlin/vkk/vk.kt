package vkk

import glm_.*
import glm_.vec2.Vec2i
import kool.stak
import org.lwjgl.system.MemoryStack.stackGet
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.system.Pointer
import org.lwjgl.system.Struct
import org.lwjgl.vulkan.*
import org.lwjgl.vulkan.VK10.VK_QUEUE_FAMILY_IGNORED
import vkk.VkPhysicalDeviceArrayList.resize
import java.nio.ByteBuffer
import java.nio.LongBuffer
import kotlin.reflect.KMutableProperty0


object vk {

    inline fun ApplicationInfo(block: VkApplicationInfo.() -> Unit): VkApplicationInfo =
            VkApplicationInfo.callocStack().apply {
                type = VkStructureType.APPLICATION_INFO
                block()
            }

    inline fun BufferCreateInfo(block: VkBufferCreateInfo.() -> Unit): VkBufferCreateInfo =
            VkBufferCreateInfo.callocStack().apply {
                type = VkStructureType.BUFFER_CREATE_INFO
                block()
            }

    inline fun BufferMemoryBarrier(block: VkBufferMemoryBarrier.() -> Unit): VkBufferMemoryBarrier =
            VkBufferMemoryBarrier.callocStack().apply {
                type = VkStructureType.BUFFER_MEMORY_BARRIER
                block()
            }

    fun CommandBufferAllocateInfo(commandPool: VkCommandPool, level: VkCommandBufferLevel, bufferCount: Int): VkCommandBufferAllocateInfo =
            CommandBufferAllocateInfo {
                this.commandPool = commandPool
                this.level = level
                commandBufferCount = bufferCount
            }

    inline fun CommandBufferAllocateInfo(block: VkCommandBufferAllocateInfo.() -> Unit): VkCommandBufferAllocateInfo =
            VkCommandBufferAllocateInfo.callocStack().apply {
                type = VkStructureType.COMMAND_BUFFER_ALLOCATE_INFO
                block()
            }

    fun CommandBufferBeginInfo(): VkCommandBufferBeginInfo =
            VkCommandBufferBeginInfo.callocStack().apply {
                type = VkStructureType.COMMAND_BUFFER_BEGIN_INFO
            }

    inline fun CommandBufferBeginInfo(block: VkCommandBufferBeginInfo.() -> Unit): VkCommandBufferBeginInfo =
            CommandBufferBeginInfo().also(block)

    inline fun CommandPoolCreateInfo(block: VkCommandPoolCreateInfo.() -> Unit): VkCommandPoolCreateInfo =
            VkCommandPoolCreateInfo.callocStack().apply {
                type = VkStructureType.COMMAND_POOL_CREATE_INFO
                block()
            }

    inline fun ComputePipelineCreateInfo(block: VkComputePipelineCreateInfo.() -> Unit): VkComputePipelineCreateInfo =
            VkComputePipelineCreateInfo.callocStack().apply {
                type = VkStructureType.COMPUTE_PIPELINE_CREATE_INFO
                block()
            }

    inline fun DebugMarkerMarkerInfoEXT(block: VkDebugMarkerMarkerInfoEXT.() -> Unit): VkDebugMarkerMarkerInfoEXT =
            VkDebugMarkerMarkerInfoEXT.callocStack().apply {
                type = VkStructureType.DEBUG_MARKER_OBJECT_NAME_INFO_EXT
                block()
            }

    inline fun DebugMarkerObjectNameInfoEXT(block: VkDebugMarkerObjectNameInfoEXT.() -> Unit): VkDebugMarkerObjectNameInfoEXT =
            VkDebugMarkerObjectNameInfoEXT.callocStack().apply {
                type = VkStructureType.DEBUG_MARKER_OBJECT_NAME_INFO_EXT
                block()
            }

    inline fun DebugMarkerObjectTagInfoEXT(block: VkDebugMarkerObjectTagInfoEXT .() -> Unit): VkDebugMarkerObjectTagInfoEXT =
            VkDebugMarkerObjectTagInfoEXT.callocStack().apply {
                type = VkStructureType.DEBUG_MARKER_OBJECT_TAG_INFO_EXT
                block()
            }

    inline fun DebugReportCallbackCreateInfoEXT(block: VkDebugReportCallbackCreateInfoEXT.() -> Unit): VkDebugReportCallbackCreateInfoEXT =
            VkDebugReportCallbackCreateInfoEXT.callocStack().apply {
                type = VkStructureType.DEBUG_REPORT_CALLBACK_CREATE_INFO_EXT
                block()
            }

    inline fun DescriptorBufferInfo(block: VkDescriptorBufferInfo.() -> Unit): VkDescriptorBufferInfo =
            VkDescriptorBufferInfo.callocStack().also(block)

//    inline fun DescriptorBufferInfo(capacity: Int, block: VkDescriptorBufferInfo.() -> Unit): VkDescriptorBufferInfo.Buffer =
//            VkDescriptorBufferInfo.callocStack(capacity).
//        res[0].block()
//        return res
//    }

    inline fun DescriptorPoolCreateInfo(block: VkDescriptorPoolCreateInfo.() -> Unit): VkDescriptorPoolCreateInfo =
            VkDescriptorPoolCreateInfo.callocStack().apply {
                type = VkStructureType.DESCRIPTOR_POOL_CREATE_INFO
                block()
            }

    inline fun DescriptorSetAllocateInfo(block: VkDescriptorSetAllocateInfo.() -> Unit): VkDescriptorSetAllocateInfo =
            VkDescriptorSetAllocateInfo.callocStack().apply {
                type = VkStructureType.DESCRIPTOR_SET_ALLOCATE_INFO
                block()
            }

    inline fun DescriptorSetLayoutCreateInfo(block: VkDescriptorSetLayoutCreateInfo.() -> Unit): VkDescriptorSetLayoutCreateInfo =
            VkDescriptorSetLayoutCreateInfo.callocStack().apply {
                type = VkStructureType.DESCRIPTOR_SET_LAYOUT_CREATE_INFO
                block()
            }

    inline fun DeviceCreateInfo(block: VkDeviceCreateInfo.() -> Unit): VkDeviceCreateInfo =
            VkDeviceCreateInfo.callocStack().apply {
                type = VkStructureType.DEVICE_CREATE_INFO
                block()
            }

    fun DeviceQueueCreateInfo(): VkDeviceQueueCreateInfo =
            VkDeviceQueueCreateInfo.callocStack().apply { type = VkStructureType.DEVICE_QUEUE_CREATE_INFO }

    inline fun DeviceQueueCreateInfo(block: VkDeviceQueueCreateInfo.() -> Unit): VkDeviceQueueCreateInfo =
            DeviceQueueCreateInfo().also(block)

    inline fun DeviceQueueCreateInfo(capacity: Int, block: VkDeviceQueueCreateInfo.() -> Unit): VkDeviceQueueCreateInfo.Buffer {
        val res = VkDeviceQueueCreateInfo.callocStack(capacity)
        res.forEach { it.type = VkStructureType.DEVICE_QUEUE_CREATE_INFO }
        res[0].block()
        return res
    }

    inline fun FenceCreateInfo(block: VkFenceCreateInfo.() -> Unit): VkFenceCreateInfo =
            VkFenceCreateInfo.callocStack().apply {
                type = VkStructureType.FENCE_CREATE_INFO
                block()
            }

    inline fun FramebufferCreateInfo(block: VkFramebufferCreateInfo.() -> Unit): VkFramebufferCreateInfo =
            VkFramebufferCreateInfo.callocStack().apply {
                type = VkStructureType.FRAMEBUFFER_CREATE_INFO
                block()
            }

    fun GraphicsPipelineCreateInfo(): VkGraphicsPipelineCreateInfo =
            VkGraphicsPipelineCreateInfo.callocStack().apply { type = VkStructureType.GRAPHICS_PIPELINE_CREATE_INFO }

    inline fun GraphicsPipelineCreateInfo(block: VkGraphicsPipelineCreateInfo.() -> Unit): VkGraphicsPipelineCreateInfo =
            GraphicsPipelineCreateInfo().also(block)

    inline fun GraphicsPipelineCreateInfo(capacity: Int, block: VkGraphicsPipelineCreateInfo.() -> Unit): VkGraphicsPipelineCreateInfo.Buffer {
        val res = VkGraphicsPipelineCreateInfo.callocStack(capacity)
        res.forEach { it.type = VkStructureType.GRAPHICS_PIPELINE_CREATE_INFO }
        res[0].block()
        return res
    }

    inline fun ImageCreateInfo(block: VkImageCreateInfo.() -> Unit): VkImageCreateInfo =
            VkImageCreateInfo.callocStack().apply {
                type = VkStructureType.IMAGE_CREATE_INFO
                block()
            }

    inline fun ImageMemoryBarrier(block: VkImageMemoryBarrier.() -> Unit): VkImageMemoryBarrier =
            VkImageMemoryBarrier.callocStack().apply {
                type = VkStructureType.IMAGE_MEMORY_BARRIER
                srcQueueFamilyIndex = VK_QUEUE_FAMILY_IGNORED
                dstQueueFamilyIndex = VK_QUEUE_FAMILY_IGNORED
                block()
            }

    inline fun ImageMemoryBarrier(capacity: Int, block: VkImageMemoryBarrier.() -> Unit): VkImageMemoryBarrier.Buffer {
        val res = VkImageMemoryBarrier.callocStack(capacity)
        res.forEach { it.type = VkStructureType.IMAGE_MEMORY_BARRIER }
        res[0].block()
        return res
    }

    inline fun ImageViewCreateInfo(block: VkImageViewCreateInfo.() -> Unit): VkImageViewCreateInfo =
            VkImageViewCreateInfo.callocStack().apply {
                type = VkStructureType.IMAGE_VIEW_CREATE_INFO
                block()
            }

    fun InstanceCreateInfo(): VkInstanceCreateInfo =
            VkInstanceCreateInfo.callocStack().apply { type = VkStructureType.INSTANCE_CREATE_INFO }

    inline fun InstanceCreateInfo(block: VkInstanceCreateInfo.() -> Unit): VkInstanceCreateInfo =
            InstanceCreateInfo().also(block)

    fun MappedMemoryRange(): VkMappedMemoryRange =
            VkMappedMemoryRange.callocStack().apply { type = VkStructureType.MAPPED_MEMORY_RANGE }

    fun MappedMemoryRange(capacity: Int): VkMappedMemoryRange.Buffer =
            VkMappedMemoryRange.callocStack(capacity).also {
                for (range in it)
                    range.type = VkStructureType.MAPPED_MEMORY_RANGE
            }

    inline fun MappedMemoryRange(block: VkMappedMemoryRange.() -> Unit): VkMappedMemoryRange =
            MappedMemoryRange().also(block)

    inline fun MemoryAllocateInfo(block: VkMemoryAllocateInfo.() -> Unit): VkMemoryAllocateInfo =
            VkMemoryAllocateInfo.callocStack().apply {
                type = VkStructureType.MEMORY_ALLOCATE_INFO
                block()
            }

    fun PhysicalDeviceFeatures(): VkPhysicalDeviceFeatures =
            VkPhysicalDeviceFeatures.callocStack()

    inline fun PhysicalDeviceFeatures(block: VkPhysicalDeviceFeatures.() -> Unit): VkPhysicalDeviceFeatures =
            PhysicalDeviceFeatures().also(block)

    fun PhysicalDeviceMemoryProperties(): VkPhysicalDeviceMemoryProperties =
            VkPhysicalDeviceMemoryProperties.callocStack()

    fun PhysicalDeviceProperties(): VkPhysicalDeviceProperties =
            VkPhysicalDeviceProperties.callocStack()

    fun PipelineCacheCreateInfo(): VkPipelineCacheCreateInfo =
            VkPipelineCacheCreateInfo.callocStack().apply { type = VkStructureType.PIPELINE_CACHE_CREATE_INFO }

    inline fun PipelineCacheCreateInfo(block: VkPipelineCacheCreateInfo.() -> Unit): VkPipelineCacheCreateInfo =
            PipelineCacheCreateInfo().also(block)

    inline fun PipelineColorBlendStateCreateInfo(block: VkPipelineColorBlendStateCreateInfo.() -> Unit): VkPipelineColorBlendStateCreateInfo =
            VkPipelineColorBlendStateCreateInfo.callocStack().apply {
                type = VkStructureType.PIPELINE_COLOR_BLEND_STATE_CREATE_INFO
                block()
            }

    fun PipelineDepthStencilStateCreateInfo(): VkPipelineDepthStencilStateCreateInfo =
            VkPipelineDepthStencilStateCreateInfo.callocStack().apply { type = VkStructureType.PIPELINE_DEPTH_STENCIL_STATE_CREATE_INFO }

    inline fun PipelineDepthStencilStateCreateInfo(block: VkPipelineDepthStencilStateCreateInfo.() -> Unit): VkPipelineDepthStencilStateCreateInfo =
            PipelineDepthStencilStateCreateInfo().also(block)

    inline fun PipelineDynamicStateCreateInfo(block: VkPipelineDynamicStateCreateInfo.() -> Unit): VkPipelineDynamicStateCreateInfo =
            VkPipelineDynamicStateCreateInfo.callocStack().apply {
                type = VkStructureType.PIPELINE_DYNAMIC_STATE_CREATE_INFO
                block()
            }

    inline fun PipelineInputAssemblyStateCreateInfo(block: VkPipelineInputAssemblyStateCreateInfo.() -> Unit): VkPipelineInputAssemblyStateCreateInfo =
            VkPipelineInputAssemblyStateCreateInfo.callocStack().apply {
                type = VkStructureType.PIPELINE_INPUT_ASSEMBLY_STATE_CREATE_INFO
                block()
            }

    fun PipelineLayoutCreateInfo(): VkPipelineLayoutCreateInfo =
            VkPipelineLayoutCreateInfo.callocStack().apply { type = VkStructureType.PIPELINE_LAYOUT_CREATE_INFO }

    inline fun PipelineLayoutCreateInfo(block: VkPipelineLayoutCreateInfo.() -> Unit): VkPipelineLayoutCreateInfo =
            PipelineLayoutCreateInfo().also(block)

    inline fun PipelineMultisampleStateCreateInfo(block: VkPipelineMultisampleStateCreateInfo.() -> Unit): VkPipelineMultisampleStateCreateInfo =
            VkPipelineMultisampleStateCreateInfo.callocStack().apply {
                type = VkStructureType.PIPELINE_MULTISAMPLE_STATE_CREATE_INFO
                block()
            }

    inline fun PipelineRasterizationStateCreateInfo(block: VkPipelineRasterizationStateCreateInfo.() -> Unit): VkPipelineRasterizationStateCreateInfo =
            VkPipelineRasterizationStateCreateInfo.callocStack().apply {
                type = VkStructureType.PIPELINE_RASTERIZATION_STATE_CREATE_INFO
                block()
            }

    fun PipelineShaderStageCreateInfo(capacity: Int): VkPipelineShaderStageCreateInfo.Buffer =
            VkPipelineShaderStageCreateInfo.callocStack(capacity).also {
                for (info in it)
                    info.type = VkStructureType.PIPELINE_SHADER_STAGE_CREATE_INFO
            }

    fun PipelineVertexInputStateCreateInfo(): VkPipelineVertexInputStateCreateInfo =
            VkPipelineVertexInputStateCreateInfo.callocStack().apply { type = VkStructureType.PIPELINE_VERTEX_INPUT_STATE_CREATE_INFO }

    inline fun PipelineVertexInputStateCreateInfo(block: VkPipelineVertexInputStateCreateInfo.() -> Unit): VkPipelineVertexInputStateCreateInfo =
            PipelineVertexInputStateCreateInfo().also(block)

    inline fun PipelineViewportStateCreateInfo(block: VkPipelineViewportStateCreateInfo.() -> Unit): VkPipelineViewportStateCreateInfo =
            VkPipelineViewportStateCreateInfo.callocStack().apply {
                type = VkStructureType.PIPELINE_VIEWPORT_STATE_CREATE_INFO
                block()
            }

    inline fun PushConstantRange(block: VkPushConstantRange.() -> Unit): VkPushConstantRange =
            VkPushConstantRange.callocStack().also(block)

    inline fun PushConstantRange(capacity: Int, block: VkPushConstantRange.() -> Unit): VkPushConstantRange.Buffer =
            VkPushConstantRange.callocStack(capacity).also { it[0].block() }

    inline fun PresentInfoKHR(block: VkPresentInfoKHR.() -> Unit): VkPresentInfoKHR =
            VkPresentInfoKHR.callocStack().apply {
                type = VkStructureType.PRESENT_INFO_KHR
                block()
            }

    fun QueryPoolCreateInfo(): VkQueryPoolCreateInfo =
            VkQueryPoolCreateInfo.callocStack().apply { type = VkStructureType.QUERY_POOL_CREATE_INFO }

    inline fun QueryPoolCreateInfo(block: VkQueryPoolCreateInfo.() -> Unit): VkQueryPoolCreateInfo =
            QueryPoolCreateInfo().also(block)

    inline fun RenderPassBeginInfo(block: VkRenderPassBeginInfo.() -> Unit): VkRenderPassBeginInfo =
            VkRenderPassBeginInfo.callocStack().apply {
                type = VkStructureType.RENDER_PASS_BEGIN_INFO
                block()
            }

    fun RenderPassCreateInfo(): VkRenderPassCreateInfo =
            VkRenderPassCreateInfo.callocStack().apply { type = VkStructureType.RENDER_PASS_CREATE_INFO }

    inline fun RenderPassCreateInfo(block: VkRenderPassCreateInfo.() -> Unit): VkRenderPassCreateInfo =
            RenderPassCreateInfo().also(block)

    inline fun SamplerCreateInfo(block: VkSamplerCreateInfo.() -> Unit): VkSamplerCreateInfo =
            VkSamplerCreateInfo.callocStack().apply {
                type = VkStructureType.SAMPLER_CREATE_INFO
                maxAnisotropy = 1f
                block()
            }

    fun SemaphoreCreateInfo(): VkSemaphoreCreateInfo =
            VkSemaphoreCreateInfo.callocStack().apply { type = VkStructureType.SEMAPHORE_CREATE_INFO }

    inline fun SemaphoreCreateInfo(block: VkSemaphoreCreateInfo.() -> Unit): VkSemaphoreCreateInfo =
            SemaphoreCreateInfo().also(block)

    inline fun ShaderModuleCreateInfo(block: VkShaderModuleCreateInfo.() -> Unit): VkShaderModuleCreateInfo =
            VkShaderModuleCreateInfo.callocStack().apply {
                type = VkStructureType.SHADER_MODULE_CREATE_INFO
                block()
            }

    fun SubmitInfo(): VkSubmitInfo =
            VkSubmitInfo.callocStack().apply { type = VkStructureType.SUBMIT_INFO }

    inline fun SubmitInfo(block: VkSubmitInfo.() -> Unit): VkSubmitInfo =
            SubmitInfo().also(block)

    inline fun SwapchainCreateInfoKHR(block: VkSwapchainCreateInfoKHR.() -> Unit): VkSwapchainCreateInfoKHR =
            VkSwapchainCreateInfoKHR.callocStack().apply {
                type = VkStructureType.SWAPCHAIN_CREATE_INFO_KHR
                block()
            }

    inline fun WriteDescriptorSet(block: VkWriteDescriptorSet.() -> Unit): VkWriteDescriptorSet =
            VkWriteDescriptorSet.callocStack().apply {
                type = VkStructureType.WRITE_DESCRIPTOR_SET
                block()
            }

    fun WriteDescriptorSet(capacity: Int): VkWriteDescriptorSet.Buffer =
            VkWriteDescriptorSet.callocStack(capacity).also {
                for (set in it)
                    set.type = VkStructureType.WRITE_DESCRIPTOR_SET
            }

    inline fun WriteDescriptorSet(capacity: Int, block: VkWriteDescriptorSet.Buffer.() -> Unit): VkWriteDescriptorSet.Buffer =
            WriteDescriptorSet(capacity).also(block)

    fun DescriptorImageInfo(capacity: Int): VkDescriptorImageInfo.Buffer =
            VkDescriptorImageInfo.callocStack(capacity)

    inline fun DescriptorImageInfo(block: VkDescriptorImageInfo.() -> Unit): VkDescriptorImageInfo =
            VkDescriptorImageInfo.callocStack().also(block)

    inline fun DescriptorImageInfo(capacity: Int, block: VkDescriptorImageInfo.() -> Unit): VkDescriptorImageInfo.Buffer =
            DescriptorImageInfo(capacity).also { it[0].block() }


    /*
        normal constructor functions
    */

    fun AttachmentDescription(): VkAttachmentDescription = VkAttachmentDescription.callocStack()
    fun AttachmentDescription(capacity: Int): VkAttachmentDescription.Buffer = VkAttachmentDescription.callocStack(capacity)
    inline fun AttachmentDescription(block: VkAttachmentDescription.() -> Unit): VkAttachmentDescription = AttachmentDescription().also(block)

    fun AttachmentReference(): VkAttachmentReference = VkAttachmentReference.callocStack()
    fun AttachmentReference(capacity: Int): VkAttachmentReference.Buffer = VkAttachmentReference.callocStack(capacity)
    inline fun AttachmentReference(block: VkAttachmentReference.() -> Unit): VkAttachmentReference = AttachmentReference().also(block)
    inline fun AttachmentReference(capacity: Int, block: VkAttachmentReference.() -> Unit): VkAttachmentReference.Buffer = AttachmentReference(capacity).also { it[0].block() }

    fun BufferCopy(): VkBufferCopy = VkBufferCopy.callocStack()
    fun BufferCopy(capacity: Int): VkBufferCopy.Buffer = VkBufferCopy.callocStack(capacity)
    inline fun BufferCopy(block: VkBufferCopy.() -> Unit): VkBufferCopy = BufferCopy().also(block)

    fun BufferImageCopy(): VkBufferImageCopy = VkBufferImageCopy.callocStack()
    fun BufferImageCopy(capacity: Int): VkBufferImageCopy.Buffer = VkBufferImageCopy.callocStack(capacity)
    inline fun BufferImageCopy(block: VkBufferImageCopy.() -> Unit): VkBufferImageCopy = BufferImageCopy().also(block)
    inline fun BufferImageCopy(capacity: Int, block: VkBufferImageCopy.() -> Unit): VkBufferImageCopy.Buffer = BufferImageCopy(capacity).also { it[0].block() }

    fun ClearValue(capacity: Int): VkClearValue.Buffer = VkClearValue.callocStack(capacity)

    fun DescriptorPoolSize(): VkDescriptorPoolSize = VkDescriptorPoolSize.callocStack()
    fun DescriptorPoolSize(capacity: Int): VkDescriptorPoolSize.Buffer = VkDescriptorPoolSize.callocStack(capacity)
    inline fun DescriptorPoolSize(block: VkDescriptorPoolSize.() -> Unit): VkDescriptorPoolSize = DescriptorPoolSize().also(block)
    inline fun DescriptorPoolSize(capacity: Int, block: VkDescriptorPoolSize.Buffer.() -> Unit): VkDescriptorPoolSize.Buffer = DescriptorPoolSize(capacity).also(block)

    fun DescriptorSetLayoutBinding(): VkDescriptorSetLayoutBinding = VkDescriptorSetLayoutBinding.callocStack()
    fun DescriptorSetLayoutBinding(capacity: Int): VkDescriptorSetLayoutBinding.Buffer = VkDescriptorSetLayoutBinding.callocStack(capacity)
    inline fun DescriptorSetLayoutBinding(block: VkDescriptorSetLayoutBinding.() -> Unit): VkDescriptorSetLayoutBinding = DescriptorSetLayoutBinding().also(block)
    inline fun DescriptorSetLayoutBinding(capacity: Int, block: VkDescriptorSetLayoutBinding.Buffer.() -> Unit): VkDescriptorSetLayoutBinding.Buffer = DescriptorSetLayoutBinding(capacity).also(block)

    fun ExtensionProperties(capacity: Int): VkExtensionProperties.Buffer = VkExtensionProperties.callocStack(capacity)

    fun Extent2D(): VkExtent2D = VkExtent2D.callocStack()
    inline fun Extent2D(block: VkExtent2D.() -> Unit): VkExtent2D = Extent2D().also(block)

    fun Extent3D(): VkExtent3D = VkExtent3D.callocStack()
    inline fun Extent3D(block: VkExtent3D.() -> Unit): VkExtent3D = Extent3D().also(block)

    fun FormatProperties(): VkFormatProperties = VkFormatProperties.callocStack()
    inline fun FormatProperties(block: VkFormatProperties.() -> Unit): VkFormatProperties = FormatProperties().also(block)

    fun ImageBlit(): VkImageBlit = VkImageBlit.callocStack()
    inline fun ImageBlit(block: VkImageBlit.() -> Unit): VkImageBlit = ImageBlit().also(block)

    fun ImageCopy(): VkImageCopy = VkImageCopy.callocStack()
    inline fun ImageCopy(block: VkImageCopy.() -> Unit): VkImageCopy = ImageCopy().also(block)

    fun ImageSubresource(): VkImageSubresource = VkImageSubresource.callocStack()
    inline fun ImageSubresource(block: VkImageSubresource.() -> Unit): VkImageSubresource = ImageSubresource().also(block)

    fun ImageSubresourceRange(): VkImageSubresourceRange = VkImageSubresourceRange.callocStack()
    inline fun ImageSubresourceRange(block: VkImageSubresourceRange.() -> Unit): VkImageSubresourceRange = ImageSubresourceRange().also(block)

    fun ImageSubresourceLayers(): VkImageSubresourceLayers = VkImageSubresourceLayers.callocStack()
    inline fun ImageSubresourceLayers(block: VkImageSubresourceLayers.() -> Unit): VkImageSubresourceLayers = ImageSubresourceLayers().also(block)

//    inline fun InstanceCreateInfo(extensions: ArrayList<String>): VkInstanceCreateInfo {
//        return InstanceCreateInfo {
//
//        }
//    }

    fun MemoryRequirements(): VkMemoryRequirements = VkMemoryRequirements.callocStack()
    inline fun MemoryRequirements(block: VkMemoryRequirements.() -> Unit): VkMemoryRequirements = MemoryRequirements().also(block)

    fun PipelineColorBlendAttachmentState(): VkPipelineColorBlendAttachmentState = VkPipelineColorBlendAttachmentState.callocStack()
    fun PipelineColorBlendAttachmentState(capacity: Int): VkPipelineColorBlendAttachmentState.Buffer = VkPipelineColorBlendAttachmentState.callocStack(capacity)
    inline fun PipelineColorBlendAttachmentState(block: VkPipelineColorBlendAttachmentState.() -> Unit): VkPipelineColorBlendAttachmentState = PipelineColorBlendAttachmentState().also(block)

    fun Rect2D(): VkRect2D = VkRect2D.callocStack()
    inline fun Rect2D(block: VkRect2D.() -> Unit): VkRect2D = Rect2D().also(block)
    inline fun Rect2D(capacity: Int, block: VkRect2D.() -> Unit): VkRect2D.Buffer = VkRect2D.callocStack(capacity).also { it[0].block() }

    fun SpecializationMapEntry(): VkSpecializationMapEntry = VkSpecializationMapEntry.callocStack()
    fun SpecializationMapEntry(capacity: Int): VkSpecializationMapEntry.Buffer = VkSpecializationMapEntry.callocStack(capacity)
    inline fun SpecializationMapEntry(block: VkSpecializationMapEntry.() -> Unit): VkSpecializationMapEntry = SpecializationMapEntry().also(block)

    fun SpecializationInfo(): VkSpecializationInfo = VkSpecializationInfo.callocStack()
    fun SpecializationInfo(capacity: Int): VkSpecializationInfo.Buffer = VkSpecializationInfo.callocStack(capacity)
    inline fun SpecializationInfo(block: VkSpecializationInfo.() -> Unit): VkSpecializationInfo = SpecializationInfo().also(block)

    fun SubpassDependency(): VkSubpassDependency = VkSubpassDependency.callocStack()
    fun SubpassDependency(capacity: Int): VkSubpassDependency.Buffer = VkSubpassDependency.callocStack(capacity)
    inline fun SubpassDependency(block: VkSubpassDependency.() -> Unit): VkSubpassDependency = SubpassDependency().also(block)

    fun SubpassDescription(): VkSubpassDescription = VkSubpassDescription.callocStack()
    fun SubpassDescription(capacity: Int): VkSubpassDescription.Buffer = VkSubpassDescription.callocStack(capacity)
    inline fun SubpassDescription(block: VkSubpassDescription.() -> Unit): VkSubpassDescription = SubpassDescription().also(block)

    fun SubresourceLayout(): VkSubresourceLayout = VkSubresourceLayout.callocStack()
    inline fun SubresourceLayout(capacity: Int, block: VkSubresourceLayout.() -> Unit): VkSubresourceLayout.Buffer = VkSubresourceLayout.callocStack(capacity).also { it[0].block() }

    fun SurfaceCapabilitiesKHR(): VkSurfaceCapabilitiesKHR = VkSurfaceCapabilitiesKHR.callocStack()
    inline fun SurfaceCapabilitiesKHR(block: VkSurfaceCapabilitiesKHR.() -> Unit): VkSurfaceCapabilitiesKHR = SurfaceCapabilitiesKHR().also(block)

    fun SurfaceFormatKHR(): VkSurfaceFormatKHR = VkSurfaceFormatKHR.callocStack()
    fun SurfaceFormatKHR(capacity: Int): VkSurfaceFormatKHR.Buffer = VkSurfaceFormatKHR.callocStack(capacity)

    fun VertexInputAttributeDescription(): VkVertexInputAttributeDescription = VkVertexInputAttributeDescription.callocStack()
    fun VertexInputAttributeDescription(capacity: Int): VkVertexInputAttributeDescription.Buffer = VkVertexInputAttributeDescription.callocStack(capacity)
    inline fun VertexInputAttributeDescription(block: VkVertexInputAttributeDescription.() -> Unit): VkVertexInputAttributeDescription = VertexInputAttributeDescription().also(block)
    inline fun VertexInputAttributeDescription(capacity: Int, block: VkVertexInputAttributeDescription.Buffer.() -> Unit): VkVertexInputAttributeDescription.Buffer = VertexInputAttributeDescription(capacity).also(block)

    fun VertexInputBindingDescription(): VkVertexInputBindingDescription = VkVertexInputBindingDescription.callocStack()
    inline fun VertexInputBindingDescription(block: VkVertexInputBindingDescription.() -> Unit): VkVertexInputBindingDescription = VertexInputBindingDescription().also(block)
    inline fun VertexInputBindingDescription(capacity: Int, block: VkVertexInputBindingDescription.() -> Unit): VkVertexInputBindingDescription.Buffer = VkVertexInputBindingDescription.callocStack(capacity).also { it[0].block() }

    fun Viewport(): VkViewport = VkViewport.callocStack()
    inline fun Viewport(block: VkViewport.() -> Unit): VkViewport = Viewport().also(block)
    inline fun Viewport(capacity: Int, block: VkViewport.() -> Unit): VkViewport.Buffer = VkViewport.callocStack(capacity).also { it[0].block() }


    /*
        Function Constructors
     */

    fun AttachmentReference(attachment: Int, layout: VkImageLayout): VkAttachmentReference =
            AttachmentReference().attachment(attachment).layout(layout.i)

    fun AttachmentReference(
            attachment0: Int, layout0: VkImageLayout,
            attachment1: Int, layout1: VkImageLayout): VkAttachmentReference.Buffer =
            AttachmentReference(2).also {
                it[0].attachment(attachment0).layout(layout0.i)
                it[1].attachment(attachment1).layout(layout1.i)
            }

    fun AttachmentReference(
            attachment0: Int, layout0: VkImageLayout,
            attachment1: Int, layout1: VkImageLayout,
            attachment2: Int, layout2: VkImageLayout): VkAttachmentReference.Buffer =
            AttachmentReference(3).also {
                it[0].attachment(attachment0).layout(layout0.i)
                it[1].attachment(attachment1).layout(layout1.i)
                it[2].attachment(attachment2).layout(layout2.i)
            }

    fun AttachmentReference(
            attachment0: Int, layout0: VkImageLayout,
            attachment1: Int, layout1: VkImageLayout,
            attachment2: Int, layout2: VkImageLayout,
            attachment3: Int, layout3: VkImageLayout): VkAttachmentReference.Buffer =
            AttachmentReference(4).also {
                it[0].attachment(attachment0).layout(layout0.i)
                it[1].attachment(attachment1).layout(layout1.i)
                it[2].attachment(attachment2).layout(layout2.i)
                it[3].attachment(attachment3).layout(layout3.i)
            }

    fun AttachmentReference(
            attachment0: Int, layout0: VkImageLayout,
            attachment1: Int, layout1: VkImageLayout,
            attachment2: Int, layout2: VkImageLayout,
            attachment3: Int, layout3: VkImageLayout,
            attachment4: Int, layout4: VkImageLayout): VkAttachmentReference.Buffer =
            AttachmentReference(5).also {
                it[0].attachment(attachment0).layout(layout0.i)
                it[1].attachment(attachment1).layout(layout1.i)
                it[2].attachment(attachment2).layout(layout2.i)
                it[3].attachment(attachment3).layout(layout3.i)
                it[4].attachment(attachment4).layout(layout4.i)
            }

    fun ComputePipelineCreateInfo(layout: VkPipelineLayout, flags: VkPipelineCreateFlags = 0): VkComputePipelineCreateInfo =
            ComputePipelineCreateInfo {
                this.layout = layout
                this.flags = flags
            }

    fun DescriptorImageInfo(sampler: VkSampler, imageView: VkImageView, imageLayout: VkImageLayout): VkDescriptorImageInfo =
            DescriptorImageInfo {
                this.sampler = sampler
                this.imageView = imageView
                this.imageLayout = imageLayout
            }

    fun DescriptorPoolCreateInfo(poolSize: VkDescriptorPoolSize, maxSets: Int): VkDescriptorPoolCreateInfo =
            DescriptorPoolCreateInfo {
                this.poolSize = poolSize
                this.maxSets = maxSets
            }

    fun DescriptorPoolCreateInfo(poolSizes: VkDescriptorPoolSize.Buffer, maxSets: Int): VkDescriptorPoolCreateInfo =
            DescriptorPoolCreateInfo {
                this.poolSizes = poolSizes
                this.maxSets = maxSets
            }

    fun DescriptorPoolSize(type: VkDescriptorType, descriptorCount: Int): VkDescriptorPoolSize =
            DescriptorPoolSize {
                this.type = type
                this.descriptorCount = descriptorCount
            }

    fun DescriptorPoolSize(
            type0: VkDescriptorType, descriptorCount0: Int,
            type1: VkDescriptorType, descriptorCount1: Int): VkDescriptorPoolSize.Buffer =
            DescriptorPoolSize(2) {
                this[0].type(type0.i).descriptorCount(descriptorCount0)
                this[1].type(type1.i).descriptorCount(descriptorCount1)
            }

    fun DescriptorPoolSize(
            type0: VkDescriptorType, descriptorCount0: Int,
            type1: VkDescriptorType, descriptorCount1: Int,
            type2: VkDescriptorType, descriptorCount2: Int): VkDescriptorPoolSize.Buffer =
            DescriptorPoolSize(3) {
                this[0].type(type0.i).descriptorCount(descriptorCount0)
                this[1].type(type1.i).descriptorCount(descriptorCount1)
                this[2].type(type2.i).descriptorCount(descriptorCount2)
            }

    fun DescriptorPoolSize(
            type0: VkDescriptorType, descriptorCount0: Int,
            type1: VkDescriptorType, descriptorCount1: Int,
            type2: VkDescriptorType, descriptorCount2: Int,
            type3: VkDescriptorType, descriptorCount3: Int): VkDescriptorPoolSize.Buffer =
            DescriptorPoolSize(4) {
                this[0].type(type0.i).descriptorCount(descriptorCount0)
                this[1].type(type1.i).descriptorCount(descriptorCount1)
                this[2].type(type2.i).descriptorCount(descriptorCount2)
                this[3].type(type3.i).descriptorCount(descriptorCount3)
            }

    fun DescriptorPoolSize(
            type0: VkDescriptorType, descriptorCount0: Int,
            type1: VkDescriptorType, descriptorCount1: Int,
            type2: VkDescriptorType, descriptorCount2: Int,
            type3: VkDescriptorType, descriptorCount3: Int,
            type4: VkDescriptorType, descriptorCount4: Int): VkDescriptorPoolSize.Buffer =
            DescriptorPoolSize(5) {
                this[0].type(type0.i).descriptorCount(descriptorCount0)
                this[1].type(type1.i).descriptorCount(descriptorCount1)
                this[2].type(type2.i).descriptorCount(descriptorCount2)
                this[3].type(type3.i).descriptorCount(descriptorCount3)
                this[4].type(type4.i).descriptorCount(descriptorCount4)
            }

    fun DescriptorPoolSize(
            type0: VkDescriptorType, descriptorCount0: Int,
            type1: VkDescriptorType, descriptorCount1: Int,
            type2: VkDescriptorType, descriptorCount2: Int,
            type3: VkDescriptorType, descriptorCount3: Int,
            type4: VkDescriptorType, descriptorCount4: Int,
            type5: VkDescriptorType, descriptorCount5: Int): VkDescriptorPoolSize.Buffer =
            DescriptorPoolSize(6) {
                this[0].type(type0.i).descriptorCount(descriptorCount0)
                this[1].type(type1.i).descriptorCount(descriptorCount1)
                this[2].type(type2.i).descriptorCount(descriptorCount2)
                this[3].type(type3.i).descriptorCount(descriptorCount3)
                this[4].type(type4.i).descriptorCount(descriptorCount4)
                this[5].type(type5.i).descriptorCount(descriptorCount5)
            }

    fun DescriptorPoolSize(
            type0: VkDescriptorType, descriptorCount0: Int,
            type1: VkDescriptorType, descriptorCount1: Int,
            type2: VkDescriptorType, descriptorCount2: Int,
            type3: VkDescriptorType, descriptorCount3: Int,
            type4: VkDescriptorType, descriptorCount4: Int,
            type5: VkDescriptorType, descriptorCount5: Int,
            type6: VkDescriptorType, descriptorCount6: Int): VkDescriptorPoolSize.Buffer =
            DescriptorPoolSize(7) {
                this[0].type(type0.i).descriptorCount(descriptorCount0)
                this[1].type(type1.i).descriptorCount(descriptorCount1)
                this[2].type(type2.i).descriptorCount(descriptorCount2)
                this[3].type(type3.i).descriptorCount(descriptorCount3)
                this[4].type(type4.i).descriptorCount(descriptorCount4)
                this[5].type(type5.i).descriptorCount(descriptorCount5)
                this[6].type(type6.i).descriptorCount(descriptorCount6)
            }

    fun DescriptorPoolSize(
            type0: VkDescriptorType, descriptorCount0: Int,
            type1: VkDescriptorType, descriptorCount1: Int,
            type2: VkDescriptorType, descriptorCount2: Int,
            type3: VkDescriptorType, descriptorCount3: Int,
            type4: VkDescriptorType, descriptorCount4: Int,
            type5: VkDescriptorType, descriptorCount5: Int,
            type6: VkDescriptorType, descriptorCount6: Int,
            type7: VkDescriptorType, descriptorCount7: Int): VkDescriptorPoolSize.Buffer =
            DescriptorPoolSize(8) {
                this[0].type(type0.i).descriptorCount(descriptorCount0)
                this[1].type(type1.i).descriptorCount(descriptorCount1)
                this[2].type(type2.i).descriptorCount(descriptorCount2)
                this[3].type(type3.i).descriptorCount(descriptorCount3)
                this[4].type(type4.i).descriptorCount(descriptorCount4)
                this[5].type(type5.i).descriptorCount(descriptorCount5)
                this[6].type(type6.i).descriptorCount(descriptorCount6)
                this[7].type(type7.i).descriptorCount(descriptorCount7)
            }

    fun DescriptorPoolSize(
            type0: VkDescriptorType, descriptorCount0: Int,
            type1: VkDescriptorType, descriptorCount1: Int,
            type2: VkDescriptorType, descriptorCount2: Int,
            type3: VkDescriptorType, descriptorCount3: Int,
            type4: VkDescriptorType, descriptorCount4: Int,
            type5: VkDescriptorType, descriptorCount5: Int,
            type6: VkDescriptorType, descriptorCount6: Int,
            type7: VkDescriptorType, descriptorCount7: Int,
            type8: VkDescriptorType, descriptorCount8: Int): VkDescriptorPoolSize.Buffer =
            DescriptorPoolSize(9) {
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

    fun DescriptorPoolSize(
            type0: VkDescriptorType, descriptorCount0: Int,
            type1: VkDescriptorType, descriptorCount1: Int,
            type2: VkDescriptorType, descriptorCount2: Int,
            type3: VkDescriptorType, descriptorCount3: Int,
            type4: VkDescriptorType, descriptorCount4: Int,
            type5: VkDescriptorType, descriptorCount5: Int,
            type6: VkDescriptorType, descriptorCount6: Int,
            type7: VkDescriptorType, descriptorCount7: Int,
            type8: VkDescriptorType, descriptorCount8: Int,
            type9: VkDescriptorType, descriptorCount9: Int): VkDescriptorPoolSize.Buffer =
            DescriptorPoolSize(10) {
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

    fun DescriptorPoolSize(
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
            type10: VkDescriptorType, descriptorCount10: Int): VkDescriptorPoolSize.Buffer =
            DescriptorPoolSize(11) {
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

    fun DescriptorSetAllocateInfo(descriptorPool: VkDescriptorPool, setLayout: VkDescriptorSetLayout): VkDescriptorSetAllocateInfo =
            DescriptorSetAllocateInfo {
                this.descriptorPool = descriptorPool
                this.setLayout = setLayout
            }

    fun DescriptorSetLayoutBinding(type: VkDescriptorType, stageFlags: VkShaderStageFlags, binding: Int, descriptorCount: Int = 1): VkDescriptorSetLayoutBinding =
            DescriptorSetLayoutBinding {
                descriptorType = type
                this.stageFlags = stageFlags
                this.binding = binding
                this.descriptorCount = descriptorCount
            }

    fun DescriptorSetLayoutBinding(
            type0: VkDescriptorType, stageFlags0: VkShaderStageFlags, binding0: Int,
            type1: VkDescriptorType, stageFlags1: VkShaderStageFlags, binding1: Int): VkDescriptorSetLayoutBinding.Buffer =
            DescriptorSetLayoutBinding(
                    type0, stageFlags0, binding0, 1,
                    type1, stageFlags1, binding1, 1)

    fun DescriptorSetLayoutBinding(
            type0: VkDescriptorType, stageFlags0: VkShaderStageFlags, binding0: Int,
            type1: VkDescriptorType, stageFlags1: VkShaderStageFlags, binding1: Int,
            type2: VkDescriptorType, stageFlags2: VkShaderStageFlags, binding2: Int): VkDescriptorSetLayoutBinding.Buffer =
            DescriptorSetLayoutBinding(
                    type0, stageFlags0, binding0, 1,
                    type1, stageFlags1, binding1, 1,
                    type2, stageFlags2, binding2, 1)

    fun DescriptorSetLayoutBinding(
            type0: VkDescriptorType, stageFlags0: VkShaderStageFlags, binding0: Int,
            type1: VkDescriptorType, stageFlags1: VkShaderStageFlags, binding1: Int,
            type2: VkDescriptorType, stageFlags2: VkShaderStageFlags, binding2: Int,
            type3: VkDescriptorType, stageFlags3: VkShaderStageFlags, binding3: Int): VkDescriptorSetLayoutBinding.Buffer =
            DescriptorSetLayoutBinding(
                    type0, stageFlags0, binding0, 1,
                    type1, stageFlags1, binding1, 1,
                    type2, stageFlags2, binding2, 1,
                    type3, stageFlags3, binding3, 1)

    fun DescriptorSetLayoutBinding(
            type0: VkDescriptorType, stageFlags0: VkShaderStageFlags, binding0: Int, descriptorCount0: Int,
            type1: VkDescriptorType, stageFlags1: VkShaderStageFlags, binding1: Int, descriptorCount1: Int): VkDescriptorSetLayoutBinding.Buffer =
            DescriptorSetLayoutBinding(2) {
                this[0].descriptorType(type0.i).stageFlags(stageFlags0).binding(binding0).descriptorCount(descriptorCount0)
                this[1].descriptorType(type1.i).stageFlags(stageFlags1).binding(binding1).descriptorCount(descriptorCount1)
            }

    fun DescriptorSetLayoutBinding(
            type0: VkDescriptorType, stageFlags0: VkShaderStageFlags, binding0: Int, descriptorCount0: Int,
            type1: VkDescriptorType, stageFlags1: VkShaderStageFlags, binding1: Int, descriptorCount1: Int,
            type2: VkDescriptorType, stageFlags2: VkShaderStageFlags, binding2: Int, descriptorCount2: Int): VkDescriptorSetLayoutBinding.Buffer =
            DescriptorSetLayoutBinding(3) {
                this[0].descriptorType(type0.i).stageFlags(stageFlags0).binding(binding0).descriptorCount(descriptorCount0)
                this[1].descriptorType(type1.i).stageFlags(stageFlags1).binding(binding1).descriptorCount(descriptorCount1)
                this[2].descriptorType(type2.i).stageFlags(stageFlags2).binding(binding2).descriptorCount(descriptorCount2)
            }

    fun DescriptorSetLayoutBinding(
            type0: VkDescriptorType, stageFlags0: VkShaderStageFlags, binding0: Int, descriptorCount0: Int,
            type1: VkDescriptorType, stageFlags1: VkShaderStageFlags, binding1: Int, descriptorCount1: Int,
            type2: VkDescriptorType, stageFlags2: VkShaderStageFlags, binding2: Int, descriptorCount2: Int,
            type3: VkDescriptorType, stageFlags3: VkShaderStageFlags, binding3: Int, descriptorCount3: Int): VkDescriptorSetLayoutBinding.Buffer =
            DescriptorSetLayoutBinding(4) {
                this[0].descriptorType(type0.i).stageFlags(stageFlags0).binding(binding0).descriptorCount(descriptorCount0)
                this[1].descriptorType(type1.i).stageFlags(stageFlags1).binding(binding1).descriptorCount(descriptorCount1)
                this[2].descriptorType(type2.i).stageFlags(stageFlags2).binding(binding2).descriptorCount(descriptorCount2)
                this[3].descriptorType(type3.i).stageFlags(stageFlags3).binding(binding3).descriptorCount(descriptorCount3)
            }

    fun DescriptorSetLayoutCreateInfo(binding: VkDescriptorSetLayoutBinding): VkDescriptorSetLayoutCreateInfo =
            DescriptorSetLayoutCreateInfo { this.binding = binding }

    fun DescriptorSetLayoutCreateInfo(bindings: VkDescriptorSetLayoutBinding.Buffer): VkDescriptorSetLayoutCreateInfo =
            DescriptorSetLayoutCreateInfo { this.bindings = bindings }

//    inline fun DeviceCreateInfo(queueCreateInfo: VkDeviceQueueCreateInfo, ): VkDeviceCreateInfo {
//
//    }

    fun FenceCreateInfo(flag: VkFenceCreate): VkFenceCreateInfo =
            FenceCreateInfo { flags = flag.i }

    fun FenceCreateInfo(flags: VkFenceCreateFlags = 0): VkFenceCreateInfo =
            FenceCreateInfo { this.flags = flags }

    fun GraphicsPipelineCreateInfo(layout: VkPipelineLayout, renderPass: VkRenderPass, flags: VkPipelineCreateFlags = 0): VkGraphicsPipelineCreateInfo =
            GraphicsPipelineCreateInfo {
                this.layout = layout
                this.renderPass = renderPass
                this.flags = flags
                basePipelineIndex = -1
                basePipelineHandle = VkPipeline(NULL)
            }

    fun PipelineColorBlendAttachmentState(colorWriteMask: VkColorComponentFlags, blendEnable: Boolean): VkPipelineColorBlendAttachmentState =
            PipelineColorBlendAttachmentState().colorWriteMask(colorWriteMask).blendEnable(blendEnable)

    fun PipelineColorBlendAttachmentState(
            colorWriteMask0: VkColorComponentFlags, blendEnable0: Boolean,
            colorWriteMask1: VkColorComponentFlags, blendEnable1: Boolean): VkPipelineColorBlendAttachmentState.Buffer =
            PipelineColorBlendAttachmentState(2).also {
                it[0].colorWriteMask(colorWriteMask0).blendEnable(blendEnable0)
                it[1].colorWriteMask(colorWriteMask1).blendEnable(blendEnable1)
            }

    fun PipelineColorBlendAttachmentState(
            colorWriteMask0: VkColorComponentFlags, blendEnable0: Boolean,
            colorWriteMask1: VkColorComponentFlags, blendEnable1: Boolean,
            colorWriteMask2: VkColorComponentFlags, blendEnable2: Boolean): VkPipelineColorBlendAttachmentState.Buffer =
            PipelineColorBlendAttachmentState(3).also {
                it[0].colorWriteMask(colorWriteMask0).blendEnable(blendEnable0)
                it[1].colorWriteMask(colorWriteMask1).blendEnable(blendEnable1)
                it[2].colorWriteMask(colorWriteMask2).blendEnable(blendEnable2)
            }

    fun PipelineColorBlendAttachmentState(
            colorWriteMask0: VkColorComponentFlags, blendEnable0: Boolean,
            colorWriteMask1: VkColorComponentFlags, blendEnable1: Boolean,
            colorWriteMask2: VkColorComponentFlags, blendEnable2: Boolean,
            colorWriteMask3: VkColorComponentFlags, blendEnable3: Boolean): VkPipelineColorBlendAttachmentState.Buffer =
            PipelineColorBlendAttachmentState(4).also {
                it[0].colorWriteMask(colorWriteMask0).blendEnable(blendEnable0)
                it[1].colorWriteMask(colorWriteMask1).blendEnable(blendEnable1)
                it[2].colorWriteMask(colorWriteMask2).blendEnable(blendEnable2)
                it[3].colorWriteMask(colorWriteMask3).blendEnable(blendEnable3)
            }

    fun PipelineColorBlendAttachmentState(
            colorWriteMask0: VkColorComponentFlags, blendEnable0: Boolean,
            colorWriteMask1: VkColorComponentFlags, blendEnable1: Boolean,
            colorWriteMask2: VkColorComponentFlags, blendEnable2: Boolean,
            colorWriteMask3: VkColorComponentFlags, blendEnable3: Boolean,
            colorWriteMask4: VkColorComponentFlags, blendEnable4: Boolean): VkPipelineColorBlendAttachmentState.Buffer =
            PipelineColorBlendAttachmentState(5).also {
                it[0].colorWriteMask(colorWriteMask0).blendEnable(blendEnable0)
                it[1].colorWriteMask(colorWriteMask1).blendEnable(blendEnable1)
                it[2].colorWriteMask(colorWriteMask2).blendEnable(blendEnable2)
                it[3].colorWriteMask(colorWriteMask3).blendEnable(blendEnable3)
                it[4].colorWriteMask(colorWriteMask4).blendEnable(blendEnable4)
            }

    fun PipelineColorBlendStateCreateInfo(attachment: VkPipelineColorBlendAttachmentState): VkPipelineColorBlendStateCreateInfo =
            PipelineColorBlendStateCreateInfo { this.attachment = attachment }

    fun PipelineDepthStencilStateCreateInfo(depthTestEnable: Boolean,
                                            depthWriteEnable: Boolean,
                                            depthCompareOp: VkCompareOp): VkPipelineDepthStencilStateCreateInfo =
            PipelineDepthStencilStateCreateInfo {
                this.depthTestEnable = depthTestEnable
                this.depthWriteEnable = depthWriteEnable
                this.depthCompareOp = depthCompareOp
                front = back
                back.compareOp = VkCompareOp.ALWAYS
            }

    fun PipelineDynamicStateCreateInfo(dynamicStates: Collection<VkDynamicState>, flags: VkPipelineDynamicStateCreateFlags = 0): VkPipelineDynamicStateCreateInfo =
            PipelineDynamicStateCreateInfo {
                this.dynamicStates = stackGet().vkDynamicStateBufferOf(dynamicStates)
                this.flags = flags
            }

    fun PipelineInputAssemblyStateCreateInfo(topology: VkPrimitiveTopology,
                                             flags: VkPipelineInputAssemblyStateCreateFlags = 0,
                                             primitiveRestartEnable: Boolean = false): VkPipelineInputAssemblyStateCreateInfo =
            PipelineInputAssemblyStateCreateInfo {
                this.topology = topology
                this.flags = flags
                this.primitiveRestartEnable = primitiveRestartEnable
            }

    fun PipelineLayoutCreateInfo(setLayout: VkDescriptorSetLayout): VkPipelineLayoutCreateInfo =
            PipelineLayoutCreateInfo { this.setLayout = setLayout }

    fun PipelineMultisampleStateCreateInfo(rasterizationSamples: VkSampleCount, flags: VkPipelineMultisampleStateCreateFlags = 0): VkPipelineMultisampleStateCreateInfo =
            PipelineMultisampleStateCreateInfo {
                this.rasterizationSamples = rasterizationSamples
                this.flags = flags
            }

    fun PipelineRasterizationStateCreateInfo(
            polygonMode: VkPolygonMode,
            cullMode: VkCullModeFlags,
            frontFace: VkFrontFace,
            flags: VkPipelineRasterizationStateCreateFlags = 0): VkPipelineRasterizationStateCreateInfo =
            PipelineRasterizationStateCreateInfo {
                this.polygonMode = polygonMode
                this.cullMode = cullMode
                this.frontFace = frontFace
                this.flags = flags
                depthClampEnable = false
                lineWidth = 1f
            }

    fun PipelineViewportStateCreateInfo(viewportCount: Int, scissorCount: Int, flags: VkPipelineViewportStateCreateFlags = 0): VkPipelineViewportStateCreateInfo =
            PipelineViewportStateCreateInfo {
                this.viewportCount = viewportCount
                this.scissorCount = scissorCount
                this.flags = flags
            }

    fun PushConstantRange(stageFlag: VkShaderStage, size: Int, offset: Int = 0): VkPushConstantRange =
            PushConstantRange(stageFlag.i, size, offset)

    fun PushConstantRange(stageFlags: VkShaderStageFlags, size: Int, offset: Int = 0): VkPushConstantRange =
            PushConstantRange {
                this.stageFlags = stageFlags
                this.size = size
                this.offset = offset
            }

    fun Rect2D(extend: Vec2i): VkRect2D = Rect2D(0, 0, extend.x, extend.y)

    fun Rect2D(offset: Vec2i, extend: Vec2i): VkRect2D = Rect2D(offset.x, offset.y, extend.x, extend.y)

    fun Rect2D(offsetX: Int, offsetY: Int, width: Int, height: Int): VkRect2D = Rect2D {
        offset.x = offsetX
        offset.y = offsetY
        extent.width = width
        extent.height = height
    }

    fun SpecializationInfo(mapEntries: VkSpecializationMapEntry.Buffer, data: ByteBuffer): VkSpecializationInfo =
            SpecializationInfo().also {
                it.mapEntries = mapEntries
                it.data = data
            }

    fun SpecializationInfo(
            mapEntries0: VkSpecializationMapEntry.Buffer, data0: ByteBuffer,
            mapEntries1: VkSpecializationMapEntry.Buffer, data1: ByteBuffer): VkSpecializationInfo.Buffer =
            SpecializationInfo(2).also {
                it[0].apply {
                    mapEntries = mapEntries0
                    data = data0
                }
                it[1].apply {
                    mapEntries = mapEntries1
                    data = data1
                }
            }

    fun SpecializationMapEntry(constantId: Int, offset: Int, size: Int): VkSpecializationMapEntry =
            SpecializationMapEntry().also {
                it.constantId = constantId
                it.offset = offset
                it.size = size.L
            }

    fun SpecializationMapEntry(
            constantId0: Int, offset0: Int, size0: Int,
            constantId1: Int, offset1: Int, size1: Int): VkSpecializationMapEntry.Buffer =
            SpecializationMapEntry(2).also {
                it[0].constantID(constantId0).offset(offset0).size(size0.L)
                it[1].constantID(constantId1).offset(offset1).size(size1.L)
            }

    fun SpecializationMapEntry(
            constantId0: Int, offset0: Int, size0: Int,
            constantId1: Int, offset1: Int, size1: Int,
            constantId2: Int, offset2: Int, size2: Int): VkSpecializationMapEntry.Buffer =
            SpecializationMapEntry(3).also {
                it[0].constantID(constantId0).offset(offset0).size(size0.L)
                it[1].constantID(constantId1).offset(offset1).size(size1.L)
                it[2].constantID(constantId2).offset(offset2).size(size2.L)
            }

    fun SpecializationMapEntry(
            constantId0: Int, offset0: Int, size0: Int,
            constantId1: Int, offset1: Int, size1: Int,
            constantId2: Int, offset2: Int, size2: Int,
            constantId3: Int, offset3: Int, size3: Int): VkSpecializationMapEntry.Buffer =
            SpecializationMapEntry(4).also {
                it[0].constantID(constantId0).offset(offset0).size(size0.L)
                it[1].constantID(constantId1).offset(offset1).size(size1.L)
                it[2].constantID(constantId2).offset(offset2).size(size2.L)
                it[3].constantID(constantId3).offset(offset3).size(size3.L)
            }

    fun SurfaceFormatKHR(format: VkFormat, colorSpace: VkColorSpace): VkSurfaceFormatKHR =
            SurfaceFormatKHR().also {
                it.format = format
                it.colorSpace = colorSpace
            }

    fun VertexInputBindingDescription(binding: Int, stride: Int, inputRate: VkVertexInputRate): VkVertexInputBindingDescription =
            VertexInputBindingDescription {
                this.binding = binding
                this.stride = stride
                this.inputRate = inputRate
            }

    fun Viewport(size: Vec2i, minDepth: Float = 0f, maxDepth: Float = 1f): VkViewport =
            Viewport(size.x.f, size.y.f, minDepth, maxDepth)

    fun Viewport(width: Float, height: Float, minDepth: Float = 0f, maxDepth: Float = 1f): VkViewport =
            Viewport {
                this.width = width
                this.height = height
                this.minDepth = minDepth
                this.maxDepth = maxDepth
            }

    fun WriteDescriptorSet(dstSet: VkDescriptorSet, type: VkDescriptorType, binding: Int, imageInfo: VkDescriptorImageInfo): VkWriteDescriptorSet =
            WriteDescriptorSet {
                this.dstSet = dstSet
                descriptorType = type
                dstBinding = binding
                imageInfo_ = imageInfo
            }

    fun WriteDescriptorSet(dstSet: VkDescriptorSet, type: VkDescriptorType, binding: Int, bufferInfo: VkDescriptorBufferInfo): VkWriteDescriptorSet =
            WriteDescriptorSet {
                this.dstSet = dstSet
                descriptorType = type
                dstBinding = binding
                bufferInfo_ = bufferInfo
            }

    fun WriteDescriptorSet(
            dstSet0: VkDescriptorSet, type0: VkDescriptorType, binding0: Int, info0: Struct,
            dstSet1: VkDescriptorSet, type1: VkDescriptorType, binding1: Int, info1: Struct): VkWriteDescriptorSet.Buffer =
            WriteDescriptorSet(2) {
                this[0].dstSet(dstSet0.L).descriptorType(type0.i).dstBinding(binding0)
                if (info0 is VkDescriptorBufferInfo) this[0].bufferInfo_ = info0 else this[0].imageInfo_ = info0 as VkDescriptorImageInfo
                this[1].dstSet(dstSet1.L).descriptorType(type1.i).dstBinding(binding1)
                if (info1 is VkDescriptorBufferInfo) this[1].bufferInfo_ = info1 else this[1].imageInfo_ = info1 as VkDescriptorImageInfo
            }

    fun WriteDescriptorSet(
            dstSet0: VkDescriptorSet, type0: VkDescriptorType, binding0: Int, info0: Struct,
            dstSet1: VkDescriptorSet, type1: VkDescriptorType, binding1: Int, info1: Struct,
            dstSet2: VkDescriptorSet, type2: VkDescriptorType, binding2: Int, info2: Struct): VkWriteDescriptorSet.Buffer =
            WriteDescriptorSet(3) {
                this[0].dstSet(dstSet0.L).descriptorType(type0.i).dstBinding(binding0)
                if (info0 is VkDescriptorBufferInfo) this[0].bufferInfo_ = info0 else this[0].imageInfo_ = info0 as VkDescriptorImageInfo
                this[1].dstSet(dstSet1.L).descriptorType(type1.i).dstBinding(binding1)
                if (info1 is VkDescriptorBufferInfo) this[1].bufferInfo_ = info1 else this[1].imageInfo_ = info1 as VkDescriptorImageInfo
                this[2].dstSet(dstSet2.L).descriptorType(type2.i).dstBinding(binding2)
                if (info2 is VkDescriptorBufferInfo) this[2].bufferInfo_ = info2 else this[2].imageInfo_ = info2 as VkDescriptorImageInfo
            }

    fun WriteDescriptorSet(
            dstSet0: VkDescriptorSet, type0: VkDescriptorType, binding0: Int, info0: Struct,
            dstSet1: VkDescriptorSet, type1: VkDescriptorType, binding1: Int, info1: Struct,
            dstSet2: VkDescriptorSet, type2: VkDescriptorType, binding2: Int, info2: Struct,
            dstSet3: VkDescriptorSet, type3: VkDescriptorType, binding3: Int, info3: Struct): VkWriteDescriptorSet.Buffer =
            WriteDescriptorSet(4) {
                this[0].dstSet(dstSet0.L).descriptorType(type0.i).dstBinding(binding0)
                if (info0 is VkDescriptorBufferInfo) this[0].bufferInfo_ = info0 else this[0].imageInfo_ = info0 as VkDescriptorImageInfo
                this[1].dstSet(dstSet1.L).descriptorType(type1.i).dstBinding(binding1)
                if (info1 is VkDescriptorBufferInfo) this[1].bufferInfo_ = info1 else this[1].imageInfo_ = info1 as VkDescriptorImageInfo
                this[2].dstSet(dstSet2.L).descriptorType(type2.i).dstBinding(binding2)
                if (info2 is VkDescriptorBufferInfo) this[2].bufferInfo_ = info2 else this[2].imageInfo_ = info2 as VkDescriptorImageInfo
                this[3].dstSet(dstSet3.L).descriptorType(type3.i).dstBinding(binding3)
                if (info3 is VkDescriptorBufferInfo) this[3].bufferInfo_ = info3 else this[3].imageInfo_ = info3 as VkDescriptorImageInfo
            }


    /*
        Full Constructors
     */


    fun ImageSubresourceRange(
            aspectMask: VkImageAspect,
            baseMipLevel: Int,
            levelCount: Int,
            baseArrayLayer: Int,
            layerCount: Int): VkImageSubresourceRange =
            ImageSubresourceRange {
                this.aspectMask = aspectMask.i
                this.baseMipLevel = baseMipLevel
                this.levelCount = levelCount
                this.baseArrayLayer = baseArrayLayer
                this.layerCount = layerCount
            }

    fun ImageSubresourceRange(
            aspectMask: VkImageAspectFlags,
            baseMipLevel: Int,
            levelCount: Int,
            baseArrayLayer: Int,
            layerCount: Int): VkImageSubresourceRange =
            ImageSubresourceRange {
                this.aspectMask = aspectMask
                this.baseMipLevel = baseMipLevel
                this.levelCount = levelCount
                this.baseArrayLayer = baseArrayLayer
                this.layerCount = layerCount
            }

    fun VertexInputAttributeDescription(binding: Int, location: Int, format: VkFormat, offset: Int): VkVertexInputAttributeDescription =
            VertexInputAttributeDescription {
                this.location = location
                this.binding = binding
                this.format = format
                this.offset = offset
            }

    fun VertexInputAttributeDescription(
            binding0: Int, location0: Int, format0: VkFormat, offset0: Int,
            binding1: Int, location1: Int, format1: VkFormat, offset1: Int): VkVertexInputAttributeDescription.Buffer =
            VertexInputAttributeDescription(2) {
                this[0].location(location0).binding(binding0).format(format0.i).offset(offset0)
                this[1].location(location1).binding(binding1).format(format1.i).offset(offset1)
            }

    fun VertexInputAttributeDescription(
            binding0: Int, location0: Int, format0: VkFormat, offset0: Int,
            binding1: Int, location1: Int, format1: VkFormat, offset1: Int,
            binding2: Int, location2: Int, format2: VkFormat, offset2: Int): VkVertexInputAttributeDescription.Buffer =
            VertexInputAttributeDescription(3) {
                this[0].location(location0).binding(binding0).format(format0.i).offset(offset0)
                this[1].location(location1).binding(binding1).format(format1.i).offset(offset1)
                this[2].location(location2).binding(binding2).format(format2.i).offset(offset2)
            }

    fun VertexInputAttributeDescription(
            binding0: Int, location0: Int, format0: VkFormat, offset0: Int,
            binding1: Int, location1: Int, format1: VkFormat, offset1: Int,
            binding2: Int, location2: Int, format2: VkFormat, offset2: Int,
            binding3: Int, location3: Int, format3: VkFormat, offset3: Int): VkVertexInputAttributeDescription.Buffer =
            VertexInputAttributeDescription(4) {
                this[0].location(location0).binding(binding0).format(format0.i).offset(offset0)
                this[1].location(location1).binding(binding1).format(format1.i).offset(offset1)
                this[2].location(location2).binding(binding2).format(format2.i).offset(offset2)
                this[3].location(location3).binding(binding3).format(format3.i).offset(offset3)
            }

    fun VertexInputAttributeDescription(
            binding0: Int, location0: Int, format0: VkFormat, offset0: Int,
            binding1: Int, location1: Int, format1: VkFormat, offset1: Int,
            binding2: Int, location2: Int, format2: VkFormat, offset2: Int,
            binding3: Int, location3: Int, format3: VkFormat, offset3: Int,
            binding4: Int, location4: Int, format4: VkFormat, offset4: Int): VkVertexInputAttributeDescription.Buffer =
            VertexInputAttributeDescription(4) {
                this[0].location(location0).binding(binding0).format(format0.i).offset(offset0)
                this[1].location(location1).binding(binding1).format(format1.i).offset(offset1)
                this[2].location(location2).binding(binding2).format(format2.i).offset(offset2)
                this[3].location(location3).binding(binding3).format(format3.i).offset(offset3)
                this[4].location(location4).binding(binding4).format(format4.i).offset(offset4)
            }

    fun VertexInputAttributeDescription(
            binding0: Int, location0: Int, format0: VkFormat, offset0: Int,
            binding1: Int, location1: Int, format1: VkFormat, offset1: Int,
            binding2: Int, location2: Int, format2: VkFormat, offset2: Int,
            binding3: Int, location3: Int, format3: VkFormat, offset3: Int,
            binding4: Int, location4: Int, format4: VkFormat, offset4: Int,
            binding5: Int, location5: Int, format5: VkFormat, offset5: Int): VkVertexInputAttributeDescription.Buffer =
            VertexInputAttributeDescription(4) {
                this[0].location(location0).binding(binding0).format(format0.i).offset(offset0)
                this[1].location(location1).binding(binding1).format(format1.i).offset(offset1)
                this[2].location(location2).binding(binding2).format(format2.i).offset(offset2)
                this[3].location(location3).binding(binding3).format(format3.i).offset(offset3)
                this[4].location(location4).binding(binding4).format(format4.i).offset(offset4)
                this[5].location(location5).binding(binding5).format(format5.i).offset(offset5)
            }

    fun VertexInputAttributeDescription(
            binding0: Int, location0: Int, format0: VkFormat, offset0: Int,
            binding1: Int, location1: Int, format1: VkFormat, offset1: Int,
            binding2: Int, location2: Int, format2: VkFormat, offset2: Int,
            binding3: Int, location3: Int, format3: VkFormat, offset3: Int,
            binding4: Int, location4: Int, format4: VkFormat, offset4: Int,
            binding5: Int, location5: Int, format5: VkFormat, offset5: Int,
            binding6: Int, location6: Int, format6: VkFormat, offset6: Int): VkVertexInputAttributeDescription.Buffer =
            VertexInputAttributeDescription(4) {
                this[0].location(location0).binding(binding0).format(format0.i).offset(offset0)
                this[1].location(location1).binding(binding1).format(format1.i).offset(offset1)
                this[2].location(location2).binding(binding2).format(format2.i).offset(offset2)
                this[3].location(location3).binding(binding3).format(format3.i).offset(offset3)
                this[4].location(location4).binding(binding4).format(format4.i).offset(offset4)
                this[5].location(location5).binding(binding5).format(format5.i).offset(offset5)
                this[6].location(location6).binding(binding6).format(format6.i).offset(offset6)
            }

    /*
        functions
     */

    fun acquireNextImageKHR(device: VkDevice, swapchain: VkSwapchainKHR, timeout: Long, semaphore: VkSemaphore, fence: VkFence, imageIndex: KMutableProperty0<Int>): VkResult =
            stak {
                val pImageIndex = it.nmalloc(1, Int.BYTES)
                VkResult(KHRSwapchain.nvkAcquireNextImageKHR(device, swapchain.L, timeout, semaphore.L, fence.L, pImageIndex))
                        .also {
                            imageIndex.set(memGetInt(pImageIndex))
                        }
            }

    fun allocateCommandBuffers(device: VkDevice, allocateInfo: VkCommandBufferAllocateInfo, count: Int, commandBuffers: ArrayList<VkCommandBuffer>): VkResult =
            stak {
                commandBuffers.clear()
                val pCommandBuffer = it.nmalloc(Pointer.POINTER_SIZE, Pointer.POINTER_SIZE * count)
                VkResult(VK10.nvkAllocateCommandBuffers(device, allocateInfo.adr, pCommandBuffer)).also {
                    for (i in 0 until count)
                        commandBuffers += VkCommandBuffer(memGetAddress(pCommandBuffer + Pointer.POINTER_SIZE * i), device)
                }
            }

    fun allocateDescriptorSets(device: VkDevice, allocateInfo: VkDescriptorSetAllocateInfo, descriptorSets: KMutableProperty0<VkDescriptorSet>): VkResult =
            stak {
                val pDescriptorSets = it.nmalloc(1, Long.BYTES)
                VkResult(VK10.nvkAllocateDescriptorSets(device, allocateInfo.adr, pDescriptorSets)).also {
                    descriptorSets.set(VkDescriptorSet(memGetLong(pDescriptorSets)))
                }
            }

    fun allocateMemory(device: VkDevice, allocateInfo: VkMemoryAllocateInfo, memory: KMutableProperty0<VkDeviceMemory>): VkResult =
            stak {
                val pMemory = it.nmalloc(1, Long.BYTES)
                VkResult(VK10.nvkAllocateMemory(device, allocateInfo.adr, NULL, pMemory)).also {
                    memory.set(VkDeviceMemory(memGetLong(pMemory)))
                }
            }

    fun beginCommandBuffer(commandBuffer: VkCommandBuffer, beginInfo: VkCommandBufferBeginInfo): VkResult =
            VkResult(VK10.nvkBeginCommandBuffer(commandBuffer, beginInfo.adr))

    fun cmdBeginRenderPass(commandBuffer: VkCommandBuffer, renderPassBegin: VkRenderPassBeginInfo, contents: VkSubpassContents) =
            VK10.nvkCmdBeginRenderPass(commandBuffer, renderPassBegin.adr, contents.i)

    fun cmdBindDescriptorSets(commandBuffer: VkCommandBuffer, pipelineBindPoint: VkPipelineBindPoint, layout: VkPipelineLayout, descriptorSet: VkDescriptorSet, dynamicOffsets: Int? = null) =
            stak {
                val pDescriptorSets = it.nmalloc(1, Long.BYTES)
                memPutLong(pDescriptorSets, descriptorSet.L)
                val dynamicOffsetCount: Int
                val pDynamicOffset: Long
                if (dynamicOffsets != null) {
                    dynamicOffsetCount = 1
                    pDynamicOffset = it.nmalloc(1, Int.BYTES)
                    memPutInt(pDynamicOffset, dynamicOffsets)
                } else {
                    dynamicOffsetCount = 0
                    pDynamicOffset = NULL
                }
                VK10.nvkCmdBindDescriptorSets(commandBuffer, pipelineBindPoint.i, layout.L, 0, 1, pDescriptorSets, dynamicOffsetCount, pDynamicOffset)
            }

    fun cmdBindIndexBuffer(commandBuffer: VkCommandBuffer, buffer: VkBuffer, offset: VkDeviceSize, indexType: VkIndexType) =
            VK10.vkCmdBindIndexBuffer(commandBuffer, buffer.L, offset.L, indexType.i)

    fun cmdBindPipeline(commandBuffer: VkCommandBuffer, pipelineBindPoint: VkPipelineBindPoint, pipeline: VkPipeline) =
            VK10.vkCmdBindPipeline(commandBuffer, pipelineBindPoint.i, pipeline.L)

    fun cmdBindVertexBuffer(commandBuffer: VkCommandBuffer, firstBinding: Int, buffer: VkBuffer) =
            stak {
                val pBuffer = it.nmalloc(1, Int.BYTES)
                memPutLong(pBuffer, buffer.L)
                val pOffset = it.ncalloc(1, Long.BYTES, 1)
                VK10.nvkCmdBindVertexBuffers(commandBuffer, firstBinding, 1, pBuffer, pOffset)
            }

    fun cmdDrawIndexed(commandBuffer: VkCommandBuffer, indexCount: Int, instanceCount: Int, firstIndex: Int, vertexOffset: Int, firstInstance: Int) =
            VK10.vkCmdDrawIndexed(commandBuffer, indexCount, instanceCount, firstIndex, vertexOffset, firstInstance)

    fun cmdEndRenderPass(commandBuffer: VkCommandBuffer) = VK10.vkCmdEndRenderPass(commandBuffer)

    fun cmdSetScissor(commandBuffer: VkCommandBuffer, firstScissor: Int, scissors: VkRect2D.Buffer) =
            VK10.nvkCmdSetScissor(commandBuffer, firstScissor, scissors.remaining(), scissors.adr)

    fun cmdSetViewport(commandBuffer: VkCommandBuffer, firstViewport: Int, viewports: VkViewport.Buffer) =
            VK10.nvkCmdSetViewport(commandBuffer, firstViewport, viewports.remaining(), viewports.adr)

    fun createBuffer(device: VkDevice, createInfo: VkBufferCreateInfo, buffer: KMutableProperty0<VkBuffer>): VkResult =
            stak {
                val pBuffer = it.nmalloc(1, Long.BYTES)
                VkResult(VK10.nvkCreateBuffer(device, createInfo.adr, NULL, pBuffer)).also {
                    buffer.set(VkBuffer(memGetLong(pBuffer)))
                }
            }

    fun createCommandPool(device: VkDevice, createInfo: VkCommandPoolCreateInfo, commandPool: KMutableProperty0<VkCommandPool>): VkResult =
            stak {
                val pCommandPool = it.nmalloc(1, Long.BYTES)
                VkResult(VK10.nvkCreateCommandPool(device, createInfo.adr, NULL, pCommandPool)).also {
                    commandPool.set(VkCommandPool(memGetLong(pCommandPool)))
                }
            }

    fun createCommandPool(device: VkDevice, createInfo: VkCommandPoolCreateInfo, commandPool: LongBuffer): VkResult =
            VkResult(VK10.nvkCreateCommandPool(device, createInfo.adr, NULL, memAddress(commandPool)))

    fun createDebugReportCallbackEXT(instance: VkInstance, createInfo: VkDebugReportCallbackCreateInfoEXT, callback: KMutableProperty0<Long>): VkResult =
            stak {
                val long = it.nmalloc(1, Long.BYTES)
                VkResult(EXTDebugReport.nvkCreateDebugReportCallbackEXT(instance, createInfo.adr, NULL, long)).also {
                    callback.set(MemoryUtil.memGetLong(long))
                }
            }

    fun createDescriptorPool(device: VkDevice, createInfo: VkDescriptorPoolCreateInfo, descriptorPool: KMutableProperty0<VkDescriptorPool>): VkResult =
            stak {
                val pDescriptorPool = it.nmalloc(1, Long.BYTES)
                VkResult(VK10.nvkCreateDescriptorPool(device, createInfo.adr, NULL, pDescriptorPool)).also {
                    descriptorPool.set(VkDescriptorPool(memGetLong(pDescriptorPool)))
                }
            }

    fun createDescriptorSetLayout(device: VkDevice, createInfo: VkDescriptorSetLayoutCreateInfo, setLayout: KMutableProperty0<VkDescriptorSetLayout>): VkResult =
            stak {
                val pSetLayout = it.nmalloc(1, Long.BYTES)
                VkResult(VK10.nvkCreateDescriptorSetLayout(device, createInfo.adr, NULL, pSetLayout)).also {
                    setLayout.set(VkDescriptorSetLayout(memGetLong(pSetLayout)))
                }
            }

    fun createDevice(physicalDevice: VkPhysicalDevice, createInfo: VkDeviceCreateInfo, device: KMutableProperty0<VkDevice?>): VkResult =
            stak {
                val pDevice = it.nmalloc(Pointer.POINTER_SIZE, Pointer.POINTER_SIZE)
                VkResult(VK10.nvkCreateDevice(physicalDevice, createInfo.adr, NULL, pDevice)).also {
                    device.set(VkDevice(memGetLong(pDevice), physicalDevice, createInfo))
                }
            }

    fun createFence(device: VkDevice, createInfo: VkFenceCreateInfo, fence: LongBuffer): VkResult = // TODO LongBuffer?
            stak {
                val pFence = it.nmalloc(1, Long.BYTES)
                VkResult(VK10.nvkCreateFence(device, createInfo.adr, NULL, pFence)).also {
                    fence[0] = memGetLong(pFence)
                }
            }

    fun createFences(device: VkDevice, createInfo: VkFenceCreateInfo, fences: ArrayList<VkFence>) =
            stak {
                val pFence = it.nmalloc(1, Long.BYTES)
                for (i in fences.indices) {
                    VK_CHECK_RESULT(VK10.nvkCreateFence(device, createInfo.adr, NULL, pFence))
                    fences[i] = VkFence(memGetLong(pFence))
                }
            }

    fun createFramebuffer(device: VkDevice, createInfo: VkFramebufferCreateInfo, framebuffer: ArrayList<VkFramebuffer>, index: Int): VkResult =
            stak {
                val pFramebuffer = it.nmalloc(1, Long.BYTES)
                VkResult(VK10.nvkCreateFramebuffer(device, createInfo.adr, NULL, pFramebuffer)).also {
                    framebuffer[index] = VkFramebuffer(memGetLong(pFramebuffer))
                }
            }

    fun createGraphicsPipelines(device: VkDevice, pipelineCache: VkPipelineCache, createInfo: VkGraphicsPipelineCreateInfo, pipelines: KMutableProperty0<VkPipeline>): VkResult =
            stak {
                val pPipelines = it.nmalloc(1, Long.BYTES)
                VkResult(VK10.nvkCreateGraphicsPipelines(device, pipelineCache.L, 1, createInfo.adr, NULL, pPipelines)).also {
                    pipelines.set(VkPipeline(memGetLong(pPipelines)))
                }
            }

    fun createGraphicsPipelines(device: VkDevice, pipelineCache: VkPipelineCache, createInfos: VkGraphicsPipelineCreateInfo.Buffer, pipelines: KMutableProperty0<VkPipeline>): VkResult =
            stak {
                val pPipelines = it.nmalloc(1, Long.BYTES)
                VkResult(VK10.nvkCreateGraphicsPipelines(device, pipelineCache.L, createInfos.remaining(), createInfos.adr, NULL, pPipelines)).also {
                    pipelines.set(VkPipeline(memGetLong(pPipelines)))
                }
            }

    fun createImage(device: VkDevice, createInfo: VkImageCreateInfo, image: KMutableProperty0<VkImage>): VkResult =
            stak {
                val pImage = it.nmalloc(1, Long.BYTES)
                VkResult(VK10.nvkCreateImage(device, createInfo.adr, NULL, pImage)).also {
                    image.set(VkImage(memGetLong(pImage)))
                }
            }

    fun createImageView(device: VkDevice, createInfo: VkImageViewCreateInfo, view: KMutableProperty0<VkImageView>): VkResult =
            stak {
                val pView = it.nmalloc(1, Long.BYTES)
                VkResult(VK10.nvkCreateImageView(device, createInfo.adr, NULL, pView)).also {
                    view.set(VkImageView(memGetLong(pView)))
                }
            }

    infix fun createInstance(createInfo: VkInstanceCreateInfo): VkInstance =
            stak {
                val pInstance = it.nmalloc(Pointer.POINTER_SIZE, Pointer.POINTER_SIZE)
                VK_CHECK_RESULT(VK10.nvkCreateInstance(createInfo.adr, NULL, pInstance))
                VkInstance(MemoryUtil.memGetLong(pInstance), createInfo)
            }

    fun createInstance(createInfo: VkInstanceCreateInfo, instance: KMutableProperty0<VkInstance>): VkResult =
            stak {
                val pInstance = it.nmalloc(Pointer.POINTER_SIZE, Pointer.POINTER_SIZE)
                VkResult(VK10.nvkCreateInstance(createInfo.adr, NULL, pInstance)).also {
                    instance.set(VkInstance(MemoryUtil.memGetLong(pInstance), createInfo))
                }
            }

    fun createPipelineCache(device: VkDevice, createInfo: VkPipelineCacheCreateInfo, pipelineCache: KMutableProperty0<VkPipelineCache>): VkResult =
            stak {
                val pPipelineCache = it.nmalloc(1, Long.BYTES)
                VkResult(VK10.nvkCreatePipelineCache(device, createInfo.adr, NULL, pPipelineCache)).also {
                    pipelineCache.set(VkPipelineCache(memGetLong(pPipelineCache)))
                }
            }

    fun createPipelineLayout(device: VkDevice, createInfo: VkPipelineLayoutCreateInfo, pipelineLayout: KMutableProperty0<VkPipelineLayout>): VkResult =
            stak {
                val pPipelineLayout = it.nmalloc(1, Long.BYTES)
                VkResult(VK10.nvkCreatePipelineLayout(device, createInfo.adr, NULL, pPipelineLayout)).also {
                    pipelineLayout.set(VkPipelineLayout(memGetLong(pPipelineLayout)))
                }
            }

    fun createRenderPass(device: VkDevice, createInfo: VkRenderPassCreateInfo, renderPass: KMutableProperty0<VkRenderPass>): VkResult =
            stak {
                val pRenderPass = it.nmalloc(1, Long.BYTES)
                VkResult(VK10.nvkCreateRenderPass(device, createInfo.adr, NULL, pRenderPass)).also {
                    renderPass.set(VkRenderPass(memGetLong(pRenderPass)))
                }
            }

    fun createSemaphore(device: VkDevice, createInfo: VkSemaphoreCreateInfo, semaphore: KMutableProperty0<VkSemaphore>): VkResult =
            stak {
                val pSemaphore = it.nmalloc(1, Long.BYTES)
                VkResult(VK10.nvkCreateSemaphore(device, createInfo.adr, NULL, pSemaphore)).also {
                    semaphore.set(VkSemaphore(memGetLong(pSemaphore)))
                }
            }

    fun createSemaphore(device: VkDevice, createInfo: VkSemaphoreCreateInfo, semaphore: VkSemaphoreBuffer): VkResult =
            VkResult(VK10.nvkCreateSemaphore(device, createInfo.adr, NULL, memAddress(semaphore)))

    fun createShaderModule(device: VkDevice, createInfo: VkShaderModuleCreateInfo, shaderModule: LongBuffer): VkResult =
            VkResult(VK10.nvkCreateShaderModule(device, createInfo.adr, NULL, memAddress(shaderModule)))

    fun createSwapchainKHR(device: VkDevice, createInfo: VkSwapchainCreateInfoKHR, swapchain: KMutableProperty0<VkSwapchainKHR>): VkResult =
            stak {
                val pSwapchain = it.nmalloc(1, Long.BYTES)
                VkResult(KHRSwapchain.nvkCreateSwapchainKHR(device, createInfo.adr, NULL, pSwapchain)).also {
                    swapchain.set(VkSwapchainKHR(memGetLong(pSwapchain)))
                }
            }

    fun destroyDescriptorPool(device: VkDevice, descriptorPool: VkDescriptorPool) =
            VK10.nvkDestroyDescriptorPool(device, descriptorPool.L, NULL)

    fun destroyDescriptorSetLayout(device: VkDevice, descriptorSetLayout: VkDescriptorSetLayout) =
            VK10.nvkDestroyDescriptorSetLayout(device, descriptorSetLayout.L, NULL)

    fun destroyBuffer(device: VkDevice, buffer: VkBuffer) = VK10.nvkDestroyBuffer(device, buffer.L, NULL)

    fun destroyCommandPool(device: VkDevice, commandPool: VkCommandPool) =
            VK10.nvkDestroyCommandPool(device, commandPool.L, NULL)

    fun destroyFence(device: VkDevice, fence: VkFence) = VK10.nvkDestroyFence(device, fence.L, NULL)

    fun destroyFences(device: VkDevice, fences: Iterable<VkFence>) {
        for (i in fences)
            VK10.nvkDestroyFence(device, i.L, NULL)
    }

    fun destroyFramebuffers(device: VkDevice, framebuffers: Iterable<VkFramebuffer>) {
        for (i in framebuffers)
            VK10.nvkDestroyFramebuffer(device, i.L, NULL)
    }

    fun destroyImage(device: VkDevice, image: VkImage) = VK10.nvkDestroyImage(device, image.L, NULL)

    fun destroyImageView(device: VkDevice, imageView: VkImageView) = VK10.nvkDestroyImageView(device, imageView.L, NULL)

    fun destroyPipeline(device: VkDevice, pipeline: VkPipeline) = VK10.nvkDestroyPipeline(device, pipeline.L, NULL)

    fun destroyPipelineCache(device: VkDevice, pipelineCache: VkPipelineCache) =
            VK10.nvkDestroyPipelineCache(device, pipelineCache.L, NULL)

    fun destroyPipelineLayout(device: VkDevice, pipelineLayout: VkPipelineLayout) =
            VK10.nvkDestroyPipelineLayout(device, pipelineLayout.L, NULL)

    fun destroyRenderPass(device: VkDevice, renderPass: VkRenderPass) =
            VK10.nvkDestroyRenderPass(device, renderPass.L, NULL)

    fun destroySemaphore(device: VkDevice, semaphore: VkSemaphore) =
            VK10.nvkDestroySemaphore(device, semaphore.L, NULL)

    fun destroyShaderModules(device: VkDevice, shaderModules: Iterable<VkShaderModule>, allocator: VkAllocationCallbacks? = null) {
        for (i in shaderModules)
            VK10.nvkDestroyShaderModule(device, i.L, allocator?.adr ?: NULL)
    }

    fun destroyShaderModules(device: VkDevice, shaderModules: VkPipelineShaderStageCreateInfo.Buffer) {
        for (i in shaderModules)
            VK10.nvkDestroyShaderModule(device, i.module.L, NULL)
    }

    fun destroySwapchainKHR(device: VkDevice, swapchain: VkSwapchainKHR) {
        KHRSwapchain.nvkDestroySwapchainKHR(device, swapchain.L, NULL)
    }

    fun endCommandBuffer(commandBuffer: VkCommandBuffer): VkResult =
            VkResult(VK10.vkEndCommandBuffer(commandBuffer))

    fun enumerateDeviceExtensionProperties(physicalDevice: VkPhysicalDevice, layerName: String? = null): ArrayList<String> =
            stak {
                val pCount = it.nmalloc(1, Int.BYTES)
                val pLayerName = layerName?.toUTF8(it)?.let(::memAddress) ?: NULL
                VK_CHECK_RESULT(VK10.nvkEnumerateDeviceExtensionProperties(physicalDevice, pLayerName, pCount, NULL))
                val count = memGetInt(pCount)
                val res = ArrayList<String>(count)
                if (count > 0) {
                    val properties = ExtensionProperties(count)
                    VK_CHECK_RESULT(VK10.nvkEnumerateDeviceExtensionProperties(physicalDevice, pLayerName, pCount, properties.adr))
                    properties.map { it.extensionNameString() }.toCollection(res)
                }
                res
            }

    fun enumeratePhysicalDevices(instance: VkInstance): ArrayList<VkPhysicalDevice> =
            stak {
                val physicalDevices = ArrayList<VkPhysicalDevice>()
                val pPhysicalDeviceCount = it.nmalloc(1, Int.BYTES)
                var physicalDeviceCount: Int
                var result: VkResult
                do {
                    result = VkResult(VK10.nvkEnumeratePhysicalDevices(instance, pPhysicalDeviceCount, NULL))
                    physicalDeviceCount = memGetInt(pPhysicalDeviceCount)
                    if (result == SUCCESS && physicalDeviceCount > 0) {
                        val pPhysicalDevices = it.nmalloc(Pointer.POINTER_SIZE, physicalDeviceCount * Pointer.POINTER_SIZE)
                        result = VkResult(VK10.nvkEnumeratePhysicalDevices(instance, pPhysicalDeviceCount, pPhysicalDevices))
                        for (i in 0 until physicalDeviceCount)
                            physicalDevices += VkPhysicalDevice(memGetAddress(pPhysicalDevices), instance)
                    }
                } while (result == INCOMPLETE)
                assert(physicalDeviceCount <= physicalDevices.size)
                physicalDevices resize physicalDeviceCount
                physicalDevices
            }

    fun flushMappedMemoryRange(device: VkDevice, memoryRange: VkMappedMemoryRange): VkResult =
            VkResult(VK10.nvkFlushMappedMemoryRanges(device, 1, memoryRange.adr))

    fun freeCommandBuffers(device: VkDevice, commandPool: VkCommandPool, commandBuffers: ArrayList<VkCommandBuffer>) =
            stak {
                val pointers = it.nmalloc(Pointer.POINTER_SIZE, commandBuffers.size * Pointer.POINTER_SIZE)
                for (i in commandBuffers.indices)
                    memPutAddress(pointers + Pointer.POINTER_SIZE * i, commandBuffers[i].adr)
                VK10.nvkFreeCommandBuffers(device, commandPool.L, commandBuffers.size, pointers)
            }

    fun freeMemory(device: VkDevice, memory: VkDeviceMemory) = VK10.nvkFreeMemory(device, memory.L, NULL)

    fun getDeviceQueue(device: VkDevice, queueFamilyIndex: Int, queueIndex: Int, queue: KMutableProperty0<VkQueue>) =
            stak {
                val pQueue = it.nmalloc(Pointer.POINTER_SIZE, Pointer.POINTER_SIZE)
                VK10.nvkGetDeviceQueue(device, queueFamilyIndex, queueIndex, pQueue)
                queue.set(VkQueue(memGetLong(pQueue), device))
            }

    fun getPhysicalDeviceFormatProperties(physicalDevice: VkPhysicalDevice, format: VkFormat): VkFormatProperties =
            FormatProperties {
                VK10.nvkGetPhysicalDeviceFormatProperties(physicalDevice, format.i, adr)
            }

    fun getPhysicalDeviceQueueFamilyProperties(physicalDevice: VkPhysicalDevice): ArrayList<VkQueueFamilyProperties> =
            stak {
                val pCount = it.nmalloc(1, Int.BYTES)
                VK10.nvkGetPhysicalDeviceQueueFamilyProperties(physicalDevice, pCount, NULL)
                val count = memGetInt(pCount)
                val pQueueFamilyProperties = VkQueueFamilyProperties.calloc(count)
                VK10.nvkGetPhysicalDeviceQueueFamilyProperties(physicalDevice, pCount, pQueueFamilyProperties.adr)
                pQueueFamilyProperties.toCollection(arrayListOf())
            }

    fun getPhysicalDeviceSurfaceSupportKHR(physicalDevice: VkPhysicalDevice, queueFamily: Int, surface: VkSurface): Boolean =
            stak {
                val supported = it.nmalloc(1, Int.BYTES)
                KHRSurface.nvkGetPhysicalDeviceSurfaceSupportKHR(physicalDevice, queueFamily, surface.L, supported)
                memGetBoolean(supported)
            }

    fun getPhysicalDeviceSurfaceSupportKHR(physicalDevice: VkPhysicalDevice, queueFamilyProperties: ArrayList<VkQueueFamilyProperties>, surface: VkSurface): BooleanArray =
            stak {
                val supported = it.nmalloc(1, Int.BYTES)
                BooleanArray(queueFamilyProperties.size) {
                    KHRSurface.nvkGetPhysicalDeviceSurfaceSupportKHR(physicalDevice, it, surface.L, supported)
                    memGetBoolean(supported)
                }
            }

    fun getPhysicalDeviceSurfaceFormatsKHR(physicalDevice: VkPhysicalDevice, surface: VkSurface): ArrayList<VkSurfaceFormatKHR> =
            stak {
                val pCount = it.nmalloc(1, Int.BYTES)
                VK_CHECK_RESULT(KHRSurface.nvkGetPhysicalDeviceSurfaceFormatsKHR(physicalDevice, surface.L, pCount, NULL))
                val count = memGetInt(pCount)
                assert(count > 0)
                val surfaceFormats = SurfaceFormatKHR(count)
                VK_CHECK_RESULT(KHRSurface.nvkGetPhysicalDeviceSurfaceFormatsKHR(physicalDevice, surface.L, pCount, surfaceFormats.adr))
                return surfaceFormats.toCollection(arrayListOf())
            }

    fun getPhysicalDeviceSurfaceCapabilitiesKHR(physicalDevice: VkPhysicalDevice, surface: VkSurface): VkSurfaceCapabilitiesKHR =
            SurfaceCapabilitiesKHR {
                VK_CHECK_RESULT(KHRSurface.nvkGetPhysicalDeviceSurfaceCapabilitiesKHR(physicalDevice, surface.L, adr))
            }

    fun getPhysicalDeviceSurfacePresentModesKHR(physicalDevice: VkPhysicalDevice, surface: VkSurface): ArrayList<VkPresentMode> =
            stak {
                val pCount = it.nmalloc(1, Int.BYTES)
                VK_CHECK_RESULT(KHRSurface.nvkGetPhysicalDeviceSurfacePresentModesKHR(physicalDevice, surface.L, pCount, NULL))
                val count = memGetInt(pCount)
                assert(count > 0)
                val presentModes = it.nmalloc(Int.BYTES, count * Int.BYTES)
                KHRSurface.nvkGetPhysicalDeviceSurfacePresentModesKHR(physicalDevice, surface.L, pCount, presentModes)
                val res = ArrayList<VkPresentMode>()
                for (i in 0 until count)
                    res += VkPresentMode of memGetInt(presentModes + Int.BYTES * i)
                return res
            }

    fun getSwapchainImagesKHR(device: VkDevice, swapchain: VkSwapchainKHR): VkImageArray =
            stak {
                val pCount = it.nmalloc(1, Int.BYTES)
                VK_CHECK_RESULT(KHRSwapchain.nvkGetSwapchainImagesKHR(device, swapchain.L, pCount, NULL))
                val count = memGetInt(pCount)
                val images = it.nmalloc(Long.BYTES, count * Long.BYTES)
                VK_CHECK_RESULT(KHRSwapchain.nvkGetSwapchainImagesKHR(device, swapchain.L, pCount, images))
                initVkImageArray(count) { i -> VkImage(memGetLong(images + Long.BYTES * i)) }
            }

    fun invalidateMappedMemoryRanges(device: VkDevice, memoryRange: VkMappedMemoryRange): VkResult =
            VkResult(VK10.nvkInvalidateMappedMemoryRanges(device, 1, memoryRange.adr))

    fun queueSubmit(queue: VkQueue, submit: VkSubmitInfo, fence: VkFence = VkFence(NULL)): VkResult =
            VkResult(VK10.nvkQueueSubmit(queue, 1, submit.adr, fence.L))

    fun updateDescriptorSets(device: VkDevice, descriptorWrites: VkWriteDescriptorSet.Buffer, descriptorCopies: VkCopyDescriptorSet.Buffer? = null) =
            VK10.nvkUpdateDescriptorSets(device, descriptorWrites.remaining(), descriptorWrites.adr, descriptorCopies?.remaining()
                    ?: 0, descriptorCopies?.adr ?: NULL)

    val VERSION = "0.2.2"
}
