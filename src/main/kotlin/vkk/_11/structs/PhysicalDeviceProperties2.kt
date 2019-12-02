package vkk._11.structs

import kool.Ptr
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.NULL
import vkk.VkStructureType
import vkk._10.structs.PhysicalDeviceProperties

/**
 * Structure specifying physical device properties.
 *
 * <h5>Description</h5>
 *
 * <p>The {@code pNext} chain of this structure is used to extend the structure with properties defined by extensions.</p>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_PROPERTIES_2 STRUCTURE_TYPE_PHYSICAL_DEVICE_PROPERTIES_2}</li>
 * <li>Each {@code pNext} member of any structure (including this one) in the {@code pNext} chain <b>must</b> be either {@code NULL} or a pointer to a valid instance of {@link VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT}, {@link VkPhysicalDeviceConservativeRasterizationPropertiesEXT}, {@link VkPhysicalDeviceCooperativeMatrixPropertiesNV}, {@link VkPhysicalDeviceDepthStencilResolvePropertiesKHR}, {@link VkPhysicalDeviceDescriptorIndexingPropertiesEXT}, {@link VkPhysicalDeviceDiscardRectanglePropertiesEXT}, {@link VkPhysicalDeviceDriverPropertiesKHR}, {@link VkPhysicalDeviceExternalMemoryHostPropertiesEXT}, {@link VkPhysicalDeviceFloatControlsPropertiesKHR}, {@link VkPhysicalDeviceFragmentDensityMapPropertiesEXT}, {@link VkPhysicalDeviceIDProperties}, {@link VkPhysicalDeviceInlineUniformBlockPropertiesEXT}, {@link VkPhysicalDeviceLineRasterizationPropertiesEXT}, {@link VkPhysicalDeviceMaintenance3Properties}, {@link VkPhysicalDeviceMeshShaderPropertiesNV}, {@link VkPhysicalDeviceMultiviewPerViewAttributesPropertiesNVX}, {@link VkPhysicalDeviceMultiviewProperties}, {@link VkPhysicalDevicePCIBusInfoPropertiesEXT}, {@link VkPhysicalDevicePointClippingProperties}, {@link VkPhysicalDeviceProtectedMemoryProperties}, {@link VkPhysicalDevicePushDescriptorPropertiesKHR}, {@link VkPhysicalDeviceRayTracingPropertiesNV}, {@link VkPhysicalDeviceSampleLocationsPropertiesEXT}, {@link VkPhysicalDeviceSamplerFilterMinmaxPropertiesEXT}, {@link VkPhysicalDeviceShaderCoreProperties2AMD}, {@link VkPhysicalDeviceShaderCorePropertiesAMD}, {@link VkPhysicalDeviceShaderSMBuiltinsPropertiesNV}, {@link VkPhysicalDeviceShadingRateImagePropertiesNV}, {@link VkPhysicalDeviceSubgroupProperties}, {@link VkPhysicalDeviceSubgroupSizeControlPropertiesEXT}, {@link VkPhysicalDeviceTexelBufferAlignmentPropertiesEXT}, {@link VkPhysicalDeviceTransformFeedbackPropertiesEXT}, or {@link VkPhysicalDeviceVertexAttributeDivisorPropertiesEXT}</li>
 * <li>Each {@code sType} member in the {@code pNext} chain <b>must</b> be unique</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkPhysicalDeviceProperties}, {@link VK11#vkGetPhysicalDeviceProperties2 GetPhysicalDeviceProperties2}, {@link KHRGetPhysicalDeviceProperties2#vkGetPhysicalDeviceProperties2KHR GetPhysicalDeviceProperties2KHR}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code properties} &ndash; a structure of type {@link VkPhysicalDeviceProperties} describing the properties of the physical device. This structure is written with the same values as if it were written by {@link VK10#vkGetPhysicalDeviceProperties GetPhysicalDeviceProperties}.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPhysicalDeviceProperties2 {
 *     VkStructureType sType;
 *     void * pNext;
 *     {@link VkPhysicalDeviceProperties VkPhysicalDeviceProperties} properties;
 * }</code></pre>
 */
class PhysicalDeviceProperties2(
        var properties: PhysicalDeviceProperties,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.PHYSICAL_DEVICE_PROPERTIES_2
}