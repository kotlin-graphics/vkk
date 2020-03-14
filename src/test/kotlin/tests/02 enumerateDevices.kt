package tests

import io.kotlintest.specs.StringSpec
import org.lwjgl.system.Configuration
import vkk.vk
import vkk.vu

class `02 enumerateDevices` : StringSpec() {

    val appName = "02_EnumerateDevices"
    val engineName = "Vulkan.hpp"

    init {
        "02 enumerateDevices" {

            val instance = vu.createInstance(appName, engineName)
//            if(vk.DEBUG)
//                vu.createDebugUtilsMessenger(instance)

            // enumerate the physicalDevices
            val physicalDevice = instance.enumeratePhysicalDevices.first()

            // Note: PhysicalDevices are not created, but just enumerated. Therefore, there is nothing like a UniquePhysicalDevice.
            // A PhysicalDevice is unique by definition, and there's no need to destroy it.
        }
    }
}