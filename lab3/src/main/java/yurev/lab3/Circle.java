package yurev.lab3;

public class Circle extends Shape {
    private Coords center;
    private int r;

    public Circle() {
        this(null);
    }
       
        
    public Circle(String color) {
        this(color, null, 0);
    }

    public Circle(String color, Coords center, int r) {
        super(color);
        this.center = center;
        this.r = r;
        Scene.getScene().add(this);
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
