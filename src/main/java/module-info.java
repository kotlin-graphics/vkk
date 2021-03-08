module kotlin.graphics.vkk {

    requires kotlin.stdlib;

    requires java.management;

    requires org.lwjgl;
    requires org.lwjgl.vulkan;

    requires kotlin.graphics.gli;
    requires kotlin.graphics.glm;
    requires kotlin.graphics.kool;
    requires kotlin.graphics.unsigned;
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