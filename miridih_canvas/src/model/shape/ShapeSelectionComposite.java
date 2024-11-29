package model.shape;

import model.ShapeInterface;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class ShapeSelectionComposite implements ShapeInterface, Iterable<ShapeInterface>, Serializable {

    private ArrayList<ShapeInterface> shapes = new ArrayList<>();

    public ArrayList<ShapeInterface> getShapes(){
        return shapes;
    }

    public void removeAll(){
        shapes.clear();
    }

    @Override
    public Iterator<ShapeInterface> iterator() {
        return shapes.iterator();
    }

    public void selectShape(ShapeInterface shape) {
        if (shapes.contains(shape)) {
            // 이미 선택된 도형이라면 선택 해제
            shapes.remove(shape);
            shape.setBorder(null, 0);
        } else {
            // 선택되지 않은 도형이라면 새로 선택
            shapes.add(shape);
            shape.setBorder(Color.GRAY, 2);
        }
    }

    // ShapeInterface의 메서드 구현
    @Override
    public void draw(Graphics2D g2) {
        for (ShapeInterface shape : shapes) {
            shape.draw(g2);
        }
    }

    @Override
    public void move(int dx, int dy) {
        for (ShapeInterface shape : shapes) {
            shape.move(dx, dy);
        }
    }

    @Override
    public void setColor(Color color) {
        for (ShapeInterface shape : shapes) {
            shape.setColor(color);
        }
    }

    @Override
    public boolean contains(int x, int y) {
        for (ShapeInterface shape : shapes) {
            if (shape.contains(x, y)) return true;
        }
        return false;
    }


    @Override
    public String getX() {
        if (shapes.size() == 1) return shapes.get(0).getX();
        return "";
    }

    @Override
    public String getY() {
        if (shapes.size() == 1) return shapes.get(0).getY();
        return "";
    }

    @Override
    public void setX(int x) {
        if (shapes.size() == 1) shapes.get(0).setX(x);
    }

    @Override
    public void setY(int y) {
        if (shapes.size() == 1) shapes.get(0).setY(y);
    }

    @Override
    public String getWidth() {
        if (shapes.size() == 1) return shapes.get(0).getWidth();
        return "";
    }

    @Override
    public String getHeight() {
        if (shapes.size() == 1) return shapes.get(0).getHeight();
        return "";
    }

    @Override
    public void setWidth(int width) {
        if (shapes.size() == 1) {
            shapes.get(0).setWidth(width);
        }
    }

    @Override
    public void setHeight(int height) {
        if (shapes.size() == 1) shapes.get(0).setHeight(height);
    }


    @Override
    public void setBorder(Color borderColor, int borderThickness) {
        for (ShapeInterface shape : shapes) {
            shape.setBorder(borderColor, borderThickness);
        }
    }
}
