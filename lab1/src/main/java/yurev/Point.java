package yurev;

public class Point extends Shape {
	private Coords coords;
	
	public Point(String color) {
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
