@file:Suppress("NOTHING_TO_INLINE")

package vkk

import kool.Adr
import kool.Ptr
import org.lwjgl.system.FunctionProvider
import org.lwjgl.system.JNI
import org.lwjgl.system.MemoryUtil
import org.lwjgl.vulkan.VkPhysicalDevice
import vkk.identifiers.VK
import vkk.identifiers.VkInstance
import vkk.structs.VkExtensionProperties
import vkk.structs.VkInstanceCreateInfo

@JvmInline
value class Function(val adr: Adr) {

    inline fun ppp(param0: Ptr, param1: Ptr): Long = JNI.callPPP(param0, param1, adr)
    inline fun pppi(param0: Ptr, param1: Ptr, param2: Ptr): Int = JNI.callPPPI(param0, param1, param2, adr)
}

// Vulkan has only `JNI.call*`, no `JNI.invoke*`
@JvmInline
value class FunctionPPP(val adr: Adr) {
    inline operator fun invoke(param0: Ptr, param1: Ptr): Long = JNI.callPPP(param0, param1, adr)
    inline val isValid
        get() = adr != MemoryUtil.NULL
    inline val isNotValid
        get() = adr == MemoryUtil.NULL
}

interface FunctionInterface {
    val adr: Adr
    val isValid
        get() = adr != MemoryUtil.NULL
    val isNotValid
        get() = adr == MemoryUtil.NULL
}

fun FunctionProvider.getFunctionPPP(name: String) = FunctionPPP(getFunctionAddress(name))

@JvmInline
value class VkGetInstanceProcAddr(val adr: Adr) {
    inline operator fun invoke(pInstance: Ptr = MemoryUtil.NULL, pName: Ptr): PFN_vkVoidFunction = PFN_vkVoidFunction(JNI.callPPP(pInstance, pName, adr))
    inline val isValid: Boolean
        get() = adr != MemoryUtil.NULL
    inline val isNotValid: Boolean
        get() = adr == MemoryUtil.NULL

    constructor(provider: FunctionProvider) : this(provider.getFunctionAddress("vkGetInstanceProcAddr"))
}

@JvmInline
value class PFN_vkVoidFunction(val ptr: Ptr) {
    inline val isValid: Boolean
        get() = ptr != MemoryUtil.NULL
    inline val isNotValid: Boolean
        get() = ptr == MemoryUtil.NULL
}

@JvmInline
value class Ptr2<T>(val ptr: Ptr) {
    inline val isValid: Boolean
        get() = ptr != MemoryUtil.NULL
    inline val isNotValid: Boolean
        get() = ptr == MemoryUtil.NULL
}

@JvmInline
value class VkCreateInstance(val adr: Adr) {

    inline fun invoke(pCreateInfo: Ptr2<VkInstanceCreateInfo>,
                      pInstance: Ptr2<VkInstance>): VkResult {

        TODO()
    }

    constructor(vkGetInstanceProcAddr: VkGetInstanceProcAddr) : this(
        stak.asciiAdr("vkCreateInstance") {
            vkGetInstanceProcAddr(pName = it)
        }.ptr)
}

@JvmInline
value class VkEnumerateInstanceExtensionProperties(val adr: Adr) {

    inline fun invoke(pLayerName: Ptr2<Char>,
                      pPropertyCount: Ptr2<Int>,
                      pProperties: Ptr2<VkExtensionProperties>): VkResult {

        TODO()
    }

    constructor(vkGetInstanceProcAddr: VkGetInstanceProcAddr) : this(
        stak.asciiAdr("vkEnumerateInstanceExtensionProperties") {
            vkGetInstanceProcAddr(pName = it)
        }.ptr)
}
