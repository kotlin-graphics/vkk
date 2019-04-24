package vkk.extensionFunctions

import glm_.BYTES
import glm_.L
import glm_.i
import kool.*
import org.lwjgl.PointerBuffer
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.system.Pointer
import org.lwjgl.vulkan.*
import vkk.*
import vkk.entities.*
import java.nio.ByteBuffer
import java.nio.IntBuffer
import java.nio.LongBuffer


/** @return ImageIndex */
fun VkDevice.acquireNextImageKHR(swapchain: VkSwapchainKHR, timeout: Long, semaphore: VkSemaphore, fence: VkFence = VkFence(NULL)): Int =
        stak.intAddress { VK_CHECK_RESULT(KHRSwapchain.nvkAcquireNextImageKHR(this, swapchain.L, timeout, semaphore.L, fence.L, it)) }

/** @return ImageIndex */
fun VkDevice.acquireNextImage2KHR(acquireInfo: VkAcquireNextImageInfoKHR): Int =
        stak.intAddress { VK_CHECK_RESULT(KHRSwapchain.nvkAcquireNextImage2KHR(this, acquireInfo.adr, it)) }

inline infix fun <reified T> VkDevice.allocateCommandBuffers(allocateInfo: VkCommandBufferAllocateInfo): T =
        stak {
            val count = allocateInfo.commandBufferCount
            val pCommandBuffers = it.nmalloc(Pointer.POINTER_SIZE, count * Pointer.POINTER_SIZE)
            VK_CHECK_RESULT(VK10.nvkAllocateCommandBuffers(this, allocateInfo.adr, pCommandBuffers))
            when (T::class) {
                VkCommandBuffer::class -> VkCommandBuffer(memGetLong(pCommandBuffers), this) as T
                Array<VkCommandBuffer>::class -> Array(count) { VkCommandBuffer(memGetAddress(pCommandBuffers + Pointer.POINTER_SIZE * it), this) } as T
                ArrayList::class -> {
                    val res = ArrayList<VkCommandBuffer>(count)
                    for (i in 0 until count)
                        res += VkCommandBuffer(memGetAddress(pCommandBuffers + Pointer.POINTER_SIZE * i), this)
                    res as T
                }
                List::class -> List(count) { VkCommandBuffer(memGetAddress(pCommandBuffers + Pointer.POINTER_SIZE * it), this) } as T
                else -> throw Exception("[VkDevice::allocateCommandBuffers] Invalid T")
            }
        }

inline infix fun VkDevice.allocateDescriptorSet(allocateInfo: VkDescriptorSetAllocateInfo): VkDescriptorSet =
        VkDescriptorSet(stak.longAddress { VK_CHECK_RESULT(VK10.nvkAllocateDescriptorSets(this, allocateInfo.adr, it)) })

inline infix fun <reified T> VkDevice.allocateDescriptorSets(allocateInfo: VkDescriptorSetAllocateInfo): T =
        stak {
            val count = allocateInfo.descriptorSetCount
            val pDescriptorSets = it.nmalloc(8, count * Long.BYTES)
            VK_CHECK_RESULT(VK10.nvkAllocateDescriptorSets(this, allocateInfo.adr, pDescriptorSets))
            when (T::class) {
                VkDescriptorSet::class -> VkDescriptorSet(memGetLong(pDescriptorSets)) as T
                VkDescriptorSet_Array::class -> VkDescriptorSet_Array(
                        LongArray(count) { memGetLong(pDescriptorSets + Long.BYTES * it) }) as T
                ArrayList::class -> {
                    val res = ArrayList<VkDescriptorSet>(count)
                    for (i in 0 until count)
                        res += VkDescriptorSet(memGetLong(pDescriptorSets + Long.BYTES * i))
                    res as T
                }
                List::class -> List(count) { VkDescriptorSet(memGetLong(pDescriptorSets + Long.BYTES * it)) } as T
                else -> throw Exception("[VkDevice::allocateDescriptorSets] Invalid T")
            }
        }

infix fun VkDevice.allocateMemory(allocateInfo: VkMemoryAllocateInfo): VkDeviceMemory =
        VkDeviceMemory(stak.longAddress { VK_CHECK_RESULT(VK10.nvkAllocateMemory(this, allocateInfo.adr, NULL, it)) })

infix fun VkDevice.bindAccelerationStructureMemoryNV(bindInfos: VkBindAccelerationStructureMemoryInfoNV.Buffer): VkResult =
        VkResult(NVRayTracing.nvkBindAccelerationStructureMemoryNV(this, bindInfos.rem, bindInfos.adr)).apply { check() }

fun VkDevice.bindBufferMemory(buffer: VkBuffer, memory: VkDeviceMemory, memoryOffset: VkDeviceSize = VkDeviceSize(0)): VkResult =
        VkResult(VK10.vkBindBufferMemory(this, buffer.L, memory.L, memoryOffset.L)).apply { check() }

infix fun VkDevice.bindBufferMemory2(bindInfos: VkBindBufferMemoryInfo.Buffer): VkResult =
        VkResult(VK11.nvkBindBufferMemory2(this, bindInfos.rem, bindInfos.adr)).apply { check() }

infix fun VkDevice.bindBufferMemory2KHR(bindInfos: VkBindBufferMemoryInfo.Buffer): VkResult =
        VkResult(KHRBindMemory2.nvkBindBufferMemory2KHR(this, bindInfos.rem, bindInfos.adr)).apply { check() }

fun VkDevice.bindImageMemory(image: VkImage, memory: VkDeviceMemory, memoryOffset: VkDeviceSize = VkDeviceSize(0)): VkResult =
        VkResult(VK10.vkBindImageMemory(this, image.L, memory.L, memoryOffset.L)).apply { check() }

fun VkDevice.bindImageMemory2(bindInfos: VkBindImageMemoryInfo.Buffer): VkResult =
        VkResult(VK11.nvkBindImageMemory2(this, bindInfos.rem, bindInfos.adr)).apply { check() }

infix fun VkDevice.bindImageMemory2KHR(bindInfos: VkBindImageMemoryInfo.Buffer): VkResult =
        VkResult(KHRBindMemory2.nvkBindImageMemory2KHR(this, bindInfos.rem, bindInfos.adr)).apply { check() }

fun VkDevice.compileDeferredNV(pipeline: VkPipeline, shader: Int): VkResult =
        VkResult(NVRayTracing.vkCompileDeferredNV(this, pipeline.L, shader)).apply { check() }

fun VkDevice.createAccelerationStructureNV(createInfo: VkAccelerationStructureCreateInfoNV, accelerationStructure: VkAccelerationStructureNV_Buffer): VkResult =
        VkResult(NVRayTracing.nvkCreateAccelerationStructureNV(this, createInfo.adr, NULL, accelerationStructure.adr)).apply { check() }

fun VkDevice.createBuffer(usage: VkBufferUsageFlags, size: VkDeviceSize): VkBuffer =
        createBuffer(vk.BufferCreateInfo { this.usage = usage; this.size = size })

infix fun VkDevice.createBuffer(createInfo: VkBufferCreateInfo): VkBuffer =
        VkBuffer(stak.longAddress { VK_CHECK_RESULT(VK10.nvkCreateBuffer(this, createInfo.adr, NULL, it)) })

infix fun VkDevice.createBufferView(createInfo: VkBufferViewCreateInfo): VkBufferView =
        VkBufferView(stak.longAddress { VK_CHECK_RESULT(VK10.nvkCreateBufferView(this, createInfo.adr, NULL, it)) })

infix fun VkDevice.createCommandPool(createInfo: VkCommandPoolCreateInfo): VkCommandPool =
        VkCommandPool(stak.longAddress { VK_CHECK_RESULT(VK10.nvkCreateCommandPool(this, createInfo.adr, NULL, it)) })

fun VkDevice.createComputePipelines(pipelineCache: VkPipelineCache, createInfo: VkComputePipelineCreateInfo): VkPipeline =
        VkPipeline(stak.longAddress {
            VK_CHECK_RESULT(VK10.nvkCreateComputePipelines(this, pipelineCache.L, 1, createInfo.adr, NULL, it))
        })

inline fun <reified T> VkDevice.createComputePipelines(pipelineCache: VkPipelineCache, createInfos: VkComputePipelineCreateInfo.Buffer): T =
        stak {
            val count = createInfos.rem
            val pComputePipelines = it.nmalloc(8, count * Long.BYTES)
            VK_CHECK_RESULT(VK10.nvkCreateComputePipelines(this, pipelineCache.L, count, createInfos.adr, NULL, pComputePipelines))
            when (T::class) {
                VkPipeline::class -> VkPipeline(memGetLong(pComputePipelines)) as T
                VkPipeline_Array::class -> VkPipeline_Array(
                        LongArray(count) { memGetLong(pComputePipelines + Long.BYTES * it) }) as T
                ArrayList::class -> {
                    val res = ArrayList<VkPipeline>(count)
                    for (i in 0 until count)
                        res += VkPipeline(memGetLong(pComputePipelines + Long.BYTES * i))
                    res as T
                }
                List::class -> List(count) { VkPipeline(memGetLong(pComputePipelines + Long.BYTES * it)) } as T
                else -> throw Exception("[VkDevice::createComputePipelines] Invalid T")
            }
        }

infix fun VkDevice.createDescriptorPool(createInfo: VkDescriptorPoolCreateInfo): VkDescriptorPool =
        VkDescriptorPool(stak.longAddress { VK_CHECK_RESULT(VK10.nvkCreateDescriptorPool(this, createInfo.adr, NULL, it)) })

infix fun VkDevice.createDescriptorSetLayout(createInfo: VkDescriptorSetLayoutCreateInfo): VkDescriptorSetLayout =
        VkDescriptorSetLayout(stak.longAddress { VK_CHECK_RESULT(VK10.nvkCreateDescriptorSetLayout(this, createInfo.adr, NULL, it)) })

infix fun VkDevice.createDescriptorUpdateTemplate(createInfo: VkDescriptorUpdateTemplateCreateInfo): VkDescriptorUpdateTemplate =
        VkDescriptorUpdateTemplate(stak.longAddress {
            VK_CHECK_RESULT(VK11.nvkCreateDescriptorUpdateTemplate(this, createInfo.adr, NULL, it))
        })

infix fun VkDevice.createEvent(createInfo: VkEventCreateInfo): VkEvent =
        VkEvent(stak.longAddress { VK_CHECK_RESULT(VK10.nvkCreateEvent(this, createInfo.adr, NULL, it)) })

infix fun VkDevice.createFence(flag: VkFenceCreate): VkFence =
        createFence(vk.FenceCreateInfo { flags = flag.i })

infix fun VkDevice.createFence(flags: VkFenceCreateFlags): VkFence =
        createFence(vk.FenceCreateInfo { this.flags = flags })

infix fun VkDevice.createFence(createInfo: VkFenceCreateInfo): VkFence =
        VkFence(stak.longAddress { VK_CHECK_RESULT(VK10.nvkCreateFence(this, createInfo.adr, NULL, it)) })

infix fun VkDevice.createFramebuffer(createInfo: VkFramebufferCreateInfo): VkFramebuffer =
        VkFramebuffer(stak.longAddress { VK_CHECK_RESULT(VK10.nvkCreateFramebuffer(this, createInfo.adr, NULL, it)) })

fun VkDevice.createGraphicsPipelines(pipelineCache: VkPipelineCache, createInfo: VkGraphicsPipelineCreateInfo): VkPipeline =
        VkPipeline(stak.longAddress {
            VK_CHECK_RESULT(VK10.nvkCreateGraphicsPipelines(this, pipelineCache.L, 1, createInfo.adr, NULL, it))
        })

inline fun <reified T> VkDevice.createGraphicsPipelines(pipelineCache: VkPipelineCache, createInfos: VkGraphicsPipelineCreateInfo.Buffer): T =
        stak {
            val count = createInfos.rem
            val pGraphicPipelines = it.nmalloc(8, count * Long.BYTES)
            VK_CHECK_RESULT(VK10.nvkCreateGraphicsPipelines(this, pipelineCache.L, count, createInfos.adr, NULL, pGraphicPipelines))
            when (T::class) {
                VkPipeline::class -> VkPipeline(memGetLong(pGraphicPipelines)) as T
                VkPipeline_Array::class -> VkPipeline_Array(
                        LongArray(count) { memGetLong(pGraphicPipelines + Long.BYTES * it) }) as T
                ArrayList::class -> {
                    val res = ArrayList<VkPipeline>(count)
                    for (i in 0 until count)
                        res += VkPipeline(memGetLong(pGraphicPipelines + Long.BYTES * i))
                    res as T
                }
                List::class -> List(count) { VkPipeline(memGetLong(pGraphicPipelines + Long.BYTES * it)) } as T
                else -> throw Exception("[VkDevice::createGraphicsPipelines] Invalid T")
            }
        }

infix fun VkDevice.createImage(createInfo: VkImageCreateInfo): VkImage =
        VkImage(stak.longAddress { VK_CHECK_RESULT(VK10.nvkCreateImage(this, createInfo.adr, NULL, it)) })

infix fun VkDevice.createImageView(createInfo: VkImageViewCreateInfo): VkImageView =
        VkImageView(stak.longAddress { VK_CHECK_RESULT(VK10.nvkCreateImageView(this, createInfo.adr, NULL, it)) })

fun VkDevice.createIndirectCommandsLayoutNVX(createInfo: VkIndirectCommandsLayoutCreateInfoNVX, indirectCommandsLayout: VkIndirectCommandsLayoutNVX): VkImageView =
        VkImageView(stak.longAddress { VK_CHECK_RESULT(NVXDeviceGeneratedCommands.nvkCreateIndirectCommandsLayoutNVX(this, createInfo.adr, NULL, it)) })

fun VkDevice.createObjectTableNVX(createInfo: VkObjectTableCreateInfoNVX, objectTable: VkObjectTableNVX_Buffer) =
        VK_CHECK_RESULT(NVXDeviceGeneratedCommands.nvkCreateObjectTableNVX(this, createInfo.adr, NULL, objectTable.adr))

// TODO delete?
//fun VkDevice.createPipeline(pipelineCache: VkPipelineCache, createInfo: VkGraphicsPipelineCreateInfo): VkPipeline = VkPipeline(stak.longAddress { VK_CHECK_RESULT(VK10.nvkCreateGraphicsPipelines(this, pipelineCache.L, 1, createInfo.adr, NULL, it)) })

infix fun VkDevice.createPipelineCache(createInfo: VkPipelineCacheCreateInfo): VkPipelineCache =
        VkPipelineCache(stak.longAddress { VK_CHECK_RESULT(VK10.nvkCreatePipelineCache(this, createInfo.adr, NULL, it)) })

infix fun VkDevice.createPipelineLayout(createInfo: VkPipelineLayoutCreateInfo): VkPipelineLayout =
        VkPipelineLayout(stak.longAddress { VK_CHECK_RESULT(VK10.nvkCreatePipelineLayout(this, createInfo.adr, NULL, it)) })

infix fun VkDevice.createQueryPool(createInfo: VkQueryPoolCreateInfo): VkQueryPool =
        VkQueryPool(stak.longAddress { VK_CHECK_RESULT(VK10.nvkCreateQueryPool(this, createInfo.adr, NULL, it)) })

fun VkDevice.createRayTracingPipelinesNV(pipelineCache: VkPipelineCache, createInfos: VkRayTracingPipelineCreateInfoNV): VkPipeline =
        VkPipeline(stak.longAddress { VK_CHECK_RESULT(NVRayTracing.nvkCreateRayTracingPipelinesNV(this, pipelineCache.L, 1, createInfos.adr, NULL, it)) })

inline fun <reified T> VkDevice.createRayTracingPipelinesNV(pipelineCache: VkPipelineCache, createInfos: VkRayTracingPipelineCreateInfoNV.Buffer): T =
        stak {
            val count = createInfos.rem
            val pRayTracingPipelinesNV = it.nmalloc(8, count * Long.BYTES)
            VK_CHECK_RESULT(NVRayTracing.nvkCreateRayTracingPipelinesNV(this, pipelineCache.L, 1, createInfos.adr, NULL, pRayTracingPipelinesNV))
            when (T::class) {
                VkPipeline::class -> VkPipeline(memGetLong(pRayTracingPipelinesNV)) as T
                VkPipeline_Array::class -> VkPipeline_Array(
                        LongArray(count) { memGetLong(pRayTracingPipelinesNV + Long.BYTES * it) }) as T
                ArrayList::class -> {
                    val res = ArrayList<VkPipeline>(count)
                    for (i in 0 until count)
                        res += VkPipeline(memGetLong(pRayTracingPipelinesNV + Long.BYTES * i))
                    res as T
                }
                List::class -> List(count) { VkPipeline(memGetLong(pRayTracingPipelinesNV + Long.BYTES * it)) } as T
                else -> throw Exception("[VkDevice::createRayTracingPipelinesNV] Invalid T")
            }
        }

infix fun VkDevice.createRenderPass(createInfo: VkRenderPassCreateInfo): VkRenderPass =
        VkRenderPass(stak.longAddress { VK_CHECK_RESULT(VK10.nvkCreateRenderPass(this, createInfo.adr, NULL, it)) })

infix fun VkDevice.createRenderPass2KHR(createInfo: VkRenderPassCreateInfo2KHR): VkRenderPass =
        VkRenderPass(stak.longAddress { VK_CHECK_RESULT(KHRCreateRenderpass2.nvkCreateRenderPass2KHR(this, createInfo.adr, NULL, it)) })

infix fun VkDevice.createSampler(createInfo: VkSamplerCreateInfo): VkSampler =
        VkSampler(stak.longAddress { VK_CHECK_RESULT(VK10.nvkCreateSampler(this, createInfo.adr, NULL, it)) })

infix fun VkDevice.createSamplerYcbcrConversion(createInfo: VkSamplerYcbcrConversionCreateInfo): VkSamplerYcbcrConversion =
        VkSamplerYcbcrConversion(stak.longAddress { VK_CHECK_RESULT(VK11.nvkCreateSamplerYcbcrConversion(this, createInfo.adr, NULL, it)) })

infix fun VkDevice.createSamplerYcbcrConversionKHR(createInfo: VkSamplerYcbcrConversionCreateInfo): VkSamplerYcbcrConversion =
        VkSamplerYcbcrConversion(stak.longAddress { VK_CHECK_RESULT(KHRSamplerYcbcrConversion.nvkCreateSamplerYcbcrConversionKHR(this, createInfo.adr, NULL, it)) })

infix fun VkDevice.createSemaphore(createInfo: VkSemaphoreCreateInfo): VkSemaphore =
        VkSemaphore(stak.longAddress { VK_CHECK_RESULT(VK10.nvkCreateSemaphore(this, createInfo.adr, NULL, it)) })

infix fun VkDevice.createShaderModule(createInfo: VkShaderModuleCreateInfo): VkShaderModule =
        VkShaderModule(stak.longAddress { VK_CHECK_RESULT(VK10.nvkCreateShaderModule(this, createInfo.adr, NULL, it)) })

fun VkDevice.createSharedSwapchainsKHR(createInfos: VkSwapchainCreateInfoKHR): VkSwapchainKHR =
        VkSwapchainKHR(stak.longAddress {
            VK_CHECK_RESULT(KHRDisplaySwapchain.nvkCreateSharedSwapchainsKHR(this, 1, createInfos.adr, NULL, it))
        })

inline fun <reified T> VkDevice.createSharedSwapchainsKHR(createInfos: VkSwapchainCreateInfoKHR.Buffer): T =
        stak {
            val count = createInfos.rem
            val pSharedSwapchainsKHR = it.nmalloc(8, count * Long.BYTES)
            VK_CHECK_RESULT(KHRDisplaySwapchain.nvkCreateSharedSwapchainsKHR(this, createInfos.rem, createInfos.adr, NULL, pSharedSwapchainsKHR))
            when (T::class) {
                VkSwapchainKHR::class -> VkSwapchainKHR(memGetLong(pSharedSwapchainsKHR)) as T
                VkSwapchainKHR_Array::class -> VkSwapchainKHR_Array(
                        LongArray(count) { memGetLong(pSharedSwapchainsKHR + Long.BYTES * it) }) as T
                ArrayList::class -> {
                    val res = ArrayList<VkSwapchainKHR>(count)
                    for (i in 0 until count)
                        res += VkSwapchainKHR(memGetLong(pSharedSwapchainsKHR + Long.BYTES * i))
                    res as T
                }
                List::class -> List(count) { VkSwapchainKHR(memGetLong(pSharedSwapchainsKHR + Long.BYTES * it)) } as T
                else -> throw Exception("[VkDevice::createSharedSwapchainsKHR] Invalid T")
            }
        }

infix fun VkDevice.createSwapchainKHR(createInfo: VkSwapchainCreateInfoKHR): VkSwapchainKHR =
        VkSwapchainKHR(stak.longAddress { VK_CHECK_RESULT(KHRSwapchain.nvkCreateSwapchainKHR(this, createInfo.adr, NULL, it)) })

infix fun VkDevice.createValidationCacheEXT(createInfo: VkValidationCacheCreateInfoEXT): VkValidationCacheEXT =
        VkValidationCacheEXT(stak.longAddress { VK_CHECK_RESULT(EXTValidationCache.nvkCreateValidationCacheEXT(this, createInfo.adr, NULL, it)) })

infix fun VkDevice.debugMarkerSetObjectNameEXT(nameInfo: VkDebugMarkerObjectNameInfoEXT) =
        VK_CHECK_RESULT(EXTDebugMarker.nvkDebugMarkerSetObjectNameEXT(this, nameInfo.adr))

infix fun VkDevice.debugMarkerSetObjectTagEXT(tagInfo: VkDebugMarkerObjectTagInfoEXT) =
        VK_CHECK_RESULT(EXTDebugMarker.nvkDebugMarkerSetObjectTagEXT(this, tagInfo.adr))

infix fun VkDevice.destroyAccelerationStructureNV(accelerationStructure: VkAccelerationStructureNV) =
        NVRayTracing.nvkDestroyAccelerationStructureNV(this, accelerationStructure.L, NULL)

infix fun VkDevice.destroy(accelerationStructure: VkAccelerationStructureNV) =
        NVRayTracing.nvkDestroyAccelerationStructureNV(this, accelerationStructure.L, NULL)

infix fun VkDevice.destroyBuffer(buffer: VkBuffer) =
        VK10.nvkDestroyBuffer(this, buffer.L, NULL)

infix fun VkDevice.destroy(buffer: VkBuffer) =
        VK10.nvkDestroyBuffer(this, buffer.L, NULL)

infix fun VkDevice.destroyBufferView(bufferView: VkBufferView) =
        VK10.nvkDestroyBufferView(this, bufferView.L, NULL)

infix fun VkDevice.destroy(bufferView: VkBufferView) =
        VK10.nvkDestroyBufferView(this, bufferView.L, NULL)

infix fun VkDevice.destroyCommandPool(commandPool: VkCommandPool) =
        VK10.nvkDestroyCommandPool(this, commandPool.L, NULL)

infix fun VkDevice.destroy(commandPool: VkCommandPool) =
        VK10.nvkDestroyCommandPool(this, commandPool.L, NULL)

infix fun VkDevice.destroyDescriptorPool(descriptorPool: VkDescriptorPool) =
        VK10.nvkDestroyDescriptorPool(this, descriptorPool.L, NULL)

infix fun VkDevice.destroy(descriptorPool: VkDescriptorPool) =
        VK10.nvkDestroyDescriptorPool(this, descriptorPool.L, NULL)

infix fun VkDevice.destroyDescriptorSetLayout(descriptorSetLayout: VkDescriptorSetLayout) =
        VK10.nvkDestroyDescriptorSetLayout(this, descriptorSetLayout.L, NULL)

infix fun VkDevice.destroy(descriptorSetLayout: VkDescriptorSetLayout) =
        VK10.nvkDestroyDescriptorSetLayout(this, descriptorSetLayout.L, NULL)

// TODO others?
infix fun VkDevice.destroyDescriptorSetLayouts(descriptorSetLayouts: Collection<VkDescriptorSetLayout>) {
    for (i in descriptorSetLayouts)
        VK10.nvkDestroyDescriptorSetLayout(this, i.L, NULL)
}

infix fun VkDevice.destroyDescriptorUpdateTemplate(descriptorUpdateTemplate: VkDescriptorUpdateTemplate) =
        VK11.nvkDestroyDescriptorUpdateTemplate(this, descriptorUpdateTemplate.L, NULL)

infix fun VkDevice.destroy(descriptorUpdateTemplate: VkDescriptorUpdateTemplate) =
        VK11.nvkDestroyDescriptorUpdateTemplate(this, descriptorUpdateTemplate.L, NULL)

infix fun VkDevice.destroyKHR(descriptorUpdateTemplate: VkDescriptorUpdateTemplate) =
        KHRDescriptorUpdateTemplate.nvkDestroyDescriptorUpdateTemplateKHR(this, descriptorUpdateTemplate.L, NULL)

fun VkDevice.destroy() =
        VK10.nvkDestroyDevice(this, NULL)

infix fun VkDevice.destroyEvent(event: VkEvent) =
        VK10.nvkDestroyEvent(this, event.L, NULL)

infix fun VkDevice.destroy(event: VkEvent) =
        VK10.nvkDestroyEvent(this, event.L, NULL)

infix fun VkDevice.destroyFence(fence: VkFence) =
        VK10.nvkDestroyFence(this, fence.L, NULL)

infix fun VkDevice.destroy(fence: VkFence) =
        VK10.nvkDestroyFence(this, fence.L, NULL)

// TODO others?
infix fun VkDevice.destroyFences(fences: Collection<VkFence>) {
    for (fence in fences)
        VK10.nvkDestroyFence(this, fence.L, NULL)
}

// TODO others?
infix fun VkDevice.destroyFences(fences: VkFence_Array) {
    for (fence in fences.array)
        VK10.nvkDestroyFence(this, fence, NULL)
}

infix fun VkDevice.destroyFramebuffer(framebuffer: VkFramebuffer) =
        VK10.nvkDestroyFramebuffer(this, framebuffer.L, NULL)

infix fun VkDevice.destroy(framebuffer: VkFramebuffer) =
        VK10.nvkDestroyFramebuffer(this, framebuffer.L, NULL)

infix fun VkDevice.destroyFramebuffers(framebuffers: Collection<VkFramebuffer>) {
    for (i in framebuffers)
        VK10.nvkDestroyFramebuffer(this, i.L, NULL)
}

infix fun VkDevice.destroyImage(image: VkImage) =
        VK10.nvkDestroyImage(this, image.L, NULL)

infix fun VkDevice.destroy(image: VkImage) =
        VK10.nvkDestroyImage(this, image.L, NULL)

infix fun VkDevice.destroyImageView(imageView: VkImageView) =
        VK10.nvkDestroyImageView(this, imageView.L, NULL)

infix fun VkDevice.destroy(imageView: VkImageView) =
        VK10.nvkDestroyImageView(this, imageView.L, NULL)

infix fun VkDevice.destroyIndirectCommandsLayoutNVX(indirectCommandsLayout: VkIndirectCommandsLayoutNVX) =
        NVXDeviceGeneratedCommands.nvkDestroyIndirectCommandsLayoutNVX(this, indirectCommandsLayout.L, NULL)

infix fun VkDevice.destroy(indirectCommandsLayout: VkIndirectCommandsLayoutNVX) =
        NVXDeviceGeneratedCommands.nvkDestroyIndirectCommandsLayoutNVX(this, indirectCommandsLayout.L, NULL)

infix fun VkDevice.destroyObjectTableNVX(objectTable: VkObjectTableNVX) =
        NVXDeviceGeneratedCommands.nvkDestroyObjectTableNVX(this, objectTable.L, NULL)

infix fun VkDevice.destroy(objectTableNVX: VkObjectTableNVX) =
        NVXDeviceGeneratedCommands.nvkDestroyObjectTableNVX(this, objectTableNVX.L, NULL)

infix fun VkDevice.destroyPipeline(pipeline: VkPipeline) =
        VK10.nvkDestroyPipeline(this, pipeline.L, NULL)

infix fun VkDevice.destroy(pipeline: VkPipeline) =
        VK10.nvkDestroyPipeline(this, pipeline.L, NULL)

infix fun VkDevice.destroyPipelineCache(pipelineCache: VkPipelineCache) =
        VK10.nvkDestroyPipelineCache(this, pipelineCache.L, NULL)

infix fun VkDevice.destroy(pipelineCache: VkPipelineCache) =
        VK10.nvkDestroyPipelineCache(this, pipelineCache.L, NULL)

infix fun VkDevice.destroyPipelineLayout(pipelineLayout: VkPipelineLayout) =
        VK10.nvkDestroyPipelineLayout(this, pipelineLayout.L, NULL)

infix fun VkDevice.destroy(pipelineLayout: VkPipelineLayout) =
        VK10.nvkDestroyPipelineLayout(this, pipelineLayout.L, NULL)

infix fun VkDevice.destroyQueryPool(queryPool: VkQueryPool) =
        VK10.nvkDestroyQueryPool(this, queryPool.L, NULL)

infix fun VkDevice.destroy(queryPool: VkQueryPool) =
        VK10.nvkDestroyQueryPool(this, queryPool.L, NULL)

infix fun VkDevice.destroyRenderPass(renderPass: VkRenderPass) =
        VK10.nvkDestroyRenderPass(this, renderPass.L, NULL)

infix fun VkDevice.destroy(renderPass: VkRenderPass) =
        VK10.nvkDestroyRenderPass(this, renderPass.L, NULL)

infix fun VkDevice.destroySampler(sampler: VkSampler) =
        VK10.nvkDestroySampler(this, sampler.L, NULL)

infix fun VkDevice.destroy(sampler: VkSampler) =
        VK10.nvkDestroySampler(this, sampler.L, NULL)

infix fun VkDevice.destroySamplerYcbcrConversion(ycbcrConversion: VkSamplerYcbcrConversion) =
        VK11.nvkDestroySamplerYcbcrConversion(this, ycbcrConversion.L, NULL)

infix fun VkDevice.destroy(ycbcrConversion: VkSamplerYcbcrConversion) =
        VK11.nvkDestroySamplerYcbcrConversion(this, ycbcrConversion.L, NULL)

infix fun VkDevice.destroySamplerYcbcrConversionKHR(ycbcrConversion: VkSamplerYcbcrConversion) =
        KHRSamplerYcbcrConversion.nvkDestroySamplerYcbcrConversionKHR(this, ycbcrConversion.L, NULL)

infix fun VkDevice.destroySemaphore(semaphore: VkSemaphore) =
        VK10.nvkDestroySemaphore(this, semaphore.L, NULL)

infix fun VkDevice.destroy(semaphore: VkSemaphore) =
        VK10.nvkDestroySemaphore(this, semaphore.L, NULL)

infix fun VkDevice.destroySemaphores(semaphores: VkSemaphore_Array) {
    for (semaphore in semaphores.array)
        VK10.nvkDestroySemaphore(this, semaphore, NULL)
}

fun VkDevice.destroySemaphores(semaphore0: VkSemaphore, semaphore1: VkSemaphore) {
    VK10.nvkDestroySemaphore(this, semaphore0.L, NULL)
    VK10.nvkDestroySemaphore(this, semaphore1.L, NULL)
}

fun VkDevice.destroySemaphores(semaphore0: VkSemaphore, semaphore1: VkSemaphore, semaphore2: VkSemaphore) {
    VK10.nvkDestroySemaphore(this, semaphore0.L, NULL)
    VK10.nvkDestroySemaphore(this, semaphore1.L, NULL)
    VK10.nvkDestroySemaphore(this, semaphore2.L, NULL)
}

infix fun VkDevice.destroyShaderModule(shaderModule: VkShaderModule) =
        VK10.nvkDestroyShaderModule(this, shaderModule.L, NULL)

infix fun VkDevice.destroy(shaderModule: VkShaderModule) =
        VK10.nvkDestroyShaderModule(this, shaderModule.L, NULL)

fun VkDevice.destroyShaderModules(shaderModules: Collection<VkShaderModule>) {
    for (i in shaderModules)
        VK10.nvkDestroyShaderModule(this, i.L, NULL)
}

infix fun VkDevice.destroySwapchainKHR(swapchain: VkSwapchainKHR) =
        KHRSwapchain.nvkDestroySwapchainKHR(this, swapchain.L, NULL)

infix fun VkDevice.destroy(swapchain: VkSwapchainKHR) =
        KHRSwapchain.nvkDestroySwapchainKHR(this, swapchain.L, NULL)

infix fun VkDevice.destroyValidationCacheEXT(validationCache: VkValidationCacheEXT) =
        EXTValidationCache.nvkDestroyValidationCacheEXT(this, validationCache.L, NULL)

infix fun VkDevice.destroy(validationCache: VkValidationCacheEXT) =
        EXTValidationCache.nvkDestroyValidationCacheEXT(this, validationCache.L, NULL)

fun VkDevice.waitIdle() =
        VK_CHECK_RESULT(VK10.vkDeviceWaitIdle(this))

fun VkDevice.displayPowerControlEXT(display: VkDisplayKHR, displayPowerInfo: VkDisplayPowerInfoEXT) =
        VK_CHECK_RESULT(EXTDisplayControl.nvkDisplayPowerControlEXT(this, display.L, displayPowerInfo.adr))

infix fun VkDevice.flushMappedMemoryRanges(memoryRange: VkMappedMemoryRange) =
        VK_CHECK_RESULT(VK10.nvkFlushMappedMemoryRanges(this, 1, memoryRange.adr))

infix fun VkDevice.flushMappedMemoryRanges(memoryRanges: VkMappedMemoryRange.Buffer) =
        VK_CHECK_RESULT(VK10.nvkFlushMappedMemoryRanges(this, memoryRanges.capacity(), memoryRanges.adr))

fun VkDevice.freeCommandBuffer(commandPool: VkCommandPool, commandBuffer: VkCommandBuffer) =
        stak.pointerAddress(commandBuffer) { VK10.nvkFreeCommandBuffers(this, commandPool.L, 1, it) }

fun VkDevice.freeCommandBuffers(commandPool: VkCommandPool, commandBuffers: Array<VkCommandBuffer>) =
        stak {
            val size = commandBuffers.size
            val pointers = it.nmalloc(Pointer.POINTER_SIZE, size * Pointer.POINTER_SIZE)
            for (i in 0 until size)
                memPutAddress(pointers + Pointer.POINTER_SIZE * i, commandBuffers[i].adr)
            VK10.nvkFreeCommandBuffers(this, commandPool.L, size, pointers)
        }

fun VkDevice.free(commandPool: VkCommandPool, commandBuffers: Array<VkCommandBuffer>) =
        freeCommandBuffers(commandPool, commandBuffers)

fun VkDevice.freeCommandBuffers(commandPool: VkCommandPool, commandBuffers: Collection<VkCommandBuffer>) =
        stak {
            val size = commandBuffers.size
            val pointers = it.nmalloc(Pointer.POINTER_SIZE, size * Pointer.POINTER_SIZE)
            for (i in 0 until size)
                memPutAddress(pointers + Pointer.POINTER_SIZE * i, commandBuffers.elementAt(i).adr)
            VK10.nvkFreeCommandBuffers(this, commandPool.L, size, pointers)
        }

fun VkDevice.free(commandPool: VkCommandPool, commandBuffers: Collection<VkCommandBuffer>) =
        freeCommandBuffers(commandPool, commandBuffers)

fun VkDevice.freeDescriptorSets(descriptorPool: VkDescriptorPool, descriptorSet: VkDescriptorSet) =
        stak.longAddress(descriptorSet.L) { VK_CHECK_RESULT(VK10.nvkFreeDescriptorSets(this, descriptorPool.L, 1, it)) }

fun VkDevice.free(descriptorPool: VkDescriptorPool, descriptorSet: VkDescriptorSet) =
        stak.longAddress(descriptorSet.L) { VK_CHECK_RESULT(VK10.nvkFreeDescriptorSets(this, descriptorPool.L, 1, it)) }

fun VkDevice.freeDescriptorSets(descriptorPool: VkDescriptorPool, descriptorSets: VkDescriptorSet_Buffer) =
        VK_CHECK_RESULT(VK10.nvkFreeDescriptorSets(this, descriptorPool.L, descriptorSets.rem, descriptorSets.adr))

fun VkDevice.free(descriptorPool: VkDescriptorPool, descriptorSets: VkDescriptorSet_Buffer) =
        VK_CHECK_RESULT(VK10.nvkFreeDescriptorSets(this, descriptorPool.L, descriptorSets.rem, descriptorSets.adr))

infix fun VkDevice.freeMemory(memory: VkDeviceMemory) =
        VK10.nvkFreeMemory(this, memory.L, NULL)

infix fun VkDevice.free(memory: VkDeviceMemory) =
        VK10.nvkFreeMemory(this, memory.L, NULL)

fun VkDevice.getAccelerationStructureHandleNV(accelerationStructure: VkAccelerationStructureNV, data: ByteBuffer) =
        VK_CHECK_RESULT(NVRayTracing.nvkGetAccelerationStructureHandleNV(this, accelerationStructure.L, data.rem.L, data.adr))

fun VkDevice.getAccelerationStructureMemoryRequirementsNV(info: VkAccelerationStructureMemoryRequirementsInfoNV, memoryRequirements: VkMemoryRequirements2KHR = vk.MemoryRequirements2KHR()) =
        NVRayTracing.nvkGetAccelerationStructureMemoryRequirementsNV(this, info.adr, memoryRequirements.adr)

fun VkDevice.getBufferAddressEXT(info: VkBufferDeviceAddressInfoEXT): VkDeviceAddress =
        VkDeviceAddress(EXTBufferDeviceAddress.nvkGetBufferDeviceAddressEXT(this, info.adr))

fun VkDevice.getBufferMemoryRequirements(buffer: VkBuffer, memoryRequirements: VkMemoryRequirements = vk.MemoryRequirements()): VkMemoryRequirements =
        memoryRequirements.also { VK10.nvkGetBufferMemoryRequirements(this, buffer.L, it.adr) }

fun VkDevice.getBufferMemoryRequirements2(info: VkBufferMemoryRequirementsInfo2, memoryRequirements: VkMemoryRequirements2 = vk.MemoryRequirements2()): VkMemoryRequirements2 =
        memoryRequirements.also { VK11.nvkGetBufferMemoryRequirements2(this, info.adr, it.adr) }

fun VkDevice.getBufferMemoryRequirements2KHR(info: VkBufferMemoryRequirementsInfo2, memoryRequirements: VkMemoryRequirements2 = vk.MemoryRequirements2()): VkMemoryRequirements2 =
        memoryRequirements.also { KHRGetMemoryRequirements2.nvkGetBufferMemoryRequirements2KHR(this, info.adr, it.adr) }

/** @return maxDeviation */
fun VkDevice.getCalibratedTimestampsEXT(timestampInfos: VkCalibratedTimestampInfoEXT.Buffer, timestamps: LongBuffer): Long =
        stak.longAddress {
            EXTCalibratedTimestamps.nvkGetCalibratedTimestampsEXT(this, timestampInfos.rem, timestampInfos.adr, timestamps.adr, it)
        }

fun VkDevice.getDescriptorSetLayoutSupport(createInfo: VkDescriptorSetLayoutCreateInfo, support: VkDescriptorSetLayoutSupport = vk.DescriptorSetLayoutSupport()): VkDescriptorSetLayoutSupport =
        support.also { VK11.nvkGetDescriptorSetLayoutSupport(this, createInfo.adr, it.adr) }

fun VkDevice.getDescriptorSetLayoutSupportKHR(createInfo: VkDescriptorSetLayoutCreateInfo, support: VkDescriptorSetLayoutSupport = vk.DescriptorSetLayoutSupport()): VkDescriptorSetLayoutSupport =
        support.also { KHRMaintenance3.nvkGetDescriptorSetLayoutSupportKHR(this, createInfo.adr, it.adr) }

fun VkDevice.getGroupPeerMemoryFeatures(heapIndex: Int, localDeviceIndex: Int, remoteDeviceIndex: Int): VkPeerMemoryFeatureFlags =
        stak.intAddress { VK11.nvkGetDeviceGroupPeerMemoryFeatures(this, heapIndex, localDeviceIndex, remoteDeviceIndex, it) }

fun VkDevice.getGroupPeerMemoryFeaturesKHR(heapIndex: Int, localDeviceIndex: Int, remoteDeviceIndex: Int): VkPeerMemoryFeatureFlags =
        stak.intAddress { KHRDeviceGroup.nvkGetDeviceGroupPeerMemoryFeaturesKHR(this, heapIndex, localDeviceIndex, remoteDeviceIndex, it) }

fun VkDevice.getGroupPresentCapabilitiesKHR(deviceGroupPresentCapabilities: VkDeviceGroupPresentCapabilitiesKHR = vk.DeviceGroupPresentCapabilitiesKHR()): VkDeviceGroupPresentCapabilitiesKHR =
        deviceGroupPresentCapabilities.also { VK_CHECK_RESULT(KHRDeviceGroup.nvkGetDeviceGroupPresentCapabilitiesKHR(this, it.adr)) }

fun VkDevice.getGroupSurfacePresentModesKHR(surface: VkSurfaceKHR): VkDeviceGroupPresentModeFlagsKHR =
        stak.intAddress { VK_CHECK_RESULT(KHRDeviceGroup.nvkGetDeviceGroupSurfacePresentModesKHR(this, surface.L, it)) }

infix fun VkDevice.getImageViewHandleNVX(info: VkImageViewHandleInfoNVX): Int =
        NVXImageViewHandle.nvkGetImageViewHandleNVX(this, info.adr)

fun VkDevice.getMemoryCommitment(memory: VkDeviceMemory): VkDeviceSize =
        VkDeviceSize(stak.longAddress { VK10.nvkGetDeviceMemoryCommitment(this, memory.L, it) })

infix fun VkDevice.getProcAddr(name: CharSequence): Adr =
        stak.asciiAddress(name) { VK10.nvkGetDeviceProcAddr(this, it) }

fun VkDevice.getQueue(queueFamilyIndex: Int, queueIndex: Int = 0): VkQueue =
        VkQueue(stak.pointerAddress { VK10.nvkGetDeviceQueue(this, queueFamilyIndex, queueIndex, it) }, this)

infix fun VkDevice.getQueue2(queueInfo: VkDeviceQueueInfo2): VkQueue =
        VkQueue(stak.pointerAddress { VK11.nvkGetDeviceQueue2(this, queueInfo.adr, it) }, this)

infix fun VkDevice.getEventStatus(event: VkEvent): VkResult =
        VkResult(VK10.vkGetEventStatus(this, event.L)).apply { check() }

infix fun VkDevice.getFenceFdKHR(getFdInfo: VkFenceGetFdInfoKHR): Int =
        stak.intAddress { VK_CHECK_RESULT(KHRExternalFenceFd.nvkGetFenceFdKHR(this, getFdInfo.adr, it)) }

infix fun VkDevice.getFenceStatus(fence: VkFence): VkResult =
        VkResult(VK10.vkGetFenceStatus(this, fence.L)).apply { check() }

infix fun VkDevice.getFenceWin32HandleKHR(getWin32HandleInfo: VkFenceGetWin32HandleInfoKHR): HANDLE =
        HANDLE(stak.pointerAddress { VK_CHECK_RESULT(KHRExternalFenceWin32.nvkGetFenceWin32HandleKHR(this, getWin32HandleInfo.adr, it)) })

fun VkDevice.getImageDrmFormatModifierPropertiesEXT(image: VkImage, properties: VkImageDrmFormatModifierPropertiesEXT = vk.ImageDrmFormatModifierPropertiesEXT()): VkImageDrmFormatModifierPropertiesEXT =
        properties.also { VK_CHECK_RESULT(EXTImageDrmFormatModifier.nvkGetImageDrmFormatModifierPropertiesEXT(this, image.L, it.adr)) }

fun VkDevice.getImageMemoryRequirements(image: VkImage, memoryRequirements: VkMemoryRequirements = vk.MemoryRequirements()): VkMemoryRequirements =
        memoryRequirements.also { VK10.nvkGetImageMemoryRequirements(this, image.L, it.adr) }

fun VkDevice.getImageMemoryRequirements2(info: VkImageMemoryRequirementsInfo2, memoryRequirements: VkMemoryRequirements2 = vk.MemoryRequirements2()): VkMemoryRequirements2 =
        memoryRequirements.also { VK11.nvkGetImageMemoryRequirements2(this, info.adr, it.adr) }

fun VkDevice.getImageMemoryRequirements2KHR(info: VkImageMemoryRequirementsInfo2, memoryRequirements: VkMemoryRequirements2 = vk.MemoryRequirements2()): VkMemoryRequirements2 =
        memoryRequirements.also { KHRGetMemoryRequirements2.nvkGetImageMemoryRequirements2KHR(this, info.adr, it.adr) }

fun VkDevice.getImageSparseMemoryRequirements(image: VkImage, sparseMemoryRequirements: VkSparseImageMemoryRequirements.Buffer) =
        stak.intAddress(sparseMemoryRequirements.rem) { VK10.nvkGetImageSparseMemoryRequirements(this, image.L, it, NULL) }

inline fun <reified T> VkDevice.getImageSparseMemoryRequirements(image: VkImage): T = when (T::class) {
    Int::class -> stak.intAddress { VK10.nvkGetImageSparseMemoryRequirements(this, image.L, it, NULL) } as T
    VkSparseImageMemoryRequirements.Buffer::class -> stak { st ->
        val pSparseMemoryRequirementCount = st.nmalloc(4, Int.BYTES)
        VK10.nvkGetImageSparseMemoryRequirements(this, image.L, pSparseMemoryRequirementCount, NULL)
        st.SparseImageMemoryRequirements(memGetInt(pSparseMemoryRequirementCount)).also {
            VK10.nvkGetImageSparseMemoryRequirements(this, image.L, pSparseMemoryRequirementCount, it.adr)
        }
    } as T
    else -> throw Exception("[VkDevice::getImageSparseMemoryRequirements] Invalid T")
}

fun VkDevice.getImageSparseMemoryRequirements2(image: VkImage, sparseMemoryRequirements: VkSparseImageMemoryRequirements2.Buffer) =
        stak.intAddress(sparseMemoryRequirements.rem) { VK11.nvkGetImageSparseMemoryRequirements2(this, image.L, it, NULL) }

inline fun <reified T> VkDevice.getImageSparseMemoryRequirements2(image: VkImage): T = when (T::class) {
    Int::class -> stak.intAddress { VK11.nvkGetImageSparseMemoryRequirements2(this, image.L, it, NULL) } as T
    VkSparseImageMemoryRequirements2.Buffer::class -> stak { st ->
        val pSparseMemoryRequirementCount = st.nmalloc(4, Int.BYTES)
        VK11.nvkGetImageSparseMemoryRequirements2(this, image.L, pSparseMemoryRequirementCount, NULL)
        st.SparseImageMemoryRequirements2(memGetInt(pSparseMemoryRequirementCount)).also {
            VK11.nvkGetImageSparseMemoryRequirements2(this, image.L, pSparseMemoryRequirementCount, it.adr)
        }
    } as T
    else -> throw Exception("[VkDevice::getImageSparseMemoryRequirements] Invalid T")
}

fun VkDevice.getImageSparseMemoryRequirements2KHR(image: VkImage, sparseMemoryRequirements: VkSparseImageMemoryRequirements2.Buffer) =
        stak.intAddress(sparseMemoryRequirements.rem) { KHRGetMemoryRequirements2.nvkGetImageSparseMemoryRequirements2KHR(this, image.L, it, NULL) }

inline fun <reified T> VkDevice.getImageSparseMemoryRequirements2KHR(image: VkImage): T = when (T::class) {
    Int::class -> stak.intAddress { KHRGetMemoryRequirements2.nvkGetImageSparseMemoryRequirements2KHR(this, image.L, it, NULL) } as T
    VkSparseImageMemoryRequirements2.Buffer::class -> stak { st ->
        val pSparseMemoryRequirementCount = st.nmalloc(4, Int.BYTES)
        KHRGetMemoryRequirements2.nvkGetImageSparseMemoryRequirements2KHR(this, image.L, pSparseMemoryRequirementCount, NULL)
        st.SparseImageMemoryRequirements2(memGetInt(pSparseMemoryRequirementCount)).also {
            KHRGetMemoryRequirements2.nvkGetImageSparseMemoryRequirements2KHR(this, image.L, pSparseMemoryRequirementCount, it.adr)
        }
    } as T
    else -> throw Exception("[VkDevice::getImageSparseMemoryRequirements] Invalid T")
}

fun VkDevice.getImageSubresourceLayout(image: VkImage, subresource: VkImageSubresource, layout: VkSubresourceLayout = vk.SubresourceLayout()): VkSubresourceLayout =
        layout.also { VK10.nvkGetImageSubresourceLayout(this, image.L, subresource.adr, it.adr) }

/** @return fd  */
infix fun VkDevice.getMemoryFdKHR(getFdInfo: VkMemoryGetFdInfoKHR): Int =
        stak.intAddress { VK_CHECK_RESULT(KHRExternalMemoryFd.nvkGetMemoryFdKHR(this, getFdInfo.adr, it)) }

fun VkDevice.getMemoryFdKHR(handleType: VkExternalMemoryHandleType, fd: Int, memoryFdProperties: VkMemoryFdPropertiesKHR = vk.MemoryFdPropertiesKHR()): VkMemoryFdPropertiesKHR =
        memoryFdProperties.also { VK_CHECK_RESULT(KHRExternalMemoryFd.nvkGetMemoryFdPropertiesKHR(this, handleType.i, fd, it.adr)) }

fun VkDevice.getMemoryHostPointerPropertiesEXT(handleType: VkExternalMemoryHandleType, hostPointer: Ptr, memoryHostPointerProperties: VkMemoryHostPointerPropertiesEXT = vk.MemoryHostPointerPropertiesEXT()): VkMemoryHostPointerPropertiesEXT =
        memoryHostPointerProperties.also { VK_CHECK_RESULT(EXTExternalMemoryHost.nvkGetMemoryHostPointerPropertiesEXT(this, handleType.i, hostPointer, it.adr)) }

infix fun VkDevice.getMemoryWin32HandleKHR(getWin32HandleInfo: VkMemoryGetWin32HandleInfoKHR): HANDLE =
        HANDLE(stak.pointerAddress { VK_CHECK_RESULT(KHRExternalMemoryWin32.nvkGetMemoryWin32HandleKHR(this, getWin32HandleInfo.adr, it)) })

fun VkDevice.getMemoryWin32HandleNV(memory: VkDeviceMemory, handleType: VkExternalMemoryHandleTypeFlagsNV): HANDLE =
        HANDLE(stak.pointerAddress { VK_CHECK_RESULT(NVExternalMemoryWin32.nvkGetMemoryWin32HandleNV(this, memory.L, handleType, it)) })

fun VkDevice.getMemoryWin32HandlePropertiesKHR(handleType: VkExternalMemoryHandleType, handle: HANDLE, memoryWin32HandleProperties: VkMemoryWin32HandlePropertiesKHR = vk.MemoryWin32HandlePropertiesKHR()): VkMemoryWin32HandlePropertiesKHR =
        memoryWin32HandleProperties.also { VK_CHECK_RESULT(KHRExternalMemoryWin32.nvkGetMemoryWin32HandlePropertiesKHR(this, handleType.i, handle.L, it.adr)) }


fun VkDevice.getPastPresentationTimingGOOGLE(swapchain: VkSwapchainKHR, physicalDeviceGroupProperties: VkPhysicalDeviceGroupProperties.Buffer): VkResult =
        stak.intAddress(physicalDeviceGroupProperties.rem) {
            VkResult(GOOGLEDisplayTiming.nvkGetPastPresentationTimingGOOGLE(this, swapchain.L, it, physicalDeviceGroupProperties.adr))
        }.apply { check() }

inline fun <reified T> VkDevice.getPastPresentationTimingGOOGLE(swapchain: VkSwapchainKHR): T = when (T::class) {
    Int::class -> stak.intAddress {
        VK_CHECK_RESULT(GOOGLEDisplayTiming.nvkGetPastPresentationTimingGOOGLE(this, swapchain.L, it, NULL))
    } as T
    VkPastPresentationTimingGOOGLE.Buffer::class -> stak {
        lateinit var presentationTimings: VkPastPresentationTimingGOOGLE.Buffer
        val pPresentationTimingCount = it.nmalloc(4, Int.BYTES)
        var result: VkResult
        do {
            result = VkResult(GOOGLEDisplayTiming.nvkGetPastPresentationTimingGOOGLE(this, swapchain.L, pPresentationTimingCount, NULL))
            val presentationTimingCount = memGetInt(pPresentationTimingCount)
            if (result == VkResult.SUCCESS && presentationTimingCount != 0) {
                presentationTimings = it.PastPresentationTimingGOOGLE(presentationTimingCount)
                result = VkResult(GOOGLEDisplayTiming.nvkGetPastPresentationTimingGOOGLE(this, swapchain.L, pPresentationTimingCount, presentationTimings.adr))
            }
        } while (result == VkResult.INCOMPLETE)
        presentationTimings as T
    }
    else -> throw Exception("[VkDevice::getPastPresentationTimingGOOGLE] Invalid T")
}


fun VkDevice.getPipelineCacheData(pipelineCache: VkPipelineCache, data: ByteBuffer): VkResult =
        stak.longAddress(data.rem.L) {
            VkResult(VK10.nvkGetPipelineCacheData(this, pipelineCache.L, it, data.adr))
        }.apply { check() }

inline fun <reified T> VkDevice.getPipelineCacheData(pipelineCache: VkPipelineCache): T = when (T::class) {
    Int::class -> stak.longAddress {
        VK_CHECK_RESULT(VK10.nvkGetPipelineCacheData(this, pipelineCache.L, it, NULL))
    }.i as T
    ByteBuffer::class -> stak {
        lateinit var data: ByteBuffer
        val pDataSize = it.nmalloc(8, Long.BYTES)
        var result: VkResult
        do {
            result = VkResult(VK10.nvkGetPipelineCacheData(this, pipelineCache.L, pDataSize, NULL))
            val presentationTimingCount = memGetLong(pDataSize).i
            if (result == VkResult.SUCCESS && presentationTimingCount != 0) {
                data = it.Buffer(presentationTimingCount)
                result = VkResult(VK10.nvkGetPipelineCacheData(this, pipelineCache.L, pDataSize, data.adr))
            }
        } while (result == VkResult.INCOMPLETE)
        data as T
    }
    else -> throw Exception("[VkDevice::getPipelineCacheData] Invalid T")
}


fun VkDevice.getQueryPoolResults(queryPool: VkQueryPool, firstQuery: Int, queryCount: Int, data: IntBuffer, stride: VkDeviceSize = VkDeviceSize(0), flags: VkQueryResultFlags = 0): VkResult =
        VkResult(VK10.nvkGetQueryPoolResults(this, queryPool.L, firstQuery, queryCount, data.rem.L, data.adr, stride.L, flags)).apply { check() }

fun VkDevice.getRayTracingShaderGroupHandlesNV(pipeline: VkPipeline, firstGroup: Int, groupCount: Int, data: ByteBuffer): VkResult =
        VkResult(NVRayTracing.nvkGetRayTracingShaderGroupHandlesNV(this, pipeline.L, firstGroup, groupCount, data.rem.L, data.adr)).apply { check() }

fun VkDevice.getRefreshCycleDurationGOOGLE(swapchain: VkSwapchainKHR, displayTimingProperties: VkRefreshCycleDurationGOOGLE = vk.RefreshCycleDurationGOOGLE()): VkResult =
        VkResult(GOOGLEDisplayTiming.nvkGetRefreshCycleDurationGOOGLE(this, swapchain.L, displayTimingProperties.adr)).apply { check() }

fun VkDevice.getRenderAreaGranularity(renderPass: VkRenderPass, granularity: VkExtent2D = vk.Extent2D()): VkExtent2D =
        granularity.also { VK10.nvkGetRenderAreaGranularity(this, renderPass.L, it.adr) }

infix fun VkDevice.getSemaphoreFdKHR(renderPass: VkRenderPass): Int =
        stak.intAddress { VK_CHECK_RESULT(KHRExternalSemaphoreFd.nvkGetSemaphoreFdKHR(this, renderPass.L, it)) }

infix fun VkDevice.getSemaphoreWin32HandleKHR(getWin32HandleInfo: VkSemaphoreGetWin32HandleInfoKHR): HANDLE =
        HANDLE(stak.pointerAddress {
            VK_CHECK_RESULT(KHRExternalSemaphoreWin32.nvkGetSemaphoreWin32HandleKHR(this, getWin32HandleInfo.adr, it))
        })


fun VkDevice.getShaderInfoAMD(pipeline: VkPipeline, shaderStage: VkShaderStage, infoType: VkShaderInfoTypeAMD, info: ByteBuffer): VkResult =
        stak.longAddress(info.rem.L) {
            VkResult(AMDShaderInfo.nvkGetShaderInfoAMD(this, pipeline.L, shaderStage.i, infoType.i, it, info.adr))
        }.apply { check() }

inline fun <reified T> VkDevice.getShaderInfoAMD(pipeline: VkPipeline, shaderStage: VkShaderStage, infoType: VkShaderInfoTypeAMD): T = when (T::class) {
    Int::class -> stak.longAddress {
        VK_CHECK_RESULT(AMDShaderInfo.nvkGetShaderInfoAMD(this, pipeline.L, shaderStage.i, infoType.i, it, NULL))
    }.i as T
    ByteBuffer::class -> stak {
        lateinit var data: ByteBuffer
        val pDataSize = it.nmalloc(8, Long.BYTES)
        var result: VkResult
        do {
            result = VkResult(AMDShaderInfo.nvkGetShaderInfoAMD(this, pipeline.L, shaderStage.i, infoType.i, pDataSize, NULL))
            val dataSize = memGetLong(pDataSize).i
            if (result == VkResult.SUCCESS && dataSize != 0) {
                data = it.Buffer(dataSize)
                result = VkResult(AMDShaderInfo.nvkGetShaderInfoAMD(this, pipeline.L, shaderStage.i, infoType.i, pDataSize, data.adr))
            }
        } while (result == VkResult.INCOMPLETE)
        data as T
    }
    else -> throw Exception("[VkDevice::getShaderInfoAMD] Invalid T")
}


fun VkDevice.getSwapchainCounterEXT(swapchain: VkSwapchainKHR, counter: VkSurfaceCounterFlagsEXT): Long =
        stak.longAddress {
            VK_CHECK_RESULT(EXTDisplayControl.nvkGetSwapchainCounterEXT(this, swapchain.L, counter, it))
        }


fun VkDevice.getSwapchainImagesKHR(swapchain: VkSwapchainKHR, swapchainImages: VkImage_Buffer): VkResult =
        stak.intAddress(swapchainImages.rem) {
            VkResult(KHRSwapchain.nvkGetSwapchainImagesKHR(this, swapchain.L, it, swapchainImages.adr))
        }.apply { check() }

inline fun <reified T> VkDevice.getSwapchainImagesKHR(swapchain: VkSwapchainKHR): T = when (T::class) {
    Int::class -> stak.intAddress {
        VK_CHECK_RESULT(KHRSwapchain.nvkGetSwapchainImagesKHR(this, swapchain.L, it, NULL))
    } as T
    VkImage_Buffer::class -> stak {
        lateinit var swapchainImages: LongBuffer
        val pSwapchainImageCount = it.nmalloc(4, Int.BYTES)
        var result: VkResult
        do {
            result = VkResult(KHRSwapchain.nvkGetSwapchainImagesKHR(this, swapchain.L, pSwapchainImageCount, NULL))
            val swapchainImageCount = memGetInt(pSwapchainImageCount)
            if (result == VkResult.SUCCESS && swapchainImageCount != 0) {
                swapchainImages = it.LongBuffer(swapchainImageCount)
                result = VkResult(KHRSwapchain.nvkGetSwapchainImagesKHR(this, swapchain.L, pSwapchainImageCount, swapchainImages.adr))
            }
        } while (result == VkResult.INCOMPLETE)
        VkImage_Buffer(swapchainImages) as T
    }
    else -> throw Exception("[VkDevice::getSwapchainImagesKHR] Invalid T")
}


infix fun VkDevice.getSwapchainStatusKHR(swapchain: VkSwapchainKHR): VkResult =
        VkResult(KHRSharedPresentableImage.vkGetSwapchainStatusKHR(this, swapchain.L)).apply { check() }


fun VkDevice.getValidationCacheDataEXT(validationCache: VkValidationCacheEXT, data: ByteBuffer): VkResult =
        stak.longAddress(data.rem.L) {
            VkResult(EXTValidationCache.nvkGetValidationCacheDataEXT(this, validationCache.L, it, data.adr))
        }.apply { check() }

inline fun <reified T> VkDevice.getValidationCacheDataEXT(swapchain: VkSwapchainKHR): T = when (T::class) {
    Int::class -> stak.longAddress {
        VK_CHECK_RESULT(EXTValidationCache.nvkGetValidationCacheDataEXT(this, swapchain.L, it, NULL))
    }.i as T
    ByteBuffer::class -> stak {
        lateinit var swapchainImages: ByteBuffer
        val pSwapchainImageCount = it.nmalloc(8, Long.BYTES)
        var result: VkResult
        do {
            result = VkResult(EXTValidationCache.nvkGetValidationCacheDataEXT(this, swapchain.L, pSwapchainImageCount, NULL))
            val swapchainImageCount = memGetLong(pSwapchainImageCount).i
            if (result == VkResult.SUCCESS && swapchainImageCount != 0) {
                swapchainImages = it.Buffer(swapchainImageCount)
                result = VkResult(EXTValidationCache.nvkGetValidationCacheDataEXT(this, swapchain.L, pSwapchainImageCount, swapchainImages.adr))
            }
        } while (result == VkResult.INCOMPLETE)
        swapchainImages as T
    }
    else -> throw Exception("[VkDevice::getValidationCacheDataEXT] Invalid T")
}


infix fun VkDevice.importFenceFdKHR(importFenceFdInfo: VkImportFenceFdInfoKHR): VkResult =
        VkResult(KHRExternalFenceFd.nvkImportFenceFdKHR(this, importFenceFdInfo.adr)).apply { check() }

infix fun VkDevice.importFenceWin32HandleKHR(importFenceWin32HandleInfo: VkImportFenceWin32HandleInfoKHR): VkResult =
        VkResult(KHRExternalFenceWin32.nvkImportFenceWin32HandleKHR(this, importFenceWin32HandleInfo.adr)).apply { check() }

infix fun VkDevice.importSemaphoreFdKHR(importSemaphoreFdInfo: VkImportSemaphoreFdInfoKHR): VkResult =
        VkResult(KHRExternalSemaphoreFd.nvkImportSemaphoreFdKHR(this, importSemaphoreFdInfo.adr)).apply { check() }

infix fun VkDevice.importSemaphoreWin32HandleKHR(importSemaphoreWin32HandleInfo: VkImportSemaphoreWin32HandleInfoKHR): VkResult =
        VkResult(KHRExternalSemaphoreWin32.nvkImportSemaphoreWin32HandleKHR(this, importSemaphoreWin32HandleInfo.adr)).apply { check() }


infix fun VkDevice.invalidateMappedMemoryRanges(memoryRanges: VkMappedMemoryRange.Buffer): VkResult =
        VkResult(VK10.nvkInvalidateMappedMemoryRanges(this, memoryRanges.rem, memoryRanges.adr)).apply { check() }

infix fun VkDevice.invalidateMappedMemoryRanges(memoryRange: VkMappedMemoryRange): VkResult =
        VkResult(VK10.nvkInvalidateMappedMemoryRanges(this, 1, memoryRange.adr)).apply { check() }


fun VkDevice.mapMemory(memory: VkDeviceMemory, offset: VkDeviceSize, size: VkDeviceSize, flags: VkMemoryMapFlags, data: PointerBuffer): VkResult =
        VkResult(VK10.nvkMapMemory(this, memory.L, offset.L, size.L, flags, data.adr)).apply { check() }

fun VkDevice.mapMemory(memory: VkDeviceMemory, offset: VkDeviceSize, size: VkDeviceSize, flags: VkMemoryMapFlags = 0): Ptr =
        stak.pointerAddress { data -> VK_CHECK_RESULT(VK10.nvkMapMemory(this, memory.L, offset.L, size.L, flags, data)) }


fun VkDevice.mergePipelineCaches(dstCache: VkPipelineCache, srcCaches: VkPipelineCache_Buffer): VkResult =
        VkResult(VK10.nvkMergePipelineCaches(this, dstCache.L, srcCaches.rem, srcCaches.adr)).apply { check() }

fun VkDevice.mergeValidationCachesEXT(dstCache: VkValidationCacheEXT, srcCaches: VkValidationCacheEXT_Buffer): VkResult =
        VkResult(EXTValidationCache.nvkMergeValidationCachesEXT(this, dstCache.L, srcCaches.rem, srcCaches.adr)).apply { check() }

infix fun VkDevice.registerEventEXT(deviceEventInfo: VkDeviceEventInfoEXT): VkFence =
        VkFence(stak.longAddress {
            EXTDisplayControl.nvkRegisterDeviceEventEXT(this, deviceEventInfo.adr, NULL, it)
        })

fun VkDevice.registerDisplayEventEXT(display: VkDisplayKHR, displayEventInfo: VkDisplayEventInfoEXT): VkFence =
        VkFence(stak.longAddress {
            EXTDisplayControl.nvkRegisterDisplayEventEXT(this, display.L, displayEventInfo.adr, NULL, it)
        })

// TODO evaluate what to do best with ppObjectTableEntries
//fun VkDevice.registerObjectsNVX(objectTable: VkObjectTableNVX, "VkObjectTableEntryNVX const * const *") PointerBuffer ppObjectTableEntries, @NativeType("uint32_t const *") IntBuffer pObjectIndices): VkFence =
//        VkFence(stak.longAddress {
//            NVXDeviceGeneratedCommands.nvkRegisterObjectsNVX(this, display.L, displayEventInfo.adr, NULL, it)
//        })


fun VkDevice.resetCommandPool(commandPool: VkCommandPool, flags: VkCommandPoolResetFlags = 0): VkResult =
        VkResult(VK10.vkResetCommandPool(this, commandPool.L, flags)).apply { check() }

fun VkDevice.resetDescriptorPool(descriptorPool: VkDescriptorPool, flags: VkDescriptorPoolResetFlags = 0): VkResult =
        VkResult(VK10.vkResetDescriptorPool(this, descriptorPool.L, flags)).apply { check() }

infix fun VkDevice.resetEvent(event: VkEvent): VkResult =
        VkResult(VK10.vkResetEvent(this, event.L)).apply { check() }

infix fun VkDevice.resetFences(fence: VkFence): VkResult =
        VkResult(stak.longAddress(fence.L) { VK10.nvkResetFences(this, 1, it) }).apply { check() }

infix fun VkDevice.resetFences(fences: VkFence_Buffer): VkResult =
        VkResult(VK10.nvkResetFences(this, fences.rem, fences.adr)).apply { check() }

infix fun VkDevice.setDebugUtilsObjectNameEXT(nameInfo: VkDebugUtilsObjectNameInfoEXT): VkResult =
        VkResult(EXTDebugUtils.nvkSetDebugUtilsObjectNameEXT(this, nameInfo.adr)).apply { check() }

infix fun VkDevice.setDebugUtilsObjectTagEXT(tagInfo: VkDebugUtilsObjectTagInfoEXT): VkResult =
        VkResult(EXTDebugUtils.nvkSetDebugUtilsObjectTagEXT(this, tagInfo.adr)).apply { check() }

infix fun VkDevice.setEvent(event: VkEvent): VkResult =
        VkResult(VK10.vkSetEvent(this, event.L)).apply { check() }

fun VkDevice.setHdrMetadataEXT(swapchains: VkSwapchainKHR_Buffer, metadata: VkHdrMetadataEXT.Buffer) =
        EXTHdrMetadata.nvkSetHdrMetadataEXT(this, swapchains.rem, swapchains.adr, metadata.adr)

fun VkDevice.trimCommandPool(commandPool: VkCommandPool, flags: VkCommandPoolTrimFlags = 0) =
        VK11.vkTrimCommandPool(this, commandPool.L, flags)

fun VkDevice.trimCommandPoolKHR(commandPool: VkCommandPool, flags: VkCommandPoolTrimFlags = 0) =
        KHRMaintenance1.vkTrimCommandPoolKHR(this, commandPool.L, flags)

infix fun VkDevice.unmapMemory(memory: VkDeviceMemory) =
        VK10.vkUnmapMemory(this, memory.L)

fun VkDevice.unregisterObjectsNVX(objectTable: VkObjectTableNVX, objectEntryTypes: VkObjectEntryTypeNVX_Buffer, objectIndices: IntBuffer): VkResult =
        VkResult(NVXDeviceGeneratedCommands.nvkUnregisterObjectsNVX(this, objectTable.L, objectEntryTypes.rem, objectEntryTypes.adr, objectIndices.adr)).apply { check() }

fun VkDevice.updateDescriptorSetWithTemplate(descriptorSet: VkDescriptorSet, descriptorUpdateTemplate: VkDescriptorUpdateTemplate, data: ByteBuffer) =
        VK11.vkUpdateDescriptorSetWithTemplate(this, descriptorSet.L, descriptorUpdateTemplate.L, data.adr)

fun VkDevice.updateDescriptorSetWithTemplateKHR(descriptorSet: VkDescriptorSet, descriptorUpdateTemplate: VkDescriptorUpdateTemplate, data: ByteBuffer) =
        KHRDescriptorUpdateTemplate.vkUpdateDescriptorSetWithTemplateKHR(this, descriptorSet.L, descriptorUpdateTemplate.L, data.adr)

fun VkDevice.updateDescriptorSets(descriptorWrites: VkWriteDescriptorSet.Buffer? = null, descriptorCopies: VkCopyDescriptorSet.Buffer? = null) =
        VK10.nvkUpdateDescriptorSets(this, descriptorWrites?.rem ?: 0, descriptorWrites?.adr
                ?: NULL, descriptorCopies?.rem ?: 0, descriptorCopies?.adr ?: NULL)

fun VkDevice.updateDescriptorSets(descriptorWrite: VkWriteDescriptorSet? = null, descriptorCopy: VkCopyDescriptorSet? = null) =
        VK10.nvkUpdateDescriptorSets(this, if(descriptorWrite == null) 0 else 1, descriptorWrite?.adr
                ?: NULL, if(descriptorCopy == null) 0 else 1, descriptorCopy?.adr ?: NULL)

fun VkDevice.waitForFences(fences: VkFence_Buffer, waitAll: Boolean, timeout: NanoSecond): VkResult =
        VkResult(VK10.nvkWaitForFences(this, fences.rem, fences.adr, waitAll.i, timeout.L)).apply { check() }

fun VkDevice.waitForFences(fence: VkFence, waitAll: Boolean, timeout: NanoSecond): VkResult =
        VkResult(stak.longAddress(fence.L) { VK10.nvkWaitForFences(this, 1, it, waitAll.i, timeout.L) }).apply { check() }

// ----------------------------------

infix fun VkDevice.newCommandBuffer(commandPool: VkCommandPool): VkCommandBuffer = newCommandBuffer(commandPool, VkCommandBufferLevel.PRIMARY)

fun VkDevice.newCommandBuffer(commandPool: VkCommandPool, level: VkCommandBufferLevel = VkCommandBufferLevel.PRIMARY, autostart: Boolean = false): VkCommandBuffer {
    val cmdBufAllocateInfo = vk.CommandBufferAllocateInfo(commandPool, level, 1)
    return allocateCommandBuffers<VkCommandBuffer>(cmdBufAllocateInfo).apply { if (autostart) begin() }
}

inline fun VkDevice.mappedMemory(memory: VkDeviceMemory, offset: VkDeviceSize, size: VkDeviceSize, flags: VkMemoryMapFlags = 0, block: (Ptr) -> Unit) = stak.pointerAddress { data ->
    VK_CHECK_RESULT(VK10.nvkMapMemory(this, memory.L, offset.L, size.L, flags, data))
    block(memGetAddress(data))
    VK10.vkUnmapMemory(this, memory.L)
}


//inline fun VkDevice.updateDescriptorSets(descriptorWrites: VkWriteDescriptorSet.Buffer,
//                                descriptorCopies: VkCopyDescriptorSet.Buffer? = null) {
//    VK10.nvkUpdateDescriptorSets(device, descriptorWrites.remaining(), descriptorWrites.adr,
//            descriptorCopies?.remaining() ?: 0, descriptorCopies?.adr ?: NULL)
//}


inline fun VkDevice.withFence(flags: VkFenceCreateFlags = 0, block: (VkFence) -> Unit) {
    val fence = createFence(flags)
    block(fence)
    destroyFence(fence)
}


// ---------- VkResult ---------

/** @return ImageIndex */
inline fun VkDevice.acquireNextImageKHR(swapchain: VkSwapchainKHR, timeout: Long, semaphore: VkSemaphore, fence: VkFence = VkFence(NULL),
                                        block: (VkResult) -> Unit): Int =
        stak.intAddress {
            val res = KHRSwapchain.nvkAcquireNextImageKHR(this, swapchain.L, timeout, semaphore.L, fence.L, it)
            block(VkResult(res))
        }

/** @return ImageIndex */
inline fun VkDevice.acquireNextImage2KHR(acquireInfo: VkAcquireNextImageInfoKHR, block: (VkResult) -> Unit): Int =
        stak.intAddress {
            val res = KHRSwapchain.nvkAcquireNextImage2KHR(this, acquireInfo.adr, it)
            block(VkResult(res))
        }

inline fun VkDevice.allocateMemory(allocateInfo: VkMemoryAllocateInfo, block: (VkResult) -> Unit): VkDeviceMemory =
        VkDeviceMemory(stak.longAddress {
            val res = VK10.nvkAllocateMemory(this, allocateInfo.adr, NULL, it)
            block(VkResult(res))
        })