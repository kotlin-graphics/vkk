package vkk.classes

import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.system.MemoryUtil.memPutAddress
import org.lwjgl.vulkan.VkPipelineShaderStageCreateInfo.*
import vkk.VkPipelineShaderStageCreateFlags
import vkk.VkShaderStage
import vkk.VkStructureType
import vkk.entities.VkShaderModule

/**
 * Structure specifying parameters of a newly created pipeline shader stage.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-geometryShader">geometry shaders</a> feature is not enabled, {@code stage} <b>must</b> not be {@link VK10#VK_SHADER_STAGE_GEOMETRY_BIT SHADER_STAGE_GEOMETRY_BIT}</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-tessellationShader">tessellation shaders</a> feature is not enabled, {@code stage} <b>must</b> not be {@link VK10#VK_SHADER_STAGE_TESSELLATION_CONTROL_BIT SHADER_STAGE_TESSELLATION_CONTROL_BIT} or {@link VK10#VK_SHADER_STAGE_TESSELLATION_EVALUATION_BIT SHADER_STAGE_TESSELLATION_EVALUATION_BIT}</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-meshShader">mesh shader</a> feature is not enabled, {@code stage} <b>must</b> not be {@link NVMeshShader#VK_SHADER_STAGE_MESH_BIT_NV SHADER_STAGE_MESH_BIT_NV}</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-taskShader">task shader</a> feature is not enabled, {@code stage} <b>must</b> not be {@link NVMeshShader#VK_SHADER_STAGE_TASK_BIT_NV SHADER_STAGE_TASK_BIT_NV}</li>
 * <li>{@code stage} <b>must</b> not be {@link VK10#VK_SHADER_STAGE_ALL_GRAPHICS SHADER_STAGE_ALL_GRAPHICS}, or {@link VK10#VK_SHADER_STAGE_ALL SHADER_STAGE_ALL}</li>
 * <li>{@code pName} <b>must</b> be the name of an {@code OpEntryPoint} in {@code module} with an execution model that matches {@code stage}</li>
 * <li>If the identified entry point includes any variable in its interface that is declared with the {@code ClipDistance} {@code BuiltIn} decoration, that variable <b>must</b> not have an array size greater than {@link VkPhysicalDeviceLimits}{@code ::maxClipDistances}</li>
 * <li>If the identified entry point includes any variable in its interface that is declared with the {@code CullDistance} {@code BuiltIn} decoration, that variable <b>must</b> not have an array size greater than {@link VkPhysicalDeviceLimits}{@code ::maxCullDistances}</li>
 * <li>If the identified entry point includes any variables in its interface that are declared with the {@code ClipDistance} or {@code CullDistance} {@code BuiltIn} decoration, those variables <b>must</b> not have array sizes which sum to more than {@link VkPhysicalDeviceLimits}{@code ::maxCombinedClipAndCullDistances}</li>
 * <li>If the identified entry point includes any variable in its interface that is declared with the {@code SampleMask} {@code BuiltIn} decoration, that variable <b>must</b> not have an array size greater than {@link VkPhysicalDeviceLimits}{@code ::maxSampleMaskWords}</li>
 * <li>If {@code stage} is {@link VK10#VK_SHADER_STAGE_VERTEX_BIT SHADER_STAGE_VERTEX_BIT}, the identified entry point <b>must</b> not include any input variable in its interface that is decorated with {@code CullDistance}</li>
 * <li>If {@code stage} is {@link VK10#VK_SHADER_STAGE_TESSELLATION_CONTROL_BIT SHADER_STAGE_TESSELLATION_CONTROL_BIT} or {@link VK10#VK_SHADER_STAGE_TESSELLATION_EVALUATION_BIT SHADER_STAGE_TESSELLATION_EVALUATION_BIT}, and the identified entry point has an {@code OpExecutionMode} instruction that specifies a patch size with {@code OutputVertices}, the patch size <b>must</b> be greater than 0 and less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxTessellationPatchSize}</li>
 * <li>If {@code stage} is {@link VK10#VK_SHADER_STAGE_GEOMETRY_BIT SHADER_STAGE_GEOMETRY_BIT}, the identified entry point <b>must</b> have an {@code OpExecutionMode} instruction that specifies a maximum output vertex count that is greater than 0 and less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxGeometryOutputVertices}</li>
 * <li>If {@code stage} is {@link VK10#VK_SHADER_STAGE_GEOMETRY_BIT SHADER_STAGE_GEOMETRY_BIT}, the identified entry point <b>must</b> have an {@code OpExecutionMode} instruction that specifies an invocation count that is greater than 0 and less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxGeometryShaderInvocations}</li>
 * <li>If {@code stage} is a vertex processing stage, and the identified entry point writes to {@code Layer} for any primitive, it <b>must</b> write the same value to {@code Layer} for all vertices of a given primitive</li>
 * <li>If {@code stage} is a vertex processing stage, and the identified entry point writes to {@code ViewportIndex} for any primitive, it <b>must</b> write the same value to {@code ViewportIndex} for all vertices of a given primitive</li>
 * <li>If {@code stage} is {@link VK10#VK_SHADER_STAGE_FRAGMENT_BIT SHADER_STAGE_FRAGMENT_BIT}, the identified entry point <b>must</b> not include any output variables in its interface decorated with {@code CullDistance}</li>
 * <li>If {@code stage} is {@link VK10#VK_SHADER_STAGE_FRAGMENT_BIT SHADER_STAGE_FRAGMENT_BIT}, and the identified entry point writes to {@code FragDepth} in any execution path, it <b>must</b> write to {@code FragDepth} in all execution paths</li>
 * <li>If {@code stage} is {@link VK10#VK_SHADER_STAGE_FRAGMENT_BIT SHADER_STAGE_FRAGMENT_BIT}, and the identified entry point writes to {@code FragStencilRefEXT} in any execution path, it <b>must</b> write to {@code FragStencilRefEXT} in all execution paths</li>
 * <li>If {@code stage} is {@link NVMeshShader#VK_SHADER_STAGE_MESH_BIT_NV SHADER_STAGE_MESH_BIT_NV}, the identified entry point <b>must</b> have an {@code OpExecutionMode} instruction that specifies a maximum output vertex count, {@code OutputVertices}, that is greater than 0 and less than or equal to {@link VkPhysicalDeviceMeshShaderPropertiesNV}{@code ::maxMeshOutputVertices}.</li>
 * <li>If {@code stage} is {@link NVMeshShader#VK_SHADER_STAGE_MESH_BIT_NV SHADER_STAGE_MESH_BIT_NV}, the identified entry point <b>must</b> have an {@code OpExecutionMode} instruction that specifies a maximum output primitive count, {@code OutputPrimitivesNV}, that is greater than 0 and less than or equal to {@link VkPhysicalDeviceMeshShaderPropertiesNV}{@code ::maxMeshOutputPrimitives}.</li>
 * <li>If {@code flags} has the {@link EXTSubgroupSizeControl#VK_PIPELINE_SHADER_STAGE_CREATE_ALLOW_VARYING_SUBGROUP_SIZE_BIT_EXT PIPELINE_SHADER_STAGE_CREATE_ALLOW_VARYING_SUBGROUP_SIZE_BIT_EXT} flag set, the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-subgroupSizeControl">{@code subgroupSizeControl}</a> feature <b>must</b> be enabled.</li>
 * <li>If {@code flags} has the {@link EXTSubgroupSizeControl#VK_PIPELINE_SHADER_STAGE_CREATE_REQUIRE_FULL_SUBGROUPS_BIT_EXT PIPELINE_SHADER_STAGE_CREATE_REQUIRE_FULL_SUBGROUPS_BIT_EXT} flag set, the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-computeFullSubgroups">{@code computeFullSubgroups}</a> feature <b>must</b> be enabled.</li>
 * <li>If a {@link VkPipelineShaderStageRequiredSubgroupSizeCreateInfoEXT} structure is chained to {@code pNext}, {@code flags} <b>must</b> not have the {@link EXTSubgroupSizeControl#VK_PIPELINE_SHADER_STAGE_CREATE_ALLOW_VARYING_SUBGROUP_SIZE_BIT_EXT PIPELINE_SHADER_STAGE_CREATE_ALLOW_VARYING_SUBGROUP_SIZE_BIT_EXT} flag set.</li>
 * <li>If a {@link VkPipelineShaderStageRequiredSubgroupSizeCreateInfoEXT} structure is chained to {@code pNext}, the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-subgroupSizeControl">{@code subgroupSizeControl}</a> feature <b>must</b> be enabled, and {@code stage} <b>must</b> be a valid bit specified in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#limits-required-subgroup-size-stages">{@code requiredSubgroupSizeStages}</a>.</li>
 * <li>If a {@link VkPipelineShaderStageRequiredSubgroupSizeCreateInfoEXT} structure is chained to {@code pNext} and {@code stage} is VK_SHADER_STAGE_COMPUTE_BIT then local workgroup size of the shader <b>must</b> be less than or equal to the product of {@link VkPipelineShaderStageRequiredSubgroupSizeCreateInfoEXT}{@code ::requiredSubgroupSize} and <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#limits-max-subgroups-per-workgroup">{@code maxComputeWorkgroupSubgroups}</a>.</li>
 * <li>If a {@link VkPipelineShaderStageRequiredSubgroupSizeCreateInfoEXT} structure is chained to {@code pNext}, and {@code flags} has the {@link EXTSubgroupSizeControl#VK_PIPELINE_SHADER_STAGE_CREATE_REQUIRE_FULL_SUBGROUPS_BIT_EXT PIPELINE_SHADER_STAGE_CREATE_REQUIRE_FULL_SUBGROUPS_BIT_EXT} flag set, the local workgroup size in the X dimension of the pipeline <b>must</b> be a multiple of {@link VkPipelineShaderStageRequiredSubgroupSizeCreateInfoEXT}{@code ::requiredSubgroupSize}.</li>
 * <li>If {@code flags} has both the {@link EXTSubgroupSizeControl#VK_PIPELINE_SHADER_STAGE_CREATE_REQUIRE_FULL_SUBGROUPS_BIT_EXT PIPELINE_SHADER_STAGE_CREATE_REQUIRE_FULL_SUBGROUPS_BIT_EXT} and {@link EXTSubgroupSizeControl#VK_PIPELINE_SHADER_STAGE_CREATE_ALLOW_VARYING_SUBGROUP_SIZE_BIT_EXT PIPELINE_SHADER_STAGE_CREATE_ALLOW_VARYING_SUBGROUP_SIZE_BIT_EXT} flags set, the local workgroup size in the X dimension of the pipeline <b>must</b> be a multiple of <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#limits-max-subgroup-size">{@code maxSubgroupSize}</a>.</li>
 * <li>If {@code flags} has the {@link EXTSubgroupSizeControl#VK_PIPELINE_SHADER_STAGE_CREATE_REQUIRE_FULL_SUBGROUPS_BIT_EXT PIPELINE_SHADER_STAGE_CREATE_REQUIRE_FULL_SUBGROUPS_BIT_EXT} flag set and {@code flags} does not have the {@link EXTSubgroupSizeControl#VK_PIPELINE_SHADER_STAGE_CREATE_ALLOW_VARYING_SUBGROUP_SIZE_BIT_EXT PIPELINE_SHADER_STAGE_CREATE_ALLOW_VARYING_SUBGROUP_SIZE_BIT_EXT} flag set and no {@link VkPipelineShaderStageRequiredSubgroupSizeCreateInfoEXT} structure is chained to {@code pNext}, the local workgroup size in the X dimension of the pipeline <b>must</b> be a multiple of <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#limits-subgroup-size">{@code subgroupSize}</a>.</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK10#VK_STRUCTURE_TYPE_PIPELINE_SHADER_STAGE_CREATE_INFO STRUCTURE_TYPE_PIPELINE_SHADER_STAGE_CREATE_INFO}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL} or a pointer to a valid instance of {@link VkPipelineShaderStageRequiredSubgroupSizeCreateInfoEXT}</li>
 * <li>{@code flags} <b>must</b> be a valid combination of {@code VkPipelineShaderStageCreateFlagBits} values</li>
 * <li>{@code stage} <b>must</b> be a valid {@code VkShaderStageFlagBits} value</li>
 * <li>{@code module} <b>must</b> be a valid {@code VkShaderModule} handle</li>
 * <li>{@code pName} <b>must</b> be a null-terminated UTF-8 string</li>
 * <li>If {@code pSpecializationInfo} is not {@code NULL}, {@code pSpecializationInfo} <b>must</b> be a valid pointer to a valid {@link VkSpecializationInfo} structure</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkComputePipelineCreateInfo}, {@link VkGraphicsPipelineCreateInfo}, {@link VkRayTracingPipelineCreateInfoNV}, {@link VkSpecializationInfo}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code flags} &ndash; a bitmask of {@code VkPipelineShaderStageCreateFlagBits} specifying how the pipeline shader stage will be generated.</li>
 * <li>{@code stage} &ndash; a {@code VkShaderStageFlagBits} value specifying a single pipeline stage.</li>
 * <li>{@code module} &ndash; a {@code VkShaderModule} object that contains the shader for this stage.</li>
 * <li>{@code pName} &ndash; a pointer to a null-terminated UTF-8 string specifying the entry point name of the shader for this stage.</li>
 * <li>{@code pSpecializationInfo} &ndash; a pointer to {@link VkSpecializationInfo}, as described in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#pipelines-specialization-constants">Specialization Constants</a>, and <b>can</b> be {@code NULL}.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPipelineShaderStageCreateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkPipelineShaderStageCreateFlags flags;
 *     VkShaderStageFlagBits stage;
 *     VkShaderModule module;
 *     char const * pName;
 *     {@link VkSpecializationInfo VkSpecializationInfo} const * pSpecializationInfo;
 * }</code></pre>
 */
class PipelineShaderStageCreateInfo(
    var flags: VkPipelineShaderStageCreateFlags = 0,
    var stage: VkShaderStage,
    var module: VkShaderModule,
    var name: String,
    var specializationInfo: SpecializationInfo? = null,
    var next: Ptr = NULL
) {

    val type get() = VkStructureType.PIPELINE_SHADER_STAGE_CREATE_INFO

    fun write(ptr: Ptr, stack: MemoryStack) {
        nsType(ptr, type.i)
        npNext(ptr, next)
        nflags(ptr, flags)
        nstage(ptr, stage.i)
        nmodule(ptr, module.L)
        npName(ptr, stack.UTF8(name))
        specializationInfo?.let { memPutAddress(ptr + PSPECIALIZATIONINFO, it.write(stack)) }
    }
}

infix fun Array<PipelineShaderStageCreateInfo>.write(stack: MemoryStack): Ptr {
    val natives = stack.ncalloc(ALIGNOF, size, SIZEOF)
    for (i in indices)
        this[i].write(natives + i * SIZEOF, stack)
    return natives
}