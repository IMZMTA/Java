package inPolymorph;

public class Child extends Parent{
    public void run(){
        super.start();
        System.out.println("I am child");
        super.start();
        System.out.println("Below Super or Immediate Parent class");
    }
}
