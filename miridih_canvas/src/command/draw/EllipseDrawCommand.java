package command.draw;

import model.ShapeManager;
import model.shape.factory.EllipseFactory;

import java.awt.*;

public class EllipseDrawCommand extends DrawCommand {
    public EllipseDrawCommand(ShapeManager shapeManager, int x1, int y1, int x2, int y2, Color color) {
        super(shapeManager, EllipseFactory.getInstance(), x1, y1, x2, y2, color);
    }
}