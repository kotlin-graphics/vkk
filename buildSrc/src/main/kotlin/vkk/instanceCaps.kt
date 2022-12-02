package vkk

import vkk.gen.generate
import vkk.gen.listAdoc
import java.io.File

fun InstanceCapabilities(target: File, vkDocs: File) {

    generate(target, vkDocs, "vkk/InstanceCapabilities.kt") {

        //        experimentals += Generator.Experimentals.UnsignedTypes

        `package` = "vkk"
        imports += listOf(
            //            "vkk.api.VkSemaphore_Array",
            //            "kool.Ptr",
            //            "vkk.Adr",
            //            "vkk.`=`",
            //            "vkk.MemStack",
            //            "kool.set",
            //            "vkk.set",
            //            "kool.ubuffers.UByteBuffer",
            //            "org.lwjgl.system.MemoryStack",
                         )

        /** Defines the capabilities of a Vulkan {@code VkInstance}. */
        "class InstanceCapabilities" {


        }
    }
}