package vkk.`object`

import glm_.i
import kool.*
import kool.lib.isEmpty
import kool.lib.isNotEmpty
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.system.MemoryUtil.memCopy
import org.lwjgl.system.Pointer
import vkk.VkDynamicState
import java.nio.ByteBuffer
import java.nio.IntBuffer
import java.nio.LongBuffer

fun Buffer(size: VkDeviceSize): ByteBuffer = kool.Buffer(size.L.i)

fun memCopy(src: Ptr, dst: Ptr, bytes: VkDeviceSize) = memCopy(src, dst, bytes.L)

fun Pointer.isInvalid() = adr == NULL
fun Pointer.isValid() = adr != NULL

inline class VkBuffer(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkBufferView(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkCommandPool(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkDebugReportCallback(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkDescriptorPool(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkDescriptorSet(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkDescriptorSetLayout(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkDeviceMemory(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkDeviceSize(val L: Long) {

    operator fun plus(size: VkDeviceSize) = VkDeviceSize(L + size.L)
    operator fun plus(size: Int) = VkDeviceSize(L + size)

    val isEmpty get() = L == 0L
    val isNotEmpty get() = L != 0L
}

inline class VkEvent(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkFence(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkFramebuffer(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkImage(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkImageView(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkPipeline(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkPipelineCache(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkPipelineLayout(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkQueryPool(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkRenderPass(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkSampler(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkSemaphore(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkShaderModule(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkSurface(val L: Long) { // TODO -> KHR
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

inline class VkSwapchainKHR(val L: Long) {
    val isValid get() = L != NULL
    val isInvalid get() = L == NULL
}

typealias VkBufferBuffer = LongBuffer
typealias VkDescriptorSetBuffer = LongBuffer
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

typealias VkCommandPoolArray = LongArray

inline class VkFenceArray(val array: LongArray) : Iterable<VkFence> {

    operator fun get(index: Int) = VkFence(array[index])
    operator fun set(index: Int, fence: VkFence) = array.set(index, fence.L)

    val size get() = array.size
    val indices get() = array.indices

    override operator fun iterator() = VkFenceArrayIterator()

    inner class VkFenceArrayIterator : Iterator<VkFence> {
        private var index = 0
        override fun hasNext() = index < array.size
        override fun next() =
            try {
                VkFence(array[index++])
            } catch (e: ArrayIndexOutOfBoundsException) {
                index -= 1
                throw NoSuchElementException(e.message)
            }
    }
}

fun initVkFenceArray(size: Int, block: (Int) -> VkFence) = VkFenceArray(LongArray(size) { block(it).L })
fun vkFenceArrayOf() = VkFenceArray(LongArray(0))
fun vkFenceArrayBig(size: Int) = VkFenceArray(LongArray(size))

inline class VkFramebufferArray(val array: LongArray) : Iterable<VkFramebuffer> {

    operator fun get(index: Int) = VkFramebuffer(array[index])
    operator fun set(index: Int, framebuffer: VkFramebuffer) = array.set(index, framebuffer.L)

    val size get() = array.size
    val indices get() = array.indices

    override operator fun iterator() = VkFramebufferArrayIterator()

    inner class VkFramebufferArrayIterator : Iterator<VkFramebuffer> {
        private var index = 0
        override fun hasNext() = index < array.size
        override fun next() =
            try {
                VkFramebuffer(array[index++])
            } catch (e: ArrayIndexOutOfBoundsException) {
                index -= 1
                throw NoSuchElementException(e.message)
            }
    }
}

fun initVkFramebufferArray(size: Int, block: (Int) -> VkFramebuffer) = VkFramebufferArray(LongArray(size) { block(it).L })
fun vkFramebufferArrayOf() = VkFramebufferArray(LongArray(0))

inline class VkImageArray(val array: LongArray) : Iterable<VkImage> {

    operator fun get(index: Int) = VkImage(array[index])
    operator fun set(index: Int, image: VkImage) = array.set(index, image.L)

    val size get() = array.size
    val indices get() = array.indices

    override operator fun iterator() = VkImageArrayIterator()

    inner class VkImageArrayIterator : Iterator<VkImage> {
        private var index = 0
        override fun hasNext() = index < array.size
        override fun next() =
            try {
                VkImage(array[index++])
            } catch (e: ArrayIndexOutOfBoundsException) {
                index -= 1
                throw NoSuchElementException(e.message)
            }
    }
}

fun VkImageArray(size: Int, block: (Int) -> VkImage) = VkImageArray(LongArray(size) { block(it).L })
fun VkImageArray(size: Int) = VkImageArray(LongArray(size))
fun VkImageArray(images: Collection<VkImage>) = VkImageArray(LongArray(images.size) { images.elementAt(it).L })
fun VkImageArray() = VkImageArray(LongArray(0))

inline class VkImageViewArray(val array: LongArray) : Iterable<VkImageView> {

    operator fun get(index: Int) = VkImageView(array[index])
    operator fun set(index: Int, imageView: VkImageView) = array.set(index, imageView.L)

    val size get() = array.size
    val indices get() = array.indices

    override operator fun iterator() = VkImageViewArrayIterator()

    inner class VkImageViewArrayIterator : Iterator<VkImageView> {
        private var index = 0
        override fun hasNext() = index < array.size
        override fun next() =
            try {
                VkImageView(array[index++])
            } catch (e: ArrayIndexOutOfBoundsException) {
                index -= 1
                throw NoSuchElementException(e.message)
            }
    }
}

fun VkImageViewArray(size: Int, block: (Int) -> VkImageView) = VkImageViewArray(LongArray(size) { block(it).L })
fun VkImageViewArray(size: Int) = VkImageViewArray(LongArray(size))
fun VkImageViewArray(images: Collection<VkImageView>) = VkImageViewArray(LongArray(images.size) { images.elementAt(it).L })
fun VkImageViewArray() = VkImageViewArray(LongArray(0))

inline class VkSemaphoreArray(val array: LongArray) {
    operator fun get(index: Int) = VkSemaphore(array[index])
}

fun VkSemaphoreArray(size: Int, init: (Int) -> VkSemaphore) = VkSemaphoreArray(LongArray(size) { init(it).L })
fun VkSemaphoreArray(semaphores: Collection<VkSemaphore>) = VkSemaphoreArray(semaphores.size) { semaphores.elementAt(it) }


inline class VkImageViewBuffer(val buffer: LongBuffer) {

    operator fun set(index: Int, imageView: VkImageView) {
        buffer[index] = imageView.L
    }
}

fun MemoryStack.vkImageViewBufferBig(size: Int) = VkImageViewBuffer(callocLong(size))
fun MemoryStack.vkImageViewBufferOf(imageView: VkImageView): VkImageViewBuffer =
    VkImageViewBuffer(longs(imageView.L))

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
}

fun MemoryStack.vkDynamicStateBufferBig(size: Int) = VkDynamicStateBuffer(callocInt(size))
fun MemoryStack.vkDynamicStateBufferOf(dynamicStates: Collection<VkDynamicState>): VkDynamicStateBuffer {
    val buffer = vkDynamicStateBufferBig(dynamicStates.size)
    for (i in dynamicStates.indices)
        buffer[i] = dynamicStates.elementAt(i)
    return buffer
}

fun MemoryStack.vkDynamicStateBufferOf(dynamicState: VkDynamicState): VkDynamicStateBuffer = VkDynamicStateBuffer(ints(dynamicState.i))

fun MemoryStack.vkDynamicStateBufferOf(dynamicState0: VkDynamicState,
                                       dynamicState1: VkDynamicState): VkDynamicStateBuffer =
    VkDynamicStateBuffer(ints(dynamicState0.i, dynamicState1.i))

fun MemoryStack.vkDynamicStateBufferOf(dynamicState0: VkDynamicState,
                                       dynamicState1: VkDynamicState,
                                       dynamicState2: VkDynamicState): VkDynamicStateBuffer =
    VkDynamicStateBuffer(ints(dynamicState0.i, dynamicState1.i, dynamicState2.i))



typealias VkResultBuffer = IntBuffer
