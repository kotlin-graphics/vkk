package vkk.extensionFunctions

import glm_.BYTES
import glm_.L
import glm_.i
import kool.Ptr
import kool.adr
import kool.rem
import kool.stak
import org.lwjgl.PointerBuffer
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.system.Pointer
import org.lwjgl.vulkan.*
import vkk.*
import vkk.entities.*
import java.nio.IntBuffer


/** @return ImageIndex */
fun VkDevice.acquireNextImageKHR(swapchain: VkSwapchainKHR, timeout: Long, semaphore: VkSemaphore, fence: VkFence = VkFence(NULL)): Int =
        stak.intAddress { VK_CHECK_RESULT(KHRSwapchain.nvkAcquireNextImageKHR(this, swapchain.L, timeout, semaphore.L, fence.L, it)) }

/** @return ImageIndex */
fun VkDevice.acquireNextImage2KHR(acquireInfo: VkAcquireNextImageInfoKHR): Int =
        stak.intAddress { VK_CHECK_RESULT(KHRSwapchain.nvkAcquireNextImage2KHR(this, acquireInfo.adr, it)) }

inline infix fun <reified C> VkDevice.allocateCommandBuffers(allocateInfo: VkCommandBufferAllocateInfo): C =
        stak {
            val count = allocateInfo.commandBufferCount
            val pCommandBuffers = it.nmalloc(Pointer.POINTER_SIZE, count * Pointer.POINTER_SIZE)
            VK_CHECK_RESULT(VK10.nvkAllocateCommandBuffers(this, allocateInfo.adr, pCommandBuffers))
            when (C::class) {
                VkCommandBuffer::class -> VkCommandBuffer(memGetLong(pCommandBuffers), this) as C
                Array<VkCommandBuffer>::class -> Array(count) { VkCommandBuffer(memGetAddress(pCommandBuffers + Pointer.POINTER_SIZE * it), this) } as C
                ArrayList::class -> {
                    val res = ArrayList<VkCommandBuffer>(count)
                    for (i in 0 until count)
                        res += VkCommandBuffer(memGetAddress(pCommandBuffers + Pointer.POINTER_SIZE * i), this)
                    res as C
                }
                List::class -> List(count) { VkCommandBuffer(memGetAddress(pCommandBuffers + Pointer.POINTER_SIZE * it), this) } as C
                else -> throw Exception("Invalid")
            }
        }

inline infix fun VkDevice.allocateDescriptorSet(allocateInfo: VkDescriptorSetAllocateInfo): VkDescriptorSet =
        VkDescriptorSet(stak.longAddress { VK_CHECK_RESULT(VK10.nvkAllocateDescriptorSets(this, allocateInfo.adr, it)) })

inline infix fun <reified C> VkDevice.allocateDescriptorSets(allocateInfo: VkDescriptorSetAllocateInfo): C =
        stak {
            val count = allocateInfo.descriptorSetCount
            val pDescriptorSets = it.nmalloc(8, count * Long.BYTES)
            VK_CHECK_RESULT(VK10.nvkAllocateDescriptorSets(this, allocateInfo.adr, pDescriptorSets))
            when (C::class) {
                VkDescriptorSet::class -> VkDescriptorSet(memGetLong(pDescriptorSets)) as C
                VkDescriptorSet_Array::class -> VkDescriptorSet_Array(
                        LongArray(count) { memGetLong(pDescriptorSets + Long.BYTES * it) }) as C
                ArrayList::class -> {
                    val res = ArrayList<VkDescriptorSet>(count)
                    for (i in 0 until count)
                        res += VkDescriptorSet(memGetLong(pDescriptorSets + Long.BYTES * i))
                    res as C
                }
                List::class -> List(count) { VkDescriptorSet(memGetLong(pDescriptorSets + Long.BYTES * it)) } as C
                else -> throw Exception("Invalid")
            }
        }

infix fun VkDevice.allocateMemory(allocateInfo: VkMemoryAllocateInfo): VkDeviceMemory =
        VkDeviceMemory(stak.longAddress { VK_CHECK_RESULT(VK10.nvkAllocateMemory(this, allocateInfo.adr, NULL, it)) })

infix fun VkDevice.bindAccelerationStructureMemoryNV(bindInfos: VkBindAccelerationStructureMemoryInfoNV.Buffer) =
        VK_CHECK_RESULT(NVRayTracing.nvkBindAccelerationStructureMemoryNV(this, bindInfos.rem, bindInfos.adr))

fun VkDevice.bindBufferMemory(buffer: VkBuffer, memory: VkDeviceMemory, memoryOffset: VkDeviceSize = VkDeviceSize(0)) =
        VK_CHECK_RESULT(VK10.vkBindBufferMemory(this, buffer.L, memory.L, memoryOffset.L))

infix fun VkDevice.bindBufferMemory2(bindInfos: VkBindBufferMemoryInfo.Buffer) =
        VK_CHECK_RESULT(VK11.nvkBindBufferMemory2(this, bindInfos.rem, bindInfos.adr))

infix fun VkDevice.bindBufferMemory2KHR(bindInfos: VkBindBufferMemoryInfo.Buffer) =
        VK_CHECK_RESULT(KHRBindMemory2.nvkBindBufferMemory2KHR(this, bindInfos.rem, bindInfos.adr))

fun VkDevice.bindImageMemory(image: VkImage, memory: VkDeviceMemory, memoryOffset: VkDeviceSize = VkDeviceSize(0)) =
        VK_CHECK_RESULT(VK10.vkBindImageMemory(this, image.L, memory.L, memoryOffset.L))

fun VkDevice.bindImageMemory2(bindInfos: VkBindImageMemoryInfo.Buffer) =
        VK_CHECK_RESULT(VK11.nvkBindImageMemory2(this, bindInfos.rem, bindInfos.adr))

infix fun VkDevice.bindImageMemory2KHR(bindInfos: VkBindImageMemoryInfo.Buffer) =
        VK_CHECK_RESULT(KHRBindMemory2.nvkBindImageMemory2KHR(this, bindInfos.rem, bindInfos.adr))

fun VkDevice.compileDeferredNV(pipeline: VkPipeline, shader: Int) =
        VK_CHECK_RESULT(NVRayTracing.vkCompileDeferredNV(this, pipeline.L, shader))

fun VkDevice.createAccelerationStructureNV(createInfo: VkAccelerationStructureCreateInfoNV, accelerationStructure: VkAccelerationStructureNV_Buffer) =
        VK_CHECK_RESULT(NVRayTracing.nvkCreateAccelerationStructureNV(this, createInfo.adr, NULL, accelerationStructure.adr))

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

inline fun <reified C> VkDevice.createComputePipelines(pipelineCache: VkPipelineCache, createInfos: VkComputePipelineCreateInfo.Buffer): C =
        stak {
            val count = createInfos.rem
            val pComputePipelines = it.nmalloc(8, count * Long.BYTES)
            VK_CHECK_RESULT(VK10.nvkCreateComputePipelines(this, pipelineCache.L, count, createInfos.adr, NULL, pComputePipelines))
            when (C::class) {
                VkPipeline::class -> VkPipeline(memGetLong(pComputePipelines)) as C
                VkPipeline_Array::class -> VkPipeline_Array(
                        LongArray(count) { memGetLong(pComputePipelines + Long.BYTES * it) }) as C
                ArrayList::class -> {
                    val res = ArrayList<VkPipeline>(count)
                    for (i in 0 until count)
                        res += VkPipeline(memGetLong(pComputePipelines + Long.BYTES * i))
                    res as C
                }
                List::class -> List(count) { VkPipeline(memGetLong(pComputePipelines + Long.BYTES * it)) } as C
                else -> throw Exception("Invalid")
            }
        }

infix fun VkDevice.createDescriptorPool(createInfo: VkDescriptorPoolCreateInfo): VkDescriptorPool =
        VkDescriptorPool(stak.longAddress { VK_CHECK_RESULT(VK10.nvkCreateDescriptorPool(this, createInfo.adr, NULL, it)) })

infix fun VkDevice.createDescriptorSetLayout(createInfo: VkDescriptorSetLayoutCreateInfo): VkDescriptorSetLayout =
        VkDescriptorSetLayout(stak.longAddress { VK_CHECK_RESULT(VK10.nvkCreateDescriptorSetLayout(this, createInfo.adr, NULL, it)) })

infix fun VkDevice.createDescriptorUpdateTemplate(createInfo: VkDescriptorUpdateTemplateCreateInfo): VkDescriptorUpdateTemplate_Buffer =
        stak {
            val count = createInfo.descriptorUpdateEntryCount
            val buffer = it.mallocLong(count)
            VK_CHECK_RESULT(VK11.vkCreateDescriptorUpdateTemplate(this, createInfo, null, buffer))
            VkDescriptorUpdateTemplate_Buffer(buffer)
        }

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

inline fun <reified C> VkDevice.createGraphicsPipelines(pipelineCache: VkPipelineCache, createInfos: VkGraphicsPipelineCreateInfo.Buffer): C =
        stak {
            val count = createInfos.rem
            val pGraphicPipelines = it.nmalloc(8, count * Long.BYTES)
            VK_CHECK_RESULT(VK10.nvkCreateGraphicsPipelines(this, pipelineCache.L, count, createInfos.adr, NULL, pGraphicPipelines))
            when (C::class) {
                VkPipeline::class -> VkPipeline(memGetLong(pGraphicPipelines)) as C
                VkPipeline_Array::class -> VkPipeline_Array(
                        LongArray(count) { memGetLong(pGraphicPipelines + Long.BYTES * it) }) as C
                ArrayList::class -> {
                    val res = ArrayList<VkPipeline>(count)
                    for (i in 0 until count)
                        res += VkPipeline(memGetLong(pGraphicPipelines + Long.BYTES * i))
                    res as C
                }
                List::class -> List(count) { VkPipeline(memGetLong(pGraphicPipelines + Long.BYTES * it)) } as C
                else -> throw Exception("Invalid")
            }
        }

infix fun VkDevice.createImage(createInfo: VkImageCreateInfo): VkImage =
        VkImage(stak.longAddress { VK_CHECK_RESULT(VK10.nvkCreateImage(this, createInfo.adr, NULL, it)) })

infix fun VkDevice.createImageView(createInfo: VkImageViewCreateInfo): VkImageView =
        VkImageView(stak.longAddress { VK10.nvkCreateImageView(this, createInfo.adr, NULL, it) })

fun VkDevice.createIndirectCommandsLayoutNVX(createInfo: VkIndirectCommandsLayoutCreateInfoNVX, indirectCommandsLayout: VkIndirectCommandsLayoutNVX): VkImageView =
        VkImageView(stak.longAddress { NVXDeviceGeneratedCommands.nvkCreateIndirectCommandsLayoutNVX(this, createInfo.adr, NULL, it) })

fun VkDevice.createPipeline(pipelineCache: VkPipelineCache, createInfo: VkGraphicsPipelineCreateInfo): VkPipeline = VkPipeline(stak.longAddress { VK_CHECK_RESULT(VK10.nvkCreateGraphicsPipelines(this, pipelineCache.L, 1, createInfo.adr, NULL, it)) })

infix fun VkDevice.createPipelineCache(createInfo: VkPipelineCacheCreateInfo): VkPipelineCache = VkPipelineCache(stak.longAddress { VK_CHECK_RESULT(VK10.nvkCreatePipelineCache(this, createInfo.adr, NULL, it)) })

infix fun VkDevice.createPipelineLayout(createInfo: VkPipelineLayoutCreateInfo): VkPipelineLayout = VkPipelineLayout(stak.longAddress { VK_CHECK_RESULT(VK10.nvkCreatePipelineLayout(this, createInfo.adr, NULL, it)) })

infix fun VkDevice.createQueryPool(createInfo: VkQueryPoolCreateInfo): VkQueryPool = VkQueryPool(stak.longAddress { VK_CHECK_RESULT(VK10.nvkCreateQueryPool(this, createInfo.adr, NULL, it)) })

infix fun VkDevice.createRenderPass(createInfo: VkRenderPassCreateInfo): VkRenderPass = VkRenderPass(stak.longAddress { VK_CHECK_RESULT(VK10.nvkCreateRenderPass(this, createInfo.adr, NULL, it)) })

infix fun VkDevice.createSampler(createInfo: VkSamplerCreateInfo): VkSampler = VkSampler(stak.longAddress { VK_CHECK_RESULT(VK10.nvkCreateSampler(this, createInfo.adr, NULL, it)) })

infix fun VkDevice.createSemaphore(createInfo: VkSemaphoreCreateInfo): VkSemaphore = VkSemaphore(stak.longAddress { VK_CHECK_RESULT(VK10.nvkCreateSemaphore(this, createInfo.adr, NULL, it)) })

infix fun VkDevice.createShaderModule(createInfo: VkShaderModuleCreateInfo): VkShaderModule = VkShaderModule(stak.longAddress { VK_CHECK_RESULT(VK10.nvkCreateShaderModule(this, createInfo.adr, NULL, it)) })

infix fun VkDevice.createSwapchainKHR(createInfo: VkSwapchainCreateInfoKHR): VkSwapchainKHR = VkSwapchainKHR(stak.longAddress { KHRSwapchain.nvkCreateSwapchainKHR(this, createInfo.adr, NULL, it) })

infix fun VkDevice.debugMarkerSetObjectName(nameInfo: VkDebugMarkerObjectNameInfoEXT) = EXTDebugMarker.nvkDebugMarkerSetObjectNameEXT(this, nameInfo.adr)

infix fun VkDevice.debugMarkerSetObjectTag(tagInfo: VkDebugMarkerObjectTagInfoEXT) = EXTDebugMarker.nvkDebugMarkerSetObjectTagEXT(this, tagInfo.adr)

infix fun VkDevice.destroyBuffer(buffer: VkBuffer) = VK10.nvkDestroyBuffer(this, buffer.L, NULL)

infix fun VkDevice.destroyCommandPool(commandPool: VkCommandPool) = VK10.nvkDestroyCommandPool(this, commandPool.L, NULL)
fun VkDevice.destroyCommandPools(commandPool0: VkCommandPool, commandPool1: VkCommandPool) {
    VK10.nvkDestroyCommandPool(this, commandPool0.L, NULL)
    VK10.nvkDestroyCommandPool(this, commandPool1.L, NULL)
}

fun VkDevice.destroyCommandPools(commandPool0: VkCommandPool, commandPool1: VkCommandPool, commandPool2: VkCommandPool) {
    VK10.nvkDestroyCommandPool(this, commandPool0.L, NULL)
    VK10.nvkDestroyCommandPool(this, commandPool1.L, NULL)
    VK10.nvkDestroyCommandPool(this, commandPool2.L, NULL)
}

infix fun VkDevice.destroyDescriptorPool(descriptorPool: VkDescriptorPool) = VK10.nvkDestroyDescriptorPool(this, descriptorPool.L, NULL)

infix fun VkDevice.destroyDescriptorSetLayout(descriptorSetLayout: VkDescriptorSetLayout) = VK10.nvkDestroyDescriptorSetLayout(this, descriptorSetLayout.L, NULL)
infix fun VkDevice.destroyDescriptorSetLayouts(descriptorSetLayouts: Collection<VkDescriptorSetLayout>) {
    for (i in descriptorSetLayouts)
        VK10.nvkDestroyDescriptorSetLayout(this, i.L, NULL)
}

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

infix fun VkDevice.destroyQueryPool(queryPool: VkQueryPool) = VK10.nvkDestroyQueryPool(this, queryPool.L, NULL)

infix fun VkDevice.destroyRenderPass(renderPass: VkRenderPass) = VK10.nvkDestroyRenderPass(this, renderPass.L, NULL)

infix fun VkDevice.destroySampler(sampler: VkSampler) = VK10.nvkDestroySampler(this, sampler.L, NULL)

infix fun VkDevice.destroySemaphore(semaphore: VkSemaphore) = VK10.nvkDestroySemaphore(this, semaphore.L, NULL)
infix fun VkDevice.destroySemaphores(semaphores: VkSemaphoreArray) {
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

fun VkDevice.freeCommandBuffers(commandPool: VkCommandPool, commandBuffers: Array<VkCommandBuffer>) = stak {
    val size = commandBuffers.size
    val pointers = it.nmalloc(Pointer.POINTER_SIZE, size * Pointer.POINTER_SIZE)
    for (i in 0 until size)
        memPutAddress(pointers + Pointer.POINTER_SIZE * i, commandBuffers.elementAt(i).adr)
    VK10.nvkFreeCommandBuffers(this, commandPool.L, size, pointers)
}

fun VkDevice.freeCommandBuffers(commandPool: VkCommandPool, commandBuffers: Collection<VkCommandBuffer>) = stak {
    val size = commandBuffers.size
    val pointers = it.nmalloc(Pointer.POINTER_SIZE, size * Pointer.POINTER_SIZE)
    for (i in 0 until size)
        memPutAddress(pointers + Pointer.POINTER_SIZE * i, commandBuffers.elementAt(i).adr)
    VK10.nvkFreeCommandBuffers(this, commandPool.L, size, pointers)
}

infix fun VkDevice.flushMappedMemoryRanges(memoryRange: VkMappedMemoryRange) = VK_CHECK_RESULT(VK10.nvkFlushMappedMemoryRanges(this, 1, memoryRange.adr))

infix fun VkDevice.flushMappedMemoryRanges(memoryRanges: VkMappedMemoryRange.Buffer) = VK_CHECK_RESULT(VK10.nvkFlushMappedMemoryRanges(this, memoryRanges.capacity(), memoryRanges.adr))

fun VkDevice.freeCommandBuffer(commandPool: VkCommandPool, commandBuffer: VkCommandBuffer) = stak.pointerAddress(commandBuffer) { VK10.nvkFreeCommandBuffers(this, commandPool.L, 1, it) }

infix fun VkDevice.freeMemory(memory: VkDeviceMemory) = VK10.nvkFreeMemory(this, memory.L, NULL)

infix fun VkDevice.getBufferMemoryRequirements(buffer: VkBuffer): VkMemoryRequirements = getBufferMemoryRequirements(buffer, vk.MemoryRequirements())

fun VkDevice.getBufferMemoryRequirements(buffer: VkBuffer, memoryRequirements: VkMemoryRequirements): VkMemoryRequirements {
    VK10.nvkGetBufferMemoryRequirements(this, buffer.L, memoryRequirements.adr)
    return memoryRequirements
}

infix fun VkDevice.getCommandBuffer(commandPool: VkCommandPool): VkCommandBuffer = getCommandBuffer(commandPool, VkCommandBufferLevel.PRIMARY)

fun VkDevice.getCommandBuffer(commandPool: VkCommandPool, level: VkCommandBufferLevel = VkCommandBufferLevel.PRIMARY, autostart: Boolean = false): VkCommandBuffer {
    val cmdBufAllocateInfo = vk.CommandBufferAllocateInfo(commandPool, level, 1)
    return allocateCommandBuffers<VkCommandBuffer>(cmdBufAllocateInfo).apply { if (autostart) begin() }
}

infix fun VkDevice.getImageMemoryRequirements(image: VkImage): VkMemoryRequirements = getImageMemoryRequirements(image, vk.MemoryRequirements())

fun VkDevice.getImageMemoryRequirements(image: VkImage, memoryRequirements: VkMemoryRequirements): VkMemoryRequirements = memoryRequirements.also { VK10.nvkGetImageMemoryRequirements(this, image.L, it.adr) }

fun VkDevice.getImageSubresourceLayout(image: VkImage, subresource: VkImageSubresource): VkSubresourceLayout = vk.SubresourceLayout().also { VK10.nvkGetImageSubresourceLayout(this, image.L, subresource.adr, it.adr) }

fun VkDevice.getImageSubresourceLayout(image: VkImage, subresource: VkImageSubresource, layout: VkSubresourceLayout): VkSubresourceLayout = layout.also { VK10.nvkGetImageSubresourceLayout(this, image.L, subresource.adr, it.adr) }

fun VkDevice.getQueryPoolResults(queryPool: VkQueryPool, firstQuery: Int, queryCount: Int, data: IntBuffer, stride: VkDeviceSize = VkDeviceSize(0), flags: VkQueryResultFlags = 0) {
    VK_CHECK_RESULT(VK10.nvkGetQueryPoolResults(this, queryPool.L, firstQuery, queryCount, data.rem.L, data.adr, stride.L, flags))
}

inline fun VkDevice.mappedMemory(memory: VkDeviceMemory, offset: VkDeviceSize, size: VkDeviceSize, flags: VkMemoryMapFlags = 0, block: (Ptr) -> Unit) = stak.pointerAddress { data ->
    VK_CHECK_RESULT(VK10.nvkMapMemory(this, memory.L, offset.L, size.L, flags, data))
    block(memGetAddress(data))
    VK10.vkUnmapMemory(this, memory.L)
}

fun VkDevice.mapMemory(memory: VkDeviceMemory, offset: VkDeviceSize, size: VkDeviceSize, flags: VkMemoryMapFlags = 0): Ptr = stak.pointerAddress { data -> VK_CHECK_RESULT(VK10.nvkMapMemory(this, memory.L, offset.L, size.L, flags, data)) }

fun VkDevice.mapMemory(memory: VkDeviceMemory, offset: VkDeviceSize, size: VkDeviceSize, flags: VkMemoryMapFlags, data: PointerBuffer) = VK_CHECK_RESULT(VK10.nvkMapMemory(this, memory.L, offset.L, size.L, flags, data.adr))

infix fun VkDevice.getQueue(queueFamilyIndex: Int): VkQueue = getQueue(queueFamilyIndex, 0)

fun VkDevice.getQueue(queueFamilyIndex: Int, queueIndex: Int): VkQueue = VkQueue(stak.pointerAddress { VK10.nvkGetDeviceQueue(this, queueFamilyIndex, queueIndex, it) }, this)

infix fun VkDevice.getSwapchainImagesKHR(swapchain: VkSwapchainKHR): VkImageArray = stak {
    val pCount = it.nmalloc(1, Int.BYTES)
    VK_CHECK_RESULT(KHRSwapchain.nvkGetSwapchainImagesKHR(this, swapchain.L, pCount, NULL))
    val count = memGetInt(pCount)
    val images = it.nmalloc(Long.BYTES, count * Long.BYTES)
    VK_CHECK_RESULT(KHRSwapchain.nvkGetSwapchainImagesKHR(this, swapchain.L, pCount, images))
    VkImageArray(count) { i -> VkImage(memGetLong(images + Long.BYTES * i)) }
}

infix fun VkDevice.resetCommandPool(commandPool: VkCommandPool) = resetCommandPool(commandPool, 0)

fun VkDevice.resetCommandPool(commandPool: VkCommandPool, flags: VkCommandPoolResetFlags) = VK_CHECK_RESULT(VK10.vkResetCommandPool(this, commandPool.L, flags))

infix fun VkDevice.resetFence(fence: VkFence) = stak.longAddress(fence.L) { VK10.nvkResetFences(this, 1, it) }

infix fun VkDevice.unmapMemory(memory: VkDeviceMemory) = VK10.vkUnmapMemory(this, memory.L)

infix fun VkDevice.updateDescriptorSets(descriptorWrites: VkWriteDescriptorSet) = VK10.nvkUpdateDescriptorSets(this, 1, descriptorWrites.adr, 0, NULL)

infix fun VkDevice.updateDescriptorSets(descriptorWrites: VkWriteDescriptorSet.Buffer) = VK10.nvkUpdateDescriptorSets(this, descriptorWrites.remaining(), descriptorWrites.adr, 0, NULL)

//inline fun VkDevice.updateDescriptorSets(descriptorWrites: VkWriteDescriptorSet.Buffer,
//                                descriptorCopies: VkCopyDescriptorSet.Buffer? = null) {
//    VK10.nvkUpdateDescriptorSets(device, descriptorWrites.remaining(), descriptorWrites.adr,
//            descriptorCopies?.remaining() ?: 0, descriptorCopies?.adr ?: NULL)
//}

fun VkDevice.waitForFence(fence: VkFence, waitAll: Boolean, timeout: Long) = stak.longAddress(fence.L) { VK_CHECK_RESULT(VK10.nvkWaitForFences(this, 1, it, waitAll.i, timeout)) }

fun VkDevice.waitIdle() = VK_CHECK_RESULT(VK10.vkDeviceWaitIdle(this))

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