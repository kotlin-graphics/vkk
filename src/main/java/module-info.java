module com.github.kotlin_graphics.vkk {

    requires kotlin.stdlib;

    requires java.management;

    requires org.lwjgl;

    requires com.github.kotlin_graphics.gln;
    requires com.github.kotlin_graphics.gli;
    requires com.github.kotlin_graphics.glm;
    requires com.github.kotlin_graphics.kool;
    requires com.github.kotlin_graphics.kotlin_unsigned;

    exports vkk;
    exports vkk.entities;
    exports vkk.extensionFunctions;
}