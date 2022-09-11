package yurev.lab3;

public class Shape {
	protected String color;
	
	public Shape(String color) {
		this.color = color;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	public void draw() {
		System.out.println("color - " + color);
	}
	
}
