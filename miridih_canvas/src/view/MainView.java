package view;

import controller.Controller;
import model.ShapeManager;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    private CanvasPanel canvasPanel;
    private PropertyPanel propertyPanel;
    private ButtonPanel buttonPanel;
    private ShapeManager shapeManager;

    public MainView(ShapeManager shapeManager) {
        canvasPanel = new CanvasPanel(shapeManager);
        this.shapeManager = shapeManager;
    }

    public void initialize(Controller controller) {
        setLayout(new BorderLayout());
        setTitle("FULL HOUSE");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // CanvasPanel 설정
        canvasPanel.setBackground(Color.WHITE);
        canvasPanel.addMouseListener(controller);
        canvasPanel.addMouseMotionListener(controller);
        add(canvasPanel, BorderLayout.CENTER);

        // PropertyPanel 추가
        propertyPanel = new PropertyPanel(controller, shapeManager);
        add(propertyPanel, BorderLayout.EAST);

        // ButtonPanel 추가
        buttonPanel = new ButtonPanel(controller, shapeManager);
        add(buttonPanel, BorderLayout.NORTH);

        setVisible(true);
    }
}
