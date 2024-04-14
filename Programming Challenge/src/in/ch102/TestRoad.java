package in.ch102;

public class TestRoad {
    public static void main(String[] args) throws InterruptedException {

        for(int i=1; i<=5; i++) {
            TrafficThread red = new TrafficThread(Traffic.RED);
            TrafficThread yellow = new TrafficThread(Traffic.YELLOW);
            TrafficThread green = new TrafficThread(Traffic.GREEN);

            red.start();
            red.join();
            yellow.start();
            yellow.join();
            green.start();
            green.join();
        }
    }
}
