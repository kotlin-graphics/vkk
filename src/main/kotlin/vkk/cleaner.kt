package vkk

//import glm_.L
//import java.lang.ref.Cleaner
//
//fun main() {
//    val cleaner = Cleaner.create()
//    for (i in 0..9) {
//        val vkObject: VkObject = VkObject(i.L)
//        cleaner.register(vkObject) { println("VkObject with id $i, is gc'ed") }
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
//inline class VkObject(val handle: Long)