package in.ch84;

public class Eagle extends Bird{

    public Eagle() {
        super("I am Eagle");
    }

    @Override
    public void fly() {
        System.out.println("I can fly");
    }
}
