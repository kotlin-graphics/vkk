package vkk._10.structs

import kool.IntPtr
import org.lwjgl.system.MemoryStack
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

    constructor(intPtr: IntPtr) : this(VkFormat(intPtr[0]), VkColorSpaceKHR(intPtr[1]))
}