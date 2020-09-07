package vkk.vk11.structs

import kool.Adr
import kool.BytePtr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkExternalFenceProperties.*
import vkk.VkExternalFenceFeatureFlags
import vkk.VkExternalFenceHandleTypeFlags
import vkk.VkStructureType
import vkk.invoke

/**
 * Structure describing supported external fence handle features.
 *
 * <h5>Description</h5>
 *
 * <p>If {@code handleType} is not supported by the implementation, then {@link VkExternalFenceProperties}{@code ::externalFenceFeatures} will be set to zero.</p>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_EXTERNAL_FENCE_PROPERTIES STRUCTURE_TYPE_EXTERNAL_FENCE_PROPERTIES}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL}</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VK11#vkGetPhysicalDeviceExternalFenceProperties GetPhysicalDeviceExternalFenceProperties}, {@link KHRExternalFenceCapabilities#vkGetPhysicalDeviceExternalFencePropertiesKHR GetPhysicalDeviceExternalFencePropertiesKHR}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code exportFromImportedHandleTypes} &ndash; a bitmask of {@code VkExternalFenceHandleTypeFlagBits} indicating which types of imported handle {@code handleType} <b>can</b> be exported from.</li>
 * <li>{@code compatibleHandleTypes} &ndash; a bitmask of {@code VkExternalFenceHandleTypeFlagBits} specifying handle types which <b>can</b> be specified at the same time as {@code handleType} when creating a fence.</li>
 * <li>{@code externalFenceFeatures} &ndash; a bitmask of {@code VkExternalFenceFeatureFlagBits} indicating the features of {@code handleType}.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkExternalFenceProperties {
 *     VkStructureType sType;
 *     void * pNext;
 *     VkExternalFenceHandleTypeFlags exportFromImportedHandleTypes;
 *     VkExternalFenceHandleTypeFlags compatibleHandleTypes;
 *     VkExternalFenceFeatureFlags externalFenceFeatures;
 * }</code></pre>
 */
class ExternalFenceProperties(
        var exportFromImportedHandleTypes: VkExternalFenceHandleTypeFlags,
        var compatibleHandleTypes: VkExternalFenceHandleTypeFlags,
        var externalFenceFeatures: VkExternalFenceFeatureFlags
) {

    val type get() = VkStructureType.EXTERNAL_FENCE_PROPERTIES

    constructor(ptr: BytePtr) : this(
            nexportFromImportedHandleTypes(ptr.adr),
            ncompatibleHandleTypes(ptr.adr),
            nexternalFenceFeatures(ptr.adr)
    )

    companion object {
//        inline infix fun <R> read(block: (Adr) -> R): ExternalFenceProperties = stak { read(it, block) }
        inline fun <R> read(stack: MemoryStack, block: (Adr) -> R): ExternalFenceProperties = stack {
            val adr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
            block(adr)
            ExternalFenceProperties(BytePtr(adr))
        }
    }
}