package vkk._11.structs

import kool.Ptr
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.NULL
import vkk.VkStructureType

/**
 * Structure describing dedicated allocation requirements of buffer and image resources.
 *
 * <h5>Description</h5>
 *
 * <p>When the implementation sets {@code requiresDedicatedAllocation} to {@link VK10#VK_TRUE TRUE}, it <b>must</b> also set {@code prefersDedicatedAllocation} to {@link VK10#VK_TRUE TRUE}.</p>
 *
 * <p>If the {@link VkMemoryDedicatedRequirements} structure is included in the {@code pNext} chain of the {@link VkMemoryRequirements2} structure passed as the {@code pMemoryRequirements} parameter of a {@code vkGetBufferMemoryRequirements2} call, {@code requiresDedicatedAllocation} <b>may</b> be {@link VK10#VK_TRUE TRUE} under one of the following conditions:</p>
 *
 * <ul>
 * <li>The {@code pNext} chain of {@link VkBufferCreateInfo} for the call to {@code vkCreateBuffer} used to create the buffer being queried contained an instance of {@link VkExternalMemoryBufferCreateInfo}, and any of the handle types specified in {@link VkExternalMemoryBufferCreateInfo}{@code ::handleTypes} requires dedicated allocation, as reported by {@link VK11#vkGetPhysicalDeviceExternalBufferProperties GetPhysicalDeviceExternalBufferProperties} in {@link VkExternalBufferProperties}{@code ::externalMemoryProperties}{@code ::externalMemoryFeatures}, the {@code requiresDedicatedAllocation} field will be set to {@link VK10#VK_TRUE TRUE}.</li>
 * </ul>
 *
 * <p>In all other cases, {@code requiresDedicatedAllocation} <b>must</b> be set to {@link VK10#VK_FALSE FALSE} by the implementation whenever a {@link VkMemoryDedicatedRequirements} structure is included in the {@code pNext} chain of the {@link VkMemoryRequirements2} structure passed to a call to {@code vkGetBufferMemoryRequirements2}.</p>
 *
 * <p>If the {@link VkMemoryDedicatedRequirements} structure is included in the {@code pNext} chain of the {@link VkMemoryRequirements2} structure passed as the {@code pMemoryRequirements} parameter of a {@code vkGetBufferMemoryRequirements2} call and {@link VK10#VK_BUFFER_CREATE_SPARSE_BINDING_BIT BUFFER_CREATE_SPARSE_BINDING_BIT} was set in {@link VkBufferCreateInfo}{@code ::flags} when {@code buffer} was created then the implementation <b>must</b> set both {@code prefersDedicatedAllocation} and {@code requiresDedicatedAllocation} to {@link VK10#VK_FALSE FALSE}.</p>
 *
 * <p>If the {@link VkMemoryDedicatedRequirements} structure is included in the {@code pNext} chain of the {@link VkMemoryRequirements2} structure passed as the {@code pMemoryRequirements} parameter of a {@code vkGetImageMemoryRequirements2} call, {@code requiresDedicatedAllocation} <b>may</b> be {@link VK10#VK_TRUE TRUE} under one of the following conditions:</p>
 *
 * <ul>
 * <li>The {@code pNext} chain of {@link VkImageCreateInfo} for the call to {@code vkCreateImage} used to create the image being queried contained an instance of {@link VkExternalMemoryImageCreateInfo}, and any of the handle types specified in {@link VkExternalMemoryImageCreateInfo}{@code ::handleTypes} requires dedicated allocation, as reported by {@link VK11#vkGetPhysicalDeviceImageFormatProperties2 GetPhysicalDeviceImageFormatProperties2} in {@link VkExternalImageFormatProperties}{@code ::externalMemoryProperties}{@code ::externalMemoryFeatures}, the {@code requiresDedicatedAllocation} field will be set to {@link VK10#VK_TRUE TRUE}.</li>
 * </ul>
 *
 * <p>In all other cases, {@code requiresDedicatedAllocation} <b>must</b> be set to {@link VK10#VK_FALSE FALSE} by the implementation whenever a {@link VkMemoryDedicatedRequirements} structure is included in the {@code pNext} chain of the {@link VkMemoryRequirements2} structure passed to a call to {@code vkGetImageMemoryRequirements2}.</p>
 *
 * <p>If the {@link VkMemoryDedicatedRequirements} structure is included in the {@code pNext} chain of the {@link VkMemoryRequirements2} structure passed as the {@code pMemoryRequirements} parameter of a {@code vkGetImageMemoryRequirements2} call and {@link VK10#VK_IMAGE_CREATE_SPARSE_BINDING_BIT IMAGE_CREATE_SPARSE_BINDING_BIT} was set in {@link VkImageCreateInfo}{@code ::flags} when {@code image} was created then the implementation <b>must</b> set both {@code prefersDedicatedAllocation} and {@code requiresDedicatedAllocation} to {@link VK10#VK_FALSE FALSE}.</p>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_MEMORY_DEDICATED_REQUIREMENTS STRUCTURE_TYPE_MEMORY_DEDICATED_REQUIREMENTS}</li>
 * </ul>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code prefersDedicatedAllocation} &ndash; specifies that the implementation would prefer a dedicated allocation for this resource. The application is still free to suballocate the resource but it <b>may</b> get better performance if a dedicated allocation is used.</li>
 * <li>{@code requiresDedicatedAllocation} &ndash; specifies that a dedicated allocation is required for this resource.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkMemoryDedicatedRequirements {
 *     VkStructureType sType;
 *     void * pNext;
 *     VkBool32 prefersDedicatedAllocation;
 *     VkBool32 requiresDedicatedAllocation;
 * }</code></pre>
 */
class MemoryDedicatedRequirements(
        var prefersDedicatedAllocation: Boolean,
        var requiresDedicatedAllocation: Boolean,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.MEMORY_DEDICATED_REQUIREMENTS
}