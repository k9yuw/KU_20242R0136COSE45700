package command.draw;

import model.ShapeManager;
import model.shape.factory.LineFactory;

import java.awt.*;

public class LineDrawCommand extends DrawCommand {
    public LineDrawCommand(ShapeManager shapeManager, int x1, int y1, int x2, int y2, Color color) {
        super(shapeManager, LineFactory.getInstance(), x1, y1, x2, y2, color);
    }
}