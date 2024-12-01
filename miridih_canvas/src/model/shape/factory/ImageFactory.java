package model.shape.factory;

import model.ShapeInterface;
import model.shape.ImageShape;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageFactory implements ShapeFactory {
    // 싱글톤 인스턴스
    private static ImageFactory instance;

    // private 생성자
    private ImageFactory() {}

    // 싱글톤 접근 메서드
    public static synchronized ImageFactory getInstance() {
        if (instance == null) {
            instance = new ImageFactory();
        }
        return instance;
    }

    @Override
    public ShapeInterface createShape(int x1, int y1, int x2, int y2, Color color) {
        BufferedImage image = loadDefaultImage();
        return new ImageShape(x1, y1, x2, y2, color, image);
    }

    private BufferedImage loadDefaultImage() {
        try {
            // 기본 이미지 파일 경로 지정
            return ImageIO.read(new File("path/to/default/image.png"));
        } catch (IOException e) {
            System.err.println("기본 이미지를 찾을 수 없어서 임시 이미지를 생성합니다.");
            return createPlaceholderImage();
        }
    }

    private BufferedImage createPlaceholderImage() {
        int width = 100;
        int height = 100;
        BufferedImage placeholder = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = placeholder.createGraphics();

        g2.setColor(Color.LIGHT_GRAY);
        g2.fillRect(0, 0, width, height);
        g2.setColor(Color.BLACK);
        g2.drawString("Image", 25, 50);

        g2.dispose();
        return placeholder;
    }
}
