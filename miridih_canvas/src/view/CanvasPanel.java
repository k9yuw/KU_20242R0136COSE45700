package view;

import model.ShapeInterface;
import model.ShapeManager;

import javax.swing.*;
import java.awt.*;

public class CanvasPanel extends JPanel implements Observer {
    private ShapeManager shapeManager;
    public CanvasPanel(ShapeManager shapeManager){
        this.shapeManager = shapeManager;
        shapeManager.addObserver(this);
    }

    @Override
    public void update() {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        for(ShapeInterface shape: this.shapeManager.getShapes()) {
            shape.draw(graphics2D);
        }
    }
}
