package vkk.extensions

@JvmInline
value class VkValidationCheckEXT(val i: Int) {
    companion object {
        val ALL_EXT = VkValidationCheckEXT(0)
        val SHADERS_EXT = VkValidationCheckEXT(1)
    }
}

//typedef struct VkValidationFlagsEXT {
//    VkStructureType                sType;
//    const void*                    pNext;
//    uint32_t                       disabledValidationCheckCount;
//    const VkValidationCheckEXT*    pDisabledValidationChecks;
//} VkValidationFlagsEXT;