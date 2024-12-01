package command.change;

import command.Command;
import model.ShapeManager;

public class ResizeSelectedShapesCommand implements Command {
    private ShapeManager shapeManager;
    private int width, height;

    public ResizeSelectedShapesCommand(ShapeManager shapeManager, int width, int height) {
        this.shapeManager = shapeManager;
        this.width = width;
        this.height = height;
    }

    @Override
    public void execute() {
        shapeManager.resizeSelectedShapes(width, height);
    }

    @Override
    public void undo() {
        shapeManager.resizeSelectedShapes(-width, -height);
    }

    @Override
    public boolean isUndoable() {
        return true;
    }
}
