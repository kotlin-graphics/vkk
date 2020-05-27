package vkk.vk10.structs

import kool.Adr
import kool.Ptr
import org.lwjgl.vulkan.VkSubpassDependency.*
import vkk.VkAccessFlags
import vkk.VkDependencyFlags
import vkk.VkPipelineStageFlags
import vkk.VkStack

/**
 * Structure specifying a subpass dependency.
 *
 * <h5>Description</h5>
 *
 * <p>If {@code srcSubpass} is equal to {@code dstSubpass} then the {@link VkSubpassDependency} describes a <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-pipeline-barriers-subpass-self-dependencies">subpass self-dependency</a>, and only constrains the pipeline barriers allowed within a subpass instance. Otherwise, when a render pass instance which includes a subpass dependency is submitted to a queue, it defines a memory dependency between the subpasses identified by {@code srcSubpass} and {@code dstSubpass}.</p>
 *
 * <p>If {@code srcSubpass} is equal to {@link VK10#VK_SUBPASS_EXTERNAL SUBPASS_EXTERNAL}, the first <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-dependencies-scopes">synchronization scope</a> includes commands that occur earlier in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-submission-order">submission order</a> than the {@link VK10#vkCmdBeginRenderPass CmdBeginRenderPass} used to begin the render pass instance. Otherwise, the first set of commands includes all commands submitted as part of the subpass instance identified by {@code srcSubpass} and any load, store or multisample resolve operations on attachments used in {@code srcSubpass}. In either case, the first synchronization scope is limited to operations on the pipeline stages determined by the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-pipeline-stages-masks">source stage mask</a> specified by {@code srcStageMask}.</p>
 *
 * <p>If {@code dstSubpass} is equal to {@link VK10#VK_SUBPASS_EXTERNAL SUBPASS_EXTERNAL}, the second <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-dependencies-scopes">synchronization scope</a> includes commands that occur later in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-submission-order">submission order</a> than the {@link VK10#vkCmdEndRenderPass CmdEndRenderPass} used to end the render pass instance. Otherwise, the second set of commands includes all commands submitted as part of the subpass instance identified by {@code dstSubpass} and any load, store or multisample resolve operations on attachments used in {@code dstSubpass}. In either case, the second synchronization scope is limited to operations on the pipeline stages determined by the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-pipeline-stages-masks">destination stage mask</a> specified by {@code dstStageMask}.</p>
 *
 * <p>The first <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-dependencies-access-scopes">access scope</a> is limited to access in the pipeline stages determined by the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-pipeline-stages-masks">source stage mask</a> specified by {@code srcStageMask}. It is also limited to access types in the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-access-masks">source access mask</a> specified by {@code srcAccessMask}.</p>
 *
 * <p>The second <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-dependencies-access-scopes">access scope</a> is limited to access in the pipeline stages determined by the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-pipeline-stages-masks">destination stage mask</a> specified by {@code dstStageMask}. It is also limited to access types in the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-access-masks">destination access mask</a> specified by {@code dstAccessMask}.</p>
 *
 * <p>The <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-dependencies-available-and-visible">availability and visibility operations</a> defined by a subpass dependency affect the execution of <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#renderpass-layout-transitions">image layout transitions</a> within the render pass.</p>
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>For non-attachment resources, the memory dependency expressed by subpass dependency is nearly identical to that of a {@link VkMemoryBarrier} (with matching {@code srcAccessMask}/{@code dstAccessMask} parameters) submitted as a part of a {@link VK10#vkCmdPipelineBarrier CmdPipelineBarrier} (with matching {@code srcStageMask}/{@code dstStageMask} parameters). The only difference being that its scopes are limited to the identified subpasses rather than potentially affecting everything before and after.</p>
 *
 * <p>For attachments however, subpass dependencies work more like a {@link VkImageMemoryBarrier} defined similarly to the {@link VkMemoryBarrier} above, the queue family indices set to {@link VK10#VK_QUEUE_FAMILY_IGNORED QUEUE_FAMILY_IGNORED}, and layouts as follows:</p>
 *
 * <ul>
 * <li>The equivalent to {@code oldLayout} is the attachment&#8217;s layout according to the subpass description for {@code srcSubpass}.</li>
 * <li>The equivalent to {@code newLayout} is the attachment&#8217;s layout according to the subpass description for {@code dstSubpass}.</li>
 * </ul>
 * </div>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-geometryShader">geometry shaders</a> feature is not enabled, {@code srcStageMask} <b>must</b> not contain {@link VK10#VK_PIPELINE_STAGE_GEOMETRY_SHADER_BIT PIPELINE_STAGE_GEOMETRY_SHADER_BIT}</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-geometryShader">geometry shaders</a> feature is not enabled, {@code dstStageMask} <b>must</b> not contain {@link VK10#VK_PIPELINE_STAGE_GEOMETRY_SHADER_BIT PIPELINE_STAGE_GEOMETRY_SHADER_BIT}</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-tessellationShader">tessellation shaders</a> feature is not enabled, {@code srcStageMask} <b>must</b> not contain {@link VK10#VK_PIPELINE_STAGE_TESSELLATION_CONTROL_SHADER_BIT PIPELINE_STAGE_TESSELLATION_CONTROL_SHADER_BIT} or {@link VK10#VK_PIPELINE_STAGE_TESSELLATION_EVALUATION_SHADER_BIT PIPELINE_STAGE_TESSELLATION_EVALUATION_SHADER_BIT}</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-tessellationShader">tessellation shaders</a> feature is not enabled, {@code dstStageMask} <b>must</b> not contain {@link VK10#VK_PIPELINE_STAGE_TESSELLATION_CONTROL_SHADER_BIT PIPELINE_STAGE_TESSELLATION_CONTROL_SHADER_BIT} or {@link VK10#VK_PIPELINE_STAGE_TESSELLATION_EVALUATION_SHADER_BIT PIPELINE_STAGE_TESSELLATION_EVALUATION_SHADER_BIT}</li>
 * <li>{@code srcSubpass} <b>must</b> be less than or equal to {@code dstSubpass}, unless one of them is {@link VK10#VK_SUBPASS_EXTERNAL SUBPASS_EXTERNAL}, to avoid cyclic dependencies and ensure a valid execution order</li>
 * <li>{@code srcSubpass} and {@code dstSubpass} <b>must</b> not both be equal to {@link VK10#VK_SUBPASS_EXTERNAL SUBPASS_EXTERNAL}</li>
 * <li>If {@code srcSubpass} is equal to {@code dstSubpass} and not all of the stages in {@code srcStageMask} and {@code dstStageMask} are <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-framebuffer-regions">framebuffer-space stages</a>, the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-pipeline-stages-order">logically latest</a> pipeline stage in {@code srcStageMask} <b>must</b> be <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-pipeline-stages-order">logically earlier</a> than or equal to the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-pipeline-stages-order">logically earliest</a> pipeline stage in {@code dstStageMask}</li>
 * <li>Any access flag included in {@code srcAccessMask} <b>must</b> be supported by one of the pipeline stages in {@code srcStageMask}, as specified in the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-access-types-supported">table of supported access types</a></li>
 * <li>Any access flag included in {@code dstAccessMask} <b>must</b> be supported by one of the pipeline stages in {@code dstStageMask}, as specified in the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-access-types-supported">table of supported access types</a></li>
 * <li>If {@code srcSubpass} equals {@code dstSubpass}, and {@code srcStageMask} and {@code dstStageMask} both include a <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-framebuffer-regions">framebuffer-space stage</a>, then {@code dependencyFlags} <b>must</b> include {@link VK10#VK_DEPENDENCY_BY_REGION_BIT DEPENDENCY_BY_REGION_BIT}</li>
 * <li>If {@code dependencyFlags} includes {@link VK11#VK_DEPENDENCY_VIEW_LOCAL_BIT DEPENDENCY_VIEW_LOCAL_BIT}, {@code srcSubpass} <b>must</b> not be equal to {@link VK10#VK_SUBPASS_EXTERNAL SUBPASS_EXTERNAL}</li>
 * <li>If {@code dependencyFlags} includes {@link VK11#VK_DEPENDENCY_VIEW_LOCAL_BIT DEPENDENCY_VIEW_LOCAL_BIT}, {@code dstSubpass} <b>must</b> not be equal to {@link VK10#VK_SUBPASS_EXTERNAL SUBPASS_EXTERNAL}</li>
 * <li>If {@code srcSubpass} equals {@code dstSubpass} and that subpass has more than one bit set in the view mask, then {@code dependencyFlags} <b>must</b> include {@link VK11#VK_DEPENDENCY_VIEW_LOCAL_BIT DEPENDENCY_VIEW_LOCAL_BIT}</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-meshShader">mesh shaders</a> feature is not enabled, {@code srcStageMask} <b>must</b> not contain {@link NVMeshShader#VK_PIPELINE_STAGE_MESH_SHADER_BIT_NV PIPELINE_STAGE_MESH_SHADER_BIT_NV}</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-taskShader">task shaders</a> feature is not enabled, {@code srcStageMask} <b>must</b> not contain {@link NVMeshShader#VK_PIPELINE_STAGE_TASK_SHADER_BIT_NV PIPELINE_STAGE_TASK_SHADER_BIT_NV}</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-meshShader">mesh shaders</a> feature is not enabled, {@code dstStageMask} <b>must</b> not contain {@link NVMeshShader#VK_PIPELINE_STAGE_MESH_SHADER_BIT_NV PIPELINE_STAGE_MESH_SHADER_BIT_NV}</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-taskShader">task shaders</a> feature is not enabled, {@code dstStageMask} <b>must</b> not contain {@link NVMeshShader#VK_PIPELINE_STAGE_TASK_SHADER_BIT_NV PIPELINE_STAGE_TASK_SHADER_BIT_NV}</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code srcStageMask} <b>must</b> be a valid combination of {@code VkPipelineStageFlagBits} values</li>
 * <li>{@code srcStageMask} <b>must</b> not be 0</li>
 * <li>{@code dstStageMask} <b>must</b> be a valid combination of {@code VkPipelineStageFlagBits} values</li>
 * <li>{@code dstStageMask} <b>must</b> not be 0</li>
 * <li>{@code srcAccessMask} <b>must</b> be a valid combination of {@code VkAccessFlagBits} values</li>
 * <li>{@code dstAccessMask} <b>must</b> be a valid combination of {@code VkAccessFlagBits} values</li>
 * <li>{@code dependencyFlags} <b>must</b> be a valid combination of {@code VkDependencyFlagBits} values</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkRenderPassCreateInfo}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code srcSubpass} &ndash; the subpass index of the first subpass in the dependency, or {@link VK10#VK_SUBPASS_EXTERNAL SUBPASS_EXTERNAL}.</li>
 * <li>{@code dstSubpass} &ndash; the subpass index of the second subpass in the dependency, or {@link VK10#VK_SUBPASS_EXTERNAL SUBPASS_EXTERNAL}.</li>
 * <li>{@code srcStageMask} &ndash; a bitmask of {@code VkPipelineStageFlagBits} specifying the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-pipeline-stages-masks">source stage mask</a>.</li>
 * <li>{@code dstStageMask} &ndash; a bitmask of {@code VkPipelineStageFlagBits} specifying the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-pipeline-stages-masks">destination stage mask</a></li>
 * <li>{@code srcAccessMask} &ndash; a bitmask of {@code VkAccessFlagBits} specifying a <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-access-masks">source access mask</a>.</li>
 * <li>{@code dstAccessMask} &ndash; a bitmask of {@code VkAccessFlagBits} specifying a <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#synchronization-access-masks">destination access mask</a>.</li>
 * <li>{@code dependencyFlags} &ndash; a bitmask of {@code VkDependencyFlagBits}.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkSubpassDependency {
 *     uint32_t srcSubpass;
 *     uint32_t dstSubpass;
 *     VkPipelineStageFlags srcStageMask;
 *     VkPipelineStageFlags dstStageMask;
 *     VkAccessFlags srcAccessMask;
 *     VkAccessFlags dstAccessMask;
 *     VkDependencyFlags dependencyFlags;
 * }</code></pre>
 */
class SubpassDependency(
    var srcSubpass: Int,
    var dstSubpass: Int,
    var srcStageMask: VkPipelineStageFlags = 0,
    var dstStageMask: VkPipelineStageFlags = 0,
    var srcAccessMask: VkAccessFlags = 0,
    var dstAccessMask: VkAccessFlags = 0,
    var dependencyFlags: VkDependencyFlags = 0
) {

    fun write(stack: VkStack): Adr =
        stack.ncalloc(ALIGNOF, 1, SIZEOF).also { write(it) }

    infix fun write(adr: Adr) {
        nsrcSubpass(adr, srcSubpass)
        ndstSubpass(adr, dstSubpass)
        nsrcStageMask(adr, srcStageMask)
        ndstStageMask(adr, dstStageMask)
        nsrcAccessMask(adr, srcAccessMask)
        ndstAccessMask(adr, dstAccessMask)
        ndependencyFlags(adr, dependencyFlags)
    }
}

infix fun Array<SubpassDependency>.write(stack: VkStack): Ptr {
    val natives = stack.ncalloc(ALIGNOF, size, SIZEOF)
    for (i in indices)
        this[i] write (natives + i * SIZEOF)
    return natives
}