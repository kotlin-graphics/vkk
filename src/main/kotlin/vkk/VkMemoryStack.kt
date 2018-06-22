import vkk.VkDebugReportFlagsEXT
import vkk.VkDebugReportObjectType

//package vkn
//
//import glm_.i
//import org.lwjgl.PointerBuffer
//import org.lwjgl.system.Configuration
//import org.lwjgl.system.MemoryUtil
//import org.lwjgl.system.MemoryUtil.*
//import org.lwjgl.vulkan.*
//import uno.kotlin.buffers.toCollection
//import vkk.*
//import java.nio.ByteBuffer
//import java.nio.FloatBuffer
//import java.nio.IntBuffer
//import java.nio.LongBuffer
//import kotlin.reflect.KMutableProperty0
//
//class VkMemoryStack private constructor(size: Int) : MemoryStackPlus(size) {
//
//    fun vkAllocateCommandBuffers(device: VkDevice, allocateInfo: VkCommandBufferAllocateInfo, count: Int,
//                                 commandBuffers: ArrayList<VkCommandBuffer>): VkResult {
//        val pCommandBuffer = mallocPointer(count)
//        return VkResult of VK10.vkAllocateCommandBuffers(device, allocateInfo, pCommandBuffer).also {
//            for (i in 0 until count)
//                commandBuffers += VkCommandBuffer(pCommandBuffer[i], device)
//        }
//    }
//
//    fun vkAllocateCommandBuffers(device: VkDevice, allocateInfo: VkCommandBufferAllocateInfo,
//                                 commandBuffer: KMutableProperty0<VkCommandBuffer>): VkResult {
//        val pCommandBuffer = mallocPointer()
//        return VkResult of VK10.vkAllocateCommandBuffers(device, allocateInfo, pCommandBuffer).also {
//            commandBuffer.set(VkCommandBuffer(pCommandBuffer[0], device))
//        }
//    }
//
//
//
//
//    fun vkGetSwapchainImagesKHR(device: VkDevice, swapchain: VkSwapchainKHR, images: ArrayList<VkImageView>): VkResult {
//        val count = mallocInt()
//        val ret = VkResult of KHRSwapchain.vkGetSwapchainImagesKHR(device, swapchain, count, null)
//        if(ret()) return ret
//        val pImages = mallocLong(count)
//        return VkResult of KHRSwapchain.vkGetSwapchainImagesKHR(device, swapchain, count, pImages).also {
//            pImages.toCollection(images)
//        }
//    }
////
////    fun vkCreateDebugReportCallback(instance: VkInstance, createInfo: VkDebugReportCallbackCreateInfoEXT,
////                                    allocator: VkAllocationCallbacks?, callback: VkDebugReportCallbackFunc?): VkResult {
////        vkDebugReportCallback = VkDebugReportCallback().apply { cb = callback }
////        val pCallback = longs(vkDebugReportCallback!!.adr)
////        return VkResult of EXTDebugReport.vkCreateDebugReportCallbackEXT(instance, createInfo, allocator, pCallback).also {
//////                        vkDebugReportCallback = VkDebugReportCallback(pCallback[0]).apply { cb = callback }
////        }
////    }
//
//    fun vkCreateImageView(device: VkDevice, createInfo: VkImageViewCreateInfo, allocator: VkAllocationCallbacks?,
//                          view: KMutableProperty0<VkImageView>): VkResult {
//        val pView = mallocLong()
//        return VkResult of VK10.vkCreateImageView(device, createInfo, allocator, pView).also {
//            view.set(pView)
//        }
//    }
//
//    fun vkCreateImage(device: VkDevice, createInfo: VkImageCreateInfo, allocator: VkAllocationCallbacks?,
//                      image: KMutableProperty0<VkImage>): VkResult {
//        val pImage = mallocLong()
//        return VkResult of VK10.vkCreateImage(device, createInfo, allocator, pImage).also {
//            image.set(pImage)
//        }
//    }
//
//
//
//    fun vkGetImageMemoryRequirements(device: VkDevice, image: VkImageBlit, memoryRequirements: VkMemoryRequirements) =
//            VK10.vkGetImageMemoryRequirements(device, image.address(), memoryRequirements)
//
//    fun vkAllocateMemory(device: VkDevice, allocateInfo: VkMemoryAllocateInfo, allocator: VkAllocationCallbacks?,
//                         memory: KMutableProperty0<VkDeviceMemory>): VkResult {
//        val pMemory = mallocLong()
//        return VkResult of VK10.vkAllocateMemory(device, allocateInfo, allocator, pMemory).also {
//            memory.set(pMemory)
//        }
//    }
//
//    fun vkBindImageMemory(device: VkDevice, image: VkImage, memory: VkDeviceMemory, memoryOffset: VkDeviceSize) =
//            VK10.vkBindImageMemory(device, image, memory, memoryOffset)
//
//    fun vkCreateRenderPass(device: VkDevice, createInfo: VkRenderPassCreateInfo, allocator: VkAllocationCallbacks?,
//                           renderPass: KMutableProperty0<VkRenderPass>): VkResult {
//        val pRenderPass = mallocLong()
//        return VkResult of VK10.vkCreateRenderPass(device, createInfo, allocator, pRenderPass).also {
//            renderPass.set(pRenderPass)
//        }
//    }
//
//    fun vkCreatePipelineCache(device: VkDevice, createInfo: VkPipelineCacheCreateInfo, allocator: VkAllocationCallbacks?,
//                              pipelineCache: KMutableProperty0<VkPipelineCache>): VkResult {
//        val pPipelineCache = mallocLong()
//        return VkResult of VK10.vkCreatePipelineCache(device, createInfo, allocator, pPipelineCache).also {
//            pipelineCache.set(pPipelineCache)
//        }
//    }
//
//    fun vkCreateFramebuffer(device: VkDevice, createInfo: VkFramebufferCreateInfo, allocator: VkAllocationCallbacks?,
//                            framebuffer: ArrayList<VkFramebuffer>, index: Int): VkResult {
//        val pFramebuffer = mallocLong()
//        return VkResult of VK10.vkCreateFramebuffer(device, createInfo, allocator, pFramebuffer).also {
//            framebuffer[index] = pFramebuffer
//        }
//    }
//
//    fun vkAcquireNextImageKHR(device: VkDevice, swapchain: VkSwapchainKHR, timeout: Long, semaphore: VkSemaphore, fence: VkFence,
//                              imageIndex: KMutableProperty0<Int>): VkResult {
//        val pImageIndex = mallocInt()
//        return VkResult of KHRSwapchain.vkAcquireNextImageKHR(device, swapchain, timeout, semaphore, fence, pImageIndex).also {
//            imageIndex.set(pImageIndex)
//        }
//    }
//
//    fun vkFreeCommandBuffers(device: VkDevice, commandPool: VkCommandPool, commandBuffers: ArrayList<VkCommandBuffer>) {
//        val pointers = mallocPointer(commandBuffers.size)
//        for (i in commandBuffers.indices)
//            pointers[i] = commandBuffers[i].address()
//        return VK10.vkFreeCommandBuffers(device, commandPool, pointers)
//    }
//
//    fun vkCreateFences(device: VkDevice, createInfo: VkFenceCreateInfo, allocator: VkAllocationCallbacks?, fences: ArrayList<VkFence>) {
//        val pFence = mallocLong()
//        for (i in fences.indices) {
//            VK10.vkCreateFence(device, createInfo, allocator, pFence)
//            fences[i] = pFence
//        }
//    }
//
//    fun vkCreateBuffer(device: VkDevice, createInfo: VkBufferCreateInfo, allocator: VkAllocationCallbacks?,
//                       buffer: KMutableProperty0<VkBuffer>): VkResult {
//        val pBuffer = mallocLong()
//        return VkResult of VK10.nvkCreateBuffer(device, createInfo.address(), memAddressSafe(allocator), memAddress(pBuffer)).also {
//            buffer.set(pBuffer)
//        }
//    }
//
//    fun vkCreateDescriptorSetLayout(device: VkDevice, createInfo: VkDescriptorSetLayoutCreateInfo, allocator: VkAllocationCallbacks?,
//                                    setLayout: KMutableProperty0<VkDescriptorSetLayout>): VkResult {
//        val pSetLayout = mallocLong()
//        return VkResult of VK10.vkCreateDescriptorSetLayout(device, createInfo, allocator, pSetLayout).also {
//            setLayout.set(pSetLayout)
//        }
//    }
//
//    fun vkCreatePipelineLayout(device: VkDevice, createInfo: VkPipelineLayoutCreateInfo, allocator: VkAllocationCallbacks?,
//                               pipelineLayout: KMutableProperty0<VkPipelineLayout>): VkResult {
//        val pPipelineLayout = mallocLong()
//        return VkResult of VK10.vkCreatePipelineLayout(device, createInfo, allocator, pPipelineLayout).also {
//            pipelineLayout.set(pPipelineLayout)
//        }
//    }
//
//    fun vkCreateGraphicsPipelines(device: VkDevice, pipelineCache: VkPipelineCache, createInfos: VkGraphicsPipelineCreateInfo.Buffer,
//                                  allocator: VkAllocationCallbacks?, pipelines: KMutableProperty0<VkPipeline>): VkResult {
//        val pPipelines = mallocLong()
//        return VkResult of VK10.vkCreateGraphicsPipelines(device, pipelineCache, createInfos, allocator, pPipelines).also {
//            pipelines.set(pPipelines)
//        }
//    }
//
//    fun vkCreateDescriptorPool(device: VkDevice, createInfo: VkDescriptorPoolCreateInfo, allocator: VkAllocationCallbacks?,
//                               descriptorPool: KMutableProperty0<VkDescriptorPool>): VkResult {
//        val pDescriptorPool = mallocLong()
//        return VkResult of VK10.vkCreateDescriptorPool(device, createInfo, allocator, pDescriptorPool).also {
//            descriptorPool.set(pDescriptorPool)
//        }
//    }
//
//    fun vkAllocateDescriptorSets(device: VkDevice, allocateInfo: VkDescriptorSetAllocateInfo,
//                                 descriptorSets: KMutableProperty0<VkDescriptorSet>): VkResult {
//        val pDescriptorSets = mallocLong()
//        return VkResult of VK10.vkAllocateDescriptorSets(device, allocateInfo, pDescriptorSets).also {
//            descriptorSets.set(pDescriptorSets)
//        }
//    }
//
//    fun vkCmdBindDescriptorSets(commandBuffer: VkCommandBuffer, pipelineBindPoint: VkPipelineBindPoint, layout: VkPipelineLayout,
//                                firstSet: Int, descriptorSets: KMutableProperty0<VkDescriptorSet>, dynamicOffsets: IntBuffer?) {
//        val pDescriptorSets = callocLong().apply { set(0, descriptorSets()) }
//        VK10.vkCmdBindDescriptorSets(commandBuffer, pipelineBindPoint.i, layout, firstSet, pDescriptorSets, dynamicOffsets).also {
//            descriptorSets.set(pDescriptorSets)
//        }
//    }
//
//    fun vkCmdBindVertexBuffers(commandBuffer: VkCommandBuffer, firstBinding: Int, buffers: KMutableProperty0<VkBuffer>,
//                               offsets: LongBuffer) {
//        val pBuffer = mallocLong().apply { set(0, buffers()) }
//        VK10.vkCmdBindVertexBuffers(commandBuffer, firstBinding, pBuffer, offsets).also {
//            buffers.set(pBuffer)
//        }
//    }
//
//
//    fun ArrayList<VkDeviceQueueCreateInfo>.toBuffer(): VkDeviceQueueCreateInfo.Buffer {
//        val buffer = VkDeviceQueueCreateInfo.calloc(size)
//        for (i in indices)
//            buffer += get(i)
//        return buffer.flip()
//    }
//
//    inline fun <R>VkMemoryStack.withLong(block: VkMemoryStack.(LongBuffer) -> R): Long {
//        val pLong = mallocLong()
//        block(pLong)
//        return pLong[0]
//    }
//
////fun <R>Struct.use(block: (Struct) -> R) = block(this).also { free() }
//
//
//    fun KMutableProperty0<Long>.set(longBuffer: LongBuffer) = set(longBuffer[0])
//    fun KMutableProperty0<Int>.set(intBuffer: IntBuffer) = set(intBuffer[0])
//
//    val VkExtensionProperties.extensionName get() = extensionName()
//    var VkApplicationInfo.type: VkStructureType
//        get() = VkStructureType of sType()
//        set(value) {
//            sType(value.i)
//        }
//    var VkApplicationInfo.applicationName
//        get() = pApplicationNameString()// TODO
//        set(value) {
//            pApplicationName(value?.utf8)
//        }
//    var VkApplicationInfo.engineName
//        get() = pEngineNameString()
//        set(value) {
//            pEngineName(value?.utf8)
//        }
//    var VkApplicationInfo.apiVersion
//        get() = apiVersion()
//        set(value) {
//            apiVersion(value)
//        }
//
//
//    var VkInstanceCreateInfo.type: VkStructureType
//        get() = VkStructureType of sType()
//        set(value) {
//            sType(value.i)
//        }
//    var VkInstanceCreateInfo.next
//        get() = pNext()
//        set(value) {
//            pNext(value)
//        }
//    var VkInstanceCreateInfo.applicationInfo
//        get() = pApplicationInfo()
//        set(value) {
//            pApplicationInfo(value)
//        }
//    //    var VkInstanceCreateInfo.enabledExtensionNames
////        get() = ppEnabledExtensionNames()?.toArrayListString(enabledExtensionCount())
////        set(value) {
////            ppEnabledExtensionNames(value?.toPointerBuffer())
////        }
//    var VkInstanceCreateInfo.enabledExtensionNames
//        get() = ppEnabledExtensionNames()
//        set(value) {
//            ppEnabledExtensionNames(value)
//        }
//    var VkInstanceCreateInfo.enabledLayerNames
//        get() = ppEnabledLayerNames()
//        set(value) {
//            ppEnabledLayerNames(value)
//        }
//
//
//    var VkDebugReportCallbackCreateInfoEXT.type: VkStructureType
//        get() = VkStructureType of sType()
//        set(value) {
//            sType(value.i)
//        }
//    var VkDebugReportCallbackCreateInfoEXT.callback: VkDebugReportCallbackFunc?
////        get() = pfnCallback()
//        get() = null
//        set(value) {
//            value?.let {
//                pfnCallback { flags, objectType, `object`, location, messageCode, layerPrefix, message, userData ->
//                    val type = VkDebugReportObjectType of objectType
//                    it(flags, type, `object`, location, messageCode, layerPrefix.toUTF8,  message.toUTF8, userData as Any).i
//                }
//            }
//        }
//    var VkDebugReportCallbackCreateInfoEXT.flags
//        get() = flags()
//        set(value) {
//            flags(value)
//        }
//
//
//    var VkDeviceQueueCreateInfo.type: VkStructureType
//        get() = VkStructureType of sType()
//        set(value) {
//            sType(value.i)
//        }
//    var VkDeviceQueueCreateInfo.queueFamilyIndex
//        get() = queueFamilyIndex()
//        set(value) {
//            queueFamilyIndex(value)
//        }
//    var VkDeviceQueueCreateInfo.queuePriorities: FloatBuffer
//        get() = pQueuePriorities()
//        set(value) {
//            pQueuePriorities(value)
//        }
//
//    var VkDeviceCreateInfo.type: VkStructureType
//        get() = VkStructureType of sType()
//        set(value) {
//            sType(value.i)
//        }
//    var VkDeviceCreateInfo.queueCreateInfos: VkDeviceQueueCreateInfo.Buffer
//        get() = pQueueCreateInfos()
//        set(value) {
//            pQueueCreateInfos(value)
////            pQueueCreateInfos(VkDeviceQueueCreateInfo.create(value[0].address(), value.size))
//        }
//    var VkDeviceCreateInfo.enabledFeatures
//        get() = pEnabledFeatures()
//        set(value) {
//            pEnabledFeatures(value)
//        }
//    var VkDeviceCreateInfo.enabledExtensionNames
//        get() = ppEnabledExtensionNames()
//        set(value) {
//            ppEnabledExtensionNames(value)
//        }
//
//    var VkCommandPoolCreateInfo.type: VkStructureType
//        get() = VkStructureType of sType()
//        set(value) {
//            sType(value.i)
//        }
//    var VkCommandPoolCreateInfo.queueFamilyIndex
//        get() = queueFamilyIndex()
//        set(value) {
//            queueFamilyIndex(value)
//        }
//    var VkCommandPoolCreateInfo.flags: VkCommandPoolCreateFlags
//        get() = flags()
//        set(value) {
//            flags(value)
//        }
//
//    inline fun VkSubmitInfo.commandBuffers(array: ArrayList<VkCommandBuffer>, index: Int, count: Int = 1) {
//        val pointers = mallocPointer(count)
//        for (i in 0 until count) pointers[0] = array[index + i]
//        commandBuffers = pointers
//    }
//
//    val VkFormatProperties.optimalTilingFeatures get() = optimalTilingFeatures()
//
//    inline var VkPipelineShaderStageCreateInfo.name: String
//        get() = pNameString()
//        set(value) {
//            pName(value.utf8)
//        }
//
////    fun VkClearValue.color(x: Float, y: Float, z: Float, w: Float) {
////        val floats = memByteBuffer(adr, Vec4.size).asFloatBuffer()
////        floats[0] = x
////        floats[1] = y
////        floats[2] = z
////        floats[3] = w
////    }
//
////    fun VkClearValue.depthStencil(float: Float, int: Int) {
////        val bytes = memByteBuffer(adr, Float.BYTES + Int.BYTES)
////        bytes.putFloat(0, float)
////        bytes.putInt(Float.BYTES, int)
////    }
//
//
////    typedef union VkClearValue {
////        VkClearColorValue           color;
////        VkClearDepthStencilValue    depthStencil;
////    } VkClearValue;
////typedef union VkClearColorValue {
////    float       float32[4];
////    int32_t     int32[4];
////    uint32_t    uint32[4];
////} VkClearColorValue;
////
////typedef struct VkClearDepthStencilValue {
////    float       depth;
////    uint32_t    stencil;
////} VkClearDepthStencilValue;
//
//
////    fun VkDeviceQueueCreateInfo.Buffer.toArrayList(count: Int): ArrayList<VkDeviceQueueCreateInfo> {
////        val res = ArrayList<VkDeviceQueueCreateInfo>(count)
////        for (i in 0 until count)
////            res += get(i)
////        return res
////    }
//
////    fun ArrayList<VkDeviceQueueCreateInfo>.toVkDeviceQueueCreateInfo_Buffer(): VkDeviceQueueCreateInfo.Buffer {
////        val res = sVkDeviceQueueCreateInfo_Buffer(size)
////        for (i in indices)
////            res.put(i, get(i))
////        return res
////    }
//
//    //    inline fun mVkQueueFamilyProperties(capacity: IntBuffer): VkQueueFamilyProperties.Buffer = VkQueueFamilyProperties.create(nmalloc(VkQueueFamilyProperties.ALIGNOF, capacity[0] * VkQueueFamilyProperties.SIZEOF), capacity[0])
//    inline fun cVkQueueFamilyProperties(capacity: Int): VkQueueFamilyProperties.Buffer = VkQueueFamilyProperties.create(ncalloc(VkQueueFamilyProperties.ALIGNOF, capacity, VkQueueFamilyProperties.SIZEOF), capacity)
//
//    inline fun cVkSurfaceFormatKHR(capacity: Int): VkSurfaceFormatKHR.Buffer = VkSurfaceFormatKHR.create(ncalloc(VkSurfaceFormatKHR.ALIGNOF, capacity, VkSurfaceFormatKHR.SIZEOF), capacity)
//    //    inline fun mVkSurfaceFormatKHR(capacity: Int): VkSurfaceFormatKHR.Buffer = VkSurfaceFormatKHR.create(nmalloc(VkSurfaceFormatKHR.ALIGNOF, capacity * VkSurfaceFormatKHR.SIZEOF), capacity)
////    inline fun mVkExtensionProperties(capacity: Int): VkExtensionProperties.Buffer = VkExtensionProperties.create(nmalloc(VkExtensionProperties.ALIGNOF, capacity * VkExtensionProperties.SIZEOF), capacity)
//    inline fun cVkExtensionProperties(capacity: Int): VkExtensionProperties.Buffer = VkExtensionProperties.create(ncalloc(VkExtensionProperties.ALIGNOF, capacity, VkExtensionProperties.SIZEOF), capacity)
//
//    inline fun cVkAttachmentDescription(capacity: Int): VkAttachmentDescription.Buffer = VkAttachmentDescription.create(ncalloc(VkAttachmentDescription.ALIGNOF, capacity, VkAttachmentDescription.SIZEOF), capacity)
//    inline fun cVkApplicationInfo() = VkApplicationInfo.create(ncalloc(VkApplicationInfo.ALIGNOF, 1, VkApplicationInfo.SIZEOF))
//
//    inline fun cVkApplicationInfo(block: VkApplicationInfo.() -> Unit) = cVkApplicationInfo().also(block)
//
//    inline fun cVkInstanceCreateInfo(): VkInstanceCreateInfo = VkInstanceCreateInfo.create(ncalloc(VkInstanceCreateInfo.ALIGNOF, 1, VkInstanceCreateInfo.SIZEOF))
//    inline fun cVkInstanceCreateInfo(block: VkInstanceCreateInfo.() -> Unit) = cVkInstanceCreateInfo().also(block)
//
//    inline fun cVkDebugReportCallbackCreateInfoEXT(): VkDebugReportCallbackCreateInfoEXT = VkDebugReportCallbackCreateInfoEXT.create(ncalloc(VkDebugReportCallbackCreateInfoEXT.ALIGNOF, 1, VkDebugReportCallbackCreateInfoEXT.SIZEOF))
//    inline fun cVkDebugReportCallbackCreateInfoEXT(block: VkDebugReportCallbackCreateInfoEXT.() -> Unit) = cVkDebugReportCallbackCreateInfoEXT().also(block)
//
////    inline fun mVkDeviceQueueCreateInfo(capacity: Int): VkDeviceQueueCreateInfo.Buffer = VkDeviceQueueCreateInfo.create(nmalloc(VkDeviceQueueCreateInfo.ALIGNOF, capacity * VkDeviceQueueCreateInfo.SIZEOF), capacity)
//    inline fun cVkDeviceQueueCreateInfo(capacity: Int): VkDeviceQueueCreateInfo.Buffer = VkDeviceQueueCreateInfo.create(ncalloc(VkDeviceQueueCreateInfo.ALIGNOF, capacity, VkDeviceQueueCreateInfo.SIZEOF), capacity)
//    inline fun cVkDeviceQueueCreateInfo(): VkDeviceQueueCreateInfo = VkDeviceQueueCreateInfo.create(ncalloc(VkInstanceCreateInfo.ALIGNOF, 1, VkInstanceCreateInfo.SIZEOF))
//    inline fun cVkDeviceQueueCreateInfo(block: VkDeviceQueueCreateInfo.() -> Unit) = cVkDeviceQueueCreateInfo().also(block)
//
//    inline fun cVkCommandPoolCreateInfo(): VkCommandPoolCreateInfo = VkCommandPoolCreateInfo.create(ncalloc(VkCommandPoolCreateInfo.ALIGNOF, 1, VkCommandPoolCreateInfo.SIZEOF))
//    inline fun cVkCommandPoolCreateInfo(block: VkCommandPoolCreateInfo.() -> Unit) = cVkCommandPoolCreateInfo().also(block)
//
////    inline fun mVkFormatProperties(): VkFormatProperties = VkFormatProperties.create(nmalloc(VkFormatProperties.ALIGNOF, VkFormatProperties.SIZEOF))
//    inline fun cVkFormatProperties(): VkFormatProperties = VkFormatProperties.create(ncalloc(VkFormatProperties.ALIGNOF, 1, VkFormatProperties.SIZEOF))
//
//    inline fun cVkSemaphoreCreateInfo(): VkSemaphoreCreateInfo = VkSemaphoreCreateInfo.create(ncalloc(VkSemaphoreCreateInfo.ALIGNOF, 1, VkSemaphoreCreateInfo.SIZEOF))
//    inline fun cVkSemaphoreCreateInfo(block: VkSemaphoreCreateInfo.() -> Unit) = cVkSemaphoreCreateInfo().also(block)
//
//    inline fun cVkFenceCreateInfo(): VkFenceCreateInfo = VkFenceCreateInfo.create(ncalloc(VkFenceCreateInfo.ALIGNOF, 1, VkFenceCreateInfo.SIZEOF))
//    inline fun cVkFenceCreateInfo(block: VkFenceCreateInfo.() -> Unit) = cVkFenceCreateInfo().also(block)
//
//    inline fun cVkSubmitInfo(): VkSubmitInfo = VkSubmitInfo.create(ncalloc(VkSubmitInfo.ALIGNOF, 1, VkSubmitInfo.SIZEOF))
//    inline fun cVkSubmitInfo(block: VkSubmitInfo.() -> Unit) = cVkSubmitInfo().also(block)
//
//    inline fun cVkSurfaceCapabilitiesKHR(): VkSurfaceCapabilitiesKHR = VkSurfaceCapabilitiesKHR.create(ncalloc(VkSurfaceCapabilitiesKHR.ALIGNOF, 1, VkSurfaceCapabilitiesKHR.SIZEOF))
//    inline fun cVkSurfaceCapabilitiesKHR(block: VkSurfaceCapabilitiesKHR.() -> Unit) = cVkSurfaceCapabilitiesKHR().also(block)
//
////    inline fun mVkSurfaceCapabilitiesKHR(): VkSurfaceCapabilitiesKHR = VkSurfaceCapabilitiesKHR.create(nmalloc(VkSurfaceCapabilitiesKHR.ALIGNOF, VkSurfaceCapabilitiesKHR.SIZEOF))
//
//    inline fun cVkExtent2D(): VkExtent2D = VkExtent2D.create(ncalloc(VkExtent2D.ALIGNOF, 1, VkExtent2D.SIZEOF))
//
//    inline fun cVkSwapchainCreateInfoKHR(): VkSwapchainCreateInfoKHR = VkSwapchainCreateInfoKHR.create(ncalloc(VkSwapchainCreateInfoKHR.ALIGNOF, 1, VkSwapchainCreateInfoKHR.SIZEOF))
//    inline fun cVkSwapchainCreateInfoKHR(block: VkSwapchainCreateInfoKHR.() -> Unit) = cVkSwapchainCreateInfoKHR().also(block)
//
//    inline fun cVkDeviceCreateInfo(): VkDeviceCreateInfo = VkDeviceCreateInfo.create(ncalloc(VkDeviceCreateInfo.ALIGNOF, 1, VkDeviceCreateInfo.SIZEOF))
//    inline fun cVkDeviceCreateInfo(block: VkDeviceCreateInfo.() -> Unit) = cVkDeviceCreateInfo().also(block)
//
////    inline fun mVkImageViewCreateInfo(): VkImageViewCreateInfo = VkImageViewCreateInfo.create(nmalloc(VkImageViewCreateInfo.ALIGNOF, VkImageViewCreateInfo.SIZEOF))
////    inline fun mVkImageViewCreateInfo(block: VkImageViewCreateInfo.() -> Unit) = mVkImageViewCreateInfo().also(block)
//    inline fun cVkImageViewCreateInfo(): VkImageViewCreateInfo = VkImageViewCreateInfo.create(ncalloc(VkImageViewCreateInfo.ALIGNOF, 1, VkImageViewCreateInfo.SIZEOF))
//    inline fun cVkImageViewCreateInfo(block: VkImageViewCreateInfo .() -> Unit) = cVkImageViewCreateInfo().also(block)
//
//    inline fun cVkCommandBufferAllocateInfo(): VkCommandBufferAllocateInfo = VkCommandBufferAllocateInfo.create(ncalloc(VkCommandBufferAllocateInfo.ALIGNOF, 1, VkCommandBufferAllocateInfo.SIZEOF))
//    inline fun cVkCommandBufferAllocateInfo(block: VkCommandBufferAllocateInfo.() -> Unit) = cVkCommandBufferAllocateInfo().also(block)
////    inline fun mVkCommandBufferAllocateInfo(): VkCommandBufferAllocateInfo = VkCommandBufferAllocateInfo.create(nmalloc(VkCommandBufferAllocateInfo.ALIGNOF, VkCommandBufferAllocateInfo.SIZEOF))
////    inline fun mVkCommandBufferAllocateInfo(block: VkCommandBufferAllocateInfo.() -> Unit) = mVkCommandBufferAllocateInfo().also(block)
//
//    inline fun cVkImageCreateInfo(): VkImageCreateInfo = VkImageCreateInfo.create(ncalloc(VkImageCreateInfo.ALIGNOF, 1, VkImageCreateInfo.SIZEOF))
//    inline fun cVkImageCreateInfo(block: VkImageCreateInfo.() -> Unit) = cVkImageCreateInfo().also(block)
//
//
//    inline fun cVkMemoryAllocateInfo(): VkMemoryAllocateInfo = VkMemoryAllocateInfo.create(ncalloc(VkMemoryAllocateInfo.ALIGNOF, 1, VkMemoryAllocateInfo.SIZEOF))
//    inline fun cVkMemoryAllocateInfo(block: VkMemoryAllocateInfo.() -> Unit) = cVkMemoryAllocateInfo().also(block)
//    inline fun cVkMemoryRequirements(): VkMemoryRequirements = VkMemoryRequirements.create(ncalloc(VkMemoryRequirements.ALIGNOF, 1, VkMemoryRequirements.SIZEOF))
//
//    inline fun cVkAttachmentReference(): VkAttachmentReference = VkAttachmentReference.create(ncalloc(VkAttachmentReference.ALIGNOF, 1, VkAttachmentReference.SIZEOF))
//    inline fun cVkAttachmentReference(block: VkAttachmentReference.() -> Unit) = cVkAttachmentReference().also(block)
//    // TODO c m
//    inline fun cVkAttachmentReference(capacity: Int): VkAttachmentReference.Buffer = VkAttachmentReference.create(ncalloc(VkAttachmentReference.ALIGNOF, capacity, VkAttachmentReference.SIZEOF), capacity)
//
//    inline fun cVkAttachmentReference(capacity: Int, block: VkAttachmentReference.() -> Unit) = cVkAttachmentReference(capacity).apply { get(0).block() }
//
//    inline fun cVkSubpassDescription(): VkSubpassDescription = VkSubpassDescription.create(ncalloc(VkSubpassDescription.ALIGNOF, 1, VkSubpassDescription.SIZEOF))
//    inline fun cVkSubpassDescription(block: VkSubpassDescription.() -> Unit) = cVkSubpassDescription().also(block)
//    inline fun cVkSubpassDescription(capacity: Int): VkSubpassDescription.Buffer = VkSubpassDescription.create(ncalloc(VkSubpassDescription.ALIGNOF, capacity, VkSubpassDescription.SIZEOF), capacity)
//    inline fun cVkSubpassDescription(capacity: Int, block: VkSubpassDescription.() -> Unit) = cVkSubpassDescription(capacity).apply { get(0).block() }
//
//    inline fun cVkSubpassDependency(capacity: Int): VkSubpassDependency.Buffer = VkSubpassDependency.create(ncalloc(VkSubpassDependency.ALIGNOF, capacity, VkSubpassDependency.SIZEOF), capacity)
//    inline fun cVkSubpassDependency(capacity: Int, block: VkSubpassDependency.() -> Unit) = cVkSubpassDependency(capacity).apply { get(0).block() }
//
//    inline fun cVkRenderPassCreateInfo(): VkRenderPassCreateInfo = VkRenderPassCreateInfo.create(ncalloc(VkRenderPassCreateInfo.ALIGNOF, 1, VkRenderPassCreateInfo.SIZEOF))
//    inline fun cVkRenderPassCreateInfo(block: VkRenderPassCreateInfo.() -> Unit) = cVkRenderPassCreateInfo().also(block)
//
//    inline fun cVkPipelineCacheCreateInfo(): VkPipelineCacheCreateInfo = VkPipelineCacheCreateInfo.create(ncalloc(VkPipelineCacheCreateInfo.ALIGNOF, 1, VkPipelineCacheCreateInfo.SIZEOF))
//    inline fun cVkPipelineCacheCreateInfo(block: VkPipelineCacheCreateInfo.() -> Unit) = cVkPipelineCacheCreateInfo().also(block)
//
//    inline fun cVkFramebufferCreateInfo(): VkFramebufferCreateInfo = VkFramebufferCreateInfo.create(ncalloc(VkFramebufferCreateInfo.ALIGNOF, 1, VkFramebufferCreateInfo.SIZEOF))
//    inline fun cVkFramebufferCreateInfo(block: VkFramebufferCreateInfo.() -> Unit) = cVkFramebufferCreateInfo().also(block)
//
//    inline fun cVkPresentInfoKHR(): VkPresentInfoKHR = VkPresentInfoKHR.create(ncalloc(VkPresentInfoKHR.ALIGNOF, 1, VkPresentInfoKHR.SIZEOF))
//    inline fun cVkPresentInfoKHR(block: VkPresentInfoKHR.() -> Unit) = cVkPresentInfoKHR().also(block)
//
//    inline fun cVkBufferCreateInfo(): VkBufferCreateInfo = VkBufferCreateInfo.create(ncalloc(VkBufferCreateInfo.ALIGNOF, 1, VkBufferCreateInfo.SIZEOF))
//    inline fun cVkBufferCreateInfo(block: VkBufferCreateInfo.() -> Unit) = cVkBufferCreateInfo().also(block)
//
//    inline fun cVkCommandBufferBeginInfo(): VkCommandBufferBeginInfo = VkCommandBufferBeginInfo.create(ncalloc(VkCommandBufferBeginInfo.ALIGNOF, 1, VkCommandBufferBeginInfo.SIZEOF))
//    inline fun cVkCommandBufferBeginInfo(block: VkCommandBufferBeginInfo.() -> Unit) = cVkCommandBufferBeginInfo().also(block)
//
//    inline fun cVkDescriptorSetLayoutBinding(): VkDescriptorSetLayoutBinding = VkDescriptorSetLayoutBinding.create(ncalloc(VkDescriptorSetLayoutBinding.ALIGNOF, 1, VkDescriptorSetLayoutBinding.SIZEOF))
//    inline fun cVkDescriptorSetLayoutBinding(block: VkDescriptorSetLayoutBinding.() -> Unit) = cVkDescriptorSetLayoutBinding().also(block)
//    inline fun cVkDescriptorSetLayoutBinding(capacity: Int): VkDescriptorSetLayoutBinding.Buffer = VkDescriptorSetLayoutBinding.create(ncalloc(VkDescriptorSetLayoutBinding.ALIGNOF, capacity, VkDescriptorSetLayoutBinding.SIZEOF), capacity)
//    inline fun cVkDescriptorSetLayoutBinding(capacity: Int, block: VkDescriptorSetLayoutBinding.() -> Unit) = cVkDescriptorSetLayoutBinding(capacity).apply { get(0).block() }
//
//    inline fun cVkDescriptorSetLayoutCreateInfo(): VkDescriptorSetLayoutCreateInfo = VkDescriptorSetLayoutCreateInfo.create(ncalloc(VkDescriptorSetLayoutCreateInfo.ALIGNOF, 1, VkDescriptorSetLayoutCreateInfo.SIZEOF))
//    inline fun cVkDescriptorSetLayoutCreateInfo(block: VkDescriptorSetLayoutCreateInfo .() -> Unit) = cVkDescriptorSetLayoutCreateInfo().also(block)
//
//    inline fun cVkPipelineLayoutCreateInfo(): VkPipelineLayoutCreateInfo = VkPipelineLayoutCreateInfo.create(ncalloc(VkPipelineLayoutCreateInfo.ALIGNOF, 1, VkPipelineLayoutCreateInfo.SIZEOF))
//    inline fun cVkPipelineLayoutCreateInfo(block: VkPipelineLayoutCreateInfo.() -> Unit) = cVkPipelineLayoutCreateInfo().also(block)
//
//    inline fun cVkGraphicsPipelineCreateInfo(): VkGraphicsPipelineCreateInfo = VkGraphicsPipelineCreateInfo.create(ncalloc(VkGraphicsPipelineCreateInfo.ALIGNOF, 1, VkGraphicsPipelineCreateInfo.SIZEOF))
//    inline fun cVkGraphicsPipelineCreateInfo(block: VkGraphicsPipelineCreateInfo.() -> Unit) = cVkGraphicsPipelineCreateInfo().also(block)
//    inline fun cVkGraphicsPipelineCreateInfo(capacity: Int): VkGraphicsPipelineCreateInfo.Buffer = VkGraphicsPipelineCreateInfo.create(ncalloc(VkGraphicsPipelineCreateInfo.ALIGNOF, capacity, VkGraphicsPipelineCreateInfo.SIZEOF), capacity)
//    inline fun cVkGraphicsPipelineCreateInfo(capacity: Int, block: VkGraphicsPipelineCreateInfo.() -> Unit) = cVkGraphicsPipelineCreateInfo(capacity).apply { get(0).block() }
//
//
//    inline fun cVkPipelineViewportStateCreateInfo(): VkPipelineViewportStateCreateInfo = VkPipelineViewportStateCreateInfo.create(ncalloc(VkPipelineViewportStateCreateInfo.ALIGNOF, 1, VkPipelineViewportStateCreateInfo.SIZEOF))
//    inline fun cVkPipelineViewportStateCreateInfo(block: VkPipelineViewportStateCreateInfo.() -> Unit) = cVkPipelineViewportStateCreateInfo().also(block)
//
//    inline fun cVkPipelineDynamicStateCreateInfo(): VkPipelineDynamicStateCreateInfo = VkPipelineDynamicStateCreateInfo.create(ncalloc(VkPipelineDynamicStateCreateInfo.ALIGNOF, 1, VkPipelineDynamicStateCreateInfo.SIZEOF))
//    inline fun cVkPipelineDynamicStateCreateInfo(block: VkPipelineDynamicStateCreateInfo.() -> Unit) = cVkPipelineDynamicStateCreateInfo().also(block)
//
//    inline fun cVkPipelineInputAssemblyStateCreateInfo(): VkPipelineInputAssemblyStateCreateInfo = VkPipelineInputAssemblyStateCreateInfo.create(ncalloc(VkPipelineInputAssemblyStateCreateInfo.ALIGNOF, 1, VkPipelineInputAssemblyStateCreateInfo.SIZEOF))
//    inline fun cVkPipelineInputAssemblyStateCreateInfo(block: VkPipelineInputAssemblyStateCreateInfo.() -> Unit) = cVkPipelineInputAssemblyStateCreateInfo().also(block)
//
//    inline fun cVkPipelineRasterizationStateCreateInfo(): VkPipelineRasterizationStateCreateInfo = VkPipelineRasterizationStateCreateInfo.create(ncalloc(VkPipelineRasterizationStateCreateInfo.ALIGNOF, 1, VkPipelineRasterizationStateCreateInfo.SIZEOF))
//    inline fun cVkPipelineRasterizationStateCreateInfo(block: VkPipelineRasterizationStateCreateInfo.() -> Unit) = cVkPipelineRasterizationStateCreateInfo().also(block)
//
//    inline fun cVkPipelineColorBlendStateCreateInfo(): VkPipelineColorBlendStateCreateInfo = VkPipelineColorBlendStateCreateInfo.create(ncalloc(VkPipelineColorBlendStateCreateInfo.ALIGNOF, 1, VkPipelineColorBlendStateCreateInfo.SIZEOF))
//    inline fun cVkPipelineColorBlendStateCreateInfo(block: VkPipelineColorBlendStateCreateInfo.() -> Unit) = cVkPipelineColorBlendStateCreateInfo().also(block)
//
//    inline fun cVkPipelineDepthStencilStateCreateInfo(): VkPipelineDepthStencilStateCreateInfo = VkPipelineDepthStencilStateCreateInfo.create(ncalloc(VkPipelineDepthStencilStateCreateInfo.ALIGNOF, 1, VkPipelineDepthStencilStateCreateInfo.SIZEOF))
//    inline fun cVkPipelineDepthStencilStateCreateInfo(block: VkPipelineDepthStencilStateCreateInfo.() -> Unit) = cVkPipelineDepthStencilStateCreateInfo().also(block)
//
//    inline fun cVkPipelineMultisampleStateCreateInfo(): VkPipelineMultisampleStateCreateInfo = VkPipelineMultisampleStateCreateInfo.create(ncalloc(VkPipelineMultisampleStateCreateInfo.ALIGNOF, 1, VkPipelineMultisampleStateCreateInfo.SIZEOF))
//    inline fun cVkPipelineMultisampleStateCreateInfo(block: VkPipelineMultisampleStateCreateInfo.() -> Unit) = cVkPipelineMultisampleStateCreateInfo().also(block)
//
//    inline fun cVkVertexInputBindingDescription(): VkVertexInputBindingDescription = VkVertexInputBindingDescription.create(ncalloc(VkVertexInputBindingDescription.ALIGNOF, 1, VkVertexInputBindingDescription.SIZEOF))
//    inline fun cVkVertexInputBindingDescription(block: VkVertexInputBindingDescription.() -> Unit) = cVkVertexInputBindingDescription().also(block)
//    inline fun cVkVertexInputBindingDescription(capacity: Int): VkVertexInputBindingDescription.Buffer = VkVertexInputBindingDescription.create(ncalloc(VkVertexInputBindingDescription.ALIGNOF, capacity, VkVertexInputBindingDescription.SIZEOF), capacity)
//    inline fun cVkVertexInputBindingDescription(capacity: Int, block: VkVertexInputBindingDescription.() -> Unit) = cVkVertexInputBindingDescription(capacity).apply { get(0).block() }
//
//    inline fun cVkPipelineShaderStageCreateInfo(capacity: Int): VkPipelineShaderStageCreateInfo.Buffer = VkPipelineShaderStageCreateInfo.create(ncalloc(VkPipelineShaderStageCreateInfo.ALIGNOF, capacity, VkPipelineShaderStageCreateInfo.SIZEOF), capacity)
//    inline fun cVkPipelineShaderStageCreateInfo(capacity: Int, block: VkPipelineShaderStageCreateInfo.() -> Unit) = cVkPipelineShaderStageCreateInfo(capacity).apply { get(0).block() }
//
//    inline fun cVkDescriptorPoolSize(capacity: Int): VkDescriptorPoolSize.Buffer = VkDescriptorPoolSize.create(ncalloc(VkDescriptorPoolSize.ALIGNOF, capacity, VkDescriptorPoolSize.SIZEOF), capacity)
//    inline fun cVkDescriptorPoolSize(capacity: Int, block: VkDescriptorPoolSize.() -> Unit) = cVkDescriptorPoolSize(capacity).apply { get(0).block() }
//
//    inline fun cVkPipelineVertexInputStateCreateInfo(): VkPipelineVertexInputStateCreateInfo = VkPipelineVertexInputStateCreateInfo.create(ncalloc(VkPipelineVertexInputStateCreateInfo.ALIGNOF, 1, VkPipelineVertexInputStateCreateInfo.SIZEOF))
//    inline fun cVkPipelineVertexInputStateCreateInfo(block: VkPipelineVertexInputStateCreateInfo.() -> Unit) = cVkPipelineVertexInputStateCreateInfo().also(block)
//
//    inline fun cVkDescriptorPoolCreateInfo(): VkDescriptorPoolCreateInfo = VkDescriptorPoolCreateInfo.create(ncalloc(VkDescriptorPoolCreateInfo.ALIGNOF, 1, VkDescriptorPoolCreateInfo.SIZEOF))
//    inline fun cVkDescriptorPoolCreateInfo(block: VkDescriptorPoolCreateInfo.() -> Unit) = cVkDescriptorPoolCreateInfo().also(block)
//
//    inline fun cVkShaderModuleCreateInfo(): VkShaderModuleCreateInfo = VkShaderModuleCreateInfo.create(ncalloc(VkShaderModuleCreateInfo.ALIGNOF, 1, VkShaderModuleCreateInfo.SIZEOF))
//    inline fun cVkShaderModuleCreateInfo(block: VkShaderModuleCreateInfo.() -> Unit) = cVkShaderModuleCreateInfo().also(block)
//
//    inline fun cVkDescriptorSetAllocateInfo(): VkDescriptorSetAllocateInfo = VkDescriptorSetAllocateInfo.create(ncalloc(VkDescriptorSetAllocateInfo.ALIGNOF, 1, VkDescriptorSetAllocateInfo.SIZEOF))
//    inline fun cVkDescriptorSetAllocateInfo(block: VkDescriptorSetAllocateInfo.() -> Unit) = cVkDescriptorSetAllocateInfo().also(block)
//
//    inline fun cVkRenderPassBeginInfo(): VkRenderPassBeginInfo = VkRenderPassBeginInfo.create(ncalloc(VkRenderPassBeginInfo.ALIGNOF, 1, VkRenderPassBeginInfo.SIZEOF))
//    inline fun cVkRenderPassBeginInfo(block: VkRenderPassBeginInfo.() -> Unit) = cVkRenderPassBeginInfo().also(block)
//
//    inline fun cVkViewport(): VkViewport = VkViewport.create(ncalloc(VkViewport.ALIGNOF, 1, VkViewport.SIZEOF))
//    inline fun cVkViewport(block: VkViewport .() -> Unit) = cVkViewport().also(block)
//    inline fun cVkViewport(capacity: Int): VkViewport.Buffer = VkViewport.create(ncalloc(VkViewport.ALIGNOF, capacity, VkViewport.SIZEOF), capacity)
//    inline fun cVkViewport(capacity: Int, block: VkViewport.() -> Unit) = cVkViewport(capacity).apply { get(0).block() }
//
//    inline fun cVkRect2D(): VkRect2D = VkRect2D.create(ncalloc(VkRect2D.ALIGNOF, 1, VkRect2D.SIZEOF))
//    inline fun cVkRect2D(block: VkRect2D .() -> Unit) = cVkRect2D().also(block)
//    inline fun cVkRect2D(capacity: Int): VkRect2D.Buffer = VkRect2D.create(ncalloc(VkRect2D.ALIGNOF, capacity, VkRect2D.SIZEOF), capacity)
//    inline fun cVkRect2D(capacity: Int, block: VkRect2D.() -> Unit) = cVkRect2D(capacity).apply { get(0).block() }
//
//    inline fun cVkWriteDescriptorSet(): VkWriteDescriptorSet = VkWriteDescriptorSet.create(ncalloc(VkWriteDescriptorSet.ALIGNOF, 1, VkWriteDescriptorSet.SIZEOF))
//    inline fun cVkWriteDescriptorSet(block: VkWriteDescriptorSet.() -> Unit) = cVkWriteDescriptorSet().also(block)
//    inline fun cVkWriteDescriptorSet(capacity: Int): VkWriteDescriptorSet.Buffer = VkWriteDescriptorSet.create(ncalloc(VkWriteDescriptorSet.ALIGNOF, capacity, VkWriteDescriptorSet.SIZEOF), capacity)
//    inline fun cVkWriteDescriptorSet(capacity: Int, block: VkWriteDescriptorSet.() -> Unit) = cVkWriteDescriptorSet(capacity).apply { get(0).block() }
//
//    inline fun cVkClearValue(): VkClearValue = VkClearValue.create(ncalloc(VkClearValue.ALIGNOF, 1, VkClearValue.SIZEOF))
//    inline fun cVkClearValue(block: VkClearValue.() -> Unit) = cVkClearValue().also(block)
//    inline fun cVkClearValue(capacity: Int): VkClearValue.Buffer = VkClearValue.create(ncalloc(VkClearValue.ALIGNOF, capacity, VkClearValue.SIZEOF), capacity)
//    inline fun cVkClearValue(capacity: Int, block: VkClearValue.() -> Unit) = cVkClearValue(capacity).apply { get(0).block() }
//
////    inline fun cVkStencilOpState(): VkStencilOpState = VkStencilOpState.create(ncalloc(VkStencilOpState.ALIGNOF, 1, VkStencilOpState.SIZEOF))
////    inline fun cVkStencilOpState(block: VkStencilOpState.() -> Unit) = cVkStencilOpState().also(block)
//
//    inline fun cVkBufferCopy(): VkBufferCopy = VkBufferCopy.create(ncalloc(VkBufferCopy.ALIGNOF, 1, VkBufferCopy.SIZEOF))
//    inline fun cVkBufferCopy(block: VkBufferCopy.() -> Unit) = cVkBufferCopy().also(block)
//    inline fun cVkBufferCopy(capacity: Int): VkBufferCopy.Buffer = VkBufferCopy.create(ncalloc(VkBufferCopy.ALIGNOF, capacity, VkBufferCopy.SIZEOF), capacity)
//    inline fun cVkBufferCopy(capacity: Int, block: VkBufferCopy.() -> Unit) = cVkBufferCopy(capacity).apply { get(0).block() }
//
//    inline fun cVkVertexInputAttributeDescription(capacity: Int): VkVertexInputAttributeDescription.Buffer = VkVertexInputAttributeDescription.create(ncalloc(VkVertexInputAttributeDescription.ALIGNOF, capacity, VkVertexInputAttributeDescription.SIZEOF), capacity)
//    inline fun cVkVertexInputAttributeDescription(capacity: Int, block: VkVertexInputAttributeDescription.() -> Unit) = cVkVertexInputAttributeDescription(capacity).apply { get(0).block() }
//
//    inline fun cVkPipelineColorBlendAttachmentState(): VkPipelineColorBlendAttachmentState = VkPipelineColorBlendAttachmentState.create(ncalloc(VkPipelineColorBlendAttachmentState.ALIGNOF, 1, VkPipelineColorBlendAttachmentState.SIZEOF))
//    inline fun cVkPipelineColorBlendAttachmentState(block: VkPipelineColorBlendAttachmentState.() -> Unit) = cVkPipelineColorBlendAttachmentState().also(block)
//    inline fun cVkPipelineColorBlendAttachmentState(capacity: Int): VkPipelineColorBlendAttachmentState.Buffer = VkPipelineColorBlendAttachmentState.create(ncalloc(VkPipelineColorBlendAttachmentState.ALIGNOF, capacity, VkPipelineColorBlendAttachmentState.SIZEOF), capacity)
//    inline fun cVkPipelineColorBlendAttachmentState(capacity: Int, block: VkPipelineColorBlendAttachmentState.() -> Unit) = cVkPipelineColorBlendAttachmentState(capacity).apply { get(0).block() }
//
//    inline fun cVkImageView(capacity: Int) = callocLong(capacity)
//    inline fun vkImageViewOf(view0: VkImageView, view1: VkImageView): VkImageViewBuffer = longs(view0, view1)
//
//    operator fun PointerBuffer.plusAssign(string: String) {
//        put(string.utf8)
//    }
//
//    operator fun PointerBuffer.plusAssign(pointerBuffer: PointerBuffer) {
//        put(pointerBuffer)
//    }
//
//    operator fun PointerBuffer.plusAssign(collection: Collection<String>) {
//        for (i in collection)
//            put(i.utf8)
//    }
//
//    operator fun VkDeviceQueueCreateInfo.Buffer.plusAssign(info: VkDeviceQueueCreateInfo) {
//        put(info)
//    }
//
//    fun VkCommandBuffer.toPointerBuffer() = pointers(adr)
//    fun Long.toLongBuffer() = longs(this)
//
//    override fun push(): VkMemoryStack {
//        super.push()
//        return this
//    }
//
//    companion object {
//
//        private val DEFAULT_STACK_SIZE = Configuration.STACK_SIZE.get(64) * 1024
//        private val DEFAULT_STACK_FRAMES = 8
//
//        private val TLS = ThreadLocal.withInitial<VkMemoryStack>({ create() })
//
//        init {
//            if (DEFAULT_STACK_SIZE < 0)
//                throw IllegalStateException("Invalid stack size.")
//        }
//
//        /**
//         * Creates a new [MemoryStackPlus] with the specified size.
//         *
//         * @param size the maximum number of bytes that may be allocated on the stack
//         */
//        @JvmOverloads
//        fun create(size: Int = DEFAULT_STACK_SIZE) = VkMemoryStack(size)
//
//        /** Returns the stack of the current thread.  */
//        fun stackGet() = TLS.get()
//
//        inline fun <R> withStack(block: VkMemoryStack.() -> R): R {
//            var exception: Throwable? = null
//            val stack = stackGet().push()
//            try {
//                return stack.block()
//            } catch (e: Throwable) {
//                exception = e
//                throw e
//            } finally {
//                stack.closeFinally(exception)
//            }
//        }
//
////        @SinceKotlin("1.1")
////        @Suppress("INVISIBLE_REFERENCE", "INVISIBLE_MEMBER")
////        @kotlin.internal.InlineOnly
////        inline fun <T : AutoCloseable?, R> T.use(block: (T) -> R): R {
////            var exception: Throwable? = null
////            try {
////                return block(this)
////            } catch (e: Throwable) {
////                exception = e
////                throw e
////            } finally {
////                this.closeFinally(exception)
////            }
////        }
//
//        @SinceKotlin("1.1")
//        @PublishedApi
//        internal fun AutoCloseable?.closeFinally(cause: Throwable?) = when {
//            this == null -> Unit
//            cause == null -> close()
//            else ->
//                try {
//                    close()
//                } catch (closeException: Throwable) {
//                    cause.addSuppressed(closeException)
//                }
//        }
//    }
//
//    val Long.utf8: String get() = MemoryUtil.memUTF8(this)
//    val ByteBuffer.utf8: String get() = MemoryUtil.memUTF8(this)
//}
//
typealias VkDebugReportCallbackFunc = (VkDebugReportFlagsEXT, VkDebugReportObjectType, Long, Long, Int, String, String, Any?) -> Boolean
//
////var vkDebugReportCallback: VkDebugReportCallback? = null
////
////class VkDebugReportCallback : VkDebugReportCallbackEXT() {
//////    val instance: VkDebugReportCallbackEXT = create(address)
////    var cb: VkDebugReportCallbackFunc? = null
////    override fun invoke(flags: VkDebugReportFlagsEXT, objectType: VkDebugReportObjectTypeEXT, `object`: Long, location: Long,
////                        messageCode: Int, pLayerPrefix: Long, pMessage: Long, userData: Long): VkBool32 = withStack {
////        val layerPrefix = getString(pLayerPrefix)
////        val message = getString(pMessage)
////        println("ou")
////        return cb?.invoke(flags, objectType, `object`, location, messageCode, layerPrefix, message, userData)?.i
////                ?: VK_FALSE
////    }
////}