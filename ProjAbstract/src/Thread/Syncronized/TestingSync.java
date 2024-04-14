package Thread.Syncronized;

public class TestingSync {
    public static void main(String[] args) {
        long st = System.currentTimeMillis();
        Counter counter = new Counter();
        UpdaterThread u1 = new UpdaterThread(counter);
        UpdaterThread u2 = new UpdaterThread(counter);

        try {

            u1.start();
            u2.start();

            u1.join();
            u2.join();

            //This below code does hel as proper multi threading is not in use
//            u1.start();
//            u1.join();
//
//            u2.start();
//            u2.join();
        }catch (InterruptedException e){
            System.out.println("Interrupted Exception : " + e.getMessage());
        }
        long et = System.currentTimeMillis();

        System.out.println("Final counter value : " + counter.getCount() + " and time taken : " + (et-st));
    }
}
