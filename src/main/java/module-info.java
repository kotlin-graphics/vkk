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
//    exports vkk.classes;
    exports vkk.entities;
//    exports vkk.identifiers;
}