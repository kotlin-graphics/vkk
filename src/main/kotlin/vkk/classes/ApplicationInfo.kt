package vkk.classes

import kool.Ptr
import kool.utf8Adr
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.memPutAddress
import org.lwjgl.vulkan.VkApplicationInfo.*
import vkk.VkStructureType

/**
 * Structure specifying application info.
 *
 * <h5>Description</h5>
 *
 * <p>Vulkan 1.0 implementations were required to return {@link VK10#VK_ERROR_INCOMPATIBLE_DRIVER ERROR_INCOMPATIBLE_DRIVER} if {@code apiVersion} was larger than 1.0. Implementations that support Vulkan 1.1 or later <b>must</b> not return {@link VK10#VK_ERROR_INCOMPATIBLE_DRIVER ERROR_INCOMPATIBLE_DRIVER} for any value of {@code apiVersion}.</p>
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>Because Vulkan 1.0 implementations <b>may</b> fail with {@link VK10#VK_ERROR_INCOMPATIBLE_DRIVER ERROR_INCOMPATIBLE_DRIVER}, applications <b>should</b> determine the version of Vulkan available before calling {@link VK10#vkCreateInstance CreateInstance}. If the {@link VK10#vkGetInstanceProcAddr GetInstanceProcAddr} returns {@code NULL} for {@link VK11#vkEnumerateInstanceVersion EnumerateInstanceVersion}, it is a Vulkan 1.0 implementation. Otherwise, the application <b>can</b> call {@link VK11#vkEnumerateInstanceVersion EnumerateInstanceVersion} to determine the version of Vulkan.</p>
 * </div>
 *
 * <p>As long as the instance supports at least Vulkan 1.1, an application <b>can</b> use different versions of Vulkan with an instance than it does with a device or physical device.</p>
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>The Khronos validation layers will treat {@code apiVersion} as the highest API version the application targets, and will validate API usage against the minimum of that version and the implementation version (instance or device, depending on context). If an application tries to use functionality from a greater version than this, a validation error will be triggered.</p>
 *
 * <p>For example, if the instance supports Vulkan 1.1 and three physical devices support Vulkan 1.0, Vulkan 1.1, and a hypothetical Vulkan 1.2, respectively, and if the application sets {@code apiVersion} to 1.2, the application <b>can</b> use the following versions of Vulkan:</p>
 *
 * <ul>
 * <li>Vulkan 1.0 <b>can</b> be used with the instance and with all physical devices.</li>
 * <li>Vulkan 1.1 <b>can</b> be used with the instance and with the physical devices that support Vulkan 1.1 and Vulkan 1.2.</li>
 * <li>Vulkan 1.2 <b>can</b> be used with the physical device that supports Vulkan 1.2.</li>
 * </ul>
 *
 * <p>If we modify the above example so that the application sets {@code apiVersion} to 1.1, then the application <b>must</b> not use Vulkan 1.2 functionality on the physical device that supports Vulkan 1.2.</p>
 * </div>
 *
 * <p>Implicit layers <b>must</b> be disabled if they do not support a version at least as high as {@code apiVersion}. See the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#LoaderAndLayerInterface">Vulkan Loader Specification and Architecture Overview</a> document for additional information.</p>
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>Providing a {@code NULL} {@link VkInstanceCreateInfo}{@code ::pApplicationInfo} or providing an {@code apiVersion} of 0 is equivalent to providing an {@code apiVersion} of {@code VK_MAKE_VERSION(1,0,0)}.</p>
 * </div>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK10#VK_STRUCTURE_TYPE_APPLICATION_INFO STRUCTURE_TYPE_APPLICATION_INFO}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL}</li>
 * <li>If {@code pApplicationName} is not {@code NULL}, {@code pApplicationName} <b>must</b> be a null-terminated UTF-8 string</li>
 * <li>If {@code pEngineName} is not {@code NULL}, {@code pEngineName} <b>must</b> be a null-terminated UTF-8 string</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkInstanceCreateInfo}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code pApplicationName} &ndash; {@code NULL} or is a pointer to a null-terminated UTF-8 string containing the name of the application.</li>
 * <li>{@code applicationVersion} &ndash; an unsigned integer variable containing the developer-supplied version number of the application.</li>
 * <li>{@code pEngineName} &ndash; {@code NULL} or is a pointer to a null-terminated UTF-8 string containing the name of the engine (if any) used to create the application.</li>
 * <li>{@code engineVersion} &ndash; an unsigned integer variable containing the developer-supplied version number of the engine used to create the application.</li>
 * <li>{@code apiVersion} &ndash; <b>must</b> be the highest version of Vulkan that the application is designed to use, encoded as described in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#extendingvulkan-coreversions-versionnumbers">Version Numbers</a>. The patch version number specified in {@code apiVersion} is ignored when creating an instance object. Only the major and minor versions of the instance <b>must</b> match those requested in {@code apiVersion}.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkApplicationInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     char const * pApplicationName;
 *     uint32_t applicationVersion;
 *     char const * pEngineName;
 *     uint32_t engineVersion;
 *     uint32_t apiVersion;
 * }</code></pre>
 */
class ApplicationInfo(
        var applicationName: String? = null,
        var applicationVersion: Int = 0,
        var engineName: String? = null,
        var engineVersion: Int = 0,
        var apiVersion: Int = 0
) {

    val type get() = VkStructureType.APPLICATION_INFO

    infix fun write(stack: MemoryStack): Ptr {
        val ptr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
        nsType(ptr, type.i)
        applicationName?.let { memPutAddress(ptr + PAPPLICATIONNAME, stack.utf8Adr(it)) }
        napplicationVersion(ptr, applicationVersion)
        engineName?.let { memPutAddress(ptr + PENGINENAME, stack.utf8Adr(it)) }
        nengineVersion(ptr, engineVersion)
        napiVersion(ptr, apiVersion)
        return ptr
    }
}