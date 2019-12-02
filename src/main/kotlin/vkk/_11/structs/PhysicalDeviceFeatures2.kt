package vkk._11.structs

import kool.Ptr
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.NULL
import vkk.VkStructureType
import vkk._10.structs.PhysicalDeviceFeatures

/**
 * Structure describing the fine-grained features that can be supported by an implementation.
 *
 * <h5>Description</h5>
 *
 * <p>The {@code pNext} chain of this structure is used to extend the structure with features defined by extensions. This structure <b>can</b> be used in {@link VK11#vkGetPhysicalDeviceFeatures2 GetPhysicalDeviceFeatures2} or <b>can</b> be in the {@code pNext} chain of a {@link VkDeviceCreateInfo} structure, in which case it controls which features are enabled in the device in lieu of {@code pEnabledFeatures}.</p>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_FEATURES_2 STRUCTURE_TYPE_PHYSICAL_DEVICE_FEATURES_2}</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkPhysicalDeviceFeatures}, {@link VK11#vkGetPhysicalDeviceFeatures2 GetPhysicalDeviceFeatures2}, {@link KHRGetPhysicalDeviceProperties2#vkGetPhysicalDeviceFeatures2KHR GetPhysicalDeviceFeatures2KHR}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code features} &ndash; a structure of type {@link VkPhysicalDeviceFeatures} describing the fine-grained features of the Vulkan 1.0 API.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPhysicalDeviceFeatures2 {
 *     VkStructureType sType;
 *     void * pNext;
 *     {@link VkPhysicalDeviceFeatures VkPhysicalDeviceFeatures} features;
 * }</code></pre>
 */
class PhysicalDeviceFeatures2(
        var features: PhysicalDeviceFeatures,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.PHYSICAL_DEVICE_FEATURES_2
}