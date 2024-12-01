package model.shape.factory;

import model.ShapeInterface;
import model.shape.LineShape;

import java.awt.*;

public class LineFactory implements ShapeFactory {
    // 싱글톤 인스턴스
    private static LineFactory instance;

    // private 생성자
    private LineFactory() {}

    // 싱글톤 접근 메서드
    public static synchronized LineFactory getInstance() {
        if (instance == null) {
            instance = new LineFactory();
        }
        return instance;
    }

    @Override
    public ShapeInterface createShape(int x1, int y1, int x2, int y2, Color color) {
        return new LineShape(x1, y1, x2, y2, color);
    }
}
