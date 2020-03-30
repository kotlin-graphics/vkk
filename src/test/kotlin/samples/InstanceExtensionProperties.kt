package samples

import io.kotlintest.specs.StringSpec
import main.isNotCI
import vkk.vk
import vkk.vk10.enumerateInstanceExtensionProperties

class InstanceExtensionProperties : StringSpec() {

    init {
        if (isNotCI)
            "InstanceExtensionProperties" {

                val extensionProperties = vk.enumerateInstanceExtensionProperties()

                // sort the extensions alphabetically

                extensionProperties.sortBy { it.extensionName }

                println("Instance Extensions:")
                for (ep in extensionProperties)
                    println("${ep.extensionName}:\n\tVersion: ${ep.specVersion}\n")
            }
    }
}