package vkk

import glm_.BYTES
import glm_.bool
import glm_.i
import glm_.vec2.Vec2i
import glm_.vec3.Vec3i
import glm_.vec4.Vec4
import kool.Ptr
import kool.adr
import org.lwjgl.PointerBuffer
import org.lwjgl.system.MemoryStack.stackGet
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.vulkan.*
import vkk.entities.*
import java.nio.ByteBuffer
import java.nio.FloatBuffer
import java.nio.IntBuffer
import java.nio.LongBuffer


inline class VkExternalSemaphoreHandleType(val i: Int) {
    companion object {
        val OPAQUE_FD_BIT = VkExternalSemaphoreHandleType(0x00000001)
        val OPAQUE_WIN32_BIT = VkExternalSemaphoreHandleType(0x00000002)
        val OPAQUE_WIN32_KMT_BIT = VkExternalSemaphoreHandleType(0x00000004)
        val D3D12_FENCE_BIT = VkExternalSemaphoreHandleType(0x00000008)
        val SYNC_FD_BIT = VkExternalSemaphoreHandleType(0x00000010)
        val OPAQUE_FD_BIT_KHR = VkExternalSemaphoreHandleType.OPAQUE_FD_BIT
        val OPAQUE_WIN32_BIT_KHR = VkExternalSemaphoreHandleType.OPAQUE_WIN32_BIT
        val OPAQUE_WIN32_KMT_BIT_KHR = VkExternalSemaphoreHandleType.OPAQUE_WIN32_KMT_BIT
        val D3D12_FENCE_BIT_KHR = VkExternalSemaphoreHandleType.D3D12_FENCE_BIT
        val SYNC_FD_BIT_KHR = VkExternalSemaphoreHandleType.SYNC_FD_BIT
    }
}

typealias VkExternalSemaphoreHandleTypeFlags = VkFlags

inline class VkExternalSemaphoreFeature(val i: Int) {
    companion object {
        val EXPORTABLE_BIT = VkExternalSemaphoreFeature(0x00000001)
        val IMPORTABLE_BIT = VkExternalSemaphoreFeature(0x00000002)
        val EXPORTABLE_BIT_KHR = VkExternalSemaphoreFeature.EXPORTABLE_BIT
        val IMPORTABLE_BIT_KHR = VkExternalSemaphoreFeature.IMPORTABLE_BIT
    }
}

typealias VkExternalSemaphoreFeatureFlags = VkFlags


inline var VkPhysicalDeviceSubgroupProperties.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceSubgroupProperties.nsType(adr))
    set(value) = VkPhysicalDeviceSubgroupProperties.nsType(adr, value.i)
inline var VkPhysicalDeviceSubgroupProperties.next: Ptr
    get() = VkPhysicalDeviceSubgroupProperties.npNext(adr)
    set(value) = VkPhysicalDeviceSubgroupProperties.npNext(adr, value)
inline val VkPhysicalDeviceSubgroupProperties.subgroupSize: Int
    get() = VkPhysicalDeviceSubgroupProperties.nsubgroupSize(adr)
inline val VkPhysicalDeviceSubgroupProperties.supportedStages: VkShaderStageFlags
    get() = VkPhysicalDeviceSubgroupProperties.nsupportedStages(adr)
inline val VkPhysicalDeviceSubgroupProperties.supportedOperations: VkSubgroupFeatureFlags
    get() = VkPhysicalDeviceSubgroupProperties.nsupportedOperations(adr)
inline val VkPhysicalDeviceSubgroupProperties.quadOperationsInAllStages: Boolean
    get() = VkPhysicalDeviceSubgroupProperties.nquadOperationsInAllStages(adr).bool


inline var VkBindBufferMemoryInfo.type: VkStructureType
    get() = VkStructureType(VkBindBufferMemoryInfo.nsType(adr))
    set(value) = VkBindBufferMemoryInfo.nsType(adr, value.i)
inline var VkBindBufferMemoryInfo.next: Ptr
    get() = VkBindBufferMemoryInfo.npNext(adr)
    set(value) = VkBindBufferMemoryInfo.npNext(adr, value)
inline var VkBindBufferMemoryInfo.buffer: VkBuffer
    get() = VkBuffer(VkBindBufferMemoryInfo.nbuffer(adr))
    set(value) = VkBindBufferMemoryInfo.nbuffer(adr, value.L)
inline var VkBindBufferMemoryInfo.memory: VkDeviceMemory
    get() = VkDeviceMemory(VkBindBufferMemoryInfo.nmemory(adr))
    set(value) = VkBindBufferMemoryInfo.nmemory(adr, value.L)
inline var VkBindBufferMemoryInfo.memoryOffset: VkDeviceSize
    get() = VkDeviceSize(VkBindBufferMemoryInfo.nmemoryOffset(adr))
    set(value) = VkBindBufferMemoryInfo.nmemoryOffset(adr, value.L)


inline var VkBindImageMemoryInfo.type: VkStructureType
    get() = VkStructureType(VkBindImageMemoryInfo.nsType(adr))
    set(value) = VkBindImageMemoryInfo.nsType(adr, value.i)
inline var VkBindImageMemoryInfo.next: Ptr
    get() = VkBindImageMemoryInfo.npNext(adr)
    set(value) = VkBindImageMemoryInfo.npNext(adr, value)
inline var VkBindImageMemoryInfo.image: VkImage
    get() = VkImage(VkBindImageMemoryInfo.nimage(adr))
    set(value) = VkBindImageMemoryInfo.nimage(adr, value.L)
inline var VkBindImageMemoryInfo.memory: VkDeviceMemory
    get() = VkDeviceMemory(VkBindImageMemoryInfo.nmemory(adr))
    set(value) = VkBindImageMemoryInfo.nmemory(adr, value.L)
inline var VkBindImageMemoryInfo.memoryOffset: VkDeviceSize
    get() = VkDeviceSize(VkBindImageMemoryInfo.nmemoryOffset(adr))
    set(value) = VkBindImageMemoryInfo.nmemoryOffset(adr, value.L)


inline var VkPhysicalDevice16BitStorageFeatures.type: VkStructureType
    get() = VkStructureType(VkPhysicalDevice16BitStorageFeatures.nsType(adr))
    set(value) = VkPhysicalDevice16BitStorageFeatures.nsType(adr, value.i)
inline var VkPhysicalDevice16BitStorageFeatures.next: Ptr
    get() = VkPhysicalDevice16BitStorageFeatures.npNext(adr)
    set(value) = VkPhysicalDevice16BitStorageFeatures.npNext(adr, value)
inline var VkPhysicalDevice16BitStorageFeatures.storageBuffer16BitAccess: Boolean
    get() = VkPhysicalDevice16BitStorageFeatures.nstorageBuffer16BitAccess(adr).bool
    set(value) = VkPhysicalDevice16BitStorageFeatures.nstorageBuffer16BitAccess(adr, value.i)
inline var VkPhysicalDevice16BitStorageFeatures.uniformAndStorageBuffer16BitAccess: Boolean
    get() = VkPhysicalDevice16BitStorageFeatures.nuniformAndStorageBuffer16BitAccess(adr).bool
    set(value) = VkPhysicalDevice16BitStorageFeatures.nuniformAndStorageBuffer16BitAccess(adr, value.i)
inline var VkPhysicalDevice16BitStorageFeatures.storagePushConstant16: Boolean
    get() = VkPhysicalDevice16BitStorageFeatures.nstoragePushConstant16(adr).bool
    set(value) = VkPhysicalDevice16BitStorageFeatures.nstoragePushConstant16(adr, value.i)
inline var VkPhysicalDevice16BitStorageFeatures.storageInputOutput16: Boolean
    get() = VkPhysicalDevice16BitStorageFeatures.nstorageInputOutput16(adr).bool
    set(value) = VkPhysicalDevice16BitStorageFeatures.nstorageInputOutput16(adr, value.i)


inline var VkMemoryDedicatedRequirements.type: VkStructureType
    get() = VkStructureType(VkMemoryDedicatedRequirements.nsType(adr))
    set(value) = VkMemoryDedicatedRequirements.nsType(adr, value.i)
inline var VkMemoryDedicatedRequirements.next: Ptr
    get() = VkMemoryDedicatedRequirements.npNext(adr)
    set(value) = VkMemoryDedicatedRequirements.npNext(adr, value)
inline val VkMemoryDedicatedRequirements.prefersDedicatedAllocation: Boolean
    get() = VkMemoryDedicatedRequirements.nprefersDedicatedAllocation(adr).bool
inline val VkMemoryDedicatedRequirements.requiresDedicatedAllocation: Boolean
    get() = VkMemoryDedicatedRequirements.nrequiresDedicatedAllocation(adr).bool


inline var VkMemoryDedicatedAllocateInfo.type: VkStructureType
    get() = VkStructureType(VkMemoryDedicatedAllocateInfo.nsType(adr))
    set(value) = VkMemoryDedicatedAllocateInfo.nsType(adr, value.i)
inline var VkMemoryDedicatedAllocateInfo.next: Ptr
    get() = VkMemoryDedicatedAllocateInfo.npNext(adr)
    set(value) = VkMemoryDedicatedAllocateInfo.npNext(adr, value)
inline var VkMemoryDedicatedAllocateInfo.image: VkImage
    get() = VkImage(VkMemoryDedicatedAllocateInfo.nimage(adr))
    set(value) = VkMemoryDedicatedAllocateInfo.nimage(adr, value.L)
inline var VkMemoryDedicatedAllocateInfo.buffer: VkBuffer
    get() = VkBuffer(VkMemoryDedicatedAllocateInfo.nbuffer(adr))
    set(value) = VkMemoryDedicatedAllocateInfo.nbuffer(adr, value.L)


inline var VkMemoryAllocateFlagsInfo.type: VkStructureType
    get() = VkStructureType(VkMemoryAllocateFlagsInfo.nsType(adr))
    set(value) = VkMemoryAllocateFlagsInfo.nsType(adr, value.i)
inline var VkMemoryAllocateFlagsInfo.next: Ptr
    get() = VkMemoryAllocateFlagsInfo.npNext(adr)
    set(value) = VkMemoryAllocateFlagsInfo.npNext(adr, value)
inline var VkMemoryAllocateFlagsInfo.flags: VkMemoryAllocateFlags
    get() = VkMemoryAllocateFlagsInfo.nflags(adr)
    set(value) = VkMemoryAllocateFlagsInfo.nflags(adr, value)
inline var VkMemoryAllocateFlagsInfo.deviceMask: Int
    get() = VkMemoryAllocateFlagsInfo.ndeviceMask(adr)
    set(value) = VkMemoryAllocateFlagsInfo.ndeviceMask(adr, value)


inline var VkDeviceGroupRenderPassBeginInfo.type: VkStructureType
    get() = VkStructureType(VkDeviceGroupRenderPassBeginInfo.nsType(adr))
    set(value) = VkDeviceGroupRenderPassBeginInfo.nsType(adr, value.i)
inline var VkDeviceGroupRenderPassBeginInfo.next: Ptr
    get() = VkDeviceGroupRenderPassBeginInfo.npNext(adr)
    set(value) = VkDeviceGroupRenderPassBeginInfo.npNext(adr, value)
inline var VkDeviceGroupRenderPassBeginInfo.deviceMask: Int
    get() = VkDeviceGroupRenderPassBeginInfo.ndeviceMask(adr)
    set(value) = VkDeviceGroupRenderPassBeginInfo.ndeviceMask(adr, value)
@Deprecated("this will be set automatically")
inline var VkDeviceGroupRenderPassBeginInfo.deviceRenderAreaCount: Int
    get() = VkDeviceGroupRenderPassBeginInfo.ndeviceRenderAreaCount(adr)
    set(value) = VkDeviceGroupRenderPassBeginInfo.ndeviceRenderAreaCount(adr, value)
inline var VkDeviceGroupRenderPassBeginInfo.deviceRenderAreas: VkRect2D.Buffer?
    get() = VkDeviceGroupRenderPassBeginInfo.npDeviceRenderAreas(adr)
    set(value) = VkDeviceGroupRenderPassBeginInfo.npDeviceRenderAreas(adr, value)


inline var VkDeviceGroupCommandBufferBeginInfo.type: VkStructureType
    get() = VkStructureType(VkDeviceGroupCommandBufferBeginInfo.nsType(adr))
    set(value) = VkDeviceGroupCommandBufferBeginInfo.nsType(adr, value.i)
inline var VkDeviceGroupCommandBufferBeginInfo.next: Ptr
    get() = VkDeviceGroupCommandBufferBeginInfo.npNext(adr)
    set(value) = VkDeviceGroupCommandBufferBeginInfo.npNext(adr, value)
inline var VkDeviceGroupCommandBufferBeginInfo.deviceMask: Int
    get() = VkDeviceGroupCommandBufferBeginInfo.ndeviceMask(adr)
    set(value) = VkDeviceGroupCommandBufferBeginInfo.ndeviceMask(adr, value)


inline var VkDeviceGroupSubmitInfo.type: VkStructureType
    get() = VkStructureType(VkDeviceGroupSubmitInfo.nsType(adr))
    set(value) = VkDeviceGroupSubmitInfo.nsType(adr, value.i)
inline var VkDeviceGroupSubmitInfo.next: Ptr
    get() = VkDeviceGroupSubmitInfo.npNext(adr)
    set(value) = VkDeviceGroupSubmitInfo.npNext(adr, value)
@Deprecated("this will be set automatically")
inline var VkDeviceGroupSubmitInfo.waitSemaphoreCount: Int
    get() = VkDeviceGroupSubmitInfo.nwaitSemaphoreCount(adr)
    set(value) = VkDeviceGroupSubmitInfo.nwaitSemaphoreCount(adr, value)
inline var VkDeviceGroupSubmitInfo.waitSemaphoreDeviceIndices: IntBuffer?
    get() = VkDeviceGroupSubmitInfo.npWaitSemaphoreDeviceIndices(adr)
    set(value) = VkDeviceGroupSubmitInfo.npWaitSemaphoreDeviceIndices(adr, value)
@Deprecated("this will be set automatically")
inline var VkDeviceGroupSubmitInfo.commandBufferCount: Int
    get() = VkDeviceGroupSubmitInfo.ncommandBufferCount(adr)
    set(value) = VkDeviceGroupSubmitInfo.ncommandBufferCount(adr, value)
inline var VkDeviceGroupSubmitInfo.commandBufferDeviceMasks: IntBuffer?
    get() = VkDeviceGroupSubmitInfo.npCommandBufferDeviceMasks(adr)
    set(value) = VkDeviceGroupSubmitInfo.npCommandBufferDeviceMasks(adr, value)
@Deprecated("this will be set automatically")
inline var VkDeviceGroupSubmitInfo.signalSemaphoreCount: Int
    get() = VkDeviceGroupSubmitInfo.nsignalSemaphoreCount(adr)
    set(value) = VkDeviceGroupSubmitInfo.nsignalSemaphoreCount(adr, value)
inline var VkDeviceGroupSubmitInfo.signalSemaphoreDeviceIndices: IntBuffer?
    get() = VkDeviceGroupSubmitInfo.npSignalSemaphoreDeviceIndices(adr)
    set(value) = VkDeviceGroupSubmitInfo.npSignalSemaphoreDeviceIndices(adr, value)


inline var VkDeviceGroupBindSparseInfo.type: VkStructureType
    get() = VkStructureType(VkDeviceGroupBindSparseInfo.nsType(adr))
    set(value) = VkDeviceGroupBindSparseInfo.nsType(adr, value.i)
inline var VkDeviceGroupBindSparseInfo.next: Ptr
    get() = VkDeviceGroupBindSparseInfo.npNext(adr)
    set(value) = VkDeviceGroupBindSparseInfo.npNext(adr, value)
inline var VkDeviceGroupBindSparseInfo.resourceDeviceIndex: Int
    get() = VkDeviceGroupBindSparseInfo.nresourceDeviceIndex(adr)
    set(value) = VkDeviceGroupBindSparseInfo.nresourceDeviceIndex(adr, value)
inline var VkDeviceGroupBindSparseInfo.memoryDeviceIndex: Int
    get() = VkDeviceGroupBindSparseInfo.nmemoryDeviceIndex(adr)
    set(value) = VkDeviceGroupBindSparseInfo.nmemoryDeviceIndex(adr, value)


inline var VkBindBufferMemoryDeviceGroupInfo.type: VkStructureType
    get() = VkStructureType(VkBindBufferMemoryDeviceGroupInfo.nsType(adr))
    set(value) = VkBindBufferMemoryDeviceGroupInfo.nsType(adr, value.i)
inline var VkBindBufferMemoryDeviceGroupInfo.next: Ptr
    get() = VkBindBufferMemoryDeviceGroupInfo.npNext(adr)
    set(value) = VkBindBufferMemoryDeviceGroupInfo.npNext(adr, value)
@Deprecated("this will be set automatically")
inline var VkBindBufferMemoryDeviceGroupInfo.deviceIndexCount: Int
    get() = VkBindBufferMemoryDeviceGroupInfo.ndeviceIndexCount(adr)
    set(value) = VkBindBufferMemoryDeviceGroupInfo.ndeviceIndexCount(adr, value)
inline var VkBindBufferMemoryDeviceGroupInfo.deviceIndices: IntBuffer?
    get() = VkBindBufferMemoryDeviceGroupInfo.npDeviceIndices(adr)
    set(value) = VkBindBufferMemoryDeviceGroupInfo.npDeviceIndices(adr, value)


inline var VkBindImageMemoryDeviceGroupInfo.type: VkStructureType
    get() = VkStructureType(VkBindImageMemoryDeviceGroupInfo.nsType(adr))
    set(value) = VkBindImageMemoryDeviceGroupInfo.nsType(adr, value.i)
inline var VkBindImageMemoryDeviceGroupInfo.next: Ptr
    get() = VkBindImageMemoryDeviceGroupInfo.npNext(adr)
    set(value) = VkBindImageMemoryDeviceGroupInfo.npNext(adr, value)
@Deprecated("this will be set automatically")
inline var VkBindImageMemoryDeviceGroupInfo.deviceIndexCount: Int
    get() = VkBindImageMemoryDeviceGroupInfo.ndeviceIndexCount(adr)
    set(value) = VkBindImageMemoryDeviceGroupInfo.ndeviceIndexCount(adr, value)
inline var VkBindImageMemoryDeviceGroupInfo.deviceIndices: IntBuffer?
    get() = VkBindImageMemoryDeviceGroupInfo.npDeviceIndices(adr)
    set(value) = VkBindImageMemoryDeviceGroupInfo.npDeviceIndices(adr, value)
@Deprecated("this will be set automatically")
inline var VkBindImageMemoryDeviceGroupInfo.splitInstanceBindRegionCount: Int
    get() = VkBindImageMemoryDeviceGroupInfo.nsplitInstanceBindRegionCount(adr)
    set(value) = VkBindImageMemoryDeviceGroupInfo.nsplitInstanceBindRegionCount(adr, value)
inline var VkBindImageMemoryDeviceGroupInfo.splitInstanceBindRegions: VkRect2D.Buffer?
    get() = VkBindImageMemoryDeviceGroupInfo.npSplitInstanceBindRegions(adr)
    set(value) = VkBindImageMemoryDeviceGroupInfo.npSplitInstanceBindRegions(adr, value)


inline var VkPhysicalDeviceGroupProperties.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceGroupProperties.nsType(adr))
    set(value) = VkPhysicalDeviceGroupProperties.nsType(adr, value.i)
inline var VkPhysicalDeviceGroupProperties.next: Ptr
    get() = VkPhysicalDeviceGroupProperties.npNext(adr)
    set(value) = VkPhysicalDeviceGroupProperties.npNext(adr, value)
inline val VkPhysicalDeviceGroupProperties.physicalDeviceCount: Int
    get() = VkPhysicalDeviceGroupProperties.nphysicalDeviceCount(adr)
inline val VkPhysicalDeviceGroupProperties.physicalDevices: PointerBuffer
    get() = VkPhysicalDeviceGroupProperties.nphysicalDevices(adr)
inline val VkPhysicalDeviceGroupProperties.subsetAllocation: Boolean
    get() = VkPhysicalDeviceGroupProperties.nsubsetAllocation(adr).bool


inline var VkDeviceGroupDeviceCreateInfo.type: VkStructureType
    get() = VkStructureType(VkDeviceGroupDeviceCreateInfo.nsType(adr))
    set(value) = VkDeviceGroupDeviceCreateInfo.nsType(adr, value.i)
inline var VkDeviceGroupDeviceCreateInfo.next: Ptr
    get() = VkDeviceGroupDeviceCreateInfo.npNext(adr)
    set(value) = VkDeviceGroupDeviceCreateInfo.npNext(adr, value)
@Deprecated("this will be set automatically")
inline var VkDeviceGroupDeviceCreateInfo.physicalDeviceCount: Int
    get() = VkDeviceGroupDeviceCreateInfo.nphysicalDeviceCount(adr)
    set(value) = VkDeviceGroupDeviceCreateInfo.nphysicalDeviceCount(adr, value)
inline var VkDeviceGroupDeviceCreateInfo.physicalDevices: PointerBuffer?
    get() = VkDeviceGroupDeviceCreateInfo.npPhysicalDevices(adr)
    set(value) = VkDeviceGroupDeviceCreateInfo.npPhysicalDevices(adr, value)


inline var VkBufferMemoryRequirementsInfo2.type: VkStructureType
    get() = VkStructureType(VkBufferMemoryRequirementsInfo2.nsType(adr))
    set(value) = VkBufferMemoryRequirementsInfo2.nsType(adr, value.i)
inline var VkBufferMemoryRequirementsInfo2.next: Ptr
    get() = VkBufferMemoryRequirementsInfo2.npNext(adr)
    set(value) = VkBufferMemoryRequirementsInfo2.npNext(adr, value)
inline var VkBufferMemoryRequirementsInfo2.buffer: VkBuffer
    get() = VkBuffer(VkBufferMemoryRequirementsInfo2.nbuffer(adr))
    set(value) = VkBufferMemoryRequirementsInfo2.nbuffer(adr, value.L)


inline var VkImageMemoryRequirementsInfo2.type: VkStructureType
    get() = VkStructureType(VkImageMemoryRequirementsInfo2.nsType(adr))
    set(value) = VkImageMemoryRequirementsInfo2.nsType(adr, value.i)
inline var VkImageMemoryRequirementsInfo2.next: Ptr
    get() = VkImageMemoryRequirementsInfo2.npNext(adr)
    set(value) = VkImageMemoryRequirementsInfo2.npNext(adr, value)
inline var VkImageMemoryRequirementsInfo2.image: VkImage
    get() = VkImage(VkImageMemoryRequirementsInfo2.nimage(adr))
    set(value) = VkImageMemoryRequirementsInfo2.nimage(adr, value.L)


inline var VkImageSparseMemoryRequirementsInfo2.type: VkStructureType
    get() = VkStructureType(VkImageSparseMemoryRequirementsInfo2.nsType(adr))
    set(value) = VkImageSparseMemoryRequirementsInfo2.nsType(adr, value.i)
inline var VkImageSparseMemoryRequirementsInfo2.next: Ptr
    get() = VkImageSparseMemoryRequirementsInfo2.npNext(adr)
    set(value) = VkImageSparseMemoryRequirementsInfo2.npNext(adr, value)
inline var VkImageSparseMemoryRequirementsInfo2.image: VkImage
    get() = VkImage(VkImageSparseMemoryRequirementsInfo2.nimage(adr))
    set(value) = VkImageSparseMemoryRequirementsInfo2.nimage(adr, value.L)


inline var VkMemoryRequirements2.type: VkStructureType
    get() = VkStructureType(VkMemoryRequirements2.nsType(adr))
    set(value) = VkMemoryRequirements2.nsType(adr, value.i)
inline var VkMemoryRequirements2.next: Ptr
    get() = VkMemoryRequirements2.npNext(adr)
    set(value) = VkMemoryRequirements2.npNext(adr, value)
inline val VkMemoryRequirements2.memoryRequirements: VkMemoryRequirements
    get() = VkMemoryRequirements2.nmemoryRequirements(adr)


typealias VkMemoryRequirements2KHR = VkMemoryRequirements2


inline var VkSparseImageMemoryRequirements2.type: VkStructureType
    get() = VkStructureType(VkSparseImageMemoryRequirements2.nsType(adr))
    set(value) = VkSparseImageMemoryRequirements2.nsType(adr, value.i)
inline var VkSparseImageMemoryRequirements2.next: Ptr
    get() = VkSparseImageMemoryRequirements2.npNext(adr)
    set(value) = VkSparseImageMemoryRequirements2.npNext(adr, value)
inline val VkSparseImageMemoryRequirements2.memoryRequirements: VkSparseImageMemoryRequirements
    get() = VkSparseImageMemoryRequirements2.nmemoryRequirements(adr)


inline var VkPhysicalDeviceFeatures2.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceFeatures2.nsType(adr))
    set(value) = VkPhysicalDeviceFeatures2.nsType(adr, value.i)
inline var VkPhysicalDeviceFeatures2.next: Ptr
    get() = VkPhysicalDeviceFeatures2.npNext(adr)
    set(value) = VkPhysicalDeviceFeatures2.npNext(adr, value)
inline var VkPhysicalDeviceFeatures2.features: VkPhysicalDeviceFeatures
    get() = VkPhysicalDeviceFeatures2.nfeatures(adr)
    set(value) = VkPhysicalDeviceFeatures2.nfeatures(adr, value)


inline var VkPhysicalDeviceProperties2.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceProperties2.nsType(adr))
    set(value) = VkPhysicalDeviceProperties2.nsType(adr, value.i)
inline var VkPhysicalDeviceProperties2.next: Ptr
    get() = VkPhysicalDeviceProperties2.npNext(adr)
    set(value) = VkPhysicalDeviceProperties2.npNext(adr, value)
inline val VkPhysicalDeviceProperties2.properties: VkPhysicalDeviceProperties
    get() = VkPhysicalDeviceProperties2.nproperties(adr)


inline var VkFormatProperties2.type: VkStructureType
    get() = VkStructureType(VkFormatProperties2.nsType(adr))
    set(value) = VkFormatProperties2.nsType(adr, value.i)
inline var VkFormatProperties2.next: Ptr
    get() = VkFormatProperties2.npNext(adr)
    set(value) = VkFormatProperties2.npNext(adr, value)
inline val VkFormatProperties2.formatProperties: VkFormatProperties
    get() = VkFormatProperties2.nformatProperties(adr)


inline var VkImageFormatProperties2.type: VkStructureType
    get() = VkStructureType(VkImageFormatProperties2.nsType(adr))
    set(value) = VkImageFormatProperties2.nsType(adr, value.i)
inline var VkImageFormatProperties2.next: Ptr
    get() = VkImageFormatProperties2.npNext(adr)
    set(value) = VkImageFormatProperties2.npNext(adr, value)
inline val VkImageFormatProperties2.imageFormatProperties: VkImageFormatProperties
    get() = VkImageFormatProperties2.nimageFormatProperties(adr)


inline var VkPhysicalDeviceImageFormatInfo2.sType: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceImageFormatInfo2.nsType(adr))
    set(value) = VkPhysicalDeviceImageFormatInfo2.nsType(adr, value.i)
inline var VkPhysicalDeviceImageFormatInfo2.next: Ptr
    get() = VkPhysicalDeviceImageFormatInfo2.npNext(adr)
    set(value) = VkPhysicalDeviceImageFormatInfo2.npNext(adr, value)
inline var VkPhysicalDeviceImageFormatInfo2.format: VkFormat
    get() = VkFormat(VkPhysicalDeviceImageFormatInfo2.nformat(adr))
    set(value) = VkPhysicalDeviceImageFormatInfo2.nformat(adr, value.i)
inline var VkPhysicalDeviceImageFormatInfo2.type: VkImageType
    get() = VkImageType(VkPhysicalDeviceImageFormatInfo2.nsType(adr))
    set(value) = VkPhysicalDeviceImageFormatInfo2.nsType(adr, value.i)
inline var VkPhysicalDeviceImageFormatInfo2.tiling: VkImageTiling
    get() = VkImageTiling(VkPhysicalDeviceImageFormatInfo2.ntiling(adr))
    set(value) = VkPhysicalDeviceImageFormatInfo2.ntiling(adr, value.i)
inline var VkPhysicalDeviceImageFormatInfo2.usage: VkImageUsageFlags
    get() = VkPhysicalDeviceImageFormatInfo2.nusage(adr)
    set(value) = VkPhysicalDeviceImageFormatInfo2.nusage(adr, value)
inline var VkPhysicalDeviceImageFormatInfo2.flags: VkImageCreateFlags
    get() = VkPhysicalDeviceImageFormatInfo2.nflags(adr)
    set(value) = VkPhysicalDeviceImageFormatInfo2.nflags(adr, value)


inline var VkQueueFamilyProperties2.type: VkStructureType
    get() = VkStructureType(VkQueueFamilyProperties2.nsType(adr))
    set(value) = VkQueueFamilyProperties2.nsType(adr, value.i)
inline var VkQueueFamilyProperties2.next: Ptr
    get() = VkQueueFamilyProperties2.npNext(adr)
    set(value) = VkQueueFamilyProperties2.npNext(adr, value)
inline val VkQueueFamilyProperties2.queueFamilyProperties: VkQueueFamilyProperties
    get() = VkQueueFamilyProperties2.nqueueFamilyProperties(adr)


inline var VkPhysicalDeviceMemoryProperties2.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceMemoryProperties2.nsType(adr))
    set(value) = VkPhysicalDeviceMemoryProperties2.nsType(adr, value.i)
inline var VkPhysicalDeviceMemoryProperties2.next: Ptr
    get() = VkPhysicalDeviceMemoryProperties2.npNext(adr)
    set(value) = VkPhysicalDeviceMemoryProperties2.npNext(adr, value)
inline val VkPhysicalDeviceMemoryProperties2.memoryProperties: VkPhysicalDeviceMemoryProperties
    get() = VkPhysicalDeviceMemoryProperties2.nmemoryProperties(adr)


inline var VkSparseImageFormatProperties2.type: VkStructureType
    get() = VkStructureType(VkSparseImageFormatProperties2.nsType(adr))
    set(value) = VkSparseImageFormatProperties2.nsType(adr, value.i)
inline var VkSparseImageFormatProperties2.next: Ptr
    get() = VkSparseImageFormatProperties2.npNext(adr)
    set(value) = VkSparseImageFormatProperties2.npNext(adr, value)
inline val VkSparseImageFormatProperties2.properties: VkSparseImageFormatProperties
    get() = VkSparseImageFormatProperties2.nproperties(adr)


inline var VkPhysicalDeviceSparseImageFormatInfo2.sType: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceSparseImageFormatInfo2.nsType(adr))
    set(value) = VkPhysicalDeviceSparseImageFormatInfo2.nsType(adr, value.i)
inline var VkPhysicalDeviceSparseImageFormatInfo2.next: Ptr
    get() = VkPhysicalDeviceSparseImageFormatInfo2.npNext(adr)
    set(value) = VkPhysicalDeviceSparseImageFormatInfo2.npNext(adr, value)
inline var VkPhysicalDeviceSparseImageFormatInfo2.format: VkFormat
    get() = VkFormat(VkPhysicalDeviceSparseImageFormatInfo2.nformat(adr))
    set(value) = VkPhysicalDeviceSparseImageFormatInfo2.nformat(adr, value.i)
inline var VkPhysicalDeviceSparseImageFormatInfo2.type: VkImageType
    get() = VkImageType(VkPhysicalDeviceSparseImageFormatInfo2.nsType(adr))
    set(value) = VkPhysicalDeviceSparseImageFormatInfo2.nsType(adr, value.i)
inline var VkPhysicalDeviceSparseImageFormatInfo2.samples: VkSampleCount
    get() = VkSampleCount(VkPhysicalDeviceSparseImageFormatInfo2.nsamples(adr))
    set(value) = VkPhysicalDeviceSparseImageFormatInfo2.nsamples(adr, value.i)
inline var VkPhysicalDeviceSparseImageFormatInfo2.usage: VkImageUsageFlags
    get() = VkPhysicalDeviceSparseImageFormatInfo2.nusage(adr)
    set(value) = VkPhysicalDeviceSparseImageFormatInfo2.nusage(adr, value)
inline var VkPhysicalDeviceSparseImageFormatInfo2.tiling: VkImageTiling
    get() = VkImageTiling(VkPhysicalDeviceSparseImageFormatInfo2.ntiling(adr))
    set(value) = VkPhysicalDeviceSparseImageFormatInfo2.ntiling(adr, value.i)


inline var VkPhysicalDevicePointClippingProperties.type: VkStructureType
    get() = VkStructureType(VkPhysicalDevicePointClippingProperties.nsType(adr))
    set(value) = VkPhysicalDevicePointClippingProperties.nsType(adr, value.i)
inline var VkPhysicalDevicePointClippingProperties.next: Ptr
    get() = VkPhysicalDevicePointClippingProperties.npNext(adr)
    set(value) = VkPhysicalDevicePointClippingProperties.npNext(adr, value)
inline val VkPhysicalDevicePointClippingProperties.pointClippingBehavior: VkPointClippingBehavior
    get() = VkPointClippingBehavior(VkPhysicalDevicePointClippingProperties.npointClippingBehavior(adr))


inline var VkInputAttachmentAspectReference.subpass: Int
    get() = VkInputAttachmentAspectReference.nsubpass(adr)
    set(value) = VkInputAttachmentAspectReference.nsubpass(adr, value)
inline var VkInputAttachmentAspectReference.inputAttachmentIndex: Int
    get() = VkInputAttachmentAspectReference.ninputAttachmentIndex(adr)
    set(value) = VkInputAttachmentAspectReference.ninputAttachmentIndex(adr, value)
inline var VkInputAttachmentAspectReference.aspectMask: VkImageAspect
    get() = VkImageAspect(VkInputAttachmentAspectReference.naspectMask(adr))
    set(value) = VkInputAttachmentAspectReference.naspectMask(adr, value.i)


inline var VkRenderPassInputAttachmentAspectCreateInfo.type: VkStructureType
    get() = VkStructureType(VkRenderPassInputAttachmentAspectCreateInfo.nsType(adr))
    set(value) = VkRenderPassInputAttachmentAspectCreateInfo.nsType(adr, value.i)
inline var VkRenderPassInputAttachmentAspectCreateInfo.next: Ptr
    get() = VkRenderPassInputAttachmentAspectCreateInfo.npNext(adr)
    set(value) = VkRenderPassInputAttachmentAspectCreateInfo.npNext(adr, value)
inline var VkRenderPassInputAttachmentAspectCreateInfo.aspectReferenceCount: Int
    get() = VkRenderPassInputAttachmentAspectCreateInfo.naspectReferenceCount(adr)
    set(value) = VkRenderPassInputAttachmentAspectCreateInfo.naspectReferenceCount(adr, value)


inline var VkImageViewUsageCreateInfo.type: VkStructureType
    get() = VkStructureType(VkImageViewUsageCreateInfo.nsType(adr))
    set(value) = VkImageViewUsageCreateInfo.nsType(adr, value.i)
inline var VkImageViewUsageCreateInfo.next: Ptr
    get() = VkImageViewUsageCreateInfo.npNext(adr)
    set(value) = VkImageViewUsageCreateInfo.npNext(adr, value)
inline var VkImageViewUsageCreateInfo.usage: VkImageUsageFlags
    get() = VkImageViewUsageCreateInfo.nusage(adr)
    set(value) = VkImageViewUsageCreateInfo.nusage(adr, value)


inline var VkPipelineTessellationDomainOriginStateCreateInfo.type: VkStructureType
    get() = VkStructureType(VkPipelineTessellationDomainOriginStateCreateInfo.nsType(adr))
    set(value) = VkPipelineTessellationDomainOriginStateCreateInfo.nsType(adr, value.i)
inline var VkPipelineTessellationDomainOriginStateCreateInfo.next: Ptr
    get() = VkPipelineTessellationDomainOriginStateCreateInfo.npNext(adr)
    set(value) = VkPipelineTessellationDomainOriginStateCreateInfo.npNext(adr, value)
inline var VkPipelineTessellationDomainOriginStateCreateInfo.domainOrigin: VkTessellationDomainOrigin
    get() = VkTessellationDomainOrigin(VkPipelineTessellationDomainOriginStateCreateInfo.ndomainOrigin(adr))
    set(value) = VkPipelineTessellationDomainOriginStateCreateInfo.ndomainOrigin(adr, value.i)


inline var VkRenderPassMultiviewCreateInfo.type: VkStructureType
    get() = VkStructureType(VkRenderPassMultiviewCreateInfo.nsType(adr))
    set(value) = VkRenderPassMultiviewCreateInfo.nsType(adr, value.i)
inline var VkRenderPassMultiviewCreateInfo.next: Ptr
    get() = VkRenderPassMultiviewCreateInfo.npNext(adr)
    set(value) = VkRenderPassMultiviewCreateInfo.npNext(adr, value)
@Deprecated("this will be set automatically")
inline var VkRenderPassMultiviewCreateInfo.subpassCount: Int
    get() = VkRenderPassMultiviewCreateInfo.nsubpassCount(adr)
    set(value) = VkRenderPassMultiviewCreateInfo.nsubpassCount(adr, value.i)
inline var VkRenderPassMultiviewCreateInfo.viewMasks: IntBuffer?
    get() = VkRenderPassMultiviewCreateInfo.npViewMasks(adr)
    set(value) = VkRenderPassMultiviewCreateInfo.npViewMasks(adr, value)
@Deprecated("this will be set automatically")
inline var VkRenderPassMultiviewCreateInfo.dependencyCount: Int
    get() = VkRenderPassMultiviewCreateInfo.ndependencyCount(adr)
    set(value) = VkRenderPassMultiviewCreateInfo.ndependencyCount(adr, value.i)
inline var VkRenderPassMultiviewCreateInfo.viewOffsets: IntBuffer?
    get() = VkRenderPassMultiviewCreateInfo.npViewOffsets(adr)
    set(value) = VkRenderPassMultiviewCreateInfo.npViewOffsets(adr, value)
@Deprecated("this will be set automatically")
inline var VkRenderPassMultiviewCreateInfo.correlationMaskCount: Int
    get() = VkRenderPassMultiviewCreateInfo.ncorrelationMaskCount(adr)
    set(value) = VkRenderPassMultiviewCreateInfo.ncorrelationMaskCount(adr, value.i)
inline var VkRenderPassMultiviewCreateInfo.correlationMasks: IntBuffer?
    get() = VkRenderPassMultiviewCreateInfo.npCorrelationMasks(adr)
    set(value) = VkRenderPassMultiviewCreateInfo.npCorrelationMasks(adr, value)


inline var VkPhysicalDeviceMultiviewFeatures.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceMultiviewFeatures.nsType(adr))
    set(value) = VkPhysicalDeviceMultiviewFeatures.nsType(adr, value.i)
inline var VkPhysicalDeviceMultiviewFeatures.next: Ptr
    get() = VkPhysicalDeviceMultiviewFeatures.npNext(adr)
    set(value) = VkPhysicalDeviceMultiviewFeatures.npNext(adr, value)
inline var VkPhysicalDeviceMultiviewFeatures.multiview: Boolean
    get() = VkPhysicalDeviceMultiviewFeatures.nmultiview(adr).bool
    set(value) = VkPhysicalDeviceMultiviewFeatures.nmultiview(adr, value.i)
inline var VkPhysicalDeviceMultiviewFeatures.multiviewGeometryShader: Boolean
    get() = VkPhysicalDeviceMultiviewFeatures.nmultiviewGeometryShader(adr).bool
    set(value) = VkPhysicalDeviceMultiviewFeatures.nmultiviewGeometryShader(adr, value.i)
inline var VkPhysicalDeviceMultiviewFeatures.multiviewTessellationShader: Boolean
    get() = VkPhysicalDeviceMultiviewFeatures.nmultiviewTessellationShader(adr).bool
    set(value) = VkPhysicalDeviceMultiviewFeatures.nmultiviewTessellationShader(adr, value.i)


inline var VkPhysicalDeviceMultiviewProperties.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceMultiviewProperties.nsType(adr))
    set(value) = VkPhysicalDeviceMultiviewProperties.nsType(adr, value.i)
inline var VkPhysicalDeviceMultiviewProperties.next: Ptr
    get() = VkPhysicalDeviceMultiviewProperties.npNext(adr)
    set(value) = VkPhysicalDeviceMultiviewProperties.npNext(adr, value)
inline val VkPhysicalDeviceMultiviewProperties.maxMultiviewViewCount: Int
    get() = VkPhysicalDeviceMultiviewProperties.nmaxMultiviewViewCount(adr)
inline val VkPhysicalDeviceMultiviewProperties.maxMultiviewInstanceIndex: Int
    get() = VkPhysicalDeviceMultiviewProperties.nmaxMultiviewInstanceIndex(adr)


inline var VkPhysicalDeviceVariablePointerFeatures.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceVariablePointerFeatures.nsType(adr))
    set(value) = VkPhysicalDeviceVariablePointerFeatures.nsType(adr, value.i)
inline var VkPhysicalDeviceVariablePointerFeatures.next: Ptr
    get() = VkPhysicalDeviceVariablePointerFeatures.npNext(adr)
    set(value) = VkPhysicalDeviceVariablePointerFeatures.npNext(adr, value)
inline var VkPhysicalDeviceVariablePointerFeatures.variablePointersStorageBuffer: Boolean
    get() = VkPhysicalDeviceVariablePointerFeatures.nvariablePointersStorageBuffer(adr).bool
    set(value) = VkPhysicalDeviceVariablePointerFeatures.nvariablePointersStorageBuffer(adr, value.i)
inline var VkPhysicalDeviceVariablePointerFeatures.variablePointers: Boolean
    get() = VkPhysicalDeviceVariablePointerFeatures.nvariablePointers(adr).bool
    set(value) = VkPhysicalDeviceVariablePointerFeatures.nvariablePointers(adr, value.i)


inline var VkPhysicalDeviceProtectedMemoryFeatures.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceProtectedMemoryFeatures.nsType(adr))
    set(value) = VkPhysicalDeviceProtectedMemoryFeatures.nsType(adr, value.i)
inline var VkPhysicalDeviceProtectedMemoryFeatures.next: Ptr
    get() = VkPhysicalDeviceProtectedMemoryFeatures.npNext(adr)
    set(value) = VkPhysicalDeviceProtectedMemoryFeatures.npNext(adr, value)
inline var VkPhysicalDeviceProtectedMemoryFeatures.protectedMemory: Boolean
    get() = VkPhysicalDeviceProtectedMemoryFeatures.nprotectedMemory(adr).bool
    set(value) = VkPhysicalDeviceProtectedMemoryFeatures.nprotectedMemory(adr, value.i)


inline var VkPhysicalDeviceProtectedMemoryProperties.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceProtectedMemoryProperties.nsType(adr))
    set(value) = VkPhysicalDeviceProtectedMemoryProperties.nsType(adr, value.i)
inline var VkPhysicalDeviceProtectedMemoryProperties.next: Ptr
    get() = VkPhysicalDeviceProtectedMemoryProperties.npNext(adr)
    set(value) = VkPhysicalDeviceProtectedMemoryProperties.npNext(adr, value)
inline val VkPhysicalDeviceProtectedMemoryProperties.protectedNoFault: Boolean
    get() = VkPhysicalDeviceProtectedMemoryProperties.nprotectedNoFault(adr).bool


inline var VkDeviceQueueInfo2.type: VkStructureType
    get() = VkStructureType(VkDeviceQueueInfo2.nsType(adr))
    set(value) = VkDeviceQueueInfo2.nsType(adr, value.i)
inline var VkDeviceQueueInfo2.next: Ptr
    get() = VkDeviceQueueInfo2.npNext(adr)
    set(value) = VkDeviceQueueInfo2.npNext(adr, value)
inline var VkDeviceQueueInfo2.flags: VkDeviceQueueCreateFlags
    get() = VkDeviceQueueInfo2.nflags(adr)
    set(value) = VkDeviceQueueInfo2.nflags(adr, value)
inline var VkDeviceQueueInfo2.queueFamilyIndex: Int
    get() = VkDeviceQueueInfo2.nqueueFamilyIndex(adr)
    set(value) = VkDeviceQueueInfo2.nqueueFamilyIndex(adr, value)
inline var VkDeviceQueueInfo2.queueIndex: Int
    get() = VkDeviceQueueInfo2.nqueueIndex(adr)
    set(value) = VkDeviceQueueInfo2.nqueueIndex(adr, value)


inline var VkProtectedSubmitInfo.type: VkStructureType
    get() = VkStructureType(VkProtectedSubmitInfo.nsType(adr))
    set(value) = VkProtectedSubmitInfo.nsType(adr, value.i)
inline var VkProtectedSubmitInfo.next: Ptr
    get() = VkProtectedSubmitInfo.npNext(adr)
    set(value) = VkProtectedSubmitInfo.npNext(adr, value)
inline var VkProtectedSubmitInfo.protectedSubmit: Boolean
    get() = VkProtectedSubmitInfo.nprotectedSubmit(adr).bool
    set(value) = VkProtectedSubmitInfo.nprotectedSubmit(adr, value.i)


inline var VkSamplerYcbcrConversionCreateInfo.type: VkStructureType
    get() = VkStructureType(VkSamplerYcbcrConversionCreateInfo.nsType(adr))
    set(value) = VkSamplerYcbcrConversionCreateInfo.nsType(adr, value.i)
inline var VkSamplerYcbcrConversionCreateInfo.next: Ptr
    get() = VkSamplerYcbcrConversionCreateInfo.npNext(adr)
    set(value) = VkSamplerYcbcrConversionCreateInfo.npNext(adr, value)
inline var VkSamplerYcbcrConversionCreateInfo.format: VkFormat
    get() = VkFormat(VkSamplerYcbcrConversionCreateInfo.nformat(adr))
    set(value) = VkSamplerYcbcrConversionCreateInfo.nformat(adr, value.i)
inline var VkSamplerYcbcrConversionCreateInfo.ycbcrModel: VkSamplerYcbcrModelConversion
    get() = VkSamplerYcbcrModelConversion(VkSamplerYcbcrConversionCreateInfo.nycbcrModel(adr))
    set(value) = VkSamplerYcbcrConversionCreateInfo.nycbcrModel(adr, value.i)
inline var VkSamplerYcbcrConversionCreateInfo.ycbcrRange: VkSamplerYcbcrRange
    get() = VkSamplerYcbcrRange(VkSamplerYcbcrConversionCreateInfo.nycbcrRange(adr))
    set(value) = VkSamplerYcbcrConversionCreateInfo.nycbcrRange(adr, value.i)
inline var VkSamplerYcbcrConversionCreateInfo.components: VkComponentMapping
    get() = VkSamplerYcbcrConversionCreateInfo.ncomponents(adr)
    set(value) = VkSamplerYcbcrConversionCreateInfo.ncomponents(adr, value)
inline var VkSamplerYcbcrConversionCreateInfo.xChromaOffset: VkChromaLocation
    get() = VkChromaLocation(VkSamplerYcbcrConversionCreateInfo.nxChromaOffset(adr))
    set(value) = VkSamplerYcbcrConversionCreateInfo.nxChromaOffset(adr, value.i)
inline var VkSamplerYcbcrConversionCreateInfo.yChromaOffset: VkChromaLocation
    get() = VkChromaLocation(VkSamplerYcbcrConversionCreateInfo.nyChromaOffset(adr))
    set(value) = VkSamplerYcbcrConversionCreateInfo.nyChromaOffset(adr, value.i)
inline var VkSamplerYcbcrConversionCreateInfo.chromaFilter: VkFilter
    get() = VkFilter(VkSamplerYcbcrConversionCreateInfo.nchromaFilter(adr))
    set(value) = VkSamplerYcbcrConversionCreateInfo.nchromaFilter(adr, value.i)
inline var VkSamplerYcbcrConversionCreateInfo.forceExplicitReconstruction: Boolean
    get() = VkSamplerYcbcrConversionCreateInfo.nforceExplicitReconstruction(adr).bool
    set(value) = VkSamplerYcbcrConversionCreateInfo.nforceExplicitReconstruction(adr, value.i)


inline var VkSamplerYcbcrConversionInfo.type: VkStructureType
    get() = VkStructureType(VkSamplerYcbcrConversionInfo.nsType(adr))
    set(value) = VkSamplerYcbcrConversionInfo.nsType(adr, value.i)
inline var VkSamplerYcbcrConversionInfo.next: Ptr
    get() = VkSamplerYcbcrConversionInfo.npNext(adr)
    set(value) = VkSamplerYcbcrConversionInfo.npNext(adr, value)
inline var VkSamplerYcbcrConversionInfo.conversion: VkSamplerYcbcrConversion
    get() = VkSamplerYcbcrConversion(VkSamplerYcbcrConversionInfo.nconversion(adr))
    set(value) = VkSamplerYcbcrConversionInfo.nconversion(adr, value.L)


inline var VkBindImagePlaneMemoryInfo.type: VkStructureType
    get() = VkStructureType(VkBindImagePlaneMemoryInfo.nsType(adr))
    set(value) = VkBindImagePlaneMemoryInfo.nsType(adr, value.i)
inline var VkBindImagePlaneMemoryInfo.next: Ptr
    get() = VkBindImagePlaneMemoryInfo.npNext(adr)
    set(value) = VkBindImagePlaneMemoryInfo.npNext(adr, value)
inline var VkBindImagePlaneMemoryInfo.planeAspect: VkImageAspect
    get() = VkImageAspect(VkBindImagePlaneMemoryInfo.nplaneAspect(adr))
    set(value) = VkBindImagePlaneMemoryInfo.nplaneAspect(adr, value.i)


inline var VkImagePlaneMemoryRequirementsInfo.type: VkStructureType
    get() = VkStructureType(VkImagePlaneMemoryRequirementsInfo.nsType(adr))
    set(value) = VkImagePlaneMemoryRequirementsInfo.nsType(adr, value.i)
inline var VkImagePlaneMemoryRequirementsInfo.next: Ptr
    get() = VkImagePlaneMemoryRequirementsInfo.npNext(adr)
    set(value) = VkImagePlaneMemoryRequirementsInfo.npNext(adr, value)
inline var VkImagePlaneMemoryRequirementsInfo.planeAspect: VkImageAspect
    get() = VkImageAspect(VkImagePlaneMemoryRequirementsInfo.nplaneAspect(adr))
    set(value) = VkImagePlaneMemoryRequirementsInfo.nplaneAspect(adr, value.i)


inline var VkPhysicalDeviceSamplerYcbcrConversionFeatures.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceSamplerYcbcrConversionFeatures.nsType(adr))
    set(value) = VkPhysicalDeviceSamplerYcbcrConversionFeatures.nsType(adr, value.i)
inline var VkPhysicalDeviceSamplerYcbcrConversionFeatures.next: Ptr
    get() = VkPhysicalDeviceSamplerYcbcrConversionFeatures.npNext(adr)
    set(value) = VkPhysicalDeviceSamplerYcbcrConversionFeatures.npNext(adr, value)
inline var VkPhysicalDeviceSamplerYcbcrConversionFeatures.samplerYcbcrConversion: Boolean
    get() = VkPhysicalDeviceSamplerYcbcrConversionFeatures.nsamplerYcbcrConversion(adr).bool
    set(value) = VkPhysicalDeviceSamplerYcbcrConversionFeatures.nsamplerYcbcrConversion(adr, value.i)


inline var VkSamplerYcbcrConversionImageFormatProperties.type: VkStructureType
    get() = VkStructureType(VkSamplerYcbcrConversionImageFormatProperties.nsType(adr))
    set(value) = VkSamplerYcbcrConversionImageFormatProperties.nsType(adr, value.i)
inline var VkSamplerYcbcrConversionImageFormatProperties.next: Ptr
    get() = VkSamplerYcbcrConversionImageFormatProperties.npNext(adr)
    set(value) = VkSamplerYcbcrConversionImageFormatProperties.npNext(adr, value)
inline val VkSamplerYcbcrConversionImageFormatProperties.combinedImageSamplerDescriptorCount: Int
    get() = VkSamplerYcbcrConversionImageFormatProperties.ncombinedImageSamplerDescriptorCount(adr)


inline var VkDescriptorUpdateTemplateEntry.dstBinding: Int
    get() = VkDescriptorUpdateTemplateEntry.ndstBinding(adr)
    set(value) = VkDescriptorUpdateTemplateEntry.ndstBinding(adr, value)
inline var VkDescriptorUpdateTemplateEntry.dstArrayElement: Int
    get() = VkDescriptorUpdateTemplateEntry.ndstArrayElement(adr)
    set(value) = VkDescriptorUpdateTemplateEntry.ndstArrayElement(adr, value)
inline var VkDescriptorUpdateTemplateEntry.descriptorCount: Int
    get() = VkDescriptorUpdateTemplateEntry.ndescriptorCount(adr)
    set(value) = VkDescriptorUpdateTemplateEntry.ndescriptorCount(adr, value)
inline var VkDescriptorUpdateTemplateEntry.descriptorType: VkDescriptorType
    get() = VkDescriptorType(VkDescriptorUpdateTemplateEntry.ndescriptorType(adr))
    set(value) = VkDescriptorUpdateTemplateEntry.ndescriptorType(adr, value.i)
inline var VkDescriptorUpdateTemplateEntry.offset: Long
    get() = VkDescriptorUpdateTemplateEntry.noffset(adr)
    set(value) = VkDescriptorUpdateTemplateEntry.noffset(adr, value)
inline var VkDescriptorUpdateTemplateEntry.stride: Long
    get() = VkDescriptorUpdateTemplateEntry.nstride(adr)
    set(value) = VkDescriptorUpdateTemplateEntry.nstride(adr, value)


inline var VkDescriptorUpdateTemplateCreateInfo.type: VkStructureType
    get() = VkStructureType(VkDescriptorUpdateTemplateCreateInfo.nsType(adr))
    set(value) = VkDescriptorUpdateTemplateCreateInfo.nsType(adr, value.i)
inline var VkDescriptorUpdateTemplateCreateInfo.next: Ptr
    get() = VkDescriptorUpdateTemplateCreateInfo.npNext(adr)
    set(value) = VkDescriptorUpdateTemplateCreateInfo.npNext(adr, value)
inline var VkDescriptorUpdateTemplateCreateInfo.flags: VkDescriptorUpdateTemplateCreateFlags
    get() = VkDescriptorUpdateTemplateCreateInfo.nflags(adr)
    set(value) = VkDescriptorUpdateTemplateCreateInfo.nflags(adr, value)
@Deprecated("this will be set automatically")
inline var VkDescriptorUpdateTemplateCreateInfo.descriptorUpdateEntryCount: Int
    get() = VkDescriptorUpdateTemplateCreateInfo.ndescriptorUpdateEntryCount(adr)
    set(value) = VkDescriptorUpdateTemplateCreateInfo.ndescriptorUpdateEntryCount(adr, value)
inline var VkDescriptorUpdateTemplateCreateInfo.descriptorUpdateEntries: VkDescriptorUpdateTemplateEntry.Buffer
    get() = VkDescriptorUpdateTemplateCreateInfo.npDescriptorUpdateEntries(adr)
    set(value) = VkDescriptorUpdateTemplateCreateInfo.npDescriptorUpdateEntries(adr, value)
inline var VkDescriptorUpdateTemplateCreateInfo.templateType: VkDescriptorUpdateTemplateType
    get() = VkDescriptorUpdateTemplateType(VkDescriptorUpdateTemplateCreateInfo.ntemplateType(adr))
    set(value) = VkDescriptorUpdateTemplateCreateInfo.ntemplateType(adr, value.i)
inline var VkDescriptorUpdateTemplateCreateInfo.descriptorSetLayout: VkDescriptorSetLayout
    get() = VkDescriptorSetLayout(VkDescriptorUpdateTemplateCreateInfo.ndescriptorSetLayout(adr))
    set(value) = VkDescriptorUpdateTemplateCreateInfo.ndescriptorSetLayout(adr, value.L)
inline var VkDescriptorUpdateTemplateCreateInfo.pipelineBindPoint: VkPipelineBindPoint
    get() = VkPipelineBindPoint(VkDescriptorUpdateTemplateCreateInfo.npipelineBindPoint(adr))
    set(value) = VkDescriptorUpdateTemplateCreateInfo.npipelineBindPoint(adr, value.i)
inline var VkDescriptorUpdateTemplateCreateInfo.pipelineLayout: VkPipelineLayout
    get() = VkPipelineLayout(VkDescriptorUpdateTemplateCreateInfo.npipelineLayout(adr))
    set(value) = VkDescriptorUpdateTemplateCreateInfo.npipelineLayout(adr, value.L)
inline var VkDescriptorUpdateTemplateCreateInfo.set: Int
    get() = VkDescriptorUpdateTemplateCreateInfo.nset(adr)
    set(value) = VkDescriptorUpdateTemplateCreateInfo.nset(adr, value)


inline val VkExternalMemoryProperties.externalMemoryFeatures: VkExternalMemoryFeatureFlags
    get() = VkExternalMemoryProperties.nexternalMemoryFeatures(adr)
inline val VkExternalMemoryProperties.exportFromImportedHandleTypes: VkExternalMemoryHandleTypeFlags
    get() = VkExternalMemoryProperties.nexportFromImportedHandleTypes(adr)
inline val VkExternalMemoryProperties.compatibleHandleTypes: VkExternalMemoryHandleTypeFlags
    get() = VkExternalMemoryProperties.ncompatibleHandleTypes(adr)


inline var VkPhysicalDeviceExternalImageFormatInfo.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceExternalImageFormatInfo.nsType(adr))
    set(value) = VkPhysicalDeviceExternalImageFormatInfo.nsType(adr, value.i)
inline var VkPhysicalDeviceExternalImageFormatInfo.next: Ptr
    get() = VkPhysicalDeviceExternalImageFormatInfo.npNext(adr)
    set(value) = VkPhysicalDeviceExternalImageFormatInfo.npNext(adr, value)
inline var VkPhysicalDeviceExternalImageFormatInfo.handleType: VkExternalMemoryHandleType
    get() = VkExternalMemoryHandleType(VkPhysicalDeviceExternalImageFormatInfo.nhandleType(adr))
    set(value) = VkPhysicalDeviceExternalImageFormatInfo.nhandleType(adr, value.i)


inline var VkExternalImageFormatProperties.type: VkStructureType
    get() = VkStructureType(VkExternalImageFormatProperties.nsType(adr))
    set(value) = VkExternalImageFormatProperties.nsType(adr, value.i)
inline var VkExternalImageFormatProperties.next: Ptr
    get() = VkExternalImageFormatProperties.npNext(adr)
    set(value) = VkExternalImageFormatProperties.npNext(adr, value)
inline val VkExternalImageFormatProperties.externalMemoryProperties: VkExternalMemoryProperties
    get() = VkExternalImageFormatProperties.nexternalMemoryProperties(adr)


inline var VkPhysicalDeviceExternalBufferInfo.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceExternalBufferInfo.nsType(adr))
    set(value) = VkPhysicalDeviceExternalBufferInfo.nsType(adr, value.i)
inline var VkPhysicalDeviceExternalBufferInfo.next: Ptr
    get() = VkPhysicalDeviceExternalBufferInfo.npNext(adr)
    set(value) = VkPhysicalDeviceExternalBufferInfo.npNext(adr, value)
inline var VkPhysicalDeviceExternalBufferInfo.flags: VkBufferCreateFlags
    get() = VkPhysicalDeviceExternalBufferInfo.nflags(adr)
    set(value) = VkPhysicalDeviceExternalBufferInfo.nflags(adr, value)
inline var VkPhysicalDeviceExternalBufferInfo.usage: VkBufferUsageFlags
    get() = VkPhysicalDeviceExternalBufferInfo.nusage(adr)
    set(value) = VkPhysicalDeviceExternalBufferInfo.nusage(adr, value)
inline var VkPhysicalDeviceExternalBufferInfo.handleType: VkExternalMemoryHandleType
    get() = VkExternalMemoryHandleType(VkPhysicalDeviceExternalBufferInfo.nhandleType(adr))
    set(value) = VkPhysicalDeviceExternalBufferInfo.nhandleType(adr, value.i)


inline var VkExternalBufferProperties.type: VkStructureType
    get() = VkStructureType(VkExternalBufferProperties.nsType(adr))
    set(value) = VkExternalBufferProperties.nsType(adr, value.i)
inline var VkExternalBufferProperties.next: Ptr
    get() = VkExternalBufferProperties.npNext(adr)
    set(value) = VkExternalBufferProperties.npNext(adr, value)
inline val VkExternalBufferProperties.externalMemoryProperties: VkExternalMemoryProperties
    get() = VkExternalBufferProperties.nexternalMemoryProperties(adr)


inline var VkPhysicalDeviceIDProperties.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceIDProperties.nsType(adr))
    set(value) = VkPhysicalDeviceIDProperties.nsType(adr, value.i)
inline var VkPhysicalDeviceIDProperties.next: Ptr
    get() = VkPhysicalDeviceIDProperties.npNext(adr)
    set(value) = VkPhysicalDeviceIDProperties.npNext(adr, value)
inline val VkPhysicalDeviceIDProperties.deviceUUID: ByteBuffer
    get() = VkPhysicalDeviceIDProperties.ndeviceUUID(adr)
inline val VkPhysicalDeviceIDProperties.driverUUID: ByteBuffer
    get() = VkPhysicalDeviceIDProperties.ndriverUUID(adr)
inline val VkPhysicalDeviceIDProperties.deviceLUID: ByteBuffer
    get() = VkPhysicalDeviceIDProperties.ndeviceLUID(adr)
inline val VkPhysicalDeviceIDProperties.deviceNodeMask: Int
    get() = VkPhysicalDeviceIDProperties.ndeviceNodeMask(adr)
inline val VkPhysicalDeviceIDProperties.deviceLUIDValid: Boolean
    get() = VkPhysicalDeviceIDProperties.ndeviceLUIDValid(adr).bool


inline var VkExternalMemoryImageCreateInfo.type: VkStructureType
    get() = VkStructureType(VkExternalMemoryImageCreateInfo.nsType(adr))
    set(value) = VkExternalMemoryImageCreateInfo.nsType(adr, value.i)
inline var VkExternalMemoryImageCreateInfo.next: Ptr
    get() = VkExternalMemoryImageCreateInfo.npNext(adr)
    set(value) = VkExternalMemoryImageCreateInfo.npNext(adr, value)
inline var VkExternalMemoryImageCreateInfo.handleTypes: VkExternalMemoryHandleTypeFlags
    get() = VkExternalMemoryImageCreateInfo.nhandleTypes(adr)
    set(value) = VkExternalMemoryImageCreateInfo.nhandleTypes(adr, value)


inline var VkExternalMemoryBufferCreateInfo.type: VkStructureType
    get() = VkStructureType(VkExternalMemoryBufferCreateInfo.nsType(adr))
    set(value) = VkExternalMemoryBufferCreateInfo.nsType(adr, value.i)
inline var VkExternalMemoryBufferCreateInfo.next: Ptr
    get() = VkExternalMemoryBufferCreateInfo.npNext(adr)
    set(value) = VkExternalMemoryBufferCreateInfo.npNext(adr, value)
inline var VkExternalMemoryBufferCreateInfo.handleTypes: VkExternalMemoryHandleTypeFlags
    get() = VkExternalMemoryBufferCreateInfo.nhandleTypes(adr)
    set(value) = VkExternalMemoryBufferCreateInfo.nhandleTypes(adr, value)


inline var VkExportMemoryAllocateInfo.type: VkStructureType
    get() = VkStructureType(VkExportMemoryAllocateInfo.nsType(adr))
    set(value) = VkExportMemoryAllocateInfo.nsType(adr, value.i)
inline var VkExportMemoryAllocateInfo.next: Ptr
    get() = VkExportMemoryAllocateInfo.npNext(adr)
    set(value) = VkExportMemoryAllocateInfo.npNext(adr, value)
inline var VkExportMemoryAllocateInfo.handleTypes: VkExternalMemoryHandleTypeFlags
    get() = VkExportMemoryAllocateInfo.nhandleTypes(adr)
    set(value) = VkExportMemoryAllocateInfo.nhandleTypes(adr, value)


inline var VkPhysicalDeviceExternalFenceInfo.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceExternalFenceInfo.nsType(adr))
    set(value) = VkPhysicalDeviceExternalFenceInfo.nsType(adr, value.i)
inline var VkPhysicalDeviceExternalFenceInfo.next: Ptr
    get() = VkPhysicalDeviceExternalFenceInfo.npNext(adr)
    set(value) = VkPhysicalDeviceExternalFenceInfo.npNext(adr, value)
inline var VkPhysicalDeviceExternalFenceInfo.handleType: VkExternalFenceHandleType
    get() = VkExternalFenceHandleType(VkPhysicalDeviceExternalFenceInfo.nhandleType(adr))
    set(value) = VkPhysicalDeviceExternalFenceInfo.nhandleType(adr, value.i)


inline var VkExternalFenceProperties.type: VkStructureType
    get() = VkStructureType(VkExternalFenceProperties.nsType(adr))
    set(value) = VkExternalFenceProperties.nsType(adr, value.i)
inline var VkExternalFenceProperties.next: Ptr
    get() = VkExternalFenceProperties.npNext(adr)
    set(value) = VkExternalFenceProperties.npNext(adr, value)
inline val VkExternalFenceProperties.exportFromImportedHandleTypes: VkExternalFenceHandleTypeFlags
    get() = VkExternalFenceProperties.nexportFromImportedHandleTypes(adr)
inline val VkExternalFenceProperties.compatibleHandleTypes: VkExternalFenceHandleTypeFlags
    get() = VkExternalFenceProperties.ncompatibleHandleTypes(adr)
inline val VkExternalFenceProperties.externalFenceFeatures: VkExternalFenceFeatureFlags
    get() = VkExternalFenceProperties.nexternalFenceFeatures(adr)


inline var VkExportFenceCreateInfo.type: VkStructureType
    get() = VkStructureType(VkExportFenceCreateInfo.nsType(adr))
    set(value) = VkExportFenceCreateInfo.nsType(adr, value.i)
inline var VkExportFenceCreateInfo.next: Ptr
    get() = VkExportFenceCreateInfo.npNext(adr)
    set(value) = VkExportFenceCreateInfo.npNext(adr, value)
inline var VkExportFenceCreateInfo.handleTypes: VkExternalFenceHandleTypeFlags
    get() = VkExportFenceCreateInfo.nhandleTypes(adr)
    set(value) = VkExportFenceCreateInfo.nhandleTypes(adr, value)


inline var VkExportSemaphoreCreateInfo.type: VkStructureType
    get() = VkStructureType(VkExportSemaphoreCreateInfo.nsType(adr))
    set(value) = VkExportSemaphoreCreateInfo.nsType(adr, value.i)
inline var VkExportSemaphoreCreateInfo.next: Ptr
    get() = VkExportSemaphoreCreateInfo.npNext(adr)
    set(value) = VkExportSemaphoreCreateInfo.npNext(adr, value)
inline var VkExportSemaphoreCreateInfo.handleTypes: VkExternalSemaphoreHandleTypeFlags
    get() = VkExportSemaphoreCreateInfo.nhandleTypes(adr)
    set(value) = VkExportSemaphoreCreateInfo.nhandleTypes(adr, value)


inline var VkPhysicalDeviceExternalSemaphoreInfo.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceExternalSemaphoreInfo.nsType(adr))
    set(value) = VkPhysicalDeviceExternalSemaphoreInfo.nsType(adr, value.i)
inline var VkPhysicalDeviceExternalSemaphoreInfo.next: Ptr
    get() = VkPhysicalDeviceExternalSemaphoreInfo.npNext(adr)
    set(value) = VkPhysicalDeviceExternalSemaphoreInfo.npNext(adr, value)
inline var VkPhysicalDeviceExternalSemaphoreInfo.handleType: VkExternalSemaphoreHandleType
    get() = VkExternalSemaphoreHandleType(VkPhysicalDeviceExternalSemaphoreInfo.nhandleType(adr))
    set(value) = VkPhysicalDeviceExternalSemaphoreInfo.nhandleType(adr, value.i)


inline var VkExternalSemaphoreProperties.type: VkStructureType
    get() = VkStructureType(VkExternalSemaphoreProperties.nsType(adr))
    set(value) = VkExternalSemaphoreProperties.nsType(adr, value.i)
inline var VkExternalSemaphoreProperties.next: Ptr
    get() = VkExternalSemaphoreProperties.npNext(adr)
    set(value) = VkExternalSemaphoreProperties.npNext(adr, value)
inline val VkExternalSemaphoreProperties.exportFromImportedHandleTypes: VkExternalSemaphoreHandleTypeFlags
    get() = VkExternalSemaphoreProperties.nexportFromImportedHandleTypes(adr)
inline val VkExternalSemaphoreProperties.compatibleHandleTypes: VkExternalSemaphoreHandleTypeFlags
    get() = VkExternalSemaphoreProperties.ncompatibleHandleTypes(adr)
inline val VkExternalSemaphoreProperties.externalSemaphoreFeatures: VkExternalSemaphoreFeatureFlags
    get() = VkExternalSemaphoreProperties.nexternalSemaphoreFeatures(adr)


inline var VkPhysicalDeviceMaintenance3Properties.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceMaintenance3Properties.nsType(adr))
    set(value) = VkPhysicalDeviceMaintenance3Properties.nsType(adr, value.i)
inline var VkPhysicalDeviceMaintenance3Properties.next: Ptr
    get() = VkPhysicalDeviceMaintenance3Properties.npNext(adr)
    set(value) = VkPhysicalDeviceMaintenance3Properties.npNext(adr, value)
inline val VkPhysicalDeviceMaintenance3Properties.maxPerSetDescriptors: Int
    get() = VkPhysicalDeviceMaintenance3Properties.nmaxPerSetDescriptors(adr)
inline val VkPhysicalDeviceMaintenance3Properties.maxMemoryAllocationSize: VkDeviceSize
    get() = VkDeviceSize(VkPhysicalDeviceMaintenance3Properties.nmaxMemoryAllocationSize(adr))


inline var VkDescriptorSetLayoutSupport.type: VkStructureType
    get() = VkStructureType(VkDescriptorSetLayoutSupport.nsType(adr))
    set(value) = VkDescriptorSetLayoutSupport.nsType(adr, value.i)
inline var VkDescriptorSetLayoutSupport.next: Ptr
    get() = VkDescriptorSetLayoutSupport.npNext(adr)
    set(value) = VkDescriptorSetLayoutSupport.npNext(adr, value)
inline val VkDescriptorSetLayoutSupport.supported: Boolean
    get() = VkDescriptorSetLayoutSupport.nsupported(adr).bool


inline var VkPhysicalDeviceShaderDrawParameterFeatures.type: VkStructureType
    get() = VkStructureType(VkPhysicalDeviceShaderDrawParameterFeatures.nsType(adr))
    set(value) = VkPhysicalDeviceShaderDrawParameterFeatures.nsType(adr, value.i)
inline var VkPhysicalDeviceShaderDrawParameterFeatures.next: Ptr
    get() = VkPhysicalDeviceShaderDrawParameterFeatures.npNext(adr)
    set(value) = VkPhysicalDeviceShaderDrawParameterFeatures.npNext(adr, value)
inline val VkPhysicalDeviceShaderDrawParameterFeatures.shaderDrawParameters: Boolean
    get() = VkPhysicalDeviceShaderDrawParameterFeatures.nshaderDrawParameters(adr).bool


inline class VkColorSpaceKHR(val i: Int) {
    companion object {
        val SRGB_NONLINEAR_KHR = VkColorSpaceKHR(0)
        val DISPLAY_P3_NONLINEAR_EXT = VkColorSpaceKHR(1000104001)
        val EXTENDED_SRGB_LINEAR_EXT = VkColorSpaceKHR(1000104002)
        val DCI_P3_LINEAR_EXT = VkColorSpaceKHR(1000104003)
        val DCI_P3_NONLINEAR_EXT = VkColorSpaceKHR(1000104004)
        val BT709_LINEAR_EXT = VkColorSpaceKHR(1000104005)
        val BT709_NONLINEAR_EXT = VkColorSpaceKHR(1000104006)
        val BT2020_LINEAR_EXT = VkColorSpaceKHR(1000104007)
        val HDR10_ST2084_EXT = VkColorSpaceKHR(1000104008)
        val DOLBYVISION_EXT = VkColorSpaceKHR(1000104009)
        val HDR10_HLG_EXT = VkColorSpaceKHR(1000104010)
        val ADOBERGB_LINEAR_EXT = VkColorSpaceKHR(1000104011)
        val ADOBERGB_NONLINEAR_EXT = VkColorSpaceKHR(1000104012)
        val PASS_THROUGH_EXT = VkColorSpaceKHR(1000104013)
        val EXTENDED_SRGB_NONLINEAR_EXT = VkColorSpaceKHR(1000104014)
    }
}