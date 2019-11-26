package classes

import glm_.asRawIntBits
import glm_.bitsAsFloat
import glm_.vec4.Vec4
import glm_.vec4.Vec4ui

/**
 * Structure specifying a clear color value.
 *
 * <h5>Description</h5>
 *
 * <p>The four array elements of the clear color map to R, G, B, and A components of image formats, in order.</p>
 *
 * <p>If the image has more than one sample, the same value is written to all samples for any pixels being cleared.</p>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkClearValue}, {@link VK10#vkCmdClearColorImage CmdClearColorImage}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code float32[4]} &ndash; are the color clear values when the format of the image or attachment is one of the formats in the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#formats-numericformat">Interpretation of Numeric Format</a> table other than signed integer ({@code SINT}) or unsigned integer ({@code UINT}). Floating point values are automatically converted to the format of the image, with the clear value being treated as linear if the image is sRGB.</li>
 * <li>{@code int32[4]} &ndash; are the color clear values when the format of the image or attachment is signed integer ({@code SINT}). Signed integer values are converted to the format of the image by casting to the smaller type (with negative 32-bit values mapping to negative values in the smaller type). If the integer clear value is not representable in the target type (e.g. would overflow in conversion to that type), the clear value is undefined.</li>
 * <li>{@code uint32[4]} &ndash; are the color clear values when the format of the image or attachment is unsigned integer ({@code UINT}). Unsigned integer values are converted to the format of the image by casting to the integer type with fewer bits.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * union VkClearColorValue {
 *     float float32[4];
 *     int32_t int32[4];
 *     uint32_t uint32[4];
 * }</code></pre>
 */
class ClearColorValue(
    var value: IntArray = IntArray(4)
) {

    constructor(float32: FloatArray) : this(IntArray(4) { float32[it].asRawIntBits })
    constructor(vec4: Vec4) : this(IntArray(4) { vec4[it].asRawIntBits })
    constructor(uint32: Vec4ui) : this(IntArray(4) { uint32[it].v })

    var vec4: Vec4
        get() = Vec4{ value[it].bitsAsFloat }
        set(value) {
            for(i in 0..3)
                this.value[i] = value[i].asRawIntBits
        }

    val int32: IntArray
        get() = value
}