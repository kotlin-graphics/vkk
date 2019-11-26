package classes

import glm_.i
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkPipelineInputAssemblyStateCreateInfo
import org.lwjgl.vulkan.VkPipelineInputAssemblyStateCreateInfo.*
import vkk.VkPrimitiveTopology
import vkk.VkStructureType

/**
 * Structure specifying parameters of a newly created pipeline input assembly state.
 *
 * <h5>Description</h5>
 *
 * <p>Restarting the assembly of primitives discards the most recent index values if those elements formed an incomplete primitive, and restarts the primitive assembly using the subsequent indices, but only assembling the immediately following element through the end of the originally specified elements. The primitive restart index value comparison is performed before adding the {@code vertexOffset} value to the index value.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>If {@code topology} is {@link VK10#VK_PRIMITIVE_TOPOLOGY_POINT_LIST PRIMITIVE_TOPOLOGY_POINT_LIST}, {@link VK10#VK_PRIMITIVE_TOPOLOGY_LINE_LIST PRIMITIVE_TOPOLOGY_LINE_LIST}, {@link VK10#VK_PRIMITIVE_TOPOLOGY_TRIANGLE_LIST PRIMITIVE_TOPOLOGY_TRIANGLE_LIST}, {@link VK10#VK_PRIMITIVE_TOPOLOGY_LINE_LIST_WITH_ADJACENCY PRIMITIVE_TOPOLOGY_LINE_LIST_WITH_ADJACENCY}, {@link VK10#VK_PRIMITIVE_TOPOLOGY_TRIANGLE_LIST_WITH_ADJACENCY PRIMITIVE_TOPOLOGY_TRIANGLE_LIST_WITH_ADJACENCY} or {@link VK10#VK_PRIMITIVE_TOPOLOGY_PATCH_LIST PRIMITIVE_TOPOLOGY_PATCH_LIST}, {@code primitiveRestartEnable} <b>must</b> be {@link VK10#VK_FALSE FALSE}</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-geometryShader">geometry shaders</a> feature is not enabled, {@code topology} <b>must</b> not be any of {@link VK10#VK_PRIMITIVE_TOPOLOGY_LINE_LIST_WITH_ADJACENCY PRIMITIVE_TOPOLOGY_LINE_LIST_WITH_ADJACENCY}, {@link VK10#VK_PRIMITIVE_TOPOLOGY_LINE_STRIP_WITH_ADJACENCY PRIMITIVE_TOPOLOGY_LINE_STRIP_WITH_ADJACENCY}, {@link VK10#VK_PRIMITIVE_TOPOLOGY_TRIANGLE_LIST_WITH_ADJACENCY PRIMITIVE_TOPOLOGY_TRIANGLE_LIST_WITH_ADJACENCY} or {@link VK10#VK_PRIMITIVE_TOPOLOGY_TRIANGLE_STRIP_WITH_ADJACENCY PRIMITIVE_TOPOLOGY_TRIANGLE_STRIP_WITH_ADJACENCY}</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-tessellationShader">tessellation shaders</a> feature is not enabled, {@code topology} <b>must</b> not be {@link VK10#VK_PRIMITIVE_TOPOLOGY_PATCH_LIST PRIMITIVE_TOPOLOGY_PATCH_LIST}</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK10#VK_STRUCTURE_TYPE_PIPELINE_INPUT_ASSEMBLY_STATE_CREATE_INFO STRUCTURE_TYPE_PIPELINE_INPUT_ASSEMBLY_STATE_CREATE_INFO}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL}</li>
 * <li>{@code flags} <b>must</b> be 0</li>
 * <li>{@code topology} <b>must</b> be a valid {@code VkPrimitiveTopology} value</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkGraphicsPipelineCreateInfo}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code flags} &ndash; reserved for future use.</li>
 * <li>{@code topology} &ndash; a {@code VkPrimitiveTopology} defining the primitive topology, as described below.</li>
 * <li>{@code primitiveRestartEnable} &ndash; controls whether a special vertex index value is treated as restarting the assembly of primitives. This enable only applies to indexed draws ({@link VK10#vkCmdDrawIndexed CmdDrawIndexed} and {@link VK10#vkCmdDrawIndexedIndirect CmdDrawIndexedIndirect}), and the special index value is either 0xFFFFFFFF when the {@code indexType} parameter of {@code vkCmdBindIndexBuffer} is equal to {@link VK10#VK_INDEX_TYPE_UINT32 INDEX_TYPE_UINT32}, 0xFF when {@code indexType} is equal to {@link EXTIndexTypeUint8#VK_INDEX_TYPE_UINT8_EXT INDEX_TYPE_UINT8_EXT}, or 0xFFFF when {@code indexType} is equal to {@link VK10#VK_INDEX_TYPE_UINT16 INDEX_TYPE_UINT16}. Primitive restart is not allowed for “list” topologies.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPipelineInputAssemblyStateCreateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkPipelineInputAssemblyStateCreateFlags flags;
 *     VkPrimitiveTopology topology;
 *     VkBool32 primitiveRestartEnable;
 * }</code></pre>
 */
class PipelineInputAssemblyStateCreateInfo(
    var topology: VkPrimitiveTopology,
    var primitiveRestartEnable: Boolean = false
) {

    val type get() = VkStructureType.PIPELINE_INPUT_ASSEMBLY_STATE_CREATE_INFO

    val MemoryStack.native: Ptr
        get() = ncalloc(ALIGNOF, 1, SIZEOF).also {
            nsType(it, type.i)
            ntopology(it, topology.i)
            nprimitiveRestartEnable(it, primitiveRestartEnable.i)
        }
}