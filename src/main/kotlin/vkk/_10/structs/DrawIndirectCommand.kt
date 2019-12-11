package vkk._10.structs

import kool.Adr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkDrawIndirectCommand.*

/**
 * Structure specifying a draw indirect command.
 *
 * <h5>Description</h5>
 *
 * <p>The members of {@link VkDrawIndirectCommand} have the same meaning as the similarly named parameters of {@link VK10#vkCmdDraw CmdDraw}.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>For a given vertex buffer binding, any attribute data fetched <b>must</b> be entirely contained within the corresponding vertex buffer binding, as described in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#fxvertex-input">Vertex Input Description</a></li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-drawIndirectFirstInstance">drawIndirectFirstInstance</a> feature is not enabled, {@code firstInstance} <b>must</b> be 0</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VK10#vkCmdDrawIndirect CmdDrawIndirect}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code vertexCount} &ndash; the number of vertices to draw.</li>
 * <li>{@code instanceCount} &ndash; the number of instances to draw.</li>
 * <li>{@code firstVertex} &ndash; the index of the first vertex to draw.</li>
 * <li>{@code firstInstance} &ndash; the instance ID of the first instance to draw.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkDrawIndirectCommand {
 *     uint32_t vertexCount;
 *     uint32_t instanceCount;
 *     uint32_t firstVertex;
 *     uint32_t firstInstance;
 * }</code></pre>
 */
class DrawIndirectCommand(
        var vertexCount: Int,
        var instanceCount: Int,
        var firstVertex: Int = 0,
        var firstInstance: Int = 0
) {

    infix fun write(stack: MemoryStack): Adr {
        val adr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
        nvertexCount(adr, vertexCount)
        ninstanceCount(adr, instanceCount)
        nfirstVertex(adr, firstVertex)
        nfirstInstance(adr, firstInstance)
        return adr
    }
}