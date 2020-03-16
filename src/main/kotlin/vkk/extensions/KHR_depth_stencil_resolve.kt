package vkk.extensions


inline class VkResolveModeKHR(val i: Int) {
    companion object {
        val NONE = VkResolveModeKHR(0)
        val SAMPLE_ZERO_BIT = VkResolveModeKHR(0x00000001)
        val AVERAGE_BIT = VkResolveModeKHR(0x00000002)
        val MIN_BIT = VkResolveModeKHR(0x00000004)
        val MAX_BIT = VkResolveModeKHR(0x00000008)
    }
}

typealias VkResolveModeFlagsKHR = VkCompositeAlphaFlagsKHR

//typedef struct VkSubpassDescriptionDepthStencilResolveKHR {
//    VkStructureType                     sType;
//    const void*                         pNext;
//    VkResolveModeFlagBitsKHR            depthResolveMode;
//    VkResolveModeFlagBitsKHR            stencilResolveMode;
//    const VkAttachmentReference2KHR*    pDepthStencilResolveAttachment;
//} VkSubpassDescriptionDepthStencilResolveKHR;
//
//typedef struct VkPhysicalDeviceDepthStencilResolvePropertiesKHR {
//    VkStructureType          sType;
//    void*                    pNext;
//    VkResolveModeFlagsKHR    supportedDepthResolveModes;
//    VkResolveModeFlagsKHR    supportedStencilResolveModes;
//    VkBool32                 independentResolveNone;
//    VkBool32                 independentResolve;
//} VkPhysicalDeviceDepthStencilResolvePropertiesKHR;