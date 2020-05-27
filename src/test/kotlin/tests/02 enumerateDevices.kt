package tests

import io.kotest.core.spec.style.StringSpec
import main.isNotCI
import vkk.unique.`try`
import vkk.unique.vu

class `02 enumerateDevices` : StringSpec() {

    val appName = "02_EnumerateDevices"

    init {
        if (isNotCI)
            appName {
                `try` {
                    val instance = vu.createInstance(appName, engineName)
//                  if(vk.DEBUG)
//                      vu.createDebugUtilsMessenger(instance)

                    // enumerate the physicalDevices
                    val physicalDevice = instance.physicalDevices[0]

                    // Note: PhysicalDevices are not created, but just enumerated. Therefore, there is nothing like a UniquePhysicalDevice.
                    // A PhysicalDevice is unique by definition, and there's no need to destroy it.
                }
            }
    }
}