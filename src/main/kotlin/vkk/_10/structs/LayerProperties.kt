package vkk._10.structs

import kool.BytePtr
import org.lwjgl.vulkan.VkLayerProperties.*

/**
 * Structure specifying layer properties.
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code layerName[VK_MAX_EXTENSION_NAME_SIZE]} &ndash; a null-terminated UTF-8 string specifying the name of the layer. Use this name in the {@code ppEnabledLayerNames} array passed in the {@link VkInstanceCreateInfo} structure to enable this layer for an instance.</li>
 * <li>{@code specVersion} &ndash; the Vulkan version the layer was written to, encoded as described in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#extendingvulkan-coreversions-versionnumbers">Version Numbers</a>.</li>
 * <li>{@code implementationVersion} &ndash; the version of this layer. It is an integer, increasing with backward compatible changes.</li>
 * <li>{@code description[VK_MAX_DESCRIPTION_SIZE]} &ndash; a null-terminated UTF-8 string providing additional details that <b>can</b> be used by the application to identify the layer.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkLayerProperties {
 *     char layerName[VK_MAX_EXTENSION_NAME_SIZE];
 *     uint32_t specVersion;
 *     uint32_t implementationVersion;
 *     char description[VK_MAX_DESCRIPTION_SIZE];
 * }</code></pre>
 */
class LayerProperties(
        var layerName: String,
        var specVersion: Int,
        var implementationVersion: Int,
        var description: String
) {

    constructor(ptr: BytePtr) : this(
            nlayerNameString(ptr.adr),
            nspecVersion(ptr.adr),
            nimplementationVersion(ptr.adr),
            ndescriptionString(ptr.adr))
}