package vkk

import glm_.BYTES
import glm_.L
import glm_.i
import graphics.scenery.spirvcrossj.*
import kool.*
import org.lwjgl.PointerBuffer
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryStack.stackGet
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.memLengthUTF8
import org.lwjgl.system.MemoryUtil.memUTF8
import org.lwjgl.vulkan.VkAttachmentReference
import java.nio.Buffer
import java.nio.ByteBuffer
import java.nio.file.Files
import java.nio.file.Path


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


fun PointerBuffer.toArrayList(): ArrayList<String> {
    val count = this.remaining()
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

fun glslToSpirv(path: Path): ByteBuffer {

    var compileFail = false
    var linkFail = false
    val program = TProgram()

    val code = Files.readAllLines(path).joinToString("\n")

    val extension = path.toUri().toASCIIString().substringAfterLast(".")
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

    val bytes = MemoryStack.stackGet().malloc(spirv.size().i * Int.BYTES)
    val ints = bytes.asIntBuffer()
    for (i in 0 until ints.cap)
        ints[i] = spirv.get(i).i
    return bytes
}

operator fun VkAttachmentReference.invoke(attachment: Int, layout: VkImageLayout): VkAttachmentReference {
    return attachment(attachment).layout(layout.i)
}

//fun ArrayList<VkDeviceQueueCreateInfo>.toBufferStack(): VkDeviceQueueCreateInfo.Buffer {
//    val buffer = VkDeviceQueueCreateInfo.callocStack(size)
//    for (i in indices)
//        buffer[i] = get(i)
//    return buffer
//}

fun String.toUtf8Stack(): ByteBuffer = toUTF8(stackGet())

fun String.toUTF8(stack: MemoryStack): ByteBuffer {
    val size = memLengthUTF8(this, true)
    return stack.malloc(size).also {
        memUTF8(this, true, it)
    }
}

fun String.toUTF8(): ByteBuffer {
    val size = memLengthUTF8(this, true)
    return MemoryUtil.memAlloc(size).also {
        memUTF8(this, true, it)
    }
}

val ByteBuffer.utf8: String
    get() = MemoryUtil.memUTF8(this)

val Adr.utf8: String
    get() = MemoryUtil.memUTF8(this)

infix fun Buffer.copyTo(ptr: Ptr) = MemoryUtil.memCopy(adr, ptr, remSize.L)
infix fun Buffer.copyFrom(ptr: Ptr) = MemoryUtil.memCopy(ptr, adr, remSize.L)

val Int.vkr: VkResult
    get() = VkResult(this)



//fun vk.AttachmentDescription(size: Int, init: (Int) -> VkAttachmentDescription): VkAttachmentDescription.Buffer {
//    val res = VkAttachmentDescription.callocStack(size)
//    for (i in res.indices)
//        res[i] = init(i)
//    return res
//}
