package vkk.vk10.structs

import kool.*
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.system.MemoryUtil.memPutAddress
import org.lwjgl.vulkan.VkBufferCreateInfo.*
import vkk.*
import vkk.entities.VkDeviceSize

/**
 * Structure specifying the parameters of a newly created buffer object.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code size} <b>must</b> be greater than 0</li>
 * <li>If {@code sharingMode} is {@link VK10#VK_SHARING_MODE_CONCURRENT SHARING_MODE_CONCURRENT}, {@code pQueueFamilyIndices} <b>must</b> be a valid pointer to an array of {@code queueFamilyIndexCount} {@code uint32_t} values</li>
 * <li>If {@code sharingMode} is {@link VK10#VK_SHARING_MODE_CONCURRENT SHARING_MODE_CONCURRENT}, {@code queueFamilyIndexCount} <b>must</b> be greater than 1</li>
 * <li>If {@code sharingMode} is {@link VK10#VK_SHARING_MODE_CONCURRENT SHARING_MODE_CONCURRENT}, each element of {@code pQueueFamilyIndices} <b>must</b> be unique and <b>must</b> be less than {@code pQueueFamilyPropertyCount} returned by either {@link VK10#vkGetPhysicalDeviceQueueFamilyProperties GetPhysicalDeviceQueueFamilyProperties} or {@link VK11#vkGetPhysicalDeviceQueueFamilyProperties2 GetPhysicalDeviceQueueFamilyProperties2} for the {@code physicalDevice} that was used to create {@code device}</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-sparseBinding">sparse bindings</a> feature is not enabled, {@code flags} <b>must</b> not contain {@link VK10#VK_BUFFER_CREATE_SPARSE_BINDING_BIT BUFFER_CREATE_SPARSE_BINDING_BIT}</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-sparseResidencyBuffer">sparse buffer residency</a> feature is not enabled, {@code flags} <b>must</b> not contain {@link VK10#VK_BUFFER_CREATE_SPARSE_RESIDENCY_BIT BUFFER_CREATE_SPARSE_RESIDENCY_BIT}</li>
 * <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-sparseResidencyAliased">sparse aliased residency</a> feature is not enabled, {@code flags} <b>must</b> not contain {@link VK10#VK_BUFFER_CREATE_SPARSE_ALIASED_BIT BUFFER_CREATE_SPARSE_ALIASED_BIT}</li>
 * <li>If {@code flags} contains {@link VK10#VK_BUFFER_CREATE_SPARSE_RESIDENCY_BIT BUFFER_CREATE_SPARSE_RESIDENCY_BIT} or {@link VK10#VK_BUFFER_CREATE_SPARSE_ALIASED_BIT BUFFER_CREATE_SPARSE_ALIASED_BIT}, it <b>must</b> also contain {@link VK10#VK_BUFFER_CREATE_SPARSE_BINDING_BIT BUFFER_CREATE_SPARSE_BINDING_BIT}</li>
 * <li>If the {@code pNext} chain contains an instance of {@link VkExternalMemoryBufferCreateInfo}, its {@code handleTypes} member <b>must</b> only contain bits that are also in {@link VkExternalBufferProperties}{@code ::externalMemoryProperties}.compatibleHandleTypes, as returned by {@link VK11#vkGetPhysicalDeviceExternalBufferProperties GetPhysicalDeviceExternalBufferProperties} with {@code pExternalBufferInfo}-&gt;{@code handleType} equal to any one of the handle types specified in {@link VkExternalMemoryBufferCreateInfo}{@code ::handleTypes}</li>
 * <li>If the protected memory feature is not enabled, {@code flags} <b>must</b> not contain {@link VK11#VK_BUFFER_CREATE_PROTECTED_BIT BUFFER_CREATE_PROTECTED_BIT}</li>
 * <li>If any of the bits {@link VK10#VK_BUFFER_CREATE_SPARSE_BINDING_BIT BUFFER_CREATE_SPARSE_BINDING_BIT}, {@link VK10#VK_BUFFER_CREATE_SPARSE_RESIDENCY_BIT BUFFER_CREATE_SPARSE_RESIDENCY_BIT}, or {@link VK10#VK_BUFFER_CREATE_SPARSE_ALIASED_BIT BUFFER_CREATE_SPARSE_ALIASED_BIT} are set, {@link VK11#VK_BUFFER_CREATE_PROTECTED_BIT BUFFER_CREATE_PROTECTED_BIT} <b>must</b> not also be set</li>
 * <li>If the {@code pNext} chain contains an instance of {@link VkDedicatedAllocationBufferCreateInfoNV}, and the {@code dedicatedAllocation} member of the chained structure is {@link VK10#VK_TRUE TRUE}, then {@code flags} <b>must</b> not include {@link VK10#VK_BUFFER_CREATE_SPARSE_BINDING_BIT BUFFER_CREATE_SPARSE_BINDING_BIT}, {@link VK10#VK_BUFFER_CREATE_SPARSE_RESIDENCY_BIT BUFFER_CREATE_SPARSE_RESIDENCY_BIT}, or {@link VK10#VK_BUFFER_CREATE_SPARSE_ALIASED_BIT BUFFER_CREATE_SPARSE_ALIASED_BIT}</li>
 * <li>If {@link VkBufferDeviceAddressCreateInfoEXT}{@code ::deviceAddress} is not zero, {@code flags} <b>must</b> include {@link EXTBufferDeviceAddress#VK_BUFFER_CREATE_DEVICE_ADDRESS_CAPTURE_REPLAY_BIT_EXT BUFFER_CREATE_DEVICE_ADDRESS_CAPTURE_REPLAY_BIT_EXT}</li>
 * <li>If {@code flags} includes {@link EXTBufferDeviceAddress#VK_BUFFER_CREATE_DEVICE_ADDRESS_CAPTURE_REPLAY_BIT_EXT BUFFER_CREATE_DEVICE_ADDRESS_CAPTURE_REPLAY_BIT_EXT}, the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-bufferDeviceAddressCaptureReplay">bufferDeviceAddressCaptureReplay</a> feature <b>must</b> be enabled</li>
 * <li>If {@code usage} includes {@link EXTBufferDeviceAddress#VK_BUFFER_USAGE_SHADER_DEVICE_ADDRESS_BIT_EXT BUFFER_USAGE_SHADER_DEVICE_ADDRESS_BIT_EXT}, the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-bufferDeviceAddress">bufferDeviceAddress</a> feature <b>must</b> be enabled</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK10#VK_STRUCTURE_TYPE_BUFFER_CREATE_INFO STRUCTURE_TYPE_BUFFER_CREATE_INFO}</li>
 * <li>Each {@code pNext} member of any structure (including this one) in the {@code pNext} chain <b>must</b> be either {@code NULL} or a pointer to a valid instance of {@link VkBufferDeviceAddressCreateInfoEXT}, {@link VkDedicatedAllocationBufferCreateInfoNV}, or {@link VkExternalMemoryBufferCreateInfo}</li>
 * <li>Each {@code sType} member in the {@code pNext} chain <b>must</b> be unique</li>
 * <li>{@code flags} <b>must</b> be a valid combination of {@code VkBufferCreateFlagBits} values</li>
 * <li>{@code usage} <b>must</b> be a valid combination of {@code VkBufferUsageFlagBits} values</li>
 * <li>{@code usage} <b>must</b> not be 0</li>
 * <li>{@code sharingMode} <b>must</b> be a valid {@code VkSharingMode} value</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VK10#vkCreateBuffer CreateBuffer}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code flags} &ndash; a bitmask of {@code VkBufferCreateFlagBits} specifying additional parameters of the buffer.</li>
 * <li>{@code size} &ndash; the size in bytes of the buffer to be created.</li>
 * <li>{@code usage} &ndash; a bitmask of {@code VkBufferUsageFlagBits} specifying allowed usages of the buffer.</li>
 * <li>{@code sharingMode} &ndash; a {@code VkSharingMode} value specifying the sharing mode of the buffer when it will be accessed by multiple queue families.</li>
 * <li>{@code queueFamilyIndexCount} &ndash; the number of entries in the {@code pQueueFamilyIndices} array.</li>
 * <li>{@code pQueueFamilyIndices} &ndash; a list of queue families that will access this buffer (ignored if {@code sharingMode} is not {@link VK10#VK_SHARING_MODE_CONCURRENT SHARING_MODE_CONCURRENT}).</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkBufferCreateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkBufferCreateFlags flags;
 *     VkDeviceSize size;
 *     VkBufferUsageFlags usage;
 *     VkSharingMode sharingMode;
 *     uint32_t queueFamilyIndexCount;
 *     uint32_t const * pQueueFamilyIndices;
 * }</code></pre>
 */
class BufferCreateInfo(
        var flags: VkBufferCreateFlags = 0,
        var size: VkDeviceSize,
        var usageFlags: VkBufferUsageFlags = 0,
        var sharingMode: VkSharingMode = VkSharingMode.EXCLUSIVE,
        var queueFamilyIndices: IntArray? = null,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.BUFFER_CREATE_INFO

    infix fun write(stack: VkStack): Adr {
        val adr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
        nsType(adr, type.i)
        npNext(adr, next)
        nflags(adr, flags)
        nsize(adr, size.L)
        nusage(adr, usageFlags)
        nsharingMode(adr, sharingMode.i)
        queueFamilyIndices?.let {
            nqueueFamilyIndexCount(adr, it.size)
            memPutAddress(adr + PQUEUEFAMILYINDICES, stack.IntAdr(it).adr)
        }
        return adr
    }
}