package vkk.vk11.structs

import kool.Ptr
import org.lwjgl.system.MemoryUtil.NULL
import vkk.VkShaderStageFlags
import vkk.VkStructureType
import vkk.VkSubgroupFeatureFlags

/**
 * Structure describing subgroup support for an implementation.
 *
 * <h5>Description</h5>
 *
 * <p>If the {@link VkPhysicalDeviceSubgroupProperties} structure is included in the {@code pNext} chain of {@link VkPhysicalDeviceProperties2}, it is filled with the implementation-dependent limits.</p>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SUBGROUP_PROPERTIES STRUCTURE_TYPE_PHYSICAL_DEVICE_SUBGROUP_PROPERTIES}</li>
 * </ul>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code subgroupSize} &ndash; the default number of invocations in each subgroup. {@code subgroupSize} is at least 1 if any of the physical device&#8217;s queues support {@link VK10#VK_QUEUE_GRAPHICS_BIT QUEUE_GRAPHICS_BIT} or {@link VK10#VK_QUEUE_COMPUTE_BIT QUEUE_COMPUTE_BIT}.</li>
 * <li>{@code supportedStages} &ndash; a bitfield of {@code VkShaderStageFlagBits} describing the shader stages that subgroup operations are supported in. {@code supportedStages} will have the {@link VK10#VK_SHADER_STAGE_COMPUTE_BIT SHADER_STAGE_COMPUTE_BIT} bit set if any of the physical device&#8217;s queues support {@link VK10#VK_QUEUE_COMPUTE_BIT QUEUE_COMPUTE_BIT}.</li>
 * <li>{@code supportedOperations} &ndash; a bitmask of {@code VkSubgroupFeatureFlagBits} specifying the sets of subgroup operations supported on this device. {@code supportedOperations} will have the {@link VK11#VK_SUBGROUP_FEATURE_BASIC_BIT SUBGROUP_FEATURE_BASIC_BIT} bit set if any of the physical device&#8217;s queues support {@link VK10#VK_QUEUE_GRAPHICS_BIT QUEUE_GRAPHICS_BIT} or {@link VK10#VK_QUEUE_COMPUTE_BIT QUEUE_COMPUTE_BIT}.</li>
 * <li>{@code quadOperationsInAllStages} &ndash; a boolean that specifies whether <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-subgroup-quad">quad subgroup operations</a> are available in all stages, or are restricted to fragment and compute stages.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPhysicalDeviceSubgroupProperties {
 *     VkStructureType sType;
 *     void * pNext;
 *     uint32_t subgroupSize;
 *     VkShaderStageFlags supportedStages;
 *     VkSubgroupFeatureFlags supportedOperations;
 *     VkBool32 quadOperationsInAllStages;
 * }</code></pre>
 */
class PhysicalDeviceSubgroupProperties(
        var subgroupSize: Int,
        var supportedStages: VkShaderStageFlags,
        var supportedOperations: VkSubgroupFeatureFlags,
        var quadOperationsInAllStages: Boolean,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.PHYSICAL_DEVICE_SUBGROUP_PROPERTIES
}