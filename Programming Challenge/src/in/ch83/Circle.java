package in.ch83;

public class Circle extends Shape{

    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double calculateArea() {
        return 2*Math.PI*Math.pow(radius,2);
    }
}
