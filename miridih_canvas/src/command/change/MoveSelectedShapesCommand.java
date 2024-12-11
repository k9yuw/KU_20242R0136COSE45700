package command.change;

import command.Command;
import model.ShapeManager;

public class MoveSelectedShapesCommand implements Command {
    private ShapeManager shapeManager;
    private int dx, dy;

    public MoveSelectedShapesCommand(ShapeManager shapeManager, int x1, int y1, int x2, int y2){
        this.shapeManager = shapeManager;
        this.dx= x2 - x1;
        this.dy = y2 - y1;
    }
    public MoveSelectedShapesCommand(ShapeManager shapeManager, int x, int y){
        this.shapeManager = shapeManager;
        this.dx =  x - Integer.parseInt(shapeManager.getShapeSelection().getX());
        this.dy=  y - Integer.parseInt(shapeManager.getShapeSelection().getY()) ;
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
