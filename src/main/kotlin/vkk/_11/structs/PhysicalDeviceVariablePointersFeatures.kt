package vkk._11.structs

import kool.Ptr
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.NULL
import vkk.VkStructureType

/**
 * Structure describing variable pointers features that can be supported by an implementation.
 *
 * <h5>Description</h5>
 *
 * <p>If the {@link VkPhysicalDeviceVariablePointersFeatures} structure is included in the {@code pNext} chain of {@link VkPhysicalDeviceFeatures2}, it is filled with values indicating whether each feature is supported. {@link VkPhysicalDeviceVariablePointersFeatures} <b>can</b> also be used in the {@code pNext} chain of {@link VkDeviceCreateInfo} to enable the features.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>If {@code variablePointers} is enabled then {@code variablePointersStorageBuffer} <b>must</b> also be enabled.</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_VARIABLE_POINTERS_FEATURES STRUCTURE_TYPE_PHYSICAL_DEVICE_VARIABLE_POINTERS_FEATURES}</li>
 * </ul>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code variablePointersStorageBuffer} &ndash; specifies whether the implementation supports the SPIR-V {@code VariablePointersStorageBuffer} capability. When this feature is not enabled, shader modules <b>must</b> not declare the {@code SPV_KHR_variable_pointers} extension or the {@code VariablePointersStorageBuffer} capability.</li>
 * <li>{@code variablePointers} &ndash; specifies whether the implementation supports the SPIR-V {@code VariablePointers} capability. When this feature is not enabled, shader modules <b>must</b> not declare the {@code VariablePointers} capability.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPhysicalDeviceVariablePointersFeatures {
 *     VkStructureType sType;
 *     void * pNext;
 *     VkBool32 variablePointersStorageBuffer;
 *     VkBool32 variablePointers;
 * }</code></pre>
 */
class PhysicalDeviceVariablePointersFeatures(
        var variablePointersStorageBuffer: Boolean,
        var variablePointers: Boolean,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.PHYSICAL_DEVICE_VARIABLE_POINTERS_FEATURES
}