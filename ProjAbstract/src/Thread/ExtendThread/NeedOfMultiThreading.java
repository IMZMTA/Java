package Thread.ExtendThread;

public class NeedOfMultiThreading {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        //First Task
        for(int i=1; i<=500; i++){
            System.out.printf("%d* ",i);
        }
        //Second Task
        for(int i=1;i<=500;i++){
            System.out.printf("%d# ",i);
        }
        System.out.println("\n # Task completed");
        //Third Task
        for(int i=1;i<=500;i++){
            System.out.printf("%d- ",i);
        }
        System.out.println("\n - Task completed");
        //Fourth Task
        for(int i=1;i<=500;i++){
            System.out.printf("%d$ ",i);
        }
        System.out.println("\n $ Task completed");
        //Fifth Task
        long endTime = System.currentTimeMillis();
        System.out.printf("Total time taken : %d", (endTime - startTime));
    }
}
