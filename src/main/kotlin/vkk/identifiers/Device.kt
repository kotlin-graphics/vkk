package vkk.identifiers

import glm_.L
import kool.Ptr
import kool.adr
import kool.asciiAdr
import org.lwjgl.system.APIUtil.apiLog
import org.lwjgl.system.Checks
import org.lwjgl.system.FunctionProvider
import org.lwjgl.system.JNI.*
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.vulkan.VkPhysicalDeviceProperties
import vkk.*
import vkk.entities.*
import vkk.vk10.structs.DeviceCreateInfo

typealias UniqueDevice = Device

//class UniqueDevice(handle: Ptr, physicalDevice: PhysicalDevice, ci: DeviceCreateInfo, apiVersion: Int = 0) :
//        Device(handle, physicalDevice, ci, apiVersion) {
//
//    init {
//        val address = adr
//        val function = capabilities.vkDestroyDevice
//        vk.cleaner.register(this) {
//            callPPV(address, NULL, function)
//            println("device gc'ed")
//        }
//    }
//}

/** Wraps a Vulkan device dispatchable handle. */
class Device(handle: Ptr,
             val physicalDevice: PhysicalDevice, ci: DeviceCreateInfo, apiVersion: Int = 0)
    :
        DispatchableHandleDevice(handle, getDeviceCapabilities(handle, physicalDevice, ci, apiVersion)),
        VkCloseable {


    // ---------------------------------------------- VK10 -------------------------------------------------------------

    // --- [ vkDestroyDevice ] ---
    fun destroy() = callPPV(adr, NULL, capabilities.vkDestroyDevice)

    // --- [ vkDeviceWaitIdle ] ---
    fun waitIdle(): VkResult = VkResult(callPI(adr, capabilities.vkDeviceWaitIdle))

    // --- [ vkFreeMemory ] ---
    infix fun freeMemory(memory: VkDeviceMemory) = callPJPV(adr, memory.L, NULL, capabilities.vkFreeMemory)

    // --- [ vkUnmapMemory ] ---
    infix fun unmapMemory(memory: VkDeviceMemory) = callPJV(adr, memory.L, capabilities.vkUnmapMemory)

    // --- [ vkBindBufferMemory ] ---
    fun bindBufferMemory(buffer: VkBuffer, memory: VkDeviceMemory, memoryOffset: VkDeviceSize = VkDeviceSize(0)): VkResult =
            VkResult(callPJJJI(adr, buffer.L, memory.L, memoryOffset.L, capabilities.vkBindBufferMemory)).andCheck()

    // --- [ vkBindImageMemory ] ---
    fun bindImageMemory(image: VkImage, memory: VkDeviceMemory, memoryOffset: VkDeviceSize = VkDeviceSize(0)): VkResult =
            VkResult(callPJJJI(adr, image.L, memory.L, memoryOffset.L, capabilities.vkBindImageMemory))

    // --- [ vkDestroyFence ] ---
    infix fun destroy(fence: VkFence) = callPJPV(adr, fence.L, NULL, capabilities.vkDestroyFence)

    // --- [ vkGetFenceStatus ] ---
    fun getFenceStatus(fence: VkFence): VkResult = VkResult(callPJI(adr, fence.L, capabilities.vkGetFenceStatus))

    // --- [ vkDestroySemaphore ] ---
    infix fun destroy(semaphore: VkSemaphore) = callPJPV(adr, semaphore.L, NULL, capabilities.vkDestroySemaphore)

    // --- [ vkDestroyEvent ] ---
    infix fun destroy(event: VkEvent) = callPJPV(adr, event.L, NULL, capabilities.vkDestroyEvent)

    // --- [ vkGetEventStatus ] ---
    fun getEventStatus(event: VkEvent): VkResult = VkResult(callPJI(adr, event.L, capabilities.vkGetEventStatus))

    // --- [ vkSetEvent ] ---
    infix fun setEvent(event: VkEvent): VkResult = VkResult(callPJI(adr, event.L, capabilities.vkSetEvent))

    // --- [ vkResetEvent ] ---
    infix fun resetEvent(event: VkEvent): VkResult = VkResult(callPJI(adr, event.L, capabilities.vkResetEvent))

    // --- [ vkDestroyQueryPool ] ---
    infix fun destroy(queryPool: VkQueryPool) = callPJPV(adr, queryPool.L, NULL, capabilities.vkDestroyQueryPool)

    // --- [ vkGetQueryPoolResults ] ---
    fun getQueryPoolResults(queryPool: VkQueryPool, firstQuery: Int, queryCount: Int, dataSize: Int, pData: Ptr, stride: VkDeviceSize, flags: VkQueryResultFlags): VkResult =
            VkResult(callPJPPJI(adr, queryPool.L, firstQuery, queryCount, dataSize.L, pData, stride.L, flags, capabilities.vkGetQueryPoolResults))

    // --- [ vkDestroyBuffer ] ---
    infix fun destroy(buffer: VkBuffer) = callPJPV(adr, buffer.L, NULL, capabilities.vkDestroyBuffer)

    // --- [ vkDestroyBufferView ] ---
    infix fun destroy(bufferView: VkBufferView) = callPJPV(adr, bufferView.L, NULL, capabilities.vkDestroyBufferView)

    // --- [ vkDestroyImage ] ---
    infix fun destroy(image: VkImage) = callPJPV(adr, image.L, NULL, capabilities.vkDestroyImage)

    // --- [ vkDestroyImageView ] ---
    infix fun destroy(imageView: VkImageView) = callPJPV(adr, imageView.L, NULL, capabilities.vkDestroyImageView)

    // --- [ vkDestroyShaderModule ] ---
    infix fun destroy(shaderModule: VkShaderModule) = callPJPV(adr, shaderModule.L, NULL, capabilities.vkDestroyShaderModule)

    // --- [ vkDestroyPipelineCache ] ---
    infix fun destroy(pipelineCache: VkPipelineCache) = callPJPV(adr, pipelineCache.L, NULL, capabilities.vkDestroyPipelineCache)

    // --- [ vkDestroyPipeline ] ---
    infix fun destroy(pipeline: VkPipeline) = callPJPV(adr, pipeline.L, NULL, capabilities.vkDestroyPipeline)

    // --- [ vkDestroyPipelineLayout ] ---
    infix fun destroy(pipelineLayout: VkPipelineLayout) = callPJPV(adr, pipelineLayout.L, NULL, capabilities.vkDestroyPipelineLayout)

    // --- [ vkDestroySampler ] ---
    infix fun destroy(sampler: VkSampler) = callPJPV(adr, sampler.L, NULL, capabilities.vkDestroySampler)

    // --- [ vkDestroyDescriptorSetLayout ] ---
    infix fun destroyDescriptorSetLayout(descriptorSetLayout: VkDescriptorSetLayout) = callPJPV(adr, descriptorSetLayout.L, NULL, capabilities.vkDestroyDescriptorSetLayout)

    // --- [ vkDestroyDescriptorPool ] ---
    infix fun destroy(descriptorPool: VkDescriptorPool) = callPJPV(adr, descriptorPool.L, NULL, capabilities.vkDestroyDescriptorPool)

    // --- [ vkResetDescriptorPool ] ---
    fun resetDescriptorPool(descriptorPool: VkDescriptorPool, flags: VkDescriptorPoolResetFlags): VkResult =
            VkResult(callPJI(adr, descriptorPool.L, flags, capabilities.vkResetDescriptorPool)).andCheck()

    // --- [ vkDestroyFramebuffer ] ---
    infix fun destroy(framebuffer: VkFramebuffer) = callPJPV(adr, framebuffer.L, NULL, capabilities.vkDestroyFramebuffer)

    // --- [ vkDestroyRenderPass ] ---
    infix fun destroy(renderPass: VkRenderPass) = callPJPV(adr, renderPass.L, NULL, capabilities.vkDestroyRenderPass)

    // --- [ vkDestroyCommandPool ] ---
    infix fun destroy(commandPool: VkCommandPool) = callPJPV(adr, commandPool.L, NULL, capabilities.vkDestroyCommandPool)

    // --- [ vkResetCommandPool ] ---
    fun resetCommandPool(commandPool: VkCommandPool, flags: VkCommandPoolResetFlags = 0): VkResult =
            VkResult(callPJI(adr, commandPool.L, flags, capabilities.vkResetCommandPool)).andCheck()

    //




//    // Unique
//
//    infix fun MemoryStack.allocateCommandBufferUnique(allocateInfo: CommandBufferAllocateInfo): UniqueCommandBuffer =
//            framed { UniqueCommandBuffer(this.pointerAdr { nAllocateCommandBuffers(allocateInfo write this, it).check() }, this@Device) }
//
//    infix fun allocateCommandBufferUnique(allocateInfo: CommandBufferAllocateInfo): CommandBuffer =
//            stak { it allocateCommandBufferUnique allocateInfo }
//
//
//    infix fun MemoryStack.allocateCommandBuffersUnique(allocateInfo: CommandBufferAllocateInfo): Array<UniqueCommandBuffer> =
//            framed {
//                val pCommandBuffers = this.mPointer(allocateInfo.commandBufferCount)
//                nAllocateCommandBuffers(allocateInfo write this, pCommandBuffers.adr)
//                val array = Array(allocateInfo.commandBufferCount) {
//                    UniqueCommandBuffer(memGetAddress(pCommandBuffers[it]), this@Device)
//                }
//                val address = this@Device.adr
//                val commands = LongArray(array.size) { pCommandBuffers[it] }
////                vk.cleaner.register(array) {
////                    stak { s ->
//////                        val pCommands = s.mallocPointer(commands.size)// { commands[it] }
////                        println("buffers freed")
//////                        callPJPV(address, allocateInfo.commandPool.L, array.size, pCommands.adr, capabilities.vkFreeCommandBuffers)
////                    }
////                }
//                array
//            }
//
//    infix fun allocateCommandBuffersUnique(allocateInfo: CommandBufferAllocateInfo): Array<UniqueCommandBuffer> =
//            stak { it allocateCommandBuffersUnique allocateInfo }



    // ---------------------------------------------- VK11 -------------------------------------------------------------

    // --- [ vkTrimCommandPool ] ---
    fun trimCommandPool(commandPool: VkCommandPool, flags: VkCommandPoolTrimFlags = 0) = callPJV(adr, commandPool.L, flags, capabilities.vkTrimCommandPool)

    // --- [ vkDestroySamplerYcbcrConversion ] ---
    infix fun destroy(ycbcrConversion: VkSamplerYcbcrConversion) = callPJPV(adr, ycbcrConversion.L, NULL, capabilities.vkDestroySamplerYcbcrConversion)

    // --- [ vkDestroyDescriptorUpdateTemplate ] ---
    infix fun destroy(descriptorUpdateTemplate: VkDescriptorUpdateTemplate) = callPJPV(adr, descriptorUpdateTemplate.L, NULL, capabilities.vkDestroyDescriptorUpdateTemplate)

    // --- [ vkUpdateDescriptorSetWithTemplate ] ---
    fun updateDescriptorSetWithTemplate(descriptorSet: VkDescriptorSet, descriptorUpdateTemplate: VkDescriptorUpdateTemplate, pData: Ptr) = callPJJPV(adr, descriptorSet.L, descriptorUpdateTemplate.L, pData, capabilities.vkUpdateDescriptorSetWithTemplate)

    // AutoCloseable

    override fun close() = destroy()
}

private fun getDeviceCapabilities(handle: Ptr, physicalDevice: PhysicalDevice, ci: DeviceCreateInfo, apiVersion_: Int): CapabilitiesDevice {
    var apiVersion = apiVersion_
    val GetDeviceProcAddr = stak { s ->
        if (apiVersion == 0) {
            val GetPhysicalDeviceProperties = callPPP(
                    physicalDevice.instance.adr,
                    s.asciiAdr("vkGetPhysicalDeviceProperties"),
                    VK.globalCommands!!.vkGetInstanceProcAddr
            )
            val props = s.ncalloc(VkPhysicalDeviceProperties.ALIGNOF, 1, VkPhysicalDeviceProperties.SIZEOF)
            callPPV(physicalDevice.adr, props, GetPhysicalDeviceProperties)
            apiVersion = memGetInt(props)
            if (apiVersion == 0)  // vkGetPhysicalDeviceProperties failed?
                apiVersion = physicalDevice.instance.capabilities.apiVersion
        }

        callPPP(physicalDevice.instance.adr, s.asciiAdr("vkGetDeviceProcAddr"), VK.globalCommands!!.vkGetInstanceProcAddr)
    }

    return CapabilitiesDevice(FunctionProvider { functionName ->
        callPPP(handle, functionName.adr, GetDeviceProcAddr).also {
            if (it == NULL && Checks.DEBUG_FUNCTIONS)
                apiLog("Failed to locate address for VK device function " + memASCII(functionName))
        }
    }, physicalDevice.capabilities, VK.getEnabledExtensionSet(apiVersion, ci.enabledExtensionNames))
}