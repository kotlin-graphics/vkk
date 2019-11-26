package classes

import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkSurfaceCapabilitiesKHR.*
import vkk.VkCompositeAlphaFlagsKHR
import vkk.VkImageUsageFlags
import vkk.VkSurfaceTransformFlagsKHR
import vkk.VkSurfaceTransformKHR

/**
 * Structure describing capabilities of a surface.
 *
 * <h5>Description</h5>
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>Supported usage flags of a presentable image when using {@link KHRSharedPresentableImage#VK_PRESENT_MODE_SHARED_DEMAND_REFRESH_KHR PRESENT_MODE_SHARED_DEMAND_REFRESH_KHR} or {@link KHRSharedPresentableImage#VK_PRESENT_MODE_SHARED_CONTINUOUS_REFRESH_KHR PRESENT_MODE_SHARED_CONTINUOUS_REFRESH_KHR} presentation mode are provided by {@link VkSharedPresentSurfaceCapabilitiesKHR}{@code ::sharedPresentSupportedUsageFlags}.</p>
 * </div>
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>Formulas such as <code>min(N, maxImageCount)</code> are not correct, since {@code maxImageCount} <b>may</b> be zero.</p>
 * </div>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkExtent2D}, {@link VkSurfaceCapabilities2KHR}, {@link KHRSurface#vkGetPhysicalDeviceSurfaceCapabilitiesKHR GetPhysicalDeviceSurfaceCapabilitiesKHR}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code minImageCount} &ndash; the minimum number of images the specified device supports for a swapchain created for the surface, and will be at least one.</li>
 * <li>{@code maxImageCount} &ndash; the maximum number of images the specified device supports for a swapchain created for the surface, and will be either 0, or greater than or equal to {@code minImageCount}. A value of 0 means that there is no limit on the number of images, though there <b>may</b> be limits related to the total amount of memory used by presentable images.</li>
 * <li>{@code currentExtent} &ndash; the current width and height of the surface, or the special value <code>(0xFFFFFFFF, 0xFFFFFFFF)</code> indicating that the surface size will be determined by the extent of a swapchain targeting the surface.</li>
 * <li>{@code minImageExtent} &ndash; contains the smallest valid swapchain extent for the surface on the specified device. The {@code width} and {@code height} of the extent will each be less than or equal to the corresponding {@code width} and {@code height} of {@code currentExtent}, unless {@code currentExtent} has the special value described above.</li>
 * <li>{@code maxImageExtent} &ndash; contains the largest valid swapchain extent for the surface on the specified device. The {@code width} and {@code height} of the extent will each be greater than or equal to the corresponding {@code width} and {@code height} of {@code minImageExtent}. The {@code width} and {@code height} of the extent will each be greater than or equal to the corresponding {@code width} and {@code height} of {@code currentExtent}, unless {@code currentExtent} has the special value described above.</li>
 * <li>{@code maxImageArrayLayers} &ndash; the maximum number of layers presentable images <b>can</b> have for a swapchain created for this device and surface, and will be at least one.</li>
 * <li>{@code supportedTransforms} &ndash; a bitmask of {@code VkSurfaceTransformFlagBitsKHR} indicating the presentation transforms supported for the surface on the specified device. At least one bit will be set.</li>
 * <li>{@code currentTransform} &ndash; {@code VkSurfaceTransformFlagBitsKHR} value indicating the surface&#8217;s current transform relative to the presentation engine&#8217;s natural orientation.</li>
 * <li>{@code supportedCompositeAlpha} &ndash; a bitmask of {@code VkCompositeAlphaFlagBitsKHR}, representing the alpha compositing modes supported by the presentation engine for the surface on the specified device, and at least one bit will be set. Opaque composition <b>can</b> be achieved in any alpha compositing mode by either using an image format that has no alpha component, or by ensuring that all pixels in the presentable images have an alpha value of 1.0.</li>
 * <li>{@code supportedUsageFlags} &ndash; a bitmask of {@code VkImageUsageFlagBits} representing the ways the application <b>can</b> use the presentable images of a swapchain created with {@code VkPresentModeKHR} set to {@link KHRSurface#VK_PRESENT_MODE_IMMEDIATE_KHR PRESENT_MODE_IMMEDIATE_KHR}, {@link KHRSurface#VK_PRESENT_MODE_MAILBOX_KHR PRESENT_MODE_MAILBOX_KHR}, {@link KHRSurface#VK_PRESENT_MODE_FIFO_KHR PRESENT_MODE_FIFO_KHR} or {@link KHRSurface#VK_PRESENT_MODE_FIFO_RELAXED_KHR PRESENT_MODE_FIFO_RELAXED_KHR} for the surface on the specified device. {@link VK10#VK_IMAGE_USAGE_COLOR_ATTACHMENT_BIT IMAGE_USAGE_COLOR_ATTACHMENT_BIT} <b>must</b> be included in the set but implementations <b>may</b> support additional usages.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkSurfaceCapabilitiesKHR {
 *     uint32_t minImageCount;
 *     uint32_t maxImageCount;
 *     {@link VkExtent2D VkExtent2D} currentExtent;
 *     {@link VkExtent2D VkExtent2D} minImageExtent;
 *     {@link VkExtent2D VkExtent2D} maxImageExtent;
 *     uint32_t maxImageArrayLayers;
 *     VkSurfaceTransformFlagsKHR supportedTransforms;
 *     VkSurfaceTransformFlagBitsKHR currentTransform;
 *     VkCompositeAlphaFlagsKHR supportedCompositeAlpha;
 *     VkImageUsageFlags supportedUsageFlags;
 * }</code></pre>
 */
class SurfaceCapabilitiesKHR(
    var minImageCount: Int,
    var maxImageCount: Int,
    var currentExtent: Extent2D,
    var minImageExtent: Extent2D,
    var maxImageExtent: Extent2D,
    var maxImageArrayLayers: Int,
    var supportedTransforms: VkSurfaceTransformFlagsKHR,
    var currentTransform: VkSurfaceTransformKHR,
    var supportedCompositeAlpha: VkCompositeAlphaFlagsKHR,
    var supportedUsageFlags: VkImageUsageFlags
) {

    companion object {
        fun ncalloc(stack: MemoryStack, num: Int = 1): Ptr = stack.ncalloc(ALIGNOF, num, SIZEOF)

        fun <R> fromNative(stack: MemoryStack, block: (Ptr) -> R): SurfaceCapabilitiesKHR {
            val ptr = ncalloc(stack)
            block(ptr)
            return SurfaceCapabilitiesKHR(
                nminImageCount(ptr),
                nmaxImageCount(ptr),
                Extent2D(ptr + CURRENTEXTENT),
                Extent2D(ptr + MINIMAGEEXTENT),
                Extent2D(ptr + MAXIMAGEEXTENT),
                nmaxImageArrayLayers(ptr),
                nsupportedTransforms(ptr),
                VkSurfaceTransformKHR(ncurrentTransform(ptr)),
                nsupportedCompositeAlpha(ptr),
                nsupportedUsageFlags(ptr)
            )
        }
    }
}