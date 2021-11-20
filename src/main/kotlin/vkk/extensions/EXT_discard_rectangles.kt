package vkk.extensions

import vkk.VkFlags

@JvmInline
value class VkDiscardRectangleModeEXT(val i: Int) {
    companion object {
        val INCLUSIVE_EXT = VkDiscardRectangleModeEXT(0)
        val EXCLUSIVE_EXT = VkDiscardRectangleModeEXT(1)
    }
}

typealias VkPipelineDiscardRectangleStateCreateFlagsEXT = VkFlags


//typedef struct VkPhysicalDeviceDiscardRectanglePropertiesEXT {
//    VkStructureType    sType;
//    void*              pNext;
//    uint32_t           maxDiscardRectangles;
//} VkPhysicalDeviceDiscardRectanglePropertiesEXT;
//
//typedef struct VkPipelineDiscardRectangleStateCreateInfoEXT {
//    VkStructureType                                  sType;
//    const void*                                      pNext;
//    VkPipelineDiscardRectangleStateCreateFlagsEXT    flags;
//    VkDiscardRectangleModeEXT                        discardRectangleMode;
//    uint32_t                                         discardRectangleCount;
//    const VkRect2D*                                  pDiscardRectangles;
//} VkPipelineDiscardRectangleStateCreateInfoEXT;
//
//
//VKAPI_ATTR void VKAPI_CALL vkCmdSetDiscardRectangleEXT(
//VkCommandBuffer                             commandBuffer,
//uint32_t                                    firstDiscardRectangle,
//uint32_t                                    discardRectangleCount,
//const VkRect2D*                             pDiscardRectangles);