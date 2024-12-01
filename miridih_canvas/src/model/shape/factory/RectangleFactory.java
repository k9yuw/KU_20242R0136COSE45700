package model.shape.factory;

import model.ShapeInterface;
import model.shape.RectangleShape;

import java.awt.*;

public class RectangleFactory implements ShapeFactory {
    // 싱글톤 인스턴스
    private static RectangleFactory instance;

    // private 생성자
    private RectangleFactory() {}

    // 싱글톤 접근 메서드
    public static synchronized RectangleFactory getInstance() {
        if (instance == null) {
            instance = new RectangleFactory();
        }
        return instance;
    }

    @Override
    public ShapeInterface createShape(int x1, int y1, int x2, int y2, Color color) {
        return new RectangleShape(x1, y1, x2, y2, color);
    }
}