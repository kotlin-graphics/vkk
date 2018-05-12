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
