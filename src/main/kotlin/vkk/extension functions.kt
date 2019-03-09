package vkk

import glm_.*
import glm_.vec2.Vec2i
import kool.*
import org.lwjgl.PointerBuffer
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.system.Pointer
import org.lwjgl.vulkan.*
import vkk.entities.*
import vkk.extensionFunctions.begin
import java.nio.Buffer
import java.nio.IntBuffer
import java.nio.LongBuffer






// VkQueue =========================================================================================================

infix fun VkQueue.presentKHR(presentInfo: VkPresentInfoKHR) = VK_CHECK_RESULT(KHRSwapchain.vkQueuePresentKHR(this, presentInfo))
fun VkQueue.presentKHR(presentInfo: VkPresentInfoKHR, block: (VkResult) -> Unit) = block(VkResult(KHRSwapchain.vkQueuePresentKHR(this, presentInfo)))

infix fun VkQueue.submit(submits: VkSubmitInfo) = VK_CHECK_RESULT(VK10.nvkQueueSubmit(this, 1, submits.adr, MemoryUtil.NULL))

fun VkQueue.submit(submits: VkSubmitInfo, fence: VkFence) = VK_CHECK_RESULT(VK10.nvkQueueSubmit(this, 1, submits.adr, fence.L))

fun VkQueue.waitIdle() = VK_CHECK_RESULT(VK10.vkQueueWaitIdle(this))
