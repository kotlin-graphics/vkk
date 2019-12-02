package vkk._11.structs

import kool.Ptr
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.NULL
import vkk.VkStructureType

/**
 * Structure describing Y'CbCr conversion features that can be supported by an implementation.
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SAMPLER_YCBCR_CONVERSION_FEATURES STRUCTURE_TYPE_PHYSICAL_DEVICE_SAMPLER_YCBCR_CONVERSION_FEATURES}</li>
 * </ul>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code samplerYcbcrConversion} &ndash; specifies whether the implementation supports <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#samplers-YCbCr-conversion">sampler Y&#8217;C<sub>B</sub>C<sub>R</sub> conversion</a>. If {@code samplerYcbcrConversion} is {@link VK10#VK_FALSE FALSE}, sampler Y&#8217;C<sub>B</sub>C<sub>R</sub> conversion is not supported, and samplers using sampler Y&#8217;C<sub>B</sub>C<sub>R</sub> conversion <b>must</b> not be used.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPhysicalDeviceSamplerYcbcrConversionFeatures {
 *     VkStructureType sType;
 *     void * pNext;
 *     VkBool32 samplerYcbcrConversion;
 * }</code></pre>
 */
class PhysicalDeviceSamplerYcbcrConversionFeatures(
        var samplerYcbcrConversion: Boolean,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.PHYSICAL_DEVICE_SAMPLER_YCBCR_CONVERSION_FEATURES
}