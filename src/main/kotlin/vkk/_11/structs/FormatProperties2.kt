package vkk._11.structs

import kool.Adr
import kool.BytePtr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.vulkan.VkFormatProperties2
import org.lwjgl.vulkan.VkFormatProperties2.*
import org.lwjgl.vulkan.VkPhysicalDeviceFeatures2
import vkk.VkStructureType
import vkk._10.structs.FormatProperties
import vkk.stak

/**
 * Structure specifying image format properties.
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_FORMAT_PROPERTIES_2 STRUCTURE_TYPE_FORMAT_PROPERTIES_2}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL} or a pointer to a valid instance of {@link VkDrmFormatModifierPropertiesListEXT}</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkFormatProperties}, {@link VK11#vkGetPhysicalDeviceFormatProperties2 GetPhysicalDeviceFormatProperties2}, {@link KHRGetPhysicalDeviceProperties2#vkGetPhysicalDeviceFormatProperties2KHR GetPhysicalDeviceFormatProperties2KHR}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code formatProperties} &ndash; a structure of type {@link VkFormatProperties} describing features supported by the requested format.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkFormatProperties2 {
 *     VkStructureType sType;
 *     void * pNext;
 *     {@link VkFormatProperties VkFormatProperties} formatProperties;
 * }</code></pre>
 */
class FormatProperties2(
        var formatProperties: FormatProperties,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.FORMAT_PROPERTIES_2

    constructor(ptr: BytePtr): this(
            FormatProperties(ptr + FORMATPROPERTIES),
            npNext(ptr.adr)
    )

    companion object {
//        inline infix fun <R> read(block: (Adr) -> R): FormatProperties2 = stak { read(it, block) }
        inline fun <R> read(stack: MemoryStack, block: (Adr) -> R): FormatProperties2 {
            val adr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
            block(adr)
            return FormatProperties2(BytePtr(adr))
        }
    }
}