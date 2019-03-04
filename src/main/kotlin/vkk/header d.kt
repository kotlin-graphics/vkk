package vkk

import glm_.BYTES
import glm_.bool
import glm_.f
import glm_.i
import glm_.vec2.Vec2
import glm_.vec2.Vec2i
import glm_.vec2.Vec2t
import glm_.vec3.Vec3i
import kool.Ptr
import kool.adr
import org.lwjgl.system.MemoryStack.stackGet
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.vulkan.*
import vkk.entities.*
import java.nio.ByteBuffer
import java.nio.FloatBuffer
import java.nio.IntBuffer
import java.nio.LongBuffer


inline var VkPipelineShaderStageCreateInfo.type: VkStructureType
    get() = VkStructureType(VkPipelineShaderStageCreateInfo.nsType(adr))
    set(value) = VkPipelineShaderStageCreateInfo.nsType(adr, value.i)
inline var VkPipelineShaderStageCreateInfo.next: Ptr
    get() = VkPipelineShaderStageCreateInfo.npNext(adr)
    set(value) = VkPipelineShaderStageCreateInfo.npNext(adr, value)
inline var VkPipelineShaderStageCreateInfo.flags: VkPipelineShaderStageCreateFlags
    get() = VkPipelineShaderStageCreateInfo.nflags(adr)
    set(value) = VkPipelineShaderStageCreateInfo.nflags(adr, value)
inline var VkPipelineShaderStageCreateInfo.stage: VkShaderStage
    get() = VkShaderStage(VkPipelineShaderStageCreateInfo.nstage(adr))
    set(value) = VkPipelineShaderStageCreateInfo.nstage(adr, value.i)
inline var VkPipelineShaderStageCreateInfo.module: VkShaderModule
    get() = VkShaderModule(VkPipelineShaderStageCreateInfo.nmodule(adr))
    set(value) = VkPipelineShaderStageCreateInfo.nmodule(adr, value.L)
/** JVM custom */
inline var VkPipelineShaderStageCreateInfo.name: String
    get() = VkPipelineShaderStageCreateInfo.npNameString(adr)
    set(value) = VkPipelineShaderStageCreateInfo.npName(adr, value.toUtf8Stack())
inline var VkPipelineShaderStageCreateInfo.pName: ByteBuffer
    get() = VkPipelineShaderStageCreateInfo.npName(adr)
    set(value) = VkPipelineShaderStageCreateInfo.npName(adr, value)
inline var VkPipelineShaderStageCreateInfo.specializationInfo: VkSpecializationInfo?
    get() = VkPipelineShaderStageCreateInfo.npSpecializationInfo(adr)
    set(value) = VkPipelineShaderStageCreateInfo.npSpecializationInfo(adr, value)


inline var VkVertexInputBindingDescription.binding: Int
    get() = VkVertexInputBindingDescription.nbinding(adr)
    set(value) = VkVertexInputBindingDescription.nbinding(adr, value)
inline var VkVertexInputBindingDescription.stride: Int
    get() = VkVertexInputBindingDescription.nstride(adr)
    set(value) = VkVertexInputBindingDescription.nstride(adr, value)
inline var VkVertexInputBindingDescription.inputRate: VkVertexInputRate
    get() = VkVertexInputRate(VkVertexInputBindingDescription.ninputRate(adr))
    set(value) = VkVertexInputBindingDescription.ninputRate(adr, value.i)


inline var VkVertexInputAttributeDescription.location: Int
    get() = VkVertexInputAttributeDescription.nlocation(adr)
    set(value) = VkVertexInputAttributeDescription.nlocation(adr, value)
inline var VkVertexInputAttributeDescription.binding: Int
    get() = VkVertexInputAttributeDescription.nbinding(adr)
    set(value) = VkVertexInputAttributeDescription.nbinding(adr, value)
inline var VkVertexInputAttributeDescription.format: VkFormat
    get() = VkFormat(VkVertexInputAttributeDescription.nformat(adr))
    set(value) = VkVertexInputAttributeDescription.nformat(adr, value.i)
inline var VkVertexInputAttributeDescription.offset: Int
    get() = VkVertexInputAttributeDescription.noffset(adr)
    set(value) = VkVertexInputAttributeDescription.noffset(adr, value)


inline var VkPipelineVertexInputStateCreateInfo.type: VkStructureType
    get() = VkStructureType(VkPipelineVertexInputStateCreateInfo.nsType(adr))
    set(value) = VkPipelineVertexInputStateCreateInfo.nsType(adr, value.i)
inline var VkPipelineVertexInputStateCreateInfo.next: Ptr
    get() = VkPipelineVertexInputStateCreateInfo.npNext(adr)
    set(value) = VkPipelineVertexInputStateCreateInfo.npNext(adr, value)
inline var VkPipelineVertexInputStateCreateInfo.flags: VkPipelineVertexInputStateCreateFlags
    get() = VkPipelineVertexInputStateCreateInfo.nflags(adr)
    set(value) = VkPipelineVertexInputStateCreateInfo.nflags(adr, value)
@Deprecated("this will be set automatically")
inline var VkPipelineVertexInputStateCreateInfo.vertexBindingDescriptionCount: Int
    get() = VkPipelineVertexInputStateCreateInfo.nvertexBindingDescriptionCount(adr)
    set(value) = VkPipelineVertexInputStateCreateInfo.nvertexBindingDescriptionCount(adr, value)
inline var VkPipelineVertexInputStateCreateInfo.vertexBindingDescriptions: VkVertexInputBindingDescription.Buffer?
    get() = VkPipelineVertexInputStateCreateInfo.npVertexBindingDescriptions(adr)
    set(value) = VkPipelineVertexInputStateCreateInfo.npVertexBindingDescriptions(adr, value)
/** JVM custom */
inline var VkPipelineVertexInputStateCreateInfo.vertexBindingDescription: VkVertexInputBindingDescription?
    get() = VkVertexInputBindingDescription.createSafe(memGetAddress(adr + VkPipelineVertexInputStateCreateInfo.PVERTEXBINDINGDESCRIPTIONS))
    set(value) {
        memPutAddress(adr + VkPipelineVertexInputStateCreateInfo.PVERTEXBINDINGDESCRIPTIONS, memAddressSafe(value))
        vertexBindingDescriptionCount = if (value == null) 0 else 1
    }
@Deprecated("this will be set automatically")
inline var VkPipelineVertexInputStateCreateInfo.vertexAttributeDescriptionCount: Int
    get() = VkPipelineVertexInputStateCreateInfo.nvertexAttributeDescriptionCount(adr)
    set(value) = VkPipelineVertexInputStateCreateInfo.nvertexBindingDescriptionCount(adr, value)
inline var VkPipelineVertexInputStateCreateInfo.vertexAttributeDescriptions: VkVertexInputAttributeDescription.Buffer?
    get() = VkPipelineVertexInputStateCreateInfo.npVertexAttributeDescriptions(adr)
    set(value) = VkPipelineVertexInputStateCreateInfo.npVertexAttributeDescriptions(adr, value)


inline var VkPipelineInputAssemblyStateCreateInfo.type: VkStructureType
    get() = VkStructureType(VkPipelineInputAssemblyStateCreateInfo.nsType(adr))
    set(value) = VkPipelineInputAssemblyStateCreateInfo.nsType(adr, value.i)
inline var VkPipelineInputAssemblyStateCreateInfo.next: Ptr
    get() = VkPipelineInputAssemblyStateCreateInfo.npNext(adr)
    set(value) = VkPipelineInputAssemblyStateCreateInfo.npNext(adr, value)
inline var VkPipelineInputAssemblyStateCreateInfo.flags: VkPipelineInputAssemblyStateCreateFlags
    get() = VkPipelineInputAssemblyStateCreateInfo.nflags(adr)
    set(value) = VkPipelineInputAssemblyStateCreateInfo.nflags(adr, value)
inline var VkPipelineInputAssemblyStateCreateInfo.topology: VkPrimitiveTopology
    get() = VkPrimitiveTopology(VkPipelineInputAssemblyStateCreateInfo.ntopology(adr))
    set(value) = VkPipelineInputAssemblyStateCreateInfo.ntopology(adr, value.i)
inline var VkPipelineInputAssemblyStateCreateInfo.primitiveRestartEnable: Boolean
    get() = VkPipelineInputAssemblyStateCreateInfo.nprimitiveRestartEnable(adr).bool
    set(value) = VkPipelineInputAssemblyStateCreateInfo.nprimitiveRestartEnable(adr, value.i)


inline var VkPipelineTessellationStateCreateInfo.type: VkStructureType
    get() = VkStructureType(VkPipelineTessellationStateCreateInfo.nsType(adr))
    set(value) = VkPipelineTessellationStateCreateInfo.nsType(adr, value.i)
inline var VkPipelineTessellationStateCreateInfo.next: Ptr
    get() = VkPipelineTessellationStateCreateInfo.npNext(adr)
    set(value) = VkPipelineTessellationStateCreateInfo.npNext(adr, value)
inline var VkPipelineTessellationStateCreateInfo.flags: VkPipelineTessellationStateCreateFlags
    get() = VkPipelineTessellationStateCreateInfo.nflags(adr)
    set(value) = VkPipelineTessellationStateCreateInfo.nflags(adr, value)
inline var VkPipelineTessellationStateCreateInfo.patchControlPoints: Int
    get() = VkPipelineTessellationStateCreateInfo.npatchControlPoints(adr)
    set(value) = VkPipelineTessellationStateCreateInfo.npatchControlPoints(adr, value)


inline var VkViewport.x: Float
    get() = VkViewport.nx(adr)
    set(value) = VkViewport.nx(adr, value)
inline var VkViewport.y: Float
    get() = VkViewport.ny(adr)
    set(value) = VkViewport.ny(adr, value)
inline var VkViewport.width: Float
    get() = VkViewport.nwidth(adr)
    set(value) = VkViewport.nwidth(adr, value)
inline var VkViewport.height: Float
    get() = VkViewport.nheight(adr)
    set(value) = VkViewport.nheight(adr, value)
inline var VkViewport.minDepth: Float
    get() = VkViewport.nminDepth(adr)
    set(value) = VkViewport.nminDepth(adr, value)
inline var VkViewport.maxDepth: Float
    get() = VkViewport.nmaxDepth(adr)
    set(value) = VkViewport.nmaxDepth(adr, value)

/** JVM custom */
fun VkViewport.offset(f: Float) = offset(f, f)

/** JVM custom */
fun VkViewport.offset(x: Float, y: Float) {
    this.x = x
    this.y = y
}

/** JVM custom */
fun VkViewport.size(size: Vec2i) {
    width = size.x.f
    height = size.y.f
}

/** JVM custom */
fun VkViewport.depth(minDepth: Float, maxDepth: Float) {
    this.minDepth = minDepth
    this.maxDepth = maxDepth
}

inline var VkViewport.offset: Vec2
    get() = Vec2(x, y)
    set(value) {
        x = value.x
        y = value.y
    }

fun VkViewport.size(size: Vec2t<out Number>) {
    width = size.x.f
    height = size.y.f
}

inline var VkViewport.size: Vec2
    get() = Vec2(width, height)
    set(value) {
        width = value.x
        height = value.y
    }
inline var VkViewport.depth: Vec2
    get() = Vec2(minDepth, maxDepth)
    set(value) {
        minDepth = value.x
        maxDepth = value.y
    }


inline var VkOffset2D.x: Int
    get() = VkOffset2D.nx(adr)
    set(value) = VkOffset2D.nx(adr, value)
inline var VkOffset2D.y: Int
    get() = VkOffset2D.ny(adr)
    set(value) = VkOffset2D.ny(adr, value)

operator fun VkOffset2D.invoke(size: Vec2i) = invoke(size.x, size.y)
operator fun VkOffset2D.invoke(x: Int, y: Int) {
    this.x = x
    this.y = y
}


inline var VkExtent2D.width: Int
    get() = VkExtent2D.nwidth(adr)
    set(value) = VkExtent2D.nwidth(adr, value)
inline var VkExtent2D.height: Int
    get() = VkExtent2D.nheight(adr)
    set(value) = VkExtent2D.nheight(adr, value)
var VkExtent2D.size: Vec2i
    get() = Vec2i(width, height)
    set(value) {
        width = value.x
        height = value.y
    }

operator fun VkExtent2D.invoke(size: Vec2i) = invoke(size.x, size.y)
operator fun VkExtent2D.invoke(width: Int, height: Int) {
    this.width = width
    this.height = height
}


inline var VkRect2D.offset: VkOffset2D
    get() = VkRect2D.noffset(adr)
    set(value) = VkRect2D.noffset(adr, value)
inline var VkRect2D.extent: VkExtent2D
    get() = VkRect2D.nextent(adr)
    set(value) = VkRect2D.nextent(adr, value)

/** JVM custom */
fun VkRect2D.offset(offset: Int) = offset(offset, offset)

/** JVM custom */
fun VkRect2D.offset(x: Int, y: Int) {
    offset.x = x
    offset.y = y
}

/** JVM custom */
fun VkRect2D.extent(size: Vec2i) = extent(size.x, size.y)

/** JVM custom */
fun VkRect2D.extent(width: Int, height: Int) {
    extent.width = width
    extent.height = height
}

/** JVM custom */
fun VkRect2D.extent(width: Number, height: Number) = extent(width.i, height.i)

/** JVM custom */
fun VkRect2D.offset(width: Number, height: Number) = offset(width.i, height.i)


inline var VkPipelineViewportStateCreateInfo.type: VkStructureType
    get() = VkStructureType(VkPipelineViewportStateCreateInfo.nsType(adr))
    set(value) = VkPipelineViewportStateCreateInfo.nsType(adr, value.i)
inline var VkPipelineViewportStateCreateInfo.next: Ptr
    get() = VkPipelineViewportStateCreateInfo.npNext(adr)
    set(value) = VkPipelineViewportStateCreateInfo.npNext(adr, value)
inline var VkPipelineViewportStateCreateInfo.flags: VkPipelineViewportStateCreateFlags
    get() = VkPipelineViewportStateCreateInfo.nflags(adr)
    set(value) = VkPipelineViewportStateCreateInfo.nflags(adr, value)
@Deprecated("this will be set automatically")
inline var VkPipelineViewportStateCreateInfo.viewportCount: Int
    get() = VkPipelineViewportStateCreateInfo.nviewportCount(adr)
    set(value) = VkPipelineViewportStateCreateInfo.nviewportCount(adr, value)
inline var VkPipelineViewportStateCreateInfo.viewports: VkViewport.Buffer?
    get() = VkPipelineViewportStateCreateInfo.npViewports(adr)
    set(value) = VkPipelineViewportStateCreateInfo.npViewports(adr, value)
@Deprecated("this will be set automatically")
inline var VkPipelineViewportStateCreateInfo.scissorCount: Int
    get() = VkPipelineViewportStateCreateInfo.nscissorCount(adr)
    set(value) = VkPipelineViewportStateCreateInfo.nscissorCount(adr, value)
inline var VkPipelineViewportStateCreateInfo.scissors: VkRect2D.Buffer?
    get() = VkPipelineViewportStateCreateInfo.npScissors(adr)
    set(value) = VkPipelineViewportStateCreateInfo.npScissors(adr, value)


inline var VkPipelineRasterizationStateCreateInfo.type: VkStructureType
    get() = VkStructureType(VkPipelineRasterizationStateCreateInfo.nsType(adr))
    set(value) = VkPipelineRasterizationStateCreateInfo.nsType(adr, value.i)
inline var VkPipelineRasterizationStateCreateInfo.next: Ptr
    get() = VkPipelineRasterizationStateCreateInfo.npNext(adr)
    set(value) = VkPipelineRasterizationStateCreateInfo.npNext(adr, value)
inline var VkPipelineRasterizationStateCreateInfo.flags: VkPipelineRasterizationStateCreateFlags
    get() = VkPipelineRasterizationStateCreateInfo.nflags(adr)
    set(value) = VkPipelineRasterizationStateCreateInfo.nflags(adr, value)
inline var VkPipelineRasterizationStateCreateInfo.depthClampEnable: Boolean
    get() = VkPipelineRasterizationStateCreateInfo.ndepthClampEnable(adr).bool
    set(value) = VkPipelineRasterizationStateCreateInfo.ndepthClampEnable(adr, value.i)
inline var VkPipelineRasterizationStateCreateInfo.rasterizerDiscardEnable: Boolean
    get() = VkPipelineRasterizationStateCreateInfo.nrasterizerDiscardEnable(adr).bool
    set(value) = VkPipelineRasterizationStateCreateInfo.nrasterizerDiscardEnable(adr, value.i)
inline var VkPipelineRasterizationStateCreateInfo.polygonMode: VkPolygonMode
    get() = VkPolygonMode(VkPipelineRasterizationStateCreateInfo.npolygonMode(adr))
    set(value) = VkPipelineRasterizationStateCreateInfo.npolygonMode(adr, value.i)
inline var VkPipelineRasterizationStateCreateInfo.cullMode: VkCullModeFlags
    get() = VkPipelineRasterizationStateCreateInfo.ncullMode(adr)
    set(value) = VkPipelineRasterizationStateCreateInfo.ncullMode(adr, value)
inline var VkPipelineRasterizationStateCreateInfo.frontFace: VkFrontFace
    get() = VkFrontFace(VkPipelineRasterizationStateCreateInfo.nfrontFace(adr))
    set(value) = VkPipelineRasterizationStateCreateInfo.nfrontFace(adr, value.i)
inline var VkPipelineRasterizationStateCreateInfo.depthBiasEnable: Boolean
    get() = VkPipelineRasterizationStateCreateInfo.ndepthBiasEnable(adr).bool
    set(value) = VkPipelineRasterizationStateCreateInfo.ndepthBiasEnable(adr, value.i)
inline var VkPipelineRasterizationStateCreateInfo.depthBiasConstantFactor: Float
    get() = VkPipelineRasterizationStateCreateInfo.ndepthBiasConstantFactor(adr)
    set(value) = VkPipelineRasterizationStateCreateInfo.ndepthBiasConstantFactor(adr, value)
inline var VkPipelineRasterizationStateCreateInfo.depthBiasClamp: Float
    get() = VkPipelineRasterizationStateCreateInfo.ndepthBiasClamp(adr)
    set(value) = VkPipelineRasterizationStateCreateInfo.ndepthBiasClamp(adr, value)
inline var VkPipelineRasterizationStateCreateInfo.depthBiasSlopeFactor: Float
    get() = VkPipelineRasterizationStateCreateInfo.ndepthBiasSlopeFactor(adr)
    set(value) = VkPipelineRasterizationStateCreateInfo.ndepthBiasSlopeFactor(adr, value)
inline var VkPipelineRasterizationStateCreateInfo.lineWidth: Float
    get() = VkPipelineRasterizationStateCreateInfo.nlineWidth(adr)
    set(value) = VkPipelineRasterizationStateCreateInfo.nlineWidth(adr, value)


inline var VkPipelineMultisampleStateCreateInfo.type: VkStructureType
    get() = VkStructureType(VkPipelineMultisampleStateCreateInfo.nsType(adr))
    set(value) = VkPipelineMultisampleStateCreateInfo.nsType(adr, value.i)
inline var VkPipelineMultisampleStateCreateInfo.next: Ptr
    get() = VkPipelineMultisampleStateCreateInfo.npNext(adr)
    set(value) = VkPipelineMultisampleStateCreateInfo.npNext(adr, value)
inline var VkPipelineMultisampleStateCreateInfo.flags: VkPipelineMultisampleStateCreateFlags
    get() = VkPipelineMultisampleStateCreateInfo.nflags(adr)
    set(value) = VkPipelineMultisampleStateCreateInfo.nflags(adr, value)
inline var VkPipelineMultisampleStateCreateInfo.rasterizationSamples: VkSampleCount
    get() = VkSampleCount(VkPipelineMultisampleStateCreateInfo.nrasterizationSamples(adr))
    set(value) = VkPipelineMultisampleStateCreateInfo.nrasterizationSamples(adr, value.i)
inline var VkPipelineMultisampleStateCreateInfo.sampleShadingEnable: Boolean
    get() = VkPipelineMultisampleStateCreateInfo.nsampleShadingEnable(adr).bool
    set(value) = VkPipelineMultisampleStateCreateInfo.nsampleShadingEnable(adr, value.i)
inline var VkPipelineMultisampleStateCreateInfo.minSampleShading: Float
    get() = VkPipelineMultisampleStateCreateInfo.nminSampleShading(adr)
    set(value) = VkPipelineMultisampleStateCreateInfo.nminSampleShading(adr, value)
/** https://stackoverflow.com/a/38863042/1047713
 *  If pSampleMask is not NULL, pSampleMask must be a valid pointer to an array of rasterizationSamples/32 VkSampleMask values
 *  JVM custom  */
inline var VkPipelineMultisampleStateCreateInfo.samplesMask: IntBuffer? // TODO VkSampleMask?
    get() = memIntBufferSafe(memGetAddress(adr + VkPipelineMultisampleStateCreateInfo.PSAMPLEMASK), 2)
    set(value) = memPutAddress(adr + VkPipelineMultisampleStateCreateInfo.PSAMPLEMASK, memAddressSafe(value))
/**  JVM custom  */
inline var VkPipelineMultisampleStateCreateInfo.sampleMask: Int? // TODO VkSampleMask?
    get() {
        val adr = memGetAddress(adr + VkPipelineMultisampleStateCreateInfo.PSAMPLEMASK)
        return if(adr == NULL) null else memGetInt(adr)
    }
    set(value) {
        val pMask = when(value) {
            null -> NULL
            else -> stackGet().nmalloc(4, Int.BYTES).also { memPutInt (it, value) }
        }
        memPutAddress(adr + VkPipelineMultisampleStateCreateInfo.PSAMPLEMASK, pMask)
    }
inline var VkPipelineMultisampleStateCreateInfo.alphaToCoverageEnable: Boolean
    get() = VkPipelineMultisampleStateCreateInfo.nalphaToCoverageEnable(adr).bool
    set(value) = VkPipelineMultisampleStateCreateInfo.nalphaToCoverageEnable(adr, value.i)
inline var VkPipelineMultisampleStateCreateInfo.alphaToOneEnable: Boolean
    get() = VkPipelineMultisampleStateCreateInfo.nalphaToOneEnable(adr).bool
    set(value) = VkPipelineMultisampleStateCreateInfo.nalphaToOneEnable(adr, value.i)


inline var VkStencilOpState.failOp: VkStencilOp
    get() = VkStencilOp(VkStencilOpState.nfailOp(adr))
    set(value) = VkStencilOpState.nfailOp(adr, value.i)
inline var VkStencilOpState.passOp: VkStencilOp
    get() = VkStencilOp(VkStencilOpState.npassOp(adr))
    set(value) = VkStencilOpState.npassOp(adr, value.i)
inline var VkStencilOpState.depthFailOp: VkStencilOp
    get() = VkStencilOp(VkStencilOpState.ndepthFailOp(adr))
    set(value) = VkStencilOpState.ndepthFailOp(adr, value.i)
inline var VkStencilOpState.compareOp: VkCompareOp
    get() = VkCompareOp(VkStencilOpState.ncompareOp(adr))
    set(value) = VkStencilOpState.ncompareOp(adr, value.i)
inline var VkStencilOpState.compareMask: Int
    get() = VkStencilOpState.ncompareMask(adr)
    set(value) = VkStencilOpState.ncompareMask(adr, value)
inline var VkStencilOpState.writeMask: Int
    get() = VkStencilOpState.nwriteMask(adr)
    set(value) = VkStencilOpState.nwriteMask(adr, value)
inline var VkStencilOpState.reference: Int
    get() = VkStencilOpState.nreference(adr)
    set(value) = VkStencilOpState.nreference(adr, value)


inline var VkPipelineDepthStencilStateCreateInfo.type: VkStructureType
    get() = VkStructureType(VkPipelineDepthStencilStateCreateInfo.nsType(adr))
    set(value) = VkPipelineDepthStencilStateCreateInfo.nsType(adr, value.i)
inline var VkPipelineDepthStencilStateCreateInfo.next: Ptr
    get() = VkPipelineDepthStencilStateCreateInfo.npNext(adr)
    set(value) = VkPipelineDepthStencilStateCreateInfo.npNext(adr, value)
inline var VkPipelineDepthStencilStateCreateInfo.flags: VkPipelineDepthStencilStateCreateFlags
    get() = VkPipelineDepthStencilStateCreateInfo.nflags(adr)
    set(value) = VkPipelineDepthStencilStateCreateInfo.nflags(adr, value)
inline var VkPipelineDepthStencilStateCreateInfo.depthTestEnable: Boolean
    get() = VkPipelineDepthStencilStateCreateInfo.ndepthTestEnable(adr).bool
    set(value) = VkPipelineDepthStencilStateCreateInfo.ndepthTestEnable(adr, value.i)
inline var VkPipelineDepthStencilStateCreateInfo.depthWriteEnable: Boolean
    get() = VkPipelineDepthStencilStateCreateInfo.ndepthWriteEnable(adr).bool
    set(value) = VkPipelineDepthStencilStateCreateInfo.ndepthWriteEnable(adr, value.i)
inline var VkPipelineDepthStencilStateCreateInfo.depthCompareOp: VkCompareOp
    get() = VkCompareOp(VkPipelineDepthStencilStateCreateInfo.ndepthCompareOp(adr))
    set(value) = VkPipelineDepthStencilStateCreateInfo.ndepthCompareOp(adr, value.i)
inline var VkPipelineDepthStencilStateCreateInfo.depthBoundsTestEnable: Boolean
    get() = VkPipelineDepthStencilStateCreateInfo.ndepthBoundsTestEnable(adr).bool
    set(value) = VkPipelineDepthStencilStateCreateInfo.ndepthBoundsTestEnable(adr, value.i)
inline var VkPipelineDepthStencilStateCreateInfo.stencilTestEnable: Boolean
    get() = VkPipelineDepthStencilStateCreateInfo.nstencilTestEnable(adr).bool
    set(value) = VkPipelineDepthStencilStateCreateInfo.nstencilTestEnable(adr, value.i)
inline var VkPipelineDepthStencilStateCreateInfo.front: VkStencilOpState
    get() = VkPipelineDepthStencilStateCreateInfo.nfront(adr)
    set(value) = VkPipelineDepthStencilStateCreateInfo.nfront(adr, value)
inline var VkPipelineDepthStencilStateCreateInfo.back: VkStencilOpState
    get() = VkPipelineDepthStencilStateCreateInfo.nback(adr)
    set(value) = VkPipelineDepthStencilStateCreateInfo.nback(adr, value)
inline var VkPipelineDepthStencilStateCreateInfo.minDepthBounds: Float
    get() = VkPipelineDepthStencilStateCreateInfo.nminDepthBounds(adr)
    set(value) = VkPipelineDepthStencilStateCreateInfo.nminDepthBounds(adr, value)
inline var VkPipelineDepthStencilStateCreateInfo.maxDepthBounds: Float
    get() = VkPipelineDepthStencilStateCreateInfo.nmaxDepthBounds(adr)
    set(value) = VkPipelineDepthStencilStateCreateInfo.nmaxDepthBounds(adr, value)


inline var VkPipelineColorBlendAttachmentState.blendEnable: Boolean
    get() = VkPipelineColorBlendAttachmentState.nblendEnable(adr).bool
    set(value) = VkPipelineColorBlendAttachmentState.nblendEnable(adr, value.i)
inline var VkPipelineColorBlendAttachmentState.srcColorBlendFactor: VkBlendFactor
    get() = VkBlendFactor(VkPipelineColorBlendAttachmentState.nsrcColorBlendFactor(adr))
    set(value) = VkPipelineColorBlendAttachmentState.nsrcColorBlendFactor(adr, value.i)
inline var VkPipelineColorBlendAttachmentState.dstColorBlendFactor: VkBlendFactor
    get() = VkBlendFactor(VkPipelineColorBlendAttachmentState.ndstColorBlendFactor(adr))
    set(value) = VkPipelineColorBlendAttachmentState.ndstColorBlendFactor(adr, value.i)
inline var VkPipelineColorBlendAttachmentState.colorBlendOp: VkBlendOp
    get() = VkBlendOp(VkPipelineColorBlendAttachmentState.ncolorBlendOp(adr))
    set(value) = VkPipelineColorBlendAttachmentState.ncolorBlendOp(adr, value.i)
inline var VkPipelineColorBlendAttachmentState.srcAlphaBlendFactor: VkBlendFactor
    get() = VkBlendFactor(VkPipelineColorBlendAttachmentState.nsrcAlphaBlendFactor(adr))
    set(value) = VkPipelineColorBlendAttachmentState.nsrcAlphaBlendFactor(adr, value.i)
inline var VkPipelineColorBlendAttachmentState.dstAlphaBlendFactor: VkBlendFactor
    get() = VkBlendFactor(VkPipelineColorBlendAttachmentState.ndstAlphaBlendFactor(adr))
    set(value) = VkPipelineColorBlendAttachmentState.ndstAlphaBlendFactor(adr, value.i)
inline var VkPipelineColorBlendAttachmentState.alphaBlendOp: VkBlendOp
    get() = VkBlendOp(VkPipelineColorBlendAttachmentState.nalphaBlendOp(adr))
    set(value) = VkPipelineColorBlendAttachmentState.nalphaBlendOp(adr, value.i)
inline var VkPipelineColorBlendAttachmentState.colorWriteMask: VkColorComponentFlags
    get() = VkPipelineColorBlendAttachmentState.ncolorWriteMask(adr)
    set(value) = VkPipelineColorBlendAttachmentState.ncolorWriteMask(adr, value)


inline var VkPipelineColorBlendStateCreateInfo.type: VkStructureType
    get() = VkStructureType(VkPipelineColorBlendStateCreateInfo.nsType(adr))
    set(value) = VkPipelineColorBlendStateCreateInfo.nsType(adr, value.i)
inline var VkPipelineColorBlendStateCreateInfo.next: Ptr
    get() = VkPipelineColorBlendStateCreateInfo.npNext(adr)
    set(value) = VkPipelineColorBlendStateCreateInfo.npNext(adr, value)
inline var VkPipelineColorBlendStateCreateInfo.flags: VkPipelineColorBlendStateCreateFlags
    get() = VkPipelineColorBlendStateCreateInfo.nflags(adr)
    set(value) = VkPipelineColorBlendStateCreateInfo.nflags(adr, value)
inline var VkPipelineColorBlendStateCreateInfo.logicOpEnable: Boolean
    get() = VkPipelineColorBlendStateCreateInfo.nlogicOpEnable(adr).bool
    set(value) = VkPipelineColorBlendStateCreateInfo.nlogicOpEnable(adr, value.i)
inline var VkPipelineColorBlendStateCreateInfo.logicOp: VkLogicOp
    get() = VkLogicOp(VkPipelineColorBlendStateCreateInfo.nlogicOp(adr))
    set(value) = VkPipelineColorBlendStateCreateInfo.nlogicOp(adr, value.i)
@Deprecated("this will be set automatically")
inline var VkPipelineColorBlendStateCreateInfo.attachmentCount: Int
    get() = VkPipelineColorBlendStateCreateInfo.nattachmentCount(adr)
    set(value) = VkPipelineColorBlendStateCreateInfo.nattachmentCount(adr, value)
inline var VkPipelineColorBlendStateCreateInfo.attachments: VkPipelineColorBlendAttachmentState.Buffer?
    get() = VkPipelineColorBlendStateCreateInfo.npAttachments(adr)
    set(value) = VkPipelineColorBlendStateCreateInfo.npAttachments(adr, value)
/** JVM custom */
inline var VkPipelineColorBlendStateCreateInfo.attachment: VkPipelineColorBlendAttachmentState?
    get() = VkPipelineColorBlendAttachmentState.createSafe(memGetAddress(adr + VkPipelineColorBlendStateCreateInfo.PATTACHMENTS))
    set(value) {
        memPutAddress(adr + VkPipelineColorBlendStateCreateInfo.PATTACHMENTS, memAddressSafe(value))
        attachmentCount = if (value == null) 0 else 1
    }
inline var VkPipelineColorBlendStateCreateInfo.blendConstants: FloatBuffer
    get() = VkPipelineColorBlendStateCreateInfo.nblendConstants(adr)
    set(value) = VkPipelineColorBlendStateCreateInfo.nblendConstants(adr, value)


inline var VkPipelineDynamicStateCreateInfo.type: VkStructureType
    get() = VkStructureType(VkPipelineDynamicStateCreateInfo.nsType(adr))
    set(value) = VkPipelineDynamicStateCreateInfo.nsType(adr, value.i)
inline var VkPipelineDynamicStateCreateInfo.next: Ptr
    get() = VkPipelineDynamicStateCreateInfo.npNext(adr)
    set(value) = VkPipelineDynamicStateCreateInfo.npNext(adr, value)
inline var VkPipelineDynamicStateCreateInfo.flags: VkPipelineDynamicStateCreateFlags
    get() = VkPipelineDynamicStateCreateInfo.nflags(adr)
    set(value) = VkPipelineDynamicStateCreateInfo.nflags(adr, value)
@Deprecated("this will be set automatically")
inline var VkPipelineDynamicStateCreateInfo.dynamicStateCount: Int
    get() = VkPipelineDynamicStateCreateInfo.ndynamicStateCount(adr)
    set(value) = VkPipelineDynamicStateCreateInfo.ndynamicStateCount(adr, value)
inline var VkPipelineDynamicStateCreateInfo.dynamicStates: VkDynamicStateBuffer?
    get() = VkPipelineDynamicStateCreateInfo.npDynamicStates(adr)?.let { VkDynamicStateBuffer(it) }
    set(value) = VkPipelineDynamicStateCreateInfo.npDynamicStates(adr, value?.buffer)


inline var VkGraphicsPipelineCreateInfo.type: VkStructureType
    get() = VkStructureType(VkGraphicsPipelineCreateInfo.nsType(adr))
    set(value) = VkGraphicsPipelineCreateInfo.nsType(adr, value.i)
inline var VkGraphicsPipelineCreateInfo.next: Ptr
    get() = VkGraphicsPipelineCreateInfo.npNext(adr)
    set(value) = VkGraphicsPipelineCreateInfo.npNext(adr, value)
/** JVM custom */
inline var VkGraphicsPipelineCreateInfo.flag: VkPipelineCreate
    get() = throw Exception("Invalid")
    set(value) = VkGraphicsPipelineCreateInfo.nflags(adr, value.i)
inline var VkGraphicsPipelineCreateInfo.flags: VkPipelineCreateFlags
    get() = VkGraphicsPipelineCreateInfo.nflags(adr)
    set(value) = VkGraphicsPipelineCreateInfo.nflags(adr, value)
@Deprecated("this will be set automatically")
inline var VkGraphicsPipelineCreateInfo.stageCount: Int
    get() = VkGraphicsPipelineCreateInfo.nstageCount(adr)
    set(value) = VkGraphicsPipelineCreateInfo.nstageCount(adr, value)
inline var VkGraphicsPipelineCreateInfo.stages: VkPipelineShaderStageCreateInfo.Buffer
    get() = VkGraphicsPipelineCreateInfo.npStages(adr)
    set(value) = VkGraphicsPipelineCreateInfo.npStages(adr, value)
inline var VkGraphicsPipelineCreateInfo.vertexInputState: VkPipelineVertexInputStateCreateInfo?
    get() = VkGraphicsPipelineCreateInfo.npVertexInputState(adr)
    set(value) = VkGraphicsPipelineCreateInfo.npVertexInputState(adr, value)
inline var VkGraphicsPipelineCreateInfo.inputAssemblyState: VkPipelineInputAssemblyStateCreateInfo?
    get() = VkGraphicsPipelineCreateInfo.npInputAssemblyState(adr)
    set(value) = VkGraphicsPipelineCreateInfo.npInputAssemblyState(adr, value)
inline var VkGraphicsPipelineCreateInfo.tessellationState
    get() = VkGraphicsPipelineCreateInfo.npTessellationState(adr)
    set(value) = VkGraphicsPipelineCreateInfo.npTessellationState(adr, value)
inline var VkGraphicsPipelineCreateInfo.viewportState
    get() = VkGraphicsPipelineCreateInfo.npViewportState(adr)
    set(value) = VkGraphicsPipelineCreateInfo.npViewportState(adr, value)
inline var VkGraphicsPipelineCreateInfo.rasterizationState: VkPipelineRasterizationStateCreateInfo
    get() = VkGraphicsPipelineCreateInfo.npRasterizationState(adr)
    set(value) = VkGraphicsPipelineCreateInfo.npRasterizationState(adr, value)
inline var VkGraphicsPipelineCreateInfo.multisampleState
    get() = VkGraphicsPipelineCreateInfo.npMultisampleState(adr)
    set(value) = VkGraphicsPipelineCreateInfo.npMultisampleState(adr, value)
inline var VkGraphicsPipelineCreateInfo.depthStencilState
    get() = VkGraphicsPipelineCreateInfo.npDepthStencilState(adr)
    set(value) = VkGraphicsPipelineCreateInfo.npDepthStencilState(adr, value)
inline var VkGraphicsPipelineCreateInfo.colorBlendState
    get() = VkGraphicsPipelineCreateInfo.npColorBlendState(adr)
    set(value) = VkGraphicsPipelineCreateInfo.npColorBlendState(adr, value)
inline var VkGraphicsPipelineCreateInfo.dynamicState
    get() = VkGraphicsPipelineCreateInfo.npDynamicState(adr)
    set(value) = VkGraphicsPipelineCreateInfo.npDynamicState(adr, value)
inline var VkGraphicsPipelineCreateInfo.layout: VkPipelineLayout
    get() = VkPipelineLayout(VkGraphicsPipelineCreateInfo.nlayout(adr))
    set(value) = VkGraphicsPipelineCreateInfo.nlayout(adr, value.L)
inline var VkGraphicsPipelineCreateInfo.renderPass: VkRenderPass
    get() = VkRenderPass(VkGraphicsPipelineCreateInfo.nrenderPass(adr))
    set(value) = VkGraphicsPipelineCreateInfo.nrenderPass(adr, value.L)
inline var VkGraphicsPipelineCreateInfo.subpass
    get() = VkGraphicsPipelineCreateInfo.nsubpass(adr)
    set(value) = VkGraphicsPipelineCreateInfo.nsubpass(adr, value)
inline var VkGraphicsPipelineCreateInfo.basePipelineHandle: VkPipeline
    get() = VkPipeline(VkGraphicsPipelineCreateInfo.nbasePipelineHandle(adr))
    set(value) = VkGraphicsPipelineCreateInfo.nbasePipelineHandle(adr, value.L)
inline var VkGraphicsPipelineCreateInfo.basePipelineIndex: Int
    get() = VkGraphicsPipelineCreateInfo.nbasePipelineIndex(adr)
    set(value) = VkGraphicsPipelineCreateInfo.nbasePipelineIndex(adr, value)


inline var VkComputePipelineCreateInfo.type: VkStructureType
    get() = VkStructureType(VkComputePipelineCreateInfo.nsType(adr))
    set(value) = VkComputePipelineCreateInfo.nsType(adr, value.i)
inline var VkComputePipelineCreateInfo.next: Ptr
    get() = VkComputePipelineCreateInfo.npNext(adr)
    set(value) = VkComputePipelineCreateInfo.npNext(adr, value)
inline var VkComputePipelineCreateInfo.flags: VkPipelineCreateFlags
    get() = VkComputePipelineCreateInfo.nflags(adr)
    set(value) = VkComputePipelineCreateInfo.nflags(adr, value)
inline var VkComputePipelineCreateInfo.stage: VkPipelineShaderStageCreateInfo
    get() = VkComputePipelineCreateInfo.nstage(adr)
    set(value) = VkComputePipelineCreateInfo.nstage(adr, value)
inline var VkComputePipelineCreateInfo.layout: VkPipelineLayout
    get() = VkPipelineLayout(VkComputePipelineCreateInfo.nlayout(adr))
    set(value) = VkComputePipelineCreateInfo.nlayout(adr, value.L)
inline var VkComputePipelineCreateInfo.basePipelineHandle: VkPipeline
    get() = VkPipeline(VkComputePipelineCreateInfo.nbasePipelineHandle(adr))
    set(value) = VkComputePipelineCreateInfo.nbasePipelineHandle(adr, value.L)
inline var VkComputePipelineCreateInfo.basePipelineIndex: Int
    get() = VkComputePipelineCreateInfo.nbasePipelineIndex(adr)
    set(value) = VkComputePipelineCreateInfo.nbasePipelineIndex(adr, value)


inline var VkPushConstantRange.stageFlags: VkShaderStageFlags
    get() = VkPushConstantRange.nstageFlags(adr)
    set(value) = VkPushConstantRange.nstageFlags(adr, value)
inline var VkPushConstantRange.offset: Int
    get() = VkPushConstantRange.noffset(adr)
    set(value) = VkPushConstantRange.noffset(adr, value)
inline var VkPushConstantRange.size: Int
    get() = VkPushConstantRange.nsize(adr)
    set(value) = VkPushConstantRange.nsize(adr, value)


inline var VkPipelineLayoutCreateInfo.type: VkStructureType
    get() = VkStructureType(VkPipelineLayoutCreateInfo.nsType(adr))
    set(value) = VkPipelineLayoutCreateInfo.nsType(adr, value.i)
inline var VkPipelineLayoutCreateInfo.next: Ptr
    get() = VkPipelineLayoutCreateInfo.npNext(adr)
    set(value) = VkPipelineLayoutCreateInfo.npNext(adr, value)
inline var VkPipelineLayoutCreateInfo.flags: VkPipelineLayoutCreateFlags
    get() = VkPipelineLayoutCreateInfo.nflags(adr)
    set(value) = VkPipelineLayoutCreateInfo.nflags(adr, value)
@Deprecated("this will be set automatically")
inline var VkPipelineLayoutCreateInfo.setLayoutCount: Int
    get() = VkPipelineLayoutCreateInfo.nsetLayoutCount(adr)
    set(value) = VkPipelineLayoutCreateInfo.nsetLayoutCount(adr, value)
inline var VkPipelineLayoutCreateInfo.setLayouts: VkDescriptorSetLayout_Buffer?
    get() = VkPipelineLayoutCreateInfo.npSetLayouts(adr)?.let(::VkDescriptorSetLayout_Buffer)
    set(value) = VkPipelineLayoutCreateInfo.npSetLayouts(adr, value?.buffer)
/** JVM custom */
inline var VkPipelineLayoutCreateInfo.setLayout: VkDescriptorSetLayout?
    get() = VkPipelineLayoutCreateInfo.npSetLayouts(adr)?.let { VkDescriptorSetLayout(it[0]) }
    set(value) {
        val p = when(value) {
            null -> NULL
            else -> stackGet().nmalloc(8, Long.BYTES).also { memPutLong (it, value.L) }
        }
        memPutAddress(adr + VkPipelineLayoutCreateInfo.PSETLAYOUTS, p)
        setLayoutCount = if (value == null) 0 else 1
    }
@Deprecated("this will be set automatically")
inline var VkPipelineLayoutCreateInfo.pushConstantRangeCount: Int
    get() = VkPipelineLayoutCreateInfo.npushConstantRangeCount(adr)
    set(value) = VkPipelineLayoutCreateInfo.npushConstantRangeCount(adr, value)
inline var VkPipelineLayoutCreateInfo.pushConstantRanges: VkPushConstantRange.Buffer?
    get() = VkPipelineLayoutCreateInfo.npPushConstantRanges(adr)
    set(value) = VkPipelineLayoutCreateInfo.npPushConstantRanges(adr, value)
/** JVM Custom */
inline var VkPipelineLayoutCreateInfo.pushConstantRange: VkPushConstantRange?
    get() = VkPushConstantRange.createSafe(memGetAddress(adr + VkPipelineLayoutCreateInfo.PPUSHCONSTANTRANGES))
    set(value) {
        memPutAddress(adr + VkPipelineLayoutCreateInfo.PPUSHCONSTANTRANGES, memAddressSafe(value))
        pushConstantRangeCount = if (value != null) 1 else 0
    }


inline var VkSamplerCreateInfo.type: VkStructureType
    get() = VkStructureType(VkSamplerCreateInfo.nsType(adr))
    set(value) = VkSamplerCreateInfo.nsType(adr, value.i)
inline var VkSamplerCreateInfo.next: Ptr
    get() = VkSamplerCreateInfo.npNext(adr)
    set(value) = VkSamplerCreateInfo.npNext(adr, value)
inline var VkSamplerCreateInfo.flags: VkSamplerCreateFlags
    get() = VkSamplerCreateInfo.nflags(adr)
    set(value) = VkSamplerCreateInfo.nflags(adr, value)
inline var VkSamplerCreateInfo.magFilter: VkFilter
    get() = VkFilter(VkSamplerCreateInfo.nmagFilter(adr))
    set(value) = VkSamplerCreateInfo.nmagFilter(adr, value.i)
inline var VkSamplerCreateInfo.minFilter: VkFilter
    get() = VkFilter(VkSamplerCreateInfo.nminFilter(adr))
    set(value) = VkSamplerCreateInfo.nminFilter(adr, value.i)
/** JVM custom */
inline var VkSamplerCreateInfo.minMagFilter: VkFilter
    get() = throw Error()
    set(value) {
        minFilter = value
        magFilter = value
    }

/** JVM custom */
fun VkSamplerCreateInfo.minMagFilter(min: VkFilter, mag: VkFilter) {
    minFilter = min
    magFilter = mag
}

inline var VkSamplerCreateInfo.mipmapMode: VkSamplerMipmapMode
    get() = VkSamplerMipmapMode(VkSamplerCreateInfo.nmipmapMode(adr))
    set(value) = VkSamplerCreateInfo.nmipmapMode(adr, value.i)
inline var VkSamplerCreateInfo.addressModeU: VkSamplerAddressMode
    get() = VkSamplerAddressMode(VkSamplerCreateInfo.naddressModeU(adr))
    set(value) = VkSamplerCreateInfo.naddressModeU(adr, value.i)
inline var VkSamplerCreateInfo.addressModeV: VkSamplerAddressMode
    get() = VkSamplerAddressMode(VkSamplerCreateInfo.naddressModeV(adr))
    set(value) = VkSamplerCreateInfo.naddressModeV(adr, value.i)
inline var VkSamplerCreateInfo.addressModeW: VkSamplerAddressMode
    get() = VkSamplerAddressMode(VkSamplerCreateInfo.naddressModeW(adr))
    set(value) = VkSamplerCreateInfo.naddressModeW(adr, value.i)
/** JVM custom */
inline var VkSamplerCreateInfo.addressModeUVW: VkSamplerAddressMode
    get() = throw Error()
    set(value) {
        addressModeU = value
        addressModeV = value
        addressModeW = value
    }
inline var VkSamplerCreateInfo.mipLodBias: Float
    get() = VkSamplerCreateInfo.nmipLodBias(adr)
    set(value) = VkSamplerCreateInfo.nmipLodBias(adr, value)
inline var VkSamplerCreateInfo.anisotropyEnable: Boolean
    get() = VkSamplerCreateInfo.nanisotropyEnable(adr).bool
    set(value) = VkSamplerCreateInfo.nanisotropyEnable(adr, value.i)
inline var VkSamplerCreateInfo.maxAnisotropy: Float
    get() = VkSamplerCreateInfo.nmaxAnisotropy(adr)
    set(value) = VkSamplerCreateInfo.nmaxAnisotropy(adr, value)
inline var VkSamplerCreateInfo.compareEnable: Boolean
    get() = VkSamplerCreateInfo.ncompareEnable(adr).bool
    set(value) = VkSamplerCreateInfo.ncompareEnable(adr, value.i)
inline var VkSamplerCreateInfo.compareOp: VkCompareOp
    get() = VkCompareOp(VkSamplerCreateInfo.ncompareOp(adr))
    set(value) = VkSamplerCreateInfo.ncompareOp(adr, value.i)
inline var VkSamplerCreateInfo.minLod: Float
    get() = VkSamplerCreateInfo.nminLod(adr)
    set(value) = VkSamplerCreateInfo.nminLod(adr, value)
inline var VkSamplerCreateInfo.maxLod: Float
    get() = VkSamplerCreateInfo.nmaxLod(adr)
    set(value) = VkSamplerCreateInfo.nmaxLod(adr, value)

/** Custom JVM */
fun VkSamplerCreateInfo.minMaxLod(min: Float, max: Float) {
    minLod = min
    maxLod = max
}

inline var VkSamplerCreateInfo.borderColor: VkBorderColor
    get() = VkBorderColor(VkSamplerCreateInfo.nborderColor(adr))
    set(value) = VkSamplerCreateInfo.nborderColor(adr, value.i)
inline var VkSamplerCreateInfo.unnormalizedCoordinates: Boolean
    get() = VkSamplerCreateInfo.nunnormalizedCoordinates(adr).bool
    set(value) = VkSamplerCreateInfo.nunnormalizedCoordinates(adr, value.i)


inline var VkDescriptorSetLayoutBinding.binding: Int
    get() = VkDescriptorSetLayoutBinding.nbinding(adr)
    set(value) = VkDescriptorSetLayoutBinding.nbinding(adr, value)
inline var VkDescriptorSetLayoutBinding.descriptorType: VkDescriptorType
    get() = VkDescriptorType(VkDescriptorSetLayoutBinding.ndescriptorType(adr))
    set(value) = VkDescriptorSetLayoutBinding.ndescriptorType(adr, value.i)
@Deprecated("this will be set automatically")
inline var VkDescriptorSetLayoutBinding.descriptorCount: Int
    get() = VkDescriptorSetLayoutBinding.ndescriptorCount(adr)
    set(value) = VkDescriptorSetLayoutBinding.ndescriptorCount(adr, value)
/** JVM custom */
inline var VkDescriptorSetLayoutBinding.stageFlag: VkShaderStage
    get() = throw Exception("Invalid")
    set(value) = VkDescriptorSetLayoutBinding.nstageFlags(adr, value.i)
inline var VkDescriptorSetLayoutBinding.stageFlags: VkShaderStageFlags
    get() = VkDescriptorSetLayoutBinding.nstageFlags(adr)
    set(value) = VkDescriptorSetLayoutBinding.nstageFlags(adr, value)
inline var VkDescriptorSetLayoutBinding.immutableSamplers: VkSampler_Buffer?
    get() = VkDescriptorSetLayoutBinding.npImmutableSamplers(adr)?.let(::VkSampler_Buffer)
    set(value) = VkDescriptorSetLayoutBinding.npImmutableSamplers(adr, value?.buffer)
/** JVM custom */
inline var VkDescriptorSetLayoutBinding.immutableSampler: VkSampler?
    get() = VkDescriptorSetLayoutBinding.npImmutableSamplers(adr)?.let { VkSampler(it[0]) }
    set(value) {
        val p = when(value) {
            null -> NULL
            else -> stackGet().nmalloc(8, Long.BYTES).also { memPutLong(it, value.L) }
        }
        memPutAddress(adr + VkDescriptorSetLayoutBinding.PIMMUTABLESAMPLERS, p)
        descriptorCount = if(value == null) 0 else 1
    }


inline var VkDescriptorSetLayoutCreateInfo.type: VkStructureType
    get() = VkStructureType(VkDescriptorSetLayoutCreateInfo.nsType(adr))
    set(value) = VkDescriptorSetLayoutCreateInfo.nsType(adr, value.i)
inline var VkDescriptorSetLayoutCreateInfo.next
    get() = VkDescriptorSetLayoutCreateInfo.npNext(adr)
    set(value) = VkDescriptorSetLayoutCreateInfo.npNext(adr, value)
/** JVM custom */
inline var VkDescriptorSetLayoutCreateInfo.flag: VkDescriptorSetLayoutCreate
    get() = throw Exception("Invalid")
    set(value) = VkDescriptorSetLayoutCreateInfo.nflags(adr, value.i)
inline var VkDescriptorSetLayoutCreateInfo.flags: VkDescriptorSetLayoutCreateFlags
    get() = VkDescriptorSetLayoutCreateInfo.nflags(adr)
    set(value) = VkDescriptorSetLayoutCreateInfo.nflags(adr, value)
@Deprecated("this will be set automatically")
inline var VkDescriptorSetLayoutCreateInfo.bindingCount: Int
    get() = VkDescriptorSetLayoutCreateInfo.nbindingCount(adr)
    set(value) = VkDescriptorSetLayoutCreateInfo.nbindingCount(adr, value)
inline var VkDescriptorSetLayoutCreateInfo.bindings: VkDescriptorSetLayoutBinding.Buffer?
    get() = VkDescriptorSetLayoutCreateInfo.npBindings(adr)
    set(value) = VkDescriptorSetLayoutCreateInfo.npBindings(adr, value)
/** JVM custom */
inline var VkDescriptorSetLayoutCreateInfo.binding: VkDescriptorSetLayoutBinding?
    get() = VkDescriptorSetLayoutBinding.createSafe(memGetAddress(adr + VkDescriptorSetLayoutCreateInfo.PBINDINGS))
    set(value) {
        memPutAddress(adr + VkDescriptorSetLayoutCreateInfo.PBINDINGS, memAddressSafe(value))
        bindingCount = if (value == null) 0 else 1
    }