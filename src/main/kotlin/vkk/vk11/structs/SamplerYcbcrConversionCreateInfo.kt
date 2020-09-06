package vkk.vk11.structs

import glm_.i
import kool.Adr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkSamplerYcbcrConversionCreateInfo.*
import vkk.*
import vkk.vk10.structs.ComponentMapping

/**
 * Structure specifying the parameters of the newly created conversion.
 *
 * <h5>Description</h5>
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>Setting {@code forceExplicitReconstruction} to {@link VK10#VK_TRUE TRUE} <b>may</b> have a performance penalty on implementations where explicit reconstruction is not the default mode of operation.</p>
 * </div>
 *
 * <p>Sampler Y'C<sub>B</sub>C<sub>R</sub> conversion objects do not support <em>external format conversion</em> without additional extensions defining <em>external formats</em>.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code format} <b>must</b> not be {@link VK10#VK_FORMAT_UNDEFINED FORMAT_UNDEFINED}</li>
 * <li>{@code format} <b>must</b> support {@link VK11#VK_FORMAT_FEATURE_MIDPOINT_CHROMA_SAMPLES_BIT FORMAT_FEATURE_MIDPOINT_CHROMA_SAMPLES_BIT} or {@link VK11#VK_FORMAT_FEATURE_COSITED_CHROMA_SAMPLES_BIT FORMAT_FEATURE_COSITED_CHROMA_SAMPLES_BIT}</li>
 * <li>If the format does not support {@link VK11#VK_FORMAT_FEATURE_COSITED_CHROMA_SAMPLES_BIT FORMAT_FEATURE_COSITED_CHROMA_SAMPLES_BIT}, {@code xChromaOffset} and {@code yChromaOffset} <b>must</b> not be {@link VK11#VK_CHROMA_LOCATION_COSITED_EVEN CHROMA_LOCATION_COSITED_EVEN}</li>
 * <li>If the format does not support {@link VK11#VK_FORMAT_FEATURE_MIDPOINT_CHROMA_SAMPLES_BIT FORMAT_FEATURE_MIDPOINT_CHROMA_SAMPLES_BIT}, {@code xChromaOffset} and {@code yChromaOffset} <b>must</b> not be {@link VK11#VK_CHROMA_LOCATION_MIDPOINT CHROMA_LOCATION_MIDPOINT}</li>
 * <li>{@code format} <b>must</b> represent unsigned normalized values (i.e. the format must be a {@code UNORM} format)</li>
 * <li>If the format has a {@code _422} or {@code _420} suffix, then {@code components.g} <b>must</b> be {@link VK10#VK_COMPONENT_SWIZZLE_IDENTITY COMPONENT_SWIZZLE_IDENTITY}</li>
 * <li>If the format has a {@code _422} or {@code _420} suffix, then {@code components.a} <b>must</b> be {@link VK10#VK_COMPONENT_SWIZZLE_IDENTITY COMPONENT_SWIZZLE_IDENTITY}, {@link VK10#VK_COMPONENT_SWIZZLE_ONE COMPONENT_SWIZZLE_ONE}, or {@link VK10#VK_COMPONENT_SWIZZLE_ZERO COMPONENT_SWIZZLE_ZERO}</li>
 * <li>If the format has a {@code _422} or {@code _420} suffix, then {@code components.r} <b>must</b> be {@link VK10#VK_COMPONENT_SWIZZLE_IDENTITY COMPONENT_SWIZZLE_IDENTITY} or {@link VK10#VK_COMPONENT_SWIZZLE_B COMPONENT_SWIZZLE_B}</li>
 * <li>If the format has a {@code _422} or {@code _420} suffix, then {@code components.b} <b>must</b> be {@link VK10#VK_COMPONENT_SWIZZLE_IDENTITY COMPONENT_SWIZZLE_IDENTITY} or {@link VK10#VK_COMPONENT_SWIZZLE_R COMPONENT_SWIZZLE_R}</li>
 * <li>If the format has a {@code _422} or {@code _420} suffix, and if either {@code components.r} or {@code components.b} is {@link VK10#VK_COMPONENT_SWIZZLE_IDENTITY COMPONENT_SWIZZLE_IDENTITY}, both values <b>must</b> be {@link VK10#VK_COMPONENT_SWIZZLE_IDENTITY COMPONENT_SWIZZLE_IDENTITY}</li>
 * <li>If {@code ycbcrModel} is not {@link VK11#VK_SAMPLER_YCBCR_MODEL_CONVERSION_RGB_IDENTITY SAMPLER_YCBCR_MODEL_CONVERSION_RGB_IDENTITY}, then {@code components.r}, {@code components.g}, and {@code components.b} <b>must</b> correspond to channels of the {@code format}; that is, {@code components.r}, {@code components.g}, and {@code components.b} <b>must</b> not be {@link VK10#VK_COMPONENT_SWIZZLE_ZERO COMPONENT_SWIZZLE_ZERO} or {@link VK10#VK_COMPONENT_SWIZZLE_ONE COMPONENT_SWIZZLE_ONE}, and <b>must</b> not correspond to a channel which contains zero or one as a consequence of <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#textures-conversion-to-rgba">conversion to RGBA</a></li>
 * <li>If {@code ycbcrRange} is {@link VK11#VK_SAMPLER_YCBCR_RANGE_ITU_NARROW SAMPLER_YCBCR_RANGE_ITU_NARROW} then the R, G and B channels obtained by applying the {@code component} swizzle to {@code format} <b>must</b> each have a bit-depth greater than or equal to 8.</li>
 * <li>If the format does not support {@link VK11#VK_FORMAT_FEATURE_SAMPLED_IMAGE_YCBCR_CONVERSION_CHROMA_RECONSTRUCTION_EXPLICIT_FORCEABLE_BIT FORMAT_FEATURE_SAMPLED_IMAGE_YCBCR_CONVERSION_CHROMA_RECONSTRUCTION_EXPLICIT_FORCEABLE_BIT}, {@code forceExplicitReconstruction} <b>must</b> be FALSE</li>
 * <li>If the format does not support {@link VK11#VK_FORMAT_FEATURE_SAMPLED_IMAGE_YCBCR_CONVERSION_LINEAR_FILTER_BIT FORMAT_FEATURE_SAMPLED_IMAGE_YCBCR_CONVERSION_LINEAR_FILTER_BIT}, {@code chromaFilter} <b>must</b> be {@link VK10#VK_FILTER_NEAREST FILTER_NEAREST}</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_SAMPLER_YCBCR_CONVERSION_CREATE_INFO STRUCTURE_TYPE_SAMPLER_YCBCR_CONVERSION_CREATE_INFO}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL}</li>
 * <li>{@code format} <b>must</b> be a valid {@code VkFormat} value</li>
 * <li>{@code ycbcrModel} <b>must</b> be a valid {@code VkSamplerYcbcrModelConversion} value</li>
 * <li>{@code ycbcrRange} <b>must</b> be a valid {@code VkSamplerYcbcrRange} value</li>
 * <li>{@code components} <b>must</b> be a valid {@link VkComponentMapping} structure</li>
 * <li>{@code xChromaOffset} <b>must</b> be a valid {@code VkChromaLocation} value</li>
 * <li>{@code yChromaOffset} <b>must</b> be a valid {@code VkChromaLocation} value</li>
 * <li>{@code chromaFilter} <b>must</b> be a valid {@code VkFilter} value</li>
 * </ul>
 *
 * <p>If {@code chromaFilter} is {@link VK10#VK_FILTER_NEAREST FILTER_NEAREST}, chroma samples are reconstructed to luma channel resolution using nearest-neighbour sampling. Otherwise, chroma samples are reconstructed using interpolation. More details can be found in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#textures-sampler-YCbCr-conversion">the description of sampler Y'C<sub>B</sub>C<sub>R</sub> conversion</a> in the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#textures">Image Operations</a> chapter.</p>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkComponentMapping}, {@link VK11#vkCreateSamplerYcbcrConversion CreateSamplerYcbcrConversion}, {@link KHRSamplerYcbcrConversion#vkCreateSamplerYcbcrConversionKHR CreateSamplerYcbcrConversionKHR}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code format} &ndash; the format of the image from which color information will be retrieved.</li>
 * <li>{@code ycbcrModel} &ndash; describes the color matrix for conversion between color models.</li>
 * <li>{@code ycbcrRange} &ndash; describes whether the encoded values have headroom and foot room, or whether the encoding uses the full numerical range.</li>
 * <li>{@code components} &ndash; applies a <em>swizzle</em> based on {@code VkComponentSwizzle} enums prior to range expansion and color model conversion.</li>
 * <li>{@code xChromaOffset} &ndash; describes the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#textures-chroma-reconstruction">sample location</a> associated with downsampled chroma channels in the x dimension. {@code xChromaOffset} has no effect for formats in which chroma channels are the same resolution as the luma channel.</li>
 * <li>{@code yChromaOffset} &ndash; describes the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#textures-chroma-reconstruction">sample location</a> associated with downsampled chroma channels in the y dimension. {@code yChromaOffset} has no effect for formats in which the chroma channels are not downsampled vertically.</li>
 * <li>{@code chromaFilter} &ndash; the filter for chroma reconstruction.</li>
 * <li>{@code forceExplicitReconstruction} &ndash; <b>can</b> be used to ensure that reconstruction is done explicitly, if supported.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkSamplerYcbcrConversionCreateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkFormat format;
 *     VkSamplerYcbcrModelConversion ycbcrModel;
 *     VkSamplerYcbcrRange ycbcrRange;
 *     {@link VkComponentMapping VkComponentMapping} components;
 *     VkChromaLocation xChromaOffset;
 *     VkChromaLocation yChromaOffset;
 *     VkFilter chromaFilter;
 *     VkBool32 forceExplicitReconstruction;
 * }</code></pre>
 */
class SamplerYcbcrConversionCreateInfo(
    var format: VkFormat,
    var ycbcrModel: VkSamplerYcbcrModelConversion,
    var ycbcrRange: VkSamplerYcbcrRange,
    var components: ComponentMapping,
    var xChromaOffset: VkChromaLocation,
    var yChromaOffset: VkChromaLocation,
    var chromaFilter: VkFilter,
    var forceExplicitReconstruction: Boolean
) {

    val type get() = VkStructureType.SAMPLER_YCBCR_CONVERSION_CREATE_INFO

    infix fun write(stack: MemoryStack): Adr {
        val adr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
        nsType(adr, type.i)
        nformat(adr, format.i)
        nycbcrModel(adr, ycbcrModel.i)
        nycbcrRange(adr, ycbcrRange.i)
        components write (adr + COMPONENTS)
        nxChromaOffset(adr, xChromaOffset.i)
        nyChromaOffset(adr, yChromaOffset.i)
        nchromaFilter(adr, chromaFilter.i)
        nforceExplicitReconstruction(adr, forceExplicitReconstruction.i)
        return adr
    }
}