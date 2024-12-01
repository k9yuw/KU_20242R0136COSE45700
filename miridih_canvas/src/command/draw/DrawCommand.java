package command.draw;

import command.Command;
import model.ShapeManager;
import model.ShapeInterface;
import model.shape.factory.ShapeFactory;

import java.awt.*;

public abstract class DrawCommand implements Command {
    protected ShapeManager shapeManager;
    protected ShapeInterface shape;

    public DrawCommand(ShapeManager shapeManager, ShapeFactory factory, int x1, int y1, int x2, int y2, Color color) {
        this.shapeManager = shapeManager;
        this.shape = factory.createShape(x1, y1, x2, y2, color);
    }

    @Override
    public void execute() {
        shapeManager.addShape(shape);
    }

    @Override
    public void undo() {
        shapeManager.removeShape(shape);
    }

    @Override
    public boolean isUndoable() {
        return true;
    }
}

