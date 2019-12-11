package vkk._11.structs

import kool.Ptr
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.NULL
import vkk.VkStructureType

/**
 * Structure describing protected memory features that can be supported by an implementation.
 *
 * <h5>Description</h5>
 *
 * <p>If the {@link VkPhysicalDeviceProtectedMemoryFeatures} structure is included in the {@code pNext} chain of {@link VkPhysicalDeviceFeatures2}, it is filled with a value indicating whether the feature is supported.</p>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_PROTECTED_MEMORY_FEATURES STRUCTURE_TYPE_PHYSICAL_DEVICE_PROTECTED_MEMORY_FEATURES}</li>
 * </ul>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code protectedMemory} &ndash; specifies whether protected memory is supported.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPhysicalDeviceProtectedMemoryFeatures {
 *     VkStructureType sType;
 *     void * pNext;
 *     VkBool32 protectedMemory;
 * }</code></pre>
 */
class PhysicalDeviceProtectedMemoryFeatures(
    var protectedMemory: Boolean,
    var next: Ptr = NULL
) {

    val type get() = VkStructureType.PHYSICAL_DEVICE_PROTECTED_MEMORY_FEATURES
}