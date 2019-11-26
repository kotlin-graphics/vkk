package classes

import kool.Ptr
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VkMemoryHeap
import org.lwjgl.vulkan.VkMemoryRequirements
import org.lwjgl.vulkan.VkMemoryType
import org.lwjgl.vulkan.VkPhysicalDeviceMemoryProperties.*
import vkk.entities.VkDeviceSize

/**
 * Structure specifying physical device memory properties.
 *
 * <h5>Description</h5>
 *
 * <p>The {@link VkPhysicalDeviceMemoryProperties} structure describes a number of <em>memory heaps</em> as well as a number of <em>memory types</em> that <b>can</b> be used to access memory allocated in those heaps. Each heap describes a memory resource of a particular size, and each memory type describes a set of memory properties (e.g. host cached vs uncached) that <b>can</b> be used with a given memory heap. Allocations using a particular memory type will consume resources from the heap indicated by that memory type's heap index. More than one memory type <b>may</b> share each heap, and the heaps and memory types provide a mechanism to advertise an accurate size of the physical memory resources while allowing the memory to be used with a variety of different properties.</p>
 *
 * <p>The number of memory heaps is given by {@code memoryHeapCount} and is less than or equal to {@link VK10#VK_MAX_MEMORY_HEAPS MAX_MEMORY_HEAPS}. Each heap is described by an element of the {@code memoryHeaps} array as a {@link VkMemoryHeap} structure. The number of memory types available across all memory heaps is given by {@code memoryTypeCount} and is less than or equal to {@link VK10#VK_MAX_MEMORY_TYPES MAX_MEMORY_TYPES}. Each memory type is described by an element of the {@code memoryTypes} array as a {@link VkMemoryType} structure.</p>
 *
 * <p>At least one heap <b>must</b> include {@link VK10#VK_MEMORY_HEAP_DEVICE_LOCAL_BIT MEMORY_HEAP_DEVICE_LOCAL_BIT} in {@link VkMemoryHeap}{@code ::flags}. If there are multiple heaps that all have similar performance characteristics, they <b>may</b> all include {@link VK10#VK_MEMORY_HEAP_DEVICE_LOCAL_BIT MEMORY_HEAP_DEVICE_LOCAL_BIT}. In a unified memory architecture (UMA) system there is often only a single memory heap which is considered to be equally "{@code local}" to the host and to the device, and such an implementation <b>must</b> advertise the heap as device-local.</p>
 *
 * <p>Each memory type returned by {@link VK10#vkGetPhysicalDeviceMemoryProperties GetPhysicalDeviceMemoryProperties} <b>must</b> have its {@code propertyFlags} set to one of the following values:</p>
 *
 * <ul>
 * <li>0</li>
 * <li>{@link VK10#VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT MEMORY_PROPERTY_HOST_VISIBLE_BIT} | {@link VK10#VK_MEMORY_PROPERTY_HOST_COHERENT_BIT MEMORY_PROPERTY_HOST_COHERENT_BIT}</li>
 * <li>{@link VK10#VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT MEMORY_PROPERTY_HOST_VISIBLE_BIT} | {@link VK10#VK_MEMORY_PROPERTY_HOST_CACHED_BIT MEMORY_PROPERTY_HOST_CACHED_BIT}</li>
 * <li>{@link VK10#VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT MEMORY_PROPERTY_HOST_VISIBLE_BIT} | {@link VK10#VK_MEMORY_PROPERTY_HOST_CACHED_BIT MEMORY_PROPERTY_HOST_CACHED_BIT} | {@link VK10#VK_MEMORY_PROPERTY_HOST_COHERENT_BIT MEMORY_PROPERTY_HOST_COHERENT_BIT}</li>
 * <li>{@link VK10#VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT MEMORY_PROPERTY_DEVICE_LOCAL_BIT}</li>
 * <li>{@link VK10#VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT MEMORY_PROPERTY_DEVICE_LOCAL_BIT} | {@link VK10#VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT MEMORY_PROPERTY_HOST_VISIBLE_BIT} | {@link VK10#VK_MEMORY_PROPERTY_HOST_COHERENT_BIT MEMORY_PROPERTY_HOST_COHERENT_BIT}</li>
 * <li>{@link VK10#VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT MEMORY_PROPERTY_DEVICE_LOCAL_BIT} | {@link VK10#VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT MEMORY_PROPERTY_HOST_VISIBLE_BIT} | {@link VK10#VK_MEMORY_PROPERTY_HOST_CACHED_BIT MEMORY_PROPERTY_HOST_CACHED_BIT}</li>
 * <li>{@link VK10#VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT MEMORY_PROPERTY_DEVICE_LOCAL_BIT} | {@link VK10#VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT MEMORY_PROPERTY_HOST_VISIBLE_BIT} | {@link VK10#VK_MEMORY_PROPERTY_HOST_CACHED_BIT MEMORY_PROPERTY_HOST_CACHED_BIT} | {@link VK10#VK_MEMORY_PROPERTY_HOST_COHERENT_BIT MEMORY_PROPERTY_HOST_COHERENT_BIT}</li>
 * <li>{@link VK10#VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT MEMORY_PROPERTY_DEVICE_LOCAL_BIT} | {@link VK10#VK_MEMORY_PROPERTY_LAZILY_ALLOCATED_BIT MEMORY_PROPERTY_LAZILY_ALLOCATED_BIT}</li>
 * <li>{@link VK11#VK_MEMORY_PROPERTY_PROTECTED_BIT MEMORY_PROPERTY_PROTECTED_BIT}</li>
 * <li>{@link VK11#VK_MEMORY_PROPERTY_PROTECTED_BIT MEMORY_PROPERTY_PROTECTED_BIT} | {@link VK10#VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT MEMORY_PROPERTY_DEVICE_LOCAL_BIT}</li>
 * <li>{@link VK10#VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT MEMORY_PROPERTY_HOST_VISIBLE_BIT} | {@link VK10#VK_MEMORY_PROPERTY_HOST_COHERENT_BIT MEMORY_PROPERTY_HOST_COHERENT_BIT} | {@link AMDDeviceCoherentMemory#VK_MEMORY_PROPERTY_DEVICE_COHERENT_BIT_AMD MEMORY_PROPERTY_DEVICE_COHERENT_BIT_AMD}</li>
 * <li>{@link VK10#VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT MEMORY_PROPERTY_HOST_VISIBLE_BIT} | {@link VK10#VK_MEMORY_PROPERTY_HOST_CACHED_BIT MEMORY_PROPERTY_HOST_CACHED_BIT} | {@link VK10#VK_MEMORY_PROPERTY_HOST_COHERENT_BIT MEMORY_PROPERTY_HOST_COHERENT_BIT} | {@link AMDDeviceCoherentMemory#VK_MEMORY_PROPERTY_DEVICE_COHERENT_BIT_AMD MEMORY_PROPERTY_DEVICE_COHERENT_BIT_AMD}</li>
 * <li>{@link VK10#VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT MEMORY_PROPERTY_DEVICE_LOCAL_BIT} | {@link AMDDeviceCoherentMemory#VK_MEMORY_PROPERTY_DEVICE_COHERENT_BIT_AMD MEMORY_PROPERTY_DEVICE_COHERENT_BIT_AMD}</li>
 * <li>{@link VK10#VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT MEMORY_PROPERTY_DEVICE_LOCAL_BIT} | {@link VK10#VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT MEMORY_PROPERTY_HOST_VISIBLE_BIT} | {@link VK10#VK_MEMORY_PROPERTY_HOST_COHERENT_BIT MEMORY_PROPERTY_HOST_COHERENT_BIT} | {@link AMDDeviceCoherentMemory#VK_MEMORY_PROPERTY_DEVICE_COHERENT_BIT_AMD MEMORY_PROPERTY_DEVICE_COHERENT_BIT_AMD}</li>
 * <li>{@link VK10#VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT MEMORY_PROPERTY_DEVICE_LOCAL_BIT} | {@link VK10#VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT MEMORY_PROPERTY_HOST_VISIBLE_BIT} | {@link VK10#VK_MEMORY_PROPERTY_HOST_CACHED_BIT MEMORY_PROPERTY_HOST_CACHED_BIT} | {@link VK10#VK_MEMORY_PROPERTY_HOST_COHERENT_BIT MEMORY_PROPERTY_HOST_COHERENT_BIT} | {@link AMDDeviceCoherentMemory#VK_MEMORY_PROPERTY_DEVICE_COHERENT_BIT_AMD MEMORY_PROPERTY_DEVICE_COHERENT_BIT_AMD}</li>
 * <li>{@link VK10#VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT MEMORY_PROPERTY_HOST_VISIBLE_BIT} | {@link VK10#VK_MEMORY_PROPERTY_HOST_COHERENT_BIT MEMORY_PROPERTY_HOST_COHERENT_BIT} | {@link AMDDeviceCoherentMemory#VK_MEMORY_PROPERTY_DEVICE_COHERENT_BIT_AMD MEMORY_PROPERTY_DEVICE_COHERENT_BIT_AMD} | {@link AMDDeviceCoherentMemory#VK_MEMORY_PROPERTY_DEVICE_UNCACHED_BIT_AMD MEMORY_PROPERTY_DEVICE_UNCACHED_BIT_AMD}</li>
 * <li>{@link VK10#VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT MEMORY_PROPERTY_HOST_VISIBLE_BIT} | {@link VK10#VK_MEMORY_PROPERTY_HOST_CACHED_BIT MEMORY_PROPERTY_HOST_CACHED_BIT} | {@link VK10#VK_MEMORY_PROPERTY_HOST_COHERENT_BIT MEMORY_PROPERTY_HOST_COHERENT_BIT} | {@link AMDDeviceCoherentMemory#VK_MEMORY_PROPERTY_DEVICE_COHERENT_BIT_AMD MEMORY_PROPERTY_DEVICE_COHERENT_BIT_AMD} | {@link AMDDeviceCoherentMemory#VK_MEMORY_PROPERTY_DEVICE_UNCACHED_BIT_AMD MEMORY_PROPERTY_DEVICE_UNCACHED_BIT_AMD}</li>
 * <li>{@link VK10#VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT MEMORY_PROPERTY_DEVICE_LOCAL_BIT} | {@link AMDDeviceCoherentMemory#VK_MEMORY_PROPERTY_DEVICE_COHERENT_BIT_AMD MEMORY_PROPERTY_DEVICE_COHERENT_BIT_AMD} | {@link AMDDeviceCoherentMemory#VK_MEMORY_PROPERTY_DEVICE_UNCACHED_BIT_AMD MEMORY_PROPERTY_DEVICE_UNCACHED_BIT_AMD}</li>
 * <li>{@link VK10#VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT MEMORY_PROPERTY_DEVICE_LOCAL_BIT} | {@link VK10#VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT MEMORY_PROPERTY_HOST_VISIBLE_BIT} | {@link VK10#VK_MEMORY_PROPERTY_HOST_COHERENT_BIT MEMORY_PROPERTY_HOST_COHERENT_BIT} | {@link AMDDeviceCoherentMemory#VK_MEMORY_PROPERTY_DEVICE_COHERENT_BIT_AMD MEMORY_PROPERTY_DEVICE_COHERENT_BIT_AMD} | {@link AMDDeviceCoherentMemory#VK_MEMORY_PROPERTY_DEVICE_UNCACHED_BIT_AMD MEMORY_PROPERTY_DEVICE_UNCACHED_BIT_AMD}</li>
 * <li>{@link VK10#VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT MEMORY_PROPERTY_DEVICE_LOCAL_BIT} | {@link VK10#VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT MEMORY_PROPERTY_HOST_VISIBLE_BIT} | {@link VK10#VK_MEMORY_PROPERTY_HOST_CACHED_BIT MEMORY_PROPERTY_HOST_CACHED_BIT} | {@link VK10#VK_MEMORY_PROPERTY_HOST_COHERENT_BIT MEMORY_PROPERTY_HOST_COHERENT_BIT} | {@link AMDDeviceCoherentMemory#VK_MEMORY_PROPERTY_DEVICE_COHERENT_BIT_AMD MEMORY_PROPERTY_DEVICE_COHERENT_BIT_AMD} | {@link AMDDeviceCoherentMemory#VK_MEMORY_PROPERTY_DEVICE_UNCACHED_BIT_AMD MEMORY_PROPERTY_DEVICE_UNCACHED_BIT_AMD}</li>
 * </ul>
 *
 * <p>There <b>must</b> be at least one memory type with both the {@link VK10#VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT MEMORY_PROPERTY_HOST_VISIBLE_BIT} and {@link VK10#VK_MEMORY_PROPERTY_HOST_COHERENT_BIT MEMORY_PROPERTY_HOST_COHERENT_BIT} bits set in its {@code propertyFlags}. There <b>must</b> be at least one memory type with the {@link VK10#VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT MEMORY_PROPERTY_DEVICE_LOCAL_BIT} bit set in its {@code propertyFlags}. If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#features-deviceCoherentMemory">{@code deviceCoherentMemory}</a> feature is enabled, there <b>must</b> be at least one memory type with the {@link AMDDeviceCoherentMemory#VK_MEMORY_PROPERTY_DEVICE_COHERENT_BIT_AMD MEMORY_PROPERTY_DEVICE_COHERENT_BIT_AMD} bit set in its {@code propertyFlags}.</p>
 *
 * <p>For each pair of elements <b>X</b> and <b>Y</b> returned in {@code memoryTypes}, <b>X</b> <b>must</b> be placed at a lower index position than <b>Y</b> if:</p>
 *
 * <ul>
 * <li>either the set of bit flags returned in the {@code propertyFlags} member of <b>X</b> is a strict subset of the set of bit flags returned in the {@code propertyFlags} member of <b>Y</b>; or</li>
 * <li>the {@code propertyFlags} members of <b>X</b> and <b>Y</b> are equal, and <b>X</b> belongs to a memory heap with greater performance (as determined in an implementation-specific manner) ; or</li>
 * <li>or the {@code propertyFlags} members of <b>X</b> includes {@link AMDDeviceCoherentMemory#VK_MEMORY_PROPERTY_DEVICE_COHERENT_BIT_AMD MEMORY_PROPERTY_DEVICE_COHERENT_BIT_AMD} or {@link AMDDeviceCoherentMemory#VK_MEMORY_PROPERTY_DEVICE_UNCACHED_BIT_AMD MEMORY_PROPERTY_DEVICE_UNCACHED_BIT_AMD} and <b>Y</b> does not</li>
 * </ul>
 *
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 *
 * <p>There is no ordering requirement between <b>X</b> and <b>Y</b> elements for the case their {@code propertyFlags} members are not in a subset relation. That potentially allows more than one possible way to order the same set of memory types. Notice that the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.1-extensions/html/vkspec.html#memory-device-bitmask-list">list of all allowed memory property flag combinations</a> is written in a valid order. But if instead {@link VK10#VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT MEMORY_PROPERTY_DEVICE_LOCAL_BIT} was before {@link VK10#VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT MEMORY_PROPERTY_HOST_VISIBLE_BIT} | {@link VK10#VK_MEMORY_PROPERTY_HOST_COHERENT_BIT MEMORY_PROPERTY_HOST_COHERENT_BIT}, the list would still be in a valid order.</p>
 *
 * <p>There may be a performance penalty for using device coherent or uncached device memory types, and using these accidentally is undesirable. In order to avoid this, memory types with these properties always appear at the end of the list; but are subject to the same rules otherwise.</p>
 * </div>
 *
 * <p>This ordering requirement enables applications to use a simple search loop to select the desired memory type along the lines of:</p>
 *
 * <pre><code>
 * // Find a memory in `memoryTypeBitsRequirement` that includes all of `requiredProperties`
 * int32_t findProperties(const VkPhysicalDeviceMemoryProperties* pMemoryProperties,
 *                        uint32_t memoryTypeBitsRequirement,
 *                        VkMemoryPropertyFlags requiredProperties) {
 *     const uint32_t memoryCount = pMemoryProperties-&gt;memoryTypeCount;
 *     for (uint32_t memoryIndex = 0; memoryIndex &lt; memoryCount; ++memoryIndex) {
 *         const uint32_t memoryTypeBits = (1 &lt;&lt; memoryIndex);
 *         const bool isRequiredMemoryType = memoryTypeBitsRequirement &amp; memoryTypeBits;
 *
 *         const VkMemoryPropertyFlags properties =
 *             pMemoryProperties-&gt;memoryTypes[memoryIndex].propertyFlags;
 *         const bool hasRequiredProperties =
 *             (properties &amp; requiredProperties) == requiredProperties;
 *
 *         if (isRequiredMemoryType &amp;&amp; hasRequiredProperties)
 *             return static_cast&lt;int32_t&gt;(memoryIndex);
 *     }
 *
 *     // failed to find memory type
 *     return -1;
 * }
 *
 * // Try to find an optimal memory type, or if it does not exist try fallback memory type
 * // `device` is the VkDevice
 * // `image` is the VkImage that requires memory to be bound
 * // `memoryProperties` properties as returned by vkGetPhysicalDeviceMemoryProperties
 * // `requiredProperties` are the property flags that must be present
 * // `optimalProperties` are the property flags that are preferred by the application
 * VkMemoryRequirements memoryRequirements;
 * vkGetImageMemoryRequirements(device, image, &amp;memoryRequirements);
 * int32_t memoryType =
 *     findProperties(&amp;memoryProperties, memoryRequirements.memoryTypeBits, optimalProperties);
 * if (memoryType == -1) // not found; try fallback properties
 *     memoryType =
 *         findProperties(&amp;memoryProperties, memoryRequirements.memoryTypeBits, requiredProperties);</code></pre>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkMemoryHeap}, {@link VkMemoryType}, {@link VkPhysicalDeviceMemoryProperties2}, {@link VK10#vkGetPhysicalDeviceMemoryProperties GetPhysicalDeviceMemoryProperties}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code memoryTypeCount} &ndash; the number of valid elements in the {@code memoryTypes} array.</li>
 * <li>{@code memoryTypes[VK_MAX_MEMORY_TYPES]} &ndash; an array of {@link VkMemoryType} structures describing the <em>memory types</em> that <b>can</b> be used to access memory allocated from the heaps specified by {@code memoryHeaps}.</li>
 * <li>{@code memoryHeapCount} &ndash; the number of valid elements in the {@code memoryHeaps} array.</li>
 * <li>{@code memoryHeaps[VK_MAX_MEMORY_HEAPS]} &ndash; an array of {@link VkMemoryHeap} structures describing the <em>memory heaps</em> from which memory <b>can</b> be allocated.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkPhysicalDeviceMemoryProperties {
 *     uint32_t memoryTypeCount;
 *     {@link VkMemoryType VkMemoryType} memoryTypes[VK_MAX_MEMORY_TYPES];
 *     uint32_t memoryHeapCount;
 *     {@link VkMemoryHeap VkMemoryHeap} memoryHeaps[VK_MAX_MEMORY_HEAPS];
 * }</code></pre>
 */
class PhysicalDeviceMemoryProperties(
    var memoryTypes: Array<MemoryType>,
    var memoryHeaps: Array<MemoryHeap>
) {

    constructor(ptr: Ptr) : this(
        Array(nmemoryTypeCount(ptr)) { MemoryType(ptr + MEMORYTYPES + VkMemoryType.SIZEOF * it) },
        Array(nmemoryHeapCount(ptr)) { MemoryHeap(ptr + MEMORYHEAPS + VkMemoryHeap.SIZEOF * it) })

    companion object {

        fun ncalloc(stack: MemoryStack, num: Int = 1): Ptr = stack.ncalloc(ALIGNOF, num, SIZEOF)

        fun <R> fromNative(stack: MemoryStack, block: (Ptr) -> R): PhysicalDeviceMemoryProperties {
            val native = ncalloc(stack)
            block(native)
            return PhysicalDeviceMemoryProperties(
                Array(nmemoryTypeCount(native)) { MemoryType(native + MEMORYTYPES + VkMemoryType.SIZEOF * it) },
                Array(nmemoryHeapCount(native)) { MemoryHeap(native + MEMORYHEAPS + VkMemoryType.SIZEOF * it) }
            )
        }
    }
}