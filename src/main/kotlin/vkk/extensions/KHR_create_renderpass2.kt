package vkk.extensions

//typedef struct VkAttachmentDescription2KHR {
//    VkStructureType                 sType;
//    const void*                     pNext;
//    VkAttachmentDescriptionFlags    flags;
//    VkFormat                        format;
//    VkSampleCountFlagBits           samples;
//    VkAttachmentLoadOp              loadOp;
//    VkAttachmentStoreOp             storeOp;
//    VkAttachmentLoadOp              stencilLoadOp;
//    VkAttachmentStoreOp             stencilStoreOp;
//    VkImageLayout                   initialLayout;
//    VkImageLayout                   finalLayout;
//} VkAttachmentDescription2KHR;
//
//typedef struct VkAttachmentReference2KHR {
//    VkStructureType       sType;
//    const void*           pNext;
//    uint32_t              attachment;
//    VkImageLayout         layout;
//    VkImageAspectFlags    aspectMask;
//} VkAttachmentReference2KHR;
//
//typedef struct VkSubpassDescription2KHR {
//    VkStructureType                     sType;
//    const void*                         pNext;
//    VkSubpassDescriptionFlags           flags;
//    VkPipelineBindPoint                 pipelineBindPoint;
//    uint32_t                            viewMask;
//    uint32_t                            inputAttachmentCount;
//    const VkAttachmentReference2KHR*    pInputAttachments;
//    uint32_t                            colorAttachmentCount;
//    const VkAttachmentReference2KHR*    pColorAttachments;
//    const VkAttachmentReference2KHR*    pResolveAttachments;
//    const VkAttachmentReference2KHR*    pDepthStencilAttachment;
//    uint32_t                            preserveAttachmentCount;
//    const uint32_t*                     pPreserveAttachments;
//} VkSubpassDescription2KHR;
//
//typedef struct VkSubpassDependency2KHR {
//    VkStructureType         sType;
//    const void*             pNext;
//    uint32_t                srcSubpass;
//    uint32_t                dstSubpass;
//    VkPipelineStageFlags    srcStageMask;
//    VkPipelineStageFlags    dstStageMask;
//    VkAccessFlags           srcAccessMask;
//    VkAccessFlags           dstAccessMask;
//    VkDependencyFlags       dependencyFlags;
//    int32_t                 viewOffset;
//} VkSubpassDependency2KHR;
//
//typedef struct VkRenderPassCreateInfo2KHR {
//    VkStructureType                       sType;
//    const void*                           pNext;
//    VkRenderPassCreateFlags               flags;
//    uint32_t                              attachmentCount;
//    const VkAttachmentDescription2KHR*    pAttachments;
//    uint32_t                              subpassCount;
//    const VkSubpassDescription2KHR*       pSubpasses;
//    uint32_t                              dependencyCount;
//    const VkSubpassDependency2KHR*        pDependencies;
//    uint32_t                              correlatedViewMaskCount;
//    const uint32_t*                       pCorrelatedViewMasks;
//} VkRenderPassCreateInfo2KHR;
//
//typedef struct VkSubpassBeginInfoKHR {
//    VkStructureType      sType;
//    const void*          pNext;
//    VkSubpassContents    contents;
//} VkSubpassBeginInfoKHR;
//
//typedef struct VkSubpassEndInfoKHR {
//    VkStructureType    sType;
//    const void*        pNext;
//} VkSubpassEndInfoKHR;
//
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateRenderPass2KHR(
//VkDevice                                    device,
//const VkRenderPassCreateInfo2KHR*           pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkRenderPass*                               pRenderPass);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdBeginRenderPass2KHR(
//VkCommandBuffer                             commandBuffer,
//const VkRenderPassBeginInfo*                pRenderPassBegin,
//const VkSubpassBeginInfoKHR*                pSubpassBeginInfo);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdNextSubpass2KHR(
//VkCommandBuffer                             commandBuffer,
//const VkSubpassBeginInfoKHR*                pSubpassBeginInfo,
//const VkSubpassEndInfoKHR*                  pSubpassEndInfo);
//
//VKAPI_ATTR void VKAPI_CALL vkCmdEndRenderPass2KHR(
//VkCommandBuffer                             commandBuffer,
//const VkSubpassEndInfoKHR*                  pSubpassEndInfo);