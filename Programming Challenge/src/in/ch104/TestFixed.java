package in.ch104;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestFixed {
    public static void main(String[] args) {
        try (ExecutorService service = Executors.newFixedThreadPool(5)) {
            for(int i=1; i<=10; i++) {

                FixedPool fp = new FixedPool();
                service.submit(fp);

            }
            service.shutdown();
        if(!service.awaitTermination(10, TimeUnit.SECONDS)){
            System.out.println("Emergency Shutdown");
            service.shutdownNow();
        }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
