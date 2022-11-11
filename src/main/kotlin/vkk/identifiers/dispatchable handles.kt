package vkk.identifiers

import kool.Ptr
import kool.adr
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.system.Pointer

/** Base class for Vulkan dispatchable handles.  */
abstract class DispatchableHandleInstance(
    handle: Ptr,
    /** the [CapabilitiesInstance] instance associated with this dispatchable handle.  */
    val capabilities: CapabilitiesInstance) : Pointer.Default(handle) {

    val isValid: Boolean
        get() = adr != NULL
    val isInvalid: Boolean
        get() = adr == NULL
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