package in.ch101;

public class PrntThread extends Thread{
    private final int x;

    public PrntThread(int x) {
        this.x = x;
    }

    @Override
    public void run() {
        try {
            System.out.println(getName() + " Thread Started " + (x-1));
            sleep(2000);
            System.out.println(getName() + " Thread Ended " + (x-1));
        }catch (InterruptedException e){
            System.out.println("Interupted Exception : " + e.getMessage());
        }
    }
}
