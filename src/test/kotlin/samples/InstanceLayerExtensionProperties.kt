package samples

import io.kotlintest.specs.StringSpec
import vkk._10.structs.ExtensionProperties
import vkk._10.structs.LayerProperties
import vkk.vk

class InstanceLayerExtensionProperties : StringSpec() {

    class PropertyData(val layerProperties: LayerProperties, val extensionProperties: Array<ExtensionProperties>)

    init {
        "InstanceLayerExtensionProperties" {

            val layerProperties = vk.enumerateInstanceLayerProperties()

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