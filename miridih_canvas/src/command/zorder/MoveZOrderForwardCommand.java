package command.zorder;

import command.Command;
import model.ShapeManager;

public class MoveZOrderForwardCommand implements Command {
    private ShapeManager shapeManager;

    public MoveZOrderForwardCommand(ShapeManager shapeManager) {
        this.shapeManager = shapeManager;
    }

    @Override
    public void execute() {
        shapeManager.sendSelectedToFront();
    }

    @Override
    public void undo() {
        shapeManager.sendSelectedToBack();
    }

    @Override
    public boolean isUndoable() {
        return true;
    }
}
