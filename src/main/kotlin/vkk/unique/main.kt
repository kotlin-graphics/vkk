package vkk.unique

import org.lwjgl.system.MemoryStack
import vkk.VkStack
import vkk._10.createInstance
import vkk._10.structs.InstanceCreateInfo
import vkk.identifiers.Instance
import vkk.vk
import java.util.*

class VkObjectHolder : UniqueInstanceInterface {
    override val stack: Deque<() -> Unit> = LinkedList()
    override val vkStack = VkStack.stackPush()

    fun dispose() {
        var func = stack.pollLast()
        while (func != null) {
            func()
            func = stack.pollLast()
        }
        vkStack.pop()
    }
}

interface UniqueInstanceInterface {
    val stack: Deque<() -> Unit>
    val vkStack: VkStack

    fun vk.UniqueInstance(createInfo: InstanceCreateInfo): Instance = vkStack.run {
        val instance = vk createInstance createInfo
        stack += {
            instance.destroy()
            println("instance destroyed")
        }
        return instance
    }
}

fun `try`(block: VkObjectHolder.() -> Unit) {
    VkObjectHolder().apply {
        block()
        dispose()
    }
}
