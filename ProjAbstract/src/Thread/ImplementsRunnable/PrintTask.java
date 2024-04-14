package Thread.ImplementsRunnable;

public class PrintTask implements Runnable{

    private final char ch;

    public PrintTask(char ch) {
        this.ch = ch;
    }

    @Override
    public void run() {
        for(int i=1; i<=100; i++){
            System.out.printf("%d%c ",i,ch);
        }
        System.out.printf("\n %s %c Task completed\n",Thread.currentThread().getName(),ch);
    }
}
