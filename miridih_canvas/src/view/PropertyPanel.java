package view;

import controller.Controller;
import model.ShapeInterface;
import model.ShapeManager;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class PropertyPanel extends JPanel implements Observer {
    private JTextField xField;
    private JTextField yField;
    private JTextField widthField;
    private JTextField heightField;
    private ShapeManager shapeManager;

    public PropertyPanel(Controller controller, ShapeManager shapeManager) {
        this.shapeManager = shapeManager;
        shapeManager.addObserver(this);

        JLabel xLabel = new JLabel("X:");
        xField = new JTextField(10);
        xField.getDocument().addDocumentListener(createDocumentListener(() -> {
            int x = parseSafeInt(xField.getText());
            int y = parseSafeInt(yField.getText());
            controller.move(x, y);
        }));

        JLabel yLabel = new JLabel("Y:");
        yField = new JTextField(10);
        yField.getDocument().addDocumentListener(createDocumentListener(() -> {
            int x = parseSafeInt(xField.getText());
            int y = parseSafeInt(yField.getText());
            controller.move(x, y);
        }));

        JLabel widthLabel = new JLabel("Width:");
        widthField = new JTextField(10);
        widthField.getDocument().addDocumentListener(createDocumentListener(() -> {
            int width = parseSafeInt(widthField.getText());
            int height = parseSafeInt(heightField.getText());
            controller.resize(width, height);
        }));

        JLabel heightLabel = new JLabel("Height:");
        heightField = new JTextField(10);
        heightField.getDocument().addDocumentListener(createDocumentListener(() -> {
            int width = parseSafeInt(widthField.getText());
            int height = parseSafeInt(heightField.getText());
            controller.resize(width, height);
        }));

        // 레이아웃 그룹 정의
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(xLabel)
                                .addComponent(yLabel)
                                .addComponent(widthLabel)
                                .addComponent(heightLabel))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(xField)
                                .addComponent(yField)
                                .addComponent(widthField)
                                .addComponent(heightField))
        );

        // Define vertical group
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(xLabel)
                                .addComponent(xField))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(yLabel)
                                .addComponent(yField))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(widthLabel)
                                .addComponent(widthField))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(heightLabel)
                                .addComponent(heightField))
        );
    }


    @Override
    public void update() {
        ShapeInterface shape = shapeManager.getShapeSelection();

        xField.setText(String.valueOf(shape.getX()));
        yField.setText(String.valueOf(shape.getY()));
        widthField.setText(String.valueOf(shape.getWidth()));
        heightField.setText(String.valueOf(shape.getHeight()));
    }

    // DocumentListener 생성 메서드
    private DocumentListener createDocumentListener(Runnable onChange) {
        return new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                onChange.run();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                onChange.run();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                onChange.run();
            }
        };
    }

    // 안전하게 정수 변환 (빈 값은 0으로 처리)
    private int parseSafeInt(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
