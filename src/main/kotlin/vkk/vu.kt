package vkk

import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.EXTDebugUtils.VK_EXT_DEBUG_UTILS_EXTENSION_NAME
import org.lwjgl.vulkan.VK10.*
import vkk._10.structs.*
import vkk.identifiers.Device
import vkk.identifiers.Instance
import vkk.identifiers.PhysicalDevice

object vu {

//    const uint64_t FenceTimeout = 100000000;
//
//    template <typename Func>
//    void oneTimeSubmit(vk::UniqueCommandBuffer const& commandBuffer, vk::Queue const& queue, Func const& func)
//    {
//        commandBuffer->begin(vk::CommandBufferBeginInfo(vk::CommandBufferUsageFlagBits::eOneTimeSubmit));
//        func(commandBuffer);
//        commandBuffer->end();
//        queue.submit(vk::SubmitInfo(0, nullptr, nullptr, 1, &(*commandBuffer)), nullptr);
//        queue.waitIdle();
//    }
//
//    template <typename Func>
//    void oneTimeSubmit(vk::UniqueDevice const& device, vk::UniqueCommandPool const& commandPool, vk::Queue const& queue, Func const& func)
//    {
//        vk::UniqueCommandBuffer commandBuffer = std::move(device->allocateCommandBuffersUnique(vk::CommandBufferAllocateInfo(*commandPool, vk::CommandBufferLevel::ePrimary, 1)).front());
//        oneTimeSubmit(commandBuffer, queue, func);
//    }
//
//    template <class T>
//    void copyToDevice(vk::UniqueDevice const& device, vk::UniqueDeviceMemory const& memory, T const* pData, size_t count, size_t stride = sizeof(T))
//    {
//        assert(sizeof(T) <= stride);
//        uint8_t* deviceData = static_cast<uint8_t*>(device->mapMemory(memory.get(), 0, count * stride));
//        if (stride == sizeof(T))
//        {
//            memcpy(deviceData, pData, count * sizeof(T));
//        }
//        else
//        {
//            for (size_t i = 0; i < count; i++)
//            {
//                memcpy(deviceData, &pData[i], sizeof(T));
//                deviceData += stride;
//            }
//        }
//        device->unmapMemory(memory.get());
//    }
//
//    template <class T>
//    void copyToDevice(vk::UniqueDevice const& device, vk::UniqueDeviceMemory const& memory, T const& data)
//    {
//        copyToDevice<T>(device, memory, &data, 1);
//    }
//
//    template<class T>
//    VULKAN_HPP_INLINE constexpr const T& clamp(const T& v, const T& lo, const T& hi)
//    {
//        return v < lo ? lo : hi < v ? hi : v;
//    }
//
//    void setImageLayout(vk::UniqueCommandBuffer const &commandBuffer, vk::Image image, vk::Format format, vk::ImageLayout oldImageLayout, vk::ImageLayout newImageLayout);
//
//    struct WindowData
//    {
//        WindowData(GLFWwindow *wnd, std::string const& name, vk::Extent2D const& extent);
//        WindowData(const WindowData &) = delete;
//        WindowData(WindowData &&other);
//        ~WindowData() noexcept;
//
//        GLFWwindow *handle;
//        std::string name;
//        vk::Extent2D extent;
//    };
//
//    WindowData createWindow(std::string const &windowName, vk::Extent2D const &extent);
//
//    struct BufferData
//    {
//        BufferData(vk::PhysicalDevice const& physicalDevice, vk::UniqueDevice const& device, vk::DeviceSize size, vk::BufferUsageFlags usage,
//                vk::MemoryPropertyFlags propertyFlags = vk::MemoryPropertyFlagBits::eHostVisible | vk::MemoryPropertyFlagBits::eHostCoherent);
//
//        template <typename DataType>
//        void upload(vk::UniqueDevice const& device, DataType const& data) const
//        {
//            assert((m_propertyFlags & vk::MemoryPropertyFlagBits::eHostCoherent) && (m_propertyFlags & vk::MemoryPropertyFlagBits::eHostVisible));
//            assert(sizeof(DataType) <= m_size);
//
//            void* dataPtr = device->mapMemory(*this->deviceMemory, 0, sizeof(DataType));
//            memcpy(dataPtr, &data, sizeof(DataType));
//            device->unmapMemory(*this->deviceMemory);
//        }
//
//        template <typename DataType>
//        void upload(vk::UniqueDevice const& device, std::vector<DataType> const& data, size_t stride = 0) const
//        {
//            assert(m_propertyFlags & vk::MemoryPropertyFlagBits::eHostVisible);
//
//            size_t elementSize = stride ? stride : sizeof(DataType);
//            assert(sizeof(DataType) <= elementSize);
//
//            copyToDevice(device, deviceMemory, data.data(), data.size(), elementSize);
//        }
//
//        template <typename DataType>
//        void upload(vk::PhysicalDevice const& physicalDevice, vk::UniqueDevice const& device, vk::UniqueCommandPool const& commandPool, vk::Queue queue, std::vector<DataType> const& data,
//        size_t stride) const
//        {
//            assert(m_usage & vk::BufferUsageFlagBits::eTransferDst);
//            assert(m_propertyFlags & vk::MemoryPropertyFlagBits::eDeviceLocal);
//
//            size_t elementSize = stride ? stride : sizeof(DataType);
//            assert(sizeof(DataType) <= elementSize);
//
//            size_t dataSize = data.size() * elementSize;
//            assert(dataSize <= m_size);
//
//            vk::su::BufferData stagingBuffer(physicalDevice, device, dataSize, vk::BufferUsageFlagBits::eTransferSrc);
//            copyToDevice(device, stagingBuffer.deviceMemory, data.data(), data.size(), elementSize);
//
//            vk::su::oneTimeSubmit(device, commandPool, queue,
//                    [&](vk::UniqueCommandBuffer const& commandBuffer) { commandBuffer->copyBuffer(*stagingBuffer.buffer, *this->buffer, vk::BufferCopy(0, 0, dataSize)); });
//        }
//
//        vk::UniqueBuffer        buffer;
//        vk::UniqueDeviceMemory  deviceMemory;
//        #if !defined(NDEBUG)
//        private:
//        vk::DeviceSize          m_size;
//        vk::BufferUsageFlags    m_usage;
//        vk::MemoryPropertyFlags m_propertyFlags;
//        #endif
//    };
//
//    struct ImageData
//    {
//        ImageData(vk::PhysicalDevice const& physicalDevice, vk::UniqueDevice const& device, vk::Format format, vk::Extent2D const& extent, vk::ImageTiling tiling, vk::ImageUsageFlags usage
//                , vk::ImageLayout initialLayout, vk::MemoryPropertyFlags memoryProperties, vk::ImageAspectFlags aspectMask);
//
//        vk::Format              format;
//        vk::UniqueImage         image;
//        vk::UniqueDeviceMemory  deviceMemory;
//        vk::UniqueImageView     imageView;
//    };
//
//    struct DepthBufferData : public ImageData
//    {
//        DepthBufferData(vk::PhysicalDevice &physicalDevice, vk::UniqueDevice & device, vk::Format format, vk::Extent2D const& extent);
//    };
//
//    struct SurfaceData
//    {
//        SurfaceData(vk::UniqueInstance &instance, std::string const& windowName, vk::Extent2D const& extent);
//
//        vk::Extent2D          extent;
//        WindowData            window;
//        vk::UniqueSurfaceKHR  surface;
//    };
//
//    struct SwapChainData
//    {
//        SwapChainData(vk::PhysicalDevice const& physicalDevice, vk::UniqueDevice const& device, vk::SurfaceKHR const& surface, vk::Extent2D const& extent, vk::ImageUsageFlags usage,
//                vk::UniqueSwapchainKHR const& oldSwapChain, uint32_t graphicsFamilyIndex, uint32_t presentFamilyIndex);
//
//        vk::Format                        colorFormat;
//        vk::UniqueSwapchainKHR            swapChain;
//        std::vector<vk::Image>            images;
//        std::vector<vk::UniqueImageView>  imageViews;
//    };
//
//    class CheckerboardImageGenerator
//    {
//        public:
//        CheckerboardImageGenerator(std::array<uint8_t, 3> const& rgb0 = {0, 0, 0}, std::array<uint8_t, 3> const& rgb1 = {255, 255, 255});
//
//        void operator()(void* data, vk::Extent2D &extent) const;
//
//        private:
//        std::array<uint8_t, 3> const& m_rgb0;
//        std::array<uint8_t, 3> const& m_rgb1;
//    };
//
//    class MonochromeImageGenerator
//    {
//        public:
//        MonochromeImageGenerator(std::array<unsigned char, 3> const& rgb);
//
//        void operator()(void* data, vk::Extent2D &extent) const;
//
//        private:
//        std::array<unsigned char, 3> const& m_rgb;
//    };
//
//    class PixelsImageGenerator
//    {
//        public:
//        PixelsImageGenerator(vk::Extent2D const& extent, size_t channels, unsigned char const* pixels);
//
//        void operator()(void* data, vk::Extent2D & extent) const;
//
//        private:
//        vk::Extent2D          m_extent;
//        size_t                m_channels;
//        unsigned char const*  m_pixels;
//    };
//
//
//    struct TextureData
//    {
//        TextureData(vk::PhysicalDevice const& physicalDevice, vk::UniqueDevice const& device, vk::Extent2D const& extent_ = {256, 256}, vk::ImageUsageFlags usageFlags = {},
//                vk::FormatFeatureFlags formatFeatureFlags = {}, bool anisotropyEnable = false, bool forceStaging = false);
//
//        template <typename ImageGenerator>
//        void setImage(vk::UniqueDevice const& device, vk::UniqueCommandBuffer const& commandBuffer, ImageGenerator const& imageGenerator)
//        {
//            void* data = needsStaging
//            ? device->mapMemory(stagingBufferData->deviceMemory.get(), 0, device->getBufferMemoryRequirements(stagingBufferData->buffer.get()).size)
//            : device->mapMemory(imageData->deviceMemory.get(), 0, device->getImageMemoryRequirements(imageData->image.get()).size);
//            imageGenerator(data, extent);
//            device->unmapMemory(needsStaging ? stagingBufferData->deviceMemory.get() : imageData->deviceMemory.get());
//
//            if (needsStaging)
//            {
//                // Since we're going to blit to the texture image, set its layout to eTransferDstOptimal
//                vk::su::setImageLayout(commandBuffer, imageData->image.get(), imageData->format, vk::ImageLayout::eUndefined, vk::ImageLayout::eTransferDstOptimal);
//                vk::BufferImageCopy copyRegion(0, extent.width, extent.height, vk::ImageSubresourceLayers(vk::ImageAspectFlagBits::eColor, 0, 0, 1), vk::Offset3D(0, 0, 0), vk::Extent3D(extent, 1));
//                commandBuffer->copyBufferToImage(stagingBufferData->buffer.get(), imageData->image.get(), vk::ImageLayout::eTransferDstOptimal, copyRegion);
//                // Set the layout for the texture image from eTransferDstOptimal to SHADER_READ_ONLY
//                vk::su::setImageLayout(commandBuffer, imageData->image.get(), imageData->format, vk::ImageLayout::eTransferDstOptimal, vk::ImageLayout::eShaderReadOnlyOptimal);
//            }
//            else
//            {
//                // If we can use the linear tiled image as a texture, just do it
//                vk::su::setImageLayout(commandBuffer, imageData->image.get(), imageData->format, vk::ImageLayout::ePreinitialized, vk::ImageLayout::eShaderReadOnlyOptimal);
//            }
//        }
//
//        vk::Format                  format;
//        vk::Extent2D                extent;
//        bool                        needsStaging;
//        std::unique_ptr<BufferData> stagingBufferData;
//        std::unique_ptr<ImageData>  imageData;
//        vk::UniqueSampler           textureSampler;
//    };
//
//    struct UUID
//    {
//        public:
//        UUID(uint8_t const data[VK_UUID_SIZE]);
//
//        uint8_t m_data[VK_UUID_SIZE];
//    };
//
//
//    template <typename TargetType, typename SourceType>
//    VULKAN_HPP_INLINE TargetType checked_cast(SourceType value)
//    {
//        static_assert(sizeof(TargetType) <= sizeof(SourceType), "No need to cast from smaller to larger type!");
//        static_assert(!std::numeric_limits<TargetType>::is_signed, "Only unsigned types supported!");
//        static_assert(!std::numeric_limits<SourceType>::is_signed, "Only unsigned types supported!");
//        assert(value <= std::numeric_limits<TargetType>::max());
//        return static_cast<TargetType>(value);
//    }
//
//    vk::UniqueDeviceMemory allocateMemory(vk::UniqueDevice const& device, vk::PhysicalDeviceMemoryProperties const& memoryProperties, vk::MemoryRequirements const& memoryRequirements,
//    vk::MemoryPropertyFlags memoryPropertyFlags);
//    bool contains(std::vector<vk::ExtensionProperties> const& extensionProperties, std::string const& extensionName);
//    vk::UniqueCommandPool createCommandPool(vk::UniqueDevice &device, uint32_t queueFamilyIndex);

//    fun createDebugUtilsMessenger(instance: UniqueInstance): VkUniqueDebugUtilsMessengerEXT {
//        val severityFlags = VkDebugUtilsMessageSeverityEXT.WARNING.i or VkDebugUtilsMessageSeverityEXT.ERROR.i
//        val messageTypeFlags = VkDebugUtilsMessageTypeEXT.GENERAL.i or VkDebugUtilsMessageTypeEXT.PERFORMANCE.i or VkDebugUtilsMessageTypeEXT.VALIDATION.i
//        return instance.createDebugUtilsMessengerEXTUnique(vk::DebugUtilsMessengerCreateInfoEXT({}, severityFlags, messageTypeFlags, &vk::su::debugUtilsMessengerCallback))
//    }

//    vk::UniqueDescriptorPool createDescriptorPool(vk::UniqueDevice &device, std::vector<vk::DescriptorPoolSize> const& poolSizes);
//    vk::UniqueDescriptorSetLayout createDescriptorSetLayout(vk::UniqueDevice const& device, std::vector<std::tuple<vk::DescriptorType, uint32_t, vk::ShaderStageFlags>> const& bindingData,
//    vk::DescriptorSetLayoutCreateFlags flags = {});

    fun createDevice(physicalDevice: PhysicalDevice, queueFamilyIndex: Int, extensions: ArrayList<String> = ArrayList(),
                     physicalDeviceFeatures: PhysicalDeviceFeatures? = null, next: VkStructure? = null): Device {
        // create a UniqueDevice
        val deviceQueueCreateInfo = DeviceQueueCreateInfo(0, queueFamilyIndex, queuePriority = 0f)
        val deviceCreateInfo = DeviceCreateInfo(0, deviceQueueCreateInfo, extensions, physicalDeviceFeatures)
        deviceCreateInfo.next = next
        return physicalDevice.createDevice(deviceCreateInfo)
    }

//    std::vector<vk::UniqueFramebuffer> createFramebuffers(vk::UniqueDevice &device, vk::UniqueRenderPass &renderPass, std::vector<vk::UniqueImageView> const& imageViews, vk::UniqueImageView const& depthImageView, vk::Extent2D const& extent);
//    vk::UniquePipeline createGraphicsPipeline(vk::UniqueDevice const& device, vk::UniquePipelineCache const& pipelineCache,
//    std::pair<vk::ShaderModule, vk::SpecializationInfo const*> const& vertexShaderData,
//    std::pair<vk::ShaderModule, vk::SpecializationInfo const*> const& fragmentShaderData, uint32_t vertexStride,
//    std::vector<std::pair<vk::Format, uint32_t>> const& vertexInputAttributeFormatOffset, vk::FrontFace frontFace, bool depthBuffered,
//    vk::UniquePipelineLayout const& pipelineLayout, vk::UniqueRenderPass const& renderPass);

    fun MemoryStack.createInstance(appName: String, engineName: String,
                       layers: ArrayList<String> = ArrayList(), extensions: ArrayList<String> = ArrayList(),
                       apiVersion: Int = VK_API_VERSION_1_0): Instance {

        val layerProperties = ArrayList<LayerProperties>()
        val extensionProperties = ArrayList<ExtensionProperties>()

        if (vk.DEBUG) {
            layerProperties += vk.enumerateInstanceLayerProperties()
            extensionProperties += vk.enumerateInstanceExtensionProperties()
        }
        val enabledLayers = ArrayList<String>(layers.size)
        for (layer in layers) {
            assert(layerProperties.find { layer == it.layerName } != null)
            enabledLayers += layer
        }
        if (vk.DEBUG) {
            val validation = "VK_LAYER_KHRONOS_validation"
            // Enable standard validation layer to find as much errors as possible!
            if (validation !in layers && layerProperties.find { validation == it.layerName } != null)
                enabledLayers += validation
            val lunar = "VK_LAYER_LUNARG_assistant_layer"
            if (lunar !in layers && layerProperties.find { lunar == it.layerName } != null)
                enabledLayers += lunar
        }

        val enabledExtensions = ArrayList<String>(extensions.size)
        for (ext in extensions) {
            assert(extensionProperties.find { ext == it.extensionName } != null)
            enabledExtensions += ext
        }
        if (vk.DEBUG)
            if (VK_EXT_DEBUG_UTILS_EXTENSION_NAME !in extensions &&
                    extensionProperties.find { VK_EXT_DEBUG_UTILS_EXTENSION_NAME == it.extensionName } != null)
                enabledExtensions += VK_EXT_DEBUG_UTILS_EXTENSION_NAME

        // create a UniqueInstance
        val applicationInfo = ApplicationInfo(appName, 1, engineName, 1, apiVersion)
        // in non-debug mode just use the InstanceCreateInfo for instance creation
        val instanceCreateInfo = InstanceCreateInfo(applicationInfo, enabledLayers, enabledExtensions)
//        if(vk.DEBUG) {
        // in debug mode, additionally use the debugUtilsMessengerCallback in instance creation!
//            val severityFlags = VkDebugUtilsMessageSeverityEXT.WARNING.i or VkDebugUtilsMessageSeverityEXT.ERROR.i
//            val messageTypeFlags = VkDebugUtilsMessageTypeEXT.GENERAL.i or VkDebugUtilsMessageTypeEXT.PERFORMANCE.i or VkDebugUtilsMessageTypeEXT.VALIDATION.i
//            instanceCreateInfo += DebugUtilCr
//            { {}, severityFlags, messageTypeFlags, &vk::su::debugUtilsMessengerCallback }
//            )
//        }

        return Instance(instanceCreateInfo)
    }

//    vk::UniqueRenderPass createRenderPass(vk::UniqueDevice &device, vk::Format colorFormat, vk::Format depthFormat, vk::AttachmentLoadOp loadOp = vk::AttachmentLoadOp::eClear, vk::ImageLayout colorFinalLayout = vk::ImageLayout::ePresentSrcKHR);
//    VkBool32 debugUtilsMessengerCallback(VkDebugUtilsMessageSeverityFlagBitsEXT messageSeverity, VkDebugUtilsMessageTypeFlagsEXT messageTypes, VkDebugUtilsMessengerCallbackDataEXT const * pCallbackData, void * /*pUserData*/);

    fun findGraphicsQueueFamilyIndex(queueFamilyProperties: Array<QueueFamilyProperties>): Int {
        // get the first index into queueFamiliyProperties which supports graphics
        val graphicsQueueFamilyIndex = queueFamilyProperties.indexOfFirst { it.queueFlags has VkQueueFlag.GRAPHICS_BIT }
        assert(graphicsQueueFamilyIndex != -1)

        return graphicsQueueFamilyIndex
    }

//    std::pair<uint32_t, uint32_t> findGraphicsAndPresentQueueFamilyIndex(vk::PhysicalDevice physicalDevice, vk::SurfaceKHR const& surface);
//    uint32_t findMemoryType(vk::PhysicalDeviceMemoryProperties const& memoryProperties, uint32_t typeBits, vk::MemoryPropertyFlags requirementsMask);
//    std::vector<std::string> getDeviceExtensions();
//    std::vector<std::string> getInstanceExtensions();
//    vk::Format pickDepthFormat(vk::PhysicalDevice const& physicalDevice);
//    vk::PresentModeKHR pickPresentMode(std::vector<vk::PresentModeKHR> const& presentModes);
//    vk::SurfaceFormatKHR pickSurfaceFormat(std::vector<vk::SurfaceFormatKHR> const& formats);
//    void submitAndWait(vk::UniqueDevice &device, vk::Queue queue, vk::UniqueCommandBuffer &commandBuffer);
//    void updateDescriptorSets(vk::UniqueDevice const& device, vk::UniqueDescriptorSet const& descriptorSet,
//    std::vector<std::tuple<vk::DescriptorType, vk::UniqueBuffer const&, vk::UniqueBufferView const&>> const& bufferData, vk::su::TextureData const& textureData,
//    uint32_t bindingOffset = 0);
//    void updateDescriptorSets(vk::UniqueDevice const& device, vk::UniqueDescriptorSet const& descriptorSet,
//    std::vector<std::tuple<vk::DescriptorType, vk::UniqueBuffer const&, vk::UniqueBufferView const&>> const& bufferData,
//    std::vector<vk::su::TextureData> const& textureData, uint32_t bindingOffset = 0);
}