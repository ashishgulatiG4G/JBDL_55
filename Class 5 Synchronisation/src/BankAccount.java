public class BankAccount {

    private int accountNumber;

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public Double getBalance() {
        return this.balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    private Double balance;

    private String accountHolderName;

    public BankAccount(int accountNumber, String accountHolderName, Double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }


    public void depositMoney(Double amount) {
        synchronized (balance) {
            this.balance += amount;
        }
    }

    public void withdraw(Double amount) {
        synchronized (balance) {
            this.balance -= amount;
        }
    }






}
