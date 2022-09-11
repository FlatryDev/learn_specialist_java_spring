package yurev.lab2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("coords")
public class Coords {
	private int x,y;

	public Coords() {

	}
	
	public Coords(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}
            
        @Value("33")
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

        @Value("44")
	public void setY(int y) {
		this.y = y;
	}
	
	
}
