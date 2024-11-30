package model.shape;

import java.awt.*;

public class RectangleShape extends AbstractShape {

    private int x, y, width, height;

    public RectangleShape(int x1, int y1, int x2, int y2, Color color) {
        super(x1, y1, x2, y2, color);

        this.x = Math.min(x1, x2);
        this.y = Math.min(y1, y2);
        width = Math.abs(x2 - x1);
        height = Math.abs(y2- y1);
    }

    @Override
    public void draw(Graphics2D g2) {
        int minX = Math.min(x1, x2);
        int minY = Math.min(y1, y2);
        int width = Math.abs(x2 - x1);
        int height = Math.abs(y2 - y1);

        g2.drawRect(minX, minY, width, height);
    }

    @Override
    public String getX() {
        return String.valueOf(x);
    }

    @Override
    public String getY() {
        return String.valueOf(y);
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String getWidth() {
        return String.valueOf(width);
    }

    @Override
    public String getHeight() {
        return String.valueOf(height);
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }
}
