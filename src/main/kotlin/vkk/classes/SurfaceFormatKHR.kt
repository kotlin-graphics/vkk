package classes

import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkSurfaceFormatKHR
import org.lwjgl.vulkan.VkSurfaceFormatKHR.*
import vkk.VkColorSpaceKHR
import vkk.VkFormat

/**
 * Structure describing a supported swapchain format-color space pair.
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code format} &ndash; a {@code VkFormat} that is compatible with the specified surface.</li>
 * <li>{@code colorSpace} &ndash; a presentation {@code VkColorSpaceKHR} that is compatible with the surface.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkSurfaceFormatKHR {
 *     VkFormat format;
 *     VkColorSpaceKHR colorSpace;
 * }</code></pre>
 */
class SurfaceFormatKHR(
    var format: VkFormat,
    var colorSpace: VkColorSpaceKHR
) {

    constructor(ptr: Ptr) : this(VkFormat(nformat(ptr)), VkColorSpaceKHR(ncolorSpace(ptr)))

    companion object {
        inline fun ncalloc(stack: MemoryStack, num: Int = 1) = stack.ncalloc(ALIGNOF, num, SIZEOF)
    }
}