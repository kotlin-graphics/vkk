package classes

import glm_.asRawIntBits
import glm_.bitsAsFloat

/**
 * Structure specifying a clear depth stencil value.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>Unless the {@link EXTDepthRangeUnrestricted VK_EXT_depth_range_unrestricted} extension is enabled {@code depth} <b>must</b> be between {@code 0.0} and {@code 1.0}, inclusive</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkClearValue}, {@link VK10#vkCmdClearDepthStencilImage CmdClearDepthStencilImage}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code depth} &ndash; the clear value for the depth aspect of the depth/stencil attachment. It is a floating-point value which is automatically converted to the attachment&#8217;s format.</li>
 * <li>{@code stencil} &ndash; the clear value for the stencil aspect of the depth/stencil attachment. It is a 32-bit integer value which is converted to the attachment&#8217;s format by taking the appropriate number of LSBs.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkClearDepthStencilValue {
 *     float depth;
 *     uint32_t stencil;
 * }</code></pre>
 */
class ClearDepthStencilValue(
    var value: Int = 0
) {
    var depth: Float
        get() = value.bitsAsFloat
        set(value) {
            this.value = value.asRawIntBits
        }

    var stencil: Int
        get() = value
        set(value) {
            this.value = value
        }
}