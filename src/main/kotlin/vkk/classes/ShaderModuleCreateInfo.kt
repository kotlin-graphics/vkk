package classes

import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.vulkan.VkShaderModuleCreateInfo
import org.lwjgl.vulkan.VkShaderModuleCreateInfo.*
import vkk.VkShaderModuleCreateFlags
import vkk.VkStructureType
import java.nio.ByteBuffer

/**
 * Structure specifying parameters of a newly created shader module.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code codeSize} <b>must</b> be greater than 0</li>
 * <li>If {@code pCode} points to SPIR-V code, {@code codeSize} <b>must</b> be a multiple of 4</li>
 * <li>{@code pCode} <b>must</b> point to either valid SPIR-V code, formatted and packed as described by the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#spirv-spec">Khronos SPIR-V Specification</a> or valid GLSL code which <b>must</b> be written to the {@code GL_KHR_vulkan_glsl} extension specification</li>
 * <li>If {@code pCode} points to SPIR-V code, that code <b>must</b> adhere to the validation rules described by the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#spirvenv-module-validation">Validation Rules within a Module</a> section of the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#spirvenv-capabilities">SPIR-V Environment</a> appendix</li>
 * <li>If {@code pCode} points to GLSL code, it <b>must</b> be valid GLSL code written to the {@code GL_KHR_vulkan_glsl} GLSL extension specification</li>
 * <li>{@code pCode} <b>must</b> declare the {@code Shader} capability for SPIR-V code</li>
 * <li>{@code pCode} <b>must</b> not declare any capability that is not supported by the API, as described by the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#spirvenv-module-validation">Capabilities</a> section of the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#spirvenv-capabilities">SPIR-V Environment</a> appendix</li>
 * <li>If {@code pCode} declares any of the capabilities listed as optional: in the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#spirvenv-capabilities-table">SPIR-V Environment</a> appendix, the corresponding feature(s) <b>must</b> be enabled.</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK10#VK_STRUCTURE_TYPE_SHADER_MODULE_CREATE_INFO STRUCTURE_TYPE_SHADER_MODULE_CREATE_INFO}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL} or a pointer to a valid instance of {@link VkShaderModuleValidationCacheCreateInfoEXT}</li>
 * <li>{@code flags} <b>must</b> be a valid combination of {@code VkShaderModuleCreateFlagBits} values</li>
 * <li>{@code pCode} <b>must</b> be a valid pointer to an array of {@code codeSize / 4} {@code uint32_t} values</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VK10#vkCreateShaderModule CreateShaderModule}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code flags} &ndash; reserved for future use.</li>
 * <li>{@code codeSize} &ndash; the size, in bytes, of the code pointed to by {@code pCode}.</li>
 * <li>{@code pCode} &ndash; points to code that is used to create the shader module</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkShaderModuleCreateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkShaderModuleCreateFlags flags;
 *     size_t codeSize;
 *     uint32_t const * pCode;
 * }</code></pre>
 */
class ShaderModuleCreateInfo(
    var flags: VkShaderModuleCreateFlags = 0,
    var codeSize: Long,
    var code: ByteBuffer,
    var next: Ptr = NULL
) {

    val type get() = VkStructureType.SHADER_MODULE_CREATE_INFO

    val MemoryStack.native: Ptr
        get() = ncalloc(ALIGNOF, 1, SIZEOF).also {
            nsType(it, type.i)
            npNext(it, next)
            nflags(it, flags)
            ncodeSize(it, codeSize)
            npCode(it, code)
        }
}