package yurev.lab3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        try (
            AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(JavaConfig.class)
        ) {
            Coords coord = ac.getBean("coord", Coords.class);
            Point point = ac.getBean("point",Point.class);
            Circle circle = ac.getBean(Circle.class);
            Circle circle2 = ac.getBean(Circle.class);
            Scene scene = ac.getBean(Scene.class);
            circle2.setCenter(new Coords(77,88));
            
            coord.draw();
            point.draw();
            circle.draw();
            circle2.draw();
            System.out.println("=========================================");
            scene.draw();
            
        }
                
//        
//        
//        
//        
//        
//        
        
        //ac.close();
    }
}
