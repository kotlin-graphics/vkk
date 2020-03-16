package vkk

import kool.adr
import kool.pointerAdr
import org.lwjgl.system.JNI
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil
import vkk._10.structs.DeviceCreateInfo
import vkk._10.structs.InstanceCreateInfo
import vkk.identifiers.UniqueDevice
import vkk.identifiers.UniqueInstance

interface VkCleanable {
    fun destroy()
}

class vkUnique private constructor() {

    val objects = ArrayList<VkCleanable>()

    fun UniqueInstance(createInfo: InstanceCreateInfo): UniqueInstance =
            vkk.identifiers.UniqueInstance(createInfo).also { objects += it }

//    infix fun MemoryStack.createDeviceUnique(createInfo: DeviceCreateInfo): UniqueDevice =
//            framed {
//                val handle = this.pointerAdr { VK_CHECK_RESULT(JNI.callPPPPI(this@PhysicalDevice.adr, createInfo write this, MemoryUtil.NULL, it, capabilities.vkCreateDevice)) }
//                UniqueDevice(handle, this@PhysicalDevice, createInfo)
//            }
//
//    infix fun createDeviceUnique(createInfo: DeviceCreateInfo): UniqueDevice =
//            stak { it createDeviceUnique createInfo }

    companion object {
        operator fun invoke(block: vkUnique.() -> Unit) {
            vkUnique().apply {
                block()
                for (i in objects.indices.reversed())
                    objects[i].destroy()
            }
        }
    }
}