package ExecutorService.SingleThread;

import Thread.ImplementsRunnable.PrintTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestingSingleThread {
    public static void main(String[] args) {
        try (ExecutorService service = Executors.newSingleThreadExecutor()) {
            PrintTask task1 = new PrintTask('@');
            PrintTask task2 = new PrintTask('=');
            PrintTask task3 = new PrintTask('%');

            service.submit(task1);
            service.submit(task2);
            service.submit(task3);

            service.shutdown();
        }
    }
}
