package vkk._10.structs

import kool.Adr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkDispatchIndirectCommand.*

/**
 * Structure specifying a dispatch indirect command.
 *
 * <h5>Description</h5>
 *
 * <p>The members of {@link VkDispatchIndirectCommand} have the same meaning as the corresponding parameters of {@link VK10#vkCmdDispatch CmdDispatch}.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code x} <b>must</b> be less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxComputeWorkGroupCount}[0]</li>
 * <li>{@code y} <b>must</b> be less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxComputeWorkGroupCount}[1]</li>
 * <li>{@code z} <b>must</b> be less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxComputeWorkGroupCount}[2]</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VK10#vkCmdDispatchIndirect CmdDispatchIndirect}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code x} &ndash; the number of local workgroups to dispatch in the X dimension.</li>
 * <li>{@code y} &ndash; the number of local workgroups to dispatch in the Y dimension.</li>
 * <li>{@code z} &ndash; the number of local workgroups to dispatch in the Z dimension.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkDispatchIndirectCommand {
 *     uint32_t x;
 *     uint32_t y;
 *     uint32_t z;
 * }</code></pre>
 */
class DispatchIndirectCommand(
        var x: Int,
        var y: Int,
        var z: Int
) {

    infix fun write(stack: MemoryStack): Adr {
        val adr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
        nx(adr, x)
        ny(adr, y)
        nz(adr, z)
        return adr
    }
}