package vkk._10.structs

import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.system.MemoryUtil.memPutAddress
import org.lwjgl.vulkan.VkCommandBufferBeginInfo.*
import vkk.VkCommandBufferUsageFlags
import vkk.VkStructureType

/**
 * Structure specifying a command buffer begin operation.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>If {@code flags} contains {@link VK10#VK_COMMAND_BUFFER_USAGE_RENDER_PASS_CONTINUE_BIT COMMAND_BUFFER_USAGE_RENDER_PASS_CONTINUE_BIT}, the {@code renderPass} member of {@code pInheritanceInfo} <b>must</b> be a valid {@code VkRenderPass}</li>
 * <li>If {@code flags} contains {@link VK10#VK_COMMAND_BUFFER_USAGE_RENDER_PASS_CONTINUE_BIT COMMAND_BUFFER_USAGE_RENDER_PASS_CONTINUE_BIT}, the {@code subpass} member of {@code pInheritanceInfo} <b>must</b> be a valid subpass index within the {@code renderPass} member of {@code pInheritanceInfo}</li>
 * <li>If {@code flags} contains {@link VK10#VK_COMMAND_BUFFER_USAGE_RENDER_PASS_CONTINUE_BIT COMMAND_BUFFER_USAGE_RENDER_PASS_CONTINUE_BIT}, the {@code framebuffer} member of {@code pInheritanceInfo} <b>must</b> be either {@link VK10#VK_NULL_HANDLE NULL_HANDLE}, or a valid {@code VkFramebuffer} that is compatible with the {@code renderPass} member of {@code pInheritanceInfo}</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK10#VK_STRUCTURE_TYPE_COMMAND_BUFFER_BEGIN_INFO STRUCTURE_TYPE_COMMAND_BUFFER_BEGIN_INFO}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL} or a pointer to a valid instance of {@link VkDeviceGroupCommandBufferBeginInfo}</li>
 * <li>{@code flags} <b>must</b> be a valid combination of {@code VkCommandBufferUsageFlagBits} values</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkCommandBufferInheritanceInfo}, {@link VK10#vkBeginCommandBuffer BeginCommandBuffer}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code flags} &ndash; a bitmask of {@code VkCommandBufferUsageFlagBits} specifying usage behavior for the command buffer.</li>
 * <li>{@code pInheritanceInfo} &ndash; a pointer to a {@link VkCommandBufferInheritanceInfo} structure, which is used if {@code commandBuffer} is a secondary command buffer. If this is a primary command buffer, then this value is ignored.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkCommandBufferBeginInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkCommandBufferUsageFlags flags;
 *     {@link VkCommandBufferInheritanceInfo VkCommandBufferInheritanceInfo} const * pInheritanceInfo;
 * }</code></pre>
 */
class CommandBufferBeginInfo(
        var flags: VkCommandBufferUsageFlags = 0,
        var inheritanceInfo: CommandBufferInheritanceInfo? = null,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.COMMAND_BUFFER_BEGIN_INFO

    infix fun write(stack: MemoryStack): Ptr =
            stack.ncalloc(ALIGNOF, 1, SIZEOF).also { ptr ->
                nsType(ptr, type.i)
                npNext(ptr, next)
                nflags(ptr, flags)
                inheritanceInfo?.let { memPutAddress(ptr + PINHERITANCEINFO, it.write(stack)) }
            }
}