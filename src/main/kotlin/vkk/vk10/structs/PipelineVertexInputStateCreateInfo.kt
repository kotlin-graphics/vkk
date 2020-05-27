package vkk.vk10.structs

import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.system.MemoryUtil.memPutAddress
import org.lwjgl.vulkan.VkPipelineVertexInputStateCreateInfo.*
import vkk.VkStack
import vkk.VkStructureType

/**
 * Structure specifying parameters of a newly created pipeline vertex input state.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code vertexBindingDescriptionCount} <b>must</b> be less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxVertexInputBindings}</li>
 * <li>{@code vertexAttributeDescriptionCount} <b>must</b> be less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxVertexInputAttributes}</li>
 * <li>For every {@code binding} specified by each element of {@code pVertexAttributeDescriptions}, a {@link VkVertexInputBindingDescription} <b>must</b> exist in {@code pVertexBindingDescriptions} with the same value of {@code binding}</li>
 * <li>All elements of {@code pVertexBindingDescriptions} <b>must</b> describe distinct binding numbers</li>
 * <li>All elements of {@code pVertexAttributeDescriptions} <b>must</b> describe distinct attribute locations</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK10#VK_STRUCTURE_TYPE_PIPELINE_VERTEX_INPUT_STATE_CREATE_INFO STRUCTURE_TYPE_PIPELINE_VERTEX_INPUT_STATE_CREATE_INFO}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL} or a pointer to a valid instance of {@link VkPipelineVertexInputDivisorStateCreateInfoEXT}</li>
 * <li>{@code flags} <b>must</b> be 0</li>
 * <li>If {@code vertexBindingDescriptionCount} is not 0, {@code pVertexBindingDescriptions} <b>must</b> be a valid pointer to an array of {@code vertexBindingDescriptionCount} valid {@link VkVertexInputBindingDescription} structures</li>
 * <li>If {@code vertexAttributeDescriptionCount} is not 0, {@code pVertexAttributeDescriptions} <b>must</b> be a valid pointer to an array of {@code vertexAttributeDescriptionCount} valid {@link VkVertexInputAttributeDescription} structures</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkGraphicsPipelineCreateInfo}, {@link VkVertexInputAttributeDescription}, {@link VkVertexInputBindingDescription}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code flags} &ndash; reserved for future use.</li>
 * <li>{@code vertexBindingDescriptionCount} &ndash; the number of vertex binding descriptions provided in {@code pVertexBindingDescriptions}.</li>
 * <li>{@code pVertexBindingDescriptions} &ndash; a pointer to an array of {@link VkVertexInputBindingDescription} structures.</li>
 * <li>{@code vertexAttributeDescriptionCount} &ndash; the number of vertex attribute descriptions provided in {@code pVertexAttributeDescriptions}.</li>
 * <li>{@code pVertexAttributeDescriptions} &ndash; a pointer to an array of {@link VkVertexInputAttributeDescription} structures.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPipelineVertexInputStateCreateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkPipelineVertexInputStateCreateFlags flags;
 *     uint32_t vertexBindingDescriptionCount;
 *     {@link VkVertexInputBindingDescription VkVertexInputBindingDescription} const * pVertexBindingDescriptions;
 *     uint32_t vertexAttributeDescriptionCount;
 *     {@link VkVertexInputAttributeDescription VkVertexInputAttributeDescription} const * pVertexAttributeDescriptions;
 * }</code></pre>
 */
class PipelineVertexInputStateCreateInfo(
    var vertexBindingDescriptions: Array<VertexInputBindingDescription>? = null,
    var vertexAttributeDescriptions: Array<VertexInputAttributeDescription>? = null,
    var next: Ptr = NULL
) {
    constructor(
        vertexBindingDescription: VertexInputBindingDescription,
        vertexAttributeDescriptions: VertexInputAttributeDescription,
        next: Ptr = NULL
    ) : this(arrayOf(vertexBindingDescription), arrayOf(vertexAttributeDescriptions), next)

    val type get() = VkStructureType.PIPELINE_VERTEX_INPUT_STATE_CREATE_INFO

    infix fun write(stack: VkStack): Adr =
            stack.ncalloc(ALIGNOF, 1, SIZEOF).also { write(it, stack) }

    fun write(ptr: Ptr, stack: VkStack) {
        nsType(ptr, type.i)
        npNext(ptr, next)
        vertexBindingDescriptions?.let {
            nvertexBindingDescriptionCount(ptr, it.size)
            memPutAddress(ptr + PVERTEXBINDINGDESCRIPTIONS, it write stack)
        }
        vertexAttributeDescriptions?.let {
            nvertexAttributeDescriptionCount(ptr, it.size)
            memPutAddress(ptr + PVERTEXATTRIBUTEDESCRIPTIONS, it write stack)
        }
    }
}