package vkk.vk10.structs

import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.system.MemoryUtil.memPutAddress
import org.lwjgl.vulkan.VkDescriptorPoolCreateInfo.*
import vkk.VkDescriptorPoolCreateFlags
import vkk.VkStack
import vkk.VkStructureType

/**
 * Structure specifying parameters of a newly created descriptor pool.
 *
 * <h5>Description</h5>
 *
 * <p>If multiple {@link VkDescriptorPoolSize} structures appear in the {@code pPoolSizes} array then the pool will be created with enough storage for the total number of descriptors of each type.</p>
 *
 * <p>Fragmentation of a descriptor pool is possible and <b>may</b> lead to descriptor set allocation failures. A failure due to fragmentation is defined as failing a descriptor set allocation despite the sum of all outstanding descriptor set allocations from the pool plus the requested allocation requiring no more than the total number of descriptors requested at pool creation. Implementations provide certain guarantees of when fragmentation <b>must</b> not cause allocation failure, as described below.</p>
 *
 * <p>If a descriptor pool has not had any descriptor sets freed since it was created or most recently reset then fragmentation <b>must</b> not cause an allocation failure (note that this is always the case for a pool created without the {@link VK10#VK_DESCRIPTOR_POOL_CREATE_FREE_DESCRIPTOR_SET_BIT DESCRIPTOR_POOL_CREATE_FREE_DESCRIPTOR_SET_BIT} bit set). Additionally, if all sets allocated from the pool since it was created or most recently reset use the same number of descriptors (of each type) and the requested allocation also uses that same number of descriptors (of each type), then fragmentation <b>must</b> not cause an allocation failure.</p>
 *
 * <p>If an allocation failure occurs due to fragmentation, an application <b>can</b> create an additional descriptor pool to perform further descriptor set allocations.</p>
 *
 * <p>If {@code flags} has the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_POOL_CREATE_UPDATE_AFTER_BIND_BIT_EXT DESCRIPTOR_POOL_CREATE_UPDATE_AFTER_BIND_BIT_EXT} bit set, descriptor pool creation <b>may</b> fail with the error {@link EXTDescriptorIndexing#VK_ERROR_FRAGMENTATION_EXT ERROR_FRAGMENTATION_EXT} if the total number of descriptors across all pools (including this one) created with this bit set exceeds {@code maxUpdateAfterBindDescriptorsInAllPools}, or if fragmentation of the underlying hardware resources occurs.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code maxSets} <b>must</b> be greater than 0</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK10#VK_STRUCTURE_TYPE_DESCRIPTOR_POOL_CREATE_INFO STRUCTURE_TYPE_DESCRIPTOR_POOL_CREATE_INFO}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL} or a pointer to a valid instance of {@link VkDescriptorPoolInlineUniformBlockCreateInfoEXT}</li>
 * <li>{@code flags} <b>must</b> be a valid combination of {@code VkDescriptorPoolCreateFlagBits} values</li>
 * <li>{@code pPoolSizes} <b>must</b> be a valid pointer to an array of {@code poolSizeCount} valid {@link VkDescriptorPoolSize} structures</li>
 * <li>{@code poolSizeCount} <b>must</b> be greater than 0</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkDescriptorPoolSize}, {@link VK10#vkCreateDescriptorPool CreateDescriptorPool}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code flags} &ndash; a bitmask of {@code VkDescriptorPoolCreateFlagBits} specifying certain supported operations on the pool.</li>
 * <li>{@code maxSets} &ndash; the maximum number of descriptor sets that <b>can</b> be allocated from the pool.</li>
 * <li>{@code poolSizeCount} &ndash; the number of elements in {@code pPoolSizes}.</li>
 * <li>{@code pPoolSizes} &ndash; a pointer to an array of {@link VkDescriptorPoolSize} structures, each containing a descriptor type and number of descriptors of that type to be allocated in the pool.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkDescriptorPoolCreateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkDescriptorPoolCreateFlags flags;
 *     uint32_t maxSets;
 *     uint32_t poolSizeCount;
 *     {@link VkDescriptorPoolSize VkDescriptorPoolSize} const * pPoolSizes;
 * }</code></pre>
 */
class DescriptorPoolCreateInfo(
        var flags: VkDescriptorPoolCreateFlags,
        var maxSets: Int,
        var poolSizes: Array<DescriptorPoolSize>,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.DESCRIPTOR_POOL_CREATE_INFO

    infix fun write(stack: VkStack): Adr {
        val adr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
        nsType(adr, type.i)
        npNext(adr, next)
        nflags(adr, flags)
        nmaxSets(adr, maxSets)
        npoolSizeCount(adr, poolSizes.size)
        memPutAddress(adr + PPOOLSIZES, poolSizes write stack)
        return adr
    }
}