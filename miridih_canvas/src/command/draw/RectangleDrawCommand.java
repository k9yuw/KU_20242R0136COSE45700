package command.draw;

import model.ShapeManager;
import model.shape.factory.RectangleFactory;

import java.awt.*;

public class RectangleDrawCommand extends DrawCommand {
    public RectangleDrawCommand(ShapeManager shapeManager, int x1, int y1, int x2, int y2, Color color) {
        super(shapeManager, RectangleFactory.getInstance(), x1, y1, x2, y2, color);
    }
}
