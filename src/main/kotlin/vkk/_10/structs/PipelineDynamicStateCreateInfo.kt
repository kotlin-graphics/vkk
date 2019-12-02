package vkk._10.structs

import kool.Adr
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.memPutAddress
import org.lwjgl.vulkan.VkPipelineDynamicStateCreateInfo.*
import vkk.VkDynamicState
import vkk.VkStructureType
import vkk.write

/**
 * Structure specifying parameters of a newly created pipeline dynamic state.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>Each element of {@code pDynamicStates} <b>must</b> be unique</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK10#VK_STRUCTURE_TYPE_PIPELINE_DYNAMIC_STATE_CREATE_INFO STRUCTURE_TYPE_PIPELINE_DYNAMIC_STATE_CREATE_INFO}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL}</li>
 * <li>{@code flags} <b>must</b> be 0</li>
 * <li>If {@code dynamicStateCount} is not 0, {@code pDynamicStates} <b>must</b> be a valid pointer to an array of {@code dynamicStateCount} valid {@code VkDynamicState} values</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkGraphicsPipelineCreateInfo}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code flags} &ndash; reserved for future use.</li>
 * <li>{@code dynamicStateCount} &ndash; the number of elements in the {@code pDynamicStates} array.</li>
 * <li>{@code pDynamicStates} &ndash; an array of {@code VkDynamicState} values specifying which pieces of pipeline state will use the values from dynamic state commands rather than from pipeline state creation info.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPipelineDynamicStateCreateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkPipelineDynamicStateCreateFlags flags;
 *     uint32_t dynamicStateCount;
 *     VkDynamicState const * pDynamicStates;
 * }</code></pre>
 */
class PipelineDynamicStateCreateInfo(
        var dynamicStates: Array<VkDynamicState>? = null
) {
    constructor(dynamicState: VkDynamicState) : this(arrayOf(dynamicState))
    constructor(dynamicState0: VkDynamicState, dynamicState1: VkDynamicState) : this(arrayOf(dynamicState0, dynamicState1))

    val type get() = VkStructureType.PIPELINE_DYNAMIC_STATE_CREATE_INFO

    infix fun write(stack: MemoryStack): Adr {
        val adr = stack.ncalloc(ALIGNOF, 1, SIZEOF)
        nsType(adr, type.i)
        dynamicStates?.let {
            ndynamicStateCount(adr, it.size)
            memPutAddress(adr + PDYNAMICSTATES, it.write(stack))
        }
        return adr
    }
}