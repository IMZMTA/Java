package in.ch104;

public class FixedPool extends Thread{

    public int getRand(){
        double rand = Math.ceil(Math.random() *5000);
        return (int) rand;
    }

    @Override
    public void run() {
        System.out.printf("Started with thread : %s\n",getName());
        try {
            sleep(getRand());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Ended with thread : %s\n",getName());
    }
}
