package command.select;

import command.Command;
import model.ShapeManager;

public class SelectShapeCommand implements Command {
    private ShapeManager shapeManager;
    private int x, y;

    public SelectShapeCommand(ShapeManager shapeManager, int x, int y) {
        this.shapeManager = shapeManager;
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        shapeManager.selectShape(x, y);
    }

    @Override
    public void undo() {
        // SelectShapeCommand는 Undo 불가능
    }

    @Override
    public boolean isUndoable() {
        return false;
    }
}

