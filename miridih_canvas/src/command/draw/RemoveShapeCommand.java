package command.draw;

import command.Command;
import model.ShapeInterface;
import model.ShapeManager;

public class RemoveShapeCommand implements Command {
    private ShapeManager shapeManager;
    private ShapeInterface shape;

    public RemoveShapeCommand(ShapeManager shapeManager, ShapeInterface shape) {
        this.shapeManager = shapeManager;
        this.shape = shape;
    }

    @Override
    public void execute() {
        shapeManager.removeShape(shape);
    }

    @Override
    public void undo() {
        shapeManager.addShape(shape);
    }

    @Override
    public boolean isUndoable() {
        return true;
    }
}

