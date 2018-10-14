package vkk

import gli_.extension
import glm_.BYTES
import glm_.i
import glm_.mat3x3.Mat3
import glm_.mat4x4.Mat4
import glm_.set
import glm_.vec2.Vec2
import glm_.vec2.Vec2i
import glm_.vec3.Vec3
import glm_.vec4.Vec4
import graphics.scenery.spirvcrossj.*
import kool.*
import org.lwjgl.PointerBuffer
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryStack.stackGet
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.system.Pointer
import org.lwjgl.system.Struct
import org.lwjgl.system.StructBuffer
import org.lwjgl.vulkan.*
import java.nio.Buffer
import java.nio.ByteBuffer
import java.nio.IntBuffer
import java.nio.LongBuffer
import java.nio.file.Files
import java.nio.file.Path
import kotlin.reflect.KProperty1
import kotlin.reflect.KType
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.defaultType
import kotlin.reflect.full.findAnnotation


//fun pointerBufferOf(vararg strings: String): PointerBuffer {
//    val buf = pointerBufferBig(strings.size)
//    for (i in strings.indices)
//        buf[i] = strings[i]
//    return buf
//}
//
//operator fun PointerBuffer.set(index: Int, string: String) {
//    put(index, string.memUTF16)
//}
operator fun PointerBuffer.set(index: Int, long: Long) {
    put(index, long)
}

operator fun PointerBuffer.set(index: Int, pointer: Pointer) {
    put(index, pointer)
}

operator fun PointerBuffer.set(index: Int, buffer: Buffer) {
    put(index, buffer.adr)
}

//operator fun PointerBuffer.plusAssign(string: String) {
//    put(string.stackUTF16)
//}

//operator fun <T> PointerBuffer.plusAssign(elements: Iterable<T>) {
//    for (item in elements)
//        if (item is String)
//            put(item.memUTF16)
//        else
//            throw Error()
//}
//
//fun PointerBuffer.isNotEmpty() = position() > 0


object LongArrayList {
    operator fun ArrayList<Long>.set(index: Int, long: LongBuffer) {
        set(index, long[0])
    }

    infix fun ArrayList<Long>.resize(newSize: Int) {
        if (size < newSize)
            for (i in size until newSize)
                add(NULL)
        else if (size > newSize)
            for (i in size downTo newSize + 1)
                removeAt(lastIndex)
    }
}

object VkPhysicalDeviceArrayList {
//    operator fun ArrayList<VkPhysicalDevice>.set(index: Int, long: LongBuffer) {
//        set(index, long[0])
//    }

    infix fun ArrayList<VkPhysicalDevice>.resize(newSize: Int) {
        if (size < newSize) TODO()
//            for (i in size until newSize)
//                add(VkPhysicalDevice())
        else if (size > newSize)
            for (i in size downTo newSize + 1)
                removeAt(lastIndex)
    }
}


fun vkDestroySemaphores(device: VkDevice, semaphores: VkSemaphoreBuffer) {
    for (i in 0 until semaphores.remaining())
        VK10.nvkDestroySemaphore(device, semaphores[i], NULL)
}


fun vkDestroyBuffer(device: VkDevice, buffer: VkBuffer) = VK10.nvkDestroyBuffer(device, buffer.L, NULL)


inline val Pointer.adr get() = address()


fun PointerBuffer?.toArrayList(): ArrayList<String> {
    val count = this?.remaining() ?: 0
    if (this == null || count == 0) return arrayListOf()
    val res = ArrayList<String>(count)
    for (i in 0 until count)
        res += get(i).utf8
    return res
}

fun Collection<String>.toPointerBufferStack(): PointerBuffer = toPointerBuffer(stackGet())

fun Collection<String>.toPointerBuffer(stack: MemoryStack): PointerBuffer {
    val pointers = stack.mallocPointer(size)
    for (i in indices)
        pointers[i] = elementAt(i).toUTF8(stack)
    return pointers
}


infix fun Vec2i.put(extent: VkExtent2D) {
    x = extent.width
    y = extent.height
}


fun glslToSpirv(path: Path): ByteBuffer {

    var compileFail = false
    var linkFail = false
    val program = TProgram()

    val code = Files.readAllLines(path).joinToString("\n")

    val extension = path.extension
    val shaderType = when (extension) {
        "vert" -> EShLanguage.EShLangVertex
        "frag" -> EShLanguage.EShLangFragment
        "geom" -> EShLanguage.EShLangGeometry
        "tesc" -> EShLanguage.EShLangTessControl
        "tese" -> EShLanguage.EShLangTessEvaluation
        "comp" -> EShLanguage.EShLangCompute
        else -> throw RuntimeException("Unknown shader extension .$extension")
    }

    println("${path.fileName}: Compiling shader code  (${code.length} bytes)... ")

    val shader = TShader(shaderType).apply {
        setStrings(arrayOf(code), 1)
        setAutoMapBindings(true)
    }

    val messages = EShMessages.EShMsgDefault or EShMessages.EShMsgVulkanRules or EShMessages.EShMsgSpvRules

    val resources = libspirvcrossj.getDefaultTBuiltInResource()
    if (!shader.parse(resources, 450, false, messages))
        compileFail = true

    if (compileFail) {
        println("Info log: " + shader.infoLog)
        println("Debug log: " + shader.infoDebugLog)
        throw RuntimeException("Compilation of ${path.fileName} failed")
    }

    program.addShader(shader)

    if (!program.link(EShMessages.EShMsgDefault) || !program.mapIO())
        linkFail = true

    if (linkFail) {
        System.err.println(program.infoLog)
        System.err.println(program.infoDebugLog)

        throw RuntimeException("Linking of program ${path.fileName} failed!")
    }


    val spirv = IntVec()
    libspirvcrossj.glslangToSpv(program.getIntermediate(shaderType), spirv)

    println("Generated " + spirv.capacity() + " bytes of SPIRV bytecode.")

    //System.out.println(shader);
    //System.out.println(program);

    return spirv.toByteBuffer()
}

private fun IntVec.toByteBuffer(): ByteBuffer {
    val bytes = MemoryStack.stackGet().malloc(size().i * Int.BYTES)
    val ints = bytes.asIntBuffer()
    for (i in 0 until ints.cap)
        ints[i] = get(i).i
    return bytes
}


operator fun <T : Struct, SELF : StructBuffer<T, SELF>> StructBuffer<T, SELF>.set(index: Int, value: T) {
    put(index, value)
}

inline fun <R> withAddress(address: Long, block: WithAddress.() -> R): R {
    WithAddress.address = address
    WithAddress.offset = 0
    return WithAddress.block()
}

object WithAddress {

    var address = NULL
    var offset = 0

    fun addMat4(mat4: Mat4) {
        for (i in 0..3)
            for (j in 0..3) {
                memPutFloat(address + offset, mat4[i, j])
                offset += Float.BYTES
            }
    }

    fun addMat3(mat3: Mat3) {
        for (i in 0..2)
            for (j in 0..2) {
                memPutFloat(address + offset, mat3[i, j])
                offset += Float.BYTES
            }
    }

    fun addVec4(vec4: Vec4) {
        for (i in 0..3) {
            memPutFloat(address + offset, vec4[i])
            offset += Float.BYTES
        }
    }

    fun addVec3(vec3: Vec3) {
        for (i in 0..2) {
            memPutFloat(address + offset, vec3[i])
            offset += Float.BYTES
        }
    }

    fun addVec2(vec2: Vec2) {
        for (i in 0..1) {
            memPutFloat(address + offset, vec2[i])
            offset += Float.BYTES
        }
    }

    fun addFloat(float: Float) {
        memPutFloat(address + offset, float)
        offset += Float.BYTES
    }

    fun addInt(int: Int) {
        memPutInt(address + offset, int)
        offset += Int.BYTES
    }
}


abstract class Bufferizable {

    @Retention(AnnotationRetention.RUNTIME)
    annotation class Order(val value: Int)

    val fieldOrderDefault: Array<String> by lazy {
        val properties = this::class.declaredMemberProperties
        val parts = properties.partition { it.findAnnotation<Order>() == null }
        val plain = parts.first.sortedBy { it.name }
        val annotated = parts.second.associateBy { it.findAnnotation<Order>()!!.value }
        val list = ArrayList<KProperty1<*, *>>()
        var plainIdx = 0
        for (i in properties.indices)
            list += annotated[i] ?: plain[plainIdx++]
        list.map { it.name }.toTypedArray()
    }

    open var fieldOrder = emptyArray<String>()
        get() = if (field.isEmpty()) fieldOrderDefault else field

    open val size: Int by lazy {
        fieldOrder.sumBy { field -> this::class.declaredMemberProperties.find { it.name == field }!!.returnType.size }
    }

    open infix fun to(address: Ptr) {

        WithAddress.address = address
        WithAddress.offset = 0

        for (i in data.indices)
            data[i].first(data[i].second.getter.call(this)!!)
    }

    infix fun from(address: Adr): Unit = TODO()

    val data: Array<BufferizableData> by lazy {
        Array(fieldOrder.size) {
            val field = fieldOrder[it]
            val member = this::class.declaredMemberProperties.find { it.name == field }!!
            val func = member.returnType.func
            func to member
        }
    }

    val offsets by lazy {
        var offset = 0
        MutableList(fieldOrder.size) { i ->
            fieldOrder[i] to offset.also {
                offset += data[i].second.returnType.size
            }
        }.toMap()
    }

    fun offsetOf(field: String) = offsets[field]!!

    private val KType.size: Int
        get() = when (this) {
            Mat4::class.defaultType -> Mat4.size
            Mat3::class.defaultType -> Mat3.size
            Vec4::class.defaultType -> Vec4.size
            Vec3::class.defaultType -> Vec3.size
            Vec2::class.defaultType -> Vec2.size
            Float::class.defaultType -> Float.BYTES
            Int::class.defaultType -> Int.BYTES
            else -> throw Error(toString())
        }
    private val KType.func: BufferizableAddFunctionType
        get() = when (this) {
            Mat4::class.defaultType -> WithAddress::addMat4
            Mat3::class.defaultType -> WithAddress::addMat3
            Vec4::class.defaultType -> WithAddress::addVec4
            Vec3::class.defaultType -> WithAddress::addVec3
            Vec2::class.defaultType -> WithAddress::addVec2
            Float::class.defaultType -> WithAddress::addFloat
            Int::class.defaultType -> WithAddress::addInt
            else -> throw Error(toString())
        } as BufferizableAddFunctionType
}

typealias BufferizableAddFunctionType = (Any) -> Unit
typealias BufferizableData = Pair<BufferizableAddFunctionType, KProperty1<out Bufferizable, Any?>>

fun bufferOf(vararg data: Bufferizable): ByteBuffer {
    val size = data.sumBy { it.size }
    val res = bufferBig(size)
    val address = memAddress(res)
    var offset = 0
    for (i in data.indices) {
        data[i] to address + offset
        offset += data[i].size
    }
    return res
}

fun bufferOf(data: Collection<Bufferizable>): ByteBuffer {
    val size = data.sumBy { it.size }
    val res = bufferBig(size)
    val address = memAddress(res)
    var offset = 0
    for (i in data.indices) {
        data.elementAt(i) to address + offset
        offset += data.elementAt(i).size
    }
    return res
}

fun intArrayOf(ints: Collection<Int>): IntBuffer {
    val buffer = intBufferBig(ints.size)
    for (i in ints.indices)
        buffer[i] = ints.elementAt(i)
    return buffer
}

//object uboVS : Bufferizable() {
//
//    var projectionMatrix = Mat4()
//    var modelMatrix = Mat4()
//    var viewMatrix = Mat4()
//
//    override val fieldOrder = arrayOf("projectionMatrix", "modelMatrix", "viewMatrix")
//
//    override infix fun to(address: Long) {
//        withAddress(address) {
//            //            add(projectionMatrix); add(modelMatrix); add(viewMatrix)
//        }
//    }
//}
//
//fun main(args: Array<String>) {
//    println(uboVS::class.declaredMemberProperties)
//    val member = uboVS::class.declaredMemberProperties.find { it.name == "projectionMatrix" }!!
//    println(member.returnType)
//    println(member.get(uboVS) as Mat4)
//    println(member.returnType == Mat4::class.defaultType)
//}

class FiledOrder {
    @Retention(AnnotationRetention.RUNTIME)
    annotation class Order(val value: Int)

    @Order(3)
    var field1: Int = 0
    @Order(1)
    var field2: Int = 0
    // no annotation
    var field4: Int = 0
    var field3: Int = 0

    @Order(1)
    fun start() {
    }

    @Order(2)
    fun end() {
    }
}

fun main(args: Array<String>) {
    val properties = FiledOrder::class.declaredMemberProperties
    val parts = properties.partition { it.findAnnotation<FiledOrder.Order>() == null }
    val plain = parts.first.sortedBy { it.name }
    val annotated = parts.second.associateBy { it.findAnnotation<FiledOrder.Order>()!!.value }
    val list = ArrayList<KProperty1<*, *>>()
    var plainIdx = 0
    for (i in properties.indices)
        list += annotated[i] ?: plain[plainIdx++]
    println(list)
}

typealias VkDebugReportCallbackType = (
        flag: VkDebugReportFlagsEXT,
        objType: VkDebugReportObjectType,
        scrType: Long,
        location: Long,
        msgCode: Int,
        layerPrefix: String,
        msg: String,
        userData: Any?) -> Boolean

operator fun VkAttachmentReference.invoke(attachment: Int, layout: VkImageLayout): VkAttachmentReference {
    return attachment(attachment).layout(layout.i)
}

fun ArrayList<VkDeviceQueueCreateInfo>.toBufferStack(): VkDeviceQueueCreateInfo.Buffer {
    val buffer = VkDeviceQueueCreateInfo.callocStack(size)
    for (i in indices)
        buffer[i] = get(i)
    return buffer
}