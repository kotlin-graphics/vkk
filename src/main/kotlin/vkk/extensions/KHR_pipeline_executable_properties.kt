package vkk.extensions

//typedef enum VkPipelineExecutableStatisticFormatKHR {
//    VK_PIPELINE_EXECUTABLE_STATISTIC_FORMAT_BOOL32_KHR = 0,
//    VK_PIPELINE_EXECUTABLE_STATISTIC_FORMAT_INT64_KHR = 1,
//    VK_PIPELINE_EXECUTABLE_STATISTIC_FORMAT_UINT64_KHR = 2,
//    VK_PIPELINE_EXECUTABLE_STATISTIC_FORMAT_FLOAT64_KHR = 3,
//    VK_PIPELINE_EXECUTABLE_STATISTIC_FORMAT_BEGIN_RANGE_KHR = VK_PIPELINE_EXECUTABLE_STATISTIC_FORMAT_BOOL32_KHR,
//    VK_PIPELINE_EXECUTABLE_STATISTIC_FORMAT_END_RANGE_KHR = VK_PIPELINE_EXECUTABLE_STATISTIC_FORMAT_FLOAT64_KHR,
//    VK_PIPELINE_EXECUTABLE_STATISTIC_FORMAT_RANGE_SIZE_KHR = (VK_PIPELINE_EXECUTABLE_STATISTIC_FORMAT_FLOAT64_KHR - VK_PIPELINE_EXECUTABLE_STATISTIC_FORMAT_BOOL32_KHR + 1),
//    VK_PIPELINE_EXECUTABLE_STATISTIC_FORMAT_MAX_ENUM_KHR = 0x7FFFFFFF
//} VkPipelineExecutableStatisticFormatKHR;
//typedef struct VkPhysicalDevicePipelineExecutablePropertiesFeaturesKHR {
//    VkStructureType    sType;
//    void*              pNext;
//    VkBool32           pipelineExecutableInfo;
//} VkPhysicalDevicePipelineExecutablePropertiesFeaturesKHR;
//
//typedef struct VkPipelineInfoKHR {
//    VkStructureType    sType;
//    const void*        pNext;
//    VkPipeline         pipeline;
//} VkPipelineInfoKHR;
//
//typedef struct VkPipelineExecutablePropertiesKHR {
//    VkStructureType       sType;
//    void*                 pNext;
//    VkShaderStageFlags    stages;
//    char                  name[VK_MAX_DESCRIPTION_SIZE];
//    char                  description[VK_MAX_DESCRIPTION_SIZE];
//    uint32_t              subgroupSize;
//} VkPipelineExecutablePropertiesKHR;
//
//typedef struct VkPipelineExecutableInfoKHR {
//    VkStructureType    sType;
//    const void*        pNext;
//    VkPipeline         pipeline;
//    uint32_t           executableIndex;
//} VkPipelineExecutableInfoKHR;
//
//typedef union VkPipelineExecutableStatisticValueKHR {
//    VkBool32    b32;
//    int64_t     i64;
//    uint64_t    u64;
//    double      f64;
//} VkPipelineExecutableStatisticValueKHR;
//
//typedef struct VkPipelineExecutableStatisticKHR {
//    VkStructureType                           sType;
//    void*                                     pNext;
//    char                                      name[VK_MAX_DESCRIPTION_SIZE];
//    char                                      description[VK_MAX_DESCRIPTION_SIZE];
//    VkPipelineExecutableStatisticFormatKHR    format;
//    VkPipelineExecutableStatisticValueKHR     value;
//} VkPipelineExecutableStatisticKHR;
//
//typedef struct VkPipelineExecutableInternalRepresentationKHR {
//    VkStructureType    sType;
//    void*              pNext;
//    char               name[VK_MAX_DESCRIPTION_SIZE];
//    char               description[VK_MAX_DESCRIPTION_SIZE];
//    VkBool32           isText;
//    size_t             dataSize;
//    void*              pData;
//} VkPipelineExecutableInternalRepresentationKHR;
//
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetPipelineExecutablePropertiesKHR(
//VkDevice                                    device,
//const VkPipelineInfoKHR*                    pPipelineInfo,
//uint32_t*                                   pExecutableCount,
//VkPipelineExecutablePropertiesKHR*          pProperties);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetPipelineExecutableStatisticsKHR(
//VkDevice                                    device,
//const VkPipelineExecutableInfoKHR*          pExecutableInfo,
//uint32_t*                                   pStatisticCount,
//VkPipelineExecutableStatisticKHR*           pStatistics);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetPipelineExecutableInternalRepresentationsKHR(
//VkDevice                                    device,
//const VkPipelineExecutableInfoKHR*          pExecutableInfo,
//uint32_t*                                   pInternalRepresentationCount,
//VkPipelineExecutableInternalRepresentationKHR* pInternalRepresentations);