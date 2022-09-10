package yurev;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Coords coord = ac.getBean("coord", Coords.class);
        Point point = ac.getBean("point",Point.class);
        Circle circle = ac.getBean("circle",Circle.class);
        Circle circle2 = ac.getBean("circle",Circle.class);
        circle2.setCenter(new Coords(77,88));
        point.draw();
        circle.draw();
        circle2.draw();
        
        ac.close();
    }
}
