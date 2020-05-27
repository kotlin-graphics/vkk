package vkk.vk11.structs

import kool.Ptr
import org.lwjgl.system.MemoryUtil.NULL
import vkk.VkStructureType
import vkk.vk10.structs.Rect2D

/**
 * Structure specifying device within a group to bind to.
 *
 * <h5>Description</h5>
 *
 * <p>The {@link VkBindImageMemoryDeviceGroupInfo} structure is defined as:</p>
 *
 * <ul>
 * <li>{@code sType} is the type of this structure.</li>
 * <li>{@code pNext} is {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code deviceIndexCount} is the number of elements in {@code pDeviceIndices}.</li>
 * <li>{@code pDeviceIndices} is a pointer to an array of device indices.</li>
 * <li>{@code splitInstanceBindRegionCount} is the number of elements in {@code pSplitInstanceBindRegions}.</li>
 * <li>{@code pSplitInstanceBindRegions} is a pointer to an array of rectangles describing which regions of the image are attached to each instance of memory.</li>
 * </ul>
 *
 * <p>If {@code deviceIndexCount} is greater than zero, then on device index <code>i</code> {@code image} is attached to the instance of the memory on the physical device with device index <code>pDeviceIndices[i]</code>.</p>
 *
 * <p>Let <code>N</code> be the number of physical devices in the logical device. If {@code splitInstanceBindRegionCount} is greater than zero, then {@code pSplitInstanceBindRegions} is an array of <code>N<sup>2</sup></code> rectangles, where the image region specified by the rectangle at element <code>i*N+j</code> in resource instance <code>i</code> is bound to the memory instance <code>j</code>. The blocks of the memory that are bound to each sparse image block region use an offset in memory, relative to {@code memoryOffset}, computed as if the whole image were being bound to a contiguous range of memory. In other words, horizontally adjacent image blocks use consecutive blocks of memory, vertically adjacent image blocks are separated by the number of bytes per block multiplied by the width in blocks of {@code image}, and the block at <code>(0,0)</code> corresponds to memory starting at {@code memoryOffset}.</p>
 *
 * <p>If {@code splitInstanceBindRegionCount} and {@code deviceIndexCount} are zero and the memory comes from a memory heap with the {@link VK11#VK_MEMORY_HEAP_MULTI_INSTANCE_BIT MEMORY_HEAP_MULTI_INSTANCE_BIT} bit set, then it is as if {@code pDeviceIndices} contains consecutive indices from zero to the number of physical devices in the logical device, minus one. In other words, by default each physical device attaches to its own instance of the memory.</p>
 *
 * <p>If {@code splitInstanceBindRegionCount} and {@code deviceIndexCount} are zero and the memory comes from a memory heap without the {@link VK11#VK_MEMORY_HEAP_MULTI_INSTANCE_BIT MEMORY_HEAP_MULTI_INSTANCE_BIT} bit set, then it is as if {@code pDeviceIndices} contains an array of zeros. In other words, by default each physical device attaches to instance zero.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>At least one of {@code deviceIndexCount} and {@code splitInstanceBindRegionCount} <b>must</b> be zero.</li>
 * <li>{@code deviceIndexCount} <b>must</b> either be zero or equal to the number of physical devices in the logical device</li>
 * <li>All elements of {@code pDeviceIndices} <b>must</b> be valid device indices.</li>
 * <li>{@code splitInstanceBindRegionCount} <b>must</b> either be zero or equal to the number of physical devices in the logical device squared</li>
 * <li>Elements of {@code pSplitInstanceBindRegions} that correspond to the same instance of an image <b>must</b> not overlap.</li>
 * <li>The {@code offset.x} member of any element of {@code pSplitInstanceBindRegions} <b>must</b> be a multiple of the sparse image block width ({@link VkSparseImageFormatProperties}{@code ::imageGranularity}.width) of all non-metadata aspects of the image</li>
 * <li>The {@code offset.y} member of any element of {@code pSplitInstanceBindRegions} <b>must</b> be a multiple of the sparse image block height ({@link VkSparseImageFormatProperties}{@code ::imageGranularity}.height) of all non-metadata aspects of the image</li>
 * <li>The {@code extent.width} member of any element of {@code pSplitInstanceBindRegions} <b>must</b> either be a multiple of the sparse image block width of all non-metadata aspects of the image, or else {@code extent.width} + {@code offset.x} <b>must</b> equal the width of the image subresource</li>
 * <li>The {@code extent.height} member of any element of {@code pSplitInstanceBindRegions} <b>must</b> either be a multiple of the sparse image block height of all non-metadata aspects of the image, or else {@code extent.height} {@code offset.y} <b>must</b> equal the width of the image subresource</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_BIND_IMAGE_MEMORY_DEVICE_GROUP_INFO STRUCTURE_TYPE_BIND_IMAGE_MEMORY_DEVICE_GROUP_INFO}</li>
 * <li>If {@code deviceIndexCount} is not 0, {@code pDeviceIndices} <b>must</b> be a valid pointer to an array of {@code deviceIndexCount} {@code uint32_t} values</li>
 * <li>If {@code splitInstanceBindRegionCount} is not 0, {@code pSplitInstanceBindRegions} <b>must</b> be a valid pointer to an array of {@code splitInstanceBindRegionCount} {@link VkRect2D} structures</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkRect2D}</p>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkBindImageMemoryDeviceGroupInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     uint32_t deviceIndexCount;
 *     uint32_t const * pDeviceIndices;
 *     uint32_t splitInstanceBindRegionCount;
 *     {@link VkRect2D VkRect2D} const * pSplitInstanceBindRegions;
 * }</code></pre>
 */
class BindImageMemoryDeviceGroupInfo(
    var deviceIndices: IntArray? = null,
    var splitInstanceBindRegions: Array<Rect2D>? = null,
    var next: Ptr = NULL
) {

    val type get() = VkStructureType.BIND_IMAGE_MEMORY_DEVICE_GROUP_INFO
}