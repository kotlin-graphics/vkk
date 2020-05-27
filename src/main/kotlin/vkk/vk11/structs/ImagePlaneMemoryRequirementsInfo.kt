package vkk.vk11.structs

import kool.Ptr
import org.lwjgl.system.MemoryUtil.NULL
import vkk.VkImageAspect
import vkk.VkStructureType

/**
 * Structure specifying image plane for memory requirements.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>If the image&#8217;s tiling is {@link VK10#VK_IMAGE_TILING_LINEAR IMAGE_TILING_LINEAR} or {@link VK10#VK_IMAGE_TILING_OPTIMAL IMAGE_TILING_OPTIMAL}, then {@code planeAspect} <b>must</b> be a single valid <em>format plane</em> for the image. (That is, for a two-plane image {@code planeAspect} <b>must</b> be {@link VK11#VK_IMAGE_ASPECT_PLANE_0_BIT IMAGE_ASPECT_PLANE_0_BIT} or {@link VK11#VK_IMAGE_ASPECT_PLANE_1_BIT IMAGE_ASPECT_PLANE_1_BIT}, and for a three-plane image {@code planeAspect} <b>must</b> be {@link VK11#VK_IMAGE_ASPECT_PLANE_0_BIT IMAGE_ASPECT_PLANE_0_BIT}, {@link VK11#VK_IMAGE_ASPECT_PLANE_1_BIT IMAGE_ASPECT_PLANE_1_BIT} or {@link VK11#VK_IMAGE_ASPECT_PLANE_2_BIT IMAGE_ASPECT_PLANE_2_BIT}).</li>
 * <li>If the image&#8217;s tiling is {@link EXTImageDrmFormatModifier#VK_IMAGE_TILING_DRM_FORMAT_MODIFIER_EXT IMAGE_TILING_DRM_FORMAT_MODIFIER_EXT}, then {@code planeAspect} <b>must</b> be a single valid <em>memory plane</em> for the image. (That is, {@code aspectMask} <b>must</b> specify a plane index that is less than the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#VkDrmFormatModifierPropertiesEXT">{@code drmFormatModifierPlaneCount}</a> associated with the image&#8217;s <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#VkImageCreateInfo">{@code format}</a> and <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#VkImageDrmFormatModifierPropertiesEXT">{@code drmFormatModifier}</a>.)</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_IMAGE_PLANE_MEMORY_REQUIREMENTS_INFO STRUCTURE_TYPE_IMAGE_PLANE_MEMORY_REQUIREMENTS_INFO}</li>
 * <li>{@code planeAspect} <b>must</b> be a valid {@code VkImageAspectFlagBits} value</li>
 * </ul>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code planeAspect} &ndash; the aspect corresponding to the image plane to query.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkImagePlaneMemoryRequirementsInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkImageAspectFlagBits planeAspect;
 * }</code></pre>
 */
class ImagePlaneMemoryRequirementsInfo(
        var planeAspect: VkImageAspect,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.IMAGE_PLANE_MEMORY_REQUIREMENTS_INFO
}