module com.github.kotlin_graphics.vkk {

    requires kotlin.stdlib;

    requires java.management;

    requires org.lwjgl;
    requires org.lwjgl.vulkan;

    requires com.github.kotlin_graphics.gli;
    requires com.github.kotlin_graphics.glm;
    requires com.github.kotlin_graphics.kool;
    requires com.github.kotlin_graphics.kotlin_unsigned;
    requires kotlin.reflect;

    exports vkk;
    exports vkk.entities;
    exports vkk.extensions;
    exports vkk.identifiers;
    exports vkk.unique;
    exports vkk.vk10;
    exports vkk.vk10.api;
    exports vkk.vk10.structs;
    exports vkk.vk11;
//    exports vkk.vk11.api;
    exports vkk.vk11.structs;
}