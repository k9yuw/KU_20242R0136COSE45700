package model.shape.factory;

import model.ShapeInterface;
import model.shape.EllipseShape;

import java.awt.*;

public class EllipseFactory implements ShapeFactory {
    // 싱글톤 인스턴스
    private static EllipseFactory instance;

    // private 생성자
    private EllipseFactory() {}

    // 싱글톤 접근 메서드
    public static synchronized EllipseFactory getInstance() {
        if (instance == null) {
            instance = new EllipseFactory();
        }
        return instance;
    }

    @Override
    public ShapeInterface createShape(int x1, int y1, int x2, int y2, Color color) {
        return new EllipseShape(x1, y1, x2, y2, color);
    }
}
