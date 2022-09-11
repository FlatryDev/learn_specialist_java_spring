package yurev.lab3;

import org.springframework.beans.factory.annotation.Value;

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

        @Value("0")
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

        @Value("0")
	public void setY(int y) {
		this.y = y;
	}

        public void draw() {
            System.out.println("Coords - " + getX() + ":" + getY());
        }
	
        
        
	
}
