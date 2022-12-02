@file:OptIn(ExperimentalUnsignedTypes::class)

package vkk

// unions
val specialStructs = mapOf(
    "VkAccelerationStructureGeometryDataKHR" to """
        interface VkAccelerationStructureGeometryDataKHR {
            infix fun into(stack: MemStack): Ptr<UByte> = stack.calloc(ALIGN, BYTES).also { into(it, stack) }
            fun into(ptr: Ptr<UByte>, stack: MemStack)
            companion object {
                val BYTES = 64u
                val ALIGN = 8u
            }
        }""",
    "VkAccelerationStructureMotionInstanceDataNV" to """
        interface VkAccelerationStructureMotionInstanceDataNV {
            infix fun into(stack: MemStack): Ptr<UByte> = stack.calloc(ALIGN, BYTES).also { into(it, stack) }
            fun into(ptr: Ptr<UByte>, stack: MemStack)
            companion object {
                val BYTES = 144u
                val ALIGN = 8u
            }
        }""",
    "VkClearColorValue" to """
        interface VkClearColorValue<T> {
            abstract val x: T
            abstract val y: T
            abstract val z: T
            abstract val w: T
            infix fun into(stack: MemStack): Ptr<UByte> = stack.calloc(ALIGN, BYTES).also { into(it, stack) }
            fun into(ptr: Ptr<UByte>, stack: MemStack)
            companion object {
                val BYTES = 16u
                val ALIGN = 4u
            }
        }
        class VkClearColorFloatValue(override val x: Float, override val y: Float, override val z: Float, override val w: Float) : VkClearColorValue<Float> {
            override infix fun into(stack: MemStack): Ptr<UByte> = stack.calloc(ALIGN, BYTES).also { into(it, stack) }
            override fun into(ptr: Ptr<UByte>, stack: MemStack) { 
                ptr `=` x
                (ptr + 4) `=` y
                (ptr + 8) `=` z
                (ptr + 12) `=` w
            }
            companion object {
                val BYTES = VkClearColorValue.BYTES
                val ALIGN = VkClearColorValue.ALIGN
            }
        }
        class VkClearColorIntValue(override val x: Int, override val y: Int, override val z: Int, override val w: Int) : VkClearColorValue<Int> {
            override infix fun into(stack: MemStack): Ptr<UByte> = stack.calloc(ALIGN, BYTES).also { into(it, stack) }
            override fun into(ptr: Ptr<UByte>, stack: MemStack) { 
                ptr `=` x
                (ptr + 4) `=` y
                (ptr + 8) `=` z
                (ptr + 12) `=` w
            }
            companion object {
                val BYTES = VkClearColorValue.BYTES
                val ALIGN = VkClearColorValue.ALIGN
            }
        }
        class VkClearColorUIntValue(override val x: UInt, override val y: UInt, override val z: UInt, override val w: UInt) : VkClearColorValue<UInt> {
            override infix fun into(stack: MemStack): Ptr<UByte> = stack.calloc(ALIGN, BYTES).also { into(it, stack) }
            override fun into(ptr: Ptr<UByte>, stack: MemStack) { 
                ptr `=` x
                (ptr + 4) `=` y
                (ptr + 8) `=` z
                (ptr + 12) `=` w
            }
            companion object {
                val BYTES = VkClearColorValue.BYTES
                val ALIGN = VkClearColorValue.ALIGN
            }
        }""",
    "VkClearDepthStencilValue" to """
        class VkClearDepthStencilValue : VkClearValue {
            var stencil = 0u
            var depth: Float
                get() = Float.fromBits(stencil.toInt())
                set(value) { stencil = value.toRawBits().toUInt() }
            override infix fun into(stack: MemStack): Ptr<UByte> = stack.calloc(ALIGN, BYTES).also { into(it, stack) }
            override fun into(ptr: Ptr<UByte>, stack: MemStack) { ptr `=` stencil }
            companion object {
                val BYTES = 4u
                val ALIGN = 4u
            }
        }""",
    "VkClearValue" to """
        interface VkClearValue {
            infix fun into(stack: MemStack): Ptr<UByte> = stack.calloc(ALIGN, BYTES).also { into(it, stack) }
            fun into(ptr: Ptr<UByte>, stack: MemStack)
            companion object {
                val BYTES = 16u
                val ALIGN = 4u
            }
        }""",
    "VkDeviceOrHostAddressConstKHR" to """
        interface VkDeviceOrHostAddressConstKHR {
            infix fun into(stack: MemStack): Ptr<UByte> = stack.calloc(ALIGN, BYTES).also { into(it, stack) }
            fun into(ptr: Ptr<UByte>, stack: MemStack)
            companion object {
                val BYTES = 8u
                val ALIGN = 8u
            }
        }""",
    "VkDeviceOrHostAddressKHR" to "typealias VkDeviceOrHostAddressKHR = VkDeviceOrHostAddressConstKHR",
    "VkDescriptorSetLayoutBinding" to """
        class VkDescriptorSetLayoutBinding(var binding: UInt,
                                           var descriptorType: VkDescriptorType,
                                           var descriptorCount: UInt = 0u,
                                           var stageFlags: VkShaderStageFlags,
                                           var immutableSamplers: VkSampler_Array = VkSampler_Array()) {
            infix fun into(stack: MemStack): Ptr<UByte> = stack.calloc(ALIGN, BYTES).also { into(it, stack) }
            fun into(ptr: Ptr<UByte>, stack: MemStack) {
                ptr `=` binding
                (ptr + 4) `=` descriptorType.i
                if (immutableSamplers.isNotEmpty()) {
                    (ptr + 8) `=` immutableSamplers.size
                    immutableSamplers.into(ptr + 16, stack)
                }
                else if (descriptorCount != 0u)
                    (ptr + 8) `=` descriptorCount
                (ptr + 12) `=` stageFlags.uint
            }
            companion object {
                val BYTES: UInt = 24u
                val ALIGN: UInt = 8u
            }
        }
        infix fun List<VkDescriptorSetLayoutBinding>.into(stack: MemStack): Ptr<UByte> {
            val ptr = stack.calloc(VkDescriptorSetLayoutBinding.ALIGN, size, VkDescriptorSetLayoutBinding.BYTES)
            for (i in indices)
                this[i].into(ptr + VkDescriptorSetLayoutBinding.BYTES.toInt() * i, stack)
            return ptr
        }""",
    "VkWriteDescriptorSet" to """
        class VkWriteDescriptorSet(var dstSet: VkDescriptorSet,
                                   var dstBinding: UInt,
                                   var dstArrayElement: UInt,
                                   var descriptorCount: UInt,
                                   var descriptorType: VkDescriptorType,
                                   var imageInfo: List<VkDescriptorImageInfo>? = null,
                                   var bufferInfo: List<VkDescriptorBufferInfo>? = null,
                                   var texelBufferView: VkBufferView_Array? = null) {
            constructor(dstSet: VkDescriptorSet,
                        dstBinding: UInt,
                        dstArrayElement: UInt,
                        descriptorType: VkDescriptorType,
                        imageInfo: List<VkDescriptorImageInfo>) : this(dstSet, dstBinding, dstArrayElement, imageInfo.size.toUInt(), descriptorType, imageInfo)
            constructor(dstSet: VkDescriptorSet,
                        dstBinding: UInt,
                        dstArrayElement: UInt,
                        descriptorType: VkDescriptorType,
                        bufferInfo: List<VkDescriptorBufferInfo>) : this(dstSet, dstBinding, dstArrayElement, bufferInfo.size.toUInt(), descriptorType, null, bufferInfo)
            constructor(dstSet: VkDescriptorSet,
                        dstBinding: UInt,
                        dstArrayElement: UInt,
                        descriptorType: VkDescriptorType,
                        texelBufferView: VkBufferView_Array) : this(dstSet, dstBinding, dstArrayElement, texelBufferView.size.toUInt(), descriptorType, null, null, texelBufferView)  
            infix fun into(stack: MemStack): Ptr<UByte> = stack.calloc(ALIGN, BYTES).also { into(it, stack) }
            fun into(ptr: Ptr<UByte>, stack: MemStack) {
                ptr `=` sType.i
                (ptr + 16) `=` dstSet.ulong
                (ptr + 24) `=` dstBinding
                (ptr + 28) `=` dstArrayElement
                (ptr + 32) `=` descriptorCount
                (ptr + 36) `=` descriptorType.i
                imageInfo?.let { (ptr + 40) `=` it.into(stack) } ?: bufferInfo?.let { (ptr + 48) `=` it.into(stack)} ?: texelBufferView?.let { (ptr + 56) `=` it.array.into(stack) }
            }
            companion object {
                val sType: VkStructureType = VkStructureType.WRITE_DESCRIPTOR_SET
                val BYTES: UInt = 64u
                val ALIGN: UInt = 8u
            }
        }""")

// TODO
//class VkHostAddress : VkDeviceOrHostAddressConstKHR
class VkPerformanceCounterResultKHR {
    var uint64 = 0uL
    var int32: Int
        get() = uint64.toUInt().toInt()
        set(value) {
            uint64 = value.toULong()
        }
    var int64: Long
        get() = uint64.toLong()
        set(value) {
            uint64 = value.toULong()
        }
    var uint32: UInt
        get() = uint64.toUInt()
        set(value) {
            uint64 = value.toULong()
        }
    var float32: Float
        get() = uint64.toFloat()
        set(value) {
            uint64 = value.toULong()
        }
    var float64: Double
        get() = uint64.toDouble()
        set(value) {
            uint64 = value.toULong()
        }

    companion object {
        val BYTES = 8u
        val ALIGN = 8u
    }
}

val VkPerformanceValueDataINTEL =
    """
        class VkPerformanceValueDataINTEL {
            var value64 = 0uL
            var value32: UInt
                get() = value64.toUInt()
                set(value) { value64 = value.toULong() }
            var float: Float
                get() = value64.toFloat()
                set(value) { value64 = value.toULong() }
            var valueBool: Boolean
                get() = (value64 and 0x1uL) == 0x1uL
                set(value) { value64 = if (value) 0x1uL else 0uL }
            var valueString: Ptr<UByte>
                get() = Ptr(value64)
                set(value) { value64 = value.adr }
            companion object {
                val BYTES = 8u
                val ALIGN = 8u
            }
        }"""

class VkPipelineExecutableStatisticValueKHR {
    var u64 = 0uL
    var i64: Long
        get() = u64.toLong()
        set(value) {
            u64 = value.toULong()
        }
    var f64: Double
        get() = u64.toDouble()
        set(value) {
            u64 = value.toULong()
        }
    var b32: Boolean
        get() = (u64 and 0x1uL) == 0x1uL
        set(value) {
            u64 = if (value) 0x1uL else 0uL
        }

    companion object {
        val BYTES = 8u
        val ALIGN = 8u
    }
}