package vkk

import glm_.BYTES
import glm_.bool
import glm_.i
import glm_.vec2.Vec2i
import glm_.vec3.Vec3i
import glm_.vec4.Vec4
import kool.Ptr
import kool.adr
import org.lwjgl.system.MemoryStack.stackGet
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.vulkan.*
import vkk.entities.*
import java.nio.FloatBuffer
import java.nio.IntBuffer
import java.nio.LongBuffer


inline var VkDescriptorPoolSize.type: VkDescriptorType
    get() = VkDescriptorType(VkDescriptorPoolSize.ntype(adr))
    set(value) = VkDescriptorPoolSize.ntype(adr, value.i)
inline var VkDescriptorPoolSize.descriptorCount
    get() = VkDescriptorPoolSize.ndescriptorCount(adr)
    set(value) = VkDescriptorPoolSize.ndescriptorCount(adr, value)


inline var VkDescriptorPoolCreateInfo.type: VkStructureType
    get() = VkStructureType(VkDescriptorPoolCreateInfo.nsType(adr))
    set(value) = VkDescriptorPoolCreateInfo.nsType(adr, value.i)
inline var VkDescriptorPoolCreateInfo.next
    get() = VkDescriptorPoolCreateInfo.npNext(adr)
    set(value) = VkDescriptorPoolCreateInfo.npNext(adr, value)
/** JVM custom */
inline var VkDescriptorPoolCreateInfo.flag: VkDescriptorPoolCreate
    get() = throw Exception("Invalid")
    set(value) = VkDescriptorPoolCreateInfo.nflags(adr, value.i)
inline var VkDescriptorPoolCreateInfo.flags: VkDescriptorPoolCreateFlags
    get() = VkDescriptorPoolCreateInfo.nflags(adr)
    set(value) = VkDescriptorPoolCreateInfo.nflags(adr, value)
inline var VkDescriptorPoolCreateInfo.maxSets
    get() = VkDescriptorPoolCreateInfo.nmaxSets(adr)
    set(value) = VkDescriptorPoolCreateInfo.nmaxSets(adr, value)
@Deprecated("this will be set automatically")
inline var VkDescriptorPoolCreateInfo.poolSizeCount: Int
    get() = VkDescriptorPoolCreateInfo.npoolSizeCount(adr)
    set(value) = VkDescriptorPoolCreateInfo.npoolSizeCount(adr, value)
inline var VkDescriptorPoolCreateInfo.poolSizes: VkDescriptorPoolSize.Buffer
    get() = VkDescriptorPoolCreateInfo.npPoolSizes(adr)
    set(value) = VkDescriptorPoolCreateInfo.npPoolSizes(adr, value)
/** JVM custom */
inline var VkDescriptorPoolCreateInfo.poolSize: VkDescriptorPoolSize
    get() = VkDescriptorPoolSize.create(memGetAddress(adr + VkDescriptorPoolCreateInfo.PPOOLSIZES))
    set(value) {
        memPutAddress(adr + VkDescriptorPoolCreateInfo.PPOOLSIZES, value.adr)
        poolSizeCount = 1
    }


inline var VkDescriptorSetAllocateInfo.type: VkStructureType
    get() = VkStructureType(VkDescriptorSetAllocateInfo.nsType(adr))
    set(value) = VkDescriptorSetAllocateInfo.nsType(adr, value.i)
inline var VkDescriptorSetAllocateInfo.next
    get() = VkDescriptorSetAllocateInfo.npNext(adr)
    set(value) = VkDescriptorSetAllocateInfo.npNext(adr, value)
inline var VkDescriptorSetAllocateInfo.descriptorPool: VkDescriptorPool
    get() = VkDescriptorPool(VkDescriptorSetAllocateInfo.ndescriptorPool(adr))
    set(value) = VkDescriptorSetAllocateInfo.ndescriptorPool(adr, value.L)
@Deprecated("this will be set automatically")
inline var VkDescriptorSetAllocateInfo.descriptorSetCount: Int
    get() = VkDescriptorSetAllocateInfo.ndescriptorSetCount(adr)
    set(value) = VkDescriptorSetAllocateInfo.ndescriptorSetCount(adr, value)
inline var VkDescriptorSetAllocateInfo.setLayouts: VkDescriptorSetLayout_Buffer
    get() = VkDescriptorSetLayout_Buffer(VkDescriptorSetAllocateInfo.npSetLayouts(adr))
    set(value) = VkDescriptorSetAllocateInfo.npSetLayouts(adr, value.buffer)
/** JVM custom */
inline var VkDescriptorSetAllocateInfo.setLayout: VkDescriptorSetLayout
    get() = VkDescriptorSetLayout(VkDescriptorSetAllocateInfo.npSetLayouts(adr)[0])
    set(value) {
        val p = stackGet().nmalloc(8, Long.BYTES)
        memPutLong(p, value.L)
        memPutAddress(adr + VkDescriptorSetAllocateInfo.PSETLAYOUTS, p)
        descriptorSetCount = 1
    }


inline var VkDescriptorImageInfo.sampler: VkSampler
    get() = VkSampler(VkDescriptorImageInfo.nsampler(adr))
    set(value) = VkDescriptorImageInfo.nsampler(adr, value.L)
inline var VkDescriptorImageInfo.imageView: VkImageView
    get() = VkImageView(VkDescriptorImageInfo.nimageView(adr))
    set(value) = VkDescriptorImageInfo.nimageView(adr, value.L)
inline var VkDescriptorImageInfo.imageLayout: VkImageLayout
    get() = VkImageLayout(VkDescriptorImageInfo.nimageLayout(adr))
    set(value) = VkDescriptorImageInfo.nimageLayout(adr, value.i)


inline var VkDescriptorBufferInfo.buffer: VkBuffer
    get() = VkBuffer(VkDescriptorBufferInfo.nbuffer(adr))
    set(value) = VkDescriptorBufferInfo.nbuffer(adr, value.L)
inline var VkDescriptorBufferInfo.offset: VkDeviceSize
    get() = VkDeviceSize(VkDescriptorBufferInfo.noffset(adr))
    set(value) = VkDescriptorBufferInfo.noffset(adr, value.L)
inline var VkDescriptorBufferInfo.range: VkDeviceSize
    get() = VkDeviceSize(VkDescriptorBufferInfo.nrange(adr))
    set(value) = VkDescriptorBufferInfo.nrange(adr, value.L)


inline var VkWriteDescriptorSet.type: VkStructureType
    get() = VkStructureType(VkWriteDescriptorSet.nsType(adr))
    set(value) = VkWriteDescriptorSet.nsType(adr, value.i)
inline var VkWriteDescriptorSet.next: Ptr
    get() = VkWriteDescriptorSet.npNext(adr)
    set(value) = VkWriteDescriptorSet.npNext(adr, value)
inline var VkWriteDescriptorSet.dstSet: VkDescriptorSet
    get() = VkDescriptorSet(VkWriteDescriptorSet.ndstSet(adr))
    set(value) = VkWriteDescriptorSet.ndstSet(adr, value.L)
inline var VkWriteDescriptorSet.dstBinding: Int
    get() = VkWriteDescriptorSet.ndstBinding(adr)
    set(value) = VkWriteDescriptorSet.ndstBinding(adr, value)
inline var VkWriteDescriptorSet.dstArrayElement: Int
    get() = VkWriteDescriptorSet.ndstArrayElement(adr)
    set(value) = VkWriteDescriptorSet.ndstArrayElement(adr, value)
@Deprecated("this will be set automatically")
inline var VkWriteDescriptorSet.descriptorCount: Int
    get() = VkWriteDescriptorSet.ndescriptorCount(adr)
    set(value) = VkWriteDescriptorSet.ndescriptorCount(adr, value)
inline var VkWriteDescriptorSet.descriptorType: VkDescriptorType
    get() = VkDescriptorType(VkWriteDescriptorSet.ndescriptorType(adr))
    set(value) = VkWriteDescriptorSet.ndescriptorType(adr, value.i)
inline var VkWriteDescriptorSet.imageInfos: VkDescriptorImageInfo.Buffer?
    get() = VkWriteDescriptorSet.npImageInfo(adr)
    set(value) = VkWriteDescriptorSet.npImageInfo(adr, value)
/** JVM custom */
inline var VkWriteDescriptorSet.imageInfo: VkDescriptorImageInfo?
    get() = VkDescriptorImageInfo.createSafe(memGetAddress(adr + VkWriteDescriptorSet.PIMAGEINFO))
    set(value) {
        memPutAddress(adr + VkWriteDescriptorSet.PIMAGEINFO, memAddressSafe(value))
        value?.let { VkWriteDescriptorSet.ndescriptorCount(adr, 1) }
    }
inline var VkWriteDescriptorSet.bufferInfo: VkDescriptorBufferInfo.Buffer?
    get() = VkWriteDescriptorSet.npBufferInfo(adr)
    set(value) = VkWriteDescriptorSet.npBufferInfo(adr, value)
/** JVM custom */
inline var VkWriteDescriptorSet.bufferInfo_: VkDescriptorBufferInfo?
    get() = VkDescriptorBufferInfo.createSafe(memGetAddress(adr + VkWriteDescriptorSet.PBUFFERINFO))
    set(value) {
        memPutAddress(adr + VkWriteDescriptorSet.PBUFFERINFO, memAddressSafe(value))
        value?.let { VkWriteDescriptorSet.ndescriptorCount(adr, 1) }
    }
inline var VkWriteDescriptorSet.texelBufferView: LongBuffer?
    get() = VkWriteDescriptorSet.npTexelBufferView(adr)
    set(value) = VkWriteDescriptorSet.npTexelBufferView(adr, value)


inline var VkCopyDescriptorSet.type: VkStructureType
    get() = VkStructureType(VkCopyDescriptorSet.nsType(adr))
    set(value) = VkCopyDescriptorSet.nsType(adr, value.i)
inline var VkCopyDescriptorSet.next: Long
    get() = VkCopyDescriptorSet.npNext(adr)
    set(value) = VkCopyDescriptorSet.npNext(adr, value)
inline var VkCopyDescriptorSet.srcSet: VkDescriptorSet
    get() = VkDescriptorSet(VkCopyDescriptorSet.nsrcSet(adr))
    set(value) = VkCopyDescriptorSet.nsrcSet(adr, value.L)
inline var VkCopyDescriptorSet.srcBinding: Int
    get() = VkCopyDescriptorSet.nsrcBinding(adr)
    set(value) = VkCopyDescriptorSet.nsrcBinding(adr, value)
inline var VkCopyDescriptorSet.srcArrayElement: Int
    get() = VkCopyDescriptorSet.nsrcArrayElement(adr)
    set(value) = VkCopyDescriptorSet.nsrcArrayElement(adr, value)
inline var VkCopyDescriptorSet.dstSet: VkDescriptorSet
    get() = VkDescriptorSet(VkCopyDescriptorSet.ndstSet(adr))
    set(value) = VkCopyDescriptorSet.ndstSet(adr, value.L)
inline var VkCopyDescriptorSet.dstBinding: Int
    get() = VkCopyDescriptorSet.ndstBinding(adr)
    set(value) = VkCopyDescriptorSet.ndstBinding(adr, value)
inline var VkCopyDescriptorSet.dstArrayElement: Int
    get() = VkCopyDescriptorSet.ndstArrayElement(adr)
    set(value) = VkCopyDescriptorSet.ndstArrayElement(adr, value)
inline var VkCopyDescriptorSet.descriptorCount: Int
    get() = VkCopyDescriptorSet.ndescriptorCount(adr)
    set(value) = VkCopyDescriptorSet.ndescriptorCount(adr, value)


inline var VkFramebufferCreateInfo.type: VkStructureType
    get() = VkStructureType(VkFramebufferCreateInfo.nsType(adr))
    set(value) = VkFramebufferCreateInfo.nsType(adr, value.i)
inline var VkFramebufferCreateInfo.next: Ptr
    get() = VkFramebufferCreateInfo.npNext(adr)
    set(value) = VkFramebufferCreateInfo.npNext(adr, value)
inline var VkFramebufferCreateInfo.flags: VkFramebufferCreateFlags
    get() = VkFramebufferCreateInfo.nflags(adr)
    set(value) = VkFramebufferCreateInfo.nflags(adr, value)
inline var VkFramebufferCreateInfo.renderPass: VkRenderPass
    get() = VkRenderPass(VkFramebufferCreateInfo.nrenderPass(adr))
    set(value) = VkFramebufferCreateInfo.nrenderPass(adr, value.L)
@Deprecated("this will be set automatically")
inline var VkFramebufferCreateInfo.attachmentCount: Int
    get() = VkFramebufferCreateInfo.nattachmentCount(adr)
    set(value) = VkFramebufferCreateInfo.nattachmentCount(adr, value)
inline var VkFramebufferCreateInfo.attachments: VkImageView_Buffer?
    get() = VkFramebufferCreateInfo.npAttachments(adr)?.let(::VkImageView_Buffer)
    set(value) = VkFramebufferCreateInfo.npAttachments(adr, value?.buffer)
/** JVM custom */
inline var VkFramebufferCreateInfo.attachment: VkImageView?
    get() = VkFramebufferCreateInfo.npAttachments(adr)?.let { VkImageView(it[0]) }
    set(value) {
        val p = when (value) {
            null -> NULL
            else -> stackGet().nmalloc(8, Long.BYTES).also { memPutLong(it, value.L) }
        }
        memPutAddress(adr + VkFramebufferCreateInfo.PATTACHMENTS, p)
        attachmentCount = if (value == null) 0 else 1
    }
inline var VkFramebufferCreateInfo.width: Int
    get() = VkFramebufferCreateInfo.nwidth(adr)
    set(value) = VkFramebufferCreateInfo.nwidth(adr, value)
inline var VkFramebufferCreateInfo.height: Int
    get() = VkFramebufferCreateInfo.nheight(adr)
    set(value) = VkFramebufferCreateInfo.nheight(adr, value)
inline var VkFramebufferCreateInfo.layers: Int
    get() = VkFramebufferCreateInfo.nlayers(adr)
    set(value) = VkFramebufferCreateInfo.nlayers(adr, value)
/** JVM custom */
inline var VkFramebufferCreateInfo.extent: Vec3i
    get() = Vec3i(width, height, layers)
    set(value) {
        width = value.x
        height = value.y
        layers = value.z
    }

/** JVM custom */
fun VkFramebufferCreateInfo.extent(extent: Vec2i, layers: Int) {
    width = extent.x
    height = extent.y
    this.layers = layers
}

/** JVM custom */
inline var VkAttachmentDescription.flag: VkAttachmentDescriptionFlag
    get() = throw Exception("Invalid")
    set(value) = VkAttachmentDescription.nflags(adr, value.i)
inline var VkAttachmentDescription.flags: VkAttachmentDescriptionFlags
    get() = VkAttachmentDescription.nflags(adr)
    set(value) = VkAttachmentDescription.nflags(adr, value)
inline var VkAttachmentDescription.format: VkFormat
    get() = VkFormat(VkAttachmentDescription.nformat(adr))
    set(value) = VkAttachmentDescription.nformat(adr, value.i)
inline var VkAttachmentDescription.samples: VkSampleCount
    get() = VkSampleCount(VkSampleCountFlags(VkAttachmentDescription.nsamples(adr)))
    set(value) = VkAttachmentDescription.nsamples(adr, value.i)
inline var VkAttachmentDescription.loadOp: VkAttachmentLoadOp
    get() = VkAttachmentLoadOp(VkAttachmentDescription.nloadOp(adr))
    set(value) = VkAttachmentDescription.nloadOp(adr, value.i)
inline var VkAttachmentDescription.storeOp: VkAttachmentStoreOp
    get() = VkAttachmentStoreOp(VkAttachmentDescription.nstoreOp(adr))
    set(value) = VkAttachmentDescription.nstoreOp(adr, value.i)
inline var VkAttachmentDescription.stencilLoadOp: VkAttachmentLoadOp
    get() = VkAttachmentLoadOp(VkAttachmentDescription.nstencilLoadOp(adr))
    set(value) = VkAttachmentDescription.nstencilLoadOp(adr, value.i)
inline var VkAttachmentDescription.stencilStoreOp: VkAttachmentStoreOp
    get() = VkAttachmentStoreOp(VkAttachmentDescription.nstencilStoreOp(adr))
    set(value) = VkAttachmentDescription.nstencilStoreOp(adr, value.i)
inline var VkAttachmentDescription.initialLayout: VkImageLayout
    get() = VkImageLayout(VkAttachmentDescription.ninitialLayout(adr))
    set(value) = VkAttachmentDescription.ninitialLayout(adr, value.i)
inline var VkAttachmentDescription.finalLayout: VkImageLayout
    get() = VkImageLayout(VkAttachmentDescription.nfinalLayout(adr))
    set(value) = VkAttachmentDescription.nfinalLayout(adr, value.i)


inline var VkAttachmentReference.attachment: Int
    get() = VkAttachmentReference.nattachment(adr)
    set(value) = VkAttachmentReference.nattachment(adr, value)
inline var VkAttachmentReference.layout: VkImageLayout
    get() = VkImageLayout(VkAttachmentReference.nlayout(adr))
    set(value) = VkAttachmentReference.nlayout(adr, value.i)


/** JVM custom */
inline var VkSubpassDescription.flag: VkSubpassDescriptionFlag
    get() = throw Exception("Invalid")
    set(value) = VkSubpassDescription.nflags(adr, value.i)
inline var VkSubpassDescription.flags: VkSubpassDescriptionFlags
    get() = VkSubpassDescription.nflags(adr)
    set(value) = VkSubpassDescription.nflags(adr, value)
inline var VkSubpassDescription.pipelineBindPoint: VkPipelineBindPoint
    get() = VkPipelineBindPoint(VkSubpassDescription.npipelineBindPoint(adr))
    set(value) = VkSubpassDescription.npipelineBindPoint(adr, value.i)
@Deprecated("this will be set automatically")
inline var VkSubpassDescription.inputAttachmentCount: Int
    get() = VkSubpassDescription.ninputAttachmentCount(adr)
    set(value) = VkSubpassDescription.ninputAttachmentCount(adr, value)
inline var VkSubpassDescription.inputAttachments: VkAttachmentReference.Buffer?
    get() = VkSubpassDescription.npInputAttachments(adr)
    set(value) = VkSubpassDescription.npInputAttachments(adr, value)
inline var VkSubpassDescription.colorAttachmentCount: Int
    get() = VkSubpassDescription.ncolorAttachmentCount(adr)
    set(value) = VkSubpassDescription.ncolorAttachmentCount(adr, value)
inline var VkSubpassDescription.colorAttachments: VkAttachmentReference.Buffer?
    get() = VkSubpassDescription.npColorAttachments(adr)
    set(value) = VkSubpassDescription.npColorAttachments(adr, value)
/** JVM custom */
inline var VkSubpassDescription.colorAttachment: VkAttachmentReference?
    get() = VkSubpassDescription.npColorAttachments(adr)?.get(0)
    set(value) = memPutAddress(adr + VkSubpassDescription.PCOLORATTACHMENTS, memAddressSafe(value))
inline var VkSubpassDescription.resolveAttachments: VkAttachmentReference.Buffer?
    get() = VkSubpassDescription.npResolveAttachments(adr)
    set(value) = VkSubpassDescription.npResolveAttachments(adr, value)
inline var VkSubpassDescription.depthStencilAttachment: VkAttachmentReference?
    get() = VkSubpassDescription.npDepthStencilAttachment(adr)
    set(value) = VkSubpassDescription.npDepthStencilAttachment(adr, value)
@Deprecated("this will be set automatically")
inline var VkSubpassDescription.preserveAttachmentCount: Int
    get() = VkSubpassDescription.npreserveAttachmentCount(adr)
    set(value) = VkSubpassDescription.npreserveAttachmentCount(adr, value)
inline var VkSubpassDescription.preserveAttachments: IntBuffer?
    get() = VkSubpassDescription.npPreserveAttachments(adr)
    set(value) = VkSubpassDescription.npPreserveAttachments(adr, value)


inline var VkSubpassDependency.srcSubpass: Int
    get() = VkSubpassDependency.nsrcSubpass(adr)
    set(value) = VkSubpassDependency.nsrcSubpass(adr, value)
inline var VkSubpassDependency.dstSubpass: Int
    get() = VkSubpassDependency.ndstSubpass(adr)
    set(value) = VkSubpassDependency.ndstSubpass(adr, value)
inline var VkSubpassDependency.srcStageMask: VkPipelineStageFlags
    get() = VkSubpassDependency.nsrcStageMask(adr)
    set(value) = VkSubpassDependency.nsrcStageMask(adr, value)
inline var VkSubpassDependency.dstStageMask: VkPipelineStageFlags
    get() = VkSubpassDependency.ndstStageMask(adr)
    set(value) = VkSubpassDependency.ndstStageMask(adr, value)
inline var VkSubpassDependency.srcAccessMask: VkAccessFlags
    get() = VkSubpassDependency.nsrcAccessMask(adr)
    set(value) = VkSubpassDependency.nsrcAccessMask(adr, value)
inline var VkSubpassDependency.dstAccessMask: VkAccessFlags
    get() = VkSubpassDependency.ndstAccessMask(adr)
    set(value) = VkSubpassDependency.ndstAccessMask(adr, value)
inline var VkSubpassDependency.dependencyFlags: VkDependencyFlags
    get() = VkSubpassDependency.ndependencyFlags(adr)
    set(value) = VkSubpassDependency.ndependencyFlags(adr, value)


inline var VkRenderPassCreateInfo.type: VkStructureType
    get() = VkStructureType(VkRenderPassCreateInfo.nsType(adr))
    set(value) = VkRenderPassCreateInfo.nsType(adr, value.i)
inline var VkRenderPassCreateInfo.next: Ptr
    get() = VkRenderPassCreateInfo.npNext(adr)
    set(value) = VkRenderPassCreateInfo.npNext(adr, value)
inline var VkRenderPassCreateInfo.flags: VkRenderPassCreateFlags
    get() = VkRenderPassCreateInfo.nflags(adr)
    set(value) = VkRenderPassCreateInfo.nflags(adr, value)
@Deprecated("this will be set automatically")
inline var VkRenderPassCreateInfo.attachmentCount: Int
    get() = VkRenderPassCreateInfo.nattachmentCount(adr)
    set(value) = VkRenderPassCreateInfo.nattachmentCount(adr, value)
inline var VkRenderPassCreateInfo.attachments: VkAttachmentDescription.Buffer?
    get() = VkRenderPassCreateInfo.npAttachments(adr)
    set(value) = VkRenderPassCreateInfo.npAttachments(adr, value)
/** JVM custom */
inline var VkRenderPassCreateInfo.attachment: VkAttachmentDescription?
    get() = VkRenderPassCreateInfo.npAttachments(adr)?.get(0)
    set(value) {
        memPutAddress(adr + VkRenderPassCreateInfo.PATTACHMENTS, memAddressSafe(value))
        attachmentCount = if (value == null) 0 else 1
    }
@Deprecated("this will be set automatically")
inline var VkRenderPassCreateInfo.subpassCount: Int
    get() = VkRenderPassCreateInfo.nsubpassCount(adr)
    set(value) = VkRenderPassCreateInfo.nsubpassCount(adr, value)
inline var VkRenderPassCreateInfo.subpasses: VkSubpassDescription.Buffer
    get() = VkRenderPassCreateInfo.npSubpasses(adr)
    set(value) = VkRenderPassCreateInfo.npSubpasses(adr, value)
/** JVM custom */
inline var VkRenderPassCreateInfo.subpass: VkSubpassDescription
    get() = VkRenderPassCreateInfo.npSubpasses(adr)[0]
    set(value) {
        memPutAddress(adr + VkRenderPassCreateInfo.PSUBPASSES, value.address())
        subpassCount = 1
    }
@Deprecated("this will be set automatically")
inline var VkRenderPassCreateInfo.dependencyCount: Int
    get() = VkRenderPassCreateInfo.ndependencyCount(adr)
    set(value) = VkRenderPassCreateInfo.ndependencyCount(adr, value)
inline var VkRenderPassCreateInfo.dependencies: VkSubpassDependency.Buffer?
    get() = VkRenderPassCreateInfo.npDependencies(adr)
    set(value) = VkRenderPassCreateInfo.npDependencies(adr, value)
/** JVM custom */
inline var VkRenderPassCreateInfo.dependency: VkSubpassDependency?
    get() = VkRenderPassCreateInfo.npDependencies(adr)?.get(0)
    set(value) {
        memPutAddress(adr + VkRenderPassCreateInfo.PDEPENDENCIES, memAddressSafe(value))
        dependencyCount = if (value == null) 0 else 1
    }


inline var VkCommandPoolCreateInfo.type: VkStructureType
    get() = VkStructureType(VkCommandPoolCreateInfo.nsType(adr))
    set(value) = VkCommandPoolCreateInfo.nsType(adr, value.i)
inline var VkCommandPoolCreateInfo.next: Ptr
    get() = VkCommandPoolCreateInfo.npNext(adr)
    set(value) = VkCommandPoolCreateInfo.npNext(adr, value)
/** JVM custom */
inline var VkCommandPoolCreateInfo.flag: VkCommandPoolCreate
    get() = throw Exception("Invalid")
    set(value) = VkCommandPoolCreateInfo.nflags(adr, value.i)
inline var VkCommandPoolCreateInfo.flags: VkCommandPoolCreateFlags
    get() = VkCommandPoolCreateInfo.nflags(adr)
    set(value) = VkCommandPoolCreateInfo.nflags(adr, value)
inline var VkCommandPoolCreateInfo.queueFamilyIndex: Int
    get() = VkCommandPoolCreateInfo.nqueueFamilyIndex(adr)
    set(value) = VkCommandPoolCreateInfo.nqueueFamilyIndex(adr, value)


inline var VkCommandBufferAllocateInfo.type: VkStructureType
    get() = VkStructureType(VkCommandBufferAllocateInfo.nsType(adr))
    set(value) = VkCommandBufferAllocateInfo.nsType(adr, value.i)
inline var VkCommandBufferAllocateInfo.next: Ptr
    get() = VkCommandBufferAllocateInfo.npNext(adr)
    set(value) = VkCommandBufferAllocateInfo.npNext(adr, value)
inline var VkCommandBufferAllocateInfo.commandPool: VkCommandPool
    get() = VkCommandPool(VkCommandBufferAllocateInfo.ncommandPool(adr))
    set(value) = VkCommandBufferAllocateInfo.ncommandPool(adr, value.L)
inline var VkCommandBufferAllocateInfo.level: VkCommandBufferLevel
    get() = VkCommandBufferLevel(VkCommandBufferAllocateInfo.nlevel(adr))
    set(value) = VkCommandBufferAllocateInfo.nlevel(adr, value.i)
inline var VkCommandBufferAllocateInfo.commandBufferCount: Int
    get() = VkCommandBufferAllocateInfo.ncommandBufferCount(adr)
    set(value) = VkCommandBufferAllocateInfo.ncommandBufferCount(adr, value)


inline var VkCommandBufferInheritanceInfo.type: VkStructureType
    get() = VkStructureType(VkCommandBufferInheritanceInfo.nsType(adr))
    set(value) = VkCommandBufferInheritanceInfo.nsType(adr, value.i)
inline var VkCommandBufferInheritanceInfo.next: Ptr
    get() = VkCommandBufferInheritanceInfo.npNext(adr)
    set(value) = VkCommandBufferInheritanceInfo.npNext(adr, value)
inline var VkCommandBufferInheritanceInfo.renderPass: VkRenderPass
    get() = VkRenderPass(VkCommandBufferInheritanceInfo.nrenderPass(adr))
    set(value) = VkCommandBufferInheritanceInfo.nrenderPass(adr, value.L)
inline var VkCommandBufferInheritanceInfo.subpass: Int
    get() = VkCommandBufferInheritanceInfo.nsubpass(adr)
    set(value) = VkCommandBufferInheritanceInfo.nsubpass(adr, value)
inline var VkCommandBufferInheritanceInfo.framebuffer: VkFramebuffer
    get() = VkFramebuffer(VkCommandBufferInheritanceInfo.nframebuffer(adr))
    set(value) = VkCommandBufferInheritanceInfo.nframebuffer(adr, value.L)
inline var VkCommandBufferInheritanceInfo.occlusionQueryEnable: Boolean
    get() = VkCommandBufferInheritanceInfo.nocclusionQueryEnable(adr).bool
    set(value) = VkCommandBufferInheritanceInfo.nocclusionQueryEnable(adr, value.i)
inline var VkCommandBufferInheritanceInfo.queryFlags: VkQueryControlFlags
    get() = VkCommandBufferInheritanceInfo.nqueryFlags(adr)
    set(value) = VkCommandBufferInheritanceInfo.nqueryFlags(adr, value)
inline var VkCommandBufferInheritanceInfo.pipelineStatistics: VkQueryPipelineStatisticFlags
    get() = VkCommandBufferInheritanceInfo.npipelineStatistics(adr)
    set(value) = VkCommandBufferInheritanceInfo.npipelineStatistics(adr, value)


inline var VkCommandBufferBeginInfo.type: VkStructureType
    get() = VkStructureType(VkCommandBufferBeginInfo.nsType(adr))
    set(value) = VkCommandBufferBeginInfo.nsType(adr, value.i)
inline var VkCommandBufferBeginInfo.next: Ptr
    get() = VkCommandBufferBeginInfo.npNext(adr)
    set(value) = VkCommandBufferBeginInfo.npNext(adr, value)
/** JVM custom */
inline var VkCommandBufferBeginInfo.flag: VkCommandBufferUsage
    get() = TODO()
    set(value) = VkCommandBufferBeginInfo.nflags(adr, value.i)
inline var VkCommandBufferBeginInfo.flags: VkCommandBufferUsageFlags
    get() = VkCommandBufferBeginInfo.nflags(adr)
    set(value) = VkCommandBufferBeginInfo.nflags(adr, value)
inline var VkCommandBufferBeginInfo.inheritanceInfo
    get() = VkCommandBufferBeginInfo.npInheritanceInfo(adr)
    set(value) = VkCommandBufferBeginInfo.npInheritanceInfo(adr, value)


inline var VkBufferCopy.srcOffset: VkDeviceSize
    get() = VkDeviceSize(VkBufferCopy.nsrcOffset(adr))
    set(value) = VkBufferCopy.nsrcOffset(adr, value.L)
inline var VkBufferCopy.dstOffset: VkDeviceSize
    get() = VkDeviceSize(VkBufferCopy.ndstOffset(adr))
    set(value) = VkBufferCopy.ndstOffset(adr, value.L)
inline var VkBufferCopy.size: VkDeviceSize
    get() = VkDeviceSize(VkBufferCopy.nsize(adr))
    set(value) = VkBufferCopy.nsize(adr, value.L)


inline var VkImageSubresourceLayers.aspectMask: VkImageAspectFlags
    get() = VkImageSubresourceLayers.naspectMask(adr)
    set(value) = VkImageSubresourceLayers.naspectMask(adr, value)
inline var VkImageSubresourceLayers.mipLevel: Int
    get() = VkImageSubresourceLayers.nmipLevel(adr)
    set(value) = VkImageSubresourceLayers.nmipLevel(adr, value)
inline var VkImageSubresourceLayers.baseArrayLayer: Int
    get() = VkImageSubresourceLayers.nbaseArrayLayer(adr)
    set(value) = VkImageSubresourceLayers.nbaseArrayLayer(adr, value)
inline var VkImageSubresourceLayers.layerCount: Int
    get() = VkImageSubresourceLayers.nlayerCount(adr)
    set(value) = VkImageSubresourceLayers.nlayerCount(adr, value)


inline var VkImageCopy.srcSubresource: VkImageSubresourceLayers
    get() = VkImageCopy.nsrcSubresource(adr)
    set(value) = VkImageCopy.nsrcSubresource(adr, value)
inline var VkImageCopy.srcOffset: VkOffset3D
    get() = VkImageCopy.nsrcOffset(adr)
    set(value) = VkImageCopy.nsrcOffset(adr, value)
inline var VkImageCopy.dstSubresource: VkImageSubresourceLayers
    get() = VkImageCopy.ndstSubresource(adr)
    set(value) = VkImageCopy.ndstSubresource(adr, value)
inline var VkImageCopy.dstOffset: VkOffset3D
    get() = VkImageCopy.ndstOffset(adr)
    set(value) = VkImageCopy.ndstOffset(adr, value)
inline var VkImageCopy.extent: VkExtent3D
    get() = VkImageCopy.nextent(adr)
    set(value) = VkImageCopy.nextent(adr, value)


inline var VkImageBlit.srcSubresource: VkImageSubresourceLayers
    get() = VkImageBlit.nsrcSubresource(adr)
    set(value) = VkImageBlit.nsrcSubresource(adr, value)
inline var VkImageBlit.srcOffsets: VkOffset3D.Buffer
    get() = VkImageBlit.nsrcOffsets(adr)
    set(value) = VkImageBlit.nsrcOffsets(adr, value)
inline var VkImageBlit.dstSubresource: VkImageSubresourceLayers
    get() = VkImageBlit.ndstSubresource(adr)
    set(value) = VkImageBlit.ndstSubresource(adr, value)
inline var VkImageBlit.dstOffsets: VkOffset3D.Buffer
    get() = VkImageBlit.ndstOffsets(adr)
    set(value) = VkImageBlit.ndstOffsets(adr, value)


inline var VkBufferImageCopy.bufferOffset: VkDeviceSize
    get() = VkDeviceSize(VkBufferImageCopy.nbufferOffset(adr))
    set(value) = VkBufferImageCopy.nbufferOffset(adr, value.L)
inline var VkBufferImageCopy.bufferRowLength: Int
    get() = VkBufferImageCopy.nbufferRowLength(adr)
    set(value) = VkBufferImageCopy.nbufferRowLength(adr, value)
inline var VkBufferImageCopy.bufferImageHeight: Int
    get() = VkBufferImageCopy.nbufferImageHeight(adr)
    set(value) = VkBufferImageCopy.nbufferImageHeight(adr, value)
inline var VkBufferImageCopy.imageSubresource: VkImageSubresourceLayers
    get() = VkBufferImageCopy.nimageSubresource(adr)
    set(value) = VkBufferImageCopy.nimageSubresource(adr, value)
inline var VkBufferImageCopy.imageOffset: VkOffset3D
    get() = VkBufferImageCopy.nimageOffset(adr)
    set(value) = VkBufferImageCopy.nimageOffset(adr, value)

/** JVM custom */
fun VkBufferImageCopy.imageOffset(i: Int) = imageOffset(i, i, i)

/** JVM custom */
fun VkBufferImageCopy.imageOffset(x: Int, y: Int, z: Int) = imageOffset.set(x, y, z)

inline var VkBufferImageCopy.imageExtent: VkExtent3D
    get() = VkBufferImageCopy.nimageExtent(adr)
    set(value) = VkBufferImageCopy.nimageExtent(adr, value)

/** JVM custom */
fun VkBufferImageCopy.imageExtent(width: Int, height: Int, depth: Int) = imageExtent.set(width, height, depth)

/** JVM custom */
fun VkBufferImageCopy.imageExtent(extent: Vec2i, depth: Int) = imageExtent.set(extent.x, extent.y, depth)

/** JVM custom */
fun VkBufferImageCopy.imageExtent(extent: Vec3i) = imageExtent.set(extent.x, extent.y, extent.z)


inline var VkClearColorValue.float32: FloatBuffer
    get() = VkClearColorValue.nfloat32(adr)
    set(value) = VkClearColorValue.nfloat32(adr, value)
inline var VkClearColorValue.int32: IntBuffer
    get() = VkClearColorValue.nint32(adr)
    set(value) = VkClearColorValue.nint32(adr, value)
inline var VkClearColorValue.uint32: IntBuffer
    get() = VkClearColorValue.nuint32(adr)
    set(value) = VkClearColorValue.nuint32(adr, value)


inline var VkClearDepthStencilValue.depth: Float
    get() = VkClearDepthStencilValue.ndepth(adr)
    set(value) = VkClearDepthStencilValue.ndepth(adr, value)
inline var VkClearDepthStencilValue.stencil: Int
    get() = VkClearDepthStencilValue.nstencil(adr)
    set(value) = VkClearDepthStencilValue.nstencil(adr, value)


inline var VkClearValue.color: VkClearColorValue
    get() = VkClearValue.ncolor(adr)
    set(value) = VkClearValue.ncolor(adr, value)
inline var VkClearValue.depthStencil: VkClearDepthStencilValue
    get() = VkClearValue.ndepthStencil(adr)
    set(value) = VkClearValue.ndepthStencil(adr, value)

/** JVM custom  */
fun VkClearValue.color(floats: FloatArray) = color(floats[0], floats[1], floats[2], floats[3])

/** JVM custom  */
fun VkClearValue.color(float: Float) = color(float, float, float, float)

/** JVM custom  */
fun VkClearValue.color(vec: Vec4) = color(vec.r, vec.g, vec.b, vec.a)

/** JVM custom  */
fun VkClearValue.color(r: Float, g: Float, b: Float, a: Float) {
    color.float32().put(0, r).put(1, g).put(2, b).put(3, a)
}

/** JVM Custom */
fun VkClearValue.depthStencil(depth: Float, stencil: Int) {
    depthStencil().set(depth, stencil)
}


inline var VkClearAttachment.aspectMask: VkImageAspectFlags
    get() = VkClearAttachment.naspectMask(adr)
    set(value) = VkClearAttachment.naspectMask(adr, value)
inline var VkClearAttachment.colorAttachment: Int
    get() = VkClearAttachment.ncolorAttachment(adr)
    set(value) = VkClearAttachment.ncolorAttachment(adr, value)
inline var VkClearAttachment.clearValue: VkClearValue
    get() = VkClearAttachment.nclearValue(adr)
    set(value) = VkClearAttachment.nclearValue(adr, value)


inline var VkClearRect.rect: VkRect2D
    get() = VkClearRect.nrect(adr)
    set(value) = VkClearRect.nrect(adr, value)
inline var VkClearRect.baseArrayLayer: Int
    get() = VkClearRect.nbaseArrayLayer(adr)
    set(value) = VkClearRect.nbaseArrayLayer(adr, value)
inline var VkClearRect.layerCount: Int
    get() = VkClearRect.nlayerCount(adr)
    set(value) = VkClearRect.nlayerCount(adr, value)


inline var VkImageResolve.srcSubresource: VkImageSubresourceLayers
    get() = VkImageResolve.nsrcSubresource(adr)
    set(value) = VkImageResolve.nsrcSubresource(adr, value)
inline var VkImageResolve.srcOffset: VkOffset3D
    get() = VkImageResolve.nsrcOffset(adr)
    set(value) = VkImageResolve.nsrcOffset(adr, value)
inline var VkImageResolve.dstSubresource: VkImageSubresourceLayers
    get() = VkImageResolve.ndstSubresource(adr)
    set(value) = VkImageResolve.ndstSubresource(adr, value)
inline var VkImageResolve.dstOffset: VkOffset3D
    get() = VkImageResolve.ndstOffset(adr)
    set(value) = VkImageResolve.ndstOffset(adr, value)
inline var VkImageResolve.extent: VkExtent3D
    get() = VkImageResolve.nextent(adr)
    set(value) = VkImageResolve.nextent(adr, value)


inline var VkMemoryBarrier.type: VkStructureType
    get() = VkStructureType(VkMemoryBarrier.nsType(adr))
    set(value) = VkMemoryBarrier.nsType(adr, value.i)
inline var VkMemoryBarrier.next: Ptr
    get() = VkMemoryBarrier.npNext(adr)
    set(value) = VkMemoryBarrier.npNext(adr, value)
inline var VkMemoryBarrier.srcAccessMask: VkAccessFlags
    get() = VkMemoryBarrier.nsrcAccessMask(adr)
    set(value) = VkMemoryBarrier.nsrcAccessMask(adr, value)
inline var VkMemoryBarrier.dstAccessMask: VkAccessFlags
    get() = VkMemoryBarrier.ndstAccessMask(adr)
    set(value) = VkMemoryBarrier.ndstAccessMask(adr, value)


inline var VkBufferMemoryBarrier.type: VkStructureType
    get() = VkStructureType(VkBufferMemoryBarrier.nsType(adr))
    set(value) = VkBufferMemoryBarrier.nsType(adr, value.i)
inline var VkBufferMemoryBarrier.next: Ptr
    get() = VkBufferMemoryBarrier.npNext(adr)
    set(value) = VkBufferMemoryBarrier.npNext(adr, value)
inline var VkBufferMemoryBarrier.srcAccessMask: VkAccessFlags
    get() = VkBufferMemoryBarrier.nsrcAccessMask(adr)
    set(value) = VkBufferMemoryBarrier.nsrcAccessMask(adr, value)
inline var VkBufferMemoryBarrier.dstAccessMask: VkAccessFlags
    get() = VkBufferMemoryBarrier.ndstAccessMask(adr)
    set(value) = VkBufferMemoryBarrier.ndstAccessMask(adr, value)
inline var VkBufferMemoryBarrier.srcQueueFamilyIndex: Int
    get() = VkBufferMemoryBarrier.nsrcQueueFamilyIndex(adr)
    set(value) = VkBufferMemoryBarrier.nsrcQueueFamilyIndex(adr, value)
inline var VkBufferMemoryBarrier.dstQueueFamilyIndex: Int
    get() = VkBufferMemoryBarrier.ndstQueueFamilyIndex(adr)
    set(value) = VkBufferMemoryBarrier.ndstQueueFamilyIndex(adr, value)
inline var VkBufferMemoryBarrier.buffer: VkBuffer
    get() = VkBuffer(VkBufferMemoryBarrier.nbuffer(adr))
    set(value) = VkBufferMemoryBarrier.nbuffer(adr, value.L)
inline var VkBufferMemoryBarrier.offset: VkDeviceSize
    get() = VkDeviceSize(VkBufferMemoryBarrier.noffset(adr))
    set(value) = VkBufferMemoryBarrier.noffset(adr, value.L)
inline var VkBufferMemoryBarrier.size: VkDeviceSize
    get() = VkDeviceSize(VkBufferMemoryBarrier.nsize(adr))
    set(value) = VkBufferMemoryBarrier.nsize(adr, value.L)


inline var VkImageMemoryBarrier.type: VkStructureType
    get() = VkStructureType(VkImageMemoryBarrier.nsType(adr))
    set(value) = VkImageMemoryBarrier.nsType(adr, value.i)
inline var VkImageMemoryBarrier.next: Ptr
    get() = VkImageMemoryBarrier.npNext(adr)
    set(value) = VkImageMemoryBarrier.npNext(adr, value)
inline var VkImageMemoryBarrier.srcAccessMask: VkAccessFlags
    get() = VkImageMemoryBarrier.nsrcAccessMask(adr)
    set(value) = VkImageMemoryBarrier.nsrcAccessMask(adr, value)
inline var VkImageMemoryBarrier.dstAccessMask: VkAccessFlags
    get() = VkImageMemoryBarrier.ndstAccessMask(adr)
    set(value) = VkImageMemoryBarrier.ndstAccessMask(adr, value)
inline var VkImageMemoryBarrier.oldLayout: VkImageLayout
    get() = VkImageLayout(VkImageMemoryBarrier.noldLayout(adr))
    set(value) = VkImageMemoryBarrier.noldLayout(adr, value.i)
inline var VkImageMemoryBarrier.newLayout: VkImageLayout
    get() = VkImageLayout(VkImageMemoryBarrier.nnewLayout(adr))
    set(value) = VkImageMemoryBarrier.nnewLayout(adr, value.i)
inline var VkImageMemoryBarrier.srcQueueFamilyIndex: Int
    get() = VkImageMemoryBarrier.nsrcQueueFamilyIndex(adr)
    set(value) = VkImageMemoryBarrier.nsrcQueueFamilyIndex(adr, value)
inline var VkImageMemoryBarrier.dstQueueFamilyIndex: Int
    get() = VkImageMemoryBarrier.ndstQueueFamilyIndex(adr)
    set(value) = VkImageMemoryBarrier.ndstQueueFamilyIndex(adr, value)
inline var VkImageMemoryBarrier.image: VkImage
    get() = VkImage(VkImageMemoryBarrier.nimage(adr))
    set(value) = VkImageMemoryBarrier.nimage(adr, value.L)
inline var VkImageMemoryBarrier.subresourceRange: VkImageSubresourceRange
    get() = VkImageMemoryBarrier.nsubresourceRange(adr)
    set(value) = VkImageMemoryBarrier.nsubresourceRange(adr, value)


inline var VkRenderPassBeginInfo.type: VkStructureType
    get() = VkStructureType(VkRenderPassBeginInfo.nsType(adr))
    set(value) = VkRenderPassBeginInfo.nsType(adr, value.i)
inline var VkRenderPassBeginInfo.next: Ptr
    get() = VkRenderPassBeginInfo.npNext(adr)
    set(value) = VkRenderPassBeginInfo.npNext(adr, value)
inline var VkRenderPassBeginInfo.renderPass: VkRenderPass
    get() = VkRenderPass(VkRenderPassBeginInfo.nrenderPass(adr))
    set(value) = VkRenderPassBeginInfo.nrenderPass(adr, value.L)
inline var VkRenderPassBeginInfo.framebuffer: VkFramebuffer
    get() = VkFramebuffer(VkRenderPassBeginInfo.nframebuffer(adr))
    set(value) = VkRenderPassBeginInfo.nframebuffer(adr, value.L)
inline var VkRenderPassBeginInfo.renderArea: VkRect2D
    get() = VkRenderPassBeginInfo.nrenderArea(adr)
    set(value) = VkRenderPassBeginInfo.nrenderArea(adr, value)
@Deprecated("this will be set automatically")
inline var VkRenderPassBeginInfo.clearValueCount: Int
    get() = VkRenderPassBeginInfo.nclearValueCount(adr)
    set(value) = VkRenderPassBeginInfo.nclearValueCount(adr, value)
inline var VkRenderPassBeginInfo.clearValues: VkClearValue.Buffer?
    get() = VkRenderPassBeginInfo.npClearValues(adr)
    set(value) = VkRenderPassBeginInfo.npClearValues(adr, value)
/** JVM custom  */
inline var VkRenderPassBeginInfo.clearValue: VkClearValue?
    get() = VkRenderPassBeginInfo.npClearValues(adr)?.get(0)
    set(value) {
        memPutAddress(adr + VkRenderPassBeginInfo.PCLEARVALUES, value?.adr ?: NULL)
        clearValueCount = if (value == null) 0 else 1
    }

/** JVM custom */
fun VkRenderPassBeginInfo.clearValue(vec4: Vec4) {
    (clearValue ?: VkClearValue.mallocStack().also { clearValue = it }).color(vec4)
    clearValueCount = 1
}


inline var VkDispatchIndirectCommand.x: Int
    get() = VkDispatchIndirectCommand.nx(adr)
    set(value) = VkDispatchIndirectCommand.nx(adr, value)
inline var VkDispatchIndirectCommand.y: Int
    get() = VkDispatchIndirectCommand.ny(adr)
    set(value) = VkDispatchIndirectCommand.ny(adr, value)
inline var VkDispatchIndirectCommand.z: Int
    get() = VkDispatchIndirectCommand.nz(adr)
    set(value) = VkDispatchIndirectCommand.nz(adr, value)


inline var VkDrawIndexedIndirectCommand.indexCount: Int
    get() = VkDrawIndexedIndirectCommand.nindexCount(adr)
    set(value) = VkDrawIndexedIndirectCommand.nindexCount(adr, value)
inline var VkDrawIndexedIndirectCommand.instanceCount: Int
    get() = VkDrawIndexedIndirectCommand.ninstanceCount(adr)
    set(value) = VkDrawIndexedIndirectCommand.ninstanceCount(adr, value)
inline var VkDrawIndexedIndirectCommand.firstIndex: Int
    get() = VkDrawIndexedIndirectCommand.nfirstIndex(adr)
    set(value) = VkDrawIndexedIndirectCommand.nfirstIndex(adr, value)
inline var VkDrawIndexedIndirectCommand.vertexOffset: Int
    get() = VkDrawIndexedIndirectCommand.nvertexOffset(adr)
    set(value) = VkDrawIndexedIndirectCommand.nvertexOffset(adr, value)
inline var VkDrawIndexedIndirectCommand.firstInstance: Int
    get() = VkDrawIndexedIndirectCommand.nfirstInstance(adr)
    set(value) = VkDrawIndexedIndirectCommand.nfirstInstance(adr, value)


inline var VkDrawIndirectCommand.vertexCount: Int
    get() = VkDrawIndirectCommand.nvertexCount(adr)
    set(value) = VkDrawIndirectCommand.nvertexCount(adr, value)
inline var VkDrawIndirectCommand.instanceCount: Int
    get() = VkDrawIndirectCommand.ninstanceCount(adr)
    set(value) = VkDrawIndirectCommand.ninstanceCount(adr, value)
inline var VkDrawIndirectCommand.firstVertex: Int
    get() = VkDrawIndirectCommand.nfirstVertex(adr)
    set(value) = VkDrawIndirectCommand.nfirstVertex(adr, value)
inline var VkDrawIndirectCommand.firstInstance: Int
    get() = VkDrawIndirectCommand.nfirstInstance(adr)
    set(value) = VkDrawIndirectCommand.nfirstInstance(adr, value)


inline var VkBaseOutStructure.type: VkStructureType
    get() = VkStructureType(VkBaseOutStructure.nsType(adr))
    set(value) = VkBaseOutStructure.nsType(adr, value.i)
inline var VkBaseOutStructure.next: VkBaseOutStructure?
    get() = VkBaseOutStructure.npNext(adr)
    set(value) = VkBaseOutStructure.npNext(adr, value)


inline var VkBaseInStructure.type: VkStructureType
    get() = VkStructureType(VkBaseInStructure.nsType(adr))
    set(value) = VkBaseInStructure.nsType(adr, value.i)
inline var VkBaseInStructure.next: VkBaseInStructure?
    get() = VkBaseInStructure.npNext(adr)
    set(value) = VkBaseInStructure.npNext(adr, value)


inline class VkPointClippingBehavior(val i: Int) {
    companion object {
        val ALL_CLIP_PLANES = VkPointClippingBehavior(0)
        val USER_CLIP_PLANES_ONLY = VkPointClippingBehavior(1)
        val ALL_CLIP_PLANES_KHR = VkPointClippingBehavior.ALL_CLIP_PLANES
        val USER_CLIP_PLANES_ONLY_KHR = VkPointClippingBehavior.USER_CLIP_PLANES_ONLY
    }
}

inline class VkTessellationDomainOrigin(val i: Int) {
    companion object {
        val UPPER_LEFT = VkTessellationDomainOrigin(0)
        val LOWER_LEFT = VkTessellationDomainOrigin(1)
        val UPPER_LEFT_KHR = VkTessellationDomainOrigin.UPPER_LEFT
        val LOWER_LEFT_KHR = VkTessellationDomainOrigin.LOWER_LEFT
    }
}

inline class VkSamplerYcbcrModelConversion(val i: Int) {
    companion object {
        val RGB_IDENTITY = VkSamplerYcbcrModelConversion(0)
        val YCBCR_IDENTITY = VkSamplerYcbcrModelConversion(1)
        val YCBCR_709 = VkSamplerYcbcrModelConversion(2)
        val YCBCR_601 = VkSamplerYcbcrModelConversion(3)
        val YCBCR_2020 = VkSamplerYcbcrModelConversion(4)
        val RGB_IDENTITY_KHR = VkSamplerYcbcrModelConversion.RGB_IDENTITY
        val YCBCR_IDENTITY_KHR = VkSamplerYcbcrModelConversion.YCBCR_IDENTITY
        val YCBCR_709_KHR = VkSamplerYcbcrModelConversion.YCBCR_709
        val YCBCR_601_KHR = VkSamplerYcbcrModelConversion.YCBCR_601
        val YCBCR_2020_KHR = VkSamplerYcbcrModelConversion.YCBCR_2020
    }
}

inline class VkSamplerYcbcrRange(val i: Int) {
    companion object {
        val ITU_FULL = VkSamplerYcbcrRange(0)
        val ITU_NARROW = VkSamplerYcbcrRange(1)
        val ITU_FULL_KHR = VkSamplerYcbcrRange(0)
        val ITU_NARROW_KHR = VkSamplerYcbcrRange(1)
    }
}

inline class VkChromaLocation(val i: Int) {
    companion object {
        val COSITED_EVEN = VkChromaLocation(0)
        val MIDPOINT = VkChromaLocation(1)
        val COSITED_EVEN_KHR = VkChromaLocation(0)
        val MIDPOINT_KHR = VkChromaLocation(1)
    }
}

inline class VkDescriptorUpdateTemplateType(val i: Int) {
    companion object {
        val DESCRIPTOR_SET = VkDescriptorUpdateTemplateType(0)
        val PUSH_DESCRIPTORS_KHR = VkDescriptorUpdateTemplateType(1)
        val DESCRIPTOR_SET_KHR = VkDescriptorUpdateTemplateType.DESCRIPTOR_SET
    }
}


inline class VkSubgroupFeature(val i: Int) {
    companion object {
        val BASIC_BIT = VkSubgroupFeature(0x00000001)
        val VOTE_BIT = VkSubgroupFeature(0x00000002)
        val ARITHMETIC_BIT = VkSubgroupFeature(0x00000004)
        val BALLOT_BIT = VkSubgroupFeature(0x00000008)
        val SHUFFLE_BIT = VkSubgroupFeature(0x00000010)
        val SHUFFLE_RELATIVE_BIT = VkSubgroupFeature(0x00000020)
        val CLUSTERED_BIT = VkSubgroupFeature(0x00000040)
        val QUAD_BIT = VkSubgroupFeature(0x00000080)
        val PARTITIONED_BIT_NV = VkSubgroupFeature(0x00000100)
    }
}

typealias VkSubgroupFeatureFlags = VkFlags

inline class VkPeerMemoryFeature(val i: Int) {
    companion object {
        val COPY_SRC_BIT = VkPeerMemoryFeature(0x00000001)
        val COPY_DST_BIT = VkPeerMemoryFeature(0x00000002)
        val GENERIC_SRC_BIT = VkPeerMemoryFeature(0x00000004)
        val GENERIC_DST_BIT = VkPeerMemoryFeature(0x00000008)
        val COPY_SRC_BIT_KHR = VkPeerMemoryFeature(0x00000001)
        val COPY_DST_BIT_KHR = VkPeerMemoryFeature(0x00000002)
        val GENERIC_SRC_BIT_KHR = VkPeerMemoryFeature(0x00000004)
        val GENERIC_DST_BIT_KHR = VkPeerMemoryFeature(0x00000008)
    }
}

typealias VkPeerMemoryFeatureFlags = VkFlags

inline class VkMemoryAllocate(val i: Int) {
    companion object {
        val DEVICE_MASK_BIT = VkMemoryAllocate(0x00000001)
    }
}

typealias VkMemoryAllocateFlags = VkFlags
typealias VkCommandPoolTrimFlags = VkFlags
typealias VkDescriptorUpdateTemplateCreateFlags = VkFlags

inline class VkExternalMemoryHandleType(val i: Int) {
    companion object {
        val OPAQUE_FD_BIT = VkExternalMemoryHandleType(0x00000001)
        val OPAQUE_WIN32_BIT = VkExternalMemoryHandleType(0x00000002)
        val OPAQUE_WIN32_KMT_BIT = VkExternalMemoryHandleType(0x00000004)
        val D3D11_TEXTURE_BIT = VkExternalMemoryHandleType(0x00000008)
        val D3D11_TEXTURE_KMT_BIT = VkExternalMemoryHandleType(0x00000010)
        val D3D12_HEAP_BIT = VkExternalMemoryHandleType(0x00000020)
        val D3D12_RESOURCE_BIT = VkExternalMemoryHandleType(0x00000040)
        val DMA_BUF_BIT_EXT = VkExternalMemoryHandleType(0x00000200)
        val ANDROID_HARDWARE_BUFFER_BIT_ANDROID = VkExternalMemoryHandleType(0x00000400)
        val HOST_ALLOCATION_BIT_EXT = VkExternalMemoryHandleType(0x00000080)
        val HOST_MAPPED_FOREIGN_MEMORY_BIT_EXT = VkExternalMemoryHandleType(0x00000100)
        val OPAQUE_FD_BIT_KHR = VkExternalMemoryHandleType.OPAQUE_FD_BIT
        val OPAQUE_WIN32_BIT_KHR = VkExternalMemoryHandleType.OPAQUE_WIN32_BIT
        val OPAQUE_WIN32_KMT_BIT_KHR = VkExternalMemoryHandleType.OPAQUE_WIN32_KMT_BIT
        val D3D11_TEXTURE_BIT_KHR = VkExternalMemoryHandleType.D3D11_TEXTURE_BIT
        val D3D11_TEXTURE_KMT_BIT_KHR = VkExternalMemoryHandleType.D3D11_TEXTURE_KMT_BIT
        val D3D12_HEAP_BIT_KHR = VkExternalMemoryHandleType.D3D12_HEAP_BIT
        val D3D12_RESOURCE_BIT_KHR = VkExternalMemoryHandleType.D3D12_RESOURCE_BIT
    }
}

typealias VkExternalMemoryHandleTypeFlags = VkFlags

inline class VkExternalMemoryFeature(val i: Int) {
    companion object {
        val DEDICATED_ONLY_BIT = VkExternalMemoryFeature(0x00000001)
        val EXPORTABLE_BIT = VkExternalMemoryFeature(0x00000002)
        val IMPORTABLE_BIT = VkExternalMemoryFeature(0x00000004)
        val DEDICATED_ONLY_BIT_KHR = VkExternalMemoryFeature.DEDICATED_ONLY_BIT
        val EXPORTABLE_BIT_KHR = VkExternalMemoryFeature.EXPORTABLE_BIT
        val IMPORTABLE_BIT_KHR = VkExternalMemoryFeature.IMPORTABLE_BIT
    }
}

typealias VkExternalMemoryFeatureFlags = VkFlags

inline class VkExternalFenceHandleType(val i: Int) {
    companion object {
        val OPAQUE_FD_BIT = VkExternalFenceHandleType(0x00000001)
        val OPAQUE_WIN32_BIT = VkExternalFenceHandleType(0x00000002)
        val OPAQUE_WIN32_KMT_BIT = VkExternalFenceHandleType(0x00000004)
        val SYNC_FD_BIT = VkExternalFenceHandleType(0x00000008)
        val OPAQUE_FD_BIT_KHR = VkExternalFenceHandleType.OPAQUE_FD_BIT
        val OPAQUE_WIN32_BIT_KHR = VkExternalFenceHandleType.OPAQUE_WIN32_BIT
        val OPAQUE_WIN32_KMT_BIT_KHR = VkExternalFenceHandleType.OPAQUE_WIN32_KMT_BIT
        val SYNC_FD_BIT_KHR = VkExternalFenceHandleType.SYNC_FD_BIT
    }
}

typealias VkExternalFenceHandleTypeFlags = VkFlags

inline class VkExternalFenceFeature(val i: Int) {
    companion object {
        val EXPORTABLE_BIT = VkExternalFenceFeature(0x00000001)
        val IMPORTABLE_BIT = VkExternalFenceFeature(0x00000002)
        val EXPORTABLE_BIT_KHR = VkExternalFenceFeature.EXPORTABLE_BIT
        val IMPORTABLE_BIT_KHR = VkExternalFenceFeature.IMPORTABLE_BIT
    }
}

typealias VkExternalFenceFeatureFlags = VkFlags

inline class VkFenceImport(val i: Int) {
    companion object {
        val TEMPORARY_BIT = VkFenceImport(0x00000001)
        val TEMPORARY_BIT_KHR = VkFenceImport.TEMPORARY_BIT
    }
}

typealias VkFenceImportFlags = VkFlags

inline class VkSemaphoreImport(val i: Int) {
    companion object {
        val TEMPORARY_BIT = VkSemaphoreImport(0x00000001)
        val TEMPORARY_BIT_KHR = VkSemaphoreImport.TEMPORARY_BIT
    }
}

typealias VkSemaphoreImportFlags = VkFlags