package vkk._11.structs

import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.vulkan.VkBindBufferMemoryInfo
import org.lwjgl.vulkan.VkBindImageMemoryInfo
import org.lwjgl.vulkan.VkBindImageMemoryInfo.*
import vkk.VkStructureType
import vkk.entities.VkDeviceMemory
import vkk.entities.VkDeviceSize
import vkk.entities.VkImage

/**
 * Structure specifying how to bind an image to memory.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code image} <b>must</b> not already be backed by a memory object</li>
 * <li>{@code image} <b>must</b> not have been created with any sparse memory binding flags</li>
 * <li>{@code memoryOffset} <b>must</b> be less than the size of {@code memory}</li>
 * <li>If the {@code pNext} chain does not include an instance of the {@link VkBindImagePlaneMemoryInfo} structure, {@code memory} <b>must</b> have been allocated using one of the memory types allowed in the {@code memoryTypeBits} member of the {@link VkMemoryRequirements} structure returned from a call to {@link VK11#vkGetImageMemoryRequirements2 GetImageMemoryRequirements2} with {@code image}</li>
 * <li>If the {@code pNext} chain does not include an instance of the {@link VkBindImagePlaneMemoryInfo} structure, {@code memoryOffset} <b>must</b> be an integer multiple of the {@code alignment} member of the {@link VkMemoryRequirements} structure returned from a call to {@link VK11#vkGetImageMemoryRequirements2 GetImageMemoryRequirements2} with {@code image}</li>
 * <li>If the {@code pNext} chain does not include an instance of the {@link VkBindImagePlaneMemoryInfo} structure, the difference of the size of {@code memory} and {@code memoryOffset} <b>must</b> be greater than or equal to the {@code size} member of the {@link VkMemoryRequirements} structure returned from a call to {@link VK11#vkGetImageMemoryRequirements2 GetImageMemoryRequirements2} with the same {@code image}</li>
 * <li>If the {@code pNext} chain includes an instance of the {@link VkBindImagePlaneMemoryInfo} structure, {@code image} <b>must</b> have been created with the {@link VK11#VK_IMAGE_CREATE_DISJOINT_BIT IMAGE_CREATE_DISJOINT_BIT} bit set.</li>
 * <li>If the {@code pNext} chain includes an instance of the {@link VkBindImagePlaneMemoryInfo} structure, {@code memory} <b>must</b> have been allocated using one of the memory types allowed in the {@code memoryTypeBits} member of the {@link VkMemoryRequirements} structure returned from a call to {@link VK11#vkGetImageMemoryRequirements2 GetImageMemoryRequirements2} with {@code image} and the correct {@code planeAspect} for this plane in the {@link VkImagePlaneMemoryRequirementsInfo} structure attached to the {@link VkImageMemoryRequirementsInfo2}&#8217;s {@code pNext} chain</li>
 * <li>If the {@code pNext} chain includes an instance of the {@link VkBindImagePlaneMemoryInfo} structure, {@code memoryOffset} <b>must</b> be an integer multiple of the {@code alignment} member of the {@link VkMemoryRequirements} structure returned from a call to {@link VK11#vkGetImageMemoryRequirements2 GetImageMemoryRequirements2} with {@code image} and the correct {@code planeAspect} for this plane in the {@link VkImagePlaneMemoryRequirementsInfo} structure attached to the {@link VkImageMemoryRequirementsInfo2}&#8217;s {@code pNext} chain</li>
 * <li>If the {@code pNext} chain includes an instance of the {@link VkBindImagePlaneMemoryInfo} structure, the difference of the size of {@code memory} and {@code memoryOffset} <b>must</b> be greater than or equal to the {@code size} member of the {@link VkMemoryRequirements} structure returned from a call to {@link VK11#vkGetImageMemoryRequirements2 GetImageMemoryRequirements2} with the same {@code image} and the correct {@code planeAspect} for this plane in the {@link VkImagePlaneMemoryRequirementsInfo} structure attached to the {@link VkImageMemoryRequirementsInfo2}&#8217;s {@code pNext} chain</li>
 * <li>If {@code image} requires a dedicated allocation (as reported by {@link VK11#vkGetImageMemoryRequirements2 GetImageMemoryRequirements2} in {@link VkMemoryDedicatedRequirements}::requiresDedicatedAllocation for {@code image}), {@code memory} <b>must</b> have been created with {@link VkMemoryDedicatedAllocateInfo}{@code ::image} equal to {@code image} and {@code memoryOffset} <b>must</b> be zero</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-dedicatedAllocationImageAliasing">dedicated allocation image aliasing</a> feature is not enabled, and the {@link VkMemoryAllocateInfo} provided when {@code memory} was allocated included an instance of {@link VkMemoryDedicatedAllocateInfo} in its {@code pNext} chain, and {@link VkMemoryDedicatedAllocateInfo}{@code ::image} was not {@link VK10#VK_NULL_HANDLE NULL_HANDLE}, then {@code image} <b>must</b> equal {@link VkMemoryDedicatedAllocateInfo}{@code ::image} and {@code memoryOffset} <b>must</b> be zero.</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-dedicatedAllocationImageAliasing">dedicated allocation image aliasing</a> feature is enabled, and the {@link VkMemoryAllocateInfo} provided when {@code memory} was allocated included an instance of {@link VkMemoryDedicatedAllocateInfo} in its {@code pNext} chain, and {@link VkMemoryDedicatedAllocateInfo}{@code ::image} was not {@link VK10#VK_NULL_HANDLE NULL_HANDLE}, then {@code memoryOffset} <b>must</b> be zero, and {@code image} <b>must</b> be either equal to {@link VkMemoryDedicatedAllocateInfo}{@code ::image} or an image that was created using the same parameters in {@link VkImageCreateInfo}, with the exception that {@code extent} and {@code arrayLayers} <b>may</b> differ subject to the following restrictions: every dimension in the {@code extent} parameter of the image being bound <b>must</b> be equal to or smaller than the original image for which the allocation was created; and the {@code arrayLayers} parameter of the image being bound <b>must</b> be equal to or smaller than the original image for which the allocation was created.</li>
 * <li>If {@code image} was created with {@link VkDedicatedAllocationImageCreateInfoNV}{@code ::dedicatedAllocation} equal to {@link VK10#VK_TRUE TRUE}, {@code memory} <b>must</b> have been created with {@link VkDedicatedAllocationMemoryAllocateInfoNV}{@code ::image} equal to {@code image} and {@code memoryOffset} <b>must</b> be zero</li>
 * <li>If the {@code pNext} chain includes {@link VkBindImageMemoryDeviceGroupInfo}, all instances of {@code memory} specified by {@link VkBindImageMemoryDeviceGroupInfo}{@code ::pDeviceIndices} <b>must</b> have been allocated</li>
 * <li>If the {@code pNext} chain includes {@link VkBindImageMemoryDeviceGroupInfo}, and {@link VkBindImageMemoryDeviceGroupInfo}{@code ::splitInstanceBindRegionCount} is not zero, then {@code image} <b>must</b> have been created with the {@link VK11#VK_IMAGE_CREATE_SPLIT_INSTANCE_BIND_REGIONS_BIT IMAGE_CREATE_SPLIT_INSTANCE_BIND_REGIONS_BIT} bit set</li>
 * <li>If the {@code pNext} chain includes {@link VkBindImageMemoryDeviceGroupInfo}, all elements of {@link VkBindImageMemoryDeviceGroupInfo}{@code ::pSplitInstanceBindRegions} <b>must</b> be valid rectangles contained within the dimensions of {@code image}</li>
 * <li>If the {@code pNext} chain includes {@link VkBindImageMemoryDeviceGroupInfo}, the union of the areas of all elements of {@link VkBindImageMemoryDeviceGroupInfo}{@code ::pSplitInstanceBindRegions} that correspond to the same instance of {@code image} <b>must</b> cover the entire image.</li>
 * <li>If {@code image} was created with a valid swapchain handle in {@link VkImageSwapchainCreateInfoKHR}{@code ::swapchain}, then the {@code pNext} chain <b>must</b> include a valid instance of {@link VkBindImageMemorySwapchainInfoKHR} containing the same swapchain handle.</li>
 * <li>If the {@code pNext} chain includes an instance of {@link VkBindImageMemorySwapchainInfoKHR}, {@code memory} <b>must</b> be {@link VK10#VK_NULL_HANDLE NULL_HANDLE}</li>
 * <li>If the {@code pNext} chain does not include an instance of {@link VkBindImageMemorySwapchainInfoKHR}, {@code memory} <b>must</b> be a valid {@code VkDeviceMemory} handle</li>
 * <li>If the value of {@link VkExportMemoryAllocateInfo}{@code ::handleTypes} used to allocate {@code memory} is not 0, it <b>must</b> include at least one of the handles set in {@link VkExternalMemoryImageCreateInfo}{@code ::handleTypes} when {@code image} was created</li>
 * <li>If {@code memory} was created by a memory import operation, the external handle type of the imported memory <b>must</b> also have been set in {@link VkExternalMemoryImageCreateInfo}{@code ::handleTypes} when {@code image} was created</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_BIND_IMAGE_MEMORY_INFO STRUCTURE_TYPE_BIND_IMAGE_MEMORY_INFO}</li>
 * <li>Each {@code pNext} member of any structure (including this one) in the {@code pNext} chain <b>must</b> be either {@code NULL} or a pointer to a valid instance of {@link VkBindImageMemoryDeviceGroupInfo}, {@link VkBindImageMemorySwapchainInfoKHR}, or {@link VkBindImagePlaneMemoryInfo}</li>
 * <li>Each {@code sType} member in the {@code pNext} chain <b>must</b> be unique</li>
 * <li>{@code image} <b>must</b> be a valid {@code VkImage} handle</li>
 * <li>Both of {@code image}, and {@code memory} that are valid handles <b>must</b> have been created, allocated, or retrieved from the same {@code VkDevice}</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VK11#vkBindImageMemory2 BindImageMemory2}, {@link KHRBindMemory2#vkBindImageMemory2KHR BindImageMemory2KHR}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code image} &ndash; the image to be attached to memory.</li>
 * <li>{@code memory} &ndash; a {@code VkDeviceMemory} object describing the device memory to attach.</li>
 * <li>{@code memoryOffset} &ndash; the start offset of the region of {@code memory} which is to be bound to the image. The number of bytes returned in the {@link VkMemoryRequirements}{@code ::size} member in {@code memory}, starting from {@code memoryOffset} bytes, will be bound to the specified image.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkBindImageMemoryInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkImage image;
 *     VkDeviceMemory memory;
 *     VkDeviceSize memoryOffset;
 * }</code></pre>
 */
class BindImageMemoryInfo(
    var image: VkImage,
    var memory: VkDeviceMemory,
    var memoryOffset: VkDeviceSize,
    var next: Ptr = NULL
) {

    val type get() = VkStructureType.BIND_IMAGE_MEMORY_INFO

    infix fun write(stack: MemoryStack): Adr =
            stack.ncalloc(ALIGNOF, 1, SIZEOF).also { write(it) }

    infix fun write(adr: Adr) {
        nsType(adr, type.i)
        npNext(adr, next)
        nimage(adr, image.L)
        nmemory(adr, memory.L)
        nmemoryOffset(adr, memoryOffset.L)
        nmemoryOffset(adr, memoryOffset.L)
    }
}

infix fun Array<BindImageMemoryInfo>.write(stack: MemoryStack): Ptr {
    val natives = stack.ncalloc(ALIGNOF, size, SIZEOF)
    for (i in indices)
        this[i] write (natives + i * SIZEOF)
    return natives
}