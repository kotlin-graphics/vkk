package vkk.classes

import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkPushConstantRange.*
import vkk.VkShaderStageFlags

/**
 * Structure specifying a push constant range.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code offset} <b>must</b> be less than {@link VkPhysicalDeviceLimits}{@code ::maxPushConstantsSize}</li>
 * <li>{@code offset} <b>must</b> be a multiple of 4</li>
 * <li>{@code size} <b>must</b> be greater than 0</li>
 * <li>{@code size} <b>must</b> be a multiple of 4</li>
 * <li>{@code size} <b>must</b> be less than or equal to {@link VkPhysicalDeviceLimits}{@code ::maxPushConstantsSize} minus {@code offset}</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code stageFlags} <b>must</b> be a valid combination of {@code VkShaderStageFlagBits} values</li>
 * <li>{@code stageFlags} <b>must</b> not be 0</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkPipelineLayoutCreateInfo}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code stageFlags} &ndash; a set of stage flags describing the shader stages that will access a range of push constants. If a particular stage is not included in the range, then accessing members of that range of push constants from the corresponding shader stage will return undefined values.</li>
 * <li>{@code offset} &ndash; {@code offset} and {@code size} are the start offset and size, respectively, consumed by the range. Both {@code offset} and {@code size} are in units of bytes and <b>must</b> be a multiple of 4. The layout of the push constant variables is specified in the shader.</li>
 * <li>{@code size} &ndash; see {@code offset}</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPushConstantRange {
 *     VkShaderStageFlags stageFlags;
 *     uint32_t offset;
 *     uint32_t size;
 * }</code></pre>
 */
class PushConstantRange(
    var stageFlags: VkShaderStageFlags,
    var offset: Int = 0,
    var size: Int
) {

    infix fun write(ptr: Ptr) {
        nstageFlags(ptr, stageFlags)
        noffset(ptr, offset)
        nsize(ptr, size)
    }
}

infix fun Array<PushConstantRange>.write(stack: MemoryStack): Ptr {
    val ranges = stack.ncalloc(ALIGNOF, size, SIZEOF)
    for (i in indices)
        this[i] write (ranges + i * SIZEOF)
    return ranges
}