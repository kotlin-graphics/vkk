package vkk.entities

import kool.*
import kool.lib.isEmpty
import kool.lib.isNotEmpty
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryStack.stackGet
import vkk.VkDynamicState
import vkk.VkFormat
import vkk.vk
import java.nio.IntBuffer
import java.nio.LongBuffer

inline class VkAccelerationStructureNV_Buffer(val buffer: LongBuffer) {
    operator fun get(index: Int) = VkAccelerationStructureNV(buffer[index])
    operator fun set(index: Int, value: VkAccelerationStructureNV) {
        buffer[index] = value.L
    }

    val rem get() = buffer.rem
    val adr get() = buffer.adr
    var pos
        get() = buffer.pos
        set(value) {
            buffer.pos = value
        }
    var lim
        get() = buffer.lim
        set(value) {
            buffer.lim = value
        }

    infix fun put(src: VkAccelerationStructureNV_Buffer) {
        buffer.put(src.buffer)
    }

    fun flip() {
        buffer.flip()
    }
}

fun VkAccelerationStructureNV_Buffer(size: Int, block: (Int) -> VkAccelerationStructureNV) = VkAccelerationStructureNV_Buffer(LongBuffer(size) { block(it).L })
fun VkAccelerationStructureNV_Buffer(size: Int) = VkAccelerationStructureNV_Buffer(LongBuffer(size))
fun VkAccelerationStructureNV_Buffer(elements: Collection<VkAccelerationStructureNV>) = VkAccelerationStructureNV_Buffer(LongBuffer(elements.size) { elements.elementAt(it).L })

fun vk.AccelerationStructureNV_Buffer(size: Int, block: (Int) -> VkAccelerationStructureNV) = VkAccelerationStructureNV_Buffer(stackGet().LongBuffer(size) { block(it).L })
fun vk.AccelerationStructureNV_Buffer(size: Int) = VkAccelerationStructureNV_Buffer(stackGet().LongBuffer(size))
fun vk.AccelerationStructureNV_Buffer(elements: Collection<VkAccelerationStructureNV>) = VkAccelerationStructureNV_Buffer(stackGet().LongBuffer(elements.size) { elements.elementAt(it).L })


inline class VkBuffer_Buffer(val buffer: LongBuffer) {
    operator fun get(index: Int) = VkBuffer(buffer[index])
    operator fun set(index: Int, value: VkBuffer) {
        buffer[index] = value.L
    }

    val rem get() = buffer.rem
    val adr get() = buffer.adr
    var pos
        get() = buffer.pos
        set(value) {
            buffer.pos = value
        }
    var lim
        get() = buffer.lim
        set(value) {
            buffer.lim = value
        }

    infix fun put(src: VkBuffer_Buffer) {
        buffer.put(src.buffer)
    }

    fun flip() {
        buffer.flip()
    }
}

fun VkBuffer_Buffer(size: Int, block: (Int) -> VkBuffer) = VkBuffer_Buffer(LongBuffer(size) { block(it).L })
fun VkBuffer_Buffer(size: Int) = VkBuffer_Buffer(LongBuffer(size))
fun VkBuffer_Buffer(elements: Collection<VkBuffer>) = VkBuffer_Buffer(LongBuffer(elements.size) { elements.elementAt(it).L })

fun vk.Buffer_Buffer(size: Int, block: (Int) -> VkBuffer) = VkBuffer_Buffer(stackGet().LongBuffer(size) { block(it).L })
fun vk.Buffer_Buffer(size: Int) = VkBuffer_Buffer(stackGet().LongBuffer(size))
fun vk.Buffer_Buffer(elements: Collection<VkBuffer>) = VkBuffer_Buffer(stackGet().LongBuffer(elements.size) { elements.elementAt(it).L })


inline class VkBufferView_Buffer(val buffer: LongBuffer) {
    operator fun get(index: Int) = VkBufferView(buffer[index])
    operator fun set(index: Int, value: VkBufferView) {
        buffer[index] = value.L
    }

    val rem get() = buffer.rem
    val adr get() = buffer.adr
    var pos
        get() = buffer.pos
        set(value) {
            buffer.pos = value
        }
    var lim
        get() = buffer.lim
        set(value) {
            buffer.lim = value
        }

    infix fun put(src: VkBufferView_Buffer) {
        buffer.put(src.buffer)
    }

    fun flip() {
        buffer.flip()
    }
}

fun VkBufferView_Buffer(size: Int, block: (Int) -> VkBufferView) = VkBufferView_Buffer(LongBuffer(size) { block(it).L })
fun VkBufferView_Buffer(size: Int) = VkBufferView_Buffer(LongBuffer(size))
fun VkBufferView_Buffer(elements: Collection<VkBufferView>) = VkBufferView_Buffer(LongBuffer(elements.size) { elements.elementAt(it).L })

fun vk.BufferView_Buffer(size: Int, block: (Int) -> VkBufferView) = VkBufferView_Buffer(LongBuffer(size) { block(it).L })
fun vk.BufferView_Buffer(size: Int) = VkBufferView_Buffer(LongBuffer(size))
fun vk.BufferView_Buffer(elements: Collection<VkBufferView>) = VkBufferView_Buffer(LongBuffer(elements.size) { elements.elementAt(it).L })


inline class VkCommandPool_Buffer(val buffer: LongBuffer) {
    operator fun get(index: Int) = VkCommandPool(buffer[index])
    operator fun set(index: Int, value: VkCommandPool) {
        buffer[index] = value.L
    }

    val rem get() = buffer.rem
    val adr get() = buffer.adr
    var pos
        get() = buffer.pos
        set(value) {
            buffer.pos = value
        }
    var lim
        get() = buffer.lim
        set(value) {
            buffer.lim = value
        }

    infix fun put(src: VkCommandPool_Buffer) {
        buffer.put(src.buffer)
    }

    fun flip() {
        buffer.flip()
    }
}

fun VkCommandPool_Buffer(size: Int, block: (Int) -> VkCommandPool) = VkCommandPool_Buffer(LongBuffer(size) { block(it).L })
fun VkCommandPool_Buffer(size: Int) = VkCommandPool_Buffer(LongBuffer(size))
fun VkCommandPool_Buffer(elements: Collection<VkCommandPool>) = VkCommandPool_Buffer(LongBuffer(elements.size) { elements.elementAt(it).L })

fun vk.CommandPool_Buffer(size: Int, block: (Int) -> VkCommandPool) = VkCommandPool_Buffer(stackGet().LongBuffer(size) { block(it).L })
fun vk.CommandPool_Buffer(size: Int) = VkCommandPool_Buffer(stackGet().LongBuffer(size))
fun vk.CommandPool_Buffer(elements: Collection<VkCommandPool>) = VkCommandPool_Buffer(stackGet().LongBuffer(elements.size) { elements.elementAt(it).L })


inline class VkDebugReportCallback_Buffer(val buffer: LongBuffer) {
    operator fun get(index: Int) = VkDebugReportCallback(buffer[index])
    operator fun set(index: Int, value: VkDebugReportCallback) {
        buffer[index] = value.L
    }

    val rem get() = buffer.rem
    val adr get() = buffer.adr
    var pos
        get() = buffer.pos
        set(value) {
            buffer.pos = value
        }
    var lim
        get() = buffer.lim
        set(value) {
            buffer.lim = value
        }

    infix fun put(src: VkDebugReportCallback_Buffer) {
        buffer.put(src.buffer)
    }

    fun flip() {
        buffer.flip()
    }
}

fun VkDebugReportCallback_Buffer(size: Int, block: (Int) -> VkDebugReportCallback) = VkDebugReportCallback_Buffer(LongBuffer(size) { block(it).L })
fun VkDebugReportCallback_Buffer(size: Int) = VkDebugReportCallback_Buffer(LongBuffer(size))
fun VkDebugReportCallback_Buffer(elements: Collection<VkDebugReportCallback>) = VkDebugReportCallback_Buffer(LongBuffer(elements.size) { elements.elementAt(it).L })

fun vk.DebugReportCallback_Buffer(size: Int, block: (Int) -> VkDebugReportCallback) = VkDebugReportCallback_Buffer(stackGet().LongBuffer(size) { block(it).L })
fun vk.DebugReportCallback_Buffer(size: Int) = VkDebugReportCallback_Buffer(stackGet().LongBuffer(size))
fun vk.DebugReportCallback_Buffer(elements: Collection<VkDebugReportCallback>) = VkDebugReportCallback_Buffer(stackGet().LongBuffer(elements.size) { elements.elementAt(it).L })

inline class VkDebugUtilsMessengerEXT_Buffer(val buffer: LongBuffer) {
    operator fun get(index: Int) = VkDebugUtilsMessengerEXT(buffer[index])
    operator fun set(index: Int, value: VkDebugUtilsMessengerEXT) {
        buffer[index] = value.L
    }

    val rem get() = buffer.rem
    val adr get() = buffer.adr
    var pos
        get() = buffer.pos
        set(value) {
            buffer.pos = value
        }
    var lim
        get() = buffer.lim
        set(value) {
            buffer.lim = value
        }

    infix fun put(src: VkDebugUtilsMessengerEXT_Buffer) {
        buffer.put(src.buffer)
    }

    fun flip() {
        buffer.flip()
    }
}

fun VkDebugUtilsMessengerEXT_Buffer(size: Int, block: (Int) -> VkDebugUtilsMessengerEXT) = VkDebugUtilsMessengerEXT_Buffer(LongBuffer(size) { block(it).L })
fun VkDebugUtilsMessengerEXT_Buffer(size: Int) = VkDebugUtilsMessengerEXT_Buffer(LongBuffer(size))
fun VkDebugUtilsMessengerEXT_Buffer(elements: Collection<VkDebugUtilsMessengerEXT>) = VkDebugUtilsMessengerEXT_Buffer(LongBuffer(elements.size) { elements.elementAt(it).L })

fun vk.DebugUtilsMessengerEXT_Buffer(size: Int, block: (Int) -> VkDebugUtilsMessengerEXT) = VkDebugUtilsMessengerEXT_Buffer(stackGet().LongBuffer(size) { block(it).L })
fun vk.DebugUtilsMessengerEXT_Buffer(size: Int) = VkDebugUtilsMessengerEXT_Buffer(stackGet().LongBuffer(size))
fun vk.DebugUtilsMessengerEXT_Buffer(elements: Collection<VkDebugUtilsMessengerEXT>) = VkDebugUtilsMessengerEXT_Buffer(stackGet().LongBuffer(elements.size) { elements.elementAt(it).L })


inline class VkDescriptorPool_Buffer(val buffer: LongBuffer) {
    operator fun get(index: Int) = VkDescriptorPool(buffer[index])
    operator fun set(index: Int, value: VkDescriptorPool) {
        buffer[index] = value.L
    }

    val rem get() = buffer.rem
    val adr get() = buffer.adr
    var pos
        get() = buffer.pos
        set(value) {
            buffer.pos = value
        }
    var lim
        get() = buffer.lim
        set(value) {
            buffer.lim = value
        }

    infix fun put(src: VkDescriptorPool_Buffer) {
        buffer.put(src.buffer)
    }

    fun flip() {
        buffer.flip()
    }
}

fun VkDescriptorPool_Buffer(size: Int, block: (Int) -> VkDescriptorPool) = VkDescriptorPool_Buffer(LongBuffer(size) { block(it).L })
fun VkDescriptorPool_Buffer(size: Int) = VkDescriptorPool_Buffer(LongBuffer(size))
fun VkDescriptorPool_Buffer(elements: Collection<VkDescriptorPool>) = VkDescriptorPool_Buffer(LongBuffer(elements.size) { elements.elementAt(it).L })

fun vk.DescriptorPool_Buffer(size: Int, block: (Int) -> VkDescriptorPool) = VkDescriptorPool_Buffer(stackGet().LongBuffer(size) { block(it).L })
fun vk.DescriptorPool_Buffer(size: Int) = VkDescriptorPool_Buffer(stackGet().LongBuffer(size))
fun vk.DescriptorPool_Buffer(elements: Collection<VkDescriptorPool>) = VkDescriptorPool_Buffer(stackGet().LongBuffer(elements.size) { elements.elementAt(it).L })


inline class VkDescriptorSet_Buffer(val buffer: LongBuffer) {
    operator fun get(index: Int) = VkDescriptorSet(buffer[index])
    operator fun set(index: Int, value: VkDescriptorSet) {
        buffer[index] = value.L
    }

    val rem get() = buffer.rem
    val adr get() = buffer.adr
    var pos
        get() = buffer.pos
        set(value) {
            buffer.pos = value
        }
    var lim
        get() = buffer.lim
        set(value) {
            buffer.lim = value
        }

    infix fun put(src: VkDescriptorSet_Buffer) {
        buffer.put(src.buffer)
    }

    fun flip() {
        buffer.flip()
    }
}

fun VkDescriptorSet_Buffer(size: Int, block: (Int) -> VkDescriptorSet) = VkDescriptorSet_Buffer(LongBuffer(size) { block(it).L })
fun VkDescriptorSet_Buffer(size: Int) = VkDescriptorSet_Buffer(LongBuffer(size))
fun VkDescriptorSet_Buffer(elements: Collection<VkDescriptorSet>) = VkDescriptorSet_Buffer(LongBuffer(elements.size) { elements.elementAt(it).L })

fun vk.DescriptorSet_Buffer(size: Int, block: (Int) -> VkDescriptorSet) = VkDescriptorSet_Buffer(stackGet().LongBuffer(size) { block(it).L })
fun vk.DescriptorSet_Buffer(size: Int) = VkDescriptorSet_Buffer(stackGet().LongBuffer(size))
fun vk.DescriptorSet_Buffer(elements: Collection<VkDescriptorSet>) = VkDescriptorSet_Buffer(stackGet().LongBuffer(elements.size) { elements.elementAt(it).L })


inline class VkDescriptorSetLayout_Buffer(val buffer: LongBuffer) {
    operator fun get(index: Int) = VkDescriptorSetLayout(buffer[index])
    operator fun set(index: Int, value: VkDescriptorSetLayout) {
        buffer[index] = value.L
    }

    val rem get() = buffer.rem
    val adr get() = buffer.adr
    var pos
        get() = buffer.pos
        set(value) {
            buffer.pos = value
        }
    var lim
        get() = buffer.lim
        set(value) {
            buffer.lim = value
        }

    infix fun put(src: VkDescriptorSetLayout_Buffer) {
        buffer.put(src.buffer)
    }

    fun flip() {
        buffer.flip()
    }
}

fun VkDescriptorSetLayout_Buffer(size: Int, block: (Int) -> VkDescriptorSetLayout) = VkDescriptorSetLayout_Buffer(LongBuffer(size) { block(it).L })
fun VkDescriptorSetLayout_Buffer(size: Int) = VkDescriptorSetLayout_Buffer(LongBuffer(size))
fun VkDescriptorSetLayout_Buffer(elements: Collection<VkDescriptorSetLayout>) = VkDescriptorSetLayout_Buffer(LongBuffer(elements.size) { elements.elementAt(it).L })

fun vk.DescriptorSetLayout_Buffer(size: Int, block: (Int) -> VkDescriptorSetLayout) = VkDescriptorSetLayout_Buffer(stackGet().LongBuffer(size) { block(it).L })
fun vk.DescriptorSetLayout_Buffer(size: Int) = VkDescriptorSetLayout_Buffer(stackGet().LongBuffer(size))
fun vk.DescriptorSetLayout_Buffer(elements: Collection<VkDescriptorSetLayout>) = VkDescriptorSetLayout_Buffer(stackGet().LongBuffer(elements.size) { elements.elementAt(it).L })


inline class VkDescriptorUpdateTemplate_Buffer(val buffer: LongBuffer) {
    operator fun get(index: Int) = VkDescriptorUpdateTemplate(buffer[index])
    operator fun set(index: Int, value: VkDescriptorUpdateTemplate) {
        buffer[index] = value.L
    }

    val rem get() = buffer.rem
    val adr get() = buffer.adr
    var pos
        get() = buffer.pos
        set(value) {
            buffer.pos = value
        }
    var lim
        get() = buffer.lim
        set(value) {
            buffer.lim = value
        }

    infix fun put(src: VkDescriptorUpdateTemplate_Buffer) {
        buffer.put(src.buffer)
    }

    fun flip() {
        buffer.flip()
    }
}

fun VkDescriptorUpdateTemplate_Buffer(size: Int, block: (Int) -> VkDescriptorUpdateTemplate) = VkDescriptorUpdateTemplate_Buffer(LongBuffer(size) { block(it).L })
fun VkDescriptorUpdateTemplate_Buffer(size: Int) = VkDescriptorUpdateTemplate_Buffer(LongBuffer(size))
fun VkDescriptorUpdateTemplate_Buffer(elements: Collection<VkDescriptorUpdateTemplate>) = VkDescriptorUpdateTemplate_Buffer(LongBuffer(elements.size) { elements.elementAt(it).L })

fun vk.DescriptorUpdateTemplate_Buffer(size: Int, block: (Int) -> VkDescriptorUpdateTemplate) = VkDescriptorUpdateTemplate_Buffer(stackGet().LongBuffer(size) { block(it).L })
fun vk.DescriptorUpdateTemplate_Buffer(size: Int) = VkDescriptorUpdateTemplate_Buffer(stackGet().LongBuffer(size))
fun vk.DescriptorUpdateTemplate_Buffer(elements: Collection<VkDescriptorUpdateTemplate>) = VkDescriptorUpdateTemplate_Buffer(stackGet().LongBuffer(elements.size) { elements.elementAt(it).L })


inline class VkDeviceMemory_Buffer(val buffer: LongBuffer) {
    operator fun get(index: Int) = VkDeviceMemory(buffer[index])
    operator fun set(index: Int, value: VkDeviceMemory) {
        buffer[index] = value.L
    }

    val rem get() = buffer.rem
    val adr get() = buffer.adr
    var pos
        get() = buffer.pos
        set(value) {
            buffer.pos = value
        }
    var lim
        get() = buffer.lim
        set(value) {
            buffer.lim = value
        }

    infix fun put(src: VkDeviceMemory_Buffer) {
        buffer.put(src.buffer)
    }

    fun flip() {
        buffer.flip()
    }
}

fun VkDeviceMemory_Buffer(size: Int, block: (Int) -> VkDeviceMemory) = VkDeviceMemory_Buffer(LongBuffer(size) { block(it).L })
fun VkDeviceMemory_Buffer(size: Int) = VkDeviceMemory_Buffer(LongBuffer(size))
fun VkDeviceMemory_Buffer(elements: Collection<VkDeviceMemory>) = VkDeviceMemory_Buffer(LongBuffer(elements.size) { elements.elementAt(it).L })

fun vk.DeviceMemory_Buffer(size: Int, block: (Int) -> VkDeviceMemory) = VkDeviceMemory_Buffer(stackGet().LongBuffer(size) { block(it).L })
fun vk.DeviceMemory_Buffer(size: Int) = VkDeviceMemory_Buffer(stackGet().LongBuffer(size))
fun vk.DeviceMemory_Buffer(elements: Collection<VkDeviceMemory>) = VkDeviceMemory_Buffer(stackGet().LongBuffer(elements.size) { elements.elementAt(it).L })


inline class VkDeviceSize_Buffer(val buffer: LongBuffer) {
    operator fun get(index: Int) = VkDeviceSize(buffer[index])
    operator fun set(index: Int, value: VkDeviceSize) {
        buffer[index] = value.L
    }

    val rem get() = buffer.rem
    val adr get() = buffer.adr
    var pos
        get() = buffer.pos
        set(value) {
            buffer.pos = value
        }
    var lim
        get() = buffer.lim
        set(value) {
            buffer.lim = value
        }

    infix fun put(src: VkDeviceSize_Buffer) {
        buffer.put(src.buffer)
    }

    fun flip() {
        buffer.flip()
    }
}

fun VkDeviceSize_Buffer(size: Int, block: (Int) -> VkDeviceSize) = VkDeviceSize_Buffer(LongBuffer(size) { block(it).L })
fun VkDeviceSize_Buffer(size: Int) = VkDeviceSize_Buffer(LongBuffer(size))
fun VkDeviceSize_Buffer(elements: Collection<VkDeviceSize>) = VkDeviceSize_Buffer(LongBuffer(elements.size) { elements.elementAt(it).L })

fun vk.DeviceSize_Buffer(size: Int, block: (Int) -> VkDeviceSize) = VkDeviceSize_Buffer(stackGet().LongBuffer(size) { block(it).L })
fun vk.DeviceSize_Buffer(size: Int) = VkDeviceSize_Buffer(stackGet().LongBuffer(size))
fun vk.DeviceSize_Buffer(elements: Collection<VkDeviceSize>) = VkDeviceSize_Buffer(stackGet().LongBuffer(elements.size) { elements.elementAt(it).L })


inline class VkDisplayKHR_Buffer(val buffer: LongBuffer) {
    operator fun get(index: Int) = VkDisplayKHR(buffer[index])
    operator fun set(index: Int, value: VkDisplayKHR) {
        buffer[index] = value.L
    }

    val rem get() = buffer.rem
    val adr get() = buffer.adr
    var pos
        get() = buffer.pos
        set(value) {
            buffer.pos = value
        }
    var lim
        get() = buffer.lim
        set(value) {
            buffer.lim = value
        }

    infix fun put(src: VkDisplayKHR_Buffer) {
        buffer.put(src.buffer)
    }

    fun flip() {
        buffer.flip()
    }
}

fun VkDisplayKHR_Buffer(size: Int, block: (Int) -> VkDisplayKHR) = VkDisplayKHR_Buffer(LongBuffer(size) { block(it).L })
fun VkDisplayKHR_Buffer(size: Int) = VkDisplayKHR_Buffer(LongBuffer(size))
fun VkDisplayKHR_Buffer(elements: Collection<VkDisplayKHR>) = VkDisplayKHR_Buffer(LongBuffer(elements.size) { elements.elementAt(it).L })

fun vk.DisplayKHR_Buffer(size: Int, block: (Int) -> VkDisplayKHR) = VkDisplayKHR_Buffer(stackGet().LongBuffer(size) { block(it).L })
fun vk.DisplayKHR_Buffer(size: Int) = VkDisplayKHR_Buffer(stackGet().LongBuffer(size))
fun vk.DisplayKHR_Buffer(elements: Collection<VkDisplayKHR>) = VkDisplayKHR_Buffer(stackGet().LongBuffer(elements.size) { elements.elementAt(it).L })


inline class VkDisplayModeKHR_Buffer(val buffer: LongBuffer) {
    operator fun get(index: Int) = VkDisplayModeKHR(buffer[index])
    operator fun set(index: Int, value: VkDisplayModeKHR) {
        buffer[index] = value.L
    }

    val rem get() = buffer.rem
    val adr get() = buffer.adr
    var pos
        get() = buffer.pos
        set(value) {
            buffer.pos = value
        }
    var lim
        get() = buffer.lim
        set(value) {
            buffer.lim = value
        }

    infix fun put(src: VkDisplayModeKHR_Buffer) {
        buffer.put(src.buffer)
    }

    fun flip() {
        buffer.flip()
    }
}

fun VkDisplayModeKHR_Buffer(size: Int, block: (Int) -> VkDisplayModeKHR) = VkDisplayModeKHR_Buffer(LongBuffer(size) { block(it).L })
fun VkDisplayModeKHR_Buffer(size: Int) = VkDisplayModeKHR_Buffer(LongBuffer(size))
fun VkDisplayModeKHR_Buffer(elements: Collection<VkDisplayModeKHR>) = VkDisplayModeKHR_Buffer(LongBuffer(elements.size) { elements.elementAt(it).L })

fun vk.DisplayModeKHR_Buffer(size: Int, block: (Int) -> VkDisplayModeKHR) = VkDisplayModeKHR_Buffer(stackGet().LongBuffer(size) { block(it).L })
fun vk.DisplayModeKHR_Buffer(size: Int) = VkDisplayModeKHR_Buffer(stackGet().LongBuffer(size))
fun vk.DisplayModeKHR_Buffer(elements: Collection<VkDisplayModeKHR>) = VkDisplayModeKHR_Buffer(stackGet().LongBuffer(elements.size) { elements.elementAt(it).L })


inline class VkEvent_Buffer(val buffer: LongBuffer) {
    operator fun get(index: Int) = VkEvent(buffer[index])
    operator fun set(index: Int, value: VkEvent) {
        buffer[index] = value.L
    }

    val rem get() = buffer.rem
    val adr get() = buffer.adr
    var pos
        get() = buffer.pos
        set(value) {
            buffer.pos = value
        }
    var lim
        get() = buffer.lim
        set(value) {
            buffer.lim = value
        }

    infix fun put(src: VkEvent_Buffer) {
        buffer.put(src.buffer)
    }

    fun flip() {
        buffer.flip()
    }
}

fun VkEvent_Buffer(size: Int, block: (Int) -> VkEvent) = VkEvent_Buffer(LongBuffer(size) { block(it).L })
fun VkEvent_Buffer(size: Int) = VkEvent_Buffer(LongBuffer(size))
fun VkEvent_Buffer(elements: Collection<VkEvent>) = VkEvent_Buffer(LongBuffer(elements.size) { elements.elementAt(it).L })

fun vk.Event_Buffer(size: Int, block: (Int) -> VkEvent) = VkEvent_Buffer(stackGet().LongBuffer(size) { block(it).L })
fun vk.Event_Buffer(size: Int) = VkEvent_Buffer(stackGet().LongBuffer(size))
fun vk.Event_Buffer(elements: Collection<VkEvent>) = VkEvent_Buffer(stackGet().LongBuffer(elements.size) { elements.elementAt(it).L })


inline class VkFence_Buffer(val buffer: LongBuffer) {
    operator fun get(index: Int) = VkFence(buffer[index])
    operator fun set(index: Int, value: VkFence) {
        buffer[index] = value.L
    }

    val rem get() = buffer.rem
    val adr get() = buffer.adr
    var pos
        get() = buffer.pos
        set(value) {
            buffer.pos = value
        }
    var lim
        get() = buffer.lim
        set(value) {
            buffer.lim = value
        }

    infix fun put(src: VkFence_Buffer) {
        buffer.put(src.buffer)
    }

    fun flip() {
        buffer.flip()
    }
}

fun VkFence_Buffer(size: Int, block: (Int) -> VkFence) = VkFence_Buffer(LongBuffer(size) { block(it).L })
fun VkFence_Buffer(size: Int) = VkFence_Buffer(LongBuffer(size))
fun VkFence_Buffer(elements: Collection<VkFence>) = VkFence_Buffer(LongBuffer(elements.size) { elements.elementAt(it).L })

fun vk.Fence_Buffer(size: Int, block: (Int) -> VkFence) = VkFence_Buffer(stackGet().LongBuffer(size) { block(it).L })
fun vk.Fence_Buffer(size: Int) = VkFence_Buffer(stackGet().LongBuffer(size))
fun vk.Fence_Buffer(elements: Collection<VkFence>) = VkFence_Buffer(stackGet().LongBuffer(elements.size) { elements.elementAt(it).L })


inline class VkFramebuffer_Buffer(val buffer: LongBuffer) {
    operator fun get(index: Int) = VkFramebuffer(buffer[index])
    operator fun set(index: Int, value: VkFramebuffer) {
        buffer[index] = value.L
    }

    val rem get() = buffer.rem
    val adr get() = buffer.adr
    var pos
        get() = buffer.pos
        set(value) {
            buffer.pos = value
        }
    var lim
        get() = buffer.lim
        set(value) {
            buffer.lim = value
        }

    infix fun put(src: VkFramebuffer_Buffer) {
        buffer.put(src.buffer)
    }

    fun flip() {
        buffer.flip()
    }
}

fun VkFramebuffer_Buffer(size: Int, block: (Int) -> VkFramebuffer) = VkFramebuffer_Buffer(LongBuffer(size) { block(it).L })
fun VkFramebuffer_Buffer(size: Int) = VkFramebuffer_Buffer(LongBuffer(size))
fun VkFramebuffer_Buffer(elements: Collection<VkFramebuffer>) = VkFramebuffer_Buffer(LongBuffer(elements.size) { elements.elementAt(it).L })

fun vk.Framebuffer_Buffer(size: Int, block: (Int) -> VkFramebuffer) = VkFramebuffer_Buffer(stackGet().LongBuffer(size) { block(it).L })
fun vk.Framebuffer_Buffer(size: Int) = VkFramebuffer_Buffer(stackGet().LongBuffer(size))
fun vk.Framebuffer_Buffer(elements: Collection<VkFramebuffer>) = VkFramebuffer_Buffer(stackGet().LongBuffer(elements.size) { elements.elementAt(it).L })


inline class VkFormat_Buffer(val buffer: IntBuffer) {
    operator fun get(index: Int) = VkFormat(buffer[index])
    operator fun set(index: Int, value: VkFormat) {
        buffer[index] = value.i
    }

    val rem get() = buffer.rem
    val adr get() = buffer.adr
    var pos
        get() = buffer.pos
        set(value) {
            buffer.pos = value
        }
    var lim
        get() = buffer.lim
        set(value) {
            buffer.lim = value
        }

    infix fun put(src: VkFormat_Buffer) {
        buffer.put(src.buffer)
    }

    fun flip() {
        buffer.flip()
    }
}

fun VkFormat_Buffer(size: Int, block: (Int) -> VkFormat) = VkFormat_Buffer(IntBuffer(size) { block(it).i })
fun VkFormat_Buffer(size: Int) = VkFormat_Buffer(IntBuffer(size))
fun VkFormat_Buffer(elements: Collection<VkFormat>) = VkFormat_Buffer(IntBuffer(elements.size) { elements.elementAt(it).i })

fun vk.Format_Buffer(size: Int, block: (Int) -> VkFormat) = VkFormat_Buffer(stackGet().IntBuffer(size) { block(it).i })
fun vk.Format_Buffer(size: Int) = VkFormat_Buffer(stackGet().IntBuffer(size))
fun vk.Format_Buffer(elements: Collection<VkFormat>) = VkFormat_Buffer(stackGet().IntBuffer(elements.size) { elements.elementAt(it).i })


inline class VkImage_Buffer(val buffer: LongBuffer) {
    operator fun get(index: Int) = VkImage(buffer[index])
    operator fun set(index: Int, value: VkImage) {
        buffer[index] = value.L
    }

    val rem get() = buffer.rem
    val adr get() = buffer.adr
    var pos
        get() = buffer.pos
        set(value) {
            buffer.pos = value
        }
    var lim
        get() = buffer.lim
        set(value) {
            buffer.lim = value
        }

    infix fun put(src: VkImage_Buffer) {
        buffer.put(src.buffer)
    }

    fun flip() {
        buffer.flip()
    }
}

fun VkImage_Buffer(size: Int, block: (Int) -> VkImage) = VkImage_Buffer(LongBuffer(size) { block(it).L })
fun VkImage_Buffer(size: Int) = VkImage_Buffer(LongBuffer(size))
fun VkImage_Buffer(elements: Collection<VkImage>) = VkImage_Buffer(LongBuffer(elements.size) { elements.elementAt(it).L })

fun vk.Image_Buffer(size: Int, block: (Int) -> VkImage) = VkImage_Buffer(stackGet().LongBuffer(size) { block(it).L })
fun vk.Image_Buffer(size: Int) = VkImage_Buffer(stackGet().LongBuffer(size))
fun vk.Image_Buffer(elements: Collection<VkImage>) = VkImage_Buffer(stackGet().LongBuffer(elements.size) { elements.elementAt(it).L })


inline class VkImageView_Buffer(val buffer: LongBuffer) {
    operator fun get(index: Int) = VkImageView(buffer[index])
    operator fun set(index: Int, value: VkImageView) {
        buffer[index] = value.L
    }

    val rem get() = buffer.rem
    val adr get() = buffer.adr
    var pos
        get() = buffer.pos
        set(value) {
            buffer.pos = value
        }
    var lim
        get() = buffer.lim
        set(value) {
            buffer.lim = value
        }

    infix fun put(src: VkImageView_Buffer) {
        buffer.put(src.buffer)
    }

    fun flip() {
        buffer.flip()
    }
}

fun VkImageView_Buffer(size: Int, block: (Int) -> VkImageView) = VkImageView_Buffer(LongBuffer(size) { block(it).L })
fun VkImageView_Buffer(size: Int) = VkImageView_Buffer(LongBuffer(size))
fun VkImageView_Buffer(elements: Collection<VkImageView>) = VkImageView_Buffer(LongBuffer(elements.size) { elements.elementAt(it).L })

fun vk.ImageView_Buffer(size: Int, block: (Int) -> VkImageView) = VkImageView_Buffer(stackGet().LongBuffer(size) { block(it).L })
fun vk.ImageView_Buffer(size: Int) = VkImageView_Buffer(stackGet().LongBuffer(size))
fun vk.ImageView_Buffer(elements: Collection<VkImageView>) = VkImageView_Buffer(stackGet().LongBuffer(elements.size) { elements.elementAt(it).L })


inline class VkIndirectCommandsLayoutNVX_Buffer(val buffer: LongBuffer) {
    operator fun get(index: Int) = VkIndirectCommandsLayoutNVX(buffer[index])
    operator fun set(index: Int, value: VkIndirectCommandsLayoutNVX) {
        buffer[index] = value.L
    }

    val rem get() = buffer.rem
    val adr get() = buffer.adr
    var pos
        get() = buffer.pos
        set(value) {
            buffer.pos = value
        }
    var lim
        get() = buffer.lim
        set(value) {
            buffer.lim = value
        }

    infix fun put(src: VkIndirectCommandsLayoutNVX_Buffer) {
        buffer.put(src.buffer)
    }

    fun flip() {
        buffer.flip()
    }
}

fun VkIndirectCommandsLayoutNVX_Buffer(size: Int, block: (Int) -> VkIndirectCommandsLayoutNVX) = VkIndirectCommandsLayoutNVX_Buffer(LongBuffer(size) { block(it).L })
fun VkIndirectCommandsLayoutNVX_Buffer(size: Int) = VkIndirectCommandsLayoutNVX_Buffer(LongBuffer(size))
fun VkIndirectCommandsLayoutNVX_Buffer(elements: Collection<VkIndirectCommandsLayoutNVX>) = VkIndirectCommandsLayoutNVX_Buffer(LongBuffer(elements.size) { elements.elementAt(it).L })

fun vk.IndirectCommandsLayoutNVX_Buffer(size: Int, block: (Int) -> VkIndirectCommandsLayoutNVX) = VkIndirectCommandsLayoutNVX_Buffer(stackGet().LongBuffer(size) { block(it).L })
fun vk.IndirectCommandsLayoutNVX_Buffer(size: Int) = VkIndirectCommandsLayoutNVX_Buffer(stackGet().LongBuffer(size))
fun vk.IndirectCommandsLayoutNVX_Buffer(elements: Collection<VkIndirectCommandsLayoutNVX>) = VkIndirectCommandsLayoutNVX_Buffer(stackGet().LongBuffer(elements.size) { elements.elementAt(it).L })


inline class VkObjectTableNVX_Buffer(val buffer: LongBuffer) {
    operator fun get(index: Int) = VkObjectTableNVX(buffer[index])
    operator fun set(index: Int, value: VkObjectTableNVX) {
        buffer[index] = value.L
    }

    val rem get() = buffer.rem
    val adr get() = buffer.adr
    var pos
        get() = buffer.pos
        set(value) {
            buffer.pos = value
        }
    var lim
        get() = buffer.lim
        set(value) {
            buffer.lim = value
        }

    infix fun put(src: VkObjectTableNVX_Buffer) {
        buffer.put(src.buffer)
    }

    fun flip() {
        buffer.flip()
    }
}

fun VkObjectTableNVX_Buffer(size: Int, block: (Int) -> VkObjectTableNVX) = VkObjectTableNVX_Buffer(LongBuffer(size) { block(it).L })
fun VkObjectTableNVX_Buffer(size: Int) = VkObjectTableNVX_Buffer(LongBuffer(size))
fun VkObjectTableNVX_Buffer(elements: Collection<VkObjectTableNVX>) = VkObjectTableNVX_Buffer(LongBuffer(elements.size) { elements.elementAt(it).L })

fun vk.ObjectTableNVX_Buffer(size: Int, block: (Int) -> VkObjectTableNVX) = VkObjectTableNVX_Buffer(stackGet().LongBuffer(size) { block(it).L })
fun vk.ObjectTableNVX_Buffer(size: Int) = VkObjectTableNVX_Buffer(stackGet().LongBuffer(size))
fun vk.ObjectTableNVX_Buffer(elements: Collection<VkObjectTableNVX>) = VkObjectTableNVX_Buffer(stackGet().LongBuffer(elements.size) { elements.elementAt(it).L })


inline class VkPipeline_Buffer(val buffer: LongBuffer) {
    operator fun get(index: Int) = VkPipeline(buffer[index])
    operator fun set(index: Int, value: VkPipeline) {
        buffer[index] = value.L
    }

    val rem get() = buffer.rem
    val adr get() = buffer.adr
    var pos
        get() = buffer.pos
        set(value) {
            buffer.pos = value
        }
    var lim
        get() = buffer.lim
        set(value) {
            buffer.lim = value
        }

    infix fun put(src: VkPipeline_Buffer) {
        buffer.put(src.buffer)
    }

    fun flip() {
        buffer.flip()
    }
}

fun VkPipeline_Buffer(size: Int, block: (Int) -> VkPipeline) = VkPipeline_Buffer(LongBuffer(size) { block(it).L })
fun VkPipeline_Buffer(size: Int) = VkPipeline_Buffer(LongBuffer(size))
fun VkPipeline_Buffer(elements: Collection<VkPipeline>) = VkPipeline_Buffer(LongBuffer(elements.size) { elements.elementAt(it).L })

fun vk.Pipeline_Buffer(size: Int, block: (Int) -> VkPipeline) = VkPipeline_Buffer(stackGet().LongBuffer(size) { block(it).L })
fun vk.Pipeline_Buffer(size: Int) = VkPipeline_Buffer(stackGet().LongBuffer(size))
fun vk.Pipeline_Buffer(elements: Collection<VkPipeline>) = VkPipeline_Buffer(stackGet().LongBuffer(elements.size) { elements.elementAt(it).L })


inline class VkPipelineCache_Buffer(val buffer: LongBuffer) {
    operator fun get(index: Int) = VkPipelineCache(buffer[index])
    operator fun set(index: Int, value: VkPipelineCache) {
        buffer[index] = value.L
    }

    val rem get() = buffer.rem
    val adr get() = buffer.adr
    var pos
        get() = buffer.pos
        set(value) {
            buffer.pos = value
        }
    var lim
        get() = buffer.lim
        set(value) {
            buffer.lim = value
        }

    infix fun put(src: VkPipelineCache_Buffer) {
        buffer.put(src.buffer)
    }

    fun flip() {
        buffer.flip()
    }
}

fun VkPipelineCache_Buffer(size: Int, block: (Int) -> VkPipelineCache) = VkPipelineCache_Buffer(LongBuffer(size) { block(it).L })
fun VkPipelineCache_Buffer(size: Int) = VkPipelineCache_Buffer(LongBuffer(size))
fun VkPipelineCache_Buffer(elements: Collection<VkPipelineCache>) = VkPipelineCache_Buffer(LongBuffer(elements.size) { elements.elementAt(it).L })

fun vk.PipelineCache_Buffer(size: Int, block: (Int) -> VkPipelineCache) = VkPipelineCache_Buffer(stackGet().LongBuffer(size) { block(it).L })
fun vk.PipelineCache_Buffer(size: Int) = VkPipelineCache_Buffer(stackGet().LongBuffer(size))
fun vk.PipelineCache_Buffer(elements: Collection<VkPipelineCache>) = VkPipelineCache_Buffer(stackGet().LongBuffer(elements.size) { elements.elementAt(it).L })


inline class VkPipelineLayout_Buffer(val buffer: LongBuffer) {
    operator fun get(index: Int) = VkPipelineLayout(buffer[index])
    operator fun set(index: Int, value: VkPipelineLayout) {
        buffer[index] = value.L
    }

    val rem get() = buffer.rem
    val adr get() = buffer.adr
    var pos
        get() = buffer.pos
        set(value) {
            buffer.pos = value
        }
    var lim
        get() = buffer.lim
        set(value) {
            buffer.lim = value
        }

    infix fun put(src: VkPipelineLayout_Buffer) {
        buffer.put(src.buffer)
    }

    fun flip() {
        buffer.flip()
    }
}

fun VkPipelineLayout_Buffer(size: Int, block: (Int) -> VkPipelineLayout) = VkPipelineLayout_Buffer(LongBuffer(size) { block(it).L })
fun VkPipelineLayout_Buffer(size: Int) = VkPipelineLayout_Buffer(LongBuffer(size))
fun VkPipelineLayout_Buffer(elements: Collection<VkPipelineLayout>) = VkPipelineLayout_Buffer(LongBuffer(elements.size) { elements.elementAt(it).L })

fun vk.PipelineLayout_Buffer(size: Int, block: (Int) -> VkPipelineLayout) = VkPipelineLayout_Buffer(stackGet().LongBuffer(size) { block(it).L })
fun vk.PipelineLayout_Buffer(size: Int) = VkPipelineLayout_Buffer(stackGet().LongBuffer(size))
fun vk.PipelineLayout_Buffer(elements: Collection<VkPipelineLayout>) = VkPipelineLayout_Buffer(stackGet().LongBuffer(elements.size) { elements.elementAt(it).L })


inline class VkQueryPool_Buffer(val buffer: LongBuffer) {
    operator fun get(index: Int) = VkQueryPool(buffer[index])
    operator fun set(index: Int, value: VkQueryPool) {
        buffer[index] = value.L
    }

    val rem get() = buffer.rem
    val adr get() = buffer.adr
    var pos
        get() = buffer.pos
        set(value) {
            buffer.pos = value
        }
    var lim
        get() = buffer.lim
        set(value) {
            buffer.lim = value
        }

    infix fun put(src: VkQueryPool_Buffer) {
        buffer.put(src.buffer)
    }

    fun flip() {
        buffer.flip()
    }
}

fun VkQueryPool_Buffer(size: Int, block: (Int) -> VkQueryPool) = VkQueryPool_Buffer(LongBuffer(size) { block(it).L })
fun VkQueryPool_Buffer(size: Int) = VkQueryPool_Buffer(LongBuffer(size))
fun VkQueryPool_Buffer(elements: Collection<VkQueryPool>) = VkQueryPool_Buffer(LongBuffer(elements.size) { elements.elementAt(it).L })

fun vk.QueryPool_Buffer(size: Int, block: (Int) -> VkQueryPool) = VkQueryPool_Buffer(stackGet().LongBuffer(size) { block(it).L })
fun vk.QueryPool_Buffer(size: Int) = VkQueryPool_Buffer(stackGet().LongBuffer(size))
fun vk.QueryPool_Buffer(elements: Collection<VkQueryPool>) = VkQueryPool_Buffer(stackGet().LongBuffer(elements.size) { elements.elementAt(it).L })


inline class VkRenderPass_Buffer(val buffer: LongBuffer) {
    operator fun get(index: Int) = VkRenderPass(buffer[index])
    operator fun set(index: Int, value: VkRenderPass) {
        buffer[index] = value.L
    }

    val rem get() = buffer.rem
    val adr get() = buffer.adr
    var pos
        get() = buffer.pos
        set(value) {
            buffer.pos = value
        }
    var lim
        get() = buffer.lim
        set(value) {
            buffer.lim = value
        }

    infix fun put(src: VkRenderPass_Buffer) {
        buffer.put(src.buffer)
    }

    fun flip() {
        buffer.flip()
    }
}

fun VkRenderPass_Buffer(size: Int, block: (Int) -> VkRenderPass) = VkRenderPass_Buffer(LongBuffer(size) { block(it).L })
fun VkRenderPass_Buffer(size: Int) = VkRenderPass_Buffer(LongBuffer(size))
fun VkRenderPass_Buffer(elements: Collection<VkRenderPass>) = VkRenderPass_Buffer(LongBuffer(elements.size) { elements.elementAt(it).L })

fun vk.RenderPass_Buffer(size: Int, block: (Int) -> VkRenderPass) = VkRenderPass_Buffer(stackGet().LongBuffer(size) { block(it).L })
fun vk.RenderPass_Buffer(size: Int) = VkRenderPass_Buffer(stackGet().LongBuffer(size))
fun vk.RenderPass_Buffer(elements: Collection<VkRenderPass>) = VkRenderPass_Buffer(stackGet().LongBuffer(elements.size) { elements.elementAt(it).L })


inline class VkSampler_Buffer(val buffer: LongBuffer) {
    operator fun get(index: Int) = VkSampler(buffer[index])
    operator fun set(index: Int, value: VkSampler) {
        buffer[index] = value.L
    }

    val rem get() = buffer.rem
    val adr get() = buffer.adr
    var pos
        get() = buffer.pos
        set(value) {
            buffer.pos = value
        }
    var lim
        get() = buffer.lim
        set(value) {
            buffer.lim = value
        }

    infix fun put(src: VkSampler_Buffer) {
        buffer.put(src.buffer)
    }

    fun flip() {
        buffer.flip()
    }
}

fun VkSampler_Buffer(size: Int, block: (Int) -> VkSampler) = VkSampler_Buffer(LongBuffer(size) { block(it).L })
fun VkSampler_Buffer(size: Int) = VkSampler_Buffer(LongBuffer(size))
fun VkSampler_Buffer(elements: Collection<VkSampler>) = VkSampler_Buffer(LongBuffer(elements.size) { elements.elementAt(it).L })

fun vk.Sampler_Buffer(size: Int, block: (Int) -> VkSampler) = VkSampler_Buffer(stackGet().LongBuffer(size) { block(it).L })
fun vk.Sampler_Buffer(size: Int) = VkSampler_Buffer(stackGet().LongBuffer(size))
fun vk.Sampler_Buffer(elements: Collection<VkSampler>) = VkSampler_Buffer(stackGet().LongBuffer(elements.size) { elements.elementAt(it).L })


inline class VkSamplerYcbcrConversion_Buffer(val buffer: LongBuffer) {
    operator fun get(index: Int) = VkSamplerYcbcrConversion(buffer[index])
    operator fun set(index: Int, value: VkSamplerYcbcrConversion) {
        buffer[index] = value.L
    }

    val rem get() = buffer.rem
    val adr get() = buffer.adr
    var pos
        get() = buffer.pos
        set(value) {
            buffer.pos = value
        }
    var lim
        get() = buffer.lim
        set(value) {
            buffer.lim = value
        }

    infix fun put(src: VkSamplerYcbcrConversion_Buffer) {
        buffer.put(src.buffer)
    }

    fun flip() {
        buffer.flip()
    }
}

fun VkSamplerYcbcrConversion_Buffer(size: Int, block: (Int) -> VkSamplerYcbcrConversion) = VkSamplerYcbcrConversion_Buffer(LongBuffer(size) { block(it).L })
fun VkSamplerYcbcrConversion_Buffer(size: Int) = VkSamplerYcbcrConversion_Buffer(LongBuffer(size))
fun VkSamplerYcbcrConversion_Buffer(elements: Collection<VkSamplerYcbcrConversion>) = VkSamplerYcbcrConversion_Buffer(LongBuffer(elements.size) { elements.elementAt(it).L })

fun vk.SamplerYcbcrConversion_Buffer(size: Int, block: (Int) -> VkSamplerYcbcrConversion) = VkSamplerYcbcrConversion_Buffer(stackGet().LongBuffer(size) { block(it).L })
fun vk.SamplerYcbcrConversion_Buffer(size: Int) = VkSamplerYcbcrConversion_Buffer(stackGet().LongBuffer(size))
fun vk.SamplerYcbcrConversion_Buffer(elements: Collection<VkSamplerYcbcrConversion>) = VkSamplerYcbcrConversion_Buffer(stackGet().LongBuffer(elements.size) { elements.elementAt(it).L })


inline class VkSemaphore_Buffer(val buffer: LongBuffer) {
    operator fun get(index: Int) = VkSemaphore(buffer[index])
    operator fun set(index: Int, value: VkSemaphore) {
        buffer[index] = value.L
    }

    val rem get() = buffer.rem
    val adr get() = buffer.adr
    var pos
        get() = buffer.pos
        set(value) {
            buffer.pos = value
        }
    var lim
        get() = buffer.lim
        set(value) {
            buffer.lim = value
        }

    infix fun put(src: VkSemaphore_Buffer) {
        buffer.put(src.buffer)
    }

    fun flip() {
        buffer.flip()
    }
}

fun VkSemaphore_Buffer(size: Int, block: (Int) -> VkSemaphore) = VkSemaphore_Buffer(LongBuffer(size) { block(it).L })
fun VkSemaphore_Buffer(size: Int) = VkSemaphore_Buffer(LongBuffer(size))
fun VkSemaphore_Buffer(elements: Collection<VkSemaphore>) = VkSemaphore_Buffer(LongBuffer(elements.size) { elements.elementAt(it).L })

fun vk.Semaphore_Buffer(size: Int, block: (Int) -> VkSemaphore) = VkSemaphore_Buffer(stackGet().LongBuffer(size) { block(it).L })
fun vk.Semaphore_Buffer(size: Int) = VkSemaphore_Buffer(stackGet().LongBuffer(size))
fun vk.Semaphore_Buffer(elements: Collection<VkSemaphore>) = VkSemaphore_Buffer(stackGet().LongBuffer(elements.size) { elements.elementAt(it).L })


inline class VkShaderModule_Buffer(val buffer: LongBuffer) {
    operator fun get(index: Int) = VkShaderModule(buffer[index])
    operator fun set(index: Int, value: VkShaderModule) {
        buffer[index] = value.L
    }

    val rem get() = buffer.rem
    val adr get() = buffer.adr
    var pos
        get() = buffer.pos
        set(value) {
            buffer.pos = value
        }
    var lim
        get() = buffer.lim
        set(value) {
            buffer.lim = value
        }

    infix fun put(src: VkShaderModule_Buffer) {
        buffer.put(src.buffer)
    }

    fun flip() {
        buffer.flip()
    }
}

fun VkShaderModule_Buffer(size: Int, block: (Int) -> VkShaderModule) = VkShaderModule_Buffer(LongBuffer(size) { block(it).L })
fun VkShaderModule_Buffer(size: Int) = VkShaderModule_Buffer(LongBuffer(size))
fun VkShaderModule_Buffer(elements: Collection<VkShaderModule>) = VkShaderModule_Buffer(LongBuffer(elements.size) { elements.elementAt(it).L })

fun vk.ShaderModule_Buffer(size: Int, block: (Int) -> VkShaderModule) = VkShaderModule_Buffer(stackGet().LongBuffer(size) { block(it).L })
fun vk.ShaderModule_Buffer(size: Int) = VkShaderModule_Buffer(stackGet().LongBuffer(size))
fun vk.ShaderModule_Buffer(elements: Collection<VkShaderModule>) = VkShaderModule_Buffer(stackGet().LongBuffer(elements.size) { elements.elementAt(it).L })


//fun vkSemaphoreBufferOf(semaphore: VkSemaphore) = VkSemaphoreBuffer(longBufferOf(semaphore.L))
//fun MemoryStack.vkSemaphoreBufferOf(semaphore: VkSemaphore) = VkSemaphoreBuffer(longs(semaphore.L))


inline class VkSurfaceKHR_Buffer(val buffer: LongBuffer) {
    operator fun get(index: Int) = VkSurfaceKHR(buffer[index])
    operator fun set(index: Int, value: VkSurfaceKHR) {
        buffer[index] = value.L
    }

    val rem get() = buffer.rem
    val adr get() = buffer.adr
    var pos
        get() = buffer.pos
        set(value) {
            buffer.pos = value
        }
    var lim
        get() = buffer.lim
        set(value) {
            buffer.lim = value
        }

    infix fun put(src: VkSurfaceKHR_Buffer) {
        buffer.put(src.buffer)
    }

    fun flip() {
        buffer.flip()
    }
}

fun VkSurfaceKHR_Buffer(size: Int, block: (Int) -> VkSurfaceKHR) = VkSurfaceKHR_Buffer(LongBuffer(size) { block(it).L })
fun VkSurfaceKHR_Buffer(size: Int) = VkSurfaceKHR_Buffer(LongBuffer(size))
fun VkSurfaceKHR_Buffer(elements: Collection<VkSurfaceKHR>) = VkSurfaceKHR_Buffer(LongBuffer(elements.size) { elements.elementAt(it).L })

fun vk.SurfaceKHR_Buffer(size: Int, block: (Int) -> VkSurfaceKHR) = VkSurfaceKHR_Buffer(stackGet().LongBuffer(size) { block(it).L })
fun vk.SurfaceKHR_Buffer(size: Int) = VkSurfaceKHR_Buffer(stackGet().LongBuffer(size))
fun vk.SurfaceKHR_Buffer(elements: Collection<VkSurfaceKHR>) = VkSurfaceKHR_Buffer(stackGet().LongBuffer(elements.size) { elements.elementAt(it).L })


inline class VkSwapchainKHR_Buffer(val buffer: LongBuffer) {
    operator fun get(index: Int) = VkSwapchainKHR(buffer[index])
    operator fun set(index: Int, value: VkSwapchainKHR) {
        buffer[index] = value.L
    }

    val rem get() = buffer.rem
    val adr get() = buffer.adr
    var pos
        get() = buffer.pos
        set(value) {
            buffer.pos = value
        }
    var lim
        get() = buffer.lim
        set(value) {
            buffer.lim = value
        }

    infix fun put(src: VkSwapchainKHR_Buffer) {
        buffer.put(src.buffer)
    }

    fun flip() {
        buffer.flip()
    }
}

fun VkSwapchainKHR_Buffer(size: Int, block: (Int) -> VkSwapchainKHR) = VkSwapchainKHR_Buffer(LongBuffer(size) { block(it).L })
fun VkSwapchainKHR_Buffer(size: Int) = VkSwapchainKHR_Buffer(LongBuffer(size))
fun VkSwapchainKHR_Buffer(elements: Collection<VkSwapchainKHR>) = VkSwapchainKHR_Buffer(LongBuffer(elements.size) { elements.elementAt(it).L })

fun vk.SwapchainKHR_Buffer(size: Int, block: (Int) -> VkSwapchainKHR) = VkSwapchainKHR_Buffer(stackGet().LongBuffer(size) { block(it).L })
fun vk.SwapchainKHR_Buffer(size: Int) = VkSwapchainKHR_Buffer(stackGet().LongBuffer(size))
fun vk.SwapchainKHR_Buffer(elements: Collection<VkSwapchainKHR>) = VkSwapchainKHR_Buffer(stackGet().LongBuffer(elements.size) { elements.elementAt(it).L })


inline class VkValidationCacheEXT_Buffer(val buffer: LongBuffer) {
    operator fun get(index: Int) = VkValidationCacheEXT(buffer[index])
    operator fun set(index: Int, value: VkValidationCacheEXT) {
        buffer[index] = value.L
    }

    val rem get() = buffer.rem
    val adr get() = buffer.adr
    var pos
        get() = buffer.pos
        set(value) {
            buffer.pos = value
        }
    var lim
        get() = buffer.lim
        set(value) {
            buffer.lim = value
        }

    infix fun put(src: VkValidationCacheEXT_Buffer) {
        buffer.put(src.buffer)
    }

    fun flip() {
        buffer.flip()
    }
}

fun VkValidationCacheEXT_Buffer(size: Int, block: (Int) -> VkValidationCacheEXT) = VkValidationCacheEXT_Buffer(LongBuffer(size) { block(it).L })
fun VkValidationCacheEXT_Buffer(size: Int) = VkValidationCacheEXT_Buffer(LongBuffer(size))
fun VkValidationCacheEXT_Buffer(elements: Collection<VkValidationCacheEXT>) = VkValidationCacheEXT_Buffer(LongBuffer(elements.size) { elements.elementAt(it).L })

fun vk.ValidationCacheEXT_Buffer(size: Int, block: (Int) -> VkValidationCacheEXT) = VkValidationCacheEXT_Buffer(stackGet().LongBuffer(size) { block(it).L })
fun vk.ValidationCacheEXT_Buffer(size: Int) = VkValidationCacheEXT_Buffer(stackGet().LongBuffer(size))
fun vk.ValidationCacheEXT_Buffer(elements: Collection<VkValidationCacheEXT>) = VkValidationCacheEXT_Buffer(stackGet().LongBuffer(elements.size) { elements.elementAt(it).L })