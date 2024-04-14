package ExceptionAndFileHandling;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to division calculator");
        System.out.print("Please enter your two number : ");
        try {
            int first = sc.nextInt();
            int second = sc.nextInt();

            int[] a = new int[5];
            System.out.println(a[2]);
            System.out.println(a[4]);
            int result = first / second;
            System.out.printf("Result is %d", result);
        }catch (ArithmeticException | NumberFormatException e){
            System.out.printf("Division by zero %s",e.getMessage());
        }catch (Exception e){
            System.out.printf("Exception occur %s", e.getMessage());
        }
        catch (Throwable th){
            System.out.printf("Throwable exception %s",th.getMessage());
            throw th;
        }
    }
}