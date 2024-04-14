package in.ch83;

public class Test {
    public static void main(String[] args) {
        Circle c = new Circle(7.7);
        Square s = new Square(25);
        System.out.println(s.calculateArea());
        System.out.println(c.calculateArea());
    }
}
