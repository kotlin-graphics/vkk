package vkk.vk10.structs

import glm_.i
import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.vulkan.VkCommandBufferInheritanceInfo.*
import vkk.VkQueryControlFlags
import vkk.VkQueryPipelineStatisticFlags
import vkk.VkStructureType
import vkk.entities.VkFramebuffer
import vkk.entities.VkRenderPass

/**
 * Structure specifying command buffer inheritance info.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-inheritedQueries">inherited queries</a> feature is not enabled, {@code occlusionQueryEnable} <b>must</b> be {@link VK10#VK_FALSE FALSE}</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-inheritedQueries">inherited queries</a> feature is enabled, {@code queryFlags} <b>must</b> be a valid combination of {@code VkQueryControlFlagBits} values</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-inheritedQueries">inherited queries</a> feature is not enabled, {@code queryFlags} <b>must</b> be 0</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-pipelineStatisticsQuery">pipeline statistics queries</a> feature is enabled, {@code pipelineStatistics} <b>must</b> be a valid combination of {@code VkQueryPipelineStatisticFlagBits} values</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-pipelineStatisticsQuery">pipeline statistics queries</a> feature is not enabled, {@code pipelineStatistics} <b>must</b> be 0</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK10#VK_STRUCTURE_TYPE_COMMAND_BUFFER_INHERITANCE_INFO STRUCTURE_TYPE_COMMAND_BUFFER_INHERITANCE_INFO}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL} or a pointer to a valid instance of {@link VkCommandBufferInheritanceConditionalRenderingInfoEXT}</li>
 * <li>Both of {@code framebuffer}, and {@code renderPass} that are valid handles <b>must</b> have been created, allocated, or retrieved from the same {@code VkDevice}</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkCommandBufferBeginInfo}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code renderPass} &ndash; a {@code VkRenderPass} object defining which render passes the {@code VkCommandBuffer} will be <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#renderpass-compatibility">compatible</a> with and <b>can</b> be executed within. If the {@code VkCommandBuffer} will not be executed within a render pass instance, {@code renderPass} is ignored.</li>
 * <li>{@code subpass} &ndash; the index of the subpass within the render pass instance that the {@code VkCommandBuffer} will be executed within. If the {@code VkCommandBuffer} will not be executed within a render pass instance, {@code subpass} is ignored.</li>
 * <li>{@code framebuffer} &ndash; optionally refers to the {@code VkFramebuffer} object that the {@code VkCommandBuffer} will be rendering to if it is executed within a render pass instance. It <b>can</b> be {@link VK10#VK_NULL_HANDLE NULL_HANDLE} if the framebuffer is not known, or if the {@code VkCommandBuffer} will not be executed within a render pass instance.
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>Specifying the exact framebuffer that the secondary command buffer will be executed with <b>may</b> result in better performance at command buffer execution time.</p>
 * </div></li>
 * <li>{@code occlusionQueryEnable} &ndash; specifies whether the command buffer <b>can</b> be executed while an occlusion query is active in the primary command buffer. If this is {@link VK10#VK_TRUE TRUE}, then this command buffer <b>can</b> be executed whether the primary command buffer has an occlusion query active or not. If this is {@link VK10#VK_FALSE FALSE}, then the primary command buffer <b>must</b> not have an occlusion query active.</li>
 * <li>{@code queryFlags} &ndash; specifies the query flags that <b>can</b> be used by an active occlusion query in the primary command buffer when this secondary command buffer is executed. If this value includes the {@link VK10#VK_QUERY_CONTROL_PRECISE_BIT QUERY_CONTROL_PRECISE_BIT} bit, then the active query <b>can</b> return boolean results or actual sample counts. If this bit is not set, then the active query <b>must</b> not use the {@link VK10#VK_QUERY_CONTROL_PRECISE_BIT QUERY_CONTROL_PRECISE_BIT} bit.</li>
 * <li>{@code pipelineStatistics} &ndash; a bitmask of {@code VkQueryPipelineStatisticFlagBits} specifying the set of pipeline statistics that <b>can</b> be counted by an active query in the primary command buffer when this secondary command buffer is executed. If this value includes a given bit, then this command buffer <b>can</b> be executed whether the primary command buffer has a pipeline statistics query active that includes this bit or not. If this value excludes a given bit, then the active pipeline statistics query <b>must</b> not be from a query pool that counts that statistic.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkCommandBufferInheritanceInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkRenderPass renderPass;
 *     uint32_t subpass;
 *     VkFramebuffer framebuffer;
 *     VkBool32 occlusionQueryEnable;
 *     VkQueryControlFlags queryFlags;
 *     VkQueryPipelineStatisticFlags pipelineStatistics;
 * }</code></pre>
 */
class CommandBufferInheritanceInfo(
        var renderPass: VkRenderPass,
        var subpass: Int,
        var framebuffer: VkFramebuffer,
        var occlusionQueryEnable: Boolean,
        var queryFlags: VkQueryControlFlags,
        var pipelineStatistics: VkQueryPipelineStatisticFlags,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.COMMAND_BUFFER_INHERITANCE_INFO

    infix fun write(stack: MemoryStack): Adr =
            stack.ncalloc(ALIGNOF, 1, SIZEOF).also { write(it) }

    fun write(adr: Adr) {
        nsType(adr, type.i)
        npNext(adr, next)
        nrenderPass(adr, renderPass.L)
        nframebuffer(adr, framebuffer.L)
        nocclusionQueryEnable(adr, occlusionQueryEnable.i)
        nqueryFlags(adr, queryFlags)
        npipelineStatistics(adr, pipelineStatistics)
    }
}