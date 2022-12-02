package vkk

import vkk.gen.*
import java.io.File

val nonDispHandles = HashSet<String>()
val dispHandles = HashSet<String>()

fun handles(target: File, vkDocs: File) {

    generate(target, vkDocs, "vkk/api/handles.kt") {

        `package` = "vkk.api"
        imports += listOf("kool.set", "vkk.MemStack", "kool.Ptr")
        experimentals += Generator.Experimentals.UnsignedTypes
        suppressInlineWarning = true

        for (handle in vkDocs.resolve("gen/api/handles").listAdoc()) {

            val name = handle.nameWithoutExtension

            if (handle.readText().lines()[5] == "VK_DEFINE_NON_DISPATCHABLE_HANDLE($name)") {

                nonDispHandles += name

                man(name)
                +jvmInline
                +"""
                    value class $name(val ulong: ULong) {
                        val isValid: Boolean
                            get() = ulong != 0uL
                        val isNotValid: Boolean
                            get() = ulong == 0uL
                        companion object {
                            val NULL: $name = $name(0uL)
                        }
                    }"""

                +"""
                    $jvmInline
                    value class ${name}_Array(val array: ULongArray) {
                    
                        constructor() : this(ULongArray(0))

                        operator fun get(index: Int) = $name(array[index])
                        operator fun set(index: Int, element: $name) = array.set(index, element.ulong)
                        
                        inline fun isEmpty(): Boolean = array.isEmpty()
                        inline fun isNotEmpty(): Boolean = array.isNotEmpty()

                        val size: Int 
                            get() = array.size
                        val indices: IntRange
                            get() = array.indices
                            
                        infix fun into(stack: MemStack): Ptr<UByte> = stack.calloc(8u, size.toUInt() * 8u).also { into(it, stack) }
                        fun into(ptr: Ptr<UByte>, stack: MemStack) {
                            val p = ptr.toPtr<ULong>()
                            for (i in indices)
                                p[i] = array[i]
                        }

                        inline fun forEach(action: ($name) -> Unit) {
                            for (element in array) 
                                action($name(element))
                        }

                        //infix fun write(stack: MemoryStack): Adr = stack.LongPtr(size) { get(it).L }.adr
                    }

                    //fun VkAccelerationStructureNV_Array(size: Int, block: (Int) -> VkAccelerationStructureNV) = VkAccelerationStructureNV_Array(LongArray(size) { block(it).L })
                    //fun VkAccelerationStructureNV_Array(size: Int) = VkAccelerationStructureNV_Array(LongArray(size))
                    //fun VkAccelerationStructureNV_Array(elements: Collection<VkAccelerationStructureNV>) = VkAccelerationStructureNV_Array(LongArray(elements.size) { elements.elementAt(it).L })
                    //fun VkAccelerationStructureNV_Array() = VkAccelerationStructureNV_Array(LongArray(0))
                    """
            } else {
                dispHandles += name
            }
        }
    }
}
