package in.ch100;

public class TestState {
    public static void main(String[] args) throws InterruptedException {

        ThreadState t1 = new ThreadState();
        System.out.println("Created the thread : " + t1.getState());
        t1.start();
        t1.join();
        System.out.println("Thread Finished : " + t1.getState());
    }
}
