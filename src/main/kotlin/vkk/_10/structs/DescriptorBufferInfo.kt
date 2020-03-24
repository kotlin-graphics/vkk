package vkk._10.structs

import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkDescriptorBufferInfo.*
import vkk.VkStack
import vkk.entities.VkBuffer
import vkk.entities.VkDeviceSize

/**
 * Structure specifying descriptor buffer info.
 *
 * <h5>Description</h5>
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>When setting {@code range} to {@link VK10#VK_WHOLE_SIZE WHOLE_SIZE}, the effective range <b>must</b> not be larger than the maximum range for the descriptor type (<a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#limits-maxUniformBufferRange">{@code maxUniformBufferRange}</a> or <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#limits-maxStorageBufferRange">{@code maxStorageBufferRange}</a>). This means that {@link VK10#VK_WHOLE_SIZE WHOLE_SIZE} is not typically useful in the common case where uniform buffer descriptors are suballocated from a buffer that is much larger than {@code maxUniformBufferRange}.</p>
 * </div>
 *
 * <p>For {@link VK10#VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER_DYNAMIC DESCRIPTOR_TYPE_UNIFORM_BUFFER_DYNAMIC} and {@link VK10#VK_DESCRIPTOR_TYPE_STORAGE_BUFFER_DYNAMIC DESCRIPTOR_TYPE_STORAGE_BUFFER_DYNAMIC} descriptor types, {@code offset} is the base offset from which the dynamic offset is applied and {@code range} is the static size used for all dynamic offsets.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code offset} <b>must</b> be less than the size of {@code buffer}</li>
 * <li>If {@code range} is not equal to {@link VK10#VK_WHOLE_SIZE WHOLE_SIZE}, {@code range} <b>must</b> be greater than 0</li>
 * <li>If {@code range} is not equal to {@link VK10#VK_WHOLE_SIZE WHOLE_SIZE}, {@code range} <b>must</b> be less than or equal to the size of {@code buffer} minus {@code offset}</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code buffer} <b>must</b> be a valid {@code VkBuffer} handle</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkWriteDescriptorSet}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code buffer} &ndash; the buffer resource.</li>
 * <li>{@code offset} &ndash; the offset in bytes from the start of {@code buffer}. Access to buffer memory via this descriptor uses addressing that is relative to this starting offset.</li>
 * <li>{@code range} &ndash; the size in bytes that is used for this descriptor update, or {@link VK10#VK_WHOLE_SIZE WHOLE_SIZE} to use the range from {@code offset} to the end of the buffer.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkDescriptorBufferInfo {
 *     VkBuffer buffer;
 *     VkDeviceSize offset;
 *     VkDeviceSize range;
 * }</code></pre>
 */
class DescriptorBufferInfo(
        var buffer: VkBuffer,
        var offset: VkDeviceSize,
        var range: VkDeviceSize = VkDeviceSize.WHOLE_SIZE
) {

    infix fun write(stack: VkStack): Adr =
            stack.ncalloc(ALIGNOF, 1, SIZEOF).also { write(it) }

    infix fun write(adr: Adr) {
        nbuffer(adr, buffer.L)
        noffset(adr, offset.L)
        nrange(adr, range.L)
    }
}

infix fun Array<DescriptorBufferInfo>.write(stack: VkStack): Ptr {
    val natives = stack.ncalloc(ALIGNOF, size, SIZEOF)
    for (i in indices)
        this[i] write (natives + i * SIZEOF)
    return natives
}