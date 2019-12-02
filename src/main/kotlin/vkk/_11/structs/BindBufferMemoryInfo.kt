package vkk._11.structs

import kool.Ptr
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.NULL
import vkk.VkStructureType
import vkk.entities.VkBuffer
import vkk.entities.VkDeviceMemory
import vkk.entities.VkDeviceSize

/**
 * Structure specifying how to bind a buffer to memory.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code buffer} <b>must</b> not already be backed by a memory object</li>
 * <li>{@code buffer} <b>must</b> not have been created with any sparse memory binding flags</li>
 * <li>{@code memoryOffset} <b>must</b> be less than the size of {@code memory}</li>
 * <li>{@code memory} <b>must</b> have been allocated using one of the memory types allowed in the {@code memoryTypeBits} member of the {@link VkMemoryRequirements} structure returned from a call to {@code vkGetBufferMemoryRequirements} with {@code buffer}</li>
 * <li>{@code memoryOffset} <b>must</b> be an integer multiple of the {@code alignment} member of the {@link VkMemoryRequirements} structure returned from a call to {@code vkGetBufferMemoryRequirements} with {@code buffer}</li>
 * <li>The {@code size} member of the {@link VkMemoryRequirements} structure returned from a call to {@code vkGetBufferMemoryRequirements} with {@code buffer} <b>must</b> be less than or equal to the size of {@code memory} minus {@code memoryOffset}</li>
 * <li>If {@code buffer} requires a dedicated allocation(as reported by {@link VK11#vkGetBufferMemoryRequirements2 GetBufferMemoryRequirements2} in {@link VkMemoryDedicatedRequirements}::requiresDedicatedAllocation for {@code buffer}), {@code memory} <b>must</b> have been created with {@link VkMemoryDedicatedAllocateInfo}{@code ::buffer} equal to {@code buffer} and {@code memoryOffset} <b>must</b> be zero</li>
 * <li>If the {@link VkMemoryAllocateInfo} provided when {@code memory} was allocated included an instance of {@link VkMemoryDedicatedAllocateInfo} in its {@code pNext} chain, and {@link VkMemoryDedicatedAllocateInfo}{@code ::buffer} was not {@link VK10#VK_NULL_HANDLE NULL_HANDLE}, then {@code buffer} <b>must</b> equal {@link VkMemoryDedicatedAllocateInfo}{@code ::buffer} and {@code memoryOffset} <b>must</b> be zero.</li>
 * <li>If {@code buffer} was created with {@link VkDedicatedAllocationBufferCreateInfoNV}{@code ::dedicatedAllocation} equal to {@link VK10#VK_TRUE TRUE}, {@code memory} <b>must</b> have been created with {@link VkDedicatedAllocationMemoryAllocateInfoNV}{@code ::buffer} equal to {@code buffer} and {@code memoryOffset} <b>must</b> be zero</li>
 * <li>If the {@code pNext} chain includes {@link VkBindBufferMemoryDeviceGroupInfo}, all instances of {@code memory} specified by {@link VkBindBufferMemoryDeviceGroupInfo}{@code ::pDeviceIndices} <b>must</b> have been allocated</li>
 * <li>If the value of {@link VkExportMemoryAllocateInfo}{@code ::handleTypes} used to allocate {@code memory} is not 0, it <b>must</b> include at least one of the handles set in {@link VkExternalMemoryImageCreateInfo}{@code ::handleTypes} when {@code image} was created</li>
 * <li>If {@code memory} was created by a memory import operation, the external handle type of the imported memory <b>must</b> also have been set in {@link VkExternalMemoryBufferCreateInfo}{@code ::handleTypes} when {@code buffer} was created</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_BIND_BUFFER_MEMORY_INFO STRUCTURE_TYPE_BIND_BUFFER_MEMORY_INFO}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL} or a pointer to a valid instance of {@link VkBindBufferMemoryDeviceGroupInfo}</li>
 * <li>{@code buffer} <b>must</b> be a valid {@code VkBuffer} handle</li>
 * <li>{@code memory} <b>must</b> be a valid {@code VkDeviceMemory} handle</li>
 * <li>Both of {@code buffer}, and {@code memory} <b>must</b> have been created, allocated, or retrieved from the same {@code VkDevice}</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VK11#vkBindBufferMemory2 BindBufferMemory2}, {@link KHRBindMemory2#vkBindBufferMemory2KHR BindBufferMemory2KHR}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code buffer} &ndash; the buffer to be attached to memory.</li>
 * <li>{@code memory} &ndash; a {@code VkDeviceMemory} object describing the device memory to attach.</li>
 * <li>{@code memoryOffset} &ndash; the start offset of the region of {@code memory} which is to be bound to the buffer. The number of bytes returned in the {@link VkMemoryRequirements}{@code ::size} member in {@code memory}, starting from {@code memoryOffset} bytes, will be bound to the specified buffer.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkBindBufferMemoryInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkBuffer buffer;
 *     VkDeviceMemory memory;
 *     VkDeviceSize memoryOffset;
 * }</code></pre>
 */
class BindBufferMemoryInfo(
    var buffer: VkBuffer,
    var memory: VkDeviceMemory,
    var memoryOffset: VkDeviceSize,
    var next: Ptr = NULL
) {

    val type get() = VkStructureType.BIND_BUFFER_MEMORY_INFO
}