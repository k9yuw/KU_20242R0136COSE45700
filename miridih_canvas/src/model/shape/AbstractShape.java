package model.shape;

import model.ShapeInterface;

import java.awt.*;

public abstract class AbstractShape implements ShapeInterface {
    protected int x1, y1, x2, y2;
    protected Color color;
    protected Color borderColor;
    protected int borderThickness;

    public AbstractShape(int x1, int y1, int x2, int y2, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
        this.borderColor = null;
        this.borderThickness = 0;
    }

    @Override
    public void move(int dx, int dy) {
        x1 += dx;
        y1 += dy;
        x2 += dx;
        y2 += dy;
    }

    @Override
    public boolean contains(int x, int y) {
        int minX = Math.min(x1, x2);
        int minY = Math.min(y1, y2);
        int maxX = Math.max(x1, x2);
        int maxY = Math.max(y1, y2);
        return minX < x && x < maxX && minY < y && y < maxY;
    }

    @Override
    public void setBorder(Color borderColor, int borderThickness) {
        this.borderColor = borderColor;
        this.borderThickness = borderThickness;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }
}
