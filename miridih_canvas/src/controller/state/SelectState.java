package controller.state;

import command.CommandInvoker;
import command.change.MoveSelectedShapesCommand;
import command.select.SelectShapeCommand;
import model.ShapeManager;

import java.awt.*;
import java.awt.event.MouseEvent;

public class SelectState extends MouseHandlerState {
    public SelectState(ShapeManager shapeManager){
        super(shapeManager);
    }
    int mouseStartX, mouseStartY;
    @Override
    public void handleMouseDown(MouseEvent e, Color color) {
        mouseStartX =  e.getX();
        mouseStartY = e.getY();
        System.out.println("SelectState: handleMouseDown: Start (" + mouseStartX + ", " + mouseStartY + ")");
    }
    @Override
    public void handleMouseClick(MouseEvent e, Color color){
        int x = e.getX();
        int y = e.getY();
        
        SelectShapeCommand selectCommand = new SelectShapeCommand(shapeManager, x, y);
        CommandInvoker.getInstance().executeCommand(selectCommand);
        System.out.println(shapeManager.getShapeSelection());
    };
    @Override
    public void handleMouseUp(MouseEvent e, Color color) {
    }

    @Override
    public void handleMouseDrag(MouseEvent e, Color color) {

        MoveSelectedShapesCommand moveCommand = new MoveSelectedShapesCommand(shapeManager, mouseStartX, mouseStartY, e.getX(), e.getY());
        CommandInvoker.getInstance().executeCommand(moveCommand);
        mouseStartX = e.getX();
        mouseStartY=e.getY();
    }


}
