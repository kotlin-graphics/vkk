package classes

import identifiers.CommandBuffer
import identifiers.native
import kool.Ptr
import kool.adr
import kool.toBuffer
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.system.MemoryUtil.memPutAddress
import org.lwjgl.vulkan.VkSubmitInfo.*
import util.native
import vkk.VkStructureType
import vkk.entities.VkSemaphore
import vkk.entities.VkSemaphore_Array

/**
 * Structure specifying a queue submit operation.
 *
 * <h5>Description</h5>
 *
 * <p>The order that command buffers appear in {@code pCommandBuffers} is used to determine <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-submission-order">submission order</a>, and thus all the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-implicit">implicit ordering guarantees</a> that respect it. Other than these implicit ordering guarantees and any <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization">explicit synchronization primitives</a>, these command buffers <b>may</b> overlap or otherwise execute out of order.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>Each element of {@code pCommandBuffers} <b>must</b> not have been allocated with {@link VK10#VK_COMMAND_BUFFER_LEVEL_SECONDARY COMMAND_BUFFER_LEVEL_SECONDARY}</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-geometryShader">geometry shaders</a> feature is not enabled, each element of {@code pWaitDstStageMask} <b>must</b> not contain {@link VK10#VK_PIPELINE_STAGE_GEOMETRY_SHADER_BIT PIPELINE_STAGE_GEOMETRY_SHADER_BIT}</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-tessellationShader">tessellation shaders</a> feature is not enabled, each element of {@code pWaitDstStageMask} <b>must</b> not contain {@link VK10#VK_PIPELINE_STAGE_TESSELLATION_CONTROL_SHADER_BIT PIPELINE_STAGE_TESSELLATION_CONTROL_SHADER_BIT} or {@link VK10#VK_PIPELINE_STAGE_TESSELLATION_EVALUATION_SHADER_BIT PIPELINE_STAGE_TESSELLATION_EVALUATION_SHADER_BIT}</li>
 * <li>Each element of {@code pWaitDstStageMask} <b>must</b> not include {@link VK10#VK_PIPELINE_STAGE_HOST_BIT PIPELINE_STAGE_HOST_BIT}.</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-meshShader">mesh shaders</a> feature is not enabled, each element of {@code pWaitDstStageMask} <b>must</b> not contain {@link NVMeshShader#VK_PIPELINE_STAGE_MESH_SHADER_BIT_NV PIPELINE_STAGE_MESH_SHADER_BIT_NV}</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-taskShader">task shaders</a> feature is not enabled, each element of {@code pWaitDstStageMask} <b>must</b> not contain {@link NVMeshShader#VK_PIPELINE_STAGE_TASK_SHADER_BIT_NV PIPELINE_STAGE_TASK_SHADER_BIT_NV}</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK10#VK_STRUCTURE_TYPE_SUBMIT_INFO STRUCTURE_TYPE_SUBMIT_INFO}</li>
 * <li>Each {@code pNext} member of any structure (including this one) in the {@code pNext} chain <b>must</b> be either {@code NULL} or a pointer to a valid instance of {@link VkD3D12FenceSubmitInfoKHR}, {@link VkDeviceGroupSubmitInfo}, {@link VkProtectedSubmitInfo}, {@link VkWin32KeyedMutexAcquireReleaseInfoKHR}, or {@link VkWin32KeyedMutexAcquireReleaseInfoNV}</li>
 * <li>Each {@code sType} member in the {@code pNext} chain <b>must</b> be unique</li>
 * <li>If {@code waitSemaphoreCount} is not 0, {@code pWaitSemaphores} <b>must</b> be a valid pointer to an array of {@code waitSemaphoreCount} valid {@code VkSemaphore} handles</li>
 * <li>If {@code waitSemaphoreCount} is not 0, {@code pWaitDstStageMask} <b>must</b> be a valid pointer to an array of {@code waitSemaphoreCount} valid combinations of {@code VkPipelineStageFlagBits} values</li>
 * <li>Each element of {@code pWaitDstStageMask} <b>must</b> not be 0</li>
 * <li>If {@code commandBufferCount} is not 0, {@code pCommandBuffers} <b>must</b> be a valid pointer to an array of {@code commandBufferCount} valid {@code VkCommandBuffer} handles</li>
 * <li>If {@code signalSemaphoreCount} is not 0, {@code pSignalSemaphores} <b>must</b> be a valid pointer to an array of {@code signalSemaphoreCount} valid {@code VkSemaphore} handles</li>
 * <li>Each of the elements of {@code pCommandBuffers}, the elements of {@code pSignalSemaphores}, and the elements of {@code pWaitSemaphores} that are valid handles <b>must</b> have been created, allocated, or retrieved from the same {@code VkDevice}</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VK10#vkQueueSubmit QueueSubmit}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code waitSemaphoreCount} &ndash; the number of semaphores upon which to wait before executing the command buffers for the batch.</li>
 * <li>{@code pWaitSemaphores} &ndash; a pointer to an array of semaphores upon which to wait before the command buffers for this batch begin execution. If semaphores to wait on are provided, they define a <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-semaphores-waiting">semaphore wait operation</a>.</li>
 * <li>{@code pWaitDstStageMask} &ndash; a pointer to an array of pipeline stages at which each corresponding semaphore wait will occur.</li>
 * <li>{@code commandBufferCount} &ndash; the number of command buffers to execute in the batch.</li>
 * <li>{@code pCommandBuffers} &ndash; a pointer to an array of command buffers to execute in the batch.</li>
 * <li>{@code signalSemaphoreCount} &ndash; the number of semaphores to be signaled once the commands specified in {@code pCommandBuffers} have completed execution.</li>
 * <li>{@code pSignalSemaphores} &ndash; a pointer to an array of semaphores which will be signaled when the command buffers for this batch have completed execution. If semaphores to be signaled are provided, they define a <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-semaphores-signaling">semaphore signal operation</a>.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkSubmitInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     uint32_t waitSemaphoreCount;
 *     VkSemaphore const * pWaitSemaphores;
 *     VkPipelineStageFlags const * pWaitDstStageMask;
 *     uint32_t commandBufferCount;
 *     VkCommandBuffer const * pCommandBuffers;
 *     uint32_t signalSemaphoreCount;
 *     VkSemaphore const * pSignalSemaphores;
 * }</code></pre>
 */
class SubmitInfo(
    var waitSemaphoreCount: Int = 0,
    var waitSemaphores: VkSemaphore_Array? = null,
    var waitDstStageMask: IntArray? = null,
    var commandBuffers: Array<CommandBuffer>? = null,
    var signalSemaphores: VkSemaphore_Array? = null,
    var next: Ptr = NULL,
    commandBuffer: CommandBuffer? = null
) {
    init {
        commandBuffer?.let { commandBuffers = arrayOf(it) }
    }

    val type get() = VkStructureType.SUBMIT_INFO

    var commandBuffer: CommandBuffer?
        get() = commandBuffers?.get(0)
        set(value) {
            when (value) {
                null -> commandBuffers = null
                else -> when (val bufs = commandBuffers) {
                    null -> commandBuffers = Array(1) { value!! }
                    else -> bufs[0] = value
                }
            }
        }

    constructor(
        waitSemaphore: VkSemaphore,
        waitDstStageMask: Int,
        commandBuffer: CommandBuffer? = null,
        signalSemaphore: VkSemaphore
    ) : this(
        1,
        VkSemaphore_Array(1) { waitSemaphore },
        intArrayOf(waitDstStageMask),
        commandBuffer?.let { arrayOf(it) },
        VkSemaphore_Array(1) { signalSemaphore }
    )

    val MemoryStack.native: Ptr
        get() = ncalloc(ALIGNOF, 1, SIZEOF).also { p ->
            nsType(p, type.i)
            npNext(p, next)
            nwaitSemaphoreCount(p, waitSemaphoreCount)
            waitSemaphores?.let { memPutAddress(p + PWAITSEMAPHORES, it.native(this)) }
            waitDstStageMask?.let { memPutAddress(p + PWAITDSTSTAGEMASK, it.toBuffer(this).adr) }
            commandBuffers?.let {
                memPutAddress(p + PCOMMANDBUFFERS, it.native(this))
                ncommandBufferCount(p, it.size)
            }
            signalSemaphores?.let {
                memPutAddress(p + PSIGNALSEMAPHORES, it.native(this))
                nsignalSemaphoreCount(p, it.size)
            }
        }
}