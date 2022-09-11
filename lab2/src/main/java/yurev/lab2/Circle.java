package yurev.lab2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("circle")
@Lazy
@Scope("prototype")
public class Circle extends Shape {
	
        //@Autowired
        //@Qualifier("coords")
        private Coords center;
	private int r;

	public Circle(String color) {
		super(color);
	}
	
        @Autowired
	public Circle(@Value("#1200FF") String color, Coords center, @Value("123") int r) {
		super(color);
		this.center = center;
		this.r = r;
	}
	
	public Coords getCenter() {
		return center;
	}
	public void setCenter(Coords center) {
		this.center = center;
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	
	@Override
	public void draw() {
		System.out.println("Circle color - " + color + 
				 "; coords - " + center.getX() + ":" + center.getY() +
				 "; radius - " + r
				  );
	}
	
}
