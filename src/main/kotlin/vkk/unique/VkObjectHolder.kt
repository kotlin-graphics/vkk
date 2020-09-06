package vkk.unique

import org.lwjgl.system.MemoryStack
import vkk.*
import vkk.identifiers.VK
import vkk.vk10.VkStack_VK10
import java.util.*

class VkObjectHolder : UniqueVU, VkStack_VK10 {
    override val disposes: Deque<() -> Unit> = LinkedList()
    override val stack = VkStack.get()

    init {
        VK // trigger static create
    }

    fun dispose() {
        var func = disposes.pollLast()
        while (func != null) {
            func()
            func = disposes.pollLast()
        }
    }

}

fun `try`(block: VkObjectHolder.() -> Unit) {
    VkObjectHolder().apply {
        block()
        dispose()
    }
}
