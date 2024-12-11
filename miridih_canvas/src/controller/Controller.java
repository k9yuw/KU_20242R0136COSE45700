package controller;

import command.change.MoveSelectedShapesCommand;
import command.change.ResizeSelectedShapesCommand;
import command.zorder.MoveZOrderBackwardCommand;
import command.zorder.MoveZOrderForwardCommand;
import controller.state.MouseHandlerState;
import model.ShapeManager;
import command.CommandInvoker;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controller extends MouseAdapter {

    private ShapeManager shapeManager;
    private MouseHandler mouseHandler;

    public Controller(ShapeManager shapeManager){
        this.shapeManager = shapeManager;
        this.mouseHandler = new MouseHandler(shapeManager);
    }

    public void setColor(Color color){
        mouseHandler.setColor(color);
    }

    public void setState(MouseHandlerState state){

        System.out.println("Changing state to: " + state);
        mouseHandler.setState(state);
    }

    @Override
    public void mousePressed(MouseEvent e){
        mouseHandler.handleMouseDown(e);
    }

    @Override
    public void mouseReleased(MouseEvent e){
        mouseHandler.handleMouseUp(e);
    }

    @Override
    public void mouseClicked(MouseEvent e){
        mouseHandler.handleMouseClick(e);
    }

    @Override
    public void mouseDragged(MouseEvent e){
        mouseHandler.handleMouseDrag(e);
    }
    public void bringSelectedToFront() {

        MoveZOrderForwardCommand cmd = new MoveZOrderForwardCommand(shapeManager);
        CommandInvoker.getInstance().executeCommand(cmd);
    }

    public void sendSelectedToBack() {

        MoveZOrderBackwardCommand cmd = new MoveZOrderBackwardCommand(shapeManager);
        CommandInvoker.getInstance().executeCommand(cmd);
    }

    public void move(int x, int y){
        MoveSelectedShapesCommand moveCommand = new MoveSelectedShapesCommand(shapeManager, x, y);
        CommandInvoker.getInstance().executeCommand(moveCommand);
    }

    public void resize(int width, int height) {
        ResizeSelectedShapesCommand resizeCommand = new ResizeSelectedShapesCommand(shapeManager, width, height);
        CommandInvoker.getInstance().executeCommand(resizeCommand);
    }
}
