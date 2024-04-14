package ExecutorService.Futures;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestingFutures {

    //Running Futures returns(task assigned to that thread task) to main method.
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(2);
        FetchName f1 = new FetchName("Tausif");
        FetchName f2 = new FetchName("Muskaan");
        FetchName f3 = new FetchName("Irshad");
        FetchName f4 = new FetchName("Nazish");

        Future<String> name1 = service.submit(f1);
        Future<String> name2 = service.submit(f2);
        Future<String> name3 = service.submit(f3);
        Future<String> name4 = service.submit(f4);

        System.out.println("Full Future Return is : " + name1.get()); //.get() waits the thread (i.e here main) from its called.
        System.out.println("Full Future Return is : " + name2.get());
        System.out.println("Full Future Return is : " + name3.get());
        System.out.println("Full Future Return is : " + name4.get());

        service.shutdown();
    }
}
