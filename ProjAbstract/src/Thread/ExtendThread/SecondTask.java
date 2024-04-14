package Thread.ExtendThread;

public class SecondTask extends Thread{
    @Override
    public void run() {
        for(int i=1;i<=500;i++){
            System.out.printf("%d# ",i);
        }
        System.out.printf("\n %s # Task completed",Thread.currentThread().getName());
    }
}
