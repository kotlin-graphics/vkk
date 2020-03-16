package samples

import io.kotlintest.specs.StringSpec
import vkk.vk

class InstanceExtensionProperties : StringSpec() {

    init {
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