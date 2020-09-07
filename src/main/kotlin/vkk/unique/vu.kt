package vkk.unique

import gli_.has
import gli_.memCopy
import glm_.f
import glm_.func.rad
import glm_.glm
import glm_.mat4x4.Mat4
import glm_.vec3.Vec3
import kool.Ptr
import org.lwjgl.vulkan.EXTDebugUtils.VK_EXT_DEBUG_UTILS_EXTENSION_NAME
import org.lwjgl.vulkan.VK10.VK_API_VERSION_1_0
import vkk.*
import vkk.entities.*
import vkk.extensions.getSurfaceSupportKHR
import vkk.identifiers.PhysicalDevice
import vkk.identifiers.UniqueDevice
import vkk.identifiers.UniqueInstance
import vkk.vk10.*
import vkk.vk10.structs.*

object vu {
    val deviceExtensions: ArrayList<String>
        get() = arrayListOf("VK_KHR_swapchain")

    class BufferData(val buffer: VkUniqueBuffer, val deviceMemory: VkUniqueDeviceMemory, val size: VkDeviceSize, val usage: VkBufferUsageFlags, val propertyFlags: VkMemoryPropertyFlags)

    fun copyToDevice(device: UniqueDevice, memory: VkUniqueDeviceMemory, pData: Ptr, size: Int, count: Int, stride: Int = size) {
        assert(size <= stride)
        device.mappedMemory(memory, VkDeviceSize(0), VkDeviceSize(count * stride)) { deviceData ->
            if (stride == size)
                memCopy(pData, deviceData, count * size)
            else
                for (i in 0 until count)
                    memCopy(pData + i * size, deviceData + i * stride, size)
        }
    }

    fun copyToDevice(device: UniqueDevice, memory: VkUniqueDeviceMemory, data: Ptr, size: Int) = copyToDevice(device, memory, data, size, 1)


    // math.cpp

    fun createModelViewProjectionClipMatrix(extent: Extent2D): Mat4 {
        var fov = 45f.rad
        if (extent.width > extent.height)
            fov *= extent.height.f / extent.width

        val model = Mat4(1f)
        val view = glm.lookAt(Vec3(-5f, 3f, -10f), Vec3(0f), Vec3(0f, -1f, 0f))
        val projection = glm.perspective(fov, 1f, 0.1f, 100f)
        val clip = Mat4(1f, 0f, 0f, 0f, 0f, -1f, 0f, 0f, 0f, 0f, .5f, 0f, 0f, 0f, 5f, 1f)   // vulkan clip space has inverted y and half z !
        return clip * projection * view * model
    }
}

interface UniqueVU : UniqueVk, UniquePhysicalDeviceI, UniqueDeviceI {

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

    fun vu.newBufferData(physicalDevice: PhysicalDevice, device: UniqueDevice,
                         size: VkDeviceSize, usage: VkBufferUsageFlags,
                         propertyFlags: VkMemoryPropertyFlags = VkMemoryProperty.HOST_VISIBLE_BIT or VkMemoryProperty.HOST_COHERENT_BIT): vu.BufferData {
        val buffer = device.createBufferUnique(BufferCreateInfo(0, size, usage))
        val deviceMemory = vu.allocateMemory(device, physicalDevice.memoryProperties, device getBufferMemoryRequirements buffer, propertyFlags)
        device.bindBufferMemory(buffer, deviceMemory)
        return vu.BufferData(buffer, deviceMemory, size, usage, propertyFlags)
    }

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

    fun vu.allocateMemory(device: UniqueDevice, memoryProperties: PhysicalDeviceMemoryProperties, memoryRequirements: MemoryRequirements, memoryPropertyFlags: VkMemoryPropertyFlags): VkUniqueDeviceMemory {
        val memoryTypeIndex = findMemoryType(memoryProperties, memoryRequirements.memoryTypeBits, memoryPropertyFlags)
        return device.allocateMemoryUnique(MemoryAllocateInfo(memoryRequirements.size, memoryTypeIndex))
    }

//    bool contains(std::vector<vk::ExtensionProperties> const& extensionProperties, std::string const& extensionName);
//    vk::UniqueCommandPool createCommandPool(vk::UniqueDevice &device, uint32_t queueFamilyIndex);

//    fun createDebugUtilsMessenger(instance: UniqueInstance): VkUniqueDebugUtilsMessengerEXT {
//        val severityFlags = VkDebugUtilsMessageSeverityEXT.WARNING.i or VkDebugUtilsMessageSeverityEXT.ERROR.i
//        val messageTypeFlags = VkDebugUtilsMessageTypeEXT.GENERAL.i or VkDebugUtilsMessageTypeEXT.PERFORMANCE.i or VkDebugUtilsMessageTypeEXT.VALIDATION.i
//        return instance.createDebugUtilsMessengerEXTUnique(vk::DebugUtilsMessengerCreateInfoEXT({}, severityFlags, messageTypeFlags, &vk::su::debugUtilsMessengerCallback))
//    }

//    vk::UniqueDescriptorPool createDescriptorPool(vk::UniqueDevice &device, std::vector<vk::DescriptorPoolSize> const& poolSizes);

    fun createDescriptorSetLayout(device: UniqueDevice, bindingData: ArrayList<Triple<VkDescriptorType, Int, VkShaderStageFlags>>,
            flags: VkDescriptorSetLayoutCreateFlags): VkUniqueDescriptorSetLayout {
        TODO()
//        std::vector<vk::DescriptorSetLayoutBinding> bindings(bindingData.size());
//        for (size_t i = 0; i < bindingData.size(); i++)
//        {
//            bindings[i] = vk::DescriptorSetLayoutBinding(checked_cast<uint32_t>(i), std::get<0>(bindingData[i]), std::get<1>(bindingData[i]), std::get<2>(bindingData[i]));
//        }
//        return device->createDescriptorSetLayoutUnique(vk::DescriptorSetLayoutCreateInfo(flags, checked_cast<uint32_t>(bindings.size()), bindings.data()));
    }

//    vk::DescriptorSetLayoutCreateFlags flags = {});

    fun vu.createDevice(physicalDevice: PhysicalDevice, queueFamilyIndex: Int, extensions: ArrayList<String> = ArrayList(),
                        physicalDeviceFeatures: PhysicalDeviceFeatures? = null, next: VkStructure? = null): UniqueDevice {
        // create a UniqueDevice
        val deviceQueueCreateInfo = DeviceQueueCreateInfo(0, queueFamilyIndex, queuePriority = 0f)
        val deviceCreateInfo = DeviceCreateInfo(0, deviceQueueCreateInfo, extensions, physicalDeviceFeatures)
        deviceCreateInfo.next = next
        return physicalDevice.createDeviceUnique(deviceCreateInfo)
    }

    fun Prova() = vkk.vk10.Prova()

//    std::vector<vk::UniqueFramebuffer> createFramebuffers(vk::UniqueDevice &device, vk::UniqueRenderPass &renderPass, std::vector<vk::UniqueImageView> const& imageViews, vk::UniqueImageView const& depthImageView, vk::Extent2D const& extent);
//    vk::UniquePipeline createGraphicsPipeline(vk::UniqueDevice const& device, vk::UniquePipelineCache const& pipelineCache,
//    std::pair<vk::ShaderModule, vk::SpecializationInfo const*> const& vertexShaderData,
//    std::pair<vk::ShaderModule, vk::SpecializationInfo const*> const& fragmentShaderData, uint32_t vertexStride,
//    std::vector<std::pair<vk::Format, uint32_t>> const& vertexInputAttributeFormatOffset, vk::FrontFace frontFace, bool depthBuffered,
//    vk::UniquePipelineLayout const& pipelineLayout, vk::UniqueRenderPass const& renderPass);

    fun vu.createInstance(appName: String, engineName: String,
                          layers: ArrayList<String> = ArrayList(), extensions: ArrayList<String> = ArrayList(),
                          apiVersion: Int = VK_API_VERSION_1_0): UniqueInstance {

        val layerProperties = ArrayList<LayerProperties>()
        val extensionProperties = ArrayList<ExtensionProperties>()

        if (vk.DEBUG) {
            layerProperties += vk.instanceLayerProperties
            extensionProperties += vk.enumerateInstanceExtensionProperties()
        }
        val enabledLayers = ArrayList<String>(layers.size)
        for (layer in layers) {
            assert(layerProperties.any { layer == it.layerName })
            enabledLayers += layer
        }
        if (vk.DEBUG) {
            val validation = "VK_LAYER_KHRONOS_validation"
            // Enable standard validation layer to find as much errors as possible!
            if (validation !in layers && layerProperties.any { validation == it.layerName })
                enabledLayers += validation
            val lunar = "VK_LAYER_LUNARG_assistant_layer"
            if (lunar !in layers && layerProperties.any { lunar == it.layerName })
                enabledLayers += lunar
        }

        val enabledExtensions = ArrayList<String>(extensions.size)
        for (ext in extensions) {
            assert(extensionProperties.any { ext == it.extensionName })
            enabledExtensions += ext
        }
        if (vk.DEBUG)
            if (VK_EXT_DEBUG_UTILS_EXTENSION_NAME !in extensions &&
                    extensionProperties.any { VK_EXT_DEBUG_UTILS_EXTENSION_NAME == it.extensionName })
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

        return vk.createInstanceUnique(instanceCreateInfo)
    }

//    vk::UniqueRenderPass createRenderPass(vk::UniqueDevice &device, vk::Format colorFormat, vk::Format depthFormat, vk::AttachmentLoadOp loadOp = vk::AttachmentLoadOp::eClear, vk::ImageLayout colorFinalLayout = vk::ImageLayout::ePresentSrcKHR);
//    VkBool32 debugUtilsMessengerCallback(VkDebugUtilsMessageSeverityFlagBitsEXT messageSeverity, VkDebugUtilsMessageTypeFlagsEXT messageTypes, VkDebugUtilsMessengerCallbackDataEXT const * pCallbackData, void * /*pUserData*/);

    fun vu.findGraphicsQueueFamilyIndex(queueFamilyProperties: Array<QueueFamilyProperties>): Int {
        // get the first index into queueFamiliyProperties which supports graphics
        val graphicsQueueFamilyIndex = queueFamilyProperties.indexOfFirst { it.queueFlags has VkQueueFlag.GRAPHICS_BIT }
        assert(graphicsQueueFamilyIndex != -1)

        return graphicsQueueFamilyIndex
    }

    fun vu.findGraphicsAndPresentQueueFamilyIndex(physicalDevice: PhysicalDevice, surface: VkSurfaceKHR): Pair<Int, Int> {
        val queueFamilyProperties = physicalDevice.queueFamilyProperties
        assert(queueFamilyProperties.size < Int.MAX_VALUE)

        val graphicsQueueFamilyIndex = findGraphicsQueueFamilyIndex(queueFamilyProperties)
        if (physicalDevice.getSurfaceSupportKHR(graphicsQueueFamilyIndex, surface))
            return graphicsQueueFamilyIndex to graphicsQueueFamilyIndex    // the first graphicsQueueFamilyIndex does also support presents

        // the graphicsQueueFamilyIndex doesn't support present -> look for an other family index that supports both graphics and present
        for (i in queueFamilyProperties.indices)
            if (queueFamilyProperties[i].queueFlags has VkQueueFlag.GRAPHICS_BIT && physicalDevice.getSurfaceSupportKHR(i, surface))
                return i to i

        // there's nothing like a single family index that supports both graphics and present -> look for an other family index that supports present
        for (i in queueFamilyProperties.indices)
            if (physicalDevice.getSurfaceSupportKHR(i, surface))
                return graphicsQueueFamilyIndex to i

        throw error("Could not find queues for both graphics or present -> terminating")
    }

    fun vu.findMemoryType(memoryProperties: PhysicalDeviceMemoryProperties, typeBits_: Int, requirementsMask: VkMemoryPropertyFlags): Int {
        var typeBits = typeBits_
        var typeIndex = -1
        for (i in memoryProperties.memoryTypes.indices) {
            if (typeBits has 1 && (memoryProperties.memoryTypes[i].propertyFlags and requirementsMask) == requirementsMask) {
                typeIndex = i
                break
            }
            typeBits = typeBits ushr 1
        }
        assert(typeIndex != -1)
        return typeIndex
    }

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