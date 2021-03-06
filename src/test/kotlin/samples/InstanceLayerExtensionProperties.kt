package samples

import io.kotest.core.spec.style.StringSpec
import main.isNotCI
import vkk.vk10.structs.ExtensionProperties
import vkk.vk10.structs.LayerProperties
import vkk.vk
import vkk.vk10.enumerateInstanceExtensionProperties
import vkk.vk10.instanceLayerProperties

class InstanceLayerExtensionProperties : StringSpec() {

    class PropertyData(val layerProperties: LayerProperties, val extensionProperties: Array<ExtensionProperties>)

    init {
        if (isNotCI)
            "InstanceLayerExtensionProperties" {

                val layerProperties = vk.instanceLayerProperties

                /* VULKAN_KEY_START */

                val propertyData = Array(layerProperties.size) {
                    val layerProperty = layerProperties[it]
                    val extensionProperties = vk.enumerateInstanceExtensionProperties(layerProperty.layerName)
                    PropertyData(layerProperty, extensionProperties)
                }

                println("Instance Layers:")
                if (propertyData.isEmpty())
                    println("Set the environment variable VK_LAYER_PATH to point to the location of your layers")
                else
                    for (pd in propertyData) {
                        println(pd.layerProperties.layerName)
                        if (pd.extensionProperties.isEmpty())
                            print("Layer Extension: None")
                        else
                            for (it in pd.extensionProperties) {
                                if (it !== pd.extensionProperties[0])
                                    print(", ")
                                print("${it.extensionName} Version ${it.specVersion}")
                            }
                        print("\n\n")
                    }
            }
    }
}