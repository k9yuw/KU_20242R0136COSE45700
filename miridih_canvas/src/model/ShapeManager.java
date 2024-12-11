package model;

import model.shape.ShapeSelectionComposite;
import view.Observer;

import java.util.ArrayList;

public class ShapeManager implements Subject{

    public ShapeManager() {
    }

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

    public void removeShape(ShapeInterface shapeInterface) {
        if (shapes.remove(shapeInterface)) {
            // 만약 선택된 도형이라면 selection에서도 제거
            shapeSelection.removeAll();
            notifyObservers();
        }
    }

    // 기능 2: object를 multi select 할 수 있다.
    public void selectShape(int x, int y) {
        ShapeInterface shape = findShapeAt(x, y);
        if (shape == null) {
            clearSelection();
        } else {
            this.shapeSelection.selectShape(shape); // 다중 선택 로직은 Composite에서 처리
        }
        notifyObservers();
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

    // 기능 6: 도형의 z-order 조절
    public void sendSelectedToFront() {
        for(ShapeInterface shape : shapeSelection){
            shapes.remove(shape);
            shapes.add(0, shape);
        }
        notifyObservers();
    }

    public void sendSelectedToBack() {
        for(ShapeInterface shape : shapeSelection){
            shapes.remove(shape);
            shapes.add(shape);
        }
        notifyObservers();
    }
}
