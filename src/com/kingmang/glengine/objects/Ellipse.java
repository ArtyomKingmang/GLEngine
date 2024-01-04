package com.kingmang.glengine.objects;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL33;

public class Ellipse implements Object {
    static float[] vertices = new float[12];
    static int vbo;
    static int vao;

    public Ellipse(float x, float y, float width, float height) {
        // Вычисляем вершины эллипса
        int segments = 30; // Количество сегментов для аппроксимации эллипса
        float[] ellipseVertices = new float[segments * 2];
        for (int i = 0; i < segments; i++) {
            float angle = (float) (2 * Math.PI * i / segments);
            ellipseVertices[i * 2] = (float) (x + Math.cos(angle) * width / 2);
            ellipseVertices[i * 2 + 1] = (float) (y + Math.sin(angle) * height / 2);
        }
        this.vertices = ellipseVertices;
    }

    @Override
    public void init() {
        vbo = GL15.glGenBuffers();
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vbo);
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, vertices, GL15.GL_STATIC_DRAW);

        vao = GL33.glGenVertexArrays();
        GL33.glBindVertexArray(vao);
        GL20.glVertexAttribPointer(0, 2, GL11.GL_FLOAT, false, 0, 0);
    }

    @Override
    public void draw() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
        GL20.glEnableVertexAttribArray(0);
        GL11.glDrawArrays(GL11.GL_TRIANGLE_FAN, 0, vertices.length / 2);
    }

    @Override
    public void destroy() {
        GL15.glDeleteBuffers(vbo);
        GL33.glDeleteVertexArrays(vao);
    }
}