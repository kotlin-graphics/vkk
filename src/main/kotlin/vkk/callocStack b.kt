package vkk

import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.*


fun MemoryStack.ObjectTableCreateInfoNVX(): VkObjectTableCreateInfoNVX = VkObjectTableCreateInfoNVX.callocStack(this).apply { type = VkStructureType.OBJECT_TABLE_CREATE_INFO_NVX }
fun MemoryStack.ObjectTableCreateInfoNVX(block: VkObjectTableCreateInfoNVX.() -> Unit): VkObjectTableCreateInfoNVX = ObjectTableCreateInfoNVX().also(block)
fun MemoryStack.ObjectTableCreateInfoNVX(capacity: Int): VkObjectTableCreateInfoNVX.Buffer = VkObjectTableCreateInfoNVX.callocStack(capacity, this).onEach { it.type = VkStructureType.OBJECT_TABLE_CREATE_INFO_NVX }
fun MemoryStack.ObjectTableCreateInfoNVX(capacity: Int, block: VkObjectTableCreateInfoNVX.Buffer.() -> Unit): VkObjectTableCreateInfoNVX.Buffer = ObjectTableCreateInfoNVX(capacity).also(block)

fun MemoryStack.ObjectTableEntryNVX(): VkObjectTableEntryNVX = VkObjectTableEntryNVX.callocStack(this)
fun MemoryStack.ObjectTableEntryNVX(block: VkObjectTableEntryNVX.() -> Unit): VkObjectTableEntryNVX = ObjectTableEntryNVX().also(block)
fun MemoryStack.ObjectTableEntryNVX(capacity: Int): VkObjectTableEntryNVX.Buffer = VkObjectTableEntryNVX.callocStack(capacity, this)
fun MemoryStack.ObjectTableEntryNVX(capacity: Int, block: VkObjectTableEntryNVX.Buffer.() -> Unit): VkObjectTableEntryNVX.Buffer = ObjectTableEntryNVX(capacity).also(block)

fun MemoryStack.ObjectTableDescriptorSetEntryNVX(): VkObjectTableDescriptorSetEntryNVX = VkObjectTableDescriptorSetEntryNVX.callocStack(this)
fun MemoryStack.ObjectTableDescriptorSetEntryNVX(block: VkObjectTableDescriptorSetEntryNVX.() -> Unit): VkObjectTableDescriptorSetEntryNVX = ObjectTableDescriptorSetEntryNVX().also(block)
fun MemoryStack.ObjectTableDescriptorSetEntryNVX(capacity: Int): VkObjectTableDescriptorSetEntryNVX.Buffer = VkObjectTableDescriptorSetEntryNVX.callocStack(capacity, this)
fun MemoryStack.ObjectTableDescriptorSetEntryNVX(capacity: Int, block: VkObjectTableDescriptorSetEntryNVX.Buffer.() -> Unit): VkObjectTableDescriptorSetEntryNVX.Buffer = ObjectTableDescriptorSetEntryNVX(capacity).also(block)

fun MemoryStack.ObjectTableIndexBufferEntryNVX(): VkObjectTableIndexBufferEntryNVX = VkObjectTableIndexBufferEntryNVX.callocStack(this)
fun MemoryStack.ObjectTableIndexBufferEntryNVX(block: VkObjectTableIndexBufferEntryNVX.() -> Unit): VkObjectTableIndexBufferEntryNVX = ObjectTableIndexBufferEntryNVX().also(block)
fun MemoryStack.ObjectTableIndexBufferEntryNVX(capacity: Int): VkObjectTableIndexBufferEntryNVX.Buffer = VkObjectTableIndexBufferEntryNVX.callocStack(capacity, this)
fun MemoryStack.ObjectTableIndexBufferEntryNVX(capacity: Int, block: VkObjectTableIndexBufferEntryNVX.Buffer.() -> Unit): VkObjectTableIndexBufferEntryNVX.Buffer = ObjectTableIndexBufferEntryNVX(capacity).also(block)

fun MemoryStack.ObjectTablePipelineEntryNVX(): VkObjectTablePipelineEntryNVX = VkObjectTablePipelineEntryNVX.callocStack(this)
fun MemoryStack.ObjectTablePipelineEntryNVX(block: VkObjectTablePipelineEntryNVX.() -> Unit): VkObjectTablePipelineEntryNVX = ObjectTablePipelineEntryNVX().also(block)
fun MemoryStack.ObjectTablePipelineEntryNVX(capacity: Int): VkObjectTablePipelineEntryNVX.Buffer = VkObjectTablePipelineEntryNVX.callocStack(capacity, this)
fun MemoryStack.ObjectTablePipelineEntryNVX(capacity: Int, block: VkObjectTablePipelineEntryNVX.Buffer.() -> Unit): VkObjectTablePipelineEntryNVX.Buffer = ObjectTablePipelineEntryNVX(capacity).also(block)

fun MemoryStack.ObjectTablePushConstantEntryNVX(): VkObjectTablePushConstantEntryNVX = VkObjectTablePushConstantEntryNVX.callocStack(this)
fun MemoryStack.ObjectTablePushConstantEntryNVX(block: VkObjectTablePushConstantEntryNVX.() -> Unit): VkObjectTablePushConstantEntryNVX = ObjectTablePushConstantEntryNVX().also(block)
fun MemoryStack.ObjectTablePushConstantEntryNVX(capacity: Int): VkObjectTablePushConstantEntryNVX.Buffer = VkObjectTablePushConstantEntryNVX.callocStack(capacity, this)
fun MemoryStack.ObjectTablePushConstantEntryNVX(capacity: Int, block: VkObjectTablePushConstantEntryNVX.Buffer.() -> Unit): VkObjectTablePushConstantEntryNVX.Buffer = ObjectTablePushConstantEntryNVX(capacity).also(block)

fun MemoryStack.ObjectTableVertexBufferEntryNVX(): VkObjectTableVertexBufferEntryNVX = VkObjectTableVertexBufferEntryNVX.callocStack(this)
fun MemoryStack.ObjectTableVertexBufferEntryNVX(block: VkObjectTableVertexBufferEntryNVX.() -> Unit): VkObjectTableVertexBufferEntryNVX = ObjectTableVertexBufferEntryNVX().also(block)
fun MemoryStack.ObjectTableVertexBufferEntryNVX(capacity: Int): VkObjectTableVertexBufferEntryNVX.Buffer = VkObjectTableVertexBufferEntryNVX.callocStack(capacity, this)
fun MemoryStack.ObjectTableVertexBufferEntryNVX(capacity: Int, block: VkObjectTableVertexBufferEntryNVX.Buffer.() -> Unit): VkObjectTableVertexBufferEntryNVX.Buffer = ObjectTableVertexBufferEntryNVX(capacity).also(block)

fun MemoryStack.Offset2D(): VkOffset2D = VkOffset2D.callocStack(this)
fun MemoryStack.Offset2D(block: VkOffset2D.() -> Unit): VkOffset2D = Offset2D().also(block)
fun MemoryStack.Offset2D(capacity: Int): VkOffset2D.Buffer = VkOffset2D.callocStack(capacity, this)
fun MemoryStack.Offset2D(capacity: Int, block: VkOffset2D.Buffer.() -> Unit): VkOffset2D.Buffer = Offset2D(capacity).also(block)

fun MemoryStack.Offset3D(): VkOffset3D = VkOffset3D.callocStack(this)
fun MemoryStack.Offset3D(block: VkOffset3D.() -> Unit): VkOffset3D = Offset3D().also(block)
fun MemoryStack.Offset3D(capacity: Int): VkOffset3D.Buffer = VkOffset3D.callocStack(capacity, this)
fun MemoryStack.Offset3D(capacity: Int, block: VkOffset3D.Buffer.() -> Unit): VkOffset3D.Buffer = Offset3D(capacity).also(block)

fun MemoryStack.PastPresentationTimingGOOGLE(): VkPastPresentationTimingGOOGLE = VkPastPresentationTimingGOOGLE.callocStack(this)
fun MemoryStack.PastPresentationTimingGOOGLE(block: VkPastPresentationTimingGOOGLE.() -> Unit): VkPastPresentationTimingGOOGLE = PastPresentationTimingGOOGLE().also(block)
fun MemoryStack.PastPresentationTimingGOOGLE(capacity: Int): VkPastPresentationTimingGOOGLE.Buffer = VkPastPresentationTimingGOOGLE.callocStack(capacity, this)
fun MemoryStack.PastPresentationTimingGOOGLE(capacity: Int, block: VkPastPresentationTimingGOOGLE.Buffer.() -> Unit): VkPastPresentationTimingGOOGLE.Buffer = PastPresentationTimingGOOGLE(capacity).also(block)

fun MemoryStack.PhysicalDevice16BitStorageFeatures(): VkPhysicalDevice16BitStorageFeatures = VkPhysicalDevice16BitStorageFeatures.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_16BIT_STORAGE_FEATURES }
fun MemoryStack.PhysicalDevice16BitStorageFeatures(block: VkPhysicalDevice16BitStorageFeatures.() -> Unit): VkPhysicalDevice16BitStorageFeatures = PhysicalDevice16BitStorageFeatures().also(block)
fun MemoryStack.PhysicalDevice16BitStorageFeatures(capacity: Int): VkPhysicalDevice16BitStorageFeatures.Buffer = VkPhysicalDevice16BitStorageFeatures.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_16BIT_STORAGE_FEATURES }
fun MemoryStack.PhysicalDevice16BitStorageFeatures(capacity: Int, block: VkPhysicalDevice16BitStorageFeatures.Buffer.() -> Unit): VkPhysicalDevice16BitStorageFeatures.Buffer = PhysicalDevice16BitStorageFeatures(capacity).also(block)

fun MemoryStack.PhysicalDevice8BitStorageFeaturesKHR(): VkPhysicalDevice8BitStorageFeaturesKHR = VkPhysicalDevice8BitStorageFeaturesKHR.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_8BIT_STORAGE_FEATURES_KHR }
fun MemoryStack.PhysicalDevice8BitStorageFeaturesKHR(block: VkPhysicalDevice8BitStorageFeaturesKHR.() -> Unit): VkPhysicalDevice8BitStorageFeaturesKHR = PhysicalDevice8BitStorageFeaturesKHR().also(block)
fun MemoryStack.PhysicalDevice8BitStorageFeaturesKHR(capacity: Int): VkPhysicalDevice8BitStorageFeaturesKHR.Buffer = VkPhysicalDevice8BitStorageFeaturesKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_8BIT_STORAGE_FEATURES_KHR }
fun MemoryStack.PhysicalDevice8BitStorageFeaturesKHR(capacity: Int, block: VkPhysicalDevice8BitStorageFeaturesKHR.Buffer.() -> Unit): VkPhysicalDevice8BitStorageFeaturesKHR.Buffer = PhysicalDevice8BitStorageFeaturesKHR(capacity).also(block)

fun MemoryStack.PhysicalDeviceASTCDecodeFeaturesEXT(): VkPhysicalDeviceASTCDecodeFeaturesEXT = VkPhysicalDeviceASTCDecodeFeaturesEXT.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_ASTC_DECODE_FEATURES_EXT }
fun MemoryStack.PhysicalDeviceASTCDecodeFeaturesEXT(block: VkPhysicalDeviceASTCDecodeFeaturesEXT.() -> Unit): VkPhysicalDeviceASTCDecodeFeaturesEXT = PhysicalDeviceASTCDecodeFeaturesEXT().also(block)
fun MemoryStack.PhysicalDeviceASTCDecodeFeaturesEXT(capacity: Int): VkPhysicalDeviceASTCDecodeFeaturesEXT.Buffer = VkPhysicalDeviceASTCDecodeFeaturesEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_ASTC_DECODE_FEATURES_EXT }
fun MemoryStack.PhysicalDeviceASTCDecodeFeaturesEXT(capacity: Int, block: VkPhysicalDeviceASTCDecodeFeaturesEXT.Buffer.() -> Unit): VkPhysicalDeviceASTCDecodeFeaturesEXT.Buffer = PhysicalDeviceASTCDecodeFeaturesEXT(capacity).also(block)

fun MemoryStack.PhysicalDeviceBlendOperationAdvancedFeaturesEXT(): VkPhysicalDeviceBlendOperationAdvancedFeaturesEXT = VkPhysicalDeviceBlendOperationAdvancedFeaturesEXT.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_BLEND_OPERATION_ADVANCED_FEATURES_EXT }
fun MemoryStack.PhysicalDeviceBlendOperationAdvancedFeaturesEXT(block: VkPhysicalDeviceBlendOperationAdvancedFeaturesEXT.() -> Unit): VkPhysicalDeviceBlendOperationAdvancedFeaturesEXT = PhysicalDeviceBlendOperationAdvancedFeaturesEXT().also(block)
fun MemoryStack.PhysicalDeviceBlendOperationAdvancedFeaturesEXT(capacity: Int): VkPhysicalDeviceBlendOperationAdvancedFeaturesEXT.Buffer = VkPhysicalDeviceBlendOperationAdvancedFeaturesEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_BLEND_OPERATION_ADVANCED_FEATURES_EXT }
fun MemoryStack.PhysicalDeviceBlendOperationAdvancedFeaturesEXT(capacity: Int, block: VkPhysicalDeviceBlendOperationAdvancedFeaturesEXT.Buffer.() -> Unit): VkPhysicalDeviceBlendOperationAdvancedFeaturesEXT.Buffer = PhysicalDeviceBlendOperationAdvancedFeaturesEXT(capacity).also(block)

fun MemoryStack.PhysicalDeviceBlendOperationAdvancedPropertiesEXT(): VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT = VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_BLEND_OPERATION_ADVANCED_PROPERTIES_EXT }
fun MemoryStack.PhysicalDeviceBlendOperationAdvancedPropertiesEXT(block: VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.() -> Unit): VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT = PhysicalDeviceBlendOperationAdvancedPropertiesEXT().also(block)
fun MemoryStack.PhysicalDeviceBlendOperationAdvancedPropertiesEXT(capacity: Int): VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.Buffer = VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_BLEND_OPERATION_ADVANCED_PROPERTIES_EXT }
fun MemoryStack.PhysicalDeviceBlendOperationAdvancedPropertiesEXT(capacity: Int, block: VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.Buffer.() -> Unit): VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.Buffer = PhysicalDeviceBlendOperationAdvancedPropertiesEXT(capacity).also(block)

fun MemoryStack.PhysicalDeviceBufferDeviceAddressFeaturesEXT (): VkPhysicalDeviceBufferDeviceAddressFeaturesEXT  = VkPhysicalDeviceBufferDeviceAddressFeaturesEXT .callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_BUFFER_ADDRESS_FEATURES_EXT }
fun MemoryStack.PhysicalDeviceBufferDeviceAddressFeaturesEXT (block: VkPhysicalDeviceBufferDeviceAddressFeaturesEXT .() -> Unit): VkPhysicalDeviceBufferDeviceAddressFeaturesEXT  = PhysicalDeviceBufferDeviceAddressFeaturesEXT ().also(block)
fun MemoryStack.PhysicalDeviceBufferDeviceAddressFeaturesEXT (capacity: Int): VkPhysicalDeviceBufferDeviceAddressFeaturesEXT .Buffer = VkPhysicalDeviceBufferDeviceAddressFeaturesEXT .callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_BUFFER_ADDRESS_FEATURES_EXT }
fun MemoryStack.PhysicalDeviceBufferDeviceAddressFeaturesEXT (capacity: Int, block: VkPhysicalDeviceBufferDeviceAddressFeaturesEXT .Buffer.() -> Unit): VkPhysicalDeviceBufferDeviceAddressFeaturesEXT .Buffer = PhysicalDeviceBufferDeviceAddressFeaturesEXT (capacity).also(block)

fun MemoryStack.PhysicalDeviceConditionalRenderingFeaturesEXT(): VkPhysicalDeviceConditionalRenderingFeaturesEXT = VkPhysicalDeviceConditionalRenderingFeaturesEXT.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_CONDITIONAL_RENDERING_FEATURES_EXT }
fun MemoryStack.PhysicalDeviceConditionalRenderingFeaturesEXT(block: VkPhysicalDeviceConditionalRenderingFeaturesEXT.() -> Unit): VkPhysicalDeviceConditionalRenderingFeaturesEXT = PhysicalDeviceConditionalRenderingFeaturesEXT().also(block)
fun MemoryStack.PhysicalDeviceConditionalRenderingFeaturesEXT(capacity: Int): VkPhysicalDeviceConditionalRenderingFeaturesEXT.Buffer = VkPhysicalDeviceConditionalRenderingFeaturesEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_CONDITIONAL_RENDERING_FEATURES_EXT }
fun MemoryStack.PhysicalDeviceConditionalRenderingFeaturesEXT(capacity: Int, block: VkPhysicalDeviceConditionalRenderingFeaturesEXT.Buffer.() -> Unit): VkPhysicalDeviceConditionalRenderingFeaturesEXT.Buffer = PhysicalDeviceConditionalRenderingFeaturesEXT(capacity).also(block)

fun MemoryStack.PhysicalDeviceComputeShaderDerivativesFeaturesNV(): VkPhysicalDeviceComputeShaderDerivativesFeaturesNV = VkPhysicalDeviceComputeShaderDerivativesFeaturesNV.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_COMPUTE_SHADER_DERIVATIVES_FEATURES_NV }
fun MemoryStack.PhysicalDeviceComputeShaderDerivativesFeaturesNV(block: VkPhysicalDeviceComputeShaderDerivativesFeaturesNV.() -> Unit): VkPhysicalDeviceComputeShaderDerivativesFeaturesNV = PhysicalDeviceComputeShaderDerivativesFeaturesNV().also(block)
fun MemoryStack.PhysicalDeviceComputeShaderDerivativesFeaturesNV(capacity: Int): VkPhysicalDeviceComputeShaderDerivativesFeaturesNV.Buffer = VkPhysicalDeviceComputeShaderDerivativesFeaturesNV.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_COMPUTE_SHADER_DERIVATIVES_FEATURES_NV }
fun MemoryStack.PhysicalDeviceComputeShaderDerivativesFeaturesNV(capacity: Int, block: VkPhysicalDeviceComputeShaderDerivativesFeaturesNV.Buffer.() -> Unit): VkPhysicalDeviceComputeShaderDerivativesFeaturesNV.Buffer = PhysicalDeviceComputeShaderDerivativesFeaturesNV(capacity).also(block)

fun MemoryStack.PhysicalDeviceConservativeRasterizationPropertiesEXT(): VkPhysicalDeviceConservativeRasterizationPropertiesEXT = VkPhysicalDeviceConservativeRasterizationPropertiesEXT.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_CONSERVATIVE_RASTERIZATION_PROPERTIES_EXT }
fun MemoryStack.PhysicalDeviceConservativeRasterizationPropertiesEXT(block: VkPhysicalDeviceConservativeRasterizationPropertiesEXT.() -> Unit): VkPhysicalDeviceConservativeRasterizationPropertiesEXT = PhysicalDeviceConservativeRasterizationPropertiesEXT().also(block)
fun MemoryStack.PhysicalDeviceConservativeRasterizationPropertiesEXT(capacity: Int): VkPhysicalDeviceConservativeRasterizationPropertiesEXT.Buffer = VkPhysicalDeviceConservativeRasterizationPropertiesEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_CONSERVATIVE_RASTERIZATION_PROPERTIES_EXT }
fun MemoryStack.PhysicalDeviceConservativeRasterizationPropertiesEXT(capacity: Int, block: VkPhysicalDeviceConservativeRasterizationPropertiesEXT.Buffer.() -> Unit): VkPhysicalDeviceConservativeRasterizationPropertiesEXT.Buffer = PhysicalDeviceConservativeRasterizationPropertiesEXT(capacity).also(block)

fun MemoryStack.PhysicalDeviceCooperativeMatrixFeaturesNV(): VkPhysicalDeviceCooperativeMatrixFeaturesNV = VkPhysicalDeviceCooperativeMatrixFeaturesNV.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_COOPERATIVE_MATRIX_FEATURES_NV }
fun MemoryStack.PhysicalDeviceCooperativeMatrixFeaturesNV(block: VkPhysicalDeviceCooperativeMatrixFeaturesNV.() -> Unit): VkPhysicalDeviceCooperativeMatrixFeaturesNV = PhysicalDeviceCooperativeMatrixFeaturesNV().also(block)
fun MemoryStack.PhysicalDeviceCooperativeMatrixFeaturesNV(capacity: Int): VkPhysicalDeviceCooperativeMatrixFeaturesNV.Buffer = VkPhysicalDeviceCooperativeMatrixFeaturesNV.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_COOPERATIVE_MATRIX_FEATURES_NV }
fun MemoryStack.PhysicalDeviceCooperativeMatrixFeaturesNV(capacity: Int, block: VkPhysicalDeviceCooperativeMatrixFeaturesNV.Buffer.() -> Unit): VkPhysicalDeviceCooperativeMatrixFeaturesNV.Buffer = PhysicalDeviceCooperativeMatrixFeaturesNV(capacity).also(block)

fun MemoryStack.PhysicalDeviceCooperativeMatrixPropertiesNV(): VkPhysicalDeviceCooperativeMatrixPropertiesNV = VkPhysicalDeviceCooperativeMatrixPropertiesNV.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_COOPERATIVE_MATRIX_PROPERTIES_NV }
fun MemoryStack.PhysicalDeviceCooperativeMatrixPropertiesNV(block: VkPhysicalDeviceCooperativeMatrixPropertiesNV.() -> Unit): VkPhysicalDeviceCooperativeMatrixPropertiesNV = PhysicalDeviceCooperativeMatrixPropertiesNV().also(block)
fun MemoryStack.PhysicalDeviceCooperativeMatrixPropertiesNV(capacity: Int): VkPhysicalDeviceCooperativeMatrixPropertiesNV.Buffer = VkPhysicalDeviceCooperativeMatrixPropertiesNV.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_COOPERATIVE_MATRIX_PROPERTIES_NV }
fun MemoryStack.PhysicalDeviceCooperativeMatrixPropertiesNV(capacity: Int, block: VkPhysicalDeviceCooperativeMatrixPropertiesNV.Buffer.() -> Unit): VkPhysicalDeviceCooperativeMatrixPropertiesNV.Buffer = PhysicalDeviceCooperativeMatrixPropertiesNV(capacity).also(block)

fun MemoryStack.PhysicalDeviceCornerSampledImageFeaturesNV(): VkPhysicalDeviceCornerSampledImageFeaturesNV = VkPhysicalDeviceCornerSampledImageFeaturesNV.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_CORNER_SAMPLED_IMAGE_FEATURES_NV }
fun MemoryStack.PhysicalDeviceCornerSampledImageFeaturesNV(block: VkPhysicalDeviceCornerSampledImageFeaturesNV.() -> Unit): VkPhysicalDeviceCornerSampledImageFeaturesNV = PhysicalDeviceCornerSampledImageFeaturesNV().also(block)
fun MemoryStack.PhysicalDeviceCornerSampledImageFeaturesNV(capacity: Int): VkPhysicalDeviceCornerSampledImageFeaturesNV.Buffer = VkPhysicalDeviceCornerSampledImageFeaturesNV.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_CORNER_SAMPLED_IMAGE_FEATURES_NV }
fun MemoryStack.PhysicalDeviceCornerSampledImageFeaturesNV(capacity: Int, block: VkPhysicalDeviceCornerSampledImageFeaturesNV.Buffer.() -> Unit): VkPhysicalDeviceCornerSampledImageFeaturesNV.Buffer = PhysicalDeviceCornerSampledImageFeaturesNV(capacity).also(block)

fun MemoryStack.PhysicalDeviceDedicatedAllocationImageAliasingFeaturesNV(): VkPhysicalDeviceDedicatedAllocationImageAliasingFeaturesNV = VkPhysicalDeviceDedicatedAllocationImageAliasingFeaturesNV.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_DEDICATED_ALLOCATION_IMAGE_ALIASING_FEATURES_NV }
fun MemoryStack.PhysicalDeviceDedicatedAllocationImageAliasingFeaturesNV(block: VkPhysicalDeviceDedicatedAllocationImageAliasingFeaturesNV.() -> Unit): VkPhysicalDeviceDedicatedAllocationImageAliasingFeaturesNV = PhysicalDeviceDedicatedAllocationImageAliasingFeaturesNV().also(block)
fun MemoryStack.PhysicalDeviceDedicatedAllocationImageAliasingFeaturesNV(capacity: Int): VkPhysicalDeviceDedicatedAllocationImageAliasingFeaturesNV.Buffer = VkPhysicalDeviceDedicatedAllocationImageAliasingFeaturesNV.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_DEDICATED_ALLOCATION_IMAGE_ALIASING_FEATURES_NV }
fun MemoryStack.PhysicalDeviceDedicatedAllocationImageAliasingFeaturesNV(capacity: Int, block: VkPhysicalDeviceDedicatedAllocationImageAliasingFeaturesNV.Buffer.() -> Unit): VkPhysicalDeviceDedicatedAllocationImageAliasingFeaturesNV.Buffer = PhysicalDeviceDedicatedAllocationImageAliasingFeaturesNV(capacity).also(block)

fun MemoryStack.PhysicalDeviceDepthClipEnableFeaturesEXT(): VkPhysicalDeviceDepthClipEnableFeaturesEXT = VkPhysicalDeviceDepthClipEnableFeaturesEXT.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_DEPTH_CLIP_ENABLE_FEATURES_EXT }
fun MemoryStack.PhysicalDeviceDepthClipEnableFeaturesEXT(block: VkPhysicalDeviceDepthClipEnableFeaturesEXT.() -> Unit): VkPhysicalDeviceDepthClipEnableFeaturesEXT = PhysicalDeviceDepthClipEnableFeaturesEXT().also(block)
fun MemoryStack.PhysicalDeviceDepthClipEnableFeaturesEXT(capacity: Int): VkPhysicalDeviceDepthClipEnableFeaturesEXT.Buffer = VkPhysicalDeviceDepthClipEnableFeaturesEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_DEPTH_CLIP_ENABLE_FEATURES_EXT }
fun MemoryStack.PhysicalDeviceDepthClipEnableFeaturesEXT(capacity: Int, block: VkPhysicalDeviceDepthClipEnableFeaturesEXT.Buffer.() -> Unit): VkPhysicalDeviceDepthClipEnableFeaturesEXT.Buffer = PhysicalDeviceDepthClipEnableFeaturesEXT(capacity).also(block)

fun MemoryStack.PhysicalDeviceDepthStencilResolvePropertiesKHR(): VkPhysicalDeviceDepthStencilResolvePropertiesKHR = VkPhysicalDeviceDepthStencilResolvePropertiesKHR.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_DEPTH_STENCIL_RESOLVE_PROPERTIES_KHR }
fun MemoryStack.PhysicalDeviceDepthStencilResolvePropertiesKHR(block: VkPhysicalDeviceDepthStencilResolvePropertiesKHR.() -> Unit): VkPhysicalDeviceDepthStencilResolvePropertiesKHR = PhysicalDeviceDepthStencilResolvePropertiesKHR().also(block)
fun MemoryStack.PhysicalDeviceDepthStencilResolvePropertiesKHR(capacity: Int): VkPhysicalDeviceDepthStencilResolvePropertiesKHR.Buffer = VkPhysicalDeviceDepthStencilResolvePropertiesKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_DEPTH_STENCIL_RESOLVE_PROPERTIES_KHR }
fun MemoryStack.PhysicalDeviceDepthStencilResolvePropertiesKHR(capacity: Int, block: VkPhysicalDeviceDepthStencilResolvePropertiesKHR.Buffer.() -> Unit): VkPhysicalDeviceDepthStencilResolvePropertiesKHR.Buffer = PhysicalDeviceDepthStencilResolvePropertiesKHR(capacity).also(block)

fun MemoryStack.PhysicalDeviceDescriptorIndexingFeaturesEXT(): VkPhysicalDeviceDescriptorIndexingFeaturesEXT = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_DESCRIPTOR_INDEXING_FEATURES_EXT }
fun MemoryStack.PhysicalDeviceDescriptorIndexingFeaturesEXT(block: VkPhysicalDeviceDescriptorIndexingFeaturesEXT.() -> Unit): VkPhysicalDeviceDescriptorIndexingFeaturesEXT = PhysicalDeviceDescriptorIndexingFeaturesEXT().also(block)
fun MemoryStack.PhysicalDeviceDescriptorIndexingFeaturesEXT(capacity: Int): VkPhysicalDeviceDescriptorIndexingFeaturesEXT.Buffer = VkPhysicalDeviceDescriptorIndexingFeaturesEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_DESCRIPTOR_INDEXING_FEATURES_EXT }
fun MemoryStack.PhysicalDeviceDescriptorIndexingFeaturesEXT(capacity: Int, block: VkPhysicalDeviceDescriptorIndexingFeaturesEXT.Buffer.() -> Unit): VkPhysicalDeviceDescriptorIndexingFeaturesEXT.Buffer = PhysicalDeviceDescriptorIndexingFeaturesEXT(capacity).also(block)

fun MemoryStack.PhysicalDeviceDescriptorIndexingPropertiesEXT(): VkPhysicalDeviceDescriptorIndexingPropertiesEXT = VkPhysicalDeviceDescriptorIndexingPropertiesEXT.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_DESCRIPTOR_INDEXING_PROPERTIES_EXT }
fun MemoryStack.PhysicalDeviceDescriptorIndexingPropertiesEXT(block: VkPhysicalDeviceDescriptorIndexingPropertiesEXT.() -> Unit): VkPhysicalDeviceDescriptorIndexingPropertiesEXT = PhysicalDeviceDescriptorIndexingPropertiesEXT().also(block)
fun MemoryStack.PhysicalDeviceDescriptorIndexingPropertiesEXT(capacity: Int): VkPhysicalDeviceDescriptorIndexingPropertiesEXT.Buffer = VkPhysicalDeviceDescriptorIndexingPropertiesEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_DESCRIPTOR_INDEXING_PROPERTIES_EXT }
fun MemoryStack.PhysicalDeviceDescriptorIndexingPropertiesEXT(capacity: Int, block: VkPhysicalDeviceDescriptorIndexingPropertiesEXT.Buffer.() -> Unit): VkPhysicalDeviceDescriptorIndexingPropertiesEXT.Buffer = PhysicalDeviceDescriptorIndexingPropertiesEXT(capacity).also(block)

fun MemoryStack.PhysicalDeviceDiscardRectanglePropertiesEXT(): VkPhysicalDeviceDiscardRectanglePropertiesEXT = VkPhysicalDeviceDiscardRectanglePropertiesEXT.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_DISCARD_RECTANGLE_PROPERTIES_EXT }
fun MemoryStack.PhysicalDeviceDiscardRectanglePropertiesEXT(block: VkPhysicalDeviceDiscardRectanglePropertiesEXT.() -> Unit): VkPhysicalDeviceDiscardRectanglePropertiesEXT = PhysicalDeviceDiscardRectanglePropertiesEXT().also(block)
fun MemoryStack.PhysicalDeviceDiscardRectanglePropertiesEXT(capacity: Int): VkPhysicalDeviceDiscardRectanglePropertiesEXT.Buffer = VkPhysicalDeviceDiscardRectanglePropertiesEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_DISCARD_RECTANGLE_PROPERTIES_EXT }
fun MemoryStack.PhysicalDeviceDiscardRectanglePropertiesEXT(capacity: Int, block: VkPhysicalDeviceDiscardRectanglePropertiesEXT.Buffer.() -> Unit): VkPhysicalDeviceDiscardRectanglePropertiesEXT.Buffer = PhysicalDeviceDiscardRectanglePropertiesEXT(capacity).also(block)

fun MemoryStack.PhysicalDeviceDriverPropertiesKHR(): VkPhysicalDeviceDriverPropertiesKHR = VkPhysicalDeviceDriverPropertiesKHR.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_DRIVER_PROPERTIES_KHR }
fun MemoryStack.PhysicalDeviceDriverPropertiesKHR(block: VkPhysicalDeviceDriverPropertiesKHR.() -> Unit): VkPhysicalDeviceDriverPropertiesKHR = PhysicalDeviceDriverPropertiesKHR().also(block)
fun MemoryStack.PhysicalDeviceDriverPropertiesKHR(capacity: Int): VkPhysicalDeviceDriverPropertiesKHR.Buffer = VkPhysicalDeviceDriverPropertiesKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_DRIVER_PROPERTIES_KHR }
fun MemoryStack.PhysicalDeviceDriverPropertiesKHR(capacity: Int, block: VkPhysicalDeviceDriverPropertiesKHR.Buffer.() -> Unit): VkPhysicalDeviceDriverPropertiesKHR.Buffer = PhysicalDeviceDriverPropertiesKHR(capacity).also(block)

fun MemoryStack.PhysicalDeviceExclusiveScissorFeaturesNV(): VkPhysicalDeviceExclusiveScissorFeaturesNV = VkPhysicalDeviceExclusiveScissorFeaturesNV.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_EXCLUSIVE_SCISSOR_FEATURES_NV }
fun MemoryStack.PhysicalDeviceExclusiveScissorFeaturesNV(block: VkPhysicalDeviceExclusiveScissorFeaturesNV.() -> Unit): VkPhysicalDeviceExclusiveScissorFeaturesNV = PhysicalDeviceExclusiveScissorFeaturesNV().also(block)
fun MemoryStack.PhysicalDeviceExclusiveScissorFeaturesNV(capacity: Int): VkPhysicalDeviceExclusiveScissorFeaturesNV.Buffer = VkPhysicalDeviceExclusiveScissorFeaturesNV.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_EXCLUSIVE_SCISSOR_FEATURES_NV }
fun MemoryStack.PhysicalDeviceExclusiveScissorFeaturesNV(capacity: Int, block: VkPhysicalDeviceExclusiveScissorFeaturesNV.Buffer.() -> Unit): VkPhysicalDeviceExclusiveScissorFeaturesNV.Buffer = PhysicalDeviceExclusiveScissorFeaturesNV(capacity).also(block)

fun MemoryStack.PhysicalDeviceExternalBufferInfo(): VkPhysicalDeviceExternalBufferInfo = VkPhysicalDeviceExternalBufferInfo.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_EXTERNAL_BUFFER_INFO }
fun MemoryStack.PhysicalDeviceExternalBufferInfo(block: VkPhysicalDeviceExternalBufferInfo.() -> Unit): VkPhysicalDeviceExternalBufferInfo = PhysicalDeviceExternalBufferInfo().also(block)
fun MemoryStack.PhysicalDeviceExternalBufferInfo(capacity: Int): VkPhysicalDeviceExternalBufferInfo.Buffer = VkPhysicalDeviceExternalBufferInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_EXTERNAL_BUFFER_INFO }
fun MemoryStack.PhysicalDeviceExternalBufferInfo(capacity: Int, block: VkPhysicalDeviceExternalBufferInfo.Buffer.() -> Unit): VkPhysicalDeviceExternalBufferInfo.Buffer = PhysicalDeviceExternalBufferInfo(capacity).also(block)

fun MemoryStack.PhysicalDeviceExternalFenceInfo(): VkPhysicalDeviceExternalFenceInfo = VkPhysicalDeviceExternalFenceInfo.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_EXTERNAL_FENCE_INFO }
fun MemoryStack.PhysicalDeviceExternalFenceInfo(block: VkPhysicalDeviceExternalFenceInfo.() -> Unit): VkPhysicalDeviceExternalFenceInfo = PhysicalDeviceExternalFenceInfo().also(block)
fun MemoryStack.PhysicalDeviceExternalFenceInfo(capacity: Int): VkPhysicalDeviceExternalFenceInfo.Buffer = VkPhysicalDeviceExternalFenceInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_EXTERNAL_FENCE_INFO }
fun MemoryStack.PhysicalDeviceExternalFenceInfo(capacity: Int, block: VkPhysicalDeviceExternalFenceInfo.Buffer.() -> Unit): VkPhysicalDeviceExternalFenceInfo.Buffer = PhysicalDeviceExternalFenceInfo(capacity).also(block)

fun MemoryStack.PhysicalDeviceExternalImageFormatInfo(): VkPhysicalDeviceExternalImageFormatInfo = VkPhysicalDeviceExternalImageFormatInfo.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_EXTERNAL_IMAGE_FORMAT_INFO }
fun MemoryStack.PhysicalDeviceExternalImageFormatInfo(block: VkPhysicalDeviceExternalImageFormatInfo.() -> Unit): VkPhysicalDeviceExternalImageFormatInfo = PhysicalDeviceExternalImageFormatInfo().also(block)
fun MemoryStack.PhysicalDeviceExternalImageFormatInfo(capacity: Int): VkPhysicalDeviceExternalImageFormatInfo.Buffer = VkPhysicalDeviceExternalImageFormatInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_EXTERNAL_IMAGE_FORMAT_INFO }
fun MemoryStack.PhysicalDeviceExternalImageFormatInfo(capacity: Int, block: VkPhysicalDeviceExternalImageFormatInfo.Buffer.() -> Unit): VkPhysicalDeviceExternalImageFormatInfo.Buffer = PhysicalDeviceExternalImageFormatInfo(capacity).also(block)

fun MemoryStack.PhysicalDeviceExternalMemoryHostPropertiesEXT(): VkPhysicalDeviceExternalMemoryHostPropertiesEXT = VkPhysicalDeviceExternalMemoryHostPropertiesEXT.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_EXTERNAL_MEMORY_HOST_PROPERTIES_EXT }
fun MemoryStack.PhysicalDeviceExternalMemoryHostPropertiesEXT(block: VkPhysicalDeviceExternalMemoryHostPropertiesEXT.() -> Unit): VkPhysicalDeviceExternalMemoryHostPropertiesEXT = PhysicalDeviceExternalMemoryHostPropertiesEXT().also(block)
fun MemoryStack.PhysicalDeviceExternalMemoryHostPropertiesEXT(capacity: Int): VkPhysicalDeviceExternalMemoryHostPropertiesEXT.Buffer = VkPhysicalDeviceExternalMemoryHostPropertiesEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_EXTERNAL_MEMORY_HOST_PROPERTIES_EXT }
fun MemoryStack.PhysicalDeviceExternalMemoryHostPropertiesEXT(capacity: Int, block: VkPhysicalDeviceExternalMemoryHostPropertiesEXT.Buffer.() -> Unit): VkPhysicalDeviceExternalMemoryHostPropertiesEXT.Buffer = PhysicalDeviceExternalMemoryHostPropertiesEXT(capacity).also(block)

fun MemoryStack.PhysicalDeviceExternalSemaphoreInfo(): VkPhysicalDeviceExternalSemaphoreInfo = VkPhysicalDeviceExternalSemaphoreInfo.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_EXTERNAL_SEMAPHORE_INFO }
fun MemoryStack.PhysicalDeviceExternalSemaphoreInfo(block: VkPhysicalDeviceExternalSemaphoreInfo.() -> Unit): VkPhysicalDeviceExternalSemaphoreInfo = PhysicalDeviceExternalSemaphoreInfo().also(block)
fun MemoryStack.PhysicalDeviceExternalSemaphoreInfo(capacity: Int): VkPhysicalDeviceExternalSemaphoreInfo.Buffer = VkPhysicalDeviceExternalSemaphoreInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_EXTERNAL_SEMAPHORE_INFO }
fun MemoryStack.PhysicalDeviceExternalSemaphoreInfo(capacity: Int, block: VkPhysicalDeviceExternalSemaphoreInfo.Buffer.() -> Unit): VkPhysicalDeviceExternalSemaphoreInfo.Buffer = PhysicalDeviceExternalSemaphoreInfo(capacity).also(block)

fun MemoryStack.PhysicalDeviceFeatures(): VkPhysicalDeviceFeatures = VkPhysicalDeviceFeatures.callocStack(this)
fun MemoryStack.PhysicalDeviceFeatures(block: VkPhysicalDeviceFeatures.() -> Unit): VkPhysicalDeviceFeatures = PhysicalDeviceFeatures().also(block)
fun MemoryStack.PhysicalDeviceFeatures(capacity: Int): VkPhysicalDeviceFeatures.Buffer = VkPhysicalDeviceFeatures.callocStack(capacity, this)
fun MemoryStack.PhysicalDeviceFeatures(capacity: Int, block: VkPhysicalDeviceFeatures.Buffer.() -> Unit): VkPhysicalDeviceFeatures.Buffer = PhysicalDeviceFeatures(capacity).also(block)

fun MemoryStack.PhysicalDeviceFeatures2(): VkPhysicalDeviceFeatures2 = VkPhysicalDeviceFeatures2.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_FEATURES_2 }
fun MemoryStack.PhysicalDeviceFeatures2(block: VkPhysicalDeviceFeatures2.() -> Unit): VkPhysicalDeviceFeatures2 = PhysicalDeviceFeatures2().also(block)
fun MemoryStack.PhysicalDeviceFeatures2(capacity: Int): VkPhysicalDeviceFeatures2.Buffer = VkPhysicalDeviceFeatures2.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_FEATURES_2 }
fun MemoryStack.PhysicalDeviceFeatures2(capacity: Int, block: VkPhysicalDeviceFeatures2.Buffer.() -> Unit): VkPhysicalDeviceFeatures2.Buffer = PhysicalDeviceFeatures2(capacity).also(block)

fun MemoryStack.PhysicalDeviceFloat16Int8FeaturesKHR(): VkPhysicalDeviceFloat16Int8FeaturesKHR = VkPhysicalDeviceFloat16Int8FeaturesKHR.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_FLOAT16_INT8_FEATURES_KHR }
fun MemoryStack.PhysicalDeviceFloat16Int8FeaturesKHR(block: VkPhysicalDeviceFloat16Int8FeaturesKHR.() -> Unit): VkPhysicalDeviceFloat16Int8FeaturesKHR = PhysicalDeviceFloat16Int8FeaturesKHR().also(block)
fun MemoryStack.PhysicalDeviceFloat16Int8FeaturesKHR(capacity: Int): VkPhysicalDeviceFloat16Int8FeaturesKHR.Buffer = VkPhysicalDeviceFloat16Int8FeaturesKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_FLOAT16_INT8_FEATURES_KHR }
fun MemoryStack.PhysicalDeviceFloat16Int8FeaturesKHR(capacity: Int, block: VkPhysicalDeviceFloat16Int8FeaturesKHR.Buffer.() -> Unit): VkPhysicalDeviceFloat16Int8FeaturesKHR.Buffer = PhysicalDeviceFloat16Int8FeaturesKHR(capacity).also(block)

fun MemoryStack.PhysicalDeviceFloatControlsPropertiesKHR(): VkPhysicalDeviceFloatControlsPropertiesKHR = VkPhysicalDeviceFloatControlsPropertiesKHR.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_FLOAT_CONTROLS_PROPERTIES_KHR }
fun MemoryStack.PhysicalDeviceFloatControlsPropertiesKHR(block: VkPhysicalDeviceFloatControlsPropertiesKHR.() -> Unit): VkPhysicalDeviceFloatControlsPropertiesKHR = PhysicalDeviceFloatControlsPropertiesKHR().also(block)
fun MemoryStack.PhysicalDeviceFloatControlsPropertiesKHR(capacity: Int): VkPhysicalDeviceFloatControlsPropertiesKHR.Buffer = VkPhysicalDeviceFloatControlsPropertiesKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_FLOAT_CONTROLS_PROPERTIES_KHR }
fun MemoryStack.PhysicalDeviceFloatControlsPropertiesKHR(capacity: Int, block: VkPhysicalDeviceFloatControlsPropertiesKHR.Buffer.() -> Unit): VkPhysicalDeviceFloatControlsPropertiesKHR.Buffer = PhysicalDeviceFloatControlsPropertiesKHR(capacity).also(block)

fun MemoryStack.PhysicalDeviceFragmentDensityMapFeaturesEXT(): VkPhysicalDeviceFragmentDensityMapFeaturesEXT = VkPhysicalDeviceFragmentDensityMapFeaturesEXT.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_FRAGMENT_DENSITY_MAP_FEATURES_EXT }
fun MemoryStack.PhysicalDeviceFragmentDensityMapFeaturesEXT(block: VkPhysicalDeviceFragmentDensityMapFeaturesEXT.() -> Unit): VkPhysicalDeviceFragmentDensityMapFeaturesEXT = PhysicalDeviceFragmentDensityMapFeaturesEXT().also(block)
fun MemoryStack.PhysicalDeviceFragmentDensityMapFeaturesEXT(capacity: Int): VkPhysicalDeviceFragmentDensityMapFeaturesEXT.Buffer = VkPhysicalDeviceFragmentDensityMapFeaturesEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_FRAGMENT_DENSITY_MAP_FEATURES_EXT }
fun MemoryStack.PhysicalDeviceFragmentDensityMapFeaturesEXT(capacity: Int, block: VkPhysicalDeviceFragmentDensityMapFeaturesEXT.Buffer.() -> Unit): VkPhysicalDeviceFragmentDensityMapFeaturesEXT.Buffer = PhysicalDeviceFragmentDensityMapFeaturesEXT(capacity).also(block)

fun MemoryStack.PhysicalDeviceFragmentDensityMapPropertiesEXT(): VkPhysicalDeviceFragmentDensityMapPropertiesEXT = VkPhysicalDeviceFragmentDensityMapPropertiesEXT.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_FRAGMENT_DENSITY_MAP_PROPERTIES_EXT }
fun MemoryStack.PhysicalDeviceFragmentDensityMapPropertiesEXT(block: VkPhysicalDeviceFragmentDensityMapPropertiesEXT.() -> Unit): VkPhysicalDeviceFragmentDensityMapPropertiesEXT = PhysicalDeviceFragmentDensityMapPropertiesEXT().also(block)
fun MemoryStack.PhysicalDeviceFragmentDensityMapPropertiesEXT(capacity: Int): VkPhysicalDeviceFragmentDensityMapPropertiesEXT.Buffer = VkPhysicalDeviceFragmentDensityMapPropertiesEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_FRAGMENT_DENSITY_MAP_PROPERTIES_EXT }
fun MemoryStack.PhysicalDeviceFragmentDensityMapPropertiesEXT(capacity: Int, block: VkPhysicalDeviceFragmentDensityMapPropertiesEXT.Buffer.() -> Unit): VkPhysicalDeviceFragmentDensityMapPropertiesEXT.Buffer = PhysicalDeviceFragmentDensityMapPropertiesEXT(capacity).also(block)

fun MemoryStack.PhysicalDeviceFragmentShaderBarycentricFeaturesNV(): VkPhysicalDeviceFragmentShaderBarycentricFeaturesNV = VkPhysicalDeviceFragmentShaderBarycentricFeaturesNV.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_FRAGMENT_SHADER_BARYCENTRIC_FEATURES_NV }
fun MemoryStack.PhysicalDeviceFragmentShaderBarycentricFeaturesNV(block: VkPhysicalDeviceFragmentShaderBarycentricFeaturesNV.() -> Unit): VkPhysicalDeviceFragmentShaderBarycentricFeaturesNV = PhysicalDeviceFragmentShaderBarycentricFeaturesNV().also(block)
fun MemoryStack.PhysicalDeviceFragmentShaderBarycentricFeaturesNV(capacity: Int): VkPhysicalDeviceFragmentShaderBarycentricFeaturesNV.Buffer = VkPhysicalDeviceFragmentShaderBarycentricFeaturesNV.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_FRAGMENT_SHADER_BARYCENTRIC_FEATURES_NV }
fun MemoryStack.PhysicalDeviceFragmentShaderBarycentricFeaturesNV(capacity: Int, block: VkPhysicalDeviceFragmentShaderBarycentricFeaturesNV.Buffer.() -> Unit): VkPhysicalDeviceFragmentShaderBarycentricFeaturesNV.Buffer = PhysicalDeviceFragmentShaderBarycentricFeaturesNV(capacity).also(block)

fun MemoryStack.PhysicalDeviceGroupProperties(): VkPhysicalDeviceGroupProperties = VkPhysicalDeviceGroupProperties.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_GROUP_PROPERTIES }
fun MemoryStack.PhysicalDeviceGroupProperties(block: VkPhysicalDeviceGroupProperties.() -> Unit): VkPhysicalDeviceGroupProperties = PhysicalDeviceGroupProperties().also(block)
fun MemoryStack.PhysicalDeviceGroupProperties(capacity: Int): VkPhysicalDeviceGroupProperties.Buffer = VkPhysicalDeviceGroupProperties.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_GROUP_PROPERTIES }
fun MemoryStack.PhysicalDeviceGroupProperties(capacity: Int, block: VkPhysicalDeviceGroupProperties.Buffer.() -> Unit): VkPhysicalDeviceGroupProperties.Buffer = PhysicalDeviceGroupProperties(capacity).also(block)

fun MemoryStack.PhysicalDeviceHostQueryResetFeaturesEXT(): VkPhysicalDeviceHostQueryResetFeaturesEXT = VkPhysicalDeviceHostQueryResetFeaturesEXT.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_HOST_QUERY_RESET_FEATURES_EXT }
fun MemoryStack.PhysicalDeviceHostQueryResetFeaturesEXT(block: VkPhysicalDeviceHostQueryResetFeaturesEXT.() -> Unit): VkPhysicalDeviceHostQueryResetFeaturesEXT = PhysicalDeviceHostQueryResetFeaturesEXT().also(block)
fun MemoryStack.PhysicalDeviceHostQueryResetFeaturesEXT(capacity: Int): VkPhysicalDeviceHostQueryResetFeaturesEXT.Buffer = VkPhysicalDeviceHostQueryResetFeaturesEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_HOST_QUERY_RESET_FEATURES_EXT }
fun MemoryStack.PhysicalDeviceHostQueryResetFeaturesEXT(capacity: Int, block: VkPhysicalDeviceHostQueryResetFeaturesEXT.Buffer.() -> Unit): VkPhysicalDeviceHostQueryResetFeaturesEXT.Buffer = PhysicalDeviceHostQueryResetFeaturesEXT(capacity).also(block)

fun MemoryStack.PhysicalDeviceIDProperties(): VkPhysicalDeviceIDProperties = VkPhysicalDeviceIDProperties.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_ID_PROPERTIES }
fun MemoryStack.PhysicalDeviceIDProperties(block: VkPhysicalDeviceIDProperties.() -> Unit): VkPhysicalDeviceIDProperties = PhysicalDeviceIDProperties().also(block)
fun MemoryStack.PhysicalDeviceIDProperties(capacity: Int): VkPhysicalDeviceIDProperties.Buffer = VkPhysicalDeviceIDProperties.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_ID_PROPERTIES }
fun MemoryStack.PhysicalDeviceIDProperties(capacity: Int, block: VkPhysicalDeviceIDProperties.Buffer.() -> Unit): VkPhysicalDeviceIDProperties.Buffer = PhysicalDeviceIDProperties(capacity).also(block)

fun MemoryStack.PhysicalDeviceImageDrmFormatModifierInfoEXT(): VkPhysicalDeviceImageDrmFormatModifierInfoEXT = VkPhysicalDeviceImageDrmFormatModifierInfoEXT.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_IMAGE_DRM_FORMAT_MODIFIER_INFO_EXT }
fun MemoryStack.PhysicalDeviceImageDrmFormatModifierInfoEXT(block: VkPhysicalDeviceImageDrmFormatModifierInfoEXT.() -> Unit): VkPhysicalDeviceImageDrmFormatModifierInfoEXT = PhysicalDeviceImageDrmFormatModifierInfoEXT().also(block)
fun MemoryStack.PhysicalDeviceImageDrmFormatModifierInfoEXT(capacity: Int): VkPhysicalDeviceImageDrmFormatModifierInfoEXT.Buffer = VkPhysicalDeviceImageDrmFormatModifierInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_IMAGE_DRM_FORMAT_MODIFIER_INFO_EXT }
fun MemoryStack.PhysicalDeviceImageDrmFormatModifierInfoEXT(capacity: Int, block: VkPhysicalDeviceImageDrmFormatModifierInfoEXT.Buffer.() -> Unit): VkPhysicalDeviceImageDrmFormatModifierInfoEXT.Buffer = PhysicalDeviceImageDrmFormatModifierInfoEXT(capacity).also(block)

fun MemoryStack.PhysicalDeviceImageFormatInfo2(): VkPhysicalDeviceImageFormatInfo2 = VkPhysicalDeviceImageFormatInfo2.callocStack(this).apply { sType = VkStructureType.PHYSICAL_DEVICE_IMAGE_FORMAT_INFO_2 }
fun MemoryStack.PhysicalDeviceImageFormatInfo2(block: VkPhysicalDeviceImageFormatInfo2.() -> Unit): VkPhysicalDeviceImageFormatInfo2 = PhysicalDeviceImageFormatInfo2().also(block)
fun MemoryStack.PhysicalDeviceImageFormatInfo2(capacity: Int): VkPhysicalDeviceImageFormatInfo2.Buffer = VkPhysicalDeviceImageFormatInfo2.callocStack(capacity, this).onEach { it.sType = VkStructureType.PHYSICAL_DEVICE_IMAGE_FORMAT_INFO_2 }
fun MemoryStack.PhysicalDeviceImageFormatInfo2(capacity: Int, block: VkPhysicalDeviceImageFormatInfo2.Buffer.() -> Unit): VkPhysicalDeviceImageFormatInfo2.Buffer = PhysicalDeviceImageFormatInfo2(capacity).also(block)

fun MemoryStack.PhysicalDeviceImageViewImageFormatInfoEXT(): VkPhysicalDeviceImageViewImageFormatInfoEXT = VkPhysicalDeviceImageViewImageFormatInfoEXT.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_IMAGE_VIEW_IMAGE_FORMAT_INFO_EXT }
fun MemoryStack.PhysicalDeviceImageViewImageFormatInfoEXT(block: VkPhysicalDeviceImageViewImageFormatInfoEXT.() -> Unit): VkPhysicalDeviceImageViewImageFormatInfoEXT = PhysicalDeviceImageViewImageFormatInfoEXT().also(block)
fun MemoryStack.PhysicalDeviceImageViewImageFormatInfoEXT(capacity: Int): VkPhysicalDeviceImageViewImageFormatInfoEXT.Buffer = VkPhysicalDeviceImageViewImageFormatInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_IMAGE_VIEW_IMAGE_FORMAT_INFO_EXT }
fun MemoryStack.PhysicalDeviceImageViewImageFormatInfoEXT(capacity: Int, block: VkPhysicalDeviceImageViewImageFormatInfoEXT.Buffer.() -> Unit): VkPhysicalDeviceImageViewImageFormatInfoEXT.Buffer = PhysicalDeviceImageViewImageFormatInfoEXT(capacity).also(block)

fun MemoryStack.PhysicalDeviceInlineUniformBlockFeaturesEXT(): VkPhysicalDeviceInlineUniformBlockFeaturesEXT = VkPhysicalDeviceInlineUniformBlockFeaturesEXT.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_INLINE_UNIFORM_BLOCK_FEATURES_EXT }
fun MemoryStack.PhysicalDeviceInlineUniformBlockFeaturesEXT(block: VkPhysicalDeviceInlineUniformBlockFeaturesEXT.() -> Unit): VkPhysicalDeviceInlineUniformBlockFeaturesEXT = PhysicalDeviceInlineUniformBlockFeaturesEXT().also(block)
fun MemoryStack.PhysicalDeviceInlineUniformBlockFeaturesEXT(capacity: Int): VkPhysicalDeviceInlineUniformBlockFeaturesEXT.Buffer = VkPhysicalDeviceInlineUniformBlockFeaturesEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_INLINE_UNIFORM_BLOCK_FEATURES_EXT }
fun MemoryStack.PhysicalDeviceInlineUniformBlockFeaturesEXT(capacity: Int, block: VkPhysicalDeviceInlineUniformBlockFeaturesEXT.Buffer.() -> Unit): VkPhysicalDeviceInlineUniformBlockFeaturesEXT.Buffer = PhysicalDeviceInlineUniformBlockFeaturesEXT(capacity).also(block)

fun MemoryStack.PhysicalDeviceInlineUniformBlockPropertiesEXT(): VkPhysicalDeviceInlineUniformBlockPropertiesEXT = VkPhysicalDeviceInlineUniformBlockPropertiesEXT.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_INLINE_UNIFORM_BLOCK_PROPERTIES_EXT }
fun MemoryStack.PhysicalDeviceInlineUniformBlockPropertiesEXT(block: VkPhysicalDeviceInlineUniformBlockPropertiesEXT.() -> Unit): VkPhysicalDeviceInlineUniformBlockPropertiesEXT = PhysicalDeviceInlineUniformBlockPropertiesEXT().also(block)
fun MemoryStack.PhysicalDeviceInlineUniformBlockPropertiesEXT(capacity: Int): VkPhysicalDeviceInlineUniformBlockPropertiesEXT.Buffer = VkPhysicalDeviceInlineUniformBlockPropertiesEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_INLINE_UNIFORM_BLOCK_PROPERTIES_EXT }
fun MemoryStack.PhysicalDeviceInlineUniformBlockPropertiesEXT(capacity: Int, block: VkPhysicalDeviceInlineUniformBlockPropertiesEXT.Buffer.() -> Unit): VkPhysicalDeviceInlineUniformBlockPropertiesEXT.Buffer = PhysicalDeviceInlineUniformBlockPropertiesEXT(capacity).also(block)

//fun MemoryStack.PhysicalDeviceLimits(): VkPhysicalDeviceLimits = VkPhysicalDeviceLimits.callocStack(this)
//fun MemoryStack.PhysicalDeviceLimits(block: VkPhysicalDeviceLimits.() -> Unit): VkPhysicalDeviceLimits = PhysicalDeviceLimits().also(block)
//fun MemoryStack.PhysicalDeviceLimits(capacity: Int): VkPhysicalDeviceLimits.Buffer = VkPhysicalDeviceLimits.callocStack(capacity, this)
//fun MemoryStack.PhysicalDeviceLimits(capacity: Int, block: VkPhysicalDeviceLimits.Buffer.() -> Unit): VkPhysicalDeviceLimits.Buffer = PhysicalDeviceLimits(capacity).also(block)

fun MemoryStack.PhysicalDeviceMaintenance3Properties(): VkPhysicalDeviceMaintenance3Properties = VkPhysicalDeviceMaintenance3Properties.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_MAINTENANCE_3_PROPERTIES }
fun MemoryStack.PhysicalDeviceMaintenance3Properties(block: VkPhysicalDeviceMaintenance3Properties.() -> Unit): VkPhysicalDeviceMaintenance3Properties = PhysicalDeviceMaintenance3Properties().also(block)
fun MemoryStack.PhysicalDeviceMaintenance3Properties(capacity: Int): VkPhysicalDeviceMaintenance3Properties.Buffer = VkPhysicalDeviceMaintenance3Properties.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_MAINTENANCE_3_PROPERTIES }
fun MemoryStack.PhysicalDeviceMaintenance3Properties(capacity: Int, block: VkPhysicalDeviceMaintenance3Properties.Buffer.() -> Unit): VkPhysicalDeviceMaintenance3Properties.Buffer = PhysicalDeviceMaintenance3Properties(capacity).also(block)

fun MemoryStack.PhysicalDeviceMemoryBudgetPropertiesEXT(): VkPhysicalDeviceMemoryBudgetPropertiesEXT = VkPhysicalDeviceMemoryBudgetPropertiesEXT.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_MEMORY_BUDGET_PROPERTIES_EXT }
fun MemoryStack.PhysicalDeviceMemoryBudgetPropertiesEXT(block: VkPhysicalDeviceMemoryBudgetPropertiesEXT.() -> Unit): VkPhysicalDeviceMemoryBudgetPropertiesEXT = PhysicalDeviceMemoryBudgetPropertiesEXT().also(block)
fun MemoryStack.PhysicalDeviceMemoryBudgetPropertiesEXT(capacity: Int): VkPhysicalDeviceMemoryBudgetPropertiesEXT.Buffer = VkPhysicalDeviceMemoryBudgetPropertiesEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_MEMORY_BUDGET_PROPERTIES_EXT }
fun MemoryStack.PhysicalDeviceMemoryBudgetPropertiesEXT(capacity: Int, block: VkPhysicalDeviceMemoryBudgetPropertiesEXT.Buffer.() -> Unit): VkPhysicalDeviceMemoryBudgetPropertiesEXT.Buffer = PhysicalDeviceMemoryBudgetPropertiesEXT(capacity).also(block)

fun MemoryStack.PhysicalDeviceMemoryPriorityFeaturesEXT(): VkPhysicalDeviceMemoryPriorityFeaturesEXT = VkPhysicalDeviceMemoryPriorityFeaturesEXT.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_MEMORY_PRIORITY_FEATURES_EXT }
fun MemoryStack.PhysicalDeviceMemoryPriorityFeaturesEXT(block: VkPhysicalDeviceMemoryPriorityFeaturesEXT.() -> Unit): VkPhysicalDeviceMemoryPriorityFeaturesEXT = PhysicalDeviceMemoryPriorityFeaturesEXT().also(block)
fun MemoryStack.PhysicalDeviceMemoryPriorityFeaturesEXT(capacity: Int): VkPhysicalDeviceMemoryPriorityFeaturesEXT.Buffer = VkPhysicalDeviceMemoryPriorityFeaturesEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_MEMORY_PRIORITY_FEATURES_EXT }
fun MemoryStack.PhysicalDeviceMemoryPriorityFeaturesEXT(capacity: Int, block: VkPhysicalDeviceMemoryPriorityFeaturesEXT.Buffer.() -> Unit): VkPhysicalDeviceMemoryPriorityFeaturesEXT.Buffer = PhysicalDeviceMemoryPriorityFeaturesEXT(capacity).also(block)

fun MemoryStack.PhysicalDeviceMemoryProperties(): VkPhysicalDeviceMemoryProperties = VkPhysicalDeviceMemoryProperties.callocStack(this)
fun MemoryStack.PhysicalDeviceMemoryProperties(block: VkPhysicalDeviceMemoryProperties.() -> Unit): VkPhysicalDeviceMemoryProperties = PhysicalDeviceMemoryProperties().also(block)
fun MemoryStack.PhysicalDeviceMemoryProperties(capacity: Int): VkPhysicalDeviceMemoryProperties.Buffer = VkPhysicalDeviceMemoryProperties.callocStack(capacity, this)
fun MemoryStack.PhysicalDeviceMemoryProperties(capacity: Int, block: VkPhysicalDeviceMemoryProperties.Buffer.() -> Unit): VkPhysicalDeviceMemoryProperties.Buffer = PhysicalDeviceMemoryProperties(capacity).also(block)

fun MemoryStack.PhysicalDeviceMemoryProperties2(): VkPhysicalDeviceMemoryProperties2 = VkPhysicalDeviceMemoryProperties2.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_MEMORY_PROPERTIES_2 }
fun MemoryStack.PhysicalDeviceMemoryProperties2(block: VkPhysicalDeviceMemoryProperties2.() -> Unit): VkPhysicalDeviceMemoryProperties2 = PhysicalDeviceMemoryProperties2().also(block)
fun MemoryStack.PhysicalDeviceMemoryProperties2(capacity: Int): VkPhysicalDeviceMemoryProperties2.Buffer = VkPhysicalDeviceMemoryProperties2.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_MEMORY_PROPERTIES_2 }
fun MemoryStack.PhysicalDeviceMemoryProperties2(capacity: Int, block: VkPhysicalDeviceMemoryProperties2.Buffer.() -> Unit): VkPhysicalDeviceMemoryProperties2.Buffer = PhysicalDeviceMemoryProperties2(capacity).also(block)

fun MemoryStack.PhysicalDeviceMeshShaderFeaturesNV(): VkPhysicalDeviceMeshShaderFeaturesNV = VkPhysicalDeviceMeshShaderFeaturesNV.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_MESH_SHADER_FEATURES_NV }
fun MemoryStack.PhysicalDeviceMeshShaderFeaturesNV(block: VkPhysicalDeviceMeshShaderFeaturesNV.() -> Unit): VkPhysicalDeviceMeshShaderFeaturesNV = PhysicalDeviceMeshShaderFeaturesNV().also(block)
fun MemoryStack.PhysicalDeviceMeshShaderFeaturesNV(capacity: Int): VkPhysicalDeviceMeshShaderFeaturesNV.Buffer = VkPhysicalDeviceMeshShaderFeaturesNV.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_MESH_SHADER_FEATURES_NV }
fun MemoryStack.PhysicalDeviceMeshShaderFeaturesNV(capacity: Int, block: VkPhysicalDeviceMeshShaderFeaturesNV.Buffer.() -> Unit): VkPhysicalDeviceMeshShaderFeaturesNV.Buffer = PhysicalDeviceMeshShaderFeaturesNV(capacity).also(block)

fun MemoryStack.PhysicalDeviceMeshShaderPropertiesNV(): VkPhysicalDeviceMeshShaderPropertiesNV = VkPhysicalDeviceMeshShaderPropertiesNV.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_MESH_SHADER_PROPERTIES_NV }
fun MemoryStack.PhysicalDeviceMeshShaderPropertiesNV(block: VkPhysicalDeviceMeshShaderPropertiesNV.() -> Unit): VkPhysicalDeviceMeshShaderPropertiesNV = PhysicalDeviceMeshShaderPropertiesNV().also(block)
fun MemoryStack.PhysicalDeviceMeshShaderPropertiesNV(capacity: Int): VkPhysicalDeviceMeshShaderPropertiesNV.Buffer = VkPhysicalDeviceMeshShaderPropertiesNV.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_MESH_SHADER_PROPERTIES_NV }
fun MemoryStack.PhysicalDeviceMeshShaderPropertiesNV(capacity: Int, block: VkPhysicalDeviceMeshShaderPropertiesNV.Buffer.() -> Unit): VkPhysicalDeviceMeshShaderPropertiesNV.Buffer = PhysicalDeviceMeshShaderPropertiesNV(capacity).also(block)

fun MemoryStack.PhysicalDeviceMultiviewFeatures(): VkPhysicalDeviceMultiviewFeatures = VkPhysicalDeviceMultiviewFeatures.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_MULTIVIEW_FEATURES }
fun MemoryStack.PhysicalDeviceMultiviewFeatures(block: VkPhysicalDeviceMultiviewFeatures.() -> Unit): VkPhysicalDeviceMultiviewFeatures = PhysicalDeviceMultiviewFeatures().also(block)
fun MemoryStack.PhysicalDeviceMultiviewFeatures(capacity: Int): VkPhysicalDeviceMultiviewFeatures.Buffer = VkPhysicalDeviceMultiviewFeatures.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_MULTIVIEW_FEATURES }
fun MemoryStack.PhysicalDeviceMultiviewFeatures(capacity: Int, block: VkPhysicalDeviceMultiviewFeatures.Buffer.() -> Unit): VkPhysicalDeviceMultiviewFeatures.Buffer = PhysicalDeviceMultiviewFeatures(capacity).also(block)

fun MemoryStack.PhysicalDeviceMultiviewPerViewAttributesPropertiesNVX(): VkPhysicalDeviceMultiviewPerViewAttributesPropertiesNVX = VkPhysicalDeviceMultiviewPerViewAttributesPropertiesNVX.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_MULTIVIEW_PER_VIEW_ATTRIBUTES_PROPERTIES_NVX }
fun MemoryStack.PhysicalDeviceMultiviewPerViewAttributesPropertiesNVX(block: VkPhysicalDeviceMultiviewPerViewAttributesPropertiesNVX.() -> Unit): VkPhysicalDeviceMultiviewPerViewAttributesPropertiesNVX = PhysicalDeviceMultiviewPerViewAttributesPropertiesNVX().also(block)
fun MemoryStack.PhysicalDeviceMultiviewPerViewAttributesPropertiesNVX(capacity: Int): VkPhysicalDeviceMultiviewPerViewAttributesPropertiesNVX.Buffer = VkPhysicalDeviceMultiviewPerViewAttributesPropertiesNVX.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_MULTIVIEW_PER_VIEW_ATTRIBUTES_PROPERTIES_NVX }
fun MemoryStack.PhysicalDeviceMultiviewPerViewAttributesPropertiesNVX(capacity: Int, block: VkPhysicalDeviceMultiviewPerViewAttributesPropertiesNVX.Buffer.() -> Unit): VkPhysicalDeviceMultiviewPerViewAttributesPropertiesNVX.Buffer = PhysicalDeviceMultiviewPerViewAttributesPropertiesNVX(capacity).also(block)

fun MemoryStack.PhysicalDeviceMultiviewProperties(): VkPhysicalDeviceMultiviewProperties = VkPhysicalDeviceMultiviewProperties.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_MULTIVIEW_PROPERTIES }
fun MemoryStack.PhysicalDeviceMultiviewProperties(block: VkPhysicalDeviceMultiviewProperties.() -> Unit): VkPhysicalDeviceMultiviewProperties = PhysicalDeviceMultiviewProperties().also(block)
fun MemoryStack.PhysicalDeviceMultiviewProperties(capacity: Int): VkPhysicalDeviceMultiviewProperties.Buffer = VkPhysicalDeviceMultiviewProperties.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_MULTIVIEW_PROPERTIES }
fun MemoryStack.PhysicalDeviceMultiviewProperties(capacity: Int, block: VkPhysicalDeviceMultiviewProperties.Buffer.() -> Unit): VkPhysicalDeviceMultiviewProperties.Buffer = PhysicalDeviceMultiviewProperties(capacity).also(block)

fun MemoryStack.PhysicalDevicePCIBusInfoPropertiesEXT(): VkPhysicalDevicePCIBusInfoPropertiesEXT = VkPhysicalDevicePCIBusInfoPropertiesEXT.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_PCI_BUS_INFO_PROPERTIES_EXT }
fun MemoryStack.PhysicalDevicePCIBusInfoPropertiesEXT(block: VkPhysicalDevicePCIBusInfoPropertiesEXT.() -> Unit): VkPhysicalDevicePCIBusInfoPropertiesEXT = PhysicalDevicePCIBusInfoPropertiesEXT().also(block)
fun MemoryStack.PhysicalDevicePCIBusInfoPropertiesEXT(capacity: Int): VkPhysicalDevicePCIBusInfoPropertiesEXT.Buffer = VkPhysicalDevicePCIBusInfoPropertiesEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_PCI_BUS_INFO_PROPERTIES_EXT }
fun MemoryStack.PhysicalDevicePCIBusInfoPropertiesEXT(capacity: Int, block: VkPhysicalDevicePCIBusInfoPropertiesEXT.Buffer.() -> Unit): VkPhysicalDevicePCIBusInfoPropertiesEXT.Buffer = PhysicalDevicePCIBusInfoPropertiesEXT(capacity).also(block)

fun MemoryStack.PhysicalDevicePointClippingProperties(): VkPhysicalDevicePointClippingProperties = VkPhysicalDevicePointClippingProperties.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_POINT_CLIPPING_PROPERTIES }
fun MemoryStack.PhysicalDevicePointClippingProperties(block: VkPhysicalDevicePointClippingProperties.() -> Unit): VkPhysicalDevicePointClippingProperties = PhysicalDevicePointClippingProperties().also(block)
fun MemoryStack.PhysicalDevicePointClippingProperties(capacity: Int): VkPhysicalDevicePointClippingProperties.Buffer = VkPhysicalDevicePointClippingProperties.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_POINT_CLIPPING_PROPERTIES }
fun MemoryStack.PhysicalDevicePointClippingProperties(capacity: Int, block: VkPhysicalDevicePointClippingProperties.Buffer.() -> Unit): VkPhysicalDevicePointClippingProperties.Buffer = PhysicalDevicePointClippingProperties(capacity).also(block)

//fun MemoryStack.PhysicalDeviceSparseProperties(): VkPhysicalDeviceSparseProperties = VkPhysicalDeviceSparseProperties.callocStack(this)
//fun MemoryStack.PhysicalDeviceSparseProperties(block: VkPhysicalDeviceSparseProperties.() -> Unit): VkPhysicalDeviceSparseProperties = PhysicalDeviceSparseProperties().also(block)
//fun MemoryStack.PhysicalDeviceSparseProperties(capacity: Int): VkPhysicalDeviceSparseProperties.Buffer = VkPhysicalDeviceSparseProperties.callocStack(capacity, this)
//fun MemoryStack.PhysicalDeviceSparseProperties(capacity: Int, block: VkPhysicalDeviceSparseProperties.Buffer.() -> Unit): VkPhysicalDeviceSparseProperties.Buffer = PhysicalDeviceSparseProperties(capacity).also(block)

fun MemoryStack.PhysicalDeviceProperties(): VkPhysicalDeviceProperties = VkPhysicalDeviceProperties.callocStack(this)
fun MemoryStack.PhysicalDeviceProperties(block: VkPhysicalDeviceProperties.() -> Unit): VkPhysicalDeviceProperties = PhysicalDeviceProperties().also(block)
fun MemoryStack.PhysicalDeviceProperties(capacity: Int): VkPhysicalDeviceProperties.Buffer = VkPhysicalDeviceProperties.callocStack(capacity, this)
fun MemoryStack.PhysicalDeviceProperties(capacity: Int, block: VkPhysicalDeviceProperties.Buffer.() -> Unit): VkPhysicalDeviceProperties.Buffer = PhysicalDeviceProperties(capacity).also(block)

fun MemoryStack.PhysicalDeviceProperties2(): VkPhysicalDeviceProperties2 = VkPhysicalDeviceProperties2.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_PROPERTIES_2 }
fun MemoryStack.PhysicalDeviceProperties2(block: VkPhysicalDeviceProperties2.() -> Unit): VkPhysicalDeviceProperties2 = PhysicalDeviceProperties2().also(block)
fun MemoryStack.PhysicalDeviceProperties2(capacity: Int): VkPhysicalDeviceProperties2.Buffer = VkPhysicalDeviceProperties2.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_PROPERTIES_2 }
fun MemoryStack.PhysicalDeviceProperties2(capacity: Int, block: VkPhysicalDeviceProperties2.Buffer.() -> Unit): VkPhysicalDeviceProperties2.Buffer = PhysicalDeviceProperties2(capacity).also(block)

fun MemoryStack.PhysicalDeviceProtectedMemoryFeatures(): VkPhysicalDeviceProtectedMemoryFeatures = VkPhysicalDeviceProtectedMemoryFeatures.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_PROTECTED_MEMORY_FEATURES }
fun MemoryStack.PhysicalDeviceProtectedMemoryFeatures(block: VkPhysicalDeviceProtectedMemoryFeatures.() -> Unit): VkPhysicalDeviceProtectedMemoryFeatures = PhysicalDeviceProtectedMemoryFeatures().also(block)
fun MemoryStack.PhysicalDeviceProtectedMemoryFeatures(capacity: Int): VkPhysicalDeviceProtectedMemoryFeatures.Buffer = VkPhysicalDeviceProtectedMemoryFeatures.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_PROTECTED_MEMORY_FEATURES }
fun MemoryStack.PhysicalDeviceProtectedMemoryFeatures(capacity: Int, block: VkPhysicalDeviceProtectedMemoryFeatures.Buffer.() -> Unit): VkPhysicalDeviceProtectedMemoryFeatures.Buffer = PhysicalDeviceProtectedMemoryFeatures(capacity).also(block)

fun MemoryStack.PhysicalDeviceProtectedMemoryProperties(): VkPhysicalDeviceProtectedMemoryProperties = VkPhysicalDeviceProtectedMemoryProperties.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_PROTECTED_MEMORY_PROPERTIES }
fun MemoryStack.PhysicalDeviceProtectedMemoryProperties(block: VkPhysicalDeviceProtectedMemoryProperties.() -> Unit): VkPhysicalDeviceProtectedMemoryProperties = PhysicalDeviceProtectedMemoryProperties().also(block)
fun MemoryStack.PhysicalDeviceProtectedMemoryProperties(capacity: Int): VkPhysicalDeviceProtectedMemoryProperties.Buffer = VkPhysicalDeviceProtectedMemoryProperties.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_PROTECTED_MEMORY_PROPERTIES }
fun MemoryStack.PhysicalDeviceProtectedMemoryProperties(capacity: Int, block: VkPhysicalDeviceProtectedMemoryProperties.Buffer.() -> Unit): VkPhysicalDeviceProtectedMemoryProperties.Buffer = PhysicalDeviceProtectedMemoryProperties(capacity).also(block)

fun MemoryStack.PhysicalDevicePushDescriptorPropertiesKHR(): VkPhysicalDevicePushDescriptorPropertiesKHR = VkPhysicalDevicePushDescriptorPropertiesKHR.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_PUSH_DESCRIPTOR_PROPERTIES_KHR }
fun MemoryStack.PhysicalDevicePushDescriptorPropertiesKHR(block: VkPhysicalDevicePushDescriptorPropertiesKHR.() -> Unit): VkPhysicalDevicePushDescriptorPropertiesKHR = PhysicalDevicePushDescriptorPropertiesKHR().also(block)
fun MemoryStack.PhysicalDevicePushDescriptorPropertiesKHR(capacity: Int): VkPhysicalDevicePushDescriptorPropertiesKHR.Buffer = VkPhysicalDevicePushDescriptorPropertiesKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_PUSH_DESCRIPTOR_PROPERTIES_KHR }
fun MemoryStack.PhysicalDevicePushDescriptorPropertiesKHR(capacity: Int, block: VkPhysicalDevicePushDescriptorPropertiesKHR.Buffer.() -> Unit): VkPhysicalDevicePushDescriptorPropertiesKHR.Buffer = PhysicalDevicePushDescriptorPropertiesKHR(capacity).also(block)

fun MemoryStack.PhysicalDeviceRayTracingPropertiesNV(): VkPhysicalDeviceRayTracingPropertiesNV = VkPhysicalDeviceRayTracingPropertiesNV.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_RAY_TRACING_PROPERTIES_NV }
fun MemoryStack.PhysicalDeviceRayTracingPropertiesNV(block: VkPhysicalDeviceRayTracingPropertiesNV.() -> Unit): VkPhysicalDeviceRayTracingPropertiesNV = PhysicalDeviceRayTracingPropertiesNV().also(block)
fun MemoryStack.PhysicalDeviceRayTracingPropertiesNV(capacity: Int): VkPhysicalDeviceRayTracingPropertiesNV.Buffer = VkPhysicalDeviceRayTracingPropertiesNV.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_RAY_TRACING_PROPERTIES_NV }
fun MemoryStack.PhysicalDeviceRayTracingPropertiesNV(capacity: Int, block: VkPhysicalDeviceRayTracingPropertiesNV.Buffer.() -> Unit): VkPhysicalDeviceRayTracingPropertiesNV.Buffer = PhysicalDeviceRayTracingPropertiesNV(capacity).also(block)

fun MemoryStack.PhysicalDeviceRepresentativeFragmentTestFeaturesNV(): VkPhysicalDeviceRepresentativeFragmentTestFeaturesNV = VkPhysicalDeviceRepresentativeFragmentTestFeaturesNV.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_REPRESENTATIVE_FRAGMENT_TEST_FEATURES_NV }
fun MemoryStack.PhysicalDeviceRepresentativeFragmentTestFeaturesNV(block: VkPhysicalDeviceRepresentativeFragmentTestFeaturesNV.() -> Unit): VkPhysicalDeviceRepresentativeFragmentTestFeaturesNV = PhysicalDeviceRepresentativeFragmentTestFeaturesNV().also(block)
fun MemoryStack.PhysicalDeviceRepresentativeFragmentTestFeaturesNV(capacity: Int): VkPhysicalDeviceRepresentativeFragmentTestFeaturesNV.Buffer = VkPhysicalDeviceRepresentativeFragmentTestFeaturesNV.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_REPRESENTATIVE_FRAGMENT_TEST_FEATURES_NV }
fun MemoryStack.PhysicalDeviceRepresentativeFragmentTestFeaturesNV(capacity: Int, block: VkPhysicalDeviceRepresentativeFragmentTestFeaturesNV.Buffer.() -> Unit): VkPhysicalDeviceRepresentativeFragmentTestFeaturesNV.Buffer = PhysicalDeviceRepresentativeFragmentTestFeaturesNV(capacity).also(block)

fun MemoryStack.PhysicalDeviceSampleLocationsPropertiesEXT(): VkPhysicalDeviceSampleLocationsPropertiesEXT = VkPhysicalDeviceSampleLocationsPropertiesEXT.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_SAMPLE_LOCATIONS_PROPERTIES_EXT }
fun MemoryStack.PhysicalDeviceSampleLocationsPropertiesEXT(block: VkPhysicalDeviceSampleLocationsPropertiesEXT.() -> Unit): VkPhysicalDeviceSampleLocationsPropertiesEXT = PhysicalDeviceSampleLocationsPropertiesEXT().also(block)
fun MemoryStack.PhysicalDeviceSampleLocationsPropertiesEXT(capacity: Int): VkPhysicalDeviceSampleLocationsPropertiesEXT.Buffer = VkPhysicalDeviceSampleLocationsPropertiesEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_SAMPLE_LOCATIONS_PROPERTIES_EXT }
fun MemoryStack.PhysicalDeviceSampleLocationsPropertiesEXT(capacity: Int, block: VkPhysicalDeviceSampleLocationsPropertiesEXT.Buffer.() -> Unit): VkPhysicalDeviceSampleLocationsPropertiesEXT.Buffer = PhysicalDeviceSampleLocationsPropertiesEXT(capacity).also(block)

fun MemoryStack.PhysicalDeviceSamplerFilterMinmaxPropertiesEXT(): VkPhysicalDeviceSamplerFilterMinmaxPropertiesEXT = VkPhysicalDeviceSamplerFilterMinmaxPropertiesEXT.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_SAMPLER_FILTER_MINMAX_PROPERTIES_EXT }
fun MemoryStack.PhysicalDeviceSamplerFilterMinmaxPropertiesEXT(block: VkPhysicalDeviceSamplerFilterMinmaxPropertiesEXT.() -> Unit): VkPhysicalDeviceSamplerFilterMinmaxPropertiesEXT = PhysicalDeviceSamplerFilterMinmaxPropertiesEXT().also(block)
fun MemoryStack.PhysicalDeviceSamplerFilterMinmaxPropertiesEXT(capacity: Int): VkPhysicalDeviceSamplerFilterMinmaxPropertiesEXT.Buffer = VkPhysicalDeviceSamplerFilterMinmaxPropertiesEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_SAMPLER_FILTER_MINMAX_PROPERTIES_EXT }
fun MemoryStack.PhysicalDeviceSamplerFilterMinmaxPropertiesEXT(capacity: Int, block: VkPhysicalDeviceSamplerFilterMinmaxPropertiesEXT.Buffer.() -> Unit): VkPhysicalDeviceSamplerFilterMinmaxPropertiesEXT.Buffer = PhysicalDeviceSamplerFilterMinmaxPropertiesEXT(capacity).also(block)

fun MemoryStack.PhysicalDeviceSamplerYcbcrConversionFeatures(): VkPhysicalDeviceSamplerYcbcrConversionFeatures = VkPhysicalDeviceSamplerYcbcrConversionFeatures.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_SAMPLER_YCBCR_CONVERSION_FEATURES }
fun MemoryStack.PhysicalDeviceSamplerYcbcrConversionFeatures(block: VkPhysicalDeviceSamplerYcbcrConversionFeatures.() -> Unit): VkPhysicalDeviceSamplerYcbcrConversionFeatures = PhysicalDeviceSamplerYcbcrConversionFeatures().also(block)
fun MemoryStack.PhysicalDeviceSamplerYcbcrConversionFeatures(capacity: Int): VkPhysicalDeviceSamplerYcbcrConversionFeatures.Buffer = VkPhysicalDeviceSamplerYcbcrConversionFeatures.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_SAMPLER_YCBCR_CONVERSION_FEATURES }
fun MemoryStack.PhysicalDeviceSamplerYcbcrConversionFeatures(capacity: Int, block: VkPhysicalDeviceSamplerYcbcrConversionFeatures.Buffer.() -> Unit): VkPhysicalDeviceSamplerYcbcrConversionFeatures.Buffer = PhysicalDeviceSamplerYcbcrConversionFeatures(capacity).also(block)

fun MemoryStack.PhysicalDeviceScalarBlockLayoutFeaturesEXT(): VkPhysicalDeviceScalarBlockLayoutFeaturesEXT = VkPhysicalDeviceScalarBlockLayoutFeaturesEXT.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_SCALAR_BLOCK_LAYOUT_FEATURES_EXT }
fun MemoryStack.PhysicalDeviceScalarBlockLayoutFeaturesEXT(block: VkPhysicalDeviceScalarBlockLayoutFeaturesEXT.() -> Unit): VkPhysicalDeviceScalarBlockLayoutFeaturesEXT = PhysicalDeviceScalarBlockLayoutFeaturesEXT().also(block)
fun MemoryStack.PhysicalDeviceScalarBlockLayoutFeaturesEXT(capacity: Int): VkPhysicalDeviceScalarBlockLayoutFeaturesEXT.Buffer = VkPhysicalDeviceScalarBlockLayoutFeaturesEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_SCALAR_BLOCK_LAYOUT_FEATURES_EXT }
fun MemoryStack.PhysicalDeviceScalarBlockLayoutFeaturesEXT(capacity: Int, block: VkPhysicalDeviceScalarBlockLayoutFeaturesEXT.Buffer.() -> Unit): VkPhysicalDeviceScalarBlockLayoutFeaturesEXT.Buffer = PhysicalDeviceScalarBlockLayoutFeaturesEXT(capacity).also(block)

fun MemoryStack.PhysicalDeviceShaderAtomicInt64FeaturesKHR(): VkPhysicalDeviceShaderAtomicInt64FeaturesKHR = VkPhysicalDeviceShaderAtomicInt64FeaturesKHR.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_SHADER_ATOMIC_INT64_FEATURES_KHR }
fun MemoryStack.PhysicalDeviceShaderAtomicInt64FeaturesKHR(block: VkPhysicalDeviceShaderAtomicInt64FeaturesKHR.() -> Unit): VkPhysicalDeviceShaderAtomicInt64FeaturesKHR = PhysicalDeviceShaderAtomicInt64FeaturesKHR().also(block)
fun MemoryStack.PhysicalDeviceShaderAtomicInt64FeaturesKHR(capacity: Int): VkPhysicalDeviceShaderAtomicInt64FeaturesKHR.Buffer = VkPhysicalDeviceShaderAtomicInt64FeaturesKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_SHADER_ATOMIC_INT64_FEATURES_KHR }
fun MemoryStack.PhysicalDeviceShaderAtomicInt64FeaturesKHR(capacity: Int, block: VkPhysicalDeviceShaderAtomicInt64FeaturesKHR.Buffer.() -> Unit): VkPhysicalDeviceShaderAtomicInt64FeaturesKHR.Buffer = PhysicalDeviceShaderAtomicInt64FeaturesKHR(capacity).also(block)

fun MemoryStack.PhysicalDeviceShaderCorePropertiesAMD(): VkPhysicalDeviceShaderCorePropertiesAMD = VkPhysicalDeviceShaderCorePropertiesAMD.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_SHADER_CORE_PROPERTIES_AMD }
fun MemoryStack.PhysicalDeviceShaderCorePropertiesAMD(block: VkPhysicalDeviceShaderCorePropertiesAMD.() -> Unit): VkPhysicalDeviceShaderCorePropertiesAMD = PhysicalDeviceShaderCorePropertiesAMD().also(block)
fun MemoryStack.PhysicalDeviceShaderCorePropertiesAMD(capacity: Int): VkPhysicalDeviceShaderCorePropertiesAMD.Buffer = VkPhysicalDeviceShaderCorePropertiesAMD.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_SHADER_CORE_PROPERTIES_AMD }
fun MemoryStack.PhysicalDeviceShaderCorePropertiesAMD(capacity: Int, block: VkPhysicalDeviceShaderCorePropertiesAMD.Buffer.() -> Unit): VkPhysicalDeviceShaderCorePropertiesAMD.Buffer = PhysicalDeviceShaderCorePropertiesAMD(capacity).also(block)

fun MemoryStack.PhysicalDeviceShaderDrawParametersFeatures(): VkPhysicalDeviceShaderDrawParametersFeatures = VkPhysicalDeviceShaderDrawParametersFeatures.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_SHADER_DRAW_PARAMETER_FEATURES }
fun MemoryStack.PhysicalDeviceShaderDrawParametersFeatures(block: VkPhysicalDeviceShaderDrawParametersFeatures.() -> Unit): VkPhysicalDeviceShaderDrawParametersFeatures = PhysicalDeviceShaderDrawParametersFeatures().also(block)
fun MemoryStack.PhysicalDeviceShaderDrawParametersFeatures(capacity: Int): VkPhysicalDeviceShaderDrawParametersFeatures.Buffer = VkPhysicalDeviceShaderDrawParametersFeatures.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_SHADER_DRAW_PARAMETER_FEATURES }
fun MemoryStack.PhysicalDeviceShaderDrawParametersFeatures(capacity: Int, block: VkPhysicalDeviceShaderDrawParametersFeatures.Buffer.() -> Unit): VkPhysicalDeviceShaderDrawParametersFeatures.Buffer = PhysicalDeviceShaderDrawParametersFeatures(capacity).also(block)

fun MemoryStack.PhysicalDeviceShaderImageFootprintFeaturesNV(): VkPhysicalDeviceShaderImageFootprintFeaturesNV = VkPhysicalDeviceShaderImageFootprintFeaturesNV.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_SHADER_IMAGE_FOOTPRINT_FEATURES_NV }
fun MemoryStack.PhysicalDeviceShaderImageFootprintFeaturesNV(block: VkPhysicalDeviceShaderImageFootprintFeaturesNV.() -> Unit): VkPhysicalDeviceShaderImageFootprintFeaturesNV = PhysicalDeviceShaderImageFootprintFeaturesNV().also(block)
fun MemoryStack.PhysicalDeviceShaderImageFootprintFeaturesNV(capacity: Int): VkPhysicalDeviceShaderImageFootprintFeaturesNV.Buffer = VkPhysicalDeviceShaderImageFootprintFeaturesNV.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_SHADER_IMAGE_FOOTPRINT_FEATURES_NV }
fun MemoryStack.PhysicalDeviceShaderImageFootprintFeaturesNV(capacity: Int, block: VkPhysicalDeviceShaderImageFootprintFeaturesNV.Buffer.() -> Unit): VkPhysicalDeviceShaderImageFootprintFeaturesNV.Buffer = PhysicalDeviceShaderImageFootprintFeaturesNV(capacity).also(block)

fun MemoryStack.PhysicalDeviceShadingRateImageFeaturesNV(): VkPhysicalDeviceShadingRateImageFeaturesNV = VkPhysicalDeviceShadingRateImageFeaturesNV.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_SHADING_RATE_IMAGE_FEATURES_NV }
fun MemoryStack.PhysicalDeviceShadingRateImageFeaturesNV(block: VkPhysicalDeviceShadingRateImageFeaturesNV.() -> Unit): VkPhysicalDeviceShadingRateImageFeaturesNV = PhysicalDeviceShadingRateImageFeaturesNV().also(block)
fun MemoryStack.PhysicalDeviceShadingRateImageFeaturesNV(capacity: Int): VkPhysicalDeviceShadingRateImageFeaturesNV.Buffer = VkPhysicalDeviceShadingRateImageFeaturesNV.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_SHADING_RATE_IMAGE_FEATURES_NV }
fun MemoryStack.PhysicalDeviceShadingRateImageFeaturesNV(capacity: Int, block: VkPhysicalDeviceShadingRateImageFeaturesNV.Buffer.() -> Unit): VkPhysicalDeviceShadingRateImageFeaturesNV.Buffer = PhysicalDeviceShadingRateImageFeaturesNV(capacity).also(block)

fun MemoryStack.PhysicalDeviceShadingRateImagePropertiesNV(): VkPhysicalDeviceShadingRateImagePropertiesNV = VkPhysicalDeviceShadingRateImagePropertiesNV.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_SHADING_RATE_IMAGE_PROPERTIES_NV }
fun MemoryStack.PhysicalDeviceShadingRateImagePropertiesNV(block: VkPhysicalDeviceShadingRateImagePropertiesNV.() -> Unit): VkPhysicalDeviceShadingRateImagePropertiesNV = PhysicalDeviceShadingRateImagePropertiesNV().also(block)
fun MemoryStack.PhysicalDeviceShadingRateImagePropertiesNV(capacity: Int): VkPhysicalDeviceShadingRateImagePropertiesNV.Buffer = VkPhysicalDeviceShadingRateImagePropertiesNV.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_SHADING_RATE_IMAGE_PROPERTIES_NV }
fun MemoryStack.PhysicalDeviceShadingRateImagePropertiesNV(capacity: Int, block: VkPhysicalDeviceShadingRateImagePropertiesNV.Buffer.() -> Unit): VkPhysicalDeviceShadingRateImagePropertiesNV.Buffer = PhysicalDeviceShadingRateImagePropertiesNV(capacity).also(block)

fun MemoryStack.PhysicalDeviceSparseImageFormatInfo2(): VkPhysicalDeviceSparseImageFormatInfo2 = VkPhysicalDeviceSparseImageFormatInfo2.callocStack(this).apply { sType = VkStructureType.PHYSICAL_DEVICE_SPARSE_IMAGE_FORMAT_INFO_2 }
fun MemoryStack.PhysicalDeviceSparseImageFormatInfo2(block: VkPhysicalDeviceSparseImageFormatInfo2.() -> Unit): VkPhysicalDeviceSparseImageFormatInfo2 = PhysicalDeviceSparseImageFormatInfo2().also(block)
fun MemoryStack.PhysicalDeviceSparseImageFormatInfo2(capacity: Int): VkPhysicalDeviceSparseImageFormatInfo2.Buffer = VkPhysicalDeviceSparseImageFormatInfo2.callocStack(capacity, this).onEach { it.sType = VkStructureType.PHYSICAL_DEVICE_SPARSE_IMAGE_FORMAT_INFO_2 }
fun MemoryStack.PhysicalDeviceSparseImageFormatInfo2(capacity: Int, block: VkPhysicalDeviceSparseImageFormatInfo2.Buffer.() -> Unit): VkPhysicalDeviceSparseImageFormatInfo2.Buffer = PhysicalDeviceSparseImageFormatInfo2(capacity).also(block)

fun MemoryStack.PhysicalDeviceSubgroupProperties(): VkPhysicalDeviceSubgroupProperties = VkPhysicalDeviceSubgroupProperties.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_SUBGROUP_PROPERTIES }
fun MemoryStack.PhysicalDeviceSubgroupProperties(block: VkPhysicalDeviceSubgroupProperties.() -> Unit): VkPhysicalDeviceSubgroupProperties = PhysicalDeviceSubgroupProperties().also(block)
fun MemoryStack.PhysicalDeviceSubgroupProperties(capacity: Int): VkPhysicalDeviceSubgroupProperties.Buffer = VkPhysicalDeviceSubgroupProperties.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_SUBGROUP_PROPERTIES }
fun MemoryStack.PhysicalDeviceSubgroupProperties(capacity: Int, block: VkPhysicalDeviceSubgroupProperties.Buffer.() -> Unit): VkPhysicalDeviceSubgroupProperties.Buffer = PhysicalDeviceSubgroupProperties(capacity).also(block)

fun MemoryStack.PhysicalDeviceSurfaceInfo2KHR(): VkPhysicalDeviceSurfaceInfo2KHR = VkPhysicalDeviceSurfaceInfo2KHR.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_SURFACE_INFO_2_KHR }
fun MemoryStack.PhysicalDeviceSurfaceInfo2KHR(block: VkPhysicalDeviceSurfaceInfo2KHR.() -> Unit): VkPhysicalDeviceSurfaceInfo2KHR = PhysicalDeviceSurfaceInfo2KHR().also(block)
fun MemoryStack.PhysicalDeviceSurfaceInfo2KHR(capacity: Int): VkPhysicalDeviceSurfaceInfo2KHR.Buffer = VkPhysicalDeviceSurfaceInfo2KHR.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_SURFACE_INFO_2_KHR }
fun MemoryStack.PhysicalDeviceSurfaceInfo2KHR(capacity: Int, block: VkPhysicalDeviceSurfaceInfo2KHR.Buffer.() -> Unit): VkPhysicalDeviceSurfaceInfo2KHR.Buffer = PhysicalDeviceSurfaceInfo2KHR(capacity).also(block)

fun MemoryStack.PhysicalDeviceTransformFeedbackFeaturesEXT(): VkPhysicalDeviceTransformFeedbackFeaturesEXT = VkPhysicalDeviceTransformFeedbackFeaturesEXT.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_TRANSFORM_FEEDBACK_FEATURES_EXT }
fun MemoryStack.PhysicalDeviceTransformFeedbackFeaturesEXT(block: VkPhysicalDeviceTransformFeedbackFeaturesEXT.() -> Unit): VkPhysicalDeviceTransformFeedbackFeaturesEXT = PhysicalDeviceTransformFeedbackFeaturesEXT().also(block)
fun MemoryStack.PhysicalDeviceTransformFeedbackFeaturesEXT(capacity: Int): VkPhysicalDeviceTransformFeedbackFeaturesEXT.Buffer = VkPhysicalDeviceTransformFeedbackFeaturesEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_TRANSFORM_FEEDBACK_FEATURES_EXT }
fun MemoryStack.PhysicalDeviceTransformFeedbackFeaturesEXT(capacity: Int, block: VkPhysicalDeviceTransformFeedbackFeaturesEXT.Buffer.() -> Unit): VkPhysicalDeviceTransformFeedbackFeaturesEXT.Buffer = PhysicalDeviceTransformFeedbackFeaturesEXT(capacity).also(block)

fun MemoryStack.PhysicalDeviceTransformFeedbackPropertiesEXT(): VkPhysicalDeviceTransformFeedbackPropertiesEXT = VkPhysicalDeviceTransformFeedbackPropertiesEXT.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_TRANSFORM_FEEDBACK_PROPERTIES_EXT }
fun MemoryStack.PhysicalDeviceTransformFeedbackPropertiesEXT(block: VkPhysicalDeviceTransformFeedbackPropertiesEXT.() -> Unit): VkPhysicalDeviceTransformFeedbackPropertiesEXT = PhysicalDeviceTransformFeedbackPropertiesEXT().also(block)
fun MemoryStack.PhysicalDeviceTransformFeedbackPropertiesEXT(capacity: Int): VkPhysicalDeviceTransformFeedbackPropertiesEXT.Buffer = VkPhysicalDeviceTransformFeedbackPropertiesEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_TRANSFORM_FEEDBACK_PROPERTIES_EXT }
fun MemoryStack.PhysicalDeviceTransformFeedbackPropertiesEXT(capacity: Int, block: VkPhysicalDeviceTransformFeedbackPropertiesEXT.Buffer.() -> Unit): VkPhysicalDeviceTransformFeedbackPropertiesEXT.Buffer = PhysicalDeviceTransformFeedbackPropertiesEXT(capacity).also(block)

fun MemoryStack.PhysicalDeviceVariablePointersFeatures(): VkPhysicalDeviceVariablePointersFeatures = VkPhysicalDeviceVariablePointersFeatures.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_VARIABLE_POINTER_FEATURES }
fun MemoryStack.PhysicalDeviceVariablePointersFeatures(block: VkPhysicalDeviceVariablePointersFeatures.() -> Unit): VkPhysicalDeviceVariablePointersFeatures = PhysicalDeviceVariablePointersFeatures().also(block)
fun MemoryStack.PhysicalDeviceVariablePointersFeatures(capacity: Int): VkPhysicalDeviceVariablePointersFeatures.Buffer = VkPhysicalDeviceVariablePointersFeatures.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_VARIABLE_POINTER_FEATURES }
fun MemoryStack.PhysicalDeviceVariablePointersFeatures(capacity: Int, block: VkPhysicalDeviceVariablePointersFeatures.Buffer.() -> Unit): VkPhysicalDeviceVariablePointersFeatures.Buffer = PhysicalDeviceVariablePointersFeatures(capacity).also(block)

fun MemoryStack.PhysicalDeviceVertexAttributeDivisorFeaturesEXT(): VkPhysicalDeviceVertexAttributeDivisorFeaturesEXT = VkPhysicalDeviceVertexAttributeDivisorFeaturesEXT.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_VERTEX_ATTRIBUTE_DIVISOR_FEATURES_EXT }
fun MemoryStack.PhysicalDeviceVertexAttributeDivisorFeaturesEXT(block: VkPhysicalDeviceVertexAttributeDivisorFeaturesEXT.() -> Unit): VkPhysicalDeviceVertexAttributeDivisorFeaturesEXT = PhysicalDeviceVertexAttributeDivisorFeaturesEXT().also(block)
fun MemoryStack.PhysicalDeviceVertexAttributeDivisorFeaturesEXT(capacity: Int): VkPhysicalDeviceVertexAttributeDivisorFeaturesEXT.Buffer = VkPhysicalDeviceVertexAttributeDivisorFeaturesEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_VERTEX_ATTRIBUTE_DIVISOR_FEATURES_EXT }
fun MemoryStack.PhysicalDeviceVertexAttributeDivisorFeaturesEXT(capacity: Int, block: VkPhysicalDeviceVertexAttributeDivisorFeaturesEXT.Buffer.() -> Unit): VkPhysicalDeviceVertexAttributeDivisorFeaturesEXT.Buffer = PhysicalDeviceVertexAttributeDivisorFeaturesEXT(capacity).also(block)

fun MemoryStack.PhysicalDeviceVertexAttributeDivisorPropertiesEXT(): VkPhysicalDeviceVertexAttributeDivisorPropertiesEXT = VkPhysicalDeviceVertexAttributeDivisorPropertiesEXT.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_VERTEX_ATTRIBUTE_DIVISOR_PROPERTIES_EXT }
fun MemoryStack.PhysicalDeviceVertexAttributeDivisorPropertiesEXT(block: VkPhysicalDeviceVertexAttributeDivisorPropertiesEXT.() -> Unit): VkPhysicalDeviceVertexAttributeDivisorPropertiesEXT = PhysicalDeviceVertexAttributeDivisorPropertiesEXT().also(block)
fun MemoryStack.PhysicalDeviceVertexAttributeDivisorPropertiesEXT(capacity: Int): VkPhysicalDeviceVertexAttributeDivisorPropertiesEXT.Buffer = VkPhysicalDeviceVertexAttributeDivisorPropertiesEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_VERTEX_ATTRIBUTE_DIVISOR_PROPERTIES_EXT }
fun MemoryStack.PhysicalDeviceVertexAttributeDivisorPropertiesEXT(capacity: Int, block: VkPhysicalDeviceVertexAttributeDivisorPropertiesEXT.Buffer.() -> Unit): VkPhysicalDeviceVertexAttributeDivisorPropertiesEXT.Buffer = PhysicalDeviceVertexAttributeDivisorPropertiesEXT(capacity).also(block)

fun MemoryStack.PhysicalDeviceVulkanMemoryModelFeaturesKHR(): VkPhysicalDeviceVulkanMemoryModelFeaturesKHR = VkPhysicalDeviceVulkanMemoryModelFeaturesKHR.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_VULKAN_MEMORY_MODEL_FEATURES_KHR }
fun MemoryStack.PhysicalDeviceVulkanMemoryModelFeaturesKHR(block: VkPhysicalDeviceVulkanMemoryModelFeaturesKHR.() -> Unit): VkPhysicalDeviceVulkanMemoryModelFeaturesKHR = PhysicalDeviceVulkanMemoryModelFeaturesKHR().also(block)
fun MemoryStack.PhysicalDeviceVulkanMemoryModelFeaturesKHR(capacity: Int): VkPhysicalDeviceVulkanMemoryModelFeaturesKHR.Buffer = VkPhysicalDeviceVulkanMemoryModelFeaturesKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_VULKAN_MEMORY_MODEL_FEATURES_KHR }
fun MemoryStack.PhysicalDeviceVulkanMemoryModelFeaturesKHR(capacity: Int, block: VkPhysicalDeviceVulkanMemoryModelFeaturesKHR.Buffer.() -> Unit): VkPhysicalDeviceVulkanMemoryModelFeaturesKHR.Buffer = PhysicalDeviceVulkanMemoryModelFeaturesKHR(capacity).also(block)

fun MemoryStack.PhysicalDeviceYcbcrImageArraysFeaturesEXT(): VkPhysicalDeviceYcbcrImageArraysFeaturesEXT = VkPhysicalDeviceYcbcrImageArraysFeaturesEXT.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_YCBCR_IMAGE_ARRAYS_FEATURES_EXT }
fun MemoryStack.PhysicalDeviceYcbcrImageArraysFeaturesEXT(block: VkPhysicalDeviceYcbcrImageArraysFeaturesEXT.() -> Unit): VkPhysicalDeviceYcbcrImageArraysFeaturesEXT = PhysicalDeviceYcbcrImageArraysFeaturesEXT().also(block)
fun MemoryStack.PhysicalDeviceYcbcrImageArraysFeaturesEXT(capacity: Int): VkPhysicalDeviceYcbcrImageArraysFeaturesEXT.Buffer = VkPhysicalDeviceYcbcrImageArraysFeaturesEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_YCBCR_IMAGE_ARRAYS_FEATURES_EXT }
fun MemoryStack.PhysicalDeviceYcbcrImageArraysFeaturesEXT(capacity: Int, block: VkPhysicalDeviceYcbcrImageArraysFeaturesEXT.Buffer.() -> Unit): VkPhysicalDeviceYcbcrImageArraysFeaturesEXT.Buffer = PhysicalDeviceYcbcrImageArraysFeaturesEXT(capacity).also(block)

fun MemoryStack.PipelineCacheCreateInfo(): VkPipelineCacheCreateInfo = VkPipelineCacheCreateInfo.callocStack(this).apply { type = VkStructureType.PIPELINE_CACHE_CREATE_INFO }
fun MemoryStack.PipelineCacheCreateInfo(block: VkPipelineCacheCreateInfo.() -> Unit): VkPipelineCacheCreateInfo = PipelineCacheCreateInfo().also(block)
fun MemoryStack.PipelineCacheCreateInfo(capacity: Int): VkPipelineCacheCreateInfo.Buffer = VkPipelineCacheCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_CACHE_CREATE_INFO }
fun MemoryStack.PipelineCacheCreateInfo(capacity: Int, block: VkPipelineCacheCreateInfo.Buffer.() -> Unit): VkPipelineCacheCreateInfo.Buffer = PipelineCacheCreateInfo(capacity).also(block)

fun MemoryStack.PipelineColorBlendAdvancedStateCreateInfoEXT(): VkPipelineColorBlendAdvancedStateCreateInfoEXT = VkPipelineColorBlendAdvancedStateCreateInfoEXT.callocStack(this).apply { type = VkStructureType.PIPELINE_COLOR_BLEND_ADVANCED_STATE_CREATE_INFO_EXT }
fun MemoryStack.PipelineColorBlendAdvancedStateCreateInfoEXT(block: VkPipelineColorBlendAdvancedStateCreateInfoEXT.() -> Unit): VkPipelineColorBlendAdvancedStateCreateInfoEXT = PipelineColorBlendAdvancedStateCreateInfoEXT().also(block)
fun MemoryStack.PipelineColorBlendAdvancedStateCreateInfoEXT(capacity: Int): VkPipelineColorBlendAdvancedStateCreateInfoEXT.Buffer = VkPipelineColorBlendAdvancedStateCreateInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_COLOR_BLEND_ADVANCED_STATE_CREATE_INFO_EXT }
fun MemoryStack.PipelineColorBlendAdvancedStateCreateInfoEXT(capacity: Int, block: VkPipelineColorBlendAdvancedStateCreateInfoEXT.Buffer.() -> Unit): VkPipelineColorBlendAdvancedStateCreateInfoEXT.Buffer = PipelineColorBlendAdvancedStateCreateInfoEXT(capacity).also(block)

fun MemoryStack.PipelineColorBlendAttachmentState(): VkPipelineColorBlendAttachmentState = VkPipelineColorBlendAttachmentState.callocStack(this)
fun MemoryStack.PipelineColorBlendAttachmentState(block: VkPipelineColorBlendAttachmentState.() -> Unit): VkPipelineColorBlendAttachmentState = PipelineColorBlendAttachmentState().also(block)
fun MemoryStack.PipelineColorBlendAttachmentState(capacity: Int): VkPipelineColorBlendAttachmentState.Buffer = VkPipelineColorBlendAttachmentState.callocStack(capacity, this)
fun MemoryStack.PipelineColorBlendAttachmentState(capacity: Int, block: VkPipelineColorBlendAttachmentState.Buffer.() -> Unit): VkPipelineColorBlendAttachmentState.Buffer = PipelineColorBlendAttachmentState(capacity).also(block)

fun MemoryStack.PipelineColorBlendStateCreateInfo(): VkPipelineColorBlendStateCreateInfo = VkPipelineColorBlendStateCreateInfo.callocStack(this).apply { type = VkStructureType.PIPELINE_COLOR_BLEND_STATE_CREATE_INFO }
fun MemoryStack.PipelineColorBlendStateCreateInfo(block: VkPipelineColorBlendStateCreateInfo.() -> Unit): VkPipelineColorBlendStateCreateInfo = PipelineColorBlendStateCreateInfo().also(block)
fun MemoryStack.PipelineColorBlendStateCreateInfo(capacity: Int): VkPipelineColorBlendStateCreateInfo.Buffer = VkPipelineColorBlendStateCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_COLOR_BLEND_STATE_CREATE_INFO }
fun MemoryStack.PipelineColorBlendStateCreateInfo(capacity: Int, block: VkPipelineColorBlendStateCreateInfo.Buffer.() -> Unit): VkPipelineColorBlendStateCreateInfo.Buffer = PipelineColorBlendStateCreateInfo(capacity).also(block)

fun MemoryStack.PipelineCoverageModulationStateCreateInfoNV(): VkPipelineCoverageModulationStateCreateInfoNV = VkPipelineCoverageModulationStateCreateInfoNV.callocStack(this).apply { type = VkStructureType.PIPELINE_COVERAGE_MODULATION_STATE_CREATE_INFO_NV }
fun MemoryStack.PipelineCoverageModulationStateCreateInfoNV(block: VkPipelineCoverageModulationStateCreateInfoNV.() -> Unit): VkPipelineCoverageModulationStateCreateInfoNV = PipelineCoverageModulationStateCreateInfoNV().also(block)
fun MemoryStack.PipelineCoverageModulationStateCreateInfoNV(capacity: Int): VkPipelineCoverageModulationStateCreateInfoNV.Buffer = VkPipelineCoverageModulationStateCreateInfoNV.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_COVERAGE_MODULATION_STATE_CREATE_INFO_NV }
fun MemoryStack.PipelineCoverageModulationStateCreateInfoNV(capacity: Int, block: VkPipelineCoverageModulationStateCreateInfoNV.Buffer.() -> Unit): VkPipelineCoverageModulationStateCreateInfoNV.Buffer = PipelineCoverageModulationStateCreateInfoNV(capacity).also(block)

fun MemoryStack.PipelineCoverageToColorStateCreateInfoNV(): VkPipelineCoverageToColorStateCreateInfoNV = VkPipelineCoverageToColorStateCreateInfoNV.callocStack(this).apply { type = VkStructureType.PIPELINE_COVERAGE_TO_COLOR_STATE_CREATE_INFO_NV }
fun MemoryStack.PipelineCoverageToColorStateCreateInfoNV(block: VkPipelineCoverageToColorStateCreateInfoNV.() -> Unit): VkPipelineCoverageToColorStateCreateInfoNV = PipelineCoverageToColorStateCreateInfoNV().also(block)
fun MemoryStack.PipelineCoverageToColorStateCreateInfoNV(capacity: Int): VkPipelineCoverageToColorStateCreateInfoNV.Buffer = VkPipelineCoverageToColorStateCreateInfoNV.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_COVERAGE_TO_COLOR_STATE_CREATE_INFO_NV }
fun MemoryStack.PipelineCoverageToColorStateCreateInfoNV(capacity: Int, block: VkPipelineCoverageToColorStateCreateInfoNV.Buffer.() -> Unit): VkPipelineCoverageToColorStateCreateInfoNV.Buffer = PipelineCoverageToColorStateCreateInfoNV(capacity).also(block)

//fun MemoryStack.PipelineCreationFeedbackEXT(): VkPipelineCreationFeedbackEXT = VkPipelineCreationFeedbackEXT.callocStack(this)
//fun MemoryStack.PipelineCreationFeedbackEXT(block: VkPipelineCreationFeedbackEXT .() -> Unit): VkPipelineCreationFeedbackEXT = PipelineCreationFeedbackEXT().also(block)
//fun MemoryStack.PipelineCreationFeedbackEXT(capacity: Int): VkPipelineCreationFeedbackEXT.Buffer = VkPipelineCreationFeedbackEXT.callocStack(capacity, this)
//fun MemoryStack.PipelineCreationFeedbackEXT(capacity: Int, block: VkPipelineCreationFeedbackEXT.Buffer.() -> Unit): VkPipelineCreationFeedbackEXT.Buffer = PipelineCreationFeedbackEXT(capacity).also(block)

fun MemoryStack.PipelineCreationFeedbackCreateInfoEXT(): VkPipelineCreationFeedbackCreateInfoEXT = VkPipelineCreationFeedbackCreateInfoEXT.callocStack(this).apply { type = VkStructureType.PIPELINE_CREATION_FEEDBACK_CREATE_INFO_EXT }
fun MemoryStack.PipelineCreationFeedbackCreateInfoEXT(block: VkPipelineCreationFeedbackCreateInfoEXT  .() -> Unit): VkPipelineCreationFeedbackCreateInfoEXT = PipelineCreationFeedbackCreateInfoEXT().also(block)
fun MemoryStack.PipelineCreationFeedbackCreateInfoEXT(capacity: Int): VkPipelineCreationFeedbackCreateInfoEXT.Buffer = VkPipelineCreationFeedbackCreateInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_CREATION_FEEDBACK_CREATE_INFO_EXT }
fun MemoryStack.PipelineCreationFeedbackCreateInfoEXT(capacity: Int, block: VkPipelineCreationFeedbackCreateInfoEXT.Buffer.() -> Unit): VkPipelineCreationFeedbackCreateInfoEXT.Buffer = PipelineCreationFeedbackCreateInfoEXT(capacity).also(block)

fun MemoryStack.PipelineDepthStencilStateCreateInfo(): VkPipelineDepthStencilStateCreateInfo = VkPipelineDepthStencilStateCreateInfo.callocStack(this).apply { type = VkStructureType.PIPELINE_DEPTH_STENCIL_STATE_CREATE_INFO }
fun MemoryStack.PipelineDepthStencilStateCreateInfo(block: VkPipelineDepthStencilStateCreateInfo.() -> Unit): VkPipelineDepthStencilStateCreateInfo = PipelineDepthStencilStateCreateInfo().also(block)
fun MemoryStack.PipelineDepthStencilStateCreateInfo(capacity: Int): VkPipelineDepthStencilStateCreateInfo.Buffer = VkPipelineDepthStencilStateCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_DEPTH_STENCIL_STATE_CREATE_INFO }
fun MemoryStack.PipelineDepthStencilStateCreateInfo(capacity: Int, block: VkPipelineDepthStencilStateCreateInfo.Buffer.() -> Unit): VkPipelineDepthStencilStateCreateInfo.Buffer = PipelineDepthStencilStateCreateInfo(capacity).also(block)

fun MemoryStack.PipelineDiscardRectangleStateCreateInfoEXT(): VkPipelineDiscardRectangleStateCreateInfoEXT = VkPipelineDiscardRectangleStateCreateInfoEXT.callocStack(this).apply { type = VkStructureType.PIPELINE_DISCARD_RECTANGLE_STATE_CREATE_INFO_EXT }
fun MemoryStack.PipelineDiscardRectangleStateCreateInfoEXT(block: VkPipelineDiscardRectangleStateCreateInfoEXT.() -> Unit): VkPipelineDiscardRectangleStateCreateInfoEXT = PipelineDiscardRectangleStateCreateInfoEXT().also(block)
fun MemoryStack.PipelineDiscardRectangleStateCreateInfoEXT(capacity: Int): VkPipelineDiscardRectangleStateCreateInfoEXT.Buffer = VkPipelineDiscardRectangleStateCreateInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_DISCARD_RECTANGLE_STATE_CREATE_INFO_EXT }
fun MemoryStack.PipelineDiscardRectangleStateCreateInfoEXT(capacity: Int, block: VkPipelineDiscardRectangleStateCreateInfoEXT.Buffer.() -> Unit): VkPipelineDiscardRectangleStateCreateInfoEXT.Buffer = PipelineDiscardRectangleStateCreateInfoEXT(capacity).also(block)

fun MemoryStack.PipelineDynamicStateCreateInfo(): VkPipelineDynamicStateCreateInfo = VkPipelineDynamicStateCreateInfo.callocStack(this).apply { type = VkStructureType.PIPELINE_DYNAMIC_STATE_CREATE_INFO }
fun MemoryStack.PipelineDynamicStateCreateInfo(block: VkPipelineDynamicStateCreateInfo.() -> Unit): VkPipelineDynamicStateCreateInfo = PipelineDynamicStateCreateInfo().also(block)
fun MemoryStack.PipelineDynamicStateCreateInfo(capacity: Int): VkPipelineDynamicStateCreateInfo.Buffer = VkPipelineDynamicStateCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_DYNAMIC_STATE_CREATE_INFO }
fun MemoryStack.PipelineDynamicStateCreateInfo(capacity: Int, block: VkPipelineDynamicStateCreateInfo.Buffer.() -> Unit): VkPipelineDynamicStateCreateInfo.Buffer = PipelineDynamicStateCreateInfo(capacity).also(block)

fun MemoryStack.PipelineInputAssemblyStateCreateInfo(): VkPipelineInputAssemblyStateCreateInfo = VkPipelineInputAssemblyStateCreateInfo.callocStack(this).apply { type = VkStructureType.PIPELINE_INPUT_ASSEMBLY_STATE_CREATE_INFO }
fun MemoryStack.PipelineInputAssemblyStateCreateInfo(block: VkPipelineInputAssemblyStateCreateInfo.() -> Unit): VkPipelineInputAssemblyStateCreateInfo = PipelineInputAssemblyStateCreateInfo().also(block)
fun MemoryStack.PipelineInputAssemblyStateCreateInfo(capacity: Int): VkPipelineInputAssemblyStateCreateInfo.Buffer = VkPipelineInputAssemblyStateCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_INPUT_ASSEMBLY_STATE_CREATE_INFO }
fun MemoryStack.PipelineInputAssemblyStateCreateInfo(capacity: Int, block: VkPipelineInputAssemblyStateCreateInfo.Buffer.() -> Unit): VkPipelineInputAssemblyStateCreateInfo.Buffer = PipelineInputAssemblyStateCreateInfo(capacity).also(block)

fun MemoryStack.PipelineLayoutCreateInfo(): VkPipelineLayoutCreateInfo = VkPipelineLayoutCreateInfo.callocStack(this).apply { type = VkStructureType.PIPELINE_LAYOUT_CREATE_INFO }
fun MemoryStack.PipelineLayoutCreateInfo(block: VkPipelineLayoutCreateInfo.() -> Unit): VkPipelineLayoutCreateInfo = PipelineLayoutCreateInfo().also(block)
fun MemoryStack.PipelineLayoutCreateInfo(capacity: Int): VkPipelineLayoutCreateInfo.Buffer = VkPipelineLayoutCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_LAYOUT_CREATE_INFO }
fun MemoryStack.PipelineLayoutCreateInfo(capacity: Int, block: VkPipelineLayoutCreateInfo.Buffer.() -> Unit): VkPipelineLayoutCreateInfo.Buffer = PipelineLayoutCreateInfo(capacity).also(block)

fun MemoryStack.PipelineMultisampleStateCreateInfo(): VkPipelineMultisampleStateCreateInfo = VkPipelineMultisampleStateCreateInfo.callocStack(this).apply { type = VkStructureType.PIPELINE_MULTISAMPLE_STATE_CREATE_INFO }
fun MemoryStack.PipelineMultisampleStateCreateInfo(block: VkPipelineMultisampleStateCreateInfo.() -> Unit): VkPipelineMultisampleStateCreateInfo = PipelineMultisampleStateCreateInfo().also(block)
fun MemoryStack.PipelineMultisampleStateCreateInfo(capacity: Int): VkPipelineMultisampleStateCreateInfo.Buffer = VkPipelineMultisampleStateCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_MULTISAMPLE_STATE_CREATE_INFO }
fun MemoryStack.PipelineMultisampleStateCreateInfo(capacity: Int, block: VkPipelineMultisampleStateCreateInfo.Buffer.() -> Unit): VkPipelineMultisampleStateCreateInfo.Buffer = PipelineMultisampleStateCreateInfo(capacity).also(block)

fun MemoryStack.PipelineRasterizationConservativeStateCreateInfoEXT(): VkPipelineRasterizationConservativeStateCreateInfoEXT = VkPipelineRasterizationConservativeStateCreateInfoEXT.callocStack(this).apply { type = VkStructureType.PIPELINE_RASTERIZATION_CONSERVATIVE_STATE_CREATE_INFO_EXT }
fun MemoryStack.PipelineRasterizationConservativeStateCreateInfoEXT(block: VkPipelineRasterizationConservativeStateCreateInfoEXT.() -> Unit): VkPipelineRasterizationConservativeStateCreateInfoEXT = PipelineRasterizationConservativeStateCreateInfoEXT().also(block)
fun MemoryStack.PipelineRasterizationConservativeStateCreateInfoEXT(capacity: Int): VkPipelineRasterizationConservativeStateCreateInfoEXT.Buffer = VkPipelineRasterizationConservativeStateCreateInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_RASTERIZATION_CONSERVATIVE_STATE_CREATE_INFO_EXT }
fun MemoryStack.PipelineRasterizationConservativeStateCreateInfoEXT(capacity: Int, block: VkPipelineRasterizationConservativeStateCreateInfoEXT.Buffer.() -> Unit): VkPipelineRasterizationConservativeStateCreateInfoEXT.Buffer = PipelineRasterizationConservativeStateCreateInfoEXT(capacity).also(block)

fun MemoryStack.PipelineRasterizationDepthClipStateCreateInfoEXT(): VkPipelineRasterizationDepthClipStateCreateInfoEXT = VkPipelineRasterizationDepthClipStateCreateInfoEXT.callocStack(this).apply { type = VkStructureType.PIPELINE_RASTERIZATION_DEPTH_CLIP_STATE_CREATE_INFO_EXT }
fun MemoryStack.PipelineRasterizationDepthClipStateCreateInfoEXT(block: VkPipelineRasterizationDepthClipStateCreateInfoEXT.() -> Unit): VkPipelineRasterizationDepthClipStateCreateInfoEXT = PipelineRasterizationDepthClipStateCreateInfoEXT().also(block)
fun MemoryStack.PipelineRasterizationDepthClipStateCreateInfoEXT(capacity: Int): VkPipelineRasterizationDepthClipStateCreateInfoEXT.Buffer = VkPipelineRasterizationDepthClipStateCreateInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_RASTERIZATION_DEPTH_CLIP_STATE_CREATE_INFO_EXT }
fun MemoryStack.PipelineRasterizationDepthClipStateCreateInfoEXT(capacity: Int, block: VkPipelineRasterizationDepthClipStateCreateInfoEXT.Buffer.() -> Unit): VkPipelineRasterizationDepthClipStateCreateInfoEXT.Buffer = PipelineRasterizationDepthClipStateCreateInfoEXT(capacity).also(block)

fun MemoryStack.PipelineRasterizationStateCreateInfo(): VkPipelineRasterizationStateCreateInfo = VkPipelineRasterizationStateCreateInfo.callocStack(this).apply { type = VkStructureType.PIPELINE_RASTERIZATION_STATE_CREATE_INFO }
fun MemoryStack.PipelineRasterizationStateCreateInfo(block: VkPipelineRasterizationStateCreateInfo.() -> Unit): VkPipelineRasterizationStateCreateInfo = PipelineRasterizationStateCreateInfo().also(block)
fun MemoryStack.PipelineRasterizationStateCreateInfo(capacity: Int): VkPipelineRasterizationStateCreateInfo.Buffer = VkPipelineRasterizationStateCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_RASTERIZATION_STATE_CREATE_INFO }
fun MemoryStack.PipelineRasterizationStateCreateInfo(capacity: Int, block: VkPipelineRasterizationStateCreateInfo.Buffer.() -> Unit): VkPipelineRasterizationStateCreateInfo.Buffer = PipelineRasterizationStateCreateInfo(capacity).also(block)

fun MemoryStack.PipelineRasterizationStateRasterizationOrderAMD(): VkPipelineRasterizationStateRasterizationOrderAMD = VkPipelineRasterizationStateRasterizationOrderAMD.callocStack(this).apply { type = VkStructureType.PIPELINE_RASTERIZATION_STATE_RASTERIZATION_ORDER_AMD }
fun MemoryStack.PipelineRasterizationStateRasterizationOrderAMD(block: VkPipelineRasterizationStateRasterizationOrderAMD.() -> Unit): VkPipelineRasterizationStateRasterizationOrderAMD = PipelineRasterizationStateRasterizationOrderAMD().also(block)
fun MemoryStack.PipelineRasterizationStateRasterizationOrderAMD(capacity: Int): VkPipelineRasterizationStateRasterizationOrderAMD.Buffer = VkPipelineRasterizationStateRasterizationOrderAMD.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_RASTERIZATION_STATE_RASTERIZATION_ORDER_AMD }
fun MemoryStack.PipelineRasterizationStateRasterizationOrderAMD(capacity: Int, block: VkPipelineRasterizationStateRasterizationOrderAMD.Buffer.() -> Unit): VkPipelineRasterizationStateRasterizationOrderAMD.Buffer = PipelineRasterizationStateRasterizationOrderAMD(capacity).also(block)

fun MemoryStack.PipelineRasterizationStateStreamCreateInfoEXT(): VkPipelineRasterizationStateStreamCreateInfoEXT = VkPipelineRasterizationStateStreamCreateInfoEXT.callocStack(this).apply { type = VkStructureType.PIPELINE_RASTERIZATION_STATE_STREAM_CREATE_INFO_EXT }
fun MemoryStack.PipelineRasterizationStateStreamCreateInfoEXT(block: VkPipelineRasterizationStateStreamCreateInfoEXT.() -> Unit): VkPipelineRasterizationStateStreamCreateInfoEXT = PipelineRasterizationStateStreamCreateInfoEXT().also(block)
fun MemoryStack.PipelineRasterizationStateStreamCreateInfoEXT(capacity: Int): VkPipelineRasterizationStateStreamCreateInfoEXT.Buffer = VkPipelineRasterizationStateStreamCreateInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_RASTERIZATION_STATE_STREAM_CREATE_INFO_EXT }
fun MemoryStack.PipelineRasterizationStateStreamCreateInfoEXT(capacity: Int, block: VkPipelineRasterizationStateStreamCreateInfoEXT.Buffer.() -> Unit): VkPipelineRasterizationStateStreamCreateInfoEXT.Buffer = PipelineRasterizationStateStreamCreateInfoEXT(capacity).also(block)

fun MemoryStack.PipelineRepresentativeFragmentTestStateCreateInfoNV(): VkPipelineRepresentativeFragmentTestStateCreateInfoNV = VkPipelineRepresentativeFragmentTestStateCreateInfoNV.callocStack(this).apply { type = VkStructureType.PIPELINE_REPRESENTATIVE_FRAGMENT_TEST_STATE_CREATE_INFO_NV }
fun MemoryStack.PipelineRepresentativeFragmentTestStateCreateInfoNV(block: VkPipelineRepresentativeFragmentTestStateCreateInfoNV.() -> Unit): VkPipelineRepresentativeFragmentTestStateCreateInfoNV = PipelineRepresentativeFragmentTestStateCreateInfoNV().also(block)
fun MemoryStack.PipelineRepresentativeFragmentTestStateCreateInfoNV(capacity: Int): VkPipelineRepresentativeFragmentTestStateCreateInfoNV.Buffer = VkPipelineRepresentativeFragmentTestStateCreateInfoNV.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_REPRESENTATIVE_FRAGMENT_TEST_STATE_CREATE_INFO_NV }
fun MemoryStack.PipelineRepresentativeFragmentTestStateCreateInfoNV(capacity: Int, block: VkPipelineRepresentativeFragmentTestStateCreateInfoNV.Buffer.() -> Unit): VkPipelineRepresentativeFragmentTestStateCreateInfoNV.Buffer = PipelineRepresentativeFragmentTestStateCreateInfoNV(capacity).also(block)

fun MemoryStack.PipelineSampleLocationsStateCreateInfoEXT(): VkPipelineSampleLocationsStateCreateInfoEXT = VkPipelineSampleLocationsStateCreateInfoEXT.callocStack(this).apply { type = VkStructureType.PIPELINE_SAMPLE_LOCATIONS_STATE_CREATE_INFO_EXT }
fun MemoryStack.PipelineSampleLocationsStateCreateInfoEXT(block: VkPipelineSampleLocationsStateCreateInfoEXT.() -> Unit): VkPipelineSampleLocationsStateCreateInfoEXT = PipelineSampleLocationsStateCreateInfoEXT().also(block)
fun MemoryStack.PipelineSampleLocationsStateCreateInfoEXT(capacity: Int): VkPipelineSampleLocationsStateCreateInfoEXT.Buffer = VkPipelineSampleLocationsStateCreateInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_SAMPLE_LOCATIONS_STATE_CREATE_INFO_EXT }
fun MemoryStack.PipelineSampleLocationsStateCreateInfoEXT(capacity: Int, block: VkPipelineSampleLocationsStateCreateInfoEXT.Buffer.() -> Unit): VkPipelineSampleLocationsStateCreateInfoEXT.Buffer = PipelineSampleLocationsStateCreateInfoEXT(capacity).also(block)

fun MemoryStack.PipelineTessellationDomainOriginStateCreateInfo(): VkPipelineTessellationDomainOriginStateCreateInfo = VkPipelineTessellationDomainOriginStateCreateInfo.callocStack(this).apply { type = VkStructureType.PIPELINE_TESSELLATION_DOMAIN_ORIGIN_STATE_CREATE_INFO }
fun MemoryStack.PipelineTessellationDomainOriginStateCreateInfo(block: VkPipelineTessellationDomainOriginStateCreateInfo.() -> Unit): VkPipelineTessellationDomainOriginStateCreateInfo = PipelineTessellationDomainOriginStateCreateInfo().also(block)
fun MemoryStack.PipelineTessellationDomainOriginStateCreateInfo(capacity: Int): VkPipelineTessellationDomainOriginStateCreateInfo.Buffer = VkPipelineTessellationDomainOriginStateCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_TESSELLATION_DOMAIN_ORIGIN_STATE_CREATE_INFO }
fun MemoryStack.PipelineTessellationDomainOriginStateCreateInfo(capacity: Int, block: VkPipelineTessellationDomainOriginStateCreateInfo.Buffer.() -> Unit): VkPipelineTessellationDomainOriginStateCreateInfo.Buffer = PipelineTessellationDomainOriginStateCreateInfo(capacity).also(block)

fun MemoryStack.PipelineShaderStageCreateInfo(): VkPipelineShaderStageCreateInfo = VkPipelineShaderStageCreateInfo.callocStack(this).apply { type = VkStructureType.PIPELINE_SHADER_STAGE_CREATE_INFO }
fun MemoryStack.PipelineShaderStageCreateInfo(block: VkPipelineShaderStageCreateInfo.() -> Unit): VkPipelineShaderStageCreateInfo = PipelineShaderStageCreateInfo().also(block)
fun MemoryStack.PipelineShaderStageCreateInfo(capacity: Int): VkPipelineShaderStageCreateInfo.Buffer = VkPipelineShaderStageCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_SHADER_STAGE_CREATE_INFO }
fun MemoryStack.PipelineShaderStageCreateInfo(capacity: Int, block: VkPipelineShaderStageCreateInfo.Buffer.() -> Unit): VkPipelineShaderStageCreateInfo.Buffer = PipelineShaderStageCreateInfo(capacity).also(block)

fun MemoryStack.PipelineTessellationStateCreateInfo(): VkPipelineTessellationStateCreateInfo = VkPipelineTessellationStateCreateInfo.callocStack(this).apply { type = VkStructureType.PIPELINE_TESSELLATION_STATE_CREATE_INFO }
fun MemoryStack.PipelineTessellationStateCreateInfo(block: VkPipelineTessellationStateCreateInfo.() -> Unit): VkPipelineTessellationStateCreateInfo = PipelineTessellationStateCreateInfo().also(block)
fun MemoryStack.PipelineTessellationStateCreateInfo(capacity: Int): VkPipelineTessellationStateCreateInfo.Buffer = VkPipelineTessellationStateCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_TESSELLATION_STATE_CREATE_INFO }
fun MemoryStack.PipelineTessellationStateCreateInfo(capacity: Int, block: VkPipelineTessellationStateCreateInfo.Buffer.() -> Unit): VkPipelineTessellationStateCreateInfo.Buffer = PipelineTessellationStateCreateInfo(capacity).also(block)

fun MemoryStack.PipelineVertexInputDivisorStateCreateInfoEXT(): VkPipelineVertexInputDivisorStateCreateInfoEXT = VkPipelineVertexInputDivisorStateCreateInfoEXT.callocStack(this).apply { type = VkStructureType.PIPELINE_VERTEX_INPUT_DIVISOR_STATE_CREATE_INFO_EXT }
fun MemoryStack.PipelineVertexInputDivisorStateCreateInfoEXT(block: VkPipelineVertexInputDivisorStateCreateInfoEXT.() -> Unit): VkPipelineVertexInputDivisorStateCreateInfoEXT = PipelineVertexInputDivisorStateCreateInfoEXT().also(block)
fun MemoryStack.PipelineVertexInputDivisorStateCreateInfoEXT(capacity: Int): VkPipelineVertexInputDivisorStateCreateInfoEXT.Buffer = VkPipelineVertexInputDivisorStateCreateInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_VERTEX_INPUT_DIVISOR_STATE_CREATE_INFO_EXT }
fun MemoryStack.PipelineVertexInputDivisorStateCreateInfoEXT(capacity: Int, block: VkPipelineVertexInputDivisorStateCreateInfoEXT.Buffer.() -> Unit): VkPipelineVertexInputDivisorStateCreateInfoEXT.Buffer = PipelineVertexInputDivisorStateCreateInfoEXT(capacity).also(block)

fun MemoryStack.PipelineVertexInputStateCreateInfo(): VkPipelineVertexInputStateCreateInfo = VkPipelineVertexInputStateCreateInfo.callocStack(this).apply { type = VkStructureType.PIPELINE_VERTEX_INPUT_STATE_CREATE_INFO }
fun MemoryStack.PipelineVertexInputStateCreateInfo(block: VkPipelineVertexInputStateCreateInfo.() -> Unit): VkPipelineVertexInputStateCreateInfo = PipelineVertexInputStateCreateInfo().also(block)
fun MemoryStack.PipelineVertexInputStateCreateInfo(capacity: Int): VkPipelineVertexInputStateCreateInfo.Buffer = VkPipelineVertexInputStateCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_VERTEX_INPUT_STATE_CREATE_INFO }
fun MemoryStack.PipelineVertexInputStateCreateInfo(capacity: Int, block: VkPipelineVertexInputStateCreateInfo.Buffer.() -> Unit): VkPipelineVertexInputStateCreateInfo.Buffer = PipelineVertexInputStateCreateInfo(capacity).also(block)

fun MemoryStack.PipelineViewportCoarseSampleOrderStateCreateInfoNV(): VkPipelineViewportCoarseSampleOrderStateCreateInfoNV = VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.callocStack(this).apply { type = VkStructureType.PIPELINE_VIEWPORT_COARSE_SAMPLE_ORDER_STATE_CREATE_INFO_NV }
fun MemoryStack.PipelineViewportCoarseSampleOrderStateCreateInfoNV(block: VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.() -> Unit): VkPipelineViewportCoarseSampleOrderStateCreateInfoNV = PipelineViewportCoarseSampleOrderStateCreateInfoNV().also(block)
fun MemoryStack.PipelineViewportCoarseSampleOrderStateCreateInfoNV(capacity: Int): VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.Buffer = VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_VIEWPORT_COARSE_SAMPLE_ORDER_STATE_CREATE_INFO_NV }
fun MemoryStack.PipelineViewportCoarseSampleOrderStateCreateInfoNV(capacity: Int, block: VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.Buffer.() -> Unit): VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.Buffer = PipelineViewportCoarseSampleOrderStateCreateInfoNV(capacity).also(block)

fun MemoryStack.PipelineViewportExclusiveScissorStateCreateInfoNV(): VkPipelineViewportExclusiveScissorStateCreateInfoNV = VkPipelineViewportExclusiveScissorStateCreateInfoNV.callocStack(this).apply { type = VkStructureType.PIPELINE_VIEWPORT_EXCLUSIVE_SCISSOR_STATE_CREATE_INFO_NV }
fun MemoryStack.PipelineViewportExclusiveScissorStateCreateInfoNV(block: VkPipelineViewportExclusiveScissorStateCreateInfoNV.() -> Unit): VkPipelineViewportExclusiveScissorStateCreateInfoNV = PipelineViewportExclusiveScissorStateCreateInfoNV().also(block)
fun MemoryStack.PipelineViewportExclusiveScissorStateCreateInfoNV(capacity: Int): VkPipelineViewportExclusiveScissorStateCreateInfoNV.Buffer = VkPipelineViewportExclusiveScissorStateCreateInfoNV.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_VIEWPORT_EXCLUSIVE_SCISSOR_STATE_CREATE_INFO_NV }
fun MemoryStack.PipelineViewportExclusiveScissorStateCreateInfoNV(capacity: Int, block: VkPipelineViewportExclusiveScissorStateCreateInfoNV.Buffer.() -> Unit): VkPipelineViewportExclusiveScissorStateCreateInfoNV.Buffer = PipelineViewportExclusiveScissorStateCreateInfoNV(capacity).also(block)

fun MemoryStack.PipelineViewportShadingRateImageStateCreateInfoNV(): VkPipelineViewportShadingRateImageStateCreateInfoNV = VkPipelineViewportShadingRateImageStateCreateInfoNV.callocStack(this).apply { type = VkStructureType.PIPELINE_VIEWPORT_SHADING_RATE_IMAGE_STATE_CREATE_INFO_NV }
fun MemoryStack.PipelineViewportShadingRateImageStateCreateInfoNV(block: VkPipelineViewportShadingRateImageStateCreateInfoNV.() -> Unit): VkPipelineViewportShadingRateImageStateCreateInfoNV = PipelineViewportShadingRateImageStateCreateInfoNV().also(block)
fun MemoryStack.PipelineViewportShadingRateImageStateCreateInfoNV(capacity: Int): VkPipelineViewportShadingRateImageStateCreateInfoNV.Buffer = VkPipelineViewportShadingRateImageStateCreateInfoNV.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_VIEWPORT_SHADING_RATE_IMAGE_STATE_CREATE_INFO_NV }
fun MemoryStack.PipelineViewportShadingRateImageStateCreateInfoNV(capacity: Int, block: VkPipelineViewportShadingRateImageStateCreateInfoNV.Buffer.() -> Unit): VkPipelineViewportShadingRateImageStateCreateInfoNV.Buffer = PipelineViewportShadingRateImageStateCreateInfoNV(capacity).also(block)

fun MemoryStack.PipelineViewportStateCreateInfo(): VkPipelineViewportStateCreateInfo = VkPipelineViewportStateCreateInfo.callocStack(this).apply { type = VkStructureType.PIPELINE_VIEWPORT_STATE_CREATE_INFO }
fun MemoryStack.PipelineViewportStateCreateInfo(block: VkPipelineViewportStateCreateInfo.() -> Unit): VkPipelineViewportStateCreateInfo = PipelineViewportStateCreateInfo().also(block)
fun MemoryStack.PipelineViewportStateCreateInfo(capacity: Int): VkPipelineViewportStateCreateInfo.Buffer = VkPipelineViewportStateCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_VIEWPORT_STATE_CREATE_INFO }
fun MemoryStack.PipelineViewportStateCreateInfo(capacity: Int, block: VkPipelineViewportStateCreateInfo.Buffer.() -> Unit): VkPipelineViewportStateCreateInfo.Buffer = PipelineViewportStateCreateInfo(capacity).also(block)

fun MemoryStack.PipelineViewportSwizzleStateCreateInfoNV(): VkPipelineViewportSwizzleStateCreateInfoNV = VkPipelineViewportSwizzleStateCreateInfoNV.callocStack(this).apply { type = VkStructureType.PIPELINE_VIEWPORT_SWIZZLE_STATE_CREATE_INFO_NV }
fun MemoryStack.PipelineViewportSwizzleStateCreateInfoNV(block: VkPipelineViewportSwizzleStateCreateInfoNV.() -> Unit): VkPipelineViewportSwizzleStateCreateInfoNV = PipelineViewportSwizzleStateCreateInfoNV().also(block)
fun MemoryStack.PipelineViewportSwizzleStateCreateInfoNV(capacity: Int): VkPipelineViewportSwizzleStateCreateInfoNV.Buffer = VkPipelineViewportSwizzleStateCreateInfoNV.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_VIEWPORT_SWIZZLE_STATE_CREATE_INFO_NV }
fun MemoryStack.PipelineViewportSwizzleStateCreateInfoNV(capacity: Int, block: VkPipelineViewportSwizzleStateCreateInfoNV.Buffer.() -> Unit): VkPipelineViewportSwizzleStateCreateInfoNV.Buffer = PipelineViewportSwizzleStateCreateInfoNV(capacity).also(block)

fun MemoryStack.PipelineViewportWScalingStateCreateInfoNV(): VkPipelineViewportWScalingStateCreateInfoNV = VkPipelineViewportWScalingStateCreateInfoNV.callocStack(this).apply { type = VkStructureType.PIPELINE_VIEWPORT_W_SCALING_STATE_CREATE_INFO_NV }
fun MemoryStack.PipelineViewportWScalingStateCreateInfoNV(block: VkPipelineViewportWScalingStateCreateInfoNV.() -> Unit): VkPipelineViewportWScalingStateCreateInfoNV = PipelineViewportWScalingStateCreateInfoNV().also(block)
fun MemoryStack.PipelineViewportWScalingStateCreateInfoNV(capacity: Int): VkPipelineViewportWScalingStateCreateInfoNV.Buffer = VkPipelineViewportWScalingStateCreateInfoNV.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_VIEWPORT_W_SCALING_STATE_CREATE_INFO_NV }
fun MemoryStack.PipelineViewportWScalingStateCreateInfoNV(capacity: Int, block: VkPipelineViewportWScalingStateCreateInfoNV.Buffer.() -> Unit): VkPipelineViewportWScalingStateCreateInfoNV.Buffer = PipelineViewportWScalingStateCreateInfoNV(capacity).also(block)

fun MemoryStack.PresentInfoKHR(): VkPresentInfoKHR = VkPresentInfoKHR.callocStack(this).apply { type = VkStructureType.PRESENT_INFO_KHR }
fun MemoryStack.PresentInfoKHR(block: VkPresentInfoKHR.() -> Unit): VkPresentInfoKHR = PresentInfoKHR().also(block)
fun MemoryStack.PresentInfoKHR(capacity: Int): VkPresentInfoKHR.Buffer = VkPresentInfoKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.PRESENT_INFO_KHR }
fun MemoryStack.PresentInfoKHR(capacity: Int, block: VkPresentInfoKHR.Buffer.() -> Unit): VkPresentInfoKHR.Buffer = PresentInfoKHR(capacity).also(block)

fun MemoryStack.PresentRegionKHR(): VkPresentRegionKHR = VkPresentRegionKHR.callocStack(this)
fun MemoryStack.PresentRegionKHR(block: VkPresentRegionKHR.() -> Unit): VkPresentRegionKHR = PresentRegionKHR().also(block)
fun MemoryStack.PresentRegionKHR(capacity: Int): VkPresentRegionKHR.Buffer = VkPresentRegionKHR.callocStack(capacity, this)
fun MemoryStack.PresentRegionKHR(capacity: Int, block: VkPresentRegionKHR.Buffer.() -> Unit): VkPresentRegionKHR.Buffer = PresentRegionKHR(capacity).also(block)

fun MemoryStack.PresentRegionsKHR(): VkPresentRegionsKHR = VkPresentRegionsKHR.callocStack(this).apply { type = VkStructureType.PRESENT_REGIONS_KHR }
fun MemoryStack.PresentRegionsKHR(block: VkPresentRegionsKHR.() -> Unit): VkPresentRegionsKHR = PresentRegionsKHR().also(block)
fun MemoryStack.PresentRegionsKHR(capacity: Int): VkPresentRegionsKHR.Buffer = VkPresentRegionsKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.PRESENT_REGIONS_KHR }
fun MemoryStack.PresentRegionsKHR(capacity: Int, block: VkPresentRegionsKHR.Buffer.() -> Unit): VkPresentRegionsKHR.Buffer = PresentRegionsKHR(capacity).also(block)

fun MemoryStack.PresentTimeGOOGLE(): VkPresentTimeGOOGLE = VkPresentTimeGOOGLE.callocStack(this)
fun MemoryStack.PresentTimeGOOGLE(block: VkPresentTimeGOOGLE.() -> Unit): VkPresentTimeGOOGLE = PresentTimeGOOGLE().also(block)
fun MemoryStack.PresentTimeGOOGLE(capacity: Int): VkPresentTimeGOOGLE.Buffer = VkPresentTimeGOOGLE.callocStack(capacity, this)
fun MemoryStack.PresentTimeGOOGLE(capacity: Int, block: VkPresentTimeGOOGLE.Buffer.() -> Unit): VkPresentTimeGOOGLE.Buffer = PresentTimeGOOGLE(capacity).also(block)

fun MemoryStack.PresentTimesInfoGOOGLE(): VkPresentTimesInfoGOOGLE = VkPresentTimesInfoGOOGLE.callocStack(this).apply { type = VkStructureType.PRESENT_TIMES_INFO_GOOGLE }
fun MemoryStack.PresentTimesInfoGOOGLE(block: VkPresentTimesInfoGOOGLE.() -> Unit): VkPresentTimesInfoGOOGLE = PresentTimesInfoGOOGLE().also(block)
fun MemoryStack.PresentTimesInfoGOOGLE(capacity: Int): VkPresentTimesInfoGOOGLE.Buffer = VkPresentTimesInfoGOOGLE.callocStack(capacity, this).onEach { it.type = VkStructureType.PRESENT_TIMES_INFO_GOOGLE }
fun MemoryStack.PresentTimesInfoGOOGLE(capacity: Int, block: VkPresentTimesInfoGOOGLE.Buffer.() -> Unit): VkPresentTimesInfoGOOGLE.Buffer = PresentTimesInfoGOOGLE(capacity).also(block)

fun MemoryStack.ProtectedSubmitInfo(): VkProtectedSubmitInfo = VkProtectedSubmitInfo.callocStack(this).apply { type = VkStructureType.PROTECTED_SUBMIT_INFO }
fun MemoryStack.ProtectedSubmitInfo(block: VkProtectedSubmitInfo.() -> Unit): VkProtectedSubmitInfo = ProtectedSubmitInfo().also(block)
fun MemoryStack.ProtectedSubmitInfo(capacity: Int): VkProtectedSubmitInfo.Buffer = VkProtectedSubmitInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.PROTECTED_SUBMIT_INFO }
fun MemoryStack.ProtectedSubmitInfo(capacity: Int, block: VkProtectedSubmitInfo.Buffer.() -> Unit): VkProtectedSubmitInfo.Buffer = ProtectedSubmitInfo(capacity).also(block)

fun MemoryStack.PushConstantRange(): VkPushConstantRange = VkPushConstantRange.callocStack(this)
fun MemoryStack.PushConstantRange(block: VkPushConstantRange.() -> Unit): VkPushConstantRange = PushConstantRange().also(block)
fun MemoryStack.PushConstantRange(capacity: Int): VkPushConstantRange.Buffer = VkPushConstantRange.callocStack(capacity, this)
fun MemoryStack.PushConstantRange(capacity: Int, block: VkPushConstantRange.Buffer.() -> Unit): VkPushConstantRange.Buffer = PushConstantRange(capacity).also(block)

fun MemoryStack.QueryPoolCreateInfo(): VkQueryPoolCreateInfo = VkQueryPoolCreateInfo.callocStack(this).apply { type = VkStructureType.QUERY_POOL_CREATE_INFO }
fun MemoryStack.QueryPoolCreateInfo(block: VkQueryPoolCreateInfo.() -> Unit): VkQueryPoolCreateInfo = QueryPoolCreateInfo().also(block)
fun MemoryStack.QueryPoolCreateInfo(capacity: Int): VkQueryPoolCreateInfo.Buffer = VkQueryPoolCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.QUERY_POOL_CREATE_INFO }
fun MemoryStack.QueryPoolCreateInfo(capacity: Int, block: VkQueryPoolCreateInfo.Buffer.() -> Unit): VkQueryPoolCreateInfo.Buffer = QueryPoolCreateInfo(capacity).also(block)

fun MemoryStack.QueueFamilyCheckpointPropertiesNV(): VkQueueFamilyCheckpointPropertiesNV = VkQueueFamilyCheckpointPropertiesNV.callocStack(this).apply { type = VkStructureType.QUEUE_FAMILY_CHECKPOINT_PROPERTIES_NV }
fun MemoryStack.QueueFamilyCheckpointPropertiesNV(block: VkQueueFamilyCheckpointPropertiesNV.() -> Unit): VkQueueFamilyCheckpointPropertiesNV = QueueFamilyCheckpointPropertiesNV().also(block)
fun MemoryStack.QueueFamilyCheckpointPropertiesNV(capacity: Int): VkQueueFamilyCheckpointPropertiesNV.Buffer = VkQueueFamilyCheckpointPropertiesNV.callocStack(capacity, this).onEach { it.type = VkStructureType.QUEUE_FAMILY_CHECKPOINT_PROPERTIES_NV }
fun MemoryStack.QueueFamilyCheckpointPropertiesNV(capacity: Int, block: VkQueueFamilyCheckpointPropertiesNV.Buffer.() -> Unit): VkQueueFamilyCheckpointPropertiesNV.Buffer = QueueFamilyCheckpointPropertiesNV(capacity).also(block)

fun MemoryStack.QueueFamilyProperties(): VkQueueFamilyProperties = VkQueueFamilyProperties.callocStack(this)
fun MemoryStack.QueueFamilyProperties(block: VkQueueFamilyProperties.() -> Unit): VkQueueFamilyProperties = QueueFamilyProperties().also(block)
fun MemoryStack.QueueFamilyProperties(capacity: Int): VkQueueFamilyProperties.Buffer = VkQueueFamilyProperties.callocStack(capacity, this)
fun MemoryStack.QueueFamilyProperties(capacity: Int, block: VkQueueFamilyProperties.Buffer.() -> Unit): VkQueueFamilyProperties.Buffer = QueueFamilyProperties(capacity).also(block)

fun MemoryStack.QueueFamilyProperties2(): VkQueueFamilyProperties2 = VkQueueFamilyProperties2.callocStack(this).apply { type = VkStructureType.QUEUE_FAMILY_PROPERTIES_2 }
fun MemoryStack.QueueFamilyProperties2(block: VkQueueFamilyProperties2.() -> Unit): VkQueueFamilyProperties2 = QueueFamilyProperties2().also(block)
fun MemoryStack.QueueFamilyProperties2(capacity: Int): VkQueueFamilyProperties2.Buffer = VkQueueFamilyProperties2.callocStack(capacity, this).onEach { it.type = VkStructureType.QUEUE_FAMILY_PROPERTIES_2 }
fun MemoryStack.QueueFamilyProperties2(capacity: Int, block: VkQueueFamilyProperties2.Buffer.() -> Unit): VkQueueFamilyProperties2.Buffer = QueueFamilyProperties2(capacity).also(block)

fun MemoryStack.RayTracingPipelineCreateInfoNV(): VkRayTracingPipelineCreateInfoNV = VkRayTracingPipelineCreateInfoNV.callocStack(this).apply { type = VkStructureType.RAY_TRACING_PIPELINE_CREATE_INFO_NV }
fun MemoryStack.RayTracingPipelineCreateInfoNV(block: VkRayTracingPipelineCreateInfoNV.() -> Unit): VkRayTracingPipelineCreateInfoNV = RayTracingPipelineCreateInfoNV().also(block)
fun MemoryStack.RayTracingPipelineCreateInfoNV(capacity: Int): VkRayTracingPipelineCreateInfoNV.Buffer = VkRayTracingPipelineCreateInfoNV.callocStack(capacity, this).onEach { it.type = VkStructureType.RAY_TRACING_PIPELINE_CREATE_INFO_NV }
fun MemoryStack.RayTracingPipelineCreateInfoNV(capacity: Int, block: VkRayTracingPipelineCreateInfoNV.Buffer.() -> Unit): VkRayTracingPipelineCreateInfoNV.Buffer = RayTracingPipelineCreateInfoNV(capacity).also(block)

fun MemoryStack.RayTracingShaderGroupCreateInfoNV(): VkRayTracingShaderGroupCreateInfoNV = VkRayTracingShaderGroupCreateInfoNV.callocStack(this).apply { sType = VkStructureType.RAY_TRACING_SHADER_GROUP_CREATE_INFO_NV }
fun MemoryStack.RayTracingShaderGroupCreateInfoNV(block: VkRayTracingShaderGroupCreateInfoNV.() -> Unit): VkRayTracingShaderGroupCreateInfoNV = RayTracingShaderGroupCreateInfoNV().also(block)
fun MemoryStack.RayTracingShaderGroupCreateInfoNV(capacity: Int): VkRayTracingShaderGroupCreateInfoNV.Buffer = VkRayTracingShaderGroupCreateInfoNV.callocStack(capacity, this).onEach { it.sType = VkStructureType.RAY_TRACING_SHADER_GROUP_CREATE_INFO_NV }
fun MemoryStack.RayTracingShaderGroupCreateInfoNV(capacity: Int, block: VkRayTracingShaderGroupCreateInfoNV.Buffer.() -> Unit): VkRayTracingShaderGroupCreateInfoNV.Buffer = RayTracingShaderGroupCreateInfoNV(capacity).also(block)

fun MemoryStack.RectLayerKHR(): VkRectLayerKHR = VkRectLayerKHR.callocStack(this)
fun MemoryStack.RectLayerKHR(block: VkRectLayerKHR.() -> Unit): VkRectLayerKHR = RectLayerKHR().also(block)
fun MemoryStack.RectLayerKHR(capacity: Int): VkRectLayerKHR.Buffer = VkRectLayerKHR.callocStack(capacity, this)
fun MemoryStack.RectLayerKHR(capacity: Int, block: VkRectLayerKHR.Buffer.() -> Unit): VkRectLayerKHR.Buffer = RectLayerKHR(capacity).also(block)

fun MemoryStack.Rect2D(): VkRect2D = VkRect2D.callocStack(this)
fun MemoryStack.Rect2D(block: VkRect2D.() -> Unit): VkRect2D = Rect2D().also(block)
fun MemoryStack.Rect2D(capacity: Int): VkRect2D.Buffer = VkRect2D.callocStack(capacity, this)
fun MemoryStack.Rect2D(capacity: Int, block: VkRect2D.Buffer.() -> Unit): VkRect2D.Buffer = Rect2D(capacity).also(block)

fun MemoryStack.RefreshCycleDurationGOOGLE(): VkRefreshCycleDurationGOOGLE = VkRefreshCycleDurationGOOGLE.callocStack(this)
fun MemoryStack.RefreshCycleDurationGOOGLE(block: VkRefreshCycleDurationGOOGLE.() -> Unit): VkRefreshCycleDurationGOOGLE = RefreshCycleDurationGOOGLE().also(block)
fun MemoryStack.RefreshCycleDurationGOOGLE(capacity: Int): VkRefreshCycleDurationGOOGLE.Buffer = VkRefreshCycleDurationGOOGLE.callocStack(capacity, this)
fun MemoryStack.RefreshCycleDurationGOOGLE(capacity: Int, block: VkRefreshCycleDurationGOOGLE.Buffer.() -> Unit): VkRefreshCycleDurationGOOGLE.Buffer = RefreshCycleDurationGOOGLE(capacity).also(block)

fun MemoryStack.RenderPassBeginInfo(): VkRenderPassBeginInfo = VkRenderPassBeginInfo.callocStack(this).apply { type = VkStructureType.RENDER_PASS_BEGIN_INFO }
fun MemoryStack.RenderPassBeginInfo(block: VkRenderPassBeginInfo.() -> Unit): VkRenderPassBeginInfo = RenderPassBeginInfo().also(block)
fun MemoryStack.RenderPassBeginInfo(capacity: Int): VkRenderPassBeginInfo.Buffer = VkRenderPassBeginInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.RENDER_PASS_BEGIN_INFO }
fun MemoryStack.RenderPassBeginInfo(capacity: Int, block: VkRenderPassBeginInfo.Buffer.() -> Unit): VkRenderPassBeginInfo.Buffer = RenderPassBeginInfo(capacity).also(block)

fun MemoryStack.RenderPassCreateInfo(): VkRenderPassCreateInfo = VkRenderPassCreateInfo.callocStack(this).apply { type = VkStructureType.RENDER_PASS_CREATE_INFO }
fun MemoryStack.RenderPassCreateInfo(block: VkRenderPassCreateInfo.() -> Unit): VkRenderPassCreateInfo = RenderPassCreateInfo().also(block)
fun MemoryStack.RenderPassCreateInfo(capacity: Int): VkRenderPassCreateInfo.Buffer = VkRenderPassCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.RENDER_PASS_CREATE_INFO }
fun MemoryStack.RenderPassCreateInfo(capacity: Int, block: VkRenderPassCreateInfo.Buffer.() -> Unit): VkRenderPassCreateInfo.Buffer = RenderPassCreateInfo(capacity).also(block)

fun MemoryStack.RenderPassCreateInfo2KHR(): VkRenderPassCreateInfo2KHR = VkRenderPassCreateInfo2KHR.callocStack(this).apply { type = VkStructureType.RENDER_PASS_CREATE_INFO_2_KHR }
fun MemoryStack.RenderPassCreateInfo2KHR(block: VkRenderPassCreateInfo2KHR.() -> Unit): VkRenderPassCreateInfo2KHR = RenderPassCreateInfo2KHR().also(block)
fun MemoryStack.RenderPassCreateInfo2KHR(capacity: Int): VkRenderPassCreateInfo2KHR.Buffer = VkRenderPassCreateInfo2KHR.callocStack(capacity, this).onEach { it.type = VkStructureType.RENDER_PASS_CREATE_INFO_2_KHR }
fun MemoryStack.RenderPassCreateInfo2KHR(capacity: Int, block: VkRenderPassCreateInfo2KHR.Buffer.() -> Unit): VkRenderPassCreateInfo2KHR.Buffer = RenderPassCreateInfo2KHR(capacity).also(block)

fun MemoryStack.RenderPassFragmentDensityMapCreateInfoEXT(): VkRenderPassFragmentDensityMapCreateInfoEXT = VkRenderPassFragmentDensityMapCreateInfoEXT.callocStack(this).apply { type = VkStructureType.RENDER_PASS_FRAGMENT_DENSITY_MAP_CREATE_INFO_EXT }
fun MemoryStack.RenderPassFragmentDensityMapCreateInfoEXT(block: VkRenderPassFragmentDensityMapCreateInfoEXT.() -> Unit): VkRenderPassFragmentDensityMapCreateInfoEXT = RenderPassFragmentDensityMapCreateInfoEXT().also(block)
fun MemoryStack.RenderPassFragmentDensityMapCreateInfoEXT(capacity: Int): VkRenderPassFragmentDensityMapCreateInfoEXT.Buffer = VkRenderPassFragmentDensityMapCreateInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.RENDER_PASS_FRAGMENT_DENSITY_MAP_CREATE_INFO_EXT }
fun MemoryStack.RenderPassFragmentDensityMapCreateInfoEXT(capacity: Int, block: VkRenderPassFragmentDensityMapCreateInfoEXT.Buffer.() -> Unit): VkRenderPassFragmentDensityMapCreateInfoEXT.Buffer = RenderPassFragmentDensityMapCreateInfoEXT(capacity).also(block)

fun MemoryStack.RenderPassInputAttachmentAspectCreateInfo(): VkRenderPassInputAttachmentAspectCreateInfo = VkRenderPassInputAttachmentAspectCreateInfo.callocStack(this).apply { type = VkStructureType.RENDER_PASS_INPUT_ATTACHMENT_ASPECT_CREATE_INFO }
fun MemoryStack.RenderPassInputAttachmentAspectCreateInfo(block: VkRenderPassInputAttachmentAspectCreateInfo.() -> Unit): VkRenderPassInputAttachmentAspectCreateInfo = RenderPassInputAttachmentAspectCreateInfo().also(block)
fun MemoryStack.RenderPassInputAttachmentAspectCreateInfo(capacity: Int): VkRenderPassInputAttachmentAspectCreateInfo.Buffer = VkRenderPassInputAttachmentAspectCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.RENDER_PASS_INPUT_ATTACHMENT_ASPECT_CREATE_INFO }
fun MemoryStack.RenderPassInputAttachmentAspectCreateInfo(capacity: Int, block: VkRenderPassInputAttachmentAspectCreateInfo.Buffer.() -> Unit): VkRenderPassInputAttachmentAspectCreateInfo.Buffer = RenderPassInputAttachmentAspectCreateInfo(capacity).also(block)

fun MemoryStack.RenderPassMultiviewCreateInfo(): VkRenderPassMultiviewCreateInfo = VkRenderPassMultiviewCreateInfo.callocStack(this).apply { type = VkStructureType.RENDER_PASS_MULTIVIEW_CREATE_INFO }
fun MemoryStack.RenderPassMultiviewCreateInfo(block: VkRenderPassMultiviewCreateInfo.() -> Unit): VkRenderPassMultiviewCreateInfo = RenderPassMultiviewCreateInfo().also(block)
fun MemoryStack.RenderPassMultiviewCreateInfo(capacity: Int): VkRenderPassMultiviewCreateInfo.Buffer = VkRenderPassMultiviewCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.RENDER_PASS_MULTIVIEW_CREATE_INFO }
fun MemoryStack.RenderPassMultiviewCreateInfo(capacity: Int, block: VkRenderPassMultiviewCreateInfo.Buffer.() -> Unit): VkRenderPassMultiviewCreateInfo.Buffer = RenderPassMultiviewCreateInfo(capacity).also(block)

fun MemoryStack.RenderPassSampleLocationsBeginInfoEXT(): VkRenderPassSampleLocationsBeginInfoEXT = VkRenderPassSampleLocationsBeginInfoEXT.callocStack(this).apply { type = VkStructureType.RENDER_PASS_SAMPLE_LOCATIONS_BEGIN_INFO_EXT }
fun MemoryStack.RenderPassSampleLocationsBeginInfoEXT(block: VkRenderPassSampleLocationsBeginInfoEXT.() -> Unit): VkRenderPassSampleLocationsBeginInfoEXT = RenderPassSampleLocationsBeginInfoEXT().also(block)
fun MemoryStack.RenderPassSampleLocationsBeginInfoEXT(capacity: Int): VkRenderPassSampleLocationsBeginInfoEXT.Buffer = VkRenderPassSampleLocationsBeginInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.RENDER_PASS_SAMPLE_LOCATIONS_BEGIN_INFO_EXT }
fun MemoryStack.RenderPassSampleLocationsBeginInfoEXT(capacity: Int, block: VkRenderPassSampleLocationsBeginInfoEXT.Buffer.() -> Unit): VkRenderPassSampleLocationsBeginInfoEXT.Buffer = RenderPassSampleLocationsBeginInfoEXT(capacity).also(block)

fun MemoryStack.SampleLocationEXT(): VkSampleLocationEXT = VkSampleLocationEXT.callocStack(this)
fun MemoryStack.SampleLocationEXT(block: VkSampleLocationEXT.() -> Unit): VkSampleLocationEXT = SampleLocationEXT().also(block)
fun MemoryStack.SampleLocationEXT(capacity: Int): VkSampleLocationEXT.Buffer = VkSampleLocationEXT.callocStack(capacity, this)
fun MemoryStack.SampleLocationEXT(capacity: Int, block: VkSampleLocationEXT.Buffer.() -> Unit): VkSampleLocationEXT.Buffer = SampleLocationEXT(capacity).also(block)

fun MemoryStack.SampleLocationsInfoEXT(): VkSampleLocationsInfoEXT = VkSampleLocationsInfoEXT.callocStack(this).apply { type = VkStructureType.SAMPLE_LOCATIONS_INFO_EXT }
fun MemoryStack.SampleLocationsInfoEXT(block: VkSampleLocationsInfoEXT.() -> Unit): VkSampleLocationsInfoEXT = SampleLocationsInfoEXT().also(block)
fun MemoryStack.SampleLocationsInfoEXT(capacity: Int): VkSampleLocationsInfoEXT.Buffer = VkSampleLocationsInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.SAMPLE_LOCATIONS_INFO_EXT }
fun MemoryStack.SampleLocationsInfoEXT(capacity: Int, block: VkSampleLocationsInfoEXT.Buffer.() -> Unit): VkSampleLocationsInfoEXT.Buffer = SampleLocationsInfoEXT(capacity).also(block)

fun MemoryStack.SamplerCreateInfo(): VkSamplerCreateInfo = VkSamplerCreateInfo.callocStack(this).apply { type = VkStructureType.SAMPLER_CREATE_INFO }
fun MemoryStack.SamplerCreateInfo(block: VkSamplerCreateInfo.() -> Unit): VkSamplerCreateInfo = SamplerCreateInfo().also(block)
fun MemoryStack.SamplerCreateInfo(capacity: Int): VkSamplerCreateInfo.Buffer = VkSamplerCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.SAMPLER_CREATE_INFO }
fun MemoryStack.SamplerCreateInfo(capacity: Int, block: VkSamplerCreateInfo.Buffer.() -> Unit): VkSamplerCreateInfo.Buffer = SamplerCreateInfo(capacity).also(block)

fun MemoryStack.SamplerReductionModeCreateInfoEXT(): VkSamplerReductionModeCreateInfoEXT = VkSamplerReductionModeCreateInfoEXT.callocStack(this).apply { type = VkStructureType.SAMPLER_REDUCTION_MODE_CREATE_INFO_EXT }
fun MemoryStack.SamplerReductionModeCreateInfoEXT(block: VkSamplerReductionModeCreateInfoEXT.() -> Unit): VkSamplerReductionModeCreateInfoEXT = SamplerReductionModeCreateInfoEXT().also(block)
fun MemoryStack.SamplerReductionModeCreateInfoEXT(capacity: Int): VkSamplerReductionModeCreateInfoEXT.Buffer = VkSamplerReductionModeCreateInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.SAMPLER_REDUCTION_MODE_CREATE_INFO_EXT }
fun MemoryStack.SamplerReductionModeCreateInfoEXT(capacity: Int, block: VkSamplerReductionModeCreateInfoEXT.Buffer.() -> Unit): VkSamplerReductionModeCreateInfoEXT.Buffer = SamplerReductionModeCreateInfoEXT(capacity).also(block)

fun MemoryStack.SamplerYcbcrConversionCreateInfo(): VkSamplerYcbcrConversionCreateInfo = VkSamplerYcbcrConversionCreateInfo.callocStack(this).apply { type = VkStructureType.SAMPLER_YCBCR_CONVERSION_CREATE_INFO }
fun MemoryStack.SamplerYcbcrConversionCreateInfo(block: VkSamplerYcbcrConversionCreateInfo.() -> Unit): VkSamplerYcbcrConversionCreateInfo = SamplerYcbcrConversionCreateInfo().also(block)
fun MemoryStack.SamplerYcbcrConversionCreateInfo(capacity: Int): VkSamplerYcbcrConversionCreateInfo.Buffer = VkSamplerYcbcrConversionCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.SAMPLER_YCBCR_CONVERSION_CREATE_INFO }
fun MemoryStack.SamplerYcbcrConversionCreateInfo(capacity: Int, block: VkSamplerYcbcrConversionCreateInfo.Buffer.() -> Unit): VkSamplerYcbcrConversionCreateInfo.Buffer = SamplerYcbcrConversionCreateInfo(capacity).also(block)

fun MemoryStack.SamplerYcbcrConversionImageFormatProperties(): VkSamplerYcbcrConversionImageFormatProperties = VkSamplerYcbcrConversionImageFormatProperties.callocStack(this).apply { type = VkStructureType.SAMPLER_YCBCR_CONVERSION_IMAGE_FORMAT_PROPERTIES }
fun MemoryStack.SamplerYcbcrConversionImageFormatProperties(block: VkSamplerYcbcrConversionImageFormatProperties.() -> Unit): VkSamplerYcbcrConversionImageFormatProperties = SamplerYcbcrConversionImageFormatProperties().also(block)
fun MemoryStack.SamplerYcbcrConversionImageFormatProperties(capacity: Int): VkSamplerYcbcrConversionImageFormatProperties.Buffer = VkSamplerYcbcrConversionImageFormatProperties.callocStack(capacity, this).onEach { it.type = VkStructureType.SAMPLER_YCBCR_CONVERSION_IMAGE_FORMAT_PROPERTIES }
fun MemoryStack.SamplerYcbcrConversionImageFormatProperties(capacity: Int, block: VkSamplerYcbcrConversionImageFormatProperties.Buffer.() -> Unit): VkSamplerYcbcrConversionImageFormatProperties.Buffer = SamplerYcbcrConversionImageFormatProperties(capacity).also(block)

fun MemoryStack.SamplerYcbcrConversionInfo(): VkSamplerYcbcrConversionInfo = VkSamplerYcbcrConversionInfo.callocStack(this).apply { type = VkStructureType.SAMPLER_YCBCR_CONVERSION_INFO }
fun MemoryStack.SamplerYcbcrConversionInfo(block: VkSamplerYcbcrConversionInfo.() -> Unit): VkSamplerYcbcrConversionInfo = SamplerYcbcrConversionInfo().also(block)
fun MemoryStack.SamplerYcbcrConversionInfo(capacity: Int): VkSamplerYcbcrConversionInfo.Buffer = VkSamplerYcbcrConversionInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.SAMPLER_YCBCR_CONVERSION_INFO }
fun MemoryStack.SamplerYcbcrConversionInfo(capacity: Int, block: VkSamplerYcbcrConversionInfo.Buffer.() -> Unit): VkSamplerYcbcrConversionInfo.Buffer = SamplerYcbcrConversionInfo(capacity).also(block)

fun MemoryStack.SemaphoreCreateInfo(): VkSemaphoreCreateInfo = VkSemaphoreCreateInfo.callocStack(this).apply { type = VkStructureType.SEMAPHORE_CREATE_INFO }
fun MemoryStack.SemaphoreCreateInfo(block: VkSemaphoreCreateInfo.() -> Unit): VkSemaphoreCreateInfo = SemaphoreCreateInfo().also(block)
fun MemoryStack.SemaphoreCreateInfo(capacity: Int): VkSemaphoreCreateInfo.Buffer = VkSemaphoreCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.SEMAPHORE_CREATE_INFO }
fun MemoryStack.SemaphoreCreateInfo(capacity: Int, block: VkSemaphoreCreateInfo.Buffer.() -> Unit): VkSemaphoreCreateInfo.Buffer = SemaphoreCreateInfo(capacity).also(block)

fun MemoryStack.SemaphoreGetFdInfoKHR(): VkSemaphoreGetFdInfoKHR = VkSemaphoreGetFdInfoKHR.callocStack(this).apply { type = VkStructureType.SEMAPHORE_GET_FD_INFO_KHR }
fun MemoryStack.SemaphoreGetFdInfoKHR(block: VkSemaphoreGetFdInfoKHR.() -> Unit): VkSemaphoreGetFdInfoKHR = SemaphoreGetFdInfoKHR().also(block)
fun MemoryStack.SemaphoreGetFdInfoKHR(capacity: Int): VkSemaphoreGetFdInfoKHR.Buffer = VkSemaphoreGetFdInfoKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.SEMAPHORE_GET_FD_INFO_KHR }
fun MemoryStack.SemaphoreGetFdInfoKHR(capacity: Int, block: VkSemaphoreGetFdInfoKHR.Buffer.() -> Unit): VkSemaphoreGetFdInfoKHR.Buffer = SemaphoreGetFdInfoKHR(capacity).also(block)

fun MemoryStack.SemaphoreGetWin32HandleInfoKHR(): VkSemaphoreGetWin32HandleInfoKHR = VkSemaphoreGetWin32HandleInfoKHR.callocStack(this).apply { type = VkStructureType.SEMAPHORE_GET_WIN32_HANDLE_INFO_KHR }
fun MemoryStack.SemaphoreGetWin32HandleInfoKHR(block: VkSemaphoreGetWin32HandleInfoKHR.() -> Unit): VkSemaphoreGetWin32HandleInfoKHR = SemaphoreGetWin32HandleInfoKHR().also(block)
fun MemoryStack.SemaphoreGetWin32HandleInfoKHR(capacity: Int): VkSemaphoreGetWin32HandleInfoKHR.Buffer = VkSemaphoreGetWin32HandleInfoKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.SEMAPHORE_GET_WIN32_HANDLE_INFO_KHR }
fun MemoryStack.SemaphoreGetWin32HandleInfoKHR(capacity: Int, block: VkSemaphoreGetWin32HandleInfoKHR.Buffer.() -> Unit): VkSemaphoreGetWin32HandleInfoKHR.Buffer = SemaphoreGetWin32HandleInfoKHR(capacity).also(block)

fun MemoryStack.ShaderModuleCreateInfo(): VkShaderModuleCreateInfo = VkShaderModuleCreateInfo.callocStack(this).apply { type = VkStructureType.SHADER_MODULE_CREATE_INFO }
fun MemoryStack.ShaderModuleCreateInfo(block: VkShaderModuleCreateInfo.() -> Unit): VkShaderModuleCreateInfo = ShaderModuleCreateInfo().also(block)
fun MemoryStack.ShaderModuleCreateInfo(capacity: Int): VkShaderModuleCreateInfo.Buffer = VkShaderModuleCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.SHADER_MODULE_CREATE_INFO }
fun MemoryStack.ShaderModuleCreateInfo(capacity: Int, block: VkShaderModuleCreateInfo.Buffer.() -> Unit): VkShaderModuleCreateInfo.Buffer = ShaderModuleCreateInfo(capacity).also(block)

fun MemoryStack.ShaderModuleValidationCacheCreateInfoEXT(): VkShaderModuleValidationCacheCreateInfoEXT = VkShaderModuleValidationCacheCreateInfoEXT.callocStack(this).apply { type = VkStructureType.SHADER_MODULE_VALIDATION_CACHE_CREATE_INFO_EXT }
fun MemoryStack.ShaderModuleValidationCacheCreateInfoEXT(block: VkShaderModuleValidationCacheCreateInfoEXT.() -> Unit): VkShaderModuleValidationCacheCreateInfoEXT = ShaderModuleValidationCacheCreateInfoEXT().also(block)
fun MemoryStack.ShaderModuleValidationCacheCreateInfoEXT(capacity: Int): VkShaderModuleValidationCacheCreateInfoEXT.Buffer = VkShaderModuleValidationCacheCreateInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.SHADER_MODULE_VALIDATION_CACHE_CREATE_INFO_EXT }
fun MemoryStack.ShaderModuleValidationCacheCreateInfoEXT(capacity: Int, block: VkShaderModuleValidationCacheCreateInfoEXT.Buffer.() -> Unit): VkShaderModuleValidationCacheCreateInfoEXT.Buffer = ShaderModuleValidationCacheCreateInfoEXT(capacity).also(block)

//fun MemoryStack.ShaderResourceUsageAMD(): VkShaderResourceUsageAMD = VkShaderResourceUsageAMD.callocStack(this)
//fun MemoryStack.ShaderResourceUsageAMD(block: VkShaderResourceUsageAMD.() -> Unit): VkShaderResourceUsageAMD = ShaderResourceUsageAMD().also(block)
//fun MemoryStack.ShaderResourceUsageAMD(capacity: Int): VkShaderResourceUsageAMD.Buffer = VkShaderResourceUsageAMD.callocStack(capacity, this)
//fun MemoryStack.ShaderResourceUsageAMD(capacity: Int, block: VkShaderResourceUsageAMD.Buffer.() -> Unit): VkShaderResourceUsageAMD.Buffer = ShaderResourceUsageAMD(capacity).also(block)
//
//fun MemoryStack.ShaderStatisticsInfoAMD(): VkShaderStatisticsInfoAMD = VkShaderStatisticsInfoAMD.callocStack(this)
//fun MemoryStack.ShaderStatisticsInfoAMD(block: VkShaderStatisticsInfoAMD.() -> Unit): VkShaderStatisticsInfoAMD = ShaderStatisticsInfoAMD().also(block)
//fun MemoryStack.ShaderStatisticsInfoAMD(capacity: Int): VkShaderStatisticsInfoAMD.Buffer = VkShaderStatisticsInfoAMD.callocStack(capacity, this)
//fun MemoryStack.ShaderStatisticsInfoAMD(capacity: Int, block: VkShaderStatisticsInfoAMD.Buffer.() -> Unit): VkShaderStatisticsInfoAMD.Buffer = ShaderStatisticsInfoAMD(capacity).also(block)

fun MemoryStack.ShadingRatePaletteNV(): VkShadingRatePaletteNV = VkShadingRatePaletteNV.callocStack(this)
fun MemoryStack.ShadingRatePaletteNV(block: VkShadingRatePaletteNV.() -> Unit): VkShadingRatePaletteNV = ShadingRatePaletteNV().also(block)
fun MemoryStack.ShadingRatePaletteNV(capacity: Int): VkShadingRatePaletteNV.Buffer = VkShadingRatePaletteNV.callocStack(capacity, this)
fun MemoryStack.ShadingRatePaletteNV(capacity: Int, block: VkShadingRatePaletteNV.Buffer.() -> Unit): VkShadingRatePaletteNV.Buffer = ShadingRatePaletteNV(capacity).also(block)

fun MemoryStack.SharedPresentSurfaceCapabilitiesKHR(): VkSharedPresentSurfaceCapabilitiesKHR = VkSharedPresentSurfaceCapabilitiesKHR.callocStack(this).apply { type = VkStructureType.SHARED_PRESENT_SURFACE_CAPABILITIES_KHR }
fun MemoryStack.SharedPresentSurfaceCapabilitiesKHR(block: VkSharedPresentSurfaceCapabilitiesKHR.() -> Unit): VkSharedPresentSurfaceCapabilitiesKHR = SharedPresentSurfaceCapabilitiesKHR().also(block)
fun MemoryStack.SharedPresentSurfaceCapabilitiesKHR(capacity: Int): VkSharedPresentSurfaceCapabilitiesKHR.Buffer = VkSharedPresentSurfaceCapabilitiesKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.SHARED_PRESENT_SURFACE_CAPABILITIES_KHR }
fun MemoryStack.SharedPresentSurfaceCapabilitiesKHR(capacity: Int, block: VkSharedPresentSurfaceCapabilitiesKHR.Buffer.() -> Unit): VkSharedPresentSurfaceCapabilitiesKHR.Buffer = SharedPresentSurfaceCapabilitiesKHR(capacity).also(block)

fun MemoryStack.SparseBufferMemoryBindInfo(): VkSparseBufferMemoryBindInfo = VkSparseBufferMemoryBindInfo.callocStack(this)
fun MemoryStack.SparseBufferMemoryBindInfo(block: VkSparseBufferMemoryBindInfo.() -> Unit): VkSparseBufferMemoryBindInfo = SparseBufferMemoryBindInfo().also(block)
fun MemoryStack.SparseBufferMemoryBindInfo(capacity: Int): VkSparseBufferMemoryBindInfo.Buffer = VkSparseBufferMemoryBindInfo.callocStack(capacity, this)
fun MemoryStack.SparseBufferMemoryBindInfo(capacity: Int, block: VkSparseBufferMemoryBindInfo.Buffer.() -> Unit): VkSparseBufferMemoryBindInfo.Buffer = SparseBufferMemoryBindInfo(capacity).also(block)

fun MemoryStack.SparseImageFormatProperties(): VkSparseImageFormatProperties = VkSparseImageFormatProperties.callocStack(this)
fun MemoryStack.SparseImageFormatProperties(block: VkSparseImageFormatProperties.() -> Unit): VkSparseImageFormatProperties = SparseImageFormatProperties().also(block)
fun MemoryStack.SparseImageFormatProperties(capacity: Int): VkSparseImageFormatProperties.Buffer = VkSparseImageFormatProperties.callocStack(capacity, this)
fun MemoryStack.SparseImageFormatProperties(capacity: Int, block: VkSparseImageFormatProperties.Buffer.() -> Unit): VkSparseImageFormatProperties.Buffer = SparseImageFormatProperties(capacity).also(block)

fun MemoryStack.SparseImageFormatProperties2(): VkSparseImageFormatProperties2 = VkSparseImageFormatProperties2.callocStack(this).apply { type = VkStructureType.SPARSE_IMAGE_FORMAT_PROPERTIES_2 }
fun MemoryStack.SparseImageFormatProperties2(block: VkSparseImageFormatProperties2.() -> Unit): VkSparseImageFormatProperties2 = SparseImageFormatProperties2().also(block)
fun MemoryStack.SparseImageFormatProperties2(capacity: Int): VkSparseImageFormatProperties2.Buffer = VkSparseImageFormatProperties2.callocStack(capacity, this).onEach { it.type = VkStructureType.SPARSE_IMAGE_FORMAT_PROPERTIES_2 }
fun MemoryStack.SparseImageFormatProperties2(capacity: Int, block: VkSparseImageFormatProperties2.Buffer.() -> Unit): VkSparseImageFormatProperties2.Buffer = SparseImageFormatProperties2(capacity).also(block)

fun MemoryStack.SparseImageMemoryBind(): VkSparseImageMemoryBind = VkSparseImageMemoryBind.callocStack(this)
fun MemoryStack.SparseImageMemoryBind(block: VkSparseImageMemoryBind.() -> Unit): VkSparseImageMemoryBind = SparseImageMemoryBind().also(block)
fun MemoryStack.SparseImageMemoryBind(capacity: Int): VkSparseImageMemoryBind.Buffer = VkSparseImageMemoryBind.callocStack(capacity, this)
fun MemoryStack.SparseImageMemoryBind(capacity: Int, block: VkSparseImageMemoryBind.Buffer.() -> Unit): VkSparseImageMemoryBind.Buffer = SparseImageMemoryBind(capacity).also(block)

fun MemoryStack.SparseImageMemoryBindInfo(): VkSparseImageMemoryBindInfo = VkSparseImageMemoryBindInfo.callocStack(this)
fun MemoryStack.SparseImageMemoryBindInfo(block: VkSparseImageMemoryBindInfo.() -> Unit): VkSparseImageMemoryBindInfo = SparseImageMemoryBindInfo().also(block)
fun MemoryStack.SparseImageMemoryBindInfo(capacity: Int): VkSparseImageMemoryBindInfo.Buffer = VkSparseImageMemoryBindInfo.callocStack(capacity, this)
fun MemoryStack.SparseImageMemoryBindInfo(capacity: Int, block: VkSparseImageMemoryBindInfo.Buffer.() -> Unit): VkSparseImageMemoryBindInfo.Buffer = SparseImageMemoryBindInfo(capacity).also(block)

fun MemoryStack.SparseImageMemoryRequirements(): VkSparseImageMemoryRequirements = VkSparseImageMemoryRequirements.callocStack(this)
fun MemoryStack.SparseImageMemoryRequirements(block: VkSparseImageMemoryRequirements.() -> Unit): VkSparseImageMemoryRequirements = SparseImageMemoryRequirements().also(block)
fun MemoryStack.SparseImageMemoryRequirements(capacity: Int): VkSparseImageMemoryRequirements.Buffer = VkSparseImageMemoryRequirements.callocStack(capacity, this)
fun MemoryStack.SparseImageMemoryRequirements(capacity: Int, block: VkSparseImageMemoryRequirements.Buffer.() -> Unit): VkSparseImageMemoryRequirements.Buffer = SparseImageMemoryRequirements(capacity).also(block)

fun MemoryStack.SparseImageMemoryRequirements2(): VkSparseImageMemoryRequirements2 = VkSparseImageMemoryRequirements2.callocStack(this)
fun MemoryStack.SparseImageMemoryRequirements2(block: VkSparseImageMemoryRequirements2.() -> Unit): VkSparseImageMemoryRequirements2 = SparseImageMemoryRequirements2().also(block)
fun MemoryStack.SparseImageMemoryRequirements2(capacity: Int): VkSparseImageMemoryRequirements2.Buffer = VkSparseImageMemoryRequirements2.callocStack(capacity, this)
fun MemoryStack.SparseImageMemoryRequirements2(capacity: Int, block: VkSparseImageMemoryRequirements2.Buffer.() -> Unit): VkSparseImageMemoryRequirements2.Buffer = SparseImageMemoryRequirements2(capacity).also(block)

fun MemoryStack.SparseImageOpaqueMemoryBindInfo(): VkSparseImageOpaqueMemoryBindInfo = VkSparseImageOpaqueMemoryBindInfo.callocStack(this)
fun MemoryStack.SparseImageOpaqueMemoryBindInfo(block: VkSparseImageOpaqueMemoryBindInfo.() -> Unit): VkSparseImageOpaqueMemoryBindInfo = SparseImageOpaqueMemoryBindInfo().also(block)
fun MemoryStack.SparseImageOpaqueMemoryBindInfo(capacity: Int): VkSparseImageOpaqueMemoryBindInfo.Buffer = VkSparseImageOpaqueMemoryBindInfo.callocStack(capacity, this)
fun MemoryStack.SparseImageOpaqueMemoryBindInfo(capacity: Int, block: VkSparseImageOpaqueMemoryBindInfo.Buffer.() -> Unit): VkSparseImageOpaqueMemoryBindInfo.Buffer = SparseImageOpaqueMemoryBindInfo(capacity).also(block)

fun MemoryStack.SparseMemoryBind(): VkSparseMemoryBind = VkSparseMemoryBind.callocStack(this)
fun MemoryStack.SparseMemoryBind(block: VkSparseMemoryBind.() -> Unit): VkSparseMemoryBind = SparseMemoryBind().also(block)
fun MemoryStack.SparseMemoryBind(capacity: Int): VkSparseMemoryBind.Buffer = VkSparseMemoryBind.callocStack(capacity, this)
fun MemoryStack.SparseMemoryBind(capacity: Int, block: VkSparseMemoryBind.Buffer.() -> Unit): VkSparseMemoryBind.Buffer = SparseMemoryBind(capacity).also(block)

fun MemoryStack.SpecializationInfo(): VkSpecializationInfo = VkSpecializationInfo.callocStack(this)
fun MemoryStack.SpecializationInfo(block: VkSpecializationInfo.() -> Unit): VkSpecializationInfo = SpecializationInfo().also(block)
fun MemoryStack.SpecializationInfo(capacity: Int): VkSpecializationInfo.Buffer = VkSpecializationInfo.callocStack(capacity, this)
fun MemoryStack.SpecializationInfo(capacity: Int, block: VkSpecializationInfo.Buffer.() -> Unit): VkSpecializationInfo.Buffer = SpecializationInfo(capacity).also(block)

fun MemoryStack.SpecializationMapEntry(): VkSpecializationMapEntry = VkSpecializationMapEntry.callocStack(this)
fun MemoryStack.SpecializationMapEntry(block: VkSpecializationMapEntry.() -> Unit): VkSpecializationMapEntry = SpecializationMapEntry().also(block)
fun MemoryStack.SpecializationMapEntry(capacity: Int): VkSpecializationMapEntry.Buffer = VkSpecializationMapEntry.callocStack(capacity, this)
fun MemoryStack.SpecializationMapEntry(capacity: Int, block: VkSpecializationMapEntry.Buffer.() -> Unit): VkSpecializationMapEntry.Buffer = SpecializationMapEntry(capacity).also(block)

fun MemoryStack.StencilOpState(): VkStencilOpState = VkStencilOpState.callocStack(this)
fun MemoryStack.StencilOpState(block: VkStencilOpState.() -> Unit): VkStencilOpState = StencilOpState().also(block)
fun MemoryStack.StencilOpState(capacity: Int): VkStencilOpState.Buffer = VkStencilOpState.callocStack(capacity, this)
fun MemoryStack.StencilOpState(capacity: Int, block: VkStencilOpState.Buffer.() -> Unit): VkStencilOpState.Buffer = StencilOpState(capacity).also(block)

fun MemoryStack.SubmitInfo(): VkSubmitInfo = VkSubmitInfo.callocStack(this).apply { type = VkStructureType.SUBMIT_INFO }
fun MemoryStack.SubmitInfo(block: VkSubmitInfo.() -> Unit): VkSubmitInfo = SubmitInfo().also(block)
fun MemoryStack.SubmitInfo(capacity: Int): VkSubmitInfo.Buffer = VkSubmitInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.SUBMIT_INFO }
fun MemoryStack.SubmitInfo(capacity: Int, block: VkSubmitInfo.Buffer.() -> Unit): VkSubmitInfo.Buffer = SubmitInfo(capacity).also(block)

fun MemoryStack.SubpassBeginInfoKHR(): VkSubpassBeginInfoKHR = VkSubpassBeginInfoKHR.callocStack(this).apply { type = VkStructureType.SUBPASS_BEGIN_INFO_KHR }
fun MemoryStack.SubpassBeginInfoKHR(block: VkSubpassBeginInfoKHR.() -> Unit): VkSubpassBeginInfoKHR = SubpassBeginInfoKHR().also(block)
fun MemoryStack.SubpassBeginInfoKHR(capacity: Int): VkSubpassBeginInfoKHR.Buffer = VkSubpassBeginInfoKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.SUBPASS_BEGIN_INFO_KHR }
fun MemoryStack.SubpassBeginInfoKHR(capacity: Int, block: VkSubpassBeginInfoKHR.Buffer.() -> Unit): VkSubpassBeginInfoKHR.Buffer = SubpassBeginInfoKHR(capacity).also(block)

fun MemoryStack.SubpassDependency(): VkSubpassDependency = VkSubpassDependency.callocStack(this)
fun MemoryStack.SubpassDependency(block: VkSubpassDependency.() -> Unit): VkSubpassDependency = SubpassDependency().also(block)
fun MemoryStack.SubpassDependency(capacity: Int): VkSubpassDependency.Buffer = VkSubpassDependency.callocStack(capacity, this)
fun MemoryStack.SubpassDependency(capacity: Int, block: VkSubpassDependency.Buffer.() -> Unit): VkSubpassDependency.Buffer = SubpassDependency(capacity).also(block)

fun MemoryStack.SubpassDependency2KHR(): VkSubpassDependency2KHR = VkSubpassDependency2KHR.callocStack(this).apply { type = VkStructureType.SUBPASS_DEPENDENCY_2_KHR }
fun MemoryStack.SubpassDependency2KHR(block: VkSubpassDependency2KHR.() -> Unit): VkSubpassDependency2KHR = SubpassDependency2KHR().also(block)
fun MemoryStack.SubpassDependency2KHR(capacity: Int): VkSubpassDependency2KHR.Buffer = VkSubpassDependency2KHR.callocStack(capacity, this).onEach { it.type = VkStructureType.SUBPASS_DEPENDENCY_2_KHR }
fun MemoryStack.SubpassDependency2KHR(capacity: Int, block: VkSubpassDependency2KHR.Buffer.() -> Unit): VkSubpassDependency2KHR.Buffer = SubpassDependency2KHR(capacity).also(block)

fun MemoryStack.SubpassDescription(): VkSubpassDescription = VkSubpassDescription.callocStack(this)
fun MemoryStack.SubpassDescription(block: VkSubpassDescription.() -> Unit): VkSubpassDescription = SubpassDescription().also(block)
fun MemoryStack.SubpassDescription(capacity: Int): VkSubpassDescription.Buffer = VkSubpassDescription.callocStack(capacity, this)
fun MemoryStack.SubpassDescription(capacity: Int, block: VkSubpassDescription.Buffer.() -> Unit): VkSubpassDescription.Buffer = SubpassDescription(capacity).also(block)

fun MemoryStack.SubpassDescriptionDepthStencilResolveKHR(): VkSubpassDescriptionDepthStencilResolveKHR = VkSubpassDescriptionDepthStencilResolveKHR.callocStack(this).apply { type = VkStructureType.SUBPASS_DESCRIPTION_DEPTH_STENCIL_RESOLVE_KHR }
fun MemoryStack.SubpassDescriptionDepthStencilResolveKHR(block: VkSubpassDescriptionDepthStencilResolveKHR.() -> Unit): VkSubpassDescriptionDepthStencilResolveKHR = SubpassDescriptionDepthStencilResolveKHR().also(block)
fun MemoryStack.SubpassDescriptionDepthStencilResolveKHR(capacity: Int): VkSubpassDescriptionDepthStencilResolveKHR.Buffer = VkSubpassDescriptionDepthStencilResolveKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.SUBPASS_DESCRIPTION_DEPTH_STENCIL_RESOLVE_KHR }
fun MemoryStack.SubpassDescriptionDepthStencilResolveKHR(capacity: Int, block: VkSubpassDescriptionDepthStencilResolveKHR.Buffer.() -> Unit): VkSubpassDescriptionDepthStencilResolveKHR.Buffer = SubpassDescriptionDepthStencilResolveKHR(capacity).also(block)

fun MemoryStack.SubpassDescription2KHR(): VkSubpassDescription2KHR = VkSubpassDescription2KHR.callocStack(this).apply { type = VkStructureType.SUBPASS_DESCRIPTION_2_KHR }
fun MemoryStack.SubpassDescription2KHR(block: VkSubpassDescription2KHR.() -> Unit): VkSubpassDescription2KHR = SubpassDescription2KHR().also(block)
fun MemoryStack.SubpassDescription2KHR(capacity: Int): VkSubpassDescription2KHR.Buffer = VkSubpassDescription2KHR.callocStack(capacity, this).onEach { it.type = VkStructureType.SUBPASS_DESCRIPTION_2_KHR }
fun MemoryStack.SubpassDescription2KHR(capacity: Int, block: VkSubpassDescription2KHR.Buffer.() -> Unit): VkSubpassDescription2KHR.Buffer = SubpassDescription2KHR(capacity).also(block)

fun MemoryStack.SubpassEndInfoKHR(): VkSubpassEndInfoKHR = VkSubpassEndInfoKHR.callocStack(this).apply { type = VkStructureType.SUBPASS_END_INFO_KHR }
fun MemoryStack.SubpassEndInfoKHR(block: VkSubpassEndInfoKHR.() -> Unit): VkSubpassEndInfoKHR = SubpassEndInfoKHR().also(block)
fun MemoryStack.SubpassEndInfoKHR(capacity: Int): VkSubpassEndInfoKHR.Buffer = VkSubpassEndInfoKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.SUBPASS_END_INFO_KHR }
fun MemoryStack.SubpassEndInfoKHR(capacity: Int, block: VkSubpassEndInfoKHR.Buffer.() -> Unit): VkSubpassEndInfoKHR.Buffer = SubpassEndInfoKHR(capacity).also(block)

fun MemoryStack.SubpassSampleLocationsEXT(): VkSubpassSampleLocationsEXT = VkSubpassSampleLocationsEXT.callocStack(this)
fun MemoryStack.SubpassSampleLocationsEXT(block: VkSubpassSampleLocationsEXT.() -> Unit): VkSubpassSampleLocationsEXT = SubpassSampleLocationsEXT().also(block)
fun MemoryStack.SubpassSampleLocationsEXT(capacity: Int): VkSubpassSampleLocationsEXT.Buffer = VkSubpassSampleLocationsEXT.callocStack(capacity, this)
fun MemoryStack.SubpassSampleLocationsEXT(capacity: Int, block: VkSubpassSampleLocationsEXT.Buffer.() -> Unit): VkSubpassSampleLocationsEXT.Buffer = SubpassSampleLocationsEXT(capacity).also(block)

fun MemoryStack.SubresourceLayout(): VkSubresourceLayout = VkSubresourceLayout.callocStack(this)
fun MemoryStack.SubresourceLayout(block: VkSubresourceLayout.() -> Unit): VkSubresourceLayout = SubresourceLayout().also(block)
fun MemoryStack.SubresourceLayout(capacity: Int): VkSubresourceLayout.Buffer = VkSubresourceLayout.callocStack(capacity, this)
fun MemoryStack.SubresourceLayout(capacity: Int, block: VkSubresourceLayout.Buffer.() -> Unit): VkSubresourceLayout.Buffer = SubresourceLayout(capacity).also(block)

fun MemoryStack.SurfaceCapabilitiesFullScreenExclusiveEXT(): VkSurfaceCapabilitiesFullScreenExclusiveEXT = VkSurfaceCapabilitiesFullScreenExclusiveEXT.callocStack(this).apply { type = VkStructureType.SURFACE_CAPABILITIES_FULL_SCREEN_EXCLUSIVE_EXT }
fun MemoryStack.SurfaceCapabilitiesFullScreenExclusiveEXT(block: VkSurfaceCapabilitiesFullScreenExclusiveEXT.() -> Unit): VkSurfaceCapabilitiesFullScreenExclusiveEXT = SurfaceCapabilitiesFullScreenExclusiveEXT().also(block)
fun MemoryStack.SurfaceCapabilitiesFullScreenExclusiveEXT(capacity: Int): VkSurfaceCapabilitiesFullScreenExclusiveEXT.Buffer = VkSurfaceCapabilitiesFullScreenExclusiveEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.SURFACE_CAPABILITIES_FULL_SCREEN_EXCLUSIVE_EXT }
fun MemoryStack.SurfaceCapabilitiesFullScreenExclusiveEXT(capacity: Int, block: VkSurfaceCapabilitiesFullScreenExclusiveEXT.Buffer.() -> Unit): VkSurfaceCapabilitiesFullScreenExclusiveEXT.Buffer = SurfaceCapabilitiesFullScreenExclusiveEXT(capacity).also(block)

fun MemoryStack.SurfaceCapabilitiesKHR(): VkSurfaceCapabilitiesKHR = VkSurfaceCapabilitiesKHR.callocStack(this)
fun MemoryStack.SurfaceCapabilitiesKHR(block: VkSurfaceCapabilitiesKHR.() -> Unit): VkSurfaceCapabilitiesKHR = SurfaceCapabilitiesKHR().also(block)
fun MemoryStack.SurfaceCapabilitiesKHR(capacity: Int): VkSurfaceCapabilitiesKHR.Buffer = VkSurfaceCapabilitiesKHR.callocStack(capacity, this)
fun MemoryStack.SurfaceCapabilitiesKHR(capacity: Int, block: VkSurfaceCapabilitiesKHR.Buffer.() -> Unit): VkSurfaceCapabilitiesKHR.Buffer = SurfaceCapabilitiesKHR(capacity).also(block)

fun MemoryStack.SurfaceCapabilities2EXT(): VkSurfaceCapabilities2EXT = VkSurfaceCapabilities2EXT.callocStack(this).apply { type = VkStructureType.SURFACE_CAPABILITIES_2_EXT }
fun MemoryStack.SurfaceCapabilities2EXT(block: VkSurfaceCapabilities2EXT.() -> Unit): VkSurfaceCapabilities2EXT = SurfaceCapabilities2EXT().also(block)
fun MemoryStack.SurfaceCapabilities2EXT(capacity: Int): VkSurfaceCapabilities2EXT.Buffer = VkSurfaceCapabilities2EXT.callocStack(capacity, this).onEach { it.type = VkStructureType.SURFACE_CAPABILITIES_2_EXT }
fun MemoryStack.SurfaceCapabilities2EXT(capacity: Int, block: VkSurfaceCapabilities2EXT.Buffer.() -> Unit): VkSurfaceCapabilities2EXT.Buffer = SurfaceCapabilities2EXT(capacity).also(block)

fun MemoryStack.SurfaceCapabilities2KHR(): VkSurfaceCapabilities2KHR = VkSurfaceCapabilities2KHR.callocStack(this).apply { type = VkStructureType.SURFACE_CAPABILITIES_2_KHR }
fun MemoryStack.SurfaceCapabilities2KHR(block: VkSurfaceCapabilities2KHR.() -> Unit): VkSurfaceCapabilities2KHR = SurfaceCapabilities2KHR().also(block)
fun MemoryStack.SurfaceCapabilities2KHR(capacity: Int): VkSurfaceCapabilities2KHR.Buffer = VkSurfaceCapabilities2KHR.callocStack(capacity, this).onEach { it.type = VkStructureType.SURFACE_CAPABILITIES_2_KHR }
fun MemoryStack.SurfaceCapabilities2KHR(capacity: Int, block: VkSurfaceCapabilities2KHR.Buffer.() -> Unit): VkSurfaceCapabilities2KHR.Buffer = SurfaceCapabilities2KHR(capacity).also(block)

fun MemoryStack.SurfaceFormatKHR(): VkSurfaceFormatKHR = VkSurfaceFormatKHR.callocStack(this)
fun MemoryStack.SurfaceFormatKHR(block: VkSurfaceFormatKHR.() -> Unit): VkSurfaceFormatKHR = SurfaceFormatKHR().also(block)
fun MemoryStack.SurfaceFormatKHR(capacity: Int): VkSurfaceFormatKHR.Buffer = VkSurfaceFormatKHR.callocStack(capacity, this)
fun MemoryStack.SurfaceFormatKHR(capacity: Int, block: VkSurfaceFormatKHR.Buffer.() -> Unit): VkSurfaceFormatKHR.Buffer = SurfaceFormatKHR(capacity).also(block)

fun MemoryStack.SurfaceFormat2KHR(): VkSurfaceFormat2KHR = VkSurfaceFormat2KHR.callocStack(this).apply { type = VkStructureType.SURFACE_FORMAT_2_KHR }
fun MemoryStack.SurfaceFormat2KHR(block: VkSurfaceFormat2KHR.() -> Unit): VkSurfaceFormat2KHR = SurfaceFormat2KHR().also(block)
fun MemoryStack.SurfaceFormat2KHR(capacity: Int): VkSurfaceFormat2KHR.Buffer = VkSurfaceFormat2KHR.callocStack(capacity, this).onEach { it.type = VkStructureType.SURFACE_FORMAT_2_KHR }
fun MemoryStack.SurfaceFormat2KHR(capacity: Int, block: VkSurfaceFormat2KHR.Buffer.() -> Unit): VkSurfaceFormat2KHR.Buffer = SurfaceFormat2KHR(capacity).also(block)

fun MemoryStack.SurfaceFullScreenExclusiveInfoEXT(): VkSurfaceFullScreenExclusiveInfoEXT = VkSurfaceFullScreenExclusiveInfoEXT.callocStack(this).apply { type = VkStructureType.SURFACE_FULL_SCREEN_EXCLUSIVE_INFO_EXT }
fun MemoryStack.SurfaceFullScreenExclusiveInfoEXT(block: VkSurfaceFullScreenExclusiveInfoEXT.() -> Unit): VkSurfaceFullScreenExclusiveInfoEXT = SurfaceFullScreenExclusiveInfoEXT().also(block)
fun MemoryStack.SurfaceFullScreenExclusiveInfoEXT(capacity: Int): VkSurfaceFullScreenExclusiveInfoEXT.Buffer = VkSurfaceFullScreenExclusiveInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.SURFACE_FULL_SCREEN_EXCLUSIVE_INFO_EXT }
fun MemoryStack.SurfaceFullScreenExclusiveInfoEXT(capacity: Int, block: VkSurfaceFullScreenExclusiveInfoEXT.Buffer.() -> Unit): VkSurfaceFullScreenExclusiveInfoEXT.Buffer = SurfaceFullScreenExclusiveInfoEXT(capacity).also(block)

fun MemoryStack.SurfaceFullScreenExclusiveWin32InfoEXT(): VkSurfaceFullScreenExclusiveWin32InfoEXT = VkSurfaceFullScreenExclusiveWin32InfoEXT.callocStack(this).apply { type = VkStructureType.SURFACE_FULL_SCREEN_EXCLUSIVE_WIN32_INFO_EXT }
fun MemoryStack.SurfaceFullScreenExclusiveWin32InfoEXT(block: VkSurfaceFullScreenExclusiveWin32InfoEXT.() -> Unit): VkSurfaceFullScreenExclusiveWin32InfoEXT = SurfaceFullScreenExclusiveWin32InfoEXT().also(block)
fun MemoryStack.SurfaceFullScreenExclusiveWin32InfoEXT(capacity: Int): VkSurfaceFullScreenExclusiveWin32InfoEXT.Buffer = VkSurfaceFullScreenExclusiveWin32InfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.SURFACE_FULL_SCREEN_EXCLUSIVE_WIN32_INFO_EXT }
fun MemoryStack.SurfaceFullScreenExclusiveWin32InfoEXT(capacity: Int, block: VkSurfaceFullScreenExclusiveWin32InfoEXT.Buffer.() -> Unit): VkSurfaceFullScreenExclusiveWin32InfoEXT.Buffer = SurfaceFullScreenExclusiveWin32InfoEXT(capacity).also(block)

fun MemoryStack.SurfaceProtectedCapabilitiesKHR(): VkSurfaceProtectedCapabilitiesKHR = VkSurfaceProtectedCapabilitiesKHR.callocStack(this)
fun MemoryStack.SurfaceProtectedCapabilitiesKHR(block: VkSurfaceProtectedCapabilitiesKHR.() -> Unit): VkSurfaceProtectedCapabilitiesKHR = SurfaceProtectedCapabilitiesKHR().also(block)
fun MemoryStack.SurfaceProtectedCapabilitiesKHR(capacity: Int): VkSurfaceProtectedCapabilitiesKHR.Buffer = VkSurfaceProtectedCapabilitiesKHR.callocStack(capacity, this)
fun MemoryStack.SurfaceProtectedCapabilitiesKHR(capacity: Int, block: VkSurfaceProtectedCapabilitiesKHR.Buffer.() -> Unit): VkSurfaceProtectedCapabilitiesKHR.Buffer = SurfaceProtectedCapabilitiesKHR(capacity).also(block)

fun MemoryStack.SwapchainCounterCreateInfoEXT(): VkSwapchainCounterCreateInfoEXT = VkSwapchainCounterCreateInfoEXT.callocStack(this).apply { type = VkStructureType.SWAPCHAIN_COUNTER_CREATE_INFO_EXT }
fun MemoryStack.SwapchainCounterCreateInfoEXT(block: VkSwapchainCounterCreateInfoEXT.() -> Unit): VkSwapchainCounterCreateInfoEXT = SwapchainCounterCreateInfoEXT().also(block)
fun MemoryStack.SwapchainCounterCreateInfoEXT(capacity: Int): VkSwapchainCounterCreateInfoEXT.Buffer = VkSwapchainCounterCreateInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.SWAPCHAIN_COUNTER_CREATE_INFO_EXT }
fun MemoryStack.SwapchainCounterCreateInfoEXT(capacity: Int, block: VkSwapchainCounterCreateInfoEXT.Buffer.() -> Unit): VkSwapchainCounterCreateInfoEXT.Buffer = SwapchainCounterCreateInfoEXT(capacity).also(block)

fun MemoryStack.SwapchainCreateInfoKHR(): VkSwapchainCreateInfoKHR = VkSwapchainCreateInfoKHR.callocStack(this).apply { type = VkStructureType.SWAPCHAIN_CREATE_INFO_KHR }
fun MemoryStack.SwapchainCreateInfoKHR(block: VkSwapchainCreateInfoKHR.() -> Unit): VkSwapchainCreateInfoKHR = SwapchainCreateInfoKHR().also(block)
fun MemoryStack.SwapchainCreateInfoKHR(capacity: Int): VkSwapchainCreateInfoKHR.Buffer = VkSwapchainCreateInfoKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.SWAPCHAIN_CREATE_INFO_KHR }
fun MemoryStack.SwapchainCreateInfoKHR(capacity: Int, block: VkSwapchainCreateInfoKHR.Buffer.() -> Unit): VkSwapchainCreateInfoKHR.Buffer = SwapchainCreateInfoKHR(capacity).also(block)

fun MemoryStack.SwapchainDisplayNativeHdrCreateInfoAMD(): VkSwapchainDisplayNativeHdrCreateInfoAMD = VkSwapchainDisplayNativeHdrCreateInfoAMD.callocStack(this).apply { type = VkStructureType.SWAPCHAIN_DISPLAY_NATIVE_HDR_CREATE_INFO_AMD }
fun MemoryStack.SwapchainDisplayNativeHdrCreateInfoAMD(block: VkSwapchainDisplayNativeHdrCreateInfoAMD.() -> Unit): VkSwapchainDisplayNativeHdrCreateInfoAMD = SwapchainDisplayNativeHdrCreateInfoAMD().also(block)
fun MemoryStack.SwapchainDisplayNativeHdrCreateInfoAMD(capacity: Int): VkSwapchainDisplayNativeHdrCreateInfoAMD.Buffer = VkSwapchainDisplayNativeHdrCreateInfoAMD.callocStack(capacity, this).onEach { it.type = VkStructureType.SWAPCHAIN_DISPLAY_NATIVE_HDR_CREATE_INFO_AMD }
fun MemoryStack.SwapchainDisplayNativeHdrCreateInfoAMD(capacity: Int, block: VkSwapchainDisplayNativeHdrCreateInfoAMD.Buffer.() -> Unit): VkSwapchainDisplayNativeHdrCreateInfoAMD.Buffer = SwapchainDisplayNativeHdrCreateInfoAMD(capacity).also(block)

fun MemoryStack.TextureLODGatherFormatPropertiesAMD(): VkTextureLODGatherFormatPropertiesAMD = VkTextureLODGatherFormatPropertiesAMD.callocStack(this).apply { type = VkStructureType.TEXTURE_LOD_GATHER_FORMAT_PROPERTIES_AMD }
fun MemoryStack.TextureLODGatherFormatPropertiesAMD(block: VkTextureLODGatherFormatPropertiesAMD.() -> Unit): VkTextureLODGatherFormatPropertiesAMD = TextureLODGatherFormatPropertiesAMD().also(block)
fun MemoryStack.TextureLODGatherFormatPropertiesAMD(capacity: Int): VkTextureLODGatherFormatPropertiesAMD.Buffer = VkTextureLODGatherFormatPropertiesAMD.callocStack(capacity, this).onEach { it.type = VkStructureType.TEXTURE_LOD_GATHER_FORMAT_PROPERTIES_AMD }
fun MemoryStack.TextureLODGatherFormatPropertiesAMD(capacity: Int, block: VkTextureLODGatherFormatPropertiesAMD.Buffer.() -> Unit): VkTextureLODGatherFormatPropertiesAMD.Buffer = TextureLODGatherFormatPropertiesAMD(capacity).also(block)

fun MemoryStack.ValidationCacheCreateInfoEXT(): VkValidationCacheCreateInfoEXT = VkValidationCacheCreateInfoEXT.callocStack(this).apply { type = VkStructureType.VALIDATION_CACHE_CREATE_INFO_EXT }
fun MemoryStack.ValidationCacheCreateInfoEXT(block: VkValidationCacheCreateInfoEXT.() -> Unit): VkValidationCacheCreateInfoEXT = ValidationCacheCreateInfoEXT().also(block)
fun MemoryStack.ValidationCacheCreateInfoEXT(capacity: Int): VkValidationCacheCreateInfoEXT.Buffer = VkValidationCacheCreateInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.VALIDATION_CACHE_CREATE_INFO_EXT }
fun MemoryStack.ValidationCacheCreateInfoEXT(capacity: Int, block: VkValidationCacheCreateInfoEXT.Buffer.() -> Unit): VkValidationCacheCreateInfoEXT.Buffer = ValidationCacheCreateInfoEXT(capacity).also(block)

fun MemoryStack.ValidationFeaturesEXT(): VkValidationFeaturesEXT = VkValidationFeaturesEXT.callocStack(this).apply { type = VkStructureType.VALIDATION_FEATURES_EXT }
fun MemoryStack.ValidationFeaturesEXT(block: VkValidationFeaturesEXT.() -> Unit): VkValidationFeaturesEXT = ValidationFeaturesEXT().also(block)
fun MemoryStack.ValidationFeaturesEXT(capacity: Int): VkValidationFeaturesEXT.Buffer = VkValidationFeaturesEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.VALIDATION_FEATURES_EXT }
fun MemoryStack.ValidationFeaturesEXT(capacity: Int, block: VkValidationFeaturesEXT.Buffer.() -> Unit): VkValidationFeaturesEXT.Buffer = ValidationFeaturesEXT(capacity).also(block)

fun MemoryStack.ValidationFlagsEXT(): VkValidationFlagsEXT = VkValidationFlagsEXT.callocStack(this).apply { type = VkStructureType.VALIDATION_FLAGS_EXT }
fun MemoryStack.ValidationFlagsEXT(block: VkValidationFlagsEXT.() -> Unit): VkValidationFlagsEXT = ValidationFlagsEXT().also(block)
fun MemoryStack.ValidationFlagsEXT(capacity: Int): VkValidationFlagsEXT.Buffer = VkValidationFlagsEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.VALIDATION_FLAGS_EXT }
fun MemoryStack.ValidationFlagsEXT(capacity: Int, block: VkValidationFlagsEXT.Buffer.() -> Unit): VkValidationFlagsEXT.Buffer = ValidationFlagsEXT(capacity).also(block)

fun MemoryStack.VertexInputAttributeDescription(): VkVertexInputAttributeDescription = VkVertexInputAttributeDescription.callocStack(this)
fun MemoryStack.VertexInputAttributeDescription(block: VkVertexInputAttributeDescription.() -> Unit): VkVertexInputAttributeDescription = VertexInputAttributeDescription().also(block)
fun MemoryStack.VertexInputAttributeDescription(capacity: Int): VkVertexInputAttributeDescription.Buffer = VkVertexInputAttributeDescription.callocStack(capacity, this)
fun MemoryStack.VertexInputAttributeDescription(capacity: Int, block: VkVertexInputAttributeDescription.Buffer.() -> Unit): VkVertexInputAttributeDescription.Buffer = VertexInputAttributeDescription(capacity).also(block)

fun MemoryStack.VertexInputBindingDescription(): VkVertexInputBindingDescription = VkVertexInputBindingDescription.callocStack(this)
fun MemoryStack.VertexInputBindingDescription(block: VkVertexInputBindingDescription.() -> Unit): VkVertexInputBindingDescription = VertexInputBindingDescription().also(block)
fun MemoryStack.VertexInputBindingDescription(capacity: Int): VkVertexInputBindingDescription.Buffer = VkVertexInputBindingDescription.callocStack(capacity, this)
fun MemoryStack.VertexInputBindingDescription(capacity: Int, block: VkVertexInputBindingDescription.Buffer.() -> Unit): VkVertexInputBindingDescription.Buffer = VertexInputBindingDescription(capacity).also(block)

fun MemoryStack.VertexInputBindingDivisorDescriptionEXT(): VkVertexInputBindingDivisorDescriptionEXT = VkVertexInputBindingDivisorDescriptionEXT.callocStack(this)
fun MemoryStack.VertexInputBindingDivisorDescriptionEXT(block: VkVertexInputBindingDivisorDescriptionEXT.() -> Unit): VkVertexInputBindingDivisorDescriptionEXT = VertexInputBindingDivisorDescriptionEXT().also(block)
fun MemoryStack.VertexInputBindingDivisorDescriptionEXT(capacity: Int): VkVertexInputBindingDivisorDescriptionEXT.Buffer = VkVertexInputBindingDivisorDescriptionEXT.callocStack(capacity, this)
fun MemoryStack.VertexInputBindingDivisorDescriptionEXT(capacity: Int, block: VkVertexInputBindingDivisorDescriptionEXT.Buffer.() -> Unit): VkVertexInputBindingDivisorDescriptionEXT.Buffer = VertexInputBindingDivisorDescriptionEXT(capacity).also(block)

fun MemoryStack.Viewport(): VkViewport = VkViewport.callocStack(this)
fun MemoryStack.Viewport(block: VkViewport.() -> Unit): VkViewport = Viewport().also(block)
fun MemoryStack.Viewport(capacity: Int): VkViewport.Buffer = VkViewport.callocStack(capacity, this)
fun MemoryStack.Viewport(capacity: Int, block: VkViewport.Buffer.() -> Unit): VkViewport.Buffer = Viewport(capacity).also(block)

fun MemoryStack.ViewportSwizzleNV(): VkViewportSwizzleNV = VkViewportSwizzleNV.callocStack(this)
fun MemoryStack.ViewportSwizzleNV(block: VkViewportSwizzleNV.() -> Unit): VkViewportSwizzleNV = ViewportSwizzleNV().also(block)
fun MemoryStack.ViewportSwizzleNV(capacity: Int): VkViewportSwizzleNV.Buffer = VkViewportSwizzleNV.callocStack(capacity, this)
fun MemoryStack.ViewportSwizzleNV(capacity: Int, block: VkViewportSwizzleNV.Buffer.() -> Unit): VkViewportSwizzleNV.Buffer = ViewportSwizzleNV(capacity).also(block)

fun MemoryStack.ViewportWScalingNV(): VkViewportWScalingNV = VkViewportWScalingNV.callocStack(this)
fun MemoryStack.ViewportWScalingNV(block: VkViewportWScalingNV.() -> Unit): VkViewportWScalingNV = ViewportWScalingNV().also(block)
fun MemoryStack.ViewportWScalingNV(capacity: Int): VkViewportWScalingNV.Buffer = VkViewportWScalingNV.callocStack(capacity, this)
fun MemoryStack.ViewportWScalingNV(capacity: Int, block: VkViewportWScalingNV.Buffer.() -> Unit): VkViewportWScalingNV.Buffer = ViewportWScalingNV(capacity).also(block)

fun MemoryStack.XYColorEXT(): VkXYColorEXT = VkXYColorEXT.callocStack(this)
fun MemoryStack.XYColorEXT(block: VkXYColorEXT.() -> Unit): VkXYColorEXT = XYColorEXT().also(block)
fun MemoryStack.XYColorEXT(capacity: Int): VkXYColorEXT.Buffer = VkXYColorEXT.callocStack(capacity, this)
fun MemoryStack.XYColorEXT(capacity: Int, block: VkXYColorEXT.Buffer.() -> Unit): VkXYColorEXT.Buffer = XYColorEXT(capacity).also(block)

fun MemoryStack.WaylandSurfaceCreateInfoKHR(): VkWaylandSurfaceCreateInfoKHR = VkWaylandSurfaceCreateInfoKHR.callocStack(this).apply { type = VkStructureType.WAYLAND_SURFACE_CREATE_INFO_KHR }
fun MemoryStack.WaylandSurfaceCreateInfoKHR(block: VkWaylandSurfaceCreateInfoKHR.() -> Unit): VkWaylandSurfaceCreateInfoKHR = WaylandSurfaceCreateInfoKHR().also(block)
fun MemoryStack.WaylandSurfaceCreateInfoKHR(capacity: Int): VkWaylandSurfaceCreateInfoKHR.Buffer = VkWaylandSurfaceCreateInfoKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.WAYLAND_SURFACE_CREATE_INFO_KHR }
fun MemoryStack.WaylandSurfaceCreateInfoKHR(capacity: Int, block: VkWaylandSurfaceCreateInfoKHR.Buffer.() -> Unit): VkWaylandSurfaceCreateInfoKHR.Buffer = WaylandSurfaceCreateInfoKHR(capacity).also(block)

fun MemoryStack.Win32KeyedMutexAcquireReleaseInfoKHR(): VkWin32KeyedMutexAcquireReleaseInfoKHR = VkWin32KeyedMutexAcquireReleaseInfoKHR.callocStack(this).apply { type = VkStructureType.WIN32_KEYED_MUTEX_ACQUIRE_RELEASE_INFO_KHR }
fun MemoryStack.Win32KeyedMutexAcquireReleaseInfoKHR(block: VkWin32KeyedMutexAcquireReleaseInfoKHR.() -> Unit): VkWin32KeyedMutexAcquireReleaseInfoKHR = Win32KeyedMutexAcquireReleaseInfoKHR().also(block)
fun MemoryStack.Win32KeyedMutexAcquireReleaseInfoKHR(capacity: Int): VkWin32KeyedMutexAcquireReleaseInfoKHR.Buffer = VkWin32KeyedMutexAcquireReleaseInfoKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.WIN32_KEYED_MUTEX_ACQUIRE_RELEASE_INFO_KHR }
fun MemoryStack.Win32KeyedMutexAcquireReleaseInfoKHR(capacity: Int, block: VkWin32KeyedMutexAcquireReleaseInfoKHR.Buffer.() -> Unit): VkWin32KeyedMutexAcquireReleaseInfoKHR.Buffer = Win32KeyedMutexAcquireReleaseInfoKHR(capacity).also(block)

fun MemoryStack.Win32KeyedMutexAcquireReleaseInfoNV(): VkWin32KeyedMutexAcquireReleaseInfoNV = VkWin32KeyedMutexAcquireReleaseInfoNV.callocStack(this).apply { type = VkStructureType.WIN32_KEYED_MUTEX_ACQUIRE_RELEASE_INFO_NV }
fun MemoryStack.Win32KeyedMutexAcquireReleaseInfoNV(block: VkWin32KeyedMutexAcquireReleaseInfoNV.() -> Unit): VkWin32KeyedMutexAcquireReleaseInfoNV = Win32KeyedMutexAcquireReleaseInfoNV().also(block)
fun MemoryStack.Win32KeyedMutexAcquireReleaseInfoNV(capacity: Int): VkWin32KeyedMutexAcquireReleaseInfoNV.Buffer = VkWin32KeyedMutexAcquireReleaseInfoNV.callocStack(capacity, this).onEach { it.type = VkStructureType.WIN32_KEYED_MUTEX_ACQUIRE_RELEASE_INFO_NV }
fun MemoryStack.Win32KeyedMutexAcquireReleaseInfoNV(capacity: Int, block: VkWin32KeyedMutexAcquireReleaseInfoNV.Buffer.() -> Unit): VkWin32KeyedMutexAcquireReleaseInfoNV.Buffer = Win32KeyedMutexAcquireReleaseInfoNV(capacity).also(block)

fun MemoryStack.Win32SurfaceCreateInfoKHR(): VkWin32SurfaceCreateInfoKHR = VkWin32SurfaceCreateInfoKHR.callocStack(this).apply { type = VkStructureType.WIN32_SURFACE_CREATE_INFO_KHR }
fun MemoryStack.Win32SurfaceCreateInfoKHR(block: VkWin32SurfaceCreateInfoKHR.() -> Unit): VkWin32SurfaceCreateInfoKHR = Win32SurfaceCreateInfoKHR().also(block)
fun MemoryStack.Win32SurfaceCreateInfoKHR(capacity: Int): VkWin32SurfaceCreateInfoKHR.Buffer = VkWin32SurfaceCreateInfoKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.WIN32_SURFACE_CREATE_INFO_KHR }
fun MemoryStack.Win32SurfaceCreateInfoKHR(capacity: Int, block: VkWin32SurfaceCreateInfoKHR.Buffer.() -> Unit): VkWin32SurfaceCreateInfoKHR.Buffer = Win32SurfaceCreateInfoKHR(capacity).also(block)

fun MemoryStack.WriteDescriptorSet(): VkWriteDescriptorSet = VkWriteDescriptorSet.callocStack(this).apply { type = VkStructureType.WRITE_DESCRIPTOR_SET }
fun MemoryStack.WriteDescriptorSet(block: VkWriteDescriptorSet.() -> Unit): VkWriteDescriptorSet = WriteDescriptorSet().also(block)
fun MemoryStack.WriteDescriptorSet(capacity: Int): VkWriteDescriptorSet.Buffer = VkWriteDescriptorSet.callocStack(capacity, this).onEach { it.type = VkStructureType.WRITE_DESCRIPTOR_SET }
fun MemoryStack.WriteDescriptorSet(capacity: Int, block: VkWriteDescriptorSet.Buffer.() -> Unit): VkWriteDescriptorSet.Buffer = WriteDescriptorSet(capacity).also(block)

fun MemoryStack.WriteDescriptorSetAccelerationStructureNV(): VkWriteDescriptorSetAccelerationStructureNV = VkWriteDescriptorSetAccelerationStructureNV.callocStack(this).apply { type = VkStructureType.WRITE_DESCRIPTOR_SET_ACCELERATION_STRUCTURE_NV }
fun MemoryStack.WriteDescriptorSetAccelerationStructureNV(block: VkWriteDescriptorSetAccelerationStructureNV.() -> Unit): VkWriteDescriptorSetAccelerationStructureNV = WriteDescriptorSetAccelerationStructureNV().also(block)
fun MemoryStack.WriteDescriptorSetAccelerationStructureNV(capacity: Int): VkWriteDescriptorSetAccelerationStructureNV.Buffer = VkWriteDescriptorSetAccelerationStructureNV.callocStack(capacity, this).onEach { it.type = VkStructureType.WRITE_DESCRIPTOR_SET_ACCELERATION_STRUCTURE_NV }
fun MemoryStack.WriteDescriptorSetAccelerationStructureNV(capacity: Int, block: VkWriteDescriptorSetAccelerationStructureNV.Buffer.() -> Unit): VkWriteDescriptorSetAccelerationStructureNV.Buffer = WriteDescriptorSetAccelerationStructureNV(capacity).also(block)

fun MemoryStack.WriteDescriptorSetInlineUniformBlockEXT(): VkWriteDescriptorSetInlineUniformBlockEXT = VkWriteDescriptorSetInlineUniformBlockEXT.callocStack(this).apply { type = VkStructureType.WRITE_DESCRIPTOR_SET_INLINE_UNIFORM_BLOCK_EXT }
fun MemoryStack.WriteDescriptorSetInlineUniformBlockEXT(block: VkWriteDescriptorSetInlineUniformBlockEXT.() -> Unit): VkWriteDescriptorSetInlineUniformBlockEXT = WriteDescriptorSetInlineUniformBlockEXT().also(block)
fun MemoryStack.WriteDescriptorSetInlineUniformBlockEXT(capacity: Int): VkWriteDescriptorSetInlineUniformBlockEXT.Buffer = VkWriteDescriptorSetInlineUniformBlockEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.WRITE_DESCRIPTOR_SET_INLINE_UNIFORM_BLOCK_EXT }
fun MemoryStack.WriteDescriptorSetInlineUniformBlockEXT(capacity: Int, block: VkWriteDescriptorSetInlineUniformBlockEXT.Buffer.() -> Unit): VkWriteDescriptorSetInlineUniformBlockEXT.Buffer = WriteDescriptorSetInlineUniformBlockEXT(capacity).also(block)

fun MemoryStack.XlibSurfaceCreateInfoKHR(): VkXlibSurfaceCreateInfoKHR = VkXlibSurfaceCreateInfoKHR.callocStack(this).apply { type = VkStructureType.XLIB_SURFACE_CREATE_INFO_KHR }
fun MemoryStack.XlibSurfaceCreateInfoKHR(block: VkXlibSurfaceCreateInfoKHR.() -> Unit): VkXlibSurfaceCreateInfoKHR = XlibSurfaceCreateInfoKHR().also(block)
fun MemoryStack.XlibSurfaceCreateInfoKHR(capacity: Int): VkXlibSurfaceCreateInfoKHR.Buffer = VkXlibSurfaceCreateInfoKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.XLIB_SURFACE_CREATE_INFO_KHR }
fun MemoryStack.XlibSurfaceCreateInfoKHR(capacity: Int, block: VkXlibSurfaceCreateInfoKHR.Buffer.() -> Unit): VkXlibSurfaceCreateInfoKHR.Buffer = XlibSurfaceCreateInfoKHR(capacity).also(block)

