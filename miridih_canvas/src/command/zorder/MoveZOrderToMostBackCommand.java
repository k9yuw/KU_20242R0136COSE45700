package command.zorder;

import command.Command;
import model.ShapeInterface;
import model.ShapeManager;

public class MoveZOrderToMostBackCommand implements Command {
    private ShapeManager shapeManager;
    private ShapeInterface shape;

    public MoveZOrderToMostBackCommand(ShapeManager shapeManager, ShapeInterface shape) {
        this.shapeManager = shapeManager;
        this.shape = shape;
    }

    @Override
    public void execute() {
        shapeManager.moveZOrderToMostBack(shape);
    }

    @Override
    public void undo() {
        shapeManager.moveZOrderToMostFront(shape);
    }

    @Override
    public boolean isUndoable() {
        return true;
    }
}