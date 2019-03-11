package vkk

import kool.stak
import org.lwjgl.PointerBuffer
import org.lwjgl.vulkan.*
import vkk.entities.*
import java.nio.*

inline fun vkDestroyCommandPool(device: VkDevice,
		commandPool: VkCommandPool,
		pAllocator: VkAllocationCallbacks?) = VK10.vkDestroyCommandPool(device, commandPool.L, pAllocator)

inline fun vkFreeCommandBuffers(device: VkDevice,
		commandPool: VkCommandPool,
		pCommandBuffer: VkCommandBuffer) = VK10.vkFreeCommandBuffers(device, commandPool.L, pCommandBuffer)

inline fun vkFreeCommandBuffers(device: VkDevice,
		commandPool: VkCommandPool,
		pCommandBuffers: PointerBuffer) = VK10.vkFreeCommandBuffers(device, commandPool.L, pCommandBuffers)

inline fun vkDestroyFence(device: VkDevice,
		fence: VkFence,
		pAllocator: VkAllocationCallbacks?) = VK10.vkDestroyFence(device, fence.L, pAllocator)

inline fun vkDestroySemaphore(device: VkDevice,
		semaphore: VkSemaphore,
		pAllocator: VkAllocationCallbacks?) = VK10.vkDestroySemaphore(device, semaphore.L, pAllocator)

inline fun vkDestroyEvent(device: VkDevice,
		event: VkEvent,
		pAllocator: VkAllocationCallbacks?) = VK10.vkDestroyEvent(device, event.L, pAllocator)

inline fun vkCmdSetEvent(commandBuffer: VkCommandBuffer,
		event: VkEvent,
		stageMask: VkPipelineStageFlags) = VK10.vkCmdSetEvent(commandBuffer, event.L, stageMask)

inline fun vkCmdResetEvent(commandBuffer: VkCommandBuffer,
		event: VkEvent,
		stageMask: VkPipelineStageFlags) = VK10.vkCmdResetEvent(commandBuffer, event.L, stageMask)

inline fun vkCmdWaitEvents(commandBuffer: VkCommandBuffer,
		pEvent: VkEvent,
		srcStageMask: VkPipelineStageFlags,
		dstStageMask: VkPipelineStageFlags,
		pMemoryBarriers: VkMemoryBarrier.Buffer?,
		pBufferMemoryBarriers: VkBufferMemoryBarrier.Buffer?,
		pImageMemoryBarriers: VkImageMemoryBarrier.Buffer?) = VK10.vkCmdWaitEvents(commandBuffer, longArrayOf(pEvent.L), srcStageMask, dstStageMask, pMemoryBarriers, pBufferMemoryBarriers, pImageMemoryBarriers)

inline fun vkCmdWaitEvents(commandBuffer: VkCommandBuffer,
		pEvents: Array<VkEvent>,
		srcStageMask: VkPipelineStageFlags,
		dstStageMask: VkPipelineStageFlags,
		pMemoryBarriers: VkMemoryBarrier.Buffer?,
		pBufferMemoryBarriers: VkBufferMemoryBarrier.Buffer?,
		pImageMemoryBarriers: VkImageMemoryBarrier.Buffer?) = VK10.vkCmdWaitEvents(commandBuffer, LongArray(pEvents.size) { pEvents[it].L }, srcStageMask, dstStageMask, pMemoryBarriers, pBufferMemoryBarriers, pImageMemoryBarriers)

inline fun vkDestroyRenderPass(device: VkDevice,
		renderPass: VkRenderPass,
		pAllocator: VkAllocationCallbacks?) = VK10.vkDestroyRenderPass(device, renderPass.L, pAllocator)

inline fun vkDestroyFramebuffer(device: VkDevice,
		framebuffer: VkFramebuffer,
		pAllocator: VkAllocationCallbacks?) = VK10.vkDestroyFramebuffer(device, framebuffer.L, pAllocator)

inline fun vkCmdBeginRenderPass(commandBuffer: VkCommandBuffer,
		pRenderPassBegin: VkRenderPassBeginInfo,
		contents: VkSubpassContents) = VK10.vkCmdBeginRenderPass(commandBuffer, pRenderPassBegin, contents.i)

inline fun vkGetRenderAreaGranularity(device: VkDevice,
		renderPass: VkRenderPass,
		pGranularity: VkExtent2D) = VK10.vkGetRenderAreaGranularity(device, renderPass.L, pGranularity)

inline fun vkCmdNextSubpass(commandBuffer: VkCommandBuffer,
		contents: VkSubpassContents) = VK10.vkCmdNextSubpass(commandBuffer, contents.i)

inline fun vkDestroyShaderModule(device: VkDevice,
		shaderModule: VkShaderModule,
		pAllocator: VkAllocationCallbacks?) = VK10.vkDestroyShaderModule(device, shaderModule.L, pAllocator)

inline fun vkDestroyPipeline(device: VkDevice,
		pipeline: VkPipeline,
		pAllocator: VkAllocationCallbacks?) = VK10.vkDestroyPipeline(device, pipeline.L, pAllocator)

inline fun vkDestroyPipelineCache(device: VkDevice,
		pipelineCache: VkPipelineCache,
		pAllocator: VkAllocationCallbacks?) = VK10.vkDestroyPipelineCache(device, pipelineCache.L, pAllocator)

inline fun vkCmdBindPipeline(commandBuffer: VkCommandBuffer,
		pipelineBindPoint: VkPipelineBindPoint,
		pipeline: VkPipeline) = VK10.vkCmdBindPipeline(commandBuffer, pipelineBindPoint.i, pipeline.L)

inline fun vkFreeMemory(device: VkDevice,
		memory: VkDeviceMemory,
		pAllocator: VkAllocationCallbacks?) = VK10.vkFreeMemory(device, memory.L, pAllocator)

inline fun vkUnmapMemory(device: VkDevice,
		memory: VkDeviceMemory) = VK10.vkUnmapMemory(device, memory.L)

inline fun vkGetDeviceMemoryCommitment(device: VkDevice,
		memory: VkDeviceMemory,
		pCommittedMemoryInBytes: LongArray) = VK10.vkGetDeviceMemoryCommitment(device, memory.L, pCommittedMemoryInBytes)

inline fun vkGetDeviceMemoryCommitment(device: VkDevice,
		memory: VkDeviceMemory,
		pCommittedMemoryInBytes: LongBuffer) = VK10.vkGetDeviceMemoryCommitment(device, memory.L, pCommittedMemoryInBytes)

inline fun vkDestroyBuffer(device: VkDevice,
		buffer: VkBuffer,
		pAllocator: VkAllocationCallbacks?) = VK10.vkDestroyBuffer(device, buffer.L, pAllocator)

inline fun vkDestroyBufferView(device: VkDevice,
		bufferView: VkBufferView,
		pAllocator: VkAllocationCallbacks?) = VK10.vkDestroyBufferView(device, bufferView.L, pAllocator)

inline fun vkGetImageSubresourceLayout(device: VkDevice,
		image: VkImage,
		pSubresource: VkImageSubresource,
		pLayout: VkSubresourceLayout) = VK10.vkGetImageSubresourceLayout(device, image.L, pSubresource, pLayout)

inline fun vkDestroyImage(device: VkDevice,
		image: VkImage,
		pAllocator: VkAllocationCallbacks?) = VK10.vkDestroyImage(device, image.L, pAllocator)

inline fun vkDestroyImageView(device: VkDevice,
		imageView: VkImageView,
		pAllocator: VkAllocationCallbacks?) = VK10.vkDestroyImageView(device, imageView.L, pAllocator)

inline fun vkGetBufferMemoryRequirements(device: VkDevice,
		buffer: VkBuffer,
		pMemoryRequirements: VkMemoryRequirements) = VK10.vkGetBufferMemoryRequirements(device, buffer.L, pMemoryRequirements)

inline fun vkGetImageMemoryRequirements(device: VkDevice,
		image: VkImage,
		pMemoryRequirements: VkMemoryRequirements) = VK10.vkGetImageMemoryRequirements(device, image.L, pMemoryRequirements)

inline fun vkDestroySampler(device: VkDevice,
		sampler: VkSampler,
		pAllocator: VkAllocationCallbacks?) = VK10.vkDestroySampler(device, sampler.L, pAllocator)

inline fun vkDestroyDescriptorSetLayout(
        device: VkDevice,
        descriptorSetLayout: VkDescriptorSetLayout,
        pAllocator: VkAllocationCallbacks?) = VK10.vkDestroyDescriptorSetLayout(device, descriptorSetLayout.L, pAllocator)

inline fun vkDestroyPipelineLayout(
        device: VkDevice,
        pipelineLayout: VkPipelineLayout,
        pAllocator: VkAllocationCallbacks?) = VK10.vkDestroyPipelineLayout(device, pipelineLayout.L, pAllocator)

inline fun vkDestroyDescriptorPool(
        device: VkDevice,
        descriptorPool: VkDescriptorPool,
        pAllocator: VkAllocationCallbacks?) = VK10.vkDestroyDescriptorPool(device, descriptorPool.L, pAllocator)

inline fun vkCmdBindDescriptorSets(
        commandBuffer: VkCommandBuffer,
        pipelineBindPoint: VkPipelineBindPoint,
        layout: VkPipelineLayout,
        firstSet: Int,
        pDescriptorSets: Array<VkDescriptorSet>,
        pDynamicOffsets: IntArray) = VK10.vkCmdBindDescriptorSets(commandBuffer, pipelineBindPoint.i, layout.L, firstSet, LongArray(pDescriptorSets.size) { pDescriptorSets[it].L }, pDynamicOffsets)

/* TODO:
inline fun vkCmdBindDescriptorSets(
        commandBuffer: VkCommandBuffer,
        pipelineBindPoint: VkPipelineBindPoint,
        layout: VkPipelineLayout,
        firstSet: Int,
        pDescriptorSets: Array<VkDescriptorSet>,
        pDynamicOffsets: IntBuffer) = VK10.vkCmdBindDescriptorSets(commandBuffer, pipelineBindPoint.i, layout.L, firstSet, LongArray(pDescriptorSets.size) { pDescriptorSets[it].L }, pDynamicOffsets)
*/

inline fun vkCmdBindDescriptorSets(
        commandBuffer: VkCommandBuffer,
        pipelineBindPoint: VkPipelineBindPoint,
        layout: VkPipelineLayout,
        firstSet: Int,
        pDescriptorSets: VkDescriptorSet,
        pDynamicOffsets: IntArray) = VK10.vkCmdBindDescriptorSets(commandBuffer, pipelineBindPoint.i, layout.L, firstSet, longArrayOf(pDescriptorSets.L), pDynamicOffsets)

inline fun vkCmdBindDescriptorSets(
        commandBuffer: VkCommandBuffer,
        pipelineBindPoint: VkPipelineBindPoint,
        layout: VkPipelineLayout,
        firstSet: Int,
        pDescriptorSets: VkDescriptorSet,
        pDynamicOffsets: IntBuffer) = stak.longBuffer(pDescriptorSets.L) { buffer -> VK10.vkCmdBindDescriptorSets(commandBuffer, pipelineBindPoint.i, layout.L, firstSet, buffer, pDynamicOffsets) }

inline fun vkCmdPushConstants(
        commandBuffer: VkCommandBuffer,
        layout: VkPipelineLayout,
        stageFlags: VkShaderStageFlags,
        offset: Int,
        pValues: ByteBuffer) = VK10.vkCmdPushConstants(commandBuffer, layout.L, stageFlags, offset, pValues)

inline fun vkCmdPushConstants(
        commandBuffer: VkCommandBuffer,
        layout: VkPipelineLayout,
        stageFlags: VkShaderStageFlags,
        offset: Int,
        pValues: ShortBuffer) = VK10.vkCmdPushConstants(commandBuffer, layout.L, stageFlags, offset, pValues)

inline fun vkCmdPushConstants(
        commandBuffer: VkCommandBuffer,
        layout: VkPipelineLayout,
        stageFlags: VkShaderStageFlags,
        offset: Int,
        pValues: IntBuffer) = VK10.vkCmdPushConstants(commandBuffer, layout.L, stageFlags, offset, pValues)

inline fun vkCmdPushConstants(
        commandBuffer: VkCommandBuffer,
        layout: VkPipelineLayout,
        stageFlags: VkShaderStageFlags,
        offset: Int,
        pValues: LongBuffer) = VK10.vkCmdPushConstants(commandBuffer, layout.L, stageFlags, offset, pValues)

inline fun vkCmdPushConstants(
        commandBuffer: VkCommandBuffer,
        layout: VkPipelineLayout,
        stageFlags: VkShaderStageFlags,
        offset: Int,
        pValues: FloatBuffer) = VK10.vkCmdPushConstants(commandBuffer, layout.L, stageFlags, offset, pValues)

inline fun vkCmdPushConstants(
        commandBuffer: VkCommandBuffer,
        layout: VkPipelineLayout,
        stageFlags: VkShaderStageFlags,
        offset: Int,
        pValues: DoubleBuffer) = VK10.vkCmdPushConstants(commandBuffer, layout.L, stageFlags, offset, pValues)

inline fun vkCmdPushConstants(
        commandBuffer: VkCommandBuffer,
        layout: VkPipelineLayout,
        stageFlags: VkShaderStageFlags,
        offset: Int,
        pValues: ShortArray) = VK10.vkCmdPushConstants(commandBuffer, layout.L, stageFlags, offset, pValues)

inline fun vkCmdPushConstants(
        commandBuffer: VkCommandBuffer,
        layout: VkPipelineLayout,
        stageFlags: VkShaderStageFlags,
        offset: Int,
        pValues: IntArray) = VK10.vkCmdPushConstants(commandBuffer, layout.L, stageFlags, offset, pValues)

inline fun vkCmdPushConstants(
        commandBuffer: VkCommandBuffer,
        layout: VkPipelineLayout,
        stageFlags: VkShaderStageFlags,
        offset: Int,
        pValues: LongArray) = VK10.vkCmdPushConstants(commandBuffer, layout.L, stageFlags, offset, pValues)

inline fun vkCmdPushConstants(
        commandBuffer: VkCommandBuffer,
        layout: VkPipelineLayout,
        stageFlags: VkShaderStageFlags,
        offset: Int,
        pValues: FloatArray) = VK10.vkCmdPushConstants(commandBuffer, layout.L, stageFlags, offset, pValues)

inline fun vkCmdPushConstants(
        commandBuffer: VkCommandBuffer,
        layout: VkPipelineLayout,
        stageFlags: VkShaderStageFlags,
        offset: Int,
        pValues: DoubleArray) = VK10.vkCmdPushConstants(commandBuffer, layout.L, stageFlags, offset, pValues)

inline fun vkDestroyQueryPool(
        device: VkDevice,
        queryPool: VkQueryPool,
        pAllocator: VkAllocationCallbacks?) = VK10.vkDestroyQueryPool(device, queryPool.L, pAllocator)

inline fun vkCmdResetQueryPool(
        commandBuffer: VkCommandBuffer,
        queryPool: VkQueryPool,
        firstQuery: Int,
        queryCount: Int) = VK10.vkCmdResetQueryPool(commandBuffer, queryPool.L, firstQuery, queryCount)

inline fun vkCmdBeginQuery(
        commandBuffer: VkCommandBuffer,
        queryPool: VkQueryPool,
        query: Int,
        flags: VkQueryControlFlags) = VK10.vkCmdBeginQuery(commandBuffer, queryPool.L, query, flags)

inline fun vkCmdEndQuery(
        commandBuffer: VkCommandBuffer,
        queryPool: VkQueryPool,
        query: Int) = VK10.vkCmdEndQuery(commandBuffer, queryPool.L, query)

inline fun vkCmdCopyQueryPoolResults(
        commandBuffer: VkCommandBuffer,
        queryPool: VkQueryPool,
        firstQuery: Int,
        queryCount: Int,
        dstBuffer: VkBuffer,
        dstOffset: VkDeviceSize,
        stride: VkDeviceSize,
        flags: VkQueryResultFlags) = VK10.vkCmdCopyQueryPoolResults(commandBuffer, queryPool.L, firstQuery, queryCount, dstBuffer.L, dstOffset.L, stride.L, flags)

inline fun vkCmdWriteTimestamp(
        commandBuffer: VkCommandBuffer,
        pipelineStage: VkPipelineStageFlags,
        queryPool: VkQueryPool,
        query: Int) = VK10.vkCmdWriteTimestamp(commandBuffer, pipelineStage, queryPool.L, query)

inline fun vkCmdClearColorImage(
        commandBuffer: VkCommandBuffer,
        image: VkImage,
        imageLayout: VkImageLayout,
        pColor: VkClearColorValue,
        pRanges: VkImageSubresourceRange.Buffer) = VK10.vkCmdClearColorImage(commandBuffer, image.L, imageLayout.i, pColor, pRanges)

inline fun vkCmdClearColorImage(
        commandBuffer: VkCommandBuffer,
        image: VkImage,
        imageLayout: VkImageLayout,
        pColor: VkClearColorValue,
        pRange: VkImageSubresourceRange) = VK10.vkCmdClearColorImage(commandBuffer, image.L, imageLayout.i, pColor, pRange)

inline fun vkCmdClearDepthStencilImage(
        commandBuffer: VkCommandBuffer,
        image: VkImage,
        imageLayout: VkImageLayout,
        pDepthStencil: VkClearDepthStencilValue,
        pRanges: VkImageSubresourceRange.Buffer) = VK10.vkCmdClearDepthStencilImage(commandBuffer, image.L, imageLayout.i, pDepthStencil, pRanges)

inline fun vkCmdClearDepthStencilImage(
        commandBuffer: VkCommandBuffer,
        image: VkImage,
        imageLayout: VkImageLayout,
        pDepthStencil: VkClearDepthStencilValue,
        pRange: VkImageSubresourceRange) = VK10.vkCmdClearDepthStencilImage(commandBuffer, image.L, imageLayout.i, pDepthStencil, pRange)

inline fun vkCmdFillBuffer(
        commandBuffer: VkCommandBuffer,
        dstBuffer: VkBuffer,
        dstOffset: VkDeviceSize,
        size: VkDeviceSize,
        data: Int) = VK10.vkCmdFillBuffer(commandBuffer, dstBuffer.L, dstOffset.L, size.L, data)

inline fun vkCmdUpdateBuffer(
        commandBuffer: VkCommandBuffer,
        dstBuffer: VkBuffer,
        dstOffset: VkDeviceSize,
        pData: ByteBuffer) = VK10.vkCmdUpdateBuffer(commandBuffer, dstBuffer.L, dstOffset.L, pData)

inline fun vkCmdUpdateBuffer(
        commandBuffer: VkCommandBuffer,
        dstBuffer: VkBuffer,
        dstOffset: VkDeviceSize,
        pData: ShortBuffer) = VK10.vkCmdUpdateBuffer(commandBuffer, dstBuffer.L, dstOffset.L, pData)

inline fun vkCmdUpdateBuffer(
        commandBuffer: VkCommandBuffer,
        dstBuffer: VkBuffer,
        dstOffset: VkDeviceSize,
        pData: IntBuffer) = VK10.vkCmdUpdateBuffer(commandBuffer, dstBuffer.L, dstOffset.L, pData)

inline fun vkCmdUpdateBuffer(
        commandBuffer: VkCommandBuffer,
        dstBuffer: VkBuffer,
        dstOffset: VkDeviceSize,
        pData: LongBuffer) = VK10.vkCmdUpdateBuffer(commandBuffer, dstBuffer.L, dstOffset.L, pData)

inline fun vkCmdUpdateBuffer(
        commandBuffer: VkCommandBuffer,
        dstBuffer: VkBuffer,
        dstOffset: VkDeviceSize,
        pData: FloatBuffer) = VK10.vkCmdUpdateBuffer(commandBuffer, dstBuffer.L, dstOffset.L, pData)

inline fun vkCmdUpdateBuffer(
        commandBuffer: VkCommandBuffer,
        dstBuffer: VkBuffer,
        dstOffset: VkDeviceSize,
        pData: DoubleBuffer) = VK10.vkCmdUpdateBuffer(commandBuffer, dstBuffer.L, dstOffset.L, pData)

inline fun vkCmdUpdateBuffer(
        commandBuffer: VkCommandBuffer,
        dstBuffer: VkBuffer,
        dstOffset: VkDeviceSize,
        pData: ShortArray) = VK10.vkCmdUpdateBuffer(commandBuffer, dstBuffer.L, dstOffset.L, pData)

inline fun vkCmdUpdateBuffer(
        commandBuffer: VkCommandBuffer,
        dstBuffer: VkBuffer,
        dstOffset: VkDeviceSize,
        pData: IntArray) = VK10.vkCmdUpdateBuffer(commandBuffer, dstBuffer.L, dstOffset.L, pData)

inline fun vkCmdUpdateBuffer(
        commandBuffer: VkCommandBuffer,
        dstBuffer: VkBuffer,
        dstOffset: VkDeviceSize,
        pData: LongArray) = VK10.vkCmdUpdateBuffer(commandBuffer, dstBuffer.L, dstOffset.L, pData)

inline fun vkCmdUpdateBuffer(
        commandBuffer: VkCommandBuffer,
        dstBuffer: VkBuffer,
        dstOffset: VkDeviceSize,
        pData: FloatArray) = VK10.vkCmdUpdateBuffer(commandBuffer, dstBuffer.L, dstOffset.L, pData)

inline fun vkCmdUpdateBuffer(
        commandBuffer: VkCommandBuffer,
        dstBuffer: VkBuffer,
        dstOffset: VkDeviceSize,
        pData: DoubleArray) = VK10.vkCmdUpdateBuffer(commandBuffer, dstBuffer.L, dstOffset.L, pData)

inline fun vkCmdCopyBuffer(
        commandBuffer: VkCommandBuffer,
        srcBuffer: VkBuffer,
        dstBuffer: VkBuffer,
        pRegions: VkBufferCopy.Buffer) = VK10.vkCmdCopyBuffer(commandBuffer, srcBuffer.L, dstBuffer.L, pRegions)

inline fun vkCmdCopyImage(
        commandBuffer: VkCommandBuffer,
        srcImage: VkImage,
        srcImageLayout: VkImageLayout,
        dstImage: VkImage,
        dstImageLayout: VkImageLayout,
        pRegions: VkImageCopy.Buffer) = VK10.vkCmdCopyImage(commandBuffer, srcImage.L, srcImageLayout.i, dstImage.L, dstImageLayout.i, pRegions)

inline fun vkCmdCopyBufferToImage(
        commandBuffer: VkCommandBuffer,
        srcBuffer: VkBuffer,
        dstImage: VkImage,
        dstImageLayout: VkImageLayout,
        pRegions: VkBufferImageCopy.Buffer) = VK10.vkCmdCopyBufferToImage(commandBuffer, srcBuffer.L, dstImage.L, dstImageLayout.i, pRegions)

inline fun vkCmdCopyImageToBuffer(
		commandBuffer: VkCommandBuffer,
		srcImage: VkImage,
		srcImageLayout: VkImageLayout,
		dstBuffer: VkBuffer,
		pRegions: VkBufferImageCopy.Buffer) = VK10.vkCmdCopyImageToBuffer(commandBuffer, srcImage.L, srcImageLayout.i, dstBuffer.L, pRegions)

inline fun vkCmdBlitImage(
		commandBuffer: VkCommandBuffer,
		srcImage: VkImage,
		srcImageLayout: VkImageLayout,
		dstImage: VkImage,
		dstImageLayout: VkImageLayout,
		pRegions: VkImageBlit.Buffer,
		filter: VkFilter) = VK10.vkCmdBlitImage(commandBuffer, srcImage.L, srcImageLayout.i, dstImage.L, dstImageLayout.i, pRegions, filter.i)

inline fun vkCmdResolveImage(
		commandBuffer: VkCommandBuffer,
		srcImage: VkImage,
		srcImageLayout: VkImageLayout,
		dstImage: VkImage,
		dstImageLayout: VkImageLayout,
		pRegions: VkImageResolve.Buffer) = VK10.vkCmdResolveImage(commandBuffer, srcImage.L, srcImageLayout.i, dstImage.L, dstImageLayout.i, pRegions)


inline fun vkCmdResolveImage(
		commandBuffer: VkCommandBuffer,
		srcImage: VkImage,
		srcImageLayout: VkImageLayout,
		dstImage: VkImage,
		dstImageLayout: VkImageLayout,
		pRegion: VkImageResolve) = VK10.vkCmdResolveImage(commandBuffer, srcImage.L, srcImageLayout.i, dstImage.L, dstImageLayout.i, pRegion)

inline fun vkCmdBindIndexBuffer(
		commandBuffer: VkCommandBuffer,
		buffer: VkBuffer,
		offset: VkDeviceSize,
		indexType: VkIndexType) = VK10.vkCmdBindIndexBuffer(commandBuffer, buffer.L, offset.L, indexType.i)

inline fun vkCmdDrawIndirect(
		commandBuffer: VkCommandBuffer,
		buffer: VkBuffer,
		offset: VkDeviceSize,
		drawCount: Int,
		stride: Int) = VK10.vkCmdDrawIndirect(commandBuffer, buffer.L, offset.L, drawCount, stride)

inline fun vkCmdDrawIndexedIndirect(
		commandBuffer: VkCommandBuffer,
		buffer: VkBuffer,
		offset: VkDeviceSize,
		drawCount: Int,
		stride: Int) = VK10.vkCmdDrawIndexedIndirect(commandBuffer, buffer.L, offset.L, drawCount, stride)

/* TODO
inline fun vkCmdBindVertexBuffers(
		commandBuffer: VkCommandBuffer,
		firstBinding: Int,
		bindingCount: Int,
		pBuffers: Array<VkBuffer>,
		pOffsets: Array<VkDeviceSize>) = vkCmdBindVertexBuffers()
*/

inline fun vkCmdDispatchIndirect(
		commandBuffer: VkCommandBuffer,
		buffer: VkBuffer,
		offset: VkDeviceSize) = VK10.vkCmdDispatchIndirect(commandBuffer, buffer.L, offset.L)

inline fun vkGetPhysicalDeviceSparseImageFormatProperties(
		physicalDevice: VkPhysicalDevice,
		format: VkFormat,
		type: VkImageType,
		samples: VkSampleCount,
		usage: VkImageUsageFlags,
		tiling: VkImageTiling,
		pPropertyCount: IntBuffer,
		pProperties: VkSparseImageFormatProperties.Buffer) = VK10.vkGetPhysicalDeviceSparseImageFormatProperties(physicalDevice, format.i, type.i, samples.i, usage, tiling.i, pPropertyCount, pProperties)

inline fun vkGetPhysicalDeviceSparseImageFormatProperties(
		physicalDevice: VkPhysicalDevice,
		format: VkFormat,
		type: VkImageType,
		samples: VkSampleCount,
		usage: VkImageUsageFlags,
		tiling: VkImageTiling,
		pPropertyCount: IntArray,
		pProperties: VkSparseImageFormatProperties.Buffer) = VK10.vkGetPhysicalDeviceSparseImageFormatProperties(physicalDevice, format.i, type.i, samples.i, usage, tiling.i, pPropertyCount, pProperties)

inline fun vkGetImageSparseMemoryRequirements(
		device: VkDevice,
		image: VkImage,
		pSparseMemoryRequirementCount: IntBuffer,
		pSparseMemoryRequirements: VkSparseImageMemoryRequirements.Buffer) = VK10.vkGetImageSparseMemoryRequirements(device, image.L, pSparseMemoryRequirementCount, pSparseMemoryRequirements)

inline fun vkGetImageSparseMemoryRequirements(
		device: VkDevice,
		image: VkImage,
		pSparseMemoryRequirementCount: IntArray,
		pSparseMemoryRequirements: VkSparseImageMemoryRequirements.Buffer) = VK10.vkGetImageSparseMemoryRequirements(device, image.L, pSparseMemoryRequirementCount, pSparseMemoryRequirements)

inline fun vkGetPhysicalDeviceFormatProperties(
		physicalDevice: VkPhysicalDevice,
		format: VkFormat,
		pFormatProperties: VkFormatProperties) = VK10.vkGetPhysicalDeviceFormatProperties(physicalDevice, format.i, pFormatProperties)





