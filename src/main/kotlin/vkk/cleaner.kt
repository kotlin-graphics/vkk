import org.lwjgl.vulkan.VK10

//package vkk
//
//import glm_.L
//import java.lang.ref.Cleaner
//
//fun main() {
//    val cleaner = Cleaner.create()
//    for (i in 0..9) {
//        val id = Integer.toString(i)
//        val vkObject = VkObject(i.L)
//        cleaner.register(vkObject, CleanerRunnable(id))
//    }
//
//    //myObjects are not reachable anymore
//    //do some other memory intensive work
//    for (i in 1..10000) {
//        val a = IntArray(10000)
//        try {
//            Thread.sleep(1)
//        } catch (e: InterruptedException) {
//        }
//
//    }
//}
//
//class CleanerRunnable(val id: String) : Runnable {
//    override fun run() = println("VkObject with id $id, is gc'ed")
//}
//
//class VkObject(val handle: Long)