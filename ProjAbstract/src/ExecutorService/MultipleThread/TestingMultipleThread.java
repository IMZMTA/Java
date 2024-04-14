package ExecutorService.MultipleThread;

import Thread.ImplementsRunnable.PrintTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestingMultipleThread {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);

        PrintTask task1 = new PrintTask('@');
        PrintTask task2 = new PrintTask('=');
        PrintTask task3 = new PrintTask('%');
        PrintTask task4 = new PrintTask('!');

        service.submit(task1);
        service.submit(task2);
        service.submit(task3);
        service.submit(task4);

        service.shutdown();

    }
}
