package vkk.entities

import kool.*
import kool.lib.isEmpty
import kool.lib.isNotEmpty
import org.lwjgl.system.MemoryStack
import vkk.VkDynamicState
import java.nio.IntBuffer
import java.nio.LongBuffer


typealias VkBufferBuffer = LongBuffer

inline class VkDescriptorSetLayoutBuffer(val buffer: LongBuffer)


typealias VkDeviceMemoryBuffer = LongBuffer
typealias VkDeviceSizeBuffer = LongBuffer



inline class VkSemaphoreBuffer(val buffer: LongBuffer) {
    operator fun get(index: Int) = VkSemaphore(buffer[index])

    fun isNotEmpty() = buffer.isNotEmpty()
    fun isEmpty() = buffer.isEmpty()

    val rem get() = buffer.rem
    val adr get() = buffer.adr
}

fun vkSemaphoreBufferOf(semaphore: VkSemaphore) = VkSemaphoreBuffer(longBufferOf(semaphore.L))
fun MemoryStack.vkSemaphoreBufferOf(semaphore: VkSemaphore) = VkSemaphoreBuffer(longs(semaphore.L))

typealias VkSwapchainKhrBuffer = LongBuffer
//typealias VkResultBuffer = IntBuffer
typealias VkSamplerBuffer = LongBuffer


inline class VkImageViewBuffer(val buffer: LongBuffer) {

    operator fun set(index: Int, imageView: VkImageView) {
        buffer[index] = imageView.L
    }

    fun free() = buffer.free()
}

fun VkImageViewBuffer(size: Int, init: (Int) -> VkImageView) = VkImageViewBuffer(LongBuffer(size) { init(it).L })
fun MemoryStack.VkImageViewBuffer(size: Int, init: (Int) -> VkImageView) = VkImageViewBuffer(LongBuffer(size) { init(it).L })

fun MemoryStack.VkImageViewBuffer(size: Int) = VkImageViewBuffer(callocLong(size))

fun MemoryStack.vkImageViewBufferOf(imageView: VkImageView): VkImageViewBuffer = VkImageViewBuffer(longs(imageView.L))
fun MemoryStack.vkImageViewBufferOf(imageView0: VkImageView,
                                    imageView1: VkImageView): VkImageViewBuffer =
        VkImageViewBuffer(longs(imageView0.L, imageView1.L))

fun MemoryStack.vkImageViewBufferOf(imageView0: VkImageView,
                                    imageView1: VkImageView,
                                    imageView2: VkImageView): VkImageViewBuffer =
        VkImageViewBuffer(longs(imageView0.L, imageView1.L, imageView2.L))

inline class VkDynamicStateBuffer(val buffer: IntBuffer) {

    operator fun set(index: Int, imageView: VkDynamicState) {
        buffer[index] = imageView.i
    }

    fun free() = buffer.free()
}

fun VkDynamicStateBuffer(size: Int, block: (Int) -> VkDynamicState) = VkDynamicStateBuffer(IntBuffer(size) { block(it).i })
fun VkDynamicStateBuffer(size: Int) = VkDynamicStateBuffer(IntBuffer(size))
fun VkDynamicStateBuffer(images: Collection<VkDynamicState>) = VkDynamicStateBuffer(IntBuffer(images.size) { images.elementAt(it).i })

fun MemoryStack.VkDynamicStateBuffer(size: Int, block: (Int) -> VkDynamicState) = VkDynamicStateBuffer(IntBuffer(size) { block(it).i })
fun MemoryStack.VkDynamicStateBuffer(size: Int) = VkDynamicStateBuffer(IntBuffer(size))
fun MemoryStack.VkDynamicStateBuffer(images: Collection<VkDynamicState>) = VkDynamicStateBuffer(IntBuffer(images.size) { images.elementAt(it).i })


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

inline class VkEventBuffer(val buffer: LongBuffer) {

    val rem get() = buffer.rem
    val adr get() = buffer.adr
}