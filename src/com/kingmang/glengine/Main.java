package com.kingmang.glengine;
import com.kingmang.glengine.display.Window;
import com.kingmang.glengine.objects.Object;
import com.kingmang.glengine.objects.Ellipse;
import com.kingmang.glengine.objects.Square;
import org.lwjgl.opengl.GL;


import com.kingmang.glengine.display.Window;
import com.kingmang.glengine.objects.Object;
import com.kingmang.glengine.objects.Square;
import org.lwjgl.opengl.GL;

public class Main {

    public static float[] vertices = {
            -0.5f, 0.5f, 0.0f,
            -0.5f, -0.5f, 0.0f,
            0.5f, -0.5f, 0.0f,
            0.5f, 0.5f, 0.0f
    };

    public static void main(String[] args) {
        Window display = new Window(500, 500, "title");
        display.create();
        GL.createCapabilities();
        display.background(0,0,1.0f,0);
        Object square = new Square(vertices);
        square.init();

        // Основной цикл отрисовки
        while (!display.shouldClose()) {
            display.update();
            square.draw();
            display.swapBuffers();
        }
        square.destroy();
        display.destroy();
    }
}