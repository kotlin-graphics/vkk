package vkk

import java.io.File
import vkk.gen.listAdoc

val refPages = mutableMapOf<String, RefPage>()

data class RefPage(val name: String, val desc: String, val page: String, val alias: String = "") {
    val xNames = ArrayList<String>()
    val seeAlso = ArrayList<String>()
}

object apiMap {
    val mapDict = mutableMapOf<String, List<String>>()
    val requiredBy = mutableMapOf<String, List<String>>()
    val crossRefs = mutableMapOf<String, List<String>>()
}

fun apiMapAndDocs(vkDocs: File) {

    val apimap = vkDocs.resolve("gen/apimap.py").readText().lines()

    run {
        val mapDict = apimap.dropWhile { it != "mapDict = {" }.drop(1).takeWhile { it != "}" }
        lateinit var key: String
        val values = arrayListOf<String>()
        for (line in mapDict) {
            if (line[0] == '\'') {
                key = line.drop(1).substringBefore("'")
                var index = key.length + 6
                while (true) {
                    index = line.indexOf("'", index)
                    if (index == -1)
                        break
                    values += line.substring(++index).substringBefore("'")
                    index += values.last().length + 2
                }
            } else
                values += line.drop(2).substringBefore("'")
            if (line.endsWith("},")) {
                apiMap.mapDict[key] = values.clone() as List<String>
                values.clear()
            }
        }
    }
    /*val lwjgl = listOf(
        "vkDestroyInstance",
        "vkEnumeratePhysicalDevices",
        "vkGetPhysicalDeviceFeatures",
        "vkGetPhysicalDeviceFormatProperties",
        "vkGetPhysicalDeviceImageFormatProperties",
        "vkGetPhysicalDeviceProperties",
        "vkGetPhysicalDeviceQueueFamilyProperties",
        "vkGetPhysicalDeviceMemoryProperties",
        "vkCreateDevice",
        "vkEnumerateDeviceExtensionProperties",
        "vkEnumerateDeviceLayerProperties",
        "vkGetPhysicalDeviceSparseImageFormatProperties",
        // VK11
        "vkEnumeratePhysicalDeviceGroups",
        "vkGetPhysicalDeviceFeatures2",
        "vkGetPhysicalDeviceProperties2",
        "vkGetPhysicalDeviceFormatProperties2",
        "vkGetPhysicalDeviceImageFormatProperties2",
        "vkGetPhysicalDeviceQueueFamilyProperties2",
        "vkGetPhysicalDeviceMemoryProperties2",
        "vkGetPhysicalDeviceSparseImageFormatProperties2",
        "vkGetPhysicalDeviceExternalBufferProperties",
        "vkGetPhysicalDeviceExternalFenceProperties",
        "vkGetPhysicalDeviceExternalSemaphoreProperties",
        // VK13
        "vkGetPhysicalDeviceToolProperties",
        // EXT_acquire_drm_display
        "vkAcquireDrmDisplayEXT",
        "vkGetDrmDisplayEXT",
        // EXT_acquire_xlib_display
        "vkAcquireXlibDisplayEXT",
        "vkGetRandROutputDisplayEXT",
        // EXT_calibrated_timestamps
        "vkGetPhysicalDeviceCalibrateableTimeDomainsEXT",
        // EXT_debug_report
        "vkCreateDebugReportCallbackEXT",
        "vkDestroyDebugReportCallbackEXT",
        "vkDebugReportMessageEXT",
        // EXT_debug_utils
        "vkCreateDebugUtilsMessengerEXT",
        "vkDestroyDebugUtilsMessengerEXT",
        "vkSubmitDebugUtilsMessageEXT",
        // EXT_direct_mode_display
        "vkReleaseDisplayEXT",
        // EXT_display_surface_counter
        "vkGetPhysicalDeviceSurfaceCapabilities2EXT",
        // EXT_full_screen_exclusive
        "vkGetPhysicalDeviceSurfacePresentModes2EXT",
        // EXT_headless_surface
        "vkCreateHeadlessSurfaceEXT",
        // EXT_metal_surface
        "vkCreateMetalSurfaceEXT",
        // EXT_sample_locations
        "vkGetPhysicalDeviceMultisamplePropertiesEXT",
        // EXT_tooling_info
        "vkGetPhysicalDeviceToolPropertiesEXT",
        // KHR_device_group
        "vkGetPhysicalDevicePresentRectanglesKHR",
        // KHR_device_group_creation
        "vkEnumeratePhysicalDeviceGroupsKHR",
        // KHR_display
        "vkGetPhysicalDeviceDisplayPropertiesKHR",
        "vkGetPhysicalDeviceDisplayPlanePropertiesKHR",
        "vkGetDisplayPlaneSupportedDisplaysKHR",
        "vkGetDisplayModePropertiesKHR",
        "vkCreateDisplayModeKHR",
        "vkGetDisplayPlaneCapabilitiesKHR",
        "vkCreateDisplayPlaneSurfaceKHR",
        // KHR_external_fence_capabilities
        "vkGetPhysicalDeviceExternalFencePropertiesKHR",
        // KHR_external_memory_capabilities
        "vkGetPhysicalDeviceExternalBufferPropertiesKHR",
        // KHR_external_semaphore_capabilities
        "vkGetPhysicalDeviceExternalSemaphorePropertiesKHR",
        // KHR_fragment_shading_rate
        "vkGetPhysicalDeviceFragmentShadingRatesKHR",
        // KHR_get_display_properties2
        "vkGetPhysicalDeviceDisplayProperties2KHR",
        "vkGetPhysicalDeviceDisplayPlaneProperties2KHR",
        "vkGetDisplayModeProperties2KHR",
        "vkGetDisplayPlaneCapabilities2KHR",
        // KHR_get_physical_device_properties2
        "vkGetPhysicalDeviceFeatures2KHR",
        "vkGetPhysicalDeviceProperties2KHR",
        "vkGetPhysicalDeviceFormatProperties2KHR",
        "vkGetPhysicalDeviceImageFormatProperties2KHR",
        "vkGetPhysicalDeviceQueueFamilyProperties2KHR",
        "vkGetPhysicalDeviceMemoryProperties2KHR",
        "vkGetPhysicalDeviceSparseImageFormatProperties2KHR",
        // KHR_get_surface_capabilities2
        "vkGetPhysicalDeviceSurfaceCapabilities2KHR",
        "vkGetPhysicalDeviceSurfaceFormats2KHR",
        // KHR_performance_query
        "vkEnumeratePhysicalDeviceQueueFamilyPerformanceQueryCountersKHR",
        "vkGetPhysicalDeviceQueueFamilyPerformanceQueryPassesKHR",
        // KHR_surface
        "vkDestroySurfaceKHR",
        "vkGetPhysicalDeviceSurfaceSupportKHR",
        "vkGetPhysicalDeviceSurfaceCapabilitiesKHR",
        "vkGetPhysicalDeviceSurfaceFormatsKHR",
        "vkGetPhysicalDeviceSurfacePresentModesKHR",
        // KHR_video_queue
        "vkGetPhysicalDeviceVideoCapabilitiesKHR",
        "vkGetPhysicalDeviceVideoFormatPropertiesKHR",
        // KHR_wayland_surface
        "vkCreateWaylandSurfaceKHR",
        "vkGetPhysicalDeviceWaylandPresentationSupportKHR",
        // KHR_win32_surface
        "vkCreateWin32SurfaceKHR",
        "vkGetPhysicalDeviceWin32PresentationSupportKHR",
        // KHR_xlib_surface
        "vkCreateXlibSurfaceKHR",
        "vkGetPhysicalDeviceXlibPresentationSupportKHR",
        // MVK_macos_surface
        "vkCreateMacOSSurfaceMVK",
        // NV_acquire_winrt_display
        "vkAcquireWinrtDisplayNV",
        "vkGetWinrtDisplayNV",
        // NV_cooperative_matrix
        "vkGetPhysicalDeviceCooperativeMatrixPropertiesNV",
        // NV_coverage_reduction_mode
        "vkGetPhysicalDeviceSupportedFramebufferMixedSamplesCombinationsNV",
        // NV_external_memory_capabilities
        "vkGetPhysicalDeviceExternalImageFormatPropertiesNV")*/
    //    println("VkInstance")
    //    val tot = apiMap.mapDict["VkInstance"]!! + apiMap.mapDict["VkPhysicalDevice"]!!
    run {
        val requiredBy = apimap.dropWhile { it != "requiredBy = {" }.drop(1).takeWhile { it != "}" }
        for (line in requiredBy) {
            val key = line.drop(1).substringBefore("'")
            val requiredBys = ArrayList<String>()
            var index = key.length + 7
            while (true) {
                index = line.indexOf("'", index)
                if (index == -1)
                    break
                requiredBys += line.substring(++index).substringBefore("'")
                index += requiredBys.last().length + 2
            }
            apiMap.requiredBy[key] = requiredBys
        }
    }

    //    val req = apiMap.requiredBy.filter { "VK_VERSION_1_0" in it.value }.map { it.key }
    //    for (t in tot)
    //        if (t in req)
    //            println(t)

    fun String.replaceKey(key: String, prefix: Char, postfix: Char = prefix): String {
        var res = this
        if (isEmpty())
            return res
        var index = res.indexOf("$key:")
        while (index != -1) {
            index += key.length + 1 // :
            var end = 0
            while (index + end in res.indices && (res[index + end].isLetterOrDigit() || res[index + end] == '*' || res[index + end] == '_')) // Vk*Flags, VkFlags64
                end++
            val code = res.substring(index, index + end)
            res = res.replaceFirst("$key:$code", "$prefix$code$postfix")
            index = res.indexOf("$key:", end)
        }
        return res
    }

    fun String.resolve(): String {
        //        val found = this == "members of slink:VkMemoryBarrier2KHR, slink:VkImageMemoryBarrier2KHR, and"
        var resolved = this
        // we need to treat slink::X[.Y] differently because its complexity
        var idx = indexOf("slink:")
        while (idx != -1) {
            var end = idx + 6
            while (end in resolved.indices && (resolved[end].isLetterOrDigit() || resolved[end] == ':'))
                end++
            //                                println(formatted)
            //                                println("$idx + 6 .. $end")
            val slink = resolved.substring(idx + 6..end - 1)
            //            if (found) println(slink)
            resolved = resolved.replaceFirst("slink:$slink", '[' + slink.replace("::pname:", ".") + ']')
            //            if (found)println(resolved)
            //            if (found)println("$idx")
            idx = resolved.indexOf("slink:", idx + slink.length + 2)
            //            if (found)println("$idx, $end")
        }
        return resolved
                .replaceKey("etext", '`')
                .replaceKey("basetype", '[', ']')
                .replaceKey("flink", '[', ']')
                .replace("  * pname:", "@param ") // this must go before the next one
                .replaceKey("ename", '[', ']')
                .replaceKey("sname", '[', ']')
                .replaceKey("pname", '`')
                .replaceKey("dname", '`')
                .replaceKey("code", '`')
                .replaceKey("tname", '[', ']')
                .replaceKey("tlink", '[', ']')
                .replaceKey("elink", '[', ']')
                //                                                    .replace("::pname:", ".")
                .replace("{core_header}", "vulkan_core.h")
                .replace("must:", "**must**")
                .replace("may:", "**may**")
                .replace("cannot:", "**cannot**")
                .replace("undefined:", "**undefined**")
                .replace(".Note", "")
    }

    val chapters = vkDocs.resolve("chapters").listAdoc()
    val chaptersExtensions = ArrayList<File>()
    vkDocs.resolve("chapters").listFiles()!!.forEach {
        if (it.isDirectory && it.name.startsWith("VK_"))
            chaptersExtensions += it.listAdoc()
    }
    val appendices = vkDocs.resolve("appendices").listAdoc()
    for (adoc in chapters + chaptersExtensions + appendices) {

        var page = StringBuilder()
        var delimiter = 0
        val xNames = ArrayList<String>()
        var name = ""
        var desc = ""
        var alias = ""

        fun xName(line: String) {
            if (xNames.isNotEmpty()) {
                val existing = xNames.removeAt(xNames.lastIndex)
                xNames += existing + ' ' + line.trimStart()
            }
        }

        for (line in adoc.readText().lines())
            when {
                line.startsWith("[open,refpage='") -> {
                    check(page.isEmpty() && delimiter == 0)
                    name = line.substring(15).substringBefore("'")
                    desc = line.substring(15 + name.length + 8).substringBefore("'")
                    val aliasIdx = line.indexOf("alias='")
                    alias = when {
                        aliasIdx != -1 -> line.substring(aliasIdx + 7).substringBefore("'")
                        else -> ""
                    }
                    val xrefs = line.indexOf("xrefs='")
                    if (xrefs != -1)
                        apiMap.crossRefs[name] = line.substring(xrefs + 7).substringBefore("'").split(' ')
                }
                line == "--" ->
                    if (delimiter == 1) { // end
                        val refPage = RefPage(name, desc, page.toString(), alias)
                        refPages[name] = refPage
                        apiMap.requiredBy[name]?.let { refPage.seeAlso += it }
                        apiMap.mapDict[name]?.let { refPage.seeAlso += it }
                        apiMap.crossRefs[name]?.let { refPage.seeAlso += it }
                        refPage.xNames += xNames.map { it.resolve() }
                        xNames.clear()
                        page.clear()
                        delimiter = 0
                    } else { // start
                        check(delimiter == 0)
                        delimiter++
                    }
                delimiter == 1 -> { // inside a refPage
                    when {
                        line.startsWith("  * ename:") || line.startsWith("  * pname:") -> xNames += line.substring(10)
                        line.startsWith("  * [[") -> xNames += line.substringAfter("]] pname:")
                        line.startsWith("    ") -> xName(line)
                        line.startsWith("  ** ") -> xName(line.replace("  ** ", "    - "))
                        line.startsWith("include::{generated}") -> {
                            val relative = line.drop(20).dropLast(2)
                            val lines = vkDocs.resolve("gen$relative").readText().lines()
                            page.appendLine("```")
                            for (code in lines.drop(4).dropLast(2)/*.filter { it.isNotEmpty() }*/)
                                page.appendLine(code)
                            page.appendLine("```")
                        }
                        else ->
                            if (line != ":refpage: $name" && !line.startsWith("ifdef::") && !line.startsWith("endif::")
                                && !line.startsWith("ifndef::"))
                                page.appendLine(line.resolve())
                    }
                }
            }
    }
//    for ((k, v) in apiMap.structOptionals.toSortedMap().entries.take(10)) {
//        println("$k $v")
//    }
}