import controller.Controller;
import model.ShapeManager;
import view.MainView;

public class Main {
    public static void main(String[] args) {

        ShapeManager shapeManager = new ShapeManager();
        Controller controller = new Controller(shapeManager);
        MainView mainView = new MainView(shapeManager);

        mainView.initialize(controller);
    }
}