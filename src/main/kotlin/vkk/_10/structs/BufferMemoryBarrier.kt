package vkk._10.structs

import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkBufferMemoryBarrier.*
import vkk.VkAccessFlags
import vkk.VkStack
import vkk.VkStructureType
import vkk.entities.VkBuffer
import vkk.entities.VkDeviceSize

/**
 * Structure specifying a buffer memory barrier.
 *
 * <h5>Description</h5>
 *
 * <p>The first <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-dependencies-access-scopes">access scope</a> is limited to access to memory through the specified buffer range, via access types in the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-access-masks">source access mask</a> specified by {@code srcAccessMask}. If {@code srcAccessMask} includes {@link VK10#VK_ACCESS_HOST_WRITE_BIT ACCESS_HOST_WRITE_BIT}, memory writes performed by that access type are also made visible, as that access type is not performed through a resource.</p>
 *
 * <p>The second <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-dependencies-access-scopes">access scope</a> is limited to access to memory through the specified buffer range, via access types in the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-access-masks">destination access mask</a>. specified by {@code dstAccessMask}. If {@code dstAccessMask} includes {@link VK10#VK_ACCESS_HOST_WRITE_BIT ACCESS_HOST_WRITE_BIT} or {@link VK10#VK_ACCESS_HOST_READ_BIT ACCESS_HOST_READ_BIT}, available memory writes are also made visible to accesses of those types, as those access types are not performed through a resource.</p>
 *
 * <p>If {@code srcQueueFamilyIndex} is not equal to {@code dstQueueFamilyIndex}, and {@code srcQueueFamilyIndex} is equal to the current queue family, then the memory barrier defines a <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-queue-transfers-release">queue family release operation</a> for the specified buffer range, and the second access scope includes no access, as if {@code dstAccessMask} was 0.</p>
 *
 * <p>If {@code dstQueueFamilyIndex} is not equal to {@code srcQueueFamilyIndex}, and {@code dstQueueFamilyIndex} is equal to the current queue family, then the memory barrier defines a <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-queue-transfers-acquire">queue family acquire operation</a> for the specified buffer range, and the first access scope includes no access, as if {@code srcAccessMask} was 0.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code offset} <b>must</b> be less than the size of {@code buffer}</li>
 * <li>If {@code size} is not equal to {@link VK10#VK_WHOLE_SIZE WHOLE_SIZE}, {@code size} <b>must</b> be greater than 0</li>
 * <li>If {@code size} is not equal to {@link VK10#VK_WHOLE_SIZE WHOLE_SIZE}, {@code size} <b>must</b> be less than or equal to than the size of {@code buffer} minus {@code offset}</li>
 * <li>If {@code buffer} was created with a sharing mode of {@link VK10#VK_SHARING_MODE_CONCURRENT SHARING_MODE_CONCURRENT}, at least one of {@code srcQueueFamilyIndex} and {@code dstQueueFamilyIndex} <b>must</b> be {@link VK10#VK_QUEUE_FAMILY_IGNORED QUEUE_FAMILY_IGNORED}</li>
 * <li>If {@code buffer} was created with a sharing mode of {@link VK10#VK_SHARING_MODE_CONCURRENT SHARING_MODE_CONCURRENT}, and one of {@code srcQueueFamilyIndex} and {@code dstQueueFamilyIndex} is {@link VK10#VK_QUEUE_FAMILY_IGNORED QUEUE_FAMILY_IGNORED}, the other <b>must</b> be {@link VK10#VK_QUEUE_FAMILY_IGNORED QUEUE_FAMILY_IGNORED} or a special queue family reserved for external memory ownership transfers, as described in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-queue-transfers">Queue Family Ownership Transfer</a>.</li>
 * <li>If {@code buffer} was created with a sharing mode of {@link VK10#VK_SHARING_MODE_EXCLUSIVE SHARING_MODE_EXCLUSIVE} and {@code srcQueueFamilyIndex} is {@link VK10#VK_QUEUE_FAMILY_IGNORED QUEUE_FAMILY_IGNORED}, {@code dstQueueFamilyIndex} <b>must</b> also be {@link VK10#VK_QUEUE_FAMILY_IGNORED QUEUE_FAMILY_IGNORED}</li>
 * <li>If {@code buffer} was created with a sharing mode of {@link VK10#VK_SHARING_MODE_EXCLUSIVE SHARING_MODE_EXCLUSIVE} and {@code srcQueueFamilyIndex} is not {@link VK10#VK_QUEUE_FAMILY_IGNORED QUEUE_FAMILY_IGNORED}, it <b>must</b> be a valid queue family or a special queue family reserved for external memory transfers, as described in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-queue-transfers">Queue Family Ownership Transfer</a>.</li>
 * <li>If {@code buffer} was created with a sharing mode of {@link VK10#VK_SHARING_MODE_EXCLUSIVE SHARING_MODE_EXCLUSIVE} and {@code dstQueueFamilyIndex} is not {@link VK10#VK_QUEUE_FAMILY_IGNORED QUEUE_FAMILY_IGNORED}, it <b>must</b> be a valid queue family or a special queue family reserved for external memory transfers, as described in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-queue-transfers">Queue Family Ownership Transfer</a>.</li>
 * <li>If {@code buffer} was created with a sharing mode of {@link VK10#VK_SHARING_MODE_EXCLUSIVE SHARING_MODE_EXCLUSIVE}, and {@code srcQueueFamilyIndex} and {@code dstQueueFamilyIndex} are not {@link VK10#VK_QUEUE_FAMILY_IGNORED QUEUE_FAMILY_IGNORED}, at least one of them <b>must</b> be the same as the family of the queue that will execute this barrier</li>
 * <li>If {@code buffer} is non-sparse then it <b>must</b> be bound completely and contiguously to a single {@code VkDeviceMemory} object</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK10#VK_STRUCTURE_TYPE_BUFFER_MEMORY_BARRIER STRUCTURE_TYPE_BUFFER_MEMORY_BARRIER}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL}</li>
 * <li>{@code srcAccessMask} <b>must</b> be a valid combination of {@code VkAccessFlagBits} values</li>
 * <li>{@code dstAccessMask} <b>must</b> be a valid combination of {@code VkAccessFlagBits} values</li>
 * <li>{@code buffer} <b>must</b> be a valid {@code VkBuffer} handle</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VK10#vkCmdPipelineBarrier CmdPipelineBarrier}, {@link VK10#vkCmdWaitEvents CmdWaitEvents}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code srcAccessMask} &ndash; a bitmask of {@code VkAccessFlagBits} specifying a <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-access-masks">source access mask</a>.</li>
 * <li>{@code dstAccessMask} &ndash; a bitmask of {@code VkAccessFlagBits} specifying a <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-access-masks">destination access mask</a>.</li>
 * <li>{@code srcQueueFamilyIndex} &ndash; the source queue family for a <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-queue-transfers">queue family ownership transfer</a>.</li>
 * <li>{@code dstQueueFamilyIndex} &ndash; the destination queue family for a <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-queue-transfers">queue family ownership transfer</a>.</li>
 * <li>{@code buffer} &ndash; a handle to the buffer whose backing memory is affected by the barrier.</li>
 * <li>{@code offset} &ndash; an offset in bytes into the backing memory for {@code buffer}; this is relative to the base offset as bound to the buffer (see {@link VK10#vkBindBufferMemory BindBufferMemory}).</li>
 * <li>{@code size} &ndash; a size in bytes of the affected area of backing memory for {@code buffer}, or {@link VK10#VK_WHOLE_SIZE WHOLE_SIZE} to use the range from {@code offset} to the end of the buffer.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkBufferMemoryBarrier {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkAccessFlags srcAccessMask;
 *     VkAccessFlags dstAccessMask;
 *     uint32_t srcQueueFamilyIndex;
 *     uint32_t dstQueueFamilyIndex;
 *     VkBuffer buffer;
 *     VkDeviceSize offset;
 *     VkDeviceSize size;
 * }</code></pre>
 */
class BufferMemoryBarrier(
        var srcAccessMask: VkAccessFlags,
        var dstAccessMask: VkAccessFlags,
        var srcQueueFamilyIndex: Int,
        var dstQueueFamilyIndex: Int,
        var buffer: VkBuffer,
        var offset: VkDeviceSize = VkDeviceSize.NULL,
        var size: VkDeviceSize
) {

    val type get() = VkStructureType.BUFFER_MEMORY_BARRIER

    infix fun write(stack: VkStack): Adr =
        stack.ncalloc(ALIGNOF, 1, SIZEOF).also { write(it) }

    infix fun write(adr: Adr) {
        nsType(adr, type.i)
        nsrcAccessMask(adr, srcAccessMask)
        ndstAccessMask(adr, dstAccessMask)
        nsrcQueueFamilyIndex(adr, srcQueueFamilyIndex)
        ndstQueueFamilyIndex(adr, dstQueueFamilyIndex)
        nbuffer(adr, buffer.L)
        noffset(adr, offset.L)
        nsize(adr, size.L)
    }
}

infix fun Array<BufferMemoryBarrier>.write(stack: VkStack): Ptr {
    val natives = stack.ncalloc(ALIGNOF, size, SIZEOF)
    for (i in indices)
        this[i] write (natives + i * SIZEOF)
    return natives
}