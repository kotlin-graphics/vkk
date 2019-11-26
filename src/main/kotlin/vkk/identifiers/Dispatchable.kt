package identifiers

import kool.Ptr
import org.lwjgl.system.Pointer

/** Base class for Vulkan dispatchable handles.  */
abstract class Dispatchable(
    handle: Ptr,
    /** the [CapabilitiesInstance] instance associated with this dispatchable handle.  */
    val capabilities: CapabilitiesInstance
) : Pointer.Default(handle)

abstract class DispatchableHandleDevice(
    handle: Ptr,
    /** [CapabilitiesInstance] instance associated with this dispatchable handle.  */
    val capabilities: CapabilitiesDevice
) : Pointer.Default(handle)