package in.ch99;

public class TestingThread {
    public static void main(String[] args) {
        PrintThread p1 = new PrintThread(1);
        PrintThread p2 = new PrintThread(2);

        p1.start();
        p2.start(); //p2.run start from main itself as p2.run does not create as new start thread
    }
}
