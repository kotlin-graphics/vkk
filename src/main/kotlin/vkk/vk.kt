package vkk

//import java.lang.ref.Cleaner
import identifiers.VK
import kool.*
import org.lwjgl.system.JNI
import org.lwjgl.system.JNI.callPPI
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.vulkan.VkExtensionProperties
import org.lwjgl.vulkan.VkLayerProperties
import vkk._10.ExtensionProperties
import vkk._10.LayerProperties


//fun main() {
//    println(VK10.VK_HEADER_VERSION)
//}

object vk {

    //    val cleaner by lazy { Cleaner.create() }

    // --- [ vkEnumerateInstanceExtensionProperties ] ---
    inline fun nEnumerateInstanceExtensionProperties(pLayerName: Ptr, pPropertyCount: IntPtr, pProperties: Ptr = NULL): VkResult =
            VkResult(JNI.callPPPI(pLayerName, pPropertyCount.adr, pProperties, VK.globalCommands!!.vkEnumerateInstanceExtensionProperties))

    infix fun enumerateInstanceExtensionProperties(layerName: String?): Array<ExtensionProperties> = stak { s ->
        val pLayerName = layerName?.let { s.utf8Adr(layerName) } ?: NULL
        var properties: Ptr = NULL
        val pPropertyCount = s.mInt()
        var propertyCount: Int
        var result: VkResult
        do {
            result = nEnumerateInstanceExtensionProperties(pLayerName, pPropertyCount)
            propertyCount = pPropertyCount[0]
            if (result == VkResult.SUCCESS && propertyCount != 0) {
                properties = s.ncalloc(VkExtensionProperties.ALIGNOF, propertyCount, VkExtensionProperties.SIZEOF)
                result = nEnumerateInstanceExtensionProperties(pLayerName, pPropertyCount, properties)
            }
        } while (result == VkResult.INCOMPLETE)
        return Array(propertyCount) {
            ExtensionProperties(BytePtr(properties + it * VkExtensionProperties.SIZEOF))
        }
    }

    // --- [ vkEnumerateInstanceLayerProperties ] ---
    inline fun nEnumerateInstanceLayerProperties(pPropertyCount: IntPtr, pProperties: Ptr = NULL): VkResult =
            VkResult(callPPI(pPropertyCount.adr, pProperties, VK.globalCommands!!.vkEnumerateInstanceLayerProperties))

    fun enumerateInstanceLayerProperties(): Array<LayerProperties> = stak { s ->
        var properties: Ptr = NULL
        val pPropertyCount = s.mInt()
        var propertyCount: Int
        var result: VkResult
        do {
            result = nEnumerateInstanceLayerProperties(pPropertyCount)
            propertyCount = pPropertyCount[0]
            if (result == VkResult.SUCCESS && propertyCount != 0) {
                properties = s.ncalloc(VkLayerProperties.ALIGNOF, 1, VkLayerProperties.SIZEOF)
                result = nEnumerateInstanceLayerProperties(pPropertyCount, properties)
            }
        } while (result == VkResult.INCOMPLETE)
        return Array(propertyCount) {
            LayerProperties(BytePtr(properties + it * VkLayerProperties.SIZEOF))
        }
    }

    /*  Function Constructors     */

//    fun AttachmentReference(attachment: Int, layout: VkImageLayout): VkAttachmentReference =
//            AttachmentReference().attachment(attachment).layout(layout.i)
//
//    fun AttachmentReference(
//            attachment0: Int, layout0: VkImageLayout,
//            attachment1: Int, layout1: VkImageLayout): VkAttachmentReference.Buffer =
//            AttachmentReference(2).also {
//                it[0].attachment(attachment0).layout(layout0.i)
//                it[1].attachment(attachment1).layout(layout1.i)
//            }
//
//    fun AttachmentReference(
//            attachment0: Int, layout0: VkImageLayout,
//            attachment1: Int, layout1: VkImageLayout,
//            attachment2: Int, layout2: VkImageLayout): VkAttachmentReference.Buffer =
//            AttachmentReference(3).also {
//                it[0].attachment(attachment0).layout(layout0.i)
//                it[1].attachment(attachment1).layout(layout1.i)
//                it[2].attachment(attachment2).layout(layout2.i)
//            }
//
//    fun AttachmentReference(
//            attachment0: Int, layout0: VkImageLayout,
//            attachment1: Int, layout1: VkImageLayout,
//            attachment2: Int, layout2: VkImageLayout,
//            attachment3: Int, layout3: VkImageLayout): VkAttachmentReference.Buffer =
//            AttachmentReference(4).also {
//                it[0].attachment(attachment0).layout(layout0.i)
//                it[1].attachment(attachment1).layout(layout1.i)
//                it[2].attachment(attachment2).layout(layout2.i)
//                it[3].attachment(attachment3).layout(layout3.i)
//            }
//
//    fun AttachmentReference(
//            attachment0: Int, layout0: VkImageLayout,
//            attachment1: Int, layout1: VkImageLayout,
//            attachment2: Int, layout2: VkImageLayout,
//            attachment3: Int, layout3: VkImageLayout,
//            attachment4: Int, layout4: VkImageLayout): VkAttachmentReference.Buffer =
//            AttachmentReference(5).also {
//                it[0].attachment(attachment0).layout(layout0.i)
//                it[1].attachment(attachment1).layout(layout1.i)
//                it[2].attachment(attachment2).layout(layout2.i)
//                it[3].attachment(attachment3).layout(layout3.i)
//                it[4].attachment(attachment4).layout(layout4.i)
//            }
//
//    fun CommandBufferAllocateInfo(commandPool: VkCommandPool, level: VkCommandBufferLevel, bufferCount: Int): VkCommandBufferAllocateInfo = CommandBufferAllocateInfo {
//        this.commandPool = commandPool
//        this.level = level
//        commandBufferCount = bufferCount
//    }
//
//    fun ComputePipelineCreateInfo(layout: VkPipelineLayout, flags: VkPipelineCreateFlags = 0): VkComputePipelineCreateInfo =
//            ComputePipelineCreateInfo {
//                this.layout = layout
//                this.flags = flags
//            }
//
//    fun DescriptorImageInfo(sampler: VkSampler, imageView: VkImageView, imageLayout: VkImageLayout): VkDescriptorImageInfo =
//            DescriptorImageInfo {
//                this.sampler = sampler
//                this.imageView = imageView
//                this.imageLayout = imageLayout
//            }
//
//    fun DescriptorPoolCreateInfo(poolSize: VkDescriptorPoolSize, maxSets: Int): VkDescriptorPoolCreateInfo =
//            DescriptorPoolCreateInfo {
//                this.poolSize = poolSize
//                this.maxSets = maxSets
//            }
//
//    fun DescriptorPoolCreateInfo(poolSizes: VkDescriptorPoolSize.Buffer, maxSets: Int): VkDescriptorPoolCreateInfo =
//            DescriptorPoolCreateInfo {
//                this.poolSizes = poolSizes
//                this.maxSets = maxSets
//            }
//
//    fun DescriptorPoolSize(type: VkDescriptorType, descriptorCount: Int): VkDescriptorPoolSize =
//            DescriptorPoolSize {
//                this.type = type
//                this.descriptorCount = descriptorCount
//            }
//
//    fun DescriptorPoolSize(
//            type0: VkDescriptorType, descriptorCount0: Int,
//            type1: VkDescriptorType, descriptorCount1: Int): VkDescriptorPoolSize.Buffer =
//            DescriptorPoolSize(2) {
//                this[0].type(type0.i).descriptorCount(descriptorCount0)
//                this[1].type(type1.i).descriptorCount(descriptorCount1)
//            }
//
//    fun DescriptorPoolSize(
//            type0: VkDescriptorType, descriptorCount0: Int,
//            type1: VkDescriptorType, descriptorCount1: Int,
//            type2: VkDescriptorType, descriptorCount2: Int): VkDescriptorPoolSize.Buffer =
//            DescriptorPoolSize(3) {
//                this[0].type(type0.i).descriptorCount(descriptorCount0)
//                this[1].type(type1.i).descriptorCount(descriptorCount1)
//                this[2].type(type2.i).descriptorCount(descriptorCount2)
//            }
//
//    fun DescriptorPoolSize(
//            type0: VkDescriptorType, descriptorCount0: Int,
//            type1: VkDescriptorType, descriptorCount1: Int,
//            type2: VkDescriptorType, descriptorCount2: Int,
//            type3: VkDescriptorType, descriptorCount3: Int): VkDescriptorPoolSize.Buffer =
//            DescriptorPoolSize(4) {
//                this[0].type(type0.i).descriptorCount(descriptorCount0)
//                this[1].type(type1.i).descriptorCount(descriptorCount1)
//                this[2].type(type2.i).descriptorCount(descriptorCount2)
//                this[3].type(type3.i).descriptorCount(descriptorCount3)
//            }
//
//    fun DescriptorPoolSize(
//            type0: VkDescriptorType, descriptorCount0: Int,
//            type1: VkDescriptorType, descriptorCount1: Int,
//            type2: VkDescriptorType, descriptorCount2: Int,
//            type3: VkDescriptorType, descriptorCount3: Int,
//            type4: VkDescriptorType, descriptorCount4: Int): VkDescriptorPoolSize.Buffer =
//            DescriptorPoolSize(5) {
//                this[0].type(type0.i).descriptorCount(descriptorCount0)
//                this[1].type(type1.i).descriptorCount(descriptorCount1)
//                this[2].type(type2.i).descriptorCount(descriptorCount2)
//                this[3].type(type3.i).descriptorCount(descriptorCount3)
//                this[4].type(type4.i).descriptorCount(descriptorCount4)
//            }
//
//    fun DescriptorPoolSize(
//            type0: VkDescriptorType, descriptorCount0: Int,
//            type1: VkDescriptorType, descriptorCount1: Int,
//            type2: VkDescriptorType, descriptorCount2: Int,
//            type3: VkDescriptorType, descriptorCount3: Int,
//            type4: VkDescriptorType, descriptorCount4: Int,
//            type5: VkDescriptorType, descriptorCount5: Int): VkDescriptorPoolSize.Buffer =
//            DescriptorPoolSize(6) {
//                this[0].type(type0.i).descriptorCount(descriptorCount0)
//                this[1].type(type1.i).descriptorCount(descriptorCount1)
//                this[2].type(type2.i).descriptorCount(descriptorCount2)
//                this[3].type(type3.i).descriptorCount(descriptorCount3)
//                this[4].type(type4.i).descriptorCount(descriptorCount4)
//                this[5].type(type5.i).descriptorCount(descriptorCount5)
//            }
//
//    fun DescriptorPoolSize(
//            type0: VkDescriptorType, descriptorCount0: Int,
//            type1: VkDescriptorType, descriptorCount1: Int,
//            type2: VkDescriptorType, descriptorCount2: Int,
//            type3: VkDescriptorType, descriptorCount3: Int,
//            type4: VkDescriptorType, descriptorCount4: Int,
//            type5: VkDescriptorType, descriptorCount5: Int,
//            type6: VkDescriptorType, descriptorCount6: Int): VkDescriptorPoolSize.Buffer =
//            DescriptorPoolSize(7) {
//                this[0].type(type0.i).descriptorCount(descriptorCount0)
//                this[1].type(type1.i).descriptorCount(descriptorCount1)
//                this[2].type(type2.i).descriptorCount(descriptorCount2)
//                this[3].type(type3.i).descriptorCount(descriptorCount3)
//                this[4].type(type4.i).descriptorCount(descriptorCount4)
//                this[5].type(type5.i).descriptorCount(descriptorCount5)
//                this[6].type(type6.i).descriptorCount(descriptorCount6)
//            }
//
//    fun DescriptorPoolSize(
//            type0: VkDescriptorType, descriptorCount0: Int,
//            type1: VkDescriptorType, descriptorCount1: Int,
//            type2: VkDescriptorType, descriptorCount2: Int,
//            type3: VkDescriptorType, descriptorCount3: Int,
//            type4: VkDescriptorType, descriptorCount4: Int,
//            type5: VkDescriptorType, descriptorCount5: Int,
//            type6: VkDescriptorType, descriptorCount6: Int,
//            type7: VkDescriptorType, descriptorCount7: Int): VkDescriptorPoolSize.Buffer =
//            DescriptorPoolSize(8) {
//                this[0].type(type0.i).descriptorCount(descriptorCount0)
//                this[1].type(type1.i).descriptorCount(descriptorCount1)
//                this[2].type(type2.i).descriptorCount(descriptorCount2)
//                this[3].type(type3.i).descriptorCount(descriptorCount3)
//                this[4].type(type4.i).descriptorCount(descriptorCount4)
//                this[5].type(type5.i).descriptorCount(descriptorCount5)
//                this[6].type(type6.i).descriptorCount(descriptorCount6)
//                this[7].type(type7.i).descriptorCount(descriptorCount7)
//            }
//
//    fun DescriptorPoolSize(
//            type0: VkDescriptorType, descriptorCount0: Int,
//            type1: VkDescriptorType, descriptorCount1: Int,
//            type2: VkDescriptorType, descriptorCount2: Int,
//            type3: VkDescriptorType, descriptorCount3: Int,
//            type4: VkDescriptorType, descriptorCount4: Int,
//            type5: VkDescriptorType, descriptorCount5: Int,
//            type6: VkDescriptorType, descriptorCount6: Int,
//            type7: VkDescriptorType, descriptorCount7: Int,
//            type8: VkDescriptorType, descriptorCount8: Int): VkDescriptorPoolSize.Buffer =
//            DescriptorPoolSize(9) {
//                this[0].type(type0.i).descriptorCount(descriptorCount0)
//                this[1].type(type1.i).descriptorCount(descriptorCount1)
//                this[2].type(type2.i).descriptorCount(descriptorCount2)
//                this[3].type(type3.i).descriptorCount(descriptorCount3)
//                this[4].type(type4.i).descriptorCount(descriptorCount4)
//                this[5].type(type5.i).descriptorCount(descriptorCount5)
//                this[6].type(type6.i).descriptorCount(descriptorCount6)
//                this[7].type(type7.i).descriptorCount(descriptorCount7)
//                this[8].type(type8.i).descriptorCount(descriptorCount8)
//            }
//
//    fun DescriptorPoolSize(
//            type0: VkDescriptorType, descriptorCount0: Int,
//            type1: VkDescriptorType, descriptorCount1: Int,
//            type2: VkDescriptorType, descriptorCount2: Int,
//            type3: VkDescriptorType, descriptorCount3: Int,
//            type4: VkDescriptorType, descriptorCount4: Int,
//            type5: VkDescriptorType, descriptorCount5: Int,
//            type6: VkDescriptorType, descriptorCount6: Int,
//            type7: VkDescriptorType, descriptorCount7: Int,
//            type8: VkDescriptorType, descriptorCount8: Int,
//            type9: VkDescriptorType, descriptorCount9: Int): VkDescriptorPoolSize.Buffer =
//            DescriptorPoolSize(10) {
//                this[0].type(type0.i).descriptorCount(descriptorCount0)
//                this[1].type(type1.i).descriptorCount(descriptorCount1)
//                this[2].type(type2.i).descriptorCount(descriptorCount2)
//                this[3].type(type3.i).descriptorCount(descriptorCount3)
//                this[4].type(type4.i).descriptorCount(descriptorCount4)
//                this[5].type(type5.i).descriptorCount(descriptorCount5)
//                this[6].type(type6.i).descriptorCount(descriptorCount6)
//                this[7].type(type7.i).descriptorCount(descriptorCount7)
//                this[8].type(type8.i).descriptorCount(descriptorCount8)
//                this[9].type(type9.i).descriptorCount(descriptorCount9)
//            }
//
//    fun DescriptorPoolSize(
//            type0: VkDescriptorType, descriptorCount0: Int,
//            type1: VkDescriptorType, descriptorCount1: Int,
//            type2: VkDescriptorType, descriptorCount2: Int,
//            type3: VkDescriptorType, descriptorCount3: Int,
//            type4: VkDescriptorType, descriptorCount4: Int,
//            type5: VkDescriptorType, descriptorCount5: Int,
//            type6: VkDescriptorType, descriptorCount6: Int,
//            type7: VkDescriptorType, descriptorCount7: Int,
//            type8: VkDescriptorType, descriptorCount8: Int,
//            type9: VkDescriptorType, descriptorCount9: Int,
//            type10: VkDescriptorType, descriptorCount10: Int): VkDescriptorPoolSize.Buffer =
//            DescriptorPoolSize(11) {
//                this[0].type(type0.i).descriptorCount(descriptorCount0)
//                this[1].type(type1.i).descriptorCount(descriptorCount1)
//                this[2].type(type2.i).descriptorCount(descriptorCount2)
//                this[3].type(type3.i).descriptorCount(descriptorCount3)
//                this[4].type(type4.i).descriptorCount(descriptorCount4)
//                this[5].type(type5.i).descriptorCount(descriptorCount5)
//                this[6].type(type6.i).descriptorCount(descriptorCount6)
//                this[7].type(type7.i).descriptorCount(descriptorCount7)
//                this[8].type(type8.i).descriptorCount(descriptorCount8)
//                this[9].type(type9.i).descriptorCount(descriptorCount9)
//                this[10].type(type10.i).descriptorCount(descriptorCount10)
//            }
//
//    fun DescriptorSetAllocateInfo(descriptorPool: VkDescriptorPool, setLayout: VkDescriptorSetLayout): VkDescriptorSetAllocateInfo =
//            DescriptorSetAllocateInfo {
//                this.descriptorPool = descriptorPool
//                this.setLayout = setLayout
//            }
//
//    fun DescriptorSetLayoutBinding(type: VkDescriptorType, stageFlags: VkShaderStageFlags, binding: Int, descriptorCount: Int = 1): VkDescriptorSetLayoutBinding =
//            DescriptorSetLayoutBinding {
//                descriptorType = type
//                this.stageFlags = stageFlags
//                this.binding = binding
//                this.descriptorCount = descriptorCount
//            }
//
//    fun DescriptorSetLayoutBinding(
//            type0: VkDescriptorType, stageFlags0: VkShaderStageFlags, binding0: Int,
//            type1: VkDescriptorType, stageFlags1: VkShaderStageFlags, binding1: Int): VkDescriptorSetLayoutBinding.Buffer =
//            DescriptorSetLayoutBinding(
//                    type0, stageFlags0, binding0, 1,
//                    type1, stageFlags1, binding1, 1)
//
//    fun DescriptorSetLayoutBinding(
//            type0: VkDescriptorType, stageFlags0: VkShaderStageFlags, binding0: Int,
//            type1: VkDescriptorType, stageFlags1: VkShaderStageFlags, binding1: Int,
//            type2: VkDescriptorType, stageFlags2: VkShaderStageFlags, binding2: Int): VkDescriptorSetLayoutBinding.Buffer =
//            DescriptorSetLayoutBinding(
//                    type0, stageFlags0, binding0, 1,
//                    type1, stageFlags1, binding1, 1,
//                    type2, stageFlags2, binding2, 1)
//
//    fun DescriptorSetLayoutBinding(
//            type0: VkDescriptorType, stageFlags0: VkShaderStageFlags, binding0: Int,
//            type1: VkDescriptorType, stageFlags1: VkShaderStageFlags, binding1: Int,
//            type2: VkDescriptorType, stageFlags2: VkShaderStageFlags, binding2: Int,
//            type3: VkDescriptorType, stageFlags3: VkShaderStageFlags, binding3: Int): VkDescriptorSetLayoutBinding.Buffer =
//            DescriptorSetLayoutBinding(
//                    type0, stageFlags0, binding0, 1,
//                    type1, stageFlags1, binding1, 1,
//                    type2, stageFlags2, binding2, 1,
//                    type3, stageFlags3, binding3, 1)
//
//    fun DescriptorSetLayoutBinding(
//            type0: VkDescriptorType, stageFlags0: VkShaderStageFlags, binding0: Int, descriptorCount0: Int,
//            type1: VkDescriptorType, stageFlags1: VkShaderStageFlags, binding1: Int, descriptorCount1: Int): VkDescriptorSetLayoutBinding.Buffer =
//            DescriptorSetLayoutBinding(2) {
//                this[0].descriptorType(type0.i).stageFlags(stageFlags0).binding(binding0).descriptorCount(descriptorCount0)
//                this[1].descriptorType(type1.i).stageFlags(stageFlags1).binding(binding1).descriptorCount(descriptorCount1)
//            }
//
//    fun DescriptorSetLayoutBinding(
//            type0: VkDescriptorType, stageFlags0: VkShaderStageFlags, binding0: Int, descriptorCount0: Int,
//            type1: VkDescriptorType, stageFlags1: VkShaderStageFlags, binding1: Int, descriptorCount1: Int,
//            type2: VkDescriptorType, stageFlags2: VkShaderStageFlags, binding2: Int, descriptorCount2: Int): VkDescriptorSetLayoutBinding.Buffer =
//            DescriptorSetLayoutBinding(3) {
//                this[0].descriptorType(type0.i).stageFlags(stageFlags0).binding(binding0).descriptorCount(descriptorCount0)
//                this[1].descriptorType(type1.i).stageFlags(stageFlags1).binding(binding1).descriptorCount(descriptorCount1)
//                this[2].descriptorType(type2.i).stageFlags(stageFlags2).binding(binding2).descriptorCount(descriptorCount2)
//            }
//
//    fun DescriptorSetLayoutBinding(
//            type0: VkDescriptorType, stageFlags0: VkShaderStageFlags, binding0: Int, descriptorCount0: Int,
//            type1: VkDescriptorType, stageFlags1: VkShaderStageFlags, binding1: Int, descriptorCount1: Int,
//            type2: VkDescriptorType, stageFlags2: VkShaderStageFlags, binding2: Int, descriptorCount2: Int,
//            type3: VkDescriptorType, stageFlags3: VkShaderStageFlags, binding3: Int, descriptorCount3: Int): VkDescriptorSetLayoutBinding.Buffer =
//            DescriptorSetLayoutBinding(4) {
//                this[0].descriptorType(type0.i).stageFlags(stageFlags0).binding(binding0).descriptorCount(descriptorCount0)
//                this[1].descriptorType(type1.i).stageFlags(stageFlags1).binding(binding1).descriptorCount(descriptorCount1)
//                this[2].descriptorType(type2.i).stageFlags(stageFlags2).binding(binding2).descriptorCount(descriptorCount2)
//                this[3].descriptorType(type3.i).stageFlags(stageFlags3).binding(binding3).descriptorCount(descriptorCount3)
//            }
//
//    fun DescriptorSetLayoutCreateInfo(binding: VkDescriptorSetLayoutBinding): VkDescriptorSetLayoutCreateInfo =
//            DescriptorSetLayoutCreateInfo { this.binding = binding }
//
//    fun DescriptorSetLayoutCreateInfo(bindings: VkDescriptorSetLayoutBinding.Buffer): VkDescriptorSetLayoutCreateInfo =
//            DescriptorSetLayoutCreateInfo { this.bindings = bindings }
//
////    inline fun DeviceCreateInfo(queueCreateInfo: VkDeviceQueueCreateInfo, ): VkDeviceCreateInfo {
////
////    }
//
//    fun FenceCreateInfo(flag: VkFenceCreate): VkFenceCreateInfo =
//            FenceCreateInfo { flags = flag.i }
//
//    fun FenceCreateInfo(flags: VkFenceCreateFlags = 0): VkFenceCreateInfo =
//            FenceCreateInfo { this.flags = flags }
//
//    fun GraphicsPipelineCreateInfo(layout: VkPipelineLayout, renderPass: VkRenderPass, flags: VkPipelineCreateFlags = 0): VkGraphicsPipelineCreateInfo =
//            GraphicsPipelineCreateInfo {
//                this.layout = layout
//                this.renderPass = renderPass
//                this.flags = flags
//                basePipelineIndex = -1
//                basePipelineHandle = VkPipeline(NULL)
//            }
//
//    fun PipelineColorBlendAttachmentState(colorWriteMask: VkColorComponentFlags, blendEnable: Boolean): VkPipelineColorBlendAttachmentState =
//            PipelineColorBlendAttachmentState().colorWriteMask(colorWriteMask).blendEnable(blendEnable)
//
//    fun PipelineColorBlendAttachmentState(
//            colorWriteMask0: VkColorComponentFlags, blendEnable0: Boolean,
//            colorWriteMask1: VkColorComponentFlags, blendEnable1: Boolean): VkPipelineColorBlendAttachmentState.Buffer =
//            PipelineColorBlendAttachmentState(2).also {
//                it[0].colorWriteMask(colorWriteMask0).blendEnable(blendEnable0)
//                it[1].colorWriteMask(colorWriteMask1).blendEnable(blendEnable1)
//            }
//
//    fun PipelineColorBlendAttachmentState(
//            colorWriteMask0: VkColorComponentFlags, blendEnable0: Boolean,
//            colorWriteMask1: VkColorComponentFlags, blendEnable1: Boolean,
//            colorWriteMask2: VkColorComponentFlags, blendEnable2: Boolean): VkPipelineColorBlendAttachmentState.Buffer =
//            PipelineColorBlendAttachmentState(3).also {
//                it[0].colorWriteMask(colorWriteMask0).blendEnable(blendEnable0)
//                it[1].colorWriteMask(colorWriteMask1).blendEnable(blendEnable1)
//                it[2].colorWriteMask(colorWriteMask2).blendEnable(blendEnable2)
//            }
//
//    fun PipelineColorBlendAttachmentState(
//            colorWriteMask0: VkColorComponentFlags, blendEnable0: Boolean,
//            colorWriteMask1: VkColorComponentFlags, blendEnable1: Boolean,
//            colorWriteMask2: VkColorComponentFlags, blendEnable2: Boolean,
//            colorWriteMask3: VkColorComponentFlags, blendEnable3: Boolean): VkPipelineColorBlendAttachmentState.Buffer =
//            PipelineColorBlendAttachmentState(4).also {
//                it[0].colorWriteMask(colorWriteMask0).blendEnable(blendEnable0)
//                it[1].colorWriteMask(colorWriteMask1).blendEnable(blendEnable1)
//                it[2].colorWriteMask(colorWriteMask2).blendEnable(blendEnable2)
//                it[3].colorWriteMask(colorWriteMask3).blendEnable(blendEnable3)
//            }
//
//    fun PipelineColorBlendAttachmentState(
//            colorWriteMask0: VkColorComponentFlags, blendEnable0: Boolean,
//            colorWriteMask1: VkColorComponentFlags, blendEnable1: Boolean,
//            colorWriteMask2: VkColorComponentFlags, blendEnable2: Boolean,
//            colorWriteMask3: VkColorComponentFlags, blendEnable3: Boolean,
//            colorWriteMask4: VkColorComponentFlags, blendEnable4: Boolean): VkPipelineColorBlendAttachmentState.Buffer =
//            PipelineColorBlendAttachmentState(5).also {
//                it[0].colorWriteMask(colorWriteMask0).blendEnable(blendEnable0)
//                it[1].colorWriteMask(colorWriteMask1).blendEnable(blendEnable1)
//                it[2].colorWriteMask(colorWriteMask2).blendEnable(blendEnable2)
//                it[3].colorWriteMask(colorWriteMask3).blendEnable(blendEnable3)
//                it[4].colorWriteMask(colorWriteMask4).blendEnable(blendEnable4)
//            }
//
//    fun PipelineColorBlendStateCreateInfo(attachment: VkPipelineColorBlendAttachmentState): VkPipelineColorBlendStateCreateInfo =
//            PipelineColorBlendStateCreateInfo { this.attachment = attachment }
//
//    fun PipelineDepthStencilStateCreateInfo(depthTestEnable: Boolean,
//                                            depthWriteEnable: Boolean,
//                                            depthCompareOp: VkCompareOp): VkPipelineDepthStencilStateCreateInfo =
//            PipelineDepthStencilStateCreateInfo {
//                this.depthTestEnable = depthTestEnable
//                this.depthWriteEnable = depthWriteEnable
//                this.depthCompareOp = depthCompareOp
//                front = back
//                back.compareOp = VkCompareOp.ALWAYS
//            }
//
//    fun PipelineDynamicStateCreateInfo(dynamicStates: Collection<VkDynamicState>, flags: VkPipelineDynamicStateCreateFlags = 0): VkPipelineDynamicStateCreateInfo = stak {
//        PipelineDynamicStateCreateInfo {
//            this.dynamicStates = it.VkDynamicStateBuffer(dynamicStates)
//            this.flags = flags
//        }
//    }
//
//    fun PipelineInputAssemblyStateCreateInfo(topology: VkPrimitiveTopology,
//                                             flags: VkPipelineInputAssemblyStateCreateFlags = 0,
//                                             primitiveRestartEnable: Boolean = false): VkPipelineInputAssemblyStateCreateInfo =
//            PipelineInputAssemblyStateCreateInfo {
//                this.topology = topology
//                this.flags = flags
//                this.primitiveRestartEnable = primitiveRestartEnable
//            }
//
//    fun PipelineLayoutCreateInfo(setLayout: VkDescriptorSetLayout): VkPipelineLayoutCreateInfo =
//            PipelineLayoutCreateInfo { this.setLayout = setLayout }
//
//    // TODO flag
//    fun PipelineMultisampleStateCreateInfo(rasterizationSamples: VkSampleCount, flags: VkPipelineMultisampleStateCreateFlags = 0): VkPipelineMultisampleStateCreateInfo =
//            PipelineMultisampleStateCreateInfo {
//                this.rasterizationSamples = rasterizationSamples
//                this.flags = flags
//            }
//
//    fun PipelineRasterizationStateCreateInfo(
//            polygonMode: VkPolygonMode,
//            cullMode: VkCullModeFlags,
//            frontFace: VkFrontFace,
//            flags: VkPipelineRasterizationStateCreateFlags = 0): VkPipelineRasterizationStateCreateInfo =
//            PipelineRasterizationStateCreateInfo {
//                this.polygonMode = polygonMode
//                this.cullMode = cullMode
//                this.frontFace = frontFace
//                this.flags = flags
//                depthClampEnable = false
//                lineWidth = 1f
//            }
//
//    fun PipelineViewportStateCreateInfo(viewportCount: Int, scissorCount: Int, flags: VkPipelineViewportStateCreateFlags = 0): VkPipelineViewportStateCreateInfo =
//            PipelineViewportStateCreateInfo {
//                this.viewportCount = viewportCount
//                this.scissorCount = scissorCount
//                this.flags = flags
//            }
//
//    fun PushConstantRange(stageFlag: VkShaderStage, size: Int, offset: Int = 0): VkPushConstantRange =
//            PushConstantRange(stageFlag.i, size, offset)
//
//    fun PushConstantRange(stageFlags: VkShaderStageFlags, size: Int, offset: Int = 0): VkPushConstantRange =
//            PushConstantRange {
//                this.stageFlags = stageFlags
//                this.size = size
//                this.offset = offset
//            }
//
//    fun Rect2D(extend: Vec2i): VkRect2D = Rect2D(0, 0, extend.x, extend.y)
//
//    fun Rect2D(offset: Vec2i, extend: Vec2i): VkRect2D = Rect2D(offset.x, offset.y, extend.x, extend.y)
//
//    fun Rect2D(offsetX: Int, offsetY: Int, width: Int, height: Int): VkRect2D = Rect2D {
//        offset.x = offsetX
//        offset.y = offsetY
//        extent.width = width
//        extent.height = height
//    }
//
//    fun SpecializationInfo(mapEntries: VkSpecializationMapEntry.Buffer, data: ByteBuffer): VkSpecializationInfo =
//            SpecializationInfo().also {
//                it.mapEntries = mapEntries
//                it.data = data
//            }
//
//    fun SpecializationInfo(
//            mapEntries0: VkSpecializationMapEntry.Buffer, data0: ByteBuffer,
//            mapEntries1: VkSpecializationMapEntry.Buffer, data1: ByteBuffer): VkSpecializationInfo.Buffer =
//            SpecializationInfo(2).also {
//                it[0].apply {
//                    mapEntries = mapEntries0
//                    data = data0
//                }
//                it[1].apply {
//                    mapEntries = mapEntries1
//                    data = data1
//                }
//            }
//
//    fun SpecializationMapEntry(constantId: Int, offset: Int, size: Int): VkSpecializationMapEntry =
//            SpecializationMapEntry().also {
//                it.constantId = constantId
//                it.offset = offset
//                it.size = size.L
//            }
//
//    fun SpecializationMapEntry(
//            constantId0: Int, offset0: Int, size0: Int,
//            constantId1: Int, offset1: Int, size1: Int): VkSpecializationMapEntry.Buffer =
//            SpecializationMapEntry(2).also {
//                it[0].constantID(constantId0).offset(offset0).size(size0.L)
//                it[1].constantID(constantId1).offset(offset1).size(size1.L)
//            }
//
//    fun SpecializationMapEntry(
//            constantId0: Int, offset0: Int, size0: Int,
//            constantId1: Int, offset1: Int, size1: Int,
//            constantId2: Int, offset2: Int, size2: Int): VkSpecializationMapEntry.Buffer =
//            SpecializationMapEntry(3).also {
//                it[0].constantID(constantId0).offset(offset0).size(size0.L)
//                it[1].constantID(constantId1).offset(offset1).size(size1.L)
//                it[2].constantID(constantId2).offset(offset2).size(size2.L)
//            }
//
//    fun SpecializationMapEntry(
//            constantId0: Int, offset0: Int, size0: Int,
//            constantId1: Int, offset1: Int, size1: Int,
//            constantId2: Int, offset2: Int, size2: Int,
//            constantId3: Int, offset3: Int, size3: Int): VkSpecializationMapEntry.Buffer =
//            SpecializationMapEntry(4).also {
//                it[0].constantID(constantId0).offset(offset0).size(size0.L)
//                it[1].constantID(constantId1).offset(offset1).size(size1.L)
//                it[2].constantID(constantId2).offset(offset2).size(size2.L)
//                it[3].constantID(constantId3).offset(offset3).size(size3.L)
//            }
//
//    fun SurfaceFormatKHR(format: VkFormat, colorSpace: VkColorSpaceKHR): VkSurfaceFormatKHR =
//            SurfaceFormatKHR().also {
//                it.format = format
//                it.colorSpace = colorSpace
//            }
//
//    fun VertexInputBindingDescription(binding: Int, stride: Int, inputRate: VkVertexInputRate): VkVertexInputBindingDescription =
//            VertexInputBindingDescription {
//                this.binding = binding
//                this.stride = stride
//                this.inputRate = inputRate
//            }
//
//    fun Viewport(size: Vec2i, minDepth: Float = 0f, maxDepth: Float = 1f): VkViewport =
//            Viewport(size.x.f, size.y.f, minDepth, maxDepth)
//
//    fun Viewport(width: Float, height: Float, minDepth: Float = 0f, maxDepth: Float = 1f): VkViewport =
//            Viewport {
//                this.width = width
//                this.height = height
//                this.minDepth = minDepth
//                this.maxDepth = maxDepth
//            }
//
//    fun WriteDescriptorSet(dstSet: VkDescriptorSet, type: VkDescriptorType, binding: Int, imageInfo: VkDescriptorImageInfo): VkWriteDescriptorSet =
//            WriteDescriptorSet {
//                this.dstSet = dstSet
//                descriptorType = type
//                dstBinding = binding
//                this.imageInfo = imageInfo
//            }
//
//    fun WriteDescriptorSet(dstSet: VkDescriptorSet, type: VkDescriptorType, binding: Int, bufferInfo: VkDescriptorBufferInfo): VkWriteDescriptorSet =
//            WriteDescriptorSet {
//                this.dstSet = dstSet
//                descriptorType = type
//                dstBinding = binding
//                bufferInfo_ = bufferInfo
//            }
//
//    fun WriteDescriptorSet(
//            dstSet0: VkDescriptorSet, type0: VkDescriptorType, binding0: Int, info0: Struct,
//            dstSet1: VkDescriptorSet, type1: VkDescriptorType, binding1: Int, info1: Struct): VkWriteDescriptorSet.Buffer =
//            WriteDescriptorSet(2).also {
//                it[0].dstSet(dstSet0.L).descriptorType(type0.i).dstBinding(binding0)
//                if (info0 is VkDescriptorBufferInfo) it[0].bufferInfo_ = info0 else it[0].imageInfo = info0 as VkDescriptorImageInfo
//                it[1].dstSet(dstSet1.L).descriptorType(type1.i).dstBinding(binding1)
//                if (info1 is VkDescriptorBufferInfo) it[1].bufferInfo_ = info1 else it[1].imageInfo = info1 as VkDescriptorImageInfo
//            }
//
//    fun WriteDescriptorSet(
//            dstSet0: VkDescriptorSet, type0: VkDescriptorType, binding0: Int, info0: Struct,
//            dstSet1: VkDescriptorSet, type1: VkDescriptorType, binding1: Int, info1: Struct,
//            dstSet2: VkDescriptorSet, type2: VkDescriptorType, binding2: Int, info2: Struct): VkWriteDescriptorSet.Buffer =
//            WriteDescriptorSet(3).also {
//                it[0].dstSet(dstSet0.L).descriptorType(type0.i).dstBinding(binding0)
//                if (info0 is VkDescriptorBufferInfo) it[0].bufferInfo_ = info0 else it[0].imageInfo = info0 as VkDescriptorImageInfo
//                it[1].dstSet(dstSet1.L).descriptorType(type1.i).dstBinding(binding1)
//                if (info1 is VkDescriptorBufferInfo) it[1].bufferInfo_ = info1 else it[1].imageInfo = info1 as VkDescriptorImageInfo
//                it[2].dstSet(dstSet2.L).descriptorType(type2.i).dstBinding(binding2)
//                if (info2 is VkDescriptorBufferInfo) it[2].bufferInfo_ = info2 else it[2].imageInfo = info2 as VkDescriptorImageInfo
//            }
//
//    fun WriteDescriptorSet(
//            dstSet0: VkDescriptorSet, type0: VkDescriptorType, binding0: Int, info0: Struct,
//            dstSet1: VkDescriptorSet, type1: VkDescriptorType, binding1: Int, info1: Struct,
//            dstSet2: VkDescriptorSet, type2: VkDescriptorType, binding2: Int, info2: Struct,
//            dstSet3: VkDescriptorSet, type3: VkDescriptorType, binding3: Int, info3: Struct): VkWriteDescriptorSet.Buffer =
//            WriteDescriptorSet(4).also {
//                it[0].dstSet(dstSet0.L).descriptorType(type0.i).dstBinding(binding0)
//                if (info0 is VkDescriptorBufferInfo) it[0].bufferInfo_ = info0 else it[0].imageInfo = info0 as VkDescriptorImageInfo
//                it[1].dstSet(dstSet1.L).descriptorType(type1.i).dstBinding(binding1)
//                if (info1 is VkDescriptorBufferInfo) it[1].bufferInfo_ = info1 else it[1].imageInfo = info1 as VkDescriptorImageInfo
//                it[2].dstSet(dstSet2.L).descriptorType(type2.i).dstBinding(binding2)
//                if (info2 is VkDescriptorBufferInfo) it[2].bufferInfo_ = info2 else it[2].imageInfo = info2 as VkDescriptorImageInfo
//                it[3].dstSet(dstSet3.L).descriptorType(type3.i).dstBinding(binding3)
//                if (info3 is VkDescriptorBufferInfo) it[3].bufferInfo_ = info3 else it[3].imageInfo = info3 as VkDescriptorImageInfo
//            }
//
//
//    /*
//        Full Constructors
//     */
//
//
//    fun ImageSubresourceRange(
//            aspectMask: VkImageAspect,
//            baseMipLevel: Int,
//            levelCount: Int,
//            baseArrayLayer: Int,
//            layerCount: Int): VkImageSubresourceRange =
//            ImageSubresourceRange {
//                this.aspectMask = aspectMask.i
//                this.baseMipLevel = baseMipLevel
//                this.levelCount = levelCount
//                this.baseArrayLayer = baseArrayLayer
//                this.layerCount = layerCount
//            }
//
//    fun ImageSubresourceRange(
//            aspectMask: VkImageAspectFlags,
//            baseMipLevel: Int,
//            levelCount: Int,
//            baseArrayLayer: Int,
//            layerCount: Int): VkImageSubresourceRange =
//            ImageSubresourceRange {
//                this.aspectMask = aspectMask
//                this.baseMipLevel = baseMipLevel
//                this.levelCount = levelCount
//                this.baseArrayLayer = baseArrayLayer
//                this.layerCount = layerCount
//            }
//
//    fun VertexInputAttributeDescription(binding: Int, location: Int, format: VkFormat, offset: Int): VkVertexInputAttributeDescription =
//            VertexInputAttributeDescription {
//                this.location = location
//                this.binding = binding
//                this.format = format
//                this.offset = offset
//            }
//
//    fun VertexInputAttributeDescription(
//            binding0: Int, location0: Int, format0: VkFormat, offset0: Int,
//            binding1: Int, location1: Int, format1: VkFormat, offset1: Int): VkVertexInputAttributeDescription.Buffer =
//            VertexInputAttributeDescription(2) {
//                this[0].location(location0).binding(binding0).format(format0.i).offset(offset0)
//                this[1].location(location1).binding(binding1).format(format1.i).offset(offset1)
//            }
//
//    fun VertexInputAttributeDescription(
//            binding0: Int, location0: Int, format0: VkFormat, offset0: Int,
//            binding1: Int, location1: Int, format1: VkFormat, offset1: Int,
//            binding2: Int, location2: Int, format2: VkFormat, offset2: Int): VkVertexInputAttributeDescription.Buffer =
//            VertexInputAttributeDescription(3) {
//                this[0].location(location0).binding(binding0).format(format0.i).offset(offset0)
//                this[1].location(location1).binding(binding1).format(format1.i).offset(offset1)
//                this[2].location(location2).binding(binding2).format(format2.i).offset(offset2)
//            }
//
//    fun VertexInputAttributeDescription(
//            binding0: Int, location0: Int, format0: VkFormat, offset0: Int,
//            binding1: Int, location1: Int, format1: VkFormat, offset1: Int,
//            binding2: Int, location2: Int, format2: VkFormat, offset2: Int,
//            binding3: Int, location3: Int, format3: VkFormat, offset3: Int): VkVertexInputAttributeDescription.Buffer =
//            VertexInputAttributeDescription(4) {
//                this[0].location(location0).binding(binding0).format(format0.i).offset(offset0)
//                this[1].location(location1).binding(binding1).format(format1.i).offset(offset1)
//                this[2].location(location2).binding(binding2).format(format2.i).offset(offset2)
//                this[3].location(location3).binding(binding3).format(format3.i).offset(offset3)
//            }
//
//    fun VertexInputAttributeDescription(
//            binding0: Int, location0: Int, format0: VkFormat, offset0: Int,
//            binding1: Int, location1: Int, format1: VkFormat, offset1: Int,
//            binding2: Int, location2: Int, format2: VkFormat, offset2: Int,
//            binding3: Int, location3: Int, format3: VkFormat, offset3: Int,
//            binding4: Int, location4: Int, format4: VkFormat, offset4: Int): VkVertexInputAttributeDescription.Buffer =
//            VertexInputAttributeDescription(4) {
//                this[0].location(location0).binding(binding0).format(format0.i).offset(offset0)
//                this[1].location(location1).binding(binding1).format(format1.i).offset(offset1)
//                this[2].location(location2).binding(binding2).format(format2.i).offset(offset2)
//                this[3].location(location3).binding(binding3).format(format3.i).offset(offset3)
//                this[4].location(location4).binding(binding4).format(format4.i).offset(offset4)
//            }
//
//    fun VertexInputAttributeDescription(
//            binding0: Int, location0: Int, format0: VkFormat, offset0: Int,
//            binding1: Int, location1: Int, format1: VkFormat, offset1: Int,
//            binding2: Int, location2: Int, format2: VkFormat, offset2: Int,
//            binding3: Int, location3: Int, format3: VkFormat, offset3: Int,
//            binding4: Int, location4: Int, format4: VkFormat, offset4: Int,
//            binding5: Int, location5: Int, format5: VkFormat, offset5: Int): VkVertexInputAttributeDescription.Buffer =
//            VertexInputAttributeDescription(4) {
//                this[0].location(location0).binding(binding0).format(format0.i).offset(offset0)
//                this[1].location(location1).binding(binding1).format(format1.i).offset(offset1)
//                this[2].location(location2).binding(binding2).format(format2.i).offset(offset2)
//                this[3].location(location3).binding(binding3).format(format3.i).offset(offset3)
//                this[4].location(location4).binding(binding4).format(format4.i).offset(offset4)
//                this[5].location(location5).binding(binding5).format(format5.i).offset(offset5)
//            }
//
//    fun VertexInputAttributeDescription(
//            binding0: Int, location0: Int, format0: VkFormat, offset0: Int,
//            binding1: Int, location1: Int, format1: VkFormat, offset1: Int,
//            binding2: Int, location2: Int, format2: VkFormat, offset2: Int,
//            binding3: Int, location3: Int, format3: VkFormat, offset3: Int,
//            binding4: Int, location4: Int, format4: VkFormat, offset4: Int,
//            binding5: Int, location5: Int, format5: VkFormat, offset5: Int,
//            binding6: Int, location6: Int, format6: VkFormat, offset6: Int): VkVertexInputAttributeDescription.Buffer =
//            VertexInputAttributeDescription(4) {
//                this[0].location(location0).binding(binding0).format(format0.i).offset(offset0)
//                this[1].location(location1).binding(binding1).format(format1.i).offset(offset1)
//                this[2].location(location2).binding(binding2).format(format2.i).offset(offset2)
//                this[3].location(location3).binding(binding3).format(format3.i).offset(offset3)
//                this[4].location(location4).binding(binding4).format(format4.i).offset(offset4)
//                this[5].location(location5).binding(binding5).format(format5.i).offset(offset5)
//                this[6].location(location6).binding(binding6).format(format6.i).offset(offset6)
//            }


    val VERSION = "0.2.4"
}
