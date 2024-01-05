package com.kingmang.glengine.display;

import org.joml.Vector3f;

public class Vertex {

    private Vector3f pos;
    private Vector3f normal;
    private Vector3f ambientColour;
    private Vector3f diffuseColour;
    
    public Vertex(Vector3f pos, Vector3f ambientColour, 
            Vector3f diffuseColour) {
        this.pos = pos;
        this.ambientColour = ambientColour;
        this.diffuseColour = diffuseColour;
    }
    
    public Vector3f getPos() {
        return pos;
    }
    
    public Vector3f getNormal() {
        return normal;
    }
    
    public Vector3f getAmbientColour() {
        return ambientColour;
    }
    
    public Vector3f getDiffuseColour() {
        return diffuseColour;
    }

    public void setNormal(Vector3f normal) {
        this.normal = normal;
    }
    
}
