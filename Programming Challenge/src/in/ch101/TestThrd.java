package in.ch101;

public class TestThrd {
    public static void main(String[] args) throws InterruptedException {
        PrntThread p1 = new PrntThread(1);
        PrntThread p2 = new PrntThread(2);
        PrntThread p3 = new PrntThread(3);
        p1.start();
        p1.join();
        p2.start();
        p2.join();
        p3.start();
    }
}
