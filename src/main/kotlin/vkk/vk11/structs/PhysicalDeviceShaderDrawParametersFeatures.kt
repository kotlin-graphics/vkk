package vkk.vk11.structs

import kool.Ptr
import org.lwjgl.system.MemoryUtil.NULL
import vkk.VkStructureType

/**
 * Structure describing shader draw parameter features that can be supported by an implementation.
 *
 * <h5>Description</h5>
 *
 * <p>If the {@link VkPhysicalDeviceShaderDrawParametersFeatures} structure is included in the {@code pNext} chain of {@link VkPhysicalDeviceFeatures2}, it is filled with a value indicating whether the feature is supported.</p>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SHADER_DRAW_PARAMETERS_FEATURES STRUCTURE_TYPE_PHYSICAL_DEVICE_SHADER_DRAW_PARAMETERS_FEATURES}</li>
 * </ul>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code shaderDrawParameters} &ndash; specifies whether shader draw parameters are supported.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPhysicalDeviceShaderDrawParametersFeatures {
 *     VkStructureType sType;
 *     void * pNext;
 *     VkBool32 shaderDrawParameters;
 * }</code></pre>
 */
class PhysicalDeviceShaderDrawParametersFeatures(
    var shaderDrawParameters: Boolean,
    var next: Ptr = NULL
) {

    val type get() = VkStructureType.PHYSICAL_DEVICE_SHADER_DRAW_PARAMETERS_FEATURES
}