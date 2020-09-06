package vkk.vk10.structs

import glm_.L
import kool.Adr
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.memPutAddress
import org.lwjgl.vulkan.VkPipelineCacheCreateInfo.*
import vkk.VkStack
import vkk.VkStructureType
import vkk.adr

/**
 * Structure specifying parameters of a newly created pipeline cache.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>If {@code initialDataSize} is not 0, it <b>must</b> be equal to the size of {@code pInitialData}, as returned by {@code vkGetPipelineCacheData} when {@code pInitialData} was originally retrieved</li>
 * <li>If {@code initialDataSize} is not 0, {@code pInitialData} <b>must</b> have been retrieved from a previous call to {@code vkGetPipelineCacheData}</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK10#VK_STRUCTURE_TYPE_PIPELINE_CACHE_CREATE_INFO STRUCTURE_TYPE_PIPELINE_CACHE_CREATE_INFO}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL}</li>
 * <li>{@code flags} <b>must</b> be 0</li>
 * <li>If {@code initialDataSize} is not 0, {@code pInitialData} <b>must</b> be a valid pointer to an array of {@code initialDataSize} bytes</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VK10#vkCreatePipelineCache CreatePipelineCache}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code flags} &ndash; reserved for future use.</li>
 * <li>{@code initialDataSize} &ndash; the number of bytes in {@code pInitialData}. If {@code initialDataSize} is zero, the pipeline cache will initially be empty.</li>
 * <li>{@code pInitialData} &ndash; a pointer to previously retrieved pipeline cache data. If the pipeline cache data is incompatible (as defined below) with the device, the pipeline cache will be initially empty. If {@code initialDataSize} is zero, {@code pInitialData} is ignored.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPipelineCacheCreateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkPipelineCacheCreateFlags flags;
 *     size_t initialDataSize;
 *     void const * pInitialData;
 * }</code></pre>
 */
class PipelineCacheCreateInfo(
        var initialData: ByteArray? = null
) {

    val type get() = VkStructureType.PIPELINE_CACHE_CREATE_INFO

    infix fun write(stack: MemoryStack): Adr {
        val adr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
        nsType(adr, type.i)
        initialData?.let {
            ninitialDataSize(adr, it.size.L)
            memPutAddress(adr + PINITIALDATA, stack.adr(it))
        }
        return adr
    }
}