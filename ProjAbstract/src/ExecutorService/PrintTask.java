package ExecutorService;

public class PrintTask implements Runnable{

    private final char ch;

    public PrintTask(char ch) {
        this.ch = ch;
    }

    @Override
    public void run() {
        for(int i=1; i<=50; i++){
            System.out.printf("%d%c ",i,ch);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.printf("\n %s %c Task completed\n",Thread.currentThread().getName(),ch);
    }
}
