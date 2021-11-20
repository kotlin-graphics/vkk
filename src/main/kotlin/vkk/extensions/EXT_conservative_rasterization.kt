package vkk.extensions

import vkk.VkFlags

@JvmInline
value class VkConservativeRasterizationModeEXT(val i: Int) {
    companion object {
        val DISABLED_EXT = VkConservativeRasterizationModeEXT(0)
        val OVERESTIMATE_EXT = VkConservativeRasterizationModeEXT(1)
        val UNDERESTIMATE_EXT = VkConservativeRasterizationModeEXT(2)
    }
}

typealias VkPipelineRasterizationConservativeStateCreateFlagsEXT = VkFlags

//typedef struct VkPhysicalDeviceConservativeRasterizationPropertiesEXT {
//    VkStructureType    sType;
//    void*              pNext;
//    float              primitiveOverestimationSize;
//    float              maxExtraPrimitiveOverestimationSize;
//    float              extraPrimitiveOverestimationSizeGranularity;
//    VkBool32           primitiveUnderestimation;
//    VkBool32           conservativePointAndLineRasterization;
//    VkBool32           degenerateTrianglesRasterized;
//    VkBool32           degenerateLinesRasterized;
//    VkBool32           fullyCoveredFragmentShaderInputVariable;
//    VkBool32           conservativeRasterizationPostDepthCoverage;
//} VkPhysicalDeviceConservativeRasterizationPropertiesEXT;
//
//typedef struct VkPipelineRasterizationConservativeStateCreateInfoEXT {
//    VkStructureType                                           sType;
//    const void*                                               pNext;
//    VkPipelineRasterizationConservativeStateCreateFlagsEXT    flags;
//    VkConservativeRasterizationModeEXT                        conservativeRasterizationMode;
//    float                                                     extraPrimitiveOverestimationSize;
//} VkPipelineRasterizationConservativeStateCreateInfoEXT;