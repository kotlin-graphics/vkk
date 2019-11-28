package vkk.classes

/**
 * Structure specifying an extension properties.
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code extensionName[VK_MAX_EXTENSION_NAME_SIZE]} &ndash; a null-terminated string specifying the name of the extension.</li>
 * <li>{@code specVersion} &ndash; the version of this extension. It is an integer, incremented with backward compatible changes.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkExtensionProperties {
 *     char extensionName[VK_MAX_EXTENSION_NAME_SIZE];
 *     uint32_t specVersion;
 * }</code></pre>
 */
class ExtensionProperties(
    var extensionName: String,
    var specVersion: Int
)