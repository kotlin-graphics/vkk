package vkk._11.structs

import kool.Ptr
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.NULL
import vkk.VkStructureType

/**
 * Structure indicating which physical devices execute semaphore operations and command buffers.
 *
 * <h5>Description</h5>
 *
 * <p>If this structure is not present, semaphore operations and command buffers execute on device index zero.</p>
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>{@code waitSemaphoreCount} <b>must</b> equal {@link VkSubmitInfo}{@code ::waitSemaphoreCount}</li>
 * <li>{@code commandBufferCount} <b>must</b> equal {@link VkSubmitInfo}{@code ::commandBufferCount}</li>
 * <li>{@code signalSemaphoreCount} <b>must</b> equal {@link VkSubmitInfo}{@code ::signalSemaphoreCount}</li>
 * <li>All elements of {@code pWaitSemaphoreDeviceIndices} and {@code pSignalSemaphoreDeviceIndices} <b>must</b> be valid device indices</li>
 * <li>All elements of {@code pCommandBufferDeviceMasks} <b>must</b> be valid device masks</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_DEVICE_GROUP_SUBMIT_INFO STRUCTURE_TYPE_DEVICE_GROUP_SUBMIT_INFO}</li>
 * <li>If {@code waitSemaphoreCount} is not 0, {@code pWaitSemaphoreDeviceIndices} <b>must</b> be a valid pointer to an array of {@code waitSemaphoreCount} {@code uint32_t} values</li>
 * <li>If {@code commandBufferCount} is not 0, {@code pCommandBufferDeviceMasks} <b>must</b> be a valid pointer to an array of {@code commandBufferCount} {@code uint32_t} values</li>
 * <li>If {@code signalSemaphoreCount} is not 0, {@code pSignalSemaphoreDeviceIndices} <b>must</b> be a valid pointer to an array of {@code signalSemaphoreCount} {@code uint32_t} values</li>
 * </ul>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code waitSemaphoreCount} &ndash; the number of elements in the {@code pWaitSemaphoreDeviceIndices} array.</li>
 * <li>{@code pWaitSemaphoreDeviceIndices} &ndash; an array of device indices indicating which physical device executes the semaphore wait operation in the corresponding element of {@link VkSubmitInfo}{@code ::pWaitSemaphores}.</li>
 * <li>{@code commandBufferCount} &ndash; the number of elements in the {@code pCommandBufferDeviceMasks} array.</li>
 * <li>{@code pCommandBufferDeviceMasks} &ndash; an array of device masks indicating which physical devices execute the command buffer in the corresponding element of {@link VkSubmitInfo}{@code ::pCommandBuffers}. A physical device executes the command buffer if the corresponding bit is set in the mask.</li>
 * <li>{@code signalSemaphoreCount} &ndash; the number of elements in the {@code pSignalSemaphoreDeviceIndices} array.</li>
 * <li>{@code pSignalSemaphoreDeviceIndices} &ndash; an array of device indices indicating which physical device executes the semaphore signal operation in the corresponding element of {@link VkSubmitInfo}{@code ::pSignalSemaphores}.</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkDeviceGroupSubmitInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     uint32_t waitSemaphoreCount;
 *     uint32_t const * pWaitSemaphoreDeviceIndices;
 *     uint32_t commandBufferCount;
 *     uint32_t const * pCommandBufferDeviceMasks;
 *     uint32_t signalSemaphoreCount;
 *     uint32_t const * pSignalSemaphoreDeviceIndices;
 * }</code></pre>
 */
class DeviceGroupSubmitInfo(
        var waitSemaphoreDeviceIndices: IntArray? = null,
        var commandBufferDeviceMasks: IntArray? = null,
        var signalSemaphoreDeviceIndices: IntArray? = null,
        var next: Ptr = NULL
) {

    val type get() = VkStructureType.DEVICE_GROUP_SUBMIT_INFO
}