package vkk.classes

import kool.Adr
import kool.BytePtr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkSparseImageMemoryRequirements
import org.lwjgl.vulkan.VkSparseImageMemoryRequirements.*
import vkk.entities.VkDeviceSize

/**
 * Structure specifying sparse image memory requirements.
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code formatProperties} &ndash; {@code formatProperties.aspectMask} is the set of aspects of the image that this sparse memory requirement applies to. This will usually have a single aspect specified. However, depth/stencil images <b>may</b> have depth and stencil data interleaved in the same sparse block, in which case both {@link VK10#VK_IMAGE_ASPECT_DEPTH_BIT IMAGE_ASPECT_DEPTH_BIT} and {@link VK10#VK_IMAGE_ASPECT_STENCIL_BIT IMAGE_ASPECT_STENCIL_BIT} would be present.
 *
 * <p>{@code formatProperties.imageGranularity} describes the dimensions of a single bindable sparse image block in texel units. For aspect {@link VK10#VK_IMAGE_ASPECT_METADATA_BIT IMAGE_ASPECT_METADATA_BIT}, all dimensions will be zero. All metadata is located in the mip tail region.</p>
 *
 * <p>{@code formatProperties.flags} is a bitmask of {@code VkSparseImageFormatFlagBits}:</p>
 *
 * <ul>
 * <li>If {@link VK10#VK_SPARSE_IMAGE_FORMAT_SINGLE_MIPTAIL_BIT SPARSE_IMAGE_FORMAT_SINGLE_MIPTAIL_BIT} is set the image uses a single mip tail region for all array layers.</li>
 * <li>If {@link VK10#VK_SPARSE_IMAGE_FORMAT_ALIGNED_MIP_SIZE_BIT SPARSE_IMAGE_FORMAT_ALIGNED_MIP_SIZE_BIT} is set the dimensions of mip levels <b>must</b> be integer multiples of the corresponding dimensions of the sparse image block for levels not located in the mip tail.</li>
 * <li>If {@link VK10#VK_SPARSE_IMAGE_FORMAT_NONSTANDARD_BLOCK_SIZE_BIT SPARSE_IMAGE_FORMAT_NONSTANDARD_BLOCK_SIZE_BIT} is set the image uses non-standard sparse image block dimensions. The {@code formatProperties.imageGranularity} values do not match the standard sparse image block dimension corresponding to the image&#8217;s format.</li>
 * </ul></li>
 * <li>{@code imageMipTailFirstLod} &ndash; the first mip level at which image subresources are included in the mip tail region.</li>
 * <li>{@code imageMipTailSize} &ndash; the memory size (in bytes) of the mip tail region. If {@code formatProperties.flags} contains {@link VK10#VK_SPARSE_IMAGE_FORMAT_SINGLE_MIPTAIL_BIT SPARSE_IMAGE_FORMAT_SINGLE_MIPTAIL_BIT}, this is the size of the whole mip tail, otherwise this is the size of the mip tail of a single array layer. This value is guaranteed to be a multiple of the sparse block size in bytes.</li>
 * <li>{@code imageMipTailOffset} &ndash; the opaque memory offset used with {@link VkSparseImageOpaqueMemoryBindInfo} to bind the mip tail region(s).</li>
 * <li>{@code imageMipTailStride} &ndash; the offset stride between each array-layer&#8217;s mip tail, if {@code formatProperties.flags} does not contain {@link VK10#VK_SPARSE_IMAGE_FORMAT_SINGLE_MIPTAIL_BIT SPARSE_IMAGE_FORMAT_SINGLE_MIPTAIL_BIT} (otherwise the value is undefined).</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkSparseImageMemoryRequirements {
 *     {@link VkSparseImageFormatProperties VkSparseImageFormatProperties} formatProperties;
 *     uint32_t imageMipTailFirstLod;
 *     VkDeviceSize imageMipTailSize;
 *     VkDeviceSize imageMipTailOffset;
 *     VkDeviceSize imageMipTailStride;
 * }</code></pre>
 */
class SparseImageMemoryRequirements(
        var formatProperties: SparseImageFormatProperties,
        var imageMipTailFirstLod: Int,
        var imageMipTailSize: VkDeviceSize,
        var imageMipTailOffset: VkDeviceSize,
        var imageMipTailStride: VkDeviceSize
) {

    constructor(ptr: BytePtr) : this(
            SparseImageFormatProperties(BytePtr(ptr.adr + FORMATPROPERTIES)),
            nimageMipTailFirstLod(ptr.adr),
            VkDeviceSize(nimageMipTailSize(ptr.adr)),
            VkDeviceSize(nimageMipTailOffset(ptr.adr)),
            VkDeviceSize(nimageMipTailStride(ptr.adr))
    )

    fun <R> read(stack: MemoryStack, block: (Adr) -> R): SparseImageMemoryRequirements =
            SparseImageMemoryRequirements(BytePtr(stack.ncalloc(ALIGNOF, 1, SIZEOF)))
}