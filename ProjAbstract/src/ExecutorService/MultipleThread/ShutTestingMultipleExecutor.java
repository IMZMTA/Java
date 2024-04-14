package ExecutorService.MultipleThread;

import ExecutorService.PrintTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ShutTestingMultipleExecutor {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);

        for(int i=1;i<=10;i++) {
            PrintTask task1 = new PrintTask((char)(i+65));
            service.submit(task1);
        }


        service.shutdown();
        System.out.println("\n--------****Before****--------");

        //As executors service waits and main method is already ended or shutown
        //Many of applications kills the thread after main is completed or shutdownn or ended
        //So to complete all thread in all app main should wait
        //Main waits by below method (i.e //awaitTermination method)

        if(!service.awaitTermination(5, TimeUnit.SECONDS)){
            System.out.println("\n--------****After****--------");
            service.shutdownNow();
        };
    }
}
