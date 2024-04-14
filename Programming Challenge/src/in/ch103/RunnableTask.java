package in.ch103;

public class RunnableTask extends Thread{
    private int num=1;

    @Override
    public void run() {
        for(int i=1; i<=10;i++){
            System.out.print(num++ + " ");
        }
        System.out.println();
    }
}
