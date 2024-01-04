package com.kingmang.glengine;
import com.kingmang.glengine.display.Window;
import com.kingmang.glengine.objects.Triangle;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL33;

public class Main {

    public static float[] vertices = {
            -0.5f, -0.5f, 0.0f,
            0.5f, -0.5f, 0.0f,
            0.0f, 0.5f, 0.0f,
    };
    public static void main(String[] args) {
        Window display = new Window(500, 500, "title");
        display.create();
        GL.createCapabilities();
        display.background();
        Triangle triangle = new Triangle(vertices);
        triangle.init();

        // Основной цикл отрисовки
        while (!display.shouldClose()) {
            display.update();
            triangle.draw();
            display.swapBuffers();

        }
        triangle.destroy();
        display.destroy();

    }
}