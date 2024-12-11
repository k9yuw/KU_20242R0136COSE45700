package controller.state;

import command.CommandInvoker;
import command.draw.LineDrawCommand;
import model.ShapeManager;

import java.awt.*;
import java.awt.event.MouseEvent;

public class LineDrawingState extends MouseHandlerState {

    public LineDrawingState(ShapeManager shapeManager) {
        super(shapeManager);
    }

    private int x1;
    private int y1;

    @Override
    public void handleMouseDown(MouseEvent e, Color color) {
        x1 = e.getX();
        y1 = e.getY();
    }

    @Override
    public void handleMouseUp(MouseEvent e, Color color) {
        int x2 = e.getX();
        int y2 = e.getY();

        LineDrawCommand lineDrawCommand = new LineDrawCommand(shapeManager, x1, y1, x2, y2, color);
        CommandInvoker.getInstance().executeCommand(lineDrawCommand);
    }

    @Override
    public void handleMouseClick(MouseEvent e, Color color) {
    }

    @Override
    public void handleMouseDrag(MouseEvent e, Color color) {
    }
}
