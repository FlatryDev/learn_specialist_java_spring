package yurev.lab3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class JavaConfig {
    
    @Bean("coord")
    @Scope("prototype")
    @Lazy
    public Coords coords() {
        return new Coords();
    }
    
    @Bean
    @Scope("prototype")
    @Lazy
    public Point point() {
        Point result = new Point("#123456");
        result.setCoords(coords());
        return result;
    }
    
    @Bean
    @Scope("prototype")
    @Lazy
    public Circle circle() {
        return new Circle("#1200FF", new Coords(44, 555), 123);
    }
    
    @Bean
    public Scene scene() {
        System.out.println("Created scene");
        return Scene.getScene();
    }
    
}
