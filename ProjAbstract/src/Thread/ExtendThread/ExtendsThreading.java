package Thread.ExtendThread;

public class ExtendsThreading {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        //First Task
        FirstTask t1 = new FirstTask();
        //Second Task
        SecondTask t2 = new SecondTask();
        //Third Task
        ThirdTask t3 = new ThirdTask();

        t1.start();
        t2.start();
        t3.start();

        long endTime = System.currentTimeMillis();
        System.out.printf("\n%s Total time taken : %d\n",Thread.currentThread().getName(), (endTime - startTime));
    }
}
