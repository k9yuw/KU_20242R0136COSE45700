package command.draw;

import model.ShapeManager;
import model.shape.factory.ImageFactory;

import java.awt.*;

public class ImageDrawCommand extends DrawCommand {
    public ImageDrawCommand(ShapeManager shapeManager, int x1, int y1, int x2, int y2, Color color) {
        super(shapeManager, ImageFactory.getInstance(), x1, y1, x2, y2, color);
    }
}