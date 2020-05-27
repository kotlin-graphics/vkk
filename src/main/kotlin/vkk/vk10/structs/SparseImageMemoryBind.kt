package vkk.vk10.structs

import kool.Adr
import kool.Ptr
import org.lwjgl.vulkan.VkSparseImageMemoryBind.*
import vkk.VkSparseMemoryBindFlags
import vkk.VkStack
import vkk.entities.VkDeviceMemory
import vkk.entities.VkDeviceSize

/**
 * Structure specifying sparse image memory bind.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-sparseResidencyAliased">sparse aliased residency</a> feature is not enabled, and if any other resources are bound to ranges of {@code memory}, the range of {@code memory} being bound <b>must</b> not overlap with those bound ranges</li>
 * <li>{@code memory} and {@code memoryOffset} <b>must</b> match the memory requirements of the calling command&#8217;s {@code image}, as described in section <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#resources-association">Resource Memory Association</a></li>
 * <li>{@code subresource} <b>must</b> be a valid image subresource for {@code image} (see <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#resources-image-views">Image Views</a>)</li>
 * <li>{@code offset.x} <b>must</b> be a multiple of the sparse image block width ({@link VkSparseImageFormatProperties}{@code ::imageGranularity}.width) of the image</li>
 * <li>{@code extent.width} <b>must</b> either be a multiple of the sparse image block width of the image, or else <code>(extent.width offset.x)</code> <b>must</b> equal the width of the image subresource</li>
 * <li>{@code offset.y} <b>must</b> be a multiple of the sparse image block height ({@link VkSparseImageFormatProperties}{@code ::imageGranularity}.height) of the image</li>
 * <li>{@code extent.height} <b>must</b> either be a multiple of the sparse image block height of the image, or else <code>(extent.height offset.y)</code> <b>must</b> equal the height of the image subresource</li>
 * <li>{@code offset.z} <b>must</b> be a multiple of the sparse image block depth ({@link VkSparseImageFormatProperties}{@code ::imageGranularity}.depth) of the image</li>
 * <li>{@code extent.depth} <b>must</b> either be a multiple of the sparse image block depth of the image, or else <code>(extent.depth offset.z)</code> <b>must</b> equal the depth of the image subresource</li>
 * <li>If {@code memory} was created with {@link VkExportMemoryAllocateInfo}{@code ::handleTypes} not equal to 0, at least one handle type it contained must also have been set in {@link VkExternalMemoryImageCreateInfo}{@code ::handleTypes} when the image was created.</li>
 * <li>If {@code memory} was created by a memory import operation, the external handle type of the imported memory must also have been set in {@link VkExternalMemoryImageCreateInfo}{@code ::handleTypes} when {@code image} was created.</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code subresource} <b>must</b> be a valid {@link VkImageSubresource} structure</li>
 * <li>If {@code memory} is not {@link VK10#VK_NULL_HANDLE NULL_HANDLE}, {@code memory} <b>must</b> be a valid {@code VkDeviceMemory} handle</li>
 * <li>{@code flags} <b>must</b> be a valid combination of {@code VkSparseMemoryBindFlagBits} values</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkExtent3D}, {@link VkImageSubresource}, {@link VkOffset3D}, {@link VkSparseImageMemoryBindInfo}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code subresource} &ndash; the image <em>aspect</em> and region of interest in the image.</li>
 * <li>{@code offset} &ndash; are the coordinates of the first texel within the image subresource to bind.</li>
 * <li>{@code extent} &ndash; the size in texels of the region within the image subresource to bind. The extent <b>must</b> be a multiple of the sparse image block dimensions, except when binding sparse image blocks along the edge of an image subresource it <b>can</b> instead be such that any coordinate of <code>offset + extent</code> equals the corresponding dimensions of the image subresource.</li>
 * <li>{@code memory} &ndash; the {@code VkDeviceMemory} object that the sparse image blocks of the image are bound to. If {@code memory} is {@link VK10#VK_NULL_HANDLE NULL_HANDLE}, the sparse image blocks are unbound.</li>
 * <li>{@code memoryOffset} &ndash; an offset into {@code VkDeviceMemory} object. If {@code memory} is {@link VK10#VK_NULL_HANDLE NULL_HANDLE}, this value is ignored.</li>
 * <li>{@code flags} &ndash; are sparse memory binding flags.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkSparseImageMemoryBind {
 *     {@link VkImageSubresource VkImageSubresource} subresource;
 *     {@link VkOffset3D VkOffset3D} offset;
 *     {@link VkExtent3D VkExtent3D} extent;
 *     VkDeviceMemory memory;
 *     VkDeviceSize memoryOffset;
 *     VkSparseMemoryBindFlags flags;
 * }</code></pre>
 */
class SparseImageMemoryBind(
        var subresource: ImageSubresource,
        var offset: Offset3D = Offset3D(),
        var extent: Extent3D,
        var memory: VkDeviceMemory,
        var memoryOffset: VkDeviceSize = VkDeviceSize.NULL,
        var flags: VkSparseMemoryBindFlags
) {

    infix fun write(stack: VkStack): Adr =
            stack.ncalloc(ALIGNOF, 1, SIZEOF).also { write(it) }

    infix fun write(adr: Adr) {
        subresource write (adr + SUBRESOURCE)
        offset write (adr + OFFSET)
        extent write (adr + EXTENT)
        nmemory(adr, memory.L)
        nmemoryOffset(adr, memoryOffset.L)
        nflags(adr, flags)
    }
}

infix fun Array<SparseImageMemoryBind>.write(stack: VkStack): Ptr {
    val natives = stack.ncalloc(ALIGNOF, size, SIZEOF)
    for (i in indices)
        this[i] write (natives + i * SIZEOF)
    return natives
}