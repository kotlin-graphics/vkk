package vkk

import glm_.BYTES
import glm_.mat3x3.Mat3
import glm_.mat4x4.Mat4
import glm_.vec2.Vec2
import glm_.vec3.Vec3
import glm_.vec4.Vec4
import kool.*
import org.lwjgl.system.MemoryUtil.*
import java.nio.ByteBuffer
import kotlin.reflect.KProperty1
import kotlin.reflect.KType
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.defaultType
import kotlin.reflect.full.findAnnotation


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
        fieldOrder.sumOf { field -> this::class.declaredMemberProperties.find { it.name == field }!!.returnType.size }
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
    val size = data.sumOf { it.size }
    val res = Buffer(size)
    val address = memAddress(res)
    var offset = 0
    for (i in data.indices) {
        data[i] to address + offset
        offset += data[i].size
    }
    return res
}

fun bufferOf(data: Collection<Bufferizable>): ByteBuffer {
    val size = data.sumOf { it.size }
    val res = Buffer(size)
    val address = memAddress(res)
    var offset = 0
    for (i in data.indices) {
        data.elementAt(i) to address + offset
        offset += data.elementAt(i).size
    }
    return res
}

fun intArrayOf(ints: Collection<Int>) = IntBuffer(ints.size) { ints.elementAt(it) }

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