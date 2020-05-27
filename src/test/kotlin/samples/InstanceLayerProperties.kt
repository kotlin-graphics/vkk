package samples

import io.kotest.core.spec.style.StringSpec
import main.isNotCI
import vkk.vk
import vkk.vk10.instanceLayerProperties

class InstanceLayerProperties : StringSpec() {

    init {
        if (isNotCI)
            "InstanceLayerProperties" {

                val layerProperties = vk.instanceLayerProperties

                println("Instance Layers:")
                if (layerProperties.isEmpty())
                    println("Set the environment variable VK_LAYER_PATH to point to the location of your layers")
                for (lp in layerProperties) {
                    println("${lp.layerName}:")
                    println("\tVersion: ${lp.implementationVersion}")
                    println("\tAPI Version: (${lp.specVersion shr 22}.${(lp.specVersion shr 12) and 0x03FF}.${lp.specVersion and 0xFFF})")
                    println("\tDescription: ${lp.description}")
                    println()
                }
            }
    }
}