package vkk.handles

import vkk.gen.Generator
import vkk.gen.generate
import java.io.File

fun InstanceCapabilities(target: File, vkDocs: File) {

    generate(target, vkDocs, "vkk/InstanceCapabilities.kt") {

        experimentals += Generator.Experimentals.UnsignedTypes

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

    }
}