package vkk

import java.io.File
import vkk.gen.generate

fun VkInstance(target: File) {

    generate(target,"vkk/handles/VkInstance.kt") {

        `package` = "vkk.handles"


    }
}