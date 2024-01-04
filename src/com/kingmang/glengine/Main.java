package com.kingmang.glengine;


import com.kingmang.glengine.display.Display;

public class Main {
    public static void main(String[] args){
        //Создание экрана
        Display display = new Display(500,500, "title");
        display.create();

        //Обновление экрана
        while(!display.shouldClose()){
            display.update();
            display.swapBuffers();
        }


    }

}