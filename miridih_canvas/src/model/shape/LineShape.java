package model.shape;

import java.awt.*;

public class LineShape extends AbstractShape {

    private int x1, y1, x2, y2;

    public LineShape(int x1, int y1, int x2, int y2, Color color) {
        super(x1, y1, x2, y2, color);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.drawLine(x1, y1, x2, y2);
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
        int dx = x - x1;
        this.x1 = x;
        this.x2 += dx;
    }

    @Override
    public void setY(int y) {
        int dy = y - y1;
        this.y1 = y;
        this.y2 += dy;
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
        this.x2 = x1 + width;
    }

    @Override
    public void setHeight(int height) {
        this.y2 = y1 + height;
    }
}