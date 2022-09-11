package yurev.lab3;

import java.util.ArrayList;
import java.util.List;

public final class Scene {
    private List<Shape> shapes = new ArrayList<Shape>();
    private static Scene scene = new Scene();

    public static Scene getScene() {
        return scene;
        
    }

    private Scene() {
    }
    
    public List<Shape> getShapes() {
        return shapes;
    }
    
    public void add(Shape shape) {
        shapes.add(shape);
    }
    
    public void draw() {
        System.out.println("Scene contains:");
        for(int i = 0;i < scene.shapes.size();i++) {
            scene.shapes.get(i).draw();
        }
        
    }
    
}
