package command.change;

import command.Command;
import model.ShapeManager;

public class MoveSelectedShapesCommand implements Command {
    private ShapeManager shapeManager;
    private int dx, dy;

    public MoveSelectedShapesCommand(ShapeManager shapeManager, int dx, int dy) {
        this.shapeManager = shapeManager;
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public void execute() {
        shapeManager.moveSelectedShapes(dx, dy);
    }

    @Override
    public void undo() {
        shapeManager.moveSelectedShapes(-dx, -dy);
    }

    @Override
    public boolean isUndoable() {
        return true;
    }
}
