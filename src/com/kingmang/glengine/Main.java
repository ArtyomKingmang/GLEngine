package com.kingmang.glengine;
import com.kingmang.glengine.display.Window;
import com.kingmang.glengine.objects.Object;
import com.kingmang.glengine.objects.Ellipse;
import org.lwjgl.opengl.GL;

public class Main {

    public static void main(String[] args) {
        Window display = new Window(500, 500, "title");
        display.create();
        GL.createCapabilities();
        display.background();
        Object ellipse = new Ellipse(0.0f, 0.0f, 0.5f, 0.3f); // Создаем эллипс с центром в (0, 0) и размерами 0.5x0.3
        ellipse.init();

        // Основной цикл отрисовки
        while (!display.shouldClose()) {
            display.update();
            ellipse.draw();
            display.swapBuffers();
        }
        ellipse.destroy();
        display.destroy();
    }
}