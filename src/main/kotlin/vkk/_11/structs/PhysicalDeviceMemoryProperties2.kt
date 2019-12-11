package vkk._11.structs

import kool.Adr
import kool.BytePtr
import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.vulkan.VkFormatProperties
import org.lwjgl.vulkan.VkPhysicalDeviceMemoryProperties2
import org.lwjgl.vulkan.VkPhysicalDeviceMemoryProperties2.*
import vkk.VkStructureType
import vkk._10.structs.FormatProperties
import vkk._10.structs.PhysicalDeviceMemoryProperties
import vkk.stak

/**
 * Structure specifying physical device memory properties.
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_MEMORY_PROPERTIES_2 STRUCTURE_TYPE_PHYSICAL_DEVICE_MEMORY_PROPERTIES_2}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL} or a pointer to a valid instance of {@link VkPhysicalDeviceMemoryBudgetPropertiesEXT}</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkPhysicalDeviceMemoryProperties}, {@link VK11#vkGetPhysicalDeviceMemoryProperties2 GetPhysicalDeviceMemoryProperties2}, {@link KHRGetPhysicalDeviceProperties2#vkGetPhysicalDeviceMemoryProperties2KHR GetPhysicalDeviceMemoryProperties2KHR}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code memoryProperties} &ndash; a structure of type {@link VkPhysicalDeviceMemoryProperties} which is populated with the same values as in {@link VK10#vkGetPhysicalDeviceMemoryProperties GetPhysicalDeviceMemoryProperties}.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPhysicalDeviceMemoryProperties2 {
 *     VkStructureType sType;
 *     void * pNext;
 *     {@link VkPhysicalDeviceMemoryProperties VkPhysicalDeviceMemoryProperties} memoryProperties;
 * }</code></pre>
 */
class PhysicalDeviceMemoryProperties2(
    var memoryProperties: PhysicalDeviceMemoryProperties,
    var next: Ptr = NULL
) {

    val type get() = VkStructureType.PHYSICAL_DEVICE_MEMORY_PROPERTIES_2

    constructor(ptr: BytePtr): this(
            PhysicalDeviceMemoryProperties(ptr + MEMORYPROPERTIES),
            npNext(ptr.adr)
    )

    companion object {
//        inline infix fun <R> read(block: (Adr) -> R): PhysicalDeviceMemoryProperties2 = stak { read(it, block) }
        inline fun <R> read(stack: MemoryStack, block: (Adr) -> R): PhysicalDeviceMemoryProperties2 {
            val adr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
            block(adr)
            return PhysicalDeviceMemoryProperties2(BytePtr(adr))
        }
    }
}