package vkk.classes

import kool.Adr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkClearRect
import org.lwjgl.vulkan.VkClearRect.*

/**
 * Structure specifying a clear rectangle.
 *
 * <h5>Description</h5>
 *
 * <p>The layers <code>[baseArrayLayer, baseArrayLayer + layerCount)</code> counting from the base layer of the attachment image view are cleared.</p>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkRect2D}, {@link VK10#vkCmdClearAttachments CmdClearAttachments}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code rect} &ndash; the two-dimensional region to be cleared.</li>
 * <li>{@code baseArrayLayer} &ndash; the first layer to be cleared.</li>
 * <li>{@code layerCount} &ndash; the number of layers to clear.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkClearRect {
 *     {@link VkRect2D VkRect2D} rect;
 *     uint32_t baseArrayLayer;
 *     uint32_t layerCount;
 * }</code></pre>
 */
class ClearRect(
        var rect: Rect2D,
        var baseArrayLayer: Int,
        var layerCount: Int
) {

    infix fun write(stack: MemoryStack): Adr {
        val adr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
        rect write (adr + RECT)
        nbaseArrayLayer(adr, baseArrayLayer)
        nlayerCount(adr, layerCount)
        return adr
    }
}