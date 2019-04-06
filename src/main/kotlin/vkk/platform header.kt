package vkk

import kool.Ptr
import kool.adr
import org.lwjgl.system.windows.SECURITY_ATTRIBUTES
import org.lwjgl.vulkan.*
import vkk.entities.*
import java.nio.IntBuffer
import java.nio.LongBuffer

// win32

typealias VkWin32SurfaceCreateFlagsKHR = VkFlags


inline var VkWin32SurfaceCreateInfoKHR.type: VkStructureType
    get() = VkStructureType(VkWin32SurfaceCreateInfoKHR.nsType(adr))
    set(value) = VkWin32SurfaceCreateInfoKHR.nsType(adr, value.i)
inline var VkWin32SurfaceCreateInfoKHR.next: Ptr
    get() = VkWin32SurfaceCreateInfoKHR.npNext(adr)
    set(value) = VkWin32SurfaceCreateInfoKHR.npNext(adr, value)
inline var VkWin32SurfaceCreateInfoKHR.flags: VkWin32SurfaceCreateFlagsKHR
    get() = VkWin32SurfaceCreateInfoKHR.nflags(adr)
    set(value) = VkWin32SurfaceCreateInfoKHR.nflags(adr, value)
inline var VkWin32SurfaceCreateInfoKHR.hinstance: HINSTANCE
    get() = HINSTANCE(VkWin32SurfaceCreateInfoKHR.nhinstance(adr))
    set(value) = VkWin32SurfaceCreateInfoKHR.nhinstance(adr, value.L)
inline var VkWin32SurfaceCreateInfoKHR.hwnd: HWND
    get() = HWND(VkWin32SurfaceCreateInfoKHR.nhinstance(adr))
    set(value) = VkWin32SurfaceCreateInfoKHR.nhinstance(adr, value.L)


inline var VkImportMemoryWin32HandleInfoKHR.type: VkStructureType
    get() = VkStructureType(VkImportMemoryWin32HandleInfoKHR.nsType(adr))
    set(value) = VkImportMemoryWin32HandleInfoKHR.nsType(adr, value.i)
inline var VkImportMemoryWin32HandleInfoKHR.next: Ptr
    get() = VkImportMemoryWin32HandleInfoKHR.npNext(adr)
    set(value) = VkImportMemoryWin32HandleInfoKHR.npNext(adr, value)
inline var VkImportMemoryWin32HandleInfoKHR.handleType: VkExternalMemoryHandleType
    get() = VkExternalMemoryHandleType(VkImportMemoryWin32HandleInfoKHR.nhandleType(adr))
    set(value) = VkImportMemoryWin32HandleInfoKHR.nhandleType(adr, value.i)
inline var VkImportMemoryWin32HandleInfoKHR.handle: HANDLE
    get() = HANDLE(VkImportMemoryWin32HandleInfoKHR.nhandle(adr))
    set(value) = VkImportMemoryWin32HandleInfoKHR.nhandle(adr, value.L)
inline var VkImportMemoryWin32HandleInfoKHR.name: String
    get() = VkImportMemoryWin32HandleInfoKHR.nnameString(adr)
    set(value) = stak.asciiBuffer(value) { VkImportMemoryWin32HandleInfoKHR.nname(adr, it) }


inline var VkExportMemoryWin32HandleInfoKHR.type: VkStructureType
    get() = VkStructureType(VkExportMemoryWin32HandleInfoKHR.nsType(adr))
    set(value) = VkExportMemoryWin32HandleInfoKHR.nsType(adr, value.i)
inline var VkExportMemoryWin32HandleInfoKHR.next: Ptr
    get() = VkExportMemoryWin32HandleInfoKHR.npNext(adr)
    set(value) = VkExportMemoryWin32HandleInfoKHR.npNext(adr, value)
inline var VkExportMemoryWin32HandleInfoKHR.pAttributes: SECURITY_ATTRIBUTES?
    get() = VkExportMemoryWin32HandleInfoKHR.npAttributes(adr)
    set(value) = VkExportMemoryWin32HandleInfoKHR.npAttributes(adr, value)
inline var VkExportMemoryWin32HandleInfoKHR.dwAccess: DWORD
    get() = DWORD(VkExportMemoryWin32HandleInfoKHR.ndwAccess(adr))
    set(value) = VkExportMemoryWin32HandleInfoKHR.ndwAccess(adr, value.i)
inline var VkExportMemoryWin32HandleInfoKHR.name: String
    get() = VkExportMemoryWin32HandleInfoKHR.nnameString(adr)
    set(value) = stak.asciiBuffer(value) { VkExportMemoryWin32HandleInfoKHR.nname(adr, it) }


inline var VkMemoryWin32HandlePropertiesKHR.type: VkStructureType
    get() = VkStructureType(VkMemoryWin32HandlePropertiesKHR.nsType(adr))
    set(value) = VkMemoryWin32HandlePropertiesKHR.nsType(adr, value.i)
inline var VkMemoryWin32HandlePropertiesKHR.next: Ptr
    get() = VkMemoryWin32HandlePropertiesKHR.npNext(adr)
    set(value) = VkMemoryWin32HandlePropertiesKHR.npNext(adr, value)
inline val VkMemoryWin32HandlePropertiesKHR.memoryTypeBits: Int
    get() = VkMemoryWin32HandlePropertiesKHR.nmemoryTypeBits(adr)


inline var VkMemoryGetWin32HandleInfoKHR.type: VkStructureType
    get() = VkStructureType(VkMemoryGetWin32HandleInfoKHR.nsType(adr))
    set(value) = VkMemoryGetWin32HandleInfoKHR.nsType(adr, value.i)
inline var VkMemoryGetWin32HandleInfoKHR.next: Ptr
    get() = VkMemoryGetWin32HandleInfoKHR.npNext(adr)
    set(value) = VkMemoryGetWin32HandleInfoKHR.npNext(adr, value)
inline var VkMemoryGetWin32HandleInfoKHR.memory: VkDeviceMemory
    get() = VkDeviceMemory(VkMemoryGetWin32HandleInfoKHR.nmemory(adr))
    set(value) = VkMemoryGetWin32HandleInfoKHR.nmemory(adr, value.L)
inline var VkMemoryGetWin32HandleInfoKHR.handleType: VkExternalMemoryHandleType
    get() = VkExternalMemoryHandleType(VkMemoryGetWin32HandleInfoKHR.nhandleType(adr))
    set(value) = VkMemoryGetWin32HandleInfoKHR.nhandleType(adr, value.i)


inline var VkWin32KeyedMutexAcquireReleaseInfoKHR.type: VkStructureType
    get() = VkStructureType(VkWin32KeyedMutexAcquireReleaseInfoKHR.nsType(adr))
    set(value) = VkWin32KeyedMutexAcquireReleaseInfoKHR.nsType(adr, value.i)
inline var VkWin32KeyedMutexAcquireReleaseInfoKHR.next: Ptr
    get() = VkWin32KeyedMutexAcquireReleaseInfoKHR.npNext(adr)
    set(value) = VkWin32KeyedMutexAcquireReleaseInfoKHR.npNext(adr, value)
inline var VkWin32KeyedMutexAcquireReleaseInfoKHR.acquireCount: Int
    get() = VkWin32KeyedMutexAcquireReleaseInfoKHR.nacquireCount(adr)
    set(value) = VkWin32KeyedMutexAcquireReleaseInfoKHR.nacquireCount(adr, value)
inline var VkWin32KeyedMutexAcquireReleaseInfoKHR.acquireSyncs: VkDeviceMemory_Buffer?
    get() = VkWin32KeyedMutexAcquireReleaseInfoKHR.npAcquireSyncs(adr)?.let(::VkDeviceMemory_Buffer)
    set(value) = VkWin32KeyedMutexAcquireReleaseInfoKHR.npAcquireSyncs(adr, value?.buffer)
inline var VkWin32KeyedMutexAcquireReleaseInfoKHR.acquireKeys: LongBuffer?
    get() = VkWin32KeyedMutexAcquireReleaseInfoKHR.npAcquireKeys(adr)
    set(value) = VkWin32KeyedMutexAcquireReleaseInfoKHR.npAcquireKeys(adr, value)
inline var VkWin32KeyedMutexAcquireReleaseInfoKHR.acquireTimeouts: IntBuffer?
    get() = VkWin32KeyedMutexAcquireReleaseInfoKHR.npAcquireTimeouts(adr)
    set(value) = VkWin32KeyedMutexAcquireReleaseInfoKHR.npAcquireTimeouts(adr, value)
inline var VkWin32KeyedMutexAcquireReleaseInfoKHR.releaseCount: Int
    get() = VkWin32KeyedMutexAcquireReleaseInfoKHR.nreleaseCount(adr)
    set(value) = VkWin32KeyedMutexAcquireReleaseInfoKHR.nreleaseCount(adr, value)
inline var VkWin32KeyedMutexAcquireReleaseInfoKHR.releaseSyncs: VkDeviceMemory_Buffer?
    get() = VkWin32KeyedMutexAcquireReleaseInfoKHR.npReleaseSyncs(adr)?.let(::VkDeviceMemory_Buffer)
    set(value) = VkWin32KeyedMutexAcquireReleaseInfoKHR.npReleaseSyncs(adr, value?.buffer)
inline var VkWin32KeyedMutexAcquireReleaseInfoKHR.releaseKeys: LongBuffer?
    get() = VkWin32KeyedMutexAcquireReleaseInfoKHR.npReleaseKeys(adr)
    set(value) = VkWin32KeyedMutexAcquireReleaseInfoKHR.npReleaseKeys(adr, value)


inline var VkImportSemaphoreWin32HandleInfoKHR.type: VkStructureType
    get() = VkStructureType(VkImportSemaphoreWin32HandleInfoKHR.nsType(adr))
    set(value) = VkImportSemaphoreWin32HandleInfoKHR.nsType(adr, value.i)
inline var VkImportSemaphoreWin32HandleInfoKHR.next: Ptr
    get() = VkImportSemaphoreWin32HandleInfoKHR.npNext(adr)
    set(value) = VkImportSemaphoreWin32HandleInfoKHR.npNext(adr, value)
inline var VkImportSemaphoreWin32HandleInfoKHR.semaphore: VkSemaphore
    get() = VkSemaphore(VkImportSemaphoreWin32HandleInfoKHR.nsemaphore(adr))
    set(value) = VkImportSemaphoreWin32HandleInfoKHR.nsemaphore(adr, value.L)
inline var VkImportSemaphoreWin32HandleInfoKHR.flags: VkSemaphoreImportFlags
    get() = VkImportSemaphoreWin32HandleInfoKHR.nflags(adr)
    set(value) = VkImportSemaphoreWin32HandleInfoKHR.nflags(adr, value)
inline var VkImportSemaphoreWin32HandleInfoKHR.handleType: VkExternalSemaphoreHandleType
    get() = VkExternalSemaphoreHandleType(VkImportSemaphoreWin32HandleInfoKHR.nhandleType(adr))
    set(value) = VkImportSemaphoreWin32HandleInfoKHR.nhandleType(adr, value.i)
inline var VkImportSemaphoreWin32HandleInfoKHR.handle: HANDLE
    get() = HANDLE(VkImportSemaphoreWin32HandleInfoKHR.nhandle(adr))
    set(value) = VkImportSemaphoreWin32HandleInfoKHR.nhandle(adr, value.L)
inline var VkImportSemaphoreWin32HandleInfoKHR.name: String
    get() = VkImportSemaphoreWin32HandleInfoKHR.nnameString(adr)
    set(value) = VkImportSemaphoreWin32HandleInfoKHR.nname(adr, value.toUtf8Stack())


inline var VkExportSemaphoreWin32HandleInfoKHR.type: VkStructureType
    get() = VkStructureType(VkExportSemaphoreWin32HandleInfoKHR.nsType(adr))
    set(value) = VkExportSemaphoreWin32HandleInfoKHR.nsType(adr, value.i)
inline var VkExportSemaphoreWin32HandleInfoKHR.next: Ptr
    get() = VkExportSemaphoreWin32HandleInfoKHR.npNext(adr)
    set(value) = VkExportSemaphoreWin32HandleInfoKHR.npNext(adr, value)
inline var VkExportSemaphoreWin32HandleInfoKHR.attributes: SECURITY_ATTRIBUTES?
    get() = VkExportSemaphoreWin32HandleInfoKHR.npAttributes(adr)
    set(value) = VkExportSemaphoreWin32HandleInfoKHR.npAttributes(adr, value)
inline var VkExportSemaphoreWin32HandleInfoKHR.dwAccess: DWORD
    get() = DWORD(VkExportSemaphoreWin32HandleInfoKHR.ndwAccess(adr))
    set(value) = VkExportSemaphoreWin32HandleInfoKHR.ndwAccess(adr, value.i)
inline var VkExportSemaphoreWin32HandleInfoKHR.name: String
    get() = VkExportSemaphoreWin32HandleInfoKHR.nnameString(adr)
    set(value) = VkExportSemaphoreWin32HandleInfoKHR.nname(adr, value.toUtf8Stack())


inline var VkD3D12FenceSubmitInfoKHR.type: VkStructureType
    get() = VkStructureType(VkD3D12FenceSubmitInfoKHR.nsType(adr))
    set(value) = VkD3D12FenceSubmitInfoKHR.nsType(adr, value.i)
inline var VkD3D12FenceSubmitInfoKHR.next: Ptr
    get() = VkD3D12FenceSubmitInfoKHR.npNext(adr)
    set(value) = VkD3D12FenceSubmitInfoKHR.npNext(adr, value)
inline var VkD3D12FenceSubmitInfoKHR.waitSemaphoreValuesCount: Int
    get() = VkD3D12FenceSubmitInfoKHR.nwaitSemaphoreValuesCount(adr)
    @Deprecated("this will be set automatically")
    set(value) = VkD3D12FenceSubmitInfoKHR.nwaitSemaphoreValuesCount(adr, value)
inline var VkD3D12FenceSubmitInfoKHR.waitSemaphoreValues: VkSemaphore_Buffer?
    get() = VkD3D12FenceSubmitInfoKHR.npWaitSemaphoreValues(adr)?.let(::VkSemaphore_Buffer)
    set(value) = VkD3D12FenceSubmitInfoKHR.npWaitSemaphoreValues(adr, value?.buffer)
inline var VkD3D12FenceSubmitInfoKHR.signalSemaphoreValuesCount: Int
    get() = VkD3D12FenceSubmitInfoKHR.nsignalSemaphoreValuesCount(adr)
    @Deprecated("this will be set automatically")
    set(value) = VkD3D12FenceSubmitInfoKHR.nsignalSemaphoreValuesCount(adr, value)
inline var VkD3D12FenceSubmitInfoKHR.pSignalSemaphoreValues: VkSemaphore_Buffer?
    get() = VkD3D12FenceSubmitInfoKHR.npSignalSemaphoreValues(adr)?.let(::VkSemaphore_Buffer)
    set(value) = VkD3D12FenceSubmitInfoKHR.npSignalSemaphoreValues(adr, value?.buffer)


inline var VkSemaphoreGetWin32HandleInfoKHR.type: VkStructureType
    get() = VkStructureType(VkSemaphoreGetWin32HandleInfoKHR.nsType(adr))
    set(value) = VkSemaphoreGetWin32HandleInfoKHR.nsType(adr, value.i)
inline var VkSemaphoreGetWin32HandleInfoKHR.next: Ptr
    get() = VkSemaphoreGetWin32HandleInfoKHR.npNext(adr)
    set(value) = VkSemaphoreGetWin32HandleInfoKHR.npNext(adr, value)
inline var VkSemaphoreGetWin32HandleInfoKHR.semaphore: VkSemaphore
    get() = VkSemaphore(VkSemaphoreGetWin32HandleInfoKHR.nsemaphore(adr))
    set(value) = VkSemaphoreGetWin32HandleInfoKHR.nsemaphore(adr, value.L)
inline var VkSemaphoreGetWin32HandleInfoKHR.handleType: VkExternalSemaphoreHandleType
    get() = VkExternalSemaphoreHandleType(VkSemaphoreGetWin32HandleInfoKHR.nhandleType(adr))
    set(value) = VkSemaphoreGetWin32HandleInfoKHR.nhandleType(adr, value.i)


inline var VkImportFenceWin32HandleInfoKHR.type: VkStructureType
    get() = VkStructureType(VkImportFenceWin32HandleInfoKHR.nsType(adr))
    set(value) = VkImportFenceWin32HandleInfoKHR.nsType(adr, value.i)
inline var VkImportFenceWin32HandleInfoKHR.next: Ptr
    get() = VkImportFenceWin32HandleInfoKHR.npNext(adr)
    set(value) = VkImportFenceWin32HandleInfoKHR.npNext(adr, value)
inline var VkImportFenceWin32HandleInfoKHR.fence: VkFence
    get() = VkFence(VkImportFenceWin32HandleInfoKHR.nfence(adr))
    set(value) = VkImportFenceWin32HandleInfoKHR.nfence(adr, value.L)
inline var VkImportFenceWin32HandleInfoKHR.flags: VkFenceImportFlags
    get() = VkImportFenceWin32HandleInfoKHR.nflags(adr)
    set(value) = VkImportFenceWin32HandleInfoKHR.nflags(adr, value)
inline var VkImportFenceWin32HandleInfoKHR.handleType: VkExternalFenceHandleType
    get() = VkExternalFenceHandleType(VkImportFenceWin32HandleInfoKHR.nhandleType(adr))
    set(value) = VkImportFenceWin32HandleInfoKHR.nhandleType(adr, value.i)
inline var VkImportFenceWin32HandleInfoKHR.handle: HANDLE
    get() = HANDLE(VkImportFenceWin32HandleInfoKHR.nhandle(adr))
    set(value) = VkImportFenceWin32HandleInfoKHR.nhandle(adr, value.L)
inline var VkImportFenceWin32HandleInfoKHR.name: String
    get() = VkImportFenceWin32HandleInfoKHR.nnameString(adr)
    set(value) = VkImportFenceWin32HandleInfoKHR.nname(adr, value.toUtf8Stack())


inline var VkExportFenceWin32HandleInfoKHR.type: VkStructureType
    get() = VkStructureType(VkExportFenceWin32HandleInfoKHR.nsType(adr))
    set(value) = VkExportFenceWin32HandleInfoKHR.nsType(adr, value.i)
inline var VkExportFenceWin32HandleInfoKHR.next: Ptr
    get() = VkExportFenceWin32HandleInfoKHR.npNext(adr)
    set(value) = VkExportFenceWin32HandleInfoKHR.npNext(adr, value)
inline var VkExportFenceWin32HandleInfoKHR.attributes: SECURITY_ATTRIBUTES?
    get() = VkExportFenceWin32HandleInfoKHR.npAttributes(adr)
    set(value) = VkExportFenceWin32HandleInfoKHR.npAttributes(adr, value)
inline var VkExportFenceWin32HandleInfoKHR.dwAccess: DWORD
    get() = DWORD(VkExportFenceWin32HandleInfoKHR.ndwAccess(adr))
    set(value) = VkExportFenceWin32HandleInfoKHR.ndwAccess(adr, value.i)
inline var VkExportFenceWin32HandleInfoKHR.name: String
    get() = VkExportFenceWin32HandleInfoKHR.nnameString(adr)
    set(value) = VkExportFenceWin32HandleInfoKHR.nname(adr, value.toUtf8Stack())


inline var VkFenceGetWin32HandleInfoKHR.type: VkStructureType
    get() = VkStructureType(VkFenceGetWin32HandleInfoKHR.nsType(adr))
    set(value) = VkFenceGetWin32HandleInfoKHR.nsType(adr, value.i)
inline var VkFenceGetWin32HandleInfoKHR.next: Ptr
    get() = VkFenceGetWin32HandleInfoKHR.npNext(adr)
    set(value) = VkFenceGetWin32HandleInfoKHR.npNext(adr, value)
inline var VkFenceGetWin32HandleInfoKHR.fence: VkFence
    get() = VkFence(VkFenceGetWin32HandleInfoKHR.nfence(adr))
    set(value) = VkFenceGetWin32HandleInfoKHR.nfence(adr, value.L)
inline var VkFenceGetWin32HandleInfoKHR.handleType: VkExternalFenceHandleType
    get() = VkExternalFenceHandleType(VkFenceGetWin32HandleInfoKHR.nhandleType(adr))
    set(value) = VkFenceGetWin32HandleInfoKHR.nhandleType(adr, value.i)


inline var VkImportMemoryWin32HandleInfoNV.type: VkStructureType
    get() = VkStructureType(VkImportMemoryWin32HandleInfoNV.nsType(adr))
    set(value) = VkImportMemoryWin32HandleInfoNV.nsType(adr, value.i)
inline var VkImportMemoryWin32HandleInfoNV.next: Ptr
    get() = VkImportMemoryWin32HandleInfoNV.npNext(adr)
    set(value) = VkImportMemoryWin32HandleInfoNV.npNext(adr, value)
inline var VkImportMemoryWin32HandleInfoNV.handleType: VkExternalMemoryHandleTypeFlagsNV
    get() = VkImportMemoryWin32HandleInfoNV.nhandleType(adr)
    set(value) = VkImportMemoryWin32HandleInfoNV.nhandleType(adr, value)
inline var VkImportMemoryWin32HandleInfoNV.handle: HANDLE
    get() = HANDLE(VkImportMemoryWin32HandleInfoNV.nhandle(adr))
    set(value) = VkImportMemoryWin32HandleInfoNV.nhandle(adr, value.L)


inline var VkExportMemoryWin32HandleInfoNV.type: VkStructureType
    get() = VkStructureType(VkExportMemoryWin32HandleInfoNV.nsType(adr))
    set(value) = VkExportMemoryWin32HandleInfoNV.nsType(adr, value.i)
inline var VkExportMemoryWin32HandleInfoNV.next: Ptr
    get() = VkExportMemoryWin32HandleInfoNV.npNext(adr)
    set(value) = VkExportMemoryWin32HandleInfoNV.npNext(adr, value)
inline var VkExportMemoryWin32HandleInfoNV.attributes: SECURITY_ATTRIBUTES?
    get() = VkExportMemoryWin32HandleInfoNV.npAttributes(adr)
    set(value) = VkExportMemoryWin32HandleInfoNV.npAttributes(adr, value)
inline var VkExportMemoryWin32HandleInfoNV.dwAccess: DWORD
    get() = DWORD(VkExportMemoryWin32HandleInfoNV.ndwAccess(adr))
    set(value) = VkExportMemoryWin32HandleInfoNV.ndwAccess(adr, value.i)


inline var VkWin32KeyedMutexAcquireReleaseInfoNV.type: VkStructureType
    get() = VkStructureType(VkWin32KeyedMutexAcquireReleaseInfoNV.nsType(adr))
    set(value) = VkWin32KeyedMutexAcquireReleaseInfoNV.nsType(adr, value.i)
inline var VkWin32KeyedMutexAcquireReleaseInfoNV.next: Ptr
    get() = VkWin32KeyedMutexAcquireReleaseInfoNV.npNext(adr)
    set(value) = VkWin32KeyedMutexAcquireReleaseInfoNV.npNext(adr, value)
inline var VkWin32KeyedMutexAcquireReleaseInfoNV.acquireCount: Int
    get() = VkWin32KeyedMutexAcquireReleaseInfoNV.nacquireCount(adr)
    set(value) = VkWin32KeyedMutexAcquireReleaseInfoNV.nacquireCount(adr, value)
inline var VkWin32KeyedMutexAcquireReleaseInfoNV.acquireSyncs: VkDeviceMemory_Buffer?
    get() = VkWin32KeyedMutexAcquireReleaseInfoNV.npAcquireSyncs(adr)?.let(::VkDeviceMemory_Buffer)
    set(value) = VkWin32KeyedMutexAcquireReleaseInfoNV.npAcquireSyncs(adr, value?.buffer)
inline var VkWin32KeyedMutexAcquireReleaseInfoNV.acquireKeys: LongBuffer?
    get() = VkWin32KeyedMutexAcquireReleaseInfoNV.npAcquireKeys(adr)
    set(value) = VkWin32KeyedMutexAcquireReleaseInfoNV.npAcquireKeys(adr, value)
inline var VkWin32KeyedMutexAcquireReleaseInfoNV.acquireTimeoutMilliseconds: IntBuffer?
    get() = VkWin32KeyedMutexAcquireReleaseInfoNV.npAcquireTimeoutMilliseconds(adr)
    set(value) = VkWin32KeyedMutexAcquireReleaseInfoNV.npAcquireTimeoutMilliseconds(adr, value)
inline var VkWin32KeyedMutexAcquireReleaseInfoNV.releaseCount: Int
    get() = VkWin32KeyedMutexAcquireReleaseInfoNV.nreleaseCount(adr)
    set(value) = VkWin32KeyedMutexAcquireReleaseInfoNV.nreleaseCount(adr, value)
inline var VkWin32KeyedMutexAcquireReleaseInfoNV.releaseSyncs: VkDeviceMemory_Buffer?
    get() = VkWin32KeyedMutexAcquireReleaseInfoNV.npReleaseSyncs(adr)?.let(::VkDeviceMemory_Buffer)
    set(value) = VkWin32KeyedMutexAcquireReleaseInfoNV.npReleaseSyncs(adr, value?.buffer)
inline var VkWin32KeyedMutexAcquireReleaseInfoNV.releaseKeys: LongBuffer?
    get() = VkWin32KeyedMutexAcquireReleaseInfoNV.npReleaseKeys(adr)
    set(value) = VkWin32KeyedMutexAcquireReleaseInfoNV.npReleaseKeys(adr, value)


// macosx


typealias VkMacOSSurfaceCreateFlagsMVK = VkFlags


inline var VkMacOSSurfaceCreateInfoMVK.type: VkStructureType
    get() = VkStructureType(VkMacOSSurfaceCreateInfoMVK.nsType(adr))
    set(value) = VkMacOSSurfaceCreateInfoMVK.nsType(adr, value.i)
inline var VkMacOSSurfaceCreateInfoMVK.next: Ptr
    get() = VkMacOSSurfaceCreateInfoMVK.npNext(adr)
    set(value) = VkMacOSSurfaceCreateInfoMVK.npNext(adr, value)
inline var VkMacOSSurfaceCreateInfoMVK.flags: VkMacOSSurfaceCreateFlagsMVK
    get() = VkMacOSSurfaceCreateInfoMVK.nflags(adr)
    set(value) = VkMacOSSurfaceCreateInfoMVK.nflags(adr, value)
inline var VkMacOSSurfaceCreateInfoMVK.view: Ptr
    get() = VkMacOSSurfaceCreateInfoMVK.npView(adr)
    set(value) = VkMacOSSurfaceCreateInfoMVK.npView(adr, value)


// wayland


typealias VkWaylandSurfaceCreateFlagsKHR = VkFlags


inline var VkWaylandSurfaceCreateInfoKHR.type: VkStructureType
    get() = VkStructureType(VkWaylandSurfaceCreateInfoKHR.nsType(adr))
    set(value) = VkWaylandSurfaceCreateInfoKHR.nsType(adr, value.i)
inline var VkWaylandSurfaceCreateInfoKHR.next: Ptr
    get() = VkWaylandSurfaceCreateInfoKHR.npNext(adr)
    set(value) = VkWaylandSurfaceCreateInfoKHR.npNext(adr, value)
inline var VkWaylandSurfaceCreateInfoKHR.flags: VkWaylandSurfaceCreateFlagsKHR
    get() = VkWaylandSurfaceCreateInfoKHR.nflags(adr)
    set(value) = VkWaylandSurfaceCreateInfoKHR.nflags(adr, value)
inline var VkWaylandSurfaceCreateInfoKHR.display: WLDisplay
    get() = WLDisplay(VkWaylandSurfaceCreateInfoKHR.ndisplay(adr))
    set(value) = VkWaylandSurfaceCreateInfoKHR.ndisplay(adr, value.L)
inline var VkWaylandSurfaceCreateInfoKHR.surface: WLSurface
    get() = WLSurface(VkWaylandSurfaceCreateInfoKHR.nsurface(adr))
    set(value) = VkWaylandSurfaceCreateInfoKHR.nsurface(adr, value.L)


// xlib


typealias VkXlibSurfaceCreateFlagsKHR = VkFlags


inline var VkXlibSurfaceCreateInfoKHR.type: VkStructureType
    get() = VkStructureType(VkXlibSurfaceCreateInfoKHR.nsType(adr))
    set(value) = VkXlibSurfaceCreateInfoKHR.nsType(adr, value.i)
inline var VkXlibSurfaceCreateInfoKHR.next: Ptr
    get() = VkXlibSurfaceCreateInfoKHR.npNext(adr)
    set(value) = VkXlibSurfaceCreateInfoKHR.npNext(adr, value)
inline var VkXlibSurfaceCreateInfoKHR.flags: VkXlibSurfaceCreateFlagsKHR
    get() = VkXlibSurfaceCreateInfoKHR.nflags(adr)
    set(value) = VkXlibSurfaceCreateInfoKHR.nflags(adr, value)
inline var VkXlibSurfaceCreateInfoKHR.dpy: Display
    get() = Display(VkXlibSurfaceCreateInfoKHR.ndpy(adr))
    set(value) = VkXlibSurfaceCreateInfoKHR.ndpy(adr, value.L)
inline var VkXlibSurfaceCreateInfoKHR.window: Window
    get() = Window(VkXlibSurfaceCreateInfoKHR.nwindow(adr))
    set(value) = VkXlibSurfaceCreateInfoKHR.nwindow(adr, value.L)