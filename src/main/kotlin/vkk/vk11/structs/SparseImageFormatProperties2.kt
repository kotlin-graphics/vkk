package vkk.vk11.structs

import kool.BytePtr
import kool.Ptr
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.vulkan.VkSparseImageFormatProperties2.PROPERTIES
import org.lwjgl.vulkan.VkSparseImageFormatProperties2.npNext
import vkk.VkStructureType
import vkk.vk10.structs.SparseImageFormatProperties

/**
 * Structure specifying sparse image format properties.
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_SPARSE_IMAGE_FORMAT_PROPERTIES_2 STRUCTURE_TYPE_SPARSE_IMAGE_FORMAT_PROPERTIES_2}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL}</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkSparseImageFormatProperties}, {@link VK11#vkGetPhysicalDeviceSparseImageFormatProperties2 GetPhysicalDeviceSparseImageFormatProperties2}, {@link KHRGetPhysicalDeviceProperties2#vkGetPhysicalDeviceSparseImageFormatProperties2KHR GetPhysicalDeviceSparseImageFormatProperties2KHR}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code properties} &ndash; a structure of type {@link VkSparseImageFormatProperties} which is populated with the same values as in {@link VK10#vkGetPhysicalDeviceSparseImageFormatProperties GetPhysicalDeviceSparseImageFormatProperties}.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkSparseImageFormatProperties2 {
 *     VkStructureType sType;
 *     void * pNext;
 *     {@link VkSparseImageFormatProperties VkSparseImageFormatProperties} properties;
 * }</code></pre>
 */
class SparseImageFormatProperties2(
        var properties: SparseImageFormatProperties,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.SPARSE_IMAGE_FORMAT_PROPERTIES_2

    constructor(ptr: BytePtr) : this(
            SparseImageFormatProperties(ptr + PROPERTIES),
            npNext(ptr.adr)
    )
}