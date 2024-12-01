package command.zorder;

import command.Command;
import model.ShapeInterface;
import model.ShapeManager;

public class MoveZOrderToMostFrontCommand implements Command {
    private ShapeManager shapeManager;
    private ShapeInterface shape;

    public MoveZOrderToMostFrontCommand(ShapeManager shapeManager, ShapeInterface shape) {
        this.shapeManager = shapeManager;
        this.shape = shape;
    }

    @Override
    public void execute() {
        shapeManager.moveZOrderToMostFront(shape);
    }

    @Override
    public void undo() {
        shapeManager.moveZOrderToMostBack(shape);
    }

    @Override
    public boolean isUndoable() {
        return true;
    }
}
