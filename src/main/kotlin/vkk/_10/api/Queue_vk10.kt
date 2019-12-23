package vkk._10.api

import vkk.identifiers.CapabilitiesDevice
import kool.adr
import org.lwjgl.system.JNI.*
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.Pointer
import vkk.VkResult
import vkk._10.structs.BindSparseInfo
import vkk._10.structs.PresentInfoKHR
import vkk._10.structs.SubmitInfo
import vkk._10.structs.write
import vkk.entities.VkFence
import vkk.framed
import vkk.stak

interface Queue_vk10 : Pointer {

    val capabilities: CapabilitiesDevice

    // --- [ vkQueueBindSparse ] ---

    fun MemoryStack.bindSparse(bindInfos: Array<BindSparseInfo>, fence: VkFence = VkFence.NULL): VkResult =
            framed { VkResult(callPPJI(adr, bindInfos.size, bindInfos write this, fence.L, capabilities.vkQueueBindSparse)) }

    fun bindSparse(bindInfos: Array<BindSparseInfo>, fence: VkFence = VkFence.NULL): VkResult =
            stak { it.bindSparse(bindInfos, fence) }

    // --- [ vkQueuePresentKHR ] ---

    infix fun MemoryStack.presentKHR(presentInfo: PresentInfoKHR): VkResult =
            framed { presentInfo.native(this) { pPresentInfo -> VkResult(callPPI(adr, pPresentInfo, capabilities.vkQueuePresentKHR)).andCheck() } }

    infix fun presentKHR(presentInfo: PresentInfoKHR): VkResult =
            stak { it presentKHR presentInfo }

    // --- [ vkQueueSubmit ] ---

    fun MemoryStack.submit(submit: SubmitInfo, fence: VkFence = VkFence.NULL): VkResult =
            framed { VkResult(callPPJI(adr, 1, submit write this, fence.L, capabilities.vkQueueSubmit)).andCheck() }

    fun submit(submit: SubmitInfo, fence: VkFence = VkFence.NULL): VkResult =
            stak { it.submit(submit, fence) }

    // --- [ vkQueueWaitIdle ] ---
    fun waitIdle(): VkResult =
            VkResult(callPI(adr, capabilities.vkQueueWaitIdle)).andCheck()
}