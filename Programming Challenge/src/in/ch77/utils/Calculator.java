package in.ch77.utils;

import in.ch77.geometry.Circle;
import in.ch77.geometry.Rectangle;

public class Calculator {
    public static void main(String[] args) {
        Circle c = new Circle(7.1);
        Rectangle r = new Rectangle(5,4);

        double cArea =  (2 * Math.PI *c.radius);
        int rArea = r.length * r.breadth;

        System.out.println("Area of Circle : " + cArea);
        System.out.println("Area of Rectangle : " + rArea);
    }
}
