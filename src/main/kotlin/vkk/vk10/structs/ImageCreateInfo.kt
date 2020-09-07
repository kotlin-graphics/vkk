package vkk.vk10.structs

import kool.Adr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.system.MemoryUtil.memPutAddress
import org.lwjgl.vulkan.VkImageCreateInfo.*
import vkk.*

/**
 * Structure specifying the parameters of a newly created image object.
 *
 * <h5>Description</h5>
 *
 * <p>Images created with {@code tiling} equal to {@link VK10#VK_IMAGE_TILING_LINEAR IMAGE_TILING_LINEAR} have further restrictions on their limits and capabilities compared to images created with {@code tiling} equal to {@link VK10#VK_IMAGE_TILING_OPTIMAL IMAGE_TILING_OPTIMAL}. Creation of images with tiling {@link VK10#VK_IMAGE_TILING_LINEAR IMAGE_TILING_LINEAR} <b>may</b> not be supported unless other parameters meet all of the constraints:</p>
 *
 * <ul>
 * <li>{@code imageType} is {@link VK10#VK_IMAGE_TYPE_2D IMAGE_TYPE_2D}</li>
 * <li>{@code format} is not a depth/stencil format</li>
 * <li>{@code mipLevels} is 1</li>
 * <li>{@code arrayLayers} is 1</li>
 * <li>{@code samples} is {@link VK10#VK_SAMPLE_COUNT_1_BIT SAMPLE_COUNT_1_BIT}</li>
 * <li>{@code usage} only includes {@link VK10#VK_IMAGE_USAGE_TRANSFER_SRC_BIT IMAGE_USAGE_TRANSFER_SRC_BIT} and/or {@link VK10#VK_IMAGE_USAGE_TRANSFER_DST_BIT IMAGE_USAGE_TRANSFER_DST_BIT}</li>
 * </ul>
 *
 * <p>Images created with a {@code format} from one of those listed in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#formats-requiring-sampler-ycbcr-conversion">Formats requiring sampler Y'C<sub>B</sub>C<sub>R</sub> conversion for {@link VK10#VK_IMAGE_ASPECT_COLOR_BIT IMAGE_ASPECT_COLOR_BIT} image views</a> have further restrictions on their limits and capabilities compared to images created with other formats. Creation of images with a format requiring <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#formats-requiring-sampler-ycbcr-conversion">Y'C<sub>B</sub>C<sub>R</sub> conversion</a> <b>may</b> not be supported unless other parameters meet all of the constraints:</p>
 *
 * <ul>
 * <li>{@code imageType} is {@link VK10#VK_IMAGE_TYPE_2D IMAGE_TYPE_2D}</li>
 * <li>{@code mipLevels} is 1</li>
 * <li>{@code arrayLayers} is 1</li>
 * <li>{@code samples} is {@link VK10#VK_SAMPLE_COUNT_1_BIT SAMPLE_COUNT_1_BIT}</li>
 * </ul>
 *
 * <p>Implementations <b>may</b> support additional limits and capabilities beyond those listed above.</p>
 *
 * <p>To determine the set of valid {@code usage} bits for a given format, call {@link VK10#vkGetPhysicalDeviceFormatProperties GetPhysicalDeviceFormatProperties}.</p>
 *
 * <p>If the size of the resultant image would exceed {@code maxResourceSize}, then {@code vkCreateImage} <b>must</b> fail and return {@link VK10#VK_ERROR_OUT_OF_DEVICE_MEMORY ERROR_OUT_OF_DEVICE_MEMORY}. This failure <b>may</b> occur even when all image creation parameters satisfy their valid usage requirements.</p>
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>For images created without {@link VK11#VK_IMAGE_CREATE_EXTENDED_USAGE_BIT IMAGE_CREATE_EXTENDED_USAGE_BIT} a {@code usage} bit is valid if it is supported for the format the image is created with.</p>
 *
 * <p>For images created with {@link VK11#VK_IMAGE_CREATE_EXTENDED_USAGE_BIT IMAGE_CREATE_EXTENDED_USAGE_BIT} a {@code usage} bit is valid if it is supported for at least one of the formats a {@code VkImageView} created from the image <b>can</b> have (see <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#resources-image-views">Image Views</a> for more detail).</p>
 * </div>
 *
 * <h5>Image Creation Limits</h5>
 *
 * <p>Valid values for some image creation parameters are limited by a numerical upper bound or by inclusion in a bitset. For example, {@link VkImageCreateInfo}{@code ::arrayLayers} is limited by {@code imageCreateMaxArrayLayers}, defined below; and {@link VkImageCreateInfo}{@code ::samples} is limited by {@code imageCreateSampleCounts}, also defined below.</p>
 *
 * <p>Several limiting values are defined below, as well as assisting values from which the limiting values are derived. The limiting values are referenced by the relevant valid usage statements of {@link VkImageCreateInfo}.</p>
 *
 * <ul>
 * <li>Let {@code uint64_t imageCreateDrmFormatModifiers[]} be the set of <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#glossary-drm-format-modifier">Linux DRM format modifiers</a> that the resultant image <b>may</b> have.
 *
 * <ul>
 * <li>If {@code tiling} is not {@link EXTImageDrmFormatModifier#VK_IMAGE_TILING_DRM_FORMAT_MODIFIER_EXT IMAGE_TILING_DRM_FORMAT_MODIFIER_EXT}, then {@code imageCreateDrmFormatModifiers} is empty.</li>
 * <li>If {@link VkImageCreateInfo}{@code ::pNext} contains {@link VkImageDrmFormatModifierExplicitCreateInfoEXT}, then {@code imageCreateDrmFormatModifiers} contains exactly one modifier, {@link VkImageDrmFormatModifierExplicitCreateInfoEXT}{@code ::drmFormatModifier}.</li>
 * <li>If {@link VkImageCreateInfo}{@code ::pNext} contains {@link VkImageDrmFormatModifierListCreateInfoEXT}, then {@code imageCreateDrmFormatModifiers} contains the exactly the modifiers in {@link VkImageDrmFormatModifierListCreateInfoEXT}{@code ::pDrmFormatModifiers}.</li>
 * </ul>
 * </li>
 * <li>Let {@code VkBool32 imageCreateMaybeLinear} indicate if the resultant image may be <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#glossary-linear-image">linear</a>.
 *
 * <ul>
 * <li>If {@code tiling} is {@link VK10#VK_IMAGE_TILING_LINEAR IMAGE_TILING_LINEAR}, then {@code imageCreateMaybeLinear} is {@code true}.</li>
 * <li>If {@code tiling} is {@link VK10#VK_IMAGE_TILING_OPTIMAL IMAGE_TILING_OPTIMAL}, then {@code imageCreateMaybeLinear} is {@code false}.</li>
 * <li>If {@code tiling} is {@link EXTImageDrmFormatModifier#VK_IMAGE_TILING_DRM_FORMAT_MODIFIER_EXT IMAGE_TILING_DRM_FORMAT_MODIFIER_EXT}, then {@code imageCreateMaybeLinear_} is {@code true} if and only if {@code imageCreateDrmFormatModifiers} contains {@code DRM_FORMAT_MOD_LINEAR}.</li>
 * </ul>
 * </li>
 * <li>Let {@code VkFormatFeatureFlags imageCreateFormatFeatures} be the set of format features available during image creation.
 *
 * <ul>
 * <li>If {@code tiling} is {@link VK10#VK_IMAGE_TILING_LINEAR IMAGE_TILING_LINEAR}, then {@code imageCreateFormatFeatures} is the value of {@link VkImageFormatProperties}{@code ::linearTilingFeatures} found by calling {@link VK10#vkGetPhysicalDeviceFormatProperties GetPhysicalDeviceFormatProperties} with parameter {@code format} equal to {@link VkImageCreateInfo}{@code ::format}.</li>
 * <li>If {@code tiling} is {@link VK10#VK_IMAGE_TILING_OPTIMAL IMAGE_TILING_OPTIMAL}, then {@code imageCreateFormatFeatures} is value of {@link VkImageFormatProperties}{@code ::optimalTilingFeatures} found by calling {@link VK10#vkGetPhysicalDeviceFormatProperties GetPhysicalDeviceFormatProperties} with parameter {@code format} equal to {@link VkImageCreateInfo}{@code ::format}.</li>
 * <li>If {@code tiling} is {@link EXTImageDrmFormatModifier#VK_IMAGE_TILING_DRM_FORMAT_MODIFIER_EXT IMAGE_TILING_DRM_FORMAT_MODIFIER_EXT}, then the value of {@code imageCreateFormatFeatures} is found by calling {@link VK11#vkGetPhysicalDeviceFormatProperties2 GetPhysicalDeviceFormatProperties2} with {@link VkImageFormatProperties}{@code ::format} equal to {@link VkImageCreateInfo}{@code ::format} and with {@link VkDrmFormatModifierPropertiesListEXT} chained into {@link VkImageFormatProperties2}; by collecting all members of the returned array {@link VkDrmFormatModifierPropertiesListEXT}::pDrmFormatModifierProperties whose {@code drmFormatModifier} belongs to {@code imageCreateDrmFormatModifiers}; and by taking the bitwise intersection, over the collected array members, of {@code drmFormatModifierTilingFeatures}. (The resultant {@code imageCreateFormatFeatures} <b>may</b> be empty).</li>
 * </ul>
 * </li>
 * <li>Let {@code VkImageFormatProperties2 imageCreateImageFormatPropertiesList[]} be the list of structures obtained by calling {@link VK11#vkGetPhysicalDeviceImageFormatProperties2 GetPhysicalDeviceImageFormatProperties2}, possibly multiple times, as follows:
 *
 * <ul>
 * <li>The parameters {@link VkPhysicalDeviceImageFormatInfo2}{@code ::format}, {@code imageType}, {@code tiling}, {@code usage}, and {@code flags} <b>must</b> be equal to those in {@link VkImageCreateInfo}.</li>
 * <li>If {@link VkImageCreateInfo}{@code ::pNext} contains an instance of {@link VkExternalMemoryImageCreateInfo} where {@code handleTypes} is not 0, then {@link VkPhysicalDeviceImageFormatInfo2}{@code ::pNext} <b>must</b> contain an instance of {@link VkPhysicalDeviceExternalImageFormatInfo} where {@code handleType} is not 0; and {@link VK11#vkGetPhysicalDeviceImageFormatProperties2 GetPhysicalDeviceImageFormatProperties2} <b>must</b> be called for each handle type in {@link VkExternalMemoryImageCreateInfo}{@code ::handleTypes}, successively setting {@link VkPhysicalDeviceExternalImageFormatInfo}{@code ::handleType} on each call.</li>
 * <li>If {@link VkImageCreateInfo}{@code ::pNext} contains no instance of {@link VkExternalMemoryImageCreateInfo} or contains an instance where {@code handleTypes} is 0, then {@link VkPhysicalDeviceImageFormatInfo2}{@code ::pNext} <b>must</b> either contain no instance of {@link VkPhysicalDeviceExternalImageFormatInfo} or contain an instance where {@code handleType} is 0.</li>
 * <li>If {@code tiling} is {@link EXTImageDrmFormatModifier#VK_IMAGE_TILING_DRM_FORMAT_MODIFIER_EXT IMAGE_TILING_DRM_FORMAT_MODIFIER_EXT}, then {@link VkPhysicalDeviceImageFormatInfo2}{@code ::pNext} <b>must</b> contain an instance of {@link VkPhysicalDeviceImageDrmFormatModifierInfoEXT} where {@code sharingMode} is equal to {@link VkImageCreateInfo}{@code ::sharingMode}; and, if {@code sharingMode} is {@link VK10#VK_SHARING_MODE_CONCURRENT SHARING_MODE_CONCURRENT}, then {@code queueFamilyIndexCount} and {@code pQueueFamilyIndices} <b>must</b> be equal to those in {@link VkImageCreateInfo}; and, if {@code flags} contains {@link VK10#VK_IMAGE_CREATE_MUTABLE_FORMAT_BIT IMAGE_CREATE_MUTABLE_FORMAT_BIT}, then the instance of {@link VkImageFormatListCreateInfoKHR} in the {@code pNext} chain of {@link VkPhysicalDeviceImageFormatInfo2} <b>must</b> be equivalent to the one in the {@code pNext} chain of {@link VkImageCreateInfo}; and {@link VK11#vkGetPhysicalDeviceImageFormatProperties2 GetPhysicalDeviceImageFormatProperties2} <b>must</b> be called for each modifier in {@code imageCreateDrmFormatModifiers}, successively setting {@link VkPhysicalDeviceImageDrmFormatModifierInfoEXT}{@code ::drmFormatModifier} on each call.</li>
 * <li>If {@code tiling} is not {@link EXTImageDrmFormatModifier#VK_IMAGE_TILING_DRM_FORMAT_MODIFIER_EXT IMAGE_TILING_DRM_FORMAT_MODIFIER_EXT}, then {@link VkPhysicalDeviceImageFormatInfo2}{@code ::pNext} <b>must</b> contain no instance of {@link VkPhysicalDeviceImageDrmFormatModifierInfoEXT}.</li>
 * <li>If any call to {@link VK11#vkGetPhysicalDeviceImageFormatProperties2 GetPhysicalDeviceImageFormatProperties2} returns an error, then {@code imageCreateImageFormatPropertiesList} is defined to be the empty list.</li>
 * </ul>
 * </li>
 * <li>Let {@code uint32_t imageCreateMaxMipLevels} be the minimum value of {@link VkImageFormatProperties}{@code ::maxMipLevels} in {@code imageCreateImageFormatPropertiesList}. The value is undefined if {@code imageCreateImageFormatPropertiesList} is empty.</li>
 * <li>Let {@code uint32_t imageCreateMaxArrayLayers} be the minimum value of {@link VkImageFormatProperties}{@code ::maxArrayLayers} in {@code imageCreateImageFormatPropertiesList}. The value is undefined if {@code imageCreateImageFormatPropertiesList} is empty.</li>
 * <li>Let {@code VkExtent3D imageCreateMaxExtent} be the component-wise minimum over all {@link VkImageFormatProperties}{@code ::maxExtent} values in {@code imageCreateImageFormatPropertiesList}. The value is undefined if {@code imageCreateImageFormatPropertiesList} is empty.</li>
 * <li>Let {@code VkSampleCountFlags imageCreateSampleCounts} be the intersection of each {@link VkImageFormatProperties}{@code ::sampleCounts} in {@code imageCreateImageFormatPropertiesList}. The value is undefined if {@code imageCreateImageFormatPropertiesList} is empty.</li>
 * </ul>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>Each of the following values (as described in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#resources-image-creation-limits">Image Creation Limits</a>) <b>must</b> not be undefined {@code imageCreateMaxMipLevels}, {@code imageCreateMaxArrayLayers}, {@code imageCreateMaxExtent}, and {@code imageCreateSampleCounts}.</li>
 * <li>If {@code sharingMode} is {@link VK10#VK_SHARING_MODE_CONCURRENT SHARING_MODE_CONCURRENT}, {@code pQueueFamilyIndices} <b>must</b> be a valid pointer to an array of {@code queueFamilyIndexCount} {@code uint32_t} values</li>
 * <li>If {@code sharingMode} is {@link VK10#VK_SHARING_MODE_CONCURRENT SHARING_MODE_CONCURRENT}, {@code queueFamilyIndexCount} <b>must</b> be greater than 1</li>
 * <li>If {@code sharingMode} is {@link VK10#VK_SHARING_MODE_CONCURRENT SHARING_MODE_CONCURRENT}, each element of {@code pQueueFamilyIndices} <b>must</b> be unique and <b>must</b> be less than {@code pQueueFamilyPropertyCount} returned by either {@link VK10#vkGetPhysicalDeviceQueueFamilyProperties GetPhysicalDeviceQueueFamilyProperties} or {@link VK11#vkGetPhysicalDeviceQueueFamilyProperties2 GetPhysicalDeviceQueueFamilyProperties2} for the {@code physicalDevice} that was used to create {@code device}</li>
 * <li>{@code format} <b>must</b> not be {@link VK10#VK_FORMAT_UNDEFINED FORMAT_UNDEFINED}</li>
 * <li>{@code extent}{@code ::width} <b>must</b> be greater than 0.</li>
 * <li>{@code extent}{@code ::height} <b>must</b> be greater than 0.</li>
 * <li>{@code extent}{@code ::depth} <b>must</b> be greater than 0.</li>
 * <li>{@code mipLevels} <b>must</b> be greater than 0</li>
 * <li>{@code arrayLayers} <b>must</b> be greater than 0</li>
 * <li>If {@code flags} contains {@link VK10#VK_IMAGE_CREATE_CUBE_COMPATIBLE_BIT IMAGE_CREATE_CUBE_COMPATIBLE_BIT}, {@code imageType} <b>must</b> be {@link VK10#VK_IMAGE_TYPE_2D IMAGE_TYPE_2D}</li>
 * <li>If {@code flags} contains {@link EXTFragmentDensityMap#VK_IMAGE_USAGE_FRAGMENT_DENSITY_MAP_BIT_EXT IMAGE_USAGE_FRAGMENT_DENSITY_MAP_BIT_EXT}, {@code imageType} <b>must</b> be {@link VK10#VK_IMAGE_TYPE_2D IMAGE_TYPE_2D}</li>
 * <li>If {@code flags} contains {@link VK11#VK_IMAGE_CREATE_2D_ARRAY_COMPATIBLE_BIT IMAGE_CREATE_2D_ARRAY_COMPATIBLE_BIT}, {@code imageType} <b>must</b> be {@link VK10#VK_IMAGE_TYPE_3D IMAGE_TYPE_3D}</li>
 * <li>{@code extent.width} <b>must</b> be less than or equal to {@code imageCreateMaxExtent.width} (as defined in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#resources-image-creation-limits">Image Creation Limits</a>).</li>
 * <li>{@code extent.height} <b>must</b> be less than or equal to {@code imageCreateMaxExtent.height} (as defined in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#resources-image-creation-limits">Image Creation Limits</a>).</li>
 * <li>{@code extent.depth} <b>must</b> be less than or equal to {@code imageCreateMaxExtent.depth} (as defined in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#resources-image-creation-limits">Image Creation Limits</a>).</li>
 * <li>If {@code imageType} is {@link VK10#VK_IMAGE_TYPE_2D IMAGE_TYPE_2D} and {@code flags} contains {@link VK10#VK_IMAGE_CREATE_CUBE_COMPATIBLE_BIT IMAGE_CREATE_CUBE_COMPATIBLE_BIT}, {@code extent.width} and {@code extent.height} <b>must</b> be equal and {@code arrayLayers} <b>must</b> be greater than or equal to 6</li>
 * <li>If {@code imageType} is {@link VK10#VK_IMAGE_TYPE_1D IMAGE_TYPE_1D}, both {@code extent.height} and {@code extent.depth} <b>must</b> be 1</li>
 * <li>If {@code imageType} is {@link VK10#VK_IMAGE_TYPE_2D IMAGE_TYPE_2D}, {@code extent.depth} <b>must</b> be 1</li>
 * <li>{@code mipLevels} <b>must</b> be less than or equal to the number of levels in the complete mipmap chain based on <code>extent.width</code>, <code>extent.height</code>, and <code>extent.depth</code>.</li>
 * <li>{@code mipLevels} <b>must</b> be less than or equal to {@code imageCreateMaxMipLevels} (as defined in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#resources-image-creation-limits">Image Creation Limits</a>).</li>
 * <li>{@code arrayLayers} <b>must</b> be less than or equal to {@code imageCreateMaxArrayLayers} (as defined in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#resources-image-creation-limits">Image Creation Limits</a>).</li>
 * <li>If {@code imageType} is {@link VK10#VK_IMAGE_TYPE_3D IMAGE_TYPE_3D}, {@code arrayLayers} <b>must</b> be 1.</li>
 * <li>If {@code samples} is not {@link VK10#VK_SAMPLE_COUNT_1_BIT SAMPLE_COUNT_1_BIT}, then {@code imageType} <b>must</b> be {@link VK10#VK_IMAGE_TYPE_2D IMAGE_TYPE_2D}, {@code flags} <b>must</b> not contain {@link VK10#VK_IMAGE_CREATE_CUBE_COMPATIBLE_BIT IMAGE_CREATE_CUBE_COMPATIBLE_BIT}, {@code mipLevels} <b>must</b> be equal to 1, and {@code imageCreateMaybeLinear} (as defined in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#resources-image-creation-limits">Image Creation Limits</a>) <b>must</b> be {@code false},</li>
 * <li>If {@code samples} is not {@link VK10#VK_SAMPLE_COUNT_1_BIT SAMPLE_COUNT_1_BIT}, {@code usage} <b>must</b> not contain {@link EXTFragmentDensityMap#VK_IMAGE_USAGE_FRAGMENT_DENSITY_MAP_BIT_EXT IMAGE_USAGE_FRAGMENT_DENSITY_MAP_BIT_EXT}</li>
 * <li>If {@code usage} includes {@link VK10#VK_IMAGE_USAGE_TRANSIENT_ATTACHMENT_BIT IMAGE_USAGE_TRANSIENT_ATTACHMENT_BIT}, then bits other than {@link VK10#VK_IMAGE_USAGE_COLOR_ATTACHMENT_BIT IMAGE_USAGE_COLOR_ATTACHMENT_BIT}, {@link VK10#VK_IMAGE_USAGE_DEPTH_STENCIL_ATTACHMENT_BIT IMAGE_USAGE_DEPTH_STENCIL_ATTACHMENT_BIT}, and {@link VK10#VK_IMAGE_USAGE_INPUT_ATTACHMENT_BIT IMAGE_USAGE_INPUT_ATTACHMENT_BIT} <b>must</b> not be set</li>
 * <li>If {@code usage} includes {@link VK10#VK_IMAGE_USAGE_COLOR_ATTACHMENT_BIT IMAGE_USAGE_COLOR_ATTACHMENT_BIT}, {@link VK10#VK_IMAGE_USAGE_DEPTH_STENCIL_ATTACHMENT_BIT IMAGE_USAGE_DEPTH_STENCIL_ATTACHMENT_BIT}, {@link VK10#VK_IMAGE_USAGE_TRANSIENT_ATTACHMENT_BIT IMAGE_USAGE_TRANSIENT_ATTACHMENT_BIT}, or {@link VK10#VK_IMAGE_USAGE_INPUT_ATTACHMENT_BIT IMAGE_USAGE_INPUT_ATTACHMENT_BIT}, {@code extent.width} <b>must</b> be less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxFramebufferWidth}</li>
 * <li>If {@code usage} includes {@link VK10#VK_IMAGE_USAGE_COLOR_ATTACHMENT_BIT IMAGE_USAGE_COLOR_ATTACHMENT_BIT}, {@link VK10#VK_IMAGE_USAGE_DEPTH_STENCIL_ATTACHMENT_BIT IMAGE_USAGE_DEPTH_STENCIL_ATTACHMENT_BIT}, {@link VK10#VK_IMAGE_USAGE_TRANSIENT_ATTACHMENT_BIT IMAGE_USAGE_TRANSIENT_ATTACHMENT_BIT}, or {@link VK10#VK_IMAGE_USAGE_INPUT_ATTACHMENT_BIT IMAGE_USAGE_INPUT_ATTACHMENT_BIT}, {@code extent.height} <b>must</b> be less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxFramebufferHeight}</li>
 * <li>If {@code usage} includes {@link EXTFragmentDensityMap#VK_IMAGE_USAGE_FRAGMENT_DENSITY_MAP_BIT_EXT IMAGE_USAGE_FRAGMENT_DENSITY_MAP_BIT_EXT}, {@code extent.width} <b>must</b> be less than or equal to {@code ceil(maxFramebufferWidth / minFragmentDensityTexelSize.width)}</li>
 * <li>If {@code usage} includes {@link EXTFragmentDensityMap#VK_IMAGE_USAGE_FRAGMENT_DENSITY_MAP_BIT_EXT IMAGE_USAGE_FRAGMENT_DENSITY_MAP_BIT_EXT}, {@code extent.height} <b>must</b> be less than or equal to {@code ceil(maxFramebufferHeight / minFragmentDensityTexelSize.height)}</li>
 * <li>If {@code usage} includes {@link VK10#VK_IMAGE_USAGE_TRANSIENT_ATTACHMENT_BIT IMAGE_USAGE_TRANSIENT_ATTACHMENT_BIT}, {@code usage} <b>must</b> also contain at least one of {@link VK10#VK_IMAGE_USAGE_COLOR_ATTACHMENT_BIT IMAGE_USAGE_COLOR_ATTACHMENT_BIT}, {@link VK10#VK_IMAGE_USAGE_DEPTH_STENCIL_ATTACHMENT_BIT IMAGE_USAGE_DEPTH_STENCIL_ATTACHMENT_BIT}, or {@link VK10#VK_IMAGE_USAGE_INPUT_ATTACHMENT_BIT IMAGE_USAGE_INPUT_ATTACHMENT_BIT}.</li>
 * <li>{@code samples} <b>must</b> be a bit value that is set in {@code imageCreateSampleCounts} (as defined in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#resources-image-creation-limits">Image Creation Limits</a>).</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-shaderStorageImageMultisample">multisampled storage images</a> feature is not enabled, and {@code usage} contains {@link VK10#VK_IMAGE_USAGE_STORAGE_BIT IMAGE_USAGE_STORAGE_BIT}, {@code samples} <b>must</b> be {@link VK10#VK_SAMPLE_COUNT_1_BIT SAMPLE_COUNT_1_BIT}</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-sparseBinding">sparse bindings</a> feature is not enabled, {@code flags} <b>must</b> not contain {@link VK10#VK_IMAGE_CREATE_SPARSE_BINDING_BIT IMAGE_CREATE_SPARSE_BINDING_BIT}</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-sparseResidencyAliased">sparse aliased residency</a> feature is not enabled, {@code flags} <b>must</b> not contain {@link VK10#VK_IMAGE_CREATE_SPARSE_ALIASED_BIT IMAGE_CREATE_SPARSE_ALIASED_BIT}</li>
 * <li>If {@code imageType} is {@link VK10#VK_IMAGE_TYPE_1D IMAGE_TYPE_1D}, {@code flags} <b>must</b> not contain {@link VK10#VK_IMAGE_CREATE_SPARSE_RESIDENCY_BIT IMAGE_CREATE_SPARSE_RESIDENCY_BIT}</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-sparseResidencyImage2D">sparse residency for 2D images</a> feature is not enabled, and {@code imageType} is {@link VK10#VK_IMAGE_TYPE_2D IMAGE_TYPE_2D}, {@code flags} <b>must</b> not contain {@link VK10#VK_IMAGE_CREATE_SPARSE_RESIDENCY_BIT IMAGE_CREATE_SPARSE_RESIDENCY_BIT}</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-sparseResidencyImage3D">sparse residency for 3D images</a> feature is not enabled, and {@code imageType} is {@link VK10#VK_IMAGE_TYPE_3D IMAGE_TYPE_3D}, {@code flags} <b>must</b> not contain {@link VK10#VK_IMAGE_CREATE_SPARSE_RESIDENCY_BIT IMAGE_CREATE_SPARSE_RESIDENCY_BIT}</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-sparseResidency2Samples">sparse residency for images with 2 samples</a> feature is not enabled, {@code imageType} is {@link VK10#VK_IMAGE_TYPE_2D IMAGE_TYPE_2D}, and {@code samples} is {@link VK10#VK_SAMPLE_COUNT_2_BIT SAMPLE_COUNT_2_BIT}, {@code flags} <b>must</b> not contain {@link VK10#VK_IMAGE_CREATE_SPARSE_RESIDENCY_BIT IMAGE_CREATE_SPARSE_RESIDENCY_BIT}</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-sparseResidency4Samples">sparse residency for images with 4 samples</a> feature is not enabled, {@code imageType} is {@link VK10#VK_IMAGE_TYPE_2D IMAGE_TYPE_2D}, and {@code samples} is {@link VK10#VK_SAMPLE_COUNT_4_BIT SAMPLE_COUNT_4_BIT}, {@code flags} <b>must</b> not contain {@link VK10#VK_IMAGE_CREATE_SPARSE_RESIDENCY_BIT IMAGE_CREATE_SPARSE_RESIDENCY_BIT}</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-sparseResidency8Samples">sparse residency for images with 8 samples</a> feature is not enabled, {@code imageType} is {@link VK10#VK_IMAGE_TYPE_2D IMAGE_TYPE_2D}, and {@code samples} is {@link VK10#VK_SAMPLE_COUNT_8_BIT SAMPLE_COUNT_8_BIT}, {@code flags} <b>must</b> not contain {@link VK10#VK_IMAGE_CREATE_SPARSE_RESIDENCY_BIT IMAGE_CREATE_SPARSE_RESIDENCY_BIT}</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-sparseResidency16Samples">sparse residency for images with 16 samples</a> feature is not enabled, {@code imageType} is {@link VK10#VK_IMAGE_TYPE_2D IMAGE_TYPE_2D}, and {@code samples} is {@link VK10#VK_SAMPLE_COUNT_16_BIT SAMPLE_COUNT_16_BIT}, {@code flags} <b>must</b> not contain {@link VK10#VK_IMAGE_CREATE_SPARSE_RESIDENCY_BIT IMAGE_CREATE_SPARSE_RESIDENCY_BIT}</li>
 * <li>If {@code flags} contains {@link VK10#VK_IMAGE_CREATE_SPARSE_RESIDENCY_BIT IMAGE_CREATE_SPARSE_RESIDENCY_BIT} or {@link VK10#VK_IMAGE_CREATE_SPARSE_ALIASED_BIT IMAGE_CREATE_SPARSE_ALIASED_BIT}, it <b>must</b> also contain {@link VK10#VK_IMAGE_CREATE_SPARSE_BINDING_BIT IMAGE_CREATE_SPARSE_BINDING_BIT}</li>
 * <li>If any of the bits {@link VK10#VK_IMAGE_CREATE_SPARSE_BINDING_BIT IMAGE_CREATE_SPARSE_BINDING_BIT}, {@link VK10#VK_IMAGE_CREATE_SPARSE_RESIDENCY_BIT IMAGE_CREATE_SPARSE_RESIDENCY_BIT}, or {@link VK10#VK_IMAGE_CREATE_SPARSE_ALIASED_BIT IMAGE_CREATE_SPARSE_ALIASED_BIT} are set, {@link VK10#VK_IMAGE_USAGE_TRANSIENT_ATTACHMENT_BIT IMAGE_USAGE_TRANSIENT_ATTACHMENT_BIT} <b>must</b> not also be set</li>
 * <li>If the protected memory feature is not enabled, {@code flags} <b>must</b> not contain {@link VK11#VK_IMAGE_CREATE_PROTECTED_BIT IMAGE_CREATE_PROTECTED_BIT}.</li>
 * <li>If any of the bits {@link VK10#VK_IMAGE_CREATE_SPARSE_BINDING_BIT IMAGE_CREATE_SPARSE_BINDING_BIT}, {@link VK10#VK_IMAGE_CREATE_SPARSE_RESIDENCY_BIT IMAGE_CREATE_SPARSE_RESIDENCY_BIT}, or {@link VK10#VK_IMAGE_CREATE_SPARSE_ALIASED_BIT IMAGE_CREATE_SPARSE_ALIASED_BIT} are set, {@link VK11#VK_IMAGE_CREATE_PROTECTED_BIT IMAGE_CREATE_PROTECTED_BIT} <b>must</b> not also be set.</li>
 * <li>If the {@code pNext} chain contains an instance of {@link VkExternalMemoryImageCreateInfoNV}, it <b>must</b> not contain an instance of {@link VkExternalMemoryImageCreateInfo}.</li>
 * <li>If the {@code pNext} chain contains an instance of {@link VkExternalMemoryImageCreateInfo}, its {@code handleTypes} member <b>must</b> only contain bits that are also in {@link VkExternalImageFormatProperties}{@code ::externalMemoryProperties}.compatibleHandleTypes, as returned by {@link VK11#vkGetPhysicalDeviceImageFormatProperties2 GetPhysicalDeviceImageFormatProperties2} with {@code format}, {@code imageType}, {@code tiling}, {@code usage}, and {@code flags} equal to those in this structure, and with an instance of {@link VkPhysicalDeviceExternalImageFormatInfo} in the {@code pNext} chain, with a {@code handleType} equal to any one of the handle types specified in {@link VkExternalMemoryImageCreateInfo}{@code ::handleTypes}</li>
 * <li>If the {@code pNext} chain contains an instance of {@link VkExternalMemoryImageCreateInfoNV}, its {@code handleTypes} member <b>must</b> only contain bits that are also in {@link VkExternalImageFormatPropertiesNV}{@code ::externalMemoryProperties}.compatibleHandleTypes, as returned by {@link NVExternalMemoryCapabilities#vkGetPhysicalDeviceExternalImageFormatPropertiesNV GetPhysicalDeviceExternalImageFormatPropertiesNV} with {@code format}, {@code imageType}, {@code tiling}, {@code usage}, and {@code flags} equal to those in this structure, and with {@code externalHandleType} equal to any one of the handle types specified in {@link VkExternalMemoryImageCreateInfoNV}{@code ::handleTypes}</li>
 * <li>If the logical device was created with {@link VkDeviceGroupDeviceCreateInfo}{@code ::physicalDeviceCount} equal to 1, {@code flags} <b>must</b> not contain {@link VK11#VK_IMAGE_CREATE_SPLIT_INSTANCE_BIND_REGIONS_BIT IMAGE_CREATE_SPLIT_INSTANCE_BIND_REGIONS_BIT}</li>
 * <li>If {@code flags} contains {@link VK11#VK_IMAGE_CREATE_SPLIT_INSTANCE_BIND_REGIONS_BIT IMAGE_CREATE_SPLIT_INSTANCE_BIND_REGIONS_BIT}, then {@code mipLevels} <b>must</b> be one, {@code arrayLayers} <b>must</b> be one, {@code imageType} <b>must</b> be {@link VK10#VK_IMAGE_TYPE_2D IMAGE_TYPE_2D}. and {@code imageCreateMaybeLinear} (as defined in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#resources-image-creation-limits">Image Creation Limits</a>) <b>must</b> be {@code false}.</li>
 * <li>If {@code flags} contains {@link VK11#VK_IMAGE_CREATE_BLOCK_TEXEL_VIEW_COMPATIBLE_BIT IMAGE_CREATE_BLOCK_TEXEL_VIEW_COMPATIBLE_BIT}, then {@code format} <b>must</b> be a <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#appendix-compressedtex-bc">block-compressed image format</a>, an <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#appendix-compressedtex-etc2">ETC compressed image format</a>, or an <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#appendix-compressedtex-astc">ASTC compressed image format</a>.</li>
 * <li>If {@code flags} contains {@link VK11#VK_IMAGE_CREATE_BLOCK_TEXEL_VIEW_COMPATIBLE_BIT IMAGE_CREATE_BLOCK_TEXEL_VIEW_COMPATIBLE_BIT}, then {@code flags} <b>must</b> also contain {@link VK10#VK_IMAGE_CREATE_MUTABLE_FORMAT_BIT IMAGE_CREATE_MUTABLE_FORMAT_BIT}.</li>
 * <li>{@code initialLayout} <b>must</b> be {@link VK10#VK_IMAGE_LAYOUT_UNDEFINED IMAGE_LAYOUT_UNDEFINED} or {@link VK10#VK_IMAGE_LAYOUT_PREINITIALIZED IMAGE_LAYOUT_PREINITIALIZED}.</li>
 * <li>If the {@code pNext} chain includes a {@link VkExternalMemoryImageCreateInfo} or {@link VkExternalMemoryImageCreateInfoNV} structure whose {@code handleTypes} member is not 0, {@code initialLayout} <b>must</b> be {@link VK10#VK_IMAGE_LAYOUT_UNDEFINED IMAGE_LAYOUT_UNDEFINED}</li>
 * <li>If the image {@code format} is one of those listed in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#formats-requiring-sampler-ycbcr-conversion">Formats requiring sampler Y'C<sub>B</sub>C<sub>R</sub> conversion for {@link VK10#VK_IMAGE_ASPECT_COLOR_BIT IMAGE_ASPECT_COLOR_BIT} image views</a>, then {@code mipLevels} <b>must</b> be 1</li>
 * <li>If the image {@code format} is one of those listed in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#formats-requiring-sampler-ycbcr-conversion">Formats requiring sampler Y'C<sub>B</sub>C<sub>R</sub> conversion for {@link VK10#VK_IMAGE_ASPECT_COLOR_BIT IMAGE_ASPECT_COLOR_BIT} image views</a>, {@code samples} must be {@link VK10#VK_SAMPLE_COUNT_1_BIT SAMPLE_COUNT_1_BIT}</li>
 * <li>If the image {@code format} is one of those listed in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#formats-requiring-sampler-ycbcr-conversion">Formats requiring sampler Y'C<sub>B</sub>C<sub>R</sub> conversion for {@link VK10#VK_IMAGE_ASPECT_COLOR_BIT IMAGE_ASPECT_COLOR_BIT} image views</a>, {@code imageType} <b>must</b> be {@link VK10#VK_IMAGE_TYPE_2D IMAGE_TYPE_2D}</li>
 * <li>If the image {@code format} is one of those listed in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#formats-requiring-sampler-ycbcr-conversion">Formats requiring sampler Y'C<sub>B</sub>C<sub>R</sub> conversion for {@link VK10#VK_IMAGE_ASPECT_COLOR_BIT IMAGE_ASPECT_COLOR_BIT} image views</a>, and the {@code ycbcrImageArrays} feature is not enabled, {@code arrayLayers} <b>must</b> be 1</li>
 * <li>If {@code format} is a <em>multi-planar</em> format, and if {@code imageCreateFormatFeatures} (as defined in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#resources-image-creation-limits">Image Creation Limits</a>) does not contain {@link VK11#VK_FORMAT_FEATURE_DISJOINT_BIT FORMAT_FEATURE_DISJOINT_BIT}, then {@code flags} <b>must</b> not contain {@link VK11#VK_IMAGE_CREATE_DISJOINT_BIT IMAGE_CREATE_DISJOINT_BIT}.</li>
 * <li>If {@code format} is not a <em>multi-planar</em> format, and {@code flags} does not include {@link VK11#VK_IMAGE_CREATE_ALIAS_BIT IMAGE_CREATE_ALIAS_BIT}, {@code flags} <b>must</b> not contain {@link VK11#VK_IMAGE_CREATE_DISJOINT_BIT IMAGE_CREATE_DISJOINT_BIT}</li>
 * <li>If {@code tiling} is {@link EXTImageDrmFormatModifier#VK_IMAGE_TILING_DRM_FORMAT_MODIFIER_EXT IMAGE_TILING_DRM_FORMAT_MODIFIER_EXT}, then the {@code pNext} chain <b>must</b> contain exactly one of {@link VkImageDrmFormatModifierListCreateInfoEXT} or {@link VkImageDrmFormatModifierExplicitCreateInfoEXT}.</li>
 * <li>If the {@code pNext} chain contains {@link VkImageDrmFormatModifierListCreateInfoEXT} or {@link VkImageDrmFormatModifierExplicitCreateInfoEXT}, then {@code tiling} <b>must</b> be {@link EXTImageDrmFormatModifier#VK_IMAGE_TILING_DRM_FORMAT_MODIFIER_EXT IMAGE_TILING_DRM_FORMAT_MODIFIER_EXT}.</li>
 * <li>If {@code tiling} is {@link EXTImageDrmFormatModifier#VK_IMAGE_TILING_DRM_FORMAT_MODIFIER_EXT IMAGE_TILING_DRM_FORMAT_MODIFIER_EXT} and {@code flags} contains {@link VK10#VK_IMAGE_CREATE_MUTABLE_FORMAT_BIT IMAGE_CREATE_MUTABLE_FORMAT_BIT}, then the {@code pNext} chain <b>must</b> contain {@link VkImageFormatListCreateInfoKHR} with non-zero {@code viewFormatCount}.</li>
 * <li>If {@code flags} contains {@link EXTSampleLocations#VK_IMAGE_CREATE_SAMPLE_LOCATIONS_COMPATIBLE_DEPTH_BIT_EXT IMAGE_CREATE_SAMPLE_LOCATIONS_COMPATIBLE_DEPTH_BIT_EXT} {@code format} <b>must</b> be a depth or depth/stencil format</li>
 * <li>If {@code format} is a depth-stencil format and the {@code pNext} chain contains an instance of {@link VkImageStencilUsageCreateInfoEXT}, then its {@code stencilUsage} member <b>must</b> only include {@link VK10#VK_IMAGE_USAGE_DEPTH_STENCIL_ATTACHMENT_BIT IMAGE_USAGE_DEPTH_STENCIL_ATTACHMENT_BIT} if {@code usage} also includes it</li>
 * <li>If {@code format} is a depth-stencil format and the {@code pNext} chain contains an instance of {@link VkImageStencilUsageCreateInfoEXT}, then its {@code stencilUsage} member <b>must</b> only include {@link VK10#VK_IMAGE_USAGE_TRANSIENT_ATTACHMENT_BIT IMAGE_USAGE_TRANSIENT_ATTACHMENT_BIT} if {@code usage} also includes it</li>
 * <li>If {@code Format} is a depth-stencil format and the {@code pNext} chain contains an instance of {@link VkImageStencilUsageCreateInfoEXT} with its {@code stencilUsage} member including {@link VK10#VK_IMAGE_USAGE_INPUT_ATTACHMENT_BIT IMAGE_USAGE_INPUT_ATTACHMENT_BIT}, {@code extent.width} <b>must</b> be less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxFramebufferWidth}</li>
 * <li>If {@code format} is a depth-stencil format and the {@code pNext} chain contains an instance of {@link VkImageStencilUsageCreateInfoEXT} with its {@code stencilUsage} member including {@link VK10#VK_IMAGE_USAGE_INPUT_ATTACHMENT_BIT IMAGE_USAGE_INPUT_ATTACHMENT_BIT}, {@code extent.height} <b>must</b> be less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxFramebufferHeight}</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-shaderStorageImageMultisample">multisampled storage images</a> feature is not enabled, {@code format} is a depth-stencil format and the {@code pNext} chain contains an instance of {@link VkImageStencilUsageCreateInfoEXT} with its {@code stencilUsage} including {@link VK10#VK_IMAGE_USAGE_STORAGE_BIT IMAGE_USAGE_STORAGE_BIT}, {@code samples} <b>must</b> be {@link VK10#VK_SAMPLE_COUNT_1_BIT SAMPLE_COUNT_1_BIT}</li>
 * <li>If {@code flags} contains {@link NVCornerSampledImage#VK_IMAGE_CREATE_CORNER_SAMPLED_BIT_NV IMAGE_CREATE_CORNER_SAMPLED_BIT_NV}, {@code imageType} <b>must</b> be {@link VK10#VK_IMAGE_TYPE_2D IMAGE_TYPE_2D} or {@link VK10#VK_IMAGE_TYPE_3D IMAGE_TYPE_3D}</li>
 * <li>If {@code flags} contains {@link NVCornerSampledImage#VK_IMAGE_CREATE_CORNER_SAMPLED_BIT_NV IMAGE_CREATE_CORNER_SAMPLED_BIT_NV}, it <b>must</b> not contain {@link VK10#VK_IMAGE_CREATE_CUBE_COMPATIBLE_BIT IMAGE_CREATE_CUBE_COMPATIBLE_BIT} and the {@code format} <b>must</b> not be a depth/stencil format</li>
 * <li>If {@code flags} contains {@link NVCornerSampledImage#VK_IMAGE_CREATE_CORNER_SAMPLED_BIT_NV IMAGE_CREATE_CORNER_SAMPLED_BIT_NV} and {@code imageType} is {@link VK10#VK_IMAGE_TYPE_2D IMAGE_TYPE_2D}, {@code extent}{@code ::width} and {@code extent}{@code ::height} <b>must</b> be greater than 1</li>
 * <li>If {@code flags} contains {@link NVCornerSampledImage#VK_IMAGE_CREATE_CORNER_SAMPLED_BIT_NV IMAGE_CREATE_CORNER_SAMPLED_BIT_NV} and {@code imageType} is {@link VK10#VK_IMAGE_TYPE_3D IMAGE_TYPE_3D}, {@code extent}{@code ::width}, {@code extent}{@code ::height}, and {@code extent}{@code ::depth} <b>must</b> be greater than 1</li>
 * <li>If {@code usage} includes {@link NVShadingRateImage#VK_IMAGE_USAGE_SHADING_RATE_IMAGE_BIT_NV IMAGE_USAGE_SHADING_RATE_IMAGE_BIT_NV}, {@code imageType} <b>must</b> be {@link VK10#VK_IMAGE_TYPE_2D IMAGE_TYPE_2D}.</li>
 * <li>If {@code usage} includes {@link NVShadingRateImage#VK_IMAGE_USAGE_SHADING_RATE_IMAGE_BIT_NV IMAGE_USAGE_SHADING_RATE_IMAGE_BIT_NV}, {@code samples} <b>must</b> be {@link VK10#VK_SAMPLE_COUNT_1_BIT SAMPLE_COUNT_1_BIT}.</li>
 * <li>If {@code usage} includes {@link NVShadingRateImage#VK_IMAGE_USAGE_SHADING_RATE_IMAGE_BIT_NV IMAGE_USAGE_SHADING_RATE_IMAGE_BIT_NV}, {@code tiling} <b>must</b> be {@link VK10#VK_IMAGE_TILING_OPTIMAL IMAGE_TILING_OPTIMAL}.</li>
 * <li>If {@code flags} contains {@link EXTFragmentDensityMap#VK_IMAGE_CREATE_SUBSAMPLED_BIT_EXT IMAGE_CREATE_SUBSAMPLED_BIT_EXT}, {@code tiling} <b>must</b> be {@link VK10#VK_IMAGE_TILING_OPTIMAL IMAGE_TILING_OPTIMAL}</li>
 * <li>If {@code flags} contains {@link EXTFragmentDensityMap#VK_IMAGE_CREATE_SUBSAMPLED_BIT_EXT IMAGE_CREATE_SUBSAMPLED_BIT_EXT}, {@code imageType} <b>must</b> be {@link VK10#VK_IMAGE_TYPE_2D IMAGE_TYPE_2D}</li>
 * <li>If {@code flags} contains {@link EXTFragmentDensityMap#VK_IMAGE_CREATE_SUBSAMPLED_BIT_EXT IMAGE_CREATE_SUBSAMPLED_BIT_EXT}, {@code flags} <b>must</b> not contain {@link VK10#VK_IMAGE_CREATE_CUBE_COMPATIBLE_BIT IMAGE_CREATE_CUBE_COMPATIBLE_BIT}</li>
 * <li>If {@code flags} contains {@link EXTFragmentDensityMap#VK_IMAGE_CREATE_SUBSAMPLED_BIT_EXT IMAGE_CREATE_SUBSAMPLED_BIT_EXT}, {@code mipLevels} <b>must</b> be 1</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK10#VK_STRUCTURE_TYPE_IMAGE_CREATE_INFO STRUCTURE_TYPE_IMAGE_CREATE_INFO}</li>
 * <li>Each {@code pNext} member of any structure (including this one) in the {@code pNext} chain <b>must</b> be either {@code NULL} or a pointer to a valid instance of {@link VkDedicatedAllocationImageCreateInfoNV}, {@link VkExternalMemoryImageCreateInfo}, {@link VkExternalMemoryImageCreateInfoNV}, {@link VkImageDrmFormatModifierExplicitCreateInfoEXT}, {@link VkImageDrmFormatModifierListCreateInfoEXT}, {@link VkImageFormatListCreateInfoKHR}, {@link VkImageStencilUsageCreateInfoEXT}, or {@link VkImageSwapchainCreateInfoKHR}</li>
 * <li>Each {@code sType} member in the {@code pNext} chain <b>must</b> be unique</li>
 * <li>{@code flags} <b>must</b> be a valid combination of {@code VkImageCreateFlagBits} values</li>
 * <li>{@code imageType} <b>must</b> be a valid {@code VkImageType} value</li>
 * <li>{@code format} <b>must</b> be a valid {@code VkFormat} value</li>
 * <li>{@code samples} <b>must</b> be a valid {@code VkSampleCountFlagBits} value</li>
 * <li>{@code tiling} <b>must</b> be a valid {@code VkImageTiling} value</li>
 * <li>{@code usage} <b>must</b> be a valid combination of {@code VkImageUsageFlagBits} values</li>
 * <li>{@code usage} <b>must</b> not be 0</li>
 * <li>{@code sharingMode} <b>must</b> be a valid {@code VkSharingMode} value</li>
 * <li>{@code initialLayout} <b>must</b> be a valid {@code VkImageLayout} value</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkExtent3D}, {@link VK10#vkCreateImage CreateImage}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code flags} &ndash; a bitmask of {@code VkImageCreateFlagBits} describing additional parameters of the image.</li>
 * <li>{@code imageType} &ndash; a {@code VkImageType} value specifying the basic dimensionality of the image. Layers in array textures do not count as a dimension for the purposes of the image type.</li>
 * <li>{@code format} &ndash; a {@code VkFormat} describing the format and type of the texel blocks that will be contained in the image.</li>
 * <li>{@code extent} &ndash; a {@link VkExtent3D} describing the number of data elements in each dimension of the base level.</li>
 * <li>{@code mipLevels} &ndash; describes the number of levels of detail available for minified sampling of the image.</li>
 * <li>{@code arrayLayers} &ndash; the number of layers in the image.</li>
 * <li>{@code samples} &ndash; a {@code VkSampleCountFlagBits} specifying the number of <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#primsrast-multisampling">samples per texel</a>.</li>
 * <li>{@code tiling} &ndash; a {@code VkImageTiling} value specifying the tiling arrangement of the texel blocks in memory.</li>
 * <li>{@code usage} &ndash; a bitmask of {@code VkImageUsageFlagBits} describing the intended usage of the image.</li>
 * <li>{@code sharingMode} &ndash; a {@code VkSharingMode} value specifying the sharing mode of the image when it will be accessed by multiple queue families.</li>
 * <li>{@code queueFamilyIndexCount} &ndash; the number of entries in the {@code pQueueFamilyIndices} array.</li>
 * <li>{@code pQueueFamilyIndices} &ndash; a list of queue families that will access this image (ignored if {@code sharingMode} is not {@link VK10#VK_SHARING_MODE_CONCURRENT SHARING_MODE_CONCURRENT}).</li>
 * <li>{@code initialLayout} &ndash; a {@code VkImageLayout} value specifying the initial {@code VkImageLayout} of all image subresources of the image. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#resources-image-layouts">Image Layouts</a>.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkImageCreateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkImageCreateFlags flags;
 *     VkImageType imageType;
 *     VkFormat format;
 *     {@link VkExtent3D VkExtent3D} extent;
 *     uint32_t mipLevels;
 *     uint32_t arrayLayers;
 *     VkSampleCountFlagBits samples;
 *     VkImageTiling tiling;
 *     VkImageUsageFlags usage;
 *     VkSharingMode sharingMode;
 *     uint32_t queueFamilyIndexCount;
 *     uint32_t const * pQueueFamilyIndices;
 *     VkImageLayout initialLayout;
 * }</code></pre>
 */
class ImageCreateInfo(
        var flags: VkImageCreateFlags = 0,
        var imageType: VkImageType,
        var format: VkFormat,
        var extent: Extent3D,
        var mipLevels: Int,
        var arrayLayers: Int,
        var samples: VkSampleCount,
        var tiling: VkImageTiling,
        var usage: VkImageUsageFlags,
        var sharingMode: VkSharingMode = VkSharingMode.EXCLUSIVE,
        var queueFamilyIndices: IntArray? = null,
        var initialLayout: VkImageLayout = VkImageLayout.UNDEFINED,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.IMAGE_CREATE_INFO

    infix fun write(stack: MemoryStack): Adr {
        val adr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
        nsType(adr, type.i)
        npNext(adr, next)
        nflags(adr, flags)
        nimageType(adr, imageType.i)
        nformat(adr, format.i)
        extent write (adr + EXTENT)
        nmipLevels(adr, mipLevels)
        narrayLayers(adr, arrayLayers)
        nsamples(adr, samples.i)
        ntiling(adr, tiling.i)
        nusage(adr, usage)
        nsharingMode(adr, sharingMode.i)
        queueFamilyIndices?.let {
            nqueueFamilyIndexCount(adr, it.size)
            memPutAddress(adr + PQUEUEFAMILYINDICES, stack.adr(it))
        }
        ninitialLayout(adr, initialLayout.i)
        return adr
    }
}