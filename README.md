# VK², Kotlin Wrapper for Vulkan


The goal of the VK² is to provide a library for the Vulkan C API to improve the developers Vulkan experience without introducing 
any considerable CPU runtime cost. It adds features like type safety for enums and bitfields, collection support, exceptions and simple enumerations.

## Getting Started

VK² can be obtained by adding the following lines in your `build.gradle`:

- Step 1. Add the JitPack repository to your build file at the end of repositories:

      allprojects {
          repositories {
              ...
              maven { url 'https://jitpack.io' }
          }
      }

- Step 2. Add the dependency:

	  dependencies {
	      implementation 'com.github.kotlin-graphics:vkk:-SNAPSHOT'
	  }

## Usage

### vk `object`

To avoid name collisions with the lwjgl Vulkan bindings, the VK² wrapper resides mostly under the `object vk`. The following rules apply to the new naming

* All functions, extension functions, and structs have the Vk prefix removed. In addition to this the first letter of functions is lower case.
  * `VkCreateImage` can be accessed as `vk.createImage`
  * `VkImageTiling` can be accessed as `vk.ImageTiling`
  * `VkImageCreateInfo` can be accessed as `vk.ImageCreateInfo`
* Enums are mapped to scoped enums to provide compile time type safety. The names have been changed to have the Enum Base in CamelCase with the VK_ prefix and the enum name in Capital letters (corresponding to the original counterpart). Enums starting with a number requires to be surrounded by backticks, `` ` ``

Some examples:
  - `VK_COLOR_SPACE_SRGB_NONLINEAR_KHR` is now `VkColorSpace.SRGB_NONLINEAR_KHR`
  - `VK_IMAGETYPE_2D` is now ``VkImageType.`2D` ``

* Flag bits are handled like scoped enums with the addition that the `_BIT` suffix has also been removed.

### Extension functions

This is one case where Kotlin really shines: VK² declares a class for all handles to ensure full type safety and to add support for member functions on handles. A member function has been added to a handle class for each function which accepts the corresponding handle as first parameter. Instead of `vkBindBufferMemory(device, ...)` one can write `device.bindBufferMemory(...)`.

### Mask Flags

All flags masks have been `typealias`ed accordingly. For example a field of type `VkBufferUsageFlags` means that it represents a mask from the `VkBufferUsage.` enum.
The postfix `Flag` has been eliminated from the enum name for conciseness matter. However, it has been kept for some special cases, such as `VkQueueFlag`, to avoid clashes with existing other structures, in this case the `VkQueue` class for example.

### CreateInfo structs

When constructing a handle in Vulkan one usually has to create some `CreateInfo` struct which describes the new handle. This can result in quite lengthy code as can be seen in the following Vulkan C example:

```kotlin
val info = vk.ImageCreateInfo {
    type = Vk.StructureType.IMAGE_CREATE_INFO
    next = null
    flags = ...some flags...
    imageType = VkImageType.`2D`
    format = VkFormat.R8G8B8A8_UNORM
    extent(size, 1)
    mipLevels = 1
    arrayLayers = 1
    samples = VkSampleCount.`1_BIT`
    tiling = VkImageTiling.OPTIMAL
    usage = VkImageUsage.COLOR_ATTACHMENT_BIT.i
    sharingMode = VkSharingMode.EXCLUSIVE
    queueFamilyIndices = null
    initialLayout = VkImageLayout.UNDEFINED
}
image = device createImage info
```

One typical issue Vulkan developers encounter when filling out a CreateInfo struct field by field is that `sType` is incorrect.

VK² provides constructors for all CreateInfo objects (and others) where `sType` is automatically filled with the correct value and `pNext` set to a `nullptr` by default. Here's how the same code looks with a constructor:

```kotlin
val info = vk.ImageCreateInfo {
    flags = ...some flags...
    imageType = VkImageType.`2D`
    format = VkFormat.R8G8B8A8_UNORM
    extent(size, 1)
    mipLevels = 1
    arrayLayers = 1
    samples = VkSampleCount.`1_BIT`
    tiling = VkImageTiling.OPTIMAL
    usage = VkImageUsage.COLOR_ATTACHMENT_BIT.i
    sharingMode = VkSharingMode.EXCLUSIVE
}
```

TODO
