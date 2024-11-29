package model;

import lombok.NoArgsConstructor;
import model.shape.ShapeSelectionComposite;
import view.Observer;

import java.util.ArrayList;
import java.util.Collections;

@NoArgsConstructor
public class ShapeManager implements Subject{

    private ArrayList<Observer> observers = new ArrayList<>();
    private ArrayList<ShapeInterface> shapes = new ArrayList<>();
    private ShapeSelectionComposite shapeSelection = new ShapeSelectionComposite();

    public ArrayList<ShapeInterface> getShapes() {
        return shapes;
    }

    // property panel에서 update 시 해당 메서드 호출하여 기능3 구현
    public ShapeSelectionComposite getShapeSelection() {
        return shapeSelection;
    }

    // 옵저버 패턴 메서드 구현
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    // 기능 1: object를 type별로 생성할 수 있다.
    public void addShape(ShapeInterface shapeInterface){
        shapes.add(shapeInterface);
        notifyObservers();
    }

    // 기능 2: object를 multi select 할 수 있다.
    public void selectShape(int x, int y) {
        ShapeInterface shape = findShapeAt(x, y);
        if (shape == null) {
            clearSelection();
        } else {
            this.shapeSelection.selectShape(shape); // 다중 선택 로직은 Composite에서 처리
        }
        notifyObservers(); // 변경 사항 알림
    }

    private ShapeInterface findShapeAt(int x, int y) {
        for(ShapeInterface shape : shapes){
            if(shape.contains(x, y)) return shape;
        }
        return null;
    }

    private void clearSelection(){
        this.shapeSelection.removeAll();
    }

    // 기능 4-1: object의 위치를 조절할 수 있다.
    public void moveSelectedShapes(int dx, int dy){
        this.shapeSelection.move(dx, dy);
        notifyObservers();
    }

    // 기능 4-2: object의 크기를 조절할 수 있다.
    public void resizeSelectedShapes(int width, int height){
        this.shapeSelection.setWidth(width);
        this.shapeSelection.setHeight(height);
        notifyObservers();
    }

    // 기능 6-1: 선택된 도형의 순서 한 칸 앞으로 이동
    public void moveZOrderForward(ShapeInterface shape) {
        int index = shapes.indexOf(shape);
        if (index >= 0 && index < shapes.size() - 1) {
            Collections.swap(shapes, index, index + 1); // 현재 위치와 다음 위치를 스왑
            notifyObservers();
        }
    }

    // 기능 6-2: 선택된 도형의 순서 한 칸 앞으로 이동
    public void moveZOrderBackward(ShapeInterface shape) {
        int index = shapes.indexOf(shape);
        if (index > 0) {
            Collections.swap(shapes, index, index - 1); // 현재 위치와 이전 위치를 스왑
            notifyObservers();
        }
    }

    // 기능 6-3: 선택된 도형의 순서 맨 앞으로 이동
    public void moveZOrderToMostFront(ShapeInterface shape) {
        if (shapes.remove(shape)) {
            shapes.add(0, shape); // 리스트의 첫 번째 위치로 이동
            notifyObservers();
        }
    }

    // 기능 6-4: 선택된 도형의 순서 맨 뒤로 이동
    public void moveZOrderToMostBack(ShapeInterface shape) {
        if (shapes.remove(shape)) {
            shapes.add(shape);
            notifyObservers();
        }
    }
}
