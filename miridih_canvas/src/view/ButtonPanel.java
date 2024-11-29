package view;

import controller.Controller;
import model.ShapeManager;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {

    public ButtonPanel(Controller controller, ShapeManager shapeManager) {
        // 레이아웃 설정
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        // shape 버튼 생성
        JButton rectangleButton = new JButton("직사각형 추가");
        JButton ellipseButton = new JButton("타원 추가");
        JButton lineButton = new JButton("선 추가");
        JButton textButton = new JButton("텍스트 추가");
        JButton imageButton = new JButton("이미지 추가");

        // z-order 버튼
        JButton moveZOrderForwardButton = new JButton("앞으로 보내기");
        JButton moveZOrderBackwardButton = new JButton("뒤로 보내기");
        JButton moveZOrderToMostFrontButton = new JButton("맨앞으로 보내기");
        JButton moveZOrderToMostBackButton = new JButton("맨뒤로 보내기");

        // 버튼을 패널에 추가
        this.add(rectangleButton);
        this.add(ellipseButton);
        this.add(lineButton);
        this.add(textButton);
        this.add(imageButton);
        this.add(moveZOrderForwardButton);
        this.add(moveZOrderBackwardButton);
        this.add(moveZOrderToMostFrontButton);
        this.add(moveZOrderToMostBackButton);
    }
}
