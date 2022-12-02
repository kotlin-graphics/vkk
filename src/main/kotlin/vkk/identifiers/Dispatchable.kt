package vkk.identifiers

import kool.Adr
import kool.Ptr
import kool.adr
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.system.Pointer

/** Base class for Vulkan dispatchable handles.  */
interface Dispatchable {
    val handle: Adr
    val isValid: Boolean
        get() = handle != 0uL
    val isNotValid: Boolean
        get() = handle == 0uL
}

abstract class DispatchableHandleDevice(
        handle: Ptr,
        /** [CapabilitiesInstance] instance associated with this dispatchable handle.  */
        val capabilities: CapabilitiesDevice) : Pointer.Default(handle) {

    val isValid: Boolean
        get() = adr != NULL
    val isInvalid: Boolean
        get() = adr == NULL
}