package in.ch103;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExec {
    public static void main(String[] args) {
        try (ExecutorService service = Executors.newSingleThreadExecutor()) {

            RunnableTask r1 = new RunnableTask();
            service.submit(r1);

//            service.shutdown(); //After try and resource it is optional to use i.e not mandatory
        }
    }
}