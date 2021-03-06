package tests

import io.kotest.core.spec.style.StringSpec
import main.isNotCI
import org.lwjgl.vulkan.VK11.VK_API_VERSION_1_1
import vkk.vk10.structs.ApplicationInfo
import vkk.vk10.structs.InstanceCreateInfo
import vkk.unique.`try`
import vkk.vk

class `01 initInstance` : StringSpec() {

    val appName = "01_InitInstance"

    init {
        if (isNotCI)
            appName {
                `try` {
                    // initialize the vk::ApplicationInfo structure
                    val applicationInfo = ApplicationInfo(appName, 1, engineName, 1, VK_API_VERSION_1_1)

                    // initialize the vk::InstanceCreateInfo
                    val instanceCreateInfo = InstanceCreateInfo(applicationInfo)

                    // create a UniqueInstance
                    val instance = vk.createInstanceUnique(instanceCreateInfo)

                    // Note: No need to explicitly destroy the instance, as the corresponding destroy function is
                    // called by the destructor of the UniqueInstance on leaving this scope.
                }
            }
    }
}