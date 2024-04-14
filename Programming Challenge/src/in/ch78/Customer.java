package in.ch78;

public class Customer {
    public static void main(String[] args) {

        BankAccount b1 = new BankAccount("12345","Nazish");

        b1.deposit(100);
        b1.deposit(200);
        System.out.println(b1.withdraw(300));
        b1.deposit(-8);
        b1.withdraw(0);
        b1.withdraw(20);

    }
}
