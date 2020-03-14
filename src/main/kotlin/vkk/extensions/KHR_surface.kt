package vkk.extensions

import glm_.bool
import kool.*
import org.lwjgl.system.JNI
import org.lwjgl.system.JNI.callPJPI
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.Pointer
import org.lwjgl.vulkan.VkSurfaceCapabilitiesKHR
import org.lwjgl.vulkan.VkSurfaceFormatKHR
import vkk.*
import vkk._10.structs.Extent2D
import vkk.entities.VkPresentModeKHR_Array
import vkk.entities.VkSurfaceKHR
import vkk.identifiers.CapabilitiesInstance

inline class VkColorSpaceKHR(val i: Int) {
    companion object {
        val SRGB_NONLINEAR_KHR = VkColorSpaceKHR(0)
        val DISPLAY_P3_NONLINEAR_EXT = VkColorSpaceKHR(1000104001)
        val EXTENDED_SRGB_LINEAR_EXT = VkColorSpaceKHR(1000104002)
        val DCI_P3_LINEAR_EXT = VkColorSpaceKHR(1000104003)
        val DCI_P3_NONLINEAR_EXT = VkColorSpaceKHR(1000104004)
        val BT709_LINEAR_EXT = VkColorSpaceKHR(1000104005)
        val BT709_NONLINEAR_EXT = VkColorSpaceKHR(1000104006)
        val BT2020_LINEAR_EXT = VkColorSpaceKHR(1000104007)
        val HDR10_ST2084_EXT = VkColorSpaceKHR(1000104008)
        val DOLBYVISION_EXT = VkColorSpaceKHR(1000104009)
        val HDR10_HLG_EXT = VkColorSpaceKHR(1000104010)
        val ADOBERGB_LINEAR_EXT = VkColorSpaceKHR(1000104011)
        val ADOBERGB_NONLINEAR_EXT = VkColorSpaceKHR(1000104012)
        val PASS_THROUGH_EXT = VkColorSpaceKHR(1000104013)
        val EXTENDED_SRGB_NONLINEAR_EXT = VkColorSpaceKHR(1000104014)
        val DISPLAY_NATIVE_AMD = VkColorSpaceKHR(1000213000)
    }
}

inline class VkPresentModeKHR(val i: Int) {
    companion object {
        val IMMEDIATE = VkPresentModeKHR(0)
        val MAILBOX = VkPresentModeKHR(1)
        val FIFO = VkPresentModeKHR(2)
        val FIFO_RELAXED = VkPresentModeKHR(3)
        val SHARED_DEMAND_REFRESH = VkPresentModeKHR(1000111000)
        val SHARED_CONTINUOUS_REFRESH = VkPresentModeKHR(1000111001)
    }
}


inline class VkSurfaceTransformKHR(val i: Int) {
    companion object {
        val IDENTITY_BIT = VkSurfaceTransformKHR(0x00000001)
        val ROTATE_90_BIT = VkSurfaceTransformKHR(0x00000002)
        val ROTATE_180_BIT = VkSurfaceTransformKHR(0x00000004)
        val ROTATE_270_BIT = VkSurfaceTransformKHR(0x00000008)
        val HORIZONTAL_MIRROR_BIT = VkSurfaceTransformKHR(0x00000010)
        val HORIZONTAL_MIRROR_ROTATE_90_BIT = VkSurfaceTransformKHR(0x00000020)
        val HORIZONTAL_MIRROR_ROTATE_180_BIT = VkSurfaceTransformKHR(0x00000040)
        val HORIZONTAL_MIRROR_ROTATE_270_BIT = VkSurfaceTransformKHR(0x00000080)
        val INHERIT_BIT = VkSurfaceTransformKHR(0x00000100)
    }
}

infix fun Int.has(f: VkSurfaceTransformKHR) = and(f.i) != 0

typealias VkSurfaceTransformFlagsKHR = VkFlags

inline class VkCompositeAlphaKHR(val i: Int) {
    companion object {
        val OPAQUE_BIT = VkCompositeAlphaKHR(0x00000001)
        val PRE_MULTIPLIED_BIT = VkCompositeAlphaKHR(0x00000002)
        val POST_MULTIPLIED_BIT = VkCompositeAlphaKHR(0x00000004)
        val INHERIT_BIT = VkCompositeAlphaKHR(0x00000008)
    }
}

infix fun Int.has(f: VkCompositeAlphaKHR) = and(f.i) != 0

typealias VkCompositeAlphaFlagsKHR = VkFlags

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
        var supportedUsageFlags: VkImageUsageFlags) {

    constructor(ptr: BytePtr) : this(
            VkSurfaceCapabilitiesKHR.nminImageCount(ptr.adr),
            VkSurfaceCapabilitiesKHR.nmaxImageCount(ptr.adr),
            Extent2D(IntPtr(ptr + VkSurfaceCapabilitiesKHR.CURRENTEXTENT)),
            Extent2D(IntPtr(ptr + VkSurfaceCapabilitiesKHR.MINIMAGEEXTENT)),
            Extent2D(IntPtr(ptr + VkSurfaceCapabilitiesKHR.MAXIMAGEEXTENT)),
            VkSurfaceCapabilitiesKHR.nmaxImageArrayLayers(ptr.adr),
            VkSurfaceCapabilitiesKHR.nsupportedTransforms(ptr.adr),
            VkSurfaceTransformKHR(VkSurfaceCapabilitiesKHR.ncurrentTransform(ptr.adr)),
            VkSurfaceCapabilitiesKHR.nsupportedCompositeAlpha(ptr.adr),
            VkSurfaceCapabilitiesKHR.nsupportedUsageFlags(ptr.adr)
    )

    companion object {
        //inline fun <R> read(block: (Ptr) -> R): SurfaceCapabilitiesKHR = stak { read(it, block) }
        inline fun <R> read(stack: MemoryStack, block: (Ptr) -> R): SurfaceCapabilitiesKHR {
            val ptr = stack.ncalloc(VkSurfaceCapabilitiesKHR.ALIGNOF, 1, VkSurfaceCapabilitiesKHR.SIZEOF)
            block(ptr)
            return SurfaceCapabilitiesKHR(BytePtr(ptr))
        }
    }
}

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
        var colorSpace: VkColorSpaceKHR) {

    constructor(intPtr: IntPtr) : this(VkFormat(intPtr[0]), VkColorSpaceKHR(intPtr[1]))
}

interface Instance_KHR_surface : Pointer {

    val capabilities: CapabilitiesInstance

    // --- [ vkDestroySurfaceKHR ] ---
    infix fun destroy(surface: VkSurfaceKHR) =
            JNI.callPJPV(adr, surface.L, MemoryUtil.NULL, capabilities.vkDestroySurfaceKHR)
}

interface PhysicalDevice_KHR_surface : Pointer {

    val capabilities: CapabilitiesInstance

    // --- [ vkGetPhysicalDeviceSurfaceSupportKHR ] ---

    fun MemoryStack.getSurfaceSupportKHR(queueFamilySize: Int, surface: VkSurfaceKHR): BooleanArray =
            framed {
                val supported = this.mInt()
                BooleanArray(queueFamilySize) {
                    VK_CHECK_RESULT(JNI.callPJPI(adr, it, surface.L, supported.adr, capabilities.vkGetPhysicalDeviceSurfaceSupportKHR))
                    supported[0].bool
                }
            }

    fun getSurfaceSupportKHR(queueFamilySize: Int, surface: VkSurfaceKHR): BooleanArray =
            stak { it.getSurfaceSupportKHR(queueFamilySize, surface) }

    // --- [ vkGetPhysicalDeviceSurfaceCapabilitiesKHR ] ---

    infix fun MemoryStack.getSurfaceCapabilitiesKHR(surface: VkSurfaceKHR): SurfaceCapabilitiesKHR =
            framed { SurfaceCapabilitiesKHR.read(this) { VK_CHECK_RESULT(callPJPI(adr, surface.L, it, capabilities.vkGetPhysicalDeviceSurfaceCapabilitiesKHR)) } }

    infix fun getSurfaceCapabilitiesKHR(surface: VkSurfaceKHR): SurfaceCapabilitiesKHR =
            stak { it getSurfaceCapabilitiesKHR surface }

    // --- [ vkGetPhysicalDeviceSurfaceFormatsKHR ] ---

    infix fun MemoryStack.getSurfaceFormatsKHR(surface: VkSurfaceKHR): MutableList<SurfaceFormatKHR> =
            framed {
                val pCount = this.mInt()
                nGetSurfaceFormatsKHR(surface, pCount.adr).check()
                val count = pCount[0]
                assert(count > 0)
                val pSurfaceFormats = this.ncalloc(VkSurfaceFormatKHR.ALIGNOF, count, VkSurfaceFormatKHR.SIZEOF)
                nGetSurfaceFormatsKHR(surface, pCount.adr, pSurfaceFormats).check()
                MutableList(count) { SurfaceFormatKHR(IntPtr(pSurfaceFormats + VkSurfaceFormatKHR.SIZEOF * it)) }
            }

    infix fun getSurfaceFormatsKHR(surface: VkSurfaceKHR): MutableList<SurfaceFormatKHR> =
            stak { it getSurfaceFormatsKHR surface }

    // --- [ vkGetPhysicalDeviceSurfacePresentModesKHR ] ---

    infix fun MemoryStack.getSurfacePresentModesKHR(surface: VkSurfaceKHR): VkPresentModeKHR_Array =
            framed {
                val pPresentModeCount = this.mInt()
                var propertyCount: Int
                var result: VkResult
                var pPresentModes = IntPtr.NULL
                do {
                    result = nGetSurfacePresentModesKHR(surface, pPresentModeCount.adr)
                    propertyCount = pPresentModeCount[0]
                    if (result == VkResult.SUCCESS && propertyCount != 0) {
                        pPresentModes = this.mInt(propertyCount)
                        nGetSurfacePresentModesKHR(surface, pPresentModeCount.adr, pPresentModes.adr).check()
                    }
                } while (result == VkResult.INCOMPLETE)
                VkPresentModeKHR_Array(propertyCount) { VkPresentModeKHR(pPresentModes[it]) }
            }

    infix fun getSurfacePresentModesKHR(surface: VkSurfaceKHR): VkPresentModeKHR_Array =
            stak { it getSurfacePresentModesKHR surface }
}

private inline fun PhysicalDevice_KHR_surface.nGetSurfaceFormatsKHR(surface: VkSurfaceKHR, pSurfaceFormatCount: Ptr, pSurfaceFormats: Ptr = MemoryUtil.NULL): VkResult =
        VkResult(JNI.callPJPPI(adr, surface.L, pSurfaceFormatCount, pSurfaceFormats, capabilities.vkGetPhysicalDeviceSurfaceFormatsKHR))

private inline fun PhysicalDevice_KHR_surface.nGetSurfacePresentModesKHR(surface: VkSurfaceKHR, pPresentModeCount: Ptr, pPresentModes: Ptr = MemoryUtil.NULL): VkResult =
        VkResult(JNI.callPJPPI(adr, surface.L, pPresentModeCount, pPresentModes, capabilities.vkGetPhysicalDeviceSurfacePresentModesKHR))