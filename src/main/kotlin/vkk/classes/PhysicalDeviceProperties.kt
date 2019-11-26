package classes

import vkk.VkPhysicalDeviceType

/**
 * Structure specifying physical device properties.
 *
 * <h5>Description</h5>
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>The value of {@code apiVersion} <b>may</b> be different than the version returned by {@link VK11#vkEnumerateInstanceVersion EnumerateInstanceVersion}; either higher or lower. In such cases, the application <b>must</b> not use functionality that exceeds the version of Vulkan associated with a given object. The {@code pApiVersion} parameter returned by {@link VK11#vkEnumerateInstanceVersion EnumerateInstanceVersion} is the version associated with a {@code VkInstance} and its children, except for a {@code VkPhysicalDevice} and its children. {@link VkPhysicalDeviceProperties}{@code ::apiVersion} is the version associated with a {@code VkPhysicalDevice} and its children.</p>
 * </div>
 *
 * <p>The {@code vendorID} and {@code deviceID} fields are provided to allow applications to adapt to device characteristics that are not adequately exposed by other Vulkan queries.</p>
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>These <b>may</b> include performance profiles, hardware errata, or other characteristics.</p>
 * </div>
 *
 * <p>The <em>vendor</em> identified by {@code vendorID} is the entity responsible for the most salient characteristics of the underlying implementation of the {@code VkPhysicalDevice} being queried.</p>
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>For example, in the case of a discrete GPU implementation, this <b>should</b> be the GPU chipset vendor. In the case of a hardware accelerator integrated into a system-on-chip (SoC), this <b>should</b> be the supplier of the silicon IP used to create the accelerator.</p>
 * </div>
 *
 * <p>If the vendor has a <a target="_blank" href="https://pcisig.com/membership/member-companies">PCI vendor ID</a>, the low 16 bits of {@code vendorID} <b>must</b> contain that PCI vendor ID, and the remaining bits <b>must</b> be set to zero. Otherwise, the value returned <b>must</b> be a valid Khronos vendor ID, obtained as described in the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#vulkan-styleguide">Vulkan Documentation and Extensions: Procedures and Conventions</a> document in the section "{@code Registering a Vendor ID with Khronos}". Khronos vendor IDs are allocated starting at 0x10000, to distinguish them from the PCI vendor ID namespace. Khronos vendor IDs are symbolically defined in the {@code VkVendorId} type.</p>
 *
 * <p>The vendor is also responsible for the value returned in {@code deviceID}. If the implementation is driven primarily by a <a target="_blank" href="https://pcisig.com/">PCI device</a> with a <a target="_blank" href="https://pcisig.com/">PCI device ID</a>, the low 16 bits of {@code deviceID} <b>must</b> contain that PCI device ID, and the remaining bits <b>must</b> be set to zero. Otherwise, the choice of what values to return <b>may</b> be dictated by operating system or platform policies - but <b>should</b> uniquely identify both the device version and any major configuration options (for example, core count in the case of multicore devices).</p>
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>The same device ID <b>should</b> be used for all physical implementations of that device version and configuration. For example, all uses of a specific silicon IP GPU version and configuration <b>should</b> use the same device ID, even if those uses occur in different SoCs.</p>
 * </div>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkPhysicalDeviceLimits}, {@link VkPhysicalDeviceProperties2}, {@link VkPhysicalDeviceSparseProperties}, {@link VK10#vkGetPhysicalDeviceProperties GetPhysicalDeviceProperties}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code apiVersion} &ndash; the version of Vulkan supported by the device, encoded as described in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#extendingvulkan-coreversions-versionnumbers">Version Numbers</a>.</li>
 * <li>{@code driverVersion} &ndash; the vendor-specified version of the driver.</li>
 * <li>{@code vendorID} &ndash; a unique identifier for the <em>vendor</em> (see below) of the physical device.</li>
 * <li>{@code deviceID} &ndash; a unique identifier for the physical device among devices available from the vendor.</li>
 * <li>{@code deviceType} &ndash; a {@code VkPhysicalDeviceType} specifying the type of device.</li>
 * <li>{@code deviceName[VK_MAX_PHYSICAL_DEVICE_NAME_SIZE]} &ndash; a null-terminated UTF-8 string containing the name of the device.</li>
 * <li>{@code pipelineCacheUUID[VK_UUID_SIZE]} &ndash; an array of size {@link VK10#VK_UUID_SIZE UUID_SIZE}, containing 8-bit values that represent a universally unique identifier for the device.</li>
 * <li>{@code limits} &ndash; the {@link VkPhysicalDeviceLimits} structure which specifies device-specific limits of the physical device. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#limits">Limits</a> for details.</li>
 * <li>{@code sparseProperties} &ndash; the {@link VkPhysicalDeviceSparseProperties} structure which specifies various sparse related properties of the physical device. See <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#sparsememory-physicalprops">Sparse Properties</a> for details.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPhysicalDeviceProperties {
 *     uint32_t apiVersion;
 *     uint32_t driverVersion;
 *     uint32_t vendorID;
 *     uint32_t deviceID;
 *     VkPhysicalDeviceType deviceType;
 *     char deviceName[VK_MAX_PHYSICAL_DEVICE_NAME_SIZE];
 *     uint8_t pipelineCacheUUID[VK_UUID_SIZE];
 *     {@link VkPhysicalDeviceLimits VkPhysicalDeviceLimits} limits;
 *     {@link VkPhysicalDeviceSparseProperties VkPhysicalDeviceSparseProperties} sparseProperties;
 * }</code></pre>
 */
class PhysicalDeviceProperties(
    var apiVersion: Int,
    var driverVersion: Int,
    var vendorID: Int,
    var deviceID: Int,
    var deviceType: VkPhysicalDeviceType,
    var deviceName: String,
    var pipelineCacheUUID: ByteArray,
    var limits: PhysicalDeviceLimits,
    var sparseProperties: PhysicalDeviceSparseProperties
) {

}