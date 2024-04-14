package in.ch83;

public class Square extends Shape {

    private final int length;

    public Square(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public double calculateArea() {
        return Math.pow(length,2);
    }
}
