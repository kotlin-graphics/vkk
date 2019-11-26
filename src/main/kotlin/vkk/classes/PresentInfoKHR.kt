package classes

import glm_.BYTES
import kool.Ptr
import kool.adr
import kool.toBuffer
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.vulkan.VkPresentInfoKHR
import org.lwjgl.vulkan.VkPresentInfoKHR.*
import util.VkResult_Array
import util.native
import util.nmallocInt
import vkk.VkResult
import vkk.VkStructureType
import vkk.entities.VkSemaphore
import vkk.entities.VkSemaphore_Array
import vkk.entities.VkSwapchainKHR
import vkk.entities.VkSwapchainKHR_Array

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
        waitSemaphore: VkSemaphore,
        swapchain: VkSwapchainKHR = VkSwapchainKHR.NULL,
        imageIndex: Int,
        result: VkResult_Array? = null
    ) : this(
        VkSemaphore_Array(1) { waitSemaphore },
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

    fun <R> native(stack: MemoryStack, block: (Ptr) -> R): R {
        val ptr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
        nsType(ptr, type.i)
        npNext(ptr, next)
        waitSemaphores?.let {
            nwaitSemaphoreCount(ptr, it.size)
            memPutAddress(ptr + PWAITSEMAPHORES, it.native(stack))
        }
        nswapchainCount(ptr, swapchains.size)
        memPutAddress(ptr + PSWAPCHAINS, swapchains.native(stack))
        memPutAddress(ptr + PIMAGEINDICES, imageIndices.toBuffer(stack).adr)
        return when(val results = results) {
            null -> block(ptr)
            else -> {
                val pResults = stack.nmallocInt(swapchains.size)
                memPutAddress(ptr + PRESULTS, pResults)
                block(ptr).also {
                    for (i in results.indices)
                        results[i] = VkResult(memGetInt(pResults + i * Int.BYTES))
                }
            }
        }
    }
}