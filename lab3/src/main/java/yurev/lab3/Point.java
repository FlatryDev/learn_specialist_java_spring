package yurev.lab3;

public class Point extends Shape {
	private Coords coords;

        public Point() {
            this(null);
        }
	
	public Point(String color) {
		this(color, null);
	}
	
	public Point(String color, Coords coords) {
		super(color);
		this.coords = coords;
                Scene.getScene().add(this);
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
