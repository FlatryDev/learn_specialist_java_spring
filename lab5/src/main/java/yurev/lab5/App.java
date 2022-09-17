package yurev.lab5;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import yurev.lab5.*;

public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CourseDAO courseDAO = context.getBean(CourseDAO.class);
       
        System.out.println("\n--- Result findAll ---");
        
        for(Course cc : courseDAO.findAll())
            System.out.println(cc);
        
        System.out.println("\n--- Result findByTitle ---");
        
        for(Course cc : courseDAO.findByTitle("Spring"))
            System.out.println(cc);
        
        System.out.println("\n--- Result findById ---");
        Course c = courseDAO.findById(13);
        System.out.println(c);
        
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Calendar cl = Calendar.getInstance();
        
        System.out.println("\n--- Update course ---");
        c.setTitle("Title changed " + df.format(cl.getTime()));
        courseDAO.update(c);
        c = courseDAO.findById(13);
        System.out.println(c);
        
        System.out.println("\n--- Insert course ---");       
        Course cNew = new Course();
        String nameNew = "New course " + df.format(cl.getTime());
        cNew.setTitle(nameNew);
        cNew.setLength(40);
        cNew.setDescription("Spring framework");
        courseDAO.insert(cNew);
        System.out.println(courseDAO.findById(cNew.getId()));
               
        System.out.println("\n--- Delete course ---");    
        courseDAO.delete(cNew.getId());
        boolean flDel = true;
        for(Course cc : courseDAO.findByTitle(nameNew)) {
        	System.out.println(cc);
        	flDel = false;
        }
        System.out.println((flDel)?"Элемент '"+nameNew+"' удален":"!!!ERROR. Элемент '"+nameNew+"' не удален");
            
      
        context.close();
    }
}
