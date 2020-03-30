package vkk.vk11.structs

import kool.Ptr
import org.lwjgl.system.MemoryUtil.NULL
import vkk.VkStructureType

/**
 * Structure describing protected memory properties that can be supported by an implementation.
 *
 * <h5>Description</h5>
 *
 * <p>If the {@link VkPhysicalDeviceProtectedMemoryProperties} structure is included in the {@code pNext} chain of {@link VkPhysicalDeviceProperties2}, it is filled with a value indicating the implementation-dependent behavior.</p>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_PROTECTED_MEMORY_PROPERTIES STRUCTURE_TYPE_PHYSICAL_DEVICE_PROTECTED_MEMORY_PROPERTIES}</li>
 * </ul>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code protectedNoFault} &ndash; specifies the behavior of the implementation when <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#memory-protected-access-rules">protected memory access rules</a> are broken. If {@code protectedNoFault} is {@link VK10#VK_TRUE TRUE}, breaking those rules will not result in process termination or device loss.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPhysicalDeviceProtectedMemoryProperties {
 *     VkStructureType sType;
 *     void * pNext;
 *     VkBool32 protectedNoFault;
 * }</code></pre>
 */
class PhysicalDeviceProtectedMemoryProperties(
        var protectedNoFault: Boolean,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.PHYSICAL_DEVICE_PROTECTED_MEMORY_PROPERTIES
}