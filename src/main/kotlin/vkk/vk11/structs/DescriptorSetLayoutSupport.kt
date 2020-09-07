package vkk.vk11.structs

import glm_.bool
import kool.BytePtr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.vulkan.VkDescriptorSetLayoutSupport.*
import vkk.VkStructureType
import vkk.invoke

/**
 * Structure returning information about whether a descriptor set layout can be supported.
 *
 * <h5>Description</h5>
 *
 * <p>{@code supported} is set to {@link VK10#VK_TRUE TRUE} if the descriptor set <b>can</b> be created, or else is set to {@link VK10#VK_FALSE FALSE}.</p>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_DESCRIPTOR_SET_LAYOUT_SUPPORT STRUCTURE_TYPE_DESCRIPTOR_SET_LAYOUT_SUPPORT}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL} or a pointer to a valid instance of {@link VkDescriptorSetVariableDescriptorCountLayoutSupportEXT}</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VK11#vkGetDescriptorSetLayoutSupport GetDescriptorSetLayoutSupport}, {@link KHRMaintenance3#vkGetDescriptorSetLayoutSupportKHR GetDescriptorSetLayoutSupportKHR}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code supported} &ndash; specifies whether the descriptor set layout <b>can</b> be created.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkDescriptorSetLayoutSupport {
 *     VkStructureType sType;
 *     void * pNext;
 *     VkBool32 supported;
 * }</code></pre>
 */
class DescriptorSetLayoutSupport(
        var supported: Boolean,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.DESCRIPTOR_SET_LAYOUT_SUPPORT

    constructor(ptr: BytePtr) : this(
            nsupported(ptr.adr).bool,
            npNext(ptr.adr)
    )

    companion object {
//        inline fun <R> read(block: (Ptr) -> R): DescriptorSetLayoutSupport = stak { read(it, block) }
        inline fun <R> read(stack: MemoryStack, block: (Ptr) -> R): DescriptorSetLayoutSupport = stack {
            val ptr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
            block(ptr)
            DescriptorSetLayoutSupport(BytePtr(ptr))
        }
    }
}