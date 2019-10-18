package vkk.extensionFunctions

import glm_.BYTES
import kool.Stack
import kool.adr
import kool.rem
import org.lwjgl.system.MemoryStack.stackGet
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.system.MemoryUtil.memGetInt
import org.lwjgl.vulkan.*
import vkk.VkResult
import vkk.entities.VkFence


fun VkQueue.getCheckpointDataNV(checkpointData: VkCheckpointDataNV.Buffer) =
        Stack.intAddress(checkpointData.rem) { NVDeviceDiagnosticCheckpoints.nvkGetQueueCheckpointDataNV(this, it, checkpointData.adr) }

inline fun <reified T> VkQueue.getCheckpointDataNV(): T = when (T::class) {
    Int::class -> Stack.intAddress {
        NVDeviceDiagnosticCheckpoints.nvkGetQueueCheckpointDataNV(this, it, NULL)
    } as T
    VkCheckpointDataNV.Buffer::class -> {
        val st = stackGet()
        val pCheckpointDataCount = st.nmalloc(4, Int.BYTES)
        NVDeviceDiagnosticCheckpoints.nvkGetQueueCheckpointDataNV(this, pCheckpointDataCount, NULL)
        val checkpointDataCount = memGetInt(pCheckpointDataCount)
        VkCheckpointDataNV.callocStack(checkpointDataCount, st).also {
            NVDeviceDiagnosticCheckpoints.nvkGetQueueCheckpointDataNV(this, pCheckpointDataCount, it.adr)
        } as T
    }
    else -> throw Exception("[VkQueue::getCheckpointDataNV] Invalid T")
}

fun VkQueue.beginDebugUtilsLabelEXT(labelInfo: VkDebugUtilsLabelEXT) =
        EXTDebugUtils.nvkQueueBeginDebugUtilsLabelEXT(this, labelInfo.adr)

fun VkQueue.bindSparse(bindInfo: VkBindSparseInfo.Buffer, fence: VkFence): VkResult =
        VkResult(VK10.nvkQueueBindSparse(this, bindInfo.rem, bindInfo.adr, fence.L)).apply { check() }

fun VkQueue.endDebugUtilsLabelEXT() =
        EXTDebugUtils.vkQueueEndDebugUtilsLabelEXT(this)

fun VkQueue.insertDebugUtilsLabelEXT(labelInfo: VkDebugUtilsLabelEXT) =
        EXTDebugUtils.nvkQueueInsertDebugUtilsLabelEXT(this, labelInfo.adr)

infix fun VkQueue.presentKHR(presentInfo: VkPresentInfoKHR): VkResult =
        VkResult(KHRSwapchain.vkQueuePresentKHR(this, presentInfo)).apply { check() }

//infix fun VkQueue.setPerformanceConfigurationINTEL(configuration: VkPerformanceConfigurationINTEL): VkResult = TODO
//        VkResult(nsetPerformanceConfigurationINTEL(this, configuration.adr)).apply { check() }

fun VkQueue.submit(submits: VkSubmitInfo, fence: VkFence): VkResult =
        VkResult(VK10.nvkQueueSubmit(this, 1, submits.adr, fence.L)).apply { check() }

infix fun VkQueue.submit(submits: VkSubmitInfo): VkResult = submit(submits, VkFence.NULL)

fun VkQueue.waitIdle(): VkResult =
        VkResult(VK10.vkQueueWaitIdle(this)).apply { check() }

// block result

fun VkQueue.presentKHR(presentInfo: VkPresentInfoKHR, block: (VkResult) -> Unit) =
        block(VkResult(KHRSwapchain.vkQueuePresentKHR(this, presentInfo)))

// lambda

fun VkQueue.debugUtilsLabelEXT(labelInfo: VkDebugUtilsLabelEXT, block: () -> Unit) {
    EXTDebugUtils.nvkQueueBeginDebugUtilsLabelEXT(this, labelInfo.adr)
    block()
    EXTDebugUtils.vkQueueEndDebugUtilsLabelEXT(this)
}