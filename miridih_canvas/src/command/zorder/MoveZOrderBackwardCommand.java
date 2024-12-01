package command.zorder;

import command.Command;
import model.ShapeInterface;
import model.ShapeManager;

public class MoveZOrderBackwardCommand implements Command {
    private ShapeManager shapeManager;
    private ShapeInterface shape;

    public MoveZOrderBackwardCommand(ShapeManager shapeManager, ShapeInterface shape) {
        this.shapeManager = shapeManager;
        this.shape = shape;
    }

    @Override
    public void execute() {
        shapeManager.moveZOrderBackward(shape);
    }

    @Override
    public void undo() {
        shapeManager.moveZOrderForward(shape);
    }

    @Override
    public boolean isUndoable() {
        return true;
    }
}