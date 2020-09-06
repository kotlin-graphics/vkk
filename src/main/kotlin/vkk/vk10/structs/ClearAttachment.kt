package vkk.vk10.structs

import kool.Adr
import kool.IntPtr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkClearAttachment.*
import vkk.VkImageAspectFlags

/**
 * Structure specifying a clear attachment.
 *
 * <h5>Description</h5>
 *
 * <p>No memory barriers are needed between {@code vkCmdClearAttachments} and preceding or subsequent draw or attachment clear commands in the same subpass.</p>
 *
 * <p>The {@code vkCmdClearAttachments} command is not affected by the bound pipeline state.</p>
 *
 * <p>Attachments <b>can</b> also be cleared at the beginning of a render pass instance by setting {@code loadOp} (or {@code stencilLoadOp}) of {@link VkAttachmentDescription} to {@link VK10#VK_ATTACHMENT_LOAD_OP_CLEAR ATTACHMENT_LOAD_OP_CLEAR}, as described for {@link VK10#vkCreateRenderPass CreateRenderPass}.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>If {@code aspectMask} includes {@link VK10#VK_IMAGE_ASPECT_COLOR_BIT IMAGE_ASPECT_COLOR_BIT}, it <b>must</b> not include {@link VK10#VK_IMAGE_ASPECT_DEPTH_BIT IMAGE_ASPECT_DEPTH_BIT} or {@link VK10#VK_IMAGE_ASPECT_STENCIL_BIT IMAGE_ASPECT_STENCIL_BIT}</li>
 * <li>{@code aspectMask} <b>must</b> not include {@link VK10#VK_IMAGE_ASPECT_METADATA_BIT IMAGE_ASPECT_METADATA_BIT}</li>
 * <li>{@code aspectMask} <b>must</b> not include {@code VK_IMAGE_ASPECT_MEMORY_PLANE_i_BIT_EXT} for any index {@code i}.</li>
 * <li>{@code clearValue} <b>must</b> be a valid {@link VkClearValue} union</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code aspectMask} <b>must</b> be a valid combination of {@code VkImageAspectFlagBits} values</li>
 * <li>{@code aspectMask} <b>must</b> not be 0</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkClearValue}, {@link VK10#vkCmdClearAttachments CmdClearAttachments}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code aspectMask} &ndash; a mask selecting the color, depth and/or stencil aspects of the attachment to be cleared.</li>
 * <li>{@code colorAttachment} &ndash; only meaningful if {@link VK10#VK_IMAGE_ASPECT_COLOR_BIT IMAGE_ASPECT_COLOR_BIT} is set in {@code aspectMask}, in which case it is an index to the {@code pColorAttachments} array in the {@link VkSubpassDescription} structure of the current subpass which selects the color attachment to clear.</li>
 * <li>{@code clearValue} &ndash; the color or depth/stencil value to clear the attachment to, as described in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#clears-values">Clear Values</a> below.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkClearAttachment {
 *     VkImageAspectFlags aspectMask;
 *     uint32_t colorAttachment;
 *     {@link VkClearValue VkClearValue} clearValue;
 * }</code></pre>
 */
class ClearAttachment(
        var aspectMask: VkImageAspectFlags,
        var colorAttachment: Int,
        var clearValue: ClearValue
) {

    infix fun write(stack: MemoryStack): Adr =
        stack.ncalloc(ALIGNOF, 1, SIZEOF).also { write(it) }

    infix fun write(adr: Adr) {
        naspectMask(adr, aspectMask)
        ncolorAttachment(adr, colorAttachment)
        clearValue write IntPtr(adr + CLEARVALUE)
    }
}

infix fun Array<ClearAttachment>.write(stack: MemoryStack): Ptr {
    val natives = stack.ncalloc(ALIGNOF, size, SIZEOF)
    for (i in indices)
        this[i] write (natives + i * SIZEOF)
    return natives
}