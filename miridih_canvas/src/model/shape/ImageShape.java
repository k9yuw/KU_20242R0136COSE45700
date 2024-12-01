package model.shape;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageShape extends AbstractShape {

    private int x, y, width, height;
    private BufferedImage image;

    public ImageShape(int x1, int y1, int x2, int y2, Color color, BufferedImage image) {
        super(x1, y1, x2, y2, color);

        this.x = Math.min(x1, x2);
        this.y = Math.min(y1, y2);
        this.width = Math.abs(x2 - x1);
        this.height = Math.abs(y2 - y1);
        this.image = image;
    }

    @Override
    public void draw(Graphics2D g2) {
        if (image != null) {
            g2.drawImage(image, x, y, width, height, null);
        }
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