package command.zorder;

import command.Command;
import model.ShapeInterface;
import model.ShapeManager;

public class MoveZOrderForwardCommand implements Command {
    private ShapeManager shapeManager;
    private ShapeInterface shape;

    public MoveZOrderForwardCommand(ShapeManager shapeManager, ShapeInterface shape) {
        this.shapeManager = shapeManager;
        this.shape = shape;
    }

    @Override
    public void execute() {
        shapeManager.moveZOrderForward(shape);
    }

    @Override
    public void undo() {
        shapeManager.moveZOrderBackward(shape);
    }

    @Override
    public boolean isUndoable() {
        return true;
    }
}
