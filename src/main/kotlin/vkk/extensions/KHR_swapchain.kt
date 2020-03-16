package vkk.extensions

import glm_.i
import kool.*
import org.lwjgl.system.JNI.*
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.system.MemoryUtil.memPutAddress
import org.lwjgl.system.Pointer
import org.lwjgl.vulkan.*
import org.lwjgl.vulkan.VK11.VK_MAX_DEVICE_GROUP_SIZE
import vkk.*
import vkk._10.structs.Extent2D
import vkk._10.structs.Rect2D
import vkk.entities.*
import vkk.identifiers.CapabilitiesDevice
import vkk.identifiers.CapabilitiesInstance

inline class VkSwapchainCreateKHR(val i: Int) {
    companion object {
        val SPLIT_INSTANCE_BIND_REGIONS_BIT_KHR = (0x00000001)
        val PROTECTED_BIT_KHR = (0x00000002)
        val MUTABLE_FORMAT_BIT_KHR = (0x00000004)
    }
}

typealias VkSwapchainCreateFlagsKHR = VkFlags

inline class VkDeviceGroupPresentModeKHR(val i: Int) {
    companion object {
        val LOCAL_BIT_KHR = (0x00000001)
        val REMOTE_BIT_KHR = (0x00000002)
        val SUM_BIT_KHR = (0x00000004)
        val LOCAL_MULTI_DEVICE_BIT_KHR = (0x00000008)
    }
}

typealias VkDeviceGroupPresentModeFlagsKHR = VkFlags

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
        var next: Ptr = NULL) {

    val type get() = VkStructureType.SWAPCHAIN_CREATE_INFO_KHR

    infix fun write(stack: MemoryStack): Adr {
        val adr = stack.ncalloc(VkSwapchainCreateInfoKHR.ALIGNOF, 1, VkSwapchainCreateInfoKHR.SIZEOF)
        VkSwapchainCreateInfoKHR.nsType(adr, type.i)
        VkSwapchainCreateInfoKHR.npNext(adr, next)
        VkSwapchainCreateInfoKHR.nflags(adr, flags)
        VkSwapchainCreateInfoKHR.nsurface(adr, surface.L)
        VkSwapchainCreateInfoKHR.nminImageCount(adr, minImageCount)
        VkSwapchainCreateInfoKHR.nimageFormat(adr, imageFormat.i)
        VkSwapchainCreateInfoKHR.nimageColorSpace(adr, imageColorSpace.i)
        imageExtent.write(adr + VkSwapchainCreateInfoKHR.IMAGEEXTENT)
        VkSwapchainCreateInfoKHR.nimageArrayLayers(adr, imageArrayLayers)
        VkSwapchainCreateInfoKHR.nimageUsage(adr, imageUsage)
        VkSwapchainCreateInfoKHR.nimageSharingMode(adr, imageSharingMode.i)
        queueFamilyIndices?.let {
            VkSwapchainCreateInfoKHR.nqueueFamilyIndexCount(adr, it.size)
            memPutAddress(adr + VkSwapchainCreateInfoKHR.PQUEUEFAMILYINDICES, it.toAdr(stack).adr)
        }
        VkSwapchainCreateInfoKHR.npreTransform(adr, preTransform.i)
        VkSwapchainCreateInfoKHR.ncompositeAlpha(adr, compositeAlpha.i)
        VkSwapchainCreateInfoKHR.npresentMode(adr, presentMode.i)
        VkSwapchainCreateInfoKHR.nclipped(adr, clipped.i)
        VkSwapchainCreateInfoKHR.noldSwapchain(adr, oldSwapchain.L)
        return adr
    }
}

/**
 * Structure describing parameters of a queue presentation.
 *
 * <h5>Description</h5>
 *
 * <p>Before an application <b>can</b> present an image, the image's layout <b>must</b> be transitioned to the {@link KHRSwapchain#VK_IMAGE_LAYOUT_PRESENT_SRC_KHR IMAGE_LAYOUT_PRESENT_SRC_KHR} layout, or for a shared presentable image the {@link KHRSharedPresentableImage#VK_IMAGE_LAYOUT_SHARED_PRESENT_KHR IMAGE_LAYOUT_SHARED_PRESENT_KHR} layout.</p>
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>When transitioning the image to {@link KHRSharedPresentableImage#VK_IMAGE_LAYOUT_SHARED_PRESENT_KHR IMAGE_LAYOUT_SHARED_PRESENT_KHR} or {@link KHRSwapchain#VK_IMAGE_LAYOUT_PRESENT_SRC_KHR IMAGE_LAYOUT_PRESENT_SRC_KHR}, there is no need to delay subsequent processing, or perform any visibility operations (as {@link KHRSwapchain#vkQueuePresentKHR QueuePresentKHR} performs automatic visibility operations). To achieve this, the {@code dstAccessMask} member of the {@link VkImageMemoryBarrier} <b>should</b> be set to 0, and the {@code dstStageMask} parameter <b>should</b> be set to {@link VK10#VK_PIPELINE_STAGE_BOTTOM_OF_PIPE_BIT PIPELINE_STAGE_BOTTOM_OF_PIPE_BIT}.</p>
 * </div>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>Each element of {@code pImageIndices} <b>must</b> be the index of a presentable image acquired from the swapchain specified by the corresponding element of the {@code pSwapchains} array, and the presented image subresource <b>must</b> be in the {@link KHRSwapchain#VK_IMAGE_LAYOUT_PRESENT_SRC_KHR IMAGE_LAYOUT_PRESENT_SRC_KHR} or {@link KHRSharedPresentableImage#VK_IMAGE_LAYOUT_SHARED_PRESENT_KHR IMAGE_LAYOUT_SHARED_PRESENT_KHR} layout at the time the operation is executed on a {@code VkDevice}</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link KHRSwapchain#VK_STRUCTURE_TYPE_PRESENT_INFO_KHR STRUCTURE_TYPE_PRESENT_INFO_KHR}</li>
 * <li>Each {@code pNext} member of any structure (including this one) in the {@code pNext} chain <b>must</b> be either {@code NULL} or a pointer to a valid instance of {@link VkDeviceGroupPresentInfoKHR}, {@link VkDisplayPresentInfoKHR}, {@link VkPresentRegionsKHR}, or {@link VkPresentTimesInfoGOOGLE}</li>
 * <li>Each {@code sType} member in the {@code pNext} chain <b>must</b> be unique</li>
 * <li>If {@code waitSemaphoreCount} is not 0, {@code pWaitSemaphores} <b>must</b> be a valid pointer to an array of {@code waitSemaphoreCount} valid {@code VkSemaphore} handles</li>
 * <li>{@code pSwapchains} <b>must</b> be a valid pointer to an array of {@code swapchainCount} valid {@code VkSwapchainKHR} handles</li>
 * <li>{@code pImageIndices} <b>must</b> be a valid pointer to an array of {@code swapchainCount} {@code uint32_t} values</li>
 * <li>If {@code pResults} is not {@code NULL}, {@code pResults} <b>must</b> be a valid pointer to an array of {@code swapchainCount} {@code VkResult} values</li>
 * <li>{@code swapchainCount} <b>must</b> be greater than 0</li>
 * <li>Both of the elements of {@code pSwapchains}, and the elements of {@code pWaitSemaphores} that are valid handles <b>must</b> have been created, allocated, or retrieved from the same {@code VkInstance}</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link KHRSwapchain#vkQueuePresentKHR QueuePresentKHR}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code waitSemaphoreCount} &ndash; the number of semaphores to wait for before issuing the present request. The number <b>may</b> be zero.</li>
 * <li>{@code pWaitSemaphores} &ndash; if not {@code NULL}, is an array of {@code VkSemaphore} objects with {@code waitSemaphoreCount} entries, and specifies the semaphores to wait for before issuing the present request.</li>
 * <li>{@code swapchainCount} &ndash; the number of swapchains being presented to by this command.</li>
 * <li>{@code pSwapchains} &ndash; an array of {@code VkSwapchainKHR} objects with {@code swapchainCount} entries. A given swapchain <b>must</b> not appear in this list more than once.</li>
 * <li>{@code pImageIndices} &ndash; an array of indices into the array of each swapchain&#8217;s presentable images, with {@code swapchainCount} entries. Each entry in this array identifies the image to present on the corresponding entry in the {@code pSwapchains} array.</li>
 * <li>{@code pResults} &ndash; an array of {@code VkResult} typed elements with {@code swapchainCount} entries. Applications that do not need per-swapchain results <b>can</b> use {@code NULL} for {@code pResults}. If non-{@code NULL}, each entry in {@code pResults} will be set to the {@code VkResult} for presenting the swapchain corresponding to the same index in {@code pSwapchains}.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPresentInfoKHR {
 *     VkStructureType sType;
 *     void const * pNext;
 *     uint32_t waitSemaphoreCount;
 *     VkSemaphore const * pWaitSemaphores;
 *     uint32_t swapchainCount;
 *     VkSwapchainKHR const * pSwapchains;
 *     uint32_t const * pImageIndices;
 *     VkResult * pResults;
 * }</code></pre>
 */
class PresentInfoKHR(
        var waitSemaphores: VkSemaphore_Array? = null,
        var swapchains: VkSwapchainKHR_Array,
        var imageIndices: IntArray,
        var results: VkResult_Array? = null,
        var next: Ptr = NULL
) {

    constructor(
            waitSemaphore: VkSemaphore? = null,
            swapchain: VkSwapchainKHR = VkSwapchainKHR.NULL,
            imageIndex: Int,
            result: VkResult_Array? = null
    ) : this(
            waitSemaphore?.let { s -> VkSemaphore_Array(1) { s } },
            VkSwapchainKHR_Array(1) { swapchain },
            intArrayOf(imageIndex),
            result
    )

    val type get() = VkStructureType.PRESENT_INFO_KHR

    var swapchain: VkSwapchainKHR
        get() = swapchains[0]
        set(value) {
            swapchains[0] = value
        }

    var imageIndex: Int
        get() = imageIndices[0]
        set(value) {
            imageIndices[0] = value
        }

    // write and maybe read
    fun <R> native(stack: MemoryStack, block: (Ptr) -> R): R {
        val adr = stack.ncalloc(VkPresentInfoKHR.ALIGNOF, 1, VkPresentInfoKHR.SIZEOF)
        VkPresentInfoKHR.nsType(adr, type.i)
        VkPresentInfoKHR.npNext(adr, next)
        waitSemaphores?.let {
            VkPresentInfoKHR.nwaitSemaphoreCount(adr, it.size)
            memPutAddress(adr + VkPresentInfoKHR.PWAITSEMAPHORES, it.write(stack))
        }
        VkPresentInfoKHR.nswapchainCount(adr, swapchains.size)
        memPutAddress(adr + VkPresentInfoKHR.PSWAPCHAINS, swapchains.write(stack))
        memPutAddress(adr + VkPresentInfoKHR.PIMAGEINDICES, imageIndices.toAdr(stack).adr)
        return when (val results = results) {
            null -> block(adr)
            else -> {
                val pResults = stack.mInt(swapchains.size)
                memPutAddress(adr + VkPresentInfoKHR.PRESULTS, pResults.adr)
                block(adr).also {
                    for (i in results.indices)
                        results[i] = VkResult(pResults[i])
                }
            }
        }
    }
}

/**
 * Specify that an image will be bound to swapchain memory.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>If {@code swapchain} is not {@link VK10#VK_NULL_HANDLE NULL_HANDLE}, the fields of {@link VkImageCreateInfo} <b>must</b> match the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#swapchain-wsi-image-create-info">implied image creation parameters</a> of the swapchain</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link KHRSwapchain#VK_STRUCTURE_TYPE_IMAGE_SWAPCHAIN_CREATE_INFO_KHR STRUCTURE_TYPE_IMAGE_SWAPCHAIN_CREATE_INFO_KHR}</li>
 * <li>If {@code swapchain} is not {@link VK10#VK_NULL_HANDLE NULL_HANDLE}, {@code swapchain} <b>must</b> be a valid {@code VkSwapchainKHR} handle</li>
 * </ul>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code swapchain} &ndash; {@link VK10#VK_NULL_HANDLE NULL_HANDLE} or a handle of a swapchain that the image will be bound to.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkImageSwapchainCreateInfoKHR {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkSwapchainKHR swapchain;
 * }</code></pre>
 */
class ImageSwapchainCreateInfoKHR(
        var swapchain: VkSwapchainKHR,
        var next: Ptr) {

    val type get() = VkStructureType.IMAGE_SWAPCHAIN_CREATE_INFO_KHR
}

/**
 * Structure specifying swapchain image memory to bind to.
 *
 * <h5>Description</h5>
 *
 * <p>If {@code swapchain} is not {@code NULL}, the {@code swapchain} and {@code imageIndex} are used to determine the memory that the image is bound to, instead of {@code memory} and {@code memoryOffset}.</p>
 *
 * <p>Memory <b>can</b> be bound to a swapchain and use the {@code pDeviceIndices} or {@code pSplitInstanceBindRegions} members of {@link VkBindImageMemoryDeviceGroupInfo}.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code imageIndex} <b>must</b> be less than the number of images in {@code swapchain}</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link KHRSwapchain#VK_STRUCTURE_TYPE_BIND_IMAGE_MEMORY_SWAPCHAIN_INFO_KHR STRUCTURE_TYPE_BIND_IMAGE_MEMORY_SWAPCHAIN_INFO_KHR}</li>
 * <li>{@code swapchain} <b>must</b> be a valid {@code VkSwapchainKHR} handle</li>
 * </ul>
 *
 * <h5>Host Synchronization</h5>
 *
 * <ul>
 * <li>Host access to {@code swapchain} <b>must</b> be externally synchronized</li>
 * </ul>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code swapchain} &ndash; {@link VK10#VK_NULL_HANDLE NULL_HANDLE} or a swapchain handle.</li>
 * <li>{@code imageIndex} &ndash; an image index within {@code swapchain}.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkBindImageMemorySwapchainInfoKHR {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkSwapchainKHR swapchain;
 *     uint32_t imageIndex;
 * }</code></pre>
 */
class BindImageMemorySwapchainInfoKHR(
        var swapchain: VkSwapchainKHR,
        var imageIndex: Int,
        var next: Ptr) {

    val type get() = VkStructureType.BIND_IMAGE_MEMORY_SWAPCHAIN_INFO_KHR
}

/**
 * Structure specifying parameters of the acquire.
 *
 * <h5>Description</h5>
 *
 * <p>If {@link KHRSwapchain#vkAcquireNextImageKHR AcquireNextImageKHR} is used, the device mask is considered to include all physical devices in the logical device.</p>
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>{@link KHRSwapchain#vkAcquireNextImage2KHR AcquireNextImage2KHR} signals at most one semaphore, even if the application requests waiting for multiple physical devices to be ready via the {@code deviceMask}. However, only a single physical device <b>can</b> wait on that semaphore, since the semaphore becomes unsignaled when the wait succeeds. For other physical devices to wait for the image to be ready, it is necessary for the application to submit semaphore signal operation(s) to that first physical device to signal additional semaphore(s) after the wait succeeds, which the other physical device(s) <b>can</b> wait upon.</p>
 * </div>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code swapchain} <b>must</b> not be in the retired state</li>
 * <li>If {@code semaphore} is not {@link VK10#VK_NULL_HANDLE NULL_HANDLE} it <b>must</b> be unsignaled</li>
 * <li>If {@code semaphore} is not {@link VK10#VK_NULL_HANDLE NULL_HANDLE} it <b>must</b> not have any uncompleted signal or wait operations pending</li>
 * <li>If {@code fence} is not {@link VK10#VK_NULL_HANDLE NULL_HANDLE} it <b>must</b> be unsignaled and <b>must</b> not be associated with any other queue command that has not yet completed execution on that queue</li>
 * <li>{@code semaphore} and {@code fence} <b>must</b> not both be equal to {@link VK10#VK_NULL_HANDLE NULL_HANDLE}</li>
 * <li>{@code deviceMask} <b>must</b> be a valid device mask</li>
 * <li>{@code deviceMask} <b>must</b> not be zero</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link KHRSwapchain#VK_STRUCTURE_TYPE_ACQUIRE_NEXT_IMAGE_INFO_KHR STRUCTURE_TYPE_ACQUIRE_NEXT_IMAGE_INFO_KHR}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL}</li>
 * <li>{@code swapchain} <b>must</b> be a valid {@code VkSwapchainKHR} handle</li>
 * <li>If {@code semaphore} is not {@link VK10#VK_NULL_HANDLE NULL_HANDLE}, {@code semaphore} <b>must</b> be a valid {@code VkSemaphore} handle</li>
 * <li>If {@code fence} is not {@link VK10#VK_NULL_HANDLE NULL_HANDLE}, {@code fence} <b>must</b> be a valid {@code VkFence} handle</li>
 * <li>Each of {@code fence}, {@code semaphore}, and {@code swapchain} that are valid handles <b>must</b> have been created, allocated, or retrieved from the same {@code VkInstance}</li>
 * </ul>
 *
 * <h5>Host Synchronization</h5>
 *
 * <ul>
 * <li>Host access to {@code swapchain} <b>must</b> be externally synchronized</li>
 * <li>Host access to {@code semaphore} <b>must</b> be externally synchronized</li>
 * <li>Host access to {@code fence} <b>must</b> be externally synchronized</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link KHRSwapchain#vkAcquireNextImage2KHR AcquireNextImage2KHR}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code swapchain} &ndash; a non-retired swapchain from which an image is acquired.</li>
 * <li>{@code timeout} &ndash; specifies how long the function waits, in nanoseconds, if no image is available.</li>
 * <li>{@code semaphore} &ndash; {@link VK10#VK_NULL_HANDLE NULL_HANDLE} or a semaphore to signal.</li>
 * <li>{@code fence} &ndash; {@link VK10#VK_NULL_HANDLE NULL_HANDLE} or a fence to signal.</li>
 * <li>{@code deviceMask} &ndash; a mask of physical devices for which the swapchain image will be ready to use when the semaphore or fence is signaled.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkAcquireNextImageInfoKHR {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkSwapchainKHR swapchain;
 *     uint64_t timeout;
 *     VkSemaphore semaphore;
 *     VkFence fence;
 *     uint32_t deviceMask;
 * }</code></pre>
 */
class AcquireNextImageInfoKHR(
        var swapchain: VkSwapchainKHR,
        var timeout: Long,
        var semaphore: VkSemaphore,
        var fence: VkFence,
        var deviceMask: Int) {

    val type get() = VkStructureType.ACQUIRE_NEXT_IMAGE_INFO_KHR

    infix fun write(stack: MemoryStack): Adr {
        val adr = stack.ncalloc(VkAcquireNextImageInfoKHR.ALIGNOF, 1, VkAcquireNextImageInfoKHR.SIZEOF)
        VkAcquireNextImageInfoKHR.nsType(adr, type.i)
        // pNext must be null
        VkAcquireNextImageInfoKHR.nswapchain(adr, swapchain.L)
        VkAcquireNextImageInfoKHR.ntimeout(adr, timeout)
        VkAcquireNextImageInfoKHR.nsemaphore(adr, semaphore.L)
        VkAcquireNextImageInfoKHR.nfence(adr, fence.L)
        VkAcquireNextImageInfoKHR.ndeviceMask(adr, deviceMask)
        return adr
    }
}

/**
 * Present capabilities from other physical devices.
 *
 * <h5>Description</h5>
 *
 * <p>{@code modes} always has {@link KHRSwapchain#VK_DEVICE_GROUP_PRESENT_MODE_LOCAL_BIT_KHR DEVICE_GROUP_PRESENT_MODE_LOCAL_BIT_KHR} set.</p>
 *
 * <p>The present mode flags are also used when presenting an image, in {@link VkDeviceGroupPresentInfoKHR}{@code ::mode}.</p>
 *
 * <p>If a device group only includes a single physical device, then {@code modes} <b>must</b> equal {@link KHRSwapchain#VK_DEVICE_GROUP_PRESENT_MODE_LOCAL_BIT_KHR DEVICE_GROUP_PRESENT_MODE_LOCAL_BIT_KHR}.</p>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link KHRSwapchain#VK_STRUCTURE_TYPE_DEVICE_GROUP_PRESENT_CAPABILITIES_KHR STRUCTURE_TYPE_DEVICE_GROUP_PRESENT_CAPABILITIES_KHR}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL}</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link KHRSwapchain#vkGetDeviceGroupPresentCapabilitiesKHR GetDeviceGroupPresentCapabilitiesKHR}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code presentMask[VK_MAX_DEVICE_GROUP_SIZE]} &ndash; an array of masks, where the mask at element <code>i</code> is non-zero if physical device <code>i</code> has a presentation engine, and where bit <code>j</code> is set in element <code>i</code> if physical device <code>i</code> <b>can</b> present swapchain images from physical device <code>j</code>. If element <code>i</code> is non-zero, then bit <code>i</code> <b>must</b> be set.</li>
 * <li>{@code modes} &ndash; a bitmask of {@code VkDeviceGroupPresentModeFlagBitsKHR} indicating which device group presentation modes are supported.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkDeviceGroupPresentCapabilitiesKHR {
 *     VkStructureType sType;
 *     void const * pNext;
 *     uint32_t presentMask[VK_MAX_DEVICE_GROUP_SIZE];
 *     VkDeviceGroupPresentModeFlagsKHR modes;
 * }</code></pre>
 */
class DeviceGroupPresentCapabilitiesKHR(
        var presentMask: IntArray, // [VK_MAX_DEVICE_GROUP_SIZE]
        var modes: VkDeviceGroupPresentModeFlagsKHR) {

    val type get() = VkStructureType.DEVICE_GROUP_PRESENT_CAPABILITIES_KHR

    constructor(ptr: BytePtr) : this(
            IntArray(VK_MAX_DEVICE_GROUP_SIZE) { VkDeviceGroupPresentCapabilitiesKHR.npresentMask(ptr.adr, it) },
            VkDeviceGroupPresentCapabilitiesKHR.nmodes(ptr.adr))

    companion object {
        //        inline infix fun <R> read(block: (Adr) -> R): PhysicalDeviceProperties2 = stak { read(it, block) }
        inline fun <R> read(stack: MemoryStack, block: (Adr) -> R): DeviceGroupPresentCapabilitiesKHR {
            val adr = stack.ncalloc(VkDeviceGroupPresentCapabilitiesKHR.ALIGNOF, 1, VkDeviceGroupPresentCapabilitiesKHR.SIZEOF)
            block(adr)
            return DeviceGroupPresentCapabilitiesKHR(BytePtr(adr))
        }
    }
}

/**
 * Mode and mask controlling which physical devices' images are presented.
 *
 * <h5>Description</h5>
 *
 * <p>If {@code mode} is {@link KHRSwapchain#VK_DEVICE_GROUP_PRESENT_MODE_LOCAL_BIT_KHR DEVICE_GROUP_PRESENT_MODE_LOCAL_BIT_KHR}, then each element of {@code pDeviceMasks} selects which instance of the swapchain image is presented. Each element of {@code pDeviceMasks} <b>must</b> have exactly one bit set, and the corresponding physical device <b>must</b> have a presentation engine as reported by {@link VkDeviceGroupPresentCapabilitiesKHR}.</p>
 *
 * <p>If {@code mode} is {@link KHRSwapchain#VK_DEVICE_GROUP_PRESENT_MODE_REMOTE_BIT_KHR DEVICE_GROUP_PRESENT_MODE_REMOTE_BIT_KHR}, then each element of {@code pDeviceMasks} selects which instance of the swapchain image is presented. Each element of {@code pDeviceMasks} <b>must</b> have exactly one bit set, and some physical device in the logical device <b>must</b> include that bit in its {@link VkDeviceGroupPresentCapabilitiesKHR}{@code ::presentMask}.</p>
 *
 * <p>If {@code mode} is {@link KHRSwapchain#VK_DEVICE_GROUP_PRESENT_MODE_SUM_BIT_KHR DEVICE_GROUP_PRESENT_MODE_SUM_BIT_KHR}, then each element of {@code pDeviceMasks} selects which instances of the swapchain image are component-wise summed and the sum of those images is presented. If the sum in any component is outside the representable range, the value of that component is undefined. Each element of {@code pDeviceMasks} <b>must</b> have a value for which all set bits are set in one of the elements of {@link VkDeviceGroupPresentCapabilitiesKHR}{@code ::presentMask}.</p>
 *
 * <p>If {@code mode} is {@link KHRSwapchain#VK_DEVICE_GROUP_PRESENT_MODE_LOCAL_MULTI_DEVICE_BIT_KHR DEVICE_GROUP_PRESENT_MODE_LOCAL_MULTI_DEVICE_BIT_KHR}, then each element of {@code pDeviceMasks} selects which instance(s) of the swapchain images are presented. For each bit set in each element of {@code pDeviceMasks}, the corresponding physical device <b>must</b> have a presentation engine as reported by {@link VkDeviceGroupPresentCapabilitiesKHR}.</p>
 *
 * <p>If {@link VkDeviceGroupPresentInfoKHR} is not provided or {@code swapchainCount} is zero then the masks are considered to be 1. If {@link VkDeviceGroupPresentInfoKHR} is not provided, {@code mode} is considered to be {@link KHRSwapchain#VK_DEVICE_GROUP_PRESENT_MODE_LOCAL_BIT_KHR DEVICE_GROUP_PRESENT_MODE_LOCAL_BIT_KHR}.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code swapchainCount} <b>must</b> equal 0 or {@link VkPresentInfoKHR}{@code ::swapchainCount}</li>
 * <li>If {@code mode} is {@link KHRSwapchain#VK_DEVICE_GROUP_PRESENT_MODE_LOCAL_BIT_KHR DEVICE_GROUP_PRESENT_MODE_LOCAL_BIT_KHR}, then each element of {@code pDeviceMasks} <b>must</b> have exactly one bit set, and the corresponding element of {@link VkDeviceGroupPresentCapabilitiesKHR}{@code ::presentMask} <b>must</b> be non-zero</li>
 * <li>If {@code mode} is {@link KHRSwapchain#VK_DEVICE_GROUP_PRESENT_MODE_REMOTE_BIT_KHR DEVICE_GROUP_PRESENT_MODE_REMOTE_BIT_KHR}, then each element of {@code pDeviceMasks} <b>must</b> have exactly one bit set, and some physical device in the logical device <b>must</b> include that bit in its {@link VkDeviceGroupPresentCapabilitiesKHR}{@code ::presentMask}.</li>
 * <li>If {@code mode} is {@link KHRSwapchain#VK_DEVICE_GROUP_PRESENT_MODE_SUM_BIT_KHR DEVICE_GROUP_PRESENT_MODE_SUM_BIT_KHR}, then each element of {@code pDeviceMasks} <b>must</b> have a value for which all set bits are set in one of the elements of {@link VkDeviceGroupPresentCapabilitiesKHR}{@code ::presentMask}</li>
 * <li>If {@code mode} is {@link KHRSwapchain#VK_DEVICE_GROUP_PRESENT_MODE_LOCAL_MULTI_DEVICE_BIT_KHR DEVICE_GROUP_PRESENT_MODE_LOCAL_MULTI_DEVICE_BIT_KHR}, then for each bit set in each element of {@code pDeviceMasks}, the corresponding element of {@link VkDeviceGroupPresentCapabilitiesKHR}{@code ::presentMask} <b>must</b> be non-zero</li>
 * <li>The value of each element of {@code pDeviceMasks} <b>must</b> be equal to the device mask passed in {@link VkAcquireNextImageInfoKHR}{@code ::deviceMask} when the image index was last acquired</li>
 * <li>{@code mode} <b>must</b> have exactly one bit set, and that bit <b>must</b> have been included in {@link VkDeviceGroupSwapchainCreateInfoKHR}{@code ::modes}</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link KHRSwapchain#VK_STRUCTURE_TYPE_DEVICE_GROUP_PRESENT_INFO_KHR STRUCTURE_TYPE_DEVICE_GROUP_PRESENT_INFO_KHR}</li>
 * <li>If {@code swapchainCount} is not 0, {@code pDeviceMasks} <b>must</b> be a valid pointer to an array of {@code swapchainCount} {@code uint32_t} values</li>
 * <li>{@code mode} <b>must</b> be a valid {@code VkDeviceGroupPresentModeFlagBitsKHR} value</li>
 * </ul>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code swapchainCount} &ndash; zero or the number of elements in {@code pDeviceMasks}.</li>
 * <li>{@code pDeviceMasks} &ndash; an array of device masks, one for each element of {@link VkPresentInfoKHR}::pSwapchains.</li>
 * <li>{@code mode} &ndash; the device group present mode that will be used for this present.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkDeviceGroupPresentInfoKHR {
 *     VkStructureType sType;
 *     void const * pNext;
 *     uint32_t swapchainCount;
 *     uint32_t const * pDeviceMasks;
 *     VkDeviceGroupPresentModeFlagBitsKHR mode;
 * }</code></pre>
 */
class DeviceGroupPresentInfoKHR(
        var deviceMasks: IntArray?,
        var mode: VkDeviceGroupPresentModeFlagsKHR,
        var next: Ptr) {

    val type get() = VkStructureType.DEVICE_GROUP_PRESENT_INFO_KHR
}

/**
 * Structure specifying parameters of a newly created swapchain object.
 *
 * <h5>Description</h5>
 *
 * <p>If this structure is not present, {@code modes} is considered to be {@link KHRSwapchain#VK_DEVICE_GROUP_PRESENT_MODE_LOCAL_BIT_KHR DEVICE_GROUP_PRESENT_MODE_LOCAL_BIT_KHR}.</p>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link KHRSwapchain#VK_STRUCTURE_TYPE_DEVICE_GROUP_SWAPCHAIN_CREATE_INFO_KHR STRUCTURE_TYPE_DEVICE_GROUP_SWAPCHAIN_CREATE_INFO_KHR}</li>
 * <li>{@code modes} <b>must</b> be a valid combination of {@code VkDeviceGroupPresentModeFlagBitsKHR} values</li>
 * <li>{@code modes} <b>must</b> not be 0</li>
 * </ul>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code modes} &ndash; a bitfield of modes that the swapchain <b>can</b> be used with.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkDeviceGroupSwapchainCreateInfoKHR {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkDeviceGroupPresentModeFlagsKHR modes;
 * }</code></pre>
 */
class DeviceGroupSwapchainCreateInfoKHR(
        var modes: VkDeviceGroupPresentModeFlagsKHR,
        var next: Ptr) {

    val type get() = VkStructureType.DEVICE_GROUP_SWAPCHAIN_CREATE_INFO_KHR
}

interface Device_KHR_swapchain : Pointer {

    val capabilities: CapabilitiesDevice

    // --- [ vkCreateSwapchainKHR ] ---

    infix fun MemoryStack.createSwapchainKHR(createInfo: SwapchainCreateInfoKHR): VkSwapchainKHR =
            framed { VkSwapchainKHR(this.longAdr { VK_CHECK_RESULT(callPPPPI(this@Device_KHR_swapchain.adr, createInfo write this, NULL, it, capabilities.vkCreateSwapchainKHR)) }) }

    infix fun createSwapchainKHR(createInfo: SwapchainCreateInfoKHR): VkSwapchainKHR =
            stak { it createSwapchainKHR createInfo }

    // --- [ vkDestroySwapchainKHR ] ---
    infix fun destroy(swapchain: VkSwapchainKHR) =
            callPJPV(adr, swapchain.L, NULL, capabilities.vkDestroySwapchainKHR)

    // --- [ vkGetSwapchainImagesKHR ] ---

    infix fun MemoryStack.getSwapchainImagesKHR(swapchain: VkSwapchainKHR): VkImage_Array =
            framed {
                var pSwapchainImages = LongPtr.NULL
                val pSwapchainImageCount = this.mInt()
                var swapchainImageCount: Int
                var result: VkResult
                do {
                    result = nGetSwapchainImagesKHR(swapchain, pSwapchainImageCount.adr)
                    swapchainImageCount = pSwapchainImageCount[0]
                    if (result == VkResult.SUCCESS && swapchainImageCount != 0) {
                        pSwapchainImages = this.mLong(swapchainImageCount)
                        result = nGetSwapchainImagesKHR(swapchain, pSwapchainImageCount.adr, pSwapchainImages.adr)
                    }
                } while (result == VkResult.INCOMPLETE)
                VkImage_Array(swapchainImageCount) { VkImage(pSwapchainImages[it]) }
            }

    infix fun getSwapchainImagesKHR(swapchain: VkSwapchainKHR): VkImage_Array =
            stak { it getSwapchainImagesKHR swapchain }


    // --- [ vkAcquireNextImageKHR ] ---

    fun MemoryStack.acquireNextImageKHR(swapchain: VkSwapchainKHR, timeout: Long = -1L, semaphore: VkSemaphore, fence: VkFence = VkFence.NULL, check: (VkResult) -> Unit = ::defaultCheck): Int =
            framed { this.intAdr { check(nAcquireNextImageKHR(swapchain, timeout, semaphore, fence, it)) } }

    fun acquireNextImageKHR(swapchain: VkSwapchainKHR, timeout: Long = -1L, semaphore: VkSemaphore, fence: VkFence = VkFence.NULL, check: (VkResult) -> Unit = ::defaultCheck): Int =
            stak { it.acquireNextImageKHR(swapchain, timeout, semaphore, fence, check) }


    // --- [ vkGetDeviceGroupPresentCapabilitiesKHR ] ---

    val MemoryStack.groupPresentCapabilitiesKHR: DeviceGroupPresentCapabilitiesKHR
        get() = DeviceGroupPresentCapabilitiesKHR.read(this) { callPPI(this@Device_KHR_swapchain.adr, it, capabilities.vkGetDeviceGroupPresentCapabilitiesKHR) }

    val groupPresentCapabilitiesKHR: DeviceGroupPresentCapabilitiesKHR
        get() = stak { it.groupPresentCapabilitiesKHR }


    // --- [ vkGetDeviceGroupSurfacePresentModesKHR ] ---

    infix fun MemoryStack.getGroupSurfacePresentModesKHR(surface: VkSurfaceKHR): VkDeviceGroupPresentModeFlagsKHR =
            intAdr { callPJPI(this@Device_KHR_swapchain.adr, surface.L, it, capabilities.vkGetDeviceGroupSurfacePresentModesKHR) }

    infix fun getGroupSurfacePresentModesKHR(surface: VkSurfaceKHR): VkDeviceGroupPresentModeFlagsKHR =
            stak { it getGroupSurfacePresentModesKHR surface }

    // --- [ vkAcquireNextImage2KHR ] ---

    infix fun MemoryStack.acquireNextImage2KHR(acquireInfo: AcquireNextImageInfoKHR): Int {
        val pImageIndex = this.mInt()
        VK_CHECK_RESULT(callPPPI(this@Device_KHR_swapchain.adr, acquireInfo write this, pImageIndex.adr, capabilities.vkAcquireNextImage2KHR))
        return pImageIndex()
    }

    infix fun acquireNextImage2KHR(acquireInfo: AcquireNextImageInfoKHR): Int =
            stak { it acquireNextImage2KHR acquireInfo }
}

inline fun Device_KHR_swapchain.nGetSwapchainImagesKHR(swapchain: VkSwapchainKHR, pSwapchainImageCount: Ptr, pSwapchainImages: Ptr = NULL): VkResult =
        VkResult(callPJPPI(adr, swapchain.L, pSwapchainImageCount, pSwapchainImages, capabilities.vkGetSwapchainImagesKHR))

inline fun Device_KHR_swapchain.nAcquireNextImageKHR(swapchain: VkSwapchainKHR, timeout: Long = -1L, semaphore: VkSemaphore, fence: VkFence = VkFence.NULL, pImage: Ptr): VkResult =
        VkResult(callPJJJJPI(adr, swapchain.L, timeout, semaphore.L, fence.L, pImage, capabilities.vkAcquireNextImageKHR))

interface Queue_KHR_swapchain : Pointer {

    val capabilities: CapabilitiesDevice

    // --- [ vkQueuePresentKHR ] ---

    infix fun MemoryStack.presentKHR(presentInfo: PresentInfoKHR): VkResult =
            framed { presentInfo.native(this) { pPresentInfo -> VkResult(callPPI(this@Queue_KHR_swapchain.adr, pPresentInfo, capabilities.vkQueuePresentKHR)).andCheck() } }

    infix fun presentKHR(presentInfo: PresentInfoKHR): VkResult =
            stak { it presentKHR presentInfo }
}


interface PhysicalDevice_KHR_swapchain : Pointer {

    val capabilities: CapabilitiesInstance

    // --- [ vkGetPhysicalDevicePresentRectanglesKHR ] ---

    infix fun MemoryStack.getPresentRectanglesKHR(surface: VkSurfaceKHR): Array<Rect2D> {
        var rects: Ptr = NULL
        val pRectCount = this.mInt()
        var rectCount: Int
        do {
            var result = nGetPresentRectanglesKHR(surface, pRectCount.adr)
            rectCount = pRectCount()
            if (result == VkResult.SUCCESS && rectCount != 0) {
                rects = this.ncalloc(VkRect2D.ALIGNOF, size, VkRect2D.SIZEOF)
                result = nGetPresentRectanglesKHR(surface, pRectCount.adr, rects)
            }
        } while (result == VkResult.INCOMPLETE)
        return Array(rectCount) { Rect2D(IntPtr(rects + it * VkRect2D.SIZEOF)) }
    }

    infix fun getPresentRectanglesKHR(surface: VkSurfaceKHR): Array<Rect2D> =
            stak { it getPresentRectanglesKHR surface }
}

inline fun PhysicalDevice_KHR_swapchain.nGetPresentRectanglesKHR(surface: VkSurfaceKHR, pRectCount: Ptr, pRects: Ptr = NULL): VkResult =
        VkResult(callPJPPI(adr, surface.L, pRectCount, pRects, capabilities.vkGetPhysicalDevicePresentRectanglesKHR))