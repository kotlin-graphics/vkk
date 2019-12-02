package vkk._11.structs

import kool.Ptr
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.NULL
import vkk.VkStructureType
import vkk.VkTessellationDomainOrigin

/**
 * Structure specifying the orientation of the tessellation domain.
 *
 * <h5>Description</h5>
 *
 * <p>If the {@link VkPipelineTessellationDomainOriginStateCreateInfo} structure is included in the {@code pNext} chain of {@link VkPipelineTessellationStateCreateInfo}, it controls the origin of the tessellation domain. If this structure is not present, it is as if {@code domainOrigin} were {@link VK11#VK_TESSELLATION_DOMAIN_ORIGIN_UPPER_LEFT TESSELLATION_DOMAIN_ORIGIN_UPPER_LEFT}.</p>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_PIPELINE_TESSELLATION_DOMAIN_ORIGIN_STATE_CREATE_INFO STRUCTURE_TYPE_PIPELINE_TESSELLATION_DOMAIN_ORIGIN_STATE_CREATE_INFO}</li>
 * <li>{@code domainOrigin} <b>must</b> be a valid {@code VkTessellationDomainOrigin} value</li>
 * </ul>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code domainOrigin} &ndash; controls the origin of the tessellation domain space, and is of type {@code VkTessellationDomainOrigin}.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPipelineTessellationDomainOriginStateCreateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkTessellationDomainOrigin domainOrigin;
 * }</code></pre>
 */
class PipelineTessellationDomainOriginStateCreateInfo(
    var domainOrigin: VkTessellationDomainOrigin,
    var next: Ptr = NULL
) {

    val type get() = VkStructureType.PIPELINE_TESSELLATION_DOMAIN_ORIGIN_STATE_CREATE_INFO
}