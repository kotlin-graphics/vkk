package vkk

import org.lwjgl.vulkan.*
import vkk.entities.VkDynamicStateBuffer


//fun VmDescriptorBufferInfo(): VkDescriptorBufferInfo = VkDescriptorBufferInfo.malloc()
//fun VmDescriptorBufferInfo(capacity: Int): VkDescriptorBufferInfo.Buffer = VkDescriptorBufferInfo.malloc(capacity)
fun VkClearValue(): VkClearValue = VkClearValue.calloc()

fun VkClearValue(capacity: Int): VkClearValue.Buffer = VkClearValue.calloc(capacity)

fun VkDescriptorBufferInfo(): VkDescriptorBufferInfo = VkDescriptorBufferInfo.calloc()

fun VkDescriptorBufferInfo(capacity: Int): VkDescriptorBufferInfo.Buffer = VkDescriptorBufferInfo.calloc(capacity)


//fun VbApplicationInfo(block: VkApplicationInfo.() -> Unit): VkApplicationInfo = VkApplicationInfo.create(ptr.advance(VkApplicationInfo.SIZEOF)).also(block)

fun VkDescriptorSetLayoutBinding(): VkDescriptorSetLayoutBinding = VkDescriptorSetLayoutBinding.calloc()
fun VkDescriptorSetLayoutBinding(capacity: Int): VkDescriptorSetLayoutBinding.Buffer = VkDescriptorSetLayoutBinding.calloc(capacity)

inline fun VkDescriptorSetLayoutCreateInfo(block: VkDescriptorSetLayoutCreateInfo.() -> Unit): VkDescriptorSetLayoutCreateInfo {
    val res = VkDescriptorSetLayoutCreateInfo.calloc()
    res.type = VkStructureType.DESCRIPTOR_SET_LAYOUT_CREATE_INFO
    res.block()
    return res
}

fun VkImageCreateInfo() = VkImageCreateInfo.calloc().apply { type = VkStructureType.IMAGE_CREATE_INFO }

fun VkImageSubresourceRange(aspectMask: VkImageAspectFlags,
                             baseMipLevel: Int,
                             levelCount: Int,
                             baseArrayLayer: Int,
                             layerCount: Int): VkImageSubresourceRange {
    return VkImageSubresourceRange.calloc().also {
        it.aspectMask = aspectMask
        it.baseMipLevel = baseMipLevel
        it.levelCount = levelCount
        it.baseArrayLayer = baseArrayLayer
        it.layerCount = layerCount
    }
}

inline fun VkPipelineColorBlendAttachmentState(block: VkPipelineColorBlendAttachmentState.() -> Unit): VkPipelineColorBlendAttachmentState = VkPipelineColorBlendAttachmentState().also(block)

fun VkPipelineColorBlendAttachmentState(capacity: Int): VkPipelineColorBlendAttachmentState.Buffer = VkPipelineColorBlendAttachmentState.calloc(capacity)

fun VkPipelineColorBlendAttachmentState(): VkPipelineColorBlendAttachmentState = VkPipelineColorBlendAttachmentState.calloc()

inline fun VkPipelineColorBlendAttachmentState(capacity: Int, block: VkPipelineColorBlendAttachmentState.() -> Unit): VkPipelineColorBlendAttachmentState.Buffer {
    val res = VkPipelineColorBlendAttachmentState(capacity)
    res[0].block()
    return res
}

inline fun VkPipelineColorBlendStateCreateInfo(block: VkPipelineColorBlendStateCreateInfo.() -> Unit): VkPipelineColorBlendStateCreateInfo =
        VkPipelineColorBlendStateCreateInfo.calloc().apply {
            type = VkStructureType.PIPELINE_COLOR_BLEND_STATE_CREATE_INFO
            block()
        }

fun VkPipelineDepthStencilStateCreateInfo(): VkPipelineDepthStencilStateCreateInfo =
        VkPipelineDepthStencilStateCreateInfo.calloc().apply { type = VkStructureType.PIPELINE_DEPTH_STENCIL_STATE_CREATE_INFO }

inline fun VkPipelineDepthStencilStateCreateInfo(block: VkPipelineDepthStencilStateCreateInfo.() -> Unit): VkPipelineDepthStencilStateCreateInfo =
        VkPipelineDepthStencilStateCreateInfo().also(block)

inline fun VkPipelineDynamicStateCreateInfo(block: VkPipelineDynamicStateCreateInfo.() -> Unit): VkPipelineDynamicStateCreateInfo =
        VkPipelineDynamicStateCreateInfo.calloc().apply {
            type = VkStructureType.PIPELINE_DYNAMIC_STATE_CREATE_INFO
            block()
        }

inline fun VkPipelineInputAssemblyStateCreateInfo(block: VkPipelineInputAssemblyStateCreateInfo.() -> Unit): VkPipelineInputAssemblyStateCreateInfo =
        VkPipelineInputAssemblyStateCreateInfo.calloc().apply {
            type = VkStructureType.PIPELINE_INPUT_ASSEMBLY_STATE_CREATE_INFO
            block()
        }

fun VkPipelineShaderStageCreateInfo(): VkPipelineShaderStageCreateInfo =
        VkPipelineShaderStageCreateInfo.calloc().apply { type = VkStructureType.PIPELINE_SHADER_STAGE_CREATE_INFO }

inline fun VkPipelineMultisampleStateCreateInfo(block: VkPipelineMultisampleStateCreateInfo.() -> Unit): VkPipelineMultisampleStateCreateInfo =
        VkPipelineMultisampleStateCreateInfo.calloc().apply {
            type = VkStructureType.PIPELINE_MULTISAMPLE_STATE_CREATE_INFO
            block()
        }

inline fun VkPipelineRasterizationStateCreateInfo(block: VkPipelineRasterizationStateCreateInfo.() -> Unit): VkPipelineRasterizationStateCreateInfo =
        VkPipelineRasterizationStateCreateInfo.calloc().apply {
            type = VkStructureType.PIPELINE_RASTERIZATION_STATE_CREATE_INFO
            block()
        }

fun VkPipelineShaderStageCreateInfo(capacity: Int): VkPipelineShaderStageCreateInfo.Buffer =
        VkPipelineShaderStageCreateInfo.calloc(capacity).also {
            for (info in it)
                info.type = VkStructureType.PIPELINE_SHADER_STAGE_CREATE_INFO
        }

inline fun VkPipelineShaderStageCreateInfo(block: VkPipelineShaderStageCreateInfo.() -> Unit): VkPipelineShaderStageCreateInfo {
    val res = VkPipelineShaderStageCreateInfo.calloc()
    res.type = VkStructureType.PIPELINE_SHADER_STAGE_CREATE_INFO
    res.block()
    return res
}

fun VkPipelineVertexInputStateCreateInfo(): VkPipelineVertexInputStateCreateInfo = VkPipelineVertexInputStateCreateInfo.calloc().apply { type = VkStructureType.PIPELINE_VERTEX_INPUT_STATE_CREATE_INFO }
fun VkPipelineVertexInputStateCreateInfo(capacity: Int): VkPipelineVertexInputStateCreateInfo.Buffer = VkPipelineVertexInputStateCreateInfo.calloc(capacity).also {
    for (i in it)
        i.type = VkStructureType.PIPELINE_VERTEX_INPUT_STATE_CREATE_INFO
}

inline fun VkPipelineVertexInputStateCreateInfo(block: VkPipelineVertexInputStateCreateInfo.() -> Unit): VkPipelineVertexInputStateCreateInfo {
    return VkPipelineVertexInputStateCreateInfo().also(block)
}

inline fun VkPipelineViewportStateCreateInfo(block: VkPipelineViewportStateCreateInfo.() -> Unit): VkPipelineViewportStateCreateInfo =
        VkPipelineViewportStateCreateInfo.calloc().apply {
            type = VkStructureType.PIPELINE_VIEWPORT_STATE_CREATE_INFO
            block()
        }

fun VkRect2D(): VkRect2D = VkRect2D.calloc()

fun VkRenderPassBeginInfo(): VkRenderPassBeginInfo = VkRenderPassBeginInfo.calloc().apply { type = VkStructureType.RENDER_PASS_BEGIN_INFO }
inline fun VkRenderPassBeginInfo(block: VkRenderPassBeginInfo.() -> Unit): VkRenderPassBeginInfo = VkRenderPassBeginInfo().also(block)

inline fun VkSemaphoreCreateInfo(block: VkSemaphoreCreateInfo.() -> Unit): VkSemaphoreCreateInfo {
    val res = VkSemaphoreCreateInfo.calloc()
    res.type = VkStructureType.SEMAPHORE_CREATE_INFO
    res.block()
    return res
}

fun VkSemaphoreCreateInfo() = VkSemaphoreCreateInfo.calloc().apply { type = VkStructureType.SEMAPHORE_CREATE_INFO }

fun VkSubmitInfo() = VkSubmitInfo.calloc().apply { type = VkStructureType.SUBMIT_INFO }

inline fun VkSubmitInfo(block: VkSubmitInfo.() -> Unit): VkSubmitInfo = VkSubmitInfo().also(block)

fun VkVertexInputAttributeDescription(): VkVertexInputAttributeDescription = VkVertexInputAttributeDescription.calloc()
fun VkVertexInputAttributeDescription(capacity: Int): VkVertexInputAttributeDescription.Buffer = VkVertexInputAttributeDescription.calloc(capacity)

fun VkVertexInputBindingDescription(): VkVertexInputBindingDescription = VkVertexInputBindingDescription.calloc()

fun VkVertexInputBindingDescription(block: VkVertexInputBindingDescription.() -> Unit): VkVertexInputBindingDescription {
    return VkVertexInputBindingDescription().also(block)
}

fun VkVertexInputBindingDescription(capacity: Int): VkVertexInputBindingDescription.Buffer = VkVertexInputBindingDescription.calloc(capacity)
fun VkVertexInputBindingDescription(capacity: Int, block: VkVertexInputBindingDescription.() -> Unit): VkVertexInputBindingDescription.Buffer =
        VkVertexInputBindingDescription(capacity).also { it[0].block() }

fun VkViewport(): VkViewport = VkViewport.calloc()

// common functions

fun VkPipelineDynamicStateCreateInfo(dynamicStates: VkDynamicStateBuffer, flags: VkPipelineDynamicStateCreateFlags = 0): VkPipelineDynamicStateCreateInfo =
        VkPipelineDynamicStateCreateInfo {
            this.dynamicStates = dynamicStates
            this.flags = flags
        }

fun VkPipelineDynamicStateCreateInfo(dynamicStates: Collection<VkDynamicState>, flags: VkPipelineDynamicStateCreateFlags = 0): VkPipelineDynamicStateCreateInfo =
        VkPipelineDynamicStateCreateInfo {
            this.dynamicStates = VkDynamicStateBuffer(dynamicStates)
            this.flags = flags
        }

fun VkPipelineInputAssemblyStateCreateInfo(topology: VkPrimitiveTopology,
                                           flags: VkPipelineInputAssemblyStateCreateFlags = 0,
                                           primitiveRestartEnable: Boolean = false): VkPipelineInputAssemblyStateCreateInfo =
        VkPipelineInputAssemblyStateCreateInfo {
            this.topology = topology
            this.flags = flags
            this.primitiveRestartEnable = primitiveRestartEnable
        }
