package vkk.classes

import kool.Adr
import kool.Ptr
import org.lwjgl.vulkan.VkComponentMapping.*
import vkk.VkComponentSwizzle

/**
 * Structure specifying a color component mapping.
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code r} <b>must</b> be a valid {@code VkComponentSwizzle} value</li>
 * <li>{@code g} <b>must</b> be a valid {@code VkComponentSwizzle} value</li>
 * <li>{@code b} <b>must</b> be a valid {@code VkComponentSwizzle} value</li>
 * <li>{@code a} <b>must</b> be a valid {@code VkComponentSwizzle} value</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkImageViewCreateInfo}, {@link VkSamplerYcbcrConversionCreateInfo}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code r} &ndash; a {@code VkComponentSwizzle} specifying the component value placed in the R component of the output vector.</li>
 * <li>{@code g} &ndash; a {@code VkComponentSwizzle} specifying the component value placed in the G component of the output vector.</li>
 * <li>{@code b} &ndash; a {@code VkComponentSwizzle} specifying the component value placed in the B component of the output vector.</li>
 * <li>{@code a} &ndash; a {@code VkComponentSwizzle} specifying the component value placed in the A component of the output vector.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkComponentMapping {
 *     VkComponentSwizzle r;
 *     VkComponentSwizzle g;
 *     VkComponentSwizzle b;
 *     VkComponentSwizzle a;
 * }</code></pre>
 */
class ComponentMapping(
    var r: VkComponentSwizzle = VkComponentSwizzle.R,
    var g: VkComponentSwizzle = VkComponentSwizzle.G,
    var b: VkComponentSwizzle = VkComponentSwizzle.B,
    var a: VkComponentSwizzle = VkComponentSwizzle.A
) {

    infix fun write(adr: Adr) {
        nr(adr, r.i)
        ng(adr, g.i)
        nb(adr, b.i)
        na(adr, a.i)
    }
}