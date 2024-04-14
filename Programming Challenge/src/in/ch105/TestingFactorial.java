package in.ch105;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestingFactorial {
    public static void main(String[] args) {
        try (ExecutorService service = Executors.newFixedThreadPool(3)) {
            List<Future<Integer>> factList = new ArrayList<>();

            for (int i = 1; i <= 5; i++) {
                FactorialCal fc = new FactorialCal(i);
                factList.add(service.submit(fc));
            }
            for (Future<Integer> list : factList) {
                System.out.println("Result is :" + list.get() + " ");
            }
            service.shutdown();

            if(!service.awaitTermination(5, TimeUnit.SECONDS)){
                System.out.println("\n----Emergency Exit----");
                service.shutdownNow();
            }
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
