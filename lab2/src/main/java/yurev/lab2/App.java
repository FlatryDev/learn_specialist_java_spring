package yurev.lab2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import yurev.lab2.Point;

@ComponentScan("yurev.lab2")
public class App {

    public static void main(String[] args) {
        try (
          AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(App.class)
        ) {
            Point point = ac.getBean(Point.class);
            Circle circle = ac.getBean(Circle.class);
            Circle circle2 = ac.getBean(Circle.class);

            circle2.setCenter(new Coords(77,88));
            point.draw();
            circle.draw();
            circle2.draw();
        }
        

    }
}
