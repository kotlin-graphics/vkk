//package vkn
//
//import glfw_.GlfwWindow
//import glfw_.appBuffer
//import glfw_.glfw
//import glm_.i
//import glm_.set
//import glm_.vec2.Vec2
//import glm_.vec2.Vec2i
//import glm_.vec4.Vec4
//import imgui.Cond
//import imgui.Context
//import imgui.ImGui
//import org.lwjgl.system.MemoryUtil.NULL
//import org.lwjgl.vulkan.*
//import org.lwjgl.vulkan.VK10.*
//import vkk.*
//
//
//var VULKAN_DEBUG_REPORT = true
//var UNLIMITED_FRAME_RATE = false
//const val MAX_POSSIBLE_BACK_BUFFERS = 16
//
//
//fun main(args: Array<String>) {
//    Example().run()
//}
//
//class Example {
//
//    val window: GlfwWindow
//
//    ////#define IMGUI_UNLIMITED_FRAME_RATE
////#ifdef _DEBUG
////#define IMGUI_VULKAN_DEBUG_REPORT
////#endif
////
////static VkAllocationCallbacks*   g_Allocator = NULL;
//    lateinit var instance: VkInstance
//    var surface: VkSurfaceKHR = NULL
//    lateinit var gpu: VkPhysicalDevice
//    lateinit var device: VkDevice
//    var swapchain: VkSwapchainKHR = NULL
//    var renderPass: VkRenderPass = NULL
//    var queueFamily = 0
//    lateinit var queue: VkQueue
//    var debugReport: VkDebugReportCallback = NULL
//
//    val surfaceFormat: VkSurfaceFormatKHR = VkSurfaceFormatKHR.calloc()
//    val imageRange = cVkImageSubresourceRange(VkImageAspect.COLOR_BIT.i, 0, 1, 0, 1)
//    lateinit var presentMode: VkPresentMode
//
//    var pipelineCache: VkPipelineCache = NULL
//    var descriptorPool: VkDescriptorPool = NULL
//    //
//    val fbSize = Vec2i()
//    var resizeWanted = false
//    var resizeSize = Vec2i()
//    val backbufferIndices = IntArray(VK_QUEUED_FRAMES)    // keep track of recently rendered swapchain frame indices
//    //    var backBufferCount = 0
//    var backBuffer = VkImageArray(MAX_POSSIBLE_BACK_BUFFERS)
//    val backBufferView = VkImageViewArray(MAX_POSSIBLE_BACK_BUFFERS)
//    val framebuffer = VkFramebufferArray(MAX_POSSIBLE_BACK_BUFFERS)
//
//    var frameIndex = 0
//    val commandPool = VkCommandPoolArray(VK_QUEUED_FRAMES)
//    val commandBuffer: Array<VkCommandBuffer?> = Array(VK_QUEUED_FRAMES) { null }
//    val fence = VkFenceArray(VK_QUEUED_FRAMES)
//    val presentCompleteSemaphore = VkSemaphoreArray(VK_QUEUED_FRAMES)
//    val renderCompleteSemaphore = VkSemaphoreArray(VK_QUEUED_FRAMES)
//
//
//    var f = 0f
//    var showDemoWindow = true
//    var showAnotherWindow = false
//    val clearColor = Vec4(0.45f, 0.55f, 0.6f, 1f)
//
//    init {
//        // Setup window
////    glfwSetErrorCallback(glfw_error_callback);
//        glfw.init()
//        glfw.windowHint { api = "none" }
//
//        window = GlfwWindow(1280, 720, "ImGui GLFW+Vulkan example")
//
//        // Setup Vulkan
//        if (!glfw.vulkanSupported)
//            throw Error("GLFW: Vulkan Not Supported")
//        setupVulkan(window)
//        window.framebufferSizeCallback = { size ->
//            resizeWanted = true
//            resizeSize put size
//        }
//        window.show()
//    }
//
//    fun run() {
//
//        // Setup Dear ImGui binding
////        IMGUI_CHECKVERSION() TODO
//        val context = Context()
//        val initData = ImplGlfwVulkan_InitData(
//                gpu,
//                device,
//                renderPass,
//                pipelineCache,
//                descriptorPool)
//
//        //io.ConfigFlags |= ImGuiConfigFlags_NavEnableKeyboard;  // Enable Keyboard Controls
//        ImplGlfwVulkan.init(window, true, initData)
//
//        // Setup style
//        ImGui.styleColorsDark()
//        //ImGui::StyleColorsClassic();
//
//        // Load Fonts
//        // - If no fonts are loaded, dear imgui will use the default font. You can also load multiple fonts and use ImGui::PushFont()/PopFont() to select them.
//        // - AddFontFromFileTTF() will return the ImFont* so you can store it if you need to select the font among multiple.
//        // - If the file cannot be loaded, the function will return NULL. Please handle those errors in your application (e.g. use an assertion, or display an error and quit).
//        // - The fonts will be rasterized at a given size (w/ oversampling) and stored into a texture when calling ImFontAtlas::Build()/GetTexDataAsXXXX(), which ImGui_ImplXXXX_NewFrame below will call.
//        // - Read 'misc/fonts/README.txt' for more instructions and details.
//        // - Remember that in C/C++ if you want to include a backslash \ in a string literal you need to write a double backslash \\ !
//        //io.Fonts->AddFontDefault();
//        //io.Fonts->AddFontFromFileTTF("../../misc/fonts/Roboto-Medium.ttf", 16.0f);
//        //io.Fonts->AddFontFromFileTTF("../../misc/fonts/Cousine-Regular.ttf", 15.0f);
//        //io.Fonts->AddFontFromFileTTF("../../misc/fonts/DroidSans.ttf", 16.0f);
//        //io.Fonts->AddFontFromFileTTF("../../misc/fonts/ProggyTiny.ttf", 10.0f);
//        //ImFont* font = io.Fonts->AddFontFromFileTTF("c:\\Windows\\Fonts\\ArialUni.ttf", 18.0f, NULL, io.Fonts->GetGlyphRangesJapanese());
//        //IM_ASSERT(font != NULL);
//
//        // Upload Fonts
//        run {
//            device resetCommandPool commandPool[frameIndex]
//            val beginInfo = vk.CommandBufferBeginInfo { flags = flags or VkCommandBufferUsage.ONE_TIME_SUBMIT_BIT }
//            commandBuffer[frameIndex]!! begin beginInfo
//
//            ImplGlfwVulkan.createFontsTexture(commandBuffer[frameIndex]!!)
//
//            val endInfo = vk.SubmitInfo { commandBuffer = this@Example.commandBuffer[frameIndex]!! }
//            commandBuffer[frameIndex]!!.end()
//            queue submit endInfo
//
//            device.waitIdle()
//            ImplGlfwVulkan.invalidateFontUploadObjects()
//        }
//
//        var counter = 0
//
//
//        // Main loop
//        while (!window.shouldClose) {
//            // You can read the io.WantCaptureMouse, io.WantCaptureKeyboard flags to tell if dear imgui wants to use your inputs.
//            // - When io.WantCaptureMouse is true, do not dispatch mouse input data to your main application.
//            // - When io.WantCaptureKeyboard is true, do not dispatch keyboard input data to your main application.
//            // Generally you may always pass all inputs to dear imgui, and hide them from your application based on those two flags.
//            glfw.pollEvents()
//
//            if (resizeWanted)
//                resizeVulkan(resizeSize)
//            resizeWanted = false
//
//            ImplGlfwVulkan.newFrame()
//
//            // 1. Show a simple window.
//            // Tip: if we don't call ImGui::Begin()/ImGui::End() the widgets automatically appears in a window called "Debug".
//            run {
//                ImGui.text("Hello, world!")                           // Display some text (you can use a format string too)
//                ImGui.sliderFloat("float", ::f, 0f, 1f)            // Edit 1 float using a slider from 0.0f to 1.0f
//                ImGui.colorEdit3("clear color", clearColor) // Edit 3 floats representing a color
//
//                ImGui.checkbox("Demo Window", ::showDemoWindow)      // Edit bools storing our windows open/close state
//                ImGui.checkbox("Another Window", ::showAnotherWindow)
//
//                if (ImGui.button("Button"))                            // Buttons return true when clicked (NB: most widgets return true when edited/activated)
//                    counter++
//                ImGui.sameLine()
//                ImGui.text("counter = %d", counter)
//
//                ImGui.text("Application average %.3f ms/frame (%.1f FPS)", 1000f / io.framerate, io.framerate)
//            }
//
//            // 2. Show another simple window. In most cases you will use an explicit Begin/End pair to name your windows.
//            if (showAnotherWindow) {
//                ImGui._begin("Another Window", ::showAnotherWindow)
//                ImGui.text("Hello from another window!")
//                if (ImGui.button("Close Me"))
//                    showAnotherWindow = false
//                ImGui.end()
//            }
//
//            // 3. Show the ImGui demo window. Most of the sample code is in ImGui::ShowDemoWindow(). Read its code to learn more about Dear ImGui!
//            if (showDemoWindow) {
//                ImGui.setNextWindowPos(Vec2(650, 20), Cond.FirstUseEver) // Normally user code doesn't need/want to call this because positions are saved in .ini file anyway. Here we just want to make the demo initial state a bit more friendly!
//                ImGui.showDemoWindow(::showDemoWindow)
//            }
//
//            frameBegin()
//            ImplGlfwVulkan.render(commandBuffer[frameIndex]!!)
//            frameEnd()
//            framePresent()
//        }
//
//        // Cleanup
//        device.waitIdle()
//        ImplGlfwVulkan.shutdown()
//        cleanupVulkan()
//
//        window.destroy()
//        glfw.terminate()
//    }
//
//
//    fun setupVulkan(window: GlfwWindow) {
//
//        // Create Vulkan Instance
//        run {
//            val extensions = glfw.requiredInstanceExtensions
//
//            val createInfo = vk.InstanceCreateInfo()
//
//            if (VULKAN_DEBUG_REPORT) {
//                // enabling multiple validation layers grouped as lunarg standard validation
//                val layers = listOf("VK_LAYER_LUNARG_standard_validation")
//                createInfo.enabledLayerNames = layers
//
//                // need additional storage for char pointer to debug report extension
//                extensions += "VK_EXT_debug_report"
//                createInfo.enabledExtensionNames = extensions
//            }
//
//            instance = vk.createInstance(createInfo)
//
//            if (VULKAN_DEBUG_REPORT) {
//                // create the debug report callback
//                val debugReportCi = vk.DebugReportCallbackCreateInfoEXT {
//                    flags = VkDebugReport.ERROR_BIT_EXT or VkDebugReport.WARNING_BIT_EXT or VkDebugReport.PERFORMANCE_WARNING_BIT_EXT
//                    callback = { _, objType, _, _, _, _, msg, _ ->
//                        println("[vulkan] ObjectType: $objType\nMessage: $msg\n")
//                        false
//                    }
//                }
//                // get the proc address of the function pointer, required for used extensions
//                debugReport = instance createDebugReportCallbackEXT debugReportCi
//            }
//        }
//
//        // Create Window Surface
//        surface = window createSurface instance
//
//        // Get GPU
//        gpu = instance.enumeratePhysicalDevices()[0]
//
//        // Get queue
//        run {
//            val queues = gpu.queueFamilyProperties
//            for (i in queues.indices)
//                if (queues[i].queueFlags has VkQueueFlag.GRAPHICS_BIT) {
//                    queueFamily = i
//                    break
//                }
//        }
//
//        // Check for WSI support
//        if (!gpu.getSurfaceSupportKHR(queueFamily, surface))
//            throw Error("Error no WSI support on physical device 0")
//
//        // Get Surface Format
//        run {
//            /*  Per Spec Format and View Format are expected to be the same unless VK_IMAGE_CREATE_MUTABLE_BIT was set
//                at image creation
//                Assuming that the default behavior is without setting this bit, there is no need for separate Spawchain
//                image and image view format
//                additionally several new color spaces were introduced with Vulkan Spec v1.0.40
//                hence we must make sure that a format with the mostly available color space,
//                VK_COLOR_SPACE_SRGB_NONLINEAR_KHR, is found and used */
//            val formats = gpu getSurfaceFormatsKHR surface
//
//            // first check if only one format, VK_FORMAT_UNDEFINED, is available, which would imply that any format is available
//            if (formats.size == 1) {
//                if (formats[0].format == VkFormat.UNDEFINED) {
//                    surfaceFormat.format = VkFormat.B8G8R8A8_UNORM
//                    surfaceFormat.colorSpace = VkColorSpace.SRGB_NONLINEAR_KHR
//                } else    // no point in searching another format
//                    surfaceFormat(formats[0])
//            } else {
//                // request several formats, the first found will be used
//                val requestSurfaceImageFormat = arrayOf(VkFormat.B8G8R8A8_UNORM, VkFormat.R8G8B8A8_UNORM, VkFormat.B8G8R8_UNORM, VkFormat.R8G8B8_UNORM)
//                val requestSurfaceColorSpace = VkColorSpace.SRGB_NONLINEAR_KHR
//                var requestedFound = false
//                for (i in requestSurfaceImageFormat.indices) {
//                    if (requestedFound)
//                        break
//                    for (j in formats.indices)
//                        if (formats[j].format == requestSurfaceImageFormat[i] && formats[j].colorSpace == requestSurfaceColorSpace) {
//                            surfaceFormat(formats[j])
//                            requestedFound = true
//                        }
//                }
//
//                // if none of the requested image formats could be found, use the first available
//                if (!requestedFound)
//                    surfaceFormat(formats[0])
//            }
//        }
//
//
//        // Get Present Mode
//        run {
//            // Request a certain mode and confirm that it is available. If not use VK_PRESENT_MODE_FIFO_KHR which is mandatory
//            presentMode = when {
//                UNLIMITED_FRAME_RATE -> VkPresentMode.MAILBOX_KHR //VK_PRESENT_MODE_IMMEDIATE_KHR;
//                else -> VkPresentMode.FIFO_KHR
//            }
//            val presentModes = gpu getSurfaceFormatsKHR surface
//            val presentModeAvailable = presentModes.any { it == presentMode }
//            if (!presentModeAvailable)
//                presentMode = VkPresentMode.FIFO_KHR   // always available
//        }
//
//
//        // Create Logical Device
//        run {
//            val deviceExtensions = listOf("VK_KHR_swapchain")
//            val queueIndex = 0
//            val queueCount = 1
//            val queuePriority = 1f
//            val queueInfo = vk.DeviceQueueCreateInfo {
//                queueFamilyIndex = queueFamily
//                this.queuePriority = queuePriority
//            }
//            val createInfo = vk.DeviceCreateInfo {
//                queueCreateInfo = queueInfo
//                enabledExtensionNames = deviceExtensions
//            }
//            device = gpu createDevice createInfo
//            queue = device.getQueue(queueFamily, queueIndex)
//        }
//
//        // Create Framebuffers
//        resizeVulkan(window.framebufferSize)
//
//        // Create Command Buffers
//        for (i in 0 until VK_QUEUED_FRAMES) {
//
//            commandPool[i] = device createCommandPool vk.CommandPoolCreateInfo {
//                flags = VkCommandPoolCreate.RESET_COMMAND_BUFFER_BIT.i
//                queueFamilyIndex = queueFamily
//            }
//
//            commandBuffer[i] = device allocateCommandBuffer vk.CommandBufferAllocateInfo {
//                commandPool = this@Example.commandPool[i]
//                level = VkCommandBufferLevel.PRIMARY
//                commandBufferCount = 1
//            }
//
//            fence[i] = device createFence vk.FenceCreateInfo { flags = VkFenceCreate.SIGNALED_BIT.i }
//
//            val info = vk.SemaphoreCreateInfo()
//            presentCompleteSemaphore[i] = device createSemaphore info
//            renderCompleteSemaphore[i] = device createSemaphore info
//        }
//
//        // Create Descriptor Pool
//        run {
//            val poolSize = vk.DescriptorPoolSize(
//                    VkDescriptorType.SAMPLER, 1000,
//                    VkDescriptorType.COMBINED_IMAGE_SAMPLER, 1000,
//                    VkDescriptorType.SAMPLED_IMAGE, 1000,
//                    VkDescriptorType.STORAGE_IMAGE, 1000,
//                    VkDescriptorType.UNIFORM_TEXEL_BUFFER, 1000,
//                    VkDescriptorType.STORAGE_TEXEL_BUFFER, 1000,
//                    VkDescriptorType.UNIFORM_BUFFER, 1000,
//                    VkDescriptorType.STORAGE_BUFFER, 1000,
//                    VkDescriptorType.UNIFORM_BUFFER_DYNAMIC, 1000,
//                    VkDescriptorType.STORAGE_BUFFER_DYNAMIC, 1000,
//                    VkDescriptorType.INPUT_ATTACHMENT, 1000)
//            val poolInfo = vk.DescriptorPoolCreateInfo {
//                flags = VkDescriptorPoolCreate.FREE_DESCRIPTOR_SET_BIT.i
//                maxSets = 1000 * 11
//                poolSizes = poolSize
//            }
//            descriptorPool = device createDescriptorPool poolInfo
//        }
//    }
//
//    fun resizeVulkan(size: Vec2i) {
//
//        val oldSwapchain: VkSwapchainKHR = swapchain
//        device.waitIdle()
//
//        // Destroy old Framebuffer:
//        backBuffer.filter { it != NULL }.forEach { device destroyImageView it }
//        framebuffer.filter { it != NULL }.forEach { device destroyFramebuffer it }
//        if (renderPass != NULL)
//            device destroyRenderPass renderPass
//
//        // Create Swapchain:
//        run {
//            val info = vk.SwapchainCreateInfoKHR {
//                surface = this@Example.surface
//                imageFormat = surfaceFormat.format
//                imageColorSpace = surfaceFormat.colorSpace
//                imageArrayLayers = 1
//                imageUsage = imageUsage or VkImageUsage.COLOR_ATTACHMENT_BIT
//                imageSharingMode = VkSharingMode.EXCLUSIVE
//                preTransform = VkSurfaceTransform.IDENTITY_BIT_KHR
//                compositeAlpha = VkCompositeAlpha.OPAQUE_BIT_KHR
//                presentMode = this@Example.presentMode
//                clipped = true
//                this.oldSwapchain = oldSwapchain
//            }
//            val cap = gpu getSurfaceCapabilitiesKHR surface
//            info.minImageCount = when {
//                cap.maxImageCount > 0 -> when {
//                    cap.minImageCount + 2 < cap.maxImageCount -> cap.minImageCount + 2
//                    else -> cap.maxImageCount
//                }
//                else -> cap.minImageCount + 2
//            }
//
//            if (cap.currentExtent.width == 0xffffffff.i) {
//                fbSize put size
//                info.imageExtent(fbSize)
//            } else {
//                fbSize put cap.currentExtent
//                info.imageExtent(fbSize)
//            }
//            swapchain = device createSwapchainKHR info
//            backBuffer = device getSwapchainImagesKHR swapchain
//        }
//        if (oldSwapchain != NULL)
//            device destroySwapchainKHR oldSwapchain
//
//        // Create the Render Pass:
//        run {
//            val attachment = vk.AttachmentDescription {
//                format = surfaceFormat.format
//                samples = VkSampleCount.`1_BIT`
//                loadOp = VkAttachmentLoadOp.CLEAR
//                storeOp = VkAttachmentStoreOp.STORE
//                stencilLoadOp = VkAttachmentLoadOp.DONT_CARE
//                stencilStoreOp = VkAttachmentStoreOp.DONT_CARE
//                initialLayout = VkImageLayout.UNDEFINED
//                finalLayout = VkImageLayout.PRESENT_SRC_KHR
//            }
//            val colorAttachment = vk.AttachmentReference {
//                this.attachment = 0
//                layout = VkImageLayout.COLOR_ATTACHMENT_OPTIMAL
//            }
//            val subpass = vk.SubpassDescription {
//                pipelineBindPoint = VkPipelineBindPoint.GRAPHICS
//                colorAttachmentCount = 1
//                this.colorAttachment = colorAttachment
//            }
//            val dependency = vk.SubpassDependency {
//                srcSubpass = VK_SUBPASS_EXTERNAL
//                dstSubpass = 0
//                srcStageMask = VkPipelineStage.COLOR_ATTACHMENT_OUTPUT_BIT.i
//                dstStageMask = VkPipelineStage.COLOR_ATTACHMENT_OUTPUT_BIT.i
//                srcAccessMask = 0
//                dstAccessMask = VkAccess.COLOR_ATTACHMENT_WRITE_BIT.i
//            }
//            val info = vk.RenderPassCreateInfo().also {
//                it.attachment = attachment
//                it.subpass = subpass
//                it.dependency = dependency
//            }
//            renderPass = device createRenderPass info
//        }
//
//        // Create The Image Views
//        run {
//            val info = vk.ImageViewCreateInfo {
//                viewType = VkImageViewType.`2D`
//                format = surfaceFormat.format
//                components(VkComponentSwizzle.R, VkComponentSwizzle.G, VkComponentSwizzle.B, VkComponentSwizzle.A)
//                subresourceRange = imageRange
//            }
//            for (i in backBuffer.indices) {
//                info.image = backBuffer[i]
//                backBufferView[i] = device createImageView info
//            }
//        }
//
//        // Create Framebuffer:
//        run {
//            val attachment: VkImageViewBuffer = appBuffer.longBuffer(1)
//            val info = vk.FramebufferCreateInfo {
//                renderPass = this@Example.renderPass
//                attachments = attachment
//                width = fbSize.x
//                height = fbSize.y // TODO
//                layers = 1
//            }
//            for (i in backBuffer.indices) {
//                attachment[0] = backBufferView[i]
//                framebuffer[i] = device createFramebuffer info
//            }
//        }
//    }
//
//    fun frameBegin() {
//
//        while (true) {
//            val err = vkWaitForFences(device, fence[frameIndex], true, 100)
//            if (err == VK_SUCCESS) break
//            if (err == VK_TIMEOUT) continue
//            VK_CHECK_RESULT(err)
//        }
//
//        backbufferIndices[frameIndex] = device.acquireNextImageKHR(swapchain, UINT64_MAX, presentCompleteSemaphore[frameIndex], NULL)
//
//        run {
//            device resetCommandPool commandPool[frameIndex]
//            val info = vk.CommandBufferBeginInfo { flags = flags or VkCommandBufferUsage.ONE_TIME_SUBMIT_BIT }
//            commandBuffer[frameIndex]!! begin info
//        }
//
//        val info = vk.RenderPassBeginInfo {
//            renderPass = this@Example.renderPass
//            framebuffer = this@Example.framebuffer[backbufferIndices[frameIndex]]
//            renderArea.apply { extent(fbSize) }
//            clearValue(clearColor)
//        }
//        commandBuffer[frameIndex]!!.beginRenderPass(info, VkSubpassContents.INLINE)
//    }
//
//    fun frameEnd() {
//
//        commandBuffer[frameIndex]!!.endRenderPass()
//
//        val waitStage: VkPipelineStageFlags = VkPipelineStage.COLOR_ATTACHMENT_OUTPUT_BIT.i
//        val info = vk.SubmitInfo {
//            waitSemaphoreCount = 1
//            waitSemaphore = presentCompleteSemaphore[frameIndex]
//            waitDstStageMask = appBuffer intBufferOf waitStage
//            commandBuffer = this@Example.commandBuffer[frameIndex]
//            signalSemaphore = renderCompleteSemaphore[frameIndex]
//        }
//        commandBuffer[frameIndex]!!.end()
//        device resetFence fence[frameIndex]
//        queue.submit(info, fence[frameIndex])
//    }
//
//    fun framePresent() {
//
//        val info = vk.PresentInfoKHR {
//            waitSemaphores = appBuffer longBufferOf renderCompleteSemaphore[frameIndex] // TODO bug
//            swapchainCount = 1
//            swapchain = this@Example.swapchain
//            imageIndex = backbufferIndices[frameIndex]
//        }
//        queue presentKHR info
//
//        frameIndex = (frameIndex + 1) % VK_QUEUED_FRAMES
//    }
//
//    fun cleanupVulkan() {
//
//        device.apply {
//
//            destroyDescriptorPool(descriptorPool)
//            for (i in 0 until VK_QUEUED_FRAMES) {
//                destroyFence(fence[i])
//                freeCommandBuffer(commandPool[i], commandBuffer[i]!!)
//                destroyCommandPool(commandPool[i])
//                destroySemaphore(presentCompleteSemaphore[i])
//                destroySemaphore(renderCompleteSemaphore[i])
//            }
//            for (i in backBuffer.indices) {
//                destroyImageView(backBufferView[i])
//                destroyFramebuffer(framebuffer[i])
//            }
//            destroyRenderPass(renderPass)
//            destroySwapchainKHR(swapchain)
////            destroySurfaceKHR(g_Instance, g_Surface, g_Allocator) TODO
//
//            if (VULKAN_DEBUG_REPORT) TODO()
//            // get the proc address of the function pointer, required for used extensions
////                auto vkDestroyDebugReportCallbackEXT =(PFN_vkDestroyDebugReportCallbackEXT) vkGetInstanceProcAddr (g_Instance, "vkDestroyDebugReportCallbackEXT")
////            vkDestroyDebugReportCallbackEXT(g_Instance, g_Debug_Report, g_Allocator)
//
//            device.destroy()
//            instance.destroy()
//        }
//    }
//}