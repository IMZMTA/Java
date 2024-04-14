package in.ch100;

public class ThreadState extends Thread{

    /* if parents method(i.e. from where override) does not throw any exception or error child method(i.e. override) also cannot throw exception */
    @Override
    public void run() {
        try {
            Thread.sleep(4000);
            System.out.println("From inside run : " + getState());
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
