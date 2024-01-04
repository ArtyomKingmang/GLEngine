package com.kingmang.glengine.objects;

import com.kingmang.glengine.display.Window;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL33;

public class Triangle{
    static float[] vertices = new float[9];
    static int vbo;
    static int vao;

    public Triangle(float[] vertices){
        this.vertices = vertices;
    }
    public static void init(){
        int vbo = GL15.glGenBuffers();
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER,vbo);
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, vertices, GL15.GL_STATIC_DRAW);

        int vao = GL33.glGenVertexArrays();
        GL33.glBindVertexArray(vao);
        GL20.glVertexAttribPointer(0,3, GL11.GL_FLOAT, false, 0,0);
    }

    public static void draw(){
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
        GL20.glEnableVertexAttribArray(0);
        GL11.glDrawArrays(GL11.GL_TRIANGLES,0,3);
    }

    public static void destroy(){
        GL15.glDeleteBuffers(vbo);
        GL33.glDeleteVertexArrays(vao);
    }
}