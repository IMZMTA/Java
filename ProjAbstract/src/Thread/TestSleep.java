package Thread;

public class TestSleep {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Before Sleeping");
        Thread.sleep(4000); //(Static method )Makes the invoked or called thread sleep for given millisecond
        System.out.println("After sleeping");
    }
}
