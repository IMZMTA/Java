package inPoly;

public class Child implements Parent {
    public void run(){
        System.out.println("I am child");
    }


    @Override
    public void start() {
        System.out.println("I am parents");
    }
}
