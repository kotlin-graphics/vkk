package vkk._11.structs

import vkk.VkStructureType

/**
 * Structure specifying supported external handle capabilities.
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_EXTERNAL_BUFFER_PROPERTIES STRUCTURE_TYPE_EXTERNAL_BUFFER_PROPERTIES}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL}</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkExternalMemoryProperties}, {@link VK11#vkGetPhysicalDeviceExternalBufferProperties GetPhysicalDeviceExternalBufferProperties}, {@link KHRExternalMemoryCapabilities#vkGetPhysicalDeviceExternalBufferPropertiesKHR GetPhysicalDeviceExternalBufferPropertiesKHR}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure</li>
 * <li>{@code pNext} &ndash; NULL or a pointer to an extension-specific structure.</li>
 * <li>{@code externalMemoryProperties} &ndash; an instance of the {@link VkExternalMemoryProperties} structure specifying various capabilities of the external handle type when used with the specified buffer creation parameters.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkExternalBufferProperties {
 *     VkStructureType sType;
 *     void * pNext;
 *     {@link VkExternalMemoryProperties VkExternalMemoryProperties} externalMemoryProperties;
 * }</code></pre>
 */
class ExternalBufferProperties(
        var externalMemoryProperties: ExternalMemoryProperties
) {

    val type get() = VkStructureType.EXTERNAL_BUFFER_PROPERTIES
}