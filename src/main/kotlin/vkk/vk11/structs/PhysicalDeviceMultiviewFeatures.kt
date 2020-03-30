package vkk.vk11.structs

import kool.Ptr
import org.lwjgl.system.MemoryUtil.NULL
import vkk.VkStructureType

/**
 * Structure describing multiview features that can be supported by an implementation.
 *
 * <h5>Description</h5>
 *
 * <p>If the {@link VkPhysicalDeviceMultiviewFeatures} structure is included in the {@code pNext} chain of {@link VkPhysicalDeviceFeatures2}, it is filled with values indicating whether each feature is supported. {@link VkPhysicalDeviceMultiviewFeatures} <b>can</b> also be used in the {@code pNext} chain of {@link VkDeviceCreateInfo} to enable the features.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>If {@code multiviewGeometryShader} is enabled then {@code multiview} <b>must</b> also be enabled.</li>
 * <li>If {@code multiviewTessellationShader} is enabled then {@code multiview} <b>must</b> also be enabled.</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_MULTIVIEW_FEATURES STRUCTURE_TYPE_PHYSICAL_DEVICE_MULTIVIEW_FEATURES}</li>
 * </ul>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code multiview} &ndash; specifies whether the implementation supports multiview rendering within a render pass. If this feature is not enabled, the view mask of each subpass <b>must</b> always be zero.</li>
 * <li>{@code multiviewGeometryShader} &ndash; specifies whether the implementation supports multiview rendering within a render pass, with <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#geometry">geometry shaders</a>. If this feature is not enabled, then a pipeline compiled against a subpass with a non-zero view mask <b>must</b> not include a geometry shader.</li>
 * <li>{@code multiviewTessellationShader} &ndash; specifies whether the implementation supports multiview rendering within a render pass, with <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#tessellation">tessellation shaders</a>. If this feature is not enabled, then a pipeline compiled against a subpass with a non-zero view mask <b>must</b> not include any tessellation shaders.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPhysicalDeviceMultiviewFeatures {
 *     VkStructureType sType;
 *     void * pNext;
 *     VkBool32 multiview;
 *     VkBool32 multiviewGeometryShader;
 *     VkBool32 multiviewTessellationShader;
 * }</code></pre>
 */
class PhysicalDeviceMultiviewFeatures(
    var multiview: Boolean,
    var multiviewGeometryShader: Boolean,
    var multiviewTessellationShader: Boolean,
    var next: Ptr = NULL
) {

    val type get() = VkStructureType.PHYSICAL_DEVICE_MULTIVIEW_FEATURES
}