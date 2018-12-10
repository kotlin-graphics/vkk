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

fun String.toUTF8stack(): ByteBuffer = toUTF8(MemoryStack.stackGet())

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

val VkResult.description: String
    get() = when (this) {
        // Success Codes
        SUCCESS -> "Command successfully completed"
        NOT_READY -> "A fence or query has not yet completed"
        TIMEOUT -> "A wait operation has not completed in the specified time"
        EVENT_SET -> "An event is signaled"
        EVENT_RESET -> "An event is unsignaled"
        INCOMPLETE -> "A return array was too small for the result"
        SUBOPTIMAL_KHR -> "A swapchain no longer matches the surface properties exactly, but can still be used to present to the surface successfully"
        // Error codes
        ERROR_OUT_OF_HOST_MEMORY -> "A host memory allocation has failed"
        ERROR_OUT_OF_DEVICE_MEMORY -> "A device memory allocation has failed"
        ERROR_INITIALIZATION_FAILED -> "Initialization of an object could not be completed for implementation-specific reasons"
        ERROR_DEVICE_LOST -> "The logical or physical device has been lost. See Lost Device"
        ERROR_MEMORY_MAP_FAILED -> "Mapping of a memory object has failed"
        ERROR_LAYER_NOT_PRESENT -> "A requested layer is not present or could not be loaded"
        ERROR_EXTENSION_NOT_PRESENT -> "A requested extension is not supported"
        ERROR_FEATURE_NOT_PRESENT -> "A requested feature is not supported"
        ERROR_INCOMPATIBLE_DRIVER -> "The requested version of Vulkan is not supported by the driver or is otherwise incompatible for implementation-specific reasons"
        ERROR_TOO_MANY_OBJECTS -> "Too many objects of the type have already been created"
        ERROR_FORMAT_NOT_SUPPORTED -> "A requested format is not supported on this device"
        ERROR_FRAGMENTED_POOL -> "A pool allocation has failed due to fragmentation of the pool’s memory. This must only be returned if no attempt to allocate host or device memory was made to accomodate the new allocation. This should be returned in preference to VK_ERROR_OUT_OF_POOL_MEMORY, but only if the implementation is certain that the pool allocation failure was due to fragmentation"
        ERROR_SURFACE_LOST_KHR -> "A surface is no longer available"
        ERROR_NATIVE_WINDOW_IN_USE_KHR -> "The requested window is already in use by Vulkan or another API in a manner which prevents it from being used again"
        ERROR_OUT_OF_DATE_KHR -> "A surface has changed in such a way that it is no longer compatible with the swapchain, and further presentation requests using the swapchain will fail. Applications must query the new surface properties and recreate their swapchain if they wish to continue presenting to the surface"
        ERROR_INCOMPATIBLE_DISPLAY_KHR -> "The display used by a swapchain does not use the same presentable image layout, or is incompatible in a way that prevents sharing an image"
        ERROR_INVALID_SHADER_NV -> "One or more shaders failed to compile or link. More details are reported back to the application via ../../html/vkspec.html#VK_EXT_debug_report if enabled"
        ERROR_OUT_OF_POOL_MEMORY -> "A pool memory allocation has failed. This must only be returned if no attempt to allocate host or device memory was made to accomodate the new allocation. If the failure was definitely due to fragmentation of the pool, VK_ERROR_FRAGMENTED_POOL should be returned instead"
        ERROR_INVALID_EXTERNAL_HANDLE -> "An external handle is not a valid handle of the specified type"
        ERROR_FRAGMENTATION_EXT -> "A descriptor pool creation has failed due to fragmentation"
        else -> "Unknown VkResult type"
    }

//fun vk.AttachmentDescription(size: Int, init: (Int) -> VkAttachmentDescription): VkAttachmentDescription.Buffer {
//    val res = VkAttachmentDescription.callocStack(size)
//    for (i in res.indices)
//        res[i] = init(i)
//    return res
//}
