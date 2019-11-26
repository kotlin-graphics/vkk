package classes

import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.vulkan.VkMemoryAllocateInfo
import org.lwjgl.vulkan.VkMemoryAllocateInfo.*
import vkk.VkStructureType
import vkk.entities.VkDeviceSize

/**
 * Structure containing parameters of a memory allocation.
 *
 * <h5>Description</h5>
 *
 * <p>An instance of the {@link VkMemoryAllocateInfo} structure defines a memory import operation if the {@code pNext} chain contains an instance of one of the following structures:</p>
 *
 * <ul>
 * <li>{@link VkImportMemoryWin32HandleInfoKHR} with non-zero {@code handleType} value</li>
 * <li>{@link VkImportMemoryFdInfoKHR} with a non-zero {@code handleType} value</li>
 * <li>{@link VkImportMemoryHostPointerInfoEXT} with a non-zero {@code handleType} value</li>
 * </ul>
 *
 * <p>Importing memory <b>must</b> not modify the content of the memory. Implementations <b>must</b> ensure that importing memory does not enable the importing Vulkan instance to access any memory or resources in other Vulkan instances other than that corresponding to the memory object imported. Implementations <b>must</b> also ensure accessing imported memory which has not been initialized does not allow the importing Vulkan instance to obtain data from the exporting Vulkan instance or vice-versa.</p>
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>How exported and imported memory is isolated is left to the implementation, but applications should be aware that such isolation <b>may</b> prevent implementations from placing multiple exportable memory objects in the same physical or virtual page. Hence, applications <b>should</b> avoid creating many small external memory objects whenever possible.</p>
 * </div>
 *
 * <p>When performing a memory import operation, it is the responsibility of the application to ensure the external handles meet all valid usage requirements. However, implementations <b>must</b> perform sufficient validation of external handles to ensure that the operation results in a valid memory object which will not cause program termination, device loss, queue stalls, or corruption of other resources when used as allowed according to its allocation parameters. If the external handle provided does not meet these requirements, the implementation <b>must</b> fail the memory import operation with the error code {@link VK11#VK_ERROR_INVALID_EXTERNAL_HANDLE ERROR_INVALID_EXTERNAL_HANDLE}.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code allocationSize} <b>must</b> be greater than 0</li>
 * <li>If the {@code pNext} chain contains an instance of {@link VkExportMemoryAllocateInfo}, and any of the handle types specified in {@link VkExportMemoryAllocateInfo}{@code ::handleTypes} require a dedicated allocation, as reported by {@link VK11#vkGetPhysicalDeviceImageFormatProperties2 GetPhysicalDeviceImageFormatProperties2} in {@link VkExternalImageFormatProperties}{@code ::externalMemoryProperties}{@code ::externalMemoryFeatures} or {@link VkExternalBufferProperties}{@code ::externalMemoryProperties}{@code ::externalMemoryFeatures}, the {@code pNext} chain must contain an instance of {@link VkMemoryDedicatedAllocateInfo} or {@link VkDedicatedAllocationMemoryAllocateInfoNV} with either its {@code image} or {@code buffer} field set to a value other than {@link VK10#VK_NULL_HANDLE NULL_HANDLE}.</li>
 * <li>If the {@code pNext} chain contains an instance of {@link VkExportMemoryAllocateInfo}, it <b>must</b> not contain an instance of {@link VkExportMemoryAllocateInfoNV} or {@link VkExportMemoryWin32HandleInfoNV}.</li>
 * <li>If the {@code pNext} chain contains an instance of {@link VkImportMemoryWin32HandleInfoKHR}, it <b>must</b> not contain an instance of {@link VkImportMemoryWin32HandleInfoNV}.</li>
 * <li>If the parameters define an import operation, the external handle specified was created by the Vulkan API, and the external handle type is {@link KHRExternalMemoryCapabilities#VK_EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_FD_BIT_KHR EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_FD_BIT_KHR}, then the values of {@code allocationSize} and {@code memoryTypeIndex} <b>must</b> match those specified when the memory object being imported was created.</li>
 * <li>If the parameters define an import operation and the external handle specified was created by the Vulkan API, the device mask specified by {@link VkMemoryAllocateFlagsInfo} <b>must</b> match that specified when the memory object being imported was allocated.</li>
 * <li>If the parameters define an import operation and the external handle specified was created by the Vulkan API, the list of physical devices that comprise the logical device passed to {@link VK10#vkAllocateMemory AllocateMemory} <b>must</b> match the list of physical devices that comprise the logical device on which the memory was originally allocated.</li>
 * <li>If the parameters define an import operation and the external handle is an NT handle or a global share handle created outside of the Vulkan API, the value of {@code memoryTypeIndex} <b>must</b> be one of those returned by {@link KHRExternalMemoryWin32#vkGetMemoryWin32HandlePropertiesKHR GetMemoryWin32HandlePropertiesKHR}.</li>
 * <li>If the parameters define an import operation, the external handle was created by the Vulkan API, and the external handle type is {@link KHRExternalMemoryCapabilities#VK_EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_WIN32_BIT_KHR EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_WIN32_BIT_KHR} or {@link KHRExternalMemoryCapabilities#VK_EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_WIN32_KMT_BIT_KHR EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_WIN32_KMT_BIT_KHR}, then the values of {@code allocationSize} and {@code memoryTypeIndex} <b>must</b> match those specified when the memory object being imported was created.</li>
 * <li>If the parameters define an import operation and the external handle type is {@link VK11#VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D11_TEXTURE_BIT EXTERNAL_MEMORY_HANDLE_TYPE_D3D11_TEXTURE_BIT}, {@link VK11#VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D11_TEXTURE_KMT_BIT EXTERNAL_MEMORY_HANDLE_TYPE_D3D11_TEXTURE_KMT_BIT}, or {@link VK11#VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D12_RESOURCE_BIT EXTERNAL_MEMORY_HANDLE_TYPE_D3D12_RESOURCE_BIT}, {@code allocationSize} <b>must</b> match the size reported in the memory requirements of the {@code image} or {@code buffer} member of the instance of {@link VkDedicatedAllocationMemoryAllocateInfoNV} included in the {@code pNext} chain.</li>
 * <li>If the parameters define an import operation and the external handle type is {@link VK11#VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D12_HEAP_BIT EXTERNAL_MEMORY_HANDLE_TYPE_D3D12_HEAP_BIT}, {@code allocationSize} <b>must</b> match the size specified when creating the Direct3D 12 heap from which the external handle was extracted.</li>
 * <li>If the parameters define an import operation and the external handle is a POSIX file descriptor created outside of the Vulkan API, the value of {@code memoryTypeIndex} <b>must</b> be one of those returned by {@link KHRExternalMemoryFd#vkGetMemoryFdPropertiesKHR GetMemoryFdPropertiesKHR}.</li>
 * <li>If the protected memory feature is not enabled, the {@link VkMemoryAllocateInfo}{@code ::memoryTypeIndex} <b>must</b> not indicate a memory type that reports {@link VK11#VK_MEMORY_PROPERTY_PROTECTED_BIT MEMORY_PROPERTY_PROTECTED_BIT}.</li>
 * <li>If the parameters define an import operation and the external handle is a host pointer, the value of {@code memoryTypeIndex} <b>must</b> be one of those returned by {@link EXTExternalMemoryHost#vkGetMemoryHostPointerPropertiesEXT GetMemoryHostPointerPropertiesEXT}</li>
 * <li>If the parameters define an import operation and the external handle is a host pointer, {@code allocationSize} <b>must</b> be an integer multiple of {@link VkPhysicalDeviceExternalMemoryHostPropertiesEXT}{@code ::minImportedHostPointerAlignment}</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK10#VK_STRUCTURE_TYPE_MEMORY_ALLOCATE_INFO STRUCTURE_TYPE_MEMORY_ALLOCATE_INFO}</li>
 * <li>Each {@code pNext} member of any structure (including this one) in the {@code pNext} chain <b>must</b> be either {@code NULL} or a pointer to a valid instance of {@link VkDedicatedAllocationMemoryAllocateInfoNV}, {@link VkExportMemoryAllocateInfo}, {@link VkExportMemoryAllocateInfoNV}, {@link VkExportMemoryWin32HandleInfoKHR}, {@link VkExportMemoryWin32HandleInfoNV}, {@link VkImportMemoryFdInfoKHR}, {@link VkImportMemoryHostPointerInfoEXT}, {@link VkImportMemoryWin32HandleInfoKHR}, {@link VkImportMemoryWin32HandleInfoNV}, {@link VkMemoryAllocateFlagsInfo}, {@link VkMemoryDedicatedAllocateInfo}, or {@link VkMemoryPriorityAllocateInfoEXT}</li>
 * <li>Each {@code sType} member in the {@code pNext} chain <b>must</b> be unique</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VK10#vkAllocateMemory AllocateMemory}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code allocationSize} &ndash; the size of the allocation in bytes</li>
 * <li>{@code memoryTypeIndex} &ndash; an index identifying a memory type from the {@code memoryTypes} array of the {@link VkPhysicalDeviceMemoryProperties} structure</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkMemoryAllocateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkDeviceSize allocationSize;
 *     uint32_t memoryTypeIndex;
 * }</code></pre>
 */
class MemoryAllocateInfo(
    var allocationSize: VkDeviceSize = VkDeviceSize.NULL,
    var memoryTypeIndex: Int = 0,
    var next: Ptr = NULL
) {

    val type get() = VkStructureType.MEMORY_ALLOCATE_INFO

    val MemoryStack.native: Ptr
        get() = ncalloc(ALIGNOF, 1, SIZEOF).also { toPtr(it) }

    infix fun MemoryStack.toPtr(ptr: Ptr) {
        nsType(ptr, type.i)
        npNext(ptr, next)
        nallocationSize(ptr, allocationSize.L)
        nmemoryTypeIndex(ptr, memoryTypeIndex)
    }
}