package in.ch99;

public class PrintThread extends Thread{
    private final int x;

    public PrintThread(int x) {
        this.x = x;
    }

    @Override
    public void run() {
        for (int i=1;i<=10;i++) {
            System.out.println(i + " -> Hello from Thread " + x);
        }
    }
}
