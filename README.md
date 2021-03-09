# VK², Kotlin Wrapper for Vulkan

[![Build Status](https://github.com/kotlin-graphics/vkk/workflows/build/badge.svg)](https://github.com/kotlin-graphics/vkk/actions?workflow=build)
[![license](https://img.shields.io/badge/License-Apache%202.0-orange.svg)](https://github.com/kotlin-graphics/vkk/blob/master/LICENSE) 
[![Release](https://jitpack.io/v/kotlin-graphics/vkk.svg)](https://jitpack.io/#kotlin-graphics/vkk) 
![Size](https://github-size-badge.herokuapp.com/kotlin-graphics/vkk.svg)
[![Github All Releases](https://img.shields.io/github/downloads/kotlin-graphics/vkk/total.svg)]()

The goal of the VK² is to provide a library for the Vulkan C API to improve the developers Vulkan experience without introducing 
any considerable CPU runtime cost. It adds features like type safety for enums and bitfields, collection support, exceptions and simple enumerations.

Strongly inspired by [Vulkan hpp](https://github.com/KhronosGroup/Vulkan-Hpp), it's shaped on the Sasha examples [port](https://github.com/java-opengl-labs/Vulkan). It's the Vulkan counterpart of the OpenGL [gln](https://github.com/kotlin-graphics/gln/).

See it in action [here](https://github.com/jvm-graphics-labs/Vulkan)!

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
* Enums are mapped to scoped enums to provide compile time type safety. The names have been changed to have the Enum Base in CamelCase with the VK_ prefix and the enum name in Capital letters (corresponding to the original counterpart). Enums starting with a number requires ~to be surrounded by backticks~ the underscore prefix `_`, this because Idea handles backticks this very poorly.

Some examples:
  - `VK_COLOR_SPACE_SRGB_NONLINEAR_KHR` is now `VkColorSpace.SRGB_NONLINEAR_KHR`
  - `VK_IMAGETYPE_2D` is now ``VkImageType._2D ``

* Flag bits are handled like scoped enums with the addition that the `_BIT` suffix has also been removed.

### Extension functions

This is one case where Kotlin really shines: VK² declares a class for all handles to ensure full type safety and to add support for member functions on handles. A member function has been added to a handle class for each function which accepts the corresponding handle as first parameter. Instead of `vkBindBufferMemory(device, ...)` one can write `device.bindBufferMemory(...)`.

### Mask Flags

All flags masks have been `typealias`ed accordingly. For example a field of type `VkBufferUsageFlags` means that it represents a mask from the `VkBufferUsage.` enum.
The postfix `Flag` has been eliminated from the enum name for conciseness matter. However, it has been kept for some special cases, such as `VkQueueFlag`, to avoid clashes with existing other structures, in this case the `VkQueue` class for example.

### CreateInfo structs and appBuffer

When constructing a handle in Vulkan one usually has to create some `CreateInfo` struct which describes the new handle. Moreover, allocation has to be handled manually and everywhere C code uses pointers, we have to use buffers on the JVM. 
This can result in quite lengthy code as can be seen in the following Vulkan example:

```kotlin
val info = VkImageCreateInfo.calloc()
    .sType(VK_STRUCTURE_TYPE_IMAGE_CREATE_INFO)
    .pNext(null)
    .flags(...some flags...)
    .imageType(VK_IMAGE_TYPE_2D)
    .format(VK_FORMAT_R8G8B8A8_UNORM)
    .extent().apply {
        .width(size.x)
        .height(size.y)
        .depth(1)
    }
    .mipLevels(1)
    .arrayLayers(1)
    .samples(VK_SAMPLE_COUNT_1_BIT)
    .tiling(VK_IMAGE_TILING_OPTIMAL)
    .usage(VK_IMAGE_USAGE_COLOR_ATTACHMENT_BIT)
    .sharingMode(VK_SHARING_MODE_EXCLUSIVE)
    .pQueueFamilyIndices(null)
    .initialLayout(VK_IMAGE_LAYOUT_UNDEFINED)
val pImage = MemoryUtil.memAllocLong(1)
vkCreateImage(device, info, allocator, pImage)
image = pImage.get(0)
info.free()
memFree(pImage)
```

One typical issue Vulkan developers encounter when filling out a CreateInfo struct field by field is that `sType` is incorrect.

VK² provides constructors for all CreateInfo objects (and others) where `sType` is automatically filled with the correct value and `pNext` set to a `nullptr` by default. All other field are also initialized to zero. There are exceptions though.

Moreover, all the allocations takes place in the thread local memory, using the lwjgl `MemoryStack` class.

VK² provides also special method accepting glm classes, like `extent` accepting a `(Vec3i)` or `(Vec2i, Int)`.
Here's how the same code looks with a constructor:

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
image = device createImage info
```

Errors will be checked automatically in debug mode, but you can set `DEBUG` explicitely as you wish.
In case `VULKAN_NO_EXCEPTIONS` is `true`, errors will be reported in the `System.err` stream, otherwise the exception to the corresponding error will be thrown.

TODO

### Build-logic and platform dependencies

The build logic has been extracted in dedicated [plugins](https://github.com/elect86/build-logic), as well as the versioning in specific platform [plugins](https://github.com/elect86/platforms).

In order to import vkk you need then to add the repository where these plugins are getting published for the time being.

In Gradle KTS you can do that by adding the following to your `settings.gradle.kts`:

```kotlin
pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://repo.repsy.io/mvn/elect/kx")
    }
}
```
