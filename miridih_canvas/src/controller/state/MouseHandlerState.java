package controller.state;

import model.ShapeManager;

public abstract class MouseHandlerState {
    protected ShapeManager shapeManager;

    public MouseHandlerState(ShapeManager shapeManager){
        this.shapeManager = shapeManager;
    }
}
