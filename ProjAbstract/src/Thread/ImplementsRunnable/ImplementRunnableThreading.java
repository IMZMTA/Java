package Thread.ImplementsRunnable;

public class ImplementRunnableThreading {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        //First Task
        PrintTask p1 = new PrintTask('*');
        //Second Task
        PrintTask p2 = new PrintTask('#');
        //Third Task
        PrintTask p3 = new PrintTask('$');

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        Thread t3 = new Thread(p3);

        System.out.print("\nTask *1 started");
        t1.start();
        t1.join(); //This method stops that thread(main) from where it is called until task of thread(t1) which is called is completed ->Like here main thread stops until t1 finished its task.
        System.out.print("\nTask #2 started");
        t2.start();
        System.out.print("\nTask $3 started");
        t3.start();
        t3.setPriority(10);

        long endTime = System.currentTimeMillis();
        System.out.printf("\n%s Total time taken : %d\n",Thread.currentThread().getName(), (endTime - startTime));
    }
}
