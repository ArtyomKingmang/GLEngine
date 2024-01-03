package com.kingmang.glengine;


import com.kingmang.glengine.display.Display;
import com.kingmang.glengine.display.Input;
import org.lwjgl.glfw.GLFW;


public class Main implements Runnable {
    public Thread game;
    public Display window;
    public final int WIDTH = 1280, HEIGHT = 760;

    public void start() {
        game = new Thread(this, "game");
        game.start();
    }

    public void init() {
        window = new Display(WIDTH, HEIGHT, "Game");
        window.create();
    }

    public void run() {
        init();
        while (!window.shouldClose()) {
            update();
            render();
            if (Input.isKeyDown(GLFW.GLFW_KEY_ESCAPE)) return;
        }
        window.destroy();
    }

    private void update() {
        window.update();
        if (Input.isButtonDown(GLFW.GLFW_MOUSE_BUTTON_LEFT)) System.out.println("X: " + Input.getMouseX() + ", Y: " + Input.getMouseY());
    }

    private void render() {
        window.swapBuffers();
    }

    public static void main(String[] args) {
        new Main().start();
    }
}