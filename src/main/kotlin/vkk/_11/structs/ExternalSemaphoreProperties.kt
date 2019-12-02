package vkk._11.structs

import vkk.VkExternalSemaphoreFeatureFlags
import vkk.VkExternalSemaphoreHandleTypeFlags
import vkk.VkStructureType

/**
 * Structure describing supported external semaphore handle features.
 *
 * <h5>Description</h5>
 *
 * <p>If {@code handleType} is not supported by the implementation, then {@link VkExternalSemaphoreProperties}{@code ::externalSemaphoreFeatures} will be set to zero.</p>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_EXTERNAL_SEMAPHORE_PROPERTIES STRUCTURE_TYPE_EXTERNAL_SEMAPHORE_PROPERTIES}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL}</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VK11#vkGetPhysicalDeviceExternalSemaphoreProperties GetPhysicalDeviceExternalSemaphoreProperties}, {@link KHRExternalSemaphoreCapabilities#vkGetPhysicalDeviceExternalSemaphorePropertiesKHR GetPhysicalDeviceExternalSemaphorePropertiesKHR}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code exportFromImportedHandleTypes} &ndash; a bitmask of {@code VkExternalSemaphoreHandleTypeFlagBits} specifying which types of imported handle {@code handleType} <b>can</b> be exported from.</li>
 * <li>{@code compatibleHandleTypes} &ndash; a bitmask of {@code VkExternalSemaphoreHandleTypeFlagBits} specifying handle types which <b>can</b> be specified at the same time as {@code handleType} when creating a semaphore.</li>
 * <li>{@code externalSemaphoreFeatures} &ndash; a bitmask of {@code VkExternalSemaphoreFeatureFlagBits} describing the features of {@code handleType}.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkExternalSemaphoreProperties {
 *     VkStructureType sType;
 *     void * pNext;
 *     VkExternalSemaphoreHandleTypeFlags exportFromImportedHandleTypes;
 *     VkExternalSemaphoreHandleTypeFlags compatibleHandleTypes;
 *     VkExternalSemaphoreFeatureFlags externalSemaphoreFeatures;
 * }</code></pre>
 */
class ExternalSemaphoreProperties(
        var exportFromImportedHandleTypes: VkExternalSemaphoreHandleTypeFlags,
        var compatibleHandleTypes: VkExternalSemaphoreHandleTypeFlags,
        var externalSemaphoreFeatures: VkExternalSemaphoreFeatureFlags
) {

    val type get() = VkStructureType.EXTERNAL_SEMAPHORE_PROPERTIES
}