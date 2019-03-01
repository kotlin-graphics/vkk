package vkk

import org.lwjgl.vulkan.NVRayTracing
import org.lwjgl.vulkan.NVRayTracing.VK_COPY_ACCELERATION_STRUCTURE_MODE_CLONE_NV
import org.lwjgl.vulkan.NVRayTracing.VK_COPY_ACCELERATION_STRUCTURE_MODE_COMPACT_NV
import org.lwjgl.vulkan.NVShadingRateImage.*
import org.lwjgl.vulkan.VkCommandBuffer

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