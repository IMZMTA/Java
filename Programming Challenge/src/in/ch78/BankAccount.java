package in.ch78;

class BankAccount {
    private String accountNum;
    private String accountName;
    private int accountbal;

    public BankAccount(String accountNum, String accountName) {
        this.accountNum = accountNum;
        this.accountName = accountName;
    }

    public void deposit(int money){
        if(money <= 0){
            System.out.println("Invalid Deposit");
        }else{
            this.accountbal +=money;
        }
    }
    public int withdraw(int money){
        if(money<=0){
            System.out.println("Invalid Withdraw");
        }else if(this.accountbal >= money){
            this.accountbal -=money;
        }else {
            money = this.accountbal;
            this.accountbal = 0;
        }
            return money;
    }
}