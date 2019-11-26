package classes

import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.system.MemoryUtil.memPutAddress
import org.lwjgl.vulkan.VkGraphicsPipelineCreateInfo.*
import vkk.VkPipelineCreateFlags
import vkk.VkStructureType
import vkk.entities.VkPipeline
import vkk.entities.VkPipelineLayout
import vkk.entities.VkRenderPass

/**
 * Structure specifying parameters of a newly created graphics pipeline.
 *
 * <h5>Description</h5>
 *
 * <p>The parameters {@code basePipelineHandle} and {@code basePipelineIndex} are described in more detail in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#pipelines-pipeline-derivatives">Pipeline Derivatives</a>.</p>
 *
 * <p>{@code pStages} points to an array of {@link VkPipelineShaderStageCreateInfo} structures, which were previously described in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#pipelines-compute">Compute Pipelines</a>.</p>
 *
 * <p>{@code pDynamicState} points to a structure of type {@link VkPipelineDynamicStateCreateInfo}.</p>
 *
 * <p>If any shader stage fails to compile, the compile log will be reported back to the application, and {@link NVGLSLShader#VK_ERROR_INVALID_SHADER_NV ERROR_INVALID_SHADER_NV} will be generated.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>If {@code flags} contains the {@link VK10#VK_PIPELINE_CREATE_DERIVATIVE_BIT PIPELINE_CREATE_DERIVATIVE_BIT} flag, and {@code basePipelineIndex} is -1, {@code basePipelineHandle} <b>must</b> be a valid handle to a graphics {@code VkPipeline}</li>
 * <li>If {@code flags} contains the {@link VK10#VK_PIPELINE_CREATE_DERIVATIVE_BIT PIPELINE_CREATE_DERIVATIVE_BIT} flag, and {@code basePipelineHandle} is {@link VK10#VK_NULL_HANDLE NULL_HANDLE}, {@code basePipelineIndex} <b>must</b> be a valid index into the calling command&#8217;s {@code pCreateInfos} parameter</li>
 * <li>If {@code flags} contains the {@link VK10#VK_PIPELINE_CREATE_DERIVATIVE_BIT PIPELINE_CREATE_DERIVATIVE_BIT} flag, and {@code basePipelineIndex} is not -1, {@code basePipelineHandle} <b>must</b> be {@link VK10#VK_NULL_HANDLE NULL_HANDLE}</li>
 * <li>If {@code flags} contains the {@link VK10#VK_PIPELINE_CREATE_DERIVATIVE_BIT PIPELINE_CREATE_DERIVATIVE_BIT} flag, and {@code basePipelineHandle} is not {@link VK10#VK_NULL_HANDLE NULL_HANDLE}, {@code basePipelineIndex} <b>must</b> be -1</li>
 * <li>The {@code stage} member of each element of {@code pStages} <b>must</b> be unique</li>
 * <li>The geometric shader stages provided in {@code pStages} <b>must</b> be either from the mesh shading pipeline ({@code stage} is {@link NVMeshShader#VK_SHADER_STAGE_TASK_BIT_NV SHADER_STAGE_TASK_BIT_NV} or {@link NVMeshShader#VK_SHADER_STAGE_MESH_BIT_NV SHADER_STAGE_MESH_BIT_NV}) or from the primitive shading pipeline ({@code stage} is {@link VK10#VK_SHADER_STAGE_VERTEX_BIT SHADER_STAGE_VERTEX_BIT}, {@link VK10#VK_SHADER_STAGE_TESSELLATION_CONTROL_BIT SHADER_STAGE_TESSELLATION_CONTROL_BIT}, {@link VK10#VK_SHADER_STAGE_TESSELLATION_EVALUATION_BIT SHADER_STAGE_TESSELLATION_EVALUATION_BIT}, or {@link VK10#VK_SHADER_STAGE_GEOMETRY_BIT SHADER_STAGE_GEOMETRY_BIT}).</li>
 * <li>The {@code stage} member of one element of {@code pStages} <b>must</b> be either {@link VK10#VK_SHADER_STAGE_VERTEX_BIT SHADER_STAGE_VERTEX_BIT} or {@link NVMeshShader#VK_SHADER_STAGE_MESH_BIT_NV SHADER_STAGE_MESH_BIT_NV}.</li>
 * <li>The {@code stage} member of each element of {@code pStages} <b>must</b> not be {@link VK10#VK_SHADER_STAGE_COMPUTE_BIT SHADER_STAGE_COMPUTE_BIT}</li>
 * <li>If {@code pStages} includes a tessellation control shader stage, it <b>must</b> include a tessellation evaluation shader stage</li>
 * <li>If {@code pStages} includes a tessellation evaluation shader stage, it <b>must</b> include a tessellation control shader stage</li>
 * <li>If {@code pStages} includes a tessellation control shader stage and a tessellation evaluation shader stage, {@code pTessellationState} <b>must</b> be a valid pointer to a valid {@link VkPipelineTessellationStateCreateInfo} structure</li>
 * <li>If {@code pStages} includes tessellation shader stages, the shader code of at least one stage <b>must</b> contain an {@code OpExecutionMode} instruction that specifies the type of subdivision in the pipeline</li>
 * <li>If {@code pStages} includes tessellation shader stages, and the shader code of both stages contain an {@code OpExecutionMode} instruction that specifies the type of subdivision in the pipeline, they <b>must</b> both specify the same subdivision mode</li>
 * <li>If {@code pStages} includes tessellation shader stages, the shader code of at least one stage <b>must</b> contain an {@code OpExecutionMode} instruction that specifies the output patch size in the pipeline</li>
 * <li>If {@code pStages} includes tessellation shader stages, and the shader code of both contain an {@code OpExecutionMode} instruction that specifies the out patch size in the pipeline, they <b>must</b> both specify the same patch size</li>
 * <li>If {@code pStages} includes tessellation shader stages, the {@code topology} member of {@code pInputAssembly} <b>must</b> be {@link VK10#VK_PRIMITIVE_TOPOLOGY_PATCH_LIST PRIMITIVE_TOPOLOGY_PATCH_LIST}</li>
 * <li>If the {@code topology} member of {@code pInputAssembly} is {@link VK10#VK_PRIMITIVE_TOPOLOGY_PATCH_LIST PRIMITIVE_TOPOLOGY_PATCH_LIST}, {@code pStages} <b>must</b> include tessellation shader stages</li>
 * <li>If {@code pStages} includes a geometry shader stage, and does not include any tessellation shader stages, its shader code <b>must</b> contain an {@code OpExecutionMode} instruction that specifies an input primitive type that is <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#shaders-geometry-execution">compatible</a> with the primitive topology specified in {@code pInputAssembly}</li>
 * <li>If {@code pStages} includes a geometry shader stage, and also includes tessellation shader stages, its shader code <b>must</b> contain an {@code OpExecutionMode} instruction that specifies an input primitive type that is <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#shaders-geometry-execution">compatible</a> with the primitive topology that is output by the tessellation stages</li>
 * <li>If {@code pStages} includes a fragment shader stage and a geometry shader stage, and the fragment shader code reads from an input variable that is decorated with {@code PrimitiveID}, then the geometry shader code <b>must</b> write to a matching output variable, decorated with {@code PrimitiveID}, in all execution paths</li>
 * <li>If {@code pStages} includes a fragment shader stage, its shader code <b>must</b> not read from any input attachment that is defined as {@link VK10#VK_ATTACHMENT_UNUSED ATTACHMENT_UNUSED} in {@code subpass}</li>
 * <li>The shader code for the entry points identified by {@code pStages}, and the rest of the state identified by this structure <b>must</b> adhere to the pipeline linking rules described in the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#interfaces">Shader Interfaces</a> chapter</li>
 * <li>If rasterization is not disabled and {@code subpass} uses a depth/stencil attachment in {@code renderPass} that has a layout of {@link VK10#VK_IMAGE_LAYOUT_DEPTH_STENCIL_READ_ONLY_OPTIMAL IMAGE_LAYOUT_DEPTH_STENCIL_READ_ONLY_OPTIMAL} or {@link VK11#VK_IMAGE_LAYOUT_DEPTH_READ_ONLY_STENCIL_ATTACHMENT_OPTIMAL IMAGE_LAYOUT_DEPTH_READ_ONLY_STENCIL_ATTACHMENT_OPTIMAL} in the {@link VkAttachmentReference} defined by {@code subpass}, the {@code depthWriteEnable} member of {@code pDepthStencilState} <b>must</b> be {@link VK10#VK_FALSE FALSE}</li>
 * <li>If rasterization is not disabled and {@code subpass} uses a depth/stencil attachment in {@code renderPass} that has a layout of {@link VK10#VK_IMAGE_LAYOUT_DEPTH_STENCIL_READ_ONLY_OPTIMAL IMAGE_LAYOUT_DEPTH_STENCIL_READ_ONLY_OPTIMAL} or {@link VK11#VK_IMAGE_LAYOUT_DEPTH_ATTACHMENT_STENCIL_READ_ONLY_OPTIMAL IMAGE_LAYOUT_DEPTH_ATTACHMENT_STENCIL_READ_ONLY_OPTIMAL} in the {@link VkAttachmentReference} defined by {@code subpass}, the {@code failOp}, {@code passOp} and {@code depthFailOp} members of each of the {@code front} and {@code back} members of {@code pDepthStencilState} <b>must</b> be {@link VK10#VK_STENCIL_OP_KEEP STENCIL_OP_KEEP}</li>
 * <li>If rasterization is not disabled and the subpass uses color attachments, then for each color attachment in the subpass the {@code blendEnable} member of the corresponding element of the {@code pAttachment} member of {@code pColorBlendState} <b>must</b> be {@link VK10#VK_FALSE FALSE} if the attached image&#8217;s <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#resources-image-format-features">format features</a> does not contain {@link VK10#VK_FORMAT_FEATURE_COLOR_ATTACHMENT_BLEND_BIT FORMAT_FEATURE_COLOR_ATTACHMENT_BLEND_BIT}.</li>
 * <li>If rasterization is not disabled and the subpass uses color attachments, the {@code attachmentCount} member of {@code pColorBlendState} <b>must</b> be equal to the {@code colorAttachmentCount} used to create {@code subpass}</li>
 * <li>If no element of the {@code pDynamicStates} member of {@code pDynamicState} is {@link VK10#VK_DYNAMIC_STATE_VIEWPORT DYNAMIC_STATE_VIEWPORT}, the {@code pViewports} member of {@code pViewportState} <b>must</b> be a valid pointer to an array of {@code pViewportState}{@code ::viewportCount} valid {@link VkViewport} structures</li>
 * <li>If no element of the {@code pDynamicStates} member of {@code pDynamicState} is {@link VK10#VK_DYNAMIC_STATE_SCISSOR DYNAMIC_STATE_SCISSOR}, the {@code pScissors} member of {@code pViewportState} <b>must</b> be a valid pointer to an array of {@code pViewportState}{@code ::scissorCount} {@link VkRect2D} structures</li>
 * <li>If the wide lines feature is not enabled, and no element of the {@code pDynamicStates} member of {@code pDynamicState} is {@link VK10#VK_DYNAMIC_STATE_LINE_WIDTH DYNAMIC_STATE_LINE_WIDTH}, the {@code lineWidth} member of {@code pRasterizationState} <b>must</b> be {@code 1.0}</li>
 * <li>If the {@code rasterizerDiscardEnable} member of {@code pRasterizationState} is {@link VK10#VK_FALSE FALSE}, {@code pViewportState} <b>must</b> be a valid pointer to a valid {@link VkPipelineViewportStateCreateInfo} structure</li>
 * <li>If the {@code rasterizerDiscardEnable} member of {@code pRasterizationState} is {@link VK10#VK_FALSE FALSE}, {@code pMultisampleState} <b>must</b> be a valid pointer to a valid {@link VkPipelineMultisampleStateCreateInfo} structure</li>
 * <li>If the {@code rasterizerDiscardEnable} member of {@code pRasterizationState} is {@link VK10#VK_FALSE FALSE}, and {@code subpass} uses a depth/stencil attachment, {@code pDepthStencilState} <b>must</b> be a valid pointer to a valid {@link VkPipelineDepthStencilStateCreateInfo} structure</li>
 * <li>If the {@code rasterizerDiscardEnable} member of {@code pRasterizationState} is {@link VK10#VK_FALSE FALSE}, and {@code subpass} uses color attachments, {@code pColorBlendState} <b>must</b> be a valid pointer to a valid {@link VkPipelineColorBlendStateCreateInfo} structure</li>
 * <li>If the depth bias clamping feature is not enabled, no element of the {@code pDynamicStates} member of {@code pDynamicState} is {@link VK10#VK_DYNAMIC_STATE_DEPTH_BIAS DYNAMIC_STATE_DEPTH_BIAS}, and the {@code depthBiasEnable} member of {@code pRasterizationState} is {@link VK10#VK_TRUE TRUE}, the {@code depthBiasClamp} member of {@code pRasterizationState} <b>must</b> be {@code 0.0}</li>
 * <li>If the {@link EXTDepthRangeUnrestricted VK_EXT_depth_range_unrestricted} extension is not enabled and no element of the {@code pDynamicStates} member of {@code pDynamicState} is {@link VK10#VK_DYNAMIC_STATE_DEPTH_BOUNDS DYNAMIC_STATE_DEPTH_BOUNDS}, and the {@code depthBoundsTestEnable} member of {@code pDepthStencilState} is {@link VK10#VK_TRUE TRUE}, the {@code minDepthBounds} and {@code maxDepthBounds} members of {@code pDepthStencilState} <b>must</b> be between {@code 0.0} and {@code 1.0}, inclusive</li>
 * <li>If no element of the {@code pDynamicStates} member of {@code pDynamicState} is {@link EXTSampleLocations#VK_DYNAMIC_STATE_SAMPLE_LOCATIONS_EXT DYNAMIC_STATE_SAMPLE_LOCATIONS_EXT}, and the {@code sampleLocationsEnable} member of a {@link VkPipelineSampleLocationsStateCreateInfoEXT} structure chained to the {@code pNext} chain of {@code pMultisampleState} is {@link VK10#VK_TRUE TRUE}, {@code sampleLocationsInfo.sampleLocationGridSize.width} <b>must</b> evenly divide {@link VkMultisamplePropertiesEXT}{@code ::sampleLocationGridSize}.width as returned by {@link EXTSampleLocations#vkGetPhysicalDeviceMultisamplePropertiesEXT GetPhysicalDeviceMultisamplePropertiesEXT} with a {@code samples} parameter equaling {@code rasterizationSamples}</li>
 * <li>If no element of the {@code pDynamicStates} member of {@code pDynamicState} is {@link EXTSampleLocations#VK_DYNAMIC_STATE_SAMPLE_LOCATIONS_EXT DYNAMIC_STATE_SAMPLE_LOCATIONS_EXT}, and the {@code sampleLocationsEnable} member of a {@link VkPipelineSampleLocationsStateCreateInfoEXT} structure chained to the {@code pNext} chain of {@code pMultisampleState} is {@link VK10#VK_TRUE TRUE}, {@code sampleLocationsInfo.sampleLocationGridSize.height} <b>must</b> evenly divide {@link VkMultisamplePropertiesEXT}{@code ::sampleLocationGridSize}.height as returned by {@link EXTSampleLocations#vkGetPhysicalDeviceMultisamplePropertiesEXT GetPhysicalDeviceMultisamplePropertiesEXT} with a {@code samples} parameter equaling {@code rasterizationSamples}</li>
 * <li>If no element of the {@code pDynamicStates} member of {@code pDynamicState} is {@link EXTSampleLocations#VK_DYNAMIC_STATE_SAMPLE_LOCATIONS_EXT DYNAMIC_STATE_SAMPLE_LOCATIONS_EXT}, and the {@code sampleLocationsEnable} member of a {@link VkPipelineSampleLocationsStateCreateInfoEXT} structure chained to the {@code pNext} chain of {@code pMultisampleState} is {@link VK10#VK_TRUE TRUE}, {@code sampleLocationsInfo.sampleLocationsPerPixel} <b>must</b> equal {@code rasterizationSamples}</li>
 * <li>If the {@code sampleLocationsEnable} member of a {@link VkPipelineSampleLocationsStateCreateInfoEXT} structure chained to the {@code pNext} chain of {@code pMultisampleState} is {@link VK10#VK_TRUE TRUE}, the fragment shader code <b>must</b> not statically use the extended instruction {@code InterpolateAtSample}</li>
 * <li>{@code layout} <b>must</b> be <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#descriptorsets-pipelinelayout-consistency">consistent</a> with all shaders specified in {@code pStages}</li>
 * <li>If neither the {@code VK_AMD_mixed_attachment_samples} nor the {@code VK_NV_framebuffer_mixed_samples} extensions are enabled, and if {@code subpass} uses color and/or depth/stencil attachments, then the {@code rasterizationSamples} member of {@code pMultisampleState} <b>must</b> be the same as the sample count for those subpass attachments</li>
 * <li>If the {@code VK_AMD_mixed_attachment_samples} extension is enabled, and if {@code subpass} uses color and/or depth/stencil attachments, then the {@code rasterizationSamples} member of {@code pMultisampleState} <b>must</b> equal the maximum of the sample counts of those subpass attachments</li>
 * <li>If the {@code VK_NV_framebuffer_mixed_samples} extension is enabled, and if {@code subpass} has a depth/stencil attachment and depth test, stencil test, or depth bounds test are enabled, then the {@code rasterizationSamples} member of {@code pMultisampleState} <b>must</b> be the same as the sample count of the depth/stencil attachment</li>
 * <li>If the {@code VK_NV_framebuffer_mixed_samples} extension is enabled, and if {@code subpass} has any color attachments, then the {@code rasterizationSamples} member of {@code pMultisampleState} <b>must</b> be greater than or equal to the sample count for those subpass attachments</li>
 * <li>If the {@code VK_NV_coverage_reduction_mode} extension is enabled, the coverage reduction mode specified by {@link VkPipelineCoverageReductionStateCreateInfoNV}{@code ::coverageReductionMode}, the {@code rasterizationSamples} member of {@code pMultisampleState} and the sample counts for the color and depth/stencil attachments (if the subpass has them) <b>must</b> be a valid combination returned by {@code vkGetPhysicalDeviceSupportedFramebufferMixedSamplesCombinationsNV}</li>
 * <li>If {@code subpass} does not use any color and/or depth/stencil attachments, then the {@code rasterizationSamples} member of {@code pMultisampleState} <b>must</b> follow the rules for a <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#renderpass-noattachments">zero-attachment subpass</a></li>
 * <li>{@code subpass} <b>must</b> be a valid subpass within {@code renderPass}</li>
 * <li>If the {@code renderPass} has multiview enabled and {@code subpass} has more than one bit set in the view mask and {@code multiviewTessellationShader} is not enabled, then {@code pStages} <b>must</b> not include tessellation shaders.</li>
 * <li>If the {@code renderPass} has multiview enabled and {@code subpass} has more than one bit set in the view mask and {@code multiviewGeometryShader} is not enabled, then {@code pStages} <b>must</b> not include a geometry shader.</li>
 * <li>If the {@code renderPass} has multiview enabled and {@code subpass} has more than one bit set in the view mask, shaders in the pipeline <b>must</b> not write to the {@code Layer} built-in output</li>
 * <li>If the {@code renderPass} has multiview enabled, then all shaders <b>must</b> not include variables decorated with the {@code Layer} built-in decoration in their interfaces.</li>
 * <li>{@code flags} <b>must</b> not contain the {@link VK11#VK_PIPELINE_CREATE_DISPATCH_BASE PIPELINE_CREATE_DISPATCH_BASE} flag.</li>
 * <li>If {@code pStages} includes a fragment shader stage and an input attachment was referenced by the {@link VkRenderPassInputAttachmentAspectCreateInfo} at {@code renderPass} create time, its shader code <b>must</b> not read from any aspect that was not specified in the {@code aspectMask} of the corresponding {@link VkInputAttachmentAspectReference} structure.</li>
 * <li>The number of resources in {@code layout} accessible to each shader stage that is used by the pipeline <b>must</b> be less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxPerStageResources}</li>
 * <li>If no element of the {@code pDynamicStates} member of {@code pDynamicState} is {@link NVClipSpaceWScaling#VK_DYNAMIC_STATE_VIEWPORT_W_SCALING_NV DYNAMIC_STATE_VIEWPORT_W_SCALING_NV}, and the {@code viewportWScalingEnable} member of a {@link VkPipelineViewportWScalingStateCreateInfoNV} structure, chained to the {@code pNext} chain of {@code pViewportState}, is {@link VK10#VK_TRUE TRUE}, the {@code pViewportWScalings} member of the {@link VkPipelineViewportWScalingStateCreateInfoNV} <b>must</b> be a pointer to an array of {@link VkPipelineViewportWScalingStateCreateInfoNV}{@code ::viewportCount} valid {@link VkViewportWScalingNV} structures</li>
 * <li>If {@code pStages} includes a vertex shader stage, {@code pVertexInputState} <b>must</b> be a valid pointer to a valid {@link VkPipelineVertexInputStateCreateInfo} structure</li>
 * <li>If {@code pStages} includes a vertex shader stage, {@code pInputAssemblyState} <b>must</b> be a valid pointer to a valid {@link VkPipelineInputAssemblyStateCreateInfo} structure</li>
 * <li>The {@code Xfb} execution mode <b>can</b> be specified by only one shader stage in {@code pStages}</li>
 * <li>If any shader stage in {@code pStages} specifies {@code Xfb} execution mode it <b>must</b> be the last vertex processing stage</li>
 * <li>If a {@link VkPipelineRasterizationStateStreamCreateInfoEXT}{@code ::rasterizationStream} value other than zero is specified, all variables in the output interface of the entry point being compiled decorated with {@code Position}, {@code PointSize}, {@code ClipDistance}, or {@code CullDistance} <b>must</b> all be decorated with identical {@code Stream} values that match the {@code rasterizationStream}</li>
 * <li>If {@link VkPipelineRasterizationStateStreamCreateInfoEXT}{@code ::rasterizationStream} is zero, or not specified, all variables in the output interface of the entry point being compiled decorated with {@code Position}, {@code PointSize}, {@code ClipDistance}, or {@code CullDistance} <b>must</b> all be decorated with a {@code Stream} value of zero, or <b>must</b> not specify the {@code Stream} decoration</li>
 * <li>If the last vertex processing stage is a geometry shader, and that geometry shader uses the {@code GeometryStreams} capability, then {@link VkPhysicalDeviceTransformFeedbackFeaturesEXT}{@code ::geometryStreams} feature <b>must</b> be enabled</li>
 * <li>If there are any mesh shader stages in the pipeline there <b>must</b> not be any shader stage in the pipeline with a {@code Xfb} execution mode.</li>
 * <li>If the {@code lineRasterizationMode} member of a {@link VkPipelineRasterizationLineStateCreateInfoEXT} structure chained to the {@code pNext} chain of {@code pRasterizationState} is {@link EXTLineRasterization#VK_LINE_RASTERIZATION_MODE_BRESENHAM_EXT LINE_RASTERIZATION_MODE_BRESENHAM_EXT} or {@link EXTLineRasterization#VK_LINE_RASTERIZATION_MODE_RECTANGULAR_SMOOTH_EXT LINE_RASTERIZATION_MODE_RECTANGULAR_SMOOTH_EXT} and if rasterization is enabled, then the {@code alphaToCoverageEnable}, {@code alphaToOneEnable}, and {@code sampleShadingEnable} members of {@code pMultisampleState} <b>must</b> all be {@link VK10#VK_FALSE FALSE}</li>
 * <li>If the {@code stippledLineEnable} member of {@link VkPipelineRasterizationLineStateCreateInfoEXT} is {@link VK10#VK_TRUE TRUE} and no element of the {@code pDynamicStates} member of {@code pDynamicState} is {@link EXTLineRasterization#VK_DYNAMIC_STATE_LINE_STIPPLE_EXT DYNAMIC_STATE_LINE_STIPPLE_EXT}, then the {@code lineStippleFactor} member of {@link VkPipelineRasterizationLineStateCreateInfoEXT} <b>must</b> be in the range <code>[1,256]</code></li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK10#VK_STRUCTURE_TYPE_GRAPHICS_PIPELINE_CREATE_INFO STRUCTURE_TYPE_GRAPHICS_PIPELINE_CREATE_INFO}</li>
 * <li>Each {@code pNext} member of any structure (including this one) in the {@code pNext} chain <b>must</b> be either {@code NULL} or a pointer to a valid instance of {@link VkPipelineCompilerControlCreateInfoAMD}, {@link VkPipelineCreationFeedbackCreateInfoEXT}, {@link VkPipelineDiscardRectangleStateCreateInfoEXT}, or {@link VkPipelineRepresentativeFragmentTestStateCreateInfoNV}</li>
 * <li>Each {@code sType} member in the {@code pNext} chain <b>must</b> be unique</li>
 * <li>{@code flags} <b>must</b> be a valid combination of {@code VkPipelineCreateFlagBits} values</li>
 * <li>{@code pStages} <b>must</b> be a valid pointer to an array of {@code stageCount} valid {@link VkPipelineShaderStageCreateInfo} structures</li>
 * <li>{@code pRasterizationState} <b>must</b> be a valid pointer to a valid {@link VkPipelineRasterizationStateCreateInfo} structure</li>
 * <li>If {@code pDynamicState} is not {@code NULL}, {@code pDynamicState} <b>must</b> be a valid pointer to a valid {@link VkPipelineDynamicStateCreateInfo} structure</li>
 * <li>{@code layout} <b>must</b> be a valid {@code VkPipelineLayout} handle</li>
 * <li>{@code renderPass} <b>must</b> be a valid {@code VkRenderPass} handle</li>
 * <li>{@code stageCount} <b>must</b> be greater than 0</li>
 * <li>Each of {@code basePipelineHandle}, {@code layout}, and {@code renderPass} that are valid handles <b>must</b> have been created, allocated, or retrieved from the same {@code VkDevice}</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkPipelineColorBlendStateCreateInfo}, {@link VkPipelineDepthStencilStateCreateInfo}, {@link VkPipelineDynamicStateCreateInfo}, {@link VkPipelineInputAssemblyStateCreateInfo}, {@link VkPipelineMultisampleStateCreateInfo}, {@link VkPipelineRasterizationStateCreateInfo}, {@link VkPipelineShaderStageCreateInfo}, {@link VkPipelineTessellationStateCreateInfo}, {@link VkPipelineVertexInputStateCreateInfo}, {@link VkPipelineViewportStateCreateInfo}, {@link VK10#vkCreateGraphicsPipelines CreateGraphicsPipelines}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code flags} &ndash; a bitmask of {@code VkPipelineCreateFlagBits} specifying how the pipeline will be generated.</li>
 * <li>{@code stageCount} &ndash; the number of entries in the {@code pStages} array.</li>
 * <li>{@code pStages} &ndash; an array of size {@code stageCount} structures of type {@link VkPipelineShaderStageCreateInfo} describing the set of the shader stages to be included in the graphics pipeline.</li>
 * <li>{@code pVertexInputState} &ndash; a pointer to an instance of the {@link VkPipelineVertexInputStateCreateInfo} structure. It is ignored if the pipeline includes a mesh shader stage.</li>
 * <li>{@code pInputAssemblyState} &ndash; a pointer to an instance of the {@link VkPipelineInputAssemblyStateCreateInfo} structure which determines input assembly behavior, as described in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#drawing">Drawing Commands</a>. It is ignored if the pipeline includes a mesh shader stage.</li>
 * <li>{@code pTessellationState} &ndash; a pointer to an instance of the {@link VkPipelineTessellationStateCreateInfo} structure, and is ignored if the pipeline does not include a tessellation control shader stage and tessellation evaluation shader stage.</li>
 * <li>{@code pViewportState} &ndash; a pointer to an instance of the {@link VkPipelineViewportStateCreateInfo} structure, and is ignored if the pipeline has rasterization disabled.</li>
 * <li>{@code pRasterizationState} &ndash; a pointer to an instance of the {@link VkPipelineRasterizationStateCreateInfo} structure.</li>
 * <li>{@code pMultisampleState} &ndash; a pointer to an instance of the {@link VkPipelineMultisampleStateCreateInfo}, and is ignored if the pipeline has rasterization disabled.</li>
 * <li>{@code pDepthStencilState} &ndash; a pointer to an instance of the {@link VkPipelineDepthStencilStateCreateInfo} structure, and is ignored if the pipeline has rasterization disabled or if the subpass of the render pass the pipeline is created against does not use a depth/stencil attachment.</li>
 * <li>{@code pColorBlendState} &ndash; a pointer to an instance of the {@link VkPipelineColorBlendStateCreateInfo} structure, and is ignored if the pipeline has rasterization disabled or if the subpass of the render pass the pipeline is created against does not use any color attachments.</li>
 * <li>{@code pDynamicState} &ndash; a pointer to {@link VkPipelineDynamicStateCreateInfo} and is used to indicate which properties of the pipeline state object are dynamic and <b>can</b> be changed independently of the pipeline state. This <b>can</b> be {@code NULL}, which means no state in the pipeline is considered dynamic.</li>
 * <li>{@code layout} &ndash; the description of binding locations used by both the pipeline and descriptor sets used with the pipeline.</li>
 * <li>{@code renderPass} &ndash; a handle to a render pass object describing the environment in which the pipeline will be used; the pipeline <b>must</b> only be used with an instance of any render pass compatible with the one provided. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#renderpass-compatibility">Render Pass Compatibility</a> for more information.</li>
 * <li>{@code subpass} &ndash; the index of the subpass in the render pass where this pipeline will be used.</li>
 * <li>{@code basePipelineHandle} &ndash; a pipeline to derive from.</li>
 * <li>{@code basePipelineIndex} &ndash; an index into the {@code pCreateInfos} parameter to use as a pipeline to derive from.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkGraphicsPipelineCreateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkPipelineCreateFlags flags;
 *     uint32_t stageCount;
 *     {@link VkPipelineShaderStageCreateInfo VkPipelineShaderStageCreateInfo} const * pStages;
 *     {@link VkPipelineVertexInputStateCreateInfo VkPipelineVertexInputStateCreateInfo} const * pVertexInputState;
 *     {@link VkPipelineInputAssemblyStateCreateInfo VkPipelineInputAssemblyStateCreateInfo} const * pInputAssemblyState;
 *     {@link VkPipelineTessellationStateCreateInfo VkPipelineTessellationStateCreateInfo} const * pTessellationState;
 *     {@link VkPipelineViewportStateCreateInfo VkPipelineViewportStateCreateInfo} const * pViewportState;
 *     {@link VkPipelineRasterizationStateCreateInfo VkPipelineRasterizationStateCreateInfo} const * pRasterizationState;
 *     {@link VkPipelineMultisampleStateCreateInfo VkPipelineMultisampleStateCreateInfo} const * pMultisampleState;
 *     {@link VkPipelineDepthStencilStateCreateInfo VkPipelineDepthStencilStateCreateInfo} const * pDepthStencilState;
 *     {@link VkPipelineColorBlendStateCreateInfo VkPipelineColorBlendStateCreateInfo} const * pColorBlendState;
 *     {@link VkPipelineDynamicStateCreateInfo VkPipelineDynamicStateCreateInfo} const * pDynamicState;
 *     VkPipelineLayout layout;
 *     VkRenderPass renderPass;
 *     uint32_t subpass;
 *     VkPipeline basePipelineHandle;
 *     int32_t basePipelineIndex;
 * }</code></pre>
 */
class GraphicsPipelineCreateInfo(
        var flags: VkPipelineCreateFlags = 0,
        var stages: Array<PipelineShaderStageCreateInfo>,
        var vertexInputState: PipelineVertexInputStateCreateInfo? = null,
        var inputAssemblyState: PipelineInputAssemblyStateCreateInfo? = null,
        var tessellationState: PipelineTessellationStateCreateInfo? = null,
        var viewportState: PipelineViewportStateCreateInfo? = null,
        var rasterizationState: PipelineRasterizationStateCreateInfo,
        var multisampleState: PipelineMultisampleStateCreateInfo? = null,
        var depthStencilState: PipelineDepthStencilStateCreateInfo? = null,
        var colorBlendState: PipelineColorBlendStateCreateInfo? = null,
        var dynamicState: PipelineDynamicStateCreateInfo? = null,
        var layout: VkPipelineLayout,
        var renderPass: VkRenderPass,
        var subpass: Int = 0,
        var basePipelineHandle: VkPipeline = VkPipeline.NULL,
        var basePipelineIndex: Int = 0,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.GRAPHICS_PIPELINE_CREATE_INFO

    fun write(stack: MemoryStack): Adr {
        val adr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
        nsType(adr, type.i)
        npNext(adr, next)
        nflags(adr, flags)
        memPutAddress(adr + PSTAGES, stages.write(stack)); nstageCount(adr, stages.size)
        vertexInputState?.let { memPutAddress(adr + PVERTEXINPUTSTATE, it.write(stack)) }
        inputAssemblyState?.let { memPutAddress(adr + PINPUTASSEMBLYSTATE, it.write(stack)) }
        tessellationState?.let { memPutAddress(adr + PTESSELLATIONSTATE, it.write(stack)) }
        viewportState?.let { memPutAddress(adr + PVIEWPORTSTATE, it.write(stack)) }
        memPutAddress(adr + PRASTERIZATIONSTATE, rasterizationState.write(stack))
        multisampleState?.let { memPutAddress(adr + PMULTISAMPLESTATE, it.write(stack)) }
        depthStencilState?.let { memPutAddress(adr + PDEPTHSTENCILSTATE, it.write(stack)) }
        colorBlendState?.let { memPutAddress(adr + PCOLORBLENDSTATE, it.write(stack)) }
        dynamicState?.let { memPutAddress(adr + PDYNAMICSTATE, it.write(stack)) }
        nlayout(adr, layout.L)
        nrenderPass(adr, renderPass.L)
        nsubpass(adr, subpass)
        nbasePipelineHandle(adr, basePipelineHandle.L)
        nbasePipelineIndex(adr, basePipelineIndex)
        return adr
    }
}