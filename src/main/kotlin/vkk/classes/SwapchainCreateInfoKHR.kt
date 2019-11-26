package classes

import glm_.i
import kool.Ptr
import kool.adr
import kool.toBuffer
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.system.MemoryUtil.memPutAddress
import org.lwjgl.vulkan.VkSwapchainCreateInfoKHR.*
import vkk.*
import vkk.entities.VkSurfaceKHR
import vkk.entities.VkSwapchainKHR

/**
 * Structure specifying parameters of a newly created swapchain object.
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link KHRSwapchain#VK_STRUCTURE_TYPE_SWAPCHAIN_CREATE_INFO_KHR STRUCTURE_TYPE_SWAPCHAIN_CREATE_INFO_KHR}</li>
 * <li>Each {@code pNext} member of any structure (including this one) in the {@code pNext} chain <b>must</b> be either {@code NULL} or a pointer to a valid instance of {@link VkDeviceGroupSwapchainCreateInfoKHR}, {@link VkImageFormatListCreateInfoKHR}, {@link VkSurfaceFullScreenExclusiveInfoEXT}, {@link VkSurfaceFullScreenExclusiveWin32InfoEXT}, {@link VkSwapchainCounterCreateInfoEXT}, or {@link VkSwapchainDisplayNativeHdrCreateInfoAMD}</li>
 * <li>Each {@code sType} member in the {@code pNext} chain <b>must</b> be unique</li>
 * <li>{@code flags} <b>must</b> be a valid combination of {@code VkSwapchainCreateFlagBitsKHR} values</li>
 * <li>{@code surface} <b>must</b> be a valid {@code VkSurfaceKHR} handle</li>
 * <li>{@code imageFormat} <b>must</b> be a valid {@code VkFormat} value</li>
 * <li>{@code imageColorSpace} <b>must</b> be a valid {@code VkColorSpaceKHR} value</li>
 * <li>{@code imageUsage} <b>must</b> be a valid combination of {@code VkImageUsageFlagBits} values</li>
 * <li>{@code imageUsage} <b>must</b> not be 0</li>
 * <li>{@code imageSharingMode} <b>must</b> be a valid {@code VkSharingMode} value</li>
 * <li>{@code preTransform} <b>must</b> be a valid {@code VkSurfaceTransformFlagBitsKHR} value</li>
 * <li>{@code compositeAlpha} <b>must</b> be a valid {@code VkCompositeAlphaFlagBitsKHR} value</li>
 * <li>{@code presentMode} <b>must</b> be a valid {@code VkPresentModeKHR} value</li>
 * <li>If {@code oldSwapchain} is not {@link VK10#VK_NULL_HANDLE NULL_HANDLE}, {@code oldSwapchain} <b>must</b> be a valid {@code VkSwapchainKHR} handle</li>
 * <li>If {@code oldSwapchain} is a valid handle, it <b>must</b> have been created, allocated, or retrieved from {@code surface}</li>
 * <li>Both of {@code oldSwapchain}, and {@code surface} that are valid handles <b>must</b> have been created, allocated, or retrieved from the same {@code VkInstance}</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkExtent2D}, {@link KHRDisplaySwapchain#vkCreateSharedSwapchainsKHR CreateSharedSwapchainsKHR}, {@link KHRSwapchain#vkCreateSwapchainKHR CreateSwapchainKHR}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code flags} &ndash; a bitmask of {@code VkSwapchainCreateFlagBitsKHR} indicating parameters of the swapchain creation.</li>
 * <li>{@code surface} &ndash; the surface onto which the swapchain will present images. If the creation succeeds, the swapchain becomes associated with {@code surface}.</li>
 * <li>{@code minImageCount} &ndash; the minimum number of presentable images that the application needs. The implementation will either create the swapchain with at least that many images, or it will fail to create the swapchain.</li>
 * <li>{@code imageFormat} &ndash; a {@code VkFormat} value specifying the format the swapchain image(s) will be created with.</li>
 * <li>{@code imageColorSpace} &ndash; a {@code VkColorSpaceKHR} value specifying the way the swapchain interprets image data.</li>
 * <li>{@code imageExtent} &ndash; the size (in pixels) of the swapchain image(s). The behavior is platform-dependent if the image extent does not match the surface&#8217;s {@code currentExtent} as returned by {@code vkGetPhysicalDeviceSurfaceCapabilitiesKHR}.
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>On some platforms, it is normal that {@code maxImageExtent} <b>may</b> become {@code (0, 0)}, for example when the window is minimized. In such a case, it is not possible to create a swapchain due to the Valid Usage requirements.</p>
 * </div></li>
 * <li>{@code imageArrayLayers} &ndash; the number of views in a multiview/stereo surface. For non-stereoscopic-3D applications, this value is 1.</li>
 * <li>{@code imageUsage} &ndash; a bitmask of {@code VkImageUsageFlagBits} describing the intended usage of the (acquired) swapchain images.</li>
 * <li>{@code imageSharingMode} &ndash; the sharing mode used for the image(s) of the swapchain.</li>
 * <li>{@code queueFamilyIndexCount} &ndash; the number of queue families having access to the image(s) of the swapchain when {@code imageSharingMode} is {@link VK10#VK_SHARING_MODE_CONCURRENT SHARING_MODE_CONCURRENT}.</li>
 * <li>{@code pQueueFamilyIndices} &ndash; an array of queue family indices having access to the images(s) of the swapchain when {@code imageSharingMode} is {@link VK10#VK_SHARING_MODE_CONCURRENT SHARING_MODE_CONCURRENT}.</li>
 * <li>{@code preTransform} &ndash; a {@code VkSurfaceTransformFlagBitsKHR} value describing the transform, relative to the presentation engine&#8217;s natural orientation, applied to the image content prior to presentation. If it does not match the {@code currentTransform} value returned by {@code vkGetPhysicalDeviceSurfaceCapabilitiesKHR}, the presentation engine will transform the image content as part of the presentation operation.</li>
 * <li>{@code compositeAlpha} &ndash; a {@code VkCompositeAlphaFlagBitsKHR} value indicating the alpha compositing mode to use when this surface is composited together with other surfaces on certain window systems.</li>
 * <li>{@code presentMode} &ndash; the presentation mode the swapchain will use. A swapchain&#8217;s present mode determines how incoming present requests will be processed and queued internally.</li>
 * <li>{@code clipped} &ndash; specifies whether the Vulkan implementation is allowed to discard rendering operations that affect regions of the surface that are not visible.
 *
 * <ul>
 * <li>If set to {@link VK10#VK_TRUE TRUE}, the presentable images associated with the swapchain <b>may</b> not own all of their pixels. Pixels in the presentable images that correspond to regions of the target surface obscured by another window on the desktop, or subject to some other clipping mechanism will have undefined content when read back. Pixel shaders <b>may</b> not execute for these pixels, and thus any side effects they would have had will not occur. {@link VK10#VK_TRUE TRUE} value does not guarantee any clipping will occur, but allows more optimal presentation methods to be used on some platforms.</li>
 * <li>If set to {@link VK10#VK_FALSE FALSE}, presentable images associated with the swapchain will own all of the pixels they contain.
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>Applications <b>should</b> set this value to {@link VK10#VK_TRUE TRUE} if they do not expect to read back the content of presentable images before presenting them or after reacquiring them, and if their pixel shaders do not have any side effects that require them to run for all pixels in the presentable image.</p>
 * </div>
 * </li>
 * </ul></li>
 * <li>{@code oldSwapchain} &ndash; {@link VK10#VK_NULL_HANDLE NULL_HANDLE}, or the existing non-retired swapchain currently associated with {@code surface}. Providing a valid {@code oldSwapchain} <b>may</b> aid in the resource reuse, and also allows the application to still present any images that are already acquired from it.
 *
 * <p>Upon calling {@code vkCreateSwapchainKHR} with an {@code oldSwapchain} that is not {@link VK10#VK_NULL_HANDLE NULL_HANDLE}, {@code oldSwapchain} is retired -- even if creation of the new swapchain fails. The new swapchain is created in the non-retired state whether or not {@code oldSwapchain} is {@link VK10#VK_NULL_HANDLE NULL_HANDLE}.</p>
 *
 * <p>Upon calling {@code vkCreateSwapchainKHR} with an {@code oldSwapchain} that is not {@link VK10#VK_NULL_HANDLE NULL_HANDLE}, any images from {@code oldSwapchain} that are not acquired by the application <b>may</b> be freed by the implementation, which <b>may</b> occur even if creation of the new swapchain fails. The application <b>can</b> destroy {@code oldSwapchain} to free all memory associated with {@code oldSwapchain}.</p>
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>Multiple retired swapchains <b>can</b> be associated with the same {@code VkSurfaceKHR} through multiple uses of {@code oldSwapchain} that outnumber calls to {@link KHRSwapchain#vkDestroySwapchainKHR DestroySwapchainKHR}.</p>
 *
 * <p>After {@code oldSwapchain} is retired, the application <b>can</b> pass to {@link KHRSwapchain#vkQueuePresentKHR QueuePresentKHR} any images it had already acquired from {@code oldSwapchain}. E.g., an application may present an image from the old swapchain before an image from the new swapchain is ready to be presented. As usual, {@link KHRSwapchain#vkQueuePresentKHR QueuePresentKHR} <b>may</b> fail if {@code oldSwapchain} has entered a state that causes {@link KHRSwapchain#VK_ERROR_OUT_OF_DATE_KHR ERROR_OUT_OF_DATE_KHR} to be returned.</p>
 *
 * <p>The application <b>can</b> continue to use a shared presentable image obtained from {@code oldSwapchain} until a presentable image is acquired from the new swapchain, as long as it has not entered a state that causes it to return {@link KHRSwapchain#VK_ERROR_OUT_OF_DATE_KHR ERROR_OUT_OF_DATE_KHR}.</p>
 * </div></li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkSwapchainCreateInfoKHR {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkSwapchainCreateFlagsKHR flags;
 *     VkSurfaceKHR surface;
 *     uint32_t minImageCount;
 *     VkFormat imageFormat;
 *     VkColorSpaceKHR imageColorSpace;
 *     {@link VkExtent2D VkExtent2D} imageExtent;
 *     uint32_t imageArrayLayers;
 *     VkImageUsageFlags imageUsage;
 *     VkSharingMode imageSharingMode;
 *     uint32_t queueFamilyIndexCount;
 *     uint32_t const * pQueueFamilyIndices;
 *     VkSurfaceTransformFlagBitsKHR preTransform;
 *     VkCompositeAlphaFlagBitsKHR compositeAlpha;
 *     VkPresentModeKHR presentMode;
 *     VkBool32 clipped;
 *     VkSwapchainKHR oldSwapchain;
 * }</code></pre>
 */
class SwapchainCreateInfoKHR(
    var flags: VkSwapchainCreateFlagsKHR = 0,
    var surface: VkSurfaceKHR,
    var minImageCount: Int,
    var imageFormat: VkFormat,
    var imageColorSpace: VkColorSpaceKHR,
    var imageExtent: Extent2D = Extent2D(0, 0),
    var imageArrayLayers: Int,
    var imageUsage: VkImageUsageFlags,
    var imageSharingMode: VkSharingMode,
    var queueFamilyIndices: IntArray? = null,
    var preTransform: VkSurfaceTransformKHR,
    var compositeAlpha: VkCompositeAlphaKHR,
    var presentMode: VkPresentModeKHR,
    var clipped: Boolean,
    var oldSwapchain: VkSwapchainKHR,
    var next: Ptr = NULL
) {

    val type get() = VkStructureType.SWAPCHAIN_CREATE_INFO_KHR

    val MemoryStack.native: Ptr
        get() = ncalloc(ALIGNOF, 1, SIZEOF).also { ptr ->
            nsType(ptr, type.i)
            npNext(ptr, next)
            nflags(ptr, flags)
            nsurface(ptr, surface.L)
            nminImageCount(ptr, minImageCount)
            nimageFormat(ptr, imageFormat.i)
            nimageColorSpace(ptr, imageColorSpace.i)
            imageExtent.toPtr(ptr + IMAGEEXTENT)
            nimageArrayLayers(ptr, imageArrayLayers)
            nimageUsage(ptr, imageUsage)
            nimageSharingMode(ptr, imageSharingMode.i)
            queueFamilyIndices?.let {
                nqueueFamilyIndexCount(ptr, it.size)
                memPutAddress(ptr + PQUEUEFAMILYINDICES, it.toBuffer(this).adr) // TODO nToBuffer
            }
            npreTransform(ptr, preTransform.i)
            ncompositeAlpha(ptr, compositeAlpha.i)
            npresentMode(ptr, presentMode.i)
            nclipped(ptr, clipped.i)
            noldSwapchain(ptr, oldSwapchain.L)
        }
}