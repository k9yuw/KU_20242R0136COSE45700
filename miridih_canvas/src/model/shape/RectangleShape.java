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
        return String.valueOf(x1);
    }

    @Override
    public String getY() {
        return String.valueOf(y1);
    }

    @Override
    public void setX(int x) {
        x2 = x2 - x1 + x;
        x1 = x;
    }

    @Override
    public void setY(int y) {
        y2 = y2 - y1 + y;
        y1 = y;
    }

    @Override
    public String getWidth() {
        return String.valueOf(Math.abs(x2 - x1));
    }

    @Override
    public String getHeight() {
        return String.valueOf(Math.abs(y2 - y1));
    }

    @Override
    public void setWidth(int width) {
        x2 = x1 + width;
    }

    @Override
    public void setHeight(int height) {
        y2 = y1 + height;
    }
}
