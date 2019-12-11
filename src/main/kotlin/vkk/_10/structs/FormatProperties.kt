package vkk._10.structs

import kool.Adr
import kool.BytePtr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkFormatProperties.*
import vkk.VkFormatFeatureFlags
import vkk.stak

/**
 * Structure specifying image format properties.
 *
 * <h5>Description</h5>
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>If no format feature flags are supported, the format itself is not supported, and images of that format cannot be created.</p>
 * </div>
 *
 * <p>If {@code format} is a block-compressed format, then {@code bufferFeatures} <b>must</b> not support any features for the format.</p>
 *
 * <p>If {@code format} is not a multi-plane format then {@code linearTilingFeatures} and {@code optimalTilingFeatures} <b>must</b> not contain {@link VK11#VK_FORMAT_FEATURE_DISJOINT_BIT FORMAT_FEATURE_DISJOINT_BIT}.</p>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkFormatProperties2}, {@link VK10#vkGetPhysicalDeviceFormatProperties GetPhysicalDeviceFormatProperties}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code linearTilingFeatures} &ndash; a bitmask of {@code VkFormatFeatureFlagBits} specifying features supported by images created with a {@code tiling} parameter of {@link VK10#VK_IMAGE_TILING_LINEAR IMAGE_TILING_LINEAR}.</li>
 * <li>{@code optimalTilingFeatures} &ndash; a bitmask of {@code VkFormatFeatureFlagBits} specifying features supported by images created with a {@code tiling} parameter of {@link VK10#VK_IMAGE_TILING_OPTIMAL IMAGE_TILING_OPTIMAL}.</li>
 * <li>{@code bufferFeatures} &ndash; a bitmask of {@code VkFormatFeatureFlagBits} specifying features supported by buffers.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkFormatProperties {
 *     VkFormatFeatureFlags linearTilingFeatures;
 *     VkFormatFeatureFlags optimalTilingFeatures;
 *     VkFormatFeatureFlags bufferFeatures;
 * }</code></pre>
 */
class FormatProperties(
        var linearTilingFeatures: VkFormatFeatureFlags,
        var optimalTilingFeatures: VkFormatFeatureFlags,
        var bufferFeatures: VkFormatFeatureFlags
) {
    constructor(ptr: BytePtr) : this(
            nlinearTilingFeatures(ptr.adr),
            noptimalTilingFeatures(ptr.adr),
            nbufferFeatures(ptr.adr)
    )

    companion object {
        //inline infix fun <R> read(block: (Adr) -> R): FormatProperties = stak { read(it, block) }
        inline fun <R> read(stack: MemoryStack, block: (Adr) -> R): FormatProperties {
            val adr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
            block(adr)
            return FormatProperties(BytePtr(adr))
        }
    }
}