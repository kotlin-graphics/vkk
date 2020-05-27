package vkk.unique

import vkk.VkStack
import vkk.vk10.VkStack_VK10
import java.util.*

class VkObjectHolder : UniqueVU, VkStack_VK10 {
    override val disposes: Deque<() -> Unit> = LinkedList()
    override val stack = VkStack.stackPush()

    fun dispose() {
        var func = disposes.pollLast()
        while (func != null) {
            func()
            func = disposes.pollLast()
        }
        stack.pop()
    }
}

fun `try`(block: VkObjectHolder.() -> Unit) {
    VkObjectHolder().apply {
        block()
        dispose()
    }
}
