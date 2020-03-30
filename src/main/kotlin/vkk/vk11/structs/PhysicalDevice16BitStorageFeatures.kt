package vkk.vk11.structs

import kool.Ptr
import org.lwjgl.system.MemoryUtil.NULL
import vkk.VkStructureType

/**
 * Structure describing features supported by VK_KHR_16bit_storage.
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_16BIT_STORAGE_FEATURES STRUCTURE_TYPE_PHYSICAL_DEVICE_16BIT_STORAGE_FEATURES}</li>
 * </ul>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code storageBuffer16BitAccess} &ndash; specifies whether objects in the {@code StorageBuffer} or {@code PhysicalStorageBufferEXT} storage class with the {@code Block} decoration <b>can</b> have 16-bit integer and 16-bit floating-point members. If this feature is not enabled, 16-bit integer or 16-bit floating-point members <b>must</b> not be used in such objects. This also specifies whether shader modules <b>can</b> declare the {@code StorageBuffer16BitAccess} capability.</li>
 * <li>{@code uniformAndStorageBuffer16BitAccess} &ndash; specifies whether objects in the {@code Uniform} storage class with the {@code Block} decoration and in the {@code StorageBuffer} or {@code PhysicalStorageBufferEXT} storage class with the same decoration <b>can</b> have 16-bit integer and 16-bit floating-point members. If this feature is not enabled, 16-bit integer or 16-bit floating-point members <b>must</b> not be used in such objects. This also specifies whether shader modules <b>can</b> declare the {@code UniformAndStorageBuffer16BitAccess} capability.</li>
 * <li>{@code storagePushConstant16} &ndash; specifies whether objects in the {@code PushConstant} storage class <b>can</b> have 16-bit integer and 16-bit floating-point members. If this feature is not enabled, 16-bit integer or floating-point members <b>must</b> not be used in such objects. This also specifies whether shader modules <b>can</b> declare the {@code StoragePushConstant16} capability.</li>
 * <li>{@code storageInputOutput16} &ndash; specifies whether objects in the {@code Input} and {@code Output} storage classes <b>can</b> have 16-bit integer and 16-bit floating-point members. If this feature is not enabled, 16-bit integer or 16-bit floating-point members <b>must</b> not be used in such objects. This also specifies whether shader modules <b>can</b> declare the {@code StorageInputOutput16} capability.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPhysicalDevice16BitStorageFeatures {
 *     VkStructureType sType;
 *     void * pNext;
 *     VkBool32 storageBuffer16BitAccess;
 *     VkBool32 uniformAndStorageBuffer16BitAccess;
 *     VkBool32 storagePushConstant16;
 *     VkBool32 storageInputOutput16;
 * }</code></pre>
 */
class PhysicalDevice16BitStorageFeatures(
        var storageBuffer16BitAccess: Boolean,
        var uniformAndStorageBuffer16BitAccess: Boolean,
        var storagePushConstant16: Boolean,
        var storageInputOutput16: Boolean,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.PHYSICAL_DEVICE_16BIT_STORAGE_FEATURES
}