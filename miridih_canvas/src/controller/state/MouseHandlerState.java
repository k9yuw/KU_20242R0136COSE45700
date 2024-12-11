package controller.state;

import model.ShapeManager;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class MouseHandlerState {
    protected ShapeManager shapeManager;

    public MouseHandlerState(ShapeManager shapeManager){
        this.shapeManager = shapeManager;
    }

    public abstract void handleMouseDown(MouseEvent e, Color color);
    public abstract void handleMouseClick(MouseEvent e, Color color);
    public abstract void handleMouseUp(MouseEvent e, Color color);
    public abstract void handleMouseDrag(MouseEvent e, Color color);
}
