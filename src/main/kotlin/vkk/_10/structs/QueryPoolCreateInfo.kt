package vkk._10.structs

import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.vulkan.VkQueryPoolCreateInfo.*
import vkk.VkQueryPipelineStatisticFlags
import vkk.VkQueryType
import vkk.VkStack
import vkk.VkStructureType

/**
 * Structure specifying parameters of a newly created query pool.
 *
 * <h5>Description</h5>
 *
 * <p>{@code pipelineStatistics} is ignored if {@code queryType} is not {@link VK10#VK_QUERY_TYPE_PIPELINE_STATISTICS QUERY_TYPE_PIPELINE_STATISTICS}.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-pipelineStatisticsQuery">pipeline statistics queries</a> feature is not enabled, {@code queryType} <b>must</b> not be {@link VK10#VK_QUERY_TYPE_PIPELINE_STATISTICS QUERY_TYPE_PIPELINE_STATISTICS}</li>
 * <li>If {@code queryType} is {@link VK10#VK_QUERY_TYPE_PIPELINE_STATISTICS QUERY_TYPE_PIPELINE_STATISTICS}, {@code pipelineStatistics} <b>must</b> be a valid combination of {@code VkQueryPipelineStatisticFlagBits} values</li>
 * <li>{@code queryCount} <b>must</b> be greater than 0</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK10#VK_STRUCTURE_TYPE_QUERY_POOL_CREATE_INFO STRUCTURE_TYPE_QUERY_POOL_CREATE_INFO}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL}</li>
 * <li>{@code flags} <b>must</b> be 0</li>
 * <li>{@code queryType} <b>must</b> be a valid {@code VkQueryType} value</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VK10#vkCreateQueryPool CreateQueryPool}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code flags} &ndash; reserved for future use.</li>
 * <li>{@code queryType} &ndash; a {@code VkQueryType} value specifying the type of queries managed by the pool.</li>
 * <li>{@code queryCount} &ndash; the number of queries managed by the pool.</li>
 * <li>{@code pipelineStatistics} &ndash; a bitmask of {@code VkQueryPipelineStatisticFlagBits} specifying which counters will be returned in queries on the new pool, as described below in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#queries-pipestats">Pipeline Statistics Queries</a>.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkQueryPoolCreateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkQueryPoolCreateFlags flags;
 *     VkQueryType queryType;
 *     uint32_t queryCount;
 *     VkQueryPipelineStatisticFlags pipelineStatistics;
 * }</code></pre>
 */
class QueryPoolCreateInfo(
        var queryType: VkQueryType,
        var queryCount: Int,
        var pipelineStatistics: VkQueryPipelineStatisticFlags,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.QUERY_POOL_CREATE_INFO

    infix fun write(stack: VkStack): Adr {
        val adr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
        nqueryType(adr, type.i)
        npNext(adr, next)
        nqueryType(adr, queryType.i)
        npipelineStatistics(adr, pipelineStatistics)
        return adr
    }
}