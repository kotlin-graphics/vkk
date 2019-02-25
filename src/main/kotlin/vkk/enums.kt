package vkk



var DEBUG = java.lang.management.ManagementFactory.getRuntimeMXBean().inputArguments.toString().indexOf("jdwp") >= 0





var VULKAN_NO_EXCEPTIONS = false

class OutOfHostMemoryError(message: String) : Error(message)
class OutOfDeviceMemoryError(message: String) : Error(message)
class InitializationFailedError(message: String) : Error(message)
class DeviceLostError(message: String) : Error(message)
class MemoryMapFailedError(message: String) : Error(message)
class LayerNotPresentError(message: String) : Error(message)
class ExtensionNotPresentError(message: String) : Error(message)
class FeatureNotPresentError(message: String) : Error(message)
class IncompatibleDriverError(message: String) : Error(message)
class TooManyObjectsError(message: String) : Error(message)
class FormatNotSupportedError(message: String) : Error(message)
class FragmentedPoolError(message: String) : Error(message)
class SurfaceLostKhrError(message: String) : Error(message)
class NativeWindowInUseKhrError(message: String) : Error(message)
class OutOfDateKhrError(message: String) : Error(message)
class IncompatibleDisplayKhrError(message: String) : Error(message)
class ValidationFailedExtError(message: String) : Error(message)
class InvalidShaderNvError(message: String) : Error(message)
class OutOfPoolMemoryError(message: String) : Error(message)
class InvalidExternalHandleError(message: String) : Error(message)
class NotPermittedError(message: String) : Error(message)

fun VK_CHECK_RESULT(i: Int) = VkResult(i).check()






