package classes

import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkQueueFamilyProperties.*
import vkk.VkQueueFlags

/**
 * Structure providing information about a queue family.
 *
 * <h5>Description</h5>
 *
 * <p>The value returned in {@code minImageTransferGranularity} has a unit of compressed texel blocks for images having a block-compressed format, and a unit of texels otherwise.</p>
 *
 * <p>Possible values of {@code minImageTransferGranularity} are:</p>
 *
 * <ul>
 * <li><code>(0,0,0)</code> which indicates that only whole mip levels <b>must</b> be transferred using the image transfer operations on the corresponding queues. In this case, the following restrictions apply to all offset and extent parameters of image transfer operations:
 *
 * <ul>
 * <li>The {@code x}, {@code y}, and {@code z} members of a {@link VkOffset3D} parameter <b>must</b> always be zero.</li>
 * <li>The {@code width}, {@code height}, and {@code depth} members of a {@link VkExtent3D} parameter <b>must</b> always match the width, height, and depth of the image subresource corresponding to the parameter, respectively.</li>
 * </ul>
 * </li>
 * <li><code>(A<sub>x</sub>, A<sub>y</sub>, A<sub>z</sub>)</code> where <code>A<sub>x</sub></code>, <code>A<sub>y</sub></code>, and <code>A<sub>z</sub></code> are all integer powers of two. In this case the following restrictions apply to all image transfer operations:
 *
 * <ul>
 * <li>{@code x}, {@code y}, and {@code z} of a {@link VkOffset3D} parameter <b>must</b> be integer multiples of <code>A<sub>x</sub></code>, <code>A<sub>y</sub></code>, and <code>A<sub>z</sub></code>, respectively.</li>
 * <li>{@code width} of a {@link VkExtent3D} parameter <b>must</b> be an integer multiple of <code>A<sub>x</sub></code>, or else <code>x + width</code> <b>must</b> equal the width of the image subresource corresponding to the parameter.</li>
 * <li>{@code height} of a {@link VkExtent3D} parameter <b>must</b> be an integer multiple of <code>A<sub>y</sub></code>, or else <code>y + height</code> <b>must</b> equal the height of the image subresource corresponding to the parameter.</li>
 * <li>{@code depth} of a {@link VkExtent3D} parameter <b>must</b> be an integer multiple of <code>A<sub>z</sub></code>, or else <code>z + depth</code> <b>must</b> equal the depth of the image subresource corresponding to the parameter.</li>
 * <li>If the format of the image corresponding to the parameters is one of the block-compressed formats then for the purposes of the above calculations the granularity <b>must</b> be scaled up by the compressed texel block dimensions.</li>
 * </ul>
 * </li>
 * </ul>
 *
 * <p>Queues supporting graphics and/or compute operations <b>must</b> report <code>(1,1,1)</code> in {@code minImageTransferGranularity}, meaning that there are no additional restrictions on the granularity of image transfer operations for these queues. Other queues supporting image transfer operations are only required: to support whole mip level transfers, thus {@code minImageTransferGranularity} for queues belonging to such queue families <b>may</b> be <code>(0,0,0)</code>.</p>
 *
 * <p>The <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#memory-device">Device Memory</a> section describes memory properties queried from the physical device.</p>
 *
 * <p>For physical device feature queries see the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features">Features</a> chapter.</p>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkExtent3D}, {@link VkQueueFamilyProperties2}, {@link VK10#vkGetPhysicalDeviceQueueFamilyProperties GetPhysicalDeviceQueueFamilyProperties}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code queueFlags} &ndash; a bitmask of {@code VkQueueFlagBits} indicating capabilities of the queues in this queue family.</li>
 * <li>{@code queueCount} &ndash; the unsigned integer count of queues in this queue family. Each queue family <b>must</b> support at least one queue.</li>
 * <li>{@code timestampValidBits} &ndash; the unsigned integer count of meaningful bits in the timestamps written via {@code vkCmdWriteTimestamp}. The valid range for the count is 36..64 bits, or a value of 0, indicating no support for timestamps. Bits outside the valid range are guaranteed to be zeros.</li>
 * <li>{@code minImageTransferGranularity} &ndash; the minimum granularity supported for image transfer operations on the queues in this queue family.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkQueueFamilyProperties {
 *     VkQueueFlags queueFlags;
 *     uint32_t queueCount;
 *     uint32_t timestampValidBits;
 *     {@link VkExtent3D VkExtent3D} minImageTransferGranularity;
 * }</code></pre>
 */
class QueueFamilyProperties(
    var queueFlags: VkQueueFlags,
    var queueCount: Int,
    var timestampValidBits: Int,
    var minImageTransferGranularity: Extent3D
) {

    constructor(ptr: Ptr) : this(
        nqueueFlags(ptr),
        nqueueCount(ptr),
        ntimestampValidBits(ptr),
        Extent3D(ptr + MINIMAGETRANSFERGRANULARITY)
    )

    companion object {
        inline fun ncalloc(stack: MemoryStack, num: Int = 1): Ptr = stack.ncalloc(ALIGNOF, num, SIZEOF)
    }
}