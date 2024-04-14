package in.ch105;

import java.util.concurrent.Callable;

public class FactorialCal implements Callable<Integer> {

    private final int num;

    public FactorialCal(int num) {
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(2000);
        if(num <= 1){
            return 1;
        }
        int fact = 1;
        for(int i=2; i<=num;i++){
            fact *= i;
        }
        return fact;
    }
}
