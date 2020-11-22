package main;

import org.lwjgl.PointerBuffer;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.*;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFWVulkan.glfwGetRequiredInstanceExtensions;
import static org.lwjgl.glfw.GLFWVulkan.glfwVulkanSupported;
import static org.lwjgl.system.MemoryStack.stackPush;
import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.vulkan.EXTDebugReport.*;
import static org.lwjgl.vulkan.KHRSwapchain.VK_KHR_SWAPCHAIN_EXTENSION_NAME;
import static org.lwjgl.vulkan.VK10.*;

public class Instance01 {

    static boolean VALIDATE = false;
    static IntBuffer ip = memAllocInt(1);
    static final PointerBuffer pp = memAllocPointer(1);
    static PointerBuffer extension_names = memAllocPointer(64);
    static final ByteBuffer KHR_swapchain = memASCII(VK_KHR_SWAPCHAIN_EXTENSION_NAME);
    static final ByteBuffer EXT_debug_report = memASCII(VK_EXT_DEBUG_REPORT_EXTENSION_NAME);

    private static void check(int errcode) {
        if (errcode != 0) {
            throw new IllegalStateException(String.format("Vulkan error [0x%X]", errcode));
        }
    }

    private static PointerBuffer demo_check_layers(MemoryStack stack, VkLayerProperties.Buffer available, String... layers) {
        PointerBuffer required = stack.mallocPointer(layers.length);
        for (int i = 0; i < layers.length; i++) {
            boolean found = false;

            for (int j = 0; j < available.capacity(); j++) {
                available.position(j);
                if (layers[i].equals(available.layerNameString())) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.err.format("Cannot find layer: %s\n", layers[i]);
                return null;
            }

            required.put(i, stack.ASCII(layers[i]));
        }

        return required;
    }

    static final VkDebugReportCallbackEXT dbgFunc = VkDebugReportCallbackEXT.create(
            (flags, objectType, object, location, messageCode, pLayerPrefix, pMessage, pUserData) -> {
                String type;
                if ((flags & VK_DEBUG_REPORT_INFORMATION_BIT_EXT) != 0) {
                    type = "INFORMATION";
                } else if ((flags & VK_DEBUG_REPORT_WARNING_BIT_EXT) != 0) {
                    type = "WARNING";
                } else if ((flags & VK_DEBUG_REPORT_PERFORMANCE_WARNING_BIT_EXT) != 0) {
                    type = "PERFORMANCE WARNING";
                } else if ((flags & VK_DEBUG_REPORT_ERROR_BIT_EXT) != 0) {
                    type = "ERROR";
                } else if ((flags & VK_DEBUG_REPORT_DEBUG_BIT_EXT) != 0) {
                    type = "DEBUG";
                } else {
                    type = "UNKNOWN";
                }

                System.err.format(
                        "%s: [%s] Code %d : %s\n",
                        type, memASCII(pLayerPrefix), messageCode, VkDebugReportCallbackEXT.getString(pMessage)
                );

                /*
                 * false indicates that layer should not bail-out of an
                 * API call that had validation failures. This may mean that the
                 * app dies inside the driver due to invalid parameter(s).
                 * That's what would happen without validation layers, so we'll
                 * keep that behavior here.
                 */
                return VK_FALSE;
            }
    );

    public static VkInstanceCreateInfo getInfo(MemoryStack stack) {
        VkInstanceCreateInfo inst_info;
        PointerBuffer requiredLayers = null;
//        if (VALIDATE) {
//            check(vkEnumerateInstanceLayerProperties(ip, null));
//
//            if (ip.get(0) > 0) {
//                VkLayerProperties.Buffer availableLayers = VkLayerProperties.mallocStack(ip.get(0), stack);
//                check(vkEnumerateInstanceLayerProperties(ip, availableLayers));
//
//                // VulkanSDK 1.1.106+
//                requiredLayers = demo_check_layers(
//                        stack, availableLayers,
//                        "VK_LAYER_KHRONOS_validation"/*,
//                        "VK_LAYER_LUNARG_assistant_layer"*/
//                );
//                if (requiredLayers == null) { // use alternative (deprecated) set of validation layers
//                    requiredLayers = demo_check_layers(
//                            stack, availableLayers,
//                            "VK_LAYER_LUNARG_standard_validation"/*,
//                            "VK_LAYER_LUNARG_assistant_layer"*/
//                    );
//                }
//                if (requiredLayers == null) { // use alternative (deprecated) set of validation layers
//                    requiredLayers = demo_check_layers(
//                            stack, availableLayers,
//                            "VK_LAYER_GOOGLE_threading",
//                            "VK_LAYER_LUNARG_parameter_validation",
//                            "VK_LAYER_LUNARG_object_tracker",
//                            "VK_LAYER_LUNARG_core_validation",
//                            "VK_LAYER_GOOGLE_unique_objects"/*,
//                            "VK_LAYER_LUNARG_assistant_layer"*/
//                    );
//                }
//            }
//
//            if (requiredLayers == null) {
//                throw new IllegalStateException("vkEnumerateInstanceLayerProperties failed to find required validation layer.");
//            }
//        }
//
//        PointerBuffer required_extensions = glfwGetRequiredInstanceExtensions();
//        if (required_extensions == null) {
//            throw new IllegalStateException("glfwGetRequiredInstanceExtensions failed to find the platform surface extensions.");
//        }
//
//        for (int i = 0; i < required_extensions.capacity(); i++) {
////            System.out.println(memASCII(required_extensions.get(i)));
//            extension_names.put(required_extensions.get(i));
//        }
//
//        check(vkEnumerateInstanceExtensionProperties((String) null, ip, null));
//
//        if (ip.get(0) != 0) {
//            VkExtensionProperties.Buffer instance_extensions = VkExtensionProperties.mallocStack(ip.get(0), stack);
//            check(vkEnumerateInstanceExtensionProperties((String) null, ip, instance_extensions));
//
//            for (int i = 0; i < ip.get(0); i++) {
//                instance_extensions.position(i);
//                if (VK_EXT_DEBUG_REPORT_EXTENSION_NAME.equals(instance_extensions.extensionNameString())) {
//                    if (VALIDATE) {
//                        extension_names.put(EXT_debug_report);
//                    }
//                }
//            }
//        }

//        ByteBuffer APP_SHORT_NAME = stack.UTF8("tri");
//
//        VkApplicationInfo app = VkApplicationInfo.mallocStack(stack)
//                .sType(VK_STRUCTURE_TYPE_APPLICATION_INFO)
//                .pNext(NULL)
//                .pApplicationName(APP_SHORT_NAME)
//                .applicationVersion(0)
//                .pEngineName(APP_SHORT_NAME)
//                .engineVersion(0)
//                .apiVersion(VK.getInstanceVersionSupported());
//
//        extension_names.flip();
        inst_info = VkInstanceCreateInfo.callocStack(stack);
//                .sType(VK_STRUCTURE_TYPE_INSTANCE_CREATE_INFO)
//                .pNext(NULL)
//                .flags(0)
//                    .pApplicationInfo(app)
//                    .ppEnabledLayerNames(requiredLayers)
//                .ppEnabledExtensionNames(extension_names);
//        extension_names.clear();

//        VkDebugReportCallbackCreateInfoEXT dbgCreateInfo;
//        if (VALIDATE) {
//            dbgCreateInfo = VkDebugReportCallbackCreateInfoEXT.mallocStack(stack)
//                    .sType(VK_STRUCTURE_TYPE_DEBUG_REPORT_CALLBACK_CREATE_INFO_EXT)
//                    .pNext(NULL)
//                    .flags(VK_DEBUG_REPORT_ERROR_BIT_EXT | VK_DEBUG_REPORT_WARNING_BIT_EXT)
//                    .pfnCallback(dbgFunc)
//                    .pUserData(NULL);
//
//            inst_info.pNext(dbgCreateInfo.address());
//        }
        return inst_info;
//        return null;
    }

    public static void main(String[] args) {

        GLFWErrorCallback.createPrint().set();
        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        if (!glfwVulkanSupported()) {
            throw new IllegalStateException("Cannot find a compatible Vulkan installable client driver (ICD)");
        }


        try (MemoryStack stack = stackPush()) {
            VkInstanceCreateInfo inst_info = getInfo(stack);

            int err = vkCreateInstance(inst_info, null, pp);
            if (err == VK_ERROR_INCOMPATIBLE_DRIVER) {
                throw new IllegalStateException("Cannot find a compatible Vulkan installable client driver (ICD).");
            } else if (err == VK_ERROR_EXTENSION_NOT_PRESENT) {
                throw new IllegalStateException("Cannot find a specified extension library. Make sure your layers path is set appropriately.");
            } else if (err != 0) {
                throw new IllegalStateException("vkCreateInstance failed. Do you have a compatible Vulkan installable client driver (ICD) installed?");
            }

            VkInstance inst = new VkInstance(pp.get(0), inst_info);
            System.out.println("inst=" + inst.address());
        }
    }
}

