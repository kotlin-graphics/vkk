package vkk._10.structs

import kool.Adr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkDrawIndexedIndirectCommand.*

/**
 * Structure specifying a draw indexed indirect command.
 *
 * <h5>Description</h5>
 *
 * <p>The members of {@link VkDrawIndexedIndirectCommand} have the same meaning as the similarly named parameters of {@link VK10#vkCmdDrawIndexed CmdDrawIndexed}.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>For a given vertex buffer binding, any attribute data fetched <b>must</b> be entirely contained within the corresponding vertex buffer binding, as described in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#fxvertex-input">Vertex Input Description</a></li>
 * <li><code>(indexSize * (firstIndex + indexCount) offset)</code> <b>must</b> be less than or equal to the size of the bound index buffer, with {@code indexSize} being based on the type specified by {@code indexType}, where the index buffer, {@code indexType}, and {@code offset} are specified via {@code vkCmdBindIndexBuffer}</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-drawIndirectFirstInstance">drawIndirectFirstInstance</a> feature is not enabled, {@code firstInstance} <b>must</b> be 0</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VK10#vkCmdDrawIndexedIndirect CmdDrawIndexedIndirect}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code indexCount} &ndash; the number of vertices to draw.</li>
 * <li>{@code instanceCount} &ndash; the number of instances to draw.</li>
 * <li>{@code firstIndex} &ndash; the base index within the index buffer.</li>
 * <li>{@code vertexOffset} &ndash; the value added to the vertex index before indexing into the vertex buffer.</li>
 * <li>{@code firstInstance} &ndash; the instance ID of the first instance to draw.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkDrawIndexedIndirectCommand {
 *     uint32_t indexCount;
 *     uint32_t instanceCount;
 *     uint32_t firstIndex;
 *     int32_t vertexOffset;
 *     uint32_t firstInstance;
 * }</code></pre>
 */
class DrawIndexedIndirectCommand(
        var indexCount: Int,
        var instanceCount: Int,
        var firstIndex: Int = 0,
        var vertexOffset: Int = 0,
        var firstInstance: Int = 0
) {

    infix fun write(stack: MemoryStack): Adr {
        val adr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
        nindexCount(adr, indexCount)
        ninstanceCount(adr, instanceCount)
        nfirstIndex(adr, firstIndex)
        nvertexOffset(adr, vertexOffset)
        nfirstInstance(adr, firstInstance)
        return adr
    }
}