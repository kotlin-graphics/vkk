package vkk.extensions

import vkk.VkFlags

inline class VkConditionalRenderingEXT(val i: VkConditionalRenderingFlagsEXT) {
    companion object {
        val INVERTED_BIT_EXT = VkConditionalRenderingEXT(0x00000001)
    }
}

typealias VkConditionalRenderingFlagsEXT = VkFlags

//typedef struct VkConditionalRenderingBeginInfoEXT {
//    VkStructureType                   sType;
//    const void*                       pNext;
//    VkBuffer                          buffer;
//    VkDeviceSize                      offset;
//    VkConditionalRenderingFlagsEXT    flags;
//} VkConditionalRenderingBeginInfoEXT;
//
//typedef struct VkPhysicalDeviceConditionalRenderingFeaturesEXT {
//    VkStructureType    sType;
//    void*              pNext;
//    VkBool32           conditionalRendering;
//    VkBool32           inheritedConditionalRendering;
//} VkPhysicalDeviceConditionalRenderingFeaturesEXT;
//
//typedef struct VkCommandBufferInheritanceConditionalRenderingInfoEXT {
//    VkStructureType    sType;
//    const void*        pNext;
//    VkBool32           conditionalRenderingEnable;
//} VkCommandBufferInheritanceConditionalRenderingInfoEXT;
//
//
//VKAPI_ATTR void VKAPI_CALL vkCmdBeginConditionalRenderingEXT(
//VkCommandBuffer                             commandBuffer,
//const VkConditionalRenderingBeginInfoEXT*   pConditionalRenderingBegin);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdEndConditionalRenderingEXT(
//VkCommandBuffer                             commandBuffer);