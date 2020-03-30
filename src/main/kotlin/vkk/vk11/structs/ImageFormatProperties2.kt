package vkk.vk11.structs

import kool.Adr
import kool.BytePtr
import kool.Ptr
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.vulkan.VkImageFormatProperties2.*
import vkk.VkStack
import vkk.VkStructureType
import vkk.vk10.structs.ImageFormatProperties

/**
 * Structure specifying an image format properties.
 *
 * <h5>Description</h5>
 *
 * <p>If the combination of parameters to {@code vkGetPhysicalDeviceImageFormatProperties2} is not supported by the implementation for use in {@link VK10#vkCreateImage CreateImage}, then all members of {@code imageFormatProperties} will be filled with zero.</p>
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>Filling {@code imageFormatProperties} with zero for unsupported formats is an exception to the usual rule that output structures have undefined contents on error. This exception was unintentional, but is preserved for backwards compatibility. This exeption only applies to {@code imageFormatProperties}, not {@code sType}, {@code pNext}, or any structures chained from {@code pNext}.</p>
 * </div>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_IMAGE_FORMAT_PROPERTIES_2 STRUCTURE_TYPE_IMAGE_FORMAT_PROPERTIES_2}</li>
 * <li>Each {@code pNext} member of any structure (including this one) in the {@code pNext} chain <b>must</b> be either {@code NULL} or a pointer to a valid instance of {@link VkExternalImageFormatProperties}, {@link VkFilterCubicImageViewImageFormatPropertiesEXT}, {@link VkSamplerYcbcrConversionImageFormatProperties}, or {@link VkTextureLODGatherFormatPropertiesAMD}</li>
 * <li>Each {@code sType} member in the {@code pNext} chain <b>must</b> be unique</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkImageFormatProperties}, {@link VK11#vkGetPhysicalDeviceImageFormatProperties2 GetPhysicalDeviceImageFormatProperties2}, {@link KHRGetPhysicalDeviceProperties2#vkGetPhysicalDeviceImageFormatProperties2KHR GetPhysicalDeviceImageFormatProperties2KHR}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure. The {@code pNext} chain of {@link VkImageFormatProperties2} is used to allow the specification of additional capabilities to be returned from {@code vkGetPhysicalDeviceImageFormatProperties2}.</li>
 * <li>{@code imageFormatProperties} &ndash; an instance of a {@link VkImageFormatProperties} structure in which capabilities are returned.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkImageFormatProperties2 {
 *     VkStructureType sType;
 *     void * pNext;
 *     {@link VkImageFormatProperties VkImageFormatProperties} imageFormatProperties;
 * }</code></pre>
 */
class ImageFormatProperties2(
        var imageFormatProperties: ImageFormatProperties,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.IMAGE_FORMAT_PROPERTIES_2

    constructor(ptr: BytePtr) : this(
            ImageFormatProperties(ptr + IMAGEFORMATPROPERTIES),
            npNext(ptr.adr)
    )

    companion object {
//        inline infix fun <R> read(block: (Adr) -> R): ImageFormatProperties2 = stak { read(it, block) }
        inline fun <R> read(stack: VkStack, block: (Adr) -> R): ImageFormatProperties2 {
            val adr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
            block(adr)
            return ImageFormatProperties2(BytePtr(adr))
        }
    }
}