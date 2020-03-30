package samples

import io.kotlintest.specs.StringSpec
import main.isNotCI
import org.lwjgl.vulkan.VK10
import org.lwjgl.vulkan.VK10.VK_VERSION_MINOR
import org.lwjgl.vulkan.VK10.VK_VERSION_PATCH
import vkk.vk
import vkk.vk11.instanceVersion

class InstanceVersion : StringSpec() {

    fun decodeAPIVersion(apiVersion: Int) = "${VK10.VK_VERSION_MAJOR(apiVersion)}.${VK_VERSION_MINOR(apiVersion)}.${VK_VERSION_PATCH(apiVersion)}"

    init {
        if (isNotCI)
            "InstanceVersion" {
                val apiVersion = vk.instanceVersion
                println("APIVersion = ${decodeAPIVersion(apiVersion)}")
            }
    }
}