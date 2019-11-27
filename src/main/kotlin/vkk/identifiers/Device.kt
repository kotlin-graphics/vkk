package identifiers

import classes.*
import kool.*
import org.lwjgl.system.APIUtil.apiLog
import org.lwjgl.system.Checks
import org.lwjgl.system.FunctionProvider
import org.lwjgl.system.JNI.*
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.vulkan.*
import vkk.*
import vkk.classes.FramebufferCreateInfo
import vkk.entities.*

/** Wraps a Vulkan device dispatchable handle. */
class Device(
        handle: Ptr,
        val physicalDevice: PhysicalDevice, ci: DeviceCreateInfo, apiVersion: Int = 0
) : DispatchableHandleDevice(handle, getDeviceCapabilities(handle, physicalDevice, ci, apiVersion)) {

    // --- [ vkAcquireNextImageKHR ] ---
    fun acquireNextImageKHR(swapchain: VkSwapchainKHR, timeout: Long = -1L, semaphore: VkSemaphore, fence: VkFence = VkFence(NULL)): Int =
            stak {
                val p = it.nmalloc(Int.BYTES, Int.SIZE_BYTES)
                VK_CHECK_RESULT(
                        callPJJJJPI(adr, swapchain.L, timeout, semaphore.L, fence.L, p, capabilities.vkAcquireNextImageKHR)
                )
                memGetInt(p)
            }

    // --- [ vkAllocateCommandBuffers ] ---
    inline fun nAllocateCommandBuffers(pAllocateInfo: Ptr, pCommandBuffers: Ptr): VkResult =
            VkResult(callPPPI(adr, pAllocateInfo, pCommandBuffers, capabilities.vkAllocateCommandBuffers))

    infix fun allocateCommandBuffer(allocateInfo: CommandBufferAllocateInfo): CommandBuffer = stak { s ->
        CommandBuffer(s.pointerAdr { nAllocateCommandBuffers(allocateInfo.write(s), it).check() }, this)
    }

    infix fun allocateCommandBuffers(allocateInfo: CommandBufferAllocateInfo): Array<CommandBuffer> = stak { s ->
        val pCommandBuffers = s.mPointer(allocateInfo.commandBufferCount)
        nAllocateCommandBuffers(allocateInfo.write(s), pCommandBuffers.adr)
        Array(allocateInfo.commandBufferCount) {
            CommandBuffer(memGetAddress(pCommandBuffers[it]), this)
        }
    }

    // --- [ vkAllocateMemory ] ---
    infix fun allocateMemory(allocateInfo: MemoryAllocateInfo): VkDeviceMemory = stak { s ->
        VkDeviceMemory(s.longAdr {
            callPPPPI(adr, allocateInfo.write(s), NULL, it, capabilities.vkAllocateMemory)
        })
    }

    // --- [ vkBindBufferMemory ] ---
    fun bindBufferMemory(buffer: VkBuffer, memory: VkDeviceMemory, memoryOffset: VkDeviceSize = VkDeviceSize(0)): VkResult =
            VkResult(callPJJJI(adr, buffer.L, memory.L, memoryOffset.L, capabilities.vkBindBufferMemory)).apply { check() }

    // --- [ vkCreateBuffer ] ---
    infix fun createBuffer(createInfo: BufferCreateInfo): VkBuffer = stak { s ->
        VkBuffer(s.longAdr { callPPPPI(adr, createInfo.write(s), NULL, it, capabilities.vkCreateBuffer) })
    }

    // --- [ vkCreateCommandPool ] ---
    infix fun createCommandPool(createInfo: CommandPoolCreateInfo): VkCommandPool = stak { s ->
        VkCommandPool(s.longAdr { callPPPPI(adr, createInfo.write(s), NULL, it, capabilities.vkCreateCommandPool) })
    }

    // --- [ vkCreateFramebuffer ] ---
    inline fun nCreateFramebuffer(createInfo: Ptr, framebuffer: Ptr): VkResult =
            VkResult(callPPPPI(adr, createInfo, NULL, framebuffer, capabilities.vkCreateFramebuffer))

    infix fun createFramebuffer(createInfo: FramebufferCreateInfo): VkFramebuffer = stak { s ->
        VkFramebuffer(s.longAdr { nCreateFramebuffer(createInfo.write(s), it).check() })
    }

    // JVM
    fun createFramebufferArray(createInfo: FramebufferCreateInfo, imageViews: VkImageView_Array): VkFramebuffer_Array = stak { s ->
        val pCreateInfo = createInfo.write(s)
        VkFramebufferCreateInfo.nattachmentCount(pCreateInfo, 1)
        val pAttachment = s.mLong()
        memPutAddress(pCreateInfo + VkFramebufferCreateInfo.PATTACHMENTS, pAttachment.adr)
        val pFramebuffer = s.mLong()
        VkFramebuffer_Array(imageViews.size) { i ->
            pAttachment[0] = imageViews[i].L
            nCreateFramebuffer(pCreateInfo, pFramebuffer.adr).check()
            VkFramebuffer(pFramebuffer[0])
        }
    }

    // --- [ vkCreateGraphicsPipelines ] ---
    infix fun createGraphicsPipeline(createInfo: GraphicsPipelineCreateInfo): VkPipeline =
            createGraphicsPipeline(VkPipelineCache.NULL, createInfo)

    fun createGraphicsPipeline(pipelineCache: VkPipelineCache, createInfo: GraphicsPipelineCreateInfo): VkPipeline =
            VkPipeline(stak { s ->
                s.longAdr {
                    callPJPPPI(adr, pipelineCache.L, 1, createInfo.write(s), NULL, it, capabilities.vkCreateGraphicsPipelines)
                }
            })

    // --- [ vkCreateImageView ] ---
    inline fun nCreateImageView(createInfo: Ptr, imageView: Ptr): VkResult =
            VkResult(callPPPPI(adr, createInfo, NULL, imageView, capabilities.vkCreateImageView))

    infix fun createImageView(createInfo: ImageViewCreateInfo): VkImageView = stak { s ->
        VkImageView(s.longAdr { nCreateImageView(createInfo.write(s), it).check() })
    }

    // JVM
    fun createImageViewArray(createInfo: ImageViewCreateInfo, images: VkImage_Array): VkImageView_Array = stak { s ->
        val pCreateInfo = createInfo.write(s)
        val pImageView = s.mLong()
        VkImageView_Array(images.size) { i ->
            VkImageViewCreateInfo.nimage(pCreateInfo, images[i].L)
            nCreateImageView(pCreateInfo, pImageView.adr)
            VkImageView(pImageView[0])
        }
    }

    // --- [ vkCreatePipelineLayout ] ---
    infix fun createPipelineLayout(createInfo: PipelineLayoutCreateInfo): VkPipelineLayout = stak { s ->
        VkPipelineLayout(s.longAdr { callPPPPI(adr, createInfo.write(s), NULL, it, capabilities.vkCreatePipelineLayout) })
    }

    // --- [ vkCreateRenderPass ] ---
    infix fun createRenderPass(createInfo: RenderPassCreateInfo): VkRenderPass = stak { s ->
        VkRenderPass(s.longAdr { callPPPPI(adr, createInfo.write(s), NULL, it, capabilities.vkCreateRenderPass) })
    }

    // --- [ vkCreateSemaphore ] ---
    fun createSemaphore(createInfo: SemaphoreCreateInfo = SemaphoreCreateInfo()): VkSemaphore = stak { s ->
        VkSemaphore(s.longAdr { callPPPPI(adr, createInfo.write(s), NULL, it, capabilities.vkCreateSemaphore) })
    }

    // --- [ vkCreateShaderModule ] ---

    infix fun createShaderModule(createInfo: ShaderModuleCreateInfo): VkShaderModule = stak { s ->
        VkShaderModule(s.longAdr { callPPPPI(adr, createInfo.write(s), NULL, it, capabilities.vkCreateShaderModule) })
    }

    // --- [ vkCreateSwapchainKHR ] ---
    infix fun createSwapchainKHR(createInfo: SwapchainCreateInfoKHR): VkSwapchainKHR = stak { s ->
        VkSwapchainKHR(s.longAdr {
            VK_CHECK_RESULT(callPPPPI(adr, createInfo.write(s), NULL, it, capabilities.vkCreateSwapchainKHR))
        })
    }

    // --- [ vkDestroyFramebuffer ] ---
    infix fun destroy(framebuffer: VkFramebuffer) =
            callPJPV(adr, framebuffer.L, NULL, capabilities.vkDestroyFramebuffer)

    // --- [ vkDestroySemaphore ] ---
    infix fun destroy(semaphore: VkSemaphore) =
            callPJPV(adr, semaphore.L, NULL, capabilities.vkDestroySemaphore)

    // --- [ vkDestroySwapchainKHR ] ---
    infix fun destroy(swapchain: VkSwapchainKHR) =
            callPJPV(adr, swapchain.L, NULL, capabilities.vkDestroySwapchainKHR)

    // --- [ vkGetBufferMemoryRequirements ] ---

    infix fun getBufferMemoryRequirements(buffer: VkBuffer): MemoryRequirements = stak { s ->
        MemoryRequirements.read(s) {
            callPJPV(adr, buffer.L, it, capabilities.vkGetBufferMemoryRequirements)
        }
    }

    // --- [ vkGetDeviceQueue ] ---
    fun getQueue(queueFamilyIndex: Int, queueIndex: Int = 0): Queue =
            Queue(stak.pointerAdr { callPPV(adr, queueFamilyIndex, queueIndex, it, capabilities.vkGetDeviceQueue) }, this)


    // --- [ vkGetSwapchainImagesKHR ] ---
    inline fun nGetSwapchainImagesKHR(swapchain: VkSwapchainKHR, pSwapchainImageCount: Ptr, pSwapchainImages: Ptr = NULL): VkResult =
            VkResult(callPJPPI(adr, swapchain.L, pSwapchainImageCount, pSwapchainImages, capabilities.vkGetSwapchainImagesKHR))

    infix fun getSwapchainImagesKHR(swapchain: VkSwapchainKHR): VkImage_Array = stak { s ->
        var pSwapchainImages = LongPtr.NULL
        val pSwapchainImageCount = s.mInt()
        var swapchainImageCount: Int
        var result: VkResult
        do {
            result = nGetSwapchainImagesKHR(swapchain, pSwapchainImageCount.adr)
            swapchainImageCount = pSwapchainImageCount[0]
            if (result == VkResult.SUCCESS && swapchainImageCount != 0) {
                pSwapchainImages = s.mLong(swapchainImageCount)
                result = nGetSwapchainImagesKHR(swapchain, pSwapchainImageCount.adr, pSwapchainImages.adr)
            }
        } while (result == VkResult.INCOMPLETE)
        VkImage_Array(swapchainImageCount) { VkImage(pSwapchainImages[it]) }
    }

    // --- [ vkMapMemory ] ---
    fun mapMemory(memory: VkDeviceMemory, offset: VkDeviceSize, size: VkDeviceSize, flags: VkMemoryMapFlags = 0): Ptr =
            stak.pointerAdr { callPJJJPI(adr, memory.L, offset.L, size.L, flags, it, capabilities.vkMapMemory) }

    // --- [ vkResetCommandPool ] ---
    fun resetCommandPool(commandPool: VkCommandPool, flags: VkCommandPoolResetFlags = 0): VkResult =
            VkResult(callPJI(adr, commandPool.L, flags, capabilities.vkResetCommandPool)).apply { check() }

    // --- [ vkUnmapMemory ] ---
    infix fun unmapMemory(memory: VkDeviceMemory) = callPJV(adr, memory.L, capabilities.vkUnmapMemory)

    // JVM custom
    inline fun <R> mappedMemory(
            memory: VkDeviceMemory, offset: VkDeviceSize, size: VkDeviceSize, flags: VkMemoryMapFlags = 0, block: (Ptr) -> R
    ): R =
            block(mapMemory(memory, offset, size, flags)).also {
                unmapMemory(memory)
            }
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

            val props = PhysicalDeviceProperties.calloc(s)
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