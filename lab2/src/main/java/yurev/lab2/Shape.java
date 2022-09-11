package yurev.lab2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Shape {
	protected String color;
	
	public Shape(@Value("#00FFCC") String color) {
		this.color = color;
	}



	public String getColor() {
		return color;
	}


        //@Value("#00FF11")
	public void setColor(String color) {
		this.color = color;
	}



	public void draw() {
		System.out.println("color - " + color);
	}
	
}
