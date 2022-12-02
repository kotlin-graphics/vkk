package vkk

import vkk.gen.generate
import vkk.gen.listAdoc
import java.io.File

fun protos(target: File, vkDocs: File) {

    generate(target, vkDocs, "vkk/api/protos.kt") {

//        experimentals += Generator.Experimentals.UnsignedTypes

        `package` = "vkk.api"
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

        for (proto in vkDocs.resolve("gen/api/protos").listAdoc()) {

            val protoName = proto.nameWithoutExtension

            val lines = proto.readText().lines().drop(5).dropLast(2)

            val protoRet = lines.first().substringBefore(' ')

            val args = ArrayList<String>()

            for (line in lines.drop(1)) {

                val (nType, nName) = line.trimStart().dropLast(1).split(Regex("\\s+"))

                args += "$nName: $nType"
            }
            val jointArgs = args.joinToString(",\n")
            +"fun $protoName($jointArgs): $protoRet"
        }
    }
}