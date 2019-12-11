package vkk._10.structs

import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.system.MemoryUtil.memPutAddress
import org.lwjgl.vulkan.VkDescriptorSetAllocateInfo.*
import vkk.VkStructureType
import vkk.entities.VkDescriptorPool
import vkk.entities.VkDescriptorSetLayout_Array

/**
 * Structure specifying the allocation parameters for descriptor sets.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>Each element of {@code pSetLayouts} <b>must</b> not have been created with {@link KHRPushDescriptor#VK_DESCRIPTOR_SET_LAYOUT_CREATE_PUSH_DESCRIPTOR_BIT_KHR DESCRIPTOR_SET_LAYOUT_CREATE_PUSH_DESCRIPTOR_BIT_KHR} set</li>
 * <li>If any element of {@code pSetLayouts} was created with the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT} bit set, {@code descriptorPool} <b>must</b> have been created with the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_POOL_CREATE_UPDATE_AFTER_BIND_BIT_EXT DESCRIPTOR_POOL_CREATE_UPDATE_AFTER_BIND_BIT_EXT} flag set</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK10#VK_STRUCTURE_TYPE_DESCRIPTOR_SET_ALLOCATE_INFO STRUCTURE_TYPE_DESCRIPTOR_SET_ALLOCATE_INFO}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL} or a pointer to a valid instance of {@link VkDescriptorSetVariableDescriptorCountAllocateInfoEXT}</li>
 * <li>{@code descriptorPool} <b>must</b> be a valid {@code VkDescriptorPool} handle</li>
 * <li>{@code pSetLayouts} <b>must</b> be a valid pointer to an array of {@code descriptorSetCount} valid {@code VkDescriptorSetLayout} handles</li>
 * <li>{@code descriptorSetCount} <b>must</b> be greater than 0</li>
 * <li>Both of {@code descriptorPool}, and the elements of {@code pSetLayouts} <b>must</b> have been created, allocated, or retrieved from the same {@code VkDevice}</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VK10#vkAllocateDescriptorSets AllocateDescriptorSets}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code descriptorPool} &ndash; the pool which the sets will be allocated from.</li>
 * <li>{@code descriptorSetCount} &ndash; determines the number of descriptor sets to be allocated from the pool.</li>
 * <li>{@code pSetLayouts} &ndash; an array of descriptor set layouts, with each member specifying how the corresponding descriptor set is allocated.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkDescriptorSetAllocateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkDescriptorPool descriptorPool;
 *     uint32_t descriptorSetCount;
 *     VkDescriptorSetLayout const * pSetLayouts;
 * }</code></pre>
 */
class DescriptorSetAllocateInfo(
        var descriptorPool: VkDescriptorPool,
        var setLayouts: VkDescriptorSetLayout_Array,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.DESCRIPTOR_SET_ALLOCATE_INFO

    infix fun write(stack: MemoryStack): Adr {
        val adr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
        nsType(adr, type.i)
        npNext(adr, next)
        ndescriptorPool(adr, descriptorPool.L)
        ndescriptorSetCount(adr, setLayouts.size)
        memPutAddress(adr + PSETLAYOUTS, setLayouts write stack)
        return adr
    }
}