package vkk

import kool.Ptr
import kool.adr
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.vulkan.VkApplicationInfo

object vs {

    class ApplicationInfo {

        var applicationName: String? = null
        var engineName: String? = null
        var applicationVersion = 0
        var engineVersion = 0
        var apiVersion = 0

        inline fun <R> native(crossinline block: (VkApplicationInfo) -> R): R = stak { s ->
            s.asciiSafe(applicationName) { pAppName ->
                s.asciiSafe(engineName) { pEngName ->
                    val appInfo = s.ApplicationInfo().also {
                        it.applicationVersion = applicationVersion
                        it.engineVersion = engineVersion
                        it.apiVersion = apiVersion
                    }
                    memPutAddress(appInfo.adr + VkApplicationInfo.PAPPLICATIONNAME, pAppName)
                    memPutAddress(appInfo.adr + VkApplicationInfo.PENGINENAME, pEngName)
                    block(appInfo)
                }
            }
        }
    }
}

fun MemoryStack.ascii(chars: CharSequence, nullTerminated: Boolean = true): Ptr {
    val length = memLengthASCII(chars, nullTerminated)
    val target = nmalloc(1, length)
    encodeASCII(chars, nullTerminated, target)
    return target
}

fun <R> MemoryStack.asciiSafe(chars: CharSequence?, nullTerminated: Boolean = true, block: (Ptr) -> R): R = when(chars){
    null -> block(NULL)
    else -> block(ascii(chars, nullTerminated))
}

internal fun encodeASCII(text: CharSequence, nullTerminated: Boolean, target: Long): Int {
    var len = text.length
    for (p in 0 until len)
        memPutByte(target + p, text[p].toByte())
    if (nullTerminated)
        memPutByte(target + len++, 0.toByte())
    return len
}