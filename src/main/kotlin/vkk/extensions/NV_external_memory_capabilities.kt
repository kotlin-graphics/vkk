package vkk.extensions

//typedef enum VkExternalMemoryHandleTypeFlagBitsNV {
//    VK_EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_WIN32_BIT_NV = 0x00000001,
//    VK_EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_WIN32_KMT_BIT_NV = 0x00000002,
//    VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D11_IMAGE_BIT_NV = 0x00000004,
//    VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D11_IMAGE_KMT_BIT_NV = 0x00000008,
//    VK_EXTERNAL_MEMORY_HANDLE_TYPE_FLAG_BITS_MAX_ENUM_NV = 0x7FFFFFFF
//} VkExternalMemoryHandleTypeFlagBitsNV;
//typedef VkFlags VkExternalMemoryHandleTypeFlagsNV;
//
//typedef enum VkExternalMemoryFeatureFlagBitsNV {
//    VK_EXTERNAL_MEMORY_FEATURE_DEDICATED_ONLY_BIT_NV = 0x00000001,
//    VK_EXTERNAL_MEMORY_FEATURE_EXPORTABLE_BIT_NV = 0x00000002,
//    VK_EXTERNAL_MEMORY_FEATURE_IMPORTABLE_BIT_NV = 0x00000004,
//    VK_EXTERNAL_MEMORY_FEATURE_FLAG_BITS_MAX_ENUM_NV = 0x7FFFFFFF
//} VkExternalMemoryFeatureFlagBitsNV;
//typedef VkFlags VkExternalMemoryFeatureFlagsNV;
//typedef struct VkExternalImageFormatPropertiesNV {
//    VkImageFormatProperties              imageFormatProperties;
//    VkExternalMemoryFeatureFlagsNV       externalMemoryFeatures;
//    VkExternalMemoryHandleTypeFlagsNV    exportFromImportedHandleTypes;
//    VkExternalMemoryHandleTypeFlagsNV    compatibleHandleTypes;
//} VkExternalImageFormatPropertiesNV;
//
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetPhysicalDeviceExternalImageFormatPropertiesNV(
//VkPhysicalDevice                            physicalDevice,
//VkFormat                                    format,
//VkImageType                                 type,
//VkImageTiling                               tiling,
//VkImageUsageFlags                           usage,
//VkImageCreateFlags                          flags,
//VkExternalMemoryHandleTypeFlagsNV           externalHandleType,
//VkExternalImageFormatPropertiesNV*          pExternalImageFormatProperties);