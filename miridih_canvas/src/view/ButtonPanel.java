package view;

import controller.Controller;
import controller.state.EllipseDrawingState;
import controller.state.LineDrawingState;
import controller.state.RectangleDrawingState;
import controller.state.SelectState;
import model.ShapeManager;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {

    public ButtonPanel(Controller controller, ShapeManager shapeManager) {
        // 레이아웃 설정
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        // shape 버튼 생성
        JPanel buttonPanel = new JPanel();
        JButton rectangleButton  =new JButton("Rectangle");
        rectangleButton.addActionListener(e->controller.setState(new RectangleDrawingState(shapeManager)));

        JButton ellipseButton  =new JButton("Ellipse");
        ellipseButton.addActionListener(e->controller.setState(new EllipseDrawingState(shapeManager)));

        JButton lineButton  =new JButton("Line");
        lineButton.addActionListener(e->controller.setState(new LineDrawingState(shapeManager)));

        JButton selectButton  =new JButton("Select");
        selectButton.addActionListener(e->controller.setState(new SelectState(shapeManager)));

        // z-order 버튼
        JButton bringToFrontButton = new JButton("Bring to Front");
        bringToFrontButton.addActionListener(e -> {
            controller.bringSelectedToFront();
        });

        JButton sendToBackButton = new JButton("Send to Back");
        sendToBackButton.addActionListener(e -> {
            controller.sendSelectedToBack();
        });

        // 버튼을 패널에 추가
        this.add(rectangleButton);
        this.add(ellipseButton);
        this.add(lineButton);
        this.add(selectButton);
        this.add(bringToFrontButton);
        this.add(sendToBackButton);
    }
}
