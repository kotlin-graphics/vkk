package vkk

import glm_.*
import glm_.vec2.Vec2i
import kool.adr
import kool.set
import kool.stak
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.system.Pointer
import org.lwjgl.system.Struct
import org.lwjgl.vulkan.*
import vkk.entities.*
import java.nio.ByteBuffer
import java.nio.LongBuffer
import kotlin.reflect.KMutableProperty0


object vk {

    // type constructors ===============================================================================================

    fun ApplicationInfo(): VkApplicationInfo = VkApplicationInfo.callocStack().apply { type = VkStructureType.APPLICATION_INFO }
    inline fun ApplicationInfo(block: VkApplicationInfo.() -> Unit): VkApplicationInfo = ApplicationInfo().also(block)

    fun BufferCreateInfo(): VkBufferCreateInfo = VkBufferCreateInfo.callocStack().apply { type = VkStructureType.BUFFER_CREATE_INFO }
    inline fun BufferCreateInfo(block: VkBufferCreateInfo.() -> Unit): VkBufferCreateInfo = BufferCreateInfo().also(block)

    fun BufferMemoryBarrier(): VkBufferMemoryBarrier = VkBufferMemoryBarrier.callocStack().apply { type = VkStructureType.BUFFER_MEMORY_BARRIER }
    inline fun BufferMemoryBarrier(block: VkBufferMemoryBarrier.() -> Unit): VkBufferMemoryBarrier = BufferMemoryBarrier().also(block)

    fun CommandBufferAllocateInfo(): VkCommandBufferAllocateInfo = VkCommandBufferAllocateInfo.callocStack().apply { type = VkStructureType.COMMAND_BUFFER_ALLOCATE_INFO }
    inline fun CommandBufferAllocateInfo(block: VkCommandBufferAllocateInfo.() -> Unit): VkCommandBufferAllocateInfo = CommandBufferAllocateInfo().also(block)

    fun CommandBufferBeginInfo(): VkCommandBufferBeginInfo = VkCommandBufferBeginInfo.callocStack().apply { type = VkStructureType.COMMAND_BUFFER_BEGIN_INFO }
    inline fun CommandBufferBeginInfo(block: VkCommandBufferBeginInfo.() -> Unit): VkCommandBufferBeginInfo = CommandBufferBeginInfo().also(block)

    fun CommandBufferInheritanceInfo(): VkCommandBufferInheritanceInfo = VkCommandBufferInheritanceInfo.callocStack().apply { type = VkStructureType.COMMAND_BUFFER_INHERITANCE_INFO }
    inline fun CommandBufferInheritanceInfo(block: VkCommandBufferInheritanceInfo.() -> Unit): VkCommandBufferInheritanceInfo = CommandBufferInheritanceInfo().also(block)

    fun CommandPoolCreateInfo(): VkCommandPoolCreateInfo = VkCommandPoolCreateInfo.callocStack().apply { type = VkStructureType.COMMAND_POOL_CREATE_INFO }
    inline fun CommandPoolCreateInfo(block: VkCommandPoolCreateInfo.() -> Unit): VkCommandPoolCreateInfo = CommandPoolCreateInfo().also(block)

    fun ComputePipelineCreateInfo(): VkComputePipelineCreateInfo = VkComputePipelineCreateInfo.callocStack().apply { type = VkStructureType.COMPUTE_PIPELINE_CREATE_INFO }
    inline fun ComputePipelineCreateInfo(block: VkComputePipelineCreateInfo.() -> Unit): VkComputePipelineCreateInfo = ComputePipelineCreateInfo().also(block)

    fun DebugMarkerMarkerInfoEXT(): VkDebugMarkerMarkerInfoEXT = VkDebugMarkerMarkerInfoEXT.callocStack().apply { type = VkStructureType.DEBUG_MARKER_OBJECT_NAME_INFO_EXT }
    inline fun DebugMarkerMarkerInfoEXT(block: VkDebugMarkerMarkerInfoEXT.() -> Unit): VkDebugMarkerMarkerInfoEXT = DebugMarkerMarkerInfoEXT().also(block)

    fun DebugMarkerObjectNameInfoEXT(): VkDebugMarkerObjectNameInfoEXT = VkDebugMarkerObjectNameInfoEXT.callocStack().apply { type = VkStructureType.DEBUG_MARKER_OBJECT_NAME_INFO_EXT }
    inline fun DebugMarkerObjectNameInfoEXT(block: VkDebugMarkerObjectNameInfoEXT.() -> Unit): VkDebugMarkerObjectNameInfoEXT = DebugMarkerObjectNameInfoEXT().also(block)

    fun DebugMarkerObjectTagInfoEXT(): VkDebugMarkerObjectTagInfoEXT = VkDebugMarkerObjectTagInfoEXT.callocStack().apply { type = VkStructureType.DEBUG_MARKER_OBJECT_TAG_INFO_EXT }
    inline fun DebugMarkerObjectTagInfoEXT(block: VkDebugMarkerObjectTagInfoEXT .() -> Unit): VkDebugMarkerObjectTagInfoEXT = DebugMarkerObjectTagInfoEXT().also(block)

    fun DebugReportCallbackCreateInfoEXT(): VkDebugReportCallbackCreateInfoEXT = VkDebugReportCallbackCreateInfoEXT.callocStack().apply { type = VkStructureType.DEBUG_REPORT_CALLBACK_CREATE_INFO_EXT }
    inline fun DebugReportCallbackCreateInfoEXT(block: VkDebugReportCallbackCreateInfoEXT.() -> Unit): VkDebugReportCallbackCreateInfoEXT = DebugReportCallbackCreateInfoEXT().also(block)

    fun DescriptorPoolCreateInfo(): VkDescriptorPoolCreateInfo = VkDescriptorPoolCreateInfo.callocStack().apply { type = VkStructureType.DESCRIPTOR_POOL_CREATE_INFO }
    inline fun DescriptorPoolCreateInfo(block: VkDescriptorPoolCreateInfo.() -> Unit): VkDescriptorPoolCreateInfo = DescriptorPoolCreateInfo().also(block)

    fun DescriptorSetAllocateInfo(): VkDescriptorSetAllocateInfo = VkDescriptorSetAllocateInfo.callocStack().apply { type = VkStructureType.DESCRIPTOR_SET_ALLOCATE_INFO }
    inline fun DescriptorSetAllocateInfo(block: VkDescriptorSetAllocateInfo.() -> Unit): VkDescriptorSetAllocateInfo = DescriptorSetAllocateInfo().also(block)

    fun DescriptorSetLayoutCreateInfo(): VkDescriptorSetLayoutCreateInfo = VkDescriptorSetLayoutCreateInfo.callocStack().apply { type = VkStructureType.DESCRIPTOR_SET_LAYOUT_CREATE_INFO }
    inline fun DescriptorSetLayoutCreateInfo(block: VkDescriptorSetLayoutCreateInfo.() -> Unit): VkDescriptorSetLayoutCreateInfo = DescriptorSetLayoutCreateInfo().also(block)

    fun DescriptorSetLayoutSupport(): VkDescriptorSetLayoutSupport = VkDescriptorSetLayoutSupport.callocStack().apply { type = VkStructureType.DESCRIPTOR_SET_LAYOUT_SUPPORT }
    fun DescriptorSetLayoutSupport(capacity: Int): VkDescriptorSetLayoutSupport.Buffer = VkDescriptorSetLayoutSupport.callocStack(capacity).onEach { it.type = VkStructureType.DESCRIPTOR_SET_LAYOUT_SUPPORT }

    fun DeviceCreateInfo(): VkDeviceCreateInfo = VkDeviceCreateInfo.callocStack().apply { type = VkStructureType.DEVICE_CREATE_INFO }
    inline fun DeviceCreateInfo(block: VkDeviceCreateInfo.() -> Unit): VkDeviceCreateInfo = DeviceCreateInfo().also(block)

    fun DeviceGroupPresentCapabilitiesKHR(): VkDeviceGroupPresentCapabilitiesKHR = VkDeviceGroupPresentCapabilitiesKHR.callocStack().apply { type = VkStructureType.DEVICE_GROUP_PRESENT_CAPABILITIES_KHR }
    inline fun DeviceGroupPresentCapabilitiesKHR(block: VkDeviceGroupPresentCapabilitiesKHR.() -> Unit): VkDeviceGroupPresentCapabilitiesKHR = DeviceGroupPresentCapabilitiesKHR().also(block)

    fun DeviceGeneratedCommandsLimitsNVX(): VkDeviceGeneratedCommandsLimitsNVX = VkDeviceGeneratedCommandsLimitsNVX.callocStack().apply { type = VkStructureType.DEVICE_GENERATED_COMMANDS_LIMITS_NVX }
    inline fun DeviceGeneratedCommandsLimitsNVX(block: VkDeviceGeneratedCommandsLimitsNVX.() -> Unit): VkDeviceGeneratedCommandsLimitsNVX = DeviceGeneratedCommandsLimitsNVX().also(block)

    fun DeviceQueueCreateInfo(): VkDeviceQueueCreateInfo = VkDeviceQueueCreateInfo.callocStack().apply { type = VkStructureType.DEVICE_QUEUE_CREATE_INFO }
    inline fun DeviceQueueCreateInfo(block: VkDeviceQueueCreateInfo.() -> Unit): VkDeviceQueueCreateInfo = DeviceQueueCreateInfo().also(block)
    fun DeviceQueueCreateInfo(capacity: Int): VkDeviceQueueCreateInfo.Buffer = VkDeviceQueueCreateInfo.callocStack(capacity).onEach { it.type = VkStructureType.DEVICE_QUEUE_CREATE_INFO }

    fun DisplayPlaneProperties2KHR(): VkDisplayPlaneProperties2KHR = VkDisplayPlaneProperties2KHR.callocStack().apply { type = VkStructureType.DISPLAY_PLANE_PROPERTIES_2_KHR }
    fun DisplayPlaneProperties2KHR(capacity: Int): VkDisplayPlaneProperties2KHR.Buffer = VkDisplayPlaneProperties2KHR.callocStack(capacity).onEach { it.type = VkStructureType.DISPLAY_PLANE_PROPERTIES_2_KHR }

    fun ExternalBufferProperties (): VkExternalBufferProperties  = VkExternalBufferProperties .callocStack().apply { type = VkStructureType.EXTERNAL_BUFFER_PROPERTIES }
    fun ExternalBufferProperties (capacity: Int): VkExternalBufferProperties .Buffer = VkExternalBufferProperties .callocStack(capacity).onEach { it.type = VkStructureType.EXTERNAL_BUFFER_PROPERTIES }

    fun ExternalFenceProperties (): VkExternalFenceProperties  = VkExternalFenceProperties .callocStack().apply { type = VkStructureType.EXTERNAL_FENCE_PROPERTIES }
    fun ExternalFenceProperties (capacity: Int): VkExternalFenceProperties .Buffer = VkExternalFenceProperties .callocStack(capacity).onEach { it.type = VkStructureType.EXTERNAL_FENCE_PROPERTIES }

    fun ExternalSemaphoreProperties (): VkExternalSemaphoreProperties  = VkExternalSemaphoreProperties .callocStack().apply { type = VkStructureType.EXTERNAL_SEMAPHORE_PROPERTIES }
    fun ExternalSemaphoreProperties (capacity: Int): VkExternalSemaphoreProperties .Buffer = VkExternalSemaphoreProperties .callocStack(capacity).onEach { it.type = VkStructureType.EXTERNAL_SEMAPHORE_PROPERTIES }

    fun FenceCreateInfo(): VkFenceCreateInfo = VkFenceCreateInfo.callocStack().apply { type = VkStructureType.FENCE_CREATE_INFO }
    inline fun FenceCreateInfo(block: VkFenceCreateInfo.() -> Unit): VkFenceCreateInfo = FenceCreateInfo().also(block)

    fun FramebufferCreateInfo(): VkFramebufferCreateInfo = VkFramebufferCreateInfo.callocStack().apply { type = VkStructureType.FRAMEBUFFER_CREATE_INFO }
    inline fun FramebufferCreateInfo(block: VkFramebufferCreateInfo.() -> Unit): VkFramebufferCreateInfo = FramebufferCreateInfo().also(block)

    fun GraphicsPipelineCreateInfo(): VkGraphicsPipelineCreateInfo = VkGraphicsPipelineCreateInfo.callocStack().apply { type = VkStructureType.GRAPHICS_PIPELINE_CREATE_INFO }
    inline fun GraphicsPipelineCreateInfo(block: VkGraphicsPipelineCreateInfo.() -> Unit): VkGraphicsPipelineCreateInfo = GraphicsPipelineCreateInfo().also(block)

    fun ImageCreateInfo(): VkImageCreateInfo = VkImageCreateInfo.callocStack().apply { type = VkStructureType.IMAGE_CREATE_INFO }
    inline fun ImageCreateInfo(block: VkImageCreateInfo.() -> Unit): VkImageCreateInfo = ImageCreateInfo().also(block)

    fun ImageMemoryBarrier(): VkImageMemoryBarrier = VkImageMemoryBarrier.callocStack().apply {
        type = VkStructureType.IMAGE_MEMORY_BARRIER
        srcQueueFamilyIndex = VK10.VK_QUEUE_FAMILY_IGNORED
        dstQueueFamilyIndex = VK10.VK_QUEUE_FAMILY_IGNORED
    }

    inline fun ImageMemoryBarrier(block: VkImageMemoryBarrier.() -> Unit): VkImageMemoryBarrier = ImageMemoryBarrier().also(block)

    fun ImageDrmFormatModifierPropertiesEXT(): VkImageDrmFormatModifierPropertiesEXT = VkImageDrmFormatModifierPropertiesEXT.callocStack().apply { type = VkStructureType.IMAGE_DRM_FORMAT_MODIFIER_PROPERTIES_EXT }
    inline fun ImageDrmFormatModifierPropertiesEXT(block: VkImageDrmFormatModifierPropertiesEXT.() -> Unit): VkImageDrmFormatModifierPropertiesEXT = ImageDrmFormatModifierPropertiesEXT().also(block)

    fun ImageViewCreateInfo(): VkImageViewCreateInfo = VkImageViewCreateInfo.callocStack().apply { type = VkStructureType.IMAGE_VIEW_CREATE_INFO }
    inline fun ImageViewCreateInfo(block: VkImageViewCreateInfo.() -> Unit): VkImageViewCreateInfo = ImageViewCreateInfo().also(block)

    fun InstanceCreateInfo(): VkInstanceCreateInfo = VkInstanceCreateInfo.callocStack().apply { type = VkStructureType.INSTANCE_CREATE_INFO }
    inline fun InstanceCreateInfo(block: VkInstanceCreateInfo.() -> Unit): VkInstanceCreateInfo = InstanceCreateInfo().also(block)

    fun MappedMemoryRange(): VkMappedMemoryRange = VkMappedMemoryRange.callocStack().apply { type = VkStructureType.MAPPED_MEMORY_RANGE }
    inline fun MappedMemoryRange(block: VkMappedMemoryRange.() -> Unit): VkMappedMemoryRange = MappedMemoryRange().also(block)

    // TODO check
    fun MappedMemoryRange(capacity: Int): VkMappedMemoryRange.Buffer = VkMappedMemoryRange.callocStack(capacity).onEach { it.type = VkStructureType.MAPPED_MEMORY_RANGE }

    fun MemoryAllocateInfo(): VkMemoryAllocateInfo = VkMemoryAllocateInfo.callocStack().apply { type = VkStructureType.MEMORY_ALLOCATE_INFO }
    inline fun MemoryAllocateInfo(block: VkMemoryAllocateInfo.() -> Unit): VkMemoryAllocateInfo = MemoryAllocateInfo().also(block)

    fun MemoryFdPropertiesKHR(): VkMemoryFdPropertiesKHR = VkMemoryFdPropertiesKHR.callocStack().apply { type = VkStructureType.MEMORY_FD_PROPERTIES_KHR }
    inline fun MemoryFdPropertiesKHR(block: VkMemoryFdPropertiesKHR.() -> Unit): VkMemoryFdPropertiesKHR = MemoryFdPropertiesKHR().also(block)

    fun MemoryHostPointerPropertiesEXT(): VkMemoryHostPointerPropertiesEXT = VkMemoryHostPointerPropertiesEXT.callocStack().apply { type = VkStructureType.MEMORY_HOST_POINTER_PROPERTIES_EXT }
    inline fun MemoryHostPointerPropertiesEXT(block: VkMemoryHostPointerPropertiesEXT.() -> Unit): VkMemoryHostPointerPropertiesEXT = MemoryHostPointerPropertiesEXT().also(block)

    fun MemoryWin32HandlePropertiesKHR(): VkMemoryWin32HandlePropertiesKHR = VkMemoryWin32HandlePropertiesKHR.callocStack().apply { type = VkStructureType.MEMORY_HOST_POINTER_PROPERTIES_EXT }
    inline fun MemoryWin32HandlePropertiesKHR(block: VkMemoryWin32HandlePropertiesKHR.() -> Unit): VkMemoryWin32HandlePropertiesKHR = MemoryWin32HandlePropertiesKHR().also(block)

    fun MultisamplePropertiesEXT(): VkMultisamplePropertiesEXT = VkMultisamplePropertiesEXT.callocStack().apply { type = VkStructureType.MULTISAMPLE_PROPERTIES_EXT }
    inline fun MultisamplePropertiesEXT(block: VkMultisamplePropertiesEXT.() -> Unit): VkMultisamplePropertiesEXT = MultisamplePropertiesEXT().also(block)

    fun PhysicalDeviceFeatures(): VkPhysicalDeviceFeatures = VkPhysicalDeviceFeatures.callocStack()
    inline fun PhysicalDeviceFeatures(block: VkPhysicalDeviceFeatures.() -> Unit): VkPhysicalDeviceFeatures = PhysicalDeviceFeatures().also(block)

    fun PhysicalDeviceFeatures2(): VkPhysicalDeviceFeatures2 = VkPhysicalDeviceFeatures2.callocStack()
    inline fun PhysicalDeviceFeatures2(block: VkPhysicalDeviceFeatures2.() -> Unit): VkPhysicalDeviceFeatures2 = PhysicalDeviceFeatures2().also(block)

    fun PhysicalDeviceMemoryProperties(): VkPhysicalDeviceMemoryProperties = VkPhysicalDeviceMemoryProperties.callocStack()
    fun PhysicalDeviceMemoryProperties(block: VkPhysicalDeviceMemoryProperties.() -> Unit): VkPhysicalDeviceMemoryProperties = PhysicalDeviceMemoryProperties().also(block)

    fun PhysicalDeviceMemoryProperties2(): VkPhysicalDeviceMemoryProperties2 = VkPhysicalDeviceMemoryProperties2.callocStack().apply { type = VkStructureType.PHYSICAL_DEVICE_MEMORY_PROPERTIES_2 }
    fun PhysicalDeviceMemoryProperties2(block: VkPhysicalDeviceMemoryProperties2.() -> Unit): VkPhysicalDeviceMemoryProperties2 = PhysicalDeviceMemoryProperties2().also(block)

    fun PhysicalDeviceProperties(): VkPhysicalDeviceProperties = VkPhysicalDeviceProperties.callocStack()
    fun PhysicalDeviceProperties(block: VkPhysicalDeviceProperties.() -> Unit): VkPhysicalDeviceProperties = PhysicalDeviceProperties().also(block)

    fun PhysicalDeviceProperties2(): VkPhysicalDeviceProperties2 = VkPhysicalDeviceProperties2.callocStack().apply { type = VkStructureType.PHYSICAL_DEVICE_PROPERTIES_2 }
    fun PhysicalDeviceProperties2(block: VkPhysicalDeviceProperties2.() -> Unit): VkPhysicalDeviceProperties2 = PhysicalDeviceProperties2().also(block)

    fun PipelineCacheCreateInfo(): VkPipelineCacheCreateInfo = VkPipelineCacheCreateInfo.callocStack().apply { type = VkStructureType.PIPELINE_CACHE_CREATE_INFO }
    inline fun PipelineCacheCreateInfo(block: VkPipelineCacheCreateInfo.() -> Unit): VkPipelineCacheCreateInfo = PipelineCacheCreateInfo().also(block)

    fun PipelineColorBlendStateCreateInfo(): VkPipelineColorBlendStateCreateInfo = VkPipelineColorBlendStateCreateInfo.callocStack().apply { type = VkStructureType.PIPELINE_COLOR_BLEND_STATE_CREATE_INFO }
    inline fun PipelineColorBlendStateCreateInfo(block: VkPipelineColorBlendStateCreateInfo.() -> Unit): VkPipelineColorBlendStateCreateInfo = PipelineColorBlendStateCreateInfo().also(block)

    fun PipelineDepthStencilStateCreateInfo(): VkPipelineDepthStencilStateCreateInfo = VkPipelineDepthStencilStateCreateInfo.callocStack().apply { type = VkStructureType.PIPELINE_DEPTH_STENCIL_STATE_CREATE_INFO }
    inline fun PipelineDepthStencilStateCreateInfo(block: VkPipelineDepthStencilStateCreateInfo.() -> Unit): VkPipelineDepthStencilStateCreateInfo = PipelineDepthStencilStateCreateInfo().also(block)

    fun PipelineDynamicStateCreateInfo(): VkPipelineDynamicStateCreateInfo = VkPipelineDynamicStateCreateInfo.callocStack().apply { type = VkStructureType.PIPELINE_DYNAMIC_STATE_CREATE_INFO }
    inline fun PipelineDynamicStateCreateInfo(block: VkPipelineDynamicStateCreateInfo.() -> Unit): VkPipelineDynamicStateCreateInfo = PipelineDynamicStateCreateInfo().also(block)

    fun PipelineInputAssemblyStateCreateInfo(): VkPipelineInputAssemblyStateCreateInfo = VkPipelineInputAssemblyStateCreateInfo.callocStack().apply { type = VkStructureType.PIPELINE_INPUT_ASSEMBLY_STATE_CREATE_INFO }
    inline fun PipelineInputAssemblyStateCreateInfo(block: VkPipelineInputAssemblyStateCreateInfo.() -> Unit): VkPipelineInputAssemblyStateCreateInfo = PipelineInputAssemblyStateCreateInfo().also(block)

    fun PipelineLayoutCreateInfo(): VkPipelineLayoutCreateInfo = VkPipelineLayoutCreateInfo.callocStack().apply { type = VkStructureType.PIPELINE_LAYOUT_CREATE_INFO }
    inline fun PipelineLayoutCreateInfo(block: VkPipelineLayoutCreateInfo.() -> Unit): VkPipelineLayoutCreateInfo = PipelineLayoutCreateInfo().also(block)

    fun PipelineMultisampleStateCreateInfo(): VkPipelineMultisampleStateCreateInfo = VkPipelineMultisampleStateCreateInfo.callocStack().apply { type = VkStructureType.PIPELINE_MULTISAMPLE_STATE_CREATE_INFO }
    inline fun PipelineMultisampleStateCreateInfo(block: VkPipelineMultisampleStateCreateInfo.() -> Unit): VkPipelineMultisampleStateCreateInfo = PipelineMultisampleStateCreateInfo().also(block)

    fun PipelineRasterizationStateCreateInfo(): VkPipelineRasterizationStateCreateInfo = VkPipelineRasterizationStateCreateInfo.callocStack().apply { type = VkStructureType.PIPELINE_RASTERIZATION_STATE_CREATE_INFO }
    inline fun PipelineRasterizationStateCreateInfo(block: VkPipelineRasterizationStateCreateInfo.() -> Unit): VkPipelineRasterizationStateCreateInfo = PipelineRasterizationStateCreateInfo().also(block)

    // TODO check
    fun PipelineShaderStageCreateInfo(): VkPipelineShaderStageCreateInfo = VkPipelineShaderStageCreateInfo.callocStack().apply{ type = VkStructureType.PIPELINE_SHADER_STAGE_CREATE_INFO }
    fun PipelineShaderStageCreateInfo(capacity: Int): VkPipelineShaderStageCreateInfo.Buffer = VkPipelineShaderStageCreateInfo.callocStack(capacity).onEach { it.type = VkStructureType.PIPELINE_SHADER_STAGE_CREATE_INFO }

    fun PipelineVertexInputStateCreateInfo(): VkPipelineVertexInputStateCreateInfo = VkPipelineVertexInputStateCreateInfo.callocStack().apply { type = VkStructureType.PIPELINE_VERTEX_INPUT_STATE_CREATE_INFO }
    inline fun PipelineVertexInputStateCreateInfo(block: VkPipelineVertexInputStateCreateInfo.() -> Unit): VkPipelineVertexInputStateCreateInfo = PipelineVertexInputStateCreateInfo().also(block)

    fun PipelineViewportStateCreateInfo(): VkPipelineViewportStateCreateInfo = VkPipelineViewportStateCreateInfo.callocStack().apply { type = VkStructureType.PIPELINE_VIEWPORT_STATE_CREATE_INFO }
    inline fun PipelineViewportStateCreateInfo(block: VkPipelineViewportStateCreateInfo.() -> Unit): VkPipelineViewportStateCreateInfo = PipelineViewportStateCreateInfo().also(block)

    fun PresentInfoKHR(): VkPresentInfoKHR = VkPresentInfoKHR.callocStack().apply { type = VkStructureType.PRESENT_INFO_KHR }
    inline fun PresentInfoKHR(block: VkPresentInfoKHR.() -> Unit): VkPresentInfoKHR = PresentInfoKHR().also(block)

    fun QueryPoolCreateInfo(): VkQueryPoolCreateInfo = VkQueryPoolCreateInfo.callocStack().apply { type = VkStructureType.QUERY_POOL_CREATE_INFO }
    inline fun QueryPoolCreateInfo(block: VkQueryPoolCreateInfo.() -> Unit): VkQueryPoolCreateInfo = QueryPoolCreateInfo().also(block)

    fun QueueFamilyProperties(): VkQueueFamilyProperties = VkQueueFamilyProperties.callocStack()
    inline fun QueueFamilyProperties(block: VkQueueFamilyProperties.() -> Unit): VkQueueFamilyProperties = QueueFamilyProperties().also(block)
    fun QueueFamilyProperties(capacity: Int): VkQueueFamilyProperties.Buffer = VkQueueFamilyProperties.callocStack(capacity)

    fun QueueFamilyProperties2(): VkQueueFamilyProperties2 = VkQueueFamilyProperties2.callocStack().apply { type = VkStructureType.QUEUE_FAMILY_PROPERTIES_2 }
    inline fun QueueFamilyProperties2(block: VkQueueFamilyProperties2.() -> Unit): VkQueueFamilyProperties2 = QueueFamilyProperties2().also(block)
    fun QueueFamilyProperties2(capacity: Int): VkQueueFamilyProperties2.Buffer = VkQueueFamilyProperties2.callocStack(capacity).onEach { it.type = VkStructureType.QUEUE_FAMILY_PROPERTIES_2 }

    fun RenderPassBeginInfo(): VkRenderPassBeginInfo = VkRenderPassBeginInfo.callocStack().apply { type = VkStructureType.RENDER_PASS_BEGIN_INFO }
    inline fun RenderPassBeginInfo(block: VkRenderPassBeginInfo.() -> Unit): VkRenderPassBeginInfo = RenderPassBeginInfo().also(block)

    fun RenderPassCreateInfo(): VkRenderPassCreateInfo = VkRenderPassCreateInfo.callocStack().apply { type = VkStructureType.RENDER_PASS_CREATE_INFO }
    inline fun RenderPassCreateInfo(block: VkRenderPassCreateInfo.() -> Unit): VkRenderPassCreateInfo = RenderPassCreateInfo().also(block)

    fun SamplerCreateInfo(): VkSamplerCreateInfo = VkSamplerCreateInfo.callocStack().apply { type = VkStructureType.SAMPLER_CREATE_INFO; maxAnisotropy = 1f }
    inline fun SamplerCreateInfo(block: VkSamplerCreateInfo.() -> Unit): VkSamplerCreateInfo = SamplerCreateInfo().also(block)

    fun SemaphoreCreateInfo(): VkSemaphoreCreateInfo = VkSemaphoreCreateInfo.callocStack().apply { type = VkStructureType.SEMAPHORE_CREATE_INFO }
    inline fun SemaphoreCreateInfo(block: VkSemaphoreCreateInfo.() -> Unit): VkSemaphoreCreateInfo = SemaphoreCreateInfo().also(block)

    fun ShaderModuleCreateInfo(): VkShaderModuleCreateInfo = VkShaderModuleCreateInfo.callocStack().apply { type = VkStructureType.SHADER_MODULE_CREATE_INFO }
    inline fun ShaderModuleCreateInfo(block: VkShaderModuleCreateInfo.() -> Unit): VkShaderModuleCreateInfo = ShaderModuleCreateInfo().also(block)

    fun SubmitInfo(): VkSubmitInfo = VkSubmitInfo.callocStack().apply { type = VkStructureType.SUBMIT_INFO }
    inline fun SubmitInfo(block: VkSubmitInfo.() -> Unit): VkSubmitInfo = SubmitInfo().also(block)

    fun SwapchainCreateInfoKHR(): VkSwapchainCreateInfoKHR = VkSwapchainCreateInfoKHR.callocStack().apply { type = VkStructureType.SWAPCHAIN_CREATE_INFO_KHR }
    inline fun SwapchainCreateInfoKHR(block: VkSwapchainCreateInfoKHR.() -> Unit): VkSwapchainCreateInfoKHR = SwapchainCreateInfoKHR().also(block)

    fun WriteDescriptorSet(): VkWriteDescriptorSet = VkWriteDescriptorSet.callocStack().apply { type = VkStructureType.WRITE_DESCRIPTOR_SET }
    inline fun WriteDescriptorSet(block: VkWriteDescriptorSet.() -> Unit): VkWriteDescriptorSet = WriteDescriptorSet().also(block)

    // TODO check
    fun WriteDescriptorSet(capacity: Int): VkWriteDescriptorSet.Buffer = VkWriteDescriptorSet.callocStack(capacity).onEach { it.type = VkStructureType.WRITE_DESCRIPTOR_SET }

    /*
        normal constructor functions
    */

    fun AttachmentDescription(): VkAttachmentDescription = VkAttachmentDescription.callocStack()
    fun AttachmentDescription(capacity: Int): VkAttachmentDescription.Buffer = VkAttachmentDescription.callocStack(capacity)
    inline fun AttachmentDescription(block: VkAttachmentDescription.() -> Unit): VkAttachmentDescription = AttachmentDescription().also(block)

    fun AttachmentReference(): VkAttachmentReference = VkAttachmentReference.callocStack()
    fun AttachmentReference(capacity: Int): VkAttachmentReference.Buffer = VkAttachmentReference.callocStack(capacity)
    inline fun AttachmentReference(block: VkAttachmentReference.() -> Unit): VkAttachmentReference = AttachmentReference().also(block)

    fun BufferCopy(): VkBufferCopy = VkBufferCopy.callocStack()
    fun BufferCopy(capacity: Int): VkBufferCopy.Buffer = VkBufferCopy.callocStack(capacity)
    inline fun BufferCopy(block: VkBufferCopy.() -> Unit): VkBufferCopy = BufferCopy().also(block)

    fun BufferImageCopy(): VkBufferImageCopy = VkBufferImageCopy.callocStack()
    fun BufferImageCopy(capacity: Int): VkBufferImageCopy.Buffer = VkBufferImageCopy.callocStack(capacity)
    inline fun BufferImageCopy(block: VkBufferImageCopy.() -> Unit): VkBufferImageCopy = BufferImageCopy().also(block)

    fun ClearValue(capacity: Int): VkClearValue.Buffer = VkClearValue.callocStack(capacity)

    fun ComponentMapping(): VkComponentMapping = VkComponentMapping.callocStack()
    fun ComponentMapping(s: VkComponentSwizzle): VkComponentMapping = VkComponentMapping.callocStack().r(s.i).g(s.i).b(s.i).a(s.i)
    fun ComponentMapping(r: VkComponentSwizzle, g: VkComponentSwizzle, b: VkComponentSwizzle, a: VkComponentSwizzle): VkComponentMapping = VkComponentMapping.callocStack().r(r.i).g(g.i).b(b.i).a(a.i)

    fun DescriptorBufferInfo(): VkDescriptorBufferInfo = VkDescriptorBufferInfo.callocStack()
    inline fun DescriptorBufferInfo(block: VkDescriptorBufferInfo.() -> Unit): VkDescriptorBufferInfo = DescriptorBufferInfo().also(block)

    fun DescriptorImageInfo(capacity: Int): VkDescriptorImageInfo.Buffer = VkDescriptorImageInfo.callocStack(capacity)
    inline fun DescriptorImageInfo(block: VkDescriptorImageInfo.() -> Unit): VkDescriptorImageInfo = VkDescriptorImageInfo.callocStack().also(block)

    fun DescriptorPoolSize(): VkDescriptorPoolSize = VkDescriptorPoolSize.callocStack()
    fun DescriptorPoolSize(capacity: Int): VkDescriptorPoolSize.Buffer = VkDescriptorPoolSize.callocStack(capacity)
    inline fun DescriptorPoolSize(block: VkDescriptorPoolSize.() -> Unit): VkDescriptorPoolSize = DescriptorPoolSize().also(block)
    inline fun DescriptorPoolSize(capacity: Int, block: VkDescriptorPoolSize.Buffer.() -> Unit): VkDescriptorPoolSize.Buffer = DescriptorPoolSize(capacity).also(block)

    fun DescriptorSetLayoutBinding(): VkDescriptorSetLayoutBinding = VkDescriptorSetLayoutBinding.callocStack()
    inline fun DescriptorSetLayoutBinding(block: VkDescriptorSetLayoutBinding.() -> Unit): VkDescriptorSetLayoutBinding = DescriptorSetLayoutBinding().also(block)
    inline fun DescriptorSetLayoutBinding(capacity: Int, block: VkDescriptorSetLayoutBinding.Buffer.() -> Unit): VkDescriptorSetLayoutBinding.Buffer = DescriptorSetLayoutBinding(capacity).also(block)
    fun DescriptorSetLayoutBinding(capacity: Int): VkDescriptorSetLayoutBinding.Buffer = VkDescriptorSetLayoutBinding.callocStack(capacity)

    fun DisplayModeProperties2KHR(capacity: Int): VkDisplayModeProperties2KHR.Buffer = VkDisplayModeProperties2KHR.callocStack(capacity)
    fun DisplayModePropertiesKHR(capacity: Int): VkDisplayModePropertiesKHR.Buffer = VkDisplayModePropertiesKHR.callocStack(capacity)

    fun DisplayPlaneCapabilities2KHR(): VkDisplayPlaneCapabilities2KHR = VkDisplayPlaneCapabilities2KHR.callocStack()
    fun DisplayPlaneCapabilities2KHR(capacity: Int): VkDisplayPlaneCapabilities2KHR.Buffer = VkDisplayPlaneCapabilities2KHR.callocStack(capacity)

    fun DisplayPlaneCapabilitiesKHR(): VkDisplayPlaneCapabilitiesKHR = VkDisplayPlaneCapabilitiesKHR.callocStack()
    fun DisplayPlaneCapabilitiesKHR(capacity: Int): VkDisplayPlaneCapabilitiesKHR.Buffer = VkDisplayPlaneCapabilitiesKHR.callocStack(capacity)

    fun ExtensionProperties(capacity: Int): VkExtensionProperties.Buffer = VkExtensionProperties.callocStack(capacity)

    fun Extent2D(): VkExtent2D = VkExtent2D.callocStack()
    inline fun Extent2D(block: VkExtent2D.() -> Unit): VkExtent2D = Extent2D().also(block)

    fun Extent3D(): VkExtent3D = VkExtent3D.callocStack()
    inline fun Extent3D(block: VkExtent3D.() -> Unit): VkExtent3D = Extent3D().also(block)

    fun ExternalImageFormatPropertiesNV(): VkExternalImageFormatPropertiesNV = VkExternalImageFormatPropertiesNV.callocStack()
    inline fun ExternalImageFormatPropertiesNV(block: VkExternalImageFormatPropertiesNV.() -> Unit): VkExternalImageFormatPropertiesNV = ExternalImageFormatPropertiesNV().also(block)

    fun FormatProperties(): VkFormatProperties = VkFormatProperties.callocStack()
    inline fun FormatProperties(block: VkFormatProperties.() -> Unit): VkFormatProperties = FormatProperties().also(block)

    fun FormatProperties2(): VkFormatProperties2 = VkFormatProperties2.callocStack().apply { type = VkStructureType.FORMAT_PROPERTIES_2 }
    inline fun FormatProperties2(block: VkFormatProperties2.() -> Unit): VkFormatProperties2 = FormatProperties2().also(block)

    fun ImageBlit(): VkImageBlit = VkImageBlit.callocStack()
    inline fun ImageBlit(block: VkImageBlit.() -> Unit): VkImageBlit = ImageBlit().also(block)

    fun ImageCopy(): VkImageCopy = VkImageCopy.callocStack()
    inline fun ImageCopy(block: VkImageCopy.() -> Unit): VkImageCopy = ImageCopy().also(block)

    fun ImageFormatProperties(): VkImageFormatProperties = VkImageFormatProperties.callocStack()
    inline fun ImageFormatProperties(block: VkImageFormatProperties.() -> Unit): VkImageFormatProperties = ImageFormatProperties().also(block)

    fun ImageFormatProperties2(): VkImageFormatProperties2 = VkImageFormatProperties2.callocStack().apply { type = VkStructureType.IMAGE_FORMAT_PROPERTIES_2 }
    inline fun ImageFormatProperties2(block: VkImageFormatProperties2.() -> Unit): VkImageFormatProperties2 = ImageFormatProperties2().also(block)

    fun ImageSubresource(): VkImageSubresource = VkImageSubresource.callocStack()
    inline fun ImageSubresource(block: VkImageSubresource.() -> Unit): VkImageSubresource = ImageSubresource().also(block)

    fun ImageSubresourceRange(): VkImageSubresourceRange = VkImageSubresourceRange.callocStack()
    inline fun ImageSubresourceRange(block: VkImageSubresourceRange.() -> Unit): VkImageSubresourceRange = ImageSubresourceRange().also(block)

    fun ImageSubresourceLayers(): VkImageSubresourceLayers = VkImageSubresourceLayers.callocStack()
    inline fun ImageSubresourceLayers(block: VkImageSubresourceLayers.() -> Unit): VkImageSubresourceLayers = ImageSubresourceLayers().also(block)

    fun LayerProperties(): VkLayerProperties = VkLayerProperties.callocStack()
    inline fun LayerProperties(block: VkLayerProperties.() -> Unit): VkLayerProperties = LayerProperties().also(block)
    fun LayerProperties(capacity: Int): VkLayerProperties.Buffer = VkLayerProperties.callocStack(capacity)

//    inline fun InstanceCreateInfo(extensions: ArrayList<String>): VkInstanceCreateInfo {
//        return InstanceCreateInfo {
//
//        }
//    }

    fun MemoryRequirements(): VkMemoryRequirements = VkMemoryRequirements.callocStack()
    inline fun MemoryRequirements(block: VkMemoryRequirements.() -> Unit): VkMemoryRequirements = MemoryRequirements().also(block)

    fun MemoryRequirements2(): VkMemoryRequirements2 = VkMemoryRequirements2.callocStack()
    inline fun MemoryRequirements2(block: VkMemoryRequirements2.() -> Unit): VkMemoryRequirements2 = MemoryRequirements2().also(block)

    fun MemoryRequirements2KHR(): VkMemoryRequirements2KHR = VkMemoryRequirements2KHR.callocStack()
    inline fun MemoryRequirements2KHR(block: VkMemoryRequirements2KHR.() -> Unit): VkMemoryRequirements2KHR = MemoryRequirements2KHR().also(block)

    fun PastPresentationTimingGOOGLE(): VkPastPresentationTimingGOOGLE = VkPastPresentationTimingGOOGLE.callocStack()
    fun PastPresentationTimingGOOGLE(capacity: Int): VkPastPresentationTimingGOOGLE.Buffer = VkPastPresentationTimingGOOGLE.callocStack(capacity)
    inline fun PastPresentationTimingGOOGLE(block: VkPastPresentationTimingGOOGLE.() -> Unit): VkPastPresentationTimingGOOGLE = PastPresentationTimingGOOGLE().also(block)

    fun PipelineColorBlendAttachmentState(): VkPipelineColorBlendAttachmentState = VkPipelineColorBlendAttachmentState.callocStack()
    fun PipelineColorBlendAttachmentState(capacity: Int): VkPipelineColorBlendAttachmentState.Buffer = VkPipelineColorBlendAttachmentState.callocStack(capacity)
    inline fun PipelineColorBlendAttachmentState(block: VkPipelineColorBlendAttachmentState.() -> Unit): VkPipelineColorBlendAttachmentState = PipelineColorBlendAttachmentState().also(block)

    fun PushConstantRange(): VkPushConstantRange = VkPushConstantRange.callocStack()
    fun PushConstantRange(capacity: Int): VkPushConstantRange.Buffer = VkPushConstantRange.callocStack(capacity)
    inline fun PushConstantRange(block: VkPushConstantRange.() -> Unit): VkPushConstantRange = PushConstantRange().also(block)

    fun Rect2D(): VkRect2D = VkRect2D.callocStack()
    inline fun Rect2D(block: VkRect2D.() -> Unit): VkRect2D = Rect2D().also(block)
    fun Rect2D(capacity: Int): VkRect2D.Buffer = VkRect2D.callocStack(capacity)

    fun RefreshCycleDurationGOOGLE(): VkRefreshCycleDurationGOOGLE = VkRefreshCycleDurationGOOGLE.callocStack()
    inline fun RefreshCycleDurationGOOGLE(block: VkRefreshCycleDurationGOOGLE.() -> Unit): VkRefreshCycleDurationGOOGLE = RefreshCycleDurationGOOGLE().also(block)

    fun SparseImageFormatProperties(): VkSparseImageFormatProperties = VkSparseImageFormatProperties.callocStack()
    fun SparseImageFormatProperties(capacity: Int): VkSparseImageFormatProperties.Buffer = VkSparseImageFormatProperties.callocStack(capacity)
    inline fun SparseImageFormatProperties(block: VkSparseImageFormatProperties.() -> Unit): VkSparseImageFormatProperties = SparseImageFormatProperties().also(block)

    fun SparseImageFormatProperties2(): VkSparseImageFormatProperties2 = VkSparseImageFormatProperties2.callocStack().apply { type = VkStructureType.SPARSE_IMAGE_FORMAT_PROPERTIES_2 }
    fun SparseImageFormatProperties2(capacity: Int): VkSparseImageFormatProperties2.Buffer = VkSparseImageFormatProperties2.callocStack(capacity).onEach { it.type = VkStructureType.SPARSE_IMAGE_FORMAT_PROPERTIES_2 }
    inline fun SparseImageFormatProperties2(block: VkSparseImageFormatProperties2.() -> Unit): VkSparseImageFormatProperties2 = SparseImageFormatProperties2().also(block)

    fun SparseImageMemoryRequirements(): VkSparseImageMemoryRequirements = VkSparseImageMemoryRequirements.callocStack()
    fun SparseImageMemoryRequirements(capacity: Int): VkSparseImageMemoryRequirements.Buffer = VkSparseImageMemoryRequirements.callocStack(capacity)
    inline fun SparseImageMemoryRequirements(block: VkSparseImageMemoryRequirements.() -> Unit): VkSparseImageMemoryRequirements = SparseImageMemoryRequirements().also(block)

    fun SparseImageMemoryRequirements2(): VkSparseImageMemoryRequirements2 = VkSparseImageMemoryRequirements2.callocStack()
    fun SparseImageMemoryRequirements2(capacity: Int): VkSparseImageMemoryRequirements2.Buffer = VkSparseImageMemoryRequirements2.callocStack(capacity)
    inline fun SparseImageMemoryRequirements2(block: VkSparseImageMemoryRequirements2.() -> Unit): VkSparseImageMemoryRequirements2 = SparseImageMemoryRequirements2().also(block)

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
    fun SubresourceLayout(capacity: Int): VkSubresourceLayout.Buffer = VkSubresourceLayout.callocStack(capacity)

    fun SurfaceCapabilities2EXT(): VkSurfaceCapabilities2EXT = VkSurfaceCapabilities2EXT.callocStack().apply { type = VkStructureType.SURFACE_CAPABILITIES_2_EXT }
    inline fun SurfaceCapabilities2EXT(block: VkSurfaceCapabilities2EXT.() -> Unit): VkSurfaceCapabilities2EXT = SurfaceCapabilities2EXT().also(block)

    fun SurfaceCapabilities2KHR(): VkSurfaceCapabilities2KHR = VkSurfaceCapabilities2KHR.callocStack().apply { type = VkStructureType.SURFACE_CAPABILITIES_2_KHR }
    inline fun SurfaceCapabilities2KHR(block: VkSurfaceCapabilities2KHR.() -> Unit): VkSurfaceCapabilities2KHR = SurfaceCapabilities2KHR().also(block)

    fun SurfaceCapabilitiesKHR(): VkSurfaceCapabilitiesKHR = VkSurfaceCapabilitiesKHR.callocStack()
    inline fun SurfaceCapabilitiesKHR(block: VkSurfaceCapabilitiesKHR.() -> Unit): VkSurfaceCapabilitiesKHR = SurfaceCapabilitiesKHR().also(block)

    fun SurfaceFormat2KHR(): VkSurfaceFormat2KHR = VkSurfaceFormat2KHR.callocStack().apply { type = VkStructureType.SURFACE_FORMAT_2_KHR }
    fun SurfaceFormat2KHR(capacity: Int): VkSurfaceFormat2KHR.Buffer = VkSurfaceFormat2KHR.callocStack(capacity)

    fun SurfaceFormatKHR(): VkSurfaceFormatKHR = VkSurfaceFormatKHR.callocStack()
    fun SurfaceFormatKHR(capacity: Int): VkSurfaceFormatKHR.Buffer = VkSurfaceFormatKHR.callocStack(capacity)

    fun VertexInputAttributeDescription(): VkVertexInputAttributeDescription = VkVertexInputAttributeDescription.callocStack()
    fun VertexInputAttributeDescription(capacity: Int): VkVertexInputAttributeDescription.Buffer = VkVertexInputAttributeDescription.callocStack(capacity)
    inline fun VertexInputAttributeDescription(block: VkVertexInputAttributeDescription.() -> Unit): VkVertexInputAttributeDescription = VertexInputAttributeDescription().also(block)
    inline fun VertexInputAttributeDescription(capacity: Int, block: VkVertexInputAttributeDescription.Buffer.() -> Unit): VkVertexInputAttributeDescription.Buffer = VertexInputAttributeDescription(capacity).also(block)

    fun VertexInputBindingDescription(): VkVertexInputBindingDescription = VkVertexInputBindingDescription.callocStack()
    inline fun VertexInputBindingDescription(block: VkVertexInputBindingDescription.() -> Unit): VkVertexInputBindingDescription = VertexInputBindingDescription().also(block)
    fun VertexInputBindingDescription(capacity: Int): VkVertexInputBindingDescription.Buffer = VkVertexInputBindingDescription.callocStack(capacity)

    fun Viewport(): VkViewport = VkViewport.callocStack()
    inline fun Viewport(block: VkViewport.() -> Unit): VkViewport = Viewport().also(block)
    fun Viewport(capacity: Int): VkViewport.Buffer = VkViewport.callocStack(capacity)


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

    fun PipelineDynamicStateCreateInfo(dynamicStates: Collection<VkDynamicState>, flags: VkPipelineDynamicStateCreateFlags = 0): VkPipelineDynamicStateCreateInfo = stak {
        PipelineDynamicStateCreateInfo {
            this.dynamicStates = it.VkDynamicStateBuffer(dynamicStates)
            this.flags = flags
        }
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

    fun SurfaceFormatKHR(format: VkFormat, colorSpace: VkColorSpaceKHR): VkSurfaceFormatKHR =
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
                this.imageInfo = imageInfo
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
                if (info0 is VkDescriptorBufferInfo) it[0].bufferInfo_ = info0 else it[0].imageInfo = info0 as VkDescriptorImageInfo
                it[1].dstSet(dstSet1.L).descriptorType(type1.i).dstBinding(binding1)
                if (info1 is VkDescriptorBufferInfo) it[1].bufferInfo_ = info1 else it[1].imageInfo = info1 as VkDescriptorImageInfo
            }

    fun WriteDescriptorSet(
            dstSet0: VkDescriptorSet, type0: VkDescriptorType, binding0: Int, info0: Struct,
            dstSet1: VkDescriptorSet, type1: VkDescriptorType, binding1: Int, info1: Struct,
            dstSet2: VkDescriptorSet, type2: VkDescriptorType, binding2: Int, info2: Struct): VkWriteDescriptorSet.Buffer =
            WriteDescriptorSet(3).also {
                it[0].dstSet(dstSet0.L).descriptorType(type0.i).dstBinding(binding0)
                if (info0 is VkDescriptorBufferInfo) it[0].bufferInfo_ = info0 else it[0].imageInfo = info0 as VkDescriptorImageInfo
                it[1].dstSet(dstSet1.L).descriptorType(type1.i).dstBinding(binding1)
                if (info1 is VkDescriptorBufferInfo) it[1].bufferInfo_ = info1 else it[1].imageInfo = info1 as VkDescriptorImageInfo
                it[2].dstSet(dstSet2.L).descriptorType(type2.i).dstBinding(binding2)
                if (info2 is VkDescriptorBufferInfo) it[2].bufferInfo_ = info2 else it[2].imageInfo = info2 as VkDescriptorImageInfo
            }

    fun WriteDescriptorSet(
            dstSet0: VkDescriptorSet, type0: VkDescriptorType, binding0: Int, info0: Struct,
            dstSet1: VkDescriptorSet, type1: VkDescriptorType, binding1: Int, info1: Struct,
            dstSet2: VkDescriptorSet, type2: VkDescriptorType, binding2: Int, info2: Struct,
            dstSet3: VkDescriptorSet, type3: VkDescriptorType, binding3: Int, info3: Struct): VkWriteDescriptorSet.Buffer =
            WriteDescriptorSet(4).also {
                it[0].dstSet(dstSet0.L).descriptorType(type0.i).dstBinding(binding0)
                if (info0 is VkDescriptorBufferInfo) it[0].bufferInfo_ = info0 else it[0].imageInfo = info0 as VkDescriptorImageInfo
                it[1].dstSet(dstSet1.L).descriptorType(type1.i).dstBinding(binding1)
                if (info1 is VkDescriptorBufferInfo) it[1].bufferInfo_ = info1 else it[1].imageInfo = info1 as VkDescriptorImageInfo
                it[2].dstSet(dstSet2.L).descriptorType(type2.i).dstBinding(binding2)
                if (info2 is VkDescriptorBufferInfo) it[2].bufferInfo_ = info2 else it[2].imageInfo = info2 as VkDescriptorImageInfo
                it[3].dstSet(dstSet3.L).descriptorType(type3.i).dstBinding(binding3)
                if (info3 is VkDescriptorBufferInfo) it[3].bufferInfo_ = info3 else it[3].imageInfo = info3 as VkDescriptorImageInfo
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

    fun createSemaphore(device: VkDevice, createInfo: VkSemaphoreCreateInfo, semaphores: VkSemaphore_Buffer): VkResult =
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

    fun getPhysicalDeviceSurfaceSupportKHR(physicalDevice: VkPhysicalDevice, queueFamily: Int, surface: VkSurfaceKHR): Boolean =
            stak {
                val supported = it.nmalloc(1, Int.BYTES)
                KHRSurface.nvkGetPhysicalDeviceSurfaceSupportKHR(physicalDevice, queueFamily, surface.L, supported)
                memGetBoolean(supported)
            }

    fun getPhysicalDeviceSurfaceSupportKHR(physicalDevice: VkPhysicalDevice, queueFamilyProperties: ArrayList<VkQueueFamilyProperties>, surface: VkSurfaceKHR): BooleanArray =
            stak {
                val supported = it.nmalloc(1, Int.BYTES)
                BooleanArray(queueFamilyProperties.size) {
                    KHRSurface.nvkGetPhysicalDeviceSurfaceSupportKHR(physicalDevice, it, surface.L, supported)
                    memGetBoolean(supported)
                }
            }

    fun getPhysicalDeviceSurfaceFormatsKHR(physicalDevice: VkPhysicalDevice, surface: VkSurfaceKHR): ArrayList<VkSurfaceFormatKHR> =
            stak {
                val pCount = it.nmalloc(1, Int.BYTES)
                VK_CHECK_RESULT(KHRSurface.nvkGetPhysicalDeviceSurfaceFormatsKHR(physicalDevice, surface.L, pCount, NULL))
                val count = memGetInt(pCount)
                assert(count > 0)
                val surfaceFormats = SurfaceFormatKHR(count)
                VK_CHECK_RESULT(KHRSurface.nvkGetPhysicalDeviceSurfaceFormatsKHR(physicalDevice, surface.L, pCount, surfaceFormats.adr))
                return surfaceFormats.toCollection(arrayListOf())
            }

    fun getPhysicalDeviceSurfaceCapabilitiesKHR(physicalDevice: VkPhysicalDevice, surface: VkSurfaceKHR): VkSurfaceCapabilitiesKHR =
            SurfaceCapabilitiesKHR {
                VK_CHECK_RESULT(KHRSurface.nvkGetPhysicalDeviceSurfaceCapabilitiesKHR(physicalDevice, surface.L, adr))
            }

    fun getPhysicalDeviceSurfacePresentModesKHR(physicalDevice: VkPhysicalDevice, surface: VkSurfaceKHR): ArrayList<VkPresentModeKHR> =
            stak {
                val pCount = it.nmalloc(1, Int.BYTES)
                VK_CHECK_RESULT(KHRSurface.nvkGetPhysicalDeviceSurfacePresentModesKHR(physicalDevice, surface.L, pCount, NULL))
                val count = memGetInt(pCount)
                assert(count > 0)
                val presentModes = it.nmalloc(Int.BYTES, count * Int.BYTES)
                KHRSurface.nvkGetPhysicalDeviceSurfacePresentModesKHR(physicalDevice, surface.L, pCount, presentModes)
                val res = ArrayList<VkPresentModeKHR>()
                for (i in 0 until count)
                    res += VkPresentModeKHR(memGetInt(presentModes + Int.BYTES * i))
                return res
            }

    fun invalidateMappedMemoryRanges(device: VkDevice, memoryRange: VkMappedMemoryRange): VkResult =
            VkResult(VK10.nvkInvalidateMappedMemoryRanges(device, 1, memoryRange.adr))

    fun queueSubmit(queue: VkQueue, submit: VkSubmitInfo, fence: VkFence = VkFence(NULL)): VkResult =
            VkResult(VK10.nvkQueueSubmit(queue, 1, submit.adr, fence.L))

    fun updateDescriptorSets(device: VkDevice, descriptorWrites: VkWriteDescriptorSet.Buffer, descriptorCopies: VkCopyDescriptorSet.Buffer? = null) =
            VK10.nvkUpdateDescriptorSets(device, descriptorWrites.remaining(), descriptorWrites.adr, descriptorCopies?.remaining()
                    ?: 0, descriptorCopies?.adr ?: NULL)

    val VERSION = "0.2.4"
}
