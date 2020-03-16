package vkk.extensions

inline class VkDriverIdKHR(val i: Int) {
    companion object {
        val AMD_PROPRIETARY = VkDriverIdKHR(1)
        val AMD_OPEN_SOURCE = VkDriverIdKHR(2)
        val MESA_RADV = VkDriverIdKHR(3)
        val NVIDIA_PROPRIETARY = VkDriverIdKHR(4)
        val INTEL_PROPRIETARY_WINDOWS = VkDriverIdKHR(5)
        val INTEL_OPEN_SOURCE_MESA = VkDriverIdKHR(6)
        val IMAGINATION_PROPRIETARY = VkDriverIdKHR(7)
        val QUALCOMM_PROPRIETARY = VkDriverIdKHR(8)
        val ARM_PROPRIETARY = VkDriverIdKHR(9)
        val GOOGLE_PASTEL = VkDriverIdKHR(10)
        val GGP_PROPRIETARY = VkDriverIdKHR(11)
    }
}

//typedef struct VkConformanceVersionKHR {
//    uint8_t    major;
//    uint8_t    minor;
//    uint8_t    subminor;
//    uint8_t    patch;
//} VkConformanceVersionKHR;
//
//typedef struct VkPhysicalDeviceDriverPropertiesKHR {
//    VkStructureType            sType;
//    void*                      pNext;
//    VkDriverIdKHR              driverID;
//    char                       driverName[VK_MAX_DRIVER_NAME_SIZE_KHR];
//    char                       driverInfo[VK_MAX_DRIVER_INFO_SIZE_KHR];
//    VkConformanceVersionKHR    conformanceVersion;
//} VkPhysicalDeviceDriverPropertiesKHR;