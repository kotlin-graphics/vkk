package vkk._11.structs

import vkk.identifiers.PhysicalDevice
import kool.Ptr
import org.lwjgl.system.MemoryUtil.NULL
import vkk.VkStructureType

/**
 * Create a logical device from multiple physical devices.
 *
 * <h5>Description</h5>
 *
 * <p>The elements of the {@code pPhysicalDevices} array are an ordered list of the physical devices that the logical device represents. These <b>must</b> be a subset of a single device group, and need not be in the same order as they were enumerated. The order of the physical devices in the {@code pPhysicalDevices} array determines the <em>device index</em> of each physical device, with element <code>i</code> being assigned a device index of <code>i</code>. Certain commands and structures refer to one or more physical devices by using device indices or <em>device masks</em> formed using device indices.</p>
 *
 * <p>A logical device created without using {@link VkDeviceGroupDeviceCreateInfo}, or with {@code physicalDeviceCount} equal to zero, is equivalent to a {@code physicalDeviceCount} of one and {@code pPhysicalDevices} pointing to the {@code physicalDevice} parameter to {@link VK10#vkCreateDevice CreateDevice}. In particular, the device index of that physical device is zero.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>Each element of {@code pPhysicalDevices} <b>must</b> be unique</li>
 * <li>All elements of {@code pPhysicalDevices} <b>must</b> be in the same device group as enumerated by {@link VK11#vkEnumeratePhysicalDeviceGroups EnumeratePhysicalDeviceGroups}</li>
 * <li>If {@code physicalDeviceCount} is not 0, the {@code physicalDevice} parameter of {@link VK10#vkCreateDevice CreateDevice} <b>must</b> be an element of {@code pPhysicalDevices}.</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_DEVICE_GROUP_DEVICE_CREATE_INFO STRUCTURE_TYPE_DEVICE_GROUP_DEVICE_CREATE_INFO}</li>
 * <li>If {@code physicalDeviceCount} is not 0, {@code pPhysicalDevices} <b>must</b> be a valid pointer to an array of {@code physicalDeviceCount} valid {@code VkPhysicalDevice} handles</li>
 * </ul>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code physicalDeviceCount} &ndash; the number of elements in the {@code pPhysicalDevices} array.</li>
 * <li>{@code pPhysicalDevices} &ndash; an array of physical device handles belonging to the same device group.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkDeviceGroupDeviceCreateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     uint32_t physicalDeviceCount;
 *     VkPhysicalDevice const * pPhysicalDevices;
 * }</code></pre>
 */
class DeviceGroupDeviceCreateInfo(
        var physicalDevices: Array<PhysicalDevice>? = null,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.DEVICE_GROUP_DEVICE_CREATE_INFO
}