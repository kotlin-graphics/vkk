package vkk.vk10.structs

import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.system.MemoryUtil.memPutAddress
import org.lwjgl.vulkan.VkBindSparseInfo.*
import vkk.VkStack
import vkk.VkStructureType
import vkk.entities.VkSemaphore_Array

/**
 * Structure specifying a sparse binding operation.
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK10#VK_STRUCTURE_TYPE_BIND_SPARSE_INFO STRUCTURE_TYPE_BIND_SPARSE_INFO}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL} or a pointer to a valid instance of {@link VkDeviceGroupBindSparseInfo}</li>
 * <li>If {@code waitSemaphoreCount} is not 0, {@code pWaitSemaphores} <b>must</b> be a valid pointer to an array of {@code waitSemaphoreCount} valid {@code VkSemaphore} handles</li>
 * <li>If {@code bufferBindCount} is not 0, {@code pBufferBinds} <b>must</b> be a valid pointer to an array of {@code bufferBindCount} valid {@link VkSparseBufferMemoryBindInfo} structures</li>
 * <li>If {@code imageOpaqueBindCount} is not 0, {@code pImageOpaqueBinds} <b>must</b> be a valid pointer to an array of {@code imageOpaqueBindCount} valid {@link VkSparseImageOpaqueMemoryBindInfo} structures</li>
 * <li>If {@code imageBindCount} is not 0, {@code pImageBinds} <b>must</b> be a valid pointer to an array of {@code imageBindCount} valid {@link VkSparseImageMemoryBindInfo} structures</li>
 * <li>If {@code signalSemaphoreCount} is not 0, {@code pSignalSemaphores} <b>must</b> be a valid pointer to an array of {@code signalSemaphoreCount} valid {@code VkSemaphore} handles</li>
 * <li>Both of the elements of {@code pSignalSemaphores}, and the elements of {@code pWaitSemaphores} that are valid handles <b>must</b> have been created, allocated, or retrieved from the same {@code VkDevice}</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkSparseBufferMemoryBindInfo}, {@link VkSparseImageMemoryBindInfo}, {@link VkSparseImageOpaqueMemoryBindInfo}, {@link VK10#vkQueueBindSparse QueueBindSparse}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code waitSemaphoreCount} &ndash; the number of semaphores upon which to wait before executing the sparse binding operations for the batch.</li>
 * <li>{@code pWaitSemaphores} &ndash; a pointer to an array of semaphores upon which to wait on before the sparse binding operations for this batch begin execution. If semaphores to wait on are provided, they define a <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-semaphores-waiting">semaphore wait operation</a>.</li>
 * <li>{@code bufferBindCount} &ndash; the number of sparse buffer bindings to perform in the batch.</li>
 * <li>{@code pBufferBinds} &ndash; a pointer to an array of {@link VkSparseBufferMemoryBindInfo} structures.</li>
 * <li>{@code imageOpaqueBindCount} &ndash; the number of opaque sparse image bindings to perform.</li>
 * <li>{@code pImageOpaqueBinds} &ndash; a pointer to an array of {@link VkSparseImageOpaqueMemoryBindInfo} structures, indicating opaque sparse image bindings to perform.</li>
 * <li>{@code imageBindCount} &ndash; the number of sparse image bindings to perform.</li>
 * <li>{@code pImageBinds} &ndash; a pointer to an array of {@link VkSparseImageMemoryBindInfo} structures, indicating sparse image bindings to perform.</li>
 * <li>{@code signalSemaphoreCount} &ndash; the number of semaphores to be signaled once the sparse binding operations specified by the structure have completed execution.</li>
 * <li>{@code pSignalSemaphores} &ndash; a pointer to an array of semaphores which will be signaled when the sparse binding operations for this batch have completed execution. If semaphores to be signaled are provided, they define a <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-semaphores-signaling">semaphore signal operation</a>.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkBindSparseInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     uint32_t waitSemaphoreCount;
 *     VkSemaphore const * pWaitSemaphores;
 *     uint32_t bufferBindCount;
 *     {@link VkSparseBufferMemoryBindInfo VkSparseBufferMemoryBindInfo} const * pBufferBinds;
 *     uint32_t imageOpaqueBindCount;
 *     {@link VkSparseImageOpaqueMemoryBindInfo VkSparseImageOpaqueMemoryBindInfo} const * pImageOpaqueBinds;
 *     uint32_t imageBindCount;
 *     {@link VkSparseImageMemoryBindInfo VkSparseImageMemoryBindInfo} const * pImageBinds;
 *     uint32_t signalSemaphoreCount;
 *     VkSemaphore const * pSignalSemaphores;
 * }</code></pre>
 */
class BindSparseInfo(
        var waitSemaphores: VkSemaphore_Array,
        var bufferBinds: Array<SparseBufferMemoryBindInfo>,
        var imageOpaqueBinds: Array<SparseImageOpaqueMemoryBindInfo>,
        var imageBinds: Array<SparseImageMemoryBindInfo>,
        var signalSemaphores: VkSemaphore_Array,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.BIND_SPARSE_INFO

    infix fun write(stack: VkStack): Adr =
            stack.ncalloc(ALIGNOF, 1, SIZEOF).also { write(it, stack) }

    fun write(adr: Adr, stack: VkStack) {
        nsType(adr, type.i)
        npNext(adr, next)
        nwaitSemaphoreCount(adr, waitSemaphores.size)
        memPutAddress(adr + PWAITSEMAPHORES, waitSemaphores write stack)
        nbufferBindCount(adr, bufferBinds.size)
        memPutAddress(adr + PBUFFERBINDS, bufferBinds write stack)
        nimageOpaqueBindCount(adr, imageOpaqueBinds.size)
        memPutAddress(adr + PIMAGEOPAQUEBINDS, imageOpaqueBinds write stack)
        nimageBindCount(adr, imageBinds.size)
        memPutAddress(adr + PIMAGEBINDS, imageBinds write stack)
    }
}

infix fun Array<BindSparseInfo>.write(stack: VkStack): Ptr {
    val natives = stack.ncalloc(ALIGNOF, size, SIZEOF)
    for (i in indices)
        this[i].write(natives + i * SIZEOF, stack)
    return natives
}