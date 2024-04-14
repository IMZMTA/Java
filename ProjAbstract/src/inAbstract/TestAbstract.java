package inAbstract;

public class TestAbstract {
    public static void main(String[] args) {
//        Vehicle veh = new Vehicle(2); //->cannot be created as vehicle is an abstract class
        Car c = new Car();
        c.makeStartSound();
        c.getSetGo();
        c.commute();
    }
}
