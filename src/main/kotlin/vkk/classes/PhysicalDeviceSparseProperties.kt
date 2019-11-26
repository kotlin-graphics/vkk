package classes

/**
 * Structure specifying physical device sparse memory properties.
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code residencyStandard2DBlockShape} &ndash; {@link VK10#VK_TRUE TRUE} if the physical device will access all single-sample 2D sparse resources using the standard sparse image block shapes (based on image format), as described in the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#sparsememory-sparseblockshapessingle">Standard Sparse Image Block Shapes (Single Sample)</a> table. If this property is not supported the value returned in the {@code imageGranularity} member of the {@link VkSparseImageFormatProperties} structure for single-sample 2D images is not required: to match the standard sparse image block dimensions listed in the table.</li>
 * <li>{@code residencyStandard2DMultisampleBlockShape} &ndash; {@link VK10#VK_TRUE TRUE} if the physical device will access all multisample 2D sparse resources using the standard sparse image block shapes (based on image format), as described in the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#sparsememory-sparseblockshapesmsaa">Standard Sparse Image Block Shapes (MSAA)</a> table. If this property is not supported, the value returned in the {@code imageGranularity} member of the {@link VkSparseImageFormatProperties} structure for multisample 2D images is not required: to match the standard sparse image block dimensions listed in the table.</li>
 * <li>{@code residencyStandard3DBlockShape} &ndash; {@link VK10#VK_TRUE TRUE} if the physical device will access all 3D sparse resources using the standard sparse image block shapes (based on image format), as described in the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#sparsememory-sparseblockshapessingle">Standard Sparse Image Block Shapes (Single Sample)</a> table. If this property is not supported, the value returned in the {@code imageGranularity} member of the {@link VkSparseImageFormatProperties} structure for 3D images is not required: to match the standard sparse image block dimensions listed in the table.</li>
 * <li>{@code residencyAlignedMipSize} &ndash; {@link VK10#VK_TRUE TRUE} if images with mip level dimensions that are not integer multiples of the corresponding dimensions of the sparse image block <b>may</b> be placed in the mip tail. If this property is not reported, only mip levels with dimensions smaller than the {@code imageGranularity} member of the {@link VkSparseImageFormatProperties} structure will be placed in the mip tail. If this property is reported the implementation is allowed to return {@link VK10#VK_SPARSE_IMAGE_FORMAT_ALIGNED_MIP_SIZE_BIT SPARSE_IMAGE_FORMAT_ALIGNED_MIP_SIZE_BIT} in the {@code flags} member of {@link VkSparseImageFormatProperties}, indicating that mip level dimensions that are not integer multiples of the corresponding dimensions of the sparse image block will be placed in the mip tail.</li>
 * <li>{@code residencyNonResidentStrict} &ndash; specifies whether the physical device <b>can</b> consistently access non-resident regions of a resource. If this property is {@link VK10#VK_TRUE TRUE}, access to non-resident regions of resources will be guaranteed to return values as if the resource were populated with 0; writes to non-resident regions will be discarded.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPhysicalDeviceSparseProperties {
 *     VkBool32 residencyStandard2DBlockShape;
 *     VkBool32 residencyStandard2DMultisampleBlockShape;
 *     VkBool32 residencyStandard3DBlockShape;
 *     VkBool32 residencyAlignedMipSize;
 *     VkBool32 residencyNonResidentStrict;
 * }</code></pre>
 */
class PhysicalDeviceSparseProperties(
    var residencyStandard2DBlockShape: Boolean,
    var residencyStandard2DMultisampleBlockShape: Boolean,
    var residencyStandard3DBlockShape: Boolean,
    var residencyAlignedMipSize: Boolean,
    var residencyNonResidentStrict: Boolean
) {


}