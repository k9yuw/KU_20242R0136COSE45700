package command.draw;

import command.Command;
import model.ShapeManager;
import model.ShapeInterface;

public abstract class DrawCommand implements Command {
    protected ShapeManager shapeManager;
    protected ShapeInterface shape;

    public DrawCommand(ShapeManager shapeManager) {
        this.shapeManager = shapeManager;
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

