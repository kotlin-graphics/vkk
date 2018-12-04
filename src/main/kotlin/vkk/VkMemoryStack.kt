package vkk

import glm_.*
import glm_.vec2.Vec2i
import kool.*
import org.lwjgl.PointerBuffer
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.system.Pointer
import org.lwjgl.system.Struct
import org.lwjgl.vulkan.*
import vkk.`object`.*
import java.nio.*
import kotlin.reflect.KMutableProperty0

inline class VkMemoryStack_(val stack: MemoryStack)

inline class VkMemoryStack(val stack: MemoryStack) {

    // type constructors ===============================================================================================

    fun ApplicationInfo(): VkApplicationInfo = VkApplicationInfo.callocStack(stack).apply { type = VkStructureType.APPLICATION_INFO }
    inline fun ApplicationInfo(block: VkApplicationInfo.() -> Unit): VkApplicationInfo = ApplicationInfo().also(block)

    fun BufferCreateInfo(): VkBufferCreateInfo = VkBufferCreateInfo.callocStack(stack).apply { type = VkStructureType.BUFFER_CREATE_INFO }
    inline fun BufferCreateInfo(block: VkBufferCreateInfo.() -> Unit): VkBufferCreateInfo = BufferCreateInfo().also(block)

    fun BufferMemoryBarrier(): VkBufferMemoryBarrier = VkBufferMemoryBarrier.callocStack(stack).apply { type = VkStructureType.BUFFER_MEMORY_BARRIER }
    inline fun BufferMemoryBarrier(block: VkBufferMemoryBarrier.() -> Unit): VkBufferMemoryBarrier = BufferMemoryBarrier().also(block)

    fun CommandBufferAllocateInfo(): VkCommandBufferAllocateInfo = VkCommandBufferAllocateInfo.callocStack(stack).apply { type = VkStructureType.COMMAND_BUFFER_ALLOCATE_INFO }
    inline fun CommandBufferAllocateInfo(block: VkCommandBufferAllocateInfo.() -> Unit): VkCommandBufferAllocateInfo = CommandBufferAllocateInfo().also(block)

    fun CommandBufferBeginInfo(): VkCommandBufferBeginInfo = VkCommandBufferBeginInfo.callocStack(stack).apply { type = VkStructureType.COMMAND_BUFFER_BEGIN_INFO }
    inline fun CommandBufferBeginInfo(block: VkCommandBufferBeginInfo.() -> Unit): VkCommandBufferBeginInfo = CommandBufferBeginInfo().also(block)

    fun CommandBufferInheritanceInfo(): VkCommandBufferInheritanceInfo = VkCommandBufferInheritanceInfo.callocStack(stack).apply { type = VkStructureType.COMMAND_BUFFER_INHERITANCE_INFO }
    inline fun CommandBufferInheritanceInfo(block: VkCommandBufferInheritanceInfo.() -> Unit): VkCommandBufferInheritanceInfo = CommandBufferInheritanceInfo().also(block)

    fun CommandPoolCreateInfo(): VkCommandPoolCreateInfo = VkCommandPoolCreateInfo.callocStack(stack).apply { type = VkStructureType.COMMAND_POOL_CREATE_INFO }
    inline fun CommandPoolCreateInfo(block: VkCommandPoolCreateInfo.() -> Unit): VkCommandPoolCreateInfo = CommandPoolCreateInfo().also(block)

    fun ComputePipelineCreateInfo(): VkComputePipelineCreateInfo = VkComputePipelineCreateInfo.callocStack(stack).apply { type = VkStructureType.COMPUTE_PIPELINE_CREATE_INFO }
    inline fun ComputePipelineCreateInfo(block: VkComputePipelineCreateInfo.() -> Unit): VkComputePipelineCreateInfo = ComputePipelineCreateInfo().also(block)

    fun DebugMarkerMarkerInfoEXT(): VkDebugMarkerMarkerInfoEXT = VkDebugMarkerMarkerInfoEXT.callocStack(stack).apply { type = VkStructureType.DEBUG_MARKER_OBJECT_NAME_INFO_EXT }
    inline fun DebugMarkerMarkerInfoEXT(block: VkDebugMarkerMarkerInfoEXT.() -> Unit): VkDebugMarkerMarkerInfoEXT = DebugMarkerMarkerInfoEXT().also(block)

    fun DebugMarkerObjectNameInfoEXT(): VkDebugMarkerObjectNameInfoEXT = VkDebugMarkerObjectNameInfoEXT.callocStack(stack).apply { type = VkStructureType.DEBUG_MARKER_OBJECT_NAME_INFO_EXT }
    inline fun DebugMarkerObjectNameInfoEXT(block: VkDebugMarkerObjectNameInfoEXT.() -> Unit): VkDebugMarkerObjectNameInfoEXT = DebugMarkerObjectNameInfoEXT().also(block)

    fun DebugMarkerObjectTagInfoEXT(): VkDebugMarkerObjectTagInfoEXT = VkDebugMarkerObjectTagInfoEXT.callocStack(stack).apply { type = VkStructureType.DEBUG_MARKER_OBJECT_TAG_INFO_EXT }
    inline fun DebugMarkerObjectTagInfoEXT(block: VkDebugMarkerObjectTagInfoEXT .() -> Unit): VkDebugMarkerObjectTagInfoEXT = DebugMarkerObjectTagInfoEXT().also(block)

    fun DebugReportCallbackCreateInfoEXT(): VkDebugReportCallbackCreateInfoEXT = VkDebugReportCallbackCreateInfoEXT.callocStack(stack).apply { type = VkStructureType.DEBUG_REPORT_CALLBACK_CREATE_INFO_EXT }
    inline fun DebugReportCallbackCreateInfoEXT(block: VkDebugReportCallbackCreateInfoEXT.() -> Unit): VkDebugReportCallbackCreateInfoEXT = DebugReportCallbackCreateInfoEXT().also(block)

    fun DescriptorPoolCreateInfo(): VkDescriptorPoolCreateInfo = VkDescriptorPoolCreateInfo.callocStack(stack).apply { type = VkStructureType.DESCRIPTOR_POOL_CREATE_INFO }
    inline fun DescriptorPoolCreateInfo(block: VkDescriptorPoolCreateInfo.() -> Unit): VkDescriptorPoolCreateInfo = DescriptorPoolCreateInfo().also(block)

    fun DescriptorSetAllocateInfo(): VkDescriptorSetAllocateInfo = VkDescriptorSetAllocateInfo.callocStack(stack).apply { type = VkStructureType.DESCRIPTOR_SET_ALLOCATE_INFO }
    inline fun DescriptorSetAllocateInfo(block: VkDescriptorSetAllocateInfo.() -> Unit): VkDescriptorSetAllocateInfo = DescriptorSetAllocateInfo().also(block)

    fun DescriptorSetLayoutCreateInfo(): VkDescriptorSetLayoutCreateInfo = VkDescriptorSetLayoutCreateInfo.callocStack(stack).apply { type = VkStructureType.DESCRIPTOR_SET_LAYOUT_CREATE_INFO }
    inline fun DescriptorSetLayoutCreateInfo(block: VkDescriptorSetLayoutCreateInfo.() -> Unit): VkDescriptorSetLayoutCreateInfo = DescriptorSetLayoutCreateInfo().also(block)

    fun DeviceCreateInfo(): VkDeviceCreateInfo = VkDeviceCreateInfo.callocStack(stack).apply { type = VkStructureType.DEVICE_CREATE_INFO }
    inline fun DeviceCreateInfo(block: VkDeviceCreateInfo.() -> Unit): VkDeviceCreateInfo = DeviceCreateInfo().also(block)

    fun DeviceQueueCreateInfo(): VkDeviceQueueCreateInfo = VkDeviceQueueCreateInfo.callocStack(stack).apply { type = VkStructureType.DEVICE_QUEUE_CREATE_INFO }
    inline fun DeviceQueueCreateInfo(block: VkDeviceQueueCreateInfo.() -> Unit): VkDeviceQueueCreateInfo = DeviceQueueCreateInfo().also(block)

    fun FenceCreateInfo(): VkFenceCreateInfo = VkFenceCreateInfo.callocStack(stack).apply { type = VkStructureType.FENCE_CREATE_INFO }
    inline fun FenceCreateInfo(block: VkFenceCreateInfo.() -> Unit): VkFenceCreateInfo = FenceCreateInfo().also(block)

    fun FramebufferCreateInfo(): VkFramebufferCreateInfo = VkFramebufferCreateInfo.callocStack(stack).apply { type = VkStructureType.FRAMEBUFFER_CREATE_INFO }
    inline fun FramebufferCreateInfo(block: VkFramebufferCreateInfo.() -> Unit): VkFramebufferCreateInfo = FramebufferCreateInfo().also(block)

    fun GraphicsPipelineCreateInfo(): VkGraphicsPipelineCreateInfo = VkGraphicsPipelineCreateInfo.callocStack(stack).apply { type = VkStructureType.GRAPHICS_PIPELINE_CREATE_INFO }
    inline fun GraphicsPipelineCreateInfo(block: VkGraphicsPipelineCreateInfo.() -> Unit): VkGraphicsPipelineCreateInfo = GraphicsPipelineCreateInfo().also(block)

    fun ImageCreateInfo(): VkImageCreateInfo = VkImageCreateInfo.callocStack(stack).apply { type = VkStructureType.IMAGE_CREATE_INFO }
    inline fun ImageCreateInfo(block: VkImageCreateInfo.() -> Unit): VkImageCreateInfo = ImageCreateInfo().also(block)

    fun ImageMemoryBarrier(): VkImageMemoryBarrier = VkImageMemoryBarrier.callocStack(stack).apply {
        type = VkStructureType.IMAGE_MEMORY_BARRIER
        srcQueueFamilyIndex = VK10.VK_QUEUE_FAMILY_IGNORED
        dstQueueFamilyIndex = VK10.VK_QUEUE_FAMILY_IGNORED
    }

    inline fun ImageMemoryBarrier(block: VkImageMemoryBarrier.() -> Unit): VkImageMemoryBarrier = ImageMemoryBarrier().also(block)

    fun ImageViewCreateInfo(): VkImageViewCreateInfo = VkImageViewCreateInfo.callocStack(stack).apply { type = VkStructureType.IMAGE_VIEW_CREATE_INFO }
    inline fun ImageViewCreateInfo(block: VkImageViewCreateInfo.() -> Unit): VkImageViewCreateInfo = ImageViewCreateInfo().also(block)

    fun InstanceCreateInfo(): VkInstanceCreateInfo = VkInstanceCreateInfo.callocStack(stack).apply { type = VkStructureType.INSTANCE_CREATE_INFO }
    inline fun InstanceCreateInfo(block: VkInstanceCreateInfo.() -> Unit): VkInstanceCreateInfo = InstanceCreateInfo().also(block)

    fun MappedMemoryRange(): VkMappedMemoryRange = VkMappedMemoryRange.callocStack(stack).apply { type = VkStructureType.MAPPED_MEMORY_RANGE }
    inline fun MappedMemoryRange(block: VkMappedMemoryRange.() -> Unit): VkMappedMemoryRange = MappedMemoryRange().also(block)

    // TODO check
    fun MappedMemoryRange(capacity: Int): VkMappedMemoryRange.Buffer =
        VkMappedMemoryRange.callocStack(capacity, stack).also {
            for (range in it)
                range.type = VkStructureType.MAPPED_MEMORY_RANGE
        }

    fun MemoryAllocateInfo(): VkMemoryAllocateInfo = VkMemoryAllocateInfo.callocStack(stack).apply { type = VkStructureType.MEMORY_ALLOCATE_INFO }
    inline fun MemoryAllocateInfo(block: VkMemoryAllocateInfo.() -> Unit): VkMemoryAllocateInfo = MemoryAllocateInfo().also(block)

    fun PhysicalDeviceFeatures(): VkPhysicalDeviceFeatures = VkPhysicalDeviceFeatures.callocStack(stack)
    inline fun PhysicalDeviceFeatures(block: VkPhysicalDeviceFeatures.() -> Unit): VkPhysicalDeviceFeatures = PhysicalDeviceFeatures().also(block)

    fun PhysicalDeviceMemoryProperties(): VkPhysicalDeviceMemoryProperties = VkPhysicalDeviceMemoryProperties.callocStack(stack)
    fun PhysicalDeviceMemoryProperties(block: VkPhysicalDeviceMemoryProperties.() -> Unit): VkPhysicalDeviceMemoryProperties = PhysicalDeviceMemoryProperties().also(block)

    fun PhysicalDeviceProperties(): VkPhysicalDeviceProperties = VkPhysicalDeviceProperties.callocStack(stack)
    fun PhysicalDeviceProperties(block: VkPhysicalDeviceProperties.() -> Unit): VkPhysicalDeviceProperties = PhysicalDeviceProperties().also(block)

    fun PipelineCacheCreateInfo(): VkPipelineCacheCreateInfo = VkPipelineCacheCreateInfo.callocStack(stack).apply { type = VkStructureType.PIPELINE_CACHE_CREATE_INFO }
    inline fun PipelineCacheCreateInfo(block: VkPipelineCacheCreateInfo.() -> Unit): VkPipelineCacheCreateInfo = PipelineCacheCreateInfo().also(block)

    fun PipelineColorBlendStateCreateInfo(): VkPipelineColorBlendStateCreateInfo = VkPipelineColorBlendStateCreateInfo.callocStack(stack).apply { type = VkStructureType.PIPELINE_COLOR_BLEND_STATE_CREATE_INFO }
    inline fun PipelineColorBlendStateCreateInfo(block: VkPipelineColorBlendStateCreateInfo.() -> Unit): VkPipelineColorBlendStateCreateInfo = PipelineColorBlendStateCreateInfo().also(block)

    fun PipelineDepthStencilStateCreateInfo(): VkPipelineDepthStencilStateCreateInfo = VkPipelineDepthStencilStateCreateInfo.callocStack(stack).apply { type = VkStructureType.PIPELINE_DEPTH_STENCIL_STATE_CREATE_INFO }
    inline fun PipelineDepthStencilStateCreateInfo(block: VkPipelineDepthStencilStateCreateInfo.() -> Unit): VkPipelineDepthStencilStateCreateInfo = PipelineDepthStencilStateCreateInfo().also(block)

    fun PipelineDynamicStateCreateInfo(): VkPipelineDynamicStateCreateInfo = VkPipelineDynamicStateCreateInfo.callocStack(stack).apply { type = VkStructureType.PIPELINE_DYNAMIC_STATE_CREATE_INFO }
    inline fun PipelineDynamicStateCreateInfo(block: VkPipelineDynamicStateCreateInfo.() -> Unit): VkPipelineDynamicStateCreateInfo = PipelineDynamicStateCreateInfo().also(block)

    fun PipelineInputAssemblyStateCreateInfo(): VkPipelineInputAssemblyStateCreateInfo = VkPipelineInputAssemblyStateCreateInfo.callocStack(stack).apply { type = VkStructureType.PIPELINE_INPUT_ASSEMBLY_STATE_CREATE_INFO }
    inline fun PipelineInputAssemblyStateCreateInfo(block: VkPipelineInputAssemblyStateCreateInfo.() -> Unit): VkPipelineInputAssemblyStateCreateInfo = PipelineInputAssemblyStateCreateInfo().also(block)

    fun PipelineLayoutCreateInfo(): VkPipelineLayoutCreateInfo = VkPipelineLayoutCreateInfo.callocStack(stack).apply { type = VkStructureType.PIPELINE_LAYOUT_CREATE_INFO }
    inline fun PipelineLayoutCreateInfo(block: VkPipelineLayoutCreateInfo.() -> Unit): VkPipelineLayoutCreateInfo = PipelineLayoutCreateInfo().also(block)

    fun PipelineMultisampleStateCreateInfo(): VkPipelineMultisampleStateCreateInfo = VkPipelineMultisampleStateCreateInfo.callocStack(stack).apply { type = VkStructureType.PIPELINE_MULTISAMPLE_STATE_CREATE_INFO }
    inline fun PipelineMultisampleStateCreateInfo(block: VkPipelineMultisampleStateCreateInfo.() -> Unit): VkPipelineMultisampleStateCreateInfo = PipelineMultisampleStateCreateInfo().also(block)

    fun PipelineRasterizationStateCreateInfo(): VkPipelineRasterizationStateCreateInfo = VkPipelineRasterizationStateCreateInfo.callocStack(stack).apply { type = VkStructureType.PIPELINE_RASTERIZATION_STATE_CREATE_INFO }
    inline fun PipelineRasterizationStateCreateInfo(block: VkPipelineRasterizationStateCreateInfo.() -> Unit): VkPipelineRasterizationStateCreateInfo = PipelineRasterizationStateCreateInfo().also(block)

    // TODO check
    fun PipelineShaderStageCreateInfo(capacity: Int): VkPipelineShaderStageCreateInfo.Buffer =
        VkPipelineShaderStageCreateInfo.callocStack(capacity, stack).also {
            for (info in it)
                info.type = VkStructureType.PIPELINE_SHADER_STAGE_CREATE_INFO
        }

    fun PipelineVertexInputStateCreateInfo(): VkPipelineVertexInputStateCreateInfo = VkPipelineVertexInputStateCreateInfo.callocStack(stack).apply { type = VkStructureType.PIPELINE_VERTEX_INPUT_STATE_CREATE_INFO }
    inline fun PipelineVertexInputStateCreateInfo(block: VkPipelineVertexInputStateCreateInfo.() -> Unit): VkPipelineVertexInputStateCreateInfo = PipelineVertexInputStateCreateInfo().also(block)

    fun PipelineViewportStateCreateInfo(): VkPipelineViewportStateCreateInfo = VkPipelineViewportStateCreateInfo.callocStack(stack).apply { type = VkStructureType.PIPELINE_VIEWPORT_STATE_CREATE_INFO }
    inline fun PipelineViewportStateCreateInfo(block: VkPipelineViewportStateCreateInfo.() -> Unit): VkPipelineViewportStateCreateInfo = PipelineViewportStateCreateInfo().also(block)

    fun PresentInfoKHR(): VkPresentInfoKHR = VkPresentInfoKHR.callocStack(stack).apply { type = VkStructureType.PRESENT_INFO_KHR }
    inline fun PresentInfoKHR(block: VkPresentInfoKHR.() -> Unit): VkPresentInfoKHR = PresentInfoKHR().also(block)

    fun QueryPoolCreateInfo(): VkQueryPoolCreateInfo = VkQueryPoolCreateInfo.callocStack(stack).apply { type = VkStructureType.QUERY_POOL_CREATE_INFO }
    inline fun QueryPoolCreateInfo(block: VkQueryPoolCreateInfo.() -> Unit): VkQueryPoolCreateInfo = QueryPoolCreateInfo().also(block)

    fun RenderPassBeginInfo(): VkRenderPassBeginInfo = VkRenderPassBeginInfo.callocStack(stack).apply { type = VkStructureType.RENDER_PASS_BEGIN_INFO }
    inline fun RenderPassBeginInfo(block: VkRenderPassBeginInfo.() -> Unit): VkRenderPassBeginInfo = RenderPassBeginInfo().also(block)

    fun RenderPassCreateInfo(): VkRenderPassCreateInfo = VkRenderPassCreateInfo.callocStack(stack).apply { type = VkStructureType.RENDER_PASS_CREATE_INFO }
    inline fun RenderPassCreateInfo(block: VkRenderPassCreateInfo.() -> Unit): VkRenderPassCreateInfo = RenderPassCreateInfo().also(block)

    fun SamplerCreateInfo(): VkSamplerCreateInfo = VkSamplerCreateInfo.callocStack(stack).apply { type = VkStructureType.SAMPLER_CREATE_INFO; maxAnisotropy = 1f }
    inline fun SamplerCreateInfo(block: VkSamplerCreateInfo.() -> Unit): VkSamplerCreateInfo = SamplerCreateInfo().also(block)

    fun SemaphoreCreateInfo(): VkSemaphoreCreateInfo = VkSemaphoreCreateInfo.callocStack(stack).apply { type = VkStructureType.SEMAPHORE_CREATE_INFO }
    inline fun SemaphoreCreateInfo(block: VkSemaphoreCreateInfo.() -> Unit): VkSemaphoreCreateInfo = SemaphoreCreateInfo().also(block)

    fun ShaderModuleCreateInfo(): VkShaderModuleCreateInfo = VkShaderModuleCreateInfo.callocStack(stack).apply { type = VkStructureType.SHADER_MODULE_CREATE_INFO }
    inline fun ShaderModuleCreateInfo(block: VkShaderModuleCreateInfo.() -> Unit): VkShaderModuleCreateInfo = ShaderModuleCreateInfo().also(block)

    fun SubmitInfo(): VkSubmitInfo = VkSubmitInfo.callocStack(stack).apply { type = VkStructureType.SUBMIT_INFO }
    inline fun SubmitInfo(block: VkSubmitInfo.() -> Unit): VkSubmitInfo = SubmitInfo().also(block)

    fun SwapchainCreateInfoKHR(): VkSwapchainCreateInfoKHR = VkSwapchainCreateInfoKHR.callocStack(stack).apply { type = VkStructureType.SWAPCHAIN_CREATE_INFO_KHR }
    inline fun SwapchainCreateInfoKHR(block: VkSwapchainCreateInfoKHR.() -> Unit): VkSwapchainCreateInfoKHR = SwapchainCreateInfoKHR().also(block)

    fun WriteDescriptorSet(): VkWriteDescriptorSet = VkWriteDescriptorSet.callocStack(stack).apply { type = VkStructureType.WRITE_DESCRIPTOR_SET }
    inline fun WriteDescriptorSet(block: VkWriteDescriptorSet.() -> Unit): VkWriteDescriptorSet = WriteDescriptorSet().also(block)

    // TODO check
    fun WriteDescriptorSet(capacity: Int): VkWriteDescriptorSet.Buffer =
        VkWriteDescriptorSet.callocStack(capacity, stack).also {
            for (set in it)
                set.type = VkStructureType.WRITE_DESCRIPTOR_SET
        }

    /*
        normal constructor functions
    */

    fun AttachmentDescription(): VkAttachmentDescription = VkAttachmentDescription.callocStack(stack)
    fun AttachmentDescription(capacity: Int): VkAttachmentDescription.Buffer = VkAttachmentDescription.callocStack(capacity, stack)
    inline fun AttachmentDescription(block: VkAttachmentDescription.() -> Unit): VkAttachmentDescription = AttachmentDescription().also(block)

    fun AttachmentReference(): VkAttachmentReference = VkAttachmentReference.callocStack(stack)
    fun AttachmentReference(capacity: Int): VkAttachmentReference.Buffer = VkAttachmentReference.callocStack(capacity, stack)
    inline fun AttachmentReference(block: VkAttachmentReference.() -> Unit): VkAttachmentReference = AttachmentReference().also(block)

    fun BufferCopy(): VkBufferCopy = VkBufferCopy.callocStack(stack)
    fun BufferCopy(capacity: Int): VkBufferCopy.Buffer = VkBufferCopy.callocStack(capacity, stack)
    inline fun BufferCopy(block: VkBufferCopy.() -> Unit): VkBufferCopy = BufferCopy().also(block)

    fun BufferImageCopy(): VkBufferImageCopy = VkBufferImageCopy.callocStack(stack)
    fun BufferImageCopy(capacity: Int): VkBufferImageCopy.Buffer = VkBufferImageCopy.callocStack(capacity, stack)
    inline fun BufferImageCopy(block: VkBufferImageCopy.() -> Unit): VkBufferImageCopy = BufferImageCopy().also(block)

    fun ClearValue(capacity: Int): VkClearValue.Buffer = VkClearValue.callocStack(capacity, stack)

    fun DescriptorBufferInfo(): VkDescriptorBufferInfo = VkDescriptorBufferInfo.callocStack(stack)
    inline fun DescriptorBufferInfo(block: VkDescriptorBufferInfo.() -> Unit): VkDescriptorBufferInfo = DescriptorBufferInfo().also(block)

    fun DescriptorImageInfo(capacity: Int): VkDescriptorImageInfo.Buffer = VkDescriptorImageInfo.callocStack(capacity, stack)
    inline fun DescriptorImageInfo(block: VkDescriptorImageInfo.() -> Unit): VkDescriptorImageInfo = VkDescriptorImageInfo.callocStack(stack).also(block)

    fun DescriptorPoolSize(): VkDescriptorPoolSize = VkDescriptorPoolSize.callocStack(stack)
    fun DescriptorPoolSize(capacity: Int): VkDescriptorPoolSize.Buffer = VkDescriptorPoolSize.callocStack(capacity, stack)
    inline fun DescriptorPoolSize(block: VkDescriptorPoolSize.() -> Unit): VkDescriptorPoolSize = DescriptorPoolSize().also(block)
    inline fun DescriptorPoolSize(capacity: Int, block: VkDescriptorPoolSize.Buffer.() -> Unit): VkDescriptorPoolSize.Buffer = DescriptorPoolSize(capacity).also(block)

    fun DescriptorSetLayoutBinding(): VkDescriptorSetLayoutBinding = VkDescriptorSetLayoutBinding.callocStack(stack)
    fun DescriptorSetLayoutBinding(capacity: Int): VkDescriptorSetLayoutBinding.Buffer = VkDescriptorSetLayoutBinding.callocStack(capacity, stack)
    inline fun DescriptorSetLayoutBinding(block: VkDescriptorSetLayoutBinding.() -> Unit): VkDescriptorSetLayoutBinding = DescriptorSetLayoutBinding().also(block)
    inline fun DescriptorSetLayoutBinding(capacity: Int, block: VkDescriptorSetLayoutBinding.Buffer.() -> Unit): VkDescriptorSetLayoutBinding.Buffer = DescriptorSetLayoutBinding(capacity).also(block)

    fun ExtensionProperties(capacity: Int): VkExtensionProperties.Buffer = VkExtensionProperties.callocStack(capacity, stack)

    fun Extent2D(): VkExtent2D = VkExtent2D.callocStack(stack)
    inline fun Extent2D(block: VkExtent2D.() -> Unit): VkExtent2D = Extent2D().also(block)

    fun Extent3D(): VkExtent3D = VkExtent3D.callocStack(stack)
    inline fun Extent3D(block: VkExtent3D.() -> Unit): VkExtent3D = Extent3D().also(block)

    fun FormatProperties(): VkFormatProperties = VkFormatProperties.callocStack(stack)
    inline fun FormatProperties(block: VkFormatProperties.() -> Unit): VkFormatProperties = FormatProperties().also(block)

    fun ImageBlit(): VkImageBlit = VkImageBlit.callocStack(stack)
    inline fun ImageBlit(block: VkImageBlit.() -> Unit): VkImageBlit = ImageBlit().also(block)

    fun ImageCopy(): VkImageCopy = VkImageCopy.callocStack(stack)
    inline fun ImageCopy(block: VkImageCopy.() -> Unit): VkImageCopy = ImageCopy().also(block)

    fun ImageSubresource(): VkImageSubresource = VkImageSubresource.callocStack(stack)
    inline fun ImageSubresource(block: VkImageSubresource.() -> Unit): VkImageSubresource = ImageSubresource().also(block)

    fun ImageSubresourceRange(): VkImageSubresourceRange = VkImageSubresourceRange.callocStack(stack)
    inline fun ImageSubresourceRange(block: VkImageSubresourceRange.() -> Unit): VkImageSubresourceRange = ImageSubresourceRange().also(block)

    fun ImageSubresourceLayers(): VkImageSubresourceLayers = VkImageSubresourceLayers.callocStack(stack)
    inline fun ImageSubresourceLayers(block: VkImageSubresourceLayers.() -> Unit): VkImageSubresourceLayers = ImageSubresourceLayers().also(block)

//    inline fun InstanceCreateInfo(extensions: ArrayList<String>): VkInstanceCreateInfo {
//        return InstanceCreateInfo {
//
//        }
//    }

    fun MemoryRequirements(): VkMemoryRequirements = VkMemoryRequirements.callocStack(stack)
    inline fun MemoryRequirements(block: VkMemoryRequirements.() -> Unit): VkMemoryRequirements = MemoryRequirements().also(block)

    fun PipelineColorBlendAttachmentState(): VkPipelineColorBlendAttachmentState = VkPipelineColorBlendAttachmentState.callocStack(stack)
    fun PipelineColorBlendAttachmentState(capacity: Int): VkPipelineColorBlendAttachmentState.Buffer = VkPipelineColorBlendAttachmentState.callocStack(capacity, stack)
    inline fun PipelineColorBlendAttachmentState(block: VkPipelineColorBlendAttachmentState.() -> Unit): VkPipelineColorBlendAttachmentState = PipelineColorBlendAttachmentState().also(block)

    fun PushConstantRange(): VkPushConstantRange = VkPushConstantRange.callocStack(stack)
    fun PushConstantRange(capacity: Int): VkPushConstantRange.Buffer = VkPushConstantRange.callocStack(capacity, stack)
    inline fun PushConstantRange(block: VkPushConstantRange.() -> Unit): VkPushConstantRange = PushConstantRange().also(block)

    fun Rect2D(): VkRect2D = VkRect2D.callocStack(stack)
    inline fun Rect2D(block: VkRect2D.() -> Unit): VkRect2D = Rect2D().also(block)
    fun Rect2D(capacity: Int): VkRect2D.Buffer = VkRect2D.callocStack(capacity, stack)

    fun SpecializationMapEntry(): VkSpecializationMapEntry = VkSpecializationMapEntry.callocStack(stack)
    fun SpecializationMapEntry(capacity: Int): VkSpecializationMapEntry.Buffer = VkSpecializationMapEntry.callocStack(capacity, stack)
    inline fun SpecializationMapEntry(block: VkSpecializationMapEntry.() -> Unit): VkSpecializationMapEntry = SpecializationMapEntry().also(block)

    fun SpecializationInfo(): VkSpecializationInfo = VkSpecializationInfo.callocStack(stack)
    fun SpecializationInfo(capacity: Int): VkSpecializationInfo.Buffer = VkSpecializationInfo.callocStack(capacity, stack)
    inline fun SpecializationInfo(block: VkSpecializationInfo.() -> Unit): VkSpecializationInfo = SpecializationInfo().also(block)

    fun SubpassDependency(): VkSubpassDependency = VkSubpassDependency.callocStack(stack)
    fun SubpassDependency(capacity: Int): VkSubpassDependency.Buffer = VkSubpassDependency.callocStack(capacity, stack)
    inline fun SubpassDependency(block: VkSubpassDependency.() -> Unit): VkSubpassDependency = SubpassDependency().also(block)

    fun SubpassDescription(): VkSubpassDescription = VkSubpassDescription.callocStack(stack)
    fun SubpassDescription(capacity: Int): VkSubpassDescription.Buffer = VkSubpassDescription.callocStack(capacity, stack)
    inline fun SubpassDescription(block: VkSubpassDescription.() -> Unit): VkSubpassDescription = SubpassDescription().also(block)

    fun SubresourceLayout(): VkSubresourceLayout = VkSubresourceLayout.callocStack(stack)
    inline fun SubresourceLayout(capacity: Int): VkSubresourceLayout.Buffer = VkSubresourceLayout.callocStack(capacity, stack)

    fun SurfaceCapabilitiesKHR(): VkSurfaceCapabilitiesKHR = VkSurfaceCapabilitiesKHR.callocStack(stack)
    inline fun SurfaceCapabilitiesKHR(block: VkSurfaceCapabilitiesKHR.() -> Unit): VkSurfaceCapabilitiesKHR = SurfaceCapabilitiesKHR().also(block)

    fun SurfaceFormatKHR(): VkSurfaceFormatKHR = VkSurfaceFormatKHR.callocStack(stack)
    fun SurfaceFormatKHR(capacity: Int): VkSurfaceFormatKHR.Buffer = VkSurfaceFormatKHR.callocStack(capacity, stack)

    fun VertexInputAttributeDescription(): VkVertexInputAttributeDescription = VkVertexInputAttributeDescription.callocStack(stack)
    fun VertexInputAttributeDescription(capacity: Int): VkVertexInputAttributeDescription.Buffer = VkVertexInputAttributeDescription.callocStack(capacity, stack)
    inline fun VertexInputAttributeDescription(block: VkVertexInputAttributeDescription.() -> Unit): VkVertexInputAttributeDescription = VertexInputAttributeDescription().also(block)
    inline fun VertexInputAttributeDescription(capacity: Int, block: VkVertexInputAttributeDescription.Buffer.() -> Unit): VkVertexInputAttributeDescription.Buffer = VertexInputAttributeDescription(capacity).also(block)

    fun VertexInputBindingDescription(): VkVertexInputBindingDescription = VkVertexInputBindingDescription.callocStack(stack)
    inline fun VertexInputBindingDescription(block: VkVertexInputBindingDescription.() -> Unit): VkVertexInputBindingDescription = VertexInputBindingDescription().also(block)
    fun VertexInputBindingDescription(capacity: Int): VkVertexInputBindingDescription.Buffer = VkVertexInputBindingDescription.callocStack(capacity, stack)

    fun Viewport(): VkViewport = VkViewport.callocStack(stack)
    inline fun Viewport(block: VkViewport.() -> Unit): VkViewport = Viewport().also(block)
    fun Viewport(capacity: Int): VkViewport.Buffer = VkViewport.callocStack(capacity, stack)


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

    fun CommandBufferAllocateInfo(commandPool: VkCommandPool, level: VkCommandBufferLevel, bufferCount: Int): VkCommandBufferAllocateInfo = CommandBufferAllocateInfo {
        this.commandPool = commandPool
        this.level = level
        commandBufferCount = bufferCount
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
            this.dynamicStates = stack.vkDynamicStateBufferOf(dynamicStates)
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

    // TODO flag
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
        WriteDescriptorSet(2).also {
            it[0].dstSet(dstSet0.L).descriptorType(type0.i).dstBinding(binding0)
            if (info0 is VkDescriptorBufferInfo) it[0].bufferInfo_ = info0 else it[0].imageInfo_ = info0 as VkDescriptorImageInfo
            it[1].dstSet(dstSet1.L).descriptorType(type1.i).dstBinding(binding1)
            if (info1 is VkDescriptorBufferInfo) it[1].bufferInfo_ = info1 else it[1].imageInfo_ = info1 as VkDescriptorImageInfo
        }

    fun WriteDescriptorSet(
        dstSet0: VkDescriptorSet, type0: VkDescriptorType, binding0: Int, info0: Struct,
        dstSet1: VkDescriptorSet, type1: VkDescriptorType, binding1: Int, info1: Struct,
        dstSet2: VkDescriptorSet, type2: VkDescriptorType, binding2: Int, info2: Struct): VkWriteDescriptorSet.Buffer =
        WriteDescriptorSet(3).also {
            it[0].dstSet(dstSet0.L).descriptorType(type0.i).dstBinding(binding0)
            if (info0 is VkDescriptorBufferInfo) it[0].bufferInfo_ = info0 else it[0].imageInfo_ = info0 as VkDescriptorImageInfo
            it[1].dstSet(dstSet1.L).descriptorType(type1.i).dstBinding(binding1)
            if (info1 is VkDescriptorBufferInfo) it[1].bufferInfo_ = info1 else it[1].imageInfo_ = info1 as VkDescriptorImageInfo
            it[2].dstSet(dstSet2.L).descriptorType(type2.i).dstBinding(binding2)
            if (info2 is VkDescriptorBufferInfo) it[2].bufferInfo_ = info2 else it[2].imageInfo_ = info2 as VkDescriptorImageInfo
        }

    fun WriteDescriptorSet(
        dstSet0: VkDescriptorSet, type0: VkDescriptorType, binding0: Int, info0: Struct,
        dstSet1: VkDescriptorSet, type1: VkDescriptorType, binding1: Int, info1: Struct,
        dstSet2: VkDescriptorSet, type2: VkDescriptorType, binding2: Int, info2: Struct,
        dstSet3: VkDescriptorSet, type3: VkDescriptorType, binding3: Int, info3: Struct): VkWriteDescriptorSet.Buffer =
        WriteDescriptorSet(4).also {
            it[0].dstSet(dstSet0.L).descriptorType(type0.i).dstBinding(binding0)
            if (info0 is VkDescriptorBufferInfo) it[0].bufferInfo_ = info0 else it[0].imageInfo_ = info0 as VkDescriptorImageInfo
            it[1].dstSet(dstSet1.L).descriptorType(type1.i).dstBinding(binding1)
            if (info1 is VkDescriptorBufferInfo) it[1].bufferInfo_ = info1 else it[1].imageInfo_ = info1 as VkDescriptorImageInfo
            it[2].dstSet(dstSet2.L).descriptorType(type2.i).dstBinding(binding2)
            if (info2 is VkDescriptorBufferInfo) it[2].bufferInfo_ = info2 else it[2].imageInfo_ = info2 as VkDescriptorImageInfo
            it[3].dstSet(dstSet3.L).descriptorType(type3.i).dstBinding(binding3)
            if (info3 is VkDescriptorBufferInfo) it[3].bufferInfo_ = info3 else it[3].imageInfo_ = info3 as VkDescriptorImageInfo
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

    fun createSemaphore(device: VkDevice, createInfo: VkSemaphoreCreateInfo, semaphores: VkSemaphoreBuffer): VkResult =
        VkResult(VK10.nvkCreateSemaphore(device, createInfo.adr, NULL, semaphores.adr))

    fun createShaderModule(device: VkDevice, createInfo: VkShaderModuleCreateInfo, shaderModule: LongBuffer): VkResult =
        VkResult(VK10.nvkCreateShaderModule(device, createInfo.adr, NULL, memAddress(shaderModule)))

    fun createSwapchainKHR(device: VkDevice, createInfo: VkSwapchainCreateInfoKHR, swapchain: KMutableProperty0<VkSwapchainKHR>): VkResult =
        stak {
            val pSwapchain = it.nmalloc(1, Long.BYTES)
            VkResult(KHRSwapchain.nvkCreateSwapchainKHR(device, createInfo.adr, NULL, pSwapchain)).also {
                swapchain.set(VkSwapchainKHR(memGetLong(pSwapchain)))
            }
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

    fun flushMappedMemoryRange(device: VkDevice, memoryRange: VkMappedMemoryRange): VkResult =
        VkResult(VK10.nvkFlushMappedMemoryRanges(device, 1, memoryRange.adr))

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

    fun invalidateMappedMemoryRanges(device: VkDevice, memoryRange: VkMappedMemoryRange): VkResult =
        VkResult(VK10.nvkInvalidateMappedMemoryRanges(device, 1, memoryRange.adr))

    fun queueSubmit(queue: VkQueue, submit: VkSubmitInfo, fence: VkFence = VkFence(NULL)): VkResult =
        VkResult(VK10.nvkQueueSubmit(queue, 1, submit.adr, fence.L))

    fun updateDescriptorSets(device: VkDevice, descriptorWrites: VkWriteDescriptorSet.Buffer, descriptorCopies: VkCopyDescriptorSet.Buffer? = null) =
        VK10.nvkUpdateDescriptorSets(device, descriptorWrites.remaining(), descriptorWrites.adr, descriptorCopies?.remaining()
            ?: 0, descriptorCopies?.adr ?: NULL)


    // VkCommandBuffer =================================================================================================

    infix fun VkCommandBuffer.begin(beginInfo: VkCommandBufferBeginInfo) = VK_CHECK_RESULT(VK10.nvkBeginCommandBuffer(this, beginInfo.adr))

    fun VkCommandBuffer.begin(flags: VkCommandBufferUsageFlags = VkCommandBufferUsage.SIMULTANEOUS_USE_BIT.i) = begin(CommandBufferBeginInfo { this.flags = flags })

    fun VkCommandBuffer.beginRenderPass(renderPassBegin: VkRenderPassBeginInfo, contents: VkSubpassContents) = VK10.nvkCmdBeginRenderPass(this, renderPassBegin.adr, contents.i)

    fun VkCommandBuffer.bindDescriptorSets(pipelineBindPoint: VkPipelineBindPoint, layout: VkPipelineLayout, descriptorSet: VkDescriptorSet, dynamicOffsets: Int? = null) = stack {
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
        VK10.nvkCmdBindDescriptorSets(this, pipelineBindPoint.i, layout.L, 0, 1, pDescriptorSets, dynamicOffsetCount, pDynamicOffset)
    }

    fun VkCommandBuffer.bindIndexBuffer(buffer: VkBuffer, offset: VkDeviceSize, indexType: VkIndexType) = VK10.vkCmdBindIndexBuffer(this, buffer.L, offset.L, indexType.i)

    fun VkCommandBuffer.bindPipeline(pipelineBindPoint: VkPipelineBindPoint, pipeline: VkPipeline) = VK10.vkCmdBindPipeline(this, pipelineBindPoint.i, pipeline.L)

    infix fun VkCommandBuffer.bindVertexBuffers(buffer: VkBuffer) = bindVertexBuffers(0, buffer)

    fun VkCommandBuffer.bindVertexBuffers(firstBinding: Int, buffer: VkBuffer, offset: VkDeviceSize = VkDeviceSize(0)) = stack {
        val pBuffer = it.nmalloc(1, Long.BYTES)
        memPutLong(pBuffer, buffer.L)
        val pOffset = it.nmalloc(1, Long.BYTES)
        memPutLong(pOffset, offset.L)
        VK10.nvkCmdBindVertexBuffers(this, firstBinding, 1, pBuffer, pOffset)
    }

    fun VkCommandBuffer.blitImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, region: VkImageBlit, filter: VkFilter) = VK10.nvkCmdBlitImage(this, srcImage.L, srcImageLayout.i, dstImage.L, dstImageLayout.i, 1, region.adr, filter.i)

    fun VkCommandBuffer.copyBuffer(srcBuffer: VkBuffer, dstBuffer: VkBuffer, region: VkBufferCopy) = VK10.nvkCmdCopyBuffer(this, srcBuffer.L, dstBuffer.L, 1, region.adr)

    fun VkCommandBuffer.copyBuffer(srcBuffer: VkBuffer, dstBuffer: VkBuffer, regions: VkBufferCopy.Buffer) = VK10.nvkCmdCopyBuffer(this, srcBuffer.L, dstBuffer.L, regions.remaining(), regions.adr)

    fun VkCommandBuffer.copyBufferToImage(srcBuffer: VkBuffer, dstImage: VkImage, dstImageLayout: VkImageLayout, region: VkBufferImageCopy) = VK10.nvkCmdCopyBufferToImage(this, srcBuffer.L, dstImage.L, dstImageLayout.i, 1, region.adr)

    fun VkCommandBuffer.copyBufferToImage(srcBuffer: VkBuffer, dstImage: VkImage, dstImageLayout: VkImageLayout, region: VkBufferImageCopy.Buffer) = VK10.nvkCmdCopyBufferToImage(this, srcBuffer.L, dstImage.L, dstImageLayout.i, region.remaining(), region.adr)

    fun VkCommandBuffer.copyImage(srcImage: VkImage, srcImageLayout: VkImageLayout, dstImage: VkImage, dstImageLayout: VkImageLayout, region: VkImageCopy) = VK10.nvkCmdCopyImage(this, srcImage.L, srcImageLayout.i, dstImage.L, dstImageLayout.i, 1, region.adr)

    infix fun VkCommandBuffer.debugMarkerBegin(markerInfo: VkDebugMarkerMarkerInfoEXT) = EXTDebugMarker.nvkCmdDebugMarkerBeginEXT(this, markerInfo.adr)

    fun VkCommandBuffer.debugMarkerEnd() = EXTDebugMarker.vkCmdDebugMarkerEndEXT(this)

    infix fun VkCommandBuffer.debugMarkerInsert(markerInfo: VkDebugMarkerMarkerInfoEXT) = EXTDebugMarker.nvkCmdDebugMarkerInsertEXT(this, markerInfo.adr)

    fun VkCommandBuffer.dispatch(groupCountXY: Vec2i, groupCountZ: Int) = dispatch(groupCountXY.x, groupCountXY.y, groupCountZ)

    fun VkCommandBuffer.dispatch(groupCountX: Int, groupCountY: Int, groupCountZ: Int) = VK10.vkCmdDispatch(this, groupCountX, groupCountY, groupCountZ)

    fun VkCommandBuffer.draw(vertexCount: Int, instanceCount: Int, firstVertex: Int, firstInstance: Int) = VK10.vkCmdDraw(this, vertexCount, instanceCount, firstVertex, firstInstance)

    fun VkCommandBuffer.drawIndexed(indexCount: Int, instanceCount: Int, firstIndex: Int, vertexOffset: Int, firstInstance: Int) = VK10.vkCmdDrawIndexed(this, indexCount, instanceCount, firstIndex, vertexOffset, firstInstance)

    fun VkCommandBuffer.end() = VK_CHECK_RESULT(VK10.vkEndCommandBuffer(this))

    fun VkCommandBuffer.end(queue: VkQueue, submitInfoPNext: Pointer? = null) {
        end()
        submit(queue, submitInfoPNext)
    }

    fun VkCommandBuffer.end(device: VkDevice, commandPool: VkCommandPool, queue: VkQueue, submitInfoPNext: Pointer? = null) {
        end(queue, submitInfoPNext)
        device.freeCommandBuffer(commandPool, this)
    }

    fun VkCommandBuffer.endRenderPass() = VK10.vkCmdEndRenderPass(this)

    infix fun VkCommandBuffer.executeCommand(commandBuffer: VkCommandBuffer) = VK10.vkCmdExecuteCommands(this, commandBuffer)

    infix fun VkCommandBuffer.executeCommands(commandBuffers: Collection<VkCommandBuffer>) = stack {
        val count = commandBuffers.size
        val pCommandBuffers = it.mallocPointer(count)
        for (i in 0 until count)
            pCommandBuffers[i] = commandBuffers.elementAt(i)
        VK10.nvkCmdExecuteCommands(this, count, pCommandBuffers.adr)
    }

    infix fun VkCommandBuffer.nextSubpass(contents: VkSubpassContents) = VK10.vkCmdNextSubpass(this, contents.i)

    fun VkCommandBuffer.pipelineBarrier(srcStageMask: VkPipelineStage, dstStageMask: VkPipelineStage,
                                        dependencyFlags: VkDependencyFlags = 0,
                                        memoryBarrier: VkMemoryBarrier? = null,
                                        bufferMemoryBarrier: VkBufferMemoryBarrier? = null,
                                        imageMemoryBarrier: VkImageMemoryBarrier? = null) = pipelineBarrier(srcStageMask.i, dstStageMask.i, dependencyFlags, memoryBarrier, bufferMemoryBarrier, imageMemoryBarrier)

    fun VkCommandBuffer.pipelineBarrier(srcStageMask: VkPipelineStageFlags, dstStageMask: VkPipelineStageFlags,
                                        dependencyFlags: VkDependencyFlags = 0,
                                        memoryBarrier: VkMemoryBarrier? = null,
                                        bufferMemoryBarrier: VkBufferMemoryBarrier? = null,
                                        imageMemoryBarrier: VkImageMemoryBarrier? = null) =
        VK10.nvkCmdPipelineBarrier(this, srcStageMask, dstStageMask, dependencyFlags,
            if (memoryBarrier != null) 1 else 0, memoryBarrier?.adr ?: NULL,
            if (bufferMemoryBarrier != null) 1 else 0, bufferMemoryBarrier?.adr ?: NULL,
            if (imageMemoryBarrier != null) 1 else 0, imageMemoryBarrier?.adr ?: NULL)

    fun VkCommandBuffer.pushConstants(layout: VkPipelineLayout, stageFlags: VkShaderStageFlags, offset: Int, values: FloatBuffer) = VK10.nvkCmdPushConstants(this, layout.L, stageFlags, offset, values.rem, memAddress(values))

    fun VkCommandBuffer.pushConstants(layout: VkPipelineLayout, stageFlags: VkShaderStageFlags, offset: Int, values: ByteBuffer) = VK10.nvkCmdPushConstants(this, layout.L, stageFlags, offset, values.rem, memAddress(values))

    /** begin .. end */
    inline fun <R> VkCommandBuffer.record(beginInfo: VkCommandBufferBeginInfo, block: VkCommandBuffer.() -> R): R {
        begin(beginInfo)
        return block().also { end() }
    }

    fun VkCommandBuffer.reset(flags: VkCommandBufferResetFlags) = VK_CHECK_RESULT(VK10.vkResetCommandBuffer(this, flags))

    fun VkCommandBuffer.setDepthBias(depthBiasConstantFactor: Float, depthBiasClamp: Float, depthBiasSlopeFactor: Float) = VK10.vkCmdSetDepthBias(this, depthBiasConstantFactor, depthBiasClamp, depthBiasSlopeFactor)

    infix fun VkCommandBuffer.setLineWidth(lineWidth: Float) = VK10.vkCmdSetLineWidth(this, lineWidth)

    infix fun VkCommandBuffer.setScissor(extend: Vec2i) = setScissor(Rect2D(0, 0, extend.x, extend.y))

    fun VkCommandBuffer.setScissor(offset: Vec2i, extend: Vec2i) = setScissor(Rect2D(offset, extend))

    infix fun VkCommandBuffer.setScissor(scissor: VkRect2D) = VK10.nvkCmdSetScissor(this, 0, 1, scissor.adr)

    infix fun VkCommandBuffer.setScissor(scissors: VkRect2D.Buffer) = VK10.nvkCmdSetScissor(this, 0, scissors.remaining(), scissors.adr)

    fun VkCommandBuffer.setScissor(firstScissor: Int, scissors: VkRect2D.Buffer) = VK10.nvkCmdSetScissor(this, firstScissor, scissors.remaining(), scissors.adr)

    infix fun VkCommandBuffer.setViewport(size: Vec2i) = setViewport(size, 0f, 1f)

    fun VkCommandBuffer.setViewport(size: Vec2i, minDepth: Float, maxDepth: Float) = setViewport(size.x.f, size.y.f, minDepth, maxDepth)

    fun VkCommandBuffer.setViewport(width: Float, height: Float, minDepth: Float = 0f, maxDepth: Float = 1f) = setViewport(Viewport(width, height, minDepth, maxDepth))

    infix fun VkCommandBuffer.setViewport(viewport: VkViewport) = VK10.nvkCmdSetViewport(this, 0, 1, viewport.adr)

    fun VkCommandBuffer.setViewport(firstViewport: Int, viewports: VkViewport.Buffer) = VK10.nvkCmdSetViewport(this, firstViewport, viewports.remaining(), viewports.adr)

    fun VkCommandBuffer.submit(queue: VkQueue, submitInfoPNext: Pointer? = null) {
        queue submit SubmitInfo {
            commandBuffer = this@submit
            submitInfoPNext?.let { next = it.adr }
        }
        queue.waitIdle()
    }

//inline fun VkCommandBuffer.use(block: ()) {
//    VK10.nvkCmdSetViewport(this, firstViewport, viewports.remaining(), viewports.adr)
//}
//inline fun VkCommandBuffer.setBlendConstants(depthBiasConstantFactor: Float, depthBiasClamp: Float, depthBiasSlopeFactor: Float) {
//    VK10.setBlendConstants(this, depthBiasConstantFactor, depthBiasClamp, depthBiasSlopeFactor)
//}


    // VkDevice ========================================================================================================

    fun VkDevice.acquireNextImageKHR(swapchain: VkSwapchainKHR, timeout: Long, semaphore: VkSemaphore, fence: VkFence = VkFence(NULL)): Int = intAddress { VK_CHECK_RESULT(KHRSwapchain.nvkAcquireNextImageKHR(this, swapchain.L, timeout, semaphore.L, fence.L, it)) }

    infix fun VkDevice.allocateCommandBuffer(allocateInfo: VkCommandBufferAllocateInfo): VkCommandBuffer = VkCommandBuffer(pointerAddress { VK_CHECK_RESULT(VK10.nvkAllocateCommandBuffers(this, allocateInfo.adr, it)) }, this)

    infix fun VkDevice.allocateCommandBuffers(allocateInfo: VkCommandBufferAllocateInfo): Array<VkCommandBuffer> = stack {
        val count = allocateInfo.commandBufferCount
        val pCommandBuffer = it.nmalloc(Pointer.POINTER_SIZE, count * Pointer.POINTER_SIZE)
        VK_CHECK_RESULT(VK10.nvkAllocateCommandBuffers(this, allocateInfo.adr, pCommandBuffer))
        Array(count) { i -> VkCommandBuffer(memGetAddress(pCommandBuffer + Pointer.POINTER_SIZE * i), this) }
    }

    infix fun VkDevice.allocateDescriptorSets(allocateInfo: VkDescriptorSetAllocateInfo): VkDescriptorSet = VkDescriptorSet(longAddress { VK_CHECK_RESULT(VK10.nvkAllocateDescriptorSets(this, allocateInfo.adr, it)) })

    infix fun VkDevice.allocateMemory(allocateInfo: VkMemoryAllocateInfo): VkDeviceMemory = VkDeviceMemory(longAddress { VK_CHECK_RESULT(VK10.nvkAllocateMemory(this, allocateInfo.adr, NULL, it)) })

    fun VkDevice.bindBufferMemory(buffer: VkBuffer, memory: VkDeviceMemory, memoryOffset: VkDeviceSize = VkDeviceSize(0)) = VK_CHECK_RESULT(VK10.vkBindBufferMemory(this, buffer.L, memory.L, memoryOffset.L))

    fun VkDevice.bindImageMemory(image: VkImage, memory: VkDeviceMemory, memoryOffset: VkDeviceSize = VkDeviceSize(0)) = VK_CHECK_RESULT(VK10.vkBindImageMemory(this, image.L, memory.L, memoryOffset.L))

    fun VkDevice.createBuffer(usage: VkBufferUsageFlags, size: VkDeviceSize): VkBuffer = createBuffer(BufferCreateInfo { this.usage = usage; this.size = size })

    infix fun VkDevice.createBuffer(createInfo: VkBufferCreateInfo): VkBuffer = VkBuffer(longAddress { VK_CHECK_RESULT(VK10.nvkCreateBuffer(this, createInfo.adr, NULL, it)) })

    infix fun VkDevice.createCommandPool(createInfo: VkCommandPoolCreateInfo): VkCommandPool = VkCommandPool(longAddress { VK_CHECK_RESULT(VK10.nvkCreateCommandPool(this, createInfo.adr, NULL, it)) })

    fun VkDevice.createComputePipelines(pipelineCache: VkPipelineCache, createInfo: VkComputePipelineCreateInfo): VkPipeline = VkPipeline(longAddress { VK_CHECK_RESULT(VK10.nvkCreateComputePipelines(this, pipelineCache.L, 1, createInfo.adr, NULL, it)) })

    infix fun VkDevice.createDescriptorPool(createInfo: VkDescriptorPoolCreateInfo): VkDescriptorPool = VkDescriptorPool(longAddress { VK_CHECK_RESULT(VK10.nvkCreateDescriptorPool(this, createInfo.adr, NULL, it)) })

    infix fun VkDevice.createDescriptorSetLayout(createInfo: VkDescriptorSetLayoutCreateInfo): VkDescriptorSetLayout = VkDescriptorSetLayout(longAddress { VK10.nvkCreateDescriptorSetLayout(this, createInfo.adr, NULL, it) })

    infix fun VkDevice.createFence(flag: VkFenceCreate): VkFence = createFence(FenceCreateInfo { flags = flag.i })

    infix fun VkDevice.createFence(flags: VkFenceCreateFlags): VkFence = createFence(FenceCreateInfo { this.flags = flags })

    infix fun VkDevice.createFence(createInfo: VkFenceCreateInfo): VkFence = VkFence(longAddress { VK_CHECK_RESULT(VK10.nvkCreateFence(this, createInfo.adr, NULL, it)) })

    infix fun VkDevice.createFramebuffer(createInfo: VkFramebufferCreateInfo): VkFramebuffer = VkFramebuffer(longAddress { VK_CHECK_RESULT(VK10.nvkCreateFramebuffer(this, createInfo.adr, NULL, it)) })

    fun VkDevice.createGraphicsPipelines(pipelineCache: VkPipelineCache, createInfo: VkGraphicsPipelineCreateInfo): VkPipeline = VkPipeline(longAddress { VK_CHECK_RESULT(VK10.nvkCreateGraphicsPipelines(this, pipelineCache.L, 1, createInfo.adr, NULL, it)) })

    infix fun VkDevice.createImage(createInfo: VkImageCreateInfo): VkImage = VkImage(longAddress { VK_CHECK_RESULT(VK10.nvkCreateImage(this, createInfo.adr, NULL, it)) })

    infix fun VkDevice.createImageView(createInfo: VkImageViewCreateInfo): VkImageView = VkImageView(longAddress { VK10.nvkCreateImageView(this, createInfo.adr, NULL, it) })

    fun VkDevice.createPipeline(pipelineCache: VkPipelineCache, createInfo: VkGraphicsPipelineCreateInfo): VkPipeline = VkPipeline(longAddress { VK_CHECK_RESULT(VK10.nvkCreateGraphicsPipelines(this, pipelineCache.L, 1, createInfo.adr, NULL, it)) })

    infix fun VkDevice.createPipelineCache(createInfo: VkPipelineCacheCreateInfo): VkPipelineCache = VkPipelineCache(longAddress { VK_CHECK_RESULT(VK10.nvkCreatePipelineCache(this, createInfo.adr, NULL, it)) })

    infix fun VkDevice.createPipelineLayout(createInfo: VkPipelineLayoutCreateInfo): VkPipelineLayout = VkPipelineLayout(longAddress { VK_CHECK_RESULT(VK10.nvkCreatePipelineLayout(this, createInfo.adr, NULL, it)) })

    fun VkDevice.createQueryPool(createInfo: VkQueryPoolCreateInfo): VkQueryPool = VkQueryPool(longAddress { VK_CHECK_RESULT(VK10.nvkCreateQueryPool(this, createInfo.adr, NULL, it)) })

    infix fun VkDevice.createRenderPass(createInfo: VkRenderPassCreateInfo): VkRenderPass = VkRenderPass(longAddress { VK_CHECK_RESULT(VK10.nvkCreateRenderPass(this, createInfo.adr, NULL, it)) })

    infix fun VkDevice.createSampler(createInfo: VkSamplerCreateInfo): VkSampler = VkSampler(longAddress { VK_CHECK_RESULT(VK10.nvkCreateSampler(this, createInfo.adr, NULL, it)) })

    infix fun VkDevice.createSemaphore(createInfo: VkSemaphoreCreateInfo): VkSemaphore = VkSemaphore(longAddress { VK_CHECK_RESULT(VK10.nvkCreateSemaphore(this, createInfo.adr, NULL, it)) })

    infix fun VkDevice.createShaderModule(createInfo: VkShaderModuleCreateInfo): VkShaderModule = VkShaderModule(longAddress { VK_CHECK_RESULT(VK10.nvkCreateShaderModule(this, createInfo.adr, NULL, it)) })

    infix fun VkDevice.createSwapchainKHR(createInfo: VkSwapchainCreateInfoKHR): VkSwapchainKHR = VkSwapchainKHR(longAddress { KHRSwapchain.nvkCreateSwapchainKHR(this, createInfo.adr, NULL, it) })

    infix fun VkDevice.debugMarkerSetObjectName(nameInfo: VkDebugMarkerObjectNameInfoEXT) = EXTDebugMarker.nvkDebugMarkerSetObjectNameEXT(this, nameInfo.adr)

    infix fun VkDevice.debugMarkerSetObjectTag(tagInfo: VkDebugMarkerObjectTagInfoEXT) = EXTDebugMarker.nvkDebugMarkerSetObjectTagEXT(this, tagInfo.adr)

    infix fun VkDevice.destroyBuffer(buffer: VkBuffer) = VK10.nvkDestroyBuffer(this, buffer.L, NULL)

    infix fun VkDevice.destroyCommandPool(commandPool: VkCommandPool) = VK10.nvkDestroyCommandPool(this, commandPool.L, NULL)

    infix fun VkDevice.destroyDescriptorPool(descriptorPool: VkDescriptorPool) = VK10.nvkDestroyDescriptorPool(this, descriptorPool.L, NULL)

    infix fun VkDevice.destroyDescriptorSetLayout(descriptorSetLayout: VkDescriptorSetLayout) = VK10.nvkDestroyDescriptorSetLayout(this, descriptorSetLayout.L, NULL)

    infix fun VkDevice.destroyFence(fence: VkFence) = VK10.nvkDestroyFence(this, fence.L, NULL)

    infix fun VkDevice.destroyFences(fences: Collection<VkFence>) {
        for (fence in fences)
            VK10.nvkDestroyFence(this, fence.L, NULL)
    }

    infix fun VkDevice.destroyFences(fences: VkFenceArray) {
        for (fence in fences)
            VK10.nvkDestroyFence(this, fence.L, NULL)
    }

    infix fun VkDevice.destroyFramebuffer(framebuffer: VkFramebuffer) = VK10.nvkDestroyFramebuffer(this, framebuffer.L, NULL)

    infix fun VkDevice.destroyFramebuffers(framebuffers: Collection<VkFramebuffer>) {
        for (i in framebuffers)
            VK10.nvkDestroyFramebuffer(this, i.L, NULL)
    }

    infix fun VkDevice.destroyImage(image: VkImage) = VK10.nvkDestroyImage(this, image.L, NULL)

    infix fun VkDevice.destroyImageView(imageView: VkImageView) = VK10.nvkDestroyImageView(this, imageView.L, NULL)

    infix fun VkDevice.destroyPipeline(pipeline: VkPipeline) = VK10.nvkDestroyPipeline(this, pipeline.L, NULL)

    infix fun VkDevice.destroyPipelineCache(pipelineCache: VkPipelineCache) = VK10.nvkDestroyPipelineCache(this, pipelineCache.L, NULL)

    infix fun VkDevice.destroyPipelineLayout(pipelineLayout: VkPipelineLayout) = VK10.nvkDestroyPipelineLayout(this, pipelineLayout.L, NULL)

    fun VkDevice.destroyQueryPool(queryPool: VkQueryPool) = VK10.nvkDestroyQueryPool(this, queryPool.L, NULL)

    infix fun VkDevice.destroyRenderPass(renderPass: VkRenderPass) = VK10.nvkDestroyRenderPass(this, renderPass.L, NULL)

    infix fun VkDevice.destroySampler(sampler: VkSampler) = VK10.nvkDestroySampler(this, sampler.L, NULL)

    infix fun VkDevice.destroySemaphore(semaphore: VkSemaphore) = VK10.nvkDestroySemaphore(this, semaphore.L, NULL)
    fun VkDevice.destroySemaphores(semaphore0: VkSemaphore, semaphore1: VkSemaphore) {
        VK10.nvkDestroySemaphore(this, semaphore0.L, NULL)
        VK10.nvkDestroySemaphore(this, semaphore1.L, NULL)
    }

    fun VkDevice.destroySemaphores(semaphore0: VkSemaphore, semaphore1: VkSemaphore, semaphore2: VkSemaphore) {
        VK10.nvkDestroySemaphore(this, semaphore0.L, NULL)
        VK10.nvkDestroySemaphore(this, semaphore1.L, NULL)
        VK10.nvkDestroySemaphore(this, semaphore2.L, NULL)
    }

    fun VkDevice.destroyShaderModules(shaderModules: Collection<VkShaderModule>) {
        for (i in shaderModules)
            VK10.nvkDestroyShaderModule(this, i.L, NULL)
    }

//inline fun VkDevice.destroySemaphores(vararg semaphores: VkSemaphore) {
//    for (semaphore in semaphores)
//        VK10.nvkDestroySemaphore(this, semaphore, NULL)
//}

    fun VkDevice.destroy() = VK10.nvkDestroyDevice(this, NULL)

    infix fun VkDevice.destroyShaderModule(shaderModule: VkShaderModule) = VK10.nvkDestroyShaderModule(this, shaderModule.L, NULL)

//    infix fun VkDevice.destroyShaderModules(infos: VkPipelineShaderStageCreateInfo.Buffer) {
//        for (i in infos)
//            VK10.nvkDestroyShaderModule(this, i.module.L, NULL)
//    }

    infix fun VkDevice.destroySwapchainKHR(swapchain: VkSwapchainKHR) = KHRSwapchain.nvkDestroySwapchainKHR(this, swapchain.L, NULL)

    fun VkDevice.freeCommandBuffers(commandPool: VkCommandPool, commandBuffers: Array<VkCommandBuffer>) = stack {
        val size = commandBuffers.size
        val pointers = it.nmalloc(Pointer.POINTER_SIZE, size * Pointer.POINTER_SIZE)
        for (i in 0 until size)
            memPutAddress(pointers + Pointer.POINTER_SIZE * i, commandBuffers.elementAt(i).adr)
        VK10.nvkFreeCommandBuffers(this, commandPool.L, size, pointers)
    }

    fun VkDevice.freeCommandBuffers(commandPool: VkCommandPool, commandBuffers: Collection<VkCommandBuffer>) = stack {
        val size = commandBuffers.size
        val pointers = it.nmalloc(Pointer.POINTER_SIZE, size * Pointer.POINTER_SIZE)
        for (i in 0 until size)
            memPutAddress(pointers + Pointer.POINTER_SIZE * i, commandBuffers.elementAt(i).adr)
        VK10.nvkFreeCommandBuffers(this, commandPool.L, size, pointers)
    }

    infix fun VkDevice.flushMappedMemoryRanges(memoryRange: VkMappedMemoryRange) = VK_CHECK_RESULT(VK10.nvkFlushMappedMemoryRanges(this, 1, memoryRange.adr))

    infix fun VkDevice.flushMappedMemoryRanges(memoryRanges: VkMappedMemoryRange.Buffer) = VK_CHECK_RESULT(VK10.nvkFlushMappedMemoryRanges(this, memoryRanges.capacity(), memoryRanges.adr))

    fun VkDevice.freeCommandBuffer(commandPool: VkCommandPool, commandBuffer: VkCommandBuffer) = pointerAddress(commandBuffer) { VK10.nvkFreeCommandBuffers(this, commandPool.L, 1, it) }

    infix fun VkDevice.freeMemory(memory: VkDeviceMemory) = VK10.nvkFreeMemory(this, memory.L, NULL)

    infix fun VkDevice.getBufferMemoryRequirements(buffer: VkBuffer): VkMemoryRequirements = getBufferMemoryRequirements(buffer, MemoryRequirements())

    fun VkDevice.getBufferMemoryRequirements(buffer: VkBuffer, memoryRequirements: VkMemoryRequirements): VkMemoryRequirements {
        VK10.nvkGetBufferMemoryRequirements(this, buffer.L, memoryRequirements.adr)
        return memoryRequirements
    }

    infix fun VkDevice.getCommandBuffer(commandPool: VkCommandPool): VkCommandBuffer = getCommandBuffer(commandPool, VkCommandBufferLevel.PRIMARY)

    fun VkDevice.getCommandBuffer(commandPool: VkCommandPool, level: VkCommandBufferLevel = VkCommandBufferLevel.PRIMARY, autostart: Boolean = false): VkCommandBuffer {
        val cmdBufAllocateInfo = CommandBufferAllocateInfo(commandPool, level, 1)
        return allocateCommandBuffer(cmdBufAllocateInfo).apply { if (autostart) begin() }
    }

    infix fun VkDevice.getImageMemoryRequirements(image: VkImage): VkMemoryRequirements = getImageMemoryRequirements(image, MemoryRequirements())

    fun VkDevice.getImageMemoryRequirements(image: VkImage, memoryRequirements: VkMemoryRequirements): VkMemoryRequirements = memoryRequirements.also { VK10.nvkGetImageMemoryRequirements(this, image.L, it.adr) }

    fun VkDevice.getImageSubresourceLayout(image: VkImage, subresource: VkImageSubresource): VkSubresourceLayout = SubresourceLayout().also { VK10.nvkGetImageSubresourceLayout(this, image.L, subresource.adr, it.adr) }

    fun VkDevice.getImageSubresourceLayout(image: VkImage, subresource: VkImageSubresource, layout: VkSubresourceLayout): VkSubresourceLayout = layout.also { VK10.nvkGetImageSubresourceLayout(this, image.L, subresource.adr, it.adr) }

    inline fun VkDevice.mappedMemory(memory: VkDeviceMemory, offset: VkDeviceSize, size: VkDeviceSize, flags: VkMemoryMapFlags = 0, block: (Ptr) -> Unit) = pointerAddress { data ->
        VK_CHECK_RESULT(VK10.nvkMapMemory(this, memory.L, offset.L, size.L, flags, data))
        block(memGetAddress(data))
        VK10.vkUnmapMemory(this, memory.L)
    }

    fun VkDevice.mapMemory(memory: VkDeviceMemory, offset: VkDeviceSize, size: VkDeviceSize, flags: VkMemoryMapFlags = 0): Ptr = pointerAddress { data -> VK_CHECK_RESULT(VK10.nvkMapMemory(this, memory.L, offset.L, size.L, flags, data)) }

    fun VkDevice.mapMemory(memory: VkDeviceMemory, offset: VkDeviceSize, size: VkDeviceSize, flags: VkMemoryMapFlags, data: PointerBuffer) = VK_CHECK_RESULT(VK10.nvkMapMemory(this, memory.L, offset.L, size.L, flags, data.adr))

    infix fun VkDevice.getQueue(queueFamilyIndex: Int): VkQueue = getQueue(queueFamilyIndex, 0)

    fun VkDevice.getQueue(queueFamilyIndex: Int, queueIndex: Int): VkQueue = VkQueue(pointerAddress { VK10.nvkGetDeviceQueue(this, queueFamilyIndex, queueIndex, it) }, this)

    infix fun VkDevice.getSwapchainImagesKHR(swapchain: VkSwapchainKHR): VkImageArray = stack {
        val pCount = it.nmalloc(1, Int.BYTES)
        VK_CHECK_RESULT(KHRSwapchain.nvkGetSwapchainImagesKHR(this, swapchain.L, pCount, NULL))
        val count = memGetInt(pCount)
        val images = it.nmalloc(Long.BYTES, count * Long.BYTES)
        VK_CHECK_RESULT(KHRSwapchain.nvkGetSwapchainImagesKHR(this, swapchain.L, pCount, images))
        VkImageArray(count) { i -> VkImage(memGetLong(images + Long.BYTES * i)) }
    }

    infix fun VkDevice.resetCommandPool(commandPool: VkCommandPool) = resetCommandPool(commandPool, 0)

    fun VkDevice.resetCommandPool(commandPool: VkCommandPool, flags: VkCommandPoolResetFlags) = VK_CHECK_RESULT(VK10.vkResetCommandPool(this, commandPool.L, flags))

    infix fun VkDevice.resetFence(fence: VkFence) = longAddress(fence.L) { VK10.nvkResetFences(this, 1, it) }

    infix fun VkDevice.unmapMemory(memory: VkDeviceMemory) = VK10.vkUnmapMemory(this, memory.L)

    infix fun VkDevice.updateDescriptorSets(descriptorWrites: VkWriteDescriptorSet) = VK10.nvkUpdateDescriptorSets(this, 1, descriptorWrites.adr, 0, NULL)

    infix fun VkDevice.updateDescriptorSets(descriptorWrites: VkWriteDescriptorSet.Buffer) = VK10.nvkUpdateDescriptorSets(this, descriptorWrites.remaining(), descriptorWrites.adr, 0, NULL)

//inline fun VkDevice.updateDescriptorSets(descriptorWrites: VkWriteDescriptorSet.Buffer,
//                                descriptorCopies: VkCopyDescriptorSet.Buffer? = null) {
//    VK10.nvkUpdateDescriptorSets(device, descriptorWrites.remaining(), descriptorWrites.adr,
//            descriptorCopies?.remaining() ?: 0, descriptorCopies?.adr ?: NULL)
//}

    fun VkDevice.waitForFence(fence: VkFence, waitAll: Boolean, timeout: Long) = longAddress(fence.L) { VK_CHECK_RESULT(VK10.nvkWaitForFences(this, 1, it, waitAll.i, timeout)) }

    fun VkDevice.waitIdle() = VK_CHECK_RESULT(VK10.vkDeviceWaitIdle(this))

    inline fun VkDevice.withFence(flags: VkFenceCreateFlags = 0, block: (VkFence) -> Unit) {
        val fence = createFence(flags)
        block(fence)
        destroyFence(fence)
    }


    // VkInstance ======================================================================================================

    infix fun VkInstance.createDebugReportCallbackEXT(createInfo: VkDebugReportCallbackCreateInfoEXT): VkDebugReportCallback = VkDebugReportCallback(longAddress { VK_CHECK_RESULT(EXTDebugReport.nvkCreateDebugReportCallbackEXT(this, createInfo.adr, NULL, it)) })

    fun VkInstance.destroy() = VK10.nvkDestroyInstance(this, NULL)

    infix fun VkInstance.destroyDebugReportCallbackEXT(debugReportCallback: VkDebugReportCallback) = EXTDebugReport.nvkDestroyDebugReportCallbackEXT(this, debugReportCallback.L, NULL)

    fun VkInstance.enumeratePhysicalDevices(): ArrayList<VkPhysicalDevice> = stack {
        val physicalDevices = ArrayList<VkPhysicalDevice>()
        val pPhysicalDeviceCount = it.nmalloc(1, Int.BYTES)
        var physicalDeviceCount: Int
        var result: VkResult
        do {
            result = VkResult(VK10.nvkEnumeratePhysicalDevices(this, pPhysicalDeviceCount, NULL))
            physicalDeviceCount = memGetInt(pPhysicalDeviceCount)
            if (result == SUCCESS && physicalDeviceCount > 0) {
                val pPhysicalDevices = it.nmalloc(Pointer.POINTER_SIZE, physicalDeviceCount * Pointer.POINTER_SIZE)
                result = VkResult(VK10.nvkEnumeratePhysicalDevices(this, pPhysicalDeviceCount, pPhysicalDevices))
                for (i in 0 until physicalDeviceCount)
                    physicalDevices += VkPhysicalDevice(memGetAddress(pPhysicalDevices), this)
            }
        } while (result == INCOMPLETE)
        assert(physicalDeviceCount == physicalDevices.size)
        physicalDevices
    }

    infix fun VkInstance.destroySurfaceKHR(surface: VkSurface) = KHRSurface.nvkDestroySurfaceKHR(this, surface.L, NULL)


    // VkPhysicalDevice ================================================================================================

    inline val VkPhysicalDevice.features: VkPhysicalDeviceFeatures
        get() = getFeatures(PhysicalDeviceFeatures())

    infix fun VkPhysicalDevice.getFeatures(features: VkPhysicalDeviceFeatures): VkPhysicalDeviceFeatures = features.also { VK10.nvkGetPhysicalDeviceFeatures(this, it.adr) }

    infix fun VkPhysicalDevice.getFormatProperties(format: VkFormat): VkFormatProperties = getFormatProperties(format, FormatProperties())

    fun VkPhysicalDevice.getFormatProperties(format: VkFormat, formatProperties: VkFormatProperties): VkFormatProperties = formatProperties.also { VK10.nvkGetPhysicalDeviceFormatProperties(this, format.i, it.adr) }

    infix fun VkPhysicalDevice.getSurfaceFormatsKHR(surface: VkSurface): ArrayList<VkSurfaceFormatKHR> = getPhysicalDeviceSurfaceFormatsKHR(this, surface)

    inline val VkPhysicalDevice.memoryProperties: VkPhysicalDeviceMemoryProperties
        get() = getMemoryProperties(PhysicalDeviceMemoryProperties())

    infix fun VkPhysicalDevice.getMemoryProperties(memoryProperties: VkPhysicalDeviceMemoryProperties) = memoryProperties.also { VK10.nvkGetPhysicalDeviceMemoryProperties(this, it.adr) }

    inline val VkPhysicalDevice.queueFamilyProperties: ArrayList<VkQueueFamilyProperties>
        get() = getPhysicalDeviceQueueFamilyProperties(this)

    inline val VkPhysicalDevice.properties: VkPhysicalDeviceProperties
        get() = getProperties(PhysicalDeviceProperties())

    infix fun VkPhysicalDevice.getProperties(properties: VkPhysicalDeviceProperties) = properties.also { VK10.nvkGetPhysicalDeviceProperties(this, it.adr) }

    infix fun VkPhysicalDevice.createDevice(createInfo: VkDeviceCreateInfo): VkDevice = VkDevice(pointerAddress { VK_CHECK_RESULT(VK10.nvkCreateDevice(this, createInfo.adr, NULL, it)) }, this, createInfo)

    infix fun VkPhysicalDevice.getSurfaceCapabilitiesKHR(surface: VkSurface): VkSurfaceCapabilitiesKHR = SurfaceCapabilitiesKHR { VK_CHECK_RESULT(KHRSurface.nvkGetPhysicalDeviceSurfaceCapabilitiesKHR(this@getSurfaceCapabilitiesKHR, surface.L, adr)) }

    fun VkPhysicalDevice.getSurfaceSupportKHR(queueFamily: Int, surface: VkSurface): Boolean = getPhysicalDeviceSurfaceSupportKHR(this, queueFamily, surface)

    fun VkPhysicalDevice.getSurfaceSupportKHR(queueFamilyProperties: ArrayList<VkQueueFamilyProperties>, surface: VkSurface): BooleanArray = getPhysicalDeviceSurfaceSupportKHR(this, queueFamilyProperties, surface)

    infix fun VkPhysicalDevice.getSurfacePresentModesKHR(surface: VkSurface): ArrayList<VkPresentMode> = getPhysicalDeviceSurfacePresentModesKHR(this, surface)


    // VkQueue =========================================================================================================

    infix fun VkQueue.presentKHR(presentInfo: VkPresentInfoKHR) = VK_CHECK_RESULT(KHRSwapchain.vkQueuePresentKHR(this, presentInfo))

    infix fun VkQueue.submit(submits: VkSubmitInfo) = VK_CHECK_RESULT(VK10.nvkQueueSubmit(this, 1, submits.adr, NULL))

    fun VkQueue.submit(submits: VkSubmitInfo, fence: VkFence) = VK_CHECK_RESULT(VK10.nvkQueueSubmit(this, 1, submits.adr, fence.L))

    fun VkQueue.waitIdle() = VK_CHECK_RESULT(VK10.vkQueueWaitIdle(this))


    // kool, stak ======================================================================================================

    // getters

    inline fun <R> byteAddress(block: (Adr) -> R): Byte = stack {
        val adr = it.nmalloc(1, 1)
        block(adr)
        memGetByte(adr)
    }

    inline fun <R> byteBuffer(block: (ByteBuffer) -> R): Byte = stack {
        val buf = memByteBuffer(it.nmalloc(1, 1), 1)
        block(buf)
        buf[0]
    }

    inline fun <R> shortAddress(block: (Adr) -> R): Short = stack {
        val adr = it.nmalloc(1, 2)
        block(adr)
        MemoryUtil.memGetShort(adr)
    }

    inline fun <R> shortBuffer(block: (ShortBuffer) -> R): Short = stack {
        val buf = MemoryUtil.memShortBuffer(it.nmalloc(1, 2), 1)
        block(buf)
        buf[0]
    }

    inline fun <R> intAddress(block: (Adr) -> R): Int = stack {
        val adr = it.nmalloc(1, 4)
        block(adr)
        MemoryUtil.memGetInt(adr)
    }

    inline fun <R> intBuffer(block: (IntBuffer) -> R): Int = stack {
        val buf = MemoryUtil.memIntBuffer(it.nmalloc(1, 4), 1)
        block(buf)
        buf[0]
    }

    inline fun <R> longAddress(block: (Adr) -> R): Long = stack {
        val adr = it.nmalloc(1, 8)
        block(adr)
        MemoryUtil.memGetLong(adr)
    }

    inline fun <R> longBuffer(block: (LongBuffer) -> R): Long = stack {
        val buf = MemoryUtil.memLongBuffer(it.nmalloc(1, 8), 1)
        block(buf)
        buf[0]
    }

    inline fun <R> floatAddress(block: (Adr) -> R): Float = stack {
        val adr = it.nmalloc(1, 4)
        block(adr)
        MemoryUtil.memGetFloat(adr)
    }

    inline fun <R> floatBuffer(block: (FloatBuffer) -> R): Float = stack {
        val buf = MemoryUtil.memFloatBuffer(it.nmalloc(1, 4), 1)
        block(buf)
        buf[0]
    }

    inline fun <R> doubleAddress(block: (Adr) -> R): Double = stack {
        val adr = it.nmalloc(1, 8)
        block(adr)
        MemoryUtil.memGetDouble(adr)
    }

    inline fun <R> doubleBuffer(block: (DoubleBuffer) -> R): Double = stack {
        val buf = MemoryUtil.memDoubleBuffer(it.nmalloc(1, 8), 1)
        block(buf)
        buf[0]
    }

    inline fun <R> pointerAddress(block: (Adr) -> R): Ptr = stack {
        val adr = it.nmalloc(Pointer.POINTER_SIZE, Pointer.POINTER_SIZE)
        block(adr)
        MemoryUtil.memGetAddress(adr)
    }

    inline fun <R> pointerBuffer(block: (PointerBuffer) -> R): Ptr = stack {
        val buf = MemoryUtil.memPointerBuffer(it.nmalloc(Pointer.POINTER_SIZE, Pointer.POINTER_SIZE), 1)
        block(buf)
        buf[0]
    }


    // setters

    inline fun <R> byteAddress(byte: Byte, block: (Ptr) -> R): R = stack {
        val adr = it.nmalloc(1, 1)
        MemoryUtil.memPutByte(adr, byte)
        block(adr)
    }

    inline fun <R> byteBuffer(byte: Byte, block: (ByteBuffer) -> R): R = stack {
        val buf = MemoryUtil.memByteBuffer(it.nmalloc(1, 1), 1)
        buf.put(0, byte)
        block(buf)
    }

    inline fun <R> shortAddress(short: Short, block: (Ptr) -> R): R = stack {
        val adr = it.nmalloc(1, 2)
        MemoryUtil.memPutShort(adr, short)
        block(adr)
    }

    inline fun <R> shortBuffer(short: Short, block: (ShortBuffer) -> R): R = stack {
        val buf = MemoryUtil.memShortBuffer(it.nmalloc(1, 2), 1)
        buf.put(0, short)
        block(buf)
    }

    inline fun <R> intAddress(int: Int, block: (Ptr) -> R): R = stack {
        val adr = it.nmalloc(1, 4)
        MemoryUtil.memPutInt(adr, int)
        block(adr)
    }

    inline fun <R> intBuffer(int: Int, block: (IntBuffer) -> R): R = stack {
        val buf = MemoryUtil.memIntBuffer(it.nmalloc(1, 4), 1)
        buf.put(0, int)
        block(buf)
    }

    inline fun <R> longAddress(long: Long, block: (Ptr) -> R): R = stack {
        val adr = it.nmalloc(1, 8)
        MemoryUtil.memPutLong(adr, long)
        block(adr)
    }

    inline fun <R> longBuffer(long: Long, block: (LongBuffer) -> R): R = stack {
        val buf = MemoryUtil.memLongBuffer(it.nmalloc(1, 8), 1)
        buf.put(0, long)
        block(buf)
    }

    inline fun <R> pointerAddress(pointer: Pointer, block: (Ptr) -> R): R = stack {
        val adr = it.nmalloc(Pointer.POINTER_SIZE, Pointer.POINTER_SIZE)
        MemoryUtil.memPutAddress(adr, pointer.address())
        block(adr)
    }

    inline fun <R> pointerBuffer(pointer: Pointer, block: (PointerBuffer) -> R): R = stack {
        val buf = MemoryUtil.memPointerBuffer(it.nmalloc(Pointer.POINTER_SIZE, Pointer.POINTER_SIZE), 1)
        buf.put(0, pointer)
        block(buf)
    }

    inline operator fun <R> MemoryStack.invoke(block: (MemoryStack) -> R): R {
        val ptr = pointer
        return block(this).also {
            pointer = ptr
        }
    }
}

//val MemoryStack.vk: VkMemoryStack
//    get() = VkMemoryStack(this)
//
//val VkMemoryStack.vk: VkMemoryStack
//    get() = this

//fun <R> vkStak(block: (VkMemoryStack) -> R): R {
//    val stack = MemoryStack.stackGet()
//    val ptr = stack.pointer
//    return block(VkMemoryStack(stack)).also {
//        stack.pointer = ptr
//    }
//}
