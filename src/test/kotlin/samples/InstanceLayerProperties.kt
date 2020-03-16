package samples

import io.kotlintest.specs.StringSpec
import vkk.vk

class InstanceLayerProperties : StringSpec() {

    init {
        "InstanceLayerProperties" {

            val layerProperties = vk.enumerateInstanceLayerProperties()

            println("Instance Layers:")
            if (layerProperties.isEmpty())
                println("Set the environment variable VK_LAYER_PATH to point to the location of your layers")
            for (lp in layerProperties)            {
                println("${lp.layerName}:")
                println("\tVersion: ${lp.implementationVersion}")
                println("\tAPI Version: (${lp.specVersion shr 22}.${(lp.specVersion shr 12) and 0x03FF}.${lp.specVersion and 0xFFF})")
                println("\tDescription: ${lp.description}")
                println()
            }
        }
    }
}