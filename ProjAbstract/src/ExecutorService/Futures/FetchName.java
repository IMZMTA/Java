package ExecutorService.Futures;

import java.util.concurrent.Callable;

public class FetchName implements Callable<String> {

    private final String name;

    public FetchName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String call() throws Exception {
        System.out.println("Getting Return for : " + name + " from server.");
        Thread.sleep(2000);
        return name + " Running Future ";
    }
}
