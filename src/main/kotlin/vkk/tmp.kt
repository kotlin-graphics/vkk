package vkk

import gli_.memCopy
import glm_.i
import kool.*
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil
import org.lwjgl.vulkan.NVRayTracing
import org.lwjgl.vulkan.NVRayTracing.VK_COPY_ACCELERATION_STRUCTURE_MODE_CLONE_NV
import org.lwjgl.vulkan.NVRayTracing.VK_COPY_ACCELERATION_STRUCTURE_MODE_COMPACT_NV
import org.lwjgl.vulkan.NVShadingRateImage.*
import org.lwjgl.vulkan.VkCommandBuffer
import vkk.entities.VkDeviceSize
import java.nio.ByteBuffer
import java.nio.IntBuffer

inline class VkCopyAccelerationStructureModeNV(val i: Int) {
    companion object {
        val CLONE = VkCopyAccelerationStructureModeNV(VK_COPY_ACCELERATION_STRUCTURE_MODE_CLONE_NV)
        val COMPACT = VkCopyAccelerationStructureModeNV(VK_COPY_ACCELERATION_STRUCTURE_MODE_COMPACT_NV)
    }
}

inline class VkCoarseSampleOrderTypeNV(val i: Int) {
    companion object {
        val DEFAULT = VkCoarseSampleOrderTypeNV(VK_COARSE_SAMPLE_ORDER_TYPE_DEFAULT_NV)
        val CUSTOM = VkCoarseSampleOrderTypeNV(VK_COARSE_SAMPLE_ORDER_TYPE_CUSTOM_NV)
        val PIXEL_MAJOR = VkCoarseSampleOrderTypeNV(VK_COARSE_SAMPLE_ORDER_TYPE_PIXEL_MAJOR_NV)
        val SAMPLE_MAJOR = VkCoarseSampleOrderTypeNV(VK_COARSE_SAMPLE_ORDER_TYPE_SAMPLE_MAJOR_NV)
    }
}


fun main() {
    test<Int>()
    test<VkCommandBuffer>()
    test<Array<VkCommandBuffer>>()
    test<ArrayList<VkCommandBuffer>>()
    test<Float>()
}

inline fun <reified T : Any>test() {
    println(when(T::class) {
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