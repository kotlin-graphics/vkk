///**
// *  ImGui GLFW binding with Vulkan + shaders
// *
// *  Missing features:
// *  [ ] User texture binding. Changes of ImTextureID aren't supported by this binding! See https://github.com/ocornut/imgui/pull/914
// *
// *  You can copy and use unmodified imgui_impl_* files in your project. See main.cpp for an example of using this.
// *  If you use this binding you'll need to call 5 functions: ImplXXXX_Init(), ImplXXX_CreateFontsTexture(), ImplXXXX_NewFrame(),
// *  ImplXXXX_Render() and ImplXXXX_Shutdown().
// *  If you are new to ImGui, see examples/README.txt and documentation at the top of imgui.cpp.
// *  https://github.com/ocornut/imgui
// */
//
//package vkn
//
//import glfw_.GlfwWindow
//import glfw_.appBuffer
//import glfw_.glfw
//import gli_.has
//import glm_.*
//import glm_.buffer.longBufferBig
//import glm_.vec2.Vec2
//import glm_.vec4.Vec4
//import imgui.*
//import org.lwjgl.glfw.GLFW.*
//import org.lwjgl.system.MemoryUtil.*
//import org.lwjgl.vulkan.VK10.VK_QUEUE_FAMILY_IGNORED
//import org.lwjgl.vulkan.VK10.VK_WHOLE_SIZE
//import org.lwjgl.vulkan.VkCommandBuffer
//import org.lwjgl.vulkan.VkDevice
//import org.lwjgl.vulkan.VkPhysicalDevice
//import uno.buffer.toBuffer
//import vkk.*
//
//const val VK_QUEUED_FRAMES = 2
//
//val io = imgui.g.io
//
//class ImplGlfwVulkan_InitData(
////    VkAllocationCallbacks* allocator;
//        val gpu: VkPhysicalDevice,
//        val device: VkDevice,
//        val renderPass: VkRenderPass,
//        val pipelineCache: VkPipelineCache,
//        val descriptorPool: VkDescriptorPool
////    void (*check_vk_result)(VkResult err);
//)
//
//object ImplGlfwVulkan {
//    // GLFW data
//    var window: GlfwWindow? = null
//    var time = 0.0
//    var mouseJustPressed = BooleanArray(3)
//    val mouseCursors = LongArray(MouseCursor.COUNT)
//
//    // Vulkan data
////static VkAllocationCallbacks* g_Allocator = NULL;
//    lateinit var gpu: VkPhysicalDevice
//    lateinit var device: VkDevice
//    var renderPass: VkRenderPass = NULL
//    var pipelineCache: VkPipelineCache = NULL
//    var descriptorPool: VkDescriptorPool = NULL
////static void (*g_CheckVkResult)(VkResult err) = NULL;
//
//    var commandBuffer: VkCommandBuffer? = null
//    var bufferMemoryAlignment: VkDeviceSize = 256
//    var pipelineCreateFlags: VkPipelineCreateFlags = 0
//    var frameIndex = 0
//
//    var descriptorSetLayout: VkDescriptorSetLayout = NULL
//    var pipelineLayout: VkPipelineLayout = NULL
//    var descriptorSet: VkDescriptorSet = NULL
//    var pipeline: VkPipeline = NULL
//
//    var fontSampler: VkSampler = NULL
//    var fontMemory: VkDeviceMemory = NULL
//    var fontImage: VkImage = NULL
//    var fontView: VkImageView = NULL
//
//    var vertexBufferMemory: VkDeviceMemoryBuffer = longBufferBig(VK_QUEUED_FRAMES)
//    var indexBufferMemory: VkDeviceMemoryBuffer = longBufferBig(VK_QUEUED_FRAMES)
//    var vertexBufferSize: VkDeviceSizeBuffer = longBufferBig(VK_QUEUED_FRAMES)
//    var indexBufferSize: VkDeviceSizeBuffer = longBufferBig(VK_QUEUED_FRAMES)
//    var vertexBuffer: VkBufferBuffer = longBufferBig(VK_QUEUED_FRAMES)
//    var indexBuffer: VkBufferBuffer = longBufferBig(VK_QUEUED_FRAMES)
//
//    var uploadBufferMemory: VkDeviceMemory = NULL
//    var uploadBuffer: VkBuffer = NULL
//
//    val glslShaderVertSpv = intArrayOf(
//            0x07230203, 0x00010000, 0x00080001, 0x0000002e, 0x00000000, 0x00020011, 0x00000001, 0x0006000b,
//            0x00000001, 0x4c534c47, 0x6474732e, 0x3035342e, 0x00000000, 0x0003000e, 0x00000000, 0x00000001,
//            0x000a000f, 0x00000000, 0x00000004, 0x6e69616d, 0x00000000, 0x0000000b, 0x0000000f, 0x00000015,
//            0x0000001b, 0x0000001c, 0x00030003, 0x00000002, 0x000001c2, 0x00040005, 0x00000004, 0x6e69616d,
//            0x00000000, 0x00030005, 0x00000009, 0x00000000, 0x00050006, 0x00000009, 0x00000000, 0x6f6c6f43,
//            0x00000072, 0x00040006, 0x00000009, 0x00000001, 0x00005655, 0x00030005, 0x0000000b, 0x0074754f,
//            0x00040005, 0x0000000f, 0x6c6f4361, 0x0000726f, 0x00030005, 0x00000015, 0x00565561, 0x00060005,
//            0x00000019, 0x505f6c67, 0x65567265, 0x78657472, 0x00000000, 0x00060006, 0x00000019, 0x00000000,
//            0x505f6c67, 0x7469736f, 0x006e6f69, 0x00030005, 0x0000001b, 0x00000000, 0x00040005, 0x0000001c,
//            0x736f5061, 0x00000000, 0x00060005, 0x0000001e, 0x73755075, 0x6e6f4368, 0x6e617473, 0x00000074,
//            0x00050006, 0x0000001e, 0x00000000, 0x61635375, 0x0000656c, 0x00060006, 0x0000001e, 0x00000001,
//            0x61725475, 0x616c736e, 0x00006574, 0x00030005, 0x00000020, 0x00006370, 0x00040047, 0x0000000b,
//            0x0000001e, 0x00000000, 0x00040047, 0x0000000f, 0x0000001e, 0x00000002, 0x00040047, 0x00000015,
//            0x0000001e, 0x00000001, 0x00050048, 0x00000019, 0x00000000, 0x0000000b, 0x00000000, 0x00030047,
//            0x00000019, 0x00000002, 0x00040047, 0x0000001c, 0x0000001e, 0x00000000, 0x00050048, 0x0000001e,
//            0x00000000, 0x00000023, 0x00000000, 0x00050048, 0x0000001e, 0x00000001, 0x00000023, 0x00000008,
//            0x00030047, 0x0000001e, 0x00000002, 0x00020013, 0x00000002, 0x00030021, 0x00000003, 0x00000002,
//            0x00030016, 0x00000006, 0x00000020, 0x00040017, 0x00000007, 0x00000006, 0x00000004, 0x00040017,
//            0x00000008, 0x00000006, 0x00000002, 0x0004001e, 0x00000009, 0x00000007, 0x00000008, 0x00040020,
//            0x0000000a, 0x00000003, 0x00000009, 0x0004003b, 0x0000000a, 0x0000000b, 0x00000003, 0x00040015,
//            0x0000000c, 0x00000020, 0x00000001, 0x0004002b, 0x0000000c, 0x0000000d, 0x00000000, 0x00040020,
//            0x0000000e, 0x00000001, 0x00000007, 0x0004003b, 0x0000000e, 0x0000000f, 0x00000001, 0x00040020,
//            0x00000011, 0x00000003, 0x00000007, 0x0004002b, 0x0000000c, 0x00000013, 0x00000001, 0x00040020,
//            0x00000014, 0x00000001, 0x00000008, 0x0004003b, 0x00000014, 0x00000015, 0x00000001, 0x00040020,
//            0x00000017, 0x00000003, 0x00000008, 0x0003001e, 0x00000019, 0x00000007, 0x00040020, 0x0000001a,
//            0x00000003, 0x00000019, 0x0004003b, 0x0000001a, 0x0000001b, 0x00000003, 0x0004003b, 0x00000014,
//            0x0000001c, 0x00000001, 0x0004001e, 0x0000001e, 0x00000008, 0x00000008, 0x00040020, 0x0000001f,
//            0x00000009, 0x0000001e, 0x0004003b, 0x0000001f, 0x00000020, 0x00000009, 0x00040020, 0x00000021,
//            0x00000009, 0x00000008, 0x0004002b, 0x00000006, 0x00000028, 0x00000000, 0x0004002b, 0x00000006,
//            0x00000029, 0x3f800000, 0x00050036, 0x00000002, 0x00000004, 0x00000000, 0x00000003, 0x000200f8,
//            0x00000005, 0x0004003d, 0x00000007, 0x00000010, 0x0000000f, 0x00050041, 0x00000011, 0x00000012,
//            0x0000000b, 0x0000000d, 0x0003003e, 0x00000012, 0x00000010, 0x0004003d, 0x00000008, 0x00000016,
//            0x00000015, 0x00050041, 0x00000017, 0x00000018, 0x0000000b, 0x00000013, 0x0003003e, 0x00000018,
//            0x00000016, 0x0004003d, 0x00000008, 0x0000001d, 0x0000001c, 0x00050041, 0x00000021, 0x00000022,
//            0x00000020, 0x0000000d, 0x0004003d, 0x00000008, 0x00000023, 0x00000022, 0x00050085, 0x00000008,
//            0x00000024, 0x0000001d, 0x00000023, 0x00050041, 0x00000021, 0x00000025, 0x00000020, 0x00000013,
//            0x0004003d, 0x00000008, 0x00000026, 0x00000025, 0x00050081, 0x00000008, 0x00000027, 0x00000024,
//            0x00000026, 0x00050051, 0x00000006, 0x0000002a, 0x00000027, 0x00000000, 0x00050051, 0x00000006,
//            0x0000002b, 0x00000027, 0x00000001, 0x00070050, 0x00000007, 0x0000002c, 0x0000002a, 0x0000002b,
//            0x00000028, 0x00000029, 0x00050041, 0x00000011, 0x0000002d, 0x0000001b, 0x0000000d, 0x0003003e,
//            0x0000002d, 0x0000002c, 0x000100fd, 0x00010038).toBuffer()
//
//    val glslShaderFragSpv = intArrayOf(
//            0x07230203, 0x00010000, 0x00080001, 0x0000001e, 0x00000000, 0x00020011, 0x00000001, 0x0006000b,
//            0x00000001, 0x4c534c47, 0x6474732e, 0x3035342e, 0x00000000, 0x0003000e, 0x00000000, 0x00000001,
//            0x0007000f, 0x00000004, 0x00000004, 0x6e69616d, 0x00000000, 0x00000009, 0x0000000d, 0x00030010,
//            0x00000004, 0x00000007, 0x00030003, 0x00000002, 0x000001c2, 0x00040005, 0x00000004, 0x6e69616d,
//            0x00000000, 0x00040005, 0x00000009, 0x6c6f4366, 0x0000726f, 0x00030005, 0x0000000b, 0x00000000,
//            0x00050006, 0x0000000b, 0x00000000, 0x6f6c6f43, 0x00000072, 0x00040006, 0x0000000b, 0x00000001,
//            0x00005655, 0x00030005, 0x0000000d, 0x00006e49, 0x00050005, 0x00000016, 0x78655473, 0x65727574,
//            0x00000000, 0x00040047, 0x00000009, 0x0000001e, 0x00000000, 0x00040047, 0x0000000d, 0x0000001e,
//            0x00000000, 0x00040047, 0x00000016, 0x00000022, 0x00000000, 0x00040047, 0x00000016, 0x00000021,
//            0x00000000, 0x00020013, 0x00000002, 0x00030021, 0x00000003, 0x00000002, 0x00030016, 0x00000006,
//            0x00000020, 0x00040017, 0x00000007, 0x00000006, 0x00000004, 0x00040020, 0x00000008, 0x00000003,
//            0x00000007, 0x0004003b, 0x00000008, 0x00000009, 0x00000003, 0x00040017, 0x0000000a, 0x00000006,
//            0x00000002, 0x0004001e, 0x0000000b, 0x00000007, 0x0000000a, 0x00040020, 0x0000000c, 0x00000001,
//            0x0000000b, 0x0004003b, 0x0000000c, 0x0000000d, 0x00000001, 0x00040015, 0x0000000e, 0x00000020,
//            0x00000001, 0x0004002b, 0x0000000e, 0x0000000f, 0x00000000, 0x00040020, 0x00000010, 0x00000001,
//            0x00000007, 0x00090019, 0x00000013, 0x00000006, 0x00000001, 0x00000000, 0x00000000, 0x00000000,
//            0x00000001, 0x00000000, 0x0003001b, 0x00000014, 0x00000013, 0x00040020, 0x00000015, 0x00000000,
//            0x00000014, 0x0004003b, 0x00000015, 0x00000016, 0x00000000, 0x0004002b, 0x0000000e, 0x00000018,
//            0x00000001, 0x00040020, 0x00000019, 0x00000001, 0x0000000a, 0x00050036, 0x00000002, 0x00000004,
//            0x00000000, 0x00000003, 0x000200f8, 0x00000005, 0x00050041, 0x00000010, 0x00000011, 0x0000000d,
//            0x0000000f, 0x0004003d, 0x00000007, 0x00000012, 0x00000011, 0x0004003d, 0x00000014, 0x00000017,
//            0x00000016, 0x00050041, 0x00000019, 0x0000001a, 0x0000000d, 0x00000018, 0x0004003d, 0x0000000a,
//            0x0000001b, 0x0000001a, 0x00050057, 0x00000007, 0x0000001c, 0x00000017, 0x0000001b, 0x00050085,
//            0x00000007, 0x0000001d, 0x00000012, 0x0000001c, 0x0003003e, 0x00000009, 0x0000001d, 0x000100fd,
//            0x00010038).toBuffer()
//
//    fun init(window: GlfwWindow, installCallbacks: Boolean, initData: ImplGlfwVulkan_InitData): Boolean {
////    g_Allocator = init_data->allocator;
//        gpu = initData.gpu
//        device = initData.device
//        renderPass = initData.renderPass
//        pipelineCache = initData.pipelineCache
//        descriptorPool = initData.descriptorPool
////        CheckVkResult = init_data->check_vk_result
//
//        this.window = window
//
//        with(io) {
//            // TODO remove
//            // Setup back-end capabilities flags TODO or .i
//            backendFlags = backendFlags or BackendFlag.HasMouseCursors.i   // We can honor GetMouseCursor() values (optional)
//
//            // Keyboard mapping. ImGui will use those indices to peek into the io.KeysDown[] array.
//            keyMap[Key.Tab] = GLFW_KEY_TAB
//            keyMap[Key.LeftArrow] = GLFW_KEY_LEFT
//            keyMap[Key.RightArrow] = GLFW_KEY_RIGHT
//            keyMap[Key.UpArrow] = GLFW_KEY_UP
//            keyMap[Key.DownArrow] = GLFW_KEY_DOWN
//            keyMap[Key.PageUp] = GLFW_KEY_PAGE_UP
//            keyMap[Key.PageDown] = GLFW_KEY_PAGE_DOWN
//            keyMap[Key.Home] = GLFW_KEY_HOME
//            keyMap[Key.End] = GLFW_KEY_END
//            keyMap[Key.Insert] = GLFW_KEY_INSERT
//            keyMap[Key.Delete] = GLFW_KEY_DELETE
//            keyMap[Key.Backspace] = GLFW_KEY_BACKSPACE
//            keyMap[Key.Space] = GLFW_KEY_SPACE
//            keyMap[Key.Enter] = GLFW_KEY_ENTER
//            keyMap[Key.Escape] = GLFW_KEY_ESCAPE
//            keyMap[Key.A] = GLFW_KEY_A
//            keyMap[Key.C] = GLFW_KEY_C
//            keyMap[Key.V] = GLFW_KEY_V
//            keyMap[Key.X] = GLFW_KEY_X
//            keyMap[Key.Y] = GLFW_KEY_Y
//            keyMap[Key.Z] = GLFW_KEY_Z
//
////            io.SetClipboardTextFn = ImGui_ImplGlfwVulkan_SetClipboardText
////            io.GetClipboardTextFn = ImGui_ImplGlfwVulkan_GetClipboardText
////            io.ClipboardUserData = g_Window
////            #ifdef _WIN32
////                io.ImeWindowHandle = glfwGetWin32Window(g_Window)
////            #endif
//        }
//        // Load cursors
//        // FIXME: GLFW doesn't expose suitable cursors for ResizeAll, ResizeNESW, ResizeNWSE. We revert to arrow cursor for those.
//        mouseCursors[MouseCursor.Arrow.i] = glfwCreateStandardCursor(GLFW_ARROW_CURSOR)
//        mouseCursors[MouseCursor.TextInput.i] = glfwCreateStandardCursor(GLFW_IBEAM_CURSOR)
//        mouseCursors[MouseCursor.ResizeAll.i] = glfwCreateStandardCursor(GLFW_ARROW_CURSOR)
//        mouseCursors[MouseCursor.ResizeNS.i] = glfwCreateStandardCursor(GLFW_VRESIZE_CURSOR)
//        mouseCursors[MouseCursor.ResizeEW.i] = glfwCreateStandardCursor(GLFW_HRESIZE_CURSOR)
//        mouseCursors[MouseCursor.ResizeNESW.i] = glfwCreateStandardCursor(GLFW_ARROW_CURSOR)
//        mouseCursors[MouseCursor.ResizeNWSE.i] = glfwCreateStandardCursor(GLFW_ARROW_CURSOR)
//
//
//        if (installCallbacks)
//            installCallbacks()
//
//        createDeviceObjects()
//
//        return true
//    }
//
//    fun installCallbacks() {
//        window!!.apply {
//            mouseButtonCallback = { button, action, _ ->
//                if (action == GLFW_PRESS && button in 0..2)
//                    mouseJustPressed[button] = true
//            }
//            scrollCallback = { scroll ->
//                io.mouseWheelH += scroll.x
//                io.mouseWheel += scroll.y
//            }
//            keyCallback = { key, scanCode, action, mods ->
//                if (action == GLFW_PRESS)
//                    io.keysDown[key] = true
//                if (action == GLFW_RELEASE)
//                    io.keysDown[key] = false
//
//                io.keyCtrl = io.keysDown[GLFW_KEY_LEFT_CONTROL] || io.keysDown[GLFW_KEY_RIGHT_CONTROL]
//                io.keyShift = io.keysDown[GLFW_KEY_LEFT_SHIFT] || io.keysDown[GLFW_KEY_RIGHT_SHIFT]
//                io.keyAlt = io.keysDown[GLFW_KEY_LEFT_ALT] || io.keysDown[GLFW_KEY_RIGHT_ALT]
//                io.keySuper = io.keysDown[GLFW_KEY_LEFT_SUPER] || io.keysDown[GLFW_KEY_RIGHT_SUPER]
//            }
//            charCallback = { codePoint ->
//                if (codePoint in 1..65535)
//                    io.addInputCharacter(codePoint.c)
//            }
//        }
//    }
//
//    fun shutdown() {
//        // Destroy GLFW mouse cursors
//        for (cursorN in 0 until MouseCursor.COUNT)
//            glfwDestroyCursor(mouseCursors[cursorN])
//        mouseCursors.fill(NULL)
//
//        // Destroy Vulkan objects
//        invalidateDeviceObjects()
//    }
//
//    fun newFrame() {
//
//        // Setup display size (every frame to accommodate for window resizing)
//        val size = window!!.size
//        val displaySize = window!!.framebufferSize
//        io.displaySize put size
//        io.displayFramebufferScale.put(
//                if (size.x > 0) displaySize.x.f / size.x else 0f,
//                if (size.y > 0) displaySize.y.f / size.y else 0f)
//
//        // Setup time step
//        val currentTime = glfw.time
//        io.deltaTime = if (time > 0.0) (currentTime - time).f else 1f / 60f
//        time = currentTime.d
//
//        // Setup inputs
//        // (we already got mouse wheel, keyboard keys & characters from glfw callbacks polled in glfwPollEvents())
//        if (window!!.focused)
//            io.mousePos put window!!.cursorPos
//        else
//            io.mousePos put -Float.MAX_VALUE
//
//        for (i in 0..2) {
//            /*  If a mouse press event came, always pass it as "mouse held this frame", so we don't miss click-release events
//                that are shorter than 1 frame.             */
//            io.mouseDown[i] = mouseJustPressed[i] || window!!.mouseButton(i) != 0
//            mouseJustPressed[i] = false
//        }
//
//        // Update OS/hardware mouse cursor if imgui isn't drawing a software cursor
//        if (io.configFlags hasnt ConfigFlag.NoMouseCursorChange) {
//            val cursor = g.mouseCursor // TODO remove .g
//            if (io.mouseDrawCursor || cursor == MouseCursor.None)
//                window!!.cursor = GlfwWindow.Cursor.Hidden
//            else {
//                glfwSetCursor(window!!.handle, if (mouseCursors[cursor.i] != 0L) mouseCursors[cursor.i] else mouseCursors[MouseCursor.Arrow.i])
//                window!!.cursor = GlfwWindow.Cursor.Normal
//            }
//        }
//
//        // Start the frame. This call will update the io.WantCaptureMouse, io.WantCaptureKeyboard flag that you can use to dispatch inputs (or not) to your application.
//        ImGui.newFrame()
//    }
//
//    fun render(commandBuffer: VkCommandBuffer) {
//        this.commandBuffer = commandBuffer
//        ImGui.render()
//        renderDrawData(ImGui.drawData!!)
//        this.commandBuffer = null
//        frameIndex = (frameIndex + 1) % VK_QUEUED_FRAMES
//    }
//
//    /** This is the main rendering function that you have to implement and provide to ImGui
//     *  (via setting up 'RenderDrawListsFn' in the ImGuiIO structure) */
//    fun renderDrawData(drawData: DrawData) {
//
//        if (drawData.totalVtxCount == 0) return
//
//        // Create the Vertex Buffer:
//        val vertexSize = drawData.totalVtxCount * DrawVert.size
//        if (vertexBuffer[frameIndex] == NULL || vertexBufferSize[frameIndex] < vertexSize) {
//            if (vertexBuffer[frameIndex] != NULL)
//                device destroyBuffer vertexBuffer[frameIndex]
//            if (vertexBufferMemory[frameIndex] != NULL)
//                device freeMemory vertexBufferMemory[frameIndex]
//            val vertexBufferSize: VkDeviceSize = ((vertexSize - 1) / bufferMemoryAlignment + 1) * bufferMemoryAlignment
//            val bufferInfo = vk.BufferCreateInfo {
//                size = vertexBufferSize
//                usage = VkBufferUsage.VERTEX_BUFFER_BIT.i
//                sharingMode = VkSharingMode.EXCLUSIVE
//            }
//            vertexBuffer[frameIndex] = device createBuffer bufferInfo
//            val req = device getBufferMemoryRequirements vertexBuffer[frameIndex]
//            bufferMemoryAlignment = if (bufferMemoryAlignment > req.alignment) bufferMemoryAlignment else req.alignment
//            val allocInfo = vk.MemoryAllocateInfo {
//                allocationSize = req.size
//                memoryTypeIndex = memoryType(VkMemoryProperty.HOST_VISIBLE_BIT.i, req.memoryTypeBits)
//            }
//            vertexBufferMemory[frameIndex] = device allocateMemory allocInfo
//            device.bindBufferMemory(vertexBuffer[frameIndex], vertexBufferMemory[frameIndex])
//            this.vertexBufferSize[frameIndex] = vertexBufferSize
//        }
//
//        // Create the Index Buffer:
//        val indexSize = drawData.totalIdxCount * DrawIdx.BYTES
//        if (indexBuffer[frameIndex] == NULL || indexBufferSize[frameIndex] < indexSize) {
//            if (indexBuffer[frameIndex] != NULL)
//                device destroyBuffer indexBuffer[frameIndex]
//            if (indexBufferMemory[frameIndex] != NULL)
//                device freeMemory indexBufferMemory[frameIndex]
//            val indexBufferSize: VkDeviceSize = ((indexSize - 1) / bufferMemoryAlignment + 1) * bufferMemoryAlignment
//            val bufferInfo = vk.BufferCreateInfo {
//                size = indexBufferSize
//                usage = VkBufferUsage.INDEX_BUFFER_BIT.i
//                sharingMode = VkSharingMode.EXCLUSIVE
//            }
//            indexBuffer[frameIndex] = device createBuffer bufferInfo
//            val req = device getBufferMemoryRequirements indexBuffer[frameIndex]
//            bufferMemoryAlignment = if (bufferMemoryAlignment > req.alignment) bufferMemoryAlignment else req.alignment
//            val allocInfo = vk.MemoryAllocateInfo {
//                allocationSize = req.size
//                memoryTypeIndex = memoryType(VkMemoryProperty.HOST_VISIBLE_BIT.i, req.memoryTypeBits)
//            }
//            indexBufferMemory[frameIndex] = device allocateMemory allocInfo
//            device.bindBufferMemory(indexBuffer[frameIndex], indexBufferMemory[frameIndex])
//            this.indexBufferSize[frameIndex] = indexBufferSize
//        }
//
//        // Upload Vertex and index Data:
//        run {
//            val pVtxDst = appBuffer.pointer
//            val pIdxDst = appBuffer.pointer
//            device.mapMemory(vertexBufferMemory[frameIndex], 0, vertexSize.L, 0, pVtxDst)
//            device.mapMemory(indexBufferMemory[frameIndex], 0, indexSize.L, 0, pIdxDst)
//            var vtxDst = memGetAddress(pVtxDst)
//            var idxDst = memGetAddress(pIdxDst)
//            for (cmdList in drawData.cmdLists) {
//                for (v in cmdList.vtxBuffer) {
//                    memPutFloat(vtxDst, v.pos[0])
//                    memPutFloat(vtxDst + Float.BYTES, v.pos[1])
//                    memPutFloat(vtxDst + Float.BYTES * 2, v.uv[0])
//                    memPutFloat(vtxDst + Float.BYTES * 3, v.uv[1])
//                    memPutInt(vtxDst + Float.BYTES * 4, v.col)
//                    vtxDst += DrawVert.size
//                }
//                for (i in cmdList.idxBuffer) {
//                    memPutInt(idxDst * Int.BYTES, i)
//                    idxDst += Int.BYTES
//                }
//            }
//            val range = vk.MappedMemoryRange(2).also {
//                it[0].memory = vertexBufferMemory[frameIndex]
//                it[0].size = VK_WHOLE_SIZE
//                it[1].memory = indexBufferMemory[frameIndex]
//                it[1].size = VK_WHOLE_SIZE
//            }
//            device.flushMappedMemoryRanges(range)
//            device unmapMemory vertexBufferMemory[frameIndex]
//            device unmapMemory indexBufferMemory[frameIndex]
//        }
//
//        // Bind pipeline and descriptor sets:
//        run {
//            commandBuffer!!.bindPipeline(VkPipelineBindPoint.GRAPHICS, pipeline)
//            commandBuffer!!.bindDescriptorSets(VkPipelineBindPoint.GRAPHICS, pipelineLayout, descriptorSet)
//        }
//
//        // Bind Vertex And Index Buffer:
//        run {
//            commandBuffer!!.bindVertexBuffers(vertexBuffer[frameIndex])
//            commandBuffer!!.bindIndexBuffer(indexBuffer[frameIndex], 0, VkIndexType.UINT32) // TODO  VkIndexType.UINT16
//        }
//
//        // Setup viewport:
//        run {
//            val viewport = vk.Viewport {
//                offset(0f)
//                size(io.displaySize)
//                depth(0f, 1f)
//            }
//            commandBuffer!!.setViewport(viewport)
//        }
//
//        // Setup scale and translation:
//        run {
//            val scale = appBuffer.floatBuffer(2)
//            scale[0] = 2f / io.displaySize.x
//            scale[1] = 2f / io.displaySize.y
//            val translate = appBuffer.floatBuffer(2)
//            translate[0] = -1f
//            translate[1] = -1f
//            commandBuffer!!.pushConstants(pipelineLayout, VkShaderStage.VERTEX_BIT.i, 0, scale)
//            commandBuffer!!.pushConstants(pipelineLayout, VkShaderStage.VERTEX_BIT.i, scale.size, translate)
//        }
//
//        // Render the command lists:
//        var vtxOffset = 0
//        var idxOffset = 0
//        for (cmdList in drawData.cmdLists) {
//            for (cmd in cmdList.cmdBuffer) {
//                if (cmd.userCallback != null)
//                    cmd.userCallback!!(cmdList, cmd)
//                else {
//                    val scissor = vk.Rect2D {
//                        offset(if (cmd.clipRect.x > 0) cmd.clipRect.x.i else 0,
//                                if (cmd.clipRect.y > 0) cmd.clipRect.y.i else 0)
//                        extent(cmd.clipRect.z-cmd.clipRect.x,
//                                cmd.clipRect.w-cmd.clipRect.y+1) // FIXME: Why +1 here?
//                    }
//                    commandBuffer!!.setScissor(scissor)
//                    commandBuffer!!.drawIndexed(cmd.elemCount, 1, idxOffset, vtxOffset, 0)
//                }
//                idxOffset += cmd.elemCount * DrawIdx.BYTES
//            }
//            vtxOffset += cmdList.vtxBuffer.size * DrawVert.size
//        }
//    }
//
//    // Use if you want to reset your rendering device without losing ImGui state.
//    fun invalidateFontUploadObjects() {
//        if (uploadBuffer != NULL) {
//            device destroyBuffer uploadBuffer
//            uploadBuffer = NULL
//        }
//        if (uploadBufferMemory != NULL) {
//            device freeMemory uploadBufferMemory
//            uploadBufferMemory = NULL
//        }
//    }
//
//    fun invalidateDeviceObjects() {
//
//        invalidateFontUploadObjects()
//
//        device.apply {
//
//            for (i in 0 until VK_QUEUED_FRAMES) {
//
//                if (vertexBuffer[i] != NULL) {
//                    destroyBuffer(vertexBuffer[i])
//                    vertexBuffer[i] = NULL
//                }
//                if (vertexBufferMemory[i] != NULL) {
//                    freeMemory(vertexBufferMemory[i])
//                    vertexBufferMemory[i] = NULL
//                }
//                if (indexBuffer[i] != NULL) {
//                    destroyBuffer(indexBuffer[i])
//                    indexBuffer[i] = NULL
//                }
//                if (indexBufferMemory[i] != NULL) {
//                    freeMemory(indexBufferMemory[i])
//                    indexBufferMemory[i] = NULL
//                }
//            }
//
//            if (fontView != NULL) {
//                destroyImageView(fontView)
//                fontView = NULL
//            }
//            if (fontImage != NULL) {
//                destroyImage(fontImage)
//                fontImage = NULL
//            }
//            if (fontMemory != NULL) {
//                freeMemory(fontMemory)
//                fontMemory = NULL
//            }
//            if (fontSampler != NULL) {
//                destroySampler(fontSampler)
//                fontSampler = NULL
//            }
//            if (descriptorSetLayout != NULL) {
//                destroyDescriptorSetLayout(descriptorSetLayout)
//                descriptorSetLayout = NULL
//            }
//            if (pipelineLayout != NULL) {
//                destroyPipelineLayout(pipelineLayout)
//                pipelineLayout = NULL
//            }
//            if (pipeline != NULL) {
//                destroyPipeline(pipeline)
//                pipeline = NULL
//            }
//        }
//    }
//
//    fun createFontsTexture(commandBuffer: VkCommandBuffer): Boolean {
//
//        val (pixels, size, _) = io.fonts.getTexDataAsRGBA32()
//        val uploadSize = size.x * size.y * 4
//
//        // Create the Image:
//        run {
//            val info = vk.ImageCreateInfo {
//                imageType = VkImageType.`2D`
//                format = VkFormat.R8G8B8A8_UNORM
//                extent(size, 1)
//                mipLevels = 1
//                arrayLayers = 1
//                samples = VkSampleCount.`1_BIT`
//                tiling = VkImageTiling.OPTIMAL
//                usage = VkImageUsage.SAMPLED_BIT or VkImageUsage.TRANSFER_DST_BIT
//                sharingMode = VkSharingMode.EXCLUSIVE
//                initialLayout = VkImageLayout.UNDEFINED
//            }
//            fontImage = device createImage info
//            val req = device getImageMemoryRequirements fontImage
//            val allocInfo = vk.MemoryAllocateInfo {
//                allocationSize = req.size
//                memoryTypeIndex = memoryType(VkMemoryProperty.DEVICE_LOCAL_BIT.i, req.memoryTypeBits)
//            }
//            fontMemory = device allocateMemory allocInfo
//            device.bindImageMemory(fontImage, fontMemory)
//        }
//
//        // Create the Image View:
//        run {
//            val info = vk.ImageViewCreateInfo {
//                image = fontImage
//                viewType = VkImageViewType.`2D`
//                format = VkFormat.R8G8B8A8_UNORM
//                subresourceRange.apply {
//                    aspectMask = VkImageAspect.COLOR_BIT.i
//                    levelCount = 1
//                    layerCount = 1
//                }
//            }
//            fontView = device createImageView info
//        }
//
//        // Update the Descriptor Set:
//        run {
//            val descImage = vk.DescriptorImageInfo {
//                sampler = fontSampler
//                imageView = fontView
//                imageLayout = VkImageLayout.SHADER_READ_ONLY_OPTIMAL
//            }
//            val writeDesc = vk.WriteDescriptorSet {
//                dstSet = descriptorSet
//                descriptorType = VkDescriptorType.COMBINED_IMAGE_SAMPLER
//                imageInfo_ = descImage
//            }
//            device updateDescriptorSets writeDesc
//        }
//
//        // Create the Upload Buffer:
//        run {
//            val bufferInfo = vk.BufferCreateInfo {
//                this.size = uploadSize.L
//                usage = VkBufferUsage.TRANSFER_SRC_BIT.i
//                sharingMode = VkSharingMode.EXCLUSIVE
//            }
//            uploadBuffer = device createBuffer bufferInfo
//            val req = device getBufferMemoryRequirements uploadBuffer
//            bufferMemoryAlignment = if (bufferMemoryAlignment > req.alignment) bufferMemoryAlignment else req.alignment
//            val allocInfo = vk.MemoryAllocateInfo {
//                allocationSize = req.size
//                memoryTypeIndex = memoryType(VkMemoryProperty.HOST_VISIBLE_BIT.i, req.memoryTypeBits)
//            }
//            uploadBufferMemory = device allocateMemory allocInfo
//            device.bindBufferMemory(uploadBuffer, uploadBufferMemory)
//        }
//
//        // Upload to Buffer:
//        device.mappingMemory(uploadBufferMemory, 0, uploadSize.L) { map ->
//            memCopy(pixels.adr, map, uploadSize.L)
//            val range = vk.MappedMemoryRange {
//                memory = uploadBufferMemory
//                this.size = uploadSize.L
//            }
//            device flushMappedMemoryRanges range
//        }
//
//        // Copy to Image:
//        run {
//            val copyBarrier = vk.ImageMemoryBarrier {
//                dstAccessMask = VkAccess.TRANSFER_WRITE_BIT.i
//                oldLayout = VkImageLayout.UNDEFINED
//                newLayout = VkImageLayout.TRANSFER_DST_OPTIMAL
//                srcQueueFamilyIndex = VK_QUEUE_FAMILY_IGNORED
//                dstQueueFamilyIndex = VK_QUEUE_FAMILY_IGNORED
//                image = fontImage
//                subresourceRange.apply {
//                    aspectMask = VkImageAspect.COLOR_BIT.i
//                    levelCount = 1
//                    layerCount = 1
//                }
//            }
//            commandBuffer.pipelineBarrier(VkPipelineStage.HOST_BIT.i, VkPipelineStage.TRANSFER_BIT.i, 0, imageMemoryBarrier = copyBarrier)
//
//            val region = vk.BufferImageCopy {
//                imageSubresource.apply {
//                    aspectMask = VkImageAspect.COLOR_BIT.i
//                    layerCount = 1
//                }
//                imageExtent(size, 1)
//            }
//            commandBuffer.copyBufferToImage(uploadBuffer, fontImage, VkImageLayout.TRANSFER_DST_OPTIMAL, region)
//
//            val useBarrier = vk.ImageMemoryBarrier {
//                srcAccessMask = VkAccess.TRANSFER_WRITE_BIT.i
//                dstAccessMask = VkAccess.SHADER_READ_BIT.i
//                oldLayout = VkImageLayout.TRANSFER_DST_OPTIMAL
//                newLayout = VkImageLayout.SHADER_READ_ONLY_OPTIMAL
//                srcQueueFamilyIndex = VK_QUEUE_FAMILY_IGNORED
//                dstQueueFamilyIndex = VK_QUEUE_FAMILY_IGNORED
//                image = fontImage
//                subresourceRange.apply {
//                    aspectMask = VkImageAspect.COLOR_BIT.i
//                    levelCount = 1
//                    layerCount = 1
//                }
//            }
//            commandBuffer.pipelineBarrier(VkPipelineStage.TRANSFER_BIT.i, VkPipelineStage.FRAGMENT_SHADER_BIT.i, 0, imageMemoryBarrier = useBarrier)
//        }
//
//        // Store our identifier
//        io.fonts.texId = fontImage.i
//
//        return true
//    }
//
//    fun createDeviceObjects(): Boolean {
//
//        // Create The Shader Modules:
//        val vertInfo = vk.ShaderModuleCreateInfo { code = glslShaderVertSpv }
//        val vertModule = device createShaderModule vertInfo
//        val fragInfo = vk.ShaderModuleCreateInfo { code = glslShaderFragSpv }
//        val fragModule = device createShaderModule fragInfo
//
//        if (fontSampler == NULL) {
//            val info = vk.SamplerCreateInfo {
//                magFilter = VkFilter.LINEAR
//                minFilter = VkFilter.LINEAR
//                mipmapMode = VkSamplerMipmapMode.LINEAR
//                addressModeU = VkSamplerAddressMode.REPEAT
//                addressModeV = VkSamplerAddressMode.REPEAT
//                addressModeW = VkSamplerAddressMode.REPEAT
//                minLod = -1000f
//                maxLod = 1000f
//                maxAnisotropy = 1f
//            }
//            fontSampler = device createSampler info
//        }
//
//        if (descriptorSetLayout == NULL) {
//            val binding = vk.DescriptorSetLayoutBinding {
//                descriptorType = VkDescriptorType.COMBINED_IMAGE_SAMPLER
//                descriptorCount = 1
//                stageFlags = VkShaderStage.FRAGMENT_BIT.i
//                immutableSamplers = appBuffer longBufferOf fontSampler//TODO bug
//            }
//            val info = vk.DescriptorSetLayoutCreateInfo { this.binding = binding }
//            descriptorSetLayout = device createDescriptorSetLayout info
//        }
//
//        // Create Descriptor Set:
//        run {
//            val allocInfo = vk.DescriptorSetAllocateInfo {
//                descriptorPool = this@ImplGlfwVulkan.descriptorPool
//                descriptorSetCount = 1
//                setLayout = descriptorSetLayout
//            }
//            descriptorSet = device allocateDescriptorSets allocInfo
//        }
//
//        if (pipelineLayout == NULL) {
//            val pushConstants = vk.PushConstantRange {
//                stageFlags = VkShaderStage.VERTEX_BIT.i
//                offset = 0
//                size = Vec4.size
//            }
//            val layoutInfo = vk.PipelineLayoutCreateInfo {
//                setLayout = descriptorSetLayout
//                pushConstantRange = pushConstants
//            }
//            pipelineLayout = device createPipelineLayout layoutInfo
//        }
//
//        val stage = vk.PipelineShaderStageCreateInfo(2).also {
//            it[0].apply {
//                stage = VkShaderStage.VERTEX_BIT
//                module = vertModule
//                name = "main"
//            }
//            it[1].apply {
//                stage = VkShaderStage.FRAGMENT_BIT
//                module = fragModule
//                name = "main"
//            }
//        }
//        val bindingDesc = vk.VertexInputBindingDescription {
//            stride = DrawVert.size
//            inputRate = VkVertexInputRate.VERTEX
//        }
//        val attributeDesc = vk.VertexInputAttributeDescription(
//                bindingDesc.binding, 0, VkFormat.R32G32_SFLOAT, 0,
//                bindingDesc.binding, 1, VkFormat.R32G32_SFLOAT, Vec2.size,
//                bindingDesc.binding, 2, VkFormat.R8G8B8A8_UNORM, Vec2.size * 2)
//
//        val vertexInfo = vk.PipelineVertexInputStateCreateInfo {
//            vertexBindingDescription = bindingDesc
//            vertexAttributeDescriptions = attributeDesc
//        }
//        val iaInfo = vk.PipelineInputAssemblyStateCreateInfo { topology = VkPrimitiveTopology.TRIANGLE_LIST }
//
//        val viewportInfo = vk.PipelineViewportStateCreateInfo(1, 1)
//
//        val rasterInfo = vk.PipelineRasterizationStateCreateInfo(VkPolygonMode.FILL, VkCullMode.NONE.i, VkFrontFace.COUNTER_CLOCKWISE)
//
//        val msInfo = vk.PipelineMultisampleStateCreateInfo(VkSampleCount.`1_BIT`)
//
//        val colorAttachment = vk.PipelineColorBlendAttachmentState {
//            blendEnable = true
//            srcColorBlendFactor = VkBlendFactor.SRC_ALPHA
//            dstColorBlendFactor = VkBlendFactor.ONE_MINUS_SRC_ALPHA
//            colorBlendOp = VkBlendOp.ADD
//            srcAlphaBlendFactor = VkBlendFactor.ONE_MINUS_SRC_ALPHA
//            dstAlphaBlendFactor = VkBlendFactor.ZERO
//            alphaBlendOp = VkBlendOp.ADD
//            colorWriteMask = VkColorComponent.R_BIT or VkColorComponent.G_BIT or VkColorComponent.B_BIT or VkColorComponent.A_BIT
//        }
//        val depthInfo = vk.PipelineDepthStencilStateCreateInfo()
//
//        val blendInfo = vk.PipelineColorBlendStateCreateInfo(colorAttachment)
//
//        val dynamicStates = listOf(VkDynamicState.VIEWPORT, VkDynamicState.SCISSOR)
//        val dynamicState = vk.PipelineDynamicStateCreateInfo(dynamicStates)
//
//        val info = vk.GraphicsPipelineCreateInfo {
//            flags = pipelineCreateFlags
//            stages = stage
//            vertexInputState = vertexInfo
//            inputAssemblyState = iaInfo
//            viewportState = viewportInfo
//            rasterizationState = rasterInfo
//            multisampleState = msInfo
//            depthStencilState = depthInfo
//            colorBlendState = blendInfo
//            this.dynamicState = dynamicState
//            layout = pipelineLayout
//            renderPass = this@ImplGlfwVulkan.renderPass
//        }
//        pipeline = device.createGraphicsPipelines(pipelineCache, info)
//
//        device destroyShaderModules stage
//
//        return true
//    }
//
//    fun memoryType(properties: VkMemoryPropertyFlags, typeBits: Int): Int {
//        val prop = gpu.memoryProperties
//        for (i in 0 until prop.memoryTypeCount)
//            if ((prop.memoryTypes[i].propertyFlags and properties) == properties && typeBits has (1 shl i))
//                return i
//        return 0xffffffff.i // Unable to find memoryType
//    }
//
//// GLFW callbacks (installed by default if you enable 'install_callbacks' during initialization)
//// Provided here if you want to chain callbacks.
//// You can also handle inputs yourself and use those as a reference.
////    IMGUI_API void        ImGui_ImplGlfw_MouseButtonCallback(GLFWwindow* window, int button, int action, int mods)
////    IMGUI_API void        ImGui_ImplGlfw_ScrollCallback(GLFWwindow* window, double xoffset, double yoffset)
////    IMGUI_API void        ImGui_ImplGlfw_KeyCallback(GLFWwindow* window, int key, int scancode, int action, int mods)
////    IMGUI_API void ImGui_ImplGlfw_CharCallback(GLFWwindow* window, unsigned int c)
//}