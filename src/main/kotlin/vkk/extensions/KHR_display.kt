package vkk.extensions

import vkk.VkFlags
import vkk.VkStructureType
import vkk._10.structs.Extent2D
import vkk._10.structs.Offset2D
import vkk.entities.VkDisplayKHR
import vkk.entities.VkDisplayModeKHR

inline class VkDisplayPlaneAlphaKHR(val i: Int) {

    companion object {
        val OPAQUE_BIT = VkDisplayPlaneAlphaKHR(0x00000001)
        val GLOBAL_BIT = VkDisplayPlaneAlphaKHR(0x00000002)
        val PER_PIXEL_BIT = VkDisplayPlaneAlphaKHR(0x00000004)
        val PER_PIXEL_PREMULTIPLIED_BIT = VkDisplayPlaneAlphaKHR(0x00000008)
    }
}

typealias VkDisplayPlaneAlphaFlagsKHR = VkFlags
typealias VkDisplayModeCreateFlagsKHR = VkFlags
typealias VkDisplaySurfaceCreateFlagsKHR = VkFlags

/**
 * Structure describing an available display device.
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code display} &ndash; a handle that is used to refer to the display described here. This handle will be valid for the lifetime of the Vulkan instance.</li>
 * <li>{@code displayName} &ndash; a pointer to a NULL-terminated string containing the name of the display. Generally, this will be the name provided by the display&#8217;s EDID. It <b>can</b> be {@code NULL} if no suitable name is available. If not {@code NULL}, the memory it points to <b>must</b> remain accessible as long as {@code display} is valid.</li>
 * <li>{@code physicalDimensions} &ndash; describes the physical width and height of the visible portion of the display, in millimeters.</li>
 * <li>{@code physicalResolution} &ndash; describes the physical, native, or preferred resolution of the display.
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>For devices which have no natural value to return here, implementations <b>should</b> return the maximum resolution supported.</p>
 * </div></li>
 * <li>{@code supportedTransforms} &ndash; a bitmask of {@code VkSurfaceTransformFlagBitsKHR} describing which transforms are supported by this display.</li>
 * <li>{@code planeReorderPossible} &ndash; tells whether the planes on this display <b>can</b> have their z order changed. If this is {@link VK10#VK_TRUE TRUE}, the application <b>can</b> re-arrange the planes on this display in any order relative to each other.</li>
 * <li>{@code persistentContent} &ndash; tells whether the display supports self-refresh/internal buffering. If this is true, the application <b>can</b> submit persistent present operations on swapchains created against this display.
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>Persistent presents <b>may</b> have higher latency, and <b>may</b> use less power when the screen content is updated infrequently, or when only a portion of the screen needs to be updated in most frames.</p>
 * </div></li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkDisplayPropertiesKHR {
 *     VkDisplayKHR display;
 *     char const * displayName;
 *     {@link VkExtent2D VkExtent2D} physicalDimensions;
 *     {@link VkExtent2D VkExtent2D} physicalResolution;
 *     VkSurfaceTransformFlagsKHR supportedTransforms;
 *     VkBool32 planeReorderPossible;
 *     VkBool32 persistentContent;
 * }</code></pre>
 */
class DisplayPropertiesKHR(
        var display: VkDisplayKHR,
        var displayName: String,
        var physicalDimensions: Extent2D,
        var physicalResolution: Extent2D,
        var supportedTransforms: VkSurfaceTransformFlagsKHR,
        var planeReorderPossible: Boolean,
        var persistentContent: Boolean) {


}

/**
 * Structure describing display parameters associated with a display mode.
 *
 * <h5>Description</h5>
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>For example, a 60Hz display mode would report a {@code refreshRate} of 60,000.</p>
 * </div>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>The {@code width} member of {@code visibleRegion} <b>must</b> be greater than 0</li>
 * <li>The {@code height} member of {@code visibleRegion} <b>must</b> be greater than 0</li>
 * <li>{@code refreshRate} <b>must</b> be greater than 0</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkDisplayModeCreateInfoKHR}, {@link VkDisplayModePropertiesKHR}, {@link VkExtent2D}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code visibleRegion} &ndash; the 2D extents of the visible region.</li>
 * <li>{@code refreshRate} &ndash; a {@code uint32_t} that is the number of times the display is refreshed each second multiplied by 1000.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkDisplayModeParametersKHR {
 *     {@link VkExtent2D VkExtent2D} visibleRegion;
 *     uint32_t refreshRate;
 * }</code></pre>
 */
class DisplayModeParametersKHR(
        var visibleRegion: Extent2D,
        var refreshRate: Int)

/**
 * Structure describing display mode properties.
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code displayMode} &ndash; a handle to the display mode described in this structure. This handle will be valid for the lifetime of the Vulkan instance.</li>
 * <li>{@code parameters} &ndash; a {@link VkDisplayModeParametersKHR} structure describing the display parameters associated with {@code displayMode}.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkDisplayModePropertiesKHR {
 *     VkDisplayModeKHR displayMode;
 *     {@link VkDisplayModeParametersKHR VkDisplayModeParametersKHR} parameters;
 * }</code></pre>
 */
class DisplayModePropertiesKHR(
        var displayMode: VkDisplayModeKHR,
        var parameters: DisplayModeParametersKHR)

/**
 * Structure specifying parameters of a newly created display mode object.
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link KHRDisplay#VK_STRUCTURE_TYPE_DISPLAY_MODE_CREATE_INFO_KHR STRUCTURE_TYPE_DISPLAY_MODE_CREATE_INFO_KHR}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL}</li>
 * <li>{@code flags} <b>must</b> be 0</li>
 * <li>{@code parameters} <b>must</b> be a valid {@link VkDisplayModeParametersKHR} structure</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkDisplayModeParametersKHR}, {@link KHRDisplay#vkCreateDisplayModeKHR CreateDisplayModeKHR}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code flags} &ndash; reserved for future use, and <b>must</b> be zero.</li>
 * <li>{@code parameters} &ndash; a {@link VkDisplayModeParametersKHR} structure describing the display parameters to use in creating the new mode. If the parameters are not compatible with the specified display, the implementation <b>must</b> return {@link VK10#VK_ERROR_INITIALIZATION_FAILED ERROR_INITIALIZATION_FAILED}.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkDisplayModeCreateInfoKHR {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkDisplayModeCreateFlagsKHR flags;
 *     {@link VkDisplayModeParametersKHR VkDisplayModeParametersKHR} parameters;
 * }</code></pre>
 */
class DisplayModeCreateInfoKHR(
        var parameters: DisplayModeParametersKHR) {

    val type get() = VkStructureType.DISPLAY_MODE_CREATE_INFO_KHR
}

/**
 * Structure describing capabilities of a mode and plane combination.
 *
 * <h5>Description</h5>
 *
 * <p>The minimum and maximum position and extent fields describe the implementation limits, if any, as they apply to the specified display mode and plane. Vendors <b>may</b> support displaying a subset of a swapchain's presentable images on the specified display plane. This is expressed by returning {@code minSrcPosition}, {@code maxSrcPosition}, {@code minSrcExtent}, and {@code maxSrcExtent} values that indicate a range of possible positions and sizes <b>may</b> be used to specify the region within the presentable images that source pixels will be read from when creating a swapchain on the specified display mode and plane.</p>
 *
 * <p>Vendors <b>may</b> also support mapping the presentable images`' content to a subset or superset of the visible region in the specified display mode. This is expressed by returning {@code minDstPosition}, {@code maxDstPosition}, {@code minDstExtent} and {@code maxDstExtent} values that indicate a range of possible positions and sizes <b>may</b> be used to describe the region within the display mode that the source pixels will be mapped to.</p>
 *
 * <p>Other vendors <b>may</b> support only a 1-1 mapping between pixels in the presentable images and the display mode. This <b>may</b> be indicated by returning <code>(0,0)</code> for {@code minSrcPosition}, {@code maxSrcPosition}, {@code minDstPosition}, and {@code maxDstPosition}, and (display mode width, display mode height) for {@code minSrcExtent}, {@code maxSrcExtent}, {@code minDstExtent}, and {@code maxDstExtent}.</p>
 *
 * <p>These values indicate the limits of the implementation's individual fields. Not all combinations of values within the offset and extent ranges returned in {@link VkDisplayPlaneCapabilitiesKHR} are guaranteed to be supported. Vendors <b>may</b> still fail presentation requests that specify unsupported combinations.</p>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkDisplayPlaneCapabilities2KHR}, {@link VkExtent2D}, {@link VkOffset2D}, {@link KHRDisplay#vkGetDisplayPlaneCapabilitiesKHR GetDisplayPlaneCapabilitiesKHR}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code supportedAlpha} &ndash; a bitmask of {@code VkDisplayPlaneAlphaFlagBitsKHR} describing the supported alpha blending modes.</li>
 * <li>{@code minSrcPosition} &ndash; the minimum source rectangle offset supported by this plane using the specified mode.</li>
 * <li>{@code maxSrcPosition} &ndash; the maximum source rectangle offset supported by this plane using the specified mode. The {@code x} and {@code y} components of {@code maxSrcPosition} <b>must</b> each be greater than or equal to the {@code x} and {@code y} components of {@code minSrcPosition}, respectively.</li>
 * <li>{@code minSrcExtent} &ndash; the minimum source rectangle size supported by this plane using the specified mode.</li>
 * <li>{@code maxSrcExtent} &ndash; the maximum source rectangle size supported by this plane using the specified mode.</li>
 * <li>{@code minDstPosition} &ndash; {@code minDstPosition}, {@code maxDstPosition}, {@code minDstExtent}, {@code maxDstExtent} all have similar semantics to their corresponding ptext:<b>Src</b> equivalents, but apply to the output region within the mode rather than the input region within the source image. Unlike the ptext:<b>Src</b> offsets, {@code minDstPosition} and {@code maxDstPosition} <b>may</b> contain negative values.</li>
 * <li>{@code maxDstPosition} &ndash; see {@code minDstPosition}</li>
 * <li>{@code minDstExtent} &ndash; see {@code minDstPosition}</li>
 * <li>{@code maxDstExtent} &ndash; see {@code minDstPosition}</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkDisplayPlaneCapabilitiesKHR {
 *     VkDisplayPlaneAlphaFlagsKHR supportedAlpha;
 *     {@link VkOffset2D VkOffset2D} minSrcPosition;
 *     {@link VkOffset2D VkOffset2D} maxSrcPosition;
 *     {@link VkExtent2D VkExtent2D} minSrcExtent;
 *     {@link VkExtent2D VkExtent2D} maxSrcExtent;
 *     {@link VkOffset2D VkOffset2D} minDstPosition;
 *     {@link VkOffset2D VkOffset2D} maxDstPosition;
 *     {@link VkExtent2D VkExtent2D} minDstExtent;
 *     {@link VkExtent2D VkExtent2D} maxDstExtent;
 * }</code></pre>
 */
class DisplayPlaneCapabilitiesKHR(
        var supportedAlpha: VkDisplayPlaneAlphaFlagsKHR,
        var minSrcPosition: Offset2D,
        var maxSrcPosition: Offset2D,
        var minSrcExtent: Extent2D,
        var maxSrcExtent: Extent2D,
        var minDstPosition: Offset2D,
        var maxDstPosition: Offset2D,
        var minDstExtent: Extent2D,
        var maxDstExten: Extent2D)

/**
 * Structure describing display plane properties.
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code currentDisplay} &ndash; the handle of the display the plane is currently associated with. If the plane is not currently attached to any displays, this will be {@link VK10#VK_NULL_HANDLE NULL_HANDLE}.</li>
 * <li>{@code currentStackIndex} &ndash; the current z-order of the plane. This will be between 0 and the value returned by {@code vkGetPhysicalDeviceDisplayPlanePropertiesKHR} in {@code pPropertyCount}.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkDisplayPlanePropertiesKHR {
 *     VkDisplayKHR currentDisplay;
 *     uint32_t currentStackIndex;
 * }</code></pre>
 */
class DisplayPlanePropertiesKHR(
        var currentDisplay: VkDisplayKHR,
        var currentStackIndex: Int)

/**
 * Structure specifying parameters of a newly created display plane surface object.
 *
 * <h5>Description</h5>
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>Creating a display surface <b>must</b> not modify the state of the displays, planes, or other resources it names. For example, it <b>must</b> not apply the specified mode to be set on the associated display. Application of display configuration occurs as a side effect of presenting to a display surface.</p>
 * </div>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code planeIndex} <b>must</b> be less than the number of display planes supported by the device as determined by calling {@code vkGetPhysicalDeviceDisplayPlanePropertiesKHR}</li>
 * <li>If the {@code planeReorderPossible} member of the {@link VkDisplayPropertiesKHR} structure returned by {@code vkGetPhysicalDeviceDisplayPropertiesKHR} for the display corresponding to {@code displayMode} is {@link VK10#VK_TRUE TRUE} then {@code planeStackIndex} <b>must</b> be less than the number of display planes supported by the device as determined by calling {@code vkGetPhysicalDeviceDisplayPlanePropertiesKHR}; otherwise {@code planeStackIndex} <b>must</b> equal the {@code currentStackIndex} member of {@link VkDisplayPlanePropertiesKHR} returned by {@code vkGetPhysicalDeviceDisplayPlanePropertiesKHR} for the display plane corresponding to {@code displayMode}</li>
 * <li>If {@code alphaMode} is {@link KHRDisplay#VK_DISPLAY_PLANE_ALPHA_GLOBAL_BIT_KHR DISPLAY_PLANE_ALPHA_GLOBAL_BIT_KHR} then {@code globalAlpha} <b>must</b> be between 0 and 1, inclusive</li>
 * <li>{@code alphaMode} <b>must</b> be 0 or one of the bits present in the {@code supportedAlpha} member of {@link VkDisplayPlaneCapabilitiesKHR} returned by {@code vkGetDisplayPlaneCapabilitiesKHR} for the display plane corresponding to {@code displayMode}</li>
 * <li>The {@code width} and {@code height} members of {@code imageExtent} <b>must</b> be less than the {@code maxImageDimensions2D} member of {@link VkPhysicalDeviceLimits}</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link KHRDisplay#VK_STRUCTURE_TYPE_DISPLAY_SURFACE_CREATE_INFO_KHR STRUCTURE_TYPE_DISPLAY_SURFACE_CREATE_INFO_KHR}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL}</li>
 * <li>{@code flags} <b>must</b> be 0</li>
 * <li>{@code displayMode} <b>must</b> be a valid {@code VkDisplayModeKHR} handle</li>
 * <li>{@code transform} <b>must</b> be a valid {@code VkSurfaceTransformFlagBitsKHR} value</li>
 * <li>{@code alphaMode} <b>must</b> be a valid {@code VkDisplayPlaneAlphaFlagBitsKHR} value</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkExtent2D}, {@link KHRDisplay#vkCreateDisplayPlaneSurfaceKHR CreateDisplayPlaneSurfaceKHR}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code flags} &ndash; reserved for future use, and <b>must</b> be zero.</li>
 * <li>{@code displayMode} &ndash; a {@code VkDisplayModeKHR} handle specifying the mode to use when displaying this surface.</li>
 * <li>{@code planeIndex} &ndash; the plane on which this surface appears.</li>
 * <li>{@code planeStackIndex} &ndash; the z-order of the plane.</li>
 * <li>{@code transform} &ndash; a {@code VkSurfaceTransformFlagBitsKHR} value specifying the transformation to apply to images as part of the scanout operation.</li>
 * <li>{@code globalAlpha} &ndash; the global alpha value. This value is ignored if {@code alphaMode} is not {@link KHRDisplay#VK_DISPLAY_PLANE_ALPHA_GLOBAL_BIT_KHR DISPLAY_PLANE_ALPHA_GLOBAL_BIT_KHR}.</li>
 * <li>{@code alphaMode} &ndash; a {@code VkDisplayPlaneAlphaFlagBitsKHR} value specifying the type of alpha blending to use.</li>
 * <li>{@code imageExtent} &ndash; The size of the presentable images to use with the surface.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkDisplaySurfaceCreateInfoKHR {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkDisplaySurfaceCreateFlagsKHR flags;
 *     VkDisplayModeKHR displayMode;
 *     uint32_t planeIndex;
 *     uint32_t planeStackIndex;
 *     VkSurfaceTransformFlagBitsKHR transform;
 *     float globalAlpha;
 *     VkDisplayPlaneAlphaFlagBitsKHR alphaMode;
 *     {@link VkExtent2D VkExtent2D} imageExtent;
 * }</code></pre>
 */
class DisplaySurfaceCreateInfoKHR // TODO

//VKAPI_ATTR VkResult VKAPI_CALL vkGetPhysicalDeviceDisplayPropertiesKHR(
//VkPhysicalDevice                            physicalDevice,
//uint32_t*                                   pPropertyCount,
//VkDisplayPropertiesKHR*                     pProperties);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetPhysicalDeviceDisplayPlanePropertiesKHR(
//VkPhysicalDevice                            physicalDevice,
//uint32_t*                                   pPropertyCount,
//VkDisplayPlanePropertiesKHR*                pProperties);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetDisplayPlaneSupportedDisplaysKHR(
//VkPhysicalDevice                            physicalDevice,
//uint32_t                                    planeIndex,
//uint32_t*                                   pDisplayCount,
//VkDisplayKHR*                               pDisplays);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetDisplayModePropertiesKHR(
//VkPhysicalDevice                            physicalDevice,
//VkDisplayKHR                                display,
//uint32_t*                                   pPropertyCount,
//VkDisplayModePropertiesKHR*                 pProperties);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateDisplayModeKHR(
//VkPhysicalDevice                            physicalDevice,
//VkDisplayKHR                                display,
//const VkDisplayModeCreateInfoKHR*           pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkDisplayModeKHR*                           pMode);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkGetDisplayPlaneCapabilitiesKHR(
//VkPhysicalDevice                            physicalDevice,
//VkDisplayModeKHR                            mode,
//uint32_t                                    planeIndex,
//VkDisplayPlaneCapabilitiesKHR*              pCapabilities);
//
//VKAPI_ATTR VkResult VKAPI_CALL vkCreateDisplayPlaneSurfaceKHR(
//VkInstance                                  instance,
//const VkDisplaySurfaceCreateInfoKHR*        pCreateInfo,
//const VkAllocationCallbacks*                pAllocator,
//VkSurfaceKHR*                               pSurface);