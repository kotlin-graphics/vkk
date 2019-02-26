package vkk

import glm_.*
import glm_.vec2.Vec2i
import kool.*
import org.lwjgl.PointerBuffer
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.system.Pointer
import org.lwjgl.vulkan.*
import vkk.entities.*
import vkk.extensionFunctions.begin
import java.nio.Buffer
import java.nio.IntBuffer
import java.nio.LongBuffer



// VkDevice ========================================================================================================

fun VkDevice.acquireNextImageKHR(swapchain: VkSwapchainKHR, timeout: Long, semaphore: VkSemaphore, fence: VkFence = VkFence(NULL)): Int = stak.intAddress { VK_CHECK_RESULT(KHRSwapchain.nvkAcquireNextImageKHR(this, swapchain.L, timeout, semaphore.L, fence.L, it)) }
fun VkDevice.acquireNextImageKHR(swapchain: VkSwapchainKHR, timeout: Long, semaphore: VkSemaphore, fence: VkFence = VkFence(NULL), block: (VkResult) -> Unit): Int = stak.intAddress { block(VkResult(KHRSwapchain.nvkAcquireNextImageKHR(this, swapchain.L, timeout, semaphore.L, fence.L, it))) }

infix fun VkDevice.allocateCommandBuffer(allocateInfo: VkCommandBufferAllocateInfo): VkCommandBuffer = VkCommandBuffer(stak.pointerAddress { VK_CHECK_RESULT(VK10.nvkAllocateCommandBuffers(this, allocateInfo.adr, it)) }, this)

infix fun VkDevice.allocateCommandBuffers(allocateInfo: VkCommandBufferAllocateInfo): Array<VkCommandBuffer> = stak {
    val count = allocateInfo.commandBufferCount
    val pCommandBuffer = it.nmalloc(Pointer.POINTER_SIZE, count * Pointer.POINTER_SIZE)
    VK_CHECK_RESULT(VK10.nvkAllocateCommandBuffers(this, allocateInfo.adr, pCommandBuffer))
    Array(count) { i -> VkCommandBuffer(memGetAddress(pCommandBuffer + Pointer.POINTER_SIZE * i), this) }
}

infix fun VkDevice.allocateDescriptorSets(allocateInfo: VkDescriptorSetAllocateInfo): VkDescriptorSet = VkDescriptorSet(stak.longAddress { VK_CHECK_RESULT(VK10.nvkAllocateDescriptorSets(this, allocateInfo.adr, it)) })

infix fun VkDevice.allocateMemory(allocateInfo: VkMemoryAllocateInfo): VkDeviceMemory = VkDeviceMemory(stak.longAddress { VK_CHECK_RESULT(VK10.nvkAllocateMemory(this, allocateInfo.adr, NULL, it)) })

fun VkDevice.bindBufferMemory(buffer: VkBuffer, memory: VkDeviceMemory, memoryOffset: VkDeviceSize = VkDeviceSize(0)) = VK_CHECK_RESULT(VK10.vkBindBufferMemory(this, buffer.L, memory.L, memoryOffset.L))

fun VkDevice.bindImageMemory(image: VkImage, memory: VkDeviceMemory, memoryOffset: VkDeviceSize = VkDeviceSize(0)) = VK_CHECK_RESULT(VK10.vkBindImageMemory(this, image.L, memory.L, memoryOffset.L))

fun VkDevice.createBuffer(usage: VkBufferUsageFlags, size: VkDeviceSize): VkBuffer = createBuffer(vk.BufferCreateInfo { this.usage = usage; this.size = size })

infix fun VkDevice.createBuffer(createInfo: VkBufferCreateInfo): VkBuffer = VkBuffer(stak.longAddress { VK_CHECK_RESULT(VK10.nvkCreateBuffer(this, createInfo.adr, NULL, it)) })

infix fun VkDevice.createCommandPool(createInfo: VkCommandPoolCreateInfo): VkCommandPool = VkCommandPool(stak.longAddress { VK_CHECK_RESULT(VK10.nvkCreateCommandPool(this, createInfo.adr, NULL, it)) })

fun VkDevice.createComputePipelines(pipelineCache: VkPipelineCache, createInfo: VkComputePipelineCreateInfo): VkPipeline = VkPipeline(stak.longAddress { VK_CHECK_RESULT(VK10.nvkCreateComputePipelines(this, pipelineCache.L, 1, createInfo.adr, NULL, it)) })

infix fun VkDevice.createDescriptorPool(createInfo: VkDescriptorPoolCreateInfo): VkDescriptorPool = VkDescriptorPool(stak.longAddress { VK_CHECK_RESULT(VK10.nvkCreateDescriptorPool(this, createInfo.adr, NULL, it)) })

infix fun VkDevice.createDescriptorSetLayout(createInfo: VkDescriptorSetLayoutCreateInfo): VkDescriptorSetLayout = VkDescriptorSetLayout(stak.longAddress { VK10.nvkCreateDescriptorSetLayout(this, createInfo.adr, NULL, it) })

infix fun VkDevice.createFence(flag: VkFenceCreate): VkFence = createFence(vk.FenceCreateInfo { flags = flag.i })

infix fun VkDevice.createFence(flags: VkFenceCreateFlags): VkFence = createFence(vk.FenceCreateInfo { this.flags = flags })

infix fun VkDevice.createFence(createInfo: VkFenceCreateInfo): VkFence = VkFence(stak.longAddress { VK_CHECK_RESULT(VK10.nvkCreateFence(this, createInfo.adr, NULL, it)) })

infix fun VkDevice.createFramebuffer(createInfo: VkFramebufferCreateInfo): VkFramebuffer = VkFramebuffer(stak.longAddress { VK_CHECK_RESULT(VK10.nvkCreateFramebuffer(this, createInfo.adr, NULL, it)) })

fun VkDevice.createGraphicsPipelines(pipelineCache: VkPipelineCache, createInfo: VkGraphicsPipelineCreateInfo): VkPipeline = VkPipeline(stak.longAddress { VK_CHECK_RESULT(VK10.nvkCreateGraphicsPipelines(this, pipelineCache.L, 1, createInfo.adr, NULL, it)) })

infix fun VkDevice.createImage(createInfo: VkImageCreateInfo): VkImage = VkImage(stak.longAddress { VK_CHECK_RESULT(VK10.nvkCreateImage(this, createInfo.adr, NULL, it)) })

infix fun VkDevice.createImageView(createInfo: VkImageViewCreateInfo): VkImageView = VkImageView(stak.longAddress { VK10.nvkCreateImageView(this, createInfo.adr, NULL, it) })

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
    return allocateCommandBuffer(cmdBufAllocateInfo).apply { if (autostart) begin() }
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


// VkInstance ======================================================================================================

infix fun VkInstance.createDebugReportCallbackEXT(createInfo: VkDebugReportCallbackCreateInfoEXT): VkDebugReportCallback = VkDebugReportCallback(stak.longAddress { VK_CHECK_RESULT(EXTDebugReport.nvkCreateDebugReportCallbackEXT(this, createInfo.adr, NULL, it)) })

fun VkInstance.destroy() = VK10.nvkDestroyInstance(this, NULL)

infix fun VkInstance.destroyDebugReportCallbackEXT(debugReportCallback: VkDebugReportCallback) = EXTDebugReport.nvkDestroyDebugReportCallbackEXT(this, debugReportCallback.L, NULL)

fun VkInstance.enumeratePhysicalDevices(): ArrayList<VkPhysicalDevice> = stak {
    val physicalDevices = ArrayList<VkPhysicalDevice>()
    val pPhysicalDeviceCount = it.nmalloc(1, Int.BYTES)
    var physicalDeviceCount: Int
    var result: VkResult
    do {
        result = VkResult(VK10.nvkEnumeratePhysicalDevices(this, pPhysicalDeviceCount, NULL))
        physicalDeviceCount = memGetInt(pPhysicalDeviceCount)
        if (result == VkResult.SUCCESS && physicalDeviceCount > 0) {
            val pPhysicalDevices = it.nmalloc(Pointer.POINTER_SIZE, physicalDeviceCount * Pointer.POINTER_SIZE)
            result = VkResult(VK10.nvkEnumeratePhysicalDevices(this, pPhysicalDeviceCount, pPhysicalDevices))
            for (i in 0 until physicalDeviceCount)
                physicalDevices += VkPhysicalDevice(memGetAddress(pPhysicalDevices), this)
        }
    } while (result == VkResult.INCOMPLETE)
    assert(physicalDeviceCount == physicalDevices.size)
    physicalDevices
}

infix fun VkInstance.destroySurfaceKHR(surface: VkSurfaceKHR) = KHRSurface.nvkDestroySurfaceKHR(this, surface.L, NULL)


// VkPhysicalDevice ================================================================================================

inline val VkPhysicalDevice.features: VkPhysicalDeviceFeatures
    get() = getFeatures(vk.PhysicalDeviceFeatures())

infix fun VkPhysicalDevice.getFeatures(features: VkPhysicalDeviceFeatures): VkPhysicalDeviceFeatures = features.also { VK10.nvkGetPhysicalDeviceFeatures(this, it.adr) }

infix fun VkPhysicalDevice.getFormatProperties(format: VkFormat): VkFormatProperties = getFormatProperties(format, vk.FormatProperties())

fun VkPhysicalDevice.getFormatProperties(format: VkFormat, formatProperties: VkFormatProperties): VkFormatProperties = formatProperties.also { VK10.nvkGetPhysicalDeviceFormatProperties(this, format.i, it.adr) }

infix fun VkPhysicalDevice.getSurfaceFormatsKHR(surface: VkSurfaceKHR): ArrayList<VkSurfaceFormatKHR> = vk.getPhysicalDeviceSurfaceFormatsKHR(this, surface)

inline val VkPhysicalDevice.memoryProperties: VkPhysicalDeviceMemoryProperties
    get() = getMemoryProperties(vk.PhysicalDeviceMemoryProperties())

infix fun VkPhysicalDevice.getMemoryProperties(memoryProperties: VkPhysicalDeviceMemoryProperties) = memoryProperties.also { VK10.nvkGetPhysicalDeviceMemoryProperties(this, it.adr) }

inline val VkPhysicalDevice.queueFamilyProperties: ArrayList<VkQueueFamilyProperties>
    get() = vk.getPhysicalDeviceQueueFamilyProperties(this)

inline val VkPhysicalDevice.properties: VkPhysicalDeviceProperties
    get() = getProperties(vk.PhysicalDeviceProperties())

infix fun VkPhysicalDevice.getProperties(properties: VkPhysicalDeviceProperties) = properties.also { VK10.nvkGetPhysicalDeviceProperties(this, it.adr) }

infix fun VkPhysicalDevice.createDevice(createInfo: VkDeviceCreateInfo): VkDevice = VkDevice(stak.pointerAddress { VK_CHECK_RESULT(VK10.nvkCreateDevice(this, createInfo.adr, NULL, it)) }, this, createInfo)

infix fun VkPhysicalDevice.getSurfaceCapabilitiesKHR(surface: VkSurfaceKHR): VkSurfaceCapabilitiesKHR = vk.SurfaceCapabilitiesKHR { VK_CHECK_RESULT(KHRSurface.nvkGetPhysicalDeviceSurfaceCapabilitiesKHR(this@getSurfaceCapabilitiesKHR, surface.L, adr)) }

fun VkPhysicalDevice.getSurfaceSupportKHR(queueFamily: Int, surface: VkSurfaceKHR): Boolean = vk.getPhysicalDeviceSurfaceSupportKHR(this, queueFamily, surface)

fun VkPhysicalDevice.getSurfaceSupportKHR(queueFamilyProperties: ArrayList<VkQueueFamilyProperties>, surface: VkSurfaceKHR): BooleanArray = vk.getPhysicalDeviceSurfaceSupportKHR(this, queueFamilyProperties, surface)

infix fun VkPhysicalDevice.getSurfacePresentModesKHR(surface: VkSurfaceKHR): ArrayList<VkPresentModeKHR> = vk.getPhysicalDeviceSurfacePresentModesKHR(this, surface)


// VkQueue =========================================================================================================

infix fun VkQueue.presentKHR(presentInfo: VkPresentInfoKHR) = VK_CHECK_RESULT(KHRSwapchain.vkQueuePresentKHR(this, presentInfo))
fun VkQueue.presentKHR(presentInfo: VkPresentInfoKHR, block: (VkResult) -> Unit) = block(VkResult(KHRSwapchain.vkQueuePresentKHR(this, presentInfo)))

infix fun VkQueue.submit(submits: VkSubmitInfo) = VK_CHECK_RESULT(VK10.nvkQueueSubmit(this, 1, submits.adr, NULL))

fun VkQueue.submit(submits: VkSubmitInfo, fence: VkFence) = VK_CHECK_RESULT(VK10.nvkQueueSubmit(this, 1, submits.adr, fence.L))

fun VkQueue.waitIdle() = VK_CHECK_RESULT(VK10.vkQueueWaitIdle(this))
