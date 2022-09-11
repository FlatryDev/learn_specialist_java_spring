package yurev.lab2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("point")
@Lazy
@Scope("prototype")
public class Point extends Shape {
        @Autowired
        @Qualifier("coords")
	private Coords coords;
        
        @Autowired   
	public Point(@Value("#00FFCC") String color) {
		super(color);
	}
	
	public Point(String color, Coords coords) {
		super(color);
		this.coords = coords;
	}

	public Coords getCoords() {
		return coords;
	}

	public void setCoords(Coords coords) {
		this.coords = coords;
	}

	@Override 
	public void draw() {
		System.out.println("Point color - " + color + 
						 "; coords - " + coords.getX() + 
						 ":" + coords.getY()
						  );
	}
		
}
