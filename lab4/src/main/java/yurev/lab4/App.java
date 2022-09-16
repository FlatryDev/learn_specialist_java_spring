package yurev.lab4;

import javax.sound.midi.SysexMessage;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import yurev.lab4.*;

public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CourseDAO courseDAO = context.getBean(CourseDAO.class);
        //for(Course c : courseDAO.findAll())
        //    System.out.println(c);
        
//        Course c = new Course();
//        c.setTitle("Spring");
//        c.setLength(40);
//        c.setDescription("Spring framework");
        
//        System.out.println("key="+c.getId());
//        courseDAO.insert(c);
//        System.out.println("key="+c.getId());
       
        System.out.println("--- Result findAll ---");
        
        for(Course cc : courseDAO.findAll())
            System.out.println(cc);
        
        System.out.println("--- Result findByTitle ---");
        
        for(Course cc : courseDAO.findByTitle("Spring"))
            System.out.println(cc);
        
        System.out.println("--- Result findById ---");
        
        Course c = courseDAO.findById(13);
        System.out.println(c);
        
//        
//        c.setTitle(c.getTitle() + " Changed");
//        courseDAO.update(c);
//        
//        courseDAO.delete(14);
//        
//        System.out.println("------");
//        
//        for(Course cc : courseDAO.findByTitle("Spring"))
//            System.out.println(cc);
        
        
        //System.out.printf("Курс: %s \n", courseDAO.findById(4));
        
        context.close();
    }
}
