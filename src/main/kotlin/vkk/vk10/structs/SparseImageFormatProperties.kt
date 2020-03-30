package vkk.vk10.structs

import kool.Adr
import kool.BytePtr
import kool.IntPtr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkSparseImageFormatProperties.*
import vkk.VkImageAspectFlags
import vkk.VkSparseImageFormatFlags

/**
 * Structure specifying sparse image format properties.
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code aspectMask} &ndash; a bitmask {@code VkImageAspectFlagBits} specifying which aspects of the image the properties apply to.</li>
 * <li>{@code imageGranularity} &ndash; the width, height, and depth of the sparse image block in texels or compressed texel blocks.</li>
 * <li>{@code flags} &ndash; a bitmask of {@code VkSparseImageFormatFlagBits} specifying additional information about the sparse resource.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkSparseImageFormatProperties {
 *     VkImageAspectFlags aspectMask;
 *     {@link VkExtent3D VkExtent3D} imageGranularity;
 *     VkSparseImageFormatFlags flags;
 * }</code></pre>
 */
class SparseImageFormatProperties(
        var aspectMask: VkImageAspectFlags,
        var imageGranularity: Extent3D,
        var flags: VkSparseImageFormatFlags
) {

    constructor(ptr: BytePtr) : this(
            naspectMask(ptr.adr),
            Extent3D(IntPtr(ptr.adr + IMAGEGRANULARITY)),
            nflags(ptr.adr)
    )

    fun <R> read(stack: MemoryStack, block: (Adr) -> R): SparseImageFormatProperties {
        val adr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
        block(adr)
        return SparseImageFormatProperties(BytePtr(adr))
    }
}