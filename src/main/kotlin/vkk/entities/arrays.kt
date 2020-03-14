package vkk.entities

import kool.Adr
import kool.IntPtr
import kool.LongPtr
import org.lwjgl.system.MemoryStack
import vkk.VkResult
import vkk.extensions.VkPresentModeKHR


inline class VkAccelerationStructureNV_Array(val array: LongArray) {

    operator fun get(index: Int) = VkAccelerationStructureNV(array[index])
    operator fun set(index: Int, fence: VkAccelerationStructureNV) = array.set(index, fence.L)

    val size get() = array.size
    val indices get() = array.indices

    inline fun forEach(action: (VkAccelerationStructureNV) -> Unit) {
        for (element in array) action(VkAccelerationStructureNV(element))
    }

    infix fun write(stack: MemoryStack): Adr = stack.LongPtr(size) { get(it).L }.adr
}

fun VkAccelerationStructureNV_Array(size: Int, block: (Int) -> VkAccelerationStructureNV) = VkAccelerationStructureNV_Array(LongArray(size) { block(it).L })
fun VkAccelerationStructureNV_Array(size: Int) = VkAccelerationStructureNV_Array(LongArray(size))
fun VkAccelerationStructureNV_Array(elements: Collection<VkAccelerationStructureNV>) = VkAccelerationStructureNV_Array(LongArray(elements.size) { elements.elementAt(it).L })
fun VkAccelerationStructureNV_Array() = VkAccelerationStructureNV_Array(LongArray(0))


inline class VkBuffer_Array(val array: LongArray) {

    operator fun get(index: Int) = VkBuffer(array[index])
    operator fun set(index: Int, fence: VkBuffer) = array.set(index, fence.L)

    val size get() = array.size
    val indices get() = array.indices

    inline fun forEach(action: (VkBuffer) -> Unit) {
        for (element in array) action(VkBuffer(element))
    }

    infix fun write(stack: MemoryStack): Adr = stack.LongPtr(size) { get(it).L }.adr
}

fun VkBuffer_Array(size: Int, block: (Int) -> VkBuffer) = VkBuffer_Array(LongArray(size) { block(it).L })
fun VkBuffer_Array(size: Int) = VkBuffer_Array(LongArray(size))
fun VkBuffer_Array(elements: Collection<VkBuffer>) = VkBuffer_Array(LongArray(elements.size) { elements.elementAt(it).L })
fun VkBuffer_Array() = VkBuffer_Array(LongArray(0))


inline class VkBufferView_Array(val array: LongArray) {

    operator fun get(index: Int) = VkBufferView(array[index])
    operator fun set(index: Int, fence: VkBufferView) = array.set(index, fence.L)

    val size get() = array.size
    val indices get() = array.indices

    inline fun forEach(action: (VkBufferView) -> Unit) {
        for (element in array) action(VkBufferView(element))
    }

    infix fun write(stack: MemoryStack): Adr = stack.LongPtr(size) { get(it).L }.adr
}

fun VkBufferView_Array(size: Int, block: (Int) -> VkBufferView) = VkBufferView_Array(LongArray(size) { block(it).L })
fun VkBufferView_Array(size: Int) = VkBufferView_Array(LongArray(size))
fun VkBufferView_Array(elements: Collection<VkBufferView>) = VkBufferView_Array(LongArray(elements.size) { elements.elementAt(it).L })
fun VkBufferView_Array() = VkBufferView_Array(LongArray(0))


inline class VkCommandPool_Array(val array: LongArray) {

    operator fun get(index: Int) = VkCommandPool(array[index])
    operator fun set(index: Int, fence: VkCommandPool) = array.set(index, fence.L)

    val size get() = array.size
    val indices get() = array.indices

    inline fun forEach(action: (VkCommandPool) -> Unit) {
        for (element in array) action(VkCommandPool(element))
    }

    infix fun write(stack: MemoryStack): Adr = stack.LongPtr(size) { get(it).L }.adr
}

fun VkCommandPool_Array(size: Int, block: (Int) -> VkCommandPool) = VkCommandPool_Array(LongArray(size) { block(it).L })
fun VkCommandPool_Array(size: Int) = VkCommandPool_Array(LongArray(size))
fun VkCommandPool_Array(elements: Collection<VkCommandPool>) = VkCommandPool_Array(LongArray(elements.size) { elements.elementAt(it).L })
fun VkCommandPool_Array() = VkCommandPool_Array(LongArray(0))


inline class VkDebugReportCallback_Array(val array: LongArray) {

    operator fun get(index: Int) = VkDebugReportCallback(array[index])
    operator fun set(index: Int, fence: VkDebugReportCallback) = array.set(index, fence.L)

    val size get() = array.size
    val indices get() = array.indices

    inline fun forEach(action: (VkDebugReportCallback) -> Unit) {
        for (element in array) action(VkDebugReportCallback(element))
    }

    infix fun write(stack: MemoryStack): Adr = stack.LongPtr(size) { get(it).L }.adr
}

fun VkDebugReportCallback_Array(size: Int, block: (Int) -> VkDebugReportCallback) = VkDebugReportCallback_Array(LongArray(size) { block(it).L })
fun VkDebugReportCallback_Array(size: Int) = VkDebugReportCallback_Array(LongArray(size))
fun VkDebugReportCallback_Array(elements: Collection<VkDebugReportCallback>) = VkDebugReportCallback_Array(LongArray(elements.size) { elements.elementAt(it).L })
fun VkDebugReportCallback_Array() = VkDebugReportCallback_Array(LongArray(0))


inline class VkDebugUtilsMessengerEXT_Array(val array: LongArray) {

    operator fun get(index: Int) = VkDebugUtilsMessengerEXT(array[index])
    operator fun set(index: Int, fence: VkDebugUtilsMessengerEXT) = array.set(index, fence.L)

    val size get() = array.size
    val indices get() = array.indices

    inline fun forEach(action: (VkDebugUtilsMessengerEXT) -> Unit) {
        for (element in array) action(VkDebugUtilsMessengerEXT(element))
    }

    infix fun write(stack: MemoryStack): Adr = stack.LongPtr(size) { get(it).L }.adr
}

fun VkDebugUtilsMessengerEXT_Array(size: Int, block: (Int) -> VkDebugUtilsMessengerEXT) = VkDebugUtilsMessengerEXT_Array(LongArray(size) { block(it).L })
fun VkDebugUtilsMessengerEXT_Array(size: Int) = VkDebugUtilsMessengerEXT_Array(LongArray(size))
fun VkDebugUtilsMessengerEXT_Array(elements: Collection<VkDebugUtilsMessengerEXT>) = VkDebugUtilsMessengerEXT_Array(LongArray(elements.size) { elements.elementAt(it).L })
fun VkDebugUtilsMessengerEXT_Array() = VkDebugUtilsMessengerEXT_Array(LongArray(0))


inline class VkDescriptorPool_Array(val array: LongArray) {

    operator fun get(index: Int) = VkDescriptorPool(array[index])
    operator fun set(index: Int, fence: VkDescriptorPool) = array.set(index, fence.L)

    val size get() = array.size
    val indices get() = array.indices

    inline fun forEach(action: (VkDescriptorPool) -> Unit) {
        for (element in array) action(VkDescriptorPool(element))
    }

    infix fun write(stack: MemoryStack): Adr = stack.LongPtr(size) { get(it).L }.adr
}

fun VkDescriptorPool_Array(size: Int, block: (Int) -> VkDescriptorPool) = VkDescriptorPool_Array(LongArray(size) { block(it).L })
fun VkDescriptorPool_Array(size: Int) = VkDescriptorPool_Array(LongArray(size))
fun VkDescriptorPool_Array(elements: Collection<VkDescriptorPool>) = VkDescriptorPool_Array(LongArray(elements.size) { elements.elementAt(it).L })
fun VkDescriptorPool_Array() = VkDescriptorPool_Array(LongArray(0))


inline class VkDescriptorSet_Array(val array: LongArray) {

    operator fun get(index: Int) = VkDescriptorSet(array[index])
    operator fun set(index: Int, fence: VkDescriptorSet) = array.set(index, fence.L)

    val size get() = array.size
    val indices get() = array.indices

    inline fun forEach(action: (VkDescriptorSet) -> Unit) {
        for (element in array) action(VkDescriptorSet(element))
    }

    infix fun write(stack: MemoryStack): Adr = stack.LongPtr(size) { get(it).L }.adr
}

fun VkDescriptorSet_Array(size: Int, block: (Int) -> VkDescriptorSet) = VkDescriptorSet_Array(LongArray(size) { block(it).L })
fun VkDescriptorSet_Array(size: Int) = VkDescriptorSet_Array(LongArray(size))
fun VkDescriptorSet_Array(elements: Collection<VkDescriptorSet>) = VkDescriptorSet_Array(LongArray(elements.size) { elements.elementAt(it).L })
fun VkDescriptorSet_Array() = VkDescriptorSet_Array(LongArray(0))


inline class VkDescriptorSetLayout_Array(val array: LongArray) {

    operator fun get(index: Int) = VkDescriptorSetLayout(array[index])
    operator fun set(index: Int, fence: VkDescriptorSetLayout) = array.set(index, fence.L)

    val size get() = array.size
    val indices get() = array.indices

    inline fun forEach(action: (VkDescriptorSetLayout) -> Unit) {
        for (element in array) action(VkDescriptorSetLayout(element))
    }

    infix fun write(stack: MemoryStack): Adr = stack.LongPtr(size) { get(it).L }.adr
}

fun VkDescriptorSetLayout_Array(size: Int, block: (Int) -> VkDescriptorSetLayout) = VkDescriptorSetLayout_Array(LongArray(size) { block(it).L })
fun VkDescriptorSetLayout_Array(size: Int) = VkDescriptorSetLayout_Array(LongArray(size))
fun VkDescriptorSetLayout_Array(elements: Collection<VkDescriptorSetLayout>) = VkDescriptorSetLayout_Array(LongArray(elements.size) { elements.elementAt(it).L })
fun VkDescriptorSetLayout_Array() = VkDescriptorSetLayout_Array(LongArray(0))


inline class VkDescriptorUpdateTemplate_Array(val array: LongArray) {

    operator fun get(index: Int) = VkDescriptorUpdateTemplate(array[index])
    operator fun set(index: Int, fence: VkDescriptorUpdateTemplate) = array.set(index, fence.L)

    val size get() = array.size
    val indices get() = array.indices

    inline fun forEach(action: (VkDescriptorUpdateTemplate) -> Unit) {
        for (element in array) action(VkDescriptorUpdateTemplate(element))
    }

    infix fun write(stack: MemoryStack): Adr = stack.LongPtr(size) { get(it).L }.adr
}

fun VkDescriptorUpdateTemplate_Array(size: Int, block: (Int) -> VkDescriptorUpdateTemplate) = VkDescriptorUpdateTemplate_Array(LongArray(size) { block(it).L })
fun VkDescriptorUpdateTemplate_Array(size: Int) = VkDescriptorUpdateTemplate_Array(LongArray(size))
fun VkDescriptorUpdateTemplate_Array(elements: Collection<VkDescriptorUpdateTemplate>) = VkDescriptorUpdateTemplate_Array(LongArray(elements.size) { elements.elementAt(it).L })
fun VkDescriptorUpdateTemplate_Array() = VkDescriptorUpdateTemplate_Array(LongArray(0))


inline class VkDeviceMemory_Array(val array: LongArray) {

    operator fun get(index: Int) = VkDeviceMemory(array[index])
    operator fun set(index: Int, fence: VkDeviceMemory) = array.set(index, fence.L)

    val size get() = array.size
    val indices get() = array.indices

    inline fun forEach(action: (VkDeviceMemory) -> Unit) {
        for (element in array) action(VkDeviceMemory(element))
    }

    infix fun write(stack: MemoryStack): Adr = stack.LongPtr(size) { get(it).L }.adr
}

fun VkDeviceMemory_Array(size: Int, block: (Int) -> VkDeviceMemory) = VkDeviceMemory_Array(LongArray(size) { block(it).L })
fun VkDeviceMemory_Array(size: Int) = VkDeviceMemory_Array(LongArray(size))
fun VkDeviceMemory_Array(elements: Collection<VkDeviceMemory>) = VkDeviceMemory_Array(LongArray(elements.size) { elements.elementAt(it).L })
fun VkDeviceMemory_Array() = VkDeviceMemory_Array(LongArray(0))


inline class VkDeviceSize_Array(val array: LongArray) {

    operator fun get(index: Int) = VkDeviceSize(array[index])
    operator fun set(index: Int, fence: VkDeviceSize) = array.set(index, fence.L)

    val size get() = array.size
    val indices get() = array.indices

    inline fun forEach(action: (VkDeviceSize) -> Unit) {
        for (element in array) action(VkDeviceSize(element))
    }

    infix fun write(stack: MemoryStack): Adr = stack.LongPtr(size) { get(it).L }.adr
}

fun VkDeviceSize_Array(size: Int, block: (Int) -> VkDeviceSize) = VkDeviceSize_Array(LongArray(size) { block(it).L })
fun VkDeviceSize_Array(size: Int) = VkDeviceSize_Array(LongArray(size))
fun VkDeviceSize_Array(elements: Collection<VkDeviceSize>) = VkDeviceSize_Array(LongArray(elements.size) { elements.elementAt(it).L })
fun VkDeviceSize_Array() = VkDeviceSize_Array(LongArray(0))


inline class VkDisplayKHR_Array(val array: LongArray) {

    operator fun get(index: Int) = VkDisplayKHR(array[index])
    operator fun set(index: Int, fence: VkDisplayKHR) = array.set(index, fence.L)

    val size get() = array.size
    val indices get() = array.indices

    inline fun forEach(action: (VkDisplayKHR) -> Unit) {
        for (element in array) action(VkDisplayKHR(element))
    }

    infix fun write(stack: MemoryStack): Adr = stack.LongPtr(size) { get(it).L }.adr
}

fun VkDisplayKHR_Array(size: Int, block: (Int) -> VkDisplayKHR) = VkDisplayKHR_Array(LongArray(size) { block(it).L })
fun VkDisplayKHR_Array(size: Int) = VkDisplayKHR_Array(LongArray(size))
fun VkDisplayKHR_Array(elements: Collection<VkDisplayKHR>) = VkDisplayKHR_Array(LongArray(elements.size) { elements.elementAt(it).L })
fun VkDisplayKHR_Array() = VkDisplayKHR_Array(LongArray(0))


inline class VkDisplayModeKHR_Array(val array: LongArray) {

    operator fun get(index: Int) = VkDisplayModeKHR(array[index])
    operator fun set(index: Int, fence: VkDisplayModeKHR) = array.set(index, fence.L)

    val size get() = array.size
    val indices get() = array.indices

    inline fun forEach(action: (VkDisplayModeKHR) -> Unit) {
        for (element in array) action(VkDisplayModeKHR(element))
    }

    infix fun write(stack: MemoryStack): Adr = stack.LongPtr(size) { get(it).L }.adr
}

fun VkDisplayModeKHR_Array(size: Int, block: (Int) -> VkDisplayModeKHR) = VkDisplayModeKHR_Array(LongArray(size) { block(it).L })
fun VkDisplayModeKHR_Array(size: Int) = VkDisplayModeKHR_Array(LongArray(size))
fun VkDisplayModeKHR_Array(elements: Collection<VkDisplayModeKHR>) = VkDisplayModeKHR_Array(LongArray(elements.size) { elements.elementAt(it).L })
fun VkDisplayModeKHR_Array() = VkDisplayModeKHR_Array(LongArray(0))


inline class VkEvent_Array(val array: LongArray) {

    operator fun get(index: Int) = VkEvent(array[index])
    operator fun set(index: Int, fence: VkEvent) = array.set(index, fence.L)

    val size get() = array.size
    val indices get() = array.indices

    inline fun forEach(action: (VkEvent) -> Unit) {
        for (element in array) action(VkEvent(element))
    }

    infix fun write(stack: MemoryStack): Adr = stack.LongPtr(size) { get(it).L }.adr
}

fun VkEvent_Array(size: Int, block: (Int) -> VkEvent) = VkEvent_Array(LongArray(size) { block(it).L })
fun VkEvent_Array(size: Int) = VkEvent_Array(LongArray(size))
fun VkEvent_Array(elements: Collection<VkEvent>) = VkEvent_Array(LongArray(elements.size) { elements.elementAt(it).L })
fun VkEvent_Array() = VkEvent_Array(LongArray(0))


inline class VkFence_Array(val array: LongArray) {

    operator fun get(index: Int) = VkFence(array[index])
    operator fun set(index: Int, fence: VkFence) = array.set(index, fence.L)

    val size get() = array.size
    val indices get() = array.indices

//    override operator fun iterator() = VkFenceArrayIterator()
//
//    inner class VkFenceArrayIterator : Iterator<VkFence> {
//        private var index = 0
//        override fun hasNext() = index < array.size
//        override fun next() =
//                try {
//                    VkFence(array[index++])
//                } catch (e: ArrayIndexOutOfBoundsException) {
//                    index -= 1
//                    throw NoSuchElementException(e.message)
//                }
//    }

    inline fun forEach(action: (VkFence) -> Unit) {
        for (element in array) action(VkFence(element))
    }

    infix fun write(stack: MemoryStack): Adr = stack.LongPtr(size) { get(it).L }.adr
}

fun VkFence_Array(size: Int, block: (Int) -> VkFence) = VkFence_Array(LongArray(size) { block(it).L })
fun VkFence_Array(size: Int) = VkFence_Array(LongArray(size))
fun VkFence_Array(elements: Collection<VkFence>) = VkFence_Array(LongArray(elements.size) { elements.elementAt(it).L })
fun VkFence_Array() = VkFence_Array(LongArray(0))


inline class VkFramebuffer_Array(val array: LongArray) {

    operator fun get(index: Int) = VkFramebuffer(array[index])
    operator fun set(index: Int, fence: VkFramebuffer) = array.set(index, fence.L)

    val size get() = array.size
    val indices get() = array.indices

    inline fun forEach(action: (VkFramebuffer) -> Unit) {
        for (element in array) action(VkFramebuffer(element))
    }

    infix fun write(stack: MemoryStack): Adr = stack.LongPtr(size) { get(it).L }.adr
}

fun VkFramebuffer_Array(size: Int, block: (Int) -> VkFramebuffer) = VkFramebuffer_Array(LongArray(size) { block(it).L })
fun VkFramebuffer_Array(size: Int) = VkFramebuffer_Array(LongArray(size))
fun VkFramebuffer_Array(elements: Collection<VkFramebuffer>) = VkFramebuffer_Array(LongArray(elements.size) { elements.elementAt(it).L })
fun VkFramebuffer_Array() = VkFramebuffer_Array(LongArray(0))


inline class VkImage_Array(val array: LongArray) {

    operator fun get(index: Int) = VkImage(array[index])
    operator fun set(index: Int, fence: VkImage) = array.set(index, fence.L)

    val size get() = array.size
    val indices get() = array.indices

    inline fun forEach(action: (VkImage) -> Unit) {
        for (element in array) action(VkImage(element))
    }

    infix fun write(stack: MemoryStack): Adr = stack.LongPtr(size) { get(it).L }.adr
}

fun VkImage_Array(size: Int, block: (Int) -> VkImage) = VkImage_Array(LongArray(size) { block(it).L })
fun VkImage_Array(size: Int) = VkImage_Array(LongArray(size))
fun VkImage_Array(elements: Collection<VkImage>) = VkImage_Array(LongArray(elements.size) { elements.elementAt(it).L })
fun VkImage_Array() = VkImage_Array(LongArray(0))


inline class VkImageView_Array(val array: LongArray) {

    operator fun get(index: Int) = VkImageView(array[index])
    operator fun set(index: Int, fence: VkImageView) = array.set(index, fence.L)

    val size get() = array.size
    val indices get() = array.indices

    inline fun forEach(action: (VkImageView) -> Unit) {
        for (element in array) action(VkImageView(element))
    }

    infix fun write(stack: MemoryStack): Adr = stack.LongPtr(size) { get(it).L }.adr
}

fun VkImageView_Array(size: Int, block: (Int) -> VkImageView) = VkImageView_Array(LongArray(size) { block(it).L })
fun VkImageView_Array(size: Int) = VkImageView_Array(LongArray(size))
fun VkImageView_Array(elements: Collection<VkImageView>) = VkImageView_Array(LongArray(elements.size) { elements.elementAt(it).L })
fun VkImageView_Array() = VkImageView_Array(LongArray(0))


inline class VkIndirectCommandsLayoutNVX_Array(val array: LongArray) {

    operator fun get(index: Int) = VkIndirectCommandsLayoutNVX(array[index])
    operator fun set(index: Int, fence: VkIndirectCommandsLayoutNVX) = array.set(index, fence.L)

    val size get() = array.size
    val indices get() = array.indices

    inline fun forEach(action: (VkIndirectCommandsLayoutNVX) -> Unit) {
        for (element in array) action(VkIndirectCommandsLayoutNVX(element))
    }

    infix fun write(stack: MemoryStack): Adr = stack.LongPtr(size) { get(it).L }.adr
}

fun VkIndirectCommandsLayoutNVX_Array(size: Int, block: (Int) -> VkIndirectCommandsLayoutNVX) = VkIndirectCommandsLayoutNVX_Array(LongArray(size) { block(it).L })
fun VkIndirectCommandsLayoutNVX_Array(size: Int) = VkIndirectCommandsLayoutNVX_Array(LongArray(size))
fun VkIndirectCommandsLayoutNVX_Array(elements: Collection<VkIndirectCommandsLayoutNVX>) = VkIndirectCommandsLayoutNVX_Array(LongArray(elements.size) { elements.elementAt(it).L })
fun VkIndirectCommandsLayoutNVX_Array() = VkIndirectCommandsLayoutNVX_Array(LongArray(0))


inline class VkObjectTableNVX_Array(val array: LongArray) {

    operator fun get(index: Int) = VkObjectTableNVX(array[index])
    operator fun set(index: Int, fence: VkObjectTableNVX) = array.set(index, fence.L)

    val size get() = array.size
    val indices get() = array.indices

    inline fun forEach(action: (VkObjectTableNVX) -> Unit) {
        for (element in array) action(VkObjectTableNVX(element))
    }

    infix fun write(stack: MemoryStack): Adr = stack.LongPtr(size) { get(it).L }.adr
}

fun VkObjectTableNVX_Array(size: Int, block: (Int) -> VkObjectTableNVX) = VkObjectTableNVX_Array(LongArray(size) { block(it).L })
fun VkObjectTableNVX_Array(size: Int) = VkObjectTableNVX_Array(LongArray(size))
fun VkObjectTableNVX_Array(elements: Collection<VkObjectTableNVX>) = VkObjectTableNVX_Array(LongArray(elements.size) { elements.elementAt(it).L })
fun VkObjectTableNVX_Array() = VkObjectTableNVX_Array(LongArray(0))


inline class VkPipeline_Array(val array: LongArray) {

    operator fun get(index: Int) = VkPipeline(array[index])
    operator fun set(index: Int, fence: VkPipeline) = array.set(index, fence.L)

    val size get() = array.size
    val indices get() = array.indices

    inline fun forEach(action: (VkPipeline) -> Unit) {
        for (element in array) action(VkPipeline(element))
    }

    infix fun write(stack: MemoryStack): Adr = stack.LongPtr(size) { get(it).L }.adr
}

fun VkPipeline_Array(size: Int, block: (Int) -> VkPipeline) = VkPipeline_Array(LongArray(size) { block(it).L })
fun VkPipeline_Array(size: Int) = VkPipeline_Array(LongArray(size))
fun VkPipeline_Array(elements: Collection<VkPipeline>) = VkPipeline_Array(LongArray(elements.size) { elements.elementAt(it).L })
fun VkPipeline_Array() = VkPipeline_Array(LongArray(0))


inline class VkPipelineCache_Array(val array: LongArray) {

    operator fun get(index: Int) = VkPipelineCache(array[index])
    operator fun set(index: Int, fence: VkPipelineCache) = array.set(index, fence.L)

    val size get() = array.size
    val indices get() = array.indices

    inline fun forEach(action: (VkPipelineCache) -> Unit) {
        for (element in array) action(VkPipelineCache(element))
    }

    infix fun write(stack: MemoryStack): Adr = stack.LongPtr(size) { get(it).L }.adr
}

fun VkPipelineCache_Array(size: Int, block: (Int) -> VkPipelineCache) = VkPipelineCache_Array(LongArray(size) { block(it).L })
fun VkPipelineCache_Array(size: Int) = VkPipelineCache_Array(LongArray(size))
fun VkPipelineCache_Array(elements: Collection<VkPipelineCache>) = VkPipelineCache_Array(LongArray(elements.size) { elements.elementAt(it).L })
fun VkPipelineCache_Array() = VkPipelineCache_Array(LongArray(0))


inline class VkPipelineLayout_Array(val array: LongArray) {

    operator fun get(index: Int) = VkPipelineLayout(array[index])
    operator fun set(index: Int, fence: VkPipelineLayout) = array.set(index, fence.L)

    val size get() = array.size
    val indices get() = array.indices

    inline fun forEach(action: (VkPipelineLayout) -> Unit) {
        for (element in array) action(VkPipelineLayout(element))
    }

    infix fun write(stack: MemoryStack): Adr = stack.LongPtr(size) { get(it).L }.adr
}

fun VkPipelineLayout_Array(size: Int, block: (Int) -> VkPipelineLayout) = VkPipelineLayout_Array(LongArray(size) { block(it).L })
fun VkPipelineLayout_Array(size: Int) = VkPipelineLayout_Array(LongArray(size))
fun VkPipelineLayout_Array(elements: Collection<VkPipelineLayout>) = VkPipelineLayout_Array(LongArray(elements.size) { elements.elementAt(it).L })
fun VkPipelineLayout_Array() = VkPipelineLayout_Array(LongArray(0))


inline class VkPresentModeKHR_Array(val array: IntArray) {

    operator fun get(index: Int) = VkPresentModeKHR(array[index])
    operator fun set(index: Int, result: VkPresentModeKHR) = array.set(index, result.i)

    val size get() = array.size
    val indices get() = array.indices

    inline fun forEach(action: (VkPresentModeKHR) -> Unit) {
        for (element in array) action(VkPresentModeKHR(element))
    }

    infix fun write(stack: MemoryStack): Adr = stack.IntPtr(size) { get(it).i }.adr
}

fun VkPresentModeKHR_Array(size: Int, block: (Int) -> VkPresentModeKHR) = VkPresentModeKHR_Array(IntArray(size) { block(it).i })
fun VkPresentModeKHR_Array(size: Int) = VkPresentModeKHR_Array(IntArray(size))
fun VkPresentModeKHR_Array(elements: Collection<VkPresentModeKHR>) = VkPresentModeKHR_Array(IntArray(elements.size) { elements.elementAt(it).i })
fun VkPresentModeKHR_Array() = VkPresentModeKHR_Array(IntArray(0))


inline class VkQueryPool_Array(val array: LongArray) {

    operator fun get(index: Int) = VkQueryPool(array[index])
    operator fun set(index: Int, fence: VkQueryPool) = array.set(index, fence.L)

    val size get() = array.size
    val indices get() = array.indices

    inline fun forEach(action: (VkQueryPool) -> Unit) {
        for (element in array) action(VkQueryPool(element))
    }

    infix fun write(stack: MemoryStack): Adr = stack.LongPtr(size) { get(it).L }.adr
}

fun VkQueryPool_Array(size: Int, block: (Int) -> VkQueryPool) = VkQueryPool_Array(LongArray(size) { block(it).L })
fun VkQueryPool_Array(size: Int) = VkQueryPool_Array(LongArray(size))
fun VkQueryPool_Array(elements: Collection<VkQueryPool>) = VkQueryPool_Array(LongArray(elements.size) { elements.elementAt(it).L })
fun VkQueryPool_Array() = VkQueryPool_Array(LongArray(0))


inline class VkRenderPass_Array(val array: LongArray) {

    operator fun get(index: Int) = VkRenderPass(array[index])
    operator fun set(index: Int, fence: VkRenderPass) = array.set(index, fence.L)

    val size get() = array.size
    val indices get() = array.indices

    inline fun forEach(action: (VkRenderPass) -> Unit) {
        for (element in array) action(VkRenderPass(element))
    }

    infix fun write(stack: MemoryStack): Adr = stack.LongPtr(size) { get(it).L }.adr
}

fun VkRenderPass_Array(size: Int, block: (Int) -> VkRenderPass) = VkRenderPass_Array(LongArray(size) { block(it).L })
fun VkRenderPass_Array(size: Int) = VkRenderPass_Array(LongArray(size))
fun VkRenderPass_Array(elements: Collection<VkRenderPass>) = VkRenderPass_Array(LongArray(elements.size) { elements.elementAt(it).L })
fun VkRenderPass_Array() = VkRenderPass_Array(LongArray(0))


inline class VkResult_Array(val array: IntArray) {

    operator fun get(index: Int) = VkResult(array[index])
    operator fun set(index: Int, result: VkResult) = array.set(index, result.i)

    val size get() = array.size
    val indices get() = array.indices

    inline fun forEach(action: (VkResult) -> Unit) {
        for (element in array) action(VkResult(element))
    }

    infix fun write(stack: MemoryStack): Adr = stack.IntPtr(size) { get(it).i }.adr
}

fun VkResult_Array(size: Int, block: (Int) -> VkResult) = VkResult_Array(IntArray(size) { block(it).i })
fun VkResult_Array(size: Int) = VkResult_Array(IntArray(size))
fun VkResult_Array(elements: Collection<VkResult>) = VkResult_Array(IntArray(elements.size) { elements.elementAt(it).i })
fun VkResult_Array() = VkResult_Array(IntArray(0))


inline class VkSampler_Array(val array: LongArray) {

    operator fun get(index: Int) = VkSampler(array[index])
    operator fun set(index: Int, fence: VkSampler) = array.set(index, fence.L)

    val size get() = array.size
    val indices get() = array.indices

    inline fun forEach(action: (VkSampler) -> Unit) {
        for (element in array) action(VkSampler(element))
    }

    infix fun write(stack: MemoryStack): Adr = stack.LongPtr(size) { get(it).L }.adr
}

fun VkSampler_Array(size: Int, block: (Int) -> VkSampler) = VkSampler_Array(LongArray(size) { block(it).L })
fun VkSampler_Array(size: Int) = VkSampler_Array(LongArray(size))
fun VkSampler_Array(elements: Collection<VkSampler>) = VkSampler_Array(LongArray(elements.size) { elements.elementAt(it).L })
fun VkSampler_Array() = VkSampler_Array(LongArray(0))


inline class VkSamplerYcbcrConversion_Array(val array: LongArray) {

    operator fun get(index: Int) = VkSamplerYcbcrConversion(array[index])
    operator fun set(index: Int, fence: VkSamplerYcbcrConversion) = array.set(index, fence.L)

    val size get() = array.size
    val indices get() = array.indices

    inline fun forEach(action: (VkSamplerYcbcrConversion) -> Unit) {
        for (element in array) action(VkSamplerYcbcrConversion(element))
    }

    infix fun write(stack: MemoryStack): Adr = stack.LongPtr(size) { get(it).L }.adr
}

fun VkSamplerYcbcrConversion_Array(size: Int, block: (Int) -> VkSamplerYcbcrConversion) = VkSamplerYcbcrConversion_Array(LongArray(size) { block(it).L })
fun VkSamplerYcbcrConversion_Array(size: Int) = VkSamplerYcbcrConversion_Array(LongArray(size))
fun VkSamplerYcbcrConversion_Array(elements: Collection<VkSamplerYcbcrConversion>) = VkSamplerYcbcrConversion_Array(LongArray(elements.size) { elements.elementAt(it).L })
fun VkSamplerYcbcrConversion_Array() = VkSamplerYcbcrConversion_Array(LongArray(0))


inline class VkSemaphore_Array(val array: LongArray) {

    operator fun get(index: Int) = VkSemaphore(array[index])
    operator fun set(index: Int, fence: VkSemaphore) = array.set(index, fence.L)

    val size get() = array.size
    val indices get() = array.indices

    inline fun forEach(action: (VkSemaphore) -> Unit) {
        for (element in array) action(VkSemaphore(element))
    }

    infix fun write(stack: MemoryStack): Adr = stack.LongPtr(size) { get(it).L }.adr
}

fun VkSemaphore_Array(size: Int, block: (Int) -> VkSemaphore) = VkSemaphore_Array(LongArray(size) { block(it).L })
fun VkSemaphore_Array(size: Int) = VkSemaphore_Array(LongArray(size))
fun VkSemaphore_Array(elements: Collection<VkSemaphore>) = VkSemaphore_Array(LongArray(elements.size) { elements.elementAt(it).L })
fun VkSemaphore_Array() = VkSemaphore_Array(LongArray(0))


inline class VkShaderModule_Array(val array: LongArray) {

    operator fun get(index: Int) = VkShaderModule(array[index])
    operator fun set(index: Int, fence: VkShaderModule) = array.set(index, fence.L)

    val size get() = array.size
    val indices get() = array.indices

    inline fun forEach(action: (VkShaderModule) -> Unit) {
        for (element in array) action(VkShaderModule(element))
    }

    infix fun write(stack: MemoryStack): Adr = stack.LongPtr(size) { get(it).L }.adr
}

fun VkShaderModule_Array(size: Int, block: (Int) -> VkShaderModule) = VkShaderModule_Array(LongArray(size) { block(it).L })
fun VkShaderModule_Array(size: Int) = VkShaderModule_Array(LongArray(size))
fun VkShaderModule_Array(elements: Collection<VkShaderModule>) = VkShaderModule_Array(LongArray(elements.size) { elements.elementAt(it).L })
fun VkShaderModule_Array() = VkShaderModule_Array(LongArray(0))


inline class VkSurfaceKHR_Array(val array: LongArray) {

    operator fun get(index: Int) = VkSurfaceKHR(array[index])
    operator fun set(index: Int, fence: VkSurfaceKHR) = array.set(index, fence.L)

    val size get() = array.size
    val indices get() = array.indices

    inline fun forEach(action: (VkSurfaceKHR) -> Unit) {
        for (element in array) action(VkSurfaceKHR(element))
    }

    infix fun write(stack: MemoryStack): Adr = stack.LongPtr(size) { get(it).L }.adr
}

fun VkSurfaceKHR_Array(size: Int, block: (Int) -> VkSurfaceKHR) = VkSurfaceKHR_Array(LongArray(size) { block(it).L })
fun VkSurfaceKHR_Array(size: Int) = VkSurfaceKHR_Array(LongArray(size))
fun VkSurfaceKHR_Array(elements: Collection<VkSurfaceKHR>) = VkSurfaceKHR_Array(LongArray(elements.size) { elements.elementAt(it).L })
fun VkSurfaceKHR_Array() = VkSurfaceKHR_Array(LongArray(0))


inline class VkSwapchainKHR_Array(val array: LongArray) {

    operator fun get(index: Int) = VkSwapchainKHR(array[index])
    operator fun set(index: Int, fence: VkSwapchainKHR) = array.set(index, fence.L)

    val size get() = array.size
    val indices get() = array.indices

    inline fun forEach(action: (VkSwapchainKHR) -> Unit) {
        for (element in array) action(VkSwapchainKHR(element))
    }

    infix fun write(stack: MemoryStack): Adr = stack.LongPtr(size) { get(it).L }.adr
}

fun VkSwapchainKHR_Array(size: Int, block: (Int) -> VkSwapchainKHR) = VkSwapchainKHR_Array(LongArray(size) { block(it).L })
fun VkSwapchainKHR_Array(size: Int) = VkSwapchainKHR_Array(LongArray(size))
fun VkSwapchainKHR_Array(elements: Collection<VkSwapchainKHR>) = VkSwapchainKHR_Array(LongArray(elements.size) { elements.elementAt(it).L })
fun VkSwapchainKHR_Array() = VkSwapchainKHR_Array(LongArray(0))


inline class VkValidationCacheEXT_Array(val array: LongArray) {

    operator fun get(index: Int) = VkValidationCacheEXT(array[index])
    operator fun set(index: Int, fence: VkValidationCacheEXT) = array.set(index, fence.L)

    val size get() = array.size
    val indices get() = array.indices

    inline fun forEach(action: (VkValidationCacheEXT) -> Unit) {
        for (element in array) action(VkValidationCacheEXT(element))
    }

    infix fun write(stack: MemoryStack): Adr = stack.LongPtr(size) { get(it).L }.adr
}

fun VkValidationCacheEXT_Array(size: Int, block: (Int) -> VkValidationCacheEXT) = VkValidationCacheEXT_Array(LongArray(size) { block(it).L })
fun VkValidationCacheEXT_Array(size: Int) = VkValidationCacheEXT_Array(LongArray(size))
fun VkValidationCacheEXT_Array(elements: Collection<VkValidationCacheEXT>) = VkValidationCacheEXT_Array(LongArray(elements.size) { elements.elementAt(it).L })
fun VkValidationCacheEXT_Array() = VkValidationCacheEXT_Array(LongArray(0))