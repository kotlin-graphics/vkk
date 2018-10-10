package vkk

import glm_.BYTES
import glm_.bool
import glm_.i
import glm_.vec2.Vec2i
import glm_.vec3.Vec3i
import glm_.vec4.Vec4
import kool.Ptr
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.vulkan.*
import java.nio.IntBuffer


inline var VkWriteDescriptorSet.type: VkStructureType
    get() = VkStructureType of VkWriteDescriptorSet.nsType(adr)
    set(value) = VkWriteDescriptorSet.nsType(adr, value.i)
inline var VkWriteDescriptorSet.next: Ptr
    get() = VkWriteDescriptorSet.npNext(adr)
    set(value) = VkWriteDescriptorSet.npNext(adr, value)
inline var VkWriteDescriptorSet.dstSet: VkDescriptorSet
    get() = VkDescriptorSet(VkWriteDescriptorSet.ndstSet(adr))
    set(value) = VkWriteDescriptorSet.ndstSet(adr, value.L)
inline var VkWriteDescriptorSet.dstBinding
    get() = VkWriteDescriptorSet.ndstBinding(adr)
    set(value) = VkWriteDescriptorSet.ndstBinding(adr, value)
inline var VkWriteDescriptorSet.dstArrayElement
    get() = VkWriteDescriptorSet.ndstArrayElement(adr)
    set(value) = VkWriteDescriptorSet.ndstArrayElement(adr, value)
//inline val VkWriteDescriptorSet.descriptorCount get() = VkWriteDescriptorSet.ndescriptorCount(adr)
inline var VkWriteDescriptorSet.descriptorType: VkDescriptorType
    get() = VkDescriptorType of VkWriteDescriptorSet.ndescriptorType(adr)
    set(value) = VkWriteDescriptorSet.ndescriptorType(adr, value.i)
inline var VkWriteDescriptorSet.imageInfo: VkDescriptorImageInfo.Buffer?
    get() = VkWriteDescriptorSet.npImageInfo(adr)
    set(value) = VkWriteDescriptorSet.npImageInfo(adr, value)
/** JVM custom */
inline var VkWriteDescriptorSet.imageInfo_: VkDescriptorImageInfo?
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
inline var VkWriteDescriptorSet.texelBufferView
    get() = VkWriteDescriptorSet.npTexelBufferView(adr)
    set(value) = VkWriteDescriptorSet.npTexelBufferView(adr, value)


//typedef struct VkCopyDescriptorSet {
//    VkStructureType    sType;
//    const void*        pNext;
//    VkDescriptorSet    srcSet;
//    uint32_t           srcBinding;
//    uint32_t           srcArrayElement;
//    VkDescriptorSet    dstSet;
//    uint32_t           dstBinding;
//    uint32_t           dstArrayElement;
//    uint32_t           descriptorCount;
//} VkCopyDescriptorSet;


inline var VkFramebufferCreateInfo.type: VkStructureType
    get() = VkStructureType of VkFramebufferCreateInfo.nsType(adr)
    set(value) = VkFramebufferCreateInfo.nsType(adr, value.i)
inline var VkFramebufferCreateInfo.next
    get() = VkFramebufferCreateInfo.npNext(adr)
    set(value) = VkFramebufferCreateInfo.npNext(adr, value)
inline var VkFramebufferCreateInfo.flags: VkFramebufferCreateFlags
    get() = VkFramebufferCreateInfo.nflags(adr)
    set(value) = VkFramebufferCreateInfo.nflags(adr, value)
inline var VkFramebufferCreateInfo.renderPass: VkRenderPass
    get() = VkRenderPass(VkFramebufferCreateInfo.nrenderPass(adr))
    set(value) = VkFramebufferCreateInfo.nrenderPass(adr, value.L)
//inline val VkFramebufferCreateInfo.attachmentCount get() = attachmentCount()
inline var VkFramebufferCreateInfo.attachments: VkImageViewBuffer?
    get() = VkFramebufferCreateInfo.npAttachments(adr)?.let(::VkImageViewBuffer)
    set(value) = VkFramebufferCreateInfo.npAttachments(adr, value?.buffer)
/** JVM custom */
inline var VkFramebufferCreateInfo.attachment: VkImageView?
    get() = VkFramebufferCreateInfo.npAttachments(adr)?.let { VkImageView(it[0]) }
    set(value) = when (value) {
        null -> {
            memPutAddress(adr + VkFramebufferCreateInfo.PATTACHMENTS, NULL)
            VkFramebufferCreateInfo.nattachmentCount(adr, 0)
        }
        else -> longAddressStack(value.L) {
            memPutAddress(adr + VkFramebufferCreateInfo.PATTACHMENTS, it)
            memPutInt(adr + VkFramebufferCreateInfo.ATTACHMENTCOUNT, 1)
        }
    }
inline var VkFramebufferCreateInfo.width
    get() = VkFramebufferCreateInfo.nwidth(adr)
    set(value) = VkFramebufferCreateInfo.nwidth(adr, value)
inline var VkFramebufferCreateInfo.height
    get() = VkFramebufferCreateInfo.nheight(adr)
    set(value) = VkFramebufferCreateInfo.nheight(adr, value)
inline var VkFramebufferCreateInfo.layers
    get() = VkFramebufferCreateInfo.nlayers(adr)
    set(value) = VkFramebufferCreateInfo.nlayers(adr, value)

fun VkFramebufferCreateInfo.extent(extent: Vec2i, layers: Int) {
    width = extent.x
    height = extent.y
    this.layers = layers
}

/** JVM custom */
inline var VkAttachmentDescription.flag: VkAttachmentDescriptionFlag
    get() = TODO()
    set(value) = VkAttachmentDescription.nflags(adr, value.i)
inline var VkAttachmentDescription.flags: VkAttachmentDescriptionFlags
    get() = VkAttachmentDescription.nflags(adr)
    set(value) = VkAttachmentDescription.nflags(adr, value)
inline var VkAttachmentDescription.format: VkFormat
    get() = VkFormat of VkAttachmentDescription.nformat(adr)
    set(value) = VkAttachmentDescription.nformat(adr, value.i)
inline var VkAttachmentDescription.samples: VkSampleCount
    get() = VkSampleCount of VkAttachmentDescription.nsamples(adr)
    set(value) = VkAttachmentDescription.nsamples(adr, value.i)
inline var VkAttachmentDescription.loadOp: VkAttachmentLoadOp
    get() = VkAttachmentLoadOp of VkAttachmentDescription.nloadOp(adr)
    set(value) = VkAttachmentDescription.nloadOp(adr, value.i)
inline var VkAttachmentDescription.storeOp: VkAttachmentStoreOp
    get() = VkAttachmentStoreOp of VkAttachmentDescription.nstoreOp(adr)
    set(value) = VkAttachmentDescription.nstoreOp(adr, value.i)
inline var VkAttachmentDescription.stencilLoadOp: VkAttachmentLoadOp
    get() = VkAttachmentLoadOp of VkAttachmentDescription.nstencilLoadOp(adr)
    set(value) = VkAttachmentDescription.nstencilLoadOp(adr, value.i)
inline var VkAttachmentDescription.stencilStoreOp: VkAttachmentStoreOp
    get() = VkAttachmentStoreOp of VkAttachmentDescription.nstencilStoreOp(adr)
    set(value) = VkAttachmentDescription.nstencilStoreOp(adr, value.i)
inline var VkAttachmentDescription.initialLayout: VkImageLayout
    get() = VkImageLayout of VkAttachmentDescription.ninitialLayout(adr)
    set(value) = VkAttachmentDescription.ninitialLayout(adr, value.i)
inline var VkAttachmentDescription.finalLayout: VkImageLayout
    get() = VkImageLayout of VkAttachmentDescription.nfinalLayout(adr)
    set(value) = VkAttachmentDescription.nfinalLayout(adr, value.i)


inline var VkAttachmentReference.attachment
    get() = VkAttachmentReference.nattachment(adr)
    set(value) = VkAttachmentReference.nattachment(adr, value)
inline var VkAttachmentReference.layout: VkImageLayout
    get() = VkImageLayout of VkAttachmentReference.nlayout(adr)
    set(value) = VkAttachmentReference.nlayout(adr, value.i)


/** JVM custom */
inline var VkSubpassDescription.flag: VkSubpassDescriptionFlag
    get() = TODO()
    set(value) = VkSubpassDescription.nflags(adr, value.i)
inline var VkSubpassDescription.flags: VkSubpassDescriptionFlags
    get() = VkSubpassDescription.nflags(adr)
    set(value) = VkSubpassDescription.nflags(adr, value)
inline var VkSubpassDescription.pipelineBindPoint: VkPipelineBindPoint
    get() = VkPipelineBindPoint of VkSubpassDescription.npipelineBindPoint(adr)
    set(value) = VkSubpassDescription.npipelineBindPoint(adr, value.i)
//inline val VkSubpassDescription.inputAttachmentCount get() = VkSubpassDescription.ninputAttachmentCount(adr)
inline var VkSubpassDescription.inputAttachments
    get() = VkSubpassDescription.npInputAttachments(adr)
    set(value) = VkSubpassDescription.npInputAttachments(adr, value)
inline var VkSubpassDescription.colorAttachmentCount
    get() = VkSubpassDescription.ncolorAttachmentCount(adr)
    set(value) = VkSubpassDescription.ncolorAttachmentCount(adr, value)
inline var VkSubpassDescription.colorAttachments: VkAttachmentReference.Buffer?
    get() = VkSubpassDescription.npColorAttachments(adr)
    set(value) = VkSubpassDescription.npColorAttachments(adr, value)
/** JVM custom */
inline var VkSubpassDescription.colorAttachment: VkAttachmentReference?
    get() = VkSubpassDescription.npColorAttachments(adr)?.get(0)
    set(value) = memPutAddress(adr + VkSubpassDescription.PCOLORATTACHMENTS, memAddressSafe(value))
inline var VkSubpassDescription.resolveAttachments
    get() = VkSubpassDescription.npResolveAttachments(adr)
    set(value) = VkSubpassDescription.npResolveAttachments(adr, value)
inline var VkSubpassDescription.depthStencilAttachment
    get() = VkSubpassDescription.npDepthStencilAttachment(adr)
    set(value) = VkSubpassDescription.npDepthStencilAttachment(adr, value)
//inline val VkSubpassDescription.preserveAttachmentCount get() = VkSubpassDescription.npreserveAttachmentCount(adr)
inline var VkSubpassDescription.preserveAttachments
    get() = VkSubpassDescription.npPreserveAttachments(adr)
    set(value) = VkSubpassDescription.npPreserveAttachments(adr, value)


inline var VkSubpassDependency.srcSubpass
    get() = VkSubpassDependency.nsrcSubpass(adr)
    set(value) = VkSubpassDependency.nsrcSubpass(adr, value)
inline var VkSubpassDependency.dstSubpass
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
    get() = VkStructureType of VkRenderPassCreateInfo.nsType(adr)
    set(value) = VkRenderPassCreateInfo.nsType(adr, value.i)
inline var VkRenderPassCreateInfo.next
    get() = VkRenderPassCreateInfo.npNext(adr)
    set(value) = VkRenderPassCreateInfo.npNext(adr, value)
inline var VkRenderPassCreateInfo.flags: VkRenderPassCreateFlags
    get() = VkRenderPassCreateInfo.nflags(adr)
    set(value) = VkRenderPassCreateInfo.nflags(adr, value)
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
        VkRenderPassCreateInfo.nattachmentCount(adr, if (value == null) 0 else 1)
    }
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
        VkRenderPassCreateInfo.nsubpassCount(adr, 1)
    }
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
        VkRenderPassCreateInfo.ndependencyCount(adr, if (value == null) 0 else 1)
    }


inline var VkCommandPoolCreateInfo.type: VkStructureType
    get() = VkStructureType of VkCommandPoolCreateInfo.nsType(adr)
    set(value) = VkCommandPoolCreateInfo.nsType(adr, value.i)
inline var VkCommandPoolCreateInfo.next
    get() = VkCommandPoolCreateInfo.npNext(adr)
    set(value) = VkCommandPoolCreateInfo.npNext(adr, value)
/** JVM custom */
inline var VkCommandPoolCreateInfo.flag: VkCommandPoolCreate
    get() = TODO()
    set(value) = VkCommandPoolCreateInfo.nflags(adr, value.i)
inline var VkCommandPoolCreateInfo.flags: VkCommandPoolCreateFlags
    get() = VkCommandPoolCreateInfo.nflags(adr)
    set(value) = VkCommandPoolCreateInfo.nflags(adr, value)
inline var VkCommandPoolCreateInfo.queueFamilyIndex
    get() = VkCommandPoolCreateInfo.nqueueFamilyIndex(adr)
    set(value) = VkCommandPoolCreateInfo.nqueueFamilyIndex(adr, value)

//typedef struct VkCommandPoolCreateInfo {
//    VkStructureType             sType;
//    const void*                 pNext;
//    VkCommandPoolCreateFlags    flags;
//    uint32_t                    queueFamilyIndex;
//} VkCommandPoolCreateInfo;

inline var VkCommandBufferAllocateInfo.type: VkStructureType
    get() = VkStructureType of VkCommandBufferAllocateInfo.nsType(adr)
    set(value) = VkCommandBufferAllocateInfo.nsType(adr, value.i)
var VkCommandBufferAllocateInfo.next
    get() = VkCommandBufferAllocateInfo.npNext(adr)
    set(value) = VkCommandBufferAllocateInfo.npNext(adr, value)
var VkCommandBufferAllocateInfo.commandPool: VkCommandPool
    get() = VkCommandPool(VkCommandBufferAllocateInfo.ncommandPool(adr))
    set(value) = VkCommandBufferAllocateInfo.ncommandPool(adr, value.L)
var VkCommandBufferAllocateInfo.level: VkCommandBufferLevel
    get() = VkCommandBufferLevel of VkCommandBufferAllocateInfo.nlevel(adr)
    set(value) = VkCommandBufferAllocateInfo.nlevel(adr, value.i)
var VkCommandBufferAllocateInfo.commandBufferCount
    get() = VkCommandBufferAllocateInfo.ncommandBufferCount(adr)
    set(value) = VkCommandBufferAllocateInfo.ncommandBufferCount(adr, value)


//typedef struct VkCommandBufferAllocateInfo {
//    VkStructureType         sType;
//    const void*             pNext;
//    VkCommandPool           commandPool;
//    VkCommandBufferLevel    level;
//    uint32_t                commandBufferCount;
//} VkCommandBufferAllocateInfo;
//
//typedef struct VkCommandBufferInheritanceInfo {
//    VkStructureType                  sType;
//    const void*                      pNext;
//    VkRenderPass                     renderPass;
//    uint32_t                         subpass;
//    VkFramebuffer                    framebuffer;
//    VkBool32                         occlusionQueryEnable;
//    VkQueryControlFlags              queryFlags;
//    VkQueryPipelineStatisticFlags    pipelineStatistics;
//} VkCommandBufferInheritanceInfo;
//

inline var VkCommandBufferBeginInfo.type: VkStructureType
    get() = VkStructureType of VkCommandBufferBeginInfo.nsType(adr)
    set(value) = VkCommandBufferBeginInfo.nsType(adr, value.i)
inline var VkCommandBufferBeginInfo.next
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

inline var VkBufferCopy.Buffer.size: VkDeviceSize // TODO remove all .Buffer fields?
    get() = VkDeviceSize(size())
    set(value) {
        size(value.L)
    }


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
inline var VkBufferImageCopy.imageExtent: VkExtent3D
    get() = VkBufferImageCopy.nimageExtent(adr)
    set(value) = VkBufferImageCopy.nimageExtent(adr, value)

/** JVM custom */
fun VkBufferImageCopy.imageExtent(extent: Vec2i, depth: Int) {
    imageExtent.apply {
        width = extent.x
        height = extent.y
        this.depth = depth
    }
}

/** JVM custom */
fun VkBufferImageCopy.imageExtent(extent: Vec3i) {
    this.imageExtent.set(extent.x, extent.y, extent.z)
}

//typedef union VkClearColorValue {
//    float       float32[4];
//    int32_t     int32[4];
//    uint32_t    uint32[4];
//} VkClearColorValue;
//
//typedef struct VkClearDepthStencilValue {
//    float       depth;
//    uint32_t    stencil;
//} VkClearDepthStencilValue;

inline var VkClearValue.color: VkClearColorValue
    get() = VkClearValue.ncolor(adr)
    set(value) = VkClearValue.ncolor(adr, value)
inline var VkClearValue.depthStencil: VkClearDepthStencilValue
    get() = VkClearValue.ndepthStencil(adr)
    set(value) = VkClearValue.ndepthStencil(adr, value)

fun VkClearValue.color(float: Float) = color(float, float, float, float)
fun VkClearValue.color(color: Vec4) = color(color.r, color.g, color.b, color.a)
fun VkClearValue.color(r: Float, g: Float, b: Float, a: Float) {
    memPutFloat(adr, r)
    memPutFloat(adr + Float.BYTES, g)
    memPutFloat(adr + Float.BYTES * 2, b)
    memPutFloat(adr + Float.BYTES * 3, a)
}


fun VkClearValue.depthStencil(depth: Float, stencil: Int) {
    memPutFloat(adr, depth)
    memPutInt(adr + Float.BYTES, stencil)
}

//typedef union VkClearValue {
//    VkClearColorValue           color;
//    VkClearDepthStencilValue    depthStencil;
//} VkClearValue;

//typedef struct VkClearAttachment {
//    VkImageAspectFlags    aspectMask;
//    uint32_t              colorAttachment;
//    VkClearValue          clearValue;
//} VkClearAttachment;
//
//typedef struct VkClearRect {
//    VkRect2D    rect;
//    uint32_t    baseArrayLayer;
//    uint32_t    layerCount;
//} VkClearRect;
//
//typedef struct VkImageResolve {
//    VkImageSubresourceLayers    srcSubresource;
//    VkOffset3D                  srcOffset;
//    VkImageSubresourceLayers    dstSubresource;
//    VkOffset3D                  dstOffset;
//    VkExtent3D                  extent;
//} VkImageResolve;
//
//typedef struct VkMemoryBarrier {
//    VkStructureType    sType;
//    const void*        pNext;
//    VkAccessFlags      srcAccessMask;
//    VkAccessFlags      dstAccessMask;
//} VkMemoryBarrier;

inline var VkBufferMemoryBarrier.type: VkStructureType
    get() = VkStructureType of VkBufferMemoryBarrier.nsType(adr)
    set(value) = VkBufferMemoryBarrier.nsType(adr, value.i)
inline var VkBufferMemoryBarrier.next: Long
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
    get() = VkStructureType of VkImageMemoryBarrier.nsType(adr)
    set(value) = VkImageMemoryBarrier.nsType(adr, value.i)
inline var VkImageMemoryBarrier.next
    get() = VkImageMemoryBarrier.npNext(adr)
    set(value) = VkImageMemoryBarrier.npNext(adr, value)
inline var VkImageMemoryBarrier.srcAccessMask: VkAccessFlags
    get() = VkImageMemoryBarrier.nsrcAccessMask(adr)
    set(value) = VkImageMemoryBarrier.nsrcAccessMask(adr, value)
inline var VkImageMemoryBarrier.dstAccessMask: VkAccessFlags
    get() = VkImageMemoryBarrier.ndstAccessMask(adr)
    set(value) = VkImageMemoryBarrier.ndstAccessMask(adr, value)
inline var VkImageMemoryBarrier.oldLayout: VkImageLayout
    get() = VkImageLayout of VkImageMemoryBarrier.noldLayout(adr)
    set(value) = VkImageMemoryBarrier.noldLayout(adr, value.i)
inline var VkImageMemoryBarrier.newLayout: VkImageLayout
    get() = VkImageLayout of VkImageMemoryBarrier.nnewLayout(adr)
    set(value) = VkImageMemoryBarrier.nnewLayout(adr, value.i)
inline var VkImageMemoryBarrier.srcQueueFamilyIndex
    get() = VkImageMemoryBarrier.nsrcQueueFamilyIndex(adr)
    set(value) = VkImageMemoryBarrier.nsrcQueueFamilyIndex(adr, value)
inline var VkImageMemoryBarrier.dstQueueFamilyIndex
    get() = VkImageMemoryBarrier.ndstQueueFamilyIndex(adr)
    set(value) = VkImageMemoryBarrier.ndstQueueFamilyIndex(adr, value)
inline var VkImageMemoryBarrier.image: VkImage
    get() = VkImage(VkImageMemoryBarrier.nimage(adr))
    set(value) = VkImageMemoryBarrier.nimage(adr, value.L)
inline var VkImageMemoryBarrier.subresourceRange: VkImageSubresourceRange
    get() = VkImageMemoryBarrier.nsubresourceRange(adr)
    set(value) = VkImageMemoryBarrier.nsubresourceRange(adr, value)


inline var VkRenderPassBeginInfo.type: VkStructureType
    get() = VkStructureType of VkRenderPassBeginInfo.nsType(adr)
    set(value) = VkRenderPassBeginInfo.nsType(adr, value.i)
inline var VkRenderPassBeginInfo.next
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
inline val VkRenderPassBeginInfo.clearValueCount get() = clearValueCount()
inline var VkRenderPassBeginInfo.clearValues: VkClearValue.Buffer?
    get() = VkRenderPassBeginInfo.npClearValues(adr)
    set(value) = VkRenderPassBeginInfo.npClearValues(adr, value)
/** JVM custom  */
inline var VkRenderPassBeginInfo.clearValue: VkClearValue?
    get() = VkRenderPassBeginInfo.npClearValues(adr)?.get(0)
    set(value) {
        memPutAddress(adr + VkRenderPassBeginInfo.PCLEARVALUES, value?.adr ?: NULL)
        VkRenderPassBeginInfo.nclearValueCount(adr, if (value == null) 0 else 1)
    }

/** JVM custom */
fun VkRenderPassBeginInfo.clearValue(vec4: Vec4) {
    memPutFloat(adr + VkRenderPassBeginInfo.PCLEARVALUES, vec4.x)
    memPutFloat(adr + VkRenderPassBeginInfo.PCLEARVALUES + Float.BYTES, vec4.y)
    memPutFloat(adr + VkRenderPassBeginInfo.PCLEARVALUES + Float.BYTES * 2, vec4.z)
    memPutFloat(adr + VkRenderPassBeginInfo.PCLEARVALUES + Float.BYTES * 3, vec4.w)
    VkRenderPassBeginInfo.nclearValueCount(adr, 1)
}

//typedef struct VkRenderPassBeginInfo {
//    VkStructureType        sType;
//    const void*            pNext;
//    VkRenderPass           renderPass;
//    VkFramebuffer          framebuffer;
//    VkRect2D               renderArea;
//    uint32_t               clearValueCount;
//    const VkClearValue*    pClearValues;
//} VkRenderPassBeginInfo;
//
//typedef struct VkDispatchIndirectCommand {
//    uint32_t    x;
//    uint32_t    y;
//    uint32_t    z;
//} VkDispatchIndirectCommand;
//
//typedef struct VkDrawIndexedIndirectCommand {
//    uint32_t    indexCount;
//    uint32_t    instanceCount;
//    uint32_t    firstIndex;
//    int32_t     vertexOffset;
//    uint32_t    firstInstance;
//} VkDrawIndexedIndirectCommand;
//
//typedef struct VkDrawIndirectCommand {
//    uint32_t    vertexCount;
//    uint32_t    instanceCount;
//    uint32_t    firstVertex;
//    uint32_t    firstInstance;
//} VkDrawIndirectCommand;
//
//
//typedef struct VkBaseOutStructure {
//    VkStructureType               sType;
//    struct VkBaseOutStructure*    pNext;
//} VkBaseOutStructure;
//
//typedef struct VkBaseInStructure {
//    VkStructureType                    sType;
//    const struct VkBaseInStructure*    pNext;
//} VkBaseInStructure;
//
//typedef VkResult (VKAPI_PTR *PFN_vkCreateInstance)(const VkInstanceCreateInfo* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkInstance* pInstance);
//typedef void (VKAPI_PTR *PFN_vkDestroyInstance)(VkInstance instance, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkEnumeratePhysicalDevices)(VkInstance instance, uint32_t* pPhysicalDeviceCount, VkPhysicalDevice* pPhysicalDevices);
//typedef void (VKAPI_PTR *PFN_vkGetPhysicalDeviceFeatures)(VkPhysicalDevice physicalDevice, VkPhysicalDeviceFeatures* pFeatures);
//typedef void (VKAPI_PTR *PFN_vkGetPhysicalDeviceFormatProperties)(VkPhysicalDevice physicalDevice, VkFormat format, VkFormatProperties* pFormatProperties);
//typedef VkResult (VKAPI_PTR *PFN_vkGetPhysicalDeviceImageFormatProperties)(VkPhysicalDevice physicalDevice, VkFormat format, VkImageType type, VkImageTiling tiling, VkImageUsageFlags usage, VkImageCreateFlags flags, VkImageFormatProperties* pImageFormatProperties);
//typedef void (VKAPI_PTR *PFN_vkGetPhysicalDeviceProperties)(VkPhysicalDevice physicalDevice, VkPhysicalDeviceProperties* pProperties);
//typedef void (VKAPI_PTR *PFN_vkGetPhysicalDeviceQueueFamilyProperties)(VkPhysicalDevice physicalDevice, uint32_t* pQueueFamilyPropertyCount, VkQueueFamilyProperties* pQueueFamilyProperties);
//typedef void (VKAPI_PTR *PFN_vkGetPhysicalDeviceMemoryProperties)(VkPhysicalDevice physicalDevice, VkPhysicalDeviceMemoryProperties* pMemoryProperties);
//typedef PFN_vkVoidFunction (VKAPI_PTR *PFN_vkGetInstanceProcAddr)(VkInstance instance, const char* pName);
//typedef PFN_vkVoidFunction (VKAPI_PTR *PFN_vkGetDeviceProcAddr)(VkDevice device, const char* pName);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateDevice)(VkPhysicalDevice physicalDevice, const VkDeviceCreateInfo* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkDevice* pDevice);
//typedef void (VKAPI_PTR *PFN_vkDestroyDevice)(VkDevice device, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkEnumerateInstanceExtensionProperties)(const char* pLayerName, uint32_t* pPropertyCount, VkExtensionProperties* pProperties);
//typedef VkResult (VKAPI_PTR *PFN_vkEnumerateDeviceExtensionProperties)(VkPhysicalDevice physicalDevice, const char* pLayerName, uint32_t* pPropertyCount, VkExtensionProperties* pProperties);
//typedef VkResult (VKAPI_PTR *PFN_vkEnumerateInstanceLayerProperties)(uint32_t* pPropertyCount, VkLayerProperties* pProperties);
//typedef VkResult (VKAPI_PTR *PFN_vkEnumerateDeviceLayerProperties)(VkPhysicalDevice physicalDevice, uint32_t* pPropertyCount, VkLayerProperties* pProperties);
//typedef void (VKAPI_PTR *PFN_vkGetDeviceQueue)(VkDevice device, uint32_t queueFamilyIndex, uint32_t queueIndex, VkQueue* pQueue);
//typedef VkResult (VKAPI_PTR *PFN_vkQueueSubmit)(VkQueue queue, uint32_t submitCount, const VkSubmitInfo* pSubmits, VkFence fence);
//typedef VkResult (VKAPI_PTR *PFN_vkQueueWaitIdle)(VkQueue queue);
//typedef VkResult (VKAPI_PTR *PFN_vkDeviceWaitIdle)(VkDevice device);
//typedef VkResult (VKAPI_PTR *PFN_vkAllocateMemory)(VkDevice device, const VkMemoryAllocateInfo* pAllocateInfo, const VkAllocationCallbacks* pAllocator, VkDeviceMemory* pMemory);
//typedef void (VKAPI_PTR *PFN_vkFreeMemory)(VkDevice device, VkDeviceMemory memory, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkMapMemory)(VkDevice device, VkDeviceMemory memory, VkDeviceSize offset, VkDeviceSize size, VkMemoryMapFlags flags, void** ppData);
//typedef void (VKAPI_PTR *PFN_vkUnmapMemory)(VkDevice device, VkDeviceMemory memory);
//typedef VkResult (VKAPI_PTR *PFN_vkFlushMappedMemoryRanges)(VkDevice device, uint32_t memoryRangeCount, const VkMappedMemoryRange* pMemoryRanges);
//typedef VkResult (VKAPI_PTR *PFN_vkInvalidateMappedMemoryRanges)(VkDevice device, uint32_t memoryRangeCount, const VkMappedMemoryRange* pMemoryRanges);
//typedef void (VKAPI_PTR *PFN_vkGetDeviceMemoryCommitment)(VkDevice device, VkDeviceMemory memory, VkDeviceSize* pCommittedMemoryInBytes);
//typedef VkResult (VKAPI_PTR *PFN_vkBindBufferMemory)(VkDevice device, VkBuffer buffer, VkDeviceMemory memory, VkDeviceSize memoryOffset);
//typedef VkResult (VKAPI_PTR *PFN_vkBindImageMemory)(VkDevice device, VkImage image, VkDeviceMemory memory, VkDeviceSize memoryOffset);
//typedef void (VKAPI_PTR *PFN_vkGetBufferMemoryRequirements)(VkDevice device, VkBuffer buffer, VkMemoryRequirements* pMemoryRequirements);
//typedef void (VKAPI_PTR *PFN_vkGetImageMemoryRequirements)(VkDevice device, VkImage image, VkMemoryRequirements* pMemoryRequirements);
//typedef void (VKAPI_PTR *PFN_vkGetImageSparseMemoryRequirements)(VkDevice device, VkImage image, uint32_t* pSparseMemoryRequirementCount, VkSparseImageMemoryRequirements* pSparseMemoryRequirements);
//typedef void (VKAPI_PTR *PFN_vkGetPhysicalDeviceSparseImageFormatProperties)(VkPhysicalDevice physicalDevice, VkFormat format, VkImageType type, VkSampleCountFlagBits samples, VkImageUsageFlags usage, VkImageTiling tiling, uint32_t* pPropertyCount, VkSparseImageFormatProperties* pProperties);
//typedef VkResult (VKAPI_PTR *PFN_vkQueueBindSparse)(VkQueue queue, uint32_t bindInfoCount, const VkBindSparseInfo* pBindInfo, VkFence fence);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateFence)(VkDevice device, const VkFenceCreateInfo* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkFence* pFence);
//typedef void (VKAPI_PTR *PFN_vkDestroyFence)(VkDevice device, VkFence fence, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkResetFences)(VkDevice device, uint32_t fenceCount, const VkFence* pFences);
//typedef VkResult (VKAPI_PTR *PFN_vkGetFenceStatus)(VkDevice device, VkFence fence);
//typedef VkResult (VKAPI_PTR *PFN_vkWaitForFences)(VkDevice device, uint32_t fenceCount, const VkFence* pFences, VkBool32 waitAll, uint64_t timeout);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateSemaphore)(VkDevice device, const VkSemaphoreCreateInfo* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkSemaphore* pSemaphore);
//typedef void (VKAPI_PTR *PFN_vkDestroySemaphore)(VkDevice device, VkSemaphore semaphore, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateEvent)(VkDevice device, const VkEventCreateInfo* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkEvent* pEvent);
//typedef void (VKAPI_PTR *PFN_vkDestroyEvent)(VkDevice device, VkEvent event, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkGetEventStatus)(VkDevice device, VkEvent event);
//typedef VkResult (VKAPI_PTR *PFN_vkSetEvent)(VkDevice device, VkEvent event);
//typedef VkResult (VKAPI_PTR *PFN_vkResetEvent)(VkDevice device, VkEvent event);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateQueryPool)(VkDevice device, const VkQueryPoolCreateInfo* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkQueryPool* pQueryPool);
//typedef void (VKAPI_PTR *PFN_vkDestroyQueryPool)(VkDevice device, VkQueryPool queryPool, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkGetQueryPoolResults)(VkDevice device, VkQueryPool queryPool, uint32_t firstQuery, uint32_t queryCount, size_t dataSize, void* pData, VkDeviceSize stride, VkQueryResultFlags flags);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateBuffer)(VkDevice device, const VkBufferCreateInfo* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkBuffer* pBuffer);
//typedef void (VKAPI_PTR *PFN_vkDestroyBuffer)(VkDevice device, VkBuffer buffer, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateBufferView)(VkDevice device, const VkBufferViewCreateInfo* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkBufferView* pView);
//typedef void (VKAPI_PTR *PFN_vkDestroyBufferView)(VkDevice device, VkBufferView bufferView, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateImage)(VkDevice device, const VkImageCreateInfo* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkImage* pImage);
//typedef void (VKAPI_PTR *PFN_vkDestroyImage)(VkDevice device, VkImage image, const VkAllocationCallbacks* pAllocator);
//typedef void (VKAPI_PTR *PFN_vkGetImageSubresourceLayout)(VkDevice device, VkImage image, const VkImageSubresource* pSubresource, VkSubresourceLayout* pLayout);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateImageView)(VkDevice device, const VkImageViewCreateInfo* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkImageView* pView);
//typedef void (VKAPI_PTR *PFN_vkDestroyImageView)(VkDevice device, VkImageView imageView, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateShaderModule)(VkDevice device, const VkShaderModuleCreateInfo* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkShaderModule* pShaderModule);
//typedef void (VKAPI_PTR *PFN_vkDestroyShaderModule)(VkDevice device, VkShaderModule shaderModule, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkCreatePipelineCache)(VkDevice device, const VkPipelineCacheCreateInfo* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkPipelineCache* pPipelineCache);
//typedef void (VKAPI_PTR *PFN_vkDestroyPipelineCache)(VkDevice device, VkPipelineCache pipelineCache, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkGetPipelineCacheData)(VkDevice device, VkPipelineCache pipelineCache, size_t* pDataSize, void* pData);
//typedef VkResult (VKAPI_PTR *PFN_vkMergePipelineCaches)(VkDevice device, VkPipelineCache dstCache, uint32_t srcCacheCount, const VkPipelineCache* pSrcCaches);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateGraphicsPipelines)(VkDevice device, VkPipelineCache pipelineCache, uint32_t createInfoCount, const VkGraphicsPipelineCreateInfo* pCreateInfos, const VkAllocationCallbacks* pAllocator, VkPipeline* pPipelines);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateComputePipelines)(VkDevice device, VkPipelineCache pipelineCache, uint32_t createInfoCount, const VkComputePipelineCreateInfo* pCreateInfos, const VkAllocationCallbacks* pAllocator, VkPipeline* pPipelines);
//typedef void (VKAPI_PTR *PFN_vkDestroyPipeline)(VkDevice device, VkPipeline pipeline, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkCreatePipelineLayout)(VkDevice device, const VkPipelineLayoutCreateInfo* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkPipelineLayout* pPipelineLayout);
//typedef void (VKAPI_PTR *PFN_vkDestroyPipelineLayout)(VkDevice device, VkPipelineLayout pipelineLayout, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateSampler)(VkDevice device, const VkSamplerCreateInfo* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkSampler* pSampler);
//typedef void (VKAPI_PTR *PFN_vkDestroySampler)(VkDevice device, VkSampler sampler, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateDescriptorSetLayout)(VkDevice device, const VkDescriptorSetLayoutCreateInfo* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkDescriptorSetLayout* pSetLayout);
//typedef void (VKAPI_PTR *PFN_vkDestroyDescriptorSetLayout)(VkDevice device, VkDescriptorSetLayout descriptorSetLayout, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateDescriptorPool)(VkDevice device, const VkDescriptorPoolCreateInfo* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkDescriptorPool* pDescriptorPool);
//typedef void (VKAPI_PTR *PFN_vkDestroyDescriptorPool)(VkDevice device, VkDescriptorPool descriptorPool, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkResetDescriptorPool)(VkDevice device, VkDescriptorPool descriptorPool, VkDescriptorPoolResetFlags flags);
//typedef VkResult (VKAPI_PTR *PFN_vkAllocateDescriptorSets)(VkDevice device, const VkDescriptorSetAllocateInfo* pAllocateInfo, VkDescriptorSet* pDescriptorSets);
//typedef VkResult (VKAPI_PTR *PFN_vkFreeDescriptorSets)(VkDevice device, VkDescriptorPool descriptorPool, uint32_t descriptorSetCount, const VkDescriptorSet* pDescriptorSets);
//typedef void (VKAPI_PTR *PFN_vkUpdateDescriptorSets)(VkDevice device, uint32_t descriptorWriteCount, const VkWriteDescriptorSet* pDescriptorWrites, uint32_t descriptorCopyCount, const VkCopyDescriptorSet* pDescriptorCopies);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateFramebuffer)(VkDevice device, const VkFramebufferCreateInfo* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkFramebuffer* pFramebuffer);
//typedef void (VKAPI_PTR *PFN_vkDestroyFramebuffer)(VkDevice device, VkFramebuffer framebuffer, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateRenderPass)(VkDevice device, const VkRenderPassCreateInfo* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkRenderPass* pRenderPass);
//typedef void (VKAPI_PTR *PFN_vkDestroyRenderPass)(VkDevice device, VkRenderPass renderPass, const VkAllocationCallbacks* pAllocator);
//typedef void (VKAPI_PTR *PFN_vkGetRenderAreaGranularity)(VkDevice device, VkRenderPass renderPass, VkExtent2D* pGranularity);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateCommandPool)(VkDevice device, const VkCommandPoolCreateInfo* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkCommandPool* pCommandPool);
//typedef void (VKAPI_PTR *PFN_vkDestroyCommandPool)(VkDevice device, VkCommandPool commandPool, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkResetCommandPool)(VkDevice device, VkCommandPool commandPool, VkCommandPoolResetFlags flags);
//typedef VkResult (VKAPI_PTR *PFN_vkAllocateCommandBuffers)(VkDevice device, const VkCommandBufferAllocateInfo* pAllocateInfo, VkCommandBuffer* pCommandBuffers);
//typedef void (VKAPI_PTR *PFN_vkFreeCommandBuffers)(VkDevice device, VkCommandPool commandPool, uint32_t commandBufferCount, const VkCommandBuffer* pCommandBuffers);
//typedef VkResult (VKAPI_PTR *PFN_vkBeginCommandBuffer)(VkCommandBuffer commandBuffer, const VkCommandBufferBeginInfo* pBeginInfo);
//typedef VkResult (VKAPI_PTR *PFN_vkEndCommandBuffer)(VkCommandBuffer commandBuffer);
//typedef VkResult (VKAPI_PTR *PFN_vkResetCommandBuffer)(VkCommandBuffer commandBuffer, VkCommandBufferResetFlags flags);
//typedef void (VKAPI_PTR *PFN_vkCmdBindPipeline)(VkCommandBuffer commandBuffer, VkPipelineBindPoint pipelineBindPoint, VkPipeline pipeline);
//typedef void (VKAPI_PTR *PFN_vkCmdSetViewport)(VkCommandBuffer commandBuffer, uint32_t firstViewport, uint32_t viewportCount, const VkViewport* pViewports);
//typedef void (VKAPI_PTR *PFN_vkCmdSetScissor)(VkCommandBuffer commandBuffer, uint32_t firstScissor, uint32_t scissorCount, const VkRect2D* pScissors);
//typedef void (VKAPI_PTR *PFN_vkCmdSetLineWidth)(VkCommandBuffer commandBuffer, float lineWidth);
//typedef void (VKAPI_PTR *PFN_vkCmdSetDepthBias)(VkCommandBuffer commandBuffer, float depthBiasConstantFactor, float depthBiasClamp, float depthBiasSlopeFactor);
//typedef void (VKAPI_PTR *PFN_vkCmdSetBlendConstants)(VkCommandBuffer commandBuffer, const float blendConstants[4]);
//typedef void (VKAPI_PTR *PFN_vkCmdSetDepthBounds)(VkCommandBuffer commandBuffer, float minDepthBounds, float maxDepthBounds);
//typedef void (VKAPI_PTR *PFN_vkCmdSetStencilCompareMask)(VkCommandBuffer commandBuffer, VkStencilFaceFlags faceMask, uint32_t compareMask);
//typedef void (VKAPI_PTR *PFN_vkCmdSetStencilWriteMask)(VkCommandBuffer commandBuffer, VkStencilFaceFlags faceMask, uint32_t writeMask);
//typedef void (VKAPI_PTR *PFN_vkCmdSetStencilReference)(VkCommandBuffer commandBuffer, VkStencilFaceFlags faceMask, uint32_t reference);
//typedef void (VKAPI_PTR *PFN_vkCmdBindDescriptorSets)(VkCommandBuffer commandBuffer, VkPipelineBindPoint pipelineBindPoint, VkPipelineLayout layout, uint32_t firstSet, uint32_t descriptorSetCount, const VkDescriptorSet* pDescriptorSets, uint32_t dynamicOffsetCount, const uint32_t* pDynamicOffsets);
//typedef void (VKAPI_PTR *PFN_vkCmdBindIndexBuffer)(VkCommandBuffer commandBuffer, VkBuffer buffer, VkDeviceSize offset, VkIndexType indexType);
//typedef void (VKAPI_PTR *PFN_vkCmdBindVertexBuffers)(VkCommandBuffer commandBuffer, uint32_t firstBinding, uint32_t bindingCount, const VkBuffer* pBuffers, const VkDeviceSize* pOffsets);
//typedef void (VKAPI_PTR *PFN_vkCmdDraw)(VkCommandBuffer commandBuffer, uint32_t vertexCount, uint32_t instanceCount, uint32_t firstVertex, uint32_t firstInstance);
//typedef void (VKAPI_PTR *PFN_vkCmdDrawIndexed)(VkCommandBuffer commandBuffer, uint32_t indexCount, uint32_t instanceCount, uint32_t firstIndex, int32_t vertexOffset, uint32_t firstInstance);
//typedef void (VKAPI_PTR *PFN_vkCmdDrawIndirect)(VkCommandBuffer commandBuffer, VkBuffer buffer, VkDeviceSize offset, uint32_t drawCount, uint32_t stride);
//typedef void (VKAPI_PTR *PFN_vkCmdDrawIndexedIndirect)(VkCommandBuffer commandBuffer, VkBuffer buffer, VkDeviceSize offset, uint32_t drawCount, uint32_t stride);
//typedef void (VKAPI_PTR *PFN_vkCmdDispatch)(VkCommandBuffer commandBuffer, uint32_t groupCountX, uint32_t groupCountY, uint32_t groupCountZ);
//typedef void (VKAPI_PTR *PFN_vkCmdDispatchIndirect)(VkCommandBuffer commandBuffer, VkBuffer buffer, VkDeviceSize offset);
//typedef void (VKAPI_PTR *PFN_vkCmdCopyBuffer)(VkCommandBuffer commandBuffer, VkBuffer srcBuffer, VkBuffer dstBuffer, uint32_t regionCount, const VkBufferCopy* pRegions);
//typedef void (VKAPI_PTR *PFN_vkCmdCopyImage)(VkCommandBuffer commandBuffer, VkImage srcImage, VkImageLayout srcImageLayout, VkImage dstImage, VkImageLayout dstImageLayout, uint32_t regionCount, const VkImageCopy* pRegions);
//typedef void (VKAPI_PTR *PFN_vkCmdBlitImage)(VkCommandBuffer commandBuffer, VkImage srcImage, VkImageLayout srcImageLayout, VkImage dstImage, VkImageLayout dstImageLayout, uint32_t regionCount, const VkImageBlit* pRegions, VkFilter filter);
//typedef void (VKAPI_PTR *PFN_vkCmdCopyBufferToImage)(VkCommandBuffer commandBuffer, VkBuffer srcBuffer, VkImage dstImage, VkImageLayout dstImageLayout, uint32_t regionCount, const VkBufferImageCopy* pRegions);
//typedef void (VKAPI_PTR *PFN_vkCmdCopyImageToBuffer)(VkCommandBuffer commandBuffer, VkImage srcImage, VkImageLayout srcImageLayout, VkBuffer dstBuffer, uint32_t regionCount, const VkBufferImageCopy* pRegions);
//typedef void (VKAPI_PTR *PFN_vkCmdUpdateBuffer)(VkCommandBuffer commandBuffer, VkBuffer dstBuffer, VkDeviceSize dstOffset, VkDeviceSize dataSize, const void* pData);
//typedef void (VKAPI_PTR *PFN_vkCmdFillBuffer)(VkCommandBuffer commandBuffer, VkBuffer dstBuffer, VkDeviceSize dstOffset, VkDeviceSize size, uint32_t data);
//typedef void (VKAPI_PTR *PFN_vkCmdClearColorImage)(VkCommandBuffer commandBuffer, VkImage image, VkImageLayout imageLayout, const VkClearColorValue* pColor, uint32_t rangeCount, const VkImageSubresourceRange* pRanges);
//typedef void (VKAPI_PTR *PFN_vkCmdClearDepthStencilImage)(VkCommandBuffer commandBuffer, VkImage image, VkImageLayout imageLayout, const VkClearDepthStencilValue* pDepthStencil, uint32_t rangeCount, const VkImageSubresourceRange* pRanges);
//typedef void (VKAPI_PTR *PFN_vkCmdClearAttachments)(VkCommandBuffer commandBuffer, uint32_t attachmentCount, const VkClearAttachment* pAttachments, uint32_t rectCount, const VkClearRect* pRects);
//typedef void (VKAPI_PTR *PFN_vkCmdResolveImage)(VkCommandBuffer commandBuffer, VkImage srcImage, VkImageLayout srcImageLayout, VkImage dstImage, VkImageLayout dstImageLayout, uint32_t regionCount, const VkImageResolve* pRegions);
//typedef void (VKAPI_PTR *PFN_vkCmdSetEvent)(VkCommandBuffer commandBuffer, VkEvent event, VkPipelineStageFlags stageMask);
//typedef void (VKAPI_PTR *PFN_vkCmdResetEvent)(VkCommandBuffer commandBuffer, VkEvent event, VkPipelineStageFlags stageMask);
//typedef void (VKAPI_PTR *PFN_vkCmdWaitEvents)(VkCommandBuffer commandBuffer, uint32_t eventCount, const VkEvent* pEvents, VkPipelineStageFlags srcStageMask, VkPipelineStageFlags dstStageMask, uint32_t memoryBarrierCount, const VkMemoryBarrier* pMemoryBarriers, uint32_t bufferMemoryBarrierCount, const VkBufferMemoryBarrier* pBufferMemoryBarriers, uint32_t imageMemoryBarrierCount, const VkImageMemoryBarrier* pImageMemoryBarriers);
//typedef void (VKAPI_PTR *PFN_vkCmdPipelineBarrier)(VkCommandBuffer commandBuffer, VkPipelineStageFlags srcStageMask, VkPipelineStageFlags dstStageMask, VkDependencyFlags dependencyFlags, uint32_t memoryBarrierCount, const VkMemoryBarrier* pMemoryBarriers, uint32_t bufferMemoryBarrierCount, const VkBufferMemoryBarrier* pBufferMemoryBarriers, uint32_t imageMemoryBarrierCount, const VkImageMemoryBarrier* pImageMemoryBarriers);
//typedef void (VKAPI_PTR *PFN_vkCmdBeginQuery)(VkCommandBuffer commandBuffer, VkQueryPool queryPool, uint32_t query, VkQueryControlFlags flags);
//typedef void (VKAPI_PTR *PFN_vkCmdEndQuery)(VkCommandBuffer commandBuffer, VkQueryPool queryPool, uint32_t query);
//typedef void (VKAPI_PTR *PFN_vkCmdResetQueryPool)(VkCommandBuffer commandBuffer, VkQueryPool queryPool, uint32_t firstQuery, uint32_t queryCount);
//typedef void (VKAPI_PTR *PFN_vkCmdWriteTimestamp)(VkCommandBuffer commandBuffer, VkPipelineStageFlagBits pipelineStage, VkQueryPool queryPool, uint32_t query);
//typedef void (VKAPI_PTR *PFN_vkCmdCopyQueryPoolResults)(VkCommandBuffer commandBuffer, VkQueryPool queryPool, uint32_t firstQuery, uint32_t queryCount, VkBuffer dstBuffer, VkDeviceSize dstOffset, VkDeviceSize stride, VkQueryResultFlags flags);
//typedef void (VKAPI_PTR *PFN_vkCmdPushConstants)(VkCommandBuffer commandBuffer, VkPipelineLayout layout, VkShaderStageFlags stageFlags, uint32_t offset, uint32_t size, const void* pValues);
//typedef void (VKAPI_PTR *PFN_vkCmdBeginRenderPass)(VkCommandBuffer commandBuffer, const VkRenderPassBeginInfo* pRenderPassBegin, VkSubpassContents contents);
//typedef void (VKAPI_PTR *PFN_vkCmdNextSubpass)(VkCommandBuffer commandBuffer, VkSubpassContents contents);
//typedef void (VKAPI_PTR *PFN_vkCmdEndRenderPass)(VkCommandBuffer commandBuffer);
//typedef void (VKAPI_PTR *PFN_vkCmdExecuteCommands)(VkCommandBuffer commandBuffer, uint32_t commandBufferCount, const VkCommandBuffer* pCommandBuffers);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateInstance(
//const VkInstanceCreateInfo*                 pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkInstance*                                 pInstance);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyInstance(
//VkInstance                                  instance,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkEnumeratePhysicalDevices(
//VkInstance                                  instance,
//uint32_t*                                   pPhysicalDeviceCount,
//VkPhysicalDevice*                           pPhysicalDevices);
//
//VKAPI_ATTR void VKAPI_CALL vkGetPhysicalDeviceFeatures(
//VkPhysicalDevice                            physicalDevice,
//VkPhysicalDeviceFeatures*                   pFeatures);
//
//VKAPI_ATTR void VKAPI_CALL vkGetPhysicalDeviceFormatProperties(
//VkPhysicalDevice                            physicalDevice,
//VkFormat                                    format,
//VkFormatProperties*                         pFormatProperties);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetPhysicalDeviceImageFormatProperties(
//VkPhysicalDevice                            physicalDevice,
//VkFormat                                    format,
//VkImageType                                 type,
//VkImageTiling                               tiling,
//VkImageUsageFlags                           usage,
//VkImageCreateFlags                          flags,
//VkImageFormatProperties*                    pImageFormatProperties);
//
//VKAPI_ATTR void VKAPI_CALL vkGetPhysicalDeviceProperties(
//VkPhysicalDevice                            physicalDevice,
//VkPhysicalDeviceProperties*                 pProperties);
//
//VKAPI_ATTR void VKAPI_CALL vkGetPhysicalDeviceQueueFamilyProperties(
//VkPhysicalDevice                            physicalDevice,
//uint32_t*                                   pQueueFamilyPropertyCount,
//VkQueueFamilyProperties*                    pQueueFamilyProperties);
//
//VKAPI_ATTR void VKAPI_CALL vkGetPhysicalDeviceMemoryProperties(
//VkPhysicalDevice                            physicalDevice,
//VkPhysicalDeviceMemoryProperties*           pMemoryProperties);
//
//VKAPI_ATTR PFN_vkVoidFunction VKAPI_CALL vkGetInstanceProcAddr(
//VkInstance                                  instance,
//const char*                                 pName);
//
//VKAPI_ATTR PFN_vkVoidFunction VKAPI_CALL vkGetDeviceProcAddr(
//VkDevice                                    device,
//const char*                                 pName);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateDevice(
//VkPhysicalDevice                            physicalDevice,
//const VkDeviceCreateInfo*                   pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkDevice*                                   pDevice);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyDevice(
//VkDevice                                    device,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkEnumerateInstanceExtensionProperties(
//const char*                                 pLayerName,
//uint32_t*                                   pPropertyCount,
//VkExtensionProperties*                      pProperties);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkEnumerateDeviceExtensionProperties(
//VkPhysicalDevice                            physicalDevice,
//const char*                                 pLayerName,
//uint32_t*                                   pPropertyCount,
//VkExtensionProperties*                      pProperties);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkEnumerateInstanceLayerProperties(
//uint32_t*                                   pPropertyCount,
//VkLayerProperties*                          pProperties);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkEnumerateDeviceLayerProperties(
//VkPhysicalDevice                            physicalDevice,
//uint32_t*                                   pPropertyCount,
//VkLayerProperties*                          pProperties);
//
//VKAPI_ATTR void VKAPI_CALL vkGetDeviceQueue(
//VkDevice                                    device,
//uint32_t                                    queueFamilyIndex,
//uint32_t                                    queueIndex,
//VkQueue*                                    pQueue);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkQueueSubmit(
//VkQueue                                     queue,
//uint32_t                                    submitCount,
//const VkSubmitInfo*                         pSubmits,
//VkFence                                     fence);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkQueueWaitIdle(
//VkQueue                                     queue);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkDeviceWaitIdle(
//VkDevice                                    device);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkAllocateMemory(
//VkDevice                                    device,
//const VkMemoryAllocateInfo*                 pAllocateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkDeviceMemory*                             pMemory);
//
//VKAPI_ATTR void VKAPI_CALL vkFreeMemory(
//VkDevice                                    device,
//VkDeviceMemory                              memory,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkMapMemory(
//VkDevice                                    device,
//VkDeviceMemory                              memory,
//VkDeviceSize                                offset,
//VkDeviceSize                                size,
//VkMemoryMapFlags                            flags,
//void**                                      ppData);
//
//VKAPI_ATTR void VKAPI_CALL vkUnmapMemory(
//VkDevice                                    device,
//VkDeviceMemory                              memory);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkFlushMappedMemoryRanges(
//VkDevice                                    device,
//uint32_t                                    memoryRangeCount,
//const VkMappedMemoryRange*                  pMemoryRanges);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkInvalidateMappedMemoryRanges(
//VkDevice                                    device,
//uint32_t                                    memoryRangeCount,
//const VkMappedMemoryRange*                  pMemoryRanges);
//
//VKAPI_ATTR void VKAPI_CALL vkGetDeviceMemoryCommitment(
//VkDevice                                    device,
//VkDeviceMemory                              memory,
//VkDeviceSize*                               pCommittedMemoryInBytes);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkBindBufferMemory(
//VkDevice                                    device,
//VkBuffer                                    buffer,
//VkDeviceMemory                              memory,
//VkDeviceSize                                memoryOffset);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkBindImageMemory(
//VkDevice                                    device,
//VkImage                                     image,
//VkDeviceMemory                              memory,
//VkDeviceSize                                memoryOffset);
//
//VKAPI_ATTR void VKAPI_CALL vkGetBufferMemoryRequirements(
//VkDevice                                    device,
//VkBuffer                                    buffer,
//VkMemoryRequirements*                       pMemoryRequirements);
//
//VKAPI_ATTR void VKAPI_CALL vkGetImageMemoryRequirements(
//VkDevice                                    device,
//VkImage                                     image,
//VkMemoryRequirements*                       pMemoryRequirements);
//
//VKAPI_ATTR void VKAPI_CALL vkGetImageSparseMemoryRequirements(
//VkDevice                                    device,
//VkImage                                     image,
//uint32_t*                                   pSparseMemoryRequirementCount,
//VkSparseImageMemoryRequirements*            pSparseMemoryRequirements);
//
//VKAPI_ATTR void VKAPI_CALL vkGetPhysicalDeviceSparseImageFormatProperties(
//VkPhysicalDevice                            physicalDevice,
//VkFormat                                    format,
//VkImageType                                 type,
//VkSampleCountFlagBits                       samples,
//VkImageUsageFlags                           usage,
//VkImageTiling                               tiling,
//uint32_t*                                   pPropertyCount,
//VkSparseImageFormatProperties*              pProperties);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkQueueBindSparse(
//VkQueue                                     queue,
//uint32_t                                    bindInfoCount,
//const VkBindSparseInfo*                     pBindInfo,
//VkFence                                     fence);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateFence(
//VkDevice                                    device,
//const VkFenceCreateInfo*                    pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkFence*                                    pFence);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyFence(
//VkDevice                                    device,
//VkFence                                     fence,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkResetFences(
//VkDevice                                    device,
//uint32_t                                    fenceCount,
//const VkFence*                              pFences);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetFenceStatus(
//VkDevice                                    device,
//VkFence                                     fence);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkWaitForFences(
//VkDevice                                    device,
//uint32_t                                    fenceCount,
//const VkFence*                              pFences,
//VkBool32                                    waitAll,
//uint64_t                                    timeout);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateSemaphore(
//VkDevice                                    device,
//const VkSemaphoreCreateInfo*                pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkSemaphore*                                pSemaphore);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroySemaphore(
//VkDevice                                    device,
//VkSemaphore                                 semaphore,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateEvent(
//VkDevice                                    device,
//const VkEventCreateInfo*                    pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkEvent*                                    pEvent);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyEvent(
//VkDevice                                    device,
//VkEvent                                     event,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetEventStatus(
//VkDevice                                    device,
//VkEvent                                     event);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkSetEvent(
//VkDevice                                    device,
//VkEvent                                     event);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkResetEvent(
//VkDevice                                    device,
//VkEvent                                     event);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateQueryPool(
//VkDevice                                    device,
//const VkQueryPoolCreateInfo*                pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkQueryPool*                                pQueryPool);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyQueryPool(
//VkDevice                                    device,
//VkQueryPool                                 queryPool,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetQueryPoolResults(
//VkDevice                                    device,
//VkQueryPool                                 queryPool,
//uint32_t                                    firstQuery,
//uint32_t                                    queryCount,
//size_t                                      dataSize,
//void*                                       pData,
//VkDeviceSize                                stride,
//VkQueryResultFlags                          flags);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateBuffer(
//VkDevice                                    device,
//const VkBufferCreateInfo*                   pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkBuffer*                                   pBuffer);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyBuffer(
//VkDevice                                    device,
//VkBuffer                                    buffer,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateBufferView(
//VkDevice                                    device,
//const VkBufferViewCreateInfo*               pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkBufferView*                               pView);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyBufferView(
//VkDevice                                    device,
//VkBufferView                                bufferView,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateImage(
//VkDevice                                    device,
//const VkImageCreateInfo*                    pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkImage*                                    pImage);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyImage(
//VkDevice                                    device,
//VkImage                                     image,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR void VKAPI_CALL vkGetImageSubresourceLayout(
//VkDevice                                    device,
//VkImage                                     image,
//const VkImageSubresource*                   pSubresource,
//VkSubresourceLayout*                        pLayout);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateImageView(
//VkDevice                                    device,
//const VkImageViewCreateInfo*                pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkImageView*                                pView);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyImageView(
//VkDevice                                    device,
//VkImageView                                 imageView,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateShaderModule(
//VkDevice                                    device,
//const VkShaderModuleCreateInfo*             pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkShaderModule*                             pShaderModule);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyShaderModule(
//VkDevice                                    device,
//VkShaderModule                              shaderModule,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreatePipelineCache(
//VkDevice                                    device,
//const VkPipelineCacheCreateInfo*            pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkPipelineCache*                            pPipelineCache);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyPipelineCache(
//VkDevice                                    device,
//VkPipelineCache                             pipelineCache,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetPipelineCacheData(
//VkDevice                                    device,
//VkPipelineCache                             pipelineCache,
//size_t*                                     pDataSize,
//void*                                       pData);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkMergePipelineCaches(
//VkDevice                                    device,
//VkPipelineCache                             dstCache,
//uint32_t                                    srcCacheCount,
//const VkPipelineCache*                      pSrcCaches);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateGraphicsPipelines(
//VkDevice                                    device,
//VkPipelineCache                             pipelineCache,
//uint32_t                                    createInfoCount,
//const VkGraphicsPipelineCreateInfo*         pCreateInfos,
//const VkAllocationCallbacks*                pAllocator,
//VkPipeline*                                 pPipelines);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateComputePipelines(
//VkDevice                                    device,
//VkPipelineCache                             pipelineCache,
//uint32_t                                    createInfoCount,
//const VkComputePipelineCreateInfo*          pCreateInfos,
//const VkAllocationCallbacks*                pAllocator,
//VkPipeline*                                 pPipelines);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyPipeline(
//VkDevice                                    device,
//VkPipeline                                  pipeline,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreatePipelineLayout(
//VkDevice                                    device,
//const VkPipelineLayoutCreateInfo*           pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkPipelineLayout*                           pPipelineLayout);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyPipelineLayout(
//VkDevice                                    device,
//VkPipelineLayout                            pipelineLayout,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateSampler(
//VkDevice                                    device,
//const VkSamplerCreateInfo*                  pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkSampler*                                  pSampler);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroySampler(
//VkDevice                                    device,
//VkSampler                                   sampler,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateDescriptorSetLayout(
//VkDevice                                    device,
//const VkDescriptorSetLayoutCreateInfo*      pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkDescriptorSetLayout*                      pSetLayout);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyDescriptorSetLayout(
//VkDevice                                    device,
//VkDescriptorSetLayout                       descriptorSetLayout,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateDescriptorPool(
//VkDevice                                    device,
//const VkDescriptorPoolCreateInfo*           pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkDescriptorPool*                           pDescriptorPool);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyDescriptorPool(
//VkDevice                                    device,
//VkDescriptorPool                            descriptorPool,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkResetDescriptorPool(
//VkDevice                                    device,
//VkDescriptorPool                            descriptorPool,
//VkDescriptorPoolResetFlags                  flags);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkAllocateDescriptorSets(
//VkDevice                                    device,
//const VkDescriptorSetAllocateInfo*          pAllocateInfo,
//VkDescriptorSet*                            pDescriptorSets);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkFreeDescriptorSets(
//VkDevice                                    device,
//VkDescriptorPool                            descriptorPool,
//uint32_t                                    descriptorSetCount,
//const VkDescriptorSet*                      pDescriptorSets);
//
//VKAPI_ATTR void VKAPI_CALL vkUpdateDescriptorSets(
//VkDevice                                    device,
//uint32_t                                    descriptorWriteCount,
//const VkWriteDescriptorSet*                 pDescriptorWrites,
//uint32_t                                    descriptorCopyCount,
//const VkCopyDescriptorSet*                  pDescriptorCopies);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateFramebuffer(
//VkDevice                                    device,
//const VkFramebufferCreateInfo*              pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkFramebuffer*                              pFramebuffer);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyFramebuffer(
//VkDevice                                    device,
//VkFramebuffer                               framebuffer,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateRenderPass(
//VkDevice                                    device,
//const VkRenderPassCreateInfo*               pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkRenderPass*                               pRenderPass);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyRenderPass(
//VkDevice                                    device,
//VkRenderPass                                renderPass,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR void VKAPI_CALL vkGetRenderAreaGranularity(
//VkDevice                                    device,
//VkRenderPass                                renderPass,
//VkExtent2D*                                 pGranularity);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateCommandPool(
//VkDevice                                    device,
//const VkCommandPoolCreateInfo*              pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkCommandPool*                              pCommandPool);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroyCommandPool(
//VkDevice                                    device,
//VkCommandPool                               commandPool,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkResetCommandPool(
//VkDevice                                    device,
//VkCommandPool                               commandPool,
//VkCommandPoolResetFlags                     flags);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkAllocateCommandBuffers(
//VkDevice                                    device,
//const VkCommandBufferAllocateInfo*          pAllocateInfo,
//VkCommandBuffer*                            pCommandBuffers);
//
//VKAPI_ATTR void VKAPI_CALL vkFreeCommandBuffers(
//VkDevice                                    device,
//VkCommandPool                               commandPool,
//uint32_t                                    commandBufferCount,
//const VkCommandBuffer*                      pCommandBuffers);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkBeginCommandBuffer(
//VkCommandBuffer                             commandBuffer,
//const VkCommandBufferBeginInfo*             pBeginInfo);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkEndCommandBuffer(
//VkCommandBuffer                             commandBuffer);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkResetCommandBuffer(
//VkCommandBuffer                             commandBuffer,
//VkCommandBufferResetFlags                   flags);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdBindPipeline(
//VkCommandBuffer                             commandBuffer,
//VkPipelineBindPoint                         pipelineBindPoint,
//VkPipeline                                  pipeline);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdSetViewport(
//VkCommandBuffer                             commandBuffer,
//uint32_t                                    firstViewport,
//uint32_t                                    viewportCount,
//const VkViewport*                           pViewports);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdSetScissor(
//VkCommandBuffer                             commandBuffer,
//uint32_t                                    firstScissor,
//uint32_t                                    scissorCount,
//const VkRect2D*                             pScissors);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdSetLineWidth(
//VkCommandBuffer                             commandBuffer,
//float                                       lineWidth);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdSetDepthBias(
//VkCommandBuffer                             commandBuffer,
//float                                       depthBiasConstantFactor,
//float                                       depthBiasClamp,
//float                                       depthBiasSlopeFactor);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdSetBlendConstants(
//VkCommandBuffer                             commandBuffer,
//const float                                 blendConstants[4]);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdSetDepthBounds(
//VkCommandBuffer                             commandBuffer,
//float                                       minDepthBounds,
//float                                       maxDepthBounds);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdSetStencilCompareMask(
//VkCommandBuffer                             commandBuffer,
//VkStencilFaceFlags                          faceMask,
//uint32_t                                    compareMask);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdSetStencilWriteMask(
//VkCommandBuffer                             commandBuffer,
//VkStencilFaceFlags                          faceMask,
//uint32_t                                    writeMask);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdSetStencilReference(
//VkCommandBuffer                             commandBuffer,
//VkStencilFaceFlags                          faceMask,
//uint32_t                                    reference);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdBindDescriptorSets(
//VkCommandBuffer                             commandBuffer,
//VkPipelineBindPoint                         pipelineBindPoint,
//VkPipelineLayout                            layout,
//uint32_t                                    firstSet,
//uint32_t                                    descriptorSetCount,
//const VkDescriptorSet*                      pDescriptorSets,
//uint32_t                                    dynamicOffsetCount,
//const uint32_t*                             pDynamicOffsets);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdBindIndexBuffer(
//VkCommandBuffer                             commandBuffer,
//VkBuffer                                    buffer,
//VkDeviceSize                                offset,
//VkIndexType                                 indexType);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdBindVertexBuffers(
//VkCommandBuffer                             commandBuffer,
//uint32_t                                    firstBinding,
//uint32_t                                    bindingCount,
//const VkBuffer*                             pBuffers,
//const VkDeviceSize*                         pOffsets);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdDraw(
//VkCommandBuffer                             commandBuffer,
//uint32_t                                    vertexCount,
//uint32_t                                    instanceCount,
//uint32_t                                    firstVertex,
//uint32_t                                    firstInstance);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdDrawIndexed(
//VkCommandBuffer                             commandBuffer,
//uint32_t                                    indexCount,
//uint32_t                                    instanceCount,
//uint32_t                                    firstIndex,
//int32_t                                     vertexOffset,
//uint32_t                                    firstInstance);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdDrawIndirect(
//VkCommandBuffer                             commandBuffer,
//VkBuffer                                    buffer,
//VkDeviceSize                                offset,
//uint32_t                                    drawCount,
//uint32_t                                    stride);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdDrawIndexedIndirect(
//VkCommandBuffer                             commandBuffer,
//VkBuffer                                    buffer,
//VkDeviceSize                                offset,
//uint32_t                                    drawCount,
//uint32_t                                    stride);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdDispatch(
//VkCommandBuffer                             commandBuffer,
//uint32_t                                    groupCountX,
//uint32_t                                    groupCountY,
//uint32_t                                    groupCountZ);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdDispatchIndirect(
//VkCommandBuffer                             commandBuffer,
//VkBuffer                                    buffer,
//VkDeviceSize                                offset);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdCopyBuffer(
//VkCommandBuffer                             commandBuffer,
//VkBuffer                                    srcBuffer,
//VkBuffer                                    dstBuffer,
//uint32_t                                    regionCount,
//const VkBufferCopy*                         pRegions);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdCopyImage(
//VkCommandBuffer                             commandBuffer,
//VkImage                                     srcImage,
//VkImageLayout                               srcImageLayout,
//VkImage                                     dstImage,
//VkImageLayout                               dstImageLayout,
//uint32_t                                    regionCount,
//const VkImageCopy*                          pRegions);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdBlitImage(
//VkCommandBuffer                             commandBuffer,
//VkImage                                     srcImage,
//VkImageLayout                               srcImageLayout,
//VkImage                                     dstImage,
//VkImageLayout                               dstImageLayout,
//uint32_t                                    regionCount,
//const VkImageBlit*                          pRegions,
//VkFilter                                    filter);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdCopyBufferToImage(
//VkCommandBuffer                             commandBuffer,
//VkBuffer                                    srcBuffer,
//VkImage                                     dstImage,
//VkImageLayout                               dstImageLayout,
//uint32_t                                    regionCount,
//const VkBufferImageCopy*                    pRegions);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdCopyImageToBuffer(
//VkCommandBuffer                             commandBuffer,
//VkImage                                     srcImage,
//VkImageLayout                               srcImageLayout,
//VkBuffer                                    dstBuffer,
//uint32_t                                    regionCount,
//const VkBufferImageCopy*                    pRegions);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdUpdateBuffer(
//VkCommandBuffer                             commandBuffer,
//VkBuffer                                    dstBuffer,
//VkDeviceSize                                dstOffset,
//VkDeviceSize                                dataSize,
//const void*                                 pData);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdFillBuffer(
//VkCommandBuffer                             commandBuffer,
//VkBuffer                                    dstBuffer,
//VkDeviceSize                                dstOffset,
//VkDeviceSize                                size,
//uint32_t                                    data);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdClearColorImage(
//VkCommandBuffer                             commandBuffer,
//VkImage                                     image,
//VkImageLayout                               imageLayout,
//const VkClearColorValue*                    pColor,
//uint32_t                                    rangeCount,
//const VkImageSubresourceRange*              pRanges);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdClearDepthStencilImage(
//VkCommandBuffer                             commandBuffer,
//VkImage                                     image,
//VkImageLayout                               imageLayout,
//const VkClearDepthStencilValue*             pDepthStencil,
//uint32_t                                    rangeCount,
//const VkImageSubresourceRange*              pRanges);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdClearAttachments(
//VkCommandBuffer                             commandBuffer,
//uint32_t                                    attachmentCount,
//const VkClearAttachment*                    pAttachments,
//uint32_t                                    rectCount,
//const VkClearRect*                          pRects);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdResolveImage(
//VkCommandBuffer                             commandBuffer,
//VkImage                                     srcImage,
//VkImageLayout                               srcImageLayout,
//VkImage                                     dstImage,
//VkImageLayout                               dstImageLayout,
//uint32_t                                    regionCount,
//const VkImageResolve*                       pRegions);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdSetEvent(
//VkCommandBuffer                             commandBuffer,
//VkEvent                                     event,
//VkPipelineStageFlags                        stageMask);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdResetEvent(
//VkCommandBuffer                             commandBuffer,
//VkEvent                                     event,
//VkPipelineStageFlags                        stageMask);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdWaitEvents(
//VkCommandBuffer                             commandBuffer,
//uint32_t                                    eventCount,
//const VkEvent*                              pEvents,
//VkPipelineStageFlags                        srcStageMask,
//VkPipelineStageFlags                        dstStageMask,
//uint32_t                                    memoryBarrierCount,
//const VkMemoryBarrier*                      pMemoryBarriers,
//uint32_t                                    bufferMemoryBarrierCount,
//const VkBufferMemoryBarrier*                pBufferMemoryBarriers,
//uint32_t                                    imageMemoryBarrierCount,
//const VkImageMemoryBarrier*                 pImageMemoryBarriers);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdPipelineBarrier(
//VkCommandBuffer                             commandBuffer,
//VkPipelineStageFlags                        srcStageMask,
//VkPipelineStageFlags                        dstStageMask,
//VkDependencyFlags                           dependencyFlags,
//uint32_t                                    memoryBarrierCount,
//const VkMemoryBarrier*                      pMemoryBarriers,
//uint32_t                                    bufferMemoryBarrierCount,
//const VkBufferMemoryBarrier*                pBufferMemoryBarriers,
//uint32_t                                    imageMemoryBarrierCount,
//const VkImageMemoryBarrier*                 pImageMemoryBarriers);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdBeginQuery(
//VkCommandBuffer                             commandBuffer,
//VkQueryPool                                 queryPool,
//uint32_t                                    query,
//VkQueryControlFlags                         flags);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdEndQuery(
//VkCommandBuffer                             commandBuffer,
//VkQueryPool                                 queryPool,
//uint32_t                                    query);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdResetQueryPool(
//VkCommandBuffer                             commandBuffer,
//VkQueryPool                                 queryPool,
//uint32_t                                    firstQuery,
//uint32_t                                    queryCount);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdWriteTimestamp(
//VkCommandBuffer                             commandBuffer,
//VkPipelineStageFlagBits                     pipelineStage,
//VkQueryPool                                 queryPool,
//uint32_t                                    query);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdCopyQueryPoolResults(
//VkCommandBuffer                             commandBuffer,
//VkQueryPool                                 queryPool,
//uint32_t                                    firstQuery,
//uint32_t                                    queryCount,
//VkBuffer                                    dstBuffer,
//VkDeviceSize                                dstOffset,
//VkDeviceSize                                stride,
//VkQueryResultFlags                          flags);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdPushConstants(
//VkCommandBuffer                             commandBuffer,
//VkPipelineLayout                            layout,
//VkShaderStageFlags                          stageFlags,
//uint32_t                                    offset,
//uint32_t                                    size,
//const void*                                 pValues);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdBeginRenderPass(
//VkCommandBuffer                             commandBuffer,
//const VkRenderPassBeginInfo*                pRenderPassBegin,
//VkSubpassContents                           contents);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdNextSubpass(
//VkCommandBuffer                             commandBuffer,
//VkSubpassContents                           contents);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdEndRenderPass(
//VkCommandBuffer                             commandBuffer);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdExecuteCommands(
//VkCommandBuffer                             commandBuffer,
//uint32_t                                    commandBufferCount,
//const VkCommandBuffer*                      pCommandBuffers);
//#endif
//
//#define VK_KHR_surface 1
//VK_DEFINE_NON_DISPATCHABLE_HANDLE(VkSurfaceKHR)
//
//#define VK_KHR_SURFACE_SPEC_VERSION       25
//#define VK_KHR_SURFACE_EXTENSION_NAME     "VK_KHR_surface"
//#define VK_COLORSPACE_SRGB_NONLINEAR_KHR  VK_COLOR_SPACE_SRGB_NONLINEAR_KHR
//
//


inline val VkSurfaceCapabilitiesKHR.minImageCount get() = VkSurfaceCapabilitiesKHR.nminImageCount(adr)
inline val VkSurfaceCapabilitiesKHR.maxImageCount get() = VkSurfaceCapabilitiesKHR.nmaxImageCount(adr)
inline val VkSurfaceCapabilitiesKHR.currentExtent: VkExtent2D get() = VkSurfaceCapabilitiesKHR.ncurrentExtent(adr)
inline val VkSurfaceCapabilitiesKHR.minImageExtent: VkExtent2D get() = VkSurfaceCapabilitiesKHR.nminImageExtent(adr)
inline val VkSurfaceCapabilitiesKHR.maxImageExtent: VkExtent2D get() = VkSurfaceCapabilitiesKHR.nmaxImageExtent(adr)
inline val VkSurfaceCapabilitiesKHR.maxImageArrayLayers get() = VkSurfaceCapabilitiesKHR.nmaxImageArrayLayers(adr)
inline val VkSurfaceCapabilitiesKHR.supportedTransforms: VkSurfaceTransformFlagsKHR get() = VkSurfaceCapabilitiesKHR.nsupportedTransforms(adr)
inline val VkSurfaceCapabilitiesKHR.currentTransform: VkSurfaceTransform get() = VkSurfaceTransform of VkSurfaceCapabilitiesKHR.ncurrentTransform(adr)
inline val VkSurfaceCapabilitiesKHR.supportedCompositeAlpha: VkCompositeAlphaFlagsKHR get() = VkSurfaceCapabilitiesKHR.nsupportedCompositeAlpha(adr)
inline val VkSurfaceCapabilitiesKHR.supportedUsageFlags: VkImageUsageFlags get() = VkSurfaceCapabilitiesKHR.nsupportedUsageFlags(adr)

//typedef struct VkSurfaceCapabilitiesKHR {
//    uint32_t                         minImageCount;
//    uint32_t                         maxImageCount;
//    VkExtent2D                       currentExtent;
//    VkExtent2D                       minImageExtent;
//    VkExtent2D                       maxImageExtent;
//    uint32_t                         maxImageArrayLayers;
//    VkSurfaceTransformFlagsKHR       supportedTransforms;
//    VkSurfaceTransformFlagBitsKHR    currentTransform;
//    VkCompositeAlphaFlagsKHR         supportedCompositeAlpha;
//    VkImageUsageFlags                supportedUsageFlags;
//} VkSurfaceCapabilitiesKHR;

inline var VkSurfaceFormatKHR.format: VkFormat
    get() = VkFormat of VkSurfaceFormatKHR.nformat(adr)
    set(value) = memPutInt(adr + VkSurfaceFormatKHR.FORMAT, value.i)
inline var VkSurfaceFormatKHR.colorSpace: VkColorSpace
    get() = VkColorSpace of VkSurfaceFormatKHR.ncolorSpace(adr)
    set(value) = memPutInt(adr + VkSurfaceFormatKHR.COLORSPACE, value.i)

operator fun VkSurfaceFormatKHR.invoke(surfaceFormatKHR: VkSurfaceFormatKHR) {
    format = surfaceFormatKHR.format
    colorSpace = surfaceFormatKHR.colorSpace
}
//
//typedef void (VKAPI_PTR *PFN_vkDestroySurfaceKHR)(VkInstance instance, VkSurfaceKHR surface, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkGetPhysicalDeviceSurfaceSupportKHR)(VkPhysicalDevice physicalDevice, uint32_t queueFamilyIndex, VkSurfaceKHR surface, VkBool32* pSupported);
//typedef VkResult (VKAPI_PTR *PFN_vkGetPhysicalDeviceSurfaceCapabilitiesKHR)(VkPhysicalDevice physicalDevice, VkSurfaceKHR surface, VkSurfaceCapabilitiesKHR* pSurfaceCapabilities);
//typedef VkResult (VKAPI_PTR *PFN_vkGetPhysicalDeviceSurfaceFormatsKHR)(VkPhysicalDevice physicalDevice, VkSurfaceKHR surface, uint32_t* pSurfaceFormatCount, VkSurfaceFormatKHR* pSurfaceFormats);
//typedef VkResult (VKAPI_PTR *PFN_vkGetPhysicalDeviceSurfacePresentModesKHR)(VkPhysicalDevice physicalDevice, VkSurfaceKHR surface, uint32_t* pPresentModeCount, VkPresentModeKHR* pPresentModes);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR void VKAPI_CALL vkDestroySurfaceKHR(
//VkInstance                                  instance,
//VkSurfaceKHR                                surface,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetPhysicalDeviceSurfaceSupportKHR(
//VkPhysicalDevice                            physicalDevice,
//uint32_t                                    queueFamilyIndex,
//VkSurfaceKHR                                surface,
//VkBool32*                                   pSupported);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetPhysicalDeviceSurfaceCapabilitiesKHR(
//VkPhysicalDevice                            physicalDevice,
//VkSurfaceKHR                                surface,
//VkSurfaceCapabilitiesKHR*                   pSurfaceCapabilities);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetPhysicalDeviceSurfaceFormatsKHR(
//VkPhysicalDevice                            physicalDevice,
//VkSurfaceKHR                                surface,
//uint32_t*                                   pSurfaceFormatCount,
//VkSurfaceFormatKHR*                         pSurfaceFormats);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetPhysicalDeviceSurfacePresentModesKHR(
//VkPhysicalDevice                            physicalDevice,
//VkSurfaceKHR                                surface,
//uint32_t*                                   pPresentModeCount,
//VkPresentModeKHR*                           pPresentModes);
//#endif
//
//#define VK_KHR_swapchain 1
//VK_DEFINE_NON_DISPATCHABLE_HANDLE(VkSwapchainKHR)
//
//#define VK_KHR_SWAPCHAIN_SPEC_VERSION     68
//#define VK_KHR_SWAPCHAIN_EXTENSION_NAME   "VK_KHR_swapchain"


inline var VkSwapchainCreateInfoKHR.type: VkStructureType
    get() = VkStructureType of VkSwapchainCreateInfoKHR.nsType(adr)
    set(value) = VkSwapchainCreateInfoKHR.nsType(adr, value.i)
inline var VkSwapchainCreateInfoKHR.next: Long
    get() = VkSwapchainCreateInfoKHR.npNext(adr)
    set(value) = VkSwapchainCreateInfoKHR.npNext(adr, value)
inline var VkSwapchainCreateInfoKHR.flags: VkSwapchainCreateFlagsKHR
    get() = VkSwapchainCreateInfoKHR.nflags(adr)
    set(value) = VkSwapchainCreateInfoKHR.nflags(adr, value)
inline var VkSwapchainCreateInfoKHR.surface: VkSurface
    get() = VkSurface(VkSwapchainCreateInfoKHR.nsurface(adr))
    set(value) = VkSwapchainCreateInfoKHR.nsurface(adr, value.L)
inline var VkSwapchainCreateInfoKHR.minImageCount
    get() = VkSwapchainCreateInfoKHR.nminImageCount(adr)
    set(value) = VkSwapchainCreateInfoKHR.nminImageCount(adr, value)
inline var VkSwapchainCreateInfoKHR.imageFormat: VkFormat
    get() = VkFormat of VkSwapchainCreateInfoKHR.nimageFormat(adr)
    set(value) = VkSwapchainCreateInfoKHR.nimageFormat(adr, value.i)
inline var VkSwapchainCreateInfoKHR.imageColorSpace: VkColorSpace
    get() = VkColorSpace of VkSwapchainCreateInfoKHR.nimageColorSpace(adr)
    set(value) = VkSwapchainCreateInfoKHR.nimageColorSpace(adr, value.i)
inline var VkSwapchainCreateInfoKHR.imageExtent: VkExtent2D
    get() = VkSwapchainCreateInfoKHR.nimageExtent(adr)
    set(value) = VkSwapchainCreateInfoKHR.nimageExtent(adr, value)

/** JVM custom */
fun VkSwapchainCreateInfoKHR.imageExtent(extent: Vec2i) {
    imageExtent.width = extent.x
    imageExtent.height = extent.y
}

inline var VkSwapchainCreateInfoKHR.imageArrayLayers
    get() = VkSwapchainCreateInfoKHR.nimageArrayLayers(adr)
    set(value) = VkSwapchainCreateInfoKHR.nimageArrayLayers(adr, value)
inline var VkSwapchainCreateInfoKHR.imageUsage: VkImageUsageFlags
    get() = VkSwapchainCreateInfoKHR.nimageUsage(adr)
    set(value) = VkSwapchainCreateInfoKHR.nimageUsage(adr, value)
inline var VkSwapchainCreateInfoKHR.imageSharingMode: VkSharingMode
    get() = VkSharingMode of VkSwapchainCreateInfoKHR.nimageSharingMode(adr)
    set(value) = VkSwapchainCreateInfoKHR.nimageSharingMode(adr, value.i)
inline val VkSwapchainCreateInfoKHR.queueFamilyIndexCount get() = VkSwapchainCreateInfoKHR.nqueueFamilyIndexCount(adr)
inline var VkSwapchainCreateInfoKHR.queueFamilyIndices
    get() = VkSwapchainCreateInfoKHR.npQueueFamilyIndices(adr)
    set(value) = VkSwapchainCreateInfoKHR.npQueueFamilyIndices(adr, value)
inline var VkSwapchainCreateInfoKHR.preTransform: VkSurfaceTransform
    get() = VkSurfaceTransform of VkSwapchainCreateInfoKHR.npreTransform(adr)
    set(value) = VkSwapchainCreateInfoKHR.npreTransform(adr, value.i)
inline var VkSwapchainCreateInfoKHR.compositeAlpha: VkCompositeAlpha
    get() = VkCompositeAlpha of VkSwapchainCreateInfoKHR.ncompositeAlpha(adr)
    set(value) = VkSwapchainCreateInfoKHR.ncompositeAlpha(adr, value.i)
inline var VkSwapchainCreateInfoKHR.presentMode: VkPresentMode
    get() = VkPresentMode of VkSwapchainCreateInfoKHR.npresentMode(adr)
    set(value) = VkSwapchainCreateInfoKHR.npresentMode(adr, value.i)
inline var VkSwapchainCreateInfoKHR.clipped
    get() = VkSwapchainCreateInfoKHR.nclipped(adr).bool
    set(value) = VkSwapchainCreateInfoKHR.nclipped(adr, value.i)
inline var VkSwapchainCreateInfoKHR.oldSwapchain: VkSwapchainKHR
    get() = VkSwapchainKHR(VkSwapchainCreateInfoKHR.noldSwapchain(adr))
    set(value) = VkSwapchainCreateInfoKHR.noldSwapchain(adr, value.L)


typealias VkSwapchainCreateFlagsKHR = VkFlags

//typedef struct VkSwapchainCreateInfoKHR {
//    VkStructureType                  sType;
//    const void*                      pNext;
//    VkSwapchainCreateFlagsKHR        flags;
//    VkSurfaceKHR                     surface;
//    uint32_t                         minImageCount;
//    VkFormat                         imageFormat;
//    VkColorSpaceKHR                  imageColorSpace;
//    VkExtent2D                       imageExtent;
//    uint32_t                         imageArrayLayers;
//    VkImageUsageFlags                imageUsage;
//    VkSharingMode                    imageSharingMode;
//    uint32_t                         queueFamilyIndexCount;
//    const uint32_t*                  pQueueFamilyIndices;
//    VkSurfaceTransformFlagBitsKHR    preTransform;
//    VkCompositeAlphaFlagBitsKHR      compositeAlpha;
//    VkPresentModeKHR                 presentMode;
//    VkBool32                         clipped;
//    VkSwapchainKHR                   oldSwapchain;
//} VkSwapchainCreateInfoKHR;


inline var VkPresentInfoKHR.type: VkStructureType
    get() = VkStructureType of VkPresentInfoKHR.nsType(adr)
    set(value) = VkPresentInfoKHR.nsType(adr, value.i)
inline var VkPresentInfoKHR.next
    get() = VkPresentInfoKHR.npNext(adr)
    set(value) = VkPresentInfoKHR.npNext(adr, value)
//inline val VkPresentInfoKHR.waitSemaphoreCount get() = VkPresentInfoKHR.nwaitSemaphoreCount(adr)
inline var VkPresentInfoKHR.waitSemaphores: VkSemaphoreBuffer?
    get() = VkPresentInfoKHR.npWaitSemaphores(adr)
    set(value) = VkPresentInfoKHR.npWaitSemaphores(adr, value)
/** JVM custom */
inline var VkPresentInfoKHR.waitSemaphore: VkSemaphore?
    get() = VkPresentInfoKHR.npWaitSemaphores(adr)?.let { VkSemaphore(it[0]) }
    set(value) = when (value) {
        null -> {
            memPutAddress(adr + VkPresentInfoKHR.PWAITSEMAPHORES, NULL)
            VkPresentInfoKHR.nwaitSemaphoreCount(adr, 0)
        }
        else -> longAddressStack(value.L) {
            memPutAddress(adr + VkPresentInfoKHR.PWAITSEMAPHORES, it)
            memPutInt(adr + VkPresentInfoKHR.WAITSEMAPHORECOUNT, 1)
        }
    }
inline var VkPresentInfoKHR.swapchainCount: Int
    get() = VkPresentInfoKHR.nswapchainCount(adr)
    set(value) = VkPresentInfoKHR.nswapchainCount(adr, value)
inline var VkPresentInfoKHR.swapchains: VkSwapchainKhrBuffer
    get() = VkPresentInfoKHR.npSwapchains(adr)
    set(value) = VkPresentInfoKHR.npSwapchains(adr, value)
/** JVM custom */
inline var VkPresentInfoKHR.swapchain: VkSwapchainKHR
    get() = VkSwapchainKHR(VkPresentInfoKHR.npSwapchains(adr)[0])
    set(value) = longAddressStack(value.L) { memPutAddress(adr + VkPresentInfoKHR.PSWAPCHAINS, it) }
inline var VkPresentInfoKHR.imageIndices: IntBuffer
    get() = VkPresentInfoKHR.npImageIndices(adr)
    set(value) = VkPresentInfoKHR.npImageIndices(adr, value)
/** JVM custom */
inline var VkPresentInfoKHR.imageIndex: Int
    get() = VkPresentInfoKHR.npImageIndices(adr)[0]
    set(value) = intAddressStack(value) { memPutAddress(adr + VkPresentInfoKHR.PIMAGEINDICES, it) }
inline var VkPresentInfoKHR.results: VkResultBuffer?
    get() = VkPresentInfoKHR.npResults(adr)
    set(value) = VkPresentInfoKHR.npResults(adr, value)

//typedef VkResult (VKAPI_PTR *PFN_vkCreateSwapchainKHR)(VkDevice device, const VkSwapchainCreateInfoKHR* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkSwapchainKHR* pSwapchain);
//typedef void (VKAPI_PTR *PFN_vkDestroySwapchainKHR)(VkDevice device, VkSwapchainKHR swapchain, const VkAllocationCallbacks* pAllocator);
//typedef VkResult (VKAPI_PTR *PFN_vkGetSwapchainImagesKHR)(VkDevice device, VkSwapchainKHR swapchain, uint32_t* pSwapchainImageCount, VkImage* pSwapchainImages);
//typedef VkResult (VKAPI_PTR *PFN_vkAcquireNextImageKHR)(VkDevice device, VkSwapchainKHR swapchain, uint64_t timeout, VkSemaphore semaphore, VkFence fence, uint32_t* pImageIndex);
//typedef VkResult (VKAPI_PTR *PFN_vkQueuePresentKHR)(VkQueue queue, const VkPresentInfoKHR* pPresentInfo);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateSwapchainKHR(
//VkDevice                                    device,
//const VkSwapchainCreateInfoKHR*             pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkSwapchainKHR*                             pSwapchain);
//
//VKAPI_ATTR void VKAPI_CALL vkDestroySwapchainKHR(
//VkDevice                                    device,
//VkSwapchainKHR                              swapchain,
//const VkAllocationCallbacks*                pAllocator);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetSwapchainImagesKHR(
//VkDevice                                    device,
//VkSwapchainKHR                              swapchain,
//uint32_t*                                   pSwapchainImageCount,
//VkImage*                                    pSwapchainImages);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkAcquireNextImageKHR(
//VkDevice                                    device,
//VkSwapchainKHR                              swapchain,
//uint64_t                                    timeout,
//VkSemaphore                                 semaphore,
//VkFence                                     fence,
//uint32_t*                                   pImageIndex);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkQueuePresentKHR(
//VkQueue                                     queue,
//const VkPresentInfoKHR*                     pPresentInfo);
//#endif
//
//#define VK_KHR_display 1
//VK_DEFINE_NON_DISPATCHABLE_HANDLE(VkDisplayKHR)
//VK_DEFINE_NON_DISPATCHABLE_HANDLE(VkDisplayModeKHR)
//
//#define VK_KHR_DISPLAY_SPEC_VERSION       21
//#define VK_KHR_DISPLAY_EXTENSION_NAME     "VK_KHR_display"
//
//
//typedef enum VkDisplayPlaneAlphaFlagBitsKHR {
//    VK_DISPLAY_PLANE_ALPHA_OPAQUE_BIT_KHR = 0x00000001,
//    VK_DISPLAY_PLANE_ALPHA_GLOBAL_BIT_KHR = 0x00000002,
//    VK_DISPLAY_PLANE_ALPHA_PER_PIXEL_BIT_KHR = 0x00000004,
//    VK_DISPLAY_PLANE_ALPHA_PER_PIXEL_PREMULTIPLIED_BIT_KHR = 0x00000008,
//    VK_DISPLAY_PLANE_ALPHA_FLAG_BITS_MAX_ENUM_KHR = 0x7FFFFFFF
//} VkDisplayPlaneAlphaFlagBitsKHR;
//typedef VkFlags VkDisplayPlaneAlphaFlagsKHR;
//typedef VkFlags VkDisplayModeCreateFlagsKHR;
//typedef VkFlags VkDisplaySurfaceCreateFlagsKHR;
//
//typedef struct VkDisplayPropertiesKHR {
//    VkDisplayKHR                  display;
//    const char*                   displayName;
//    VkExtent2D                    physicalDimensions;
//    VkExtent2D                    physicalResolution;
//    VkSurfaceTransformFlagsKHR    supportedTransforms;
//    VkBool32                      planeReorderPossible;
//    VkBool32                      persistentContent;
//} VkDisplayPropertiesKHR;
//
//typedef struct VkDisplayModeParametersKHR {
//    VkExtent2D    visibleRegion;
//    uint32_t      refreshRate;
//} VkDisplayModeParametersKHR;
//
//typedef struct VkDisplayModePropertiesKHR {
//    VkDisplayModeKHR              displayMode;
//    VkDisplayModeParametersKHR    parameters;
//} VkDisplayModePropertiesKHR;
//
//typedef struct VkDisplayModeCreateInfoKHR {
//    VkStructureType                sType;
//    const void*                    pNext;
//    VkDisplayModeCreateFlagsKHR    flags;
//    VkDisplayModeParametersKHR     parameters;
//} VkDisplayModeCreateInfoKHR;
//
//typedef struct VkDisplayPlaneCapabilitiesKHR {
//    VkDisplayPlaneAlphaFlagsKHR    supportedAlpha;
//    VkOffset2D                     minSrcPosition;
//    VkOffset2D                     maxSrcPosition;
//    VkExtent2D                     minSrcExtent;
//    VkExtent2D                     maxSrcExtent;
//    VkOffset2D                     minDstPosition;
//    VkOffset2D                     maxDstPosition;
//    VkExtent2D                     minDstExtent;
//    VkExtent2D                     maxDstExtent;
//} VkDisplayPlaneCapabilitiesKHR;
//
//typedef struct VkDisplayPlanePropertiesKHR {
//    VkDisplayKHR    currentDisplay;
//    uint32_t        currentStackIndex;
//} VkDisplayPlanePropertiesKHR;
//
//typedef struct VkDisplaySurfaceCreateInfoKHR {
//    VkStructureType                   sType;
//    const void*                       pNext;
//    VkDisplaySurfaceCreateFlagsKHR    flags;
//    VkDisplayModeKHR                  displayMode;
//    uint32_t                          planeIndex;
//    uint32_t                          planeStackIndex;
//    VkSurfaceTransformFlagBitsKHR     transform;
//    float                             globalAlpha;
//    VkDisplayPlaneAlphaFlagBitsKHR    alphaMode;
//    VkExtent2D                        imageExtent;
//} VkDisplaySurfaceCreateInfoKHR;
//
//
//typedef VkResult (VKAPI_PTR *PFN_vkGetPhysicalDeviceDisplayPropertiesKHR)(VkPhysicalDevice physicalDevice, uint32_t* pPropertyCount, VkDisplayPropertiesKHR* pProperties);
//typedef VkResult (VKAPI_PTR *PFN_vkGetPhysicalDeviceDisplayPlanePropertiesKHR)(VkPhysicalDevice physicalDevice, uint32_t* pPropertyCount, VkDisplayPlanePropertiesKHR* pProperties);
//typedef VkResult (VKAPI_PTR *PFN_vkGetDisplayPlaneSupportedDisplaysKHR)(VkPhysicalDevice physicalDevice, uint32_t planeIndex, uint32_t* pDisplayCount, VkDisplayKHR* pDisplays);
//typedef VkResult (VKAPI_PTR *PFN_vkGetDisplayModePropertiesKHR)(VkPhysicalDevice physicalDevice, VkDisplayKHR display, uint32_t* pPropertyCount, VkDisplayModePropertiesKHR* pProperties);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateDisplayModeKHR)(VkPhysicalDevice physicalDevice, VkDisplayKHR display, const VkDisplayModeCreateInfoKHR* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkDisplayModeKHR* pMode);
//typedef VkResult (VKAPI_PTR *PFN_vkGetDisplayPlaneCapabilitiesKHR)(VkPhysicalDevice physicalDevice, VkDisplayModeKHR mode, uint32_t planeIndex, VkDisplayPlaneCapabilitiesKHR* pCapabilities);
//typedef VkResult (VKAPI_PTR *PFN_vkCreateDisplayPlaneSurfaceKHR)(VkInstance instance, const VkDisplaySurfaceCreateInfoKHR* pCreateInfo, const VkAllocationCallbacks* pAllocator, VkSurfaceKHR* pSurface);
//
//#ifndef VK_NO_PROTOTYPES
//VKAPI_ATTR VkResult VKAPI_CALL vkGetPhysicalDeviceDisplayPropertiesKHR(
//VkPhysicalDevice                            physicalDevice,
//uint32_t*                                   pPropertyCount,
//VkDisplayPropertiesKHR*                     pProperties);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetPhysicalDeviceDisplayPlanePropertiesKHR(
//VkPhysicalDevice                            physicalDevice,
//uint32_t*                                   pPropertyCount,
//VkDisplayPlanePropertiesKHR*                pProperties);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetDisplayPlaneSupportedDisplaysKHR(
//VkPhysicalDevice                            physicalDevice,
//uint32_t                                    planeIndex,
//uint32_t*                                   pDisplayCount,
//VkDisplayKHR*                               pDisplays);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetDisplayModePropertiesKHR(
//VkPhysicalDevice                            physicalDevice,
//VkDisplayKHR                                display,
//uint32_t*                                   pPropertyCount,
//VkDisplayModePropertiesKHR*                 pProperties);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateDisplayModeKHR(
//VkPhysicalDevice                            physicalDevice,
//VkDisplayKHR                                display,
//const VkDisplayModeCreateInfoKHR*           pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkDisplayModeKHR*                           pMode);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetDisplayPlaneCapabilitiesKHR(
//VkPhysicalDevice                            physicalDevice,
//VkDisplayModeKHR                            mode,
//uint32_t                                    planeIndex,
//VkDisplayPlaneCapabilitiesKHR*              pCapabilities);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateDisplayPlaneSurfaceKHR(
//VkInstance                                  instance,
//const VkDisplaySurfaceCreateInfoKHR*        pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkSurfaceKHR*                               pSurface);
//#endif
//
//#define VK_KHR_display_swapchain 1
//#define VK_KHR_DISPLAY_SWAPCHAIN_SPEC_VERSION 9
//#define VK_KHR_DISPLAY_SWAPCHAIN_EXTENSION_NAME "VK_KHR_display_swapchain"
//
//typedef struct VkDisplayPresentInfoKHR {
//    VkStructureType    sType;
//    const void*        pNext;
//    VkRect2D           srcRect;
//    VkRect2D           dstRect;
//    VkBool32           persistent;
//} VkDisplayPresentInfoKHR;
//
//