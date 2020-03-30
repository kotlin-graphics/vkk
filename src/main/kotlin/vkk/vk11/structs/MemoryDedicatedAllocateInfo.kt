package vkk.vk11.structs

import kool.Ptr
import org.lwjgl.system.MemoryUtil.NULL
import vkk.VkStructureType
import vkk.entities.VkBuffer
import vkk.entities.VkImage

/**
 * Specify a dedicated memory allocation resource.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>At least one of {@code image} and {@code buffer} <b>must</b> be {@link VK10#VK_NULL_HANDLE NULL_HANDLE}</li>
 * <li>If {@code image} is not {@link VK10#VK_NULL_HANDLE NULL_HANDLE}, {@link VkMemoryAllocateInfo}{@code ::allocationSize} <b>must</b> equal the {@link VkMemoryRequirements}{@code ::size} of the image</li>
 * <li>If {@code image} is not {@link VK10#VK_NULL_HANDLE NULL_HANDLE}, {@code image} <b>must</b> have been created without {@link VK10#VK_IMAGE_CREATE_SPARSE_BINDING_BIT IMAGE_CREATE_SPARSE_BINDING_BIT} set in {@link VkImageCreateInfo}{@code ::flags}</li>
 * <li>If {@code buffer} is not {@link VK10#VK_NULL_HANDLE NULL_HANDLE}, {@link VkMemoryAllocateInfo}{@code ::allocationSize} <b>must</b> equal the {@link VkMemoryRequirements}{@code ::size} of the buffer</li>
 * <li>If {@code buffer} is not {@link VK10#VK_NULL_HANDLE NULL_HANDLE}, {@code buffer} <b>must</b> have been created without {@link VK10#VK_BUFFER_CREATE_SPARSE_BINDING_BIT BUFFER_CREATE_SPARSE_BINDING_BIT} set in {@link VkBufferCreateInfo}{@code ::flags}</li>
 * <li>If {@code image} is not {@link VK10#VK_NULL_HANDLE NULL_HANDLE} and {@link VkMemoryAllocateInfo} defines a memory import operation with handle type {@link VK11#VK_EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_WIN32_BIT EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_WIN32_BIT}, {@link VK11#VK_EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_WIN32_KMT_BIT EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_WIN32_KMT_BIT}, {@link VK11#VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D11_TEXTURE_BIT EXTERNAL_MEMORY_HANDLE_TYPE_D3D11_TEXTURE_BIT}, {@link VK11#VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D11_TEXTURE_KMT_BIT EXTERNAL_MEMORY_HANDLE_TYPE_D3D11_TEXTURE_KMT_BIT}, {@link VK11#VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D12_HEAP_BIT EXTERNAL_MEMORY_HANDLE_TYPE_D3D12_HEAP_BIT}, or {@link VK11#VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D12_RESOURCE_BIT EXTERNAL_MEMORY_HANDLE_TYPE_D3D12_RESOURCE_BIT}, and the external handle was created by the Vulkan API, then the memory being imported <b>must</b> also be a dedicated image allocation and {@code image} must be identical to the image associated with the imported memory.</li>
 * <li>If {@code buffer} is not {@link VK10#VK_NULL_HANDLE NULL_HANDLE} and {@link VkMemoryAllocateInfo} defines a memory import operation with handle type {@link VK11#VK_EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_WIN32_BIT EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_WIN32_BIT}, {@link VK11#VK_EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_WIN32_KMT_BIT EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_WIN32_KMT_BIT}, {@link VK11#VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D11_TEXTURE_BIT EXTERNAL_MEMORY_HANDLE_TYPE_D3D11_TEXTURE_BIT}, {@link VK11#VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D11_TEXTURE_KMT_BIT EXTERNAL_MEMORY_HANDLE_TYPE_D3D11_TEXTURE_KMT_BIT}, {@link VK11#VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D12_HEAP_BIT EXTERNAL_MEMORY_HANDLE_TYPE_D3D12_HEAP_BIT}, or {@link VK11#VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D12_RESOURCE_BIT EXTERNAL_MEMORY_HANDLE_TYPE_D3D12_RESOURCE_BIT}, and the external handle was created by the Vulkan API, then the memory being imported <b>must</b> also be a dedicated buffer allocation and {@code buffer} must be identical to the buffer associated with the imported memory.</li>
 * <li>If {@code image} is not {@link VK10#VK_NULL_HANDLE NULL_HANDLE} and {@link VkMemoryAllocateInfo} defines a memory import operation with handle type {@link VK11#VK_EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_FD_BIT EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_FD_BIT}, the memory being imported <b>must</b> also be a dedicated image allocation and {@code image} must be identical to the image associated with the imported memory.</li>
 * <li>If {@code buffer} is not {@link VK10#VK_NULL_HANDLE NULL_HANDLE} and {@link VkMemoryAllocateInfo} defines a memory import operation with handle type {@link VK11#VK_EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_FD_BIT EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_FD_BIT}, the memory being imported <b>must</b> also be a dedicated buffer allocation and {@code buffer} must be identical to the buffer associated with the imported memory.</li>
 * <li>If {@code image} is not {@link VK10#VK_NULL_HANDLE NULL_HANDLE}, {@code image} <b>must</b> not have been created with {@link VK11#VK_IMAGE_CREATE_DISJOINT_BIT IMAGE_CREATE_DISJOINT_BIT} set in {@link VkImageCreateInfo}{@code ::flags}</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_MEMORY_DEDICATED_ALLOCATE_INFO STRUCTURE_TYPE_MEMORY_DEDICATED_ALLOCATE_INFO}</li>
 * <li>If {@code image} is not {@link VK10#VK_NULL_HANDLE NULL_HANDLE}, {@code image} <b>must</b> be a valid {@code VkImage} handle</li>
 * <li>If {@code buffer} is not {@link VK10#VK_NULL_HANDLE NULL_HANDLE}, {@code buffer} <b>must</b> be a valid {@code VkBuffer} handle</li>
 * <li>Both of {@code buffer}, and {@code image} that are valid handles <b>must</b> have been created, allocated, or retrieved from the same {@code VkDevice}</li>
 * </ul>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code image} &ndash; {@link VK10#VK_NULL_HANDLE NULL_HANDLE} or a handle of an image which this memory will be bound to.</li>
 * <li>{@code buffer} &ndash; {@link VK10#VK_NULL_HANDLE NULL_HANDLE} or a handle of a buffer which this memory will be bound to.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkMemoryDedicatedAllocateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkImage image;
 *     VkBuffer buffer;
 * }</code></pre>
 */
class MemoryDedicatedAllocateInfo(
        var image: VkImage = VkImage.NULL,
        var buffer: VkBuffer = VkBuffer.NULL,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.MEMORY_DEDICATED_ALLOCATE_INFO
}