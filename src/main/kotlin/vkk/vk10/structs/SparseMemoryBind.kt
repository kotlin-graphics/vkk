package vkk.vk10.structs

import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkSparseMemoryBind.*
import vkk.VkSparseMemoryBindFlags
import vkk.entities.VkDeviceMemory
import vkk.entities.VkDeviceSize

/**
 * Structure specifying a sparse memory bind operation.
 *
 * <h5>Description</h5>
 *
 * <p>The <em>binding range</em> <code>[resourceOffset, resourceOffset + size)</code> has different constraints based on {@code flags}. If {@code flags} contains {@link VK10#VK_SPARSE_MEMORY_BIND_METADATA_BIT SPARSE_MEMORY_BIND_METADATA_BIT}, the binding range <b>must</b> be within the mip tail region of the metadata aspect. This metadata region is defined by:</p>
 *
 * <dl>
 * <dd><code>metadataRegion = [base, base + imageMipTailSize)</code></dd>
 * <dd><code>base = imageMipTailOffset + imageMipTailStride × n</code></dd>
 * </dl>
 *
 * <p>and {@code imageMipTailOffset}, {@code imageMipTailSize}, and {@code imageMipTailStride} values are from the {@link VkSparseImageMemoryRequirements} corresponding to the metadata aspect of the image, and <code>n</code> is a valid array layer index for the image,</p>
 *
 * <p>{@code imageMipTailStride} is considered to be zero for aspects where {@link VkSparseImageMemoryRequirements}{@code ::formatProperties}.flags contains {@link VK10#VK_SPARSE_IMAGE_FORMAT_SINGLE_MIPTAIL_BIT SPARSE_IMAGE_FORMAT_SINGLE_MIPTAIL_BIT}.</p>
 *
 * <p>If {@code flags} does not contain {@link VK10#VK_SPARSE_MEMORY_BIND_METADATA_BIT SPARSE_MEMORY_BIND_METADATA_BIT}, the binding range <b>must</b> be within the range <code>[0,{@link VkMemoryRequirements}::size)</code>.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>If {@code memory} is not {@link VK10#VK_NULL_HANDLE NULL_HANDLE}, {@code memory} and {@code memoryOffset} <b>must</b> match the memory requirements of the resource, as described in section <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#resources-association">Resource Memory Association</a></li>
 * <li>If {@code memory} is not {@link VK10#VK_NULL_HANDLE NULL_HANDLE}, {@code memory} <b>must</b> not have been created with a memory type that reports {@link VK10#VK_MEMORY_PROPERTY_LAZILY_ALLOCATED_BIT MEMORY_PROPERTY_LAZILY_ALLOCATED_BIT} bit set</li>
 * <li>{@code size} <b>must</b> be greater than 0</li>
 * <li>{@code resourceOffset} <b>must</b> be less than the size of the resource</li>
 * <li>{@code size} <b>must</b> be less than or equal to the size of the resource minus {@code resourceOffset}</li>
 * <li>{@code memoryOffset} <b>must</b> be less than the size of {@code memory}</li>
 * <li>{@code size} <b>must</b> be less than or equal to the size of {@code memory} minus {@code memoryOffset}</li>
 * <li>If {@code memory} was created with {@link VkExportMemoryAllocateInfo}{@code ::handleTypes} not equal to 0, at least one handle type it contained must also have been set in {@link VkExternalMemoryBufferCreateInfo}{@code ::handleTypes} or {@link VkExternalMemoryImageCreateInfo}{@code ::handleTypes} when the resource was created.</li>
 * <li>If {@code memory} was created by a memory import operation, the external handle type of the imported memory must also have been set in {@link VkExternalMemoryBufferCreateInfo}{@code ::handleTypes} or {@link VkExternalMemoryImageCreateInfo}{@code ::handleTypes} when the resource was created.</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>If {@code memory} is not {@link VK10#VK_NULL_HANDLE NULL_HANDLE}, {@code memory} <b>must</b> be a valid {@code VkDeviceMemory} handle</li>
 * <li>{@code flags} <b>must</b> be a valid combination of {@code VkSparseMemoryBindFlagBits} values</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkSparseBufferMemoryBindInfo}, {@link VkSparseImageOpaqueMemoryBindInfo}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code resourceOffset} &ndash; the offset into the resource.</li>
 * <li>{@code size} &ndash; the size of the memory region to be bound.</li>
 * <li>{@code memory} &ndash; the {@code VkDeviceMemory} object that the range of the resource is bound to. If {@code memory} is {@link VK10#VK_NULL_HANDLE NULL_HANDLE}, the range is unbound.</li>
 * <li>{@code memoryOffset} &ndash; the offset into the {@code VkDeviceMemory} object to bind the resource range to. If {@code memory} is {@link VK10#VK_NULL_HANDLE NULL_HANDLE}, this value is ignored.</li>
 * <li>{@code flags} &ndash; a bitmask of {@code VkSparseMemoryBindFlagBits} specifying usage of the binding operation.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkSparseMemoryBind {
 *     VkDeviceSize resourceOffset;
 *     VkDeviceSize size;
 *     VkDeviceMemory memory;
 *     VkDeviceSize memoryOffset;
 *     VkSparseMemoryBindFlags flags;
 * }</code></pre>
 */
class SparseMemoryBind(
        var resourceOffset: VkDeviceSize,
        var size: VkDeviceSize,
        var memory: VkDeviceMemory = VkDeviceMemory.NULL,
        var memoryOffset: VkDeviceSize,
        var flags: VkSparseMemoryBindFlags
) {

    infix fun write(stack: MemoryStack): Adr =
            stack.ncalloc(ALIGNOF, 1, SIZEOF).also { write(it) }

    infix fun write(adr: Adr) {
        nresourceOffset(adr, resourceOffset.L)
        nsize(adr, size.L)
        nmemory(adr, memory.L)
        nmemoryOffset(adr, memoryOffset.L)
        nflags(adr, flags)
    }
}

infix fun Array<SparseMemoryBind>.write(stack: MemoryStack): Ptr {
    val natives = stack.ncalloc(ALIGNOF, size, SIZEOF)
    for (i in indices)
        this[i] write (natives + i * SIZEOF)
    return natives
}