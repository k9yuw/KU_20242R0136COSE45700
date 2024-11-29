package controller;

import model.ShapeManager;

import java.awt.event.MouseAdapter;

public class Controller extends MouseAdapter {

    private ShapeManager shapeManager;
    private MouseHandler mouseHandler;

    public Controller(ShapeManager shapeManager){
        this.mouseHandler = new MouseHandler(shapeManager);
    }

    public void move(int x, int y){
    }

    public void resize(int width, int height) {
    }
}
