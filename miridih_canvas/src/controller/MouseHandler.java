package controller;

import controller.state.EllipseDrawingState;
import controller.state.MouseHandlerState;
import model.ShapeManager;

import java.awt.*;
import java.awt.event.MouseEvent;

public class MouseHandler {

    private Color color = new Color(0,0,0);
    private MouseHandlerState state;
    public MouseHandler(ShapeManager shapeManager){
        state=new EllipseDrawingState(shapeManager);
    }

    public void setState(MouseHandlerState state) {
        this.state = state;
    }
    public void setColor(Color color) {
        this.color = color;
    }

    public void handleMouseDown(MouseEvent e){
        state.handleMouseDown(e, color);
    }
    public void handleMouseUp(MouseEvent e){
        state.handleMouseUp(e, color);
    }
    public void handleMouseClick(MouseEvent e){
        state.handleMouseClick(e, color);
    }
    public void handleMouseDrag(MouseEvent e){
        state.handleMouseDrag(e, color);
    }

}