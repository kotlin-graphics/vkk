package vkk.vk11.structs

import kool.BytePtr
import org.lwjgl.vulkan.VkExternalMemoryProperties.*
import vkk.VkExternalMemoryFeatureFlags
import vkk.VkExternalMemoryHandleTypeFlags

/**
 * Structure specifying external memory handle type capabilities.
 *
 * <h5>Description</h5>
 *
 * <p>{@code compatibleHandleTypes} <b>must</b> include at least {@code handleType}. Inclusion of a handle type in {@code compatibleHandleTypes} does not imply the values returned in {@link VkImageFormatProperties2} will be the same when {@link VkPhysicalDeviceExternalImageFormatInfo}{@code ::handleType} is set to that type. The application is responsible for querying the capabilities of all handle types intended for concurrent use in a single image and intersecting them to obtain the compatible set of capabilities.</p>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkExternalBufferProperties}, {@link VkExternalImageFormatProperties}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code externalMemoryFeatures} &ndash; a bitmask of {@code VkExternalMemoryFeatureFlagBits} specifying the features of {@code handleType}.</li>
 * <li>{@code exportFromImportedHandleTypes} &ndash; a bitmask of {@code VkExternalMemoryHandleTypeFlagBits} specifying which types of imported handle {@code handleType} <b>can</b> be exported from.</li>
 * <li>{@code compatibleHandleTypes} &ndash; a bitmask of {@code VkExternalMemoryHandleTypeFlagBits} specifying handle types which <b>can</b> be specified at the same time as {@code handleType} when creating an image compatible with external memory.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkExternalMemoryProperties {
 *     VkExternalMemoryFeatureFlags externalMemoryFeatures;
 *     VkExternalMemoryHandleTypeFlags exportFromImportedHandleTypes;
 *     VkExternalMemoryHandleTypeFlags compatibleHandleTypes;
 * }</code></pre>
 */
class ExternalMemoryProperties(
        var externalMemoryFeatures: VkExternalMemoryFeatureFlags,
        var exportFromImportedHandleTypes: VkExternalMemoryHandleTypeFlags,
        var compatibleHandleTypes: VkExternalMemoryHandleTypeFlags
) {

    constructor(ptr: BytePtr): this(
            nexternalMemoryFeatures(ptr.adr),
            nexportFromImportedHandleTypes(ptr.adr),
            ncompatibleHandleTypes(ptr.adr)
    )
}