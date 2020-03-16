package vkk.extensions

import vkk.VkFlags

inline class VkViewportCoordinateSwizzleNV(val i: Int) {
    companion object {
        val POSITIVE_X_NV = VkViewportCoordinateSwizzleNV(0)
        val NEGATIVE_X_NV = VkViewportCoordinateSwizzleNV(1)
        val POSITIVE_Y_NV = VkViewportCoordinateSwizzleNV(2)
        val NEGATIVE_Y_NV = VkViewportCoordinateSwizzleNV(3)
        val POSITIVE_Z_NV = VkViewportCoordinateSwizzleNV(4)
        val NEGATIVE_Z_NV = VkViewportCoordinateSwizzleNV(5)
        val POSITIVE_W_NV = VkViewportCoordinateSwizzleNV(6)
        val NEGATIVE_W_NV = VkViewportCoordinateSwizzleNV(7)
    }
}

typealias VkPipelineViewportSwizzleStateCreateFlagsNV = VkFlags

//typedef struct VkViewportSwizzleNV {
//    VkViewportCoordinateSwizzleNV    x;
//    VkViewportCoordinateSwizzleNV    y;
//    VkViewportCoordinateSwizzleNV    z;
//    VkViewportCoordinateSwizzleNV    w;
//} VkViewportSwizzleNV;
//
//typedef struct VkPipelineViewportSwizzleStateCreateInfoNV {
//    VkStructureType                                sType;
//    const void*                                    pNext;
//    VkPipelineViewportSwizzleStateCreateFlagsNV    flags;
//    uint32_t                                       viewportCount;
//    const VkViewportSwizzleNV*                     pViewportSwizzles;
//} VkPipelineViewportSwizzleStateCreateInfoNV;