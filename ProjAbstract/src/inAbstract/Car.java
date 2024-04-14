package inAbstract;

public class Car extends Vehicle{

    private int noOfDoors;
    public Car() {
        super(4);
    }

    @Override
    public void makeStartSound() {
        System.out.println("Vrhooom.....");
    }

    @Override
    public void getSetGo() {
        System.out.println("1->2->3 --> Go");
    }
}
