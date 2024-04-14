package in.ch102;

public class TrafficThread extends Thread{

    private final Traffic color;

    public TrafficThread(Traffic color) {
        this.color = color;
    }

    @Override
    public void run() {
        System.out.println(color + " active");
        try {
            Thread.sleep(color.getOnTimeInMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(color + " inactive now");
    }
}
