package com.kingmang.glengine.objects;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL33;

public class Square implements Object {
    static float[] vertices = new float[] {
            -0.5f, 0.5f, 0.0f,  // Верхний левый угол
            -0.5f, -0.5f, 0.0f, // Нижний левый угол
            0.5f, -0.5f, 0.0f,  // Нижний правый угол
            0.5f, 0.5f, 0.0f    // Верхний правый угол
    };
    static int vbo;
    static int vao;

    public Square(float[] vertices){
        this.vertices = vertices;
    }

    @Override
    public void init(){
        vbo = GL15.glGenBuffers();
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vbo);
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, vertices, GL15.GL_STATIC_DRAW);

        vao = GL33.glGenVertexArrays();
        GL33.glBindVertexArray(vao);
        GL20.glVertexAttribPointer(0, 3, GL11.GL_FLOAT, false, 0, 0);
    }

    @Override
    public void draw(){
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
        GL20.glEnableVertexAttribArray(0);
        GL11.glDrawArrays(GL11.GL_QUADS, 0, 4);
    }

    @Override
    public void destroy(){
        GL15.glDeleteBuffers(vbo);
        GL33.glDeleteVertexArrays(vao);
    }
}