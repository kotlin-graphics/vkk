package vkk.extensions

inline class VkShaderInfoTypeAMD(val i: Int) {
    companion object {
        val STATISTICS_AMD = VkShaderInfoTypeAMD(0)
        val BINARY_AMD = VkShaderInfoTypeAMD(1)
        val DISASSEMBLY_AMD = VkShaderInfoTypeAMD(2)
    }
}

//typedef struct VkShaderResourceUsageAMD {
//    uint32_t    numUsedVgprs;
//    uint32_t    numUsedSgprs;
//    uint32_t    ldsSizePerLocalWorkGroup;
//    size_t      ldsUsageSizeInBytes;
//    size_t      scratchMemUsageInBytes;
//} VkShaderResourceUsageAMD;
//
//typedef struct VkShaderStatisticsInfoAMD {
//    VkShaderStageFlags          shaderStageMask;
//    VkShaderResourceUsageAMD    resourceUsage;
//    uint32_t                    numPhysicalVgprs;
//    uint32_t                    numPhysicalSgprs;
//    uint32_t                    numAvailableVgprs;
//    uint32_t                    numAvailableSgprs;
//    uint32_t                    computeWorkGroupSize[3];
//} VkShaderStatisticsInfoAMD;
//
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetShaderInfoAMD(
//VkDevice                                    device,
//VkPipeline                                  pipeline,
//VkShaderStageFlagBits                       shaderStage,
//VkShaderInfoTypeAMD                         infoType,
//size_t*                                     pInfoSize,
//void*                                       pInfo);