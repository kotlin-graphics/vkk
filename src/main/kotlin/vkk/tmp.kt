package vkk

import glm_.i
import kool.*
import org.lwjgl.PointerBuffer
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryStack.stackGet
import org.lwjgl.system.MemoryUtil
import org.lwjgl.vulkan.VkCommandBuffer
import org.lwjgl.vulkan.VkD3D12FenceSubmitInfoKHR
import vkk.entities.VkDeviceSize
import vkk.entities.VkDisplayKHR_Buffer
import vkk.entities.VkSemaphore_Buffer
import java.nio.ByteBuffer
import java.nio.IntBuffer
import java.nio.LongBuffer

fun main() {
    test<Int>()
    test<VkCommandBuffer>()
    test<Array<VkCommandBuffer>>()
    test<ArrayList<VkCommandBuffer>>()
    test<Float>()
}

inline fun <reified T : Any> test() {
    println(when (T::class) {
        Int::class -> "Int"
        Float::class -> "Float"
        VkCommandBuffer::class -> "VkCommandBuffer"
        Array<VkCommandBuffer>::class -> "Array<VkCommandBuffer>"
        ArrayList::class -> "ArrayList<VkCommandBuffer>"
        else -> "else"
    })
}

fun Buffer(size: VkDeviceSize): ByteBuffer = kool.Buffer(size.L.i)

fun memCopy(src: Ptr, dst: Ptr, bytes: VkDeviceSize) = MemoryUtil.memCopy(src, dst, bytes.L)

inline class VkDynamicStateBuffer(val buffer: IntBuffer) {

    operator fun set(index: Int, imageView: VkDynamicState) {
        buffer[index] = imageView.i
    }

    fun free() = buffer.free()
}

fun VkDynamicStateBuffer(size: Int, block: (Int) -> VkDynamicState) = VkDynamicStateBuffer(IntBuffer(size) { block(it).i })
fun VkDynamicStateBuffer(size: Int) = VkDynamicStateBuffer(IntBuffer(size))
fun VkDynamicStateBuffer(elements: Collection<VkDynamicState>) = VkDynamicStateBuffer(IntBuffer(elements.size) { elements.elementAt(it).i })

fun MemoryStack.VkDynamicStateBuffer(size: Int, block: (Int) -> VkDynamicState) = VkDynamicStateBuffer(IntBuffer(size) { block(it).i })
fun MemoryStack.VkDynamicStateBuffer(size: Int) = VkDynamicStateBuffer(IntBuffer(size))
fun MemoryStack.VkDynamicStateBuffer(elements: Collection<VkDynamicState>) = VkDynamicStateBuffer(IntBuffer(elements.size) { elements.elementAt(it).i })


fun vkDynamicStateBufferOf(dynamicState: VkDynamicState): VkDynamicStateBuffer = VkDynamicStateBuffer(intBufferOf(dynamicState.i))

fun vkDynamicStateBufferOf(dynamicState0: VkDynamicState,
                           dynamicState1: VkDynamicState): VkDynamicStateBuffer =
        VkDynamicStateBuffer(intBufferOf(dynamicState0.i, dynamicState1.i))

fun vkDynamicStateBufferOf(dynamicState0: VkDynamicState,
                           dynamicState1: VkDynamicState,
                           dynamicState2: VkDynamicState): VkDynamicStateBuffer =
        VkDynamicStateBuffer(intBufferOf(dynamicState0.i, dynamicState1.i, dynamicState2.i))

fun MemoryStack.vkDynamicStateBufferOf(dynamicState: VkDynamicState): VkDynamicStateBuffer = VkDynamicStateBuffer(ints(dynamicState.i))

fun MemoryStack.vkDynamicStateBufferOf(dynamicState0: VkDynamicState,
                                       dynamicState1: VkDynamicState): VkDynamicStateBuffer =
        VkDynamicStateBuffer(ints(dynamicState0.i, dynamicState1.i))

fun MemoryStack.vkDynamicStateBufferOf(dynamicState0: VkDynamicState,
                                       dynamicState1: VkDynamicState,
                                       dynamicState2: VkDynamicState): VkDynamicStateBuffer =
        VkDynamicStateBuffer(ints(dynamicState0.i, dynamicState1.i, dynamicState2.i))



typealias VkResultBuffer = IntBuffer

inline class VkObjectEntryTypeNVX_Buffer(val buffer: IntBuffer) {
    val rem get() = buffer.rem
    val adr get() = buffer.adr
}

inline class VkObjectEntryUsageFlagsNVX_Buffer(val buffer: IntBuffer) {
    val rem get() = buffer.rem
    val adr get() = buffer.adr
}

inline class VkDescriptorBindingFlagsEXT_Buffer(val buffer: IntBuffer) {
    val rem get() = buffer.rem
    val adr get() = buffer.adr
}

inline class VkShadingRatePaletteEntryNV_Buffer(val buffer: IntBuffer) {
    val rem get() = buffer.rem
    val adr get() = buffer.adr
}

inline class HINSTANCE(val L: Long)
inline class HWND(val L: Long)
inline class HANDLE(val L: Long)
inline class DWORD(val i: Int)
inline class Display(val L: Long)
inline class Window(val L: Long)
inline class VisualID(val L: Long)
inline class WLDisplay(val L: Long)
inline class WLSurface(val L: Long)
inline class RROutput(val L: Long)

inline class VkDebugUtilsMessengerEXT(val L: Long)


inline class VkTimeDomainEXT_Buffer(val buffer: IntBuffer) {
    val rem get() = buffer.rem
    val adr get() = buffer.adr
}

inline class VkPresentModeKHR_Buffer(val buffer: IntBuffer) {
    val rem get() = buffer.rem
    val adr get() = buffer.adr
}

inline class VkPhysicalDevice_Buffer(val buffer: PointerBuffer) {
    val rem get() = buffer.rem
    val adr: Adr get() = buffer.adr // TODO -> Adr
}



inline class VkValidationFeatureEnableEXT_Buffer(val buffer: IntBuffer) {
    val rem get() = buffer.rem
    val adr: Adr get() = buffer.adr // TODO -> Adr
}



