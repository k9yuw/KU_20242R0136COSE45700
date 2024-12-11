package command.zorder;

import command.Command;
import model.ShapeInterface;
import model.ShapeManager;

public class MoveZOrderBackwardCommand implements Command {
    private ShapeManager shapeManager;

    public MoveZOrderBackwardCommand(ShapeManager shapeManager) {
        this.shapeManager = shapeManager;
    }

    @Override
    public void execute() {
        shapeManager.sendSelectedToBack();
    }

    @Override
    public void undo() {
        shapeManager.sendSelectedToFront();
    }

    @Override
    public boolean isUndoable() {
        return true;
    }
}