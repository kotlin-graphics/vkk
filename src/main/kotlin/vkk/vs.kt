package vkk

import kool.Ptr
import kool.adr
import kool.set
import org.lwjgl.PointerBuffer
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import org.lwjgl.vulkan.*

object vs {

    class ApplicationInfo(
            var applicationName: String? = null,
            var applicationVersion: Int = 0,
            var engineName: String? = null,
            var engineVersion: Int = 0,
            var apiVersion: Int = 0) {

        val MemoryStack.native: VkApplicationInfo
            get() = ApplicationInfo()
                    .pApplicationName(UTF8Safe(applicationName))
                    .applicationVersion(applicationVersion)
                    .pEngineName(UTF8Safe(engineName))
                    .engineVersion(engineVersion)
                    .apiVersion(apiVersion)
    }

    class InstanceCreateInfo(
            var applicationInfo: ApplicationInfo? = null,
            var enabledLayerNames: Array<String>? = null,
            var enabledExtensionNames: Array<String>? = null) {

        var next: Ptr = NULL

        val MemoryStack.native: VkInstanceCreateInfo
            get() = InstanceCreateInfo()
                    .sType(VK10.VK_STRUCTURE_TYPE_INSTANCE_CREATE_INFO)
                    .pNext(next)
                    .pApplicationInfo(applicationInfo?.run { native })
                    .ppEnabledLayerNames(enabledLayerNames?.toPointerArray(this))
                    .ppEnabledExtensionNames(enabledExtensionNames?.toPointerArray(this))
    }

//    fun PhysicalDeviceFeatures(
//        robustBufferAccess: Boolean = false,
//        fullDrawIndexUint32: Boolean = false,
//        imageCubeArray: Boolean = false,
//        independentBlend: Boolean = false,
//        geometryShader: Boolean = false,
//        tessellationShader: Boolean = false,
//        sampleRateShading: Boolean = false,
//        dualSrcBlend: Boolean = false,
//        logicOp: Boolean = false,
//        multiDrawIndirect: Boolean = false,
//        drawIndirectFirstInstance: Boolean = false,
//        depthClamp: Boolean = false,
//        depthBiasClamp: Boolean = false,
//        fillModeNonSolid: Boolean = false,
//        depthBounds: Boolean = false,
//        wideLines: Boolean = false,
//        largePoints: Boolean = false,
//        alphaToOne: Boolean = false,
//        multiViewport: Boolean = false,
//        samplerAnisotropy: Boolean = false,
//        textureCompressionETC2: Boolean = false,
//        textureCompressionASTC_LDR: Boolean = false,
//        textureCompressionBC: Boolean = false,
//        occlusionQueryPrecise: Boolean = false,
//        pipelineStatisticsQuery: Boolean = false,
//        vertexPipelineStoresAndAtomics: Boolean = false,
//        fragmentStoresAndAtomics: Boolean = false,
//        shaderTessellationAndGeometryPointSize: Boolean = false,
//        shaderImageGatherExtended: Boolean = false,
//        shaderStorageImageExtendedFormats: Boolean = false,
//        shaderStorageImageMultisample: Boolean = false,
//        shaderStorageImageReadWithoutFormat: Boolean = false,
//        shaderStorageImageWriteWithoutFormat: Boolean = false,
//        shaderUniformBufferArrayDynamicIndexing: Boolean = false,
//        shaderSampledImageArrayDynamicIndexing: Boolean = false,
//        shaderStorageBufferArrayDynamicIndexing: Boolean = false,
//        shaderStorageImageArrayDynamicIndexing: Boolean = false,
//        shaderClipDistance: Boolean = false,
//        shaderCullDistance: Boolean = false,
//        shaderFloat64: Boolean = false,
//        shaderInt64: Boolean = false,
//        shaderInt16: Boolean = false,
//        shaderResourceResidency: Boolean = false,
//        shaderResourceMinLod: Boolean = false,
//        sparseBinding: Boolean = false,
//        sparseResidencyBuffer: Boolean = false,
//        sparseResidencyImage2D: Boolean = false,
//        sparseResidencyImage3D: Boolean = false,
//        sparseResidency2Samples: Boolean = false,
//        sparseResidency4Samples: Boolean = false,
//        sparseResidency8Samples: Boolean = false,
//        sparseResidency16Samples: Boolean = false,
//        sparseResidencyAliased: Boolean = false,
//        variableMultisampleRate: Boolean = false,
//        inheritedQueries: Boolean = false): VkPhysicalDeviceFeatures {
//
//
//    }

    infix fun createInstance(createInfo: InstanceCreateInfo): VkInstance = stak { s ->
        val instanceCreateInfo = createInfo.run { s.native }
        val instance = s.pointerBuffer { VK_CHECK_RESULT(VK10.vkCreateInstance(instanceCreateInfo, null, it)) }
        VkInstance(instance, instanceCreateInfo)
    }
}

fun Array<String>.toPointerArray(stack: MemoryStack): PointerBuffer =
        stack.PointerBuffer(size) { stack.UTF8(get(it)).adr }

fun MemoryStack.PointerBuffer(size: Int, init: (Int) -> Ptr): PointerBuffer {
    val pointers = mallocPointer(size)
    for (i in 0 until size)
        pointers[i] = init(i)
    return pointers
}

fun <R> MemoryStack.pointerBuffer(block: (PointerBuffer) -> R): Ptr {
    val buf = mallocPointer(1)
    block(buf)
    return buf[0]
}