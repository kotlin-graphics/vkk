package vkk.vk10.structs

import glm_.i
import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.vulkan.VkSamplerCreateInfo.*
import vkk.*

/**
 * Structure specifying parameters of a newly created sampler.
 *
 * <h5>Description</h5>
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Mapping of OpenGL to Vulkan filter modes</h5>
 *
 * <p>{@code magFilter} values of {@link VK10#VK_FILTER_NEAREST FILTER_NEAREST} and {@link VK10#VK_FILTER_LINEAR FILTER_LINEAR} directly correspond to {@code GL_NEAREST} and {@code GL_LINEAR} magnification filters. {@code minFilter} and {@code mipmapMode} combine to correspond to the similarly named OpenGL minification filter of {@code GL_minFilter_MIPMAP_mipmapMode} (e.g. {@code minFilter} of {@link VK10#VK_FILTER_LINEAR FILTER_LINEAR} and {@code mipmapMode} of {@link VK10#VK_SAMPLER_MIPMAP_MODE_NEAREST SAMPLER_MIPMAP_MODE_NEAREST} correspond to {@code GL_LINEAR_MIPMAP_NEAREST}).</p>
 *
 * <p>There are no Vulkan filter modes that directly correspond to OpenGL minification filters of {@code GL_LINEAR} or {@code GL_NEAREST}, but they <b>can</b> be emulated using {@link VK10#VK_SAMPLER_MIPMAP_MODE_NEAREST SAMPLER_MIPMAP_MODE_NEAREST}, {@code minLod} = 0, and {@code maxLod} = 0.25, and using {@code minFilter} = {@link VK10#VK_FILTER_LINEAR FILTER_LINEAR} or {@code minFilter} = {@link VK10#VK_FILTER_NEAREST FILTER_NEAREST}, respectively.</p>
 *
 * <p>Note that using a {@code maxLod} of zero would cause <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#textures-texel-filtering">magnification</a> to always be performed, and the {@code magFilter} to always be used. This is valid, just not an exact match for OpenGL behavior. Clamping the maximum LOD to 0.25 allows the <code>λ</code> value to be non-zero and minification to be performed, while still always rounding down to the base level. If the {@code minFilter} and {@code magFilter} are equal, then using a {@code maxLod} of zero also works.</p>
 * </div>
 *
 * <p>The maximum number of sampler objects which <b>can</b> be simultaneously created on a device is implementation-dependent and specified by the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#limits-maxSamplerAllocationCount">maxSamplerAllocationCount</a> member of the {@link VkPhysicalDeviceLimits} structure. If {@code maxSamplerAllocationCount} is exceeded, {@code vkCreateSampler} will return {@link VK10#VK_ERROR_TOO_MANY_OBJECTS ERROR_TOO_MANY_OBJECTS}.</p>
 *
 * <p>Since {@code VkSampler} is a non-dispatchable handle type, implementations <b>may</b> return the same handle for sampler state vectors that are identical. In such cases, all such objects would only count once against the {@code maxSamplerAllocationCount} limit.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>The absolute value of {@code mipLodBias} <b>must</b> be less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxSamplerLodBias}</li>
 * <li>{@code maxLod} <b>must</b> be greater than or equal to {@code minLod}</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-samplerAnisotropy">anisotropic sampling</a> feature is not enabled, {@code anisotropyEnable} <b>must</b> be {@link VK10#VK_FALSE FALSE}</li>
 * <li>If {@code anisotropyEnable} is {@link VK10#VK_TRUE TRUE}, {@code maxAnisotropy} <b>must</b> be between {@code 1.0} and {@link VkPhysicalDeviceLimits}{@code ::maxSamplerAnisotropy}, inclusive</li>
 * <li>If <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#samplers-YCbCr-conversion">sampler Y&#8217;C<sub>B</sub>C<sub>R</sub> conversion</a> is enabled and {@link VK11#VK_FORMAT_FEATURE_SAMPLED_IMAGE_YCBCR_CONVERSION_SEPARATE_RECONSTRUCTION_FILTER_BIT FORMAT_FEATURE_SAMPLED_IMAGE_YCBCR_CONVERSION_SEPARATE_RECONSTRUCTION_FILTER_BIT} is not set for the format, {@code minFilter} and {@code magFilter} <b>must</b> be equal to the sampler Y&#8217;C<sub>B</sub>C<sub>R</sub> conversion&#8217;s {@code chromaFilter}</li>
 * <li>If {@code unnormalizedCoordinates} is {@link VK10#VK_TRUE TRUE}, {@code minFilter} and {@code magFilter} <b>must</b> be equal</li>
 * <li>If {@code unnormalizedCoordinates} is {@link VK10#VK_TRUE TRUE}, {@code mipmapMode} <b>must</b> be {@link VK10#VK_SAMPLER_MIPMAP_MODE_NEAREST SAMPLER_MIPMAP_MODE_NEAREST}</li>
 * <li>If {@code unnormalizedCoordinates} is {@link VK10#VK_TRUE TRUE}, {@code minLod} and {@code maxLod} <b>must</b> be zero</li>
 * <li>If {@code unnormalizedCoordinates} is {@link VK10#VK_TRUE TRUE}, {@code addressModeU} and {@code addressModeV} <b>must</b> each be either {@link VK10#VK_SAMPLER_ADDRESS_MODE_CLAMP_TO_EDGE SAMPLER_ADDRESS_MODE_CLAMP_TO_EDGE} or {@link VK10#VK_SAMPLER_ADDRESS_MODE_CLAMP_TO_BORDER SAMPLER_ADDRESS_MODE_CLAMP_TO_BORDER}</li>
 * <li>If {@code unnormalizedCoordinates} is {@link VK10#VK_TRUE TRUE}, {@code anisotropyEnable} <b>must</b> be {@link VK10#VK_FALSE FALSE}</li>
 * <li>If {@code unnormalizedCoordinates} is {@link VK10#VK_TRUE TRUE}, {@code compareEnable} <b>must</b> be {@link VK10#VK_FALSE FALSE}</li>
 * <li>If any of {@code addressModeU}, {@code addressModeV} or {@code addressModeW} are {@link VK10#VK_SAMPLER_ADDRESS_MODE_CLAMP_TO_BORDER SAMPLER_ADDRESS_MODE_CLAMP_TO_BORDER}, {@code borderColor} <b>must</b> be a valid {@code VkBorderColor} value</li>
 * <li>If <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#samplers-YCbCr-conversion">sampler Y&#8217;C<sub>B</sub>C<sub>R</sub> conversion</a> is enabled, {@code addressModeU}, {@code addressModeV}, and {@code addressModeW} <b>must</b> be {@link VK10#VK_SAMPLER_ADDRESS_MODE_CLAMP_TO_EDGE SAMPLER_ADDRESS_MODE_CLAMP_TO_EDGE}, {@code anisotropyEnable} <b>must</b> be {@link VK10#VK_FALSE FALSE}, and {@code unnormalizedCoordinates} <b>must</b> be {@link VK10#VK_FALSE FALSE}</li>
 * <li>The sampler reduction mode <b>must</b> be set to {@link EXTSamplerFilterMinmax#VK_SAMPLER_REDUCTION_MODE_WEIGHTED_AVERAGE_EXT SAMPLER_REDUCTION_MODE_WEIGHTED_AVERAGE_EXT} if <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#samplers-YCbCr-conversion">sampler Y&#8217;C<sub>B</sub>C<sub>R</sub> conversion</a> is enabled</li>
 * <li>If the {@link KHRSamplerMirrorClampToEdge VK_KHR_sampler_mirror_clamp_to_edge} extension is not enabled, {@code addressModeU}, {@code addressModeV} and {@code addressModeW} <b>must</b> not be {@link KHRSamplerMirrorClampToEdge#VK_SAMPLER_ADDRESS_MODE_MIRROR_CLAMP_TO_EDGE SAMPLER_ADDRESS_MODE_MIRROR_CLAMP_TO_EDGE}</li>
 * <li>If {@code compareEnable} is {@link VK10#VK_TRUE TRUE}, {@code compareOp} <b>must</b> be a valid {@code VkCompareOp} value</li>
 * <li>If either {@code magFilter} or {@code minFilter} is {@link EXTFilterCubic#VK_FILTER_CUBIC_EXT FILTER_CUBIC_EXT}, {@code anisotropyEnable} <b>must</b> be {@link VK10#VK_FALSE FALSE}</li>
 * <li>If {@code compareEnable} is {@link VK10#VK_TRUE TRUE}, the {@code reductionMode} member of {@link VkSamplerReductionModeCreateInfoEXT} <b>must</b> be {@link EXTSamplerFilterMinmax#VK_SAMPLER_REDUCTION_MODE_WEIGHTED_AVERAGE_EXT SAMPLER_REDUCTION_MODE_WEIGHTED_AVERAGE_EXT}</li>
 * <li>If {@code flags} includes {@link EXTFragmentDensityMap#VK_SAMPLER_CREATE_SUBSAMPLED_BIT_EXT SAMPLER_CREATE_SUBSAMPLED_BIT_EXT}, then {@code minFilter} and {@code magFilter} <b>must</b> be equal.</li>
 * <li>If {@code flags} includes {@link EXTFragmentDensityMap#VK_SAMPLER_CREATE_SUBSAMPLED_BIT_EXT SAMPLER_CREATE_SUBSAMPLED_BIT_EXT}, then {@code mipmapMode} <b>must</b> be {@link VK10#VK_SAMPLER_MIPMAP_MODE_NEAREST SAMPLER_MIPMAP_MODE_NEAREST}.</li>
 * <li>If {@code flags} includes {@link EXTFragmentDensityMap#VK_SAMPLER_CREATE_SUBSAMPLED_BIT_EXT SAMPLER_CREATE_SUBSAMPLED_BIT_EXT}, then {@code minLod} and {@code maxLod} <b>must</b> be zero.</li>
 * <li>If {@code flags} includes {@link EXTFragmentDensityMap#VK_SAMPLER_CREATE_SUBSAMPLED_BIT_EXT SAMPLER_CREATE_SUBSAMPLED_BIT_EXT}, then {@code addressModeU} and {@code addressModeV} <b>must</b> each be either {@link VK10#VK_SAMPLER_ADDRESS_MODE_CLAMP_TO_EDGE SAMPLER_ADDRESS_MODE_CLAMP_TO_EDGE} or {@link VK10#VK_SAMPLER_ADDRESS_MODE_CLAMP_TO_BORDER SAMPLER_ADDRESS_MODE_CLAMP_TO_BORDER}.</li>
 * <li>If {@code flags} includes {@link EXTFragmentDensityMap#VK_SAMPLER_CREATE_SUBSAMPLED_BIT_EXT SAMPLER_CREATE_SUBSAMPLED_BIT_EXT}, then {@code anisotropyEnable} <b>must</b> be {@link VK10#VK_FALSE FALSE}.</li>
 * <li>If {@code flags} includes {@link EXTFragmentDensityMap#VK_SAMPLER_CREATE_SUBSAMPLED_BIT_EXT SAMPLER_CREATE_SUBSAMPLED_BIT_EXT}, then {@code compareEnable} <b>must</b> be {@link VK10#VK_FALSE FALSE}.</li>
 * <li>If {@code flags} includes {@link EXTFragmentDensityMap#VK_SAMPLER_CREATE_SUBSAMPLED_BIT_EXT SAMPLER_CREATE_SUBSAMPLED_BIT_EXT}, then {@code unnormalizedCoordinates} <b>must</b> be {@link VK10#VK_FALSE FALSE}.</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK10#VK_STRUCTURE_TYPE_SAMPLER_CREATE_INFO STRUCTURE_TYPE_SAMPLER_CREATE_INFO}</li>
 * <li>Each {@code pNext} member of any structure (including this one) in the {@code pNext} chain <b>must</b> be either {@code NULL} or a pointer to a valid instance of {@link VkSamplerReductionModeCreateInfoEXT} or {@link VkSamplerYcbcrConversionInfo}</li>
 * <li>Each {@code sType} member in the {@code pNext} chain <b>must</b> be unique</li>
 * <li>{@code flags} <b>must</b> be a valid combination of {@code VkSamplerCreateFlagBits} values</li>
 * <li>{@code magFilter} <b>must</b> be a valid {@code VkFilter} value</li>
 * <li>{@code minFilter} <b>must</b> be a valid {@code VkFilter} value</li>
 * <li>{@code mipmapMode} <b>must</b> be a valid {@code VkSamplerMipmapMode} value</li>
 * <li>{@code addressModeU} <b>must</b> be a valid {@code VkSamplerAddressMode} value</li>
 * <li>{@code addressModeV} <b>must</b> be a valid {@code VkSamplerAddressMode} value</li>
 * <li>{@code addressModeW} <b>must</b> be a valid {@code VkSamplerAddressMode} value</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VK10#vkCreateSampler CreateSampler}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code flags} &ndash; a bitmask of {@code VkSamplerCreateFlagBits} describing additional parameters of the sampler.</li>
 * <li>{@code magFilter} &ndash; a {@code VkFilter} value specifying the magnification filter to apply to lookups.</li>
 * <li>{@code minFilter} &ndash; a {@code VkFilter} value specifying the minification filter to apply to lookups.</li>
 * <li>{@code mipmapMode} &ndash; a {@code VkSamplerMipmapMode} value specifying the mipmap filter to apply to lookups.</li>
 * <li>{@code addressModeU} &ndash; a {@code VkSamplerAddressMode} value specifying the addressing mode for outside [0..1] range for U coordinate.</li>
 * <li>{@code addressModeV} &ndash; a {@code VkSamplerAddressMode} value specifying the addressing mode for outside [0..1] range for V coordinate.</li>
 * <li>{@code addressModeW} &ndash; a {@code VkSamplerAddressMode} value specifying the addressing mode for outside [0..1] range for W coordinate.</li>
 * <li>{@code mipLodBias} &ndash; the bias to be added to mipmap LOD (level-of-detail) calculation and bias provided by image sampling functions in SPIR-V, as described in the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#textures-level-of-detail-operation">Level-of-Detail Operation</a> section.</li>
 * <li>{@code anisotropyEnable} &ndash; {@link VK10#VK_TRUE TRUE} to enable anisotropic filtering, as described in the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#textures-texel-anisotropic-filtering">Texel Anisotropic Filtering</a> section, or {@link VK10#VK_FALSE FALSE} otherwise.</li>
 * <li>{@code maxAnisotropy} &ndash; the anisotropy value clamp used by the sampler when {@code anisotropyEnable} is {@link VK10#VK_TRUE TRUE}. If {@code anisotropyEnable} is {@link VK10#VK_FALSE FALSE}, {@code maxAnisotropy} is ignored.</li>
 * <li>{@code compareEnable} &ndash; {@link VK10#VK_TRUE TRUE} to enable comparison against a reference value during lookups, or {@link VK10#VK_FALSE FALSE} otherwise.
 *
 * <ul>
 * <li>Note: Some implementations will default to shader state if this member does not match.</li>
 * </ul></li>
 * <li>{@code compareOp} &ndash; a {@code VkCompareOp} value specifying the comparison function to apply to fetched data before filtering as described in the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#textures-depth-compare-operation">Depth Compare Operation</a> section.</li>
 * <li>{@code minLod} &ndash; {@code minLod} and {@code maxLod} are the values used to clamp the computed LOD value, as described in the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#textures-level-of-detail-operation">Level-of-Detail Operation</a> section.</li>
 * <li>{@code maxLod} &ndash; see {@code minLod}</li>
 * <li>{@code borderColor} &ndash; a {@code VkBorderColor} value specifying the predefined border color to use.</li>
 * <li>{@code unnormalizedCoordinates} &ndash; controls whether to use unnormalized or normalized texel coordinates to address texels of the image. When set to {@link VK10#VK_TRUE TRUE}, the range of the image coordinates used to lookup the texel is in the range of zero to the image dimensions for x, y and z. When set to {@link VK10#VK_FALSE FALSE} the range of image coordinates is zero to one.
 *
 * <p>When {@code unnormalizedCoordinates} is {@link VK10#VK_TRUE TRUE}, images the sampler is used with in the shader have the following requirements:</p>
 *
 * <ul>
 * <li>The {@code viewType} <b>must</b> be either {@link VK10#VK_IMAGE_VIEW_TYPE_1D IMAGE_VIEW_TYPE_1D} or {@link VK10#VK_IMAGE_VIEW_TYPE_2D IMAGE_VIEW_TYPE_2D}.</li>
 * <li>The image view <b>must</b> have a single layer and a single mip level.</li>
 * </ul>
 *
 * <p>When {@code unnormalizedCoordinates} is {@link VK10#VK_TRUE TRUE}, image built-in functions in the shader that use the sampler have the following requirements:</p>
 *
 * <ul>
 * <li>The functions <b>must</b> not use projection.</li>
 * <li>The functions <b>must</b> not use offsets.</li>
 * </ul></li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkSamplerCreateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkSamplerCreateFlags flags;
 *     VkFilter magFilter;
 *     VkFilter minFilter;
 *     VkSamplerMipmapMode mipmapMode;
 *     VkSamplerAddressMode addressModeU;
 *     VkSamplerAddressMode addressModeV;
 *     VkSamplerAddressMode addressModeW;
 *     float mipLodBias;
 *     VkBool32 anisotropyEnable;
 *     float maxAnisotropy;
 *     VkBool32 compareEnable;
 *     VkCompareOp compareOp;
 *     float minLod;
 *     float maxLod;
 *     VkBorderColor borderColor;
 *     VkBool32 unnormalizedCoordinates;
 * }</code></pre>
 */
class SamplerCreateInfo(
        var flags: VkSamplerCreateFlags = 0,
        var magFilter: VkFilter,
        var minFilter: VkFilter,
        var mipmapMode: VkSamplerMipmapMode,
        var addressModeU: VkSamplerAddressMode,
        var addressModeV: VkSamplerAddressMode,
        var addressModeW: VkSamplerAddressMode,
        var mipLodBias: Float = 0f,
        var anisotropyEnable: Boolean = false,
        var maxAnisotropy: Float = 0f,
        var compareEnable: Boolean = false,
        var compareOp: VkCompareOp = VkCompareOp.NEVER,
        var minLod: Float = 0f,
        var maxLod: Float = 0f,
        var borderColor: VkBorderColor,
        var unnormalizedCoordinates: Boolean = false,
        var next: Ptr = NULL
) {

    constructor(
            flags: VkSamplerCreateFlags = 0,
            magMinFilter: VkFilter,
            mipmapMode: VkSamplerMipmapMode,
            addressModeUVW: VkSamplerAddressMode,
            mipLodBias: Float = 0f,
            anisotropyEnable: Boolean = false,
            maxAnisotropy: Float = 0f,
            compareEnable: Boolean = false,
            compareOp: VkCompareOp = VkCompareOp.NEVER,
            minLod: Float = 0f,
            maxLod: Float = 0f,
            borderColor: VkBorderColor,
            unnormalizedCoordinates: Boolean = false,
            next: Ptr = NULL
    ) : this(flags, magMinFilter, magMinFilter, mipmapMode,
            addressModeUVW, addressModeUVW, addressModeUVW,
            mipLodBias, anisotropyEnable, maxAnisotropy,
            compareEnable, compareOp, minLod, maxLod,
            borderColor, unnormalizedCoordinates, next)

    val type get() = VkStructureType.SAMPLER_CREATE_INFO

    infix fun write(stack: MemoryStack): Adr {
        val adr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
        nsType(adr, type.i)
        npNext(adr, next)
        nflags(adr, flags)
        nmagFilter(adr, magFilter.i)
        nminFilter(adr, minFilter.i)
        nmipmapMode(adr, mipmapMode.i)
        naddressModeU(adr, addressModeU.i)
        naddressModeV(adr, addressModeV.i)
        naddressModeW(adr, addressModeW.i)
        nmipLodBias(adr, mipLodBias)
        nanisotropyEnable(adr, anisotropyEnable.i)
        nmaxAnisotropy(adr, maxAnisotropy)
        ncompareEnable(adr, compareEnable.i)
        ncompareOp(adr, compareOp.i)
        nminLod(adr, minLod)
        nmaxLod(adr, maxLod)
        nborderColor(adr, borderColor.i)
        nunnormalizedCoordinates(adr, unnormalizedCoordinates.i)
        return adr
    }
}