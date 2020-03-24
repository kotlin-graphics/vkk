package vkk._10.structs

import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.system.MemoryUtil.memPutAddress
import org.lwjgl.vulkan.VkDescriptorSetLayoutCreateInfo.*
import vkk.VkDescriptorSetLayoutCreateFlags
import vkk.VkStack
import vkk.VkStructureType

/**
 * Structure specifying parameters of a newly created descriptor set layout.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>The {@link VkDescriptorSetLayoutBinding}{@code ::binding} members of the elements of the {@code pBindings} array <b>must</b> each have different values.</li>
 * <li>If {@code flags} contains {@link KHRPushDescriptor#VK_DESCRIPTOR_SET_LAYOUT_CREATE_PUSH_DESCRIPTOR_BIT_KHR DESCRIPTOR_SET_LAYOUT_CREATE_PUSH_DESCRIPTOR_BIT_KHR}, then all elements of {@code pBindings} <b>must</b> not have a {@code descriptorType} of {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER_DYNAMIC DESCRIPTOR_TYPE_UNIFORM_BUFFER_DYNAMIC} or {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_BUFFER_DYNAMIC DESCRIPTOR_TYPE_STORAGE_BUFFER_DYNAMIC}</li>
 * <li>If {@code flags} contains {@link KHRPushDescriptor#VK_DESCRIPTOR_SET_LAYOUT_CREATE_PUSH_DESCRIPTOR_BIT_KHR DESCRIPTOR_SET_LAYOUT_CREATE_PUSH_DESCRIPTOR_BIT_KHR}, then all elements of {@code pBindings} <b>must</b> not have a {@code descriptorType} of {@link EXTInlineUniformBlock#VK_DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK_EXT}</li>
 * <li>If {@code flags} contains {@link KHRPushDescriptor#VK_DESCRIPTOR_SET_LAYOUT_CREATE_PUSH_DESCRIPTOR_BIT_KHR DESCRIPTOR_SET_LAYOUT_CREATE_PUSH_DESCRIPTOR_BIT_KHR}, then the total number of elements of all bindings <b>must</b> be less than or equal to {@link VkPhysicalDevicePushDescriptorPropertiesKHR}{@code ::maxPushDescriptors}</li>
 * <li>If any binding has the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_BINDING_UPDATE_AFTER_BIND_BIT_EXT DESCRIPTOR_BINDING_UPDATE_AFTER_BIND_BIT_EXT} bit set, {@code flags} <b>must</b> include {@link EXTDescriptorIndexing#VK_DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT_EXT}</li>
 * <li>If any binding has the {@link EXTDescriptorIndexing#VK_DESCRIPTOR_BINDING_UPDATE_AFTER_BIND_BIT_EXT DESCRIPTOR_BINDING_UPDATE_AFTER_BIND_BIT_EXT} bit set, then all bindings <b>must</b> not have {@code descriptorType} of {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER_DYNAMIC DESCRIPTOR_TYPE_UNIFORM_BUFFER_DYNAMIC} or {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_BUFFER_DYNAMIC DESCRIPTOR_TYPE_STORAGE_BUFFER_DYNAMIC}</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK10#VK_STRUCTURE_TYPE_DESCRIPTOR_SET_LAYOUT_CREATE_INFO STRUCTURE_TYPE_DESCRIPTOR_SET_LAYOUT_CREATE_INFO}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL} or a pointer to a valid instance of {@link VkDescriptorSetLayoutBindingFlagsCreateInfoEXT}</li>
 * <li>{@code flags} <b>must</b> be a valid combination of {@code VkDescriptorSetLayoutCreateFlagBits} values</li>
 * <li>If {@code bindingCount} is not 0, {@code pBindings} <b>must</b> be a valid pointer to an array of {@code bindingCount} valid {@link VkDescriptorSetLayoutBinding} structures</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkDescriptorSetLayoutBinding}, {@link VK10#vkCreateDescriptorSetLayout CreateDescriptorSetLayout}, {@link VK11#vkGetDescriptorSetLayoutSupport GetDescriptorSetLayoutSupport}, {@link KHRMaintenance3#vkGetDescriptorSetLayoutSupportKHR GetDescriptorSetLayoutSupportKHR}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code flags} &ndash; a bitmask of {@code VkDescriptorSetLayoutCreateFlagBits} specifying options for descriptor set layout creation.</li>
 * <li>{@code bindingCount} &ndash; the number of elements in {@code pBindings}.</li>
 * <li>{@code pBindings} &ndash; a pointer to an array of {@link VkDescriptorSetLayoutBinding} structures.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkDescriptorSetLayoutCreateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkDescriptorSetLayoutCreateFlags flags;
 *     uint32_t bindingCount;
 *     {@link VkDescriptorSetLayoutBinding VkDescriptorSetLayoutBinding} const * pBindings;
 * }</code></pre>
 */
class DescriptorSetLayoutCreateInfo(
        var flags: VkDescriptorSetLayoutCreateFlags = 0,
        var bindings: Array<DescriptorSetLayoutBinding>? = null,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.DESCRIPTOR_SET_LAYOUT_CREATE_INFO

    infix fun write(stack: VkStack): Adr {
        val adr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
        nsType(adr, type.i)
        npNext(adr, next)
        nflags(adr, flags)
        bindings?.let {
            nbindingCount(adr, it.size)
            memPutAddress(adr + PBINDINGS, it write stack)
        }
        return adr
    }
}