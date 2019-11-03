module com.github.kotlin_graphics.vkk {

    requires kotlin.stdlib;
    requires kotlin.reflect;

    requires java.management;
    requires java.compiler;

    requires org.lwjgl;
    requires org.lwjgl.vulkan;

//    requires com.github.kotlin_graphics.gln;
    requires com.github.kotlin_graphics.gli;
    requires com.github.kotlin_graphics.glm;
    requires com.github.kotlin_graphics.kool;
    requires com.github.kotlin_graphics.kotlin_unsigned;
    requires jsr305;

    exports vkk;
    exports vkk.entities;
    exports vkk.extensionFunctions;
}